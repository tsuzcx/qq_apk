package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StRecommendApp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.tencent.mobileqq.utils.WupUtil;
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
  public static final String KEY_ITEM_IDS = "key_item_ids";
  public static final String KEY_MODULE_TYPES = "key_module_types";
  public static final String KEY_OLD_RECOMMEND_LIST = "key_old_recommend_list";
  public static final String KEY_SUB_TYPES = "key_sub_types";
  public static final String KEY_USE_CACHE = "key_use_cache";
  public static final String TAG = "MiniAppGetUserAppListServletV2";
  
  public MiniAppGetUserAppListServletV2()
  {
    this.observerId = 1047;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    try
    {
      localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
      if (paramFromServiceMsg != null)
      {
        boolean bool = paramFromServiceMsg.isSuccess();
        if (bool)
        {
          localObject = new PROTOCAL.StQWebRsp();
          ((PROTOCAL.StQWebRsp)localObject).mergeFrom(WupUtil.b(paramFromServiceMsg.getWupBuffer()));
          localBundle.putInt("key_index", (int)((PROTOCAL.StQWebRsp)localObject).Seq.get());
          localBundle.putLong("retCode", ((PROTOCAL.StQWebRsp)localObject).retCode.get());
          localBundle.putString("errMsg", ((PROTOCAL.StQWebRsp)localObject).errMsg.get().toStringUtf8());
          localBundle.putParcelable("getUserAppListV2", paramFromServiceMsg);
          notifyObserver(paramIntent, 1047, true, localBundle, MiniAppObserver.class);
        }
        else
        {
          localBundle.putLong("retCode", paramFromServiceMsg.getBusinessFailCode());
          localBundle.putString("errMsg", paramFromServiceMsg.getBusinessFailMsg());
          notifyObserver(paramIntent, 1047, false, localBundle, MiniAppObserver.class);
        }
      }
      else
      {
        QLog.e("MiniAppGetUserAppListServletV2", 1, "onReceive. inform MiniAppGetUserAppListServletV2 response is null.");
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localThrowable);
      ((StringBuilder)localObject).append(", onReceive exception: ");
      ((StringBuilder)localObject).append(Log.getStackTraceString(localThrowable));
      QLog.e("MiniAppGetUserAppListServletV2", 1, ((StringBuilder)localObject).toString());
    }
    doReport(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("key_index", -1);
    Object localObject3 = paramIntent.getParcelableArrayListExtra("key_old_recommend_list");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext_info");
    if (arrayOfByte != null)
    {
      localObject1 = new COMM.StCommonExt();
      try
      {
        ((COMM.StCommonExt)localObject1).mergeFrom(arrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniAppGetUserAppListServletV2", 2, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = new ArrayList();
    if (localObject3 != null)
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (RecommendAppInfo)((Iterator)localObject3).next();
        if (localObject4 != null)
        {
          localObject5 = new INTERFACE.StRecommendApp();
          ((INTERFACE.StRecommendApp)localObject5).appId.set(((RecommendAppInfo)localObject4).getAppId());
          ((INTERFACE.StRecommendApp)localObject5).exposuredNum.set(((RecommendAppInfo)localObject4).getExposuredNum());
          ((INTERFACE.StRecommendApp)localObject5).pullTime.set(((RecommendAppInfo)localObject4).getPullTime());
          ((ArrayList)localObject2).add(localObject5);
        }
      }
    }
    localObject3 = paramIntent.getIntegerArrayListExtra("key_module_types");
    int j = paramIntent.getIntExtra("key_use_cache", 0);
    Object localObject4 = paramIntent.getIntegerArrayListExtra("key_sub_types");
    Object localObject5 = paramIntent.getStringArrayListExtra("key_item_ids");
    localObject2 = new GetUserAppListRequestV2((COMM.StCommonExt)localObject1, (ArrayList)localObject2, (ArrayList)localObject3, j, AdUtils.getDeviceInfo(BaseApplicationImpl.getContext()), (ArrayList)localObject4, (ArrayList)localObject5).encode(paramIntent, i, getTraceId());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_userapp.GetDropdownAppList");
    paramPacket.putSendData(WupUtil.a((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetUserAppListServletV2
 * JD-Core Version:    0.7.0.1
 */