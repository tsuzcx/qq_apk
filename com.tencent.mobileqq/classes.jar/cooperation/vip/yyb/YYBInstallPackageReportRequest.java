package cooperation.vip.yyb;

import NS_NEW_MOBILE_REPORT.AccessReqHead;
import NS_NEW_MOBILE_REPORT.AccessRspHead;
import NS_NEW_MOBILE_REPORT.Terminal;
import com.qq.taf.jce.JceStruct;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

public class YYBInstallPackageReportRequest
  extends QzoneExternalRequest
{
  private static String jdField_a_of_type_JavaLangString = "";
  private static String b = "";
  private static String c = "";
  private AccessReqHead jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead;
  
  public YYBInstallPackageReportRequest(long paramLong, ArrayList<String> paramArrayList)
  {
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    this.needCompress = false;
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead = new AccessReqHead();
    Object localObject = this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead;
    ((AccessReqHead)localObject).loginType = 1;
    ((AccessReqHead)localObject).uin = paramLong;
    ((AccessReqHead)localObject).terminal = new Terminal();
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.terminal.imei = String.valueOf(a());
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.terminal.macAddress = String.valueOf(c());
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.terminal.androidId = String.valueOf(DeviceInfoUtil.f());
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.terminal.imsi = String.valueOf(b());
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.terminal.mode = String.valueOf(DeviceInfoUtil.i());
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.terminal.manufacture = String.valueOf(DeviceInfoUtil.h());
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.terminal.qimei = String.valueOf(UserAction.getQIMEI());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("YYBInstallPackageReportRequest qimei=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.terminal.qimei);
      QLog.d("YYBInstallPackageReportRequest", 1, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.uniqueId = String.valueOf(MobileInfoUtil.getImei());
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.uninstallPkgList = new ArrayList();
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.uninstallPkgList.addAll(paramArrayList);
  }
  
  public static AccessRspHead a(byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = (AccessRspHead)decode(paramArrayOfByte, "NewMobileReport", paramArrayOfInt);
    if (paramArrayOfByte == null) {
      return null;
    }
    return paramArrayOfByte;
  }
  
  public static String a()
  {
    String str = jdField_a_of_type_JavaLangString;
    if ((str != null) && (str.length() > 0)) {
      return jdField_a_of_type_JavaLangString;
    }
    try
    {
      jdField_a_of_type_JavaLangString = QQDeviceInfo.getIMEI("b94d1a");
      label27:
      return jdField_a_of_type_JavaLangString;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
  
  public static String b()
  {
    String str = b;
    if ((str != null) && (str.length() > 0)) {
      return b;
    }
    try
    {
      b = QQDeviceInfo.getIMSI("b94d1a");
      label27:
      return b;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
  
  public static String c()
  {
    String str = c;
    if ((str != null) && (str.length() > 0)) {
      return c;
    }
    try
    {
      c = QQDeviceInfo.getMAC("b94d1a");
      label27:
      return c;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
  
  public String getCmdString()
  {
    return "MobileReport.NewMobileReport";
  }
  
  public JceStruct getReq()
  {
    return this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead;
  }
  
  public String uniKey()
  {
    return "NewMobileReport";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.yyb.YYBInstallPackageReportRequest
 * JD-Core Version:    0.7.0.1
 */