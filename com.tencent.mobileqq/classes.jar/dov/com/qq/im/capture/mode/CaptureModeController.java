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
import bbif;
import bhtq;
import bkfs;
import bocn;
import bodv;
import bodw;
import bplu;
import bplv;
import bpny;
import bpnz;
import bpoa;
import bpoc;
import bpog;
import bpok;
import bpxc;
import bqal;
import bqan;
import bqav;
import brkm;
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
import wjj;
import yup;

public class CaptureModeController
  implements ViewPager.OnPageChangeListener, bbif, bplv
{
  protected int a;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  public ViewGroup a;
  public bocn a;
  private bpny jdField_a_of_type_Bpny;
  private bqal jdField_a_of_type_Bqal;
  private CaptureModeAdapter jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter;
  private HashMap<Integer, bpny> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<bplu> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  private boolean b;
  
  public CaptureModeController(bocn parambocn)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Bocn = parambocn;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_Bocn.a();
  }
  
  public bpny a()
  {
    return this.jdField_a_of_type_Bpny;
  }
  
  public bpoc a()
  {
    if ((this.jdField_a_of_type_Bocn instanceof bodv)) {}
    for (bpoc localbpoc1 = (bpoc)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0));; localbpoc1 = (bpoc)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1)))
    {
      bpoc localbpoc2 = localbpoc1;
      if (localbpoc1 == null) {
        localbpoc2 = new bpoc(this);
      }
      return localbpoc2;
    }
  }
  
  public bpog a()
  {
    bpog localbpog2 = (bpog)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2));
    bpog localbpog1 = localbpog2;
    if (localbpog2 == null) {
      localbpog1 = new bpog(this);
    }
    return localbpog1;
  }
  
  public bpok a()
  {
    bpok localbpok2 = (bpok)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(4));
    bpok localbpok1 = localbpok2;
    if (localbpok2 == null) {
      localbpok1 = new bpok(this);
    }
    return localbpok1;
  }
  
  public bqal a()
  {
    return this.jdField_a_of_type_Bqal;
  }
  
  public bqav a()
  {
    bqav localbqav2 = (bqav)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(5));
    bqav localbqav1 = localbqav2;
    if (localbqav2 == null) {
      localbqav1 = new bqav(this);
    }
    return localbqav1;
  }
  
  public void a()
  {
    Object localObject2 = this.jdField_a_of_type_Bocn.a().getIntent().getIntegerArrayListExtra("support_intent_mode");
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(Integer.valueOf(bpoa.a(((Integer)((Iterator)localObject2).next()).intValue())));
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
        bpny localbpny = bpoa.a(((Integer)localObject2).intValue(), this);
        if (localbpny.b())
        {
          this.jdField_a_of_type_JavaUtilList.add(new bplu(((Integer)localObject2).intValue()));
          this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, localbpny);
        }
      }
      localObject1 = this.jdField_a_of_type_Bocn.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("CaptureModeController", 2, "initCaptureMode use = " + (System.currentTimeMillis() - l));
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Bocn.c();
    if ((this.jdField_a_of_type_Int == 5) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(5)))) {
      this.jdField_a_of_type_Int = 0;
    }
    this.jdField_a_of_type_Bocn.b = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Bpny = ((bpny)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int)));
    this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(7));
  }
  
  public void a(int paramInt, View paramView)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(paramInt);
  }
  
  public void a(View paramView, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131364194));
    if (paramBoolean)
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      localLayoutParams.topMargin = bhtq.a(8.0F);
      localLayoutParams.addRule(10, -1);
      localLayoutParams.addRule(12, 0);
      paramRelativeLayout.addView(this.jdField_a_of_type_AndroidViewViewGroup, localLayoutParams);
      paramRelativeLayout = (ImageView)paramView.findViewById(2131376960);
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setVisibility(0);
      }
      paramRelativeLayout = (ImageView)paramView.findViewById(2131376958);
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setVisibility(0);
      }
    }
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)paramView.findViewById(2131364189));
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    int k = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int i = j;
    if (brkm.a(j, k)) {
      i = k * 9 / 16;
    }
    i = (i - bhtq.a(53.0F)) / 2;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setPadding(i, 0, i, 0);
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter = new CaptureModeAdapter(paramView.getContext());
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOffscreenPageLimit(this.jdField_a_of_type_JavaUtilList.size());
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(this);
    paramRelativeLayout = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (paramRelativeLayout.hasNext()) {
      ((bpny)((Map.Entry)paramRelativeLayout.next()).getValue()).a(paramView);
    }
    paramBoolean = this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(5));
    boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(7));
    if ((paramBoolean) || (bool))
    {
      this.jdField_a_of_type_Bqal = new bqal();
      this.jdField_a_of_type_Bqal.a();
      if ((this.jdField_a_of_type_Bocn.a() instanceof EffectsCameraCaptureView))
      {
        paramRelativeLayout = (EffectsCameraCaptureView)this.jdField_a_of_type_Bocn.a();
        paramRelativeLayout.setFilterInitedListener(this);
        if (paramRelativeLayout.a == null) {
          break label527;
        }
        wjj.a().dispatch(new bqan(2, true));
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_JavaUtilList.size() == 1) && ((((bplu)this.jdField_a_of_type_JavaUtilList.get(0)).a() == 0) || (((bplu)this.jdField_a_of_type_JavaUtilList.get(0)).a() == 10)))
      {
        ((ImageView)paramView.findViewById(2131364190)).setVisibility(4);
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(4);
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
        this.jdField_a_of_type_Bocn.v();
      }
      return;
      label527:
      paramRelativeLayout.setOnSurfaceCreatedListener(new bpnz(this));
    }
  }
  
  public void a(View paramView, RelativeLayout paramRelativeLayout1, boolean paramBoolean, RelativeLayout paramRelativeLayout2)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131364194));
    if (paramBoolean)
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      paramRelativeLayout2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramRelativeLayout2.topMargin = bhtq.a(8.0F);
      paramRelativeLayout2.addRule(10, -1);
      paramRelativeLayout2.addRule(12, 0);
      paramRelativeLayout1.addView(this.jdField_a_of_type_AndroidViewViewGroup, paramRelativeLayout2);
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131376960);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(0);
      }
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131376958);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(0);
      }
    }
    while ((this.jdField_a_of_type_JavaUtilList.size() == 1) && (((bplu)this.jdField_a_of_type_JavaUtilList.get(0)).a() == 0))
    {
      ((ImageView)paramView.findViewById(2131364190)).setVisibility(4);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_Bocn.v();
      return;
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      paramRelativeLayout1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramRelativeLayout1.topMargin = bhtq.a(0.0F);
      paramRelativeLayout1.bottomMargin = bhtq.a(0.0F);
      paramRelativeLayout1.addRule(10, 0);
      paramRelativeLayout1.addRule(12, -1);
      paramRelativeLayout2.addView(this.jdField_a_of_type_AndroidViewViewGroup, paramRelativeLayout1);
      this.jdField_a_of_type_AndroidViewViewGroup.bringToFront();
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131376960);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(8);
      }
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131376958);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(8);
      }
    }
    ((ImageView)paramView.findViewById(2131364190)).setVisibility(0);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
  }
  
  public void a(boolean paramBoolean)
  {
    if (bkfs.b.get()) {
      wjj.a().dispatch(new bqan(1, paramBoolean));
    }
    wjj.a().dispatch(new bqan(3, true));
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt));
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bpny.c();
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("CaptureModeController", 2, new Object[] { "setSegmentModeEnabled, ", Boolean.valueOf(paramBoolean) });
    }
    if ((this.jdField_a_of_type_Bocn instanceof bodv))
    {
      if ((this.jdField_a_of_type_Bocn instanceof bodw)) {
        paramBoolean = false;
      }
      ((bodv)this.jdField_a_of_type_Bocn).a.setEnableSegment(paramBoolean);
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
    this.jdField_a_of_type_Bpny.d();
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
    this.jdField_a_of_type_Bpny.e();
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
    this.jdField_a_of_type_Bpny.f();
    if (this.jdField_a_of_type_Bqal != null)
    {
      this.jdField_a_of_type_Bqal.b();
      this.jdField_a_of_type_Bqal = null;
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(this.jdField_a_of_type_Int));
    if ((this.b) && (this.jdField_a_of_type_Int == 7)) {}
    bplu localbplu;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilList.size() <= 0);
      localbplu = (bplu)this.jdField_a_of_type_JavaUtilList.get(0);
    } while (this.jdField_a_of_type_Int != localbplu.a());
    onPageSelected(0);
  }
  
  public void g()
  {
    Object localObject = a();
    if ((localObject != null) && (((bpog)localObject).b != null)) {
      ((bpog)localObject).b.bringToFront();
    }
    localObject = a();
    if ((localObject != null) && (((bpok)localObject).a != null)) {
      ((bpok)localObject).a.a().bringToFront();
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
    bplu localbplu = (bplu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int i = localbplu.a();
    if ((i == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Boolean)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CaptureModeController", 2, new Object[] { "onPageSelected, mLastCaptureMode:", Integer.valueOf(this.jdField_a_of_type_Int), " current:", Integer.valueOf(i) });
    }
    this.jdField_a_of_type_Bpny.a(false);
    switch (this.jdField_a_of_type_Int)
    {
    case 3: 
    case 6: 
    case 8: 
    case 9: 
    default: 
      label160:
      this.jdField_a_of_type_Bpny = ((bpny)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
      int j = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Bocn.b = i;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Bocn.a(j, this.jdField_a_of_type_Bpny);
      this.jdField_a_of_type_Bpny.a(true);
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      yup.a("video_shoot_navi", "clk_mode", 0, 0, new String[] { String.valueOf(localbplu.a()) });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CaptureModeController", 2, "onPageSelected:" + paramInt);
      return;
      this.jdField_a_of_type_Bocn.a(false, true);
      break label160;
      this.jdField_a_of_type_Bocn.d(false);
      break label160;
      this.jdField_a_of_type_Bocn.h(false);
      break label160;
      this.jdField_a_of_type_Bocn.g(false);
      break label160;
      this.jdField_a_of_type_Bocn.i(false);
      break label160;
      this.jdField_a_of_type_Bocn.f(false);
      break label160;
      this.jdField_a_of_type_Bocn.d(false);
      break label160;
      this.jdField_a_of_type_Bocn.a(true, true);
      continue;
      this.jdField_a_of_type_Bocn.d(true);
      continue;
      this.jdField_a_of_type_Bocn.f(true);
      continue;
      this.jdField_a_of_type_Bocn.h(true);
      continue;
      this.jdField_a_of_type_Bocn.g(true);
      continue;
      this.jdField_a_of_type_Bocn.i(true);
      continue;
      this.jdField_a_of_type_Bocn.d(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.mode.CaptureModeController
 * JD-Core Version:    0.7.0.1
 */