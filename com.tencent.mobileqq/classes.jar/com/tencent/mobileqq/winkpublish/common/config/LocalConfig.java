package com.tencent.mobileqq.winkpublish.common.config;

import FileUpload.MarkUinInfoBeforeUpload;
import NS_MOBILE_OPERATION.PicInfo;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.db.util.ParcelableWrapper;
import com.tencent.mobileqq.winkpublish.api.IUploadLocalConfig;
import com.tencent.mobileqq.winkpublish.common.AUploadCommonSetting;
import com.tencent.mobileqq.winkpublish.model.ShuoshuoContent;
import com.tencent.mobileqq.winkpublish.model.ShuoshuoVideoInfo;
import com.tencent.mobileqq.winkpublish.util.FSTransUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2.PoiInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LocalConfig
{
  public static final String a;
  public static final String b;
  public static String c = "sp_qqcirlce_business";
  public static String d = "qcircle_publish_share_qzone_status";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AUploadCommonSetting.a().getSpKey());
    localStringBuilder.append("_setting");
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AUploadCommonSetting.a().getSpKey());
    localStringBuilder.append("_onlinetime_report_setting");
    b = localStringBuilder.toString();
  }
  
  public static int a(String paramString, int paramInt)
  {
    return a(a, paramString, paramInt);
  }
  
  public static int a(String paramString, int paramInt, long paramLong)
  {
    return a(paramLong).getInt(paramString, paramInt);
  }
  
  public static int a(String paramString1, String paramString2, int paramInt)
  {
    return a(paramString1).getInt(paramString2, paramInt);
  }
  
  public static long a(String paramString, long paramLong)
  {
    return b(a, paramString, paramLong);
  }
  
  public static long a(String paramString, long paramLong1, long paramLong2)
  {
    return a(paramLong2).getLong(paramString, paramLong1);
  }
  
  public static SharedPreferences a()
  {
    String str = FSTransUtils.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    return RFApplication.getApplication().getSharedPreferences(str, 0);
  }
  
  public static SharedPreferences a(long paramLong)
  {
    Object localObject;
    if (paramLong == 0L)
    {
      localObject = a;
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append("preference");
      localObject = ((StringBuilder)localObject).toString();
    }
    return a((String)localObject);
  }
  
  @SuppressLint({"InlinedApi"})
  public static SharedPreferences a(String paramString)
  {
    return RFApplication.getApplication().getSharedPreferences(paramString, 0);
  }
  
  public static ShuoshuoContent a(long paramLong, String paramString)
  {
    ShuoshuoContent localShuoshuoContent = new ShuoshuoContent();
    localShuoshuoContent.d(g(paramString, paramLong));
    localShuoshuoContent.e(h(paramString, paramLong));
    localShuoshuoContent.a(j(paramString, paramLong));
    localShuoshuoContent.a(n(paramString, paramLong));
    localShuoshuoContent.a((HashMap)k(paramString, paramLong));
    localShuoshuoContent.b(l(paramString, paramLong));
    localShuoshuoContent.c(m(paramString, paramLong));
    String str = a(paramString, paramLong, "");
    if (!TextUtils.isEmpty(str)) {
      localShuoshuoContent.c(str);
    }
    str = i(paramString, paramLong);
    if (!TextUtils.isEmpty(str)) {
      localShuoshuoContent.b(str);
    }
    localShuoshuoContent.c(b(paramString, paramLong));
    localShuoshuoContent.a(o(paramString, paramLong));
    localShuoshuoContent.a(c(paramString, paramLong));
    localShuoshuoContent.b(e(paramString, paramLong));
    localShuoshuoContent.a(d(paramString, paramLong));
    return localShuoshuoContent;
  }
  
  public static String a(String paramString1, long paramLong, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_shootinf_lbs");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    return a(localStringBuilder.toString(), paramString2);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a(a, paramString1, paramString2);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1).getString(paramString2, paramString3);
  }
  
  public static void a(SharedPreferences.Editor paramEditor, String paramString, int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wink_draft_status_info_upload_status_key");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.putInt(localStringBuilder.toString(), paramInt);
  }
  
  public static void a(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mood_status");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void a(SharedPreferences.Editor paramEditor, String paramString, long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PhotoConst.KEY_CREATE_TIME");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong2);
    paramEditor.putLong(localStringBuilder.toString(), paramLong1);
  }
  
  private static void a(SharedPreferences.Editor paramEditor, String paramString, ShuoshuoVideoInfo paramShuoshuoVideoInfo, long paramLong)
  {
    if (paramShuoshuoVideoInfo == null)
    {
      u(paramEditor, paramString, paramLong);
      return;
    }
    Object localObject = Parcel.obtain();
    ((Parcel)localObject).setDataPosition(0);
    ParcelableWrapper.writeDataToParcel((Parcel)localObject, 0, paramShuoshuoVideoInfo);
    paramShuoshuoVideoInfo = ((Parcel)localObject).marshall();
    ((Parcel)localObject).recycle();
    paramShuoshuoVideoInfo = Base64.encodeToString(paramShuoshuoVideoInfo, 0);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_shuoshuo_selected_video");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramLong);
    paramEditor.putString(((StringBuilder)localObject).toString(), paramShuoshuoVideoInfo);
  }
  
  private static void a(SharedPreferences.Editor paramEditor, String paramString, Boolean paramBoolean, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_sync_qq");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.putBoolean(localStringBuilder.toString(), paramBoolean.booleanValue());
  }
  
  public static void a(SharedPreferences.Editor paramEditor, String paramString1, String paramString2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wink_draft_clientkey_key");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.putString(localStringBuilder.toString(), paramString2);
  }
  
  private static void a(SharedPreferences.Editor paramEditor, String paramString, HashMap<String, MarkUinInfoBeforeUpload> paramHashMap, long paramLong)
  {
    if (paramHashMap != null)
    {
      if (paramHashMap.size() == 0) {
        return;
      }
      Object localObject = new HashMap(paramHashMap);
      paramHashMap = Parcel.obtain();
      paramHashMap.setDataPosition(0);
      ParcelableWrapper.writeMap(paramHashMap, (Map)localObject);
      localObject = paramHashMap.marshall();
      paramHashMap.recycle();
      paramHashMap = Base64.encodeToString((byte[])localObject, 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key_shuoshuo_upload_map");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramLong);
      paramEditor.putString(((StringBuilder)localObject).toString(), paramHashMap);
    }
  }
  
  private static void a(SharedPreferences.Editor paramEditor, String paramString, List<String> paramList, long paramLong, HashMap<String, PicInfo> paramHashMap)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).startsWith("http://")) && (!((String)localObject).startsWith("https://")))
        {
          localStringBuilder1.append((String)localObject);
          localStringBuilder1.append("|");
        }
        else if ((!TextUtils.isEmpty((CharSequence)localObject)) && ((((String)localObject).startsWith("http://")) || (((String)localObject).startsWith("https://"))))
        {
          if ((paramHashMap != null) && (paramHashMap.get(localObject) != null))
          {
            paramList = (PicInfo)paramHashMap.get(localObject);
            if (paramList.sourceType == 2)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramList.sourceType);
              ((StringBuilder)localObject).append("<");
              ((StringBuilder)localObject).append(paramList.pic_url);
              ((StringBuilder)localObject).append("<");
              ((StringBuilder)localObject).append(paramList.imageId);
              ((StringBuilder)localObject).append("<");
              ((StringBuilder)localObject).append(paramList.picwidth);
              ((StringBuilder)localObject).append("<");
              ((StringBuilder)localObject).append(paramList.picheight);
              paramList = ((StringBuilder)localObject).toString();
            }
            else if (paramList.sourceType == 1)
            {
              StringBuilder localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append(paramList.sourceType);
              localStringBuilder2.append("<");
              localStringBuilder2.append((String)localObject);
              localStringBuilder2.append("<");
              localStringBuilder2.append(paramList.imageId);
              paramList = localStringBuilder2.toString();
            }
            else
            {
              paramList = "";
            }
            localStringBuilder1.append(paramList);
            localStringBuilder1.append("|");
          }
          else
          {
            localStringBuilder1.append((String)localObject);
            localStringBuilder1.append("|");
          }
        }
      }
      int i = localStringBuilder1.lastIndexOf("|");
      if (i != -1)
      {
        paramList = localStringBuilder1.substring(0, i);
        paramHashMap = new StringBuilder();
        paramHashMap.append("key_shuoshuo_selected_images");
        paramHashMap.append(paramString);
        paramHashMap.append("_");
        paramHashMap.append(paramLong);
        paramEditor.putString(paramHashMap.toString(), paramList);
      }
    }
    else
    {
      t(paramEditor, paramString, paramLong);
    }
  }
  
  private static void a(SharedPreferences.Editor paramEditor, String paramString, Map<String, PicInfo> paramMap, long paramLong)
  {
    if (paramMap != null)
    {
      if (paramMap.size() == 0) {
        return;
      }
      Object localObject = new HashMap(paramMap);
      paramMap = Parcel.obtain();
      paramMap.setDataPosition(0);
      ParcelableWrapper.writeMap(paramMap, (Map)localObject);
      localObject = paramMap.marshall();
      paramMap.recycle();
      paramMap = Base64.encodeToString((byte[])localObject, 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key_shuoshuo_selected_qzone_photo");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramLong);
      paramEditor.putString(((StringBuilder)localObject).toString(), paramMap);
    }
  }
  
  public static void a(ShuoshuoContent paramShuoshuoContent, long paramLong, String paramString)
  {
    SharedPreferences.Editor localEditor1 = b();
    SharedPreferences.Editor localEditor2 = b(paramLong);
    d(localEditor1, paramString, paramShuoshuoContent.p(), paramLong);
    b(localEditor1, paramString, paramShuoshuoContent.q(), paramLong);
    c(localEditor1, paramString, paramShuoshuoContent.r(), paramLong);
    a(localEditor1, paramString, paramShuoshuoContent.k(), paramLong, paramShuoshuoContent.g());
    a(localEditor1, paramString, Boolean.valueOf(paramShuoshuoContent.a()), paramLong);
    a(localEditor1, paramString, paramShuoshuoContent.n(), paramLong);
    a(localEditor1, paramString, paramShuoshuoContent.l(), paramLong);
    b(localEditor1, paramString, paramShuoshuoContent.m(), paramLong);
    c(localEditor1, paramString, paramShuoshuoContent.t(), paramLong);
    d(localEditor1, paramString, paramShuoshuoContent.u(), paramLong);
    Object localObject = paramShuoshuoContent.i();
    if (localObject != null) {
      d(localEditor1, paramString, (String)localObject, paramLong);
    }
    localObject = paramShuoshuoContent.h();
    if (localObject != null) {
      e(localEditor1, paramString, (String)localObject, paramLong);
    }
    localObject = paramShuoshuoContent.j();
    LbsDataV2.PoiInfo localPoiInfo = paramShuoshuoContent.f();
    if (localObject != null)
    {
      f(localEditor1, paramString, ((LbsDataV2.PoiInfo)localObject).poiId, paramLong);
      g(localEditor1, paramString, ((LbsDataV2.PoiInfo)localObject).dianPingId, paramLong);
    }
    else if (localPoiInfo != null)
    {
      f(localEditor1, paramString, localPoiInfo.poiId, paramLong);
      g(localEditor1, paramString, localPoiInfo.dianPingId, paramLong);
    }
    e(localEditor2, paramString, paramShuoshuoContent.s(), paramLong);
    localObject = paramShuoshuoContent.x();
    if (localObject != null) {
      b(localEditor1, paramString, (HashMap)localObject, paramLong);
    }
    localObject = paramShuoshuoContent.w();
    if (localObject != null) {
      a(localEditor1, paramString, (HashMap)localObject, paramLong);
    }
    localObject = paramShuoshuoContent.v();
    if (localObject != null) {
      c(localEditor1, paramString, (HashMap)localObject, paramLong);
    }
    c(localEditor1, paramString, paramShuoshuoContent.o(), paramLong);
    a(localEditor1, paramString, paramShuoshuoContent.e(), paramLong);
    a(localEditor1, paramString, paramShuoshuoContent.d(), paramLong);
    localEditor1.commit();
    localEditor2.commit();
  }
  
  public static void a(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = c(paramString1);
    paramString1.putLong(paramString2, paramLong);
    paramString1.commit();
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong)
  {
    SharedPreferences.Editor localEditor = b(paramLong);
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.commit();
  }
  
  public static void a(boolean paramBoolean)
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(d);
      localStringBuilder.append("_");
      localStringBuilder.append(FSTransUtils.a());
      ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), paramBoolean).apply();
    }
  }
  
  public static boolean a(String paramString, long paramLong, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_qcircle_kol_allow_long_video_switch");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    return b(localStringBuilder.toString(), paramBoolean, paramLong);
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    return a(paramString1).getBoolean(paramString2, paramBoolean);
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    return a(a, paramString, paramBoolean);
  }
  
  public static int b(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PhotoConst.KEY_SHOW_TYPE");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    return a(localStringBuilder.toString(), 0);
  }
  
  public static long b(String paramString, long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_qcircle_kol_max_video_limit");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong1);
    return a(localStringBuilder.toString(), paramLong2, paramLong1);
  }
  
  public static long b(String paramString1, String paramString2, long paramLong)
  {
    return a(paramString1).getLong(paramString2, paramLong);
  }
  
  private static SharedPreferences.Editor b()
  {
    return c(a);
  }
  
  private static SharedPreferences.Editor b(long paramLong)
  {
    return new LocalConfig.ConfigEditor(a(paramLong).edit());
  }
  
  public static void b(long paramLong, String paramString)
  {
    SharedPreferences.Editor localEditor1 = b();
    SharedPreferences.Editor localEditor2 = b(paramLong);
    i(localEditor1, paramString, paramLong);
    j(localEditor1, paramString, paramLong);
    k(localEditor1, paramString, paramLong);
    t(localEditor1, paramString, paramLong);
    h(localEditor2, paramString, paramLong);
    q(localEditor2, paramString, paramLong);
    u(localEditor1, paramString, paramLong);
    a(localEditor1, paramString, paramLong);
    r(localEditor2, paramString, paramLong);
    v(localEditor2, paramString, paramLong);
    w(localEditor2, paramString, paramLong);
    x(localEditor2, paramString, paramLong);
    p(localEditor1, paramString, paramLong);
    s(localEditor2, paramString, paramLong);
    l(localEditor1, paramString, paramLong);
    m(localEditor1, paramString, paramLong);
    n(localEditor1, paramString, paramLong);
    o(localEditor1, paramString, paramLong);
    g(localEditor1, paramString, paramLong);
    f(localEditor1, paramString, paramLong);
    b(localEditor1, paramString, paramLong);
    c(localEditor1, paramString, paramLong);
    d(localEditor1, paramString, paramLong);
    e(localEditor1, paramString, paramLong);
    localEditor1.commit();
    localEditor2.commit();
  }
  
  public static void b(SharedPreferences.Editor paramEditor, String paramString, int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wink_draft_toast_status_key");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.putInt(localStringBuilder.toString(), paramInt);
  }
  
  private static void b(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PhotoConst.KEY_SHOW_TYPE");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void b(SharedPreferences.Editor paramEditor, String paramString1, String paramString2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_title_draft");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.putString(localStringBuilder.toString(), paramString2);
  }
  
  private static void b(SharedPreferences.Editor paramEditor, String paramString, HashMap<String, Boolean> paramHashMap, long paramLong)
  {
    if (paramHashMap != null)
    {
      if (paramHashMap.size() == 0) {
        return;
      }
      Object localObject = new HashMap(paramHashMap);
      paramHashMap = Parcel.obtain();
      paramHashMap.setDataPosition(0);
      ParcelableWrapper.writeMap(paramHashMap, (Map)localObject);
      localObject = paramHashMap.marshall();
      paramHashMap.recycle();
      paramHashMap = Base64.encodeToString((byte[])localObject, 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key_shuoshuo_markhascheckfacesmap");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramLong);
      paramEditor.putString(((StringBuilder)localObject).toString(), paramHashMap);
    }
  }
  
  private static void b(SharedPreferences.Editor paramEditor, String paramString, Map<String, LocalMediaInfo> paramMap, long paramLong)
  {
    if (paramMap != null)
    {
      if (paramMap.size() == 0) {
        return;
      }
      Object localObject = new HashMap(paramMap);
      paramMap = Parcel.obtain();
      paramMap.setDataPosition(0);
      ParcelableWrapper.writeMap(paramMap, (Map)localObject);
      localObject = paramMap.marshall();
      paramMap.recycle();
      paramMap = Base64.encodeToString((byte[])localObject, 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key_shuoshuo_selected_media");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramLong);
      paramEditor.putString(((StringBuilder)localObject).toString(), paramMap);
    }
  }
  
  public static void b(String paramString)
  {
    SharedPreferences.Editor localEditor = b();
    localEditor.remove(paramString);
    localEditor.commit();
  }
  
  public static void b(String paramString, int paramInt, long paramLong)
  {
    SharedPreferences.Editor localEditor = b();
    a(localEditor, paramString, paramInt, paramLong);
    localEditor.commit();
  }
  
  public static boolean b(String paramString, boolean paramBoolean, long paramLong)
  {
    return a(paramLong).getBoolean(paramString, paramBoolean);
  }
  
  public static int c(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wink_draft_status_info_upload_status_key");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    return a(localStringBuilder.toString(), 0);
  }
  
  private static SharedPreferences.Editor c(String paramString)
  {
    return new LocalConfig.ConfigEditor(a(paramString).edit());
  }
  
  private static void c(SharedPreferences.Editor paramEditor, String paramString, int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PhotoConst.KEY_SHOW_TYPE");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.putInt(localStringBuilder.toString(), paramInt);
  }
  
  private static void c(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PhotoConst.KEY_CREATE_TIME");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void c(SharedPreferences.Editor paramEditor, String paramString1, String paramString2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_draft");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.putString(localStringBuilder.toString(), paramString2);
  }
  
  private static void c(SharedPreferences.Editor paramEditor, String paramString, HashMap<String, Boolean> paramHashMap, long paramLong)
  {
    if (paramHashMap != null)
    {
      if (paramHashMap.size() == 0) {
        return;
      }
      Object localObject = new HashMap(paramHashMap);
      paramHashMap = Parcel.obtain();
      paramHashMap.setDataPosition(0);
      ParcelableWrapper.writeMap(paramHashMap, (Map)localObject);
      localObject = paramHashMap.marshall();
      paramHashMap.recycle();
      paramHashMap = Base64.encodeToString((byte[])localObject, 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key_shuoshuo_markNeedShowFaceIconMap");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramLong);
      paramEditor.putString(((StringBuilder)localObject).toString(), paramHashMap);
    }
  }
  
  private static void c(SharedPreferences.Editor paramEditor, String paramString, Map<String, ShuoshuoVideoInfo> paramMap, long paramLong)
  {
    if (paramMap != null)
    {
      if (paramMap.size() == 0) {
        return;
      }
      Object localObject = new HashMap(paramMap);
      paramMap = Parcel.obtain();
      paramMap.setDataPosition(0);
      ParcelableWrapper.writeMap(paramMap, (Map)localObject);
      localObject = paramMap.marshall();
      paramMap.recycle();
      paramMap = Base64.encodeToString((byte[])localObject, 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key_shuoshuo_record_media");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramLong);
      paramEditor.putString(((StringBuilder)localObject).toString(), paramMap);
    }
  }
  
  public static void c(String paramString, int paramInt, long paramLong)
  {
    SharedPreferences.Editor localEditor = b();
    b(localEditor, paramString, paramInt, paramLong);
    localEditor.commit();
  }
  
  public static void c(String paramString1, String paramString2, long paramLong)
  {
    SharedPreferences.Editor localEditor = b(paramLong);
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  public static String d(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wink_draft_clientkey_key");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    return a(localStringBuilder.toString(), "");
  }
  
  public static String d(String paramString1, String paramString2, long paramLong)
  {
    return a(paramLong).getString(paramString1, paramString2);
  }
  
  private static void d(SharedPreferences.Editor paramEditor, String paramString, int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shuoshuo_sync_bits");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.putInt(localStringBuilder.toString(), paramInt);
  }
  
  private static void d(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wink_draft_status_info_upload_status_key");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void d(SharedPreferences.Editor paramEditor, String paramString1, String paramString2, long paramLong)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_shootinf_lbs");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.putString(localStringBuilder.toString(), paramString2);
  }
  
  private static void d(SharedPreferences.Editor paramEditor, String paramString, Map<String, ShuoshuoVideoInfo> paramMap, long paramLong)
  {
    if (paramMap != null)
    {
      if (paramMap.size() == 0) {
        return;
      }
      Object localObject = new HashMap(paramMap);
      paramMap = Parcel.obtain();
      paramMap.setDataPosition(0);
      ParcelableWrapper.writeMap(paramMap, (Map)localObject);
      localObject = paramMap.marshall();
      paramMap.recycle();
      paramMap = Base64.encodeToString((byte[])localObject, 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key_shuoshuo_select_list_media");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramLong);
      paramEditor.putString(((StringBuilder)localObject).toString(), paramMap);
    }
  }
  
  public static int e(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wink_draft_toast_status_key");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    return a(localStringBuilder.toString(), 0);
  }
  
  private static void e(SharedPreferences.Editor paramEditor, String paramString, int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shuoshuo_uistate");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.putInt(localStringBuilder.toString(), paramInt);
  }
  
  private static void e(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wink_draft_toast_status_key");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void e(SharedPreferences.Editor paramEditor, String paramString1, String paramString2, long paramLong)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_shootinfo_time_and_weather");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.putString(localStringBuilder.toString(), paramString2);
  }
  
  public static int f(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shuoshuo_sync_bits");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    return a(localStringBuilder.toString(), 0);
  }
  
  private static void f(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_markhascheckfacesmap");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void f(SharedPreferences.Editor paramEditor, String paramString1, String paramString2, long paramLong)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_shootinfo_poi_id");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.putString(localStringBuilder.toString(), paramString2);
  }
  
  public static String g(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_title_draft");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    return a(localStringBuilder.toString(), "");
  }
  
  private static void g(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_upload_map");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void g(SharedPreferences.Editor paramEditor, String paramString1, String paramString2, long paramLong)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_shootinfo_dianping_id");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.putString(localStringBuilder.toString(), paramString2);
  }
  
  public static String h(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_draft");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    return a(localStringBuilder.toString(), "");
  }
  
  private static void h(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_at_friends_size");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    int i = 0;
    int j = a((String)localObject, 0, paramLong);
    if (j > 0) {
      while (i < j)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("key_at_friends_uin");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(i);
        paramEditor.remove(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("key_at_friends_name");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(i);
        paramEditor.remove(((StringBuilder)localObject).toString());
        i += 1;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_at_friends_size");
    ((StringBuilder)localObject).append(paramString);
    paramEditor.remove(((StringBuilder)localObject).toString());
  }
  
  public static String i(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_shootinfo_time_and_weather");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    return a(localStringBuilder.toString(), "");
  }
  
  private static void i(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shuoshuo_sync_bits");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  public static List<String> j(String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_shuoshuo_selected_images");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramLong);
    localObject = a(((StringBuilder)localObject).toString(), "");
    paramString = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          paramString.add(localObject[i]);
          i += 1;
        }
      }
    }
    return paramString;
  }
  
  private static void j(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_title_draft");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  public static Map<String, LocalMediaInfo> k(String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_shuoshuo_selected_media");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramLong);
    paramString = a(((StringBuilder)localObject).toString(), "");
    boolean bool = TextUtils.isEmpty(paramString);
    localObject = null;
    if (bool) {
      return null;
    }
    byte[] arrayOfByte = Base64.decode(paramString, 0);
    paramString = (String)localObject;
    try
    {
      Parcel localParcel = Parcel.obtain();
      paramString = (String)localObject;
      localParcel.unmarshall(arrayOfByte, 0, arrayOfByte.length);
      paramString = (String)localObject;
      localParcel.setDataPosition(0);
      paramString = (String)localObject;
      localObject = ParcelableWrapper.readHashMap(localParcel, ParcelableWrapper.class.getClassLoader());
      paramString = (String)localObject;
      localParcel.recycle();
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.w("LocalConfig", 1, localException.getMessage());
    }
    return paramString;
  }
  
  private static void k(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_draft");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  public static HashMap<String, ShuoshuoVideoInfo> l(String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_shuoshuo_record_media");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramLong);
    paramString = a(((StringBuilder)localObject).toString(), "");
    boolean bool = TextUtils.isEmpty(paramString);
    localObject = null;
    if (bool) {
      return null;
    }
    byte[] arrayOfByte = Base64.decode(paramString, 0);
    paramString = (String)localObject;
    try
    {
      Parcel localParcel = Parcel.obtain();
      paramString = (String)localObject;
      localParcel.unmarshall(arrayOfByte, 0, arrayOfByte.length);
      paramString = (String)localObject;
      localParcel.setDataPosition(0);
      paramString = (String)localObject;
      localObject = ParcelableWrapper.readHashMap(localParcel, ParcelableWrapper.class.getClassLoader());
      paramString = (String)localObject;
      localParcel.recycle();
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.w("LocalConfig", 1, localException.getMessage());
    }
    return paramString;
  }
  
  private static void l(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_shootinf_lbs");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  public static HashMap<String, ShuoshuoVideoInfo> m(String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_shuoshuo_select_list_media");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramLong);
    paramString = a(((StringBuilder)localObject).toString(), "");
    boolean bool = TextUtils.isEmpty(paramString);
    localObject = null;
    if (bool) {
      return null;
    }
    byte[] arrayOfByte = Base64.decode(paramString, 0);
    paramString = (String)localObject;
    try
    {
      Parcel localParcel = Parcel.obtain();
      paramString = (String)localObject;
      localParcel.unmarshall(arrayOfByte, 0, arrayOfByte.length);
      paramString = (String)localObject;
      localParcel.setDataPosition(0);
      paramString = (String)localObject;
      localObject = ParcelableWrapper.readHashMap(localParcel, ParcelableWrapper.class.getClassLoader());
      paramString = (String)localObject;
      localParcel.recycle();
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.w("LocalConfig", 1, localException.getMessage());
    }
    return paramString;
  }
  
  private static void m(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_shootinfo_time_and_weather");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  public static ShuoshuoVideoInfo n(String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_shuoshuo_selected_video");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramLong);
    paramString = a(((StringBuilder)localObject).toString(), "");
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = Base64.decode(paramString, 0);
    try
    {
      localObject = Parcel.obtain();
      ((Parcel)localObject).unmarshall(paramString, 0, paramString.length);
      ((Parcel)localObject).setDataPosition(0);
      paramString = (ShuoshuoVideoInfo)ParcelableWrapper.createDataFromParcel((Parcel)localObject);
      try
      {
        ((Parcel)localObject).recycle();
        return paramString;
      }
      catch (Exception localException1) {}
      QLog.w("LocalConfig", 1, localException2.getMessage());
    }
    catch (Exception localException2)
    {
      paramString = null;
    }
    return paramString;
  }
  
  private static void n(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_shootinfo_poi_id");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static long o(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PhotoConst.KEY_CREATE_TIME");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    return a(localStringBuilder.toString(), 0L);
  }
  
  private static void o(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_shootinfo_dianping_id");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void p(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_right");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void q(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shuoshuo_uistate");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void r(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shuoshuo_event_tag_title");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("shuoshuo_event_tag_desc");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("shuoshuo_event_tag_desc_truncate_num");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("shuoshuo_event_tag_protocol");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void s(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_shuoshuo_right_uin_list_size");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    int i = 0;
    int j = a((String)localObject, 0, paramLong);
    if (j > 0) {
      while (i < j)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("key_shuoshuo_right_uin_list");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(i);
        paramEditor.remove(((StringBuilder)localObject).toString());
        i += 1;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_shuoshuo_right_uin_list_size");
    ((StringBuilder)localObject).append(paramString);
    paramEditor.remove(((StringBuilder)localObject).toString());
  }
  
  private static void t(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_shuoshuo_selected_images");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramEditor.remove(localStringBuilder.toString());
  }
  
  private static void u(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    paramEditor = new StringBuilder();
    paramEditor.append("key_shuoshuo_selected_video");
    paramEditor.append(paramString);
    paramEditor.append("_");
    paramEditor.append(paramLong);
    b(paramEditor.toString());
  }
  
  private static void v(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    paramEditor = new StringBuilder();
    paramEditor.append("key_shuoshuo_record_media");
    paramEditor.append(paramString);
    paramEditor.append("_");
    paramEditor.append(paramLong);
    b(paramEditor.toString());
  }
  
  private static void w(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    paramEditor = new StringBuilder();
    paramEditor.append("key_shuoshuo_select_list_media");
    paramEditor.append(paramString);
    paramEditor.append("_");
    paramEditor.append(paramLong);
    b(paramEditor.toString());
  }
  
  private static void x(SharedPreferences.Editor paramEditor, String paramString, long paramLong)
  {
    paramEditor = new StringBuilder();
    paramEditor.append("key_shuoshuo_selected_media");
    paramEditor.append(paramString);
    paramEditor.append("_");
    paramEditor.append(paramLong);
    b(paramEditor.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.common.config.LocalConfig
 * JD-Core Version:    0.7.0.1
 */