package com.tencent.mobileqq.kandian.biz.ad.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.AdInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.NegFeedback;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PosAdInfo;

public class VideoAdInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VideoAdInfo> CREATOR = new VideoAdInfo.1();
  public String A = null;
  public String B = null;
  public int C = 0;
  public ArrayList<String> D = new ArrayList();
  public ArrayList<String> E = new ArrayList();
  public ArrayList<String> F = new ArrayList();
  public long G = 0L;
  public int H = 0;
  public int I = 0;
  public int J = 0;
  public int K = 0;
  public String L = null;
  public int M = 0;
  public String N = null;
  public int O = 0;
  public ArrayList<VideoAdInfo.NegFeedback> P = new ArrayList();
  public long Q = 0L;
  public String R = null;
  public int S = 0;
  public String T = null;
  public int U = 1;
  public boolean V = false;
  public String W = null;
  public String X = null;
  public String Y = null;
  public long Z = 0L;
  public long a = 0L;
  @notColumn
  public int aA;
  public int aa = 0;
  public String ab = null;
  public long ac = 0L;
  public String ad = null;
  public int ae;
  @notColumn
  public int af = 0;
  @notColumn
  public ArrayList<String> ag = null;
  @notColumn
  public ArrayList<String> ah = null;
  public String ai;
  public boolean aj = true;
  @notColumn
  public int ak;
  @notColumn
  public boolean al;
  @notColumn
  public String am = "";
  @notColumn
  public boolean an = false;
  @notColumn
  public String ao = "";
  @notColumn
  public String ap = "";
  @notColumn
  public String aq = "";
  @notColumn
  public String ar = "";
  @notColumn
  public ArrayList<String> as = new ArrayList();
  @notColumn
  public int at = 1;
  @notColumn
  public String au;
  @notColumn
  public String av;
  @notColumn
  public int aw = 3;
  @notColumn
  public int ax = 0;
  @notColumn
  public String ay;
  @notColumn
  public double az;
  public int b = 0;
  public long c = 0L;
  public long d = 0L;
  public int e = 0;
  public String f = null;
  public String g = null;
  public String h = null;
  public String i = null;
  public String j = null;
  public String k = null;
  public String l = null;
  public String m = null;
  public String n = null;
  public int o = 0;
  public int p = 0;
  public ArrayList<VideoAdInfo> q = null;
  public String r = null;
  public String s = null;
  public String t = null;
  public String u = null;
  public String v = null;
  public String w = null;
  public String x = null;
  public String y = null;
  public long z = 0L;
  
  public VideoAdInfo() {}
  
  public VideoAdInfo(long paramLong, oidb_0x6cf.PosAdInfo paramPosAdInfo)
  {
    if ((paramPosAdInfo != null) && (paramPosAdInfo.int32_ret.get() == 0) && (paramPosAdInfo.msg_ad_info.has()))
    {
      if (paramPosAdInfo.msg_ad_info.get() == null) {
        return;
      }
      this.a = paramLong;
      this.b = paramPosAdInfo.enum_pos_layout.get();
      this.c = paramPosAdInfo.uint64_pos_id.get();
      paramPosAdInfo = (oidb_0x6cf.AdInfo)paramPosAdInfo.msg_ad_info.get();
      this.d = paramPosAdInfo.uint64_channel_id.get();
      this.e = paramPosAdInfo.int32_kd_pos.get();
      this.f = paramPosAdInfo.bytes_cl.get().toStringUtf8();
      this.g = paramPosAdInfo.bytes_img.get().toStringUtf8();
      this.h = paramPosAdInfo.bytes_img_s.get().toStringUtf8();
      this.i = paramPosAdInfo.bytes_txt.get().toStringUtf8();
      this.j = paramPosAdInfo.bytes_desc.get().toStringUtf8();
      this.k = paramPosAdInfo.bytes_rl.get().toStringUtf8();
      this.l = paramPosAdInfo.bytes_apurl.get().toStringUtf8();
      this.m = paramPosAdInfo.bytes_trace_id.get().toStringUtf8();
      this.n = paramPosAdInfo.bytes_product_id.get().toStringUtf8();
      this.o = paramPosAdInfo.int32_product_type.get();
      this.p = paramPosAdInfo.uint32_ad_type.get();
      this.r = paramPosAdInfo.bytes_landing_page.get().toStringUtf8();
      this.s = paramPosAdInfo.bytes_price.get().toStringUtf8();
      this.t = paramPosAdInfo.bytes_button_txt.get().toStringUtf8();
      this.u = paramPosAdInfo.bytes_view_id.get().toStringUtf8();
      this.v = paramPosAdInfo.bytes_customized_invoke_url.get().toStringUtf8();
      this.w = paramPosAdInfo.bytes_corporation_name.get().toStringUtf8();
      this.x = paramPosAdInfo.bytes_corporate_image_name.get().toStringUtf8();
      this.y = paramPosAdInfo.bytes_corporate_logo.get().toStringUtf8();
      this.z = paramPosAdInfo.uint64_ad_uin.get();
      this.A = paramPosAdInfo.bytes_ext.get().toStringUtf8();
      if (TextUtils.isEmpty(this.A)) {
        this.A = new JSONObject().toString();
      }
      try
      {
        this.ae = new JSONObject(paramPosAdInfo.bytes_extra_data.get().toStringUtf8()).optInt("AdSource");
      }
      catch (Throwable localThrowable)
      {
        QLog.e("VideoAdInfo", 4, localThrowable, new Object[0]);
      }
      this.B = paramPosAdInfo.bytes_video_url.get().toStringUtf8();
      this.C = paramPosAdInfo.uint32_cost_type.get();
      Iterator localIterator;
      ByteStringMicro localByteStringMicro;
      if ((paramPosAdInfo.bytes_title_list.has()) && (paramPosAdInfo.bytes_title_list.get() != null))
      {
        localIterator = paramPosAdInfo.bytes_title_list.get().iterator();
        while (localIterator.hasNext())
        {
          localByteStringMicro = (ByteStringMicro)localIterator.next();
          this.D.add(localByteStringMicro.toStringUtf8());
        }
      }
      if ((paramPosAdInfo.bytes_image_list.has()) && (paramPosAdInfo.bytes_image_list.get() != null))
      {
        localIterator = paramPosAdInfo.bytes_image_list.get().iterator();
        while (localIterator.hasNext())
        {
          localByteStringMicro = (ByteStringMicro)localIterator.next();
          this.E.add(localByteStringMicro.toStringUtf8());
        }
      }
      if ((paramPosAdInfo.bytes_url_list.has()) && (paramPosAdInfo.bytes_url_list.get() != null))
      {
        localIterator = paramPosAdInfo.bytes_url_list.get().iterator();
        while (localIterator.hasNext())
        {
          localByteStringMicro = (ByteStringMicro)localIterator.next();
          this.F.add(localByteStringMicro.toStringUtf8());
        }
      }
      this.G = paramPosAdInfo.uint64_aid.get();
      this.H = paramPosAdInfo.enum_ad_layout.get();
      this.I = paramPosAdInfo.uint32_ad_material_id.get();
      this.J = paramPosAdInfo.uint32_ad_material_width.get();
      this.K = paramPosAdInfo.uint32_ad_material_height.get();
      this.L = paramPosAdInfo.bytes_via.get().toStringUtf8();
      this.M = paramPosAdInfo.uint32_dis_channel.get();
      this.N = paramPosAdInfo.bytes_button_url.get().toStringUtf8();
      this.O = paramPosAdInfo.uint32_duration.get();
      this.R = paramPosAdInfo.bytes_extra_data.get().toStringUtf8();
      this.S = paramPosAdInfo.enum_ad_jump_mode.get();
      this.W = paramPosAdInfo.bytes_app_download_schema.get().toStringUtf8();
      this.X = paramPosAdInfo.string_canvas_json.get();
      this.Y = paramPosAdInfo.bytes_landing_page_report_url.get().toStringUtf8();
      this.Z = paramPosAdInfo.uint64_advertiser_id.get();
      this.aa = paramPosAdInfo.uint32_dest_type.get();
      this.ab = paramPosAdInfo.string_effect_url.get();
      this.ac = paramPosAdInfo.int64_noco_id.get();
      this.ad = paramPosAdInfo.bytes_download_api_url.get().toStringUtf8();
      a(this.R);
      d(this.R);
      b(this.R);
      c(this.R);
    }
  }
  
  protected VideoAdInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readLong();
    this.d = paramParcel.readLong();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.n = paramParcel.readString();
    this.o = paramParcel.readInt();
    this.p = paramParcel.readInt();
    this.q = paramParcel.readArrayList(VideoAdInfo.class.getClassLoader());
    this.r = paramParcel.readString();
    this.s = paramParcel.readString();
    this.t = paramParcel.readString();
    this.u = paramParcel.readString();
    this.v = paramParcel.readString();
    this.w = paramParcel.readString();
    this.x = paramParcel.readString();
    this.y = paramParcel.readString();
    this.z = paramParcel.readLong();
    this.A = paramParcel.readString();
    this.B = paramParcel.readString();
    this.C = paramParcel.readInt();
    paramParcel.readStringList(this.D);
    paramParcel.readStringList(this.E);
    paramParcel.readStringList(this.F);
    this.G = paramParcel.readLong();
    this.H = paramParcel.readInt();
    this.I = paramParcel.readInt();
    this.J = paramParcel.readInt();
    this.K = paramParcel.readInt();
    this.L = paramParcel.readString();
    this.M = paramParcel.readInt();
    this.N = paramParcel.readString();
    this.O = paramParcel.readInt();
    this.P = paramParcel.readArrayList(VideoAdInfo.NegFeedback.class.getClassLoader());
    this.Q = paramParcel.readLong();
    this.R = paramParcel.readString();
    this.S = paramParcel.readInt();
    this.W = paramParcel.readString();
    this.X = paramParcel.readString();
    this.Y = paramParcel.readString();
    this.Z = paramParcel.readLong();
    this.aa = paramParcel.readInt();
    this.ab = paramParcel.readString();
    this.ac = paramParcel.readLong();
    this.ad = paramParcel.readString();
    this.U = paramParcel.readInt();
  }
  
  public static void a(VideoAdInfo paramVideoAdInfo)
  {
    if (paramVideoAdInfo != null)
    {
      if (TextUtils.isEmpty(paramVideoAdInfo.R)) {
        return;
      }
      try
      {
        localObject1 = new JSONObject(paramVideoAdInfo.R);
        if (((JSONObject)localObject1).has("c2s_switch")) {
          paramVideoAdInfo.af = ((JSONObject)localObject1).optInt("c2s_switch");
        }
        boolean bool2 = ((JSONObject)localObject1).has("c2s_click_url");
        boolean bool1 = false;
        Object localObject2;
        int i2;
        Object localObject3;
        int i1;
        String str;
        StringBuilder localStringBuilder;
        if (bool2)
        {
          localObject2 = ((JSONObject)localObject1).optJSONArray("c2s_click_url");
          if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
          {
            i2 = ((JSONArray)localObject2).length();
            localObject3 = new ArrayList();
            i1 = 0;
            while (i1 < i2)
            {
              str = (String)((JSONArray)localObject2).opt(i1);
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(" setVideoAdInfoC2SInfo clickUrl = ");
                localStringBuilder.append(str);
                QLog.d("setVideoAdInfoC2SInfo", 2, localStringBuilder.toString());
              }
              ((ArrayList)localObject3).add(str);
              i1 += 1;
            }
            paramVideoAdInfo.ag = ((ArrayList)localObject3);
          }
        }
        if (((JSONObject)localObject1).has("c2s_exposure_url"))
        {
          localObject2 = ((JSONObject)localObject1).optJSONArray("c2s_exposure_url");
          if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
          {
            i2 = ((JSONArray)localObject2).length();
            localObject3 = new ArrayList();
            i1 = 0;
            while (i1 < i2)
            {
              str = (String)((JSONArray)localObject2).opt(i1);
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(" setVideoAdInfoC2SInfo exposureUrl = ");
                localStringBuilder.append(str);
                QLog.d("setVideoAdInfoC2SInfo", 2, localStringBuilder.toString());
              }
              ((ArrayList)localObject3).add(str);
              i1 += 1;
            }
            paramVideoAdInfo.ah = ((ArrayList)localObject3);
          }
        }
        bool2 = ((JSONObject)localObject1).has("pop_sheet");
        if (bool2)
        {
          localObject2 = new JSONObject(((JSONObject)localObject1).optString("pop_sheet")).getString("h5Url");
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("h5Url = ");
            ((StringBuilder)localObject3).append((String)localObject2);
            QLog.d("processAdExtraDataInfo", 2, ((StringBuilder)localObject3).toString());
          }
          paramVideoAdInfo.ai = ((String)localObject2);
        }
        if (((JSONObject)localObject1).has("button_flag"))
        {
          localObject1 = ((JSONObject)localObject1).optString("button_flag", "1");
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("buttonFlag = ");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("processAdExtraDataInfo", 2, ((StringBuilder)localObject2).toString());
          }
          if (!((String)localObject1).equals("0")) {
            bool1 = true;
          }
          paramVideoAdInfo.aj = bool1;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(" setVideoAdInfoC2SInfo mCorporateImageName = ");
          ((StringBuilder)localObject1).append(paramVideoAdInfo.x);
          ((StringBuilder)localObject1).append(" mTraceID = ");
          ((StringBuilder)localObject1).append(paramVideoAdInfo.m);
          ((StringBuilder)localObject1).append(" c2s_switch = ");
          ((StringBuilder)localObject1).append(paramVideoAdInfo.af);
          QLog.d("setVideoAdInfoC2SInfo", 2, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      catch (Exception paramVideoAdInfo)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setVideoAdInfoC2SInfo exception ");
        ((StringBuilder)localObject1).append(paramVideoAdInfo.toString());
        QLog.e("setVideoAdInfoC2SInfo", 1, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  private void d(String paramString)
  {
    if (paramString != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      try
      {
        paramString = new JSONObject(paramString);
        this.az = paramString.optDouble("ecpm");
        this.aA = paramString.optInt("isContract");
        return;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("c2s_switch")) {
          this.af = paramString.optInt("c2s_switch");
        }
        int i2;
        Object localObject2;
        int i1;
        String str;
        StringBuilder localStringBuilder;
        if (paramString.has("c2s_click_url"))
        {
          localObject1 = paramString.optJSONArray("c2s_click_url");
          if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
          {
            i2 = ((JSONArray)localObject1).length();
            localObject2 = new ArrayList();
            i1 = 0;
            if (i1 < i2)
            {
              str = (String)((JSONArray)localObject1).opt(i1);
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(" setVideoAdInfoC2SInfo clickUrl = ");
                localStringBuilder.append(str);
                QLog.d("setVideoAdInfoC2SInfo", 2, localStringBuilder.toString());
              }
              ((ArrayList)localObject2).add(str);
              i1 += 1;
              continue;
            }
            this.ag = ((ArrayList)localObject2);
          }
        }
        if (paramString.has("c2s_exposure_url"))
        {
          localObject1 = paramString.optJSONArray("c2s_exposure_url");
          if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
          {
            i2 = ((JSONArray)localObject1).length();
            localObject2 = new ArrayList();
            i1 = 0;
            if (i1 < i2)
            {
              str = (String)((JSONArray)localObject1).opt(i1);
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(" setVideoAdInfoC2SInfo exposureUrl = ");
                localStringBuilder.append(str);
                QLog.d("setVideoAdInfoC2SInfo", 2, localStringBuilder.toString());
              }
              ((ArrayList)localObject2).add(str);
              i1 += 1;
              continue;
            }
            this.ah = ((ArrayList)localObject2);
          }
        }
        bool = paramString.has("pop_sheet");
        if (bool)
        {
          localObject1 = new JSONObject(paramString.optString("pop_sheet")).getString("h5Url");
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("h5Url = ");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("processAdExtraDataInfo", 2, ((StringBuilder)localObject2).toString());
          }
          this.ai = ((String)localObject1);
        }
        if (paramString.has("button_flag"))
        {
          localObject1 = paramString.optString("button_flag", "1");
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("buttonFlag = ");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("processAdExtraDataInfo", 2, ((StringBuilder)localObject2).toString());
          }
          if (((String)localObject1).equals("0")) {
            break label686;
          }
          bool = true;
          this.aj = bool;
        }
        if (paramString.has("video_rowkey"))
        {
          this.am = paramString.optString("video_rowkey", "");
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("video_rowkey = ");
            ((StringBuilder)localObject1).append(this.am);
            QLog.d("processAdExtraDataInfo", 2, ((StringBuilder)localObject1).toString());
          }
        }
        if (paramString.has("revisionVideoType")) {
          this.U = paramString.optInt("revisionVideoType");
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append(" setVideoAdInfoC2SInfo mAdCorporateImageName = ");
          paramString.append(this.x);
          paramString.append(" mAdTraceId = ");
          paramString.append(this.m);
          paramString.append("c2s_switch = ");
          paramString.append(this.af);
          QLog.d("setVideoAdInfoC2SInfo", 2, paramString.toString());
          return;
        }
      }
      catch (Exception paramString)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setVideoAdInfoC2SInfo exception ");
        ((StringBuilder)localObject1).append(paramString.toString());
        QLog.e("setVideoAdInfoC2SInfo", 1, ((StringBuilder)localObject1).toString());
      }
      return;
      label686:
      boolean bool = false;
    }
  }
  
  public void a(List<oidb_0x6cf.NegFeedback> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        oidb_0x6cf.NegFeedback localNegFeedback = (oidb_0x6cf.NegFeedback)paramList.next();
        this.P.add(new VideoAdInfo.NegFeedback(localNegFeedback));
      }
    }
  }
  
  public void b(String paramString)
  {
    if (paramString != null) {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
    }
    for (;;)
    {
      int i1;
      try
      {
        paramString = new JSONObject(paramString);
        this.ao = paramString.optString("dpa_img");
        this.ap = paramString.optString("dpa_name");
        this.aq = paramString.optString("dpa_price");
        this.ar = paramString.optString("dpa_discount");
        JSONArray localJSONArray = paramString.optJSONArray("dpa_additional");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          i1 = 0;
          if (i1 < localJSONArray.length())
          {
            Object localObject = localJSONArray.get(i1);
            if (!(localObject instanceof String)) {
              break label176;
            }
            this.as.add((String)localObject);
            break label176;
          }
        }
        this.at = paramString.optInt("ad_first_category");
        this.aw = paramString.optInt("dpa_display_seconds");
        this.au = paramString.optString("dpa_button_text1");
        this.au = paramString.optString("dpa_button_text1");
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      return;
      label176:
      i1 += 1;
    }
  }
  
  public void c(String paramString)
  {
    if (paramString != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      try
      {
        paramString = new JSONObject(paramString);
        this.ax = paramString.optInt("verVideo618Action");
        this.ay = paramString.optString("618PendantUrl");
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("[\n");
    localStringBuilder.append("    kd_pos=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", pull_time=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n");
    localStringBuilder.append("    img=");
    localStringBuilder.append(this.g);
    localStringBuilder.append("\n");
    localStringBuilder.append("    rl=");
    localStringBuilder.append(this.k);
    localStringBuilder.append("\n");
    localStringBuilder.append("    txt=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", trace_id=");
    localStringBuilder.append(this.m);
    localStringBuilder.append("\n");
    localStringBuilder.append("    button_txt=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(", corporation_name=");
    localStringBuilder.append(this.w);
    localStringBuilder.append("\n");
    localStringBuilder.append("    corporate_logo=");
    localStringBuilder.append(this.y);
    localStringBuilder.append("\n");
    localStringBuilder.append("    video_url=");
    localStringBuilder.append(this.B);
    localStringBuilder.append("\n");
    localStringBuilder.append("    aid=");
    localStringBuilder.append(this.G);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.O);
    localStringBuilder.append("\n");
    localStringBuilder.append("    material_id=");
    localStringBuilder.append(this.I);
    localStringBuilder.append(", material_width=");
    localStringBuilder.append(this.J);
    localStringBuilder.append(", material_height=");
    localStringBuilder.append(this.K);
    localStringBuilder.append("\n");
    localStringBuilder.append("    extra_info=");
    localStringBuilder.append(this.R);
    localStringBuilder.append("\n");
    localStringBuilder.append("    jump_mode=");
    localStringBuilder.append(this.S);
    localStringBuilder.append("\n");
    localStringBuilder.append("    appDownLoad_schema=");
    localStringBuilder.append(this.W);
    localStringBuilder.append("\n");
    localStringBuilder.append("    canvas_json=");
    localStringBuilder.append(this.X);
    localStringBuilder.append("\n");
    localStringBuilder.append("    landingPage_reporturl=");
    localStringBuilder.append(this.Y);
    localStringBuilder.append("\n");
    localStringBuilder.append("    advertise_id=");
    localStringBuilder.append(this.Z);
    localStringBuilder.append("\n");
    localStringBuilder.append("    dest_type=");
    localStringBuilder.append(this.aa);
    localStringBuilder.append("\n");
    localStringBuilder.append("    effect_url=");
    localStringBuilder.append(this.ab);
    localStringBuilder.append("\n");
    localStringBuilder.append("    noco_id=");
    localStringBuilder.append(this.ac);
    localStringBuilder.append("\n");
    localStringBuilder.append("    noco_id=");
    localStringBuilder.append(this.ad);
    localStringBuilder.append("\n");
    localStringBuilder.append("    revisionVideoType=");
    localStringBuilder.append(this.U);
    localStringBuilder.append("\n");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeLong(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeInt(this.o);
    paramParcel.writeInt(this.p);
    paramParcel.writeList(this.q);
    paramParcel.writeString(this.r);
    paramParcel.writeString(this.s);
    paramParcel.writeString(this.t);
    paramParcel.writeString(this.u);
    paramParcel.writeString(this.v);
    paramParcel.writeString(this.w);
    paramParcel.writeString(this.x);
    paramParcel.writeString(this.y);
    paramParcel.writeLong(this.z);
    paramParcel.writeString(this.A);
    paramParcel.writeString(this.B);
    paramParcel.writeInt(this.C);
    paramParcel.writeStringList(this.D);
    paramParcel.writeStringList(this.E);
    paramParcel.writeStringList(this.F);
    paramParcel.writeLong(this.G);
    paramParcel.writeInt(this.H);
    paramParcel.writeInt(this.I);
    paramParcel.writeInt(this.J);
    paramParcel.writeInt(this.K);
    paramParcel.writeString(this.L);
    paramParcel.writeInt(this.M);
    paramParcel.writeString(this.N);
    paramParcel.writeInt(this.O);
    paramParcel.writeList(this.P);
    paramParcel.writeLong(this.Q);
    paramParcel.writeString(this.R);
    paramParcel.writeInt(this.S);
    paramParcel.writeString(this.W);
    paramParcel.writeString(this.X);
    paramParcel.writeString(this.Y);
    paramParcel.writeLong(this.Z);
    paramParcel.writeInt(this.aa);
    paramParcel.writeString(this.ab);
    paramParcel.writeLong(this.ac);
    paramParcel.writeString(this.ad);
    paramParcel.writeInt(this.U);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo
 * JD-Core Version:    0.7.0.1
 */