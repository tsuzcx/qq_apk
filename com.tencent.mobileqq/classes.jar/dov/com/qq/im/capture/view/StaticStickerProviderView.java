package dov.com.qq.im.capture.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.LayoutInflater;
import bjav;
import bjcu;
import bjdt;
import bjfl;
import bjfx;
import bjlq;
import bjlv;
import bjlw;
import bjtx;
import bjwf;
import bjxn;
import bkao;
import bkfy;
import bkfz;
import bkgf;
import bkgg;
import bkgj;
import bkgm;
import bkgr;
import bkhu;
import bkin;
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
import vej;

@TargetApi(9)
public class StaticStickerProviderView
  extends ProviderView
  implements bjlq, bkgm, bkhu
{
  private int jdField_a_of_type_Int = 0;
  private bjcu jdField_a_of_type_Bjcu;
  bjdt jdField_a_of_type_Bjdt = new bjlw(this);
  bkgr jdField_a_of_type_Bkgr;
  FacePagerAdapter jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter;
  FaceViewPager jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager;
  public ArrayList<String> a;
  
  public StaticStickerProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(bjfl parambjfl, bjwf parambjwf)
  {
    parambjfl = new ArrayList(parambjfl.a());
    if (b())
    {
      parambjfl.add(0, new bkgf());
      parambjwf.a(true);
    }
    for (;;)
    {
      parambjwf.a(parambjfl);
      return;
      parambjwf.a(false);
    }
  }
  
  public static void a(Collection<bkfz> paramCollection)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StaticStickerProviderView", 2, "random tab shufflePaster");
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      bkfz localbkfz = (bkfz)paramCollection.next();
      if (localbkfz.jdField_a_of_type_Boolean) {
        if ((localbkfz instanceof bkgj)) {
          Collections.shuffle(((bkgj)localbkfz).a);
        } else if ((localbkfz instanceof bkgg)) {
          Collections.shuffle(((bkgg)localbkfz).a);
        }
      }
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Bjky != null) && ((this.jdField_a_of_type_Bjky instanceof bjtx)))
    {
      bjxn localbjxn = ((bjtx)this.jdField_a_of_type_Bjky).a;
      if ((localbjxn != null) && (localbjxn.a != null)) {
        return true;
      }
    }
    return false;
  }
  
  private void j()
  {
    ArrayList localArrayList1 = ((bjfx)bjav.a(1)).a();
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
      localArrayList2.add(0, bkgf.f);
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
    return 2131560567;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Bkgr != null) {
      this.jdField_a_of_type_Bkgr.b(this);
    }
    bjwf localbjwf = ((bjfl)bjav.a(4)).a();
    if (localbjwf != null) {
      localbjwf.b(this);
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_Bjdt);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
    if (DoodleLayout.jdField_a_of_type_Boolean) {}
    for (Object localObject = "2";; localObject = "1")
    {
      DoodleLayout.a("change_face", 0, 0, new String[] { localObject });
      if (this.jdField_a_of_type_Bkgr != null)
      {
        localObject = this.jdField_a_of_type_Bkgr.a(paramInt);
        if ((localObject != null) && ((localObject instanceof bkfz)))
        {
          vej.a("0X80076C7", "", "", ((bkfz)localObject).jdField_a_of_type_JavaLangString, "");
          vej.a("0X80075DC", ((bkfz)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      if (paramInt == 1)
      {
        vej.a("0X80076CC");
        vej.b("0X80075E1");
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
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560567, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager = ((FaceViewPager)findViewById(2131365857));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter = new FacePagerAdapter(super.getContext());
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setAdapter(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.a(this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    j();
    bjfl localbjfl = (bjfl)bjav.a(4);
    localbjfl.i();
    paramBundle = localbjfl.a();
    a(localbjfl, paramBundle);
    setAdapter(paramBundle);
    Activity localActivity = (Activity)getContext();
    setDownloadListener(new bjlv(this, localActivity));
    paramBundle = (DoodleLayout)localActivity.findViewById(2131365311);
    if (paramBundle == null) {
      paramBundle = (DoodleLayout)localActivity.findViewById(2131363882);
    }
    for (;;)
    {
      setOnFaceSelectedListener(paramBundle.a());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_Bjdt);
      localbjfl.a(true, (Activity)getContext());
      return;
    }
  }
  
  public void a(bkin parambkin)
  {
    if (((parambkin instanceof bkao)) && (this.jdField_a_of_type_JavaUtilArrayList != null))
    {
      Object localObject = (bkao)parambkin;
      parambkin = ((bkao)localObject).e;
      localObject = ((bkao)localObject).d;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (TextUtils.equals((String)this.jdField_a_of_type_JavaUtilArrayList.get(i), (CharSequence)localObject))
        {
          a(i);
          postDelayed(new StaticStickerProviderView.3(this, i, parambkin), 200L);
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StaticStickerProviderView", 2, "selectPosition category=" + (String)localObject + " name=" + parambkin);
      }
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Bjcu != null) {
      this.jdField_a_of_type_Bjcu.a();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramInt);
  }
  
  public void c()
  {
    super.c();
    bjfl localbjfl = (bjfl)bjav.a(4);
    bjwf localbjwf = localbjfl.a();
    if (localbjwf.a() != b()) {
      a(localbjfl, localbjwf);
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
    bjfl localbjfl = (bjfl)bjav.a(4);
    bjwf localbjwf = localbjfl.a();
    if (localbjwf != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("StaticStickerProviderView", 2, "paster config updateData");
      }
      a(localbjfl, localbjwf);
      setAdapter(localbjwf);
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
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter != null) && (bjfl.a.compareAndSet(true, false))) {
      g();
    }
  }
  
  public void setAdapter(bkgr parambkgr)
  {
    if (this.jdField_a_of_type_Bkgr != null)
    {
      this.jdField_a_of_type_Bkgr.b(this);
      this.jdField_a_of_type_Bkgr = null;
    }
    if (parambkgr != null)
    {
      parambkgr.b(this);
      this.jdField_a_of_type_Bkgr = parambkgr;
      this.jdField_a_of_type_Bkgr.a(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(this.jdField_a_of_type_Bkgr);
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
  }
  
  public void setDownloadListener(bkfy parambkfy)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(parambkfy);
  }
  
  public void setOnFaceSelectedListener(bjcu parambjcu)
  {
    this.jdField_a_of_type_Bjcu = parambjcu;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(parambjcu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.StaticStickerProviderView
 * JD-Core Version:    0.7.0.1
 */