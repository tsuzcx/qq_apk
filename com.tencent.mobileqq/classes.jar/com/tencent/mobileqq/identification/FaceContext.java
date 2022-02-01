package com.tencent.mobileqq.identification;

import android.content.Context;
import android.os.Bundle;
import com.dataline.util.DBNetworkUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.observer.LoginVerifyObserver;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

public class FaceContext
{
  private static volatile FaceContext jdField_a_of_type_ComTencentMobileqqIdentificationFaceContext;
  public static final List<String> a;
  public static final List<String> b = Arrays.asList(new String[] { "setFaceData", "changeSecureMobile", "deleteFace", "identify" });
  public static final List<String> c = Arrays.asList(new String[] { "loginVerify", "identifyNoLogin" });
  public static final List<String> d = Arrays.asList(new String[] { "loginVerify", "changeSecureMobile" });
  public static final List<String> e = Arrays.asList(new String[] { "identify", "identifyNoLogin" });
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_JavaUtilList = Arrays.asList(new String[] { "loginVerify", "identify", "changeSecureMobile", "identifyNoLogin" });
  }
  
  public static FaceContext a()
  {
    if (jdField_a_of_type_ComTencentMobileqqIdentificationFaceContext == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqIdentificationFaceContext == null) {
        jdField_a_of_type_ComTencentMobileqqIdentificationFaceContext = new FaceContext();
      }
      return jdField_a_of_type_ComTencentMobileqqIdentificationFaceContext;
    }
    finally {}
  }
  
  public IFaceStrategy a()
  {
    if ((this.jdField_a_of_type_Int == 11) || (this.jdField_a_of_type_Int == 0)) {
      return new UsableStrategy();
    }
    if (this.jdField_a_of_type_Int == 10)
    {
      this.jdField_a_of_type_JavaLangString = "根据当地法规，人脸识别功能无法启用";
      return new UnusableStrategy(this.jdField_a_of_type_JavaLangString);
    }
    QLog.d("FaceContext", 1, new Object[] { "unknown usable state : ", Integer.valueOf(this.jdField_a_of_type_Int) });
    return null;
  }
  
  public void a(int paramInt, String paramString1, String paramString2, LoginVerifyObserver paramLoginVerifyObserver)
  {
    QLog.d("FaceContext", 1, "start refreshIpStateOnSubProcess");
    Bundle localBundle = new Bundle();
    localBundle.putString("method", paramString2);
    localBundle.putInt("srcAppId", paramInt);
    localBundle.putString("uin", paramString1);
    QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_face_usable", localBundle, new FaceContext.2(this, paramLoginVerifyObserver));
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, LoginVerifyObserver paramLoginVerifyObserver)
  {
    a(paramQQAppInterface, paramContext, paramInt, paramString, null, paramLoginVerifyObserver);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, LoginVerifyObserver paramLoginVerifyObserver)
  {
    paramLoginVerifyObserver = new FaceContext.1(this, paramLoginVerifyObserver);
    QLog.d("FaceContext", 1, "start refreshIpState");
    if (b.contains(paramString1)) {
      LoginVerifyServlet.a(paramQQAppInterface, paramInt, paramLoginVerifyObserver);
    }
    while (!c.contains(paramString1)) {
      return;
    }
    paramContext = DBNetworkUtil.a(false);
    paramQQAppInterface = null;
    long l1;
    if (IPAddressUtil.isIPv4LiteralAddress(paramContext))
    {
      paramQQAppInterface = IPAddressUtil.textToNumericFormatV4(paramContext);
      QLog.d("FaceContext", 1, "v4");
      paramContext = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        paramContext = new byte[0];
      }
      l1 = 0L;
      if (paramString2 != null) {
        break label135;
      }
      l1 = 0L;
    }
    for (;;)
    {
      LoginVerifyServlet.a(paramInt, paramContext, l1, paramLoginVerifyObserver);
      return;
      if (!IPAddressUtil.isIPv6LiteralAddress(paramContext)) {
        break;
      }
      paramQQAppInterface = IPAddressUtil.textToNumericFormatV6(paramContext);
      QLog.e("FaceContext", 1, "v6");
      break;
      try
      {
        label135:
        long l2 = Long.parseLong(paramString2);
        l1 = l2;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.d("FaceContext", 1, new Object[] { "parse uin error, ", paramQQAppInterface.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.identification.FaceContext
 * JD-Core Version:    0.7.0.1
 */