package com.tencent.mobileqq.flashshow.list.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.mobileqq.flashshow.api.bean.FSReportBean;
import com.tencent.mobileqq.flashshow.api.data.DataBuilder;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11001;
import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.mobileqq.flashshow.request.list.FSMessageNoticeRequest;
import com.tencent.mobileqq.flashshow.request.list.FSUnReadPointRequest;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.flashshow.widgets.FSBaseWidgetView;
import com.tencent.mobileqq.flashshow.widgets.common.FSAsyncTextView;
import com.tencent.mobileqq.flashshow.widgets.common.FSAvatarView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleFeedBase.MessageBoxRedPointInfo;
import qqcircle.QQCircleFeedBase.StNoticeBusiData;
import qqcircle.QQCircleFeedBase.StNoticePattonInfo;
import qqcircle.QQCircleFeedBase.StUserCertificationLabel;

public abstract class FSBaseMessagePresenter
{
  protected View a;
  protected View b;
  protected Context c;
  protected FeedCloudMeta.StNotice d;
  protected QQCircleFeedBase.StNoticeBusiData e;
  protected FSAvatarView f;
  protected TextView g;
  protected FSAsyncTextView h;
  protected TextView i;
  protected View.OnClickListener j;
  protected BlockPart k;
  protected int l;
  protected FSAsyncTextView m;
  protected ImageView n;
  protected LinearLayout o;
  protected FSAsyncTextView p;
  private ImageView q;
  private ImageView r;
  
  public FSBaseMessagePresenter(int paramInt)
  {
    this.l = paramInt;
  }
  
  private void a(View paramView)
  {
    if (this.d == null) {
      return;
    }
    if (paramView.getId() == 2131436271)
    {
      FSLpReportDc11001.a(new DataBuilder(e()).setActionType(17).setSubActionType(8).setThrActionType(0).setToUin(this.d.operation.opUser.id.get()).setExt2(String.valueOf(this.d.noticeType.get())));
      return;
    }
    if (paramView.getId() == 2131448603) {
      FSLpReportDc11001.a(new DataBuilder(e()).setActionType(17).setSubActionType(9).setThrActionType(0).setToUin(this.d.operation.opUser.id.get()).setExt2(String.valueOf(this.d.noticeType.get())));
    }
  }
  
  private void a(ImageView paramImageView, FeedCloudMeta.StImage paramStImage)
  {
    if ((paramStImage.width.get() != 0) && (paramStImage.height.get() != 0))
    {
      ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
      localLayoutParams.height = ViewUtils.dip2px(paramStImage.height.get());
      localLayoutParams.width = ViewUtils.dip2px(paramStImage.width.get());
      paramImageView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void b(FeedCloudMeta.StNotice paramStNotice)
  {
    this.g.setText(paramStNotice.operation.opUser.nick.get());
    Object localObject = (FeedCloudMeta.StUser)this.d.operation.opUser.get();
    a(paramStNotice.message.get());
    b(paramStNotice.subMessage.get());
    c(paramStNotice.summary.get());
    b(this.e);
    a(this.e);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stNotice Message:");
    ((StringBuilder)localObject).append(paramStNotice.message.get());
    ((StringBuilder)localObject).append(" unRead:");
    ((StringBuilder)localObject).append(a());
    QLog.d("FSBaseMessagePresenter", 1, ((StringBuilder)localObject).toString());
    this.i.setText(FSCommonUtil.b(paramStNotice.createTime.get() * 1000L));
  }
  
  private void i()
  {
    this.f.post(new FSBaseMessagePresenter.5(this));
  }
  
  private Object j()
  {
    View localView = this.a;
    if (!(localView instanceof FSBaseWidgetView)) {
      return null;
    }
    return ((FSBaseWidgetView)localView).getReportBean();
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.c = paramContext;
    if (paramView != null)
    {
      this.a = paramView;
      this.f = ((FSAvatarView)paramView.findViewById(2131436271));
      this.g = ((TextView)paramView.findViewById(2131448603));
      this.h = ((FSAsyncTextView)paramView.findViewById(2131448585));
      this.i = ((TextView)paramView.findViewById(2131448588));
      this.b = paramView.findViewById(2131437497);
      this.o = ((LinearLayout)paramView.findViewById(2131446529));
      this.m = ((FSAsyncTextView)paramView.findViewById(2131448766));
      this.n = ((ImageView)paramView.findViewById(2131436258));
      this.p = ((FSAsyncTextView)paramView.findViewById(2131448587));
      this.q = ((ImageView)paramView.findViewById(2131436266));
      this.r = ((ImageView)paramView.findViewById(2131436641));
      this.j = new FSBaseMessagePresenter.4(this);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.b.getLayoutParams();
      localLayoutParams.rightMargin = ImmersiveUtils.dpToPx(30.0F);
      this.b.setLayoutParams(localLayoutParams);
      this.f.setOnClickListener(this.j);
      this.g.setOnClickListener(this.j);
      i();
      b(paramContext, paramView);
    }
  }
  
  public void a(BlockPart paramBlockPart)
  {
    this.k = paramBlockPart;
  }
  
  protected void a(FeedCloudMeta.StNotice paramStNotice) {}
  
  public void a(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    if ((paramStNotice != null) && (paramStNotice.operation.get() != null))
    {
      this.d = paramStNotice;
      this.f.setAvatarUser((FeedCloudMeta.StUser)paramStNotice.operation.opUser.get());
      if (this.d.busiData.get() != null)
      {
        this.e = new QQCircleFeedBase.StNoticeBusiData();
        try
        {
          this.e.mergeFrom(this.d.busiData.get().toByteArray());
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getNoticeBusiData error");
          localStringBuilder.append(localException.getMessage());
          QLog.e("FSBaseMessagePresenter", 1, localStringBuilder.toString());
        }
      }
      b(this.d);
      b(paramStNotice, paramInt);
      c();
      a(this.d);
      VideoReport.traverseExposure();
    }
  }
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.h.setVisibility(8);
      return;
    }
    this.h.setVisibility(0);
    this.h.setOnClickAtTextListener(new FSBaseMessagePresenter.2(this));
    this.h.setText(paramString);
  }
  
  protected void a(QQCircleFeedBase.StNoticeBusiData paramStNoticeBusiData)
  {
    ImageView localImageView = this.r;
    if (localImageView != null)
    {
      int i1;
      if (paramStNoticeBusiData.messageBoxRedPointInfo.needShow.get()) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localImageView.setVisibility(i1);
    }
  }
  
  protected boolean a()
  {
    QQCircleFeedBase.StNoticeBusiData localStNoticeBusiData = this.e;
    return (localStNoticeBusiData != null) && (localStNoticeBusiData.messageBoxRedPointInfo.needShow.get());
  }
  
  protected void b()
  {
    Object localObject = this.e;
    if ((localObject != null) && (((QQCircleFeedBase.StNoticeBusiData)localObject).messageBoxRedPointInfo.needShow.get()))
    {
      localObject = new FSUnReadPointRequest(this.d.operation.opUser.id.get(), 9);
      VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, new FSBaseMessagePresenter.1(this, (FSBaseRequest)localObject));
      localObject = new FSMessageNoticeRequest(null, false);
      if (BaseRequest.isCacheExist((BaseRequest)localObject)) {
        BaseRequest.reMoveCache((BaseRequest)localObject);
      }
      this.e.messageBoxRedPointInfo.needShow.set(false);
      a(this.e);
      this.d.busiData.set(ByteStringMicro.copyFrom(this.e.toByteArray()));
    }
  }
  
  abstract void b(Context paramContext, View paramView);
  
  abstract void b(FeedCloudMeta.StNotice paramStNotice, int paramInt);
  
  protected void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.o.setVisibility(8);
      return;
    }
    this.o.setVisibility(0);
    this.m.setText(paramString.trim());
  }
  
  protected void b(QQCircleFeedBase.StNoticeBusiData paramStNoticeBusiData)
  {
    ImageView localImageView = this.q;
    if (localImageView == null) {
      return;
    }
    localImageView.setVisibility(8);
    if ((paramStNoticeBusiData != null) && (paramStNoticeBusiData.pattonInfo.userCertificationLabel.get() != null))
    {
      paramStNoticeBusiData = (QQCircleFeedBase.StUserCertificationLabel)paramStNoticeBusiData.pattonInfo.userCertificationLabel.get();
      if ((paramStNoticeBusiData != null) && (paramStNoticeBusiData.picInfo.get() != null))
      {
        this.q.setVisibility(0);
        a(this.q, (FeedCloudMeta.StImage)paramStNoticeBusiData.picInfo.get());
        paramStNoticeBusiData = new Option().setUrl(paramStNoticeBusiData.picInfo.picUrl.get()).setTargetView(this.q);
        QCircleFeedPicLoader.g().loadImage(paramStNoticeBusiData, new FSBaseMessagePresenter.3(this));
      }
    }
  }
  
  abstract void c();
  
  protected void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.p.setVisibility(8);
      return;
    }
    this.p.setVisibility(0);
    this.p.setText(paramString);
  }
  
  public String d()
  {
    return e().getPageId();
  }
  
  public FSReportBean e()
  {
    Object localObject = j();
    if (!(localObject instanceof FSReportBean))
    {
      if (!RFApplication.isDebug())
      {
        QLog.e("FSBaseMessagePresenter", 1, "getReportBean but FSReportBean is null");
        return new FSReportBean();
      }
      QLog.e("FSBaseMessagePresenter", 1, "getReportBean but FSReportBean is null , debug");
      throw new RuntimeException("getReportBean but FSReportBean is null");
    }
    return (FSReportBean)localObject;
  }
  
  protected abstract String f();
  
  public void g()
  {
    if (this.d == null) {
      return;
    }
    FSLpReportDc11001.a(new DataBuilder(e()).setActionType(17).setSubActionType(17).setThrActionType(1).setExt2(String.valueOf(this.d.noticeType.get())));
  }
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSBaseMessagePresenter
 * JD-Core Version:    0.7.0.1
 */