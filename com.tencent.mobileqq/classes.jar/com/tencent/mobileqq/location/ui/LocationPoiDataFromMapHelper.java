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
  private TencentMap a;
  private final LatLng b;
  private final String c;
  private final List<LocationRoom.Venue> d = new ArrayList(20);
  private int e = 1;
  private boolean f = true;
  private boolean g;
  private LocationPoiDataFromMapHelper.OnPoiListUpdateListener h;
  
  LocationPoiDataFromMapHelper(TencentMap paramTencentMap, LatLng paramLatLng, String paramString)
  {
    this.a = paramTencentMap;
    this.b = paramLatLng;
    paramTencentMap = paramString;
    if (paramString == null) {
      paramTencentMap = "";
    }
    this.c = paramTencentMap;
  }
  
  void a(LocationPoiDataFromMapHelper.OnPoiListUpdateListener paramOnPoiListUpdateListener)
  {
    this.h = paramOnPoiListUpdateListener;
  }
  
  public boolean a()
  {
    Object localObject1;
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[venue][poi-data] fetch next: mKeyWord = ");
      ((StringBuilder)localObject1).append(this.c);
      ((StringBuilder)localObject1).append(" latLng = ");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append(", page = ");
      ((StringBuilder)localObject1).append(this.e);
      ((StringBuilder)localObject1).append(", isSearching = ");
      ((StringBuilder)localObject1).append(this.g);
      ((StringBuilder)localObject1).append(", hasMore = ");
      ((StringBuilder)localObject1).append(this.f);
      QLog.i("LocationPoiDataFromMapHelper", 4, ((StringBuilder)localObject1).toString());
    }
    if (!this.g)
    {
      if (!this.f) {
        return false;
      }
      this.g = true;
      TencentSearch localTencentSearch = new TencentSearch(BaseApplication.getContext());
      Object localObject2 = this.a.getCityName(this.b);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (((String)localObject2).lastIndexOf("市") == ((String)localObject2).length() - 1) {
          localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
        }
      }
      localObject2 = new LocationPoiDataFromMapHelper.1(this);
      if (TextUtils.isEmpty(this.c))
      {
        localTencentSearch.geo2address(new Geo2AddressParam(this.b).getPoi(true).setPoiOptions(new Geo2AddressParam.PoiOptions().setPolicy(1).setPageSize(20).setPageIndex(this.e)), (HttpResponseListener)localObject2);
        return true;
      }
      localTencentSearch.suggestion(new SuggestionParam(this.c, (String)localObject1).location(this.b).policy(SuggestionParam.Policy.DEF).pageSize(20).pageIndex(this.e), (HttpResponseListener)localObject2);
      return true;
    }
    return false;
  }
  
  public boolean b()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPoiDataFromMapHelper
 * JD-Core Version:    0.7.0.1
 */