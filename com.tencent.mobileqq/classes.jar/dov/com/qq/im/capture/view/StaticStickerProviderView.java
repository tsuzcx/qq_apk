package dov.com.qq.im.capture.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.LayoutInflater;
import bhfm;
import bhhl;
import bhik;
import bhkc;
import bhko;
import bhqh;
import bhqm;
import bhqn;
import bicj;
import bier;
import bigb;
import bijc;
import biom;
import bion;
import biot;
import biou;
import biox;
import bipa;
import bipf;
import biqi;
import birb;
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
import urq;

@TargetApi(9)
public class StaticStickerProviderView
  extends ProviderView
  implements bhqh, bipa, biqi
{
  private int jdField_a_of_type_Int = 0;
  private bhhl jdField_a_of_type_Bhhl;
  bhik jdField_a_of_type_Bhik = new bhqn(this);
  bipf jdField_a_of_type_Bipf;
  FacePagerAdapter jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter;
  FaceViewPager jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager;
  public ArrayList<String> a;
  
  public StaticStickerProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(bhkc parambhkc, bier parambier)
  {
    parambhkc = new ArrayList(parambhkc.a());
    if (b())
    {
      parambhkc.add(0, new biot());
      parambier.a(true);
    }
    for (;;)
    {
      parambier.a(parambhkc);
      return;
      parambier.a(false);
    }
  }
  
  public static void a(Collection<bion> paramCollection)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StaticStickerProviderView", 2, "random tab shufflePaster");
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      bion localbion = (bion)paramCollection.next();
      if (localbion.jdField_a_of_type_Boolean) {
        if ((localbion instanceof biox)) {
          Collections.shuffle(((biox)localbion).a);
        } else if ((localbion instanceof biou)) {
          Collections.shuffle(((biou)localbion).a);
        }
      }
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Bhpp != null) && ((this.jdField_a_of_type_Bhpp instanceof bicj)))
    {
      bigb localbigb = ((bicj)this.jdField_a_of_type_Bhpp).a;
      if ((localbigb != null) && (localbigb.a != null)) {
        return true;
      }
    }
    return false;
  }
  
  private void j()
  {
    ArrayList localArrayList1 = ((bhko)bhfm.a(1)).a();
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
      localArrayList2.add(0, biot.f);
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
    return 2131494994;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Bipf != null) {
      this.jdField_a_of_type_Bipf.b(this);
    }
    bier localbier = ((bhkc)bhfm.a(4)).a();
    if (localbier != null) {
      localbier.b(this);
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_Bhik);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
    if (DoodleLayout.jdField_a_of_type_Boolean) {}
    for (Object localObject = "2";; localObject = "1")
    {
      DoodleLayout.a("change_face", 0, 0, new String[] { localObject });
      if (this.jdField_a_of_type_Bipf != null)
      {
        localObject = this.jdField_a_of_type_Bipf.a(paramInt);
        if ((localObject != null) && ((localObject instanceof bion)))
        {
          urq.a("0X80076C7", "", "", ((bion)localObject).jdField_a_of_type_JavaLangString, "");
          urq.a("0X80075DC", ((bion)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      if (paramInt == 1)
      {
        urq.a("0X80076CC");
        urq.b("0X80075E1");
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
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131494994, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager = ((FaceViewPager)findViewById(2131300258));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter = new FacePagerAdapter(super.getContext());
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setAdapter(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.a(this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    j();
    bhkc localbhkc = (bhkc)bhfm.a(4);
    localbhkc.g();
    paramBundle = localbhkc.a();
    a(localbhkc, paramBundle);
    setAdapter(paramBundle);
    Activity localActivity = (Activity)getContext();
    setDownloadListener(new bhqm(this, localActivity));
    paramBundle = (DoodleLayout)localActivity.findViewById(2131299744);
    if (paramBundle == null) {
      paramBundle = (DoodleLayout)localActivity.findViewById(2131298327);
    }
    for (;;)
    {
      setOnFaceSelectedListener(paramBundle.a());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_Bhik);
      localbhkc.a(true, (Activity)getContext());
      return;
    }
  }
  
  public void a(birb parambirb)
  {
    if (((parambirb instanceof bijc)) && (this.jdField_a_of_type_JavaUtilArrayList != null))
    {
      Object localObject = (bijc)parambirb;
      parambirb = ((bijc)localObject).e;
      localObject = ((bijc)localObject).d;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (TextUtils.equals((String)this.jdField_a_of_type_JavaUtilArrayList.get(i), (CharSequence)localObject))
        {
          a(i);
          postDelayed(new StaticStickerProviderView.3(this, i, parambirb), 200L);
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StaticStickerProviderView", 2, "selectPosition category=" + (String)localObject + " name=" + parambirb);
      }
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Bhhl != null) {
      this.jdField_a_of_type_Bhhl.a();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramInt);
  }
  
  public void c()
  {
    super.c();
    bhkc localbhkc = (bhkc)bhfm.a(4);
    bier localbier = localbhkc.a();
    if (localbier.a() != b()) {
      a(localbhkc, localbier);
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
    bhkc localbhkc = (bhkc)bhfm.a(4);
    bier localbier = localbhkc.a();
    if (localbier != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("StaticStickerProviderView", 2, "paster config updateData");
      }
      a(localbhkc, localbier);
      setAdapter(localbier);
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
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter != null) && (bhkc.a.compareAndSet(true, false))) {
      g();
    }
  }
  
  public void setAdapter(bipf parambipf)
  {
    if (this.jdField_a_of_type_Bipf != null)
    {
      this.jdField_a_of_type_Bipf.b(this);
      this.jdField_a_of_type_Bipf = null;
    }
    if (parambipf != null)
    {
      parambipf.b(this);
      this.jdField_a_of_type_Bipf = parambipf;
      this.jdField_a_of_type_Bipf.a(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(this.jdField_a_of_type_Bipf);
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
  }
  
  public void setDownloadListener(biom parambiom)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(parambiom);
  }
  
  public void setOnFaceSelectedListener(bhhl parambhhl)
  {
    this.jdField_a_of_type_Bhhl = parambhhl;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(parambhhl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.StaticStickerProviderView
 * JD-Core Version:    0.7.0.1
 */