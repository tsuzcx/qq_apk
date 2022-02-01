package com.tencent.mobileqq.emoticonview;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emoticon.IEmotionPanelDataCallback;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmotionRoamingDBManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingDBManagerProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class EmotionPanelDataBuilder
{
  public static final String TAG = "EmotionPanelDataBuilder";
  private static EmotionPanelDataBuilder sInstance;
  
  public static EmotionPanelDataBuilder getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new EmotionPanelDataBuilder();
      }
      return sInstance;
    }
    finally {}
  }
  
  public void asyncGetEmotionPanelData(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt1, EmoticonPackage paramEmoticonPackage, int paramInt2, int paramInt3, boolean paramBoolean, IEmotionPanelDataCallback paramIEmotionPanelDataCallback)
  {
    if (paramIEmotionPanelDataCallback == null) {
      return;
    }
    ThreadManager.post(new EmotionPanelDataBuilder.1(this, paramIEmoticonMainPanelApp, paramInt1, paramEmoticonPackage, paramInt2, paramInt3, paramBoolean, paramIEmotionPanelDataCallback), 5, null, true);
  }
  
  public List<EmotionPanelData> syncGetEmotionPanelData(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt1, EmoticonPackage paramEmoticonPackage, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramIEmoticonMainPanelApp == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelDataBuilder", 2, "getEmotionPanelData panelType = " + paramInt1);
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (EmoticonManagerProxy)paramIEmoticonMainPanelApp.getManager(QQManagerFactory.EMOTICON_MANAGER);
    switch (paramInt1)
    {
    }
    Emoticon localEmoticon;
    label624:
    for (;;)
    {
      return localArrayList;
      return SystemAndEmojiEmoticonInfo.getEmoticonList(paramIEmoticonMainPanelApp, paramInt3);
      localArrayList.add(new EmotionPanelData());
      return localArrayList;
      paramEmoticonPackage = ((FavroamingDBManagerProxy)paramIEmoticonMainPanelApp.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER)).syncGetCustomEmotionInfoShowedInPanel();
      if (paramIEmoticonMainPanelApp.getQQAppInterface() != null)
      {
        paramIEmoticonMainPanelApp = new EmoticonInfo();
        paramIEmoticonMainPanelApp.action = "favEdit";
        localArrayList.add(paramIEmoticonMainPanelApp);
        if (paramInt2 != 1024)
        {
          paramIEmoticonMainPanelApp = new EmoticonInfo();
          paramIEmoticonMainPanelApp.action = "funny_pic";
          localArrayList.add(paramIEmoticonMainPanelApp);
        }
      }
      if (paramEmoticonPackage != null)
      {
        if (paramEmoticonPackage.size() > FavEmoConstant.a)
        {
          localArrayList.addAll(new ArrayList(paramEmoticonPackage.subList(0, FavEmoConstant.a)));
          return localArrayList;
        }
        localArrayList.addAll(paramEmoticonPackage);
        return localArrayList;
        paramIEmoticonMainPanelApp = ((CameraEmotionRoamingDBManagerProxy)paramIEmoticonMainPanelApp.getManager(QQManagerFactory.CAMERA_EMOTION_DB_MANAGER)).syncGetCustomEmotionInfoShowedInPanel();
        paramEmoticonPackage = new CameraEmoticonInfo();
        paramEmoticonPackage.action = "cameraEdit";
        localArrayList.add(paramEmoticonPackage);
        paramEmoticonPackage = new CameraEmoticonInfo();
        paramEmoticonPackage.action = "cameraJump";
        localArrayList.add(paramEmoticonPackage);
        if (paramIEmoticonMainPanelApp != null)
        {
          if (paramIEmoticonMainPanelApp.size() > CameraEmoConstant.a)
          {
            localArrayList.addAll(new ArrayList(paramIEmoticonMainPanelApp.subList(0, CameraEmoConstant.a)));
            return localArrayList;
          }
          localArrayList.addAll(paramIEmoticonMainPanelApp);
          return localArrayList;
          paramIEmoticonMainPanelApp = new PicEmoticonInfo(paramIEmoticonMainPanelApp.getCurrentAccountUin());
          paramIEmoticonMainPanelApp.action = "push";
          paramEmoticonPackage = ((EmoticonManagerProxy)localObject1).getMagicEmoticonInfoList(0);
          localArrayList.add(paramIEmoticonMainPanelApp);
          localArrayList.addAll(paramEmoticonPackage);
          return localArrayList;
          paramIEmoticonMainPanelApp = ((EmoticonManagerProxy)localObject1).getProEmoticonPkgs(true, paramInt3, paramBoolean);
          if (paramIEmoticonMainPanelApp != null)
          {
            localArrayList.addAll(paramIEmoticonMainPanelApp);
            return localArrayList;
            if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId))) {
              return null;
            }
            localObject1 = ((EmoticonManagerProxy)localObject1).syncGetSubEmoticonsByPackageId(paramEmoticonPackage.epId, true);
            if (paramEmoticonPackage.jobType == 4) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              if (localObject1 == null) {
                break label624;
              }
              paramInt3 = ((List)localObject1).size();
              paramInt2 = 0;
              while (paramInt2 < paramInt3)
              {
                localEmoticon = (Emoticon)((List)localObject1).get(paramInt2);
                if (paramInt1 == 0) {
                  break label626;
                }
                localObject2 = new SmallEmoticonInfo(paramIEmoticonMainPanelApp.getCurrentAccountUin());
                ((SmallEmoticonInfo)localObject2).type = 10;
                ((SmallEmoticonInfo)localObject2).imageType = paramEmoticonPackage.type;
                ((SmallEmoticonInfo)localObject2).emoticon = localEmoticon;
                localArrayList.add(localObject2);
                paramInt2 += 1;
              }
              break;
            }
          }
        }
      }
    }
    label626:
    Object localObject2 = new PicEmoticonInfo(paramIEmoticonMainPanelApp.getCurrentAccountUin());
    ((PicEmoticonInfo)localObject2).type = 6;
    ((PicEmoticonInfo)localObject2).imageType = paramEmoticonPackage.type;
    ((PicEmoticonInfo)localObject2).emoticon = localEmoticon;
    if (paramEmoticonPackage.isAPNG == 2) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((PicEmoticonInfo)localObject2).isAPNG = paramBoolean;
      localArrayList.add(localObject2);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelDataBuilder
 * JD-Core Version:    0.7.0.1
 */