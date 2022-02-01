package com.tencent.mobileqq.qqlive.prepare.covercrop;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.qqlive.widget.PortraitImageView;
import com.tencent.mobileqq.qqlive.widget.RegionView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

class LoadBitmapTask$1$1
  implements Runnable
{
  LoadBitmapTask$1$1(LoadBitmapTask.1 param1, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.a != null)
    {
      int i = (ViewUtils.getScreenWidth() - this.b.c) / 2;
      LoadBitmapTask.a(this.b.this$0).setRestrict(this.b.c, this.b.d, i, 0);
      LoadBitmapTask.a(this.b.this$0).setImageBitmap(this.a);
      Object localObject1 = new ViewGroup.LayoutParams(-1, -1);
      LoadBitmapTask.a(this.b.this$0, new RegionView(this.b.a, LoadBitmapTask.a(this.b.this$0), this.b.c, this.b.d, 1, i, 0));
      Object localObject2 = this.b.this$0;
      boolean bool;
      if (this.b.e == this.b.f) {
        bool = true;
      } else {
        bool = false;
      }
      ((LoadBitmapTask)localObject2).a(bool);
      this.b.g.addView(LoadBitmapTask.a(this.b.this$0), (ViewGroup.LayoutParams)localObject1);
      this.b.g.addView(LoadBitmapTask.b(this.b.this$0), (ViewGroup.LayoutParams)localObject1);
      try
      {
        if (this.b.e == 1)
        {
          localObject1 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LoadBitmapTask.b(this.b.this$0).getResources(), 2130848123), this.b.c, this.b.d, false);
          LoadBitmapTask.b(this.b.this$0).setCropBitmap((Bitmap)localObject1);
        }
        else if (this.b.e == 2)
        {
          localObject1 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LoadBitmapTask.b(this.b.this$0).getResources(), 2130848122), this.b.c, this.b.d, false);
          LoadBitmapTask.b(this.b.this$0).setCropBitmap((Bitmap)localObject1);
        }
        else if (this.b.e == 3)
        {
          localObject1 = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LoadBitmapTask.b(this.b.this$0).getResources(), 2130848124), this.b.c, this.b.d, false);
          LoadBitmapTask.b(this.b.this$0).setCropBitmap((Bitmap)localObject1);
        }
        LoadBitmapTask.a(this.b.this$0).setVisibility(0);
        LoadBitmapTask.a(this.b.this$0).postDelayed(new LoadBitmapTask.1.1.1(this), 100L);
        return;
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("e ");
        ((StringBuilder)localObject2).append(localException.getMessage());
        QLog.d("LoadBitmapTask", 1, ((StringBuilder)localObject2).toString());
        return;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errorcode ");
    localStringBuilder.append(LoadBitmapTask.c(this.b.this$0));
    QLog.d("LoadBitmapTask", 1, localStringBuilder.toString());
    this.b.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.covercrop.LoadBitmapTask.1.1
 * JD-Core Version:    0.7.0.1
 */