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
  public static final RIJPushNotifyDialog.Companion a = new RIJPushNotifyDialog.Companion(null);
  private final View b;
  private final View c;
  private boolean d;
  private final ImageView e;
  private final TextView f;
  private final TextView g;
  private final TextView h;
  private final TextView i;
  private final ImageView j;
  private boolean k;
  private final ReadInJoyObserver l;
  private final TextView m;
  private final ViewGroup n;
  private final Handler o;
  private final ViewGroup p;
  private final RIJPushNotifyParam q;
  
  public RIJPushNotifyDialog(@NotNull ViewGroup paramViewGroup, @NotNull RIJPushNotifyParam paramRIJPushNotifyParam)
  {
    this.p = paramViewGroup;
    this.q = paramRIJPushNotifyParam;
    this.o = new Handler(Looper.getMainLooper());
    this.c = LayoutInflater.from(this.p.getContext()).inflate(2131629139, this.p, false);
    paramViewGroup = this.c;
    paramRIJPushNotifyParam = null;
    if (paramViewGroup != null) {
      paramViewGroup = paramViewGroup.findViewById(2131440900);
    } else {
      paramViewGroup = null;
    }
    this.b = paramViewGroup;
    paramViewGroup = this.b;
    if (paramViewGroup != null) {
      paramViewGroup = (ImageView)paramViewGroup.findViewById(2131440894);
    } else {
      paramViewGroup = null;
    }
    this.e = paramViewGroup;
    paramViewGroup = this.b;
    if (paramViewGroup != null) {
      paramViewGroup = (TextView)paramViewGroup.findViewById(2131440904);
    } else {
      paramViewGroup = null;
    }
    this.f = paramViewGroup;
    paramViewGroup = this.b;
    if (paramViewGroup != null) {
      paramViewGroup = (TextView)paramViewGroup.findViewById(2131440898);
    } else {
      paramViewGroup = null;
    }
    this.g = paramViewGroup;
    paramViewGroup = this.b;
    if (paramViewGroup != null) {
      paramViewGroup = (TextView)paramViewGroup.findViewById(2131431679);
    } else {
      paramViewGroup = null;
    }
    this.h = paramViewGroup;
    paramViewGroup = this.b;
    if (paramViewGroup != null) {
      paramViewGroup = (TextView)paramViewGroup.findViewById(2131440902);
    } else {
      paramViewGroup = null;
    }
    this.i = paramViewGroup;
    paramViewGroup = this.b;
    if (paramViewGroup != null) {
      paramViewGroup = (ImageView)paramViewGroup.findViewById(2131430825);
    } else {
      paramViewGroup = null;
    }
    this.j = paramViewGroup;
    paramViewGroup = this.b;
    if (paramViewGroup != null) {
      paramViewGroup = (TextView)paramViewGroup.findViewById(2131440899);
    } else {
      paramViewGroup = null;
    }
    this.m = paramViewGroup;
    View localView = this.b;
    paramViewGroup = paramRIJPushNotifyParam;
    if (localView != null) {
      paramViewGroup = (ViewGroup)localView.findViewById(2131440897);
    }
    this.n = paramViewGroup;
    this.l = ((ReadInJoyObserver)new RIJPushNotifyDialog.1(this));
    b();
    c();
    a();
  }
  
  private final void a()
  {
    View localView = this.c;
    if (localView != null) {
      localView.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)new RIJPushNotifyDialog.initCallback.1(this));
    }
  }
  
  private final void a(boolean paramBoolean, Function0<Unit> paramFunction0)
  {
    TranslateAnimation localTranslateAnimation;
    if (paramBoolean) {
      localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, DisplayUtil.a(this.p.getContext(), 152.0F), 0.0F);
    } else {
      localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, DisplayUtil.a(this.p.getContext(), 152.0F));
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
    paramFunction0 = this.b;
    if (paramFunction0 != null) {
      paramFunction0.startAnimation((Animation)localAnimationSet);
    }
  }
  
  private final void b()
  {
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    int i2 = 0;
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)new ColorDrawable(0));
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)new ColorDrawable(0));
    Object localObject3 = this.e;
    int i1;
    if (localObject3 != null)
    {
      if (((CharSequence)this.q.c()).length() == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        localObject1 = "https://pub.idqqimg.com/pc/misc/files/20200610/b0f587d6911f4930ae03a1817e90ac00.png";
      } else {
        localObject1 = this.q.c();
      }
      ((ImageView)localObject3).setImageDrawable((Drawable)URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2));
    }
    Object localObject1 = this.b;
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
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = this.q.e();
    }
    localObject1 = this.h;
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)RIJPushNotifyManager.Companion.a().getCheckBoxText());
    }
    if (this.q.a() == 1)
    {
      localObject1 = this.i;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)RIJPushNotifyManager.Companion.a().getType1HeaderText());
      }
      localObject1 = this.j;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(0);
      }
      localObject1 = this.m;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
      localObject1 = this.m;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)RIJPushNotifyManager.Companion.a().getType1ButtonText());
      }
      localObject1 = this.n;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setVisibility(8);
      }
    }
    else if (this.q.a() == 2)
    {
      localObject1 = this.j;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(8);
      }
      localObject1 = this.m;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject1 = this.n;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setVisibility(0);
      }
      localObject1 = this.i;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)RIJPushNotifyManager.Companion.a().getType2HeaderText());
      }
      localObject1 = this.f;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)RIJPushNotifyManager.Companion.a().getType2LeftButtonText());
      }
      localObject1 = this.g;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)RIJPushNotifyManager.Companion.a().getType2RightButtonText());
      }
    }
    if (this.q.b())
    {
      localObject1 = this.h;
      if (localObject1 != null) {
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(2130851436, 0, 0, 0);
      }
      localObject1 = this.b;
      if (localObject1 != null) {
        ((View)localObject1).setBackgroundColor(Color.parseColor("#FF333333"));
      }
      localObject2 = this.j;
      if (localObject2 != null)
      {
        localObject1 = this.p.getContext();
        if (localObject1 != null)
        {
          localObject1 = ((Context)localObject1).getResources();
          if (localObject1 != null)
          {
            localObject1 = ((Resources)localObject1).getDrawable(2130851432);
            break label522;
          }
        }
        localObject1 = null;
        label522:
        ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
      }
      localObject1 = this.i;
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(Color.parseColor("#FFFFFFFF"));
      }
      localObject1 = this.h;
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(Color.parseColor("#FFD8D8D8"));
      }
      localObject2 = this.m;
      if (localObject2 != null)
      {
        localObject1 = this.p.getContext();
        if (localObject1 != null)
        {
          localObject1 = ((Context)localObject1).getResources();
          if (localObject1 != null)
          {
            localObject1 = ((Resources)localObject1).getDrawable(2130851438);
            break label611;
          }
        }
        localObject1 = null;
        label611:
        ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject1);
      }
      localObject2 = this.g;
      if (localObject2 != null)
      {
        localObject1 = this.p.getContext();
        if (localObject1 != null)
        {
          localObject1 = ((Context)localObject1).getResources();
          if (localObject1 != null)
          {
            localObject1 = ((Resources)localObject1).getDrawable(2130851438);
            break label662;
          }
        }
        localObject1 = null;
        label662:
        ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject1);
      }
      localObject2 = this.f;
      if (localObject2 != null)
      {
        localObject4 = this.p.getContext();
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          localObject4 = ((Context)localObject4).getResources();
          localObject1 = localObject3;
          if (localObject4 != null) {
            localObject1 = ((Resources)localObject4).getDrawable(2130851434);
          }
        }
        ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject1);
      }
      localObject1 = this.f;
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(Color.parseColor("#FFFFFFFF"));
      }
    }
    else
    {
      localObject1 = this.h;
      if (localObject1 != null) {
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(2130851437, 0, 0, 0);
      }
      localObject1 = this.b;
      if (localObject1 != null) {
        ((View)localObject1).setBackgroundColor(Color.parseColor("#FFFFFFFF"));
      }
      localObject2 = this.j;
      if (localObject2 != null)
      {
        localObject1 = this.p.getContext();
        if (localObject1 != null)
        {
          localObject1 = ((Context)localObject1).getResources();
          if (localObject1 != null)
          {
            localObject1 = ((Resources)localObject1).getDrawable(2130851433);
            break label831;
          }
        }
        localObject1 = null;
        label831:
        ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
      }
      localObject1 = this.i;
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(Color.parseColor("#FF000000"));
      }
      localObject1 = this.h;
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(Color.parseColor("#FFA8A8A8"));
      }
      localObject2 = this.m;
      if (localObject2 != null)
      {
        localObject1 = this.p.getContext();
        if (localObject1 != null)
        {
          localObject1 = ((Context)localObject1).getResources();
          if (localObject1 != null)
          {
            localObject1 = ((Resources)localObject1).getDrawable(2130851428);
            break label920;
          }
        }
        localObject1 = null;
        label920:
        ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject1);
      }
      localObject2 = this.g;
      if (localObject2 != null)
      {
        localObject1 = this.p.getContext();
        if (localObject1 != null)
        {
          localObject1 = ((Context)localObject1).getResources();
          if (localObject1 != null)
          {
            localObject1 = ((Resources)localObject1).getDrawable(2130851428);
            break label971;
          }
        }
        localObject1 = null;
        label971:
        ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject1);
      }
      localObject2 = this.f;
      if (localObject2 != null)
      {
        localObject3 = this.p.getContext();
        localObject1 = localObject4;
        if (localObject3 != null)
        {
          localObject3 = ((Context)localObject3).getResources();
          localObject1 = localObject4;
          if (localObject3 != null) {
            localObject1 = ((Resources)localObject3).getDrawable(2130851429);
          }
        }
        ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject1);
      }
      localObject1 = this.f;
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(Color.parseColor("#FF000000"));
      }
    }
    localObject1 = this.c;
    if (localObject1 != null)
    {
      localObject1 = ((View)localObject1).findViewById(2131439331);
      if (localObject1 != null)
      {
        if (this.q.f()) {
          i1 = i2;
        } else {
          i1 = 8;
        }
        ((View)localObject1).setVisibility(i1);
      }
    }
  }
  
  private final void c()
  {
    Object localObject = this.f;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new RIJPushNotifyDialog.initListener.1(this));
    }
    localObject = this.g;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new RIJPushNotifyDialog.initListener.2(this));
    }
    localObject = this.j;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new RIJPushNotifyDialog.initListener.3(this));
    }
    localObject = this.m;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new RIJPushNotifyDialog.initListener.4(this));
    }
    localObject = this.h;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new RIJPushNotifyDialog.initListener.5(this));
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(toString());
    localStringBuilder.append(" show isShowing: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" needAnimation: ");
    localStringBuilder.append(paramBoolean);
    QLog.i("RIJPushNotifyDialog", 1, localStringBuilder.toString());
    if (this.d) {
      return;
    }
    this.p.addView(this.c);
    if (paramBoolean) {
      a(this, true, null, 2, null);
    }
    this.d = true;
    this.o.postDelayed((Runnable)new RIJPushNotifyDialog.show.1(this), RIJPushNotifyManager.Companion.a().getDialogShowDuration());
  }
  
  public final void b(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(toString());
    ((StringBuilder)localObject).append(" dismiss isShowing: ");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(" needAnimation: ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("RIJPushNotifyDialog", 1, ((StringBuilder)localObject).toString());
    if (!this.d) {
      return;
    }
    if (paramBoolean)
    {
      a(false, (Function0)new RIJPushNotifyDialog.dismiss.1(this));
    }
    else
    {
      localObject = this.c;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      this.p.removeView(this.c);
    }
    this.d = false;
    this.o.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.mvp.RIJPushNotifyDialog
 * JD-Core Version:    0.7.0.1
 */