import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.pubaccount.ecshopassit.RecentShopParcel;
import com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class oed
  extends WebViewPlugin
{
  public Bundle a;
  
  public oed()
  {
    this.mPluginNameSpace = "PublicAccountJs";
  }
  
  private int a(Map<String, String> paramMap, String paramString, int paramInt)
  {
    paramMap = (String)paramMap.get(paramString);
    int i = paramInt;
    if (!TextUtils.isEmpty(paramMap)) {}
    try
    {
      i = Integer.parseInt(paramMap);
      return i;
    }
    catch (Exception paramMap) {}
    return paramInt;
  }
  
  private String a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    paramMap = (String)paramMap.get(paramString1);
    if (paramMap == null) {
      return paramString2;
    }
    return paramMap;
  }
  
  private void a(String paramString)
  {
    paramString = bjnd.a(paramString);
    String str1 = a(paramString, "sub_action", "");
    String str2 = a(paramString, "action_name", "");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountWebviewPlugin", 2, "subAction[" + str1 + "] or actionName[" + str2 + "] null");
      }
      return;
    }
    bcef.b(null, a(paramString, "tag", "P_CliOper"), a(paramString, "main_action", "Pb_account_lifeservice"), a(paramString, "to_uin", ""), str1, str2, a(paramString, "from_type", 0), a(paramString, "result", 0), a(paramString, "r2", ""), a(paramString, "r3", ""), a(paramString, "r4", ""), a(paramString, "r5", ""));
  }
  
  protected void a(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!ardu.a().a())
    {
      if (paramBoolean2) {
        Toast.makeText(this.mRuntime.a().getApplicationContext(), amtj.a(2131707915), 0).show();
      }
      return;
    }
    if (paramBoolean1)
    {
      ardu.a().b(paramBundle);
      return;
    }
    ardu.a().a(paramBundle);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("setShopFolderMsg".equals(paramString3)) {}
    try
    {
      paramString1 = new JSONObject(paramVarArgs[0]);
      paramJsBridgeListener = paramString1.optString("msg");
      int i = paramString1.optInt("type");
      paramString1 = new Intent("action_folder_msg_change");
      paramString1.putExtra("msg", paramJsBridgeListener);
      paramString1.putExtra("type", i);
      this.mRuntime.a().sendBroadcast(paramString1);
      for (;;)
      {
        label75:
        return true;
        if ("onShopMsgClick".equals(paramString3))
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString1.optString("callback");
            paramString1 = paramString1.optString("uin");
            paramString2 = this.mRuntime.a();
            if ((!(paramString2 instanceof EcshopWebActivity)) || (TextUtils.isEmpty(paramJsBridgeListener))) {
              continue;
            }
            ((EcshopWebActivity)paramString2).a(paramString1);
            paramString1 = new JSONObject();
            paramString1.put("ret", 0);
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          catch (Exception paramJsBridgeListener) {}
        }
        else if ("getShopFirstMsg".equals(paramString3))
        {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("callback");
            paramString1 = this.mRuntime.a();
            if ((!(paramString1 instanceof EcshopWebActivity)) || (TextUtils.isEmpty(paramJsBridgeListener))) {
              continue;
            }
            paramString1 = (EcshopWebActivity)paramString1;
            paramString2 = new JSONObject();
            if ((paramString1.a != null) && (!paramString1.a.isEmpty()))
            {
              paramString3 = (RecentShopParcel)paramString1.a.get(0);
              paramVarArgs = new JSONObject();
              if ((paramString3 != null) && (paramString3.jdField_b_of_type_Int > 0) && (paramString3.jdField_a_of_type_Long >= paramString1.jdField_b_of_type_Long) && (paramString3.jdField_a_of_type_Long > paramString3.jdField_b_of_type_Long))
              {
                paramVarArgs.put("uin", paramString3.jdField_a_of_type_JavaLangString);
                paramVarArgs.put("msg", paramString3.d);
                paramVarArgs.put("nick", paramString3.jdField_b_of_type_JavaLangString);
                paramString2.put("data", paramVarArgs);
              }
            }
            callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
          }
          catch (Exception paramJsBridgeListener) {}
        }
        else if (TextUtils.equals("socialize_feeds_update", paramString3))
        {
          try
          {
            this.a.clear();
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString1.getString("feeds_id");
            paramString1 = paramString1.optString("feeds_type", "1");
            this.a.putLong("feeds_id", Long.valueOf(paramJsBridgeListener).longValue());
            this.a.putInt("feeds_type", Integer.valueOf(paramString1).intValue());
            a(aqyt.a("ipc_kandian_socialfeeds_update", "", -1, this.a), false, false);
          }
          catch (Exception paramJsBridgeListener)
          {
            QLog.d("PublicAccountWebviewPlugin", 1, "handle socialize_feeds_update response failed ", paramJsBridgeListener);
          }
        }
        else if ("toggleFolderList".equals(paramString3))
        {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
            i = paramJsBridgeListener.optInt("y_offset");
            boolean bool = paramJsBridgeListener.optBoolean("show_list");
            paramJsBridgeListener = this.mRuntime.a();
            if (!(paramJsBridgeListener instanceof EcshopWebActivity)) {
              continue;
            }
            paramJsBridgeListener = ((EcshopWebActivity)paramJsBridgeListener).a();
            if (!(paramJsBridgeListener instanceof ShopWebViewFragment)) {
              continue;
            }
            if (!bool) {
              break label616;
            }
            ((ShopWebViewFragment)paramJsBridgeListener).a(1, i);
          }
          catch (Exception paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
          continue;
          label616:
          ((ShopWebViewFragment)paramJsBridgeListener).a(0, 0);
        }
        else if ("showRedDot".equals(paramString3))
        {
          try
          {
            i = new JSONObject(paramVarArgs[0]).optInt("reddot");
            paramJsBridgeListener = this.mRuntime.a();
            if (!(paramJsBridgeListener instanceof EcshopWebActivity)) {
              continue;
            }
            paramJsBridgeListener = ((EcshopWebActivity)paramJsBridgeListener).a();
            if (!(paramJsBridgeListener instanceof ShopWebViewFragment)) {
              continue;
            }
            ((ShopWebViewFragment)paramJsBridgeListener).a(i);
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        else if ("getShopPushInfo".equals(paramString3))
        {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("callback");
            paramString1 = this.mRuntime.a();
            if ((paramString1 instanceof EcshopWebActivity))
            {
              paramString1 = paramString1.getIntent().getBundleExtra("bundle");
              paramString2 = new JSONObject();
              paramString2.put("taskId", paramString1.getInt("PUSH_TASK_ID"));
              paramString2.put("folderMsg", paramString1.getString("str_ecshop_diy"));
              paramString2.put("taskType", paramString1.getInt("PUSH_TASK_TYPE"));
              paramString2.put("taskInfo", paramString1.getString("PUSH_TASK_INFO"));
              paramString2.put("receiveTs", paramString1.getLong("PUSH_RECEIVE_TIME"));
              callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
            }
          }
          catch (Exception paramJsBridgeListener)
          {
            QLog.e("PublicAccountWebviewPlugin", 1, "getShopPushInfo error:", paramJsBridgeListener);
          }
        }
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      break label75;
    }
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString2))
    {
      bool1 = bool2;
      if (paramString2.equals("publicaccount"))
      {
        bool1 = bool2;
        if (paramString1 != null)
        {
          bool1 = bool2;
          if (paramString1.contains("/report?"))
          {
            a(paramString1);
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.a = new Bundle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oed
 * JD-Core Version:    0.7.0.1
 */