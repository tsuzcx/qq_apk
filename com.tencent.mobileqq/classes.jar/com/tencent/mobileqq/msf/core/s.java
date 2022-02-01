package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Collection;
import java.util.Iterator;

public class s
{
  private static s.b a = null;
  private static s.c b = null;
  private static boolean c = true;
  private static boolean d = true;
  private static s.d e = null;
  
  public static void a() {}
  
  public static void b()
  {
    if ((c) || (d))
    {
      if (b == null) {
        b = new s.c();
      }
      Handler localHandler = x.b();
      localHandler.removeCallbacks(b);
      localHandler.postDelayed(b, 5000L);
    }
  }
  
  private static void b(StringBuilder paramStringBuilder, Collection paramCollection, int paramInt)
  {
    String str;
    if ((paramCollection != null) && (paramCollection.size() > 0) && (paramStringBuilder != null)) {
      if (paramInt == 1) {
        str = "  ";
      }
    }
    for (;;)
    {
      paramCollection = paramCollection.iterator();
      for (;;)
      {
        if (!paramCollection.hasNext()) {
          break label238;
        }
        Object localObject = paramCollection.next();
        if ((localObject instanceof ToServiceMsg))
        {
          localObject = (ToServiceMsg)localObject;
          if (localObject == null) {
            continue;
          }
          paramStringBuilder.append(str).append(((ToServiceMsg)localObject).getShortStringForLog()).append("\n");
          continue;
          if (paramInt == 2)
          {
            str = "    ";
            break;
          }
          if (paramInt != 3) {
            break label239;
          }
          str = "      ";
          break;
        }
        if ((localObject instanceof FromServiceMsg))
        {
          localObject = (FromServiceMsg)localObject;
          if (localObject != null) {
            paramStringBuilder.append(str).append(((FromServiceMsg)localObject).getShortStringForLog()).append("\n");
          }
        }
        else if ((localObject instanceof MsfMessagePair))
        {
          localObject = (MsfMessagePair)localObject;
          if (localObject != null)
          {
            if (((MsfMessagePair)localObject).toServiceMsg != null) {
              paramStringBuilder.append(str).append(((MsfMessagePair)localObject).toServiceMsg.getShortStringForLog()).append("\n");
            }
            if (((MsfMessagePair)localObject).fromServiceMsg != null) {
              paramStringBuilder.append(str).append(((MsfMessagePair)localObject).fromServiceMsg.getShortStringForLog()).append("\n");
            }
          }
        }
      }
      label238:
      return;
      label239:
      str = "";
    }
  }
  
  public static void c()
  {
    if (e == null) {
      e = new s.d(null);
    }
    x.b().removeCallbacks(e);
    x.b().postDelayed(e, 60000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.s
 * JD-Core Version:    0.7.0.1
 */