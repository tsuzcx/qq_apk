package com.tencent.mobileqq.flashshow.api.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.flashshow.api.IFSQQBaseService;
import com.tencent.mobileqq.flashshow.api.hybird.FSHybirdFragment;
import com.tencent.mobileqq.flashshow.api.hybird.FSHybirdStyleFactory;
import com.tencent.mobileqq.flashshow.api.hybird.FSPublishHybirdFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class FSQQBaseServiceImpl
  implements IFSQQBaseService
{
  private static final String TAG = "FSQQBaseServiceImpl";
  private ConditionSearchManager mSearchManager;
  
  public Intent handleFSHybirdActivityIntent(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("FSQQBaseServiceImpl", 1, "handleFSHybirdActivityIntent url isEmpty");
      return paramIntent;
    }
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = MobileQQ.sMobileQQ.getApplicationContext();
    }
    paramContext = paramIntent;
    if (paramIntent == null) {
      paramContext = new Intent();
    }
    paramContext.putExtra("url", paramString);
    FSHybirdStyleFactory.a(paramContext, paramString);
    paramContext.putExtra("titleBarStyle", 5);
    paramContext.putExtra("titleStyle", FSHybirdStyleFactory.a().a(localContext, paramString));
    if (FSHybirdStyleFactory.a(paramString))
    {
      paramContext.putExtra("fromOneCLickCLose", false);
      paramContext.setClass(localContext, QQTranslucentBrowserActivity.class);
    }
    else
    {
      paramContext.putExtra("fromOneCLickCLose", true);
      paramContext.setClass(localContext, QQBrowserActivity.class);
    }
    paramContext.putExtra("fragment_class", FSHybirdFragment.class.getCanonicalName());
    if (paramInt != -1)
    {
      paramContext.putExtra("fragment_class", FSHybirdFragment.class.getCanonicalName());
      return paramContext;
    }
    paramContext.addFlags(268435456);
    return paramContext;
  }
  
  public Intent handleFSPublishHybirdActivityIntent(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("FSQQBaseServiceImpl", 1, "handleFSHybirdActivityIntent url isEmpty");
      return paramIntent;
    }
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = MobileQQ.sMobileQQ.getApplicationContext();
    }
    paramContext = paramIntent;
    if (paramIntent == null) {
      paramContext = new Intent();
    }
    paramContext.putExtra("url", paramString);
    FSHybirdStyleFactory.a(paramContext, paramString);
    paramContext.putExtra("titleBarStyle", 6);
    paramContext.putExtra("titleStyle", FSHybirdStyleFactory.a().a(localContext, paramString));
    if (FSHybirdStyleFactory.a(paramString))
    {
      paramContext.putExtra("fromOneCLickCLose", false);
      paramContext.setClass(localContext, QQTranslucentBrowserActivity.class);
    }
    else
    {
      paramContext.putExtra("fromOneCLickCLose", true);
      paramContext.setClass(localContext, QQBrowserActivity.class);
    }
    paramContext.putExtra("fragment_class", FSPublishHybirdFragment.class.getCanonicalName());
    if (paramInt != -1)
    {
      paramContext.putExtra("fragment_class", FSPublishHybirdFragment.class.getCanonicalName());
      return paramContext;
    }
    paramContext.addFlags(268435456);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.impl.FSQQBaseServiceImpl
 * JD-Core Version:    0.7.0.1
 */