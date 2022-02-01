package com.tencent.mobileqq.emoticonview;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emoticon.IEmotionPanelDataCallback;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmotionRoamingDBManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingDBManagerServiceProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class EmotionPanelDataBuilder
{
  public static final String TAG = "EmotionPanelDataBuilder";
  private static EmotionPanelDataBuilder sInstance;
  
  public static EmotionPanelDataBuilder getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new EmotionPanelDataBuilder();
        }
      }
      finally {}
    }
    return sInstance;
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
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getEmotionPanelData panelType = ");
      ((StringBuilder)localObject1).append(paramInt1);
      QLog.d("EmotionPanelDataBuilder", 2, ((StringBuilder)localObject1).toString());
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (EmoticonManagerServiceProxy)paramIEmoticonMainPanelApp.getRuntimeService(IEmoticonManagerService.class);
    switch (paramInt1)
    {
    case 10: 
    case 11: 
    default: 
      return localArrayList;
    case 13: 
      paramIEmoticonMainPanelApp = ((CameraEmotionRoamingDBManagerServiceProxy)paramIEmoticonMainPanelApp.getRuntimeService(ICameraEmotionRoamingDBManagerService.class)).syncGetCustomEmotionInfoShowedInPanel();
      paramEmoticonPackage = new CameraEmoticonInfo();
      paramEmoticonPackage.action = "cameraEdit";
      localArrayList.add(paramEmoticonPackage);
      paramEmoticonPackage = new CameraEmoticonInfo();
      paramEmoticonPackage.action = "cameraJump";
      localArrayList.add(paramEmoticonPackage);
      localObject1 = localArrayList;
      if (paramIEmoticonMainPanelApp != null)
      {
        if (paramIEmoticonMainPanelApp.size() > CameraEmoConstant.a)
        {
          localArrayList.addAll(new ArrayList(paramIEmoticonMainPanelApp.subList(0, CameraEmoConstant.a)));
          return localArrayList;
        }
        localArrayList.addAll(paramIEmoticonMainPanelApp);
        return localArrayList;
      }
      break;
    case 7: 
      localArrayList.add(new EmotionPanelData());
      return localArrayList;
    case 5: 
      paramIEmoticonMainPanelApp = new PicEmoticonInfo(paramIEmoticonMainPanelApp.getCurrentAccountUin());
      paramIEmoticonMainPanelApp.action = "push";
      paramEmoticonPackage = ((EmoticonManagerServiceProxy)localObject1).getMagicEmoticonInfoList(0);
      localArrayList.add(paramIEmoticonMainPanelApp);
      localArrayList.addAll(paramEmoticonPackage);
      return localArrayList;
    case 4: 
      paramEmoticonPackage = ((FavroamingDBManagerServiceProxy)paramIEmoticonMainPanelApp.getRuntimeService(IFavroamingDBManagerService.class)).syncGetCustomEmotionInfoShowedInPanel();
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
      localObject1 = localArrayList;
      if (paramEmoticonPackage != null)
      {
        if (paramEmoticonPackage.size() > FavEmoConstant.a)
        {
          localArrayList.addAll(new ArrayList(paramEmoticonPackage.subList(0, FavEmoConstant.a)));
          return localArrayList;
        }
        localArrayList.addAll(paramEmoticonPackage);
        return localArrayList;
      }
      break;
    case 3: 
      paramIEmoticonMainPanelApp = ((EmoticonManagerServiceProxy)localObject1).getProEmoticonPkgs(true, paramInt3, paramBoolean);
      localObject1 = localArrayList;
      if (paramIEmoticonMainPanelApp != null)
      {
        localArrayList.addAll(paramIEmoticonMainPanelApp);
        return localArrayList;
      }
      break;
    case 2: 
    case 6: 
    case 8: 
    case 9: 
    case 12: 
      if (paramEmoticonPackage != null)
      {
        if (TextUtils.isEmpty(paramEmoticonPackage.epId)) {
          return null;
        }
        List localList = ((EmoticonManagerServiceProxy)localObject1).syncGetSubEmoticonsByPackageId(paramEmoticonPackage.epId, true);
        if (paramEmoticonPackage.jobType == 4) {
          paramInt1 = 1;
        } else {
          paramInt1 = 0;
        }
        localObject1 = localArrayList;
        if (localList != null)
        {
          paramInt3 = localList.size();
          paramInt2 = 0;
          for (;;)
          {
            localObject1 = localArrayList;
            if (paramInt2 >= paramInt3) {
              break;
            }
            localObject1 = (Emoticon)localList.get(paramInt2);
            Object localObject2;
            if (paramInt1 != 0)
            {
              localObject2 = new SmallEmoticonInfo(paramIEmoticonMainPanelApp.getCurrentAccountUin());
              ((SmallEmoticonInfo)localObject2).type = 10;
              ((SmallEmoticonInfo)localObject2).imageType = paramEmoticonPackage.type;
              ((SmallEmoticonInfo)localObject2).emoticon = ((Emoticon)localObject1);
              localArrayList.add(localObject2);
            }
            else
            {
              localObject2 = new PicEmoticonInfo(paramIEmoticonMainPanelApp.getCurrentAccountUin());
              ((PicEmoticonInfo)localObject2).type = 6;
              ((PicEmoticonInfo)localObject2).imageType = paramEmoticonPackage.type;
              ((PicEmoticonInfo)localObject2).emoticon = ((Emoticon)localObject1);
              if (paramEmoticonPackage.isAPNG == 2) {
                paramBoolean = true;
              } else {
                paramBoolean = false;
              }
              ((PicEmoticonInfo)localObject2).isAPNG = paramBoolean;
              localArrayList.add(localObject2);
            }
            paramInt2 += 1;
          }
        }
      }
      else
      {
        return null;
      }
      break;
    case 1: 
      localObject1 = SystemAndEmojiEmoticonInfo.getEmoticonList(paramIEmoticonMainPanelApp, paramInt3);
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelDataBuilder
 * JD-Core Version:    0.7.0.1
 */