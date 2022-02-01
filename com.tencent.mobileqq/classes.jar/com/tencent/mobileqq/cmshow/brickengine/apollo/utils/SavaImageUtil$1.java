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
      SavaImageUtil.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      Intent localIntent;
      if (this.jdField_a_of_type_Int == 0)
      {
        localIntent = new Intent("android.intent.action.PICK");
        localIntent.setType("image/*");
        ((Activity)this.jdField_a_of_type_AndroidViewView.getContext()).startActivityForResult(localIntent, 14006);
        return;
      }
      if (this.jdField_a_of_type_Int == 1)
      {
        localIntent = new Intent();
        localIntent.addCategory("android.intent.category.DEFAULT");
        SavaImageUtil.jdField_a_of_type_JavaIoFile = new File(SavaImageUtil.a());
        SavaImageUtil.jdField_a_of_type_JavaIoFile.createNewFile();
        FileProvider7Helper.setSystemCapture(this.jdField_a_of_type_AndroidViewView.getContext(), SavaImageUtil.jdField_a_of_type_JavaIoFile, localIntent);
        ((Activity)this.jdField_a_of_type_AndroidViewView.getContext()).startActivityForResult(localIntent, 14005);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.SavaImageUtil.1
 * JD-Core Version:    0.7.0.1
 */