package com.tencent.mobileqq.litelivesdk.api.customized;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.ilive.base.bizmodule.BaseBizModule;
import com.tencent.mobileqq.litelivesdk.framework.customizedmgr.SDKPageBizModuleType;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseSDKPageBizBootModules
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private List<BaseBizModule> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private List<BaseBizModule> b = new ArrayList();
  private List<BaseBizModule> c = new ArrayList();
  
  public final ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public final List<? extends BaseBizModule> a()
  {
    return this.c;
  }
  
  public abstract void a();
  
  public abstract void a(Context paramContext);
  
  protected final void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  protected final <T extends BaseBizModule> void a(SDKPageBizModuleType paramSDKPageBizModuleType, T paramT)
  {
    if (paramSDKPageBizModuleType == SDKPageBizModuleType.Normal)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramT);
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
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final List<? extends BaseBizModule> b()
  {
    return this.b;
  }
  
  public abstract void b();
  
  public final List<? extends BaseBizModule> c()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public abstract void c();
  
  public abstract void d();
  
  public void e()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.b.clear();
    this.c.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.api.customized.BaseSDKPageBizBootModules
 * JD-Core Version:    0.7.0.1
 */