package com.tencent.mobileqq.nearby;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.HotchatPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.IOldBigDataChannelManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.json.JSONObject;
import tencent.im.cs.cmd0x6ff.subcmd0x501.ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.RspBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody.IpAddr;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody.SrvAddrs;
import tencent.im.msg.im_msg_head.Head;
import tencent.im.msg.im_msg_head.HttpConnHead;
import tencent.im.msg.im_msg_head.LoginSig;
import tencent.im.msg.im_msg_head.TransOidbHead;
import tencent.im.oidb.cmd0x6b2.oidb_cmd0x6b2.ReqBody;
import tencent.im.oidb.cmd0x6b2.oidb_cmd0x6b2.RspBody;

public class NearbyAlumniServlet
  extends MSFServlet
{
  private static int jdField_a_of_type_Int = 0;
  static final Object jdField_a_of_type_JavaLangObject = NearbyAlumniServletUtils.jdField_a_of_type_JavaLangObject;
  static HashMap<String, Object> jdField_a_of_type_JavaUtilHashMap = NearbyAlumniServletUtils.jdField_a_of_type_JavaUtilHashMap;
  
  private static int a()
  {
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i + 1;
    return i;
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt1 >> 8 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt1 >> 16 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt1 >> 24 & 0xFF);
    return a(localStringBuilder.toString(), paramInt2);
  }
  
  public static String a(String paramString, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer(200);
    localStringBuffer.append("http://");
    localStringBuffer.append(paramString);
    if (paramInt != 80)
    {
      localStringBuffer.append(":");
      localStringBuffer.append(paramInt);
    }
    localStringBuffer.append("/");
    return localStringBuffer.toString();
  }
  
  private void a(Intent paramIntent, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("respGetNearbyAlumni, errorCode = ");
      localStringBuilder.append(paramInt);
      QLog.i("NearbyAlumniServlet", 2, localStringBuilder.toString());
    }
    paramIntent.getStringExtra("param_req_json_string");
    String str2 = paramIntent.getStringExtra("param_callback_key");
    String str1 = paramIntent.getStringExtra("param_callback_id");
    StringBuilder localStringBuilder = null;
    int i = paramInt;
    if (paramInt == 0) {}
    label1161:
    label1302:
    for (;;)
    {
      try
      {
        int k = paramArrayOfByte1.length;
        if ((paramArrayOfByte1[0] == 40) && (paramArrayOfByte1[(k - 1)] == 41))
        {
          paramIntent = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte1));
          paramIntent.readByte();
          i = paramIntent.readInt();
          int j = paramIntent.readInt();
          if ((i <= k) && (j <= k))
          {
            if (QLog.isColorLevel())
            {
              paramArrayOfByte1 = new StringBuilder();
              paramArrayOfByte1.append("respGetNearbyAlumni | headLen=");
              paramArrayOfByte1.append(i);
              paramArrayOfByte1.append(" | bodyLen=");
              paramArrayOfByte1.append(j);
              QLog.i("NearbyAlumniServlet", 2, paramArrayOfByte1.toString());
            }
            if (i > 0)
            {
              paramArrayOfByte1 = new byte[i];
              paramIntent.read(paramArrayOfByte1);
              Object localObject = new im_msg_head.Head();
              ((im_msg_head.Head)localObject).mergeFrom(paramArrayOfByte1);
              localObject = (im_msg_head.HttpConnHead)((im_msg_head.Head)localObject).msg_httpconn_head.get();
              paramInt = ((im_msg_head.HttpConnHead)localObject).uint32_error_code.get();
              if (!QLog.isDevelopLevel()) {
                break label1302;
              }
              paramArrayOfByte1 = new StringBuilder();
              paramArrayOfByte1.append("uint64_uin=");
              paramArrayOfByte1.append(((im_msg_head.HttpConnHead)localObject).uint64_uin.get());
              paramArrayOfByte1.append(", uint32_command=");
              paramArrayOfByte1.append(((im_msg_head.HttpConnHead)localObject).uint32_command.get());
              paramArrayOfByte1.append(", uint32_sub_command=");
              paramArrayOfByte1.append(((im_msg_head.HttpConnHead)localObject).uint32_sub_command.get());
              paramArrayOfByte1.append(", uint32_seq=");
              paramArrayOfByte1.append(((im_msg_head.HttpConnHead)localObject).uint32_seq.get());
              paramArrayOfByte1.append(", uint32_version=");
              paramArrayOfByte1.append(((im_msg_head.HttpConnHead)localObject).uint32_version.get());
              paramArrayOfByte1.append(", uint32_retry_times=");
              paramArrayOfByte1.append(((im_msg_head.HttpConnHead)localObject).uint32_retry_times.get());
              paramArrayOfByte1.append(", uint32_client_type=");
              paramArrayOfByte1.append(((im_msg_head.HttpConnHead)localObject).uint32_client_type.get());
              paramArrayOfByte1.append(", uint32_pub_no=");
              paramArrayOfByte1.append(((im_msg_head.HttpConnHead)localObject).uint32_pub_no.get());
              paramArrayOfByte1.append(", uint32_local_id=");
              paramArrayOfByte1.append(((im_msg_head.HttpConnHead)localObject).uint32_local_id.get());
              paramArrayOfByte1.append(", uint32_time_zone=");
              paramArrayOfByte1.append(((im_msg_head.HttpConnHead)localObject).uint32_time_zone.get());
              paramArrayOfByte1.append(", uint32_client_ip=");
              paramArrayOfByte1.append(((im_msg_head.HttpConnHead)localObject).uint32_client_ip.get());
              paramArrayOfByte1.append(", uint32_client_port=");
              paramArrayOfByte1.append(((im_msg_head.HttpConnHead)localObject).uint32_client_port.get());
              paramArrayOfByte1.append(", uint32_qzhttp_ip=");
              paramArrayOfByte1.append(((im_msg_head.HttpConnHead)localObject).uint32_qzhttp_ip.get());
              paramArrayOfByte1.append(", uint32_qzhttp_port=");
              paramArrayOfByte1.append(((im_msg_head.HttpConnHead)localObject).uint32_qzhttp_port.get());
              paramArrayOfByte1.append(", uint32_spp_ip=");
              paramArrayOfByte1.append(((im_msg_head.HttpConnHead)localObject).uint32_spp_ip.get());
              paramArrayOfByte1.append(", uint32_spp_port=");
              paramArrayOfByte1.append(((im_msg_head.HttpConnHead)localObject).uint32_spp_port.get());
              paramArrayOfByte1.append(", uint32_flag=");
              paramArrayOfByte1.append(((im_msg_head.HttpConnHead)localObject).uint32_flag.get());
              paramArrayOfByte1.append(", bytes_key=");
              paramArrayOfByte1.append(((im_msg_head.HttpConnHead)localObject).bytes_key.get());
              paramArrayOfByte1.append(", uint32_compress_type=");
              paramArrayOfByte1.append(((im_msg_head.HttpConnHead)localObject).uint32_compress_type.get());
              paramArrayOfByte1.append(", uint32_origin_size=");
              paramArrayOfByte1.append(((im_msg_head.HttpConnHead)localObject).uint32_origin_size.get());
              paramArrayOfByte1.append(", uint32_error_code=");
              paramArrayOfByte1.append(((im_msg_head.HttpConnHead)localObject).uint32_error_code.get());
              paramArrayOfByte1.append(", uint32_command_id=");
              paramArrayOfByte1.append(((im_msg_head.HttpConnHead)localObject).uint32_command_id.get());
              paramArrayOfByte1.append(", uint32_service_cmdid=");
              paramArrayOfByte1.append(((im_msg_head.HttpConnHead)localObject).uint32_service_cmdid.get());
              localObject = (im_msg_head.TransOidbHead)((im_msg_head.HttpConnHead)localObject).msg_oidbhead.get();
              if (localObject != null)
              {
                paramArrayOfByte1.append(", TransOidbHead=[");
                paramArrayOfByte1.append("uint32_command=");
                paramArrayOfByte1.append(((im_msg_head.TransOidbHead)localObject).uint32_command.get());
                paramArrayOfByte1.append("|uint32_service_type=");
                paramArrayOfByte1.append(((im_msg_head.TransOidbHead)localObject).uint32_service_type.get());
                paramArrayOfByte1.append("|uint32_result=");
                paramArrayOfByte1.append(((im_msg_head.TransOidbHead)localObject).uint32_result.get());
                paramArrayOfByte1.append("|str_error_msg=");
                paramArrayOfByte1.append(((im_msg_head.TransOidbHead)localObject).str_error_msg.get());
                paramArrayOfByte1.append("]");
              }
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("HttpConnHead=");
              ((StringBuilder)localObject).append(paramArrayOfByte1.toString());
              QLog.i("NearbyAlumniServlet", 4, ((StringBuilder)localObject).toString());
              break label1302;
            }
            i = paramInt;
            if (j > 0)
            {
              i = paramInt;
              if (paramInt == 0)
              {
                paramArrayOfByte1 = new byte[j];
                paramIntent.read(paramArrayOfByte1);
                paramIntent = new Cryptor().decrypt(paramArrayOfByte1, paramArrayOfByte2);
                paramArrayOfByte1 = new oidb_cmd0x6b2.RspBody();
                paramArrayOfByte1.mergeFrom(paramIntent);
                paramIntent = paramArrayOfByte1.bytes_body.get().toStringUtf8();
                break label1161;
              }
            }
          }
          else
          {
            paramIntent = new StringBuilder();
            paramIntent.append("unexpected length, headLen=");
            paramIntent.append(i);
            paramIntent.append(", bodyLen=");
            paramIntent.append(j);
            throw new RuntimeException(paramIntent.toString());
          }
        }
        else
        {
          paramIntent = new StringBuilder();
          paramIntent.append("unexpected body data, len=");
          paramIntent.append(k);
          paramIntent.append(", data=");
          paramIntent = paramIntent.toString();
          paramArrayOfByte1 = paramArrayOfByte1.toString();
          paramArrayOfByte2 = new StringBuilder();
          paramArrayOfByte2.append(paramIntent);
          paramIntent = paramArrayOfByte1;
          if (paramArrayOfByte1.length() > 20) {
            paramIntent = paramArrayOfByte1.substring(0, 20);
          }
          paramArrayOfByte2.append(paramIntent);
          throw new RuntimeException(paramArrayOfByte2.toString());
        }
      }
      catch (Exception paramIntent)
      {
        if (QLog.isColorLevel())
        {
          paramArrayOfByte1 = new StringBuilder();
          paramArrayOfByte1.append("respGetNearbyAlumni | Exception:");
          paramArrayOfByte1.append(paramIntent.getMessage());
          QLog.i("NearbyAlumniServlet", 2, paramArrayOfByte1.toString());
        }
        paramIntent = null;
        paramInt = -10;
      }
      paramIntent = null;
      paramInt = i;
      paramArrayOfByte2 = jdField_a_of_type_JavaLangObject;
      paramArrayOfByte1 = localStringBuilder;
      try
      {
        if (jdField_a_of_type_JavaUtilHashMap != null) {
          paramArrayOfByte1 = jdField_a_of_type_JavaUtilHashMap.remove(str2);
        }
        if (NearbyUtils.b()) {
          NearbyUtils.a("NearbyAlumniServlet", new Object[] { "respGetNearbyAlumni", Integer.valueOf(paramInt), paramArrayOfByte1 });
        }
        if ((paramArrayOfByte1 instanceof HotchatPlugin))
        {
          paramArrayOfByte1 = (HotchatPlugin)paramArrayOfByte1;
          try
          {
            paramArrayOfByte2 = new JSONObject();
            paramArrayOfByte2.put("resultCode", paramInt);
            paramArrayOfByte2.put("data", paramIntent);
            paramIntent = paramArrayOfByte2.toString();
          }
          catch (Exception paramIntent)
          {
            paramIntent.printStackTrace();
            paramIntent = "";
          }
          paramArrayOfByte1.callJs(str1, new String[] { paramIntent });
        }
        return;
      }
      finally {}
    }
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1;
    if (paramFromServiceMsg.isSuccess()) {
      localObject1 = new subcmd0x501.RspBody();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        localObject2 = new byte[paramFromServiceMsg.getInt() - 4];
        paramFromServiceMsg.get((byte[])localObject2);
        ((subcmd0x501.RspBody)localObject1).mergeFrom((byte[])localObject2);
        localObject2 = (subcmd0x501.SubCmd0x501Rspbody)((subcmd0x501.RspBody)localObject1).msg_subcmd_0x501_rsp_body.get();
        paramFromServiceMsg = ((subcmd0x501.SubCmd0x501Rspbody)localObject2).bytes_session_key.get();
        if ((paramFromServiceMsg == null) || (paramFromServiceMsg.toByteArray().length <= 0)) {
          break label341;
        }
        paramFromServiceMsg = paramFromServiceMsg.toByteArray();
        localObject1 = ((subcmd0x501.SubCmd0x501Rspbody)localObject2).bytes_httpconn_sig_session.get();
        if ((localObject1 == null) || (((ByteStringMicro)localObject1).toByteArray().length <= 0)) {
          break label346;
        }
        localObject1 = ((ByteStringMicro)localObject1).toByteArray();
        localObject2 = ((subcmd0x501.SubCmd0x501Rspbody)localObject2).rpt_msg_httpconn_addrs.get();
        if ((localObject2 == null) || (((List)localObject2).size() == 0)) {
          break label352;
        }
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label352;
        }
        Object localObject3 = (subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)((Iterator)localObject2).next();
        if (((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject3).uint32_service_type.get() != 5) {
          continue;
        }
        List localList = ((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject3).rpt_msg_addrs.get();
        if ((localList == null) || (localList.size() == 0)) {
          break label352;
        }
        localObject3 = new String[localList.size()];
        int i = 0;
        localObject2 = localObject3;
        if (i < localList.size())
        {
          localObject2 = (subcmd0x501.SubCmd0x501Rspbody.IpAddr)localList.get(i);
          localObject3[i] = a(((subcmd0x501.SubCmd0x501Rspbody.IpAddr)localObject2).uint32_ip.get(), ((subcmd0x501.SubCmd0x501Rspbody.IpAddr)localObject2).uint32_port.get());
          i += 1;
          continue;
        }
        localObject3 = a();
        if (localObject3 != null) {
          ((IOldBigDataChannelManager)localObject3).saveSrvParam(paramFromServiceMsg, (byte[])localObject1, (String[])localObject2);
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyAlumniServlet", 2, paramFromServiceMsg.getMessage());
        }
      }
      a(paramIntent, null, true);
      return;
      label341:
      paramFromServiceMsg = null;
      continue;
      label346:
      localObject1 = null;
      continue;
      label352:
      Object localObject2 = null;
    }
  }
  
  private boolean a(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyAlumniServlet", 2, "request get ip list");
    }
    long l = paramIntent.getLongExtra("param_uin", 0L);
    if (l == 0L) {
      return false;
    }
    paramIntent = new subcmd0x501.SubCmd0x501ReqBody();
    paramIntent.uint64_uin.set(l);
    paramIntent.uint32_idc_id.set(0);
    paramIntent.uint32_appid.set(16);
    paramIntent.uint32_login_sig_type.set(1);
    paramIntent.uint32_request_flag.set(3);
    Object localObject = new ArrayList();
    ((List)localObject).add(Integer.valueOf(5));
    paramIntent.rpt_uint32_service_types.set((List)localObject);
    localObject = new subcmd0x501.ReqBody();
    ((subcmd0x501.ReqBody)localObject).msg_subcmd_0x501_req_body.set(paramIntent);
    paramPacket.setSSOCommand("HttpConn.0x6ff_501");
    paramIntent = ((subcmd0x501.ReqBody)localObject).toByteArray();
    localObject = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject).put(paramIntent);
    paramPacket.putSendData(((ByteBuffer)localObject).array());
    return true;
  }
  
  protected IOldBigDataChannelManager a()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof INearbyAppInterface)) {
      return (IOldBigDataChannelManager)localAppRuntime.getManager(NearbyConstants.g);
    }
    if ((localAppRuntime instanceof BrowserAppInterface)) {
      return ((BrowserAppInterface)localAppRuntime).a();
    }
    return null;
  }
  
  protected void a(Intent paramIntent, Packet paramPacket, boolean paramBoolean)
  {
    long l = paramIntent.getLongExtra("param_uin", 0L);
    int i = paramIntent.getIntExtra("param_subcmd", 0);
    if (NearbyUtils.b()) {
      NearbyUtils.a("NearbyAlumniServlet", new Object[] { "reqBigData", Integer.valueOf(i), Long.valueOf(l) });
    }
    Object localObject2 = paramIntent.getStringExtra("param_req_json_string");
    if (l != 0L)
    {
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return;
      }
      Object localObject3 = a();
      Object localObject1;
      if (localObject3 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((IOldBigDataChannelManager)localObject3).getSrvKey();
      }
      if (localObject1 == null)
      {
        if (paramBoolean)
        {
          a(null, -1, null, null);
          return;
        }
        a(paramIntent, paramPacket);
        return;
      }
      Object localObject4 = new oidb_cmd0x6b2.ReqBody();
      ((oidb_cmd0x6b2.ReqBody)localObject4).bytes_body.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localObject4 = new Cryptor().encrypt(((oidb_cmd0x6b2.ReqBody)localObject4).toByteArray(), (byte[])localObject1);
      Object localObject5 = new im_msg_head.Head();
      ((im_msg_head.Head)localObject5).uint32_head_type.set(4);
      Object localObject6 = new im_msg_head.LoginSig();
      ((im_msg_head.LoginSig)localObject6).uint32_type.set(22);
      if (localObject3 == null) {
        localObject2 = null;
      } else {
        localObject2 = ((IOldBigDataChannelManager)localObject3).getSrvSig();
      }
      if (localObject2 != null)
      {
        ((im_msg_head.LoginSig)localObject6).bytes_sig.set(ByteStringMicro.copyFrom((byte[])localObject2));
        ((im_msg_head.Head)localObject5).msg_login_sig.set((MessageMicro)localObject6);
        localObject2 = new im_msg_head.HttpConnHead();
        ((im_msg_head.HttpConnHead)localObject2).uint64_uin.set(l);
        ((im_msg_head.HttpConnHead)localObject2).uint32_command.set(1791);
        ((im_msg_head.HttpConnHead)localObject2).uint32_sub_command.set(3088);
        ((im_msg_head.HttpConnHead)localObject2).uint32_seq.set(a());
        ((im_msg_head.HttpConnHead)localObject2).uint32_version.set(4643);
        ((im_msg_head.HttpConnHead)localObject2).uint32_flag.set(1);
        ((im_msg_head.HttpConnHead)localObject2).uint32_compress_type.set(0);
        ((im_msg_head.HttpConnHead)localObject2).uint32_error_code.set(0);
        localObject6 = new im_msg_head.TransOidbHead();
        ((im_msg_head.TransOidbHead)localObject6).uint32_command.set(1714);
        ((im_msg_head.TransOidbHead)localObject6).uint32_service_type.set(i);
        ((im_msg_head.HttpConnHead)localObject2).msg_oidbhead.set((MessageMicro)localObject6);
        ((im_msg_head.Head)localObject5).msg_httpconn_head.set((MessageMicro)localObject2);
        localObject2 = ((im_msg_head.Head)localObject5).toByteArray();
        localObject5 = new ByteArrayOutputStream();
        try
        {
          localObject6 = new DataOutputStream((OutputStream)localObject5);
          ((DataOutputStream)localObject6).write(40);
          ((DataOutputStream)localObject6).writeInt(localObject2.length);
          ((DataOutputStream)localObject6).writeInt(localObject4.length);
          ((DataOutputStream)localObject6).write((byte[])localObject2);
          ((DataOutputStream)localObject6).write((byte[])localObject4);
          ((DataOutputStream)localObject6).write(41);
          ((DataOutputStream)localObject6).flush();
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.i("NearbyAlumniServlet", 2, localException.getMessage());
          }
          a(paramIntent, -10, null, null);
        }
        String str;
        if (localObject3 == null) {
          str = null;
        } else {
          str = ((IOldBigDataChannelManager)localObject3).getCircleSrvUrl();
        }
        if ((str != null) && (str.length() != 0))
        {
          paramPacket = new StringBuilder();
          paramPacket.append(str);
          paramPacket.append("cgi-bin/httpconn");
          str = paramPacket.toString();
          localObject3 = ((ByteArrayOutputStream)localObject5).toByteArray();
          paramPacket = new HttpNetReq();
          paramPacket.mSendData = ((byte[])localObject3);
          paramPacket.mCallback = new NearbyAlumniServlet.NearbyAlumniDownloadListener(this, paramIntent, (byte[])localObject1);
          paramPacket.mReqUrl = str;
          paramPacket.mHttpMethod = 1;
          paramPacket.mFileType = 131080;
          paramPacket.mReqProperties.put("Accept-Encoding", "identity");
          paramPacket.mContinuErrorLimit = 2;
          paramPacket.mExcuteTimeLimit = 15000L;
          paramIntent = getAppRuntime();
          if ((paramIntent instanceof AppInterface))
          {
            paramIntent = (AppInterface)paramIntent;
            localObject1 = (IHttpEngineService)paramIntent.getRuntimeService(IHttpEngineService.class, "all");
            ((IHttpEngineService)localObject1).sendReq(paramPacket);
            if (NearbyUtils.b()) {
              NearbyUtils.a("NearbyAlumniServlet", new Object[] { "getBigData", localObject1, paramIntent });
            }
          }
          return;
        }
        if (paramBoolean)
        {
          a(null, -1, null, null);
          return;
        }
        a(paramIntent, paramPacket);
        return;
      }
      if (paramBoolean)
      {
        a(null, -1, null, null);
        return;
      }
      a(paramIntent, paramPacket);
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str2 = paramFromServiceMsg.getServiceCmd();
    if (str2 == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      boolean bool = paramFromServiceMsg.isSuccess();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resp:");
      localStringBuilder.append(str2);
      localStringBuilder.append(" is ");
      String str1;
      if (bool) {
        str1 = "";
      } else {
        str1 = "not";
      }
      localStringBuilder.append(str1);
      localStringBuilder.append(" success");
      QLog.i("NearbyAlumniServlet", 2, localStringBuilder.toString());
    }
    if (str2.equals("HttpConn.0x6ff_501")) {
      a(paramIntent, paramFromServiceMsg);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if ((paramIntent != null) && (paramIntent.getIntExtra("param_cmd", 0) == 1714)) {
      a(paramIntent, paramPacket, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyAlumniServlet
 * JD-Core Version:    0.7.0.1
 */