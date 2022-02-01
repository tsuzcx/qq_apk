package com.tencent.mobileqq.extendfriend.bean;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatResourceUtil;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.extendfriend.wiget.FeedBannerItemGradientLinearLayout;
import com.tencent.mobileqq.extendfriend.wiget.HeadsPanelAnimationView;
import com.tencent.mobileqq.extendfriend.wiget.TabLayout;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studyroom.utils.StudyRoomReporter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class FeedBannerViewHolder
  extends RecyclerView.ViewHolder
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FeedBannerViewHolder.FeedBannerClickListener jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder$FeedBannerClickListener;
  private HeadsPanelAnimationView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHeadsPanelAnimationView;
  private String jdField_a_of_type_JavaLangString = "school_tab";
  private boolean jdField_a_of_type_Boolean = true;
  
  public FeedBannerViewHolder(View paramView, FeedBannerViewHolder.FeedBannerClickListener paramFeedBannerClickListener)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder$FeedBannerClickListener = paramFeedBannerClickListener;
  }
  
  public FeedBannerViewHolder(View paramView, FeedBannerViewHolder.FeedBannerClickListener paramFeedBannerClickListener, String paramString, boolean paramBoolean)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder$FeedBannerClickListener = paramFeedBannerClickListener;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a(Context paramContext, FeedBannerTabItem paramFeedBannerTabItem)
  {
    if ((paramFeedBannerTabItem == null) || (paramContext == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("FeedBannerViewHolder", 2, "jumpUrl bannerTabItem or context null ");
      }
    }
    label216:
    do
    {
      do
      {
        String str;
        int i;
        do
        {
          do
          {
            do
            {
              return;
              str = paramFeedBannerTabItem.d;
              i = paramFeedBannerTabItem.jdField_a_of_type_Int;
              if (QLog.isColorLevel()) {
                QLog.d("FeedBannerViewHolder", 2, "parse banner jumpUrl " + str + ", type =" + i);
              }
              if (i != 0) {
                break;
              }
            } while (this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder$FeedBannerClickListener == null);
            this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder$FeedBannerClickListener.an_();
            return;
            if (i != 1) {
              break;
            }
            if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(str))
            {
              ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.itemView.getContext(), str, 2065, null);
              return;
            }
          } while (!QLog.isColorLevel());
          QLog.e("FeedBannerViewHolder", 2, "jumpUrl is not scheme ");
          return;
          if (i != 2) {
            break label216;
          }
          if (!TextUtils.isEmpty(str)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("FeedBannerViewHolder", 2, "web jumpUrl is null ");
        return;
        paramFeedBannerTabItem = new Intent(paramContext, QQBrowserActivity.class);
        paramFeedBannerTabItem.putExtra("url", str);
        paramContext.startActivity(paramFeedBannerTabItem);
        return;
        if (i != 3) {
          break;
        }
        try
        {
          paramFeedBannerTabItem = new Intent(BaseApplicationImpl.getContext(), JumpActivity.class);
          paramFeedBannerTabItem.setData(Uri.parse(str));
          paramContext.startActivity(paramFeedBannerTabItem);
          paramContext = new Bundle();
          paramContext.putString("action", "click");
          paramContext.putString("page", "kuolie");
          paramContext.putString("module", "selfstudy");
          StudyRoomReporter.a(paramContext);
          return;
        }
        catch (Exception paramContext) {}
      } while (!QLog.isColorLevel());
      QLog.e("FeedBannerViewHolder", 2, "click studyroom", paramContext);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("FeedBannerViewHolder", 2, "jumpUrl is not support ");
  }
  
  private void a(View paramView, FeedBannerTabItem paramFeedBannerTabItem, int paramInt1, int paramInt2)
  {
    int i = ViewUtils.a(5.0F);
    ((RoundCorneredRelativeLayout)paramView).setRadius(i, i, i, i);
    Object localObject2 = (ImageView)paramView.findViewById(2131368603);
    TextView localTextView1 = (TextView)paramView.findViewById(2131379432);
    TextView localTextView2 = (TextView)paramView.findViewById(2131378625);
    if (!TextUtils.isEmpty(paramFeedBannerTabItem.jdField_a_of_type_JavaLangString)) {
      localTextView1.setText(paramFeedBannerTabItem.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(paramFeedBannerTabItem.jdField_b_of_type_JavaLangString)) {
      localTextView2.setText(paramFeedBannerTabItem.jdField_b_of_type_JavaLangString);
    }
    Object localObject1 = (FeedBannerItemGradientLinearLayout)paramView.findViewById(2131368015);
    if (paramInt2 == 1)
    {
      i = 24;
      ((FeedBannerItemGradientLinearLayout)localObject1).a(ViewUtils.a(i), paramFeedBannerTabItem.jdField_b_of_type_Int, paramFeedBannerTabItem.jdField_c_of_type_Int);
      localObject1 = (FrameLayout)paramView.findViewById(2131368606);
      if ((!this.jdField_a_of_type_Boolean) || (paramFeedBannerTabItem.jdField_a_of_type_Int != 0)) {
        break label395;
      }
      ((ImageView)localObject2).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = localTextView2;
      localObject2 = paramView.getContext().getResources().getDrawable(2130845245);
      ((Drawable)localObject2).setBounds(ViewUtils.a(1.0F), 0, ViewUtils.a(7.0F), ViewUtils.a(6.0F));
      localTextView2.setCompoundDrawablePadding(ViewUtils.a(3.0F));
      localTextView2.setCompoundDrawables((Drawable)localObject2, null, null, null);
      if (paramInt2 != 2) {
        break label347;
      }
      ((ViewGroup.MarginLayoutParams)localTextView2.getLayoutParams()).rightMargin = ViewUtils.a(80.0F);
      label252:
      a((FrameLayout)localObject1, paramInt2);
      a(paramFeedBannerTabItem);
    }
    for (;;)
    {
      localObject2 = (ImageView)paramView.findViewById(2131365421);
      Object localObject3 = Drawable.createFromPath(ExtendFriendLimitChatResourceUtil.a(paramInt2));
      if (localObject3 != null) {
        ((ImageView)localObject2).setImageDrawable((Drawable)localObject3);
      }
      paramView.setOnTouchListener(new FeedBannerViewHolder.2(this, paramView.findViewById(2131373443), (FrameLayout)localObject1, localTextView1, localTextView2, paramFeedBannerTabItem, paramInt1));
      return;
      if (paramInt2 == 2)
      {
        i = 22;
        break;
      }
      i = 40;
      break;
      label347:
      if (paramInt2 != 1) {
        break label252;
      }
      localTextView1.setTextSize(25.0F);
      localTextView2.setTextSize(12.0F);
      localTextView2.setPadding(0, ViewUtils.a(2.0F), 0, 0);
      paramView.findViewById(2131363041).setVisibility(0);
      break label252;
      label395:
      if (paramFeedBannerTabItem.jdField_c_of_type_JavaLangString != null)
      {
        try
        {
          localObject3 = new URL(paramFeedBannerTabItem.jdField_c_of_type_JavaLangString);
          ColorDrawable localColorDrawable1 = new ColorDrawable(0);
          ColorDrawable localColorDrawable2 = new ColorDrawable(0);
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = localColorDrawable1;
          localURLDrawableOptions.mFailedDrawable = localColorDrawable2;
          localURLDrawableOptions.mUseApngImage = true;
          localURLDrawableOptions.mMemoryCacheKeySuffix = "useAPNG";
          ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable((URL)localObject3, localURLDrawableOptions));
        }
        catch (MalformedURLException localMalformedURLException) {}
        if (QLog.isColorLevel()) {
          QLog.e("FeedBannerViewHolder", 2, "setImageUrl error " + localMalformedURLException.toString());
        }
      }
    }
  }
  
  private void a(FrameLayout paramFrameLayout, int paramInt)
  {
    int j = 3;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHeadsPanelAnimationView != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHeadsPanelAnimationView.d();
    }
    int i;
    FrameLayout.LayoutParams localLayoutParams;
    if (paramInt == 1)
    {
      i = 4;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHeadsPanelAnimationView = new HeadsPanelAnimationView(i);
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHeadsPanelAnimationView.a() != null)
      {
        localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (paramInt != 1) {
          break label129;
        }
        localLayoutParams.bottomMargin = ViewUtils.a(20.0F);
        localLayoutParams.topMargin = ViewUtils.a(16.0F);
        if (paramInt != 1) {
          break label166;
        }
      }
    }
    label129:
    label166:
    for (paramInt = j;; paramInt = 5)
    {
      localLayoutParams.gravity = paramInt;
      paramFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHeadsPanelAnimationView.a(), localLayoutParams);
      return;
      if (paramInt <= 2)
      {
        i = 2;
        break;
      }
      i = 3;
      break;
      if (paramInt <= 2) {}
      for (i = ViewUtils.a(16.0F);; i = ViewUtils.a(22.0F))
      {
        localLayoutParams.bottomMargin = i;
        localLayoutParams.topMargin = i;
        break;
      }
    }
  }
  
  private void a(FeedBannerTabItem paramFeedBannerTabItem, int paramInt)
  {
    a(paramFeedBannerTabItem, paramInt, "0X800A9B1");
    HashMap localHashMap = new HashMap();
    if (paramInt == 0) {
      localHashMap.put("banner_appid", "1");
    }
    for (;;)
    {
      ExpandReportUtils.a("click#" + this.jdField_a_of_type_JavaLangString + "#banner", true, -1L, -1L, localHashMap, true, true);
      a(this.itemView.getContext(), paramFeedBannerTabItem);
      return;
      localHashMap.put("banner_appid", String.valueOf(paramFeedBannerTabItem.jdField_a_of_type_Long));
    }
  }
  
  private void a(FeedBannerTabItem paramFeedBannerTabItem, int paramInt, String paramString)
  {
    if ((paramFeedBannerTabItem != null) && (paramFeedBannerTabItem.jdField_a_of_type_Int != 0))
    {
      String str1 = paramFeedBannerTabItem.jdField_a_of_type_JavaLangString;
      String str2 = paramFeedBannerTabItem.jdField_b_of_type_JavaLangString;
      long l = paramFeedBannerTabItem.jdField_a_of_type_Long;
      ReportController.b(null, "dc00898", "", "", "qq_kuolie", paramString, 0, 0, paramInt + "", "", l + ";" + str1, str2);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHeadsPanelAnimationView != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHeadsPanelAnimationView.d();
    }
  }
  
  public void a(FeedBannerTabItem paramFeedBannerTabItem)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (paramFeedBannerTabItem.jdField_b_of_type_JavaLangString != null)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramFeedBannerTabItem.jdField_b_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHeadsPanelAnimationView != null) && (paramFeedBannerTabItem.jdField_a_of_type_JavaUtilArrayList != null)) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHeadsPanelAnimationView.a(paramFeedBannerTabItem.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  public void a(StrangerInfo paramStrangerInfo, int paramInt)
  {
    Object localObject;
    ViewGroup.LayoutParams localLayoutParams;
    int i;
    if (((paramStrangerInfo instanceof FeedBannerInfo)) && ((this.itemView instanceof TabLayout)))
    {
      localObject = (FeedBannerInfo)paramStrangerInfo;
      paramStrangerInfo = (TabLayout)this.itemView;
      paramStrangerInfo.setPadding(paramStrangerInfo.getPaddingLeft(), paramInt, paramStrangerInfo.getPaddingRight(), paramStrangerInfo.getPaddingBottom());
      localObject = ((FeedBannerInfo)localObject).jdField_a_of_type_JavaUtilArrayList;
      localLayoutParams = paramStrangerInfo.getLayoutParams();
      i = ((ArrayList)localObject).size();
      if (i != 1) {
        break label129;
      }
      i = 122;
    }
    for (;;)
    {
      i = ViewUtils.a(i);
      if (localLayoutParams != null) {
        localLayoutParams.height = (i + paramInt);
      }
      paramStrangerInfo.a().setMinimumHeight(i);
      paramStrangerInfo.a(new FeedBannerViewHolder.1(this, (ArrayList)localObject, ViewUtils.a(120.0F), ViewUtils.a(4.0F)));
      return;
      label129:
      if (i == 2) {
        i = 108;
      } else {
        i = 168;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.bean.FeedBannerViewHolder
 * JD-Core Version:    0.7.0.1
 */