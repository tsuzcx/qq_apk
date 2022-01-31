package com.tencent.mobileqq.ocr;

import agau;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.cs.cmd0x6ff.subcmd0x533.HttpAROcrInfo;
import tencent.im.cs.cmd0x6ff.subcmd0x533.HttpAROcrResult;
import tencent.im.cs.cmd0x6ff.subcmd0x533.HttpCardV2;
import tencent.im.cs.cmd0x6ff.subcmd0x533.HttpClientRequestBodyV2;
import tencent.im.cs.cmd0x6ff.subcmd0x533.HttpDeviceV2;
import tencent.im.cs.cmd0x6ff.subcmd0x533.HttpServerResponseBodyV2;
import tencent.im.cs.cmd0x6ff.subcmd0x533.ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x533.RspBody;
import tencent.im.msg.im_msg_head.Head;
import tencent.im.msg.im_msg_head.HttpConnHead;
import tencent.im.msg.im_msg_head.LoginSig;
import tencent.im.oidb.cmd0x990.oidb_0x990.ReqBody;
import tencent.im.oidb.cmd0x990.oidb_0x990.RspBody;
import tencent.im.oidb.cmd0x990.oidb_0x990.TranslateReq;
import tencent.im.oidb.cmd0x990.oidb_0x990.TranslateRsp;

public class OCRHandler
  extends BusinessHandler
{
  private static int a;
  public static boolean a;
  
  public OCRHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private static int a()
  {
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i + 1;
    return i;
  }
  
  private void a(int paramInt, Intent paramIntent, byte[] paramArrayOfByte)
  {
    String str;
    long l;
    if (paramIntent != null)
    {
      str = paramIntent.getStringExtra("param_sougou_sessionid");
      l = paramIntent.getLongExtra("param_starttime", 0L);
    }
    for (;;)
    {
      OCRTextSearchInfo.SougouSearchInfo localSougouSearchInfo = null;
      if (paramInt == 0) {}
      int i;
      int j;
      try
      {
        paramIntent = new subcmd0x533.RspBody();
        paramIntent.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (subcmd0x533.HttpServerResponseBodyV2)((subcmd0x533.HttpAROcrResult)paramIntent.msg_ocr_result.get()).msg_sougou_rsp.get();
        if (paramArrayOfByte.has()) {
          i = paramArrayOfByte.int32_tencent_errorcode.get();
        }
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          label94:
          label239:
          boolean bool;
          i = 0;
          j = 0;
          paramArrayOfByte = localException;
        }
      }
      try
      {
        if (paramArrayOfByte.has())
        {
          j = paramArrayOfByte.int32_sougou_errorcode.get();
          if ((i != 0) || (j != 0)) {
            break label492;
          }
        }
      }
      catch (Exception paramIntent)
      {
        k = 0;
        j = i;
        i = k;
        paramArrayOfByte = localException;
        break label239;
      }
      try
      {
        paramIntent = new ArrayList();
        try
        {
          paramArrayOfByte = paramArrayOfByte.rpt_msg_cards.get().iterator();
          while (paramArrayOfByte.hasNext())
          {
            localSougouSearchInfo = OCRTextSearchInfo.a(((subcmd0x533.HttpCardV2)paramArrayOfByte.next()).rpt_msg_card_properties.get());
            if ((!TextUtils.isEmpty(localSougouSearchInfo.title)) || (!TextUtils.isEmpty(localSougouSearchInfo.abstractStr)))
            {
              paramIntent.add(localSougouSearchInfo);
              if (QLog.isColorLevel()) {
                QLog.d("Q.ocr.OCRHandler", 2, "handleSougouReqBigDataRsp info, " + localSougouSearchInfo);
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break label254;
          }
        }
        catch (Exception localException)
        {
          paramArrayOfByte = paramIntent;
          paramIntent = localException;
          k = j;
          j = i;
          i = k;
        }
      }
      catch (Exception paramIntent)
      {
        k = i;
        i = j;
        j = k;
        paramArrayOfByte = localException;
        break label239;
        j = 0;
        i = 0;
        break label292;
      }
      QLog.e("Q.ocr.OCRHandler", 2, "handleSougouReqBigDataRsp error", paramIntent);
      label254:
      int k = 0;
      paramIntent = paramArrayOfByte;
      bool = false;
      label262:
      a(1, bool, new Object[] { str, paramIntent });
      if (paramInt != 0)
      {
        i = 1;
        j = paramInt;
        label292:
        paramArrayOfByte = new HashMap();
        l = SystemClock.elapsedRealtime() - l;
        paramArrayOfByte.put("interval_time", String.valueOf(l));
        if (j != 0) {
          break label623;
        }
      }
      label492:
      label623:
      for (paramIntent = Integer.toString(j);; paramIntent = i + "_" + j)
      {
        paramArrayOfByte.put("param_FailCode", paramIntent);
        paramArrayOfByte.put("failReason", Integer.toString(j));
        paramArrayOfByte.put("errCodeType", Integer.toString(i));
        StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication()).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ocrTextSearch", bool, l, 0L, paramArrayOfByte, "");
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.OCRHandler", 2, "handleSougouReqBigDataRsp,errCode:" + paramInt + ", isSucc:" + bool + ", failCodeStr:" + paramIntent + ", size=" + k);
        }
        return;
        i = -1;
        break;
        j = -1;
        break label94;
        k = paramIntent.size();
        bool = true;
        for (;;)
        {
          m = i;
          i = j;
          j = m;
          break;
          bool = false;
          if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.OCRHandler", 2, "handleSougouReqBigDataRsp error, tencentCode=" + i + ",sougouErrCode=" + j + ",tencentDes=" + paramArrayOfByte.string_tencent_errormsg.get() + ",sougouErrDes=" + paramArrayOfByte.string_sougou_errormsg.get());
          }
          k = 0;
          paramIntent = null;
        }
        k = 0;
        j = 0;
        paramIntent = null;
        bool = false;
        i = 0;
        break label262;
        if (j != 0)
        {
          i = 2;
          break label292;
        }
        if (i == 0) {
          break label703;
        }
        int m = 3;
        j = i;
        i = m;
        break label292;
      }
      label703:
      l = 0L;
      str = null;
    }
  }
  
  private void a(int paramInt, Intent paramIntent, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Object localObject2 = null;
    long l = paramIntent.getLongExtra("param_subtype", 0L);
    if (QLog.isColorLevel()) {
      QLog.i("Q.ocr.OCRHandler", 2, "handleReqBigDataRsp, errorCode=" + paramInt);
    }
    Object localObject1 = localObject2;
    int i = paramInt;
    int j;
    if (paramInt == 0)
    {
      try
      {
        int k = paramArrayOfByte1.length;
        if ((paramArrayOfByte1[0] != 40) || (paramArrayOfByte1[(k - 1)] != 41))
        {
          localObject1 = "unexpected body data, len=" + k + ", data=";
          paramArrayOfByte2 = paramArrayOfByte1.toString();
          localObject1 = new StringBuilder().append((String)localObject1);
          paramArrayOfByte1 = paramArrayOfByte2;
          if (paramArrayOfByte2.length() > 20) {
            paramArrayOfByte1 = paramArrayOfByte2.substring(0, 20);
          }
          paramArrayOfByte1 = paramArrayOfByte1;
          a(-2, paramIntent, null, null);
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.e("Q.ocr.OCRHandler", 2, "handleReqBigDataRsp error, errorMsg=" + paramArrayOfByte1);
          return;
        }
        paramArrayOfByte1 = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte1));
        paramArrayOfByte1.readByte();
        i = paramArrayOfByte1.readInt();
        j = paramArrayOfByte1.readInt();
        if ((i <= k) && (j <= k)) {
          break label356;
        }
        a(-2, paramIntent, null, null);
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("Q.ocr.OCRHandler", 2, "handleReqBigDataRsp error, unexpected length, headLen=" + i + ", bodyLen=" + j);
        return;
      }
      catch (Exception paramArrayOfByte1)
      {
        paramInt = -10;
        localObject1 = localObject2;
        i = paramInt;
        if (QLog.isColorLevel())
        {
          QLog.e("Q.ocr.OCRHandler", 2, "handleReqBigDataRsp error", paramArrayOfByte1);
          i = paramInt;
          localObject1 = localObject2;
        }
      }
    }
    else
    {
      if (l != 2L) {
        return;
      }
      a(i, paramIntent, (byte[])localObject1);
      return;
    }
    label356:
    if (QLog.isColorLevel()) {
      QLog.i("Q.ocr.OCRHandler", 2, "handleReqBigDataRsp | headLen=" + i + " | bodyLen=" + j);
    }
    if (i > 0)
    {
      localObject1 = new byte[i];
      paramArrayOfByte1.read((byte[])localObject1);
      Object localObject3 = new im_msg_head.Head();
      ((im_msg_head.Head)localObject3).mergeFrom((byte[])localObject1);
      localObject1 = (im_msg_head.HttpConnHead)((im_msg_head.Head)localObject3).msg_httpconn_head.get();
      i = ((im_msg_head.HttpConnHead)localObject1).uint32_error_code.get();
      paramInt = i;
      if (QLog.isDevelopLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("uint64_uin=").append(((im_msg_head.HttpConnHead)localObject1).uint64_uin.get()).append(", uint32_command=").append(((im_msg_head.HttpConnHead)localObject1).uint32_command.get()).append(", uint32_sub_command=").append(((im_msg_head.HttpConnHead)localObject1).uint32_sub_command.get()).append(", uint32_seq=").append(((im_msg_head.HttpConnHead)localObject1).uint32_seq.get()).append(", uint32_version=").append(((im_msg_head.HttpConnHead)localObject1).uint32_version.get()).append(", uint32_retry_times=").append(((im_msg_head.HttpConnHead)localObject1).uint32_retry_times.get()).append(", uint32_client_type=").append(((im_msg_head.HttpConnHead)localObject1).uint32_client_type.get()).append(", uint32_pub_no=").append(((im_msg_head.HttpConnHead)localObject1).uint32_pub_no.get()).append(", uint32_local_id=").append(((im_msg_head.HttpConnHead)localObject1).uint32_local_id.get()).append(", uint32_time_zone=").append(((im_msg_head.HttpConnHead)localObject1).uint32_time_zone.get()).append(", uint32_client_ip=").append(((im_msg_head.HttpConnHead)localObject1).uint32_client_ip.get()).append(", uint32_client_port=").append(((im_msg_head.HttpConnHead)localObject1).uint32_client_port.get()).append(", uint32_qzhttp_ip=").append(((im_msg_head.HttpConnHead)localObject1).uint32_qzhttp_ip.get()).append(", uint32_qzhttp_port=").append(((im_msg_head.HttpConnHead)localObject1).uint32_qzhttp_port.get()).append(", uint32_spp_ip=").append(((im_msg_head.HttpConnHead)localObject1).uint32_spp_ip.get()).append(", uint32_spp_port=").append(((im_msg_head.HttpConnHead)localObject1).uint32_spp_port.get()).append(", uint32_flag=").append(((im_msg_head.HttpConnHead)localObject1).uint32_flag.get()).append(", bytes_key=").append(((im_msg_head.HttpConnHead)localObject1).bytes_key.get()).append(", uint32_compress_type=").append(((im_msg_head.HttpConnHead)localObject1).uint32_compress_type.get()).append(", uint32_origin_size=").append(((im_msg_head.HttpConnHead)localObject1).uint32_origin_size.get()).append(", uint32_error_code=").append(((im_msg_head.HttpConnHead)localObject1).uint32_error_code.get()).append(", uint32_command_id=").append(((im_msg_head.HttpConnHead)localObject1).uint32_command_id.get()).append(", uint32_service_cmdid=").append(((im_msg_head.HttpConnHead)localObject1).uint32_service_cmdid.get());
        QLog.i("Q.ocr.OCRHandler", 4, "handleReqBigData,  RspHttpConnHead=" + ((StringBuilder)localObject3).toString());
        paramInt = i;
      }
    }
    if ((j > 0) && (paramInt == 0))
    {
      localObject1 = new byte[j];
      paramArrayOfByte1.read((byte[])localObject1);
    }
    for (paramArrayOfByte1 = new Cryptor().decrypt((byte[])localObject1, paramArrayOfByte2);; paramArrayOfByte1 = null)
    {
      localObject1 = paramArrayOfByte1;
      i = paramInt;
      break;
    }
  }
  
  private void a(Intent paramIntent)
  {
    long l1 = paramIntent.getLongExtra("param_uin", 0L);
    Object localObject6 = paramIntent.getByteArrayExtra("param_reqbody");
    long l2 = paramIntent.getLongExtra("param_subtype", 0L);
    if ((l1 == 0L) || (localObject6 == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.ocr.OCRHandler", 2, "reqSouggouSearchBigData, uin or reqBody is null");
      }
    }
    for (;;)
    {
      return;
      Object localObject1 = "";
      Object localObject2 = ConfigManager.getInstance(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAppid(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).getNextSrvAddr(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (localObject2 != null) {
        localObject1 = "http://" + ((EndPoint)localObject2).host + ":" + ((EndPoint)localObject2).port + "/";
      }
      Object localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject3 = "http://htdata.qq.com/";
      }
      Object localObject4 = FMTSrvAddrProvider.a().b(l1);
      Object localObject5 = FMTSrvAddrProvider.a().a(l1);
      if (localObject4 != null)
      {
        localObject1 = localObject5;
        localObject2 = localObject4;
        if (localObject5 != null) {}
      }
      else
      {
        localObject1 = localObject5;
      }
      for (;;)
      {
        try
        {
          int i;
          if (SessionInfo.getInstance(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c()).getHttpconn_sig_session() != null)
          {
            i = SessionInfo.getInstance(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c()).getHttpconn_sig_session().length;
            localObject1 = new byte[i];
            System.arraycopy(SessionInfo.getInstance(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c()).getHttpconn_sig_session(), 0, localObject1, 0, i);
          }
          localObject2 = localObject4;
          if (SessionInfo.getInstance(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c()).getSessionKey() != null)
          {
            i = SessionInfo.getInstance(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c()).getSessionKey().length;
            localObject2 = new byte[i];
            System.arraycopy(SessionInfo.getInstance(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c()).getSessionKey(), 0, localObject2, 0, i);
          }
          if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (localObject1 != null)) {
            break;
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder().append("reqSouggouSearchBigData, host=").append((String)localObject3).append(",bkeyIsNull=");
            if (localObject2 == null)
            {
              bool = true;
              localObject2 = ((StringBuilder)localObject3).append(bool).append(",bSignIsNull=");
              if (localObject1 != null) {
                break label469;
              }
              bool = true;
              QLog.i("Q.ocr.OCRHandler", 2, bool);
            }
          }
          else
          {
            a(-1, paramIntent, null, null);
            return;
          }
        }
        finally {}
        boolean bool = false;
        continue;
        label469:
        bool = false;
      }
      localObject4 = new Cryptor().encrypt((byte[])localObject6, (byte[])localObject2);
      localObject5 = new im_msg_head.Head();
      ((im_msg_head.Head)localObject5).uint32_head_type.set(4);
      localObject6 = new im_msg_head.LoginSig();
      ((im_msg_head.LoginSig)localObject6).uint32_type.set(22);
      ((im_msg_head.LoginSig)localObject6).bytes_sig.set(ByteStringMicro.copyFrom((byte[])localObject1));
      ((im_msg_head.Head)localObject5).msg_login_sig.set((MessageMicro)localObject6);
      localObject1 = new im_msg_head.HttpConnHead();
      ((im_msg_head.HttpConnHead)localObject1).uint64_uin.set(l1);
      ((im_msg_head.HttpConnHead)localObject1).uint32_command.set(1791);
      ((im_msg_head.HttpConnHead)localObject1).uint32_sub_command.set(1331);
      ((im_msg_head.HttpConnHead)localObject1).uint32_seq.set(a());
      ((im_msg_head.HttpConnHead)localObject1).uint32_version.set(4643);
      ((im_msg_head.HttpConnHead)localObject1).uint32_flag.set(1);
      ((im_msg_head.HttpConnHead)localObject1).uint32_compress_type.set(0);
      ((im_msg_head.HttpConnHead)localObject1).uint32_error_code.set(0);
      ((im_msg_head.Head)localObject5).msg_httpconn_head.set((MessageMicro)localObject1);
      localObject5 = ((im_msg_head.Head)localObject5).toByteArray();
      localObject1 = new ByteArrayOutputStream();
      try
      {
        localObject6 = new DataOutputStream((OutputStream)localObject1);
        ((DataOutputStream)localObject6).write(40);
        ((DataOutputStream)localObject6).writeInt(localObject5.length);
        ((DataOutputStream)localObject6).writeInt(localObject4.length);
        ((DataOutputStream)localObject6).write((byte[])localObject5);
        ((DataOutputStream)localObject6).write((byte[])localObject4);
        ((DataOutputStream)localObject6).write(41);
        ((DataOutputStream)localObject6).flush();
        localObject4 = (String)localObject3 + "cgi-bin/httpconn";
        localObject5 = ((ByteArrayOutputStream)localObject1).toByteArray();
        localObject1 = new HttpNetReq();
        ((HttpNetReq)localObject1).jdField_a_of_type_ArrayOfByte = ((byte[])localObject5);
        ((HttpNetReq)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new agau(this, paramIntent, (byte[])localObject2, (String)localObject3);
        ((HttpNetReq)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject4);
        ((HttpNetReq)localObject1).jdField_a_of_type_Int = 1;
        ((HttpNetReq)localObject1).f = 57;
        ((HttpNetReq)localObject1).jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
        ((HttpNetReq)localObject1).jdField_c_of_type_Int = 2;
        ((HttpNetReq)localObject1).jdField_c_of_type_Long = 15000L;
        paramIntent = BaseApplicationImpl.sApplication.getRuntime();
        if ((paramIntent instanceof AppInterface))
        {
          ((AppInterface)paramIntent).getNetEngine(0).a((NetReq)localObject1);
          if (QLog.isColorLevel()) {
            QLog.i("Q.ocr.OCRHandler", 2, "reqSouggouSearchBigData send");
          }
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.ocr.OCRHandler", 2, "reqSouggouSearchBigData start, uin=" + l1 + ",subType=" + l2 + ",url=" + (String)localObject4 + ",testserver=" + jdField_a_of_type_Boolean);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.ocr.OCRHandler", 2, "reqSouggouSearchBigData", localException);
          }
          a(-10, paramIntent, null, null);
        }
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = true;
    oidb_0x990.RspBody localRspBody = new oidb_0x990.RspBody();
    int i = a(paramFromServiceMsg, paramObject, localRspBody);
    if (QLog.isColorLevel()) {
      QLog.i("Q.ocr.OCRHandler", 2, "handleTranslateResult, result = " + i);
    }
    paramFromServiceMsg = "";
    int j;
    if (i == 0)
    {
      paramFromServiceMsg = (oidb_0x990.TranslateRsp)localRspBody.msg_translate_rsp.get();
      j = paramFromServiceMsg.int32_ret_code.get();
      if (paramFromServiceMsg.bytes_trans_result == null) {
        break label291;
      }
    }
    label162:
    label291:
    for (paramFromServiceMsg = paramFromServiceMsg.bytes_trans_result.get().toStringUtf8();; paramFromServiceMsg = "")
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.ocr.OCRHandler", 2, "trans_ret_code = " + j + ", trans_ret_string = " + paramFromServiceMsg);
      }
      long l;
      if (j == 0)
      {
        a(2, true, paramFromServiceMsg);
        paramFromServiceMsg = String.valueOf(j);
        paramObject = new HashMap();
        l = paramToServiceMsg.extraData.getLong("param_starttime");
        l = SystemClock.elapsedRealtime() - l;
        paramObject.put("time_cost", String.valueOf(l));
        paramObject.put("errCode_qq", String.valueOf(i));
        paramObject.put("errCode_ai_lab", paramFromServiceMsg);
        paramToServiceMsg = StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication());
        paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (i != 0) {
          break label285;
        }
      }
      for (;;)
      {
        paramToServiceMsg.a(paramFromServiceMsg, "ocrTextTranslate", bool, l, 0L, paramObject, "");
        return;
        a(2, false, null);
        break;
        a(2, false, null);
        break label162;
        bool = false;
      }
    }
  }
  
  protected Class a()
  {
    return OCRObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str2 = paramToServiceMsg.extraData.getString("friendUin");
    String str1 = str2;
    if (str2 == null) {
      str1 = paramFromServiceMsg.getUin();
    }
    if (a(paramFromServiceMsg.getServiceCmd())) {}
    do
    {
      return;
      new Bundle().putString("uin", str1);
    } while (!"OidbSvc.0x990".equals(paramFromServiceMsg.getServiceCmd()));
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.ocr.OCRHandler", 2, "translate, text = " + paramString);
    }
    oidb_0x990.ReqBody localReqBody = new oidb_0x990.ReqBody();
    oidb_0x990.TranslateReq localTranslateReq = new oidb_0x990.TranslateReq();
    localTranslateReq.bytes_text.set(ByteStringMicro.copyFromUtf8(paramString));
    localTranslateReq.int32_type.set(0);
    localReqBody.msg_translate_req.set(localTranslateReq);
    paramString = a("OidbSvc.0x990", 2448, 1, localReqBody.toByteArray());
    paramString.extraData.putLong("param_starttime", SystemClock.elapsedRealtime());
    b(paramString);
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.OCRHandler", 2, "doSougouSearch start, sessionId=" + paramString1);
    }
    Object localObject1 = new subcmd0x533.HttpClientRequestBodyV2();
    Object localObject2 = new subcmd0x533.HttpDeviceV2();
    ((subcmd0x533.HttpDeviceV2)localObject2).platform.set(1);
    ((subcmd0x533.HttpClientRequestBodyV2)localObject1).msg_device.set((MessageMicro)localObject2);
    localObject2 = new ArrayList(1);
    ((List)localObject2).add(paramString2);
    ((subcmd0x533.HttpClientRequestBodyV2)localObject1).rpt_string_sentences.set((List)localObject2);
    ((subcmd0x533.HttpClientRequestBodyV2)localObject1).uint32_timeout_ms.set(3000);
    paramString2 = new subcmd0x533.HttpAROcrInfo();
    paramString2.uint64_ocr_recog_type.set(2L);
    paramString2.msg_sougou_req.set((MessageMicro)localObject1);
    localObject1 = new subcmd0x533.ReqBody();
    ((subcmd0x533.ReqBody)localObject1).string_session_id.set(paramString1);
    ((subcmd0x533.ReqBody)localObject1).uint64_req_recog_type.set(16L);
    ((subcmd0x533.ReqBody)localObject1).uint32_business_type.set(0);
    ((subcmd0x533.ReqBody)localObject1).string_clt_version.set(String.valueOf(AppSetting.jdField_a_of_type_Int));
    ((subcmd0x533.ReqBody)localObject1).msg_ocr_info.set(paramString2);
    paramString2 = new Intent();
    paramString2.putExtra("param_uin", Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
    paramString2.putExtra("param_reqbody", ((subcmd0x533.ReqBody)localObject1).toByteArray());
    paramString2.putExtra("param_subtype", 2L);
    paramString2.putExtra("param_sougou_sessionid", paramString1);
    paramString2.putExtra("param_starttime", paramLong);
    a(paramString2);
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x990");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRHandler
 * JD-Core Version:    0.7.0.1
 */