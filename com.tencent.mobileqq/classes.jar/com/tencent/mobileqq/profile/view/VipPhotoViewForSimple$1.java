package com.tencent.mobileqq.profile.view;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import android.os.Handler;
import android.os.Message;
import aukp;
import aukq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QZonePhotoWall;
import java.util.ArrayList;
import java.util.List;

class VipPhotoViewForSimple$1
  implements Runnable
{
  VipPhotoViewForSimple$1(VipPhotoViewForSimple paramVipPhotoViewForSimple) {}
  
  public void run()
  {
    Object localObject1 = (QZonePhotoWall)this.this$0.a.getEntityManagerFactory().createEntityManager().a(QZonePhotoWall.class, VipPhotoViewForSimple.a(this.this$0));
    if (localObject1 != null)
    {
      localObject1 = ((QZonePhotoWall)localObject1).unpackPhotoWallData();
      Object localObject2 = new ArrayList();
      int i = 0;
      while (i < ((ArrayList)localObject1).size())
      {
        ((ArrayList)localObject2).add(((PhotoWall)((ArrayList)localObject1).get(i)).photoUrls);
        i += 1;
      }
      localObject1 = VipPhotoViewForSimple.a(this.this$0, "", (List)localObject2);
      localObject2 = Message.obtain();
      ((Message)localObject2).what = 200;
      ((Message)localObject2).obj = localObject1;
      VipPhotoViewForSimple.a(this.this$0).sendMessage((Message)localObject2);
      return;
    }
    VipPhotoViewForSimple.a(this.this$0).sendEmptyMessage(201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipPhotoViewForSimple.1
 * JD-Core Version:    0.7.0.1
 */