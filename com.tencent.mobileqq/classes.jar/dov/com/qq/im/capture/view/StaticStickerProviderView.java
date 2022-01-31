package dov.com.qq.im.capture.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.LayoutInflater;
import blqr;
import blsr;
import bltq;
import blvi;
import blvu;
import bmbm;
import bmbr;
import bmbs;
import bmjt;
import bmmb;
import bmnj;
import bmqk;
import bmvu;
import bmvv;
import bmwb;
import bmwc;
import bmwf;
import bmwi;
import bmwn;
import bmxq;
import bmyj;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.FacePagerAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import wxk;

@TargetApi(9)
public class StaticStickerProviderView
  extends ProviderView
  implements bmbm, bmwi, bmxq
{
  private int jdField_a_of_type_Int = 0;
  private blsr jdField_a_of_type_Blsr;
  bltq jdField_a_of_type_Bltq = new bmbs(this);
  bmwn jdField_a_of_type_Bmwn;
  FacePagerAdapter jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter;
  FaceViewPager jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager;
  public ArrayList<String> a;
  
  public StaticStickerProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(blvi paramblvi, bmmb parambmmb)
  {
    paramblvi = new ArrayList(paramblvi.a());
    if (b())
    {
      paramblvi.add(0, new bmwb());
      parambmmb.a(true);
    }
    for (;;)
    {
      parambmmb.a(paramblvi);
      return;
      parambmmb.a(false);
    }
  }
  
  public static void a(Collection<bmvv> paramCollection)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StaticStickerProviderView", 2, "random tab shufflePaster");
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      bmvv localbmvv = (bmvv)paramCollection.next();
      if (localbmvv.jdField_a_of_type_Boolean) {
        if ((localbmvv instanceof bmwf)) {
          Collections.shuffle(((bmwf)localbmvv).a);
        } else if ((localbmvv instanceof bmwc)) {
          Collections.shuffle(((bmwc)localbmvv).a);
        }
      }
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Bmau != null) && ((this.jdField_a_of_type_Bmau instanceof bmjt)))
    {
      bmnj localbmnj = ((bmjt)this.jdField_a_of_type_Bmau).a;
      if ((localbmnj != null) && (localbmnj.a != null)) {
        return true;
      }
    }
    return false;
  }
  
  private void j()
  {
    ArrayList localArrayList1 = ((blvu)blqr.a(1)).a();
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
    if (b()) {
      localArrayList2.add(0, bmwb.f);
    }
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.b(localArrayList2);
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList2;
  }
  
  private void n()
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
    return 2131560761;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Bmwn != null) {
      this.jdField_a_of_type_Bmwn.b(this);
    }
    bmmb localbmmb = ((blvi)blqr.a(4)).a();
    if (localbmmb != null) {
      localbmmb.b(this);
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_Bltq);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
    if (DoodleLayout.jdField_a_of_type_Boolean) {}
    for (Object localObject = "2";; localObject = "1")
    {
      DoodleLayout.a("change_face", 0, 0, new String[] { localObject });
      if (this.jdField_a_of_type_Bmwn != null)
      {
        localObject = this.jdField_a_of_type_Bmwn.a(paramInt);
        if ((localObject != null) && ((localObject instanceof bmvv)))
        {
          wxk.a("0X80076C7", "", "", ((bmvv)localObject).jdField_a_of_type_JavaLangString, "");
          wxk.a("0X80075DC", ((bmvv)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      if (paramInt == 1)
      {
        wxk.a("0X80076CC");
        wxk.b("0X80075E1");
      }
      return;
    }
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      if (paramInt1 >= this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.getCurrentItem()) {
        break label28;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.c(paramInt1);
    }
    label28:
    while (paramInt1 != this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.getCurrentItem()) {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.c(paramInt1 + 1);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560761, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager = ((FaceViewPager)findViewById(2131365945));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter = new FacePagerAdapter(super.getContext());
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setAdapter(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.a(this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    j();
    blvi localblvi = (blvi)blqr.a(4);
    localblvi.i();
    paramBundle = localblvi.a();
    a(localblvi, paramBundle);
    setAdapter(paramBundle);
    Activity localActivity = (Activity)getContext();
    setDownloadListener(new bmbr(this, localActivity));
    paramBundle = (DoodleLayout)localActivity.findViewById(2131365398);
    if (paramBundle == null) {
      paramBundle = (DoodleLayout)localActivity.findViewById(2131363942);
    }
    for (;;)
    {
      setOnFaceSelectedListener(paramBundle.a());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_Bltq);
      localblvi.a(true, (Activity)getContext());
      return;
    }
  }
  
  public void a(bmyj parambmyj)
  {
    if (((parambmyj instanceof bmqk)) && (this.jdField_a_of_type_JavaUtilArrayList != null))
    {
      Object localObject = (bmqk)parambmyj;
      parambmyj = ((bmqk)localObject).e;
      localObject = ((bmqk)localObject).d;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (TextUtils.equals((String)this.jdField_a_of_type_JavaUtilArrayList.get(i), (CharSequence)localObject))
        {
          a(i);
          postDelayed(new StaticStickerProviderView.3(this, i, parambmyj), 200L);
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StaticStickerProviderView", 2, "selectPosition category=" + (String)localObject + " name=" + parambmyj);
      }
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Blsr != null) {
      this.jdField_a_of_type_Blsr.a();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramInt);
  }
  
  public void c()
  {
    super.c();
    blvi localblvi = (blvi)blqr.a(4);
    bmmb localbmmb = localblvi.a();
    if (localbmmb.a() != b()) {
      a(localblvi, localbmmb);
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.notifyDataSetChanged();
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(paramInt);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.b(paramInt);
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.removeAllViews();
    n();
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("StaticStickerProviderView", 2, "random tab paster onResume");
    }
    i();
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.d(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.getCurrentItem());
    }
  }
  
  public void g()
  {
    j();
    blvi localblvi = (blvi)blqr.a(4);
    bmmb localbmmb = localblvi.a();
    if (localbmmb != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("StaticStickerProviderView", 2, "paster config updateData");
      }
      a(localblvi, localbmmb);
      setAdapter(localbmmb);
      h();
      this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.getCurrentItem());
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a();
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter != null) && (blvi.a.compareAndSet(true, false))) {
      g();
    }
  }
  
  public void setAdapter(bmwn parambmwn)
  {
    if (this.jdField_a_of_type_Bmwn != null)
    {
      this.jdField_a_of_type_Bmwn.b(this);
      this.jdField_a_of_type_Bmwn = null;
    }
    if (parambmwn != null)
    {
      parambmwn.b(this);
      this.jdField_a_of_type_Bmwn = parambmwn;
      this.jdField_a_of_type_Bmwn.a(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(this.jdField_a_of_type_Bmwn);
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
  }
  
  public void setDownloadListener(bmvu parambmvu)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(parambmvu);
  }
  
  public void setOnFaceSelectedListener(blsr paramblsr)
  {
    this.jdField_a_of_type_Blsr = paramblsr;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramblsr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.view.StaticStickerProviderView
 * JD-Core Version:    0.7.0.1
 */