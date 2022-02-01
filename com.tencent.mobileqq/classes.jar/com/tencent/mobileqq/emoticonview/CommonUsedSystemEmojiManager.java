package com.tencent.mobileqq.emoticonview;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x13Rsp;
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
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class CommonUsedSystemEmojiManager
  implements Manager
{
  public static final String COMMONUSED_SYSTEM_EMOJI_FILE_NAME_ = "commonusedSystemEmojiInfoFile_v2_";
  public static final String COMMONUSED_SYSTEM_EMOJI_FILE_NAME_V2_ = "commonusedSystemEmojiInfoFile_v3_";
  private static final HashMap<Integer, Integer> EMOJI_CONVERT_MAP = new HashMap(5);
  public static final long EMOJI_UPDATE_TIME_660 = 1476413876L;
  public static final String LAST_REQUEST_TIME = "lastRequestTime";
  public static final String SP_FILE_NAME = "commonUsedSystemEmoji_sp";
  public static final String TAG = "CommonUsedSystemEmojiManager";
  public static final int TYPE_EMOJI = 2;
  public static final int TYPE_SYSTEM = 1;
  public int[] DEFAULT_IDS = { 128525, 13, 128532, 5, 6, 14, 3, 20, 109, 28, 127874, 63, 9, 1, 49, 22, 128557, 11, 128169, 128163, 98, 27, 35, 2 };
  private QQAppInterface app;
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
  
  public CommonUsedSystemEmojiManager(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private void printAfterSortLog(List<EmosmPb.SmallYellowItem> paramList)
  {
    if (paramList == null) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("mergeAndSortSystemEmojiInfo:");
    localStringBuilder.append("after sort ,mergeList:");
    int i = 0;
    while (i < paramList.size())
    {
      EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramList.get(i);
      localStringBuilder.append("type = " + localSmallYellowItem.type.get()).append(";id = " + localSmallYellowItem.id.get()).append(";ts = " + localSmallYellowItem.ts.get());
      i += 1;
    }
    QLog.d("CommonUsedSystemEmojiManager", 2, "mergeAndSortSystemEmojiInfo merge:" + localStringBuilder.toString());
  }
  
  private void printBeforeSortLog(List<EmosmPb.SmallYellowItem> paramList1, List<EmosmPb.SmallYellowItem> paramList2)
  {
    int j = 0;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("mergeAndSortSystemEmojiInfo:");
      int i;
      if (paramList1 != null)
      {
        localStringBuilder.append("befor sort list1 : ");
        i = 0;
        while (i < paramList1.size())
        {
          EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramList1.get(i);
          localStringBuilder.append("type = " + localSmallYellowItem.type.get()).append(";id = " + localSmallYellowItem.id.get()).append(";ts = " + localSmallYellowItem.ts.get());
          i += 1;
        }
      }
      if (paramList2 != null)
      {
        localStringBuilder.append("befor sort list2 : ");
        i = j;
        while (i < paramList2.size())
        {
          paramList1 = (EmosmPb.SmallYellowItem)paramList2.get(i);
          localStringBuilder.append("type = " + paramList1.type.get()).append(";id = " + paramList1.id.get()).append(";ts = " + paramList1.ts.get());
          i += 1;
        }
      }
      QLog.d("CommonUsedSystemEmojiManager", 2, "mergeAndSortSystemEmojiInfo merge:" + localStringBuilder.toString());
    }
  }
  
  private void saveMergeInfoToFile(List<EmosmPb.SmallYellowItem> paramList)
  {
    synchronized (this.lock)
    {
      File localFile = new File(BaseApplicationImpl.sApplication.getFilesDir(), "commonusedSystemEmojiInfoFile_v3_" + BaseApplicationImpl.sApplication.getRuntime().getAccount());
      EmosmPb.SubCmd0x13Rsp localSubCmd0x13Rsp = new EmosmPb.SubCmd0x13Rsp();
      localSubCmd0x13Rsp.itemlist.set(paramList);
      FileUtils.a(localFile.getAbsolutePath(), localSubCmd0x13Rsp.toByteArray(), false);
      return;
    }
  }
  
  public void copySystemEmojiFileToFileV2(File paramFile1, File paramFile2)
  {
    Object localObject2;
    synchronized (this.lock)
    {
      localObject2 = FileUtils.a(paramFile1);
      if (localObject2 == null)
      {
        QLog.e("CommonUsedSystemEmojiManager", 1, "Can not translate pb file to byte");
        return;
      }
    }
    paramFile1 = new EmosmPb.SubCmd0x13Rsp();
    for (;;)
    {
      int i;
      try
      {
        paramFile1.mergeFrom((byte[])localObject2);
        ??? = paramFile1.itemlist.get();
        localObject2 = ((List)???).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)((Iterator)localObject2).next();
          i = 0;
          if (i >= EmotcationConstants.REPLACE_EMOJIS.length) {
            continue;
          }
          if (localSmallYellowItem.id.get() == EmotcationConstants.REPLACE_EMOJIS[i]) {
            ((Iterator)localObject2).remove();
          }
        }
        else
        {
          paramFile1.itemlist.set((List)???);
          FileUtils.a(paramFile2.getAbsolutePath(), paramFile1.toByteArray(), false);
          return;
        }
      }
      catch (Exception paramFile1)
      {
        QLog.e("CommonUsedSystemEmojiManager", 1, "getLocalSystemEmojiInfoFromFile mergeFromBody exception e = " + paramFile1.getMessage());
        return;
      }
      i += 1;
    }
  }
  
  public void filterAbnormalData(List<EmosmPb.SmallYellowItem> paramList)
  {
    if (paramList == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      int i = 0;
      if (i < paramList.size())
      {
        EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramList.get(i);
        int j = localSmallYellowItem.type.get();
        int m = localSmallYellowItem.id.get();
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
            if (QQSysFaceUtil.isValidFaceId(j)) {
              localSmallYellowItem.id.set(j);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          localArrayList.add(localSmallYellowItem);
          QLog.e("CommonUsedSystemEmojiManager", 1, "updateItemInfo system id overflow index = " + m + ";emId = " + j);
          continue;
          localArrayList.add(localSmallYellowItem);
          QLog.e("CommonUsedSystemEmojiManager", 1, "updateItemInfo system id overflow index = " + m);
          continue;
          if (j == 2)
          {
            k = QQEmojiUtil.getEmojiLocalId(m);
            j = k;
            if (EMOJI_CONVERT_MAP.containsKey(Integer.valueOf(k)))
            {
              QLog.d("CommonUsedSystemEmojiManager", 2, "updateItemInfo before EMOTIONPANEL_EMOJI_MAP index = " + k);
              j = ((Integer)EMOJI_CONVERT_MAP.get(Integer.valueOf(k))).intValue();
              QLog.d("CommonUsedSystemEmojiManager", 2, "updateItemInfo after EMOTIONPANEL_EMOJI_MAP index = " + j);
            }
            if (j < 0)
            {
              localArrayList.add(localSmallYellowItem);
              QLog.e("CommonUsedSystemEmojiManager", 1, "updateItemInfo emoji id overflow index = " + m + ";localIndex = " + j);
            }
            else
            {
              localSmallYellowItem.id.set(j);
            }
          }
        }
      }
    } while (localArrayList.size() <= 0);
    paramList.removeAll(localArrayList);
  }
  
  public List<EmosmPb.SmallYellowItem> getCacheInfo()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "getCacheInfo");
    }
    if ((this.itemInfos == null) || (this.itemInfos.size() < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CommonUsedSystemEmojiManager", 2, "getCacheInfo is null");
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = this.itemInfos.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((EmosmPb.SmallYellowItem)localIterator.next());
      }
    }
    finally {}
    return localList;
  }
  
  public List<EmosmPb.SmallYellowItem> getCommonUsedSystemEmojiInfo()
  {
    Object localObject2;
    if ((this.itemInfos == null) || (this.itemInfos.size() < 1))
    {
      QLog.e("CommonUsedSystemEmojiManager", 1, "getCommonUsedSystemEmojiInfo  useDefaultinfo");
      updateCacheFromFile();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < this.DEFAULT_IDS.length)
      {
        localObject2 = new EmosmPb.SmallYellowItem();
        int j = this.DEFAULT_IDS[i];
        int k;
        if (j > QQSysFaceUtil.maxServerId())
        {
          ((EmosmPb.SmallYellowItem)localObject2).type.set(2);
          k = QQEmojiUtil.getEmojiLocalId(j);
          j = k;
          if (EMOJI_CONVERT_MAP.containsKey(Integer.valueOf(k)))
          {
            QLog.d("CommonUsedSystemEmojiManager", 2, "getCommonUsedSystemEmojiInfo dedault before EMOTIONPANEL_EMOJI_MAP index = " + k);
            j = ((Integer)EMOJI_CONVERT_MAP.get(Integer.valueOf(k))).intValue();
            QLog.d("CommonUsedSystemEmojiManager", 2, "getCommonUsedSystemEmojiInfo dedault after EMOTIONPANEL_EMOJI_MAP index = " + j);
          }
          ((EmosmPb.SmallYellowItem)localObject2).id.set(j);
          label183:
          if (!QQSysAndEmojiResMgr.getInstance().getResImpl(((EmosmPb.SmallYellowItem)localObject2).type.get()).checkEmoticonShouldHide(((EmosmPb.SmallYellowItem)localObject2).id.get())) {
            break label312;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CommonUsedSystemEmojiManager", 2, new Object[] { "emo should be hided:", Integer.valueOf(((EmosmPb.SmallYellowItem)localObject2).id.get()), " ,type:", Integer.valueOf(((EmosmPb.SmallYellowItem)localObject2).type.get()) });
          }
        }
        for (;;)
        {
          i += 1;
          break;
          ((EmosmPb.SmallYellowItem)localObject2).type.set(1);
          k = QQSysFaceUtil.convertToLocal(j);
          j = k;
          if (k == 250) {
            j = 10;
          }
          ((EmosmPb.SmallYellowItem)localObject2).id.set(j);
          break label183;
          label312:
          ((EmosmPb.SmallYellowItem)localObject2).ts.set(0L);
          localArrayList.add(localObject2);
        }
      }
      try
      {
        this.itemInfos = localArrayList;
        return getCacheInfo();
      }
      finally {}
    }
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "getCommonUsedSystemEmojiInfo ");
    }
    List localList = getCacheInfo();
    if ((!this.hasWhiteList) && (localList != null))
    {
      localObject2 = localList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)((Iterator)localObject2).next();
        if (QQSysAndEmojiResMgr.getInstance().getResImpl(localSmallYellowItem.type.get()).checkEmoticonShouldHide(localSmallYellowItem.id.get())) {
          ((Iterator)localObject2).remove();
        }
      }
    }
    return localList;
  }
  
  public List<EmosmPb.SmallYellowItem> getLocalSystemEmojiInfoFromFile()
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "getLocalSystemEmojiInfoFromFile");
    }
    synchronized (this.lock)
    {
      Object localObject3 = new File(BaseApplicationImpl.sApplication.getFilesDir(), "commonusedSystemEmojiInfoFile_v3_" + BaseApplicationImpl.sApplication.getRuntime().getAccount());
      if (!((File)localObject3).exists())
      {
        QLog.d("CommonUsedSystemEmojiManager", 2, "getLocalSystemEmojiInfoFromFile file not exists");
        return null;
      }
      localObject3 = FileUtils.a((File)localObject3);
      if (localObject3 == null)
      {
        QLog.e("CommonUsedSystemEmojiManager", 1, "Can not translate pb file to byte");
        return null;
      }
    }
    ??? = new EmosmPb.SubCmd0x13Rsp();
    List localList;
    Object localObject4;
    int j;
    EmosmPb.SmallYellowItem localSmallYellowItem;
    int m;
    label314:
    int i;
    for (;;)
    {
      int n;
      try
      {
        ((EmosmPb.SubCmd0x13Rsp)???).mergeFrom(arrayOfByte);
        localList = ((EmosmPb.SubCmd0x13Rsp)???).itemlist.get();
        localObject4 = new ArrayList();
        ??? = new ArrayList();
        if ((localList == null) || (localList.size() <= 0)) {
          break;
        }
        j = 0;
        if (j >= localList.size()) {
          break;
        }
        localObject5 = (EmosmPb.SmallYellowItem)localList.get(j);
        localSmallYellowItem = new EmosmPb.SmallYellowItem();
        localSmallYellowItem.ts.set(((EmosmPb.SmallYellowItem)localObject5).ts.get());
        localSmallYellowItem.type.set(((EmosmPb.SmallYellowItem)localObject5).type.get());
        n = ((EmosmPb.SmallYellowItem)localObject5).type.get();
        m = ((EmosmPb.SmallYellowItem)localObject5).id.get();
        if (n != 1) {
          break label370;
        }
        if (QQSysFaceUtil.isValidFaceId(m)) {
          break label755;
        }
        QLog.e("CommonUsedSystemEmojiManager", 1, "getLocalSystemEmojiInfoFromFile type = system, id error, id = " + m);
      }
      catch (Exception localException)
      {
        QLog.e("CommonUsedSystemEmojiManager", 1, "getLocalSystemEmojiInfoFromFile mergeFromBody exception e = " + localException.getMessage());
        return null;
      }
      localSmallYellowItem.id.set(i);
      ((List)localObject4).add(localSmallYellowItem);
      break label748;
      label370:
      i = m;
      if (n == 2)
      {
        if (!QQEmojiUtil.isValidEmojiId(m))
        {
          QLog.e("CommonUsedSystemEmojiManager", 1, "getLocalSystemEmojiInfoFromFile type = emoji, id error, id = " + m);
          break label748;
        }
        i = m;
        if (EMOJI_CONVERT_MAP.containsKey(Integer.valueOf(m)))
        {
          QLog.d("CommonUsedSystemEmojiManager", 2, "getLocalSystemEmojiInfoFromFile before EMOTIONPANEL_EMOJI_MAP index = " + m);
          i = ((Integer)EMOJI_CONVERT_MAP.get(Integer.valueOf(m))).intValue();
          QLog.d("CommonUsedSystemEmojiManager", 2, "getLocalSystemEmojiInfoFromFile after EMOTIONPANEL_EMOJI_MAP index = " + i);
        }
      }
    }
    Object localObject5 = getCacheInfo();
    if ((localList != null) && (localList.size() > 0)) {
      i = k;
    }
    for (;;)
    {
      if (i < localList.size())
      {
        localSmallYellowItem = (EmosmPb.SmallYellowItem)localList.get(i);
        k = localSmallYellowItem.type.get();
        j = localSmallYellowItem.id.get();
        if (k == 1)
        {
          k = QQSysFaceUtil.convertToServer(j);
          if (k >= 0)
          {
            if (j == 10) {}
            localSmallYellowItem.id.set(k);
          }
        }
        for (;;)
        {
          localException.add(localSmallYellowItem);
          break label772;
          QLog.e("CommonUsedSystemEmojiManager", 1, "getLocalSystemEmojiInfoFromFile system error localId = " + j);
          break label772;
          k = QQEmojiUtil.getEmojiUnicode(j);
          if (k == -1) {
            break;
          }
          localSmallYellowItem.id.set(k);
        }
        QLog.e("CommonUsedSystemEmojiManager", 1, "getLocalSystemEmojiInfoFromFile emoji error localId = " + j);
      }
      else
      {
        localList = mergeAndSortSystemEmojiInfo((List)localObject4, (List)localObject5);
        localObject4 = getPaddedData(localList);
        if (localObject4 != null) {
          localList.addAll((Collection)localObject4);
        }
        try
        {
          this.itemInfos = localList;
          return localException;
        }
        finally {}
        label748:
        j += 1;
        break;
        label755:
        i = m;
        if (m != 250) {
          break label314;
        }
        i = 10;
        break label314;
      }
      label772:
      i += 1;
    }
  }
  
  public List<EmosmPb.SmallYellowItem> getPaddedData(List<EmosmPb.SmallYellowItem> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    paramList = null;
    int i;
    int k;
    int m;
    int j;
    if (((List)localObject).size() < 21)
    {
      i = ((List)localObject).size();
      paramList = new ArrayList();
      if (21 - i < 0)
      {
        k = 0;
        m = 0;
        if (k < this.DEFAULT_IDS.length)
        {
          i = this.DEFAULT_IDS[k];
          if (i < QQSysFaceUtil.maxServerId())
          {
            j = QQSysFaceUtil.convertToLocal(i);
            if (j != 250) {
              break label422;
            }
            i = 1;
            j = 10;
          }
        }
      }
    }
    for (;;)
    {
      if (QQSysAndEmojiResMgr.getInstance().getResImpl(i).checkEmoticonShouldHide(j))
      {
        n = m;
        if (QLog.isColorLevel())
        {
          QLog.d("CommonUsedSystemEmojiManager", 2, new Object[] { "emo should be hided:", Integer.valueOf(j), " ,type:", Integer.valueOf(i) });
          n = m;
        }
        k += 1;
        m = n;
        break;
        j = QQEmojiUtil.getEmojiLocalId(i);
        i = j;
        if (EMOJI_CONVERT_MAP.containsKey(Integer.valueOf(j)))
        {
          QLog.d("CommonUsedSystemEmojiManager", 2, "paddedData dedault before EMOTIONPANEL_EMOJI_MAP index = " + j);
          i = ((Integer)EMOJI_CONVERT_MAP.get(Integer.valueOf(j))).intValue();
          QLog.d("CommonUsedSystemEmojiManager", 2, "paddedData dedault after EMOTIONPANEL_EMOJI_MAP index = " + i);
        }
        n = 2;
        j = i;
        i = n;
        continue;
      }
      int n = 0;
      label281:
      EmosmPb.SmallYellowItem localSmallYellowItem;
      if (n < ((List)localObject).size())
      {
        localSmallYellowItem = (EmosmPb.SmallYellowItem)((List)localObject).get(n);
        i1 = localSmallYellowItem.type.get();
        int i2 = localSmallYellowItem.id.get();
        if ((i1 != i) || (i2 != j)) {}
      }
      for (int i1 = 1;; i1 = 0)
      {
        n = m;
        if (i1 != 0) {
          break;
        }
        n = m + 1;
        localSmallYellowItem = new EmosmPb.SmallYellowItem();
        localSmallYellowItem.type.set(i);
        localSmallYellowItem.id.set(j);
        localSmallYellowItem.ts.set(0L);
        paramList.add(localSmallYellowItem);
        break;
        n += 1;
        break label281;
        return paramList;
      }
      label422:
      i = 1;
    }
  }
  
  public List<EmosmPb.SmallYellowItem> mergeAndSortSystemEmojiInfo(List<EmosmPb.SmallYellowItem> paramList1, List<EmosmPb.SmallYellowItem> paramList2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "mergeAndSortSystemEmojiInfo");
    }
    if ((paramList1 == null) && (paramList2 == null))
    {
      QLog.e("CommonUsedSystemEmojiManager", 1, "mergeAndSortSystemEmojiInfo list IS null");
      return null;
    }
    if (paramList1 == null) {
      QLog.e("CommonUsedSystemEmojiManager", 1, "mergeAndSortSystemEmojiInfo  list1 = NULL");
    }
    for (List<EmosmPb.SmallYellowItem> localList = paramList2;; localList = null)
    {
      if (paramList2 == null)
      {
        QLog.e("CommonUsedSystemEmojiManager", 1, "mergeAndSortSystemEmojiInfo  list2 = NULL");
        localList = paramList1;
      }
      if (localList == null)
      {
        paramList1.addAll(paramList2);
        localList = paramList1;
      }
      for (;;)
      {
        printBeforeSortLog(paramList1, paramList2);
        Collections.sort(localList, new CommonUsedSystemEmojiManager.2(this));
        printAfterSortLog(localList);
        paramList1 = new HashSet();
        paramList2 = localList.iterator();
        while (paramList2.hasNext())
        {
          EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramList2.next();
          String str = localSmallYellowItem.type.get() + "-" + localSmallYellowItem.id.get();
          if ((paramList1.contains(str)) || (QQSysAndEmojiResMgr.getInstance().getResImpl(localSmallYellowItem.type.get()).checkEmoticonShouldHide(localSmallYellowItem.id.get()))) {
            paramList2.remove();
          } else {
            paramList1.add(str);
          }
        }
        printAfterSortLog(localList);
        return localList;
      }
    }
  }
  
  public List<EmosmPb.SmallYellowItem> mergeList(List<EmosmPb.SmallYellowItem> paramList)
  {
    int i = 21;
    new ArrayList();
    if ((this.itemInfos != null) && (this.itemInfos.size() > 0)) {
      paramList = mergeAndSortSystemEmojiInfo(paramList, getCacheInfo());
    }
    while (paramList.size() > 21)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CommonUsedSystemEmojiManager", 2, "before remove size = " + paramList.size());
      }
      localObject = new ArrayList();
      for (;;)
      {
        if (i < paramList.size())
        {
          ((List)localObject).add(paramList.get(i));
          i += 1;
          continue;
          paramList = mergeAndSortSystemEmojiInfo(null, paramList);
          break;
        }
      }
      paramList.removeAll((Collection)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("CommonUsedSystemEmojiManager", 2, "after remove size = " + paramList.size());
      }
    }
    Object localObject = getPaddedData(paramList);
    if (localObject != null) {
      paramList.addAll((Collection)localObject);
    }
    return paramList;
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
    int i = 0;
    if (paramSmallYellowItem == null)
    {
      QLog.e("CommonUsedSystemEmojiManager", 1, "saveSystemEmojiInfoToCahce info = null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "saveSystemEmojiInfoToCahce id = " + paramSmallYellowItem.id.get() + ";type = " + paramSmallYellowItem.type.get() + ";ts = " + paramSmallYellowItem.ts.get());
    }
    int j = paramSmallYellowItem.type.get();
    int k = paramSmallYellowItem.id.get();
    for (;;)
    {
      EmosmPb.SmallYellowItem localSmallYellowItem;
      try
      {
        if (this.itemInfos == null) {
          break label330;
        }
        if (i >= this.itemInfos.size()) {
          break label355;
        }
        localSmallYellowItem = (EmosmPb.SmallYellowItem)this.itemInfos.get(i);
        if ((localSmallYellowItem.type.get() == j) && (localSmallYellowItem.id.get() == k))
        {
          localSmallYellowItem = null;
          if (i < 0) {
            break label288;
          }
          localSmallYellowItem = (EmosmPb.SmallYellowItem)this.itemInfos.remove(i);
          if ((QLog.isColorLevel()) && (localSmallYellowItem != null)) {
            QLog.d("CommonUsedSystemEmojiManager", 2, "saveSystemEmojiInfoToCahce removeInfo : type =" + localSmallYellowItem.type.get() + ";id = " + localSmallYellowItem.id.get() + ";ts = " + localSmallYellowItem.ts.get());
          }
          this.itemInfos.add(0, paramSmallYellowItem);
          return;
        }
      }
      finally {}
      i += 1;
      continue;
      label288:
      if (this.itemInfos.size() >= 21)
      {
        localSmallYellowItem = (EmosmPb.SmallYellowItem)this.itemInfos.remove(this.itemInfos.size() - 1);
        continue;
        label330:
        this.itemInfos = new ArrayList();
        this.itemInfos.add(paramSmallYellowItem);
        continue;
        label355:
        i = -1;
      }
    }
  }
  
  public void saveSystemEmojiInfoToFile()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "saveSystemEmojiInfoToFile");
    }
    ThreadManager.getFileThreadHandler().post(new CommonUsedSystemEmojiManager.3(this));
  }
  
  public void updateCacheFromFile()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "updateCacheFromFile");
    }
    ThreadManager.getFileThreadHandler().post(new CommonUsedSystemEmojiManager.1(this));
  }
  
  public void updateItemInfo(List<EmosmPb.SmallYellowItem> paramList)
  {
    if (paramList == null)
    {
      QLog.e("CommonUsedSystemEmojiManager", 1, "updateItemInfo info = null");
      return;
    }
    this.hasWhiteList = SystemEmoticonInfo.parseWhiteList(this.app, false);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("updateItemInfo backList size = ");
      localStringBuilder.append(paramList.size());
      if (paramList != null)
      {
        localStringBuilder.append(", before convert: ");
        int i = 0;
        while (i < paramList.size())
        {
          EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramList.get(i);
          localStringBuilder.append("type = " + localSmallYellowItem.type.get()).append(";id = " + localSmallYellowItem.id.get()).append(";ts = " + localSmallYellowItem.ts.get());
          i += 1;
        }
      }
      QLog.d("CommonUsedSystemEmojiManager", 2, localStringBuilder.toString());
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.CommonUsedSystemEmojiManager
 * JD-Core Version:    0.7.0.1
 */