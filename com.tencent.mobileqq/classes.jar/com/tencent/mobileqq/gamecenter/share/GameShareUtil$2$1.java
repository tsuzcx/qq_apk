package com.tencent.mobileqq.gamecenter.share;

import agej;
import aics;
import aidw;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import avlx;
import bdqo;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import mqq.util.WeakReference;

public class GameShareUtil$2$1
  implements Runnable
{
  public GameShareUtil$2$1(avlx paramavlx, Drawable paramDrawable) {}
  
  public void run()
  {
    Object localObject1 = (Context)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get();
    TextView localTextView = (TextView)this.this$0.jdField_b_of_type_MqqUtilWeakReference.get();
    Object localObject2 = (aics)this.this$0.c.get();
    if (((localObject1 instanceof Activity)) && (!((Activity)localObject1).isFinishing()) && (localTextView != null) && (localObject2 != null) && (((aics)localObject2).a() != null) && (((aics)localObject2).a().a != null) && (((aics)localObject2).a().a.jdField_f_of_type_Long == this.this$0.jdField_a_of_type_Long) && (((aics)localObject2).a().a.jdField_f_of_type_Int == this.this$0.jdField_b_of_type_Long))
    {
      localObject2 = this.a;
      localObject1 = ((Context)localObject1).getResources();
      localObject2 = new BitmapDrawable(bdqo.a((Drawable)localObject2));
      localTextView.setCompoundDrawablePadding(agej.a(3.0F, (Resources)localObject1));
      ((Drawable)localObject2).setBounds(0, 0, agej.a(20.0F, (Resources)localObject1), agej.a(20.0F, (Resources)localObject1));
      localTextView.setCompoundDrawables((Drawable)localObject2, null, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.share.GameShareUtil.2.1
 * JD-Core Version:    0.7.0.1
 */