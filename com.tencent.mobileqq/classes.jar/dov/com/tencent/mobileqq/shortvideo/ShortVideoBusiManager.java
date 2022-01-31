package dov.com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.qphone.base.util.QLog;

public class ShortVideoBusiManager
{
  public static long a;
  public static boolean a;
  
  static BaseShortVideoOprerator a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    switch (paramInt)
    {
    case 1: 
    case 4: 
    default: 
      return null;
    }
    return new AioShortVideoOperator(paramQQAppInterface);
  }
  
  static InfoBuilder a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 4: 
    default: 
      return null;
    }
    return new AioShortVideoOperator();
  }
  
  public static ShortVideoReq a(int paramInt1, int paramInt2)
  {
    ShortVideoReq localShortVideoReq = new ShortVideoReq();
    localShortVideoReq.jdField_a_of_type_Int = paramInt1;
    localShortVideoReq.jdField_b_of_type_Int = paramInt2;
    return localShortVideoReq;
  }
  
  public static ShortVideoReq a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoBusiManager", 2, "createShortVideoReqByMsg expired");
      }
      return null;
    }
    paramQQAppInterface = a(2, paramMessageForShortVideo.busiType);
    paramQQAppInterface.a(paramMessageForShortVideo);
    return paramQQAppInterface;
  }
  
  public static ShortVideoUploadInfo a(int paramInt, Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    InfoBuilder localInfoBuilder = a(paramInt);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramObject, paramShortVideoReq);
  }
  
  public static ShortVideoUploadInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    InfoBuilder localInfoBuilder = a(paramShortVideoReq.jdField_b_of_type_Int);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramObject, paramShortVideoReq);
  }
  
  public static void a(ShortVideoReq paramShortVideoReq, QQAppInterface paramQQAppInterface)
  {
    if (paramShortVideoReq == null)
    {
      Logger.b("ShortVideoBusiManager", "launch", "error,req == null");
      return;
    }
    BaseShortVideoOprerator localBaseShortVideoOprerator = a(paramShortVideoReq.jdField_b_of_type_Int, paramQQAppInterface);
    if (localBaseShortVideoOprerator == null)
    {
      Logger.b("ShortVideoBusiManager", "launch", "error,busiInterface == null,req.busiType:" + paramShortVideoReq.jdField_b_of_type_Int);
      return;
    }
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localBaseShortVideoOprerator.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoReq = paramShortVideoReq;
    localBaseShortVideoOprerator.jdField_a_of_type_JavaLangString = paramShortVideoReq.jdField_a_of_type_JavaLangString;
    localBaseShortVideoOprerator.jdField_b_of_type_JavaLangString = paramShortVideoReq.jdField_b_of_type_JavaLangString;
    localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_DovComTencentMobileqqShortvideoUiCallBack);
    Logger.a("ShortVideoBusiManager", "launch", "cmd:" + ShortVideoUtils.c(paramShortVideoReq.jdField_a_of_type_Int) + ", reqBusiType" + paramShortVideoReq.jdField_b_of_type_Int + ", uuid:" + paramShortVideoReq.jdField_a_of_type_JavaLangString);
    switch (paramShortVideoReq.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoUploadInfo);
      return;
    case 2: 
      localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoDownloadInfo);
      return;
    case 1: 
      localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoUploadInfo);
      return;
    case 3: 
      localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoForwardInfo);
      return;
    case 4: 
      localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoForwardInfo);
      return;
    }
    localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ShortVideoBusiManager
 * JD-Core Version:    0.7.0.1
 */