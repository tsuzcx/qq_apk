package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.graphics.Color;

class TavColor
{
  final int a;
  final int b;
  final int c;
  final int d;
  
  TavColor(int paramInt)
  {
    this.d = (paramInt >> 24);
    this.a = ((0xFF0000 & paramInt) >> 16);
    this.b = ((0xFF00 & paramInt) >> 8);
    this.c = (paramInt & 0xFF);
  }
  
  TavColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  int a()
  {
    int i = this.d;
    if (i < 0) {
      return Color.rgb(this.a, this.b, this.c);
    }
    return Color.argb(i, this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavColor
 * JD-Core Version:    0.7.0.1
 */