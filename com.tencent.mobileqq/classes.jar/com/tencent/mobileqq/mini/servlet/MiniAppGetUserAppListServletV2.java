package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.Entry;
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
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.Packet;

public class MiniAppGetUserAppListServletV2
  extends MiniAppAbstractServlet
{
  public static final String KEY_EXT_INFO = "key_ext_info";
  public static final String KEY_GET_USER_APP_LIST_V2 = "getUserAppListV2";
  public static final String KEY_ITEM_IDS = "key_item_ids";
  public static final String KEY_MODULE_TYPES = "key_module_types";
  public static final String KEY_OLD_RECOMMEND_LIST = "key_old_recommend_list";
  public static final String KEY_SCENE = "scene";
  public static final String KEY_SUB_TYPES = "key_sub_types";
  public static final String KEY_USE_CACHE = "key_use_cache";
  public static final String TAG = "MiniAppGetUserAppListServletV2";
  
  public MiniAppGetUserAppListServletV2()
  {
    this.observerId = 1047;
  }
  
  private COMM.StCommonExt buildExtInfo(byte[] paramArrayOfByte, int paramInt)
  {
    COMM.StCommonExt localStCommonExt = new COMM.StCommonExt();
    if (paramArrayOfByte != null) {
      try
      {
        localStCommonExt.mergeFrom(paramArrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[MiniAppGetUserAppListServletV2] onSend. exception=");
        localStringBuilder.append(paramArrayOfByte.getMessage());
        QLog.e("MiniAppGetUserAppListServletV2", 1, localStringBuilder.toString());
      }
    }
    paramArrayOfByte = new COMM.Entry();
    paramArrayOfByte.key.set("scene");
    paramArrayOfByte.value.set(String.valueOf(paramInt));
    localStCommonExt.mapInfo.get().add(paramArrayOfByte);
    return localStCommonExt;
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
    Object localObject2 = paramIntent.getParcelableArrayListExtra("key_old_recommend_list");
    Object localObject1 = new ArrayList();
    if (localObject2 != null)
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (RecommendAppInfo)((Iterator)localObject2).next();
        if (localObject3 != null)
        {
          localObject4 = new INTERFACE.StRecommendApp();
          ((INTERFACE.StRecommendApp)localObject4).appId.set(((RecommendAppInfo)localObject3).getAppId());
          ((INTERFACE.StRecommendApp)localObject4).exposuredNum.set(((RecommendAppInfo)localObject3).getExposuredNum());
          ((INTERFACE.StRecommendApp)localObject4).pullTime.set(((RecommendAppInfo)localObject3).getPullTime());
          ((ArrayList)localObject1).add(localObject4);
        }
      }
    }
    localObject2 = paramIntent.getIntegerArrayListExtra("key_module_types");
    int j = paramIntent.getIntExtra("key_use_cache", 0);
    Object localObject3 = paramIntent.getIntegerArrayListExtra("key_sub_types");
    Object localObject4 = paramIntent.getStringArrayListExtra("key_item_ids");
    localObject2 = new GetUserAppListRequestV2(buildExtInfo(paramIntent.getByteArrayExtra("key_ext_info"), paramIntent.getIntExtra("scene", 0)), (ArrayList)localObject1, (ArrayList)localObject2, j, AdUtils.getDeviceInfo(BaseApplicationImpl.getContext()), (ArrayList)localObject3, (ArrayList)localObject4).encode(paramIntent, i, getTraceId());
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_userapp.GetDropdownAppList");
    paramPacket.putSendData(WupUtil.a((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetUserAppListServletV2
 * JD-Core Version:    0.7.0.1
 */