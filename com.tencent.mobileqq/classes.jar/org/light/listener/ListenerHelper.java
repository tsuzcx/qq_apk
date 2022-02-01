package org.light.listener;

public abstract class ListenerHelper
{
  public AIDataListener aiDataListener;
  public TipsListener tipsListener;
  
  public abstract void onTipsNeedHide(String paramString1, String paramString2, int paramInt);
  
  public abstract void onTipsNeedShow(String paramString1, String paramString2, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.listener.ListenerHelper
 * JD-Core Version:    0.7.0.1
 */