package com.tencent.mobileqq.search.util;

import com.tencent.mobileqq.persistence.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class PAOfflineSearchManager
{
  static PAOfflineSearchManager b;
  ArrayList<Entity> a = null;
  public boolean c = true;
  public boolean d = true;
  String e = "0";
  AtomicBoolean f = new AtomicBoolean(false);
  boolean g = false;
  HashMap<String, Integer> h = new HashMap();
  
  public static PAOfflineSearchManager a()
  {
    try
    {
      if (b == null) {
        b = new PAOfflineSearchManager();
      }
      PAOfflineSearchManager localPAOfflineSearchManager = b;
      return localPAOfflineSearchManager;
    }
    finally {}
  }
  
  public boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (this.h == null) {
      this.h = new HashMap();
    }
    return this.h.containsKey(paramString);
  }
  
  public void b()
  {
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.PAOfflineSearchManager
 * JD-Core Version:    0.7.0.1
 */