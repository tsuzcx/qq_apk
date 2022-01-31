package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StRecommendApp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import bblm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.RecommendAppInfo;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.Packet;

public class MiniAppGetRecommendAppListServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APP_ID = "key_app_id";
  public static final String KEY_EXT_INFO = "key_ext_info";
  public static final String KEY_OLD_RECOMMEND_LIST = "key_old_recommend_list";
  public static final String KEY_RECOMMEND_MODULE = "key_recommend_module";
  public static final String KEY_USE_TIME = "key_use_time";
  public static final String KEY_VER_TYPE = "key_ver_type";
  public static final String TAG = "MiniAppGetRecommendAppListServlet";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
        if (paramFromServiceMsg == null) {
          continue;
        }
        if (!paramFromServiceMsg.isSuccess()) {
          continue;
        }
        PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
        localStQWebRsp.mergeFrom(bblm.b(paramFromServiceMsg.getWupBuffer()));
        localBundle.putInt("key_index", (int)localStQWebRsp.Seq.get());
        localBundle.putLong("retCode", localStQWebRsp.retCode.get());
        localBundle.putString("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        localBundle.putParcelable("key_recommend_module", paramFromServiceMsg);
        notifyObserver(paramIntent, 1048, true, localBundle, MiniAppObserver.class);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MiniAppGetRecommendAppListServlet", 1, localThrowable + ", onReceive exception: " + Log.getStackTraceString(localThrowable));
        continue;
        QLog.e("MiniAppGetRecommendAppListServlet", 1, "onReceive. inform MiniAppGetUserAppListServletV2 response is null.");
        continue;
      }
      doReport(paramIntent, paramFromServiceMsg);
      return;
      localBundle.putLong("retCode", paramFromServiceMsg.getBusinessFailCode());
      localBundle.putString("errMsg", paramFromServiceMsg.getBusinessFailMsg());
      notifyObserver(paramIntent, 1048, false, localBundle, MiniAppObserver.class);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("key_index", -1);
    Object localObject2 = paramIntent.getStringExtra("key_app_id");
    Object localObject4 = paramIntent.getByteArrayExtra("key_ext_info");
    int j = paramIntent.getIntExtra("key_ver_type", 3);
    long l = paramIntent.getLongExtra("key_use_time", 5L);
    Object localObject3 = paramIntent.getParcelableArrayListExtra("key_old_recommend_list");
    Object localObject1 = null;
    if (localObject4 != null) {
      localObject1 = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject1).mergeFrom((byte[])localObject4);
      localObject4 = new ArrayList();
      if (localObject3 != null)
      {
        localObject3 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          RecommendAppInfo localRecommendAppInfo = (RecommendAppInfo)((Iterator)localObject3).next();
          if (localRecommendAppInfo != null)
          {
            INTERFACE.StRecommendApp localStRecommendApp = new INTERFACE.StRecommendApp();
            localStRecommendApp.appId.set(localRecommendAppInfo.getAppId());
            localStRecommendApp.exposuredNum.set(localRecommendAppInfo.getExposuredNum());
            localStRecommendApp.pullTime.set(localRecommendAppInfo.getPullTime());
            ((ArrayList)localObject4).add(localStRecommendApp);
          }
        }
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniAppGetRecommendAppListServlet", 2, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      localObject2 = new GetRecommendAppListRequest((COMM.StCommonExt)localObject1, (String)localObject2, j, l, localInvalidProtocolBufferMicroException, AdUtils.getDeviceInfo(BaseApplicationImpl.getContext())).encode(paramIntent, i, getTraceId());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_app_userapp.GetRecommendAppList");
      paramPacket.putSendData(bblm.a((byte[])localObject1));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
      super.onSend(paramIntent, paramPacket);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetRecommendAppListServlet
 * JD-Core Version:    0.7.0.1
 */