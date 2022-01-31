package com.tencent.mobileqq.vas;

import adwl;
import aiqz;
import ajsf;
import ajvp;
import ajzf;
import android.content.Context;
import android.text.TextUtils;
import anox;
import anpq;
import anxb;
import aocr;
import apzf;
import aqwz;
import aqxb;
import aqxh;
import askd;
import auux;
import auwn;
import auwo;
import auwp;
import auws;
import azrl;
import azrw;
import balg;
import bbby;
import bbdj;
import bbkv;
import bbnq;
import bboe;
import bbpp;
import bbqh;
import bbqj;
import bbqs;
import bbrc;
import bbrt;
import bbsk;
import bbso;
import bbwa;
import bbwx;
import bbwz;
import bbzp;
import bcbi;
import bghd;
import bghi;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ho;
import ia;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import mqq.app.MobileQQ;
import mvv;

class VasQuickUpdateManager$2
  extends bbso
{
  VasQuickUpdateManager$2(VasQuickUpdateManager paramVasQuickUpdateManager) {}
  
  public void _onCompleted(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if ((QLog.isColorLevel()) || (paramInt1 != 0)) {
      QLog.d("VasQuickUpdateManager", 2, "onCompleted bid = " + paramLong + " scid = " + paramString1 + " from = " + paramString3 + " errorCode = " + paramInt1 + " httpCode = " + paramInt2);
    }
    if (paramLong == 1000L) {
      if (paramString1.equals("keywordList_2.json"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateManager", 2, "onCompleted emoji keyword errorCode = " + paramInt1);
        }
        if (paramInt1 == 0)
        {
          paramQQAppInterface = (askd)this.this$0.app.getManager(14);
          if (paramQQAppInterface != null) {
            paramQQAppInterface.d();
          }
        }
      }
    }
    label287:
    label1826:
    for (;;)
    {
      this.this$0.callBackToAll(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      boolean bool;
      int i;
      label1404:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (paramString1.startsWith("signature.item."))
                {
                  if (paramInt1 != 0) {
                    break;
                  }
                  bbkv.a(this.this$0.app);
                  break;
                }
                if ("vipData_individuation_url.android.json".equals(paramString1))
                {
                  if (QLog.isColorLevel())
                  {
                    paramQQAppInterface = new StringBuilder().append("onCompleted url_configurable ,errorCode = ").append(paramInt1).append(", app=");
                    if (this.this$0.app == null) {
                      break label287;
                    }
                  }
                  for (bool = true;; bool = false)
                  {
                    QLog.d("VasQuickUpdateManager", 2, bool);
                    if (paramInt1 != 0) {
                      break;
                    }
                    bbpp.a(this.this$0.app);
                    break;
                  }
                }
                if ("changeVoice_json".equals(paramString1))
                {
                  if (paramInt1 != 0) {
                    break;
                  }
                  ((bbzp)this.this$0.app.getManager(176)).a(null, null);
                  break;
                }
                if ("blessVoiceList.json".equals(paramString1))
                {
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("VasQuickUpdateManager", 2, "onCompleted blessVoiceChange ,errorCode = " + paramInt1);
                  break;
                }
                if ("vip_personal_card.json".equals(paramString1))
                {
                  if (paramInt1 != 0) {
                    break;
                  }
                  bbrt.a().a(this.this$0.app, true);
                  bbnq.b(this.this$0.app);
                  bbwa.a().a(this.this$0.app);
                  break;
                }
                if ("monitorAppid".equals(paramString1))
                {
                  if (paramInt1 != 0) {
                    break;
                  }
                  ((bbrc)this.this$0.app.a(103)).a(this.this$0.app, true);
                  break;
                }
                if ("praise.config.json".equals(paramString1))
                {
                  if (paramInt1 != 0) {
                    break;
                  }
                  auws.a(this.this$0.app);
                  break;
                }
                if ("card.diyFontConfig.json".equals(paramString1))
                {
                  if (paramInt1 != 0) {
                    break;
                  }
                  auwp.a(this.this$0.app);
                  break;
                }
                if ("vipData_app_webviewNavStyle.json".equals(paramString1))
                {
                  if (paramInt1 != 0) {
                    break;
                  }
                  bcbi.a().a(this.this$0.app);
                  break;
                }
                if ("VASBiz_FuncDev_webview.json".equals(paramString1))
                {
                  if (paramInt1 != 0) {
                    break;
                  }
                  mvv.a().j();
                  mvv.a().e();
                  mvv.a().c();
                  break;
                }
                if ("watch_focus.json".equals(paramString1))
                {
                  if (paramInt1 != 0) {
                    break;
                  }
                  paramQQAppInterface = (ajvp)this.this$0.app.a(12);
                  if (paramQQAppInterface == null) {
                    break;
                  }
                  paramQQAppInterface.c();
                  break;
                }
                if ("groupeffect_config.json".equals(paramString1))
                {
                  if (paramInt1 != 0) {
                    break;
                  }
                  ((azrw)this.this$0.app.getManager(231)).a(false);
                  break;
                }
                if ((!"emoji.systemEmojiWhiteList.json".equals(paramString1)) || (paramInt1 != 0)) {
                  break;
                }
                aocr.a(this.this$0.app, true);
                break;
                if (paramLong == 5L)
                {
                  if (paramString1.startsWith("font.diycard.android."))
                  {
                    if (paramInt1 != 0) {
                      break;
                    }
                    paramQQAppInterface = paramString1.substring("font.diycard.android.".length(), paramString1.length());
                    if (!TextUtils.isDigitsOnly(paramQQAppInterface)) {
                      break;
                    }
                    i = Integer.parseInt(paramQQAppInterface);
                    aqwz.a().a(i, 1, aqxh.b).a(false);
                    break;
                  }
                  if (paramString1.startsWith("font.hifont.android."))
                  {
                    paramQQAppInterface = paramString1.substring("font.hifont.android.".length(), paramString1.length());
                    if (!TextUtils.isDigitsOnly(paramQQAppInterface)) {
                      break;
                    }
                    i = Integer.parseInt(paramQQAppInterface);
                    if (paramInt1 == 0) {
                      aqwz.a().a(i, 0, aqxh.a).a(false);
                    }
                    for (;;)
                    {
                      ((aqxh)this.this$0.app.getManager(219)).b(i, paramInt1);
                      break;
                      aqwz.a().a(i, 0, aqxh.a).a();
                    }
                  }
                  if (paramString1.startsWith("font.hiFontQQ.json."))
                  {
                    paramQQAppInterface = paramString1.substring("font.hiFontQQ.json.".length(), paramString1.length());
                    if (!TextUtils.isDigitsOnly(paramQQAppInterface)) {
                      break;
                    }
                    i = Integer.parseInt(paramQQAppInterface);
                    if (paramInt1 == 0)
                    {
                      ((aqxh)this.this$0.app.getManager(219)).a(i, false, true, true);
                      break;
                    }
                    VasWebviewUtil.reportCommercialDrainage(this.this$0.app.c(), "HighFont", "DownCoverFail", "", 1, 0, 0, "", paramQQAppInterface, "");
                    break;
                  }
                  if (paramString1.startsWith("font.hiFontQQ.tags"))
                  {
                    if (paramInt1 != 0) {
                      break;
                    }
                    ((aqxh)this.this$0.app.getManager(219)).a();
                    break;
                  }
                  if (paramString1.startsWith("font.main.android."))
                  {
                    i = Integer.parseInt(paramString1.substring("font.main.android.".length(), paramString1.length()));
                    ((ho)this.this$0.app.getManager(42)).a(i, paramInt1, paramString3);
                    break;
                  }
                  if (paramString1.startsWith("font.fzfont.android."))
                  {
                    i = Integer.parseInt(paramString1.substring("font.fzfont.android.".length(), paramString1.length()));
                    ((ho)this.this$0.app.getManager(42)).a(i, paramInt1, paramString3);
                    break;
                  }
                  if (!paramString1.equals("magicFontConfig.json")) {
                    break;
                  }
                  ((ho)this.this$0.app.getManager(42)).a(new File(ho.g));
                  break;
                }
                if (paramLong == 2L)
                {
                  paramQQAppInterface = (BubbleManager)this.this$0.app.getManager(44);
                  if (paramString1.startsWith("bubble.android."))
                  {
                    paramQQAppInterface.b(paramString1, paramString2, paramString3, paramInt1, paramInt2);
                    break;
                  }
                  if (!paramString1.startsWith("bubble.paster.")) {
                    break;
                  }
                  paramQQAppInterface.a(paramString1, paramString2, paramString3, paramInt1, paramInt2);
                  break;
                }
                if (paramLong == 22L)
                {
                  paramQQAppInterface = ((bbqs)this.this$0.app.getManager(235)).jdField_a_of_type_Apzf;
                  if (!paramString1.startsWith("colorScreen.android.")) {
                    break;
                  }
                  paramQQAppInterface.a(paramString1, paramInt1);
                  break;
                }
                if (paramLong == 23L)
                {
                  paramQQAppInterface = ((bbqs)this.this$0.app.getManager(235)).jdField_a_of_type_ComTencentMobileqqVasAvatarVasFaceManager;
                  if (!paramString1.startsWith("face.")) {
                    break;
                  }
                  paramQQAppInterface.a(paramString1, paramInt1);
                  break;
                }
                if (paramLong != 4L) {
                  break label1581;
                }
                if (!paramString1.startsWith("faceAddon.stickerFont.android.")) {
                  break label1404;
                }
              } while (paramInt1 != 0);
              aiqz.a().b(paramString1);
              return;
              if (!paramString1.startsWith("faceAddon.sticker.")) {
                break label1429;
              }
            } while (paramInt1 != 0);
            aiqz.a().a(paramString1);
            return;
          } while ((!paramString1.startsWith("pendant.")) || (paramString1.length() <= "pendant.".length()));
          paramQQAppInterface = paramString1.substring("pendant.".length(), paramString1.length());
          paramInt1 = paramQQAppInterface.indexOf(".");
        } while (paramInt1 <= 0);
        paramLong = Long.parseLong(paramQQAppInterface.substring(0, paramInt1));
        paramString1 = (AvatarPendantManager)this.this$0.app.getManager(46);
        if (paramQQAppInterface.endsWith(".xydata.js"))
        {
          paramString1.a(paramLong).a(PendantInfo.g);
          return;
        }
        if (paramQQAppInterface.endsWith(".aio_50.png"))
        {
          paramString1.a(paramLong).b(paramLong, 1);
          return;
        }
      } while (!paramQQAppInterface.endsWith(".other.zip"));
      paramString1.a(paramLong).b(paramLong, 2);
      return;
      label1581:
      if (paramLong == 1001L)
      {
        if ((paramInt1 == 0) && ("sonicTemplateUpdate.json".equals(paramString1)))
        {
          paramQQAppInterface = (bbqh)this.this$0.app.getManager(192);
          if (paramQQAppInterface != null) {
            paramQQAppInterface.a();
          }
        }
      }
      else if (paramLong == 20L)
      {
        ((PraiseManager)this.this$0.app.getManager(209)).a(paramString1, paramString2, paramString3, paramInt1, paramInt2);
      }
      else if (paramLong == 1003L)
      {
        if ((paramInt1 != 0) || (!"emotionRecommendEffect".equals(paramString1))) {}
      }
      else if (paramLong == 1004L)
      {
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder().append("onCompleted sticker material ,errorCode = ").append(paramInt1).append(", app=");
          if (this.this$0.app != null)
          {
            bool = true;
            label1751:
            QLog.d("VasQuickUpdateManager", 2, bool);
          }
        }
        else if (paramInt1 == 0)
        {
          if (!paramString1.equals("emojiStickerGuideZip_v2")) {
            break label1826;
          }
          EmojiStickerManager.a();
        }
        for (;;)
        {
          if (!paramString1.equals(VasQuickUpdateManager.SCID_COLORFONT_SO)) {
            break label1843;
          }
          ((ho)this.this$0.app.getManager(42)).a(4, paramInt1);
          break;
          bool = false;
          break label1751;
          if (paramString1.equals(VasQuickUpdateManager.SCID_FLATBUFFERS)) {
            FlatBuffersParser.e();
          }
        }
        label1843:
        if (paramString1.equals(VasQuickUpdateManager.SCID_HYFONT_SO))
        {
          ((ho)this.this$0.app.getManager(42)).a(1, paramInt1);
        }
        else if (paramString1.startsWith("bqmall.android.h5magic."))
        {
          ((bbqs)this.this$0.app.getManager(235)).jdField_a_of_type_Anxb.a(paramString1, paramInt1);
        }
        else if (paramString1.equals(VasQuickUpdateManager.SCID_COMIC_PLAYER_SO))
        {
          bghi.a(this.this$0.app, paramInt1);
        }
        else if (paramString1.equals("kcsdk_4_4_7_3"))
        {
          bbwx.a().a(this.this$0.app.getApp(), paramInt1);
        }
        else if (paramString1.equals("GLDrawableV828"))
        {
          bbsk.a(this.this$0.app.getApp(), paramInt1);
        }
        else if (paramString1.equals(VasQuickUpdateManager.SCID_APNG_SO))
        {
          bbqj.a().a(paramInt1);
        }
        else if (paramString1.equals("defaultFont_775"))
        {
          ia.a(this.this$0.app, paramInt1);
        }
        else if ((paramString1.equals("enterEffectVipIcons")) && (paramInt1 == 0))
        {
          paramQQAppInterface = azrl.a();
          String str = azrl.b();
          if ((TextUtils.isEmpty(paramQQAppInterface)) || (TextUtils.isEmpty(str)))
          {
            QLog.e("VasQuickUpdateManager", 1, "SCID_ENTER_EFFECT_VIP_ICONS onComplete null path: " + paramQQAppInterface + "," + str);
            return;
          }
          try
          {
            bbdj.a(paramQQAppInterface, str, false);
          }
          catch (IOException paramQQAppInterface)
          {
            QLog.e("VasQuickUpdateManager", 1, "SCID_ENTER_EFFECT_VIP_ICONS onCompleted error", paramQQAppInterface);
          }
        }
      }
      else if (paramLong == 1002L)
      {
        paramQQAppInterface = (FlashChatManager)this.this$0.app.getManager(217);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.a(paramString1, paramInt1);
        }
      }
      else if (paramLong == 15L)
      {
        if ("cardWZ.zip".equals(paramString1)) {
          auwn.a(this.this$0.app, paramString1, paramString3, paramInt1);
        } else if (paramString1.startsWith("card.")) {
          ((bbqs)this.this$0.app.getManager(235)).jdField_a_of_type_Auux.a(this.this$0.app, paramString1, paramString3, paramInt1);
        }
      }
      else if (paramLong == 21L)
      {
        if ("poke.effectList".equals(paramString1))
        {
          paramQQAppInterface = (anox)this.this$0.app.getManager(77);
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface = (anpq)paramQQAppInterface.a("qq.android.poke.res_0625");
            if (paramQQAppInterface != null) {
              paramQQAppInterface.a();
            }
          }
        }
      }
      else if (paramLong == 9L)
      {
        if ((!paramString1.startsWith("signature.sticker.")) || (paramInt1 != 0)) {}
      }
      else if (paramLong == 100L)
      {
        if (paramInt1 == 0) {
          if (paramString1.equals("vipComic_nav_config.json")) {
            bghd.a();
          } else if (paramString1.equals("vipComic_nav_tabIcon.zip")) {
            bghd.b();
          }
        }
      }
      else if ((paramLong == 25L) && (paramString1.startsWith("groupeffect_item_")))
      {
        if (paramInt1 == 0)
        {
          i = azrl.a(paramString1);
          if (QLog.isColorLevel()) {
            QLog.d("TroopEnterEffect", 2, "download Res onCompleted success id = " + i);
          }
          if (i > 0)
          {
            paramQQAppInterface = azrl.a(i);
            try
            {
              if (!new File(paramQQAppInterface).exists()) {
                continue;
              }
              bbdj.a(paramQQAppInterface, azrl.a, false);
            }
            catch (Exception paramQQAppInterface)
            {
              QLog.e("TroopEnterEffect", 1, "Res Download unCompress error: " + paramQQAppInterface.getLocalizedMessage());
            }
          }
        }
      }
      else if (paramLong == 8L)
      {
        ((ChatBackgroundManager)this.this$0.app.getManager(63)).a(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2, this.this$0);
      }
      else if ((paramLong == 33L) && (paramString1.startsWith("profileitem.")))
      {
        paramQQAppInterface = ((bbqs)this.this$0.app.getManager(235)).jdField_a_of_type_Auux;
        i = Integer.parseInt(paramString1.substring("profileitem.".length()));
        paramQQAppInterface.a.remove(Integer.valueOf(i));
        if (paramInt1 == 0) {
          paramQQAppInterface.a(i, false);
        } else {
          QLog.e("VasQuickUpdateManager", 2, "onCompleted: default card download error: " + paramInt1 + " scid=" + paramString1);
        }
      }
    }
  }
  
  public void _onProgress(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (paramLong1 == 2L) {
      ((BubbleManager)this.this$0.app.getManager(44)).a(paramString1, paramString2, paramLong2, paramLong3);
    }
    int i;
    if (paramLong1 == 5L)
    {
      if (paramString1.startsWith("font.main.android."))
      {
        i = Integer.parseInt(paramString1.substring("font.main.android.".length(), paramString1.length()));
        ((ho)this.this$0.app.getManager(42)).a(i, (float)paramLong2 / (float)paramLong3);
      }
    }
    else
    {
      if ((paramLong1 == 1004L) && (paramString1.startsWith("bqmall.android.h5magic."))) {
        ((bbqs)this.this$0.app.getManager(235)).jdField_a_of_type_Anxb.a(paramString1, paramLong2, paramLong3);
      }
      if (paramLong1 != 15L) {
        break label316;
      }
      if (paramString1.startsWith("card.")) {
        ((bbqs)this.this$0.app.getManager(235)).jdField_a_of_type_Auux.a(Integer.parseInt(paramString1.substring("card.".length(), paramString1.length())), (int)(100L * paramLong2 / paramLong3));
      }
    }
    for (;;)
    {
      this.this$0.onProgressToAll(paramLong1, paramString1, paramString2, paramLong2, paramLong3);
      return;
      if (!paramString1.startsWith("font.hifont.android.")) {
        break;
      }
      paramQQAppInterface = paramString1.substring("font.hifont.android.".length(), paramString1.length());
      if ((TextUtils.isEmpty(paramQQAppInterface)) || (!TextUtils.isDigitsOnly(paramQQAppInterface))) {
        break;
      }
      i = Integer.parseInt(paramQQAppInterface);
      ((aqxh)this.this$0.app.getManager(219)).a(i, (int)(100L * paramLong2 / paramLong3));
      break;
      label316:
      if (paramLong1 == 8L) {
        ((ChatBackgroundManager)this.this$0.app.getManager(63)).a(this.this$0.app, paramLong1, paramString1, (int)(100L * paramLong2 / paramLong3));
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
      if (!((ho)this.this$0.app.getManager(42)).a(i)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return true;
  }
  
  public boolean deleteFiles(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateManager", 2, "deleteFiles: bid = " + paramLong + " scid = " + paramString);
    }
    boolean bool2;
    boolean bool1;
    if ((paramLong == 1000L) || (paramLong == 1003L) || (paramLong == 21L) || (paramLong == 2L) || (paramLong == 16L) || (paramLong == 20L) || (paramLong == 4L) || (paramLong == 23L))
    {
      paramQQAppInterface = getItemInfo(paramQQAppInterface, paramLong, paramString);
      if (paramQQAppInterface == null) {
        break label1620;
      }
      bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(paramQQAppInterface.strSavePath));
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("VasQuickUpdateManager", 2, "deleteFiles: bid=" + paramLong + " scid=" + paramString + ", result=" + bool2);
        bool1 = bool2;
      }
    }
    label1291:
    label1575:
    label1620:
    label1658:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return bool1;
                        if (paramLong == 1004L)
                        {
                          if (paramString.equals(VasQuickUpdateManager.SCID_COLORFONT_SO)) {
                            return VasQuickUpdateEngine.safeDeleteFile(new File(bbkv.a() + "libFounderColorFont_818.so"));
                          }
                          if (paramString.equals("kcsdk_4_4_7_3")) {
                            return VasQuickUpdateEngine.safeDeleteFile(new File(bbwx.a().a(this.this$0.app.getApp())));
                          }
                          if (paramString.equals("GLDrawableV828")) {
                            return VasQuickUpdateEngine.safeDeleteFile(bbsk.a(this.this$0.app.getApp()));
                          }
                          if (paramString.equals(VasQuickUpdateManager.SCID_FLATBUFFERS))
                          {
                            FlatBuffersParser.g();
                            return true;
                          }
                          if (paramString.equals(VasQuickUpdateManager.SCID_HYFONT_SO)) {
                            return VasQuickUpdateEngine.safeDeleteFile(new File(bbkv.a() + "libvipfont808.so"));
                          }
                          if (paramString.startsWith("bqmall.android.h5magic."))
                          {
                            anxb.a(paramString);
                            return true;
                          }
                          if (paramString.equals(VasQuickUpdateManager.SCID_COMIC_PLAYER_SO)) {
                            return VasQuickUpdateEngine.safeDeleteFile(new File(bghi.a() + "libqgplayer_765.so"));
                          }
                          if (paramString.equals(VasQuickUpdateManager.SCID_APNG_SO)) {
                            return VasQuickUpdateEngine.safeDeleteFile(new File(bbkv.a() + "libAPNG_release_813.so"));
                          }
                          if (paramString.equals("defaultFont_775")) {
                            return VasQuickUpdateEngine.safeDeleteFile(new File(ia.a()));
                          }
                          if (!paramString.equals("enterEffectVipIcons")) {
                            break label1620;
                          }
                          paramQQAppInterface = azrl.a();
                          if (!TextUtils.isEmpty(paramQQAppInterface)) {
                            VasQuickUpdateEngine.safeDeleteFile(new File(paramQQAppInterface));
                          }
                          return true;
                        }
                        if (paramLong != 5L) {
                          break label1291;
                        }
                        if (!paramString.startsWith("font.diycard.android.")) {
                          break;
                        }
                        paramQQAppInterface = paramString.substring("font.diycard.android.".length(), paramString.length());
                        paramQQAppInterface = auwo.a + paramQQAppInterface;
                        bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(paramQQAppInterface));
                        bool1 = bool2;
                      } while (!QLog.isColorLevel());
                      QLog.d("VasQuickUpdateManager", 2, "deleteFiles: font diy card path = " + paramQQAppInterface + " result = " + bool2);
                      return bool2;
                      if (!paramString.startsWith("font.hifont.android.")) {
                        break;
                      }
                      paramQQAppInterface = paramString.substring("font.hifont.android.".length(), paramString.length());
                      paramQQAppInterface = aqwz.b + paramQQAppInterface;
                      bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(paramQQAppInterface));
                      bool1 = bool2;
                    } while (!QLog.isColorLevel());
                    QLog.d("VasQuickUpdateManager", 2, "deleteFiles: font hiboom path = " + paramQQAppInterface + " result = " + bool2);
                    return bool2;
                    if (!paramString.startsWith("font.hiFontQQ.json.")) {
                      break;
                    }
                    paramQQAppInterface = paramString.substring("font.hiFontQQ.json.".length(), paramString.length());
                    paramQQAppInterface = aqwz.c + paramQQAppInterface;
                    bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(paramQQAppInterface));
                    bool1 = bool2;
                  } while (!QLog.isColorLevel());
                  QLog.d("VasQuickUpdateManager", 2, "deleteFiles: font hiboom config path = " + paramQQAppInterface + " result = " + bool2);
                  return bool2;
                  if (!paramString.startsWith("font.hiFontQQ.tags")) {
                    break;
                  }
                  bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(aqwz.d));
                  bool1 = bool2;
                } while (!QLog.isColorLevel());
                QLog.d("VasQuickUpdateManager", 2, "deleteFiles: font hiboom tag result = " + bool2);
                return bool2;
                if (!paramString.startsWith("font.main.android.")) {
                  break;
                }
                paramQQAppInterface = paramString.substring("font.main.android.".length(), paramString.length());
                paramQQAppInterface = ho.a + File.separatorChar + paramQQAppInterface + File.separatorChar + paramQQAppInterface + ".ttf";
                bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(paramQQAppInterface));
                bool1 = bool2;
              } while (!QLog.isColorLevel());
              QLog.d("VasQuickUpdateManager", 2, "deleteFiles: font font path = " + paramQQAppInterface + " result = " + bool2);
              return bool2;
              if (!paramString.startsWith("font.fzfont.android.")) {
                break;
              }
              paramQQAppInterface = paramString.substring("font.fzfont.android.".length(), paramString.length());
              paramQQAppInterface = ho.b + paramQQAppInterface + File.separatorChar + paramQQAppInterface + ".ttf";
              bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(paramQQAppInterface));
              bool1 = bool2;
            } while (!QLog.isColorLevel());
            QLog.d("VasQuickUpdateManager", 2, "deleteFiles: font font fz path = " + paramQQAppInterface + " result = " + bool2);
            return bool2;
            if (!paramString.equals("magicFontConfig.json")) {
              break label1620;
            }
            bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(ho.g));
            bool1 = bool2;
          } while (!QLog.isColorLevel());
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: fontEffect json path = " + ho.g + " result = " + bool2);
          return bool2;
          if (paramLong != 9L) {
            break;
          }
          if (!paramString.startsWith("signature.sticker.")) {
            break label1620;
          }
          paramQQAppInterface = paramString.substring("signature.sticker.".length(), paramString.length());
          bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(ajsf.bW + paramQQAppInterface));
          bool1 = bool2;
        } while (!QLog.isColorLevel());
        QLog.d("VasQuickUpdateManager", 2, "deleteFiles: signature sticker path = " + paramQQAppInterface + " result = " + bool2);
        return bool2;
        if (paramLong != 15L) {
          break label1575;
        }
        if (!"cardWZ.zip".equals(paramString)) {
          break;
        }
        paramQQAppInterface = auwn.a(this.this$0.app.getApp());
        bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(paramQQAppInterface));
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("VasQuickUpdateManager", 2, "deleteFiles: profile card path = " + paramQQAppInterface + " result = " + bool2);
      return bool2;
      int i;
      if (paramString.startsWith("card."))
      {
        paramQQAppInterface = ((bbqs)this.this$0.app.getManager(235)).jdField_a_of_type_Auux;
        i = Integer.parseInt(paramString.substring("card.".length(), paramString.length()));
        return paramQQAppInterface.b(this.this$0.app.getApp(), i);
        if (paramLong != 22L) {
          break label1658;
        }
        paramQQAppInterface = ((bbqs)this.this$0.app.getManager(235)).jdField_a_of_type_Apzf;
        if (paramString.startsWith("colorScreen.android.")) {
          paramQQAppInterface.a(paramString);
        }
      }
      do
      {
        QLog.e("VasQuickUpdateManager", 1, "deleteFiles error: bid = " + paramLong + " scid = " + paramString);
        return false;
        if (paramLong == 1999L)
        {
          paramQQAppInterface = VasQuickUpdateManager.QUICKUPDATE_TEST_DIR + paramString;
          bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(paramQQAppInterface));
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: quickupdate test path = " + paramQQAppInterface + " result = " + bool2);
          return bool2;
        }
        if (paramLong == 25L)
        {
          i = azrl.a(paramString);
          paramQQAppInterface = azrl.a + i;
          bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(paramQQAppInterface));
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: ENTER_EFFECT path = " + paramQQAppInterface + " result = " + bool2);
          return bool2;
        }
        if (paramLong == 8L)
        {
          paramQQAppInterface = paramString.substring("chatbg.".length(), paramString.length());
          paramString = (ChatBackgroundManager)this.this$0.app.getManager(63);
          return VasQuickUpdateEngine.safeDeleteFile(new File(ChatBackgroundManager.g(paramQQAppInterface)));
        }
        if (paramLong == 27L)
        {
          paramQQAppInterface = paramString.substring("groupnickitem.".length(), paramString.length());
          paramQQAppInterface = bboe.a + paramQQAppInterface;
          bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(paramQQAppInterface));
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: COLOR_NICK path = " + paramQQAppInterface + " result = " + bool2);
          return bool2;
        }
      } while (paramLong != 33L);
      paramQQAppInterface = paramString.substring("profileitem.".length());
      bool2 = VasQuickUpdateEngine.safeDeleteFile(new File(auux.a(paramQQAppInterface)));
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("VasQuickUpdateManager", 2, "deleteFiles: Default Card Config id=" + paramQQAppInterface + " ret=" + bool2);
    return bool2;
  }
  
  public long getBID()
  {
    return 0L;
  }
  
  public VasQuickUpdateEngine.TagItemInfo getItemInfo(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    VasQuickUpdateEngine.TagItemInfo localTagItemInfo = new VasQuickUpdateEngine.TagItemInfo();
    Object localObject;
    if ((paramLong == 1000L) || (paramLong == 1001L))
    {
      localTagItemInfo.bPreConfig = false;
      localTagItemInfo.bSaveInDir = false;
      String str = this.this$0.app.getApplication().getFilesDir() + File.separator;
      if (paramString.equals("pendant_market_json.android.v2"))
      {
        paramQQAppInterface = "pendant_market.json";
        localObject = str;
      }
      for (;;)
      {
        localTagItemInfo.strSavePath = ((String)localObject + paramQQAppInterface);
        return localTagItemInfo;
        localObject = str;
        paramQQAppInterface = paramString;
        if (paramString.startsWith("signature.item."))
        {
          localObject = str;
          paramQQAppInterface = paramString;
          if (paramString.endsWith(".json"))
          {
            paramString = paramString.substring("signature.item.".length(), paramString.length() - 5);
            if (QLog.isColorLevel()) {
              QLog.d("VasQuickUpdateManager", 2, "getItemInfo signature id = " + paramString);
            }
            paramQQAppInterface = "config.json";
            localObject = ajsf.bV + File.separator + paramString + File.separator;
          }
        }
      }
    }
    if (paramLong == 1002L)
    {
      paramQQAppInterface = (FlashChatManager)this.this$0.app.getManager(217);
      localTagItemInfo.bPreConfig = false;
      localTagItemInfo.bSaveInDir = false;
      localTagItemInfo.strSavePath = paramQQAppInterface.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "getItemInfo:  result.strSavePath = " + localTagItemInfo.strSavePath);
      }
      return localTagItemInfo;
    }
    if (paramLong == 5L)
    {
      if (paramString.startsWith("font.diycard.android."))
      {
        localTagItemInfo.bPreConfig = false;
        localTagItemInfo.bSaveInDir = true;
        localTagItemInfo.strSavePath = (auwo.a + paramString.substring("font.diycard.android.".length(), paramString.length()));
      }
      for (;;)
      {
        return localTagItemInfo;
        if (paramString.startsWith("font.hifont.android."))
        {
          localTagItemInfo.bPreConfig = false;
          localTagItemInfo.bSaveInDir = true;
          localTagItemInfo.strSavePath = (aqwz.b + paramString.substring("font.hifont.android.".length(), paramString.length()));
        }
        else if (paramString.startsWith("font.hiFontQQ.json."))
        {
          localTagItemInfo.bPreConfig = false;
          localTagItemInfo.bSaveInDir = true;
          localTagItemInfo.strSavePath = (aqwz.c + paramString.substring("font.hiFontQQ.json.".length(), paramString.length()));
        }
        else if (paramString.startsWith("font.hiFontQQ.tags"))
        {
          localTagItemInfo.bPreConfig = false;
          localTagItemInfo.bSaveInDir = true;
          localTagItemInfo.strSavePath = aqwz.d;
        }
        else if (paramString.startsWith("font.main.android."))
        {
          localTagItemInfo.bPreConfig = false;
          localTagItemInfo.bSaveInDir = true;
          localTagItemInfo.strSavePath = (ho.a + File.separator + paramString.substring("font.main.android.".length(), paramString.length()));
        }
        else if (paramString.startsWith("font.fzfont.android."))
        {
          localTagItemInfo.bPreConfig = false;
          localTagItemInfo.bSaveInDir = true;
          localTagItemInfo.strSavePath = (ho.b + paramString.substring("font.fzfont.android.".length(), paramString.length()));
        }
        else if (paramString.equals("magicFontConfig.json"))
        {
          localTagItemInfo.bPreConfig = false;
          localTagItemInfo.bSaveInDir = false;
          localTagItemInfo.strSavePath = ho.g;
        }
      }
    }
    int i;
    if (paramLong == 22L)
    {
      paramQQAppInterface = ((bbqs)this.this$0.app.getManager(235)).jdField_a_of_type_Apzf;
      if (paramString.startsWith("colorScreen.android."))
      {
        i = paramQQAppInterface.a(paramString);
        if (i > 0)
        {
          localTagItemInfo.bPreConfig = false;
          localTagItemInfo.bSaveInDir = false;
          localTagItemInfo.strSavePath = (paramQQAppInterface.a(i).getAbsolutePath() + File.separator + "config.zip");
          return localTagItemInfo;
        }
      }
    }
    else if (paramLong == 23L)
    {
      if (paramString.startsWith("face."))
      {
        paramQQAppInterface = VasFaceManager.a(paramString);
        if (paramQQAppInterface != null)
        {
          localTagItemInfo.bPreConfig = false;
          localTagItemInfo.bSaveInDir = false;
          localTagItemInfo.strSavePath = paramQQAppInterface;
          return localTagItemInfo;
        }
      }
      else if (paramString.equals("avatarInPendant_json"))
      {
        localTagItemInfo.bPreConfig = false;
        localTagItemInfo.bSaveInDir = false;
        localTagItemInfo.strSavePath = (this.this$0.app.getApplication().getFilesDir() + File.separator + "avatarInPendant.json");
        return localTagItemInfo;
      }
    }
    else if (paramLong == 2L)
    {
      paramQQAppInterface = (BubbleManager)this.this$0.app.getManager(44);
      if (paramString.startsWith("bubble.android."))
      {
        i = paramQQAppInterface.a(paramString);
        if (i > 0)
        {
          localTagItemInfo.bPreConfig = false;
          if (paramString.endsWith("static.zip"))
          {
            localTagItemInfo.bSaveInDir = true;
            localTagItemInfo.strSavePath = (paramQQAppInterface.a(i).getAbsolutePath() + File.separator + "static");
          }
          for (;;)
          {
            return localTagItemInfo;
            if (paramString.endsWith("other.zip"))
            {
              localTagItemInfo.bSaveInDir = true;
              localTagItemInfo.strSavePath = paramQQAppInterface.a(i).getAbsolutePath();
            }
            else if (paramString.endsWith("config.json"))
            {
              localTagItemInfo.bSaveInDir = false;
              localTagItemInfo.strSavePath = (paramQQAppInterface.a(i).getAbsolutePath() + File.separator + "config.json");
            }
          }
        }
      }
      else if (paramString.startsWith("bubble.paster."))
      {
        localTagItemInfo.bSaveInDir = false;
        if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("bubble.paster.")))
        {
          paramString = paramString.replace("bubble.paster.", "");
          localTagItemInfo.strSavePath = (paramQQAppInterface.b().getAbsolutePath() + File.separator + paramString);
          if (QLog.isColorLevel()) {
            QLog.i("VasQuickUpdateManager", 2, "download paster fileName: " + localTagItemInfo.strSavePath);
          }
        }
        localTagItemInfo.bPreConfig = false;
        return localTagItemInfo;
      }
    }
    else if (paramLong == 4L)
    {
      if (paramString.startsWith("faceAddon.stickerFont.android."))
      {
        localTagItemInfo.bPreConfig = false;
        localTagItemInfo.bSaveInDir = true;
        localTagItemInfo.strSavePath = bbby.b(paramString.replace("faceAddon.stickerFont.android.", ""));
        return localTagItemInfo;
      }
      if (paramString.startsWith("faceAddon.sticker."))
      {
        localTagItemInfo.bPreConfig = false;
        localTagItemInfo.bSaveInDir = false;
        localTagItemInfo.strSavePath = (ajsf.bP + "sticker_info/" + paramString.replace("faceAddon.sticker.", ""));
        return localTagItemInfo;
      }
      if ((paramString.startsWith("pendant.")) && (paramString.length() > "pendant.".length()))
      {
        paramQQAppInterface = paramString.substring("pendant.".length(), paramString.length());
        i = paramQQAppInterface.indexOf(".");
        if (i > 0)
        {
          paramString = paramQQAppInterface.substring(0, i);
          paramQQAppInterface.substring(i, paramQQAppInterface.length());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(ajsf.bP).append(paramString).append(File.separator);
          localTagItemInfo.bPreConfig = false;
          localTagItemInfo.bSaveInDir = true;
          if (paramQQAppInterface.endsWith(".xydata.js"))
          {
            localTagItemInfo.bSaveInDir = false;
            ((StringBuilder)localObject).append("config.json");
          }
          if (paramQQAppInterface.endsWith(".aio_50.png"))
          {
            localTagItemInfo.bSaveInDir = false;
            ((StringBuilder)localObject).append("aio_50.png");
          }
          localTagItemInfo.strSavePath = ((StringBuilder)localObject).toString();
          return localTagItemInfo;
        }
      }
    }
    else if (paramLong == 20L)
    {
      paramQQAppInterface = (PraiseManager)this.this$0.app.getManager(209);
      if ((paramQQAppInterface != null) && (paramString.startsWith("praise.android.")))
      {
        i = paramQQAppInterface.a(paramString);
        if (i > 0)
        {
          localTagItemInfo.bPreConfig = false;
          localTagItemInfo.bSaveInDir = true;
          localTagItemInfo.strSavePath = paramQQAppInterface.a(i).getAbsolutePath();
          return localTagItemInfo;
        }
      }
    }
    else
    {
      if (paramLong == 1003L)
      {
        localTagItemInfo.bPreConfig = false;
        localTagItemInfo.bSaveInDir = false;
        paramQQAppInterface = this.this$0.app.getApplication().getFilesDir() + File.separator;
        localTagItemInfo.strSavePath = (paramQQAppInterface + paramString);
        return localTagItemInfo;
      }
      if (paramLong == 16L)
      {
        localTagItemInfo.bPreConfig = false;
        if (("iRedPacket_v3.json".equals(paramString)) || ("iRedPacket_v3.char300.json".equals(paramString)))
        {
          localTagItemInfo.bSaveInDir = false;
          localTagItemInfo.strSavePath = (this.this$0.app.getApp().getApplicationContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + paramString);
        }
        if ("iRedPacket_v3.font.zip".equals(paramString))
        {
          localTagItemInfo.bSaveInDir = true;
          localTagItemInfo.strSavePath = ajzf.a(3);
        }
        for (;;)
        {
          return localTagItemInfo;
          if ("iRedPacket_v3.specialChar.zip".equals(paramString))
          {
            localTagItemInfo.bSaveInDir = true;
            localTagItemInfo.strSavePath = ajzf.a(2);
          }
          else if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("luckyMoney.item.")))
          {
            localTagItemInfo.bSaveInDir = true;
            paramQQAppInterface = ajzf.a(paramString);
            if (TextUtils.isEmpty(paramQQAppInterface)) {
              QLog.d("VasQuickUpdateManager", 2, "getItemInfo bid = " + paramLong + " scid = " + paramString + " pid = " + paramQQAppInterface);
            }
            localTagItemInfo.strSavePath = (ajzf.a(1) + paramQQAppInterface);
          }
        }
      }
      if (paramLong == 1004L)
      {
        localTagItemInfo.bPreConfig = false;
        localTagItemInfo.bSaveInDir = false;
        if (paramString.equals("emojiStickerGuideZip_v2")) {
          localTagItemInfo.strSavePath = (EmojiStickerManager.a() + "emojiStickerGuideZip_v2.zip");
        }
        for (;;)
        {
          return localTagItemInfo;
          if (paramString.equals(VasQuickUpdateManager.SCID_FLATBUFFERS))
          {
            localTagItemInfo.strSavePath = (FlatBuffersParser.a() + "libFlatBuffersParser.zip");
          }
          else if (paramString.equals("kcsdk_4_4_7_3"))
          {
            localTagItemInfo.strSavePath = bbwx.a().b(this.this$0.app.getApp());
          }
          else if (paramString.equals("GLDrawableV828"))
          {
            localTagItemInfo.strSavePath = bbsk.a(this.this$0.app.getApp());
          }
          else if (paramString.equals(VasQuickUpdateManager.SCID_COLORFONT_SO))
          {
            localTagItemInfo.strSavePath = (ho.a + File.separator + "libColorFont.zip");
          }
          else if (paramString.equals(VasQuickUpdateManager.SCID_HYFONT_SO))
          {
            localTagItemInfo.strSavePath = (ho.a + File.separator + "libVipFont.zip");
          }
          else if (paramString.startsWith("bqmall.android.h5magic."))
          {
            localTagItemInfo.strSavePath = anxb.b(paramString);
          }
          else if (paramString.equals(VasQuickUpdateManager.SCID_COMIC_PLAYER_SO))
          {
            localTagItemInfo.strSavePath = (bghi.a() + "libQGamePlayer.zip");
          }
          else if (paramString.equals(VasQuickUpdateManager.SCID_APNG_SO))
          {
            localTagItemInfo.strSavePath = (this.this$0.app.getApp().getApplicationContext().getFilesDir() + File.separator + "apng.zip");
          }
          else if (paramString.equals("defaultFont_775"))
          {
            localTagItemInfo.strSavePath = (ho.a + File.separator + "default.zip");
          }
          else if (paramString.equals("enterEffectVipIcons"))
          {
            paramQQAppInterface = azrl.a();
            if (TextUtils.isEmpty(paramQQAppInterface))
            {
              QLog.e("VasQuickUpdateManager", 1, "SCID_ENTER_EFFECT_VIP_ICONS getItemInfo null zipPath");
              return null;
            }
            localTagItemInfo.strSavePath = paramQQAppInterface;
          }
        }
      }
      if (paramLong == 15L)
      {
        if ("cardWZ.zip".equals(paramString))
        {
          localTagItemInfo.bPreConfig = false;
          localTagItemInfo.bSaveInDir = true;
          localTagItemInfo.strSavePath = auwn.a(this.this$0.app.getApp());
          return localTagItemInfo;
        }
        if (paramString.startsWith("card."))
        {
          localTagItemInfo.bPreConfig = false;
          localTagItemInfo.bSaveInDir = false;
          i = Integer.parseInt(paramString.substring("card.".length(), paramString.length()));
          paramQQAppInterface = ((bbqs)this.this$0.app.getManager(235)).jdField_a_of_type_Auux;
          localTagItemInfo.strSavePath = auux.b(this.this$0.app.getApp(), i);
          return localTagItemInfo;
        }
      }
      else
      {
        if (paramLong == 21L)
        {
          localTagItemInfo.bPreConfig = false;
          localTagItemInfo.bSaveInDir = true;
          if (paramString.startsWith("poke.item.effect.")) {
            localTagItemInfo.strSavePath = (adwl.e + paramString.substring("poke.item.effect.".length(), paramString.length()));
          }
          for (;;)
          {
            return localTagItemInfo;
            if (paramString.startsWith("poke.item.res."))
            {
              localTagItemInfo.strSavePath = (adwl.e + paramString.substring("poke.item.res.".length(), paramString.length()));
            }
            else if ("poke.effectList".equals(paramString))
            {
              localTagItemInfo.bSaveInDir = false;
              localTagItemInfo.strSavePath = adwl.f;
            }
          }
        }
        if (paramLong == 9L)
        {
          if (paramString.startsWith("signature.sticker."))
          {
            localTagItemInfo.bPreConfig = false;
            localTagItemInfo.bSaveInDir = false;
            localTagItemInfo.strSavePath = (ajsf.bW + paramString.substring("signature.sticker.".length(), paramString.length()));
            return localTagItemInfo;
          }
        }
        else
        {
          if (paramLong == 1999L)
          {
            localTagItemInfo.bPreConfig = false;
            if (paramString.endsWith("cfg")) {
              localTagItemInfo.bPreConfig = true;
            }
            localTagItemInfo.bSaveInDir = false;
            localTagItemInfo.strSavePath = (VasQuickUpdateManager.QUICKUPDATE_TEST_DIR + paramString);
            return localTagItemInfo;
          }
          if (paramLong == 100L)
          {
            localTagItemInfo.bPreConfig = false;
            if (paramString.equals("vipComic_nav_config.json"))
            {
              localTagItemInfo.bSaveInDir = false;
              localTagItemInfo.strSavePath = bghd.b().getAbsolutePath();
            }
            for (;;)
            {
              return localTagItemInfo;
              if (paramString.equals("vipComic_nav_tabIcon.zip"))
              {
                localTagItemInfo.bSaveInDir = true;
                localTagItemInfo.strSavePath = bghd.c().getAbsolutePath();
              }
            }
          }
          if (paramLong == 25L)
          {
            localTagItemInfo.bPreConfig = false;
            if (paramString.startsWith("groupeffect_item_"))
            {
              localTagItemInfo.bSaveInDir = false;
              i = azrl.a(paramString);
              localTagItemInfo.strSavePath = (azrl.a + i + File.separator + i + ".zip");
              return localTagItemInfo;
            }
          }
          else
          {
            if (paramLong == 8L)
            {
              paramQQAppInterface = (ChatBackgroundManager)this.this$0.app.getManager(63);
              paramString = paramString.substring("chatbg.".length(), paramString.length());
              localTagItemInfo.bSaveInDir = false;
              localTagItemInfo.bPreConfig = false;
              localTagItemInfo.strSavePath = paramQQAppInterface.f(paramString);
              return localTagItemInfo;
            }
            if (paramLong == 27L)
            {
              paramQQAppInterface = paramString.substring("groupnickitem.".length(), paramString.length());
              localTagItemInfo.bSaveInDir = true;
              localTagItemInfo.bPreConfig = false;
              localTagItemInfo.strSavePath = (bboe.a + paramQQAppInterface);
              return localTagItemInfo;
            }
            if (paramLong == 33L)
            {
              paramQQAppInterface = paramString.substring("profileitem.".length());
              localTagItemInfo.bSaveInDir = false;
              localTagItemInfo.bPreConfig = false;
              localTagItemInfo.strSavePath = auux.a(paramQQAppInterface);
              return localTagItemInfo;
            }
          }
        }
      }
    }
    return null;
  }
  
  public boolean isFileExists(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject5 = null;
    Object localObject1 = null;
    Object localObject4 = null;
    paramQQAppInterface = null;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool2 = false;
    if (paramLong == 1000L) {
      bool1 = new File(this.this$0.app.getApplication().getFilesDir(), paramString).exists();
    }
    int i;
    label258:
    label429:
    label602:
    label993:
    label1529:
    do
    {
      do
      {
        do
        {
          return bool1;
          if (paramLong != 5L) {
            break label993;
          }
          if (paramString.startsWith("font.diycard.android."))
          {
            paramString = paramString.substring("font.diycard.android.".length(), paramString.length());
            localObject1 = auwo.a + paramString;
            paramString = new File((String)localObject1);
            if (paramString.exists()) {
              paramQQAppInterface = paramString.list();
            }
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder().append("isFileExists hiboomfont path = ").append((String)localObject1).append(" exist = ").append(paramString.exists()).append(" file count = ");
              if (paramQQAppInterface == null) {
                break label258;
              }
            }
            for (i = paramQQAppInterface.length;; i = 0)
            {
              QLog.d("VasQuickUpdateManager", 2, i);
              bool1 = bool2;
              if (paramString.exists())
              {
                bool1 = bool2;
                if (paramQQAppInterface != null)
                {
                  bool1 = bool2;
                  if (paramQQAppInterface.length > 0) {
                    bool1 = true;
                  }
                }
              }
              return bool1;
            }
          }
          if (paramString.startsWith("font.hifont.android."))
          {
            paramQQAppInterface = paramString.substring("font.hifont.android.".length(), paramString.length());
            localObject1 = aqwz.b + paramQQAppInterface;
            paramString = new File((String)localObject1);
            paramQQAppInterface = localObject2;
            if (paramString.exists()) {
              paramQQAppInterface = paramString.list();
            }
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder().append("isFileExists hiboomfont path = ").append((String)localObject1).append(" exist = ").append(paramString.exists()).append(" file count = ");
              if (paramQQAppInterface == null) {
                break label429;
              }
            }
            for (i = paramQQAppInterface.length;; i = 0)
            {
              QLog.d("VasQuickUpdateManager", 2, i);
              if ((paramString.exists()) && (paramQQAppInterface != null) && (paramQQAppInterface.length > 0)) {
                break;
              }
              return false;
            }
          }
          if (paramString.startsWith("font.hiFontQQ.json."))
          {
            paramQQAppInterface = paramString.substring("font.hiFontQQ.json.".length(), paramString.length());
            localObject1 = aqwz.c + paramQQAppInterface;
            paramString = new File((String)localObject1);
            paramQQAppInterface = localObject3;
            if (paramString.exists()) {
              paramQQAppInterface = paramString.list();
            }
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder().append("isFileExists hiboomconfig path = ").append((String)localObject1).append(" exist = ").append(paramString.exists()).append(" file count = ");
              if (paramQQAppInterface == null) {
                break label602;
              }
            }
            for (i = paramQQAppInterface.length;; i = 0)
            {
              QLog.d("VasQuickUpdateManager", 2, i);
              if ((paramString.exists()) && (paramQQAppInterface != null) && (paramQQAppInterface.length > 0)) {
                break;
              }
              return false;
            }
          }
          if (!paramString.startsWith("font.hiFontQQ.tags")) {
            break;
          }
          paramString = new File(aqwz.d);
          paramQQAppInterface = localObject5;
          if (paramString.exists()) {
            paramQQAppInterface = paramString.list();
          }
        } while ((paramQQAppInterface != null) && (paramQQAppInterface.length > 0));
        return false;
        if (paramString.startsWith("font.main.android."))
        {
          paramQQAppInterface = paramString.substring("font.main.android.".length(), paramString.length());
          paramQQAppInterface = ho.a + File.separatorChar + paramQQAppInterface + File.separatorChar + paramQQAppInterface + ".ttf";
          paramString = new File(paramQQAppInterface);
          if (QLog.isColorLevel()) {
            QLog.d("VasQuickUpdateManager", 2, "isFileExists font path = " + paramQQAppInterface + " result = " + paramString.exists());
          }
          return paramString.exists();
        }
        if (paramString.startsWith("font.fzfont.android."))
        {
          paramQQAppInterface = paramString.substring("font.fzfont.android.".length(), paramString.length());
          paramQQAppInterface = ho.b + paramQQAppInterface + File.separatorChar + paramQQAppInterface + ".ttf";
          paramString = new File(paramQQAppInterface);
          if (QLog.isColorLevel()) {
            QLog.d("VasQuickUpdateManager", 2, "isFileExists font path = " + paramQQAppInterface + " result = " + paramString.exists());
          }
          return paramString.exists();
        }
        if (!paramString.equals("magicFontConfig.json")) {
          break label3055;
        }
        paramQQAppInterface = new File(ho.g);
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateManager", 2, "isFileExists fontEffectJson path = " + ho.g + " result = " + paramQQAppInterface.exists());
        }
        return paramQQAppInterface.exists();
        if (paramLong == 2L)
        {
          paramQQAppInterface = (BubbleManager)this.this$0.app.getManager(44);
          if (paramQQAppInterface == null) {
            break label3055;
          }
          if (paramString.startsWith("bubble.android.")) {
            return paramQQAppInterface.b(paramString);
          }
          if (!paramString.startsWith("bubble.paster.")) {
            break label3055;
          }
          return paramQQAppInterface.a(paramString);
        }
        if (paramLong == 22L)
        {
          paramQQAppInterface = ((bbqs)this.this$0.app.getManager(235)).jdField_a_of_type_Apzf;
          if (!paramString.startsWith("colorScreen.android.")) {
            break label3055;
          }
          return paramQQAppInterface.a(paramString);
        }
        if (paramLong == 23L)
        {
          paramQQAppInterface = ((bbqs)this.this$0.app.getManager(235)).jdField_a_of_type_ComTencentMobileqqVasAvatarVasFaceManager;
          if (paramString.startsWith("face.")) {
            return paramQQAppInterface.a(paramString);
          }
          if (!paramString.equals("avatarInPendant_json")) {
            break label3055;
          }
          return new File(this.this$0.app.getApplication().getFilesDir() + File.separator + "avatarInPendant.json").exists();
        }
        if (paramLong != 4L) {
          break label1625;
        }
        if (paramString.startsWith("faceAddon.stickerFont.android.")) {
          return bbby.a(paramString.replace("faceAddon.stickerFont.android.", ""));
        }
        if (paramString.startsWith("faceAddon.sticker.")) {
          return bbby.b(paramString);
        }
        if ((!paramString.startsWith("pendant.")) || (paramString.length() <= "pendant.".length())) {
          break label3055;
        }
        paramQQAppInterface = paramString.substring("pendant.".length(), paramString.length());
        i = paramQQAppInterface.indexOf(".");
        if (i <= 0) {
          break label3055;
        }
        localObject1 = paramQQAppInterface.substring(0, i);
        paramString = new StringBuilder();
        paramString.append(ajsf.bP).append((String)localObject1).append(File.separator);
        if (paramQQAppInterface.endsWith(".xydata.js")) {
          paramString.append("config.json");
        }
        for (;;)
        {
          localObject1 = new File(paramString.toString());
          if (!((File)localObject1).exists()) {
            break label1577;
          }
          if (!((File)localObject1).isDirectory()) {
            break label1529;
          }
          if (((File)localObject1).listFiles() != null) {
            break;
          }
          return false;
          if (paramQQAppInterface.endsWith(".aio_50.png")) {
            paramString.append("aio_50.png");
          } else if (paramQQAppInterface.endsWith(".other.zip")) {
            paramString.append("aio_file");
          }
        }
        i = ((File)localObject1).listFiles().length;
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateManager", 2, "isFileExists scid = " + paramQQAppInterface + " listFile length = " + i + " filepath = " + paramString.toString());
        }
      } while (i > 0);
      return false;
    } while (!QLog.isColorLevel());
    QLog.d("VasQuickUpdateManager", 2, "isFileExists scid = " + paramQQAppInterface + " exists filepath = " + paramString.toString());
    return true;
    label1577:
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateManager", 2, "isFileExists scid = " + paramQQAppInterface + " not exists filepath = " + paramString.toString());
    }
    return false;
    label1625:
    if (paramLong == 20L) {
      return ((PraiseManager)this.this$0.app.getManager(209)).a(paramString);
    }
    if (paramLong == 1003L) {
      return new File(this.this$0.app.getApplication().getFilesDir(), paramString).exists();
    }
    if (paramLong == 16L) {
      if (("iRedPacket_v3.json".equals(paramString)) || ("iRedPacket_v3.char300.json".equals(paramString))) {
        paramQQAppInterface = this.this$0.app.getApp().getApplicationContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + paramString;
      }
    }
    for (;;)
    {
      label1766:
      if (TextUtils.isEmpty(paramQQAppInterface)) {}
      for (paramQQAppInterface = (QQAppInterface)localObject1;; paramQQAppInterface = new File(paramQQAppInterface))
      {
        if ((paramQQAppInterface != null) && (paramQQAppInterface.exists())) {
          break label1995;
        }
        return false;
        if ("iRedPacket_v3.font.zip".equals(paramString))
        {
          paramQQAppInterface = ajzf.a(null, null, 8, 0, 0);
          break label1766;
        }
        if ("iRedPacket_v3.specialChar.zip".equals(paramString))
        {
          paramQQAppInterface = ajzf.a(null, null, 25, 0, 0);
          break label1766;
        }
        if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("luckyMoney.item."))) {
          break label3057;
        }
        paramQQAppInterface = ajzf.a(paramString);
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          break label3057;
        }
        paramQQAppInterface = ajzf.a(paramQQAppInterface, null, 24, 0, 0);
        if (TextUtils.isEmpty(paramQQAppInterface))
        {
          paramQQAppInterface = localObject4;
          label1889:
          if ((paramQQAppInterface == null) || (!paramQQAppInterface.exists()) || (!paramQQAppInterface.isDirectory()) || (paramQQAppInterface.list() == null) || (paramQQAppInterface.list().length <= 1)) {
            break label1979;
          }
        }
        label1979:
        for (bool2 = bool3;; bool2 = false)
        {
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("VasQuickUpdateManager", 2, "isFileExists SCID_REDPACKET_PACKETS_ZIP result = " + bool2);
          return bool2;
          paramQQAppInterface = new File(paramQQAppInterface);
          break label1889;
        }
      }
      label1995:
      break;
      if (paramLong == 15L)
      {
        if ("cardWZ.zip".equals(paramString)) {
          return auwn.a(this.this$0.app.getApp(), paramString);
        }
        if (paramString.startsWith("card."))
        {
          i = Integer.parseInt(paramString.substring("card.".length(), paramString.length()));
          paramQQAppInterface = ((bbqs)this.this$0.app.getManager(235)).jdField_a_of_type_Auux;
          return auux.a(this.this$0.app.getApp(), i);
        }
      }
      else if (paramLong == 21L)
      {
        if (paramString.startsWith("poke.item.effect."))
        {
          paramQQAppInterface = paramString.substring("poke.item.effect.".length(), paramString.length());
          try
          {
            i = Integer.valueOf(paramQQAppInterface).intValue();
            if (i == -1)
            {
              bool1 = bool4;
              return bool1;
            }
          }
          catch (Exception paramQQAppInterface)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("VasQuickUpdateManager", 2, "id error");
              }
              i = -1;
              continue;
              bool1 = adwl.a("effect.gif", i);
            }
          }
        }
        if (paramString.startsWith("poke.item.res."))
        {
          paramQQAppInterface = paramString.substring("poke.item.res.".length(), paramString.length());
          try
          {
            i = Integer.valueOf(paramQQAppInterface).intValue();
            if (i == -1)
            {
              bool1 = bool5;
              return bool1;
            }
          }
          catch (Exception paramQQAppInterface)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("VasQuickUpdateManager", 2, "id error");
              }
              i = -1;
              continue;
              bool1 = adwl.a("bubble", i);
            }
          }
        }
        if ("poke.effectList".equals(paramString)) {
          return new File(adwl.f).exists();
        }
      }
      else
      {
        if (paramLong == 1004L)
        {
          if (paramString.startsWith(VasQuickUpdateManager.SCID_COLORFONT_SO)) {
            return new File(bbkv.a() + "libFounderColorFont_818.so").exists();
          }
          if (paramString.startsWith(VasQuickUpdateManager.SCID_FLATBUFFERS)) {
            return new File(FlatBuffersParser.a() + "libFlatBuffersParser.zip").exists();
          }
          if (paramString.equals("kcsdk_4_4_7_3")) {
            return new File(bbwx.a().a(this.this$0.app.getApp())).exists();
          }
          if (paramString.equals("GLDrawableV828")) {
            return bbsk.a(this.this$0.app.getApp());
          }
          if (paramString.equals("emojiStickerGuideZip_v2")) {
            return new File(EmojiStickerManager.a() + "emojiStickerGuideZip_v2.zip").exists();
          }
          if (paramString.equals(VasQuickUpdateManager.SCID_HYFONT_SO)) {
            return new File(bbkv.a() + "libvipfont808.so").exists();
          }
          if (paramString.startsWith("bqmall.android.h5magic.")) {
            return new File(anxb.b(paramString)).exists();
          }
          if (paramString.equals(VasQuickUpdateManager.SCID_COMIC_PLAYER_SO)) {
            return new File(bghi.a() + "libqgplayer_765.so").exists();
          }
          if (paramString.equals(VasQuickUpdateManager.SCID_APNG_SO)) {
            return bbqj.a().a();
          }
          if (paramString.equals("defaultFont_775"))
          {
            paramQQAppInterface = new File(bbkv.a() + ia.a);
            if ((paramQQAppInterface.exists()) && (paramQQAppInterface.isDirectory())) {
              break;
            }
            return false;
          }
          if (!paramString.equals("enterEffectVipIcons")) {
            break label3055;
          }
          paramQQAppInterface = azrl.a();
          if (TextUtils.isEmpty(paramQQAppInterface))
          {
            QLog.e("VasQuickUpdateManager", 1, "SCID_ENTER_EFFECT_VIP_ICONS: get null zipPath");
            return false;
          }
          return new File(paramQQAppInterface).exists();
        }
        if (paramLong == 9L)
        {
          if (paramString.startsWith("signature.sticker."))
          {
            paramQQAppInterface = paramString.substring("signature.sticker.".length(), paramString.length());
            return new File(ajsf.bW + paramQQAppInterface).exists();
          }
        }
        else
        {
          if (paramLong == 1999L) {
            return new File(VasQuickUpdateManager.QUICKUPDATE_TEST_DIR + paramString).exists();
          }
          if (paramLong == 100L)
          {
            if (paramString.equals("vipComic_nav_config.json")) {
              return bghd.a();
            }
            if (paramString.equals("vipComic_nav_tabIcon.zip")) {
              return bghd.b();
            }
          }
          else if (paramLong == 25L)
          {
            i = azrl.a(paramString);
            if (i > 0) {
              return balg.a(new File(azrl.a + i));
            }
          }
          else
          {
            if (paramLong == 8L)
            {
              paramQQAppInterface = paramString.substring("chatbg.".length(), paramString.length());
              return ((ChatBackgroundManager)this.this$0.app.getManager(63)).a(paramQQAppInterface);
            }
            if (paramLong == 27L) {
              return new File(bboe.a(paramString.substring("groupnickitem.".length(), paramString.length()))).exists();
            }
            if (paramLong == 33L) {
              return new File(auux.a(paramString.substring("profileitem.".length()))).exists();
            }
          }
        }
      }
      label3055:
      return false;
      label3057:
      paramQQAppInterface = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager.2
 * JD-Core Version:    0.7.0.1
 */