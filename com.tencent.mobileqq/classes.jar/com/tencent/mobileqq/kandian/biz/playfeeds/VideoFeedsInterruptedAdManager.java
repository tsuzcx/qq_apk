package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.view.widget.CircleCountdownView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.InterruptedWeishiAd;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class VideoFeedsInterruptedAdManager
{
  public static final String a = "VideoFeedsInterruptedAdManager";
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private VideoFeedsAdapter jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter;
  private VideoFeedsPlayManager.VideoStatusListener jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager$VideoStatusListener;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
  private ShortVideoItemHolder jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder;
  private VideoInfo.InterruptedWeishiAd jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f = false;
  private boolean g = false;
  
  public VideoFeedsInterruptedAdManager(Activity paramActivity, QQAppInterface paramQQAppInterface, VideoFeedsPlayManager.VideoStatusListener paramVideoStatusListener, VideoFeedsPlayManager paramVideoFeedsPlayManager, VideoFeedsAdapter paramVideoFeedsAdapter, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager$VideoStatusListener = paramVideoStatusListener;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter = paramVideoFeedsAdapter;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.e = false;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void c()
  {
    this.g = true;
    int i = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_b_of_type_Int;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      d();
      e();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
    if (localObject != null) {
      ((VideoFeedsPlayManager)localObject).e();
    }
    localObject = Boolean.valueOf(ReadInJoyHelper.w(ReadInJoyUtils.a()));
    WebViewTitleStyle localWebViewTitleStyle = new WebViewTitleStyle();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("titleStyle", localWebViewTitleStyle);
    localBundle.putBoolean("public_account_finish_animation_out_to_bottom", true);
    localBundle.putBoolean("KEY_SLIDE_RIGHT_BACK_ENABLE", false);
    localWebViewTitleStyle.jdField_b_of_type_Int = -16777216;
    localWebViewTitleStyle.jdField_c_of_type_Int = -1;
    localWebViewTitleStyle.jdField_d_of_type_Int = -16777216;
    localWebViewTitleStyle.e = -16777216;
    localBundle.putParcelable("titleStyle", localWebViewTitleStyle);
    if (((Boolean)localObject).booleanValue()) {
      ViolaAccessHelper.a(this.jdField_a_of_type_AndroidAppActivity, HardCodeUtil.a(2131716001), "https://kandian.qq.com/viola/bundle_weishiLeadTo.js?v_bid=3256", null, new VideoFeedsInterruptedAdManager.1(this, localBundle));
    } else {
      RIJJumpUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_a_of_type_JavaLangString, localBundle);
    }
    if (!((Boolean)localObject).booleanValue()) {
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772011, 0);
    }
    if (this.jdField_a_of_type_Boolean) {
      try
      {
        i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a;
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800933E", "0X800933E", 0, 0, String.valueOf(i), "", "", VideoReporter.a(null, null, ((VideoInfo)localObject).jdField_a_of_type_JavaLangString, ((VideoInfo)localObject).g, null), false);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_b_of_type_AndroidViewView == null) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.itemView instanceof ViewGroup)))
    {
      View localView = View.inflate(this.jdField_a_of_type_AndroidAppActivity, 2131560342, (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.itemView);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_b_of_type_AndroidViewView = localView.findViewById(2131367918);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_c_of_type_AndroidViewView = localView.findViewById(2131367902);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367910));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367919));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367922));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367908));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCircleCountdownView = ((CircleCountdownView)localView.findViewById(2131367920));
    }
  }
  
  private boolean d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (localObject != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder;
      if (localObject == null) {
        return false;
      }
      int i = ((ShortVideoItemHolder)localObject).jdField_c_of_type_Int;
      int j = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_b_of_type_Int;
      if (j != 0)
      {
        if (j != 1) {
          return false;
        }
        bool1 = bool2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.c))
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_b_of_type_JavaLangString))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.d))
            {
              bool1 = bool2;
              if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.e))
              {
                bool1 = bool2;
                if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo != null)
                {
                  bool1 = bool2;
                  if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i)) {
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
        return bool1;
      }
      bool1 = bool3;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_a_of_type_JavaLangString))
      {
        localObject = this.jdField_a_of_type_AndroidUtilSparseBooleanArray;
        bool1 = bool3;
        if (localObject != null)
        {
          bool1 = bool3;
          if (((SparseBooleanArray)localObject).get(i))
          {
            bool1 = bool3;
            if (!this.g) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder;
    if ((localObject != null) && (((ShortVideoItemHolder)localObject).jdField_c_of_type_AndroidWidgetTextView != null))
    {
      Resources localResources = this.jdField_a_of_type_AndroidAppActivity.getResources();
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null)
      {
        if (!PackageUtil.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_b_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.d);
          localObject = localResources.getDrawable(2130843208);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.e);
          localObject = localResources.getDrawable(2130843211);
        }
        int i = AIOUtils.b(12.0F, localResources);
        ((Drawable)localObject).setBounds(0, 0, i, i);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new VideoFeedsInterruptedAdManager.2(this));
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new VideoFeedsInterruptedAdManager.3(this));
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_b_of_type_JavaLangString);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
        localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.c, (URLDrawable.URLDrawableOptions)localObject);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(null);
        localObject = new JSONObject();
      }
    }
    try
    {
      ((JSONObject)localObject).put("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      label271:
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009BF0", "0X8009BF0", 0, 0, "", "", "", VideoReporter.a(null, null, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.g, (JSONObject)localObject), false);
      return;
    }
    catch (Exception localException)
    {
      break label271;
    }
  }
  
  private boolean e()
  {
    Object localObject2;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_b_of_type_JavaLangString = ReadInJoyHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject1 = ReadInJoyHelper.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      boolean bool = ReadInJoyHelper.z(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel())
      {
        localObject2 = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkIsNeedShowInterruptedAd() 后台下发原始配置：");
        localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
        localStringBuilder.append("\n本地副本配置：");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("\n本地副本配置是否为当天：");
        localStringBuilder.append(bool);
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      if ((bool) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
        this.jdField_b_of_type_JavaLangString = ((String)localObject1);
      }
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    }
    try
    {
      localObject2 = new JSONObject(this.jdField_b_of_type_JavaLangString);
      if (!this.jdField_a_of_type_Boolean) {
        break label420;
      }
      localObject1 = "weishi";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        int j;
        continue;
        String str = "default";
      }
    }
    Object localObject1 = ((JSONObject)localObject2).getJSONObject((String)localObject1);
    if (localObject1 == null)
    {
      this.jdField_b_of_type_JavaLangString = null;
      return false;
    }
    i = ((JSONObject)localObject1).getInt("display_count_each_entrance");
    this.jdField_a_of_type_Int = i;
    this.jdField_c_of_type_Int = i;
    this.jdField_b_of_type_Int = ((JSONObject)localObject1).getInt("display_count_each_day");
    break label241;
    this.jdField_b_of_type_JavaLangString = null;
    return false;
    label241:
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkIsNeedShowInterruptedAd() 初始剩余次数 mDisplayCountEachEntrance = ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject2).append(", mDisplayCountEachDay = ");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    i = this.jdField_b_of_type_Int;
    if (i > 0)
    {
      j = this.jdField_a_of_type_Int;
      if (j > 0)
      {
        this.jdField_b_of_type_Int = (i - 1);
        this.jdField_a_of_type_Int = (j - 1);
        if (QLog.isColorLevel())
        {
          localObject1 = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("checkIsNeedShowInterruptedAd() 满足条件，更新后的剩余次数 mDisplayCountEachEntrance = ");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject2).append(", mDisplayCountEachDay = ");
          ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        return true;
      }
    }
    return false;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_b_of_type_Int == 0) && (this.f))
    {
      VideoFeedsPlayManager.VideoStatusListener localVideoStatusListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager$VideoStatusListener;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder;
      if (localObject != null) {
        localObject = ((ShortVideoItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
      } else {
        localObject = null;
      }
      localVideoStatusListener.d((VideoPlayParam)localObject);
    }
    this.g = false;
    this.f = false;
  }
  
  public void a(VideoInfo.InterruptedWeishiAd paramInterruptedWeishiAd)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd = paramInterruptedWeishiAd;
    }
    if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray == null)
    {
      this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
      paramInterruptedWeishiAd = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd;
      if ((paramInterruptedWeishiAd != null) && (paramInterruptedWeishiAd.jdField_a_of_type_ArrayOfInt != null))
      {
        paramInterruptedWeishiAd = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ArrayOfInt;
        int j = paramInterruptedWeishiAd.length;
        int i = 0;
        while (i < j)
        {
          int k = paramInterruptedWeishiAd[i];
          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(k - 1, true);
          i += 1;
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd != null) && (QLog.isColorLevel()))
    {
      paramInterruptedWeishiAd = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setInterruptedAdInfo() interruptedAdInfo = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.toString());
      QLog.d(paramInterruptedWeishiAd, 2, localStringBuilder.toString());
    }
  }
  
  public boolean a()
  {
    return this.g;
  }
  
  public boolean a(int paramInt)
  {
    if (!d()) {
      return false;
    }
    if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_a_of_type_Int >= 0) && (paramInt >= this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_a_of_type_Int) && (e()))
    {
      c();
      this.jdField_c_of_type_Boolean = true;
      return true;
    }
    return false;
  }
  
  public boolean a(ShortVideoItemHolder paramShortVideoItemHolder, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder;
    if (localObject != null) {
      i = ((ShortVideoItemHolder)localObject).jdField_c_of_type_Int;
    } else {
      i = 0;
    }
    if ((paramShortVideoItemHolder.jdField_c_of_type_Int > i) && (paramBoolean)) {
      b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder;
    if ((localObject != null) && (((ShortVideoItemHolder)localObject).jdField_b_of_type_AndroidViewView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder = paramShortVideoItemHolder;
    int i = this.jdField_d_of_type_Int;
    if (i >= 0)
    {
      localObject = this.jdField_a_of_type_AndroidUtilSparseBooleanArray;
      if ((localObject != null) && (((SparseBooleanArray)localObject).indexOfKey(i) >= 0) && ((this.e) || (this.jdField_d_of_type_Boolean) || (this.jdField_c_of_type_Boolean))) {
        this.jdField_a_of_type_AndroidUtilSparseBooleanArray.delete(this.jdField_d_of_type_Int);
      }
    }
    this.jdField_d_of_type_Int = paramShortVideoItemHolder.jdField_c_of_type_Int;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.e = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd != null) && (QLog.isColorLevel()))
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPlayingVideoInfo() itemHolder.position=");
      localStringBuilder.append(paramShortVideoItemHolder.jdField_c_of_type_Int);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return a(0) | false;
  }
  
  public void b()
  {
    String str1;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      str1 = jdField_a_of_type_JavaLangString;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doOnDestory() mIsConfigInited = ");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_Boolean);
      QLog.d(str1, 2, ((StringBuilder)localObject1).toString());
    }
    if ((this.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(this.jdField_b_of_type_JavaLangString);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("display_count_each_entrance", this.jdField_c_of_type_Int);
        ((JSONObject)localObject2).put("display_count_each_day", this.jdField_b_of_type_Int);
        if (!this.jdField_a_of_type_Boolean) {
          break label228;
        }
        str1 = "weishi";
        ((JSONObject)localObject1).put(str1, localObject2);
        ReadInJoyHelper.D(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((JSONObject)localObject1).toString());
        if (QLog.isColorLevel())
        {
          str1 = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("doOnDestory() 本地配置更新成功，mConfigStr = ");
          ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
          QLog.d(str1, 2, ((StringBuilder)localObject2).toString());
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("doOnDestory() 本地配置更新失败，error = ");
          ((StringBuilder)localObject2).append(localException.getMessage());
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
      }
      return;
      label228:
      String str2 = "default";
    }
  }
  
  public boolean b()
  {
    if (!d()) {
      return false;
    }
    if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_a_of_type_Boolean) && (e()))
    {
      c();
      this.jdField_d_of_type_Boolean = true;
      return true;
    }
    return false;
  }
  
  public boolean c()
  {
    if (!d()) {
      return false;
    }
    if ((!this.e) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_b_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_b_of_type_Boolean)) && (e()))
    {
      c();
      this.e = true;
      this.f = this.g;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsInterruptedAdManager
 * JD-Core Version:    0.7.0.1
 */