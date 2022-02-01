package com.tencent.mobileqq.kandian.biz.video.click;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.framework.click.ClickHandler;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsViewHolder;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class RIJVideoHandleClick
{
  private RIJDataManager a;
  private Context b;
  private HashMap<Integer, ClickHandler> c = new HashMap();
  private ClickHandler d = new RIJVideoHandleClick.4(this);
  private ClickHandler e = new RIJVideoHandleClick.5(this);
  private ClickHandler f = new RIJVideoHandleClick.6(this);
  private ClickHandler g = new RIJVideoHandleClick.7(this);
  private ClickHandler h = new RIJVideoHandleClick.8(this);
  private ClickHandler i = new RIJVideoHandleClick.9(this);
  private ClickHandler j = new RIJVideoHandleClick.10(this);
  private ClickHandler k = new RIJVideoHandleClick.11(this);
  private ClickHandler l = new RIJVideoHandleClick.12(this);
  private ClickHandler m = new RIJVideoHandleClick.13(this);
  private ClickHandler n = new RIJVideoHandleClick.14(this);
  private ClickHandler o = new RIJVideoHandleClick.15(this);
  
  public RIJVideoHandleClick(RIJDataManager paramRIJDataManager)
  {
    this.a = paramRIJDataManager;
    this.b = paramRIJDataManager.a().A();
    a();
  }
  
  private void a()
  {
    this.c.put(Integer.valueOf(2131444259), this.e);
    this.c.put(Integer.valueOf(2131435495), this.f);
    this.c.put(Integer.valueOf(2131449535), this.m);
    this.c.put(Integer.valueOf(2131437080), this.g);
    this.c.put(Integer.valueOf(2131444795), this.g);
    this.c.put(Integer.valueOf(2131437079), this.d);
    this.c.put(Integer.valueOf(2131444794), this.d);
    this.c.put(Integer.valueOf(2131435357), this.h);
    this.c.put(Integer.valueOf(2131449619), this.h);
    this.c.put(Integer.valueOf(2131433072), this.h);
    this.c.put(Integer.valueOf(2131449704), this.h);
    this.c.put(Integer.valueOf(2131449611), this.i);
    this.c.put(Integer.valueOf(2131440832), this.j);
    this.c.put(Integer.valueOf(2131437113), this.k);
    this.c.put(Integer.valueOf(2131444832), this.k);
    this.c.put(Integer.valueOf(2131434382), this.l);
    this.c.put(Integer.valueOf(2131434384), this.l);
    this.c.put(Integer.valueOf(2131435496), this.m);
    this.c.put(Integer.valueOf(2131427664), this.n);
    this.c.put(Integer.valueOf(2131427745), this.o);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    Object localObject = (VideoFeedsViewHolder)paramView.getTag();
    localObject = this.a.c(((VideoFeedsViewHolder)localObject).P);
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).setAdapterMonitorClickAdParams(this.a.a().A(), (AbsBaseArticleInfo)localObject, this.a.a().v(), 56, paramBoolean);
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).doActionAndReport((Activity)this.a.a().A(), (AbsBaseArticleInfo)localObject, this.a.a().v(), 56, paramBoolean, null);
    VideoHandler.b(paramView);
  }
  
  public void a(View paramView)
  {
    Object localObject = (ClickHandler)this.c.get(Integer.valueOf(paramView.getId()));
    if (localObject != null)
    {
      ((ClickHandler)localObject).onClick(paramView);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onClick, has no click handler for id(");
    ((StringBuilder)localObject).append(paramView.getId());
    ((StringBuilder)localObject).append("}");
    QLog.e("RIJVideoHandleClick", 1, ((StringBuilder)localObject).toString());
  }
  
  public boolean b(View paramView)
  {
    if (paramView.getId() == 2131435495)
    {
      c(paramView);
      return true;
    }
    return false;
  }
  
  public void c(View paramView)
  {
    paramView = (VideoFeedsViewHolder)paramView.getTag();
    paramView = this.a.c(paramView.P);
    if (paramView == null) {
      return;
    }
    RIJUserLevelModule.getInstance().doActionsByUserLevel(this.b, 2, new RIJVideoHandleClick.3(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick
 * JD-Core Version:    0.7.0.1
 */