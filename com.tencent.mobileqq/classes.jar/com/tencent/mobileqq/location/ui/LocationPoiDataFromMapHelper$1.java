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
    boolean bool2 = true;
    boolean bool1 = true;
    LocationPoiDataFromMapHelper.a(this.a, false);
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
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
          LocationPoiDataFromMapHelper.a(this.a).add(localVenue);
        }
        localObject = this.a;
        if (paramBaseObject.result.poi_count < 20) {
          break label232;
        }
        bool1 = true;
        LocationPoiDataFromMapHelper.b((LocationPoiDataFromMapHelper)localObject, bool1);
      }
    }
    label232:
    do
    {
      do
      {
        do
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("LocationPoiDataFromMapHelper", 4, "[venue][poi-data] fetch onSuccess: mVenueList size = " + LocationPoiDataFromMapHelper.a(this.a).size() + ", mHashMore = " + LocationPoiDataFromMapHelper.a(this.a));
          }
          if (LocationPoiDataFromMapHelper.a(this.a) != null) {
            ThreadManager.getUIHandler().post(new LocationPoiDataFromMapHelper.1.1(this));
          }
          return;
          bool1 = false;
          break;
          if (!(paramBaseObject instanceof SuggestionResultObject)) {
            break label350;
          }
          paramBaseObject = (SuggestionResultObject)paramBaseObject;
        } while (paramBaseObject.data == null);
        LocationPoiDataFromMapHelper.a(this.a);
        localIterator = paramBaseObject.data.iterator();
        while (localIterator.hasNext())
        {
          localVenue = LocationRoom.Venue.a((String)localObject, (SuggestionResultObject.SuggestionData)localIterator.next());
          LocationPoiDataFromMapHelper.a(this.a).add(localVenue);
        }
        localObject = this.a;
        if (paramBaseObject.count >= 20) {}
        for (;;)
        {
          LocationPoiDataFromMapHelper.b((LocationPoiDataFromMapHelper)localObject, bool1);
          break;
          bool1 = false;
        }
      } while (!(paramBaseObject instanceof SearchResultObject));
      paramBaseObject = (SearchResultObject)paramBaseObject;
    } while (paramBaseObject.data == null);
    label350:
    LocationPoiDataFromMapHelper.a(this.a);
    Iterator localIterator = paramBaseObject.data.iterator();
    while (localIterator.hasNext())
    {
      localVenue = LocationRoom.Venue.a((String)localObject, (SearchResultObject.SearchResultData)localIterator.next());
      LocationPoiDataFromMapHelper.a(this.a).add(localVenue);
    }
    localObject = this.a;
    if (paramBaseObject.count >= 20) {}
    for (bool1 = bool2;; bool1 = false)
    {
      LocationPoiDataFromMapHelper.b((LocationPoiDataFromMapHelper)localObject, bool1);
      break;
    }
  }
  
  public void onFailure(int paramInt, String paramString, Throwable paramThrowable)
  {
    LocationPoiDataFromMapHelper.a(this.a, false);
    if (QLog.isDevelopLevel()) {
      QLog.i("LocationPoiDataFromMapHelper", 4, "[venue][poi-data] fetch onFailure: mVenueList size = " + LocationPoiDataFromMapHelper.a(this.a).size() + ", mHashMore = " + LocationPoiDataFromMapHelper.a(this.a));
    }
    if (LocationPoiDataFromMapHelper.a(this.a) != null) {
      ThreadManager.getUIHandler().post(new LocationPoiDataFromMapHelper.1.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPoiDataFromMapHelper.1
 * JD-Core Version:    0.7.0.1
 */