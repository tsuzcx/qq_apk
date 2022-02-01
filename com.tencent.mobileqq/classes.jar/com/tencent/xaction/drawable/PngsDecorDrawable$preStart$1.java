package com.tencent.xaction.drawable;

import android.view.View;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.api.base.DecorDrawableState;
import com.tencent.xaction.api.data.TimeProp;
import com.tencent.xaction.api.util.FilePathUtil;
import com.tencent.xaction.api.util.FilePathUtil.Companion;
import com.tencent.xaction.api.util.FileUtil;
import com.tencent.xaction.api.util.FileUtil.Companion;
import com.tencent.xaction.impl.XATimeline;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PngsDecorDrawable$preStart$1
  implements Runnable
{
  PngsDecorDrawable$preStart$1(PngsDecorDrawable paramPngsDecorDrawable, PngsDrawable paramPngsDrawable, View paramView) {}
  
  public final void run()
  {
    Object localObject1 = FilePathUtil.a;
    Object localObject2 = this.this$0.getDecorState();
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    localObject2 = ((DecorDrawableState)localObject2).getPath();
    Object localObject3 = this.this$0.getDecorState();
    if (localObject3 == null) {
      Intrinsics.throwNpe();
    }
    localObject1 = ((FilePathUtil.Companion)localObject1).a((String)localObject2, ((DecorDrawableState)localObject3).getRoot(), this.this$0.getEngine());
    localObject2 = this.this$0.getTl();
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    localObject2 = ((XATimeline)localObject2).a();
    localObject3 = this.jdField_a_of_type_ComTencentXactionDrawablePngsDrawable;
    FileUtil.Companion localCompanion = FileUtil.a;
    DecorDrawableState localDecorDrawableState = this.this$0.getDecorState();
    if (localDecorDrawableState == null) {
      Intrinsics.throwNpe();
    }
    ((PngsDrawable)localObject3).a(localCompanion.a((String)localObject1, localDecorDrawableState.getFp()));
    if ((((TimeProp)localObject2).getDuration() <= 0) && (this.jdField_a_of_type_ComTencentXactionDrawablePngsDrawable.a() != null) && (((TimeProp)localObject2).getRc() > 0))
    {
      localObject1 = this.jdField_a_of_type_ComTencentXactionDrawablePngsDrawable.a();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      ((TimeProp)localObject2).setDuration((int)(localObject1.length * (1000.0F / ((TimeProp)localObject2).getFps())));
      this.this$0.getBaseAnim().setDuration(((TimeProp)localObject2).getDuration());
    }
    this.jdField_a_of_type_ComTencentXactionDrawablePngsDrawable.a();
    this.jdField_a_of_type_AndroidViewView.post((Runnable)new PngsDecorDrawable.preStart.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.drawable.PngsDecorDrawable.preStart.1
 * JD-Core Version:    0.7.0.1
 */