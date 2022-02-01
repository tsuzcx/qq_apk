package com.tencent.mobileqq.tablequery;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TableQueryServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    boolean bool1 = paramFromServiceMsg.isSuccess();
    if (bool1)
    {
      Object localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
      paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
      ((ByteBuffer)localObject).get(paramFromServiceMsg);
      localObject = new oidb_sso.OIDBSSOPkg();
      int i;
      ReportData.RspBody localRspBody;
      long l;
      try
      {
        ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramFromServiceMsg);
        i = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
        if (i == 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (!bool1) {}
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg) {}
    }
    try
    {
      localRspBody = new ReportData.RspBody();
      localRspBody.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray());
      l = localRspBody.ret.get();
      paramFromServiceMsg = localRspBody.msg.get().toByteArray();
      localObject = localRspBody.reportArray.get();
      bool2 = bool1;
      if (localObject == null) {
        break label436;
      }
      if (((List)localObject).size() == 0)
      {
        bool2 = bool1;
      }
      else
      {
        localObject = (ReportData.ReportDataItem)((List)localObject).get(0);
        localBundle.putLong("ret", l);
        localBundle.putByteArray("msg", paramFromServiceMsg);
        localBundle.putString("reqReportId", ((ReportData.ReportDataItem)localObject).reqReportId.get());
        localBundle.putString("reportId", ((ReportData.ReportDataItem)localObject).reportId.get());
        localBundle.putLong("pv", ((ReportData.ReportDataItem)localObject).pv.get());
        localBundle.putString("pv_day_earlier", ((ReportData.ReportDataItem)localObject).pv_day_earlier.get());
        localBundle.putString("pv_month_earlier", ((ReportData.ReportDataItem)localObject).pv_month_earlier.get());
        localBundle.putLong("uv", ((ReportData.ReportDataItem)localObject).uv.get());
        localBundle.putString("uv_day_earlier", ((ReportData.ReportDataItem)localObject).uv_day_earlier.get());
        localBundle.putString("uv_month_earlier", ((ReportData.ReportDataItem)localObject).uv_month_earlier.get());
        localBundle.putString("time", ((ReportData.ReportDataItem)localObject).time.get());
        localBundle.putString("param", ((ReportData.ReportDataItem)localObject).param.get());
        localBundle.putString("description", ((ReportData.ReportDataItem)localObject).description.get());
        bool2 = bool1;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      break label414;
    }
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("OIDBSSOPkg回包错误，Result: ");
    paramFromServiceMsg.append(i);
    QLog.d("TableQueryServlet", 1, paramFromServiceMsg.toString());
    boolean bool2 = bool1;
    break label436;
    label414:
    QLog.e("TableQueryServlet", 2, paramFromServiceMsg, new Object[0]);
    bool2 = bool1;
    break label436;
    bool2 = bool1;
    label436:
    notifyObserver(paramIntent, 0, bool2, localBundle, TableQueryObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    paramPacket.setSSOCommand("OidbSvc.0xd34_2");
    paramPacket.putSendData(WupUtil.a(paramIntent.getByteArrayExtra("RequestBytes")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.TableQueryServlet
 * JD-Core Version:    0.7.0.1
 */