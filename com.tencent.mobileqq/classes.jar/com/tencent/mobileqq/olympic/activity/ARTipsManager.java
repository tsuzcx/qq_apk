package com.tencent.mobileqq.olympic.activity;

import agiv;
import agiw;
import agix;
import agiy;
import agiz;
import agja;
import agjb;
import agjc;
import agjd;
import agje;
import agjf;
import agjg;
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
    this.jdField_a_of_type_AndroidOsHandler = new agje(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$ARTipsVisibleListener = paramARTipsVisibleListener;
  }
  
  private ViewGroup a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, "createTipsView");
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968704, null);
    if (localViewGroup != null)
    {
      agjg localagjg = new agjg(this, null);
      localagjg.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131363301));
      localagjg.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131363302));
      localagjg.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131363303));
      localagjg.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131363304));
      localagjg.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress = ((ARTipsCircleProgress)localViewGroup.findViewById(2131363305));
      localagjg.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131363306));
      localagjg.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131363307));
      localagjg.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131363308));
      localagjg.e = ((TextView)localViewGroup.findViewById(2131363310));
      localagjg.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131363311));
      localagjg.f = ((TextView)localViewGroup.findViewById(2131363312));
      localagjg.jdField_a_of_type_AndroidViewView = localViewGroup.findViewById(2131363313);
      localagjg.g = ((TextView)localViewGroup.findViewById(2131363316));
      localagjg.h = ((TextView)localViewGroup.findViewById(2131363315));
      localagjg.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localViewGroup.findViewById(2131363309));
      localViewGroup.setTag(localagjg);
      localViewGroup.setOnTouchListener(new agiv(this));
    }
    return localViewGroup;
  }
  
  private void a(int paramInt1, int paramInt2, ARTipsManager.OcrClickListener paramOcrClickListener, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showOcr tag=%s type=%s listener=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramOcrClickListener, Boolean.valueOf(paramBoolean) }));
    }
    agjf localagjf = new agjf(this, null);
    localagjf.jdField_a_of_type_Int = paramInt1;
    localagjf.jdField_b_of_type_Int = paramInt2;
    localagjf.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$OcrClickListener = paramOcrClickListener;
    localagjf.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramOcrClickListener = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramOcrClickListener.obj = localagjf;
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
    agjf localagjf = new agjf(this, null);
    localagjf.jdField_a_of_type_Int = paramInt1;
    localagjf.jdField_b_of_type_Int = paramInt2;
    localagjf.jdField_a_of_type_Boolean = paramBoolean1;
    localagjf.d = paramString1;
    localagjf.e = paramString2;
    localagjf.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$BaikeClickListener = paramBaikeClickListener;
    localagjf.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localagjf;
    paramString1.sendToTarget();
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, ARTipsManager.ButtonClickListener paramButtonClickListener, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showTips tag=%s type=%s tips=%s description=%s btnText=%s btnListener=%s progress=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramString3, paramButtonClickListener, Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) }));
    }
    agjf localagjf = new agjf(this, null);
    localagjf.jdField_a_of_type_Int = paramInt1;
    localagjf.jdField_b_of_type_Int = paramInt2;
    localagjf.jdField_a_of_type_Boolean = paramBoolean;
    localagjf.jdField_a_of_type_JavaLangString = paramString1;
    localagjf.jdField_b_of_type_JavaLangString = paramString2;
    localagjf.jdField_c_of_type_JavaLangString = paramString3;
    localagjf.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$ButtonClickListener = paramButtonClickListener;
    localagjf.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localagjf;
    paramString1.sendToTarget();
  }
  
  private void a(agjf paramagjf)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = a();
    }
    agjg localagjg;
    int i;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131362443, paramagjf);
      localagjg = (agjg)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
      if (localagjg != null)
      {
        i = paramagjf.jdField_b_of_type_Int;
        if ((i != 1) && (i != 2) && (i != 3)) {
          break label353;
        }
        localagjg.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        localagjg.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localagjg.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localagjg.jdField_a_of_type_AndroidWidgetTextView.setText(paramagjf.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(paramagjf.jdField_b_of_type_JavaLangString)) {
          break label213;
        }
        localagjg.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        localagjg.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
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
      if (paramagjf.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        paramagjf = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramagjf, 5000L);
      }
      return;
      label213:
      localagjg.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localagjg.jdField_b_of_type_AndroidWidgetTextView.setText(paramagjf.jdField_b_of_type_JavaLangString);
      localagjg.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 20.0F);
      break;
      localagjg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localagjg.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localagjg.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      localagjg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localagjg.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localagjg.jdField_c_of_type_AndroidWidgetTextView.setText(paramagjf.jdField_c_of_type_JavaLangString);
      localagjg.jdField_a_of_type_AndroidViewViewGroup.setEnabled(true);
      continue;
      localagjg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localagjg.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(0);
      localagjg.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setProgress(paramagjf.jdField_c_of_type_Int);
      localagjg.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      label353:
      if ((i == 10) || (i == 11))
      {
        localagjg.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localagjg.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localagjg.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        FrameLayout.LayoutParams localLayoutParams;
        if (paramagjf.jdField_b_of_type_Boolean)
        {
          localagjg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localagjg.jdField_d_of_type_AndroidWidgetTextView.setText(paramagjf.d);
          localagjg.e.setText(paramagjf.e);
          localagjg.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(new agiw(this, paramagjf));
          localLayoutParams = (FrameLayout.LayoutParams)localagjg.jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
          switch (i)
          {
          }
        }
        for (;;)
        {
          localagjg.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
          break;
          localagjg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          break label406;
          localagjg.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
          localLayoutParams.bottomMargin = AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidContentResResources);
          continue;
          localagjg.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
          localagjg.f.setOnClickListener(new agix(this, paramagjf));
          localLayoutParams.bottomMargin = AIOUtils.a(0.0F, this.jdField_a_of_type_AndroidContentResResources);
        }
      }
      label406:
      if (i == 12)
      {
        localagjg.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localagjg.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localagjg.jdField_a_of_type_AndroidViewView.setVisibility(0);
        if (paramagjf.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$OcrClickListener != null)
        {
          localagjg.g.setOnClickListener(new agiy(this, paramagjf));
          localagjg.h.setOnClickListener(new agiz(this, paramagjf));
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
    ((ValueAnimator)localObject).addUpdateListener(new agja(this));
    ((ValueAnimator)localObject).addListener(new agjb(this));
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
      localValueAnimator.addUpdateListener(new agjc(this, localViewGroup));
      localValueAnimator.addListener(new agjd(this, localViewGroup));
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
      agjf localagjf = (agjf)this.jdField_a_of_type_AndroidViewViewGroup.getTag(2131362443);
      if (localagjf != null) {
        return localagjf.jdField_a_of_type_Int;
      }
    }
    return 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("dismissTips", new Object[0]));
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101).sendToTarget();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (paramInt == a()))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
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