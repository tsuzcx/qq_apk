package com.tencent.mobileqq.newnearby.hippy;

import android.content.Intent;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.newnearby.model.AddrInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile.nearbyProfile.BaseProfile;
import com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile.nearbyProfile.SetProfileReq;
import org.json.JSONObject;

public class NearbyHippyCallback
{
  public static void a(NearbyActivity paramNearbyActivity, Intent paramIntent, Promise paramPromise)
  {
    if (paramPromise == null) {
      return;
    }
    int i = paramIntent.getShortExtra("param_year", (short)0);
    int j = paramIntent.getByteExtra("param_month", (byte)0);
    int k = paramIntent.getByteExtra("param_day", (byte)0);
    paramIntent = PkgTools.intToBytes2(i << 16 | j << 8 | k);
    nearbyProfile.SetProfileReq localSetProfileReq = new nearbyProfile.SetProfileReq();
    nearbyProfile.BaseProfile localBaseProfile = new nearbyProfile.BaseProfile();
    localBaseProfile.birthday.set(ByteStringMicro.copyFrom(paramIntent));
    localSetProfileReq.base_profile.set(localBaseProfile);
    ProtoUtils.a(paramNearbyActivity.getAppRuntime(), new NearbyHippyCallback.1(paramPromise, i, j, k), localSetProfileReq.toByteArray(), "trpc.nearby.trpc_nearby_profile.trpc_nearby_profile.SetProfile");
  }
  
  public static void a(Promise paramPromise, int paramInt)
  {
    if (paramPromise == null) {
      return;
    }
    HippyMap localHippyMap1 = new HippyMap();
    localHippyMap1.pushInt("retCode", 0);
    HippyMap localHippyMap2 = new HippyMap();
    localHippyMap2.pushInt("picId", paramInt);
    localHippyMap1.pushObject("data", localHippyMap2);
    paramPromise.resolve(localHippyMap1);
    paramPromise = new StringBuilder();
    paramPromise.append("uploadPhotoCallback: ");
    paramPromise.append(localHippyMap1.toJSONObject().toString());
    QLog.d("NearbyHippyCallback", 2, paramPromise.toString());
  }
  
  public static void a(Promise paramPromise, int paramInt1, int paramInt2)
  {
    if (paramPromise == null) {
      return;
    }
    HippyMap localHippyMap1 = new HippyMap();
    localHippyMap1.pushInt("retCode", 0);
    HippyMap localHippyMap2 = new HippyMap();
    localHippyMap2.pushInt("btnPos", paramInt1);
    localHippyMap2.pushInt("key", paramInt2);
    localHippyMap1.pushObject("data", localHippyMap2);
    paramPromise.resolve(localHippyMap1);
    paramPromise = new StringBuilder();
    paramPromise.append("titleBtnClick: ");
    paramPromise.append(localHippyMap1.toJSONObject().toString());
    QLog.d("NearbyHippyCallback", 2, paramPromise.toString());
  }
  
  public static void a(Promise paramPromise, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramPromise == null) {
      return;
    }
    String str = String.format("%04d-%02d-%02d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("set Birthday: ");
    ((StringBuilder)localObject).append(str);
    QLog.d("NearbyHippyCallback", 2, ((StringBuilder)localObject).toString());
    localObject = new HippyMap();
    ((HippyMap)localObject).pushInt("retCode", 0);
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("birthday", str);
    ((HippyMap)localObject).pushObject("data", localHippyMap);
    paramPromise.resolve(localObject);
  }
  
  public static void a(Promise paramPromise, AddrInfo paramAddrInfo1, AddrInfo paramAddrInfo2, AddrInfo paramAddrInfo3)
  {
    if (paramPromise == null) {
      return;
    }
    HippyMap localHippyMap1 = new HippyMap();
    localHippyMap1.pushInt("retCode", 0);
    HippyMap localHippyMap2 = new HippyMap();
    if (paramAddrInfo3 != null)
    {
      localHippyMap2.pushString("longitude", paramAddrInfo3.d);
      localHippyMap2.pushString("latitude", paramAddrInfo3.e);
      localHippyMap2.pushString("code", paramAddrInfo3.a);
    }
    else
    {
      StringBuilder localStringBuilder;
      if (paramAddrInfo2 != null)
      {
        localHippyMap2.pushString("longitude", paramAddrInfo2.d);
        localHippyMap2.pushString("latitude", paramAddrInfo2.e);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAddrInfo2.a);
        localStringBuilder.append("00");
        localHippyMap2.pushString("code", localStringBuilder.toString());
      }
      else if (paramAddrInfo1 != null)
      {
        localHippyMap2.pushString("longitude", paramAddrInfo1.d);
        localHippyMap2.pushString("latitude", paramAddrInfo1.e);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAddrInfo1.a);
        localStringBuilder.append("0000");
        localHippyMap2.pushString("code", localStringBuilder.toString());
      }
    }
    if (paramAddrInfo3 != null) {
      localHippyMap2.pushString("district", paramAddrInfo3.c);
    }
    if (paramAddrInfo2 != null) {
      localHippyMap2.pushString("city", paramAddrInfo2.c);
    }
    if (paramAddrInfo1 != null) {
      localHippyMap2.pushString("province", paramAddrInfo1.c);
    }
    localHippyMap1.pushObject("data", localHippyMap2);
    paramPromise.resolve(localHippyMap1);
    paramPromise = new StringBuilder();
    paramPromise.append("rspToWebLocation: ");
    paramPromise.append(localHippyMap1.toJSONObject().toString());
    QLog.d("NearbyHippyCallback", 2, paramPromise.toString());
  }
  
  public static void a(Promise paramPromise, SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramPromise == null) {
      return;
    }
    HippyMap localHippyMap1 = new HippyMap();
    localHippyMap1.pushInt("retCode", 0);
    HippyMap localHippyMap2 = new HippyMap();
    localHippyMap2.pushString("longitude", String.valueOf(paramSosoLbsInfo.mLocation.mLon02));
    localHippyMap2.pushString("latitude", String.valueOf(paramSosoLbsInfo.mLocation.mLat02));
    localHippyMap2.pushString("nation", String.valueOf(paramSosoLbsInfo.mLocation.nation));
    localHippyMap2.pushString("province", String.valueOf(paramSosoLbsInfo.mLocation.province));
    localHippyMap2.pushString("city", String.valueOf(paramSosoLbsInfo.mLocation.city));
    localHippyMap2.pushString("district", String.valueOf(paramSosoLbsInfo.mLocation.district));
    localHippyMap1.pushObject("data", localHippyMap2);
    paramPromise.resolve(localHippyMap1);
    paramPromise = new StringBuilder();
    paramPromise.append("rspToWebLBS: ");
    paramPromise.append(localHippyMap1.toJSONObject().toString());
    QLog.d("NearbyHippyCallback", 2, paramPromise.toString());
  }
  
  public static void a(Promise paramPromise, String paramString)
  {
    if (paramPromise == null) {
      return;
    }
    HippyMap localHippyMap1 = new HippyMap();
    localHippyMap1.pushInt("retCode", 0);
    HippyMap localHippyMap2 = new HippyMap();
    localHippyMap2.pushString("picture", paramString);
    localHippyMap1.pushObject("data", localHippyMap2);
    paramPromise.resolve(localHippyMap1);
    paramPromise = new StringBuilder();
    paramPromise.append("pickPhotoCallback: ");
    paramPromise.append(localHippyMap1.toJSONObject().toString());
    QLog.d("NearbyHippyCallback", 2, paramPromise.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.hippy.NearbyHippyCallback
 * JD-Core Version:    0.7.0.1
 */