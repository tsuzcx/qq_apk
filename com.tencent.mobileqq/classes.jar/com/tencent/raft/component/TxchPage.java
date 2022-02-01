package com.tencent.raft.component;

import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.Field;

public class TxchPage
{
  public static final String serverUrl = "https://support.qq.com/products/%s";
  public String appName;
  public String openId;
  public String productId;
  public String userAvatar;
  public String userID;
  public String userNickname;
  public String userType;
  
  public TxchPage(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.productId = paramString1;
    this.openId = paramString2;
    this.appName = paramString3;
    this.userAvatar = paramString4;
  }
  
  public WebView getTucaoPage(WebView paramWebView)
  {
    paramWebView.getSettings().setJavaScriptEnabled(true);
    paramWebView.getSettings().setDomStorageEnabled(true);
    String str = String.format("https://support.qq.com/products/%s", new Object[] { this.productId });
    paramWebView.setWebViewClient(new TxchPage.1(this));
    paramWebView.loadUrl(str);
    return paramWebView;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Field[] arrayOfField = getClass().getFields();
    int j = arrayOfField.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Field localField = arrayOfField[i];
        try
        {
          localStringBuffer.append(localField.getName()).append("=").append(localField.get(this)).append(",");
          i += 1;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          for (;;)
          {
            localIllegalAccessException.printStackTrace();
          }
        }
      }
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.raft.component.TxchPage
 * JD-Core Version:    0.7.0.1
 */