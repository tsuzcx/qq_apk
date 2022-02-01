package com.tencent.mobileqq.flashshow.list.presenter;

import android.content.Context;
import android.os.Handler;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter.LoadMoreViewHolder;
import com.tencent.mobileqq.flashshow.api.data.DataBuilder;
import com.tencent.mobileqq.flashshow.bean.FSFeedCommentInfo;
import com.tencent.mobileqq.flashshow.list.adapter.FSMessageReplyAdapter;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11001;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.flashshow.widgets.comment.dialog.SoftKeyboardStateHelper;
import com.tencent.mobileqq.flashshow.widgets.comment.helper.FSCommentHelper;
import com.tencent.mobileqq.flashshow.widgets.comment.helper.FSCommentHelper.CommentInputListener;
import com.tencent.mobileqq.flashshow.widgets.comment.helper.FSCommentHelper.FSCommentUpdateListener;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FSReplyMessagePresenter
  extends FSDefaultMessagePresenter
  implements FSCommentHelper.FSCommentUpdateListener
{
  private FSMessageReplyAdapter A;
  private RecyclerView B;
  private View C;
  private SoftKeyboardStateHelper D;
  private RecyclerView x;
  private FSFeedCommentInfo y;
  private FSCommentHelper.CommentInputListener z;
  
  public FSReplyMessagePresenter(int paramInt)
  {
    super(paramInt);
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.B;
    if (localObject != null)
    {
      if (((RecyclerView)localObject).getChildCount() <= 0) {
        return;
      }
      localObject = this.B;
      localObject = ((RecyclerView)localObject).getChildAt(((RecyclerView)localObject).getChildCount() - 1);
      if (localObject == null) {
        return;
      }
      if (!(this.B.findContainingViewHolder((View)localObject) instanceof PullLoadMoreAdapter.LoadMoreViewHolder)) {
        return;
      }
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("changeMarginToFooterHolder   paddingTop: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("FSReplyMessagePresenter", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    arrayOfInt[1] += paramView.getHeight();
    int i = FSCommentHelper.a().b();
    if (arrayOfInt[1] > i)
    {
      Object localObject = this.B;
      if (localObject != null)
      {
        ((RecyclerView)localObject).scrollBy(0, arrayOfInt[1] - i);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("scrollItemToVisbleAboveInputLayout  scrollBy: ");
        ((StringBuilder)localObject).append(arrayOfInt[1] - i);
        QLog.i("FSReplyMessagePresenter", 1, ((StringBuilder)localObject).toString());
        a(arrayOfInt[1] - i);
        RFThreadManager.getUIHandler().postDelayed(new FSReplyMessagePresenter.6(this, paramView, arrayOfInt, i), 1L);
      }
    }
  }
  
  private void a(FSFeedCommentInfo paramFSFeedCommentInfo)
  {
    if (paramFSFeedCommentInfo == null) {
      return;
    }
    int i = this.l;
    DataBuilder localDataBuilder2 = null;
    DataBuilder localDataBuilder1 = null;
    if (i == 1)
    {
      localDataBuilder2 = new DataBuilder(e()).setActionType(17).setSubActionType(7).setThrActionType(0).setToUin(paramFSFeedCommentInfo.b.postUser.id.get());
      paramFSFeedCommentInfo = localDataBuilder1;
      if (this.d != null) {
        paramFSFeedCommentInfo = this.d.busiReport.get().toByteArray();
      }
      FSLpReportDc11001.a(localDataBuilder2.setMsgReportInfo(paramFSFeedCommentInfo).setExt2(String.valueOf(this.l)));
      return;
    }
    if (this.l == 2)
    {
      localDataBuilder1 = new DataBuilder(e()).setActionType(17).setSubActionType(11).setThrActionType(0).setToUin(paramFSFeedCommentInfo.c.postUser.id.get());
      paramFSFeedCommentInfo = localDataBuilder2;
      if (this.d != null) {
        paramFSFeedCommentInfo = this.d.busiReport.get().toByteArray();
      }
      FSLpReportDc11001.a(localDataBuilder1.setMsgReportInfo(paramFSFeedCommentInfo).setExt2(String.valueOf(this.l)));
    }
  }
  
  private void b(View paramView)
  {
    p();
    a(paramView);
  }
  
  private void b(FeedCloudMeta.StNotice paramStNotice)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FSCommonUtil.b(paramStNotice.createTime.get() * 1000L));
    paramStNotice = new SpannableString(localStringBuilder);
    this.i.setText(paramStNotice);
  }
  
  private void m()
  {
    List localList = FSCommentHelper.a().a(n());
    if (localList != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initFakeReplyView");
      localStringBuilder.append(localList.size());
      QLog.d("FSReplyMessagePresenter", 4, localStringBuilder.toString());
      this.A.a(localList);
      this.A.notifyDataSetChanged();
      return;
    }
    QLog.d("FSReplyMessagePresenter", 4, "initFakeReplyView null");
    this.A.a(new ArrayList());
    this.A.notifyDataSetChanged();
  }
  
  private String n()
  {
    if ((this.d.feed.get() != null) && (this.d.operation.comment.get() != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d.operation.comment.id.get());
      localStringBuilder.append(this.d.feedId.get());
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private FSFeedCommentInfo o()
  {
    if (this.d == null)
    {
      QLog.e("FSReplyMessagePresenter", 1, "getFeedCommentInfo error mData is null");
      return null;
    }
    FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)this.d.operation.comment.get();
    Iterator localIterator = localStComment.vecReply.get().iterator();
    while (localIterator.hasNext())
    {
      FeedCloudMeta.StReply localStReply = (FeedCloudMeta.StReply)localIterator.next();
      if (localStReply.modifyflag.get() != 0)
      {
        QLog.d("FSReplyMessagePresenter", 1, "getFeedCommentInfo is Reply");
        return new FSFeedCommentInfo((FeedCloudMeta.StFeed)this.d.feed.get(), localStComment, localStReply);
      }
    }
    QLog.d("FSReplyMessagePresenter", 1, "getFeedCommentInfo is comment");
    return new FSFeedCommentInfo((FeedCloudMeta.StFeed)this.d.feed.get(), localStComment, null);
  }
  
  private void p()
  {
    q();
    this.D = new SoftKeyboardStateHelper(this.C);
    this.D.a(new FSReplyMessagePresenter.7(this));
  }
  
  private void q()
  {
    SoftKeyboardStateHelper localSoftKeyboardStateHelper = this.D;
    if (localSoftKeyboardStateHelper != null)
    {
      localSoftKeyboardStateHelper.a();
      this.D = null;
    }
  }
  
  private boolean r()
  {
    return "pg_ks_layer_page".equals(d());
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    this.B = paramRecyclerView;
  }
  
  public void a(List<FSFeedCommentInfo> paramList)
  {
    FSMessageReplyAdapter localFSMessageReplyAdapter = this.A;
    if (localFSMessageReplyAdapter != null)
    {
      localFSMessageReplyAdapter.a(paramList);
      this.A.notifyDataSetChanged();
    }
  }
  
  public void b(Context paramContext, View paramView)
  {
    super.b(paramContext, paramView);
    this.C = paramView;
    this.x = ((RecyclerView)paramView.findViewById(2131445212));
    paramView = new FSReplyMessagePresenter.1(this, this.a.getContext(), 1, false);
    RecyclerView localRecyclerView = this.x;
    if (localRecyclerView != null)
    {
      localRecyclerView.setLayoutManager(paramView);
      this.A = new FSMessageReplyAdapter();
      this.A.a(new FSReplyMessagePresenter.2(this, paramContext));
      this.x.setAdapter(this.A);
    }
    this.z = new FSReplyMessagePresenter.3(this);
    this.v = new FSReplyMessagePresenter.4(this, paramContext);
    this.i.setOnClickListener(new FSReplyMessagePresenter.5(this));
  }
  
  public void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    super.b(paramStNotice, paramInt);
    try
    {
      FSCommentHelper.a().a(n(), this);
      b(paramStNotice);
      this.y = o();
      m();
      return;
    }
    catch (Exception paramStNotice)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bindCustomData");
      localStringBuilder.append(paramStNotice.getMessage());
      QLog.i("FSReplyMessagePresenter", 1, localStringBuilder.toString());
      paramStNotice.printStackTrace();
    }
  }
  
  public void h()
  {
    q();
  }
  
  protected View.OnClickListener j()
  {
    return this.v;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSReplyMessagePresenter
 * JD-Core Version:    0.7.0.1
 */