import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.util.OfflineUpdateStatus;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.util.HashMap;

public class pgr
  implements View.OnClickListener
{
  public pgr(OfflinePlugin paramOfflinePlugin) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.mRuntime.a();
    if (paramView == null) {}
    OfflineUpdateStatus localOfflineUpdateStatus;
    do
    {
      do
      {
        do
        {
          return;
        } while ((OfflinePlugin.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(OfflinePlugin.a(this.a))));
        localOfflineUpdateStatus = (OfflineUpdateStatus)OfflinePlugin.jdField_a_of_type_JavaUtilHashMap.get(OfflinePlugin.a(this.a));
      } while (localOfflineUpdateStatus == null);
      if (localOfflineUpdateStatus.b() == 3)
      {
        localOfflineUpdateStatus.a();
        this.a.b();
        localOfflineUpdateStatus.a(4);
        if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
          this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
        OfflinePlugin.jdField_a_of_type_JavaUtilHashMap.remove(OfflinePlugin.a(this.a));
        return;
      }
    } while (localOfflineUpdateStatus.b() != 0);
    HtmlOffline.a(paramView.getApplicationContext(), OfflinePlugin.a(this.a), localOfflineUpdateStatus.f, localOfflineUpdateStatus.a, localOfflineUpdateStatus);
    localOfflineUpdateStatus.a(1);
    if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pgr
 * JD-Core Version:    0.7.0.1
 */