package com.tencent.mobileqq.flashshow.widgets.comment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.flashshow.api.bean.FSReportBean;
import com.tencent.mobileqq.flashshow.events.FSCommentPraiseUpdateEvent;
import com.tencent.mobileqq.flashshow.inject.FSToast;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002.DataBuilder;
import com.tencent.mobileqq.flashshow.request.comment.FSWriteCommentLikeRequest;
import com.tencent.mobileqq.flashshow.request.comment.FSWriteCommentLikeRequest.FSWriteLikeCommentRequestBuilder;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.flashshow.utils.FSHardCodeUtil;
import com.tencent.mobileqq.flashshow.utils.FSToastUtil;
import com.tencent.mobileqq.flashshow.utils.FSTransUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;

public class FSCommentPraiseLayout
  extends LinearLayout
  implements View.OnClickListener, SimpleEventReceiver
{
  private int a;
  private boolean b = true;
  private TextView c;
  private ImageView d;
  private FeedCloudMeta.StFeed e;
  private FeedCloudMeta.StComment f;
  private FeedCloudMeta.StReply g;
  private boolean h;
  private FSCommentPraiseLayout.OnClickHookListener i;
  private int j = 2130841169;
  private int k = 2130840432;
  private FSReportBean l;
  
  public FSCommentPraiseLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public FSCommentPraiseLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public FSCommentPraiseLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  @SuppressLint({"UseCompatLoadingForDrawables"})
  private Drawable a(int paramInt)
  {
    try
    {
      Drawable localDrawable = FSTransUtils.f().getResources().getDrawable(paramInt);
      return localDrawable;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("FSC-FSCommentPraiseLayout", 1, "[getDrawable] error:", localThrowable);
    }
    return null;
  }
  
  private void a()
  {
    setOrientation(0);
    setGravity(16);
    this.c = new TextView(getContext());
    this.c.setTextSize(1, 12.0F);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = ViewUtils.dip2px(3.0F);
    localLayoutParams.gravity = 16;
    localLayoutParams.bottomMargin = ViewUtils.dip2px(0.5F);
    addView(this.c, localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(20.0F), ViewUtils.dip2px(20.0F));
    localLayoutParams.gravity = 16;
    this.d = new ImageView(getContext());
    addView(this.d, localLayoutParams);
    this.d.setOnClickListener(this);
    setTouchDelegate(this.d, 30);
  }
  
  private int b(int paramInt)
  {
    try
    {
      paramInt = FSTransUtils.f().getResources().getColor(paramInt);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("FSC-FSCommentPraiseLayout", 1, "[getDrawable] error:", localThrowable);
    }
    return -1;
  }
  
  private void b()
  {
    try
    {
      this.d.setBackgroundDrawable(a(this.k));
      this.d.setVisibility(0);
      this.c.setTextColor(b(2131166072));
      return;
    }
    catch (Exception localException)
    {
      label37:
      break label37;
    }
    QLog.e("FSC-FSCommentPraiseLayout", 1, "showLikeView setBackgroundDrawable error");
  }
  
  private void c()
  {
    try
    {
      this.d.setBackgroundDrawable(a(this.j));
      this.d.setVisibility(0);
      this.c.setTextColor(b(2131166076));
      return;
    }
    catch (Exception localException)
    {
      label37:
      break label37;
    }
    QLog.e("FSC-FSCommentPraiseLayout", 1, "showUnLikeView setBackgroundDrawable error");
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (paramInt == 1) {
      b();
    } else if (paramInt == 0) {
      c();
    }
    if (this.h)
    {
      if (paramLong == 0L)
      {
        this.c.setVisibility(4);
        return;
      }
      this.c.setVisibility(0);
      this.c.setText(FSCommonUtil.a(paramLong));
      return;
    }
    this.c.setVisibility(4);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FSCommentPraiseUpdateEvent.class);
    return localArrayList;
  }
  
  public FeedCloudMeta.StFeed getFeedData()
  {
    return this.e;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onClick(View paramView)
  {
    if (this.e != null) {
      if (!this.b)
      {
        FSToast.a(FSToastUtil.a, FSHardCodeUtil.a(2131900364), 0);
      }
      else
      {
        this.b = false;
        FeedCloudMeta.StLike localStLike = new FeedCloudMeta.StLike();
        if (this.a == 1)
        {
          localObject = this.f;
          if (localObject != null)
          {
            localStLike = (FeedCloudMeta.StLike)((FeedCloudMeta.StComment)localObject).likeInfo.get();
            if (localStLike.status.get() == 0)
            {
              m = 3;
              break label155;
            }
            m = 4;
            break label155;
          }
        }
        if (this.a == 2)
        {
          localObject = this.g;
          if (localObject != null)
          {
            localStLike = (FeedCloudMeta.StLike)((FeedCloudMeta.StReply)localObject).likeInfo.get();
            if (localStLike.status.get() == 0)
            {
              m = 5;
              break label155;
            }
            m = 6;
            break label155;
          }
        }
        int m = 0;
        label155:
        Object localObject = this.i;
        if (localObject != null)
        {
          boolean bool;
          if (localStLike.status.get() == 0) {
            bool = true;
          } else {
            bool = false;
          }
          ((FSCommentPraiseLayout.OnClickHookListener)localObject).a(bool);
        }
        int i1;
        if (localStLike.status.get() == 0) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        int n = this.a;
        int i2 = -1;
        if (n == 1)
        {
          localObject = this.f;
          if (localObject != null)
          {
            i3 = ((FeedCloudMeta.StComment)localObject).likeInfo.count.get();
            n = i3;
            if (i1 != 1) {}
          }
        }
        for (n = i3;; n = i3)
        {
          i2 = 1;
          do
          {
            i3 = n;
            n = i2 + n;
            break label330;
            if (this.a != 2) {
              break;
            }
            localObject = this.g;
            if (localObject == null) {
              break;
            }
            i3 = ((FeedCloudMeta.StReply)localObject).likeInfo.count.get();
            n = i3;
          } while (i1 != 1);
        }
        n = 0;
        int i3 = 0;
        label330:
        a(i1, n);
        i2 = localStLike.status.get();
        localObject = FSWriteCommentLikeRequest.FSWriteLikeCommentRequestBuilder.a();
        ((FSWriteCommentLikeRequest.FSWriteLikeCommentRequestBuilder)localObject).a(this.e).a(m).a(localStLike).a(this.f).a(this.g).a(false);
        if (i1 == 1) {
          FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(this.e, this.l).a(50).b(2).a(this.e.poster.id.get()));
        } else {
          FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(this.e, this.l).a(51).b(2).a(this.e.poster.id.get()));
        }
        VSNetworkHelper.getInstance().sendRequest(getContext(), new FSWriteCommentLikeRequest((FSWriteCommentLikeRequest.FSWriteLikeCommentRequestBuilder)localObject), new FSCommentPraiseLayout.1(this, i1, n, i2, i3));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof FSCommentPraiseUpdateEvent)) && (this.e != null))
    {
      paramSimpleBaseEvent = (FSCommentPraiseUpdateEvent)paramSimpleBaseEvent;
      if (TextUtils.equals(paramSimpleBaseEvent.mFeedId, this.e.id.get()))
      {
        FeedCloudMeta.StComment localStComment;
        if ((this.a == 1) && (paramSimpleBaseEvent.mType == 1))
        {
          localStComment = this.f;
          if ((localStComment != null) && (TextUtils.equals(localStComment.id.get(), paramSimpleBaseEvent.mCommentId)))
          {
            this.f.likeInfo.status.set(paramSimpleBaseEvent.mPraisedStatus);
            this.f.likeInfo.count.set(paramSimpleBaseEvent.mPraisedNum);
            a(paramSimpleBaseEvent.mPraisedStatus, paramSimpleBaseEvent.mPraisedNum);
            return;
          }
        }
        if ((this.a == 2) && (paramSimpleBaseEvent.mType == 2))
        {
          localStComment = this.f;
          if ((localStComment != null) && (this.g != null) && (TextUtils.equals(localStComment.id.get(), paramSimpleBaseEvent.mCommentId)) && (TextUtils.equals(this.g.id.get(), paramSimpleBaseEvent.mReplyId)))
          {
            this.g.likeInfo.status.set(paramSimpleBaseEvent.mPraisedStatus);
            this.g.likeInfo.count.set(paramSimpleBaseEvent.mPraisedNum);
            a(paramSimpleBaseEvent.mPraisedStatus, paramSimpleBaseEvent.mPraisedNum);
          }
        }
      }
    }
  }
  
  public void setData(int paramInt, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    setData(paramInt, paramStFeed, paramStComment, paramStReply, false);
  }
  
  public void setData(int paramInt, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, boolean paramBoolean)
  {
    setVisibility(8);
    if (paramStFeed == null) {
      return;
    }
    this.a = paramInt;
    this.e = paramStFeed;
    this.f = paramStComment;
    this.g = paramStReply;
    this.h = paramBoolean;
    paramInt = this.a;
    if (paramInt == 1)
    {
      paramStFeed = this.f;
      if (paramStFeed != null)
      {
        a(paramStFeed.likeInfo.status.get(), this.f.likeInfo.count.get());
        setVisibility(0);
      }
    }
    else if (paramInt == 2)
    {
      paramStFeed = this.g;
      if (paramStFeed != null)
      {
        a(paramStFeed.likeInfo.status.get(), this.g.likeInfo.count.get());
        setVisibility(0);
      }
    }
  }
  
  public void setOnClickHookListener(FSCommentPraiseLayout.OnClickHookListener paramOnClickHookListener)
  {
    this.i = paramOnClickHookListener;
  }
  
  public void setReportBean(FSReportBean paramFSReportBean)
  {
    this.l = paramFSReportBean;
  }
  
  public void setTouchDelegate(View paramView, int paramInt)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      View localView = (View)paramView.getParent();
      localView.post(new FSCommentPraiseLayout.2(this, paramView, paramInt, localView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSCommentPraiseLayout
 * JD-Core Version:    0.7.0.1
 */