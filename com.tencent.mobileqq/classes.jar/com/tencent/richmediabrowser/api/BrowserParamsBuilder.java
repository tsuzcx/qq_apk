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
  private IBrowserProvider jdField_a_of_type_ComTencentRichmediabrowserApiDependIBrowserProvider;
  public IDecoratorMvpFactory a;
  public IMvpFactory a;
  private IBrowserAnimationListener jdField_a_of_type_ComTencentRichmediabrowserListenerIBrowserAnimationListener;
  public HashMap<Integer, Integer> a;
  public boolean a;
  public boolean b = false;
  public boolean c = false;
  
  public BrowserParamsBuilder()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public IBrowserProvider a()
  {
    return this.jdField_a_of_type_ComTencentRichmediabrowserApiDependIBrowserProvider;
  }
  
  public BrowserAnimation a(RichMediaBaseData paramRichMediaBaseData)
  {
    IBrowserAnimationListener localIBrowserAnimationListener = this.jdField_a_of_type_ComTencentRichmediabrowserListenerIBrowserAnimationListener;
    if (localIBrowserAnimationListener != null) {
      return localIBrowserAnimationListener.getBrowserAnimation(paramRichMediaBaseData);
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void a(IBrowserProvider paramIBrowserProvider)
  {
    this.jdField_a_of_type_ComTencentRichmediabrowserApiDependIBrowserProvider = paramIBrowserProvider;
  }
  
  public void a(IDecoratorMvpFactory paramIDecoratorMvpFactory)
  {
    this.jdField_a_of_type_ComTencentRichmediabrowserCoreIDecoratorMvpFactory = paramIDecoratorMvpFactory;
  }
  
  public void a(IMvpFactory paramIMvpFactory)
  {
    this.jdField_a_of_type_ComTencentRichmediabrowserCoreIMvpFactory = paramIMvpFactory;
  }
  
  public void a(IBrowserAnimationListener paramIBrowserAnimationListener)
  {
    this.jdField_a_of_type_ComTencentRichmediabrowserListenerIBrowserAnimationListener = paramIBrowserAnimationListener;
  }
  
  public void a(IBrowserLog paramIBrowserLog)
  {
    BrowserLogHelper.getInstance().setLogProxy(paramIBrowserLog);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.api.BrowserParamsBuilder
 * JD-Core Version:    0.7.0.1
 */