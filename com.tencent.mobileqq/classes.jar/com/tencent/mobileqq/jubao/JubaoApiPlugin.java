package com.tencent.mobileqq.jubao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.mini.sdk.JsonORM;
import com.tencent.mobileqq.mini.sdk.JsonORM.JsonParseException;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JubaoApiPlugin
  extends WebViewPlugin
{
  private String a;
  private String b;
  private String c;
  private final String d = "0x800A851";
  private String e = HardCodeUtil.a(2131903845);
  
  public JubaoApiPlugin()
  {
    this.mPluginNameSpace = "jubao";
  }
  
  public static String a(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", paramInt);
      localJSONObject.put("uuid", paramString);
    }
    catch (JSONException paramString)
    {
      QLog.e("jubaoApiPlugin", 1, paramString, new Object[0]);
    }
    return localJSONObject.toString();
  }
  
  private String a(String paramString)
  {
    Object localObject1 = this.c;
    if (localObject1 == null) {
      return "";
    }
    localObject1 = ((String)localObject1).split("&");
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2.startsWith(paramString)) {
        return localObject2.split("=")[1];
      }
      i += 1;
    }
    return "";
  }
  
  public static String a(ArrayList<ChatMessage> paramArrayList)
  {
    int i = paramArrayList.size();
    String str = a(paramArrayList);
    paramArrayList = new JSONObject();
    try
    {
      paramArrayList.put("msgcount", i);
      paramArrayList.put("msgs", str);
    }
    catch (JSONException localJSONException)
    {
      QLog.e("jubaoApiPlugin", 1, localJSONException, new Object[0]);
    }
    return paramArrayList.toString();
  }
  
  public static String a(List<ChatMessage> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        JubaoMsgData localJubaoMsgData = JubaoMsgData.transfer((ChatMessage)paramList.next());
        try
        {
          localJSONArray.put(localJubaoMsgData.toJson());
        }
        catch (JsonORM.JsonParseException localJsonParseException)
        {
          QLog.e("jubaoApiPlugin", 1, localJsonParseException, new Object[0]);
        }
      }
      return localJSONArray.toString();
    }
    return "";
  }
  
  private void a(String... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    if (TextUtils.isEmpty(paramVarArgs)) {
      return;
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject3 = new JSONObject(paramVarArgs);
        Object localObject1 = ((JSONObject)localObject3).optString("chatuin", "");
        localObject2 = ((JSONObject)localObject3).optString("groupcode", "");
        int j = ((JSONObject)localObject3).optInt("chattype", 0);
        int k = ((JSONObject)localObject3).optInt("topicid", 0);
        String str = ((JSONObject)localObject3).optString("uinname", "");
        Object localObject4 = ((JSONObject)localObject3).optString("msgs");
        paramVarArgs = (String[])localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramVarArgs = NewReportPlugin.c((String)localObject1, NewReportPlugin.c(1));
        }
        if (TextUtils.isEmpty(str)) {
          break label531;
        }
        str = new String(Base64.decode(str, 0));
        if (QLog.isColorLevel()) {
          QLog.i("NewReportPlugin", 2, String.format("jumpChatMsg [%s, %s, %s, %s, %s]", new Object[] { paramVarArgs, Integer.valueOf(j), localObject2, Integer.valueOf(k), str }));
        }
        this.c = new String(this.mRuntime.d().getIntent().getByteArrayExtra("SafeReportData"));
        localObject1 = null;
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject4 = (JubaoMsgData[])JsonORM.parseFrom(new JSONArray((String)localObject4), JubaoMsgData.class);
          localObject1 = new ArrayList();
          int m = localObject4.length;
          int i = 0;
          if (i >= m) {
            break label534;
          }
          ((ArrayList)localObject1).add(localObject4[i]);
          i += 1;
          continue;
        }
        this.a = ((JSONObject)localObject3).optString("callback", "");
        if ((j == 1) || (j == 3000)) {
          break label537;
        }
        if (TextUtils.isEmpty(paramVarArgs))
        {
          QLog.d("jubaoApiPlugin", 1, "jumpChatMsg openChatUin is null");
          return;
        }
        localObject2 = new Intent(this.mRuntime.d(), ChatActivity.class);
        if (j == 10007)
        {
          localObject3 = a("friendroleid");
          localObject4 = a("myroleid");
          ((Intent)localObject2).putExtra("game_msg_friend_role_id", (String)localObject3);
          ((Intent)localObject2).putExtra("game_msg_my_role_id", (String)localObject4);
        }
        ((Intent)localObject2).putExtra("uin", paramVarArgs);
        ((Intent)localObject2).putExtra("uintype", j);
        if (!TextUtils.isEmpty(str)) {
          if ((j != 1033) && (j != 1034)) {
            ((Intent)localObject2).putExtra("uinname", str);
          } else {
            ((Intent)localObject2).putExtra("key_confessor_nick", str);
          }
        }
        ((Intent)localObject2).putExtra("key_confess_topicid", k);
        if (localObject1 != null) {
          ((Intent)localObject2).putExtra("msgs", (Serializable)localObject1);
        }
        ((Intent)localObject2).putExtra("entrance", 9);
        try
        {
          startActivityForResult((Intent)localObject2, (byte)0);
          return;
        }
        catch (JsonORM.JsonParseException paramVarArgs) {}catch (JSONException paramVarArgs) {}
        QLog.e("jubaoApiPlugin", 1, paramVarArgs, new Object[0]);
      }
      catch (JsonORM.JsonParseException paramVarArgs)
      {
        QLog.e("jubaoApiPlugin", 1, paramVarArgs, new Object[0]);
        return;
      }
      catch (JSONException paramVarArgs) {}
      return;
      label531:
      continue;
      label534:
      continue;
      label537:
      paramVarArgs = (String[])localObject2;
    }
  }
  
  private void b(String... paramVarArgs)
  {
    if (!NetworkUtil.isNetworkAvailable(this.mRuntime.d()))
    {
      paramVarArgs = a(5, "");
      callJs(this.b, new String[] { paramVarArgs });
      return;
    }
    paramVarArgs = paramVarArgs[0];
    if (TextUtils.isEmpty(paramVarArgs))
    {
      paramVarArgs = a(0, "");
      callJs(this.b, new String[] { paramVarArgs });
      QLog.d("jubaoApiPlugin", 1, "doUploadChatMsg js args is empty ");
      return;
    }
    try
    {
      Object localObject2 = new JSONObject(paramVarArgs);
      String str1 = ((JSONObject)localObject2).optString("eviluin", "");
      localObject1 = ((JSONObject)localObject2).optString("chatuin", "");
      String str2 = ((JSONObject)localObject2).optString("groupcode", "");
      int j = ((JSONObject)localObject2).optInt("chattype", 0);
      paramVarArgs = (String[])localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramVarArgs = NewReportPlugin.c((String)localObject1, NewReportPlugin.c(1));
      }
      JubaoMsgData[] arrayOfJubaoMsgData = (JubaoMsgData[])JsonORM.parseFrom(new JSONArray(((JSONObject)localObject2).optString("msgs")), JubaoMsgData.class);
      localObject1 = new ArrayList();
      int k = arrayOfJubaoMsgData.length;
      int i = 0;
      while (i < k)
      {
        ((ArrayList)localObject1).add(arrayOfJubaoMsgData[i]);
        i += 1;
      }
      this.b = ((JSONObject)localObject2).optString("callback", "");
      if (((ArrayList)localObject1).size() == 0)
      {
        QLog.e("jubaoApiPlugin", 2, "ipc upload  to msgServer msg size = 0 ");
        paramVarArgs = a(1, "");
        localObject1 = this.b;
        callJs((String)localObject1, new String[] { paramVarArgs });
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("ipc upload  msg size = ");
        ((StringBuilder)localObject2).append(((ArrayList)localObject1).size());
        QLog.d("jubaoApiPlugin", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("jubao_evil_uin", str1);
      ((Bundle)localObject2).putString("jubao_chat_uin", paramVarArgs);
      ((Bundle)localObject2).putString("jubao_group_code", str2);
      ((Bundle)localObject2).putInt("jubao_chat_type", j);
      ((Bundle)localObject2).putSerializable("jubao_msg_list", (Serializable)localObject1);
      if (j == 10007)
      {
        paramVarArgs = a("jubao_game_sig");
        ((Bundle)localObject2).putString("jubao_game_sig", paramVarArgs);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("gameSig = ");
          ((StringBuilder)localObject1).append(paramVarArgs);
          QLog.i("jubaoApiPlugin", 2, ((StringBuilder)localObject1).toString());
        }
      }
      QIPCClientHelper.getInstance().callServer("JubaoIPCServer", "", (Bundle)localObject2, new JubaoApiPlugin.1(this));
      ReportController.b(null, "dc00898", "", "", "0x800A851", "0x800A851", 2, 0, "", "", "", "");
      return;
    }
    catch (JsonORM.JsonParseException paramVarArgs)
    {
      localObject1 = a(2, "");
      callJs(this.b, new String[] { localObject1 });
      QLog.e("jubaoApiPlugin", 1, paramVarArgs, new Object[0]);
      return;
    }
    catch (JSONException paramVarArgs)
    {
      Object localObject1 = a(2, "");
      callJs(this.b, new String[] { localObject1 });
      QLog.e("jubaoApiPlugin", 1, paramVarArgs, new Object[0]);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("receiver msgServer resp  isSucesss =  ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.e("jubaoApiPlugin", 2, ((StringBuilder)localObject).toString());
    ReportController.b(null, "dc00898", "", "", "0x800A851", "0x800A851", 3, 0, "", "", "", "");
    int i = 1;
    if (paramInt == 0)
    {
      if ((paramBoolean) && (paramBundle != null))
      {
        localObject = paramBundle.getString("jubao_uuid");
        paramInt = paramBundle.getInt("jubao_result_code", 0);
        i = 0;
        paramBundle = (Bundle)localObject;
      }
      else
      {
        if (paramBundle != null) {
          paramInt = paramBundle.getInt("jubao_result_code", 1);
        } else {
          paramInt = 0;
        }
        paramBundle = "";
        i = 1;
      }
      localObject = a(paramInt, paramBundle);
      callJs(this.b, new String[] { localObject });
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("upload resp uuid = ");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append(",result = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("jubaoApiPlugin", 1, ((StringBuilder)localObject).toString());
    }
    else
    {
      paramInt = 0;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("");
    paramBundle.append(i);
    paramBundle = paramBundle.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramInt);
    ReportController.b(null, "dc00898", "", "", "0x800A851", "0x800A851", 2, 0, paramBundle, ((StringBuilder)localObject).toString(), "", "");
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    if (paramString != null)
    {
      String str = this.b;
      if ((str != null) && (paramString.equals(str))) {
        ReportController.b(null, "dc00898", "", "", "0x800A851", "0x800A851", 4, 0, "", "", "", "");
      }
    }
    super.callJs(paramString, paramVarArgs);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleJsRequest methodName= ");
    localStringBuilder.append(paramString3);
    QLog.d("jubaoApiPlugin", 1, localStringBuilder.toString());
    if ("jubao".equals(paramString2))
    {
      boolean bool = "selectMsgs".equalsIgnoreCase(paramString3);
      int i = 0;
      if (bool)
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0))
        {
          paramJsBridgeListener = (InputMethodManager)this.mRuntime.d().getSystemService("input_method");
          if (paramJsBridgeListener != null) {
            paramJsBridgeListener.hideSoftInputFromWindow(this.mRuntime.d().getWindow().getDecorView().getWindowToken(), 0);
          }
          a(paramVarArgs);
          paramJsBridgeListener = new StringBuilder();
          paramJsBridgeListener.append("");
          paramJsBridgeListener.append(0);
          ReportController.b(null, "dc00898", "", "", "0x800A851", "0x800A851", 0, 0, paramJsBridgeListener.toString(), "", "", "");
        }
        return true;
      }
      if ("uploadMsgs".equalsIgnoreCase(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          b(new String[] { paramVarArgs[0] });
        } else {
          i = 1;
        }
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append("");
        paramJsBridgeListener.append(i);
        ReportController.b(null, "dc00898", "", "", "0x800A851", "0x800A851", 1, 0, paramJsBridgeListener.toString(), "", "", "");
        return true;
      }
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    QLog.d("jubaoApiPlugin", 1, "onActivityResult ");
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 0)
    {
      if (paramInt == -1)
      {
        paramIntent = paramIntent.getStringExtra("msgs");
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onActivityResult msgs= ");
          localStringBuilder.append(paramIntent);
          QLog.d("jubaoApiPlugin", 4, localStringBuilder.toString());
        }
        callJs(this.a, new String[] { paramIntent });
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("jubaoApiPlugin", 2, "onActivityResult user cancel select msg = ");
      }
    }
  }
  
  public void startActivityForResult(Intent paramIntent, byte paramByte)
  {
    QLog.e("jubaoApiPlugin", 1, "startActivityForResult ");
    super.startActivityForResult(paramIntent, paramByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jubao.JubaoApiPlugin
 * JD-Core Version:    0.7.0.1
 */