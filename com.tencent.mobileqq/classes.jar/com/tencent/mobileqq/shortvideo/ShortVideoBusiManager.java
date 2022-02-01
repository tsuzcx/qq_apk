package com.tencent.mobileqq.shortvideo;

import com.tencent.device.file.DevLittleVideoSendOperator;
import com.tencent.device.file.DevShortVideoSendOperator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.api.IShortVideoFactory;
import com.tencent.mobileqq.shortvideo.api.IShortVideoOperator;

public class ShortVideoBusiManager
{
  public static ShortVideoForwardInfo a(int paramInt, Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    return a(paramInt, null).a(paramObject, paramShortVideoReq);
  }
  
  public static ShortVideoUploadInfo a(int paramInt, Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    return a(paramInt, null).a(paramObject, paramShortVideoReq);
  }
  
  public static ShortVideoUploadInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    return a(paramShortVideoReq.jdField_b_of_type_Int, null).a(paramObject, paramShortVideoReq);
  }
  
  static IShortVideoOperator a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 4: 
      if (paramQQAppInterface == null) {
        return new DevLittleVideoSendOperator();
      }
      return new DevLittleVideoSendOperator(paramQQAppInterface);
    case 1: 
      if (paramQQAppInterface == null) {
        return new DevShortVideoSendOperator();
      }
      return new DevShortVideoSendOperator(paramQQAppInterface);
    }
    return ((IShortVideoFactory)QRoute.api(IShortVideoFactory.class)).getAioShortVideoSendOperator(paramQQAppInterface);
  }
  
  public static void a(ShortVideoReq paramShortVideoReq, QQAppInterface paramQQAppInterface)
  {
    if (paramShortVideoReq == null)
    {
      Logger.b("ShortVideoBusiManager", "launch", "error,req == null");
      return;
    }
    if (paramShortVideoReq.jdField_a_of_type_Int == 2)
    {
      localObject = new BaseSVReceiveOperator(paramQQAppInterface);
      a(paramShortVideoReq, paramQQAppInterface, (IShortVideoOperator)localObject);
      ((BaseSVReceiveOperator)localObject).a(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo);
      return;
    }
    Object localObject = a(paramShortVideoReq.jdField_b_of_type_Int, paramQQAppInterface);
    if (localObject == null)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("error,operator == null,req.busiType:");
      paramQQAppInterface.append(paramShortVideoReq.jdField_b_of_type_Int);
      Logger.b("ShortVideoBusiManager", "launch", paramQQAppInterface.toString());
      return;
    }
    a(paramShortVideoReq, paramQQAppInterface, (IShortVideoOperator)localObject);
    int i = paramShortVideoReq.jdField_a_of_type_Int;
    if ((i != 0) && (i != 1))
    {
      if ((i != 3) && (i != 4))
      {
        if (i != 5) {
          return;
        }
        ((IShortVideoOperator)localObject).a(paramShortVideoReq.jdField_a_of_type_JavaUtilArrayList);
        return;
      }
      ((IShortVideoOperator)localObject).a(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo);
      return;
    }
    ((IShortVideoOperator)localObject).a(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo);
  }
  
  private static void a(ShortVideoReq paramShortVideoReq, QQAppInterface paramQQAppInterface, IShortVideoOperator paramIShortVideoOperator)
  {
    paramIShortVideoOperator.a(paramQQAppInterface);
    paramIShortVideoOperator.a(paramShortVideoReq);
    paramIShortVideoOperator.a(paramShortVideoReq.jdField_a_of_type_JavaLangString);
    paramIShortVideoOperator.b(paramShortVideoReq.jdField_b_of_type_JavaLangString);
    paramIShortVideoOperator.a(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack);
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("cmd:");
    paramQQAppInterface.append(SVUtils.c(paramShortVideoReq.jdField_a_of_type_Int));
    paramQQAppInterface.append(", reqBusiType");
    paramQQAppInterface.append(paramShortVideoReq.jdField_b_of_type_Int);
    paramQQAppInterface.append(", uuid:");
    paramQQAppInterface.append(paramShortVideoReq.jdField_a_of_type_JavaLangString);
    Logger.a("ShortVideoBusiManager", "launch", paramQQAppInterface.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoBusiManager
 * JD-Core Version:    0.7.0.1
 */