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
  public UpgradeInfo b;
  public UpgradeInfo c;
  public ApkUpdateDetail d;
  public UpgradeDetailWrapper.NewApkInfo e;
  public NewUpgradeConfig f;
  public boolean g = false;
  public boolean h = false;
  public int i = 0;
  public int j = 0;
  public String k = "";
  
  public UpgradeDetailWrapper(UpgradeInfo paramUpgradeInfo, ApkUpdateDetail paramApkUpdateDetail)
  {
    this.b = paramUpgradeInfo;
    this.d = paramApkUpdateDetail;
  }
  
  private void a(XmlPullParser paramXmlPullParser, String paramString)
  {
    if (b(paramXmlPullParser, paramString)) {
      return;
    }
    if (c(paramXmlPullParser, paramString)) {
      return;
    }
    d(paramXmlPullParser, paramString);
  }
  
  private boolean b(XmlPullParser paramXmlPullParser, String paramString)
  {
    if (paramString.equalsIgnoreCase("configId"))
    {
      this.f.dialog.a = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else if (paramString.equalsIgnoreCase("taskName"))
    {
      this.f.dialog.b = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("taskTime"))
    {
      this.f.dialog.c = OlympicUtil.a(paramXmlPullParser.nextText());
    }
    else if (paramString.equalsIgnoreCase("showTime"))
    {
      this.f.dialog.d = OlympicUtil.a(paramXmlPullParser.nextText());
    }
    else if (paramString.equalsIgnoreCase("title"))
    {
      this.f.dialog.e = paramXmlPullParser.nextText();
      this.c.strTitle = this.f.dialog.e;
    }
    else if (paramString.equalsIgnoreCase("content"))
    {
      this.f.dialog.f = paramXmlPullParser.nextText();
      this.c.strUpgradeDesc = this.f.dialog.f;
    }
    else if (paramString.equalsIgnoreCase("desc"))
    {
      this.f.dialog.g = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("installFail"))
    {
      this.f.dialog.h = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("info"))
    {
      this.f.dialog.i = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("yellowBar"))
    {
      this.f.dialog.j = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else if (paramString.equalsIgnoreCase("barContent"))
    {
      this.f.dialog.k = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("barContent2"))
    {
      this.f.dialog.l = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("lBtnText"))
    {
      this.f.dialog.m = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("rBtnText"))
    {
      this.f.dialog.n = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("downloadDialogMaxTimes"))
    {
      this.f.dialog.p = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else if (paramString.equalsIgnoreCase("downloadDialogDayRate"))
    {
      this.f.dialog.q = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else if (paramString.equalsIgnoreCase("installDialogMaxTimes"))
    {
      this.f.dialog.r = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else if (paramString.equalsIgnoreCase("installDialogDayRate"))
    {
      this.f.dialog.s = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else
    {
      if (!paramString.equalsIgnoreCase("preDownloadYYB")) {
        break label612;
      }
      this.f.dialog.o = paramXmlPullParser.nextText().equals("1");
    }
    return true;
    label612:
    return false;
  }
  
  private boolean c(XmlPullParser paramXmlPullParser, String paramString)
  {
    boolean bool2 = paramString.equalsIgnoreCase("status");
    boolean bool1 = true;
    if (bool2)
    {
      paramXmlPullParser = paramXmlPullParser.nextText();
      if ("on".equalsIgnoreCase(paramXmlPullParser))
      {
        this.i = 1;
        return true;
      }
      if ("off".equalsIgnoreCase(paramXmlPullParser))
      {
        this.i = 2;
        return true;
      }
    }
    else
    {
      if (paramString.equalsIgnoreCase("jumpMarketSupportPhone"))
      {
        this.k = paramXmlPullParser.nextText();
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  private boolean d(XmlPullParser paramXmlPullParser, String paramString)
  {
    if (paramString.equalsIgnoreCase("iUpgradeSdkId"))
    {
      this.c.iUpgradeSdkId = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else if (paramString.equalsIgnoreCase("iUpgradeType"))
    {
      this.c.iUpgradeType = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else if (paramString.equalsIgnoreCase("iDownloadPageUrl"))
    {
      this.c.strUrl = paramXmlPullParser.nextText();
      paramXmlPullParser = this.c;
      paramXmlPullParser.strUpgradePageUrl = paramXmlPullParser.strUrl;
      paramXmlPullParser = this.c;
      paramXmlPullParser.strNewUpgradeDescURL = paramXmlPullParser.strUrl;
    }
    else if (paramString.equalsIgnoreCase("iActionType"))
    {
      this.c.iActionType = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else if (paramString.equalsIgnoreCase("bNewSwitch"))
    {
      this.c.bNewSwitch = Byte.valueOf(paramXmlPullParser.nextText()).byteValue();
    }
    else if (paramString.equalsIgnoreCase("iIncrementUpgrade"))
    {
      this.c.iIncrementUpgrade = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else if (paramString.equalsIgnoreCase("iTipsType"))
    {
      this.c.iTipsType = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else if (paramString.equalsIgnoreCase("strProgressName"))
    {
      this.c.strProgressName = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("strNewSoftwareURL"))
    {
      this.c.strNewSoftwareURL = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("strNewSoftwareMD5"))
    {
      this.c.strNewSoftwareMD5 = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("bGray"))
    {
      this.c.bGray = Byte.valueOf(paramXmlPullParser.nextText()).byteValue();
    }
    else if (paramString.equalsIgnoreCase("strButtonDesc"))
    {
      this.c.strButtonDesc = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("strCancelButtonDesc"))
    {
      this.c.strCancelButtonDesc = paramXmlPullParser.nextText();
    }
    else if (paramString.equalsIgnoreCase("iNewTimeStamp"))
    {
      this.c.iNewTimeStamp = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
    }
    else
    {
      if (!paramString.equalsIgnoreCase("strNewTipsDescURL")) {
        break label456;
      }
      this.c.strNewTipsDescURL = paramXmlPullParser.nextText();
    }
    return true;
    label456:
    return false;
  }
  
  public void a()
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parsed wrapper info:\nmTempUpgradeInfo.iUpgradeSdkId=");
    localStringBuilder.append(this.c.iUpgradeSdkId);
    localStringBuilder.append("\nmTempUpgradeInfo.iUpgradeType=");
    localStringBuilder.append(this.c.iUpgradeType);
    localStringBuilder.append("\nmTempUpgradeInfo.strUrl=");
    localStringBuilder.append(this.c.strUrl);
    localStringBuilder.append("\nmTempUpgradeInfo.strUpgradePageUrl=");
    localStringBuilder.append(this.c.strUpgradePageUrl);
    localStringBuilder.append("\nmTempUpgradeInfo.strNewUpgradeDescURL=");
    localStringBuilder.append(this.c.strNewUpgradeDescURL);
    localStringBuilder.append("\nmTempUpgradeInfo.iActionType=");
    localStringBuilder.append(this.c.iActionType);
    localStringBuilder.append("\nmTempUpgradeInfo.bNewSwitch=");
    localStringBuilder.append(this.c.bNewSwitch);
    localStringBuilder.append("\nmTempUpgradeInfo.iIncrementUpgrade=");
    localStringBuilder.append(this.c.iIncrementUpgrade);
    localStringBuilder.append("\nmTempUpgradeInfo.iTipsType=");
    localStringBuilder.append(this.c.iTipsType);
    localStringBuilder.append("\nmTempUpgradeInfo.strProgressName=");
    localStringBuilder.append(this.c.strProgressName);
    localStringBuilder.append("\nmTempUpgradeInfo.strNewSoftwareURL=");
    localStringBuilder.append(this.c.strNewSoftwareURL);
    localStringBuilder.append("\nmTempUpgradeInfo.strNewSoftwareMD5=");
    localStringBuilder.append(this.c.strNewSoftwareMD5);
    localStringBuilder.append("\nmTempUpgradeInfo.bGray=");
    localStringBuilder.append(this.c.bGray);
    localStringBuilder.append("\nmTempUpgradeInfo.strButtonDesc=");
    localStringBuilder.append(this.c.strButtonDesc);
    localStringBuilder.append("\nmTempUpgradeInfo.strCancelButtonDesc=");
    localStringBuilder.append(this.c.strCancelButtonDesc);
    localStringBuilder.append("\nmTempUpgradeInfo.strTitle=");
    localStringBuilder.append(this.c.strTitle);
    localStringBuilder.append("\nmTempUpgradeInfo.strUpgradeDesc=");
    localStringBuilder.append(this.c.strUpgradeDesc);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.id=");
    localStringBuilder.append(this.f.dialog.a);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.name=");
    localStringBuilder.append(this.f.dialog.b);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.time=");
    localStringBuilder.append(this.f.dialog.c);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.showTime=");
    localStringBuilder.append(this.f.dialog.d);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.title=");
    localStringBuilder.append(this.f.dialog.e);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.content=");
    localStringBuilder.append(this.f.dialog.f);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.desc=");
    localStringBuilder.append(this.f.dialog.g);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.installFail=");
    localStringBuilder.append(this.f.dialog.h);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.info=");
    localStringBuilder.append(this.f.dialog.i);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.rate=");
    localStringBuilder.append(this.f.dialog.j);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.barContent=");
    localStringBuilder.append(this.f.dialog.k);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.barContent2=");
    localStringBuilder.append(this.f.dialog.l);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.lBtnText=");
    localStringBuilder.append(this.f.dialog.m);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.rBtnText=");
    localStringBuilder.append(this.f.dialog.n);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.downloadDialogMaxTimes=");
    localStringBuilder.append(this.f.dialog.p);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.downloadDialogDayRate=");
    localStringBuilder.append(this.f.dialog.q);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.installDialogMaxTimes=");
    localStringBuilder.append(this.f.dialog.r);
    localStringBuilder.append("\nmNewUpgradeConfig.dialog.installDialogDayRate=");
    localStringBuilder.append(this.f.dialog.s);
    localStringBuilder.append("\npreloadSwitchConfigValue=");
    localStringBuilder.append(this.i);
    localStringBuilder.append("\njumpMarketSupportPhone=");
    localStringBuilder.append(this.k);
    QLog.d(str, 1, localStringBuilder.toString());
  }
  
  public void a(String paramString)
  {
    if (this.c == null) {
      this.c = new UpgradeInfo();
    }
    if (this.f == null)
    {
      this.f = NewUpgradeConfig.getInstance();
      this.f.prepareDialog();
    }
    Object localObject = Xml.newPullParser();
    try
    {
      ((XmlPullParser)localObject).setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
      for (int m = ((XmlPullParser)localObject).getEventType(); m != 1; m = ((XmlPullParser)localObject).next()) {
        if (m == 2) {
          a((XmlPullParser)localObject, ((XmlPullParser)localObject).getName());
        }
      }
      this.c.iAppid = AppSetting.d();
    }
    catch (Exception paramString)
    {
      this.f.dialog = null;
      localObject = a;
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
    if (this.b != null)
    {
      paramParcel.writeInt(1);
      paramParcel.writeInt(this.b.iAppid);
      paramParcel.writeByte(this.b.bAppType);
      paramParcel.writeInt(this.b.iUpgradeType);
      paramParcel.writeInt(this.b.iUpgradeSdkId);
      paramParcel.writeString(this.b.strTitle);
      paramParcel.writeString(this.b.strUpgradeDesc);
      paramParcel.writeString(this.b.strUrl);
      paramParcel.writeInt(this.b.iActionType);
      paramParcel.writeByte(this.b.bNewSwitch);
      paramParcel.writeInt(this.b.iNewTimeStamp);
      paramParcel.writeString(this.b.strUpgradePageUrl);
      paramParcel.writeInt(this.b.iIncrementUpgrade);
      paramParcel.writeInt(this.b.iTipsType);
      paramParcel.writeString(this.b.strBannerPicUrl);
      paramParcel.writeString(this.b.strNewUpgradeDescURL);
      paramParcel.writeInt(this.b.iDisplayDay);
      paramParcel.writeInt(this.b.iTipsWaitDay);
      paramParcel.writeString(this.b.strProgressName);
      paramParcel.writeString(this.b.strNewTipsDescURL);
      paramParcel.writeString(this.b.strNewSoftwareURL);
      paramParcel.writeString(this.k);
    }
    else
    {
      paramParcel.writeInt(0);
    }
    if (this.d != null)
    {
      paramParcel.writeInt(1);
      paramParcel.writeString(this.d.fileMd5);
      paramParcel.writeInt(this.d.newapksize);
      paramParcel.writeString(this.d.packageName);
      paramParcel.writeInt(this.d.patchsize);
      paramParcel.writeString(this.d.sigMd5);
      paramParcel.writeInt(this.d.updatemethod);
      paramParcel.writeString(this.d.url);
      paramParcel.writeInt(this.d.versioncode);
      paramParcel.writeString(this.d.versionname);
      return;
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeDetailWrapper
 * JD-Core Version:    0.7.0.1
 */