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
  private static String b = "";
  private static String c = "";
  private static String d = "";
  private AccessReqHead a;
  
  public YYBInstallPackageReportRequest(long paramLong, ArrayList<String> paramArrayList)
  {
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    this.needCompress = false;
    this.a = new AccessReqHead();
    Object localObject = this.a;
    ((AccessReqHead)localObject).loginType = 1;
    ((AccessReqHead)localObject).uin = paramLong;
    ((AccessReqHead)localObject).terminal = new Terminal();
    this.a.terminal.imei = String.valueOf(a());
    this.a.terminal.macAddress = String.valueOf(c());
    this.a.terminal.androidId = String.valueOf(DeviceInfoUtil.j());
    this.a.terminal.imsi = String.valueOf(b());
    this.a.terminal.mode = String.valueOf(DeviceInfoUtil.u());
    this.a.terminal.manufacture = String.valueOf(DeviceInfoUtil.t());
    this.a.terminal.qimei = String.valueOf(UserAction.getQIMEI());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("YYBInstallPackageReportRequest qimei=");
      ((StringBuilder)localObject).append(this.a.terminal.qimei);
      QLog.d("YYBInstallPackageReportRequest", 1, ((StringBuilder)localObject).toString());
    }
    this.a.uniqueId = String.valueOf(MobileInfoUtil.getImei());
    this.a.uninstallPkgList = new ArrayList();
    this.a.uninstallPkgList.addAll(paramArrayList);
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
    String str = b;
    if ((str != null) && (str.length() > 0)) {
      return b;
    }
    try
    {
      b = QQDeviceInfo.getIMEI("b94d1a");
      label27:
      return b;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
  
  public static String b()
  {
    String str = c;
    if ((str != null) && (str.length() > 0)) {
      return c;
    }
    try
    {
      c = QQDeviceInfo.getIMSI("b94d1a");
      label27:
      return c;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
  
  public static String c()
  {
    String str = d;
    if ((str != null) && (str.length() > 0)) {
      return d;
    }
    try
    {
      d = QQDeviceInfo.getMAC("b94d1a");
      label27:
      return d;
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
    return this.a;
  }
  
  public String uniKey()
  {
    return "NewMobileReport";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.yyb.YYBInstallPackageReportRequest
 * JD-Core Version:    0.7.0.1
 */