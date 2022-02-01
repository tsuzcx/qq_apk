package com.tencent.mobileqq.vas;

import ahcw;
import amks;
import android.content.Context;
import android.text.TextUtils;
import antu;
import anxc;
import asbm;
import ascd;
import asjs;
import aumm;
import avjz;
import avkb;
import avkh;
import awyr;
import azrc;
import azso;
import azsp;
import azsq;
import aztg;
import bfkl;
import bfkw;
import bglb;
import bhcs;
import bhiw;
import bhln;
import bhmb;
import bhnp;
import bhom;
import bhou;
import bhpe;
import bhpw;
import bhqv;
import bhro;
import bhyi;
import bhzh;
import bhzj;
import bicd;
import blqy;
import blrf;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webview.WebViewTitleStyleHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gb;
import gm;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import mqq.app.MobileQQ;
import nro;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VasQuickUpdateManager$DefaultUpdateCallback
  extends bhro
{
  public VasQuickUpdateManager$DefaultUpdateCallback(VasQuickUpdateManager paramVasQuickUpdateManager) {}
  
  @Nullable
  private Boolean deleteFont(String paramString)
  {
    boolean bool;
    if (paramString.startsWith("font.diycard.android."))
    {
      paramString = paramString.substring("font.diycard.android.".length(), paramString.length());
      paramString = azsp.a + paramString;
      bool = VasQuickUpdateEngine.safeDeleteFile(new File(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "deleteFiles: font diy card path = " + paramString + " result = " + bool);
      }
      return Boolean.valueOf(bool);
    }
    if (paramString.startsWith("font.hifont.android."))
    {
      paramString = paramString.substring("font.hifont.android.".length(), paramString.length());
      paramString = avjz.b + paramString;
      bool = VasQuickUpdateEngine.safeDeleteFile(new File(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "deleteFiles: font hiboom path = " + paramString + " result = " + bool);
      }
      return Boolean.valueOf(bool);
    }
    if (paramString.startsWith("font.hiFontQQ.json."))
    {
      paramString = paramString.substring("font.hiFontQQ.json.".length(), paramString.length());
      paramString = avjz.c + paramString;
      bool = VasQuickUpdateEngine.safeDeleteFile(new File(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "deleteFiles: font hiboom config path = " + paramString + " result = " + bool);
      }
      return Boolean.valueOf(bool);
    }
    if (paramString.startsWith("font.hiFontQQ.tags"))
    {
      bool = VasQuickUpdateEngine.safeDeleteFile(new File(avjz.d));
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "deleteFiles: font hiboom tag result = " + bool);
      }
      return Boolean.valueOf(bool);
    }
    if (paramString.startsWith("font.main.android."))
    {
      paramString = paramString.substring("font.main.android.".length(), paramString.length());
      paramString = gb.a + File.separatorChar + paramString + File.separatorChar + paramString + ".ttf";
      bool = VasQuickUpdateEngine.safeDeleteFile(new File(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "deleteFiles: font font path = " + paramString + " result = " + bool);
      }
      return Boolean.valueOf(bool);
    }
    if (paramString.startsWith("font.fzfont.android."))
    {
      paramString = paramString.substring("font.fzfont.android.".length(), paramString.length());
      paramString = gb.b + paramString + File.separatorChar + paramString + ".ttf";
      bool = VasQuickUpdateEngine.safeDeleteFile(new File(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "deleteFiles: font font fz path = " + paramString + " result = " + bool);
      }
      return Boolean.valueOf(bool);
    }
    if (paramString.equals("magicFontConfig.json"))
    {
      bool = VasQuickUpdateEngine.safeDeleteFile(new File(gb.g));
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "deleteFiles: fontEffect json path = " + gb.g + " result = " + bool);
      }
      return Boolean.valueOf(bool);
    }
    return Boolean.valueOf(false);
  }
  
  @Nullable
  private Boolean deleteJsonFile(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    paramQQAppInterface = getItemInfo(paramQQAppInterface, paramLong, paramString);
    if (paramQQAppInterface != null)
    {
      boolean bool = VasQuickUpdateEngine.safeDeleteFile(new File(paramQQAppInterface.strSavePath));
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
      return Boolean.valueOf(VasQuickUpdateEngine.safeDeleteFile(new File(bhiw.a() + "libFounderColorFont_818.so")));
    }
    if (paramString.equals("kcsdk_4_4_7_3661")) {
      return Boolean.valueOf(VasQuickUpdateEngine.safeDeleteFile(new File(bhzh.a().a(this.this$0.app.getApp()))));
    }
    if (paramString.equals("GLDrawableV848")) {
      return Boolean.valueOf(VasQuickUpdateEngine.safeDeleteFile(bhqv.a(this.this$0.app.getApp())));
    }
    if (paramString.equals("libFlatBuffersParser"))
    {
      FlatBuffersParser.g();
      return Boolean.valueOf(true);
    }
    if (paramString.equals("libVipFont_808")) {
      return Boolean.valueOf(VasQuickUpdateEngine.safeDeleteFile(new File(bhiw.a() + "libvipfont808.so")));
    }
    if (paramString.startsWith("bqmall.android.h5magic."))
    {
      asjs.a(paramString);
      return Boolean.valueOf(true);
    }
    if (paramString.equals("libqgplayer_841")) {
      return Boolean.valueOf(VasQuickUpdateEngine.safeDeleteFile(new File(blrf.a() + "libqgplayer_841.so")));
    }
    if (paramString.equals("libAPNG_845")) {
      return Boolean.valueOf(VasQuickUpdateEngine.safeDeleteFile(new File(bhiw.a() + "libAPNG_release_845.so")));
    }
    if (paramString.equals("defaultFont_775")) {
      return Boolean.valueOf(VasQuickUpdateEngine.safeDeleteFile(new File(gm.a())));
    }
    if (paramString.equals("enterEffectVipIcons"))
    {
      paramString = bfkl.a();
      if (!TextUtils.isEmpty(paramString)) {
        VasQuickUpdateEngine.safeDeleteFile(new File(paramString));
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
      paramString = azso.a(this.this$0.app.getApp());
      boolean bool = VasQuickUpdateEngine.safeDeleteFile(new File(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "deleteFiles: profile card path = " + paramString + " result = " + bool);
      }
      return Boolean.valueOf(bool);
    }
    if (paramString.startsWith("card."))
    {
      azrc localazrc = ((bhou)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_Azrc;
      int i = Integer.parseInt(paramString.substring("card.".length(), paramString.length()));
      return Boolean.valueOf(localazrc.b(this.this$0.app.getApp(), i));
    }
    return Boolean.valueOf(false);
  }
  
  @Nullable
  private Boolean deleteSignature(String paramString)
  {
    if (paramString.startsWith("signature.sticker."))
    {
      paramString = paramString.substring("signature.sticker.".length(), paramString.length());
      boolean bool = VasQuickUpdateEngine.safeDeleteFile(new File(AppConstants.SDCARD_SIGNATURE_STICKER_DIR + paramString));
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "deleteFiles: signature sticker path = " + paramString + " result = " + bool);
      }
      return Boolean.valueOf(bool);
    }
    return Boolean.valueOf(false);
  }
  
  private void fontProgress(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    if (paramLong1 == 5L)
    {
      if (!paramString.startsWith("font.main.android.")) {
        break label64;
      }
      i = Integer.parseInt(paramString.substring("font.main.android.".length(), paramString.length()));
      ((gb)this.this$0.app.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).a(i, (float)paramLong2 / (float)paramLong3);
    }
    label64:
    do
    {
      do
      {
        return;
      } while (!paramString.startsWith("font.hifont.android."));
      paramString = paramString.substring("font.hifont.android.".length(), paramString.length());
    } while ((TextUtils.isEmpty(paramString)) || (!TextUtils.isDigitsOnly(paramString)));
    int i = Integer.parseInt(paramString);
    ((avkh)this.this$0.app.getManager(QQManagerFactory.HIBOOM_MANAGER)).a(i, (int)(100L * paramLong2 / paramLong3));
  }
  
  @NotNull
  private VasQuickUpdateEngine.TagItemInfo getBIdJsonInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
  {
    paramTagItemInfo.bPreConfig = false;
    paramTagItemInfo.bSaveInDir = false;
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
      paramTagItemInfo.strSavePath = (str2 + str1);
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
  
  private boolean getBidBubbleInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
  {
    BubbleManager localBubbleManager = (BubbleManager)this.this$0.app.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    if (paramString.startsWith("bubble.android."))
    {
      int i = localBubbleManager.a(paramString);
      if (i > 0)
      {
        paramTagItemInfo.bPreConfig = false;
        if (paramString.endsWith("static.zip"))
        {
          paramTagItemInfo.bSaveInDir = true;
          paramTagItemInfo.strSavePath = (localBubbleManager.a(i).getAbsolutePath() + File.separator + "static");
        }
        for (;;)
        {
          return true;
          if (paramString.endsWith("other.zip"))
          {
            paramTagItemInfo.bSaveInDir = true;
            paramTagItemInfo.strSavePath = localBubbleManager.a(i).getAbsolutePath();
          }
          else if (paramString.endsWith("config.json"))
          {
            paramTagItemInfo.bSaveInDir = false;
            paramTagItemInfo.strSavePath = (localBubbleManager.a(i).getAbsolutePath() + File.separator + "config.json");
          }
        }
      }
    }
    else if (paramString.startsWith("bubble.paster."))
    {
      paramTagItemInfo.bSaveInDir = false;
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("bubble.paster.")))
      {
        paramString = paramString.replace("bubble.paster.", "");
        paramTagItemInfo.strSavePath = (localBubbleManager.b().getAbsolutePath() + File.separator + paramString);
        if (QLog.isColorLevel()) {
          QLog.i("VasQuickUpdateManager", 2, "download paster fileName: " + paramTagItemInfo.strSavePath);
        }
      }
      paramTagItemInfo.bPreConfig = false;
      return true;
    }
    return false;
  }
  
  private boolean getBidColorScreenInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
  {
    aumm localaumm = ((bhou)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_Aumm;
    if (paramString.startsWith("colorScreen.android."))
    {
      int i = localaumm.a(paramString);
      if (i > 0)
      {
        paramTagItemInfo.bPreConfig = false;
        paramTagItemInfo.bSaveInDir = false;
        paramTagItemInfo.strSavePath = (localaumm.a(i).getAbsolutePath() + File.separator + "config.zip");
        return true;
      }
    }
    return false;
  }
  
  @NotNull
  private VasQuickUpdateEngine.TagItemInfo getBidComicInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
  {
    paramTagItemInfo.bPreConfig = false;
    if (paramString.equals("vipComic_nav_config.json"))
    {
      paramTagItemInfo.bSaveInDir = false;
      paramTagItemInfo.strSavePath = blqy.b().getAbsolutePath();
    }
    while (!paramString.equals("vipComic_nav_tabIcon.zip")) {
      return paramTagItemInfo;
    }
    paramTagItemInfo.bSaveInDir = true;
    paramTagItemInfo.strSavePath = blqy.c().getAbsolutePath();
    return paramTagItemInfo;
  }
  
  private boolean getBidFaceInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
  {
    if (paramString.startsWith("face."))
    {
      paramString = VasFaceManager.a(paramString);
      if (paramString != null)
      {
        paramTagItemInfo.bPreConfig = false;
        paramTagItemInfo.bSaveInDir = false;
        paramTagItemInfo.strSavePath = paramString;
        return true;
      }
    }
    else if (paramString.equals("avatarInPendant_json"))
    {
      paramTagItemInfo.bPreConfig = false;
      paramTagItemInfo.bSaveInDir = false;
      paramTagItemInfo.strSavePath = (this.this$0.app.getApplication().getFilesDir() + File.separator + "avatarInPendant.json");
      return true;
    }
    return false;
  }
  
  @NotNull
  private VasQuickUpdateEngine.TagItemInfo getBidFlashChatInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
  {
    FlashChatManager localFlashChatManager = (FlashChatManager)this.this$0.app.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
    paramTagItemInfo.bPreConfig = false;
    paramTagItemInfo.bSaveInDir = false;
    paramTagItemInfo.strSavePath = localFlashChatManager.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateManager", 2, "getItemInfo:  result.strSavePath = " + paramTagItemInfo.strSavePath);
    }
    return paramTagItemInfo;
  }
  
  private VasQuickUpdateEngine.TagItemInfo getBidFontInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
  {
    if (paramString.startsWith("font.diycard.android."))
    {
      paramTagItemInfo.bPreConfig = false;
      paramTagItemInfo.bSaveInDir = true;
      paramTagItemInfo.strSavePath = (azsp.a + paramString.substring("font.diycard.android.".length(), paramString.length()));
    }
    do
    {
      return paramTagItemInfo;
      if (paramString.startsWith("font.hifont.android."))
      {
        paramTagItemInfo.bPreConfig = false;
        paramTagItemInfo.bSaveInDir = true;
        paramTagItemInfo.strSavePath = (avjz.b + paramString.substring("font.hifont.android.".length(), paramString.length()));
        return paramTagItemInfo;
      }
      if (paramString.startsWith("font.hiFontQQ.json."))
      {
        paramTagItemInfo.bPreConfig = false;
        paramTagItemInfo.bSaveInDir = true;
        paramTagItemInfo.strSavePath = (avjz.c + paramString.substring("font.hiFontQQ.json.".length(), paramString.length()));
        return paramTagItemInfo;
      }
      if (paramString.startsWith("font.hiFontQQ.tags"))
      {
        paramTagItemInfo.bPreConfig = false;
        paramTagItemInfo.bSaveInDir = true;
        paramTagItemInfo.strSavePath = avjz.d;
        return paramTagItemInfo;
      }
      if (paramString.startsWith("font.main.android."))
      {
        paramTagItemInfo.bPreConfig = false;
        paramTagItemInfo.bSaveInDir = true;
        paramTagItemInfo.strSavePath = (gb.a + File.separator + paramString.substring("font.main.android.".length(), paramString.length()));
        return paramTagItemInfo;
      }
      if (paramString.startsWith("font.fzfont.android."))
      {
        paramTagItemInfo.bPreConfig = false;
        paramTagItemInfo.bSaveInDir = true;
        paramTagItemInfo.strSavePath = (gb.b + paramString.substring("font.fzfont.android.".length(), paramString.length()));
        return paramTagItemInfo;
      }
    } while (!paramString.equals("magicFontConfig.json"));
    paramTagItemInfo.bPreConfig = false;
    paramTagItemInfo.bSaveInDir = false;
    paramTagItemInfo.strSavePath = gb.g;
    return paramTagItemInfo;
  }
  
  @Nullable
  private VasQuickUpdateEngine.TagItemInfo getBidMaterialInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
  {
    paramTagItemInfo.bPreConfig = false;
    paramTagItemInfo.bSaveInDir = false;
    if (paramString.equals("emojiStickerGuideZip_v2")) {
      paramTagItemInfo.strSavePath = (EmojiStickerManager.a() + "emojiStickerGuideZip_v2.zip");
    }
    do
    {
      return paramTagItemInfo;
      if (paramString.equals("libFlatBuffersParser"))
      {
        paramTagItemInfo.strSavePath = (FlatBuffersParser.a() + "libFlatBuffersParser.zip");
        return paramTagItemInfo;
      }
      if (paramString.equals("kcsdk_4_4_7_3661"))
      {
        paramTagItemInfo.strSavePath = bhzh.a().b(this.this$0.app.getApp());
        return paramTagItemInfo;
      }
      if (paramString.equals("GLDrawableV848"))
      {
        paramTagItemInfo.strSavePath = bhqv.a(this.this$0.app.getApp());
        return paramTagItemInfo;
      }
      if (paramString.equals("libColorFont_818"))
      {
        paramTagItemInfo.strSavePath = (gb.a + File.separator + "libColorFont.zip");
        return paramTagItemInfo;
      }
      if (paramString.equals("libVipFont_808"))
      {
        paramTagItemInfo.strSavePath = (gb.a + File.separator + "libVipFont.zip");
        return paramTagItemInfo;
      }
      if (paramString.startsWith("bqmall.android.h5magic."))
      {
        paramTagItemInfo.strSavePath = asjs.b(paramString);
        return paramTagItemInfo;
      }
      if (paramString.equals("libqgplayer_841"))
      {
        paramTagItemInfo.strSavePath = (blrf.a() + "libQGamePlayer.zip");
        return paramTagItemInfo;
      }
      if (paramString.equals("libAPNG_845"))
      {
        paramTagItemInfo.strSavePath = (this.this$0.app.getApp().getApplicationContext().getFilesDir() + File.separator + "apng.zip");
        return paramTagItemInfo;
      }
      if (paramString.equals("defaultFont_775"))
      {
        paramTagItemInfo.strSavePath = (gb.a + File.separator + "default.zip");
        return paramTagItemInfo;
      }
    } while (!paramString.equals("enterEffectVipIcons"));
    paramString = bfkl.a();
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("VasQuickUpdateManager", 1, "SCID_ENTER_EFFECT_VIP_ICONS getItemInfo null zipPath");
      return null;
    }
    paramTagItemInfo.strSavePath = paramString;
    return paramTagItemInfo;
  }
  
  private boolean getBidPendantInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
  {
    if (paramString.startsWith("faceAddon.stickerFont.android."))
    {
      paramTagItemInfo.bPreConfig = false;
      paramTagItemInfo.bSaveInDir = true;
      paramTagItemInfo.strSavePath = bhcs.b(paramString.replace("faceAddon.stickerFont.android.", ""));
      return true;
    }
    if (paramString.startsWith("faceAddon.sticker."))
    {
      paramTagItemInfo.bPreConfig = false;
      paramTagItemInfo.bSaveInDir = false;
      paramTagItemInfo.strSavePath = (AppConstants.SDCARD_PENDANT_ROOT + "sticker_info/" + paramString.replace("faceAddon.sticker.", ""));
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
        paramTagItemInfo.bPreConfig = false;
        paramTagItemInfo.bSaveInDir = true;
        if (paramString.endsWith(".xydata.js"))
        {
          paramTagItemInfo.bSaveInDir = false;
          localStringBuilder.append("config.json");
        }
        if (paramString.endsWith(".aio_50.png"))
        {
          paramTagItemInfo.bSaveInDir = false;
          localStringBuilder.append("aio_50.png");
        }
        paramTagItemInfo.strSavePath = localStringBuilder.toString();
        return true;
      }
    }
    return false;
  }
  
  @NotNull
  private VasQuickUpdateEngine.TagItemInfo getBidPokeInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
  {
    paramTagItemInfo.bPreConfig = false;
    paramTagItemInfo.bSaveInDir = true;
    if (paramString.startsWith("poke.item.effect.")) {
      paramTagItemInfo.strSavePath = (ahcw.e + paramString.substring("poke.item.effect.".length(), paramString.length()));
    }
    do
    {
      return paramTagItemInfo;
      if (paramString.startsWith("poke.item.res."))
      {
        paramTagItemInfo.strSavePath = (ahcw.e + paramString.substring("poke.item.res.".length(), paramString.length()));
        return paramTagItemInfo;
      }
    } while (!"poke.effectList".equals(paramString));
    paramTagItemInfo.bSaveInDir = false;
    paramTagItemInfo.strSavePath = ahcw.f;
    return paramTagItemInfo;
  }
  
  private boolean getBidPraiseInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
  {
    PraiseManager localPraiseManager = (PraiseManager)this.this$0.app.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
    if ((localPraiseManager != null) && (paramString.startsWith("praise.android.")))
    {
      int i = localPraiseManager.a(paramString);
      if (i > 0)
      {
        paramTagItemInfo.bPreConfig = false;
        paramTagItemInfo.bSaveInDir = true;
        paramTagItemInfo.strSavePath = localPraiseManager.a(i).getAbsolutePath();
        return true;
      }
    }
    return false;
  }
  
  private boolean getBidProfileCard(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
  {
    boolean bool = false;
    if ("cardWZ.zip".equals(paramString))
    {
      paramTagItemInfo.bPreConfig = false;
      paramTagItemInfo.bSaveInDir = true;
      paramTagItemInfo.strSavePath = azso.a(this.this$0.app.getApp());
      bool = true;
    }
    while (!paramString.startsWith("card.")) {
      return bool;
    }
    paramTagItemInfo.bPreConfig = false;
    paramTagItemInfo.bSaveInDir = false;
    int i = Integer.parseInt(paramString.substring("card.".length(), paramString.length()));
    paramString = ((bhou)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_Azrc;
    paramTagItemInfo.strSavePath = azrc.b(this.this$0.app.getApp(), i);
    return true;
  }
  
  @NotNull
  private VasQuickUpdateEngine.TagItemInfo getBidQuickUpdate(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
  {
    paramTagItemInfo.bPreConfig = false;
    if (paramString.endsWith("cfg")) {
      paramTagItemInfo.bPreConfig = true;
    }
    paramTagItemInfo.bSaveInDir = false;
    paramTagItemInfo.strSavePath = (VasQuickUpdateManager.QUICKUPDATE_TEST_DIR + paramString);
    return paramTagItemInfo;
  }
  
  @NotNull
  private VasQuickUpdateEngine.TagItemInfo getBidRedPacket(long paramLong, String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
  {
    paramTagItemInfo.bPreConfig = false;
    if (("iRedPacket_v3.json".equals(paramString)) || ("iRedPacket_v3.char300.json".equals(paramString)))
    {
      paramTagItemInfo.bSaveInDir = false;
      paramTagItemInfo.strSavePath = (this.this$0.app.getApp().getApplicationContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + paramString);
    }
    if ("iRedPacket_v3.font.zip".equals(paramString))
    {
      paramTagItemInfo.bSaveInDir = true;
      paramTagItemInfo.strSavePath = anxc.a(3);
    }
    do
    {
      return paramTagItemInfo;
      if ("iRedPacket_v3.specialChar.zip".equals(paramString))
      {
        paramTagItemInfo.bSaveInDir = true;
        paramTagItemInfo.strSavePath = anxc.a(2);
        return paramTagItemInfo;
      }
    } while ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("luckyMoney.item.")));
    paramTagItemInfo.bSaveInDir = true;
    String str = anxc.a(paramString);
    if (TextUtils.isEmpty(str)) {
      QLog.d("VasQuickUpdateManager", 2, "getItemInfo bid = " + paramLong + " scid = " + paramString + " pid = " + str);
    }
    paramTagItemInfo.strSavePath = (anxc.a(1) + str);
    return paramTagItemInfo;
  }
  
  private boolean getBidSignatureInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
  {
    boolean bool = false;
    if (paramString.startsWith("signature.sticker."))
    {
      paramTagItemInfo.bPreConfig = false;
      paramTagItemInfo.bSaveInDir = false;
      paramTagItemInfo.strSavePath = (AppConstants.SDCARD_SIGNATURE_STICKER_DIR + paramString.substring("signature.sticker.".length(), paramString.length()));
      bool = true;
    }
    return bool;
  }
  
  private boolean getBidTroopEnterEffect(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
  {
    boolean bool = false;
    paramTagItemInfo.bPreConfig = false;
    if (paramString.startsWith("groupeffect_item_"))
    {
      paramTagItemInfo.bSaveInDir = false;
      int i = bfkl.a(paramString);
      paramTagItemInfo.strSavePath = (bfkl.a + i + File.separator + i + ".zip");
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
    aumm localaumm = ((bhou)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_Aumm;
    if (paramString.startsWith("colorScreen.android.")) {
      return Boolean.valueOf(localaumm.a(paramString));
    }
    return null;
  }
  
  @Nullable
  private Boolean isComicExist(String paramString)
  {
    if (paramString.equals("vipComic_nav_config.json")) {
      return Boolean.valueOf(blqy.a());
    }
    if (paramString.equals("vipComic_nav_tabIcon.zip")) {
      return Boolean.valueOf(blqy.b());
    }
    return null;
  }
  
  @Nullable
  private Boolean isFaceExist(String paramString)
  {
    VasFaceManager localVasFaceManager = ((bhou)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_ComTencentMobileqqVasAvatarVasFaceManager;
    if (paramString.startsWith("face.")) {
      return Boolean.valueOf(localVasFaceManager.a(paramString));
    }
    if (paramString.equals("avatarInPendant_json")) {
      return Boolean.valueOf(new File(this.this$0.app.getApplication().getFilesDir() + File.separator + "avatarInPendant.json").exists());
    }
    return null;
  }
  
  @Nullable
  private Boolean isFontExists(String paramString)
  {
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1 = true;
    Object localObject4 = null;
    Object localObject2 = null;
    String str = null;
    Object localObject3 = null;
    Object localObject1 = null;
    boolean bool2 = false;
    int i;
    if (paramString.startsWith("font.diycard.android."))
    {
      paramString = paramString.substring("font.diycard.android.".length(), paramString.length());
      str = azsp.a + paramString;
      localObject2 = new File(str);
      paramString = (String)localObject1;
      if (((File)localObject2).exists()) {
        paramString = ((File)localObject2).list();
      }
      localObject1 = new StringBuilder().append("isFileExists hiboomfont path = ").append(str).append(" exist = ").append(((File)localObject2).exists()).append(" file count = ");
      if (paramString != null)
      {
        i = paramString.length;
        QLog.d("VasQuickUpdateManager", 2, i);
        bool1 = bool2;
        if (((File)localObject2).exists())
        {
          bool1 = bool2;
          if (paramString != null)
          {
            bool1 = bool2;
            if (paramString.length > 0) {
              bool1 = true;
            }
          }
        }
        localObject1 = Boolean.valueOf(bool1);
      }
    }
    label365:
    do
    {
      return localObject1;
      i = 0;
      break;
      if (paramString.startsWith("font.hifont.android."))
      {
        paramString = paramString.substring("font.hifont.android.".length(), paramString.length());
        str = avjz.b + paramString;
        localObject1 = new File(str);
        paramString = (String)localObject2;
        if (((File)localObject1).exists()) {
          paramString = ((File)localObject1).list();
        }
        localObject2 = new StringBuilder().append("isFileExists hiboomfont path = ").append(str).append(" exist = ").append(((File)localObject1).exists()).append(" file count = ");
        if (paramString != null)
        {
          i = paramString.length;
          QLog.d("VasQuickUpdateManager", 2, i);
          if ((!((File)localObject1).exists()) || (paramString == null) || (paramString.length <= 0)) {
            break label365;
          }
        }
        for (;;)
        {
          return Boolean.valueOf(bool1);
          i = 0;
          break;
          bool1 = false;
        }
      }
      if (paramString.startsWith("font.hiFontQQ.json."))
      {
        paramString = paramString.substring("font.hiFontQQ.json.".length(), paramString.length());
        localObject2 = avjz.c + paramString;
        localObject1 = new File((String)localObject2);
        paramString = str;
        if (((File)localObject1).exists()) {
          paramString = ((File)localObject1).list();
        }
        localObject2 = new StringBuilder().append("isFileExists hiboomconfig path = ").append((String)localObject2).append(" exist = ").append(((File)localObject1).exists()).append(" file count = ");
        if (paramString != null)
        {
          i = paramString.length;
          QLog.d("VasQuickUpdateManager", 2, i);
          if ((!((File)localObject1).exists()) || (paramString == null) || (paramString.length <= 0)) {
            break label535;
          }
        }
        for (bool1 = bool3;; bool1 = false)
        {
          return Boolean.valueOf(bool1);
          i = 0;
          break;
        }
      }
      if (paramString.startsWith("font.hiFontQQ.tags"))
      {
        localObject1 = new File(avjz.d);
        paramString = localObject3;
        if (((File)localObject1).exists()) {
          paramString = ((File)localObject1).list();
        }
        if ((paramString != null) && (paramString.length > 0)) {}
        for (bool1 = bool4;; bool1 = false) {
          return Boolean.valueOf(bool1);
        }
      }
      if (paramString.startsWith("font.main.android."))
      {
        paramString = paramString.substring("font.main.android.".length(), paramString.length());
        paramString = gb.a + File.separatorChar + paramString + File.separatorChar + paramString + ".ttf";
        localObject1 = new File(paramString);
        QLog.d("VasQuickUpdateManager", 2, "isFileExists font path = " + paramString + " result = " + ((File)localObject1).exists());
        return Boolean.valueOf(((File)localObject1).exists());
      }
      if (paramString.startsWith("font.fzfont.android."))
      {
        paramString = paramString.substring("font.fzfont.android.".length(), paramString.length());
        paramString = gb.b + paramString + File.separatorChar + paramString + ".ttf";
        localObject1 = new File(paramString);
        QLog.d("VasQuickUpdateManager", 2, "isFileExists font path = " + paramString + " result = " + ((File)localObject1).exists());
        return Boolean.valueOf(((File)localObject1).exists());
      }
      localObject1 = localObject4;
    } while (!paramString.equals("magicFontConfig.json"));
    label535:
    paramString = new File(gb.g);
    QLog.d("VasQuickUpdateManager", 2, "isFileExists fontEffectJson path = " + gb.g + " result = " + paramString.exists());
    return Boolean.valueOf(paramString.exists());
  }
  
  @Nullable
  private Boolean isMaterialExist(String paramString)
  {
    boolean bool = true;
    if (paramString.startsWith("libColorFont_818")) {
      return Boolean.valueOf(new File(bhiw.a() + "libFounderColorFont_818.so").exists());
    }
    if (paramString.startsWith("libFlatBuffersParser")) {
      return Boolean.valueOf(new File(FlatBuffersParser.a() + "libFlatBuffersParser.zip").exists());
    }
    if (paramString.equals("kcsdk_4_4_7_3661")) {
      return Boolean.valueOf(new File(bhzh.a().a(this.this$0.app.getApp())).exists());
    }
    if (paramString.equals("GLDrawableV848")) {
      return Boolean.valueOf(bhqv.a(this.this$0.app.getApp()));
    }
    if (paramString.equals("emojiStickerGuideZip_v2")) {
      return Boolean.valueOf(new File(EmojiStickerManager.a() + "emojiStickerGuideZip_v2.zip").exists());
    }
    if (paramString.equals("libVipFont_808")) {
      return Boolean.valueOf(new File(bhiw.a() + "libvipfont808.so").exists());
    }
    if (paramString.startsWith("bqmall.android.h5magic.")) {
      return Boolean.valueOf(new File(asjs.b(paramString)).exists());
    }
    if (paramString.equals("libqgplayer_841")) {
      return Boolean.valueOf(new File(blrf.a() + "libqgplayer_841.so").exists());
    }
    if (paramString.equals("libAPNG_845")) {
      return Boolean.valueOf(VasApngIPCModule.getInstance().isSoExists());
    }
    if (paramString.equals("defaultFont_775"))
    {
      paramString = new File(bhiw.a() + gm.a);
      if ((paramString.exists()) && (paramString.isDirectory())) {}
      for (;;)
      {
        return Boolean.valueOf(bool);
        bool = false;
      }
    }
    if (paramString.equals("enterEffectVipIcons"))
    {
      paramString = bfkl.a();
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("VasQuickUpdateManager", 1, "SCID_ENTER_EFFECT_VIP_ICONS: get null zipPath");
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
      return Boolean.valueOf(bhcs.a(paramString.replace("faceAddon.stickerFont.android.", "")));
    }
    if (paramString.startsWith("faceAddon.sticker.")) {
      return Boolean.valueOf(bhcs.b(paramString));
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
          bool1 = ahcw.a("effect.gif", i);
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
          bool1 = ahcw.a("bubble", i);
        }
      }
    }
    if ("poke.effectList".equals(paramString)) {
      return Boolean.valueOf(new File(ahcw.f).exists());
    }
    return null;
  }
  
  @Nullable
  private Boolean isProfileCardExist(String paramString)
  {
    if ("cardWZ.zip".equals(paramString)) {
      return Boolean.valueOf(azso.a(this.this$0.app.getApp(), paramString));
    }
    if (paramString.startsWith("card."))
    {
      int i = Integer.parseInt(paramString.substring("card.".length(), paramString.length()));
      paramString = ((bhou)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_Azrc;
      return Boolean.valueOf(azrc.a(this.this$0.app.getApp(), i));
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
          paramString = anxc.a(null, null, 8, 0, 0);
          break;
        }
        if ("iRedPacket_v3.specialChar.zip".equals(paramString))
        {
          paramString = anxc.a(null, null, 25, 0, 0);
          break;
        }
        if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("luckyMoney.item."))) {
          break label295;
        }
        paramString = anxc.a(paramString);
        if (TextUtils.isEmpty(paramString)) {
          break label295;
        }
        paramString = anxc.a(paramString, null, 24, 0, 0);
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
          QLog.d("VasQuickUpdateManager", 2, "isFileExists SCID_REDPACKET_PACKETS_ZIP result = " + bool1);
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
    int i = bfkl.a(paramString);
    if (i > 0) {
      return Boolean.valueOf(bglb.a(new File(bfkl.a + i)));
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
    aumm localaumm = ((bhou)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_Aumm;
    if (paramString.startsWith("colorScreen.android.")) {
      localaumm.a(paramString, paramInt);
    }
  }
  
  private void onComicCompleted(String paramString, int paramInt)
  {
    if (paramInt == 0)
    {
      if (!paramString.equals("vipComic_nav_config.json")) {
        break label18;
      }
      blqy.a();
    }
    label18:
    while (!paramString.equals("vipComic_nav_tabIcon.zip")) {
      return;
    }
    blqy.b();
  }
  
  private void onDefaultCardCompleted(String paramString, int paramInt)
  {
    if (paramString.startsWith("profileitem."))
    {
      azrc localazrc = ((bhou)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_Azrc;
      int i = Integer.parseInt(paramString.substring("profileitem.".length()));
      localazrc.a.remove(Integer.valueOf(i));
      if (paramInt == 0) {
        localazrc.a(i, false);
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
    VasFaceManager localVasFaceManager = ((bhou)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_ComTencentMobileqqVasAvatarVasFaceManager;
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
  
  private void onFontCompleted(String paramString1, String paramString2, int paramInt)
  {
    if (paramString1.startsWith("font.diycard.android.")) {
      if (paramInt == 0)
      {
        paramString1 = paramString1.substring("font.diycard.android.".length(), paramString1.length());
        if (TextUtils.isDigitsOnly(paramString1))
        {
          paramInt = Integer.parseInt(paramString1);
          avjz.a().a(paramInt, 1, avkh.b).a(false);
        }
      }
    }
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            return;
            if (!paramString1.startsWith("font.hifont.android.")) {
              break;
            }
            paramString1 = paramString1.substring("font.hifont.android.".length(), paramString1.length());
          } while (!TextUtils.isDigitsOnly(paramString1));
          i = Integer.parseInt(paramString1);
          if (paramInt == 0) {
            avjz.a().a(i, 0, avkh.a).a(false);
          }
          for (;;)
          {
            ((avkh)this.this$0.app.getManager(QQManagerFactory.HIBOOM_MANAGER)).b(i, paramInt);
            return;
            avjz.a().a(i, 0, avkh.a).a();
          }
          if (!paramString1.startsWith("font.hiFontQQ.json.")) {
            break;
          }
          paramString1 = paramString1.substring("font.hiFontQQ.json.".length(), paramString1.length());
        } while (!TextUtils.isDigitsOnly(paramString1));
        i = Integer.parseInt(paramString1);
        if (paramInt == 0)
        {
          ((avkh)this.this$0.app.getManager(QQManagerFactory.HIBOOM_MANAGER)).a(i, false, true, true);
          return;
        }
        VasWebviewUtil.reportCommercialDrainage(this.this$0.app.getCurrentUin(), "HighFont", "DownCoverFail", "", 1, 0, 0, "", paramString1, "");
        return;
        if (!paramString1.startsWith("font.hiFontQQ.tags")) {
          break;
        }
      } while (paramInt != 0);
      ((avkh)this.this$0.app.getManager(QQManagerFactory.HIBOOM_MANAGER)).a();
      return;
      if (paramString1.startsWith("font.main.android."))
      {
        i = Integer.parseInt(paramString1.substring("font.main.android.".length(), paramString1.length()));
        ((gb)this.this$0.app.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).a(i, paramInt, paramString2);
        return;
      }
      if (paramString1.startsWith("font.fzfont.android."))
      {
        i = Integer.parseInt(paramString1.substring("font.fzfont.android.".length(), paramString1.length()));
        ((gb)this.this$0.app.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).a(i, paramInt, paramString2);
        return;
      }
    } while (!paramString1.equals("magicFontConfig.json"));
    ((gb)this.this$0.app.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).a(new File(gb.g));
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
            paramString = (awyr)this.this$0.app.getManager(QQManagerFactory.EMOTICON_MANAGER);
          } while (paramString == null);
          paramString.d();
          return;
          if (paramString.startsWith("signature.item."))
          {
            bhiw.a(this.this$0.app);
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
              bhnp.a(this.this$0.app);
              return;
            }
          }
          if ("changeVoice_json".equals(paramString))
          {
            ((bicd)this.this$0.app.getManager(QQManagerFactory.VOICE_CHANGE_MANAGER)).a(null, null);
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
          bhpw.a().a(this.this$0.app, true);
          bhln.b(this.this$0.app);
          bhyi.a().a(this.this$0.app);
          return;
        }
        if ("monitorAppid".equals(paramString))
        {
          ((bhpe)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.VAS_MONITOR_HANDLER)).a(this.this$0.app, true);
          return;
        }
        if ("praise.config.json".equals(paramString))
        {
          aztg.a(this.this$0.app);
          return;
        }
        if ("card.diyFontConfig.json".equals(paramString))
        {
          azsq.a(this.this$0.app);
          return;
        }
        if ("vipData_app_webviewNavStyle.json".equals(paramString))
        {
          WebViewTitleStyleHelper.getsInstance().parseJson(this.this$0.app);
          return;
        }
        if ("VASBiz_FuncDev_webview.json".equals(paramString))
        {
          nro.a().j();
          nro.a().e();
          nro.a().c();
          return;
        }
        if (!"watch_focus.json".equals(paramString)) {
          break;
        }
        paramString = (antu)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM);
      } while (paramString == null);
      paramString.c();
      return;
      if ("groupeffect_config.json".equals(paramString))
      {
        ((bfkw)this.this$0.app.getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER)).a(false);
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
      ((gb)this.this$0.app.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).a(4, paramInt);
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
      if (paramString.equals("libVipFont_808"))
      {
        ((gb)this.this$0.app.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).a(1, paramInt);
      }
      else if (paramString.startsWith("bqmall.android.h5magic."))
      {
        ((bhou)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_Asjs.a(paramString, paramInt);
      }
      else if (paramString.equals("libqgplayer_841"))
      {
        blrf.a(this.this$0.app, paramInt);
      }
      else if (paramString.equals("kcsdk_4_4_7_3661"))
      {
        bhzh.a().a(this.this$0.app.getApp(), paramInt);
      }
      else if (paramString.equals("GLDrawableV848"))
      {
        bhqv.a(this.this$0.app.getApp(), paramInt);
      }
      else if (paramString.equals("libAPNG_845"))
      {
        VasApngIPCModule.getInstance().onDownloadCompleted(paramInt);
      }
      else if (paramString.equals("defaultFont_775"))
      {
        gm.a(this.this$0.app, paramInt);
      }
      else if ((paramString.equals("enterEffectVipIcons")) && (paramInt == 0))
      {
        paramString = bfkl.a();
        localObject = bfkl.b();
        if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty((CharSequence)localObject)))
        {
          QLog.e("VasQuickUpdateManager", 1, "SCID_ENTER_EFFECT_VIP_ICONS onComplete null path: " + paramString + "," + (String)localObject);
          return true;
        }
        try
        {
          FileUtils.uncompressZip(paramString, (String)localObject, false);
        }
        catch (IOException paramString)
        {
          QLog.e("VasQuickUpdateManager", 1, "SCID_ENTER_EFFECT_VIP_ICONS onCompleted error", paramString);
        }
      }
    }
  }
  
  private void onPokeCompleted(String paramString)
  {
    if ("poke.effectList".equals(paramString))
    {
      paramString = (asbm)this.this$0.app.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
      if (paramString != null)
      {
        paramString = (ascd)paramString.a("qq.android.poke.res_0625");
        if (paramString != null) {
          paramString.f();
        }
      }
    }
  }
  
  private void onProfileCardCompleted(String paramString1, String paramString2, int paramInt)
  {
    if ("cardWZ.zip".equals(paramString1)) {
      azso.a(this.this$0.app, paramString1, paramString2, paramInt);
    }
    while (!paramString1.startsWith("card.")) {
      return;
    }
    ((bhou)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_Azrc.a(this.this$0.app, paramString1, paramString2, paramInt);
  }
  
  private void onTroopEnterEffectCompleted(String paramString, int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = bfkl.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect", 2, "download Res onCompleted success id = " + paramInt);
      }
      if (paramInt > 0) {
        paramString = bfkl.a(paramInt);
      }
    }
    try
    {
      if (new File(paramString).exists()) {
        FileUtils.uncompressZip(paramString, bfkl.a, false);
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
        amks.a().b(paramString);
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
          amks.a().a(paramString);
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
      paramString = (bhom)this.this$0.app.getManager(QQManagerFactory.SONIC_FILE_DISCARD_MANAGER);
      if (paramString != null) {
        paramString.a();
      }
    }
  }
  
  public boolean canUpdate(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2)
  {
    if ((paramLong == 5L) && (paramString1.startsWith("font.main.android.")))
    {
      paramQQAppInterface = paramString1.substring("font.main.android.".length(), paramString1.length());
      if (TextUtils.isEmpty(paramQQAppInterface))
      {
        if (QLog.isColorLevel()) {
          QLog.e("VasQuickUpdateManager", 2, "canUpdate error: font id is empty");
        }
        return false;
      }
      int i = Integer.parseInt(paramQQAppInterface);
      if (!((gb)this.this$0.app.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).a(i)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return true;
  }
  
  public boolean deleteFiles(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    boolean bool;
    if ((paramLong == 1000L) || (paramLong == 1003L) || (paramLong == 21L) || (paramLong == 2L) || (paramLong == 16L) || (paramLong == 20L) || (paramLong == 4L) || (paramLong == 23L)) {
      bool = deleteJsonFile(paramQQAppInterface, paramLong, paramString).booleanValue();
    }
    for (;;)
    {
      QLog.e("VasQuickUpdateManager", 1, "deleteFiles : bid = " + paramLong + " scid = " + paramString + " result:" + bool);
      return bool;
      if (paramLong == 1004L)
      {
        bool = deleteMatriel(paramString).booleanValue();
      }
      else if (paramLong == 5L)
      {
        bool = deleteFont(paramString).booleanValue();
      }
      else if (paramLong == 9L)
      {
        bool = deleteSignature(paramString).booleanValue();
      }
      else if (paramLong == 15L)
      {
        bool = deleteProfileCard(paramString).booleanValue();
      }
      else if (paramLong == 22L)
      {
        paramQQAppInterface = ((bhou)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_Aumm;
        if (paramString.startsWith("colorScreen.android.")) {
          paramQQAppInterface.a(paramString);
        }
        bool = false;
      }
      else if (paramLong == 1999L)
      {
        paramQQAppInterface = VasQuickUpdateManager.QUICKUPDATE_TEST_DIR + paramString;
        bool = VasQuickUpdateEngine.safeDeleteFile(new File(paramQQAppInterface));
        QLog.d("VasQuickUpdateManager", 2, "deleteFiles: quickupdate test path = " + paramQQAppInterface + " result = " + bool);
      }
      else if (paramLong == 25L)
      {
        int i = bfkl.a(paramString);
        paramQQAppInterface = bfkl.a + i;
        bool = VasQuickUpdateEngine.safeDeleteFile(new File(paramQQAppInterface));
        QLog.d("VasQuickUpdateManager", 2, "deleteFiles: ENTER_EFFECT path = " + paramQQAppInterface + " result = " + bool);
      }
      else if (paramLong == 8L)
      {
        paramQQAppInterface = paramString.substring("chatbg.".length(), paramString.length());
        ChatBackgroundManager localChatBackgroundManager = (ChatBackgroundManager)this.this$0.app.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
        bool = VasQuickUpdateEngine.safeDeleteFile(new File(ChatBackgroundManager.g(paramQQAppInterface)));
      }
      else if (paramLong == 27L)
      {
        paramQQAppInterface = paramString.substring("groupnickitem.".length(), paramString.length());
        paramQQAppInterface = bhmb.a + paramQQAppInterface;
        bool = VasQuickUpdateEngine.safeDeleteFile(new File(paramQQAppInterface));
        QLog.d("VasQuickUpdateManager", 2, "deleteFiles: COLOR_NICK path = " + paramQQAppInterface + " result = " + bool);
      }
      else if (paramLong == 33L)
      {
        paramQQAppInterface = paramString.substring("profileitem.".length());
        bool = VasQuickUpdateEngine.safeDeleteFile(new File(azrc.a(paramQQAppInterface)));
        QLog.d("VasQuickUpdateManager", 2, "deleteFiles: Default Card Config id=" + paramQQAppInterface + " ret=" + bool);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public void doOnCompleted(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
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
      if (paramLong == 5L)
      {
        onFontCompleted(paramString1, paramString3, paramInt1);
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
          ((ChatBackgroundManager)this.this$0.app.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2, this.this$0);
        } else if (paramLong == 33L) {
          onDefaultCardCompleted(paramString1, paramInt1);
        }
      }
    }
  }
  
  public void doOnProgress(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (paramLong1 == 2L) {
      ((BubbleManager)this.this$0.app.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER)).a(paramString1, paramString2, paramLong2, paramLong3);
    }
    fontProgress(paramLong1, paramString1, paramLong2, paramLong3);
    if ((paramLong1 == 1004L) && (paramString1.startsWith("bqmall.android.h5magic."))) {
      ((bhou)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_Asjs.a(paramString1, paramLong2, paramLong3);
    }
    if (paramLong1 == 15L) {
      if (paramString1.startsWith("card.")) {
        ((bhou)this.this$0.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_Azrc.a(Integer.parseInt(paramString1.substring("card.".length(), paramString1.length())), (int)(100L * paramLong2 / paramLong3));
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
  
  public VasQuickUpdateEngine.TagItemInfo getItemInfo(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    paramQQAppInterface = new VasQuickUpdateEngine.TagItemInfo();
    if ((paramLong == 1000L) || (paramLong == 1001L)) {
      return getBIdJsonInfo(paramString, paramQQAppInterface);
    }
    if (paramLong == 1002L) {
      return getBidFlashChatInfo(paramString, paramQQAppInterface);
    }
    if (paramLong == 5L) {
      return getBidFontInfo(paramString, paramQQAppInterface);
    }
    boolean bool;
    if (paramLong == 22L) {
      bool = getBidColorScreenInfo(paramString, paramQQAppInterface);
    }
    for (;;)
    {
      if (bool)
      {
        return paramQQAppInterface;
        if (paramLong == 23L)
        {
          bool = getBidFaceInfo(paramString, paramQQAppInterface);
          continue;
        }
        if (paramLong == 2L)
        {
          bool = getBidBubbleInfo(paramString, paramQQAppInterface);
          continue;
        }
        if (paramLong == 4L)
        {
          bool = getBidPendantInfo(paramString, paramQQAppInterface);
          continue;
        }
        if (paramLong == 20L)
        {
          bool = getBidPraiseInfo(paramString, paramQQAppInterface);
          continue;
        }
        Object localObject;
        if (paramLong == 1003L)
        {
          paramQQAppInterface.bPreConfig = false;
          paramQQAppInterface.bSaveInDir = false;
          localObject = this.this$0.app.getApplication().getFilesDir() + File.separator;
          paramQQAppInterface.strSavePath = ((String)localObject + paramString);
          return paramQQAppInterface;
        }
        if (paramLong == 16L) {
          return getBidRedPacket(paramLong, paramString, paramQQAppInterface);
        }
        if (paramLong == 1004L) {
          return getBidMaterialInfo(paramString, paramQQAppInterface);
        }
        if (paramLong == 15L)
        {
          if (getBidProfileCard(paramString, paramQQAppInterface)) {
            return paramQQAppInterface;
          }
        }
        else
        {
          if (paramLong == 21L) {
            return getBidPokeInfo(paramString, paramQQAppInterface);
          }
          if (paramLong == 9L)
          {
            bool = getBidSignatureInfo(paramString, paramQQAppInterface);
            continue;
          }
          if (paramLong == 1999L) {
            return getBidQuickUpdate(paramString, paramQQAppInterface);
          }
          if (paramLong == 100L) {
            return getBidComicInfo(paramString, paramQQAppInterface);
          }
          if (paramLong == 25L)
          {
            bool = getBidTroopEnterEffect(paramString, paramQQAppInterface);
            continue;
          }
          if (paramLong == 8L)
          {
            localObject = (ChatBackgroundManager)this.this$0.app.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
            paramString = paramString.substring("chatbg.".length(), paramString.length());
            paramQQAppInterface.bSaveInDir = false;
            paramQQAppInterface.bPreConfig = false;
            paramQQAppInterface.strSavePath = ((ChatBackgroundManager)localObject).f(paramString);
            return paramQQAppInterface;
          }
          if (paramLong == 27L)
          {
            paramString = paramString.substring("groupnickitem.".length(), paramString.length());
            paramQQAppInterface.bSaveInDir = true;
            paramQQAppInterface.bPreConfig = false;
            paramQQAppInterface.strSavePath = (bhmb.a + paramString);
            return paramQQAppInterface;
          }
          if (paramLong == 33L)
          {
            paramString = paramString.substring("profileitem.".length());
            paramQQAppInterface.bSaveInDir = false;
            paramQQAppInterface.bPreConfig = false;
            paramQQAppInterface.strSavePath = azrc.a(paramString);
            return paramQQAppInterface;
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
  
  public boolean isFileExists(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    paramQQAppInterface = null;
    if (paramLong == 1000L) {
      return new File(this.this$0.app.getApplication().getFilesDir(), paramString).exists();
    }
    if (paramLong == 5L) {
      paramQQAppInterface = isFontExists(paramString);
    }
    while (paramQQAppInterface != null)
    {
      return paramQQAppInterface.booleanValue();
      if (paramLong == 2L)
      {
        paramQQAppInterface = isBubbleExist(paramString);
      }
      else if (paramLong == 22L)
      {
        paramQQAppInterface = isColorScreenExist(paramString);
      }
      else if (paramLong == 23L)
      {
        paramQQAppInterface = isFaceExist(paramString);
      }
      else if (paramLong == 4L)
      {
        paramQQAppInterface = isPendantExist(paramString);
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
          paramQQAppInterface = isProfileCardExist(paramString);
        }
        else if (paramLong == 21L)
        {
          paramQQAppInterface = isPokeExist(paramString);
        }
        else if (paramLong == 1004L)
        {
          paramQQAppInterface = isMaterialExist(paramString);
        }
        else if (paramLong == 9L)
        {
          paramQQAppInterface = isSignatureExist(paramString);
        }
        else
        {
          if (paramLong == 1999L) {
            return new File(VasQuickUpdateManager.QUICKUPDATE_TEST_DIR + paramString).exists();
          }
          if (paramLong == 100L)
          {
            paramQQAppInterface = isComicExist(paramString);
          }
          else if (paramLong == 25L)
          {
            paramQQAppInterface = isTroopEnterEffectExist(paramString);
          }
          else
          {
            if (paramLong == 8L)
            {
              paramQQAppInterface = paramString.substring("chatbg.".length(), paramString.length());
              return ((ChatBackgroundManager)this.this$0.app.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(paramQQAppInterface);
            }
            if (paramLong == 27L) {
              return new File(bhmb.a(paramString.substring("groupnickitem.".length(), paramString.length()))).exists();
            }
            if (paramLong == 33L) {
              return new File(azrc.a(paramString.substring("profileitem.".length()))).exists();
            }
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager.DefaultUpdateCallback
 * JD-Core Version:    0.7.0.1
 */