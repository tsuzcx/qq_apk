package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.view.widget.BezierSideBarView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.base.view.widget.ZImageView;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackQuestionAnswerExtraInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackTopicExtraInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class ComponentPolymericPullAnimatorView
  extends LinearLayout
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  ComponentPolymericView jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView;
  IReadInJoyModel jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ComponentPolymericPullAnimatorView(Context paramContext, IReadInJoyModel paramIReadInJoyModel)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel = paramIReadInJoyModel;
    b();
  }
  
  private void b()
  {
    setOrientation(1);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a();
    if ((RIJFeedsType.F((AbsBaseArticleInfo)localObject1)) || (RIJFeedsType.G((AbsBaseArticleInfo)localObject1)))
    {
      localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560125, null);
      addView((View)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)((View)localObject2).findViewById(2131368343));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131378784));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131371472));
      this.jdField_b_of_type_AndroidViewView = ((View)localObject2).findViewById(2131365759);
      this.jdField_a_of_type_AndroidViewView = ((View)localObject2).findViewById(2131365132);
      if (DailyModeConfigHandler.c(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.c()))
      {
        localObject1 = new LinearLayout.LayoutParams(-1, DisplayUtil.a(getContext(), 45.0F));
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_Int = 2130842939;
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImageDrawable(getResources().getDrawable(this.jdField_a_of_type_Int));
        localObject1 = new RelativeLayout.LayoutParams(DisplayUtil.a(getContext(), 18.0F), DisplayUtil.a(getContext(), 18.0F));
        ((RelativeLayout.LayoutParams)localObject1).setMargins(DisplayUtil.a(getContext(), 12.0F), 0, DisplayUtil.a(getContext(), 6.0F), 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(15);
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702471));
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
        this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.defaultFromStyle(1));
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, Utils.rp2px(18.0D));
      }
      else
      {
        localObject2 = new LinearLayout.LayoutParams(-1, DisplayUtil.a(getContext(), 36.0F));
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        if (((AbsBaseArticleInfo)localObject1).mNewPolymericInfo.jdField_a_of_type_Int == 12)
        {
          this.jdField_a_of_type_Int = 2130843140;
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImageDrawable(getResources().getDrawable(this.jdField_a_of_type_Int));
          this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702501));
        }
        else if (((AbsBaseArticleInfo)localObject1).mNewPolymericInfo.jdField_a_of_type_Int == 13)
        {
          this.jdField_a_of_type_Int = 2130843080;
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImageDrawable(getResources().getDrawable(this.jdField_a_of_type_Int));
          this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702497));
        }
      }
    }
    localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView = new ComponentPolymericView(this.jdField_a_of_type_AndroidContentContext);
    BezierSideBarView localBezierSideBarView = new BezierSideBarView(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView, (ViewGroup.LayoutParams)localObject2);
    ((RelativeLayout)localObject1).addView(localBezierSideBarView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView.setSideBarView(localBezierSideBarView);
    addView((View)localObject1);
  }
  
  public ComponentPolymericView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView;
  }
  
  public void a()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a();
    if ((RIJFeedsType.F(localAbsBaseArticleInfo)) || (RIJFeedsType.G(localAbsBaseArticleInfo)))
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localObject2 = new StringBuilder();
        localObject3 = localAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (NewPolymericInfo.PackArticleInfo)((Iterator)localObject3).next();
          boolean bool = RIJFeedsType.F(localAbsBaseArticleInfo);
          if (bool)
          {
            localStringBuilder.append(((NewPolymericInfo.PackArticleInfo)localObject4).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackTopicExtraInfo.b);
            localStringBuilder.append(",");
          }
          else
          {
            ((StringBuilder)localObject2).append(((NewPolymericInfo.PackArticleInfo)localObject4).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackQuestionAnswerExtraInfo.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject2).append(",");
          }
        }
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        localJSONObject.put("channel_id", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.c());
        localJSONObject.put("rowkey", ((StringBuilder)localObject2).toString());
        localJSONObject.put("topicid", localStringBuilder.toString());
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      Object localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localAbsBaseArticleInfo.mFeedId);
      ((StringBuilder)localObject1).append("");
      Object localObject3 = ((StringBuilder)localObject1).toString();
      if (RIJFeedsType.F(localAbsBaseArticleInfo)) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(localAbsBaseArticleInfo.mStrategyId);
      ((StringBuilder)localObject4).append("");
      ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8009828", "0X8009828", 0, 0, (String)localObject3, (String)localObject1, ((StringBuilder)localObject4).toString(), localJSONObject.toString(), false);
      if (!TextUtils.isEmpty(localAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaLangString)) {
        try
        {
          localObject1 = new URL(localAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImagePlaceHolder(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(this.jdField_a_of_type_Int)).setImage((URL)localObject1);
        }
        catch (MalformedURLException localMalformedURLException)
        {
          QLog.d("ComponentPolymericPullAnimatorView topic icon", 2, localMalformedURLException, new Object[0]);
        }
      }
      if (!TextUtils.isEmpty(localAbsBaseArticleInfo.mNewPolymericInfo.b)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localAbsBaseArticleInfo.mNewPolymericInfo.b);
      }
      if (!TextUtils.isEmpty(localAbsBaseArticleInfo.mNewPolymericInfo.c)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(localAbsBaseArticleInfo.mNewPolymericInfo.c);
      }
      if (!TextUtils.isEmpty(localAbsBaseArticleInfo.mNewPolymericInfo.d)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new ComponentPolymericPullAnimatorView.1(this, localAbsBaseArticleInfo, localJSONObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentPolymericPullAnimatorView
 * JD-Core Version:    0.7.0.1
 */