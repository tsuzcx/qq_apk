package com.tencent.mobileqq.profile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.activity.FriendProfilePicBrowserActivity;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HistoryHeadWebViewPlugin
  extends VasWebviewJsPlugin
{
  protected String a;
  protected String b;
  private boolean c = false;
  
  public HistoryHeadWebViewPlugin()
  {
    this.mPluginNameSpace = "historyhead";
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, ArrayList<PicInfo> paramArrayList, ArrayList<String> paramArrayList1, boolean paramBoolean, String paramString, int paramInt3)
  {
    Intent localIntent = new Intent(paramActivity, FriendProfilePicBrowserActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", paramInt1);
    localBundle.putInt("fromType", paramInt2);
    if (paramArrayList != null) {
      localBundle.putParcelableArrayList("picInfos", paramArrayList);
    }
    if (paramArrayList1 != null) {
      localBundle.putStringArrayList("fileIdList", paramArrayList1);
    }
    localBundle.putBoolean("IS_EDIT", false);
    localBundle.putBoolean("is_use_path", true);
    localBundle.putBoolean("is_show_action", true);
    localBundle.putBoolean("is_not_show_index", paramBoolean);
    if (!TextUtils.isEmpty(paramString)) {
      localBundle.putString("src_id", paramString);
    }
    localIntent.putExtras(localBundle);
    paramActivity.startActivityForResult(localIntent, paramInt3);
  }
  
  protected void a(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.a = paramString.optString("setName");
        this.b = paramString.optString("delName");
        localObject3 = paramString.optJSONArray("imageIDs");
        Object localObject2 = paramString.optJSONArray("str_fileids");
        k = paramString.optInt("index");
        str = paramString.optString("srcID");
        m = paramString.optInt("fromType");
        bool = paramString.optBoolean("isNotShowIndex", true);
        if (this.mRuntime.a() == null) {
          return;
        }
        if (this.mRuntime.b() == null) {
          return;
        }
        localObject1 = this.mRuntime.d();
        if (localObject1 == null) {
          return;
        }
        paramString = (String)localObject1;
        if ((localObject1 instanceof BasePluginActivity)) {
          paramString = ((BasePluginActivity)localObject1).getOutActivity();
        }
        localObject1 = new ArrayList();
        int j = 0;
        int n;
        if (localObject3 != null)
        {
          n = ((JSONArray)localObject3).length();
          i = 0;
          if (i < n)
          {
            PicInfo localPicInfo = new PicInfo();
            localPicInfo.b = ((JSONArray)localObject3).get(i).toString();
            localPicInfo.h = "type_history_head_pic";
            ((ArrayList)localObject1).add(localPicInfo);
            i += 1;
            continue;
          }
        }
        localObject3 = new ArrayList();
        if (localObject2 != null)
        {
          n = ((JSONArray)localObject2).length();
          i = j;
          if (i < n)
          {
            ((ArrayList)localObject3).add(((JSONArray)localObject2).get(i).toString());
            i += 1;
            continue;
          }
        }
        localObject2 = this.mRuntime.f();
        if ((paramString instanceof WebViewPluginContainer))
        {
          i = ((WebViewPluginContainer)paramString).switchRequestCode(this, (byte)100);
        }
        else
        {
          if (localObject2 == null) {
            break label336;
          }
          i = ((WebViewProvider)localObject2).switchRequestCode(this, (byte)100);
        }
      }
      catch (JSONException paramString)
      {
        Object localObject3;
        int k;
        String str;
        int m;
        boolean bool;
        Object localObject1;
        return;
      }
      a(paramString, k, m, (ArrayList)localObject1, (ArrayList)localObject3, bool, str, i);
      return;
      continue;
      label336:
      int i = 100;
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("historyhead".equals(paramString2)) && ("showPicture".equals(paramString3)) && (paramVarArgs.length == 1)) {
      a(paramVarArgs[0]);
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if ((paramByte == 100) && (paramInt == -1))
    {
      if (this.mRuntime.a() == null) {
        return;
      }
      if (paramIntent != null) {
        if ((paramIntent.hasExtra("setHead_fileid")) && (!TextUtils.isEmpty(this.a)))
        {
          paramIntent = paramIntent.getStringExtra("setHead_fileid");
          if (!TextUtils.isEmpty(paramIntent)) {
            callJs(this.a, new String[] { Util.c(paramIntent) });
          }
        }
        else if ((paramIntent.hasExtra("delHead_fileid")) && (!TextUtils.isEmpty(this.b)))
        {
          paramIntent = paramIntent.getStringExtra("delHead_fileid");
          if (!TextUtils.isEmpty(paramIntent))
          {
            callJs(this.b, new String[] { Util.c(paramIntent) });
            this.c = true;
          }
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    if (this.c)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("hasHistoryHeadDel", this.c);
      super.sendRemoteReq(DataFactory.a("ipc_cmd_historyhead_refresh_numflag", "", 0, localBundle), false, true);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.HistoryHeadWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */