package dov.com.qq.im.capture.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.LayoutInflater;
import bplq;
import bpnq;
import bpop;
import bpqh;
import bpqt;
import bpwl;
import bpwq;
import bpwr;
import bqcu;
import bqfc;
import bqgk;
import bqjl;
import bqov;
import bqow;
import bqpc;
import bqpd;
import bqpg;
import bqpj;
import bqpo;
import bqqr;
import bqrk;
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
import yuq;

@TargetApi(9)
public class StaticStickerProviderView
  extends ProviderView
  implements bpwl, bqpj, bqqr
{
  private int jdField_a_of_type_Int = 0;
  private bpnq jdField_a_of_type_Bpnq;
  bpop jdField_a_of_type_Bpop = new bpwr(this);
  bqpo jdField_a_of_type_Bqpo;
  FacePagerAdapter jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter;
  FaceViewPager jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager;
  public ArrayList<String> a;
  
  public StaticStickerProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(bpqh parambpqh, bqfc parambqfc)
  {
    parambpqh = new ArrayList(parambpqh.a());
    if (b())
    {
      parambpqh.add(0, new bqpc());
      parambqfc.a(true);
    }
    for (;;)
    {
      parambqfc.a(parambpqh);
      return;
      parambqfc.a(false);
    }
  }
  
  public static void a(Collection<bqow> paramCollection)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StaticStickerProviderView", 2, "random tab shufflePaster");
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      bqow localbqow = (bqow)paramCollection.next();
      if (localbqow.jdField_a_of_type_Boolean) {
        if ((localbqow instanceof bqpg)) {
          Collections.shuffle(((bqpg)localbqow).a);
        } else if ((localbqow instanceof bqpd)) {
          Collections.shuffle(((bqpd)localbqow).a);
        }
      }
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Bpvt != null) && ((this.jdField_a_of_type_Bpvt instanceof bqcu)))
    {
      bqgk localbqgk = ((bqcu)this.jdField_a_of_type_Bpvt).a;
      if ((localbqgk != null) && (localbqgk.a != null)) {
        return true;
      }
    }
    return false;
  }
  
  private void j()
  {
    ArrayList localArrayList1 = ((bpqt)bplq.a(1)).a();
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
      localArrayList2.add(0, bqpc.f);
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
    return 2131560997;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Bqpo != null) {
      this.jdField_a_of_type_Bqpo.b(this);
    }
    bqfc localbqfc = ((bpqh)bplq.a(4)).a();
    if (localbqfc != null) {
      localbqfc.b(this);
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_Bpop);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramInt);
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
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560997, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager = ((FaceViewPager)findViewById(2131366245));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter = new FacePagerAdapter(super.getContext());
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setAdapter(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.a(this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    j();
    bpqh localbpqh = (bpqh)bplq.a(4);
    localbpqh.e();
    paramBundle = localbpqh.a();
    a(localbpqh, paramBundle);
    setAdapter(paramBundle);
    Activity localActivity = (Activity)getContext();
    setDownloadListener(new bpwq(this, localActivity));
    paramBundle = (DoodleLayout)localActivity.findViewById(2131365676);
    if (paramBundle == null) {
      paramBundle = (DoodleLayout)localActivity.findViewById(2131364186);
    }
    for (;;)
    {
      setOnFaceSelectedListener(paramBundle.a());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_Bpop);
      localbpqh.a(true, (Activity)getContext());
      return;
    }
  }
  
  public void a(bqrk parambqrk)
  {
    if (((parambqrk instanceof bqjl)) && (this.jdField_a_of_type_JavaUtilArrayList != null))
    {
      Object localObject = (bqjl)parambqrk;
      parambqrk = ((bqjl)localObject).e;
      localObject = ((bqjl)localObject).d;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (TextUtils.equals((String)this.jdField_a_of_type_JavaUtilArrayList.get(i), (CharSequence)localObject))
        {
          b(i);
          postDelayed(new StaticStickerProviderView.3(this, i, parambqrk), 200L);
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StaticStickerProviderView", 2, "selectPosition category=" + (String)localObject + " name=" + parambqrk);
      }
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Bpnq != null) {
      this.jdField_a_of_type_Bpnq.a();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
    if (DoodleLayout.jdField_a_of_type_Boolean) {}
    for (Object localObject = "2";; localObject = "1")
    {
      DoodleLayout.a("change_face", 0, 0, new String[] { localObject });
      if (this.jdField_a_of_type_Bqpo != null)
      {
        localObject = this.jdField_a_of_type_Bqpo.a(paramInt);
        if ((localObject != null) && ((localObject instanceof bqow)))
        {
          yuq.a("0X80076C7", "", "", ((bqow)localObject).jdField_a_of_type_JavaLangString, "");
          yuq.a("0X80075DC", ((bqow)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      if (paramInt == 1)
      {
        yuq.a("0X80076CC");
        yuq.b("0X80075E1");
      }
      return;
    }
  }
  
  public void c()
  {
    super.c();
    bpqh localbpqh = (bpqh)bplq.a(4);
    bqfc localbqfc = localbpqh.a();
    if (localbqfc.a() != b()) {
      a(localbpqh, localbqfc);
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
    bpqh localbpqh = (bpqh)bplq.a(4);
    bqfc localbqfc = localbpqh.a();
    if (localbqfc != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("StaticStickerProviderView", 2, "paster config updateData");
      }
      a(localbpqh, localbqfc);
      setAdapter(localbqfc);
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
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter != null) && (bpqh.a.compareAndSet(true, false))) {
      g();
    }
  }
  
  public void setAdapter(bqpo parambqpo)
  {
    if (this.jdField_a_of_type_Bqpo != null)
    {
      this.jdField_a_of_type_Bqpo.b(this);
      this.jdField_a_of_type_Bqpo = null;
    }
    if (parambqpo != null)
    {
      parambqpo.b(this);
      this.jdField_a_of_type_Bqpo = parambqpo;
      this.jdField_a_of_type_Bqpo.a(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(this.jdField_a_of_type_Bqpo);
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
  }
  
  public void setDownloadListener(bqov parambqov)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(parambqov);
  }
  
  public void setOnFaceSelectedListener(bpnq parambpnq)
  {
    this.jdField_a_of_type_Bpnq = parambpnq;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(parambpnq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.view.StaticStickerProviderView
 * JD-Core Version:    0.7.0.1
 */