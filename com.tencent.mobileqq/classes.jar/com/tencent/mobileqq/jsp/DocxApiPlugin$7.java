package com.tencent.mobileqq.jsp;

import com.tencent.biz.ui.TouchWebView;
import org.json.JSONObject;

final class DocxApiPlugin$7
  implements Runnable
{
  DocxApiPlugin$7(TouchWebView paramTouchWebView, JSONObject paramJSONObject) {}
  
  public void run()
  {
    TouchWebView localTouchWebView = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:window.injectLocalTcntDocData(");
    localStringBuilder.append(this.jdField_a_of_type_OrgJsonJSONObject.toString());
    localStringBuilder.append(")");
    localTouchWebView.loadUrl(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DocxApiPlugin.7
 * JD-Core Version:    0.7.0.1
 */