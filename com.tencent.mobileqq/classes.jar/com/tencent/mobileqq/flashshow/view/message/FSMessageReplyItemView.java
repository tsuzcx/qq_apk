package com.tencent.mobileqq.flashshow.view.message;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.flashshow.api.bean.FSPersonalDetailBean;
import com.tencent.mobileqq.flashshow.bean.FSFeedCommentInfo;
import com.tencent.mobileqq.flashshow.launcher.FSNativeLauncher;
import com.tencent.mobileqq.flashshow.utils.FSHardCodeUtil;
import com.tencent.mobileqq.flashshow.widgets.FSBaseWidgetView;
import com.tencent.mobileqq.flashshow.widgets.common.FSAsyncTextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

public class FSMessageReplyItemView
  extends FSBaseWidgetView<FSFeedCommentInfo>
  implements View.OnClickListener
{
  private final String a = FSHardCodeUtil.a(2131889740);
  private FSAsyncTextView b;
  private FSFeedCommentInfo c;
  private FSMessageReplyItemView.FSMessageReplyItemListener d;
  private int e;
  
  public FSMessageReplyItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(FSAsyncTextView paramFSAsyncTextView)
  {
    if (paramFSAsyncTextView != null)
    {
      paramFSAsyncTextView.a(false);
      paramFSAsyncTextView.setText("");
      paramFSAsyncTextView.setVisibility(8);
    }
  }
  
  private void a(String paramString)
  {
    FSPersonalDetailBean localFSPersonalDetailBean = new FSPersonalDetailBean(getReportBean());
    localFSPersonalDetailBean.setUin(paramString);
    FSNativeLauncher.a(getContext(), localFSPersonalDetailBean);
  }
  
  public void a(FSFeedCommentInfo paramFSFeedCommentInfo, int paramInt)
  {
    if (paramFSFeedCommentInfo == null) {
      return;
    }
    this.c = paramFSFeedCommentInfo;
    this.e = paramInt;
    if (this.c.b == null) {
      return;
    }
    setReplyTxt(this.c.c);
  }
  
  public int getLayoutId()
  {
    return 2131624827;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131433852)
    {
      Object localObject = this.c;
      if ((localObject != null) && (((FSFeedCommentInfo)localObject).a != null) && (this.c.b != null))
      {
        localObject = this.d;
        if (localObject != null) {
          ((FSMessageReplyItemView.FSMessageReplyItemListener)localObject).a(paramView, this.c);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.b = ((FSAsyncTextView)paramView.findViewById(2131433852));
    this.b.setOnClickListener(this);
  }
  
  public void setReplyItemListener(FSMessageReplyItemView.FSMessageReplyItemListener paramFSMessageReplyItemListener)
  {
    this.d = paramFSMessageReplyItemListener;
  }
  
  public void setReplyTxt(FeedCloudMeta.StReply paramStReply)
  {
    a(this.b);
    if ((paramStReply != null) && (this.b != null) && (this.c != null))
    {
      if (TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        localObject = this.c.b.postUser;
      } else {
        localObject = paramStReply.targetUser;
      }
      String str = ((FeedCloudMeta.StUser)localObject).id.get();
      if (TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        localObject = this.c.b.postUser;
      } else {
        localObject = paramStReply.targetUser;
      }
      Object localObject = ((FeedCloudMeta.StUser)localObject).nick.get();
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(paramStReply.postUser.nick.get()).append(this.a).append((CharSequence)localObject).append("：").append(paramStReply.content.get());
      this.b.a(localSpannableStringBuilder, 0, paramStReply.postUser.nick.get().length(), new FSMessageReplyItemView.1(this, paramStReply));
      this.b.a(localSpannableStringBuilder, paramStReply.postUser.nick.get().length() + this.a.length(), paramStReply.postUser.nick.get().length() + this.a.length() + ((String)localObject).length(), new FSMessageReplyItemView.2(this, str));
      this.b.setOnClickAtTextListener(new FSMessageReplyItemView.3(this));
      this.b.setText(localSpannableStringBuilder);
      this.b.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.view.message.FSMessageReplyItemView
 * JD-Core Version:    0.7.0.1
 */