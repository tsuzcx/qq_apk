package com.tencent.mobileqq.troop.homework.entry.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.troopgift.absMultiViewPager;
import com.tencent.image.GifDrawable;
import com.tencent.image.GifDrawable.OnGIFPlayOnceListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.config.HomeworkConfig.HomeWorkGuideInfo.PageInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class GuideViewPager
  extends absMultiViewPager
  implements View.OnClickListener, GifDrawable.OnGIFPlayOnceListener
{
  private ComplexGuidViewPager.OnGuideBtnClickListener a;
  
  public GuideViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GuideViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static URLDrawable a(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = null;
    localURLDrawableOptions.mFailedDrawable = null;
    localURLDrawableOptions.mUseAutoScaleParams = false;
    localURLDrawableOptions.mPlayGifImage = true;
    return URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions);
  }
  
  public static void setBitmapByPath(ImageView paramImageView, String paramString)
  {
    ThreadManager.post(new GuideViewPager.1(paramString, paramImageView), 8, null, true);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public View a(int paramInt)
  {
    HomeworkConfig.HomeWorkGuideInfo.PageInfo localPageInfo = (HomeworkConfig.HomeWorkGuideInfo.PageInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(getContext()).inflate(2131561683, null);
    Object localObject = (ImageView)localRelativeLayout.findViewById(2131367650);
    ImageView localImageView3 = (ImageView)localRelativeLayout.findViewById(2131363583);
    ImageView localImageView1 = (ImageView)localRelativeLayout.findViewById(2131367622);
    ImageView localImageView2 = (ImageView)localRelativeLayout.findViewById(2131361948);
    if (localPageInfo.jdField_a_of_type_Boolean) {
      if (!TextUtils.isEmpty(localPageInfo.jdField_a_of_type_JavaLangString))
      {
        setBitmapByPath((ImageView)localObject, localPageInfo.jdField_a_of_type_JavaLangString);
        ((ImageView)localObject).setVisibility(0);
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localPageInfo.c))
      {
        localImageView2.setImageDrawable(a(localPageInfo.c));
        localImageView2.setVisibility(0);
        localImageView2.setOnClickListener(this);
      }
      return localRelativeLayout;
      if (!TextUtils.isEmpty(localPageInfo.jdField_a_of_type_JavaLangString))
      {
        setBitmapByPath(localImageView3, localPageInfo.jdField_a_of_type_JavaLangString);
        localImageView3.setVisibility(0);
      }
      if (!TextUtils.isEmpty(localPageInfo.b))
      {
        localObject = a(localPageInfo.b);
        if ((((URLDrawable)localObject).getCurrDrawable() instanceof GifDrawable)) {
          ((GifDrawable)((URLDrawable)localObject).getCurrDrawable()).setGIFPlayOnceListener(this);
        }
        localImageView1.setImageDrawable(a(localPageInfo.b));
        localImageView1.setVisibility(0);
      }
    }
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
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager$OnGuideBtnClickListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager$OnGuideBtnClickListener.a();
      }
    }
  }
  
  public void onPlayOnce()
  {
    ThreadManager.getUIHandler().post(new GuideViewPager.2(this));
  }
  
  public void setOnActionBtnClickListener(ComplexGuidViewPager.OnGuideBtnClickListener paramOnGuideBtnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager$OnGuideBtnClickListener = paramOnGuideBtnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.view.GuideViewPager
 * JD-Core Version:    0.7.0.1
 */