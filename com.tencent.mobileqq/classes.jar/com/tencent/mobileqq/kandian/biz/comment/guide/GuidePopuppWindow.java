package com.tencent.mobileqq.kandian.biz.comment.guide;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.pts.ReadInjoyContext;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.CommentGuideConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;

public class GuidePopuppWindow
  extends PopupWindow
{
  private Activity a;
  private Container b;
  private AbsBaseArticleInfo c;
  private VafContext d;
  private GuidePopuppWindow.OnGuideDismissListener e;
  private int f = 0;
  private Set<String> g = new HashSet();
  
  public GuidePopuppWindow(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    super(paramActivity);
    this.a = paramActivity;
    this.c = paramAbsBaseArticleInfo;
    b(b());
    setTouchable(true);
    setFocusable(true);
    setOutsideTouchable(false);
    setInputMethodMode(1);
    setBackgroundDrawable(new ColorDrawable(0));
    a();
  }
  
  public static TemplateBean a(VafContext paramVafContext)
  {
    if (paramVafContext == null)
    {
      TemplateFactory localTemplateFactory = TemplateFactory.a("comment_feeds", true);
      paramVafContext = localTemplateFactory;
      if (localTemplateFactory == null) {
        return null;
      }
    }
    else
    {
      paramVafContext = (TemplateFactory)paramVafContext.getTemplateFactory();
    }
    if (paramVafContext != null) {
      try
      {
        paramVafContext = paramVafContext.getTemplateBean(CommentGuideConfigHandler.e());
        return paramVafContext;
      }
      catch (JSONException paramVafContext)
      {
        QLog.d("GuidePopuppWindow", 1, "getTemplateBean ", paramVafContext);
      }
    }
    return null;
  }
  
  private void b(VafContext paramVafContext)
  {
    TemplateBean localTemplateBean = a(paramVafContext);
    this.b = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
    if (localTemplateBean != null) {
      ProteusSupportUtil.a(this.b.getVirtualView(), localTemplateBean.getViewBean());
    }
    setContentView(this.b);
    paramVafContext = this.b.getVirtualView().getComLayoutParams();
    setHeight(paramVafContext.mLayoutHeight);
    setWidth(paramVafContext.mLayoutWidth);
  }
  
  public void a()
  {
    setOnDismissListener(new GuidePopuppWindow.1(this));
    Container localContainer = this.b;
    if (localContainer != null) {
      a(localContainer);
    }
  }
  
  protected void a(float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = this.a.getWindow().getAttributes();
    localLayoutParams.alpha = paramFloat;
    this.a.getWindow().setAttributes(localLayoutParams);
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(View paramView)
  {
    if (isShowing())
    {
      dismiss();
      return;
    }
    this.g.add(this.c.innerUniqueID);
    a(0);
    a(1.0F);
    setAnimationStyle(2131951659);
    showAtLocation(paramView, 17, 0, 0);
    paramView = new RIJTransMergeKanDianReport.ReportR5Builder();
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = paramView.addOS();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(CommentGuideConfigHandler.d());
    localReportR5Builder.addStringNotThrow("wording", localStringBuilder.toString());
    ReadInJoyCommentUtils.a("0X8009FE7", this.c, paramView);
  }
  
  public void a(Container paramContainer)
  {
    if (paramContainer == null) {
      return;
    }
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new GuidePopuppWindow.2(this));
  }
  
  public void a(GuidePopuppWindow.OnGuideDismissListener paramOnGuideDismissListener)
  {
    this.e = paramOnGuideDismissListener;
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.c = paramAbsBaseArticleInfo;
  }
  
  public boolean a(String paramString)
  {
    return this.g.contains(paramString);
  }
  
  public VafContext b()
  {
    if (this.d == null)
    {
      this.d = new ReadInjoyContext();
      this.d.setCurActivity(this.a);
      this.d.setContext(this.a);
      ProteusSupportUtil.a(this.d, "comment_feeds");
    }
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.guide.GuidePopuppWindow
 * JD-Core Version:    0.7.0.1
 */