package com.tencent.mobileqq.litelivesdk.api.customized;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.ilive.base.bizmodule.BaseBizModule;
import com.tencent.mobileqq.litelivesdk.framework.customizedmgr.SDKPageBizModuleType;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseSDKPageBizBootModules
{
  private List<BaseBizModule> a = new ArrayList();
  private List<BaseBizModule> b = new ArrayList();
  private List<BaseBizModule> c = new ArrayList();
  private ViewGroup d;
  private boolean e = false;
  private BaseSDKPageBizBootModules.GetEnterRoomExtDataCallback f;
  
  public Object a(String paramString)
  {
    BaseSDKPageBizBootModules.GetEnterRoomExtDataCallback localGetEnterRoomExtDataCallback = this.f;
    if (localGetEnterRoomExtDataCallback != null) {
      return localGetEnterRoomExtDataCallback.a(paramString);
    }
    return Integer.valueOf(0);
  }
  
  public abstract void a();
  
  public abstract void a(Context paramContext);
  
  protected final void a(ViewGroup paramViewGroup)
  {
    this.d = paramViewGroup;
  }
  
  public void a(BaseSDKPageBizBootModules.GetEnterRoomExtDataCallback paramGetEnterRoomExtDataCallback)
  {
    this.f = paramGetEnterRoomExtDataCallback;
  }
  
  protected final <T extends BaseBizModule> void a(SDKPageBizModuleType paramSDKPageBizModuleType, T paramT)
  {
    if (paramSDKPageBizModuleType == SDKPageBizModuleType.Normal)
    {
      this.a.add(paramT);
      return;
    }
    if (paramSDKPageBizModuleType == SDKPageBizModuleType.Top)
    {
      this.b.add(paramT);
      return;
    }
    this.c.add(paramT);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  public void e()
  {
    this.a.clear();
    this.b.clear();
    this.c.clear();
  }
  
  public final ViewGroup f()
  {
    return this.d;
  }
  
  public final List<? extends BaseBizModule> g()
  {
    return this.c;
  }
  
  public final List<? extends BaseBizModule> h()
  {
    return this.b;
  }
  
  public final List<? extends BaseBizModule> i()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.api.customized.BaseSDKPageBizBootModules
 * JD-Core Version:    0.7.0.1
 */