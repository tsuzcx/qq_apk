package dov.com.tencent.biz.qqstory.takevideo;

import ajjy;
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
import bibh;
import bieu;
import bifz;
import bigb;
import bird;
import bire;
import birf;
import birm;
import birp;
import bitz;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import java.util.ArrayList;
import java.util.List;
import spb;
import spz;
import sqg;
import urk;
import urp;
import urq;

public class EditVideoFilter
  extends bifz
  implements bibh
{
  public static final String a;
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e;
  public static final String f = ajjy.a(2131637929);
  public static final String g = ajjy.a(2131637924);
  public static final String h = ajjy.a(2131638128);
  public static final String i = ajjy.a(2131638024);
  public static final String j = ajjy.a(2131638099);
  public static final String k = ajjy.a(2131638123);
  public int a;
  public long a;
  public SparseArray<bird> a;
  private SparseIntArray a;
  protected birf a;
  protected UnHandleTouchEventViewPager a;
  public EditVideoFilter.FilterPagerAdapter a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajjy.a(2131638077);
    jdField_b_of_type_JavaLangString = ajjy.a(2131638103);
    c = ajjy.a(2131637981);
    d = ajjy.a(2131637945);
    jdField_e_of_type_JavaLangString = ajjy.a(2131638018);
  }
  
  public EditVideoFilter(@NonNull bigb parambigb)
  {
    super(parambigb);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  }
  
  public static int a(@NonNull bird parambird)
  {
    urk.b("Q.qqstory.publish.edit.EditVideoFilter", "getSpecialSaveMode : mVideoPlayMode = " + parambird.jdField_a_of_type_Int);
    switch (parambird.jdField_a_of_type_Int)
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
  
  public static void a(bire parambire)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setStartOffset(1000L);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setFillAfter(true);
    parambire.a.startAnimation(localAlphaAnimation);
  }
  
  public int a()
  {
    return b(this.jdField_a_of_type_Bigb.a());
  }
  
  public int a(int paramInt)
  {
    bird localbird = (bird)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbird == null) {
      return 0;
    }
    return localbird.jdField_a_of_type_Int;
  }
  
  @Nullable
  public View a()
  {
    int m = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    Object localObject = (bird)this.jdField_a_of_type_AndroidUtilSparseArray.get(m);
    localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(m);
    if ((localObject != null) && (((bire)localObject).a())) {
      return ((bire)localObject).a;
    }
    return null;
  }
  
  public bird a()
  {
    int m = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    bird localbird = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(m);
    if (localbird != null) {
      return localbird;
    }
    return null;
  }
  
  public birf a()
  {
    return this.jdField_a_of_type_Birf;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager = ((UnHandleTouchEventViewPager)a(2131299182));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter = new EditVideoFilter.FilterPagerAdapter(a());
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setAdapter(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setOnPageChangeListener(new bieu(this, null));
    urk.b("Q.qqstory.publish.edit.EditVideoFilter", "init filter view pager : " + this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager);
    d();
    a(bibh.class, this);
  }
  
  public void a(int paramInt, @NonNull bitz parambitz)
  {
    super.a(paramInt, parambitz);
    Object localObject1 = a();
    if (localObject1 != null) {
      parambitz.a.videoAddress = AddressItem.generatePoiJson(QQStoryContext.a().a(), ((birf)localObject1).jdField_e_of_type_JavaLangString, ((birf)localObject1).f, ((birf)localObject1).g, ((birf)localObject1).h, ((birf)localObject1).i, ((birf)localObject1).c, ((birf)localObject1).d, ((birf)localObject1).jdField_e_of_type_Int);
    }
    Object localObject2 = (bird)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((localObject1 != null) && (localObject2 != null) && ((localObject2 instanceof birf))) {
      parambitz.a.gpsFilterDescription = ((birf)localObject1).a();
    }
    if (this.jdField_a_of_type_Bigb.a.d()) {
      parambitz.a.localCreateCity = this.jdField_a_of_type_Bigb.a.a("extra_local_address_city_name");
    }
    parambitz.a(a());
    parambitz.a.saveMode = b(paramInt);
    parambitz = "";
    int m = -1;
    paramInt = 0;
    int n;
    if (localObject2 != null)
    {
      localObject1 = ((bird)localObject2).jdField_a_of_type_JavaLangString;
      n = ((bird)localObject2).jdField_b_of_type_Int;
      int i1 = ((bird)localObject2).jdField_a_of_type_Int;
      paramInt = i1;
      m = n;
      parambitz = (bitz)localObject1;
      if (((bird)localObject2).jdField_b_of_type_Int != -1)
      {
        this.jdField_a_of_type_Bigb.a().setFilterId(((bird)localObject2).jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Bigb.a().setFilterType(2);
        parambitz = (bitz)localObject1;
        m = n;
        paramInt = i1;
      }
    }
    long l;
    if (m != -1)
    {
      localObject2 = this.jdField_a_of_type_Bigb;
      n = this.jdField_a_of_type_Bigb.b();
      if (this.jdField_a_of_type_Bigb.a())
      {
        localObject1 = "2";
        ((bigb)localObject2).b("pub_filter_menu", n, 0, new String[] { String.valueOf(m), parambitz, localObject1 });
      }
    }
    else
    {
      if (m != -1) {
        urq.a("0X80076E9", String.valueOf(urq.jdField_b_of_type_Int), String.valueOf(paramInt), parambitz, String.valueOf(m));
      }
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      paramInt = this.jdField_a_of_type_Int;
      urk.a("Q.qqstory.publish.edit.EditVideoFilter", "intervalTime : %s , videoMode : %s. ", Long.valueOf(l), Integer.valueOf(paramInt));
      if (!this.jdField_a_of_type_Bigb.a()) {
        break label437;
      }
    }
    label437:
    for (parambitz = "2";; parambitz = "1")
    {
      urp.b("video_edit", "pub_filter_interval_time", 0, 0, new String[] { String.valueOf(l), String.valueOf(paramInt), parambitz });
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
    bird localbird = (bird)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    return (localbird != null) && (localbird.a());
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
      if (!((bire)localObject2).a()) {
        break label226;
      }
      localObject1 = ((bire)localObject2).a;
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
      if ((paramMessage.obj instanceof spb))
      {
        paramMessage = (spb)paramMessage.obj;
        this.jdField_a_of_type_Birf = new birf(0, i, 8, paramMessage.c, paramMessage.d, paramMessage.jdField_a_of_type_JavaLangString, paramMessage.c, paramMessage.jdField_b_of_type_JavaLangString, paramMessage.jdField_e_of_type_JavaLangString, "", paramMessage.jdField_a_of_type_Int, paramMessage.jdField_b_of_type_Int, 1);
        d();
        urk.a("Q.qqstory.publish.edit.EditVideoFilter", "handleEditVideoMessage MESSAGE_LOCATION_LOCAL_ADDRESS_UPDATE POIFilterData is available : country : %s, city : %s, district : %s .", paramMessage.jdField_a_of_type_JavaLangString, paramMessage.c, paramMessage.d);
      }
      for (;;)
      {
        return true;
        urk.e("Q.qqstory.publish.edit.EditVideoFilter", "handleEditVideoMessage MESSAGE_LOCATION_LOCAL_ADDRESS_UPDATE Message Error! Message obj type mismatch");
      }
      int m = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
      int n = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(this.jdField_a_of_type_Bigb.a(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a() * 50);
      urk.b("Q.qqstory.publish.edit.EditVideoFilter", "change video block from %d to %d, change page from %d to %d", Integer.valueOf(paramMessage.arg1), Integer.valueOf(paramMessage.arg2), Integer.valueOf(m), Integer.valueOf(n));
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
    bird localbird = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(m);
    if (localbird != null) {
      return localbird.jdField_b_of_type_Int;
    }
    return -1;
  }
  
  public int b(int paramInt)
  {
    bird localbird = (bird)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbird == null) {
      return 0;
    }
    return a(localbird);
  }
  
  public void d()
  {
    urk.a("Q.qqstory.publish.edit.EditVideoFilter", "updateFilterMode : %s", this.jdField_a_of_type_Bigb.a.a);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new birp(jdField_a_of_type_JavaLangString, -1, 0, 0));
    boolean bool;
    if (((this.jdField_a_of_type_Bigb.a.a instanceof EditRecordVideoSource)) || ((this.jdField_a_of_type_Bigb.a.a instanceof EditTakeVideoSource)))
    {
      if (((this.jdField_a_of_type_Bigb.a.a instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL)))
      {
        if ((!"Meizu".equalsIgnoreCase(Build.MANUFACTURER)) || (!"MX4 Pro".equalsIgnoreCase(Build.MODEL)))
        {
          bool = ((Boolean)((spz)sqg.a(10)).b("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue();
          if ((!(this.jdField_a_of_type_Bigb.a.a instanceof EditTakeVideoSource)) || (bool)) {
            break label492;
          }
          urk.d("Q.qqstory.publish.edit.EditVideoFilter", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        }
        label201:
        if ((!(this.jdField_a_of_type_Bigb.a.a instanceof EditTakeVideoSource)) || (!"HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) || ((!"CHE-TL00".equalsIgnoreCase(Build.MODEL)) && (!"CAM-TL00".equalsIgnoreCase(Build.MODEL)) && (!"MHA-AL00".equalsIgnoreCase(Build.MODEL)) && (!"CHM-TL00".equalsIgnoreCase(Build.MODEL)))) {
          break label543;
        }
      }
    }
    else
    {
      label277:
      localArrayList.add(new birm(0, h, 7));
      if (this.jdField_a_of_type_Birf != null) {
        localArrayList.add(this.jdField_a_of_type_Birf);
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
    for (int m = 0;; m = ((bird)localArrayList.get(0)).jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = m;
      return;
      bool = ((Boolean)((spz)sqg.a(10)).b("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue();
      if (((this.jdField_a_of_type_Bigb.a.a instanceof EditTakeVideoSource)) && (!bool))
      {
        urk.d("Q.qqstory.publish.edit.EditVideoFilter", "it's fast black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        break;
      }
      localArrayList.add(new birp(jdField_b_of_type_JavaLangString, 1, 2130845430, 2));
      localArrayList.add(new birp(j, 9, 2130845430, 8));
      break;
      label492:
      localArrayList.add(new birp(c, 2, 2130845431, 3));
      localArrayList.add(new birp(k, 10, 2130845431, 9));
      break label201;
      if ((((this.jdField_a_of_type_Bigb.a.a instanceof EditTakeVideoSource)) && ("GIONEE".equalsIgnoreCase(Build.MANUFACTURER)) && ("GN9011".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_Bigb.a.a instanceof EditTakeVideoSource)) && ("ZTE".equalsIgnoreCase(Build.MANUFACTURER)) && ("ZTE A2017".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_Bigb.a.a instanceof EditTakeVideoSource)) && ("Xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) && ("HM NOTE 1W".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_Bigb.a.a instanceof EditTakeVideoSource)) && ("OnePlus".equalsIgnoreCase(Build.MANUFACTURER)) && ("ONEPLUS A3000".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_Bigb.a.a instanceof EditTakeVideoSource)) && ("vivo Y67".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_Bigb.a.a instanceof EditTakeVideoSource)) && ("OPPO R7sm".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_Bigb.a.a instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_Bigb.a.a instanceof EditTakeVideoSource)) && ("GN5001S".equalsIgnoreCase(Build.MODEL)))) {
        break label277;
      }
      bool = ((Boolean)((spz)sqg.a(10)).b("boolean_enable_revert_play_mode", Boolean.valueOf(true))).booleanValue();
      if (((this.jdField_a_of_type_Bigb.a.a instanceof EditTakeVideoSource)) && (!bool))
      {
        urk.d("Q.qqstory.publish.edit.EditVideoFilter", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        break label277;
      }
      birp localbirp = new birp(d, 3, 2130845429, 1);
      if (this.jdField_a_of_type_Bigb.a.i()) {}
      for (String str = ajjy.a(2131638050);; str = null)
      {
        localbirp.jdField_b_of_type_JavaLangString = str;
        localArrayList.add(localbirp);
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