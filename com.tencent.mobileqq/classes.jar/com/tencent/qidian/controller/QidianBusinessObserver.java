package com.tencent.qidian.controller;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import java.util.HashMap;

public class QidianBusinessObserver
  implements BusinessObserver
{
  private static final String a = QidianBusinessObserver.class.getName();
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, QidianHandler.NavigationMenuConfig paramNavigationMenuConfig) {}
  
  public void a(boolean paramBoolean, PubAccountNavigationMenu paramPubAccountNavigationMenu) {}
  
  public void a(boolean paramBoolean, HashMap paramHashMap) {}
  
  public void b(boolean paramBoolean, HashMap paramHashMap) {}
  
  public void c(boolean paramBoolean, HashMap paramHashMap) {}
  
  public void d(boolean paramBoolean, HashMap paramHashMap) {}
  
  public void e(boolean paramBoolean, HashMap paramHashMap) {}
  
  public void f(boolean paramBoolean, HashMap paramHashMap) {}
  
  public void g(boolean paramBoolean, HashMap paramHashMap) {}
  
  public void h(boolean paramBoolean, HashMap paramHashMap) {}
  
  public void i(boolean paramBoolean, HashMap paramHashMap) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1001: 
      d(paramBoolean, (HashMap)paramObject);
      return;
    case 1002: 
      e(paramBoolean, (HashMap)paramObject);
      return;
    case 1003: 
      f(paramBoolean, (HashMap)paramObject);
      return;
    case 1004: 
      h(paramBoolean, (HashMap)paramObject);
      return;
    case 1005: 
      c(paramBoolean, (HashMap)paramObject);
      return;
    case 1006: 
      if (paramObject != null)
      {
        a(paramBoolean, (QidianHandler.NavigationMenuConfig)paramObject);
        return;
      }
      a(paramBoolean, null);
      return;
    case 2001: 
      a(paramBoolean);
      return;
    case 3001: 
      a(paramBoolean, (PubAccountNavigationMenu)paramObject);
      return;
    case 1007: 
      i(paramBoolean, (HashMap)paramObject);
      return;
    case 1008: 
      b(paramBoolean, (HashMap)paramObject);
      return;
    case 1009: 
      a(paramBoolean, (HashMap)paramObject);
      return;
    }
    g(paramBoolean, (HashMap)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.qidian.controller.QidianBusinessObserver
 * JD-Core Version:    0.7.0.1
 */