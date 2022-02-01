package com.tencent.mobileqq.flashshow.part;

import android.app.Activity;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.flashshow.api.IFlashShowRedPointService;
import com.tencent.mobileqq.flashshow.bean.FSMainTabInfo;
import com.tencent.mobileqq.flashshow.events.FSPageSelectEvent;
import com.tencent.mobileqq.flashshow.helper.FSEeveeRedPointHelper;
import com.tencent.mobileqq.flashshow.helper.FSTempRedPointHelper;
import com.tencent.mobileqq.flashshow.ioc.IFSTabFragmentIoc;
import com.tencent.mobileqq.flashshow.request.redpoint.FSClearCountRequest;
import com.tencent.mobileqq.flashshow.utils.FSInnerProtoUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qflash.QFlashBadge.BadgeDisplayInfo;
import qflash.QFlashBadge.BadgeJumpInfo;
import qflash.QFlashBadge.BadgeTypeInfo;
import qflash.QFlashBadge.QFlashBadgeContentInfo;
import qflash.QFlashBadge.QFlashBadgeInfo;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class FSRedPointTipsPart
  extends FSBasePart
  implements SimpleEventReceiver
{
  private final FSMainTabInfo a;
  private String b;
  private boolean c;
  private TextView d;
  private View e;
  private IFSTabFragmentIoc f;
  private int g;
  private final Runnable h = new FSRedPointTipsPart.1(this);
  
  public FSRedPointTipsPart(FSMainTabInfo paramFSMainTabInfo)
  {
    this.a = paramFSMainTabInfo;
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return Uri.parse(paramString).getQueryParameter("wording");
  }
  
  private void b(int paramInt)
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((FSMainTabInfo)localObject1).a != null))
    {
      if (!e(paramInt)) {
        return;
      }
      localObject1 = FSInnerProtoUtil.a(FSTempRedPointHelper.getInstance().getTabRedPointInfo());
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("has red point size  = ");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      QLog.d("FSRedPointTipsPart", 1, ((StringBuilder)localObject2).toString());
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (QFlashBadge.QFlashBadgeInfo)((Iterator)localObject2).next();
        if ((((QFlashBadge.QFlashBadgeInfo)localObject1).contentInfo.typeInfo.badgeSubTypeValue.get() == this.a.a.sourceType.get()) && (((QFlashBadge.QFlashBadgeInfo)localObject1).contentInfo.displayInfo.showBadge.get()))
        {
          this.b = a(((QFlashBadge.QFlashBadgeInfo)localObject1).contentInfo.displayInfo.jumpInfo.jumpLink.get());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("has red point displayText = ");
          ((StringBuilder)localObject2).append(this.b);
          ((StringBuilder)localObject2).append("sourceType = ");
          ((StringBuilder)localObject2).append(this.a.a.sourceType.get());
          QLog.d("FSRedPointTipsPart", 1, ((StringBuilder)localObject2).toString());
          e();
          c(this.a.a.sourceType.get());
          d(this.a.a.sourceType.get());
          ((QFlashBadge.QFlashBadgeInfo)localObject1).contentInfo.displayInfo.showBadge.set(false);
          return;
        }
      }
      f();
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("tab is not init mTab =");
    ((StringBuilder)localObject1).append(this.a);
    QLog.e("FSRedPointTipsPart", 1, ((StringBuilder)localObject1).toString());
  }
  
  private boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = Uri.parse(paramString).getQueryParameter("sourcetype");
    return String.valueOf(this.a.a.sourceType.get()).equals(paramString);
  }
  
  private void c(int paramInt)
  {
    ((IFlashShowRedPointService)QRoute.api(IFlashShowRedPointService.class)).setTabRedPointReaded(paramInt);
  }
  
  private void d()
  {
    if (!this.c)
    {
      this.c = true;
      this.d = ((TextView)((ViewStub)this.e.findViewById(2131433876)).inflate().findViewById(2131433875));
    }
  }
  
  private void d(int paramInt)
  {
    Object localObject = new QFlashBadge.BadgeTypeInfo();
    ((QFlashBadge.BadgeTypeInfo)localObject).badgeMainTypeValue.set(1);
    ((QFlashBadge.BadgeTypeInfo)localObject).badgeSubTypeValue.set(paramInt);
    localObject = new FSClearCountRequest((QFlashBadge.BadgeTypeInfo)localObject, 1, FSEeveeRedPointHelper.getInstance().getLastPreTabRedPointTimestamp(paramInt));
    VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, new FSRedPointTipsPart.2(this, paramInt));
  }
  
  private void e()
  {
    d();
    if (this.d == null) {
      return;
    }
    if (!TextUtils.isEmpty(this.b))
    {
      this.d.setVisibility(0);
      this.d.setText(this.b);
      RFThreadManager.getUIHandler().removeCallbacks(this.h);
      RFThreadManager.getUIHandler().postDelayed(this.h, 3000L);
    }
  }
  
  private boolean e(int paramInt)
  {
    if (b(FSInnerProtoUtil.a(FSTempRedPointHelper.getInstance().getBottomRedPointInfo()).contentInfo.displayInfo.jumpInfo.jumpLink.get())) {
      return true;
    }
    return this.g == paramInt;
  }
  
  private void f()
  {
    Object localObject = FSInnerProtoUtil.a(FSTempRedPointHelper.getInstance().getBottomRedPointInfo());
    if (!FSTempRedPointHelper.getInstance().isBottomRedPointValid()) {
      return;
    }
    localObject = ((QFlashBadge.QFlashBadgeInfo)localObject).contentInfo.displayInfo.jumpInfo.jumpLink.get();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    localObject = Uri.parse((String)localObject);
    String str = ((Uri)localObject).getQueryParameter("sourcetype");
    if (!String.valueOf(this.a.a.sourceType.get()).equals(str)) {
      return;
    }
    this.b = ((Uri)localObject).getQueryParameter("wording");
    e();
  }
  
  public String a()
  {
    return "FSRedPointTipsPart";
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.e = paramView;
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void a(IFSTabFragmentIoc paramIFSTabFragmentIoc)
  {
    this.f = paramIFSTabFragmentIoc;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FSPageSelectEvent.class);
    return localArrayList;
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    paramActivity = new StringBuilder();
    paramActivity.append("onActivityResumed");
    paramActivity.append(this.a.a.sourceType.get());
    QLog.d("FSRedPointTipsPart", 1, paramActivity.toString());
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveEvent:");
    localStringBuilder.append(paramSimpleBaseEvent);
    QLog.d("FSRedPointTipsPart", 1, localStringBuilder.toString());
    if ((paramSimpleBaseEvent instanceof FSPageSelectEvent)) {
      b(((FSPageSelectEvent)paramSimpleBaseEvent).mSelectPosition);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSRedPointTipsPart
 * JD-Core Version:    0.7.0.1
 */