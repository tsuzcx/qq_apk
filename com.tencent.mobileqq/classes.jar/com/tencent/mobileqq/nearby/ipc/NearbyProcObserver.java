package com.tencent.mobileqq.nearby.ipc;

import android.graphics.Bitmap;
import java.util.List;

public class NearbyProcObserver
  implements INearbyProcObserver
{
  protected void a() {}
  
  protected void a(int paramInt, String paramString) {}
  
  protected void a(int paramInt, String paramString, Bitmap paramBitmap) {}
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 4118)
    {
      if (paramInt != 4131)
      {
        if (paramInt != 4159)
        {
          if (paramInt != 4164)
          {
            if (paramInt != 4161)
            {
              if (paramInt != 4162)
              {
                switch (paramInt)
                {
                default: 
                  return;
                case 4116: 
                  a(((Boolean)paramVarArgs[0]).booleanValue(), null);
                  return;
                case 4115: 
                  a(((Boolean)paramVarArgs[0]).booleanValue(), null);
                  return;
                case 4114: 
                  b(((Boolean)paramVarArgs[0]).booleanValue(), (List)paramVarArgs[1]);
                  return;
                }
                a(((Boolean)paramVarArgs[0]).booleanValue(), (List)paramVarArgs[1]);
                return;
              }
              try
              {
                if (((Integer)paramVarArgs[0]).intValue() == 0)
                {
                  a(((Integer)paramVarArgs[0]).intValue(), (String)paramVarArgs[1]);
                  return;
                }
                b(((Integer)paramVarArgs[0]).intValue(), (String)paramVarArgs[1]);
                return;
              }
              catch (Exception paramVarArgs)
              {
                paramVarArgs.printStackTrace();
                return;
              }
            }
            try
            {
              a(((Integer)paramVarArgs[0]).intValue(), (String)paramVarArgs[1], (Bitmap)paramVarArgs[2]);
              return;
            }
            catch (Exception paramVarArgs)
            {
              paramVarArgs.printStackTrace();
              return;
            }
          }
          try
          {
            a();
            return;
          }
          catch (Exception paramVarArgs)
          {
            paramVarArgs.printStackTrace();
            return;
          }
        }
        b();
        return;
      }
      if (paramVarArgs != null)
      {
        if (paramVarArgs.length != 2) {
          return;
        }
        a(((Integer)paramVarArgs[0]).intValue(), ((Boolean)paramVarArgs[1]).booleanValue());
        return;
      }
      return;
    }
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length != 2) {
        return;
      }
      a((List)paramVarArgs[0], (List)paramVarArgs[1]);
    }
  }
  
  public void a(List<String> paramList1, List<String> paramList2) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  public void a(boolean paramBoolean, List<Long> paramList) {}
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void b() {}
  
  protected void b(int paramInt, String paramString) {}
  
  public void b(boolean paramBoolean, List<Long> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ipc.NearbyProcObserver
 * JD-Core Version:    0.7.0.1
 */