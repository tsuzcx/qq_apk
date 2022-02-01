package com.tencent.mobileqq.olympic.activity;

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
    this.jdField_a_of_type_AndroidOsHandler = new ARTipsManager.CustomHandler(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$ARTipsVisibleListener = paramARTipsVisibleListener;
  }
  
  private ViewGroup a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, "createTipsView");
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558736, null);
    if (localViewGroup != null)
    {
      ARTipsManager.ViewHolder localViewHolder = new ARTipsManager.ViewHolder(this, null);
      localViewHolder.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362974));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362978));
      localViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362976));
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362975));
      localViewHolder.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress = ((ARTipsCircleProgress)localViewGroup.findViewById(2131362977));
      localViewHolder.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362962));
      localViewHolder.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362964));
      localViewHolder.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362966));
      localViewHolder.e = ((TextView)localViewGroup.findViewById(2131362965));
      localViewHolder.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362967));
      localViewHolder.f = ((TextView)localViewGroup.findViewById(2131362968));
      localViewHolder.jdField_a_of_type_AndroidViewView = localViewGroup.findViewById(2131362969);
      localViewHolder.g = ((TextView)localViewGroup.findViewById(2131362970));
      localViewHolder.h = ((TextView)localViewGroup.findViewById(2131362972));
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localViewGroup.findViewById(2131362963));
      localViewGroup.setTag(localViewHolder);
      localViewGroup.setOnTouchListener(new ARTipsManager.1(this));
    }
    return localViewGroup;
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
    ARTipsManager.TipsInfo localTipsInfo = new ARTipsManager.TipsInfo(this, null);
    localTipsInfo.jdField_a_of_type_Int = paramInt1;
    localTipsInfo.jdField_b_of_type_Int = paramInt2;
    localTipsInfo.jdField_a_of_type_Boolean = paramBoolean1;
    localTipsInfo.d = paramString1;
    localTipsInfo.e = paramString2;
    localTipsInfo.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$BaikeClickListener = paramBaikeClickListener;
    localTipsInfo.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localTipsInfo;
    paramString1.sendToTarget();
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, ARTipsManager.ButtonClickListener paramButtonClickListener, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showTips tag=%s type=%s tips=%s description=%s btnText=%s btnListener=%s progress=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramString3, paramButtonClickListener, Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) }));
    }
    ARTipsManager.TipsInfo localTipsInfo = new ARTipsManager.TipsInfo(this, null);
    localTipsInfo.jdField_a_of_type_Int = paramInt1;
    localTipsInfo.jdField_b_of_type_Int = paramInt2;
    localTipsInfo.jdField_a_of_type_Boolean = paramBoolean;
    localTipsInfo.jdField_a_of_type_JavaLangString = paramString1;
    localTipsInfo.jdField_b_of_type_JavaLangString = paramString2;
    localTipsInfo.jdField_c_of_type_JavaLangString = paramString3;
    localTipsInfo.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$ButtonClickListener = paramButtonClickListener;
    localTipsInfo.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localTipsInfo;
    paramString1.sendToTarget();
  }
  
  private void a(ARTipsManager.TipsInfo paramTipsInfo)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = a();
    }
    ARTipsManager.ViewHolder localViewHolder;
    int i;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131362973, paramTipsInfo);
      localViewHolder = (ARTipsManager.ViewHolder)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
      if (localViewHolder != null)
      {
        i = paramTipsInfo.jdField_b_of_type_Int;
        if ((i != 1) && (i != 2) && (i != 3)) {
          break label353;
        }
        localViewHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        localViewHolder.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramTipsInfo.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(paramTipsInfo.jdField_b_of_type_JavaLangString)) {
          break label213;
        }
        localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
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
      if (paramTipsInfo.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        paramTipsInfo = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramTipsInfo, 5000L);
      }
      return;
      label213:
      localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramTipsInfo.jdField_b_of_type_JavaLangString);
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 20.0F);
      break;
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localViewHolder.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramTipsInfo.jdField_c_of_type_JavaLangString);
      localViewHolder.jdField_a_of_type_AndroidViewViewGroup.setEnabled(true);
      continue;
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(0);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setProgress(paramTipsInfo.jdField_c_of_type_Int);
      localViewHolder.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      label353:
      if ((i == 10) || (i == 11))
      {
        localViewHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localViewHolder.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        FrameLayout.LayoutParams localLayoutParams;
        if (paramTipsInfo.jdField_b_of_type_Boolean)
        {
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(paramTipsInfo.d);
          localViewHolder.e.setText(paramTipsInfo.e);
          localViewHolder.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(new ARTipsManager.2(this, paramTipsInfo));
          localLayoutParams = (FrameLayout.LayoutParams)localViewHolder.jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
          switch (i)
          {
          }
        }
        for (;;)
        {
          localViewHolder.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
          break;
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          break label406;
          localViewHolder.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
          localLayoutParams.bottomMargin = AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidContentResResources);
          continue;
          localViewHolder.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
          localViewHolder.f.setOnClickListener(new ARTipsManager.3(this, paramTipsInfo));
          localLayoutParams.bottomMargin = AIOUtils.a(0.0F, this.jdField_a_of_type_AndroidContentResResources);
        }
      }
      label406:
      if (i == 12)
      {
        localViewHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localViewHolder.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        if (paramTipsInfo.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$OcrClickListener != null)
        {
          localViewHolder.g.setOnClickListener(new ARTipsManager.4(this, paramTipsInfo));
          localViewHolder.h.setOnClickListener(new ARTipsManager.5(this, paramTipsInfo));
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
    ((ValueAnimator)localObject).addUpdateListener(new ARTipsManager.6(this));
    ((ValueAnimator)localObject).addListener(new ARTipsManager.7(this));
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
      localValueAnimator.addUpdateListener(new ARTipsManager.8(this, localViewGroup));
      localValueAnimator.addListener(new ARTipsManager.9(this, localViewGroup));
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
      ARTipsManager.TipsInfo localTipsInfo = (ARTipsManager.TipsInfo)this.jdField_a_of_type_AndroidViewViewGroup.getTag(2131362973);
      if (localTipsInfo != null) {
        return localTipsInfo.jdField_a_of_type_Int;
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
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ARTipsManager
 * JD-Core Version:    0.7.0.1
 */