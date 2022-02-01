package com.tencent.mobileqq.kandian.biz.tab.api.impl;

import android.view.View;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.tab.RIJInjectImpl;
import com.tencent.mobileqq.kandian.biz.tab.api.IRIJTabInject;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/tab/api/impl/RIJTabInjectImpl;", "Lcom/tencent/mobileqq/kandian/biz/tab/api/IRIJTabInject;", "()V", "initKanDianTab", "", "frameFragment", "", "kanDianTabExposure", "mTabNotifyIcon", "Ljava/util/HashMap;", "", "Landroid/view/View;", "mTabs", "", "(Ljava/util/HashMap;[Landroid/view/View;)V", "updateKanDianRedTouch", "updateKanDianTab", "type", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJTabInjectImpl
  implements IRIJTabInject
{
  public void initKanDianTab(@Nullable Object paramObject)
  {
    if ((paramObject instanceof FrameFragment)) {
      RIJInjectImpl.i((FrameFragment)paramObject);
    }
  }
  
  public void kanDianTabExposure(@Nullable HashMap<String, View> paramHashMap, @Nullable View[] paramArrayOfView)
  {
    RIJInjectImpl.a(RIJQQAppInterfaceUtil.b(), paramHashMap, paramArrayOfView);
  }
  
  public void updateKanDianRedTouch(@Nullable Object paramObject)
  {
    if ((paramObject instanceof FrameFragment)) {
      RIJInjectImpl.h((FrameFragment)paramObject);
    }
  }
  
  public void updateKanDianTab(@Nullable Object paramObject, int paramInt)
  {
    if ((paramObject instanceof FrameFragment)) {
      RIJInjectImpl.a((FrameFragment)paramObject, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.api.impl.RIJTabInjectImpl
 * JD-Core Version:    0.7.0.1
 */