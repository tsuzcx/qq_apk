package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.follow.FollowListInfoModule;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import java.text.DecimalFormat;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentHeaderRecommend
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView;
  public ReadInJoyNickNameTextView a;
  public ReadInJoyYAFolderTextView a;
  
  public ComponentHeaderRecommend(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderRecommend(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentHeaderRecommend(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private long a()
  {
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSubscribeID);
      return l;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
    return 0L;
  }
  
  private boolean b()
  {
    try
    {
      boolean bool = FollowListInfoModule.a(a(), null);
      return bool;
    }
    catch (Exception localException)
    {
      label11:
      break label11;
    }
    return false;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (b())
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131702436));
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#BBBBBB"));
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131702529));
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#07D0B0"));
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(true);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setText(RIJStringUtils.a(((AbsBaseArticleInfo)localObject).mSubscribeName));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setOnClickListener(this);
      if ((((AbsBaseArticleInfo)localObject).mSocialFeedInfo != null) && (RIJItemViewTypeUtils.g((AbsBaseArticleInfo)localObject)) && (((AbsBaseArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.a == 1))
      {
        localObject = getResources().getDrawable(2130845016);
        ((Drawable)localObject).setBounds(0, 0, AIOUtils.b(16.0F, getResources()), AIOUtils.b(16.0F, getResources()));
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setCompoundDrawablePadding(AIOUtils.b(4.0F, getResources()));
      }
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setMaxLines(7);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setSpanText(HardCodeUtil.a(2131702447));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setMoreSpan(new ComponentHeaderRecommend.1(this));
      if (RIJFeedsType.I(localAbsBaseArticleInfo)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setVisibility(8);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setText(localAbsBaseArticleInfo.mSummary);
      }
      g();
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
  }
  
  private void g()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
    if (RIJFeedsType.I((AbsBaseArticleInfo)localObject1))
    {
      if (((AbsBaseArticleInfo)localObject1).mTime > 0L)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getRelativeDisplayForTime(((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.e, true));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702467));
      return;
    }
    if (((AbsBaseArticleInfo)localObject1).mSocialFeedInfo != null)
    {
      if (!TextUtils.isEmpty(((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.d))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.d);
        return;
      }
      if (((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null)
      {
        int i = ((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a;
        if (i >= 10000)
        {
          localObject1 = new DecimalFormat("####.0");
          localObject2 = new StringBuilder();
          double d = i;
          Double.isNaN(d);
          ((StringBuilder)localObject2).append(((DecimalFormat)localObject1).format(d / 10000.0D));
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131702466));
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).append(i);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        Object localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(HardCodeUtil.a(2131702460));
        ((TextView)localObject2).setText(localStringBuilder.toString());
      }
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
      Object localObject2 = new StringBuilder();
      Object localObject1 = "";
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(a());
      String str = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(ReadInJoyConstants.k);
      ((StringBuilder)localObject2).append(Base64Util.encodeToString(String.valueOf(a()).getBytes(), 2));
      localObject2 = ((StringBuilder)localObject2).toString();
      ReadInJoyUtils.a(getContext(), (String)localObject2);
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        ((JSONObject)localObject2).put("rowkey", localAbsBaseArticleInfo.innerUniqueID);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(RIJAppSetting.a());
        ((JSONObject)localObject2).put("kandian_mode", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(RIJTransMergeKanDianReport.a());
        ((JSONObject)localObject2).put("tab_source", localStringBuilder.toString());
        localObject2 = ((JSONObject)localObject2).toString();
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, str, "0X80080ED", "0X80080ED", 0, 0, String.valueOf(localAbsBaseArticleInfo.mFeedId), String.valueOf(localAbsBaseArticleInfo.mArticleID), "", (String)localObject1, false);
    }
  }
  
  private void i()
  {
    if (!b())
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131702437));
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#BBBBBB"));
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(false);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null))
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
        if ((localAbsBaseArticleInfo.mGroupSubArticleList != null) && (localAbsBaseArticleInfo.mGroupSubArticleList.size() > 0))
        {
          localAbsBaseArticleInfo = (AbsBaseArticleInfo)localAbsBaseArticleInfo.mGroupSubArticleList.get(0);
          if ((!(localAbsBaseArticleInfo instanceof BaseArticleInfo)) || (RIJItemViewTypeUtils.v(localAbsBaseArticleInfo)))
          {
            i = 2;
            break label153;
          }
        }
      }
      int i = 1;
      label153:
      ReadInJoyLogicEngine.a().a().request0x978(localQQAppInterface.getAccount(), a(), true, "", new ComponentHeaderRecommend.2(this), i);
      c();
    }
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560144, this, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView = ((ReadInJoyHeadImageView)findViewById(2131363135));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)findViewById(2131371877));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365265));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131365536));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363938));
    this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(true);
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    long l = a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setHeadImgByUin(l);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setOnClickListener(this);
    e();
    f();
    d();
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof IReadInJoyModel)) {
      a((IReadInJoyModel)paramObject);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363938: 
      i();
      return;
    }
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderRecommend
 * JD-Core Version:    0.7.0.1
 */