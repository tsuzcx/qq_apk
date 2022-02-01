package com.tencent.mobileqq.vas.font.api.impl;

import android.graphics.drawable.Drawable;
import android.os.HandlerThread;
import android.os.Message;
import android.widget.TextView;
import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.FontManager;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vas.font.api.FontLoadCallback;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class FontManagerServiceImpl
  implements IFontManagerService
{
  private FontManager mFontManager;
  
  public void addFontLoadCallback(FontLoadCallback paramFontLoadCallback)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.a(paramFontLoadCallback);
    }
  }
  
  public boolean checkUpdateDIYConfig(AppRuntime paramAppRuntime, String paramString, ExtensionInfo paramExtensionInfo, int paramInt1, int paramInt2)
  {
    if (this.mFontManager != null) {
      return FontManager.a((QQAppInterface)paramAppRuntime, paramString, paramExtensionInfo, paramInt1, paramInt2);
    }
    return false;
  }
  
  public boolean enableEnlargeFontEffect(MessageRecord paramMessageRecord)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.a(paramMessageRecord);
    }
    return false;
  }
  
  public void enlargeEmojiAndSmall(Object paramObject)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.a((ChatMessage)paramObject);
    }
  }
  
  public void enlargeTextMsg(TextView paramTextView)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.a(paramTextView);
    }
  }
  
  public FontInfo findFontInfo(int paramInt1, int paramInt2)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.a(paramInt1, paramInt2);
    }
    return null;
  }
  
  public boolean getChatFontAbility()
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.c();
    }
    return false;
  }
  
  public String getEnlargeFontDesc()
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.jdField_c_of_type_JavaLangString;
    }
    return "";
  }
  
  public float getEnlargeFontEmo()
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.jdField_c_of_type_Float;
    }
    return 0.0F;
  }
  
  public String getEnlargeFontImgURL()
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.d;
    }
    return "";
  }
  
  public float getEnlargeFontText()
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.jdField_a_of_type_Float;
    }
    return 0.0F;
  }
  
  public float getEnlargeFontTextMax()
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.jdField_b_of_type_Float;
    }
    return 0.0F;
  }
  
  public File getFontBaseDir()
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.a();
    }
    return null;
  }
  
  public int getFontEffectPrefer()
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.jdField_b_of_type_Int;
    }
    return 0;
  }
  
  public FontInfo getFontInfo(int paramInt1, int paramInt2, boolean paramBoolean, String paramString, int paramInt3)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.a(paramInt1, paramInt2, paramBoolean, paramString, paramInt3);
    }
    return null;
  }
  
  public Drawable getFontNameDrawable(int paramInt)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.a(paramInt);
    }
    return null;
  }
  
  public boolean getFounderDynamicFontAbility()
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.b();
    }
    return false;
  }
  
  public boolean getFounderFontAbility()
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.a();
    }
    return false;
  }
  
  public HandlerThread getHandlerThread()
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.jdField_a_of_type_AndroidOsHandlerThread;
    }
    return null;
  }
  
  public FontInfo getTestFont()
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.a();
    }
    return null;
  }
  
  public String getTestFontFile()
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public int getTestFontType()
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public FontInfo getUserFont(Object paramObject)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.b((ChatMessage)paramObject);
    }
    return null;
  }
  
  public int getVariedStyleIndex(long paramLong)
  {
    return FontManager.a(paramLong);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.handleMessage(paramMessage);
    }
    return false;
  }
  
  public boolean isAioNeedRefresh(Object paramObject1, Object paramObject2)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.a((BaseBubbleBuilder.ViewHolder)paramObject1, (ChatMessage)paramObject2);
    }
    return false;
  }
  
  public boolean isAnonymousMsg(MessageRecord paramMessageRecord)
  {
    return AnonymousChatHelper.a(paramMessageRecord);
  }
  
  public boolean isFontLoaded(int paramInt)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.a(paramInt);
    }
    return false;
  }
  
  public boolean isSupportFont()
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public boolean isTestOn()
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
    }
    return false;
  }
  
  public void onAIODestroy()
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.a();
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mFontManager = ((FontManager)paramAppRuntime.getManager(QQManagerFactory.CHAT_FONT_MANAGER));
  }
  
  public void onDestroy()
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.onDestroy();
    }
  }
  
  public void onDownloadComplete(int paramInt1, int paramInt2, String paramString)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.a(paramInt1, paramInt2, paramString);
    }
  }
  
  public void onProgress(int paramInt, float paramFloat)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.a(paramInt, paramFloat);
    }
  }
  
  public void onSoDownloadCompleted(int paramInt1, int paramInt2)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.a(paramInt1, paramInt2);
    }
  }
  
  public void openFontTest(boolean paramBoolean)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.b(paramBoolean);
    }
  }
  
  public void parseFontEffectJSON(File paramFile)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.a(paramFile);
    }
  }
  
  public void parseHYDIYFont(MessageRecord paramMessageRecord, FontInfo paramFontInfo, String paramString)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.a((ChatMessage)paramMessageRecord, paramFontInfo, paramString);
    }
  }
  
  public JSONObject queryInfo(int paramInt1, int paramInt2)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.a(paramInt1, paramInt2);
    }
    return null;
  }
  
  public void reDownloadFont(int paramInt1, int paramInt2)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.b(paramInt1, paramInt2);
    }
  }
  
  public void registerIPCDownloadListener(IPCDownloadListener paramIPCDownloadListener)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.a(paramIPCDownloadListener);
    }
  }
  
  public void removeFontLoadCallback(FontLoadCallback paramFontLoadCallback)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.b(paramFontLoadCallback);
    }
  }
  
  public void reportFontEffect(Object paramObject)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.b((ChatMessage)paramObject);
    }
  }
  
  public void resetLastSendReportTime()
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.d();
    }
  }
  
  public void resumeFontAnimation(Object paramObject)
  {
    if (this.mFontManager != null) {
      FontManager.a((BaseChatPie)paramObject);
    }
  }
  
  public void setChatFontSwitchStatus(boolean paramBoolean)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.a(paramBoolean);
    }
  }
  
  public void setDownloadHYSoCallback(String paramString)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.jdField_b_of_type_JavaLangString = paramString;
    }
  }
  
  public void setHasCheckMd5(boolean paramBoolean)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
    }
  }
  
  public void setTestFont(boolean paramBoolean, int paramInt, String paramString)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.a(paramBoolean, paramInt, paramString);
    }
  }
  
  public void startDownload(int paramInt1, String paramString, int paramInt2)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.a(paramInt1, paramString, paramInt2);
    }
  }
  
  public int stopDownload(int paramInt)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      return localFontManager.a(paramInt);
    }
    return 0;
  }
  
  public void tryInitHYEngine()
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.c();
    }
  }
  
  public void updateDiyConfig(String paramString, int paramInt)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.b(paramString, paramInt);
    }
  }
  
  public void updateSelfFontEffectId(String paramString, int paramInt)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.a(paramString, paramInt);
    }
  }
  
  public void validLocalFont(int paramInt, String paramString)
  {
    FontManager localFontManager = this.mFontManager;
    if (localFontManager != null) {
      localFontManager.a(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.font.api.impl.FontManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */