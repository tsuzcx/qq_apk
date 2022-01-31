package cooperation.qzone.webviewplugin;

import ajjy;
import android.app.Activity;
import android.content.Context;
import babr;
import bafb;
import bbac;
import bgjg;
import bgji;
import bgjj;
import bgjk;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class QzoneQunFeedJsPlugin$2$1
  implements Runnable
{
  public QzoneQunFeedJsPlugin$2$1(bgji parambgji) {}
  
  public void run()
  {
    bgjg.a(this.a.jdField_a_of_type_Bgjg, this.a.jdField_a_of_type_ArrayOfJavaLangString[0]);
    Activity localActivity = this.a.jdField_a_of_type_Bgjg.a.mRuntime.a();
    if (bgjg.a(this.a.jdField_a_of_type_Bgjg) == null) {
      bgjg.a(this.a.jdField_a_of_type_Bgjg, babr.a(localActivity, 230).setTitle(ajjy.a(2131646487)).setMessage(ajjy.a(2131646491)).setPositiveButton(ajjy.a(2131646488), new bgjk(this)).setNegativeButton(localActivity.getString(2131652318), new bgjj(this)));
    }
    if (!bgjg.a(this.a.jdField_a_of_type_Bgjg).isShowing()) {
      bgjg.a(this.a.jdField_a_of_type_Bgjg).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */