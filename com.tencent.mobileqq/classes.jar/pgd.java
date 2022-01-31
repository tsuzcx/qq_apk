import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.NewerGuidePlugin;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class pgd
  extends Client.onRemoteRespObserver
{
  public pgd(NewerGuidePlugin paramNewerGuidePlugin) {}
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == NewerGuidePlugin.a(this.a).key) && ("ipc_newer_guide".equals(paramBundle.getString("cmd"))))
    {
      localObject3 = paramBundle.getBundle("request");
      paramBundle = ((Bundle)localObject3).getString("key_action");
      if (QLog.isColorLevel()) {
        QLog.d("NewerGuidePlugin", 2, "onResponse action=" + paramBundle);
      }
    }
    for (;;)
    {
      try
      {
        if ("getRecommendedList".equals(paramBundle))
        {
          paramBundle = new JSONObject();
          localObject2 = ((Bundle)localObject3).getString("op_result");
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            paramBundle.put("result", new JSONArray((String)localObject2));
          }
          this.a.callJs("respRecommend", new String[] { paramBundle.toString() });
          paramBundle = null;
          if ((paramBundle != null) && (localObject1 != null))
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("uin", paramBundle);
            ((JSONObject)localObject2).put("result", 0);
            this.a.callJs((String)localObject1, new String[] { ((JSONObject)localObject2).toString() });
          }
        }
        else
        {
          String str;
          if ("sayHi".equals(paramBundle))
          {
            paramBundle = ((Bundle)localObject3).getString("uin");
            localObject1 = ((Bundle)localObject3).getByteArray("sig");
            str = ((Bundle)localObject3).getString("nick");
            localObject3 = ((Bundle)localObject3).getString("tinyId");
            if ((!TextUtils.isEmpty(paramBundle)) && (localObject1 != null) && (!TextUtils.isEmpty(str)))
            {
              Intent localIntent = new Intent(this.a.mRuntime.a(), ChatActivity.class);
              localIntent.addFlags(67108864);
              localIntent.putExtra("uin", paramBundle);
              localIntent.putExtra("uintype", 1001);
              localIntent.putExtra("aio_msg_source", 999);
              localIntent.putExtra("rich_accost_sig", (byte[])localObject1);
              localIntent.putExtra("uinname", str);
              localIntent.putExtra("from_newer_guide", true);
              localIntent.putExtra("tinyId", (String)localObject3);
              this.a.startActivityForResult(localIntent, (byte)8);
              paramBundle = null;
              localObject1 = localObject2;
              break label707;
            }
            localObject1 = String.valueOf(localObject3);
            paramBundle = "respSayHi";
            break label707;
          }
          if ("joinTroop".equals(paramBundle))
          {
            paramBundle = ((Bundle)localObject3).getString("uin");
            localObject2 = ((Bundle)localObject3).getString("name");
            short s = ((Bundle)localObject3).getShort("option");
            str = ((Bundle)localObject3).getString("question");
            localObject3 = ((Bundle)localObject3).getString("answer");
            if (s == 0) {
              break label720;
            }
            paramBundle = AddFriendLogicActivity.a(this.a.mRuntime.a(), paramBundle, (String)localObject2, s, 1, str, (String)localObject3, null, null);
            paramBundle.putExtra("from_newer_guide", true);
            this.a.startActivityForResult(paramBundle, (byte)6);
            paramBundle = null;
            continue;
          }
          if ("followPublicAccount".equals(paramBundle))
          {
            i = ((Bundle)localObject3).getInt("result");
            paramBundle = ((Bundle)localObject3).getString("uin");
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("uin", paramBundle);
            ((JSONObject)localObject2).put("result", i);
            this.a.callJs("respFollow", new String[] { ((JSONObject)localObject2).toString() });
            paramBundle = null;
            continue;
          }
          if (!"setAvatar".equals(paramBundle)) {
            break label728;
          }
          if (((Bundle)localObject3).getInt("result") == 1)
          {
            paramBundle = ((Bundle)localObject3).getString("path");
            NewerGuidePlugin.a(this.a, true, paramBundle);
            if (NewerGuidePlugin.a(this.a) == null) {
              break label728;
            }
            NewerGuidePlugin.a(this.a).dismiss();
            break label728;
          }
          paramBundle = this.a.mRuntime.a();
          int i = paramBundle.getResources().getDimensionPixelSize(2131558448);
          QQToast.a(paramBundle, 1, "更换头像失败", 0).b(i);
          continue;
        }
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.d("NewerGuidePlugin", 1, "mOnRemoteResp fail", paramBundle);
      }
      label707:
      localObject2 = paramBundle;
      paramBundle = (Bundle)localObject1;
      localObject1 = localObject2;
      continue;
      label720:
      localObject1 = "respTroop";
      continue;
      label728:
      paramBundle = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pgd
 * JD-Core Version:    0.7.0.1
 */