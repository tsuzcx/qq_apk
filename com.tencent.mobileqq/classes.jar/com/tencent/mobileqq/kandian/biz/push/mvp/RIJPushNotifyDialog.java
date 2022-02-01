package com.tencent.mobileqq.kandian.biz.push.mvp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager.Companion;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyParam;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.util.DisplayUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/push/mvp/RIJPushNotifyDialog;", "", "parent", "Landroid/view/ViewGroup;", "param", "Lcom/tencent/mobileqq/kandian/biz/push/RIJPushNotifyParam;", "(Landroid/view/ViewGroup;Lcom/tencent/mobileqq/kandian/biz/push/RIJPushNotifyParam;)V", "avatarImageView", "Landroid/widget/ImageView;", "buttonLayout", "closeIcon", "closeTextView", "Landroid/widget/TextView;", "contentView", "Landroid/view/View;", "defaultOpenTextView", "handler", "Landroid/os/Handler;", "isSelected", "", "isShowing", "maskView", "observer", "Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;", "openTextView", "rejectTextView", "titleTextView", "dismiss", "", "needAnimation", "initCallback", "initListener", "initUI", "playAnimation", "isShow", "callback", "Lkotlin/Function0;", "show", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJPushNotifyDialog
{
  public static final RIJPushNotifyDialog.Companion a;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final View jdField_a_of_type_AndroidViewView;
  private final ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private final ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private final RIJPushNotifyParam jdField_a_of_type_ComTencentMobileqqKandianBizPushRIJPushNotifyParam;
  private final ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver;
  private boolean jdField_a_of_type_Boolean;
  private final View jdField_b_of_type_AndroidViewView;
  private final ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private final ImageView jdField_b_of_type_AndroidWidgetImageView;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private final TextView c;
  private final TextView d;
  private final TextView e;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizPushMvpRIJPushNotifyDialog$Companion = new RIJPushNotifyDialog.Companion(null);
  }
  
  public RIJPushNotifyDialog(@NotNull ViewGroup paramViewGroup, @NotNull RIJPushNotifyParam paramRIJPushNotifyParam)
  {
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPushRIJPushNotifyParam = paramRIJPushNotifyParam;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_b_of_type_AndroidViewViewGroup.getContext()).inflate(2131562706, this.jdField_b_of_type_AndroidViewViewGroup, false);
    paramViewGroup = this.jdField_b_of_type_AndroidViewView;
    paramRIJPushNotifyParam = null;
    if (paramViewGroup != null) {
      paramViewGroup = paramViewGroup.findViewById(2131373291);
    } else {
      paramViewGroup = null;
    }
    this.jdField_a_of_type_AndroidViewView = paramViewGroup;
    paramViewGroup = this.jdField_a_of_type_AndroidViewView;
    if (paramViewGroup != null) {
      paramViewGroup = (ImageView)paramViewGroup.findViewById(2131373285);
    } else {
      paramViewGroup = null;
    }
    this.jdField_a_of_type_AndroidWidgetImageView = paramViewGroup;
    paramViewGroup = this.jdField_a_of_type_AndroidViewView;
    if (paramViewGroup != null) {
      paramViewGroup = (TextView)paramViewGroup.findViewById(2131373295);
    } else {
      paramViewGroup = null;
    }
    this.jdField_a_of_type_AndroidWidgetTextView = paramViewGroup;
    paramViewGroup = this.jdField_a_of_type_AndroidViewView;
    if (paramViewGroup != null) {
      paramViewGroup = (TextView)paramViewGroup.findViewById(2131373289);
    } else {
      paramViewGroup = null;
    }
    this.jdField_b_of_type_AndroidWidgetTextView = paramViewGroup;
    paramViewGroup = this.jdField_a_of_type_AndroidViewView;
    if (paramViewGroup != null) {
      paramViewGroup = (TextView)paramViewGroup.findViewById(2131365464);
    } else {
      paramViewGroup = null;
    }
    this.c = paramViewGroup;
    paramViewGroup = this.jdField_a_of_type_AndroidViewView;
    if (paramViewGroup != null) {
      paramViewGroup = (TextView)paramViewGroup.findViewById(2131373293);
    } else {
      paramViewGroup = null;
    }
    this.d = paramViewGroup;
    paramViewGroup = this.jdField_a_of_type_AndroidViewView;
    if (paramViewGroup != null) {
      paramViewGroup = (ImageView)paramViewGroup.findViewById(2131364719);
    } else {
      paramViewGroup = null;
    }
    this.jdField_b_of_type_AndroidWidgetImageView = paramViewGroup;
    paramViewGroup = this.jdField_a_of_type_AndroidViewView;
    if (paramViewGroup != null) {
      paramViewGroup = (TextView)paramViewGroup.findViewById(2131373290);
    } else {
      paramViewGroup = null;
    }
    this.e = paramViewGroup;
    View localView = this.jdField_a_of_type_AndroidViewView;
    paramViewGroup = paramRIJPushNotifyParam;
    if (localView != null) {
      paramViewGroup = (ViewGroup)localView.findViewById(2131373288);
    }
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = ((ReadInJoyObserver)new RIJPushNotifyDialog.1(this));
    b();
    c();
    a();
  }
  
  private final void a()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      localView.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)new RIJPushNotifyDialog.initCallback.1(this));
    }
  }
  
  private final void a(boolean paramBoolean, Function0<Unit> paramFunction0)
  {
    TranslateAnimation localTranslateAnimation;
    if (paramBoolean) {
      localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, DisplayUtil.a(this.jdField_b_of_type_AndroidViewViewGroup.getContext(), 152.0F), 0.0F);
    } else {
      localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, DisplayUtil.a(this.jdField_b_of_type_AndroidViewViewGroup.getContext(), 152.0F));
    }
    localTranslateAnimation.setDuration(300L);
    AlphaAnimation localAlphaAnimation;
    if (paramBoolean) {
      localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    } else {
      localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    }
    localAlphaAnimation.setDuration(300L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation((Animation)localAlphaAnimation);
    localAnimationSet.addAnimation((Animation)localTranslateAnimation);
    localAnimationSet.setAnimationListener((Animation.AnimationListener)new RIJPushNotifyDialog.playAnimation.1(paramFunction0));
    localAnimationSet.setFillAfter(true);
    paramFunction0 = this.jdField_a_of_type_AndroidViewView;
    if (paramFunction0 != null) {
      paramFunction0.startAnimation((Animation)localAnimationSet);
    }
  }
  
  private final void b()
  {
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    int j = 0;
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)new ColorDrawable(0));
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)new ColorDrawable(0));
    Object localObject3 = this.jdField_a_of_type_AndroidWidgetImageView;
    int i;
    if (localObject3 != null)
    {
      if (((CharSequence)this.jdField_a_of_type_ComTencentMobileqqKandianBizPushRIJPushNotifyParam.a()).length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        localObject1 = "https://pub.idqqimg.com/pc/misc/files/20200610/b0f587d6911f4930ae03a1817e90ac00.png";
      } else {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPushRIJPushNotifyParam.a();
      }
      ((ImageView)localObject3).setImageDrawable((Drawable)URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2));
    }
    Object localObject1 = this.jdField_a_of_type_AndroidViewView;
    Object localObject4 = null;
    localObject3 = null;
    if (localObject1 != null) {
      localObject1 = ((View)localObject1).getLayoutParams();
    } else {
      localObject1 = null;
    }
    localObject2 = localObject1;
    if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
      localObject2 = null;
    }
    localObject1 = (RelativeLayout.LayoutParams)localObject2;
    if (localObject1 != null) {
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = this.jdField_a_of_type_ComTencentMobileqqKandianBizPushRIJPushNotifyParam.b();
    }
    localObject1 = this.c;
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)RIJPushNotifyManager.Companion.a().getCheckBoxText());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPushRIJPushNotifyParam.a() == 1)
    {
      localObject1 = this.d;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)RIJPushNotifyManager.Companion.a().getType1HeaderText());
      }
      localObject1 = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(0);
      }
      localObject1 = this.e;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
      localObject1 = this.e;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)RIJPushNotifyManager.Companion.a().getType1ButtonText());
      }
      localObject1 = this.jdField_a_of_type_AndroidViewViewGroup;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setVisibility(8);
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPushRIJPushNotifyParam.a() == 2)
    {
      localObject1 = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(8);
      }
      localObject1 = this.e;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject1 = this.jdField_a_of_type_AndroidViewViewGroup;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setVisibility(0);
      }
      localObject1 = this.d;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)RIJPushNotifyManager.Companion.a().getType2HeaderText());
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)RIJPushNotifyManager.Companion.a().getType2LeftButtonText());
      }
      localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)RIJPushNotifyManager.Companion.a().getType2RightButtonText());
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPushRIJPushNotifyParam.a())
    {
      localObject1 = this.c;
      if (localObject1 != null) {
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(2130849727, 0, 0, 0);
      }
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 != null) {
        ((View)localObject1).setBackgroundColor(Color.parseColor("#FF333333"));
      }
      localObject2 = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject2 != null)
      {
        localObject1 = this.jdField_b_of_type_AndroidViewViewGroup.getContext();
        if (localObject1 != null)
        {
          localObject1 = ((Context)localObject1).getResources();
          if (localObject1 != null)
          {
            localObject1 = ((Resources)localObject1).getDrawable(2130849723);
            break label522;
          }
        }
        localObject1 = null;
        label522:
        ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
      }
      localObject1 = this.d;
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(Color.parseColor("#FFFFFFFF"));
      }
      localObject1 = this.c;
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(Color.parseColor("#FFD8D8D8"));
      }
      localObject2 = this.e;
      if (localObject2 != null)
      {
        localObject1 = this.jdField_b_of_type_AndroidViewViewGroup.getContext();
        if (localObject1 != null)
        {
          localObject1 = ((Context)localObject1).getResources();
          if (localObject1 != null)
          {
            localObject1 = ((Resources)localObject1).getDrawable(2130849729);
            break label611;
          }
        }
        localObject1 = null;
        label611:
        ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject1);
      }
      localObject2 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject2 != null)
      {
        localObject1 = this.jdField_b_of_type_AndroidViewViewGroup.getContext();
        if (localObject1 != null)
        {
          localObject1 = ((Context)localObject1).getResources();
          if (localObject1 != null)
          {
            localObject1 = ((Resources)localObject1).getDrawable(2130849729);
            break label662;
          }
        }
        localObject1 = null;
        label662:
        ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject1);
      }
      localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject2 != null)
      {
        localObject4 = this.jdField_b_of_type_AndroidViewViewGroup.getContext();
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          localObject4 = ((Context)localObject4).getResources();
          localObject1 = localObject3;
          if (localObject4 != null) {
            localObject1 = ((Resources)localObject4).getDrawable(2130849725);
          }
        }
        ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject1);
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(Color.parseColor("#FFFFFFFF"));
      }
    }
    else
    {
      localObject1 = this.c;
      if (localObject1 != null) {
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(2130849728, 0, 0, 0);
      }
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 != null) {
        ((View)localObject1).setBackgroundColor(Color.parseColor("#FFFFFFFF"));
      }
      localObject2 = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject2 != null)
      {
        localObject1 = this.jdField_b_of_type_AndroidViewViewGroup.getContext();
        if (localObject1 != null)
        {
          localObject1 = ((Context)localObject1).getResources();
          if (localObject1 != null)
          {
            localObject1 = ((Resources)localObject1).getDrawable(2130849724);
            break label831;
          }
        }
        localObject1 = null;
        label831:
        ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
      }
      localObject1 = this.d;
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(Color.parseColor("#FF000000"));
      }
      localObject1 = this.c;
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(Color.parseColor("#FFA8A8A8"));
      }
      localObject2 = this.e;
      if (localObject2 != null)
      {
        localObject1 = this.jdField_b_of_type_AndroidViewViewGroup.getContext();
        if (localObject1 != null)
        {
          localObject1 = ((Context)localObject1).getResources();
          if (localObject1 != null)
          {
            localObject1 = ((Resources)localObject1).getDrawable(2130849719);
            break label920;
          }
        }
        localObject1 = null;
        label920:
        ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject1);
      }
      localObject2 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject2 != null)
      {
        localObject1 = this.jdField_b_of_type_AndroidViewViewGroup.getContext();
        if (localObject1 != null)
        {
          localObject1 = ((Context)localObject1).getResources();
          if (localObject1 != null)
          {
            localObject1 = ((Resources)localObject1).getDrawable(2130849719);
            break label971;
          }
        }
        localObject1 = null;
        label971:
        ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject1);
      }
      localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject2 != null)
      {
        localObject3 = this.jdField_b_of_type_AndroidViewViewGroup.getContext();
        localObject1 = localObject4;
        if (localObject3 != null)
        {
          localObject3 = ((Context)localObject3).getResources();
          localObject1 = localObject4;
          if (localObject3 != null) {
            localObject1 = ((Resources)localObject3).getDrawable(2130849720);
          }
        }
        ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject1);
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(Color.parseColor("#FF000000"));
      }
    }
    localObject1 = this.jdField_b_of_type_AndroidViewView;
    if (localObject1 != null)
    {
      localObject1 = ((View)localObject1).findViewById(2131371888);
      if (localObject1 != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPushRIJPushNotifyParam.b()) {
          i = j;
        } else {
          i = 8;
        }
        ((View)localObject1).setVisibility(i);
      }
    }
  }
  
  private final void c()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new RIJPushNotifyDialog.initListener.1(this));
    }
    localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new RIJPushNotifyDialog.initListener.2(this));
    }
    localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new RIJPushNotifyDialog.initListener.3(this));
    }
    localObject = this.e;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new RIJPushNotifyDialog.initListener.4(this));
    }
    localObject = this.c;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new RIJPushNotifyDialog.initListener.5(this));
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(toString());
    localStringBuilder.append(" show isShowing: ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" needAnimation: ");
    localStringBuilder.append(paramBoolean);
    QLog.i("RIJPushNotifyDialog", 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.addView(this.jdField_b_of_type_AndroidViewView);
    if (paramBoolean) {
      a(this, true, null, 2, null);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed((Runnable)new RIJPushNotifyDialog.show.1(this), RIJPushNotifyManager.Companion.a().getDialogShowDuration());
  }
  
  public final void b(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(toString());
    ((StringBuilder)localObject).append(" dismiss isShowing: ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
    ((StringBuilder)localObject).append(" needAnimation: ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("RIJPushNotifyDialog", 1, ((StringBuilder)localObject).toString());
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramBoolean)
    {
      a(false, (Function0)new RIJPushNotifyDialog.dismiss.1(this));
    }
    else
    {
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      this.jdField_b_of_type_AndroidViewViewGroup.removeView(this.jdField_b_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.mvp.RIJPushNotifyDialog
 * JD-Core Version:    0.7.0.1
 */