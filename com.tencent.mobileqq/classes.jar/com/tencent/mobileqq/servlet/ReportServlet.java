package com.tencent.mobileqq.servlet;

import QQService.strupbuff;
import QQService.strupbuffResp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.report.StrupBuff;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class ReportServlet
  extends MSFServlet
{
  public String[] getPreferSSOCommands()
  {
    return new String[] { "CliLogSvc.UploadReq" };
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (("CliLogSvc.UploadReq".equals(paramFromServiceMsg.getServiceCmd())) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      boolean bool = paramFromServiceMsg.isSuccess();
      if (paramIntent.getExtras().getInt("seqKey") != 0) {
        notifyObserver(paramIntent, paramIntent.getExtras().getInt("sendType"), bool, paramIntent.getExtras(), null);
      }
      if (bool) {
        paramIntent = (strupbuffResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "DataResp", new strupbuffResp());
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getExtras().getInt("sendType");
    Object localObject1 = "GBK";
    Object localObject2 = "UTF-8";
    Object localObject6;
    Object localObject3;
    Object localObject7;
    Object localObject5;
    Object localObject4;
    switch (i)
    {
    case 5: 
    default: 
      return;
    case 10: 
      localObject6 = new strupbuff();
      ((strupbuff)localObject6).prefix = "";
      localObject3 = paramIntent.getExtras().getStringArrayList("tags");
      localObject7 = paramIntent.getExtras().getStringArrayList("contents");
      HashMap localHashMap = new HashMap();
      i = 0;
      localObject2 = null;
      while (i < ((List)localObject3).size())
      {
        String str = (String)((List)localObject3).get(i);
        localObject5 = (String)((List)localObject7).get(i);
        if (QLog.isColorLevel())
        {
          if (localObject2 == null) {
            localObject2 = new StringBuilder("[Capture Report Send:not runtime]:\n");
          }
          ((StringBuilder)localObject2).append("[");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append("]");
          ((StringBuilder)localObject2).append(" tag = ");
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append(", content = ");
          ((StringBuilder)localObject2).append((String)localObject5);
          ((StringBuilder)localObject2).append("\n");
        }
        if (ReportController.a(str)) {
          localObject4 = localObject1;
        } else {
          localObject4 = "UTF-8";
        }
        try
        {
          byte[] arrayOfByte = ((String)localObject5).getBytes((String)localObject4);
          localObject5 = (ArrayList)localHashMap.get(str);
          localObject4 = localObject5;
          if (localObject5 == null)
          {
            localObject4 = new ArrayList();
            localHashMap.put(str, localObject4);
          }
          ((ArrayList)localObject4).add(arrayOfByte);
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          break label325;
        }
        i += 1;
      }
      ((strupbuff)localObject6).logstring = new HashMap(localHashMap);
      ((strupbuff)localObject6).encoding = 0;
      ((strupbuff)localObject6).seqno = paramIntent.getExtras().getInt("seqKey");
      paramPacket.setSSOCommand("CliLogSvc.UploadReq");
      paramPacket.setServantName("QQService.CliLogSvc.MainServantObj");
      paramPacket.setFuncName("UploadReq");
      paramPacket.addRequestPacket("Data", (JceStruct)localObject6);
      paramPacket.setTimeout(30000L);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        QLog.d("CaptureReport", 2, ((StringBuilder)localObject2).toString());
        return;
      }
      break;
    case 9: 
      localObject1 = new StrupBuff();
      localObject2 = paramIntent.getExtras().getString("tag");
      ((StrupBuff)localObject1).prefix = "";
      localObject3 = paramIntent.getExtras().getByteArray("content");
      paramIntent = new ArrayList();
      paramIntent.add(localObject3);
      localObject3 = new HashMap();
      ((HashMap)localObject3).put(localObject2, paramIntent);
      ((StrupBuff)localObject1).logstring = new HashMap((Map)localObject3);
      ((StrupBuff)localObject1).encoding = 0;
      paramPacket.setSSOCommand("CliLogSvc.UploadReq");
      paramPacket.setServantName("QQService.CliLogSvc.MainServantObj");
      paramPacket.setFuncName("UploadReq");
      paramPacket.addRequestPacket("Data", (JceStruct)localObject1);
      paramPacket.setNoResponse();
      return;
    case 8: 
      localObject2 = new StrupBuff();
      ((StrupBuff)localObject2).prefix = "";
      localObject3 = paramIntent.getExtras().getStringArrayList("tags");
      localObject4 = paramIntent.getExtras().getStringArrayList("contents");
      localObject5 = new HashMap();
      i = 0;
      while (i < ((List)localObject3).size())
      {
        localObject6 = (String)((List)localObject3).get(i);
        paramIntent = (String)((List)localObject4).get(i);
        try
        {
          localObject7 = paramIntent.getBytes("utf-8");
          localObject1 = (ArrayList)((HashMap)localObject5).get(localObject6);
          paramIntent = (Intent)localObject1;
          if (localObject1 == null)
          {
            paramIntent = new ArrayList();
            ((HashMap)localObject5).put(localObject6, paramIntent);
          }
          paramIntent.add(localObject7);
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          long l1;
          long l2;
          boolean bool1;
          boolean bool2;
          break label678;
        }
        i += 1;
      }
      ((StrupBuff)localObject2).logstring = new HashMap((Map)localObject5);
      ((StrupBuff)localObject2).encoding = 2;
      paramPacket.setSSOCommand("CliLogSvc.UploadReq");
      paramPacket.setServantName("QQService.CliLogSvc.MainServantObj");
      paramPacket.setFuncName("UploadReq");
      paramPacket.addRequestPacket("Data", (JceStruct)localObject2);
      paramPacket.setNoResponse();
      return;
    case 7: 
      sendToMSF(paramIntent, MsfMsgUtil.getAppDataIncermentMsg(null, paramIntent.getStringExtra("uin"), paramIntent.getStringArrayExtra("tags"), paramIntent.getLongExtra("count", 0L)));
      return;
    case 6: 
      localObject1 = new StrupBuff();
      localObject2 = paramIntent.getExtras().getString("tag");
      ((StrupBuff)localObject1).prefix = "";
      localObject3 = paramIntent.getExtras().getStringArrayList("content");
      paramIntent = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        try
        {
          paramIntent.add(((String)localObject4).getBytes("utf-8"));
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          paramIntent.printStackTrace();
          return;
        }
      }
      localObject3 = new HashMap();
      ((HashMap)localObject3).put(localObject2, paramIntent);
      ((StrupBuff)localObject1).logstring = new HashMap((Map)localObject3);
      ((StrupBuff)localObject1).encoding = 2;
      paramPacket.setSSOCommand("CliLogSvc.UploadReq");
      paramPacket.setServantName("QQService.CliLogSvc.MainServantObj");
      paramPacket.setFuncName("UploadReq");
      paramPacket.addRequestPacket("Data", (JceStruct)localObject1);
      paramPacket.setNoResponse();
      return;
    case 4: 
      paramPacket = paramIntent.getExtras().getString("tagName");
      l1 = paramIntent.getExtras().getLong("duration");
      l2 = paramIntent.getExtras().getLong("size");
      bool1 = paramIntent.getExtras().getBoolean("success");
      localObject1 = (HashMap)paramIntent.getExtras().getSerializable("Params_MAP");
      bool2 = paramIntent.getExtras().getBoolean("realtime");
      localObject2 = new RdmReq();
      ((RdmReq)localObject2).eventName = paramPacket;
      ((RdmReq)localObject2).elapse = l1;
      ((RdmReq)localObject2).size = l2;
      ((RdmReq)localObject2).isSucceed = Boolean.valueOf(bool1).booleanValue();
      ((RdmReq)localObject2).isRealTime = Boolean.valueOf(bool2).booleanValue();
      ((RdmReq)localObject2).params = ((Map)localObject1);
      sendToMSF(paramIntent, MsfMsgUtil.getRdmReportMsg(null, (RdmReq)localObject2));
      return;
    case 3: 
      sendToMSF(paramIntent, MsfMsgUtil.getCurrentDataCountMsg(null, paramIntent.getStringArrayExtra("tags")));
      return;
    case 2: 
      label325:
      localObject3 = new StrupBuff();
      label678:
      localObject1 = paramIntent.getExtras().getString("tag");
      ((StrupBuff)localObject3).prefix = "";
      localObject4 = paramIntent.getExtras().getString("content");
      localObject5 = new ArrayList();
      paramIntent = (Intent)localObject2;
      if (ReportController.a((String)localObject1)) {
        paramIntent = "GBK";
      }
      try
      {
        ((ArrayList)localObject5).add(((String)localObject4).getBytes(paramIntent));
        paramIntent = new HashMap();
        paramIntent.put(localObject1, localObject5);
        ((StrupBuff)localObject3).logstring = new HashMap(paramIntent);
        ((StrupBuff)localObject3).encoding = 0;
        paramPacket.setSSOCommand("CliLogSvc.UploadReq");
        paramPacket.setServantName("QQService.CliLogSvc.MainServantObj");
        paramPacket.setFuncName("UploadReq");
        paramPacket.addRequestPacket("Data", (JceStruct)localObject3);
        paramPacket.setNoResponse();
        if ((QLog.isColorLevel()) && ("dc02181".equals(localObject1)))
        {
          paramIntent = new StringBuilder();
          paramIntent.append("[Capture Report Send:runtime] tag = ");
          paramIntent.append((String)localObject1);
          paramIntent.append(", content = ");
          paramIntent.append((String)localObject4);
          QLog.d("CaptureReport", 2, paramIntent.toString());
          return;
        }
      }
      catch (UnsupportedEncodingException paramIntent)
      {
        paramIntent.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.ReportServlet
 * JD-Core Version:    0.7.0.1
 */