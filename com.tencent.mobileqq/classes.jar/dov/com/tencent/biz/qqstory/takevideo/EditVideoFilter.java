package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Canvas;
import android.os.Build;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import anzj;
import bqbs;
import bqff;
import bqgi;
import bqgk;
import bqrm;
import bqrn;
import bqro;
import bqrq;
import bqrt;
import bqua;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import java.util.ArrayList;
import java.util.List;
import wsc;
import wta;
import wth;
import yuk;
import yup;
import yuq;

public class EditVideoFilter
  extends bqgi
  implements bqbs
{
  public static final String a;
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e;
  public static final String f = anzj.a(2131702613);
  public static final String g = anzj.a(2131702608);
  public static final String h = anzj.a(2131702812);
  public static final String i = anzj.a(2131702708);
  public static final String j = anzj.a(2131702783);
  public static final String k = anzj.a(2131702807);
  public int a;
  public long a;
  public SparseArray<bqrm> a;
  private SparseIntArray a;
  protected bqro a;
  protected UnHandleTouchEventViewPager a;
  public EditVideoFilter.FilterPagerAdapter a;
  
  static
  {
    jdField_a_of_type_JavaLangString = anzj.a(2131702761);
    jdField_b_of_type_JavaLangString = anzj.a(2131702787);
    c = anzj.a(2131702665);
    d = anzj.a(2131702629);
    jdField_e_of_type_JavaLangString = anzj.a(2131702702);
  }
  
  public EditVideoFilter(@NonNull bqgk parambqgk)
  {
    super(parambqgk);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  }
  
  public static int a(@NonNull bqrm parambqrm)
  {
    yuk.b("Q.qqstory.publish.edit.EditVideoFilter", "getSpecialSaveMode : mVideoPlayMode = " + parambqrm.jdField_a_of_type_Int);
    switch (parambqrm.jdField_a_of_type_Int)
    {
    case 0: 
    default: 
      return 0;
    case 2: 
      return 1;
    case 8: 
      return 3;
    case 1: 
      return 5;
    case 3: 
      return 2;
    case 9: 
      return 4;
    case 4: 
      return 6;
    case 5: 
      return 7;
    case 6: 
      return 8;
    }
    return 9;
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getVisibility() == paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setVisibility(paramInt);
  }
  
  public static void a(bqrn parambqrn)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setStartOffset(1000L);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setFillAfter(true);
    parambqrn.a.startAnimation(localAlphaAnimation);
  }
  
  public int a()
  {
    return b(this.jdField_a_of_type_Bqgk.a());
  }
  
  public int a(int paramInt)
  {
    bqrm localbqrm = (bqrm)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbqrm == null) {
      return 0;
    }
    return localbqrm.jdField_a_of_type_Int;
  }
  
  @Nullable
  public View a()
  {
    int m = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    Object localObject = (bqrm)this.jdField_a_of_type_AndroidUtilSparseArray.get(m);
    localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(m);
    if ((localObject != null) && (((bqrn)localObject).a())) {
      return ((bqrn)localObject).a;
    }
    return null;
  }
  
  public bqrm a()
  {
    int m = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    bqrm localbqrm = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(m);
    if (localbqrm != null) {
      return localbqrm;
    }
    return null;
  }
  
  public bqro a()
  {
    return this.jdField_a_of_type_Bqro;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager = ((UnHandleTouchEventViewPager)a(2131365102));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter = new EditVideoFilter.FilterPagerAdapter(a());
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setAdapter(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setOnPageChangeListener(new bqff(this, null));
    yuk.b("Q.qqstory.publish.edit.EditVideoFilter", "init filter view pager : " + this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager);
    d();
    a(bqbs.class, this);
  }
  
  public void a(int paramInt, @NonNull bqua parambqua)
  {
    super.a(paramInt, parambqua);
    Object localObject1 = a();
    if (localObject1 != null) {
      parambqua.a.videoAddress = AddressItem.generatePoiJson(QQStoryContext.a().a(), ((bqro)localObject1).jdField_e_of_type_JavaLangString, ((bqro)localObject1).f, ((bqro)localObject1).g, ((bqro)localObject1).h, ((bqro)localObject1).i, ((bqro)localObject1).c, ((bqro)localObject1).d, ((bqro)localObject1).jdField_e_of_type_Int);
    }
    Object localObject2 = (bqrm)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((localObject1 != null) && (localObject2 != null) && ((localObject2 instanceof bqro))) {
      parambqua.a.gpsFilterDescription = ((bqro)localObject1).a();
    }
    if (this.jdField_a_of_type_Bqgk.a.d()) {
      parambqua.a.localCreateCity = this.jdField_a_of_type_Bqgk.a.a("extra_local_address_city_name");
    }
    parambqua.a(a());
    parambqua.a.saveMode = b(paramInt);
    parambqua = "";
    int m = -1;
    paramInt = 0;
    int n;
    if (localObject2 != null)
    {
      localObject1 = ((bqrm)localObject2).jdField_a_of_type_JavaLangString;
      n = ((bqrm)localObject2).jdField_b_of_type_Int;
      int i1 = ((bqrm)localObject2).jdField_a_of_type_Int;
      paramInt = i1;
      m = n;
      parambqua = (bqua)localObject1;
      if (((bqrm)localObject2).jdField_b_of_type_Int != -1)
      {
        this.jdField_a_of_type_Bqgk.a().setFilterId(((bqrm)localObject2).jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Bqgk.a().setFilterType(2);
        parambqua = (bqua)localObject1;
        m = n;
        paramInt = i1;
      }
    }
    long l;
    if (m != -1)
    {
      localObject2 = this.jdField_a_of_type_Bqgk;
      n = this.jdField_a_of_type_Bqgk.b();
      if (this.jdField_a_of_type_Bqgk.a())
      {
        localObject1 = "2";
        ((bqgk)localObject2).b("pub_filter_menu", n, 0, new String[] { String.valueOf(m), parambqua, localObject1 });
      }
    }
    else
    {
      if (m != -1) {
        yuq.a("0X80076E9", String.valueOf(yuq.jdField_b_of_type_Int), String.valueOf(paramInt), parambqua, String.valueOf(m));
      }
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      paramInt = this.jdField_a_of_type_Int;
      yuk.a("Q.qqstory.publish.edit.EditVideoFilter", "intervalTime : %s , videoMode : %s. ", Long.valueOf(l), Integer.valueOf(paramInt));
      if (!this.jdField_a_of_type_Bqgk.a()) {
        break label437;
      }
    }
    label437:
    for (parambqua = "2";; parambqua = "1")
    {
      yup.b("video_edit", "pub_filter_interval_time", 0, 0, new String[] { String.valueOf(l), String.valueOf(paramInt), parambqua });
      return;
      localObject1 = "1";
      break;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(paramInt, paramString);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.notifyDataSetChanged();
  }
  
  public boolean a(int paramInt)
  {
    bqrm localbqrm = (bqrm)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    return (localbqrm != null) && (localbqrm.a());
  }
  
  public boolean a(int paramInt1, Canvas paramCanvas, int paramInt2, int paramInt3)
  {
    Object localObject1 = null;
    paramInt1 = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt1);
    Object localObject2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(paramInt1);
    int m = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getWidth();
    int n = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getHeight();
    if (localObject2 != null)
    {
      if (!((bqrn)localObject2).a()) {
        break label226;
      }
      localObject1 = ((bqrn)localObject2).a;
      localObject2 = null;
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        paramCanvas.save();
        paramCanvas.scale(paramInt2 / m, paramInt3 / n);
        ((View)localObject1).draw(paramCanvas);
        paramCanvas.restore();
        if (localObject2 != null) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.destroyItem((ViewGroup)localObject1, paramInt1, localObject2);
        }
        return true;
        localObject1 = new FrameLayout(a());
        ((View)localObject1).setLayoutParams(new ViewGroup.LayoutParams(this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getLayoutParams()));
        localObject2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.instantiateItem((ViewGroup)localObject1, paramInt1);
        ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getMeasuredHeight(), 1073741824));
        ((View)localObject1).layout(0, 0, this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getWidth(), this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getHeight());
      }
      else
      {
        return false;
        label226:
        localObject2 = null;
      }
    }
  }
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((paramMessage.obj instanceof wsc))
      {
        paramMessage = (wsc)paramMessage.obj;
        this.jdField_a_of_type_Bqro = new bqro(0, i, 8, paramMessage.c, paramMessage.d, paramMessage.jdField_a_of_type_JavaLangString, paramMessage.c, paramMessage.jdField_b_of_type_JavaLangString, paramMessage.jdField_e_of_type_JavaLangString, "", paramMessage.jdField_a_of_type_Int, paramMessage.jdField_b_of_type_Int, 1);
        d();
        yuk.a("Q.qqstory.publish.edit.EditVideoFilter", "handleEditVideoMessage MESSAGE_LOCATION_LOCAL_ADDRESS_UPDATE POIFilterData is available : country : %s, city : %s, district : %s .", paramMessage.jdField_a_of_type_JavaLangString, paramMessage.c, paramMessage.d);
      }
      for (;;)
      {
        return true;
        yuk.e("Q.qqstory.publish.edit.EditVideoFilter", "handleEditVideoMessage MESSAGE_LOCATION_LOCAL_ADDRESS_UPDATE Message Error! Message obj type mismatch");
      }
      int m = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
      int n = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(this.jdField_a_of_type_Bqgk.a(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a() * 50);
      yuk.b("Q.qqstory.publish.edit.EditVideoFilter", "change video block from %d to %d, change page from %d to %d", Integer.valueOf(paramMessage.arg1), Integer.valueOf(paramMessage.arg2), Integer.valueOf(m), Integer.valueOf(n));
      if (m != n) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(n, false);
      }
    }
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 11: 
    case 12: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 25: 
    case 26: 
    default: 
      a(4);
    case 10: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 24: 
      return;
    }
    a(0);
  }
  
  public int b()
  {
    int m = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    bqrm localbqrm = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(m);
    if (localbqrm != null) {
      return localbqrm.jdField_b_of_type_Int;
    }
    return -1;
  }
  
  public int b(int paramInt)
  {
    bqrm localbqrm = (bqrm)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbqrm == null) {
      return 0;
    }
    return a(localbqrm);
  }
  
  public void d()
  {
    yuk.a("Q.qqstory.publish.edit.EditVideoFilter", "updateFilterMode : %s", this.jdField_a_of_type_Bqgk.a.a);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new bqrt(jdField_a_of_type_JavaLangString, -1, 0, 0));
    boolean bool;
    if (((this.jdField_a_of_type_Bqgk.a.a instanceof EditRecordVideoSource)) || ((this.jdField_a_of_type_Bqgk.a.a instanceof EditTakeVideoSource)))
    {
      if (((this.jdField_a_of_type_Bqgk.a.a instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL)))
      {
        if ((!"Meizu".equalsIgnoreCase(Build.MANUFACTURER)) || (!"MX4 Pro".equalsIgnoreCase(Build.MODEL)))
        {
          bool = ((Boolean)((wta)wth.a(10)).b("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue();
          if ((!(this.jdField_a_of_type_Bqgk.a.a instanceof EditTakeVideoSource)) || (bool)) {
            break label492;
          }
          yuk.d("Q.qqstory.publish.edit.EditVideoFilter", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        }
        label201:
        if ((!(this.jdField_a_of_type_Bqgk.a.a instanceof EditTakeVideoSource)) || (!"HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) || ((!"CHE-TL00".equalsIgnoreCase(Build.MODEL)) && (!"CAM-TL00".equalsIgnoreCase(Build.MODEL)) && (!"MHA-AL00".equalsIgnoreCase(Build.MODEL)) && (!"CHM-TL00".equalsIgnoreCase(Build.MODEL)))) {
          break label543;
        }
      }
    }
    else
    {
      label277:
      localArrayList.add(new bqrq(0, h, 7));
      if (this.jdField_a_of_type_Bqro != null) {
        localArrayList.add(this.jdField_a_of_type_Bqro);
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(localArrayList);
      this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(localArrayList.size() * 50, false);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (!localArrayList.isEmpty()) {
        break label948;
      }
    }
    label543:
    label948:
    for (int m = 0;; m = ((bqrm)localArrayList.get(0)).jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = m;
      return;
      bool = ((Boolean)((wta)wth.a(10)).b("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue();
      if (((this.jdField_a_of_type_Bqgk.a.a instanceof EditTakeVideoSource)) && (!bool))
      {
        yuk.d("Q.qqstory.publish.edit.EditVideoFilter", "it's fast black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        break;
      }
      localArrayList.add(new bqrt(jdField_b_of_type_JavaLangString, 1, 2130846528, 2));
      localArrayList.add(new bqrt(j, 9, 2130846528, 8));
      break;
      label492:
      localArrayList.add(new bqrt(c, 2, 2130846529, 3));
      localArrayList.add(new bqrt(k, 10, 2130846529, 9));
      break label201;
      if ((((this.jdField_a_of_type_Bqgk.a.a instanceof EditTakeVideoSource)) && ("GIONEE".equalsIgnoreCase(Build.MANUFACTURER)) && ("GN9011".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_Bqgk.a.a instanceof EditTakeVideoSource)) && ("ZTE".equalsIgnoreCase(Build.MANUFACTURER)) && ("ZTE A2017".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_Bqgk.a.a instanceof EditTakeVideoSource)) && ("Xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) && ("HM NOTE 1W".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_Bqgk.a.a instanceof EditTakeVideoSource)) && ("OnePlus".equalsIgnoreCase(Build.MANUFACTURER)) && ("ONEPLUS A3000".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_Bqgk.a.a instanceof EditTakeVideoSource)) && ("vivo Y67".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_Bqgk.a.a instanceof EditTakeVideoSource)) && ("OPPO R7sm".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_Bqgk.a.a instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_Bqgk.a.a instanceof EditTakeVideoSource)) && ("GN5001S".equalsIgnoreCase(Build.MODEL)))) {
        break label277;
      }
      bool = ((Boolean)((wta)wth.a(10)).b("boolean_enable_revert_play_mode", Boolean.valueOf(true))).booleanValue();
      if (((this.jdField_a_of_type_Bqgk.a.a instanceof EditTakeVideoSource)) && (!bool))
      {
        yuk.d("Q.qqstory.publish.edit.EditVideoFilter", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        break label277;
      }
      bqrt localbqrt = new bqrt(d, 3, 2130846527, 1);
      if (this.jdField_a_of_type_Bqgk.a.i()) {}
      for (String str = anzj.a(2131702734);; str = null)
      {
        localbqrt.jdField_b_of_type_JavaLangString = str;
        localArrayList.add(localbqrt);
        break;
      }
    }
  }
  
  public void f()
  {
    super.f();
  }
  
  public void j() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter
 * JD-Core Version:    0.7.0.1
 */