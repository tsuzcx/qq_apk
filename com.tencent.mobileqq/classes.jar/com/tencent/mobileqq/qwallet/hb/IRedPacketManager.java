package com.tencent.mobileqq.qwallet.hb;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qwallet.hb.aio.elem.IRedPacket;
import com.tencent.mobileqq.qwallet.hb.send.PanelData;
import com.tencent.mobileqq.qwallet.hb.send.PanelTabData;
import com.tencent.mobileqq.qwallet.hb.theme.ThemeRedPkgConfig;
import java.util.List;
import java.util.Map;

@QAPI(process={""})
public abstract interface IRedPacketManager
  extends QRouteApi, IRedPacket
{
  public static final String CONFIG_BIG_ANIM = "bigAnimMap";
  public static final String CONFIG_MODULE = "redPack";
  public static final String CONFIG_POP_AD = "popAd";
  public static final String CONFIG_POP_ANIM = "popAnimMap";
  public static final String CONFIG_SKINS = "skinMap";
  public static final String CONFIG_TAIL = "tail";
  public static final String CONFIG_URL_DETAULT_PREFIX = "https://imgcache.qq.com/channel/static/socialpay/skin/";
  public static final String CONFIG_URL_PANEL_PREFIX = "https://i.gtimg.cn/channel/imglib/201803/";
  public static final String CONFIG_URL_THEME_PREFIX = "https://i.gtimg.cn/channel/static/socialpay/paneltheme/socialpay_theme_v1_";
  public static final String CONFIG_URL_VOICE_PREFIX = "https://imgcache.qq.com/channel/static/socialpay/voice/";
  public static final String FILE_SKINS = "skins";
  public static final int FLAG_DEFAULT_REDPKG = 1;
  public static final int FLAG_LOCK_TEXT_REDPKG = 4;
  public static final int FLAG_LOCK_VOICE_REDPKG = 8;
  public static final int FLAG_LUCK_REDPKG = 2;
  public static final Map<Integer, Integer> TYPEHBINFOMAP = new IRedPacketManager.1();
  public static final int TYPE_CLEAR_CACHE = 1;
  
  public abstract List<PanelData> getPanelList(BaseSessionInfo paramBaseSessionInfo);
  
  public abstract List<PanelTabData> getPanelTabList(int paramInt, String paramString1, String paramString2);
  
  public abstract ThemeRedPkgConfig getThemeRedPkgConfById(int paramInt);
  
  public abstract void setPanelDataList(List<PanelData> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.IRedPacketManager
 * JD-Core Version:    0.7.0.1
 */