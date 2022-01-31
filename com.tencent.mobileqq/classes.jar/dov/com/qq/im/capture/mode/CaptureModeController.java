package dov.com.qq.im.capture.mode;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import avvb;
import bbkx;
import bdsn;
import bify;
import bihg;
import bihi;
import bjai;
import bjaj;
import bjcl;
import bjcm;
import bjcn;
import bjcp;
import bjct;
import bjcx;
import bjlq;
import bjqx;
import bjqz;
import bjrh;
import blbz;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import dov.com.qq.im.capture.adapter.CaptureModeAdapter;
import dov.com.tencent.mobileqq.richmedia.capture.view.DragAnimationMgr;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraStoryCaptureButtonLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import ste;
import vel;

public class CaptureModeController
  implements ViewPager.OnPageChangeListener, avvb, bjaj
{
  protected int a;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  public ViewGroup a;
  public bify a;
  private bjcl jdField_a_of_type_Bjcl;
  private bjqx jdField_a_of_type_Bjqx;
  private CaptureModeAdapter jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter;
  private HashMap<Integer, bjcl> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<bjai> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  private boolean b;
  
  public CaptureModeController(bify parambify)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Bify = parambify;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_Bify.a();
  }
  
  public bjcl a()
  {
    return this.jdField_a_of_type_Bjcl;
  }
  
  public bjcp a()
  {
    if ((this.jdField_a_of_type_Bify instanceof bihg)) {}
    for (bjcp localbjcp1 = (bjcp)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0));; localbjcp1 = (bjcp)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1)))
    {
      bjcp localbjcp2 = localbjcp1;
      if (localbjcp1 == null) {
        localbjcp2 = new bjcp(this);
      }
      return localbjcp2;
    }
  }
  
  public bjct a()
  {
    bjct localbjct2 = (bjct)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2));
    bjct localbjct1 = localbjct2;
    if (localbjct2 == null) {
      localbjct1 = new bjct(this);
    }
    return localbjct1;
  }
  
  public bjcx a()
  {
    bjcx localbjcx2 = (bjcx)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(4));
    bjcx localbjcx1 = localbjcx2;
    if (localbjcx2 == null) {
      localbjcx1 = new bjcx(this);
    }
    return localbjcx1;
  }
  
  public bjqx a()
  {
    return this.jdField_a_of_type_Bjqx;
  }
  
  public bjrh a()
  {
    bjrh localbjrh2 = (bjrh)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(5));
    bjrh localbjrh1 = localbjrh2;
    if (localbjrh2 == null) {
      localbjrh1 = new bjrh(this);
    }
    return localbjrh1;
  }
  
  public void a()
  {
    Object localObject2 = this.jdField_a_of_type_Bify.a().getIntent().getIntegerArrayListExtra("support_intent_mode");
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(Integer.valueOf(bjcn.a(((Integer)((Iterator)localObject2).next()).intValue())));
      }
    }
    long l;
    for (;;)
    {
      l = System.currentTimeMillis();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Integer)((Iterator)localObject1).next();
        bjcl localbjcl = bjcn.a(((Integer)localObject2).intValue(), this);
        if (localbjcl.b())
        {
          this.jdField_a_of_type_JavaUtilList.add(new bjai(((Integer)localObject2).intValue()));
          this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, localbjcl);
        }
      }
      localObject1 = this.jdField_a_of_type_Bify.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("CaptureModeController", 2, "initCaptureMode use = " + (System.currentTimeMillis() - l));
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Bify.d();
    if ((this.jdField_a_of_type_Int == 5) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(5)))) {
      this.jdField_a_of_type_Int = 0;
    }
    this.jdField_a_of_type_Bify.b = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Bjcl = ((bjcl)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int)));
    this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(7));
  }
  
  public void a(int paramInt, View paramView)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(paramInt);
  }
  
  public void a(View paramView, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131363891));
    if (paramBoolean)
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      localLayoutParams.topMargin = bbkx.a(8.0F);
      localLayoutParams.addRule(10, -1);
      localLayoutParams.addRule(12, 0);
      paramRelativeLayout.addView(this.jdField_a_of_type_AndroidViewViewGroup, localLayoutParams);
      paramRelativeLayout = (ImageView)paramView.findViewById(2131375525);
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setVisibility(0);
      }
      paramRelativeLayout = (ImageView)paramView.findViewById(2131375523);
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setVisibility(0);
      }
    }
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)paramView.findViewById(2131363886));
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    int k = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int i = j;
    if (blbz.a(j, k)) {
      i = k * 9 / 16;
    }
    i = (i - bbkx.a(53.0F)) / 2;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setPadding(i, 0, i, 0);
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter = new CaptureModeAdapter(paramView.getContext());
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOffscreenPageLimit(this.jdField_a_of_type_JavaUtilList.size());
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(this);
    paramRelativeLayout = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (paramRelativeLayout.hasNext()) {
      ((bjcl)((Map.Entry)paramRelativeLayout.next()).getValue()).a(paramView);
    }
    paramBoolean = this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(5));
    boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(7));
    if ((paramBoolean) || (bool))
    {
      this.jdField_a_of_type_Bjqx = new bjqx();
      this.jdField_a_of_type_Bjqx.a();
      if ((this.jdField_a_of_type_Bify.a() instanceof EffectsCameraCaptureView))
      {
        paramRelativeLayout = (EffectsCameraCaptureView)this.jdField_a_of_type_Bify.a();
        paramRelativeLayout.setFilterInitedListener(this);
        if (paramRelativeLayout.a == null) {
          break label527;
        }
        ste.a().dispatch(new bjqz(2, true));
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_JavaUtilList.size() == 1) && ((((bjai)this.jdField_a_of_type_JavaUtilList.get(0)).a() == 0) || (((bjai)this.jdField_a_of_type_JavaUtilList.get(0)).a() == 10)))
      {
        ((ImageView)paramView.findViewById(2131363887)).setVisibility(4);
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(4);
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
        this.jdField_a_of_type_Bify.v();
      }
      return;
      label527:
      paramRelativeLayout.setOnSurfaceCreatedListener(new bjcm(this));
    }
  }
  
  public void a(View paramView, RelativeLayout paramRelativeLayout1, boolean paramBoolean, RelativeLayout paramRelativeLayout2)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131363891));
    if (paramBoolean)
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      paramRelativeLayout2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramRelativeLayout2.topMargin = bbkx.a(8.0F);
      paramRelativeLayout2.addRule(10, -1);
      paramRelativeLayout2.addRule(12, 0);
      paramRelativeLayout1.addView(this.jdField_a_of_type_AndroidViewViewGroup, paramRelativeLayout2);
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131375525);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(0);
      }
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131375523);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(0);
      }
    }
    while ((this.jdField_a_of_type_JavaUtilList.size() == 1) && (((bjai)this.jdField_a_of_type_JavaUtilList.get(0)).a() == 0))
    {
      ((ImageView)paramView.findViewById(2131363887)).setVisibility(4);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_Bify.v();
      return;
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      paramRelativeLayout1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramRelativeLayout1.topMargin = bbkx.a(0.0F);
      paramRelativeLayout1.bottomMargin = bbkx.a(0.0F);
      paramRelativeLayout1.addRule(10, 0);
      paramRelativeLayout1.addRule(12, -1);
      paramRelativeLayout2.addView(this.jdField_a_of_type_AndroidViewViewGroup, paramRelativeLayout1);
      this.jdField_a_of_type_AndroidViewViewGroup.bringToFront();
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131375525);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(8);
      }
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131375523);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(8);
      }
    }
    ((ImageView)paramView.findViewById(2131363887)).setVisibility(0);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
  }
  
  public void a(boolean paramBoolean)
  {
    if (bdsn.b.get()) {
      ste.a().dispatch(new bjqz(1, paramBoolean));
    }
    ste.a().dispatch(new bjqz(3, true));
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt));
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bjcl.c();
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("CaptureModeController", 2, new Object[] { "setSegmentModeEnabled, ", Boolean.valueOf(paramBoolean) });
    }
    if ((this.jdField_a_of_type_Bify instanceof bihg))
    {
      if ((this.jdField_a_of_type_Bify instanceof bihi)) {
        paramBoolean = false;
      }
      ((bihg)this.jdField_a_of_type_Bify).a.setEnableSegment(paramBoolean);
      return;
    }
    int i = this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(0);
    int j = this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(1);
    Object localObject = this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter;
    if (!paramBoolean)
    {
      ((CaptureModeAdapter)localObject).a(i, bool);
      this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(j, paramBoolean);
      localObject = this.jdField_a_of_type_AndroidSupportV4ViewViewPager;
      if (!paramBoolean) {
        break label140;
      }
      i = j;
    }
    label140:
    for (;;)
    {
      ((ViewPager)localObject).setCurrentItem(i, false);
      return;
      bool = false;
      break;
    }
  }
  
  public void c()
  {
    this.b = false;
    this.jdField_a_of_type_Bjcl.d();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup.getTranslationY() != 0.0F)
    {
      if (paramBoolean) {
        DragAnimationMgr.a(this.jdField_a_of_type_AndroidViewViewGroup, null);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setTranslationY(0.0F);
    this.jdField_a_of_type_AndroidViewViewGroup.setAlpha(1.0F);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Bjcl.e();
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup.getTranslationY() == 0.0F)
    {
      if (paramBoolean) {
        DragAnimationMgr.b(this.jdField_a_of_type_AndroidViewViewGroup, null);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setTranslationY(this.jdField_a_of_type_AndroidViewViewGroup.getHeight());
    this.jdField_a_of_type_AndroidViewViewGroup.setAlpha(0.0F);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Bjcl.f();
    if (this.jdField_a_of_type_Bjqx != null)
    {
      this.jdField_a_of_type_Bjqx.b();
      this.jdField_a_of_type_Bjqx = null;
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(this.jdField_a_of_type_Int));
    if ((this.b) && (this.jdField_a_of_type_Int == 7)) {}
    bjai localbjai;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilList.size() <= 0);
      localbjai = (bjai)this.jdField_a_of_type_JavaUtilList.get(0);
    } while (this.jdField_a_of_type_Int != localbjai.a());
    onPageSelected(0);
  }
  
  public void g()
  {
    Object localObject = a();
    if ((localObject != null) && (((bjct)localObject).b != null)) {
      ((bjct)localObject).b.bringToFront();
    }
    localObject = a();
    if ((localObject != null) && (((bjcx)localObject).a != null)) {
      ((bjcx)localObject).a.a().bringToFront();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.bringToFront();
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(paramInt);
  }
  
  @Deprecated
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(paramInt1, paramFloat);
  }
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.b(paramInt);
    bjai localbjai = (bjai)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int i = localbjai.a();
    if ((i == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Boolean)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CaptureModeController", 2, new Object[] { "onPageSelected, mLastCaptureMode:", Integer.valueOf(this.jdField_a_of_type_Int), " current:", Integer.valueOf(i) });
    }
    this.jdField_a_of_type_Bjcl.a(false);
    switch (this.jdField_a_of_type_Int)
    {
    case 3: 
    case 6: 
    case 8: 
    case 9: 
    default: 
      label160:
      this.jdField_a_of_type_Bjcl = ((bjcl)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
      int j = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Bify.b = i;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Bify.a(j, this.jdField_a_of_type_Bjcl);
      this.jdField_a_of_type_Bjcl.a(true);
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      vel.a("video_shoot_navi", "clk_mode", 0, 0, new String[] { String.valueOf(localbjai.a()) });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CaptureModeController", 2, "onPageSelected:" + paramInt);
      return;
      this.jdField_a_of_type_Bify.a(false, true);
      break label160;
      this.jdField_a_of_type_Bify.d(false);
      break label160;
      this.jdField_a_of_type_Bify.h(false);
      break label160;
      this.jdField_a_of_type_Bify.g(false);
      break label160;
      this.jdField_a_of_type_Bify.i(false);
      break label160;
      this.jdField_a_of_type_Bify.f(false);
      break label160;
      this.jdField_a_of_type_Bify.d(false);
      break label160;
      this.jdField_a_of_type_Bify.a(true, true);
      continue;
      this.jdField_a_of_type_Bify.d(true);
      continue;
      this.jdField_a_of_type_Bify.f(true);
      continue;
      this.jdField_a_of_type_Bify.h(true);
      continue;
      this.jdField_a_of_type_Bify.g(true);
      continue;
      this.jdField_a_of_type_Bify.i(true);
      continue;
      this.jdField_a_of_type_Bify.d(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.mode.CaptureModeController
 * JD-Core Version:    0.7.0.1
 */