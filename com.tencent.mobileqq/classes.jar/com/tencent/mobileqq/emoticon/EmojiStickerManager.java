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
  public static float a = 0.01F;
  public static View a;
  private static final EmojiStickerManager jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager = new EmojiStickerManager();
  public static boolean a = false;
  public static String b = "";
  public static boolean b = false;
  public static int c = 1;
  public static boolean c = false;
  public static int d = 0;
  public static long d = 0L;
  public static boolean d = false;
  public static int e = 1;
  public static boolean e = false;
  public static int f = 20;
  public static boolean f = true;
  public static int g = 10;
  public static boolean g = false;
  public static int h = 0;
  public static boolean h = false;
  public static int i = -1;
  public static boolean i = false;
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
  public long c = -9223372036854775808L;
  
  private EmojiStickerManager()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -2147483648;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    this.jdField_b_of_type_Long = -9223372036854775808L;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(64);
    this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(64);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static int a(StringBuilder paramStringBuilder)
  {
    int i4 = paramStringBuilder.length();
    int i5 = paramStringBuilder.length();
    int k = 0;
    int i1 = 0;
    int j = 0;
    while (k < i4)
    {
      int i6 = paramStringBuilder.codePointAt(k);
      int i3;
      if ((i6 == 20) && (k < i5 - 1))
      {
        i2 = k + 1;
        i3 = paramStringBuilder.charAt(i2);
        if (i3 < EmotcationConstants.VALID_SYS_EMOTCATION_COUNT) {
          a(paramStringBuilder, k, i3);
        }
        for (;;)
        {
          m = i1 + 1;
          j += 1;
          k = i2;
          break label352;
          if (i3 >= 255)
          {
            m = k + 4;
            if (m < i5)
            {
              b(paramStringBuilder, k);
              n = i1 + 1;
              j += 1;
              k = m;
              m = n;
              break label352;
            }
          }
          n = k;
          m = j;
          if (i3 != 250) {
            break;
          }
          a(paramStringBuilder, k);
        }
      }
      int n = EmotcationConstants.getSingleEmoji(i6);
      if (i6 > 65535)
      {
        m = k + 2;
        if (i5 <= m) {
          break label244;
        }
        m = paramStringBuilder.codePointAt(m);
      }
      else
      {
        m = k + 1;
        if (i5 <= m) {
          break label244;
        }
        i2 = paramStringBuilder.codePointAt(m);
        m = i2;
        if (i2 == 65039)
        {
          i3 = k + 2;
          m = i2;
          if (i5 > i3)
          {
            i2 = paramStringBuilder.codePointAt(i3);
            bool1 = true;
            break label252;
          }
        }
      }
      break label246;
      label244:
      int m = -1;
      label246:
      boolean bool1 = false;
      int i2 = m;
      label252:
      boolean bool2 = EmotcationConstants.isSkinEmoji(i2);
      if ((n != -1) && (!bool2))
      {
        bool2 = false;
        i3 = n;
      }
      else
      {
        m = EmotcationConstants.getDoubleEmoji(i6, i2);
        if (m == -1) {
          m = n;
        }
        bool2 = true;
        i3 = m;
      }
      n = k;
      m = j;
      if (i3 != -1)
      {
        n = k + (a(paramStringBuilder, k, i5, i6, bool2, i2, bool1) - 1);
        m = j + 1;
      }
      k = n;
      j = m;
      m = i1;
      label352:
      if (j > 512) {
        return m;
      }
      k += 1;
      i1 = m;
    }
    return i1;
  }
  
  protected static int a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, boolean paramBoolean2)
  {
    int j = 1;
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
      paramInt2 = j;
      if (QQText.IS_FXXKED_MTK)
      {
        paramStringBuilder.replace(paramInt1, paramInt1 + 1, "#");
        paramInt2 = j;
      }
    }
    return paramInt2;
  }
  
  private long a(long paramLong, StickerInfo paramStickerInfo)
  {
    long l;
    if (paramLong != -9223372036854775808L)
    {
      l = paramLong;
      if (paramStickerInfo.hostMsgSeq >= paramLong) {}
    }
    else
    {
      l = paramLong;
      if (paramStickerInfo.hostMsgSeq > this.c)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("new navigate seq: ");
          localStringBuilder.append(paramStickerInfo.hostMsgSeq);
          QLog.i("EmojiStickerManager", 2, localStringBuilder.toString());
        }
        l = paramStickerInfo.hostMsgSeq;
      }
    }
    return l;
  }
  
  public static Pair<Long, Long> a(MessageRecord paramMessageRecord)
  {
    Object localObject2 = null;
    if (paramMessageRecord == null) {
      return null;
    }
    Object localObject3;
    Object localObject1;
    if (paramMessageRecord.msgtype == -2058)
    {
      localObject3 = a(paramMessageRecord);
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
      if (b(paramMessageRecord))
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
          if (((MessageForUniteGrayTip)localObject3).tipParam.jdField_b_of_type_Int == 1)
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
  
  public static CustomEmotionData a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (IFavroamingDBManagerService)paramQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
    List localList = paramQQAppInterface.getEmoticonDataList();
    if (localList != null)
    {
      int j = 0;
      while (j < localList.size())
      {
        if ((paramString != null) && (paramString.equals(((CustomEmotionData)localList.get(j)).emoPath)))
        {
          paramString = (CustomEmotionData)localList.get(j);
          paramQQAppInterface.updateDeletedEmoticon(paramString, j);
          return paramString;
        }
        j += 1;
      }
    }
    return null;
  }
  
  private MessageRecord a(ChatXListView paramChatXListView, List<ChatMessage> paramList)
  {
    if (paramChatXListView.getChildCount() > 0)
    {
      int j = paramChatXListView.getFirstVisiblePosition() - paramChatXListView.getHeaderViewsCount();
      if ((j < 0) || (j >= paramChatXListView.getAdapter().getCount())) {
        j = 0;
      }
      paramChatXListView = paramChatXListView.getAdapter().getItem(j);
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
    return jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager;
  }
  
  public static StickerInfo a(MessageRecord paramMessageRecord)
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
      HardCodeUtil.a(2131704140);
      Object localObject = paramMessage.getExtInfoFromExtStr("sticker_info");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = StickerInfo.transformFromJson((String)localObject);
        if (localObject != null)
        {
          String str = ((StickerInfo)localObject).msg;
          localObject = str;
          if (!f) {
            break label152;
          }
          if (paramMessage.senderuin.equals(paramQQAppInterface.getCurrentAccountUin()))
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append(HardCodeUtil.a(2131704141));
            paramQQAppInterface.append(str);
            localObject = paramQQAppInterface.toString();
            paramMsgSummary.mEmojiFlag = 1;
            break label152;
          }
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append(HardCodeUtil.a(2131704144));
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
  
  public static String a()
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
        return HardCodeUtil.a(2131704147);
      }
      return HardCodeUtil.a(2131704146);
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
    Pair localPair = a(paramChatMessage);
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
  
  public static void a()
  {
    ThreadManager.post(new EmojiStickerManager.2(), 5, null, false);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable, String paramString, PicMessageExtraData paramPicMessageExtraData, MessengerService paramMessengerService, Bundle paramBundle)
  {
    new EmojiStickerManager.3(paramBundle, paramMessengerService, paramURLDrawable, paramQQAppInterface, paramPicMessageExtraData).execute(new Void[0]);
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt, List<ChatMessage> paramList, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
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
        if ((this.jdField_a_of_type_Int == 0) && (((MessageRecord)localObject).time > this.jdField_b_of_type_Long))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("new message coming! getLastRead: ");
            localStringBuilder.append(((MessageRecord)localObject).time);
            QLog.i("EmojiStickerManager", 2, localStringBuilder.toString());
          }
          this.jdField_b_of_type_Int = 0;
        }
        else
        {
          if (((MessageRecord)localObject).shmsgseq <= this.jdField_b_of_type_Long) {
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
      paramList = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramList.hasNext())
      {
        localObject = a((MessageRecord)paramList.next());
        if ((localObject != null) && (!((StickerInfo)localObject).isDisplayed)) {
          ((StickerInfo)localObject).isDisplayed = true;
        }
      }
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Long = paramQQAppInterface.getConversationFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
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
    paramStructMsgForImageShare = AIOGallerySceneWithBusiness.a(paramStructMsgForImageShare);
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
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject2).append(", new sticker size: ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.i("EmojiStickerManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (this.jdField_b_of_type_Int > 0)
    {
      localObject2 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject2).isread = true;
      int j = this.jdField_b_of_type_Int;
      Object localObject3;
      if (j <= 10)
      {
        if ((this.jdField_a_of_type_Int == 1) && (paramLong != -9223372036854775808L))
        {
          localObject3 = String.format(HardCodeUtil.a(2131704139), new Object[] { Integer.valueOf(Math.min(this.jdField_a_of_type_JavaUtilList.size(), this.jdField_b_of_type_Int)) });
          localObject1 = new UniteGrayTipParam(((MessageRecord)localObject1).frienduin, paramQQAppInterface.getCurrentAccountUin(), (String)localObject3, ((MessageRecord)localObject1).istroop, -5023, 1179651, ((MessageRecord)localObject1).time);
          Bundle localBundle = new Bundle();
          localBundle.putInt("key_action", 20);
          localBundle.putString("key_action_DATA", String.valueOf(paramLong));
          ((UniteGrayTipParam)localObject1).a(((String)localObject3).length() - 4, ((String)localObject3).length(), localBundle);
        }
        else
        {
          localObject3 = String.format(HardCodeUtil.a(2131704142), new Object[] { Integer.valueOf(Math.min(this.jdField_a_of_type_JavaUtilList.size(), this.jdField_b_of_type_Int)) });
          localObject1 = new UniteGrayTipParam(((MessageRecord)localObject1).frienduin, paramQQAppInterface.getCurrentAccountUin(), (String)localObject3, ((MessageRecord)localObject1).istroop, -5023, 1179651, ((MessageRecord)localObject1).time);
        }
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("key", "NewTip");
        ((Bundle)localObject3).putInt("sessionType", this.jdField_a_of_type_Int);
        ((Bundle)localObject3).putString("ext2", "1");
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject3);
        ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject1);
      }
      else if (j > 10)
      {
        localObject3 = HardCodeUtil.a(2131704148);
        ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(paramQQAppInterface, new UniteGrayTipParam(((MessageRecord)localObject1).frienduin, paramQQAppInterface.getCurrentAccountUin(), (String)localObject3, ((MessageRecord)localObject1).istroop, -5023, 1179651, ((MessageRecord)localObject1).time));
        paramQQAppInterface = new Bundle();
        paramQQAppInterface.putString("key", "NewTip");
        paramQQAppInterface.putInt("sessionType", this.jdField_a_of_type_Int);
        paramQQAppInterface.putString("ext2", "2");
        this.jdField_a_of_type_JavaUtilArrayList.add(paramQQAppInterface);
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
      paramQQAppInterface.putInt("sessionType", this.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramQQAppInterface);
    }
    paramQQAppInterface = ((List)localObject).iterator();
    while (paramQQAppInterface.hasNext())
    {
      paramHashMap = (MessageForUniteGrayTip)paramQQAppInterface.next();
      int j = 0;
      localObject = paramList.iterator();
      while ((((Iterator)localObject).hasNext()) && (((MessageRecord)((Iterator)localObject).next()).time <= paramHashMap.time)) {
        j += 1;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("insert unfounded gray tips:  host seq: ");
        ((StringBuilder)localObject).append(paramHashMap.shmsgseq);
        ((StringBuilder)localObject).append(", list pos: ");
        ((StringBuilder)localObject).append(j);
        QLog.i("EmojiStickerManager", 2, ((StringBuilder)localObject).toString());
      }
      paramList.add(j, paramHashMap);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap, List<MessageForUniteGrayTip> paramList1)
  {
    int j = paramList.size();
    int k = 0;
    if (j > 0) {
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
    long l4 = paramQQAppInterface.getMsgCache().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    paramList = paramHashMap.keySet().iterator();
    while (paramList.hasNext())
    {
      Pair localPair = (Pair)paramList.next();
      Object localObject1 = (List)paramHashMap.get(localPair);
      if (localObject1 != null) {
        if (((List)localObject1).size() != 0)
        {
          localObject1 = (MessageRecord)((List)localObject1).get(k);
          StickerInfo localStickerInfo = a((MessageRecord)localObject1);
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
            if ((!this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.containsKey(localPair)) && (localStickerInfo.hostMsgTime <= l1)) {
              j = 0;
            } else {
              j = 1;
            }
            Object localObject3;
            if (j == 0)
            {
              localObject2 = paramQQAppInterface.getMessageProxy(this.jdField_a_of_type_Int).c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
              if ((localObject2 != null) && (((List)localObject2).size() > 0))
              {
                long l2;
                if (localStickerInfo.hostMsgTime < ((MessageRecord)((List)localObject2).get(k)).time)
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
                    j = 1;
                    break label539;
                    k = ((List)localObject2).size() - 1;
                    while (k >= 0)
                    {
                      localObject3 = (MessageRecord)((List)localObject2).get(k);
                      if ((((MessageRecord)localObject3).shmsgseq == localStickerInfo.hostMsgSeq) && (((MessageRecord)localObject3).msgUid == localStickerInfo.hostMsgUid))
                      {
                        k = 1;
                        j = 0;
                        break label445;
                      }
                      k -= 1;
                    }
                    k = 0;
                    label445:
                    if (k == 0)
                    {
                      localObject2 = paramQQAppInterface.getMsgCache().b(this.jdField_a_of_type_JavaLangString);
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
                      if (this.jdField_a_of_type_Long - localStickerInfo.hostMsgTime > 86400L) {
                        break label537;
                      }
                    }
                  }
                }
              }
            }
            label539:
            if (j != 0)
            {
              localObject2 = new MessageForUniteGrayTip();
              localObject3 = BaseApplicationImpl.getApplication().getString(2131719233);
              ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(paramQQAppInterface, new UniteGrayTipParam(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).senderuin, (String)localObject3, this.jdField_a_of_type_Int, -5040, 1, localStickerInfo.hostMsgTime));
              ((MessageForUniteGrayTip)localObject2).shmsgseq = ((Long)localPair.first).longValue();
              ((MessageForUniteGrayTip)localObject2).msgUid = ((Long)localPair.second).longValue();
              ((MessageForUniteGrayTip)localObject2).time = localStickerInfo.hostMsgTime;
              ((MessageForUniteGrayTip)localObject2).mNeedTimeStamp = false;
              paramList1.add(localObject2);
            }
            k = 0;
          }
        }
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage)
  {
    if (!paramChatMessage.isread)
    {
      if ((this.jdField_a_of_type_Int == 0) && (paramChatMessage.time > this.jdField_b_of_type_Long))
      {
        this.jdField_b_of_type_Long = paramChatMessage.time;
        return;
      }
      if (paramChatMessage.shmsgseq > this.jdField_b_of_type_Long) {
        this.jdField_b_of_type_Long = paramChatMessage.shmsgseq;
      }
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    Object localObject1;
    if (paramMessageRecord.istroop != 0)
    {
      Object localObject2 = null;
      localObject1 = a(paramMessageRecord);
      if (localObject1 != null)
      {
        Pair localPair = new Pair(Long.valueOf(((StickerInfo)localObject1).hostMsgSeq), Long.valueOf(0L));
        boolean bool = a().jdField_b_of_type_ComTencentUtilLRULinkedHashMap.containsKey(localPair);
        localObject1 = localObject2;
        if (!bool)
        {
          paramAppInterface = ((QQAppInterface)paramAppInterface).getMessageProxy(paramMessageRecord.istroop).b(paramMessageRecord.frienduin, paramMessageRecord.istroop);
          localObject1 = localObject2;
          if (paramAppInterface != null)
          {
            localObject1 = localObject2;
            if (paramAppInterface.size() > 0)
            {
              int j = paramAppInterface.size() - 1;
              for (;;)
              {
                localObject1 = localObject2;
                if (j < 0) {
                  break;
                }
                localObject1 = (MessageRecord)paramAppInterface.get(j);
                if ((((MessageRecord)localObject1).shmsgseq == ((Long)localPair.first).longValue()) && (b((MessageRecord)localObject1))) {
                  break;
                }
                j -= 1;
              }
            }
          }
        }
        if (((bool) || ((localObject1 != null) && (((MessageRecord)localObject1).msgtype == -2006))) && (localObject1 != null)) {
          a().jdField_b_of_type_ComTencentUtilLRULinkedHashMap.put(localPair, Boolean.valueOf(true));
        }
      }
    }
    else
    {
      paramAppInterface = a(paramMessageRecord);
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
    int j;
    if (paramMessageRecord != null)
    {
      if (!a(paramMessageRecord)) {
        return;
      }
      try
      {
        j = paramMessageRecord.msgtype;
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
          ((StickerInfo)localObject).originMsgType = j;
          if (j == -1000) {
            paramStickerInfo = paramMessageRecord.msg;
          } else {
            paramStickerInfo = HardCodeUtil.a(2131704145);
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
      paramStickerInfo.put("msgType", j);
      paramMessageRecord.saveExtInfoToExtStr("Emoji_Sticker_Info", paramStickerInfo.toString());
      if (f)
      {
        paramMessageRecord.msgtype = -2058;
        return;
      }
      label206:
      return;
      label207:
      if (j == -2007) {
        break label107;
      }
      if ((j == -2000) || (j == -1000)) {
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
    if (this.jdField_a_of_type_Int != 0) {
      b(paramQQAppInterface, paramList, paramHashMap);
    } else {
      a(paramQQAppInterface, paramList, paramHashMap);
    }
    if (paramList.size() == 0) {
      c(paramQQAppInterface, paramList, paramHashMap);
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
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForMarketFace)) || (((paramMessageRecord instanceof MessageForText)) && (paramMessageRecord.msgtype == -1000)) || ((paramMessageRecord instanceof MessageForPic));
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
    if (!f)
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
    int j;
    if (localObject != null)
    {
      int k = 0;
      int n = 0;
      int i1;
      for (j = 1; k < ((List)localObject).size(); j = i1)
      {
        int m;
        if (!TextUtils.isEmpty(((CustomEmotionData)((List)localObject).get(k)).RomaingType))
        {
          m = n;
          if ("needDel".equals(((CustomEmotionData)((List)localObject).get(k)).RomaingType)) {}
        }
        else
        {
          m = n + 1;
        }
        n = ((CustomEmotionData)((List)localObject).get(k)).emoId;
        if ((paramString != null) && (paramString.equals(((CustomEmotionData)((List)localObject).get(k)).emoPath)))
        {
          b(paramQQAppInterface, paramStructMsgForImageShare, (CustomEmotionData)((List)localObject).get(k));
          return 2;
        }
        if ((str != null) && (((CustomEmotionData)((List)localObject).get(k)).md5 != null) && (str.equals(((CustomEmotionData)((List)localObject).get(k)).md5)))
        {
          b(paramQQAppInterface, paramStructMsgForImageShare, (CustomEmotionData)((List)localObject).get(k));
          if ("needDel".equals(((CustomEmotionData)((List)localObject).get(k)).RomaingType))
          {
            localIFavroamingDBManagerService.updateDeletedEmoticon((CustomEmotionData)((List)localObject).get(k), k);
            paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.obtainMessage(10).sendToTarget();
            }
            return 0;
          }
          return 2;
        }
        i1 = j;
        if (j < n) {
          i1 = n;
        }
        k += 1;
        n = m;
      }
      if (n >= FavEmoConstant.jdField_a_of_type_Int) {
        return 3;
      }
    }
    else
    {
      j = 1;
    }
    localObject = new CustomEmotionData();
    ((CustomEmotionData)localObject).uin = paramQQAppInterface.getCurrentAccountUin();
    ((CustomEmotionData)localObject).emoId = (j + 1);
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
          localBundle1.putString("callbackid", jdField_b_of_type_JavaLangString);
          localBundle1.putInt("respkey", jdField_i_of_type_Int);
          Bundle localBundle2 = new Bundle();
          if (!paramBoolean) {
            break label232;
          }
          j = 0;
          localBundle2.putInt("result", j);
          AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
          if ((localAppRuntime instanceof QQAppInterface)) {
            localBundle2.putString("QQ", ((QQAppInterface)localAppRuntime).getCurrentUin());
          }
          j = -1;
          if (this.jdField_a_of_type_Int == 0) {
            j = 1;
          } else if (this.jdField_a_of_type_Int == 1) {
            j = 2;
          } else if (this.jdField_a_of_type_Int == 3000) {
            j = 3;
          }
          localBundle2.putInt("chatType", j);
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
      jdField_i_of_type_Boolean = false;
      return;
      label232:
      int j = -2;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = AIOGallerySceneWithBusiness.a(paramStructMsgForImageShare);
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
      paramQQAppInterface.putInt("sessionType", this.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramQQAppInterface);
    }
    paramQQAppInterface = ((List)localObject).iterator();
    while (paramQQAppInterface.hasNext())
    {
      paramHashMap = (MessageForUniteGrayTip)paramQQAppInterface.next();
      int j = 0;
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (localMessageRecord.shmsgseq > paramHashMap.shmsgseq)
        {
          paramHashMap.time = (localMessageRecord.time - 10L);
          break;
        }
        j += 1;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("insert unfind gray tips:  host seq: ");
        ((StringBuilder)localObject).append(paramHashMap.shmsgseq);
        ((StringBuilder)localObject).append(", list pos: ");
        ((StringBuilder)localObject).append(j);
        QLog.i("EmojiStickerManager", 2, ((StringBuilder)localObject).toString());
      }
      paramList.add(j, paramHashMap);
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
    long l2 = paramQQAppInterface.getMsgCache().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    paramList = paramHashMap.keySet().iterator();
    while (paramList.hasNext())
    {
      Pair localPair1 = (Pair)paramList.next();
      Object localObject1 = (List)paramHashMap.get(localPair1);
      if (localObject1 != null) {
        if (((List)localObject1).size() != 0)
        {
          MessageRecord localMessageRecord1 = (MessageRecord)((List)localObject1).get(0);
          Object localObject2 = a(localMessageRecord1);
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
            int j;
            if ((!this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.containsKey(localPair1)) && (((Long)localPair1.first).longValue() <= l1)) {
              j = 0;
            } else {
              j = 1;
            }
            if (j == 0)
            {
              localObject1 = paramQQAppInterface.getMessageProxy(this.jdField_a_of_type_Int).c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
              if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
                if (((StickerInfo)localObject2).hostMsgSeq < ((MessageRecord)((List)localObject1).get(0)).shmsgseq)
                {
                  if (((StickerInfo)localObject2).hostMsgSeq <= l2) {
                    j = 1;
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
                      Pair localPair2 = a(localMessageRecord2);
                      if (localPair2 != null) {
                        this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.put(localPair2, Boolean.valueOf(true));
                      }
                    }
                    int k;
                    if ((localMessageRecord2.shmsgseq == ((StickerInfo)localObject2).hostMsgSeq) && (!MsgProxyUtils.a(localMessageRecord2)))
                    {
                      if (localMessageRecord2.msgtype == -2006) {
                        j = 1;
                      } else {
                        j = 0;
                      }
                      k = j;
                      if (j == 0) {
                        break;
                      }
                    }
                    else
                    {
                      k = j;
                    }
                    if ((k != 0) && (b(localMessageRecord2)))
                    {
                      j = 0;
                      break;
                    }
                    j = k;
                  }
                }
              }
            }
            if (j != 0)
            {
              localObject1 = new MessageForUniteGrayTip();
              localObject2 = BaseApplicationImpl.getApplication().getString(2131719233);
              ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQAppInterface, new UniteGrayTipParam(localMessageRecord1.frienduin, localMessageRecord1.senderuin, (String)localObject2, this.jdField_a_of_type_Int, -5040, 1, localMessageRecord1.time));
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
    int j = paramStringBuilder.charAt(paramInt + 4);
    int m = 0;
    arrayOfChar[0] = j;
    arrayOfChar[1] = paramStringBuilder.charAt(paramInt + 3);
    j = paramStringBuilder.charAt(paramInt + 2);
    int n = 2;
    arrayOfChar[2] = j;
    arrayOfChar[3] = paramStringBuilder.charAt(paramInt + 1);
    int k;
    for (;;)
    {
      k = n;
      if (m >= 3) {
        break;
      }
      if (arrayOfChar[m] == 'ú') {
        arrayOfChar[m] = '\n';
      } else if (arrayOfChar[m] == 'þ') {
        arrayOfChar[m] = '\r';
      }
      m += 1;
    }
    while (k < 5)
    {
      m = paramInt + k;
      if (paramStringBuilder.charAt(m) == '\n') {
        paramStringBuilder.setCharAt(m, 'ú');
      } else if (paramStringBuilder.charAt(m) == '\r') {
        paramStringBuilder.setCharAt(m, 'þ');
      }
      k += 1;
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
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    int j = paramMessageRecord.msgtype;
    boolean bool = ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).isRedPacketMsg(paramMessageRecord);
    return (j == -1000) || (j == -2011) || (j == -2039) || ((j == -2025) && (bool)) || (j == -2007) || (j == -2000) || (j == -2002) || (j == -2022) || (j == -1035) || (j == -1049);
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
      int k = 0;
      int j = 0;
      do
      {
        n = k;
        localObject6 = localObject3;
        localObject5 = localObject1;
        localObject4 = localObject2;
        m = j;
        if (!localIterator1.hasNext()) {
          break;
        }
        localObject5 = (List)paramHashMap.get((Pair)localIterator1.next());
      } while ((localObject5 == null) || (((List)localObject5).size() == 0));
      n = k + ((List)localObject5).size();
      localObject4 = localObject2;
      if (localObject2 == null) {
        localObject4 = (MessageRecord)((List)localObject5).get(0);
      }
      Iterator localIterator2 = ((List)localObject5).iterator();
      m = j;
      localObject6 = localObject1;
      localObject5 = localObject3;
      for (;;)
      {
        k = n;
        localObject3 = localObject5;
        localObject1 = localObject6;
        localObject2 = localObject4;
        j = m;
        if (!localIterator2.hasNext()) {
          break;
        }
        localObject1 = (ChatMessage)localIterator2.next();
        if ((localObject5 == null) && (!((ChatMessage)localObject1).senderuin.equals(localObject5))) {
          localObject5 = ((ChatMessage)localObject1).senderuin;
        } else if ((localObject6 == null) && (!((ChatMessage)localObject1).senderuin.equals(localObject5))) {
          localObject6 = ((ChatMessage)localObject1).senderuin;
        } else if ((localObject5 != null) && (localObject6 != null)) {
          m = 1;
        }
      }
    }
    Object localObject6 = null;
    paramHashMap = (HashMap<Pair<Long, Long>, List<ChatMessage>>)localObject6;
    Object localObject4 = paramHashMap;
    int n = 0;
    int m = 0;
    Object localObject5 = paramHashMap;
    if ((n > 0) && (localObject4 != null))
    {
      paramHashMap = a(paramQQAppInterface, ((MessageRecord)localObject4).frienduin, ((MessageRecord)localObject4).istroop, (String)localObject6);
      localObject1 = a(paramQQAppInterface, ((MessageRecord)localObject4).frienduin, ((MessageRecord)localObject4).istroop, (String)localObject5);
      if ((n != 1) && (!TextUtils.isEmpty(paramHashMap)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramHashMap);
        ((StringBuilder)localObject2).append("、");
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = ((StringBuilder)localObject2).toString();
        paramHashMap = (HashMap<Pair<Long, Long>, List<ChatMessage>>)localObject1;
        if (m != 0)
        {
          paramHashMap = new StringBuilder();
          paramHashMap.append((String)localObject1);
          paramHashMap.append(HardCodeUtil.a(2131704143));
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
      paramHashMap = String.format("%s在上面贴了%d个表情", new Object[] { paramHashMap, Integer.valueOf(n) });
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
      paramQQAppInterface.putInt("sessionType", this.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramQQAppInterface);
      paramList.add(localObject1);
    }
  }
  
  public static boolean c(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForMarketFace)) || ((paramMessageRecord instanceof MessageForText)) || ((paramMessageRecord instanceof MessageForPic));
  }
  
  public static boolean d(MessageRecord paramMessageRecord)
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
    Drawable localDrawable2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 == null) {
      localDrawable1 = paramContext.getResources().getDrawable(2130839638);
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
    int j = (int)(f1 * 110.0F);
    paramEmoticon = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    return URLDrawable.getDrawable(paramContext, j, j, paramEmoticon, paramEmoticon, true);
  }
  
  protected EmoticonInfo a(int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
  {
    int n = paramInt1 + 1;
    int m = paramStringBuilder.charAt(n);
    if (m >= 255)
    {
      int k = paramInt1 + 4;
      if (k < paramInt2)
      {
        Object localObject = new char[4];
        int j = paramStringBuilder.charAt(k);
        k = 0;
        localObject[0] = j;
        localObject[1] = paramStringBuilder.charAt(paramInt1 + 3);
        localObject[2] = paramStringBuilder.charAt(paramInt1 + 2);
        localObject[3] = paramStringBuilder.charAt(n);
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
        if (m == 511) {
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
          paramInt1 = k;
        }
        localEmoticon.eId = String.valueOf(paramInt2);
        localEmoticon.epId = String.valueOf(paramInt1);
        localEmoticon.jobType = 3;
        paramStringBuilder.setEmoticon(localEmoticon);
        boolean bool2 = bool1;
        if (!bool1)
        {
          localObject = EmoticonPanelUtils.a();
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
    if (m == 250) {
      return new SystemAndEmojiEmoticonInfo(7, 1, 10, "", false);
    }
    return new SystemAndEmojiEmoticonInfo(7, 1, m, "", false);
  }
  
  public EmoticonInfo a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int k = 0;
      int i1 = paramString.length();
      int i2 = paramString.length();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      while (k < i1)
      {
        int i3 = localStringBuilder.codePointAt(k);
        if ((i3 == 20) && (k < i2 - 1)) {
          return a(k, i2, localStringBuilder);
        }
        int n = EmotcationConstants.getSingleEmoji(i3);
        int m;
        if (i3 > 65535)
        {
          j = k + 2;
          if (i2 > j)
          {
            j = localStringBuilder.codePointAt(j);
            break label166;
          }
        }
        else
        {
          j = k + 1;
          if (i2 > j)
          {
            m = localStringBuilder.codePointAt(j);
            j = m;
            if (m != 65039) {
              break label166;
            }
            int i4 = k + 2;
            j = m;
            if (i2 <= i4) {
              break label166;
            }
            j = localStringBuilder.codePointAt(i4);
            break label166;
          }
        }
        int j = -1;
        label166:
        boolean bool = EmotcationConstants.isSkinEmoji(j);
        if (n != -1)
        {
          m = n;
          if (bool) {}
        }
        for (;;)
        {
          break;
          m = EmotcationConstants.getDoubleEmoji(i3, j);
          if (m == -1) {
            m = n;
          }
        }
        if (m != -1) {
          return new SystemAndEmojiEmoticonInfo(7, 2, m, "", false);
        }
        k += 1;
      }
    }
    return null;
  }
  
  public List<Long> a(MessageRecord paramMessageRecord)
  {
    if ((f) && (paramMessageRecord != null) && (paramMessageRecord.shmsgseq != 0L) && (paramMessageRecord.extraflag != 32772) && (paramMessageRecord.extraflag != 32768) && (!paramMessageRecord.isMultiMsg))
    {
      if (paramMessageRecord.isReMultiMsg) {
        return null;
      }
      paramMessageRecord = a(paramMessageRecord);
      if (paramMessageRecord != null) {
        return (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramMessageRecord);
      }
    }
    return null;
  }
  
  public void a(Messenger paramMessenger, boolean paramBoolean)
  {
    if (jdField_i_of_type_Boolean) {
      b(paramMessenger, paramBoolean);
    }
  }
  
  public void a(View paramView)
  {
    jdField_a_of_type_AndroidViewView = (ViewGroup)paramView.getParent();
    paramView = jdField_a_of_type_AndroidViewView;
    if ((paramView instanceof BaseChatItemLayout))
    {
      paramView = (BaseChatItemLayout)paramView;
      if (paramView.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = paramView.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)localIterator.next();
          if (localSticker.f == 255) {
            localSticker.f = 127;
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
    this.jdField_b_of_type_Int = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Long = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    this.c = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel())
    {
      paramBaseChatPie = new StringBuilder();
      paramBaseChatPie.append("init, unReadCnt: ");
      paramBaseChatPie.append(this.jdField_b_of_type_Int);
      paramBaseChatPie.append(", mInitLastReadSeq: ");
      paramBaseChatPie.append(this.jdField_a_of_type_Long);
      QLog.i("EmojiStickerManager", 2, paramBaseChatPie.toString());
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, String paramString, int paramInt, boolean paramBoolean)
  {
    ((EmojiStickerHelper)paramBaseChatPie.a(133)).b();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    jdField_i_of_type_Boolean = false;
    jdField_b_of_type_JavaLangString = "";
    jdField_i_of_type_Int = -1;
    jdField_a_of_type_AndroidViewView = null;
    List localList = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).d(paramString, paramInt);
    ThreadManager.post(new EmojiStickerManager.1(this, localList, paramString, paramInt, paramBoolean), 5, null, false);
    if (paramBaseChatPie.c != null)
    {
      paramString = (TopGestureLayout)paramBaseChatPie.c;
      GestureDetector localGestureDetector = paramString.getGestureDetector();
      if ((localGestureDetector instanceof StickerGestureDetector))
      {
        paramString.removeView(((StickerGestureDetector)localGestureDetector).popupEmo);
        jdField_a_of_type_Boolean = false;
        paramBaseChatPie.i(false);
        paramBaseChatPie.i(false);
      }
      paramString.restoreGestureDetector();
    }
    a(localList);
    this.jdField_a_of_type_Long = -9223372036854775808L;
    this.jdField_b_of_type_Long = -9223372036854775808L;
    this.c = -9223372036854775808L;
  }
  
  public void a(BaseChatPie paramBaseChatPie, List<ChatMessage> paramList)
  {
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.b().a().a().a(), paramList);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, ChatXListView paramChatXListView, int paramInt, List<ChatMessage> paramList, HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap, long paramLong, boolean paramBoolean)
  {
    if ((paramList.size() != 0) && (paramChatXListView.getChildCount() != 0) && (paramBoolean) && (this.jdField_b_of_type_Int > 0)) {
      a(paramQQAppInterface, paramInt, paramList, paramLong);
    }
    if ((paramHashMap != null) && (paramHashMap.size() > 0)) {
      if (paramList.size() > 0)
      {
        if (paramChatXListView.getChildCount() > 0)
        {
          if (this.jdField_a_of_type_Int != 0)
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
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (paramChatXListView == null) {
        return;
      }
      long l7 = System.currentTimeMillis();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      int j = paramList.size() - 1;
      paramString = null;
      int k = 0;
      boolean bool1 = false;
      long l2 = -9223372036854775808L;
      long l4 = -9223372036854775808L;
      long l3 = -9223372036854775808L;
      long l9;
      for (long l1 = -9223372036854775808L;; l1 = l9)
      {
        Object localObject1 = paramList;
        if (j < 0) {
          break;
        }
        ChatMessage localChatMessage = (ChatMessage)((List)localObject1).get(j);
        Object localObject2;
        if (localChatMessage == null)
        {
          l6 = l3;
        }
        else
        {
          a(localChatMessage);
          if ((localChatMessage.msgtype != -2058) || (!d(localChatMessage))) {
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
          localObject2 = a(localChatMessage);
          if (!a((List)localObject1, localChatMessage, (StickerInfo)localObject2)) {
            break label268;
          }
          l6 = l4;
          l4 = l3;
        }
        paramInt1 = k;
        localObject1 = paramString;
        boolean bool2 = bool1;
        long l8 = l2;
        long l5 = l4;
        l9 = l1;
        break label635;
        label268:
        if (!((StickerInfo)localObject2).isDisplayed)
        {
          paramInt1 = this.jdField_a_of_type_Int;
          if (paramInt1 == 0)
          {
            if (localChatMessage.time > this.jdField_a_of_type_Long)
            {
              this.jdField_a_of_type_JavaUtilList.add(localChatMessage);
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
                if (((StickerInfo)localObject2).hostMsgTime > this.c)
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
            if (localChatMessage.shmsgseq <= this.jdField_a_of_type_Long) {
              break label516;
            }
            this.jdField_a_of_type_JavaUtilList.add(localChatMessage);
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
        paramInt1 = k;
        localObject1 = paramString;
        bool2 = bool1;
        l8 = l2;
        l5 = l4;
        l6 = l3;
        l9 = l1;
        if (k > 0)
        {
          paramString.remove(a(localChatMessage));
          paramInt1 = paramString.size();
          l9 = l1;
          l6 = l3;
          l5 = l4;
          l8 = l2;
          bool2 = bool1;
          localObject1 = paramString;
        }
        label635:
        j -= 1;
        k = paramInt1;
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
    if ((paramMessageRecord != null) && (paramMessageRecord.msgtype == -2058) && (f))
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
    Object localObject = jdField_a_of_type_AndroidViewView;
    if ((localObject instanceof BaseChatItemLayout))
    {
      localObject = (BaseChatItemLayout)localObject;
      if (((BaseChatItemLayout)localObject).jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = ((BaseChatItemLayout)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)localIterator.next();
          if (localSticker.f != 0) {
            localSticker.f = 255;
          }
        }
        ((BaseChatItemLayout)localObject).invalidate();
      }
    }
    jdField_a_of_type_AndroidViewView = null;
  }
  
  public void b(BaseChatPie paramBaseChatPie)
  {
    List localList = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    if (localList != null)
    {
      if (localList.size() <= 0) {
        return;
      }
      System.currentTimeMillis();
      ChatXListView localChatXListView = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      long l2 = 9223372036854775807L;
      long l3 = -9223372036854775808L;
      Object localObject;
      long l4;
      long l1;
      if ((localChatXListView != null) && (localChatXListView.getAdapter() != null))
      {
        paramBaseChatPie = localChatXListView.getAdapter();
        int j = localChatXListView.getChildCount();
        localObject = null;
        if (j > 0)
        {
          int k;
          if ((paramBaseChatPie instanceof HeaderViewListAdapter))
          {
            k = localChatXListView.getFirstVisiblePosition();
            j = localChatXListView.getLastVisiblePosition();
          }
          else if ((paramBaseChatPie instanceof ChatAdapter1))
          {
            k = localChatXListView.getFirstVisiblePosition() - localChatXListView.getHeaderViewsCount();
            j = localChatXListView.getLastVisiblePosition() - localChatXListView.getFooterViewsCount();
          }
          else
          {
            j = 0;
            k = 0;
          }
          if ((k < 0) || (k >= paramBaseChatPie.getCount())) {
            k = 0;
          }
          if ((j < 0) || (j >= paramBaseChatPie.getCount())) {
            j = 0;
          }
          localObject = paramBaseChatPie.getItem(k);
          paramBaseChatPie = paramBaseChatPie.getItem(j);
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
    if ((paramMessageRecord != null) && (paramMessageRecord.msgtype == -2058) && (f) && (a(paramMessageRecord) != null))
    {
      Object localObject;
      if ((paramMessageRecord.frienduin.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Int == paramMessageRecord.istroop))
      {
        this.jdField_b_of_type_Int = 0;
        localObject = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject instanceof QQAppInterface)) {
          this.jdField_a_of_type_Long = ((QQAppInterface)localObject).getConversationFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
        }
      }
      Pair localPair = a(paramMessageRecord);
      if (localPair != null)
      {
        ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(localPair);
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
        this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(localPair, localObject);
      }
    }
  }
  
  public void c(BaseChatPie paramBaseChatPie)
  {
    if ((paramBaseChatPie != null) && (paramBaseChatPie.c != null) && ((paramBaseChatPie.c instanceof TopGestureLayout)))
    {
      TopGestureLayout localTopGestureLayout = (TopGestureLayout)paramBaseChatPie.c;
      if (!(localTopGestureLayout.getGestureDetector() instanceof StickerGestureDetector)) {
        localTopGestureLayout.setGestureDetector(new StickerGestureDetector(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, localTopGestureLayout.getGestureListener(), paramBaseChatPie));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiStickerManager
 * JD-Core Version:    0.7.0.1
 */