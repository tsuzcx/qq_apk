package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Context;
import anzj;
import bhlq;
import bhpc;
import bioy;
import bnnx;
import bnnz;
import bnoa;
import bnob;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class QzoneQunFeedJsPlugin$2$1
  implements Runnable
{
  public QzoneQunFeedJsPlugin$2$1(bnnz parambnnz) {}
  
  public void run()
  {
    bnnx.a(this.a.jdField_a_of_type_Bnnx, this.a.jdField_a_of_type_ArrayOfJavaLangString[0]);
    Activity localActivity = this.a.jdField_a_of_type_Bnnx.a.mRuntime.a();
    if (bnnx.a(this.a.jdField_a_of_type_Bnnx) == null) {
      bnnx.a(this.a.jdField_a_of_type_Bnnx, bhlq.a(localActivity, 230).setTitle(anzj.a(2131711158)).setMessage(anzj.a(2131711162)).setPositiveButton(anzj.a(2131711159), new bnob(this)).setNegativeButton(localActivity.getString(2131716807), new bnoa(this)));
    }
    if (!bnnx.a(this.a.jdField_a_of_type_Bnnx).isShowing()) {
      bnnx.a(this.a.jdField_a_of_type_Bnnx).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */