package com.tencent.mobileqq.studyroom.webview;

import android.graphics.Bitmap;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

class StudyRoomBaseWebViewBuilder$InnerAbsWebView
  extends AbsWebView
{
  private boolean jdField_a_of_type_Boolean;
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    super.bindJavaScript(paramArrayList);
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqStudyroomWebviewStudyRoomBaseWebViewBuilder.a(localArrayList);
    paramArrayList.addAll(localArrayList);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.jdField_a_of_type_ComTencentMobileqqStudyroomWebviewStudyRoomBaseWebViewBuilder.b((StudyRoomWebView)paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    this.jdField_a_of_type_ComTencentMobileqqStudyroomWebviewStudyRoomBaseWebViewBuilder.a((StudyRoomWebView)paramWebView, paramString);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    this.jdField_a_of_type_ComTencentMobileqqStudyroomWebviewStudyRoomBaseWebViewBuilder.a((StudyRoomWebView)paramWebView, paramString2, paramInt, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.webview.StudyRoomBaseWebViewBuilder.InnerAbsWebView
 * JD-Core Version:    0.7.0.1
 */