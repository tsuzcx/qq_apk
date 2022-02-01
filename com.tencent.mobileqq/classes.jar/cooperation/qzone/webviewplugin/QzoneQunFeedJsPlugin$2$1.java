package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Context;
import anni;
import bglp;
import bgpa;
import bhod;
import bmmu;
import bmmw;
import bmmx;
import bmmy;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class QzoneQunFeedJsPlugin$2$1
  implements Runnable
{
  public QzoneQunFeedJsPlugin$2$1(bmmw parambmmw) {}
  
  public void run()
  {
    bmmu.a(this.a.jdField_a_of_type_Bmmu, this.a.jdField_a_of_type_ArrayOfJavaLangString[0]);
    Activity localActivity = this.a.jdField_a_of_type_Bmmu.a.mRuntime.a();
    if (bmmu.a(this.a.jdField_a_of_type_Bmmu) == null) {
      bmmu.a(this.a.jdField_a_of_type_Bmmu, bglp.a(localActivity, 230).setTitle(anni.a(2131711049)).setMessage(anni.a(2131711053)).setPositiveButton(anni.a(2131711050), new bmmy(this)).setNegativeButton(localActivity.getString(2131716691), new bmmx(this)));
    }
    if (!bmmu.a(this.a.jdField_a_of_type_Bmmu).isShowing()) {
      bmmu.a(this.a.jdField_a_of_type_Bmmu).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */