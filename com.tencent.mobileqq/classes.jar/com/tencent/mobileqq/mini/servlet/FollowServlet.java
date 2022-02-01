package com.tencent.mobileqq.mini.servlet;

import NS_FOLLOW.Follow.StBatchGetFollowingCountRsp;
import NS_FOLLOW.Follow.StCountResult;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.Packet;
import org.json.JSONObject;

public class FollowServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APPID_LIST = "key_appid_list";
  public static final String KEY_RSP_FOLLOW_COUNT = "key_follow_count";
  private static final String TAG = "FollowServlet";
  
  public FollowServlet()
  {
    this.observerId = 1091;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    int j = 0;
    try
    {
      localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
      int i = j;
      if (paramFromServiceMsg != null)
      {
        i = j;
        if (paramFromServiceMsg.isSuccess())
        {
          Object localObject = new PROTOCAL.StQWebRsp();
          ((PROTOCAL.StQWebRsp)localObject).mergeFrom(WupUtil.b(paramFromServiceMsg.getWupBuffer()));
          localBundle.putInt("key_index", (int)((PROTOCAL.StQWebRsp)localObject).Seq.get());
          i = j;
          if (((PROTOCAL.StQWebRsp)localObject).retCode.get() == 0L)
          {
            paramFromServiceMsg = new Follow.StBatchGetFollowingCountRsp();
            paramFromServiceMsg.mergeFrom(((PROTOCAL.StQWebRsp)localObject).busiBuff.get().toByteArray());
            localObject = paramFromServiceMsg.followingCounts.get();
            paramFromServiceMsg = new JSONObject();
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              Follow.StCountResult localStCountResult = (Follow.StCountResult)((Iterator)localObject).next();
              paramFromServiceMsg.put(localStCountResult.follower.get().replace("|3", ""), localStCountResult.count.get());
            }
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("jsonObject=");
              ((StringBuilder)localObject).append(paramFromServiceMsg.toString());
              QLog.d("FollowServlet", 2, ((StringBuilder)localObject).toString());
            }
            localBundle.putString("key_follow_count", paramFromServiceMsg.toString());
            notifyObserver(paramIntent, this.observerId, true, localBundle, MiniAppObserver.class);
            i = 1;
          }
        }
      }
      if (i == 0)
      {
        notifyObserver(paramIntent, this.observerId, false, localBundle, MiniAppObserver.class);
        return;
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      QLog.e("FollowServlet", 1, "onReceive error!", paramFromServiceMsg);
      notifyObserver(paramIntent, this.observerId, false, localBundle, MiniAppObserver.class);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte2 = new BatchGetFollowingCountRequest(paramIntent.getStringArrayListExtra("key_appid_list")).encode(paramIntent, paramIntent.getIntExtra("key_index", -1), getTraceId());
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null) {
      arrayOfByte1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.follow_svr.BatchGetFollowingCount");
    paramPacket.putSendData(WupUtil.a(arrayOfByte1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.FollowServlet
 * JD-Core Version:    0.7.0.1
 */