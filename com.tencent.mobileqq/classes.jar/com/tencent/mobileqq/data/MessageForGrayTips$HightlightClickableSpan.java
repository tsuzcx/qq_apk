package com.tencent.mobileqq.data;

import aabc;
import abwz;
import acvv;
import afhv;
import afhw;
import afiw;
import afst;
import ahdt;
import ahey;
import amsw;
import amtj;
import ancw;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import anoh;
import aprw;
import aprx;
import apse;
import apyy;
import apyz;
import aqrc;
import aqrd;
import aqre;
import aqrf;
import aqvo;
import arib;
import armh;
import aubv;
import aucf;
import aucg;
import auyo;
import auzn;
import avjp;
import avsc;
import awfm;
import awfy;
import aynd;
import azwg;
import bbkv;
import bcef;
import bcek;
import bctz;
import bcvc;
import bcvs;
import bdct;
import bddg;
import bedt;
import beeg;
import beue;
import bevq;
import beyy;
import bfic;
import bflj;
import bftc;
import bftk;
import bfur;
import bfvp;
import bfwg;
import bfyz;
import bgge;
import bhvw;
import bing;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.fragment.TempMsgSettingFragment;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.teamwork.DocsGrayTipsInfo;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ugf;
import wmu;
import xwa;

public class MessageForGrayTips$HightlightClickableSpan
  extends ClickableSpan
{
  int color = -1;
  private Context context;
  public String frienduin;
  private MessageForGrayTips.HighlightItem item;
  private WeakReference<QQAppInterface> mApp;
  MessageRecord message;
  
  public MessageForGrayTips$HightlightClickableSpan(QQAppInterface paramQQAppInterface, int paramInt, Context paramContext, MessageForGrayTips.HighlightItem paramHighlightItem, MessageRecord paramMessageRecord)
  {
    this.mApp = new WeakReference(paramQQAppInterface);
    this.context = paramContext;
    this.color = paramInt;
    this.item = paramHighlightItem;
    this.message = paramMessageRecord;
    if (paramMessageRecord != null) {
      this.frienduin = paramMessageRecord.frienduin;
    }
  }
  
  private void deleteFriend(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {}
    do
    {
      do
      {
        return;
      } while (!((amsw)paramQQAppInterface.getManager(51)).b(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("MessageForGrayTips", 2, "deleteFriend " + paramString);
      }
      ((FriendListHandler)paramQQAppInterface.getBusinessHandler(1)).delFriend(paramString, (byte)2);
      MqqHandler localMqqHandler = paramQQAppInterface.getHandler(ChatActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendMessage(localMqqHandler.obtainMessage(16711681, paramString));
      }
      paramQQAppInterface = paramQQAppInterface.getHandler(ChatSettingActivity.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.sendMessage(paramQQAppInterface.obtainMessage(16711681, paramString));
  }
  
  private void doAddFriendSafetyReport(QQAppInterface paramQQAppInterface)
  {
    if ((this.context instanceof BaseActivity))
    {
      Object localObject = (BaseActivity)this.context;
      Bundle localBundle = aabc.a(this.message.frienduin, 0);
      aabc.a((BaseActivity)localObject, this.message.frienduin, null, "1", null, this.message.selfuin, 25030, null, localBundle);
      localObject = this.message.getExtInfoFromExtStr("uint64_busi_type");
      bcef.b(paramQQAppInterface, "CliOper", "", "", "0X800A561", "0X800A561", 1, 0, this.message.getExtInfoFromExtStr("uint64_busi_id"), (String)localObject, "web", "");
    }
  }
  
  private void onClickActionWeb(QQAppInterface paramQQAppInterface)
  {
    if ((this.message != null) && (this.message.msgtype == -2049)) {
      bhvw.a().a(((QQAppInterface)this.mApp.get()).getCurrentAccountUin(), "", "", "2000", "2012", "0", false);
    }
    aucf localaucf;
    Object localObject1;
    if ((this.message != null) && ((this.message instanceof MessageForUniteGrayTip)))
    {
      localaucf = ((MessageForUniteGrayTip)this.message).tipParam;
      if (localaucf != null)
      {
        if (localaucf.b != 2359297) {
          break label203;
        }
        bcef.b(null, "P_CliOper", "cmshow", "", "Apollo", "Invitetip_clk", 0, 0, "", "", "", "");
        if (awfy.b(localaucf.b))
        {
          if (!TextUtils.isEmpty(this.item.mMsgActionData)) {
            break label1330;
          }
          localObject1 = this.item.mMsg_A_ActionData;
          label151:
          awfm.a(paramQQAppInterface, (MessageForUniteGrayTip)this.message, localaucf.b, (String)localObject1);
        }
        arib.a(paramQQAppInterface, localaucf);
      }
    }
    if (TextUtils.isEmpty(this.item.mMsgActionData)) {}
    for (paramQQAppInterface = this.item.mMsg_A_ActionData;; paramQQAppInterface = this.item.mMsgActionData)
    {
      clickWebMsg(paramQQAppInterface);
      return;
      label203:
      if (localaucf.b == 2359298)
      {
        bcef.b(null, "P_CliOper", "cmshow", "", "Apollo", "clk_intro", 0, 0, "", "", "", "");
        break;
      }
      if (localaucf.b == 2490369)
      {
        bcef.b(null, "dc00898", "", "", "0X8007F12", "0X8007F12", 0, 0, "", "", "", "");
        break;
      }
      if (localaucf.b == 2621441)
      {
        localObject1 = ((MessageForUniteGrayTip)this.message).appGuideTipsOpKey;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        bcef.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
        break;
      }
      if (localaucf.b == 3145729)
      {
        bcef.b(null, "dc00898", "", "", "0X800812B", "0X800812B", 0, 0, "", "", "", "");
        break;
      }
      if (localaucf.b == 131078)
      {
        VasWebviewUtil.reportCommercialDrainage(((QQAppInterface)this.mApp.get()).getCurrentUin(), "style", "0X8009133", "", 1, 0, 0, "", "", "0");
        break;
      }
      int i;
      if (localaucf.b == 2097154)
      {
        if (TextUtils.isEmpty(this.item.mMsgActionData)) {}
        for (localObject1 = this.item.mMsg_A_ActionData;; localObject1 = this.item.mMsgActionData)
        {
          for (;;)
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label586;
            }
            Object localObject2 = HttpUtil.decodeURL((String)localObject1);
            if (!((Map)localObject2).containsKey("type")) {
              break;
            }
            localObject2 = (String)((Map)localObject2).get("type");
            try
            {
              i = Integer.parseInt((String)localObject2);
              bcef.b((QQAppInterface)this.mApp.get(), "dc00898", "", "", "qq_vip", "0X8009CA6", i, 0, "", "", "", "");
            }
            catch (NumberFormatException localNumberFormatException) {}
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("reactive", 2, "parse url type error:" + (String)localObject1);
          break;
        }
        label586:
        break;
      }
      String str1;
      if (localaucf.b == 655384)
      {
        str1 = this.message.getExtInfoFromExtStr("love_c2c_aio_businessSubtype");
        localObject1 = str1;
        if (TextUtils.isEmpty(str1)) {
          localObject1 = "1";
        }
        LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", (String)localObject1, "", "2"));
        break;
      }
      if (localaucf.b == 2097153)
      {
        localObject1 = this.message.getExtInfoFromExtStr("friendIconType");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        VasWebviewUtil.reportCommercialDrainage(paramQQAppInterface.getCurrentAccountUin(), "friendspark", "aio_click", "", 0, 0, 0, "", (String)localObject1, "", "", "", "", "", 0, 0, 0, 0);
        if (((String)localObject1).equals("3"))
        {
          LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "8", "2"));
          break;
        }
        if (!((String)localObject1).equals("6")) {
          break;
        }
        LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "7", "2"));
        break;
      }
      if (localaucf.b == 655397)
      {
        String str2 = this.message.getExtInfoFromExtStr("uint64_busi_type");
        localObject1 = this.message.getExtInfoFromExtStr("uint64_busi_id");
        str1 = this.message.getExtInfoFromExtStr("uint64_templ_id");
        i = 3;
        if (this.message.istroop == 0)
        {
          i = 1;
          label842:
          bcef.b(paramQQAppInterface, "CliOper", "", "", "0X800A561", "0X800A561", i, 0, "" + (String)localObject1, "" + str2, "web", "");
          if ("1008".equals(localObject1)) {
            bcef.b(null, "dc00898", "", "", "0X800A639", "0X800A639", i - 1, 0, "", "", "", "");
          }
          if (("1062".equals(localObject1)) && ("12".equals(str2)))
          {
            str2 = this.message.getExtInfoFromExtStr("bytes_content");
            if (!TextUtils.isEmpty(str2))
            {
              if (!str2.contains("动作")) {
                break label1213;
              }
              bcef.b(null, "dc00898", "", "", "0X800B43E", "0X800B43E", i, 0, "", "", "", "");
            }
          }
        }
        for (;;)
        {
          if (afhw.a(this.message))
          {
            int j = i;
            if (i != 1)
            {
              j = i;
              if (i != 2) {
                j = 10;
              }
            }
            bcef.b(null, "dc00898", "", "", "0X800B525", "0X800B525", j, 0, "", "", "", "");
          }
          if (Long.valueOf((String)localObject1).equals(Long.valueOf(1021L))) {
            bcef.b(null, "dc00898", "", "", "0X800AD83", "0X800AD83", 0, 0, "", "", "", "");
          }
          bddg.a((String)localObject1, localaucf.a);
          if ((!Long.valueOf((String)localObject1).equals(Long.valueOf(1038L))) || (TextUtils.isEmpty(str1))) {
            break;
          }
          if (!Long.valueOf(str1).equals(Long.valueOf(1111L))) {
            break label1253;
          }
          bcef.b(null, "dc00898", "", "", "0X800B1A3", "0X800B1A3", 0, 0, "", "", "", "");
          break;
          if (this.message.istroop != 1) {
            break label842;
          }
          i = 2;
          break label842;
          label1213:
          if (str2.contains("效果")) {
            bcef.b(null, "dc00898", "", "", "0X800B440", "0X800B440", i, 0, "", "", "", "");
          }
        }
        label1253:
        if (!Long.valueOf(str1).equals(Long.valueOf(1112L))) {
          break;
        }
        bcef.b(null, "dc00898", "", "", "0X800B1A5", "0X800B1A5", 0, 0, "", "", "", "");
        break;
      }
      if (localaucf.b != 131090) {
        break;
      }
      beeg.a((QQAppInterface)this.mApp.get(), this.frienduin);
      break;
      label1330:
      localObject1 = this.item.mMsgActionData;
      break label151;
    }
  }
  
  private void showDeleteDialog(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = amtj.a(2131705720);
    if (this.item.mMsg_A_ActionData != null) {
      paramQQAppInterface = this.item.mMsg_A_ActionData;
    }
    bfur.a(this.context, null, paramQQAppInterface, null, 2131690620, 2131691644, new aqre(this), new aqrf(this)).show();
  }
  
  /* Error */
  public boolean clickAppMsg(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +40 -> 45
    //   8: ldc_w 445
    //   11: iconst_2
    //   12: new 77	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 447
    //   22: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 449
    //   32: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_0
    //   46: aload_1
    //   47: aload_2
    //   48: invokevirtual 453	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:parsePackageNameAndData	(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;
    //   51: astore_2
    //   52: aload_0
    //   53: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   56: invokevirtual 459	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   59: astore 4
    //   61: aload 4
    //   63: aload_2
    //   64: iconst_0
    //   65: aaload
    //   66: iconst_1
    //   67: invokevirtual 465	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   70: ifnull +250 -> 320
    //   73: aload 4
    //   75: aload_2
    //   76: iconst_0
    //   77: aaload
    //   78: invokevirtual 469	android/content/pm/PackageManager:getLaunchIntentForPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   81: astore 4
    //   83: aload_2
    //   84: iconst_1
    //   85: aaload
    //   86: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   89: ifne +15 -> 104
    //   92: aload 4
    //   94: aload_2
    //   95: iconst_1
    //   96: aaload
    //   97: invokestatic 475	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   100: invokevirtual 481	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   103: pop
    //   104: aload 4
    //   106: ifnull +133 -> 239
    //   109: aload_0
    //   110: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   113: getfield 347	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   116: sipush 1008
    //   119: if_icmpeq +120 -> 239
    //   122: aload 4
    //   124: ldc_w 483
    //   127: ldc_w 485
    //   130: invokevirtual 489	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   133: pop
    //   134: aload_0
    //   135: getfield 31	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   138: invokevirtual 175	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   141: checkcast 57	com/tencent/mobileqq/app/QQAppInterface
    //   144: bipush 23
    //   146: invokevirtual 96	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   149: checkcast 491	anbg
    //   152: astore 5
    //   154: aload 4
    //   156: ldc_w 493
    //   159: ldc_w 495
    //   162: invokevirtual 489	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   165: pop
    //   166: aload 4
    //   168: ldc_w 497
    //   171: ldc 149
    //   173: invokevirtual 489	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   176: pop
    //   177: aload 4
    //   179: ldc_w 499
    //   182: ldc 133
    //   184: invokevirtual 489	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   187: pop
    //   188: aload 4
    //   190: ldc_w 501
    //   193: ldc_w 503
    //   196: invokevirtual 489	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   199: pop
    //   200: aload 4
    //   202: ldc_w 505
    //   205: aload_0
    //   206: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   209: invokevirtual 511	java/lang/Object:getClass	()Ljava/lang/Class;
    //   212: invokevirtual 516	java/lang/Class:getName	()Ljava/lang/String;
    //   215: invokevirtual 489	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   218: pop
    //   219: aload 5
    //   221: aload_2
    //   222: iconst_0
    //   223: aaload
    //   224: invokevirtual 519	java/lang/String:trim	()Ljava/lang/String;
    //   227: aload_0
    //   228: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   231: aload 4
    //   233: invokevirtual 522	anbg:b	(Ljava/lang/String;Landroid/content/Context;Landroid/content/Intent;)V
    //   236: goto +82 -> 318
    //   239: aload 4
    //   241: ifnull -107 -> 134
    //   244: aload 4
    //   246: ldc_w 483
    //   249: aload_0
    //   250: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   253: getfield 41	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   256: invokestatic 526	ugf:b	(Ljava/lang/String;)Ljava/lang/String;
    //   259: invokevirtual 489	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   262: pop
    //   263: goto -129 -> 134
    //   266: astore_2
    //   267: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +13 -> 283
    //   273: ldc_w 528
    //   276: iconst_2
    //   277: ldc_w 530
    //   280: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: aload_0
    //   284: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   287: aload 4
    //   289: invokevirtual 534	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   292: goto +26 -> 318
    //   295: astore_2
    //   296: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq +13 -> 312
    //   302: ldc 75
    //   304: iconst_2
    //   305: aload_2
    //   306: invokevirtual 537	android/content/pm/PackageManager$NameNotFoundException:getMessage	()Ljava/lang/String;
    //   309: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: aload_0
    //   313: aload_1
    //   314: invokevirtual 238	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:clickWebMsg	(Ljava/lang/String;)Z
    //   317: ireturn
    //   318: iconst_1
    //   319: istore_3
    //   320: iload_3
    //   321: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	HightlightClickableSpan
    //   0	322	1	paramString1	String
    //   0	322	2	paramString2	String
    //   1	320	3	bool	boolean
    //   59	229	4	localObject	Object
    //   152	68	5	localanbg	anbg
    // Exception table:
    //   from	to	target	type
    //   109	134	266	java/lang/Exception
    //   134	236	266	java/lang/Exception
    //   244	263	266	java/lang/Exception
    //   61	104	295	android/content/pm/PackageManager$NameNotFoundException
    //   109	134	295	android/content/pm/PackageManager$NameNotFoundException
    //   134	236	295	android/content/pm/PackageManager$NameNotFoundException
    //   244	263	295	android/content/pm/PackageManager$NameNotFoundException
    //   267	283	295	android/content/pm/PackageManager$NameNotFoundException
    //   283	292	295	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public boolean clickPluginMsg(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HightlightClickableSpan", 2, "HightlightClickableSpan clickPluginMsg  actionData = " + paramString1 + ", actionDataA = " + paramString2);
    }
    String str;
    if (!TextUtils.isEmpty(paramString2))
    {
      str = paramString2;
      if (!TextUtils.equals("null", paramString2)) {}
    }
    else
    {
      str = paramString1;
    }
    try
    {
      paramString1 = bfwg.a((QQAppInterface)this.mApp.get(), this.context, str);
      if (paramString1 != null)
      {
        paramString1.a();
        paramString1.a();
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HightlightClickableSpan", 2, paramString1.getMessage(), paramString1);
        }
      }
    }
    return true;
  }
  
  public boolean clickWebMsg(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        do
        {
          return false;
          if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))) {
            break label133;
          }
          if (!paramString.equals("cmd://openGiftPanel")) {
            break;
          }
        } while (!(this.context instanceof FragmentActivity));
        paramString = ((FragmentActivity)this.context).getChatFragment();
      } while ((paramString == null) || (paramString.a() == null));
      paramString.a().showGiftPanel(true);
      return true;
    } while ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("mqzone://arouse/lovermainpage")) || (this.mApp == null));
    avjp.a((QQAppInterface)this.mApp.get(), this.context, 2080, "");
    return false;
    label133:
    if (paramString.equals("http://imgcache.qq.com/lightalk/lightalk_pay/qq/index.html?_wv=1025&type=")) {
      bcef.b(null, "CliOper", "", "", "0X80070EB", "0X80070EB", 0, 0, "", "", "", "");
    }
    aqvo.a(paramString);
    if ((this.message != null) && ((this.message instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)this.message).tipParam.b == 131078))
    {
      bedt.a("Grp_AIO", "grey_clk", new String[] { this.message.frienduin });
      bfyz.r(this.context, ((BaseActivity)this.context).app.getCurrentAccountUin(), this.message.frienduin);
    }
    if ((this.message != null) && (this.message.istroop == 1) && (avsc.a((BaseActivity)this.context, paramString, this.message)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MessageForGrayTips", 2, "mini app jump handled");
      }
      return true;
    }
    Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("key_isReadModeEnabled", true);
    String str;
    if (this.message == null) {
      str = "biz_src_jc_aio";
    }
    for (;;)
    {
      localIntent.putExtra("big_brother_source_key", str);
      ugf.a(this.message, localIntent, paramString);
      this.context.startActivity(localIntent);
      paramString = (QQAppInterface)this.mApp.get();
      if ((paramString != null) && ((this.message instanceof MessageForGrayTips)) && (String.valueOf(11).equals(this.message.getExtInfoFromExtStr("gray_tips_serviceType")))) {
        bcef.b(paramString, "dc00898", "", "", "0X8009328", "0X8009328", 0, 0, "", "", "", "");
      }
      return true;
      if (this.message.istroop == 1008) {
        str = ugf.b(this.message.frienduin);
      } else {
        str = "biz_src_jc_aio";
      }
    }
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public MessageRecord getMessage()
  {
    return this.message;
  }
  
  public void onClick(View paramView)
  {
    if ((this.item == null) || (this.mApp == null) || (this.mApp.get() == null)) {}
    Object localObject2;
    Object localObject1;
    int i;
    label516:
    label582:
    label2284:
    Object localObject4;
    label896:
    label2467:
    label2520:
    boolean bool1;
    long l;
    int j;
    Object localObject5;
    Object localObject6;
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
                                                      if (QLog.isColorLevel()) {
                                                        QLog.d("MessageForGrayTips", 2, "revoke msg onClick==>item actionType:" + this.item.actionType);
                                                      }
                                                      localObject2 = (QQAppInterface)this.mApp.get();
                                                    } while (localObject2 == null);
                                                    switch (this.item.actionType)
                                                    {
                                                    case 8: 
                                                    case 9: 
                                                    case 22: 
                                                    case 23: 
                                                    case 35: 
                                                    case 37: 
                                                    case 49: 
                                                    default: 
                                                      return;
                                                    case 1: 
                                                      onClickActionWeb((QQAppInterface)localObject2);
                                                      return;
                                                    case 3: 
                                                      if ((this.message != null) && ((this.message instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)this.message).tipParam.b == 655397))
                                                      {
                                                        paramView = this.message.getExtInfoFromExtStr("uint64_busi_type");
                                                        localObject1 = this.message.getExtInfoFromExtStr("uint64_busi_id");
                                                        i = 3;
                                                        if (this.message.istroop != 0) {
                                                          break label516;
                                                        }
                                                        i = 1;
                                                      }
                                                      for (;;)
                                                      {
                                                        bcef.b((QQAppInterface)localObject2, "CliOper", "", "", "0X800A561", "0X800A561", i, 0, "" + (String)localObject1, "" + paramView, "mqq", "");
                                                        clickPluginMsg(this.item.mMsgActionData, this.item.mMsg_A_ActionData);
                                                        return;
                                                        if (this.message.istroop == 1) {
                                                          i = 2;
                                                        }
                                                      }
                                                    case 2: 
                                                      clickAppMsg(this.item.mMsgActionData, this.item.mMsg_A_ActionData);
                                                      return;
                                                    case 4: 
                                                      if (((TroopManager)((QQAppInterface)this.mApp.get()).getManager(52)).b(this.frienduin) != null) {
                                                        break;
                                                      }
                                                      i = 2;
                                                      paramView = TroopInfoActivity.a(this.frienduin, 4);
                                                      paramView.putInt("t_s_f", 1001);
                                                      TroopUtils.openTroopInfoActivity(this.context, paramView, i);
                                                      return;
                                                    case 17: 
                                                      localObject1 = new Intent(this.context, PermisionPrivacyActivity.class);
                                                      if (this.message != null) {}
                                                      for (paramView = this.message.getExtInfoFromExtStr("scrollflag");; paramView = null)
                                                      {
                                                        if (!TextUtils.isEmpty(paramView))
                                                        {
                                                          ((Intent)localObject1).putExtra("scrollflag", paramView);
                                                          bcef.b((QQAppInterface)this.mApp.get(), "P_CliOper", "invite_friend", "", "auto_pass", "clk_set_entry", 0, 0, this.frienduin, "", "", "");
                                                        }
                                                        this.context.startActivity((Intent)localObject1);
                                                        return;
                                                      }
                                                    case 5: 
                                                      paramView = (QQAppInterface)this.mApp.get();
                                                    }
                                                  } while ((this.context == null) || (paramView == null));
                                                  aynd.a(paramView, this.context, this.frienduin, "" + this.item.uin, 4, -1);
                                                  return;
                                                  paramView = (QQAppInterface)this.mApp.get();
                                                } while ((this.context == null) || (paramView == null));
                                                aynd.a(paramView, this.context, this.frienduin, "" + this.item.uin, 4, -1);
                                                paramView = paramView.getCurrentAccountUin();
                                                localObject1 = (TroopManager)((QQAppInterface)this.mApp.get()).getManager(52);
                                                if (localObject1 == null) {
                                                  break;
                                                }
                                                localObject1 = ((TroopManager)localObject1).b(this.frienduin);
                                                if (localObject1 == null) {
                                                  break;
                                                }
                                                if (((TroopInfo)localObject1).isTroopOwner(paramView)) {}
                                                for (paramView = "1";; paramView = "2")
                                                {
                                                  bftc.a("Grp_manage", "recall_msg", "clk_mberName", 0, 0, new String[] { this.frienduin, paramView });
                                                  return;
                                                }
                                              } while (this.context == null);
                                              paramView = new Intent(this.context, EditInfoActivity.class);
                                              localObject1 = String.valueOf(this.item.uin);
                                              localObject2 = ContactUtils.getTroopMemberNick((QQAppInterface)this.mApp.get(), this.frienduin, (String)localObject1);
                                              paramView.putExtra("edit_type", 0);
                                              paramView.putExtra("troopUin", this.frienduin);
                                              paramView.putExtra("uin", (String)localObject1);
                                              paramView.putExtra("title", this.context.getResources().getString(2131697040));
                                              paramView.putExtra("isTroopNick", true);
                                              paramView.putExtra("default_text", (String)localObject2);
                                              paramView.putExtra("max_num", 60);
                                              paramView.putExtra("default_hint", amtj.a(2131705728));
                                              paramView.putExtra("auto_remark", true);
                                              this.context.startActivity(paramView);
                                              return;
                                              paramView = new TroopInfoData();
                                              paramView.troopUin = this.frienduin;
                                              localObject1 = (TroopManager)((QQAppInterface)this.mApp.get()).getManager(52);
                                            } while (localObject1 == null);
                                            localObject1 = ((TroopManager)localObject1).b(this.frienduin);
                                            if (localObject1 != null)
                                            {
                                              paramView.updateForTroopChatSetting((TroopInfo)localObject1, this.context.getResources(), ((QQAppInterface)this.mApp.get()).getCurrentAccountUin());
                                              paramView.isMember = true;
                                            }
                                            new bflj((SplashActivity)this.context, paramView).a(paramView);
                                            return;
                                            if (QLog.isColorLevel()) {
                                              QLog.d("reactive", 2, "onclick graytip");
                                            }
                                            bcef.b(null, "dc00898", "", "", "0X8007603", "0X8007603", 0, 0, "", "", "", "");
                                            paramView = new Intent(this.context, QQBrowserActivity.class);
                                            localObject1 = apyz.a().a(this.frienduin);
                                            if (QLog.isColorLevel()) {
                                              QLog.d("MessageForGrayTips", 2, String.format("goToC2CWebPage, url: %s", new Object[] { localObject1 }));
                                            }
                                            paramView.putExtra("url", (String)localObject1);
                                            paramView.putExtra("finish_animation_out_to_right", true);
                                            paramView.putExtra("is_wrap_content", true);
                                            paramView.putExtra("hide_left_button", false);
                                            if (this.context != null) {
                                              this.context.startActivity(paramView);
                                            }
                                            if ((this.message != null) && ((this.message instanceof MessageForUniteGrayTip)))
                                            {
                                              paramView = ((MessageForUniteGrayTip)this.message).tipParam;
                                              if ((paramView != null) && (2097154 == paramView.b)) {
                                                bcef.b((QQAppInterface)this.mApp.get(), "dc00898", "", "", "qq_vip", "0X8009CA7", 0, 0, "", "", "", "");
                                              }
                                              if (paramView != null) {
                                                awfm.b((QQAppInterface)localObject2, (MessageForUniteGrayTip)this.message, paramView.b);
                                              }
                                            }
                                          } while ((this.message == null) || (!(this.message instanceof MessageForUniteGrayTip)));
                                          paramView = ((MessageForUniteGrayTip)this.message).tipParam;
                                        } while ((paramView == null) || (2097155 != paramView.b));
                                        bcef.b((QQAppInterface)this.mApp.get(), "dc00898", "", "", "0X800A1BD", "0X800A1BD", 0, 0, "", "", "", "");
                                        return;
                                        if (QLog.isColorLevel()) {
                                          QLog.d("specialCare", 2, "onclick graytip");
                                        }
                                        paramView = new Intent(this.context, QQSpecialCareSettingActivity.class);
                                        paramView.putExtra("key_friend_uin", this.frienduin);
                                        paramView.putExtra("key_start_from", 1);
                                        if ((this.context instanceof BaseActivity)) {
                                          this.context.startActivity(paramView);
                                        }
                                        VasWebviewUtil.reportCommercialDrainage(((QQAppInterface)this.mApp.get()).getCurrentAccountUin(), "Care", "CareTipClick", "", 1, 0, 0, null, this.item.mMsgActionData, null);
                                        return;
                                        paramView = new Intent(this.context, SelectMemberActivity.class);
                                        paramView.putExtra("param_groupcode", this.frienduin);
                                        paramView.putExtra("param_type", 1);
                                        paramView.putExtra("param_subtype", 1);
                                        paramView.putExtra("param_done_button_wording", this.context.getString(2131696766));
                                        paramView.putExtra("param_only_friends", true);
                                        paramView.putExtra("param_is_troop_admin", true);
                                        paramView.putExtra("param_title", this.context.getString(2131695546));
                                        paramView.putExtra("param_max", 100);
                                        this.context.startActivity(paramView);
                                        return;
                                        paramView = ((TroopManager)((QQAppInterface)this.mApp.get()).getManager(52)).c(this.frienduin);
                                      } while (paramView == null);
                                      localObject1 = new Intent(this.context, EditInfoActivity.class);
                                      ((Intent)localObject1).putExtra("edit_type", 2);
                                      ((Intent)localObject1).putExtra("title", amtj.a(2131705740));
                                      if (paramView.hasSetNewTroopName) {
                                        ((Intent)localObject1).putExtra("default_text", paramView.troopname);
                                      }
                                      ((Intent)localObject1).putExtra("max_num", 96);
                                      ((Intent)localObject1).putExtra("canPostNull", false);
                                      ((Activity)this.context).startActivityForResult((Intent)localObject1, 13010);
                                      return;
                                      beyy.a(this.context, this.frienduin);
                                      bftc.a("Grp_edu", "Grp_AIO", "graybar_showmore", 0, 0, new String[] { this.frienduin });
                                      return;
                                    } while ((this.message == null) || (!(this.message instanceof MessageForUniteGrayTip)));
                                    paramView = (MessageForUniteGrayTip)this.message;
                                  } while (this.mApp == null);
                                  localObject1 = (bing)((QQAppInterface)this.mApp.get()).getBusinessHandler(85);
                                } while (localObject1 == null);
                                ((bing)localObject1).a(paramView.extUin, paramView.masterUin, paramView.taskId, paramView.uniseq, paramView.istroop);
                                return;
                                paramView = new Intent(this.context, EditActivity.class);
                                paramView.putExtra("title", 2131693102).putExtra("current", this.item.remark).putExtra("action", 103).putExtra("limit", 96).putExtra("canPostNull", true).putExtra("multiLine", false);
                                if ((this.context instanceof BaseActivity)) {
                                  ((BaseActivity)this.context).startActivityForResult(paramView, 13008);
                                }
                                for (;;)
                                {
                                  bcef.b((QQAppInterface)this.mApp.get(), "dc00898", "", "", "0X800797A", "0X800797A", 0, 0, "", "", "", "");
                                  if (!"from_batch_add_frd_for_troop".equals(this.item.mMsgActionData)) {
                                    break;
                                  }
                                  bcef.b((QQAppInterface)this.mApp.get(), "dc00899", "Grp_addFrd", "", "Frd_AIO", "setRefTips_clk", 0, 0, "", "", "", "");
                                  return;
                                  this.context.startActivity(paramView);
                                }
                                paramView = new Intent(this.context, MoveToGroupActivity.class);
                                i = this.item.groupId;
                                if ((i != -1) && ((i != 0) || (!"from_batch_add_frd_for_troop".equals(this.item.mMsgActionData)))) {
                                  break label6959;
                                }
                                localObject1 = ((amsw)((QQAppInterface)this.mApp.get()).getManager(51)).e(this.frienduin);
                                if (localObject1 != null)
                                {
                                  i = ((Friends)localObject1).groupid;
                                  paramView.putExtra("friendUin", this.frienduin).putExtra("mgid", (byte)i);
                                  if (!(this.context instanceof BaseActivity)) {
                                    break label2467;
                                  }
                                  ((BaseActivity)this.context).startActivityForResult(paramView, 13009);
                                }
                                for (;;)
                                {
                                  bcef.b((QQAppInterface)this.mApp.get(), "dc00898", "", "", "0X8007979", "0X8007979", 0, 0, "", "", "", "");
                                  if (!"from_batch_add_frd_for_troop".equals(this.item.mMsgActionData)) {
                                    break;
                                  }
                                  if (QLog.isDevelopLevel()) {
                                    QLog.i("MessageForGrayTips", 4, String.format(Locale.getDefault(), "ACTION_FRIEND_GROUP_SETTING gid: %s, groupId: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.item.groupId) }));
                                  }
                                  bcef.b((QQAppInterface)this.mApp.get(), "dc00899", "Grp_addFrd", "", "Frd_AIO", "setGrpTips_clk", 0, 0, "", "", "", "");
                                  return;
                                  i = 0;
                                  break label2284;
                                  this.context.startActivity(paramView);
                                }
                                if ((this.message == null) || (this.message.msg == null)) {
                                  break;
                                }
                                paramView = this.message.msg.substring(this.item.start, this.item.end);
                                localObject1 = this.item.mMsgActionData;
                                localObject2 = this.item.mMsg_A_ActionData;
                              } while ((localObject1 == null) || (localObject2 == null) || (!(this.context instanceof FragmentActivity)));
                              localObject4 = ((FragmentActivity)this.context).getChatFragment();
                            } while ((localObject4 == null) || (((ChatFragment)localObject4).a() == null));
                            localObject4 = ((ChatFragment)localObject4).a();
                            ((BaseChatPie)localObject4).input.setText("");
                            localObject1 = bevq.a((QQAppInterface)this.mApp.get(), this.context, this.frienduin, (String)localObject1, (String)localObject2, false, ((BaseChatPie)localObject4).input, true);
                            ((BaseChatPie)localObject4).input.setText((CharSequence)localObject1);
                            ((BaseChatPie)localObject4).input.append(paramView);
                            ((BaseChatPie)localObject4).input.setSelection(((BaseChatPie)localObject4).input.getText().length());
                            return;
                            for (;;)
                            {
                              try
                              {
                                localObject2 = new JSONObject(this.item.mMsgActionData);
                                paramView = ((JSONObject)localObject2).optString("uin");
                                localObject1 = ((JSONObject)localObject2).optString("name");
                                localObject2 = ((JSONObject)localObject2).optString("text");
                                if ((paramView == null) || (localObject1 == null) || (!(this.context instanceof FragmentActivity))) {
                                  break;
                                }
                                localObject4 = ((FragmentActivity)this.context).getChatFragment();
                                if ((localObject4 == null) || (((ChatFragment)localObject4).a() == null)) {
                                  break;
                                }
                                localObject4 = ((ChatFragment)localObject4).a();
                                if (!TextUtils.isEmpty((CharSequence)localObject2))
                                {
                                  bool1 = true;
                                  paramView = bevq.a((QQAppInterface)this.mApp.get(), this.context, this.frienduin, paramView, (String)localObject1, false, ((BaseChatPie)localObject4).input, true, bool1);
                                  ((BaseChatPie)localObject4).input.setText(paramView);
                                  ((BaseChatPie)localObject4).input.append((CharSequence)localObject2);
                                  ((BaseChatPie)localObject4).input.setSelection(((BaseChatPie)localObject4).input.getText().length());
                                  return;
                                }
                              }
                              catch (JSONException paramView)
                              {
                                paramView.printStackTrace();
                                return;
                              }
                              bool1 = false;
                            }
                            wmu.a(this.context, this.item.mMsgActionData, "HightLight_Feed_Id", 1005);
                            xwa.a("story_grp", "aio_grey", 0, 0, new String[] { "", "", "", "" });
                            return;
                            paramView = this.item.mMsgActionData;
                          } while (TextUtils.isEmpty(paramView));
                          for (;;)
                          {
                            try
                            {
                              l = Long.parseLong(paramView);
                              if (!(this.context instanceof FragmentActivity)) {
                                break;
                              }
                              paramView = ((FragmentActivity)this.context).getChatFragment().a();
                              if (!paramView.supportRefreshHeadMessage()) {
                                break;
                              }
                              paramView.refreshHeadMessage(10, l, 0, null);
                              EmojiStickerManager.a().b = 0;
                              if (this.message == null) {
                                break;
                              }
                              paramView = "1";
                              if (this.message.istroop == 1)
                              {
                                paramView = "2";
                                VasWebviewUtil.reportCommercialDrainage("", "Stick", "ClickTip", paramView, 1, 0, 0, null, "", "");
                                return;
                              }
                            }
                            catch (Exception paramView)
                            {
                              paramView = paramView;
                              if (!QLog.isColorLevel()) {
                                break;
                              }
                              QLog.e("MessageForGrayTips", 2, "", paramView);
                              return;
                            }
                            finally {}
                            if (this.message.istroop == 3000) {
                              paramView = "3";
                            }
                          }
                        } while ((this.message == null) || (!(this.message instanceof MessageForUniteGrayTip)));
                        paramView = ((MessageForUniteGrayTip)this.message).tipParam;
                        i = bfic.a(bfic.a(paramView.d, 0));
                        paramView = bfic.a(paramView.d, 1);
                        azwg.a(this.context, (QQAppInterface)this.mApp.get(), this.item.mMsgActionData, this.item.mMsg_A_ActionData, i, paramView);
                        return;
                        localObject4 = this.frienduin;
                        i = this.message.istroop;
                        j = this.message.getConfessTopicId();
                        localObject5 = new ConfessInfo();
                        ((ConfessInfo)localObject5).parseFromJsonStr(this.message.getExtInfoFromExtStr("ext_key_confess_info"));
                      } while ((!(this.context instanceof FragmentActivity)) || (((FragmentActivity)this.context).isFinishing()) || (abwz.a(i) != 1032));
                      localObject6 = ((FragmentActivity)this.context).getChatFragment().a();
                      localObject1 = null;
                      paramView = (View)localObject1;
                      if (localObject6 != null)
                      {
                        paramView = (View)localObject1;
                        if ((localObject6 instanceof ahey)) {
                          paramView = (ahey)localObject6;
                        }
                      }
                    } while (paramView == null);
                    paramView = bfur.a(this.context, 0, aprw.f, aprw.g, 2131690620, 2131694201, new aqrc(this, (QQAppInterface)localObject2, (String)localObject4, i, j, (ConfessInfo)localObject5, paramView), new aqrd(this));
                  } while (((FragmentActivity)this.context).isFinishing());
                  paramView.show();
                  return;
                } while (!(this.context instanceof FragmentActivity));
                paramView = ((FragmentActivity)this.context).getChatFragment();
              } while ((paramView == null) || (paramView.a() == null));
              paramView = paramView.a();
            } while (!(paramView instanceof ahdt));
            ((ahdt)paramView).a(this.item.mMsgActionData);
            return;
            if (!BaseChatItemLayout.a) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("MessageForGrayTips", 2, "revoke msg multi msg select forward,return click");
          return;
        } while (!(this.context instanceof FragmentActivity));
        paramView = this.item.mMsgActionData;
        localObject2 = this.item.mMsg_A_ActionData;
        if (QLog.isColorLevel())
        {
          l = 0L;
          if (!TextUtils.isEmpty(paramView)) {
            l = paramView.length();
          }
          QLog.d("MessageForGrayTips", 2, new Object[] { "revoke msg click handle msg length =", Long.valueOf(l) });
        }
        localObject1 = ((FragmentActivity)this.context).getChatFragment();
      } while ((localObject1 == null) || (((ChatFragment)localObject1).a() == null));
      aucg.a(this.message);
      localObject1 = ((ChatFragment)localObject1).a();
      if ((((BaseChatPie)localObject1).input != null) && (((BaseChatPie)localObject1).input.getEditableText() != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MessageForGrayTips", 2, "revoke msg clickspan chatpie input is null");
    return;
    ((BaseChatPie)localObject1).input.getEditableText().clear();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    for (;;)
    {
      try
      {
        localObject2 = new JSONArray((String)localObject2);
        if ((localObject2 != null) && (((JSONArray)localObject2).length() != 0)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MessageForGrayTips", 2, "revoke msg clickspan handle at info is null");
        }
        ((BaseChatPie)localObject1).input.setText(paramView);
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MessageForGrayTips", 2, "revoke msg clickspan json exception,input only text String", localJSONException);
        ((BaseChatPie)localObject1).input.setText(paramView);
        continue;
        j = 0;
      }
      j = ((BaseChatPie)localObject1).input.getText().length();
      i = j;
      if (j < 0) {
        i = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MessageForGrayTips", 2, "revoke msg click handle input length =" + i);
      }
      ((BaseChatPie)localObject1).mDraftText = "";
      ((BaseChatPie)localObject1).input.setSelection(i);
      ((BaseChatPie)localObject1).showInputPanel();
      return;
      i = 0;
      if (i < ((JSONArray)localObject2).length())
      {
        localObject4 = ((JSONArray)localObject2).getJSONObject(i);
        localObject5 = ((JSONObject)localObject4).optString(bbkv.k);
        int n = ((JSONObject)localObject4).optInt(bbkv.l);
        localObject4 = new JSONArray((String)localObject5);
        if ((localObject4 != null) && (((JSONArray)localObject4).length() == 0))
        {
          ((BaseChatPie)localObject1).input.setText(paramView);
        }
        else
        {
          label3835:
          if (j < ((JSONArray)localObject4).length())
          {
            localObject5 = ((JSONArray)localObject4).getJSONObject(j);
            int i1 = ((JSONObject)localObject5).optInt("startPos");
            int k = ((JSONObject)localObject5).optInt("textLen");
            ((JSONObject)localObject5).optInt("flag");
            localObject5 = ((JSONObject)localObject5).optString("uin");
            localObject6 = paramView.substring(i1 + 1, k + i1);
            int m = ((BaseChatPie)localObject1).input.getSelectionEnd();
            k = m;
            if (m < 0) {
              k = 0;
            }
            Object localObject7 = paramView.substring(k, i1);
            ((BaseChatPie)localObject1).input.getEditableText().insert(k, (CharSequence)localObject7);
            localObject7 = (QQAppInterface)this.mApp.get();
            Context localContext = this.context;
            String str = this.frienduin;
            XEditTextEx localXEditTextEx = ((BaseChatPie)localObject1).input;
            if (n != 1) {
              break label6980;
            }
            bool1 = true;
            localObject5 = bevq.a((QQAppInterface)localObject7, localContext, str, (String)localObject5, (String)localObject6, false, localXEditTextEx, bool1);
            if ((localObject5 == null) || (((SpannableString)localObject5).length() == 0)) {
              break;
            }
            m = ((BaseChatPie)localObject1).input.getSelectionEnd();
            k = m;
            if (m < 0) {
              k = 0;
            }
            ((BaseChatPie)localObject1).input.getEditableText().insert(k, (CharSequence)localObject5);
            if (j != ((JSONArray)localObject4).length() - 1) {
              break;
            }
            m = ((BaseChatPie)localObject1).input.getSelectionEnd();
            k = m;
            if (m < 0) {
              k = 0;
            }
            if (k > paramView.length() - 1) {
              break;
            }
            localObject5 = paramView.substring(k, paramView.length());
            ((BaseChatPie)localObject1).input.getEditableText().insert(k, (CharSequence)localObject5);
            break;
          }
          label3996:
          i += 1;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("MessageForGrayTips", 2, "revoke msg click handle at info is empty");
          }
          ((BaseChatPie)localObject1).input.setText(paramView);
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          if (!(this.message instanceof MessageForUniteGrayTip)) {
            break label6948;
          }
          paramView = (MessageForUniteGrayTip)this.message;
          if (paramView.istroop != 0) {
            continue;
          }
          if (!paramView.senderuin.equals(localJSONException.getCurrentAccountUin())) {
            continue;
          }
          i = 1;
          bcef.b((QQAppInterface)this.mApp.get(), "dc00898", "", "", "0X800A613", "0X800A613", 0, 0, i + "", "", "", "");
        }
        catch (RuntimeException paramView)
        {
          boolean bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("MessageForGrayTips", 1, "0X800A613", paramView);
          continue;
        }
        acvv.a(this.context, localJSONException, (ChatMessage)this.message);
        return;
        i = 2;
        continue;
        if (paramView.istroop == 1)
        {
          bool1 = TroopUtils.isTroopOwner(localJSONException, this.message.frienduin, localJSONException.getCurrentUin());
          bool2 = TroopUtils.isTroopAdmin(localJSONException, this.message.frienduin, localJSONException.getCurrentUin());
          localObject1 = paramView.tipParam.c;
          localObject4 = amtj.a(2131705732) + localJSONException.getApp().getString(2131697173);
          if (bool1)
          {
            if (((String)localObject1).startsWith((String)localObject4))
            {
              i = 3;
              break label6986;
            }
            if (!paramView.senderuin.equals(localJSONException.getCurrentAccountUin())) {
              break label6989;
            }
            i = 4;
            break label6986;
          }
          if (bool2)
          {
            if (((String)localObject1).startsWith((String)localObject4))
            {
              i = 5;
              break label6986;
            }
            if (!paramView.senderuin.equals(localJSONException.getCurrentAccountUin())) {
              break label6995;
            }
            i = 6;
            break label6986;
          }
          if (!paramView.senderuin.equals(localJSONException.getCurrentAccountUin())) {
            break label7001;
          }
          i = 7;
          break label6986;
        }
        if (paramView.istroop == 3000)
        {
          if (!paramView.senderuin.equals(localJSONException.getCurrentAccountUin())) {
            break label7007;
          }
          i = 9;
        }
        else
        {
          bool1 = paramView.senderuin.equals(localJSONException.getCurrentAccountUin());
          if (bool1)
          {
            i = 11;
          }
          else
          {
            i = 12;
            continue;
            if ((!(this.context instanceof ChatActivity)) && (!(this.context instanceof SplashActivity))) {
              break;
            }
            paramView = (FragmentActivity)this.context;
            if ((paramView.getChatFragment() != null) && (paramView.getChatFragment().a() != null) && ((this.message instanceof ChatMessage)))
            {
              paramView.getChatFragment().a().startDelAnimAndDelMsg((ChatMessage)this.message);
              ((bedt)localJSONException.getManager(231)).a(this.item.mMsgActionData);
              if (QLog.isColorLevel()) {
                QLog.d("TroopEnterEffect", 2, "click nolongerPrompt id = " + this.item.mMsgActionData);
              }
            }
            if ((this.message == null) || (!(this.message instanceof MessageForUniteGrayTip))) {
              break;
            }
            paramView = ((MessageForUniteGrayTip)this.message).tipParam;
            if (paramView == null) {
              break;
            }
            switch (paramView.b)
            {
            default: 
              return;
            }
            VasWebviewUtil.reportCommercialDrainage(localJSONException.getCurrentUin(), "style", "0X8009133", "", 1, 0, 0, "", "", "3");
            return;
            if (this.context != null) {
              bgge.a(this.item.mMsgActionData, this.context);
            }
            if ((this.mApp.get() == null) || (this.message == null) || (!(this.message instanceof MessageForUniteGrayTip))) {
              break;
            }
            paramView = ((MessageForUniteGrayTip)this.message).tipParam;
            if (paramView == null) {
              break;
            }
            switch (paramView.b)
            {
            default: 
              return;
            }
            VasWebviewUtil.reportCommercialDrainage(((QQAppInterface)this.mApp.get()).getCurrentUin(), "style", "0X8009133", "", 1, 0, 0, "", "", "1");
            return;
            if ((this.mApp.get() == null) || (this.message == null) || (!(this.message instanceof MessageForUniteGrayTip))) {
              break;
            }
            avjp.a((QQAppInterface)this.mApp.get(), this.context, 2080, "6");
            return;
            if (bcvs.a()) {
              break;
            }
            try
            {
              paramView = String.valueOf(this.item.uin);
              localObject1 = this.item.mMsg_A_ActionData;
              localObject3 = this.item.mMsgActionData.split("@#@");
              localObject4 = localObject3[0];
              l = Long.parseLong(localObject3[1]);
              i = this.message.istroop;
              localObject1 = bcvs.a((String)localObject4, paramView, (String)localObject1);
              QLog.i("MessageForGrayTips" + bctz.i, 1, "click to modify tencent docs auth. frienduin = " + paramView + ", uinType = " + i + ", msgSeq = " + l + ", docsGrayTipsInfo = " + localObject1);
              if (localObject1 == null) {
                break;
              }
              if (((DocsGrayTipsInfo)localObject1).s.equals(bctz.k))
              {
                paramView = ((DocsGrayTipsInfo)localObject1).t;
                if (TextUtils.isEmpty(paramView)) {
                  break;
                }
                bcvs.a(this.context, paramView);
                bcef.b(null, "dc00898", "", "", "0X8009C79", "0X8009C79", 0, 0, "", "", "", "");
                return;
              }
            }
            catch (Exception paramView)
            {
              QLog.e("MessageForGrayTips" + bctz.i, 1, " docs gray tips action exception =" + paramView.toString());
              return;
            }
          }
        }
      }
      paramView = (bcvc)((QQAppInterface)this.mApp.get()).getBusinessHandler(122);
      if (i == 1)
      {
        paramView.b((DocsGrayTipsInfo)localObject1, l);
        return;
      }
      paramView.a((DocsGrayTipsInfo)localObject1, l);
      return;
      Object localObject3 = (QQAppInterface)this.mApp.get();
      if ((localObject3 == null) || (!aprw.a((AppInterface)localObject3))) {
        break;
      }
      if (this.message.isSelfConfessor()) {
        paramView = ((QQAppInterface)localObject3).getAccount();
      }
      for (localObject1 = this.message.frienduin;; localObject1 = ((QQAppInterface)localObject3).getAccount())
      {
        aprw.b((QQAppInterface)localObject3, apse.a(this.message.frienduin, this.message.istroop, this.message.getConfessTopicId()), false);
        localObject4 = (aprx)((QQAppInterface)localObject3).getBusinessHandler(125);
        if (localObject4 != null) {
          ((aprx)localObject4).notifyUI(9, true, new Object[] { this.message.frienduin, Integer.valueOf(this.message.getConfessTopicId()), Integer.valueOf(this.message.istroop) });
        }
        aprw.a((AppInterface)localObject3, this.context, paramView, (String)localObject1, this.message.getConfessTopicId(), this.message.isSelfConfessor());
        bcef.b((QQAppInterface)localObject3, "dc00898", "", "", "0X8009574", "0X8009574", 0, 0, this.message.getConfessTopicId() + "", "", paramView, (String)localObject1);
        return;
        paramView = this.message.frienduin;
      }
      i = this.message.istroop;
      if ((i != 1044) && (i != 1045)) {
        break;
      }
      auyo.a(this.context, this.frienduin, this.item.mMsgActionData, this.item.mMsg_A_ActionData);
      return;
      if (this.context == null) {
        break;
      }
      PublicFragmentActivity.a(this.context, TempMsgSettingFragment.class);
      j = 0;
      try
      {
        i = Integer.parseInt(this.item.mMsgActionData);
        bcef.b(null, "dc00898", "", "", "0X800997A", "0X800997A", i, i, "", "", "", "");
        return;
      }
      catch (NumberFormatException paramView)
      {
        for (;;)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("MessageForGrayTips", 2, "NumberFormatException: " + this.item.mMsgActionData);
            i = j;
          }
        }
      }
      paramView = TroopInfoActivity.a(this.item.mMsgActionData, 2);
      paramView.putInt("t_s_f", 1000);
      TroopUtils.openTroopInfoActivity(this.context, paramView, 2);
      bcef.b(null, "dc00898", "", "", "0X800997B", "0X800997B", 0, 0, "", "", "", "");
      return;
      if (anoh.d) {
        this.context.startActivity(anoh.a);
      }
      for (;;)
      {
        try
        {
          i = Integer.parseInt(this.item.mMsgActionData);
          bcef.b(null, "dc00898", "", "", "0X8009AD0", "0X8009AD0", i, i, "", "", "", "");
          return;
        }
        catch (NumberFormatException paramView) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MessageForGrayTips", 2, "NumberFormatException: " + this.item.mMsgActionData);
        return;
        if (this.mApp != null) {
          ThreadManager.executeOnSubThread(new MessageForGrayTips.HightlightClickableSpan.3(this));
        } else if (QLog.isColorLevel()) {
          QLog.d("MessageForGrayTips", 2, "ACTION_FROM_MESSAGE_GOTO_PUSH_NOTIFICATION_SWITCH_SETTING= mApp==null");
        }
      }
      bdct.a((QQAppInterface)this.mApp.get()).a((BaseActivity)this.context, 2, 1, this.message.frienduin, 0L, 10, new Bundle());
      return;
      paramView = new Intent(this.context, AssistantSettingActivity.class);
      this.context.startActivity(paramView);
      return;
      paramView = this.item.mMsg_A_ActionData;
      localObject1 = this.item.mMsgActionData;
      if ((!TextUtils.isEmpty(paramView)) && (paramView.contains("docs.qq.com/form"))) {
        bcvs.a(this.context, paramView, (String)localObject1);
      }
      for (;;)
      {
        bcef.b(null, "dc00898", "", this.frienduin, "0X8009FD1", "0X8009FD1", 0, 0, "", "", "", "");
        return;
        if (bcvs.a(paramView)) {
          MiniAppLauncher.startMiniApp(this.context, paramView, 0, null);
        }
      }
      if ((this.context instanceof FragmentActivity))
      {
        paramView = ((FragmentActivity)this.context).getChatFragment();
        if ((paramView != null) && (paramView.a() != null))
        {
          paramView = paramView.a();
          if ((paramView instanceof afiw)) {
            ((afiw)paramView).a();
          }
        }
      }
      bcef.b((QQAppInterface)this.mApp.get(), "dc00898", "", "", "0X800A013", "0X800A013", 0, 0, "", "", "", "");
      return;
      paramView = new ProfileActivity.AllInOne(this.item.mMsgActionData, 1);
      ProfileActivity.b(this.context, paramView);
      return;
      showDeleteDialog((QQAppInterface)this.mApp.get());
      return;
      if (this.message == null) {
        break;
      }
      if (this.message.istroop == 1)
      {
        auzn.a((QQAppInterface)localObject3, this.context, 1, this.frienduin, 0);
        return;
      }
      if (this.message.istroop != 0) {
        break;
      }
      auzn.a((QQAppInterface)this.mApp.get(), this.context, 2, this.frienduin, 0);
      return;
      if (this.message == null) {
        break;
      }
      auzn.a(this.context, this.message.istroop, this.frienduin);
      return;
      if (!(this.context instanceof FragmentActivity)) {
        break;
      }
      paramView = ((FragmentActivity)this.context).getChatFragment();
      if ((paramView == null) || (paramView.a() == null) || (!(paramView.a() instanceof TroopChatPie))) {
        break;
      }
      paramView = (TroopChatPie)paramView.a();
      localObject1 = paramView.getCurFriendUin();
      if ((TextUtils.isEmpty(this.frienduin)) || (!this.frienduin.equals(localObject1)) || (!(this.message instanceof ChatMessage))) {
        break;
      }
      ((afst)paramView.getHelper(41)).b(1);
      ((TroopManager)((QQAppInterface)localObject3).getManager(52)).a().a((QQAppInterface)localObject3, this.context, paramView.input, this.frienduin, 0, (ChatMessage)this.message);
      agsn.c = 3;
      agsn.a = this.message.senderuin;
      new bcek((QQAppInterface)localObject3).a("dc00899").b("Grp_AIO").c("newman_join").d("clk_bar").a(new String[] { localObject1, "", "" + TroopUtils.convSfToReportParam((QQAppInterface)localObject3, (String)localObject1) }).a();
      return;
      paramView = ((TroopManager)((QQAppInterface)this.mApp.get()).getManager(52)).c(this.frienduin);
      localObject1 = new ArrayList(Arrays.asList(this.item.mMsgActionData.split(",")));
      LpReportInfo_pf00064.allReport(40, 3, 2);
      QZoneHelper.forwardToTroopUploadPhoto((Activity)this.context, ((QQAppInterface)localObject3).getCurrentUin(), 1, 0, Long.parseLong(this.frienduin), paramView.troopname, "$RecentAlbumId", bftk.d, (ArrayList)localObject1, -1, 0, 3);
      return;
      i = QzoneConfig.getInstance().getConfig("aio_qzone_troop_gray_tips", "troop_gray_tips_cool_down", 24);
      paramView = String.format(amtj.a(2131719185), new Object[] { Integer.valueOf(i) });
      QQToast.a(BaseApplication.getContext(), 0, paramView, 0).a();
      LocalMultiProcConfig.putLong4Uin("aio_qzone_troop_gray_tips", System.currentTimeMillis() / 1000L + i * 60 * 60, this.item.uin);
      acvv.a(this.context, (QQAppInterface)localObject3, (ChatMessage)this.message);
      LpReportInfo_pf00064.allReport(40, 3, 3);
      return;
      TroopUtils.checkAndOpenMemberProfileForRecommendTipsClick((QQAppInterface)this.mApp.get(), this.context, this.frienduin, this.item.mMsg_A_ActionData, this.item.mMsgActionData);
      return;
      TroopUtils.openTroopRecommendMemberList((QQAppInterface)this.mApp.get(), this.context, this.message, this.frienduin, this.item.mMsgActionData);
      return;
      TroopUtils.expandFoldMsg((QQAppInterface)this.mApp.get(), this.context, this.message, this.frienduin, this.item.mMsgActionData, this.item.mMsg_A_ActionData);
      return;
      doAddFriendSafetyReport((QQAppInterface)localObject3);
      return;
      aubv.a(this.context, "1", this.message.istroop);
      return;
      armh.a(this.context);
      return;
      beeg.a((QQAppInterface)this.mApp.get(), this.context, this.frienduin, this.item.mMsgActionData);
      return;
      ((afhv)((QQAppInterface)localObject3).getManager(388)).a(this);
      TroopUtils.foldSameMsg((QQAppInterface)this.mApp.get(), this.context, this.message, this.frienduin, this.item.mMsgActionData, this.item.mMsg_A_ActionData);
      return;
      beue.a((QQAppInterface)this.mApp.get(), this.context, this.frienduin, this.item.mMsgActionData);
      return;
      beue.a((QQAppInterface)this.mApp.get(), this.frienduin, this.item.mMsgActionData);
      return;
      label6948:
      i = -1;
      continue;
      paramView = "";
      break label2520;
      label6959:
      break label2284;
      paramView = "";
      break label896;
      i = 1;
      break label582;
      j += 1;
      break label3835;
      label6980:
      bool1 = false;
      break label3996;
      for (;;)
      {
        label6986:
        break;
        label6989:
        i = 8;
        continue;
        label6995:
        i = 8;
        continue;
        label7001:
        i = 8;
      }
      label7007:
      i = 10;
    }
  }
  
  protected final String[] parsePackageNameAndData(String paramString1, String paramString2)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    if (TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.isEmpty(paramString1)) {
        break label52;
      }
    }
    label52:
    for (int i = -1;; i = paramString1.indexOf("://"))
    {
      if (i != -1) {
        break label63;
      }
      arrayOfString[0] = paramString1;
      return arrayOfString;
      paramString1 = paramString2;
      break;
    }
    label63:
    arrayOfString[0] = paramString1.substring(0, i);
    arrayOfString[1] = paramString1.substring(i + 3);
    return arrayOfString;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    if (this.color == -1) {
      paramTextPaint.setColor(paramTextPaint.linkColor);
    }
    for (;;)
    {
      paramTextPaint.setUnderlineText(false);
      return;
      paramTextPaint.setColor(this.color);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan
 * JD-Core Version:    0.7.0.1
 */