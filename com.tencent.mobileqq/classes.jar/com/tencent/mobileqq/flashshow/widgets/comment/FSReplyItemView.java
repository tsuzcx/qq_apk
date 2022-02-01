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
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.flashshow.bean.FSReplyItemInfo;
import com.tencent.mobileqq.flashshow.events.FSCommentPraiseUpdateEvent;
import com.tencent.mobileqq.flashshow.utils.DateUtils;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.flashshow.utils.FSHardCodeUtil;
import com.tencent.mobileqq.flashshow.utils.FSTransUtils;
import com.tencent.mobileqq.flashshow.widgets.FSBaseWidgetView;
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
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;

public class FSReplyItemView
  extends FSBaseWidgetView<FSReplyItemInfo>
  implements View.OnClickListener, View.OnLongClickListener, SimpleEventReceiver
{
  private final String a = FSHardCodeUtil.a(2131910888);
  private int b;
  private int c;
  private OnCommentElementClickListener d;
  private FSAsyncTextView e;
  private FSAsyncTextView f;
  private FeedCloudMeta.StFeed g;
  private FeedCloudMeta.StComment h;
  private FSReplyItemInfo i;
  private FeedCloudMeta.StReply j;
  private Drawable k;
  private Drawable l;
  private Drawable m;
  private FSCommentPraiseLayout n;
  private FSAvatarView o;
  private TextView p;
  
  public FSReplyItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.o.setOnClickListener(this);
    setOnClickListener(this);
    this.f.setOnLongClickListener(this);
    setOnLongClickListener(this);
  }
  
  @SuppressLint({"UseCompatLoadingForDrawables"})
  private void a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (this.g == null) {
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramStComment != null) && (paramStReply.targetUser != null) && (!TextUtils.isEmpty(paramStReply.targetUser.id.get())))
    {
      localSpannableStringBuilder.append(this.a).append(paramStReply.targetUser.nick.get());
      this.f.a(localSpannableStringBuilder, this.a.length(), this.a.length() + paramStReply.targetUser.nick.get().length(), new FSReplyItemView.2(this, paramStReply), getContext().getResources().getColor(2131166068), true);
      if (paramStReply.targetUser.id.get().equals(this.g.poster.id.get()))
      {
        if (this.k == null)
        {
          this.k = FSTransUtils.f().getResources().getDrawable(2130840406);
          this.k.setBounds(ImmersiveUtils.dpToPx(2.0F), ImmersiveUtils.dpToPx(1.5F), ImmersiveUtils.dpToPx(30.0F), ImmersiveUtils.dpToPx(15.5F));
        }
        this.f.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.k);
      }
      localSpannableStringBuilder.append("：");
    }
    localSpannableStringBuilder.append(paramStReply.content.get());
    if (paramStReply.typeFlag.get() == 1)
    {
      if (this.m == null)
      {
        this.m = FSTransUtils.f().getResources().getDrawable(2130840408);
        this.m.setBounds(ImmersiveUtils.dpToPx(2.0F), ImmersiveUtils.dpToPx(1.5F), ImmersiveUtils.dpToPx(30.0F), ImmersiveUtils.dpToPx(15.5F));
      }
      this.f.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.m);
      this.f.a(true);
    }
    else if (paramStReply.likeInfo.ownerStatus.get() == 1)
    {
      if (this.l == null)
      {
        this.l = FSTransUtils.f().getResources().getDrawable(2130840407);
        this.l.setBounds(ImmersiveUtils.dpToPx(2.0F), ImmersiveUtils.dpToPx(1.5F), ImmersiveUtils.dpToPx(47.0F), ImmersiveUtils.dpToPx(15.5F));
      }
      this.f.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.l);
      this.f.a(true);
    }
    else
    {
      this.f.a(false);
    }
    this.f.setOnClickAtTextListener(new FSReplyItemView.3(this));
    this.f.setText(localSpannableStringBuilder);
  }
  
  private void a(String paramString) {}
  
  public void a(FSReplyItemInfo paramFSReplyItemInfo, int paramInt)
  {
    if ((this.g != null) && (this.h != null) && (paramFSReplyItemInfo != null))
    {
      if (paramFSReplyItemInfo.b == null) {
        return;
      }
      this.c = paramInt;
      this.i = paramFSReplyItemInfo;
      this.j = paramFSReplyItemInfo.b;
      if ((this.j.postUser != null) && (this.j.postUser.nick.get() != null))
      {
        this.o.setAvatarUser(this.j.postUser);
        paramFSReplyItemInfo = new SpannableStringBuilder(this.j.postUser.nick.get());
        if (this.j.postUser.id.get().equals(this.g.poster.id.get()))
        {
          if (this.k == null)
          {
            this.k = FSTransUtils.f().getResources().getDrawable(2130840406);
            this.k.setBounds(ImmersiveUtils.dpToPx(2.0F), ImmersiveUtils.dpToPx(1.5F), ImmersiveUtils.dpToPx(30.0F), ImmersiveUtils.dpToPx(15.5F));
          }
          this.e.a(paramFSReplyItemInfo, paramFSReplyItemInfo.length(), this.k);
          this.e.a(true);
        }
        else
        {
          this.e.a(false);
        }
        this.e.setText(paramFSReplyItemInfo);
      }
      this.p.setText(DateUtils.a(this.j.createTime.get() * 1000L));
      a(this.h, this.j);
      this.n.setData(2, this.g, this.h, this.j, true);
      this.n.setOnClickHookListener(new FSReplyItemView.1(this));
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FSCommentPraiseUpdateEvent.class);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return 2131624858;
  }
  
  protected String getLogTag()
  {
    return "FSReplyItemView";
  }
  
  public FeedCloudMeta.StReply getReply()
  {
    return this.j;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    OnCommentElementClickListener localOnCommentElementClickListener;
    if (i1 == 2131428988)
    {
      localOnCommentElementClickListener = this.d;
      if ((localOnCommentElementClickListener != null) && (this.h != null)) {
        localOnCommentElementClickListener.a(paramView, 1, this.c, this.j.postUser);
      }
    }
    else
    {
      Object localObject;
      if (i1 == 2131444654)
      {
        localOnCommentElementClickListener = this.d;
        if (localOnCommentElementClickListener != null)
        {
          localObject = this.j;
          if (localObject != null) {
            localOnCommentElementClickListener.a(paramView, 2, this.b, ((FeedCloudMeta.StReply)localObject).postUser);
          }
        }
      }
      else
      {
        FeedCloudMeta.StReply localStReply;
        if (i1 == 2131444652)
        {
          localOnCommentElementClickListener = this.d;
          if (localOnCommentElementClickListener != null)
          {
            localObject = this.h;
            localStReply = this.j;
            localOnCommentElementClickListener.a(paramView, 7, this.b, new Object[] { localObject, localStReply });
          }
        }
        else if ((paramView instanceof FSReplyItemView))
        {
          localOnCommentElementClickListener = this.d;
          if (localOnCommentElementClickListener != null)
          {
            localObject = this.h;
            localStReply = this.j;
            localOnCommentElementClickListener.a(paramView, 7, this.b, new Object[] { localObject, localStReply });
          }
        }
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
    this.e = ((FSAsyncTextView)paramView.findViewById(2131444654));
    this.f = ((FSAsyncTextView)paramView.findViewById(2131444652));
    this.n = ((FSCommentPraiseLayout)paramView.findViewById(2131440580));
    this.o = ((FSAvatarView)paramView.findViewById(2131428988));
    this.p = ((TextView)paramView.findViewById(2131448705));
    a();
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView.getId() == 2131444652)
    {
      OnCommentElementClickListener localOnCommentElementClickListener = this.d;
      if (localOnCommentElementClickListener != null)
      {
        FeedCloudMeta.StComment localStComment = this.h;
        FeedCloudMeta.StReply localStReply = this.j;
        localOnCommentElementClickListener.b(paramView, 8, this.b, new Object[] { localStComment, localStReply });
      }
      return true;
    }
    return false;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof FSCommentPraiseUpdateEvent)) && (this.g != null) && (this.h != null) && (this.j != null))
    {
      paramSimpleBaseEvent = (FSCommentPraiseUpdateEvent)paramSimpleBaseEvent;
      if (!TextUtils.equals(paramSimpleBaseEvent.mFeedId, this.g.id.get())) {
        return;
      }
      if ((paramSimpleBaseEvent.mType == 2) && (TextUtils.equals(paramSimpleBaseEvent.mCommentId, this.h.id.get())) && (TextUtils.equals(paramSimpleBaseEvent.mReplyId, this.j.id.get())))
      {
        if (FSCommonUtil.a((FeedCloudMeta.StUser)this.g.poster.get())) {
          this.j.likeInfo.ownerStatus.set(paramSimpleBaseEvent.mPraisedStatus);
        }
        this.j.likeInfo.status.set(paramSimpleBaseEvent.mPraisedStatus);
        this.j.likeInfo.count.set(paramSimpleBaseEvent.mPraisedNum);
        a(this.h, this.j);
      }
    }
  }
  
  public void setOnCommentElementClickListener(OnCommentElementClickListener paramOnCommentElementClickListener)
  {
    this.d = paramOnCommentElementClickListener;
  }
  
  public void setPreData(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, int paramInt)
  {
    this.g = paramStFeed;
    this.h = paramStComment;
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSReplyItemView
 * JD-Core Version:    0.7.0.1
 */