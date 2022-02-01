package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_AD.MiniAppAd.ContextInfo;
import NS_MINI_AD.MiniAppAd.DebugInfo;
import NS_MINI_AD.MiniAppAd.DeviceInfo;
import NS_MINI_AD.MiniAppAd.PositionInfo;
import NS_MINI_AD.MiniAppAd.UserInfo;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniRewardedVideoAdServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_AD_TYPE = "key_ad_type";
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_BUSI_COOKIE = "key_busi_cookie";
  public static final String KEY_CONTEXT_INFO = "key_context_info";
  public static final String KEY_DEBUG_INFO = "key_debug_info";
  public static final String KEY_DEVICE_INFO = "key_device_info";
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_EXTENDINFO = "key_extendinfo";
  public static final String KEY_GDT_COOKIE = "key_gdt_cookie";
  public static final String KEY_POSITION_INFO = "key_position_info";
  public static final String KEY_SUPPORT_HTTPS = "key_support_https";
  public static final String KEY_USER_INFO = "key_user_info";
  public static final String TAG = "MiniRewardedVideoAdServlet";
  private int index;
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniRewardedVideoAdServlet", 2, "onReceive.");
    }
    Bundle localBundle = new Bundle();
    try
    {
      localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
      if (paramFromServiceMsg != null)
      {
        PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
        localStQWebRsp.mergeFrom(WupUtil.b(paramFromServiceMsg.getWupBuffer()));
        if (paramFromServiceMsg.isSuccess())
        {
          localBundle.putParcelable("getRewardedVideoADInfo", paramFromServiceMsg);
          localBundle.putLong("retCode", localStQWebRsp.retCode.get());
          localBundle.putString("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
          notifyObserver(paramIntent, 1027, true, localBundle, MiniAppObserver.class);
        }
        else
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onReceive. MiniRewardedVideoAdServlet rsp = ");
            localStringBuilder.append(localStQWebRsp);
            QLog.d("MiniRewardedVideoAdServlet", 2, localStringBuilder.toString());
          }
          notifyObserver(paramIntent, 1027, false, localBundle, MiniAppObserver.class);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MiniRewardedVideoAdServlet", 2, "onReceive. inform MiniRewardedVideoAdServlet resultcode fail.");
        }
        notifyObserver(paramIntent, 1027, false, localBundle, MiniAppObserver.class);
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniRewardedVideoAdServlet", 1, "onReceive error", localThrowable);
      localBundle.putInt("key_index", this.index);
      notifyObserver(paramIntent, 1027, false, localBundle, MiniAppObserver.class);
    }
    doReport(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    this.index = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte1 = paramIntent.getByteArrayExtra("key_ext");
    byte[] arrayOfByte2 = paramIntent.getByteArrayExtra("key_user_info");
    byte[] arrayOfByte3 = paramIntent.getByteArrayExtra("key_position_info");
    byte[] arrayOfByte4 = paramIntent.getByteArrayExtra("key_device_info");
    byte[] arrayOfByte5 = paramIntent.getByteArrayExtra("key_context_info");
    byte[] arrayOfByte6 = paramIntent.getByteArrayExtra("key_debug_info");
    String str1 = paramIntent.getStringExtra("key_gdt_cookie");
    boolean bool = paramIntent.getBooleanExtra("key_support_https", false);
    String str2 = paramIntent.getStringExtra("key_busi_cookie");
    String str3 = paramIntent.getStringExtra("key_appid");
    int i = paramIntent.getIntExtra("key_ad_type", -1);
    if (arrayOfByte1 != null)
    {
      localObject1 = new COMM.StCommonExt();
      try
      {
        ((COMM.StCommonExt)localObject1).mergeFrom(arrayOfByte1);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniRewardedVideoAdServlet", 2, "onSend. mergeFrom extData exception!");
        }
        localInvalidProtocolBufferMicroException1.printStackTrace();
      }
    }
    else
    {
      localObject1 = null;
    }
    if (arrayOfByte2 != null)
    {
      localObject2 = new MiniAppAd.UserInfo();
      try
      {
        ((MiniAppAd.UserInfo)localObject2).mergeFrom(arrayOfByte2);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniRewardedVideoAdServlet", 2, "onSend. mergeFrom userInfoByte exception!");
        }
        localInvalidProtocolBufferMicroException2.printStackTrace();
      }
    }
    else
    {
      localObject2 = null;
    }
    MiniAppAd.PositionInfo localPositionInfo;
    if (arrayOfByte3 != null)
    {
      localPositionInfo = new MiniAppAd.PositionInfo();
      try
      {
        localPositionInfo.mergeFrom(arrayOfByte3);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException3)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniRewardedVideoAdServlet", 2, "onSend. mergeFrom positionInfoByte exception!");
        }
        localInvalidProtocolBufferMicroException3.printStackTrace();
      }
    }
    else
    {
      localPositionInfo = null;
    }
    MiniAppAd.DeviceInfo localDeviceInfo;
    if (arrayOfByte4 != null)
    {
      localDeviceInfo = new MiniAppAd.DeviceInfo();
      try
      {
        localDeviceInfo.mergeFrom(arrayOfByte4);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException4)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniRewardedVideoAdServlet", 2, "onSend. mergeFrom deviceInfoByte exception!");
        }
        localInvalidProtocolBufferMicroException4.printStackTrace();
      }
    }
    else
    {
      localDeviceInfo = null;
    }
    MiniAppAd.ContextInfo localContextInfo;
    if (arrayOfByte5 != null)
    {
      localContextInfo = new MiniAppAd.ContextInfo();
      try
      {
        localContextInfo.mergeFrom(arrayOfByte5);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException5)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniRewardedVideoAdServlet", 2, "onSend. mergeFrom contextInfoByte exception!");
        }
        localInvalidProtocolBufferMicroException5.printStackTrace();
      }
    }
    else
    {
      localContextInfo = null;
    }
    MiniAppAd.DebugInfo localDebugInfo;
    if (arrayOfByte6 != null)
    {
      localDebugInfo = new MiniAppAd.DebugInfo();
      try
      {
        localDebugInfo.mergeFrom(arrayOfByte6);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException6)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniRewardedVideoAdServlet", 2, "onSend. mergeFrom debugInfoByte exception!");
        }
        localInvalidProtocolBufferMicroException6.printStackTrace();
      }
    }
    else
    {
      localDebugInfo = null;
    }
    Object localObject2 = new MiniAppGetAdRequest((COMM.StCommonExt)localObject1, (MiniAppAd.UserInfo)localObject2, localPositionInfo, localDeviceInfo, localContextInfo, localDebugInfo, str1, bool, str2, str3, i).encode(paramIntent, this.index, getTraceId());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_ad.GetAd");
    paramPacket.putSendData(WupUtil.a((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniRewardedVideoAdServlet
 * JD-Core Version:    0.7.0.1
 */