package com.tencent.mobileqq.kandian.biz.comment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.OnCommentListLoadListener;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData.RepliedCommentData;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView.RefreshCallback;
import com.tencent.mobileqq.kandian.biz.pts.ReadInjoyContext;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class ReadInJoySecondCommentListAdapter
  extends ReadinjoyCommentListBaseAdapter
  implements ReadInJoyCommentListView.RefreshCallback
{
  private LayoutInflater a;
  private String b;
  private int u;
  private int v = 0;
  private ReadInJoySecondCommentListFragment w;
  private ICommentNumChangedListener x;
  private ReadInJoyCommentDataManager.OnCommentListLoadListener y;
  
  public ReadInJoySecondCommentListAdapter(QBaseActivity paramQBaseActivity, ReadInJoyCommentListView paramReadInJoyCommentListView, ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment, int paramInt)
  {
    this.a = LayoutInflater.from(paramQBaseActivity);
    this.c = paramQBaseActivity;
    this.g = paramReadInJoyCommentListView;
    this.g.setRefreshCallback(this);
    this.w = paramReadInJoySecondCommentListFragment;
    this.v = paramInt;
    this.m = new DynamicCommentProteusHelper();
    this.m.a(m());
    this.o = new ReadInJoyCommentItemHeightHelper(this.g, this.h, this);
    this.g.setOnScrollListener(this.t);
  }
  
  private void a(List<CommentViewItem> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CommentViewItem localCommentViewItem = (CommentViewItem)paramList.next();
        if ((localCommentViewItem.c instanceof CommentData)) {
          localCommentViewItem.c.isAnchor = false;
        }
      }
    }
  }
  
  public CommentViewItem a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.h.size())) {
      return (CommentViewItem)this.h.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    QLog.d("ReadInJoySecondCommentListAdapter", 1, new Object[] { "onDestroy article=", this.i });
    if (this.e != null) {
      this.e.a(this.w.c());
    }
    if (this.f != null)
    {
      this.f.b(this);
      this.f.cC_();
    }
    this.a = null;
    this.c = null;
    this.i = null;
    this.w = null;
    this.e = null;
    this.f = null;
    this.x = null;
    this.y = null;
  }
  
  public void a(ICommentNumChangedListener paramICommentNumChangedListener)
  {
    this.x = paramICommentNumChangedListener;
  }
  
  public void a(CommentViewItem paramCommentViewItem)
  {
    super.a(paramCommentViewItem);
    if (this.e != null) {
      this.e.a(2, paramCommentViewItem);
    }
  }
  
  public void a(ReadInJoyCommentDataManager.OnCommentListLoadListener paramOnCommentListLoadListener)
  {
    this.y = paramOnCommentListLoadListener;
  }
  
  public void a(String paramString1, String paramString2, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    this.i = paramAbsBaseArticleInfo;
    this.b = paramString1;
    this.u = paramInt;
    this.f = ReadInJoyCommentDataManager.a(paramAbsBaseArticleInfo);
    this.e = new ReadInJoyCommentReportManager(this, this.i, paramInt);
    if (this.f != null)
    {
      this.f.a(this);
      this.h.clear();
      paramAbsBaseArticleInfo = this.f.e(paramString1);
      a(paramAbsBaseArticleInfo);
      this.h.addAll(paramAbsBaseArticleInfo);
      this.f.a(paramString1, paramString2);
      notifyDataSetChanged();
    }
    QLog.d("ReadInJoySecondCommentListAdapter", 1, new Object[] { "initCommentData article=", this.i, "mCommentDataManager=", this.f });
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(@NotNull CommentViewItem paramCommentViewItem)
  {
    if (!(paramCommentViewItem.c instanceof SubCommentData)) {
      return;
    }
    ReadInJoyCommentReportManager.a(paramCommentViewItem.d, paramCommentViewItem.c);
    paramCommentViewItem = ((SubCommentData)paramCommentViewItem.c).repliedCommentData;
    if (paramCommentViewItem == null) {
      return;
    }
    if (paramCommentViewItem.c > 0)
    {
      QRUtils.a(1, 2131915274);
      return;
    }
    paramCommentViewItem = paramCommentViewItem.a;
    if (TextUtils.isEmpty(paramCommentViewItem)) {
      return;
    }
    int k = -1;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.h.size()) {
        break;
      }
      CommentViewItem localCommentViewItem = (CommentViewItem)this.h.get(i);
      if ((localCommentViewItem != null) && (paramCommentViewItem.equals(CommentProteusUtil.a(localCommentViewItem.c))))
      {
        localCommentViewItem.c.isAnchor = true;
        j = i;
        break;
      }
      i += 1;
    }
    if (j >= 0)
    {
      this.g.smoothScrollToPosition(j);
      notifyDataSetChanged();
    }
  }
  
  public boolean b(int paramInt)
  {
    return true;
  }
  
  public void c()
  {
    ReadInJoySecondCommentListFragment localReadInJoySecondCommentListFragment = this.w;
    if (localReadInJoySecondCommentListFragment != null) {
      localReadInJoySecondCommentListFragment.i();
    }
  }
  
  public ReadInJoyCommentDataManager f()
  {
    return this.f;
  }
  
  LayoutInflater g()
  {
    return this.a;
  }
  
  public int getCount()
  {
    return this.h.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.d == null)
    {
      this.d = new ReadInjoyContext();
      this.d.setContext(this.c);
      ProteusSupportUtil.a(this.d, "comment_feeds");
    }
    View localView = paramView;
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getTag() != null)
      {
        localView = paramView;
        if ((paramView.getTag() instanceof String))
        {
          localView = paramView;
          if ("non_null_convertview".equalsIgnoreCase((String)paramView.getTag()))
          {
            localView = null;
            QLog.d("ReadInJoySecondCommentListAdapter", 1, "getView | sub comment reset NonNullView");
          }
        }
      }
    }
    if (this.f == null)
    {
      paramView = new StringBuilder();
      paramView.append("getView | mCommentDataManager is null, article=");
      paramView.append(this.i);
      QLog.w("ReadInJoySecondCommentListAdapter", 1, paramView.toString());
    }
    int i = getItemViewType(paramInt);
    if (i != 0) {
      if (i != 3)
      {
        if ((i != 4) && (i != 5)) {
          break label386;
        }
      }
      else
      {
        if (localView == null)
        {
          paramView = new ReadinjoyCommentViewHolder.ReplyNumTitleHolder();
          localView = paramView.a(this, paramInt, localView, paramViewGroup);
          paramViewGroup = paramView;
          paramView = localView;
        }
        else
        {
          paramViewGroup = (ReadinjoyCommentViewHolder.ReplyNumTitleHolder)localView.getTag();
          paramView = localView;
        }
        localView = paramView;
        if (paramViewGroup == null) {
          break label386;
        }
        paramViewGroup.a(this, paramInt);
        localView = paramView;
        break label386;
      }
    }
    if (DynamicCommentProteusHelper.b(a(paramInt)))
    {
      paramViewGroup = this.m.a(a(paramInt));
      if (localView != null)
      {
        paramView = localView;
        if ((localView instanceof Container)) {}
      }
      else
      {
        paramView = this.d.getViewFactory().inflate(this.d, paramViewGroup);
      }
      DynamicCommentProteusHelper.a(this.d, (Container)paramView, paramViewGroup, this, paramInt, i, true);
      localView = paramView;
    }
    else
    {
      paramViewGroup = CommentProteusUtil.a(this.d, a(paramInt), i, false, this);
      if (localView != null)
      {
        paramView = localView;
        if ((localView instanceof Container)) {}
      }
      else
      {
        paramView = this.d.getViewFactory().inflate(this.d, paramViewGroup);
      }
      CommentProteusUtil.a(this.d, (Container)paramView, paramViewGroup, this, paramInt, i, false);
      localView = paramView;
    }
    label386:
    if (this.e != null) {
      this.e.d(paramInt);
    }
    paramView = localView;
    if (localView == null)
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("getView | sub comment convertview is null ; position ");
      paramViewGroup.append(paramInt);
      paramViewGroup.append(" viewtype ");
      paramViewGroup.append(i);
      paramViewGroup.append("\n commentItem: ");
      if (a(paramInt) != null) {
        paramView = a(paramInt).c;
      } else {
        paramView = "commentData is null";
      }
      paramViewGroup.append(paramView);
      paramViewGroup = paramViewGroup.toString();
      QLog.d("ReadInJoySecondCommentListAdapter", 1, paramViewGroup);
      QLog.d("ReadInJoySecondCommentListAdapter", 1, paramViewGroup);
      paramView = t();
      AIOUtils.a("ReadInJoySecondCommentListAdapter", "sub comment convertview is null", new NullPointerException(paramViewGroup));
    }
    return paramView;
  }
  
  ReadInJoyCommentUtils.CommentComponetEventListener h()
  {
    ReadInJoySecondCommentListFragment localReadInJoySecondCommentListFragment = this.w;
    if (localReadInJoySecondCommentListFragment != null) {
      return localReadInJoySecondCommentListFragment.f();
    }
    return null;
  }
  
  public VafContext m()
  {
    if (this.d == null)
    {
      this.d = new ReadInjoyContext();
      this.d.setCurActivity(this.c);
      this.d.setContext(this.c);
      ProteusSupportUtil.a(this.d, "comment_feeds");
    }
    return this.d;
  }
  
  public void onCommentBlock(int paramInt, boolean paramBoolean, Pair<List<BaseCommentData>, List<BaseCommentData>> paramPair)
  {
    if (paramBoolean)
    {
      if (paramPair == null) {
        return;
      }
      paramPair = (List)paramPair.second;
      if (paramInt == 1)
      {
        paramPair = this.w;
        if (paramPair != null) {
          paramPair.g();
        }
      }
      else if ((this.f != null) && (paramPair != null) && (paramPair.size() > 0))
      {
        paramPair = this.f.i(this.b);
        if (!paramPair.isEmpty())
        {
          this.h.clear();
          this.h.addAll(paramPair);
          notifyDataSetChanged();
        }
      }
      if ((this.x != null) && (this.f != null)) {
        this.x.onCommentNumChanged(this.f.h());
      }
    }
  }
  
  public void onCommentCreate(boolean paramBoolean, CommentViewItem paramCommentViewItem, List<CommentViewItem> paramList, int paramInt) {}
  
  public void onCommentCreate(boolean paramBoolean1, CommentViewItem paramCommentViewItem, boolean paramBoolean2, List<CommentViewItem> paramList, int paramInt) {}
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, CommentViewItem paramCommentViewItem, int paramInt2)
  {
    if (!paramBoolean) {
      return;
    }
    if (!b(paramInt2))
    {
      QLog.d("ReadInJoySecondCommentListAdapter", 1, "onCommentDelete | wrong firstFeedsType");
      return;
    }
    if (paramInt1 == 1)
    {
      paramCommentViewItem = this.w;
      if (paramCommentViewItem != null) {
        paramCommentViewItem.g();
      }
    }
    else if (this.f != null)
    {
      paramCommentViewItem = this.f.i(this.b);
      if (!paramCommentViewItem.isEmpty())
      {
        this.h.clear();
        this.h.addAll(paramCommentViewItem);
        notifyDataSetChanged();
      }
    }
    if ((this.x != null) && (this.f != null)) {
      this.x.onCommentNumChanged(this.f.h());
    }
  }
  
  public void onCommentLikeOrDislike(boolean paramBoolean, BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 2)
    {
      if (this.f == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCommentListLoad sub comments ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" flowType : ");
      localStringBuilder.append(paramInt2);
      QLog.d("ReadInJoySecondCommentListAdapter", 1, localStringBuilder.toString());
      if (!b(paramInt3))
      {
        QLog.d("ReadInJoySecondCommentListAdapter", 1, "onCommentListLoad | wrong firstFeedsType");
        return;
      }
      if ((paramBoolean1) && (this.h != null) && (paramList != null) && (this.g != null))
      {
        a(paramList);
        this.h.clear();
        this.h.addAll(paramList);
        paramList = new StringBuilder();
        paramList.append("onCommentListLoad list size = ");
        paramList.append(this.h.size());
        QLog.d("ReadInJoySecondCommentListAdapter", 1, paramList.toString());
        this.g.loadingMoreComplete(paramBoolean2);
        notifyDataSetChanged();
      }
    }
  }
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2)
  {
    if (paramInt1 == 2)
    {
      if (this.f == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCommentLoadMore sub comments ");
      localStringBuilder.append(paramBoolean1);
      QLog.d("ReadInJoySecondCommentListAdapter", 1, localStringBuilder.toString());
      if (!b(paramInt2))
      {
        QLog.d("ReadInJoySecondCommentListAdapter", 1, "onCommentLoadMore | wrong firstFeedsType");
        return;
      }
      if (paramBoolean1)
      {
        if ((this.h != null) && (paramList != null) && (this.g != null))
        {
          this.h.addAll(paramList);
          notifyDataSetChanged();
          this.g.loadingMoreComplete(paramBoolean2);
        }
      }
      else if (this.g != null) {
        this.g.loadMoreFail();
      }
    }
  }
  
  public void onCommentReply(boolean paramBoolean, CommentViewItem paramCommentViewItem)
  {
    if (paramBoolean)
    {
      QQToast.makeText(BaseApplication.getContext(), 2, HardCodeUtil.a(2131910490), 0).show();
      if (this.f != null) {
        paramCommentViewItem = this.f.i(this.b);
      } else {
        paramCommentViewItem = new ArrayList();
      }
      if ((!paramCommentViewItem.isEmpty()) && (this.h != null) && (this.g != null))
      {
        this.h.clear();
        this.h.addAll(paramCommentViewItem);
        notifyDataSetChanged();
        this.g.smoothScrollBy(0, 0);
        this.g.setSelection(0);
      }
      if ((this.x != null) && (this.f != null)) {
        this.x.onCommentNumChanged(this.f.h());
      }
    }
    else
    {
      QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131910345), 0).show();
    }
  }
  
  public void onCommentReport(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (!paramBoolean) {
      return;
    }
    if (paramInt == 1)
    {
      paramString1 = this.w;
      if (paramString1 != null) {
        paramString1.g();
      }
    }
    else if (this.f != null)
    {
      paramString1 = this.f.i(this.b);
      if (!paramString1.isEmpty())
      {
        this.h.clear();
        this.h.addAll(paramString1);
        notifyDataSetChanged();
      }
    }
    if ((this.x != null) && (this.f != null)) {
      this.x.onCommentNumChanged(this.f.h());
    }
  }
  
  public void onCommentStateError(int paramInt)
  {
    ReadInJoyCommentDataManager.OnCommentListLoadListener localOnCommentListLoadListener = this.y;
    if (localOnCommentListLoadListener != null)
    {
      localOnCommentListLoadListener.onCommentStateError(paramInt);
      return;
    }
    if (paramInt == 1001) {
      QRUtils.a(1, 2131915274);
    }
  }
  
  public void startLoadMore(ListView paramListView)
  {
    if (this.e != null) {
      this.e.d();
    }
    if (this.f != null) {
      this.f.f(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoySecondCommentListAdapter
 * JD-Core Version:    0.7.0.1
 */