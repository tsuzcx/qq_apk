package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import com.tencent.biz.qrcode.activity.ScannerUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IQRMenuItemController;
import com.tencent.mobileqq.utils.FileUtils;

final class QFileUtils$5
  implements Runnable
{
  QFileUtils$5(Context paramContext, String paramString, IQRMenuItemController paramIQRMenuItemController) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
    while (!FileUtils.b(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    SparseArray localSparseArray = new SparseArray(2);
    int i = ScannerUtils.a(Uri.parse("file://" + this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_AndroidContentContext, 3, localSparseArray);
    ThreadManagerV2.getUIHandlerV2().post(new QFileUtils.5.1(this, i, localSparseArray));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QFileUtils.5
 * JD-Core Version:    0.7.0.1
 */