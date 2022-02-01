package com.tencent.mobileqq.emosm.cameraemotionroaming;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.CameraEmoRoamingHandler;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emosm.control.EmoCaptureAsyncControl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

public class CameraEmoSendControl
  implements ICameraEmoSendControl
{
  private static int b = -1;
  private static Object c = new Object();
  private static CameraEmoSendControl d;
  public EmoCaptureAsyncControl a = new EmoCaptureAsyncControl();
  
  private CameraEmotionData a(String paramString1, String paramString2, String paramString3)
  {
    CameraEmotionData localCameraEmotionData = new CameraEmotionData();
    localCameraEmotionData.uin = b().getCurrentAccountUin();
    localCameraEmotionData.emoPath = paramString1;
    localCameraEmotionData.RomaingType = "needUpload";
    localCameraEmotionData.strContext = paramString2;
    localCameraEmotionData.templateId = paramString3;
    return localCameraEmotionData;
  }
  
  private CameraEmotionData a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    CameraEmotionData localCameraEmotionData = new CameraEmotionData();
    localCameraEmotionData.uin = b().getCurrentAccountUin();
    localCameraEmotionData.emoOriginalPath = paramString1;
    localCameraEmotionData.thumbPath = paramString3;
    localCameraEmotionData.RomaingType = "needUpload";
    localCameraEmotionData.strContext = paramString2;
    localCameraEmotionData.templateId = paramString4;
    return localCameraEmotionData;
  }
  
  public static CameraEmoSendControl a()
  {
    if (d == null) {
      synchronized (c)
      {
        if (d == null) {
          d = new CameraEmoSendControl();
        }
      }
    }
    return d;
  }
  
  private int c()
  {
    Object localObject = (ICameraEmotionRoamingDBManagerService)b().getRuntimeService(ICameraEmotionRoamingDBManagerService.class);
    if (b == -1)
    {
      b = 1;
      localObject = ((ICameraEmotionRoamingDBManagerService)localObject).getEmoticonDataList();
      if (localObject != null)
      {
        i = 0;
        while (i < ((List)localObject).size())
        {
          int j = ((CameraEmotionData)((List)localObject).get(i)).emoId;
          if (b < j) {
            b = j;
          }
          i += 1;
        }
      }
    }
    int i = b + 1;
    b = i;
    return i;
  }
  
  public void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3)
  {
    Object localObject = b();
    if (localObject == null)
    {
      QLog.d("CameraEmoSendControl", 1, "app null");
      return;
    }
    ICameraEmotionRoamingDBManagerService localICameraEmotionRoamingDBManagerService = (ICameraEmotionRoamingDBManagerService)((BaseQQAppInterface)localObject).getRuntimeService(ICameraEmotionRoamingDBManagerService.class);
    localObject = (CameraEmoRoamingHandler)((BaseQQAppInterface)localObject).getBusinessHandler(CameraEmoRoamingHandler.a);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList1.size())
    {
      CameraEmotionData localCameraEmotionData = a((String)paramArrayList1.get(i), (String)paramArrayList2.get(i), (String)paramArrayList3.get(i));
      localCameraEmotionData.emoId = c();
      localICameraEmotionRoamingDBManagerService.insertCustomEmotion(localCameraEmotionData);
      localArrayList.add(localCameraEmotionData);
      i += 1;
    }
    ((CameraEmoRoamingHandler)localObject).notifyUI(4, true, null);
    if (QLog.isColorLevel()) {
      QLog.d("CameraEmoSendControl", 2, "doStep, insert completed");
    }
    this.a.a(String.valueOf(1000), new Object[] { localArrayList });
  }
  
  public void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3, ArrayList<String> paramArrayList4)
  {
    Object localObject = b();
    ICameraEmotionRoamingDBManagerService localICameraEmotionRoamingDBManagerService = (ICameraEmotionRoamingDBManagerService)((BaseQQAppInterface)localObject).getRuntimeService(ICameraEmotionRoamingDBManagerService.class);
    localObject = (CameraEmoRoamingHandler)((BaseQQAppInterface)localObject).getBusinessHandler(CameraEmoRoamingHandler.a);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList1.size())
    {
      CameraEmotionData localCameraEmotionData = a((String)paramArrayList1.get(i), (String)paramArrayList2.get(i), (String)paramArrayList3.get(i), (String)paramArrayList4.get(i));
      localCameraEmotionData.emoId = c();
      localICameraEmotionRoamingDBManagerService.insertCustomEmotion(localCameraEmotionData);
      localArrayList.add(localCameraEmotionData);
      i += 1;
    }
    ((CameraEmoRoamingHandler)localObject).notifyUI(4, true, null);
    if (QLog.isColorLevel()) {
      QLog.d("CameraEmoSendControl", 2, "doStep, insert completed");
    }
    this.a.a(String.valueOf(1000), new Object[] { localArrayList });
  }
  
  public BaseQQAppInterface b()
  {
    return (BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSendControl
 * JD-Core Version:    0.7.0.1
 */