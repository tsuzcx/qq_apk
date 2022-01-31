package com.tencent.mobileqq.earlydownload.handler;

import com.etrump.mixlayout.FontSoLoader;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.xmldata.VipFontData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class VipFontSoHandler
  extends EarlyHandler
{
  private boolean d;
  
  public int a()
  {
    return 10003;
  }
  
  public Class a()
  {
    return VipFontData.class;
  }
  
  public String a()
  {
    return "actEarlyNativeVipFont";
  }
  
  public void a(XmlData paramXmlData)
  {
    if ((a().loadState == 0) && (FontSoLoader.a()) && (FontSoLoader.a((VipFontData)paramXmlData)))
    {
      VipFontData localVipFontData = (VipFontData)a();
      localVipFontData.vip_font_so_downloaded = false;
      EarlyDataFactory.a(localVipFontData, new String[] { "vip_font_so_downloaded" });
      if (QLog.isColorLevel()) {
        QLog.d("VipFontSoHandler", 2, "version update, delete unzipped so and set vip_font_so_download=false");
      }
    }
    super.a(paramXmlData);
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    Object localObject;
    if ((!paramBoolean) && (!FontSoLoader.a.get()))
    {
      localObject = ((FriendsManager)this.a.getManager(50)).a(this.a.getAccount());
      if ((localObject == null) || (0L == ((ExtensionInfo)localObject).uVipFont) || (((ExtensionInfo)localObject).vipFontType != 1)) {
        break label161;
      }
      localObject = "0";
      if (!NetworkUtil.g(this.a.getApp())) {
        break label168;
      }
    }
    label161:
    label168:
    for (String str = "1";; str = "0")
    {
      ReportController.b(this.a, "CliOper", "", "", "Font_Mall", "0X80072CA", 0, 0, "0", (String)localObject, str, "0");
      if (QLog.isColorLevel()) {
        QLog.d("VipFontSoHandler", 2, "VipFontReport: early download failed, restartDownload=false, type=" + (String)localObject + ", network=" + str);
      }
      super.a(paramXmlData, paramBoolean, paramInt, paramString);
      return;
      localObject = "1";
      break;
    }
  }
  
  public void a(String paramString)
  {
    VipFontData localVipFontData = (VipFontData)a();
    if ((localVipFontData != null) && (!this.d) && (!FontSoLoader.a()))
    {
      if (FontSoLoader.a(paramString, localVipFontData.SoMD5)) {
        break label70;
      }
      this.d = false;
      localVipFontData.loadState = 0;
      localVipFontData.Version = 0;
      localVipFontData.vip_font_so_downloaded = false;
      EarlyDataFactory.a(localVipFontData, new String[0]);
    }
    for (;;)
    {
      super.a(paramString);
      return;
      label70:
      this.d = true;
      localVipFontData.vip_font_so_downloaded = true;
      EarlyDataFactory.a(localVipFontData, new String[] { "vip_font_so_downloaded" });
      if (!FontSoLoader.b()) {
        FontSoLoader.c();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = a();
    String str1;
    String str2;
    if ((localObject == null) || (((XmlData)localObject).strPkgName == null) || (((XmlData)localObject).strPkgName.length() <= 0))
    {
      localObject = ((FriendsManager)this.a.getManager(50)).a(this.a.getAccount());
      if ((localObject != null) && (0L != ((ExtensionInfo)localObject).uVipFont) && (((ExtensionInfo)localObject).vipFontType == 1))
      {
        str1 = "0";
        if (!NetworkUtil.g(this.a.getApp())) {
          break label195;
        }
        str2 = "1";
        label90:
        localObject = (EarlyDownloadManager)this.a.getManager(76);
        if (((EarlyDownloadManager)localObject).a != null) {
          break label202;
        }
        localObject = "2";
        label113:
        ReportController.b(this.a, "CliOper", "", "", "Font_Mall", "0X80072CA", 0, 0, "1", str1, str2, (String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("VipFontSoHandler", 2, "VipFontReport: early download failed, restartDownload=true, type=" + str1 + ", network=" + str2 + ", config=" + (String)localObject);
        }
      }
    }
    label195:
    label202:
    do
    {
      return;
      str1 = "1";
      break;
      str2 = "0";
      break label90;
      if (((EarlyDownloadManager)localObject).a.booleanValue())
      {
        localObject = "2";
        break label113;
      }
      localObject = "1";
      break label113;
      if (((XmlData)localObject).loadState != 2) {
        break label247;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VipFontSoHandler", 2, "is in downloading");
    return;
    label247:
    super.a(paramBoolean);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return null;
  }
  
  public boolean f()
  {
    boolean bool = super.f();
    if ((bool) && (!FontSoLoader.a.get()))
    {
      ReportController.b(this.a, "CliOper", "", "", "Font_Mall", "0X80072C8", 0, 0, "0", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("VipFontSoHandler", 2, "VipFontReport: early download start, restartDownload=false");
      }
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.VipFontSoHandler
 * JD-Core Version:    0.7.0.1
 */