package com.tencent.mobileqq.qqlive.prepare.covercrop;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import mqq.os.MqqHandler;

class LoadBitmapTask$1
  implements Runnable
{
  LoadBitmapTask$1(LoadBitmapTask paramLoadBitmapTask, Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ViewGroup paramViewGroup, ImageView paramImageView) {}
  
  public void run()
  {
    Object localObject = new Point();
    this.a.getWindowManager().getDefaultDisplay().getSize((Point)localObject);
    try
    {
      System.gc();
      localObject = BaseImageUtil.a(this.b, ((Point)localObject).x, ((Point)localObject).y);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label58;
    }
    catch (Exception localException)
    {
      label46:
      break label46;
    }
    LoadBitmapTask.a(this.this$0, 2);
    break label67;
    label58:
    LoadBitmapTask.a(this.this$0, 1);
    label67:
    localObject = null;
    ThreadManager.getUIHandler().post(new LoadBitmapTask.1.1(this, (Bitmap)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.covercrop.LoadBitmapTask.1
 * JD-Core Version:    0.7.0.1
 */