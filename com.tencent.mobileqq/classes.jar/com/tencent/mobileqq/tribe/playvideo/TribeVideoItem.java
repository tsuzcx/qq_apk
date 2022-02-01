package com.tencent.mobileqq.tribe.playvideo;

import android.text.Spannable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class TribeVideoItem
  extends BaseTribeVideoItem
{
  public int a;
  public Spannable a;
  public ArrayList<TribeItem> a;
  public JSONObject a;
  public int b;
  public long b;
  public boolean b;
  public int c;
  public long c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public String l;
  public int m;
  public int n;
  
  public TribeVideoItem(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_Int = paramJSONObject.optInt("del");
    this.jdField_e_of_type_Int = paramJSONObject.optInt("views_num");
    this.jdField_f_of_type_Int = paramJSONObject.optInt("hot_score");
    this.m = paramJSONObject.optInt("commentnum_v2");
    this.jdField_c_of_type_Long = paramJSONObject.optLong("uin");
    this.jdField_l_of_type_Int = paramJSONObject.optInt("likes");
    this.jdField_g_of_type_Int = paramJSONObject.optInt("readnum");
    this.jdField_h_of_type_Int = paramJSONObject.optInt("theme_id");
    this.jdField_k_of_type_Int = paramJSONObject.optInt("alreadyzan");
    this.jdField_d_of_type_JavaLangString = paramJSONObject.optString("pid");
    this.jdField_b_of_type_Long = paramJSONObject.optLong("bid");
    if ((TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) || (this.jdField_b_of_type_Long == 0L)) {
      throw new IllegalArgumentException("pid = " + this.jdField_d_of_type_JavaLangString + ", bid = " + this.jdField_b_of_type_Long);
    }
    label251:
    Object localObject;
    if (paramJSONObject.optInt("relation") == 1)
    {
      bool1 = true;
      this.jdField_c_of_type_Boolean = bool1;
      this.jdField_g_of_type_JavaLangString = paramJSONObject.optString("detail_page_url").replace("${bid}", String.valueOf(this.jdField_b_of_type_Long)).replace("${pid}", this.jdField_d_of_type_JavaLangString);
      if (paramJSONObject.optInt("star") != 1) {
        break label684;
      }
      bool1 = true;
      this.jdField_d_of_type_Boolean = bool1;
      this.jdField_e_of_type_JavaLangString = paramJSONObject.optString("gbar_home_url_android");
      this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject.optJSONObject("report");
      localObject = paramJSONObject.optJSONObject("user_info");
      if (localObject != null)
      {
        this.n = ((JSONObject)localObject).optInt("sex");
        this.jdField_k_of_type_JavaLangString = ((JSONObject)localObject).optString("nickname");
        this.jdField_l_of_type_JavaLangString = ((JSONObject)localObject).optString("headimgurl");
      }
      localObject = paramJSONObject.optJSONObject("theme_info");
      if (localObject != null)
      {
        this.jdField_d_of_type_Long = ((JSONObject)localObject).optLong("creator_uin");
        this.jdField_i_of_type_Int = ((JSONObject)localObject).optInt("censor_status");
        this.jdField_j_of_type_Int = ((JSONObject)localObject).optInt("recommend_status");
        this.jdField_h_of_type_JavaLangString = ((JSONObject)localObject).optString("theme_intro");
        this.jdField_i_of_type_JavaLangString = ((JSONObject)localObject).optString("theme_name");
      }
      localObject = paramJSONObject.optJSONObject("post");
      this.jdField_j_of_type_JavaLangString = ((JSONObject)localObject).optString("content");
      this.jdField_c_of_type_Int = paramJSONObject.optInt("cs_source");
      localObject = ((JSONObject)localObject).optJSONArray("ugc_video_list").optJSONObject(0);
      this.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("duration");
      this.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("height");
      this.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("width");
      this.jdField_b_of_type_Boolean = ((JSONObject)localObject).optBoolean("isLocalVideo");
      this.jdField_e_of_type_Long = ((JSONObject)localObject).optLong("size");
      this.jdField_f_of_type_JavaLangString = ((JSONObject)localObject).optString("text");
      this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("url");
      this.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("vid");
      this.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("video_thumbe_url");
      if (this.jdField_b_of_type_Int / this.jdField_a_of_type_Int <= 0.75F) {
        break label689;
      }
    }
    label684:
    label689:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      paramJSONObject = paramJSONObject.optJSONArray("gbar_info_list");
      if (paramJSONObject == null) {
        return;
      }
      while (i1 < paramJSONObject.length())
      {
        localObject = paramJSONObject.optJSONObject(i1);
        long l1 = ((JSONObject)localObject).optLong("bid");
        if (((JSONObject)localObject).optInt("bar_class") != 101)
        {
          localObject = new TribeItem(l1, ((JSONObject)localObject).optString("name") + HardCodeUtil.a(2131714957), this.jdField_e_of_type_JavaLangString.replace("${bid}", String.valueOf(l1)));
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        i1 += 1;
      }
      bool1 = false;
      break;
      bool1 = false;
      break label251;
    }
  }
  
  public static ArrayList<TribeVideoItem> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList(paramJSONArray.length());
    int i1 = 0;
    for (;;)
    {
      if (i1 < paramJSONArray.length()) {
        try
        {
          TribeVideoItem localTribeVideoItem = new TribeVideoItem(paramJSONArray.optJSONObject(i1));
          if (localTribeVideoItem != null) {
            localArrayList.add(new TribeVideoItem(paramJSONArray.optJSONObject(i1)));
          }
          i1 += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("TribeVideoItem", 2, QLog.getStackTraceString(localException));
            }
            Object localObject = null;
          }
        }
      }
    }
    return localArrayList;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (TribeVideoItem)paramObject;
    } while ((this.jdField_d_of_type_JavaLangString.equals(paramObject.jdField_d_of_type_JavaLangString)) && (this.jdField_b_of_type_Long == paramObject.jdField_b_of_type_Long));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.playvideo.TribeVideoItem
 * JD-Core Version:    0.7.0.1
 */