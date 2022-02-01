package com.tencent.mobileqq.kandian.glue.report;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.RIJDeviceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGalleryBiu;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil.NetInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.gallery.gallery_report.GalleryExpReported;

public class GalleryReportedUtils
{
  private static boolean a = false;
  
  public static int a(int paramInt)
  {
    if ((paramInt != 48) && (paramInt != 51))
    {
      if ((paramInt != 49) && (paramInt != 52))
      {
        if (paramInt == 78) {
          return 5;
        }
        if (paramInt == 79) {
          return 6;
        }
        if (paramInt == 80) {
          return 7;
        }
        if (paramInt == 1005) {
          return 9;
        }
        if (paramInt == 1006) {
          return 10;
        }
        if (paramInt == 1007) {
          return 11;
        }
        return 3;
      }
      return 2;
    }
    return 1;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if ((paramInt2 != 48) && (paramInt2 != 49) && (paramInt2 != 50) && (paramInt2 != 78)) {
        return 4;
      }
      return 1;
    }
    if (paramInt1 == 70)
    {
      if ((paramInt2 != 48) && (paramInt2 != 49) && (paramInt2 != 50) && (paramInt2 != 78)) {
        return 6;
      }
      return 5;
    }
    if (RIJFeedsType.a(paramInt1)) {
      return 3;
    }
    return 0;
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((int)Math.ceil(Float.valueOf((float)DeviceInfoUtil.a()).floatValue() / 1024.0F / 1024.0F / 1024.0F));
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  public static String a(Context paramContext)
  {
    paramContext = DeviceInfoUtil.f(paramContext).a;
    if (!TextUtils.isEmpty(paramContext))
    {
      if (paramContext.equals("WIFI")) {
        return "1";
      }
      if ((!paramContext.equals("4G")) && (!paramContext.equals("3G"))) {
        return "0";
      }
      return "2";
    }
    return "0";
  }
  
  public static String a(Context paramContext, long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4)
  {
    return a(paramContext, paramLong1, paramInt1, paramLong2, paramLong3, paramInt2, paramString1, paramString2, paramInt3, paramInt4, null);
  }
  
  public static String a(Context paramContext, long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, String paramString3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", a(paramContext));
      localJSONObject.put("version", VideoReporter.a);
      localJSONObject.put("os", "1");
      paramContext = new StringBuilder();
      paramContext.append(paramLong1);
      paramContext.append("");
      localJSONObject.put("uin", paramContext.toString());
      paramContext = new StringBuilder();
      paramContext.append(paramInt1);
      paramContext.append("");
      localJSONObject.put("source", paramContext.toString());
      localJSONObject.put("mem_size", a());
      paramContext = new StringBuilder();
      paramContext.append(paramLong2);
      paramContext.append("");
      localJSONObject.put("article_id", paramContext.toString());
      localJSONObject.put("city", b());
      paramContext = new StringBuilder();
      paramContext.append(paramLong3);
      paramContext.append("");
      localJSONObject.put("exptime", paramContext.toString());
      paramContext = new StringBuilder();
      paramContext.append(paramInt2);
      paramContext.append("");
      localJSONObject.put("pos", paramContext.toString());
      localJSONObject.put("rowkey", paramString1);
      localJSONObject.put("proxy_bytes", paramString2);
      paramContext = new StringBuilder();
      paramContext.append(paramInt3);
      paramContext.append("");
      localJSONObject.put("card_type", paramContext.toString());
      localJSONObject.put("imei", RIJDeviceUtil.a());
      localJSONObject.put("imsi", RIJDeviceUtil.b());
      localJSONObject.put("channel_id", paramInt4);
      if (!TextUtils.isEmpty(paramString3)) {
        localJSONObject.put("source_rowkey", paramString3);
      }
      paramContext = localJSONObject.toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("galleryExpReport:");
        paramString1.append(paramContext.toString());
        QLog.d("GalleryReportedUtils", 2, paramString1.toString());
      }
    }
    return "";
  }
  
  public static String a(Context paramContext, String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4, int paramInt5, JSONObject paramJSONObject)
  {
    return a(paramContext, paramString1, paramInt1, paramLong, paramInt2, paramString2, paramString3, paramInt3, paramInt4, paramInt5, paramJSONObject, null);
  }
  
  public static String a(Context paramContext, String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4, int paramInt5, JSONObject paramJSONObject, String paramString4)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {}
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("network", a(paramContext));
      paramContext = new StringBuilder();
      paramContext.append(VideoReporter.a);
      paramContext.append("");
      localJSONObject.put("version", paramContext.toString());
      localJSONObject.put("os", "1");
      localJSONObject.put("uin", paramString1);
      paramContext = new StringBuilder();
      paramContext.append(paramInt1);
      paramContext.append("");
      localJSONObject.put("source", paramContext.toString());
      localJSONObject.put("mem_size", a());
      paramContext = new StringBuilder();
      paramContext.append(paramLong);
      paramContext.append("");
      localJSONObject.put("article_id", paramContext.toString());
      localJSONObject.put("city", b());
      paramContext = new StringBuilder();
      paramContext.append(System.currentTimeMillis());
      paramContext.append("");
      localJSONObject.put("exptime", paramContext.toString());
      paramContext = new StringBuilder();
      paramContext.append(paramInt2);
      paramContext.append("");
      localJSONObject.put("pos", paramContext.toString());
      localJSONObject.put("rowkey", paramString2);
      localJSONObject.put("proxy_bytes", paramString3);
      localJSONObject.put("card_type", paramInt3);
      paramContext = new StringBuilder();
      paramContext.append(paramInt4);
      paramContext.append("");
      localJSONObject.put("pic_click", paramContext.toString());
      localJSONObject.put("imei", RIJDeviceUtil.a());
      localJSONObject.put("imsi", RIJDeviceUtil.b());
      localJSONObject.put("channel_id", paramInt5);
      if (!TextUtils.isEmpty(paramString4)) {
        localJSONObject.put("source_rowkey", paramString4);
      }
      paramContext = localJSONObject.toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("galleryClickReport:");
        paramString1.append(paramContext.toString());
        QLog.d("GalleryReportedUtils", 2, paramString1.toString());
      }
    }
    return "";
  }
  
  public static JSONObject a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("network", a(paramContext));
      paramContext = new StringBuilder();
      paramContext.append(VideoReporter.a);
      paramContext.append("");
      localJSONObject.put("version", paramContext.toString());
      localJSONObject.put("os", "1");
      paramContext = new StringBuilder();
      paramContext.append(RIJQQAppInterfaceUtil.c());
      paramContext.append("");
      localJSONObject.put("uin", paramContext.toString());
      localJSONObject.put("source", String.valueOf(paramInt2));
      localJSONObject.put("mem_size", a());
      localJSONObject.put("article_id", paramAbsBaseArticleInfo.mArticleID);
      localJSONObject.put("city", b());
      localJSONObject.put("pos", String.valueOf(paramInt3));
      localJSONObject.put("rowkey", ReadinjoyReportUtils.c(paramAbsBaseArticleInfo));
      localJSONObject.put("channel_id", String.valueOf(paramInt1));
      return localJSONObject;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static JSONObject a(Context paramContext, String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean, Boolean paramBoolean1)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("network", a(paramContext));
      localJSONObject.put("os", "1");
      paramContext = new StringBuilder();
      paramContext.append(paramInt1);
      paramContext.append("");
      localJSONObject.put("source", paramContext.toString());
      localJSONObject.put("uin", paramString1);
      localJSONObject.put("rowkey", paramString2);
      localJSONObject.put("version", VideoReporter.a);
      paramInt1 = 1;
      if (paramBoolean) {
        localJSONObject.put("cancel", String.valueOf(1));
      }
      if (paramInt2 >= 0)
      {
        paramContext = new StringBuilder();
        paramContext.append(paramInt2);
        paramContext.append("");
        localJSONObject.put("sourcefrom", paramContext.toString());
      }
      if (paramInt3 >= 0)
      {
        paramContext = new StringBuilder();
        paramContext.append(paramInt3);
        paramContext.append("");
        localJSONObject.put("share_unit", paramContext.toString());
      }
      if (paramBoolean1 != null)
      {
        if (paramBoolean1.booleanValue()) {
          paramInt1 = 0;
        }
        localJSONObject.put("result", paramInt1);
        return localJSONObject;
      }
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("shareReport:");
        paramString1.append(paramContext.toString());
        QLog.d("GalleryReportedUtils", 2, paramString1.toString());
      }
    }
    return localJSONObject;
  }
  
  public static void a(int paramInt1, long paramLong1, int paramInt2, int paramInt3, long paramLong2, int paramInt4, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mIsGallery = true;
    localReportInfo.mUin = paramLong1;
    localReportInfo.mAlgorithmId = paramInt2;
    localReportInfo.mOperation = paramInt1;
    gallery_report.GalleryExpReported localGalleryExpReported = new gallery_report.GalleryExpReported();
    localGalleryExpReported.phone_type.set(1);
    if (!TextUtils.isEmpty("8.8.17")) {
      localGalleryExpReported.client_ver.set(ByteStringMicro.copyFromUtf8("8.8.17"));
    }
    localGalleryExpReported.source.set(paramInt3);
    if (!TextUtils.isEmpty(a())) {
      localGalleryExpReported.mem_size.set(Float.valueOf(a()).floatValue());
    }
    if (!TextUtils.isEmpty(b())) {
      localGalleryExpReported.city.set(ByteStringMicro.copyFromUtf8(b()));
    }
    localGalleryExpReported.exptime.set(paramLong2);
    localGalleryExpReported.pos.set(paramInt4);
    if (!TextUtils.isEmpty(paramString1)) {
      localGalleryExpReported.rowkey.set(ByteStringMicro.copyFromUtf8(paramString1));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localGalleryExpReported.proxy_bytes.set(ByteStringMicro.copyFromUtf8(paramString2));
    }
    localReportInfo.mGalleryReportInfo = localGalleryExpReported.toByteArray();
    localArrayList.add(localReportInfo);
    ReadInJoyLogicEngine.a().a(localArrayList);
  }
  
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if ((RIJFeedsType.c(paramAbsBaseArticleInfo)) || (RIJFeedsType.r(paramAbsBaseArticleInfo)) || (RIJFeedsType.ab(paramAbsBaseArticleInfo)))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.c());
      ((StringBuilder)localObject).append("");
      paramContext = a(paramContext, ((StringBuilder)localObject).toString(), ComponentContentGalleryBiu.a(paramAbsBaseArticleInfo, paramReadInJoyBaseAdapter), paramAbsBaseArticleInfo.mArticleID, paramReadInJoyBaseAdapter.h().indexOf(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo.innerUniqueID, paramAbsBaseArticleInfo.galleryReprotExdData, a(RIJFeedsType.g(paramAbsBaseArticleInfo)), 0, (int)paramAbsBaseArticleInfo.mChannelID, null);
      paramReadInJoyBaseAdapter = new StringBuilder();
      paramReadInJoyBaseAdapter.append("");
      paramReadInJoyBaseAdapter.append(paramAbsBaseArticleInfo.publishUin);
      paramReadInJoyBaseAdapter = paramReadInJoyBaseAdapter.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mArticleID);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAbsBaseArticleInfo.mAlgorithmID);
      localStringBuilder.append("");
      PublicAccountReportUtils.a(null, paramReadInJoyBaseAdapter, "0X8008E2F", "0X8008E2F", 0, 0, "", (String)localObject, localStringBuilder.toString(), paramContext, false);
    }
  }
  
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, JSONObject paramJSONObject)
  {
    int i = RIJFeedsType.g(paramAbsBaseArticleInfo);
    i = a((int)paramAbsBaseArticleInfo.mChannelID, i);
    if (paramJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    try
    {
      paramJSONObject.put("pics", paramAbsBaseArticleInfo.mGalleryPicNumber);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.c());
    ((StringBuilder)localObject).append("");
    paramContext = a(paramContext, ((StringBuilder)localObject).toString(), i, paramAbsBaseArticleInfo.mArticleID, 0, paramAbsBaseArticleInfo.innerUniqueID, paramAbsBaseArticleInfo.galleryReprotExdData, a(RIJFeedsType.g(paramAbsBaseArticleInfo)), 0, (int)paramAbsBaseArticleInfo.mChannelID, paramJSONObject);
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("");
    paramJSONObject.append(paramAbsBaseArticleInfo.publishUin);
    paramJSONObject = paramJSONObject.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mArticleID);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAbsBaseArticleInfo.mAlgorithmID);
    localStringBuilder.append("");
    PublicAccountReportUtils.a(null, paramJSONObject, paramString, paramString, 0, 0, "", (String)localObject, localStringBuilder.toString(), paramContext, false);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("network", a(paramContext));
      paramContext = new StringBuilder();
      paramContext.append(VideoReporter.a);
      paramContext.append("");
      localJSONObject.put("version", paramContext.toString());
      localJSONObject.put("os", "1");
      paramContext = new StringBuilder();
      paramContext.append(RIJQQAppInterfaceUtil.c());
      paramContext.append("");
      localJSONObject.put("uin", paramContext.toString());
      localJSONObject.put("mem_size", a());
      localJSONObject.put("city", b());
      localJSONObject.put("channel_id", String.valueOf(paramInt1));
      localJSONObject.put("sub_channel_id", paramInt2);
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
    PublicAccountReportUtils.a(null, "", paramString, paramString, 0, 0, "", "", "", localJSONObject.toString(), false);
  }
  
  public static void a(GalleryReportedUtils.ReportData paramReportData)
  {
    PublicAccountReportUtils.a(null, paramReportData.b, paramReportData.c, paramReportData.d, 0, 0, "", paramReportData.f, paramReportData.g, paramReportData.h, false);
  }
  
  public static String b()
  {
    SosoLbsInfo localSosoLbsInfo = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getSosoInfo();
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null) && (!TextUtils.isEmpty(localSosoLbsInfo.mLocation.city))) {
      return localSosoLbsInfo.mLocation.city;
    }
    if (!a)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GalleryReportedUtils", 2, "locationInfo is empty");
      }
      if ((Build.VERSION.SDK_INT >= 23) && (BaseApplicationImpl.getApplication().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {
        return "";
      }
      a = true;
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new GalleryReportedUtils.1(3, true, true, 300000L, false, false, "GalleryReportedUtils"));
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils
 * JD-Core Version:    0.7.0.1
 */