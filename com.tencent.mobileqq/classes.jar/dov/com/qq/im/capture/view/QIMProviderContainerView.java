package dov.com.qq.im.capture.view;

import alpo;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import axns;
import blly;
import blmf;
import blnl;
import blva;
import blvf;
import blwp;
import blwq;
import blwr;
import blws;
import blwt;
import blwu;
import blwv;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import xod;

public class QIMProviderContainerView
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  public int a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new blwp(this);
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private blly jdField_a_of_type_Blly;
  private blvf jdField_a_of_type_Blvf;
  private blwv jdField_a_of_type_Blwv;
  private ProviderView jdField_a_of_type_DovComQqImCaptureViewProviderView;
  private ArrayList<View> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Integer, ProviderView> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<axns> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  private List<blwu> jdField_b_of_type_JavaUtilList = new ArrayList();
  public boolean b;
  public View c;
  public boolean c;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g = true;
  private boolean h;
  private boolean i;
  
  public QIMProviderContainerView(Context paramContext)
  {
    super(paramContext);
    h();
  }
  
  public QIMProviderContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    h();
  }
  
  public QIMProviderContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    h();
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
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(this.jdField_a_of_type_Blvf.d(paramInt))))
    {
      localObject = (ProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Blvf.d(paramInt)));
      if (localObject == null) {
        break label313;
      }
      if (!((ProviderView)localObject).jdField_d_of_type_Boolean)
      {
        ((ProviderView)localObject).setProviderViewListener(this.jdField_a_of_type_Blly);
        ((ProviderView)localObject).setDoodleEventListener(this.jdField_a_of_type_Blly);
        ((ProviderView)localObject).a(null);
      }
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView = ((ProviderView)localObject);
      if (paramBoolean) {
        break label314;
      }
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView.getId() != 2131363941) {
        this.jdField_a_of_type_Blly.b(false);
      }
      localObject = this.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        blwu localblwu = (blwu)((Iterator)localObject).next();
        if (localblwu != null) {
          localblwu.a(false);
        }
      }
      int j = this.jdField_a_of_type_Blvf.d(paramInt);
      localObject = this.jdField_a_of_type_Blvf.a(getContext(), j);
      if (localObject != null)
      {
        ((ProviderView)localObject).setLiuHaiParentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_Blvf.d(paramInt)), localObject);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject);
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ProviderContainerView", 2, "build provider view failed " + paramInt);
      label313:
      return;
      label314:
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(8);
    }
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView.c();
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView.h = this.jdField_a_of_type_Blly.jdField_a_of_type_Int;
  }
  
  private void a(ImageView paramImageView, int paramInt)
  {
    paramInt = this.jdField_a_of_type_Blvf.d(paramInt);
    if (paramInt == 101) {
      paramImageView.setContentDescription(alpo.a(2131710194));
    }
    do
    {
      return;
      if (paramInt == 102)
      {
        paramImageView.setContentDescription(alpo.a(2131710200));
        return;
      }
      if (paramInt == 103)
      {
        paramImageView.setContentDescription(alpo.a(2131710198));
        return;
      }
      if (paramInt == 108)
      {
        paramImageView.setContentDescription(alpo.a(2131710196));
        return;
      }
      if (paramInt == 104)
      {
        paramImageView.setContentDescription(alpo.a(2131710197));
        return;
      }
    } while (paramInt != 105);
    paramImageView.setContentDescription(alpo.a(2131710199));
  }
  
  private void c(int paramInt)
  {
    this.e = true;
    a(paramInt, true);
    paramInt = xod.a(getContext(), 88.0F);
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(ObjectAnimator.ofFloat(this, "translationY", new float[] { paramInt, 0.0F }));
    ((List)localObject1).add(ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "alpha", new float[] { 0.0F, 1.0F }));
    ((List)localObject1).add(blva.a(this.jdField_a_of_type_AndroidViewView, getResources().getColor(2131165448), 0, 153));
    ((List)localObject1).add(blva.a(this.jdField_b_of_type_AndroidViewView, getResources().getColor(2131165448), 0, 153));
    Object localObject2 = this.jdField_a_of_type_Blly.jdField_a_of_type_AndroidViewView.findViewById(2131379617);
    if (localObject2 != null) {
      ((List)localObject1).add(ObjectAnimator.ofFloat(localObject2, "translationY", new float[] { paramInt, 0.0F }));
    }
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).playTogether((Collection)localObject1);
    ((AnimatorSet)localObject2).addListener(new blwq(this));
    ((AnimatorSet)localObject2).setDuration(300L).start();
    localObject1 = blva.a(this.jdField_a_of_type_DovComQqImCaptureViewProviderView, 0.0F, 1.0F);
    ((Animation)localObject1).setStartOffset(200L);
    ((Animation)localObject1).setDuration(100L);
    ((Animation)localObject1).setAnimationListener(new blwr(this));
    startAnimation((Animation)localObject1);
  }
  
  private void c(boolean paramBoolean)
  {
    this.e = false;
    int j = xod.a(getContext(), 88.0F);
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, j }));
    ((List)localObject1).add(ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "alpha", new float[] { 1.0F, 0.0F }));
    ((List)localObject1).add(blva.a(this.jdField_a_of_type_AndroidViewView, getResources().getColor(2131165448), 153, 0));
    ((List)localObject1).add(blva.a(this.jdField_b_of_type_AndroidViewView, getResources().getColor(2131165448), 153, 0));
    Object localObject2 = this.jdField_a_of_type_Blly.jdField_a_of_type_AndroidViewView.findViewById(2131379617);
    if (localObject2 != null) {
      ((List)localObject1).add(ObjectAnimator.ofFloat(localObject2, "translationY", new float[] { 0.0F, j }));
    }
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).playTogether((Collection)localObject1);
    ((AnimatorSet)localObject2).addListener(new blws(this));
    ((AnimatorSet)localObject2).setDuration(300L).start();
    localObject1 = blva.a(this.jdField_a_of_type_DovComQqImCaptureViewProviderView, 1.0F, 0.0F);
    ((Animation)localObject1).setStartOffset(0L);
    ((Animation)localObject1).setDuration(100L);
    ((Animation)localObject1).setAnimationListener(new blwt(this, paramBoolean));
    startAnimation((Animation)localObject1);
  }
  
  private void h()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131560735, null);
    addView(localView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131367820));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131372371));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131365985);
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131365984);
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131379433);
    this.jdField_a_of_type_Blvf = new blvf(0);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_c_of_type_AndroidViewView);
  }
  
  private void i()
  {
    ThreadManager.excute(new QIMProviderContainerView.7(this), 64, null, true);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Blvf.a();
  }
  
  public Bundle a()
  {
    Bundle localBundle1 = new Bundle();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      ProviderView localProviderView = (ProviderView)localIterator.next();
      Bundle localBundle2 = localProviderView.a();
      if (localBundle2 != null) {
        localBundle1.putBundle(localProviderView.getClass().getSimpleName(), localBundle2);
      }
    }
    return localBundle1;
  }
  
  public ProviderView a()
  {
    return this.jdField_a_of_type_DovComQqImCaptureViewProviderView;
  }
  
  public <T extends ProviderView> T a(Class<? extends ProviderView> paramClass)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).a();
    }
  }
  
  public void a(int paramInt)
  {
    int j = this.jdField_a_of_type_Blvf.e(paramInt);
    ProviderView localProviderView = this.jdField_a_of_type_Blvf.a(getContext(), paramInt);
    if (localProviderView != null)
    {
      localProviderView.setLiuHaiParentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_Blvf.d(j)), localProviderView);
      localProviderView.b(null);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localProviderView);
      localProviderView.setProviderViewListener(this.jdField_a_of_type_Blly);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProviderContainerView", 2, "openSpecificTabByCategoryId");
    }
    Intent localIntent = ((Activity)getContext()).getIntent();
    a(this.jdField_a_of_type_Blvf.e(paramInt1), paramInt2, paramString, true);
    localIntent.removeExtra("qim_camera_open_specific");
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!this.f) {
      if (QLog.isColorLevel()) {
        QLog.e("ProviderContainerView", 2, "doOpenProviderView failed isInflated" + this.f);
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
      this.jdField_d_of_type_Boolean = true;
    }
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt1);
    this.jdField_d_of_type_AndroidViewView.setSelected(true);
    this.jdField_a_of_type_Int = paramInt1;
    ((ImageView)this.jdField_d_of_type_AndroidViewView).setImageResource(this.jdField_a_of_type_Blvf.a(paramInt1));
    if (!this.jdField_d_of_type_Boolean) {
      c(paramInt1);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Blly != null) {
        this.jdField_a_of_type_Blly.a(paramInt1, paramBoolean);
      }
      this.jdField_a_of_type_Blvf.a(paramInt1);
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
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProviderContainerView", 2, "openSpecificTabByCategoryName");
    }
    if (((Activity)getContext()).getIntent().getIntExtra("entrance_type", 99) == 7) {
      a(this.jdField_a_of_type_Blvf.e(paramInt), -1, paramString1, paramString2, true);
    }
  }
  
  public void a(RedDotImageView paramRedDotImageView)
  {
    ThreadManager.excute(new QIMProviderContainerView.6(this, paramRedDotImageView), 64, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_d_of_type_AndroidViewView.setSelected(false);
      this.jdField_d_of_type_AndroidViewView = null;
      this.jdField_d_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.d();
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView = null;
    }
    if (this.e) {
      c(paramBoolean);
    }
    this.h = false;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        axns localaxns = (axns)localIterator.next();
        if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && ((localaxns instanceof blwu)))
        {
          if (!this.i) {
            localaxns.a();
          }
        }
        else {
          localaxns.a();
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProviderContainerView", 2, "panelOpened : " + this.h);
    }
  }
  
  public boolean a()
  {
    return !this.h;
  }
  
  public boolean a(Class<? extends ProviderView> paramClass)
  {
    paramClass = a(paramClass);
    return (this.jdField_a_of_type_DovComQqImCaptureViewProviderView != null) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderView == paramClass) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderView.getVisibility() == 0);
  }
  
  @TargetApi(11)
  public void b()
  {
    this.jdField_a_of_type_Blvf.a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int j = 0;
    while (j < this.jdField_a_of_type_Blvf.a())
    {
      localObject = new PressScaleImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, xod.a(getContext(), 44.0F));
      localLayoutParams.weight = 1.0F;
      localLayoutParams.gravity = 16;
      ((ImageView)localObject).setPadding(0, xod.a(getContext(), 9.0F), 0, xod.a(getContext(), 9.0F));
      ((ImageView)localObject).setTag(Integer.valueOf(j));
      ((ImageView)localObject).setId(this.jdField_a_of_type_Blvf.b(j));
      ((ImageView)localObject).setImageResource(this.jdField_a_of_type_Blvf.a(j));
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER);
      ((ImageView)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      a((ImageView)localObject, j);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, localLayoutParams);
      j += 1;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = xod.a(getContext(), 206.0F);
    setTranslationY(xod.a(getContext(), 88.0F));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void b(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
    if ((this.jdField_d_of_type_AndroidViewView == null) || (this.jdField_d_of_type_AndroidViewView != localView)) {
      localView.performClick();
    }
  }
  
  public void b(int paramInt1, int paramInt2, String paramString)
  {
    a(paramInt1, paramInt2, paramString, true);
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_Boolean == paramBoolean)) {}
    Object localObject3;
    Object localObject1;
    Object localObject2;
    Object localObject4;
    do
    {
      return;
      this.jdField_a_of_type_Boolean = paramBoolean;
      if ((this.jdField_a_of_type_Float == 0.0F) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 1)) {
        this.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).getX() - this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0).getX());
      }
      localObject3 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131373249);
      localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131373251);
      localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131373250);
      localObject4 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131373254);
      if (!paramBoolean) {
        break;
      }
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(8);
      }
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      if (localObject4 != null)
      {
        localObject1 = (LinearLayout.LayoutParams)((View)localObject4).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).weight = 3.0F;
        ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = (MusicProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(104));
    } while (localObject1 == null);
    if (!paramBoolean) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((MusicProviderView)localObject1).setChangeMusicEnabled(paramBoolean);
      return;
      if ((localObject3 == null) || (localObject1 == null) || (localObject2 == null) || (localObject4 == null) || (this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {
        break;
      }
      ((View)localObject3).setVisibility(0);
      ((View)localObject1).setVisibility(0);
      Object localObject5 = (LinearLayout.LayoutParams)((View)localObject4).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject5).weight = 1.0F;
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
      ((View)localObject2).setTranslationX(-this.jdField_a_of_type_Float);
      ((View)localObject4).setTranslationX(-this.jdField_a_of_type_Float);
      ((View)localObject3).setAlpha(0.0F);
      ((View)localObject1).setAlpha(0.0F);
      localObject2 = ObjectAnimator.ofFloat(localObject2, "translationX", new float[] { -this.jdField_a_of_type_Float, 0.0F });
      localObject4 = ObjectAnimator.ofFloat(localObject4, "translationX", new float[] { -this.jdField_a_of_type_Float, 0.0F });
      localObject3 = ObjectAnimator.ofFloat(localObject3, "alpha", new float[] { 0.0F, 1.0F });
      localObject1 = ObjectAnimator.ofFloat(localObject1, "alpha", new float[] { 0.0F, 1.0F });
      localObject5 = new AnimatorSet();
      ((AnimatorSet)localObject5).playTogether(new Animator[] { localObject3, localObject2, localObject1, localObject4 });
      ((AnimatorSet)localObject5).setDuration(400L).start();
      break;
    }
  }
  
  public void c()
  {
    a(false);
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)localIterator.next()).f();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).e();
    }
    localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      blwu localblwu = (blwu)localIterator.next();
      if (localblwu != null) {
        localblwu.a(true);
      }
    }
    if ((this.jdField_a_of_type_DovComQqImCaptureViewProviderView != null) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderView.getVisibility() == 0)) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.c();
    }
  }
  
  public void f()
  {
    this.g = true;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)localIterator.next()).b();
    }
    ((blnl)blmf.a(5)).a((Activity)getContext());
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProviderContainerView", 2, "openSpecificTabByOut");
    }
    Object localObject1 = ((Activity)getContext()).getIntent();
    int j = ((Intent)localObject1).getIntExtra("entrance_type", 99);
    boolean bool = ((Intent)localObject1).getBooleanExtra("qim_camera_open_specific", false);
    String str = ((Intent)localObject1).getStringExtra("video_tag_info");
    if (QLog.isColorLevel()) {
      QLog.i("ProviderContainerView", 2, "openSpecificTabByOut return " + j + ",openSpecific=" + bool + ",musicLabel =" + str);
    }
    if (((j == 8) || (j == 7) || (j == 103) || (j == 15)) && (bool))
    {
      j = ((Intent)localObject1).getIntExtra("firsttab", 0);
      k = ((Intent)localObject1).getIntExtra("secondtab", 0);
      str = ((Intent)localObject1).getStringExtra("itemid");
      a(this.jdField_a_of_type_Blvf.e(j), k, str, true);
      ((Intent)localObject1).removeExtra("qim_camera_open_specific");
    }
    Object localObject2;
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(str)) {
        try
        {
          localObject2 = new JSONObject(str);
          j = ((JSONObject)localObject2).optInt("music_type", -1);
          k = ((JSONObject)localObject2).optInt("music_id", -2);
          localObject1 = ((JSONObject)localObject2).optString("music_download_url");
          str = ((JSONObject)localObject2).optString("music_title");
          localObject2 = ((JSONObject)localObject2).optString("music_path");
          if ((j != 1) || (k == -2) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str)))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ProviderContainerView", 2, "json no music info musicTpe= " + j);
          }
        }
        catch (JSONException localJSONException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProviderContainerView", 2, "musicLabel cannot pasrse jsonObject");
          }
          localJSONException.printStackTrace();
          return;
        }
      }
    }
    MusicItemInfo localMusicItemInfo = new MusicItemInfo();
    localMusicItemInfo.mItemId = k;
    localMusicItemInfo.mType = 5;
    localMusicItemInfo.mUrl = localJSONException;
    localMusicItemInfo.mMusicName = str;
    localMusicItemInfo.musicStart = 0;
    int k = localMusicItemInfo.musicStart;
    if (this.jdField_a_of_type_Blly == null) {}
    for (j = 10000;; j = this.jdField_a_of_type_Blly.a())
    {
      localMusicItemInfo.musicEnd = (j + k);
      localMusicItemInfo.musicDuration = localMusicItemInfo.musicEnd;
      localMusicItemInfo.setPath((String)localObject2);
      ((MusicProviderView)a(MusicProviderView.class)).a(localMusicItemInfo);
      MusicProviderView.jdField_a_of_type_Boolean = true;
      return;
    }
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
    if (this.jdField_a_of_type_Blvf != null) {
      this.jdField_a_of_type_Blvf.a(paramBoolean);
    }
  }
  
  public void setBottomTabParentLH(RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
  }
  
  public void setCaptureControllerAndPreloadView(blly paramblly)
  {
    this.jdField_a_of_type_Blly = paramblly;
    this.f = true;
    if (QLog.isColorLevel()) {
      QLog.d("ProviderContainerView", 2, "preloadProviderView");
    }
  }
  
  public void setCloseEventTouch(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setComboEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Blvf != null) {
      this.jdField_a_of_type_Blvf.d(paramBoolean);
    }
  }
  
  public void setContainerViewListener(blwv paramblwv)
  {
    this.jdField_a_of_type_Blwv = paramblwv;
  }
  
  public void setDpcEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Blvf != null) {
      this.jdField_a_of_type_Blvf.f(paramBoolean);
    }
  }
  
  public void setFaceEffectEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Blvf != null) {
      this.jdField_a_of_type_Blvf.c(paramBoolean);
    }
  }
  
  public void setFilterEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Blvf != null) {
      this.jdField_a_of_type_Blvf.b(paramBoolean);
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
    if (this.jdField_a_of_type_Blvf != null) {
      this.jdField_a_of_type_Blvf.e(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMProviderContainerView
 * JD-Core Version:    0.7.0.1
 */