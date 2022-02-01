package com.tencent.mobileqq.tablequery;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TableQueryManager
  implements Manager
{
  private TableQueryObserver a;
  
  public void a(QQAppInterface paramQQAppInterface, ReportData.ReqBody paramReqBody)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), TableQueryServlet.class);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(3380);
    localOIDBSSOPkg.uint32_service_type.set(2);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramReqBody.toByteArray()));
    localNewIntent.setObserver(this.a);
    localNewIntent.putExtra("RequestBytes", localOIDBSSOPkg.toByteArray());
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    ReportData.ReqMqqParam localReqMqqParam = new ReportData.ReqMqqParam();
    localReqMqqParam.department.set(paramString2);
    localReqMqqParam.opername.set(paramString3);
    localReqMqqParam.action.set(paramString4);
    if (this.a == null) {
      this.a = new TableQueryObserver();
    }
    try
    {
      paramString2 = new ReportData.ReqBody();
      paramString3 = new ArrayList();
      paramString3.add(paramString1);
      paramString2.reportId.set(paramString3);
      paramString2.type.set(paramInt);
      paramString1 = new ArrayList();
      paramString1.add(localReqMqqParam);
      paramString2.params.set(paramString1);
      a(paramQQAppInterface, paramString2);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("TableQueryManager", 1, paramQQAppInterface.toString());
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.TableQueryManager
 * JD-Core Version:    0.7.0.1
 */