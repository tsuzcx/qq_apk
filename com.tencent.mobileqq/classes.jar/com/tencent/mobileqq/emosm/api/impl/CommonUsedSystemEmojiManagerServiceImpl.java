package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x13Rsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class CommonUsedSystemEmojiManagerServiceImpl
  implements ICommonUsedSystemEmojiManagerService
{
  public static final int[] DEFAULT_IDS = { 128525, 13, 128532, 5, 6, 14, 3, 20, 109, 28, 127874, 63, 9, 1, 49, 22, 128557, 11, 128169, 128163, 98, 27, 35, 2 };
  private static final HashMap<Integer, Integer> EMOJI_CONVERT_MAP = new HashMap(5);
  public static final String TAG = "CommonUsedSystemEmojiManager";
  private AppInterface app;
  private boolean hasWhiteList;
  public List<EmosmPb.SmallYellowItem> itemInfos = new ArrayList();
  public Object lock = new Object();
  
  static
  {
    EMOJI_CONVERT_MAP.put(Integer.valueOf(217), Integer.valueOf(0));
    EMOJI_CONVERT_MAP.put(Integer.valueOf(223), Integer.valueOf(3));
    EMOJI_CONVERT_MAP.put(Integer.valueOf(168), Integer.valueOf(8));
    EMOJI_CONVERT_MAP.put(Integer.valueOf(219), Integer.valueOf(10));
    EMOJI_CONVERT_MAP.put(Integer.valueOf(212), Integer.valueOf(12));
  }
  
  private void printAfterSortLog(List<EmosmPb.SmallYellowItem> paramList)
  {
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder("mergeAndSortSystemEmojiInfo:");
      localStringBuilder1.append("after sort ,mergeList:");
      int i = 0;
      while (i < paramList.size())
      {
        EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramList.get(i);
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("type = ");
        localStringBuilder2.append(localSmallYellowItem.type.get());
        localStringBuilder1.append(localStringBuilder2.toString());
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(";id = ");
        localStringBuilder2.append(localSmallYellowItem.id.get());
        localStringBuilder1.append(localStringBuilder2.toString());
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(";ts = ");
        localStringBuilder2.append(localSmallYellowItem.ts.get());
        localStringBuilder1.append(localStringBuilder2.toString());
        i += 1;
      }
      paramList = new StringBuilder();
      paramList.append("mergeAndSortSystemEmojiInfo merge:");
      paramList.append(localStringBuilder1.toString());
      QLog.d("CommonUsedSystemEmojiManager", 2, paramList.toString());
    }
  }
  
  private void printBeforeSortLog(List<EmosmPb.SmallYellowItem> paramList1, List<EmosmPb.SmallYellowItem> paramList2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder("mergeAndSortSystemEmojiInfo:");
      int j = 0;
      int i;
      Object localObject;
      if (paramList1 != null)
      {
        localStringBuilder1.append("befor sort list1 : ");
        i = 0;
        while (i < paramList1.size())
        {
          localObject = (EmosmPb.SmallYellowItem)paramList1.get(i);
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("type = ");
          localStringBuilder2.append(((EmosmPb.SmallYellowItem)localObject).type.get());
          localStringBuilder1.append(localStringBuilder2.toString());
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(";id = ");
          localStringBuilder2.append(((EmosmPb.SmallYellowItem)localObject).id.get());
          localStringBuilder1.append(localStringBuilder2.toString());
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(";ts = ");
          localStringBuilder2.append(((EmosmPb.SmallYellowItem)localObject).ts.get());
          localStringBuilder1.append(localStringBuilder2.toString());
          i += 1;
        }
      }
      if (paramList2 != null)
      {
        localStringBuilder1.append("befor sort list2 : ");
        i = j;
        while (i < paramList2.size())
        {
          paramList1 = (EmosmPb.SmallYellowItem)paramList2.get(i);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("type = ");
          ((StringBuilder)localObject).append(paramList1.type.get());
          localStringBuilder1.append(((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(";id = ");
          ((StringBuilder)localObject).append(paramList1.id.get());
          localStringBuilder1.append(((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(";ts = ");
          ((StringBuilder)localObject).append(paramList1.ts.get());
          localStringBuilder1.append(((StringBuilder)localObject).toString());
          i += 1;
        }
      }
      paramList1 = new StringBuilder();
      paramList1.append("mergeAndSortSystemEmojiInfo merge:");
      paramList1.append(localStringBuilder1.toString());
      QLog.d("CommonUsedSystemEmojiManager", 2, paramList1.toString());
    }
  }
  
  private void saveMergeInfoToFile(List<EmosmPb.SmallYellowItem> paramList)
  {
    synchronized (this.lock)
    {
      File localFile = MobileQQ.getContext().getFilesDir();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("commonusedSystemEmojiInfoFile_v3_");
      ((StringBuilder)localObject2).append(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
      localFile = new File(localFile, ((StringBuilder)localObject2).toString());
      localObject2 = new EmosmPb.SubCmd0x13Rsp();
      ((EmosmPb.SubCmd0x13Rsp)localObject2).itemlist.set(paramList);
      FileUtils.pushData2File(localFile.getAbsolutePath(), ((EmosmPb.SubCmd0x13Rsp)localObject2).toByteArray(), false);
      return;
    }
  }
  
  public void copySystemEmojiFileToFileV2(File paramFile1, File paramFile2)
  {
    int i;
    label198:
    synchronized (this.lock)
    {
      Object localObject2 = FileUtils.fileToBytes(paramFile1);
      if (localObject2 == null)
      {
        QLog.e("CommonUsedSystemEmojiManager", 1, "Can not translate pb file to byte");
        return;
      }
      paramFile1 = new EmosmPb.SubCmd0x13Rsp();
      try
      {
        paramFile1.mergeFrom((byte[])localObject2);
        ??? = paramFile1.itemlist.get();
        localObject2 = ((List)???).iterator();
        EmosmPb.SmallYellowItem localSmallYellowItem;
        do
        {
          boolean bool = ((Iterator)localObject2).hasNext();
          i = 0;
          if (!bool) {
            break;
          }
          localSmallYellowItem = (EmosmPb.SmallYellowItem)((Iterator)localObject2).next();
        } while (i >= EmotcationConstants.REPLACE_EMOJIS.length);
        if (localSmallYellowItem.id.get() == EmotcationConstants.REPLACE_EMOJIS[i])
        {
          ((Iterator)localObject2).remove();
          break label198;
          paramFile1.itemlist.set((List)???);
          FileUtils.pushData2File(paramFile2.getAbsolutePath(), paramFile1.toByteArray(), false);
          return;
        }
      }
      catch (Exception paramFile1)
      {
        paramFile2 = new StringBuilder();
        paramFile2.append("getLocalSystemEmojiInfoFromFile mergeFromBody exception e = ");
        paramFile2.append(paramFile1.getMessage());
        QLog.e("CommonUsedSystemEmojiManager", 1, paramFile2.toString());
        return;
      }
    }
  }
  
  public void filterAbnormalData(List<EmosmPb.SmallYellowItem> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = (EmosmPb.SmallYellowItem)paramList.get(i);
      int j = ((EmosmPb.SmallYellowItem)localObject).type.get();
      int m = ((EmosmPb.SmallYellowItem)localObject).id.get();
      int k;
      if (j == 1)
      {
        k = QQSysFaceUtil.convertToLocal(m);
        if (k != -1)
        {
          j = k;
          if (k == 250) {
            j = 10;
          }
          if (QQSysFaceUtil.isValidFaceId(j))
          {
            ((EmosmPb.SmallYellowItem)localObject).id.set(j);
          }
          else
          {
            localArrayList.add(localObject);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("updateItemInfo system id overflow index = ");
            ((StringBuilder)localObject).append(m);
            ((StringBuilder)localObject).append(";emId = ");
            ((StringBuilder)localObject).append(j);
            QLog.e("CommonUsedSystemEmojiManager", 1, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          localArrayList.add(localObject);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateItemInfo system id overflow index = ");
          ((StringBuilder)localObject).append(m);
          QLog.e("CommonUsedSystemEmojiManager", 1, ((StringBuilder)localObject).toString());
        }
      }
      else if (j == 2)
      {
        k = QQEmojiUtil.getEmojiLocalId(m);
        j = k;
        if (EMOJI_CONVERT_MAP.containsKey(Integer.valueOf(k)))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateItemInfo before EMOTIONPANEL_EMOJI_MAP index = ");
          localStringBuilder.append(k);
          QLog.d("CommonUsedSystemEmojiManager", 2, localStringBuilder.toString());
          j = ((Integer)EMOJI_CONVERT_MAP.get(Integer.valueOf(k))).intValue();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateItemInfo after EMOTIONPANEL_EMOJI_MAP index = ");
          localStringBuilder.append(j);
          QLog.d("CommonUsedSystemEmojiManager", 2, localStringBuilder.toString());
        }
        if (j < 0)
        {
          localArrayList.add(localObject);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateItemInfo emoji id overflow index = ");
          ((StringBuilder)localObject).append(m);
          ((StringBuilder)localObject).append(";localIndex = ");
          ((StringBuilder)localObject).append(j);
          QLog.e("CommonUsedSystemEmojiManager", 1, ((StringBuilder)localObject).toString());
        }
        else
        {
          ((EmosmPb.SmallYellowItem)localObject).id.set(j);
        }
      }
      i += 1;
    }
    if (localArrayList.size() > 0) {
      paramList.removeAll(localArrayList);
    }
  }
  
  public List<EmosmPb.SmallYellowItem> getCacheInfo()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "getCacheInfo");
    }
    Object localObject1 = this.itemInfos;
    if ((localObject1 != null) && (((List)localObject1).size() >= 1))
    {
      localObject1 = new ArrayList();
      try
      {
        Iterator localIterator = this.itemInfos.iterator();
        while (localIterator.hasNext()) {
          ((List)localObject1).add((EmosmPb.SmallYellowItem)localIterator.next());
        }
        return localObject1;
      }
      finally {}
    }
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "getCacheInfo is null");
    }
    return null;
  }
  
  public List<EmosmPb.SmallYellowItem> getCommonUsedSystemEmojiInfo()
  {
    Object localObject1 = this.itemInfos;
    Object localObject3;
    Object localObject4;
    if ((localObject1 != null) && (((List)localObject1).size() >= 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CommonUsedSystemEmojiManager", 2, "getCommonUsedSystemEmojiInfo ");
      }
      localObject1 = getCacheInfo();
      if ((!this.hasWhiteList) && (localObject1 != null))
      {
        localObject3 = ((List)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (EmosmPb.SmallYellowItem)((Iterator)localObject3).next();
          if (QQSysAndEmojiResMgr.getInstance().getResImpl(((EmosmPb.SmallYellowItem)localObject4).type.get()).checkEmoticonShouldHide(((EmosmPb.SmallYellowItem)localObject4).id.get())) {
            ((Iterator)localObject3).remove();
          }
        }
      }
      return localObject1;
    }
    QLog.e("CommonUsedSystemEmojiManager", 1, "getCommonUsedSystemEmojiInfo  useDefaultinfo");
    updateCacheFromFile();
    localObject1 = new ArrayList();
    int i = 0;
    while (i < DEFAULT_IDS.length)
    {
      localObject3 = new EmosmPb.SmallYellowItem();
      int j = DEFAULT_IDS[i];
      int k;
      if (j > QQSysFaceUtil.maxServerId())
      {
        ((EmosmPb.SmallYellowItem)localObject3).type.set(2);
        k = QQEmojiUtil.getEmojiLocalId(j);
        j = k;
        if (EMOJI_CONVERT_MAP.containsKey(Integer.valueOf(k)))
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("getCommonUsedSystemEmojiInfo dedault before EMOTIONPANEL_EMOJI_MAP index = ");
          ((StringBuilder)localObject4).append(k);
          QLog.d("CommonUsedSystemEmojiManager", 2, ((StringBuilder)localObject4).toString());
          j = ((Integer)EMOJI_CONVERT_MAP.get(Integer.valueOf(k))).intValue();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("getCommonUsedSystemEmojiInfo dedault after EMOTIONPANEL_EMOJI_MAP index = ");
          ((StringBuilder)localObject4).append(j);
          QLog.d("CommonUsedSystemEmojiManager", 2, ((StringBuilder)localObject4).toString());
        }
        ((EmosmPb.SmallYellowItem)localObject3).id.set(j);
      }
      else
      {
        ((EmosmPb.SmallYellowItem)localObject3).type.set(1);
        k = QQSysFaceUtil.convertToLocal(j);
        j = k;
        if (k == 250) {
          j = 10;
        }
        ((EmosmPb.SmallYellowItem)localObject3).id.set(j);
      }
      if (QQSysAndEmojiResMgr.getInstance().getResImpl(((EmosmPb.SmallYellowItem)localObject3).type.get()).checkEmoticonShouldHide(((EmosmPb.SmallYellowItem)localObject3).id.get()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CommonUsedSystemEmojiManager", 2, new Object[] { "emo should be hided:", Integer.valueOf(((EmosmPb.SmallYellowItem)localObject3).id.get()), " ,type:", Integer.valueOf(((EmosmPb.SmallYellowItem)localObject3).type.get()) });
        }
      }
      else
      {
        ((EmosmPb.SmallYellowItem)localObject3).ts.set(0L);
        ((ArrayList)localObject1).add(localObject3);
      }
      i += 1;
    }
    try
    {
      this.itemInfos = ((List)localObject1);
      return getCacheInfo();
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public List<EmosmPb.SmallYellowItem> getLocalSystemEmojiInfoFromFile()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "getLocalSystemEmojiInfoFromFile");
    }
    int j;
    int m;
    int i;
    label680:
    label829:
    label846:
    label853:
    synchronized (this.lock)
    {
      Object localObject3 = MobileQQ.getContext().getFilesDir();
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("commonusedSystemEmojiInfoFile_v3_");
      ((StringBuilder)localObject5).append(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
      localObject3 = new File((File)localObject3, ((StringBuilder)localObject5).toString());
      if (!((File)localObject3).exists())
      {
        QLog.d("CommonUsedSystemEmojiManager", 2, "getLocalSystemEmojiInfoFromFile file not exists");
        return null;
      }
      localObject3 = FileUtils.fileToBytes((File)localObject3);
      if (localObject3 == null)
      {
        QLog.e("CommonUsedSystemEmojiManager", 1, "Can not translate pb file to byte");
        return null;
      }
      ??? = new EmosmPb.SubCmd0x13Rsp();
      try
      {
        ((EmosmPb.SubCmd0x13Rsp)???).mergeFrom((byte[])localObject3);
        localObject3 = ((EmosmPb.SubCmd0x13Rsp)???).itemlist.get();
        localObject5 = new ArrayList();
        ??? = new ArrayList();
        int k = 0;
        Object localObject7;
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          j = 0;
          if (j < ((List)localObject3).size())
          {
            localObject7 = (EmosmPb.SmallYellowItem)((List)localObject3).get(j);
            localObject6 = new EmosmPb.SmallYellowItem();
            ((EmosmPb.SmallYellowItem)localObject6).ts.set(((EmosmPb.SmallYellowItem)localObject7).ts.get());
            ((EmosmPb.SmallYellowItem)localObject6).type.set(((EmosmPb.SmallYellowItem)localObject7).type.get());
            int n = ((EmosmPb.SmallYellowItem)localObject7).type.get();
            m = ((EmosmPb.SmallYellowItem)localObject7).id.get();
            if (n == 1)
            {
              if (QQSysFaceUtil.isValidFaceId(m)) {
                break label829;
              }
              localObject6 = new StringBuilder();
              ((StringBuilder)localObject6).append("getLocalSystemEmojiInfoFromFile type = system, id error, id = ");
              ((StringBuilder)localObject6).append(m);
              QLog.e("CommonUsedSystemEmojiManager", 1, ((StringBuilder)localObject6).toString());
              break label846;
            }
            i = m;
            if (n == 2)
            {
              if (!QQEmojiUtil.isValidEmojiId(m))
              {
                localObject6 = new StringBuilder();
                ((StringBuilder)localObject6).append("getLocalSystemEmojiInfoFromFile type = emoji, id error, id = ");
                ((StringBuilder)localObject6).append(m);
                QLog.e("CommonUsedSystemEmojiManager", 1, ((StringBuilder)localObject6).toString());
                break label846;
              }
              i = m;
              if (EMOJI_CONVERT_MAP.containsKey(Integer.valueOf(m)))
              {
                localObject7 = new StringBuilder();
                ((StringBuilder)localObject7).append("getLocalSystemEmojiInfoFromFile before EMOTIONPANEL_EMOJI_MAP index = ");
                ((StringBuilder)localObject7).append(m);
                QLog.d("CommonUsedSystemEmojiManager", 2, ((StringBuilder)localObject7).toString());
                i = ((Integer)EMOJI_CONVERT_MAP.get(Integer.valueOf(m))).intValue();
                localObject7 = new StringBuilder();
                ((StringBuilder)localObject7).append("getLocalSystemEmojiInfoFromFile after EMOTIONPANEL_EMOJI_MAP index = ");
                ((StringBuilder)localObject7).append(i);
                QLog.d("CommonUsedSystemEmojiManager", 2, ((StringBuilder)localObject7).toString());
              }
            }
            ((EmosmPb.SmallYellowItem)localObject6).id.set(i);
            ((List)localObject5).add(localObject6);
            break label846;
          }
        }
        Object localObject6 = getCacheInfo();
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          i = k;
          if (i < ((List)localObject3).size())
          {
            localObject7 = (EmosmPb.SmallYellowItem)((List)localObject3).get(i);
            k = ((EmosmPb.SmallYellowItem)localObject7).type.get();
            j = ((EmosmPb.SmallYellowItem)localObject7).id.get();
            if (k == 1)
            {
              k = QQSysFaceUtil.convertToServer(j);
              if (k >= 0)
              {
                ((EmosmPb.SmallYellowItem)localObject7).id.set(k);
              }
              else
              {
                localObject7 = new StringBuilder();
                ((StringBuilder)localObject7).append("getLocalSystemEmojiInfoFromFile system error localId = ");
                ((StringBuilder)localObject7).append(j);
                QLog.e("CommonUsedSystemEmojiManager", 1, ((StringBuilder)localObject7).toString());
                break label853;
              }
            }
            else
            {
              k = QQEmojiUtil.getEmojiUnicode(j);
              if (k == -1) {
                break label680;
              }
              ((EmosmPb.SmallYellowItem)localObject7).id.set(k);
            }
            ((List)???).add(localObject7);
            break label853;
            localObject7 = new StringBuilder();
            ((StringBuilder)localObject7).append("getLocalSystemEmojiInfoFromFile emoji error localId = ");
            ((StringBuilder)localObject7).append(j);
            QLog.e("CommonUsedSystemEmojiManager", 1, ((StringBuilder)localObject7).toString());
            break label853;
          }
        }
        localObject3 = mergeAndSortSystemEmojiInfo((List)localObject5, (List)localObject6);
        localObject5 = getPaddedData((List)localObject3);
        if (localObject5 != null) {
          ((List)localObject3).addAll((Collection)localObject5);
        }
        try
        {
          this.itemInfos = ((List)localObject3);
          return ???;
        }
        finally {}
        localObject4 = finally;
      }
      catch (Exception localException)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getLocalSystemEmojiInfoFromFile mergeFromBody exception e = ");
        ((StringBuilder)localObject3).append(localException.getMessage());
        QLog.e("CommonUsedSystemEmojiManager", 1, ((StringBuilder)localObject3).toString());
        return null;
      }
    }
  }
  
  public List<EmosmPb.SmallYellowItem> getPaddedData(List<EmosmPb.SmallYellowItem> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    paramList = null;
    if (((List)localObject).size() < 21)
    {
      int i = ((List)localObject).size();
      ArrayList localArrayList = new ArrayList();
      paramList = localArrayList;
      if (21 - i > 0)
      {
        int k = 0;
        for (;;)
        {
          int[] arrayOfInt = DEFAULT_IDS;
          paramList = localArrayList;
          if (k >= arrayOfInt.length) {
            break;
          }
          i = arrayOfInt[k];
          int j = QQSysFaceUtil.maxServerId();
          int n = 1;
          int m;
          if (i < j)
          {
            j = QQSysFaceUtil.convertToLocal(i);
            if (j == 250)
            {
              i = 1;
              j = 10;
            }
            else
            {
              i = 1;
            }
          }
          else
          {
            j = QQEmojiUtil.getEmojiLocalId(i);
            i = j;
            if (EMOJI_CONVERT_MAP.containsKey(Integer.valueOf(j)))
            {
              paramList = new StringBuilder();
              paramList.append("paddedData dedault before EMOTIONPANEL_EMOJI_MAP index = ");
              paramList.append(j);
              QLog.d("CommonUsedSystemEmojiManager", 2, paramList.toString());
              i = ((Integer)EMOJI_CONVERT_MAP.get(Integer.valueOf(j))).intValue();
              paramList = new StringBuilder();
              paramList.append("paddedData dedault after EMOTIONPANEL_EMOJI_MAP index = ");
              paramList.append(i);
              QLog.d("CommonUsedSystemEmojiManager", 2, paramList.toString());
            }
            m = 2;
            j = i;
            i = m;
          }
          if (QQSysAndEmojiResMgr.getInstance().getResImpl(i).checkEmoticonShouldHide(j))
          {
            if (QLog.isColorLevel()) {
              QLog.d("CommonUsedSystemEmojiManager", 2, new Object[] { "emo should be hided:", Integer.valueOf(j), " ,type:", Integer.valueOf(i) });
            }
          }
          else
          {
            m = 0;
            while (m < ((List)localObject).size())
            {
              paramList = (EmosmPb.SmallYellowItem)((List)localObject).get(m);
              int i1 = paramList.type.get();
              int i2 = paramList.id.get();
              if ((i1 == i) && (i2 == j))
              {
                m = n;
                break label364;
              }
              m += 1;
            }
            m = 0;
            label364:
            if (m == 0)
            {
              paramList = new EmosmPb.SmallYellowItem();
              paramList.type.set(i);
              paramList.id.set(j);
              paramList.ts.set(0L);
              localArrayList.add(paramList);
            }
          }
          k += 1;
        }
      }
    }
    return paramList;
  }
  
  public List<EmosmPb.SmallYellowItem> mergeAndSortSystemEmojiInfo(List<EmosmPb.SmallYellowItem> paramList1, List<EmosmPb.SmallYellowItem> paramList2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "mergeAndSortSystemEmojiInfo");
    }
    Object localObject1 = null;
    if ((paramList1 == null) && (paramList2 == null))
    {
      QLog.e("CommonUsedSystemEmojiManager", 1, "mergeAndSortSystemEmojiInfo list IS null");
      return null;
    }
    if (paramList1 == null)
    {
      QLog.e("CommonUsedSystemEmojiManager", 1, "mergeAndSortSystemEmojiInfo  list1 = NULL");
      localObject1 = paramList2;
    }
    if (paramList2 == null)
    {
      QLog.e("CommonUsedSystemEmojiManager", 1, "mergeAndSortSystemEmojiInfo  list2 = NULL");
      localObject1 = paramList1;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      paramList1.addAll(paramList2);
      localObject2 = paramList1;
    }
    printBeforeSortLog(paramList1, paramList2);
    Collections.sort((List)localObject2, new CommonUsedSystemEmojiManagerServiceImpl.2(this));
    printAfterSortLog((List)localObject2);
    paramList1 = new HashSet();
    paramList2 = ((List)localObject2).iterator();
    while (paramList2.hasNext())
    {
      localObject1 = (EmosmPb.SmallYellowItem)paramList2.next();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((EmosmPb.SmallYellowItem)localObject1).type.get());
      ((StringBuilder)localObject3).append("-");
      ((StringBuilder)localObject3).append(((EmosmPb.SmallYellowItem)localObject1).id.get());
      localObject3 = ((StringBuilder)localObject3).toString();
      if ((!paramList1.contains(localObject3)) && (!QQSysAndEmojiResMgr.getInstance().getResImpl(((EmosmPb.SmallYellowItem)localObject1).type.get()).checkEmoticonShouldHide(((EmosmPb.SmallYellowItem)localObject1).id.get()))) {
        paramList1.add(localObject3);
      } else {
        paramList2.remove();
      }
    }
    printAfterSortLog((List)localObject2);
    return localObject2;
  }
  
  public List<EmosmPb.SmallYellowItem> mergeList(List<EmosmPb.SmallYellowItem> paramList)
  {
    new ArrayList();
    Object localObject = this.itemInfos;
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      paramList = mergeAndSortSystemEmojiInfo(paramList, getCacheInfo());
    } else {
      paramList = mergeAndSortSystemEmojiInfo(null, paramList);
    }
    int j = paramList.size();
    int i = 21;
    if (j > 21)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("before remove size = ");
        ((StringBuilder)localObject).append(paramList.size());
        QLog.d("CommonUsedSystemEmojiManager", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new ArrayList();
      while (i < paramList.size())
      {
        ((List)localObject).add(paramList.get(i));
        i += 1;
      }
      paramList.removeAll((Collection)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("after remove size = ");
        ((StringBuilder)localObject).append(paramList.size());
        QLog.d("CommonUsedSystemEmojiManager", 2, ((StringBuilder)localObject).toString());
      }
    }
    localObject = getPaddedData(paramList);
    if (localObject != null) {
      paramList.addAll((Collection)localObject);
    }
    return paramList;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = ((AppInterface)paramAppRuntime);
  }
  
  public void onDestroy()
  {
    try
    {
      if (this.itemInfos != null)
      {
        this.itemInfos.clear();
        this.itemInfos = null;
      }
      return;
    }
    finally {}
  }
  
  public void saveSystemEmojiInfoToCahce(EmosmPb.SmallYellowItem paramSmallYellowItem)
  {
    if (paramSmallYellowItem == null)
    {
      QLog.e("CommonUsedSystemEmojiManager", 1, "saveSystemEmojiInfoToCahce info = null");
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveSystemEmojiInfoToCahce id = ");
      ((StringBuilder)localObject).append(paramSmallYellowItem.id.get());
      ((StringBuilder)localObject).append(";type = ");
      ((StringBuilder)localObject).append(paramSmallYellowItem.type.get());
      ((StringBuilder)localObject).append(";ts = ");
      ((StringBuilder)localObject).append(paramSmallYellowItem.ts.get());
      QLog.d("CommonUsedSystemEmojiManager", 2, ((StringBuilder)localObject).toString());
    }
    int m = paramSmallYellowItem.type.get();
    int n = paramSmallYellowItem.id.get();
    try
    {
      if (this.itemInfos == null) {
        break label375;
      }
      k = -1;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        int k;
        int i;
        int j;
        StringBuilder localStringBuilder;
        for (;;)
        {
          throw paramSmallYellowItem;
        }
        i += 1;
      }
    }
    j = k;
    if (i < this.itemInfos.size())
    {
      localObject = (EmosmPb.SmallYellowItem)this.itemInfos.get(i);
      if ((((EmosmPb.SmallYellowItem)localObject).type.get() != m) || (((EmosmPb.SmallYellowItem)localObject).id.get() != n)) {
        break label411;
      }
      j = i;
    }
    Object localObject = null;
    if (j >= 0) {
      localObject = (EmosmPb.SmallYellowItem)this.itemInfos.remove(j);
    } else if (this.itemInfos.size() >= 21) {
      localObject = (EmosmPb.SmallYellowItem)this.itemInfos.remove(this.itemInfos.size() - 1);
    }
    if ((QLog.isColorLevel()) && (localObject != null))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveSystemEmojiInfoToCahce removeInfo : type =");
      localStringBuilder.append(((EmosmPb.SmallYellowItem)localObject).type.get());
      localStringBuilder.append(";id = ");
      localStringBuilder.append(((EmosmPb.SmallYellowItem)localObject).id.get());
      localStringBuilder.append(";ts = ");
      localStringBuilder.append(((EmosmPb.SmallYellowItem)localObject).ts.get());
      QLog.d("CommonUsedSystemEmojiManager", 2, localStringBuilder.toString());
    }
    this.itemInfos.add(0, paramSmallYellowItem);
    break label397;
    label375:
    this.itemInfos = new ArrayList();
    this.itemInfos.add(paramSmallYellowItem);
    label397:
  }
  
  public void saveSystemEmojiInfoToFile()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "saveSystemEmojiInfoToFile");
    }
    ThreadManager.getFileThreadHandler().post(new CommonUsedSystemEmojiManagerServiceImpl.3(this));
  }
  
  public void updateCacheFromFile()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "updateCacheFromFile");
    }
    ThreadManager.getFileThreadHandler().post(new CommonUsedSystemEmojiManagerServiceImpl.1(this));
  }
  
  public void updateItemInfo(List<EmosmPb.SmallYellowItem> paramList)
  {
    if (paramList == null)
    {
      QLog.e("CommonUsedSystemEmojiManager", 1, "updateItemInfo info = null");
      return;
    }
    Object localObject = this.app;
    int i = 0;
    this.hasWhiteList = SystemEmoticonInfo.parseWhiteList((AppRuntime)localObject, false);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("updateItemInfo backList size = ");
      ((StringBuilder)localObject).append(paramList.size());
      if (paramList != null)
      {
        ((StringBuilder)localObject).append(", before convert: ");
        while (i < paramList.size())
        {
          EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramList.get(i);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("type = ");
          localStringBuilder.append(localSmallYellowItem.type.get());
          ((StringBuilder)localObject).append(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(";id = ");
          localStringBuilder.append(localSmallYellowItem.id.get());
          ((StringBuilder)localObject).append(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(";ts = ");
          localStringBuilder.append(localSmallYellowItem.ts.get());
          ((StringBuilder)localObject).append(localStringBuilder.toString());
          i += 1;
        }
      }
      QLog.d("CommonUsedSystemEmojiManager", 2, ((StringBuilder)localObject).toString());
    }
    filterAbnormalData(paramList);
    if (paramList.size() < 1)
    {
      QLog.e("CommonUsedSystemEmojiManager", 1, "updateItemInfo itemInfos size < 1");
      return;
    }
    paramList = mergeList(paramList);
    try
    {
      this.itemInfos = paramList;
      saveMergeInfoToFile(paramList);
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.CommonUsedSystemEmojiManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */