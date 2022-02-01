package com.tencent.mobileqq.mini.reuse;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_AD.MiniAppAd.StGetAdRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetPotentialFriendListRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetReactiveFriendListRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetUserInteractiveStorageRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StModifyFriendInteractiveStorageRsp;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetPhoneNumberRsp;
import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import NS_MINI_INTERFACE.INTERFACE.StPhoneNumber;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import NS_MINI_INTERFACE.INTERFACE.UseUserInfo;
import NS_MINI_SHARE.MiniProgramShare.StSendArkMsgRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.apkg.CommExtInfo;
import com.tencent.mobileqq.mini.apkg.UseUserInfo;
import com.tencent.mobileqq.mini.app.PreCacheManager.ContentAccelerateRsp;
import com.tencent.mobileqq.mini.servlet.BatchQueryAppInfoRequest;
import com.tencent.mobileqq.mini.servlet.GetHotSearchAppsRequest;
import com.tencent.mobileqq.mini.servlet.GetPotentialFriendListRequest;
import com.tencent.mobileqq.mini.servlet.GetReactiveFriendListRequest;
import com.tencent.mobileqq.mini.servlet.GetRecommendAppListRequest;
import com.tencent.mobileqq.mini.servlet.GetUserAppListRequest;
import com.tencent.mobileqq.mini.servlet.GetUserAppListRequestV2;
import com.tencent.mobileqq.mini.servlet.GetUserInteractiveStorageRequest;
import com.tencent.mobileqq.mini.servlet.GuessYouLikeRequest;
import com.tencent.mobileqq.mini.servlet.LocalSearchDataRequest;
import com.tencent.mobileqq.mini.servlet.MiniAppGetAdRequest;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGroupShareInfoRequest;
import com.tencent.mobileqq.mini.servlet.MiniAppGetSwitchListRequest;
import com.tencent.mobileqq.mini.servlet.MiniAppObserver;
import com.tencent.mobileqq.mini.servlet.MiniAppSendArkMsgRequest;
import com.tencent.mobileqq.mini.servlet.MiniAppSetUserSwitchRequest;
import com.tencent.mobileqq.mini.servlet.ModifyFriendInteractiveStorageReq;
import com.tencent.mobileqq.mini.servlet.PayRequest;
import com.tencent.mobileqq.mini.servlet.QueryCurrencyRequest;
import com.tencent.mobileqq.mini.servlet.SearchAppRequest;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqexpand.bean.feed.MiniAppRecommInfo;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MiniSdkUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.SenderListener;
import com.tencent.ttpic.util.GsonUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppCmdUtil$1
  extends MiniAppObserver
{
  MiniAppCmdUtil$1(MiniAppCmdUtil paramMiniAppCmdUtil) {}
  
  protected void onAddPhoneNumber(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onAddPhoneNumber(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        JSONObject localJSONObject = new JSONObject();
        String str1 = paramBundle.getString("errMsg");
        String str2 = paramBundle.getString("retCode");
        localJSONObject.put("errMsg", str1);
        localJSONObject.put("retCode", str2);
        if (paramBoolean)
        {
          localJSONObject.put("encryptedData", paramBundle.getString("encryptedData", ""));
          localJSONObject.put("iv", paramBundle.getString("iv", ""));
        }
        if (localMiniAppCmdInterface != null)
        {
          localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
          return;
        }
      }
      catch (Throwable paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "onAddPhoneNumber error.", paramBundle);
      }
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("onAddPhoneNumber no listener for ");
    paramBundle.append(paramInt);
    QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
  }
  
  protected void onBatchGetContact(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        localObject = new JSONObject();
        if (paramBoolean)
        {
          paramBundle = new JSONObject(paramBundle.getString("contact_list"));
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(true, paramBundle);
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call onBatchGetContact fail.");
        if (!TextUtils.isEmpty(paramBundle.getString("errMsg"))) {
          ((JSONObject)localObject).put("errMsg", paramBundle.getString("errMsg"));
        }
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(false, (JSONObject)localObject);
        return;
      }
      catch (Exception paramBundle)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("call onBatchGetContact exception ");
        ((StringBuilder)localObject).append(paramBundle);
        QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onBatchGetContact can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onBatchGetFollowingCount(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramBoolean) {
        try
        {
          localObject1 = new JSONObject(paramBundle.getString("key_follow_count"));
        }
        catch (JSONException paramBundle)
        {
          QLog.e("[mini] MiniAppObserver", 1, "onBatchGetFollowingCount error. ", paramBundle);
          localObject1 = localObject2;
        }
      }
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(paramBoolean, (JSONObject)localObject1);
      }
    }
  }
  
  protected void onBatchGetUserInfoResult(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        paramBundle = new JSONObject(paramBundle.getString("key_reslut_data"));
      }
      catch (Throwable paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "onBatchGetUserInfoResult error. ", paramBundle);
        paramBundle = new JSONObject();
      }
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(paramBoolean, paramBundle);
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onBatchGetUserInfoResult can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onBatchQueryAppInfoFin(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (!paramBoolean) {}
    }
    try
    {
      paramBundle = (FromServiceMsg)paramBundle.getParcelable("batchQueryAppInfo");
      if (paramBundle == null) {
        break label222;
      }
      paramBundle = BatchQueryAppInfoRequest.onResponse(WupUtil.b(paramBundle.getWupBuffer()));
      localJSONObject = new JSONObject();
      localJSONObject.put("batch_query_app_info", paramBundle);
      if (localMiniAppCmdInterface == null) {
        break label222;
      }
      localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject;
      label138:
      label222:
      break label138;
    }
    QLog.d("[mini] MiniAppObserver", 1, "call onBatchQueryAppInfoFin fail.");
    if (localMiniAppCmdInterface != null)
    {
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("call onBatchQueryAppInfoFin exception ");
      paramBundle.append(localJSONObject);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        paramBundle = new StringBuilder();
        paramBundle.append("onBatchQueryAppInfoFin can not found listener. ");
        paramBundle.append(paramInt);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      }
    }
  }
  
  protected void onBookShelfInsertResult(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("retCode", paramBundle.getInt("retCode"));
        localJSONObject.put("errMsg", paramBundle.getString("errMsg"));
        if (paramBoolean) {
          localJSONObject.put("key_result_data", paramBundle.getString("key_result_data"));
        }
      }
      catch (Throwable paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "onBookShelfInsertResult error. ", paramBundle);
      }
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onBookShelfInsertResult can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onBookShelfQueryResult(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("retCode", paramBundle.getInt("retCode"));
        localJSONObject.put("errMsg", paramBundle.getString("errMsg"));
        if (paramBoolean) {
          localJSONObject.put("key_result_data", paramBundle.getString("key_result_data"));
        }
      }
      catch (Throwable paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "onBookShelfQueryResult error. ", paramBundle);
      }
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onBookShelfQueryResult can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onBookShelfUpdateResult(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("retCode", paramBundle.getInt("retCode"));
        localJSONObject.put("errMsg", paramBundle.getString("errMsg"));
        if (paramBoolean) {
          localJSONObject.put("key_result_data", paramBundle.getString("key_result_data"));
        }
      }
      catch (Throwable paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "onBookShelfUpdateResult error. ", paramBundle);
      }
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onBookShelfUpdateResult can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onChangeShareImageUrl(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onChangeShareImageUrl(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (localMiniAppCmdInterface != null)
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("imageUrl", paramBundle.getString("imageUrl"));
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
        }
        localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
      }
    }
  }
  
  protected void onCheckBindingState(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("retCode", paramBundle.getLong("retCode"));
        localJSONObject.put("errMsg", paramBundle.getString("key_Msg"));
        if (paramBoolean)
        {
          paramInt = paramBundle.getInt("key_check_State", -1);
          if (paramInt != -1) {
            localJSONObject.put("key_check_State", paramInt);
          } else {
            QLog.d("[mini] MiniAppObserver", 1, "call checkBindingType is null.");
          }
        }
        else
        {
          QLog.e("[mini] MiniAppObserver", 1, "onCheckBindingType fail");
        }
      }
      catch (Throwable paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "onCheckBindingType error. ", paramBundle);
      }
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCheckBindingType can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onCheckNavigateRightServlet(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (!paramBoolean) {}
    }
    label256:
    try
    {
      paramInt = paramBundle.getInt("key_action_code", 0);
      int i = paramBundle.getInt("key_skip_local_check", 0);
      paramBundle = paramBundle.getString("key_navigate_wording");
      localJSONObject = new JSONObject();
      localJSONObject.put("action_code", paramInt);
      localJSONObject.put("skip_local_check", i);
      if (paramInt == 0) {
        localJSONObject.put("reason", paramBundle);
      } else {
        localJSONObject.put("wording", paramBundle);
      }
      if (localMiniAppCmdInterface == null) {
        break label256;
      }
      localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject;
      label172:
      break label172;
    }
    QLog.d("[mini] MiniAppObserver", 1, "call onCheckNavigateRightServlet fail.");
    if (localMiniAppCmdInterface != null)
    {
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("call onCheckNavigateRightServlet exception ");
      paramBundle.append(localJSONObject);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        paramBundle = new StringBuilder();
        paramBundle.append("onCheckNavigateRightServlet can not found listener. ");
        paramBundle.append(paramInt);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      }
    }
  }
  
  protected void onCheckOfferIdFin(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    MiniAppCmdInterface localMiniAppCmdInterface;
    JSONObject localJSONObject;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      localJSONObject = new JSONObject();
      if (!paramBoolean) {}
    }
    label287:
    try
    {
      paramInt = paramBundle.getInt("key_result");
      localObject = paramBundle.getString("errMsg");
      localJSONObject.put("result", paramInt);
      localJSONObject.put("firstRefer", paramBundle.getString("key_first_refer"));
      localJSONObject.put("firstVia", paramBundle.getString("key_first_via"));
      localJSONObject.put("errMsg", localObject);
      paramBundle = paramBundle.getByteArray("key_extendinfo");
      if (paramBundle != null)
      {
        localObject = new COMM.StCommonExt();
        ((COMM.StCommonExt)localObject).mergeFrom(paramBundle);
        localJSONObject.put("ext", localObject);
      }
      if (localMiniAppCmdInterface == null) {
        break label287;
      }
      localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      Object localObject;
      label206:
      break label206;
    }
    QLog.d("[mini] MiniAppObserver", 1, "call onCheckOfferIdFin fail.");
    if (localMiniAppCmdInterface != null)
    {
      localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("call onCheckOfferIdFin exception ");
      paramBundle.append(localObject);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
        return;
        paramBundle = new StringBuilder();
        paramBundle.append("onCheckOfferIdFin can not found listener. ");
        paramBundle.append(paramInt);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      }
    }
  }
  
  protected void onCheckSessionFin(int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
  {
    super.onCheckSessionFin(paramInt1, paramBoolean, paramInt2, paramString);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt1))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt1));
      if ((paramBoolean) && (paramInt2 == 0)) {}
      try
      {
        QLog.d("[mini] MiniAppObserver", 1, "call API_REFRESH_SESSION success.");
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(true, new JSONObject());
        return;
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("call API_LOGIN exception ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("errMsg", paramString);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("call API_LOGIN failed ");
      localStringBuilder.append(paramString);
      QLog.e("[mini] MiniAppObserver", 1, localStringBuilder.toString());
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, (JSONObject)localObject);
        return;
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      }
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("onCheckSessionFin can not found listener. ");
      paramString.append(paramInt1);
      QLog.e("[mini] MiniAppObserver", 1, paramString.toString());
    }
  }
  
  protected void onCreateUpdatableMsgResult(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("retCode", paramBundle.getLong("retCode"));
        localJSONObject.put("errMsg", paramBundle.getString("errMsg"));
      }
      catch (Throwable paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "onCreateUpdatableMsgResult error. ", paramBundle);
      }
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCreateUpdatableMsgResult can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onDcReport(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    super.onDcReport(paramInt1, paramBoolean, paramInt2);
    Object localObject;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt1))))
    {
      localObject = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt1));
      if ((paramBoolean) && (paramInt2 == 0))
      {
        if (localObject != null)
        {
          QLog.d("[mini] MiniAppObserver", 1, "onDcReport ok");
          ((MiniAppCmdInterface)localObject).onCmdListener(true, new JSONObject());
        }
      }
      else if (localObject != null)
      {
        QLog.e("[mini] MiniAppObserver", 1, "onDcReport fail");
        ((MiniAppCmdInterface)localObject).onCmdListener(false, new JSONObject());
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDcReport can not found listener for index ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void onDelMiniAppFin(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onDelMiniAppFin(paramInt, paramBoolean, paramBundle);
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (!paramBoolean) {}
    }
    try
    {
      localJSONObject = new JSONObject();
      paramBundle = paramBundle.getByteArray("key_extendinfo");
      if (paramBundle != null)
      {
        COMM.StCommonExt localStCommonExt = new COMM.StCommonExt();
        localStCommonExt.mergeFrom(paramBundle);
        localJSONObject.put("ext", localStCommonExt);
      }
      if (localMiniAppCmdInterface == null) {
        break label237;
      }
      localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject;
      label151:
      label237:
      break label151;
    }
    QLog.d("[mini] MiniAppObserver", 1, "call onDelMiniAppFin fail.");
    if (localMiniAppCmdInterface != null)
    {
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("call onDelMiniAppFin exception ");
      paramBundle.append(localJSONObject);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        paramBundle = new StringBuilder();
        paramBundle.append("onDelMiniAppFin can not found listener. ");
        paramBundle.append(paramInt);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      }
    }
  }
  
  protected void onDelPhoneNumber(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onDelPhoneNumber(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        JSONObject localJSONObject = new JSONObject();
        String str = paramBundle.getString("errMsg");
        paramBundle = paramBundle.getString("retCode");
        localJSONObject.put("errMsg", str);
        localJSONObject.put("retCode", paramBundle);
        if (localMiniAppCmdInterface != null)
        {
          localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
          return;
        }
      }
      catch (Throwable paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "onDelPhoneNumber error.", paramBundle);
      }
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("onDelPhoneNumber no listener for ");
    paramBundle.append(paramInt);
    QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
  }
  
  protected void onDoGameRaffle(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("retCode", paramBundle.getLong("retCode", -1L));
        localJSONObject.put("errMsg", paramBundle.getString("errMsg"));
        if (paramBoolean) {
          localJSONObject.put("key_result_data", paramBundle.getString("key_result_data"));
        }
      }
      catch (Throwable paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "onDoGameRaffle error. ", paramBundle);
      }
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onDoGameRaffle can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onGetAppInfoByIdForSDKServlet(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetAppInfoByIdForSDKServlet(paramInt, paramBoolean, paramBundle);
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt)))) {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      try
      {
        long l = paramBundle.getLong("retCode", 0L);
        Object localObject = paramBundle.getString("errMsg");
        if (paramBoolean)
        {
          paramBundle = (com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)paramBundle.getParcelable("mini_app_info_data");
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("mini_app_info_data", paramBundle);
          localJSONObject.put("retCode", l);
          localJSONObject.put("errMsg", localObject);
          if (localMiniAppCmdInterface != null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onGetAppInfoByIdForSDKServlet . ");
            ((StringBuilder)localObject).append(paramInt);
            QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
            if (l != 0L) {
              break label333;
            }
            paramBoolean = true;
            localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
          }
          if (paramBundle == null) {
            break label332;
          }
          this.this$0.getExtConfigDetail(paramBundle.commonExt, MiniSdkUtil.a(paramBundle.extConfigInfoList), new MiniAppCmdUtil.1.3(this));
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call onGetAppInfoByIdForSDKServlet fail.");
        if (localMiniAppCmdInterface == null) {
          break label332;
        }
        paramBundle = new JSONObject();
        paramBundle.put("retCode", l);
        paramBundle.put("errMsg", localObject);
        localMiniAppCmdInterface.onCmdListener(false, paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onGetAppInfoByIdForSDKServlet exception ", paramBundle);
        if (localMiniAppCmdInterface == null) {
          break label332;
        }
      }
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("onGetAppInfoByIdForSDKServlet can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      label332:
      return;
      label333:
      paramBoolean = false;
    }
  }
  
  protected void onGetAppInfoByIdServlet(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt)))) {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      try
      {
        long l = paramBundle.getLong("retCode", 0L);
        localObject = paramBundle.getString("errMsg");
        if (paramBoolean)
        {
          com.tencent.mobileqq.mini.apkg.MiniAppInfo localMiniAppInfo = (com.tencent.mobileqq.mini.apkg.MiniAppInfo)paramBundle.getSerializable("mini_app_info_data");
          byte[] arrayOfByte = (byte[])paramBundle.getSerializable("mini_app_info_pb_data");
          paramBundle = new JSONObject();
          paramBundle.put("mini_app_info_data", localMiniAppInfo);
          paramBundle.put("mini_app_info_pb_data", arrayOfByte);
          paramBundle.put("retCode", l);
          paramBundle.put("errMsg", localObject);
          if (localMiniAppCmdInterface != null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onGetAppInfoByIdServlet . ");
            ((StringBuilder)localObject).append(paramInt);
            QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
            if (l != 0L) {
              break label374;
            }
            paramBoolean = true;
            localMiniAppCmdInterface.onCmdListener(paramBoolean, paramBundle);
          }
          if (localMiniAppInfo == null) {
            break label373;
          }
          this.this$0.getExtConfigDetail(localMiniAppInfo.commonExt, localMiniAppInfo.extConfigInfoList, new MiniAppCmdUtil.1.2(this));
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call onGetAppInfoByIdServlet fail.");
        if (localMiniAppCmdInterface == null) {
          break label373;
        }
        paramBundle = new JSONObject();
        paramBundle.put("retCode", l);
        paramBundle.put("errMsg", localObject);
        localMiniAppCmdInterface.onCmdListener(false, paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("call onGetAppInfoByIdServlet exception ");
        ((StringBuilder)localObject).append(paramBundle);
        QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
        if (localMiniAppCmdInterface == null) {
          break label373;
        }
      }
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("onGetAppInfoByIdServlet can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      label373:
      return;
      label374:
      paramBoolean = false;
    }
  }
  
  protected void onGetAppInfoByLinkFin(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetAppInfoByLinkFin(paramInt, paramBoolean, paramBundle);
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt)))) {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      try
      {
        long l = paramBundle.getLong("retCode", -1L);
        Object localObject = paramBundle.getString("errMsg", HardCodeUtil.a(2131904658));
        if (paramBoolean)
        {
          com.tencent.mobileqq.mini.apkg.MiniAppInfo localMiniAppInfo = (com.tencent.mobileqq.mini.apkg.MiniAppInfo)paramBundle.getSerializable("appInfo");
          String str = paramBundle.getString("shareTicket", "");
          byte[] arrayOfByte = (byte[])paramBundle.getSerializable("appInfo_pd");
          paramBundle = new JSONObject();
          paramBundle.put("appInfo", localMiniAppInfo);
          paramBundle.put("shareTicket", str);
          paramBundle.put("appInfo_pb", arrayOfByte);
          paramBundle.put("retCode", l);
          paramBundle.put("errMsg", localObject);
          if (localMiniAppCmdInterface != null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("  onGetAppInfoByLinkFin . ");
            ((StringBuilder)localObject).append(paramInt);
            QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
            if (l != 0L) {
              break label384;
            }
            paramBoolean = true;
            localMiniAppCmdInterface.onCmdListener(paramBoolean, paramBundle);
          }
          if (localMiniAppInfo == null) {
            break label383;
          }
          this.this$0.getExtConfigDetail(localMiniAppInfo.commonExt, localMiniAppInfo.extConfigInfoList, new MiniAppCmdUtil.1.1(this));
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call onGetAppInfoByLinkFin fail.");
        if (localMiniAppCmdInterface == null) {
          break label383;
        }
        paramBundle = new JSONObject();
        paramBundle.put("retCode", l);
        paramBundle.put("errMsg", localObject);
        localMiniAppCmdInterface.onCmdListener(false, paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onGetAppInfoByLinkFin exception ", paramBundle);
        if (localMiniAppCmdInterface == null) {
          break label383;
        }
      }
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("onGetAppInfoByLinkFin can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      label383:
      return;
      label384:
      paramBoolean = false;
    }
  }
  
  protected void onGetAppInfoByLinkFinForSDK(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetAppInfoByLinkFinForSDK(paramInt, paramBoolean, paramBundle);
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt)))) {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      try
      {
        long l = paramBundle.getLong("retCode", -1L);
        Object localObject = paramBundle.getString("errMsg", HardCodeUtil.a(2131904658));
        if (paramBoolean)
        {
          com.tencent.qqmini.sdk.launcher.model.MiniAppInfo localMiniAppInfo = (com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)paramBundle.getParcelable("mini_app_info_data");
          String str = paramBundle.getString("shareTicket", "");
          paramBundle = new JSONObject();
          paramBundle.put("mini_app_info_data", localMiniAppInfo);
          paramBundle.put("shareTicket", str);
          paramBundle.put("retCode", l);
          paramBundle.put("errMsg", localObject);
          if (localMiniAppCmdInterface != null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("  onGetAppInfoByLinkFinForSDK . ");
            ((StringBuilder)localObject).append(paramInt);
            QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
            if (l != 0L) {
              break label362;
            }
            paramBoolean = true;
            localMiniAppCmdInterface.onCmdListener(paramBoolean, paramBundle);
          }
          if (localMiniAppInfo == null) {
            break label361;
          }
          this.this$0.getExtConfigDetail(localMiniAppInfo.commonExt, MiniSdkUtil.a(localMiniAppInfo.extConfigInfoList), new MiniAppCmdUtil.1.4(this));
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call onGetAppInfoByLinkFinForSDK fail.");
        if (localMiniAppCmdInterface == null) {
          break label361;
        }
        paramBundle = new JSONObject();
        paramBundle.put("retCode", l);
        paramBundle.put("errMsg", localObject);
        localMiniAppCmdInterface.onCmdListener(false, paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onGetAppInfoByLinkFinForSDK exception ", paramBundle);
        if (localMiniAppCmdInterface == null) {
          break label361;
        }
      }
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("onGetAppInfoByLinkFinForSDK can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      label361:
      return;
      label362:
      paramBoolean = false;
    }
  }
  
  protected void onGetAuthList(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetAuthList(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        localObject = new JSONObject();
        if (paramBoolean)
        {
          if (paramBundle != null)
          {
            ((JSONObject)localObject).put("authList", paramBundle.get("key_get_auth_list_result"));
            ((JSONObject)localObject).put("extendInfo", paramBundle.get("key_ext"));
          }
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(true, (JSONObject)localObject);
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call onGetAuthList fail.");
        if (!TextUtils.isEmpty(paramBundle.getString("errMsg"))) {
          ((JSONObject)localObject).put("errMsg", paramBundle.getString("errMsg"));
        }
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(false, (JSONObject)localObject);
        return;
      }
      catch (Exception paramBundle)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("call onGetAuthList exception ");
        ((StringBuilder)localObject).append(paramBundle);
        QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onGetAuthList can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onGetCMShowInfo(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("retCode", paramBundle.getLong("retCode"));
        localJSONObject.put("errMsg", paramBundle.getString("errMsg"));
        if (paramBoolean) {
          localJSONObject.put("result_data", paramBundle.getString("result_data"));
        }
      }
      catch (Throwable paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "onGetCMShowInfo error. ", paramBundle);
      }
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onGetCMShowInfo can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onGetContentAccelerateServlet(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt)))) {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      try
      {
        long l = paramBundle.getLong("retCode", 0L);
        Object localObject = paramBundle.getString("errMsg");
        if (paramBoolean)
        {
          paramBundle.setClassLoader(PreCacheManager.ContentAccelerateRsp.class.getClassLoader());
          PreCacheManager.ContentAccelerateRsp localContentAccelerateRsp = (PreCacheManager.ContentAccelerateRsp)paramBundle.getParcelable("mini_rsp_data");
          paramBundle = new JSONObject();
          paramBundle.put("mini_rsp_data", localContentAccelerateRsp);
          paramBundle.put("retCode", l);
          paramBundle.put("errMsg", localObject);
          if (localMiniAppCmdInterface == null) {
            break label302;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onGetContentAccelerateServlet . ");
          ((StringBuilder)localObject).append(paramInt);
          QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
          if (l != 0L) {
            break label303;
          }
          paramBoolean = true;
          localMiniAppCmdInterface.onCmdListener(paramBoolean, paramBundle);
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call onGetContentAccelerateServlet fail.");
        if (localMiniAppCmdInterface == null) {
          break label302;
        }
        paramBundle = new JSONObject();
        paramBundle.put("retCode", l);
        paramBundle.put("errMsg", localObject);
        localMiniAppCmdInterface.onCmdListener(false, paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onGetContentAccelerateServlet exception ", paramBundle);
        if (localMiniAppCmdInterface == null) {
          break label302;
        }
      }
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("onGetContentAccelerateServlet can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      label302:
      return;
      label303:
      paramBoolean = false;
    }
  }
  
  protected void onGetExtConfigDetail(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      Object localObject = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean)
      {
        paramBundle = paramBundle.getString("key_ext_config_detail_result");
        try
        {
          paramBundle = new JSONObject(paramBundle);
          JSONObject localJSONObject = paramBundle.optJSONObject("apiscopeconfig");
          if (localJSONObject != null)
          {
            BaseApplicationImpl.getApplication().getSharedPreferences("MiniAppExtConfigDetail", 4).edit().putString("MiniAppExtConfigDetail", localJSONObject.toString()).commit();
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("apiScopeConfigJson ");
              localStringBuilder.append(localJSONObject.toString());
              QLog.i("[mini] MiniAppObserver", 2, localStringBuilder.toString());
            }
          }
          if (localObject != null) {
            ((MiniAppCmdInterface)localObject).onCmdListener(true, paramBundle);
          }
          if (!QLog.isColorLevel()) {
            break label256;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onGetExtConfigDetail ");
          ((StringBuilder)localObject).append(paramBundle.toString());
          QLog.i("[mini] MiniAppObserver", 2, ((StringBuilder)localObject).toString());
          return;
        }
        catch (Throwable paramBundle)
        {
          QLog.e("[mini] MiniAppObserver", 1, "onGetExtConfigDetail error.", paramBundle);
          return;
        }
      }
      else if (localObject != null)
      {
        ((MiniAppCmdInterface)localObject).onCmdListener(false, new JSONObject());
      }
      label256:
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("onGetExtConfigDetail can not found listener. ");
    paramBundle.append(paramInt);
    QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
  }
  
  protected void onGetFormId(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetFormId(paramInt, paramBoolean, paramBundle);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetFormId() called with: index = [");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], isSuccess = [");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("], bundle = [");
    ((StringBuilder)localObject).append(paramBundle);
    ((StringBuilder)localObject).append("]");
    QLog.d("[mini] MiniAppObserver", 2, ((StringBuilder)localObject).toString());
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localObject = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      JSONObject localJSONObject = new JSONObject();
      if (paramBoolean) {
        try
        {
          localJSONObject.putOpt("formId", paramBundle.getString("formId", ""));
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
        }
      }
      ((MiniAppCmdInterface)localObject).onCmdListener(paramBoolean, localJSONObject);
    }
  }
  
  protected void onGetFriendCloudStorage(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        if (TextUtils.isEmpty(paramBundle.getString("key_reslut_data"))) {
          paramBundle = new JSONObject("{data:[]}");
        } else {
          paramBundle = new JSONObject(paramBundle.getString("key_reslut_data"));
        }
      }
      catch (Throwable paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "onGetFriendCloudStorage error. ", paramBundle);
      }
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{data:[],error:\"");
      localStringBuilder.append(paramBundle.getMessage());
      localStringBuilder.append("\"}");
      paramBundle = new JSONObject(localStringBuilder.toString());
    }
    catch (Throwable paramBundle)
    {
      label153:
      break label153;
    }
    paramBundle = new JSONObject();
    if (localMiniAppCmdInterface != null)
    {
      localMiniAppCmdInterface.onCmdListener(paramBoolean, paramBundle);
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("onGetFriendCloudStorage can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onGetGameRaffleMaterial(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("retCode", paramBundle.getLong("retCode", -1L));
        localJSONObject.put("errMsg", paramBundle.getString("errMsg"));
        if (paramBoolean) {
          localJSONObject.put("key_result_data", paramBundle.getString("key_result_data"));
        }
      }
      catch (Throwable paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "onGetGameRaffleMaterial error. ", paramBundle);
      }
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onGetGameRaffleMaterial can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onGetGeneralCmdFin(int paramInt, long paramLong, byte[] paramArrayOfByte, String paramString)
  {
    super.onGetGeneralCmdFin(paramInt, paramLong, paramArrayOfByte, paramString);
    if ((MiniAppCmdUtil.access$300(this.this$0) != null) && (MiniAppCmdUtil.access$300(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppProxy.SenderListener localSenderListener = (MiniAppProxy.SenderListener)MiniAppCmdUtil.access$300(this.this$0).remove(Integer.valueOf(paramInt));
      if (localSenderListener != null) {
        localSenderListener.onReply((int)paramLong, paramArrayOfByte, paramString);
      }
    }
    else
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("onGetGeneralCmdFin can not found listener. ");
      paramArrayOfByte.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramArrayOfByte.toString());
    }
  }
  
  protected void onGetGroupCloudStorage(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        paramBundle = paramBundle.getString("key_reslut_data");
        if (TextUtils.isEmpty(paramBundle)) {
          paramBundle = new JSONObject("{data:[]}");
        } else {
          paramBundle = new JSONObject(paramBundle);
        }
      }
      catch (Throwable paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "onGetGroupCloudStorage error. ", paramBundle);
      }
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{data:[],error:\"");
      localStringBuilder.append(paramBundle.getMessage());
      localStringBuilder.append("\"}");
      paramBundle = new JSONObject(localStringBuilder.toString());
    }
    catch (Throwable paramBundle)
    {
      label150:
      break label150;
    }
    paramBundle = new JSONObject();
    if (localMiniAppCmdInterface != null)
    {
      localMiniAppCmdInterface.onCmdListener(paramBoolean, paramBundle);
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("onGetGroupCloudStorage can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onGetGroupShareInfo(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (!paramBoolean) {}
    }
    label297:
    try
    {
      Object localObject = (FromServiceMsg)paramBundle.getParcelable("getGroupShareInfo");
      str = paramBundle.getString("getGroupShareInfoErrMsg");
      paramInt = paramBundle.getInt("getGroupShareInfoRetCode");
      if (localObject != null)
      {
        paramBundle = MiniAppGetGroupShareInfoRequest.onResponse(WupUtil.b(((FromServiceMsg)localObject).getWupBuffer()));
        localObject = new JSONObject();
        ((JSONObject)localObject).put("response", paramBundle);
        ((JSONObject)localObject).put("resultCode", paramInt);
        ((JSONObject)localObject).put("errMsg", str);
        if (localMiniAppCmdInterface == null) {
          break label297;
        }
        localMiniAppCmdInterface.onCmdListener(true, (JSONObject)localObject);
        return;
      }
      QLog.d("[mini] MiniAppObserver", 1, "call getGroupShareInfo FromServiceMsg rsp is null.");
      if (localMiniAppCmdInterface == null) {
        break label297;
      }
      localMiniAppCmdInterface.onCmdListener(true, new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      String str;
      label211:
      break label211;
    }
    QLog.d("[mini] MiniAppObserver", 1, "call getGroupShareInfo fail.");
    if (localMiniAppCmdInterface != null)
    {
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("call getGroupShareInfo exception ");
      paramBundle.append(str);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        paramBundle = new StringBuilder();
        paramBundle.append("getGroupShareInfo can not found listener. ");
        paramBundle.append(paramInt);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      }
    }
  }
  
  protected void onGetHotSearchApps(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      Object localObject = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        long l = paramBundle.getLong("retCode", -1L);
        String str = paramBundle.getString("errMsg", HardCodeUtil.a(2131904660));
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("retCode", l);
        localJSONObject.put("errMsg", str);
        if (paramBoolean)
        {
          paramBundle = (FromServiceMsg)paramBundle.getParcelable("getHotSearchApps");
          if (paramBundle != null)
          {
            localJSONObject.put("getHotSearchAppsResponse", GetHotSearchAppsRequest.onResponse(WupUtil.b(paramBundle.getWupBuffer())));
            if (localObject == null) {
              return;
            }
            ((MiniAppCmdInterface)localObject).onCmdListener(true, localJSONObject);
            return;
          }
          QLog.e("[mini] MiniAppObserver", 1, "call onGetHotSearchApps FromServiceMsg rsp is null.");
          if (localObject == null) {
            return;
          }
          ((MiniAppCmdInterface)localObject).onCmdListener(false, localJSONObject);
          return;
        }
        paramBundle = new StringBuilder();
        paramBundle.append("call onGetHotSearchApps fail. errCode = ");
        paramBundle.append(l);
        paramBundle.append(", errMsg = ");
        paramBundle.append(str);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
        if (localObject == null) {
          return;
        }
        ((MiniAppCmdInterface)localObject).onCmdListener(false, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("call onGetHotSearchApps exception ");
        ((StringBuilder)localObject).append(Log.getStackTraceString(paramBundle));
        QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onGetHotSearchApps can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onGetKuolieAppListServlet(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetAppInfoByLinkFin(paramInt, paramBoolean, paramBundle);
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt)))) {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      try
      {
        long l = paramBundle.getLong("retCode", -1L);
        Object localObject = paramBundle.getString("errMsg", HardCodeUtil.a(2131904664));
        if (paramBoolean)
        {
          MiniAppRecommInfo localMiniAppRecommInfo = (MiniAppRecommInfo)paramBundle.getSerializable("mini_kuolie_applist_data");
          paramBundle = new JSONObject();
          paramBundle.put("data", localMiniAppRecommInfo);
          paramBundle.put("retCode", l);
          paramBundle.put("errMsg", localObject);
          if (localMiniAppCmdInterface == null) {
            break label307;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("  onGetKuolieAppListServlet . ");
          ((StringBuilder)localObject).append(paramInt);
          QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
          if (l != 0L) {
            break label308;
          }
          paramBoolean = true;
          localMiniAppCmdInterface.onCmdListener(paramBoolean, paramBundle);
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call onGetKuolieAppListServlet fail.");
        if (localMiniAppCmdInterface == null) {
          break label307;
        }
        paramBundle = new JSONObject();
        paramBundle.put("retCode", l);
        paramBundle.put("errMsg", localObject);
        localMiniAppCmdInterface.onCmdListener(false, paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onGetKuolieAppListServlet exception ", paramBundle);
        if (localMiniAppCmdInterface == null) {
          break label307;
        }
      }
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("onGetKuolieAppListServlet can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      label307:
      return;
      label308:
      paramBoolean = false;
    }
  }
  
  protected void onGetLoginCodeFin(int paramInt, boolean paramBoolean, String paramString1, long paramLong, String paramString2)
  {
    super.onGetLoginCodeFin(paramInt, paramBoolean, paramString1, paramLong, paramString2);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean)
      {
        try
        {
          paramString2 = new JSONObject();
          paramString2.put("code", paramString1);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("call API_LOGIN  code:");
          localStringBuilder.append(paramString1);
          QLog.d("[mini] MiniAppObserver", 1, localStringBuilder.toString());
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(paramBoolean, paramString2);
          return;
        }
        catch (Exception paramString1)
        {
          paramString2 = new StringBuilder();
          paramString2.append("call API_LOGIN exception ");
          paramString2.append(paramString1);
          QLog.e("[mini] MiniAppObserver", 1, paramString2.toString());
          if (localMiniAppCmdInterface == null) {
            return;
          }
        }
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      }
      else
      {
        QLog.e("[mini] MiniAppObserver", 1, "call API_LOGIN failed ");
        if (localMiniAppCmdInterface != null)
        {
          paramString1 = new JSONObject();
          try
          {
            paramString1.put("retCode", paramLong);
            paramString1.put("errMsg", paramString2);
          }
          catch (Exception paramString2)
          {
            QLog.d("[mini] MiniAppObserver", 1, "call onBatchGetUserInfoResult exception", paramString2);
          }
          localMiniAppCmdInterface.onCmdListener(false, paramString1);
        }
      }
    }
    else
    {
      paramString1 = new StringBuilder();
      paramString1.append("onGetLoginCodeFin can not found listener. ");
      paramString1.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramString1.toString());
    }
  }
  
  protected void onGetMidasConsumeResult(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (!paramBoolean) {}
    }
    label297:
    try
    {
      Object localObject = (FromServiceMsg)paramBundle.getParcelable("getMidasConsumeResult");
      str = paramBundle.getString("getMidasConsumeResultErrMsg");
      paramInt = paramBundle.getInt("getMidasConsumeResultRetCode");
      if (localObject != null)
      {
        paramBundle = PayRequest.onResponse(WupUtil.b(((FromServiceMsg)localObject).getWupBuffer()));
        localObject = new JSONObject();
        ((JSONObject)localObject).put("response", paramBundle);
        ((JSONObject)localObject).put("resultCode", paramInt);
        ((JSONObject)localObject).put("errMsg", str);
        if (localMiniAppCmdInterface == null) {
          break label297;
        }
        localMiniAppCmdInterface.onCmdListener(true, (JSONObject)localObject);
        return;
      }
      QLog.d("[mini] MiniAppObserver", 1, "call getMidasConsumeResult FromServiceMsg rsp is null.");
      if (localMiniAppCmdInterface == null) {
        break label297;
      }
      localMiniAppCmdInterface.onCmdListener(true, new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      String str;
      label211:
      break label211;
    }
    QLog.d("[mini] MiniAppObserver", 1, "call getMidasConsumeResult fail.");
    if (localMiniAppCmdInterface != null)
    {
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("call getMidasConsumeResult exception ");
      paramBundle.append(str);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        paramBundle = new StringBuilder();
        paramBundle.append("getMidasConsumeResult can not found listener. ");
        paramBundle.append(paramInt);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      }
    }
  }
  
  protected void onGetMidasQueryResult(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (!paramBoolean) {}
    }
    label297:
    try
    {
      Object localObject = (FromServiceMsg)paramBundle.getParcelable("getMidasQueryResult");
      str = paramBundle.getString("getMidasQueryResultErrMsg");
      paramInt = paramBundle.getInt("getMidasQueryResultRetCode");
      if (localObject != null)
      {
        paramBundle = QueryCurrencyRequest.onResponse(WupUtil.b(((FromServiceMsg)localObject).getWupBuffer()));
        localObject = new JSONObject();
        ((JSONObject)localObject).put("response", paramBundle);
        ((JSONObject)localObject).put("resultCode", paramInt);
        ((JSONObject)localObject).put("errMsg", str);
        if (localMiniAppCmdInterface == null) {
          break label297;
        }
        localMiniAppCmdInterface.onCmdListener(true, (JSONObject)localObject);
        return;
      }
      QLog.d("[mini] MiniAppObserver", 1, "call getMidasQueryResult FromServiceMsg rsp is null.");
      if (localMiniAppCmdInterface == null) {
        break label297;
      }
      localMiniAppCmdInterface.onCmdListener(true, new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      String str;
      label211:
      break label211;
    }
    QLog.d("[mini] MiniAppObserver", 1, "call onGetMidasQueryResult fail.");
    if (localMiniAppCmdInterface != null)
    {
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("call onGetMidasQueryResult exception ");
      paramBundle.append(str);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        paramBundle = new StringBuilder();
        paramBundle.append("onGetMidasQueryResult can not found listener. ");
        paramBundle.append(paramInt);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      }
    }
  }
  
  protected void onGetNativeAppInfoForJump(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (!paramBoolean) {}
    }
    label299:
    try
    {
      localJSONObject = new JSONObject();
      String str1 = paramBundle.get("key_package_name").toString();
      String str2 = paramBundle.get("key_native_app_id").toString();
      String str3 = paramBundle.get("key_app_id").toString();
      paramInt = paramBundle.getInt("key_only_open");
      paramBundle = paramBundle.getString("key_download_url").toString();
      localJSONObject.put("packageName", str1);
      localJSONObject.put("nativeAppId", str2);
      localJSONObject.put("appName", str3);
      localJSONObject.put("onlyOpen", paramInt);
      localJSONObject.put("downloadUrl", paramBundle);
      if (localMiniAppCmdInterface == null) {
        break label299;
      }
      localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject;
      label213:
      break label213;
    }
    QLog.d("[mini] MiniAppObserver", 1, "call onGetNativeAppInfoForJump fail.");
    if (localMiniAppCmdInterface != null)
    {
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("call onGetNativeAppInfoForJump exception ");
      paramBundle.append(localJSONObject);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        paramBundle = new StringBuilder();
        paramBundle.append("onGetNativeAppInfoForJump can not found listener. ");
        paramBundle.append(paramInt);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      }
    }
  }
  
  protected void onGetNewBaseLibFin(int paramInt, boolean paramBoolean, String paramString1, String paramString2, Bundle paramBundle)
  {
    super.onGetNewBaseLibFin(paramInt, paramBoolean, paramString1, paramString2, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean) {}
      try
      {
        QLog.d("[mini] MiniAppObserver", 1, "call onGetNewBaseLibFin success.");
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("version", paramString1);
        localJSONObject.put("downloadUrl", paramString2);
        paramString1 = (com.tencent.mobileqq.mini.sdk.BaseLibInfo)paramBundle.getParcelable(com.tencent.mobileqq.mini.sdk.BaseLibInfo.getKey(2));
        if (paramString1 != null) {
          localJSONObject.put(com.tencent.mobileqq.mini.sdk.BaseLibInfo.getKey(2), paramString1.toJSONObject());
        }
        paramString1 = (com.tencent.mobileqq.mini.sdk.BaseLibInfo)paramBundle.getParcelable(com.tencent.mobileqq.mini.sdk.BaseLibInfo.getKey(3));
        if (paramString1 != null) {
          localJSONObject.put(com.tencent.mobileqq.mini.sdk.BaseLibInfo.getKey(3), paramString1.toJSONObject());
        }
        paramString1 = (com.tencent.mobileqq.mini.sdk.BaseLibInfo)paramBundle.getParcelable(com.tencent.mobileqq.mini.sdk.BaseLibInfo.getKey(1));
        if (paramString1 != null) {
          localJSONObject.put(com.tencent.mobileqq.mini.sdk.BaseLibInfo.getKey(1), paramString1.toJSONObject());
        }
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
        return;
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("call onGetNewBaseLibFin exception ");
        paramString2.append(paramString1);
        QLog.e("[mini] MiniAppObserver", 1, paramString2.toString());
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      QLog.d("[mini] MiniAppObserver", 1, "call onGetNewBaseLibFin fail.");
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      }
    }
    else
    {
      paramString1 = new StringBuilder();
      paramString1.append("onGetNewBaseLibFin can not found listener. ");
      paramString1.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramString1.toString());
    }
  }
  
  protected void onGetNewBaseLibFinForSDK(int paramInt, boolean paramBoolean, String paramString1, String paramString2, Bundle paramBundle)
  {
    super.onGetNewBaseLibFinForSDK(paramInt, paramBoolean, paramString1, paramString2, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean) {}
      try
      {
        QLog.d("[mini] MiniAppObserver", 1, "call onGetNewBaseLibFinForSDK success.");
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("version", paramString1);
        localJSONObject.put("downloadUrl", paramString2);
        paramString1 = (com.tencent.qqmini.sdk.launcher.model.BaseLibInfo)paramBundle.getParcelable(com.tencent.mobileqq.mini.sdk.BaseLibInfo.getKey(2));
        if (paramString1 != null) {
          localJSONObject.put(com.tencent.mobileqq.mini.sdk.BaseLibInfo.getKey(2), paramString1.toJSONObject());
        }
        paramString1 = (com.tencent.qqmini.sdk.launcher.model.BaseLibInfo)paramBundle.getParcelable(com.tencent.mobileqq.mini.sdk.BaseLibInfo.getKey(3));
        if (paramString1 != null) {
          localJSONObject.put(com.tencent.mobileqq.mini.sdk.BaseLibInfo.getKey(3), paramString1.toJSONObject());
        }
        paramString1 = (com.tencent.qqmini.sdk.launcher.model.BaseLibInfo)paramBundle.getParcelable(com.tencent.mobileqq.mini.sdk.BaseLibInfo.getKey(1));
        if (paramString1 != null) {
          localJSONObject.put(com.tencent.mobileqq.mini.sdk.BaseLibInfo.getKey(1), paramString1.toJSONObject());
        }
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
        return;
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("call onGetNewBaseLibFinForSDK exception ");
        paramString2.append(paramString1);
        QLog.e("[mini] MiniAppObserver", 1, paramString2.toString());
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      QLog.d("[mini] MiniAppObserver", 1, "call onGetNewBaseLibFinForSDK fail.");
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      }
    }
    else
    {
      paramString1 = new StringBuilder();
      paramString1.append("onGetNewBaseLibFinForSDK can not found listener. ");
      paramString1.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramString1.toString());
    }
  }
  
  protected void onGetPhoneNumber(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetPhoneNumber(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (localMiniAppCmdInterface != null)
      {
        if ((paramBoolean) && (paramBundle != null) && (paramBundle.containsKey("data")))
        {
          INTERFACE.StGetPhoneNumberRsp localStGetPhoneNumberRsp = new INTERFACE.StGetPhoneNumberRsp();
          try
          {
            paramBundle = paramBundle.getByteArray("data");
            if (paramBundle != null)
            {
              localStGetPhoneNumberRsp.mergeFrom(paramBundle);
              Object localObject = localStGetPhoneNumberRsp.phoneLists.get();
              paramBundle = new JSONArray();
              if ((localObject != null) && (((List)localObject).size() > 0))
              {
                localObject = ((List)localObject).iterator();
                while (((Iterator)localObject).hasNext())
                {
                  INTERFACE.StPhoneNumber localStPhoneNumber = (INTERFACE.StPhoneNumber)((Iterator)localObject).next();
                  if (localStPhoneNumber != null)
                  {
                    JSONObject localJSONObject = new JSONObject();
                    localJSONObject.put("phoneType", localStPhoneNumber.phoneType.get());
                    localJSONObject.put("purePhoneNumber", localStPhoneNumber.purePhoneNumber.get());
                    localJSONObject.put("countryCode", localStPhoneNumber.countryCode.get());
                    localJSONObject.put("iv", localStPhoneNumber.iv.get());
                    localJSONObject.put("encryptedData", localStPhoneNumber.encryptedData.get());
                    paramBundle.put(localJSONObject);
                  }
                }
              }
              localMiniAppCmdInterface.onCmdListener(true, new JSONObject().put("countryCode", localStGetPhoneNumberRsp.countryCode.get()).put("purePhoneNumber", localStGetPhoneNumberRsp.purePhoneNumber.get()).put("iv", localStGetPhoneNumberRsp.iv.get()).put("encryptedData", localStGetPhoneNumberRsp.encryptedData.get()).put("cloudID", "").put("phoneLists", paramBundle).put("errMsg", "ok"));
              return;
            }
            QLog.e("[mini] MiniAppObserver", 2, "onGetPhoneNumber no bytes data found");
            return;
          }
          catch (Exception paramBundle)
          {
            QLog.e("[mini] MiniAppObserver", 1, "onGetPhoneNumber", paramBundle);
            localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
            return;
          }
        }
        if (paramBundle != null)
        {
          long l = paramBundle.getLong("retCode");
          paramBundle = paramBundle.getString("errMsg");
          try
          {
            localMiniAppCmdInterface.onCmdListener(false, new JSONObject().put("retCode", l).put("errMsg", paramBundle));
          }
          catch (JSONException paramBundle)
          {
            paramBundle.printStackTrace();
          }
        }
        QLog.e("[mini] MiniAppObserver", 1, "onGetPhoneNumber no data found");
        return;
      }
      QLog.e("[mini] MiniAppObserver", 2, "onGetPhoneNumber empty listener");
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("onGetPhoneNumber no listener for ");
    paramBundle.append(paramInt);
    QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
  }
  
  protected void onGetPotentialFriendList(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (!paramBoolean) {}
    }
    label310:
    try
    {
      localFromServiceMsg = (FromServiceMsg)paramBundle.getParcelable("getPotentialFriendList");
      long l = paramBundle.getLong("retCode");
      paramBundle = paramBundle.getString("errMsg");
      if (localFromServiceMsg != null)
      {
        CloudStorage.StGetPotentialFriendListRsp localStGetPotentialFriendListRsp = GetPotentialFriendListRequest.onResponse(WupUtil.b(localFromServiceMsg.getWupBuffer()));
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("response", localStGetPotentialFriendListRsp);
        localJSONObject.put("resultCode", localFromServiceMsg.getResultCode());
        localJSONObject.put("retCode", l);
        localJSONObject.put("errMsg", paramBundle);
        if (localMiniAppCmdInterface == null) {
          break label310;
        }
        localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
        return;
      }
      QLog.d("[mini] MiniAppObserver", 1, "call getPotentialFriendList FromServiceMsg rsp is null.");
      if (localMiniAppCmdInterface == null) {
        break label310;
      }
      localMiniAppCmdInterface.onCmdListener(true, new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      FromServiceMsg localFromServiceMsg;
      label224:
      break label224;
    }
    QLog.d("[mini] MiniAppObserver", 1, "call getPotentialFriendList fail.");
    if (localMiniAppCmdInterface != null)
    {
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("call getPotentialFriendList exception ");
      paramBundle.append(localFromServiceMsg);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        paramBundle = new StringBuilder();
        paramBundle.append("getPotentialFriendList can not found listener. ");
        paramBundle.append(paramInt);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      }
    }
  }
  
  protected void onGetProfileFin(int paramInt1, String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, long paramLong, String paramString12)
  {
    super.onGetProfileFin(paramInt1, paramString1, paramBoolean, paramString2, paramString3, paramInt2, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramLong, paramString12);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt1))))
    {
      paramString1 = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt1));
      if (paramBoolean)
      {
        try
        {
          JSONObject localJSONObject1 = new JSONObject();
          JSONObject localJSONObject2 = new JSONObject();
          paramString12 = new JSONObject();
          localJSONObject1.put("nickName", paramString2);
          localJSONObject1.put("avatarUrl", paramString3);
          localJSONObject1.put("gender", paramInt2);
          localJSONObject1.put("province", paramString5);
          localJSONObject1.put("city", paramString6);
          localJSONObject1.put("country", paramString4);
          localJSONObject1.put("language", paramString7);
          paramString12.put("rawData", paramString8);
          paramString12.put("signature", paramString9);
          paramString12.put("encryptedData", paramString10);
          paramString12.put("iv", paramString11);
          paramString12.put("userInfo", localJSONObject1);
          localJSONObject2.put("data", paramString8);
          localJSONObject2.put("signature", paramString9);
          paramString12.put("data", localJSONObject2.toString());
          paramString2 = new StringBuilder();
          paramString2.append("call getUserInfo ： ");
          paramString2.append(paramString12.toString());
          QLog.d("[mini] MiniAppObserver", 1, paramString2.toString());
          if (paramString1 == null) {
            return;
          }
          paramString1.onCmdListener(true, paramString12);
          return;
        }
        catch (Exception paramString2)
        {
          paramString3 = new StringBuilder();
          paramString3.append("call getUserInfo exception ");
          paramString3.append(paramString2);
          QLog.e("[mini] MiniAppObserver", 1, paramString3.toString());
          if (paramString1 == null) {
            return;
          }
        }
        paramString1.onCmdListener(false, new JSONObject());
      }
      else
      {
        QLog.e("[mini] MiniAppObserver", 1, "call getUserInfo failed ");
        if (paramString1 != null)
        {
          paramString2 = new JSONObject();
          try
          {
            paramString2.put("retCode", paramLong);
            paramString2.put("errMsg", paramString12);
          }
          catch (Exception paramString3)
          {
            QLog.d("[mini] MiniAppObserver", 1, "call onBatchGetUserInfoResult exception", paramString3);
          }
          paramString1.onCmdListener(false, paramString2);
        }
      }
    }
    else
    {
      paramString1 = new StringBuilder();
      paramString1.append("onGetProfileFin can not found listener. ");
      paramString1.append(paramInt1);
      QLog.e("[mini] MiniAppObserver", 1, paramString1.toString());
    }
  }
  
  protected void onGetReactiveFriendList(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (!paramBoolean) {}
    }
    label310:
    try
    {
      localFromServiceMsg = (FromServiceMsg)paramBundle.getParcelable("getReactiveFriendList");
      long l = paramBundle.getLong("retCode");
      paramBundle = paramBundle.getString("errMsg");
      if (localFromServiceMsg != null)
      {
        CloudStorage.StGetReactiveFriendListRsp localStGetReactiveFriendListRsp = GetReactiveFriendListRequest.onResponse(WupUtil.b(localFromServiceMsg.getWupBuffer()));
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("response", localStGetReactiveFriendListRsp);
        localJSONObject.put("resultCode", localFromServiceMsg.getResultCode());
        localJSONObject.put("retCode", l);
        localJSONObject.put("errMsg", paramBundle);
        if (localMiniAppCmdInterface == null) {
          break label310;
        }
        localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
        return;
      }
      QLog.d("[mini] MiniAppObserver", 1, "call getReactiveFriendList FromServiceMsg rsp is null.");
      if (localMiniAppCmdInterface == null) {
        break label310;
      }
      localMiniAppCmdInterface.onCmdListener(true, new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      FromServiceMsg localFromServiceMsg;
      label224:
      break label224;
    }
    QLog.d("[mini] MiniAppObserver", 1, "call getReactiveFriendList fail.");
    if (localMiniAppCmdInterface != null)
    {
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("call getReactiveFriendList exception ");
      paramBundle.append(localFromServiceMsg);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        paramBundle = new StringBuilder();
        paramBundle.append("getReactiveFriendList can not found listener. ");
        paramBundle.append(paramInt);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      }
    }
  }
  
  protected void onGetRecommendAppList(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetRecommendAppList(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      Object localObject = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        long l = paramBundle.getLong("retCode", -1L);
        String str = paramBundle.getString("errMsg", HardCodeUtil.a(2131904662));
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("retCode", l);
        localJSONObject.put("errMsg", str);
        if (paramBoolean)
        {
          paramBundle = (FromServiceMsg)paramBundle.getParcelable("key_recommend_module");
          if (paramBundle != null)
          {
            localJSONObject.put("response", GetRecommendAppListRequest.onResponse(WupUtil.b(paramBundle.getWupBuffer())));
            if (localObject == null) {
              return;
            }
            ((MiniAppCmdInterface)localObject).onCmdListener(true, localJSONObject);
            return;
          }
          QLog.e("[mini] MiniAppObserver", 1, "call onGetUserAppListV2 FromServiceMsg rsp is null.");
          if (localObject == null) {
            return;
          }
          ((MiniAppCmdInterface)localObject).onCmdListener(false, localJSONObject);
          return;
        }
        paramBundle = new StringBuilder();
        paramBundle.append("call onGetUserAppListV2 fail. errCode = ");
        paramBundle.append(l);
        paramBundle.append(", errMsg = ");
        paramBundle.append(str);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
        if (localObject == null) {
          return;
        }
        ((MiniAppCmdInterface)localObject).onCmdListener(false, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("call onGetUserAppListV2 exception ");
        ((StringBuilder)localObject).append(Log.getStackTraceString(paramBundle));
        QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onGetUserAppListV2 can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onGetRewardedVideoAdResult(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetRewardedVideoAdResult, index=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
      localObject = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (!paramBoolean) {}
    }
    try
    {
      localFromServiceMsg = (FromServiceMsg)paramBundle.getParcelable("getRewardedVideoADInfo");
      long l = paramBundle.getLong("retCode");
      paramBundle = paramBundle.getString("errMsg");
      if (localFromServiceMsg != null)
      {
        MiniAppAd.StGetAdRsp localStGetAdRsp = MiniAppGetAdRequest.onResponse(WupUtil.b(localFromServiceMsg.getWupBuffer()));
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("response", localStGetAdRsp);
        localJSONObject.put("resultCode", localFromServiceMsg.getResultCode());
        localJSONObject.put("retCode", l);
        localJSONObject.put("errMsg", paramBundle);
        if (localObject == null) {
          break label346;
        }
        ((MiniAppCmdInterface)localObject).onCmdListener(true, localJSONObject);
        return;
      }
      QLog.d("[mini] MiniAppObserver", 1, "call getRewardedVideoADInfo FromServiceMsg rsp is null.");
      if (localObject == null) {
        break label346;
      }
      ((MiniAppCmdInterface)localObject).onCmdListener(true, new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      FromServiceMsg localFromServiceMsg;
      label260:
      label346:
      break label260;
    }
    QLog.d("[mini] MiniAppObserver", 1, "call onGetRewardedVideoAdResult fail.");
    if (localObject != null)
    {
      ((MiniAppCmdInterface)localObject).onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("call onGetRewardedVideoAdResult exception ");
      paramBundle.append(localFromServiceMsg);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      if (localObject != null)
      {
        ((MiniAppCmdInterface)localObject).onCmdListener(false, new JSONObject());
        return;
        paramBundle = new StringBuilder();
        paramBundle.append("onGetRewardedVideoAdResult can not found listener. ");
        paramBundle.append(paramInt);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      }
    }
  }
  
  protected void onGetRobotUin(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean)
      {
        paramBundle = paramBundle.getString("key_robot_result_uin");
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("robotUin", paramBundle);
          if (localMiniAppCmdInterface == null) {
            break label128;
          }
          localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
          return;
        }
        catch (Throwable paramBundle)
        {
          QLog.e("[mini] MiniAppObserver", 1, "onGetRobotUin error.", paramBundle);
          return;
        }
      }
      else if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      }
      label128:
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("onGetRobotUin can not found listener. ");
    paramBundle.append(paramInt);
    QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
  }
  
  protected void onGetShareInfo(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetShareInfo(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        long l = paramBundle.getLong("retCode", -1L);
        localObject1 = paramBundle.getString("errMsg", HardCodeUtil.a(2131904657));
        if (paramBoolean)
        {
          if ((l != -100070004L) && (l != -1000710003L))
          {
            if (localMiniAppCmdInterface == null) {
              return;
            }
            localObject1 = new JSONObject(paramBundle.getString("jsonData"));
            ((JSONObject)localObject1).put("needShareCallBack", paramBundle.getBoolean("needShareCallBack", false));
            localMiniAppCmdInterface.onCmdListener(true, (JSONObject)localObject1);
            return;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onGetShareInfo isSuccess=false, retCode=");
          ((StringBuilder)localObject2).append(l);
          QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject2).toString());
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("retCode", l);
          ((JSONObject)localObject2).put("errMsg", localObject1);
          ((JSONObject)localObject2).put("needShareCallBack", paramBundle.getBoolean("needShareCallBack", false));
          localMiniAppCmdInterface.onCmdListener(false, (JSONObject)localObject2);
          return;
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onGetShareInfo isSuccess=false, retCode=");
        ((StringBuilder)localObject2).append(l);
        QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject2).toString());
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("retCode", l);
        ((JSONObject)localObject2).put("errMsg", localObject1);
        ((JSONObject)localObject2).put("needShareCallBack", paramBundle.getBoolean("needShareCallBack", false));
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(false, (JSONObject)localObject2);
        return;
      }
      catch (JSONException paramBundle)
      {
        Object localObject1 = new JSONObject();
        try
        {
          ((JSONObject)localObject1).put("retCode", -1);
          ((JSONObject)localObject1).put("errMsg", HardCodeUtil.a(2131904655));
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        localMiniAppCmdInterface.onCmdListener(false, (JSONObject)localObject1);
        QLog.e("[mini] MiniAppObserver", 1, "onGetShareInfo parse json failed", paramBundle);
        return;
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onGetShareInfo get null response");
    }
  }
  
  protected void onGetStoreAppList(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetStoreAppList(paramInt, paramBoolean, paramBundle);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetStoreAppList() called with: index = [");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], isSuccess = [");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("], bundle = [");
    ((StringBuilder)localObject).append(paramBundle);
    ((StringBuilder)localObject).append("]");
    QLog.d("[mini] MiniAppObserver", 2, ((StringBuilder)localObject).toString());
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localObject = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      JSONObject localJSONObject = new JSONObject();
      if (paramBoolean) {
        try
        {
          localJSONObject.put("data", paramBundle.getString("data", ""));
          localJSONObject.put("dataType", "string");
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
        }
      }
      ((MiniAppCmdInterface)localObject).onCmdListener(paramBoolean, localJSONObject);
    }
  }
  
  protected void onGetSwitchList(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean) {}
      try
      {
        localObject = (FromServiceMsg)paramBundle.getParcelable("getSwitchList");
        long l = paramBundle.getLong("retCode");
        paramBundle = paramBundle.getString("errMsg");
        if (localObject != null)
        {
          localObject = MiniAppGetSwitchListRequest.onResponse(WupUtil.b(((FromServiceMsg)localObject).getWupBuffer()));
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("getSwitchList", localObject);
          localJSONObject.put("retCode", l);
          localJSONObject.put("errMsg", paramBundle);
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call getSwitchList FromServiceMsg rsp is null.");
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(true, new JSONObject());
        return;
      }
      catch (Exception paramBundle)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("call onGetSwitchList exception ");
        ((StringBuilder)localObject).append(paramBundle);
        QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      QLog.d("[mini] MiniAppObserver", 1, "call onGetSwitchList fail.");
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onGetSwitchList can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onGetTcbTicket(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      JSONObject localJSONObject = new JSONObject();
      if (paramBoolean) {
        try
        {
          localJSONObject.put("ticket", paramBundle.getString("key_ticket"));
          localJSONObject.put("createTime", paramBundle.getInt("key_createTime"));
          localJSONObject.put("period", paramBundle.getInt("key_period"));
          if (localMiniAppCmdInterface == null) {
            break label208;
          }
          localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
          return;
        }
        catch (Throwable paramBundle)
        {
          QLog.e("[mini] MiniAppObserver", 1, "onGetTcbTicket error.", paramBundle);
          return;
        }
      } else {
        try
        {
          localJSONObject = new JSONObject();
          long l = paramBundle.getLong("retCode");
          paramBundle = paramBundle.getString("errMsg");
          localJSONObject.put("retCode", l);
          localJSONObject.put("errMsg", paramBundle);
          if (localMiniAppCmdInterface != null)
          {
            localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
            return;
          }
        }
        catch (Throwable paramBundle)
        {
          QLog.e("[mini] MiniAppObserver", 1, "onGetTcbTicket error.", paramBundle);
        }
      }
      label208:
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("onGetTcbTicket can not found listener. ");
    paramBundle.append(paramInt);
    QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
  }
  
  protected void onGetUserAppInfoFin(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetUserAppInfoFin(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean) {}
      try
      {
        QLog.d("[mini] MiniAppObserver", 1, "call onGetUserAppInfoFin success.");
        localObject = new JSONObject();
        paramInt = paramBundle.getInt("like_num", 0);
        int i = paramBundle.getInt("do_like", 0);
        paramBundle = paramBundle.getSerializable("mini_app_info_data");
        ((JSONObject)localObject).put("likeNum", paramInt);
        ((JSONObject)localObject).put("doLike", i);
        ((JSONObject)localObject).put("mini_app_info_data", paramBundle);
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(true, (JSONObject)localObject);
        return;
      }
      catch (Exception paramBundle)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("call onGetUserAppInfoFin exception ");
        ((StringBuilder)localObject).append(paramBundle);
        QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      QLog.d("[mini] MiniAppObserver", 1, "call onGetUserAppInfoFin fail.");
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onGetUserAppInfoFin can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onGetUserAppList(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetUserAppList(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      Object localObject = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        long l = paramBundle.getLong("retCode", -1L);
        String str = paramBundle.getString("errMsg", HardCodeUtil.a(2131904659));
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("retCode", l);
        localJSONObject.put("errMsg", str);
        if (paramBoolean)
        {
          paramBundle = (FromServiceMsg)paramBundle.getParcelable("getUserAppList");
          if (paramBundle != null)
          {
            localJSONObject.put("response", GetUserAppListRequest.onResponse(WupUtil.b(paramBundle.getWupBuffer())));
            if (localObject == null) {
              return;
            }
            ((MiniAppCmdInterface)localObject).onCmdListener(true, localJSONObject);
            return;
          }
          QLog.e("[mini] MiniAppObserver", 1, "call onGetUserAppList FromServiceMsg rsp is null.");
          if (localObject == null) {
            return;
          }
          ((MiniAppCmdInterface)localObject).onCmdListener(false, localJSONObject);
          return;
        }
        paramBundle = new StringBuilder();
        paramBundle.append("call onGetUserAppList fail. errCode = ");
        paramBundle.append(l);
        paramBundle.append(", errMsg = ");
        paramBundle.append(str);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
        if (localObject == null) {
          return;
        }
        ((MiniAppCmdInterface)localObject).onCmdListener(false, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("call onGetUserAppList exception ");
        ((StringBuilder)localObject).append(Log.getStackTraceString(paramBundle));
        QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onGetUserAppList can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onGetUserAppListV2(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetUserAppListV2(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      Object localObject = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        long l = paramBundle.getLong("retCode", -1L);
        String str = paramBundle.getString("errMsg", HardCodeUtil.a(2131904660));
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("retCode", l);
        localJSONObject.put("errMsg", str);
        if (paramBoolean)
        {
          paramBundle = (FromServiceMsg)paramBundle.getParcelable("getUserAppListV2");
          if (paramBundle != null)
          {
            localJSONObject.put("response", GetUserAppListRequestV2.onResponse(WupUtil.b(paramBundle.getWupBuffer())));
            if (localObject == null) {
              return;
            }
            ((MiniAppCmdInterface)localObject).onCmdListener(true, localJSONObject);
            return;
          }
          QLog.e("[mini] MiniAppObserver", 1, "call onGetUserAppListV2 FromServiceMsg rsp is null.");
          if (localObject == null) {
            return;
          }
          ((MiniAppCmdInterface)localObject).onCmdListener(false, localJSONObject);
          return;
        }
        paramBundle = new StringBuilder();
        paramBundle.append("call onGetUserAppListV2 fail. errCode = ");
        paramBundle.append(l);
        paramBundle.append(", errMsg = ");
        paramBundle.append(str);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
        if (localObject == null) {
          return;
        }
        ((MiniAppCmdInterface)localObject).onCmdListener(false, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("call onGetUserAppListV2 exception ");
        ((StringBuilder)localObject).append(Log.getStackTraceString(paramBundle));
        QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onGetUserAppListV2 can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onGetUserGroupInfo(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean) {}
      try
      {
        localObject = paramBundle.getString("extra_json_data");
        l = paramBundle.getLong("retCode");
        paramBundle = paramBundle.getString("errMsg");
        if (localObject != null)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("extra_json_data", localObject);
          localJSONObject.put("retCode", l);
          localJSONObject.put("errMsg", paramBundle);
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call getUserInfo extraJsonData is null.");
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localObject = new JSONObject();
        ((JSONObject)localObject).put("retCode", l);
        ((JSONObject)localObject).put("errMsg", paramBundle);
        localMiniAppCmdInterface.onCmdListener(true, (JSONObject)localObject);
        return;
      }
      catch (Exception paramBundle)
      {
        long l;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("call getUserInfo exception ");
        ((StringBuilder)localObject).append(paramBundle);
        QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      QLog.d("[mini] MiniAppObserver", 1, "call getUserInfo fail.");
      if (localMiniAppCmdInterface != null)
      {
        localObject = new JSONObject();
        l = paramBundle.getLong("retCode");
        paramBundle = paramBundle.getString("errMsg");
        ((JSONObject)localObject).put("retCode", l);
        ((JSONObject)localObject).put("errMsg", paramBundle);
        localMiniAppCmdInterface.onCmdListener(false, (JSONObject)localObject);
        return;
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("getUserInfo can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onGetUserHealthData(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        localObject = new JSONObject();
        if (paramBoolean)
        {
          if (paramBundle != null)
          {
            ((JSONObject)localObject).put("encryptedData", paramBundle.getString("key_encrypted_data"));
            ((JSONObject)localObject).put("iv", paramBundle.get("key_ret_iv"));
          }
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(true, (JSONObject)localObject);
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call onGetUserHealthData fail.");
        if (!TextUtils.isEmpty(paramBundle.getString("errMsg"))) {
          ((JSONObject)localObject).put("errMsg", paramBundle.getString("errMsg"));
        }
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(false, (JSONObject)localObject);
        return;
      }
      catch (Exception paramBundle)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("call onGetUserHealthData exception ");
        ((StringBuilder)localObject).append(paramBundle);
        QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onGetUserHealthData can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onGetUserInfoExtra(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (!paramBoolean) {}
    }
    label282:
    try
    {
      localJSONObject = new JSONObject();
      String str = paramBundle.get("ret_encrypt_data").toString();
      paramBundle = paramBundle.get("ret_iv").toString();
      localJSONObject.put("encryptedData", str);
      localJSONObject.put("iv", paramBundle);
      if (localMiniAppCmdInterface == null) {
        break label282;
      }
      localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject;
      label196:
      break label196;
    }
    QLog.d("[mini] MiniAppObserver", 1, "call onGetUserInfoExtra fail.");
    if (localMiniAppCmdInterface != null)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("retCode", paramBundle.getLong("retCode", -1L));
        localJSONObject.put("errMsg", paramBundle.getString("errMsg", ""));
        localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.d("[mini] MiniAppObserver", 1, "call onGetUserInfoExtra exception", paramBundle);
        return;
      }
      paramBundle = new StringBuilder();
      paramBundle.append("call onGetUserInfoExtra exception ");
      paramBundle.append(localJSONObject);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        paramBundle = new StringBuilder();
        paramBundle.append("onGetUserInfoExtra can not found listener. ");
        paramBundle.append(paramInt);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      }
    }
  }
  
  protected void onGetUserInteractiveStorage(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (!paramBoolean) {}
    }
    label310:
    try
    {
      localFromServiceMsg = (FromServiceMsg)paramBundle.getParcelable("getUserInteractiveStorage");
      long l = paramBundle.getLong("retCode");
      paramBundle = paramBundle.getString("errMsg");
      if (localFromServiceMsg != null)
      {
        CloudStorage.StGetUserInteractiveStorageRsp localStGetUserInteractiveStorageRsp = GetUserInteractiveStorageRequest.onResponse(WupUtil.b(localFromServiceMsg.getWupBuffer()));
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("response", localStGetUserInteractiveStorageRsp);
        localJSONObject.put("resultCode", localFromServiceMsg.getResultCode());
        localJSONObject.put("retCode", l);
        localJSONObject.put("errMsg", paramBundle);
        if (localMiniAppCmdInterface == null) {
          break label310;
        }
        localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
        return;
      }
      QLog.d("[mini] MiniAppObserver", 1, "call getUserInteractiveStorage FromServiceMsg rsp is null.");
      if (localMiniAppCmdInterface == null) {
        break label310;
      }
      localMiniAppCmdInterface.onCmdListener(true, new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      FromServiceMsg localFromServiceMsg;
      label224:
      break label224;
    }
    QLog.d("[mini] MiniAppObserver", 1, "call getUserInteractiveStorage fail.");
    if (localMiniAppCmdInterface != null)
    {
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("call getUserInteractiveStorage exception ");
      paramBundle.append(localFromServiceMsg);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        paramBundle = new StringBuilder();
        paramBundle.append("getUserInteractiveStorage can not found listener. ");
        paramBundle.append(paramInt);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      }
    }
  }
  
  protected void onGetUserSetting(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      Object localObject;
      JSONObject localJSONObject;
      if (paramBoolean)
      {
        localObject = paramBundle.getByteArray("originalData");
        try
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("settingItem", paramBundle.getString("settingItem", ""));
          localJSONObject.put("desc", paramBundle.getString("desc", ""));
          localJSONObject.put("authState", paramBundle.getInt("authState", -1));
          localJSONObject.put("originalData", localObject);
          localJSONObject.put("errMsg", paramBundle.getString("errMsg", ""));
          if (localMiniAppCmdInterface == null) {
            break label312;
          }
          localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
          return;
        }
        catch (Throwable paramBundle)
        {
          QLog.e("[mini] MiniAppObserver", 1, "onGetUserSetting error.", paramBundle);
          return;
        }
      }
      else if (localMiniAppCmdInterface != null)
      {
        localJSONObject = new JSONObject();
        localObject = localJSONObject;
        if (paramBundle != null)
        {
          long l2 = paramBundle.getLong("retCode");
          paramBundle = paramBundle.getString("errMsg");
          long l1;
          if (-101511014L == l2)
          {
            l1 = 20001L;
          }
          else if (-101511020L == l2)
          {
            l1 = 20003L;
          }
          else
          {
            l1 = l2;
            if (-101511021L == l2) {
              l1 = 20004L;
            }
          }
          try
          {
            localObject = new JSONObject().put("retCode", l1).put("errMsg", paramBundle);
          }
          catch (JSONException paramBundle)
          {
            paramBundle.printStackTrace();
            localObject = localJSONObject;
          }
        }
        localMiniAppCmdInterface.onCmdListener(false, (JSONObject)localObject);
      }
      label312:
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("onGetUserSetting can not found listener. ");
    paramBundle.append(paramInt);
    QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
  }
  
  protected void onGetWeixinSDKAppInfoFin(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetWeixinSDKAppInfoFin(paramInt, paramBoolean, paramBundle);
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt)))) {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      try
      {
        long l = paramBundle.getLong("retCode", -1L);
        Object localObject = paramBundle.getString("errMsg", HardCodeUtil.a(2131904658));
        if (paramBoolean)
        {
          byte[] arrayOfByte = paramBundle.getByteArray("mini_app_info_pb_data");
          paramBundle = new JSONObject();
          paramBundle.put("appInfo_pb", arrayOfByte);
          paramBundle.put("retCode", l);
          paramBundle.put("errMsg", localObject);
          if (localMiniAppCmdInterface == null) {
            break label304;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("  onGetWeixinSDKAppInfoFin . ");
          ((StringBuilder)localObject).append(paramInt);
          QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
          if (l != 0L) {
            break label305;
          }
          paramBoolean = true;
          localMiniAppCmdInterface.onCmdListener(paramBoolean, paramBundle);
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call onGetWeixinSDKAppInfoFin fail.");
        if (localMiniAppCmdInterface == null) {
          break label304;
        }
        paramBundle = new JSONObject();
        paramBundle.put("retCode", l);
        paramBundle.put("errMsg", localObject);
        localMiniAppCmdInterface.onCmdListener(false, paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onGetWeixinSDKAppInfoFin exception ", paramBundle);
        if (localMiniAppCmdInterface == null) {
          break label304;
        }
      }
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("onGetWeixinSDKAppInfoFin can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      label304:
      return;
      label305:
      paramBoolean = false;
    }
  }
  
  protected void onGetuserCloudStorage(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("KVDataList", new JSONArray(paramBundle.getString("key_reslut_data")));
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
        return;
      }
      catch (Throwable paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "onGetuserCloudStorage error. ", paramBundle);
        return;
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onGetuserCloudStorage can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onGuessYouLike(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      Object localObject = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        long l = paramBundle.getLong("retCode", -1L);
        String str = paramBundle.getString("errMsg", HardCodeUtil.a(2131904660));
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("retCode", l);
        localJSONObject.put("errMsg", str);
        if (paramBoolean)
        {
          paramBundle = (FromServiceMsg)paramBundle.getParcelable("searchGuessYouLike");
          if (paramBundle != null)
          {
            localJSONObject.put("searchGuessYouLikeResponse", GuessYouLikeRequest.onResponse(WupUtil.b(paramBundle.getWupBuffer())));
            if (localObject == null) {
              return;
            }
            ((MiniAppCmdInterface)localObject).onCmdListener(true, localJSONObject);
            return;
          }
          QLog.e("[mini] MiniAppObserver", 1, "call onGuessYouLike FromServiceMsg rsp is null.");
          if (localObject == null) {
            return;
          }
          ((MiniAppCmdInterface)localObject).onCmdListener(false, localJSONObject);
          return;
        }
        paramBundle = new StringBuilder();
        paramBundle.append("call onGuessYouLike fail. errCode = ");
        paramBundle.append(l);
        paramBundle.append(", errMsg = ");
        paramBundle.append(str);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
        if (localObject == null) {
          return;
        }
        ((MiniAppCmdInterface)localObject).onCmdListener(false, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("call onGuessYouLike exception ");
        ((StringBuilder)localObject).append(Log.getStackTraceString(paramBundle));
        QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onGuessYouLike can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onLocalSearchDataFin(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onLocalSearchDataFin(paramInt, paramBoolean, paramBundle);
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (!paramBoolean) {}
    }
    try
    {
      paramBundle = (FromServiceMsg)paramBundle.getParcelable("localSearchData");
      if (paramBundle == null) {
        break label234;
      }
      paramBundle = LocalSearchDataRequest.onResponse(WupUtil.b(paramBundle.getWupBuffer()));
      localJSONObject = new JSONObject();
      localJSONObject.put("response", paramBundle);
      if (localMiniAppCmdInterface == null) {
        break label234;
      }
      localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject;
      label148:
      label234:
      break label148;
    }
    QLog.d("[mini] MiniAppObserver", 1, "call onLocalSearchDataFin fail.");
    if (localMiniAppCmdInterface != null)
    {
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("call onLocalSearchDataFin exception ");
      paramBundle.append(localJSONObject);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        paramBundle = new StringBuilder();
        paramBundle.append("onLocalSearchDataFin can not found listener. ");
        paramBundle.append(paramInt);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      }
    }
  }
  
  protected void onModifyFriendInteractiveStorage(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (!paramBoolean) {}
    }
    label332:
    try
    {
      localFromServiceMsg = (FromServiceMsg)paramBundle.getParcelable("modifyFriendInteractiveStorage");
      long l = paramBundle.getLong("retCode");
      paramBundle = paramBundle.getString("errMsg");
      if (localFromServiceMsg != null)
      {
        CloudStorage.StModifyFriendInteractiveStorageRsp localStModifyFriendInteractiveStorageRsp = ModifyFriendInteractiveStorageReq.onResponse(WupUtil.b(localFromServiceMsg.getWupBuffer()));
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("response", localStModifyFriendInteractiveStorageRsp);
        localJSONObject.put("resultCode", localFromServiceMsg.getResultCode());
        if (localStModifyFriendInteractiveStorageRsp != null) {
          localJSONObject.put("details", localStModifyFriendInteractiveStorageRsp.details.get());
        }
        localJSONObject.put("retCode", l);
        localJSONObject.put("errMsg", paramBundle);
        if (localMiniAppCmdInterface == null) {
          break label332;
        }
        localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
        return;
      }
      QLog.d("[mini] MiniAppObserver", 1, "call modifyFriendInteractiveStorage FromServiceMsg rsp is null.");
      if (localMiniAppCmdInterface == null) {
        break label332;
      }
      localMiniAppCmdInterface.onCmdListener(true, new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      FromServiceMsg localFromServiceMsg;
      label246:
      break label246;
    }
    QLog.d("[mini] MiniAppObserver", 1, "call modifyFriendInteractiveStorage fail.");
    if (localMiniAppCmdInterface != null)
    {
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("call modifyFriendInteractiveStorage exception ");
      paramBundle.append(localFromServiceMsg);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        paramBundle = new StringBuilder();
        paramBundle.append("modifyFriendInteractiveStorage can not found listener. ");
        paramBundle.append(paramInt);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      }
    }
  }
  
  protected void onOpenChannel(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onOpenChannel(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean) {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          paramBundle = paramBundle.getByteArray("responsedata");
          if (paramBundle != null)
          {
            PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
            localStQWebRsp.mergeFrom(paramBundle);
            localJSONObject.put("responsedata", localStQWebRsp);
          }
          if (localMiniAppCmdInterface == null) {
            break label156;
          }
          localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
          return;
        }
        catch (Throwable paramBundle)
        {
          QLog.e("[mini] MiniAppObserver", 1, "onOpenChannel error.", paramBundle);
          return;
        }
      } else if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      }
      label156:
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("onOpenChannel can not found listener. ");
    paramBundle.append(paramInt);
    QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
  }
  
  protected void onRealTimeLogReport(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      Object localObject = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        long l = paramBundle.getLong("retCode", -1L);
        paramBundle = paramBundle.getString("errMsg", HardCodeUtil.a(2131904660));
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("retCode", l);
        localJSONObject.put("errMsg", paramBundle);
        if (paramBoolean)
        {
          if (localObject == null) {
            return;
          }
          ((MiniAppCmdInterface)localObject).onCmdListener(true, localJSONObject);
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("call onRealTimeLogReport fail. errCode = ");
        localStringBuilder.append(l);
        localStringBuilder.append(", errMsg = ");
        localStringBuilder.append(paramBundle);
        QLog.e("[mini] MiniAppObserver", 1, localStringBuilder.toString());
        if (localObject == null) {
          return;
        }
        ((MiniAppCmdInterface)localObject).onCmdListener(false, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("call onRealTimeLogReport exception ");
        ((StringBuilder)localObject).append(Log.getStackTraceString(paramBundle));
        QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onRealTimeLogReport can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onRejectFrequentlyRecommends(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("retCode", paramBundle.getInt("retCode"));
        localJSONObject.put("errMsg", paramBundle.getString("key_Msg"));
        if (paramBoolean)
        {
          paramInt = paramBundle.getInt("key_State", -1);
          if (paramInt != -1) {
            localJSONObject.put("key_State", paramInt);
          } else {
            QLog.d("[mini] MiniAppObserver", 1, "call onRejectFrequentlyRecommends state is null.");
          }
        }
        else
        {
          QLog.e("[mini] MiniAppObserver", 1, "onRejectFrequentlyRecommends fail");
        }
      }
      catch (Throwable paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "onRejectFrequentlyRecommends error. ", paramBundle);
      }
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onRejectFrequentlyRecommends can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onRemoveuserCloudStorage(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localObject = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (localObject != null) {
        ((MiniAppCmdInterface)localObject).onCmdListener(paramBoolean, new JSONObject());
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRemoveuserCloudStorage can not found listener. ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void onReportLogFileUrlServlet(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      paramBundle = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (!paramBoolean) {}
    }
    try
    {
      localObject1 = new JSONObject();
      if (paramBundle == null) {
        break label188;
      }
      paramBundle.onCmdListener(true, (JSONObject)localObject1);
      return;
    }
    catch (Exception localException)
    {
      Object localObject1;
      Object localObject2;
      break label100;
    }
    QLog.d("[mini] MiniAppObserver", 1, "call onReportLogFileUrlServlet fail.");
    if (paramBundle != null)
    {
      paramBundle.onCmdListener(false, new JSONObject());
      return;
      label100:
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("call onReportLogFileUrlServlet exception ");
      ((StringBuilder)localObject1).append(localObject2);
      QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject1).toString());
      if (paramBundle != null)
      {
        paramBundle.onCmdListener(false, new JSONObject());
        return;
        paramBundle = new StringBuilder();
        paramBundle.append("onReportLogFileUrlServlet can not found listener. ");
        paramBundle.append(paramInt);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      }
    }
    label188:
  }
  
  protected void onReportShare(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      paramBundle = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (!paramBoolean) {}
    }
    try
    {
      localObject1 = new JSONObject();
      if (paramBundle == null) {
        break label188;
      }
      paramBundle.onCmdListener(true, (JSONObject)localObject1);
      return;
    }
    catch (Exception localException)
    {
      Object localObject1;
      Object localObject2;
      break label100;
    }
    QLog.d("[mini] MiniAppObserver", 1, "call onReportShare fail.");
    if (paramBundle != null)
    {
      paramBundle.onCmdListener(false, new JSONObject());
      return;
      label100:
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("call onReportShare exception ");
      ((StringBuilder)localObject1).append(localObject2);
      QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject1).toString());
      if (paramBundle != null)
      {
        paramBundle.onCmdListener(false, new JSONObject());
        return;
        paramBundle = new StringBuilder();
        paramBundle.append("onReportShare can not found listener. ");
        paramBundle.append(paramInt);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      }
    }
    label188:
  }
  
  protected void onSearchApp(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      Object localObject = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        long l = paramBundle.getLong("retCode", -1L);
        String str = paramBundle.getString("errMsg", HardCodeUtil.a(2131904660));
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("retCode", l);
        localJSONObject.put("errMsg", str);
        if (paramBoolean)
        {
          paramBundle = (FromServiceMsg)paramBundle.getParcelable("searchApp");
          if (paramBundle != null)
          {
            localJSONObject.put("searchAppResponse", SearchAppRequest.onResponse(WupUtil.b(paramBundle.getWupBuffer())));
            if (localObject == null) {
              return;
            }
            ((MiniAppCmdInterface)localObject).onCmdListener(true, localJSONObject);
            return;
          }
          QLog.e("[mini] MiniAppObserver", 1, "call onSearchApp FromServiceMsg rsp is null.");
          if (localObject == null) {
            return;
          }
          ((MiniAppCmdInterface)localObject).onCmdListener(false, localJSONObject);
          return;
        }
        paramBundle = new StringBuilder();
        paramBundle.append("call onSearchApp fail. errCode = ");
        paramBundle.append(l);
        paramBundle.append(", errMsg = ");
        paramBundle.append(str);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
        if (localObject == null) {
          return;
        }
        ((MiniAppCmdInterface)localObject).onCmdListener(false, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("call onSearchApp exception ");
        ((StringBuilder)localObject).append(Log.getStackTraceString(paramBundle));
        QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onSearchApp can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onSendArkMsg(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (!paramBoolean) {}
    }
    label310:
    try
    {
      localFromServiceMsg = (FromServiceMsg)paramBundle.getParcelable("sendArkMsg");
      long l = paramBundle.getLong("retCode");
      paramBundle = paramBundle.getString("errMsg");
      if (localFromServiceMsg != null)
      {
        MiniProgramShare.StSendArkMsgRsp localStSendArkMsgRsp = MiniAppSendArkMsgRequest.onResponse(WupUtil.b(localFromServiceMsg.getWupBuffer()));
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("response", localStSendArkMsgRsp);
        localJSONObject.put("resultCode", localFromServiceMsg.getResultCode());
        localJSONObject.put("retCode", l);
        localJSONObject.put("errMsg", paramBundle);
        if (localMiniAppCmdInterface == null) {
          break label310;
        }
        localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
        return;
      }
      QLog.d("[mini] MiniAppObserver", 1, "call sendArkMsg FromServiceMsg rsp is null.");
      if (localMiniAppCmdInterface == null) {
        break label310;
      }
      localMiniAppCmdInterface.onCmdListener(true, new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      FromServiceMsg localFromServiceMsg;
      label224:
      break label224;
    }
    QLog.d("[mini] MiniAppObserver", 1, "call sendArkMsg fail.");
    if (localMiniAppCmdInterface != null)
    {
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("call sendArkMsg exception ");
      paramBundle.append(localFromServiceMsg);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        paramBundle = new StringBuilder();
        paramBundle.append("sendArkMsg can not found listener. ");
        paramBundle.append(paramInt);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      }
    }
  }
  
  protected void onSetAuth(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (localMiniAppCmdInterface != null)
      {
        JSONObject localJSONObject = new JSONObject();
        if (paramBundle != null) {
          try
          {
            localJSONObject.put("retCode", paramBundle.getLong("retCode"));
          }
          catch (JSONException paramBundle)
          {
            paramBundle.printStackTrace();
          }
        }
        localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onGetUserHealthData can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onSetAvatar(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (!paramBoolean) {}
    }
    try
    {
      paramBundle = new JSONObject();
      if (localMiniAppCmdInterface == null) {
        break label236;
      }
      localMiniAppCmdInterface.onCmdListener(true, paramBundle);
      return;
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject;
      long l;
      label150:
      label236:
      break label150;
    }
    QLog.d("[mini] MiniAppObserver", 1, "call onGetUserInfoExtra fail.");
    if (localMiniAppCmdInterface != null)
    {
      localJSONObject = new JSONObject();
      l = paramBundle.getLong("retCode", -1L);
      paramBundle = paramBundle.getString("errMsg", HardCodeUtil.a(2131904661));
      localJSONObject.put("retCode", l);
      localJSONObject.put("errMsg", paramBundle);
      localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("call onGetUserInfoExtra exception ");
      paramBundle.append(localJSONObject);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        paramBundle = new StringBuilder();
        paramBundle.append("onGetUserInfoExtra can not found listener. ");
        paramBundle.append(paramInt);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      }
    }
  }
  
  protected void onSetCMShowPetStatus(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("retCode", paramBundle.getInt("retCode"));
        localJSONObject.put("errMsg", paramBundle.getString("errMsg"));
      }
      catch (Throwable paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "onSetCMShowPetStatus error. ", paramBundle);
      }
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onSetCMShowPetStatus can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onSetTopMiniAppFin(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onSetTopMiniAppFin(paramInt, paramBoolean, paramBundle);
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (!paramBoolean) {}
    }
    try
    {
      localJSONObject = new JSONObject();
      paramBundle = paramBundle.getByteArray("key_extendinfo");
      if (paramBundle != null)
      {
        COMM.StCommonExt localStCommonExt = new COMM.StCommonExt();
        localStCommonExt.mergeFrom(paramBundle);
        localJSONObject.put("ext", localStCommonExt);
      }
      if (localMiniAppCmdInterface == null) {
        break label237;
      }
      localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject;
      label151:
      label237:
      break label151;
    }
    QLog.d("[mini] MiniAppObserver", 1, "call onSetTopMiniAppFin fail.");
    if (localMiniAppCmdInterface != null)
    {
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("call onSetTopMiniAppFin exception ");
      paramBundle.append(localJSONObject);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        paramBundle = new StringBuilder();
        paramBundle.append("onSetTopMiniAppFin can not found listener. ");
        paramBundle.append(paramInt);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      }
    }
  }
  
  protected void onSetUserAppLikeFin(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onSetUserAppLikeFin(paramInt, paramBoolean, paramBundle);
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (!paramBoolean) {}
    }
    try
    {
      localJSONObject = new JSONObject();
      paramBundle = paramBundle.getByteArray("key_extendinfo");
      if (paramBundle != null)
      {
        COMM.StCommonExt localStCommonExt = new COMM.StCommonExt();
        localStCommonExt.mergeFrom(paramBundle);
        localJSONObject.put("ext", localStCommonExt);
      }
      if (localMiniAppCmdInterface == null) {
        break label237;
      }
      localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject;
      label151:
      label237:
      break label151;
    }
    QLog.d("[mini] MiniAppObserver", 1, "call onSetUserAppLikeFin fail.");
    if (localMiniAppCmdInterface != null)
    {
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("call onSetUserAppLikeFin exception ");
      paramBundle.append(localJSONObject);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        paramBundle = new StringBuilder();
        paramBundle.append("onSetUserAppLikeFin can not found listener. ");
        paramBundle.append(paramInt);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      }
    }
  }
  
  protected void onSetUserSwitch(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean) {}
      try
      {
        localObject = (FromServiceMsg)paramBundle.getParcelable("setUserSwitch");
        long l = paramBundle.getLong("retCode");
        paramBundle = paramBundle.getString("errMsg");
        if (localObject != null)
        {
          localObject = MiniAppSetUserSwitchRequest.onResponse(WupUtil.b(((FromServiceMsg)localObject).getWupBuffer()));
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("setUserSwitch", localObject);
          localJSONObject.put("retCode", l);
          localJSONObject.put("errMsg", paramBundle);
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call setUserSwitch FromServiceMsg rsp is null.");
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(true, new JSONObject());
        return;
      }
      catch (Exception paramBundle)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("call onSetUserSwitch exception ");
        ((StringBuilder)localObject).append(paramBundle);
        QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      QLog.d("[mini] MiniAppObserver", 1, "call onSetUserSwitch fail.");
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onSetUserSwitch can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onSetuserCloudStorage(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localObject = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (localObject != null) {
        ((MiniAppCmdInterface)localObject).onCmdListener(paramBoolean, new JSONObject());
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSetuserCloudStorage can not found listener. ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void onTransForOpenIdAndTinyId(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    MiniAppCmdInterface localMiniAppCmdInterface;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (!paramBoolean) {}
    }
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("openId", paramBundle.getString("key_open_id"));
      localJSONObject.put("tinyId", paramBundle.getString("key_tiny_id"));
      if (localMiniAppCmdInterface == null) {
        break label223;
      }
      localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject;
      label137:
      label223:
      break label137;
    }
    QLog.d("[mini] MiniAppObserver", 1, "call onTransForOpenIdAndTinyId fail.");
    if (localMiniAppCmdInterface != null)
    {
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      return;
      paramBundle = new StringBuilder();
      paramBundle.append("call onTransForOpenIdAndTinyId exception ");
      paramBundle.append(localJSONObject);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        paramBundle = new StringBuilder();
        paramBundle.append("onTransForOpenIdAndTinyId can not found listener. ");
        paramBundle.append(paramInt);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
      }
    }
  }
  
  protected void onTransForRoomId(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        localObject = new JSONObject();
        if (paramBoolean)
        {
          ((JSONObject)localObject).put("openId", paramBundle.getString("key_open_id"));
          ((JSONObject)localObject).put("tinyId", paramBundle.getLong("key_tiny_id"));
          ((JSONObject)localObject).put("roomId", paramBundle.getInt("key_room_id"));
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(true, (JSONObject)localObject);
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call onTransForRoomId fail.");
        if (!TextUtils.isEmpty(paramBundle.getString("errMsg"))) {
          ((JSONObject)localObject).put("errMsg", paramBundle.getString("errMsg"));
        }
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(false, (JSONObject)localObject);
        return;
      }
      catch (Exception paramBundle)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("call onTransForRoomId exception ");
        ((StringBuilder)localObject).append(paramBundle);
        QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onTransForRoomId can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onUpdateUserSetting(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      paramBundle = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean)
      {
        if (paramBundle != null) {
          paramBundle.onCmdListener(true, new JSONObject());
        }
      }
      else if (paramBundle != null) {
        paramBundle.onCmdListener(false, new JSONObject());
      }
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("onUpdateUserSetting can not found listener. ");
    paramBundle.append(paramInt);
    QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
  }
  
  protected void onUseUserAppFin(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    MiniAppCmdInterface localMiniAppCmdInterface;
    JSONObject localJSONObject;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      localJSONObject = new JSONObject();
      if (!paramBoolean) {}
    }
    for (;;)
    {
      try
      {
        Object localObject2 = paramBundle.getByteArray("key_recommend");
        if (localObject2 != null)
        {
          localObject1 = new INTERFACE.StModuleInfo();
          ((INTERFACE.StModuleInfo)localObject1).mergeFrom((byte[])localObject2);
          localObject2 = (INTERFACE.StUserAppInfo)((INTERFACE.StModuleInfo)localObject1).jumpMoreApp.get();
          if ((localObject2 != null) && (((INTERFACE.StUserAppInfo)localObject2).appInfo.get() != null)) {
            localJSONObject.put("moreAppInfo", GsonUtils.obj2Json(com.tencent.mobileqq.mini.apkg.MiniAppInfo.from((INTERFACE.StApiAppInfo)((INTERFACE.StUserAppInfo)localObject2).appInfo.get())));
          }
          localJSONObject.put("popupType", ((INTERFACE.StModuleInfo)localObject1).PopupType.get());
          localObject2 = new JSONArray();
          int i = ((INTERFACE.StModuleInfo)localObject1).userAppList.size();
          paramInt = 0;
          Object localObject3;
          Object localObject4;
          if (paramInt < i)
          {
            Object localObject5 = (INTERFACE.StUserAppInfo)((INTERFACE.StModuleInfo)localObject1).userAppList.get(paramInt);
            if ((localObject5 == null) || (((INTERFACE.StUserAppInfo)localObject5).appInfo.get() == null)) {
              continue;
            }
            localObject3 = com.tencent.mobileqq.mini.apkg.MiniAppInfo.from((INTERFACE.StApiAppInfo)((INTERFACE.StUserAppInfo)localObject5).appInfo.get());
            ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject3).userNum = ((INTERFACE.StUserAppInfo)localObject5).userNum.get();
            ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject3).friendNum = ((INTERFACE.StUserAppInfo)localObject5).friendNum.get();
            if (((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject3).friendNum > 0)
            {
              localObject4 = new ArrayList();
              localObject5 = ((INTERFACE.StUserAppInfo)localObject5).users.get().iterator();
              if (((Iterator)localObject5).hasNext())
              {
                INTERFACE.UseUserInfo localUseUserInfo = (INTERFACE.UseUserInfo)((Iterator)localObject5).next();
                if (localUseUserInfo == null) {
                  continue;
                }
                UseUserInfo localUseUserInfo1 = new UseUserInfo();
                localUseUserInfo1.uin = localUseUserInfo.uin.get();
                localUseUserInfo1.avatar = localUseUserInfo.avatar.get();
                localUseUserInfo1.nick = localUseUserInfo.nick.get();
                ((ArrayList)localObject4).add(localUseUserInfo1);
                continue;
              }
              ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject3).users = ((List)localObject4);
            }
            ((JSONArray)localObject2).put(GsonUtils.obj2Json(localObject3));
            continue;
          }
          localJSONObject.put("appList", localObject2);
          localJSONObject.put("backgroundPic", ((INTERFACE.StModuleInfo)localObject1).backgroundPic.get());
          localJSONObject.put("jumpLink", ((INTERFACE.StModuleInfo)localObject1).jumpLink.get());
          localObject1 = paramBundle.getByteArray("key_ext");
          if (localObject1 != null)
          {
            paramBundle = new COMM.StCommonExt();
            paramBundle.mergeFrom((byte[])localObject1);
            localObject1 = new CommExtInfo();
            localObject2 = new HashMap();
            localObject3 = paramBundle.mapInfo.get().iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = (COMM.Entry)((Iterator)localObject3).next();
              if (localObject4 == null) {
                continue;
              }
              ((HashMap)localObject2).put(((COMM.Entry)localObject4).key.get(), ((COMM.Entry)localObject4).value.get());
              continue;
            }
            ((CommExtInfo)localObject1).mapInfo = ((Map)localObject2);
            ((CommExtInfo)localObject1).attachInfo = paramBundle.attachInfo.get();
            localJSONObject.put("ext", GsonUtils.obj2Json(localObject1));
          }
        }
        if (localMiniAppCmdInterface == null) {
          continue;
        }
        localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
        return;
      }
      catch (Exception localException)
      {
        Object localObject1;
        continue;
      }
      QLog.d("[mini] MiniAppObserver", 1, "call onUseUserAppFin fail.");
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
        return;
        paramBundle = new StringBuilder();
        paramBundle.append("call onUseUserAppFin exception ");
        paramBundle.append(localObject1);
        QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
        if (localMiniAppCmdInterface != null)
        {
          localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
          return;
          paramBundle = new StringBuilder();
          paramBundle.append("onUseUserAppFin can not found listener. ");
          paramBundle.append(paramInt);
          QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
        }
      }
      return;
      paramInt += 1;
    }
  }
  
  protected void onVerifyPlugin(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        localObject = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        if (paramBoolean)
        {
          localJSONObject.put("list", new JSONArray(paramBundle.getString("plugin_profile")));
          ((JSONObject)localObject).put("data", localJSONObject);
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(true, (JSONObject)localObject);
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call onVerifyPlugin fail.");
        if (!TextUtils.isEmpty(paramBundle.getString("errMsg"))) {
          ((JSONObject)localObject).put("errMsg", paramBundle.getString("errMsg"));
        }
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(false, (JSONObject)localObject);
        return;
      }
      catch (Exception paramBundle)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("call onVerifyPlugin exception ");
        ((StringBuilder)localObject).append(paramBundle);
        QLog.e("[mini] MiniAppObserver", 1, ((StringBuilder)localObject).toString());
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onVerifyPlugin can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
  
  protected void onWxPayCheckUrlResult(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("retCode", paramBundle.getInt("retCode"));
        localJSONObject.put("errMsg", paramBundle.getString("errMsg"));
        if (paramBoolean) {
          localJSONObject.put("key_url_valid", paramBundle.getInt("key_url_valid"));
        }
      }
      catch (Throwable paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "onWxPayCheckUrlResult error. ", paramBundle);
      }
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onWxPayCheckUrlResult can not found listener. ");
      paramBundle.append(paramInt);
      QLog.e("[mini] MiniAppObserver", 1, paramBundle.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil.1
 * JD-Core Version:    0.7.0.1
 */