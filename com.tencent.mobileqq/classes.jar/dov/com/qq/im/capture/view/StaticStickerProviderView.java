package dov.com.qq.im.capture.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.LayoutInflater;
import blmf;
import blof;
import blpe;
import blqw;
import blri;
import blxa;
import blxf;
import blxg;
import bmfh;
import bmhp;
import bmix;
import bmly;
import bmri;
import bmrj;
import bmrp;
import bmrq;
import bmrt;
import bmrw;
import bmsb;
import bmte;
import bmtx;
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
import wtb;

@TargetApi(9)
public class StaticStickerProviderView
  extends ProviderView
  implements blxa, bmrw, bmte
{
  private int jdField_a_of_type_Int = 0;
  private blof jdField_a_of_type_Blof;
  blpe jdField_a_of_type_Blpe = new blxg(this);
  bmsb jdField_a_of_type_Bmsb;
  FacePagerAdapter jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter;
  FaceViewPager jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager;
  public ArrayList<String> a;
  
  public StaticStickerProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(blqw paramblqw, bmhp parambmhp)
  {
    paramblqw = new ArrayList(paramblqw.a());
    if (b())
    {
      paramblqw.add(0, new bmrp());
      parambmhp.a(true);
    }
    for (;;)
    {
      parambmhp.a(paramblqw);
      return;
      parambmhp.a(false);
    }
  }
  
  public static void a(Collection<bmrj> paramCollection)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StaticStickerProviderView", 2, "random tab shufflePaster");
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      bmrj localbmrj = (bmrj)paramCollection.next();
      if (localbmrj.jdField_a_of_type_Boolean) {
        if ((localbmrj instanceof bmrt)) {
          Collections.shuffle(((bmrt)localbmrj).a);
        } else if ((localbmrj instanceof bmrq)) {
          Collections.shuffle(((bmrq)localbmrj).a);
        }
      }
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Blwi != null) && ((this.jdField_a_of_type_Blwi instanceof bmfh)))
    {
      bmix localbmix = ((bmfh)this.jdField_a_of_type_Blwi).a;
      if ((localbmix != null) && (localbmix.a != null)) {
        return true;
      }
    }
    return false;
  }
  
  private void j()
  {
    ArrayList localArrayList1 = ((blri)blmf.a(1)).a();
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
      localArrayList2.add(0, bmrp.f);
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
    return 2131560743;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Bmsb != null) {
      this.jdField_a_of_type_Bmsb.b(this);
    }
    bmhp localbmhp = ((blqw)blmf.a(4)).a();
    if (localbmhp != null) {
      localbmhp.b(this);
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_Blpe);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
    if (DoodleLayout.jdField_a_of_type_Boolean) {}
    for (Object localObject = "2";; localObject = "1")
    {
      DoodleLayout.a("change_face", 0, 0, new String[] { localObject });
      if (this.jdField_a_of_type_Bmsb != null)
      {
        localObject = this.jdField_a_of_type_Bmsb.a(paramInt);
        if ((localObject != null) && ((localObject instanceof bmrj)))
        {
          wtb.a("0X80076C7", "", "", ((bmrj)localObject).jdField_a_of_type_JavaLangString, "");
          wtb.a("0X80075DC", ((bmrj)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      if (paramInt == 1)
      {
        wtb.a("0X80076CC");
        wtb.b("0X80075E1");
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
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560743, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager = ((FaceViewPager)findViewById(2131365943));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter = new FacePagerAdapter(super.getContext());
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setAdapter(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.a(this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    j();
    blqw localblqw = (blqw)blmf.a(4);
    localblqw.i();
    paramBundle = localblqw.a();
    a(localblqw, paramBundle);
    setAdapter(paramBundle);
    Activity localActivity = (Activity)getContext();
    setDownloadListener(new blxf(this, localActivity));
    paramBundle = (DoodleLayout)localActivity.findViewById(2131365396);
    if (paramBundle == null) {
      paramBundle = (DoodleLayout)localActivity.findViewById(2131363940);
    }
    for (;;)
    {
      setOnFaceSelectedListener(paramBundle.a());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_Blpe);
      localblqw.a(true, (Activity)getContext());
      return;
    }
  }
  
  public void a(bmtx parambmtx)
  {
    if (((parambmtx instanceof bmly)) && (this.jdField_a_of_type_JavaUtilArrayList != null))
    {
      Object localObject = (bmly)parambmtx;
      parambmtx = ((bmly)localObject).e;
      localObject = ((bmly)localObject).d;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (TextUtils.equals((String)this.jdField_a_of_type_JavaUtilArrayList.get(i), (CharSequence)localObject))
        {
          a(i);
          postDelayed(new StaticStickerProviderView.3(this, i, parambmtx), 200L);
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StaticStickerProviderView", 2, "selectPosition category=" + (String)localObject + " name=" + parambmtx);
      }
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Blof != null) {
      this.jdField_a_of_type_Blof.a();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramInt);
  }
  
  public void c()
  {
    super.c();
    blqw localblqw = (blqw)blmf.a(4);
    bmhp localbmhp = localblqw.a();
    if (localbmhp.a() != b()) {
      a(localblqw, localbmhp);
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
    blqw localblqw = (blqw)blmf.a(4);
    bmhp localbmhp = localblqw.a();
    if (localbmhp != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("StaticStickerProviderView", 2, "paster config updateData");
      }
      a(localblqw, localbmhp);
      setAdapter(localbmhp);
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
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter != null) && (blqw.a.compareAndSet(true, false))) {
      g();
    }
  }
  
  public void setAdapter(bmsb parambmsb)
  {
    if (this.jdField_a_of_type_Bmsb != null)
    {
      this.jdField_a_of_type_Bmsb.b(this);
      this.jdField_a_of_type_Bmsb = null;
    }
    if (parambmsb != null)
    {
      parambmsb.b(this);
      this.jdField_a_of_type_Bmsb = parambmsb;
      this.jdField_a_of_type_Bmsb.a(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(this.jdField_a_of_type_Bmsb);
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
  }
  
  public void setDownloadListener(bmri parambmri)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(parambmri);
  }
  
  public void setOnFaceSelectedListener(blof paramblof)
  {
    this.jdField_a_of_type_Blof = paramblof;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramblof);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.view.StaticStickerProviderView
 * JD-Core Version:    0.7.0.1
 */