package com.tencent.mobileqq.richmediabrowser.view;

import android.net.Uri;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import java.io.File;
import java.util.ArrayList;

class AIOPictureView$3
  implements Runnable
{
  AIOPictureView$3(AIOPictureView paramAIOPictureView, File paramFile, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (((IBrowserDepend)QRoute.api(IBrowserDepend.class)).scanQrCodeNeedBlock()) {
      return;
    }
    if ((this.this$0.b != null) && (this.this$0.b.equals(this.jdField_a_of_type_JavaIoFile.getPath())))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("file://");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
      localObject = Uri.parse(((StringBuilder)localObject).toString());
      AIOPictureView.a(this.this$0, (Uri)localObject, this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.3
 * JD-Core Version:    0.7.0.1
 */