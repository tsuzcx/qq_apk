package com.tencent.mobileqq.qqexpand.feed;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.mobileqq.qqexpand.utils.ExpandLimitChatResourceUtil;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.widget.FeedBannerItemGradientLinearLayout;
import com.tencent.mobileqq.qqexpand.widget.HeadsPanelAnimationView;
import com.tencent.mobileqq.qqexpand.widget.TabLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studyroom.api.IStudyRoomReporter;
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
  private final FeedBannerViewHolder.FeedBannerClickListener jdField_a_of_type_ComTencentMobileqqQqexpandFeedFeedBannerViewHolder$FeedBannerClickListener;
  private HeadsPanelAnimationView jdField_a_of_type_ComTencentMobileqqQqexpandWidgetHeadsPanelAnimationView;
  private String jdField_a_of_type_JavaLangString = "school_tab";
  private boolean jdField_a_of_type_Boolean = true;
  
  public FeedBannerViewHolder(View paramView, FeedBannerViewHolder.FeedBannerClickListener paramFeedBannerClickListener)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFeedFeedBannerViewHolder$FeedBannerClickListener = paramFeedBannerClickListener;
  }
  
  private void a(Context paramContext, FeedBannerTabItem paramFeedBannerTabItem)
  {
    if ((paramFeedBannerTabItem != null) && (paramContext != null))
    {
      String str = paramFeedBannerTabItem.d;
      int i = paramFeedBannerTabItem.jdField_a_of_type_Int;
      if (QLog.isColorLevel())
      {
        paramFeedBannerTabItem = new StringBuilder();
        paramFeedBannerTabItem.append("parse banner jumpUrl ");
        paramFeedBannerTabItem.append(str);
        paramFeedBannerTabItem.append(", type =");
        paramFeedBannerTabItem.append(i);
        QLog.d("FeedBannerViewHolder", 2, paramFeedBannerTabItem.toString());
      }
      if (i == 0)
      {
        paramContext = this.jdField_a_of_type_ComTencentMobileqqQqexpandFeedFeedBannerViewHolder$FeedBannerClickListener;
        if (paramContext != null) {
          paramContext.a();
        }
      }
      else if (i == 1)
      {
        if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(str))
        {
          ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.itemView.getContext(), str, 2065, null);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.e("FeedBannerViewHolder", 2, "jumpUrl is not scheme ");
        }
      }
      else
      {
        if (i == 2)
        {
          if (TextUtils.isEmpty(str))
          {
            if (QLog.isColorLevel()) {
              QLog.e("FeedBannerViewHolder", 2, "web jumpUrl is null ");
            }
            return;
          }
          paramFeedBannerTabItem = new Intent(paramContext, QQBrowserActivity.class);
          paramFeedBannerTabItem.putExtra("url", str);
          paramContext.startActivity(paramFeedBannerTabItem);
          return;
        }
        if (i == 3)
        {
          try
          {
            paramFeedBannerTabItem = new Intent(BaseApplicationImpl.getContext(), JumpActivity.class);
            paramFeedBannerTabItem.setData(Uri.parse(str));
            paramContext.startActivity(paramFeedBannerTabItem);
            ((IStudyRoomReporter)QRoute.api(IStudyRoomReporter.class)).reportForExpandEntry();
            return;
          }
          catch (Exception paramContext)
          {
            if (!QLog.isColorLevel()) {
              break label291;
            }
          }
          QLog.e("FeedBannerViewHolder", 2, "click studyroom", paramContext);
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("FeedBannerViewHolder", 2, "jumpUrl is not support ");
        }
      }
      label291:
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("FeedBannerViewHolder", 2, "jumpUrl bannerTabItem or context null ");
    }
  }
  
  private void a(View paramView, FeedBannerTabItem paramFeedBannerTabItem, int paramInt1, int paramInt2)
  {
    int i = ViewUtils.a(5.0F);
    Object localObject1 = (RoundCorneredRelativeLayout)paramView;
    float f = i;
    ((RoundCorneredRelativeLayout)localObject1).setRadius(f, f, f, f);
    Object localObject3 = (ImageView)paramView.findViewById(1912930327);
    localObject1 = (TextView)paramView.findViewById(1912930365);
    TextView localTextView = (TextView)paramView.findViewById(1912930362);
    if (!TextUtils.isEmpty(paramFeedBannerTabItem.jdField_a_of_type_JavaLangString)) {
      ((TextView)localObject1).setText(paramFeedBannerTabItem.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(paramFeedBannerTabItem.jdField_b_of_type_JavaLangString)) {
      localTextView.setText(paramFeedBannerTabItem.jdField_b_of_type_JavaLangString);
    }
    Object localObject2 = (FeedBannerItemGradientLinearLayout)paramView.findViewById(1912930322);
    if (paramInt2 == 1) {
      i = 24;
    } else if (paramInt2 == 2) {
      i = 22;
    } else {
      i = 40;
    }
    ((FeedBannerItemGradientLinearLayout)localObject2).a(ViewUtils.a(i), paramFeedBannerTabItem.jdField_b_of_type_Int, paramFeedBannerTabItem.jdField_c_of_type_Int);
    localObject2 = (FrameLayout)paramView.findViewById(1912930328);
    if ((this.jdField_a_of_type_Boolean) && (paramFeedBannerTabItem.jdField_a_of_type_Int == 0))
    {
      ((ImageView)localObject3).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = localTextView;
      localObject3 = paramView.getContext().getResources().getDrawable(1912864768);
      ((Drawable)localObject3).setBounds(ViewUtils.a(1.0F), 0, ViewUtils.a(7.0F), ViewUtils.a(6.0F));
      localTextView.setCompoundDrawablePadding(ViewUtils.a(3.0F));
      localTextView.setCompoundDrawables((Drawable)localObject3, null, null, null);
      if (paramInt2 == 2)
      {
        ((ViewGroup.MarginLayoutParams)localTextView.getLayoutParams()).rightMargin = ViewUtils.a(80.0F);
      }
      else if (paramInt2 == 1)
      {
        ((TextView)localObject1).setTextSize(25.0F);
        localTextView.setTextSize(12.0F);
        localTextView.setPadding(0, ViewUtils.a(2.0F), 0, 0);
        paramView.findViewById(1912930305).setVisibility(0);
      }
      a((FrameLayout)localObject2, paramInt2);
      a(paramFeedBannerTabItem);
    }
    else if (paramFeedBannerTabItem.jdField_c_of_type_JavaLangString != null)
    {
      try
      {
        localObject4 = new ColorDrawable(0);
        ColorDrawable localColorDrawable = new ColorDrawable(0);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject4);
        localURLDrawableOptions.mFailedDrawable = localColorDrawable;
        localURLDrawableOptions.mUseApngImage = true;
        localURLDrawableOptions.mMemoryCacheKeySuffix = "useAPNG";
        ((ImageView)localObject3).setImageDrawable(URLDrawable.getDrawable(new URL(paramFeedBannerTabItem.jdField_c_of_type_JavaLangString), localURLDrawableOptions));
      }
      catch (MalformedURLException localMalformedURLException)
      {
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("setImageUrl error ");
          ((StringBuilder)localObject4).append(localMalformedURLException.toString());
          QLog.e("FeedBannerViewHolder", 2, ((StringBuilder)localObject4).toString());
        }
      }
    }
    ImageView localImageView = (ImageView)paramView.findViewById(1912930310);
    Object localObject4 = Drawable.createFromPath(ExpandLimitChatResourceUtil.a(paramInt2));
    if (localObject4 != null) {
      localImageView.setImageDrawable((Drawable)localObject4);
    }
    paramView.setOnTouchListener(new FeedBannerViewHolder.2(this, paramView.findViewById(1912930346), (FrameLayout)localObject2, (TextView)localObject1, localTextView, paramFeedBannerTabItem, paramInt1));
  }
  
  private void a(FrameLayout paramFrameLayout, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetHeadsPanelAnimationView;
    if (localObject != null) {
      ((HeadsPanelAnimationView)localObject).d();
    }
    int j = 3;
    int i;
    if (paramInt == 1) {
      i = 4;
    } else if (paramInt <= 2) {
      i = 2;
    } else {
      i = 3;
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetHeadsPanelAnimationView = new HeadsPanelAnimationView(i);
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetHeadsPanelAnimationView.a() != null)
    {
      localObject = new FrameLayout.LayoutParams(-2, -2);
      if (paramInt == 1)
      {
        ((FrameLayout.LayoutParams)localObject).bottomMargin = ViewUtils.a(20.0F);
        ((FrameLayout.LayoutParams)localObject).topMargin = ViewUtils.a(16.0F);
      }
      else
      {
        if (paramInt <= 2) {
          i = ViewUtils.a(16.0F);
        } else {
          i = ViewUtils.a(22.0F);
        }
        ((FrameLayout.LayoutParams)localObject).bottomMargin = i;
        ((FrameLayout.LayoutParams)localObject).topMargin = i;
      }
      if (paramInt == 1) {
        paramInt = j;
      } else {
        paramInt = 5;
      }
      ((FrameLayout.LayoutParams)localObject).gravity = paramInt;
      paramFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetHeadsPanelAnimationView.a(), (ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void a(FeedBannerTabItem paramFeedBannerTabItem, int paramInt)
  {
    a(paramFeedBannerTabItem, paramInt, "0X800A9B1");
    HashMap localHashMap = new HashMap();
    if (paramInt == 0) {
      localHashMap.put("banner_appid", "1");
    } else {
      localHashMap.put("banner_appid", String.valueOf(paramFeedBannerTabItem.jdField_a_of_type_Long));
    }
    IExpandReportUtils localIExpandReportUtils = (IExpandReportUtils)QRoute.api(IExpandReportUtils.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("click#");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("#banner");
    localIExpandReportUtils.onUserActionToTunnel(localStringBuilder.toString(), true, -1L, -1L, localHashMap, true, true);
    a(this.itemView.getContext(), paramFeedBannerTabItem);
  }
  
  private void a(FeedBannerTabItem paramFeedBannerTabItem, int paramInt, String paramString)
  {
    if ((paramFeedBannerTabItem != null) && (paramFeedBannerTabItem.jdField_a_of_type_Int != 0))
    {
      String str1 = paramFeedBannerTabItem.jdField_a_of_type_JavaLangString;
      String str2 = paramFeedBannerTabItem.jdField_b_of_type_JavaLangString;
      long l = paramFeedBannerTabItem.jdField_a_of_type_Long;
      paramFeedBannerTabItem = new StringBuilder();
      paramFeedBannerTabItem.append(paramInt);
      paramFeedBannerTabItem.append("");
      paramFeedBannerTabItem = paramFeedBannerTabItem.toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l);
      localStringBuilder.append(";");
      localStringBuilder.append(str1);
      ReportController.b(null, "dc00898", "", "", "qq_kuolie", paramString, 0, 0, paramFeedBannerTabItem, "", localStringBuilder.toString(), str2);
    }
  }
  
  public void a()
  {
    HeadsPanelAnimationView localHeadsPanelAnimationView = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetHeadsPanelAnimationView;
    if (localHeadsPanelAnimationView != null) {
      localHeadsPanelAnimationView.d();
    }
  }
  
  public void a(StrangerInfo paramStrangerInfo, int paramInt)
  {
    if (((paramStrangerInfo instanceof FeedBannerInfo)) && ((this.itemView instanceof TabLayout)))
    {
      Object localObject = (FeedBannerInfo)paramStrangerInfo;
      paramStrangerInfo = (TabLayout)this.itemView;
      paramStrangerInfo.setPadding(paramStrangerInfo.getPaddingLeft(), paramInt, paramStrangerInfo.getPaddingRight(), paramStrangerInfo.getPaddingBottom());
      localObject = ((FeedBannerInfo)localObject).jdField_a_of_type_JavaUtilArrayList;
      ViewGroup.LayoutParams localLayoutParams = paramStrangerInfo.getLayoutParams();
      int i = ((ArrayList)localObject).size();
      if (i == 1) {
        i = 122;
      } else if (i == 2) {
        i = 108;
      } else {
        i = 168;
      }
      i = ViewUtils.a(i);
      if (localLayoutParams != null) {
        localLayoutParams.height = (paramInt + i);
      }
      paramStrangerInfo.a().setMinimumHeight(i);
      paramStrangerInfo.a(new FeedBannerViewHolder.1(this, (ArrayList)localObject, ViewUtils.a(120.0F), ViewUtils.a(4.0F)));
    }
  }
  
  public void a(FeedBannerTabItem paramFeedBannerTabItem)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (paramFeedBannerTabItem.jdField_b_of_type_JavaLangString != null)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramFeedBannerTabItem.jdField_b_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetHeadsPanelAnimationView != null) && (paramFeedBannerTabItem.jdField_a_of_type_JavaUtilArrayList != null)) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetHeadsPanelAnimationView.a(paramFeedBannerTabItem.jdField_a_of_type_JavaUtilArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.feed.FeedBannerViewHolder
 * JD-Core Version:    0.7.0.1
 */