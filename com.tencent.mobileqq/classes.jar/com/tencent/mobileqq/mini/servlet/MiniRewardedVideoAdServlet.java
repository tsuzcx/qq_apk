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
import bbma;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
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
    localBundle = new Bundle();
    for (;;)
    {
      try
      {
        localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
        if (paramFromServiceMsg == null) {
          continue;
        }
        localStQWebRsp = new PROTOCAL.StQWebRsp();
        localStQWebRsp.mergeFrom(bbma.b(paramFromServiceMsg.getWupBuffer()));
        localBundle.putInt("key_index", (int)localStQWebRsp.Seq.get());
        if (!paramFromServiceMsg.isSuccess()) {
          continue;
        }
        localBundle.putParcelable("getRewardedVideoADInfo", paramFromServiceMsg);
        localBundle.putLong("retCode", localStQWebRsp.retCode.get());
        localBundle.putString("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        notifyObserver(paramIntent, 1027, true, localBundle, MiniAppObserver.class);
      }
      catch (Throwable localThrowable)
      {
        PROTOCAL.StQWebRsp localStQWebRsp;
        QLog.e("MiniRewardedVideoAdServlet", 1, localThrowable + "onReceive error");
        localBundle.putInt("key_index", this.index);
        notifyObserver(paramIntent, 1027, false, localBundle, MiniAppObserver.class);
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MiniRewardedVideoAdServlet", 2, "onReceive. inform MiniRewardedVideoAdServlet resultcode fail.");
        notifyObserver(paramIntent, 1027, false, localBundle, MiniAppObserver.class);
        continue;
      }
      doReport(paramIntent, paramFromServiceMsg);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MiniRewardedVideoAdServlet", 2, "onReceive. MiniRewardedVideoAdServlet rsp = " + localStQWebRsp);
      }
      notifyObserver(paramIntent, 1027, false, localBundle, MiniAppObserver.class);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    this.index = paramIntent.getIntExtra("key_index", -1);
    Object localObject2 = paramIntent.getByteArrayExtra("key_ext");
    Object localObject3 = paramIntent.getByteArrayExtra("key_user_info");
    Object localObject4 = paramIntent.getByteArrayExtra("key_position_info");
    Object localObject5 = paramIntent.getByteArrayExtra("key_device_info");
    Object localObject6 = paramIntent.getByteArrayExtra("key_context_info");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_debug_info");
    String str1 = paramIntent.getStringExtra("key_gdt_cookie");
    boolean bool = paramIntent.getBooleanExtra("key_support_https", false);
    String str2 = paramIntent.getStringExtra("key_busi_cookie");
    String str3 = paramIntent.getStringExtra("key_appid");
    int i = paramIntent.getIntExtra("key_ad_type", -1);
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject1).mergeFrom((byte[])localObject2);
      localObject2 = null;
      if (localObject3 != null) {
        localObject2 = new MiniAppAd.UserInfo();
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException5)
    {
      try
      {
        ((MiniAppAd.UserInfo)localObject2).mergeFrom((byte[])localObject3);
        localObject3 = null;
        if (localObject4 != null) {
          localObject3 = new MiniAppAd.PositionInfo();
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException5)
      {
        try
        {
          ((MiniAppAd.PositionInfo)localObject3).mergeFrom((byte[])localObject4);
          localObject4 = null;
          if (localObject5 != null) {
            localObject4 = new MiniAppAd.DeviceInfo();
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException5)
        {
          try
          {
            ((MiniAppAd.DeviceInfo)localObject4).mergeFrom((byte[])localObject5);
            localObject5 = null;
            if (localObject6 != null) {
              localObject5 = new MiniAppAd.ContextInfo();
            }
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException5)
          {
            try
            {
              ((MiniAppAd.ContextInfo)localObject5).mergeFrom((byte[])localObject6);
              localObject6 = null;
              if (arrayOfByte != null) {
                localObject6 = new MiniAppAd.DebugInfo();
              }
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException5)
            {
              try
              {
                for (;;)
                {
                  ((MiniAppAd.DebugInfo)localObject6).mergeFrom(arrayOfByte);
                  localObject2 = new MiniAppGetAdRequest((COMM.StCommonExt)localObject1, (MiniAppAd.UserInfo)localObject2, (MiniAppAd.PositionInfo)localObject3, (MiniAppAd.DeviceInfo)localObject4, (MiniAppAd.ContextInfo)localObject5, (MiniAppAd.DebugInfo)localObject6, str1, bool, str2, str3, i).encode(paramIntent, this.index, getTraceId());
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = new byte[4];
                  }
                  paramPacket.setSSOCommand("LightAppSvc.mini_app_ad.GetAd");
                  paramPacket.putSendData(bbma.a((byte[])localObject1));
                  paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
                  super.onSend(paramIntent, paramPacket);
                  return;
                  localInvalidProtocolBufferMicroException1 = localInvalidProtocolBufferMicroException1;
                  if (QLog.isColorLevel()) {
                    QLog.e("MiniRewardedVideoAdServlet", 2, "onSend. mergeFrom extData exception!");
                  }
                  localInvalidProtocolBufferMicroException1.printStackTrace();
                  continue;
                  localInvalidProtocolBufferMicroException2 = localInvalidProtocolBufferMicroException2;
                  if (QLog.isColorLevel()) {
                    QLog.e("MiniRewardedVideoAdServlet", 2, "onSend. mergeFrom userInfoByte exception!");
                  }
                  localInvalidProtocolBufferMicroException2.printStackTrace();
                  continue;
                  localInvalidProtocolBufferMicroException3 = localInvalidProtocolBufferMicroException3;
                  if (QLog.isColorLevel()) {
                    QLog.e("MiniRewardedVideoAdServlet", 2, "onSend. mergeFrom positionInfoByte exception!");
                  }
                  localInvalidProtocolBufferMicroException3.printStackTrace();
                  continue;
                  localInvalidProtocolBufferMicroException4 = localInvalidProtocolBufferMicroException4;
                  if (QLog.isColorLevel()) {
                    QLog.e("MiniRewardedVideoAdServlet", 2, "onSend. mergeFrom deviceInfoByte exception!");
                  }
                  localInvalidProtocolBufferMicroException4.printStackTrace();
                }
                localInvalidProtocolBufferMicroException5 = localInvalidProtocolBufferMicroException5;
                if (QLog.isColorLevel()) {
                  QLog.e("MiniRewardedVideoAdServlet", 2, "onSend. mergeFrom contextInfoByte exception!");
                }
                localInvalidProtocolBufferMicroException5.printStackTrace();
              }
              catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException6)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("MiniRewardedVideoAdServlet", 2, "onSend. mergeFrom debugInfoByte exception!");
                  }
                  localInvalidProtocolBufferMicroException6.printStackTrace();
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniRewardedVideoAdServlet
 * JD-Core Version:    0.7.0.1
 */