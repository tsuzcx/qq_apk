package cooperation.vip.webview.controller;

public class VipGeneralPopupWndHelper$ClickedPoint
{
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public VipGeneralPopupWndHelper$ClickedPoint(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.f = paramInt1;
    this.e = paramInt2;
    this.b = paramInt3;
    this.a = paramInt4;
    this.c = paramInt5;
    this.d = paramInt6;
  }
  
  public int a()
  {
    return this.f;
  }
  
  public int b()
  {
    return this.e;
  }
  
  public int c()
  {
    return this.c - this.b;
  }
  
  public int d()
  {
    return this.d - this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.webview.controller.VipGeneralPopupWndHelper.ClickedPoint
 * JD-Core Version:    0.7.0.1
 */