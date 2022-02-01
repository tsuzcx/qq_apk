package de.robv.android.xposed.callbacks;

import android.content.res.XResources;

public class XC_LayoutInflated$Unhook
  implements IXUnhook<XC_LayoutInflated>
{
  private final int id;
  private final String resDir;
  
  public XC_LayoutInflated$Unhook(XC_LayoutInflated paramXC_LayoutInflated, String paramString, int paramInt)
  {
    this.resDir = paramString;
    this.id = paramInt;
  }
  
  public XC_LayoutInflated getCallback()
  {
    return this.this$0;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public void unhook()
  {
    XResources.unhookLayout(this.resDir, this.id, this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.callbacks.XC_LayoutInflated.Unhook
 * JD-Core Version:    0.7.0.1
 */