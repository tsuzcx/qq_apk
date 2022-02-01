package com.tencent.mobileqq.kandian.base.view.api.impl;

import android.content.Context;
import android.view.View;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.impl.FrameInfoBean;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.view.api.IKanDianOptUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/view/api/impl/KanDianOptUtils;", "Lcom/tencent/mobileqq/kandian/base/view/api/IKanDianOptUtils;", "()V", "EVENT_REPORT_THIRD_TAB", "", "TAG", "mainFrameIsInInit", "", "generateTabItem", "Landroid/view/View;", "faceId", "", "bgId", "facePressId", "bgPressId", "strId", "animateTag", "apngPlayTag", "getTabInfo", "infoBean", "Lcom/tencent/mobileqq/activity/home/impl/FrameInfoBean;", "isMainFrameInInit", "reportTabInfo", "", "tabHost", "Lcom/tencent/mobileqq/widget/QQTabHost;", "reportTabInfoImp", "tabSpecs", "", "Landroid/widget/TabHost$TabSpec;", "Landroid/widget/TabHost;", "updateMainFrameInitStatus", "isRunning", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KanDianOptUtils
  implements IKanDianOptUtils
{
  private static final String EVENT_REPORT_THIRD_TAB = "actKandianReportTabInfo";
  public static final KanDianOptUtils INSTANCE = new KanDianOptUtils();
  private static final String TAG = "KanDianOptUtils";
  private static boolean mainFrameIsInInit;
  
  private final String getTabInfo(FrameInfoBean paramFrameInfoBean)
  {
    String str = paramFrameInfoBean.d();
    paramFrameInfoBean = paramFrameInfoBean.a();
    Intrinsics.checkExpressionValueIsNotNull(paramFrameInfoBean, "infoBean.frameClass");
    paramFrameInfoBean = paramFrameInfoBean.getSimpleName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(',');
    localStringBuilder.append(paramFrameInfoBean);
    return localStringBuilder.toString();
  }
  
  private final void reportTabInfoImp(List<? extends TabHost.TabSpec> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = Class.forName(((TabHost.TabSpec)paramList.next()).getTag());
      localObject = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByClazz((Class)localObject);
      if (localObject == null) {
        break;
      }
      Map localMap = (Map)localHashMap;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tab_");
      localStringBuilder.append(i);
      localMap.put(localStringBuilder.toString(), getTabInfo((FrameInfoBean)localObject));
      i += 1;
    }
    paramList = new StringBuilder();
    paramList.append("[reportTabInfo], event = actKandianReportTabInfo, params = ");
    paramList.append(localHashMap);
    QLog.i("KanDianOptUtils", 1, paramList.toString());
    QQBeaconReport.a("0S200MNJT807V3GE", RIJQQAppInterfaceUtil.d(), "actKandianReportTabInfo", true, (Map)localHashMap, true);
  }
  
  @Nullable
  public View generateTabItem(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (BaseApplicationImpl.sApplication == null) {
      return null;
    }
    View localView = View.inflate((Context)BaseApplicationImpl.sApplication, 2131629366, null);
    Object localObject = (DragTextView)localView.findViewById(2131449076);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "tv");
    ((DragTextView)localObject).setDragViewType(2);
    localObject = localView.findViewById(2131446751);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "vTab.findViewById(com.te…leqq.R.id.tab_item_image)");
    ((TabDragAnimationView)localObject).setEmotionDrawable(paramInt1, paramInt2, paramInt3, paramInt4, paramInt6, paramInt7);
    ((TextView)localView.findViewById(2131448791)).setText(paramInt5);
    return localView;
  }
  
  public boolean isMainFrameInInit()
  {
    return mainFrameIsInInit;
  }
  
  public void reportTabInfo(@Nullable QQTabHost paramQQTabHost)
  {
    if (paramQQTabHost == null) {
      return;
    }
    ThreadManager.getSubThreadHandler().post((Runnable)new KanDianOptUtils.reportTabInfo.1(paramQQTabHost));
  }
  
  public void updateMainFrameInitStatus(boolean paramBoolean)
  {
    mainFrameIsInInit = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.api.impl.KanDianOptUtils
 * JD-Core Version:    0.7.0.1
 */