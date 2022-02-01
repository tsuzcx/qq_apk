package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import android.content.Context;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyBeaconReport;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyGuard;

public class VsReporter
{
  public static final String GUARD_JAR_VERSION = "guard_jar_version";
  public static final String GUARD_SO_VERSION = "guard_so_version";
  private static final String TAG = "VsReporter";
  public static final String VS_JAR_VERSION = "vs_jar_version";
  public static final String VS_REP_BSGUID = "vs_bsguid";
  public static final String VS_REP_ECODE = "vs_ecode";
  public static final String VS_REP_PKG = "vs_pkgmame";
  public static final String VS_REP_PLAT = "vs_platform";
  public static final String VS_REP_QIMEI = "vs_qimei";
  public static final String VS_REP_SDT = "vs_sdtfrom";
  public static final String VS_REP_VSGUID = "vs_vsguid";
  public static final String VS_REP_VSKEY = "vs_vskey";
  public static final String VS_SO_VERSION = "vs_so_version";
  
  public static void reportCKey(Context paramContext, CKeyBeaconReport paramCKeyBeaconReport, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7, String paramString8, String paramString9, String paramString10, long paramLong, String paramString11, String paramString12, String paramString13, String paramString14)
  {
    paramCKeyBeaconReport.setRequiredReportValue();
    paramCKeyBeaconReport.put("vs_platform", paramString1);
    paramCKeyBeaconReport.put("vs_sdtfrom", paramString2);
    paramCKeyBeaconReport.put("vs_vskey", paramString3);
    paramCKeyBeaconReport.put("vs_vsguid", paramString4);
    paramCKeyBeaconReport.put("vs_bsguid", paramString5);
    paramCKeyBeaconReport.put("vs_qimei", paramString6);
    paramCKeyBeaconReport.put("vs_ecode", String.valueOf(paramInt));
    paramCKeyBeaconReport.put("vs_pkgmame", paramString7);
    CKeyFacade.instance();
    paramCKeyBeaconReport.put("vs_so_version", CKeyFacade.getSoVersion());
    CKeyFacade.instance();
    paramCKeyBeaconReport.put("vs_jar_version", CKeyFacade.getJarVersion());
    CKeyGuard.instance();
    paramCKeyBeaconReport.put("guard_so_version", CKeyGuard.getSoVersion());
    CKeyGuard.instance();
    paramCKeyBeaconReport.put("guard_jar_version", CKeyGuard.getJarVersion());
    paramCKeyBeaconReport.put("vs_uin", CKeyFacade.instance().getmUin());
    paramCKeyBeaconReport.put("vs_openid", CKeyFacade.instance().getmOpenID());
    paramCKeyBeaconReport.put("vs_vuid", CKeyFacade.instance().getmVuid());
    paramCKeyBeaconReport.put("vs_extinfo", CKeyFacade.instance().getmExtInfo());
    paramCKeyBeaconReport.put("bs_platform", paramString8);
    paramCKeyBeaconReport.put("bs_sdtfrom", paramString9);
    paramCKeyBeaconReport.put("bs_vid", paramString10);
    paramCKeyBeaconReport.put("bs_time", String.valueOf(paramLong));
    paramCKeyBeaconReport.put("com/tencent/qqlive/ckey", paramString11);
    paramCKeyBeaconReport.put("vs_caller", paramString12);
    paramCKeyBeaconReport.put("bs_extinfo", paramString13);
    paramCKeyBeaconReport.put("bs_guard", paramString14);
    CKeyBeaconReport.trackCustomKVEvent(paramContext, "vs_ckey", paramCKeyBeaconReport.getProperties());
  }
  
  public static void reportInit(Context paramContext, CKeyBeaconReport paramCKeyBeaconReport, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7)
  {
    paramCKeyBeaconReport.setRequiredReportValue();
    paramCKeyBeaconReport.put("vs_platform", paramString1);
    paramCKeyBeaconReport.put("vs_sdtfrom", paramString2);
    paramCKeyBeaconReport.put("vs_vskey", paramString3);
    paramCKeyBeaconReport.put("vs_vsguid", paramString4);
    paramCKeyBeaconReport.put("vs_bsguid", paramString5);
    paramCKeyBeaconReport.put("vs_qimei", paramString6);
    paramCKeyBeaconReport.put("vs_ecode", String.valueOf(paramInt));
    paramCKeyBeaconReport.put("vs_pkgmame", paramString7);
    CKeyFacade.instance();
    paramCKeyBeaconReport.put("vs_so_version", CKeyFacade.getSoVersion());
    CKeyFacade.instance();
    paramCKeyBeaconReport.put("vs_jar_version", CKeyFacade.getJarVersion());
    CKeyGuard.instance();
    paramCKeyBeaconReport.put("guard_so_version", CKeyGuard.getSoVersion());
    CKeyGuard.instance();
    paramCKeyBeaconReport.put("guard_jar_version", CKeyGuard.getJarVersion());
    paramCKeyBeaconReport.put("vs_uin", CKeyFacade.instance().getmUin());
    paramCKeyBeaconReport.put("vs_openid", CKeyFacade.instance().getmOpenID());
    paramCKeyBeaconReport.put("vs_vuid", CKeyFacade.instance().getmVuid());
    paramCKeyBeaconReport.put("vs_extinfo", CKeyFacade.instance().getmExtInfo());
    CKeyBeaconReport.trackCustomKVEvent(paramContext, "vs_init", paramCKeyBeaconReport.getProperties());
  }
  
  public static void reportSign(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    throw new NullPointerException();
  }
  
  public static void reportTaskEncrypt(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    throw new NullPointerException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsReporter
 * JD-Core Version:    0.7.0.1
 */