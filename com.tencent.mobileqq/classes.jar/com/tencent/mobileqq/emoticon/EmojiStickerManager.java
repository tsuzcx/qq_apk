package com.tencent.mobileqq.emoticon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.helper.EmojiStickerHelper;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.ISmallEmoticonInfo;
import com.tencent.mobileqq.emoticonview.StickerGestureDetector;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.ISmallEmoticonInfoService;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.config.business.qvip.QVipStickerProcessor;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.widget.HeaderViewListAdapter;
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
  public static long A = 0L;
  private static final EmojiStickerManager G = new EmojiStickerManager();
  public static boolean a = false;
  public static boolean b = false;
  public static boolean c = false;
  public static boolean d = false;
  public static boolean e = false;
  public static View f;
  public static boolean n = true;
  public static int o = 1;
  public static int p = 0;
  public static int q = 1;
  public static int r = 20;
  public static int s = 10;
  public static float t = 0.01F;
  public static boolean u = false;
  public static boolean v = false;
  public static int w = 0;
  public static boolean x = false;
  public static String y = "";
  public static int z = -1;
  public ConcurrentHashMap<Pair<Long, Long>, ArrayList<Long>> B = new ConcurrentHashMap();
  public LRULinkedHashMap<Pair<Long, Long>, ArrayList<Long>> C = new LRULinkedHashMap(64);
  public LRULinkedHashMap<Pair<Long, Long>, Boolean> D = new LRULinkedHashMap(64);
  public List<MessageRecord> E = new ArrayList();
  public ConcurrentHashMap<String, Long> F = new ConcurrentHashMap();
  private Drawable H;
  private ColorDrawable I = new ColorDrawable();
  public String g = "";
  public int h = 0;
  public int i = -2147483648;
  public long j = -9223372036854775808L;
  public long k = -9223372036854775808L;
  public long l = -9223372036854775808L;
  public ArrayList<Bundle> m = new ArrayList();
  
  public static int a(StringBuilder paramStringBuilder)
  {
    int i8 = paramStringBuilder.length();
    int i9 = paramStringBuilder.length();
    int i2 = 0;
    int i5 = 0;
    int i1 = 0;
    while (i2 < i8)
    {
      int i10 = paramStringBuilder.codePointAt(i2);
      int i7;
      if ((i10 == 20) && (i2 < i9 - 1))
      {
        i6 = i2 + 1;
        i7 = paramStringBuilder.charAt(i6);
        if (i7 < EmotcationConstants.VALID_SYS_EMOTCATION_COUNT) {
          a(paramStringBuilder, i2, i7);
        }
        for (;;)
        {
          i3 = i5 + 1;
          i1 += 1;
          i2 = i6;
          break label352;
          if (i7 >= 255)
          {
            i3 = i2 + 4;
            if (i3 < i9)
            {
              b(paramStringBuilder, i2);
              i4 = i5 + 1;
              i1 += 1;
              i2 = i3;
              i3 = i4;
              break label352;
            }
          }
          i4 = i2;
          i3 = i1;
          if (i7 != 250) {
            break;
          }
          a(paramStringBuilder, i2);
        }
      }
      int i4 = EmotcationConstants.getSingleEmoji(i10);
      if (i10 > 65535)
      {
        i3 = i2 + 2;
        if (i9 <= i3) {
          break label244;
        }
        i3 = paramStringBuilder.codePointAt(i3);
      }
      else
      {
        i3 = i2 + 1;
        if (i9 <= i3) {
          break label244;
        }
        i6 = paramStringBuilder.codePointAt(i3);
        i3 = i6;
        if (i6 == 65039)
        {
          i7 = i2 + 2;
          i3 = i6;
          if (i9 > i7)
          {
            i6 = paramStringBuilder.codePointAt(i7);
            bool1 = true;
            break label252;
          }
        }
      }
      break label246;
      label244:
      int i3 = -1;
      label246:
      boolean bool1 = false;
      int i6 = i3;
      label252:
      boolean bool2 = EmotcationConstants.isSkinEmoji(i6);
      if ((i4 != -1) && (!bool2))
      {
        bool2 = false;
        i7 = i4;
      }
      else
      {
        i3 = EmotcationConstants.getDoubleEmoji(i10, i6);
        if (i3 == -1) {
          i3 = i4;
        }
        bool2 = true;
        i7 = i3;
      }
      i4 = i2;
      i3 = i1;
      if (i7 != -1)
      {
        i4 = i2 + (a(paramStringBuilder, i2, i9, i10, bool2, i6, bool1) - 1);
        i3 = i1 + 1;
      }
      i2 = i4;
      i1 = i3;
      i3 = i5;
      label352:
      if (i1 > 512) {
        return i3;
      }
      i2 += 1;
      i5 = i3;
    }
    return i5;
  }
  
  protected static int a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, boolean paramBoolean2)
  {
    int i1 = 1;
    if (paramBoolean1)
    {
      if (paramInt3 > 65535)
      {
        paramInt3 = paramInt1 + 2;
        if (paramInt2 >= paramInt3)
        {
          if (QQText.IS_FXXKED_MTK) {
            paramStringBuilder.replace(paramInt1, paramInt3, "##");
          }
          paramInt3 = 2;
          break label62;
        }
      }
      if (QQText.IS_FXXKED_MTK) {
        paramStringBuilder.replace(paramInt1, paramInt1 + 1, "#");
      }
      paramInt3 = 1;
      label62:
      if (paramInt4 > 65535)
      {
        paramInt4 = paramInt1 + 2;
        if (paramInt2 >= paramInt4)
        {
          if (QQText.IS_FXXKED_MTK) {
            paramStringBuilder.replace(paramInt4, paramInt1 + 4, "##");
          }
          paramInt1 = paramInt3 + 2;
          break label128;
        }
      }
      if (QQText.IS_FXXKED_MTK) {
        paramStringBuilder.replace(paramInt1 + 2, paramInt1 + 3, "#");
      }
      paramInt1 = paramInt3 + 1;
      label128:
      paramInt2 = paramInt1;
      if (paramBoolean2) {
        return paramInt1 + 1;
      }
    }
    else
    {
      if (paramInt3 > 65535)
      {
        paramInt3 = paramInt1 + 2;
        if (paramInt2 >= paramInt3)
        {
          if (QQText.IS_FXXKED_MTK) {
            paramStringBuilder.replace(paramInt1, paramInt3, "##");
          }
          return 2;
        }
      }
      paramInt2 = i1;
      if (QQText.IS_FXXKED_MTK)
      {
        paramStringBuilder.replace(paramInt1, paramInt1 + 1, "#");
        paramInt2 = i1;
      }
    }
    return paramInt2;
  }
  
  private long a(long paramLong, StickerInfo paramStickerInfo)
  {
    long l1;
    if (paramLong != -9223372036854775808L)
    {
      l1 = paramLong;
      if (paramStickerInfo.hostMsgSeq >= paramLong) {}
    }
    else
    {
      l1 = paramLong;
      if (paramStickerInfo.hostMsgSeq > this.l)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("new navigate seq: ");
          localStringBuilder.append(paramStickerInfo.hostMsgSeq);
          QLog.i("EmojiStickerManager", 2, localStringBuilder.toString());
        }
        l1 = paramStickerInfo.hostMsgSeq;
      }
    }
    return l1;
  }
  
  public static CustomEmotionData a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (IFavroamingDBManagerService)paramQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
    List localList = paramQQAppInterface.getEmoticonDataList();
    if (localList != null)
    {
      int i1 = 0;
      while (i1 < localList.size())
      {
        if ((paramString != null) && (paramString.equals(((CustomEmotionData)localList.get(i1)).emoPath)))
        {
          paramString = (CustomEmotionData)localList.get(i1);
          paramQQAppInterface.updateDeletedEmoticon(paramString, i1);
          return paramString;
        }
        i1 += 1;
      }
    }
    return null;
  }
  
  private MessageRecord a(ChatXListView paramChatXListView, List<ChatMessage> paramList)
  {
    if (paramChatXListView.getChildCount() > 0)
    {
      int i1 = paramChatXListView.getFirstVisiblePosition() - paramChatXListView.getHeaderViewsCount();
      if ((i1 < 0) || (i1 >= paramChatXListView.getAdapter().getCount())) {
        i1 = 0;
      }
      paramChatXListView = paramChatXListView.getAdapter().getItem(i1);
    }
    else
    {
      paramChatXListView = null;
    }
    if ((paramChatXListView instanceof MessageRecord)) {
      return (MessageRecord)paramChatXListView;
    }
    return (MessageRecord)paramList.get(0);
  }
  
  public static EmojiStickerManager a()
  {
    return G;
  }
  
  public static QQText a(com.tencent.imcore.message.Message paramMessage)
  {
    Object localObject1 = null;
    if (paramMessage == null) {
      return null;
    }
    Object localObject2 = paramMessage.getExtInfoFromExtStr("sticker_info");
    paramMessage = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = StickerInfo.transformFromJson((String)localObject2);
      paramMessage = localObject1;
      if (localObject2 != null) {
        paramMessage = new QQText(((StickerInfo)localObject2).msg, 3, 16);
      }
    }
    return paramMessage;
  }
  
  public static QQText a(QQAppInterface paramQQAppInterface, com.tencent.imcore.message.Message paramMessage, MsgSummary paramMsgSummary)
  {
    if ((paramQQAppInterface != null) && (paramMessage != null))
    {
      HardCodeUtil.a(2131902062);
      Object localObject = paramMessage.getExtInfoFromExtStr("sticker_info");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = StickerInfo.transformFromJson((String)localObject);
        if (localObject != null)
        {
          String str = ((StickerInfo)localObject).msg;
          localObject = str;
          if (!n) {
            break label152;
          }
          if (paramMessage.senderuin.equals(paramQQAppInterface.getCurrentAccountUin()))
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append(HardCodeUtil.a(2131902063));
            paramQQAppInterface.append(str);
            localObject = paramQQAppInterface.toString();
            paramMsgSummary.mEmojiFlag = 1;
            break label152;
          }
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append(HardCodeUtil.a(2131902066));
          paramQQAppInterface.append(str);
          localObject = paramQQAppInterface.toString();
          paramMsgSummary.mEmojiFlag = 0;
          break label152;
        }
      }
      localObject = "";
      label152:
      return new QQText((CharSequence)localObject, 3, 16);
    }
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    boolean bool = TextUtils.isEmpty(paramString2);
    String str1 = null;
    if (bool) {
      return null;
    }
    String str2 = paramQQAppInterface.getCurrentUin();
    if (paramInt == 0)
    {
      if (str2.equals(paramString2)) {
        return HardCodeUtil.a(2131902069);
      }
      return HardCodeUtil.a(2131902068);
    }
    if (paramInt == 1)
    {
      if (str2.equals(paramString2)) {
        return paramQQAppInterface.getCurrentNickname();
      }
      return ContactUtils.b(paramQQAppInterface, paramString1, paramString2);
    }
    if (paramInt == 3000)
    {
      if (str2.equals(paramString2)) {
        return paramQQAppInterface.getCurrentNickname();
      }
      str1 = ContactUtils.a(paramQQAppInterface, paramString1, paramString2);
    }
    return str1;
  }
  
  private HashMap<Pair<Long, Long>, List<ChatMessage>> a(HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap, ChatMessage paramChatMessage)
  {
    Object localObject = paramHashMap;
    if (paramHashMap == null) {
      localObject = new HashMap();
    }
    Pair localPair = f(paramChatMessage);
    if (localPair != null)
    {
      List localList = (List)((HashMap)localObject).get(localPair);
      paramHashMap = localList;
      if (localList == null) {
        paramHashMap = new ArrayList();
      }
      paramHashMap.add(paramChatMessage);
      ((HashMap)localObject).put(localPair, paramHashMap);
    }
    return localObject;
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable, String paramString, PicMessageExtraData paramPicMessageExtraData, MessengerService paramMessengerService, Bundle paramBundle)
  {
    new EmojiStickerManager.3(paramBundle, paramMessengerService, paramURLDrawable, paramQQAppInterface, paramPicMessageExtraData).execute(new Void[0]);
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt, List<ChatMessage> paramList, long paramLong)
  {
    Object localObject = this.E;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if (paramInt > 0) {
        if (QLog.isColorLevel()) {
          QLog.i("EmojiStickerManager", 2, "has been pull more than once!");
        }
      }
      for (;;)
      {
        paramInt = 0;
        break label202;
        localObject = (MessageRecord)paramList.get(paramList.size() - 1);
        StringBuilder localStringBuilder;
        if ((this.h == 0) && (((MessageRecord)localObject).time > this.k))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("new message coming! getLastRead: ");
            localStringBuilder.append(((MessageRecord)localObject).time);
            QLog.i("EmojiStickerManager", 2, localStringBuilder.toString());
          }
          this.i = 0;
        }
        else
        {
          if (((MessageRecord)localObject).shmsgseq <= this.k) {
            break;
          }
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("new message coming! getLastRead: ");
            localStringBuilder.append(((MessageRecord)localObject).shmsgseq);
            QLog.i("EmojiStickerManager", 2, localStringBuilder.toString());
          }
        }
      }
      paramInt = 1;
      label202:
      if (paramInt != 0)
      {
        a(paramQQAppInterface, paramList, paramLong);
        return;
      }
      paramList = this.E.iterator();
      while (paramList.hasNext())
      {
        localObject = d((MessageRecord)paramList.next());
        if ((localObject != null) && (!((StickerInfo)localObject).isDisplayed)) {
          ((StickerInfo)localObject).isDisplayed = true;
        }
      }
      this.i = 0;
      this.j = paramQQAppInterface.getConversationFacade().e(this.g, this.h);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, StickerInfo paramStickerInfo)
  {
    if (paramQQAppInterface != null)
    {
      if (paramStickerInfo == null) {
        return;
      }
      try
      {
        if ((paramMessageRecord instanceof MessageForMarketFace))
        {
          MessageForMarketFace localMessageForMarketFace = (MessageForMarketFace)paramMessageRecord;
          if (localMessageForMarketFace.mMarkFaceMessage != null) {
            localMessageForMarketFace.mMarkFaceMessage.stickerInfo = paramStickerInfo;
          }
          localMessageForMarketFace.msgData = MessagePkgUtils.a(localMessageForMarketFace.mMarkFaceMessage);
          paramQQAppInterface.getMessageFacade().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, paramMessageRecord.msgData);
          return;
        }
        if (((paramMessageRecord instanceof MessageForText)) || ((paramMessageRecord instanceof MessageForPic)))
        {
          paramMessageRecord.stickerInfo = paramStickerInfo;
          paramMessageRecord.saveExtInfoToExtStr("sticker_info", paramStickerInfo.toJsonString());
          paramQQAppInterface.getMessageFacade().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extStr", paramMessageRecord.extStr);
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append("save sticker shown status error e = ");
        paramMessageRecord.append(paramQQAppInterface);
        QLog.e("EmojiStickerManager", 1, paramMessageRecord.toString());
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = AIOGallerySceneWithBusiness.c(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      IVipComicMqqManagerService localIVipComicMqqManagerService = (IVipComicMqqManagerService)paramQQAppInterface.getRuntimeService(IVipComicMqqManagerService.class);
      paramQQAppInterface = new VipComicFavorEmoStructMsgInfo();
      paramQQAppInterface.picMd5 = paramCustomEmotionData.md5;
      paramQQAppInterface.actionData = paramStructMsgForImageShare;
      paramStructMsgForImageShare = new ArrayList();
      paramStructMsgForImageShare.add(paramQQAppInterface);
      localIVipComicMqqManagerService.setMyComicEmoticon(paramStructMsgForImageShare, true);
      if (QLog.isColorLevel())
      {
        paramStructMsgForImageShare = new StringBuilder();
        paramStructMsgForImageShare.append("handleComicStructMsg , emoStructMsgInfo = ");
        paramStructMsgForImageShare.append(paramQQAppInterface);
        QLog.d("EmojiStickerManager", 2, paramStructMsgForImageShare.toString());
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, long paramLong)
  {
    Object localObject1 = (MessageRecord)paramList.get(paramList.size() - 1);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("insertStickerGrayTips4UnRead, mUnReadCount: ");
      ((StringBuilder)localObject2).append(this.i);
      ((StringBuilder)localObject2).append(", new sticker size: ");
      ((StringBuilder)localObject2).append(this.E.size());
      QLog.i("EmojiStickerManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (this.i > 0)
    {
      localObject2 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject2).isread = true;
      int i1 = this.i;
      Object localObject3;
      if (i1 <= 10)
      {
        if ((this.h == 1) && (paramLong != -9223372036854775808L))
        {
          localObject3 = String.format(HardCodeUtil.a(2131902061), new Object[] { Integer.valueOf(Math.min(this.E.size(), this.i)) });
          localObject1 = new UniteGrayTipParam(((MessageRecord)localObject1).frienduin, paramQQAppInterface.getCurrentAccountUin(), (String)localObject3, ((MessageRecord)localObject1).istroop, -5023, 1179651, ((MessageRecord)localObject1).time);
          Bundle localBundle = new Bundle();
          localBundle.putInt("key_action", 20);
          localBundle.putString("key_action_DATA", String.valueOf(paramLong));
          ((UniteGrayTipParam)localObject1).a(((String)localObject3).length() - 4, ((String)localObject3).length(), localBundle);
        }
        else
        {
          localObject3 = String.format(HardCodeUtil.a(2131902064), new Object[] { Integer.valueOf(Math.min(this.E.size(), this.i)) });
          localObject1 = new UniteGrayTipParam(((MessageRecord)localObject1).frienduin, paramQQAppInterface.getCurrentAccountUin(), (String)localObject3, ((MessageRecord)localObject1).istroop, -5023, 1179651, ((MessageRecord)localObject1).time);
        }
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("key", "NewTip");
        ((Bundle)localObject3).putInt("sessionType", this.h);
        ((Bundle)localObject3).putString("ext2", "1");
        this.m.add(localObject3);
        ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject1);
      }
      else if (i1 > 10)
      {
        localObject3 = HardCodeUtil.a(2131902070);
        ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(paramQQAppInterface, new UniteGrayTipParam(((MessageRecord)localObject1).frienduin, paramQQAppInterface.getCurrentAccountUin(), (String)localObject3, ((MessageRecord)localObject1).istroop, -5023, 1179651, ((MessageRecord)localObject1).time));
        paramQQAppInterface = new Bundle();
        paramQQAppInterface.putString("key", "NewTip");
        paramQQAppInterface.putInt("sessionType", this.h);
        paramQQAppInterface.putString("ext2", "2");
        this.m.add(paramQQAppInterface);
      }
      paramList.add(paramList.size(), localObject2);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap)
  {
    Object localObject = new ArrayList();
    a(paramQQAppInterface, paramList, paramHashMap, (List)localObject);
    if (((List)localObject).size() > 0)
    {
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putString("key", "DeleteHide");
      paramQQAppInterface.putInt("sessionType", this.h);
      this.m.add(paramQQAppInterface);
    }
    paramQQAppInterface = ((List)localObject).iterator();
    while (paramQQAppInterface.hasNext())
    {
      paramHashMap = (MessageForUniteGrayTip)paramQQAppInterface.next();
      int i1 = 0;
      localObject = paramList.iterator();
      while ((((Iterator)localObject).hasNext()) && (((MessageRecord)((Iterator)localObject).next()).time <= paramHashMap.time)) {
        i1 += 1;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("insert unfounded gray tips:  host seq: ");
        ((StringBuilder)localObject).append(paramHashMap.shmsgseq);
        ((StringBuilder)localObject).append(", list pos: ");
        ((StringBuilder)localObject).append(i1);
        QLog.i("EmojiStickerManager", 2, ((StringBuilder)localObject).toString());
      }
      paramList.add(i1, paramHashMap);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap, List<MessageForUniteGrayTip> paramList1)
  {
    int i1 = paramList.size();
    int i2 = 0;
    if (i1 > 0) {
      paramList = (MessageRecord)paramList.get(0);
    } else {
      paramList = null;
    }
    long l1;
    if (paramList != null) {
      l1 = paramList.time;
    } else {
      l1 = 9223372036854775807L;
    }
    long l4 = paramQQAppInterface.getMsgCache().b(this.g, this.h);
    paramList = paramHashMap.keySet().iterator();
    while (paramList.hasNext())
    {
      Pair localPair = (Pair)paramList.next();
      Object localObject1 = (List)paramHashMap.get(localPair);
      if (localObject1 != null) {
        if (((List)localObject1).size() != 0)
        {
          localObject1 = (MessageRecord)((List)localObject1).get(i2);
          StickerInfo localStickerInfo = d((MessageRecord)localObject1);
          if (localStickerInfo != null)
          {
            Object localObject2;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("unFind msg: shmsgseq: ");
              ((StringBuilder)localObject2).append(localStickerInfo.hostMsgSeq);
              ((StringBuilder)localObject2).append(", isDisplay: ");
              ((StringBuilder)localObject2).append(localStickerInfo.isDisplayed);
              ((StringBuilder)localObject2).append(", hostTime: ");
              ((StringBuilder)localObject2).append(localStickerInfo.hostMsgTime);
              QLog.i("EmojiStickerManager", 2, ((StringBuilder)localObject2).toString());
            }
            if ((!this.D.containsKey(localPair)) && (localStickerInfo.hostMsgTime <= l1)) {
              i1 = 0;
            } else {
              i1 = 1;
            }
            Object localObject3;
            if (i1 == 0)
            {
              localObject2 = paramQQAppInterface.getMessageProxy(this.h).d(this.g, this.h);
              if ((localObject2 != null) && (((List)localObject2).size() > 0))
              {
                long l2;
                if (localStickerInfo.hostMsgTime < ((MessageRecord)((List)localObject2).get(i2)).time)
                {
                  if (localStickerInfo.hostMsgTime <= l4)
                  {
                    l2 = l1;
                    l1 = l2;
                  }
                }
                else {
                  label537:
                  for (;;)
                  {
                    i1 = 1;
                    break label539;
                    i2 = ((List)localObject2).size() - 1;
                    while (i2 >= 0)
                    {
                      localObject3 = (MessageRecord)((List)localObject2).get(i2);
                      if ((((MessageRecord)localObject3).shmsgseq == localStickerInfo.hostMsgSeq) && (((MessageRecord)localObject3).msgUid == localStickerInfo.hostMsgUid))
                      {
                        i2 = 1;
                        i1 = 0;
                        break label445;
                      }
                      i2 -= 1;
                    }
                    i2 = 0;
                    label445:
                    if (i2 == 0)
                    {
                      localObject2 = paramQQAppInterface.getMsgCache().N(this.g);
                      long l3;
                      if (localObject2 == null) {
                        l3 = 0L;
                      } else {
                        l3 = ((Long)((Pair)localObject2).first).longValue();
                      }
                      l2 = l1;
                      if (localStickerInfo.hostMsgTime > l3) {
                        break;
                      }
                      if (l3 == 0L)
                      {
                        l2 = l1;
                        break;
                      }
                      if (this.j - localStickerInfo.hostMsgTime > 86400L) {
                        break label537;
                      }
                    }
                  }
                }
              }
            }
            label539:
            if (i1 != 0)
            {
              localObject2 = new MessageForUniteGrayTip();
              localObject3 = BaseApplicationImpl.getApplication().getString(2131916785);
              ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(paramQQAppInterface, new UniteGrayTipParam(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).senderuin, (String)localObject3, this.h, -5040, 1, localStickerInfo.hostMsgTime));
              ((MessageForUniteGrayTip)localObject2).shmsgseq = ((Long)localPair.first).longValue();
              ((MessageForUniteGrayTip)localObject2).msgUid = ((Long)localPair.second).longValue();
              ((MessageForUniteGrayTip)localObject2).time = localStickerInfo.hostMsgTime;
              ((MessageForUniteGrayTip)localObject2).mNeedTimeStamp = false;
              paramList1.add(localObject2);
            }
            i2 = 0;
          }
        }
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage)
  {
    if (!paramChatMessage.isread)
    {
      if ((this.h == 0) && (paramChatMessage.time > this.k))
      {
        this.k = paramChatMessage.time;
        return;
      }
      if (paramChatMessage.shmsgseq > this.k) {
        this.k = paramChatMessage.shmsgseq;
      }
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    Object localObject1;
    if (paramMessageRecord.istroop != 0)
    {
      Object localObject2 = null;
      localObject1 = d(paramMessageRecord);
      if (localObject1 != null)
      {
        Pair localPair = new Pair(Long.valueOf(((StickerInfo)localObject1).hostMsgSeq), Long.valueOf(0L));
        boolean bool = a().D.containsKey(localPair);
        localObject1 = localObject2;
        if (!bool)
        {
          paramAppInterface = ((QQAppInterface)paramAppInterface).getMessageProxy(paramMessageRecord.istroop).c(paramMessageRecord.frienduin, paramMessageRecord.istroop);
          localObject1 = localObject2;
          if (paramAppInterface != null)
          {
            localObject1 = localObject2;
            if (paramAppInterface.size() > 0)
            {
              int i1 = paramAppInterface.size() - 1;
              for (;;)
              {
                localObject1 = localObject2;
                if (i1 < 0) {
                  break;
                }
                localObject1 = (MessageRecord)paramAppInterface.get(i1);
                if ((((MessageRecord)localObject1).shmsgseq == ((Long)localPair.first).longValue()) && (g((MessageRecord)localObject1))) {
                  break;
                }
                i1 -= 1;
              }
            }
          }
        }
        if (((bool) || ((localObject1 != null) && (((MessageRecord)localObject1).msgtype == -2006))) && (localObject1 != null)) {
          a().D.put(localPair, Boolean.valueOf(true));
        }
      }
    }
    else
    {
      paramAppInterface = d(paramMessageRecord);
      if (paramAppInterface != null)
      {
        paramAppInterface.hostMsgSeq = ((short)(int)paramAppInterface.hostMsgSeq);
        if ((paramMessageRecord instanceof MessageForMarketFace))
        {
          localObject1 = (MessageForMarketFace)paramMessageRecord;
          if (((MessageForMarketFace)localObject1).mMarkFaceMessage != null) {
            ((MessageForMarketFace)localObject1).mMarkFaceMessage.stickerInfo = paramAppInterface;
          }
          try
          {
            ((MessageForMarketFace)localObject1).msgData = MessagePkgUtils.a(((MessageForMarketFace)localObject1).mMarkFaceMessage);
          }
          catch (Exception paramAppInterface)
          {
            paramAppInterface.printStackTrace();
          }
        }
        else if ((paramMessageRecord instanceof MessageForText))
        {
          localObject1 = (MessageForText)paramMessageRecord;
          ((MessageForText)localObject1).stickerInfo = paramAppInterface;
          ((MessageForText)localObject1).saveExtInfoToExtStr("sticker_info", paramAppInterface.toJsonString());
        }
        else if ((paramMessageRecord instanceof MessageForPic))
        {
          localObject1 = (MessageForPic)paramMessageRecord;
          ((MessageForPic)localObject1).stickerInfo = paramAppInterface;
          ((MessageForPic)localObject1).saveExtInfoToExtStr("sticker_info", paramAppInterface.toJsonString());
        }
      }
    }
    a().b(paramMessageRecord);
  }
  
  public static void a(MessageRecord paramMessageRecord, StickerInfo paramStickerInfo)
  {
    int i1;
    if (paramMessageRecord != null)
    {
      if (!e(paramMessageRecord)) {
        return;
      }
      try
      {
        i1 = paramMessageRecord.msgtype;
        if (paramStickerInfo == null) {
          break label207;
        }
        paramStickerInfo.originMsgType = paramMessageRecord.msgtype;
      }
      catch (Exception paramMessageRecord)
      {
        Object localObject;
        label107:
        if (!QLog.isColorLevel()) {
          break label206;
        }
        QLog.e("EmojiStickerManager", 2, "", paramMessageRecord);
      }
      paramStickerInfo = paramMessageRecord.getExtInfoFromExtStr("sticker_info");
      if (!TextUtils.isEmpty(paramStickerInfo))
      {
        localObject = StickerInfo.transformFromJson(paramStickerInfo);
        if (localObject != null)
        {
          ((StickerInfo)localObject).originMsgType = i1;
          if (i1 == -1000) {
            paramStickerInfo = paramMessageRecord.msg;
          } else {
            paramStickerInfo = HardCodeUtil.a(2131902067);
          }
          ((StickerInfo)localObject).msg = paramStickerInfo;
          paramMessageRecord.stickerInfo = localObject;
          paramMessageRecord.saveExtInfoToExtStr("sticker_info", ((StickerInfo)localObject).toJsonString());
          break label138;
          localObject = (MessageForMarketFace)paramMessageRecord;
          if (((MessageForMarketFace)localObject).mMarkFaceMessage != null) {
            ((MessageForMarketFace)localObject).mMarkFaceMessage.stickerInfo = paramStickerInfo;
          }
          ((MessageForMarketFace)localObject).msgData = MessagePkgUtils.a(((MessageForMarketFace)localObject).mMarkFaceMessage);
        }
      }
    }
    for (;;)
    {
      label138:
      paramMessageRecord.extLong |= 0x4;
      paramStickerInfo = new JSONObject();
      paramStickerInfo.put("msgType", i1);
      paramMessageRecord.saveExtInfoToExtStr("Emoji_Sticker_Info", paramStickerInfo.toString());
      if (n)
      {
        paramMessageRecord.msgtype = -2058;
        return;
      }
      label206:
      return;
      label207:
      if (i1 == -2007) {
        break label107;
      }
      if ((i1 == -2000) || (i1 == -1000)) {
        break;
      }
    }
  }
  
  protected static void a(StringBuilder paramStringBuilder, int paramInt)
  {
    if (QQText.IS_FXXKED_MTK) {
      paramStringBuilder.replace(paramInt, paramInt + 2, "##");
    }
  }
  
  protected static void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    if (QQText.IS_FXXKED_MTK)
    {
      paramStringBuilder.replace(paramInt1, paramInt1 + 2, "##");
      return;
    }
    if (paramInt2 == 10) {
      paramStringBuilder.setCharAt(paramInt1 + 1, 'ú');
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
    if (this.h != 0) {
      b(paramQQAppInterface, paramList, paramHashMap);
    } else {
      a(paramQQAppInterface, paramList, paramHashMap);
    }
    if (paramList.size() == 0) {
      c(paramQQAppInterface, paramList, paramHashMap);
    }
  }
  
  private boolean a(long paramLong, boolean paramBoolean, StickerInfo paramStickerInfo)
  {
    if (paramStickerInfo.hostMsgTime < paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmojiStickerManager", 2, "need insert unRead tips!");
      }
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  private boolean a(List<ChatMessage> paramList, ChatMessage paramChatMessage, StickerInfo paramStickerInfo)
  {
    if (paramStickerInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmojiStickerManager", 2, "sticker info is null! WTF!");
      }
      return true;
    }
    if (!n)
    {
      paramChatMessage.msgtype = paramStickerInfo.originMsgType;
      return true;
    }
    a().a(paramChatMessage);
    paramList.remove(paramChatMessage);
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("isDisplay: ");
      paramList.append(paramStickerInfo.isDisplayed);
      paramList.append(", isRead:");
      paramList.append(paramChatMessage.isread);
      paramList.append(", hostSeq: ");
      paramList.append(paramStickerInfo.hostMsgSeq);
      paramList.append(", hostTime: ");
      paramList.append(paramStickerInfo.hostMsgTime);
      QLog.i("EmojiStickerManager", 2, paramList.toString());
    }
    return false;
  }
  
  private static int b(QQAppInterface paramQQAppInterface, String paramString, StructMsgForImageShare paramStructMsgForImageShare, PicMessageExtraData paramPicMessageExtraData)
  {
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    IFavroamingDBManagerService localIFavroamingDBManagerService = (IFavroamingDBManagerService)paramQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
    Object localObject = localIFavroamingDBManagerService.getEmoticonDataList();
    int i1;
    if (localObject != null)
    {
      int i2 = 0;
      int i4 = 0;
      int i5;
      for (i1 = 1; i2 < ((List)localObject).size(); i1 = i5)
      {
        int i3;
        if (!TextUtils.isEmpty(((CustomEmotionData)((List)localObject).get(i2)).RomaingType))
        {
          i3 = i4;
          if ("needDel".equals(((CustomEmotionData)((List)localObject).get(i2)).RomaingType)) {}
        }
        else
        {
          i3 = i4 + 1;
        }
        i4 = ((CustomEmotionData)((List)localObject).get(i2)).emoId;
        if ((paramString != null) && (paramString.equals(((CustomEmotionData)((List)localObject).get(i2)).emoPath)))
        {
          b(paramQQAppInterface, paramStructMsgForImageShare, (CustomEmotionData)((List)localObject).get(i2));
          return 2;
        }
        if ((str != null) && (((CustomEmotionData)((List)localObject).get(i2)).md5 != null) && (str.equals(((CustomEmotionData)((List)localObject).get(i2)).md5)))
        {
          b(paramQQAppInterface, paramStructMsgForImageShare, (CustomEmotionData)((List)localObject).get(i2));
          if ("needDel".equals(((CustomEmotionData)((List)localObject).get(i2)).RomaingType))
          {
            localIFavroamingDBManagerService.updateDeletedEmoticon((CustomEmotionData)((List)localObject).get(i2), i2);
            paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.obtainMessage(10).sendToTarget();
            }
            return 0;
          }
          return 2;
        }
        i5 = i1;
        if (i1 < i4) {
          i5 = i4;
        }
        i2 += 1;
        i4 = i3;
      }
      if (i4 >= FavEmoConstant.a) {
        return 3;
      }
    }
    else
    {
      i1 = 1;
    }
    localObject = new CustomEmotionData();
    ((CustomEmotionData)localObject).uin = paramQQAppInterface.getCurrentAccountUin();
    ((CustomEmotionData)localObject).emoId = (i1 + 1);
    ((CustomEmotionData)localObject).emoPath = paramString;
    ((CustomEmotionData)localObject).md5 = str;
    if ((paramPicMessageExtraData != null) && (paramPicMessageExtraData.isDiyDouTu())) {
      ((CustomEmotionData)localObject).eId = paramPicMessageExtraData.emojiPkgId;
    }
    localIFavroamingDBManagerService.insertCustomEmotion((CustomEmotionData)localObject);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(AppConstants.SDCARD_EMOTIOCN_DIY))) {
      ReportController.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
    }
    a(paramQQAppInterface, paramStructMsgForImageShare, (CustomEmotionData)localObject);
    paramQQAppInterface = (IFavroamingManagerService)paramQQAppInterface.getRuntimeService(IFavroamingManagerService.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.syncUpload((CustomEmotionData)localObject);
    }
    return 0;
  }
  
  public static void b()
  {
    ThreadManager.post(new EmojiStickerManager.2(), 5, null, false);
  }
  
  private void b(Messenger paramMessenger, boolean paramBoolean)
  {
    if (paramMessenger != null) {}
    for (;;)
    {
      try
      {
        localObject = android.os.Message.obtain(null, 4);
        if (paramMessenger != null)
        {
          Bundle localBundle1 = new Bundle();
          localBundle1.putString("cmd", "emojiStickerRecall");
          localBundle1.putString("callbackid", y);
          localBundle1.putInt("respkey", z);
          Bundle localBundle2 = new Bundle();
          if (!paramBoolean) {
            break label232;
          }
          i1 = 0;
          localBundle2.putInt("result", i1);
          AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
          if ((localAppRuntime instanceof QQAppInterface)) {
            localBundle2.putString("QQ", ((QQAppInterface)localAppRuntime).getCurrentUin());
          }
          i1 = -1;
          if (this.h == 0) {
            i1 = 1;
          } else if (this.h == 1) {
            i1 = 2;
          } else if (this.h == 3000) {
            i1 = 3;
          }
          localBundle2.putInt("chatType", i1);
          localBundle1.putBundle("response", localBundle2);
          ((android.os.Message)localObject).setData(localBundle1);
          paramMessenger.send((android.os.Message)localObject);
        }
      }
      catch (RemoteException paramMessenger)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sendEmojiStickerRecallResponse e =");
        ((StringBuilder)localObject).append(paramMessenger);
        QLog.e("EmojiStickerManager", 1, ((StringBuilder)localObject).toString());
      }
      x = false;
      return;
      label232:
      int i1 = -2;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = AIOGallerySceneWithBusiness.c(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      IVipComicMqqManagerService localIVipComicMqqManagerService = (IVipComicMqqManagerService)paramQQAppInterface.getRuntimeService(IVipComicMqqManagerService.class);
      paramQQAppInterface = new VipComicFavorEmoStructMsgInfo();
      paramQQAppInterface.picMd5 = paramCustomEmotionData.md5;
      paramQQAppInterface.actionData = paramStructMsgForImageShare;
      if (!paramQQAppInterface.equals(localIVipComicMqqManagerService.getComicStructInfo(paramCustomEmotionData.md5)))
      {
        paramStructMsgForImageShare = new ArrayList();
        paramStructMsgForImageShare.add(paramQQAppInterface);
        localIVipComicMqqManagerService.setMyComicEmoticon(paramStructMsgForImageShare, true);
        if (QLog.isColorLevel())
        {
          paramStructMsgForImageShare = new StringBuilder();
          paramStructMsgForImageShare.append("handleOldComicStructMsg , emoStructMsgInfo = ");
          paramStructMsgForImageShare.append(paramQQAppInterface);
          QLog.d("EmojiStickerManager", 2, paramStructMsgForImageShare.toString());
        }
      }
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap)
  {
    Object localObject = new ArrayList();
    b(paramQQAppInterface, paramList, paramHashMap, (List)localObject);
    if (((List)localObject).size() > 0)
    {
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putString("key", "DeleteHide");
      paramQQAppInterface.putInt("sessionType", this.h);
      this.m.add(paramQQAppInterface);
    }
    paramQQAppInterface = ((List)localObject).iterator();
    while (paramQQAppInterface.hasNext())
    {
      paramHashMap = (MessageForUniteGrayTip)paramQQAppInterface.next();
      int i1 = 0;
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (localMessageRecord.shmsgseq > paramHashMap.shmsgseq)
        {
          paramHashMap.time = (localMessageRecord.time - 10L);
          break;
        }
        i1 += 1;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("insert unfind gray tips:  host seq: ");
        ((StringBuilder)localObject).append(paramHashMap.shmsgseq);
        ((StringBuilder)localObject).append(", list pos: ");
        ((StringBuilder)localObject).append(i1);
        QLog.i("EmojiStickerManager", 2, ((StringBuilder)localObject).toString());
      }
      paramList.add(i1, paramHashMap);
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap, List<MessageForUniteGrayTip> paramList1)
  {
    if (paramList.size() > 0) {
      paramList = (MessageRecord)paramList.get(0);
    } else {
      paramList = null;
    }
    long l1;
    if (paramList != null) {
      l1 = paramList.shmsgseq;
    } else {
      l1 = 9223372036854775807L;
    }
    long l2 = paramQQAppInterface.getMsgCache().b(this.g, this.h);
    paramList = paramHashMap.keySet().iterator();
    while (paramList.hasNext())
    {
      Pair localPair1 = (Pair)paramList.next();
      Object localObject1 = (List)paramHashMap.get(localPair1);
      if (localObject1 != null) {
        if (((List)localObject1).size() != 0)
        {
          MessageRecord localMessageRecord1 = (MessageRecord)((List)localObject1).get(0);
          Object localObject2 = d(localMessageRecord1);
          if (localObject2 != null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("unFind msg: shmsgseq: ");
              ((StringBuilder)localObject1).append(((StickerInfo)localObject2).hostMsgSeq);
              ((StringBuilder)localObject1).append(", isDisplay: ");
              ((StringBuilder)localObject1).append(((StickerInfo)localObject2).isDisplayed);
              ((StringBuilder)localObject1).append(", hostTime: ");
              ((StringBuilder)localObject1).append(((StickerInfo)localObject2).hostMsgTime);
              QLog.i("EmojiStickerManager", 2, ((StringBuilder)localObject1).toString());
            }
            int i1;
            if ((!this.D.containsKey(localPair1)) && (((Long)localPair1.first).longValue() <= l1)) {
              i1 = 0;
            } else {
              i1 = 1;
            }
            if (i1 == 0)
            {
              localObject1 = paramQQAppInterface.getMessageProxy(this.h).d(this.g, this.h);
              if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
                if (((StickerInfo)localObject2).hostMsgSeq < ((MessageRecord)((List)localObject1).get(0)).shmsgseq)
                {
                  if (((StickerInfo)localObject2).hostMsgSeq <= l2) {
                    i1 = 1;
                  }
                }
                else
                {
                  localObject1 = ((List)localObject1).iterator();
                  while (((Iterator)localObject1).hasNext())
                  {
                    MessageRecord localMessageRecord2 = (MessageRecord)((Iterator)localObject1).next();
                    if (localMessageRecord2.shmsgseq >= l1) {
                      break;
                    }
                    if (localMessageRecord2.msgtype == -2006)
                    {
                      Pair localPair2 = f(localMessageRecord2);
                      if (localPair2 != null) {
                        this.D.put(localPair2, Boolean.valueOf(true));
                      }
                    }
                    int i2;
                    if ((localMessageRecord2.shmsgseq == ((StickerInfo)localObject2).hostMsgSeq) && (!MsgProxyUtils.a(localMessageRecord2)))
                    {
                      if (localMessageRecord2.msgtype == -2006) {
                        i1 = 1;
                      } else {
                        i1 = 0;
                      }
                      i2 = i1;
                      if (i1 == 0) {
                        break;
                      }
                    }
                    else
                    {
                      i2 = i1;
                    }
                    if ((i2 != 0) && (g(localMessageRecord2)))
                    {
                      i1 = 0;
                      break;
                    }
                    i1 = i2;
                  }
                }
              }
            }
            if (i1 != 0)
            {
              localObject1 = new MessageForUniteGrayTip();
              localObject2 = BaseApplicationImpl.getApplication().getString(2131916785);
              ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQAppInterface, new UniteGrayTipParam(localMessageRecord1.frienduin, localMessageRecord1.senderuin, (String)localObject2, this.h, -5040, 1, localMessageRecord1.time));
              ((MessageForUniteGrayTip)localObject1).shmsgseq = ((Long)localPair1.first).longValue();
              ((MessageForUniteGrayTip)localObject1).msgUid = ((Long)localPair1.second).longValue();
              ((MessageForUniteGrayTip)localObject1).mNeedTimeStamp = false;
              paramList1.add(localObject1);
            }
          }
        }
      }
    }
  }
  
  protected static void b(StringBuilder paramStringBuilder, int paramInt)
  {
    char[] arrayOfChar = new char[4];
    int i1 = paramStringBuilder.charAt(paramInt + 4);
    int i3 = 0;
    arrayOfChar[0] = i1;
    arrayOfChar[1] = paramStringBuilder.charAt(paramInt + 3);
    i1 = paramStringBuilder.charAt(paramInt + 2);
    int i4 = 2;
    arrayOfChar[2] = i1;
    arrayOfChar[3] = paramStringBuilder.charAt(paramInt + 1);
    int i2;
    for (;;)
    {
      i2 = i4;
      if (i3 >= 3) {
        break;
      }
      if (arrayOfChar[i3] == 'ú') {
        arrayOfChar[i3] = '\n';
      } else if (arrayOfChar[i3] == 'þ') {
        arrayOfChar[i3] = '\r';
      }
      i3 += 1;
    }
    while (i2 < 5)
    {
      i3 = paramInt + i2;
      if (paramStringBuilder.charAt(i3) == '\n') {
        paramStringBuilder.setCharAt(i3, 'ú');
      } else if (paramStringBuilder.charAt(i3) == '\r') {
        paramStringBuilder.setCharAt(i3, 'þ');
      }
      i2 += 1;
    }
  }
  
  private boolean b(long paramLong, boolean paramBoolean, StickerInfo paramStickerInfo)
  {
    if (paramStickerInfo.hostMsgSeq < paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmojiStickerManager", 2, "need insert unRead tips!");
      }
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public static String c()
  {
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(BaseApplicationImpl.getApplication().getDir(".emojiSticker_v2.1", 0).getAbsoluteFile());
      ((StringBuilder)localObject).append(File.separator);
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      Object localObject;
      label41:
      break label41;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(BaseApplicationImpl.getApplication().getDir(".emojiSticker_v2.1", 0).getAbsoluteFile());
    ((StringBuilder)localObject).append(File.separator);
    return ((StringBuilder)localObject).toString();
  }
  
  private void c(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap)
  {
    Object localObject1;
    Object localObject2;
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      Iterator localIterator1 = paramHashMap.keySet().iterator();
      Object localObject3 = null;
      localObject1 = localObject3;
      localObject2 = localObject1;
      int i2 = 0;
      int i1 = 0;
      do
      {
        i4 = i2;
        localObject6 = localObject3;
        localObject5 = localObject1;
        localObject4 = localObject2;
        i3 = i1;
        if (!localIterator1.hasNext()) {
          break;
        }
        localObject5 = (List)paramHashMap.get((Pair)localIterator1.next());
      } while ((localObject5 == null) || (((List)localObject5).size() == 0));
      i4 = i2 + ((List)localObject5).size();
      localObject4 = localObject2;
      if (localObject2 == null) {
        localObject4 = (MessageRecord)((List)localObject5).get(0);
      }
      Iterator localIterator2 = ((List)localObject5).iterator();
      i3 = i1;
      localObject6 = localObject1;
      localObject5 = localObject3;
      for (;;)
      {
        i2 = i4;
        localObject3 = localObject5;
        localObject1 = localObject6;
        localObject2 = localObject4;
        i1 = i3;
        if (!localIterator2.hasNext()) {
          break;
        }
        localObject1 = (ChatMessage)localIterator2.next();
        if ((localObject5 == null) && (!((ChatMessage)localObject1).senderuin.equals(localObject5))) {
          localObject5 = ((ChatMessage)localObject1).senderuin;
        } else if ((localObject6 == null) && (!((ChatMessage)localObject1).senderuin.equals(localObject5))) {
          localObject6 = ((ChatMessage)localObject1).senderuin;
        } else if ((localObject5 != null) && (localObject6 != null)) {
          i3 = 1;
        }
      }
    }
    Object localObject6 = null;
    paramHashMap = (HashMap<Pair<Long, Long>, List<ChatMessage>>)localObject6;
    Object localObject4 = paramHashMap;
    int i4 = 0;
    int i3 = 0;
    Object localObject5 = paramHashMap;
    if ((i4 > 0) && (localObject4 != null))
    {
      paramHashMap = a(paramQQAppInterface, ((MessageRecord)localObject4).frienduin, ((MessageRecord)localObject4).istroop, (String)localObject6);
      localObject1 = a(paramQQAppInterface, ((MessageRecord)localObject4).frienduin, ((MessageRecord)localObject4).istroop, (String)localObject5);
      if ((i4 != 1) && (!TextUtils.isEmpty(paramHashMap)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramHashMap);
        ((StringBuilder)localObject2).append("、");
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = ((StringBuilder)localObject2).toString();
        paramHashMap = (HashMap<Pair<Long, Long>, List<ChatMessage>>)localObject1;
        if (i3 != 0)
        {
          paramHashMap = new StringBuilder();
          paramHashMap.append((String)localObject1);
          paramHashMap.append(HardCodeUtil.a(2131902065));
          paramHashMap = paramHashMap.toString();
        }
      }
      else if (TextUtils.isEmpty(paramHashMap))
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramHashMap = (HashMap<Pair<Long, Long>, List<ChatMessage>>)localObject1;
        } else {
          paramHashMap = "";
        }
      }
      paramHashMap = String.format("%s在上面贴了%d个表情", new Object[] { paramHashMap, Integer.valueOf(i4) });
      localObject2 = new UniteGrayTipParam(((MessageRecord)localObject4).frienduin, paramQQAppInterface.getCurrentAccountUin(), paramHashMap, ((MessageRecord)localObject4).istroop, -5023, 1179651, ((MessageRecord)localObject4).time);
      localObject1 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject2);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("insert gray tips for sticker msg! ");
        paramQQAppInterface.append(paramHashMap);
        QLog.i("EmojiStickerManager", 2, paramQQAppInterface.toString());
      }
      ((MessageForUniteGrayTip)localObject1).isread = true;
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putString("key", "NotGetTip");
      paramQQAppInterface.putInt("sessionType", this.h);
      this.m.add(paramQQAppInterface);
      paramList.add(localObject1);
    }
  }
  
  public static StickerInfo d(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.msgtype == -2058)) {
      if ((paramMessageRecord instanceof MessageForMarketFace))
      {
        paramMessageRecord = (MessageForMarketFace)paramMessageRecord;
        if ((paramMessageRecord != null) && (paramMessageRecord.mMarkFaceMessage != null)) {
          return paramMessageRecord.mMarkFaceMessage.stickerInfo;
        }
      }
      else if (((paramMessageRecord instanceof MessageForText)) || ((paramMessageRecord instanceof MessageForPic)))
      {
        Object localObject = (StickerInfo)paramMessageRecord.stickerInfo;
        if (localObject != null) {
          return localObject;
        }
        localObject = paramMessageRecord.getExtInfoFromExtStr("sticker_info");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = StickerInfo.transformFromJson((String)localObject);
          paramMessageRecord.stickerInfo = localObject;
          return localObject;
        }
      }
    }
    return null;
  }
  
  public static boolean d()
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
  
  public static boolean e(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForMarketFace)) || (((paramMessageRecord instanceof MessageForText)) && (paramMessageRecord.msgtype == -1000)) || ((paramMessageRecord instanceof MessageForPic));
  }
  
  public static Pair<Long, Long> f(MessageRecord paramMessageRecord)
  {
    Object localObject2 = null;
    if (paramMessageRecord == null) {
      return null;
    }
    Object localObject3;
    Object localObject1;
    if (paramMessageRecord.msgtype == -2058)
    {
      localObject3 = d(paramMessageRecord);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        if (paramMessageRecord.istroop == 0) {
          return new Pair(Long.valueOf(((StickerInfo)localObject3).hostMsgSeq), Long.valueOf(((StickerInfo)localObject3).hostMsgUid));
        }
        return new Pair(Long.valueOf(((StickerInfo)localObject3).hostMsgSeq), Long.valueOf(0L));
      }
    }
    else
    {
      if (paramMessageRecord.msgtype == -2006)
      {
        if (paramMessageRecord.istroop == 0) {
          return new Pair(Long.valueOf(paramMessageRecord.shmsgseq), Long.valueOf(paramMessageRecord.msgUid));
        }
        return new Pair(Long.valueOf(paramMessageRecord.shmsgseq), Long.valueOf(0L));
      }
      if (g(paramMessageRecord))
      {
        if (paramMessageRecord.istroop == 0) {
          return new Pair(Long.valueOf(paramMessageRecord.shmsgseq), Long.valueOf(paramMessageRecord.msgUid));
        }
        return new Pair(Long.valueOf(paramMessageRecord.shmsgseq), Long.valueOf(0L));
      }
      localObject1 = localObject2;
      if ((paramMessageRecord instanceof MessageForUniteGrayTip))
      {
        localObject3 = (MessageForUniteGrayTip)paramMessageRecord;
        localObject1 = localObject2;
        if (((MessageForUniteGrayTip)localObject3).tipParam != null)
        {
          localObject1 = localObject2;
          if (((MessageForUniteGrayTip)localObject3).tipParam.i == 1)
          {
            if (paramMessageRecord.istroop == 0) {
              return new Pair(Long.valueOf(paramMessageRecord.shmsgseq), Long.valueOf(paramMessageRecord.msgUid));
            }
            localObject1 = new Pair(Long.valueOf(paramMessageRecord.shmsgseq), Long.valueOf(0L));
          }
        }
      }
    }
    return localObject1;
  }
  
  public static boolean g(MessageRecord paramMessageRecord)
  {
    int i1 = paramMessageRecord.msgtype;
    boolean bool = ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).isRedPacketMsg(paramMessageRecord);
    return (i1 == -1000) || (i1 == -2011) || (i1 == -2039) || ((i1 == -2025) && (bool)) || (i1 == -2007) || (i1 == -2000) || (i1 == -2002) || (i1 == -2022) || (i1 == -1035) || (i1 == -1049);
  }
  
  public static boolean h(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForMarketFace)) || ((paramMessageRecord instanceof MessageForText)) || ((paramMessageRecord instanceof MessageForPic));
  }
  
  public static boolean i(MessageRecord paramMessageRecord)
  {
    boolean bool2 = true;
    if (paramMessageRecord != null)
    {
      bool1 = bool2;
      if (paramMessageRecord.istroop == 0) {
        return bool1;
      }
      bool1 = bool2;
      if (paramMessageRecord.istroop == 1) {
        return bool1;
      }
      if (paramMessageRecord.istroop == 3000) {
        return true;
      }
    }
    boolean bool1 = false;
    return bool1;
  }
  
  public Drawable a(Context paramContext)
  {
    Drawable localDrawable2 = this.H;
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 == null) {
      localDrawable1 = paramContext.getResources().getDrawable(2130840107);
    }
    return localDrawable1;
  }
  
  public URLDrawable a(Context paramContext, Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return null;
    }
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    try
    {
      paramContext = new StringBuilder();
      paramContext.append(paramEmoticon.epId);
      paramContext.append("_");
      paramContext.append(paramEmoticon.eId);
      paramContext = new URL("emotion_pic", "fromAIO", paramContext.toString());
    }
    catch (MalformedURLException paramContext)
    {
      paramEmoticon = new StringBuilder();
      paramEmoticon.append("getStickerDrawable url exception e = ");
      paramEmoticon.append(paramContext.getMessage());
      QLog.e("EmojiStickerManager", 1, paramEmoticon.toString());
      paramContext = null;
    }
    if (paramContext == null)
    {
      QLog.e("EmojiStickerManager", 1, "getStickerDrawable url = null");
      return null;
    }
    int i1 = (int)(f1 * 110.0F);
    paramEmoticon = this.I;
    return URLDrawable.getDrawable(paramContext, i1, i1, paramEmoticon, paramEmoticon, true);
  }
  
  protected EmoticonInfo a(int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
  {
    int i4 = paramInt1 + 1;
    int i3 = paramStringBuilder.charAt(i4);
    if (i3 >= 255)
    {
      int i2 = paramInt1 + 4;
      if (i2 < paramInt2)
      {
        Object localObject = new char[4];
        int i1 = paramStringBuilder.charAt(i2);
        i2 = 0;
        localObject[0] = i1;
        localObject[1] = paramStringBuilder.charAt(paramInt1 + 3);
        localObject[2] = paramStringBuilder.charAt(paramInt1 + 2);
        localObject[3] = paramStringBuilder.charAt(i4);
        paramInt1 = 0;
        while (paramInt1 < 3)
        {
          if (localObject[paramInt1] == 'ú') {
            localObject[paramInt1] = 10;
          } else if (localObject[paramInt1] == 'þ') {
            localObject[paramInt1] = 13;
          }
          paramInt1 += 1;
        }
        boolean bool1;
        if (i3 == 511) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        paramStringBuilder = ((ISmallEmoticonInfoService)QRoute.api(ISmallEmoticonInfoService.class)).createSmallEmoticonInfo(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        Emoticon localEmoticon = new Emoticon();
        localObject = EmosmUtils.a((char[])localObject);
        if ((localObject != null) && (localObject.length == 2))
        {
          paramInt1 = localObject[0];
          paramInt2 = localObject[1];
        }
        else
        {
          paramInt2 = 0;
          paramInt1 = i2;
        }
        localEmoticon.eId = String.valueOf(paramInt2);
        localEmoticon.epId = String.valueOf(paramInt1);
        localEmoticon.jobType = 3;
        paramStringBuilder.setEmoticon(localEmoticon);
        boolean bool2 = bool1;
        if (!bool1)
        {
          localObject = EmoticonPanelUtils.d();
          bool2 = bool1;
          if (localObject != null)
          {
            localObject = ((IEmoticonManagerService)localObject).syncFindEmoticonPackageById(String.valueOf(paramInt1));
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
        paramStringBuilder.setIsAPNG(bool2);
        return (EmoticonInfo)paramStringBuilder;
      }
    }
    if (i3 == 250) {
      return new SystemAndEmojiEmoticonInfo(7, 1, 10, "", false);
    }
    return new SystemAndEmojiEmoticonInfo(7, 1, i3, "", false);
  }
  
  public EmoticonInfo a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i2 = 0;
      int i5 = paramString.length();
      int i6 = paramString.length();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      while (i2 < i5)
      {
        int i7 = localStringBuilder.codePointAt(i2);
        if ((i7 == 20) && (i2 < i6 - 1)) {
          return a(i2, i6, localStringBuilder);
        }
        int i4 = EmotcationConstants.getSingleEmoji(i7);
        int i3;
        if (i7 > 65535)
        {
          i1 = i2 + 2;
          if (i6 > i1)
          {
            i1 = localStringBuilder.codePointAt(i1);
            break label166;
          }
        }
        else
        {
          i1 = i2 + 1;
          if (i6 > i1)
          {
            i3 = localStringBuilder.codePointAt(i1);
            i1 = i3;
            if (i3 != 65039) {
              break label166;
            }
            int i8 = i2 + 2;
            i1 = i3;
            if (i6 <= i8) {
              break label166;
            }
            i1 = localStringBuilder.codePointAt(i8);
            break label166;
          }
        }
        int i1 = -1;
        label166:
        boolean bool = EmotcationConstants.isSkinEmoji(i1);
        if (i4 != -1)
        {
          i3 = i4;
          if (bool) {}
        }
        for (;;)
        {
          break;
          i3 = EmotcationConstants.getDoubleEmoji(i7, i1);
          if (i3 == -1) {
            i3 = i4;
          }
        }
        if (i3 != -1) {
          return new SystemAndEmojiEmoticonInfo(7, 2, i3, "", false);
        }
        i2 += 1;
      }
    }
    return null;
  }
  
  public void a(Messenger paramMessenger, boolean paramBoolean)
  {
    if (x) {
      b(paramMessenger, paramBoolean);
    }
  }
  
  public void a(View paramView)
  {
    f = (ViewGroup)paramView.getParent();
    paramView = f;
    if ((paramView instanceof BaseChatItemLayout))
    {
      paramView = (BaseChatItemLayout)paramView;
      if (paramView.am != null)
      {
        Iterator localIterator = paramView.am.iterator();
        while (localIterator.hasNext())
        {
          EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)localIterator.next();
          if (localSticker.h == 255) {
            localSticker.h = 127;
          }
        }
        paramView.invalidate();
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.g = paramBaseChatPie.ah.b;
    this.h = paramBaseChatPie.ah.a;
    this.i = paramBaseChatPie.d.getConversationFacade().a(this.g, this.h);
    this.j = paramBaseChatPie.d.getConversationFacade().e(this.g, this.h);
    this.l = paramBaseChatPie.d.getMsgCache().b(this.g, this.h);
    if (QLog.isColorLevel())
    {
      paramBaseChatPie = new StringBuilder();
      paramBaseChatPie.append("init, unReadCnt: ");
      paramBaseChatPie.append(this.i);
      paramBaseChatPie.append(", mInitLastReadSeq: ");
      paramBaseChatPie.append(this.j);
      QLog.i("EmojiStickerManager", 2, paramBaseChatPie.toString());
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, String paramString, int paramInt, boolean paramBoolean)
  {
    ((EmojiStickerHelper)paramBaseChatPie.q(133)).b();
    this.g = "";
    this.h = 0;
    this.i = 0;
    x = false;
    y = "";
    z = -1;
    f = null;
    List localList = paramBaseChatPie.d.getMessageProxy(paramInt).g(paramString, paramInt);
    ThreadManager.post(new EmojiStickerManager.1(this, localList, paramString, paramInt, paramBoolean), 5, null, false);
    if (paramBaseChatPie.aZ != null)
    {
      paramString = (TopGestureLayout)paramBaseChatPie.aZ;
      GestureDetector localGestureDetector = paramString.getGestureDetector();
      if ((localGestureDetector instanceof StickerGestureDetector))
      {
        paramString.removeView(((StickerGestureDetector)localGestureDetector).popupEmo);
        a = false;
        paramBaseChatPie.l(false);
        paramBaseChatPie.l(false);
      }
      paramString.restoreGestureDetector();
    }
    a(localList);
    this.j = -9223372036854775808L;
    this.k = -9223372036854775808L;
    this.l = -9223372036854775808L;
  }
  
  public void a(BaseChatPie paramBaseChatPie, List<ChatMessage> paramList)
  {
    a(paramBaseChatPie.d, paramBaseChatPie.U, paramBaseChatPie.ah.b, paramBaseChatPie.ah.a, paramBaseChatPie.bv().e().b().f(), paramList);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, ChatXListView paramChatXListView, int paramInt, List<ChatMessage> paramList, HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap, long paramLong, boolean paramBoolean)
  {
    if ((paramList.size() != 0) && (paramChatXListView.getChildCount() != 0) && (paramBoolean) && (this.i > 0)) {
      a(paramQQAppInterface, paramInt, paramList, paramLong);
    }
    if ((paramHashMap != null) && (paramHashMap.size() > 0)) {
      if (paramList.size() > 0)
      {
        if (paramChatXListView.getChildCount() > 0)
        {
          if (this.h != 0)
          {
            b(paramQQAppInterface, paramList, paramHashMap);
            return;
          }
          a(paramQQAppInterface, paramList, paramHashMap);
        }
      }
      else {
        a(paramList, paramQQAppInterface, paramHashMap);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ChatXListView paramChatXListView, String paramString, int paramInt1, int paramInt2, List<ChatMessage> paramList)
  {
    this.g = paramString;
    this.h = paramInt1;
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (paramChatXListView == null) {
        return;
      }
      long l7 = System.currentTimeMillis();
      this.B.clear();
      this.E.clear();
      int i1 = paramList.size() - 1;
      paramString = null;
      int i2 = 0;
      boolean bool1 = false;
      long l2 = -9223372036854775808L;
      long l4 = -9223372036854775808L;
      long l3 = -9223372036854775808L;
      long l9;
      for (long l1 = -9223372036854775808L;; l1 = l9)
      {
        Object localObject1 = paramList;
        if (i1 < 0) {
          break;
        }
        ChatMessage localChatMessage = (ChatMessage)((List)localObject1).get(i1);
        Object localObject2;
        if (localChatMessage == null)
        {
          l6 = l3;
        }
        else
        {
          a(localChatMessage);
          if ((localChatMessage.msgtype != -2058) || (!i(localChatMessage))) {
            break label564;
          }
          if ((l4 == -9223372036854775808L) && (l3 == -9223372036854775808L) && (paramChatXListView.getAdapter() != null))
          {
            localObject2 = a(paramChatXListView, (List)localObject1);
            l3 = ((MessageRecord)localObject2).shmsgseq;
            l4 = ((MessageRecord)localObject2).time;
          }
          else
          {
            l5 = l3;
            l3 = l4;
            l4 = l5;
          }
          localObject2 = d(localChatMessage);
          if (!a((List)localObject1, localChatMessage, (StickerInfo)localObject2)) {
            break label268;
          }
          l6 = l4;
          l4 = l3;
        }
        paramInt1 = i2;
        localObject1 = paramString;
        boolean bool2 = bool1;
        long l8 = l2;
        long l5 = l4;
        l9 = l1;
        break label635;
        label268:
        if (!((StickerInfo)localObject2).isDisplayed)
        {
          paramInt1 = this.h;
          if (paramInt1 == 0)
          {
            if (localChatMessage.time > this.j)
            {
              this.E.add(localChatMessage);
              if (l1 != -9223372036854775808L)
              {
                l6 = l2;
                l5 = l1;
                if (((StickerInfo)localObject2).hostMsgTime >= l1) {}
              }
              else
              {
                l6 = l2;
                l5 = l1;
                if (((StickerInfo)localObject2).hostMsgTime > this.l)
                {
                  if (QLog.isColorLevel())
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("new navigate seq: ");
                    ((StringBuilder)localObject1).append(((StickerInfo)localObject2).hostMsgSeq);
                    QLog.i("EmojiStickerManager", 2, ((StringBuilder)localObject1).toString());
                  }
                  l5 = ((StickerInfo)localObject2).hostMsgTime;
                  l6 = ((StickerInfo)localObject2).hostMsgSeq;
                }
              }
              bool1 = a(l4, bool1, (StickerInfo)localObject2);
              l2 = l6;
              l1 = l5;
            }
            else
            {
              ((StickerInfo)localObject2).isDisplayed = true;
              break label525;
            }
          }
          else
          {
            if ((paramInt1 != 1) && (paramInt1 != 3000)) {
              break label525;
            }
            if (localChatMessage.shmsgseq <= this.j) {
              break label516;
            }
            this.E.add(localChatMessage);
            l2 = a(l2, (StickerInfo)localObject2);
            bool1 = b(l3, bool1, (StickerInfo)localObject2);
          }
          break label525;
          ((StickerInfo)localObject2).isDisplayed = true;
        }
        label516:
        label525:
        localObject1 = a(paramString, localChatMessage);
        paramInt1 = ((HashMap)localObject1).size();
        bool2 = bool1;
        l8 = l2;
        l5 = l3;
        long l6 = l4;
        l9 = l1;
        break label635;
        label564:
        paramInt1 = i2;
        localObject1 = paramString;
        bool2 = bool1;
        l8 = l2;
        l5 = l4;
        l6 = l3;
        l9 = l1;
        if (i2 > 0)
        {
          paramString.remove(f(localChatMessage));
          paramInt1 = paramString.size();
          l9 = l1;
          l6 = l3;
          l5 = l4;
          l8 = l2;
          bool2 = bool1;
          localObject1 = paramString;
        }
        label635:
        i1 -= 1;
        i2 = paramInt1;
        paramString = (String)localObject1;
        bool1 = bool2;
        l2 = l8;
        l4 = l5;
        l3 = l6;
      }
      a(paramQQAppInterface, paramChatXListView, paramInt2, paramList, paramString, l2, bool1);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("removeStickerMsgAndInsertGrayTips, cost=");
        paramQQAppInterface.append(System.currentTimeMillis() - l7);
        QLog.i("EmojiStickerManager", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.msgtype == -2058) && (n))
    {
      Object localObject = d(paramMessageRecord);
      Pair localPair = f(paramMessageRecord);
      if ((localObject != null) && (localPair != null))
      {
        ArrayList localArrayList = (ArrayList)this.B.get(localPair);
        localObject = localArrayList;
        if (localArrayList == null) {
          localObject = new ArrayList();
        }
        if (!((ArrayList)localObject).contains(Long.valueOf(paramMessageRecord.uniseq))) {
          ((ArrayList)localObject).add(Long.valueOf(paramMessageRecord.uniseq));
        }
        this.B.put(localPair, localObject);
      }
    }
  }
  
  public void b(BaseChatPie paramBaseChatPie)
  {
    List localList = paramBaseChatPie.V.a();
    if (localList != null)
    {
      if (localList.size() <= 0) {
        return;
      }
      System.currentTimeMillis();
      ChatXListView localChatXListView = paramBaseChatPie.U;
      long l2 = 9223372036854775807L;
      long l3 = -9223372036854775808L;
      Object localObject;
      long l4;
      long l1;
      if ((localChatXListView != null) && (localChatXListView.getAdapter() != null))
      {
        paramBaseChatPie = localChatXListView.getAdapter();
        int i1 = localChatXListView.getChildCount();
        localObject = null;
        if (i1 > 0)
        {
          int i2;
          if ((paramBaseChatPie instanceof HeaderViewListAdapter))
          {
            i2 = localChatXListView.getFirstVisiblePosition();
            i1 = localChatXListView.getLastVisiblePosition();
          }
          else if ((paramBaseChatPie instanceof ChatAdapter1))
          {
            i2 = localChatXListView.getFirstVisiblePosition() - localChatXListView.getHeaderViewsCount();
            i1 = localChatXListView.getLastVisiblePosition() - localChatXListView.getFooterViewsCount();
          }
          else
          {
            i1 = 0;
            i2 = 0;
          }
          if ((i2 < 0) || (i2 >= paramBaseChatPie.getCount())) {
            i2 = 0;
          }
          if ((i1 < 0) || (i1 >= paramBaseChatPie.getCount())) {
            i1 = 0;
          }
          localObject = paramBaseChatPie.getItem(i2);
          paramBaseChatPie = paramBaseChatPie.getItem(i1);
        }
        else
        {
          paramBaseChatPie = null;
        }
        if ((localObject instanceof MessageRecord)) {
          localObject = (MessageRecord)localObject;
        } else {
          localObject = (MessageRecord)localList.get(0);
        }
        if ((paramBaseChatPie instanceof MessageRecord)) {
          paramBaseChatPie = (MessageRecord)paramBaseChatPie;
        } else {
          paramBaseChatPie = (MessageRecord)localList.get(localList.size() - 1);
        }
        l4 = ((MessageRecord)localObject).shmsgseq;
        l3 = ((MessageRecord)localObject).time;
        l1 = paramBaseChatPie.shmsgseq;
        l2 = paramBaseChatPie.time;
      }
      else
      {
        l1 = 9223372036854775807L;
        l4 = -9223372036854775808L;
      }
      paramBaseChatPie = localList.iterator();
      while (paramBaseChatPie.hasNext())
      {
        localObject = (ChatMessage)paramBaseChatPie.next();
        if (((ChatMessage)localObject).istroop == 0)
        {
          if ((((ChatMessage)localObject).time < l3) || (((ChatMessage)localObject).time > l2)) {
            ((ChatMessage)localObject).stickerHidden = false;
          }
        }
        else if (((((ChatMessage)localObject).istroop == 1) || (((ChatMessage)localObject).istroop == 3000)) && ((((ChatMessage)localObject).shmsgseq < l4) || (((ChatMessage)localObject).shmsgseq > l1))) {
          ((ChatMessage)localObject).stickerHidden = false;
        }
      }
      System.currentTimeMillis();
    }
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.msgtype == -2058) && (n) && (d(paramMessageRecord) != null))
    {
      Object localObject;
      if ((paramMessageRecord.frienduin.equalsIgnoreCase(this.g)) && (this.h == paramMessageRecord.istroop))
      {
        this.i = 0;
        localObject = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject instanceof QQAppInterface)) {
          this.j = ((QQAppInterface)localObject).getConversationFacade().e(this.g, this.h);
        }
      }
      Pair localPair = f(paramMessageRecord);
      if (localPair != null)
      {
        ArrayList localArrayList = (ArrayList)this.C.get(localPair);
        localObject = localArrayList;
        if (localArrayList == null) {
          localObject = new ArrayList();
        }
        if ((!((ArrayList)localObject).contains(Long.valueOf(paramMessageRecord.uniseq))) && (((ArrayList)localObject).size() < QVipStickerProcessor.c)) {
          ((ArrayList)localObject).add(Long.valueOf(paramMessageRecord.uniseq));
        }
        if (paramMessageRecord.istroop == 1) {
          paramMessageRecord = "2";
        } else if (paramMessageRecord.istroop == 3000) {
          paramMessageRecord = "3";
        } else {
          paramMessageRecord = "1";
        }
        VasWebviewUtil.a("", "Stick", "Receive", paramMessageRecord, 1, 0, 0, null, "", "");
        this.C.put(localPair, localObject);
      }
    }
  }
  
  public List<Long> c(MessageRecord paramMessageRecord)
  {
    if ((n) && (paramMessageRecord != null) && (paramMessageRecord.shmsgseq != 0L) && (paramMessageRecord.extraflag != 32772) && (paramMessageRecord.extraflag != 32768) && (!paramMessageRecord.isMultiMsg))
    {
      if (paramMessageRecord.isReMultiMsg) {
        return null;
      }
      paramMessageRecord = f(paramMessageRecord);
      if (paramMessageRecord != null) {
        return (List)this.B.get(paramMessageRecord);
      }
    }
    return null;
  }
  
  public void c(BaseChatPie paramBaseChatPie)
  {
    if ((paramBaseChatPie != null) && (paramBaseChatPie.aZ != null) && ((paramBaseChatPie.aZ instanceof TopGestureLayout)))
    {
      TopGestureLayout localTopGestureLayout = (TopGestureLayout)paramBaseChatPie.aZ;
      if (!(localTopGestureLayout.getGestureDetector() instanceof StickerGestureDetector)) {
        localTopGestureLayout.setGestureDetector(new StickerGestureDetector(paramBaseChatPie.e, localTopGestureLayout.getGestureListener(), paramBaseChatPie));
      }
    }
  }
  
  public void e()
  {
    Object localObject = f;
    if ((localObject instanceof BaseChatItemLayout))
    {
      localObject = (BaseChatItemLayout)localObject;
      if (((BaseChatItemLayout)localObject).am != null)
      {
        Iterator localIterator = ((BaseChatItemLayout)localObject).am.iterator();
        while (localIterator.hasNext())
        {
          EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)localIterator.next();
          if (localSticker.h != 0) {
            localSticker.h = 255;
          }
        }
        ((BaseChatItemLayout)localObject).invalidate();
      }
    }
    f = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiStickerManager
 * JD-Core Version:    0.7.0.1
 */