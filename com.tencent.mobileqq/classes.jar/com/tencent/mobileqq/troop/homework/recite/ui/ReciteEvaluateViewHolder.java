package com.tencent.mobileqq.troop.homework.recite.ui;

import aiud;
import aiue;
import aiuf;
import aiug;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.utils.VideoAnimationUtils;
import com.tencent.mobileqq.troop.widget.BgTextSpan;
import mqq.app.AppRuntime;

public class ReciteEvaluateViewHolder
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "http://pub.idqqimg.com/pc/misc/files/20180315/a9ebfbc36f364fd6bd186620148066ba.gif", "http://pub.idqqimg.com/pc/misc/files/20180315/f780d696d63842c1aad4f8eb12f7ea85.gif", "http://pub.idqqimg.com/pc/misc/files/20180315/43357aa60b24452baba7707ed7f75c88.gif" };
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "完美！\n为你打Call。", "超棒！\n背得很流畅哦。", "不错~\n但还可以更好。" };
  private Context jdField_a_of_type_AndroidContentContext;
  public View a;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SpriteVideoView jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView;
  private boolean jdField_a_of_type_Boolean = true;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private View e;
  private View f;
  private View g;
  
  public ReciteEvaluateViewHolder(Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2130969907, paramViewGroup, false);
    e();
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private CharSequence a(String paramString1, String paramString2, int paramInt)
  {
    paramString2 = new SpannableString(new StringBuilder(paramString1).append(paramString2));
    paramString2.setSpan(new BgTextSpan(this.jdField_a_of_type_AndroidContentContext, 0, 20, 1, 7, 14, paramInt, paramString1), 0, paramString1.length(), 33);
    return paramString2;
  }
  
  private void a(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mPlayGifImage = this.jdField_a_of_type_Boolean;
    localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredWidth();
    localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredHeight();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.a;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.a;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setDownloadListener(new aiuf(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
    if ((paramString.getStatus() == 1) && (paramString.getCurrDrawable() != null))
    {
      h();
      return;
    }
    paramString.startDownload();
  }
  
  private void a(boolean paramBoolean, View paramView1, View paramView2)
  {
    int i = paramView1.getMeasuredHeight();
    int j = paramView2.getMeasuredHeight();
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, i + j, j);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    }
    paramView2 = this.jdField_a_of_type_AndroidViewAnimationAnimation;
    if (paramBoolean) {}
    for (long l = 1000L;; l = 0L)
    {
      paramView2.setDuration(l);
      paramView1.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      return;
    }
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368413);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368411));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368410));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368407);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368414));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368415));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368416));
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368405);
    this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131368417);
    this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131368418);
    this.g = this.jdField_a_of_type_AndroidViewView.findViewById(2131368406);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView = ((SpriteVideoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368392));
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.a();
    }
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationAnimation.cancel();
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.setVisibility(0);
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        VideoAnimationUtils.a((QQAppInterface)localAppRuntime, "qb_troop_hw_recite_result.mp4", "http://pub.idqqimg.com/pc/misc/files/20180312/59583551a1c748dfaae1e64f6e04ca20.mp4", this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView, new aiug(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView, null));
      }
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      AbstractGifImage.resumeAll();
      return;
    }
    AbstractGifImage.pauseAll();
  }
  
  public void a() {}
  
  public void a(SpriteVideoView paramSpriteVideoView)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView = paramSpriteVideoView;
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    paramString = this.jdField_a_of_type_AndroidContentContext.getResources();
    int j = 2130841355;
    int m = paramString.getColor(2131492970);
    int i;
    if (paramInt1 < jdField_b_of_type_ArrayOfJavaLangString.length)
    {
      i = paramInt1;
      if (paramInt1 >= 0) {}
    }
    else
    {
      i = jdField_b_of_type_ArrayOfJavaLangString.length - 1;
    }
    String str1 = jdField_b_of_type_ArrayOfJavaLangString[i];
    String str2 = jdField_a_of_type_ArrayOfJavaLangString[i];
    paramInt1 = 0;
    int k = 2130841335;
    switch (i)
    {
    default: 
      i = m;
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(k);
      this.jdField_b_of_type_AndroidViewView.setLayerType(1, null);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
      if (this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredHeight() > 0)
      {
        a(str2);
        label168:
        this.jdField_c_of_type_AndroidViewView.setBackgroundResource(j);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
        j = (int)(paramLong / 60L);
        k = (int)(paramLong % 60L);
        paramString = new StringBuilder().append(j).append("'");
        if (k != 0) {
          paramString.append(k);
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(a("用时", paramString.toString(), paramInt1));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(i);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(a("错误", String.valueOf(paramInt2), paramInt1));
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(i);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(a("提醒", String.valueOf(paramInt3), paramInt1));
        if (this.g.getMeasuredHeight() != 0) {
          break label430;
        }
        this.g.getViewTreeObserver().addOnGlobalLayoutListener(new aiue(this, paramBoolean));
      }
      break;
    }
    for (;;)
    {
      if (paramBoolean) {
        g();
      }
      return;
      paramInt1 = Color.parseColor("#636363");
      i = m;
      break;
      paramInt1 = paramString.getColor(2131492968);
      k = 2130841336;
      j = 2130841354;
      i = paramInt1;
      break;
      paramInt1 = paramString.getColor(2131492968);
      j = 2130841353;
      i = paramInt1;
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.getViewTreeObserver().addOnGlobalLayoutListener(new aiud(this, str2));
      break label168;
      label430:
      this.f.setVisibility(4);
      a(paramBoolean, this.g, this.jdField_d_of_type_AndroidViewView);
    }
  }
  
  public void b()
  {
    f();
  }
  
  public void c()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {
      VideoAnimationUtils.a((QQAppInterface)localObject1, "qb_troop_hw_recite_result.mp4", "http://pub.idqqimg.com/pc/misc/files/20180312/59583551a1c748dfaae1e64f6e04ca20.mp4");
    }
    localObject1 = jdField_a_of_type_ArrayOfJavaLangString;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mPlayGifImage = true;
      localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
      if ((((URLDrawable)localObject2).getStatus() != 1) || (((URLDrawable)localObject2).getCurrDrawable() == null)) {
        ((URLDrawable)localObject2).startDownload();
      }
      i += 1;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.f.setVisibility(0);
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.a();
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationAnimation.cancel();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.ReciteEvaluateViewHolder
 * JD-Core Version:    0.7.0.1
 */