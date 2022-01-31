package dov.com.tencent.biz.qqstory.takevideo;

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
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import aocb;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.AddressDataProvider;
import com.tencent.biz.qqstory.model.AddressDataProvider.AddressInfo;
import com.tencent.biz.qqstory.model.DataProviderManager;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import dov.com.tencent.biz.qqstory.takevideo.filter.FilterData;
import dov.com.tencent.biz.qqstory.takevideo.filter.FilterData.FilterPageItem;
import dov.com.tencent.biz.qqstory.takevideo.filter.POIFilterData;
import dov.com.tencent.biz.qqstory.takevideo.filter.TimeFilterData;
import dov.com.tencent.biz.qqstory.takevideo.filter.VideoEffectsFilterData;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import java.util.ArrayList;
import java.util.List;

public class EditVideoFilter
  extends EditVideoPart
  implements EditFilterExport
{
  public int a;
  public long a;
  public SparseArray a;
  private SparseIntArray a;
  protected UnHandleTouchEventViewPager a;
  public EditVideoFilter.FilterPagerAdapter a;
  protected POIFilterData a;
  
  public EditVideoFilter(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  }
  
  public static int a(@NonNull FilterData paramFilterData)
  {
    SLog.b("Q.qqstory.publish.edit.EditVideoFilter", "getSpecialSaveMode : mVideoPlayMode = " + paramFilterData.jdField_a_of_type_Int);
    switch (paramFilterData.jdField_a_of_type_Int)
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
  
  public static void a(FilterData.FilterPageItem paramFilterPageItem)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setStartOffset(1000L);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setFillAfter(true);
    paramFilterPageItem.a.startAnimation(localAlphaAnimation);
  }
  
  public int a()
  {
    return b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a());
  }
  
  public int a(int paramInt)
  {
    FilterData localFilterData = (FilterData)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localFilterData == null) {
      return 0;
    }
    return localFilterData.jdField_a_of_type_Int;
  }
  
  @Nullable
  public View a()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    Object localObject = (FilterData)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(i);
    if ((localObject != null) && (((FilterData.FilterPageItem)localObject).a())) {
      return ((FilterData.FilterPageItem)localObject).a;
    }
    return null;
  }
  
  public FilterData a()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    FilterData localFilterData = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(i);
    if (localFilterData != null) {
      return localFilterData;
    }
    return null;
  }
  
  public POIFilterData a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterPOIFilterData;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager = ((UnHandleTouchEventViewPager)a(2131364438));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter = new EditVideoFilter.FilterPagerAdapter(a());
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setAdapter(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setOnPageChangeListener(new aocb(this, null));
    SLog.b("Q.qqstory.publish.edit.EditVideoFilter", "init filter view pager : " + this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager);
    c();
    i();
    a(EditFilterExport.class, this);
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    Object localObject2 = a();
    if (localObject2 != null) {
      paramGenerateContext.a.videoAddress = AddressItem.generatePoiJson(QQStoryContext.a().a(), ((POIFilterData)localObject2).jdField_e_of_type_JavaLangString, ((POIFilterData)localObject2).f, ((POIFilterData)localObject2).g, ((POIFilterData)localObject2).h, ((POIFilterData)localObject2).i, ((POIFilterData)localObject2).c, ((POIFilterData)localObject2).d, ((POIFilterData)localObject2).jdField_e_of_type_Int);
    }
    Object localObject1 = (FilterData)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((localObject2 != null) && (localObject1 != null) && ((localObject1 instanceof POIFilterData))) {
      paramGenerateContext.a.gpsFilterDescription = ((POIFilterData)localObject2).a();
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.d()) {
      paramGenerateContext.a.localCreateCity = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a("extra_local_address_city_name");
    }
    paramGenerateContext.a(a());
    paramGenerateContext.a.saveMode = b(paramInt);
    paramGenerateContext = "";
    int i = -1;
    paramInt = 0;
    if (localObject1 != null)
    {
      paramGenerateContext = ((FilterData)localObject1).jdField_a_of_type_JavaLangString;
      i = ((FilterData)localObject1).jdField_b_of_type_Int;
      paramInt = ((FilterData)localObject1).jdField_a_of_type_Int;
    }
    long l;
    if (i != -1)
    {
      localObject2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
      int j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b();
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a())
      {
        localObject1 = "2";
        ((EditVideoPartManager)localObject2).b("pub_filter_menu", j, 0, new String[] { String.valueOf(i), paramGenerateContext, localObject1 });
      }
    }
    else
    {
      if (i != -1) {
        VideoEditReport.a("0X80076E9", String.valueOf(VideoEditReport.jdField_b_of_type_Int), String.valueOf(paramInt), paramGenerateContext, String.valueOf(i));
      }
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      paramInt = this.jdField_a_of_type_Int;
      SLog.a("Q.qqstory.publish.edit.EditVideoFilter", "intervalTime : %s , videoMode : %s. ", Long.valueOf(l), Integer.valueOf(paramInt));
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
        break label380;
      }
    }
    label380:
    for (paramGenerateContext = "2";; paramGenerateContext = "1")
    {
      StoryReportor.b("video_edit", "pub_filter_interval_time", 0, 0, new String[] { String.valueOf(l), String.valueOf(paramInt), paramGenerateContext });
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
    FilterData localFilterData = (FilterData)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    return (localFilterData != null) && (localFilterData.a());
  }
  
  public boolean a(int paramInt1, Canvas paramCanvas, int paramInt2, int paramInt3)
  {
    Object localObject1 = null;
    paramInt1 = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt1);
    Object localObject2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(paramInt1);
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getWidth();
    int j = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getHeight();
    if (localObject2 != null)
    {
      if (!((FilterData.FilterPageItem)localObject2).a()) {
        break label226;
      }
      localObject1 = ((FilterData.FilterPageItem)localObject2).a;
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
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((paramMessage.obj instanceof AddressDataProvider.AddressInfo))
      {
        paramMessage = (AddressDataProvider.AddressInfo)paramMessage.obj;
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterPOIFilterData = new POIFilterData(0, "地点", 8, paramMessage.c, paramMessage.d, paramMessage.jdField_a_of_type_JavaLangString, paramMessage.c, paramMessage.jdField_b_of_type_JavaLangString, paramMessage.jdField_e_of_type_JavaLangString, "", paramMessage.jdField_a_of_type_Int, paramMessage.jdField_b_of_type_Int, 1);
        i();
        SLog.a("Q.qqstory.publish.edit.EditVideoFilter", "handleEditVideoMessage MESSAGE_LOCATION_LOCAL_ADDRESS_UPDATE POIFilterData is available : country : %s, city : %s, district : %s .", paramMessage.jdField_a_of_type_JavaLangString, paramMessage.c, paramMessage.d);
      }
      for (;;)
      {
        return true;
        SLog.e("Q.qqstory.publish.edit.EditVideoFilter", "handleEditVideoMessage MESSAGE_LOCATION_LOCAL_ADDRESS_UPDATE Message Error! Message obj type mismatch");
      }
      int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
      int j = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a() * 50);
      SLog.b("Q.qqstory.publish.edit.EditVideoFilter", "change video block from %d to %d, change page from %d to %d", Integer.valueOf(paramMessage.arg1), Integer.valueOf(paramMessage.arg2), Integer.valueOf(i), Integer.valueOf(j));
      if (i != j) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(j, false);
      }
    }
  }
  
  public void aF_()
  {
    super.aF_();
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
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    FilterData localFilterData = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(i);
    if (localFilterData != null) {
      return localFilterData.jdField_b_of_type_Int;
    }
    return -1;
  }
  
  public int b(int paramInt)
  {
    FilterData localFilterData = (FilterData)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localFilterData == null) {
      return 0;
    }
    return a(localFilterData);
  }
  
  protected void c()
  {
    String str3 = null;
    String str4 = null;
    String str1 = null;
    String str2 = null;
    String str5 = null;
    int k = 0;
    int m = 0;
    AddressDataProvider localAddressDataProvider = (AddressDataProvider)((DataProviderManager)SuperManager.a(20)).a(1);
    AddressDataProvider.AddressInfo localAddressInfo = (AddressDataProvider.AddressInfo)localAddressDataProvider.a();
    int i;
    if (localAddressInfo != null)
    {
      SLog.b("Q.qqstory.publish.edit.EditVideoFilter", "get address from cache.");
      str3 = localAddressInfo.jdField_a_of_type_JavaLangString;
      str4 = localAddressInfo.jdField_b_of_type_JavaLangString;
      str1 = localAddressInfo.c;
      str2 = localAddressInfo.d;
      str5 = localAddressInfo.jdField_e_of_type_JavaLangString;
      k = localAddressInfo.jdField_a_of_type_Int;
      m = localAddressInfo.jdField_b_of_type_Int;
      if ((!TextUtils.isEmpty(str3)) || (!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(str2))) {
        i = 1;
      }
    }
    for (;;)
    {
      int j = i;
      if (i == 0)
      {
        SLog.b("Q.qqstory.publish.edit.EditVideoFilter", "get address from sp.");
        str3 = localAddressDataProvider.a();
        str4 = localAddressDataProvider.b();
        str1 = localAddressDataProvider.c();
        str2 = localAddressDataProvider.d();
        str5 = localAddressDataProvider.e();
        k = localAddressDataProvider.a();
        m = localAddressDataProvider.b();
        long l = localAddressDataProvider.a();
        if (((TextUtils.isEmpty(str3)) && (TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2))) || ((float)(System.currentTimeMillis() - l) >= 1800000.0F)) {
          break label274;
        }
      }
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          break label287;
        }
        SLog.b("Q.qqstory.publish.edit.EditVideoFilter", "get address from net.");
        localAddressDataProvider.b();
        return;
        SLog.b("Q.qqstory.publish.edit.EditVideoFilter", "country,city,district all empty.");
        i = 0;
        break;
        label274:
        SLog.b("Q.qqstory.publish.edit.EditVideoFilter", "country,city,district all empty or overTime.");
      }
      label287:
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterPOIFilterData = new POIFilterData(0, "地点", 8, str1, str2, str3, str1, str4, str5, "", k, m, 1);
      return;
      i = 0;
    }
  }
  
  public void i()
  {
    SLog.a("Q.qqstory.publish.edit.EditVideoFilter", "updateFilterMode : %s", this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new VideoEffectsFilterData("正常速度", -1, 0, 0));
    boolean bool;
    if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditRecordVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource)))
    {
      if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL)))
      {
        if ((!"Meizu".equalsIgnoreCase(Build.MANUFACTURER)) || (!"MX4 Pro".equalsIgnoreCase(Build.MODEL)))
        {
          bool = ((Boolean)((StoryConfigManager)SuperManager.a(10)).b("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue();
          if ((!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource)) || (bool)) {
            break label492;
          }
          SLog.d("Q.qqstory.publish.edit.EditVideoFilter", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        }
        label201:
        if ((!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource)) || (!"HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) || ((!"CHE-TL00".equalsIgnoreCase(Build.MODEL)) && (!"CAM-TL00".equalsIgnoreCase(Build.MODEL)) && (!"MHA-AL00".equalsIgnoreCase(Build.MODEL)) && (!"CHM-TL00".equalsIgnoreCase(Build.MODEL)))) {
          break label543;
        }
      }
    }
    else
    {
      label277:
      localArrayList.add(new TimeFilterData(0, "时间", 7));
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterPOIFilterData != null) {
        localArrayList.add(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterPOIFilterData);
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(localArrayList);
      this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(localArrayList.size() * 50, false);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (!localArrayList.isEmpty()) {
        break label945;
      }
    }
    label543:
    label945:
    for (int i = 0;; i = ((FilterData)localArrayList.get(0)).jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = i;
      return;
      bool = ((Boolean)((StoryConfigManager)SuperManager.a(10)).b("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue();
      if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource)) && (!bool))
      {
        SLog.d("Q.qqstory.publish.edit.EditVideoFilter", "it's fast black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        break;
      }
      localArrayList.add(new VideoEffectsFilterData("快动作", 1, 2130843512, 2));
      localArrayList.add(new VideoEffectsFilterData("稍快动作", 9, 2130843512, 8));
      break;
      label492:
      localArrayList.add(new VideoEffectsFilterData("慢动作", 2, 2130843513, 3));
      localArrayList.add(new VideoEffectsFilterData("极慢动作", 10, 2130843513, 9));
      break label201;
      if ((((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource)) && ("GIONEE".equalsIgnoreCase(Build.MANUFACTURER)) && ("GN9011".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource)) && ("ZTE".equalsIgnoreCase(Build.MANUFACTURER)) && ("ZTE A2017".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource)) && ("Xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) && ("HM NOTE 1W".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource)) && ("OnePlus".equalsIgnoreCase(Build.MANUFACTURER)) && ("ONEPLUS A3000".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource)) && ("vivo Y67".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource)) && ("OPPO R7sm".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL))) || (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource)) && ("GN5001S".equalsIgnoreCase(Build.MODEL)))) {
        break label277;
      }
      bool = ((Boolean)((StoryConfigManager)SuperManager.a(10)).b("boolean_enable_revert_play_mode", Boolean.valueOf(true))).booleanValue();
      if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource)) && (!bool))
      {
        SLog.d("Q.qqstory.publish.edit.EditVideoFilter", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        break label277;
      }
      VideoEffectsFilterData localVideoEffectsFilterData = new VideoEffectsFilterData("倒带", 3, 2130843511, 1);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.h()) {}
      for (String str = "正在处理中...";; str = null)
      {
        localVideoEffectsFilterData.jdField_b_of_type_JavaLangString = str;
        localArrayList.add(localVideoEffectsFilterData);
        break;
      }
    }
  }
  
  public void k() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter
 * JD-Core Version:    0.7.0.1
 */