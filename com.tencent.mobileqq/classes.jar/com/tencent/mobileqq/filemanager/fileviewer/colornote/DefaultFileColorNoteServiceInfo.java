package com.tencent.mobileqq.filemanager.fileviewer.colornote;

import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.Builder;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.qphone.base.util.QLog;

public class DefaultFileColorNoteServiceInfo
  implements IServiceInfo
{
  public ColorNote getColorNote()
  {
    ColorNote.Builder localBuilder = new ColorNote.Builder();
    localBuilder.a(17039360);
    String str = QFileUtils.a(-1, "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getColorNote: file colorNote key [");
      localStringBuilder.append(str);
      localStringBuilder.append("]");
      QLog.i("DefaultFileColorNoteServiceInfo", 2, localStringBuilder.toString());
    }
    localBuilder.a(str);
    localBuilder.b("default_file");
    localBuilder.c("0MB");
    localBuilder.d("resdrawable://2130845755");
    return localBuilder.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.colornote.DefaultFileColorNoteServiceInfo
 * JD-Core Version:    0.7.0.1
 */