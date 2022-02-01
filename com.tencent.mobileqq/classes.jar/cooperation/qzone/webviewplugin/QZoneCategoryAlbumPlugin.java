package cooperation.qzone.webviewplugin;

import android.app.Activity;
import bgve;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
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
      Activity localActivity = this.parentPlugin.mRuntime.a();
      if (localActivity != null)
      {
        QZoneHelper.forwardToCategoryAlbum(localActivity, this.parentPlugin.mRuntime.a().getCurrentAccountUin(), i, paramString, -1);
        return true;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("QZoneCategoryAlbumPlugin", 1, paramString.getMessage());
      return false;
    }
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.parentPlugin == null) || (this.parentPlugin.mRuntime == null)) {}
    while ((!paramString3.equalsIgnoreCase("jumpCategoryAlbum")) || (paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return false;
    }
    return jumpCategoryAlbum(paramVarArgs[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneCategoryAlbumPlugin
 * JD-Core Version:    0.7.0.1
 */