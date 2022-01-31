package dov.com.qq.im.capture.view;

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
import anpr;
import anps;
import anpt;
import anpu;
import anpv;
import anpw;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMCaptureController;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.util.QIMAnimationUtils;
import dov.com.qq.im.capture.util.QIMProviderViewBuilder;
import dov.com.qq.im.setting.IProviderContainerOperator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class QIMProviderContainerView
  extends FrameLayout
  implements IProviderContainerOperator
{
  private float jdField_a_of_type_Float;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new anpr(this);
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public LinearLayout a;
  private QIMCaptureController jdField_a_of_type_DovComQqImCaptureQIMCaptureController;
  private QIMProviderViewBuilder jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder;
  private ProviderView jdField_a_of_type_DovComQqImCaptureViewProviderView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  public View c;
  public boolean c;
  private View d;
  public boolean d;
  public boolean e = true;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i = true;
  
  public QIMProviderContainerView(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    i();
  }
  
  public QIMProviderContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    i();
  }
  
  public QIMProviderContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    i();
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    if (!this.h) {
      if (QLog.isColorLevel()) {
        QLog.e("ProviderContainerView", 2, "doOpenProviderView failed isInflated" + this.h);
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
      this.f = true;
    }
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt1);
    this.jdField_d_of_type_AndroidViewView.setSelected(true);
    this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.a(paramInt1);
    ((ImageView)this.jdField_d_of_type_AndroidViewView).setImageResource(this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.a(paramInt1));
    if (!this.f) {
      b(paramInt1);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController != null) {
        this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.a(paramInt1, paramBoolean);
      }
      if (!paramBoolean) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProviderContainerView", 2, "openSpecificTabByWeb tab_index= " + paramInt1 + ",categoryId=" + paramInt2 + "itemId=" + paramString);
      }
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.a(paramInt2, paramString);
      return;
      a(paramInt1, false);
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.b();
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView = null;
    }
    ProviderView localProviderView;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.d(paramInt))))
    {
      localProviderView = (ProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.d(paramInt)));
      if (!localProviderView.jdField_d_of_type_Boolean)
      {
        localProviderView.setDoodleEventListener(this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController);
        localProviderView.a(null);
      }
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView = localProviderView;
      if (paramBoolean) {
        break label241;
      }
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView.getId() != 2131362418) {
        this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.d(false);
      }
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.a();
      return;
      int j = this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.d(paramInt);
      localProviderView = this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.a(getContext(), j);
      if (localProviderView != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.d(paramInt)), localProviderView);
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ProviderContainerView", 2, "build provider view failed " + paramInt);
      return;
      label241:
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(8);
    }
  }
  
  @TargetApi(12)
  private void b(int paramInt)
  {
    this.g = true;
    a(paramInt, true);
    paramInt = UIUtils.a(getContext(), 88.0F);
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).playTogether(new Animator[] { ObjectAnimator.ofFloat(this, "translationY", new float[] { paramInt, 0.0F }), QIMAnimationUtils.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, getResources().getColor(2131492879), 0, 153), QIMAnimationUtils.a(this.jdField_a_of_type_AndroidViewView, getResources().getColor(2131492879), 0, 153), QIMAnimationUtils.a(this.jdField_b_of_type_AndroidViewView, getResources().getColor(2131492879), 0, 153) });
    ((AnimatorSet)localObject).addListener(new anps(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = QIMAnimationUtils.a(this.jdField_a_of_type_DovComQqImCaptureViewProviderView, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new anpt(this));
    startAnimation((Animation)localObject);
  }
  
  private void c(boolean paramBoolean)
  {
    this.g = false;
    Object localObject = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, UIUtils.a(getContext(), 88.0F) });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObject, QIMAnimationUtils.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, getResources().getColor(2131492879), 153, 0), QIMAnimationUtils.a(this.jdField_a_of_type_AndroidViewView, getResources().getColor(2131492879), 153, 0), QIMAnimationUtils.a(this.jdField_b_of_type_AndroidViewView, getResources().getColor(2131492879), 153, 0) });
    localAnimatorSet.addListener(new anpu(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = QIMAnimationUtils.a(this.jdField_a_of_type_DovComQqImCaptureViewProviderView, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new anpv(this, paramBoolean));
    startAnimation((Animation)localObject);
  }
  
  private void i()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2130970124, null);
    addView(localView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131369120));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131364450));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131369121);
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131369122);
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131369123);
    this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder = new QIMProviderViewBuilder(0);
    this.jdField_a_of_type_Boolean = ((Activity)getContext()).getIntent().getBooleanExtra("qim_camera_open_specific", false);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_c_of_type_AndroidViewView);
  }
  
  private void j()
  {
    ThreadManager.post(new anpw(this), 8, null, true);
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
  
  public ProviderView a(Class paramClass)
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
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).c();
    }
  }
  
  public void a(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
    if ((this.jdField_d_of_type_AndroidViewView == null) || (this.jdField_d_of_type_AndroidViewView != localView)) {
      localView.performClick();
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
    a(paramInt1, paramInt2, paramString, true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_d_of_type_AndroidViewView.setSelected(false);
      this.jdField_d_of_type_AndroidViewView = null;
      this.f = false;
    }
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.b();
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView = null;
    }
    if (this.g) {
      c(paramBoolean);
    }
  }
  
  public boolean a(Class paramClass)
  {
    paramClass = a(paramClass);
    return (this.jdField_a_of_type_DovComQqImCaptureViewProviderView == paramClass) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderView.getVisibility() == 0);
  }
  
  @TargetApi(11)
  public void b()
  {
    this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int j = 0;
    while (j < this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.a())
    {
      localObject = new PressScaleImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, UIUtils.a(getContext(), 44.0F));
      localLayoutParams.weight = 1.0F;
      localLayoutParams.gravity = 16;
      ((ImageView)localObject).setPadding(0, UIUtils.a(getContext(), 9.0F), 0, UIUtils.a(getContext(), 9.0F));
      ((ImageView)localObject).setTag(Integer.valueOf(j));
      ((ImageView)localObject).setId(this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.b(j));
      ((ImageView)localObject).setImageResource(this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.a(j));
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER);
      ((ImageView)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, localLayoutParams);
      j += 1;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = UIUtils.a(getContext(), 206.0F);
    setTranslationY(UIUtils.a(getContext(), 88.0F));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_b_of_type_Boolean == paramBoolean)) {}
    Object localObject3;
    Object localObject1;
    Object localObject2;
    Object localObject4;
    do
    {
      return;
      this.jdField_b_of_type_Boolean = paramBoolean;
      if ((this.jdField_a_of_type_Float == 0.0F) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 1)) {
        this.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).getX() - this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0).getX());
      }
      localObject3 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131362493);
      localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131362497);
      localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131362494);
      localObject4 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131362495);
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
      if ((localObject3 == null) || (localObject1 == null) || (localObject2 == null) || (localObject4 == null)) {
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
  
  void c()
  {
    int j = 0;
    if (j < this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.a())
    {
      int k = this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.d(j);
      ProviderView localProviderView = this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.a(getContext(), k);
      if (localProviderView != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.d(j)), localProviderView);
        localProviderView.b(null);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localProviderView);
        localProviderView.setProviderViewListener(this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController);
      }
      while (!QLog.isColorLevel())
      {
        j += 1;
        break;
      }
      QLog.e("ProviderContainerView", 2, "preloadProviderView failed " + j);
    }
  }
  
  public void d()
  {
    a(false);
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)localIterator.next()).f();
    }
  }
  
  public void f()
  {
    j();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).e();
    }
    if ((this.jdField_a_of_type_DovComQqImCaptureViewProviderView != null) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderView.getVisibility() == 0)) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.a();
    }
  }
  
  public void g()
  {
    this.i = true;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)localIterator.next()).g();
    }
    ((CaptureComboManager)QIMManager.a(5)).a((Activity)getContext());
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProviderContainerView", 2, "openSpecificTabByOut");
    }
    Object localObject1 = ((Activity)getContext()).getIntent();
    int j = ((Intent)localObject1).getIntExtra("take_video_entrance_type", 99);
    boolean bool = ((Intent)localObject1).getBooleanExtra("qim_camera_open_specific", false);
    Object localObject2 = ((Intent)localObject1).getStringExtra("video_tag_info");
    if (QLog.isColorLevel()) {
      QLog.i("ProviderContainerView", 2, "openSpecificTabByWeb return " + j + ",openSpecific=" + bool + ",musicLabel =" + (String)localObject2);
    }
    if (((j == 8) || (j == 7)) && (bool))
    {
      j = ((Intent)localObject1).getIntExtra("firsttab", 0);
      k = ((Intent)localObject1).getIntExtra("secondtab", 0);
      localObject2 = ((Intent)localObject1).getStringExtra("itemid");
      a(this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.e(j), k, (String)localObject2, true);
      ((Intent)localObject1).removeExtra("qim_camera_open_specific");
    }
    for (;;)
    {
      return;
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (j == 15)) {
        try
        {
          localObject2 = new JSONObject((String)localObject2);
          j = ((JSONObject)localObject2).optInt("music_type", -1);
          k = ((JSONObject)localObject2).optInt("music_id", -2);
          localObject1 = ((JSONObject)localObject2).optString("music_download_url");
          localObject2 = ((JSONObject)localObject2).optString("music_title");
          if ((j != 1) || (k == -2) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)))
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
    localMusicItemInfo.jdField_a_of_type_Int = k;
    localMusicItemInfo.d = 5;
    localMusicItemInfo.c = localJSONException;
    localMusicItemInfo.jdField_a_of_type_JavaLangString = ((String)localObject2);
    localMusicItemInfo.e = 0;
    int k = localMusicItemInfo.e;
    if (this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController == null) {}
    for (j = 10000;; j = this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.a())
    {
      localMusicItemInfo.f = (j + k);
      localMusicItemInfo.g = localMusicItemInfo.f;
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
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder != null) {
      this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.a(paramBoolean);
    }
  }
  
  public void setCaptureControllerAndPreloadView(QIMCaptureController paramQIMCaptureController)
  {
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController = paramQIMCaptureController;
    c();
    this.h = true;
    if (QLog.isColorLevel()) {
      QLog.d("ProviderContainerView", 2, "preloadProviderView");
    }
  }
  
  public void setDpcEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder != null) {
      this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.d(paramBoolean);
    }
  }
  
  public void setFaceEffectEnable(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder != null) {
      this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.c(paramBoolean);
    }
  }
  
  public void setFilterEnable(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder != null) {
      this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.b(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMProviderContainerView
 * JD-Core Version:    0.7.0.1
 */