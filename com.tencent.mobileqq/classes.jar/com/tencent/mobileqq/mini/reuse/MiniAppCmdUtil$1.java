package com.tencent.mobileqq.mini.reuse;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_AD.MiniAppAd.StGetAdRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetPotentialFriendListRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetUserInteractiveStorageRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StModifyFriendInteractiveStorageRsp;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetPhoneNumberRsp;
import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import NS_MINI_INTERFACE.INTERFACE.StPhoneNumber;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import NS_MINI_SHARE.MiniProgramShare.StSendArkMsgRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import amtj;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import bgau;
import bjeo;
import com.tencent.biz.richframework.network.request.GetMineStoryFeedListRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo;
import com.tencent.mobileqq.mini.app.PreCacheManager.ContentAccelerateRsp;
import com.tencent.mobileqq.mini.servlet.BatchQueryAppInfoRequest;
import com.tencent.mobileqq.mini.servlet.GetHotSearchAppsRequest;
import com.tencent.mobileqq.mini.servlet.GetPotentialFriendListRequest;
import com.tencent.mobileqq.mini.servlet.GetRecommendAppListRequest;
import com.tencent.mobileqq.mini.servlet.GetUserAppListRequest;
import com.tencent.mobileqq.mini.servlet.GetUserAppListRequestV2;
import com.tencent.mobileqq.mini.servlet.GetUserInteractiveStorageRequest;
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
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.SenderListener;
import com.tencent.ttpic.util.GsonUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppCmdUtil$1
  extends MiniAppObserver
{
  MiniAppCmdUtil$1(MiniAppCmdUtil paramMiniAppCmdUtil) {}
  
  public void onAddPhoneNumber(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onAddPhoneNumber(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) == null) || (!MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt)))) {
      QLog.e("[mini] MiniAppObserver", 1, "onAddPhoneNumber no listener for " + paramInt);
    }
    for (;;)
    {
      return;
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
    }
  }
  
  public void onBatchGetContact(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        JSONObject localJSONObject = new JSONObject();
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
          localJSONObject.put("errMsg", paramBundle.getString("errMsg"));
        }
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onBatchGetContact exception " + paramBundle);
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onBatchGetContact can not found listener. " + paramInt);
    }
  }
  
  public void onBatchGetUserInfoResult(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        paramBundle = new JSONObject(paramBundle.getString("key_reslut_data"));
        if (localMiniAppCmdInterface != null) {
          localMiniAppCmdInterface.onCmdListener(paramBoolean, paramBundle);
        }
        return;
      }
      catch (Throwable paramBundle)
      {
        for (;;)
        {
          QLog.e("[mini] MiniAppObserver", 1, "onBatchGetUserInfoResult error. ", paramBundle);
          paramBundle = new JSONObject();
        }
      }
    }
    QLog.e("[mini] MiniAppObserver", 1, "onBatchGetUserInfoResult can not found listener. " + paramInt);
  }
  
  public void onBatchQueryAppInfoFin(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean) {}
      try
      {
        paramBundle = (FromServiceMsg)paramBundle.getParcelable("batchQueryAppInfo");
        if (paramBundle == null) {
          return;
        }
        paramBundle = BatchQueryAppInfoRequest.onResponse(bgau.b(paramBundle.getWupBuffer()));
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("batch_query_app_info", paramBundle);
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onBatchQueryAppInfoFin exception " + paramBundle);
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      QLog.d("[mini] MiniAppObserver", 1, "call onBatchQueryAppInfoFin fail.");
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onBatchQueryAppInfoFin can not found listener. " + paramInt);
    }
  }
  
  public void onBookShelfInsertResult(int paramInt, boolean paramBoolean, Bundle paramBundle)
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
        for (;;)
        {
          QLog.e("[mini] MiniAppObserver", 1, "onBookShelfInsertResult error. ", paramBundle);
        }
      }
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
      }
      return;
    }
    QLog.e("[mini] MiniAppObserver", 1, "onBookShelfInsertResult can not found listener. " + paramInt);
  }
  
  public void onBookShelfQueryResult(int paramInt, boolean paramBoolean, Bundle paramBundle)
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
        for (;;)
        {
          QLog.e("[mini] MiniAppObserver", 1, "onBookShelfQueryResult error. ", paramBundle);
        }
      }
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
      }
      return;
    }
    QLog.e("[mini] MiniAppObserver", 1, "onBookShelfQueryResult can not found listener. " + paramInt);
  }
  
  public void onBookShelfUpdateResult(int paramInt, boolean paramBoolean, Bundle paramBundle)
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
        for (;;)
        {
          QLog.e("[mini] MiniAppObserver", 1, "onBookShelfUpdateResult error. ", paramBundle);
        }
      }
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
      }
      return;
    }
    QLog.e("[mini] MiniAppObserver", 1, "onBookShelfUpdateResult can not found listener. " + paramInt);
  }
  
  public void onChangeShareImageUrl(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onChangeShareImageUrl(paramInt, paramBoolean, paramBundle);
    MiniAppCmdInterface localMiniAppCmdInterface;
    JSONObject localJSONObject;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (localMiniAppCmdInterface != null) {
        localJSONObject = new JSONObject();
      }
    }
    try
    {
      localJSONObject.put("imageUrl", paramBundle.getString("imageUrl"));
      localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
      return;
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  public void onCheckBindingState(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      JSONObject localJSONObject = new JSONObject();
      for (;;)
      {
        try
        {
          localJSONObject.put("retCode", paramBundle.getInt("retCode"));
          localJSONObject.put("errMsg", paramBundle.getString("key_Msg"));
          if (!paramBoolean) {
            continue;
          }
          paramInt = paramBundle.getInt("key_check_State", -1);
          if (paramInt == -1) {
            continue;
          }
          localJSONObject.put("key_check_State", paramInt);
        }
        catch (Throwable paramBundle)
        {
          QLog.e("[mini] MiniAppObserver", 1, "onCheckBindingType error. ", paramBundle);
          continue;
          QLog.e("[mini] MiniAppObserver", 1, "onCheckBindingType fail");
          continue;
        }
        if (localMiniAppCmdInterface != null) {
          localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
        }
        return;
        QLog.d("[mini] MiniAppObserver", 1, "call checkBindingType is null.");
      }
    }
    QLog.e("[mini] MiniAppObserver", 1, "onCheckBindingType can not found listener. " + paramInt);
  }
  
  public void onCheckNavigateRightServlet(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean)
      {
        try
        {
          paramInt = paramBundle.getInt("key_action_code", 0);
          int i = paramBundle.getInt("key_skip_local_check", 0);
          paramBundle = paramBundle.getString("key_navigate_wording");
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("action_code", paramInt);
          localJSONObject.put("skip_local_check", i);
          if (paramInt == 0) {
            localJSONObject.put("reason", paramBundle);
          }
          while (localMiniAppCmdInterface != null)
          {
            localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
            return;
            localJSONObject.put("wording", paramBundle);
          }
          localMiniAppCmdInterface.onCmdListener(false, null);
        }
        catch (Exception paramBundle)
        {
          QLog.e("[mini] MiniAppObserver", 1, "call onCheckNavigateRightServlet exception " + paramBundle);
          if (localMiniAppCmdInterface == null) {
            return;
          }
        }
      }
      else
      {
        QLog.d("[mini] MiniAppObserver", 1, "call onCheckNavigateRightServlet fail.");
        if (localMiniAppCmdInterface != null) {
          localMiniAppCmdInterface.onCmdListener(false, null);
        }
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onCheckNavigateRightServlet can not found listener. " + paramInt);
    }
  }
  
  public void onCheckOfferIdFin(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      JSONObject localJSONObject = new JSONObject();
      if (paramBoolean) {}
      try
      {
        paramInt = paramBundle.getInt("key_result");
        Object localObject = paramBundle.getString("errMsg");
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
          return;
        }
        localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onCheckOfferIdFin exception " + paramBundle);
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      QLog.d("[mini] MiniAppObserver", 1, "call onCheckOfferIdFin fail.");
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
        return;
        localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onCheckOfferIdFin can not found listener. " + paramInt);
    }
  }
  
  public void onCheckSessionFin(int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
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
        localMiniAppCmdInterface.onCmdListener(true, null);
        return;
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        QLog.e("[mini] MiniAppObserver", 1, "call API_LOGIN exception " + paramString);
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      localJSONObject = new JSONObject();
      localJSONObject.put("errMsg", paramString);
      QLog.e("[mini] MiniAppObserver", 1, "call API_LOGIN failed " + paramString);
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
        return;
        localMiniAppCmdInterface.onCmdListener(false, null);
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onCheckSessionFin can not found listener. " + paramInt1);
    }
  }
  
  public void onCreateUpdatableMsgResult(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("retCode", paramBundle.getLong("retCode"));
        localJSONObject.put("errMsg", paramBundle.getString("errMsg"));
        if (localMiniAppCmdInterface != null) {
          localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
        }
        return;
      }
      catch (Throwable paramBundle)
      {
        for (;;)
        {
          QLog.e("[mini] MiniAppObserver", 1, "onCreateUpdatableMsgResult error. ", paramBundle);
        }
      }
    }
    QLog.e("[mini] MiniAppObserver", 1, "onCreateUpdatableMsgResult can not found listener. " + paramInt);
  }
  
  public void onDcReport(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    super.onDcReport(paramInt1, paramBoolean, paramInt2);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt1))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt1));
      if ((paramBoolean) && (paramInt2 == 0)) {
        if (localMiniAppCmdInterface != null)
        {
          QLog.d("[mini] MiniAppObserver", 1, "onDcReport ok");
          localMiniAppCmdInterface.onCmdListener(true, null);
        }
      }
      while (localMiniAppCmdInterface == null) {
        return;
      }
      QLog.e("[mini] MiniAppObserver", 1, "onDcReport fail");
      localMiniAppCmdInterface.onCmdListener(false, null);
      return;
    }
    QLog.e("[mini] MiniAppObserver", 1, "onDcReport can not found listener for index " + paramInt1);
  }
  
  public void onDelMiniAppFin(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onDelMiniAppFin(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean) {}
      try
      {
        JSONObject localJSONObject = new JSONObject();
        paramBundle = paramBundle.getByteArray("key_extendinfo");
        if (paramBundle != null)
        {
          COMM.StCommonExt localStCommonExt = new COMM.StCommonExt();
          localStCommonExt.mergeFrom(paramBundle);
          localJSONObject.put("ext", localStCommonExt);
        }
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onDelMiniAppFin exception " + paramBundle);
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      QLog.d("[mini] MiniAppObserver", 1, "call onDelMiniAppFin fail.");
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, null);
        return;
        localMiniAppCmdInterface.onCmdListener(false, null);
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onDelMiniAppFin can not found listener. " + paramInt);
    }
  }
  
  public void onDelPhoneNumber(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onDelPhoneNumber(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) == null) || (!MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt)))) {
      QLog.e("[mini] MiniAppObserver", 1, "onDelPhoneNumber no listener for " + paramInt);
    }
    for (;;)
    {
      return;
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
    }
  }
  
  public void onGetAppInfoByIdForSDKServlet(int paramInt, boolean paramBoolean, Bundle paramBundle)
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
        String str = paramBundle.getString("errMsg");
        if (paramBoolean)
        {
          paramBundle = (com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)paramBundle.getParcelable("mini_app_info_data");
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("mini_app_info_data", paramBundle);
          localJSONObject.put("retCode", l);
          localJSONObject.put("errMsg", str);
          if (localMiniAppCmdInterface != null)
          {
            QLog.e("[mini] MiniAppObserver", 1, "onGetAppInfoByIdForSDKServlet . " + paramInt);
            if (l != 0L) {
              break label324;
            }
            paramBoolean = true;
            localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
          }
          if (paramBundle == null) {
            break label323;
          }
          this.this$0.getExtConfigDetail(paramBundle.commonExt, bjeo.a(paramBundle.extConfigInfoList), new MiniAppCmdUtil.1.3(this));
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call onGetAppInfoByIdForSDKServlet fail.");
        if (localMiniAppCmdInterface == null) {
          break label323;
        }
        paramBundle = new JSONObject();
        paramBundle.put("retCode", l);
        paramBundle.put("errMsg", str);
        localMiniAppCmdInterface.onCmdListener(false, paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onGetAppInfoByIdForSDKServlet exception " + paramBundle);
        if (localMiniAppCmdInterface == null) {
          break label323;
        }
      }
      localMiniAppCmdInterface.onCmdListener(false, null);
      return;
      QLog.e("[mini] MiniAppObserver", 1, "onGetAppInfoByIdForSDKServlet can not found listener. " + paramInt);
      label323:
      return;
      label324:
      paramBoolean = false;
    }
  }
  
  public void onGetAppInfoByIdServlet(int paramInt, boolean paramBoolean, Bundle paramBundle)
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
        String str = paramBundle.getString("errMsg");
        if (paramBoolean)
        {
          paramBundle = (com.tencent.mobileqq.mini.apkg.MiniAppInfo)paramBundle.getSerializable("mini_app_info_data");
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("mini_app_info_data", paramBundle);
          localJSONObject.put("retCode", l);
          localJSONObject.put("errMsg", str);
          if (localMiniAppCmdInterface != null)
          {
            QLog.e("[mini] MiniAppObserver", 1, "onGetAppInfoByIdServlet . " + paramInt);
            if (l != 0L) {
              break label314;
            }
            paramBoolean = true;
            localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
          }
          if (paramBundle == null) {
            break label313;
          }
          this.this$0.getExtConfigDetail(paramBundle.commonExt, paramBundle.extConfigInfoList, new MiniAppCmdUtil.1.2(this));
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call onGetAppInfoByIdServlet fail.");
        if (localMiniAppCmdInterface == null) {
          break label313;
        }
        paramBundle = new JSONObject();
        paramBundle.put("retCode", l);
        paramBundle.put("errMsg", str);
        localMiniAppCmdInterface.onCmdListener(false, paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onGetAppInfoByIdServlet exception " + paramBundle);
        if (localMiniAppCmdInterface == null) {
          break label313;
        }
      }
      localMiniAppCmdInterface.onCmdListener(false, null);
      return;
      QLog.e("[mini] MiniAppObserver", 1, "onGetAppInfoByIdServlet can not found listener. " + paramInt);
      label313:
      return;
      label314:
      paramBoolean = false;
    }
  }
  
  public void onGetAppInfoByLinkFin(int paramInt, boolean paramBoolean, Bundle paramBundle)
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
        String str = paramBundle.getString("errMsg", amtj.a(2131705896));
        if (paramBoolean)
        {
          com.tencent.mobileqq.mini.apkg.MiniAppInfo localMiniAppInfo = (com.tencent.mobileqq.mini.apkg.MiniAppInfo)paramBundle.getSerializable("appInfo");
          paramBundle = paramBundle.getString("shareTicket", "");
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("appInfo", localMiniAppInfo);
          localJSONObject.put("shareTicket", paramBundle);
          localJSONObject.put("retCode", l);
          localJSONObject.put("errMsg", str);
          if (localMiniAppCmdInterface != null)
          {
            QLog.e("[mini] MiniAppObserver", 1, "  onGetAppInfoByLinkFin . " + paramInt);
            if (l != 0L) {
              break label338;
            }
            paramBoolean = true;
            localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
          }
          if (localMiniAppInfo == null) {
            break label337;
          }
          this.this$0.getExtConfigDetail(localMiniAppInfo.commonExt, localMiniAppInfo.extConfigInfoList, new MiniAppCmdUtil.1.1(this));
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call onGetAppInfoByLinkFin fail.");
        if (localMiniAppCmdInterface == null) {
          break label337;
        }
        paramBundle = new JSONObject();
        paramBundle.put("retCode", l);
        paramBundle.put("errMsg", str);
        localMiniAppCmdInterface.onCmdListener(false, paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onGetAppInfoByLinkFin exception ", paramBundle);
        if (localMiniAppCmdInterface == null) {
          break label337;
        }
      }
      localMiniAppCmdInterface.onCmdListener(false, null);
      return;
      QLog.e("[mini] MiniAppObserver", 1, "onGetAppInfoByLinkFin can not found listener. " + paramInt);
      label337:
      return;
      label338:
      paramBoolean = false;
    }
  }
  
  public void onGetAppInfoByLinkFinForSDK(int paramInt, boolean paramBoolean, Bundle paramBundle)
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
        String str = paramBundle.getString("errMsg", amtj.a(2131705896));
        if (paramBoolean)
        {
          com.tencent.qqmini.sdk.launcher.model.MiniAppInfo localMiniAppInfo = (com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)paramBundle.getParcelable("mini_app_info_data");
          paramBundle = paramBundle.getString("shareTicket", "");
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("mini_app_info_data", localMiniAppInfo);
          localJSONObject.put("shareTicket", paramBundle);
          localJSONObject.put("retCode", l);
          localJSONObject.put("errMsg", str);
          if (localMiniAppCmdInterface != null)
          {
            QLog.e("[mini] MiniAppObserver", 1, "  onGetAppInfoByLinkFinForSDK . " + paramInt);
            if (l != 0L) {
              break label341;
            }
            paramBoolean = true;
            localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
          }
          if (localMiniAppInfo == null) {
            break label340;
          }
          this.this$0.getExtConfigDetail(localMiniAppInfo.commonExt, bjeo.a(localMiniAppInfo.extConfigInfoList), new MiniAppCmdUtil.1.4(this));
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call onGetAppInfoByLinkFinForSDK fail.");
        if (localMiniAppCmdInterface == null) {
          break label340;
        }
        paramBundle = new JSONObject();
        paramBundle.put("retCode", l);
        paramBundle.put("errMsg", str);
        localMiniAppCmdInterface.onCmdListener(false, paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onGetAppInfoByLinkFinForSDK exception ", paramBundle);
        if (localMiniAppCmdInterface == null) {
          break label340;
        }
      }
      localMiniAppCmdInterface.onCmdListener(false, null);
      return;
      QLog.e("[mini] MiniAppObserver", 1, "onGetAppInfoByLinkFinForSDK can not found listener. " + paramInt);
      label340:
      return;
      label341:
      paramBoolean = false;
    }
  }
  
  public void onGetAuthList(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetAuthList(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (paramBoolean)
        {
          if (paramBundle != null)
          {
            localJSONObject.put("authList", paramBundle.get("key_get_auth_list_result"));
            localJSONObject.put("extendInfo", paramBundle.get("key_ext"));
          }
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call onGetAuthList fail.");
        if (!TextUtils.isEmpty(paramBundle.getString("errMsg"))) {
          localJSONObject.put("errMsg", paramBundle.getString("errMsg"));
        }
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onGetAuthList exception " + paramBundle);
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onGetAuthList can not found listener. " + paramInt);
    }
  }
  
  public void onGetContentAccelerateServlet(int paramInt, boolean paramBoolean, Bundle paramBundle)
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
        String str = paramBundle.getString("errMsg");
        if (paramBoolean)
        {
          paramBundle.setClassLoader(PreCacheManager.ContentAccelerateRsp.class.getClassLoader());
          paramBundle = (PreCacheManager.ContentAccelerateRsp)paramBundle.getParcelable("mini_rsp_data");
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("mini_rsp_data", paramBundle);
          localJSONObject.put("retCode", l);
          localJSONObject.put("errMsg", str);
          if (localMiniAppCmdInterface == null) {
            break label280;
          }
          QLog.e("[mini] MiniAppObserver", 1, "onGetContentAccelerateServlet . " + paramInt);
          if (l != 0L) {
            break label281;
          }
          paramBoolean = true;
          localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call onGetContentAccelerateServlet fail.");
        if (localMiniAppCmdInterface == null) {
          break label280;
        }
        paramBundle = new JSONObject();
        paramBundle.put("retCode", l);
        paramBundle.put("errMsg", str);
        localMiniAppCmdInterface.onCmdListener(false, paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onGetContentAccelerateServlet exception ", paramBundle);
        if (localMiniAppCmdInterface == null) {
          break label280;
        }
      }
      localMiniAppCmdInterface.onCmdListener(false, null);
      return;
      QLog.e("[mini] MiniAppObserver", 1, "onGetContentAccelerateServlet can not found listener. " + paramInt);
      label280:
      return;
      label281:
      paramBoolean = false;
    }
  }
  
  public void onGetExtConfigDetail(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) == null) || (!MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt)))) {
      QLog.e("[mini] MiniAppObserver", 1, "onGetExtConfigDetail can not found listener. " + paramInt);
    }
    MiniAppCmdInterface localMiniAppCmdInterface;
    do
    {
      for (;;)
      {
        return;
        localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
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
              if (QLog.isColorLevel()) {
                QLog.i("[mini] MiniAppObserver", 2, "apiScopeConfigJson " + localJSONObject.toString());
              }
            }
            if (localMiniAppCmdInterface != null) {
              localMiniAppCmdInterface.onCmdListener(true, paramBundle);
            }
            if (QLog.isColorLevel())
            {
              QLog.i("[mini] MiniAppObserver", 2, "onGetExtConfigDetail " + paramBundle.toString());
              return;
            }
          }
          catch (Throwable paramBundle)
          {
            QLog.e("[mini] MiniAppObserver", 1, "onGetExtConfigDetail error.", paramBundle);
            return;
          }
        }
      }
    } while (localMiniAppCmdInterface == null);
    localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
  }
  
  public void onGetFormId(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetFormId(paramInt, paramBoolean, paramBundle);
    QLog.d("[mini] MiniAppObserver", 2, "onGetFormId() called with: index = [" + paramInt + "], isSuccess = [" + paramBoolean + "], bundle = [" + paramBundle + "]");
    MiniAppCmdInterface localMiniAppCmdInterface;
    JSONObject localJSONObject;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      localJSONObject = new JSONObject();
      if (!paramBoolean) {}
    }
    try
    {
      localJSONObject.putOpt("formId", paramBundle.getString("formId", ""));
      localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
      return;
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  public void onGetFriendCloudStorage(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        if (TextUtils.isEmpty(paramBundle.getString("key_reslut_data"))) {}
        for (paramBundle = new JSONObject("{data:[]}");; paramBundle = new JSONObject(paramBundle.getString("key_reslut_data")))
        {
          if (localMiniAppCmdInterface != null) {
            localMiniAppCmdInterface.onCmdListener(paramBoolean, paramBundle);
          }
          return;
        }
      }
      catch (Throwable paramBundle)
      {
        for (;;)
        {
          QLog.e("[mini] MiniAppObserver", 1, "onGetFriendCloudStorage error. ", paramBundle);
          try
          {
            paramBundle = new JSONObject("{data:[],error:\"" + paramBundle.getMessage() + "\"}");
          }
          catch (Throwable paramBundle)
          {
            paramBundle = new JSONObject();
          }
        }
      }
    }
    QLog.e("[mini] MiniAppObserver", 1, "onGetFriendCloudStorage can not found listener. " + paramInt);
  }
  
  public void onGetGeneralCmdFin(int paramInt, long paramLong, byte[] paramArrayOfByte, String paramString)
  {
    super.onGetGeneralCmdFin(paramInt, paramLong, paramArrayOfByte, paramString);
    if ((MiniAppCmdUtil.access$300(this.this$0) != null) && (MiniAppCmdUtil.access$300(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppProxy.SenderListener localSenderListener = (MiniAppProxy.SenderListener)MiniAppCmdUtil.access$300(this.this$0).remove(Integer.valueOf(paramInt));
      if (localSenderListener != null) {
        localSenderListener.onReply((int)paramLong, paramArrayOfByte, paramString);
      }
      return;
    }
    QLog.e("[mini] MiniAppObserver", 1, "onGetGeneralCmdFin can not found listener. " + paramInt);
  }
  
  public void onGetGroupCloudStorage(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        paramBundle = paramBundle.getString("key_reslut_data");
        if (TextUtils.isEmpty(paramBundle)) {}
        for (paramBundle = new JSONObject("{data:[]}");; paramBundle = new JSONObject(paramBundle))
        {
          if (localMiniAppCmdInterface != null) {
            localMiniAppCmdInterface.onCmdListener(paramBoolean, paramBundle);
          }
          return;
        }
      }
      catch (Throwable paramBundle)
      {
        for (;;)
        {
          QLog.e("[mini] MiniAppObserver", 1, "onGetGroupCloudStorage error. ", paramBundle);
          try
          {
            paramBundle = new JSONObject("{data:[],error:\"" + paramBundle.getMessage() + "\"}");
          }
          catch (Throwable paramBundle)
          {
            paramBundle = new JSONObject();
          }
        }
      }
    }
    QLog.e("[mini] MiniAppObserver", 1, "onGetGroupCloudStorage can not found listener. " + paramInt);
  }
  
  public void onGetGroupShareInfo(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean)
      {
        try
        {
          Object localObject = (FromServiceMsg)paramBundle.getParcelable("getGroupShareInfo");
          String str = paramBundle.getString("getGroupShareInfoErrMsg");
          paramInt = paramBundle.getInt("getGroupShareInfoRetCode");
          if (localObject != null)
          {
            paramBundle = MiniAppGetGroupShareInfoRequest.onResponse(bgau.b(((FromServiceMsg)localObject).getWupBuffer()));
            localObject = new JSONObject();
            ((JSONObject)localObject).put("response", paramBundle);
            ((JSONObject)localObject).put("resultCode", paramInt);
            ((JSONObject)localObject).put("errMsg", str);
            if (localMiniAppCmdInterface == null) {
              return;
            }
            localMiniAppCmdInterface.onCmdListener(true, (JSONObject)localObject);
            return;
          }
          QLog.d("[mini] MiniAppObserver", 1, "call getGroupShareInfo FromServiceMsg rsp is null.");
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(true, new JSONObject());
          return;
        }
        catch (Exception paramBundle)
        {
          QLog.e("[mini] MiniAppObserver", 1, "call getGroupShareInfo exception " + paramBundle);
          if (localMiniAppCmdInterface == null) {
            return;
          }
        }
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      }
      else
      {
        QLog.d("[mini] MiniAppObserver", 1, "call getGroupShareInfo fail.");
        if (localMiniAppCmdInterface != null) {
          localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        }
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "getGroupShareInfo can not found listener. " + paramInt);
    }
  }
  
  public void onGetHotSearchApps(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      long l;
      String str;
      JSONObject localJSONObject;
      try
      {
        l = paramBundle.getLong("retCode", -1L);
        str = paramBundle.getString("errMsg", amtj.a(2131705898));
        localJSONObject = new JSONObject();
        localJSONObject.put("retCode", l);
        localJSONObject.put("errMsg", str);
        if (paramBoolean)
        {
          paramBundle = (FromServiceMsg)paramBundle.getParcelable("getHotSearchApps");
          if (paramBundle != null)
          {
            localJSONObject.put("getHotSearchAppsResponse", GetHotSearchAppsRequest.onResponse(bgau.b(paramBundle.getWupBuffer())));
            if (localMiniAppCmdInterface == null) {
              return;
            }
            localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
            return;
          }
          QLog.e("[mini] MiniAppObserver", 1, "call onGetHotSearchApps FromServiceMsg rsp is null.");
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onGetHotSearchApps exception " + Log.getStackTraceString(paramBundle));
        return;
      }
      QLog.e("[mini] MiniAppObserver", 1, "call onGetHotSearchApps fail. errCode = " + l + ", errMsg = " + str);
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onGetHotSearchApps can not found listener. " + paramInt);
    }
  }
  
  public void onGetKuolieAppListServlet(int paramInt, boolean paramBoolean, Bundle paramBundle)
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
        String str = paramBundle.getString("errMsg", amtj.a(2131705902));
        if (paramBoolean)
        {
          paramBundle = (MiniAppRecommInfo)paramBundle.getSerializable("mini_kuolie_applist_data");
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("data", paramBundle);
          localJSONObject.put("retCode", l);
          localJSONObject.put("errMsg", str);
          if (localMiniAppCmdInterface == null) {
            break label285;
          }
          QLog.e("[mini] MiniAppObserver", 1, "  onGetKuolieAppListServlet . " + paramInt);
          if (l != 0L) {
            break label286;
          }
          paramBoolean = true;
          localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call onGetKuolieAppListServlet fail.");
        if (localMiniAppCmdInterface == null) {
          break label285;
        }
        paramBundle = new JSONObject();
        paramBundle.put("retCode", l);
        paramBundle.put("errMsg", str);
        localMiniAppCmdInterface.onCmdListener(false, paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onGetKuolieAppListServlet exception ", paramBundle);
        if (localMiniAppCmdInterface == null) {
          break label285;
        }
      }
      localMiniAppCmdInterface.onCmdListener(false, null);
      return;
      QLog.e("[mini] MiniAppObserver", 1, "onGetKuolieAppListServlet can not found listener. " + paramInt);
      label285:
      return;
      label286:
      paramBoolean = false;
    }
  }
  
  public void onGetLoginCodeFin(int paramInt, boolean paramBoolean, String paramString)
  {
    super.onGetLoginCodeFin(paramInt, paramBoolean, paramString);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean) {}
      do
      {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("code", paramString);
          QLog.d("[mini] MiniAppObserver", 1, "call API_LOGIN  code:" + paramString);
          if (localMiniAppCmdInterface != null) {
            localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
          }
          return;
        }
        catch (Exception paramString)
        {
          do
          {
            QLog.e("[mini] MiniAppObserver", 1, "call API_LOGIN exception " + paramString);
          } while (localMiniAppCmdInterface == null);
          localMiniAppCmdInterface.onCmdListener(false, null);
          return;
        }
        QLog.e("[mini] MiniAppObserver", 1, "call API_LOGIN failed ");
      } while (localMiniAppCmdInterface == null);
      localMiniAppCmdInterface.onCmdListener(false, null);
      return;
    }
    QLog.e("[mini] MiniAppObserver", 1, "onGetLoginCodeFin can not found listener. " + paramInt);
  }
  
  public void onGetMidasConsumeResult(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean)
      {
        try
        {
          Object localObject = (FromServiceMsg)paramBundle.getParcelable("getMidasConsumeResult");
          String str = paramBundle.getString("getMidasConsumeResultErrMsg");
          paramInt = paramBundle.getInt("getMidasConsumeResultRetCode");
          if (localObject != null)
          {
            paramBundle = PayRequest.onResponse(bgau.b(((FromServiceMsg)localObject).getWupBuffer()));
            localObject = new JSONObject();
            ((JSONObject)localObject).put("response", paramBundle);
            ((JSONObject)localObject).put("resultCode", paramInt);
            ((JSONObject)localObject).put("errMsg", str);
            if (localMiniAppCmdInterface == null) {
              return;
            }
            localMiniAppCmdInterface.onCmdListener(true, (JSONObject)localObject);
            return;
          }
          QLog.d("[mini] MiniAppObserver", 1, "call getMidasConsumeResult FromServiceMsg rsp is null.");
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(true, null);
          return;
        }
        catch (Exception paramBundle)
        {
          QLog.e("[mini] MiniAppObserver", 1, "call getMidasConsumeResult exception " + paramBundle);
          if (localMiniAppCmdInterface == null) {
            return;
          }
        }
        localMiniAppCmdInterface.onCmdListener(false, null);
      }
      else
      {
        QLog.d("[mini] MiniAppObserver", 1, "call getMidasConsumeResult fail.");
        if (localMiniAppCmdInterface != null) {
          localMiniAppCmdInterface.onCmdListener(false, null);
        }
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "getMidasConsumeResult can not found listener. " + paramInt);
    }
  }
  
  public void onGetMidasQueryResult(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean)
      {
        try
        {
          Object localObject = (FromServiceMsg)paramBundle.getParcelable("getMidasQueryResult");
          String str = paramBundle.getString("getMidasQueryResultErrMsg");
          paramInt = paramBundle.getInt("getMidasQueryResultRetCode");
          if (localObject != null)
          {
            paramBundle = QueryCurrencyRequest.onResponse(bgau.b(((FromServiceMsg)localObject).getWupBuffer()));
            localObject = new JSONObject();
            ((JSONObject)localObject).put("response", paramBundle);
            ((JSONObject)localObject).put("resultCode", paramInt);
            ((JSONObject)localObject).put("errMsg", str);
            if (localMiniAppCmdInterface == null) {
              return;
            }
            localMiniAppCmdInterface.onCmdListener(true, (JSONObject)localObject);
            return;
          }
          QLog.d("[mini] MiniAppObserver", 1, "call getMidasQueryResult FromServiceMsg rsp is null.");
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(true, null);
          return;
        }
        catch (Exception paramBundle)
        {
          QLog.e("[mini] MiniAppObserver", 1, "call onGetMidasQueryResult exception " + paramBundle);
          if (localMiniAppCmdInterface == null) {
            return;
          }
        }
        localMiniAppCmdInterface.onCmdListener(false, null);
      }
      else
      {
        QLog.d("[mini] MiniAppObserver", 1, "call onGetMidasQueryResult fail.");
        if (localMiniAppCmdInterface != null) {
          localMiniAppCmdInterface.onCmdListener(false, null);
        }
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onGetMidasQueryResult can not found listener. " + paramInt);
    }
  }
  
  public void onGetMineStoryFeedList(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetMineStoryFeedList(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (localMiniAppCmdInterface == null)
      {
        QLog.e("[mini] MiniAppObserver", 1, "onGetMineStoryFeedList  listener is null ");
        return;
      }
      if (paramBoolean)
      {
        try
        {
          paramBundle = (FromServiceMsg)paramBundle.getParcelable("key_get_story_feed_list");
          if (paramBundle != null)
          {
            paramBundle = GetMineStoryFeedListRequest.onResponse(bgau.b(paramBundle.getWupBuffer()));
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("response", paramBundle);
            localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
            return;
          }
        }
        catch (Exception paramBundle)
        {
          QLog.e("[mini] MiniAppObserver", 1, "call onGetMineStoryFeedList exception " + paramBundle);
          localMiniAppCmdInterface.onCmdListener(false, null);
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call onGetMineStoryFeedList FromServiceMsg rsp is null.");
        localMiniAppCmdInterface.onCmdListener(true, null);
        return;
      }
      QLog.d("[mini] MiniAppObserver", 1, "call onGetMineStoryFeedList fail.");
      localMiniAppCmdInterface.onCmdListener(false, null);
      return;
    }
    QLog.e("[mini] MiniAppObserver", 1, "onGetMineStoryFeedList can not found listener. " + paramInt);
  }
  
  public void onGetNativeAppInfoForJump(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean) {}
      try
      {
        JSONObject localJSONObject = new JSONObject();
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
          return;
        }
        localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onGetNativeAppInfoForJump exception " + paramBundle);
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      QLog.d("[mini] MiniAppObserver", 1, "call onGetNativeAppInfoForJump fail.");
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, null);
        return;
        localMiniAppCmdInterface.onCmdListener(false, null);
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onGetNativeAppInfoForJump can not found listener. " + paramInt);
    }
  }
  
  public void onGetNewBaseLibFin(int paramInt, boolean paramBoolean, String paramString1, String paramString2, Bundle paramBundle)
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
        QLog.e("[mini] MiniAppObserver", 1, "call onGetNewBaseLibFin exception " + paramString1);
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      QLog.d("[mini] MiniAppObserver", 1, "call onGetNewBaseLibFin fail.");
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, null);
        return;
        localMiniAppCmdInterface.onCmdListener(false, null);
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onGetNewBaseLibFin can not found listener. " + paramInt);
    }
  }
  
  public void onGetNewBaseLibFinForSDK(int paramInt, boolean paramBoolean, String paramString1, String paramString2, Bundle paramBundle)
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
        QLog.e("[mini] MiniAppObserver", 1, "call onGetNewBaseLibFinForSDK exception " + paramString1);
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      QLog.d("[mini] MiniAppObserver", 1, "call onGetNewBaseLibFinForSDK fail.");
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, null);
        return;
        localMiniAppCmdInterface.onCmdListener(false, null);
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onGetNewBaseLibFinForSDK can not found listener. " + paramInt);
    }
  }
  
  public void onGetPhoneNumber(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetPhoneNumber(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) == null) || (!MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      QLog.e("[mini] MiniAppObserver", 1, "onGetPhoneNumber no listener for " + paramInt);
      return;
    }
    MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
    if (localMiniAppCmdInterface != null)
    {
      if ((paramBoolean) && (paramBundle != null) && (paramBundle.containsKey("data")))
      {
        INTERFACE.StGetPhoneNumberRsp localStGetPhoneNumberRsp = new INTERFACE.StGetPhoneNumberRsp();
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle == null) {
            break label422;
          }
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
        }
        catch (Exception paramBundle)
        {
          QLog.e("[mini] MiniAppObserver", 1, "onGetPhoneNumber", paramBundle);
          localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
          return;
        }
        return;
        label422:
        QLog.e("[mini] MiniAppObserver", 2, "onGetPhoneNumber no bytes data found");
        return;
      }
      long l;
      if (paramBundle != null)
      {
        l = paramBundle.getLong("retCode");
        paramBundle = paramBundle.getString("errMsg");
      }
      try
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject().put("retCode", l).put("errMsg", paramBundle));
        QLog.e("[mini] MiniAppObserver", 1, "onGetPhoneNumber no data found");
        return;
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
      }
    }
    QLog.e("[mini] MiniAppObserver", 2, "onGetPhoneNumber empty listener");
  }
  
  public void onGetPotentialFriendList(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean)
      {
        try
        {
          FromServiceMsg localFromServiceMsg = (FromServiceMsg)paramBundle.getParcelable("getPotentialFriendList");
          long l = paramBundle.getLong("retCode");
          paramBundle = paramBundle.getString("errMsg");
          if (localFromServiceMsg != null)
          {
            CloudStorage.StGetPotentialFriendListRsp localStGetPotentialFriendListRsp = GetPotentialFriendListRequest.onResponse(bgau.b(localFromServiceMsg.getWupBuffer()));
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("response", localStGetPotentialFriendListRsp);
            localJSONObject.put("resultCode", localFromServiceMsg.getResultCode());
            localJSONObject.put("retCode", l);
            localJSONObject.put("errMsg", paramBundle);
            if (localMiniAppCmdInterface == null) {
              return;
            }
            localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
            return;
          }
          QLog.d("[mini] MiniAppObserver", 1, "call getPotentialFriendList FromServiceMsg rsp is null.");
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(true, null);
          return;
        }
        catch (Exception paramBundle)
        {
          QLog.e("[mini] MiniAppObserver", 1, "call getPotentialFriendList exception " + paramBundle);
          if (localMiniAppCmdInterface == null) {
            return;
          }
        }
        localMiniAppCmdInterface.onCmdListener(false, null);
      }
      else
      {
        QLog.d("[mini] MiniAppObserver", 1, "call getPotentialFriendList fail.");
        if (localMiniAppCmdInterface != null) {
          localMiniAppCmdInterface.onCmdListener(false, null);
        }
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "getPotentialFriendList can not found listener. " + paramInt);
    }
  }
  
  public void onGetProfileFin(int paramInt1, String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    super.onGetProfileFin(paramInt1, paramString1, paramBoolean, paramString2, paramString3, paramInt2, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt1))))
    {
      paramString1 = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt1));
      if (paramBoolean) {}
      do
      {
        try
        {
          JSONObject localJSONObject1 = new JSONObject();
          JSONObject localJSONObject2 = new JSONObject();
          JSONObject localJSONObject3 = new JSONObject();
          localJSONObject1.put("nickName", paramString2);
          localJSONObject1.put("avatarUrl", paramString3);
          localJSONObject1.put("gender", paramInt2);
          localJSONObject1.put("province", paramString5);
          localJSONObject1.put("city", paramString6);
          localJSONObject1.put("country", paramString4);
          localJSONObject1.put("language", paramString7);
          localJSONObject3.put("rawData", paramString8);
          localJSONObject3.put("signature", paramString9);
          localJSONObject3.put("encryptedData", paramString10);
          localJSONObject3.put("iv", paramString11);
          localJSONObject3.put("userInfo", localJSONObject1);
          localJSONObject2.put("data", paramString8);
          localJSONObject2.put("signature", paramString9);
          localJSONObject3.put("data", localJSONObject2.toString());
          QLog.d("[mini] MiniAppObserver", 1, "call getUserInfo ： " + localJSONObject3.toString());
          if (paramString1 != null) {
            paramString1.onCmdListener(true, localJSONObject3);
          }
          return;
        }
        catch (Exception paramString2)
        {
          do
          {
            QLog.e("[mini] MiniAppObserver", 1, "call getUserInfo exception " + paramString2);
          } while (paramString1 == null);
          paramString1.onCmdListener(false, null);
          return;
        }
        QLog.e("[mini] MiniAppObserver", 1, "call getUserInfo failed ");
      } while (paramString1 == null);
      paramString1.onCmdListener(false, null);
      return;
    }
    QLog.e("[mini] MiniAppObserver", 1, "onGetProfileFin can not found listener. " + paramInt1);
  }
  
  public void onGetRecommendAppList(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetRecommendAppList(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      long l;
      String str;
      JSONObject localJSONObject;
      try
      {
        l = paramBundle.getLong("retCode", -1L);
        str = paramBundle.getString("errMsg", amtj.a(2131705900));
        localJSONObject = new JSONObject();
        localJSONObject.put("retCode", l);
        localJSONObject.put("errMsg", str);
        if (paramBoolean)
        {
          paramBundle = (FromServiceMsg)paramBundle.getParcelable("key_recommend_module");
          if (paramBundle != null)
          {
            localJSONObject.put("response", GetRecommendAppListRequest.onResponse(bgau.b(paramBundle.getWupBuffer())));
            if (localMiniAppCmdInterface == null) {
              return;
            }
            localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
            return;
          }
          QLog.e("[mini] MiniAppObserver", 1, "call onGetUserAppListV2 FromServiceMsg rsp is null.");
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onGetUserAppListV2 exception " + Log.getStackTraceString(paramBundle));
        return;
      }
      QLog.e("[mini] MiniAppObserver", 1, "call onGetUserAppListV2 fail. errCode = " + l + ", errMsg = " + str);
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onGetUserAppListV2 can not found listener. " + paramInt);
    }
  }
  
  public void onGetRewardedVideoAdResult(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      QLog.i("[mini] MiniAppObserver", 1, "onGetRewardedVideoAdResult, index=" + paramInt);
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean)
      {
        try
        {
          FromServiceMsg localFromServiceMsg = (FromServiceMsg)paramBundle.getParcelable("getRewardedVideoADInfo");
          long l = paramBundle.getLong("retCode");
          paramBundle = paramBundle.getString("errMsg");
          if (localFromServiceMsg != null)
          {
            MiniAppAd.StGetAdRsp localStGetAdRsp = MiniAppGetAdRequest.onResponse(bgau.b(localFromServiceMsg.getWupBuffer()));
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("response", localStGetAdRsp);
            localJSONObject.put("resultCode", localFromServiceMsg.getResultCode());
            localJSONObject.put("retCode", l);
            localJSONObject.put("errMsg", paramBundle);
            if (localMiniAppCmdInterface == null) {
              return;
            }
            localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
            return;
          }
          QLog.d("[mini] MiniAppObserver", 1, "call getRewardedVideoADInfo FromServiceMsg rsp is null.");
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(true, null);
          return;
        }
        catch (Exception paramBundle)
        {
          QLog.e("[mini] MiniAppObserver", 1, "call onGetRewardedVideoAdResult exception " + paramBundle);
          if (localMiniAppCmdInterface == null) {
            return;
          }
        }
        localMiniAppCmdInterface.onCmdListener(false, null);
      }
      else
      {
        QLog.d("[mini] MiniAppObserver", 1, "call onGetRewardedVideoAdResult fail.");
        if (localMiniAppCmdInterface != null) {
          localMiniAppCmdInterface.onCmdListener(false, null);
        }
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onGetRewardedVideoAdResult can not found listener. " + paramInt);
    }
  }
  
  public void onGetRobotUin(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) == null) || (!MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt)))) {
      QLog.e("[mini] MiniAppObserver", 1, "onGetRobotUin can not found listener. " + paramInt);
    }
    MiniAppCmdInterface localMiniAppCmdInterface;
    do
    {
      for (;;)
      {
        return;
        localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
        if (paramBoolean)
        {
          paramBundle = paramBundle.getString("key_robot_result_uin");
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("robotUin", paramBundle);
            if (localMiniAppCmdInterface != null)
            {
              localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
              return;
            }
          }
          catch (Throwable paramBundle)
          {
            QLog.e("[mini] MiniAppObserver", 1, "onGetRobotUin error.", paramBundle);
            return;
          }
        }
      }
    } while (localMiniAppCmdInterface == null);
    localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
  }
  
  public void onGetShareInfo(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetShareInfo(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      long l;
      Object localObject;
      JSONObject localJSONObject;
      try
      {
        l = paramBundle.getLong("retCode", -1L);
        localObject = paramBundle.getString("errMsg", amtj.a(2131705895));
        if (paramBoolean)
        {
          if ((l == -100070004L) || (l == -1000710003L))
          {
            QLog.e("[mini] MiniAppObserver", 1, "onGetShareInfo isSuccess=false, retCode=" + l);
            if (localMiniAppCmdInterface == null) {
              return;
            }
            localJSONObject = new JSONObject();
            localJSONObject.put("retCode", l);
            localJSONObject.put("errMsg", localObject);
            localJSONObject.put("needShareCallBack", paramBundle.getBoolean("needShareCallBack", false));
            localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
            return;
          }
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localObject = new JSONObject(paramBundle.getString("jsonData"));
          ((JSONObject)localObject).put("needShareCallBack", paramBundle.getBoolean("needShareCallBack", false));
          localMiniAppCmdInterface.onCmdListener(true, (JSONObject)localObject);
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        localObject = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject).put("retCode", -1);
        ((JSONObject)localObject).put("errMsg", amtj.a(2131705893));
        localMiniAppCmdInterface.onCmdListener(false, (JSONObject)localObject);
        QLog.e("[mini] MiniAppObserver", 1, "onGetShareInfo parse json failed", paramBundle);
        return;
        QLog.e("[mini] MiniAppObserver", 1, "onGetShareInfo isSuccess=false, retCode=" + l);
        localJSONObject = new JSONObject();
        localJSONObject.put("retCode", l);
        localJSONObject.put("errMsg", localObject);
        localJSONObject.put("needShareCallBack", paramBundle.getBoolean("needShareCallBack", false));
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onGetShareInfo get null response");
    }
  }
  
  public void onGetStoreAppList(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetStoreAppList(paramInt, paramBoolean, paramBundle);
    QLog.d("[mini] MiniAppObserver", 2, "onGetStoreAppList() called with: index = [" + paramInt + "], isSuccess = [" + paramBoolean + "], bundle = [" + paramBundle + "]");
    MiniAppCmdInterface localMiniAppCmdInterface;
    JSONObject localJSONObject;
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      localJSONObject = new JSONObject();
      if (!paramBoolean) {}
    }
    try
    {
      localJSONObject.put("data", paramBundle.getString("data", ""));
      localJSONObject.put("dataType", "string");
      localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
      return;
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  public void onGetSwitchList(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean)
      {
        try
        {
          Object localObject = (FromServiceMsg)paramBundle.getParcelable("getSwitchList");
          long l = paramBundle.getLong("retCode");
          paramBundle = paramBundle.getString("errMsg");
          if (localObject != null)
          {
            localObject = MiniAppGetSwitchListRequest.onResponse(bgau.b(((FromServiceMsg)localObject).getWupBuffer()));
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
          localMiniAppCmdInterface.onCmdListener(true, null);
          return;
        }
        catch (Exception paramBundle)
        {
          QLog.e("[mini] MiniAppObserver", 1, "call onGetSwitchList exception " + paramBundle);
          if (localMiniAppCmdInterface == null) {
            return;
          }
        }
        localMiniAppCmdInterface.onCmdListener(false, null);
      }
      else
      {
        QLog.d("[mini] MiniAppObserver", 1, "call onGetSwitchList fail.");
        if (localMiniAppCmdInterface != null) {
          localMiniAppCmdInterface.onCmdListener(false, null);
        }
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onGetSwitchList can not found listener. " + paramInt);
    }
  }
  
  public void onGetTcbTicket(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) == null) || (!MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt)))) {
      QLog.e("[mini] MiniAppObserver", 1, "onGetTcbTicket can not found listener. " + paramInt);
    }
    for (;;)
    {
      return;
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      JSONObject localJSONObject = new JSONObject();
      if (paramBoolean) {
        try
        {
          localJSONObject.put("ticket", paramBundle.getString("key_ticket"));
          localJSONObject.put("createTime", paramBundle.getInt("key_createTime"));
          localJSONObject.put("period", paramBundle.getInt("key_period"));
          if (localMiniAppCmdInterface == null) {
            continue;
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
    }
  }
  
  public void onGetUserAppInfoFin(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetUserAppInfoFin(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean) {}
      try
      {
        QLog.d("[mini] MiniAppObserver", 1, "call onGetUserAppInfoFin success.");
        JSONObject localJSONObject = new JSONObject();
        paramInt = paramBundle.getInt("like_num", 0);
        int i = paramBundle.getInt("do_like", 0);
        paramBundle = paramBundle.getSerializable("mini_app_info_data");
        localJSONObject.put("likeNum", paramInt);
        localJSONObject.put("doLike", i);
        localJSONObject.put("mini_app_info_data", paramBundle);
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onGetUserAppInfoFin exception " + paramBundle);
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      QLog.d("[mini] MiniAppObserver", 1, "call onGetUserAppInfoFin fail.");
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, null);
        return;
        localMiniAppCmdInterface.onCmdListener(false, null);
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onGetUserAppInfoFin can not found listener. " + paramInt);
    }
  }
  
  public void onGetUserAppList(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetUserAppList(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      long l;
      String str;
      JSONObject localJSONObject;
      try
      {
        l = paramBundle.getLong("retCode", -1L);
        str = paramBundle.getString("errMsg", amtj.a(2131705897));
        localJSONObject = new JSONObject();
        localJSONObject.put("retCode", l);
        localJSONObject.put("errMsg", str);
        if (paramBoolean)
        {
          paramBundle = (FromServiceMsg)paramBundle.getParcelable("getUserAppList");
          if (paramBundle != null)
          {
            localJSONObject.put("response", GetUserAppListRequest.onResponse(bgau.b(paramBundle.getWupBuffer())));
            if (localMiniAppCmdInterface == null) {
              return;
            }
            localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
            return;
          }
          QLog.e("[mini] MiniAppObserver", 1, "call onGetUserAppList FromServiceMsg rsp is null.");
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onGetUserAppList exception " + Log.getStackTraceString(paramBundle));
        return;
      }
      QLog.e("[mini] MiniAppObserver", 1, "call onGetUserAppList fail. errCode = " + l + ", errMsg = " + str);
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onGetUserAppList can not found listener. " + paramInt);
    }
  }
  
  public void onGetUserAppListV2(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onGetUserAppListV2(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      long l;
      String str;
      JSONObject localJSONObject;
      try
      {
        l = paramBundle.getLong("retCode", -1L);
        str = paramBundle.getString("errMsg", amtj.a(2131705898));
        localJSONObject = new JSONObject();
        localJSONObject.put("retCode", l);
        localJSONObject.put("errMsg", str);
        if (paramBoolean)
        {
          paramBundle = (FromServiceMsg)paramBundle.getParcelable("getUserAppListV2");
          if (paramBundle != null)
          {
            localJSONObject.put("response", GetUserAppListRequestV2.onResponse(bgau.b(paramBundle.getWupBuffer())));
            if (localMiniAppCmdInterface == null) {
              return;
            }
            localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
            return;
          }
          QLog.e("[mini] MiniAppObserver", 1, "call onGetUserAppListV2 FromServiceMsg rsp is null.");
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onGetUserAppListV2 exception " + Log.getStackTraceString(paramBundle));
        return;
      }
      QLog.e("[mini] MiniAppObserver", 1, "call onGetUserAppListV2 fail. errCode = " + l + ", errMsg = " + str);
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onGetUserAppListV2 can not found listener. " + paramInt);
    }
  }
  
  public void onGetUserGroupInfo(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      Object localObject;
      long l;
      if (paramBoolean)
      {
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
          QLog.e("[mini] MiniAppObserver", 1, "call getUserInfo exception " + paramBundle);
          if (localMiniAppCmdInterface == null) {
            return;
          }
        }
        localMiniAppCmdInterface.onCmdListener(false, null);
      }
      else
      {
        QLog.d("[mini] MiniAppObserver", 1, "call getUserInfo fail.");
        if (localMiniAppCmdInterface != null)
        {
          localObject = new JSONObject();
          l = paramBundle.getLong("retCode");
          paramBundle = paramBundle.getString("errMsg");
          ((JSONObject)localObject).put("retCode", l);
          ((JSONObject)localObject).put("errMsg", paramBundle);
          localMiniAppCmdInterface.onCmdListener(false, (JSONObject)localObject);
        }
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "getUserInfo can not found listener. " + paramInt);
    }
  }
  
  public void onGetUserHealthData(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (paramBoolean)
        {
          if (paramBundle != null)
          {
            localJSONObject.put("encryptedData", paramBundle.getString("key_encrypted_data"));
            localJSONObject.put("iv", paramBundle.get("key_ret_iv"));
          }
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call onGetUserHealthData fail.");
        if (!TextUtils.isEmpty(paramBundle.getString("errMsg"))) {
          localJSONObject.put("errMsg", paramBundle.getString("errMsg"));
        }
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onGetUserHealthData exception " + paramBundle);
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onGetUserHealthData can not found listener. " + paramInt);
    }
  }
  
  public void onGetUserInfoExtra(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean) {}
      try
      {
        JSONObject localJSONObject = new JSONObject();
        String str = paramBundle.get("ret_encrypt_data").toString();
        paramBundle = paramBundle.get("ret_iv").toString();
        localJSONObject.put("encryptedData", str);
        localJSONObject.put("iv", paramBundle);
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onGetUserInfoExtra exception " + paramBundle);
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      QLog.d("[mini] MiniAppObserver", 1, "call onGetUserInfoExtra fail.");
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onGetUserInfoExtra can not found listener. " + paramInt);
    }
  }
  
  public void onGetUserInteractiveStorage(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean)
      {
        try
        {
          FromServiceMsg localFromServiceMsg = (FromServiceMsg)paramBundle.getParcelable("getUserInteractiveStorage");
          long l = paramBundle.getLong("retCode");
          paramBundle = paramBundle.getString("errMsg");
          if (localFromServiceMsg != null)
          {
            CloudStorage.StGetUserInteractiveStorageRsp localStGetUserInteractiveStorageRsp = GetUserInteractiveStorageRequest.onResponse(bgau.b(localFromServiceMsg.getWupBuffer()));
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("response", localStGetUserInteractiveStorageRsp);
            localJSONObject.put("resultCode", localFromServiceMsg.getResultCode());
            localJSONObject.put("retCode", l);
            localJSONObject.put("errMsg", paramBundle);
            if (localMiniAppCmdInterface == null) {
              return;
            }
            localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
            return;
          }
          QLog.d("[mini] MiniAppObserver", 1, "call getUserInteractiveStorage FromServiceMsg rsp is null.");
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(true, null);
          return;
        }
        catch (Exception paramBundle)
        {
          QLog.e("[mini] MiniAppObserver", 1, "call getUserInteractiveStorage exception " + paramBundle);
          if (localMiniAppCmdInterface == null) {
            return;
          }
        }
        localMiniAppCmdInterface.onCmdListener(false, null);
      }
      else
      {
        QLog.d("[mini] MiniAppObserver", 1, "call getUserInteractiveStorage fail.");
        if (localMiniAppCmdInterface != null) {
          localMiniAppCmdInterface.onCmdListener(false, null);
        }
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "getUserInteractiveStorage can not found listener. " + paramInt);
    }
  }
  
  public void onGetUserSetting(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) == null) || (!MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt)))) {
      QLog.e("[mini] MiniAppObserver", 1, "onGetUserSetting can not found listener. " + paramInt);
    }
    MiniAppCmdInterface localMiniAppCmdInterface;
    do
    {
      for (;;)
      {
        return;
        localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
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
            if (localMiniAppCmdInterface != null)
            {
              localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
              return;
            }
          }
          catch (Throwable paramBundle)
          {
            QLog.e("[mini] MiniAppObserver", 1, "onGetUserSetting error.", paramBundle);
            return;
          }
        }
      }
    } while (localMiniAppCmdInterface == null);
    JSONObject localJSONObject = new JSONObject();
    Object localObject = localJSONObject;
    long l2;
    long l1;
    if (paramBundle != null)
    {
      l2 = paramBundle.getLong("retCode");
      paramBundle = paramBundle.getString("errMsg");
      if (-101511014L != l2) {
        break label287;
      }
      l1 = 20001L;
    }
    try
    {
      for (;;)
      {
        localObject = new JSONObject().put("retCode", l1).put("errMsg", paramBundle);
        localMiniAppCmdInterface.onCmdListener(false, (JSONObject)localObject);
        return;
        label287:
        if (-101511020L == l2)
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
      }
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        localObject = localJSONObject;
      }
    }
  }
  
  public void onGetuserCloudStorage(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("KVDataList", new JSONArray(paramBundle.getString("key_reslut_data")));
        if (localMiniAppCmdInterface != null) {
          localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
        }
        return;
      }
      catch (Throwable paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "onGetuserCloudStorage error. ", paramBundle);
        return;
      }
    }
    QLog.e("[mini] MiniAppObserver", 1, "onGetuserCloudStorage can not found listener. " + paramInt);
  }
  
  public void onLocalSearchDataFin(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onLocalSearchDataFin(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean) {}
      try
      {
        paramBundle = (FromServiceMsg)paramBundle.getParcelable("localSearchData");
        if (paramBundle == null) {
          return;
        }
        paramBundle = LocalSearchDataRequest.onResponse(bgau.b(paramBundle.getWupBuffer()));
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("response", paramBundle);
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onLocalSearchDataFin exception " + paramBundle);
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      QLog.d("[mini] MiniAppObserver", 1, "call onLocalSearchDataFin fail.");
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onLocalSearchDataFin can not found listener. " + paramInt);
    }
  }
  
  public void onModifyFriendInteractiveStorage(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean)
      {
        try
        {
          FromServiceMsg localFromServiceMsg = (FromServiceMsg)paramBundle.getParcelable("modifyFriendInteractiveStorage");
          long l = paramBundle.getLong("retCode");
          paramBundle = paramBundle.getString("errMsg");
          if (localFromServiceMsg != null)
          {
            CloudStorage.StModifyFriendInteractiveStorageRsp localStModifyFriendInteractiveStorageRsp = ModifyFriendInteractiveStorageReq.onResponse(bgau.b(localFromServiceMsg.getWupBuffer()));
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("response", localStModifyFriendInteractiveStorageRsp);
            localJSONObject.put("resultCode", localFromServiceMsg.getResultCode());
            if (localStModifyFriendInteractiveStorageRsp != null) {
              localJSONObject.put("details", localStModifyFriendInteractiveStorageRsp.details.get());
            }
            localJSONObject.put("retCode", l);
            localJSONObject.put("errMsg", paramBundle);
            if (localMiniAppCmdInterface == null) {
              return;
            }
            localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
            return;
          }
          QLog.d("[mini] MiniAppObserver", 1, "call modifyFriendInteractiveStorage FromServiceMsg rsp is null.");
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(true, null);
          return;
        }
        catch (Exception paramBundle)
        {
          QLog.e("[mini] MiniAppObserver", 1, "call modifyFriendInteractiveStorage exception " + paramBundle);
          if (localMiniAppCmdInterface == null) {
            return;
          }
        }
        localMiniAppCmdInterface.onCmdListener(false, null);
      }
      else
      {
        QLog.d("[mini] MiniAppObserver", 1, "call modifyFriendInteractiveStorage fail.");
        if (localMiniAppCmdInterface != null) {
          localMiniAppCmdInterface.onCmdListener(false, null);
        }
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "modifyFriendInteractiveStorage can not found listener. " + paramInt);
    }
  }
  
  public void onOpenChannel(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onOpenChannel(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) == null) || (!MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt)))) {
      QLog.e("[mini] MiniAppObserver", 1, "onOpenChannel can not found listener. " + paramInt);
    }
    MiniAppCmdInterface localMiniAppCmdInterface;
    do
    {
      for (;;)
      {
        return;
        localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
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
            if (localMiniAppCmdInterface != null)
            {
              localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
              return;
            }
          }
          catch (Throwable paramBundle)
          {
            QLog.e("[mini] MiniAppObserver", 1, "onOpenChannel error.", paramBundle);
            return;
          }
        }
      }
    } while (localMiniAppCmdInterface == null);
    localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
  }
  
  public void onRealTimeLogReport(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        long l = paramBundle.getLong("retCode", -1L);
        paramBundle = paramBundle.getString("errMsg", amtj.a(2131705898));
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("retCode", l);
        localJSONObject.put("errMsg", paramBundle);
        if (paramBoolean)
        {
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
          return;
        }
        QLog.e("[mini] MiniAppObserver", 1, "call onRealTimeLogReport fail. errCode = " + l + ", errMsg = " + paramBundle);
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onRealTimeLogReport exception " + Log.getStackTraceString(paramBundle));
        return;
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onRealTimeLogReport can not found listener. " + paramInt);
    }
  }
  
  public void onRemoveuserCloudStorage(int paramInt, boolean paramBoolean)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(paramBoolean, null);
      }
      return;
    }
    QLog.e("[mini] MiniAppObserver", 1, "onRemoveuserCloudStorage can not found listener. " + paramInt);
  }
  
  public void onReportLogFileUrlServlet(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      paramBundle = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean) {}
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (paramBundle == null) {
          return;
        }
        paramBundle.onCmdListener(true, localJSONObject);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onReportLogFileUrlServlet exception " + localException);
        if (paramBundle == null) {
          return;
        }
      }
      QLog.d("[mini] MiniAppObserver", 1, "call onReportLogFileUrlServlet fail.");
      if (paramBundle != null)
      {
        paramBundle.onCmdListener(false, new JSONObject());
        return;
        paramBundle.onCmdListener(false, new JSONObject());
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onReportLogFileUrlServlet can not found listener. " + paramInt);
    }
  }
  
  public void onReportShare(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      paramBundle = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean) {}
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (paramBundle == null) {
          return;
        }
        paramBundle.onCmdListener(true, localJSONObject);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onReportShare exception " + localException);
        if (paramBundle == null) {
          return;
        }
      }
      QLog.d("[mini] MiniAppObserver", 1, "call onReportShare fail.");
      if (paramBundle != null)
      {
        paramBundle.onCmdListener(false, new JSONObject());
        return;
        paramBundle.onCmdListener(false, new JSONObject());
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onReportShare can not found listener. " + paramInt);
    }
  }
  
  public void onSearchApp(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      long l;
      String str;
      JSONObject localJSONObject;
      try
      {
        l = paramBundle.getLong("retCode", -1L);
        str = paramBundle.getString("errMsg", amtj.a(2131705898));
        localJSONObject = new JSONObject();
        localJSONObject.put("retCode", l);
        localJSONObject.put("errMsg", str);
        if (paramBoolean)
        {
          paramBundle = (FromServiceMsg)paramBundle.getParcelable("searchApp");
          if (paramBundle != null)
          {
            localJSONObject.put("searchAppResponse", SearchAppRequest.onResponse(bgau.b(paramBundle.getWupBuffer())));
            if (localMiniAppCmdInterface == null) {
              return;
            }
            localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
            return;
          }
          QLog.e("[mini] MiniAppObserver", 1, "call onSearchApp FromServiceMsg rsp is null.");
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onSearchApp exception " + Log.getStackTraceString(paramBundle));
        return;
      }
      QLog.e("[mini] MiniAppObserver", 1, "call onSearchApp fail. errCode = " + l + ", errMsg = " + str);
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onSearchApp can not found listener. " + paramInt);
    }
  }
  
  public void onSendArkMsg(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean)
      {
        try
        {
          FromServiceMsg localFromServiceMsg = (FromServiceMsg)paramBundle.getParcelable("sendArkMsg");
          long l = paramBundle.getLong("retCode");
          paramBundle = paramBundle.getString("errMsg");
          if (localFromServiceMsg != null)
          {
            MiniProgramShare.StSendArkMsgRsp localStSendArkMsgRsp = MiniAppSendArkMsgRequest.onResponse(bgau.b(localFromServiceMsg.getWupBuffer()));
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("response", localStSendArkMsgRsp);
            localJSONObject.put("resultCode", localFromServiceMsg.getResultCode());
            localJSONObject.put("retCode", l);
            localJSONObject.put("errMsg", paramBundle);
            if (localMiniAppCmdInterface == null) {
              return;
            }
            localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
            return;
          }
          QLog.d("[mini] MiniAppObserver", 1, "call sendArkMsg FromServiceMsg rsp is null.");
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(true, null);
          return;
        }
        catch (Exception paramBundle)
        {
          QLog.e("[mini] MiniAppObserver", 1, "call sendArkMsg exception " + paramBundle);
          if (localMiniAppCmdInterface == null) {
            return;
          }
        }
        localMiniAppCmdInterface.onCmdListener(false, null);
      }
      else
      {
        QLog.d("[mini] MiniAppObserver", 1, "call sendArkMsg fail.");
        if (localMiniAppCmdInterface != null) {
          localMiniAppCmdInterface.onCmdListener(false, null);
        }
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "sendArkMsg can not found listener. " + paramInt);
    }
  }
  
  public void onSetAuth(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      JSONObject localJSONObject;
      if (localMiniAppCmdInterface != null)
      {
        localJSONObject = new JSONObject();
        if (paramBundle == null) {}
      }
      try
      {
        localJSONObject.put("retCode", paramBundle.getLong("retCode"));
        localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
        return;
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
      }
    }
    QLog.e("[mini] MiniAppObserver", 1, "onGetUserHealthData can not found listener. " + paramInt);
  }
  
  public void onSetAvatar(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean) {}
      try
      {
        paramBundle = new JSONObject();
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(true, paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        JSONObject localJSONObject;
        long l;
        QLog.e("[mini] MiniAppObserver", 1, "call onGetUserInfoExtra exception " + paramBundle);
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      QLog.d("[mini] MiniAppObserver", 1, "call onGetUserInfoExtra fail.");
      if (localMiniAppCmdInterface != null)
      {
        localJSONObject = new JSONObject();
        l = paramBundle.getLong("retCode", -1L);
        paramBundle = paramBundle.getString("errMsg", amtj.a(2131705899));
        localJSONObject.put("retCode", l);
        localJSONObject.put("errMsg", paramBundle);
        localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
        return;
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onGetUserInfoExtra can not found listener. " + paramInt);
    }
  }
  
  public void onSetTopMiniAppFin(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onSetTopMiniAppFin(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean) {}
      try
      {
        JSONObject localJSONObject = new JSONObject();
        paramBundle = paramBundle.getByteArray("key_extendinfo");
        if (paramBundle != null)
        {
          COMM.StCommonExt localStCommonExt = new COMM.StCommonExt();
          localStCommonExt.mergeFrom(paramBundle);
          localJSONObject.put("ext", localStCommonExt);
        }
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onSetTopMiniAppFin exception " + paramBundle);
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      QLog.d("[mini] MiniAppObserver", 1, "call onSetTopMiniAppFin fail.");
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, null);
        return;
        localMiniAppCmdInterface.onCmdListener(false, null);
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onSetTopMiniAppFin can not found listener. " + paramInt);
    }
  }
  
  public void onSetUserAppLikeFin(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    super.onSetUserAppLikeFin(paramInt, paramBoolean, paramBundle);
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean) {}
      try
      {
        JSONObject localJSONObject = new JSONObject();
        paramBundle = paramBundle.getByteArray("key_extendinfo");
        if (paramBundle != null)
        {
          COMM.StCommonExt localStCommonExt = new COMM.StCommonExt();
          localStCommonExt.mergeFrom(paramBundle);
          localJSONObject.put("ext", localStCommonExt);
        }
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onSetUserAppLikeFin exception " + paramBundle);
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      QLog.d("[mini] MiniAppObserver", 1, "call onSetUserAppLikeFin fail.");
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, null);
        return;
        localMiniAppCmdInterface.onCmdListener(false, null);
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onSetUserAppLikeFin can not found listener. " + paramInt);
    }
  }
  
  public void onSetUserSwitch(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean)
      {
        try
        {
          Object localObject = (FromServiceMsg)paramBundle.getParcelable("setUserSwitch");
          long l = paramBundle.getLong("retCode");
          paramBundle = paramBundle.getString("errMsg");
          if (localObject != null)
          {
            localObject = MiniAppSetUserSwitchRequest.onResponse(bgau.b(((FromServiceMsg)localObject).getWupBuffer()));
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
          localMiniAppCmdInterface.onCmdListener(true, null);
          return;
        }
        catch (Exception paramBundle)
        {
          QLog.e("[mini] MiniAppObserver", 1, "call onSetUserSwitch exception " + paramBundle);
          if (localMiniAppCmdInterface == null) {
            return;
          }
        }
        localMiniAppCmdInterface.onCmdListener(false, null);
      }
      else
      {
        QLog.d("[mini] MiniAppObserver", 1, "call onSetUserSwitch fail.");
        if (localMiniAppCmdInterface != null) {
          localMiniAppCmdInterface.onCmdListener(false, null);
        }
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onSetUserSwitch can not found listener. " + paramInt);
    }
  }
  
  public void onSetuserCloudStorage(int paramInt, boolean paramBoolean)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(paramBoolean, null);
      }
      return;
    }
    QLog.e("[mini] MiniAppObserver", 1, "onSetuserCloudStorage can not found listener. " + paramInt);
  }
  
  public void onTransForOpenIdAndTinyId(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      if (paramBoolean) {}
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("openId", paramBundle.getString("key_open_id"));
        localJSONObject.put("tinyId", paramBundle.getString("key_tiny_id"));
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onTransForOpenIdAndTinyId exception " + paramBundle);
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      QLog.d("[mini] MiniAppObserver", 1, "call onTransForOpenIdAndTinyId fail.");
      if (localMiniAppCmdInterface != null)
      {
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
        return;
        localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
      }
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onTransForOpenIdAndTinyId can not found listener. " + paramInt);
    }
  }
  
  public void onTransForRoomId(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (paramBoolean)
        {
          localJSONObject.put("openId", paramBundle.getString("key_open_id"));
          localJSONObject.put("tinyId", paramBundle.getLong("key_tiny_id"));
          localJSONObject.put("roomId", paramBundle.getInt("key_room_id"));
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call onTransForRoomId fail.");
        if (!TextUtils.isEmpty(paramBundle.getString("errMsg"))) {
          localJSONObject.put("errMsg", paramBundle.getString("errMsg"));
        }
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onTransForRoomId exception " + paramBundle);
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onTransForRoomId can not found listener. " + paramInt);
    }
  }
  
  public void onUpdateUserSetting(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) == null) || (!MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt)))) {
      QLog.e("[mini] MiniAppObserver", 1, "onUpdateUserSetting can not found listener. " + paramInt);
    }
    do
    {
      do
      {
        return;
        paramBundle = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
        if (!paramBoolean) {
          break;
        }
      } while (paramBundle == null);
      paramBundle.onCmdListener(true, new JSONObject());
      return;
    } while (paramBundle == null);
    paramBundle.onCmdListener(false, new JSONObject());
  }
  
  public void onUseUserAppFin(int paramInt, boolean paramBoolean, Bundle paramBundle)
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
        Object localObject = paramBundle.getByteArray("key_recommend");
        if (localObject != null)
        {
          paramBundle = new INTERFACE.StModuleInfo();
          paramBundle.mergeFrom((byte[])localObject);
          localObject = (INTERFACE.StUserAppInfo)paramBundle.jumpMoreApp.get();
          if ((localObject != null) && (((INTERFACE.StUserAppInfo)localObject).appInfo.get() != null)) {
            localJSONObject.put("moreAppInfo", GsonUtils.obj2Json(com.tencent.mobileqq.mini.apkg.MiniAppInfo.from((INTERFACE.StApiAppInfo)((INTERFACE.StUserAppInfo)localObject).appInfo.get())));
          }
          localObject = new JSONArray();
          int i = paramBundle.userAppList.size();
          paramInt = 0;
          if (paramInt < i)
          {
            INTERFACE.StUserAppInfo localStUserAppInfo = (INTERFACE.StUserAppInfo)paramBundle.userAppList.get(paramInt);
            if ((localStUserAppInfo == null) || (localStUserAppInfo.appInfo.get() == null)) {
              break label377;
            }
            ((JSONArray)localObject).put(GsonUtils.obj2Json(com.tencent.mobileqq.mini.apkg.MiniAppInfo.from((INTERFACE.StApiAppInfo)localStUserAppInfo.appInfo.get())));
            break label377;
          }
          localJSONObject.put("appList", localObject);
          localJSONObject.put("backgroundPic", paramBundle.backgroundPic.get());
          localJSONObject.put("jumpLink", paramBundle.jumpLink.get());
        }
        if (localMiniAppCmdInterface == null) {
          break;
        }
        localMiniAppCmdInterface.onCmdListener(true, localJSONObject);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onUseUserAppFin exception " + paramBundle);
        if (localMiniAppCmdInterface == null) {
          break;
        }
      }
      QLog.d("[mini] MiniAppObserver", 1, "call onUseUserAppFin fail.");
      if (localMiniAppCmdInterface == null) {
        break;
      }
      localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
      return;
      localMiniAppCmdInterface.onCmdListener(false, localJSONObject);
      return;
      QLog.e("[mini] MiniAppObserver", 1, "onUseUserAppFin can not found listener. " + paramInt);
      return;
      label377:
      paramInt += 1;
    }
  }
  
  public void onVerifyPlugin(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((MiniAppCmdUtil.access$400(this.this$0) != null) && (MiniAppCmdUtil.access$400(this.this$0).containsKey(Integer.valueOf(paramInt))))
    {
      MiniAppCmdInterface localMiniAppCmdInterface = (MiniAppCmdInterface)MiniAppCmdUtil.access$400(this.this$0).remove(Integer.valueOf(paramInt));
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        if (paramBoolean)
        {
          localJSONObject2.put("list", new JSONArray(paramBundle.getString("plugin_profile")));
          localJSONObject1.put("data", localJSONObject2);
          if (localMiniAppCmdInterface == null) {
            return;
          }
          localMiniAppCmdInterface.onCmdListener(true, localJSONObject1);
          return;
        }
        QLog.d("[mini] MiniAppObserver", 1, "call onVerifyPlugin fail.");
        if (!TextUtils.isEmpty(paramBundle.getString("errMsg"))) {
          localJSONObject1.put("errMsg", paramBundle.getString("errMsg"));
        }
        if (localMiniAppCmdInterface == null) {
          return;
        }
        localMiniAppCmdInterface.onCmdListener(false, localJSONObject1);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("[mini] MiniAppObserver", 1, "call onVerifyPlugin exception " + paramBundle);
        if (localMiniAppCmdInterface == null) {
          return;
        }
      }
      localMiniAppCmdInterface.onCmdListener(false, new JSONObject());
    }
    else
    {
      QLog.e("[mini] MiniAppObserver", 1, "onVerifyPlugin can not found listener. " + paramInt);
    }
  }
  
  public void onWxPayCheckUrlResult(int paramInt, boolean paramBoolean, Bundle paramBundle)
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
        for (;;)
        {
          QLog.e("[mini] MiniAppObserver", 1, "onWxPayCheckUrlResult error. ", paramBundle);
        }
      }
      if (localMiniAppCmdInterface != null) {
        localMiniAppCmdInterface.onCmdListener(paramBoolean, localJSONObject);
      }
      return;
    }
    QLog.e("[mini] MiniAppObserver", 1, "onWxPayCheckUrlResult can not found listener. " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil.1
 * JD-Core Version:    0.7.0.1
 */