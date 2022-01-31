package cooperation.qzone.webviewplugin;

import ajya;
import android.app.Activity;
import android.content.Context;
import bbdj;
import bbgu;
import bcdp;
import bhsr;
import bhst;
import bhsu;
import bhsv;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class QzoneQunFeedJsPlugin$2$1
  implements Runnable
{
  public QzoneQunFeedJsPlugin$2$1(bhst parambhst) {}
  
  public void run()
  {
    bhsr.a(this.a.jdField_a_of_type_Bhsr, this.a.jdField_a_of_type_ArrayOfJavaLangString[0]);
    Activity localActivity = this.a.jdField_a_of_type_Bhsr.a.mRuntime.a();
    if (bhsr.a(this.a.jdField_a_of_type_Bhsr) == null) {
      bhsr.a(this.a.jdField_a_of_type_Bhsr, bbdj.a(localActivity, 230).setTitle(ajya.a(2131712286)).setMessage(ajya.a(2131712290)).setPositiveButton(ajya.a(2131712287), new bhsv(this)).setNegativeButton(localActivity.getString(2131718148), new bhsu(this)));
    }
    if (!bhsr.a(this.a.jdField_a_of_type_Bhsr).isShowing()) {
      bhsr.a(this.a.jdField_a_of_type_Bhsr).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */