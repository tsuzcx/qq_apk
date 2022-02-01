package com.tencent.mobileqq.profilecard.bussiness.photowall.view;

import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.QZonePhotoWall;
import java.util.ArrayList;

class PhotoWallView$1
  implements Runnable
{
  PhotoWallView$1(PhotoWallView paramPhotoWallView) {}
  
  public void run()
  {
    Object localObject = (QZonePhotoWall)this.this$0.mApp.getEntityManagerFactory().createEntityManager().find(QZonePhotoWall.class, this.this$0.mUin);
    if (localObject == null)
    {
      this.this$0.mHandler.sendEmptyMessage(3);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    this.this$0.update(((QZonePhotoWall)localObject).totalPic, ((QZonePhotoWall)localObject).hasMore, ((QZonePhotoWall)localObject).attachInfo, ((QZonePhotoWall)localObject).unpackPhotoWallData(), localArrayList);
    localObject = this.this$0.mHandler.obtainMessage(1);
    ((Message)localObject).obj = localArrayList;
    this.this$0.mHandler.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView.1
 * JD-Core Version:    0.7.0.1
 */