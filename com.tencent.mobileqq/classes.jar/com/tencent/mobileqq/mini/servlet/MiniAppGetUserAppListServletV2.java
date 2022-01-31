package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StRecommendApp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import bbma;
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

public class MiniAppGetUserAppListServletV2
  extends MiniAppAbstractServlet
{
  public static final String KEY_EXT_INFO = "key_ext_info";
  public static final String KEY_GET_USER_APP_LIST_V2 = "getUserAppListV2";
  public static final String KEY_MODULE_TYPES = "key_module_types";
  public static final String KEY_OLD_RECOMMEND_LIST = "key_old_recommend_list";
  public static final String KEY_USE_CACHE = "key_use_cache";
  public static final String TAG = "MiniAppGetUserAppListServletV2";
  
  public MiniAppGetUserAppListServletV2()
  {
    this.observerId = 1047;
  }
  
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
        localStQWebRsp.mergeFrom(bbma.b(paramFromServiceMsg.getWupBuffer()));
        localBundle.putInt("key_index", (int)localStQWebRsp.Seq.get());
        localBundle.putLong("retCode", localStQWebRsp.retCode.get());
        localBundle.putString("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        localBundle.putParcelable("getUserAppListV2", paramFromServiceMsg);
        notifyObserver(paramIntent, 1047, true, localBundle, MiniAppObserver.class);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MiniAppGetUserAppListServletV2", 1, localThrowable + ", onReceive exception: " + Log.getStackTraceString(localThrowable));
        continue;
        QLog.e("MiniAppGetUserAppListServletV2", 1, "onReceive. inform MiniAppGetUserAppListServletV2 response is null.");
        continue;
      }
      doReport(paramIntent, paramFromServiceMsg);
      return;
      localBundle.putLong("retCode", paramFromServiceMsg.getBusinessFailCode());
      localBundle.putString("errMsg", paramFromServiceMsg.getBusinessFailMsg());
      notifyObserver(paramIntent, 1047, false, localBundle, MiniAppObserver.class);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("key_index", -1);
    Object localObject2 = paramIntent.getParcelableArrayListExtra("key_old_recommend_list");
    Object localObject3 = paramIntent.getByteArrayExtra("key_ext_info");
    Object localObject1 = null;
    if (localObject3 != null) {
      localObject1 = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject1).mergeFrom((byte[])localObject3);
      localObject3 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          RecommendAppInfo localRecommendAppInfo = (RecommendAppInfo)((Iterator)localObject2).next();
          if (localRecommendAppInfo != null)
          {
            INTERFACE.StRecommendApp localStRecommendApp = new INTERFACE.StRecommendApp();
            localStRecommendApp.appId.set(localRecommendAppInfo.getAppId());
            localStRecommendApp.exposuredNum.set(localRecommendAppInfo.getExposuredNum());
            localStRecommendApp.pullTime.set(localRecommendAppInfo.getPullTime());
            ((ArrayList)localObject3).add(localStRecommendApp);
          }
        }
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniAppGetUserAppListServletV2", 2, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      localObject2 = new GetUserAppListRequestV2((COMM.StCommonExt)localObject1, localInvalidProtocolBufferMicroException, paramIntent.getIntegerArrayListExtra("key_module_types"), paramIntent.getIntExtra("key_use_cache", 0), AdUtils.getDeviceInfo(BaseApplicationImpl.getContext())).encode(paramIntent, i, getTraceId());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_app_userapp.GetDropdownAppList");
      paramPacket.putSendData(bbma.a((byte[])localObject1));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
      super.onSend(paramIntent, paramPacket);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetUserAppListServletV2
 * JD-Core Version:    0.7.0.1
 */