package cooperation.vip.jsoninflate.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import bkbd;
import bkbe;
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
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class AlumBasicData
  implements Parcelable
{
  public static final Parcelable.Creator<AlumBasicData> CREATOR = new bkbd();
  public int a;
  public long a;
  public String a;
  public List<bkbe> a;
  public qq_ad_get.QQAdGetRsp.AdInfo a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h = "";
  public String i = "";
  public String j = "";
  
  public AlumBasicData()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public AlumBasicData(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
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
      this.h = paramParcel.readString();
      this.i = paramParcel.readString();
      paramParcel.readList(this.jdField_a_of_type_JavaUtilList, bkbe.class.getClassLoader());
      this.jdField_d_of_type_Int = paramParcel.readInt();
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
    AlumBasicData localAlumBasicData = new AlumBasicData();
    if (paramVacAdvMetaMsg == null) {
      return null;
    }
    localAlumBasicData.jdField_a_of_type_JavaLangString = paramVacAdvMetaMsg.recomm_cookie.get();
    paramVacAdvMetaMsg = (qq_ad_get.QQAdGetRsp.AdInfo)paramVacAdvMetaMsg.adv_rsp.get();
    localAlumBasicData.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo = paramVacAdvMetaMsg;
    Object localObject;
    if ((paramVacAdvMetaMsg != null) && (paramVacAdvMetaMsg.display_info.get() != null))
    {
      localObject = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)paramVacAdvMetaMsg.display_info.basic_info.get();
      if (localObject != null)
      {
        localAlumBasicData.jdField_b_of_type_JavaLangString = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject).img.get();
        localAlumBasicData.jdField_d_of_type_JavaLangString = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject).txt.get();
        localAlumBasicData.jdField_a_of_type_Int = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject).pic_width.get();
        localAlumBasicData.jdField_b_of_type_Int = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject).pic_height.get();
      }
      if ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)paramVacAdvMetaMsg.display_info.advertiser_info.get() != null) {
        localAlumBasicData.jdField_c_of_type_JavaLangString = paramVacAdvMetaMsg.display_info.advertiser_info.corporate_image_name.get();
      }
    }
    if ((paramVacAdvMetaMsg != null) && (paramVacAdvMetaMsg.report_info != null))
    {
      localObject = (qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)paramVacAdvMetaMsg.report_info.get();
      localAlumBasicData.e = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject).exposure_url.get();
      localAlumBasicData.f = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject).negative_feedback_url.get();
      localAlumBasicData.g = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject).click_url.get();
      if (paramVacAdvMetaMsg.report_info.trace_info != null) {
        localAlumBasicData.jdField_a_of_type_Long = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject).trace_info.aid.get();
      }
    }
    return localAlumBasicData;
  }
  
  public static AlumBasicData a(byte[] paramArrayOfByte)
  {
    int m = 0;
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
        break label403;
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
        break label374;
      }
      k = 0;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        int k;
        label374:
        QLog.e("AlumBasicData", 1, "createFrombyte  from byte error " + paramArrayOfByte);
        label403:
        continue;
        k += 1;
      }
    }
    if (k < paramArrayOfByte.display_info.button_info.get().size())
    {
      localObject2 = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)paramArrayOfByte.display_info.button_info.get(k);
      if ((((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject2).pos.get() == 2) && (!TextUtils.isEmpty(((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject2).txt.get()))) {
        localAlumBasicData.i = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject2).txt.get();
      }
      if ((((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject2).pos.get() == 1) && (!TextUtils.isEmpty(((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject2).txt.get()))) {
        localAlumBasicData.h = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject2).txt.get();
      }
    }
    else
    {
      QLog.i("AlumBasicData", 1, " basicData.advTextTitle=" + localAlumBasicData.jdField_c_of_type_JavaLangString);
      if ((((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).default_conf.has()) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).default_conf.get() != null))
      {
        if ((TextUtils.isEmpty(localAlumBasicData.h)) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).default_conf.left_bottom_text.has())) {
          localAlumBasicData.h = ((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).default_conf.left_bottom_text.get();
        }
        if ((TextUtils.isEmpty(localAlumBasicData.i)) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).default_conf.right_bottom_button.has())) {
          localAlumBasicData.i = ((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).default_conf.right_bottom_button.get();
        }
      }
      if ((((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).droplist.has()) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).droplist.get() != null) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).droplist.get().size() != 0))
      {
        k = m;
        while (k < ((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).droplist.get().size())
        {
          localAlumBasicData.jdField_a_of_type_JavaUtilList.add(bkbe.a((vac_adv_get.DropList)((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).droplist.get().get(k)));
          k += 1;
        }
      }
      if ((paramArrayOfByte != null) && (paramArrayOfByte.report_info != null))
      {
        localObject1 = (qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)paramArrayOfByte.report_info.get();
        localAlumBasicData.e = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).exposure_url.get();
        localAlumBasicData.f = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).negative_feedback_url.get();
        localAlumBasicData.g = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).click_url.get();
        if (paramArrayOfByte.report_info.trace_info != null) {
          localAlumBasicData.jdField_a_of_type_Long = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).trace_info.aid.get();
        }
      }
      return localAlumBasicData;
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
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    int k = 0;
    paramInt = k;
    try
    {
      byte[] arrayOfByte = this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.toByteArray();
      paramInt = k;
      k = arrayOfByte.length;
      paramInt = k;
      paramParcel.writeInt(k);
      paramInt = k;
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
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilList);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.jsoninflate.model.AlumBasicData
 * JD-Core Version:    0.7.0.1
 */