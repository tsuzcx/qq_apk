package com.tencent.mobileqq.leba.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.LebaFeedInfo;
import com.tencent.mobileqq.leba.LebaFeedsAdapter.ListItem;
import com.tencent.mobileqq.leba.LebaFeedsVideoPlayController;
import com.tencent.mobileqq.leba.LebaFeedsVideoPlayController.VideoPlayParam;
import com.tencent.mobileqq.leba.UITemplate.VideoUITemplateInfo;
import com.tencent.qphone.base.util.QLog;

public class LebaFeedsVideoView1
  extends LebaFeedsNativeViewBase
  implements View.OnClickListener
{
  protected int a;
  protected ImageView a;
  protected RelativeLayout a;
  protected URLImageView a;
  protected LebaFeedsVideoPlayController.VideoPlayParam a;
  protected LebaFeedsVideoPlayController a;
  protected int b;
  protected RelativeLayout b;
  
  public LebaFeedsVideoView1(Context paramContext, LebaFeedsVideoPlayController paramLebaFeedsVideoPlayController)
  {
    super(paramContext);
    super.setId(2131362519);
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController = paramLebaFeedsVideoPlayController;
    a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2130969495, null));
    this.a.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new ViewGroup.LayoutParams(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366708));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366709));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366710));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(LebaFeedsViewBase.b);
  }
  
  public LebaFeedsVideoPlayController.VideoPlayParam a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam;
  }
  
  protected void a()
  {
    int i = getResources().getDisplayMetrics().widthPixels - AIOUtils.a(40.0F, getResources());
    int j = (int)(1.0F * i / 16.0F * 9.0F);
    this.jdField_a_of_type_Int = i;
    this.jdField_b_of_type_Int = j;
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsVideoView1", 2, "calcVideoSize w=" + this.jdField_a_of_type_Int + ", h=" + this.jdField_b_of_type_Int);
    }
  }
  
  public void a(LebaFeedsAdapter.ListItem paramListItem)
  {
    if (paramListItem == null) {}
    do
    {
      return;
      super.a(paramListItem);
      paramListItem = paramListItem.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo;
    } while (paramListItem == null);
    if ((paramListItem.templateInfo != null) && ((paramListItem.templateInfo instanceof VideoUITemplateInfo)))
    {
      paramListItem = (VideoUITemplateInfo)paramListItem.templateInfo;
      if (!TextUtils.isEmpty(paramListItem.jdField_c_of_type_JavaLangString)) {
        break label204;
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam = new LebaFeedsVideoPlayController.VideoPlayParam();
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsVideoView1 = this;
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo = this.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo;
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_AndroidWidgetImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_b_of_type_AndroidWidgetImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo.feedID;
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_Int = this.c;
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_JavaLangString = paramListItem.jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_b_of_type_JavaLangString = paramListItem.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_c_of_type_JavaLangString = paramListItem.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_b_of_type_Long = paramListItem.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_c_of_type_Long = paramListItem.jdField_b_of_type_Long;
      return;
      QLog.e("LebaFeedsVideoView1", 1, "fillData VideoUITemplateInfo is null or not instance VideoUITemplateInfo");
      return;
      label204:
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_b_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localObject = URLDrawable.getDrawable(paramListItem.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_b_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.i("LebaFeedsVideoView1", 2, "onClick hasDelete=true, v=" + paramView);
      }
    }
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        super.onClick(paramView);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController == null);
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController.onClick(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.view.LebaFeedsVideoView1
 * JD-Core Version:    0.7.0.1
 */