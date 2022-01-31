package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import antn;
import anto;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.AddressDataProvider.AddressInfo;
import com.tencent.biz.qqstory.model.DataProvider.DataUpdateListener;
import com.tencent.biz.qqstory.model.DataProviderManager;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.WeatherDataProvider;
import com.tencent.biz.qqstory.model.WeatherDataProvider.WeatherInfo;
import com.tencent.biz.qqstory.model.filter.FilterItem;
import com.tencent.biz.qqstory.model.filter.VideoFilterManager;
import com.tencent.biz.qqstory.network.request.GetLocationRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;
import dov.com.tencent.biz.qqstory.takevideo.filter.FilterData;
import dov.com.tencent.biz.qqstory.takevideo.filter.POIFilterData;
import dov.com.tencent.biz.qqstory.takevideo.filter.PictureFilterData;
import dov.com.tencent.biz.qqstory.takevideo.filter.SpeedFilterData;
import dov.com.tencent.biz.qqstory.takevideo.filter.TimeFilterData;
import dov.com.tencent.biz.qqstory.takevideo.filter.VideoEffectsFilterData;
import dov.com.tencent.biz.qqstory.takevideo.filter.WeatherFilterData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EditVideoFilterNeo
  extends EditVideoFilter
{
  public static final int[] a;
  public static final String[] a;
  public static final int[] b;
  private DataProvider.DataUpdateListener jdField_a_of_type_ComTencentBizQqstoryModelDataProvider$DataUpdateListener;
  private WeatherFilterData jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterWeatherFilterData;
  private SparseArray b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "正常速度", "快动作", "慢动作", "倒带", "暖色", "冷色", "黑白", "时间", "地点", "速度", "温度" };
    jdField_b_of_type_ArrayOfInt = new int[] { -1, 1, 2, 9, 10, 3, 4, 5, 6, 7, 8, 9, 10 };
  }
  
  private FilterData a(int paramInt1, @NonNull String paramString, int paramInt2, EditVideoParams.EditSource paramEditSource)
  {
    int i = this.jdField_b_of_type_AndroidUtilSparseArray.indexOfKey(paramInt1);
    FilterData localFilterData = (FilterData)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt1);
    if (i >= 0)
    {
      paramString = (FilterData)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(i);
      return paramString;
    }
    DoodleEmojiManager localDoodleEmojiManager = (DoodleEmojiManager)SuperManager.a(36);
    Object localObject = localFilterData;
    switch (paramInt1)
    {
    default: 
      localObject = localFilterData;
    }
    for (;;)
    {
      paramString = (String)localObject;
      if (paramInt1 == 7) {
        break;
      }
      this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt1, localObject);
      return localObject;
      localObject = new VideoEffectsFilterData(paramString, paramInt2, 0, 0);
      continue;
      if (!(paramEditSource instanceof EditRecordVideoSource))
      {
        localObject = localFilterData;
        if (!(paramEditSource instanceof EditTakeVideoSource)) {}
      }
      else
      {
        localObject = new VideoEffectsFilterData(paramString, paramInt2, 0, 7);
        continue;
        if (!(paramEditSource instanceof EditRecordVideoSource))
        {
          localObject = localFilterData;
          if (!(paramEditSource instanceof EditTakeVideoSource)) {}
        }
        else
        {
          localObject = new VideoEffectsFilterData(paramString, paramInt2, 0, 6);
          continue;
          if (!(paramEditSource instanceof EditRecordVideoSource))
          {
            localObject = localFilterData;
            if (!(paramEditSource instanceof EditTakeVideoSource)) {}
          }
          else
          {
            localObject = new VideoEffectsFilterData(paramString, paramInt2, 0, 5);
            continue;
            if (!(paramEditSource instanceof EditRecordVideoSource))
            {
              localObject = localFilterData;
              if (!(paramEditSource instanceof EditTakeVideoSource)) {}
            }
            else if (((paramEditSource instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL)))
            {
              localObject = null;
            }
            else
            {
              boolean bool = ((Boolean)((StoryConfigManager)SuperManager.a(10)).b("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue();
              if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource)) && (!bool))
              {
                SLog.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                localObject = null;
              }
              else
              {
                localObject = new VideoEffectsFilterData(paramString, paramInt2, 2130843478, 2);
                continue;
                if (!(paramEditSource instanceof EditRecordVideoSource))
                {
                  localObject = localFilterData;
                  if (!(paramEditSource instanceof EditTakeVideoSource)) {}
                }
                else if (((paramEditSource instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL)))
                {
                  localObject = null;
                }
                else
                {
                  bool = ((Boolean)((StoryConfigManager)SuperManager.a(10)).b("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue();
                  if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource)) && (!bool))
                  {
                    SLog.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                    localObject = null;
                  }
                  else
                  {
                    localObject = new VideoEffectsFilterData(paramString, paramInt2, 2130843478, 8);
                    continue;
                    localObject = localFilterData;
                    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterPOIFilterData != null)
                    {
                      localObject = new POIFilterData(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterPOIFilterData.a, paramString, paramInt2, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterPOIFilterData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterPOIFilterData.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterPOIFilterData.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterPOIFilterData.f, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterPOIFilterData.g, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterPOIFilterData.h, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterPOIFilterData.i, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterPOIFilterData.jdField_c_of_type_Int, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterPOIFilterData.jdField_d_of_type_Int, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterPOIFilterData.jdField_e_of_type_Int);
                      continue;
                      if (!(paramEditSource instanceof EditRecordVideoSource))
                      {
                        localObject = localFilterData;
                        if (!(paramEditSource instanceof EditTakeVideoSource)) {}
                      }
                      else if (((paramEditSource instanceof EditTakeVideoSource)) && ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) && (("CHE-TL00".equalsIgnoreCase(Build.MODEL)) || ("CAM-TL00".equalsIgnoreCase(Build.MODEL)) || ("MHA-AL00".equalsIgnoreCase(Build.MODEL)) || ("CHM-TL00".equalsIgnoreCase(Build.MODEL))))
                      {
                        localObject = null;
                      }
                      else if (((paramEditSource instanceof EditTakeVideoSource)) && ("GIONEE".equalsIgnoreCase(Build.MANUFACTURER)) && ("GN9011".equalsIgnoreCase(Build.MODEL)))
                      {
                        localObject = null;
                      }
                      else if (((paramEditSource instanceof EditTakeVideoSource)) && ("ZTE".equalsIgnoreCase(Build.MANUFACTURER)) && ("ZTE A2017".equalsIgnoreCase(Build.MODEL)))
                      {
                        localObject = null;
                      }
                      else if (((paramEditSource instanceof EditTakeVideoSource)) && ("Xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) && ("HM NOTE 1W".equalsIgnoreCase(Build.MODEL)))
                      {
                        localObject = null;
                      }
                      else if (((paramEditSource instanceof EditTakeVideoSource)) && ("OnePlus".equalsIgnoreCase(Build.MANUFACTURER)) && ("ONEPLUS A3000".equalsIgnoreCase(Build.MODEL)))
                      {
                        localObject = null;
                      }
                      else if (((paramEditSource instanceof EditTakeVideoSource)) && ("vivo Y67".equalsIgnoreCase(Build.MODEL)))
                      {
                        localObject = null;
                      }
                      else if (((paramEditSource instanceof EditTakeVideoSource)) && ("OPPO R7sm".equalsIgnoreCase(Build.MODEL)))
                      {
                        localObject = null;
                      }
                      else if (((paramEditSource instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL)))
                      {
                        localObject = null;
                      }
                      else if (((paramEditSource instanceof EditTakeVideoSource)) && ("GN5001S".equalsIgnoreCase(Build.MODEL)))
                      {
                        localObject = null;
                      }
                      else
                      {
                        bool = ((Boolean)((StoryConfigManager)SuperManager.a(10)).b("boolean_enable_revert_play_mode", Boolean.valueOf(true))).booleanValue();
                        if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource)) && (!bool))
                        {
                          SLog.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                          localObject = null;
                        }
                        else
                        {
                          localObject = new VideoEffectsFilterData(paramString, paramInt2, 2130843477, 1);
                          continue;
                          if (!(paramEditSource instanceof EditRecordVideoSource))
                          {
                            localObject = localFilterData;
                            if (!(paramEditSource instanceof EditTakeVideoSource)) {}
                          }
                          else if ("Meizu".equalsIgnoreCase(Build.MANUFACTURER))
                          {
                            localObject = localFilterData;
                            if ("MX4 Pro".equalsIgnoreCase(Build.MODEL)) {}
                          }
                          else
                          {
                            localObject = localFilterData;
                            if (!"X9000".equalsIgnoreCase(Build.MODEL))
                            {
                              bool = ((Boolean)((StoryConfigManager)SuperManager.a(10)).b("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue();
                              if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource)) && (!bool))
                              {
                                SLog.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                                localObject = null;
                              }
                              else
                              {
                                localObject = new VideoEffectsFilterData(paramString, paramInt2, 2130843479, 3);
                                continue;
                                if (!(paramEditSource instanceof EditRecordVideoSource))
                                {
                                  localObject = localFilterData;
                                  if (!(paramEditSource instanceof EditTakeVideoSource)) {}
                                }
                                else if ("Meizu".equalsIgnoreCase(Build.MANUFACTURER))
                                {
                                  localObject = localFilterData;
                                  if ("MX4 Pro".equalsIgnoreCase(Build.MODEL)) {}
                                }
                                else
                                {
                                  localObject = localFilterData;
                                  if (!"X9000".equalsIgnoreCase(Build.MODEL))
                                  {
                                    bool = ((Boolean)((StoryConfigManager)SuperManager.a(10)).b("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue();
                                    if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource)) && (!bool))
                                    {
                                      SLog.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                                      localObject = null;
                                    }
                                    else
                                    {
                                      localObject = new VideoEffectsFilterData(paramString, paramInt2, 2130843479, 9);
                                      continue;
                                      localObject = new TimeFilterData(0, paramString, paramInt2);
                                      continue;
                                      if ((!(paramEditSource instanceof EditRecordVideoSource)) && (!(paramEditSource instanceof EditTakeVideoSource)))
                                      {
                                        localObject = localFilterData;
                                        if (!(paramEditSource instanceof EditTakePhotoSource)) {}
                                      }
                                      else if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterPOIFilterData == null) || (!b()))
                                      {
                                        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterPOIFilterData == null) {
                                          SLog.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "TYPE_SPEED : POI data is disable.");
                                        }
                                        localObject = localFilterData;
                                        if (!b())
                                        {
                                          SLog.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "TYPE_SPEED : has not open gps.");
                                          localObject = localFilterData;
                                        }
                                      }
                                      else
                                      {
                                        float f = localDoodleEmojiManager.a();
                                        if (f >= 0.0F)
                                        {
                                          localObject = new SpeedFilterData(0, paramString, paramInt2, f);
                                        }
                                        else
                                        {
                                          SLog.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "speed is unavailable : %s.", Float.valueOf(f));
                                          localObject = localFilterData;
                                          continue;
                                          if ((!(paramEditSource instanceof EditRecordVideoSource)) && (!(paramEditSource instanceof EditTakeVideoSource)))
                                          {
                                            localObject = localFilterData;
                                            if (!(paramEditSource instanceof EditTakePhotoSource)) {}
                                          }
                                          else
                                          {
                                            if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterPOIFilterData != null) && (b())) {
                                              break label1618;
                                            }
                                            if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterPOIFilterData == null) {
                                              SLog.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "TYPE_TEMP : POI data is disable.");
                                            }
                                            localObject = localFilterData;
                                            if (!b())
                                            {
                                              SLog.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "TYPE_TEMP : has not open gps.");
                                              localObject = localFilterData;
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label1618:
    paramEditSource = (WeatherDataProvider)((DataProviderManager)SuperManager.a(20)).a(0);
    localObject = (WeatherDataProvider.WeatherInfo)paramEditSource.a();
    if (localObject != null)
    {
      SLog.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "get weather from cache.");
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterWeatherFilterData = new WeatherFilterData(0, paramString, paramInt2, ((WeatherDataProvider.WeatherInfo)localObject).a);
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterWeatherFilterData;
      break;
      SLog.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "get weather from net.");
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterWeatherFilterData = new WeatherFilterData(0, paramString, paramInt2, 0);
      paramEditSource.b();
    }
  }
  
  private FilterData a(@NonNull FilterItem paramFilterItem, EditVideoParams.EditSource paramEditSource)
  {
    switch (paramFilterItem.filterType)
    {
    default: 
      return null;
    case 10: 
      paramEditSource = ((VideoFilterManager)SuperManager.a(16)).a(paramFilterItem);
      if (paramEditSource != null) {
        return new PictureFilterData(0, paramFilterItem.filterName, (int)paramFilterItem.filterId, VideoFilterManager.a(paramFilterItem), paramEditSource);
      }
      return null;
    }
    return a(paramFilterItem.filterType, paramFilterItem.filterName, (int)paramFilterItem.filterId, paramEditSource);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    SLog.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress([lat]%d, [lng]%d)", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    GetLocationRequest localGetLocationRequest = new GetLocationRequest(1, paramInt2, paramInt1);
    CmdTaskManger.a().a(localGetLocationRequest, new antn(this));
  }
  
  private boolean b()
  {
    return ((LocationManager)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a().getSystemService("location")).isProviderEnabled("gps");
  }
  
  public void a()
  {
    super.a();
    ((WeatherDataProvider)((DataProviderManager)SuperManager.a(20)).a(0)).a(this.jdField_a_of_type_ComTencentBizQqstoryModelDataProvider$DataUpdateListener);
  }
  
  public void a(int paramInt, AddressDataProvider.AddressInfo paramAddressInfo)
  {
    SLog.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "onAddressRequestResult err=%d, address=%s, %s", Integer.valueOf(paramInt), paramAddressInfo, null);
    if (paramInt == 0)
    {
      Activity localActivity = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
      if (localActivity != null) {
        localActivity.runOnUiThread(new anto(this, paramAddressInfo));
      }
    }
    else
    {
      return;
    }
    SLog.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "activity is Null! can't boardcast AddressInforamtion");
  }
  
  protected void c()
  {
    EditVideoParams localEditVideoParams = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a;
    int j;
    label48:
    LocalMediaInfo localLocalMediaInfo;
    if (localEditVideoParams.a() == 1)
    {
      i = 1;
      if ((i == 0) || ((!(localEditVideoParams.a instanceof EditLocalPhotoSource)) && (!(localEditVideoParams.a instanceof EditLocalVideoSource)))) {
        break label127;
      }
      j = 1;
      if ((i == 0) || (j == 0)) {
        break label158;
      }
      localLocalMediaInfo = null;
      if (!(localEditVideoParams.a instanceof EditLocalPhotoSource)) {
        break label132;
      }
      localLocalMediaInfo = ((EditLocalPhotoSource)localEditVideoParams.a).a;
      label81:
      if ((localLocalMediaInfo == null) || ((localLocalMediaInfo.latitude == 0) && (localLocalMediaInfo.longitude == 0))) {
        break label158;
      }
      a(localLocalMediaInfo.latitude, localLocalMediaInfo.longitude);
    }
    label132:
    label158:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        super.c();
      }
      return;
      i = 0;
      break;
      label127:
      j = 0;
      break label48;
      if (!(localEditVideoParams.a instanceof EditLocalVideoSource)) {
        break label81;
      }
      localLocalMediaInfo = ((EditLocalVideoSource)localEditVideoParams.a).a;
      break label81;
    }
  }
  
  public void h()
  {
    ((WeatherDataProvider)((DataProviderManager)SuperManager.a(20)).a(0)).b(this.jdField_a_of_type_ComTencentBizQqstoryModelDataProvider$DataUpdateListener);
    super.h();
  }
  
  public void j()
  {
    Object localObject1 = ((VideoFilterManager)SuperManager.a(16)).a();
    ArrayList localArrayList = new ArrayList();
    if (((List)localObject1).isEmpty())
    {
      int i = 0;
      while (i < jdField_a_of_type_ArrayOfInt.length)
      {
        localObject1 = a(jdField_a_of_type_ArrayOfInt[i], jdField_a_of_type_ArrayOfJavaLangString[i], jdField_b_of_type_ArrayOfInt[i], this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a);
        if (localObject1 != null) {
          localArrayList.add(localObject1);
        }
        i += 1;
      }
    }
    Object localObject2 = a(-1, "正常速度", -1, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a);
    if (localObject2 != null) {
      localArrayList.add(localObject2);
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FilterItem)((Iterator)localObject1).next();
      FilterData localFilterData = a((FilterItem)localObject2, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a);
      if (localFilterData != null)
      {
        SLog.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "Filter : %s", new Object[] { localObject2 });
        localArrayList.add(localFilterData);
      }
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(localArrayList);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(localArrayList.size() * 50, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoFilterNeo
 * JD-Core Version:    0.7.0.1
 */