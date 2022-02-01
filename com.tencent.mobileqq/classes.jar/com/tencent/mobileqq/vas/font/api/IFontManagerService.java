package com.tencent.mobileqq.vas.font.api;

import android.graphics.drawable.Drawable;
import android.os.HandlerThread;
import android.os.Message;
import android.widget.TextView;
import com.etrump.mixlayout.FontInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

@Service(process={""})
public abstract interface IFontManagerService
  extends IRuntimeService
{
  public abstract void addFontLoadCallback(FontLoadCallback paramFontLoadCallback);
  
  public abstract boolean checkUpdateDIYConfig(AppRuntime paramAppRuntime, String paramString, ExtensionInfo paramExtensionInfo, int paramInt1, int paramInt2);
  
  public abstract boolean enableEnlargeFontEffect(MessageRecord paramMessageRecord);
  
  public abstract void enlargeEmojiAndSmall(Object paramObject);
  
  public abstract void enlargeTextMsg(TextView paramTextView);
  
  public abstract FontInfo findFontInfo(int paramInt1, int paramInt2);
  
  public abstract boolean getChatFontAbility();
  
  public abstract String getEnlargeFontDesc();
  
  public abstract float getEnlargeFontEmo();
  
  public abstract String getEnlargeFontImgURL();
  
  public abstract float getEnlargeFontText();
  
  public abstract float getEnlargeFontTextMax();
  
  public abstract File getFontBaseDir();
  
  public abstract int getFontEffectPrefer();
  
  public abstract FontInfo getFontInfo(int paramInt1, int paramInt2, boolean paramBoolean, String paramString, int paramInt3);
  
  public abstract Drawable getFontNameDrawable(int paramInt);
  
  public abstract boolean getFounderDynamicFontAbility();
  
  public abstract boolean getFounderFontAbility();
  
  public abstract HandlerThread getHandlerThread();
  
  public abstract FontInfo getTestFont();
  
  public abstract String getTestFontFile();
  
  public abstract int getTestFontType();
  
  public abstract FontInfo getUserFont(Object paramObject);
  
  public abstract int getVariedStyleIndex(long paramLong);
  
  public abstract boolean handleMessage(Message paramMessage);
  
  public abstract boolean isAioNeedRefresh(Object paramObject1, Object paramObject2);
  
  public abstract boolean isAnonymousMsg(MessageRecord paramMessageRecord);
  
  public abstract boolean isFontLoaded(int paramInt);
  
  public abstract boolean isSupportFont();
  
  public abstract boolean isTestOn();
  
  public abstract void onAIODestroy();
  
  public abstract void onDownloadComplete(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onProgress(int paramInt, float paramFloat);
  
  public abstract void onSoDownloadCompleted(int paramInt1, int paramInt2);
  
  public abstract void openFontTest(boolean paramBoolean);
  
  public abstract void parseFontEffectJSON(File paramFile);
  
  public abstract void parseHYDIYFont(MessageRecord paramMessageRecord, FontInfo paramFontInfo, String paramString);
  
  public abstract JSONObject queryInfo(int paramInt1, int paramInt2);
  
  public abstract void reDownloadFont(int paramInt1, int paramInt2);
  
  public abstract void registerIPCDownloadListener(IPCDownloadListener paramIPCDownloadListener);
  
  public abstract void removeFontLoadCallback(FontLoadCallback paramFontLoadCallback);
  
  public abstract void reportFontEffect(Object paramObject);
  
  public abstract void resetLastSendReportTime();
  
  public abstract void resumeFontAnimation(Object paramObject);
  
  public abstract void setChatFontSwitchStatus(boolean paramBoolean);
  
  public abstract void setDownloadHYSoCallback(String paramString);
  
  public abstract void setHasCheckMd5(boolean paramBoolean);
  
  public abstract void setTestFont(boolean paramBoolean, int paramInt, String paramString);
  
  public abstract void startDownload(int paramInt1, String paramString, int paramInt2);
  
  public abstract int stopDownload(int paramInt);
  
  public abstract void tryInitHYEngine();
  
  public abstract void updateDiyConfig(String paramString, int paramInt);
  
  public abstract void updateSelfFontEffectId(String paramString, int paramInt);
  
  public abstract void validLocalFont(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.font.api.IFontManagerService
 * JD-Core Version:    0.7.0.1
 */