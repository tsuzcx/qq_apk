import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyMessagesActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.math.BigInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class pcf
  extends WebViewPlugin
{
  public Bundle a;
  private String jdField_a_of_type_JavaLangString;
  shh jdField_a_of_type_Shh;
  wxr jdField_a_of_type_Wxr = null;
  
  public pcf()
  {
    this.mPluginNameSpace = "readinjoy";
  }
  
  private void b()
  {
    Intent localIntent = new Intent(this.mRuntime.a(), ReadInJoyMessagesActivity.class);
    localIntent.setFlags(67108864);
    startActivityForResult(localIntent, (byte)0);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyWebviewPlugin", 2, "do updateSocialFeedsInfo all");
    }
    this.jdField_a_of_type_AndroidOsBundle.putLong("feeds_id", -1L);
    this.jdField_a_of_type_AndroidOsBundle.putLong("feeds_type", 1L);
    a(anqu.a("ipc_kandian_socialfeeds_update", "", 0, this.jdField_a_of_type_AndroidOsBundle), false, false);
  }
  
  protected void a(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!anvq.a().a())
    {
      if (paramBoolean2) {
        Toast.makeText(this.mRuntime.a().getApplicationContext(), ajya.a(2131712827), 0).show();
      }
      return;
    }
    if (paramBoolean1)
    {
      anvq.a().b(paramBundle);
      return;
    }
    anvq.a().a(paramBundle);
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    super.callJs(paramString, paramVarArgs);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyWebviewPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"readinjoy".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    if ("showShareReadInJoyMenu".equals(paramString3))
    {
      if (this.jdField_a_of_type_Shh == null) {
        this.jdField_a_of_type_Shh = new shh(this, this.jdField_a_of_type_Wxr);
      }
      if (paramVarArgs == null) {
        return false;
      }
      this.jdField_a_of_type_Shh.a(paramVarArgs[0]);
    }
    for (;;)
    {
      return true;
      paramVarArgs = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (paramVarArgs == null) {
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyWebviewPlugin", 2, "handleJsRequest JSON = " + paramVarArgs.toString());
      }
      long l1;
      int i;
      if ((TextUtils.equals("socialize_feeds_update", paramString3)) || (TextUtils.equals("openPrivateLetter", paramString3)))
      {
        paramJsBridgeListener = null;
        try
        {
          paramString1 = paramVarArgs.optString("callback");
          if (paramString1 == null)
          {
            paramJsBridgeListener = paramString1;
            throw new Exception("need callback");
          }
        }
        catch (Exception paramString1)
        {
          if (QLog.isColorLevel())
          {
            paramString1.printStackTrace();
            QLog.e("ReadInJoyWebviewPlugin", 2, paramString1.getMessage());
          }
        }
        try
        {
          paramString2 = new JSONObject();
          paramString2.put("result", 1);
          paramString2.put("msg", paramString1.getMessage());
          super.callJs(paramJsBridgeListener + "(" + paramString2.toString() + ");");
          for (;;)
          {
            return true;
            paramJsBridgeListener = paramString1;
            if (TextUtils.equals("socialize_feeds_update", paramString3))
            {
              paramJsBridgeListener = paramString1;
              this.jdField_a_of_type_AndroidOsBundle.clear();
              paramJsBridgeListener = paramString1;
              l1 = new BigInteger(paramVarArgs.getString("feeds_id")).longValue();
              paramJsBridgeListener = paramString1;
              this.jdField_a_of_type_AndroidOsBundle.putLong("feeds_id", Long.valueOf(l1).longValue());
              paramJsBridgeListener = paramString1;
              i = paramVarArgs.optInt("feeds_type", 1);
              paramJsBridgeListener = paramString1;
              this.jdField_a_of_type_AndroidOsBundle.putInt("feeds_type", Integer.valueOf(i).intValue());
              paramJsBridgeListener = paramString1;
              a(anqu.a("ipc_kandian_socialfeeds_update", paramString1, 0, this.jdField_a_of_type_AndroidOsBundle), false, false);
            }
            else
            {
              paramJsBridgeListener = paramString1;
              if (TextUtils.equals("openPrivateLetter", paramString3))
              {
                paramJsBridgeListener = paramString1;
                this.jdField_a_of_type_JavaLangString = paramString1;
                paramJsBridgeListener = paramString1;
                b();
              }
            }
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("ReadInJoyWebviewPlugin", 2, paramString1.getMessage());
            }
          }
        }
      }
      if ("readSkinAndSound".equals(paramString3))
      {
        paramJsBridgeListener = null;
        try
        {
          paramString1 = paramVarArgs.getString("callback");
          paramJsBridgeListener = paramString1;
          this.jdField_a_of_type_Wxr.i(new pcg(this, paramString1));
        }
        catch (JSONException paramString1)
        {
          QLog.w("ReadInJoyWebviewPlugin", 1, "readSkinAndSound error " + paramString1.toString());
          callJs(paramJsBridgeListener, new String[] { "{\"retCode\":-1}" });
        }
      }
      else if ("notifyLoadSkin".equals(paramString3))
      {
        paramString2 = null;
      }
      try
      {
        paramString1 = paramVarArgs.getString("callback");
        try
        {
          paramJsBridgeListener = paramVarArgs.getString("skinId");
          paramString2 = paramVarArgs.getString("skinUrl");
          paramString3 = paramVarArgs.getString("skinName");
          l1 = paramVarArgs.getLong("seq");
          l2 = paramVarArgs.getLong("startTime");
          l3 = paramVarArgs.getLong("endTime");
          this.jdField_a_of_type_Wxr.a(paramJsBridgeListener, l1, paramString2, paramString3, l2, l3, new pch(this, paramString1));
          QLog.d("ReadInJoyWebviewPlugin", 4, "send notifyLoadSkin cmd to service");
        }
        catch (JSONException paramJsBridgeListener) {}
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          long l2;
          long l3;
          paramString1 = paramString2;
        }
      }
      QLog.w("ReadInJoyWebviewPlugin", 1, "notifyLoadSkin error " + paramJsBridgeListener.toString());
      callJs(paramString1, new String[] { "{\"retCode\":-1}" });
      continue;
      if ("cancelLoadSkin".equals(paramString3))
      {
        paramJsBridgeListener = null;
        try
        {
          paramString2 = paramVarArgs.getString("callback");
          paramJsBridgeListener = paramString2;
          paramString3 = paramVarArgs.getString("skinId");
          paramString1 = "";
          paramJsBridgeListener = paramString2;
          if (paramVarArgs.has("skinUrl"))
          {
            paramJsBridgeListener = paramString2;
            paramString1 = paramVarArgs.optString("skinUrl");
          }
          paramJsBridgeListener = paramString2;
          this.jdField_a_of_type_Wxr.e(paramString3, paramString1, new pci(this, paramString2));
          paramJsBridgeListener = paramString2;
          QLog.d("ReadInJoyWebviewPlugin", 4, "send cancelLoadSkin cmd to service");
        }
        catch (Exception paramString1)
        {
          QLog.w("ReadInJoyWebviewPlugin", 1, "cancelLoadSkin error " + paramString1.toString());
          callJs(paramJsBridgeListener, new String[] { "{\"retCode\":-1}" });
        }
      }
      else if ("setSkinAndSound".equals(paramString3))
      {
        paramString1 = null;
      }
      try
      {
        paramString2 = paramVarArgs.getString("callback");
      }
      catch (Exception paramJsBridgeListener)
      {
        label1078:
        break label1078;
      }
      try
      {
        paramString3 = paramVarArgs.getString("skinId");
        paramJsBridgeListener = "";
        if (paramVarArgs.has("skinUrl")) {
          paramJsBridgeListener = paramVarArgs.optString("skinUrl");
        }
        paramString1 = "";
        if (paramVarArgs.has("skinName")) {
          paramString1 = paramVarArgs.optString("skinName");
        }
        l1 = 0L;
        if (paramVarArgs.has("seq")) {
          l1 = paramVarArgs.optLong("seq");
        }
        l2 = 0L;
        if (paramVarArgs.has("startTime")) {
          l2 = paramVarArgs.optLong("startTime");
        }
        l3 = 0L;
        if (paramVarArgs.has("endTime")) {
          l3 = paramVarArgs.optLong("endTime");
        }
        i = 0;
        if (paramVarArgs.has("volumeIsOn")) {
          i = paramVarArgs.optInt("volumeIsOn");
        }
        this.jdField_a_of_type_Wxr.a(paramString3, l1, paramJsBridgeListener, paramString1, l2, l3, i, new pcj(this, paramString2));
        QLog.d("ReadInJoyWebviewPlugin", 4, "send set skin cmd to service");
      }
      catch (Exception paramJsBridgeListener)
      {
        paramString1 = paramString2;
        QLog.w("ReadInJoyWebviewPlugin", 1, "setSkinAndSound error " + paramJsBridgeListener.toString());
        callJs(paramString1, new String[] { "{\"retCode\":-1}" });
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    Log.d("ReadInJoyWebviewPlugin", "onActivityResult()");
    if ((paramByte == 0) && (paramIntent != null))
    {
      paramInt = paramIntent.getIntExtra("extra_private_letter_count", 0);
      callJs(this.jdField_a_of_type_JavaLangString, new String[] { Integer.toString(paramInt) });
    }
    while (((paramByte != 1) && (paramByte != 2)) || (this.jdField_a_of_type_Shh == null)) {
      return;
    }
    this.jdField_a_of_type_Shh.a(paramIntent, paramByte, paramInt);
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_Wxr = wxr.a();
    this.jdField_a_of_type_Wxr.a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a();
    this.jdField_a_of_type_Wxr.b();
    if (this.jdField_a_of_type_Shh != null) {
      this.jdField_a_of_type_Shh.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pcf
 * JD-Core Version:    0.7.0.1
 */