package cooperation.qzone.webviewplugin;

import ajyc;
import android.app.Activity;
import android.content.Context;
import bbcv;
import bbgg;
import bcdb;
import bhsa;
import bhsc;
import bhsd;
import bhse;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class QzoneQunFeedJsPlugin$2$1
  implements Runnable
{
  public QzoneQunFeedJsPlugin$2$1(bhsc parambhsc) {}
  
  public void run()
  {
    bhsa.a(this.a.jdField_a_of_type_Bhsa, this.a.jdField_a_of_type_ArrayOfJavaLangString[0]);
    Activity localActivity = this.a.jdField_a_of_type_Bhsa.a.mRuntime.a();
    if (bhsa.a(this.a.jdField_a_of_type_Bhsa) == null) {
      bhsa.a(this.a.jdField_a_of_type_Bhsa, bbcv.a(localActivity, 230).setTitle(ajyc.a(2131712275)).setMessage(ajyc.a(2131712279)).setPositiveButton(ajyc.a(2131712276), new bhse(this)).setNegativeButton(localActivity.getString(2131718137), new bhsd(this)));
    }
    if (!bhsa.a(this.a.jdField_a_of_type_Bhsa).isShowing()) {
      bhsa.a(this.a.jdField_a_of_type_Bhsa).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */