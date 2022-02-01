package com.tencent.mobileqq.intervideo.groupvideo.cschannel.impl;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.jungle.videohub.proto.CommProtocolProto.commRequest;
import com.tencent.jungle.videohub.proto.CommProtocolProto.commResponse;
import com.tencent.jungle.videohub.proto.CommonUserProto.LoginCheckReq;
import com.tencent.jungle.videohub.proto.CommonUserProto.LoginCheckRsp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.groupvideo.cschannel.IODCsChannel;
import com.tencent.mobileqq.intervideo.groupvideo.cschannel.IODCsChannel.CsChannelObserver;
import com.tencent.mobileqq.intervideo.groupvideo.cschannel.ODCsUtil;
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
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ODCsChannelImpl
  implements IODCsChannel
{
  private static final int DEFAULT_RETRY_TIMES = 0;
  private static final int ERROR_CODE_ACCESS_TOKEN_INVALID = 1008;
  private static final int ERROR_CODE_DATA_PARSE_ERROR = -10;
  private static final int ERROR_CODE_USER_SIG_INVALID = 1006;
  private static final String TAG = "ODCsChannel";
  private static final AtomicLong mCommRequestSequence = new AtomicLong(1L);
  private Bundle mAccessToken;
  private String mAppName;
  private String mFromId;
  private long mGroupUin;
  private CommonUserProto.LoginCheckRsp mLoginCheckRsp;
  private QQAppInterface mQQApp;
  private String mServiceName = "videohub";
  private long mUin;
  
  public ODCsChannelImpl() {}
  
  public ODCsChannelImpl(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this(paramQQAppInterface, paramLong, "OnlineDating", "Group");
  }
  
  public ODCsChannelImpl(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2)
  {
    this.mQQApp = paramQQAppInterface;
    this.mGroupUin = paramLong;
    this.mAppName = paramString1;
    this.mFromId = paramString2;
    try
    {
      this.mUin = Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  private CommProtocolProto.commRequest buildCommRequest(int paramInt)
  {
    CommProtocolProto.commRequest localcommRequest = new CommProtocolProto.commRequest();
    localcommRequest.cmd.set(paramInt);
    localcommRequest.network.set(ODCsUtil.a(this.mQQApp.getApp()));
    localcommRequest.seq.set(mCommRequestSequence.getAndAdd(1L));
    localcommRequest.app_name.set(this.mAppName);
    localcommRequest.microtime.set(System.currentTimeMillis());
    localcommRequest.client_release.set("8.8.17");
    localcommRequest.from_id.set(this.mFromId);
    localcommRequest.version.set(2);
    localcommRequest.client_type.set(2);
    localcommRequest.auth_appid.set(Long.valueOf("1104763709").longValue());
    localcommRequest.auth_type.set(1);
    localcommRequest.uin.set(this.mUin);
    localcommRequest.openid.set(getAuthId());
    localcommRequest.auth_key.set(ByteStringMicro.copyFrom(getAuthKey().getBytes()));
    localcommRequest.uid.set(getUid());
    localcommRequest.user_sig.set(getUserSig());
    return localcommRequest;
  }
  
  private void getAccessToken(int paramInt1, byte[] paramArrayOfByte, boolean paramBoolean, int paramInt2, IODCsChannel.CsChannelObserver paramCsChannelObserver)
  {
    ThreadManagerV2.excute(new ODCsChannelImpl.1(this, paramInt2, paramInt1, paramArrayOfByte, paramBoolean, paramCsChannelObserver), 128, null, true);
  }
  
  private String getAuthId()
  {
    Bundle localBundle = this.mAccessToken;
    if (localBundle != null) {
      return localBundle.getString("authid");
    }
    return "";
  }
  
  private String getAuthKey()
  {
    Bundle localBundle = this.mAccessToken;
    if (localBundle != null) {
      return localBundle.getString("authKey");
    }
    return "";
  }
  
  private long getUid()
  {
    CommonUserProto.LoginCheckRsp localLoginCheckRsp = this.mLoginCheckRsp;
    if (localLoginCheckRsp != null) {
      return localLoginCheckRsp.uid.get();
    }
    return 0L;
  }
  
  private String getUserSig()
  {
    CommonUserProto.LoginCheckRsp localLoginCheckRsp = this.mLoginCheckRsp;
    if (localLoginCheckRsp != null) {
      return localLoginCheckRsp.user_sig.get();
    }
    return "";
  }
  
  private void init(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2)
  {
    this.mQQApp = paramQQAppInterface;
    this.mGroupUin = paramLong;
    this.mAppName = paramString1;
    this.mFromId = paramString2;
    try
    {
      this.mUin = Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  private void notifyResult(int paramInt, CommProtocolProto.commResponse paramcommResponse, Bundle paramBundle, IODCsChannel.CsChannelObserver paramCsChannelObserver)
  {
    boolean bool = QLog.isColorLevel();
    String str = "null";
    StringBuilder localStringBuilder;
    Object localObject;
    if (bool)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyResult: errorCode=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" bundle=");
      if (paramBundle == null) {
        localObject = "null";
      } else {
        localObject = paramBundle.toString();
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" commResponse=");
      if (paramcommResponse == null) {
        localObject = "null";
      } else {
        localObject = paramcommResponse.toString();
      }
      localStringBuilder.append((String)localObject);
      QLog.d("ODCsChannel", 2, localStringBuilder.toString());
    }
    if (paramcommResponse != null) {
      paramInt = paramcommResponse.code.get();
    }
    if (paramcommResponse == null) {
      localObject = null;
    } else {
      localObject = paramcommResponse.body.get().toByteArray();
    }
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    if (paramcommResponse != null)
    {
      paramBundle.putString("msg", paramcommResponse.msg.get());
      paramBundle.putLong("seq", paramcommResponse.seq.get());
      paramBundle.putByteArray("data", (byte[])localObject);
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyResult: errorCode=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" bundle=");
      if (paramBundle == null) {
        paramcommResponse = str;
      } else {
        paramcommResponse = paramBundle.toString();
      }
      localStringBuilder.append(paramcommResponse);
      localStringBuilder.append(" data=");
      localStringBuilder.append(Arrays.toString((byte[])localObject));
      QLog.d("ODCsChannel", 2, localStringBuilder.toString());
    }
    if (paramCsChannelObserver != null)
    {
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        paramCsChannelObserver.a(paramInt, (byte[])localObject, paramBundle);
        return;
      }
      ThreadManager.getUIHandler().post(new ODCsChannelImpl.4(this, paramCsChannelObserver, paramInt, (byte[])localObject, paramBundle));
    }
  }
  
  private void sendPBRequest(int paramInt1, byte[] paramArrayOfByte, boolean paramBoolean, int paramInt2, IODCsChannel.CsChannelObserver paramCsChannelObserver)
  {
    CommProtocolProto.commRequest localcommRequest = buildCommRequest(paramInt1);
    if (paramArrayOfByte != null) {
      localcommRequest.body.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    QQAppInterface localQQAppInterface = this.mQQApp;
    paramArrayOfByte = new ODCsChannelImpl.3(this, paramInt2, paramInt1, paramArrayOfByte, paramBoolean, paramCsChannelObserver);
    paramCsChannelObserver = localcommRequest.toByteArray();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mServiceName);
    localStringBuilder.append(".");
    localStringBuilder.append(localcommRequest.cmd);
    ProtoUtils.a(localQQAppInterface, paramArrayOfByte, paramCsChannelObserver, localStringBuilder.toString());
  }
  
  public ODCsChannelImpl get(AppInterface paramAppInterface, long paramLong)
  {
    init((QQAppInterface)paramAppInterface, paramLong, "OnlineDating", "Group");
    return this;
  }
  
  public ODCsChannelImpl get(AppInterface paramAppInterface, long paramLong, String paramString1, String paramString2)
  {
    init((QQAppInterface)paramAppInterface, paramLong, paramString1, paramString2);
    return this;
  }
  
  public void login(int paramInt1, byte[] paramArrayOfByte, int paramInt2, IODCsChannel.CsChannelObserver paramCsChannelObserver)
  {
    Object localObject1 = new CommonUserProto.LoginCheckReq();
    ((CommonUserProto.LoginCheckReq)localObject1).group_code.set(this.mGroupUin);
    ((CommonUserProto.LoginCheckReq)localObject1).refresh.set(false);
    ((CommonUserProto.LoginCheckReq)localObject1).is_test.set(true);
    Object localObject2 = buildCommRequest(10401);
    ((CommProtocolProto.commRequest)localObject2).body.set(ByteStringMicro.copyFrom(((CommonUserProto.LoginCheckReq)localObject1).toByteArray()));
    localObject1 = this.mQQApp;
    paramArrayOfByte = new ODCsChannelImpl.2(this, paramInt2, paramInt1, paramArrayOfByte, paramCsChannelObserver);
    paramCsChannelObserver = ((CommProtocolProto.commRequest)localObject2).toByteArray();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.mServiceName);
    ((StringBuilder)localObject2).append(".");
    ((StringBuilder)localObject2).append(10401);
    ProtoUtils.a((AppRuntime)localObject1, paramArrayOfByte, paramCsChannelObserver, ((StringBuilder)localObject2).toString());
  }
  
  public void sendRequest(int paramInt, byte[] paramArrayOfByte, IODCsChannel.CsChannelObserver paramCsChannelObserver)
  {
    sendRequest(paramInt, paramArrayOfByte, true, 0, paramCsChannelObserver);
  }
  
  public void sendRequest(int paramInt1, byte[] paramArrayOfByte, boolean paramBoolean, int paramInt2, IODCsChannel.CsChannelObserver paramCsChannelObserver)
  {
    if (this.mAccessToken == null)
    {
      getAccessToken(paramInt1, paramArrayOfByte, paramBoolean, paramInt2, paramCsChannelObserver);
      return;
    }
    if ((this.mLoginCheckRsp == null) && (paramBoolean))
    {
      login(paramInt1, paramArrayOfByte, paramInt2, paramCsChannelObserver);
      return;
    }
    sendPBRequest(paramInt1, paramArrayOfByte, paramBoolean, paramInt2, paramCsChannelObserver);
  }
  
  public void sendRequest(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean, IODCsChannel.CsChannelObserver paramCsChannelObserver)
  {
    sendRequest(paramInt, paramArrayOfByte, paramBoolean, 0, paramCsChannelObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.cschannel.impl.ODCsChannelImpl
 * JD-Core Version:    0.7.0.1
 */