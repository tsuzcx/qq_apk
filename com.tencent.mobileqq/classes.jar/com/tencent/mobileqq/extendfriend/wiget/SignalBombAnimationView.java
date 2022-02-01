package com.tencent.mobileqq.extendfriend.wiget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import atax;
import ateu;
import atev;
import atew;
import atez;
import atfa;
import bhlo;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SignalBombAnimationView
  extends FrameLayout
  implements Handler.Callback
{
  int jdField_a_of_type_Int = 0;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private atfa jdField_a_of_type_Atfa;
  public QQAnimationDrawable a;
  boolean jdField_a_of_type_Boolean = false;
  public final int b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  QQAnimationDrawable jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
  private boolean jdField_b_of_type_Boolean;
  public final int c;
  private ImageView c;
  private int d = 48;
  
  public SignalBombAnimationView(Context paramContext)
  {
    this(paramContext, null);
    a(paramContext);
  }
  
  public SignalBombAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    a(paramContext);
  }
  
  public SignalBombAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 2;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131561207, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377728));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377725));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363569));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366286);
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable = new QQAnimationDrawable();
    this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable = new QQAnimationDrawable();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private String[] a(String paramString)
  {
    int j = 0;
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      QLog.i("SignalBombAnimationView", 2, "exist Animation Pic!");
      paramString = paramString.listFiles();
      if ((paramString != null) && (paramString.length > 0))
      {
        Arrays.sort(paramString, new atez(this));
        ArrayList localArrayList = new ArrayList();
        boolean bool = bhlo.g();
        int i = 1;
        if (bool) {
          i = 3;
        }
        int k = bhlo.f();
        this.d = (48 / i);
        QLog.e("SignalBombAnimationView", 2, "isLowLevelMachine 50% cut frames isLowLevel:" + bool + " level :" + k + " cut time:" + i + " traceindex:" + this.d);
        int m = paramString.length;
        k = 0;
        while (j < m)
        {
          Object localObject = paramString[j];
          if ((!bool) || (k % i == 0) || (k + 1 == paramString.length)) {
            localArrayList.add(localObject.getPath());
          }
          k += 1;
          j += 1;
        }
        return (String[])localArrayList.toArray(new String[localArrayList.size()]);
      }
    }
    return null;
  }
  
  private void e()
  {
    this.jdField_a_of_type_Boolean = true;
    int i = this.jdField_a_of_type_AndroidViewView.getTop();
    int j = this.jdField_c_of_type_AndroidWidgetImageView.getTop();
    this.jdField_a_of_type_Int = (i - j);
    QLog.d("SignalBombAnimationViewExtendFriendLimitChat", 2, "SignalBombAnimationView. deltaY = " + this.jdField_a_of_type_Int + " beginY" + j + "destinyY " + i);
    Object localObject = a(atax.d());
    if ((localObject != null) && (localObject.length > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a((String[])localObject);
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.b(true);
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(2480L);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(new ateu(this));
    }
    localObject = a(atax.e());
    if ((localObject != null) && (localObject.length > 0))
    {
      if (this.d > localObject.length)
      {
        this.d = (localObject.length * 2 / 3);
        QLog.e("SignalBombAnimationView", 2, "traceStartOnFrameIndexOfBomb > bombPaths.length straceStartOnFrameIndexOfBomb set" + this.d);
      }
      this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a((String[])localObject);
      this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.b(true);
      this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(2880L);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
      this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(new atev(this));
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    localObject = ObjectAnimator.ofFloat(this.jdField_c_of_type_AndroidWidgetImageView, "translationY", new float[] { 0.0F, this.jdField_a_of_type_Int });
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_c_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F });
    AccelerateDecelerateInterpolator localAccelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
    ((ObjectAnimator)localObject).setDuration(860L);
    ((ObjectAnimator)localObject).setInterpolator(localAccelerateDecelerateInterpolator);
    localObjectAnimator.setDuration(860L);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { localObject, localObjectAnimator });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new atew(this));
  }
  
  public void a()
  {
    QLog.d("SignalBombAnimationView", 2, "startBombAnim()");
    if (!this.jdField_a_of_type_Boolean) {
      e();
    }
    if (this.jdField_a_of_type_Atfa != null) {
      this.jdField_a_of_type_Atfa.a();
    }
    b();
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
      QLog.d("SignalBombAnimationView", 2, "mSignalBomb SET mBombDrawable");
    }
    if (this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
      if (this.jdField_a_of_type_Atfa != null) {
        this.jdField_a_of_type_Atfa.a();
      }
      QLog.d("SignalBombAnimationView", 2, "mBombDrawable start");
    }
  }
  
  public void b()
  {
    QLog.d("SignalBombAnimationView", 2, "stopBombAnim()");
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.stop();
      QLog.d("SignalBombAnimationView", 2, "mBombDrawable stop");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.stop();
      QLog.d("SignalBombAnimationView", 2, "mFireDrawable stop");
    }
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
    if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.setTranslationY(0.0F);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void c()
  {
    b();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.clearAnimation();
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.d();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable != null) {
      this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.d();
    }
  }
  
  void d()
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      d();
      continue;
      a();
    }
  }
  
  public void setListener(atfa paramatfa)
  {
    this.jdField_a_of_type_Atfa = paramatfa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.SignalBombAnimationView
 * JD-Core Version:    0.7.0.1
 */