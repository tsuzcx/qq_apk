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
import bbgc;
import bbgl;
import bbgp;
import bbio;
import bbiq;
import bbir;
import bbis;
import bbit;
import bbiu;
import bbiv;
import bbiw;
import bdcy;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import zps;

@TargetApi(11)
public class ProviderContainerView
  extends FrameLayout
  implements bbio
{
  private int jdField_a_of_type_Int = -1;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bbiq(this);
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private bbgl jdField_a_of_type_Bbgl;
  private bbgp jdField_a_of_type_Bbgp;
  private bbiv jdField_a_of_type_Bbiv;
  private bbiw jdField_a_of_type_Bbiw;
  private CameraCaptureButtonLayout jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout;
  private EffectsCameraCaptureView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
  private ProviderView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView;
  private HashMap<Integer, RedDotImageView> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<bbiv> jdField_a_of_type_JavaUtilList;
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
    paramInt = zps.a(getContext(), 80.0F);
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).playTogether(new Animator[] { ObjectAnimator.ofFloat(this, "translationY", new float[] { paramInt, 0.0F }), bbgc.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, getResources().getColor(2131165483), 0, 153), bbgc.a(this.jdField_a_of_type_AndroidViewView, getResources().getColor(2131165483), 0, 153), bbgc.a(this.jdField_b_of_type_AndroidViewView, getResources().getColor(2131165483), 0, 153) });
    ((AnimatorSet)localObject).addListener(new bbir(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = bbgc.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new bbis(this));
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
    if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(this.jdField_a_of_type_Bbgp.a(paramInt))))
    {
      localProviderView = (ProviderView)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Bbgp.a(paramInt)));
      if ((localProviderView != null) && (!localProviderView.jdField_c_of_type_Boolean))
      {
        localProviderView.setProviderViewListener(this.jdField_a_of_type_Bbgl);
        localProviderView.setAppInterface(this.jdField_a_of_type_Bbgl.jdField_a_of_type_ComTencentCommonAppAppInterface);
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
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.aI_();
      return;
      int i = this.jdField_a_of_type_Bbgp.a(paramInt);
      localProviderView = this.jdField_a_of_type_Bbgp.a(getContext(), i);
      if (localProviderView != null)
      {
        if ((localProviderView instanceof bbio)) {
          ((bbio)localProviderView).setNeedAdvertisement(this.jdField_e_of_type_Boolean);
        }
        this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_Bbgp.a(paramInt)), localProviderView);
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
          if ((paramInt == 102) && (!bdcy.a(bdcy.e))) {
            bdcy.a(bdcy.e);
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
          localObject = this.jdField_a_of_type_Bbiv;
          if (localObject != null) {
            ((bbiv)localObject).a(paramView, paramInt);
          }
          if (i != this.jdField_a_of_type_Int) {
            break label155;
          }
          a();
          this.jdField_a_of_type_Int = -1;
          return;
          this.jdField_a_of_type_Bbgp.a(i);
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
            ((bbiv)((Iterator)localObject).next()).a(paramView, paramInt);
          }
        }
      }
    }
  }
  
  private void b()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131561506, null);
    addView(localView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131368226));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131373097));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131366288);
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131366287);
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131373087);
    this.jdField_a_of_type_Bbgp = new bbgp(0);
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, zps.a(getContext(), 80.0F) });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObject, bbgc.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, getResources().getColor(2131165483), 153, 0), bbgc.a(this.jdField_a_of_type_AndroidViewView, getResources().getColor(2131165483), 153, 0), bbgc.a(this.jdField_b_of_type_AndroidViewView, getResources().getColor(2131165483), 153, 0) });
    localAnimatorSet.addListener(new bbit(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = bbgc.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new bbiu(this, paramBoolean));
    startAnimation((Animation)localObject);
  }
  
  public int a(int paramInt)
  {
    return this.jdField_a_of_type_Bbgp.b(paramInt);
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
    if (this.jdField_a_of_type_Bbgp != null) {
      this.jdField_a_of_type_Bbgp.a(paramBoolean);
    }
  }
  
  public void setContainerViewListener(bbiv parambbiv)
  {
    this.jdField_a_of_type_Bbiv = parambbiv;
  }
  
  public void setFaceEffectEnable(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Bbgp != null) {
      this.jdField_a_of_type_Bbgp.d(paramBoolean);
    }
  }
  
  public void setFilterEnable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Bbgp != null) {
      this.jdField_a_of_type_Bbgp.c(paramBoolean);
    }
  }
  
  public void setListenerController(bbgl parambbgl)
  {
    this.jdField_a_of_type_Bbgl = parambbgl;
    this.jdField_e_of_type_AndroidViewView = parambbgl.jdField_a_of_type_AndroidViewView;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout = ((CameraCaptureButtonLayout)this.jdField_e_of_type_AndroidViewView.findViewById(2131364184));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView = ((EffectsCameraCaptureView)this.jdField_e_of_type_AndroidViewView.findViewById(2131364134));
  }
  
  public void setNeedAdvertisement(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setSubtitleEnable(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Bbgp != null) {
      this.jdField_a_of_type_Bbgp.b(paramBoolean);
    }
  }
  
  public void setTriggerLisener(bbiw parambbiw)
  {
    this.jdField_a_of_type_Bbiw = parambbiw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView
 * JD-Core Version:    0.7.0.1
 */