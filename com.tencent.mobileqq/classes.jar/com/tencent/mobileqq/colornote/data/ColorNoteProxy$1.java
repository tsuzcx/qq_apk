package com.tencent.mobileqq.colornote.data;

import java.util.Comparator;

class ColorNoteProxy$1
  implements Comparator<ColorNote>
{
  ColorNoteProxy$1(ColorNoteProxy paramColorNoteProxy) {}
  
  public int a(ColorNote paramColorNote1, ColorNote paramColorNote2)
  {
    int j = 0;
    int k = 1;
    boolean bool1 = ColorNoteUtils.c(paramColorNote1);
    boolean bool2 = ColorNoteUtils.c(paramColorNote2);
    int i;
    if ((bool1) && (bool2)) {
      i = ColorNoteProxy.a(this.a, paramColorNote1, paramColorNote2);
    }
    do
    {
      do
      {
        do
        {
          return i;
          if (bool1) {
            return -1;
          }
          i = k;
        } while (bool2);
        bool1 = ColorNoteUtils.b(paramColorNote1);
        bool2 = ColorNoteUtils.b(paramColorNote2);
        if ((bool1) && (bool2)) {
          return ColorNoteProxy.a(this.a, paramColorNote1, paramColorNote2);
        }
        if (bool1) {
          return -1;
        }
        i = k;
      } while (bool2);
      if (paramColorNote1.getServiceType() == 16973824) {}
      for (i = 1;; i = 0)
      {
        if (paramColorNote2.getServiceType() == 16973824) {
          j = 1;
        }
        if ((i == 0) || (j == 0)) {
          break;
        }
        return ColorNoteProxy.a(this.a, paramColorNote1, paramColorNote2);
      }
      if (i != 0) {
        return -1;
      }
      i = k;
    } while (j != 0);
    return ColorNoteProxy.a(this.a, paramColorNote1, paramColorNote2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.data.ColorNoteProxy.1
 * JD-Core Version:    0.7.0.1
 */