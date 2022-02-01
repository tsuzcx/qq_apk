package com.tencent.mobileqq.filemanager.activity;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class FilePreviewActivity$8
  extends WebViewClient
{
  long jdField_a_of_type_Long = 0L;
  
  FilePreviewActivity$8(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_f_of_type_Boolean)
    {
      super.onPageFinished(paramWebView, paramString);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_f_of_type_Boolean = true;
    }
    Object localObject1 = null;
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_Boolean;
    Object localObject2 = "javascript:qpreview.onClientResponse('showFileList', {})";
    if (bool)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_Int == 0)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity;
        localObject1 = ((FilePreviewActivity)localObject1).getInitString(((FilePreviewActivity)localObject1).g, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.b, Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.h), this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.e, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_f_of_type_JavaLangString, null);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_Int == 1)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity;
        localObject1 = ((FilePreviewActivity)localObject1).getInitString(((FilePreviewActivity)localObject1).g, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.b, Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.h), this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.e, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.c);
      }
      else
      {
        if (QLog.isDevelopLevel()) {
          break label264;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("finish load run javascript![");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("]");
      QLog.i("<FileAssistant>FilePreviewActivity", 1, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl((String)localObject1);
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('showFileList', {})");
      localObject1 = localObject2;
      break label395;
      label264:
      throw new NullPointerException(HardCodeUtil.a(2131704673));
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity;
      localObject1 = ((FilePreviewActivity)localObject1).getInitString(((FilePreviewActivity)localObject1).g, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.b, Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.h), this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.e, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_f_of_type_JavaLangString, null);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("finish load run javascript![");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("]");
      QLog.i("<FileAssistant>FilePreviewActivity", 1, ((StringBuilder)localObject2).toString());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl((String)localObject1);
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('addMorePage',{})");
      localObject1 = "javascript:qpreview.onClientResponse('addMorePage',{})";
    }
    label395:
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("mWebView.loadUrl(");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(")");
    QLog.i("<FileAssistant>FilePreviewActivity", 1, ((StringBuilder)localObject2).toString());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl((String)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_f_of_type_Boolean = true;
    super.onPageFinished(paramWebView, paramString);
  }
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    for (;;)
    {
      try
      {
        localObject = URLDecoder.decode(paramString, "UTF-8");
        paramString = (String)localObject;
      }
      catch (Exception localException)
      {
        Object localObject;
        boolean bool;
        continue;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("URLDecoder.decode, url:");
          ((StringBuilder)localObject).append(paramString);
          QLog.i("<FileAssistant>FilePreviewActivity", 1, ((StringBuilder)localObject).toString());
        }
        bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.a(paramWebView, paramString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$JSInterface);
        if (bool) {
          return true;
        }
      }
      catch (Exception paramWebView)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("parseUrl error,exception:");
          ((StringBuilder)localObject).append(paramWebView.toString());
          QLog.e("<FileAssistant>FilePreviewActivity", 2, ((StringBuilder)localObject).toString());
        }
        if ((paramString != null) && (!"".equals(paramString)) && (!"about:blank;".equals(paramString)) && (!"about:blank".equals(paramString)))
        {
          long l = System.currentTimeMillis();
          if (l - this.jdField_a_of_type_Long < 1500L) {
            return true;
          }
          this.jdField_a_of_type_Long = l;
          paramWebView = new StringBuilder();
          paramWebView.append("start load new[");
          paramWebView.append(paramString);
          paramWebView.append("]");
          QLog.i("<FileAssistant>FilePreviewActivity", 1, paramWebView.toString());
          paramWebView = FilePreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity, paramString);
          try
          {
            URLDecoder.decode(paramWebView, "UTF-8");
            return true;
          }
          catch (UnsupportedEncodingException paramWebView)
          {
            paramWebView.printStackTrace();
            return true;
          }
        }
        QLog.e("<FileAssistant>FilePreviewActivity", 1, "request url is null,or about:blank! return");
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.8
 * JD-Core Version:    0.7.0.1
 */