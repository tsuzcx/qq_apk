import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.util.OfflineUpdateStatus;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QQBrowserBaseActivityInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class paa
  extends Handler
{
  public paa(OfflinePlugin paramOfflinePlugin, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.jdField_a_of_type_Boolean) {}
    label32:
    Object localObject2;
    label468:
    do
    {
      do
      {
        do
        {
          do
          {
            Object localObject1;
            do
            {
              return;
              switch (paramMessage.what)
              {
              default: 
                if (paramMessage.arg1 != 1) {
                  break label468;
                }
                this.a.b = paramMessage.arg2;
                localObject1 = (String)paramMessage.obj;
                localObject2 = this.a.mRuntime.a();
              }
            } while (localObject2 == null);
            if (this.a.jdField_a_of_type_Long == -1L) {
              this.a.jdField_a_of_type_Long = System.currentTimeMillis();
            }
            ((CustomWebView)localObject2).a((String)localObject1);
            ((CustomWebView)localObject2).requestFocus();
            if (QLog.isColorLevel()) {
              QLog.i("OfflinePluginQQ", 2, "mCheckupHandler loadUrl start \n" + (String)localObject1);
            }
            this.a.a((String)localObject1);
            for (;;)
            {
              for (;;)
              {
                localObject1 = this.a.mRuntime.a();
                localObject2 = this.a.mRuntime.a(this.a.mRuntime.a());
                if ((localObject2 == null) || (!(localObject2 instanceof WebUiUtils.QQBrowserBaseActivityInterface))) {
                  break;
                }
                if (paramMessage.arg1 != 4) {
                  break label535;
                }
                if ((OfflinePlugin.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(OfflinePlugin.a(this.a)))) {
                  break;
                }
                localObject1 = (OfflineUpdateStatus)OfflinePlugin.jdField_a_of_type_JavaUtilHashMap.get(OfflinePlugin.a(this.a));
                if (this.a.jdField_a_of_type_AndroidWidgetProgressBar != null) {
                  this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramMessage.arg2);
                }
                if (this.a.jdField_a_of_type_AndroidWidgetTextView == null) {
                  break;
                }
                this.a.jdField_a_of_type_AndroidWidgetTextView.setText(((OfflineUpdateStatus)localObject1).e + paramMessage.arg2 + "%");
                return;
                try
                {
                  localObject1 = (String)((Object[])(Object[])paramMessage.obj)[1];
                  localObject2 = new JSONObject();
                  ((JSONObject)localObject2).put("retcode", 0);
                  ((JSONObject)localObject2).put("data", Util.a((String)localObject1));
                  this.a.callJs(this.a.jdField_a_of_type_JavaLangString, new String[] { ((JSONObject)localObject2).toString() });
                }
                catch (Exception localException1)
                {
                  try
                  {
                    JSONObject localJSONObject1 = new JSONObject();
                    localJSONObject1.put("retcode", -1);
                    localJSONObject1.put("msg", "error");
                    this.a.callJs(this.a.jdField_a_of_type_JavaLangString, new String[] { localJSONObject1.toString() });
                  }
                  catch (JSONException localJSONException) {}
                }
              }
              if (!QLog.isColorLevel()) {
                break label32;
              }
              QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, batchCheckUpdate, JSONException :" + localJSONException);
              break label32;
              if (paramMessage.arg1 == 2)
              {
                if (QLog.isDevelopLevel()) {
                  QLog.i("OfflinePluginQQ", 4, "checkOfflineUpBack refresh current url");
                }
                this.a.c();
              }
              else if (paramMessage.arg1 == 3)
              {
                try
                {
                  JSONObject localJSONObject2 = (JSONObject)paramMessage.obj;
                  this.a.a(localJSONObject2);
                }
                catch (Exception localException2)
                {
                  localException2.printStackTrace();
                }
              }
            }
          } while ((paramMessage.arg1 != 5) || (OfflinePlugin.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(OfflinePlugin.a(this.a))));
          localObject2 = (OfflineUpdateStatus)OfflinePlugin.jdField_a_of_type_JavaUtilHashMap.get(OfflinePlugin.a(this.a));
        } while (localObject2 == null);
        if (paramMessage.arg2 != 0) {
          break;
        }
        ((OfflineUpdateStatus)localObject2).b(3);
      } while (localException2 == null);
      paramMessage = localException2.getResources().getDrawable(2130838568);
      paramMessage.setBounds(0, 0, 40, 40);
      if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramMessage, null, null, null);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(((OfflineUpdateStatus)localObject2).d);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetProgressBar != null) {
        this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      }
    } while (this.a.jdField_a_of_type_AndroidWidgetLinearLayout == null);
    label535:
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    return;
    if ((paramMessage.arg2 == 5) || (paramMessage.arg2 == 7))
    {
      if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      ((OfflineUpdateStatus)localObject2).b(4);
      return;
    }
    QRUtils.a(1, 2131430185);
    if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    ((OfflineUpdateStatus)localObject2).b(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     paa
 * JD-Core Version:    0.7.0.1
 */