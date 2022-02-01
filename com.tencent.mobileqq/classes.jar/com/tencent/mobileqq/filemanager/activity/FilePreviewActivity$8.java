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
  long a = 0L;
  
  FilePreviewActivity$8(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (this.b.J)
    {
      super.onPageFinished(paramWebView, paramString);
      return;
    }
    if (this.b.l) {
      this.b.J = true;
    }
    Object localObject1 = null;
    boolean bool = this.b.l;
    Object localObject2 = "javascript:qpreview.onClientResponse('showFileList', {})";
    if (bool)
    {
      if (this.b.i == 0)
      {
        localObject1 = this.b;
        localObject1 = ((FilePreviewActivity)localObject1).getInitString(((FilePreviewActivity)localObject1).p, this.b.j, Integer.parseInt(this.b.q), this.b.m, this.b.n, null);
      }
      else if (this.b.i == 1)
      {
        localObject1 = this.b;
        localObject1 = ((FilePreviewActivity)localObject1).getInitString(((FilePreviewActivity)localObject1).p, this.b.j, Integer.parseInt(this.b.q), this.b.m, this.b.n, this.b.g);
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
      this.b.d.loadUrl((String)localObject1);
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('showFileList', {})");
      localObject1 = localObject2;
      break label395;
      label264:
      throw new NullPointerException(HardCodeUtil.a(2131902577));
    }
    else
    {
      localObject1 = this.b;
      localObject1 = ((FilePreviewActivity)localObject1).getInitString(((FilePreviewActivity)localObject1).p, this.b.j, Integer.parseInt(this.b.q), this.b.m, this.b.n, null);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("finish load run javascript![");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("]");
      QLog.i("<FileAssistant>FilePreviewActivity", 1, ((StringBuilder)localObject2).toString());
      this.b.d.loadUrl((String)localObject1);
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('addMorePage',{})");
      localObject1 = "javascript:qpreview.onClientResponse('addMorePage',{})";
    }
    label395:
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("mWebView.loadUrl(");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(")");
    QLog.i("<FileAssistant>FilePreviewActivity", 1, ((StringBuilder)localObject2).toString());
    this.b.d.loadUrl((String)localObject1);
    this.b.J = true;
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
        bool = this.b.d.a(paramWebView, paramString, this.b.D);
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
          if (l - this.a < 1500L) {
            return true;
          }
          this.a = l;
          paramWebView = new StringBuilder();
          paramWebView.append("start load new[");
          paramWebView.append(paramString);
          paramWebView.append("]");
          QLog.i("<FileAssistant>FilePreviewActivity", 1, paramWebView.toString());
          paramWebView = FilePreviewActivity.a(this.b, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.8
 * JD-Core Version:    0.7.0.1
 */