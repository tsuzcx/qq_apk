package com.tencent.widget;

import java.util.Formatter;

final class TCWNumberPicker$1
  implements TCWNumberPicker.Formatter
{
  final StringBuilder a = new StringBuilder();
  final Formatter b = new Formatter(this.a);
  final Object[] c = new Object[1];
  
  public String a(int paramInt)
  {
    this.c[0] = Integer.valueOf(paramInt);
    StringBuilder localStringBuilder = this.a;
    localStringBuilder.delete(0, localStringBuilder.length());
    this.b.format("%02d", this.c);
    return this.b.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.TCWNumberPicker.1
 * JD-Core Version:    0.7.0.1
 */