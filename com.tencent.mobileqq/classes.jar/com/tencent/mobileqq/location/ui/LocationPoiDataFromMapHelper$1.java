package com.tencent.mobileqq.location.ui;

import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.httpresponse.HttpResponseListener;
import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject.ReverseAddressResult;
import com.tencent.lbssearch.object.result.SearchResultObject;
import com.tencent.lbssearch.object.result.SearchResultObject.SearchResultData;
import com.tencent.lbssearch.object.result.SuggestionResultObject;
import com.tencent.lbssearch.object.result.SuggestionResultObject.SuggestionData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

class LocationPoiDataFromMapHelper$1
  implements HttpResponseListener<BaseObject>
{
  LocationPoiDataFromMapHelper$1(LocationPoiDataFromMapHelper paramLocationPoiDataFromMapHelper) {}
  
  public void a(int paramInt, BaseObject paramBaseObject)
  {
    Object localObject = this.a;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    LocationPoiDataFromMapHelper.a((LocationPoiDataFromMapHelper)localObject, false);
    localObject = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    Iterator localIterator;
    LocationRoom.Venue localVenue;
    if ((paramBaseObject instanceof Geo2AddressResultObject))
    {
      paramBaseObject = (Geo2AddressResultObject)paramBaseObject;
      if ((paramBaseObject.result != null) && (paramBaseObject.result.pois != null))
      {
        LocationPoiDataFromMapHelper.a(this.a);
        localIterator = paramBaseObject.result.pois.iterator();
        while (localIterator.hasNext())
        {
          localVenue = LocationRoom.Venue.a((String)localObject, (Poi)localIterator.next());
          LocationPoiDataFromMapHelper.b(this.a).add(localVenue);
        }
        localObject = this.a;
        if (paramBaseObject.result.poi_count >= 20) {
          bool1 = true;
        }
        LocationPoiDataFromMapHelper.b((LocationPoiDataFromMapHelper)localObject, bool1);
      }
    }
    else if ((paramBaseObject instanceof SuggestionResultObject))
    {
      paramBaseObject = (SuggestionResultObject)paramBaseObject;
      if (paramBaseObject.data != null)
      {
        LocationPoiDataFromMapHelper.a(this.a);
        localIterator = paramBaseObject.data.iterator();
        while (localIterator.hasNext())
        {
          localVenue = LocationRoom.Venue.a((String)localObject, (SuggestionResultObject.SuggestionData)localIterator.next());
          LocationPoiDataFromMapHelper.b(this.a).add(localVenue);
        }
        localObject = this.a;
        bool1 = bool2;
        if (paramBaseObject.count >= 20) {
          bool1 = true;
        }
        LocationPoiDataFromMapHelper.b((LocationPoiDataFromMapHelper)localObject, bool1);
      }
    }
    else if ((paramBaseObject instanceof SearchResultObject))
    {
      paramBaseObject = (SearchResultObject)paramBaseObject;
      if (paramBaseObject.data != null)
      {
        LocationPoiDataFromMapHelper.a(this.a);
        localIterator = paramBaseObject.data.iterator();
        while (localIterator.hasNext())
        {
          localVenue = LocationRoom.Venue.a((String)localObject, (SearchResultObject.SearchResultData)localIterator.next());
          LocationPoiDataFromMapHelper.b(this.a).add(localVenue);
        }
        localObject = this.a;
        bool1 = bool3;
        if (paramBaseObject.count >= 20) {
          bool1 = true;
        }
        LocationPoiDataFromMapHelper.b((LocationPoiDataFromMapHelper)localObject, bool1);
      }
    }
    if (QLog.isDevelopLevel())
    {
      paramBaseObject = new StringBuilder();
      paramBaseObject.append("[venue][poi-data] fetch onSuccess: mVenueList size = ");
      paramBaseObject.append(LocationPoiDataFromMapHelper.b(this.a).size());
      paramBaseObject.append(", mHashMore = ");
      paramBaseObject.append(LocationPoiDataFromMapHelper.c(this.a));
      QLog.i("LocationPoiDataFromMapHelper", 4, paramBaseObject.toString());
    }
    if (LocationPoiDataFromMapHelper.d(this.a) != null) {
      ThreadManager.getUIHandler().post(new LocationPoiDataFromMapHelper.1.1(this));
    }
  }
  
  public void onFailure(int paramInt, String paramString, Throwable paramThrowable)
  {
    LocationPoiDataFromMapHelper.a(this.a, false);
    if (QLog.isDevelopLevel())
    {
      paramString = new StringBuilder();
      paramString.append("[venue][poi-data] fetch onFailure: mVenueList size = ");
      paramString.append(LocationPoiDataFromMapHelper.b(this.a).size());
      paramString.append(", mHashMore = ");
      paramString.append(LocationPoiDataFromMapHelper.c(this.a));
      QLog.i("LocationPoiDataFromMapHelper", 4, paramString.toString());
    }
    if (LocationPoiDataFromMapHelper.d(this.a) != null) {
      ThreadManager.getUIHandler().post(new LocationPoiDataFromMapHelper.1.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPoiDataFromMapHelper.1
 * JD-Core Version:    0.7.0.1
 */