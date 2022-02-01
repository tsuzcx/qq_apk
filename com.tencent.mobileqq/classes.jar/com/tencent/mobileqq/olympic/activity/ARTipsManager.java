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
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558635, null);
    if (localViewGroup != null)
    {
      ARTipsManager.ViewHolder localViewHolder = new ARTipsManager.ViewHolder(this, null);
      localViewHolder.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362923));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362927));
      localViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362925));
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362924));
      localViewHolder.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress = ((ARTipsCircleProgress)localViewGroup.findViewById(2131362926));
      localViewHolder.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362911));
      localViewHolder.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362913));
      localViewHolder.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131362915));
      localViewHolder.e = ((TextView)localViewGroup.findViewById(2131362914));
      localViewHolder.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)localViewGroup.findViewById(2131362916));
      localViewHolder.f = ((TextView)localViewGroup.findViewById(2131362917));
      localViewHolder.jdField_a_of_type_AndroidViewView = localViewGroup.findViewById(2131362918);
      localViewHolder.g = ((TextView)localViewGroup.findViewById(2131362919));
      localViewHolder.h = ((TextView)localViewGroup.findViewById(2131362921));
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localViewGroup.findViewById(2131362912));
      localViewGroup.setTag(localViewHolder);
      localViewGroup.setOnTouchListener(new ARTipsManager.1(this));
    }
    return localViewGroup;
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
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject != null)
    {
      ((ViewGroup)localObject).setTag(2131362922, paramTipsInfo);
      localObject = (ARTipsManager.ViewHolder)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
      if (localObject != null)
      {
        int i = paramTipsInfo.jdField_b_of_type_Int;
        if ((i != 1) && (i != 2) && (i != 3))
        {
          if ((i != 10) && (i != 11))
          {
            if (i == 12)
            {
              ((ARTipsManager.ViewHolder)localObject).jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
              ((ARTipsManager.ViewHolder)localObject).jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
              ((ARTipsManager.ViewHolder)localObject).jdField_a_of_type_AndroidViewView.setVisibility(0);
              if (paramTipsInfo.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$OcrClickListener != null)
              {
                ((ARTipsManager.ViewHolder)localObject).g.setOnClickListener(new ARTipsManager.4(this, paramTipsInfo));
                ((ARTipsManager.ViewHolder)localObject).h.setOnClickListener(new ARTipsManager.5(this, paramTipsInfo));
              }
            }
          }
          else
          {
            ((ARTipsManager.ViewHolder)localObject).jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
            ((ARTipsManager.ViewHolder)localObject).jdField_a_of_type_AndroidViewView.setVisibility(8);
            ((ARTipsManager.ViewHolder)localObject).jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
            if (paramTipsInfo.jdField_b_of_type_Boolean) {
              ((ARTipsManager.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            } else {
              ((ARTipsManager.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
            }
            ((ARTipsManager.ViewHolder)localObject).jdField_d_of_type_AndroidWidgetTextView.setText(paramTipsInfo.d);
            ((ARTipsManager.ViewHolder)localObject).e.setText(paramTipsInfo.e);
            ((ARTipsManager.ViewHolder)localObject).jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(new ARTipsManager.2(this, paramTipsInfo));
            FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)((ARTipsManager.ViewHolder)localObject).jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
            if (i != 10)
            {
              if (i == 11)
              {
                ((ARTipsManager.ViewHolder)localObject).jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
                ((ARTipsManager.ViewHolder)localObject).f.setOnClickListener(new ARTipsManager.3(this, paramTipsInfo));
                localLayoutParams.bottomMargin = AIOUtils.b(0.0F, this.jdField_a_of_type_AndroidContentResResources);
              }
            }
            else
            {
              ((ARTipsManager.ViewHolder)localObject).jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
              localLayoutParams.bottomMargin = AIOUtils.b(20.0F, this.jdField_a_of_type_AndroidContentResResources);
            }
            ((ARTipsManager.ViewHolder)localObject).jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
          }
        }
        else
        {
          ((ARTipsManager.ViewHolder)localObject).jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
          ((ARTipsManager.ViewHolder)localObject).jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
          ((ARTipsManager.ViewHolder)localObject).jdField_a_of_type_AndroidViewView.setVisibility(8);
          ((ARTipsManager.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramTipsInfo.jdField_a_of_type_JavaLangString);
          if (TextUtils.isEmpty(paramTipsInfo.jdField_b_of_type_JavaLangString))
          {
            ((ARTipsManager.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            ((ARTipsManager.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
          }
          else
          {
            ((ARTipsManager.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            ((ARTipsManager.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setText(paramTipsInfo.jdField_b_of_type_JavaLangString);
            ((ARTipsManager.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 20.0F);
          }
          if (i != 1)
          {
            if (i != 2)
            {
              if (i == 3)
              {
                ((ARTipsManager.ViewHolder)localObject).jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
                ((ARTipsManager.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(0);
                ((ARTipsManager.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setProgress(paramTipsInfo.jdField_c_of_type_Int);
                ((ARTipsManager.ViewHolder)localObject).jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
              }
            }
            else
            {
              ((ARTipsManager.ViewHolder)localObject).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
              ((ARTipsManager.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
              ((ARTipsManager.ViewHolder)localObject).jdField_c_of_type_AndroidWidgetTextView.setText(paramTipsInfo.jdField_c_of_type_JavaLangString);
              ((ARTipsManager.ViewHolder)localObject).jdField_a_of_type_AndroidViewViewGroup.setEnabled(true);
            }
          }
          else
          {
            ((ARTipsManager.ViewHolder)localObject).jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            ((ARTipsManager.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsCircleProgress.setVisibility(8);
            ((ARTipsManager.ViewHolder)localObject).jdField_a_of_type_AndroidViewViewGroup.setEnabled(false);
          }
        }
        if (this.jdField_a_of_type_AndroidViewViewGroup.getParent() == null) {
          b();
        }
        if (paramTipsInfo.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
          paramTipsInfo = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101);
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramTipsInfo, 5000L);
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
    localObject = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$ARTipsVisibleListener;
    if (localObject != null) {
      ((ARTipsManager.ARTipsVisibleListener)localObject).a(true);
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, "removeTipsWithAnim");
    }
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = null;
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.setDuration(400L);
      localValueAnimator.addUpdateListener(new ARTipsManager.8(this, (View)localObject));
      localValueAnimator.addListener(new ARTipsManager.9(this, (View)localObject));
      localValueAnimator.start();
      localObject = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$ARTipsVisibleListener;
      if (localObject != null) {
        ((ARTipsManager.ARTipsVisibleListener)localObject).a(false);
      }
    }
  }
  
  public int a()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject != null)
    {
      localObject = (ARTipsManager.TipsInfo)((ViewGroup)localObject).getTag(2131362922);
      if (localObject != null) {
        return ((ARTipsManager.TipsInfo)localObject).jdField_a_of_type_Int;
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
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    return (localViewGroup != null) && (localViewGroup.getVisibility() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ARTipsManager
 * JD-Core Version:    0.7.0.1
 */