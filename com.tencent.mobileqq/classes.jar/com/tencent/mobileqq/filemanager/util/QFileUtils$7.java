package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import ariq;
import bdhb;
import com.tencent.mobileqq.app.ThreadManagerV2;
import yak;

public final class QFileUtils$7
  implements Runnable
{
  public QFileUtils$7(Context paramContext, String paramString, ariq paramariq) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
    while (!bdhb.b(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    SparseArray localSparseArray = new SparseArray(2);
    int i = yak.a(Uri.parse("file://" + this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_AndroidContentContext, 3, localSparseArray);
    ThreadManagerV2.getUIHandlerV2().post(new QFileUtils.7.1(this, i, localSparseArray));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QFileUtils.7
 * JD-Core Version:    0.7.0.1
 */