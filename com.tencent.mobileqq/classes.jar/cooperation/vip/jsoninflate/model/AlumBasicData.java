package cooperation.vip.jsoninflate.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import blal;
import blam;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import cooperation.vip.pb.vac_adv_get.DefaultConf;
import cooperation.vip.pb.vac_adv_get.DropList;
import cooperation.vip.pb.vac_adv_get.VacAdvMetaMsg;
import cooperation.vip.pb.vac_adv_get.VacFeedsAdvMetaInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpParam;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class AlumBasicData
  implements Parcelable
{
  public static final Parcelable.Creator<AlumBasicData> CREATOR = new blal();
  public int a;
  public long a;
  public String a;
  public List<blam> a;
  public qq_ad_get.QQAdGetRsp.AdInfo a;
  public boolean a;
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
      paramParcel.readList(this.jdField_a_of_type_JavaUtilList, blam.class.getClassLoader());
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
          break label435;
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
          break label440;
        }
        m = n;
        label247:
        localAlumBasicData.jdField_f_of_type_Int = m;
        if (!TextUtils.isEmpty(localAlumBasicData.k)) {
          localAlumBasicData.jdField_g_of_type_Int = 1;
        }
      }
      a(localAlumBasicData, localAdInfo);
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
      else if ((localAdInfo != null) && (localAdInfo.ext_json != null))
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
        label435:
        m = 0;
        continue;
        label440:
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
      Object localObject = new vac_adv_get.VacFeedsAdvMetaInfo();
      ((vac_adv_get.VacFeedsAdvMetaInfo)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (qq_ad_get.QQAdGetRsp.AdInfo)((vac_adv_get.VacFeedsAdvMetaInfo)localObject).adv_rsp.get();
      localAlumBasicData.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo = paramArrayOfByte;
      localAlumBasicData.jdField_a_of_type_JavaLangString = ((vac_adv_get.VacFeedsAdvMetaInfo)localObject).recomm_cookie.get();
      b(localAlumBasicData, paramArrayOfByte);
      if ((((vac_adv_get.VacFeedsAdvMetaInfo)localObject).default_conf.has()) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject).default_conf.get() != null))
      {
        if ((TextUtils.isEmpty(localAlumBasicData.jdField_h_of_type_JavaLangString)) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject).default_conf.left_bottom_text.has())) {
          localAlumBasicData.jdField_h_of_type_JavaLangString = ((vac_adv_get.VacFeedsAdvMetaInfo)localObject).default_conf.left_bottom_text.get();
        }
        if ((TextUtils.isEmpty(localAlumBasicData.i)) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject).default_conf.right_bottom_button.has())) {
          localAlumBasicData.i = ((vac_adv_get.VacFeedsAdvMetaInfo)localObject).default_conf.right_bottom_button.get();
        }
      }
      if ((((vac_adv_get.VacFeedsAdvMetaInfo)localObject).droplist.has()) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject).droplist.get() != null) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject).droplist.get().size() != 0))
      {
        int m = 0;
        while (m < ((vac_adv_get.VacFeedsAdvMetaInfo)localObject).droplist.get().size())
        {
          localAlumBasicData.jdField_a_of_type_JavaUtilList.add(blam.a((vac_adv_get.DropList)((vac_adv_get.VacFeedsAdvMetaInfo)localObject).droplist.get().get(m)));
          m += 1;
        }
      }
      if ((paramArrayOfByte != null) && (paramArrayOfByte.report_info != null))
      {
        localObject = (qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)paramArrayOfByte.report_info.get();
        localAlumBasicData.jdField_e_of_type_JavaLangString = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject).exposure_url.get();
        localAlumBasicData.jdField_f_of_type_JavaLangString = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject).negative_feedback_url.get();
        localAlumBasicData.jdField_g_of_type_JavaLangString = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject).click_url.get();
        if (paramArrayOfByte.report_info.trace_info != null) {
          localAlumBasicData.jdField_a_of_type_Long = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject).trace_info.aid.get();
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        QLog.e("AlumBasicData", 1, "createFrombyte  from byte error " + paramArrayOfByte);
      }
    }
    return localAlumBasicData;
  }
  
  private String a(AlumBasicData paramAlumBasicData, boolean paramBoolean)
  {
    localObject1 = "";
    Object localObject2 = localObject1;
    if (paramAlumBasicData != null)
    {
      localObject2 = localObject1;
      if (paramAlumBasicData.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo != null)
      {
        localObject2 = localObject1;
        if (paramAlumBasicData.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.report_info != null)
        {
          localObject2 = localObject1;
          if (paramAlumBasicData.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.report_info.original_exposure_url != null)
          {
            localObject2 = localObject1;
            if (TextUtils.isEmpty(paramAlumBasicData.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.report_info.original_exposure_url.get())) {}
          }
        }
      }
    }
    for (;;)
    {
      String str;
      try
      {
        str = paramAlumBasicData.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.report_info.original_exposure_url.get();
        localObject2 = str;
        localObject1 = str;
        if (!TextUtils.isEmpty(str))
        {
          localObject1 = str;
          if (paramAlumBasicData.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.product_type.get() != 12) {
            continue;
          }
          localObject1 = str;
          paramAlumBasicData = new StringBuilder();
          if (!paramBoolean) {
            continue;
          }
          m = 2;
          localObject1 = str;
          paramAlumBasicData = str.replace("__ACTION_TYPE__", m + "");
          localObject1 = paramAlumBasicData;
          paramAlumBasicData = (AlumBasicData)localObject1;
        }
      }
      catch (Exception paramAlumBasicData) {}
      try
      {
        localObject1 = ((String)localObject1).replace("__VIEW_PERCENT__", "1");
        paramAlumBasicData = (AlumBasicData)localObject1;
        localObject2 = ((String)localObject1).replace("__VIEW_TIME__", "0");
        return localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject1 = paramAlumBasicData;
          paramAlumBasicData = localException;
        }
      }
      int m = 1;
      continue;
      localObject1 = str;
      paramAlumBasicData = str.replace("__ACTION_TYPE__", "0");
      localObject1 = paramAlumBasicData;
    }
    paramAlumBasicData.printStackTrace();
    return localObject1;
  }
  
  private static void a(AlumBasicData paramAlumBasicData, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    int n;
    int i2;
    if ((paramAdInfo.display_info.button_info.has()) && (paramAdInfo.display_info.button_info.get() != null) && (paramAdInfo.display_info.button_info.get().size() > 0))
    {
      n = 0;
      i2 = 0;
    }
    int i3;
    for (int m = 0;; m = i3)
    {
      int i1;
      if (n < paramAdInfo.display_info.button_info.get().size())
      {
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo localButtonInfo = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)paramAdInfo.display_info.button_info.get(n);
        i1 = i2;
        if (i2 == 0)
        {
          i1 = i2;
          if (localButtonInfo.pos.get() == 2)
          {
            i1 = i2;
            if (!TextUtils.isEmpty(localButtonInfo.txt.get()))
            {
              paramAlumBasicData.i = localButtonInfo.txt.get();
              i1 = 1;
            }
          }
        }
        i3 = m;
        if (m == 0)
        {
          i3 = m;
          if (localButtonInfo.pos.get() == 1)
          {
            i3 = m;
            if (!TextUtils.isEmpty(localButtonInfo.txt.get()))
            {
              paramAlumBasicData.jdField_h_of_type_JavaLangString = localButtonInfo.txt.get();
              i3 = 1;
            }
          }
        }
        if ((i3 == 0) || (i1 == 0)) {}
      }
      else
      {
        return;
      }
      n += 1;
      i2 = i1;
    }
  }
  
  private static void b(AlumBasicData paramAlumBasicData, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    if ((paramAdInfo != null) && (paramAdInfo.display_info.get() != null))
    {
      Object localObject = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)paramAdInfo.display_info.basic_info.get();
      if (localObject != null)
      {
        paramAlumBasicData.jdField_b_of_type_JavaLangString = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject).img.get();
        paramAlumBasicData.jdField_d_of_type_JavaLangString = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject).txt.get();
        paramAlumBasicData.jdField_a_of_type_Int = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject).pic_width.get();
        paramAlumBasicData.jdField_b_of_type_Int = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject).pic_height.get();
      }
      if ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)paramAdInfo.display_info.advertiser_info.get() != null)
      {
        paramAlumBasicData.jdField_c_of_type_JavaLangString = paramAdInfo.display_info.advertiser_info.corporate_image_name.get();
        paramAlumBasicData.j = paramAdInfo.display_info.advertiser_info.corporate_logo.get();
      }
      if ((paramAdInfo.display_info.button_info.has()) && (paramAdInfo.display_info.button_info.get() != null) && (paramAdInfo.display_info.button_info.get().size() > 0))
      {
        int m = 0;
        while (m < paramAdInfo.display_info.button_info.get().size())
        {
          localObject = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)paramAdInfo.display_info.button_info.get(m);
          if ((((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject).pos.get() == 2) && (!TextUtils.isEmpty(((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject).txt.get()))) {
            paramAlumBasicData.i = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject).txt.get();
          }
          if ((((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject).pos.get() == 1) && (!TextUtils.isEmpty(((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject).txt.get()))) {
            paramAlumBasicData.jdField_h_of_type_JavaLangString = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject).txt.get();
          }
          m += 1;
        }
      }
      QLog.i("AlumBasicData", 1, " basicData.advTextTitle=" + paramAlumBasicData.jdField_c_of_type_JavaLangString);
    }
  }
  
  public void a(AlumBasicData paramAlumBasicData, boolean paramBoolean)
  {
    if (paramAlumBasicData == null) {}
    String str;
    do
    {
      do
      {
        return;
      } while (paramAlumBasicData == null);
      str = a(paramAlumBasicData, paramBoolean);
    } while ((TextUtils.isEmpty(str)) || (paramAlumBasicData.jdField_a_of_type_Boolean));
    GdtReporter.doCgiReport(str);
    paramAlumBasicData.jdField_a_of_type_Boolean = true;
    QZLog.i("AlumBasicData", "GDT_CGI_REPORT" + str);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo != null) && (this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.ext != null))
    {
      Iterator localIterator = this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.ext.exp_map.get().iterator();
      while (localIterator.hasNext())
      {
        qq_ad_get.QQAdGetRsp.AdInfo.ExpParam localExpParam = (qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)localIterator.next();
        if ((localExpParam.key.get() == 10001) && ("1".equals(localExpParam.value.get()))) {
          return true;
        }
      }
    }
    return false;
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