package com.tencent.mobileqq.kandian.biz.comment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.ad.api.entity.INegativeHelper;
import com.tencent.mobileqq.kandian.biz.ad.RIJCommentAdUtils;
import com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.mobileqq.kandian.biz.comment.bean.CommentComponentArgs;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.OnDataChangeListener;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommonCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.comment.guide.GuideHelper;
import com.tencent.mobileqq.kandian.biz.comment.ui.RIJCommentBubbleView;
import com.tencent.mobileqq.kandian.biz.comment.ui.ReadInJoyCommentLikeView.OnLikeStateChangeLinstener;
import com.tencent.mobileqq.kandian.biz.comment.ui.ReadInJoyCommentPopUpWindow.OnCommentTypeChangedListener;
import com.tencent.mobileqq.kandian.biz.fastweb.event.ListAdExposeManager;
import com.tencent.mobileqq.kandian.biz.framework.RIJCreateArticleInfoForBiu;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ReadinjoyCommentListBaseAdapter
  extends BaseAdapter
  implements ReadInJoyCommentDataManager.OnDataChangeListener, ReadInJoyCommentLikeView.OnLikeStateChangeLinstener, ReadInJoyCommentPopUpWindow.OnCommentTypeChangedListener
{
  QBaseActivity c;
  protected VafContext d;
  protected ReadInJoyCommentReportManager e;
  protected ReadInJoyCommentDataManager f;
  protected ReadInJoyCommentListView g;
  protected List<CommentViewItem> h = new ArrayList();
  protected AbsBaseArticleInfo i;
  protected boolean j = true;
  protected boolean k = true;
  protected CommonCommentData l;
  protected DynamicCommentProteusHelper m;
  protected ReadinjoyCommentListBaseAdapter.OnGetViewListener n;
  protected ReadInJoyCommentItemHeightHelper o;
  protected ListAdExposeManager p;
  protected ReadInJoyCommentItemHeightHelper.OnScrollYOffsetListener q;
  protected INegativeHelper r;
  protected int s = -1;
  protected AbsListView.OnScrollListener t = new ReadinjoyCommentListBaseAdapter.1(this);
  
  private int a(int paramInt)
  {
    Object localObject = this.o;
    int i2 = 0;
    if (localObject == null) {
      return 0;
    }
    int i1;
    if (this.g.getChildAt(0) != null) {
      i1 = this.g.getChildAt(0).getTop();
    } else {
      i1 = 0;
    }
    while (i2 < paramInt)
    {
      i1 += this.o.a(i2);
      i2 += 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("calculateScrollYOffsetHeight | firstVisiblePos ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" totalHeight ");
    ((StringBuilder)localObject).append(i1);
    QLog.d("ReadinjoyCommentListBaseAdapter", 2, ((StringBuilder)localObject).toString());
    return i1;
  }
  
  public static String a(String paramString)
  {
    if (paramString.contains("-")) {
      return paramString.split("-")[1];
    }
    return "";
  }
  
  public static String b(String paramString)
  {
    if (paramString.contains(":")) {
      return paramString.split(":")[1];
    }
    return "";
  }
  
  private void b(String paramString, int paramInt1, int paramInt2)
  {
    paramInt2 = 1;
    QLog.d("ReadinjoyCommentListBaseAdapter", 2, new Object[] { "comment id : ", paramString, " like state change, new state : ", Integer.valueOf(paramInt1) });
    Object localObject = this.f;
    if (localObject != null)
    {
      ((ReadInJoyCommentDataManager)localObject).b_(paramString, paramInt1);
      paramString = this.f.g(paramString);
      if ((paramString != null) && (!paramString.isAd)) {
        notifyDataSetChanged();
      }
      localObject = this.e;
      if (localObject != null)
      {
        if ((this instanceof ReadInJoyCommentListAdapter)) {
          paramInt1 = paramInt2;
        } else {
          paramInt1 = 2;
        }
        ((ReadInJoyCommentReportManager)localObject).a(paramInt1, paramString);
      }
      RIJCommentAdUtils.a(paramString);
    }
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return getView(paramInt, paramView, paramViewGroup);
  }
  
  public CommentViewItem a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Click more button in  commentLineId is :");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("     mViewState is :");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("ReadinjoyCommentListBaseAdapter", 2, String.format(((StringBuilder)localObject).toString(), new Object[0]));
    }
    Object localObject = a(paramString);
    boolean bool = ((String)localObject).contains(":");
    paramString = localObject.split(":")[0];
    localObject = b((String)localObject);
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      CommentViewItem localCommentViewItem = (CommentViewItem)localIterator.next();
      BaseCommentData localBaseCommentData = localCommentViewItem.c;
      if (localBaseCommentData != null) {
        if ((bool) && ((localBaseCommentData instanceof SubCommentData)))
        {
          SubCommentData localSubCommentData = (SubCommentData)localCommentViewItem.c;
          if ((localBaseCommentData.commentId.equals(localObject)) && (localSubCommentData.parentCommentId.equals(paramString)))
          {
            localBaseCommentData.maxLine = 100;
            this.e.a(paramString, (String)localObject, localCommentViewItem.b);
            return null;
          }
        }
        else if ((bool) && ((localCommentViewItem.c instanceof CommentData)) && (paramInt == 1))
        {
          if ((localBaseCommentData.commentId.equals(paramString)) && (((CommentData)localCommentViewItem.c).subCommentNum > 0))
          {
            this.e.b(paramString, (String)localObject, localCommentViewItem.b);
            return localCommentViewItem;
          }
        }
        else if ((!bool) && (localBaseCommentData.commentId.equals(paramString)))
        {
          localBaseCommentData.maxLine = 100;
          this.e.a(paramString, localCommentViewItem.b);
        }
      }
    }
    return null;
  }
  
  public void a(Activity paramActivity, View paramView, CommentViewItem paramCommentViewItem, BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    new RIJCommentBubbleView(paramActivity, this, paramCommentViewItem, this.i).a(this.j, this.k, this.i, paramView, paramOnDismissListener);
    RIJTransMergeKanDianReport.a("0X800824A");
  }
  
  public void a(Context paramContext, ReadInJoyCommentUtils.ReportCommentDialogClickListener paramReportCommentDialogClickListener)
  {
    if (paramContext == null) {
      return;
    }
    ActionSheet localActionSheet = ActionSheet.create(paramContext);
    localActionSheet.setMainTitle(2131915295);
    int[] arrayOfInt = new int[7];
    int[] tmp27_25 = arrayOfInt;
    tmp27_25[0] = 2131915288;
    int[] tmp33_27 = tmp27_25;
    tmp33_27[1] = 2131915289;
    int[] tmp39_33 = tmp33_27;
    tmp39_33[2] = 2131915290;
    int[] tmp45_39 = tmp39_33;
    tmp45_39[3] = 2131915291;
    int[] tmp51_45 = tmp45_39;
    tmp51_45[4] = 2131915292;
    int[] tmp57_51 = tmp51_45;
    tmp57_51[5] = 2131915293;
    int[] tmp63_57 = tmp57_51;
    tmp63_57[6] = 2131915294;
    tmp63_57;
    int i1 = 0;
    while (i1 < arrayOfInt.length)
    {
      localActionSheet.addButton(arrayOfInt[i1]);
      i1 += 1;
    }
    localActionSheet.addCancelButton(2131887648);
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
    localActionSheet.setOnButtonClickListener(new ReadinjoyCommentListBaseAdapter.4(this, localActionSheet, arrayOfInt, paramContext, paramReportCommentDialogClickListener));
  }
  
  public void a(Intent paramIntent)
  {
    CommonCommentData localCommonCommentData = this.l;
    if (localCommonCommentData != null)
    {
      paramIntent.putExtra("arg_common_comment_info", localCommonCommentData);
      paramIntent = new StringBuilder();
      paramIntent.append("readToBiuActivity   commonCommentData :");
      paramIntent.append(this.l.toString());
      QLog.d("ReadinjoyCommentListBaseAdapter", 2, paramIntent.toString());
    }
  }
  
  public void a(ReadInJoyCommentItemHeightHelper.OnScrollYOffsetListener paramOnScrollYOffsetListener)
  {
    this.q = paramOnScrollYOffsetListener;
  }
  
  public void a(ReadinjoyCommentListBaseAdapter.OnGetViewListener paramOnGetViewListener)
  {
    this.n = paramOnGetViewListener;
  }
  
  public void a(CommentViewItem paramCommentViewItem)
  {
    BaseCommentData localBaseCommentData = paramCommentViewItem.c;
    if (this.i != null)
    {
      paramCommentViewItem = this.l;
      int i1;
      if ((paramCommentViewItem != null) && (paramCommentViewItem.getAdTag() != -1)) {
        i1 = this.l.getAdTag();
      } else if (((this.i.mFeedType == 1) && (this.i.mSocialFeedInfo != null) && (this.i.mSocialFeedInfo.b == 5)) || (RIJFeedsType.a(this.i))) {
        i1 = 2;
      } else if ((RIJItemViewTypeUtils.o(this.i)) && (this.i.mSocialFeedInfo != null) && (this.i.mSocialFeedInfo.s != null) && (RIJItemViewTypeUtils.b(this.i.mSocialFeedInfo.s.a))) {
        i1 = 9;
      } else {
        i1 = 4;
      }
      if (TextUtils.isEmpty(localBaseCommentData.nickName)) {
        paramCommentViewItem = "";
      } else {
        paramCommentViewItem = localBaseCommentData.nickName;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c.getString(2131915287));
      localStringBuilder.append(paramCommentViewItem);
      paramCommentViewItem = localStringBuilder.toString();
      paramCommentViewItem = new CommentComponentArgs().a(this.i).a(localBaseCommentData).a(i1).a(paramCommentViewItem).a(h()).a(this.j);
      ReadInJoyCommentUtils.a(this.c, paramCommentViewItem);
    }
  }
  
  public void a(CommonCommentData paramCommonCommentData)
  {
    this.l = paramCommonCommentData;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    RIJUserLevelModule.getInstance().doActionsByUserLevel(n(), 3, new ReadinjoyCommentListBaseAdapter.3(this, paramString, paramInt1, paramInt2));
  }
  
  public boolean b(int paramInt)
  {
    return paramInt == this.s;
  }
  
  public abstract void c();
  
  public void c(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCommentTypeChanged | changeToType ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, ((StringBuilder)localObject).toString());
    this.s = paramInt;
    if (this.f != null)
    {
      localObject = this.h;
      if (localObject != null)
      {
        ((List)localObject).clear();
        this.h.addAll(this.f.d(paramInt));
        notifyDataSetChanged();
      }
      this.f.n().a(false, this.g);
    }
    localObject = this.e;
    if (localObject != null) {
      ((ReadInJoyCommentReportManager)localObject).b(paramInt);
    }
    localObject = this.g;
    if (localObject != null) {
      ((ReadInJoyCommentListView)localObject).resetFooterView();
    }
  }
  
  public void c(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem != null)
    {
      if (paramCommentViewItem.c == null) {
        return;
      }
      if ((paramCommentViewItem.c.isAuthorReply()) && (!TextUtils.isEmpty(paramCommentViewItem.c.ksHomePage))) {
        ReadInJoyCommentUtils.b(paramCommentViewItem.c.ksHomePage, this.c);
      } else {
        ReadInJoyCommentUtils.a(paramCommentViewItem.c.uin, this.c, paramCommentViewItem.d);
      }
      ReadInJoyCommentReportManager localReadInJoyCommentReportManager = this.e;
      if (localReadInJoyCommentReportManager != null) {
        localReadInJoyCommentReportManager.b(paramCommentViewItem);
      }
    }
  }
  
  public void d(CommentViewItem paramCommentViewItem)
  {
    Object localObject = ActionSheet.create(this.c);
    ((ActionSheet)localObject).setMainTitle(2131915320);
    ((ActionSheet)localObject).addButton(2131915319, 3);
    ((ActionSheet)localObject).addCancelButton(2131887648);
    if (!((ActionSheet)localObject).isShowing()) {
      ((ActionSheet)localObject).show();
    }
    ((ActionSheet)localObject).setOnButtonClickListener(new ReadinjoyCommentListBaseAdapter.2(this, paramCommentViewItem, (ActionSheet)localObject));
    localObject = this.e;
    if (localObject != null) {
      ((ReadInJoyCommentReportManager)localObject).a(paramCommentViewItem);
    }
  }
  
  public void e(CommentViewItem paramCommentViewItem)
  {
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, "start showBiuComponent");
    if (paramCommentViewItem != null)
    {
      Object localObject = this.i;
      if (localObject == null) {
        return;
      }
      localObject = ReadInJoyCommentUtils.a((AbsBaseArticleInfo)localObject, this.l);
      int i1 = ((Integer)((Pair)localObject).first).intValue();
      int i2 = ((Integer)((Pair)localObject).second).intValue();
      localObject = paramCommentViewItem.c;
      String str1 = ((BaseCommentData)localObject).getWholeStringContent();
      String str2 = ((BaseCommentData)localObject).uin;
      localObject = RIJCreateArticleInfoForBiu.a(new Intent(this.c, ReadInJoyDeliverBiuActivity.class), this.i, i1, str1, Long.valueOf(str2).longValue(), ((BaseCommentData)localObject).nickName, 0, i2);
      a((Intent)localObject);
      this.c.startActivity((Intent)localObject);
      this.c.overridePendingTransition(0, 0);
      localObject = this.e;
      if (localObject != null) {
        ((ReadInJoyCommentReportManager)localObject).c(paramCommentViewItem);
      }
    }
  }
  
  public abstract ReadInJoyCommentDataManager f();
  
  public void f(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {
      return;
    }
    Object localObject1 = paramCommentViewItem.c;
    if (((BaseCommentData)localObject1).isDisliked()) {
      i1 = 2131910362;
    } else {
      i1 = 2131910456;
    }
    Object localObject2 = HardCodeUtil.a(i1);
    QQToast.makeText(this.c, 2, (CharSequence)localObject2, 0).show();
    localObject2 = f();
    int i1 = 1;
    if (localObject2 != null) {
      ((ReadInJoyCommentDataManager)localObject2).a_(((BaseCommentData)localObject1).commentId, ((BaseCommentData)localObject1).isDisliked() ^ true);
    }
    localObject1 = this.e;
    if (localObject1 != null)
    {
      if (!(this instanceof ReadInJoyCommentListAdapter)) {
        i1 = 2;
      }
      ((ReadInJoyCommentReportManager)localObject1).b(i1, paramCommentViewItem);
    }
  }
  
  abstract LayoutInflater g();
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      if (paramInt >= ((List)localObject).size()) {
        return -1;
      }
      localObject = (CommentViewItem)this.h.get(paramInt);
      if (localObject == null) {
        return -1;
      }
      if (DynamicCommentProteusHelper.b((CommentViewItem)localObject)) {
        return this.m.c((CommentViewItem)localObject);
      }
      return ((CommentViewItem)this.h.get(paramInt)).a;
    }
    return -1;
  }
  
  public int getViewTypeCount()
  {
    DynamicCommentProteusHelper localDynamicCommentProteusHelper = this.m;
    int i1;
    if (localDynamicCommentProteusHelper != null) {
      i1 = localDynamicCommentProteusHelper.a();
    } else {
      i1 = 0;
    }
    return i1 + 8;
  }
  
  abstract ReadInJoyCommentUtils.CommentComponetEventListener h();
  
  public VafContext m()
  {
    return this.d;
  }
  
  public QBaseActivity n()
  {
    return this.c;
  }
  
  public int o()
  {
    return this.s;
  }
  
  public void onClick(ViewBase paramViewBase) {}
  
  public boolean p()
  {
    ReadInJoyCommentDataManager localReadInJoyCommentDataManager = this.f;
    if (localReadInJoyCommentDataManager != null) {
      return localReadInJoyCommentDataManager.c();
    }
    return false;
  }
  
  public ReadInJoyCommentReportManager q()
  {
    return this.e;
  }
  
  public ReadInJoyCommentListView r()
  {
    return this.g;
  }
  
  public void s()
  {
    int i2 = this.s;
    int i1 = 2;
    if (i2 == 2) {
      i1 = 3;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onChangeCommentTypeClick | curType ");
    ((StringBuilder)localObject).append(this.s);
    ((StringBuilder)localObject).append("; changeToType ");
    ((StringBuilder)localObject).append(i1);
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, ((StringBuilder)localObject).toString());
    this.s = i1;
    if (this.f != null)
    {
      localObject = this.h;
      if (localObject != null)
      {
        ((List)localObject).clear();
        this.h.addAll(this.f.d(i1));
        notifyDataSetChanged();
      }
      this.f.n().a(false, this.g);
    }
    localObject = this.e;
    if (localObject != null) {
      ((ReadInJoyCommentReportManager)localObject).b(i1);
    }
    localObject = this.g;
    if (localObject != null) {
      ((ReadInJoyCommentListView)localObject).resetFooterView();
    }
    if ((i1 == 3) && ((this instanceof ReadInJoyCommentListAdapter))) {
      ((ReadInJoyCommentListAdapter)this).k();
    }
  }
  
  protected View t()
  {
    View localView = new View(this.c);
    localView.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
    localView.setTag("non_null_convertview");
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, "createNotNullView");
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadinjoyCommentListBaseAdapter
 * JD-Core Version:    0.7.0.1
 */