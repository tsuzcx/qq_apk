package dov.com.tencent.biz.qqstory.takevideo;

import amtj;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import bncb;
import bncx;
import bnec;
import bnee;
import bnes;
import bnnq;
import bnnr;
import bnns;
import bnnu;
import bnot;
import bnrp;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import vuq;
import vux;
import xvv;
import xwa;
import xwb;
import ylg;

public class EditVideoSpeedFilter
  extends bnec
  implements bncb, bnrp
{
  public static final String a;
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e;
  public static final String f = amtj.a(2131703038);
  public int a;
  public SparseArray<bnnq> a;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  protected bnns a;
  protected UnHandleTouchEventViewPager a;
  public EditVideoSpeedFilter.FilterPagerAdapter a;
  public PickerContainer a;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 1;
  public long b;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  static
  {
    jdField_a_of_type_JavaLangString = amtj.a(2131702993);
    jdField_b_of_type_JavaLangString = amtj.a(2131703019);
    jdField_c_of_type_JavaLangString = amtj.a(2131702900);
    d = amtj.a(2131702864);
    jdField_e_of_type_JavaLangString = amtj.a(2131703015);
  }
  
  public EditVideoSpeedFilter(@NonNull bnee parambnee, boolean paramBoolean)
  {
    super(parambnee);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = b();
    }
    xvv.b("EditVideoSpeedFilter", "EditVideoSpeedFilter : enable: " + this.jdField_c_of_type_Boolean);
  }
  
  public static int a(@NonNull bnnq parambnnq)
  {
    xvv.b("EditVideoSpeedFilter", "getSpecialSaveMode : mVideoPlayMode = " + parambnnq.jdField_a_of_type_Int);
    switch (parambnnq.jdField_a_of_type_Int)
    {
    case 0: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
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
    }
    return 4;
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
  
  public static void a(bnnr parambnnr)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setStartOffset(1000L);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setFillAfter(true);
    parambnnr.a.startAnimation(localAlphaAnimation);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Int == 2) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer == null);
        if (!paramBoolean) {
          break;
        }
      } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.getVisibility() == 0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.setVisibility(0);
      return;
    } while ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.getVisibility() == 4) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.getVisibility() == 8));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.setVisibility(4);
  }
  
  private boolean b()
  {
    if ((!"Meizu".equalsIgnoreCase(Build.MANUFACTURER)) || (!"MX4 Pro".equalsIgnoreCase(Build.MODEL))) {}
    vuq localvuq;
    boolean bool2;
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1) {
        xvv.d("EditVideoSpeedFilter", "Meizu MX4 Pro, in blacklist");
      }
      localvuq = (vuq)vux.a(10);
      if (localvuq != null) {
        break;
      }
      xvv.d("EditVideoSpeedFilter", "storyConfigManager == null !!!");
      bool2 = bool1;
      return bool2;
    }
    if ((bool1) && (((Boolean)localvuq.b("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue()) && (((Boolean)localvuq.b("boolean_enable_revert_play_mode", Boolean.valueOf(true))).booleanValue()) && (((Boolean)localvuq.b("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue())) {}
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (bool1) {
        break;
      }
      xvv.d("EditVideoSpeedFilter", "black model, manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
      return bool1;
    }
  }
  
  private int c(int paramInt)
  {
    int i = 2;
    xvv.b("EditVideoSpeedFilter", "transSpecialPlayMode : nSpeedIndex = " + paramInt);
    if (ylg.a().b() == 22) {
      LpReportInfo_pf00064.allReport(680, 2, 13);
    }
    switch (paramInt)
    {
    default: 
      paramInt = 1;
    case 4: 
    case 3: 
    case 2: 
    case 1: 
    case 0: 
      do
      {
        return paramInt;
        if (ylg.a().b() == 22) {
          LpReportInfo_pf00064.allReport(680, 10, 5);
        }
        return 9;
        if (ylg.a().b() == 22) {
          LpReportInfo_pf00064.allReport(680, 10, 4);
        }
        return 3;
        if (ylg.a().b() == 22) {
          LpReportInfo_pf00064.allReport(680, 10, 1);
        }
        return 0;
        if (ylg.a().b() == 22) {
          LpReportInfo_pf00064.allReport(680, 10, 2);
        }
        return 8;
        paramInt = i;
      } while (ylg.a().b() != 22);
      LpReportInfo_pf00064.allReport(680, 10, 3);
      return 2;
    }
    if (ylg.a().b() == 22) {
      LpReportInfo_pf00064.allReport(680, 10, 6);
    }
    return 1;
  }
  
  private void c()
  {
    ThreadManager.getUIHandler().postDelayed(new EditVideoSpeedFilter.1(this), 500L);
  }
  
  private int d(int paramInt)
  {
    xvv.b("EditVideoSpeedFilter", "transSpecialPlayMode : nPlayMode = " + paramInt);
    switch (paramInt)
    {
    case 0: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return 2;
    case 9: 
      return 4;
    case 3: 
      return 3;
    case 2: 
      return 0;
    case 8: 
      return 1;
    }
    return 5;
  }
  
  private void e(int paramInt, String paramString)
  {
    int k = 0;
    xvv.b("EditVideoSpeedFilter", "onPlayModeChanged:" + paramInt + "  " + paramString);
    List localList = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < localList.size())
      {
        bnnq localbnnq = (bnnq)localList.get(i);
        if ((!TextUtils.isEmpty(localbnnq.jdField_a_of_type_JavaLangString)) && (localbnnq.jdField_a_of_type_Int == paramInt))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(i, false);
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          QQToast.a(a(), amtj.a(2131702948) + paramString, 1000).a();
        }
        return;
      }
      i += 1;
    }
  }
  
  public int a()
  {
    return b(this.jdField_a_of_type_Bnee.a());
  }
  
  public int a(int paramInt)
  {
    bnnq localbnnq = (bnnq)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbnnq == null) {
      return 0;
    }
    return localbnnq.jdField_a_of_type_Int;
  }
  
  @Nullable
  public View a()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    bnnr localbnnr = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(i);
    if ((localbnnr != null) && (localbnnr.a())) {
      return localbnnr.a;
    }
    return null;
  }
  
  public bnns a()
  {
    return this.jdField_a_of_type_Bnns;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter = new EditVideoSpeedFilter.FilterPagerAdapter(a());
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager = ((UnHandleTouchEventViewPager)a(2131365129));
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setAdapter(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setOnPageChangeListener(new bnes(this, null));
    b();
    a(bncb.class, this);
    c();
  }
  
  public void a(int paramInt, @NonNull bnot parambnot)
  {
    super.a(paramInt, parambnot);
    Object localObject1 = a();
    if (localObject1 != null) {
      parambnot.a.videoAddress = AddressItem.generatePoiJson(QQStoryContext.a().a(), ((bnns)localObject1).jdField_e_of_type_JavaLangString, ((bnns)localObject1).f, ((bnns)localObject1).g, ((bnns)localObject1).h, ((bnns)localObject1).i, ((bnns)localObject1).c, ((bnns)localObject1).d, ((bnns)localObject1).jdField_e_of_type_Int);
    }
    Object localObject2 = (bnnq)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((localObject1 != null) && (localObject2 != null) && ((localObject2 instanceof bnns))) {
      parambnot.a.gpsFilterDescription = ((bnns)localObject1).a();
    }
    if (this.jdField_a_of_type_Bnee.a.d()) {
      parambnot.a.localCreateCity = this.jdField_a_of_type_Bnee.a.a("extra_local_address_city_name");
    }
    parambnot.a(a());
    parambnot.a.saveMode = b(paramInt);
    parambnot = "";
    int i = -1;
    paramInt = 0;
    int j;
    if (localObject2 != null)
    {
      localObject1 = ((bnnq)localObject2).jdField_a_of_type_JavaLangString;
      j = ((bnnq)localObject2).jdField_b_of_type_Int;
      int k = ((bnnq)localObject2).jdField_a_of_type_Int;
      paramInt = k;
      i = j;
      parambnot = (bnot)localObject1;
      if (((bnnq)localObject2).jdField_b_of_type_Int != -1)
      {
        this.jdField_a_of_type_Bnee.a().setFilterId(((bnnq)localObject2).jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Bnee.a().setFilterType(2);
        parambnot = (bnot)localObject1;
        i = j;
        paramInt = k;
      }
    }
    long l;
    if (i != -1)
    {
      localObject2 = this.jdField_a_of_type_Bnee;
      j = this.jdField_a_of_type_Bnee.b();
      if (this.jdField_a_of_type_Bnee.a())
      {
        localObject1 = "2";
        ((bnee)localObject2).a("pub_filter_menu", j, 0, new String[] { String.valueOf(i), parambnot, localObject1 });
      }
    }
    else
    {
      if (i != -1) {
        xwb.a("0X80076E9", String.valueOf(xwb.jdField_b_of_type_Int), String.valueOf(paramInt), parambnot, String.valueOf(i));
      }
      l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
      paramInt = this.jdField_a_of_type_Int;
      xvv.a("EditVideoSpeedFilter", "intervalTime : %s , videoMode : %s. ", Long.valueOf(l), Integer.valueOf(paramInt));
      if (!this.jdField_a_of_type_Bnee.a()) {
        break label437;
      }
    }
    label437:
    for (parambnot = "2";; parambnot = "1")
    {
      xwa.b("video_edit", "pub_filter_interval_time", 0, 0, new String[] { String.valueOf(l), String.valueOf(paramInt), parambnot });
      return;
      localObject1 = "1";
      break;
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    switch (paramInt)
    {
    case 2: 
    case 3: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    default: 
      a(true);
      a(4);
      return;
    case 12: 
      paramInt = d(this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.a(paramInt, false);
      }
      a(true);
      a(0);
      return;
    case 5: 
    case 6: 
      a(false);
      a(0);
      return;
    }
    a(true);
    a(0);
  }
  
  public void a(int paramInt, String paramString)
  {
    xvv.b("EditVideoSpeedFilter", "onPickSpeedStart:" + paramInt + "  " + paramString);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public boolean a(int paramInt)
  {
    bnnq localbnnq = (bnnq)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    return (localbnnq != null) && (localbnnq.a());
  }
  
  public boolean a(int paramInt1, Canvas paramCanvas, int paramInt2, int paramInt3)
  {
    Object localObject1 = null;
    paramInt1 = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt1);
    Object localObject2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(paramInt1);
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getWidth();
    int j = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getHeight();
    if (localObject2 != null)
    {
      if (!((bnnr)localObject2).a()) {
        break label226;
      }
      localObject1 = ((bnnr)localObject2).a;
      localObject2 = null;
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        paramCanvas.save();
        paramCanvas.scale(paramInt2 / i, paramInt3 / j);
        ((View)localObject1).draw(paramCanvas);
        paramCanvas.restore();
        if (localObject2 != null) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.destroyItem((ViewGroup)localObject1, paramInt1, localObject2);
        }
        return true;
        localObject1 = new FrameLayout(a());
        ((View)localObject1).setLayoutParams(new ViewGroup.LayoutParams(this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getLayoutParams()));
        localObject2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.instantiateItem((ViewGroup)localObject1, paramInt1);
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
    boolean bool2 = false;
    boolean bool1 = true;
    if (this.jdField_c_of_type_Boolean) {
      switch (paramMessage.what)
      {
      }
    }
    for (;;)
    {
      bool1 = super.a(paramMessage);
      do
      {
        return bool1;
        this.jdField_b_of_type_Int = paramMessage.arg1;
      } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer == null);
      paramMessage = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer;
      if (this.jdField_b_of_type_Int != 1)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_Int != 3) {}
      }
      else
      {
        bool1 = true;
      }
      paramMessage.a(bool1, this.jdField_a_of_type_Long);
      return true;
      a(false);
      continue;
      a(true);
    }
  }
  
  public int b()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    bnnq localbnnq = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(i);
    if (localbnnq != null) {
      return localbnnq.jdField_b_of_type_Int;
    }
    return -1;
  }
  
  public int b(int paramInt)
  {
    bnnq localbnnq = (bnnq)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbnnq == null) {
      return 0;
    }
    return a(localbnnq);
  }
  
  public void b()
  {
    xvv.a("EditVideoSpeedFilter", "updateFilterMode : %s", this.jdField_a_of_type_Bnee.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource);
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (((this.jdField_a_of_type_Bnee.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)) || ((this.jdField_a_of_type_Bnee.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_Bnee.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)))
    {
      localObject = (vuq)vux.a(10);
      localArrayList.add(new bnnu(jdField_a_of_type_JavaLangString, -1, 0, 0));
      if (((Boolean)((vuq)localObject).b("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue()) {
        break label319;
      }
      xvv.d("EditVideoSpeedFilter", "it's fast black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
      if ((!"Meizu".equalsIgnoreCase(Build.MANUFACTURER)) || (!"MX4 Pro".equalsIgnoreCase(Build.MODEL)))
      {
        if (((Boolean)((vuq)localObject).b("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue()) {
          break label364;
        }
        xvv.d("EditVideoSpeedFilter", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
      }
      label211:
      if (!(this.jdField_a_of_type_Bnee.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        if (((Boolean)((vuq)localObject).b("boolean_enable_revert_play_mode", Boolean.valueOf(true))).booleanValue()) {
          break label492;
        }
        xvv.d("EditVideoSpeedFilter", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
      }
    }
    label270:
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(localArrayList);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(localArrayList.size() * 50, false);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if (localArrayList.isEmpty()) {}
    for (int i = 0;; i = ((bnnq)localArrayList.get(0)).jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = i;
      return;
      label319:
      localArrayList.add(new bnnu(jdField_b_of_type_JavaLangString, 1, 0, 2));
      localArrayList.add(new bnnu(jdField_e_of_type_JavaLangString, 9, 0, 8));
      break;
      label364:
      if ((this.jdField_a_of_type_Bnee.a.jdField_a_of_type_Int == 11) && (!this.jdField_a_of_type_Bnee.a.f()))
      {
        xvv.d("EditVideoSpeedFilter", "it's tribe slow black model, disable slow!");
        break label211;
      }
      if ((this.jdField_a_of_type_Bnee.a.jdField_a_of_type_Int == 12) && (!this.jdField_a_of_type_Bnee.a.f()))
      {
        xvv.d("EditVideoSpeedFilter", "it's readinjoy slow black model, disable slow!");
        break label211;
      }
      localArrayList.add(new bnnu(jdField_c_of_type_JavaLangString, 2, 0, 3));
      localArrayList.add(new bnnu(f, 10, 0, 9));
      this.jdField_a_of_type_Boolean = true;
      break label211;
      label492:
      if ((this.jdField_a_of_type_Bnee.a.jdField_a_of_type_Int == 11) && (!this.jdField_a_of_type_Bnee.a.e()))
      {
        xvv.d("EditVideoSpeedFilter", "it's tribe revert black model, disable revert!");
        break label270;
      }
      if ((this.jdField_a_of_type_Bnee.a.jdField_a_of_type_Int == 12) && (!this.jdField_a_of_type_Bnee.a.e()))
      {
        xvv.d("EditVideoSpeedFilter", "it's tribe readinjoy black model, disable revert!");
        break label270;
      }
      bnnu localbnnu = new bnnu(d, 3, 0, 1);
      if (this.jdField_a_of_type_Bnee.a.g()) {}
      for (localObject = amtj.a(2131703010);; localObject = null)
      {
        localbnnu.jdField_b_of_type_JavaLangString = ((String)localObject);
        localArrayList.add(localbnnu);
        break;
      }
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    xvv.b("EditVideoSpeedFilter", "onPickSpeed:" + paramInt + "  " + paramString + " moving:" + this.jdField_b_of_type_Boolean);
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    e(c(paramInt), paramString);
    paramString = this.jdField_a_of_type_Bnee.a(bncx.class);
    if ((paramString instanceof bncx)) {
      ((bncx)paramString).d();
    }
    this.jdField_a_of_type_Bnee.a(Message.obtain(null, 9, 12, paramInt));
  }
  
  public void c(int paramInt, String paramString)
  {
    xvv.b("EditVideoSpeedFilter", "onSpeedPickEnd:" + paramInt + "  " + paramString);
    e(c(paramInt), paramString);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void d(int paramInt, String paramString)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(paramInt, paramString);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.notifyDataSetChanged();
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_AndroidViewViewStub = null;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSpeedFilter
 * JD-Core Version:    0.7.0.1
 */