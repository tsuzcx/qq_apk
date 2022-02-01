package com.tencent.mobileqq.qqguildsdk.wrapper;

import java.util.Observable;

public class GPSNotifyCenter
  extends Observable
{
  public void a(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, Object paramObject1, Object paramObject2)
  {
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(paramInt1), paramString1, { Integer.valueOf(paramInt2), paramString2, paramString3, paramObject1, paramObject2 } });
  }
  
  public void a(int paramInt, String paramString, Object paramObject)
  {
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(paramInt), paramString, { paramObject } });
  }
  
  public void a(int paramInt, String paramString, Object paramObject1, Object paramObject2)
  {
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(paramInt), paramString, { paramObject1, paramObject2 } });
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Object paramObject)
  {
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(paramInt), paramString1, { paramString2, paramObject } });
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Object paramObject1, Object paramObject2)
  {
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(paramInt), paramString1, { paramString2, paramObject1, paramObject2 } });
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(paramInt), paramString1, { paramString2, paramObject1, paramObject2, paramObject3 } });
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(paramInt), paramString1, { paramString2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5 } });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GPSNotifyCenter
 * JD-Core Version:    0.7.0.1
 */