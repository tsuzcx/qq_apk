package com.tencent.tgpa.vendorpd.gradish;

import android.content.Context;
import com.tencent.tgpa.vendorpd.GamePredownloader.LibLoader;
import com.tencent.tgpa.vendorpd.b.a;
import com.tencent.tgpa.vendorpd.b.f;

public class GradishWrapper
{
  private static boolean sIsSupportGradishWrapper = false;
  private static String xid;
  
  private static synchronized native String dbg();
  
  public static String getAESIVParameter()
  {
    if (tryLoadLibrary()) {
      return getIVParameter();
    }
    return null;
  }
  
  public static String getAESKey()
  {
    if (tryLoadLibrary()) {
      return getKey();
    }
    return null;
  }
  
  private static synchronized native String getIVParameter();
  
  private static synchronized native String getKey();
  
  private static String getL2ID()
  {
    if (tryLoadLibrary())
    {
      if (a.a() == null) {
        return "-10";
      }
      String str = zkf(a.a());
      if (str == null) {
        return "-11";
      }
      if (str.length() != 66) {
        return "-12";
      }
      xid = str.substring(2);
      return xid;
    }
    return "-9";
  }
  
  public static String getLibraryName()
  {
    return "gradishwrapper";
  }
  
  public static String getOAID(Context paramContext, int paramInt)
  {
    return goa(paramContext, paramInt);
  }
  
  public static String getXID()
  {
    String str = xid;
    if (str != null) {
      return str;
    }
    return getL2ID();
  }
  
  private static synchronized native String goa(Context paramContext, int paramInt);
  
  public static void tryLoadLibrary(GamePredownloader.LibLoader paramLibLoader)
  {
    if ((paramLibLoader != null) && (paramLibLoader.loadLibrary(getLibraryName())))
    {
      sIsSupportGradishWrapper = true;
      f.a("load tgpa gradishwrapper lib success by loader.");
      return;
    }
    tryLoadLibrary();
  }
  
  private static boolean tryLoadLibrary()
  {
    if (sIsSupportGradishWrapper) {
      return true;
    }
    if (LibraryLoaderHelper.loadLibrary(a.a(), getLibraryName()))
    {
      sIsSupportGradishWrapper = true;
      f.a("load tgpa gradishwrapper lib success by default.");
      return true;
    }
    f.d("load tgpa gradishwrapper lib failed by default!!!");
    return false;
  }
  
  private static synchronized native String yje(Context paramContext);
  
  private static synchronized native String zkf(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.gradish.GradishWrapper
 * JD-Core Version:    0.7.0.1
 */