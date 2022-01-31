package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Message;
import awgf;
import awgg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QZonePhotoWall;
import java.util.ArrayList;

class PhotoWallView$1
  implements Runnable
{
  PhotoWallView$1(PhotoWallView paramPhotoWallView) {}
  
  public void run()
  {
    Object localObject = (QZonePhotoWall)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(QZonePhotoWall.class, this.this$0.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    this.this$0.a(((QZonePhotoWall)localObject).totalPic, ((QZonePhotoWall)localObject).hasMore, ((QZonePhotoWall)localObject).attachInfo, ((QZonePhotoWall)localObject).unpackPhotoWallData(), localArrayList);
    localObject = this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    ((Message)localObject).obj = localArrayList;
    this.this$0.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PhotoWallView.1
 * JD-Core Version:    0.7.0.1
 */