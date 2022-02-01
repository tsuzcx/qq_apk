package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.nineoldandroids.animation.AnimatorInflater;
import com.nineoldandroids.animation.AnimatorSet;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.mini.ui.RoundImageView;
import com.tencent.mobileqq.utils.ImageUtil;

public class MatchingView
  extends FrameLayout
{
  private RoundImageView a;
  private TextView b;
  private View c;
  private LottieDrawable d;
  private AnimatorSet e;
  private boolean f = false;
  
  public MatchingView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MatchingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MatchingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(1912995845, this, true);
    this.a = ((RoundImageView)findViewById(1912930379));
    this.b = ((TextView)findViewById(1912930380));
    this.c = findViewById(1912930382);
    this.a.setBorderColor(-1);
    this.a.setBorderWidth(6);
    c();
    d();
  }
  
  private void c()
  {
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    Object localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
    localObject2 = ((IQQAvatarService)((QQAppInterface)localObject2).getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface)localObject2);
    ((IFaceDecoder)localObject2).setDecodeTaskCompletionListener(new MatchingView.1(this, (String)localObject1));
    Bitmap localBitmap = ((IFaceDecoder)localObject2).getBitmapFromCacheFrom(1, (String)localObject1, 6);
    if (localBitmap == null)
    {
      if (!((IFaceDecoder)localObject2).isPausing()) {
        ((IFaceDecoder)localObject2).requestDecodeFace((String)localObject1, 1, true);
      }
      localObject1 = null;
    }
    else
    {
      localObject1 = new BitmapDrawable(getResources(), localBitmap);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = ImageUtil.j();
    }
    this.a.setImageDrawable((Drawable)localObject2);
  }
  
  private void d()
  {
    ThreadManager.post(new MatchingView.2(this), 5, null, true);
  }
  
  public void a()
  {
    if (this.e == null)
    {
      this.e = ((AnimatorSet)AnimatorInflater.loadAnimator(getContext(), 2130903061));
      this.e.setTarget(this.a);
      this.e.setStartDelay(1000L);
      this.e.addListener(new MatchingView.3(this));
    }
    LottieDrawable localLottieDrawable = this.d;
    if (localLottieDrawable != null) {
      localLottieDrawable.playAnimation();
    }
    this.e.start();
    this.f = true;
  }
  
  public void a(String paramString)
  {
    this.a.setImageDrawable(null);
    this.b.setText(null);
    c();
    if (!TextUtils.isEmpty(paramString)) {
      this.b.setText(paramString);
    }
  }
  
  public void b()
  {
    this.f = false;
    Object localObject = this.e;
    if (localObject != null)
    {
      ((AnimatorSet)localObject).cancel();
      this.e.end();
    }
    localObject = this.d;
    if (localObject != null) {
      ((LottieDrawable)localObject).endAnimation();
    }
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.MatchingView
 * JD-Core Version:    0.7.0.1
 */