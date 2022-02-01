package com.tencent.mobileqq.kandian.biz.tab.api;

import android.view.View;
import com.tencent.mobileqq.activity.home.impl.FrameInitBean;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/tab/api/IRIJTabInject;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "initKanDianTab", "", "frameFragment", "", "bean", "Lcom/tencent/mobileqq/activity/home/impl/FrameInitBean;", "kanDianTabExposure", "mTabNotifyIcon", "Ljava/util/HashMap;", "", "Landroid/view/View;", "mTabs", "", "(Ljava/util/HashMap;[Landroid/view/View;)V", "updateKanDianRedTouch", "updateKanDianTab", "type", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJTabInject
  extends QRouteApi
{
  public abstract void initKanDianTab(@Nullable Object paramObject, @NotNull FrameInitBean paramFrameInitBean);
  
  public abstract void kanDianTabExposure(@Nullable HashMap<String, View> paramHashMap, @Nullable View[] paramArrayOfView);
  
  public abstract void updateKanDianRedTouch(@Nullable Object paramObject);
  
  public abstract void updateKanDianTab(@Nullable Object paramObject, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.api.IRIJTabInject
 * JD-Core Version:    0.7.0.1
 */