package com.tencent.mobileqq.tribe.fragment;

import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tribe.playvideo.TribeVideoItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class TribeVideoListPlayerFragment$VideoViewHolder
  extends TribeVideoListPlayerFragment.BaseVideoViewHolder
  implements View.OnClickListener
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TribeVideoItem jdField_a_of_type_ComTencentMobileqqTribePlayvideoTribeVideoItem;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  LinearLayout b;
  LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  ImageView jdField_e_of_type_AndroidWidgetImageView;
  LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  ImageView jdField_f_of_type_AndroidWidgetImageView;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  ImageView g;
  ImageView h;
  ImageView i;
  ImageView j;
  ImageView k;
  ImageView l;
  ImageView m;
  
  public TribeVideoListPlayerFragment$VideoViewHolder(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment, View paramView)
  {
    super(paramView);
  }
  
  public void onClick(View paramView)
  {
    TribeVideoItem localTribeVideoItem = (TribeVideoItem)this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
    String str;
    if (localTribeVideoItem.jdField_c_of_type_Int == 31)
    {
      str = "1";
      switch (paramView.getId())
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str = "2";
      break;
      Object localObject1 = new ProfileActivity.AllInOne(String.valueOf(localTribeVideoItem.jdField_c_of_type_Long), 86);
      Object localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity(), NearbyPeopleProfileActivity.class);
      ((Intent)localObject2).putExtra("AllInOne", (Parcelable)localObject1);
      ((Intent)localObject2).putExtra("frome_where", 7);
      boolean bool = BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(String.valueOf(localTribeVideoItem.jdField_c_of_type_Long));
      com.tencent.mobileqq.app.HotChatManager.jdField_a_of_type_Boolean = false;
      if (bool) {
        ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity(), (ProfileActivity.AllInOne)localObject1);
      }
      for (;;)
      {
        ReportController.b(null, "dc00899", "Grp_tribe", "", "video_player", "Clk_poster", 0, 0, localTribeVideoItem.d, localTribeVideoItem.b + "", "", str);
        break;
        ((Intent)localObject2).putExtra("param_mode", 3);
        this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity().startActivity((Intent)localObject2);
      }
      if (!localTribeVideoItem.jdField_c_of_type_Boolean)
      {
        localObject1 = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject1).setDuration(275L);
        ((AlphaAnimation)localObject1).setFillAfter(true);
        this.k.startAnimation((Animation)localObject1);
        this.f.startAnimation((Animation)localObject1);
        localObject1 = new AlphaAnimation(0.0F, 1.0F);
        ((AlphaAnimation)localObject1).setDuration(300L);
        ((AlphaAnimation)localObject1).setStartOffset(10L);
        localObject2 = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
        ((ScaleAnimation)localObject2).setDuration(300L);
        ((ScaleAnimation)localObject2).setStartOffset(10L);
        Object localObject3 = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
        ((ScaleAnimation)localObject3).setDuration(300L);
        ((ScaleAnimation)localObject3).setStartOffset(725L);
        AnimationSet localAnimationSet = new AnimationSet(true);
        localAnimationSet.addAnimation((Animation)localObject1);
        localAnimationSet.addAnimation((Animation)localObject2);
        localAnimationSet.addAnimation((Animation)localObject3);
        localAnimationSet.setFillAfter(true);
        this.m.startAnimation(localAnimationSet);
        localObject1 = new ScaleAnimation(1.0F, 0.5F, 1.0F, 1.0F, 1, 0.0F, 1, 0.0F);
        ((ScaleAnimation)localObject1).setDuration(300L);
        ((ScaleAnimation)localObject1).setStartOffset(60L);
        localObject2 = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject2).setDuration(300L);
        ((AlphaAnimation)localObject2).setStartOffset(775L);
        localObject3 = new AnimationSet(true);
        ((AnimationSet)localObject3).addAnimation((Animation)localObject1);
        ((AnimationSet)localObject3).addAnimation((Animation)localObject2);
        ((AnimationSet)localObject3).setFillAfter(true);
        this.l.startAnimation((Animation)localObject3);
        this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.a(1, String.valueOf(localTribeVideoItem.jdField_c_of_type_Long), new TribeVideoListPlayerFragment.VideoViewHolder.1(this, localTribeVideoItem, str));
        continue;
        TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_a_of_type_Int = 4;
        if (TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).b)
        {
          if ((TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).isAdded()) && (!TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).isVisible()))
          {
            this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity().getSupportFragmentManager().beginTransaction().show(TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment)).commitAllowingStateLoss();
            this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.c(TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_a_of_type_Int);
          }
          label708:
          if (localTribeVideoItem.h == 0) {
            break label847;
          }
        }
        label847:
        for (localObject1 = "" + localTribeVideoItem.h;; localObject1 = "")
        {
          ReportController.b(null, "dc00899", "Grp_tribe", "", "video_player", "Clk_comment", this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.e, 0, localTribeVideoItem.d, localTribeVideoItem.b + "", (String)localObject1, str);
          break;
          if ((!TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_c_of_type_Boolean) || (TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).webView == null)) {
            break label708;
          }
          TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).webView.loadUrl(TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment));
          break label708;
        }
        TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.e(0);
        this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.e(2);
        if (TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).b)
        {
          this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.e(1);
          if ((TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).isAdded()) && (!TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).isVisible())) {
            this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity().getSupportFragmentManager().beginTransaction().show(TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment)).commitAllowingStateLoss();
          }
          if (localTribeVideoItem.m == 0) {
            this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.c(5);
          }
        }
        for (;;)
        {
          ReportController.b(null, "dc00899", "Grp_tribe", "", "video_player", "Clk_comment", this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.e, 0, localTribeVideoItem.d, localTribeVideoItem.b + "", "", str);
          break;
          this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.c(1);
          continue;
          if (TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_c_of_type_Boolean)
          {
            if (TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).webView != null) {
              TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).webView.loadUrl(TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment));
            }
          }
          else if (TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_a_of_type_Boolean) {
            TribeVideoListPlayerFragment.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_JavaLangRunnable, 1000L);
          }
        }
        TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_a_of_type_Int = 2;
        this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.e(0);
        this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.e(1);
        if (TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).b)
        {
          this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.e(2);
          if ((TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).isAdded()) && (!TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).isVisible())) {
            this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity().getSupportFragmentManager().beginTransaction().show(TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment)).commitAllowingStateLoss();
          }
          this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.c(TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_a_of_type_Int);
        }
        for (;;)
        {
          ReportController.b(null, "dc00899", "Grp_tribe", "", "video_player", "Clk_share", 0, 0, localTribeVideoItem.d, localTribeVideoItem.b + "", "", str);
          break;
          if (TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_c_of_type_Boolean)
          {
            if (TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).webView != null) {
              TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).webView.loadUrl(TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment));
            }
          }
          else if (TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_a_of_type_Boolean) {
            TribeVideoListPlayerFragment.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_JavaLangRunnable, 1000L);
          }
        }
        if (localTribeVideoItem.k != 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.a(localTribeVideoItem.b, localTribeVideoItem.d, new TribeVideoListPlayerFragment.VideoViewHolder.2(this, localTribeVideoItem));
          ReportController.b(null, "dc00899", "Grp_tribe", "", "video_player", "Clk_like", 0, 0, localTribeVideoItem.d, localTribeVideoItem.b + "", "", str);
          continue;
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity(), QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", localTribeVideoItem.g);
          this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity().startActivity((Intent)localObject1);
          ReportController.b(null, "dc00899", "Grp_tribe", "", "video_player", "Clk_detail", 0, 0, localTribeVideoItem.d, localTribeVideoItem.b + "", "", str);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.VideoViewHolder
 * JD-Core Version:    0.7.0.1
 */