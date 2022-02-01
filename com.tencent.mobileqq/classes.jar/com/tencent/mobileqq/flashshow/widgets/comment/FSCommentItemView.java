package com.tencent.mobileqq.flashshow.widgets.comment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.flashshow.adapter.FSCommentReplyAdapter;
import com.tencent.mobileqq.flashshow.bean.FSCommentItemInfo;
import com.tencent.mobileqq.flashshow.events.FSCommentPraiseUpdateEvent;
import com.tencent.mobileqq.flashshow.utils.DateUtils;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.flashshow.utils.FSTransUtils;
import com.tencent.mobileqq.flashshow.widgets.FSBaseWidgetView;
import com.tencent.mobileqq.flashshow.widgets.comment.helper.FSCommentHelper;
import com.tencent.mobileqq.flashshow.widgets.common.FSAsyncTextView;
import com.tencent.mobileqq.flashshow.widgets.common.FSAvatarView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;

public class FSCommentItemView
  extends FSBaseWidgetView<FSCommentItemInfo>
  implements View.OnClickListener, View.OnLongClickListener, SimpleEventReceiver
{
  private int a;
  private OnCommentElementClickListener b;
  private RelativeLayout c;
  private FSAvatarView d;
  private FSAsyncTextView e;
  private FSAsyncTextView f;
  private FeedCloudMeta.StFeed g;
  private FSCommentItemInfo h;
  private FeedCloudMeta.StComment i;
  private Drawable j;
  private Drawable k;
  private Drawable l;
  private Drawable m;
  private FSCommentPraiseLayout n;
  private TextView o;
  private LinearLayout p;
  private RecyclerView q;
  private FSCommentReplyAdapter r;
  
  public FSCommentItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.f.setOnLongClickListener(this);
    this.c.setOnLongClickListener(this);
    FSCommentItemView.1 local1 = new FSCommentItemView.1(this, getContext(), 1, false);
    this.q.setLayoutManager(local1);
  }
  
  private void a(FeedCloudMeta.StComment paramStComment)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramStComment.content.get());
    if (paramStComment.typeFlag.get() == 1)
    {
      if (this.l == null)
      {
        this.l = FSTransUtils.f().getResources().getDrawable(2130840408);
        this.l.setBounds(ImmersiveUtils.dpToPx(2.0F), ImmersiveUtils.dpToPx(1.5F), ImmersiveUtils.dpToPx(30.0F), ImmersiveUtils.dpToPx(15.5F));
      }
      this.f.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.l);
      this.f.a(true);
    }
    else if (FSCommentHelper.a(paramStComment.typeFlag2.get(), 4))
    {
      if (this.m == null)
      {
        this.m = getResources().getDrawable(2130840362);
        this.m.setBounds(ImmersiveUtils.dpToPx(6.0F), ImmersiveUtils.dpToPx(2.0F), ImmersiveUtils.dpToPx(30.0F), ImmersiveUtils.dpToPx(19.0F));
      }
      this.f.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.m);
      this.f.a(true);
    }
    else if (paramStComment.likeInfo.ownerStatus.get() == 1)
    {
      if (this.k == null)
      {
        this.k = FSTransUtils.f().getResources().getDrawable(2130840407);
        this.k.setBounds(ImmersiveUtils.dpToPx(2.0F), ImmersiveUtils.dpToPx(1.5F), ImmersiveUtils.dpToPx(47.0F), ImmersiveUtils.dpToPx(15.5F));
      }
      this.f.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.k);
      this.f.a(true);
    }
    else
    {
      this.f.a(false);
    }
    this.f.setOnClickAtTextListener(new FSCommentItemView.3(this));
    this.f.setText(localSpannableStringBuilder);
  }
  
  @SuppressLint({"UseCompatLoadingForDrawables"})
  public void a(FSCommentItemInfo paramFSCommentItemInfo, int paramInt)
  {
    if ((this.g != null) && (paramFSCommentItemInfo != null))
    {
      if (paramFSCommentItemInfo.a == null) {
        return;
      }
      this.a = paramInt;
      this.h = paramFSCommentItemInfo;
      this.i = paramFSCommentItemInfo.a;
      if ((this.i.postUser != null) && (this.i.postUser.nick.get() != null))
      {
        this.d.setAvatarUser(this.i.postUser);
        paramFSCommentItemInfo = new SpannableStringBuilder(this.i.postUser.nick.get());
        if (this.i.postUser.id.get().equals(this.g.poster.id.get()))
        {
          if (this.j == null)
          {
            this.j = FSTransUtils.f().getResources().getDrawable(2130840406);
            this.j.setBounds(ImmersiveUtils.dpToPx(2.0F), ImmersiveUtils.dpToPx(1.5F), ImmersiveUtils.dpToPx(30.0F), ImmersiveUtils.dpToPx(15.5F));
          }
          this.e.a(paramFSCommentItemInfo, paramFSCommentItemInfo.length(), this.j);
          this.e.a(true);
        }
        else
        {
          this.e.a(false);
        }
        this.e.setText(paramFSCommentItemInfo);
      }
      this.n.setData(1, this.g, this.i, null, true);
      this.n.setOnClickHookListener(new FSCommentItemView.2(this));
      a(this.i);
      this.o.setText(DateUtils.a(this.i.createTime.get() * 1000L));
      if ((this.h.b != null) && (this.h.b.size() > 0))
      {
        this.p.setVisibility(0);
        if (this.r == null)
        {
          this.r = new FSCommentReplyAdapter();
          this.q.setAdapter(this.r);
        }
        this.r.a(this.g, this.i, this.h.b, this.a);
        this.r.a(this.b);
        this.r.notifyDataSetChanged();
        return;
      }
      this.p.setVisibility(8);
    }
  }
  
  public FeedCloudMeta.StComment getComment()
  {
    return this.i;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FSCommentPraiseUpdateEvent.class);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return 2131624784;
  }
  
  public FSCommentReplyAdapter getReplyAdapter()
  {
    return this.r;
  }
  
  public RecyclerView getRvReplyList()
  {
    return this.q;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
    FSCommentPraiseLayout localFSCommentPraiseLayout = this.n;
    if (localFSCommentPraiseLayout != null) {
      localFSCommentPraiseLayout.setReportBean(getReportBean());
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    OnCommentElementClickListener localOnCommentElementClickListener;
    FeedCloudMeta.StComment localStComment;
    if (i1 == 2131428988)
    {
      localOnCommentElementClickListener = this.b;
      if (localOnCommentElementClickListener != null)
      {
        localStComment = this.i;
        if (localStComment != null) {
          localOnCommentElementClickListener.a(paramView, 1, this.a, localStComment.postUser);
        }
      }
    }
    else if (i1 == 2131440558)
    {
      localOnCommentElementClickListener = this.b;
      if (localOnCommentElementClickListener != null)
      {
        localStComment = this.i;
        if (localStComment != null) {
          localOnCommentElementClickListener.a(paramView, 2, this.a, localStComment.postUser);
        }
      }
    }
    else if ((i1 == 2131440538) || (i1 == 2131431066))
    {
      localOnCommentElementClickListener = this.b;
      if (localOnCommentElementClickListener != null) {
        localOnCommentElementClickListener.a(paramView, 4, this.a, this.i);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.c = ((RelativeLayout)paramView.findViewById(2131431066));
    this.p = ((LinearLayout)paramView.findViewById(2131444639));
    this.d = ((FSAvatarView)paramView.findViewById(2131428988));
    this.e = ((FSAsyncTextView)paramView.findViewById(2131440558));
    this.f = ((FSAsyncTextView)paramView.findViewById(2131440538));
    this.n = ((FSCommentPraiseLayout)paramView.findViewById(2131440580));
    this.o = ((TextView)paramView.findViewById(2131431073));
    this.q = ((RecyclerView)paramView.findViewById(2131444647));
    a();
  }
  
  public boolean onLongClick(View paramView)
  {
    int i1 = paramView.getId();
    if ((i1 != 2131440538) && (i1 != 2131431066)) {
      return false;
    }
    OnCommentElementClickListener localOnCommentElementClickListener = this.b;
    if (localOnCommentElementClickListener != null) {
      localOnCommentElementClickListener.b(paramView, 5, this.a, this.i);
    }
    return true;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof FSCommentPraiseUpdateEvent)) && (this.g != null) && (this.i != null))
    {
      paramSimpleBaseEvent = (FSCommentPraiseUpdateEvent)paramSimpleBaseEvent;
      if (!TextUtils.equals(paramSimpleBaseEvent.mFeedId, this.g.id.get())) {
        return;
      }
      if ((paramSimpleBaseEvent.mType == 1) && (TextUtils.equals(paramSimpleBaseEvent.mCommentId, this.i.id.get())))
      {
        if (FSCommonUtil.a(this.g.poster.id.get())) {
          this.i.likeInfo.ownerStatus.set(paramSimpleBaseEvent.mPraisedStatus);
        }
        this.i.likeInfo.status.set(paramSimpleBaseEvent.mPraisedStatus);
        this.i.likeInfo.count.set(paramSimpleBaseEvent.mPraisedNum);
        a(this.i);
      }
    }
  }
  
  public void setFeed(FeedCloudMeta.StFeed paramStFeed)
  {
    this.g = paramStFeed;
  }
  
  public void setOnCommentElementClickListener(OnCommentElementClickListener paramOnCommentElementClickListener)
  {
    this.b = paramOnCommentElementClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSCommentItemView
 * JD-Core Version:    0.7.0.1
 */