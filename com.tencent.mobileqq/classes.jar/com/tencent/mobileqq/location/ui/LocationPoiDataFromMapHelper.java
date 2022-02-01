package com.tencent.mobileqq.location.ui;

import android.text.TextUtils;
import com.tencent.lbssearch.TencentSearch;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.lbssearch.object.param.Geo2AddressParam.PoiOptions;
import com.tencent.lbssearch.object.param.SuggestionParam;
import com.tencent.lbssearch.object.param.SuggestionParam.Policy;
import com.tencent.map.tools.net.http.HttpResponseListener;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class LocationPoiDataFromMapHelper
{
  private int jdField_a_of_type_Int = 1;
  private LocationPoiDataFromMapHelper.OnPoiListUpdateListener jdField_a_of_type_ComTencentMobileqqLocationUiLocationPoiDataFromMapHelper$OnPoiListUpdateListener;
  private TencentMap jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap;
  private final LatLng jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
  private final String jdField_a_of_type_JavaLangString;
  private final List<LocationRoom.Venue> jdField_a_of_type_JavaUtilList = new ArrayList(20);
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  LocationPoiDataFromMapHelper(TencentMap paramTencentMap, LatLng paramLatLng, String paramString)
  {
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap = paramTencentMap;
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng = paramLatLng;
    paramTencentMap = paramString;
    if (paramString == null) {
      paramTencentMap = "";
    }
    this.jdField_a_of_type_JavaLangString = paramTencentMap;
  }
  
  void a(LocationPoiDataFromMapHelper.OnPoiListUpdateListener paramOnPoiListUpdateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPoiDataFromMapHelper$OnPoiListUpdateListener = paramOnPoiListUpdateListener;
  }
  
  public boolean a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocationPoiDataFromMapHelper", 4, "[venue][poi-data] fetch next: mKeyWord = " + this.jdField_a_of_type_JavaLangString + " latLng = " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + ", page = " + this.jdField_a_of_type_Int + ", isSearching = " + this.b + ", hasMore = " + this.jdField_a_of_type_Boolean);
    }
    if ((this.b) || (!this.jdField_a_of_type_Boolean)) {
      return false;
    }
    this.b = true;
    TencentSearch localTencentSearch = new TencentSearch(BaseApplication.getContext());
    Object localObject2 = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCityName(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (((String)localObject2).lastIndexOf("市") == ((String)localObject2).length() - 1) {
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
      }
    }
    localObject2 = new LocationPoiDataFromMapHelper.1(this);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localTencentSearch.geo2address(new Geo2AddressParam(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng).getPoi(true).setPoiOptions(new Geo2AddressParam.PoiOptions().setPolicy(1).setPageSize(20).setPageIndex(this.jdField_a_of_type_Int)), (HttpResponseListener)localObject2);
    }
    for (;;)
    {
      return true;
      localTencentSearch.suggestion(new SuggestionParam(this.jdField_a_of_type_JavaLangString, (String)localObject1).location(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng).policy(SuggestionParam.Policy.DEF).pageSize(20).pageIndex(this.jdField_a_of_type_Int), (HttpResponseListener)localObject2);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPoiDataFromMapHelper
 * JD-Core Version:    0.7.0.1
 */