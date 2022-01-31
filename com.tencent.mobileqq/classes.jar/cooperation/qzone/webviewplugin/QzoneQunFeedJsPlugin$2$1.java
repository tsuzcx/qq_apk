package cooperation.qzone.webviewplugin;

import alpo;
import android.app.Activity;
import android.content.Context;
import bdcd;
import bdfq;
import becq;
import bjuc;
import bjue;
import bjuf;
import bjug;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class QzoneQunFeedJsPlugin$2$1
  implements Runnable
{
  public QzoneQunFeedJsPlugin$2$1(bjue parambjue) {}
  
  public void run()
  {
    bjuc.a(this.a.jdField_a_of_type_Bjuc, this.a.jdField_a_of_type_ArrayOfJavaLangString[0]);
    Activity localActivity = this.a.jdField_a_of_type_Bjuc.a.mRuntime.a();
    if (bjuc.a(this.a.jdField_a_of_type_Bjuc) == null) {
      bjuc.a(this.a.jdField_a_of_type_Bjuc, bdcd.a(localActivity, 230).setTitle(alpo.a(2131712658)).setMessage(alpo.a(2131712662)).setPositiveButton(alpo.a(2131712659), new bjug(this)).setNegativeButton(localActivity.getString(2131718523), new bjuf(this)));
    }
    if (!bjuc.a(this.a.jdField_a_of_type_Bjuc).isShowing()) {
      bjuc.a(this.a.jdField_a_of_type_Bjuc).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */