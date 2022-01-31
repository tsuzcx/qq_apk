package dov.com.tencent.biz.qqstory.takevideo;

import ajya;
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
import bjsv;
import bjwi;
import bjxl;
import bjxn;
import bkip;
import bkiq;
import bkir;
import bkit;
import bkiw;
import bkld;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import java.util.ArrayList;
import java.util.List;
import tbu;
import tcs;
import tcz;
import ved;
import vei;
import vej;

public class EditVideoFilter
  extends bjxl
  implements bjsv
{
  public static final String a;
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e;
  public static final String f = ajya.a(2131703725);
  public static final String g = ajya.a(2131703720);
  public static final String h = ajya.a(2131703924);
  public static final String i = ajya.a(2131703820);
  public static final String j = ajya.a(2131703895);
  public static final String k = ajya.a(2131703919);
  public int a;
  public long a;
  public SparseArray<bkip> a;
  private SparseIntArray a;
  protected bkir a;
  protected UnHandleTouchEventViewPager a;
  public EditVideoFilter.FilterPagerAdapter a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajya.a(2131703873);
    jdField_b_of_type_JavaLangString = ajya.a(2131703899);
    c = ajya.a(2131703777);
    d = ajya.a(2131703741);
    jdField_e_of_type_JavaLangString = ajya.a(2131703814);
  }
  
  public EditVideoFilter(@NonNull bjxn parambjxn)
  {
    super(parambjxn);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  }
  
  public static int a(@NonNull bkip parambkip)
  {
    ved.b("Q.qqstory.publish.edit.EditVideoFilter", "getSpecialSaveMode : mVideoPlayMode = " + parambkip.jdField_a_of_type_Int);
    switch (parambkip.jdField_a_of_type_Int)
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
  
  public static void a(bkiq parambkiq)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setStartOffset(1000L);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setFillAfter(true);
    parambkiq.a.startAnimation(localAlphaAnimation);
  }
  
  public int a()
  {
    return b(this.jdField_a_of_type_Bjxn.a());
  }
  
  public int a(int paramInt)
  {
    bkip localbkip = (bkip)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbkip == null) {
      return 0;
    }
    return localbkip.jdField_a_of_type_Int;
  }
  
  @Nullable
  public View a()
  {
    int m = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    Object localObject = (bkip)this.jdField_a_of_type_AndroidUtilSparseArray.get(m);
    localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(m);
    if ((localObject != null) && (((bkiq)localObject).a())) {
      return ((bkiq)localObject).a;
    }
    return null;
  }
  
  public bkip a()
  {
    int m = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    bkip localbkip = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(m);
    if (localbkip != null) {
      return localbkip;
    }
    return null;
  }
  
  public bkir a()
  {
    return this.jdField_a_of_type_Bkir;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager = ((UnHandleTouchEventViewPager)a(2131364743));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter = new EditVideoFilter.FilterPagerAdapter(a());
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setAdapter(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setOnPageChangeListener(new bjwi(this, null));
    ved.b("Q.qqstory.publish.edit.EditVideoFilter", "init filter view pager : " + this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager);
    d();
    a(bjsv.class, this);
  }
  
  public void a(int paramInt, @NonNull bkld parambkld)
  {
    super.a(paramInt, parambkld);
    Object localObject1 = a();
    if (localObject1 != null) {
      parambkld.a.videoAddress = AddressItem.generatePoiJson(QQStoryContext.a().a(), ((bkir)localObject1).jdField_e_of_type_JavaLangString, ((bkir)localObject1).f, ((bkir)localObject1).g, ((bkir)localObject1).h, ((bkir)localObject1).i, ((bkir)localObject1).c, ((bkir)localObject1).d, ((bkir)localObject1).jdField_e_of_type_Int);
    }
    Object localObject2 = (bkip)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((localObject1 != null) && (localObject2 != null) && ((localObject2 instanceof bkir))) {
      parambkld.a.gpsFilterDescription = ((bkir)localObject1).a();
    }
    if (this.jdField_a_of_type_Bjxn.a.d()) {
      parambkld.a.localCreateCity = this.jdField_a_of_type_Bjxn.a.a("extra_local_address_city_name");
    }
    parambkld.a(a());
    parambkld.a.saveMode = b(paramInt);
    parambkld = "";
    int m = -1;
    paramInt = 0;
    int n;
    if (localObject2 != null)
    {
      localObject1 = ((bkip)localObject2).jdField_a_of_type_JavaLangString;
      n = ((bkip)localObject2).jdField_b_of_type_Int;
      int i1 = ((bkip)localObject2).jdField_a_of_type_Int;
      paramInt = i1;
      m = n;
      parambkld = (bkld)localObject1;
      if (((bkip)localObject2).jdField_b_of_type_Int != -1)
      {
        this.jdField_a_of_type_Bjxn.a().setFilterId(((bkip)localObject2).jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Bjxn.a().setFilterType(2);
        parambkld = (bkld)localObject1;
        m = n;
        paramInt = i1;
      }
    }
    long l;
    if (m != -1)
    {
      localObject2 = this.jdField_a_of_type_Bjxn;
      n = this.jdField_a_of_type_Bjxn.b();
      if (this.jdField_a_of_type_Bjxn.a())
      {
        localObject1 = "2";
        ((bjxn)localObject2).b("pub_filter_menu", n, 0, new String[] { String.valueOf(m), parambkld, localObject1 });
      }
    }
    else
    {
      if (m != -1) {
        vej.a("0X80076E9", String.valueOf(vej.jdField_b_of_type_Int), String.valueOf(paramInt), parambkld, String.valueOf(m));
      }
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      paramInt = this.jdField_a_of_type_Int;
      ved.a("Q.qqstory.publish.edit.EditVideoFilter", "intervalTime : %s , videoMode : %s. ", Long.valueOf(l), Integer.valueOf(paramInt));
      if (!this.jdField_a_of_type_Bjxn.a()) {
        break label437;
      }
    }
    label437:
    for (parambkld = "2";; parambkld = "1")
    {
      vei.b("video_edit", "pub_filter_interval_time", 0, 0, new String[] { String.valueOf(l), String.valueOf(paramInt), parambkld });
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
    bkip localbkip = (bkip)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    return (localbkip != null) && (localbkip.a());
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
      if (!((bkiq)localObject2).a()) {
        break label226;
      }
      localObject1 = ((bkiq)localObject2).a;
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
      if ((paramMessage.obj instanceof tbu))
      {
        paramMessage = (tbu)paramMessage.obj;
        this.jdField_a_of_type_Bkir = new bkir(0, i, 8, paramMessage.c, paramMessage.d, paramMessage.jdField_a_of_type_JavaLangString, paramMessage.c, paramMessage.jdField_b_of_type_JavaLangString, paramMessage.jdField_e_of_type_JavaLangString, "", paramMessage.jdField_a_of_type_Int, paramMessage.jdField_b_of_type_Int, 1);
        d();
        ved.a("Q.qqstory.publish.edit.EditVideoFilter", "handleEditVideoMessage MESSAGE_LOCATION_LOCAL_ADDRESS_UPDATE POIFilterData is available : country : %s, city : %s, district : %s .", paramMessage.jdField_a_of_type_JavaLangString, paramMessage.c, paramMessage.d);
      }
      for (;;)
      {
        return true;
        ved.e("Q.qqstory.publish.edit.EditVideoFilter", "handleEditVideoMessage MESSAGE_LOCATION_LOCAL_ADDRESS_UPDATE Message Error! Message obj type mismatch");
      }
      int m = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
      int n = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(this.jdField_a_of_type_Bjxn.a(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a() * 50);
      ved.b("Q.qqstory.publish.edit.EditVideoFilter", "change video block from %d to %d, change page from %d to %d", Integer.valueOf(paramMessage.arg1), Integer.valueOf(paramMessage.arg2), Integer.valueOf(m), Integer.valueOf(n));
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
    bkip localbkip = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(m);
    if (localbkip != null) {
      return localbkip.jdField_b_of_type_Int;
    }
    return -1;
  }
  
  public int b(int paramInt)
  {
    bkip localbkip = (bkip)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbkip == null) {
      return 0;
    }
    return a(localbkip);
  }
  
  public void d()
  {
    ved.a("Q.qqstory.publish.edit.EditVideoFilter", "updateFilterMode : %s", this.jdField_a_of_type_Bjxn.a.a);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new bkiw(jdField_a_of_type_JavaLangString, -1, 0, 0));
    boolean bool;
    if (((this.jdField_a_of_type_Bjxn.a.a instanceof EditRecordVideoSource)) || ((this.jdField_a_of_type_Bjxn.a.a instanceof EditTakeVideoSource)))
    {
      if (((this.jdField_a_of_type_Bjxn.a.a instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL)))
      {
        if ((!"Meizu".equalsIgnoreCase(Build.MANUFACTURER)) || (!"MX4 Pro".equalsIgnoreCase(Build.MODEL)))
        {
          bool = ((Boolean)((tcs)tcz.a(10)).b("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue();
          if ((!(this.jdField_a_of_type_Bjxn.a.a instanceof EditTakeVideoSource)) || (bool)) {
            break label492;
          }
          ved.d("Q.qqstory.publish.edit.EditVideoFilter", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        }
        label201:
        if ((!(this.jdField_a_of_type_Bjxn.a.a instanceof EditTakeVideoSource)) || (!"HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) || ((!"CHE-TL00".equalsIgnoreCase(Build.MODEL)) && (!"CAM-TL00".equalsIgnoreCase(Build.MODEL)) && (!"MHA-AL00".equalsIgnoreCase(Build.MODEL)) && (!"CHM-TL00".equalsIgnoreCase(Build.MODEL)))) {
          break label543;
        }
      }
    }
    else
    {
      label277:
      localArrayList.add(new bkit(0, h, 7));
      if (this.jdField_a_of_type_Bkir != null) {
        localArrayList.add(this.jdField_a_of_type_Bkir);
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
    for (int m = 0;; m = ((bkip)localArrayList.get(0)).jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = m;
      return;
      bool = ((Boolean)((tcs)tcz.a(10)).b("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue();
      if (((this.jdField_a_of_type_Bjxn.a.a instanceof EditTakeVideoSource)) && (!bool))
      {
        ved.d("Q.qqstory.publish.edit.EditVideoFilter", "it's fast black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        break;
      }
      localArrayList.add(new bkiw(jdField_b_of_type_JavaLangString, 1, 2130845620, 2));
      localArrayList.add(new bkiw(j, 9, 2130845620, 8));
      break;
      label492:
      localArrayList.add(new bkiw(c, 2, 2130845621, 3));
      localArrayList.add(new bkiw(k, 10, 2130845621, 9));
      break label201;
      if ((((this.jdField_a_of_type_Bjxn.a.a instanceof EditTakeVideoSource)) && ("GIONEE".equalsIgnoreCase(Build.MANUFACTURER)) && ("GN9011".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_Bjxn.a.a instanceof EditTakeVideoSource)) && ("ZTE".equalsIgnoreCase(Build.MANUFACTURER)) && ("ZTE A2017".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_Bjxn.a.a instanceof EditTakeVideoSource)) && ("Xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) && ("HM NOTE 1W".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_Bjxn.a.a instanceof EditTakeVideoSource)) && ("OnePlus".equalsIgnoreCase(Build.MANUFACTURER)) && ("ONEPLUS A3000".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_Bjxn.a.a instanceof EditTakeVideoSource)) && ("vivo Y67".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_Bjxn.a.a instanceof EditTakeVideoSource)) && ("OPPO R7sm".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_Bjxn.a.a instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_Bjxn.a.a instanceof EditTakeVideoSource)) && ("GN5001S".equalsIgnoreCase(Build.MODEL)))) {
        break label277;
      }
      bool = ((Boolean)((tcs)tcz.a(10)).b("boolean_enable_revert_play_mode", Boolean.valueOf(true))).booleanValue();
      if (((this.jdField_a_of_type_Bjxn.a.a instanceof EditTakeVideoSource)) && (!bool))
      {
        ved.d("Q.qqstory.publish.edit.EditVideoFilter", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        break label277;
      }
      bkiw localbkiw = new bkiw(d, 3, 2130845619, 1);
      if (this.jdField_a_of_type_Bjxn.a.i()) {}
      for (String str = ajya.a(2131703846);; str = null)
      {
        localbkiw.jdField_b_of_type_JavaLangString = str;
        localArrayList.add(localbkiw);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter
 * JD-Core Version:    0.7.0.1
 */