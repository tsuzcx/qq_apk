package com.tencent.mobileqq.qqgamepub.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import mqq.util.WeakReference;

class GameShareUtilImpl$3$1
  implements Runnable
{
  GameShareUtilImpl$3$1(GameShareUtilImpl.3 param3, Drawable paramDrawable) {}
  
  public void run()
  {
    Object localObject1 = (Context)this.b.a.get();
    TextView localTextView = (TextView)this.b.b.get();
    Object localObject2 = (AIOGallerySceneWithBusiness)this.b.c.get();
    if (((localObject1 instanceof Activity)) && (!((Activity)localObject1).isFinishing()) && (localTextView != null) && (localObject2 != null) && (((AIOGallerySceneWithBusiness)localObject2).S() != null) && (((AIOGallerySceneWithBusiness)localObject2).S().a != null) && (((AIOGallerySceneWithBusiness)localObject2).S().a.L == this.b.d) && (((AIOGallerySceneWithBusiness)localObject2).S().a.M == this.b.e))
    {
      localObject2 = this.a;
      localObject1 = ((Context)localObject1).getResources();
      localObject2 = new BitmapDrawable(StructMsgItemCover.a((Drawable)localObject2));
      localTextView.setCompoundDrawablePadding(AIOUtils.b(3.0F, (Resources)localObject1));
      ((Drawable)localObject2).setBounds(0, 0, AIOUtils.b(20.0F, (Resources)localObject1), AIOUtils.b(20.0F, (Resources)localObject1));
      localTextView.setCompoundDrawables((Drawable)localObject2, null, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.GameShareUtilImpl.3.1
 * JD-Core Version:    0.7.0.1
 */