package com.tencent.mobileqq.wink.edit.base;

import android.content.Context;
import com.tencent.mobileqq.wink.QQWinkEnvironment;
import java.io.File;

public class AEPathBase
{
  protected static final String a;
  protected static final String b;
  protected static final String c = QQWinkEnvironment.a().getFilesDir().getParent();
  protected static final String d = QQWinkEnvironment.a().getCacheDir().getPath();
  protected static final String e;
  
  static
  {
    int i;
    if ((QQWinkEnvironment.a().getExternalFilesDir(null) != null) && (QQWinkEnvironment.a().getExternalCacheDir() != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      b = QQWinkEnvironment.a().getExternalFilesDir(null).getPath();
      a = QQWinkEnvironment.a().getExternalCacheDir().getPath();
    }
    else
    {
      b = QQWinkEnvironment.a().getFilesDir().getPath();
      a = QQWinkEnvironment.a().getCacheDir().getPath();
    }
    e = QQWinkEnvironment.a().getFilesDir().getPath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.base.AEPathBase
 * JD-Core Version:    0.7.0.1
 */