package com.tencent.mobileqq.vas;

import android.content.Context;
import android.text.TextUtils;
import com.etrump.mixlayout.FontManager;
import com.etrump.mixlayout.VasShieldFont;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.addon.DiyPendantFetcher;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.PokeResHandler;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.VasEmojiManager;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.floatscr.ColorScreenManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profile.VipWZRYTemplateHelper;
import com.tencent.mobileqq.profile.diy.VipProfileDiyCardConfig;
import com.tencent.mobileqq.profile.like.PraiseConfigHelper;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vas.gldrawable.GLDrawableDownloadHelper;
import com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.callback.TagItemInfo;
import com.tencent.mobileqq.vas.util.VasSoUtils;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.mobileqq.vip.TMSManager.DynamicLoadHelper;
import com.tencent.mobileqq.voicechange.VoiceChangeManager;
import com.tencent.mobileqq.webview.WebViewTitleStyleHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicNavConfigHelper;
import cooperation.comic.VipComicSoHelper;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VasQuickUpdateManager$DefaultUpdateCallback
  extends BaseUpdateCallback
{
  public VasQuickUpdateManager$DefaultUpdateCallback(VasQuickUpdateManager paramVasQuickUpdateManager) {}
  
  @Nullable
  private Boolean deleteJsonFile(long paramLong, String paramString)
  {
    TagItemInfo localTagItemInfo = getItemInfo(paramLong, paramString);
    if (localTagItemInfo != null)
    {
      boolean bool = VasUpdateUtil.a(new File(localTagItemInfo.jdField_a_of_type_JavaLangString));
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "deleteFiles: bid=" + paramLong + " scid=" + paramString + ", result=" + bool);
      }
      return Boolean.valueOf(bool);
    }
    return Boolean.valueOf(false);
  }
  
  @Nullable
  private Boolean deleteMatriel(String paramString)
  {
    if (paramString.equals("libColorFont_818")) {
      return Boolean.valueOf(VasUpdateUtil.a(new File(VasSoUtils.a() + "libFounderColorFont_818.so")));
    }
    if (paramString.equals("kcsdk_4_4_7_3661")) {
      return Boolean.valueOf(VasUpdateUtil.a(new File(TMSManager.a().a(this.this$0.app.getApp()))));
    }
    if (paramString.equals("GLDrawableV8417")) {
      return Boolean.valueOf(VasUpdateUtil.a(GLDrawableDownloadHelper.a(this.this$0.app.getApp())));
    }
    if (paramString.equals("libFlatBuffersParser"))
    {
      FlatBuffersParser.g();
      return Boolean.valueOf(true);
    }
    if (paramString.equals("libVipFont_8417")) {
      return Boolean.valueOf(VasUpdateUtil.a(new File(VasSoUtils.a() + "libvipfont8417.so")));
    }
    if (paramString.startsWith("bqmall.android.h5magic."))
    {
      VasEmojiManager.a(paramString);
      return Boolean.valueOf(true);
    }
    if (paramString.equals("libqgplayer_841")) {
      return Boolean.valueOf(VasUpdateUtil.a(new File(VipComicSoHelper.a() + "libqgplayer_841.so")));
    }
    if (paramString.equals("libAPNG_845")) {
      return Boolean.valueOf(VasUpdateUtil.a(new File(VasSoUtils.a() + "libAPNG_release_845.so")));
    }
    if (paramString.equals("defaultFont_775")) {
      return Boolean.valueOf(VasUpdateUtil.a(new File(VasShieldFont.a())));
    }
    if (paramString.equals("enterEffectVipIcons"))
    {
      paramString = TroopEnterEffectController.a();
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
    if ("cardWZ.zip".equals(paramString))
    {
      paramString = VipWZRYTemplateHelper.a(this.this$0.app.getApp());
      boolean bool = VasUpdateUtil.a(new File(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "deleteFiles: profile card path = " + paramString + " result = " + bool);
      }
      return Boolean.valueOf(bool);
    }
    if (paramString.startsWith("card."))
    {
      ProfileCardManager localProfileCardManager = ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_ComTencentMobileqqProfileProfileCardManager;
      int i = Integer.parseInt(paramString.substring("card.".length(), paramString.length()));
      return Boolean.valueOf(localProfileCardManager.b(this.this$0.app.getApp(), i));
    }
    return Boolean.valueOf(false);
  }
  
  @Nullable
  private Boolean deleteSignature(String paramString)
  {
    if (paramString.startsWith("signature.sticker."))
    {
      paramString = paramString.substring("signature.sticker.".length(), paramString.length());
      boolean bool = VasUpdateUtil.a(new File(AppConstants.SDCARD_SIGNATURE_STICKER_DIR + paramString));
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "deleteFiles: signature sticker path = " + paramString + " result = " + bool);
      }
      return Boolean.valueOf(bool);
    }
    return Boolean.valueOf(false);
  }
  
  @NotNull
  private TagItemInfo getBIdJsonInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    paramTagItemInfo.jdField_a_of_type_Boolean = false;
    paramTagItemInfo.b = false;
    String str3 = this.this$0.app.getApplication().getFilesDir() + File.separator;
    String str1;
    String str2;
    if (paramString.equals("pendant_market_json.android.v2"))
    {
      str1 = "pendant_market.json";
      str2 = str3;
    }
    for (;;)
    {
      paramTagItemInfo.jdField_a_of_type_JavaLangString = (str2 + str1);
      return paramTagItemInfo;
      str2 = str3;
      str1 = paramString;
      if (paramString.startsWith("signature.item."))
      {
        str2 = str3;
        str1 = paramString;
        if (paramString.endsWith(".json"))
        {
          paramString = paramString.substring("signature.item.".length(), paramString.length() - 5);
          if (QLog.isColorLevel()) {
            QLog.d("VasQuickUpdateManager", 2, "getItemInfo signature id = " + paramString);
          }
          str1 = "config.json";
          str2 = AppConstants.SDCARD_SIGNATURE_TEMPLATE_ROOT + File.separator + paramString + File.separator;
        }
      }
    }
  }
  
  private boolean getBidBubbleInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    BubbleManager localBubbleManager = (BubbleManager)this.this$0.app.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    if (paramString.startsWith("bubble.android."))
    {
      int i = localBubbleManager.a(paramString);
      if (i > 0)
      {
        paramTagItemInfo.jdField_a_of_type_Boolean = false;
        if (paramString.endsWith("static.zip"))
        {
          paramTagItemInfo.b = true;
          paramTagItemInfo.jdField_a_of_type_JavaLangString = (localBubbleManager.a(i).getAbsolutePath() + File.separator + "static");
        }
        for (;;)
        {
          return true;
          if (paramString.endsWith("other.zip"))
          {
            paramTagItemInfo.b = true;
            paramTagItemInfo.jdField_a_of_type_JavaLangString = localBubbleManager.a(i).getAbsolutePath();
          }
          else if (paramString.endsWith("config.json"))
          {
            paramTagItemInfo.b = false;
            paramTagItemInfo.jdField_a_of_type_JavaLangString = (localBubbleManager.a(i).getAbsolutePath() + File.separator + "config.json");
          }
        }
      }
    }
    else if (paramString.startsWith("bubble.paster."))
    {
      paramTagItemInfo.b = false;
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("bubble.paster.")))
      {
        paramString = paramString.replace("bubble.paster.", "");
        paramTagItemInfo.jdField_a_of_type_JavaLangString = (localBubbleManager.b().getAbsolutePath() + File.separator + paramString);
        if (QLog.isColorLevel()) {
          QLog.i("VasQuickUpdateManager", 2, "download paster fileName: " + paramTagItemInfo.jdField_a_of_type_JavaLangString);
        }
      }
      paramTagItemInfo.jdField_a_of_type_Boolean = false;
      return true;
    }
    return false;
  }
  
  private boolean getBidColorScreenInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    ColorScreenManager localColorScreenManager = ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_ComTencentMobileqqFloatscrColorScreenManager;
    if (paramString.startsWith("colorScreen.android."))
    {
      int i = localColorScreenManager.a(paramString);
      if (i > 0)
      {
        paramTagItemInfo.jdField_a_of_type_Boolean = false;
        paramTagItemInfo.b = false;
        paramTagItemInfo.jdField_a_of_type_JavaLangString = (localColorScreenManager.a(i).getAbsolutePath() + File.separator + "config.zip");
        return true;
      }
    }
    return false;
  }
  
  @NotNull
  private TagItemInfo getBidComicInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    paramTagItemInfo.jdField_a_of_type_Boolean = false;
    if (paramString.equals("vipComic_nav_config.json"))
    {
      paramTagItemInfo.b = false;
      paramTagItemInfo.jdField_a_of_type_JavaLangString = VipComicNavConfigHelper.b().getAbsolutePath();
    }
    while (!paramString.equals("vipComic_nav_tabIcon.zip")) {
      return paramTagItemInfo;
    }
    paramTagItemInfo.b = true;
    paramTagItemInfo.jdField_a_of_type_JavaLangString = VipComicNavConfigHelper.c().getAbsolutePath();
    return paramTagItemInfo;
  }
  
  private boolean getBidFaceInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    if (paramString.startsWith("face."))
    {
      paramString = VasFaceManager.a(paramString);
      if (paramString != null)
      {
        paramTagItemInfo.jdField_a_of_type_Boolean = false;
        paramTagItemInfo.b = false;
        paramTagItemInfo.jdField_a_of_type_JavaLangString = paramString;
        return true;
      }
    }
    else if (paramString.equals("avatarInPendant_json"))
    {
      paramTagItemInfo.jdField_a_of_type_Boolean = false;
      paramTagItemInfo.b = false;
      paramTagItemInfo.jdField_a_of_type_JavaLangString = (this.this$0.app.getApplication().getFilesDir() + File.separator + "avatarInPendant.json");
      return true;
    }
    return false;
  }
  
  @NotNull
  private TagItemInfo getBidFlashChatInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    FlashChatManager localFlashChatManager = (FlashChatManager)this.this$0.app.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
    paramTagItemInfo.jdField_a_of_type_Boolean = false;
    paramTagItemInfo.b = false;
    paramTagItemInfo.jdField_a_of_type_JavaLangString = localFlashChatManager.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateManager", 2, "getItemInfo:  result.strSavePath = " + paramTagItemInfo.jdField_a_of_type_JavaLangString);
    }
    return paramTagItemInfo;
  }
  
  @Nullable
  private TagItemInfo getBidMaterialInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    paramTagItemInfo.jdField_a_of_type_Boolean = false;
    paramTagItemInfo.b = false;
    if (paramString.equals("emojiStickerGuideZip_v2")) {
      paramTagItemInfo.jdField_a_of_type_JavaLangString = (EmojiStickerManager.a() + "emojiStickerGuideZip_v2.zip");
    }
    do
    {
      return paramTagItemInfo;
      if (paramString.equals("libFlatBuffersParser"))
      {
        paramTagItemInfo.jdField_a_of_type_JavaLangString = (FlatBuffersParser.a() + "libFlatBuffersParser.zip");
        return paramTagItemInfo;
      }
      if (paramString.equals("kcsdk_4_4_7_3661"))
      {
        paramTagItemInfo.jdField_a_of_type_JavaLangString = TMSManager.a().b(this.this$0.app.getApp());
        return paramTagItemInfo;
      }
      if (paramString.equals("GLDrawableV8417"))
      {
        paramTagItemInfo.jdField_a_of_type_JavaLangString = GLDrawableDownloadHelper.a(this.this$0.app.getApp());
        return paramTagItemInfo;
      }
      if (paramString.equals("libColorFont_818"))
      {
        paramTagItemInfo.jdField_a_of_type_JavaLangString = (FontManager.jdField_a_of_type_JavaLangString + File.separator + "libColorFont.zip");
        return paramTagItemInfo;
      }
      if (paramString.equals("libVipFont_8417"))
      {
        paramTagItemInfo.jdField_a_of_type_JavaLangString = (FontManager.jdField_a_of_type_JavaLangString + File.separator + "libvipfont8417.so.zip");
        return paramTagItemInfo;
      }
      if (paramString.startsWith("bqmall.android.h5magic."))
      {
        paramTagItemInfo.jdField_a_of_type_JavaLangString = VasEmojiManager.b(paramString);
        return paramTagItemInfo;
      }
      if (paramString.equals("libqgplayer_841"))
      {
        paramTagItemInfo.jdField_a_of_type_JavaLangString = (VipComicSoHelper.a() + "libQGamePlayer.zip");
        return paramTagItemInfo;
      }
      if (paramString.equals("libAPNG_845"))
      {
        paramTagItemInfo.jdField_a_of_type_JavaLangString = (this.this$0.app.getApp().getApplicationContext().getFilesDir() + File.separator + "apng.zip");
        return paramTagItemInfo;
      }
      if (paramString.equals("defaultFont_775"))
      {
        paramTagItemInfo.jdField_a_of_type_JavaLangString = (FontManager.jdField_a_of_type_JavaLangString + File.separator + "default.zip");
        return paramTagItemInfo;
      }
    } while (!paramString.equals("enterEffectVipIcons"));
    paramString = TroopEnterEffectController.a();
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("VasQuickUpdateManager", 1, "VasUpdateConstants.SCID_ENTER_EFFECT_VIP_ICONS getItemInfo null zipPath");
      return null;
    }
    paramTagItemInfo.jdField_a_of_type_JavaLangString = paramString;
    return paramTagItemInfo;
  }
  
  private boolean getBidPendantInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    if (paramString.startsWith("faceAddon.stickerFont.android."))
    {
      paramTagItemInfo.jdField_a_of_type_Boolean = false;
      paramTagItemInfo.b = true;
      paramTagItemInfo.jdField_a_of_type_JavaLangString = AvatarPendantUtil.b(paramString.replace("faceAddon.stickerFont.android.", ""));
      return true;
    }
    if (paramString.startsWith("faceAddon.sticker."))
    {
      paramTagItemInfo.jdField_a_of_type_Boolean = false;
      paramTagItemInfo.b = false;
      paramTagItemInfo.jdField_a_of_type_JavaLangString = (AppConstants.SDCARD_PENDANT_ROOT + "sticker_info/" + paramString.replace("faceAddon.sticker.", ""));
      return true;
    }
    if ((paramString.startsWith("pendant.")) && (paramString.length() > "pendant.".length()))
    {
      paramString = paramString.substring("pendant.".length(), paramString.length());
      int i = paramString.indexOf(".");
      if (i > 0)
      {
        String str = paramString.substring(0, i);
        paramString.substring(i, paramString.length());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(AppConstants.SDCARD_PENDANT_ROOT).append(str).append(File.separator);
        paramTagItemInfo.jdField_a_of_type_Boolean = false;
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
        paramTagItemInfo.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
        return true;
      }
    }
    return false;
  }
  
  @NotNull
  private TagItemInfo getBidPokeInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    paramTagItemInfo.jdField_a_of_type_Boolean = false;
    paramTagItemInfo.b = true;
    if (paramString.startsWith("poke.item.effect.")) {
      paramTagItemInfo.jdField_a_of_type_JavaLangString = (PokeItemHelper.e + paramString.substring("poke.item.effect.".length(), paramString.length()));
    }
    do
    {
      return paramTagItemInfo;
      if (paramString.startsWith("poke.item.res."))
      {
        paramTagItemInfo.jdField_a_of_type_JavaLangString = (PokeItemHelper.e + paramString.substring("poke.item.res.".length(), paramString.length()));
        return paramTagItemInfo;
      }
    } while (!"poke.effectList".equals(paramString));
    paramTagItemInfo.b = false;
    paramTagItemInfo.jdField_a_of_type_JavaLangString = PokeItemHelper.f;
    return paramTagItemInfo;
  }
  
  private boolean getBidPraiseInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    PraiseManager localPraiseManager = (PraiseManager)this.this$0.app.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
    if ((localPraiseManager != null) && (paramString.startsWith("praise.android.")))
    {
      int i = localPraiseManager.a(paramString);
      if (i > 0)
      {
        paramTagItemInfo.jdField_a_of_type_Boolean = false;
        paramTagItemInfo.b = true;
        paramTagItemInfo.jdField_a_of_type_JavaLangString = localPraiseManager.a(i).getAbsolutePath();
        return true;
      }
    }
    return false;
  }
  
  private boolean getBidProfileCard(String paramString, TagItemInfo paramTagItemInfo)
  {
    boolean bool = false;
    if ("cardWZ.zip".equals(paramString))
    {
      paramTagItemInfo.jdField_a_of_type_Boolean = false;
      paramTagItemInfo.b = true;
      paramTagItemInfo.jdField_a_of_type_JavaLangString = VipWZRYTemplateHelper.a(this.this$0.app.getApp());
      bool = true;
    }
    while (!paramString.startsWith("card.")) {
      return bool;
    }
    paramTagItemInfo.jdField_a_of_type_Boolean = false;
    paramTagItemInfo.b = false;
    int i = Integer.parseInt(paramString.substring("card.".length(), paramString.length()));
    paramString = ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_ComTencentMobileqqProfileProfileCardManager;
    paramTagItemInfo.jdField_a_of_type_JavaLangString = ProfileCardManager.b(this.this$0.app.getApp(), i);
    return true;
  }
  
  @NotNull
  private TagItemInfo getBidQuickUpdate(String paramString, TagItemInfo paramTagItemInfo)
  {
    paramTagItemInfo.jdField_a_of_type_Boolean = false;
    if (paramString.endsWith("cfg")) {
      paramTagItemInfo.jdField_a_of_type_Boolean = true;
    }
    paramTagItemInfo.b = false;
    paramTagItemInfo.jdField_a_of_type_JavaLangString = (VasUpdateConstants.b + paramString);
    return paramTagItemInfo;
  }
  
  @NotNull
  private TagItemInfo getBidRedPacket(long paramLong, String paramString, TagItemInfo paramTagItemInfo)
  {
    paramTagItemInfo.jdField_a_of_type_Boolean = false;
    if (("iRedPacket_v3.json".equals(paramString)) || ("iRedPacket_v3.char300.json".equals(paramString)))
    {
      paramTagItemInfo.b = false;
      paramTagItemInfo.jdField_a_of_type_JavaLangString = (this.this$0.app.getApp().getApplicationContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + paramString);
    }
    if ("iRedPacket_v3.font.zip".equals(paramString))
    {
      paramTagItemInfo.b = true;
      paramTagItemInfo.jdField_a_of_type_JavaLangString = IndividualRedPacketManager.a(3);
    }
    do
    {
      return paramTagItemInfo;
      if ("iRedPacket_v3.specialChar.zip".equals(paramString))
      {
        paramTagItemInfo.b = true;
        paramTagItemInfo.jdField_a_of_type_JavaLangString = IndividualRedPacketManager.a(2);
        return paramTagItemInfo;
      }
    } while ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("luckyMoney.item.")));
    paramTagItemInfo.b = true;
    String str = IndividualRedPacketManager.a(paramString);
    if (TextUtils.isEmpty(str)) {
      QLog.d("VasQuickUpdateManager", 2, "getItemInfo bid = " + paramLong + " scid = " + paramString + " pid = " + str);
    }
    paramTagItemInfo.jdField_a_of_type_JavaLangString = (IndividualRedPacketManager.a(1) + str);
    return paramTagItemInfo;
  }
  
  private boolean getBidSignatureInfo(String paramString, TagItemInfo paramTagItemInfo)
  {
    boolean bool = false;
    if (paramString.startsWith("signature.sticker."))
    {
      paramTagItemInfo.jdField_a_of_type_Boolean = false;
      paramTagItemInfo.b = false;
      paramTagItemInfo.jdField_a_of_type_JavaLangString = (AppConstants.SDCARD_SIGNATURE_STICKER_DIR + paramString.substring("signature.sticker.".length(), paramString.length()));
      bool = true;
    }
    return bool;
  }
  
  private boolean getBidTroopEnterEffect(String paramString, TagItemInfo paramTagItemInfo)
  {
    boolean bool = false;
    paramTagItemInfo.jdField_a_of_type_Boolean = false;
    if (paramString.startsWith("groupeffect_item_"))
    {
      paramTagItemInfo.b = false;
      int i = TroopEnterEffectController.a(paramString);
      paramTagItemInfo.jdField_a_of_type_JavaLangString = (TroopEnterEffectController.jdField_a_of_type_JavaLangString + i + File.separator + i + ".zip");
      bool = true;
    }
    return bool;
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
    ColorScreenManager localColorScreenManager = ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_ComTencentMobileqqFloatscrColorScreenManager;
    if (paramString.startsWith("colorScreen.android.")) {
      return Boolean.valueOf(localColorScreenManager.a(paramString));
    }
    return null;
  }
  
  @Nullable
  private Boolean isComicExist(String paramString)
  {
    if (paramString.equals("vipComic_nav_config.json")) {
      return Boolean.valueOf(VipComicNavConfigHelper.a());
    }
    if (paramString.equals("vipComic_nav_tabIcon.zip")) {
      return Boolean.valueOf(VipComicNavConfigHelper.b());
    }
    return null;
  }
  
  @Nullable
  private Boolean isFaceExist(String paramString)
  {
    VasFaceManager localVasFaceManager = ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_ComTencentMobileqqVasAvatarVasFaceManager;
    if (paramString.startsWith("face.")) {
      return Boolean.valueOf(localVasFaceManager.a(paramString));
    }
    if (paramString.equals("avatarInPendant_json")) {
      return Boolean.valueOf(new File(this.this$0.app.getApplication().getFilesDir() + File.separator + "avatarInPendant.json").exists());
    }
    return null;
  }
  
  @Nullable
  private Boolean isMaterialExist(String paramString)
  {
    boolean bool = true;
    if (paramString.startsWith("libColorFont_818")) {
      return Boolean.valueOf(new File(VasSoUtils.a() + "libFounderColorFont_818.so").exists());
    }
    if (paramString.startsWith("libFlatBuffersParser")) {
      return Boolean.valueOf(new File(FlatBuffersParser.a() + "libFlatBuffersParser.zip").exists());
    }
    if (paramString.equals("kcsdk_4_4_7_3661")) {
      return Boolean.valueOf(new File(TMSManager.a().a(this.this$0.app.getApp())).exists());
    }
    if (paramString.equals("GLDrawableV8417")) {
      return Boolean.valueOf(GLDrawableDownloadHelper.a(this.this$0.app.getApp()));
    }
    if (paramString.equals("emojiStickerGuideZip_v2")) {
      return Boolean.valueOf(new File(EmojiStickerManager.a() + "emojiStickerGuideZip_v2.zip").exists());
    }
    if (paramString.equals("libVipFont_8417")) {
      return Boolean.valueOf(new File(VasSoUtils.a() + "libvipfont8417.so").exists());
    }
    if (paramString.startsWith("bqmall.android.h5magic.")) {
      return Boolean.valueOf(new File(VasEmojiManager.b(paramString)).exists());
    }
    if (paramString.equals("libqgplayer_841")) {
      return Boolean.valueOf(new File(VipComicSoHelper.a() + "libqgplayer_841.so").exists());
    }
    if (paramString.equals("libAPNG_845")) {
      return Boolean.valueOf(VasApngIPCModule.a().a());
    }
    if (paramString.equals("defaultFont_775"))
    {
      paramString = new File(VasSoUtils.a() + VasShieldFont.jdField_a_of_type_JavaLangString);
      if ((paramString.exists()) && (paramString.isDirectory())) {}
      for (;;)
      {
        return Boolean.valueOf(bool);
        bool = false;
      }
    }
    if (paramString.equals("enterEffectVipIcons"))
    {
      paramString = TroopEnterEffectController.a();
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("VasQuickUpdateManager", 1, "VasUpdateConstants.SCID_ENTER_EFFECT_VIP_ICONS: get null zipPath");
        return Boolean.valueOf(false);
      }
      return Boolean.valueOf(new File(paramString).exists());
    }
    return null;
  }
  
  @Nullable
  private Boolean isPendantExist(String paramString)
  {
    boolean bool = true;
    if (paramString.startsWith("faceAddon.stickerFont.android.")) {
      return Boolean.valueOf(AvatarPendantUtil.a(paramString.replace("faceAddon.stickerFont.android.", "")));
    }
    if (paramString.startsWith("faceAddon.sticker.")) {
      return Boolean.valueOf(AvatarPendantUtil.b(paramString));
    }
    if ((paramString.startsWith("pendant.")) && (paramString.length() > "pendant.".length()))
    {
      paramString = paramString.substring("pendant.".length());
      int i = paramString.indexOf(".");
      if (i <= 0) {
        return null;
      }
      Object localObject = paramString.substring(0, i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_PENDANT_ROOT).append((String)localObject).append(File.separator);
      if (paramString.endsWith(".xydata.js")) {
        localStringBuilder.append("config.json");
      }
      for (;;)
      {
        localObject = new File(localStringBuilder.toString());
        if (!((File)localObject).exists()) {
          break label366;
        }
        if (!((File)localObject).isDirectory()) {
          break label315;
        }
        if (((File)localObject).listFiles() != null) {
          break;
        }
        return Boolean.valueOf(false);
        if (paramString.endsWith(".aio_50.png")) {
          localStringBuilder.append("aio_50.png");
        } else if (paramString.endsWith(".other.zip")) {
          localStringBuilder.append("aio_file");
        }
      }
      i = ((File)localObject).listFiles().length;
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "isFileExists scid = " + paramString + " listFile length = " + i + " filepath = " + localStringBuilder.toString());
      }
      if (i > 0) {}
      for (;;)
      {
        return Boolean.valueOf(bool);
        bool = false;
      }
      label315:
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "isFileExists scid = " + paramString + " exists filepath = " + localStringBuilder.toString());
      }
      return Boolean.valueOf(true);
      label366:
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "isFileExists scid = " + paramString + " not exists filepath = " + localStringBuilder.toString());
      }
      return Boolean.valueOf(false);
    }
    return null;
  }
  
  @Nullable
  private Boolean isPokeExist(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    int i;
    if (paramString.startsWith("poke.item.effect."))
    {
      paramString = paramString.substring("poke.item.effect.".length(), paramString.length());
      try
      {
        i = Integer.valueOf(paramString).intValue();
        if (i == -1) {
          return Boolean.valueOf(bool1);
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasQuickUpdateManager", 2, "id error");
          }
          i = -1;
          continue;
          bool1 = PokeItemHelper.a("effect.gif", i);
        }
      }
    }
    if (paramString.startsWith("poke.item.res."))
    {
      paramString = paramString.substring("poke.item.res.".length(), paramString.length());
      try
      {
        i = Integer.valueOf(paramString).intValue();
        if (i == -1)
        {
          bool1 = bool2;
          return Boolean.valueOf(bool1);
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasQuickUpdateManager", 2, "id error");
          }
          i = -1;
          continue;
          bool1 = PokeItemHelper.a("bubble", i);
        }
      }
    }
    if ("poke.effectList".equals(paramString)) {
      return Boolean.valueOf(new File(PokeItemHelper.f).exists());
    }
    return null;
  }
  
  @Nullable
  private Boolean isProfileCardExist(String paramString)
  {
    if ("cardWZ.zip".equals(paramString)) {
      return Boolean.valueOf(VipWZRYTemplateHelper.a(this.this$0.app.getApp(), paramString));
    }
    if (paramString.startsWith("card."))
    {
      int i = Integer.parseInt(paramString.substring("card.".length(), paramString.length()));
      paramString = ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_ComTencentMobileqqProfileProfileCardManager;
      return Boolean.valueOf(ProfileCardManager.a(this.this$0.app.getApp(), i));
    }
    return null;
  }
  
  private boolean isRedPacketExist(String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    Object localObject2 = null;
    Object localObject1 = null;
    if (("iRedPacket_v3.json".equals(paramString)) || ("iRedPacket_v3.char300.json".equals(paramString))) {
      paramString = this.this$0.app.getApp().getApplicationContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + paramString;
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramString)) {}
      for (paramString = localObject1;; paramString = new File(paramString))
      {
        if ((paramString == null) || (!paramString.exists())) {
          break label293;
        }
        return bool2;
        if ("iRedPacket_v3.font.zip".equals(paramString))
        {
          paramString = IndividualRedPacketManager.a(null, null, 8, 0, 0);
          break;
        }
        if ("iRedPacket_v3.specialChar.zip".equals(paramString))
        {
          paramString = IndividualRedPacketManager.a(null, null, 25, 0, 0);
          break;
        }
        if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("luckyMoney.item."))) {
          break label295;
        }
        paramString = IndividualRedPacketManager.a(paramString);
        if (TextUtils.isEmpty(paramString)) {
          break label295;
        }
        paramString = IndividualRedPacketManager.a(paramString, null, 24, 0, 0);
        if (TextUtils.isEmpty(paramString))
        {
          paramString = localObject2;
          label194:
          if ((paramString == null) || (!paramString.exists()) || (!paramString.isDirectory()) || (paramString.list() == null) || (paramString.list().length <= 1)) {
            break label276;
          }
        }
        for (;;)
        {
          bool2 = bool1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("VasQuickUpdateManager", 2, "isFileExists VasUpdateConstants.SCID_REDPACKET_PACKETS_ZIP result = " + bool1);
          return bool1;
          paramString = new File(paramString);
          break label194;
          label276:
          bool1 = false;
        }
      }
      label293:
      return false;
      label295:
      paramString = null;
    }
  }
  
  @Nullable
  private Boolean isSignatureExist(String paramString)
  {
    if (paramString.startsWith("signature.sticker."))
    {
      paramString = paramString.substring("signature.sticker.".length(), paramString.length());
      return Boolean.valueOf(new File(AppConstants.SDCARD_SIGNATURE_STICKER_DIR + paramString).exists());
    }
    return null;
  }
  
  @Nullable
  private Boolean isTroopEnterEffectExist(String paramString)
  {
    int i = TroopEnterEffectController.a(paramString);
    if (i > 0) {
      return Boolean.valueOf(TroopGiftUtil.a(new File(TroopEnterEffectController.jdField_a_of_type_JavaLangString + i)));
    }
    return null;
  }
  
  private void onBubbleCompleted(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    BubbleManager localBubbleManager = (BubbleManager)this.this$0.app.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    if (paramString1.startsWith("bubble.android.")) {
      localBubbleManager.b(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    while (!paramString1.startsWith("bubble.paster.")) {
      return;
    }
    localBubbleManager.a(paramString1, paramString2, paramString3, paramInt1, paramInt2);
  }
  
  private void onColorScreenCompleted(String paramString, int paramInt)
  {
    ColorScreenManager localColorScreenManager = ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_ComTencentMobileqqFloatscrColorScreenManager;
    if (paramString.startsWith("colorScreen.android.")) {
      localColorScreenManager.a(paramString, paramInt);
    }
  }
  
  private void onComicCompleted(String paramString, int paramInt)
  {
    if (paramInt == 0)
    {
      if (!paramString.equals("vipComic_nav_config.json")) {
        break label18;
      }
      VipComicNavConfigHelper.a();
    }
    label18:
    while (!paramString.equals("vipComic_nav_tabIcon.zip")) {
      return;
    }
    VipComicNavConfigHelper.b();
  }
  
  private void onDefaultCardCompleted(String paramString, int paramInt)
  {
    if (paramString.startsWith("profileitem."))
    {
      ProfileCardManager localProfileCardManager = ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_ComTencentMobileqqProfileProfileCardManager;
      int i = Integer.parseInt(paramString.substring("profileitem.".length()));
      localProfileCardManager.a.remove(Integer.valueOf(i));
      if (paramInt == 0) {
        localProfileCardManager.a(i, false);
      }
    }
    else
    {
      return;
    }
    QLog.e("VasQuickUpdateManager", 2, "onCompleted: default card download error: " + paramInt + " scid=" + paramString);
  }
  
  private void onFaceCompleted(String paramString, int paramInt)
  {
    VasFaceManager localVasFaceManager = ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_ComTencentMobileqqVasAvatarVasFaceManager;
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
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateManager", 2, "onCompleted emoji keyword errorCode = " + paramInt);
    }
    if (paramInt != 0) {}
    label171:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!paramString.equals("keywordList_2.json")) {
              break;
            }
            paramString = (EmoticonManager)this.this$0.app.getManager(QQManagerFactory.EMOTICON_MANAGER);
          } while (paramString == null);
          paramString.d();
          return;
          if (paramString.startsWith("signature.item."))
          {
            VasUtils.a(this.this$0.app);
            return;
          }
          if ("vipData_individuation_url.android.json".equals(paramString))
          {
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder().append("onCompleted url_configurable ,errorCode = ").append(paramInt).append(", app=");
              if (this.this$0.app == null) {
                break label171;
              }
            }
            for (boolean bool = true;; bool = false)
            {
              QLog.d("VasQuickUpdateManager", 2, bool);
              IndividuationUrlHelper.a(this.this$0.app);
              return;
            }
          }
          if ("changeVoice_json".equals(paramString))
          {
            ((VoiceChangeManager)this.this$0.app.getManager(QQManagerFactory.VOICE_CHANGE_MANAGER)).a(null, null);
            return;
          }
          if (!"blessVoiceList.json".equals(paramString)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VasQuickUpdateManager", 2, "onCompleted blessVoiceChange ,errorCode = " + paramInt);
        return;
        if ("vip_personal_card.json".equals(paramString))
        {
          VipGrayConfigHelper.a().a(this.this$0.app, true);
          ClubContentJsonTask.b(this.this$0.app);
          AioVipKeywordHelper.a().a(this.this$0.app);
          return;
        }
        if ("monitorAppid".equals(paramString))
        {
          ((VasMonitorHandler)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.VAS_MONITOR_HANDLER)).a(this.this$0.app, true);
          return;
        }
        if ("praise.config.json".equals(paramString))
        {
          PraiseConfigHelper.a(this.this$0.app);
          return;
        }
        if ("card.diyFontConfig.json".equals(paramString))
        {
          VipProfileDiyCardConfig.a(this.this$0.app);
          return;
        }
        if ("vipData_app_webviewNavStyle.json".equals(paramString))
        {
          WebViewTitleStyleHelper.a().a(this.this$0.app);
          return;
        }
        if ("VASBiz_FuncDev_webview.json".equals(paramString))
        {
          AuthorizeConfig.a().j();
          AuthorizeConfig.a().e();
          AuthorizeConfig.a().c();
          return;
        }
        if (!"watch_focus.json".equals(paramString)) {
          break;
        }
        paramString = (EmoticonHandler)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM);
      } while (paramString == null);
      paramString.c();
      return;
      if ("groupeffect_config.json".equals(paramString))
      {
        ((TroopEnterEffectManager)this.this$0.app.getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER)).a(false);
        return;
      }
    } while (!"emoji.systemEmojiWhiteList.json".equals(paramString));
    SystemEmoticonInfo.parseWhiteList(this.this$0.app, true);
  }
  
  private boolean onMaterialCompleted(String paramString, int paramInt)
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onCompleted sticker material ,errorCode = ").append(paramInt).append(", app=");
      if (this.this$0.app != null)
      {
        bool = true;
        QLog.d("VasQuickUpdateManager", 2, bool);
      }
    }
    else
    {
      if (paramInt == 0)
      {
        if (!paramString.equals("emojiStickerGuideZip_v2")) {
          break label112;
        }
        EmojiStickerManager.a();
      }
      label75:
      if (!paramString.equals("libColorFont_818")) {
        break label127;
      }
      ((FontManager)this.this$0.app.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).a(4, paramInt);
    }
    for (;;)
    {
      return false;
      bool = false;
      break;
      label112:
      if (!paramString.equals("libFlatBuffersParser")) {
        break label75;
      }
      FlatBuffersParser.e();
      break label75;
      label127:
      if (paramString.equals("libVipFont_8417"))
      {
        ((FontManager)this.this$0.app.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).a(1, paramInt);
      }
      else if (paramString.startsWith("bqmall.android.h5magic."))
      {
        ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_ComTencentMobileqqEmoticonVasEmojiManager.a(paramString, paramInt);
      }
      else if (paramString.equals("libqgplayer_841"))
      {
        VipComicSoHelper.a(this.this$0.app, paramInt);
      }
      else if (paramString.equals("kcsdk_4_4_7_3661"))
      {
        TMSManager.a().a(this.this$0.app.getApp(), paramInt);
      }
      else if (paramString.equals("GLDrawableV8417"))
      {
        GLDrawableDownloadHelper.a(this.this$0.app.getApp(), paramInt);
      }
      else if (paramString.equals("libAPNG_845"))
      {
        VasApngIPCModule.a().a(paramInt);
      }
      else if (paramString.equals("defaultFont_775"))
      {
        VasShieldFont.a(this.this$0.app, paramInt);
      }
      else if ((paramString.equals("enterEffectVipIcons")) && (paramInt == 0))
      {
        paramString = TroopEnterEffectController.a();
        localObject = TroopEnterEffectController.b();
        if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty((CharSequence)localObject)))
        {
          QLog.e("VasQuickUpdateManager", 1, "VasUpdateConstants.SCID_ENTER_EFFECT_VIP_ICONS onComplete null path: " + paramString + "," + (String)localObject);
          return true;
        }
        try
        {
          FileUtils.a(paramString, (String)localObject, false);
        }
        catch (IOException paramString)
        {
          QLog.e("VasQuickUpdateManager", 1, "VasUpdateConstants.SCID_ENTER_EFFECT_VIP_ICONS onCompleted error", paramString);
        }
      }
    }
  }
  
  private void onPokeCompleted(String paramString)
  {
    if ("poke.effectList".equals(paramString))
    {
      paramString = (EarlyDownloadManager)this.this$0.app.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
      if (paramString != null)
      {
        paramString = (PokeResHandler)paramString.a("qq.android.poke.res_0625");
        if (paramString != null) {
          paramString.f();
        }
      }
    }
  }
  
  private void onProfileCardCompleted(String paramString1, String paramString2, int paramInt)
  {
    if ("cardWZ.zip".equals(paramString1)) {
      VipWZRYTemplateHelper.a(this.this$0.app, paramString1, paramString2, paramInt);
    }
    while (!paramString1.startsWith("card.")) {
      return;
    }
    ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_ComTencentMobileqqProfileProfileCardManager.a(this.this$0.app, paramString1, paramString2, paramInt);
  }
  
  private void onTroopEnterEffectCompleted(String paramString, int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = TroopEnterEffectController.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect", 2, "download Res onCompleted success id = " + paramInt);
      }
      if (paramInt > 0) {
        paramString = TroopEnterEffectController.a(paramInt);
      }
    }
    try
    {
      if (new File(paramString).exists()) {
        FileUtils.a(paramString, TroopEnterEffectController.jdField_a_of_type_JavaLangString, false);
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("TroopEnterEffect", 1, "Res Download unCompress error: " + paramString.getLocalizedMessage());
    }
  }
  
  private void pendantCompleted(String paramString, int paramInt)
  {
    if (paramString.startsWith("faceAddon.stickerFont.android.")) {
      if (paramInt == 0) {
        DiyPendantFetcher.a().b(paramString);
      }
    }
    long l;
    AvatarPendantManager localAvatarPendantManager;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!paramString.startsWith("faceAddon.sticker.")) {
              break;
            }
          } while (paramInt != 0);
          DiyPendantFetcher.a().a(paramString);
          return;
        } while ((!paramString.startsWith("pendant.")) || (paramString.length() <= "pendant.".length()));
        paramString = paramString.substring("pendant.".length(), paramString.length());
        paramInt = paramString.indexOf(".");
      } while (paramInt <= 0);
      l = Long.parseLong(paramString.substring(0, paramInt));
      localAvatarPendantManager = (AvatarPendantManager)this.this$0.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
      if (paramString.endsWith(".xydata.js"))
      {
        localAvatarPendantManager.a(l).a(PendantInfo.g);
        return;
      }
      if (paramString.endsWith(".aio_50.png"))
      {
        localAvatarPendantManager.a(l).b(l, 1);
        return;
      }
    } while (!paramString.endsWith(".other.zip"));
    localAvatarPendantManager.a(l).b(l, 2);
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
    boolean bool;
    if ((paramLong == 1000L) || (paramLong == 1003L) || (paramLong == 21L) || (paramLong == 2L) || (paramLong == 16L) || (paramLong == 20L) || (paramLong == 4L) || (paramLong == 23L)) {
      bool = deleteJsonFile(paramLong, paramString).booleanValue();
    }
    for (;;)
    {
      QLog.e("VasQuickUpdateManager", 1, "deleteFiles : bid = " + paramLong + " scid = " + paramString + " result:" + bool);
      return bool;
      if (paramLong == 1004L)
      {
        bool = deleteMatriel(paramString).booleanValue();
      }
      else if (paramLong == 9L)
      {
        bool = deleteSignature(paramString).booleanValue();
      }
      else if (paramLong == 15L)
      {
        bool = deleteProfileCard(paramString).booleanValue();
      }
      else
      {
        Object localObject;
        if (paramLong == 22L)
        {
          localObject = ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_ComTencentMobileqqFloatscrColorScreenManager;
          if (paramString.startsWith("colorScreen.android.")) {
            ((ColorScreenManager)localObject).a(paramString);
          }
          bool = false;
        }
        else if (paramLong == 1999L)
        {
          localObject = VasUpdateConstants.b + paramString;
          bool = VasUpdateUtil.a(new File((String)localObject));
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: quickupdate test path = " + (String)localObject + " result = " + bool);
        }
        else if (paramLong == 25L)
        {
          int i = TroopEnterEffectController.a(paramString);
          localObject = TroopEnterEffectController.jdField_a_of_type_JavaLangString + i;
          bool = VasUpdateUtil.a(new File((String)localObject));
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: ENTER_EFFECT path = " + (String)localObject + " result = " + bool);
        }
        else if (paramLong == 8L)
        {
          localObject = paramString.substring("chatbg.".length(), paramString.length());
          ChatBackgroundManager localChatBackgroundManager = (ChatBackgroundManager)this.this$0.app.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
          bool = VasUpdateUtil.a(new File(ChatBackgroundManager.g((String)localObject)));
        }
        else if (paramLong == 27L)
        {
          localObject = paramString.substring("groupnickitem.".length(), paramString.length());
          localObject = ColorNickManager.jdField_a_of_type_JavaLangString + (String)localObject;
          bool = VasUpdateUtil.a(new File((String)localObject));
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: COLOR_NICK path = " + (String)localObject + " result = " + bool);
        }
        else if (paramLong == 33L)
        {
          localObject = paramString.substring("profileitem.".length());
          bool = VasUpdateUtil.a(new File(ProfileCardManager.a((String)localObject)));
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: Default Card Config id=" + (String)localObject + " ret=" + bool);
        }
        else
        {
          bool = false;
        }
      }
    }
  }
  
  public void doOnCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if ((QLog.isColorLevel()) || (paramInt1 != 0)) {
      QLog.d("VasQuickUpdateManager", 2, "onCompleted bid = " + paramLong + " scid = " + paramString1 + " from = " + paramString3 + " errorCode = " + paramInt1 + " httpCode = " + paramInt2);
    }
    if (paramLong == 1000L) {
      onJsonCompleted(paramString1, paramInt1);
    }
    for (;;)
    {
      this.this$0.callBackToAll(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      return;
      if (paramLong == 2L)
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
        } else if (paramLong == 1004L)
        {
          if (!onMaterialCompleted(paramString1, paramInt1)) {}
        }
        else if (paramLong == 1002L) {
          onFlashChatCompleted(paramString1, paramInt1);
        } else if (paramLong == 15L) {
          onProfileCardCompleted(paramString1, paramString3, paramInt1);
        } else if (paramLong == 21L) {
          onPokeCompleted(paramString1);
        } else if (paramLong == 100L) {
          onComicCompleted(paramString1, paramInt1);
        } else if ((paramLong == 25L) && (paramString1.startsWith("groupeffect_item_"))) {
          onTroopEnterEffectCompleted(paramString1, paramInt1);
        } else if (paramLong == 8L) {
          ((ChatBackgroundManager)this.this$0.app.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2);
        } else if (paramLong == 33L) {
          onDefaultCardCompleted(paramString1, paramInt1);
        }
      }
    }
  }
  
  public void doOnProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (paramLong1 == 2L) {
      ((BubbleManager)this.this$0.app.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER)).a(paramString1, paramString2, paramLong2, paramLong3);
    }
    if ((paramLong1 == 1004L) && (paramString1.startsWith("bqmall.android.h5magic."))) {
      ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_ComTencentMobileqqEmoticonVasEmojiManager.a(paramString1, paramLong2, paramLong3);
    }
    if (paramLong1 == 15L) {
      if (paramString1.startsWith("card.")) {
        ((VasExtensionManager)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_ComTencentMobileqqProfileProfileCardManager.a(Integer.parseInt(paramString1.substring("card.".length(), paramString1.length())), (int)(100L * paramLong2 / paramLong3));
      }
    }
    for (;;)
    {
      this.this$0.onProgressToAll(paramLong1, paramString1, paramString2, paramLong2, paramLong3);
      return;
      if (paramLong1 == 8L) {
        ((ChatBackgroundManager)this.this$0.app.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.this$0.app, paramLong1, paramString1, (int)(100L * paramLong2 / paramLong3));
      }
    }
  }
  
  public long getBID()
  {
    return 0L;
  }
  
  public TagItemInfo getItemInfo(long paramLong, String paramString)
  {
    TagItemInfo localTagItemInfo = new TagItemInfo();
    if ((paramLong == 1000L) || (paramLong == 1001L)) {
      return getBIdJsonInfo(paramString, localTagItemInfo);
    }
    if (paramLong == 1002L) {
      return getBidFlashChatInfo(paramString, localTagItemInfo);
    }
    boolean bool;
    if (paramLong == 22L) {
      bool = getBidColorScreenInfo(paramString, localTagItemInfo);
    }
    for (;;)
    {
      if (bool)
      {
        return localTagItemInfo;
        if (paramLong == 23L)
        {
          bool = getBidFaceInfo(paramString, localTagItemInfo);
          continue;
        }
        if (paramLong == 2L)
        {
          bool = getBidBubbleInfo(paramString, localTagItemInfo);
          continue;
        }
        if (paramLong == 4L)
        {
          bool = getBidPendantInfo(paramString, localTagItemInfo);
          continue;
        }
        if (paramLong == 20L)
        {
          bool = getBidPraiseInfo(paramString, localTagItemInfo);
          continue;
        }
        Object localObject;
        if (paramLong == 1003L)
        {
          localTagItemInfo.jdField_a_of_type_Boolean = false;
          localTagItemInfo.b = false;
          localObject = this.this$0.app.getApplication().getFilesDir() + File.separator;
          localTagItemInfo.jdField_a_of_type_JavaLangString = ((String)localObject + paramString);
          return localTagItemInfo;
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
          if (paramLong == 9L)
          {
            bool = getBidSignatureInfo(paramString, localTagItemInfo);
            continue;
          }
          if (paramLong == 1999L) {
            return getBidQuickUpdate(paramString, localTagItemInfo);
          }
          if (paramLong == 100L) {
            return getBidComicInfo(paramString, localTagItemInfo);
          }
          if (paramLong == 25L)
          {
            bool = getBidTroopEnterEffect(paramString, localTagItemInfo);
            continue;
          }
          if (paramLong == 8L)
          {
            localObject = (ChatBackgroundManager)this.this$0.app.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
            paramString = paramString.substring("chatbg.".length(), paramString.length());
            localTagItemInfo.b = false;
            localTagItemInfo.jdField_a_of_type_Boolean = false;
            localTagItemInfo.jdField_a_of_type_JavaLangString = ((ChatBackgroundManager)localObject).f(paramString);
            return localTagItemInfo;
          }
          if (paramLong == 27L)
          {
            paramString = paramString.substring("groupnickitem.".length(), paramString.length());
            localTagItemInfo.b = true;
            localTagItemInfo.jdField_a_of_type_Boolean = false;
            localTagItemInfo.jdField_a_of_type_JavaLangString = (ColorNickManager.jdField_a_of_type_JavaLangString + paramString);
            return localTagItemInfo;
          }
          if (paramLong == 33L)
          {
            paramString = paramString.substring("profileitem.".length());
            localTagItemInfo.b = false;
            localTagItemInfo.jdField_a_of_type_Boolean = false;
            localTagItemInfo.jdField_a_of_type_JavaLangString = ProfileCardManager.a(paramString);
            return localTagItemInfo;
          }
        }
      }
      else
      {
        return null;
      }
      bool = false;
    }
  }
  
  public boolean isFileExists(long paramLong, String paramString)
  {
    Boolean localBoolean = null;
    if (paramLong == 1000L) {
      return new File(this.this$0.app.getApplication().getFilesDir(), paramString).exists();
    }
    if (paramLong == 2L) {
      localBoolean = isBubbleExist(paramString);
    }
    while (localBoolean != null)
    {
      return localBoolean.booleanValue();
      if (paramLong == 22L)
      {
        localBoolean = isColorScreenExist(paramString);
      }
      else if (paramLong == 23L)
      {
        localBoolean = isFaceExist(paramString);
      }
      else if (paramLong == 4L)
      {
        localBoolean = isPendantExist(paramString);
      }
      else
      {
        if (paramLong == 20L) {
          return ((PraiseManager)this.this$0.app.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER)).a(paramString);
        }
        if (paramLong == 1003L) {
          return new File(this.this$0.app.getApplication().getFilesDir(), paramString).exists();
        }
        if (paramLong == 16L) {
          return isRedPacketExist(paramString);
        }
        if (paramLong == 15L)
        {
          localBoolean = isProfileCardExist(paramString);
        }
        else if (paramLong == 21L)
        {
          localBoolean = isPokeExist(paramString);
        }
        else if (paramLong == 1004L)
        {
          localBoolean = isMaterialExist(paramString);
        }
        else if (paramLong == 9L)
        {
          localBoolean = isSignatureExist(paramString);
        }
        else
        {
          if (paramLong == 1999L) {
            return new File(VasUpdateConstants.b + paramString).exists();
          }
          if (paramLong == 100L)
          {
            localBoolean = isComicExist(paramString);
          }
          else if (paramLong == 25L)
          {
            localBoolean = isTroopEnterEffectExist(paramString);
          }
          else
          {
            if (paramLong == 8L)
            {
              paramString = paramString.substring("chatbg.".length(), paramString.length());
              return ((ChatBackgroundManager)this.this$0.app.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(paramString);
            }
            if (paramLong == 27L) {
              return new File(ColorNickManager.a(paramString.substring("groupnickitem.".length(), paramString.length()))).exists();
            }
            if (paramLong == 33L) {
              return new File(ProfileCardManager.a(paramString.substring("profileitem.".length()))).exists();
            }
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager.DefaultUpdateCallback
 * JD-Core Version:    0.7.0.1
 */