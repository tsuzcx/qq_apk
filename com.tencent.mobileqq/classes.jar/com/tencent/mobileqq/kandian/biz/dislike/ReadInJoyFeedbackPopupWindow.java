package com.tencent.mobileqq.kandian.biz.dislike;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBasePopupWindow;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRequestUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebShareUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.fastweb.FeedbackCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;

public class ReadInJoyFeedbackPopupWindow
  extends ReadInJoyBasePopupWindow
  implements View.OnClickListener
{
  private LinearLayout g;
  private LinearLayout h;
  private LinearLayout i;
  private ImageView j;
  private ImageView k;
  private ImageView l;
  private ImageView m;
  private AbsBaseArticleInfo n;
  private View o;
  private int p;
  private ReadInJoyBaseAdapter q;
  private FastWebShareUtils r;
  private boolean s = true;
  private FeedbackCallback t = new ReadInJoyFeedbackPopupWindow.1(this);
  
  public ReadInJoyFeedbackPopupWindow(Activity paramActivity, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramActivity);
    this.q = paramReadInJoyBaseAdapter;
    this.r = new FastWebShareUtils();
  }
  
  private void a(int paramInt)
  {
    if (!f()) {
      return;
    }
    ((ReadInJoyLogicManager)ReadInJoyUtils.b().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().d().a(this.n, paramInt, this.t);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (b("reportData"))
    {
      Object localObject = RIJTransMergeKanDianReport.b(this.n);
      try
      {
        localObject = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addShareOption(paramInt).addTopicId(this.n.businessId).build();
        PublicAccountReportUtils.a(null, String.valueOf(this.n.publishUin), paramString, paramString, 0, 0, String.valueOf(this.n.mFeedId), String.valueOf(this.n.mArticleID), String.valueOf(this.n.mStrategyId), (String)localObject, false);
        return;
      }
      catch (JSONException paramString)
      {
        QLog.d("ReadInJoyBasePopupWindow", 1, "reportData json exception.");
        paramString.printStackTrace();
      }
    }
  }
  
  private boolean a(String paramString)
  {
    if (this.n == null)
    {
      QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { paramString, ", mArticleInfo is null." });
      return false;
    }
    return true;
  }
  
  private int b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return 2;
          }
          return 10;
        }
        return 9;
      }
      return 3;
    }
    return 2;
  }
  
  private boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.publishUin > 0L) && (RIJQQAppInterfaceUtil.c() == paramAbsBaseArticleInfo.publishUin);
  }
  
  private boolean b(String paramString)
  {
    if ((a(paramString)) && (this.n.mSocialFeedInfo != null)) {
      return true;
    }
    QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { paramString, ", mSocialFeedInfo is null" });
    return false;
  }
  
  private void c()
  {
    if (a("reportFeeds")) {
      ThreadManager.getSubThreadHandler().post(new ReadInJoyFeedbackPopupWindow.3(this));
    }
  }
  
  private void d()
  {
    ActionSheet localActionSheet = ActionSheet.create(this.a);
    localActionSheet.setMainTitle(2131915382);
    localActionSheet.addButton(2131915381, 0);
    localActionSheet.addCancelButton(2131887648);
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
    localActionSheet.setOnButtonClickListener(new ReadInJoyFeedbackPopupWindow.4(this, localActionSheet));
  }
  
  private void e()
  {
    if (!f()) {
      return;
    }
    if (a("shieldFeeds")) {
      FastWebRequestUtil.b(this.n, this.t);
    }
  }
  
  private boolean f()
  {
    if (!NetworkUtil.isNetworkAvailable(this.a))
    {
      QQToast.makeText(this.a, 1, 2131915328, 0).show();
      return false;
    }
    return true;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131626135, null);
    this.g = ((LinearLayout)paramLayoutInflater.findViewById(2131445835));
    this.h = ((LinearLayout)paramLayoutInflater.findViewById(2131444659));
    this.i = ((LinearLayout)paramLayoutInflater.findViewById(2131431708));
    this.j = ((ImageView)paramLayoutInflater.findViewById(2131445612));
    this.k = ((ImageView)paramLayoutInflater.findViewById(2131443264));
    this.l = ((ImageView)paramLayoutInflater.findViewById(2131450101));
    this.m = ((ImageView)paramLayoutInflater.findViewById(2131438800));
    return paramLayoutInflater;
  }
  
  public final void a(View paramView1, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, View paramView2)
  {
    QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { "show, articleInfo = ", paramAbsBaseArticleInfo });
    if (!this.f) {
      a();
    }
    this.n = paramAbsBaseArticleInfo;
    this.o = paramView2;
    this.p = paramInt;
    a(paramAbsBaseArticleInfo);
    a(paramView1);
    this.s = true;
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (b(paramAbsBaseArticleInfo))
    {
      this.g.setVisibility(8);
      this.h.setVisibility(8);
      this.i.setVisibility(0);
      this.i.setBackgroundDrawable(this.a.getResources().getDrawable(2130843940));
      return;
    }
    this.g.setVisibility(0);
    this.h.setVisibility(0);
    this.i.setVisibility(8);
    this.g.setBackgroundDrawable(this.a.getResources().getDrawable(2130843939));
    this.h.setBackgroundDrawable(this.a.getResources().getDrawable(2130843940));
  }
  
  public void b()
  {
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.m.setOnClickListener(this);
    setOnDismissListener(new ReadInJoyFeedbackPopupWindow.2(this));
  }
  
  public void onClick(View paramView)
  {
    this.s = false;
    dismiss();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131450101: 
      a(2);
      a("0X80095D4", 3);
      return;
    case 2131445835: 
      e();
      a("0X80095D4", 5);
      return;
    case 2131445612: 
      a(0);
      a("0X80095D4", 1);
      return;
    case 2131444659: 
      c();
      a("0X80095D4", 7);
      return;
    case 2131443264: 
      a(1);
      a("0X80095D4", 2);
      return;
    case 2131438800: 
      a(3);
      a("0X80095D4", 4);
      return;
    }
    d();
    a("0X80095D4", 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyFeedbackPopupWindow
 * JD-Core Version:    0.7.0.1
 */