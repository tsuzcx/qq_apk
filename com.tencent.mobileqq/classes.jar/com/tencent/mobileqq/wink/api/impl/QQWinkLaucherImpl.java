package com.tencent.mobileqq.wink.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.wink.QQWinkLaucher;
import com.tencent.mobileqq.wink.api.IQQWinkLaucher;

public class QQWinkLaucherImpl
  implements IQQWinkLaucher
{
  public void jumpToPreviewFragment(Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2)
  {
    QQWinkLaucher.b(paramContext, paramIntent, paramString1, paramInt, paramString2);
  }
  
  public void jumpToWinkCamera(Context paramContext, Intent paramIntent, String paramString)
  {
    QQWinkLaucher.b(paramContext, paramIntent, paramString);
  }
  
  public void jumpToWinkCoverEditor(Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2)
  {
    QQWinkLaucher.a(paramContext, paramIntent, paramString1, paramInt, paramString2);
  }
  
  public void jumpToWinkEditor(Context paramContext, Intent paramIntent, String paramString)
  {
    QQWinkLaucher.d(paramContext, paramIntent, paramString);
  }
  
  public void jumpToWinkPick(Context paramContext, Intent paramIntent, String paramString)
  {
    QQWinkLaucher.a(paramContext, paramIntent, paramString);
  }
  
  public void jumpToWinkPublish(Context paramContext, Intent paramIntent, String paramString)
  {
    QQWinkLaucher.c(paramContext, paramIntent, paramString);
  }
  
  public void preloadWink(Context paramContext)
  {
    QQWinkLaucher.a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.api.impl.QQWinkLaucherImpl
 * JD-Core Version:    0.7.0.1
 */