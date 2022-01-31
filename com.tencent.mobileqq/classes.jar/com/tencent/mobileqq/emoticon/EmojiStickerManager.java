package com.tencent.mobileqq.emoticon;

import acka;
import adww;
import ajed;
import ajjy;
import akaq;
import akbj;
import akbm;
import akhp;
import anam;
import ance;
import ancg;
import anch;
import andn;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import anfr;
import anfs;
import anht;
import anjd;
import anlr;
import anly;
import anmf;
import aqax;
import arnz;
import awao;
import awqx;
import axjs;
import axkd;
import azzz;
import babh;
import bejx;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashMap<Landroid.util.Pair<Ljava.lang.Long;Ljava.lang.Long;>;Ljava.util.List<Lcom.tencent.mobileqq.data.ChatMessage;>;>;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class EmojiStickerManager
{
  public static float a;
  public static View a;
  private static final EmojiStickerManager jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager = new EmojiStickerManager();
  public static boolean a;
  public static String b;
  public static boolean b;
  public static int c;
  public static boolean c;
  public static int d;
  public static long d;
  public static boolean d;
  public static int e;
  public static boolean e;
  public static int f;
  public static boolean f;
  public static int g;
  public static boolean g;
  public static int h;
  public static boolean h;
  public static int i;
  public static int j;
  public static int k;
  public static int l;
  public int a;
  public long a;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public LRULinkedHashMap<Pair<Long, Long>, ArrayList<Long>> a;
  public String a;
  public ArrayList<Bundle> a;
  public List<MessageRecord> a;
  public ConcurrentHashMap<Pair<Long, Long>, ArrayList<Long>> a;
  public int b;
  public long b;
  public LRULinkedHashMap<Pair<Long, Long>, Boolean> b;
  public ConcurrentHashMap<String, Long> b;
  public long c;
  
  static
  {
    jdField_e_of_type_Boolean = true;
    jdField_c_of_type_Int = 5;
    d = 1;
    jdField_e_of_type_Int = jdField_c_of_type_Int;
    f = jdField_c_of_type_Int;
    jdField_h_of_type_Int = 1;
    i = 20;
    j = 10;
    jdField_a_of_type_Float = 0.01F;
    jdField_b_of_type_JavaLangString = "";
    l = -1;
  }
  
  private EmojiStickerManager()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = -2147483648;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    this.jdField_b_of_type_Long = -9223372036854775808L;
    this.jdField_c_of_type_Long = -9223372036854775808L;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(64);
    this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(64);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static int a(StringBuilder paramStringBuilder)
  {
    int i7 = paramStringBuilder.length();
    int i8 = paramStringBuilder.length();
    int m = 0;
    int i2 = 0;
    int i3 = 0;
    int i9;
    int n;
    label86:
    int i1;
    if (i3 < i7)
    {
      i9 = paramStringBuilder.codePointAt(i3);
      if ((i9 == 20) && (i3 < i8 - 1))
      {
        n = paramStringBuilder.charAt(i3 + 1);
        if (n < axjs.jdField_a_of_type_Int) {
          if (axkd.jdField_a_of_type_Boolean)
          {
            paramStringBuilder.replace(i3, i3 + 2, "##");
            i1 = i3 + 1;
            n = i2 + 1;
            m += 1;
            label100:
            if (n <= 512) {
              break label741;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (m > 0) {}
      return m;
      if (n != 10) {
        break label86;
      }
      paramStringBuilder.setCharAt(i3 + 1, 'ú');
      break label86;
      if ((n >= 255) && (i3 + 4 < i8))
      {
        char[] arrayOfChar = new char[4];
        arrayOfChar[0] = paramStringBuilder.charAt(i3 + 4);
        arrayOfChar[1] = paramStringBuilder.charAt(i3 + 3);
        arrayOfChar[2] = paramStringBuilder.charAt(i3 + 2);
        arrayOfChar[3] = paramStringBuilder.charAt(i3 + 1);
        n = 0;
        if (n < 3)
        {
          if (arrayOfChar[n] == 'ú') {
            arrayOfChar[n] = '\n';
          }
          for (;;)
          {
            n += 1;
            break;
            if (arrayOfChar[n] == 'þ') {
              arrayOfChar[n] = '\r';
            }
          }
        }
        n = 2;
        if (n < 5)
        {
          if (paramStringBuilder.charAt(i3 + n) == '\n') {
            paramStringBuilder.setCharAt(i3 + n, 'ú');
          }
          for (;;)
          {
            n += 1;
            break;
            if (paramStringBuilder.charAt(i3 + n) == '\r') {
              paramStringBuilder.setCharAt(i3 + n, 'þ');
            }
          }
        }
        i1 = i3 + 4;
        n = i2 + 1;
        m += 1;
        break label100;
      }
      int i4;
      if (n == 250)
      {
        if (axkd.jdField_a_of_type_Boolean) {
          paramStringBuilder.replace(i3, i3 + 2, "##");
        }
        i1 = i3 + 1;
        n = i2 + 1;
        m += 1;
        break label100;
        i4 = axjs.a(i9);
        if (i9 > 65535)
        {
          if (i8 <= i3 + 2) {
            break label787;
          }
          i1 = paramStringBuilder.codePointAt(i3 + 2);
          n = 0;
        }
      }
      for (;;)
      {
        label410:
        if (axjs.a(i1)) {}
        for (int i5 = 1;; i5 = 0)
        {
          label445:
          int i6;
          if ((i4 == -1) || (i5 != 0))
          {
            i5 = axjs.a(i9, i1);
            if (i5 == -1)
            {
              i6 = 1;
              i5 = i4;
            }
          }
          for (i4 = i6;; i4 = 0)
          {
            if (i5 != -1)
            {
              if (i4 != 0) {
                if ((i9 > 65535) && (i8 >= i3 + 2))
                {
                  if (axkd.jdField_a_of_type_Boolean) {
                    paramStringBuilder.replace(i3, i3 + 2, "##");
                  }
                  i4 = 2;
                  label505:
                  if ((i1 <= 65535) || (i8 < i3 + 2)) {
                    break label648;
                  }
                  if (axkd.jdField_a_of_type_Boolean) {
                    paramStringBuilder.replace(i3 + 2, i3 + 4, "##");
                  }
                  i1 = i4 + 2;
                  label546:
                  if (n == 0) {
                    break label752;
                  }
                  n = i1 + 1;
                }
              }
              for (;;)
              {
                i1 = i3 + (n - 1);
                n = i2 + 1;
                break label100;
                if (i8 <= i3 + 1) {
                  break label787;
                }
                i1 = paramStringBuilder.codePointAt(i3 + 1);
                if ((i1 != 65039) || (i8 <= i3 + 2)) {
                  break label782;
                }
                i1 = paramStringBuilder.codePointAt(i3 + 2);
                n = 1;
                break label410;
                i4 = i5;
                break label445;
                if (axkd.jdField_a_of_type_Boolean) {
                  paramStringBuilder.replace(i3, i3 + 1, "#");
                }
                i4 = 1;
                break label505;
                label648:
                if (axkd.jdField_a_of_type_Boolean) {
                  paramStringBuilder.replace(i3 + 2, i3 + 3, "#");
                }
                i1 = i4 + 1;
                break label546;
                if ((i9 > 65535) && (i8 >= i3 + 2))
                {
                  if (axkd.jdField_a_of_type_Boolean) {
                    paramStringBuilder.replace(i3, i3 + 2, "##");
                  }
                  n = 2;
                }
                else
                {
                  if (axkd.jdField_a_of_type_Boolean) {
                    paramStringBuilder.replace(i3, i3 + 1, "#");
                  }
                  n = 1;
                  continue;
                  label741:
                  i3 = i1 + 1;
                  i2 = n;
                  break;
                  label752:
                  n = i1;
                }
              }
            }
            n = i2;
            i1 = i3;
            break label100;
            i5 = i4;
          }
        }
        label782:
        n = 0;
        continue;
        label787:
        n = 0;
        i1 = -1;
      }
    }
  }
  
  public static Pair<Long, Long> a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    Object localObject;
    if (paramMessageRecord.msgtype == -2058)
    {
      localObject = a(paramMessageRecord);
      if (localObject == null) {
        break label269;
      }
      if (paramMessageRecord.istroop == 0) {
        paramMessageRecord = new Pair(Long.valueOf(((EmojiStickerManager.StickerInfo)localObject).hostMsgSeq), Long.valueOf(((EmojiStickerManager.StickerInfo)localObject).hostMsgUid));
      }
    }
    for (;;)
    {
      return paramMessageRecord;
      paramMessageRecord = new Pair(Long.valueOf(((EmojiStickerManager.StickerInfo)localObject).hostMsgSeq), Long.valueOf(0L));
      continue;
      if (paramMessageRecord.msgtype == -2006)
      {
        if (paramMessageRecord.istroop == 0) {
          return new Pair(Long.valueOf(paramMessageRecord.shmsgseq), Long.valueOf(paramMessageRecord.msgUid));
        }
        return new Pair(Long.valueOf(paramMessageRecord.shmsgseq), Long.valueOf(0L));
      }
      if (b(paramMessageRecord))
      {
        if (paramMessageRecord.istroop == 0) {
          return new Pair(Long.valueOf(paramMessageRecord.shmsgseq), Long.valueOf(paramMessageRecord.msgUid));
        }
        return new Pair(Long.valueOf(paramMessageRecord.shmsgseq), Long.valueOf(0L));
      }
      if (!(paramMessageRecord instanceof MessageForUniteGrayTip)) {
        break;
      }
      localObject = (MessageForUniteGrayTip)paramMessageRecord;
      if ((((MessageForUniteGrayTip)localObject).tipParam == null) || (((MessageForUniteGrayTip)localObject).tipParam.jdField_b_of_type_Int != 1)) {
        break;
      }
      if (paramMessageRecord.istroop == 0) {
        return new Pair(Long.valueOf(paramMessageRecord.shmsgseq), Long.valueOf(paramMessageRecord.msgUid));
      }
      return new Pair(Long.valueOf(paramMessageRecord.shmsgseq), Long.valueOf(0L));
      label269:
      paramMessageRecord = null;
    }
  }
  
  public static axkd a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary)
  {
    if ((paramQQAppInterface == null) || (paramMessage == null)) {
      return null;
    }
    ajjy.a(2131638238);
    String str2 = "";
    Object localObject = paramMessage.getExtInfoFromExtStr("sticker_info");
    String str1 = str2;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = EmojiStickerManager.StickerInfo.transformFromJson((String)localObject);
      str1 = str2;
      if (localObject != null)
      {
        str2 = ((EmojiStickerManager.StickerInfo)localObject).msg;
        str1 = str2;
        if (jdField_e_of_type_Boolean)
        {
          if (!paramMessage.senderuin.equals(paramQQAppInterface.getCurrentAccountUin())) {
            break label125;
          }
          str1 = ajjy.a(2131638239) + str2;
        }
      }
    }
    for (paramMsgSummary.mEmojiFlag = 1;; paramMsgSummary.mEmojiFlag = 0)
    {
      return new axkd(str1, 3, 16);
      label125:
      str1 = ajjy.a(2131638242) + str2;
    }
  }
  
  public static axkd a(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {}
    do
    {
      do
      {
        return null;
        paramMessage = paramMessage.getExtInfoFromExtStr("sticker_info");
      } while (TextUtils.isEmpty(paramMessage));
      paramMessage = EmojiStickerManager.StickerInfo.transformFromJson(paramMessage);
    } while (paramMessage == null);
    return new axkd(paramMessage.msg, 3, 16);
  }
  
  public static CustomEmotionData a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (ancg)paramQQAppInterface.getManager(149);
    List localList = paramQQAppInterface.a();
    if (localList != null)
    {
      int m = 0;
      while (m < localList.size())
      {
        if ((paramString != null) && (paramString.equals(((CustomEmotionData)localList.get(m)).emoPath)))
        {
          paramString = (CustomEmotionData)localList.get(m);
          paramQQAppInterface.a(paramString, m);
          return paramString;
        }
        m += 1;
      }
    }
    return null;
  }
  
  public static EmojiStickerManager.StickerInfo a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.msgtype == -2058))
    {
      Object localObject;
      if ((paramMessageRecord instanceof MessageForMarketFace))
      {
        paramMessageRecord = (MessageForMarketFace)paramMessageRecord;
        if ((paramMessageRecord != null) && (paramMessageRecord.mMarkFaceMessage != null)) {
          localObject = paramMessageRecord.mMarkFaceMessage.stickerInfo;
        }
      }
      else
      {
        EmojiStickerManager.StickerInfo localStickerInfo;
        do
        {
          return localObject;
          if ((!(paramMessageRecord instanceof MessageForText)) && (!(paramMessageRecord instanceof MessageForPic))) {
            break;
          }
          localStickerInfo = paramMessageRecord.stickerInfo;
          localObject = localStickerInfo;
        } while (localStickerInfo != null);
        localObject = paramMessageRecord.getExtInfoFromExtStr("sticker_info");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = EmojiStickerManager.StickerInfo.transformFromJson((String)localObject);
          paramMessageRecord.stickerInfo = ((EmojiStickerManager.StickerInfo)localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  public static EmojiStickerManager a()
  {
    return jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager;
  }
  
  public static String a()
  {
    try
    {
      if (azzz.b()) {
        return ajed.aU + File.separator + ".emojiSticker_v2.1" + File.separator;
      }
      String str = BaseApplicationImpl.getApplication().getDir(".emojiSticker_v2.1", 0).getAbsoluteFile() + File.separator;
      return str;
    }
    catch (Exception localException) {}
    return BaseApplicationImpl.getApplication().getDir(".emojiSticker_v2.1", 0).getAbsoluteFile() + File.separator;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    String str;
    do
    {
      return null;
      str = paramQQAppInterface.c();
      if (paramInt == 0)
      {
        if (str.equals(paramString2)) {
          return ajjy.a(2131638245);
        }
        return ajjy.a(2131638244);
      }
      if (paramInt == 1)
      {
        if (str.equals(paramString2)) {
          return paramQQAppInterface.getCurrentNickname();
        }
        return babh.h(paramQQAppInterface, paramString1, paramString2);
      }
    } while (paramInt != 3000);
    if (str.equals(paramString2)) {
      return paramQQAppInterface.getCurrentNickname();
    }
    return babh.c(paramQQAppInterface, paramString1, paramString2);
  }
  
  public static void a()
  {
    ThreadManager.post(new EmojiStickerManager.2(), 5, null, false);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable, String paramString, PicMessageExtraData paramPicMessageExtraData, MessengerService paramMessengerService, Bundle paramBundle)
  {
    new anfr(paramBundle, paramMessengerService, paramURLDrawable, paramQQAppInterface, paramPicMessageExtraData).execute(new Void[0]);
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt, List<ChatMessage> paramList, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      if (paramInt <= 0) {
        break label54;
      }
      if (QLog.isColorLevel()) {
        QLog.i("EmojiStickerManager", 2, "has been pull more than once!");
      }
      paramInt = 0;
    }
    for (;;)
    {
      label54:
      Object localObject;
      if (paramInt != 0)
      {
        a(paramQQAppInterface, paramList, paramLong);
        return;
        localObject = (MessageRecord)paramList.get(paramList.size() - 1);
        if ((this.jdField_a_of_type_Int == 0) && (((MessageRecord)localObject).time > this.jdField_b_of_type_Long))
        {
          if (QLog.isColorLevel()) {
            QLog.i("EmojiStickerManager", 2, "new message coming! getLastRead: " + ((MessageRecord)localObject).time);
          }
          this.jdField_b_of_type_Int = 0;
          paramInt = 0;
          continue;
        }
        if (((MessageRecord)localObject).shmsgseq > this.jdField_b_of_type_Long)
        {
          if (QLog.isColorLevel()) {
            QLog.i("EmojiStickerManager", 2, "new message coming! getLastRead: " + ((MessageRecord)localObject).shmsgseq);
          }
          paramInt = 0;
        }
      }
      else
      {
        paramList = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext())
        {
          localObject = a((MessageRecord)paramList.next());
          if ((localObject != null) && (!((EmojiStickerManager.StickerInfo)localObject).isDisplayed)) {
            ((EmojiStickerManager.StickerInfo)localObject).isDisplayed = true;
          }
        }
        this.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_Long = paramQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
        return;
      }
      paramInt = 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    if ((paramQQAppInterface == null) || (paramStickerInfo == null)) {}
    do
    {
      return;
      try
      {
        if ((paramMessageRecord instanceof MessageForMarketFace))
        {
          MessageForMarketFace localMessageForMarketFace = (MessageForMarketFace)paramMessageRecord;
          if (localMessageForMarketFace.mMarkFaceMessage != null) {
            localMessageForMarketFace.mMarkFaceMessage.stickerInfo = paramStickerInfo;
          }
          localMessageForMarketFace.msgData = akhp.a(localMessageForMarketFace.mMarkFaceMessage);
          paramQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, paramMessageRecord.msgData);
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("EmojiStickerManager", 1, "save sticker shown status error e = " + paramQQAppInterface);
        return;
      }
    } while ((!(paramMessageRecord instanceof MessageForText)) && (!(paramMessageRecord instanceof MessageForPic)));
    paramMessageRecord.stickerInfo = paramStickerInfo;
    paramMessageRecord.saveExtInfoToExtStr("sticker_info", paramStickerInfo.toJsonString());
    paramQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extStr", paramMessageRecord.extStr);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = adww.a(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      paramQQAppInterface = (andn)paramQQAppInterface.getManager(141);
      VipComicFavorEmoStructMsgInfo localVipComicFavorEmoStructMsgInfo = new VipComicFavorEmoStructMsgInfo();
      localVipComicFavorEmoStructMsgInfo.picMd5 = paramCustomEmotionData.md5;
      localVipComicFavorEmoStructMsgInfo.actionData = paramStructMsgForImageShare;
      paramStructMsgForImageShare = new ArrayList();
      paramStructMsgForImageShare.add(localVipComicFavorEmoStructMsgInfo);
      paramQQAppInterface.a(paramStructMsgForImageShare, true);
      if (QLog.isColorLevel()) {
        QLog.d("EmojiStickerManager", 2, "handleComicStructMsg , emoStructMsgInfo = " + localVipComicFavorEmoStructMsgInfo);
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, long paramLong)
  {
    Object localObject1 = (MessageRecord)paramList.get(paramList.size() - 1);
    if (QLog.isColorLevel()) {
      QLog.i("EmojiStickerManager", 2, "insertStickerGrayTips4UnRead, mUnReadCount: " + this.jdField_b_of_type_Int + ", new sticker size: " + this.jdField_a_of_type_JavaUtilList.size());
    }
    MessageForUniteGrayTip localMessageForUniteGrayTip;
    Object localObject2;
    if (this.jdField_b_of_type_Int > 0)
    {
      localMessageForUniteGrayTip = new MessageForUniteGrayTip();
      localMessageForUniteGrayTip.isread = true;
      if (this.jdField_b_of_type_Int > 10) {
        break label395;
      }
      if ((this.jdField_a_of_type_Int != 1) || (paramLong == -9223372036854775808L)) {
        break label319;
      }
      localObject2 = String.format(ajjy.a(2131638237), new Object[] { Integer.valueOf(Math.min(this.jdField_a_of_type_JavaUtilList.size(), this.jdField_b_of_type_Int)) });
      localObject1 = new aqax(((MessageRecord)localObject1).frienduin, paramQQAppInterface.getCurrentAccountUin(), (String)localObject2, ((MessageRecord)localObject1).istroop, -5023, 1179651, ((MessageRecord)localObject1).time);
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_action", 20);
      localBundle.putString("key_action_DATA", String.valueOf(paramLong));
      ((aqax)localObject1).a(((String)localObject2).length() - 4, ((String)localObject2).length(), localBundle);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key", "NewTip");
      ((Bundle)localObject2).putInt("sessionType", this.jdField_a_of_type_Int);
      ((Bundle)localObject2).putString("ext2", "1");
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, (aqax)localObject1);
    }
    for (;;)
    {
      paramList.add(paramList.size(), localMessageForUniteGrayTip);
      return;
      label319:
      localObject2 = String.format(ajjy.a(2131638240), new Object[] { Integer.valueOf(Math.min(this.jdField_a_of_type_JavaUtilList.size(), this.jdField_b_of_type_Int)) });
      localObject1 = new aqax(((MessageRecord)localObject1).frienduin, paramQQAppInterface.getCurrentAccountUin(), (String)localObject2, ((MessageRecord)localObject1).istroop, -5023, 1179651, ((MessageRecord)localObject1).time);
      break;
      label395:
      if (this.jdField_b_of_type_Int > 10)
      {
        localObject2 = ajjy.a(2131638246);
        localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, new aqax(((MessageRecord)localObject1).frienduin, paramQQAppInterface.getCurrentAccountUin(), (String)localObject2, ((MessageRecord)localObject1).istroop, -5023, 1179651, ((MessageRecord)localObject1).time));
        paramQQAppInterface = new Bundle();
        paramQQAppInterface.putString("key", "NewTip");
        paramQQAppInterface.putInt("sessionType", this.jdField_a_of_type_Int);
        paramQQAppInterface.putString("ext2", "2");
        this.jdField_a_of_type_JavaUtilArrayList.add(paramQQAppInterface);
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    long l1;
    label42:
    label70:
    Pair localPair;
    Object localObject2;
    EmojiStickerManager.StickerInfo localStickerInfo;
    int m;
    label229:
    Object localObject3;
    if (paramList.size() > 0)
    {
      localObject1 = (ChatMessage)paramList.get(0);
      if (localObject1 == null) {
        break label449;
      }
      l1 = ((MessageRecord)localObject1).time;
      long l3 = paramQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      localObject1 = paramHashMap.keySet().iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localPair = (Pair)((Iterator)localObject1).next();
        localObject2 = (List)paramHashMap.get(localPair);
      } while ((localObject2 == null) || (((List)localObject2).size() == 0));
      localObject2 = (MessageRecord)((List)localObject2).get(0);
      localStickerInfo = a((MessageRecord)localObject2);
      if (QLog.isColorLevel()) {
        QLog.i("EmojiStickerManager", 2, "unFind msg: shmsgseq: " + localStickerInfo.hostMsgSeq + ", isDisplay: " + localStickerInfo.isDisplayed + ", hostTime: " + localStickerInfo.hostMsgTime);
      }
      if ((!this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.containsKey(localPair)) && (localStickerInfo.hostMsgTime <= l1)) {
        break label457;
      }
      m = 1;
      n = m;
      if (m != 0) {
        break label822;
      }
      localObject3 = paramQQAppInterface.a(this.jdField_a_of_type_Int).c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      n = m;
      if (localObject3 == null) {
        break label822;
      }
      n = m;
      if (((List)localObject3).size() <= 0) {
        break label822;
      }
      if (localStickerInfo.hostMsgTime >= ((MessageRecord)((List)localObject3).get(0)).time) {
        break label466;
      }
      if (localStickerInfo.hostMsgTime > l3) {
        break label463;
      }
      m = 1;
    }
    label319:
    Object localObject4;
    label449:
    label457:
    label463:
    for (;;)
    {
      if (m == 0) {
        break label827;
      }
      localObject3 = new MessageForUniteGrayTip();
      localObject4 = BaseApplicationImpl.getApplication().getString(2131653885);
      ((MessageForUniteGrayTip)localObject3).initGrayTipMsg(paramQQAppInterface, new aqax(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).senderuin, (String)localObject4, this.jdField_a_of_type_Int, -5040, 1, localStickerInfo.hostMsgTime));
      ((MessageForUniteGrayTip)localObject3).shmsgseq = ((Long)localPair.first).longValue();
      ((MessageForUniteGrayTip)localObject3).msgUid = ((Long)localPair.second).longValue();
      ((MessageForUniteGrayTip)localObject3).time = localStickerInfo.hostMsgTime;
      ((MessageForUniteGrayTip)localObject3).mNeedTimeStamp = false;
      localArrayList.add(localObject3);
      break label70;
      localObject1 = null;
      break;
      l1 = 9223372036854775807L;
      break label42;
      m = 0;
      break label229;
    }
    label466:
    int n = ((List)localObject3).size() - 1;
    label477:
    int i1;
    if (n >= 0)
    {
      localObject4 = (MessageRecord)((List)localObject3).get(n);
      if ((((MessageRecord)localObject4).shmsgseq == localStickerInfo.hostMsgSeq) && (((MessageRecord)localObject4).msgUid == localStickerInfo.hostMsgUid))
      {
        i1 = 1;
        m = 0;
      }
    }
    for (;;)
    {
      n = m;
      if (i1 == 0)
      {
        localObject3 = paramQQAppInterface.a().b(this.jdField_a_of_type_JavaLangString);
        if (localObject3 == null) {}
        for (long l2 = 0L;; l2 = ((Long)((Pair)localObject3).first).longValue())
        {
          if ((localStickerInfo.hostMsgTime <= l2) && (l2 != 0L)) {
            break label609;
          }
          m = 1;
          break;
          n -= 1;
          break label477;
        }
        label609:
        n = m;
        if (this.jdField_a_of_type_Long - localStickerInfo.hostMsgTime > 86400L)
        {
          m = 1;
          break label319;
          if (localArrayList.size() > 0)
          {
            paramQQAppInterface = new Bundle();
            paramQQAppInterface.putString("key", "DeleteHide");
            paramQQAppInterface.putInt("sessionType", this.jdField_a_of_type_Int);
            this.jdField_a_of_type_JavaUtilArrayList.add(paramQQAppInterface);
          }
          paramQQAppInterface = localArrayList.iterator();
          if (paramQQAppInterface.hasNext())
          {
            paramHashMap = (MessageForUniteGrayTip)paramQQAppInterface.next();
            localObject1 = paramList.iterator();
            m = 0;
            for (;;)
            {
              if ((!((Iterator)localObject1).hasNext()) || (((MessageRecord)((Iterator)localObject1).next()).time > paramHashMap.time))
              {
                if (QLog.isColorLevel()) {
                  QLog.i("EmojiStickerManager", 2, "insert unfounded gray tips:  host seq: " + paramHashMap.shmsgseq + ", list pos: " + m);
                }
                paramList.add(m, paramHashMap);
                break;
              }
              m += 1;
            }
          }
          return;
        }
      }
      label822:
      m = n;
      break label319;
      label827:
      break;
      i1 = 0;
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    Object localObject;
    if (paramMessageRecord.istroop != 0)
    {
      localObject = a(paramMessageRecord);
      if (localObject != null)
      {
        localObject = new Pair(Long.valueOf(((EmojiStickerManager.StickerInfo)localObject).hostMsgSeq), Long.valueOf(0L));
        if (!a().jdField_b_of_type_ComTencentUtilLRULinkedHashMap.containsKey(localObject)) {
          break label345;
        }
      }
    }
    label345:
    for (int m = 1;; m = 0)
    {
      int n;
      if (m == 0)
      {
        List localList = paramQQAppInterface.a(paramMessageRecord.istroop).b(paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if ((localList != null) && (localList.size() > 0))
        {
          n = localList.size() - 1;
          if (n >= 0)
          {
            paramQQAppInterface = (MessageRecord)localList.get(n);
            if ((paramQQAppInterface.shmsgseq != ((Long)((Pair)localObject).first).longValue()) || (!b(paramQQAppInterface))) {}
          }
        }
      }
      for (;;)
      {
        if (((m != 0) || ((paramQQAppInterface != null) && (paramQQAppInterface.msgtype == -2006))) && (paramQQAppInterface != null)) {
          a().jdField_b_of_type_ComTencentUtilLRULinkedHashMap.put(localObject, Boolean.valueOf(true));
        }
        for (;;)
        {
          a().b(paramMessageRecord);
          return;
          n -= 1;
          break;
          paramQQAppInterface = a(paramMessageRecord);
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface.hostMsgSeq = ((short)(int)paramQQAppInterface.hostMsgSeq);
            if ((paramMessageRecord instanceof MessageForMarketFace))
            {
              localObject = (MessageForMarketFace)paramMessageRecord;
              if (((MessageForMarketFace)localObject).mMarkFaceMessage != null) {
                ((MessageForMarketFace)localObject).mMarkFaceMessage.stickerInfo = paramQQAppInterface;
              }
              try
              {
                ((MessageForMarketFace)localObject).msgData = akhp.a(((MessageForMarketFace)localObject).mMarkFaceMessage);
              }
              catch (Exception paramQQAppInterface)
              {
                paramQQAppInterface.printStackTrace();
              }
            }
            else if ((paramMessageRecord instanceof MessageForText))
            {
              localObject = (MessageForText)paramMessageRecord;
              ((MessageForText)localObject).stickerInfo = paramQQAppInterface;
              ((MessageForText)localObject).saveExtInfoToExtStr("sticker_info", paramQQAppInterface.toJsonString());
            }
            else if ((paramMessageRecord instanceof MessageForPic))
            {
              localObject = (MessageForPic)paramMessageRecord;
              ((MessageForPic)localObject).stickerInfo = paramQQAppInterface;
              ((MessageForPic)localObject).saveExtInfoToExtStr("sticker_info", paramQQAppInterface.toJsonString());
            }
          }
        }
        paramQQAppInterface = null;
      }
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    if ((paramMessageRecord == null) || (!a(paramMessageRecord))) {
      return;
    }
    for (;;)
    {
      int m;
      try
      {
        m = paramMessageRecord.msgtype;
        if (paramStickerInfo == null) {
          break label209;
        }
        paramStickerInfo.originMsgType = paramMessageRecord.msgtype;
      }
      catch (Exception paramMessageRecord) {}
      paramMessageRecord.extLong |= 0x4;
      paramStickerInfo = new JSONObject();
      paramStickerInfo.put("msgType", m);
      paramMessageRecord.saveExtInfoToExtStr("Emoji_Sticker_Info", paramStickerInfo.toString());
      if (!jdField_e_of_type_Boolean) {
        break;
      }
      paramMessageRecord.msgtype = -2058;
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("EmojiStickerManager", 2, "", paramMessageRecord);
      return;
      Object localObject = (MessageForMarketFace)paramMessageRecord;
      if (((MessageForMarketFace)localObject).mMarkFaceMessage != null) {
        ((MessageForMarketFace)localObject).mMarkFaceMessage.stickerInfo = paramStickerInfo;
      }
      ((MessageForMarketFace)localObject).msgData = akhp.a(((MessageForMarketFace)localObject).mMarkFaceMessage);
      continue;
      paramStickerInfo = paramMessageRecord.getExtInfoFromExtStr("sticker_info");
      if (!TextUtils.isEmpty(paramStickerInfo))
      {
        localObject = EmojiStickerManager.StickerInfo.transformFromJson(paramStickerInfo);
        if (localObject != null)
        {
          ((EmojiStickerManager.StickerInfo)localObject).originMsgType = m;
          if (m == -1000) {}
          for (paramStickerInfo = paramMessageRecord.msg;; paramStickerInfo = ajjy.a(2131638243))
          {
            ((EmojiStickerManager.StickerInfo)localObject).msg = paramStickerInfo;
            paramMessageRecord.stickerInfo = ((EmojiStickerManager.StickerInfo)localObject);
            paramMessageRecord.saveExtInfoToExtStr("sticker_info", ((EmojiStickerManager.StickerInfo)localObject).toJsonString());
            break;
          }
          label209:
          switch (m)
          {
          }
        }
      }
    }
  }
  
  private void a(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((MessageRecord)paramList.next()).stickerHidden = false;
      }
    }
  }
  
  private void a(List<ChatMessage> paramList, QQAppInterface paramQQAppInterface, HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap)
  {
    if (this.jdField_a_of_type_Int != 0) {
      b(paramQQAppInterface, paramList, paramHashMap);
    }
    for (;;)
    {
      if (paramList.size() == 0) {
        c(paramQQAppInterface, paramList, paramHashMap);
      }
      return;
      a(paramQQAppInterface, paramList, paramHashMap);
    }
  }
  
  public static boolean a()
  {
    Integer[] arrayOfInteger = WebAccelerateHelper.getInstance().getWebViewFeatureParams();
    if ((arrayOfInteger != null) && (arrayOfInteger[11].intValue() != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmojiStickerManager", 2, "now enable Emoji Sticker!");
      }
      return true;
    }
    QLog.e("EmojiStickerManager", 1, "can not use emoji Sticker!");
    return false;
  }
  
  private static boolean a(MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    boolean bool = true;
    QQWalletTransferMsgElem localQQWalletTransferMsgElem = null;
    if (paramMessageForQQWalletMsg == null) {
      break label25;
    }
    label25:
    do
    {
      do
      {
        return false;
        if (paramMessageForQQWalletMsg.mQQWalletTransferMsg == null) {
          break;
        }
        localQQWalletTransferMsgElem = paramMessageForQQWalletMsg.mQQWalletTransferMsg.elem;
      } while (localQQWalletTransferMsgElem == null);
      paramMessageForQQWalletMsg = localQQWalletTransferMsgElem.nativeAndroid;
    } while (TextUtils.isEmpty(paramMessageForQQWalletMsg));
    paramMessageForQQWalletMsg = paramMessageForQQWalletMsg.split("\\?");
    if ((!TextUtils.isEmpty(paramMessageForQQWalletMsg[0])) && (paramMessageForQQWalletMsg[0].equals("red"))) {}
    for (;;)
    {
      return bool;
      if (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg == null) {
        break;
      }
      return true;
      bool = false;
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForMarketFace)) || (((paramMessageRecord instanceof MessageForText)) && (paramMessageRecord.msgtype == -1000)) || ((paramMessageRecord instanceof MessageForPic));
  }
  
  private static int b(QQAppInterface paramQQAppInterface, String paramString, StructMsgForImageShare paramStructMsgForImageShare, PicMessageExtraData paramPicMessageExtraData)
  {
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    ancg localancg = (ancg)paramQQAppInterface.getManager(149);
    Object localObject = localancg.a();
    int m;
    if (localObject != null)
    {
      m = 1;
      int i2 = 0;
      int n = 0;
      while (n < ((List)localObject).size())
      {
        int i1;
        if (!TextUtils.isEmpty(((CustomEmotionData)((List)localObject).get(n)).RomaingType))
        {
          i1 = i2;
          if ("needDel".equals(((CustomEmotionData)((List)localObject).get(n)).RomaingType)) {}
        }
        else
        {
          i1 = i2 + 1;
        }
        i2 = ((CustomEmotionData)((List)localObject).get(n)).emoId;
        if ((paramString != null) && (paramString.equals(((CustomEmotionData)((List)localObject).get(n)).emoPath)))
        {
          b(paramQQAppInterface, paramStructMsgForImageShare, (CustomEmotionData)((List)localObject).get(n));
          return 2;
        }
        if ((str != null) && (((CustomEmotionData)((List)localObject).get(n)).md5 != null) && (str.equals(((CustomEmotionData)((List)localObject).get(n)).md5)))
        {
          b(paramQQAppInterface, paramStructMsgForImageShare, (CustomEmotionData)((List)localObject).get(n));
          if ("needDel".equals(((CustomEmotionData)((List)localObject).get(n)).RomaingType))
          {
            localancg.a((CustomEmotionData)((List)localObject).get(n), n);
            paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.obtainMessage(10).sendToTarget();
            }
            return 0;
          }
          return 2;
        }
        int i3 = m;
        if (m < i2) {
          i3 = i2;
        }
        n += 1;
        i2 = i1;
        m = i3;
      }
      if (i2 >= ance.jdField_a_of_type_Int) {
        return 3;
      }
    }
    else
    {
      m = 1;
    }
    localObject = new CustomEmotionData();
    ((CustomEmotionData)localObject).uin = paramQQAppInterface.getCurrentAccountUin();
    ((CustomEmotionData)localObject).emoId = (m + 1);
    ((CustomEmotionData)localObject).emoPath = paramString;
    ((CustomEmotionData)localObject).md5 = str;
    if ((paramPicMessageExtraData != null) && (paramPicMessageExtraData.isDiyDouTu())) {
      ((CustomEmotionData)localObject).eId = paramPicMessageExtraData.emojiPkgId;
    }
    localancg.c((CustomEmotionBase)localObject);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(ajed.bL))) {
      awqx.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
    }
    a(paramQQAppInterface, paramStructMsgForImageShare, (CustomEmotionData)localObject);
    paramQQAppInterface = (anch)paramQQAppInterface.getManager(103);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.d((CustomEmotionData)localObject);
    }
    return 0;
  }
  
  private void b(Messenger paramMessenger, boolean paramBoolean)
  {
    if (paramMessenger != null) {}
    for (;;)
    {
      try
      {
        Message localMessage = Message.obtain(null, 4);
        if (paramMessenger != null)
        {
          Bundle localBundle1 = new Bundle();
          localBundle1.putString("cmd", "emojiStickerRecall");
          localBundle1.putString("callbackid", jdField_b_of_type_JavaLangString);
          localBundle1.putInt("respkey", l);
          Bundle localBundle2 = new Bundle();
          if (!paramBoolean) {
            continue;
          }
          m = 0;
          localBundle2.putInt("result", m);
          AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
          if ((localAppRuntime instanceof QQAppInterface)) {
            localBundle2.putString("QQ", ((QQAppInterface)localAppRuntime).c());
          }
          m = -1;
          if (this.jdField_a_of_type_Int != 0) {
            continue;
          }
          m = 1;
          localBundle2.putInt("chatType", m);
          localBundle1.putBundle("response", localBundle2);
          localMessage.setData(localBundle1);
          paramMessenger.send(localMessage);
        }
      }
      catch (RemoteException paramMessenger)
      {
        int m;
        int n;
        QLog.e("EmojiStickerManager", 1, "sendEmojiStickerRecallResponse e =" + paramMessenger);
        continue;
      }
      jdField_h_of_type_Boolean = false;
      return;
      m = -2;
      continue;
      if (this.jdField_a_of_type_Int == 1)
      {
        m = 2;
      }
      else
      {
        n = this.jdField_a_of_type_Int;
        if (n == 3000) {
          m = 3;
        }
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = adww.a(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      paramQQAppInterface = (andn)paramQQAppInterface.getManager(141);
      VipComicFavorEmoStructMsgInfo localVipComicFavorEmoStructMsgInfo = new VipComicFavorEmoStructMsgInfo();
      localVipComicFavorEmoStructMsgInfo.picMd5 = paramCustomEmotionData.md5;
      localVipComicFavorEmoStructMsgInfo.actionData = paramStructMsgForImageShare;
      if (!localVipComicFavorEmoStructMsgInfo.equals(paramQQAppInterface.a(paramCustomEmotionData.md5)))
      {
        paramStructMsgForImageShare = new ArrayList();
        paramStructMsgForImageShare.add(localVipComicFavorEmoStructMsgInfo);
        paramQQAppInterface.a(paramStructMsgForImageShare, true);
        if (QLog.isColorLevel()) {
          QLog.d("EmojiStickerManager", 2, "handleOldComicStructMsg , emoStructMsgInfo = " + localVipComicFavorEmoStructMsgInfo);
        }
      }
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap)
  {
    Object localObject2 = new ArrayList();
    Object localObject1;
    long l1;
    label42:
    label70:
    Pair localPair1;
    Object localObject3;
    Object localObject4;
    label235:
    int m;
    Object localObject5;
    if (paramList.size() > 0)
    {
      localObject1 = (ChatMessage)paramList.get(0);
      if (localObject1 == null) {
        break label449;
      }
      l1 = ((MessageRecord)localObject1).shmsgseq;
      long l2 = paramQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      localObject1 = paramHashMap.keySet().iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localPair1 = (Pair)((Iterator)localObject1).next();
        localObject3 = (List)paramHashMap.get(localPair1);
      } while ((localObject3 == null) || (((List)localObject3).size() == 0));
      localObject3 = (MessageRecord)((List)localObject3).get(0);
      localObject4 = a((MessageRecord)localObject3);
      if (QLog.isColorLevel()) {
        QLog.i("EmojiStickerManager", 2, "unFind msg: shmsgseq: " + ((EmojiStickerManager.StickerInfo)localObject4).hostMsgSeq + ", isDisplay: " + ((EmojiStickerManager.StickerInfo)localObject4).isDisplayed + ", hostTime: " + ((EmojiStickerManager.StickerInfo)localObject4).hostMsgTime);
      }
      if ((!this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.containsKey(localPair1)) && (((Long)localPair1.first).longValue() <= l1)) {
        break label457;
      }
      n = 1;
      m = n;
      if (n == 0)
      {
        localObject5 = paramQQAppInterface.a(this.jdField_a_of_type_Int).c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
        m = n;
        if (localObject5 != null)
        {
          m = n;
          if (((List)localObject5).size() > 0)
          {
            if (((EmojiStickerManager.StickerInfo)localObject4).hostMsgSeq >= ((MessageRecord)((List)localObject5).get(0)).shmsgseq) {
              break label463;
            }
            m = n;
            if (((EmojiStickerManager.StickerInfo)localObject4).hostMsgSeq <= l2) {
              m = 1;
            }
          }
        }
      }
    }
    label329:
    label463:
    label472:
    MessageRecord localMessageRecord;
    for (;;)
    {
      if (m != 0)
      {
        localObject4 = new MessageForUniteGrayTip();
        localObject5 = BaseApplicationImpl.getApplication().getString(2131653885);
        ((MessageForUniteGrayTip)localObject4).initGrayTipMsg(paramQQAppInterface, new aqax(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).senderuin, (String)localObject5, this.jdField_a_of_type_Int, -5040, 1, ((MessageRecord)localObject3).time));
        ((MessageForUniteGrayTip)localObject4).shmsgseq = ((Long)localPair1.first).longValue();
        ((MessageForUniteGrayTip)localObject4).msgUid = ((Long)localPair1.second).longValue();
        ((MessageForUniteGrayTip)localObject4).mNeedTimeStamp = false;
        ((List)localObject2).add(localObject4);
        break label70;
        localObject1 = null;
        break;
        label449:
        l1 = 9223372036854775807L;
        break label42;
        label457:
        n = 0;
        break label235;
        localObject5 = ((List)localObject5).iterator();
        m = n;
        if (((Iterator)localObject5).hasNext())
        {
          localMessageRecord = (MessageRecord)((Iterator)localObject5).next();
          m = n;
          if (localMessageRecord.shmsgseq < l1)
          {
            if (localMessageRecord.msgtype == -2006)
            {
              Pair localPair2 = a(localMessageRecord);
              if (localPair2 != null) {
                this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.put(localPair2, Boolean.valueOf(true));
              }
            }
            m = n;
            if (localMessageRecord.shmsgseq == ((EmojiStickerManager.StickerInfo)localObject4).hostMsgSeq)
            {
              m = n;
              if (!akbm.a(localMessageRecord)) {
                if (localMessageRecord.msgtype != -2006) {
                  break label634;
                }
              }
            }
          }
        }
      }
    }
    label634:
    for (int n = 1;; n = 0)
    {
      m = n;
      if (n == 0) {
        break label329;
      }
      m = n;
      n = m;
      if (m == 0) {
        break label472;
      }
      n = m;
      if (!b(localMessageRecord)) {
        break label472;
      }
      m = 0;
      break label329;
      break;
    }
    if (((List)localObject2).size() > 0)
    {
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putString("key", "DeleteHide");
      paramQQAppInterface.putInt("sessionType", this.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramQQAppInterface);
    }
    paramQQAppInterface = ((List)localObject2).iterator();
    if (paramQQAppInterface.hasNext())
    {
      paramHashMap = (MessageForUniteGrayTip)paramQQAppInterface.next();
      localObject1 = paramList.iterator();
      m = 0;
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          if (((MessageRecord)localObject2).shmsgseq > paramHashMap.shmsgseq) {
            paramHashMap.time = (((MessageRecord)localObject2).time - 10L);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("EmojiStickerManager", 2, "insert unfind gray tips:  host seq: " + paramHashMap.shmsgseq + ", list pos: " + m);
          }
          paramList.add(m, paramHashMap);
          break;
        }
        m += 1;
      }
    }
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    int i1 = paramMessageRecord.msgtype;
    int m;
    if (((paramMessageRecord instanceof MessageForApollo)) && (ApolloGameUtil.a(((MessageForApollo)paramMessageRecord).msgType)))
    {
      m = 1;
      if ((!(paramMessageRecord instanceof MessageForQQWalletMsg)) || (!a((MessageForQQWalletMsg)paramMessageRecord))) {
        break label146;
      }
    }
    label146:
    for (int n = 1;; n = 0)
    {
      boolean bool1;
      if ((i1 != -1000) && (i1 != -2011) && (i1 != -2039) && ((i1 != -2025) || (n == 0)) && (i1 != -2007) && (i1 != -2000) && (i1 != -2002) && (i1 != -2022) && (i1 != -1035))
      {
        bool1 = bool2;
        if (i1 != -1049) {}
      }
      else
      {
        bool1 = bool2;
        if (m == 0) {
          bool1 = true;
        }
      }
      return bool1;
      m = 0;
      break;
    }
  }
  
  private void c(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    int m = 0;
    int n;
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      Iterator localIterator1 = paramHashMap.keySet().iterator();
      n = 0;
      MessageRecord localMessageRecord = null;
      localObject1 = localObject3;
      while (localIterator1.hasNext())
      {
        localObject3 = (List)paramHashMap.get((Pair)localIterator1.next());
        if ((localObject3 != null) && (((List)localObject3).size() != 0))
        {
          int i1 = ((List)localObject3).size();
          if (localMessageRecord != null) {
            break label592;
          }
          localMessageRecord = (MessageRecord)((List)localObject3).get(0);
          Iterator localIterator2 = ((List)localObject3).iterator();
          if (localIterator2.hasNext())
          {
            localObject3 = (ChatMessage)localIterator2.next();
            if ((localObject1 == null) && (!((ChatMessage)localObject3).senderuin.equals(localObject1)))
            {
              localObject3 = ((ChatMessage)localObject3).senderuin;
              localObject1 = localObject2;
              localObject2 = localObject3;
            }
            for (;;)
            {
              label179:
              localObject3 = localObject2;
              localObject2 = localObject1;
              localObject1 = localObject3;
              break;
              if ((localObject2 == null) && (!((ChatMessage)localObject3).senderuin.equals(localObject1)))
              {
                localObject3 = ((ChatMessage)localObject3).senderuin;
                localObject2 = localObject1;
                localObject1 = localObject3;
              }
              else
              {
                if ((localObject1 == null) || (localObject2 == null)) {
                  break label595;
                }
                m = 1;
                localObject3 = localObject1;
                localObject1 = localObject2;
                localObject2 = localObject3;
              }
            }
          }
          n = i1 + n;
        }
      }
      paramHashMap = (HashMap<Pair<Long, Long>, List<ChatMessage>>)localObject2;
      localObject2 = localMessageRecord;
    }
    for (;;)
    {
      if ((n > 0) && (localObject2 != null))
      {
        localObject1 = a(paramQQAppInterface, ((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, (String)localObject1);
        paramHashMap = a(paramQQAppInterface, ((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, paramHashMap);
        if ((n != 1) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(paramHashMap))) {
          break label523;
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label513;
        }
        paramHashMap = (HashMap<Pair<Long, Long>, List<ChatMessage>>)localObject1;
      }
      for (;;)
      {
        paramHashMap = String.format("%s在上面贴了%d个表情", new Object[] { paramHashMap, Integer.valueOf(n) });
        localObject2 = new aqax(((MessageRecord)localObject2).frienduin, paramQQAppInterface.getCurrentAccountUin(), paramHashMap, ((MessageRecord)localObject2).istroop, -5023, 1179651, ((MessageRecord)localObject2).time);
        localObject1 = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQAppInterface, (aqax)localObject2);
        if (QLog.isColorLevel()) {
          QLog.i("EmojiStickerManager", 2, "insert gray tips for sticker msg! " + paramHashMap);
        }
        ((MessageForUniteGrayTip)localObject1).isread = true;
        paramQQAppInterface = new Bundle();
        paramQQAppInterface.putString("key", "NotGetTip");
        paramQQAppInterface.putInt("sessionType", this.jdField_a_of_type_Int);
        this.jdField_a_of_type_JavaUtilArrayList.add(paramQQAppInterface);
        paramList.add(localObject1);
        return;
        label513:
        if (!TextUtils.isEmpty(paramHashMap))
        {
          continue;
          label523:
          localObject1 = (String)localObject1 + "、" + paramHashMap;
          paramHashMap = (HashMap<Pair<Long, Long>, List<ChatMessage>>)localObject1;
          if (m != 0) {
            paramHashMap = (String)localObject1 + ajjy.a(2131638241);
          }
        }
        else
        {
          paramHashMap = "";
        }
      }
      label592:
      break;
      label595:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break label179;
      localObject2 = null;
      n = 0;
      paramHashMap = null;
      m = 0;
    }
  }
  
  public static boolean c(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForMarketFace)) || ((paramMessageRecord instanceof MessageForText)) || ((paramMessageRecord instanceof MessageForPic));
  }
  
  public static boolean d(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord != null) && ((paramMessageRecord.istroop == 0) || (paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 3000));
  }
  
  public Drawable a(Context paramContext)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      return paramContext.getResources().getDrawable(2130839349);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public anht a(String paramString)
  {
    int i4 = 0;
    int i5;
    int i7;
    int i1;
    Object localObject;
    int m;
    boolean bool1;
    label198:
    Emoticon localEmoticon;
    if (!TextUtils.isEmpty(paramString))
    {
      int i6 = paramString.length();
      i5 = paramString.length();
      paramString = new StringBuilder().append(paramString);
      n = 0;
      if (n < i6)
      {
        i7 = paramString.codePointAt(n);
        if ((i7 == 20) && (n < i5 - 1))
        {
          i1 = paramString.charAt(n + 1);
          if ((i1 >= 255) && (n + 4 < i5))
          {
            localObject = new char[4];
            localObject[0] = paramString.charAt(n + 4);
            localObject[1] = paramString.charAt(n + 3);
            localObject[2] = paramString.charAt(n + 2);
            localObject[3] = paramString.charAt(n + 1);
            m = 0;
            if (m < 3)
            {
              if (localObject[m] == 'ú') {
                localObject[m] = 10;
              }
              for (;;)
              {
                m += 1;
                break;
                if (localObject[m] == 'þ') {
                  localObject[m] = 13;
                }
              }
            }
            if (i1 == 511)
            {
              bool1 = true;
              paramString = new anlr(BaseApplicationImpl.getApplication().getRuntime().getAccount());
              localEmoticon = new Emoticon();
              localObject = anam.a((char[])localObject);
              if ((localObject == null) || (localObject.length != 2)) {
                break label565;
              }
              m = localObject[0];
            }
          }
        }
      }
    }
    for (int n = localObject[1];; n = i4)
    {
      localEmoticon.eId = String.valueOf(n);
      localEmoticon.epId = String.valueOf(m);
      localEmoticon.jobType = 3;
      paramString.a = localEmoticon;
      boolean bool2 = bool1;
      if (!bool1)
      {
        localObject = anjd.a();
        bool2 = bool1;
        if (localObject != null)
        {
          localObject = ((arnz)localObject).a(String.valueOf(m));
          bool2 = bool1;
          if (localObject != null)
          {
            bool2 = bool1;
            if (((EmoticonPackage)localObject).isAPNG == 2) {
              bool2 = true;
            }
          }
        }
      }
      paramString.b = bool2;
      return paramString;
      bool1 = false;
      break label198;
      if (i1 == 250) {
        return new anmf(7, 1, 10, "", false);
      }
      return new anmf(7, 1, i1, "", false);
      i1 = axjs.a(i7);
      if (i7 > 65535)
      {
        if (i5 <= n + 2) {
          break label560;
        }
        m = paramString.codePointAt(n + 2);
      }
      for (;;)
      {
        label426:
        if (axjs.a(m)) {}
        for (int i2 = 1;; i2 = 0)
        {
          int i3;
          if (i1 != -1)
          {
            i3 = i1;
            if (i2 == 0) {}
          }
          else
          {
            i2 = axjs.a(i7, m);
            m = i2;
            if (i2 == -1) {
              m = i1;
            }
            i3 = m;
          }
          if (i3 != -1)
          {
            return new anmf(7, 2, i3, "", false);
            if (i5 <= n + 1) {
              break label560;
            }
            i2 = paramString.codePointAt(n + 1);
            m = i2;
            if (i2 != 65039) {
              break label426;
            }
            m = i2;
            if (i5 <= n + 2) {
              break label426;
            }
            m = paramString.codePointAt(n + 2);
            break label426;
          }
          n += 1;
          break;
          return null;
        }
        label560:
        m = -1;
      }
      label565:
      m = 0;
    }
  }
  
  public URLDrawable a(Context paramContext, Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return null;
    }
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    try
    {
      paramContext = new URL("emotion_pic", "fromAIO", paramEmoticon.epId + "_" + paramEmoticon.eId);
      if (paramContext == null)
      {
        QLog.e("EmojiStickerManager", 1, "getStickerDrawable url = null");
        return null;
      }
    }
    catch (MalformedURLException paramContext)
    {
      for (;;)
      {
        QLog.e("EmojiStickerManager", 1, "getStickerDrawable url exception e = " + paramContext.getMessage());
        paramContext = null;
      }
    }
    return URLDrawable.getDrawable(paramContext, (int)(110.0F * f1), (int)(f1 * 110.0F), this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, true);
  }
  
  public List<Long> a(MessageRecord paramMessageRecord)
  {
    if ((!jdField_e_of_type_Boolean) || (paramMessageRecord == null) || (paramMessageRecord.shmsgseq == 0L) || (paramMessageRecord.extraflag == 32772) || (paramMessageRecord.extraflag == 32768) || (paramMessageRecord.isMultiMsg) || (paramMessageRecord.isReMultiMsg)) {}
    do
    {
      return null;
      paramMessageRecord = a(paramMessageRecord);
    } while (paramMessageRecord == null);
    return (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramMessageRecord);
  }
  
  public void a(Messenger paramMessenger, boolean paramBoolean)
  {
    if (jdField_h_of_type_Boolean) {
      b(paramMessenger, paramBoolean);
    }
  }
  
  public void a(View paramView)
  {
    jdField_a_of_type_AndroidViewView = (ViewGroup)paramView.getParent();
    if ((jdField_a_of_type_AndroidViewView instanceof BaseChatItemLayout))
    {
      paramView = (BaseChatItemLayout)jdField_a_of_type_AndroidViewView;
      if (paramView.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = paramView.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          anfs localanfs = (anfs)localIterator.next();
          if (localanfs.f == 255) {
            localanfs.f = 127;
          }
        }
        paramView.invalidate();
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaLangString = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Int = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Long = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    this.jdField_c_of_type_Long = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.i("EmojiStickerManager", 2, "init, unReadCnt: " + this.jdField_b_of_type_Int + ", mInitLastReadSeq: " + this.jdField_a_of_type_Long);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, String paramString, int paramInt, boolean paramBoolean)
  {
    paramBaseChatPie.aY();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    jdField_h_of_type_Boolean = false;
    jdField_b_of_type_JavaLangString = "";
    l = -1;
    jdField_a_of_type_AndroidViewView = null;
    List localList = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).e(paramString, paramInt);
    ThreadManager.post(new EmojiStickerManager.1(this, localList, paramString, paramInt, paramBoolean), 5, null, false);
    if (paramBaseChatPie.jdField_c_of_type_AndroidViewViewGroup != null)
    {
      paramString = (TopGestureLayout)paramBaseChatPie.jdField_c_of_type_AndroidViewViewGroup;
      GestureDetector localGestureDetector = paramString.getGestureDetector();
      if ((localGestureDetector instanceof anly))
      {
        paramString.removeView(((anly)localGestureDetector).a);
        jdField_a_of_type_Boolean = false;
        paramBaseChatPie.p(false);
        paramBaseChatPie.p(false);
      }
      paramString.restoreGestureDetector();
    }
    a(localList);
    this.jdField_a_of_type_Long = -9223372036854775808L;
    this.jdField_b_of_type_Long = -9223372036854775808L;
    this.jdField_c_of_type_Long = -9223372036854775808L;
  }
  
  public void a(BaseChatPie paramBaseChatPie, List<ChatMessage> paramList)
  {
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_c_of_type_Int, paramList);
  }
  
  public void a(QQAppInterface paramQQAppInterface, ChatXListView paramChatXListView, String paramString, int paramInt1, int paramInt2, List<ChatMessage> paramList)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    if ((paramList == null) || (paramList.size() == 0) || (paramChatXListView == null)) {
      return;
    }
    long l9 = System.currentTimeMillis();
    int m = 0;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
    paramString = null;
    long l1 = -9223372036854775808L;
    long l2 = -9223372036854775808L;
    long l5 = -9223372036854775808L;
    long l6 = -9223372036854775808L;
    paramInt1 = 0;
    int n = paramList.size() - 1;
    ChatMessage localChatMessage;
    long l4;
    long l3;
    label131:
    label193:
    Object localObject;
    label301:
    long l8;
    long l7;
    if (n >= 0)
    {
      localChatMessage = (ChatMessage)paramList.get(n);
      if (localChatMessage == null)
      {
        l4 = l1;
        l3 = l2;
        l2 = l5;
        l1 = l6;
      }
      for (;;)
      {
        n -= 1;
        l6 = l1;
        l1 = l4;
        l5 = l2;
        l2 = l3;
        break;
        int i1;
        if (!localChatMessage.isread)
        {
          if ((this.jdField_a_of_type_Int == 0) && (localChatMessage.time > this.jdField_b_of_type_Long)) {
            this.jdField_b_of_type_Long = localChatMessage.time;
          }
        }
        else
        {
          if ((localChatMessage.msgtype != -2058) || (!d(localChatMessage))) {
            break label1107;
          }
          l4 = l6;
          l3 = l5;
          if (l5 == -9223372036854775808L)
          {
            l4 = l6;
            l3 = l5;
            if (l6 == -9223372036854775808L)
            {
              l4 = l6;
              l3 = l5;
              if (paramChatXListView.getAdapter() != null)
              {
                localObject = null;
                if (paramChatXListView.getChildCount() > 0)
                {
                  i1 = paramChatXListView.getFirstVisiblePosition() - paramChatXListView.getHeaderViewsCount();
                  if ((i1 < 0) || (i1 >= paramChatXListView.getAdapter().getCount())) {
                    break label431;
                  }
                  localObject = paramChatXListView.getAdapter().getItem(i1);
                }
                if (!(localObject instanceof MessageRecord)) {
                  break label437;
                }
              }
            }
          }
        }
        label431:
        label437:
        for (localObject = (MessageRecord)localObject;; localObject = (MessageRecord)paramList.get(0))
        {
          l3 = ((MessageRecord)localObject).shmsgseq;
          l4 = ((MessageRecord)localObject).time;
          localObject = a(localChatMessage);
          if (localObject != null) {
            break label453;
          }
          l8 = l4;
          l7 = l3;
          if (!QLog.isColorLevel()) {
            break label1299;
          }
          QLog.i("EmojiStickerManager", 2, "sticker info is null! WTF!");
          l5 = l2;
          l2 = l4;
          l4 = l1;
          l1 = l2;
          l2 = l3;
          l3 = l5;
          break;
          if (localChatMessage.shmsgseq <= this.jdField_b_of_type_Long) {
            break label193;
          }
          this.jdField_b_of_type_Long = localChatMessage.shmsgseq;
          break label193;
          i1 = 0;
          break label301;
        }
        label453:
        if (jdField_e_of_type_Boolean) {
          break label496;
        }
        localChatMessage.msgtype = ((EmojiStickerManager.StickerInfo)localObject).originMsgType;
        l5 = l2;
        l2 = l4;
        l4 = l1;
        l1 = l2;
        l2 = l3;
        l3 = l5;
      }
      label496:
      a().a(localChatMessage);
      paramList.remove(localChatMessage);
      if (QLog.isColorLevel()) {
        QLog.i("EmojiStickerManager", 2, "isDisplay: " + ((EmojiStickerManager.StickerInfo)localObject).isDisplayed + ", isRead:" + localChatMessage.isread + ", hostSeq: " + ((EmojiStickerManager.StickerInfo)localObject).hostMsgSeq + ", hostTime: " + ((EmojiStickerManager.StickerInfo)localObject).hostMsgTime);
      }
      l6 = l1;
      l8 = l2;
      if (!((EmojiStickerManager.StickerInfo)localObject).isDisplayed) {
        if (this.jdField_a_of_type_Int == 0) {
          if (localChatMessage.time > this.jdField_a_of_type_Long)
          {
            this.jdField_a_of_type_JavaUtilList.add(localChatMessage);
            if (l2 != -9223372036854775808L)
            {
              l7 = l1;
              l5 = l2;
              if (((EmojiStickerManager.StickerInfo)localObject).hostMsgTime >= l2) {}
            }
            else
            {
              l7 = l1;
              l5 = l2;
              if (((EmojiStickerManager.StickerInfo)localObject).hostMsgTime > this.jdField_c_of_type_Long)
              {
                if (QLog.isColorLevel()) {
                  QLog.i("EmojiStickerManager", 2, "new navigate seq: " + ((EmojiStickerManager.StickerInfo)localObject).hostMsgSeq);
                }
                l5 = ((EmojiStickerManager.StickerInfo)localObject).hostMsgTime;
                l7 = ((EmojiStickerManager.StickerInfo)localObject).hostMsgSeq;
              }
            }
            l6 = l7;
            l8 = l5;
            if (((EmojiStickerManager.StickerInfo)localObject).hostMsgTime >= l4) {
              break label1096;
            }
            if (QLog.isColorLevel()) {
              QLog.i("EmojiStickerManager", 2, "need insert unRead tips!");
            }
            paramInt1 = 1;
            l1 = l7;
            l2 = l5;
            label787:
            if (paramString != null) {
              break label1318;
            }
            paramString = new HashMap();
          }
        }
      }
    }
    label1288:
    label1299:
    label1318:
    for (;;)
    {
      Pair localPair = a(localChatMessage);
      if (localPair != null)
      {
        List localList = (List)paramString.get(localPair);
        localObject = localList;
        if (localList == null) {
          localObject = new ArrayList();
        }
        ((List)localObject).add(localChatMessage);
        paramString.put(localPair, localObject);
      }
      m = paramString.size();
      l5 = l2;
      l2 = l3;
      l3 = l4;
      l4 = l1;
      l1 = l3;
      l3 = l5;
      break label131;
      ((EmojiStickerManager.StickerInfo)localObject).isDisplayed = true;
      break label787;
      if (this.jdField_a_of_type_Int != 1)
      {
        l6 = l1;
        l8 = l2;
        if (this.jdField_a_of_type_Int != 3000) {}
      }
      else
      {
        if (localChatMessage.shmsgseq > this.jdField_a_of_type_Long)
        {
          this.jdField_a_of_type_JavaUtilList.add(localChatMessage);
          if (l1 != -9223372036854775808L)
          {
            l5 = l1;
            if (((EmojiStickerManager.StickerInfo)localObject).hostMsgSeq >= l1) {}
          }
          else
          {
            l5 = l1;
            if (((EmojiStickerManager.StickerInfo)localObject).hostMsgSeq > this.jdField_c_of_type_Long)
            {
              if (QLog.isColorLevel()) {
                QLog.i("EmojiStickerManager", 2, "new navigate seq: " + ((EmojiStickerManager.StickerInfo)localObject).hostMsgSeq);
              }
              l5 = ((EmojiStickerManager.StickerInfo)localObject).hostMsgSeq;
            }
          }
          l6 = l5;
          l8 = l2;
          if (((EmojiStickerManager.StickerInfo)localObject).hostMsgSeq >= l3) {
            break label1096;
          }
          if (QLog.isColorLevel()) {
            QLog.i("EmojiStickerManager", 2, "need insert unRead tips!");
          }
          paramInt1 = 1;
          l1 = l5;
          break label787;
        }
        ((EmojiStickerManager.StickerInfo)localObject).isDisplayed = true;
        l8 = l2;
        l6 = l1;
      }
      label1096:
      l1 = l6;
      l2 = l8;
      break label787;
      label1107:
      l8 = l6;
      l7 = l5;
      if (m > 0)
      {
        paramString.remove(a(localChatMessage));
        m = paramString.size();
        l3 = l2;
        l4 = l1;
        l2 = l5;
        l1 = l6;
        break label131;
        if ((paramList.size() != 0) && (paramChatXListView.getChildCount() != 0) && (paramInt1 != 0) && (this.jdField_b_of_type_Int > 0)) {
          a(paramQQAppInterface, paramInt2, paramList, l1);
        }
        if ((paramString != null) && (paramString.size() > 0))
        {
          if (paramList.size() <= 0) {
            break label1288;
          }
          if (paramChatXListView.getChildCount() > 0)
          {
            if (this.jdField_a_of_type_Int == 0) {
              break label1277;
            }
            b(paramQQAppInterface, paramList, paramString);
          }
        }
        while (QLog.isColorLevel())
        {
          QLog.i("EmojiStickerManager", 2, "removeStickerMsgAndInsertGrayTips, cost=" + (System.currentTimeMillis() - l9));
          return;
          label1277:
          a(paramQQAppInterface, paramList, paramString);
          continue;
          a(paramList, paramQQAppInterface, paramString);
        }
        break;
      }
      l3 = l2;
      l4 = l1;
      l2 = l7;
      l1 = l8;
      break label131;
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.msgtype == -2058) && (jdField_e_of_type_Boolean))
    {
      Object localObject = a(paramMessageRecord);
      Pair localPair = a(paramMessageRecord);
      if ((localObject != null) && (localPair != null))
      {
        ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localPair);
        localObject = localArrayList;
        if (localArrayList == null) {
          localObject = new ArrayList();
        }
        if (!((ArrayList)localObject).contains(Long.valueOf(paramMessageRecord.uniseq))) {
          ((ArrayList)localObject).add(Long.valueOf(paramMessageRecord.uniseq));
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPair, localObject);
      }
    }
  }
  
  public void b()
  {
    if ((jdField_a_of_type_AndroidViewView instanceof BaseChatItemLayout))
    {
      BaseChatItemLayout localBaseChatItemLayout = (BaseChatItemLayout)jdField_a_of_type_AndroidViewView;
      if (localBaseChatItemLayout.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = localBaseChatItemLayout.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          anfs localanfs = (anfs)localIterator.next();
          if (localanfs.f != 0) {
            localanfs.f = 255;
          }
        }
        localBaseChatItemLayout.invalidate();
      }
    }
    jdField_a_of_type_AndroidViewView = null;
  }
  
  public void b(BaseChatPie paramBaseChatPie)
  {
    long l4 = 9223372036854775807L;
    Object localObject2 = null;
    List localList = paramBaseChatPie.jdField_a_of_type_Acka.a();
    if ((localList == null) || (localList.size() <= 0)) {
      return;
    }
    System.currentTimeMillis();
    Object localObject1 = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    int n;
    int m;
    label103:
    label117:
    long l1;
    label134:
    label149:
    label161:
    long l2;
    long l3;
    if ((localObject1 != null) && (((ChatXListView)localObject1).getAdapter() != null))
    {
      paramBaseChatPie = ((ChatXListView)localObject1).getAdapter();
      if (((ChatXListView)localObject1).getChildCount() > 0) {
        if ((paramBaseChatPie instanceof bejx))
        {
          n = ((ChatXListView)localObject1).getFirstVisiblePosition();
          m = ((ChatXListView)localObject1).getLastVisiblePosition();
          if ((n < 0) || (n >= paramBaseChatPie.getCount())) {
            break label288;
          }
          if ((m < 0) || (m >= paramBaseChatPie.getCount())) {
            break label293;
          }
          localObject1 = paramBaseChatPie.getItem(n);
          paramBaseChatPie = paramBaseChatPie.getItem(m);
          if (!(localObject1 instanceof MessageRecord)) {
            break label298;
          }
          localObject1 = (MessageRecord)localObject1;
          if (!(paramBaseChatPie instanceof MessageRecord)) {
            break label314;
          }
          paramBaseChatPie = (MessageRecord)paramBaseChatPie;
          l1 = ((MessageRecord)localObject1).shmsgseq;
          l2 = ((MessageRecord)localObject1).time;
          l3 = paramBaseChatPie.shmsgseq;
          l4 = paramBaseChatPie.time;
        }
      }
    }
    for (;;)
    {
      paramBaseChatPie = localList.iterator();
      for (;;)
      {
        if (!paramBaseChatPie.hasNext()) {
          break label388;
        }
        localObject1 = (ChatMessage)paramBaseChatPie.next();
        if (((ChatMessage)localObject1).istroop == 0)
        {
          if ((((ChatMessage)localObject1).time >= l2) && (((ChatMessage)localObject1).time <= l4)) {
            continue;
          }
          ((ChatMessage)localObject1).stickerHidden = false;
          continue;
          if (!(paramBaseChatPie instanceof acka)) {
            break label393;
          }
          n = ((ChatXListView)localObject1).getFirstVisiblePosition() - ((ChatXListView)localObject1).getHeaderViewsCount();
          m = ((ChatXListView)localObject1).getLastVisiblePosition() - ((ChatXListView)localObject1).getFooterViewsCount();
          break;
          label288:
          n = 0;
          break label103;
          label293:
          m = 0;
          break label117;
          label298:
          localObject1 = (MessageRecord)localList.get(0);
          break label149;
          label314:
          paramBaseChatPie = (MessageRecord)localList.get(localList.size() - 1);
          break label161;
        }
        if (((((ChatMessage)localObject1).istroop == 1) || (((ChatMessage)localObject1).istroop == 3000)) && ((((ChatMessage)localObject1).shmsgseq < l1) || (((ChatMessage)localObject1).shmsgseq > l3))) {
          ((ChatMessage)localObject1).stickerHidden = false;
        }
      }
      label388:
      System.currentTimeMillis();
      return;
      label393:
      m = 0;
      n = 0;
      break;
      localObject1 = null;
      paramBaseChatPie = localObject2;
      break label134;
      l2 = -9223372036854775808L;
      l1 = -9223372036854775808L;
      l3 = 9223372036854775807L;
    }
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    Object localObject;
    Pair localPair;
    ArrayList localArrayList;
    if ((paramMessageRecord != null) && (paramMessageRecord.msgtype == -2058) && (jdField_e_of_type_Boolean) && (a(paramMessageRecord) != null))
    {
      if ((paramMessageRecord.frienduin.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Int == paramMessageRecord.istroop))
      {
        this.jdField_b_of_type_Int = 0;
        localObject = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject instanceof QQAppInterface)) {
          this.jdField_a_of_type_Long = ((QQAppInterface)localObject).a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
        }
      }
      localPair = a(paramMessageRecord);
      if (localPair != null)
      {
        localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(localPair);
        if (localArrayList != null) {
          break label230;
        }
        localArrayList = new ArrayList();
      }
    }
    label230:
    for (;;)
    {
      if ((!localArrayList.contains(Long.valueOf(paramMessageRecord.uniseq))) && (localArrayList.size() < f)) {
        localArrayList.add(Long.valueOf(paramMessageRecord.uniseq));
      }
      localObject = "1";
      if (paramMessageRecord.istroop == 1) {
        localObject = "2";
      }
      for (;;)
      {
        VasWebviewUtil.reportCommercialDrainage("", "Stick", "Receive", (String)localObject, 1, 0, 0, null, "", "");
        this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(localPair, localArrayList);
        return;
        if (paramMessageRecord.istroop == 3000) {
          localObject = "3";
        }
      }
    }
  }
  
  public void c(BaseChatPie paramBaseChatPie)
  {
    if ((paramBaseChatPie != null) && (paramBaseChatPie.jdField_c_of_type_AndroidViewViewGroup != null) && ((paramBaseChatPie.jdField_c_of_type_AndroidViewViewGroup instanceof TopGestureLayout)))
    {
      TopGestureLayout localTopGestureLayout = (TopGestureLayout)paramBaseChatPie.jdField_c_of_type_AndroidViewViewGroup;
      if (!(localTopGestureLayout.getGestureDetector() instanceof anly)) {
        localTopGestureLayout.setGestureDetector(new anly(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, localTopGestureLayout.getGestureListener(), paramBaseChatPie));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiStickerManager
 * JD-Core Version:    0.7.0.1
 */