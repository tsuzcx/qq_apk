package com.tencent.mobileqq.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Xml;
import axsb;
import bfmx;
import bfnk;
import bfnl;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import org.xmlpull.v1.XmlPullParser;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeDetailWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<UpgradeDetailWrapper> CREATOR = new bfnk();
  static String a;
  public int a;
  public bfnl a;
  public ApkUpdateDetail a;
  public NewUpgradeConfig a;
  public UpgradeInfo a;
  public boolean a;
  public int b;
  public String b;
  public UpgradeInfo b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "UpgradeDetailWrapper";
  }
  
  public UpgradeDetailWrapper(UpgradeInfo paramUpgradeInfo, ApkUpdateDetail paramApkUpdateDetail)
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo = paramUpgradeInfo;
    this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail = paramApkUpdateDetail;
  }
  
  private void a(XmlPullParser paramXmlPullParser, String paramString)
  {
    if (a(paramXmlPullParser, paramString)) {}
    while ((b(paramXmlPullParser, paramString)) || (!c(paramXmlPullParser, paramString))) {
      return;
    }
  }
  
  private boolean a(XmlPullParser paramXmlPullParser, String paramString)
  {
    if (paramString.equalsIgnoreCase("configId"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("taskName"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_JavaLangString = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("taskTime"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_Long = axsb.a(paramXmlPullParser.nextText());
      return true;
    }
    if (paramString.equalsIgnoreCase("showTime"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_b_of_type_Long = axsb.a(paramXmlPullParser.nextText());
      return true;
    }
    if (paramString.equalsIgnoreCase("title"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_b_of_type_JavaLangString = paramXmlPullParser.nextText();
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strTitle = this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_b_of_type_JavaLangString;
      return true;
    }
    if (paramString.equalsIgnoreCase("content"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_c_of_type_JavaLangString = paramXmlPullParser.nextText();
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc = this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_c_of_type_JavaLangString;
      return true;
    }
    if (paramString.equalsIgnoreCase("desc"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_d_of_type_JavaLangString = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("installFail"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_e_of_type_JavaLangString = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("info"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_f_of_type_JavaLangString = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("yellowBar"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_b_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("barContent"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.g = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("barContent2"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.h = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("lBtnText"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.i = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("rBtnText"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.j = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("downloadDialogMaxTimes"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_c_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("downloadDialogDayRate"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_d_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("installDialogMaxTimes"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_e_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("installDialogDayRate"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_f_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("preDownloadYYB"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_Boolean = paramXmlPullParser.nextText().equals("1");
      return true;
    }
    return false;
  }
  
  private boolean b(XmlPullParser paramXmlPullParser, String paramString)
  {
    if (paramString.equalsIgnoreCase("status"))
    {
      paramXmlPullParser = paramXmlPullParser.nextText();
      if ("on".equalsIgnoreCase(paramXmlPullParser)) {
        this.jdField_a_of_type_Int = 1;
      }
      while (!"off".equalsIgnoreCase(paramXmlPullParser)) {
        return true;
      }
      this.jdField_a_of_type_Int = 2;
      return true;
    }
    if (paramString.equalsIgnoreCase("jumpMarketSupportPhone"))
    {
      this.jdField_b_of_type_JavaLangString = paramXmlPullParser.nextText();
      return true;
    }
    return false;
  }
  
  private boolean c(XmlPullParser paramXmlPullParser, String paramString)
  {
    if (paramString.equalsIgnoreCase("iUpgradeSdkId"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("iUpgradeType"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("iDownloadPageUrl"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUrl = paramXmlPullParser.nextText();
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradePageUrl = this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUrl;
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewUpgradeDescURL = this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUrl;
      return true;
    }
    if (paramString.equalsIgnoreCase("iActionType"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iActionType = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("bNewSwitch"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.bNewSwitch = Byte.valueOf(paramXmlPullParser.nextText()).byteValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("iIncrementUpgrade"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iIncrementUpgrade = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("iTipsType"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("strProgressName"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strProgressName = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("strNewSoftwareURL"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("strNewSoftwareMD5"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareMD5 = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("bGray"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.bGray = Byte.valueOf(paramXmlPullParser.nextText()).byteValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("strButtonDesc"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strButtonDesc = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("strCancelButtonDesc"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strCancelButtonDesc = paramXmlPullParser.nextText();
      return true;
    }
    if (paramString.equalsIgnoreCase("iNewTimeStamp"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iNewTimeStamp = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
      return true;
    }
    if (paramString.equalsIgnoreCase("strNewTipsDescURL"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewTipsDescURL = paramXmlPullParser.nextText();
      return true;
    }
    return false;
  }
  
  public void a()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "parsed wrapper info:\nmTempUpgradeInfo.iUpgradeSdkId=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId + "\nmTempUpgradeInfo.iUpgradeType=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType + "\nmTempUpgradeInfo.strUrl=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUrl + "\nmTempUpgradeInfo.strUpgradePageUrl=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradePageUrl + "\nmTempUpgradeInfo.strNewUpgradeDescURL=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewUpgradeDescURL + "\nmTempUpgradeInfo.iActionType=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iActionType + "\nmTempUpgradeInfo.bNewSwitch=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.bNewSwitch + "\nmTempUpgradeInfo.iIncrementUpgrade=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iIncrementUpgrade + "\nmTempUpgradeInfo.iTipsType=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType + "\nmTempUpgradeInfo.strProgressName=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strProgressName + "\nmTempUpgradeInfo.strNewSoftwareURL=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL + "\nmTempUpgradeInfo.strNewSoftwareMD5=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareMD5 + "\nmTempUpgradeInfo.bGray=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.bGray + "\nmTempUpgradeInfo.strButtonDesc=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strButtonDesc + "\nmTempUpgradeInfo.strCancelButtonDesc=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strCancelButtonDesc + "\nmTempUpgradeInfo.strTitle=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strTitle + "\nmTempUpgradeInfo.strUpgradeDesc=" + this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc + "\nmNewUpgradeConfig.dialog.id=" + this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_Int + "\nmNewUpgradeConfig.dialog.name=" + this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_JavaLangString + "\nmNewUpgradeConfig.dialog.time=" + this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_Long + "\nmNewUpgradeConfig.dialog.showTime=" + this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_b_of_type_Long + "\nmNewUpgradeConfig.dialog.title=" + this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_b_of_type_JavaLangString + "\nmNewUpgradeConfig.dialog.content=" + this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_c_of_type_JavaLangString + "\nmNewUpgradeConfig.dialog.desc=" + this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_d_of_type_JavaLangString + "\nmNewUpgradeConfig.dialog.installFail=" + this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_e_of_type_JavaLangString + "\nmNewUpgradeConfig.dialog.info=" + this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_f_of_type_JavaLangString + "\nmNewUpgradeConfig.dialog.rate=" + this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_b_of_type_Int + "\nmNewUpgradeConfig.dialog.barContent=" + this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.g + "\nmNewUpgradeConfig.dialog.barContent2=" + this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.h + "\nmNewUpgradeConfig.dialog.lBtnText=" + this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.i + "\nmNewUpgradeConfig.dialog.rBtnText=" + this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.j + "\nmNewUpgradeConfig.dialog.downloadDialogMaxTimes=" + this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_c_of_type_Int + "\nmNewUpgradeConfig.dialog.downloadDialogDayRate=" + this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_d_of_type_Int + "\nmNewUpgradeConfig.dialog.installDialogMaxTimes=" + this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_e_of_type_Int + "\nmNewUpgradeConfig.dialog.installDialogDayRate=" + this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_f_of_type_Int + "\npreloadSwitchConfigValue=" + this.jdField_a_of_type_Int + "\njumpMarketSupportPhone=" + this.jdField_b_of_type_JavaLangString);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo == null) {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo = new UpgradeInfo();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig = NewUpgradeConfig.getInstance();
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.prepareDialog();
    }
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    try
    {
      localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
      for (int i = localXmlPullParser.getEventType(); i != 1; i = localXmlPullParser.next()) {
        if (i == 2) {
          a(localXmlPullParser, localXmlPullParser.getName());
        }
      }
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iAppid = AppSetting.a();
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog = null;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "parseConfig fail." + paramString);
      }
    }
    a();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null)
    {
      paramParcel.writeInt(1);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iAppid);
      paramParcel.writeByte(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.bAppType);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUrl);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iActionType);
      paramParcel.writeByte(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.bNewSwitch);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iNewTimeStamp);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradePageUrl);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iIncrementUpgrade);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strBannerPicUrl);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewUpgradeDescURL);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iDisplayDay);
      paramParcel.writeInt(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iTipsWaitDay);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strProgressName);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewTipsDescURL);
      paramParcel.writeString(this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL);
      paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    }
    while (this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null)
    {
      paramParcel.writeInt(1);
      paramParcel.writeString(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.fileMd5);
      paramParcel.writeInt(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.newapksize);
      paramParcel.writeString(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.packageName);
      paramParcel.writeInt(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.patchsize);
      paramParcel.writeString(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.sigMd5);
      paramParcel.writeInt(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod);
      paramParcel.writeString(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.url);
      paramParcel.writeInt(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.versioncode);
      paramParcel.writeString(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.versionname);
      return;
      paramParcel.writeInt(0);
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeDetailWrapper
 * JD-Core Version:    0.7.0.1
 */