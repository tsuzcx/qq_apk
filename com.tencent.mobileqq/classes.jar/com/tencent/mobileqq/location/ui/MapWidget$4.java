package com.tencent.mobileqq.location.ui;

import android.graphics.Color;
import com.google.gson.Gson;
import com.tencent.lbssearch.httpresponse.HttpResponseListener;
import com.tencent.lbssearch.object.result.DrivingResultObject;
import com.tencent.lbssearch.object.result.DrivingResultObject.Result;
import com.tencent.lbssearch.object.result.DrivingResultObject.Route;
import com.tencent.lbssearch.object.result.TransitResultObject;
import com.tencent.lbssearch.object.result.TransitResultObject.Line;
import com.tencent.lbssearch.object.result.TransitResultObject.Result;
import com.tencent.lbssearch.object.result.TransitResultObject.Route;
import com.tencent.lbssearch.object.result.TransitResultObject.Segment;
import com.tencent.lbssearch.object.result.TransitResultObject.Transit;
import com.tencent.lbssearch.object.result.TransitResultObject.Walking;
import com.tencent.lbssearch.object.result.WalkingResultObject;
import com.tencent.lbssearch.object.result.WalkingResultObject.Result;
import com.tencent.lbssearch.object.result.WalkingResultObject.Route;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.QQUIDelegate;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MapWidget$4
  implements HttpResponseListener
{
  MapWidget$4(MapWidget paramMapWidget, int paramInt, MapWidget.RouteDetail paramRouteDetail) {}
  
  public void onFailure(int paramInt, String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        paramThrowable.printStackTrace();
      }
      paramThrowable = new StringBuilder();
      paramThrowable.append("[map][venue][route]getRoutePlan onFailure invoked. error code: ");
      paramThrowable.append(paramInt);
      paramThrowable.append(" msg: ");
      paramThrowable.append(paramString);
      QLog.d("MapWidget", 2, paramThrowable.toString());
    }
    if (MapWidget.a(this.c) != null) {
      MapWidget.a(this.c).a(false, this.b);
    }
  }
  
  public void onSuccess(int paramInt, Object paramObject)
  {
    Object localObject1 = new Gson().toJson(paramObject);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[map][venue][route]getRoutePlan onSuccess invoked. routeType: ");
      ((StringBuilder)localObject2).append(this.a);
      ((StringBuilder)localObject2).append(" result: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("MapWidget", 2, ((StringBuilder)localObject2).toString());
    }
    paramInt = this.a;
    boolean bool = true;
    localObject1 = null;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          paramObject = localObject1;
        }
        else
        {
          paramObject = (WalkingResultObject)paramObject;
          if ((paramObject != null) && (paramObject.result != null) && (paramObject.result.routes != null) && (!paramObject.result.routes.isEmpty()))
          {
            paramObject = (WalkingResultObject.Route)paramObject.result.routes.get(0);
            this.b.b = paramObject.duration;
            this.b.c = paramObject.distance;
            paramObject = paramObject.polyline;
          }
          else
          {
            paramObject = localObject1;
            if (QLog.isColorLevel())
            {
              QLog.d("MapWidget", 2, "[map][venue][route]getRoutePlan onSuccess invoked. error ROUTE_TYPE_WALK");
              paramObject = localObject1;
            }
          }
        }
      }
      else
      {
        localObject2 = (TransitResultObject)paramObject;
        if ((((TransitResultObject)localObject2).result != null) && (((TransitResultObject)localObject2).result.routes != null) && (!((TransitResultObject)localObject2).result.routes.isEmpty()))
        {
          paramObject = new ArrayList();
          localObject2 = (TransitResultObject.Route)((TransitResultObject)localObject2).result.routes.get(0);
          Iterator localIterator = ((TransitResultObject.Route)localObject2).steps.iterator();
          while (localIterator.hasNext())
          {
            Object localObject3 = (TransitResultObject.Segment)localIterator.next();
            if ((localObject3 instanceof TransitResultObject.Walking))
            {
              paramObject.addAll(((TransitResultObject.Walking)localObject3).polyline);
            }
            else if ((localObject3 instanceof TransitResultObject.Transit))
            {
              localObject3 = (TransitResultObject.Transit)localObject3;
              if ((((TransitResultObject.Transit)localObject3).lines != null) && (!((TransitResultObject.Transit)localObject3).lines.isEmpty())) {
                paramObject.addAll(((TransitResultObject.Line)((TransitResultObject.Transit)localObject3).lines.get(0)).polyline);
              }
            }
          }
          this.b.b = ((float)((TransitResultObject.Route)localObject2).duration);
          this.b.c = ((TransitResultObject.Route)localObject2).distance;
          if (paramObject.isEmpty()) {
            paramObject = localObject1;
          }
        }
        else
        {
          paramObject = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("MapWidget", 2, "[map][venue][route]getRoutePlan onSuccess invoked. error ROUTE_TYPE_BUS");
            paramObject = localObject1;
          }
        }
      }
    }
    else
    {
      paramObject = (DrivingResultObject)paramObject;
      if ((paramObject.result != null) && (paramObject.result.routes != null) && (!paramObject.result.routes.isEmpty()))
      {
        paramObject = (DrivingResultObject.Route)paramObject.result.routes.get(0);
        this.b.b = paramObject.duration;
        this.b.c = paramObject.distance;
        paramObject = paramObject.polyline;
      }
      else
      {
        paramObject = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d("MapWidget", 2, "[map][venue][route]getRoutePlan onSuccess invoked. error ROUTE_TYPE_DRIVE");
          paramObject = localObject1;
        }
      }
    }
    if (paramObject != null)
    {
      if (this.c.c != null) {
        this.c.c(false);
      }
      if (QQUIDelegate.c()) {
        paramInt = Color.parseColor("#0071FF");
      } else {
        paramInt = Color.parseColor("#4D94FF");
      }
      localObject1 = this.c;
      ((MapWidget)localObject1).c = ((MapWidget)localObject1).b.addPolyline(new PolylineOptions().addAll(paramObject).color(paramInt).width(DisplayUtil.a(this.c.getContext(), 5.0F)));
      if (this.c.c != null)
      {
        this.c.a();
        if (this.c.e == 0) {
          MapWidget.c(this.c);
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("MapWidget", 2, "[map][venue][route]getRoutePlan onSuccess invoked. error polyline: null");
    }
    if (MapWidget.a(this.c) != null)
    {
      localObject1 = MapWidget.a(this.c);
      if ((paramObject == null) || (this.c.c == null)) {
        bool = false;
      }
      ((MapWidget.EventListener)localObject1).a(bool, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.MapWidget.4
 * JD-Core Version:    0.7.0.1
 */