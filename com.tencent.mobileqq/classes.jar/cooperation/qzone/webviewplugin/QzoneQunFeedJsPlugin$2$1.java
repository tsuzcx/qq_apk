package cooperation.qzone.webviewplugin;

import alud;
import android.app.Activity;
import android.content.Context;
import bdgm;
import bdjz;
import begz;
import bjyj;
import bjyl;
import bjym;
import bjyn;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class QzoneQunFeedJsPlugin$2$1
  implements Runnable
{
  public QzoneQunFeedJsPlugin$2$1(bjyl parambjyl) {}
  
  public void run()
  {
    bjyj.a(this.a.jdField_a_of_type_Bjyj, this.a.jdField_a_of_type_ArrayOfJavaLangString[0]);
    Activity localActivity = this.a.jdField_a_of_type_Bjyj.a.mRuntime.a();
    if (bjyj.a(this.a.jdField_a_of_type_Bjyj) == null) {
      bjyj.a(this.a.jdField_a_of_type_Bjyj, bdgm.a(localActivity, 230).setTitle(alud.a(2131712670)).setMessage(alud.a(2131712674)).setPositiveButton(alud.a(2131712671), new bjyn(this)).setNegativeButton(localActivity.getString(2131718535), new bjym(this)));
    }
    if (!bjyj.a(this.a.jdField_a_of_type_Bjyj).isShowing()) {
      bjyj.a(this.a.jdField_a_of_type_Bjyj).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */