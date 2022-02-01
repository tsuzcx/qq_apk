package com.tencent.mobileqq.jsp;

import android.util.Log;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.teamwork.TeamWorkHandler;
import mqq.os.MqqHandler;

final class DocxApiPlugin$8
  implements Runnable
{
  DocxApiPlugin$8(String paramString, TouchWebView paramTouchWebView) {}
  
  public void run()
  {
    String str = TeamWorkHandler.b(this.jdField_a_of_type_JavaLangString);
    ThreadManager.getUIHandler().post(new DocxApiPlugin.8.1(this, str));
    Log.e("tendocpreload", "end preload data send Back 2 Web ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DocxApiPlugin.8
 * JD-Core Version:    0.7.0.1
 */