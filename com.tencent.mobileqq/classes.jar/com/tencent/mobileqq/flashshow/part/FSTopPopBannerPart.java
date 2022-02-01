package com.tencent.mobileqq.flashshow.part;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.flashshow.api.bean.FSLayerPageInitBean;
import com.tencent.mobileqq.flashshow.events.FSUploadTaskResultEvent;
import com.tencent.mobileqq.flashshow.launcher.FSNativeLauncher;
import com.tencent.mobileqq.flashshow.utils.FSTransUtils;
import com.tencent.mobileqq.flashshow.view.RoundCornerImageView;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkpublish.IQueueTask;
import com.tencent.mobileqq.winkpublish.api.IUploadTaskManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class FSTopPopBannerPart
  extends FSBasePart
  implements View.OnClickListener, SimpleEventReceiver
{
  private boolean a;
  private String b;
  private String c;
  private long d;
  private RelativeLayout e;
  private RoundCornerImageView f;
  private TextView g;
  private Button h;
  private Button i;
  
  public String a()
  {
    return "FSTopPopBannerPart";
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null)
    {
      this.h.setOnClickListener(paramOnClickListener);
      this.i.setOnClickListener(paramOnClickListener);
      this.e.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.e = ((RelativeLayout)paramView.findViewById(2131433393));
    this.f = ((RoundCornerImageView)paramView.findViewById(2131433396));
    this.g = ((TextView)paramView.findViewById(2131433397));
    this.h = ((Button)paramView.findViewById(2131433395));
    this.i = ((Button)paramView.findViewById(2131433394));
    this.f.setCorner(ViewUtils.dip2px(8.0F), ViewUtils.dip2px(8.0F), ViewUtils.dip2px(8.0F), ViewUtils.dip2px(8.0F));
    a(this);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Option localOption = new Option();
      localOption.setUrl(paramString).setTargetView(this.f).setPredecode(true).setRequestWidth(ViewUtils.dip2px(44.0F)).setRequestHeight(ViewUtils.dip2px(60.0F));
      QCircleFeedPicLoader.g().loadImage(localOption, new FSTopPopBannerPart.1(this));
      this.f.setColor(Color.parseColor("#33FFFFFF"));
    }
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.g.setText(paramString);
    }
  }
  
  public void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.h.setText(paramString);
    }
  }
  
  public void d()
  {
    RelativeLayout localRelativeLayout = this.e;
    if (localRelativeLayout != null)
    {
      localRelativeLayout.setVisibility(0);
      new Handler().postDelayed(new FSTopPopBannerPart.2(this), 6000L);
    }
  }
  
  public void e()
  {
    RelativeLayout localRelativeLayout = this.e;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(8);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FSUploadTaskResultEvent.class);
    return localArrayList;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131433395)
    {
      Object localObject;
      if ((this.a) && (!TextUtils.isEmpty(this.b)))
      {
        localObject = new FSLayerPageInitBean(l());
        ((FSLayerPageInitBean)localObject).setFeedId(this.b);
        ((FSLayerPageInitBean)localObject).setCreateTime(this.d);
        ((FSLayerPageInitBean)localObject).setUserId(FSTransUtils.a());
        FSNativeLauncher.a(g(), (FSLayerPageInitBean)localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onClick, feedId = ");
        ((StringBuilder)localObject).append(this.b);
        QLog.d("FSTopPopBannerPart", 1, ((StringBuilder)localObject).toString());
      }
      else
      {
        localObject = ((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).getTaskList();
        if ((localObject == null) || (TextUtils.isEmpty(this.c))) {
          break label215;
        }
        localObject = ((CopyOnWriteArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          IQueueTask localIQueueTask = (IQueueTask)((Iterator)localObject).next();
          if ((localIQueueTask != null) && (this.c.equals(localIQueueTask.getClientKey()))) {
            ((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).resumeTask(localIQueueTask);
          }
        }
      }
      e();
    }
    else if (paramView.getId() == 2131433394)
    {
      e();
    }
    label215:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof FSUploadTaskResultEvent))
    {
      paramSimpleBaseEvent = (FSUploadTaskResultEvent)paramSimpleBaseEvent;
      this.a = paramSimpleBaseEvent.isUploadSuccess();
      this.b = paramSimpleBaseEvent.getFeedId();
      this.c = paramSimpleBaseEvent.getClientKey();
      this.d = paramSimpleBaseEvent.getCreateTime();
      if (this.a)
      {
        b("发布成功！\n快去看看吧！");
        c("查看");
      }
      else
      {
        b("作品发布失败，已存入\n草稿箱。");
        c("重试");
      }
      a(paramSimpleBaseEvent.getUploadCoverUrl());
      d();
      paramSimpleBaseEvent = new StringBuilder();
      paramSimpleBaseEvent.append("onReceiveEvent isSuccess = ");
      paramSimpleBaseEvent.append(this.a);
      QLog.d("FSTopPopBannerPart", 1, paramSimpleBaseEvent.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSTopPopBannerPart
 * JD-Core Version:    0.7.0.1
 */