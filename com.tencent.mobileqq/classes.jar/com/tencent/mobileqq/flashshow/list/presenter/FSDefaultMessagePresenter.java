package com.tencent.mobileqq.flashshow.list.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.flashshow.api.bean.FSInitBean;
import com.tencent.mobileqq.flashshow.api.bean.FSLayerPageInitBean;
import com.tencent.mobileqq.flashshow.api.data.DataBuilder;
import com.tencent.mobileqq.flashshow.launcher.FSNativeLauncher;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11001;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.flashshow.view.SquareImageView;
import com.tencent.mobileqq.flashshow.widgets.common.FSAsyncTextView;
import com.tencent.mobileqq.flashshow.widgets.common.FSSquareImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class FSDefaultMessagePresenter
  extends FSBaseMessagePresenter
{
  protected FSSquareImageView q;
  protected SquareImageView r;
  protected View s;
  protected View.OnClickListener t;
  protected View.OnClickListener u;
  protected View.OnClickListener v;
  protected View.OnClickListener w;
  private ViewStub x;
  
  public FSDefaultMessagePresenter(int paramInt)
  {
    super(paramInt);
  }
  
  private void b(FeedCloudMeta.StNotice paramStNotice)
  {
    if (!TextUtils.isEmpty(paramStNotice.feed.cover.picUrl.get()))
    {
      if (this.s == null)
      {
        localObject = this.x;
        if (localObject != null) {
          this.s = ((ViewStub)localObject).inflate();
        }
      }
      Object localObject = this.s;
      if (localObject != null)
      {
        this.q = ((FSSquareImageView)((View)localObject).findViewById(2131436373));
        this.r = ((SquareImageView)this.s.findViewById(2131436374));
        localObject = this.s;
        int i = 0;
        ((View)localObject).setVisibility(0);
        this.q.setRoundRect(ViewUtils.dip2px(4.0F));
        if ((this.q.getTag(2131433864) instanceof String)) {
          localObject = (String)this.q.getTag(2131433864);
        } else {
          localObject = "";
        }
        String str = paramStNotice.feed.cover.picUrl.get();
        this.q.setTag(2131433864, str);
        if (!((String)localObject).equals(str))
        {
          localObject = new Option().setUrl(str).setTargetView(this.q).setFromPreLoad(false).setPredecode(true).setRequestWidth(this.q.getWidth()).setRequestHeight(this.q.getHeight());
          QCircleFeedPicLoader.g().loadImage((Option)localObject, new FSDefaultMessagePresenter.1(this));
        }
        localObject = this.r;
        if (!FSCommonUtil.b(paramStNotice.feed)) {
          i = 8;
        }
        ((SquareImageView)localObject).setVisibility(i);
        this.s.setOnClickListener(k());
      }
    }
  }
  
  private void m()
  {
    if (this.d == null) {
      return;
    }
    FSLpReportDc11001.a(new DataBuilder(e()).setActionType(17).setSubActionType(3).setThrActionType(0).setToUin(this.d.feed.poster.id.get()).setExt2(String.valueOf(this.d.noticeType.get())));
  }
  
  protected void a(View paramView, boolean paramBoolean)
  {
    if (this.d == null) {
      return;
    }
    FSLayerPageInitBean localFSLayerPageInitBean = new FSLayerPageInitBean(e());
    localFSLayerPageInitBean.setSourceType(1002);
    localFSLayerPageInitBean.setFeedId(this.d.feed.id.get());
    localFSLayerPageInitBean.setUserId(this.d.feed.poster.id.get());
    localFSLayerPageInitBean.setCreateTime(this.d.feed.createTime.get());
    if (paramBoolean) {
      a(localFSLayerPageInitBean);
    }
    FSNativeLauncher.a(paramView.getContext(), localFSLayerPageInitBean);
  }
  
  protected void a(FSInitBean paramFSInitBean)
  {
    if ((this.l == 13) && (this.d != null) && (this.d.operation != null) && (this.d.operation.like != null))
    {
      QQCircleFeedBase.StLikeBusiData localStLikeBusiData = new QQCircleFeedBase.StLikeBusiData();
      try
      {
        localStLikeBusiData.mergeFrom(this.d.operation.like.busiData.get().toByteArray());
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      paramFSInitBean.setPolyLike((QQCircleFeedBase.StPolyLike)localStLikeBusiData.curPolyLikeInfo.get());
      paramFSInitBean = new StringBuilder();
      paramFSInitBean.append("fullscreen url");
      paramFSInitBean.append(localStLikeBusiData.curPolyLikeInfo.fullScreenURLAND.get());
      QLog.d("FSDefaultMessagePresenter", 1, paramFSInitBean.toString());
    }
  }
  
  public void b(Context paramContext, View paramView)
  {
    this.x = ((ViewStub)paramView.findViewById(2131433879));
  }
  
  public void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    b(paramStNotice);
  }
  
  public void c()
  {
    if (this.a != null) {
      this.a.setOnClickListener(i());
    }
    if (this.h != null) {
      this.h.setOnClickListener(j());
    }
    if (this.m != null) {
      this.m.setOnClickListener(l());
    }
    if (this.n != null) {
      this.n.setOnClickListener(l());
    }
    if (this.p != null) {
      this.p.setOnClickListener(i());
    }
  }
  
  protected String f()
  {
    return "FSDefaultMessagePresenter";
  }
  
  protected View.OnClickListener i()
  {
    if (this.u == null) {
      this.u = new FSDefaultMessagePresenter.2(this);
    }
    return this.u;
  }
  
  protected View.OnClickListener j()
  {
    if ((this.o != null) && (this.o.getVisibility() == 0)) {
      return l();
    }
    return i();
  }
  
  protected View.OnClickListener k()
  {
    if (this.t == null) {
      this.t = new FSDefaultMessagePresenter.3(this);
    }
    return this.t;
  }
  
  protected View.OnClickListener l()
  {
    if (this.w == null) {
      this.w = new FSDefaultMessagePresenter.4(this);
    }
    return this.w;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSDefaultMessagePresenter
 * JD-Core Version:    0.7.0.1
 */