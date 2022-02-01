package com.tencent.mobileqq.util;

import android.content.ClipData;
import android.view.View;
import java.io.File;

class SystemDragUtils$DropItem
{
  ClipData jdField_a_of_type_AndroidContentClipData;
  View jdField_a_of_type_AndroidViewView;
  File jdField_a_of_type_JavaIoFile;
  
  SystemDragUtils$DropItem(File paramFile, View paramView, ClipData paramClipData)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidContentClipData = paramClipData;
  }
  
  boolean a()
  {
    return (this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidContentClipData != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.SystemDragUtils.DropItem
 * JD-Core Version:    0.7.0.1
 */