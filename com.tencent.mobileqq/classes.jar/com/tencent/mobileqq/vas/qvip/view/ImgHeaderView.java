package com.tencent.mobileqq.vas.qvip.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bgjk;
import bgjm;
import bgjn;
import bgjo;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.mobileqq.widget.RoundImageView;
import cooperation.qzone.mobilereport.MobileReportManager;

public class ImgHeaderView
  extends RelativeLayout
  implements bgjm
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RoundImageView jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
  private String jdField_a_of_type_JavaLangString;
  
  public ImgHeaderView(Context paramContext)
  {
    super(paramContext);
    setBackgroundColor(0);
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, QQVipMsgInfo paramQQVipMsgInfo)
  {
    paramString1 = new Intent(paramActivity, QQBrowserActivity.class);
    paramString1.putExtra("url", this.jdField_a_of_type_JavaLangString);
    paramActivity.startActivity(paramString1);
    MobileReportManager.getInstance().reportAction("QQVipAccount", "1", "1", paramInt + 1 + "", "", "1", 102, 1);
    try
    {
      bgjk.a(118, paramQQVipMsgInfo, paramInt);
      return;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public void a(QQVipMsgInfo paramQQVipMsgInfo, Activity paramActivity, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = paramQQVipMsgInfo.url;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131561812, this, false));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368516));
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setmRadius(UIUtils.dip2px(getContext(), 6.0F), true);
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramQQVipMsgInfo.coverUrl);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageDrawable(localURLDrawable);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378367));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramQQVipMsgInfo.title);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365456));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bgjn(this, paramActivity, paramQQVipMsgInfo, paramInt));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new bgjo(this, paramActivity, paramQQVipMsgInfo, paramInt));
      addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      bgjk.a(117, paramQQVipMsgInfo, paramInt);
      return;
    }
    catch (Throwable paramQQVipMsgInfo)
    {
      paramQQVipMsgInfo.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.view.ImgHeaderView
 * JD-Core Version:    0.7.0.1
 */