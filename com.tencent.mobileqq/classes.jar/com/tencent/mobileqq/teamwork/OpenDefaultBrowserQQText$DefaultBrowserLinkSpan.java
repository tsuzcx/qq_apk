package com.tencent.mobileqq.teamwork;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.text.style.LinkSpan;
import com.tencent.qphone.base.util.QLog;

public class OpenDefaultBrowserQQText$DefaultBrowserLinkSpan
  extends LinkSpan
{
  public OpenDefaultBrowserQQText$DefaultBrowserLinkSpan(OpenDefaultBrowserQQText paramOpenDefaultBrowserQQText, String paramString)
  {
    super(paramString);
  }
  
  protected void a(View paramView, String paramString)
  {
    paramString = Uri.parse(paramString);
    Context localContext = paramView.getContext();
    paramView = new Intent("android.intent.action.VIEW", paramString);
    paramView.putExtra("com.android.browser.application_id", localContext.getPackageName());
    try
    {
      localContext.startActivity(paramView);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      label38:
      break label38;
    }
    paramString = new StringBuilder();
    paramString.append("Activity was not found for intent, ");
    paramString.append(paramView.toString());
    QLog.w("OpenDefaultBrowserQQText", 1, paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.OpenDefaultBrowserQQText.DefaultBrowserLinkSpan
 * JD-Core Version:    0.7.0.1
 */