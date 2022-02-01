package com.tencent.mobileqq.emosm.cameraemotionroaming;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CameraEmoRoamingHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.CaptureContext;
import dov.com.qq.im.capture.control.CaptureAsyncControl;
import java.util.ArrayList;
import java.util.List;

public class CameraEmoSendControl
{
  private static int jdField_a_of_type_Int = -1;
  private static CameraEmoSendControl jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoSendControl;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  public CaptureAsyncControl a;
  
  public CameraEmoSendControl()
  {
    this.jdField_a_of_type_DovComQqImCaptureControlCaptureAsyncControl = new CaptureAsyncControl();
  }
  
  private int a()
  {
    Object localObject = (CameraEmotionRoamingDBManager)a().getManager(QQManagerFactory.CAMERA_EMOTION_DB_MANAGER);
    if (jdField_a_of_type_Int == -1)
    {
      jdField_a_of_type_Int = 1;
      localObject = ((CameraEmotionRoamingDBManager)localObject).a();
      if (localObject != null)
      {
        i = 0;
        while (i < ((List)localObject).size())
        {
          int j = ((CameraEmotionData)((List)localObject).get(i)).emoId;
          if (jdField_a_of_type_Int < j) {
            jdField_a_of_type_Int = j;
          }
          i += 1;
        }
      }
    }
    int i = jdField_a_of_type_Int + 1;
    jdField_a_of_type_Int = i;
    return i;
  }
  
  private CameraEmotionData a(String paramString1, String paramString2, String paramString3)
  {
    CameraEmotionData localCameraEmotionData = new CameraEmotionData();
    localCameraEmotionData.uin = a().getCurrentAccountUin();
    localCameraEmotionData.emoPath = paramString1;
    localCameraEmotionData.RomaingType = "needUpload";
    localCameraEmotionData.strContext = paramString2;
    localCameraEmotionData.templateId = paramString3;
    return localCameraEmotionData;
  }
  
  private CameraEmotionData a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    CameraEmotionData localCameraEmotionData = new CameraEmotionData();
    localCameraEmotionData.uin = a().getCurrentAccountUin();
    localCameraEmotionData.emoOriginalPath = paramString1;
    localCameraEmotionData.thumbPath = paramString3;
    localCameraEmotionData.RomaingType = "needUpload";
    localCameraEmotionData.strContext = paramString2;
    localCameraEmotionData.templateId = paramString4;
    return localCameraEmotionData;
  }
  
  public static CameraEmoSendControl a()
  {
    if (jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoSendControl == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoSendControl == null) {
        jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoSendControl = new CameraEmoSendControl();
      }
      return jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoSendControl;
    }
  }
  
  public QQAppInterface a()
  {
    return (QQAppInterface)CaptureContext.a();
  }
  
  public void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3)
  {
    Object localObject = a();
    if (localObject == null)
    {
      QLog.d("CameraEmoSendControl", 1, "app null");
      return;
    }
    CameraEmotionRoamingDBManager localCameraEmotionRoamingDBManager = (CameraEmotionRoamingDBManager)((QQAppInterface)localObject).getManager(QQManagerFactory.CAMERA_EMOTION_DB_MANAGER);
    localObject = (CameraEmoRoamingHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.CAMERA_EMOTICON_HANDLER);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList1.size())
    {
      CameraEmotionData localCameraEmotionData = a((String)paramArrayList1.get(i), (String)paramArrayList2.get(i), (String)paramArrayList3.get(i));
      localCameraEmotionData.emoId = a();
      localCameraEmotionRoamingDBManager.c(localCameraEmotionData);
      localArrayList.add(localCameraEmotionData);
      i += 1;
    }
    ((CameraEmoRoamingHandler)localObject).notifyUI(4, true, null);
    if (QLog.isColorLevel()) {
      QLog.d("CameraEmoSendControl", 2, "doStep, insert completed");
    }
    this.jdField_a_of_type_DovComQqImCaptureControlCaptureAsyncControl.a(String.valueOf(1011), new Object[] { localArrayList });
  }
  
  public void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3, ArrayList<String> paramArrayList4)
  {
    Object localObject = a();
    CameraEmotionRoamingDBManager localCameraEmotionRoamingDBManager = (CameraEmotionRoamingDBManager)((QQAppInterface)localObject).getManager(QQManagerFactory.CAMERA_EMOTION_DB_MANAGER);
    localObject = (CameraEmoRoamingHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.CAMERA_EMOTICON_HANDLER);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList1.size())
    {
      CameraEmotionData localCameraEmotionData = a((String)paramArrayList1.get(i), (String)paramArrayList2.get(i), (String)paramArrayList3.get(i), (String)paramArrayList4.get(i));
      localCameraEmotionData.emoId = a();
      localCameraEmotionRoamingDBManager.c(localCameraEmotionData);
      localArrayList.add(localCameraEmotionData);
      i += 1;
    }
    ((CameraEmoRoamingHandler)localObject).notifyUI(4, true, null);
    if (QLog.isColorLevel()) {
      QLog.d("CameraEmoSendControl", 2, "doStep, insert completed");
    }
    this.jdField_a_of_type_DovComQqImCaptureControlCaptureAsyncControl.a(String.valueOf(1011), new Object[] { localArrayList });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSendControl
 * JD-Core Version:    0.7.0.1
 */