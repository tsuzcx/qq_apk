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
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private GuidePopuppWindow.OnGuideDismissListener jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuidePopuppWindow$OnGuideDismissListener;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  public GuidePopuppWindow(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    a(a());
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
        paramVafContext = paramVafContext.getTemplateBean(CommentGuideConfigHandler.a());
        return paramVafContext;
      }
      catch (JSONException paramVafContext)
      {
        QLog.d("GuidePopuppWindow", 1, "getTemplateBean ", paramVafContext);
      }
    }
    return null;
  }
  
  private void a(VafContext paramVafContext)
  {
    TemplateBean localTemplateBean = a(paramVafContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
    if (localTemplateBean != null) {
      ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), localTemplateBean.getViewBean());
    }
    setContentView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer);
    paramVafContext = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView().getComLayoutParams();
    setHeight(paramVafContext.mLayoutHeight);
    setWidth(paramVafContext.mLayoutWidth);
  }
  
  public VafContext a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new ReadInjoyContext();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_AndroidAppActivity);
      ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "comment_feeds");
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  }
  
  public void a()
  {
    setOnDismissListener(new GuidePopuppWindow.1(this));
    Container localContainer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
    if (localContainer != null) {
      a(localContainer);
    }
  }
  
  protected void a(float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidAppActivity.getWindow().getAttributes();
    localLayoutParams.alpha = paramFloat;
    this.jdField_a_of_type_AndroidAppActivity.getWindow().setAttributes(localLayoutParams);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(View paramView)
  {
    if (isShowing())
    {
      dismiss();
      return;
    }
    this.jdField_a_of_type_JavaUtilSet.add(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
    a(0);
    a(1.0F);
    setAnimationStyle(2131755043);
    showAtLocation(paramView, 17, 0, 0);
    paramView = new RIJTransMergeKanDianReport.ReportR5Builder();
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = paramView.addOS();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(CommentGuideConfigHandler.a());
    localReportR5Builder.addStringNotThrow("wording", localStringBuilder.toString());
    ReadInJoyCommentUtils.a("0X8009FE7", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramView);
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuidePopuppWindow$OnGuideDismissListener = paramOnGuideDismissListener;
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.guide.GuidePopuppWindow
 * JD-Core Version:    0.7.0.1
 */