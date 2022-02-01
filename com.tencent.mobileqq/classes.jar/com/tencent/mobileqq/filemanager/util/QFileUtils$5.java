package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import atvq;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import zmk;

public final class QFileUtils$5
  implements Runnable
{
  public QFileUtils$5(Context paramContext, String paramString, atvq paramatvq) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
    while (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    SparseArray localSparseArray = new SparseArray(2);
    int i = zmk.a(Uri.parse("file://" + this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_AndroidContentContext, 3, localSparseArray);
    ThreadManagerV2.getUIHandlerV2().post(new QFileUtils.5.1(this, i, localSparseArray));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QFileUtils.5
 * JD-Core Version:    0.7.0.1
 */