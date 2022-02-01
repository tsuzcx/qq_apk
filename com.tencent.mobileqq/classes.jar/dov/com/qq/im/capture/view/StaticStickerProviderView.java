package dov.com.qq.im.capture.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.LayoutInflater;
import bivb;
import bogd;
import boid;
import boiu;
import bojs;
import boke;
import boph;
import bopl;
import bopm;
import botp;
import bovv;
import bpav;
import bpaw;
import bpbc;
import bpbf;
import bpbi;
import bpbn;
import bpdg;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.FacePagerAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import ykw;

@TargetApi(9)
public class StaticStickerProviderView
  extends ProviderView
  implements bivb, boph, bpbi
{
  private int jdField_a_of_type_Int = 0;
  private boid jdField_a_of_type_Boid;
  boiu jdField_a_of_type_Boiu = new bopm(this);
  bpbn jdField_a_of_type_Bpbn;
  BounceViewPager jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager;
  FacePagerAdapter jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter;
  public ArrayList<String> a;
  
  public StaticStickerProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(bojs parambojs, botp parambotp)
  {
    parambojs = new ArrayList(parambojs.a());
    parambotp.a(false);
    parambotp.a(parambojs);
  }
  
  public static void a(Collection<bpaw> paramCollection)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StaticStickerProviderView", 2, "random tab shufflePaster");
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      bpaw localbpaw = (bpaw)paramCollection.next();
      if (localbpaw.jdField_a_of_type_Boolean) {
        if ((localbpaw instanceof bpbf)) {
          Collections.shuffle(((bpbf)localbpaw).a);
        } else if ((localbpaw instanceof bpbc)) {
          Collections.shuffle(((bpbc)localbpaw).a);
        }
      }
    }
  }
  
  private void j()
  {
    ArrayList localArrayList1 = ((boke)bogd.a(1)).a();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < localArrayList1.size())
    {
      if (((DoodleEmojiItem)localArrayList1.get(i)).hide != 1)
      {
        String str = ((DoodleEmojiItem)localArrayList1.get(i)).name;
        if (!localArrayList2.contains(str)) {
          localArrayList2.add(str);
        }
      }
      i += 1;
    }
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.initTabItemsWithString(localArrayList2);
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList2;
  }
  
  private void k()
  {
    long l1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long l2 = (Runtime.getRuntime().maxMemory() * 0.8D);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("clearMemory ");
      if (l1 <= l2) {
        break label91;
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("StaticStickerProviderView", 2, bool);
      if ((l1 > l2) && (BaseApplicationImpl.sImageCache != null)) {
        BaseApplicationImpl.sImageCache.evictAll();
      }
      return;
    }
  }
  
  protected int a()
  {
    return 2131560928;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.b(this);
    }
    if (this.jdField_a_of_type_Bpbn != null) {
      this.jdField_a_of_type_Bpbn.b(this);
    }
    botp localbotp = ((bojs)bogd.a(4)).a();
    if (localbotp != null) {
      localbotp.b(this);
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_Boiu);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.onTabChecked(paramInt);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.b(paramInt);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      if (paramInt1 >= this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem()) {
        break label28;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.c(paramInt1);
    }
    label28:
    while (paramInt1 != this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem()) {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.c(paramInt1 + 1);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560928, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager = ((BounceViewPager)findViewById(2131366376));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter = new FacePagerAdapter(super.getContext());
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setAdapter(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.a(this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    j();
    bojs localbojs = (bojs)bogd.a(4);
    localbojs.forceInit();
    paramBundle = localbojs.a();
    a(localbojs, paramBundle);
    setAdapter(paramBundle);
    Activity localActivity = (Activity)getContext();
    setDownloadListener(new bopl(this, localActivity));
    paramBundle = (DoodleLayout)localActivity.findViewById(2131365803);
    if (paramBundle == null) {
      paramBundle = (DoodleLayout)localActivity.findViewById(2131364284);
    }
    for (;;)
    {
      setOnFaceSelectedListener(paramBundle.a());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_Boiu);
      localbojs.a(true, (Activity)getContext());
      return;
    }
  }
  
  public void a(bpdg parambpdg)
  {
    if (((parambpdg instanceof bovv)) && (this.jdField_a_of_type_JavaUtilArrayList != null))
    {
      Object localObject = (bovv)parambpdg;
      parambpdg = ((bovv)localObject).e;
      localObject = ((bovv)localObject).d;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (TextUtils.equals((String)this.jdField_a_of_type_JavaUtilArrayList.get(i), (CharSequence)localObject))
        {
          onTabChecked(i);
          postDelayed(new StaticStickerProviderView.3(this, i, parambpdg), 200L);
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StaticStickerProviderView", 2, "selectPosition category=" + (String)localObject + " name=" + parambpdg);
      }
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Boid != null) {
      this.jdField_a_of_type_Boid.a();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.d(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem());
    }
  }
  
  public void c()
  {
    super.c();
    bojs localbojs = (bojs)bogd.a(4);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.notifyDataSetChanged();
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramInt);
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.removeAllViews();
    k();
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("StaticStickerProviderView", 2, "random tab paster onResume");
    }
    i();
  }
  
  public void g()
  {
    j();
    bojs localbojs = (bojs)bogd.a(4);
    botp localbotp = localbojs.a();
    if (localbotp != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("StaticStickerProviderView", 2, "paster config updateData");
      }
      a(localbojs, localbotp);
      setAdapter(localbotp);
      h();
      this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.onTabChecked(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem());
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a();
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter != null) && (bojs.a.compareAndSet(true, false))) {
      g();
    }
  }
  
  public void onTabChecked(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(paramInt);
    if (DoodleLayout.jdField_a_of_type_Boolean) {}
    for (Object localObject = "2";; localObject = "1")
    {
      DoodleLayout.a("change_face", 0, 0, new String[] { localObject });
      if (this.jdField_a_of_type_Bpbn != null)
      {
        localObject = this.jdField_a_of_type_Bpbn.a(paramInt);
        if ((localObject != null) && ((localObject instanceof bpaw)))
        {
          ykw.a("0X80076C7", "", "", ((bpaw)localObject).jdField_a_of_type_JavaLangString, "");
          ykw.a("0X80075DC", ((bpaw)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      if (paramInt == 1)
      {
        ykw.a("0X80076CC");
        ykw.b("0X80075E1");
      }
      return;
    }
  }
  
  public void setAdapter(bpbn parambpbn)
  {
    if (this.jdField_a_of_type_Bpbn != null)
    {
      this.jdField_a_of_type_Bpbn.b(this);
      this.jdField_a_of_type_Bpbn = null;
    }
    if (parambpbn != null)
    {
      parambpbn.b(this);
      this.jdField_a_of_type_Bpbn = parambpbn;
      this.jdField_a_of_type_Bpbn.a(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(this.jdField_a_of_type_Bpbn);
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(paramInt);
  }
  
  public void setDownloadListener(bpav parambpav)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(parambpav);
  }
  
  public void setOnFaceSelectedListener(boid paramboid)
  {
    this.jdField_a_of_type_Boid = paramboid;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramboid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.view.StaticStickerProviderView
 * JD-Core Version:    0.7.0.1
 */