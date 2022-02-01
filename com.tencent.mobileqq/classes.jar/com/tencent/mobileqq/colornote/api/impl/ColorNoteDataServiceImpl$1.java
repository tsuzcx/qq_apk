package com.tencent.mobileqq.colornote.api.impl;

import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import java.util.Comparator;

final class ColorNoteDataServiceImpl$1
  implements Comparator<ColorNote>
{
  public int a(ColorNote paramColorNote1, ColorNote paramColorNote2)
  {
    boolean bool1 = ColorNoteUtils.h(paramColorNote1);
    boolean bool2 = ColorNoteUtils.h(paramColorNote2);
    if ((bool1) && (bool2)) {
      return ColorNoteDataServiceImpl.access$000(paramColorNote1, paramColorNote2);
    }
    if (bool1) {
      return -1;
    }
    if (bool2) {
      return 1;
    }
    bool1 = ColorNoteUtils.d(paramColorNote1);
    bool2 = ColorNoteUtils.d(paramColorNote2);
    if ((bool1) && (bool2)) {
      return ColorNoteDataServiceImpl.access$000(paramColorNote1, paramColorNote2);
    }
    if (bool1) {
      return -1;
    }
    if (bool2) {
      return 1;
    }
    int i = paramColorNote1.getServiceType();
    int j = 0;
    if (i == 16973824) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramColorNote2.getServiceType() == 16973824) {
      j = 1;
    }
    if ((i != 0) && (j != 0)) {
      return ColorNoteDataServiceImpl.access$000(paramColorNote1, paramColorNote2);
    }
    if (i != 0) {
      return -1;
    }
    if (j != 0) {
      return 1;
    }
    return ColorNoteDataServiceImpl.access$000(paramColorNote1, paramColorNote2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.api.impl.ColorNoteDataServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */