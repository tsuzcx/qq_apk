package com.tencent.mobileqq.kandian.biz.reddot;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.GifHelper;
import com.tencent.biz.pubaccount.util.RIJBlackWhiteModeHelper;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.image.ApngImage;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KanDianUrlRoundCornerImageView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.diandian.RecommendFeedsDiandianEntranceManager;
import com.tencent.mobileqq.kandian.biz.skin.BaseSkinRes;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager.OnSkinChangedListener;
import com.tencent.mobileqq.kandian.glue.utils.RIJSmartCropUtils;
import com.tencent.mobileqq.kandian.repo.diandian.EntranceIconInfo;
import com.tencent.mobileqq.kandian.repo.diandian.IEntranceButtonDataSource;
import com.tencent.mobileqq.kandian.repo.diandian.RIJColumnDataSource;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;

public class ColorBandVideoEntranceButton
  extends FrameLayout
  implements View.OnClickListener, URLDrawable.URLDrawableListener2, RedDotView<IEntranceButtonDataSource>, ReadInJoySkinManager.OnSkinChangedListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  Animator jdField_a_of_type_AndroidAnimationAnimator;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  protected Drawable a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  protected ImageView a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ApngDrawable.OnPlayRepeatListener jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener;
  protected URLDrawable a;
  private URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener = new ColorBandVideoEntranceButton.1(this);
  protected URLImageView a;
  protected KanDianUrlRoundCornerImageView a;
  private IEntranceButtonDataSource jdField_a_of_type_ComTencentMobileqqKandianRepoDiandianIEntranceButtonDataSource;
  ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ColorBandVideoEntranceButton.10(this);
  Runnable jdField_a_of_type_JavaLangRunnable = new ColorBandVideoEntranceButton.12(this);
  private Function1<Canvas, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1 = new ColorBandVideoEntranceButton.14(this);
  public boolean a;
  private int jdField_b_of_type_Int;
  Animator jdField_b_of_type_AndroidAnimationAnimator;
  private AnimatorSet jdField_b_of_type_AndroidAnimationAnimatorSet;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  protected ImageView b;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private URLDrawable jdField_b_of_type_ComTencentImageURLDrawable;
  private KanDianUrlRoundCornerImageView jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView;
  Runnable jdField_b_of_type_JavaLangRunnable = new ColorBandVideoEntranceButton.13(this);
  private Function1<Canvas, Unit> jdField_b_of_type_KotlinJvmFunctionsFunction1 = new ColorBandVideoEntranceButton.15(this);
  private boolean jdField_b_of_type_Boolean;
  Animator jdField_c_of_type_AndroidAnimationAnimator;
  private AnimatorSet jdField_c_of_type_AndroidAnimationAnimatorSet;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  Animator jdField_d_of_type_AndroidAnimationAnimator;
  private AnimatorSet jdField_d_of_type_AndroidAnimationAnimatorSet;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean = false;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private boolean jdField_e_of_type_Boolean = false;
  private ImageView f;
  
  public ColorBandVideoEntranceButton(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    j();
  }
  
  public ColorBandVideoEntranceButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    j();
  }
  
  private Drawable a()
  {
    int i;
    if (!this.jdField_a_of_type_Boolean) {
      i = RecommendFeedsDiandianEntranceManager.getDefaultFeedsIconSrcId();
    } else {
      i = 2130842890;
    }
    return getResources().getDrawable(i);
  }
  
  private Drawable a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a();
    } else if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a();
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  private String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return "";
        }
        return HardCodeUtil.a(2131718313);
      }
      return HardCodeUtil.a(2131718315);
    }
    return HardCodeUtil.a(2131718314);
  }
  
  private String a(EntranceIconInfo paramEntranceIconInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramEntranceIconInfo.d));
    localStringBuilder.append(" ");
    localStringBuilder.append(a(paramEntranceIconInfo.jdField_b_of_type_Int));
    return localStringBuilder.toString();
  }
  
  private String a(String paramString)
  {
    int i = 0;
    float f1 = 0.0F;
    while (i < paramString.length())
    {
      float f2;
      if (StringUtil.c(paramString.charAt(i))) {
        f2 = 2.0F;
      } else {
        f2 = 1.0F;
      }
      f1 += f2;
      if (f1 > 16.0F)
      {
        j = 1;
        break label62;
      }
      i += 1;
    }
    int j = 0;
    label62:
    Object localObject = paramString;
    if (j != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.substring(0, i));
      ((StringBuilder)localObject).append("...");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  private void a(View paramView)
  {
    if (a())
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      c();
      this.jdField_b_of_type_Boolean = false;
      this.jdField_b_of_type_ComTencentImageURLDrawable = null;
      View.OnClickListener localOnClickListener = this.jdField_a_of_type_AndroidViewView$OnClickListener;
      if (localOnClickListener != null) {
        localOnClickListener.onClick(paramView);
      }
    }
  }
  
  private void a(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    paramView.clearAnimation();
    paramView.setScaleX(paramFloat);
    paramView.setScaleX(paramFloat);
  }
  
  private void a(ImageView paramImageView)
  {
    paramImageView = paramImageView.getLayoutParams();
    this.jdField_a_of_type_Int = paramImageView.width;
    this.jdField_b_of_type_Int = paramImageView.height;
    if (QLog.isColorLevel())
    {
      paramImageView = new StringBuilder();
      paramImageView.append("initCoverImageSize, width: ");
      paramImageView.append(this.jdField_a_of_type_Int);
      paramImageView.append(", height: ");
      paramImageView.append(this.jdField_b_of_type_Int);
      QLog.d("ColorBandVideoEntranceButton", 2, paramImageView.toString());
    }
  }
  
  private void a(ApngDrawable paramApngDrawable)
  {
    if (this.jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener == null) {
      this.jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener = new ColorBandVideoEntranceButton.11(this);
    }
    paramApngDrawable.setOnPlayRepeatListener(this.jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener);
    paramApngDrawable.repaly();
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && ((paramURLDrawable.getCurrDrawable() instanceof ApngDrawable))) {
      postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1800L);
    }
  }
  
  private void a(EntranceIconInfo paramEntranceIconInfo)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(a(paramEntranceIconInfo));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      n();
    }
  }
  
  private void a(RIJColumnDataSource paramRIJColumnDataSource)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramRIJColumnDataSource != null)
    {
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramRIJColumnDataSource.a))) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramRIJColumnDataSource.a);
      }
      if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramRIJColumnDataSource.jdField_b_of_type_JavaLangString))) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramRIJColumnDataSource.jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView == null) {
      return;
    }
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleX", new float[] { 0.2F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleY", new float[] { 0.2F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView, "scaleX", new float[] { 0.2F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView, "scaleY", new float[] { 0.2F, 1.0F }) });
    localAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimatorSet.setDuration(400L);
    if (!TextUtils.isEmpty(paramString)) {
      localAnimatorSet.addListener(new ColorBandVideoEntranceButton.6(this, paramString));
    }
    localAnimatorSet.start();
  }
  
  private void a(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.containsKey("target")) && (paramMap.containsKey("channelid")))
    {
      String str = (String)paramMap.get("target");
      paramMap = (String)paramMap.get("channelid");
      if (("2".equals(str)) && (String.valueOf(70).equals(paramMap))) {
        RIJSPUtils.a("key_sp_entrance_follow", Boolean.valueOf(true));
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    b(paramBoolean);
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    int i;
    if (paramBoolean) {
      i = 8;
    } else {
      i = 0;
    }
    ((ImageView)localObject).setVisibility(i);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    if (paramBoolean)
    {
      ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      t();
      a(this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView);
      this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView.setCorner(this.jdField_a_of_type_Int / 2);
    }
    else
    {
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView.setCorner(this.jdField_a_of_type_Int / 2);
      ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    }
    a(true);
    a(this.jdField_a_of_type_Boolean, false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showColumnDiandian! showColumnDiandian=");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("ColorBandVideoEntranceButton", 1, ((StringBuilder)localObject).toString());
  }
  
  private void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Int;
    localURLDrawableOptions.mRequestHeight = this.jdField_b_of_type_Int;
    if (paramBoolean1)
    {
      localURLDrawableOptions.mUseApngImage = true;
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_loop", 1);
      localURLDrawableOptions.mExtraInfo = localBundle;
    }
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    if (paramBoolean2)
    {
      if (paramString.getStatus() == 1)
      {
        onLoadSuccessed(paramString);
        return;
      }
      paramString.setURLDrawableListener(this);
      paramString.startDownload();
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (paramBoolean1) {
      localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    } else if (paramBoolean2) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView;
    } else {
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    }
    try
    {
      localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
      int i = ((FrameLayout.LayoutParams)localObject).bottomMargin;
      int k = ((FrameLayout.LayoutParams)localObject).rightMargin;
      int j = ((FrameLayout.LayoutParams)localObject).width;
      localObject = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      k -= DisplayUtil.a(getContext(), 12.0F);
      i = DisplayUtil.a(getContext(), 30.0F) - ((FrameLayout.LayoutParams)localObject).width + j + i;
      ((FrameLayout.LayoutParams)localObject).bottomMargin = i;
      ((FrameLayout.LayoutParams)localObject).rightMargin = k;
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (FrameLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).bottomMargin = i;
      ((FrameLayout.LayoutParams)localObject).rightMargin = k;
      this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateSkinPosition error!  msg=");
      localStringBuilder.append(localException);
      QLog.d("ColorBandVideoEntranceButton", 1, localStringBuilder.toString());
    }
  }
  
  private boolean a()
  {
    return System.currentTimeMillis() - this.jdField_a_of_type_Long > 1000L;
  }
  
  private boolean a(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    return paramIEntranceButtonDataSource instanceof EntranceIconInfo;
  }
  
  private void b(URLDrawable paramURLDrawable)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      QLog.d("ColorBandVideoEntranceButton", 1, "has no red dot");
      return;
    }
    QLog.d("ColorBandVideoEntranceButton", 1, "isHasRedDot updateAnimation");
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    if ((paramURLDrawable != null) && ((paramURLDrawable.getCurrDrawable() instanceof ApngDrawable)) && (((ApngDrawable)paramURLDrawable.getCurrDrawable()).getImage() != null))
    {
      Bitmap localBitmap = ((ApngDrawable)paramURLDrawable.getCurrDrawable()).getImage().getCurrentFrame();
      if (localBitmap != null) {
        localBitmap.eraseColor(0);
      }
    }
    if (paramURLDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramURLDrawable);
      if (paramURLDrawable.getStatus() == 1) {
        a(paramURLDrawable);
      }
    }
  }
  
  private void b(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    if ((paramIEntranceButtonDataSource instanceof EntranceIconInfo)) {
      a(URLUtil.a(((EntranceIconInfo)paramIEntranceButtonDataSource).c));
    }
  }
  
  private void b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("loadUpdateAnimation: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("ColorBandVideoEntranceButton", 1, ((StringBuilder)localObject).toString());
    localObject = new ApngOptions();
    ((ApngOptions)localObject).a(new ColorDrawable(7));
    ((ApngOptions)localObject).b(this.jdField_a_of_type_Int);
    ((ApngOptions)localObject).c(this.jdField_b_of_type_Int);
    ((ApngOptions)localObject).a(1);
    b(((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(paramString, (ApngOptions)localObject));
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(a());
    ImageView localImageView = this.jdField_e_of_type_AndroidWidgetImageView;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 4;
    }
    localImageView.setVisibility(i);
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0.0F);
    a(this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView, 0.0F);
    a(this.f, 0.0F);
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(false);
  }
  
  private void c(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = paramURLDrawable.getCurrDrawable();
    if ((paramURLDrawable instanceof ApngDrawable))
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoDiandianIEntranceButtonDataSource instanceof RIJColumnDataSource)) {
        this.jdField_d_of_type_Boolean = true;
      } else {
        this.jdField_e_of_type_Boolean = true;
      }
    }
    else
    {
      this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView.setImageDrawable(paramURLDrawable);
      this.jdField_c_of_type_Boolean = true;
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean))
    {
      paramURLDrawable = this.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
      if ((paramURLDrawable instanceof ApngDrawable))
      {
        a((ApngDrawable)paramURLDrawable);
        this.jdField_c_of_type_Boolean = false;
        this.jdField_d_of_type_Boolean = false;
      }
    }
  }
  
  private void c(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    post(new ColorBandVideoEntranceButton.5(this, paramIEntranceButtonDataSource));
  }
  
  private void c(String paramString)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_b_of_type_Int;
    }
    try
    {
      URLDrawable.getDrawable(new URL(paramString), (URLDrawable.URLDrawableOptions)localObject).startDownload();
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      label43:
      break label43;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("url format error: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ColorBandVideoEntranceButton", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void d(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    if (paramIEntranceButtonDataSource == null) {
      return;
    }
    if (paramIEntranceButtonDataSource.b())
    {
      e(paramIEntranceButtonDataSource);
      return;
    }
    c(paramIEntranceButtonDataSource.b());
  }
  
  private void e(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    if (paramIEntranceButtonDataSource == null) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if ((paramIEntranceButtonDataSource instanceof RIJColumnDataSource))
      {
        a((RIJColumnDataSource)paramIEntranceButtonDataSource);
        u();
        a(true, RIJColumnDataSource.g, true);
        a(false, paramIEntranceButtonDataSource.b(), true);
      }
    }
    else
    {
      Object localObject;
      if (paramIEntranceButtonDataSource.a())
      {
        if (!TextUtils.isEmpty(paramIEntranceButtonDataSource.a()))
        {
          try
          {
            URLDrawable.URLDrawableOptions localURLDrawableOptions1 = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions1.mLoadingDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
            localURLDrawableOptions1.mRequestWidth = this.jdField_a_of_type_Int;
            localURLDrawableOptions1.mRequestHeight = this.jdField_b_of_type_Int;
            localURLDrawableOptions1.mPlayGifImage = true;
            this.jdField_b_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramIEntranceButtonDataSource.a(), localURLDrawableOptions1);
            this.jdField_b_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
            this.jdField_b_of_type_ComTencentImageURLDrawable.startDownload();
          }
          catch (Exception localException1)
          {
            if (!QLog.isColorLevel()) {
              break label199;
            }
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("url error: ");
          ((StringBuilder)localObject).append(localException1.getMessage());
          QLog.d("ColorBandVideoEntranceButton", 2, ((StringBuilder)localObject).toString());
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("ColorBandVideoEntranceButton", 2, "url is null");
        }
        label199:
        c(paramIEntranceButtonDataSource.b());
        return;
      }
      String str = paramIEntranceButtonDataSource.b();
      if (!TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("rawUrl: ");
          ((StringBuilder)localObject).append(str);
          QLog.d("ColorBandVideoEntranceButton", 2, ((StringBuilder)localObject).toString());
        }
        str = RIJSmartCropUtils.a(str, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("showCover(): startDownload smartCutUrl: ");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append("，mWidth:");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject).append(", mHeight:");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
          QLog.d("ColorBandVideoEntranceButton", 1, ((StringBuilder)localObject).toString());
        }
        try
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Int;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions)localObject);
          if ((this.jdField_b_of_type_ComTencentImageURLDrawable.getStatus() == 1) && ((this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof RegionDrawable)))
          {
            onLoadSuccessed(this.jdField_b_of_type_ComTencentImageURLDrawable);
          }
          else
          {
            this.jdField_b_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
            this.jdField_b_of_type_ComTencentImageURLDrawable.startDownload();
          }
          paramIEntranceButtonDataSource.a(str);
        }
        catch (Exception localException2)
        {
          if (!QLog.isColorLevel()) {
            break label504;
          }
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("url error: ");
        ((StringBuilder)localObject).append(localException2.getMessage());
        QLog.d("ColorBandVideoEntranceButton", 2, ((StringBuilder)localObject).toString());
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ColorBandVideoEntranceButton", 2, "url is null");
      }
      label504:
      if ((paramIEntranceButtonDataSource.c()) && (!TextUtils.isEmpty(paramIEntranceButtonDataSource.c())))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions2 = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions2.mLoadingDrawable = a(false);
        localURLDrawableOptions2.mRequestWidth = this.jdField_a_of_type_Int;
        localURLDrawableOptions2.mRequestHeight = this.jdField_b_of_type_Int;
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramIEntranceButtonDataSource.c(), localURLDrawableOptions2);
        this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
      }
    }
  }
  
  private void j()
  {
    inflate(getContext(), 2131560109, this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131380830);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376092));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369480));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)findViewById(2131376094));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView.setOnClickListener(this);
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView.setCorner(this.jdField_a_of_type_Int / 2);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380868));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380867));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840491);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131376093));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371883));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131371882));
    l();
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364871));
    this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)findViewById(2131364865));
    this.f = ((ImageView)findViewById(2131376320));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364875));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364874));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364879));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364878));
  }
  
  private void k()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView != null))
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
        return;
      }
      ((View)localObject).setScaleX(0.2F);
      this.jdField_a_of_type_AndroidViewView.setScaleY(0.2F);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView.setScaleX(0.2F);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView.setScaleY(0.2F);
      localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "translationX", new float[] { 0.0F, AIOUtils.b(21.0F, getResources()) });
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "translationY", new float[] { 0.0F, AIOUtils.b(21.0F, getResources()) });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleX", new float[] { 1.0F, 0.38F });
      ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleY", new float[] { 1.0F, 0.38F });
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { localObject, localObjectAnimator1, localObjectAnimator2, localObjectAnimator3 });
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.setDuration(333L);
      this.jdField_b_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_b_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleX", new float[] { 0.2F, 1.1F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleY", new float[] { 0.2F, 1.1F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView, "scaleX", new float[] { 0.2F, 1.1F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView, "scaleY", new float[] { 0.2F, 1.1F, 1.0F }) });
      this.jdField_b_of_type_AndroidAnimationAnimatorSet.setDuration(400L);
      ((ObjectAnimator)localObject).addUpdateListener(new ColorBandVideoEntranceButton.3(this));
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
    }
  }
  
  private void l()
  {
    Object localObject = (ReadInJoySkinManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    BaseSkinRes localBaseSkinRes = ((ReadInJoySkinManager)localObject).a(3);
    if (localBaseSkinRes != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(localBaseSkinRes.a());
    }
    localObject = ((ReadInJoySkinManager)localObject).a(2);
    if (localObject != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(((BaseSkinRes)localObject).a());
    }
  }
  
  private void m()
  {
    p();
    a();
  }
  
  private void n()
  {
    AnimatorSet localAnimatorSet = this.jdField_c_of_type_AndroidAnimationAnimatorSet;
    if ((localAnimatorSet != null) && (localAnimatorSet.isStarted())) {
      this.jdField_c_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    this.jdField_c_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_c_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "scaleX", new float[] { 0.5F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "scaleY", new float[] { 0.5F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "translationX", new float[] { 2.0F, 0.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "translationY", new float[] { 40.0F, 20.0F, 0.0F }) });
    this.jdField_c_of_type_AndroidAnimationAnimatorSet.setDuration(300L);
    this.jdField_c_of_type_AndroidAnimationAnimatorSet.addListener(new ColorBandVideoEntranceButton.7(this));
    this.jdField_c_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  private void o()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    ((LinearLayout)localObject).setPivotX(((LinearLayout)localObject).getWidth());
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    ((LinearLayout)localObject).setPivotY(((LinearLayout)localObject).getHeight());
    localObject = this.jdField_d_of_type_AndroidAnimationAnimatorSet;
    if ((localObject != null) && (((AnimatorSet)localObject).isStarted())) {
      this.jdField_d_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    this.jdField_d_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_d_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "scaleX", new float[] { 1.0F, 0.5F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "scaleY", new float[] { 1.0F, 0.5F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "translationX", new float[] { 0.0F, 2.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "translationY", new float[] { 0.0F, 20.0F, 40.0F }) });
    this.jdField_d_of_type_AndroidAnimationAnimatorSet.setDuration(300L);
    this.jdField_d_of_type_AndroidAnimationAnimatorSet.addListener(new ColorBandVideoEntranceButton.8(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.postDelayed(new ColorBandVideoEntranceButton.9(this), 2500L);
  }
  
  private void p()
  {
    AnimatorSet localAnimatorSet = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
    if ((localAnimatorSet != null) && (localAnimatorSet.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    localAnimatorSet = this.jdField_b_of_type_AndroidAnimationAnimatorSet;
    if ((localAnimatorSet != null) && (localAnimatorSet.isRunning())) {
      this.jdField_b_of_type_AndroidAnimationAnimatorSet.cancel();
    }
  }
  
  private void q()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!this.jdField_b_of_type_Boolean)
    {
      k();
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    a(null);
  }
  
  private void r()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoDiandianIEntranceButtonDataSource;
    if ((localObject instanceof EntranceIconInfo)) {
      localObject = ((EntranceIconInfo)localObject).jdField_b_of_type_JavaLangString;
    } else {
      localObject = "https://pub.idqqimg.com/pc/misc/files/20200805/6b42a020cbde489889a5c7ea52bdd5ed.png";
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      a((String)localObject);
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    a((String)localObject);
  }
  
  private void s()
  {
    if (ReadInJoyHelper.v())
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        a(this.jdField_a_of_type_Boolean);
        setDataSource(null);
        this.jdField_e_of_type_Boolean = false;
      }
    }
    else if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      a(this.jdField_a_of_type_Boolean);
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimator == null) {
      this.jdField_a_of_type_AndroidAnimationAnimator = AnimatorInflater.loadAnimator(getContext(), 2130903042);
    }
    if (this.jdField_b_of_type_AndroidAnimationAnimator == null) {
      this.jdField_b_of_type_AndroidAnimationAnimator = AnimatorInflater.loadAnimator(getContext(), 2130903043);
    }
    if (this.jdField_c_of_type_AndroidAnimationAnimator == null) {
      this.jdField_c_of_type_AndroidAnimationAnimator = AnimatorInflater.loadAnimator(getContext(), 2130903044);
    }
    if (this.jdField_d_of_type_AndroidAnimationAnimator == null) {
      this.jdField_d_of_type_AndroidAnimationAnimator = AnimatorInflater.loadAnimator(getContext(), 2130903041);
    }
  }
  
  private void u()
  {
    a(this.jdField_e_of_type_AndroidWidgetImageView, 1.0F);
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0.0F);
    a(this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView, 0.0F);
    a(this.f, 0.0F);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView;
  }
  
  public ImageView a()
  {
    return this.jdField_b_of_type_AndroidWidgetImageView;
  }
  
  public IEntranceButtonDataSource a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoDiandianIEntranceButtonDataSource;
  }
  
  public void a()
  {
    d();
    this.jdField_b_of_type_Boolean = false;
    a(this.jdField_a_of_type_Boolean, false);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
  }
  
  public void a(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    if (paramIEntranceButtonDataSource != null) {
      c(paramIEntranceButtonDataSource);
    }
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b()
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if ((localImageView != null) && (!this.jdField_a_of_type_Boolean)) {
      onClick(localImageView);
    }
  }
  
  protected void c()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this, "scaleX", new float[] { 1.0F, 0.5F, 1.0F }), ObjectAnimator.ofFloat(this, "scaleY", new float[] { 1.0F, 0.5F, 1.0F }) });
    int[] arrayOfInt1 = new int[2];
    getLocationOnScreen(arrayOfInt1);
    int[] arrayOfInt2 = new int[2];
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (this.jdField_a_of_type_Boolean) {
      localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    }
    ((View)localObject).getLocationOnScreen(arrayOfInt2);
    setPivotX(arrayOfInt2[0] - arrayOfInt1[0] + this.jdField_a_of_type_Int / 2);
    setPivotY(arrayOfInt2[1] - arrayOfInt1[1] + this.jdField_b_of_type_Int / 2);
    localAnimatorSet.setDuration(600L);
    localAnimatorSet.setInterpolator(new OvershootInterpolator());
    localAnimatorSet.addListener(new ColorBandVideoEntranceButton.4(this));
    localAnimatorSet.start();
  }
  
  protected void d()
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    if (bool)
    {
      b(bool);
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setTranslationX(0.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.setTranslationY(0.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleX(1.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleY(1.0F);
    KanDianUrlRoundCornerImageView localKanDianUrlRoundCornerImageView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView;
    if ((localKanDianUrlRoundCornerImageView != null) && (localKanDianUrlRoundCornerImageView.getVisibility() != 8))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView.setImageDrawable(null);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a(false));
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    RIJBlackWhiteModeHelper.a.a(paramCanvas, true, this.jdField_b_of_type_KotlinJvmFunctionsFunction1);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    RIJBlackWhiteModeHelper.a.a(paramCanvas, true, this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
  }
  
  public void e()
  {
    s();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoDiandianIEntranceButtonDataSource == null)
    {
      p();
      d();
      if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
        a(true, RIJColumnDataSource.h, true);
      }
    }
  }
  
  public void f()
  {
    IEntranceButtonDataSource localIEntranceButtonDataSource = this.jdField_a_of_type_ComTencentMobileqqKandianRepoDiandianIEntranceButtonDataSource;
    if ((localIEntranceButtonDataSource != null) && (localIEntranceButtonDataSource.a()))
    {
      AbstractGifImage.pauseAll();
      GifHelper.b();
    }
  }
  
  public void g()
  {
    IEntranceButtonDataSource localIEntranceButtonDataSource = this.jdField_a_of_type_ComTencentMobileqqKandianRepoDiandianIEntranceButtonDataSource;
    if ((localIEntranceButtonDataSource != null) && (localIEntranceButtonDataSource.a()))
    {
      AbstractGifImage.resumeAll();
      GifHelper.a();
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoDiandianIEntranceButtonDataSource instanceof RIJColumnDataSource)))
    {
      t();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
      RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      localRelativeLayout.setPivotX(localRelativeLayout.getWidth());
      localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      localRelativeLayout.setPivotY(localRelativeLayout.getHeight() / 2);
      this.jdField_a_of_type_AndroidAnimationAnimator.setTarget(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_AndroidAnimationAnimator.start();
      this.jdField_b_of_type_AndroidAnimationAnimator.setTarget(this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView);
      this.jdField_b_of_type_AndroidAnimationAnimator.start();
      this.jdField_c_of_type_AndroidAnimationAnimator.setTarget(this.f);
      this.jdField_c_of_type_AndroidAnimationAnimator.start();
      postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
    }
  }
  
  public void i()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131364875: 
      paramView.setTag(Integer.valueOf(RIJColumnDataSource.c));
      a(paramView);
      return;
    }
    a(paramView);
  }
  
  public void onFileDownloaded(URLDrawable paramURLDrawable)
  {
    this.jdField_b_of_type_ComTencentImageURLDrawable = null;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ColorBandVideoEntranceButton", 2, "onLoadCanceled");
    }
    this.jdField_b_of_type_ComTencentImageURLDrawable = null;
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("onLoadFialed: ");
      paramURLDrawable.append(paramThrowable.getMessage());
      QLog.e("ColorBandVideoEntranceButton", 2, paramURLDrawable.toString());
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("loadSuccess, start setImage, dataSource=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoDiandianIEntranceButtonDataSource);
    QLog.d("ColorBandVideoEntranceButton", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_Boolean)
    {
      c(paramURLDrawable);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoDiandianIEntranceButtonDataSource == null) {
      return;
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getVisibility() != 0)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView;
    if ((localObject != null) && (((KanDianUrlRoundCornerImageView)localObject).getVisibility() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView.setVisibility(0);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView;
    if (localObject != null)
    {
      ((KanDianUrlRoundCornerImageView)localObject).setImageDrawable(paramURLDrawable);
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoDiandianIEntranceButtonDataSource instanceof EntranceIconInfo)) {
        r();
      } else {
        q();
      }
      a(this.jdField_a_of_type_Boolean, true);
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoDiandianIEntranceButtonDataSource.c()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoDiandianIEntranceButtonDataSource.c()))) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      }
    }
    this.jdField_b_of_type_ComTencentImageURLDrawable = null;
  }
  
  public void setDataSource(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDataSource: ");
    localStringBuilder.append(paramIEntranceButtonDataSource);
    QLog.d("ColorBandVideoEntranceButton", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoDiandianIEntranceButtonDataSource = paramIEntranceButtonDataSource;
    b(paramIEntranceButtonDataSource);
  }
  
  public void setDefaultDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void setDefaultIconBigMode(int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = AIOUtils.b(paramInt1, getContext().getResources());
    localLayoutParams.height = AIOUtils.b(paramInt2, getContext().getResources());
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
  }
  
  public void setNotMsg()
  {
    post(new ColorBandVideoEntranceButton.2(this));
  }
  
  public void setOnVideoCoverClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reddot.ColorBandVideoEntranceButton
 * JD-Core Version:    0.7.0.1
 */