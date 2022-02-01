package com.tencent.mobileqq.kandian.biz.message;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.glue.report.RIJMsgReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;

public class ReadinjoySocialMsgTips
  implements ReadinjoySocialMsgUI
{
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private static Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView;
  private KandianMsgBoxRedPntInfo jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ReadinjoySocialMsgTips(Activity paramActivity, View paramView)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    c();
  }
  
  private void c()
  {
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130841788));
    jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130841789));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView = ((ReadInJoyHeadImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368343));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setRound(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setImagePlaceHolder(jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365169));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371559));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377693);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362989));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new ReadinjoySocialMsgTips.1(this));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo;
      if ((localObject != null) && (((KandianMsgBoxRedPntInfo)localObject).mMsgCnt > 0))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localObject = RIJTransMergeKanDianReport.b();
        localObject = RIJMsgReport.a.a((String)localObject);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800824A", "0X800824A", 0, 0, "", "", "", (String)localObject, false);
      }
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    if ((paramKandianMsgBoxRedPntInfo != null) && (!paramKandianMsgBoxRedPntInfo.equals(this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("set msg info , count : ");
      ((StringBuilder)localObject).append(paramKandianMsgBoxRedPntInfo.mMsgCnt);
      ((StringBuilder)localObject).append(", uin : ");
      ((StringBuilder)localObject).append(paramKandianMsgBoxRedPntInfo.mUin);
      ((StringBuilder)localObject).append(", seq : ");
      ((StringBuilder)localObject).append(paramKandianMsgBoxRedPntInfo.mSeq);
      QLog.d("ReadinjoySocialMsgTips", 2, ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int % 2 == 0) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setImagePlaceHolder(jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setImagePlaceHolder(jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo = paramKandianMsgBoxRedPntInfo;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo.mMsgType == 2)
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo.mIconUrl))
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setImage(RIJConvertString2URL.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo.mIconUrl));
        }
        else
        {
          localObject = (Animatable)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.getResources().getDrawable(2130843045);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setImageDrawable((Drawable)localObject);
          if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo.canDoAnimation) {
            ((Animatable)localObject).start();
          }
        }
      }
      else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo.mIconUrl)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setImage(RIJConvertString2URL.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo.mIconUrl));
      } else if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo.mUin > 0L) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setHeadImgByUin(this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo.mUin);
      }
      if (Aladdin.getConfig(431).getIntegerFromString("msg_ui_style", 0) == 1)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramKandianMsgBoxRedPntInfo.mMsgText);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ReadInJoyHelper.c(paramKandianMsgBoxRedPntInfo.mMsgCnt));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841359);
        this.jdField_a_of_type_AndroidWidgetImageView.clearColorFilter();
        ((LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).bottomMargin = 0;
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(ReadInJoyHelper.b(paramKandianMsgBoxRedPntInfo.mMsgCnt));
        localStringBuilder.append(HardCodeUtil.a(2131712721));
        ((TextView)localObject).setText(localStringBuilder.toString());
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843458);
        this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(this.jdField_a_of_type_AndroidViewView.getResources().getColor(2131165327), PorterDuff.Mode.SRC_IN);
        ((LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).bottomMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 8.0F);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo.canDoAnimation = false;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("210 msgInfo is null ! ");
    ((StringBuilder)localObject).append(paramKandianMsgBoxRedPntInfo);
    QLog.d("ReadinjoySocialMsgTips", 2, ((StringBuilder)localObject).toString());
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.ReadinjoySocialMsgTips
 * JD-Core Version:    0.7.0.1
 */