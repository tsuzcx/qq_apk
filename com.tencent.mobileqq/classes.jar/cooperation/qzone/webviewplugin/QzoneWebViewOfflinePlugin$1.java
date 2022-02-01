package cooperation.qzone.webviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import org.json.JSONObject;

class QzoneWebViewOfflinePlugin$1
  extends Handler
{
  QzoneWebViewOfflinePlugin$1(QzoneWebViewOfflinePlugin paramQzoneWebViewOfflinePlugin, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i;
    if ((paramMessage.what == 203) && ((paramMessage.obj instanceof Bundle)))
    {
      localObject = (Bundle)paramMessage.obj;
      paramMessage = ((Bundle)localObject).getString("url");
      if ((((Bundle)localObject).getInt("req_state", 0) == 2) && (!TextUtils.isEmpty(QzoneWebViewOfflinePlugin.access$000(this.this$0))) && (!TextUtils.isEmpty(QzoneWebViewOfflinePlugin.access$100(this.this$0))) && (QzoneWebViewOfflinePlugin.access$100(this.this$0).equals(paramMessage)))
      {
        i = ((Bundle)localObject).getInt("result_code");
        paramMessage = new JSONObject();
        if (i != 0) {}
      }
    }
    try
    {
      paramMessage.put("code", 0);
    }
    catch (Exception localException)
    {
      label137:
      StringBuilder localStringBuilder;
      break label137;
    }
    paramMessage.put("code", i);
    paramMessage.put("msg", ((Bundle)localObject).getString("error_message"));
    Object localObject = this.this$0;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(QzoneWebViewOfflinePlugin.access$000(this.this$0));
    localStringBuilder.append("(");
    localStringBuilder.append(paramMessage.toString());
    localStringBuilder.append(");");
    ((QzoneWebViewOfflinePlugin)localObject).callJs(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin.1
 * JD-Core Version:    0.7.0.1
 */