package de.robv.android.xposed.callbacks;

public abstract class XC_LayoutInflated
  extends XCallback
{
  public XC_LayoutInflated() {}
  
  public XC_LayoutInflated(int paramInt)
  {
    super(paramInt);
  }
  
  protected void call(XCallback.Param paramParam)
  {
    if ((paramParam instanceof XC_LayoutInflated.LayoutInflatedParam)) {
      handleLayoutInflated((XC_LayoutInflated.LayoutInflatedParam)paramParam);
    }
  }
  
  public abstract void handleLayoutInflated(XC_LayoutInflated.LayoutInflatedParam paramLayoutInflatedParam);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.callbacks.XC_LayoutInflated
 * JD-Core Version:    0.7.0.1
 */