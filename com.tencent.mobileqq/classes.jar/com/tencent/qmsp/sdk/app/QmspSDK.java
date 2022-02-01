package com.tencent.qmsp.sdk.app;

import android.content.Context;
import com.tencent.qmsp.sdk.a.c;
import com.tencent.qmsp.sdk.f.g;

public class QmspSDK
  extends a
{
  public static String getQmspVer()
  {
    return c.d();
  }
  
  public static boolean getSDKIsAlive()
  {
    if (a.getTaskStatus()) {
      return b.e().a();
    }
    return false;
  }
  
  public static int sendCmdToLib(int paramInt1, int paramInt2, int paramInt3, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    return com.tencent.qmsp.sdk.c.f.i().a(paramInt1, paramInt2, paramInt3, paramArrayOfObject1, paramArrayOfObject2);
  }
  
  public static void setLogcat(boolean paramBoolean)
  {
    g.a(paramBoolean);
  }
  
  public static int startQmsp(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return a.login(paramContext, paramString1, paramString2, paramString3, paramString4);
  }
  
  public static int startQmsp(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, com.tencent.qmsp.sdk.b.f paramf)
  {
    return a.login(paramContext, paramString1, paramString2, paramString3, paramString4, paramf);
  }
  
  public static void stopQmsp() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.app.QmspSDK
 * JD-Core Version:    0.7.0.1
 */