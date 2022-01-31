package com.tencent.mobileqq.olympic.activity;

import afrd;
import afre;
import afrf;
import afrg;
import afrh;
import afri;
import afrj;
import afrk;
import afrl;
import afrm;
import afrn;
import afro;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

public class ARTipsManager
{
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ViewConfiguration jdField_a_of_type_AndroidViewViewConfiguration;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ARTipsManager.ARTipsVisibleListener jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$ARTipsVisibleListener;
  
  public ARTipsManager(Context paramContext, RelativeLayout paramRelativeLayout, ARTipsManager.ARTipsVisibleListener paramARTipsVisibleListener)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidViewViewConfiguration = ViewConfiguration.get(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new afrm(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$ARTipsVisibleListener = paramARTipsVisibleListener;
  }
  
  private ViewGroup a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, "createTipsView");
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968701, null);
    if (localViewGroup != null)
    {
      afro localafro = new afro(this, null);
      localafro.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131363266));
      localafro.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131363267));
      localafro.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131363268));
      localafro.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131363269));
      localafro.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress = ((ARTipsCircleProgress)localViewGroup.findViewById(2131363270));
      localafro.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131363271));
      localafro.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131363272));
      localafro.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131363273));
      localafro.e = ((TextView)localViewGroup.findViewById(2131363275));
      localafro.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131363276));
      localafro.f = ((TextView)localViewGroup.findViewById(2131363277));
      localafro.jdField_a_of_type_AndroidViewView = localViewGroup.findViewById(2131363278);
      localafro.g = ((TextView)localViewGroup.findViewById(2131363281));
      localafro.h = ((TextView)localViewGroup.findViewById(2131363280));
      localafro.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localViewGroup.findViewById(2131363274));
      localViewGroup.setTag(localafro);
      localViewGroup.setOnTouchListener(new afrd(this));
    }
    return localViewGroup;
  }
  
  private void a(int paramInt1, int paramInt2, ARTipsManager.OcrClickListener paramOcrClickListener, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showOcr tag=%s type=%s listener=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramOcrClickListener, Boolean.valueOf(paramBoolean) }));
    }
    afrn localafrn = new afrn(this, null);
    localafrn.jdField_a_of_type_Int = paramInt1;
    localafrn.jdField_b_of_type_Int = paramInt2;
    localafrn.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$OcrClickListener = paramOcrClickListener;
    localafrn.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramOcrClickListener = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramOcrClickListener.obj = localafrn;
    paramOcrClickListener.sendToTarget();
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, ARTipsManager.BaikeClickListener paramBaikeClickListener, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramString1, paramString2, paramBaikeClickListener, paramBoolean, true);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, ARTipsManager.BaikeClickListener paramBaikeClickListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showBaike tag=%s type=%s title=%s content=%s listener=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramBaikeClickListener, Boolean.valueOf(paramBoolean1) }));
    }
    afrn localafrn = new afrn(this, null);
    localafrn.jdField_a_of_type_Int = paramInt1;
    localafrn.jdField_b_of_type_Int = paramInt2;
    localafrn.jdField_a_of_type_Boolean = paramBoolean1;
    localafrn.d = paramString1;
    localafrn.e = paramString2;
    localafrn.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$BaikeClickListener = paramBaikeClickListener;
    localafrn.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localafrn;
    paramString1.sendToTarget();
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, ARTipsManager.ButtonClickListener paramButtonClickListener, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showTips tag=%s type=%s tips=%s description=%s btnText=%s btnListener=%s progress=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramString3, paramButtonClickListener, Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) }));
    }
    afrn localafrn = new afrn(this, null);
    localafrn.jdField_a_of_type_Int = paramInt1;
    localafrn.jdField_b_of_type_Int = paramInt2;
    localafrn.jdField_a_of_type_Boolean = paramBoolean;
    localafrn.jdField_a_of_type_JavaLangString = paramString1;
    localafrn.jdField_b_of_type_JavaLangString = paramString2;
    localafrn.jdField_c_of_type_JavaLangString = paramString3;
    localafrn.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$ButtonClickListener = paramButtonClickListener;
    localafrn.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localafrn;
    paramString1.sendToTarget();
  }
  
  private void a(afrn paramafrn)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = a();
    }
    afro localafro;
    int i;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131362437, paramafrn);
      localafro = (afro)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
      if (localafro != null)
      {
        i = paramafrn.jdField_b_of_type_Int;
        if ((i != 1) && (i != 2) && (i != 3)) {
          break label353;
        }
        localafro.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        localafro.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localafro.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localafro.jdField_a_of_type_AndroidWidgetTextView.setText(paramafrn.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(paramafrn.jdField_b_of_type_JavaLangString)) {
          break label213;
        }
        localafro.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        localafro.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewViewGroup.getParent() == null) {
        b();
      }
      if (paramafrn.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        paramafrn = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramafrn, 5000L);
      }
      return;
      label213:
      localafro.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localafro.jdField_b_of_type_AndroidWidgetTextView.setText(paramafrn.jdField_b_of_type_JavaLangString);
      localafro.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 20.0F);
      break;
      localafro.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localafro.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localafro.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      localafro.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localafro.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localafro.jdField_c_of_type_AndroidWidgetTextView.setText(paramafrn.jdField_c_of_type_JavaLangString);
      localafro.jdField_a_of_type_AndroidViewViewGroup.setEnabled(true);
      continue;
      localafro.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localafro.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(0);
      localafro.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setProgress(paramafrn.jdField_c_of_type_Int);
      localafro.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      label353:
      if ((i == 10) || (i == 11))
      {
        localafro.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localafro.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localafro.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        FrameLayout.LayoutParams localLayoutParams;
        if (paramafrn.jdField_b_of_type_Boolean)
        {
          localafro.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localafro.jdField_d_of_type_AndroidWidgetTextView.setText(paramafrn.d);
          localafro.e.setText(paramafrn.e);
          localafro.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(new afre(this, paramafrn));
          localLayoutParams = (FrameLayout.LayoutParams)localafro.jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
          switch (i)
          {
          }
        }
        for (;;)
        {
          localafro.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
          break;
          localafro.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          break label406;
          localafro.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
          localLayoutParams.bottomMargin = AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidContentResResources);
          continue;
          localafro.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
          localafro.f.setOnClickListener(new afrf(this, paramafrn));
          localLayoutParams.bottomMargin = AIOUtils.a(0.0F, this.jdField_a_of_type_AndroidContentResResources);
        }
      }
      label406:
      if (i == 12)
      {
        localafro.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localafro.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localafro.jdField_a_of_type_AndroidViewView.setVisibility(0);
        if (paramafrn.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$OcrClickListener != null)
        {
          localafro.g.setOnClickListener(new afrg(this, paramafrn));
          localafro.h.setOnClickListener(new afrh(this, paramafrn));
        }
      }
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, "addTipsWithAnim");
    }
    Object localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewViewGroup, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    ((ValueAnimator)localObject).setDuration(400L);
    ((ValueAnimator)localObject).addUpdateListener(new afri(this));
    ((ValueAnimator)localObject).addListener(new afrj(this));
    ((ValueAnimator)localObject).start();
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$ARTipsVisibleListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$ARTipsVisibleListener.a(true);
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, "removeTipsWithAnim");
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
      this.jdField_a_of_type_AndroidViewViewGroup = null;
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.setDuration(400L);
      localValueAnimator.addUpdateListener(new afrk(this, localViewGroup));
      localValueAnimator.addListener(new afrl(this, localViewGroup));
      localValueAnimator.start();
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$ARTipsVisibleListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$ARTipsVisibleListener.a(false);
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      afrn localafrn = (afrn)this.jdField_a_of_type_AndroidViewViewGroup.getTag(2131362437);
      if (localafrn != null) {
        return localafrn.jdField_a_of_type_Int;
      }
    }
    return 0;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101).sendToTarget();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (paramInt == a()))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101).sendToTarget();
    }
  }
  
  public void a(int paramInt, ARTipsManager.OcrClickListener paramOcrClickListener, boolean paramBoolean)
  {
    a(paramInt, 12, paramOcrClickListener, paramBoolean);
  }
  
  public void a(int paramInt, String paramString)
  {
    a(paramInt, 1, paramString, null, null, null, 0, true);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, ARTipsManager.BaikeClickListener paramBaikeClickListener)
  {
    a(paramInt, 11, paramString1, paramString2, paramBaikeClickListener, false);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, ARTipsManager.ButtonClickListener paramButtonClickListener, boolean paramBoolean)
  {
    a(paramInt, 2, paramString1, paramString2, paramString3, paramButtonClickListener, 0, paramBoolean);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    a(paramInt, 1, paramString, null, null, null, 0, paramBoolean);
  }
  
  public void a(String paramString)
  {
    a(0, paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    a(0, 3, paramString, null, null, null, paramInt, false);
  }
  
  public void a(String paramString1, String paramString2, ARTipsManager.BaikeClickListener paramBaikeClickListener, boolean paramBoolean)
  {
    a(0, 10, paramString1, paramString2, paramBaikeClickListener, false, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, ARTipsManager.ButtonClickListener paramButtonClickListener)
  {
    a(paramString1, paramString2, paramButtonClickListener, false);
  }
  
  public void a(String paramString1, String paramString2, ARTipsManager.ButtonClickListener paramButtonClickListener, boolean paramBoolean)
  {
    a(0, paramString1, null, paramString2, paramButtonClickListener, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ARTipsManager
 * JD-Core Version:    0.7.0.1
 */