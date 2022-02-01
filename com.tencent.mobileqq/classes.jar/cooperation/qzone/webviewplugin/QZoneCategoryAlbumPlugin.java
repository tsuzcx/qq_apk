package cooperation.qzone.webviewplugin;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import org.json.JSONObject;

public class QZoneCategoryAlbumPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final String NAMESPACE = "Qzone";
  
  private boolean jumpCategoryAlbum(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("categoryType");
      paramString = paramString.optString("categoryId");
      Activity localActivity = this.parentPlugin.mRuntime.d();
      if (localActivity != null)
      {
        QZoneHelper.forwardToCategoryAlbum(localActivity, this.parentPlugin.mRuntime.b().getCurrentAccountUin(), i, paramString, -1);
        return true;
      }
      return false;
    }
    catch (Exception paramString)
    {
      QLog.e("QZoneCategoryAlbumPlugin", 1, paramString.getMessage());
    }
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2.equals("Qzone")) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
        return false;
      }
      if ((paramString3.equalsIgnoreCase("jumpCategoryAlbum")) && (paramVarArgs != null) && (paramVarArgs.length > 0)) {
        return jumpCategoryAlbum(paramVarArgs[0]);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneCategoryAlbumPlugin
 * JD-Core Version:    0.7.0.1
 */