package com.tencent.mobileqq.widget;

public class LeftPopupMenuDialog$MenuItem
  implements Comparable
{
  public int a;
  public long a;
  public Object a;
  public String a;
  public int b;
  public String b;
  public int c;
  public int d;
  
  public int a(MenuItem paramMenuItem)
  {
    if (paramMenuItem == null) {}
    do
    {
      return 0;
      if ((paramMenuItem.b > 0) && (this.b == 0)) {
        return 1;
      }
      if ((this.b > 0) && (paramMenuItem.b == 0)) {
        return -1;
      }
      if (paramMenuItem.a > this.a) {
        return 1;
      }
    } while (paramMenuItem.a >= this.a);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.LeftPopupMenuDialog.MenuItem
 * JD-Core Version:    0.7.0.1
 */