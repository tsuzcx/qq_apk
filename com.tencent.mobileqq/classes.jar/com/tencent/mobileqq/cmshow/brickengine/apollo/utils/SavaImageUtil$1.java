package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class SavaImageUtil$1
  implements Runnable
{
  SavaImageUtil$1(long paramLong, int paramInt, View paramView) {}
  
  public void run()
  {
    try
    {
      SavaImageUtil.a = this.a;
      Intent localIntent;
      if (this.b == 0)
      {
        localIntent = new Intent("android.intent.action.PICK");
        localIntent.setType("image/*");
        ((Activity)this.c.getContext()).startActivityForResult(localIntent, 14006);
        return;
      }
      if (this.b == 1)
      {
        localIntent = new Intent();
        localIntent.addCategory("android.intent.category.DEFAULT");
        SavaImageUtil.b = new File(SavaImageUtil.a());
        SavaImageUtil.b.createNewFile();
        FileProvider7Helper.setSystemCapture(this.c.getContext(), SavaImageUtil.b, localIntent);
        ((Activity)this.c.getContext()).startActivityForResult(localIntent, 14005);
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("imageselector  fail e=");
      localStringBuilder.append(localException.toString());
      QLog.e("[cmshow]ImageUtil", 2, localStringBuilder.toString());
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.d("[cmshow]ImageUtil", 2, localOutOfMemoryError.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.SavaImageUtil.1
 * JD-Core Version:    0.7.0.1
 */