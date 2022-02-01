package com.tencent.mobileqq.vas.adv.common.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.DefaultConf;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.DropList;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.VacAdvMetaMsg;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.VacFeedsAdvMetaInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
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
  public static final Parcelable.Creator<AlumBasicData> CREATOR = new AlumBasicData.1();
  private static final int EXP_KEY_AD_NEGATIVE_FEEDBACK_NEW_ICON = 10002;
  private static final String EXP_VALUE_AD_NEGATIVE_FEEDBACK_NEW_ICON = "1";
  public qq_ad_get.QQAdGetRsp.AdInfo adInfo;
  public int adinfolength;
  public String advLogoUrl = "";
  public String advTextText;
  public String advTextTitle;
  public String advimageUrl;
  public String clickUrl;
  public List<AlumBasicData.DropData> dropList = new ArrayList();
  public int hasExposed = 0;
  public int imageHeight;
  public int imageWith;
  public boolean isOriginalExposureReport = false;
  public String leftBottomText = "";
  public int mAdvType = -1;
  public int mAutoPlay;
  public int mPreloadMiniApp;
  public int mShowVideoTime;
  public String mVideoReportUrl = "";
  public String mVideoUrl = "";
  public String negativeFeedbackUrl;
  public String qqbexposureInfor;
  public String recCookie;
  public String rightBottomButton = "";
  public long traceaid;
  
  public AlumBasicData() {}
  
  protected AlumBasicData(Parcel paramParcel)
  {
    this.recCookie = paramParcel.readString();
    this.advimageUrl = paramParcel.readString();
    this.advTextTitle = paramParcel.readString();
    this.advTextText = paramParcel.readString();
    this.imageWith = paramParcel.readInt();
    this.imageHeight = paramParcel.readInt();
    this.qqbexposureInfor = paramParcel.readString();
    this.negativeFeedbackUrl = paramParcel.readString();
    this.clickUrl = paramParcel.readString();
    this.traceaid = paramParcel.readLong();
    this.adinfolength = paramParcel.readInt();
    int i = this.adinfolength;
    if (i > 0)
    {
      byte[] arrayOfByte = new byte[i];
      paramParcel.readByteArray(arrayOfByte);
      this.adInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
      try
      {
        this.adInfo.mergeFrom(arrayOfByte);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse ad info from byte error ");
        localStringBuilder.append(localException);
        QLog.e("AlumBasicData", 1, localStringBuilder.toString());
      }
    }
    this.leftBottomText = paramParcel.readString();
    this.rightBottomButton = paramParcel.readString();
    paramParcel.readList(this.dropList, AlumBasicData.DropData.class.getClassLoader());
    this.hasExposed = paramParcel.readInt();
    this.mVideoUrl = paramParcel.readString();
    this.mShowVideoTime = paramParcel.readInt();
    this.mAutoPlay = paramParcel.readInt();
    this.mAdvType = paramParcel.readInt();
    this.mPreloadMiniApp = paramParcel.readInt();
    this.advLogoUrl = paramParcel.readString();
    this.mVideoReportUrl = paramParcel.readString();
  }
  
  public static AlumBasicData createFromPb(vac_adv_get.VacAdvMetaMsg paramVacAdvMetaMsg)
  {
    AlumBasicData localAlumBasicData = new AlumBasicData();
    if (paramVacAdvMetaMsg == null) {
      return null;
    }
    localAlumBasicData.recCookie = paramVacAdvMetaMsg.recomm_cookie.get();
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo)paramVacAdvMetaMsg.adv_rsp.get();
    localAlumBasicData.adInfo = localAdInfo;
    if ((localAdInfo != null) && (localAdInfo.display_info.get() != null))
    {
      paramVacAdvMetaMsg = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localAdInfo.display_info.basic_info.get();
      if (paramVacAdvMetaMsg != null)
      {
        localAlumBasicData.advimageUrl = paramVacAdvMetaMsg.img.get();
        localAlumBasicData.advTextText = paramVacAdvMetaMsg.txt.get();
        localAlumBasicData.imageWith = paramVacAdvMetaMsg.pic_width.get();
        localAlumBasicData.imageHeight = paramVacAdvMetaMsg.pic_height.get();
        int i;
        if (TextUtils.isEmpty(localAlumBasicData.advimageUrl)) {
          i = -1;
        } else {
          i = 0;
        }
        localAlumBasicData.mAdvType = i;
      }
      if ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localAdInfo.display_info.advertiser_info.get() != null)
      {
        localAlumBasicData.advTextTitle = localAdInfo.display_info.advertiser_info.corporate_image_name.get();
        localAlumBasicData.advLogoUrl = localAdInfo.display_info.advertiser_info.corporate_logo.get();
      }
      paramVacAdvMetaMsg = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localAdInfo.display_info.video_info.get();
      if (paramVacAdvMetaMsg != null)
      {
        localAlumBasicData.mVideoUrl = paramVacAdvMetaMsg.video_url.get();
        localAlumBasicData.mShowVideoTime = paramVacAdvMetaMsg.media_duration.get();
        localAlumBasicData.mAutoPlay = (paramVacAdvMetaMsg.no_auto_play.get() ^ true);
        if (!TextUtils.isEmpty(localAlumBasicData.mVideoUrl)) {
          localAlumBasicData.mAdvType = 1;
        }
      }
      parseBottomBtnTxt(localAlumBasicData, localAdInfo);
    }
    if ((localAdInfo != null) && (localAdInfo.report_info != null))
    {
      paramVacAdvMetaMsg = (qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localAdInfo.report_info.get();
      localAlumBasicData.qqbexposureInfor = paramVacAdvMetaMsg.exposure_url.get();
      localAlumBasicData.negativeFeedbackUrl = paramVacAdvMetaMsg.negative_feedback_url.get();
      localAlumBasicData.clickUrl = paramVacAdvMetaMsg.click_url.get();
      if (localAdInfo.report_info.trace_info != null) {
        localAlumBasicData.traceaid = paramVacAdvMetaMsg.trace_info.aid.get();
      }
      if (paramVacAdvMetaMsg.video_report_url.get() == null) {
        paramVacAdvMetaMsg = "";
      } else {
        paramVacAdvMetaMsg = paramVacAdvMetaMsg.video_report_url.get();
      }
      localAlumBasicData.mVideoReportUrl = paramVacAdvMetaMsg;
    }
    if ((localAdInfo != null) && (localAdInfo.ext_json != null))
    {
      paramVacAdvMetaMsg = localAdInfo.ext_json.get();
      if (!TextUtils.isEmpty(paramVacAdvMetaMsg)) {
        try
        {
          paramVacAdvMetaMsg = new JSONObject(paramVacAdvMetaMsg);
          if (paramVacAdvMetaMsg.has("mini_program_preload"))
          {
            localAlumBasicData.mPreloadMiniApp = paramVacAdvMetaMsg.getInt("mini_program_preload");
            return localAlumBasicData;
          }
        }
        catch (Exception paramVacAdvMetaMsg)
        {
          QLog.e("AlumBasicData", 2, paramVacAdvMetaMsg.toString());
        }
      }
    }
    return localAlumBasicData;
  }
  
  public static AlumBasicData createFrombyte(byte[] paramArrayOfByte)
  {
    AlumBasicData localAlumBasicData = new AlumBasicData();
    if (paramArrayOfByte != null) {}
    try
    {
      if (paramArrayOfByte.length != 0)
      {
        QLog.i("AlumBasicData", 1, " begin createFrombyte");
        localObject = new vac_adv_get.VacFeedsAdvMetaInfo();
        ((vac_adv_get.VacFeedsAdvMetaInfo)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (qq_ad_get.QQAdGetRsp.AdInfo)((vac_adv_get.VacFeedsAdvMetaInfo)localObject).adv_rsp.get();
        localAlumBasicData.adInfo = paramArrayOfByte;
        localAlumBasicData.recCookie = ((vac_adv_get.VacFeedsAdvMetaInfo)localObject).recomm_cookie.get();
        parseDisplayInfoFiled(localAlumBasicData, paramArrayOfByte);
        if ((((vac_adv_get.VacFeedsAdvMetaInfo)localObject).default_conf.has()) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject).default_conf.get() != null))
        {
          if ((TextUtils.isEmpty(localAlumBasicData.leftBottomText)) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject).default_conf.left_bottom_text.has())) {
            localAlumBasicData.leftBottomText = ((vac_adv_get.VacFeedsAdvMetaInfo)localObject).default_conf.left_bottom_text.get();
          }
          if ((TextUtils.isEmpty(localAlumBasicData.rightBottomButton)) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject).default_conf.right_bottom_button.has())) {
            localAlumBasicData.rightBottomButton = ((vac_adv_get.VacFeedsAdvMetaInfo)localObject).default_conf.right_bottom_button.get();
          }
        }
        if ((((vac_adv_get.VacFeedsAdvMetaInfo)localObject).droplist.has()) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject).droplist.get() != null) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject).droplist.get().size() != 0))
        {
          int i = 0;
          while (i < ((vac_adv_get.VacFeedsAdvMetaInfo)localObject).droplist.get().size())
          {
            localAlumBasicData.dropList.add(AlumBasicData.DropData.creatFromPb((vac_adv_get.DropList)((vac_adv_get.VacFeedsAdvMetaInfo)localObject).droplist.get().get(i)));
            i += 1;
          }
        }
        if ((paramArrayOfByte == null) || (paramArrayOfByte.report_info == null)) {
          break label382;
        }
        localObject = (qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)paramArrayOfByte.report_info.get();
        localAlumBasicData.qqbexposureInfor = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject).exposure_url.get();
        localAlumBasicData.negativeFeedbackUrl = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject).negative_feedback_url.get();
        localAlumBasicData.clickUrl = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject).click_url.get();
        if (paramArrayOfByte.report_info.trace_info == null) {
          break label382;
        }
        localAlumBasicData.traceaid = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject).trace_info.aid.get();
        return localAlumBasicData;
      }
      QLog.i("AlumBasicData", 1, " bytes is null");
      return null;
    }
    catch (Exception localException)
    {
      Object localObject;
      label350:
      break label350;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("createFrombyte  from byte error ");
    paramArrayOfByte.append(localObject);
    QLog.e("AlumBasicData", 1, paramArrayOfByte.toString());
    label382:
    return localAlumBasicData;
  }
  
  private String getOriginalIExposureUrl(AlumBasicData paramAlumBasicData, boolean paramBoolean)
  {
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (paramAlumBasicData != null)
    {
      Object localObject3 = paramAlumBasicData.adInfo;
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (((qq_ad_get.QQAdGetRsp.AdInfo)localObject3).report_info != null)
        {
          localObject2 = localObject1;
          if (paramAlumBasicData.adInfo.report_info.original_exposure_url != null)
          {
            localObject2 = localObject1;
            if (!TextUtils.isEmpty(paramAlumBasicData.adInfo.report_info.original_exposure_url.get())) {
              try
              {
                localObject3 = paramAlumBasicData.adInfo.report_info.original_exposure_url.get();
                localObject1 = localObject3;
                localObject2 = localObject3;
                if (!TextUtils.isEmpty((CharSequence)localObject3))
                {
                  localObject1 = localObject3;
                  paramAlumBasicData = GdtOriginalExposureReporter.a((String)localObject3, paramAlumBasicData.adInfo.product_type.get(), paramBoolean);
                  return paramAlumBasicData;
                }
              }
              catch (Exception paramAlumBasicData)
              {
                paramAlumBasicData.printStackTrace();
                localObject2 = localObject1;
              }
            }
          }
        }
      }
    }
    return localObject2;
  }
  
  private static void parseBottomBtnTxt(AlumBasicData paramAlumBasicData, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    if ((paramAdInfo.display_info.button_info.has()) && (paramAdInfo.display_info.button_info.get() != null) && (paramAdInfo.display_info.button_info.get().size() > 0))
    {
      int j = 0;
      int m = 0;
      int n;
      for (int i = 0; j < paramAdInfo.display_info.button_info.get().size(); i = n)
      {
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo localButtonInfo = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)paramAdInfo.display_info.button_info.get(j);
        int k = m;
        if (m == 0)
        {
          k = m;
          if (localButtonInfo.pos.get() == 2)
          {
            k = m;
            if (!TextUtils.isEmpty(localButtonInfo.txt.get()))
            {
              paramAlumBasicData.rightBottomButton = localButtonInfo.txt.get();
              k = 1;
            }
          }
        }
        n = i;
        if (i == 0)
        {
          n = i;
          if (localButtonInfo.pos.get() == 1)
          {
            n = i;
            if (!TextUtils.isEmpty(localButtonInfo.txt.get()))
            {
              paramAlumBasicData.leftBottomText = localButtonInfo.txt.get();
              n = 1;
            }
          }
        }
        if ((n != 0) && (k != 0)) {
          return;
        }
        j += 1;
        m = k;
      }
    }
  }
  
  private static void parseDisplayInfoFiled(AlumBasicData paramAlumBasicData, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    if ((paramAdInfo != null) && (paramAdInfo.display_info.get() != null))
    {
      Object localObject = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)paramAdInfo.display_info.basic_info.get();
      if (localObject != null)
      {
        paramAlumBasicData.advimageUrl = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject).img.get();
        paramAlumBasicData.advTextText = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject).txt.get();
        paramAlumBasicData.imageWith = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject).pic_width.get();
        paramAlumBasicData.imageHeight = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject).pic_height.get();
      }
      if ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)paramAdInfo.display_info.advertiser_info.get() != null)
      {
        paramAlumBasicData.advTextTitle = paramAdInfo.display_info.advertiser_info.corporate_image_name.get();
        paramAlumBasicData.advLogoUrl = paramAdInfo.display_info.advertiser_info.corporate_logo.get();
      }
      if ((paramAdInfo.display_info.button_info.has()) && (paramAdInfo.display_info.button_info.get() != null) && (paramAdInfo.display_info.button_info.get().size() > 0))
      {
        int i = 0;
        while (i < paramAdInfo.display_info.button_info.get().size())
        {
          localObject = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)paramAdInfo.display_info.button_info.get(i);
          if ((((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject).pos.get() == 2) && (!TextUtils.isEmpty(((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject).txt.get()))) {
            paramAlumBasicData.rightBottomButton = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject).txt.get();
          }
          if ((((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject).pos.get() == 1) && (!TextUtils.isEmpty(((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject).txt.get()))) {
            paramAlumBasicData.leftBottomText = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject).txt.get();
          }
          i += 1;
        }
      }
      paramAdInfo = new StringBuilder();
      paramAdInfo.append(" basicData.advTextTitle=");
      paramAdInfo.append(paramAlumBasicData.advTextTitle);
      QLog.i("AlumBasicData", 1, paramAdInfo.toString());
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean isUseAdNegativeFeedbackNewIcon()
  {
    Object localObject = this.adInfo;
    if ((localObject != null) && (((qq_ad_get.QQAdGetRsp.AdInfo)localObject).ext != null))
    {
      localObject = this.adInfo.ext.exp_map.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        qq_ad_get.QQAdGetRsp.AdInfo.ExpParam localExpParam = (qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)((Iterator)localObject).next();
        if ((localExpParam.key.get() == 10002) && ("1".equals(localExpParam.value.get()))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void originalExposureReport(AlumBasicData paramAlumBasicData, boolean paramBoolean)
  {
    if (paramAlumBasicData == null) {
      return;
    }
    if (paramAlumBasicData != null)
    {
      String str = getOriginalIExposureUrl(paramAlumBasicData, paramBoolean);
      if ((!TextUtils.isEmpty(str)) && (!paramAlumBasicData.isOriginalExposureReport))
      {
        GdtReporter.doCgiReport(str);
        paramAlumBasicData.isOriginalExposureReport = true;
        paramAlumBasicData = new StringBuilder();
        paramAlumBasicData.append("GDT_CGI_REPORT");
        paramAlumBasicData.append(str);
        QZLog.i("AlumBasicData", paramAlumBasicData.toString());
      }
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.recCookie);
    paramParcel.writeString(this.advimageUrl);
    paramParcel.writeString(this.advTextTitle);
    paramParcel.writeString(this.advTextText);
    paramParcel.writeInt(this.imageWith);
    paramParcel.writeInt(this.imageHeight);
    paramParcel.writeString(this.qqbexposureInfor);
    paramParcel.writeString(this.negativeFeedbackUrl);
    paramParcel.writeString(this.clickUrl);
    paramParcel.writeLong(this.traceaid);
    int i = 0;
    paramInt = i;
    try
    {
      byte[] arrayOfByte = this.adInfo.toByteArray();
      paramInt = i;
      i = arrayOfByte.length;
      paramInt = i;
      paramParcel.writeInt(i);
      paramInt = i;
      paramParcel.writeByteArray(arrayOfByte);
    }
    catch (Exception localException)
    {
      paramParcel.writeInt(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AlumBasicData writeToParcel  error ");
      localStringBuilder.append(localException);
      QLog.e("AlumBasicData", 1, localStringBuilder.toString());
    }
    paramParcel.writeString(this.leftBottomText);
    paramParcel.writeString(this.rightBottomButton);
    paramParcel.writeList(this.dropList);
    paramParcel.writeInt(this.hasExposed);
    paramParcel.writeString(this.mVideoUrl);
    paramParcel.writeInt(this.mShowVideoTime);
    paramParcel.writeInt(this.mAutoPlay);
    paramParcel.writeInt(this.mAdvType);
    paramParcel.writeInt(this.mPreloadMiniApp);
    paramParcel.writeString(this.advLogoUrl);
    paramParcel.writeString(this.mVideoReportUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.common.data.AlumBasicData
 * JD-Core Version:    0.7.0.1
 */