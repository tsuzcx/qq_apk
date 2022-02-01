package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import agej;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bged;
import bgee;
import bgev;
import bgew;
import bnsq;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import xiz;
import yuh;
import zps;

public class ArithmeticViewHolder$ArithmeticImageView
  extends RelativeLayout
  implements View.OnClickListener, URLDrawable.URLDrawableListener
{
  public ImageView a;
  private bgee jdField_a_of_type_Bgee;
  private RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  public MessageProgressView a;
  private ImageView b;
  
  public ArithmeticViewHolder$ArithmeticImageView(ArithmeticViewHolder paramArithmeticViewHolder, Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  private void c()
  {
    inflate(getContext(), 2131561622, this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)findViewById(2131368451));
    this.b = ((ImageView)findViewById(2131365373));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = ((MessageProgressView)findViewById(2131380489));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376598));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(zps.a(getContext(), 4.0F));
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(0.0F, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDisplayInTextView(agej.a(17.0F, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder.itemView.getResources()), -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new bgev(this));
    b();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bgee.jdField_b_of_type_Int == 1) || (this.jdField_a_of_type_Bgee.jdField_b_of_type_Int == 3)) {}
    do
    {
      return;
      this.jdField_a_of_type_Bgee.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_Bgee.jdField_a_of_type_Int = 0;
      ArithmeticViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder, this, this.jdField_a_of_type_Bgee);
      bnsq localbnsq = new bnsq(xiz.a(), this.jdField_a_of_type_Bgee.jdField_b_of_type_JavaLangString, ArithmeticViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder));
      localbnsq.a(new bgew(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder, this.jdField_a_of_type_Bgee));
      ThreadManager.post(new ArithmeticViewHolder.ArithmeticImageView.2(this, localbnsq), 8, null, true);
    } while (!QLog.isColorLevel());
    QLog.d("ArithmeticViewHolder", 2, "upload picture , local path = " + this.jdField_a_of_type_Bgee.jdField_b_of_type_JavaLangString);
  }
  
  public void a(bgee parambgee, int paramInt)
  {
    this.jdField_a_of_type_Bgee = parambgee;
    if (TextUtils.isEmpty(parambgee.jdField_b_of_type_JavaLangString)) {}
    for (String str = parambgee.jdField_a_of_type_JavaLangString;; str = yuh.a(parambgee.jdField_b_of_type_JavaLangString))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ArithmeticViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder);
      localURLDrawableOptions.mFailedDrawable = ArithmeticViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder);
      localURLDrawableOptions.mUseAutoScaleParams = true;
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(str, localURLDrawableOptions);
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
      if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) {
        onLoadSuccessed(this.jdField_a_of_type_ComTencentImageURLDrawable);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      ArithmeticViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder, this, parambgee);
      setVisibility(0);
      return;
    }
  }
  
  public void b()
  {
    setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ArithmeticViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder).b(this.jdField_a_of_type_Bgee);
      ArithmeticViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder);
      if (QLog.isColorLevel())
      {
        QLog.d("ArithmeticViewHolder", 2, "delete picture");
        continue;
        a();
      }
    }
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (ArithmeticViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder) == 0) {
      ArithmeticViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder, (int)(ArithmeticViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder).getMeasuredWidth() - 2.0F * TypedValue.applyDimension(1, 18.0F, ArithmeticViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder).getContext().getResources().getDisplayMetrics())));
    }
    int i = paramURLDrawable.getIntrinsicWidth();
    i = (int)(paramURLDrawable.getIntrinsicHeight() / i * ArithmeticViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder));
    paramURLDrawable = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLayoutParams();
    paramURLDrawable.width = ArithmeticViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder);
    paramURLDrawable.height = i;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setLayoutParams(paramURLDrawable);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
    localLayoutParams.width = ArithmeticViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder);
    localLayoutParams.height = i;
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ArithmeticViewHolder.ArithmeticImageView
 * JD-Core Version:    0.7.0.1
 */