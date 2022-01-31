package com.tencent.mobileqq.jsp;

import com.tencent.biz.ui.TouchWebView;
import org.json.JSONObject;

public final class DocxApiPlugin$7
  implements Runnable
{
  public DocxApiPlugin$7(TouchWebView paramTouchWebView, JSONObject paramJSONObject) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl("javascript:window.injectLocalTcntDocData(" + this.jdField_a_of_type_OrgJsonJSONObject.toString() + ")");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DocxApiPlugin.7
 * JD-Core Version:    0.7.0.1
 */