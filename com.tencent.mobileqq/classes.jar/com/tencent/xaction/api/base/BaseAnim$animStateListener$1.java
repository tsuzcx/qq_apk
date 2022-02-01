package com.tencent.xaction.api.base;

import android.view.View;
import com.tencent.xaction.api.data.FloatViewData;
import com.tencent.xaction.impl.AnimStateListener;
import com.tencent.xaction.impl.FloatViewUtil;
import com.tencent.xaction.impl.FloatViewUtil.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/xaction/api/base/BaseAnim$animStateListener$1", "Lcom/tencent/xaction/impl/AnimStateListener;", "cancel", "", "end", "start", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class BaseAnim$animStateListener$1
  implements AnimStateListener
{
  BaseAnim$animStateListener$1(View paramView) {}
  
  public void a()
  {
    FloatViewUtil.Companion localCompanion = FloatViewUtil.a;
    FloatViewData localFloatViewData = this.jdField_a_of_type_ComTencentXactionApiBaseBaseAnim.getFloatData();
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      Intrinsics.throwNpe();
    }
    localCompanion.b(localFloatViewData, localView);
  }
  
  public void b() {}
  
  public void c()
  {
    FloatViewUtil.Companion localCompanion = FloatViewUtil.a;
    FloatViewData localFloatViewData = this.jdField_a_of_type_ComTencentXactionApiBaseBaseAnim.getFloatData();
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      Intrinsics.throwNpe();
    }
    localCompanion.a(localFloatViewData, localView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.base.BaseAnim.animStateListener.1
 * JD-Core Version:    0.7.0.1
 */