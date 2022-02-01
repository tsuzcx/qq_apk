package com.tencent.mobileqq.colornote.settings;

import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.Comparator;

class ColorNoteSettingFragment$3
  implements Comparator<ColorNote>
{
  ColorNoteSettingFragment$3(ColorNoteSettingFragment paramColorNoteSettingFragment) {}
  
  public int a(ColorNote paramColorNote1, ColorNote paramColorNote2)
  {
    return -(int)(paramColorNote1.getTime() - paramColorNote2.getTime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */