package com.tencent.mobileqq.intervideo.groupvideo.cschannel;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.biz.ProtoUtils;
import com.tencent.jungle.videohub.proto.CommProtocolProto.commRequest;
import com.tencent.jungle.videohub.proto.CommProtocolProto.commResponse;
import com.tencent.jungle.videohub.proto.CommonUserProto.LoginCheckReq;
import com.tencent.jungle.videohub.proto.CommonUserProto.LoginCheckRsp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import mqq.os.MqqHandler;

public class ODCsChannel
{
  private static final AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(1L);
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private CommonUserProto.LoginCheckRsp jdField_a_of_type_ComTencentJungleVideohubProtoCommonUserProto$LoginCheckRsp;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "videohub";
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public ODCsChannel(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this(paramQQAppInterface, paramLong, "OnlineDating", "Group");
  }
  
  public ODCsChannel(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    try
    {
      this.jdField_a_of_type_Long = Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  private long a()
  {
    if (this.jdField_a_of_type_ComTencentJungleVideohubProtoCommonUserProto$LoginCheckRsp != null) {
      return this.jdField_a_of_type_ComTencentJungleVideohubProtoCommonUserProto$LoginCheckRsp.uid.get();
    }
    return 0L;
  }
  
  private CommProtocolProto.commRequest a(int paramInt)
  {
    CommProtocolProto.commRequest localcommRequest = new CommProtocolProto.commRequest();
    localcommRequest.cmd.set(paramInt);
    localcommRequest.network.set(ODCsUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()));
    localcommRequest.seq.set(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndAdd(1L));
    localcommRequest.app_name.set(this.jdField_b_of_type_JavaLangString);
    localcommRequest.microtime.set(System.currentTimeMillis());
    localcommRequest.client_release.set("8.5.5");
    localcommRequest.from_id.set(this.c);
    localcommRequest.version.set(2);
    localcommRequest.client_type.set(2);
    localcommRequest.auth_appid.set(Long.valueOf("1104763709").longValue());
    localcommRequest.auth_type.set(1);
    localcommRequest.uin.set(this.jdField_a_of_type_Long);
    localcommRequest.openid.set(a());
    localcommRequest.auth_key.set(ByteStringMicro.copyFrom(b().getBytes()));
    localcommRequest.uid.set(a());
    localcommRequest.user_sig.set(c());
    return localcommRequest;
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      return this.jdField_a_of_type_AndroidOsBundle.getString("authid");
    }
    return "";
  }
  
  private void a(int paramInt, CommProtocolProto.commResponse paramcommResponse, Bundle paramBundle, ODCsChannel.CsChannelObserver paramCsChannelObserver)
  {
    StringBuilder localStringBuilder;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("notifyResult: errorCode=").append(paramInt).append(" bundle=");
      if (paramBundle == null)
      {
        localObject = "null";
        localStringBuilder = localStringBuilder.append((String)localObject).append(" commResponse=");
        if (paramcommResponse != null) {
          break label241;
        }
        localObject = "null";
        label59:
        QLog.d("ODCsChannel", 2, (String)localObject);
      }
    }
    else
    {
      if (paramcommResponse != null) {
        break label250;
      }
      label79:
      if (paramcommResponse != null) {
        break label261;
      }
      localObject = null;
      label86:
      if (paramBundle != null) {
        break label276;
      }
      paramBundle = new Bundle();
      label98:
      if (paramcommResponse != null)
      {
        paramBundle.putString("msg", paramcommResponse.msg.get());
        paramBundle.putLong("seq", paramcommResponse.seq.get());
        paramBundle.putByteArray("data", (byte[])localObject);
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("notifyResult: errorCode=").append(paramInt).append(" bundle=");
        if (paramBundle != null) {
          break label279;
        }
      }
    }
    label261:
    label276:
    label279:
    for (paramcommResponse = "null";; paramcommResponse = paramBundle.toString())
    {
      QLog.d("ODCsChannel", 2, paramcommResponse + " data=" + Arrays.toString((byte[])localObject));
      if (paramCsChannelObserver != null)
      {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label287;
        }
        paramCsChannelObserver.a(paramInt, (byte[])localObject, paramBundle);
      }
      return;
      localObject = paramBundle.toString();
      break;
      label241:
      localObject = paramcommResponse.toString();
      break label59;
      label250:
      paramInt = paramcommResponse.code.get();
      break label79;
      localObject = paramcommResponse.body.get().toByteArray();
      break label86;
      break label98;
    }
    label287:
    ThreadManager.getUIHandler().post(new ODCsChannel.4(this, paramCsChannelObserver, paramInt, (byte[])localObject, paramBundle));
  }
  
  private String b()
  {
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      return this.jdField_a_of_type_AndroidOsBundle.getString("authKey");
    }
    return "";
  }
  
  private void b(int paramInt1, byte[] paramArrayOfByte, boolean paramBoolean, int paramInt2, ODCsChannel.CsChannelObserver paramCsChannelObserver)
  {
    ThreadManagerV2.excute(new ODCsChannel.1(this, paramInt2, paramInt1, paramArrayOfByte, paramBoolean, paramCsChannelObserver), 128, null, true);
  }
  
  private String c()
  {
    if (this.jdField_a_of_type_ComTencentJungleVideohubProtoCommonUserProto$LoginCheckRsp != null) {
      return this.jdField_a_of_type_ComTencentJungleVideohubProtoCommonUserProto$LoginCheckRsp.user_sig.get();
    }
    return "";
  }
  
  private void c(int paramInt1, byte[] paramArrayOfByte, boolean paramBoolean, int paramInt2, ODCsChannel.CsChannelObserver paramCsChannelObserver)
  {
    CommProtocolProto.commRequest localcommRequest = a(paramInt1);
    if (paramArrayOfByte != null) {
      localcommRequest.body.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ODCsChannel.3(this, paramInt2, paramInt1, paramArrayOfByte, paramBoolean, paramCsChannelObserver), localcommRequest.toByteArray(), this.jdField_a_of_type_JavaLangString + "." + localcommRequest.cmd);
  }
  
  public void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, ODCsChannel.CsChannelObserver paramCsChannelObserver)
  {
    CommonUserProto.LoginCheckReq localLoginCheckReq = new CommonUserProto.LoginCheckReq();
    localLoginCheckReq.group_code.set(this.jdField_b_of_type_Long);
    localLoginCheckReq.refresh.set(false);
    localLoginCheckReq.is_test.set(true);
    CommProtocolProto.commRequest localcommRequest = a(10401);
    localcommRequest.body.set(ByteStringMicro.copyFrom(localLoginCheckReq.toByteArray()));
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ODCsChannel.2(this, paramInt2, paramInt1, paramArrayOfByte, paramCsChannelObserver), localcommRequest.toByteArray(), this.jdField_a_of_type_JavaLangString + "." + 10401);
  }
  
  public void a(int paramInt1, byte[] paramArrayOfByte, boolean paramBoolean, int paramInt2, ODCsChannel.CsChannelObserver paramCsChannelObserver)
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null)
    {
      b(paramInt1, paramArrayOfByte, paramBoolean, paramInt2, paramCsChannelObserver);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentJungleVideohubProtoCommonUserProto$LoginCheckRsp == null) && (paramBoolean))
    {
      a(paramInt1, paramArrayOfByte, paramInt2, paramCsChannelObserver);
      return;
    }
    c(paramInt1, paramArrayOfByte, paramBoolean, paramInt2, paramCsChannelObserver);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean, ODCsChannel.CsChannelObserver paramCsChannelObserver)
  {
    a(paramInt, paramArrayOfByte, paramBoolean, 0, paramCsChannelObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.cschannel.ODCsChannel
 * JD-Core Version:    0.7.0.1
 */