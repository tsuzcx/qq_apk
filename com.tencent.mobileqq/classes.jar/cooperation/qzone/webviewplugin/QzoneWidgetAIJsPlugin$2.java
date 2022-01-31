package cooperation.qzone.webviewplugin;

import ajjy;
import android.app.Activity;
import bbac;
import bfpr;
import bfpy;
import bgde;
import bgkf;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.video.QzoneLiveVideoInterface;

public class QzoneWidgetAIJsPlugin$2
  implements Runnable
{
  public QzoneWidgetAIJsPlugin$2(bgkf parambgkf, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    Activity localActivity = this.this$0.a.mRuntime.a();
    if (localActivity == null) {
      return;
    }
    bgde localbgde2;
    if ((1 == this.jdField_a_of_type_Int) || (2 == this.jdField_a_of_type_Int))
    {
      localbgde2 = bgde.a();
      localbgde1 = localbgde2;
      if (localbgde2 == null)
      {
        localbgde1 = localbgde2;
        if (localbgde2.a()) {
          bgde.a(this.this$0.a.mRuntime.a());
        }
      }
    }
    for (bgde localbgde1 = localbgde2;; localbgde1 = null)
    {
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        return;
      case 1: 
        localbgde1.a(this.jdField_a_of_type_JavaLangString, null, 0);
        return;
      case 2: 
        localbgde1.a(this.jdField_a_of_type_JavaLangString, null, 1);
        return;
      case 3: 
        QzoneLiveVideoInterface.shareToQQ(localActivity, null, null, null, null, this.jdField_a_of_type_JavaLangString);
        return;
      }
      bfpr.a(localActivity, bfpy.a(), this.jdField_a_of_type_JavaLangString, ajjy.a(2131646870), this.b, -1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneWidgetAIJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */