package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.EmotionPanelInjectionInfoManager;
import com.tencent.mobileqq.config.business.EmoticonTabSortConfBean;
import com.tencent.mobileqq.config.business.EmoticonTabSortConfProcessor;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class EmoticonUtils
{
  private static final String LOG_TAG = "EmoticonUtils";
  
  public static void downloadNormalEmotion(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp, EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((paramQQEmoticonMainPanelApp != null) && (paramEmoticonPackage != null))
    {
      paramQQEmoticonMainPanelApp = (EmojiManagerServiceProxy)paramQQEmoticonMainPanelApp.getRuntimeService(IEmojiManagerService.class);
      if ((paramQQEmoticonMainPanelApp.getEmoticonPackageLoadingProgress(paramEmoticonPackage.epId) < 0.0F) && (EmoticonPanelUtils.b()))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("downloadNormalEmotion wifi auto download emotion , epid = ");
          localStringBuilder.append(paramEmoticonPackage.epId);
          QLog.d("EmoticonUtils", 2, localStringBuilder.toString());
        }
        paramQQEmoticonMainPanelApp.pullEmoticonPackage(paramEmoticonPackage, false, false, paramInt);
      }
    }
  }
  
  public static List<EmotionPanelInfo> getAllEmotionPanelData(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp, EmotionPanelInjectionInfoManager paramEmotionPanelInjectionInfoManager, int paramInt, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    List localList = Collections.synchronizedList(new ArrayList());
    Object localObject1 = ((EmoticonManagerServiceProxy)paramQQEmoticonMainPanelApp.getRuntimeService(IEmoticonManagerService.class)).syncGetTabEmoticonPackages(paramInt);
    Object localObject2 = EmoticonTabSortConfProcessor.a();
    if ((localObject2 != null) && (!((EmoticonTabSortConfBean)localObject2).b.isEmpty()))
    {
      localList.addAll(sortEmoticonTabs(paramQQEmoticonMainPanelApp, paramEmotionPanelInjectionInfoManager, ((EmoticonTabSortConfBean)localObject2).b, null, paramInt, paramBoolean));
    }
    else
    {
      localObject2 = new ArrayList();
      ((List)localObject2).add("sysface");
      ((List)localObject2).add("favorite");
      ((List)localObject2).add("hotpic");
      ((List)localObject2).add("camera");
      ((List)localObject2).add("cmshow");
      ((List)localObject2).add("recommend");
      localList.addAll(sortEmoticonTabs(paramQQEmoticonMainPanelApp, paramEmotionPanelInjectionInfoManager, (List)localObject2, null, paramInt, paramBoolean));
    }
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      int i;
      for (paramInt = 0; ((Iterator)localObject1).hasNext(); paramInt = i)
      {
        localObject2 = (EmoticonPackage)((Iterator)localObject1).next();
        i = ((EmoticonPackage)localObject2).type;
        boolean bool = true;
        if ((i != 1) && (3 != ((EmoticonPackage)localObject2).jobType) && (1 != ((EmoticonPackage)localObject2).jobType) && (5 != ((EmoticonPackage)localObject2).jobType))
        {
          paramEmotionPanelInjectionInfoManager = null;
          if (((EmoticonPackage)localObject2).jobType == 4)
          {
            paramQQEmoticonMainPanelApp = new EmotionPanelInfo(10, 7, (EmoticonPackage)localObject2);
          }
          else
          {
            paramQQEmoticonMainPanelApp = paramEmotionPanelInjectionInfoManager;
            if (((EmoticonPackage)localObject2).jobType == 0)
            {
              paramQQEmoticonMainPanelApp = paramEmotionPanelInjectionInfoManager;
              if (!paramBoolean) {
                paramQQEmoticonMainPanelApp = new EmotionPanelInfo(6, 4, (EmoticonPackage)localObject2);
              }
            }
          }
          i = paramInt;
          if (paramQQEmoticonMainPanelApp != null)
          {
            localList.add(paramQQEmoticonMainPanelApp);
            i = paramInt;
          }
        }
        else if (3 != ((EmoticonPackage)localObject2).jobType)
        {
          i = paramInt;
          if (5 != ((EmoticonPackage)localObject2).jobType) {}
        }
        else
        {
          i = paramInt;
          if (paramInt == 0)
          {
            localList.add(new EmotionPanelInfo(9, 4, (EmoticonPackage)localObject2));
            i = 1;
          }
        }
        paramQQEmoticonMainPanelApp = ((EmoticonPackage)localObject2).epId;
        if (((EmoticonPackage)localObject2).status != 2) {
          bool = false;
        }
        EmoticonTabAdapter.generateTabUrl(paramQQEmoticonMainPanelApp, bool);
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      paramQQEmoticonMainPanelApp = new StringBuilder();
      paramQQEmoticonMainPanelApp.append("prepare data cost time:");
      paramQQEmoticonMainPanelApp.append(l2 - l1);
      QLog.d("EmoticonUtils", 2, paramQQEmoticonMainPanelApp.toString());
    }
    return localList;
  }
  
  public static List<EmotionPanelInfo> getNonBigAndFavEmotionPanelData(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp)
  {
    paramQQEmoticonMainPanelApp = new ArrayList();
    paramQQEmoticonMainPanelApp.add(new EmotionPanelInfo(7, 7, null));
    return paramQQEmoticonMainPanelApp;
  }
  
  public static List<EmotionPanelInfo> getNonBigEmotionPanelData(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp, EmotionPanelInjectionInfoManager paramEmotionPanelInjectionInfoManager)
  {
    ArrayList localArrayList1 = new ArrayList();
    EmoticonTabSortConfBean localEmoticonTabSortConfBean = EmoticonTabSortConfProcessor.a();
    if ((localEmoticonTabSortConfBean != null) && (!localEmoticonTabSortConfBean.b.isEmpty()))
    {
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add("sysface");
      localArrayList2.add("favorite");
      localArrayList2.add("hotpic");
      localArrayList2.add("camera");
      localArrayList1.addAll(sortEmoticonTabs(paramQQEmoticonMainPanelApp, paramEmotionPanelInjectionInfoManager, localEmoticonTabSortConfBean.b, localArrayList2, 0, false));
      return localArrayList1;
    }
    localArrayList1.add(new EmotionPanelInfo(7, 7, null));
    if (paramQQEmoticonMainPanelApp.getQQAppInterface() != null)
    {
      localArrayList1.add(new EmotionPanelInfo(4, 4, null));
      localArrayList1.add(new EmotionPanelInfo(12, 4, null));
      localArrayList1.add(new EmotionPanelInfo(11, 4, null));
    }
    return localArrayList1;
  }
  
  public static String getSystemAndEmojiEmoticonName(EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo))
    {
      Object localObject = null;
      SystemAndEmojiEmoticonInfo localSystemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo)paramEmoticonInfo;
      if (localSystemAndEmojiEmoticonInfo.emotionType == 1)
      {
        paramEmoticonInfo = QQSysFaceUtil.getFaceDescription(localSystemAndEmojiEmoticonInfo.code);
      }
      else
      {
        paramEmoticonInfo = (EmoticonInfo)localObject;
        if (localSystemAndEmojiEmoticonInfo.emotionType == 2) {
          paramEmoticonInfo = QQEmojiUtil.getEmojiDescription(localSystemAndEmojiEmoticonInfo.code);
        }
      }
      localObject = paramEmoticonInfo;
      if (paramEmoticonInfo != null)
      {
        localObject = paramEmoticonInfo;
        if (paramEmoticonInfo.length() > 1)
        {
          localObject = paramEmoticonInfo;
          if (paramEmoticonInfo.startsWith("/")) {
            localObject = paramEmoticonInfo.substring(1);
          }
        }
      }
      return localObject;
    }
    return "";
  }
  
  public static boolean isShowEmoTitleInPreview(Object paramObject, EmoticonInfo paramEmoticonInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramEmoticonInfo != null)
    {
      if (paramObject == null) {
        return false;
      }
      bool1 = bool2;
      if (paramEmoticonInfo.type == 7) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void report(String paramString, int paramInt)
  {
    report(paramString, paramString, paramInt);
  }
  
  public static void report(String paramString1, String paramString2, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", paramString1, paramString2, paramInt, 0, "", "0", "0", "");
  }
  
  public static List<EmotionPanelInfo> sortEmoticonTabs(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp, EmotionPanelInjectionInfoManager paramEmotionPanelInjectionInfoManager, List<String> paramList1, List<String> paramList2, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList1 == null) {
      return localArrayList;
    }
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      Object localObject = (String)paramList1.next();
      if ((paramList2 == null) || (paramList2.contains(localObject))) {
        if ("sysface".equals(localObject))
        {
          localArrayList.add(new EmotionPanelInfo(7, 7, null));
        }
        else if ("favorite".equals(localObject))
        {
          if ((paramInt == 0) && (paramQQEmoticonMainPanelApp.getQQAppInterface() != null)) {
            localArrayList.add(new EmotionPanelInfo(4, 4, null));
          }
        }
        else if ("hotpic".equals(localObject))
        {
          if ((paramInt == 0) && (paramQQEmoticonMainPanelApp.getQQAppInterface() != null)) {
            localArrayList.add(new EmotionPanelInfo(12, 4, null));
          }
        }
        else if ("camera".equals(localObject))
        {
          localObject = (CameraEmoRoamingManagerServiceProxy)paramQQEmoticonMainPanelApp.getRuntimeService(ICameraEmoRoamingManagerService.class);
          if ((localObject != null) && (((CameraEmoRoamingManagerServiceProxy)localObject).isShowCameraEmoInApp()) && (paramQQEmoticonMainPanelApp.getQQAppInterface() != null)) {
            localArrayList.add(new EmotionPanelInfo(11, 4, null));
          }
        }
        else if ("recommend".equals(localObject))
        {
          localObject = ((EmoticonManagerServiceProxy)paramQQEmoticonMainPanelApp.getRuntimeService(IEmoticonManagerService.class)).getProEmoticonPkgs(false, paramInt, paramBoolean);
          if ((localObject != null) && (((List)localObject).size() > 0)) {
            localArrayList.add(new EmotionPanelInfo(8, 3, null));
          }
        }
        else if (paramEmotionPanelInjectionInfoManager != null)
        {
          localObject = paramEmotionPanelInjectionInfoManager.a((String)localObject);
          if (localObject != null) {
            localArrayList.add(new EmotionPanelInfo(((EmotionInjectionInfo)localObject).emotionType, ((EmotionInjectionInfo)localObject).columnNum, null));
          }
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonUtils
 * JD-Core Version:    0.7.0.1
 */