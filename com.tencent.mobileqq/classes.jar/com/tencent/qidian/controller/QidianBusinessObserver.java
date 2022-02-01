package com.tencent.qidian.controller;

import com.tencent.qidian.data.PubAccountNavigationMenu;
import java.util.HashMap;

public class QidianBusinessObserver
  extends QidianBusinessObserverBase
{
  private static final String a = "com.tencent.qidian.controller.QidianBusinessObserver";
  public int b = hashCode();
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, QidianHandler.NavigationMenuConfig paramNavigationMenuConfig) {}
  
  protected void a(boolean paramBoolean, PubAccountNavigationMenu paramPubAccountNavigationMenu) {}
  
  protected void a(boolean paramBoolean, HashMap<String, Object> paramHashMap) {}
  
  protected void b(boolean paramBoolean, HashMap<String, Object> paramHashMap) {}
  
  protected void c(boolean paramBoolean, HashMap<String, Object> paramHashMap) {}
  
  protected void d(boolean paramBoolean, HashMap<String, Object> paramHashMap) {}
  
  protected void e(boolean paramBoolean, HashMap<String, Object> paramHashMap) {}
  
  protected void f(boolean paramBoolean, HashMap<String, Object> paramHashMap) {}
  
  protected void g(boolean paramBoolean, HashMap<String, Object> paramHashMap) {}
  
  protected void h(boolean paramBoolean, HashMap<String, Object> paramHashMap) {}
  
  protected void i(boolean paramBoolean, HashMap<String, Object> paramHashMap) {}
  
  protected void j(boolean paramBoolean, HashMap<String, Object> paramHashMap) {}
  
  protected void k(boolean paramBoolean, HashMap<String, Object> paramHashMap) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1018)
    {
      if (paramInt != 1019)
      {
        if (paramInt != 2001)
        {
          if (paramInt != 3001)
          {
            switch (paramInt)
            {
            default: 
              return;
            case 1010: 
              h(paramBoolean, (HashMap)paramObject);
              return;
            case 1009: 
              b(paramBoolean, (HashMap)paramObject);
              return;
            case 1008: 
              e(paramBoolean, (HashMap)paramObject);
              return;
            case 1007: 
              j(paramBoolean, (HashMap)paramObject);
              return;
            case 1006: 
              if (paramObject != null)
              {
                a(paramBoolean, (QidianHandler.NavigationMenuConfig)paramObject);
                return;
              }
              a(paramBoolean, null);
              return;
            case 1005: 
              c(paramBoolean, (HashMap)paramObject);
              return;
            case 1004: 
              i(paramBoolean, (HashMap)paramObject);
              return;
            case 1003: 
              g(paramBoolean, (HashMap)paramObject);
              return;
            case 1002: 
              f(paramBoolean, (HashMap)paramObject);
              return;
            }
            d(paramBoolean, (HashMap)paramObject);
            return;
          }
          a(paramBoolean, (PubAccountNavigationMenu)paramObject);
          return;
        }
        a(paramBoolean);
      }
    }
    else {
      a(paramBoolean, (HashMap)paramObject);
    }
    k(paramBoolean, (HashMap)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.controller.QidianBusinessObserver
 * JD-Core Version:    0.7.0.1
 */