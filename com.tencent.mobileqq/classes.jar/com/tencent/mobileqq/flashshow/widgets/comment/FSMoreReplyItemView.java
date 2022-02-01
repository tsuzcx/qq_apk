package com.tencent.mobileqq.flashshow.widgets.comment;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.flashshow.bean.FSReplyItemInfo;
import com.tencent.mobileqq.flashshow.widgets.FSBaseWidgetView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;

public class FSMoreReplyItemView
  extends FSBaseWidgetView<FSReplyItemInfo>
  implements View.OnClickListener
{
  private TextView a;
  private TextView b;
  private FeedCloudMeta.StFeed c;
  private FeedCloudMeta.StComment d;
  private FSReplyItemInfo e;
  private int f;
  private int g;
  private OnCommentElementClickListener h;
  
  public FSMoreReplyItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(FSReplyItemInfo paramFSReplyItemInfo, int paramInt)
  {
    if ((this.c != null) && (this.d != null))
    {
      if (paramFSReplyItemInfo == null) {
        return;
      }
      this.e = paramFSReplyItemInfo;
      this.g = paramInt;
      if (this.e.a == 2)
      {
        this.a.setVisibility(0);
        this.a.setText(getContext().getResources().getString(2131889510, new Object[] { Integer.valueOf(this.e.c) }));
        this.b.setVisibility(8);
        return;
      }
      if (this.e.a == 3)
      {
        this.a.setVisibility(8);
        this.b.setVisibility(0);
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131624785;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    FeedCloudMeta.StComment localStComment;
    if (i == 2131448592)
    {
      if (this.h != null)
      {
        localStComment = this.d;
        i = this.g;
        this.h.a(paramView, 10, this.f, new Object[] { localStComment, Integer.valueOf(i) });
      }
    }
    else if ((i == 2131448557) && (this.h != null))
    {
      localStComment = this.d;
      i = this.g;
      this.h.a(paramView, 11, this.f, new Object[] { localStComment, Integer.valueOf(i) });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131448592));
    this.b = ((TextView)paramView.findViewById(2131448557));
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
  }
  
  public void setOnCommentElementClickListener(OnCommentElementClickListener paramOnCommentElementClickListener)
  {
    this.h = paramOnCommentElementClickListener;
  }
  
  public void setPreData(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, int paramInt)
  {
    this.c = paramStFeed;
    this.d = paramStComment;
    this.f = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSMoreReplyItemView
 * JD-Core Version:    0.7.0.1
 */