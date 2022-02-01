import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.av.wtogether.fragment.AVRecentFileSelectFragment;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class naa
  extends WebViewPlugin
{
  public static final String a = naa.class.getSimpleName();
  
  public naa()
  {
    this.mPluginNameSpace = "c2c_together_business";
  }
  
  private void a()
  {
    Object localObject = this.mRuntime.a().getIntent();
    int i = ((Intent)localObject).getIntExtra("key_from_type", 0);
    int j = ((Intent)localObject).getIntExtra("watch_together_uinType", -1);
    localObject = ((Intent)localObject).getStringExtra("watch_together_uin");
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "handleLaunchQFileChooser, fromType[" + i + "], uinType[" + j + "], uin[" + (String)localObject + "]");
    }
    AVRecentFileSelectFragment.a(this.mRuntime.a(), i, j, (String)localObject, biit.a(110, 231));
  }
  
  private void a(String paramString)
  {
    Intent localIntent = this.mRuntime.a().getIntent();
    ChooseFileInfo localChooseFileInfo = new ChooseFileInfo(4);
    localChooseFileInfo.g = paramString;
    localIntent.putExtra("ChooseFileInfo", localChooseFileInfo);
    this.mRuntime.a().setResult(4660, localIntent);
    this.mRuntime.a().finish();
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder("Call WTBusinessForWebPlugin handleJsRequest, url=").append(paramString1).append(" pkgName=").append(paramString2).append(" method=").append(paramString3);
      QLog.d(a, 2, paramJsBridgeListener.toString());
    }
    if (this.mPluginNameSpace.equalsIgnoreCase(paramString2))
    {
      if ("push_to_local_file_controller".equalsIgnoreCase(paramString3)) {
        a();
      }
      for (;;)
      {
        return true;
        if ("select_file_info".equalsIgnoreCase(paramString3)) {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("resourceId");
            if (!TextUtils.isEmpty(paramJsBridgeListener)) {
              a(paramJsBridgeListener);
            }
            if (QLog.isColorLevel())
            {
              QLog.d(a, 2, "handleJsRequest " + paramString3 + ", resourceId[" + paramJsBridgeListener + "]");
              return true;
            }
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            QLog.d(a, 1, "handleJsRequest " + paramString3 + " exception[" + paramJsBridgeListener.getMessage() + "]");
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if ((paramInt == -1) && (paramByte == 110) && (paramIntent != null))
    {
      this.mRuntime.a().setResult(4660, paramIntent);
      this.mRuntime.a().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     naa
 * JD-Core Version:    0.7.0.1
 */