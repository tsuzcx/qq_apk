package com.tencent.mobileqq.richmedia.capture.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import axkz;
import axli;
import axlm;
import axnl;
import axnn;
import axno;
import axnp;
import axnq;
import axnr;
import axns;
import axnt;
import azey;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import xod;

@TargetApi(11)
public class ProviderContainerView
  extends FrameLayout
  implements axnl
{
  private int jdField_a_of_type_Int = -1;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new axnn(this);
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private axli jdField_a_of_type_Axli;
  private axlm jdField_a_of_type_Axlm;
  private axns jdField_a_of_type_Axns;
  private axnt jdField_a_of_type_Axnt;
  private CameraCaptureButtonLayout jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout;
  private EffectsCameraCaptureView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
  private ProviderView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView;
  private HashMap<Integer, RedDotImageView> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<axns> jdField_a_of_type_JavaUtilList;
  public boolean a;
  View jdField_b_of_type_AndroidViewView;
  private HashMap<Integer, ProviderView> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  public boolean b;
  public View c;
  public boolean c;
  private View d;
  public boolean d;
  private View jdField_e_of_type_AndroidViewView;
  boolean jdField_e_of_type_Boolean = true;
  private boolean f;
  
  public ProviderContainerView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    b();
  }
  
  public ProviderContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    b();
  }
  
  public ProviderContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    b();
  }
  
  @TargetApi(12)
  private void a(int paramInt)
  {
    a(paramInt, true);
    paramInt = xod.a(getContext(), 80.0F);
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).playTogether(new Animator[] { ObjectAnimator.ofFloat(this, "translationY", new float[] { paramInt, 0.0F }), axkz.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, getResources().getColor(2131165448), 0, 153), axkz.a(this.jdField_a_of_type_AndroidViewView, getResources().getColor(2131165448), 0, 153), axkz.a(this.jdField_b_of_type_AndroidViewView, getResources().getColor(2131165448), 0, 153) });
    ((AnimatorSet)localObject).addListener(new axno(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = axkz.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new axnp(this));
    startAnimation((Animation)localObject);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.c();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.setVisibility(8);
    }
    ProviderView localProviderView;
    if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(this.jdField_a_of_type_Axlm.a(paramInt))))
    {
      localProviderView = (ProviderView)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Axlm.a(paramInt)));
      if ((localProviderView != null) && (!localProviderView.jdField_c_of_type_Boolean))
      {
        localProviderView.setProviderViewListener(this.jdField_a_of_type_Axli);
        localProviderView.setAppInterface(this.jdField_a_of_type_Axli.jdField_a_of_type_ComTencentCommonAppAppInterface);
        localProviderView.a(null);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView = localProviderView;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView != null)
      {
        if (paramBoolean) {
          break label273;
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.setAlpha(1.0F);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.aM_();
      return;
      int i = this.jdField_a_of_type_Axlm.a(paramInt);
      localProviderView = this.jdField_a_of_type_Axlm.a(getContext(), i);
      if (localProviderView != null)
      {
        if ((localProviderView instanceof axnl)) {
          ((axnl)localProviderView).setNeedAdvertisement(this.jdField_e_of_type_Boolean);
        }
        this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_Axlm.a(paramInt)), localProviderView);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localProviderView);
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ProviderContainerView", 2, "build provider view failed " + paramInt);
      return;
      label273:
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.setVisibility(8);
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      int i = a(paramInt);
      if (i != -1)
      {
        if (this.jdField_d_of_type_AndroidViewView != null)
        {
          this.jdField_d_of_type_AndroidViewView.setSelected(false);
          this.f = true;
        }
        this.jdField_d_of_type_AndroidViewView = paramView;
        this.jdField_d_of_type_AndroidViewView.setSelected(true);
        if ((paramView instanceof RedDotImageView))
        {
          ((RedDotImageView)paramView).a(false);
          if ((paramInt == 102) && (!azey.a(azey.e))) {
            azey.a(azey.e);
          }
        }
        else
        {
          if (this.f) {
            break label146;
          }
          a(i);
        }
        Object localObject;
        for (;;)
        {
          localObject = this.jdField_a_of_type_Axns;
          if (localObject != null) {
            ((axns)localObject).a(paramView, paramInt);
          }
          if (i != this.jdField_a_of_type_Int) {
            break label155;
          }
          a();
          this.jdField_a_of_type_Int = -1;
          return;
          this.jdField_a_of_type_Axlm.a(i);
          break;
          label146:
          a(i, false);
        }
        label155:
        if ((this.jdField_a_of_type_Int == -1) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout != null)) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.a(true, 150);
        }
        this.jdField_a_of_type_Int = i;
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          localObject = this.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((axns)((Iterator)localObject).next()).a(paramView, paramInt);
          }
        }
      }
    }
  }
  
  private void b()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131561223, null);
    addView(localView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131367820));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131372371));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131365985);
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131365984);
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131372361);
    this.jdField_a_of_type_Axlm = new axlm(0);
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, xod.a(getContext(), 80.0F) });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObject, axkz.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, getResources().getColor(2131165448), 153, 0), axkz.a(this.jdField_a_of_type_AndroidViewView, getResources().getColor(2131165448), 153, 0), axkz.a(this.jdField_b_of_type_AndroidViewView, getResources().getColor(2131165448), 153, 0) });
    localAnimatorSet.addListener(new axnq(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = axkz.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new axnr(this, paramBoolean));
    startAnimation((Animation)localObject);
  }
  
  public int a(int paramInt)
  {
    return this.jdField_a_of_type_Axlm.b(paramInt);
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_d_of_type_AndroidViewView.setSelected(false);
      this.jdField_d_of_type_AndroidViewView = null;
      this.f = false;
      b(paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.c();
    }
    this.jdField_a_of_type_Int = -1;
  }
  
  public void setBeautyEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Axlm != null) {
      this.jdField_a_of_type_Axlm.a(paramBoolean);
    }
  }
  
  public void setContainerViewListener(axns paramaxns)
  {
    this.jdField_a_of_type_Axns = paramaxns;
  }
  
  public void setFaceEffectEnable(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Axlm != null) {
      this.jdField_a_of_type_Axlm.d(paramBoolean);
    }
  }
  
  public void setFilterEnable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Axlm != null) {
      this.jdField_a_of_type_Axlm.c(paramBoolean);
    }
  }
  
  public void setListenerController(axli paramaxli)
  {
    this.jdField_a_of_type_Axli = paramaxli;
    this.jdField_e_of_type_AndroidViewView = paramaxli.jdField_a_of_type_AndroidViewView;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout = ((CameraCaptureButtonLayout)this.jdField_e_of_type_AndroidViewView.findViewById(2131363938));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView = ((EffectsCameraCaptureView)this.jdField_e_of_type_AndroidViewView.findViewById(2131363888));
  }
  
  public void setNeedAdvertisement(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setSubtitleEnable(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Axlm != null) {
      this.jdField_a_of_type_Axlm.b(paramBoolean);
    }
  }
  
  public void setTriggerLisener(axnt paramaxnt)
  {
    this.jdField_a_of_type_Axnt = paramaxnt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView
 * JD-Core Version:    0.7.0.1
 */