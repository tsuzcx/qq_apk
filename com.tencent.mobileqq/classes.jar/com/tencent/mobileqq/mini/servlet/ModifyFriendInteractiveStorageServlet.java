package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StInteractiveTemplate;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.Packet;

public class ModifyFriendInteractiveStorageServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_INTERACTIVE_TEMPLATE = "key_interactive_template";
  public static final String KEY_OPERATION = "key_operation";
  public static final String KEY_OPNUM = "key_opnum";
  public static final String KEY_QUIET = "key_quiet";
  public static final String KEY_SHARE_ID = "KEY_SHARE_ID";
  public static final String KEY_TO_USER = "key_to_user";
  public static final String TAG = "ModifyFriendInteractiveStorageServlet";
  private int index;
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ModifyFriendInteractiveStorageServlet", 2, "onReceive.");
    }
    Bundle localBundle = new Bundle();
    try
    {
      localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
      if (paramFromServiceMsg != null)
      {
        PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
        localStQWebRsp.mergeFrom(WupUtil.b(paramFromServiceMsg.getWupBuffer()));
        localBundle.putInt("key_index", (int)localStQWebRsp.Seq.get());
        if (paramFromServiceMsg.isSuccess())
        {
          localBundle.putParcelable("modifyFriendInteractiveStorage", paramFromServiceMsg);
          localBundle.putLong("retCode", localStQWebRsp.retCode.get());
          localBundle.putString("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
          notifyObserver(paramIntent, 1058, true, localBundle, MiniAppObserver.class);
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onReceive. MiniRewardedVideoAdServlet rsp = ");
            localStringBuilder.append(localStQWebRsp);
            QLog.d("ModifyFriendInteractiveStorageServlet", 2, localStringBuilder.toString());
          }
          notifyObserver(paramIntent, 1058, false, localBundle, MiniAppObserver.class);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ModifyFriendInteractiveStorageServlet", 2, "onReceive. inform MiniRewardedVideoAdServlet resultcode fail.");
        }
        notifyObserver(paramIntent, 1058, false, localBundle, MiniAppObserver.class);
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localThrowable);
      localStringBuilder.append("onReceive error");
      QLog.e("ModifyFriendInteractiveStorageServlet", 1, localStringBuilder.toString());
      localBundle.putInt("key_index", this.index);
      notifyObserver(paramIntent, 1058, false, localBundle, MiniAppObserver.class);
    }
    doReport(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    this.index = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte1 = paramIntent.getByteArrayExtra("key_ext");
    String str1 = paramIntent.getStringExtra("key_to_user");
    String str2 = paramIntent.getStringExtra("KEY_SHARE_ID");
    String str3 = paramIntent.getStringExtra("key_appid");
    int i = paramIntent.getIntExtra("key_opnum", -1);
    String str4 = paramIntent.getStringExtra("key_operation");
    HashMap localHashMap = (HashMap)paramIntent.getSerializableExtra("key_data");
    Object localObject2 = null;
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
          QLog.e("ModifyFriendInteractiveStorageServlet", 2, "onSend. mergeFrom extData exception!");
        }
        localInvalidProtocolBufferMicroException1.printStackTrace();
      }
    }
    else
    {
      localObject1 = null;
    }
    boolean bool = paramIntent.getBooleanExtra("key_quiet", false);
    byte[] arrayOfByte2 = paramIntent.getByteArrayExtra("key_interactive_template");
    if (arrayOfByte2 != null)
    {
      localObject2 = new CloudStorage.StInteractiveTemplate();
      try
      {
        ((CloudStorage.StInteractiveTemplate)localObject2).mergeFrom(arrayOfByte2);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        QLog.e("ModifyFriendInteractiveStorageServlet", 2, "onSend. mergeFrom interactiveTemplateBytes exception!", localInvalidProtocolBufferMicroException2);
      }
    }
    localObject2 = new ModifyFriendInteractiveStorageReq((COMM.StCommonExt)localObject1, str3, str1, str2, i, str4, localHashMap, bool, (CloudStorage.StInteractiveTemplate)localObject2).encode(paramIntent, this.index, getTraceId());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_cloudstorage.ModifyFriendInteractiveStorage");
    paramPacket.putSendData(WupUtil.a((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.ModifyFriendInteractiveStorageServlet
 * JD-Core Version:    0.7.0.1
 */