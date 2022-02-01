package com.tencent.mobileqq.confess;

import com.tencent.mobileqq.app.BusinessObserver;

public class ConfessObserver
  implements BusinessObserver
{
  public void a(ConfessConfig paramConfessConfig) {}
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean1, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, ConfessInfo paramConfessInfo) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  a(paramBoolean, paramObject);
                  return;
                  b(paramBoolean, paramObject);
                  return;
                } while ((paramObject == null) || (!(paramObject instanceof Object[])));
                paramObject = (Object[])paramObject;
              } while ((paramObject == null) || (paramObject.length != 6));
              a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), (String)paramObject[4], (ConfessInfo)paramObject[5]);
              return;
            } while ((paramObject == null) || (!(paramObject instanceof ConfessConfig)));
            a((ConfessConfig)paramObject);
            return;
          } while (!(paramObject instanceof Object[]));
          paramObject = (Object[])paramObject;
        } while (paramObject.length < 7);
        a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), ((Boolean)paramObject[6]).booleanValue());
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length < 3);
    a((String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessObserver
 * JD-Core Version:    0.7.0.1
 */