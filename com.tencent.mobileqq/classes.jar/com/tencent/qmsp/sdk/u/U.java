package com.tencent.qmsp.sdk.u;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.qmsp.sdk.app.QmspSDK;
import com.tencent.qmsp.sdk.base.IVendorCallback;
import com.tencent.qmsp.sdk.base.e;
import java.lang.reflect.Method;

public class U
{
  public static final String BEACON_ID_VERSION = "4.1";
  public static final String COMMIT_HASH = "53696f69307f49d899d265c973a58070e24fb305";
  
  static
  {
    try
    {
      System.loadLibrary("qmp");
      return;
    }
    finally
    {
      localObject.printStackTrace();
      load_so();
    }
  }
  
  public static native String a(Context paramContext, int paramInt, Activity paramActivity, String paramString);
  
  public static native String[] c(int paramInt);
  
  public static void clearContent(Context paramContext)
  {
    e.a(paramContext);
  }
  
  public static void getOAID(IVendorCallback paramIVendorCallback)
  {
    new e().a(paramIVendorCallback);
  }
  
  public static String getOAIDSync(Context paramContext)
  {
    return e.a(paramContext, null, 0);
  }
  
  private static String getP()
  {
    try
    {
      Object localObject1 = Class.forName("com.tencent.beacon.event.open.BeaconReport");
      localObject1 = (String)((Class)localObject1).getDeclaredMethod("getSoPath", new Class[0]).invoke(null, new Object[0]);
      return localObject1;
    }
    finally
    {
      localObject2.printStackTrace();
    }
    return null;
  }
  
  public static boolean getSDKIsAlive()
  {
    return QmspSDK.getSDKIsAlive();
  }
  
  public static void init_o(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    e.a(paramContext, paramBoolean1, paramBoolean2);
  }
  
  private static boolean load_so()
  {
    String str = getP();
    try
    {
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      System.load(str);
      return true;
    }
    finally
    {
      localObject.printStackTrace();
    }
    return false;
  }
  
  public static void setUserID(String paramString)
  {
    QmspSDK.setmUid(paramString);
  }
  
  public static int startQ(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    QmspSDK.setLogcat(paramBoolean);
    return QmspSDK.startQmsp(paramContext, paramString1, paramString2, paramString3, paramString4);
  }
  
  public static void stopQ() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.u.U
 * JD-Core Version:    0.7.0.1
 */