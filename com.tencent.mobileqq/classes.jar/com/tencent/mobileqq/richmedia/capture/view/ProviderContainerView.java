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
import autp;
import auty;
import auuc;
import auvt;
import auvv;
import auvw;
import auvx;
import auvy;
import auvz;
import auwa;
import auwb;
import awkk;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import vms;

@TargetApi(11)
public class ProviderContainerView
  extends FrameLayout
  implements auvt
{
  private int jdField_a_of_type_Int = -1;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new auvv(this);
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private auty jdField_a_of_type_Auty;
  private auuc jdField_a_of_type_Auuc;
  private auwa jdField_a_of_type_Auwa;
  private auwb jdField_a_of_type_Auwb;
  private CameraCaptureButtonLayout jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout;
  private EffectsCameraCaptureView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
  private ProviderView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView;
  private HashMap<Integer, RedDotImageView> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<auwa> jdField_a_of_type_JavaUtilList;
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
    paramInt = vms.a(getContext(), 80.0F);
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).playTogether(new Animator[] { ObjectAnimator.ofFloat(this, "translationY", new float[] { paramInt, 0.0F }), autp.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, getResources().getColor(2131099854), 0, 153), autp.a(this.jdField_a_of_type_AndroidViewView, getResources().getColor(2131099854), 0, 153), autp.a(this.jdField_b_of_type_AndroidViewView, getResources().getColor(2131099854), 0, 153) });
    ((AnimatorSet)localObject).addListener(new auvw(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = autp.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new auvx(this));
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
    if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(this.jdField_a_of_type_Auuc.a(paramInt))))
    {
      localProviderView = (ProviderView)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Auuc.a(paramInt)));
      if ((localProviderView != null) && (!localProviderView.jdField_c_of_type_Boolean))
      {
        localProviderView.setProviderViewListener(this.jdField_a_of_type_Auty);
        localProviderView.setAppInterface(this.jdField_a_of_type_Auty.jdField_a_of_type_ComTencentCommonAppAppInterface);
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
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.aO_();
      return;
      int i = this.jdField_a_of_type_Auuc.a(paramInt);
      localProviderView = this.jdField_a_of_type_Auuc.a(getContext(), i);
      if (localProviderView != null)
      {
        if ((localProviderView instanceof auvt)) {
          ((auvt)localProviderView).setNeedAdvertisement(this.jdField_e_of_type_Boolean);
        }
        this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_Auuc.a(paramInt)), localProviderView);
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
          if ((paramInt == 102) && (!awkk.a(awkk.e))) {
            awkk.a(awkk.e);
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
          localObject = this.jdField_a_of_type_Auwa;
          if (localObject != null) {
            ((auwa)localObject).a(paramView, paramInt);
          }
          if (i != this.jdField_a_of_type_Int) {
            break label155;
          }
          a();
          this.jdField_a_of_type_Int = -1;
          return;
          this.jdField_a_of_type_Auuc.a(i);
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
            ((auwa)((Iterator)localObject).next()).a(paramView, paramInt);
          }
        }
      }
    }
  }
  
  private void b()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131495451, null);
    addView(localView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131302071));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131306357));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131300299);
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131300298);
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131306347);
    this.jdField_a_of_type_Auuc = new auuc(0);
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, vms.a(getContext(), 80.0F) });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObject, autp.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, getResources().getColor(2131099854), 153, 0), autp.a(this.jdField_a_of_type_AndroidViewView, getResources().getColor(2131099854), 153, 0), autp.a(this.jdField_b_of_type_AndroidViewView, getResources().getColor(2131099854), 153, 0) });
    localAnimatorSet.addListener(new auvy(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = autp.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new auvz(this, paramBoolean));
    startAnimation((Animation)localObject);
  }
  
  public int a(int paramInt)
  {
    return this.jdField_a_of_type_Auuc.b(paramInt);
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
    if (this.jdField_a_of_type_Auuc != null) {
      this.jdField_a_of_type_Auuc.a(paramBoolean);
    }
  }
  
  public void setContainerViewListener(auwa paramauwa)
  {
    this.jdField_a_of_type_Auwa = paramauwa;
  }
  
  public void setFaceEffectEnable(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Auuc != null) {
      this.jdField_a_of_type_Auuc.d(paramBoolean);
    }
  }
  
  public void setFilterEnable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Auuc != null) {
      this.jdField_a_of_type_Auuc.c(paramBoolean);
    }
  }
  
  public void setListenerController(auty paramauty)
  {
    this.jdField_a_of_type_Auty = paramauty;
    this.jdField_e_of_type_AndroidViewView = paramauty.jdField_a_of_type_AndroidViewView;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout = ((CameraCaptureButtonLayout)this.jdField_e_of_type_AndroidViewView.findViewById(2131298325));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView = ((EffectsCameraCaptureView)this.jdField_e_of_type_AndroidViewView.findViewById(2131298277));
  }
  
  public void setNeedAdvertisement(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setSubtitleEnable(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Auuc != null) {
      this.jdField_a_of_type_Auuc.b(paramBoolean);
    }
  }
  
  public void setTriggerLisener(auwb paramauwb)
  {
    this.jdField_a_of_type_Auwb = paramauwb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView
 * JD-Core Version:    0.7.0.1
 */