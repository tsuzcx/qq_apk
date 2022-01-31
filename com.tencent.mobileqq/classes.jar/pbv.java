import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class pbv
  implements AsyncBack
{
  public pbv(OfflinePlugin paramOfflinePlugin, JsBridgeListener paramJsBridgeListener) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject();
        paramString.put("retcode", -1);
        paramString.put("msg", "error");
        this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.callJs(this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.jdField_a_of_type_JavaLangString, new String[] { paramString.toString() });
        return;
      }
      catch (JSONException paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, batchCheckUpdate, JSONException :" + paramString);
        return;
      }
    }
    Message localMessage = Message.obtain();
    localMessage.what = 121;
    localMessage.obj = new Object[] { this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener, paramString };
    this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pbv
 * JD-Core Version:    0.7.0.1
 */