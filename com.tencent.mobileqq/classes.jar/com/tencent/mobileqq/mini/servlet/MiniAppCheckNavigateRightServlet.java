package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StCheckNavigateRightRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppCheckNavigateRightServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_ACTION_CODE = "key_action_code";
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_NAVIGATE_WORDING = "key_navigate_wording";
  public static final String KEY_SKIP_LOCAL_CHECK = "key_skip_local_check";
  public static final String KEY_TARGET_APP_ID = "target_app_id";
  public static final String TAG = "MiniAppCheckNavigateRightServlet";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      try
      {
        PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
        localStQWebRsp.mergeFrom(WupUtil.b(paramFromServiceMsg.getWupBuffer()));
        INTERFACE.StCheckNavigateRightRsp localStCheckNavigateRightRsp = new INTERFACE.StCheckNavigateRightRsp();
        localStCheckNavigateRightRsp.mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
        int i = localStCheckNavigateRightRsp.actionCode.get();
        int j = localStCheckNavigateRightRsp.skipLocalCheck.get();
        String str = localStCheckNavigateRightRsp.wording.get();
        localBundle.putInt("key_index", (int)localStQWebRsp.Seq.get());
        localBundle.putInt("key_action_code", i);
        localBundle.putInt("key_skip_local_check", j);
        localBundle.putString("key_navigate_wording", str);
        if (localStCheckNavigateRightRsp.extInfo != null) {
          localBundle.putByteArray("key_ext", localStCheckNavigateRightRsp.extInfo.toByteArray());
        }
        notifyObserver(paramIntent, 1023, true, localBundle, MiniAppObserver.class);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        notifyObserver(paramIntent, 1023, false, localBundle, MiniAppObserver.class);
      }
    } else {
      notifyObserver(paramIntent, 1023, false, localBundle, MiniAppObserver.class);
    }
    doReport(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getStringExtra("key_appid");
    Object localObject2 = paramIntent.getStringExtra("target_app_id");
    int i = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    if (arrayOfByte != null)
    {
      COMM.StCommonExt localStCommonExt = new COMM.StCommonExt();
      try
      {
        localStCommonExt.mergeFrom(arrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniAppCheckNavigateRightServlet", 2, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    localObject2 = new CheckNavigateRightRequest((String)localObject1, (String)localObject2).encode(paramIntent, i, getTraceId());
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_info.CheckNavigateRight");
    paramPacket.putSendData(WupUtil.a((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppCheckNavigateRightServlet
 * JD-Core Version:    0.7.0.1
 */