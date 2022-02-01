package com.tencent.mobileqq.profilecard.vas.component.background;

import android.graphics.PointF;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity.OnMeasuredListener;
import com.tencent.mobileqq.profile.view.SingleTouchLayout;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "measuredWidth", "", "measuredHeight", "onMeasured", "com/tencent/mobileqq/profilecard/vas/component/background/VasProfileSimpleBackgroundComponent$updateDiyText$1$1"}, k=3, mv={1, 1, 16})
final class VasProfileSimpleBackgroundComponent$updateDiyText$$inlined$apply$lambda$1
  implements VipProfileCardDiyActivity.OnMeasuredListener
{
  VasProfileSimpleBackgroundComponent$updateDiyText$$inlined$apply$lambda$1(VasProfileSimpleBackgroundComponent paramVasProfileSimpleBackgroundComponent) {}
  
  public final void onMeasured(int paramInt1, int paramInt2)
  {
    Object localObject = VasProfileSimpleBackgroundComponent.access$getMDiyTextLayout$p(this.this$0);
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((SingleTouchLayout)localObject).setActualViewSize(paramInt1, paramInt2);
    localObject = VasProfileSimpleBackgroundComponent.access$getMDiyTextLayout$p(this.this$0);
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((SingleTouchLayout)localObject).invalidate();
    if (QLog.isColorLevel())
    {
      localObject = this.this$0.getTAG();
      StringBuilder localStringBuilder = new StringBuilder().append("updateDiyText: x=");
      SingleTouchLayout localSingleTouchLayout = VasProfileSimpleBackgroundComponent.access$getMDiyTextLayout$p(this.this$0);
      if (localSingleTouchLayout == null) {
        Intrinsics.throwNpe();
      }
      localStringBuilder = localStringBuilder.append(localSingleTouchLayout.a().x).append(',').append("y=");
      localSingleTouchLayout = VasProfileSimpleBackgroundComponent.access$getMDiyTextLayout$p(this.this$0);
      if (localSingleTouchLayout == null) {
        Intrinsics.throwNpe();
      }
      QLog.d((String)localObject, 2, localSingleTouchLayout.a().y + ',' + "width=" + paramInt1 + ',' + "height=" + paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.background.VasProfileSimpleBackgroundComponent.updateDiyText..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */