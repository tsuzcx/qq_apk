import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyMessagesActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SubCommentCreateData;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.math.BigInteger;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class pzs
  extends WebViewPlugin
{
  aanz jdField_a_of_type_Aanz = null;
  public Bundle a;
  private String jdField_a_of_type_JavaLangString;
  uat jdField_a_of_type_Uat;
  
  public pzs()
  {
    this.mPluginNameSpace = "readinjoy";
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramIntent == null) {}
    String str1;
    Object localObject1;
    String str2;
    int i;
    do
    {
      for (;;)
      {
        return;
        localObject2 = paramIntent.getStringExtra("arg_callback");
        str1 = paramIntent.getStringExtra("arg_result_json");
        try
        {
          localJSONObject = new JSONObject(str1);
          if (localJSONObject != null) {
            if (paramInt == -1) {}
          }
        }
        catch (JSONException localJSONException)
        {
          try
          {
            JSONObject localJSONObject;
            localJSONObject.put("retCode", -1);
            localJSONObject.put("commentId", 0);
            callJs((String)localObject2, new String[] { localJSONObject.toString() });
            return;
            localJSONException = localJSONException;
            QLog.e("ReadInJoyWebviewPlugin", 1, "handleCommentEditorNativeResult result parse error.");
            localObject1 = null;
          }
          catch (JSONException paramIntent)
          {
            for (;;)
            {
              QLog.e("ReadInJoyWebviewPlugin", 1, "handleCommentEditorNativeResult put user cancel result error.");
            }
          }
          paramInt = ((JSONObject)localObject1).optInt("biuAfterComment", 0);
          str2 = new String(Base64.decode(((JSONObject)localObject1).optString("comment"), 0));
          i = ((JSONObject)localObject1).optInt("feedsType");
          localObject1 = new pzx(this, (JSONObject)localObject1, (String)localObject2);
          paramIntent = paramIntent.getParcelableExtra("comment_create_data");
          if ((paramIntent instanceof FirstCommentCreateData))
          {
            paramIntent = (FirstCommentCreateData)paramIntent;
            paramIntent.a(str2);
            localObject2 = pdz.a;
            if (paramInt == 1) {}
            for (;;)
            {
              ((pdz)localObject2).a(paramIntent, (pea)localObject1, str1, i, false, bool1);
              return;
              bool1 = false;
            }
          }
        }
      }
    } while (!(paramIntent instanceof SubCommentCreateData));
    paramIntent = (SubCommentCreateData)paramIntent;
    paramIntent.d(str2);
    Object localObject2 = pdz.a;
    if (paramInt == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      ((pdz)localObject2).a(paramIntent, (pea)localObject1, str1, i, false, bool1);
      return;
    }
  }
  
  private void a(String paramString, Exception paramException)
  {
    if (QLog.isColorLevel())
    {
      paramException.printStackTrace();
      QLog.e("ReadInJoyWebviewPlugin", 2, paramException.getMessage());
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 1);
      localJSONObject.put("msg", paramException.getMessage());
      super.callJs(paramString + "(" + localJSONObject.toString() + ");");
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReadInJoyWebviewPlugin", 2, paramException.getMessage());
    }
  }
  
  private void a(@NotNull JSONObject paramJSONObject)
  {
    if (this.mRuntime.a() == null) {
      return;
    }
    String str2 = paramJSONObject.optString("callback");
    boolean bool1 = paramJSONObject.optBoolean("enableAnonymous", false);
    boolean bool2 = paramJSONObject.optBoolean("canBiu", true);
    int i = paramJSONObject.optInt("maxLength", -1);
    int j = paramJSONObject.optInt("commentType", 0);
    int k = paramJSONObject.optInt("sourceType", 0);
    int m = paramJSONObject.optInt("openAt", 0);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("defaultCommentAtLevel");
    localObject1 = paramJSONObject.optString("placeholder");
    try
    {
      localObject2 = new String(bgku.decode((String)localObject1, 0));
      localObject1 = localObject2;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject2;
        QLog.e("ReadInJoyWebviewPlugin", 1, "showCommentEditorNative | comment_placeholder decode error! | comment_placeholder: " + (String)localObject1);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyWebviewPlugin", 2, "showCommentEditorNative | comment_placeholder after decode: " + (String)localObject1);
    }
    localObject2 = paramJSONObject.optString("defaultTxt");
    try
    {
      str1 = new String(bgku.decode((String)localObject2, 0));
      localObject2 = str1;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        String str1;
        String str3;
        int n;
        int i1;
        String str5;
        String str4;
        long l;
        String str6;
        QLog.e("ReadInJoyWebviewPlugin", 1, "showCommentEditorNative | defaultTxt decode error! | defaultTxt: " + localException1);
        continue;
        localObject1 = new SubCommentCreateData(i1, str5);
        ((SubCommentCreateData)localObject1).a(str4);
        ((SubCommentCreateData)localObject1).b(localException2);
        ((SubCommentCreateData)localObject1).c(str3);
        ((SubCommentCreateData)localObject1).a(l);
        ((SubCommentCreateData)localObject1).e(str6);
        ((SubCommentCreateData)localObject1).b(n);
        paramJSONObject.putExtra("comment_create_data", (Parcelable)localObject1);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyWebviewPlugin", 2, "showCommentEditorNative | defaultTxt after decode: " + (String)localObject2);
    }
    str1 = paramJSONObject.optString("rowkey");
    str3 = paramJSONObject.optString("articleId");
    n = paramJSONObject.optInt("scene");
    i1 = paramJSONObject.optInt("entry");
    str5 = paramJSONObject.optString("businessInfo");
    str4 = paramJSONObject.optString("firstCommentId");
    l = paramJSONObject.optLong("repliedSubAuthorId");
    str6 = paramJSONObject.optString("repliedSubCommentId");
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("comment_type", false);
    paramJSONObject.putExtra("arg_comment_enable_anonymous", bool1);
    paramJSONObject.putExtra("arg_comment_placeholder", (String)localObject1);
    paramJSONObject.putExtra("arg_comment_default_txt", (String)localObject2);
    paramJSONObject.putExtra("arg_comment_max_length", i);
    paramJSONObject.putExtra("arg_comment_comment_type", j);
    paramJSONObject.putExtra("arg_comment_source_type", k);
    paramJSONObject.putExtra("arg_callback", str2);
    paramJSONObject.putExtra("arg_comment_open_at", m);
    paramJSONObject.putExtra("comment_can_biu", bool2);
    paramJSONObject.putExtra("public_fragment_window_feature", 1);
    if (localJSONArray != null) {
      paramJSONObject.putExtra("arg_comment_default_comment_at", localJSONArray.toString());
    }
    if (str4.isEmpty())
    {
      localObject1 = new FirstCommentCreateData(i1, str5);
      ((FirstCommentCreateData)localObject1).b(str1);
      ((FirstCommentCreateData)localObject1).c(str3);
      ((FirstCommentCreateData)localObject1).b(n);
      paramJSONObject.putExtra("comment_create_data", (Parcelable)localObject1);
      PublicTransFragmentActivity.b(this.mRuntime.a(), paramJSONObject, ReadInJoyCommentComponentFragment.class, 10);
      return;
    }
  }
  
  private void a(JSONObject paramJSONObject, String paramString)
  {
    this.jdField_a_of_type_AndroidOsBundle.clear();
    long l = new BigInteger(paramJSONObject.getString("feeds_id")).longValue();
    this.jdField_a_of_type_AndroidOsBundle.putLong("feeds_id", Long.valueOf(l).longValue());
    int i = paramJSONObject.optInt("feeds_type", 1);
    this.jdField_a_of_type_AndroidOsBundle.putInt("feeds_type", Integer.valueOf(i).intValue());
    a(arph.a("ipc_kandian_socialfeeds_update", paramString, 0, this.jdField_a_of_type_AndroidOsBundle), false, false);
  }
  
  private boolean a(String[] paramArrayOfString)
  {
    if (this.jdField_a_of_type_Uat == null) {
      this.jdField_a_of_type_Uat = new uat(this, this.jdField_a_of_type_Aanz);
    }
    if (paramArrayOfString == null) {
      return true;
    }
    this.jdField_a_of_type_Uat.a(paramArrayOfString[0]);
    return false;
  }
  
  private void b()
  {
    Intent localIntent = new Intent(this.mRuntime.a(), ReadInJoyMessagesActivity.class);
    localIntent.setFlags(67108864);
    startActivityForResult(localIntent, (byte)0);
  }
  
  private void b(JSONObject paramJSONObject)
  {
    localObject = null;
    try
    {
      str2 = paramJSONObject.getString("callback");
      String str3;
      String str1;
      long l1;
      long l2;
      long l3;
      int i;
      QLog.w("ReadInJoyWebviewPlugin", 1, "setSkinAndSound error " + paramJSONObject.toString());
    }
    catch (Exception paramJSONObject)
    {
      try
      {
        str3 = paramJSONObject.getString("skinId");
        localObject = "";
        if (paramJSONObject.has("skinUrl")) {
          localObject = paramJSONObject.optString("skinUrl");
        }
        str1 = "";
        if (paramJSONObject.has("skinName")) {
          str1 = paramJSONObject.optString("skinName");
        }
        l1 = 0L;
        if (paramJSONObject.has("seq")) {
          l1 = paramJSONObject.optLong("seq");
        }
        l2 = 0L;
        if (paramJSONObject.has("startTime")) {
          l2 = paramJSONObject.optLong("startTime");
        }
        l3 = 0L;
        if (paramJSONObject.has("endTime")) {
          l3 = paramJSONObject.optLong("endTime");
        }
        i = 0;
        if (paramJSONObject.has("volumeIsOn")) {
          i = paramJSONObject.optInt("volumeIsOn");
        }
        this.jdField_a_of_type_Aanz.a(str3, l1, (String)localObject, str1, l2, l3, i, new pzt(this, str2));
        QLog.d("ReadInJoyWebviewPlugin", 4, "send set skin cmd to service");
        return;
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          String str2;
          localObject = str2;
        }
      }
      paramJSONObject = paramJSONObject;
    }
    callJs((String)localObject, new String[] { "{\"retCode\":-1}" });
  }
  
  private void c(JSONObject paramJSONObject)
  {
    String str2 = null;
    try
    {
      str1 = paramJSONObject.getString("callback");
      String str3;
      String str4;
      long l1;
      long l2;
      long l3;
      QLog.w("ReadInJoyWebviewPlugin", 1, "notifyLoadSkin error " + paramJSONObject.toString());
    }
    catch (JSONException paramJSONObject)
    {
      try
      {
        str2 = paramJSONObject.getString("skinId");
        str3 = paramJSONObject.getString("skinUrl");
        str4 = paramJSONObject.getString("skinName");
        l1 = paramJSONObject.getLong("seq");
        l2 = paramJSONObject.getLong("startTime");
        l3 = paramJSONObject.getLong("endTime");
        this.jdField_a_of_type_Aanz.a(str2, l1, str3, str4, l2, l3, new pzu(this, str1));
        QLog.d("ReadInJoyWebviewPlugin", 4, "send notifyLoadSkin cmd to service");
        return;
      }
      catch (JSONException paramJSONObject)
      {
        String str1;
        break label107;
      }
      paramJSONObject = paramJSONObject;
      str1 = str2;
    }
    label107:
    callJs(str1, new String[] { "{\"retCode\":-1}" });
  }
  
  private void d(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = null;
    try
    {
      paramJSONObject = paramJSONObject.getString("callback");
      localJSONObject = paramJSONObject;
      this.jdField_a_of_type_Aanz.i(new pzv(this, paramJSONObject));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.w("ReadInJoyWebviewPlugin", 1, "readSkinAndSound error " + paramJSONObject.toString());
      callJs(localJSONObject, new String[] { "{\"retCode\":-1}" });
    }
  }
  
  private void e(JSONObject paramJSONObject)
  {
    Object localObject = null;
    try
    {
      String str2 = paramJSONObject.getString("callback");
      localObject = str2;
      String str3 = paramJSONObject.getString("skinId");
      String str1 = "";
      localObject = str2;
      if (paramJSONObject.has("skinUrl"))
      {
        localObject = str2;
        str1 = paramJSONObject.optString("skinUrl");
      }
      localObject = str2;
      this.jdField_a_of_type_Aanz.e(str3, str1, new pzw(this, str2));
      localObject = str2;
      QLog.d("ReadInJoyWebviewPlugin", 4, "send cancelLoadSkin cmd to service");
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.w("ReadInJoyWebviewPlugin", 1, "cancelLoadSkin error " + paramJSONObject.toString());
      callJs(localObject, new String[] { "{\"retCode\":-1}" });
    }
  }
  
  private void f(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("callback");
    paramJSONObject = paramJSONObject.optString("rowkey", "");
    int i;
    if ((this.mRuntime.a() instanceof PublicAccountBrowser))
    {
      PublicAccountBrowser localPublicAccountBrowser = (PublicAccountBrowser)this.mRuntime.a();
      if ((paramJSONObject.equals(localPublicAccountBrowser.c)) && (localPublicAccountBrowser.a)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        paramJSONObject = new JSONObject();
      }
      try
      {
        paramJSONObject.put("retCode", 0);
        if (i != 0) {}
        for (i = 1;; i = 0)
        {
          paramJSONObject.put("is_redpack", i);
          callJs(str, new String[] { paramJSONObject.toString() });
          return;
          i = 0;
          break;
        }
        i = 0;
      }
      catch (JSONException paramJSONObject)
      {
        QLog.w("ReadInJoyWebviewPlugin", 1, "getShareRedPackContentStatus error " + paramJSONObject.toString());
        callJs(str, new String[] { "{\"retCode\":-1}" });
        return;
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyWebviewPlugin", 2, "do updateSocialFeedsInfo all");
    }
    this.jdField_a_of_type_AndroidOsBundle.putLong("feeds_id", -1L);
    this.jdField_a_of_type_AndroidOsBundle.putLong("feeds_type", 1L);
    a(arph.a("ipc_kandian_socialfeeds_update", "", 0, this.jdField_a_of_type_AndroidOsBundle), false, false);
  }
  
  protected void a(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!arui.a().a())
    {
      if (paramBoolean2) {
        Toast.makeText(this.mRuntime.a().getApplicationContext(), anni.a(2131711590), 0).show();
      }
      return;
    }
    if (paramBoolean1)
    {
      arui.a().b(paramBundle);
      return;
    }
    arui.a().a(paramBundle);
  }
  
  public boolean a(String paramString, JSONObject paramJSONObject)
  {
    Object localObject = null;
    String str;
    try
    {
      str = paramJSONObject.optString("callback");
      if (str == null)
      {
        localObject = str;
        throw new Exception("need callback");
      }
    }
    catch (Exception paramString)
    {
      a(localObject, paramString);
    }
    for (;;)
    {
      return true;
      localObject = str;
      if (TextUtils.equals("socialize_feeds_update", paramString))
      {
        localObject = str;
        a(paramJSONObject, str);
      }
      else
      {
        localObject = str;
        if (TextUtils.equals("openPrivateLetter", paramString))
        {
          localObject = str;
          this.jdField_a_of_type_JavaLangString = str;
          localObject = str;
          b();
        }
      }
    }
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
    if ((paramString1 == null) || (!"readinjoy".equals(paramString2)) || (paramString3 == null)) {}
    do
    {
      return false;
      if (!"showShareReadInJoyMenu".equals(paramString3)) {
        break;
      }
    } while (a(paramVarArgs));
    for (;;)
    {
      return true;
      paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (paramJsBridgeListener == null) {
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyWebviewPlugin", 2, "handleJsRequest JSON = " + paramJsBridgeListener.toString());
      }
      if ((TextUtils.equals("socialize_feeds_update", paramString3)) || (TextUtils.equals("openPrivateLetter", paramString3))) {
        return a(paramString3, paramJsBridgeListener);
      }
      if ("readSkinAndSound".equals(paramString3)) {
        d(paramJsBridgeListener);
      } else if ("notifyLoadSkin".equals(paramString3)) {
        c(paramJsBridgeListener);
      } else if ("cancelLoadSkin".equals(paramString3)) {
        e(paramJsBridgeListener);
      } else if ("setSkinAndSound".equals(paramString3)) {
        b(paramJsBridgeListener);
      } else if ("getShareRedPackContentStatus".equals(paramString3)) {
        f(paramJsBridgeListener);
      } else if ("showCommentEditorNative".equals(paramString3)) {
        a(paramJsBridgeListener);
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
    do
    {
      do
      {
        return;
        if ((paramByte != 1) && (paramByte != 2)) {
          break;
        }
      } while (this.jdField_a_of_type_Uat == null);
      this.jdField_a_of_type_Uat.a(paramIntent, paramByte, paramInt);
      return;
    } while (paramByte != 10);
    a(paramInt, paramIntent);
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_Aanz = aanz.a();
    this.jdField_a_of_type_Aanz.a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a();
    this.jdField_a_of_type_Aanz.b();
    if (this.jdField_a_of_type_Uat != null) {
      this.jdField_a_of_type_Uat.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pzs
 * JD-Core Version:    0.7.0.1
 */