package com.tencent.mobileqq.data;

import aber;
import adak;
import aean;
import agwm;
import aihh;
import aiim;
import aijm;
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
import anyw;
import anzj;
import aojl;
import aovh;
import aqyl;
import aqym;
import aqyt;
import arfi;
import arfj;
import arxg;
import arxh;
import arxi;
import arxj;
import asbr;
import ataa;
import avot;
import avpd;
import avpe;
import awlm;
import awml;
import awwi;
import axev;
import axsf;
import axsr;
import azyo;
import bbbt;
import bcrn;
import bdll;
import bdlq;
import beai;
import bebl;
import becb;
import bekk;
import bfui;
import bfuv;
import bgme;
import bgpk;
import bguq;
import bgyq;
import bhbx;
import bhju;
import bhkc;
import bhlg;
import bhlq;
import bhmr;
import bhni;
import bhpc;
import bhsi;
import bhzu;
import bjqh;
import bkib;
import bmtd;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
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
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.fragment.TempMsgSettingFragment;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.teamwork.DocsGrayTipsInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import nnr;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tzq;
import xlj;
import yup;

public class MessageForGrayTips$HightlightClickableSpan
  extends ClickableSpan
{
  int color = -1;
  private Context context;
  public String frienduin;
  private MessageForGrayTips.HightlightItem item;
  private WeakReference<QQAppInterface> mApp;
  MessageRecord message;
  
  public MessageForGrayTips$HightlightClickableSpan(QQAppInterface paramQQAppInterface, int paramInt, Context paramContext, MessageForGrayTips.HightlightItem paramHightlightItem, MessageRecord paramMessageRecord)
  {
    this.mApp = new WeakReference(paramQQAppInterface);
    this.context = paramContext;
    this.color = paramInt;
    this.item = paramHightlightItem;
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
      } while (!((anyw)paramQQAppInterface.getManager(51)).b(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("MessageForGrayTips", 2, "deleteFriend " + paramString);
      }
      ((FriendListHandler)paramQQAppInterface.a(1)).c(paramString, (byte)2);
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
      Bundle localBundle = aber.a(this.message.frienduin, 0);
      aber.a((BaseActivity)localObject, this.message.frienduin, null, "1", null, this.message.selfuin, 25030, null, localBundle);
      localObject = this.message.getExtInfoFromExtStr("uint64_busi_type");
      bdll.b(paramQQAppInterface, "CliOper", "", "", "0X800A561", "0X800A561", 1, 0, this.message.getExtInfoFromExtStr("uint64_busi_id"), (String)localObject, "web", "");
    }
  }
  
  private void showDeleteDialog(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = anzj.a(2131705490);
    if (this.item.mMsg_A_ActionData != null) {
      paramQQAppInterface = this.item.mMsg_A_ActionData;
    }
    bhlq.a(this.context, null, paramQQAppInterface, null, 2131690580, 2131691600, new arxi(this), new arxj(this)).show();
  }
  
  /* Error */
  public boolean clickAppMsg(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +37 -> 42
    //   8: ldc 199
    //   10: iconst_2
    //   11: new 77	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   18: ldc 201
    //   20: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 203
    //   29: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_0
    //   43: aload_1
    //   44: aload_2
    //   45: invokevirtual 207	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:parsePackageNameAndData	(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;
    //   48: astore_2
    //   49: aload_0
    //   50: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   53: invokevirtual 213	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   56: astore 4
    //   58: aload 4
    //   60: aload_2
    //   61: iconst_0
    //   62: aaload
    //   63: iconst_1
    //   64: invokevirtual 219	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   67: ifnull +247 -> 314
    //   70: aload 4
    //   72: aload_2
    //   73: iconst_0
    //   74: aaload
    //   75: invokevirtual 223	android/content/pm/PackageManager:getLaunchIntentForPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   78: astore 4
    //   80: aload_2
    //   81: iconst_1
    //   82: aaload
    //   83: invokestatic 229	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   86: ifne +15 -> 101
    //   89: aload 4
    //   91: aload_2
    //   92: iconst_1
    //   93: aaload
    //   94: invokestatic 235	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   97: invokevirtual 241	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   100: pop
    //   101: aload 4
    //   103: ifnull +131 -> 234
    //   106: aload_0
    //   107: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   110: getfield 244	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   113: sipush 1008
    //   116: if_icmpeq +118 -> 234
    //   119: aload 4
    //   121: ldc 246
    //   123: ldc 248
    //   125: invokevirtual 252	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   128: pop
    //   129: aload_0
    //   130: getfield 31	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:mApp	Lmqq/util/WeakReference;
    //   133: invokevirtual 256	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   136: checkcast 57	com/tencent/mobileqq/app/QQAppInterface
    //   139: bipush 23
    //   141: invokevirtual 96	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lanud;
    //   144: checkcast 258	aohr
    //   147: astore 5
    //   149: aload 4
    //   151: ldc_w 260
    //   154: ldc_w 262
    //   157: invokevirtual 252	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   160: pop
    //   161: aload 4
    //   163: ldc_w 264
    //   166: ldc 148
    //   168: invokevirtual 252	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   171: pop
    //   172: aload 4
    //   174: ldc_w 266
    //   177: ldc 132
    //   179: invokevirtual 252	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   182: pop
    //   183: aload 4
    //   185: ldc_w 268
    //   188: ldc_w 270
    //   191: invokevirtual 252	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   194: pop
    //   195: aload 4
    //   197: ldc_w 272
    //   200: aload_0
    //   201: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   204: invokevirtual 278	java/lang/Object:getClass	()Ljava/lang/Class;
    //   207: invokevirtual 283	java/lang/Class:getName	()Ljava/lang/String;
    //   210: invokevirtual 252	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   213: pop
    //   214: aload 5
    //   216: aload_2
    //   217: iconst_0
    //   218: aaload
    //   219: invokevirtual 288	java/lang/String:trim	()Ljava/lang/String;
    //   222: aload_0
    //   223: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   226: aload 4
    //   228: invokevirtual 291	aohr:b	(Ljava/lang/String;Landroid/content/Context;Landroid/content/Intent;)V
    //   231: goto +81 -> 312
    //   234: aload 4
    //   236: ifnull -107 -> 129
    //   239: aload 4
    //   241: ldc 246
    //   243: aload_0
    //   244: getfield 37	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   247: getfield 41	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   250: invokestatic 295	tzq:b	(Ljava/lang/String;)Ljava/lang/String;
    //   253: invokevirtual 252	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   256: pop
    //   257: goto -128 -> 129
    //   260: astore_2
    //   261: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq +13 -> 277
    //   267: ldc_w 297
    //   270: iconst_2
    //   271: ldc_w 299
    //   274: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   277: aload_0
    //   278: getfield 33	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:context	Landroid/content/Context;
    //   281: aload 4
    //   283: invokevirtual 303	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   286: goto +26 -> 312
    //   289: astore_2
    //   290: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   293: ifeq +13 -> 306
    //   296: ldc 75
    //   298: iconst_2
    //   299: aload_2
    //   300: invokevirtual 306	android/content/pm/PackageManager$NameNotFoundException:getMessage	()Ljava/lang/String;
    //   303: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload_0
    //   307: aload_1
    //   308: invokevirtual 309	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:clickWebMsg	(Ljava/lang/String;)Z
    //   311: ireturn
    //   312: iconst_1
    //   313: istore_3
    //   314: iload_3
    //   315: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	this	HightlightClickableSpan
    //   0	316	1	paramString1	String
    //   0	316	2	paramString2	String
    //   1	314	3	bool	boolean
    //   56	226	4	localObject	Object
    //   147	68	5	localaohr	aohr
    // Exception table:
    //   from	to	target	type
    //   106	129	260	java/lang/Exception
    //   129	231	260	java/lang/Exception
    //   239	257	260	java/lang/Exception
    //   58	101	289	android/content/pm/PackageManager$NameNotFoundException
    //   106	129	289	android/content/pm/PackageManager$NameNotFoundException
    //   129	231	289	android/content/pm/PackageManager$NameNotFoundException
    //   239	257	289	android/content/pm/PackageManager$NameNotFoundException
    //   261	277	289	android/content/pm/PackageManager$NameNotFoundException
    //   277	286	289	android/content/pm/PackageManager$NameNotFoundException
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
      paramString1 = bhni.a((QQAppInterface)this.mApp.get(), this.context, str);
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
      paramString.a().o(true);
      return true;
    } while ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("mqzone://arouse/lovermainpage")) || (this.mApp == null));
    awwi.a((QQAppInterface)this.mApp.get(), this.context, 2080, "");
    return false;
    label133:
    if (paramString.equals("http://imgcache.qq.com/lightalk/lightalk_pay/qq/index.html?_wv=1025&type=")) {
      bdll.b(null, "CliOper", "", "", "0X80070EB", "0X80070EB", 0, 0, "", "", "", "");
    }
    asbr.a(paramString);
    if ((this.message != null) && ((this.message instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)this.message).tipParam.b == 131078))
    {
      bfui.a("Grp_AIO", "grey_clk", new String[] { this.message.frienduin });
      bhsi.r(this.context, ((BaseActivity)this.context).app.getCurrentAccountUin(), this.message.frienduin);
    }
    if ((this.message != null) && (this.message.istroop == 1) && (axev.a((BaseActivity)this.context, paramString, this.message)))
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
      tzq.a(this.message, localIntent, paramString);
      this.context.startActivity(localIntent);
      paramString = (QQAppInterface)this.mApp.get();
      if ((paramString != null) && ((this.message instanceof MessageForGrayTips)) && (String.valueOf(11).equals(this.message.getExtInfoFromExtStr("gray_tips_serviceType")))) {
        bdll.b(paramString, "dc00898", "", "", "0X8009328", "0X8009328", 0, 0, "", "", "", "");
      }
      return true;
      if (this.message.istroop == 1008) {
        str = tzq.b(this.message.frienduin);
      } else {
        str = "biz_src_jc_aio";
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((this.item == null) || (this.mApp == null) || (this.mApp.get() == null)) {}
    Object localObject3;
    Object localObject5;
    label491:
    int i;
    label537:
    Object localObject2;
    Object localObject6;
    label1419:
    label1497:
    label3444:
    boolean bool1;
    label1671:
    label1737:
    label3681:
    long l;
    label2052:
    label3628:
    int j;
    Object localObject7;
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
                                                      localObject3 = (QQAppInterface)this.mApp.get();
                                                    } while (localObject3 == null);
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
                                                      if ((this.message != null) && (this.message.msgtype == -2049)) {
                                                        bjqh.a().a(((QQAppInterface)this.mApp.get()).getCurrentAccountUin(), "", "", "2000", "2012", "0", false);
                                                      }
                                                      if ((this.message != null) && ((this.message instanceof MessageForUniteGrayTip)))
                                                      {
                                                        localObject5 = ((MessageForUniteGrayTip)this.message).tipParam;
                                                        if (localObject5 != null)
                                                        {
                                                          if (((avpd)localObject5).b != 2359297) {
                                                            break label537;
                                                          }
                                                          bdll.b(null, "P_CliOper", "cmshow", "", "Apollo", "Invitetip_clk", 0, 0, "", "", "", "");
                                                          if (axsr.b(((avpd)localObject5).b))
                                                          {
                                                            if (!TextUtils.isEmpty(this.item.mMsgActionData)) {
                                                              break label1497;
                                                            }
                                                            paramView = this.item.mMsg_A_ActionData;
                                                            axsf.a((QQAppInterface)localObject3, (MessageForUniteGrayTip)this.message, ((avpd)localObject5).b, paramView);
                                                          }
                                                        }
                                                      }
                                                      if (TextUtils.isEmpty(this.item.mMsgActionData)) {}
                                                      for (paramView = this.item.mMsg_A_ActionData;; paramView = this.item.mMsgActionData)
                                                      {
                                                        clickWebMsg(paramView);
                                                        return;
                                                        if (((avpd)localObject5).b == 2359298)
                                                        {
                                                          bdll.b(null, "P_CliOper", "cmshow", "", "Apollo", "clk_intro", 0, 0, "", "", "", "");
                                                          break;
                                                        }
                                                        if (((avpd)localObject5).b == 2490369)
                                                        {
                                                          bdll.b(null, "dc00898", "", "", "0X8007F12", "0X8007F12", 0, 0, "", "", "", "");
                                                          break;
                                                        }
                                                        if (((avpd)localObject5).b == 2621441)
                                                        {
                                                          paramView = ((MessageForUniteGrayTip)this.message).appGuideTipsOpKey;
                                                          if (TextUtils.isEmpty(paramView)) {
                                                            break;
                                                          }
                                                          bdll.b(null, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
                                                          break;
                                                        }
                                                        if (((avpd)localObject5).b == 3145729)
                                                        {
                                                          bdll.b(null, "dc00898", "", "", "0X800812B", "0X800812B", 0, 0, "", "", "", "");
                                                          break;
                                                        }
                                                        if (((avpd)localObject5).b == 131078)
                                                        {
                                                          VasWebviewUtil.reportCommercialDrainage(((QQAppInterface)this.mApp.get()).c(), "style", "0X8009133", "", 1, 0, 0, "", "", "0");
                                                          break;
                                                        }
                                                        if (((avpd)localObject5).b == 2097154)
                                                        {
                                                          if (TextUtils.isEmpty(this.item.mMsgActionData)) {}
                                                          for (paramView = this.item.mMsg_A_ActionData; !TextUtils.isEmpty(paramView); paramView = this.item.mMsgActionData)
                                                          {
                                                            for (;;)
                                                            {
                                                              Object localObject1 = nnr.a(paramView);
                                                              if (!((Map)localObject1).containsKey("type")) {
                                                                break;
                                                              }
                                                              localObject1 = (String)((Map)localObject1).get("type");
                                                              try
                                                              {
                                                                i = Integer.parseInt((String)localObject1);
                                                                bdll.b((QQAppInterface)this.mApp.get(), "dc00898", "", "", "qq_vip", "0X8009CA6", i, 0, "", "", "", "");
                                                              }
                                                              catch (NumberFormatException localNumberFormatException) {}
                                                            }
                                                            if (!QLog.isColorLevel()) {
                                                              break;
                                                            }
                                                            QLog.d("reactive", 2, "parse url type error:" + paramView);
                                                            break;
                                                          }
                                                        }
                                                        if (((avpd)localObject5).b == 655384)
                                                        {
                                                          localObject2 = this.message.getExtInfoFromExtStr("love_c2c_aio_businessSubtype");
                                                          paramView = (View)localObject2;
                                                          if (TextUtils.isEmpty((CharSequence)localObject2)) {
                                                            paramView = "1";
                                                          }
                                                          LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", paramView, "", "2"));
                                                          break;
                                                        }
                                                        if (((avpd)localObject5).b == 2097153)
                                                        {
                                                          paramView = this.message.getExtInfoFromExtStr("friendIconType");
                                                          if (TextUtils.isEmpty(paramView)) {
                                                            break;
                                                          }
                                                          VasWebviewUtil.reportCommercialDrainage(((QQAppInterface)localObject3).getCurrentAccountUin(), "friendspark", "aio_click", "", 0, 0, 0, "", paramView, "", "", "", "", "", 0, 0, 0, 0);
                                                          if (paramView.equals("3"))
                                                          {
                                                            LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "8", "2"));
                                                            break;
                                                          }
                                                          if (!paramView.equals("6")) {
                                                            break;
                                                          }
                                                          LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "7", "2"));
                                                          break;
                                                        }
                                                        if (((avpd)localObject5).b == 655397)
                                                        {
                                                          paramView = this.message.getExtInfoFromExtStr("uint64_busi_type");
                                                          localObject2 = this.message.getExtInfoFromExtStr("uint64_busi_id");
                                                          localObject6 = this.message.getExtInfoFromExtStr("uint64_templ_id");
                                                          i = 3;
                                                          if (this.message.istroop == 0) {
                                                            i = 1;
                                                          }
                                                          for (;;)
                                                          {
                                                            bdll.b((QQAppInterface)localObject3, "CliOper", "", "", "0X800A561", "0X800A561", i, 0, "" + (String)localObject2, "" + paramView, "web", "");
                                                            if ("1008".equals(localObject2)) {
                                                              bdll.b(null, "dc00898", "", "", "0X800A639", "0X800A639", i - 1, 0, "", "", "", "");
                                                            }
                                                            if (Long.valueOf((String)localObject2).equals(Long.valueOf(1021L))) {
                                                              bdll.b(null, "dc00898", "", "", "0X800AD83", "0X800AD83", 0, 0, "", "", "", "");
                                                            }
                                                            bekk.a((String)localObject2, ((avpd)localObject5).a);
                                                            if ((!Long.valueOf((String)localObject2).equals(Long.valueOf(1038L))) || (TextUtils.isEmpty((CharSequence)localObject6))) {
                                                              break;
                                                            }
                                                            if (!Long.valueOf((String)localObject6).equals(Long.valueOf(1111L))) {
                                                              break label1419;
                                                            }
                                                            bdll.b(null, "dc00898", "", "", "0X800B1A3", "0X800B1A3", 0, 0, "", "", "", "");
                                                            break;
                                                            if (this.message.istroop == 1) {
                                                              i = 2;
                                                            }
                                                          }
                                                          if (!Long.valueOf((String)localObject6).equals(Long.valueOf(1112L))) {
                                                            break;
                                                          }
                                                          bdll.b(null, "dc00898", "", "", "0X800B1A5", "0X800B1A5", 0, 0, "", "", "", "");
                                                          break;
                                                        }
                                                        if (((avpd)localObject5).b != 131090) {
                                                          break;
                                                        }
                                                        bfuv.a((QQAppInterface)this.mApp.get(), this.frienduin);
                                                        break;
                                                        paramView = this.item.mMsgActionData;
                                                        break label491;
                                                      }
                                                    case 3: 
                                                      if ((this.message != null) && ((this.message instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)this.message).tipParam.b == 655397))
                                                      {
                                                        paramView = this.message.getExtInfoFromExtStr("uint64_busi_type");
                                                        localObject2 = this.message.getExtInfoFromExtStr("uint64_busi_id");
                                                        i = 3;
                                                        if (this.message.istroop != 0) {
                                                          break label1671;
                                                        }
                                                        i = 1;
                                                      }
                                                      for (;;)
                                                      {
                                                        bdll.b((QQAppInterface)localObject3, "CliOper", "", "", "0X800A561", "0X800A561", i, 0, "" + (String)localObject2, "" + paramView, "mqq", "");
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
                                                      bguq.a(this.context, paramView, i);
                                                      return;
                                                    case 17: 
                                                      localObject2 = new Intent(this.context, PermisionPrivacyActivity.class);
                                                      if (this.message != null) {}
                                                      for (paramView = this.message.getExtInfoFromExtStr("scrollflag");; paramView = null)
                                                      {
                                                        if (!TextUtils.isEmpty(paramView))
                                                        {
                                                          ((Intent)localObject2).putExtra("scrollflag", paramView);
                                                          bdll.b((QQAppInterface)this.mApp.get(), "P_CliOper", "invite_friend", "", "auto_pass", "clk_set_entry", 0, 0, this.frienduin, "", "", "");
                                                        }
                                                        this.context.startActivity((Intent)localObject2);
                                                        return;
                                                      }
                                                    case 5: 
                                                      paramView = (QQAppInterface)this.mApp.get();
                                                    }
                                                  } while ((this.context == null) || (paramView == null));
                                                  azyo.a(paramView, this.context, this.frienduin, "" + this.item.uin, 4, -1);
                                                  return;
                                                  paramView = (QQAppInterface)this.mApp.get();
                                                } while ((this.context == null) || (paramView == null));
                                                azyo.a(paramView, this.context, this.frienduin, "" + this.item.uin, 4, -1);
                                                paramView = paramView.getCurrentAccountUin();
                                                localObject2 = (TroopManager)((QQAppInterface)this.mApp.get()).getManager(52);
                                                if (localObject2 == null) {
                                                  break;
                                                }
                                                localObject2 = ((TroopManager)localObject2).b(this.frienduin);
                                                if (localObject2 == null) {
                                                  break;
                                                }
                                                if (((TroopInfo)localObject2).isTroopOwner(paramView)) {}
                                                for (paramView = "1";; paramView = "2")
                                                {
                                                  bhju.a("Grp_manage", "recall_msg", "clk_mberName", 0, 0, new String[] { this.frienduin, paramView });
                                                  return;
                                                }
                                              } while (this.context == null);
                                              paramView = new Intent(this.context, EditInfoActivity.class);
                                              localObject2 = String.valueOf(this.item.uin);
                                              localObject3 = bhlg.i((QQAppInterface)this.mApp.get(), this.frienduin, (String)localObject2);
                                              paramView.putExtra("edit_type", 0);
                                              paramView.putExtra("troopUin", this.frienduin);
                                              paramView.putExtra("uin", (String)localObject2);
                                              paramView.putExtra("title", this.context.getResources().getString(2131696899));
                                              paramView.putExtra("isTroopNick", true);
                                              paramView.putExtra("default_text", (String)localObject3);
                                              paramView.putExtra("max_num", 60);
                                              paramView.putExtra("default_hint", anzj.a(2131705498));
                                              paramView.putExtra("auto_remark", true);
                                              this.context.startActivity(paramView);
                                              return;
                                              paramView = new TroopInfoData();
                                              paramView.troopUin = this.frienduin;
                                              localObject2 = (TroopManager)((QQAppInterface)this.mApp.get()).getManager(52);
                                            } while (localObject2 == null);
                                            localObject2 = ((TroopManager)localObject2).b(this.frienduin);
                                            if (localObject2 != null)
                                            {
                                              paramView.updateForTroopChatSetting((TroopInfo)localObject2, this.context.getResources(), ((QQAppInterface)this.mApp.get()).getCurrentAccountUin());
                                              paramView.isMember = true;
                                            }
                                            new bhbx((SplashActivity)this.context, paramView).a(paramView);
                                            return;
                                            if (QLog.isColorLevel()) {
                                              QLog.d("reactive", 2, "onclick graytip");
                                            }
                                            bdll.b(null, "dc00898", "", "", "0X8007603", "0X8007603", 0, 0, "", "", "", "");
                                            paramView = new Intent(this.context, QQBrowserActivity.class);
                                            localObject2 = arfj.a().a(this.frienduin);
                                            if (QLog.isColorLevel()) {
                                              QLog.d("MessageForGrayTips", 2, String.format("goToC2CWebPage, url: %s", new Object[] { localObject2 }));
                                            }
                                            paramView.putExtra("url", (String)localObject2);
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
                                                bdll.b((QQAppInterface)this.mApp.get(), "dc00898", "", "", "qq_vip", "0X8009CA7", 0, 0, "", "", "", "");
                                              }
                                              if (paramView != null) {
                                                axsf.b((QQAppInterface)localObject3, (MessageForUniteGrayTip)this.message, paramView.b);
                                              }
                                            }
                                          } while ((this.message == null) || (!(this.message instanceof MessageForUniteGrayTip)));
                                          paramView = ((MessageForUniteGrayTip)this.message).tipParam;
                                        } while ((paramView == null) || (2097155 != paramView.b));
                                        bdll.b((QQAppInterface)this.mApp.get(), "dc00898", "", "", "0X800A1BD", "0X800A1BD", 0, 0, "", "", "", "");
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
                                        paramView.putExtra("param_done_button_wording", this.context.getString(2131696625));
                                        paramView.putExtra("param_only_friends", true);
                                        paramView.putExtra("param_is_troop_admin", true);
                                        paramView.putExtra("param_title", this.context.getString(2131695407));
                                        paramView.putExtra("param_max", 100);
                                        this.context.startActivity(paramView);
                                        return;
                                        paramView = ((TroopManager)((QQAppInterface)this.mApp.get()).getManager(52)).c(this.frienduin);
                                      } while (paramView == null);
                                      localObject2 = new Intent(this.context, EditInfoActivity.class);
                                      ((Intent)localObject2).putExtra("edit_type", 2);
                                      ((Intent)localObject2).putExtra("title", anzj.a(2131705510));
                                      if (paramView.hasSetNewTroopName) {
                                        ((Intent)localObject2).putExtra("default_text", paramView.troopname);
                                      }
                                      ((Intent)localObject2).putExtra("max_num", 96);
                                      ((Intent)localObject2).putExtra("canPostNull", false);
                                      ((Activity)this.context).startActivityForResult((Intent)localObject2, 13010);
                                      return;
                                      bgpk.a(this.context, this.frienduin);
                                      bhju.a("Grp_edu", "Grp_AIO", "graybar_showmore", 0, 0, new String[] { this.frienduin });
                                      return;
                                    } while ((this.message == null) || (!(this.message instanceof MessageForUniteGrayTip)));
                                    paramView = (MessageForUniteGrayTip)this.message;
                                  } while (this.mApp == null);
                                  localObject2 = (bkib)((QQAppInterface)this.mApp.get()).a(85);
                                } while (localObject2 == null);
                                ((bkib)localObject2).a(paramView.extUin, paramView.masterUin, paramView.taskId, paramView.uniseq, paramView.istroop);
                                return;
                                paramView = new Intent(this.context, EditActivity.class);
                                paramView.putExtra("title", 2131693046).putExtra("current", this.item.remark).putExtra("action", 103).putExtra("limit", 96).putExtra("canPostNull", true).putExtra("multiLine", false);
                                if ((this.context instanceof BaseActivity)) {
                                  ((BaseActivity)this.context).startActivityForResult(paramView, 13008);
                                }
                                for (;;)
                                {
                                  bdll.b((QQAppInterface)this.mApp.get(), "dc00898", "", "", "0X800797A", "0X800797A", 0, 0, "", "", "", "");
                                  if (!"from_batch_add_frd_for_troop".equals(this.item.mMsgActionData)) {
                                    break;
                                  }
                                  bdll.b((QQAppInterface)this.mApp.get(), "dc00899", "Grp_addFrd", "", "Frd_AIO", "setRefTips_clk", 0, 0, "", "", "", "");
                                  return;
                                  this.context.startActivity(paramView);
                                }
                                paramView = new Intent(this.context, MoveToGroupActivity.class);
                                i = this.item.groupId;
                                if ((i != -1) && ((i != 0) || (!"from_batch_add_frd_for_troop".equals(this.item.mMsgActionData)))) {
                                  break label7945;
                                }
                                localObject2 = ((anyw)((QQAppInterface)this.mApp.get()).getManager(51)).e(this.frienduin);
                                if (localObject2 != null)
                                {
                                  i = ((Friends)localObject2).groupid;
                                  paramView.putExtra("friendUin", this.frienduin).putExtra("mgid", (byte)i);
                                  if (!(this.context instanceof BaseActivity)) {
                                    break label3628;
                                  }
                                  ((BaseActivity)this.context).startActivityForResult(paramView, 13009);
                                }
                                for (;;)
                                {
                                  bdll.b((QQAppInterface)this.mApp.get(), "dc00898", "", "", "0X8007979", "0X8007979", 0, 0, "", "", "", "");
                                  if (!"from_batch_add_frd_for_troop".equals(this.item.mMsgActionData)) {
                                    break;
                                  }
                                  if (QLog.isDevelopLevel()) {
                                    QLog.i("MessageForGrayTips", 4, String.format(Locale.getDefault(), "ACTION_FRIEND_GROUP_SETTING gid: %s, groupId: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.item.groupId) }));
                                  }
                                  bdll.b((QQAppInterface)this.mApp.get(), "dc00899", "Grp_addFrd", "", "Frd_AIO", "setGrpTips_clk", 0, 0, "", "", "", "");
                                  return;
                                  i = 0;
                                  break label3444;
                                  this.context.startActivity(paramView);
                                }
                                if ((this.message == null) || (this.message.msg == null)) {
                                  break;
                                }
                                paramView = this.message.msg.substring(this.item.start, this.item.end);
                                localObject2 = this.item.mMsgActionData;
                                localObject3 = this.item.mMsg_A_ActionData;
                              } while ((localObject2 == null) || (localObject3 == null) || (!(this.context instanceof FragmentActivity)));
                              localObject5 = ((FragmentActivity)this.context).getChatFragment();
                            } while ((localObject5 == null) || (((ChatFragment)localObject5).a() == null));
                            localObject5 = ((ChatFragment)localObject5).a();
                            ((BaseChatPie)localObject5).a.setText("");
                            localObject2 = bgme.a((QQAppInterface)this.mApp.get(), this.context, this.frienduin, (String)localObject2, (String)localObject3, false, ((BaseChatPie)localObject5).a, true);
                            ((BaseChatPie)localObject5).a.setText((CharSequence)localObject2);
                            ((BaseChatPie)localObject5).a.append(paramView);
                            ((BaseChatPie)localObject5).a.setSelection(((BaseChatPie)localObject5).a.getText().length());
                            return;
                            for (;;)
                            {
                              try
                              {
                                localObject3 = new JSONObject(this.item.mMsgActionData);
                                paramView = ((JSONObject)localObject3).optString("uin");
                                localObject2 = ((JSONObject)localObject3).optString("name");
                                localObject3 = ((JSONObject)localObject3).optString("text");
                                if ((paramView == null) || (localObject2 == null) || (!(this.context instanceof FragmentActivity))) {
                                  break;
                                }
                                localObject5 = ((FragmentActivity)this.context).getChatFragment();
                                if ((localObject5 == null) || (((ChatFragment)localObject5).a() == null)) {
                                  break;
                                }
                                localObject5 = ((ChatFragment)localObject5).a();
                                if (!TextUtils.isEmpty((CharSequence)localObject3))
                                {
                                  bool1 = true;
                                  paramView = bgme.a((QQAppInterface)this.mApp.get(), this.context, this.frienduin, paramView, (String)localObject2, false, ((BaseChatPie)localObject5).a, true, bool1);
                                  ((BaseChatPie)localObject5).a.setText(paramView);
                                  ((BaseChatPie)localObject5).a.append((CharSequence)localObject3);
                                  ((BaseChatPie)localObject5).a.setSelection(((BaseChatPie)localObject5).a.getText().length());
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
                            xlj.a(this.context, this.item.mMsgActionData, "HightLight_Feed_Id", 1005);
                            yup.a("story_grp", "aio_grey", 0, 0, new String[] { "", "", "", "" });
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
                              if (!paramView.j()) {
                                break;
                              }
                              paramView.a(10, l, 0, null);
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
                        i = bgyq.a(bgyq.a(paramView.d, 0));
                        paramView = bgyq.a(paramView.d, 1);
                        bbbt.a(this.context, (QQAppInterface)this.mApp.get(), this.item.mMsgActionData, this.item.mMsg_A_ActionData, i, paramView);
                        return;
                        localObject5 = this.frienduin;
                        i = this.message.istroop;
                        j = this.message.getConfessTopicId();
                        localObject6 = new ConfessInfo();
                        ((ConfessInfo)localObject6).parseFromJsonStr(this.message.getExtInfoFromExtStr("ext_key_confess_info"));
                      } while ((!(this.context instanceof FragmentActivity)) || (((FragmentActivity)this.context).isFinishing()) || (adak.a(i) != 1032));
                      localObject7 = ((FragmentActivity)this.context).getChatFragment().a();
                      localObject2 = null;
                      paramView = (View)localObject2;
                      if (localObject7 != null)
                      {
                        paramView = (View)localObject2;
                        if ((localObject7 instanceof aiim)) {
                          paramView = (aiim)localObject7;
                        }
                      }
                    } while (paramView == null);
                    paramView = bhlq.a(this.context, 0, aqyl.f, aqyl.g, 2131690580, 2131694098, new arxg(this, (QQAppInterface)localObject3, (String)localObject5, i, j, (ConfessInfo)localObject6, paramView), new arxh(this));
                  } while (((FragmentActivity)this.context).isFinishing());
                  paramView.show();
                  return;
                } while (!(this.context instanceof FragmentActivity));
                paramView = ((FragmentActivity)this.context).getChatFragment();
              } while ((paramView == null) || (paramView.a() == null));
              paramView = paramView.a();
            } while (!(paramView instanceof aihh));
            ((aihh)paramView).g(this.item.mMsgActionData);
            return;
            if (!BaseChatItemLayout.a) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("MessageForGrayTips", 2, "revoke msg multi msg select forward,return click");
          return;
        } while (!(this.context instanceof FragmentActivity));
        paramView = this.item.mMsgActionData;
        localObject3 = this.item.mMsg_A_ActionData;
        if (QLog.isColorLevel())
        {
          l = 0L;
          if (!TextUtils.isEmpty(paramView)) {
            l = paramView.length();
          }
          QLog.d("MessageForGrayTips", 2, new Object[] { "revoke msg click handle msg length =", Long.valueOf(l) });
        }
        localObject2 = ((FragmentActivity)this.context).getChatFragment();
      } while ((localObject2 == null) || (((ChatFragment)localObject2).a() == null));
      avpe.a(this.message);
      localObject2 = ((ChatFragment)localObject2).a();
      if ((((BaseChatPie)localObject2).a != null) && (((BaseChatPie)localObject2).a.getEditableText() != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MessageForGrayTips", 2, "revoke msg clickspan chatpie input is null");
    return;
    ((BaseChatPie)localObject2).a.getEditableText().clear();
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {}
    for (;;)
    {
      try
      {
        localObject3 = new JSONArray((String)localObject3);
        if ((localObject3 != null) && (((JSONArray)localObject3).length() != 0)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MessageForGrayTips", 2, "revoke msg clickspan handle at info is null");
        }
        ((BaseChatPie)localObject2).a.setText(paramView);
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MessageForGrayTips", 2, "revoke msg clickspan json exception,input only text String", localJSONException);
        ((BaseChatPie)localObject2).a.setText(paramView);
        continue;
        j = 0;
      }
      j = ((BaseChatPie)localObject2).a.getText().length();
      i = j;
      if (j < 0) {
        i = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MessageForGrayTips", 2, "revoke msg click handle input length =" + i);
      }
      ((BaseChatPie)localObject2).c = "";
      ((BaseChatPie)localObject2).a.setSelection(i);
      ((BaseChatPie)localObject2).aB();
      return;
      i = 0;
      if (i < ((JSONArray)localObject3).length())
      {
        localObject5 = ((JSONArray)localObject3).getJSONObject(i);
        localObject6 = ((JSONObject)localObject5).optString(bcrn.k);
        int n = ((JSONObject)localObject5).optInt(bcrn.l);
        localObject5 = new JSONArray((String)localObject6);
        if ((localObject5 != null) && (((JSONArray)localObject5).length() == 0))
        {
          ((BaseChatPie)localObject2).a.setText(paramView);
        }
        else
        {
          label4995:
          if (j < ((JSONArray)localObject5).length())
          {
            localObject6 = ((JSONArray)localObject5).getJSONObject(j);
            int i1 = ((JSONObject)localObject6).optInt("startPos");
            int k = ((JSONObject)localObject6).optInt("textLen");
            ((JSONObject)localObject6).optInt("flag");
            localObject6 = ((JSONObject)localObject6).optString("uin");
            localObject7 = paramView.substring(i1 + 1, k + i1);
            int m = ((BaseChatPie)localObject2).a.getSelectionEnd();
            k = m;
            if (m < 0) {
              k = 0;
            }
            Object localObject8 = paramView.substring(k, i1);
            ((BaseChatPie)localObject2).a.getEditableText().insert(k, (CharSequence)localObject8);
            localObject8 = (QQAppInterface)this.mApp.get();
            Context localContext = this.context;
            String str = this.frienduin;
            XEditTextEx localXEditTextEx = ((BaseChatPie)localObject2).a;
            if (n != 1) {
              break label7966;
            }
            bool1 = true;
            label5156:
            localObject6 = bgme.a((QQAppInterface)localObject8, localContext, str, (String)localObject6, (String)localObject7, false, localXEditTextEx, bool1);
            if ((localObject6 == null) || (((SpannableString)localObject6).length() == 0)) {
              break;
            }
            m = ((BaseChatPie)localObject2).a.getSelectionEnd();
            k = m;
            if (m < 0) {
              k = 0;
            }
            ((BaseChatPie)localObject2).a.getEditableText().insert(k, (CharSequence)localObject6);
            if (j != ((JSONArray)localObject5).length() - 1) {
              break;
            }
            m = ((BaseChatPie)localObject2).a.getSelectionEnd();
            k = m;
            if (m < 0) {
              k = 0;
            }
            if (k > paramView.length() - 1) {
              break;
            }
            localObject6 = paramView.substring(k, paramView.length());
            ((BaseChatPie)localObject2).a.getEditableText().insert(k, (CharSequence)localObject6);
            break;
          }
          i += 1;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("MessageForGrayTips", 2, "revoke msg click handle at info is empty");
          }
          ((BaseChatPie)localObject2).a.setText(paramView);
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
            break label7934;
          }
          paramView = (MessageForUniteGrayTip)this.message;
          if (paramView.istroop != 0) {
            continue;
          }
          if (!paramView.senderuin.equals(localJSONException.getCurrentAccountUin())) {
            continue;
          }
          i = 1;
          bdll.b((QQAppInterface)this.mApp.get(), "dc00898", "", "", "0X800A613", "0X800A613", 0, 0, i + "", "", "", "");
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
        aean.a(this.context, localJSONException, (ChatMessage)this.message);
        return;
        i = 2;
        continue;
        if (paramView.istroop == 1)
        {
          bool1 = bguq.a(localJSONException, this.message.frienduin, localJSONException.c());
          bool2 = bguq.b(localJSONException, this.message.frienduin, localJSONException.c());
          localObject2 = paramView.tipParam.c;
          localObject5 = anzj.a(2131705502) + localJSONException.getApp().getString(2131697031);
          if (bool1)
          {
            if (((String)localObject2).startsWith((String)localObject5))
            {
              i = 3;
              break label7972;
            }
            if (!paramView.senderuin.equals(localJSONException.getCurrentAccountUin())) {
              break label7975;
            }
            i = 4;
            break label7972;
          }
          if (bool2)
          {
            if (((String)localObject2).startsWith((String)localObject5))
            {
              i = 5;
              break label7972;
            }
            if (!paramView.senderuin.equals(localJSONException.getCurrentAccountUin())) {
              break label7981;
            }
            i = 6;
            break label7972;
          }
          if (!paramView.senderuin.equals(localJSONException.getCurrentAccountUin())) {
            break label7987;
          }
          i = 7;
          break label7972;
        }
        if (paramView.istroop == 3000)
        {
          if (!paramView.senderuin.equals(localJSONException.getCurrentAccountUin())) {
            break label7993;
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
              paramView.getChatFragment().a().a((ChatMessage)this.message);
              ((bfui)localJSONException.getManager(231)).a(this.item.mMsgActionData);
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
            VasWebviewUtil.reportCommercialDrainage(localJSONException.c(), "style", "0X8009133", "", 1, 0, 0, "", "", "3");
            return;
            if (this.context != null) {
              bhzu.a(this.item.mMsgActionData, this.context);
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
            VasWebviewUtil.reportCommercialDrainage(((QQAppInterface)this.mApp.get()).c(), "style", "0X8009133", "", 1, 0, 0, "", "", "1");
            return;
            if ((this.mApp.get() == null) || (this.message == null) || (!(this.message instanceof MessageForUniteGrayTip))) {
              break;
            }
            awwi.a((QQAppInterface)this.mApp.get(), this.context, 2080, "6");
            return;
            if (becb.a()) {
              break;
            }
            try
            {
              paramView = String.valueOf(this.item.uin);
              localObject2 = this.item.mMsg_A_ActionData;
              localObject4 = this.item.mMsgActionData.split("@#@");
              localObject5 = localObject4[0];
              l = Long.parseLong(localObject4[1]);
              i = this.message.istroop;
              localObject2 = becb.a((String)localObject5, paramView, (String)localObject2);
              QLog.i("MessageForGrayTips" + beai.i, 1, "click to modify tencent docs auth. frienduin = " + paramView + ", uinType = " + i + ", msgSeq = " + l + ", docsGrayTipsInfo = " + localObject2);
              if (localObject2 == null) {
                break;
              }
              if (((DocsGrayTipsInfo)localObject2).s.equals(beai.k))
              {
                paramView = ((DocsGrayTipsInfo)localObject2).t;
                if (TextUtils.isEmpty(paramView)) {
                  break;
                }
                becb.a(this.context, paramView);
                bdll.b(null, "dc00898", "", "", "0X8009C79", "0X8009C79", 0, 0, "", "", "", "");
                return;
              }
            }
            catch (Exception paramView)
            {
              QLog.e("MessageForGrayTips" + beai.i, 1, " docs gray tips action exception =" + paramView.toString());
              return;
            }
          }
        }
      }
      paramView = (bebl)((QQAppInterface)this.mApp.get()).a(122);
      if (i == 1)
      {
        paramView.b((DocsGrayTipsInfo)localObject2, l);
        return;
      }
      paramView.a((DocsGrayTipsInfo)localObject2, l);
      return;
      Object localObject4 = (QQAppInterface)this.mApp.get();
      if ((localObject4 == null) || (!aqyl.a((AppInterface)localObject4))) {
        break;
      }
      if (this.message.isSelfConfessor()) {
        paramView = ((QQAppInterface)localObject4).getAccount();
      }
      for (localObject2 = this.message.frienduin;; localObject2 = ((QQAppInterface)localObject4).getAccount())
      {
        aqyl.b((QQAppInterface)localObject4, aqyt.a(this.message.frienduin, this.message.istroop, this.message.getConfessTopicId()), false);
        localObject5 = (aqym)((QQAppInterface)localObject4).a(125);
        if (localObject5 != null) {
          ((aqym)localObject5).notifyUI(9, true, new Object[] { this.message.frienduin, Integer.valueOf(this.message.getConfessTopicId()), Integer.valueOf(this.message.istroop) });
        }
        aqyl.a((AppInterface)localObject4, this.context, paramView, (String)localObject2, this.message.getConfessTopicId(), this.message.isSelfConfessor());
        bdll.b((QQAppInterface)localObject4, "dc00898", "", "", "0X8009574", "0X8009574", 0, 0, this.message.getConfessTopicId() + "", "", paramView, (String)localObject2);
        return;
        paramView = this.message.frienduin;
      }
      i = this.message.istroop;
      if ((i != 1044) && (i != 1045)) {
        break;
      }
      awlm.a(this.context, this.frienduin, this.item.mMsgActionData, this.item.mMsg_A_ActionData);
      return;
      if (this.context == null) {
        break;
      }
      PublicFragmentActivity.a(this.context, TempMsgSettingFragment.class);
      j = 0;
      try
      {
        i = Integer.parseInt(this.item.mMsgActionData);
        bdll.b(null, "dc00898", "", "", "0X800997A", "0X800997A", i, i, "", "", "", "");
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
      bguq.a(this.context, paramView, 2);
      bdll.b(null, "dc00898", "", "", "0X800997B", "0X800997B", 0, 0, "", "", "", "");
      return;
      if (aovh.d) {
        this.context.startActivity(aovh.a);
      }
      for (;;)
      {
        try
        {
          i = Integer.parseInt(this.item.mMsgActionData);
          bdll.b(null, "dc00898", "", "", "0X8009AD0", "0X8009AD0", i, i, "", "", "", "");
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
      paramView = new Intent(this.context, AssistantSettingActivity.class);
      this.context.startActivity(paramView);
      return;
      paramView = this.item.mMsg_A_ActionData;
      localObject2 = this.item.mMsgActionData;
      if ((!TextUtils.isEmpty(paramView)) && (paramView.contains("docs.qq.com/form"))) {
        becb.a(this.context, paramView, (String)localObject2);
      }
      for (;;)
      {
        bdll.b(null, "dc00898", "", this.frienduin, "0X8009FD1", "0X8009FD1", 0, 0, "", "", "", "");
        return;
        if (becb.a(paramView)) {
          MiniAppLauncher.startMiniApp(this.context, paramView, 0, null);
        }
      }
      if ((this.context instanceof FragmentActivity))
      {
        paramView = ((FragmentActivity)this.context).getChatFragment();
        if ((paramView != null) && (paramView.a() != null))
        {
          paramView = paramView.a();
          if ((paramView instanceof aijm)) {
            ((aijm)paramView).bx();
          }
        }
      }
      bdll.b((QQAppInterface)this.mApp.get(), "dc00898", "", "", "0X800A013", "0X800A013", 0, 0, "", "", "", "");
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
        awml.a((QQAppInterface)localObject4, this.context, 1, this.frienduin, 0);
        return;
      }
      if (this.message.istroop != 0) {
        break;
      }
      awml.a((QQAppInterface)this.mApp.get(), this.context, 2, this.frienduin, 0);
      return;
      if (!(this.context instanceof FragmentActivity)) {
        break;
      }
      paramView = ((FragmentActivity)this.context).getChatFragment();
      if ((paramView == null) || (paramView.a() == null) || (!(paramView.a() instanceof TroopChatPie))) {
        break;
      }
      paramView = (TroopChatPie)paramView.a();
      localObject2 = paramView.a();
      if ((TextUtils.isEmpty(this.frienduin)) || (!this.frienduin.equals(localObject2)) || (!(this.message instanceof ChatMessage))) {
        break;
      }
      ((agwm)paramView.a(41)).b(1);
      ((TroopManager)((QQAppInterface)localObject4).getManager(52)).a().a((QQAppInterface)localObject4, this.context, paramView.a, this.frienduin, 0, (ChatMessage)this.message);
      ahvz.c = 3;
      ahvz.a = this.message.senderuin;
      new bdlq((QQAppInterface)localObject4).a("dc00899").b("Grp_AIO").c("newman_join").d("clk_bar").a(new String[] { localObject2, "", "" + bguq.b((QQAppInterface)localObject4, (String)localObject2) }).a();
      return;
      paramView = ((TroopManager)((QQAppInterface)this.mApp.get()).getManager(52)).c(this.frienduin);
      localObject2 = new ArrayList(Arrays.asList(this.item.mMsgActionData.split(",")));
      LpReportInfo_pf00064.allReport(40, 3, 2);
      bmtd.a((Activity)this.context, ((QQAppInterface)localObject4).c(), 1, 0, Long.parseLong(this.frienduin), paramView.troopname, "$RecentAlbumId", bhkc.d, (ArrayList)localObject2, -1, 0, 3);
      return;
      i = QzoneConfig.getInstance().getConfig("aio_qzone_troop_gray_tips", "troop_gray_tips_cool_down", 24);
      paramView = String.format(anzj.a(2131718925), new Object[] { Integer.valueOf(i) });
      QQToast.a(BaseApplication.getContext(), 0, paramView, 0).a();
      l = System.currentTimeMillis() / 1000L;
      LocalMultiProcConfig.putLong4Uin("aio_qzone_troop_gray_tips", i * 60 * 60 + l, this.item.uin);
      aean.a(this.context, (QQAppInterface)localObject4, (ChatMessage)this.message);
      LpReportInfo_pf00064.allReport(40, 3, 3);
      return;
      bguq.a((QQAppInterface)this.mApp.get(), this.context, this.frienduin, this.item.mMsg_A_ActionData, this.item.mMsgActionData);
      return;
      bguq.a((QQAppInterface)this.mApp.get(), this.context, this.message, this.frienduin, this.item.mMsgActionData);
      return;
      bguq.b((QQAppInterface)this.mApp.get(), this.context, this.message, this.frienduin, this.item.mMsgActionData);
      return;
      doAddFriendSafetyReport((QQAppInterface)localObject4);
      return;
      avot.a(this.context, "1", this.message.istroop);
      return;
      ataa.a(this.context);
      return;
      bfuv.a((QQAppInterface)this.mApp.get(), this.context, this.frienduin, this.item.mMsgActionData);
      return;
      label7934:
      i = -1;
      continue;
      paramView = "";
      break label3681;
      label7945:
      break label3444;
      paramView = "";
      break label2052;
      i = 1;
      break label1737;
      j += 1;
      break label4995;
      label7966:
      bool1 = false;
      break label5156;
      for (;;)
      {
        label7972:
        break;
        label7975:
        i = 8;
        continue;
        label7981:
        i = 8;
        continue;
        label7987:
        i = 8;
      }
      label7993:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan
 * JD-Core Version:    0.7.0.1
 */