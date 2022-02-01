package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.KandianUGStatisticUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.UGDownloadInfo;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.util.List;
import javax.annotation.Nullable;
import mqq.os.MqqHandler;

public class VideoFeedsUGView
  extends AbsVideoFeedsUGView
  implements DownloadListener
{
  public static VideoFeedsUGDownloadListener a;
  int jdField_a_of_type_Int = 0;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  Path jdField_a_of_type_AndroidGraphicsPath;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  UGDownloadInfo jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo;
  String jdField_a_of_type_JavaLangString;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString = "";
  ImageView c;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsUGDownloadListener = new VideoFeedsUGDownloadListener();
  }
  
  public VideoFeedsUGView(@NonNull Context paramContext)
  {
    super(paramContext, null, 0);
    a(paramContext);
    setOnClickListener(this);
  }
  
  public VideoFeedsUGView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    a(paramContext);
    setOnClickListener(this);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setId(1);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.b(24.0F, getResources()), AIOUtils.b(24.0F, getResources()));
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(9);
    localLayoutParams.leftMargin = AIOUtils.b(8.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_b_of_type_AndroidWidgetImageView.setId(2);
    localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.b(95.0F, getResources()), AIOUtils.b(14.0F, getResources()));
    localLayoutParams.addRule(1, 1);
    localLayoutParams.addRule(15);
    localLayoutParams.leftMargin = AIOUtils.b(4.0F, getResources());
    this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(3);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(11.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(1, 1);
    localLayoutParams.addRule(10);
    localLayoutParams.topMargin = AIOUtils.b(6.0F, getResources());
    localLayoutParams.leftMargin = AIOUtils.b(4.0F, getResources());
    localLayoutParams.bottomMargin = 1;
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.c = new ImageView(paramContext);
    this.c.setPadding(AIOUtils.b(4.0F, getResources()), AIOUtils.b(4.0F, getResources()), AIOUtils.b(4.0F, getResources()), AIOUtils.b(4.0F, getResources()));
    this.c.setOnClickListener(new VideoFeedsUGView.1(this));
    paramContext = new RelativeLayout.LayoutParams(AIOUtils.b(16.0F, getResources()), AIOUtils.b(16.0F, getResources()));
    paramContext.addRule(11);
    paramContext.addRule(15);
    paramContext.rightMargin = AIOUtils.b(4.0F, getResources());
    this.c.setLayoutParams(paramContext);
    addView(this.c, paramContext);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo == null)
    {
      setVisibility(8);
      return;
    }
    if (!DateUtils.isToday(SharedPreUtils.b("ug_prefix_ug_1get3_ug_show_time")))
    {
      SharedPreUtils.a("ug_prefix_ug_1get3_ug_show_time", System.currentTimeMillis());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ug_prefix_ug_1get3_ug_click_count");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.n);
      SharedPreUtils.a(((StringBuilder)localObject1).toString(), 0);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ug_prefix_ug_1get3_ug_exp_count");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.n);
      SharedPreUtils.a(((StringBuilder)localObject1).toString(), 0);
    }
    if (DateUtils.isToday(SharedPreUtils.b("ug_prefix_ug_1get3_ug_close_time")))
    {
      setVisibility(8);
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ug_prefix_ug_1get3_ug_click_count");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.n);
    if (SharedPreUtils.a(((StringBuilder)localObject1).toString()) >= this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_a_of_type_Int)
    {
      setVisibility(8);
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ug_prefix_ug_1get3_ug_exp_count");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.n);
    if (SharedPreUtils.a(((StringBuilder)localObject1).toString()) >= this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_b_of_type_Int)
    {
      setVisibility(8);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_c_of_type_Int == 1) && (PackageUtil.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.j)))
    {
      setVisibility(8);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_c_of_type_Int == 2) && (!PackageUtil.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.j)))
    {
      setVisibility(8);
      return;
    }
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ug_prefix_ug_1get3_ug_exp_count");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.n);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ug_prefix_ug_1get3_ug_exp_count");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.n);
      SharedPreUtils.a((String)localObject1, SharedPreUtils.a(((StringBuilder)localObject2).toString()) + 1);
      KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.i, "2", this.jdField_a_of_type_JavaLangString));
    }
    setVisibility(0);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_c_of_type_Int == 2)
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else
    {
      localObject1 = DownloadManagerV2.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.f);
      if (localObject1 == null)
      {
        this.jdField_a_of_type_Int = 0;
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        if (((DownloadInfo)localObject1).a() == 4)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.m);
        }
        else if ((((DownloadInfo)localObject1).a() != 20) && (((DownloadInfo)localObject1).a() != 1) && (((DownloadInfo)localObject1).a() != 2))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.l);
        }
        else
        {
          localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.k);
          localStringBuilder.append(((DownloadInfo)localObject1).f);
          localStringBuilder.append("%");
          ((TextView)localObject2).setText(localStringBuilder.toString());
        }
        this.jdField_a_of_type_Int = ((DownloadInfo)localObject1).f;
      }
    }
    b();
    invalidate();
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo;
    if (localObject == null) {
      return;
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(((UGDownloadInfo)localObject).e));
      label24:
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.b(153.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.b(28.0F, getResources());
      setBackgroundDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject));
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.b(24.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.b(24.0F, getResources());
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.b(95.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.b(14.0F, getResources());
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.b(8.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.b(8.0F, getResources());
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.d, (URLDrawable.URLDrawableOptions)localObject);
      this.c.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo = null;
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.8(this, paramString2));
  }
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo;
    if (paramView == null) {
      return;
    }
    Object localObject;
    if (paramView.jdField_c_of_type_Int == 2)
    {
      paramView = new Intent();
      paramView.setAction("android.intent.action.VIEW");
      paramView.putExtra("big_brother_source_key", "biz_src_kandian_videos");
      paramView.setData(Uri.parse(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.g));
      if (VideoFeedsHelper.a(getContext(), paramView)) {
        getContext().startActivity(paramView);
      }
      KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.i, "7", this.jdField_a_of_type_JavaLangString));
      paramView = new StringBuilder();
      paramView.append("ug_prefix_ug_1get3_ug_click_count");
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.n);
      paramView = paramView.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ug_prefix_ug_1get3_ug_click_count");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.n);
      SharedPreUtils.a(paramView, SharedPreUtils.a(((StringBuilder)localObject).toString()) + 1);
      return;
    }
    paramView = new VideoFeedsUGDownloadListener.UGClickData();
    paramView.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.f;
    paramView.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.i;
    paramView.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsUGDownloadListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.j, paramView);
    DownloadManagerV2.a().a(jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsUGDownloadListener);
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.h;
    try
    {
      ((ClipboardManager)getContext().getSystemService("clipboard")).setText(paramView);
      label258:
      KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.i, "3", this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      paramView = DownloadManagerV2.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.f);
      if (paramView == null)
      {
        paramView = new DownloadInfo();
        paramView.d = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.f;
        paramView.m = "biz_src_kandian_videos";
        paramView.e = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.j;
        DownloadManagerV2.a().b(paramView);
        paramView = new StringBuilder();
        paramView.append("ug_prefix_ug_1get3_ug_click_count");
        paramView.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.n);
        paramView = paramView.toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ug_prefix_ug_1get3_ug_click_count");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.n);
        SharedPreUtils.a(paramView, SharedPreUtils.a(((StringBuilder)localObject).toString()) + 1);
        KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.i, "9", this.jdField_a_of_type_JavaLangString));
        KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.i, "10", this.jdField_a_of_type_JavaLangString));
        paramView = this.jdField_a_of_type_AndroidWidgetTextView;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.k);
        ((StringBuilder)localObject).append("0%");
        paramView.setText(((StringBuilder)localObject).toString());
        this.jdField_a_of_type_Int = 0;
        return;
      }
      if (paramView.a() == 4)
      {
        KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.i, "102", this.jdField_a_of_type_JavaLangString));
        KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.i, "20", this.jdField_a_of_type_JavaLangString));
        if (!DownloadManagerV2.a().a(paramView)) {
          DownloadManagerV2.a().b(paramView);
        }
        paramView = new StringBuilder();
        paramView.append("ug_prefix_ug_1get3_ug_click_count");
        paramView.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.n);
        paramView = paramView.toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ug_prefix_ug_1get3_ug_click_count");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.n);
        SharedPreUtils.a(paramView, SharedPreUtils.a(((StringBuilder)localObject).toString()) + 1);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.m);
        return;
      }
      if ((paramView.a() != 30) && (paramView.a() != 10) && (paramView.a() != 20) && (paramView.a() != 1) && (paramView.a() != 2))
      {
        DownloadManagerV2.a().b(paramView);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ug_prefix_ug_1get3_ug_click_count");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.n);
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ug_prefix_ug_1get3_ug_click_count");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.n);
        SharedPreUtils.a((String)localObject, SharedPreUtils.a(localStringBuilder.toString()) + 1);
        KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.i, "10", this.jdField_a_of_type_JavaLangString));
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.k);
        localStringBuilder.append(paramView.f);
        localStringBuilder.append("%");
        ((TextView)localObject).setText(localStringBuilder.toString());
        this.jdField_a_of_type_Int = paramView.f;
        return;
      }
      KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.i, "22", this.jdField_a_of_type_JavaLangString));
      DownloadManagerV2.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.f);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.l);
      return;
    }
    catch (Throwable paramView)
    {
      break label258;
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.5(this, paramDownloadInfo));
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.7(this, paramDownloadInfo));
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.4(this, paramDownloadInfo));
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.2(this, paramDownloadInfo));
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.6(this, paramList));
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.3(this, paramDownloadInfo));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo != null) && (this.jdField_a_of_type_Int != 0))
    {
      paramCanvas.save();
      if (this.jdField_a_of_type_AndroidGraphicsPath == null)
      {
        this.jdField_a_of_type_AndroidGraphicsPath = new Path();
        this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), AIOUtils.b(14.0F, getResources()), AIOUtils.b(14.0F, getResources()), Path.Direction.CW);
      }
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath, Region.Op.INTERSECT);
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, getWidth() * this.jdField_a_of_type_Int / 100.0F, getHeight());
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1291845631);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.restore();
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void setActive(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      DownloadManagerV2.a().a(this);
      a(true);
      return;
    }
    DownloadManagerV2.a().b(this);
  }
  
  public void setInfo(UGDownloadInfo paramUGDownloadInfo, String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo = paramUGDownloadInfo;
    a(false);
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.9(this, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsUGView
 * JD-Core Version:    0.7.0.1
 */