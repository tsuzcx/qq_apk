import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import org.json.JSONException;
import org.json.JSONObject;

public class npt
  extends WebViewPlugin
{
  aasb jdField_a_of_type_Aasb = null;
  public anui a;
  bhpc jdField_a_of_type_Bhpc;
  String jdField_a_of_type_JavaLangString = null;
  bhpc b = null;
  
  public npt()
  {
    this.jdField_a_of_type_Anui = new npu(this);
    this.mPluginNameSpace = "lebaPlugin";
  }
  
  private void a(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if ((this.mRuntime.a() == null) || (this.mRuntime.a().isFinishing())) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Bhpc == null) {
        this.jdField_a_of_type_Bhpc = Utils.createPluginSetDialogForWeb(this.mRuntime.a(), this.jdField_a_of_type_Aasb, this.jdField_a_of_type_Anui, paramInt, paramLong, paramString1, paramString2);
      }
    } while (this.jdField_a_of_type_Bhpc.isShowing());
    this.jdField_a_of_type_Bhpc.show();
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramJsBridgeListener = paramVarArgs[0];
    if (paramString3 == null) {
      return false;
    }
    if (paramString3.equals("showOpenDialog")) {}
    for (;;)
    {
      long l;
      try
      {
        paramString1 = new JSONObject(paramJsBridgeListener);
        l = paramString1.optLong("id", -1L);
        paramJsBridgeListener = paramString1.optString("msg");
        paramString1 = paramString1.optString("callback");
        if (l != -1L)
        {
          paramString2 = new Bundle();
          paramString2.putInt("reqCode", 10000);
          paramString2.putLong("uiResId", l);
          paramString2.putString("msg", paramJsBridgeListener);
          paramString2.putString("callback", paramString1);
          paramString2.putInt("dialogType", 1);
          this.jdField_a_of_type_Aasb.a(18, paramString2, this.jdField_a_of_type_Anui);
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        continue;
      }
      return true;
      if (paramString3.equals("getPluginStatus")) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramJsBridgeListener);
          l = paramJsBridgeListener.optLong("id", -1L);
          paramJsBridgeListener = paramJsBridgeListener.optString("callback");
          if (l == -1L) {
            continue;
          }
          paramString1 = new Bundle();
          paramString1.putInt("reqCode", 10002);
          paramString1.putLong("uiResId", l);
          paramString1.putString("callback", paramJsBridgeListener);
          this.jdField_a_of_type_Aasb.a(18, paramString1, this.jdField_a_of_type_Anui);
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      } else if (paramString3.equals("search")) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramJsBridgeListener).optString("keyWord");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            if (this.mRuntime.a() != null) {}
            bcni.a("hot_list", "clk_hot_list", new String[] { paramJsBridgeListener });
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_Aasb = aasb.a();
    this.jdField_a_of_type_Aasb.a();
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Aasb != null) {
      this.jdField_a_of_type_Aasb.b();
    }
    if ((this.jdField_a_of_type_Bhpc != null) && (this.jdField_a_of_type_Bhpc.isShowing())) {
      this.jdField_a_of_type_Bhpc.dismiss();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     npt
 * JD-Core Version:    0.7.0.1
 */