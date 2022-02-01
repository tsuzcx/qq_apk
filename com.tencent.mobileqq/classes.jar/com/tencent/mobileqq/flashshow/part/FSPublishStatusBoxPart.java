package com.tencent.mobileqq.flashshow.part;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.flashshow.config.FSConfig;
import com.tencent.mobileqq.flashshow.events.FSPublishBoxStatusEvent;
import com.tencent.mobileqq.flashshow.view.RoundCornerImageView;
import com.tencent.mobileqq.flashshow.widgets.RoundProgressBar;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkpublish.IPublishQueueListener;
import com.tencent.mobileqq.winkpublish.IQueueTask;
import com.tencent.mobileqq.winkpublish.api.IUploadTaskManager;
import com.tencent.mobileqq.winkpublish.model.PublishQueueTaskInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FSPublishStatusBoxPart
  extends FSBasePart
  implements SimpleEventReceiver
{
  IPublishQueueListener a = new FSPublishStatusBoxPart.3(this);
  Runnable b = new FSPublishStatusBoxPart.5(this);
  private FrameLayout c;
  private RoundProgressBar d;
  private RoundCornerImageView e;
  private int f = 0;
  private int g = 0;
  
  private int a(int paramInt1, int paramInt2)
  {
    double d1 = (1.0D - Math.pow(0.8D, paramInt1 * 1.0F / 30.0F)) * 0.9D;
    double d2 = paramInt2;
    Double.isNaN(d2);
    int i = (int)(100.0D * d1 + d2 * (1.0D - d1));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upload fakeProgress:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" progress:");
    localStringBuilder.append(d1);
    localStringBuilder.append(" realProgress:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" result:");
    localStringBuilder.append(i);
    QLog.e("FSPublishStatusBoxPart", 1, localStringBuilder.toString());
    return i;
  }
  
  private void a(FSPublishBoxStatusEvent paramFSPublishBoxStatusEvent)
  {
    RFThreadManager.getUIHandler().post(new FSPublishStatusBoxPart.2(this));
  }
  
  private void a(String paramString) {}
  
  private void b(IQueueTask paramIQueueTask)
  {
    if (paramIQueueTask == null) {
      return;
    }
    PublishQueueTaskInfo localPublishQueueTaskInfo = paramIQueueTask.getInfo();
    if (localPublishQueueTaskInfo != null)
    {
      if ((localPublishQueueTaskInfo.state != 0) && (localPublishQueueTaskInfo.state != 4) && (localPublishQueueTaskInfo.state != 1) && (localPublishQueueTaskInfo.state != 6))
      {
        d();
        return;
      }
      if (localPublishQueueTaskInfo.progress > 0)
      {
        RFThreadManager.getUIHandler().removeCallbacks(this.b);
        a(paramIQueueTask);
        if (localPublishQueueTaskInfo.progress > this.f)
        {
          this.f = localPublishQueueTaskInfo.progress;
          this.d.setProgress(a(this.g, this.f));
        }
      }
      else
      {
        d();
      }
      if (QLog.isColorLevel())
      {
        paramIQueueTask = new StringBuilder();
        paramIQueueTask.append("IQueueTask progress:");
        paramIQueueTask.append(localPublishQueueTaskInfo.progress);
        QLog.e("FSPublishStatusBoxPart", 1, paramIQueueTask.toString());
      }
    }
  }
  
  private void e()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = ((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).getTaskList();
    int i;
    if (localCopyOnWriteArrayList != null) {
      i = localCopyOnWriteArrayList.size();
    } else {
      i = 0;
    }
    if (i == 0)
    {
      d();
      return;
    }
    a((IQueueTask)localCopyOnWriteArrayList.get(0));
    this.f = 0;
    this.d.setProgress(0);
    if (this.c.getVisibility() == 0) {
      RFThreadManager.getUIHandler().postDelayed(this.b, 200L);
    }
  }
  
  public String a()
  {
    return "FSPublishStatusBoxPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    a(j(), paramView, E());
    SimpleEventBus.getInstance().registerReceiver(this);
    this.c = ((FrameLayout)paramView.findViewById(2131433871));
    this.d = ((RoundProgressBar)paramView.findViewById(2131433877));
    this.e = ((RoundCornerImageView)paramView.findViewById(2131433872));
    this.e.setCorner(ViewUtils.dpToPx(8.0F), ViewUtils.dpToPx(8.0F), ViewUtils.dpToPx(8.0F), ViewUtils.dpToPx(8.0F));
    this.e.setColor(Color.parseColor("#33FFFFFF"));
    ((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).addPublishQueueListener(this.a);
    paramView.findViewById(2131433873).setOnClickListener(new FSPublishStatusBoxPart.1(this));
  }
  
  public void a(IQueueTask paramIQueueTask)
  {
    if (!FSConfig.q()) {
      return;
    }
    if (paramIQueueTask == null) {
      return;
    }
    PublishQueueTaskInfo localPublishQueueTaskInfo = paramIQueueTask.getInfo();
    if (this.c.getVisibility() != 0) {
      this.c.setVisibility(0);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("show info.url:");
    ((StringBuilder)localObject).append(localPublishQueueTaskInfo.url);
    QLog.e("FSPublishStatusBoxPart", 1, ((StringBuilder)localObject).toString());
    if ((localPublishQueueTaskInfo != null) && (!TextUtils.isEmpty(localPublishQueueTaskInfo.url)))
    {
      localObject = new File(localPublishQueueTaskInfo.url);
      if ((((File)localObject).exists()) && (!((File)localObject).isDirectory()))
      {
        paramIQueueTask = new Option();
        paramIQueueTask.setUrl(localPublishQueueTaskInfo.url).setTargetView(this.e).setPredecode(true).setRequestWidth(ViewUtils.dip2px(105.0F)).setRequestHeight(ViewUtils.dip2px(105.0F));
        QCircleFeedPicLoader.g().loadImage(paramIQueueTask, new FSPublishStatusBoxPart.4(this));
        return;
      }
      d();
      ((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).removeTask(paramIQueueTask);
      QLog.e("FSPublishStatusBoxPart", 1, "file not exist");
      return;
    }
    d();
    ((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).removeTask(paramIQueueTask);
    QLog.e("FSPublishStatusBoxPart", 1, "info.url is null");
  }
  
  public void d()
  {
    this.g = 0;
    this.f = 0;
    this.d.setProgress(0);
    RFThreadManager.getUIHandler().removeCallbacks(this.b);
    if (this.c.getVisibility() != 8) {
      this.c.setVisibility(8);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FSPublishBoxStatusEvent.class);
    return localArrayList;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof FSPublishBoxStatusEvent)) {
      a((FSPublishBoxStatusEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSPublishStatusBoxPart
 * JD-Core Version:    0.7.0.1
 */