package com.tencent.mobileqq.kandian.biz.comment.guide;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.OnDataChangeListener;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.CommentGuideConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class GuideHelper
  implements ReadInJoyCommentDataManager.OnDataChangeListener
{
  private Set<String> a = new HashSet();
  private int b = 10;
  private String c;
  private boolean d = false;
  private int e = 0;
  private AbsBaseArticleInfo f;
  
  private void a(String paramString, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder1 = new RIJTransMergeKanDianReport.ReportR5Builder();
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder2 = localReportR5Builder1.addOS();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(CommentGuideConfigHandler.d());
    localReportR5Builder2.addStringNotThrow("wording", localStringBuilder.toString());
    ReadInJoyCommentUtils.a(paramString, paramAbsBaseArticleInfo, localReportR5Builder1);
  }
  
  public View a(ViewGroup paramViewGroup, View paramView, Context paramContext, CommentViewItem paramCommentViewItem)
  {
    if (!a(paramCommentViewItem)) {
      return paramView;
    }
    if ((!TextUtils.isEmpty(paramCommentViewItem.d.innerUniqueID)) && (!this.a.contains(paramCommentViewItem.d.innerUniqueID)))
    {
      a("0X8009FE9", paramCommentViewItem.d);
      this.a.add(paramCommentViewItem.d.innerUniqueID);
    }
    this.d = true;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
    if (localLayoutParams.bottomMargin >= 0) {
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, paramViewGroup.getContext().getResources().getDimensionPixelOffset(2131299592));
    }
    paramViewGroup.setLayoutParams(localLayoutParams);
    if (paramView == null) {
      paramView = LayoutInflater.from(paramContext).inflate(2131626362, null);
    }
    paramView.setOnClickListener(new GuideHelper.1(this, paramCommentViewItem, paramContext));
    return paramView;
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showGuidePagerNum : ");
    localStringBuilder.append(paramInt);
    QLog.d("GuideHelper", 1, localStringBuilder.toString());
    this.b = paramInt;
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.f = paramAbsBaseArticleInfo;
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("extraInfo : ");
    localStringBuilder.append(paramString);
    QLog.d("GuideHelper", 1, localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      this.c = new JSONObject(paramString).getString("app_schema");
      paramString = new StringBuilder();
      paramString.append("scheme : ");
      paramString.append(this.c);
      QLog.d("GuideHelper", 1, paramString.toString());
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("GuideHelper", 1, "setGuideExtraInfo : ", paramString);
    }
  }
  
  public void a(boolean paramBoolean, ViewGroup paramViewGroup)
  {
    this.d = paramBoolean;
    this.e = 0;
    if (paramViewGroup == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
    if (!paramBoolean) {
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, paramViewGroup.getContext().getResources().getDimensionPixelOffset(2131299590));
    }
    paramViewGroup.setLayoutParams(localLayoutParams);
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public boolean a(CommentViewItem paramCommentViewItem)
  {
    return (paramCommentViewItem != null) && (paramCommentViewItem.a == 6);
  }
  
  public boolean a(List<CommentViewItem> paramList)
  {
    int i = this.e;
    if ((!TextUtils.isEmpty(this.c)) && (i > this.b) && (paramList != null))
    {
      CommentViewItem localCommentViewItem = new CommentViewItem(6, null, this.f);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        if (((CommentViewItem)localIterator.next()).a == 6) {
          localIterator.remove();
        }
      }
      paramList.add(localCommentViewItem);
      paramList = new StringBuilder();
      paramList.append("addGuidePager : ");
      paramList.append(i);
      paramList.append("  articleInfo :");
      paramList.append(this.f);
      QLog.d("GuideHelper", 1, paramList.toString());
      return true;
    }
    return false;
  }
  
  public void onCommentBlock(int paramInt, boolean paramBoolean, Pair<List<BaseCommentData>, List<BaseCommentData>> paramPair) {}
  
  public void onCommentCreate(boolean paramBoolean, CommentViewItem paramCommentViewItem, List<CommentViewItem> paramList, int paramInt) {}
  
  public void onCommentCreate(boolean paramBoolean1, CommentViewItem paramCommentViewItem, boolean paramBoolean2, List<CommentViewItem> paramList, int paramInt) {}
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, CommentViewItem paramCommentViewItem, int paramInt2) {}
  
  public void onCommentLikeOrDislike(boolean paramBoolean, BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    this.e = 1;
    a(paramList);
  }
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2)
  {
    this.e += 1;
    a(paramList);
  }
  
  public void onCommentReply(boolean paramBoolean, CommentViewItem paramCommentViewItem) {}
  
  public void onCommentReport(int paramInt, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onCommentStateError(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.guide.GuideHelper
 * JD-Core Version:    0.7.0.1
 */