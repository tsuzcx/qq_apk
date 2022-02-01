package com.tencent.richmediabrowser.api;

import com.tencent.richmediabrowser.api.depend.IBrowserProvider;
import com.tencent.richmediabrowser.core.IDecoratorMvpFactory;
import com.tencent.richmediabrowser.core.IMvpFactory;
import com.tencent.richmediabrowser.listener.IBrowserAnimationListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.BrowserAnimation;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import java.util.HashMap;

public class BrowserParamsBuilder
{
  public IMvpFactory a;
  public IDecoratorMvpFactory b;
  public HashMap<Integer, Integer> c = new HashMap();
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  private IBrowserAnimationListener g;
  private IBrowserProvider h;
  
  public IBrowserProvider a()
  {
    return this.h;
  }
  
  public BrowserAnimation a(RichMediaBaseData paramRichMediaBaseData)
  {
    IBrowserAnimationListener localIBrowserAnimationListener = this.g;
    if (localIBrowserAnimationListener != null) {
      return localIBrowserAnimationListener.getBrowserAnimation(paramRichMediaBaseData);
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void a(IBrowserProvider paramIBrowserProvider)
  {
    this.h = paramIBrowserProvider;
  }
  
  public void a(IDecoratorMvpFactory paramIDecoratorMvpFactory)
  {
    this.b = paramIDecoratorMvpFactory;
  }
  
  public void a(IMvpFactory paramIMvpFactory)
  {
    this.a = paramIMvpFactory;
  }
  
  public void a(IBrowserAnimationListener paramIBrowserAnimationListener)
  {
    this.g = paramIBrowserAnimationListener;
  }
  
  public void a(IBrowserLog paramIBrowserLog)
  {
    BrowserLogHelper.getInstance().setLogProxy(paramIBrowserLog);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.api.BrowserParamsBuilder
 * JD-Core Version:    0.7.0.1
 */