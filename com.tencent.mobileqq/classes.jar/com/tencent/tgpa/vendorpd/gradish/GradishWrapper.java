package com.tencent.tgpa.vendorpd.gradish;

import android.content.Context;
import android.util.Log;
import com.tencent.tgpa.vendorpd.a.a;

public class GradishWrapper
{
  private static final String TAG = "TGPA";
  private static String uniqueID;
  private static String uniqueIDL2;
  
  static
  {
    try
    {
      System.loadLibrary("gradishwrapper");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Log.e("TGPA", "load gradish wrapper lib failed!!!");
    }
  }
  
  private static synchronized native String dbg();
  
  public static String getCommonUniqueID()
  {
    if (uniqueID == null) {
      produceIDL1(a.a());
    }
    return uniqueID;
  }
  
  public static String getCommonUniqueID2WithoutFlag()
  {
    if (!isGradishEnable()) {
      return "-13";
    }
    String str = getCommonUniqueIDL2();
    if (str == null) {
      return "-11";
    }
    if (str.length() != 66) {
      return "-12";
    }
    return str.substring(2);
  }
  
  public static String getCommonUniqueIDL2()
  {
    if (uniqueIDL2 == null) {
      produceIDL2(a.a());
    }
    return uniqueIDL2;
  }
  
  public static String getCommonUniqueIDWithoutFlag()
  {
    if (!isGradishEnable()) {
      return "-13";
    }
    String str = getCommonUniqueID();
    if (str == null) {
      return "-11";
    }
    if (str.length() != 66) {
      return "-12";
    }
    return str.substring(2);
  }
  
  public static String getDebugID()
  {
    if (isGradishDebugIDEnable()) {
      try
      {
        String str = dbg();
        return str;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
    return "-13";
  }
  
  public static String getFlag1()
  {
    String str = getCommonUniqueID();
    if ((str != null) && (str.length() == 66)) {
      return str.substring(0, 1);
    }
    return "-1";
  }
  
  public static String getFlag2()
  {
    String str = getCommonUniqueID();
    if ((str != null) && (str.length() == 66)) {
      return str.substring(1, 2);
    }
    return "-1";
  }
  
  public static String getFlagL2()
  {
    String str = getCommonUniqueIDL2();
    if ((str != null) && (str.length() == 66)) {
      return str.substring(0, 2);
    }
    return "-1";
  }
  
  public static String getOAID(int paramInt)
  {
    if (isGradishEnable()) {
      try
      {
        String str = goa(a.a(), paramInt);
        return str;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
    return "-13";
  }
  
  private static synchronized native String goa(Context paramContext, int paramInt);
  
  public static boolean isGradishDebugIDEnable()
  {
    return true;
  }
  
  public static boolean isGradishEnable()
  {
    return true;
  }
  
  private static void produceIDL1(Context paramContext)
  {
    if (uniqueID == null) {}
    try
    {
      uniqueID = yje(paramContext);
      return;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private static void produceIDL2(Context paramContext)
  {
    if (uniqueIDL2 == null) {}
    try
    {
      uniqueIDL2 = zkf(paramContext);
      return;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private static synchronized native String yje(Context paramContext);
  
  private static synchronized native String zkf(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.gradish.GradishWrapper
 * JD-Core Version:    0.7.0.1
 */