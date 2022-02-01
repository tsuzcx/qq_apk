package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IQRResultCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.utils.FileUtils;

final class QFileUtils$3
  implements Runnable
{
  QFileUtils$3(Context paramContext, String paramString, IQRResultCallback paramIQRResultCallback) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    if (!FileUtils.fileExistsAndNotEmpty(this.b)) {
      return;
    }
    SparseArray localSparseArray = new SparseArray(2);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("file://");
    ((StringBuilder)localObject).append(this.b);
    localObject = Uri.parse(((StringBuilder)localObject).toString());
    int i = ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile((Uri)localObject, this.a, 3, localSparseArray);
    ThreadManagerV2.getUIHandlerV2().post(new QFileUtils.3.1(this, i, localSparseArray));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QFileUtils.3
 * JD-Core Version:    0.7.0.1
 */