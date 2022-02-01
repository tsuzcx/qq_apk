package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.qphone.base.util.QLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;

final class SavaImageUtil$2
  implements Runnable
{
  SavaImageUtil$2(int paramInt, Intent paramIntent, View paramView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.e("[cmshow]ImageUtil", 2, "imageselector selectimagecallback ");
    }
    int i = this.jdField_a_of_type_Int;
    if (i == -1)
    {
      Object localObject1 = (Bitmap)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("data");
      Object localObject2 = ByteBuffer.allocate(((Bitmap)localObject1).getByteCount());
      i = ((Bitmap)localObject1).getWidth();
      int j = ((Bitmap)localObject1).getHeight();
      ((Bitmap)localObject1).copyPixelsToBuffer((Buffer)localObject2);
      localObject1 = ((ByteBuffer)localObject2).array();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("imageselector selectimageallback textureView  ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject2).append(" data: ");
      QLog.e("[cmshow]ImageUtil", 2, ((StringBuilder)localObject2).toString());
      ((ApolloSurfaceView)this.jdField_a_of_type_AndroidViewView).getRender().getSavaWrapper().selectPhotoCallBack(SavaImageUtil.a, 1, i, j, (byte[])localObject1);
      return;
    }
    if (i == 0)
    {
      ((ApolloSurfaceView)this.jdField_a_of_type_AndroidViewView).getRender().getSavaWrapper().selectPhotoCallBack(SavaImageUtil.a, 3, 0, 0, null);
      return;
    }
    ((ApolloSurfaceView)this.jdField_a_of_type_AndroidViewView).getRender().getSavaWrapper().selectPhotoCallBack(SavaImageUtil.a, 2, 0, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.SavaImageUtil.2
 * JD-Core Version:    0.7.0.1
 */