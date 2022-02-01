package com.tencent.mobileqq.location.window;

import android.graphics.Bitmap;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.location.model.FaceItem;
import com.tencent.mobileqq.location.ui.LocationAvatarHelper;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;

class LocationFloatWindowController$2
  implements DecodeTaskCompletionListener
{
  LocationFloatWindowController$2(LocationFloatWindowController paramLocationFloatWindowController) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("remainingTasks = [");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("], uin = [");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], avatar = [");
      ((StringBuilder)localObject).append(paramBitmap);
      ((StringBuilder)localObject).append("]");
      QLog.d("LocationShareController", 2, new Object[] { "[location] onDecodeTaskCompleted invoked. ", ((StringBuilder)localObject).toString() });
    }
    Bitmap localBitmap = BaseImageUtil.c(paramBitmap, 16, 16);
    Object localObject = LocationAvatarHelper.a().a(paramString);
    long l = System.currentTimeMillis();
    paramBitmap = (Bitmap)localObject;
    if (localObject == null)
    {
      paramBitmap = new FaceItem();
      LocationAvatarHelper.a().a(paramString, paramBitmap);
    }
    paramBitmap.jdField_a_of_type_Long = l;
    paramBitmap.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    LocationFloatWindowController.a(this.a).a(paramString, localBitmap);
    if (LocationFloatWindowController.a(this.a) != null) {
      LocationFloatWindowController.a(this.a).onDecodeTaskCompleted(paramInt1, paramInt2, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.LocationFloatWindowController.2
 * JD-Core Version:    0.7.0.1
 */