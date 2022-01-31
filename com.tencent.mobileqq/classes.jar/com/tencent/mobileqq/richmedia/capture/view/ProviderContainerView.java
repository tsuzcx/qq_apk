package com.tencent.mobileqq.richmedia.capture.view;

import ahmk;
import ahml;
import ahmm;
import ahmn;
import ahmo;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategory;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.data.TemplateGroupItem;
import com.tencent.mobileqq.richmedia.capture.util.CaptureAnimationUtils;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmedia.capture.util.EffectsListenerController;
import com.tencent.mobileqq.richmedia.capture.util.ProviderViewBuilder;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

@TargetApi(11)
public class ProviderContainerView
  extends FrameLayout
  implements ISupportAdvertisement
{
  private int jdField_a_of_type_Int = -1;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ahmk(this);
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private EffectsListenerController jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilEffectsListenerController;
  private ProviderViewBuilder jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder;
  private CameraCaptureButtonLayout jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout;
  private EffectsCameraCaptureView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
  private ProviderContainerView.ContainerViewListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView$ContainerViewListener;
  private ProviderContainerView.OnProviderContainerTriggerLisener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView$OnProviderContainerTriggerLisener;
  private ProviderView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List jdField_a_of_type_JavaUtilList;
  public boolean a;
  View jdField_b_of_type_AndroidViewView;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
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
    h();
  }
  
  public ProviderContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    h();
  }
  
  public ProviderContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    h();
  }
  
  @TargetApi(12)
  private void a(int paramInt)
  {
    a(paramInt, true);
    paramInt = UIUtils.a(getContext(), 80.0F);
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).playTogether(new Animator[] { ObjectAnimator.ofFloat(this, "translationY", new float[] { paramInt, 0.0F }), CaptureAnimationUtils.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, getResources().getColor(2131492879), 0, 153), CaptureAnimationUtils.a(this.jdField_a_of_type_AndroidViewView, getResources().getColor(2131492879), 0, 153), CaptureAnimationUtils.a(this.jdField_b_of_type_AndroidViewView, getResources().getColor(2131492879), 0, 153) });
    ((AnimatorSet)localObject).addListener(new ahml(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = CaptureAnimationUtils.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new ahmm(this));
    startAnimation((Animation)localObject);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.f();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.setVisibility(8);
    }
    ProviderView localProviderView;
    if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder.b(paramInt))))
    {
      localProviderView = (ProviderView)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder.b(paramInt)));
      if ((localProviderView != null) && (!localProviderView.jdField_c_of_type_Boolean))
      {
        localProviderView.setProviderViewListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilEffectsListenerController);
        localProviderView.setAppInterface(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilEffectsListenerController.jdField_a_of_type_ComTencentCommonAppAppInterface);
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
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.ai_();
      return;
      int i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder.b(paramInt);
      localProviderView = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder.a(getContext(), i);
      if (localProviderView != null)
      {
        if ((localProviderView instanceof ISupportAdvertisement)) {
          ((ISupportAdvertisement)localProviderView).setNeedAdvertisement(this.jdField_e_of_type_Boolean);
        }
        this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder.b(paramInt)), localProviderView);
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
          if ((paramInt == 102) && (!RedBagVideoManager.a(RedBagVideoManager.e))) {
            RedBagVideoManager.a(RedBagVideoManager.e);
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
          localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView$ContainerViewListener;
          if (localObject != null) {
            ((ProviderContainerView.ContainerViewListener)localObject).a(paramView, paramInt);
          }
          if (i != this.jdField_a_of_type_Int) {
            break label155;
          }
          e();
          this.jdField_a_of_type_Int = -1;
          return;
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder.a(i);
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
            ((ProviderContainerView.ContainerViewListener)((Iterator)localObject).next()).a(paramView, paramInt);
          }
        }
      }
    }
  }
  
  private void a(RedDotImageView paramRedDotImageView, int paramInt)
  {
    paramInt = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder.b(paramInt);
    if (paramInt == 101) {
      paramRedDotImageView.setContentDescription("滤镜");
    }
    do
    {
      return;
      if (paramInt == 102)
      {
        paramRedDotImageView.setContentDescription("挂件");
        return;
      }
      if (paramInt == 103)
      {
        paramRedDotImageView.setContentDescription("美颜");
        return;
      }
    } while (paramInt != 104);
    paramRedDotImageView.setContentDescription(getResources().getText(2131439114));
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, UIUtils.a(getContext(), 80.0F) });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObject, CaptureAnimationUtils.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, getResources().getColor(2131492879), 153, 0), CaptureAnimationUtils.a(this.jdField_a_of_type_AndroidViewView, getResources().getColor(2131492879), 153, 0), CaptureAnimationUtils.a(this.jdField_b_of_type_AndroidViewView, getResources().getColor(2131492879), 153, 0) });
    localAnimatorSet.addListener(new ahmn(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = CaptureAnimationUtils.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new ahmo(this, paramBoolean));
    startAnimation((Animation)localObject);
  }
  
  private void h()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2130970581, null);
    addView(localView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131369120));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131364450));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131369121);
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131369122);
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131371221);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder = new ProviderViewBuilder(0);
  }
  
  public int a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder.c(paramInt);
  }
  
  public ProviderView a(Class paramClass)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      ProviderView localProviderView = (ProviderView)localIterator.next();
      if (paramClass.isInstance(localProviderView)) {
        return localProviderView;
      }
    }
    return null;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).b();
    }
  }
  
  public void a(float paramFloat)
  {
    View localView = (View)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(103));
    if ((localView != null) && ((localView instanceof BeautyProviderView)) && (CaptureUtil.jdField_a_of_type_Int == 1)) {
      ((BeautyProviderView)localView).setBeautyLevel(paramFloat);
    }
    while (CaptureUtil.jdField_a_of_type_Int == 1) {
      return;
    }
    QLog.i("ProviderContainerView", 2, "changeBeautyLevel failed PTV_FILTER_SO_LOADED: " + CaptureUtil.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    int i = a(paramInt1);
    if (i == -1) {}
    ProviderView localProviderView;
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramInt1 != 101) && (paramInt1 != 102) && (paramInt1 != 103));
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout != null) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.a();
        }
        a((View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)), paramInt1);
        localProviderView = (ProviderView)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
        if (paramInt1 != 101) {
          break;
        }
      } while (!(localProviderView instanceof FilterProviderView));
      localObject2 = CaptureVideoFilterManager.a().b();
      localObject1 = localObject2;
      if (((List)localObject2).isEmpty())
      {
        CaptureVideoFilterManager.a().b();
        localObject1 = CaptureVideoFilterManager.a().b();
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FilterCategoryItem)((Iterator)localObject1).next();
        FilterCategory localFilterCategory = CaptureVideoFilterManager.a().a(((FilterCategoryItem)localObject2).b);
        if ((localFilterCategory != null) && (localFilterCategory.jdField_a_of_type_Int == paramInt2) && (TextUtils.equals(((FilterCategoryItem)localObject2).jdField_a_of_type_JavaLangString, paramString)) && (!((FilterCategoryItem)localObject2).a())) {
          ((FilterProviderView)localProviderView).a((FilterCategoryItem)localObject2);
        }
      }
      ((FilterProviderView)localProviderView).setTab(paramInt2);
      return;
    } while ((paramInt1 != 102) || (!(localProviderView instanceof PtvTemplateProviderView)));
    Object localObject2 = CapturePtvTemplateManager.a().a();
    Object localObject1 = localObject2;
    if (((ArrayList)localObject2).isEmpty())
    {
      CapturePtvTemplateManager.a().b(true);
      localObject1 = CapturePtvTemplateManager.a().a();
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TemplateGroupItem)((Iterator)localObject1).next();
      if (((TemplateGroupItem)localObject2).jdField_a_of_type_Int == paramInt2)
      {
        localObject1 = ((TemplateGroupItem)localObject2).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject1).next();
          if (((PtvTemplateManager.PtvTemplateInfo)localObject2).id.equals(paramString))
          {
            CapturePtvTemplateManager.a().a((PtvTemplateManager.PtvTemplateInfo)localObject2);
            paramString = CapturePtvTemplateManager.a(((PtvTemplateManager.PtvTemplateInfo)localObject2).name, ((PtvTemplateManager.PtvTemplateInfo)localObject2).md5);
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFaceEffect(paramString);
          }
        }
      }
    }
    ((PtvTemplateProviderView)localProviderView).setTab(paramInt2);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    int i = a(paramInt);
    if (i == -1) {}
    label13:
    ProviderView localProviderView;
    do
    {
      do
      {
        do
        {
          break label13;
          do
          {
            return;
          } while ((paramInt != 101) && (paramInt != 102) && (paramInt != 103));
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout != null) {
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.a();
          }
          a((View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)), paramInt);
        } while (TextUtils.isEmpty(paramString1));
        localProviderView = (ProviderView)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
        if (paramInt != 101) {
          break;
        }
      } while (!(localProviderView instanceof FilterProviderView));
      localObject2 = CaptureVideoFilterManager.a().b();
      localObject1 = localObject2;
      if (((List)localObject2).isEmpty())
      {
        CaptureVideoFilterManager.a().b();
        localObject1 = CaptureVideoFilterManager.a().b();
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FilterCategoryItem)((Iterator)localObject1).next();
        FilterCategory localFilterCategory = CaptureVideoFilterManager.a().a(((FilterCategoryItem)localObject2).b);
        if ((localFilterCategory != null) && (TextUtils.equals(localFilterCategory.jdField_a_of_type_JavaLangString, paramString1)) && (TextUtils.equals(((FilterCategoryItem)localObject2).jdField_a_of_type_JavaLangString, paramString2)) && (!((FilterCategoryItem)localObject2).a())) {
          ((FilterProviderView)localProviderView).a((FilterCategoryItem)localObject2);
        }
      }
      ((FilterProviderView)localProviderView).setTab(paramString1);
      return;
    } while ((paramInt != 102) || (!(localProviderView instanceof PtvTemplateProviderView)));
    Object localObject2 = CapturePtvTemplateManager.a().a();
    Object localObject1 = localObject2;
    if (((ArrayList)localObject2).isEmpty())
    {
      CapturePtvTemplateManager.a().b(true);
      localObject1 = CapturePtvTemplateManager.a().a();
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TemplateGroupItem)((Iterator)localObject1).next();
      if (TextUtils.equals(((TemplateGroupItem)localObject2).jdField_a_of_type_JavaLangString, paramString1))
      {
        localObject1 = ((TemplateGroupItem)localObject2).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject1).next();
          if (((PtvTemplateManager.PtvTemplateInfo)localObject2).id.equals(paramString2)) {
            CapturePtvTemplateManager.a().a((PtvTemplateManager.PtvTemplateInfo)localObject2);
          }
        }
      }
    }
    ((PtvTemplateProviderView)localProviderView).setTab(paramString1);
  }
  
  public void a(ProviderContainerView.ContainerViewListener paramContainerViewListener)
  {
    if (paramContainerViewListener == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramContainerViewListener);
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
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.f();
    }
    this.jdField_a_of_type_Int = -1;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == -1;
  }
  
  @TargetApi(11)
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder.a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder.a())
    {
      localObject = new RedDotImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(AIOUtils.a(36.0F, getContext().getResources()), AIOUtils.a(36.0F, getContext().getResources()));
      localLayoutParams.weight = 1.0F;
      localLayoutParams.gravity = 17;
      ((RedDotImageView)localObject).setTag(Integer.valueOf(i));
      ((RedDotImageView)localObject).setImageResource(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder.a(i));
      ((RedDotImageView)localObject).setRedDotBase(0);
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder.b(i) == 102) && (!RedBagVideoManager.a(RedBagVideoManager.e)))
      {
        ((RedDotImageView)localObject).setReddotXOffsetDp(12);
        ((RedDotImageView)localObject).setReddotYOffsetDp(8);
        ((RedDotImageView)localObject).setRedDotDrawable(getResources().getDrawable(2130845579));
      }
      ((RedDotImageView)localObject).a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder.a(i));
      ((RedDotImageView)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      a((RedDotImageView)localObject, i);
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, localLayoutParams);
      i += 1;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = UIUtils.a(getContext(), 206.0F);
    setTranslationY(UIUtils.a(getContext(), 80.0F));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void b(ProviderContainerView.ContainerViewListener paramContainerViewListener)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramContainerViewListener == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramContainerViewListener);
  }
  
  public void c()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      ((RedDotImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i)).a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder.a(i));
      i += 1;
    }
  }
  
  public void d()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder.a())
    {
      if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder.b(i)))) {}
      label129:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          int j = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder.b(i);
          ProviderView localProviderView = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder.a(getContext(), j);
          if (localProviderView == null) {
            break label129;
          }
          if ((localProviderView instanceof ISupportAdvertisement)) {
            ((ISupportAdvertisement)localProviderView).setNeedAdvertisement(this.jdField_e_of_type_Boolean);
          }
          this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder.b(i)), localProviderView);
          localProviderView.b(null);
          localProviderView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localProviderView);
        }
      } while (!QLog.isColorLevel());
      QLog.e("ProviderContainerView", 2, "preloadProviderView failed " + i);
    }
  }
  
  public void e()
  {
    a(false);
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)localIterator.next()).e();
    }
  }
  
  public void g()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)localIterator.next()).d();
    }
  }
  
  public void setBeautyEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder.a(paramBoolean);
    }
  }
  
  public void setContainerViewListener(ProviderContainerView.ContainerViewListener paramContainerViewListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView$ContainerViewListener = paramContainerViewListener;
  }
  
  public void setFaceEffectEnable(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder.d(paramBoolean);
    }
  }
  
  public void setFilterEnable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder.c(paramBoolean);
    }
  }
  
  public void setListenerController(EffectsListenerController paramEffectsListenerController)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilEffectsListenerController = paramEffectsListenerController;
    this.jdField_e_of_type_AndroidViewView = paramEffectsListenerController.jdField_a_of_type_AndroidViewView;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout = ((CameraCaptureButtonLayout)this.jdField_e_of_type_AndroidViewView.findViewById(2131368954));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView = ((EffectsCameraCaptureView)this.jdField_e_of_type_AndroidViewView.findViewById(2131366945));
  }
  
  public void setNeedAdvertisement(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setSubtitleEnable(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilProviderViewBuilder.b(paramBoolean);
    }
  }
  
  public void setTriggerLisener(ProviderContainerView.OnProviderContainerTriggerLisener paramOnProviderContainerTriggerLisener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView$OnProviderContainerTriggerLisener = paramOnProviderContainerTriggerLisener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView
 * JD-Core Version:    0.7.0.1
 */