package com.tencent.mobileqq.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Xml;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import org.xmlpull.v1.XmlPullParser;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeDetailWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<UpgradeDetailWrapper> CREATOR = new UpgradeDetailWrapper.1();
  static String a = "UpgradeDetailWrapper";
  public int a;
  public ApkUpdateDetail a;
  public NewUpgradeConfig a;
  public UpgradeDetailWrapper.NewApkInfo a;
  public UpgradeInfo a;
  public boolean a;
  public int b;
  public String b;
  public UpgradeInfo b;
  public boolean b;
  
  public UpgradeDetailWrapper(UpgradeInfo paramUpgradeInfo, ApkUpdateDetail paramApkUpdateDetail)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo = paramUpgradeInfo;
    this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail = paramApkUpdateDetail;
  }
  
  private void a(XmlPullParser paramXmlPullParser, String paramString)
  {
    if (a(paramXmlPullParser, paramString)) {
      return;
    }
    if (b(paramXmlPullParser, paramString)) {
      return;
    }
    c(paramXmlPullParser, paramString);
  }
  
  private boolean a(XmlPullParser paramXmlPullParser, String paramString)
  {
    if (paramString.equalsIgnoreCase("configId"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else if (paramString.equalsIgnoreCase("taskName"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_JavaLangString = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("taskTime"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_Long = OlympicUtil.a(paramXmlPullParser.nextText());
    }
    else if (paramString.equalsIgnoreCase("showTime"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_b_of_type_Long = OlympicUtil.a(paramXmlPullParser.nextText());
    }
    else if (paramString.equalsIgnoreCase("title"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_b_of_type_JavaLangString = paramXmlPullParser.nextText();
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strTitle = this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_b_of_type_JavaLangString;
    }
    else if (paramString.equalsIgnoreCase("content"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_c_of_type_JavaLangString = paramXmlPullParser.nextText();
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc = this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_c_of_type_JavaLangString;
    }
    else if (paramString.equalsIgnoreCase("desc"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_d_of_type_JavaLangString = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("installFail"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_e_of_type_JavaLangString = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("info"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_f_of_type_JavaLangString = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("yellowBar"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_b_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else if (paramString.equalsIgnoreCase("barContent"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.g = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("barContent2"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.h = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("lBtnText"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.i = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("rBtnText"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.j = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("downloadDialogMaxTimes"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_c_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else if (paramString.equalsIgnoreCase("downloadDialogDayRate"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_d_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else if (paramString.equalsIgnoreCase("installDialogMaxTimes"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_e_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else if (paramString.equalsIgnoreCase("installDialogDayRate"))
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_f_of_type_Int = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else
    {
      if (!paramString.equalsIgnoreCase("preDownloadYYB")) {
        break label612;
      }
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_Boolean = paramXmlPullParser.nextText().equals("1");
    }
    return true;
    label612:
    return false;
  }
  
  private boolean b(XmlPullParser paramXmlPullParser, String paramString)
  {
    boolean bool2 = paramString.equalsIgnoreCase("status");
    boolean bool1 = true;
    if (bool2)
    {
      paramXmlPullParser = paramXmlPullParser.nextText();
      if ("on".equalsIgnoreCase(paramXmlPullParser))
      {
        this.jdField_a_of_type_Int = 1;
        return true;
      }
      if ("off".equalsIgnoreCase(paramXmlPullParser))
      {
        this.jdField_a_of_type_Int = 2;
        return true;
      }
    }
    else
    {
      if (paramString.equalsIgnoreCase("jumpMarketSupportPhone"))
      {
        this.jdField_b_of_type_JavaLangString = paramXmlPullParser.nextText();
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  private boolean c(XmlPullParser paramXmlPullParser, String paramString)
  {
    if (paramString.equalsIgnoreCase("iUpgradeSdkId"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else if (paramString.equalsIgnoreCase("iUpgradeType"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else if (paramString.equalsIgnoreCase("iDownloadPageUrl"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUrl = paramXmlPullParser.nextText();
      paramXmlPullParser = this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo;
      paramXmlPullParser.strUpgradePageUrl = paramXmlPullParser.strUrl;
      paramXmlPullParser = this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo;
      paramXmlPullParser.strNewUpgradeDescURL = paramXmlPullParser.strUrl;
    }
    else if (paramString.equalsIgnoreCase("iActionType"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iActionType = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else if (paramString.equalsIgnoreCase("bNewSwitch"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.bNewSwitch = Byte.valueOf(paramXmlPullParser.nextText()).byteValue();
    }
    else if (paramString.equalsIgnoreCase("iIncrementUpgrade"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iIncrementUpgrade = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else if (paramString.equalsIgnoreCase("iTipsType"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else if (paramString.equalsIgnoreCase("strProgressName"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strProgressName = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("strNewSoftwareURL"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("strNewSoftwareMD5"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareMD5 = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("bGray"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.bGray = Byte.valueOf(paramXmlPullParser.nextText()).byteValue();
    }
    else if (paramString.equalsIgnoreCase("strButtonDesc"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strButtonDesc = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("strCancelButtonDesc"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strCancelButtonDesc = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("iNewTimeStamp"))
    {
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iNewTimeStamp = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else
    {
      if (!paramString.equalsIgnoreCase("strNewTipsDescURL")) {
        break label453;
      }
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewTipsDescURL = paramXmlPullParser.nextText();
    }
    return true;
    label453:
    return false;
  }
  
  public void a()
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parsed wrapper info:\nmTempUpgradeInfo.iUpgradeSdkId=");
    localStringBuilder.append(this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId);
    localStringBuilder.append("\nmTempUpgradeInfo.iUpgradeType=");
    localStringBuilder.append(this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType);
    localStringBuilder.append("\nmTempUpgradeInfo.strUrl=");
    localStringBuilder.append(this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUrl);
    localStringBuilder.append("\nmTempUpgradeInfo.strUpgradePageUrl=");
    localStringBuilder.append(this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradePageUrl);
    localStringBuilder.append("\nmTempUpgradeInfo.strNewUpgradeDescURL=");
    localStringBuilder.append(this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewUpgradeDescURL);
    localStringBuilder.append("\nmTempUpgradeInfo.iActionType=");
    localStringBuilder.append(this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iActionType);
    localStringBuilder.append("\nmTempUpgradeInfo.bNewSwitch=");
    localStringBuilder.append(this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.bNewSwitch);
    localStringBuilder.append("\nmTempUpgradeInfo.iIncrementUpgrade=");
    localStringBuilder.append(this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iIncrementUpgrade);
    localStringBuilder.append("\nmTempUpgradeInfo.iTipsType=");
    localStringBuilder.append(this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType);
    localStringBuilder.append("\nmTempUpgradeInfo.strProgressName=");
    localStringBuilder.append(this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strProgressName);
    localStringBuilder.append("\nmTempUpgradeInfo.strNewSoftwareURL=");
    localStringBuilder.append(this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL);
    localStringBuilder.append("\nmTempUpgradeInfo.strNewSoftwareMD5=");
    localStringBuilder.append(this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareMD5);
    localStringBuilder.append("\nmTempUpgradeInfo.bGray=");
    localStringBuilder.append(this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.bGray);
    localStringBuilder.append("\nmTempUpgradeInfo.strButtonDesc=");
    localStringBuilder.append(this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strButtonDesc);
    localStringBuilder.append("\nmTempUpgradeInfo.strCancelButtonDesc=");
    localStringBuilder.append(this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strCancelButtonDesc);
    localStringBuilder.append("\nmTempUpgradeInfo.strTitle=");
    localStringBuilder.append(this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strTitle);
    localStringBuilder.append("\nmTempUpgradeInfo.strUpgradeDesc=");
    localStringBuilder.append(this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.id=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_Int);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.name=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.time=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_Long);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.showTime=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_b_of_type_Long);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.title=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.content=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.desc=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.installFail=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.info=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_f_of_type_JavaLangString);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.rate=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_b_of_type_Int);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.barContent=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.g);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.barContent2=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.h);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.lBtnText=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.i);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.rBtnText=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.j);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.downloadDialogMaxTimes=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_c_of_type_Int);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.downloadDialogDayRate=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_d_of_type_Int);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.installDialogMaxTimes=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_e_of_type_Int);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.installDialogDayRate=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_f_of_type_Int);
    localStringBuilder.append("\npreloadSwitchConfigValue=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\njumpMarketSupportPhone=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    QLog.d(str, 1, localStringBuilder.toString());
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
    Object localObject = Xml.newPullParser();
    try
    {
      ((XmlPullParser)localObject).setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
      for (int i = ((XmlPullParser)localObject).getEventType(); i != 1; i = ((XmlPullParser)localObject).next()) {
        if (i == 2) {
          a((XmlPullParser)localObject, ((XmlPullParser)localObject).getName());
        }
      }
      this.jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iAppid = AppSetting.a();
    }
    catch (Exception paramString)
    {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog = null;
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseConfig fail.");
      localStringBuilder.append(paramString);
      QLog.e((String)localObject, 1, localStringBuilder.toString());
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
    else
    {
      paramParcel.writeInt(0);
    }
    if (this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null)
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
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeDetailWrapper
 * JD-Core Version:    0.7.0.1
 */