package com.tencent.mobileqq.gamecenter.share;

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

class GameShareUtil$2$1
  implements Runnable
{
  GameShareUtil$2$1(GameShareUtil.2 param2, Drawable paramDrawable) {}
  
  public void run()
  {
    Object localObject1 = (Context)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get();
    TextView localTextView = (TextView)this.this$0.jdField_b_of_type_MqqUtilWeakReference.get();
    Object localObject2 = (AIOGallerySceneWithBusiness)this.this$0.c.get();
    if (((localObject1 instanceof Activity)) && (!((Activity)localObject1).isFinishing()) && (localTextView != null) && (localObject2 != null) && (((AIOGallerySceneWithBusiness)localObject2).a() != null) && (((AIOGallerySceneWithBusiness)localObject2).a().a != null) && (((AIOGallerySceneWithBusiness)localObject2).a().a.jdField_f_of_type_Long == this.this$0.jdField_a_of_type_Long) && (((AIOGallerySceneWithBusiness)localObject2).a().a.jdField_f_of_type_Int == this.this$0.jdField_b_of_type_Long))
    {
      localObject2 = this.a;
      localObject1 = ((Context)localObject1).getResources();
      localObject2 = new BitmapDrawable(StructMsgItemCover.a((Drawable)localObject2));
      localTextView.setCompoundDrawablePadding(AIOUtils.a(3.0F, (Resources)localObject1));
      ((Drawable)localObject2).setBounds(0, 0, AIOUtils.a(20.0F, (Resources)localObject1), AIOUtils.a(20.0F, (Resources)localObject1));
      localTextView.setCompoundDrawables((Drawable)localObject2, null, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.share.GameShareUtil.2.1
 * JD-Core Version:    0.7.0.1
 */