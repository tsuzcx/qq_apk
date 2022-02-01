package dov.com.qq.im.capture.view;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.ui.panel.AbsBottomPanal;
import dov.com.qq.im.capture.AbsQIMCaptureController;
import dov.com.qq.im.capture.util.QIMAnimationUtils;
import dov.com.qq.im.capture.util.QIMProviderViewBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@TargetApi(14)
public class QIMProviderContainerView
  extends AbsBottomPanal
{
  private float jdField_a_of_type_Float = 0.0F;
  public int a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new QIMProviderContainerView.1(this);
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private AbsQIMCaptureController jdField_a_of_type_DovComQqImCaptureAbsQIMCaptureController;
  private QIMProviderViewBuilder jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder;
  private ProviderView jdField_a_of_type_DovComQqImCaptureViewProviderView;
  private ArrayList<View> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Integer, ProviderView> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<QIMProviderContainerView.ContainerViewListener2> jdField_a_of_type_JavaUtilList = new ArrayList();
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  View c;
  public boolean c;
  private View d;
  public boolean d;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private boolean h = true;
  private boolean i = false;
  
  public QIMProviderContainerView(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    a();
  }
  
  public QIMProviderContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    a();
  }
  
  public QIMProviderContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    a();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131561009, null);
    addView(localView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131368617));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131373599));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131366594);
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131366593);
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131381114);
    this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder = new QIMProviderViewBuilder(0);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_c_of_type_AndroidViewView);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.d();
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView = null;
    }
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.c(paramInt))))
    {
      localObject = (ProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.c(paramInt)));
      if (localObject == null) {
        break label304;
      }
      if (!((ProviderView)localObject).jdField_d_of_type_Boolean)
      {
        ((ProviderView)localObject).setProviderViewListener(this.jdField_a_of_type_DovComQqImCaptureAbsQIMCaptureController);
        ((ProviderView)localObject).setDoodleEventListener(this.jdField_a_of_type_DovComQqImCaptureAbsQIMCaptureController);
        ((ProviderView)localObject).a(null);
      }
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView = ((ProviderView)localObject);
      if (paramBoolean) {
        break label305;
      }
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView.getId() != 2131364391) {
        this.jdField_a_of_type_DovComQqImCaptureAbsQIMCaptureController.b(false);
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        QIMProviderContainerView.ContainerViewListener2 localContainerViewListener2 = (QIMProviderContainerView.ContainerViewListener2)((Iterator)localObject).next();
        if (localContainerViewListener2 != null) {
          localContainerViewListener2.a(false);
        }
      }
      int j = this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.c(paramInt);
      localObject = this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.a(getContext(), j);
      if (localObject != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.c(paramInt)), localObject);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject);
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ProviderContainerView", 2, "build provider view failed " + paramInt);
      label304:
      return;
      label305:
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(8);
    }
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView.c();
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView.h = this.jdField_a_of_type_DovComQqImCaptureAbsQIMCaptureController.jdField_a_of_type_Int;
  }
  
  private void b()
  {
    ThreadManager.excute(new QIMProviderContainerView.7(this), 64, null, true);
  }
  
  private void b(boolean paramBoolean)
  {
    this.f = false;
    int j = UIUtils.a(getContext(), 88.0F);
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, j }));
    ((List)localObject1).add(ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "alpha", new float[] { 1.0F, 0.0F }));
    ((List)localObject1).add(QIMAnimationUtils.a(this.jdField_a_of_type_AndroidViewView, getResources().getColor(2131165497), 153, 0));
    ((List)localObject1).add(QIMAnimationUtils.a(this.jdField_b_of_type_AndroidViewView, getResources().getColor(2131165497), 153, 0));
    Object localObject2 = this.jdField_a_of_type_DovComQqImCaptureAbsQIMCaptureController.jdField_a_of_type_AndroidViewView.findViewById(2131381323);
    if (localObject2 != null) {
      ((List)localObject1).add(ObjectAnimator.ofFloat(localObject2, "translationY", new float[] { 0.0F, j }));
    }
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).playTogether((Collection)localObject1);
    ((AnimatorSet)localObject2).addListener(new QIMProviderContainerView.4(this));
    ((AnimatorSet)localObject2).setDuration(300L).start();
    localObject1 = QIMAnimationUtils.a(this.jdField_a_of_type_DovComQqImCaptureViewProviderView, 1.0F, 0.0F);
    ((Animation)localObject1).setStartOffset(0L);
    ((Animation)localObject1).setDuration(100L);
    ((Animation)localObject1).setAnimationListener(new QIMProviderContainerView.5(this, paramBoolean));
    startAnimation((Animation)localObject1);
  }
  
  private void c(int paramInt)
  {
    this.f = true;
    a(paramInt, true);
    paramInt = UIUtils.a(getContext(), 88.0F);
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(ObjectAnimator.ofFloat(this, "translationY", new float[] { paramInt, 0.0F }));
    ((List)localObject1).add(ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "alpha", new float[] { 0.0F, 1.0F }));
    ((List)localObject1).add(QIMAnimationUtils.a(this.jdField_a_of_type_AndroidViewView, getResources().getColor(2131165497), 0, 153));
    ((List)localObject1).add(QIMAnimationUtils.a(this.jdField_b_of_type_AndroidViewView, getResources().getColor(2131165497), 0, 153));
    Object localObject2 = this.jdField_a_of_type_DovComQqImCaptureAbsQIMCaptureController.jdField_a_of_type_AndroidViewView.findViewById(2131381323);
    if (localObject2 != null) {
      ((List)localObject1).add(ObjectAnimator.ofFloat(localObject2, "translationY", new float[] { paramInt, 0.0F }));
    }
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).playTogether((Collection)localObject1);
    ((AnimatorSet)localObject2).addListener(new QIMProviderContainerView.2(this));
    ((AnimatorSet)localObject2).setDuration(300L).start();
    localObject1 = QIMAnimationUtils.a(this.jdField_a_of_type_DovComQqImCaptureViewProviderView, 0.0F, 1.0F);
    ((Animation)localObject1).setStartOffset(200L);
    ((Animation)localObject1).setDuration(100L);
    ((Animation)localObject1).setAnimationListener(new QIMProviderContainerView.3(this));
    startAnimation((Animation)localObject1);
  }
  
  public void a(int paramInt)
  {
    int j = this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.d(paramInt);
    ProviderView localProviderView = this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.a(getContext(), paramInt);
    if (localProviderView != null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.c(j)), localProviderView);
      localProviderView.b(null);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localProviderView);
      localProviderView.setProviderViewListener(this.jdField_a_of_type_DovComQqImCaptureAbsQIMCaptureController);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!this.g) {
      if (QLog.isColorLevel()) {
        QLog.e("ProviderContainerView", 2, "doOpenProviderView failed isInflated" + this.g);
      }
    }
    do
    {
      return;
      if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ProviderContainerView", 2, "doOpenProviderView failed out bounds" + paramInt1 + " size:" + this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount());
    return;
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_d_of_type_AndroidViewView.setSelected(false);
      this.e = true;
    }
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt1);
    this.jdField_d_of_type_AndroidViewView.setSelected(true);
    this.jdField_a_of_type_Int = paramInt1;
    ((ImageView)this.jdField_d_of_type_AndroidViewView).setImageResource(this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.a(paramInt1));
    if (!this.e) {
      c(paramInt1);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_DovComQqImCaptureAbsQIMCaptureController != null) {
        this.jdField_a_of_type_DovComQqImCaptureAbsQIMCaptureController.a(paramInt1, paramBoolean);
      }
      this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.a(paramInt1);
      if (!paramBoolean) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProviderContainerView", 2, "openSpecificTabByWeb tab_index= " + paramInt1 + ",categoryId=" + paramInt2 + ",categoryName=" + paramString1 + "itemId=" + paramString2);
      }
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.a(paramInt2, paramString1, paramString2);
      return;
      a(paramInt1, false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, null, paramString, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_d_of_type_AndroidViewView.setSelected(false);
      this.jdField_d_of_type_AndroidViewView = null;
      this.e = false;
    }
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.d();
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView = null;
    }
    if (this.f) {
      b(paramBoolean);
    }
    this.i = false;
    if (QLog.isColorLevel()) {
      QLog.d("ProviderContainerView", 2, "panelOpened : " + this.i);
    }
  }
  
  public void b(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
    if ((this.jdField_d_of_type_AndroidViewView == null) || (this.jdField_d_of_type_AndroidViewView != localView)) {
      localView.performClick();
    }
  }
  
  public boolean b()
  {
    return !this.i;
  }
  
  public void d()
  {
    a(false);
  }
  
  public void setBackGroundAlpha(float paramFloat)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
        if (localView != null) {
          localView.setAlpha(paramFloat);
        }
      }
    }
  }
  
  public void setBeautyEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder != null) {
      this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.a(paramBoolean);
    }
  }
  
  public void setCaptureControllerAndPreloadView(AbsQIMCaptureController paramAbsQIMCaptureController)
  {
    this.jdField_a_of_type_DovComQqImCaptureAbsQIMCaptureController = paramAbsQIMCaptureController;
    this.g = true;
    if (QLog.isColorLevel()) {
      QLog.d("ProviderContainerView", 2, "preloadProviderView");
    }
  }
  
  public void setComboEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder != null) {
      this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.d(paramBoolean);
    }
  }
  
  public void setDpcEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder != null) {
      this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.f(paramBoolean);
    }
  }
  
  public void setFaceEffectEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder != null) {
      this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.c(paramBoolean);
    }
  }
  
  public void setFilterEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder != null) {
      this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.b(paramBoolean);
    }
  }
  
  public void setIsGuideMode(boolean paramBoolean)
  {
    MusicProviderView localMusicProviderView = (MusicProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(104));
    if (localMusicProviderView != null) {
      localMusicProviderView.setIsGuideMode(paramBoolean);
    }
  }
  
  public void setMusicEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder != null) {
      this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.e(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMProviderContainerView
 * JD-Core Version:    0.7.0.1
 */