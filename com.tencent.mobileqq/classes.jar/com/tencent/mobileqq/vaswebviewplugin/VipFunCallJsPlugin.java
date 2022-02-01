package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vipav.VipFunCallPreviewActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class VipFunCallJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BusinessName = "funCall";
  public static final int DOWNLOAD_DONE = 3;
  public static final int DOWNLOAD_ERROR = -4;
  public static final int DOWNLOAD_PARAM_ERR = -2;
  public static final int DOWNLOAD_PROGRESS = 2;
  public static final int DOWNLOAD_START = 1;
  public static final String TAG = "VipFunCallJsPlugin";
  String SetFuncallCallBack = "";
  SparseIntArray down_bgprogress = new SparseIntArray();
  SparseIntArray down_bgstatus = new SparseIntArray();
  SparseIntArray down_progress = new SparseIntArray();
  SparseIntArray down_ringProgress = new SparseIntArray();
  SparseIntArray down_ringStatus = new SparseIntArray();
  SparseIntArray down_status = new SparseIntArray();
  
  public VipFunCallJsPlugin()
  {
    this.mPluginNameSpace = "funCall";
  }
  
  public void callPJs(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("method:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", json:");
      localStringBuilder.append(paramString2);
      QLog.d("VipFunCallJsPlugin", 2, localStringBuilder.toString());
    }
    callJs(paramString1, new String[] { paramString2 });
  }
  
  protected long getPluginBusiness()
  {
    return 2148007936L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest, url=");
      paramJsBridgeListener.append(paramString1);
      QLog.d("VipFunCallJsPlugin", 2, paramJsBridgeListener.toString());
    }
    if (("funCall".equals(paramString2)) && (paramString1 != null) && (paramString3 != null)) {}
    label2994:
    label3000:
    label3003:
    label3006:
    label3009:
    for (;;)
    {
      try
      {
        Object localObject4 = WebViewPlugin.getJsonFromJSBridge(paramString1);
        if (localObject4 == null) {
          return true;
        }
        boolean bool = QLog.isColorLevel();
        if (bool)
        {
          try
          {
            paramJsBridgeListener = new StringBuilder();
            paramJsBridgeListener.append("handleJsRequest JSON = ");
            paramJsBridgeListener.append(((JSONObject)localObject4).toString());
            QLog.d("VipFunCallJsPlugin", 2, paramJsBridgeListener.toString());
          }
          catch (Exception paramJsBridgeListener)
          {
            continue;
          }
          catch (JSONException paramJsBridgeListener) {}
          break label2933;
        }
        String str = ((JSONObject)localObject4).optString("callback");
        bool = ((JSONObject)localObject4).has("callId");
        int j;
        if (bool) {
          j = ((JSONObject)localObject4).getInt("callId");
        } else {
          j = 0;
        }
        bool = ((JSONObject)localObject4).has("ringId");
        int i;
        if (bool) {
          i = ((JSONObject)localObject4).getInt("ringId");
        } else {
          i = 0;
        }
        bool = ((JSONObject)localObject4).has("feeType");
        int k;
        if (bool) {
          k = ((JSONObject)localObject4).getInt("feeType");
        } else {
          k = 1;
        }
        try
        {
          bool = ((JSONObject)localObject4).has("mediaUrl");
          Object localObject3 = "";
          if (bool)
          {
            try
            {
              paramString2 = ((JSONObject)localObject4).getString("mediaUrl");
            }
            catch (Exception paramJsBridgeListener)
            {
              continue;
            }
            catch (JSONException paramJsBridgeListener) {}
            continue;
          }
          paramString2 = "";
          bool = ((JSONObject)localObject4).has("fuzzImageUrl");
          if (bool) {
            paramJsBridgeListener = ((JSONObject)localObject4).getString("fuzzImageUrl");
          } else {
            paramJsBridgeListener = "";
          }
          try
          {
            bool = ((JSONObject)localObject4).has("imageUrl");
            if (bool)
            {
              try
              {
                localObject1 = ((JSONObject)localObject4).getString("imageUrl");
              }
              catch (Exception paramJsBridgeListener)
              {
                continue;
              }
              catch (JSONException paramJsBridgeListener) {}
              continue;
            }
            Object localObject1 = "";
            bool = ((JSONObject)localObject4).has("ringUrl");
            if (bool) {
              paramVarArgs = ((JSONObject)localObject4).getString("ringUrl");
            } else {
              paramVarArgs = "";
            }
            bool = ((JSONObject)localObject4).has("thumbnailUrl");
            Object localObject2;
            if (bool) {
              localObject2 = ((JSONObject)localObject4).getString("thumbnailUrl");
            } else {
              localObject2 = "";
            }
            bool = ((JSONObject)localObject4).has("name");
            if (bool) {
              localObject3 = ((JSONObject)localObject4).getString("name");
            }
            try
            {
              localObject4 = new Bundle();
              ((Bundle)localObject4).putInt("callId", j);
              ((Bundle)localObject4).putInt("ringId", i);
              ((Bundle)localObject4).putInt("feeType", k);
              ((Bundle)localObject4).putString("url_Video", paramString2);
              ((Bundle)localObject4).putString("url_Fuzz", paramJsBridgeListener);
              ((Bundle)localObject4).putString("url_Picture", (String)localObject1);
              ((Bundle)localObject4).putString("url_Ring", paramVarArgs);
              ((Bundle)localObject4).putString("url_call_thum", (String)localObject2);
              ((Bundle)localObject4).putString("url_call_thum", (String)localObject2);
              ((Bundle)localObject4).putString("name", (String)localObject3);
              bool = QLog.isColorLevel();
              if (!bool) {
                break label2994;
              }
            }
            catch (Exception paramJsBridgeListener) {}catch (JSONException paramJsBridgeListener) {}
          }
          catch (Exception paramJsBridgeListener) {}catch (JSONException paramJsBridgeListener) {}
        }
        catch (Exception paramJsBridgeListener) {}catch (JSONException paramJsBridgeListener) {}
      }
      catch (Exception paramJsBridgeListener)
      {
        paramString2 = new StringBuilder();
        paramString2.append("handleJsRequest, Exception=");
        paramString2.append(paramJsBridgeListener.getMessage());
        paramString2.append(", url=");
        paramString2.append(paramString1);
        QLog.e("VipFunCallJsPlugin", 1, paramString2.toString());
        return true;
      }
      catch (JSONException paramJsBridgeListener) {}
      try
      {
        if ("queryDownloadInfo".equals(paramString3)) {
          break label2994;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleJsRequest callid=");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append(", ringid=");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(", feeType");
        ((StringBuilder)localObject2).append(k);
        ((StringBuilder)localObject2).append(", mediaUrl=");
        ((StringBuilder)localObject2).append(paramString2);
        ((StringBuilder)localObject2).append(", fuzzImageUrl");
        ((StringBuilder)localObject2).append(paramJsBridgeListener);
        ((StringBuilder)localObject2).append(", imageUrl=");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(", ringUrl");
        ((StringBuilder)localObject2).append(paramVarArgs);
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      catch (Exception paramJsBridgeListener)
      {
        continue;
      }
      catch (JSONException paramJsBridgeListener)
      {
        continue;
      }
      try
      {
        QLog.d("VipFunCallJsPlugin", 2, (String)localObject1);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("code", 0);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString3);
        ((StringBuilder)localObject1).append(" has done.");
        ((JSONObject)localObject2).put("errorMessage", ((StringBuilder)localObject1).toString());
        bool = "openPreview".equals(paramString3);
        if (bool)
        {
          if (QLog.isColorLevel())
          {
            paramJsBridgeListener = new StringBuilder();
            paramJsBridgeListener.append("openPreview ringId=");
            paramJsBridgeListener.append(i);
            paramJsBridgeListener.append(", callId=");
            paramJsBridgeListener.append(j);
            QLog.d("VipFunCallJsPlugin", 2, paramJsBridgeListener.toString());
          }
          paramJsBridgeListener = this;
        }
        try
        {
          paramString2 = paramJsBridgeListener.mRuntime.a();
          paramString3 = new Intent(paramString2, VipFunCallPreviewActivity.class);
          paramString3.putExtra("key_to_uin", paramJsBridgeListener.mRuntime.a().getAccount());
          paramString3.putExtra("callId", j);
          paramString3.putExtra("ringId", i);
          paramString3.putExtra("bundle", (Bundle)localObject4);
          paramString2.startActivity(paramString3);
          paramJsBridgeListener.callJs(str, new String[] { ((JSONObject)localObject2).toString() });
        }
        catch (Exception paramJsBridgeListener)
        {
          long l;
          SparseIntArray localSparseIntArray;
          continue;
        }
        catch (JSONException paramJsBridgeListener)
        {
          break label2933;
        }
        localObject1 = this;
        if ("setFunCallMedia".equals(paramString3))
        {
          ((VipFunCallJsPlugin)localObject1).SetFuncallCallBack = str;
          ((Bundle)localObject4).putInt("callId", j);
          ((Bundle)localObject4).putInt("ringId", i);
          ((Bundle)localObject4).putInt("feeType", k);
          ((VipFunCallJsPlugin)localObject1).sendRemoteReq(DataFactory.a("funcall_set", str, ((VipFunCallJsPlugin)localObject1).mOnRemoteResp.key, (Bundle)localObject4), false, false);
        }
        else
        {
          bool = "downloadFunCallMedia".equals(paramString3);
          if (bool)
          {
            l = i;
            paramString3 = ColorRingManager.a(l, 3);
            localObject3 = ((VipFunCallJsPlugin)localObject1).down_ringStatus;
            localSparseIntArray = ((VipFunCallJsPlugin)localObject1).down_ringProgress;
            try
            {
              k = testResStatus(i, paramString3, (SparseIntArray)localObject3, localSparseIntArray, "down_ring");
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("startDownload, ringPath=");
                ((StringBuilder)localObject3).append(paramString3);
                ((StringBuilder)localObject3).append(", ringId=");
                ((StringBuilder)localObject3).append(i);
                ((StringBuilder)localObject3).append(", ringUrl in=");
                ((StringBuilder)localObject3).append(paramVarArgs);
                ((StringBuilder)localObject3).append(", resStatus:");
                ((StringBuilder)localObject3).append(k);
                QLog.d("VipFunCallJsPlugin", 2, ((StringBuilder)localObject3).toString());
              }
              paramString3 = VipFunCallUtil.a(null, j, VipFunCallUtil.a(), paramString2);
              i = testResStatus(j, paramString3, ((VipFunCallJsPlugin)localObject1).down_status, ((VipFunCallJsPlugin)localObject1).down_progress, "down_fcVideo");
              if (!QLog.isColorLevel()) {
                break label3000;
              }
              paramVarArgs = new StringBuilder();
              paramVarArgs.append("startDownload, mediaUrl=");
              paramVarArgs.append(paramString2);
              paramVarArgs.append(", fcPath=");
              paramVarArgs.append(paramString3);
              paramVarArgs.append(", callId=");
              paramVarArgs.append(j);
              paramVarArgs.append(", resStatus:");
              paramVarArgs.append(i);
              QLog.d("VipFunCallJsPlugin", 2, paramVarArgs.toString());
              if (TextUtils.isEmpty(paramString3))
              {
                QLog.e("VipFunCallJsPlugin", 1, "startDownload queryDownloadInfo no mediaUrl , fcPath=null.");
                ((JSONObject)localObject2).put("code", VipFunCallConstants.a);
                ((JSONObject)localObject2).put("errorMessage", "no mediaUrl , fcPath=null");
                ((VipFunCallJsPlugin)localObject1).callJs(str, new String[] { ((JSONObject)localObject2).toString() });
                return true;
              }
              paramString2 = VipFunCallUtil.a(null, j, 9, paramJsBridgeListener);
              paramString3 = ((VipFunCallJsPlugin)localObject1).down_bgstatus;
              paramVarArgs = ((VipFunCallJsPlugin)localObject1).down_bgprogress;
              i = testResStatus(j, paramString2, paramString3, paramVarArgs, "down_fuzzpic");
              if (QLog.isColorLevel())
              {
                paramString3 = new StringBuilder();
                paramString3.append("startDownload, fuzzUrl=");
                paramString3.append(paramJsBridgeListener);
                paramString3.append(", fuzzPath=");
                paramString3.append(paramString2);
                paramString3.append(", callId=");
                paramString3.append(j);
                paramString3.append(", resStatus:");
                paramString3.append(i);
                QLog.d("VipFunCallJsPlugin", 2, paramString3.toString());
              }
              if (!Utils.a())
              {
                QLog.e("VipFunCallJsPlugin", 1, "startDownload SDCard not available.");
                ((JSONObject)localObject2).put("code", VipFunCallConstants.c);
                ((JSONObject)localObject2).put("errorMessage", "no sdcard");
                paramJsBridgeListener = ((JSONObject)localObject2).toString();
                callJs(str, new String[] { paramJsBridgeListener });
                return true;
              }
              paramJsBridgeListener = this;
              l = Utils.b();
              if (l < 1048576)
              {
                paramString2 = new StringBuilder();
                paramString2.append("startDownload Insufficient SDCard space, required: reserved:");
                paramString2.append(1048576);
                paramString2.append("|available:");
                paramString2.append(l);
                QLog.e("VipFunCallJsPlugin", 1, paramString2.toString());
                ((JSONObject)localObject2).put("code", VipFunCallConstants.b);
                ((JSONObject)localObject2).put("errorMessage", "SDCard is full");
                paramJsBridgeListener.callJs(str, new String[] { ((JSONObject)localObject2).toString() });
                return true;
              }
              paramJsBridgeListener.sendRemoteReq(DataFactory.a("funcall_download", str, paramJsBridgeListener.mOnRemoteResp.key, (Bundle)localObject4), false, false);
              ((JSONObject)localObject2).put("errorMessage", "id is downloading");
              paramJsBridgeListener.callJs(str, new String[] { ((JSONObject)localObject2).toString() });
            }
            catch (Exception paramJsBridgeListener)
            {
              continue;
            }
            catch (JSONException paramJsBridgeListener)
            {
              break label2933;
            }
          }
          try
          {
            bool = "queryDownloadInfo".equals(paramString3);
            if (!bool) {}
          }
          catch (Exception paramJsBridgeListener) {}catch (JSONException paramJsBridgeListener) {}
        }
      }
      catch (Exception paramJsBridgeListener) {}catch (JSONException paramJsBridgeListener) {}
      try
      {
        localObject3 = new JSONObject();
        if (((VipFunCallJsPlugin)localObject1).down_status.get(j) > 0) {
          break label3009;
        }
        localObject4 = VipFunCallUtil.a(null, j, VipFunCallUtil.a(), paramString2);
        localSparseIntArray = ((VipFunCallJsPlugin)localObject1).down_status;
        localObject1 = ((VipFunCallJsPlugin)localObject1).down_progress;
        k = testResStatus(j, (String)localObject4, localSparseIntArray, (SparseIntArray)localObject1, "query_fcVideo");
        if (!QLog.isColorLevel()) {
          break label3003;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("queryDownloadInfo video, mediaUrl=");
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append(", fcPath=");
        ((StringBuilder)localObject1).append((String)localObject4);
        ((StringBuilder)localObject1).append(", callId=");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append(", resStatus:");
        ((StringBuilder)localObject1).append(k);
        QLog.d("VipFunCallJsPlugin", 2, ((StringBuilder)localObject1).toString());
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          break label3006;
        }
        QLog.e("VipFunCallJsPlugin", 1, "queryDownloadInfo Error no mediaUrl , fcPath=null.");
        ((JSONObject)localObject2).put("code", VipFunCallConstants.a);
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append(paramString3);
        paramJsBridgeListener.append(" no mediaUrl , fcPath=null");
        ((JSONObject)localObject2).put("errorMessage", paramJsBridgeListener.toString());
        paramJsBridgeListener = ((JSONObject)localObject2).toString();
      }
      catch (Exception paramJsBridgeListener)
      {
        continue;
      }
      catch (JSONException paramJsBridgeListener)
      {
        continue;
        continue;
      }
      try
      {
        callJs(str, new String[] { paramJsBridgeListener });
        return true;
      }
      catch (Exception paramJsBridgeListener) {}catch (JSONException paramJsBridgeListener)
      {
        continue;
      }
      paramString2 = (String)localObject3;
      paramString3 = paramJsBridgeListener;
      paramJsBridgeListener = this;
      if (paramJsBridgeListener.down_bgstatus.get(j) <= 0)
      {
        localObject1 = VipFunCallUtil.a(null, j, 9, paramString3);
        k = testResStatus(j, (String)localObject1, paramJsBridgeListener.down_bgstatus, paramJsBridgeListener.down_bgprogress, "query_fuzzpic");
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("queryDownloadInfo bg, fuzzUrl=");
          ((StringBuilder)localObject3).append(paramString3);
          ((StringBuilder)localObject3).append(", fuzzPath=");
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(", callId=");
          ((StringBuilder)localObject3).append(j);
          ((StringBuilder)localObject3).append(", resStatus:");
          ((StringBuilder)localObject3).append(k);
          QLog.d("VipFunCallJsPlugin", 2, ((StringBuilder)localObject3).toString());
        }
      }
      if (paramJsBridgeListener.down_ringStatus.get(i) <= 0)
      {
        paramString3 = ColorRingManager.a(i, 3);
        k = testResStatus(i, paramString3, paramJsBridgeListener.down_ringStatus, paramJsBridgeListener.down_ringProgress, "query_ring");
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("queryDownloadInfo ring, ringPath=");
          ((StringBuilder)localObject1).append(paramString3);
          ((StringBuilder)localObject1).append(", ringId=");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(", ringUrl=");
          ((StringBuilder)localObject1).append(paramVarArgs);
          ((StringBuilder)localObject1).append(", resStatus:");
          ((StringBuilder)localObject1).append(k);
          ((StringBuilder)localObject1).append(", callId=");
          ((StringBuilder)localObject1).append(j);
          QLog.d("VipFunCallJsPlugin", 2, ((StringBuilder)localObject1).toString());
        }
      }
      if ((paramJsBridgeListener.down_status.get(j) == 1) && (paramJsBridgeListener.down_bgstatus.get(j) == 1) && (paramJsBridgeListener.down_ringStatus.get(i) == 1))
      {
        paramString3 = paramString2;
        paramString3.put("status", 1);
        paramString3.put("onProgress", 0);
        if (QLog.isColorLevel())
        {
          paramString3 = new StringBuilder();
          paramString3.append("queryDownloadInfo DOWNLOAD_START, ringId=");
          paramString3.append(i);
          paramString3.append(", callId=");
          paramString3.append(j);
          QLog.d("VipFunCallJsPlugin", 2, paramString3.toString());
        }
      }
      else
      {
        paramString3 = paramString2;
        if ((paramJsBridgeListener.down_status.get(j) == 3) && (paramJsBridgeListener.down_bgstatus.get(j) == 3) && (paramJsBridgeListener.down_ringStatus.get(i) == 3))
        {
          paramString3.put("status", 3);
          paramString3.put("onProgress", 100);
          if (QLog.isColorLevel())
          {
            paramString3 = new StringBuilder();
            paramString3.append("queryDownloadInfo DOWNLOAD_DONE, ringId=");
            paramString3.append(i);
            paramString3.append(", callId=");
            paramString3.append(j);
            QLog.d("VipFunCallJsPlugin", 2, paramString3.toString());
          }
        }
        else
        {
          j = (paramJsBridgeListener.down_progress.get(j) * 6 + paramJsBridgeListener.down_bgprogress.get(j) * 1 + paramJsBridgeListener.down_ringProgress.get(i) * 3) / 10;
          paramString3.put("status", 2);
          paramString3.put("onProgress", j);
          if (QLog.isColorLevel())
          {
            paramString3 = new StringBuilder();
            paramString3.append("DOWNLOAD_PROGRESS ringId=");
            paramString3.append(i);
            paramString3.append(", progress = ");
            paramString3.append(j);
            paramString3.append(" call");
            QLog.d("VipFunCallJsPlugin", 2, paramString3.toString());
          }
        }
      }
      ((JSONObject)localObject2).put("data", paramString2);
      paramJsBridgeListener.callJs(str, new String[] { ((JSONObject)localObject2).toString() });
      continue;
      if ("delFunCallGroup".equals(paramString3))
      {
        ((VipFunCallJsPlugin)localObject1).SetFuncallCallBack = str;
        if (!QLog.isColorLevel()) {
          break;
        }
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append("handleJsRequest delFunCallGroup, url=");
      }
      try
      {
        paramJsBridgeListener.append(paramString1);
        QLog.d("VipFunCallJsPlugin", 2, paramJsBridgeListener.toString());
        ((VipFunCallJsPlugin)localObject1).sendRemoteReq(DataFactory.a("funcall_delete", str, ((VipFunCallJsPlugin)localObject1).mOnRemoteResp.key, (Bundle)localObject4), false, false);
        continue;
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append("handleJsRequest, url=");
        paramJsBridgeListener.append(paramString1);
        QLog.e("VipFunCallJsPlugin", 1, paramJsBridgeListener.toString());
        ((JSONObject)localObject2).put("code", -1);
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append(paramString3);
        paramJsBridgeListener.append(" is Error method.");
        ((JSONObject)localObject2).put("errorMessage", paramJsBridgeListener.toString());
        ((VipFunCallJsPlugin)localObject1).callJs(str, new String[] { ((JSONObject)localObject2).toString() });
        return true;
      }
      catch (Exception paramJsBridgeListener) {}catch (JSONException paramJsBridgeListener)
      {
        break label2933;
      }
      label2933:
      paramString2 = new StringBuilder();
      paramString2.append("handleJsRequest, JSONException=");
      paramString2.append(paramJsBridgeListener.getMessage());
      paramString2.append(", url=");
      paramString2.append(paramString1);
      QLog.e("VipFunCallJsPlugin", 1, paramString2.toString());
      return true;
      return false;
      continue;
      continue;
      continue;
      continue;
    }
  }
  
  public void onPushMsg(Bundle paramBundle)
  {
    if (paramBundle != null) {}
    for (;;)
    {
      SparseIntArray localSparseIntArray;
      try
      {
        String str = paramBundle.getString("callbackId");
        int i = paramBundle.getInt("srcType");
        if (i == 6)
        {
          int j = paramBundle.getInt("resourceType");
          localSparseIntArray = null;
          if (j == 6)
          {
            localSparseIntArray = this.down_progress;
            localObject = this.down_status;
            break label787;
          }
          if (j == 9)
          {
            localSparseIntArray = this.down_bgprogress;
            localObject = this.down_bgstatus;
            break label787;
          }
          if (j == 3)
          {
            localSparseIntArray = this.down_ringProgress;
            localObject = this.down_ringStatus;
            break label787;
          }
          if (j != 7) {
            break label784;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onPushMsg resourceType = TYPE_PICTURE:");
          ((StringBuilder)localObject).append(j);
          QLog.d("VipFunCallJsPlugin", 1, ((StringBuilder)localObject).toString());
          localSparseIntArray = this.down_progress;
          localObject = this.down_status;
          break label787;
          int k = paramBundle.getInt("fcStatus");
          int m = paramBundle.getInt("callId");
          if (2 == k)
          {
            localSparseIntArray.put(m, paramBundle.getInt("progress"));
            ((SparseIntArray)localObject).put(m, 2);
            if (QLog.isColorLevel())
            {
              paramBundle = new StringBuilder();
              paramBundle.append("onProgress, id=");
              paramBundle.append(m);
              paramBundle.append(",srcType=");
              paramBundle.append(i);
              paramBundle.append(",resourceType=");
              paramBundle.append(j);
              paramBundle.append(",progress=");
              paramBundle.append(localSparseIntArray.get(m));
              QLog.d("VipFunCallJsPlugin", 2, paramBundle.toString());
            }
          }
          else if (3 == k)
          {
            boolean bool = paramBundle.getBoolean("result_boo", true);
            if (QLog.isColorLevel())
            {
              paramBundle = new StringBuilder();
              paramBundle.append("onDone, id=");
              paramBundle.append(m);
              paramBundle.append(",srcType=");
              paramBundle.append(i);
              paramBundle.append(",resourceType=");
              paramBundle.append(j);
              paramBundle.append(",result=");
              paramBundle.append(bool);
              QLog.d("VipFunCallJsPlugin", 2, paramBundle.toString());
            }
            if (bool)
            {
              localSparseIntArray.put(m, 100);
              ((SparseIntArray)localObject).put(m, 3);
              if (!TextUtils.isEmpty(str)) {
                super.callJs(str, new String[] { "{'result':0, 'message':'OK'}" });
              }
            }
            else
            {
              localSparseIntArray.put(m, 100);
              ((SparseIntArray)localObject).put(m, -4);
              if (!TextUtils.isEmpty(str)) {
                super.callJs(str, new String[] { "{'result':-4, 'message':'download Error'}" });
              }
            }
          }
          else if ((1 == k) && (QLog.isColorLevel()))
          {
            paramBundle = new StringBuilder();
            paramBundle.append("onStart, id=");
            paramBundle.append(m);
            paramBundle.append(",srcType=");
            paramBundle.append(i);
            paramBundle.append(",resourceType=");
            paramBundle.append(j);
            QLog.d("VipFunCallJsPlugin", 2, paramBundle.toString());
            return;
            paramBundle = new StringBuilder();
            paramBundle.append("onPushMsg Error0: resourceType=");
            paramBundle.append(j);
            QLog.e("VipFunCallJsPlugin", 1, paramBundle.toString());
          }
        }
        else if (i == 7)
        {
          i = paramBundle.getInt("result");
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("setMedia, result=");
            paramBundle.append(i);
            QLog.d("VipFunCallJsPlugin", 2, paramBundle.toString());
          }
          paramBundle = new JSONObject();
          if (i == 0) {}
          try
          {
            paramBundle.put("code", i);
            paramBundle.put("errorMessage", "sucess");
            continue;
            paramBundle.put("code", i);
            paramBundle.put("errorMessage", "set funcall err");
            if (!TextUtils.isEmpty(str))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("setMedia, callbackId=");
              ((StringBuilder)localObject).append(str);
              ((StringBuilder)localObject).append(", sid=");
              ((StringBuilder)localObject).append(this.SetFuncallCallBack);
              QLog.d("VipFunCallJsPlugin", 2, ((StringBuilder)localObject).toString());
            }
            callJs(this.SetFuncallCallBack, new String[] { paramBundle.toString() });
            return;
          }
          catch (JSONException paramBundle)
          {
            paramBundle.printStackTrace();
            return;
          }
        }
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
      label784:
      Object localObject = null;
      label787:
      if (localSparseIntArray != null) {
        if (localObject != null) {}
      }
    }
  }
  
  int testResStatus(int paramInt, String paramString1, SparseIntArray paramSparseIntArray1, SparseIntArray paramSparseIntArray2, String paramString2)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    int i = 3;
    if (bool)
    {
      paramSparseIntArray2.put(paramInt, 100);
      paramSparseIntArray1.put(paramInt, 3);
      int j = -2;
      i = j;
      if (QLog.isColorLevel())
      {
        paramSparseIntArray1 = new StringBuilder();
        paramSparseIntArray1.append("testResStatus path isEmpty, id=");
        paramSparseIntArray1.append(paramInt);
        paramSparseIntArray1.append(", path=");
        paramSparseIntArray1.append(paramString1);
        paramSparseIntArray1.append(", from=");
        paramSparseIntArray1.append(paramString2);
        paramSparseIntArray1.append(", local=");
        paramSparseIntArray1.append(-2);
        QLog.e("VipFunCallJsPlugin", 1, paramSparseIntArray1.toString());
        i = j;
      }
    }
    else
    {
      File localFile = new File(paramString1);
      if ((localFile.exists()) && (localFile.isFile()))
      {
        paramSparseIntArray2.put(paramInt, 100);
        paramSparseIntArray1.put(paramInt, 3);
      }
      else
      {
        paramSparseIntArray2.put(paramInt, 0);
        paramSparseIntArray1.put(paramInt, 1);
        i = 1;
      }
    }
    if (QLog.isColorLevel())
    {
      paramSparseIntArray1 = new StringBuilder();
      paramSparseIntArray1.append("testResStatus, id=");
      paramSparseIntArray1.append(paramInt);
      paramSparseIntArray1.append(", path=");
      paramSparseIntArray1.append(paramString1);
      paramSparseIntArray1.append(", from=");
      paramSparseIntArray1.append(paramString2);
      paramSparseIntArray1.append(", local=");
      paramSparseIntArray1.append(i);
      QLog.d("VipFunCallJsPlugin", 2, paramSparseIntArray1.toString());
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VipFunCallJsPlugin
 * JD-Core Version:    0.7.0.1
 */