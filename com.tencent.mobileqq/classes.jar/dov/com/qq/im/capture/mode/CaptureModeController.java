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
import avvd;
import bbll;
import bdte;
import bigp;
import bihx;
import bihz;
import bjaz;
import bjba;
import bjdc;
import bjdd;
import bjde;
import bjdg;
import bjdk;
import bjdo;
import bjmh;
import bjro;
import bjrq;
import bjry;
import blcq;
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
import stb;
import vei;

public class CaptureModeController
  implements ViewPager.OnPageChangeListener, avvd, bjba
{
  protected int a;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  public ViewGroup a;
  public bigp a;
  private bjdc jdField_a_of_type_Bjdc;
  private bjro jdField_a_of_type_Bjro;
  private CaptureModeAdapter jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter;
  private HashMap<Integer, bjdc> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<bjaz> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  private boolean b;
  
  public CaptureModeController(bigp parambigp)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Bigp = parambigp;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_Bigp.a();
  }
  
  public bjdc a()
  {
    return this.jdField_a_of_type_Bjdc;
  }
  
  public bjdg a()
  {
    if ((this.jdField_a_of_type_Bigp instanceof bihx)) {}
    for (bjdg localbjdg1 = (bjdg)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0));; localbjdg1 = (bjdg)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1)))
    {
      bjdg localbjdg2 = localbjdg1;
      if (localbjdg1 == null) {
        localbjdg2 = new bjdg(this);
      }
      return localbjdg2;
    }
  }
  
  public bjdk a()
  {
    bjdk localbjdk2 = (bjdk)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2));
    bjdk localbjdk1 = localbjdk2;
    if (localbjdk2 == null) {
      localbjdk1 = new bjdk(this);
    }
    return localbjdk1;
  }
  
  public bjdo a()
  {
    bjdo localbjdo2 = (bjdo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(4));
    bjdo localbjdo1 = localbjdo2;
    if (localbjdo2 == null) {
      localbjdo1 = new bjdo(this);
    }
    return localbjdo1;
  }
  
  public bjro a()
  {
    return this.jdField_a_of_type_Bjro;
  }
  
  public bjry a()
  {
    bjry localbjry2 = (bjry)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(5));
    bjry localbjry1 = localbjry2;
    if (localbjry2 == null) {
      localbjry1 = new bjry(this);
    }
    return localbjry1;
  }
  
  public void a()
  {
    Object localObject2 = this.jdField_a_of_type_Bigp.a().getIntent().getIntegerArrayListExtra("support_intent_mode");
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(Integer.valueOf(bjde.a(((Integer)((Iterator)localObject2).next()).intValue())));
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
        bjdc localbjdc = bjde.a(((Integer)localObject2).intValue(), this);
        if (localbjdc.b())
        {
          this.jdField_a_of_type_JavaUtilList.add(new bjaz(((Integer)localObject2).intValue()));
          this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, localbjdc);
        }
      }
      localObject1 = this.jdField_a_of_type_Bigp.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("CaptureModeController", 2, "initCaptureMode use = " + (System.currentTimeMillis() - l));
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Bigp.d();
    if ((this.jdField_a_of_type_Int == 5) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(5)))) {
      this.jdField_a_of_type_Int = 0;
    }
    this.jdField_a_of_type_Bigp.b = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Bjdc = ((bjdc)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int)));
    this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(7));
  }
  
  public void a(int paramInt, View paramView)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(paramInt);
  }
  
  public void a(View paramView, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131363890));
    if (paramBoolean)
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      localLayoutParams.topMargin = bbll.a(8.0F);
      localLayoutParams.addRule(10, -1);
      localLayoutParams.addRule(12, 0);
      paramRelativeLayout.addView(this.jdField_a_of_type_AndroidViewViewGroup, localLayoutParams);
      paramRelativeLayout = (ImageView)paramView.findViewById(2131375527);
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setVisibility(0);
      }
      paramRelativeLayout = (ImageView)paramView.findViewById(2131375525);
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setVisibility(0);
      }
    }
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)paramView.findViewById(2131363885));
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    int k = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int i = j;
    if (blcq.a(j, k)) {
      i = k * 9 / 16;
    }
    i = (i - bbll.a(53.0F)) / 2;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setPadding(i, 0, i, 0);
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter = new CaptureModeAdapter(paramView.getContext());
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOffscreenPageLimit(this.jdField_a_of_type_JavaUtilList.size());
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(this);
    paramRelativeLayout = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (paramRelativeLayout.hasNext()) {
      ((bjdc)((Map.Entry)paramRelativeLayout.next()).getValue()).a(paramView);
    }
    paramBoolean = this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(5));
    boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(7));
    if ((paramBoolean) || (bool))
    {
      this.jdField_a_of_type_Bjro = new bjro();
      this.jdField_a_of_type_Bjro.a();
      if ((this.jdField_a_of_type_Bigp.a() instanceof EffectsCameraCaptureView))
      {
        paramRelativeLayout = (EffectsCameraCaptureView)this.jdField_a_of_type_Bigp.a();
        paramRelativeLayout.setFilterInitedListener(this);
        if (paramRelativeLayout.a == null) {
          break label527;
        }
        stb.a().dispatch(new bjrq(2, true));
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_JavaUtilList.size() == 1) && ((((bjaz)this.jdField_a_of_type_JavaUtilList.get(0)).a() == 0) || (((bjaz)this.jdField_a_of_type_JavaUtilList.get(0)).a() == 10)))
      {
        ((ImageView)paramView.findViewById(2131363886)).setVisibility(4);
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(4);
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
        this.jdField_a_of_type_Bigp.v();
      }
      return;
      label527:
      paramRelativeLayout.setOnSurfaceCreatedListener(new bjdd(this));
    }
  }
  
  public void a(View paramView, RelativeLayout paramRelativeLayout1, boolean paramBoolean, RelativeLayout paramRelativeLayout2)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131363890));
    if (paramBoolean)
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      paramRelativeLayout2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramRelativeLayout2.topMargin = bbll.a(8.0F);
      paramRelativeLayout2.addRule(10, -1);
      paramRelativeLayout2.addRule(12, 0);
      paramRelativeLayout1.addView(this.jdField_a_of_type_AndroidViewViewGroup, paramRelativeLayout2);
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131375527);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(0);
      }
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131375525);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(0);
      }
    }
    while ((this.jdField_a_of_type_JavaUtilList.size() == 1) && (((bjaz)this.jdField_a_of_type_JavaUtilList.get(0)).a() == 0))
    {
      ((ImageView)paramView.findViewById(2131363886)).setVisibility(4);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_Bigp.v();
      return;
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      paramRelativeLayout1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramRelativeLayout1.topMargin = bbll.a(0.0F);
      paramRelativeLayout1.bottomMargin = bbll.a(0.0F);
      paramRelativeLayout1.addRule(10, 0);
      paramRelativeLayout1.addRule(12, -1);
      paramRelativeLayout2.addView(this.jdField_a_of_type_AndroidViewViewGroup, paramRelativeLayout1);
      this.jdField_a_of_type_AndroidViewViewGroup.bringToFront();
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131375527);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(8);
      }
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131375525);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(8);
      }
    }
    ((ImageView)paramView.findViewById(2131363886)).setVisibility(0);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
  }
  
  public void a(boolean paramBoolean)
  {
    if (bdte.b.get()) {
      stb.a().dispatch(new bjrq(1, paramBoolean));
    }
    stb.a().dispatch(new bjrq(3, true));
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt));
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bjdc.c();
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("CaptureModeController", 2, new Object[] { "setSegmentModeEnabled, ", Boolean.valueOf(paramBoolean) });
    }
    if ((this.jdField_a_of_type_Bigp instanceof bihx))
    {
      if ((this.jdField_a_of_type_Bigp instanceof bihz)) {
        paramBoolean = false;
      }
      ((bihx)this.jdField_a_of_type_Bigp).a.setEnableSegment(paramBoolean);
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
    this.jdField_a_of_type_Bjdc.d();
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
    this.jdField_a_of_type_Bjdc.e();
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
    this.jdField_a_of_type_Bjdc.f();
    if (this.jdField_a_of_type_Bjro != null)
    {
      this.jdField_a_of_type_Bjro.b();
      this.jdField_a_of_type_Bjro = null;
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(this.jdField_a_of_type_Int));
    if ((this.b) && (this.jdField_a_of_type_Int == 7)) {}
    bjaz localbjaz;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilList.size() <= 0);
      localbjaz = (bjaz)this.jdField_a_of_type_JavaUtilList.get(0);
    } while (this.jdField_a_of_type_Int != localbjaz.a());
    onPageSelected(0);
  }
  
  public void g()
  {
    Object localObject = a();
    if ((localObject != null) && (((bjdk)localObject).b != null)) {
      ((bjdk)localObject).b.bringToFront();
    }
    localObject = a();
    if ((localObject != null) && (((bjdo)localObject).a != null)) {
      ((bjdo)localObject).a.a().bringToFront();
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
    bjaz localbjaz = (bjaz)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int i = localbjaz.a();
    if ((i == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Boolean)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CaptureModeController", 2, new Object[] { "onPageSelected, mLastCaptureMode:", Integer.valueOf(this.jdField_a_of_type_Int), " current:", Integer.valueOf(i) });
    }
    this.jdField_a_of_type_Bjdc.a(false);
    switch (this.jdField_a_of_type_Int)
    {
    case 3: 
    case 6: 
    case 8: 
    case 9: 
    default: 
      label160:
      this.jdField_a_of_type_Bjdc = ((bjdc)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
      int j = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Bigp.b = i;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Bigp.a(j, this.jdField_a_of_type_Bjdc);
      this.jdField_a_of_type_Bjdc.a(true);
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      vei.a("video_shoot_navi", "clk_mode", 0, 0, new String[] { String.valueOf(localbjaz.a()) });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CaptureModeController", 2, "onPageSelected:" + paramInt);
      return;
      this.jdField_a_of_type_Bigp.a(false, true);
      break label160;
      this.jdField_a_of_type_Bigp.d(false);
      break label160;
      this.jdField_a_of_type_Bigp.h(false);
      break label160;
      this.jdField_a_of_type_Bigp.g(false);
      break label160;
      this.jdField_a_of_type_Bigp.i(false);
      break label160;
      this.jdField_a_of_type_Bigp.f(false);
      break label160;
      this.jdField_a_of_type_Bigp.d(false);
      break label160;
      this.jdField_a_of_type_Bigp.a(true, true);
      continue;
      this.jdField_a_of_type_Bigp.d(true);
      continue;
      this.jdField_a_of_type_Bigp.f(true);
      continue;
      this.jdField_a_of_type_Bigp.h(true);
      continue;
      this.jdField_a_of_type_Bigp.g(true);
      continue;
      this.jdField_a_of_type_Bigp.i(true);
      continue;
      this.jdField_a_of_type_Bigp.d(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.mode.CaptureModeController
 * JD-Core Version:    0.7.0.1
 */