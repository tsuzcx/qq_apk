package com.tencent.mobileqq.kandian.repo.feeds;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PositionData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xdc0.oidb_0xdc0.GroupInfo;
import tencent.im.oidb.cmd0xdc0.oidb_0xdc0.LocationInfo;
import tencent.im.oidb.cmd0xdc0.oidb_0xdc0.LocationList;
import tencent.im.oidb.cmd0xdc0.oidb_0xdc0.ReqBody;
import tencent.im.oidb.cmd0xdc0.oidb_0xdc0.RspBody;

public class SelectPositionModule
  extends ReadInJoyEngineModule
{
  private SelectPositionModule.IPositionOrCityListChangedListener a;
  private SosoInterfaceOnLocationListener b;
  private volatile PositionData c;
  private volatile PositionData d;
  private volatile long e = 0L;
  private volatile List<CityData> f = new CopyOnWriteArrayList();
  
  public SelectPositionModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private PositionData a(String paramString)
  {
    Object localObject1 = RIJSPUtils.a(BaseApplicationImpl.getApplication().getRuntime(), true, false);
    if (localObject1 != null)
    {
      localObject1 = ((SharedPreferences)localObject1).getString(paramString, "");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        try
        {
          localObject2 = new JSONObject((String)localObject1);
          PositionData localPositionData = new PositionData();
          localPositionData.country = ((JSONObject)localObject2).getString("key_country");
          localPositionData.province = ((JSONObject)localObject2).getString("key_province");
          localPositionData.city = ((JSONObject)localObject2).getString("key_city");
          localPositionData.cityCode = ((JSONObject)localObject2).getString("key_citycode");
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getPositionDataByKey position = ");
            ((StringBuilder)localObject2).append(localPositionData);
            ((StringBuilder)localObject2).append(" key = ");
            ((StringBuilder)localObject2).append(paramString);
            QLog.d("SelectPositionModule", 2, ((StringBuilder)localObject2).toString());
          }
          return localPositionData;
        }
        catch (JSONException localJSONException)
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getSelectedPositionData positionJson = ");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(" exception = ");
          ((StringBuilder)localObject2).append(localJSONException);
          ((StringBuilder)localObject2).append(" key = ");
          ((StringBuilder)localObject2).append(paramString);
          QLog.e("SelectPositionModule", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
    return null;
  }
  
  private void a(PositionData paramPositionData, String paramString)
  {
    if (paramPositionData == null) {}
    try
    {
      QLog.e("SelectPositionModule", 1, "savePositionDataByKey positionData == null");
      return;
    }
    catch (JSONException localJSONException)
    {
      JSONObject localJSONObject;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveSelectedPositionData error positionData = ");
      ((StringBuilder)localObject).append(paramPositionData);
      ((StringBuilder)localObject).append(" ,error = ");
      ((StringBuilder)localObject).append(localJSONException);
      ((StringBuilder)localObject).append(" key = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("SelectPositionModule", 2, ((StringBuilder)localObject).toString());
    }
    localJSONObject = new JSONObject();
    localJSONObject.put("key_country", paramPositionData.country);
    localJSONObject.put("key_province", paramPositionData.province);
    localJSONObject.put("key_city", paramPositionData.city);
    localJSONObject.put("key_citycode", paramPositionData.cityCode);
    localObject = RIJSPUtils.a(BaseApplicationImpl.getApplication().getRuntime(), true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString, localJSONObject.toString());
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("save position = ");
        ((StringBuilder)localObject).append(localJSONObject);
        ((StringBuilder)localObject).append(" key = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("SelectPositionModule", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_0xdc0.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    int k = 0;
    QLog.d("SelectPositionModule", 2, new Object[] { "handle0xdc0WhiteList result = ", Integer.valueOf(i) });
    if (i == 0)
    {
      this.e = System.currentTimeMillis();
      paramFromServiceMsg = new ArrayList();
      if (((oidb_0xdc0.RspBody)localObject).msg_location_list.has())
      {
        paramObject = (oidb_0xdc0.LocationList)((oidb_0xdc0.RspBody)localObject).msg_location_list.get();
        if ((paramObject.rpt_group_list.has()) && (paramObject.rpt_group_list.size() > 0))
        {
          i = 0;
          while (i < paramObject.rpt_group_list.size())
          {
            localObject = (oidb_0xdc0.GroupInfo)paramObject.rpt_group_list.get(i);
            if (((oidb_0xdc0.GroupInfo)localObject).bytes_name.has()) {
              paramFromServiceMsg.add(new CityData(((oidb_0xdc0.GroupInfo)localObject).bytes_name.get().toStringUtf8()));
            }
            if ((((oidb_0xdc0.GroupInfo)localObject).rpt_location_list.has()) && (((oidb_0xdc0.GroupInfo)localObject).rpt_location_list.size() > 0))
            {
              int j = 0;
              while (j < ((oidb_0xdc0.GroupInfo)localObject).rpt_location_list.size())
              {
                oidb_0xdc0.LocationInfo localLocationInfo = (oidb_0xdc0.LocationInfo)((oidb_0xdc0.GroupInfo)localObject).rpt_location_list.get(j);
                if ((localLocationInfo.bytes_city.has()) && (localLocationInfo.bytes_city_code.has())) {
                  if ((localLocationInfo.bytes_province.has()) && (localLocationInfo.bytes_country.has())) {
                    paramFromServiceMsg.add(new CityData(localLocationInfo.bytes_country.get().toStringUtf8(), localLocationInfo.bytes_province.get().toStringUtf8(), localLocationInfo.bytes_city.get().toStringUtf8(), localLocationInfo.bytes_city_code.get().toStringUtf8()));
                  } else {
                    paramFromServiceMsg.add(new CityData("", "", localLocationInfo.bytes_city.get().toStringUtf8(), localLocationInfo.bytes_city_code.get().toStringUtf8()));
                  }
                }
                j += 1;
              }
            }
            i += 1;
          }
        }
      }
      this.f.clear();
      this.f.addAll(paramFromServiceMsg);
      if (QLog.isColorLevel())
      {
        if (!this.f.isEmpty())
        {
          i = k;
          while (i < this.f.size())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("handle0xdc0WhiteList result, City = ");
            paramFromServiceMsg.append(this.f.get(i));
            QLog.i("SelectPositionModule", 2, paramFromServiceMsg.toString());
            i += 1;
          }
        }
        QLog.i("SelectPositionModule", 2, "handle0xdc0WhiteList result, mCityWhiteList is empty");
      }
      paramFromServiceMsg = this.a;
      if (paramFromServiceMsg != null) {
        paramFromServiceMsg.a(this.f);
      }
      if (paramToServiceMsg.extraData.getBoolean("need_check_local_city_changed", true)) {
        i();
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = new oidb_0xdc0.ReqBody();
    ((oidb_0xdc0.ReqBody)localObject).uint32_req_type.set(1);
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0xdc0", 3520, 0, ((oidb_0xdc0.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("need_check_local_city_changed", paramBoolean);
    sendPbReq((ToServiceMsg)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestCityWhiteListListFromServer needCheckLocalCityChanged = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("SelectPositionModule", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void b(String paramString)
  {
    Object localObject = RIJSPUtils.a(BaseApplicationImpl.getApplication().getRuntime(), true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString, "");
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("clearPositionDataByKey key = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("SelectPositionModule", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void d(PositionData paramPositionData)
  {
    Object localObject = h();
    if (paramPositionData.equals(localObject))
    {
      if (QLog.isColorLevel())
      {
        paramPositionData = new StringBuilder();
        paramPositionData.append("handleLocalChannel currentGPSPosition.equals(lastGPSPosition) lastGPSPosition = ");
        paramPositionData.append(localObject);
        QLog.d("SelectPositionModule", 2, paramPositionData.toString());
      }
      return;
    }
    this.d = e();
    if (paramPositionData.equals(this.d))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleLocalChannel currentGPSPosition.equals(lastGPSPosition) currentGPSPosition = ");
        ((StringBuilder)localObject).append(paramPositionData);
        QLog.d("SelectPositionModule", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if ((System.currentTimeMillis() - this.e < 86400000L) && (!this.f.isEmpty()))
    {
      i();
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleLocalChannel currentGPSPosition.equals(lastGPSPosition) currentGPSPosition = ");
      ((StringBuilder)localObject).append(paramPositionData);
      QLog.d("SelectPositionModule", 2, ((StringBuilder)localObject).toString());
    }
    a(true);
  }
  
  private void e(PositionData paramPositionData)
  {
    a(paramPositionData, "key_gps_position");
  }
  
  private PositionData g()
  {
    return a("key_selected_position");
  }
  
  private PositionData h()
  {
    return a("key_gps_position");
  }
  
  private void i()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkNeedChangeLocalCity checkNeedChangeLocalCity mGPSPositionData = ");
      ((StringBuilder)localObject).append(this.c);
      QLog.i("SelectPositionModule", 2, ((StringBuilder)localObject).toString());
    }
    if (this.d != null) {
      localObject = this.d;
    } else {
      localObject = h();
    }
    StringBuilder localStringBuilder;
    if (a(this.c))
    {
      c(this.c);
      if ((a((PositionData)localObject)) && (!this.c.equals(localObject)))
      {
        ReadInJoyLogicEngineEventDispatcher.a().a(1, this.c);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkNeedChangeLocalCity changeCity lastPositionData = ");
          localStringBuilder.append(localObject);
          QLog.i("SelectPositionModule", 2, localStringBuilder.toString());
        }
      }
      else
      {
        f();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkNeedChangeLocalCity clearSelectedPositionData mSelectedPositionData = ");
          localStringBuilder.append(localObject);
          QLog.i("SelectPositionModule", 2, localStringBuilder.toString());
        }
      }
    }
    else if (a((PositionData)localObject))
    {
      ReadInJoyLogicEngineEventDispatcher.a().a(2, this.c);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkNeedChangeLocalCity reserveCity mSelectedPositionData = ");
        localStringBuilder.append(localObject);
        QLog.i("SelectPositionModule", 2, localStringBuilder.toString());
      }
    }
  }
  
  public List<CityData> a()
  {
    if ((this.f != null) && (!this.f.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPositionModule", 2, "getCityWhiteList mCityWhiteList is not empty");
      }
      return this.f;
    }
    a(false);
    if (QLog.isColorLevel()) {
      QLog.d("SelectPositionModule", 2, "getCityWhiteList mCityWhiteList is empty");
    }
    return null;
  }
  
  public void a(SelectPositionModule.IPositionOrCityListChangedListener paramIPositionOrCityListChangedListener)
  {
    this.a = paramIPositionOrCityListChangedListener;
  }
  
  public boolean a(PositionData paramPositionData)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkPositionInCityWhiteList currentPosition = ");
      ((StringBuilder)localObject).append(paramPositionData);
      QLog.d("SelectPositionModule", 2, ((StringBuilder)localObject).toString());
    }
    if (paramPositionData == null)
    {
      QLog.e("SelectPositionModule", 2, "checkPositionInCityWhiteList currentPosition == null");
      return false;
    }
    int i = 0;
    while (i < this.f.size())
    {
      localObject = (CityData)this.f.get(i);
      if (paramPositionData.cityCode.equals(((CityData)localObject).f))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("checkPositionInCityWhiteList true currentPosition = ");
          ((StringBuilder)localObject).append(paramPositionData);
          QLog.d("SelectPositionModule", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public PositionData b()
  {
    StringBuilder localStringBuilder;
    if (this.d != null)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("positionData = ");
        localStringBuilder.append(this.d);
        QLog.i("SelectPositionModule", 2, localStringBuilder.toString());
      }
      return this.d;
    }
    this.d = g();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSelectedPositionDataLastTime = ");
      localStringBuilder.append(this.d);
      QLog.i("SelectPositionModule", 2, localStringBuilder.toString());
    }
    if (this.d != null) {
      return this.d;
    }
    return c();
  }
  
  public void b(PositionData paramPositionData)
  {
    if (paramPositionData == null) {
      QLog.i("SelectPositionModule", 2, "saveSelectedPositionData positionData == null");
    }
    this.d = paramPositionData;
    a(paramPositionData, "key_selected_position");
  }
  
  public PositionData c()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGPSPositionData mGPSPositionData = ");
      localStringBuilder.append(this.c);
      QLog.i("SelectPositionModule", 2, localStringBuilder.toString());
    }
    if (this.c == null)
    {
      this.c = h();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getGPSPositionDataLastTime mGPSPositionData = ");
        localStringBuilder.append(this.c);
        QLog.i("SelectPositionModule", 2, localStringBuilder.toString());
      }
    }
    return this.c;
  }
  
  public void c(PositionData paramPositionData)
  {
    int i = 0;
    while (i < this.f.size())
    {
      CityData localCityData = (CityData)this.f.get(i);
      if (paramPositionData.cityCode.equals(localCityData.f)) {
        paramPositionData.city = localCityData.c;
      }
      i += 1;
    }
  }
  
  public void d()
  {
    QLog.d("SelectPositionModule", 2, "requestCurrentLoction");
    if (this.b == null) {
      this.b = new SelectPositionModule.1(this, 3, true, true, 0L, false, false, "readinjoy_position");
    }
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.b);
  }
  
  public PositionData e()
  {
    if (this.d == null) {
      this.d = g();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSelectedPositionData mSelectedPositionData = ");
      localStringBuilder.append(this.d);
      QLog.d("SelectPositionModule", 2, localStringBuilder.toString());
    }
    return this.d;
  }
  
  public void f()
  {
    b("key_selected_position");
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xdc0")) {
      ThreadManager.getUIHandler().post(new SelectPositionModule.2(this, paramToServiceMsg, paramFromServiceMsg, paramObject));
    }
  }
  
  public void unInitialize() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.SelectPositionModule
 * JD-Core Version:    0.7.0.1
 */