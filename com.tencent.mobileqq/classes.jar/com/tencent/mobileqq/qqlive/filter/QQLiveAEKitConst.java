package com.tencent.mobileqq.qqlive.filter;

import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import mqq.app.MobileQQ;

public class QQLiveAEKitConst
{
  public static final String a;
  private static final String b;
  
  static
  {
    int i;
    if ((MobileQQ.getContext().getExternalFilesDir(null) != null) && (MobileQQ.getContext().getExternalCacheDir() != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      b = MobileQQ.getContext().getExternalFilesDir(null).getPath();
    } else {
      b = MobileQQ.getContext().getFilesDir().getPath();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qqlive/ae/editor/resources");
    a = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.filter.QQLiveAEKitConst
 * JD-Core Version:    0.7.0.1
 */