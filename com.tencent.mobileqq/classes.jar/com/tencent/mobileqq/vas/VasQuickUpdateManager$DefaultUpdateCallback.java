package com.tencent.mobileqq.vas;

import android.content.Context;
import android.text.TextUtils;
import com.etrump.mixlayout.VasShieldFont;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.comic.api.IQQComicSoHelper;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.addon.DiyPendantFetcher;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.PokeResHandler;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.IVasEmojiManager;
import com.tencent.mobileqq.emoticon.VasEmojiManagerContstant;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.floatscr.IColorScreenManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profile.VipWZRYTemplateHelper;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.gldrawable.GLDrawableDownloadHelper;
import com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.callback.TagItemInfo;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vas.util.VasSoUtils;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.mobileqq.vip.TMSManager.DynamicLoadHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xaction.openapi.api.IXADownload;
import java.io.File;
import java.util.Vector;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VasQuickUpdateManager$DefaultUpdateCallback
  extends BaseUpdateCallback
{
  public VasQuickUpdateManager$DefaultUpdateCallback(VasQuickUpdateManager paramVasQuickUpdateManager) {}
  
  private boolean deleteFiles2(long paramLong, String paramString, boolean paramBoolean)
  {
    if (paramLong == 15L) {
      return deleteProfileCard(paramString).booleanValue();
    }
    Object localObject;
    if (paramLong == 1999L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(VasUpdateConstants.b);
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
      paramBoolean = VasUpdateUtil.a(new File(paramString));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteFiles: quickupdate test path = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" result = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("VasQuickUpdateManager", 2, ((StringBuilder)localObject).toString());
      return paramBoolean;
    }
    if (paramLong == 25L)
    {
      int i = TroopEnterEffectController.b(paramString);
      paramString = new StringBuilder();
      paramString.append(TroopEnterEffectController.a);
      paramString.append(i);
      paramString = paramString.toString();
      paramBoolean = VasUpdateUtil.a(new File(paramString));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteFiles: ENTER_EFFECT path = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" result = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("VasQuickUpdateManager", 2, ((StringBuilder)localObject).toString());
      return paramBoolean;
    }
    if (paramLong == 8L)
    {
      paramString = paramString.substring(7, paramString.length());
      localObject = (ChatBackgroundManager)this.this$0.app.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
      return VasUpdateUtil.a(new File(ChatBackgroundUtil.a(paramString)));
    }
    if (paramLong == 27L)
    {
      paramString = paramString.substring(14, paramString.length());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ColorNickManager.a);
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
      paramBoolean = VasUpdateUtil.a(new File(paramString));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteFiles: COLOR_NICK path = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" result = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("VasQuickUpdateManager", 2, ((StringBuilder)localObject).toString());
      return paramBoolean;
    }
    if (paramLong == 33L)
    {
      paramString = paramString.substring(12);
      paramBoolean = VasUpdateUtil.a(new File(ProfileCardManager.a(paramString)));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteFiles: Default Card Config id=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" ret=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("VasQuickUpdateManager", 2, ((StringBuilder)localObject).toString());
    }
    return paramBoolean;
  }
  
  @Nullable
  private Boolean deleteJsonFile(long paramLong, String paramString)
  {
    Object localObject = getItemInfo(paramLong, paramString);
    if (localObject != null)
    {
      boolean bool = VasUpdateUtil.a(new File(((TagItemInfo)localObject).c));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("deleteFiles: bid=");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(" scid=");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(", result=");
        ((StringBuilder)localObject).append(bool);
        QLog.d("VasQuickUpdateManager", 2, ((StringBuilder)localObject).toString());
      }
      return Boolean.valueOf(bool);
    }
    return Boolean.valueOf(false);
  }
  
  @Nullable
  private Boolean deleteMatriel(String paramString)
  {
    if (paramString.equals("libColorFont_818"))
    {
      paramString = new StringBuilder();
      paramString.append(VasSoUtils.a());
      paramString.append("libFounderColorFont_818.so");
      return Boolean.valueOf(VasUpdateUtil.a(new File(paramString.toString())));
    }
    if (paramString.equals("kcsdk_4_4_7_3661")) {
      return Boolean.valueOf(VasUpdateUtil.a(new File(TMSManager.b().a(this.this$0.app.getApp()))));
    }
    if (paramString.equals("GLDrawableV860")) {
      return Boolean.valueOf(VasUpdateUtil.a(new File(GLDrawableDownloadHelper.b(this.this$0.app.getApp()))));
    }
    if (paramString.equals(IXADownload.SCID)) {
      return Boolean.valueOf(VasUpdateUtil.a(((IXADownload)QRoute.api(IXADownload.class)).getInstallRoot()));
    }
    if (paramString.equals("libFlatBuffersParser"))
    {
      FlatBuffersParser.k();
      return Boolean.valueOf(true);
    }
    if (paramString.equals("libVipFont_8417"))
    {
      paramString = new StringBuilder();
      paramString.append(VasSoUtils.a());
      paramString.append("libvipfont8417.so");
      return Boolean.valueOf(VasUpdateUtil.a(new File(paramString.toString())));
    }
    if (paramString.startsWith("bqmall.android.h5magic."))
    {
      VasEmojiManagerContstant.delete(paramString);
      return Boolean.valueOf(true);
    }
    if (paramString.equals("libqgplayer_841")) {
      return Boolean.valueOf(VasUpdateUtil.a(new File(((IQQComicSoHelper)QRoute.api(IQQComicSoHelper.class)).getComicPlayerSoPath())));
    }
    if (paramString.equals("libAPNG_845"))
    {
      paramString = new StringBuilder();
      paramString.append(VasSoUtils.a());
      paramString.append("libAPNG_release_845.so");
      return Boolean.valueOf(VasUpdateUtil.a(new File(paramString.toString())));
    }
    if (paramString.equals("defaultFont_775")) {
      return Boolean.valueOf(VasUpdateUtil.a(new File(VasShieldFont.b())));
    }
    if (paramString.equals("enterEffectVipIcons"))
    {
      paramString = TroopEnterEffectController.b();
      if (!TextUtils.isEmpty(paramString)) {
        VasUpdateUtil.a(new File(paramString));
      }
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  @Nullable
  private Boolean deleteProfileCard(String paramString)
  {
    Object localObject;
    if ("cardWZ.zip".equals(paramString))
    {
      paramString = VipWZRYTemplateHelper.a();
      boolean bool = VasUpdateUtil.a(new File(paramString));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("deleteFiles: profile card path = ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" result = ");
        ((StringBuilder)localObject).append(bool);
        QLog.d("VasQuickUpdateManager", 2, ((StringBuilder)localObject).toString());
      }
      return Boolean.valueOf(bool);
    }
    if (paramString.startsWith("card."))
    {
      localObject = ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).e;
      int i = Integer.parseInt(paramString.substring(5, paramString.length()));
      return Boolean.valueOf(((ProfileCardManager)localObject).d(this.this$0.app.getApp(), i));
    }
    return Boolean.valueOf(false);
  }
  
  @Nullable
  private Boolean deleteSignature(String paramString)
  {
    if (paramString.startsWith("signature.sticker."))
    {
      paramString = paramString.substring(18, paramString.length());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_SIGNATURE_STICKER_DIR);
      localStringBuilder.append(paramString);
      boolean bool = VasUpdateUtil.a(new File(localStringBuilder.toString()));
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("deleteFiles: signature sticker path = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" result = ");
        localStringBuilder.append(bool);
        QLog.d("VasQuickUpdateManager", 2, localStringBuilder.toString());
      }
      return Boolean.valueOf(bool);
    }
    return Boolean.valueOf(false);
  }
  
  private void doOnCompleted2(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (paramLong == 1002L)
    {
      onFlashChatCompleted(paramString1, paramInt1);
      return;
    }
    if (paramLong == 15L)
    {
      onProfileCardCompleted(paramString1, paramString3, paramInt1);
      return;
    }
    if (paramLong == 21L)
    {
      onPokeCompleted(paramString1);
      return;
    }
    if ((paramLong == 25L) && (paramString1.startsWith("groupeffect_item_")))
    {
      onTroopEnterEffectCompleted(paramString1, paramInt1);
      return;
    }
    if (paramLong == 8L)
    {
      ((ChatBackgroundManager)this.this$0.app.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      return;
    }
    if (paramLong == 33L) {
      onDefaultCardCompleted(paramString1, paramInt1);
    }
  }
  
  @NotNull
  private TagItemInfo getBIdJsonInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    paramTagItemInfo.a = false;
    paramTagItemInfo.b = false;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.this$0.app.getApplication().getFilesDir());
    ((StringBuilder)localObject).append(File.separator);
    String str2 = ((StringBuilder)localObject).toString();
    String str1;
    if (paramString.equals("pendant_market_json.android.v2"))
    {
      localObject = "pendant_market.json";
      str1 = str2;
    }
    else
    {
      str1 = str2;
      localObject = paramString;
      if (paramString.startsWith("signature.item."))
      {
        str1 = str2;
        localObject = paramString;
        if (paramString.endsWith(".json"))
        {
          paramString = paramString.substring(15, paramString.length() - 5);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("getItemInfo signature id = ");
            ((StringBuilder)localObject).append(paramString);
            QLog.d("VasQuickUpdateManager", 2, ((StringBuilder)localObject).toString());
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(AppConstants.SDCARD_SIGNATURE_TEMPLATE_ROOT);
          ((StringBuilder)localObject).append(File.separator);
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(File.separator);
          str1 = ((StringBuilder)localObject).toString();
          localObject = "config.json";
        }
      }
    }
    paramString = new StringBuilder();
    paramString.append(str1);
    paramString.append((String)localObject);
    paramTagItemInfo.c = paramString.toString();
    return paramTagItemInfo;
  }
  
  private boolean getBidBubbleInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    BubbleManager localBubbleManager = (BubbleManager)this.this$0.app.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    if (paramString.startsWith("bubble.android."))
    {
      int i = localBubbleManager.c(paramString);
      if (i > 0)
      {
        paramTagItemInfo.a = false;
        if (paramString.endsWith("static.zip"))
        {
          paramTagItemInfo.b = true;
          paramString = new StringBuilder();
          paramString.append(localBubbleManager.d(i).getAbsolutePath());
          paramString.append(File.separator);
          paramString.append("static");
          paramTagItemInfo.c = paramString.toString();
          return true;
        }
        if (paramString.endsWith("other.zip"))
        {
          paramTagItemInfo.b = true;
          paramTagItemInfo.c = localBubbleManager.d(i).getAbsolutePath();
          return true;
        }
        if (paramString.endsWith("config.json"))
        {
          paramTagItemInfo.b = false;
          paramString = new StringBuilder();
          paramString.append(localBubbleManager.d(i).getAbsolutePath());
          paramString.append(File.separator);
          paramString.append("config.json");
          paramTagItemInfo.c = paramString.toString();
        }
        return true;
      }
    }
    else if (paramString.startsWith("bubble.paster."))
    {
      paramTagItemInfo.b = false;
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("bubble.paster.")))
      {
        paramString = paramString.replace("bubble.paster.", "");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localBubbleManager.b().getAbsolutePath());
        localStringBuilder.append(File.separator);
        localStringBuilder.append(paramString);
        paramTagItemInfo.c = localStringBuilder.toString();
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("download paster fileName: ");
          paramString.append(paramTagItemInfo.c);
          QLog.i("VasQuickUpdateManager", 2, paramString.toString());
        }
      }
      paramTagItemInfo.a = false;
      return true;
    }
    return false;
  }
  
  private boolean getBidColorScreenInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    IColorScreenManager localIColorScreenManager = VasUtil.b(this.this$0.app).getColorScreen();
    if (paramString.startsWith("colorScreen.android."))
    {
      int i = localIColorScreenManager.a(paramString);
      if (i > 0)
      {
        paramTagItemInfo.a = false;
        paramTagItemInfo.b = false;
        paramString = new StringBuilder();
        paramString.append(localIColorScreenManager.a(i).getAbsolutePath());
        paramString.append(File.separator);
        paramString.append("config.zip");
        paramTagItemInfo.c = paramString.toString();
        return true;
      }
    }
    return false;
  }
  
  private boolean getBidFaceInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    if (paramString.startsWith("face."))
    {
      paramString = VasFaceManager.a(paramString);
      if (paramString != null)
      {
        paramTagItemInfo.a = false;
        paramTagItemInfo.b = false;
        paramTagItemInfo.c = paramString;
        return true;
      }
    }
    else if (paramString.equals("avatarInPendant_json"))
    {
      paramTagItemInfo.a = false;
      paramTagItemInfo.b = false;
      paramString = new StringBuilder();
      paramString.append(this.this$0.app.getApplication().getFilesDir());
      paramString.append(File.separator);
      paramString.append("avatarInPendant.json");
      paramTagItemInfo.c = paramString.toString();
      return true;
    }
    return false;
  }
  
  @NotNull
  private TagItemInfo getBidFlashChatInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    FlashChatManager localFlashChatManager = (FlashChatManager)this.this$0.app.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
    paramTagItemInfo.a = false;
    paramTagItemInfo.b = false;
    paramTagItemInfo.c = localFlashChatManager.a(paramString);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getItemInfo:  result.strSavePath = ");
      paramString.append(paramTagItemInfo.c);
      QLog.d("VasQuickUpdateManager", 2, paramString.toString());
    }
    return paramTagItemInfo;
  }
  
  @Nullable
  private TagItemInfo getBidMaterialInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    paramTagItemInfo.a = false;
    paramTagItemInfo.b = false;
    if (paramString.equals("emojiStickerGuideZip_v2"))
    {
      paramString = new StringBuilder();
      paramString.append(EmojiStickerManager.c());
      paramString.append("emojiStickerGuideZip_v2.zip");
      paramTagItemInfo.c = paramString.toString();
      return paramTagItemInfo;
    }
    if (paramString.equals("libFlatBuffersParser"))
    {
      paramString = new StringBuilder();
      paramString.append(FlatBuffersParser.h());
      paramString.append("libFlatBuffersParser.zip");
      paramTagItemInfo.c = paramString.toString();
      return paramTagItemInfo;
    }
    if (paramString.equals("kcsdk_4_4_7_3661"))
    {
      paramTagItemInfo.c = TMSManager.b().b(this.this$0.app.getApp());
      return paramTagItemInfo;
    }
    if (paramString.equals("GLDrawableV860"))
    {
      paramTagItemInfo.c = GLDrawableDownloadHelper.b(this.this$0.app.getApp());
      return paramTagItemInfo;
    }
    if (paramString.equals(IXADownload.SCID))
    {
      paramTagItemInfo.c = ((IXADownload)QRoute.api(IXADownload.class)).getDownloadPath().getAbsolutePath();
      return paramTagItemInfo;
    }
    if (paramString.equals("libColorFont_818"))
    {
      paramString = new StringBuilder();
      paramString.append(FontManagerConstants.FONT_DOWN_LOAD_PATH);
      paramString.append(File.separator);
      paramString.append("libColorFont.zip");
      paramTagItemInfo.c = paramString.toString();
      return paramTagItemInfo;
    }
    if (paramString.equals("libVipFont_8417"))
    {
      paramString = new StringBuilder();
      paramString.append(FontManagerConstants.FONT_DOWN_LOAD_PATH);
      paramString.append(File.separator);
      paramString.append("libvipfont8417.so.zip");
      paramTagItemInfo.c = paramString.toString();
      return paramTagItemInfo;
    }
    if (paramString.startsWith("bqmall.android.h5magic."))
    {
      paramTagItemInfo.c = VasEmojiManagerContstant.getSavePath(paramString);
      return paramTagItemInfo;
    }
    if (paramString.equals("libqgplayer_841"))
    {
      paramTagItemInfo.c = ((IQQComicSoHelper)QRoute.api(IQQComicSoHelper.class)).getComicPlayerSoZipPath();
      return paramTagItemInfo;
    }
    if (paramString.equals("libAPNG_845"))
    {
      paramString = new StringBuilder();
      paramString.append(this.this$0.app.getApp().getApplicationContext().getFilesDir());
      paramString.append(File.separator);
      paramString.append("apng.zip");
      paramTagItemInfo.c = paramString.toString();
      return paramTagItemInfo;
    }
    if (paramString.equals("defaultFont_775"))
    {
      paramString = new StringBuilder();
      paramString.append(FontManagerConstants.FONT_DOWN_LOAD_PATH);
      paramString.append(File.separator);
      paramString.append("default.zip");
      paramTagItemInfo.c = paramString.toString();
      return paramTagItemInfo;
    }
    if (paramString.equals("enterEffectVipIcons"))
    {
      paramString = TroopEnterEffectController.b();
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("VasQuickUpdateManager", 1, "VasUpdateConstants.SCID_ENTER_EFFECT_VIP_ICONS getItemInfo null zipPath");
        return null;
      }
      paramTagItemInfo.c = paramString;
    }
    return paramTagItemInfo;
  }
  
  private boolean getBidPendantInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    if (paramString.startsWith("faceAddon.stickerFont.android."))
    {
      paramTagItemInfo.a = false;
      paramTagItemInfo.b = true;
      paramTagItemInfo.c = AvatarPendantUtil.d(paramString.replace("faceAddon.stickerFont.android.", ""));
      return true;
    }
    Object localObject;
    if (paramString.startsWith("faceAddon.sticker."))
    {
      paramTagItemInfo.a = false;
      paramTagItemInfo.b = false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(AppConstants.SDCARD_PENDANT_ROOT);
      ((StringBuilder)localObject).append("sticker_info/");
      ((StringBuilder)localObject).append(paramString.replace("faceAddon.sticker.", ""));
      paramTagItemInfo.c = ((StringBuilder)localObject).toString();
      return true;
    }
    if ((paramString.startsWith("pendant.")) && (paramString.length() > 8))
    {
      paramString = paramString.substring(8, paramString.length());
      int i = paramString.indexOf(".");
      if (i > 0)
      {
        localObject = paramString.substring(0, i);
        paramString.substring(i, paramString.length());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(AppConstants.SDCARD_PENDANT_ROOT);
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(File.separator);
        paramTagItemInfo.a = false;
        paramTagItemInfo.b = true;
        if (paramString.endsWith(".xydata.js"))
        {
          paramTagItemInfo.b = false;
          localStringBuilder.append("config.json");
        }
        if (paramString.endsWith(".aio_50.png"))
        {
          paramTagItemInfo.b = false;
          localStringBuilder.append("aio_50.png");
        }
        paramTagItemInfo.c = localStringBuilder.toString();
        return true;
      }
    }
    return false;
  }
  
  @NotNull
  private TagItemInfo getBidPokeInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    paramTagItemInfo.a = false;
    paramTagItemInfo.b = true;
    StringBuilder localStringBuilder;
    if (paramString.startsWith("poke.item.effect."))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PokeItemHelper.e);
      localStringBuilder.append(paramString.substring(17, paramString.length()));
      paramTagItemInfo.c = localStringBuilder.toString();
      return paramTagItemInfo;
    }
    if (paramString.startsWith("poke.item.res."))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PokeItemHelper.e);
      localStringBuilder.append(paramString.substring(14, paramString.length()));
      paramTagItemInfo.c = localStringBuilder.toString();
      return paramTagItemInfo;
    }
    if ("poke.effectList".equals(paramString))
    {
      paramTagItemInfo.b = false;
      paramTagItemInfo.c = PokeItemHelper.f;
    }
    return paramTagItemInfo;
  }
  
  private boolean getBidPraiseInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    PraiseManager localPraiseManager = (PraiseManager)this.this$0.app.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localPraiseManager != null)
    {
      bool1 = bool2;
      if (paramString.startsWith("praise.android."))
      {
        int i = localPraiseManager.b(paramString);
        bool1 = bool2;
        if (i > 0)
        {
          paramTagItemInfo.a = false;
          bool1 = true;
          paramTagItemInfo.b = true;
          paramTagItemInfo.c = localPraiseManager.a(i).getAbsolutePath();
        }
      }
    }
    return bool1;
  }
  
  private boolean getBidProfileCard(String paramString, TagItemInfo paramTagItemInfo)
  {
    if ("cardWZ.zip".equals(paramString))
    {
      paramTagItemInfo.a = false;
      paramTagItemInfo.b = true;
      paramTagItemInfo.c = VipWZRYTemplateHelper.a();
      return true;
    }
    if (paramString.startsWith("card."))
    {
      paramTagItemInfo.a = false;
      paramTagItemInfo.b = false;
      int i = Integer.parseInt(paramString.substring(5, paramString.length()));
      paramString = ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).e;
      paramTagItemInfo.c = ProfileCardManager.c(this.this$0.app.getApp(), i);
      return true;
    }
    return false;
  }
  
  @NotNull
  private TagItemInfo getBidQuickUpdate(String paramString, TagItemInfo paramTagItemInfo)
  {
    paramTagItemInfo.a = false;
    if (paramString.endsWith("cfg")) {
      paramTagItemInfo.a = true;
    }
    paramTagItemInfo.b = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(VasUpdateConstants.b);
    localStringBuilder.append(paramString);
    paramTagItemInfo.c = localStringBuilder.toString();
    return paramTagItemInfo;
  }
  
  @NotNull
  private TagItemInfo getBidRedPacket(long paramLong, String paramString, TagItemInfo paramTagItemInfo)
  {
    paramTagItemInfo.a = false;
    Object localObject;
    if (("iRedPacket_v3.json".equals(paramString)) || ("iRedPacket_v3.char300.json".equals(paramString)))
    {
      paramTagItemInfo.b = false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.this$0.app.getApp().getApplicationContext().getFilesDir());
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("pddata/vas/redpacket/");
      ((StringBuilder)localObject).append(paramString);
      paramTagItemInfo.c = ((StringBuilder)localObject).toString();
    }
    if ("iRedPacket_v3.font.zip".equals(paramString))
    {
      paramTagItemInfo.b = true;
      paramTagItemInfo.c = IndividualRedPacketManager.a(3);
      return paramTagItemInfo;
    }
    if ("iRedPacket_v3.specialChar.zip".equals(paramString))
    {
      paramTagItemInfo.b = true;
      paramTagItemInfo.c = IndividualRedPacketManager.a(2);
      return paramTagItemInfo;
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("luckyMoney.item.")))
    {
      paramTagItemInfo.b = true;
      localObject = IndividualRedPacketManager.a(paramString);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getItemInfo bid = ");
        localStringBuilder.append(paramLong);
        localStringBuilder.append(" scid = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" pid = ");
        localStringBuilder.append((String)localObject);
        QLog.d("VasQuickUpdateManager", 2, localStringBuilder.toString());
      }
      paramString = new StringBuilder();
      paramString.append(IndividualRedPacketManager.a(1));
      paramString.append((String)localObject);
      paramTagItemInfo.c = paramString.toString();
    }
    return paramTagItemInfo;
  }
  
  private boolean getBidSignatureInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    if (paramString.startsWith("signature.sticker."))
    {
      paramTagItemInfo.a = false;
      paramTagItemInfo.b = false;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_SIGNATURE_STICKER_DIR);
      localStringBuilder.append(paramString.substring(18, paramString.length()));
      paramTagItemInfo.c = localStringBuilder.toString();
      return true;
    }
    return false;
  }
  
  private boolean getBidTroopEnterEffect(String paramString, TagItemInfo paramTagItemInfo)
  {
    paramTagItemInfo.a = false;
    if (paramString.startsWith("groupeffect_item_"))
    {
      paramTagItemInfo.b = false;
      int i = TroopEnterEffectController.b(paramString);
      paramString = new StringBuilder();
      paramString.append(TroopEnterEffectController.a);
      paramString.append(i);
      paramString.append(File.separator);
      paramString.append(i);
      paramString.append(".zip");
      paramTagItemInfo.c = paramString.toString();
      return true;
    }
    return false;
  }
  
  private boolean getItemInfo2(long paramLong, String paramString, TagItemInfo paramTagItemInfo)
  {
    if (paramLong == 9L) {
      return getBidSignatureInfo(paramString, paramTagItemInfo);
    }
    if (paramLong == 22L) {
      return getBidColorScreenInfo(paramString, paramTagItemInfo);
    }
    if (paramLong == 23L) {
      return getBidFaceInfo(paramString, paramTagItemInfo);
    }
    if (paramLong == 2L) {
      return getBidBubbleInfo(paramString, paramTagItemInfo);
    }
    if (paramLong == 4L) {
      return getBidPendantInfo(paramString, paramTagItemInfo);
    }
    if (paramLong == 20L) {
      return getBidPraiseInfo(paramString, paramTagItemInfo);
    }
    if (paramLong == 25L) {
      return getBidTroopEnterEffect(paramString, paramTagItemInfo);
    }
    return false;
  }
  
  @Nullable
  private Boolean isBubbleExist(String paramString)
  {
    BubbleManager localBubbleManager = (BubbleManager)this.this$0.app.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    if (localBubbleManager != null)
    {
      if (paramString.startsWith("bubble.android.")) {
        return Boolean.valueOf(localBubbleManager.b(paramString));
      }
      if (paramString.startsWith("bubble.paster.")) {
        return Boolean.valueOf(localBubbleManager.a(paramString));
      }
    }
    return null;
  }
  
  @Nullable
  private Boolean isColorScreenExist(String paramString)
  {
    if (paramString.startsWith("colorScreen.android.")) {
      return Boolean.valueOf(VasUtil.b(this.this$0.app).getColorScreen().b(paramString));
    }
    return null;
  }
  
  @Nullable
  private Boolean isExist(long paramLong, String paramString)
  {
    if (paramLong == 2L) {
      return isBubbleExist(paramString);
    }
    if (paramLong == 22L) {
      return isColorScreenExist(paramString);
    }
    if (paramLong == 23L) {
      return isFaceExist(paramString);
    }
    if (paramLong == 4L) {
      return isPendantExist(paramString);
    }
    if (paramLong == 15L) {
      return isProfileCardExist(paramString);
    }
    if (paramLong == 21L) {
      return isPokeExist(paramString);
    }
    if (paramLong == 1004L) {
      return isMaterialExist(paramString);
    }
    if (paramLong == 25L) {
      return isTroopEnterEffectExist(paramString);
    }
    if (paramLong == 9L) {
      return isSignatureExist(paramString);
    }
    return null;
  }
  
  @Nullable
  private Boolean isFaceExist(String paramString)
  {
    VasFaceManager localVasFaceManager = ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).c;
    if (paramString.startsWith("face.")) {
      return Boolean.valueOf(localVasFaceManager.b(paramString));
    }
    if (paramString.equals("avatarInPendant_json"))
    {
      paramString = new StringBuilder();
      paramString.append(this.this$0.app.getApplication().getFilesDir());
      paramString.append(File.separator);
      paramString.append("avatarInPendant.json");
      return Boolean.valueOf(new File(paramString.toString()).exists());
    }
    return null;
  }
  
  @Nullable
  private Boolean isMaterialExist(String paramString)
  {
    if (paramString.startsWith("libColorFont_818"))
    {
      paramString = new StringBuilder();
      paramString.append(VasSoUtils.a());
      paramString.append("libFounderColorFont_818.so");
      return Boolean.valueOf(new File(paramString.toString()).exists());
    }
    if (paramString.startsWith("libFlatBuffersParser"))
    {
      paramString = new StringBuilder();
      paramString.append(FlatBuffersParser.h());
      paramString.append("libFlatBuffersParser.zip");
      return Boolean.valueOf(new File(paramString.toString()).exists());
    }
    if (paramString.equals("kcsdk_4_4_7_3661")) {
      return Boolean.valueOf(new File(TMSManager.b().a(this.this$0.app.getApp())).exists());
    }
    if (paramString.equals("GLDrawableV860")) {
      return Boolean.valueOf(GLDrawableDownloadHelper.a(this.this$0.app.getApp()));
    }
    if (paramString.equals(IXADownload.SCID)) {
      return Boolean.valueOf(((IXADownload)QRoute.api(IXADownload.class)).isNoNeedDownload());
    }
    if (paramString.equals("emojiStickerGuideZip_v2"))
    {
      paramString = new StringBuilder();
      paramString.append(EmojiStickerManager.c());
      paramString.append("emojiStickerGuideZip_v2.zip");
      return Boolean.valueOf(new File(paramString.toString()).exists());
    }
    if (paramString.equals("libVipFont_8417"))
    {
      paramString = new StringBuilder();
      paramString.append(VasSoUtils.a());
      paramString.append("libvipfont8417.so");
      return Boolean.valueOf(new File(paramString.toString()).exists());
    }
    if (paramString.startsWith("bqmall.android.h5magic.")) {
      return Boolean.valueOf(new File(VasEmojiManagerContstant.getSavePath(paramString)).exists());
    }
    if (paramString.equals("libqgplayer_841")) {
      return Boolean.valueOf(new File(((IQQComicSoHelper)QRoute.api(IQQComicSoHelper.class)).getComicPlayerSoPath()).exists());
    }
    if (paramString.equals("libAPNG_845")) {
      return Boolean.valueOf(VasApngIPCModule.a().d());
    }
    if (paramString.equals("defaultFont_775"))
    {
      paramString = new StringBuilder();
      paramString.append(VasSoUtils.a());
      paramString.append(VasShieldFont.a);
      paramString = new File(paramString.toString());
      boolean bool;
      if ((paramString.exists()) && (paramString.isDirectory())) {
        bool = true;
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
    if (paramString.equals("enterEffectVipIcons")) {
      return VasQuickUpdateManager.access$100(this.this$0);
    }
    return null;
  }
  
  @Nullable
  private Boolean isPendantExist(String paramString)
  {
    if (paramString.startsWith("faceAddon.stickerFont.android.")) {
      return Boolean.valueOf(AvatarPendantUtil.b(paramString.replace("faceAddon.stickerFont.android.", "")));
    }
    if (paramString.startsWith("faceAddon.sticker.")) {
      return Boolean.valueOf(AvatarPendantUtil.e(paramString));
    }
    if ((paramString.startsWith("pendant.")) && (paramString.length() > 8))
    {
      paramString = paramString.substring(8);
      int i = paramString.indexOf(".");
      if (i <= 0) {
        return null;
      }
      String str = paramString.substring(0, i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_PENDANT_ROOT);
      localStringBuilder.append(str);
      localStringBuilder.append(File.separator);
      if (paramString.endsWith(".xydata.js")) {
        localStringBuilder.append("config.json");
      } else if (paramString.endsWith(".aio_50.png")) {
        localStringBuilder.append("aio_50.png");
      } else if (paramString.endsWith(".other.zip")) {
        localStringBuilder.append("aio_file");
      }
      return VasQuickUpdateManager.access$300(this.this$0, paramString, localStringBuilder);
    }
    return null;
  }
  
  @Nullable
  private Boolean isPokeExist(String paramString)
  {
    boolean bool3 = paramString.startsWith("poke.item.effect.");
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool3) {
      paramString = paramString.substring(17, paramString.length());
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
    }
    catch (Exception paramString)
    {
      int i;
      label41:
      break label41;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateManager", 2, "id error");
    }
    i = -1;
    if (i != -1) {
      bool1 = PokeItemHelper.a("effect.gif", i);
    }
    return Boolean.valueOf(bool1);
    if (paramString.startsWith("poke.item.res.")) {
      paramString = paramString.substring(14, paramString.length());
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
    }
    catch (Exception paramString)
    {
      label111:
      break label111;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateManager", 2, "id error");
    }
    i = -1;
    if (i == -1) {
      bool1 = bool2;
    } else {
      bool1 = PokeItemHelper.a("bubble", i);
    }
    return Boolean.valueOf(bool1);
    if ("poke.effectList".equals(paramString)) {
      return Boolean.valueOf(new File(PokeItemHelper.f).exists());
    }
    return null;
  }
  
  @Nullable
  private Boolean isProfileCardExist(String paramString)
  {
    if ("cardWZ.zip".equals(paramString)) {
      return Boolean.valueOf(VipWZRYTemplateHelper.a(paramString));
    }
    if (paramString.startsWith("card."))
    {
      int i = Integer.parseInt(paramString.substring(5, paramString.length()));
      paramString = ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).e;
      return Boolean.valueOf(ProfileCardManager.b(this.this$0.app.getApp(), i));
    }
    return null;
  }
  
  private boolean isRedPacketExist(String paramString)
  {
    boolean bool1 = "iRedPacket_v3.json".equals(paramString);
    boolean bool2 = false;
    Object localObject = null;
    if ((!bool1) && (!"iRedPacket_v3.char300.json".equals(paramString)))
    {
      if ("iRedPacket_v3.font.zip".equals(paramString))
      {
        paramString = IndividualRedPacketManager.a(null, null, 8, 0, 0);
      }
      else if ("iRedPacket_v3.specialChar.zip".equals(paramString))
      {
        paramString = IndividualRedPacketManager.a(null, null, 25, 0, 0);
      }
      else
      {
        if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("luckyMoney.item.")))
        {
          paramString = IndividualRedPacketManager.a(paramString);
          if (!TextUtils.isEmpty(paramString)) {
            return VasQuickUpdateManager.access$200(this.this$0, paramString);
          }
        }
        paramString = null;
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.this$0.app.getApp().getApplicationContext().getFilesDir());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("pddata/vas/redpacket/");
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = localObject;
    } else {
      paramString = new File(paramString);
    }
    bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.exists()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @Nullable
  private Boolean isSignatureExist(String paramString)
  {
    if (paramString.startsWith("signature.sticker."))
    {
      paramString = paramString.substring(18, paramString.length());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_SIGNATURE_STICKER_DIR);
      localStringBuilder.append(paramString);
      return Boolean.valueOf(new File(localStringBuilder.toString()).exists());
    }
    return null;
  }
  
  @Nullable
  private Boolean isTroopEnterEffectExist(String paramString)
  {
    int i = TroopEnterEffectController.b(paramString);
    if (i > 0)
    {
      paramString = new StringBuilder();
      paramString.append(TroopEnterEffectController.a);
      paramString.append(i);
      return Boolean.valueOf(TroopGiftUtil.a(new File(paramString.toString())));
    }
    return null;
  }
  
  private void onBubbleCompleted(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    BubbleManager localBubbleManager = (BubbleManager)this.this$0.app.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    if (paramString1.startsWith("bubble.android."))
    {
      localBubbleManager.b(paramString1, paramString2, paramString3, paramInt1, paramInt2);
      return;
    }
    if (paramString1.startsWith("bubble.paster.")) {
      localBubbleManager.a(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
  }
  
  private void onColorScreenCompleted(String paramString, int paramInt)
  {
    IColorScreenManager localIColorScreenManager = VasUtil.b(this.this$0.app).getColorScreen();
    if (paramString.startsWith("colorScreen.android.")) {
      localIColorScreenManager.a(paramString, paramInt);
    }
  }
  
  private void onDefaultCardCompleted(String paramString, int paramInt)
  {
    if (paramString.startsWith("profileitem."))
    {
      Object localObject = ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).e;
      int i = Integer.parseInt(paramString.substring(12));
      ((ProfileCardManager)localObject).i.remove(Integer.valueOf(i));
      if (paramInt == 0)
      {
        ((ProfileCardManager)localObject).a(i, false);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCompleted: default card download error: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" scid=");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("VasQuickUpdateManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void onFaceCompleted(String paramString, int paramInt)
  {
    VasFaceManager localVasFaceManager = ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).c;
    if (paramString.startsWith("face.")) {
      localVasFaceManager.a(paramString, paramInt);
    }
  }
  
  private void onFlashChatCompleted(String paramString, int paramInt)
  {
    FlashChatManager localFlashChatManager = (FlashChatManager)this.this$0.app.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
    if (localFlashChatManager != null) {
      localFlashChatManager.a(paramString, paramInt);
    }
  }
  
  private void onJsonCompleted(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCompleted emoji keyword errorCode = ");
      localStringBuilder.append(paramInt);
      QLog.d("VasQuickUpdateManager", 2, localStringBuilder.toString());
    }
    if (paramInt != 0) {
      return;
    }
    VasQuickUpdateManager.access$600(this.this$0, paramString, paramInt);
    VasQuickUpdateManager.access$700(this.this$0, paramString);
  }
  
  private boolean onMaterialCompleted(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCompleted sticker material ,errorCode = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", app=");
      boolean bool;
      if (this.this$0.app != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("VasQuickUpdateManager", 2, localStringBuilder.toString());
    }
    if (paramInt == 0) {
      if (paramString.equals("emojiStickerGuideZip_v2")) {
        EmojiStickerManager.b();
      } else if (paramString.equals("libFlatBuffersParser")) {
        FlatBuffersParser.i();
      }
    }
    if (paramString.equals("libColorFont_818")) {
      ((IFontManagerService)this.this$0.app.getRuntimeService(IFontManagerService.class, "")).onSoDownloadCompleted(4, paramInt);
    } else if (paramString.equals("libVipFont_8417")) {
      ((IFontManagerService)this.this$0.app.getRuntimeService(IFontManagerService.class, "")).onSoDownloadCompleted(1, paramInt);
    } else if (paramString.startsWith("bqmall.android.h5magic.")) {
      ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).b.complete(paramString, paramInt);
    }
    return VasQuickUpdateManager.access$500(this.this$0, paramString, paramInt);
  }
  
  private void onPokeCompleted(String paramString)
  {
    if ("poke.effectList".equals(paramString))
    {
      paramString = (IEarlyDownloadService)this.this$0.app.getRuntimeService(IEarlyDownloadService.class, "");
      if (paramString != null)
      {
        paramString = (PokeResHandler)paramString.getEarlyHandler("qq.android.poke.res_0625");
        if (paramString != null) {
          paramString.w();
        }
      }
    }
  }
  
  private void onProfileCardCompleted(String paramString1, String paramString2, int paramInt)
  {
    if ("cardWZ.zip".equals(paramString1))
    {
      VipWZRYTemplateHelper.a(this.this$0.app, paramString1, paramString2, paramInt);
      return;
    }
    if (paramString1.startsWith("card.")) {
      ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).e.a(this.this$0.app, paramString1, paramString2, paramInt);
    }
  }
  
  private void onTroopEnterEffectCompleted(String paramString, int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = TroopEnterEffectController.b(paramString);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("download Res onCompleted success id = ");
        paramString.append(paramInt);
        QLog.d("TroopEnterEffect", 2, paramString.toString());
      }
      if (paramInt > 0)
      {
        paramString = TroopEnterEffectController.a(paramInt);
        try
        {
          if (new File(paramString).exists())
          {
            FileUtils.uncompressZip(paramString, TroopEnterEffectController.a, false);
            return;
          }
        }
        catch (Exception paramString)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Res Download unCompress error: ");
          localStringBuilder.append(paramString.getLocalizedMessage());
          QLog.e("TroopEnterEffect", 1, localStringBuilder.toString());
        }
      }
    }
  }
  
  private void pendantCompleted(String paramString, int paramInt)
  {
    if (paramString.startsWith("faceAddon.stickerFont.android."))
    {
      if (paramInt == 0) {
        DiyPendantFetcher.a().b(paramString);
      }
    }
    else if (paramString.startsWith("faceAddon.sticker."))
    {
      if (paramInt == 0) {
        DiyPendantFetcher.a().a(paramString);
      }
    }
    else if ((paramString.startsWith("pendant.")) && (paramString.length() > 8))
    {
      paramString = paramString.substring(8, paramString.length());
      paramInt = paramString.indexOf(".");
      if (paramInt > 0)
      {
        long l = Long.parseLong(paramString.substring(0, paramInt));
        AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.this$0.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
        if (paramString.endsWith(".xydata.js"))
        {
          localAvatarPendantManager.a(l).a(PendantInfo.h);
          return;
        }
        if (paramString.endsWith(".aio_50.png"))
        {
          localAvatarPendantManager.a(l).b(l, 1);
          return;
        }
        if (paramString.endsWith(".other.zip")) {
          localAvatarPendantManager.a(l).b(l, 2);
        }
      }
    }
  }
  
  private void sonicTemplateCompleted(String paramString, int paramInt)
  {
    if ((paramInt == 0) && ("sonicTemplateUpdate.json".equals(paramString)))
    {
      paramString = (SonicTemplateUpdateManager)this.this$0.app.getManager(QQManagerFactory.SONIC_FILE_DISCARD_MANAGER);
      if (paramString != null) {
        paramString.a();
      }
    }
  }
  
  public boolean deleteFiles(long paramLong, String paramString)
  {
    if ((paramLong != 1000L) && (paramLong != 1003L) && (paramLong != 21L) && (paramLong != 2L) && (paramLong != 16L) && (paramLong != 20L) && (paramLong != 4L) && (paramLong != 23L))
    {
      if (paramLong == 1004L)
      {
        bool = deleteMatriel(paramString).booleanValue();
      }
      else if (paramLong == 9L)
      {
        bool = deleteSignature(paramString).booleanValue();
      }
      else
      {
        if ((paramLong == 22L) && (paramString.startsWith("colorScreen.android."))) {
          VasUtil.b(this.this$0.app).getColorScreen().c(paramString);
        }
        bool = false;
      }
    }
    else {
      bool = deleteJsonFile(paramLong, paramString).booleanValue();
    }
    boolean bool = deleteFiles2(paramLong, paramString, bool);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("deleteFiles : bid = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" scid = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" result:");
    localStringBuilder.append(bool);
    QLog.e("VasQuickUpdateManager", 1, localStringBuilder.toString());
    return bool;
  }
  
  public void doOnCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if ((!QLog.isColorLevel()) && (paramInt1 == 0)) {
      break label120;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCompleted bid = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" scid = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" from = ");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(" errorCode = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" httpCode = ");
    localStringBuilder.append(paramInt2);
    QLog.d("VasQuickUpdateManager", 2, localStringBuilder.toString());
    label120:
    if (paramLong == 1000L)
    {
      onJsonCompleted(paramString1, paramInt1);
    }
    else if (paramLong == 2L)
    {
      onBubbleCompleted(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    else if (paramLong == 22L)
    {
      onColorScreenCompleted(paramString1, paramInt1);
    }
    else if (paramLong == 23L)
    {
      onFaceCompleted(paramString1, paramInt1);
    }
    else
    {
      if (paramLong == 4L)
      {
        pendantCompleted(paramString1, paramInt1);
        return;
      }
      if (paramLong == 1001L) {
        sonicTemplateCompleted(paramString1, paramInt1);
      } else if (paramLong == 20L) {
        ((PraiseManager)this.this$0.app.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER)).a(paramString1, paramString2, paramString3, paramInt1, paramInt2);
      } else if ((paramLong == 1004L) && (onMaterialCompleted(paramString1, paramInt1))) {
        return;
      }
    }
    doOnCompleted2(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2);
    this.this$0.callBackToAll(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2);
  }
  
  public void doOnProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (paramLong1 == 2L) {
      ((BubbleManager)this.this$0.app.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER)).a(paramString1, paramString2, paramLong2, paramLong3);
    }
    if ((paramLong1 == 1004L) && (paramString1.startsWith("bqmall.android.h5magic."))) {
      ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).b.onProgress(paramString1, paramLong2, paramLong3);
    }
    if (paramLong1 == 15L)
    {
      if (paramString1.startsWith("card.")) {
        ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).e.a(Integer.parseInt(paramString1.substring(5, paramString1.length())), (int)(paramLong2 * 100L / paramLong3));
      }
    }
    else if (paramLong1 == 8L) {
      ((ChatBackgroundManager)this.this$0.app.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.this$0.app, paramLong1, paramString1, (int)(100L * paramLong2 / paramLong3));
    }
    this.this$0.onProgressToAll(paramLong1, paramString1, paramString2, paramLong2, paramLong3);
  }
  
  public long getBID()
  {
    return 0L;
  }
  
  public TagItemInfo getItemInfo(long paramLong, String paramString)
  {
    TagItemInfo localTagItemInfo = new TagItemInfo();
    if ((paramLong != 1000L) && (paramLong != 1001L))
    {
      if (paramLong == 1002L) {
        return getBidFlashChatInfo(paramString, localTagItemInfo);
      }
      if (paramLong == 16L) {
        return getBidRedPacket(paramLong, paramString, localTagItemInfo);
      }
      if (paramLong == 1004L) {
        return getBidMaterialInfo(paramString, localTagItemInfo);
      }
      if (paramLong == 15L)
      {
        if (getBidProfileCard(paramString, localTagItemInfo)) {
          return localTagItemInfo;
        }
      }
      else
      {
        if (paramLong == 21L) {
          return getBidPokeInfo(paramString, localTagItemInfo);
        }
        if (paramLong == 1999L) {
          return getBidQuickUpdate(paramString, localTagItemInfo);
        }
      }
      if (VasQuickUpdateManager.access$400(this.this$0, paramLong, paramString, localTagItemInfo)) {
        return localTagItemInfo;
      }
      if (getItemInfo2(paramLong, paramString, localTagItemInfo)) {
        return localTagItemInfo;
      }
      return null;
    }
    return getBIdJsonInfo(paramString, localTagItemInfo);
  }
  
  public boolean isFileExists(long paramLong, String paramString)
  {
    if (paramLong == 1000L) {
      return new File(this.this$0.app.getApplication().getFilesDir(), paramString).exists();
    }
    if (paramLong == 20L) {
      return ((PraiseManager)this.this$0.app.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER)).a(paramString);
    }
    if (paramLong == 1003L) {
      return new File(this.this$0.app.getApplication().getFilesDir(), paramString).exists();
    }
    if (paramLong == 16L) {
      return isRedPacketExist(paramString);
    }
    if (paramLong == 1999L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(VasUpdateConstants.b);
      localStringBuilder.append(paramString);
      return new File(localStringBuilder.toString()).exists();
    }
    if (paramLong == 8L)
    {
      paramString = paramString.substring(7, paramString.length());
      return ((ChatBackgroundManager)this.this$0.app.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).f(paramString);
    }
    if (paramLong == 27L) {
      return new File(ColorNickManager.a(paramString.substring(14, paramString.length()))).exists();
    }
    if (paramLong == 33L) {
      return new File(ProfileCardManager.a(paramString.substring(12))).exists();
    }
    paramString = isExist(paramLong, paramString);
    if (paramString != null) {
      return paramString.booleanValue();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager.DefaultUpdateCallback
 * JD-Core Version:    0.7.0.1
 */