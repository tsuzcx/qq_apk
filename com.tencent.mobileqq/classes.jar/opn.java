import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGalleryBiu;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.gallery.gallery_report.GalleryExpReported;
import tencent.im.oidb.gallery.gallery_report.GallerySocialReported;

public class opn
{
  private static boolean a;
  
  public static int a(int paramInt)
  {
    if ((paramInt == 48) || (paramInt == 51)) {
      return 1;
    }
    if ((paramInt == 49) || (paramInt == 52)) {
      return 2;
    }
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
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (paramInt1 == 0) {
      if ((paramInt2 == 48) || (paramInt2 == 49) || (paramInt2 == 50) || (paramInt2 == 78)) {
        paramInt2 = 1;
      }
    }
    do
    {
      return paramInt2;
      return 4;
      if (paramInt1 == 70)
      {
        if ((paramInt2 == 48) || (paramInt2 == 49) || (paramInt2 == 50) || (paramInt2 == 78)) {
          return 5;
        }
        return 6;
      }
      paramInt2 = i;
    } while (!ors.a(paramInt1));
    return 3;
  }
  
  public static String a()
  {
    return (int)Math.ceil(Float.valueOf((float)bdcb.d()).floatValue() / 1024.0F / 1024.0F / 1024.0F) + "";
  }
  
  public static String a(Context paramContext)
  {
    paramContext = bdcb.a(paramContext).a;
    if (!TextUtils.isEmpty(paramContext))
    {
      if (paramContext.equals("WIFI")) {
        return "1";
      }
      if ((paramContext.equals("4G")) || (paramContext.equals("3G"))) {
        return "2";
      }
      return "0";
    }
    return "0";
  }
  
  public static String a(Context paramContext, long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4)
  {
    return a(paramContext, paramLong1, paramInt1, paramLong2, paramLong3, paramInt2, paramString1, paramString2, paramInt3, paramInt4, null);
  }
  
  public static String a(Context paramContext, long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, String paramString3)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", a(paramContext));
      localJSONObject.put("version", ntd.a);
      localJSONObject.put("os", "1");
      localJSONObject.put("uin", paramLong1 + "");
      localJSONObject.put("source", paramInt1 + "");
      localJSONObject.put("mem_size", a());
      localJSONObject.put("article_id", paramLong2 + "");
      localJSONObject.put("city", b());
      localJSONObject.put("exptime", paramLong3 + "");
      localJSONObject.put("pos", paramInt2 + "");
      localJSONObject.put("rowkey", paramString1);
      localJSONObject.put("proxy_bytes", paramString2);
      localJSONObject.put("card_type", paramInt3 + "");
      localJSONObject.put("imei", ors.f());
      localJSONObject.put("imsi", ors.g());
      localJSONObject.put("channel_id", paramInt4);
      if (!TextUtils.isEmpty(paramString3)) {
        localJSONObject.put("source_rowkey", paramString3);
      }
      paramContext = localJSONObject.toString();
    }
    catch (Exception paramString1)
    {
      do
      {
        paramContext = str;
      } while (!QLog.isColorLevel());
      QLog.d("GalleryReportedUtils", 2, "galleryExpReport:" + paramString1.toString());
    }
    return paramContext;
    return "";
  }
  
  public static String a(Context paramContext, long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", a(paramContext));
      localJSONObject.put("version", ntd.a);
      localJSONObject.put("os", "1");
      localJSONObject.put("uin", paramLong + "");
      localJSONObject.put("source", paramInt1 + "");
      localJSONObject.put("city", b() + "");
      localJSONObject.put("rowkey", paramString2);
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.put("topic_id", paramString1);
      }
      localJSONObject.put("pattern", paramInt2);
      paramContext = localJSONObject.toString();
    }
    catch (Exception paramString1)
    {
      do
      {
        paramContext = str;
      } while (!QLog.isColorLevel());
      QLog.d("GalleryReportedUtils", 2, "operationReport:" + paramString1.toString());
    }
    return paramContext;
    return "";
  }
  
  public static String a(Context paramContext, String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4, int paramInt5, JSONObject paramJSONObject)
  {
    return a(paramContext, paramString1, paramInt1, paramLong, paramInt2, paramString2, paramString3, paramInt3, paramInt4, paramInt5, paramJSONObject, null);
  }
  
  public static String a(Context paramContext, String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4, int paramInt5, JSONObject paramJSONObject, String paramString4)
  {
    String str = "";
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {}
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("network", a(paramContext));
      localJSONObject.put("version", ntd.a + "");
      localJSONObject.put("os", "1");
      localJSONObject.put("uin", paramString1);
      localJSONObject.put("source", paramInt1 + "");
      localJSONObject.put("mem_size", a());
      localJSONObject.put("article_id", paramLong + "");
      localJSONObject.put("city", b());
      localJSONObject.put("exptime", System.currentTimeMillis() + "");
      localJSONObject.put("pos", paramInt2 + "");
      localJSONObject.put("rowkey", paramString2);
      localJSONObject.put("proxy_bytes", paramString3);
      localJSONObject.put("card_type", paramInt3);
      localJSONObject.put("pic_click", paramInt4 + "");
      localJSONObject.put("imei", ors.f());
      localJSONObject.put("imsi", ors.g());
      localJSONObject.put("channel_id", paramInt5);
      if (!TextUtils.isEmpty(paramString4)) {
        localJSONObject.put("source_rowkey", paramString4);
      }
      paramContext = localJSONObject.toString();
    }
    catch (Exception paramString1)
    {
      do
      {
        paramContext = str;
      } while (!QLog.isColorLevel());
      QLog.d("GalleryReportedUtils", 2, "galleryClickReport:" + paramString1.toString());
    }
    return paramContext;
    return "";
  }
  
  public static String a(Context paramContext, String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    return a(paramContext, paramString1, paramInt1, paramLong, paramString2, paramInt2, paramInt3, paramBoolean, null);
  }
  
  public static String a(Context paramContext, String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean, Boolean paramBoolean1)
  {
    return a(paramContext, paramString1, paramInt1, paramLong, paramString2, paramInt2, paramInt3, paramBoolean, paramBoolean1).toString();
  }
  
  public static JSONObject a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, ArticleInfo paramArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("network", a(paramContext));
      localJSONObject.put("version", ntd.a + "");
      localJSONObject.put("os", "1");
      localJSONObject.put("uin", ors.a() + "");
      localJSONObject.put("source", String.valueOf(paramInt2));
      localJSONObject.put("mem_size", a());
      localJSONObject.put("article_id", paramArticleInfo.mArticleID);
      localJSONObject.put("city", b());
      localJSONObject.put("pos", String.valueOf(paramInt3));
      localJSONObject.put("rowkey", szp.a(paramArticleInfo));
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
    int i = 1;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("network", a(paramContext));
      localJSONObject.put("os", "1");
      localJSONObject.put("source", paramInt1 + "");
      localJSONObject.put("uin", paramString1);
      localJSONObject.put("rowkey", paramString2);
      localJSONObject.put("version", ntd.a);
      if (paramBoolean) {
        localJSONObject.put("cancel", String.valueOf(1));
      }
      if (paramInt2 >= 0) {
        localJSONObject.put("sourcefrom", paramInt2 + "");
      }
      if (paramInt3 >= 0) {
        localJSONObject.put("share_unit", paramInt3 + "");
      }
      if (paramBoolean1 != null)
      {
        paramInt1 = i;
        if (paramBoolean1.booleanValue()) {
          paramInt1 = 0;
        }
        localJSONObject.put("result", paramInt1);
      }
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("GalleryReportedUtils", 2, "shareReport:" + paramContext.toString());
    }
    return localJSONObject;
    return localJSONObject;
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mIsGallery = true;
    localReportInfo.mUin = paramLong;
    localReportInfo.mAlgorithmId = paramInt2;
    localReportInfo.mOperation = paramInt1;
    gallery_report.GallerySocialReported localGallerySocialReported = new gallery_report.GallerySocialReported();
    localGallerySocialReported.action.set(paramInt3);
    localGallerySocialReported.phone_type.set(1);
    localGallerySocialReported.client_ver.set(ByteStringMicro.copyFromUtf8("8.3.3"));
    localGallerySocialReported.source.set(paramInt4);
    if (!TextUtils.isEmpty(b())) {
      localGallerySocialReported.city.set(ByteStringMicro.copyFromUtf8(b()));
    }
    localGallerySocialReported.pos.set(paramInt5);
    localGallerySocialReported.is_read_end.set(paramInt6);
    if (!TextUtils.isEmpty(paramString1)) {
      localGallerySocialReported.rowkey.set(ByteStringMicro.copyFromUtf8(paramString1));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localGallerySocialReported.proxy_bytes.set(ByteStringMicro.copyFromUtf8(paramString2));
    }
    localReportInfo.mGalleryReportInfo = localGallerySocialReported.toByteArray();
    localArrayList.add(localReportInfo);
    owy.a().a(localArrayList);
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
    if (!TextUtils.isEmpty("8.3.3")) {
      localGalleryExpReported.client_ver.set(ByteStringMicro.copyFromUtf8("8.3.3"));
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
    owy.a().a(localArrayList);
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, String paramString, JSONObject paramJSONObject)
  {
    int i = ors.a(paramArticleInfo);
    i = a((int)paramArticleInfo.mChannelID, i);
    if (paramJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        paramJSONObject.put("pics", paramArticleInfo.mGalleryPicNumber);
        paramContext = a(paramContext, ors.a() + "", i, paramArticleInfo.mArticleID, 0, paramArticleInfo.innerUniqueID, paramArticleInfo.galleryReprotExdData, a(ors.a(paramArticleInfo)), 0, (int)paramArticleInfo.mChannelID, paramJSONObject);
        nrt.a(null, "" + paramArticleInfo.publishUin, paramString, paramString, 0, 0, "", paramArticleInfo.mArticleID + "", paramArticleInfo.mAlgorithmID + "", paramContext, false);
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, rqj paramrqj)
  {
    if ((ors.d(paramArticleInfo)) || (ors.d(paramArticleInfo)) || (ors.b(paramArticleInfo)))
    {
      paramContext = a(paramContext, ors.a() + "", ComponentContentGalleryBiu.a(paramArticleInfo, paramrqj), paramArticleInfo.mArticleID, paramrqj.a().indexOf(paramArticleInfo), paramArticleInfo.innerUniqueID, paramArticleInfo.galleryReprotExdData, a(ors.a(paramArticleInfo)), 0, (int)paramArticleInfo.mChannelID, null);
      nrt.a(null, "" + paramArticleInfo.publishUin, "0X8008E2F", "0X8008E2F", 0, 0, "", paramArticleInfo.mArticleID + "", paramArticleInfo.mAlgorithmID + "", paramContext, false);
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("network", a(paramContext));
      localJSONObject.put("version", ntd.a + "");
      localJSONObject.put("os", "1");
      localJSONObject.put("uin", ors.a() + "");
      localJSONObject.put("mem_size", a());
      localJSONObject.put("city", b());
      localJSONObject.put("channel_id", String.valueOf(paramInt1));
      localJSONObject.put("sub_channel_id", paramInt2);
      nrt.a(null, "", paramString, paramString, 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static void a(opp paramopp)
  {
    nrt.a(null, paramopp.a, paramopp.b, paramopp.c, 0, 0, "", paramopp.e, paramopp.f, paramopp.g, false);
  }
  
  public static String b()
  {
    SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.b();
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.a != null) && (!TextUtils.isEmpty(localSosoLbsInfo.a.e))) {
      return localSosoLbsInfo.a.e;
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
      SosoInterface.a(new opo(3, true, true, 300000L, false, false, "GalleryReportedUtils"));
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     opn
 * JD-Core Version:    0.7.0.1
 */