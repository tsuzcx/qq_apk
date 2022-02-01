package cooperation.vip.jsoninflate.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import bmty;
import bmtz;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.vac_adv_get.DefaultConf;
import cooperation.vip.pb.vac_adv_get.DropList;
import cooperation.vip.pb.vac_adv_get.VacAdvMetaMsg;
import cooperation.vip.pb.vac_adv_get.VacFeedsAdvMetaInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class AlumBasicData
  implements Parcelable
{
  public static final Parcelable.Creator<AlumBasicData> CREATOR = new bmty();
  public int a;
  public long a;
  public String a;
  public List<bmtz> a;
  public qq_ad_get.QQAdGetRsp.AdInfo a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public String i = "";
  public String j = "";
  public String k = "";
  public String l = "";
  
  public AlumBasicData()
  {
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_g_of_type_Int = -1;
  }
  
  public AlumBasicData(Parcel paramParcel)
  {
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_g_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.jdField_g_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    byte[] arrayOfByte;
    if (this.jdField_c_of_type_Int > 0)
    {
      arrayOfByte = new byte[this.jdField_c_of_type_Int];
      paramParcel.readByteArray(arrayOfByte);
      this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
    }
    try
    {
      this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.mergeFrom(arrayOfByte);
      this.jdField_h_of_type_JavaLangString = paramParcel.readString();
      this.i = paramParcel.readString();
      paramParcel.readList(this.jdField_a_of_type_JavaUtilList, bmtz.class.getClassLoader());
      this.jdField_d_of_type_Int = paramParcel.readInt();
      this.k = paramParcel.readString();
      this.jdField_e_of_type_Int = paramParcel.readInt();
      this.jdField_f_of_type_Int = paramParcel.readInt();
      this.jdField_g_of_type_Int = paramParcel.readInt();
      this.jdField_h_of_type_Int = paramParcel.readInt();
      this.j = paramParcel.readString();
      this.l = paramParcel.readString();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("AlumBasicData", 1, "parse ad info from byte error " + localException);
      }
    }
  }
  
  public static AlumBasicData a(vac_adv_get.VacAdvMetaMsg paramVacAdvMetaMsg)
  {
    int n = 0;
    AlumBasicData localAlumBasicData = new AlumBasicData();
    if (paramVacAdvMetaMsg == null) {
      return null;
    }
    localAlumBasicData.jdField_a_of_type_JavaLangString = paramVacAdvMetaMsg.recomm_cookie.get();
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo)paramVacAdvMetaMsg.adv_rsp.get();
    localAlumBasicData.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo = localAdInfo;
    int m;
    if ((localAdInfo != null) && (localAdInfo.display_info.get() != null))
    {
      paramVacAdvMetaMsg = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localAdInfo.display_info.basic_info.get();
      if (paramVacAdvMetaMsg != null)
      {
        localAlumBasicData.jdField_b_of_type_JavaLangString = paramVacAdvMetaMsg.img.get();
        localAlumBasicData.jdField_d_of_type_JavaLangString = paramVacAdvMetaMsg.txt.get();
        localAlumBasicData.jdField_a_of_type_Int = paramVacAdvMetaMsg.pic_width.get();
        localAlumBasicData.jdField_b_of_type_Int = paramVacAdvMetaMsg.pic_height.get();
        if (!TextUtils.isEmpty(localAlumBasicData.jdField_b_of_type_JavaLangString)) {
          break label416;
        }
        m = -1;
      }
    }
    for (;;)
    {
      localAlumBasicData.jdField_g_of_type_Int = m;
      if ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localAdInfo.display_info.advertiser_info.get() != null)
      {
        localAlumBasicData.jdField_c_of_type_JavaLangString = localAdInfo.display_info.advertiser_info.corporate_image_name.get();
        localAlumBasicData.j = localAdInfo.display_info.advertiser_info.corporate_logo.get();
      }
      paramVacAdvMetaMsg = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localAdInfo.display_info.video_info.get();
      if (paramVacAdvMetaMsg != null)
      {
        localAlumBasicData.k = paramVacAdvMetaMsg.video_url.get();
        localAlumBasicData.jdField_e_of_type_Int = paramVacAdvMetaMsg.media_duration.get();
        if (!paramVacAdvMetaMsg.no_auto_play.get()) {
          break label421;
        }
        m = n;
        label247:
        localAlumBasicData.jdField_f_of_type_Int = m;
        if (!TextUtils.isEmpty(localAlumBasicData.k)) {
          localAlumBasicData.jdField_g_of_type_Int = 1;
        }
      }
      if ((localAdInfo != null) && (localAdInfo.report_info != null))
      {
        paramVacAdvMetaMsg = (qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localAdInfo.report_info.get();
        localAlumBasicData.jdField_e_of_type_JavaLangString = paramVacAdvMetaMsg.exposure_url.get();
        localAlumBasicData.jdField_f_of_type_JavaLangString = paramVacAdvMetaMsg.negative_feedback_url.get();
        localAlumBasicData.jdField_g_of_type_JavaLangString = paramVacAdvMetaMsg.click_url.get();
        if (localAdInfo.report_info.trace_info != null) {
          localAlumBasicData.jdField_a_of_type_Long = paramVacAdvMetaMsg.trace_info.aid.get();
        }
        if (paramVacAdvMetaMsg.video_report_url.get() == null)
        {
          paramVacAdvMetaMsg = "";
          localAlumBasicData.l = paramVacAdvMetaMsg;
        }
      }
      else
      {
        paramVacAdvMetaMsg = localAdInfo.ext_json.get();
        if (TextUtils.isEmpty(paramVacAdvMetaMsg)) {}
      }
      try
      {
        paramVacAdvMetaMsg = new JSONObject(paramVacAdvMetaMsg);
        if (paramVacAdvMetaMsg.has("mini_program_preload")) {
          localAlumBasicData.jdField_h_of_type_Int = paramVacAdvMetaMsg.getInt("mini_program_preload");
        }
        return localAlumBasicData;
        label416:
        m = 0;
        continue;
        label421:
        m = 1;
        break label247;
        paramVacAdvMetaMsg = paramVacAdvMetaMsg.video_report_url.get();
      }
      catch (Exception paramVacAdvMetaMsg)
      {
        for (;;)
        {
          QLog.e("AlumBasicData", 2, paramVacAdvMetaMsg.toString());
        }
      }
    }
  }
  
  public static AlumBasicData a(byte[] paramArrayOfByte)
  {
    int n = 0;
    AlumBasicData localAlumBasicData = new AlumBasicData();
    if (paramArrayOfByte != null) {}
    try
    {
      if (paramArrayOfByte.length == 0)
      {
        QLog.i("AlumBasicData", 1, " bytes is null");
        return null;
      }
      QLog.i("AlumBasicData", 1, " begin createFrombyte");
      localObject1 = new vac_adv_get.VacFeedsAdvMetaInfo();
      ((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (qq_ad_get.QQAdGetRsp.AdInfo)((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).adv_rsp.get();
      localAlumBasicData.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo = paramArrayOfByte;
      localAlumBasicData.jdField_a_of_type_JavaLangString = ((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).recomm_cookie.get();
      if ((paramArrayOfByte == null) || (paramArrayOfByte.display_info.get() == null)) {
        break label405;
      }
      localObject2 = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)paramArrayOfByte.display_info.basic_info.get();
      if (localObject2 != null)
      {
        localAlumBasicData.jdField_b_of_type_JavaLangString = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject2).img.get();
        localAlumBasicData.jdField_d_of_type_JavaLangString = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject2).txt.get();
        localAlumBasicData.jdField_a_of_type_Int = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject2).pic_width.get();
        localAlumBasicData.jdField_b_of_type_Int = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject2).pic_height.get();
      }
      if ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)paramArrayOfByte.display_info.advertiser_info.get() != null)
      {
        localAlumBasicData.jdField_c_of_type_JavaLangString = paramArrayOfByte.display_info.advertiser_info.corporate_image_name.get();
        localAlumBasicData.j = paramArrayOfByte.display_info.advertiser_info.corporate_logo.get();
      }
      if ((!paramArrayOfByte.display_info.button_info.has()) || (paramArrayOfByte.display_info.button_info.get() == null) || (paramArrayOfByte.display_info.button_info.get().size() <= 0)) {
        break label376;
      }
      m = 0;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        int m;
        label376:
        QLog.e("AlumBasicData", 1, "createFrombyte  from byte error " + paramArrayOfByte);
        label405:
        continue;
        m += 1;
      }
    }
    if (m < paramArrayOfByte.display_info.button_info.get().size())
    {
      localObject2 = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)paramArrayOfByte.display_info.button_info.get(m);
      if ((((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject2).pos.get() == 2) && (!TextUtils.isEmpty(((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject2).txt.get()))) {
        localAlumBasicData.i = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject2).txt.get();
      }
      if ((((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject2).pos.get() == 1) && (!TextUtils.isEmpty(((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject2).txt.get()))) {
        localAlumBasicData.jdField_h_of_type_JavaLangString = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject2).txt.get();
      }
    }
    else
    {
      QLog.i("AlumBasicData", 1, " basicData.advTextTitle=" + localAlumBasicData.jdField_c_of_type_JavaLangString);
      if ((((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).default_conf.has()) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).default_conf.get() != null))
      {
        if ((TextUtils.isEmpty(localAlumBasicData.jdField_h_of_type_JavaLangString)) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).default_conf.left_bottom_text.has())) {
          localAlumBasicData.jdField_h_of_type_JavaLangString = ((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).default_conf.left_bottom_text.get();
        }
        if ((TextUtils.isEmpty(localAlumBasicData.i)) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).default_conf.right_bottom_button.has())) {
          localAlumBasicData.i = ((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).default_conf.right_bottom_button.get();
        }
      }
      if ((((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).droplist.has()) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).droplist.get() != null) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).droplist.get().size() != 0))
      {
        m = n;
        while (m < ((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).droplist.get().size())
        {
          localAlumBasicData.jdField_a_of_type_JavaUtilList.add(bmtz.a((vac_adv_get.DropList)((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).droplist.get().get(m)));
          m += 1;
        }
      }
      if ((paramArrayOfByte != null) && (paramArrayOfByte.report_info != null))
      {
        localObject1 = (qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)paramArrayOfByte.report_info.get();
        localAlumBasicData.jdField_e_of_type_JavaLangString = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).exposure_url.get();
        localAlumBasicData.jdField_f_of_type_JavaLangString = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).negative_feedback_url.get();
        localAlumBasicData.jdField_g_of_type_JavaLangString = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).click_url.get();
        if (paramArrayOfByte.report_info.trace_info != null) {
          localAlumBasicData.jdField_a_of_type_Long = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).trace_info.aid.get();
        }
      }
      return localAlumBasicData;
    }
  }
  
  public boolean a(AlumBasicData paramAlumBasicData)
  {
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool1 = false;
    boolean bool3 = bool5;
    boolean bool2;
    if (paramAlumBasicData != null)
    {
      bool3 = bool5;
      if (paramAlumBasicData.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.ext_json != null) {
        bool2 = bool4;
      }
    }
    label216:
    for (;;)
    {
      try
      {
        paramAlumBasicData = new JSONObject(paramAlumBasicData.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.ext_json.get()).getJSONArray("exp_map");
        bool2 = bool4;
        bool3 = bool5;
        if (paramAlumBasicData.length() > 0)
        {
          int m = 0;
          bool2 = bool1;
          bool3 = bool1;
          if (m < paramAlumBasicData.length())
          {
            bool2 = bool1;
            JSONObject localJSONObject = (JSONObject)paramAlumBasicData.get(m);
            bool2 = bool1;
            if (!localJSONObject.has("key")) {
              break label216;
            }
            bool2 = bool1;
            if (localJSONObject.getInt("key") != 94692) {
              break label216;
            }
            bool2 = bool1;
            if (!localJSONObject.has("value")) {
              break label216;
            }
            bool2 = bool1;
            int n = localJSONObject.getInt("value");
            if (n != 1) {
              break label216;
            }
            bool1 = true;
            m += 1;
            continue;
          }
        }
        return bool3;
      }
      catch (Throwable paramAlumBasicData)
      {
        QLog.e("AlumBasicData", 1, "adInfo error" + paramAlumBasicData);
        bool3 = bool2;
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    int m = 0;
    paramInt = m;
    try
    {
      byte[] arrayOfByte = this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.toByteArray();
      paramInt = m;
      m = arrayOfByte.length;
      paramInt = m;
      paramParcel.writeInt(m);
      paramInt = m;
      paramParcel.writeByteArray(arrayOfByte);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramParcel.writeInt(paramInt);
        QLog.e("AlumBasicData", 1, "AlumBasicData writeToParcel  error " + localException);
      }
    }
    paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
    paramParcel.writeString(this.i);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilList);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeString(this.k);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    paramParcel.writeInt(this.jdField_h_of_type_Int);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.jsoninflate.model.AlumBasicData
 * JD-Core Version:    0.7.0.1
 */