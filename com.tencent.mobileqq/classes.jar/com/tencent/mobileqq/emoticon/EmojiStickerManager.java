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
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletRedPkgUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.CustomEmotionBase;
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
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManager;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.SmallEmoticonInfo;
import com.tencent.mobileqq.emoticonview.StickerGestureDetector;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
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
  public static boolean i;
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
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_c_of_type_Boolean = false;
    jdField_d_of_type_Boolean = false;
    jdField_e_of_type_Boolean = false;
    jdField_a_of_type_AndroidViewView = null;
    jdField_f_of_type_Boolean = true;
    jdField_c_of_type_Int = 5;
    jdField_d_of_type_Int = 1;
    jdField_e_of_type_Int = jdField_c_of_type_Int;
    jdField_f_of_type_Int = jdField_c_of_type_Int;
    jdField_g_of_type_Int = 0;
    jdField_h_of_type_Int = 1;
    jdField_i_of_type_Int = 20;
    j = 10;
    jdField_a_of_type_Float = 0.01F;
    jdField_g_of_type_Boolean = false;
    jdField_h_of_type_Boolean = false;
    k = 0;
    jdField_i_of_type_Boolean = false;
    jdField_b_of_type_JavaLangString = "";
    l = -1;
    jdField_d_of_type_Long = 0L;
  }
  
  private EmojiStickerManager()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
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
    int i5 = paramStringBuilder.length();
    int i6 = paramStringBuilder.length();
    int m = 0;
    int i1 = 0;
    int i2 = 0;
    if (i2 < i5)
    {
      int i7 = paramStringBuilder.codePointAt(i2);
      int n;
      if ((i7 == 20) && (i2 < i6 - 1))
      {
        n = paramStringBuilder.charAt(i2 + 1);
        if (n < EmotcationConstants.VALID_SYS_EMOTCATION_COUNT)
        {
          a(paramStringBuilder, i2, n);
          n = i2 + 1;
          i2 = i1 + 1;
          m += 1;
          i1 = n;
          n = i2;
        }
      }
      label92:
      int i3;
      boolean bool1;
      for (;;)
      {
        if (n > 512)
        {
          return m;
          if ((n >= 255) && (i2 + 4 < i6))
          {
            b(paramStringBuilder, i2);
            i2 += 4;
            n = i1 + 1;
            m += 1;
            i1 = i2;
          }
          else
          {
            if (n != 250) {
              break label352;
            }
            a(paramStringBuilder, i2);
            i2 += 1;
            n = i1 + 1;
            m += 1;
            i1 = i2;
            continue;
            i3 = EmotcationConstants.getSingleEmoji(i7);
            if (i7 > 65535)
            {
              if (i6 <= i2 + 2) {
                break label378;
              }
              n = paramStringBuilder.codePointAt(i2 + 2);
              bool1 = false;
            }
          }
        }
      }
      for (;;)
      {
        label211:
        if (EmotcationConstants.isSkinEmoji(n)) {}
        label352:
        for (int i4 = 1;; i4 = 0)
        {
          if ((i3 == -1) || (i4 != 0))
          {
            i4 = EmotcationConstants.getDoubleEmoji(i7, n);
            if (i4 != -1) {}
          }
          label246:
          for (boolean bool2 = true;; bool2 = false)
          {
            if (i3 != -1)
            {
              i2 += a(paramStringBuilder, i2, i6, i7, bool2, n, bool1) - 1;
              n = i1 + 1;
              i1 = i2;
              break label92;
              if (i6 <= i2 + 1) {
                break label378;
              }
              n = paramStringBuilder.codePointAt(i2 + 1);
              if ((n != 65039) || (i6 <= i2 + 2)) {
                break label372;
              }
              n = paramStringBuilder.codePointAt(i2 + 2);
              bool1 = true;
              break label211;
              i3 = i4;
              break label246;
              i2 = i1 + 1;
              i1 = n;
              break;
            }
            n = i1;
            i1 = i2;
            break label92;
          }
        }
        label372:
        bool1 = false;
        continue;
        label378:
        bool1 = false;
        n = -1;
      }
    }
    return m;
  }
  
  protected static int a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, boolean paramBoolean2)
  {
    int m = 2;
    if (paramBoolean1) {
      if ((paramInt3 > 65535) && (paramInt2 >= paramInt1 + 2))
      {
        paramInt3 = m;
        if (QQText.IS_FXXKED_MTK)
        {
          paramStringBuilder.replace(paramInt1, paramInt1 + 2, "##");
          paramInt3 = m;
        }
        if ((paramInt4 <= 65535) || (paramInt2 < paramInt1 + 2)) {
          break label116;
        }
        if (QQText.IS_FXXKED_MTK) {
          paramStringBuilder.replace(paramInt1 + 2, paramInt1 + 4, "##");
        }
        paramInt1 = paramInt3 + 2;
        label81:
        paramInt2 = paramInt1;
        if (paramBoolean2) {
          paramInt2 = paramInt1 + 1;
        }
      }
    }
    label116:
    do
    {
      return paramInt2;
      if (QQText.IS_FXXKED_MTK) {
        paramStringBuilder.replace(paramInt1, paramInt1 + 1, "#");
      }
      paramInt3 = 1;
      break;
      if (QQText.IS_FXXKED_MTK) {
        paramStringBuilder.replace(paramInt1 + 2, paramInt1 + 3, "#");
      }
      paramInt1 = paramInt3 + 1;
      break label81;
      if ((paramInt3 <= 65535) || (paramInt2 < paramInt1 + 2)) {
        break label177;
      }
      paramInt2 = m;
    } while (!QQText.IS_FXXKED_MTK);
    paramStringBuilder.replace(paramInt1, paramInt1 + 2, "##");
    return 2;
    label177:
    if (QQText.IS_FXXKED_MTK) {
      paramStringBuilder.replace(paramInt1, paramInt1 + 1, "#");
    }
    return 1;
  }
  
  private long a(long paramLong, EmojiStickerManager.StickerInfo paramStickerInfo)
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
      if (paramStickerInfo.hostMsgSeq > this.jdField_c_of_type_Long)
      {
        if (QLog.isColorLevel()) {
          QLog.i("EmojiStickerManager", 2, "new navigate seq: " + paramStickerInfo.hostMsgSeq);
        }
        l1 = paramStickerInfo.hostMsgSeq;
      }
    }
    return l1;
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
  
  public static CustomEmotionData a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (FavroamingDBManager)paramQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
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
  
  private MessageRecord a(ChatXListView paramChatXListView, List<ChatMessage> paramList)
  {
    Object localObject = null;
    int m;
    if (paramChatXListView.getChildCount() > 0)
    {
      m = paramChatXListView.getFirstVisiblePosition() - paramChatXListView.getHeaderViewsCount();
      if ((m < 0) || (m >= paramChatXListView.getAdapter().getCount())) {
        break label63;
      }
    }
    for (;;)
    {
      localObject = paramChatXListView.getAdapter().getItem(m);
      if (!(localObject instanceof MessageRecord)) {
        break;
      }
      return (MessageRecord)localObject;
      label63:
      m = 0;
    }
    return (MessageRecord)paramList.get(0);
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
          localStickerInfo = (EmojiStickerManager.StickerInfo)paramMessageRecord.stickerInfo;
          localObject = localStickerInfo;
        } while (localStickerInfo != null);
        localObject = paramMessageRecord.getExtInfoFromExtStr("sticker_info");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = EmojiStickerManager.StickerInfo.transformFromJson((String)localObject);
          paramMessageRecord.stickerInfo = localObject;
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
  
  public static QQText a(com.tencent.imcore.message.Message paramMessage)
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
    return new QQText(paramMessage.msg, 3, 16);
  }
  
  public static QQText a(QQAppInterface paramQQAppInterface, com.tencent.imcore.message.Message paramMessage, MsgSummary paramMsgSummary)
  {
    if ((paramQQAppInterface == null) || (paramMessage == null)) {
      return null;
    }
    HardCodeUtil.a(2131704051);
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
        if (jdField_f_of_type_Boolean)
        {
          if (!paramMessage.senderuin.equals(paramQQAppInterface.getCurrentAccountUin())) {
            break label128;
          }
          str1 = HardCodeUtil.a(2131704052) + str2;
        }
      }
    }
    for (paramMsgSummary.mEmojiFlag = 1;; paramMsgSummary.mEmojiFlag = 0)
    {
      return new QQText(str1, 3, 16);
      label128:
      str1 = HardCodeUtil.a(2131704055) + str2;
    }
  }
  
  public static String a()
  {
    try
    {
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
      str = paramQQAppInterface.getCurrentUin();
      if (paramInt == 0)
      {
        if (str.equals(paramString2)) {
          return HardCodeUtil.a(2131704058);
        }
        return HardCodeUtil.a(2131704057);
      }
      if (paramInt == 1)
      {
        if (str.equals(paramString2)) {
          return paramQQAppInterface.getCurrentNickname();
        }
        return ContactUtils.g(paramQQAppInterface, paramString1, paramString2);
      }
    } while (paramInt != 3000);
    if (str.equals(paramString2)) {
      return paramQQAppInterface.getCurrentNickname();
    }
    return ContactUtils.c(paramQQAppInterface, paramString1, paramString2);
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
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      if (paramInt <= 0) {
        break label53;
      }
      if (QLog.isColorLevel()) {
        QLog.i("EmojiStickerManager", 2, "has been pull more than once!");
      }
      paramInt = 0;
    }
    for (;;)
    {
      label53:
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
        this.jdField_a_of_type_Long = paramQQAppInterface.getConversationFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
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
          localMessageForMarketFace.msgData = MessagePkgUtils.a(localMessageForMarketFace.mMarkFaceMessage);
          paramQQAppInterface.getMessageFacade().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, paramMessageRecord.msgData);
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
    paramQQAppInterface.getMessageFacade().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extStr", paramMessageRecord.extStr);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = AIOGallerySceneWithBusiness.a(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      paramQQAppInterface = (VipComicMqqManager)paramQQAppInterface.getManager(QQManagerFactory.MQQ_COMIC_MANAGER);
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
        break label394;
      }
      if ((this.jdField_a_of_type_Int != 1) || (paramLong == -9223372036854775808L)) {
        break label318;
      }
      localObject2 = String.format(HardCodeUtil.a(2131704050), new Object[] { Integer.valueOf(Math.min(this.jdField_a_of_type_JavaUtilList.size(), this.jdField_b_of_type_Int)) });
      localObject1 = new UniteGrayTipParam(((MessageRecord)localObject1).frienduin, paramQQAppInterface.getCurrentAccountUin(), (String)localObject2, ((MessageRecord)localObject1).istroop, -5023, 1179651, ((MessageRecord)localObject1).time);
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_action", 20);
      localBundle.putString("key_action_DATA", String.valueOf(paramLong));
      ((UniteGrayTipParam)localObject1).a(((String)localObject2).length() - 4, ((String)localObject2).length(), localBundle);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key", "NewTip");
      ((Bundle)localObject2).putInt("sessionType", this.jdField_a_of_type_Int);
      ((Bundle)localObject2).putString("ext2", "1");
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject1);
    }
    for (;;)
    {
      paramList.add(paramList.size(), localMessageForUniteGrayTip);
      return;
      label318:
      localObject2 = String.format(HardCodeUtil.a(2131704053), new Object[] { Integer.valueOf(Math.min(this.jdField_a_of_type_JavaUtilList.size(), this.jdField_b_of_type_Int)) });
      localObject1 = new UniteGrayTipParam(((MessageRecord)localObject1).frienduin, paramQQAppInterface.getCurrentAccountUin(), (String)localObject2, ((MessageRecord)localObject1).istroop, -5023, 1179651, ((MessageRecord)localObject1).time);
      break;
      label394:
      if (this.jdField_b_of_type_Int > 10)
      {
        localObject2 = HardCodeUtil.a(2131704059);
        localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, new UniteGrayTipParam(((MessageRecord)localObject1).frienduin, paramQQAppInterface.getCurrentAccountUin(), (String)localObject2, ((MessageRecord)localObject1).istroop, -5023, 1179651, ((MessageRecord)localObject1).time));
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
    if (paramQQAppInterface.hasNext())
    {
      paramHashMap = (MessageForUniteGrayTip)paramQQAppInterface.next();
      localObject = paramList.iterator();
      int m = 0;
      for (;;)
      {
        if ((!((Iterator)localObject).hasNext()) || (((MessageRecord)((Iterator)localObject).next()).time > paramHashMap.time))
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
  }
  
  private void a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap, List<MessageForUniteGrayTip> paramList1)
  {
    long l1;
    label30:
    label57:
    Pair localPair;
    Object localObject1;
    EmojiStickerManager.StickerInfo localStickerInfo;
    int m;
    label218:
    Object localObject2;
    if (paramList.size() > 0)
    {
      paramList = (ChatMessage)paramList.get(0);
      if (paramList == null) {
        break label437;
      }
      l1 = paramList.time;
      long l3 = paramQQAppInterface.getMsgCache().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      paramList = paramHashMap.keySet().iterator();
      do
      {
        do
        {
          if (!paramList.hasNext()) {
            break;
          }
          localPair = (Pair)paramList.next();
          localObject1 = (List)paramHashMap.get(localPair);
        } while ((localObject1 == null) || (((List)localObject1).size() == 0));
        localObject1 = (MessageRecord)((List)localObject1).get(0);
        localStickerInfo = a((MessageRecord)localObject1);
      } while (localStickerInfo == null);
      if (QLog.isColorLevel()) {
        QLog.i("EmojiStickerManager", 2, "unFind msg: shmsgseq: " + localStickerInfo.hostMsgSeq + ", isDisplay: " + localStickerInfo.isDisplayed + ", hostTime: " + localStickerInfo.hostMsgTime);
      }
      if ((!this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.containsKey(localPair)) && (localStickerInfo.hostMsgTime <= l1)) {
        break label445;
      }
      m = 1;
      n = m;
      if (m != 0) {
        break label625;
      }
      localObject2 = paramQQAppInterface.getMessageProxy(this.jdField_a_of_type_Int).c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      n = m;
      if (localObject2 == null) {
        break label625;
      }
      n = m;
      if (((List)localObject2).size() <= 0) {
        break label625;
      }
      if (localStickerInfo.hostMsgTime >= ((MessageRecord)((List)localObject2).get(0)).time) {
        break label454;
      }
      if (localStickerInfo.hostMsgTime > l3) {
        break label451;
      }
      m = 1;
    }
    label308:
    Object localObject3;
    label437:
    label445:
    label451:
    for (;;)
    {
      if (m == 0) {
        break label630;
      }
      localObject2 = new MessageForUniteGrayTip();
      localObject3 = BaseApplicationImpl.getApplication().getString(2131719515);
      ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(paramQQAppInterface, new UniteGrayTipParam(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).senderuin, (String)localObject3, this.jdField_a_of_type_Int, -5040, 1, localStickerInfo.hostMsgTime));
      ((MessageForUniteGrayTip)localObject2).shmsgseq = ((Long)localPair.first).longValue();
      ((MessageForUniteGrayTip)localObject2).msgUid = ((Long)localPair.second).longValue();
      ((MessageForUniteGrayTip)localObject2).time = localStickerInfo.hostMsgTime;
      ((MessageForUniteGrayTip)localObject2).mNeedTimeStamp = false;
      paramList1.add(localObject2);
      break label57;
      paramList = null;
      break;
      l1 = 9223372036854775807L;
      break label30;
      m = 0;
      break label218;
    }
    label454:
    int n = ((List)localObject2).size() - 1;
    label465:
    int i1;
    if (n >= 0)
    {
      localObject3 = (MessageRecord)((List)localObject2).get(n);
      if ((((MessageRecord)localObject3).shmsgseq == localStickerInfo.hostMsgSeq) && (((MessageRecord)localObject3).msgUid == localStickerInfo.hostMsgUid))
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
        localObject2 = paramQQAppInterface.getMsgCache().b(this.jdField_a_of_type_JavaLangString);
        if (localObject2 == null) {}
        for (long l2 = 0L;; l2 = ((Long)((Pair)localObject2).first).longValue())
        {
          if ((localStickerInfo.hostMsgTime <= l2) && (l2 != 0L)) {
            break label597;
          }
          m = 1;
          break;
          n -= 1;
          break label465;
        }
        label597:
        n = m;
        if (this.jdField_a_of_type_Long - localStickerInfo.hostMsgTime > 86400L)
        {
          m = 1;
          break label308;
          return;
        }
      }
      label625:
      m = n;
      break label308;
      label630:
      break;
      i1 = 0;
    }
  }
  
  private void a(ChatMessage paramChatMessage)
  {
    if (!paramChatMessage.isread)
    {
      if ((this.jdField_a_of_type_Int != 0) || (paramChatMessage.time <= this.jdField_b_of_type_Long)) {
        break label35;
      }
      this.jdField_b_of_type_Long = paramChatMessage.time;
    }
    label35:
    while (paramChatMessage.shmsgseq <= this.jdField_b_of_type_Long) {
      return;
    }
    this.jdField_b_of_type_Long = paramChatMessage.shmsgseq;
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
          break label347;
        }
      }
    }
    label347:
    for (int m = 1;; m = 0)
    {
      int n;
      if (m == 0)
      {
        List localList = paramQQAppInterface.getMessageProxy(paramMessageRecord.istroop).b(paramMessageRecord.frienduin, paramMessageRecord.istroop);
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
                ((MessageForMarketFace)localObject).msgData = MessagePkgUtils.a(((MessageForMarketFace)localObject).mMarkFaceMessage);
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
          break label210;
        }
        paramStickerInfo.originMsgType = paramMessageRecord.msgtype;
      }
      catch (Exception paramMessageRecord) {}
      paramMessageRecord.extLong |= 0x4;
      paramStickerInfo = new JSONObject();
      paramStickerInfo.put("msgType", m);
      paramMessageRecord.saveExtInfoToExtStr("Emoji_Sticker_Info", paramStickerInfo.toString());
      if (!jdField_f_of_type_Boolean) {
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
      ((MessageForMarketFace)localObject).msgData = MessagePkgUtils.a(((MessageForMarketFace)localObject).mMarkFaceMessage);
      continue;
      paramStickerInfo = paramMessageRecord.getExtInfoFromExtStr("sticker_info");
      if (!TextUtils.isEmpty(paramStickerInfo))
      {
        localObject = EmojiStickerManager.StickerInfo.transformFromJson(paramStickerInfo);
        if (localObject != null)
        {
          ((EmojiStickerManager.StickerInfo)localObject).originMsgType = m;
          if (m == -1000) {}
          for (paramStickerInfo = paramMessageRecord.msg;; paramStickerInfo = HardCodeUtil.a(2131704056))
          {
            ((EmojiStickerManager.StickerInfo)localObject).msg = paramStickerInfo;
            paramMessageRecord.stickerInfo = localObject;
            paramMessageRecord.saveExtInfoToExtStr("sticker_info", ((EmojiStickerManager.StickerInfo)localObject).toJsonString());
            break;
          }
          label210:
          switch (m)
          {
          }
        }
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
    if (QQText.IS_FXXKED_MTK) {
      paramStringBuilder.replace(paramInt1, paramInt1 + 2, "##");
    }
    while (paramInt2 != 10) {
      return;
    }
    paramStringBuilder.setCharAt(paramInt1 + 1, 'ú');
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
  
  private boolean a(long paramLong, boolean paramBoolean, EmojiStickerManager.StickerInfo paramStickerInfo)
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
  
  private boolean a(List<ChatMessage> paramList, ChatMessage paramChatMessage, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    if (paramStickerInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmojiStickerManager", 2, "sticker info is null! WTF!");
      }
      return true;
    }
    if (!jdField_f_of_type_Boolean)
    {
      paramChatMessage.msgtype = paramStickerInfo.originMsgType;
      return true;
    }
    a().a(paramChatMessage);
    paramList.remove(paramChatMessage);
    if (QLog.isColorLevel()) {
      QLog.i("EmojiStickerManager", 2, "isDisplay: " + paramStickerInfo.isDisplayed + ", isRead:" + paramChatMessage.isread + ", hostSeq: " + paramStickerInfo.hostMsgSeq + ", hostTime: " + paramStickerInfo.hostMsgTime);
    }
    return false;
  }
  
  private static int b(QQAppInterface paramQQAppInterface, String paramString, StructMsgForImageShare paramStructMsgForImageShare, PicMessageExtraData paramPicMessageExtraData)
  {
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    FavroamingDBManager localFavroamingDBManager = (FavroamingDBManager)paramQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
    Object localObject = localFavroamingDBManager.a();
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
            localFavroamingDBManager.a((CustomEmotionData)((List)localObject).get(n), n);
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
      if (i2 >= FavEmoConstant.jdField_a_of_type_Int) {
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
    localFavroamingDBManager.c((CustomEmotionBase)localObject);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(AppConstants.SDCARD_EMOTIOCN_DIY))) {
      ReportController.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
    }
    a(paramQQAppInterface, paramStructMsgForImageShare, (CustomEmotionData)localObject);
    paramQQAppInterface = (FavroamingManager)paramQQAppInterface.getManager(QQManagerFactory.FAV_ROAMING_MANAGER);
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
        android.os.Message localMessage = android.os.Message.obtain(null, 4);
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
            localBundle2.putString("QQ", ((QQAppInterface)localAppRuntime).getCurrentUin());
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
      jdField_i_of_type_Boolean = false;
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
    paramStructMsgForImageShare = AIOGallerySceneWithBusiness.a(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      paramQQAppInterface = (VipComicMqqManager)paramQQAppInterface.getManager(QQManagerFactory.MQQ_COMIC_MANAGER);
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
    if (paramQQAppInterface.hasNext())
    {
      paramHashMap = (MessageForUniteGrayTip)paramQQAppInterface.next();
      localObject = paramList.iterator();
      int m = 0;
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if (localMessageRecord.shmsgseq > paramHashMap.shmsgseq) {
            paramHashMap.time = (localMessageRecord.time - 10L);
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
  
  private void b(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap, List<MessageForUniteGrayTip> paramList1)
  {
    long l1;
    label30:
    label57:
    Pair localPair1;
    Object localObject1;
    Object localObject2;
    label224:
    int m;
    Object localObject3;
    if (paramList.size() > 0)
    {
      paramList = (ChatMessage)paramList.get(0);
      if (paramList == null) {
        break label437;
      }
      l1 = paramList.shmsgseq;
      long l2 = paramQQAppInterface.getMsgCache().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      paramList = paramHashMap.keySet().iterator();
      do
      {
        do
        {
          if (!paramList.hasNext()) {
            break;
          }
          localPair1 = (Pair)paramList.next();
          localObject1 = (List)paramHashMap.get(localPair1);
        } while ((localObject1 == null) || (((List)localObject1).size() == 0));
        localObject1 = (MessageRecord)((List)localObject1).get(0);
        localObject2 = a((MessageRecord)localObject1);
      } while (localObject2 == null);
      if (QLog.isColorLevel()) {
        QLog.i("EmojiStickerManager", 2, "unFind msg: shmsgseq: " + ((EmojiStickerManager.StickerInfo)localObject2).hostMsgSeq + ", isDisplay: " + ((EmojiStickerManager.StickerInfo)localObject2).isDisplayed + ", hostTime: " + ((EmojiStickerManager.StickerInfo)localObject2).hostMsgTime);
      }
      if ((!this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.containsKey(localPair1)) && (((Long)localPair1.first).longValue() <= l1)) {
        break label445;
      }
      n = 1;
      m = n;
      if (n == 0)
      {
        localObject3 = paramQQAppInterface.getMessageProxy(this.jdField_a_of_type_Int).c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
        m = n;
        if (localObject3 != null)
        {
          m = n;
          if (((List)localObject3).size() > 0)
          {
            if (((EmojiStickerManager.StickerInfo)localObject2).hostMsgSeq >= ((MessageRecord)((List)localObject3).get(0)).shmsgseq) {
              break label451;
            }
            m = n;
            if (((EmojiStickerManager.StickerInfo)localObject2).hostMsgSeq <= l2) {
              m = 1;
            }
          }
        }
      }
    }
    label318:
    label451:
    label460:
    MessageRecord localMessageRecord;
    for (;;)
    {
      if (m != 0)
      {
        localObject2 = new MessageForUniteGrayTip();
        localObject3 = BaseApplicationImpl.getApplication().getString(2131719515);
        ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(paramQQAppInterface, new UniteGrayTipParam(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).senderuin, (String)localObject3, this.jdField_a_of_type_Int, -5040, 1, ((MessageRecord)localObject1).time));
        ((MessageForUniteGrayTip)localObject2).shmsgseq = ((Long)localPair1.first).longValue();
        ((MessageForUniteGrayTip)localObject2).msgUid = ((Long)localPair1.second).longValue();
        ((MessageForUniteGrayTip)localObject2).mNeedTimeStamp = false;
        paramList1.add(localObject2);
        break label57;
        paramList = null;
        break;
        label437:
        l1 = 9223372036854775807L;
        break label30;
        label445:
        n = 0;
        break label224;
        localObject3 = ((List)localObject3).iterator();
        m = n;
        if (((Iterator)localObject3).hasNext())
        {
          localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
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
            if (localMessageRecord.shmsgseq == ((EmojiStickerManager.StickerInfo)localObject2).hostMsgSeq)
            {
              m = n;
              if (!MsgProxyUtils.a(localMessageRecord)) {
                if (localMessageRecord.msgtype != -2006) {
                  break label622;
                }
              }
            }
          }
        }
      }
    }
    label622:
    for (int n = 1;; n = 0)
    {
      m = n;
      if (n == 0) {
        break label318;
      }
      m = n;
      n = m;
      if (m == 0) {
        break label460;
      }
      n = m;
      if (!b(localMessageRecord)) {
        break label460;
      }
      m = 0;
      break label318;
      break;
    }
  }
  
  protected static void b(StringBuilder paramStringBuilder, int paramInt)
  {
    int i1 = 2;
    int m = 0;
    char[] arrayOfChar = new char[4];
    arrayOfChar[0] = paramStringBuilder.charAt(paramInt + 4);
    arrayOfChar[1] = paramStringBuilder.charAt(paramInt + 3);
    arrayOfChar[2] = paramStringBuilder.charAt(paramInt + 2);
    arrayOfChar[3] = paramStringBuilder.charAt(paramInt + 1);
    int n = i1;
    if (m < 3)
    {
      if (arrayOfChar[m] == 'ú') {
        arrayOfChar[m] = '\n';
      }
      for (;;)
      {
        m += 1;
        break;
        if (arrayOfChar[m] == 'þ') {
          arrayOfChar[m] = '\r';
        }
      }
    }
    if (n < 5)
    {
      if (paramStringBuilder.charAt(paramInt + n) == '\n') {
        paramStringBuilder.setCharAt(paramInt + n, 'ú');
      }
      for (;;)
      {
        n += 1;
        break;
        if (paramStringBuilder.charAt(paramInt + n) == '\r') {
          paramStringBuilder.setCharAt(paramInt + n, 'þ');
        }
      }
    }
  }
  
  private boolean b(long paramLong, boolean paramBoolean, EmojiStickerManager.StickerInfo paramStickerInfo)
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
    boolean bool2 = false;
    int n = paramMessageRecord.msgtype;
    if (((paramMessageRecord instanceof MessageForApollo)) && (ApolloGameUtil.a(((MessageForApollo)paramMessageRecord).msgType))) {}
    for (int m = 1;; m = 0)
    {
      boolean bool1 = QWalletRedPkgUtils.a(paramMessageRecord);
      if ((n != -1000) && (n != -2011) && (n != -2039) && ((n != -2025) || (!bool1)) && (n != -2007) && (n != -2000) && (n != -2002) && (n != -2022) && (n != -1035))
      {
        bool1 = bool2;
        if (n != -1049) {}
      }
      else
      {
        bool1 = bool2;
        if (m == 0) {
          bool1 = true;
        }
      }
      return bool1;
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
            break label591;
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
                  break label594;
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
          break label522;
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label512;
        }
        paramHashMap = (HashMap<Pair<Long, Long>, List<ChatMessage>>)localObject1;
      }
      for (;;)
      {
        paramHashMap = String.format("%s在上面贴了%d个表情", new Object[] { paramHashMap, Integer.valueOf(n) });
        localObject2 = new UniteGrayTipParam(((MessageRecord)localObject2).frienduin, paramQQAppInterface.getCurrentAccountUin(), paramHashMap, ((MessageRecord)localObject2).istroop, -5023, 1179651, ((MessageRecord)localObject2).time);
        localObject1 = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject2);
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
        label512:
        if (!TextUtils.isEmpty(paramHashMap))
        {
          continue;
          label522:
          localObject1 = (String)localObject1 + "、" + paramHashMap;
          paramHashMap = (HashMap<Pair<Long, Long>, List<ChatMessage>>)localObject1;
          if (m != 0) {
            paramHashMap = (String)localObject1 + HardCodeUtil.a(2131704054);
          }
        }
        else
        {
          paramHashMap = "";
        }
      }
      label591:
      break;
      label594:
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
      return paramContext.getResources().getDrawable(2130839778);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
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
  
  protected EmoticonInfo a(int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
  {
    int m = 0;
    int n = paramStringBuilder.charAt(paramInt1 + 1);
    Object localObject;
    boolean bool1;
    Emoticon localEmoticon;
    if ((n >= 255) && (paramInt1 + 4 < paramInt2))
    {
      localObject = new char[4];
      localObject[0] = paramStringBuilder.charAt(paramInt1 + 4);
      localObject[1] = paramStringBuilder.charAt(paramInt1 + 3);
      localObject[2] = paramStringBuilder.charAt(paramInt1 + 2);
      localObject[3] = paramStringBuilder.charAt(paramInt1 + 1);
      paramInt1 = 0;
      if (paramInt1 < 3)
      {
        if (localObject[paramInt1] == 'ú') {
          localObject[paramInt1] = 10;
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          if (localObject[paramInt1] == 'þ') {
            localObject[paramInt1] = 13;
          }
        }
      }
      if (n == 511)
      {
        bool1 = true;
        paramStringBuilder = new SmallEmoticonInfo(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        localEmoticon = new Emoticon();
        localObject = EmosmUtils.a((char[])localObject);
        if ((localObject == null) || (localObject.length != 2)) {
          break label334;
        }
        paramInt1 = localObject[0];
      }
    }
    for (paramInt2 = localObject[1];; paramInt2 = m)
    {
      localEmoticon.eId = String.valueOf(paramInt2);
      localEmoticon.epId = String.valueOf(paramInt1);
      localEmoticon.jobType = 3;
      paramStringBuilder.emoticon = localEmoticon;
      boolean bool2 = bool1;
      if (!bool1)
      {
        localObject = EmoticonUtils.getEmoticonManager();
        bool2 = bool1;
        if (localObject != null)
        {
          localObject = ((EmoticonManager)localObject).a(String.valueOf(paramInt1));
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
      paramStringBuilder.isAPNG = bool2;
      return paramStringBuilder;
      bool1 = false;
      break;
      if (n == 250) {
        return new SystemAndEmojiEmoticonInfo(7, 1, 10, "", false);
      }
      return new SystemAndEmojiEmoticonInfo(7, 1, n, "", false);
      label334:
      paramInt1 = 0;
    }
  }
  
  public EmoticonInfo a(String paramString)
  {
    int i4;
    int n;
    int i5;
    int i1;
    int m;
    if (!TextUtils.isEmpty(paramString))
    {
      int i3 = paramString.length();
      i4 = paramString.length();
      paramString = new StringBuilder().append(paramString);
      n = 0;
      if (n < i3)
      {
        i5 = paramString.codePointAt(n);
        if ((i5 == 20) && (n < i4 - 1)) {
          return a(n, i4, paramString);
        }
        i1 = EmotcationConstants.getSingleEmoji(i5);
        if (i5 > 65535)
        {
          if (i4 <= n + 2) {
            break label231;
          }
          m = paramString.codePointAt(n + 2);
        }
      }
    }
    for (;;)
    {
      label100:
      if (EmotcationConstants.isSkinEmoji(m)) {}
      for (int i2 = 1;; i2 = 0)
      {
        if ((i1 == -1) || (i2 != 0))
        {
          i2 = EmotcationConstants.getDoubleEmoji(i5, m);
          m = i2;
          if (i2 != -1) {}
        }
        for (m = i1;; m = i1)
        {
          if (m != -1)
          {
            return new SystemAndEmojiEmoticonInfo(7, 2, m, "", false);
            if (i4 <= n + 1) {
              break label231;
            }
            i2 = paramString.codePointAt(n + 1);
            m = i2;
            if (i2 != 65039) {
              break label100;
            }
            m = i2;
            if (i4 <= n + 2) {
              break label100;
            }
            m = paramString.codePointAt(n + 2);
            break label100;
          }
          n += 1;
          break;
          return null;
        }
      }
      label231:
      m = -1;
    }
  }
  
  public List<Long> a(MessageRecord paramMessageRecord)
  {
    if ((!jdField_f_of_type_Boolean) || (paramMessageRecord == null) || (paramMessageRecord.shmsgseq == 0L) || (paramMessageRecord.extraflag == 32772) || (paramMessageRecord.extraflag == 32768) || (paramMessageRecord.isMultiMsg) || (paramMessageRecord.isReMultiMsg)) {}
    do
    {
      return null;
      paramMessageRecord = a(paramMessageRecord);
    } while (paramMessageRecord == null);
    return (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramMessageRecord);
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
    if ((jdField_a_of_type_AndroidViewView instanceof BaseChatItemLayout))
    {
      paramView = (BaseChatItemLayout)jdField_a_of_type_AndroidViewView;
      if (paramView.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = paramView.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)localIterator.next();
          if (localSticker.jdField_f_of_type_Int == 255) {
            localSticker.jdField_f_of_type_Int = 127;
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
    this.jdField_c_of_type_Long = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.i("EmojiStickerManager", 2, "init, unReadCnt: " + this.jdField_b_of_type_Int + ", mInitLastReadSeq: " + this.jdField_a_of_type_Long);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, String paramString, int paramInt, boolean paramBoolean)
  {
    paramBaseChatPie.aS();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    jdField_i_of_type_Boolean = false;
    jdField_b_of_type_JavaLangString = "";
    l = -1;
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
        paramBaseChatPie.o(false);
        paramBaseChatPie.o(false);
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
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.b().a().a().a(), paramList);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, ChatXListView paramChatXListView, int paramInt, List<ChatMessage> paramList, HashMap<Pair<Long, Long>, List<ChatMessage>> paramHashMap, long paramLong, boolean paramBoolean)
  {
    if ((paramList.size() != 0) && (paramChatXListView.getChildCount() != 0) && (paramBoolean) && (this.jdField_b_of_type_Int > 0)) {
      a(paramQQAppInterface, paramInt, paramList, paramLong);
    }
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      if (paramList.size() <= 0) {
        break label96;
      }
      if (paramChatXListView.getChildCount() > 0)
      {
        if (this.jdField_a_of_type_Int == 0) {
          break label86;
        }
        b(paramQQAppInterface, paramList, paramHashMap);
      }
    }
    return;
    label86:
    a(paramQQAppInterface, paramList, paramHashMap);
    return;
    label96:
    a(paramList, paramQQAppInterface, paramHashMap);
  }
  
  public void a(QQAppInterface paramQQAppInterface, ChatXListView paramChatXListView, String paramString, int paramInt1, int paramInt2, List<ChatMessage> paramList)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    if ((paramList == null) || (paramList.size() == 0) || (paramChatXListView == null)) {
      return;
    }
    long l7 = System.currentTimeMillis();
    paramInt1 = 0;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
    paramString = null;
    long l4 = -9223372036854775808L;
    long l1 = -9223372036854775808L;
    long l2 = -9223372036854775808L;
    long l3 = -9223372036854775808L;
    boolean bool = false;
    int m = paramList.size() - 1;
    label91:
    ChatMessage localChatMessage;
    long l5;
    if (m >= 0)
    {
      localChatMessage = (ChatMessage)paramList.get(m);
      if (localChatMessage == null)
      {
        l5 = l1;
        l1 = l3;
        l3 = l5;
      }
    }
    for (;;)
    {
      m -= 1;
      l5 = l3;
      l3 = l1;
      l1 = l5;
      break label91;
      a(localChatMessage);
      if ((localChatMessage.msgtype == -2058) && (d(localChatMessage)))
      {
        long l6 = l3;
        l5 = l2;
        if (l2 == -9223372036854775808L)
        {
          l6 = l3;
          l5 = l2;
          if (l3 == -9223372036854775808L)
          {
            l6 = l3;
            l5 = l2;
            if (paramChatXListView.getAdapter() != null)
            {
              localObject = a(paramChatXListView, paramList);
              l5 = ((MessageRecord)localObject).shmsgseq;
              l6 = ((MessageRecord)localObject).time;
            }
          }
        }
        Object localObject = a(localChatMessage);
        if (a(paramList, localChatMessage, (EmojiStickerManager.StickerInfo)localObject))
        {
          l3 = l1;
          l1 = l6;
          l2 = l5;
        }
        else
        {
          if (!((EmojiStickerManager.StickerInfo)localObject).isDisplayed) {
            if (this.jdField_a_of_type_Int == 0) {
              if (localChatMessage.time > this.jdField_a_of_type_Long)
              {
                this.jdField_a_of_type_JavaUtilList.add(localChatMessage);
                if (l1 != -9223372036854775808L)
                {
                  l3 = l4;
                  l2 = l1;
                  if (((EmojiStickerManager.StickerInfo)localObject).hostMsgTime >= l1) {}
                }
                else
                {
                  l3 = l4;
                  l2 = l1;
                  if (((EmojiStickerManager.StickerInfo)localObject).hostMsgTime > this.jdField_c_of_type_Long)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.i("EmojiStickerManager", 2, "new navigate seq: " + ((EmojiStickerManager.StickerInfo)localObject).hostMsgSeq);
                    }
                    l2 = ((EmojiStickerManager.StickerInfo)localObject).hostMsgTime;
                    l3 = ((EmojiStickerManager.StickerInfo)localObject).hostMsgSeq;
                  }
                }
                bool = a(l6, bool, (EmojiStickerManager.StickerInfo)localObject);
                l1 = l2;
                l2 = l3;
              }
            }
          }
          for (;;)
          {
            paramString = a(paramString, localChatMessage);
            paramInt1 = paramString.size();
            l3 = l1;
            l4 = l2;
            l1 = l6;
            l2 = l5;
            break;
            ((EmojiStickerManager.StickerInfo)localObject).isDisplayed = true;
            l2 = l4;
            continue;
            if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3000))
            {
              if (localChatMessage.shmsgseq > this.jdField_a_of_type_Long)
              {
                this.jdField_a_of_type_JavaUtilList.add(localChatMessage);
                l2 = a(l4, (EmojiStickerManager.StickerInfo)localObject);
                bool = b(l5, bool, (EmojiStickerManager.StickerInfo)localObject);
              }
              else
              {
                ((EmojiStickerManager.StickerInfo)localObject).isDisplayed = true;
              }
            }
            else {
              l2 = l4;
            }
          }
        }
      }
      else
      {
        if (paramInt1 > 0)
        {
          paramString.remove(a(localChatMessage));
          paramInt1 = paramString.size();
          l5 = l1;
          l1 = l3;
          l3 = l5;
          continue;
          a(paramQQAppInterface, paramChatXListView, paramInt2, paramList, paramString, l4, bool);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("EmojiStickerManager", 2, "removeStickerMsgAndInsertGrayTips, cost=" + (System.currentTimeMillis() - l7));
          return;
        }
        l5 = l1;
        l1 = l3;
        l3 = l5;
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.msgtype == -2058) && (jdField_f_of_type_Boolean))
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
          EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)localIterator.next();
          if (localSticker.jdField_f_of_type_Int != 0) {
            localSticker.jdField_f_of_type_Int = 255;
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
    List localList = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
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
        if ((paramBaseChatPie instanceof HeaderViewListAdapter))
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
          if (!(paramBaseChatPie instanceof ChatAdapter1)) {
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
    if ((paramMessageRecord != null) && (paramMessageRecord.msgtype == -2058) && (jdField_f_of_type_Boolean) && (a(paramMessageRecord) != null))
    {
      if ((paramMessageRecord.frienduin.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Int == paramMessageRecord.istroop))
      {
        this.jdField_b_of_type_Int = 0;
        localObject = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject instanceof QQAppInterface)) {
          this.jdField_a_of_type_Long = ((QQAppInterface)localObject).getConversationFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
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
      if ((!localArrayList.contains(Long.valueOf(paramMessageRecord.uniseq))) && (localArrayList.size() < jdField_f_of_type_Int)) {
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
    if ((paramBaseChatPie != null) && (paramBaseChatPie.c != null) && ((paramBaseChatPie.c instanceof TopGestureLayout)))
    {
      TopGestureLayout localTopGestureLayout = (TopGestureLayout)paramBaseChatPie.c;
      if (!(localTopGestureLayout.getGestureDetector() instanceof StickerGestureDetector)) {
        localTopGestureLayout.setGestureDetector(new StickerGestureDetector(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, localTopGestureLayout.getGestureListener(), paramBaseChatPie));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiStickerManager
 * JD-Core Version:    0.7.0.1
 */