package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Collection;
import java.util.Iterator;

public class k
{
  private static k.b a;
  private static k.c b;
  private static boolean c = true;
  private static boolean d = true;
  private static k.d e;
  
  public static void a() {}
  
  public static void b()
  {
    if ((c) || (d))
    {
      if (b == null) {
        b = new k.c();
      }
      Handler localHandler = q.b();
      localHandler.removeCallbacks(b);
      localHandler.postDelayed(b, 5000L);
    }
  }
  
  private static void b(StringBuilder paramStringBuilder, Collection paramCollection, int paramInt)
  {
    if ((paramCollection != null) && (paramCollection.size() > 0) && (paramStringBuilder != null))
    {
      String str;
      if (paramInt == 1) {
        str = "  ";
      } else if (paramInt == 2) {
        str = "    ";
      } else if (paramInt == 3) {
        str = "      ";
      } else {
        str = "";
      }
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Object localObject = paramCollection.next();
        if ((localObject instanceof ToServiceMsg))
        {
          localObject = (ToServiceMsg)localObject;
          if (localObject != null)
          {
            paramStringBuilder.append(str);
            paramStringBuilder.append(((ToServiceMsg)localObject).getShortStringForLog());
            paramStringBuilder.append("\n");
          }
        }
        else if ((localObject instanceof FromServiceMsg))
        {
          localObject = (FromServiceMsg)localObject;
          if (localObject != null)
          {
            paramStringBuilder.append(str);
            paramStringBuilder.append(((FromServiceMsg)localObject).getShortStringForLog());
            paramStringBuilder.append("\n");
          }
        }
        else if ((localObject instanceof MsfMessagePair))
        {
          localObject = (MsfMessagePair)localObject;
          if (localObject != null)
          {
            if (((MsfMessagePair)localObject).toServiceMsg != null)
            {
              paramStringBuilder.append(str);
              paramStringBuilder.append(((MsfMessagePair)localObject).toServiceMsg.getShortStringForLog());
              paramStringBuilder.append("\n");
            }
            if (((MsfMessagePair)localObject).fromServiceMsg != null)
            {
              paramStringBuilder.append(str);
              paramStringBuilder.append(((MsfMessagePair)localObject).fromServiceMsg.getShortStringForLog());
              paramStringBuilder.append("\n");
            }
          }
        }
      }
    }
  }
  
  public static void c()
  {
    if (e == null) {
      e = new k.d(null);
    }
    q.b().removeCallbacks(e);
    q.b().postDelayed(e, 60000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.k
 * JD-Core Version:    0.7.0.1
 */