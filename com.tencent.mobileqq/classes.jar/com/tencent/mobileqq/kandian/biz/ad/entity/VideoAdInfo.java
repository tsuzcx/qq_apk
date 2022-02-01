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
  public String C;
  @notColumn
  public String D = "";
  @notColumn
  public String E = "";
  @notColumn
  public String F = "";
  @notColumn
  public String G = "";
  @notColumn
  public String H = "";
  @notColumn
  public String I;
  @notColumn
  public String J;
  @notColumn
  public String K;
  @notColumn
  public double a;
  public int a;
  public long a;
  public String a;
  public ArrayList<VideoAdInfo> a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public ArrayList<String> b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public ArrayList<String> c;
  @notColumn
  public boolean c;
  public int d;
  public long d;
  public String d;
  public ArrayList<String> d;
  @notColumn
  public boolean d;
  public int e;
  public long e;
  public String e;
  public ArrayList<VideoAdInfo.NegFeedback> e;
  public int f;
  public long f;
  public String f;
  @notColumn
  public ArrayList<String> f;
  public int g;
  public long g;
  public String g;
  @notColumn
  public ArrayList<String> g;
  public int h;
  public long h;
  public String h;
  @notColumn
  public ArrayList<String> h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public String l;
  public int m;
  public String m;
  public int n;
  public String n;
  public int o;
  public String o;
  @notColumn
  public int p;
  public String p;
  @notColumn
  public int q;
  public String q = null;
  @notColumn
  public int r;
  public String r;
  @notColumn
  public int s;
  public String s;
  @notColumn
  public int t;
  public String t;
  @notColumn
  public int u;
  public String u;
  public String v = null;
  public String w = null;
  public String x = null;
  public String y = null;
  public String z = null;
  
  public VideoAdInfo()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_g_of_type_JavaLangString = null;
    this.jdField_h_of_type_JavaLangString = null;
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_j_of_type_JavaLangString = null;
    this.jdField_k_of_type_JavaLangString = null;
    this.jdField_l_of_type_JavaLangString = null;
    this.jdField_m_of_type_JavaLangString = null;
    this.jdField_n_of_type_JavaLangString = null;
    this.jdField_o_of_type_JavaLangString = null;
    this.jdField_p_of_type_JavaLangString = null;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_r_of_type_JavaLangString = null;
    this.jdField_s_of_type_JavaLangString = null;
    this.jdField_e_of_type_Int = 0;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.jdField_t_of_type_JavaLangString = null;
    this.jdField_j_of_type_Int = 0;
    this.jdField_u_of_type_JavaLangString = null;
    this.jdField_k_of_type_Int = 0;
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_f_of_type_Long = 0L;
    this.jdField_l_of_type_Int = 0;
    this.jdField_m_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_n_of_type_Int = 0;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_p_of_type_Int = 0;
    this.jdField_f_of_type_JavaUtilArrayList = null;
    this.jdField_g_of_type_JavaUtilArrayList = null;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_h_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_r_of_type_Int = 1;
    this.jdField_s_of_type_Int = 3;
    this.jdField_t_of_type_Int = 0;
  }
  
  public VideoAdInfo(long paramLong, oidb_0x6cf.PosAdInfo paramPosAdInfo)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_g_of_type_JavaLangString = null;
    this.jdField_h_of_type_JavaLangString = null;
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_j_of_type_JavaLangString = null;
    this.jdField_k_of_type_JavaLangString = null;
    this.jdField_l_of_type_JavaLangString = null;
    this.jdField_m_of_type_JavaLangString = null;
    this.jdField_n_of_type_JavaLangString = null;
    this.jdField_o_of_type_JavaLangString = null;
    this.jdField_p_of_type_JavaLangString = null;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_r_of_type_JavaLangString = null;
    this.jdField_s_of_type_JavaLangString = null;
    this.jdField_e_of_type_Int = 0;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.jdField_t_of_type_JavaLangString = null;
    this.jdField_j_of_type_Int = 0;
    this.jdField_u_of_type_JavaLangString = null;
    this.jdField_k_of_type_Int = 0;
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_f_of_type_Long = 0L;
    this.jdField_l_of_type_Int = 0;
    this.jdField_m_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_n_of_type_Int = 0;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_p_of_type_Int = 0;
    this.jdField_f_of_type_JavaUtilArrayList = null;
    this.jdField_g_of_type_JavaUtilArrayList = null;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_h_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_r_of_type_Int = 1;
    this.jdField_s_of_type_Int = 3;
    this.jdField_t_of_type_Int = 0;
    if ((paramPosAdInfo != null) && (paramPosAdInfo.int32_ret.get() == 0) && (paramPosAdInfo.msg_ad_info.has()))
    {
      if (paramPosAdInfo.msg_ad_info.get() == null) {
        return;
      }
      this.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_Int = paramPosAdInfo.enum_pos_layout.get();
      this.jdField_b_of_type_Long = paramPosAdInfo.uint64_pos_id.get();
      paramPosAdInfo = (oidb_0x6cf.AdInfo)paramPosAdInfo.msg_ad_info.get();
      this.jdField_c_of_type_Long = paramPosAdInfo.uint64_channel_id.get();
      this.jdField_b_of_type_Int = paramPosAdInfo.int32_kd_pos.get();
      this.jdField_a_of_type_JavaLangString = paramPosAdInfo.bytes_cl.get().toStringUtf8();
      this.jdField_b_of_type_JavaLangString = paramPosAdInfo.bytes_img.get().toStringUtf8();
      this.jdField_c_of_type_JavaLangString = paramPosAdInfo.bytes_img_s.get().toStringUtf8();
      this.jdField_d_of_type_JavaLangString = paramPosAdInfo.bytes_txt.get().toStringUtf8();
      this.jdField_e_of_type_JavaLangString = paramPosAdInfo.bytes_desc.get().toStringUtf8();
      this.jdField_f_of_type_JavaLangString = paramPosAdInfo.bytes_rl.get().toStringUtf8();
      this.jdField_g_of_type_JavaLangString = paramPosAdInfo.bytes_apurl.get().toStringUtf8();
      this.jdField_h_of_type_JavaLangString = paramPosAdInfo.bytes_trace_id.get().toStringUtf8();
      this.jdField_i_of_type_JavaLangString = paramPosAdInfo.bytes_product_id.get().toStringUtf8();
      this.jdField_c_of_type_Int = paramPosAdInfo.int32_product_type.get();
      this.jdField_d_of_type_Int = paramPosAdInfo.uint32_ad_type.get();
      this.jdField_j_of_type_JavaLangString = paramPosAdInfo.bytes_landing_page.get().toStringUtf8();
      this.jdField_k_of_type_JavaLangString = paramPosAdInfo.bytes_price.get().toStringUtf8();
      this.jdField_l_of_type_JavaLangString = paramPosAdInfo.bytes_button_txt.get().toStringUtf8();
      this.jdField_m_of_type_JavaLangString = paramPosAdInfo.bytes_view_id.get().toStringUtf8();
      this.jdField_n_of_type_JavaLangString = paramPosAdInfo.bytes_customized_invoke_url.get().toStringUtf8();
      this.jdField_o_of_type_JavaLangString = paramPosAdInfo.bytes_corporation_name.get().toStringUtf8();
      this.jdField_p_of_type_JavaLangString = paramPosAdInfo.bytes_corporate_image_name.get().toStringUtf8();
      this.q = paramPosAdInfo.bytes_corporate_logo.get().toStringUtf8();
      this.jdField_d_of_type_Long = paramPosAdInfo.uint64_ad_uin.get();
      this.jdField_r_of_type_JavaLangString = paramPosAdInfo.bytes_ext.get().toStringUtf8();
      if (TextUtils.isEmpty(this.jdField_r_of_type_JavaLangString)) {
        this.jdField_r_of_type_JavaLangString = new JSONObject().toString();
      }
      try
      {
        this.jdField_o_of_type_Int = new JSONObject(paramPosAdInfo.bytes_extra_data.get().toStringUtf8()).optInt("AdSource");
      }
      catch (Throwable localThrowable)
      {
        QLog.e("VideoAdInfo", 4, localThrowable, new Object[0]);
      }
      this.jdField_s_of_type_JavaLangString = paramPosAdInfo.bytes_video_url.get().toStringUtf8();
      this.jdField_e_of_type_Int = paramPosAdInfo.uint32_cost_type.get();
      Iterator localIterator;
      ByteStringMicro localByteStringMicro;
      if ((paramPosAdInfo.bytes_title_list.has()) && (paramPosAdInfo.bytes_title_list.get() != null))
      {
        localIterator = paramPosAdInfo.bytes_title_list.get().iterator();
        while (localIterator.hasNext())
        {
          localByteStringMicro = (ByteStringMicro)localIterator.next();
          this.jdField_b_of_type_JavaUtilArrayList.add(localByteStringMicro.toStringUtf8());
        }
      }
      if ((paramPosAdInfo.bytes_image_list.has()) && (paramPosAdInfo.bytes_image_list.get() != null))
      {
        localIterator = paramPosAdInfo.bytes_image_list.get().iterator();
        while (localIterator.hasNext())
        {
          localByteStringMicro = (ByteStringMicro)localIterator.next();
          this.jdField_c_of_type_JavaUtilArrayList.add(localByteStringMicro.toStringUtf8());
        }
      }
      if ((paramPosAdInfo.bytes_url_list.has()) && (paramPosAdInfo.bytes_url_list.get() != null))
      {
        localIterator = paramPosAdInfo.bytes_url_list.get().iterator();
        while (localIterator.hasNext())
        {
          localByteStringMicro = (ByteStringMicro)localIterator.next();
          this.jdField_d_of_type_JavaUtilArrayList.add(localByteStringMicro.toStringUtf8());
        }
      }
      this.jdField_e_of_type_Long = paramPosAdInfo.uint64_aid.get();
      this.jdField_f_of_type_Int = paramPosAdInfo.enum_ad_layout.get();
      this.jdField_g_of_type_Int = paramPosAdInfo.uint32_ad_material_id.get();
      this.jdField_h_of_type_Int = paramPosAdInfo.uint32_ad_material_width.get();
      this.jdField_i_of_type_Int = paramPosAdInfo.uint32_ad_material_height.get();
      this.jdField_t_of_type_JavaLangString = paramPosAdInfo.bytes_via.get().toStringUtf8();
      this.jdField_j_of_type_Int = paramPosAdInfo.uint32_dis_channel.get();
      this.jdField_u_of_type_JavaLangString = paramPosAdInfo.bytes_button_url.get().toStringUtf8();
      this.jdField_k_of_type_Int = paramPosAdInfo.uint32_duration.get();
      this.v = paramPosAdInfo.bytes_extra_data.get().toStringUtf8();
      this.jdField_l_of_type_Int = paramPosAdInfo.enum_ad_jump_mode.get();
      this.x = paramPosAdInfo.bytes_app_download_schema.get().toStringUtf8();
      this.y = paramPosAdInfo.string_canvas_json.get();
      this.z = paramPosAdInfo.bytes_landing_page_report_url.get().toStringUtf8();
      this.jdField_g_of_type_Long = paramPosAdInfo.uint64_advertiser_id.get();
      this.jdField_n_of_type_Int = paramPosAdInfo.uint32_dest_type.get();
      this.A = paramPosAdInfo.string_effect_url.get();
      this.jdField_h_of_type_Long = paramPosAdInfo.int64_noco_id.get();
      this.B = paramPosAdInfo.bytes_download_api_url.get().toStringUtf8();
      a(this.v);
      d(this.v);
      b(this.v);
      c(this.v);
    }
  }
  
  protected VideoAdInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_g_of_type_JavaLangString = null;
    this.jdField_h_of_type_JavaLangString = null;
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_j_of_type_JavaLangString = null;
    this.jdField_k_of_type_JavaLangString = null;
    this.jdField_l_of_type_JavaLangString = null;
    this.jdField_m_of_type_JavaLangString = null;
    this.jdField_n_of_type_JavaLangString = null;
    this.jdField_o_of_type_JavaLangString = null;
    this.jdField_p_of_type_JavaLangString = null;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_r_of_type_JavaLangString = null;
    this.jdField_s_of_type_JavaLangString = null;
    this.jdField_e_of_type_Int = 0;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.jdField_t_of_type_JavaLangString = null;
    this.jdField_j_of_type_Int = 0;
    this.jdField_u_of_type_JavaLangString = null;
    this.jdField_k_of_type_Int = 0;
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_f_of_type_Long = 0L;
    this.jdField_l_of_type_Int = 0;
    this.jdField_m_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_n_of_type_Int = 0;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_p_of_type_Int = 0;
    this.jdField_f_of_type_JavaUtilArrayList = null;
    this.jdField_g_of_type_JavaUtilArrayList = null;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_h_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_r_of_type_Int = 1;
    this.jdField_s_of_type_Int = 3;
    this.jdField_t_of_type_Int = 0;
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.jdField_g_of_type_JavaLangString = paramParcel.readString();
    this.jdField_h_of_type_JavaLangString = paramParcel.readString();
    this.jdField_i_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaUtilArrayList = paramParcel.readArrayList(VideoAdInfo.class.getClassLoader());
    this.jdField_j_of_type_JavaLangString = paramParcel.readString();
    this.jdField_k_of_type_JavaLangString = paramParcel.readString();
    this.jdField_l_of_type_JavaLangString = paramParcel.readString();
    this.jdField_m_of_type_JavaLangString = paramParcel.readString();
    this.jdField_n_of_type_JavaLangString = paramParcel.readString();
    this.jdField_o_of_type_JavaLangString = paramParcel.readString();
    this.jdField_p_of_type_JavaLangString = paramParcel.readString();
    this.q = paramParcel.readString();
    this.jdField_d_of_type_Long = paramParcel.readLong();
    this.jdField_r_of_type_JavaLangString = paramParcel.readString();
    this.jdField_s_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    paramParcel.readStringList(this.jdField_b_of_type_JavaUtilArrayList);
    paramParcel.readStringList(this.jdField_c_of_type_JavaUtilArrayList);
    paramParcel.readStringList(this.jdField_d_of_type_JavaUtilArrayList);
    this.jdField_e_of_type_Long = paramParcel.readLong();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_g_of_type_Int = paramParcel.readInt();
    this.jdField_h_of_type_Int = paramParcel.readInt();
    this.jdField_i_of_type_Int = paramParcel.readInt();
    this.jdField_t_of_type_JavaLangString = paramParcel.readString();
    this.jdField_j_of_type_Int = paramParcel.readInt();
    this.jdField_u_of_type_JavaLangString = paramParcel.readString();
    this.jdField_k_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_JavaUtilArrayList = paramParcel.readArrayList(VideoAdInfo.NegFeedback.class.getClassLoader());
    this.jdField_f_of_type_Long = paramParcel.readLong();
    this.v = paramParcel.readString();
    this.jdField_l_of_type_Int = paramParcel.readInt();
    this.x = paramParcel.readString();
    this.y = paramParcel.readString();
    this.z = paramParcel.readString();
    this.jdField_g_of_type_Long = paramParcel.readLong();
    this.jdField_n_of_type_Int = paramParcel.readInt();
    this.A = paramParcel.readString();
    this.jdField_h_of_type_Long = paramParcel.readLong();
    this.B = paramParcel.readString();
    this.jdField_m_of_type_Int = paramParcel.readInt();
  }
  
  public static void a(VideoAdInfo paramVideoAdInfo)
  {
    if (paramVideoAdInfo != null)
    {
      if (TextUtils.isEmpty(paramVideoAdInfo.v)) {
        return;
      }
      try
      {
        localObject1 = new JSONObject(paramVideoAdInfo.v);
        if (((JSONObject)localObject1).has("c2s_switch")) {
          paramVideoAdInfo.jdField_p_of_type_Int = ((JSONObject)localObject1).optInt("c2s_switch");
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
            paramVideoAdInfo.jdField_f_of_type_JavaUtilArrayList = ((ArrayList)localObject3);
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
            paramVideoAdInfo.jdField_g_of_type_JavaUtilArrayList = ((ArrayList)localObject3);
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
          paramVideoAdInfo.C = ((String)localObject2);
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
          paramVideoAdInfo.jdField_b_of_type_Boolean = bool1;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(" setVideoAdInfoC2SInfo mCorporateImageName = ");
          ((StringBuilder)localObject1).append(paramVideoAdInfo.jdField_p_of_type_JavaLangString);
          ((StringBuilder)localObject1).append(" mTraceID = ");
          ((StringBuilder)localObject1).append(paramVideoAdInfo.jdField_h_of_type_JavaLangString);
          ((StringBuilder)localObject1).append(" c2s_switch = ");
          ((StringBuilder)localObject1).append(paramVideoAdInfo.jdField_p_of_type_Int);
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
        this.jdField_a_of_type_Double = paramString.optDouble("ecpm");
        this.jdField_u_of_type_Int = paramString.optInt("isContract");
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
          this.jdField_p_of_type_Int = paramString.optInt("c2s_switch");
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
            this.jdField_f_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
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
            this.jdField_g_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
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
          this.C = ((String)localObject1);
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
          this.jdField_b_of_type_Boolean = bool;
        }
        if (paramString.has("video_rowkey"))
        {
          this.D = paramString.optString("video_rowkey", "");
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("video_rowkey = ");
            ((StringBuilder)localObject1).append(this.D);
            QLog.d("processAdExtraDataInfo", 2, ((StringBuilder)localObject1).toString());
          }
        }
        if (paramString.has("revisionVideoType")) {
          this.jdField_m_of_type_Int = paramString.optInt("revisionVideoType");
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append(" setVideoAdInfoC2SInfo mAdCorporateImageName = ");
          paramString.append(this.jdField_p_of_type_JavaLangString);
          paramString.append(" mAdTraceId = ");
          paramString.append(this.jdField_h_of_type_JavaLangString);
          paramString.append("c2s_switch = ");
          paramString.append(this.jdField_p_of_type_Int);
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
        this.jdField_e_of_type_JavaUtilArrayList.add(new VideoAdInfo.NegFeedback(localNegFeedback));
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
        this.E = paramString.optString("dpa_img");
        this.F = paramString.optString("dpa_name");
        this.G = paramString.optString("dpa_price");
        this.H = paramString.optString("dpa_discount");
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
            this.jdField_h_of_type_JavaUtilArrayList.add((String)localObject);
            break label176;
          }
        }
        this.jdField_r_of_type_Int = paramString.optInt("ad_first_category");
        this.jdField_s_of_type_Int = paramString.optInt("dpa_display_seconds");
        this.I = paramString.optString("dpa_button_text1");
        this.I = paramString.optString("dpa_button_text1");
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
        this.jdField_t_of_type_Int = paramString.optInt("verVideo618Action");
        this.K = paramString.optString("618PendantUrl");
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
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", pull_time=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("\n");
    localStringBuilder.append("    img=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\n");
    localStringBuilder.append("    rl=");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append("\n");
    localStringBuilder.append("    txt=");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(", trace_id=");
    localStringBuilder.append(this.jdField_h_of_type_JavaLangString);
    localStringBuilder.append("\n");
    localStringBuilder.append("    button_txt=");
    localStringBuilder.append(this.jdField_l_of_type_JavaLangString);
    localStringBuilder.append(", corporation_name=");
    localStringBuilder.append(this.jdField_o_of_type_JavaLangString);
    localStringBuilder.append("\n");
    localStringBuilder.append("    corporate_logo=");
    localStringBuilder.append(this.q);
    localStringBuilder.append("\n");
    localStringBuilder.append("    video_url=");
    localStringBuilder.append(this.jdField_s_of_type_JavaLangString);
    localStringBuilder.append("\n");
    localStringBuilder.append("    aid=");
    localStringBuilder.append(this.jdField_e_of_type_Long);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.jdField_k_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("    material_id=");
    localStringBuilder.append(this.jdField_g_of_type_Int);
    localStringBuilder.append(", material_width=");
    localStringBuilder.append(this.jdField_h_of_type_Int);
    localStringBuilder.append(", material_height=");
    localStringBuilder.append(this.jdField_i_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("    extra_info=");
    localStringBuilder.append(this.v);
    localStringBuilder.append("\n");
    localStringBuilder.append("    jump_mode=");
    localStringBuilder.append(this.jdField_l_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("    appDownLoad_schema=");
    localStringBuilder.append(this.x);
    localStringBuilder.append("\n");
    localStringBuilder.append("    canvas_json=");
    localStringBuilder.append(this.y);
    localStringBuilder.append("\n");
    localStringBuilder.append("    landingPage_reporturl=");
    localStringBuilder.append(this.z);
    localStringBuilder.append("\n");
    localStringBuilder.append("    advertise_id=");
    localStringBuilder.append(this.jdField_g_of_type_Long);
    localStringBuilder.append("\n");
    localStringBuilder.append("    dest_type=");
    localStringBuilder.append(this.jdField_n_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("    effect_url=");
    localStringBuilder.append(this.A);
    localStringBuilder.append("\n");
    localStringBuilder.append("    noco_id=");
    localStringBuilder.append(this.jdField_h_of_type_Long);
    localStringBuilder.append("\n");
    localStringBuilder.append("    noco_id=");
    localStringBuilder.append(this.B);
    localStringBuilder.append("\n");
    localStringBuilder.append("    revisionVideoType=");
    localStringBuilder.append(this.jdField_m_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_i_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeString(this.jdField_j_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_k_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_l_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_m_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_n_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_o_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_p_of_type_JavaLangString);
    paramParcel.writeString(this.q);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeString(this.jdField_r_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_s_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeStringList(this.jdField_b_of_type_JavaUtilArrayList);
    paramParcel.writeStringList(this.jdField_c_of_type_JavaUtilArrayList);
    paramParcel.writeStringList(this.jdField_d_of_type_JavaUtilArrayList);
    paramParcel.writeLong(this.jdField_e_of_type_Long);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    paramParcel.writeInt(this.jdField_h_of_type_Int);
    paramParcel.writeInt(this.jdField_i_of_type_Int);
    paramParcel.writeString(this.jdField_t_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_j_of_type_Int);
    paramParcel.writeString(this.jdField_u_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_k_of_type_Int);
    paramParcel.writeList(this.jdField_e_of_type_JavaUtilArrayList);
    paramParcel.writeLong(this.jdField_f_of_type_Long);
    paramParcel.writeString(this.v);
    paramParcel.writeInt(this.jdField_l_of_type_Int);
    paramParcel.writeString(this.x);
    paramParcel.writeString(this.y);
    paramParcel.writeString(this.z);
    paramParcel.writeLong(this.jdField_g_of_type_Long);
    paramParcel.writeInt(this.jdField_n_of_type_Int);
    paramParcel.writeString(this.A);
    paramParcel.writeLong(this.jdField_h_of_type_Long);
    paramParcel.writeString(this.B);
    paramParcel.writeInt(this.jdField_m_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo
 * JD-Core Version:    0.7.0.1
 */