package com.tencent.mobileqq.location.ui;

import android.graphics.Bitmap;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.location.model.FaceItem;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;

class LocationShareController$1
  implements DecodeTaskCompletionListener
{
  LocationShareController$1(LocationShareController paramLocationShareController) {}
  
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
    Bitmap localBitmap = BaseImageUtil.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    Object localObject = LocationAvatarHelper.a().b(paramString);
    long l = System.currentTimeMillis();
    paramBitmap = (Bitmap)localObject;
    if (localObject == null)
    {
      paramBitmap = new FaceItem();
      LocationAvatarHelper.a().a(paramString, paramBitmap);
    }
    paramBitmap.a = l;
    paramBitmap.c = localBitmap;
    this.a.a.a(paramString, localBitmap);
    if (LocationShareController.a(this.a) != null) {
      LocationShareController.a(this.a).onDecodeTaskCompleted(paramInt1, paramInt2, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareController.1
 * JD-Core Version:    0.7.0.1
 */