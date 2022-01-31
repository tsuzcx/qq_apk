package com.tencent.mobileqq.olympic.activity;

import agej;
import agek;
import agel;
import agem;
import agen;
import ageo;
import agep;
import ageq;
import ager;
import ages;
import aget;
import ageu;
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
    this.jdField_a_of_type_AndroidOsHandler = new ages(this);
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
      ageu localageu = new ageu(this, null);
      localageu.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131363284));
      localageu.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131363285));
      localageu.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131363286));
      localageu.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131363287));
      localageu.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress = ((ARTipsCircleProgress)localViewGroup.findViewById(2131363288));
      localageu.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131363289));
      localageu.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131363290));
      localageu.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131363291));
      localageu.e = ((TextView)localViewGroup.findViewById(2131363293));
      localageu.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131363294));
      localageu.f = ((TextView)localViewGroup.findViewById(2131363295));
      localageu.jdField_a_of_type_AndroidViewView = localViewGroup.findViewById(2131363296);
      localageu.g = ((TextView)localViewGroup.findViewById(2131363299));
      localageu.h = ((TextView)localViewGroup.findViewById(2131363298));
      localageu.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localViewGroup.findViewById(2131363292));
      localViewGroup.setTag(localageu);
      localViewGroup.setOnTouchListener(new agej(this));
    }
    return localViewGroup;
  }
  
  private void a(int paramInt1, int paramInt2, ARTipsManager.OcrClickListener paramOcrClickListener, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showOcr tag=%s type=%s listener=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramOcrClickListener, Boolean.valueOf(paramBoolean) }));
    }
    aget localaget = new aget(this, null);
    localaget.jdField_a_of_type_Int = paramInt1;
    localaget.jdField_b_of_type_Int = paramInt2;
    localaget.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$OcrClickListener = paramOcrClickListener;
    localaget.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramOcrClickListener = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramOcrClickListener.obj = localaget;
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
    aget localaget = new aget(this, null);
    localaget.jdField_a_of_type_Int = paramInt1;
    localaget.jdField_b_of_type_Int = paramInt2;
    localaget.jdField_a_of_type_Boolean = paramBoolean1;
    localaget.d = paramString1;
    localaget.e = paramString2;
    localaget.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$BaikeClickListener = paramBaikeClickListener;
    localaget.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localaget;
    paramString1.sendToTarget();
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, ARTipsManager.ButtonClickListener paramButtonClickListener, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showTips tag=%s type=%s tips=%s description=%s btnText=%s btnListener=%s progress=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramString3, paramButtonClickListener, Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) }));
    }
    aget localaget = new aget(this, null);
    localaget.jdField_a_of_type_Int = paramInt1;
    localaget.jdField_b_of_type_Int = paramInt2;
    localaget.jdField_a_of_type_Boolean = paramBoolean;
    localaget.jdField_a_of_type_JavaLangString = paramString1;
    localaget.jdField_b_of_type_JavaLangString = paramString2;
    localaget.jdField_c_of_type_JavaLangString = paramString3;
    localaget.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$ButtonClickListener = paramButtonClickListener;
    localaget.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(100);
    paramString1.obj = localaget;
    paramString1.sendToTarget();
  }
  
  private void a(aget paramaget)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = a();
    }
    ageu localageu;
    int i;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131362440, paramaget);
      localageu = (ageu)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
      if (localageu != null)
      {
        i = paramaget.jdField_b_of_type_Int;
        if ((i != 1) && (i != 2) && (i != 3)) {
          break label353;
        }
        localageu.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        localageu.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localageu.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localageu.jdField_a_of_type_AndroidWidgetTextView.setText(paramaget.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(paramaget.jdField_b_of_type_JavaLangString)) {
          break label213;
        }
        localageu.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        localageu.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
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
      if (paramaget.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        paramaget = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramaget, 5000L);
      }
      return;
      label213:
      localageu.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localageu.jdField_b_of_type_AndroidWidgetTextView.setText(paramaget.jdField_b_of_type_JavaLangString);
      localageu.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 20.0F);
      break;
      localageu.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localageu.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localageu.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      localageu.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localageu.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
      localageu.jdField_c_of_type_AndroidWidgetTextView.setText(paramaget.jdField_c_of_type_JavaLangString);
      localageu.jdField_a_of_type_AndroidViewViewGroup.setEnabled(true);
      continue;
      localageu.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localageu.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(0);
      localageu.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setProgress(paramaget.jdField_c_of_type_Int);
      localageu.jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
      continue;
      label353:
      if ((i == 10) || (i == 11))
      {
        localageu.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localageu.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localageu.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        FrameLayout.LayoutParams localLayoutParams;
        if (paramaget.jdField_b_of_type_Boolean)
        {
          localageu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localageu.jdField_d_of_type_AndroidWidgetTextView.setText(paramaget.d);
          localageu.e.setText(paramaget.e);
          localageu.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(new agek(this, paramaget));
          localLayoutParams = (FrameLayout.LayoutParams)localageu.jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
          switch (i)
          {
          }
        }
        for (;;)
        {
          localageu.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
          break;
          localageu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          break label406;
          localageu.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
          localLayoutParams.bottomMargin = AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidContentResResources);
          continue;
          localageu.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
          localageu.f.setOnClickListener(new agel(this, paramaget));
          localLayoutParams.bottomMargin = AIOUtils.a(0.0F, this.jdField_a_of_type_AndroidContentResResources);
        }
      }
      label406:
      if (i == 12)
      {
        localageu.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localageu.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localageu.jdField_a_of_type_AndroidViewView.setVisibility(0);
        if (paramaget.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$OcrClickListener != null)
        {
          localageu.g.setOnClickListener(new agem(this, paramaget));
          localageu.h.setOnClickListener(new agen(this, paramaget));
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
    ((ValueAnimator)localObject).addUpdateListener(new ageo(this));
    ((ValueAnimator)localObject).addListener(new agep(this));
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
      localValueAnimator.addUpdateListener(new ageq(this, localViewGroup));
      localValueAnimator.addListener(new ager(this, localViewGroup));
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
      aget localaget = (aget)this.jdField_a_of_type_AndroidViewViewGroup.getTag(2131362440);
      if (localaget != null) {
        return localaget.jdField_a_of_type_Int;
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