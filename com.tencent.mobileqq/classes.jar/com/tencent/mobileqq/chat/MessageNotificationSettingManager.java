package com.tencent.mobileqq.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.quickupdate.RingUpdateCallback;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.manager.Manager;

public class MessageNotificationSettingManager
  implements Manager
{
  private final FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private MessageNotificationSettingManager.RingCallback jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager$RingCallback;
  private Map<Integer, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public MessageNotificationSettingManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
    this.jdField_a_of_type_JavaUtilMap = new MessageNotificationSettingManager.1(this);
  }
  
  private int a(String paramString, int paramInt)
  {
    if (b(paramString))
    {
      if ((b()) && (a(paramString))) {
        return 2131230766;
      }
      return a();
    }
    return paramInt;
  }
  
  public static MessageNotificationSettingManager a(QQAppInterface paramQQAppInterface)
  {
    return (MessageNotificationSettingManager)paramQQAppInterface.getManager(QQManagerFactory.MESSAGE_NOTIFICATION_SETTING_MANAGER);
  }
  
  public static ExtensionInfo a(ExtensionInfo paramExtensionInfo)
  {
    ExtensionInfo localExtensionInfo = new ExtensionInfo();
    localExtensionInfo.uin = paramExtensionInfo.uin;
    localExtensionInfo.messageEnableSoundNew = paramExtensionInfo.messageEnableSoundNew;
    localExtensionInfo.messageEnableVibrateNew = paramExtensionInfo.messageEnableVibrateNew;
    localExtensionInfo.messageEnablePreviewNew = paramExtensionInfo.messageEnablePreviewNew;
    return localExtensionInfo;
  }
  
  private void a(String paramString)
  {
    paramString = new MessageNotificationSettingManager.3(this, paramString);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManager.post(paramString, 10, null, false);
      return;
    }
    paramString.run();
  }
  
  private boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "isLocalRingId: invoked. ", " id: ", Integer.valueOf(paramInt), " R.raw.system: ", Integer.valueOf(2131230769), " R.raw.classic: ", Integer.valueOf(2131230720) });
    }
    boolean bool = this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "isLocalRingId: invoked. ", " isLocal: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    if (paramMessageRecord == null) {
      return false;
    }
    int i;
    if ((paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    boolean bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (Friends.isValidUin(paramMessageRecord.frienduin)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo != null) {
      return TroopInfo.isCmdUinFlagEx2Open(paramTroopInfo.cmdUinFlagEx2, 1024) ^ true;
    }
    return true;
  }
  
  public static byte[] a(ExtensionInfo paramExtensionInfo)
  {
    int i;
    if (paramExtensionInfo.messageEnablePreviewNew == 1) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (paramExtensionInfo.messageEnableVibrateNew == 1) {
      j = 2;
    } else {
      j = 0;
    }
    int k;
    if (paramExtensionInfo.messageEnableSoundNew == 1) {
      k = 4;
    } else {
      k = 0;
    }
    paramExtensionInfo = PkgTools.intToBytes(k | i | j);
    return new byte[] { paramExtensionInfo[1], paramExtensionInfo[0] };
  }
  
  private boolean b()
  {
    boolean bool;
    if (((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getSpecialCareRingRoamingSetting(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MessageNotificationSettingManager", 2, new Object[] { "globalSpCaredRingEnable: invoked. ", "enable: ", Boolean.valueOf(bool), new RuntimeException() });
    }
    return bool;
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    return c(paramMessageRecord.senderuin, paramMessageRecord.istroop);
  }
  
  private boolean b(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo != null) {
      return TroopInfo.isCmdUinFlagEx2Open(paramTroopInfo.cmdUinFlagEx2, 4096) ^ true;
    }
    return true;
  }
  
  private void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "playRingId: invoked. ", " id: ", Integer.valueOf(paramInt) });
    }
    int j = a();
    int i;
    if (j == AppSetting.d)
    {
      i = j;
    }
    else
    {
      i = j;
      if (j == AppSetting.e) {
        i = 2131230721;
      }
    }
    j = paramInt;
    if (paramInt == 0) {
      j = i;
    }
    if (a(j))
    {
      paramInt = j;
      if (j == AppSetting.e) {
        paramInt = 2131230721;
      }
      AudioUtil.b(paramInt, false);
      return;
    }
    Object localObject = new MessageNotificationSettingManager.2(this, j);
    boolean bool = RingUpdateCallback.isRingExists(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), j);
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "playRingId: invoked. ", " ringExists: ", Boolean.valueOf(bool), " targetId: ", Integer.valueOf(j) });
    }
    if (!bool)
    {
      RingUpdateCallback.downloadRing(j, (QuickUpdateListener)localObject, false);
      return;
    }
    localObject = RingUpdateCallback.getWavPath(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), j);
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "playRingId: invoked. ", " wavPath: ", localObject });
    }
    a((String)localObject);
  }
  
  private void c(MessageRecord paramMessageRecord)
  {
    a(paramMessageRecord);
    int i = a();
    paramMessageRecord = paramMessageRecord.senderuin;
    ExtensionInfo localExtensionInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramMessageRecord);
    if (localExtensionInfo == null)
    {
      QLog.d("MessageNotificationSettingManager", 1, new Object[] { "playFriendRing: invoked. using global id ", " extensionInfo: ", localExtensionInfo });
      c(i);
      return;
    }
    int j = localExtensionInfo.friendRingId;
    i = j;
    if (j == 0) {
      i = a(paramMessageRecord, j);
    }
    c(i);
  }
  
  private boolean c(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo != null) {
      return TroopInfo.isCmdUinFlagEx2Open(paramTroopInfo.cmdUinFlagEx2, 2048) ^ true;
    }
    return true;
  }
  
  private boolean c(String paramString, int paramInt)
  {
    boolean bool = b(paramString);
    return (paramInt == 1) && (bool);
  }
  
  public int a()
  {
    int i = SettingCloneUtil.readValueForInt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.b);
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "getGlobalRingId: invoked. ", " soundRid: ", Integer.valueOf(i) });
    }
    return i;
  }
  
  public Bitmap a(Bitmap paramBitmap, Message paramMessage)
  {
    if (a(paramMessage.frienduin, paramMessage.istroop)) {
      return paramBitmap;
    }
    return null;
  }
  
  public String a(int paramInt1, String paramString, int paramInt2)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.context;
    String str = RingUpdateCallback.getName(localBaseApplication, paramInt1);
    if (a(paramInt1))
    {
      paramString = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
    }
    else if (paramInt1 == 0)
    {
      int i = a();
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingManager", 2, new Object[] { "setRingFormSimpleItem: invoked. from sp key:QQSETTING_NOTIFY_SOUNDTYPE_KEY ", " globalRingId: ", Integer.valueOf(i) });
      }
      paramInt1 = i;
      if (paramInt2 == 0) {
        paramInt1 = a(paramString, i);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingManager", 2, new Object[] { "setRingFormSimpleItem: invoked. getRingIdCheckSpCaredFriendAndGlobalSwitch:: ", " targetRingId: ", Integer.valueOf(paramInt1) });
      }
      if (a(paramInt1))
      {
        paramString = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
      }
      else
      {
        paramString = RingUpdateCallback.getName(localBaseApplication, paramInt1);
        if (TextUtils.isEmpty(paramString)) {
          a(paramInt1);
        }
      }
    }
    else
    {
      paramString = str;
      if (TextUtils.isEmpty(str))
      {
        a(paramInt1);
        paramString = str;
      }
    }
    str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return str;
  }
  
  public String a(String paramString, Message paramMessage)
  {
    if (a(paramMessage.frienduin, paramMessage.istroop)) {
      return paramString;
    }
    paramString = new StringBuilder();
    paramString.append(HardCodeUtil.a(2131706679));
    paramString.append(paramMessage.counter);
    paramString.append(HardCodeUtil.a(2131706680));
    return paramString.toString();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit().putBoolean("SP_KEY_RESET_GRAY_USER_RING_ID", true).apply();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageNotificationSettingManager", 2, new Object[] { "preDownloadRing: invoked. ", "ring-id: ", Integer.valueOf(paramInt) });
    }
    if ((paramInt > 0) && (!RingUpdateCallback.isRingExists(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramInt)) && (!a(paramInt))) {
      RingUpdateCallback.downloadRing(paramInt, new MessageNotificationSettingManager.RingUpdateListener(this, paramInt), false);
    }
  }
  
  public void a(MessageNotificationSettingManager.RingCallback paramRingCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager$RingCallback = paramRingCallback;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    String str = paramMessageRecord.senderuin;
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "compactUpdateRingData: invoked. ", " message.senderuin: ", str });
    }
    b(str, paramMessageRecord.istroop);
  }
  
  public void a(FormSimpleItem paramFormSimpleItem, int paramInt)
  {
    a(paramFormSimpleItem, paramInt, null, -1);
  }
  
  public void a(FormSimpleItem paramFormSimpleItem, int paramInt1, String paramString, int paramInt2)
  {
    if (paramFormSimpleItem == null) {
      return;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.context;
    String str = RingUpdateCallback.getName(localBaseApplication, paramInt1);
    if (a(paramInt1))
    {
      paramString = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
    }
    else if (paramInt1 == 0)
    {
      int i = a();
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingManager", 2, new Object[] { "setRingFormSimpleItem: invoked. from sp key:QQSETTING_NOTIFY_SOUNDTYPE_KEY ", " globalRingId: ", Integer.valueOf(i) });
      }
      paramInt1 = i;
      if (paramInt2 == 0) {
        paramInt1 = a(paramString, i);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingManager", 2, new Object[] { "setRingFormSimpleItem: invoked. getRingIdCheckSpCaredFriendAndGlobalSwitch:: ", " targetRingId: ", Integer.valueOf(paramInt1) });
      }
      if (a(paramInt1))
      {
        paramString = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
      }
      else
      {
        paramString = RingUpdateCallback.getName(localBaseApplication, paramInt1);
        if (TextUtils.isEmpty(paramString)) {
          a(paramInt1);
        }
      }
    }
    else
    {
      paramString = str;
      if (TextUtils.isEmpty(str))
      {
        a(paramInt1);
        paramString = str;
      }
    }
    str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    paramFormSimpleItem.setRightText(str);
    paramString = new StringBuilder();
    paramString.append(localBaseApplication.getString(2131690854));
    paramString.append(str);
    paramFormSimpleItem.setContentDescription(paramString.toString());
  }
  
  public void a(String paramString, int paramInt)
  {
    ExtensionInfo localExtensionInfo2 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString);
    ExtensionInfo localExtensionInfo1 = localExtensionInfo2;
    if (localExtensionInfo2 == null)
    {
      localExtensionInfo1 = new ExtensionInfo();
      localExtensionInfo1.uin = paramString;
    }
    if (localExtensionInfo1.friendRingId != paramInt)
    {
      localExtensionInfo1.friendRingId = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(localExtensionInfo1);
    }
    a(paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    TroopInfo localTroopInfo2 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(paramString);
    TroopInfo localTroopInfo1 = localTroopInfo2;
    if (localTroopInfo2 == null)
    {
      localTroopInfo1 = new TroopInfo();
      localTroopInfo1.troopuin = paramString;
      localTroopInfo1.troopcode = paramString;
    }
    boolean bool;
    if (paramInt1 != 1) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramInt2 == 1024) {
      localTroopInfo1.setCmdUinFlagEx2(bool, 1024);
    } else if (paramInt2 == 2048) {
      localTroopInfo1.setCmdUinFlagEx2(bool, 2048);
    } else if (paramInt2 == 4096) {
      localTroopInfo1.setCmdUinFlagEx2(bool, 4096);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "saveTroopInfo: invoked. ", " troopInfo.cmdUinFlagEx2: ", Long.valueOf(localTroopInfo1.cmdUinFlagEx2) });
    }
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(localTroopInfo1);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    ExtensionInfo localExtensionInfo2 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString);
    ExtensionInfo localExtensionInfo1 = localExtensionInfo2;
    if (localExtensionInfo2 == null)
    {
      localExtensionInfo1 = new ExtensionInfo();
      localExtensionInfo1.uin = paramString;
    }
    if (paramInt == 1) {
      localExtensionInfo1.messageEnablePreviewNew = (paramBoolean ^ true);
    } else if (paramInt == 3) {
      localExtensionInfo1.messageEnableVibrateNew = (paramBoolean ^ true);
    } else if (paramInt == 2) {
      localExtensionInfo1.messageEnableSoundNew = (paramBoolean ^ true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "saveExtensionInfo: invoked. ", " uin: ", paramString, " type: ", Integer.valueOf(paramInt), " enable: ", Boolean.valueOf(paramBoolean) });
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(localExtensionInfo1);
  }
  
  public void a(List<ExtensionInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ExtensionInfo localExtensionInfo = (ExtensionInfo)paramList.next();
      if (localExtensionInfo.friendRingId != 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("special_sound_type");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localStringBuilder.append(localExtensionInfo.uin);
        int i = localSharedPreferences.getInt(localStringBuilder.toString(), -1);
        if (QLog.isColorLevel()) {
          QLog.d("MessageNotificationSettingManager", 2, new Object[] { "resetGrayUserRingId: invoked. ", " specialSoundId: ", Integer.valueOf(i), " uin: ", localExtensionInfo.uin });
        }
        if (localExtensionInfo.friendRingId == i)
        {
          localExtensionInfo.friendRingId = 0;
          this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(localExtensionInfo);
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getBoolean("SP_KEY_RESET_GRAY_USER_RING_ID", false);
  }
  
  public boolean a(String paramString)
  {
    SpecialCareInfo localSpecialCareInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString);
    boolean bool2 = false;
    if (localSpecialCareInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingManager", 2, new Object[] { "isSpCareFriendRingEnable: invoked. ", " info: ", localSpecialCareInfo, " info.globalSwitch: ", Integer.valueOf(localSpecialCareInfo.globalSwitch), " info.specialRingSwitch: ", Integer.valueOf(localSpecialCareInfo.specialRingSwitch) });
      }
      bool1 = bool2;
      if (localSpecialCareInfo.globalSwitch == 1)
      {
        bool1 = bool2;
        if (localSpecialCareInfo.specialRingSwitch == 1) {
          bool1 = true;
        }
      }
      return bool1;
    }
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.e();
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "isSpCareFriendRingEnable: invoked. ", " spCareInfoCacheInited: ", Boolean.valueOf(bool1), " uin: ", paramString });
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isShowMsgContent()) {
      return true;
    }
    if (!Friends.isValidUin(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enablePreview: invoked. ", " uin: ", paramString });
      }
      return true;
    }
    if (paramInt == 0)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString, false);
      if (paramString == null) {
        return true;
      }
      return paramString.messageEnablePreviewNew == 0;
    }
    if (paramInt == 1)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramString);
      if (paramString == null) {
        return true;
      }
      return a(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enablePreview: invoked. ", " uinType: ", Integer.valueOf(paramInt) });
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean, String paramString, int paramInt)
  {
    boolean bool = false;
    if (!paramBoolean) {
      return false;
    }
    if (!Friends.isValidUin(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateVibrate: invoked. ", " uin: ", paramString });
      }
      return true;
    }
    if (paramInt == 0)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString, false);
      if (paramString == null) {
        return true;
      }
      paramBoolean = bool;
      if (paramString.messageEnableVibrateNew == 0) {
        paramBoolean = true;
      }
      return paramBoolean;
    }
    if (paramInt == 1)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramString);
      if (paramString == null) {
        return true;
      }
      return b(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateVibrate: invoked. ", " uinType: ", Integer.valueOf(paramInt) });
    }
    return true;
  }
  
  public String b(String paramString, Message paramMessage)
  {
    if (a(paramMessage.frienduin, paramMessage.istroop)) {
      return paramString;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694524);
  }
  
  public void b()
  {
    int i = a();
    c(i);
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "playGlobalRing: invoked. ", " globalRingId: ", Integer.valueOf(i) });
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "saveGlobalRingId: invoked. ", " id: ", Integer.valueOf(paramInt) });
    }
    if ((a() != paramInt) && (paramInt != 0))
    {
      SettingCloneUtil.writeValueForInt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", paramInt);
      a(paramInt);
    }
  }
  
  public void b(MessageNotificationSettingManager.RingCallback paramRingCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager$RingCallback = null;
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    int i = a();
    if (paramMessageRecord.istroop == 0)
    {
      c(paramMessageRecord);
      return;
    }
    if (paramMessageRecord.istroop == 1)
    {
      if (b(paramMessageRecord))
      {
        c(paramMessageRecord);
        return;
      }
      if (TroopKeywordManager.a(paramMessageRecord))
      {
        c(2131230766);
        return;
      }
      paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(paramMessageRecord.frienduin);
      if (paramMessageRecord == null)
      {
        c(i);
        return;
      }
      c((int)paramMessageRecord.udwCmdUinRingtoneID);
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "compactUpdateRingData: invoked. ", " targetUin: ", paramString, " uinType: ", Integer.valueOf(paramInt) });
    }
    if ((paramInt == 0) || (c(paramString, paramInt)))
    {
      boolean bool1 = a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingManager", 2, new Object[] { "compactUpdateRingData: invoked. ", " spCareFriendRingEnable: ", Boolean.valueOf(bool1), " targetUin: ", paramString });
      }
      boolean bool2 = b();
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingManager", 2, new Object[] { "compactUpdateRingData: invoked. ", " globalSpCaredRingEnable: ", Boolean.valueOf(bool2) });
      }
      if ((bool1) && (bool2))
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString);
        if ((localObject == null) || (((ExtensionInfo)localObject).friendRingId == 0))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("special_sound_type");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          localStringBuilder.append(paramString);
          paramInt = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), -1);
          if (QLog.isColorLevel()) {
            QLog.d("MessageNotificationSettingManager", 2, new Object[] { "compactUpdateRingData: invoked. ", " specialSoundId: ", Integer.valueOf(paramInt) });
          }
          if (paramInt != -1) {
            a(paramString, paramInt);
          }
        }
      }
    }
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.globalSwitch == 1;
  }
  
  public boolean b(String paramString, int paramInt)
  {
    if (!Friends.isValidUin(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateSoundWhenGlobalSwitchOff: invoked. ", " uin: ", paramString });
      }
      return false;
    }
    if (paramInt == 0)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString, true);
      if (paramString == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateSoundWhenGlobalSwitchOff: invoked. ", " extensionInfo: ", paramString });
        }
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateSoundWhenGlobalSwitchOff: invoked. ", " messageEnableSoundNew: ", Integer.valueOf(paramString.messageEnableSoundNew) });
      }
      return paramString.messageEnableSoundNew == 0;
    }
    if (paramInt == 1)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(paramString);
      if (paramString == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateSoundWhenGlobalSwitchOff: invoked. ", " troopInfo: ", paramString });
        }
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateSoundWhenGlobalSwitchOff: invoked. ", " messageEnableSound: ", Boolean.valueOf(c(paramString)) });
      }
      return c(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateSoundWhenGlobalSwitchOff: invoked. ", " uinType: ", Integer.valueOf(paramInt) });
    }
    return false;
  }
  
  public boolean b(boolean paramBoolean, String paramString, int paramInt)
  {
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = false;
    if (bool2) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateSound: invoked. ", " globalSwitch: ", Boolean.valueOf(paramBoolean), " uin: ", paramString, " uinType: ", Integer.valueOf(paramInt) });
    }
    if (!paramBoolean) {
      return false;
    }
    if (!Friends.isValidUin(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateSound: invoked. ", " uin: ", paramString });
      }
      return true;
    }
    if (paramInt == 0)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString, false);
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateSound: invoked. ", " extensionInfo: ", paramString });
      }
      if (paramString == null) {
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateSound: invoked. ", " extensionInfo.messageEnableSoundNew: ", Integer.valueOf(paramString.messageEnableSoundNew) });
      }
      paramBoolean = bool1;
      if (paramString.messageEnableSoundNew == 0) {
        paramBoolean = true;
      }
      return paramBoolean;
    }
    if (paramInt == 1)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramString);
      if (paramString == null) {
        return true;
      }
      return c(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateSound: invoked. ", " uinType: ", Integer.valueOf(paramInt) });
    }
    return true;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.chat.MessageNotificationSettingManager
 * JD-Core Version:    0.7.0.1
 */