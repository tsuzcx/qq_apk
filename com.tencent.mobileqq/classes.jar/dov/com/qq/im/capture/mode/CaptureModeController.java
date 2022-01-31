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
import axnc;
import bdkf;
import bfsz;
import bkil;
import bkjt;
import bkju;
import blmj;
import blmk;
import blon;
import bloo;
import blop;
import blor;
import blov;
import bloz;
import blxr;
import bmcy;
import bmda;
import bmdi;
import bnoa;
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
import uht;
import wta;

public class CaptureModeController
  implements ViewPager.OnPageChangeListener, axnc, blmk
{
  protected int a;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  public ViewGroup a;
  public bkil a;
  private blon jdField_a_of_type_Blon;
  private bmcy jdField_a_of_type_Bmcy;
  private CaptureModeAdapter jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter;
  private HashMap<Integer, blon> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<blmj> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  private boolean b;
  
  public CaptureModeController(bkil parambkil)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Bkil = parambkil;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_Bkil.a();
  }
  
  public blon a()
  {
    return this.jdField_a_of_type_Blon;
  }
  
  public blor a()
  {
    if ((this.jdField_a_of_type_Bkil instanceof bkjt)) {}
    for (blor localblor1 = (blor)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0));; localblor1 = (blor)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1)))
    {
      blor localblor2 = localblor1;
      if (localblor1 == null) {
        localblor2 = new blor(this);
      }
      return localblor2;
    }
  }
  
  public blov a()
  {
    blov localblov2 = (blov)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2));
    blov localblov1 = localblov2;
    if (localblov2 == null) {
      localblov1 = new blov(this);
    }
    return localblov1;
  }
  
  public bloz a()
  {
    bloz localbloz2 = (bloz)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(4));
    bloz localbloz1 = localbloz2;
    if (localbloz2 == null) {
      localbloz1 = new bloz(this);
    }
    return localbloz1;
  }
  
  public bmcy a()
  {
    return this.jdField_a_of_type_Bmcy;
  }
  
  public bmdi a()
  {
    bmdi localbmdi2 = (bmdi)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(5));
    bmdi localbmdi1 = localbmdi2;
    if (localbmdi2 == null) {
      localbmdi1 = new bmdi(this);
    }
    return localbmdi1;
  }
  
  public void a()
  {
    Object localObject2 = this.jdField_a_of_type_Bkil.a().getIntent().getIntegerArrayListExtra("support_intent_mode");
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(Integer.valueOf(blop.a(((Integer)((Iterator)localObject2).next()).intValue())));
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
        blon localblon = blop.a(((Integer)localObject2).intValue(), this);
        if (localblon.b())
        {
          this.jdField_a_of_type_JavaUtilList.add(new blmj(((Integer)localObject2).intValue()));
          this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, localblon);
        }
      }
      localObject1 = this.jdField_a_of_type_Bkil.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("CaptureModeController", 2, "initCaptureMode use = " + (System.currentTimeMillis() - l));
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Bkil.c();
    if ((this.jdField_a_of_type_Int == 5) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(5)))) {
      this.jdField_a_of_type_Int = 0;
    }
    this.jdField_a_of_type_Bkil.b = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Blon = ((blon)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int)));
    this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(7));
  }
  
  public void a(int paramInt, View paramView)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(paramInt);
  }
  
  public void a(View paramView, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131363948));
    if (paramBoolean)
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      localLayoutParams.topMargin = bdkf.a(8.0F);
      localLayoutParams.addRule(10, -1);
      localLayoutParams.addRule(12, 0);
      paramRelativeLayout.addView(this.jdField_a_of_type_AndroidViewViewGroup, localLayoutParams);
      paramRelativeLayout = (ImageView)paramView.findViewById(2131376015);
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setVisibility(0);
      }
      paramRelativeLayout = (ImageView)paramView.findViewById(2131376013);
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setVisibility(0);
      }
    }
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)paramView.findViewById(2131363943));
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    int k = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int i = j;
    if (bnoa.a(j, k)) {
      i = k * 9 / 16;
    }
    i = (i - bdkf.a(53.0F)) / 2;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setPadding(i, 0, i, 0);
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter = new CaptureModeAdapter(paramView.getContext());
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOffscreenPageLimit(this.jdField_a_of_type_JavaUtilList.size());
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(this);
    paramRelativeLayout = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (paramRelativeLayout.hasNext()) {
      ((blon)((Map.Entry)paramRelativeLayout.next()).getValue()).a(paramView);
    }
    paramBoolean = this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(5));
    boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(7));
    if ((paramBoolean) || (bool))
    {
      this.jdField_a_of_type_Bmcy = new bmcy();
      this.jdField_a_of_type_Bmcy.a();
      if ((this.jdField_a_of_type_Bkil.a() instanceof EffectsCameraCaptureView))
      {
        paramRelativeLayout = (EffectsCameraCaptureView)this.jdField_a_of_type_Bkil.a();
        paramRelativeLayout.setFilterInitedListener(this);
        if (paramRelativeLayout.a == null) {
          break label527;
        }
        uht.a().dispatch(new bmda(2, true));
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_JavaUtilList.size() == 1) && ((((blmj)this.jdField_a_of_type_JavaUtilList.get(0)).a() == 0) || (((blmj)this.jdField_a_of_type_JavaUtilList.get(0)).a() == 10)))
      {
        ((ImageView)paramView.findViewById(2131363944)).setVisibility(4);
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(4);
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
        this.jdField_a_of_type_Bkil.v();
      }
      return;
      label527:
      paramRelativeLayout.setOnSurfaceCreatedListener(new bloo(this));
    }
  }
  
  public void a(View paramView, RelativeLayout paramRelativeLayout1, boolean paramBoolean, RelativeLayout paramRelativeLayout2)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131363948));
    if (paramBoolean)
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      paramRelativeLayout2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramRelativeLayout2.topMargin = bdkf.a(8.0F);
      paramRelativeLayout2.addRule(10, -1);
      paramRelativeLayout2.addRule(12, 0);
      paramRelativeLayout1.addView(this.jdField_a_of_type_AndroidViewViewGroup, paramRelativeLayout2);
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131376015);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(0);
      }
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131376013);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(0);
      }
    }
    while ((this.jdField_a_of_type_JavaUtilList.size() == 1) && (((blmj)this.jdField_a_of_type_JavaUtilList.get(0)).a() == 0))
    {
      ((ImageView)paramView.findViewById(2131363944)).setVisibility(4);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_Bkil.v();
      return;
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      paramRelativeLayout1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramRelativeLayout1.topMargin = bdkf.a(0.0F);
      paramRelativeLayout1.bottomMargin = bdkf.a(0.0F);
      paramRelativeLayout1.addRule(10, 0);
      paramRelativeLayout1.addRule(12, -1);
      paramRelativeLayout2.addView(this.jdField_a_of_type_AndroidViewViewGroup, paramRelativeLayout1);
      this.jdField_a_of_type_AndroidViewViewGroup.bringToFront();
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131376015);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(8);
      }
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131376013);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(8);
      }
    }
    ((ImageView)paramView.findViewById(2131363944)).setVisibility(0);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
  }
  
  public void a(boolean paramBoolean)
  {
    if (bfsz.b.get()) {
      uht.a().dispatch(new bmda(1, paramBoolean));
    }
    uht.a().dispatch(new bmda(3, true));
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt));
  }
  
  public void b()
  {
    this.jdField_a_of_type_Blon.c();
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("CaptureModeController", 2, new Object[] { "setSegmentModeEnabled, ", Boolean.valueOf(paramBoolean) });
    }
    if ((this.jdField_a_of_type_Bkil instanceof bkjt))
    {
      if ((this.jdField_a_of_type_Bkil instanceof bkju)) {
        paramBoolean = false;
      }
      ((bkjt)this.jdField_a_of_type_Bkil).a.setEnableSegment(paramBoolean);
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
    this.jdField_a_of_type_Blon.d();
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
    this.jdField_a_of_type_Blon.e();
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
    this.jdField_a_of_type_Blon.f();
    if (this.jdField_a_of_type_Bmcy != null)
    {
      this.jdField_a_of_type_Bmcy.b();
      this.jdField_a_of_type_Bmcy = null;
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(this.jdField_a_of_type_Int));
    if ((this.b) && (this.jdField_a_of_type_Int == 7)) {}
    blmj localblmj;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilList.size() <= 0);
      localblmj = (blmj)this.jdField_a_of_type_JavaUtilList.get(0);
    } while (this.jdField_a_of_type_Int != localblmj.a());
    onPageSelected(0);
  }
  
  public void g()
  {
    Object localObject = a();
    if ((localObject != null) && (((blov)localObject).b != null)) {
      ((blov)localObject).b.bringToFront();
    }
    localObject = a();
    if ((localObject != null) && (((bloz)localObject).a != null)) {
      ((bloz)localObject).a.a().bringToFront();
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
    blmj localblmj = (blmj)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int i = localblmj.a();
    if ((i == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Boolean)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CaptureModeController", 2, new Object[] { "onPageSelected, mLastCaptureMode:", Integer.valueOf(this.jdField_a_of_type_Int), " current:", Integer.valueOf(i) });
    }
    this.jdField_a_of_type_Blon.a(false);
    switch (this.jdField_a_of_type_Int)
    {
    case 3: 
    case 6: 
    case 8: 
    case 9: 
    default: 
      label160:
      this.jdField_a_of_type_Blon = ((blon)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
      int j = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Bkil.b = i;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Bkil.a(j, this.jdField_a_of_type_Blon);
      this.jdField_a_of_type_Blon.a(true);
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      wta.a("video_shoot_navi", "clk_mode", 0, 0, new String[] { String.valueOf(localblmj.a()) });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CaptureModeController", 2, "onPageSelected:" + paramInt);
      return;
      this.jdField_a_of_type_Bkil.a(false, true);
      break label160;
      this.jdField_a_of_type_Bkil.d(false);
      break label160;
      this.jdField_a_of_type_Bkil.h(false);
      break label160;
      this.jdField_a_of_type_Bkil.g(false);
      break label160;
      this.jdField_a_of_type_Bkil.i(false);
      break label160;
      this.jdField_a_of_type_Bkil.f(false);
      break label160;
      this.jdField_a_of_type_Bkil.d(false);
      break label160;
      this.jdField_a_of_type_Bkil.a(true, true);
      continue;
      this.jdField_a_of_type_Bkil.d(true);
      continue;
      this.jdField_a_of_type_Bkil.f(true);
      continue;
      this.jdField_a_of_type_Bkil.h(true);
      continue;
      this.jdField_a_of_type_Bkil.g(true);
      continue;
      this.jdField_a_of_type_Bkil.i(true);
      continue;
      this.jdField_a_of_type_Bkil.d(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.mode.CaptureModeController
 * JD-Core Version:    0.7.0.1
 */