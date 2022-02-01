package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import android.os.Parcelable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.CameraEmotionAdapterHelper;
import com.tencent.mobileqq.emoticonview.EmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.emoticonview.IEmoticonInfoSender;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.emoticonview.adapter.IEmotionAdapterHelper;
import com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommonUsedSystemEmojiManagerProxy;
import com.tencent.mobileqq.emoticonview.sender.CameraEmoticonInfoSender;
import com.tencent.mobileqq.emoticonview.sender.FavoriteEmoticonInfoSender;
import com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender;
import com.tencent.mobileqq.emoticonview.sender.SystemAndEmojiEmoticonInfoSender;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class EmoticonInfoServiceImpl
  implements IEmoticonInfoService
{
  private static final String TAG = "EmoticonInfoServiceImpl";
  
  public static List<EmotionPanelData> getCommonUsedSystemEmojiPanelData(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp, int paramInt)
  {
    return getCommonUsedSystemEmojiPanelData(paramQQEmoticonMainPanelApp, paramInt, false);
  }
  
  public static List<EmotionPanelData> getCommonUsedSystemEmojiPanelData(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramQQEmoticonMainPanelApp == null) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, SystemAndEmojiEmoticonInfo.TITLE_OFTEN, false));
      i += 1;
    }
    paramQQEmoticonMainPanelApp = ((CommonUsedSystemEmojiManagerProxy)paramQQEmoticonMainPanelApp.getManager(QQManagerFactory.COMMONUSED_SYSTEM_EMOJI_MANAGERT)).getCommonUsedSystemEmojiInfo();
    int j;
    if ((paramQQEmoticonMainPanelApp != null) && (paramQQEmoticonMainPanelApp.size() > 1))
    {
      j = 0;
      i = 0;
      if ((j >= paramQQEmoticonMainPanelApp.size()) || (i >= paramInt * 3))
      {
        if (i >= paramInt * 3) {
          break label269;
        }
        j = i % paramInt;
        if (j == 0) {
          break label269;
        }
        i = 0;
      }
    }
    while (i < paramInt - j)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
      i += 1;
      continue;
      EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramQQEmoticonMainPanelApp.get(j);
      int k = 1;
      if (localSmallYellowItem.type.get() == 2) {
        k = 2;
      }
      if ((paramBoolean) && (k == 1) && (localSmallYellowItem.id.get() > 255)) {}
      for (;;)
      {
        j += 1;
        break;
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, k, localSmallYellowItem.id.get(), "", true));
        i += 1;
      }
      QLog.e("EmoticonInfoServiceImpl", 1, "CommonlyUsedSystemEmoji IS NULL");
    }
    label269:
    return localArrayList;
  }
  
  public static List<EmotionPanelData> getEmojiEmoticonPanelData(int paramInt, ArrayList<Integer> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, SystemAndEmojiEmoticonInfo.TITLE_EMOJI, false));
      i += 1;
    }
    i = 0;
    while (i < paramArrayList.size())
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, ((Integer)paramArrayList.get(i)).intValue(), "", false));
      i += 1;
    }
    int j = paramArrayList.size() % paramInt;
    if (j > 0)
    {
      i = 0;
      while (i < paramInt - j)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, -1, "", false));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static List<EmotionPanelData> getSystemEmoticonPanelData(int paramInt, ArrayList<Integer> paramArrayList)
  {
    return getSystemEmoticonPanelData(paramInt, false, paramArrayList);
  }
  
  public static List<EmotionPanelData> getSystemEmoticonPanelData(int paramInt, boolean paramBoolean, ArrayList<Integer> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, SystemAndEmojiEmoticonInfo.TITLE_SYSTEM, false));
      i += 1;
    }
    i = 0;
    int k = paramArrayList.size();
    int j = 0;
    if (j < k)
    {
      if ((paramBoolean) && (((Integer)paramArrayList.get(j)).intValue() > 255)) {
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        if (((Integer)paramArrayList.get(j)).intValue() == -1) {
          localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, 0, "", false));
        } else {
          localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, ((Integer)paramArrayList.get(j)).intValue(), "", false));
        }
      }
    }
    j = (paramArrayList.size() - i) % paramInt;
    if (j > 0)
    {
      i = 0;
      while (i < paramInt - j)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public void addToCommonUsed(AppRuntime paramAppRuntime, Parcelable paramParcelable, int paramInt1, int paramInt2)
  {
    if (!(paramAppRuntime instanceof QQAppInterface)) {
      return;
    }
    SystemAndEmojiEmoticonInfoSender.addToCommonUsed((QQAppInterface)paramAppRuntime, (SessionInfo)paramParcelable, paramInt1, paramInt2);
  }
  
  public IEmoticonPanelLinearLayoutHelper createEmoticonPanelLayoutHelper(Context paramContext, boolean paramBoolean)
  {
    return new QQEmoticonPanelLinearLayoutHelper(paramContext);
  }
  
  public IEmotionAdapterHelper createEmotionAdapterHelper(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt)
  {
    if (paramInt == 11) {
      return new CameraEmotionAdapterHelper(paramIEmoticonMainPanelApp);
    }
    return null;
  }
  
  public IEmoticonInfoSender createEmotionInfoSender(int paramInt)
  {
    if (paramInt == 7) {
      return new SystemAndEmojiEmoticonInfoSender();
    }
    if (paramInt == 4) {
      return new FavoriteEmoticonInfoSender();
    }
    if (paramInt == 11) {
      return new CameraEmoticonInfoSender();
    }
    if (paramInt == 6) {
      return new PicEmoticonInfoSender();
    }
    return null;
  }
  
  public List<EmotionPanelData> getCommonUsedSystemEmojiPanelData(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramIEmoticonMainPanelApp == null) {
      return localArrayList;
    }
    paramIEmoticonMainPanelApp = (QQEmoticonMainPanelApp)paramIEmoticonMainPanelApp;
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, SystemAndEmojiEmoticonInfo.TITLE_OFTEN, false));
      i += 1;
    }
    paramIEmoticonMainPanelApp = ((CommonUsedSystemEmojiManagerProxy)paramIEmoticonMainPanelApp.getManager(QQManagerFactory.COMMONUSED_SYSTEM_EMOJI_MANAGERT)).getCommonUsedSystemEmojiInfo();
    int j;
    if ((paramIEmoticonMainPanelApp != null) && (paramIEmoticonMainPanelApp.size() > 1))
    {
      j = 0;
      i = 0;
      if ((j >= paramIEmoticonMainPanelApp.size()) || (i >= paramInt * 3))
      {
        if (i >= paramInt * 3) {
          break label288;
        }
        j = i % paramInt;
        if (j == 0) {
          break label288;
        }
        i = 0;
      }
    }
    while (i < paramInt - j)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
      i += 1;
      continue;
      EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramIEmoticonMainPanelApp.get(j);
      int k = 1;
      if (localSmallYellowItem.type.get() == 2) {
        k = 2;
      }
      if ((paramBoolean) && (k == 1) && (localSmallYellowItem.id.get() > 255)) {}
      for (;;)
      {
        j += 1;
        break;
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, k, localSmallYellowItem.id.get(), "", true));
        i += 1;
      }
      QLog.e("EmoticonInfoServiceImpl", 1, "CommonlyUsedSystemEmoji IS NULL");
    }
    label288:
    return localArrayList;
  }
  
  public List<EmotionPanelData> getEmoticonList(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt1, int paramInt2)
  {
    if (paramIEmoticonMainPanelApp == null)
    {
      QLog.e("EmoticonInfoServiceImpl", 1, "getEmoticonList app = null");
      return null;
    }
    Object localObject = (QQEmoticonMainPanelApp)paramIEmoticonMainPanelApp;
    SystemEmoticonInfo.parseWhiteList(((QQEmoticonMainPanelApp)localObject).getAppRuntime(), false);
    paramIEmoticonMainPanelApp = SystemEmoticonInfo.getSysEmotionOrder();
    ArrayList localArrayList = new ArrayList(paramIEmoticonMainPanelApp.length + EmojiEmoticonInfo.EMOJI_COUNT);
    int i;
    if ((paramInt2 != 2) && (paramInt2 != 3))
    {
      i = 0;
      while (i < paramInt1)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, SystemAndEmojiEmoticonInfo.TITLE_OFTEN, false));
        i += 1;
      }
      localObject = ((CommonUsedSystemEmojiManagerProxy)((QQEmoticonMainPanelApp)localObject).getManager(QQManagerFactory.COMMONUSED_SYSTEM_EMOJI_MANAGERT)).getCommonUsedSystemEmojiInfo();
      if ((localObject != null) && (((List)localObject).size() > 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonInfoServiceImpl", 2, "getEmoticonList commonusedsize = " + ((List)localObject).size());
        }
        i = ((List)localObject).size();
        if (i <= paramInt1 * 3) {
          break label612;
        }
        i = paramInt1 * 3;
      }
    }
    label612:
    for (;;)
    {
      int j = 0;
      while (j < i)
      {
        EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)((List)localObject).get(j);
        int k = 1;
        if (localSmallYellowItem.type.get() == 2) {
          k = 2;
        }
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, k, localSmallYellowItem.id.get(), "", true));
        j += 1;
      }
      if (i < paramInt1 * 3)
      {
        j = i % paramInt1;
        if (j != 0)
        {
          i = 0;
          while (i < paramInt1 - j)
          {
            localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
            i += 1;
            continue;
            QLog.e("EmoticonInfoServiceImpl", 1, "CommonlyUsedSystemEmoji IS NULL");
          }
        }
      }
      i = 0;
      while (i < paramInt1)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, SystemAndEmojiEmoticonInfo.TITLE_SYSTEM, false));
        i += 1;
      }
      j = paramIEmoticonMainPanelApp.length;
      i = 0;
      while (i < j)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, paramIEmoticonMainPanelApp[i], "", false));
        i += 1;
      }
      j = paramIEmoticonMainPanelApp.length % paramInt1;
      if (j > 0)
      {
        i = 0;
        while (i < j)
        {
          localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
          i += 1;
        }
      }
      if (paramInt2 != 2)
      {
        paramInt2 = 0;
        while (paramInt2 < paramInt1)
        {
          localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, SystemAndEmojiEmoticonInfo.TITLE_EMOJI, false));
          paramInt2 += 1;
        }
        paramInt2 = 0;
        while (paramInt2 < EmojiEmoticonInfo.EMOJI_COUNT)
        {
          localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, paramInt2, "", false));
          paramInt2 += 1;
        }
        paramInt2 = EmojiEmoticonInfo.EMOJI_COUNT % paramInt1;
        if (paramInt2 > 0)
        {
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, -1, "", false));
            paramInt1 += 1;
          }
        }
      }
      return localArrayList;
    }
  }
  
  public List<EmotionPanelData> getEmoticonListFromConfig(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramIEmoticonMainPanelApp == null)
    {
      QLog.e("EmoticonInfoServiceImpl", 1, "getEmoticonList app = null");
      paramIEmoticonMainPanelApp = null;
    }
    ArrayList localArrayList2;
    ArrayList localArrayList1;
    do
    {
      return paramIEmoticonMainPanelApp;
      ArrayList localArrayList3 = QQSysFaceUtil.getOrderList();
      localArrayList2 = QQEmojiUtil.getOrderList();
      localArrayList1 = new ArrayList(localArrayList3.size() + localArrayList2.size());
      if ((paramInt2 != 2) && (paramInt2 != 3)) {
        localArrayList1.addAll(getCommonUsedSystemEmojiPanelData(paramIEmoticonMainPanelApp, paramInt1, paramBoolean));
      }
      localArrayList1.addAll(getSystemEmoticonPanelData(paramInt1, paramBoolean, localArrayList3));
      paramIEmoticonMainPanelApp = localArrayList1;
    } while (paramInt2 == 2);
    localArrayList1.addAll(getEmojiEmoticonPanelData(paramInt1, localArrayList2));
    return localArrayList1;
  }
  
  public JSONObject getJSONFromLocal(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    return VasUpdateUtil.a(paramAppRuntime, "emoji.systemEmojiWhiteList.json", paramBoolean, null);
  }
  
  public List<EmoticonInfo> getOldEmoticonList(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfInt.length + EmojiEmoticonInfo.EMOJI_COUNT);
    int j = EmojiEmoticonInfo.EMOJI_COUNT % 20;
    int i = EmojiEmoticonInfo.EMOJI_COUNT - 1;
    while (i >= EmojiEmoticonInfo.EMOJI_COUNT - j)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, i, "", false));
      i -= 1;
    }
    i = 0;
    while (i < 20 - j)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, -1, "", false));
      i += 1;
    }
    i = EmojiEmoticonInfo.EMOJI_COUNT - j - 1;
    if (i >= 0)
    {
      if (QQSysAndEmojiResMgr.getInstance().getResImpl(2).checkEmoticonShouldHide(i)) {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonInfoServiceImpl", 2, new Object[] { "getOldEmoticonList hided:", Integer.valueOf(i), " ,type:", Integer.valueOf(2) });
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, i, "", false));
      }
    }
    j = paramArrayOfInt.length;
    i = 0;
    if (i < j)
    {
      int k = paramArrayOfInt[i];
      if (QQSysAndEmojiResMgr.getInstance().getResImpl(1).checkEmoticonShouldHide(k)) {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonInfoServiceImpl", 2, new Object[] { "getOldEmoticonList hided:", Integer.valueOf(k), " ,type:", Integer.valueOf(1) });
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, k, "", false));
      }
    }
    return localArrayList;
  }
  
  public List<EmotionPanelData> getOnlySysEmoticonListFromConfig(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt, int[] paramArrayOfInt)
  {
    if (paramIEmoticonMainPanelApp == null)
    {
      QLog.e("EmoticonInfoServiceImpl", 1, "getEmoticonList app = null");
      return null;
    }
    if (paramArrayOfInt != null)
    {
      paramIEmoticonMainPanelApp = paramArrayOfInt;
      if (paramArrayOfInt.length != 0) {}
    }
    else
    {
      paramIEmoticonMainPanelApp = SystemEmoticonInfo.getSysEmotionOrder();
    }
    paramArrayOfInt = new ArrayList(paramIEmoticonMainPanelApp.length);
    int i = 0;
    while (i < paramIEmoticonMainPanelApp.length)
    {
      paramArrayOfInt.add(Integer.valueOf(paramIEmoticonMainPanelApp[i]));
      i += 1;
    }
    paramIEmoticonMainPanelApp = new ArrayList(paramArrayOfInt.size());
    int j = paramArrayOfInt.size();
    i = 0;
    if (i < j)
    {
      Integer localInteger = (Integer)paramArrayOfInt.get(i);
      if (TextUtils.isApolloEmoticon(localInteger.intValue())) {}
      for (;;)
      {
        i += 1;
        break;
        if (localInteger.intValue() == -1) {
          paramIEmoticonMainPanelApp.add(new SystemAndEmojiEmoticonInfo(7, 1, 0, "", false));
        } else {
          paramIEmoticonMainPanelApp.add(new SystemAndEmojiEmoticonInfo(7, 1, localInteger.intValue(), "", false));
        }
      }
    }
    j = paramIEmoticonMainPanelApp.size() % paramInt;
    if (j > 0)
    {
      i = 0;
      while (i < paramInt - j)
      {
        paramIEmoticonMainPanelApp.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
        i += 1;
      }
    }
    return paramIEmoticonMainPanelApp;
  }
  
  public List<EmotionPanelData> getUniversalEmoticonListFromConfig(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ArrayList localArrayList1 = QQSysFaceUtil.getOrderList();
    ArrayList localArrayList2 = QQEmojiUtil.getOrderList();
    ArrayList localArrayList3 = new ArrayList(localArrayList1.size() + localArrayList2.size());
    if (paramBoolean1)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        localArrayList3.addAll(getCommonUsedSystemEmojiPanelData(new QQEmoticonMainPanelApp((QQAppInterface)localAppRuntime), paramInt, paramBoolean3));
      }
    }
    localArrayList3.addAll(getSystemEmoticonPanelData(paramInt, paramBoolean3, localArrayList1));
    if (paramBoolean2) {
      localArrayList3.addAll(getEmojiEmoticonPanelData(paramInt, localArrayList2));
    }
    return localArrayList3;
  }
  
  public String getVasExtensionDownloaderProtocol()
  {
    return "protocol_vas_extension_image";
  }
  
  public void preload(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = SystemAndEmojiEmoticonInfo.getEmoticonList(new QQEmoticonMainPanelApp(paramAppRuntime), 0);
    if ((paramAppRuntime != null) && (paramAppRuntime.size() > 0))
    {
      int i = 0;
      while ((i < 84) && (i < paramAppRuntime.size()))
      {
        Object localObject = (EmotionPanelData)paramAppRuntime.get(i);
        if ((localObject instanceof SystemAndEmojiEmoticonInfo))
        {
          localObject = (SystemAndEmojiEmoticonInfo)localObject;
          if ((((SystemAndEmojiEmoticonInfo)localObject).type != 3) && (((SystemAndEmojiEmoticonInfo)localObject).code != -1))
          {
            localObject = (URLDrawable)((SystemAndEmojiEmoticonInfo)localObject).getDrawable(false);
            if ((localObject != null) && (((URLDrawable)localObject).getStatus() != 1)) {
              ((URLDrawable)localObject).startDownload();
            }
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.EmoticonInfoServiceImpl
 * JD-Core Version:    0.7.0.1
 */