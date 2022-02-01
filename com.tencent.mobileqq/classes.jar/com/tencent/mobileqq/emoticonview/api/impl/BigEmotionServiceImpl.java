package com.tencent.mobileqq.emoticonview.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.SpannableString;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmotionPanelPayBackListener;
import com.tencent.mobileqq.emoticon.EmotionPanelPayBackListenerManager;
import com.tencent.mobileqq.emoticon.IEmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonRecDressup;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.IPSiteUtil;
import com.tencent.mobileqq.emoticonview.api.IBigEmotionService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommercialDrainageManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.MqqHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.SVIPHandlerProxy;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class BigEmotionServiceImpl
  implements IBigEmotionService
{
  public void addEmotionPanelPayBackListener(EmotionPanelPayBackListener paramEmotionPanelPayBackListener)
  {
    EmotionPanelPayBackListenerManager.a().a(paramEmotionPanelPayBackListener);
  }
  
  public SpannableString dealIPSiteString(String paramString)
  {
    return IPSiteUtil.dealIPSiteString(paramString);
  }
  
  public boolean emoticonPkgNeedUpdate(int paramInt1, int paramInt2)
  {
    return EmoticonUtils.emoticonPkgNeedUpdate(paramInt1, paramInt2);
  }
  
  public Drawable getCoverBitmap(int paramInt, String paramString)
  {
    return EmosmUtils.a(paramInt, paramString);
  }
  
  public String getCoverPath(int paramInt, String paramString)
  {
    return EmosmUtils.a(paramInt, paramString);
  }
  
  public String getCoverUrl(int paramInt, String paramString)
  {
    return EmosmUtils.b(paramInt, paramString);
  }
  
  public float getEmoticonPackageLoadingProgress(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString)
  {
    return ((EmojiManagerProxy)paramIEmoticonMainPanelApp.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).getEmoticonPackageLoadingProgress(paramString);
  }
  
  public Drawable getIPSiteDrawable(String paramString, URLDrawable.URLDrawableListener paramURLDrawableListener, Drawable paramDrawable)
  {
    return IPSiteUtil.getIPSiteDrawable(paramString, paramURLDrawableListener, paramDrawable);
  }
  
  public Parcelable getIPSiteInfoFromBytes(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, byte[] paramArrayOfByte)
  {
    return ((EmoticonManagerProxy)paramIEmoticonMainPanelApp.getManager(QQManagerFactory.EMOTICON_MANAGER)).getIPSiteInfoFromBytes(paramArrayOfByte);
  }
  
  public float getStatusPercent(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString)
  {
    return (int)((EmojiManagerProxy)paramIEmoticonMainPanelApp.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).getStatusPercent(paramString);
  }
  
  public boolean hasRecommendDressup(String paramString, boolean paramBoolean)
  {
    return EmoticonRecDressup.getEmotionRecommend(paramString, paramBoolean).hasRecommendDressup;
  }
  
  public boolean isAuthorized(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt)
  {
    if (paramIEmoticonMainPanelApp == null) {
      return false;
    }
    int i = ((SVIPHandlerProxy)paramIEmoticonMainPanelApp.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).getCurrentUserVipType();
    if (paramInt == 4) {
      return (i == 1) || (i == 3);
    }
    if (paramInt == 5) {
      return i == 3;
    }
    return true;
  }
  
  public boolean isKandianType(int paramInt)
  {
    return paramInt == 1;
  }
  
  public boolean isRichIPSite(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Parcelable paramParcelable)
  {
    paramIEmoticonMainPanelApp = (CommercialDrainageManagerProxy)paramIEmoticonMainPanelApp.getManager(QQManagerFactory.COMMERCIAL_DRAINAGE_MANAGER);
    if ((paramIEmoticonMainPanelApp != null) && ((paramParcelable instanceof VipIPSiteInfo))) {
      return paramIEmoticonMainPanelApp.isRichIPSite((VipIPSiteInfo)paramParcelable);
    }
    return false;
  }
  
  public void openEmojiDetailPage(Context paramContext, IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString1, int paramInt, String paramString2, boolean paramBoolean1, Intent paramIntent, boolean paramBoolean2)
  {
    EmojiHomeUiPlugin.openEmojiDetailPage(paramContext, paramIEmoticonMainPanelApp, paramString1, 8, paramString2, paramBoolean1, paramIntent, paramBoolean2);
  }
  
  public void openEmojiDetailPage(Context paramContext, IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString1, int paramInt1, String paramString2, boolean paramBoolean1, Intent paramIntent, boolean paramBoolean2, boolean paramBoolean3, int paramInt2, String paramString3)
  {
    paramString1 = new Intent();
    if (paramBoolean3)
    {
      paramString1.putExtra("emoji_to_dressup", true);
      EmojiHomeUiPlugin.openEmojiDetailPage(paramContext, paramIEmoticonMainPanelApp, paramIEmoticonMainPanelApp.getAccount(), 8, String.valueOf(paramString3), paramBoolean1, paramString1, paramBoolean2);
      return;
    }
    if ((paramInt2 & 0x1) != 0) {}
    for (paramBoolean3 = true;; paramBoolean3 = false)
    {
      paramString1.putExtra("emoji_is_original", paramBoolean3);
      paramString1.putExtra("emoji_author_id", EmoticonRecDressup.getEmotionRecommend(paramString3, true).authorId);
      break;
    }
  }
  
  public void openQQBrowserWithoutAD(Context paramContext, String paramString, long paramLong, Intent paramIntent, boolean paramBoolean, int paramInt)
  {
    paramIntent = new Intent(paramContext, QQBrowserActivity.class);
    paramIntent.putExtra("hide_operation_bar", true);
    VasWebviewUtil.openQQBrowserWithoutAD(paramContext, paramString, -1L, paramIntent, false, -1);
  }
  
  public void pullEmoticonPackage(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, IEmoticonPackage paramIEmoticonPackage, boolean paramBoolean, int paramInt)
  {
    paramIEmoticonMainPanelApp = (EmojiManagerProxy)paramIEmoticonMainPanelApp.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER);
    if ((paramIEmoticonPackage instanceof EmoticonPackage)) {
      paramIEmoticonMainPanelApp.pullEmoticonPackage((EmoticonPackage)paramIEmoticonPackage, paramBoolean, paramInt);
    }
  }
  
  public void removeEmotionPanelPayBackListener(EmotionPanelPayBackListener paramEmotionPanelPayBackListener)
  {
    EmotionPanelPayBackListenerManager.a().b(paramEmotionPanelPayBackListener);
  }
  
  public void reportAddEmoticonPkg(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString, int paramInt)
  {
    ((EmoticonHandlerProxy)paramIEmoticonMainPanelApp.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).reportAddEmoticonPkg(paramString, paramInt);
  }
  
  public void reportCommercialDrainage(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7)
  {
    VasWebviewUtil.reportCommercialDrainage(paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramInt3, paramString5, paramString6, paramString7);
  }
  
  public void reportCommercialDrainage(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    VasWebviewUtil.reportCommercialDrainage(paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramInt3, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public void sendPayBackMessage(IEmoticonMainPanelApp paramIEmoticonMainPanelApp)
  {
    paramIEmoticonMainPanelApp = (MqqHandlerProxy)paramIEmoticonMainPanelApp.getHandler(ChatActivity.class);
    if (paramIEmoticonMainPanelApp != null) {
      paramIEmoticonMainPanelApp.sendToTarget(41);
    }
  }
  
  public void startActivityForResult(Activity paramActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public void stopEmoticonPackageDownload(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString)
  {
    ((EmojiManagerProxy)paramIEmoticonMainPanelApp.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).stopEmoticonPackageDownload(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.BigEmotionServiceImpl
 * JD-Core Version:    0.7.0.1
 */