package com.tencent.mobileqq.util;

import android.content.ClipData;
import android.view.View;
import java.io.File;

class SystemDragUtils$DropItem
{
  File a;
  View b;
  ClipData c;
  
  SystemDragUtils$DropItem(File paramFile, View paramView, ClipData paramClipData)
  {
    this.a = paramFile;
    this.b = paramView;
    this.c = paramClipData;
  }
  
  boolean a()
  {
    return (this.a.exists()) && (this.b != null) && (this.c != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.SystemDragUtils.DropItem
 * JD-Core Version:    0.7.0.1
 */