package com.tencent.mobileqq.dating;

import abxo;
import abxp;
import abxq;
import abxr;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class NearbyTransitActivity
  extends BaseActivity
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener, Handler.Callback
{
  private static long jdField_b_of_type_Long;
  protected int a;
  long jdField_a_of_type_Long;
  private HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new abxp(this);
  public QQProgressNotifier a;
  private String jdField_a_of_type_JavaLangString;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int d;
  private int e;
  
  private void a()
  {
    DatingUtil.a("NearbyTransitActivity", new Object[] { "parseParams" });
    Intent localIntent = getIntent();
    Bundle localBundle = localIntent.getExtras();
    this.jdField_a_of_type_JavaLangString = localBundle.getString("from");
    this.jdField_c_of_type_Int = localBundle.getInt("action");
    this.jdField_c_of_type_JavaLangString = localBundle.getString("params");
    if (this.jdField_c_of_type_Int == 1) {
      this.jdField_b_of_type_JavaLangString = localIntent.getExtras().getString("hotnamecode");
    }
    String str = localBundle.getString("apollo_game_id");
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      this.jdField_b_of_type_Int = Integer.parseInt(str);
      if ("1".equals(localBundle.getString("onwall"))) {
        this.d |= 0x2;
      }
      if ("1".equals(localBundle.getString("nonelbs"))) {
        this.jdField_b_of_type_Boolean = false;
      }
      if ("1".equals(localBundle.getString("fissile"))) {
        this.e = 1;
      }
      this.jdField_a_of_type_Long = localIntent.getLongExtra("enter_time", System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this, 2130970578);
      this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131558448);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("NearbyTransitActivity", 1, localNumberFormatException, new Object[0]);
      }
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a("openNearbyTransitActivity", 0);
    long l = Math.abs(System.currentTimeMillis() - jdField_b_of_type_Long);
    if ((paramContext == null) || ((l >= 0L) && (l < 800L))) {
      return;
    }
    jdField_b_of_type_Long = System.currentTimeMillis();
    Intent localIntent = new Intent(paramContext, NearbyTransitActivity.class);
    localIntent.putExtra("from", "10002");
    localIntent.putExtra("action", 2);
    localIntent.putExtra("params", paramString);
    localIntent.putExtra("enter_time", System.currentTimeMillis());
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, HashMap paramHashMap)
  {
    a("openNearbyTransitActivity", 0);
    long l = Math.abs(System.currentTimeMillis() - jdField_b_of_type_Long);
    if ((paramContext == null) || ((l >= 0L) && (l < 800L)) || (paramHashMap == null)) {
      return;
    }
    jdField_b_of_type_Long = System.currentTimeMillis();
    String str1;
    String str2;
    label89:
    String str3;
    label109:
    String str4;
    label129:
    String str5;
    label149:
    String str6;
    label169:
    String str7;
    label189:
    String str8;
    if (paramHashMap.containsKey("src_type"))
    {
      str1 = (String)paramHashMap.get("src_type");
      if (!paramHashMap.containsKey("from_type")) {
        break label390;
      }
      str2 = (String)paramHashMap.get("from_type");
      if (!paramHashMap.containsKey("from")) {
        break label397;
      }
      str3 = (String)paramHashMap.get("from");
      if (!paramHashMap.containsKey("version")) {
        break label404;
      }
      str4 = (String)paramHashMap.get("version");
      if (!paramHashMap.containsKey("onwall")) {
        break label411;
      }
      str5 = (String)paramHashMap.get("onwall");
      if (!paramHashMap.containsKey("nonelbs")) {
        break label418;
      }
      str6 = (String)paramHashMap.get("nonelbs");
      if (!paramHashMap.containsKey("fissile")) {
        break label425;
      }
      str7 = (String)paramHashMap.get("fissile");
      if (!paramHashMap.containsKey("newly_created")) {
        break label432;
      }
      str8 = (String)paramHashMap.get("newly_created");
      label209:
      if (!paramHashMap.containsKey("apollo_game_id")) {
        break label439;
      }
    }
    label390:
    label397:
    label404:
    label411:
    label418:
    label425:
    label432:
    label439:
    for (paramHashMap = (String)paramHashMap.get("apollo_game_id");; paramHashMap = "")
    {
      Object localObject = paramHashMap;
      if (TextUtils.isEmpty(paramHashMap))
      {
        int i = ApolloUtil.a(paramString);
        localObject = paramHashMap;
        if (i > 0) {
          localObject = String.valueOf(i);
        }
      }
      paramHashMap = new Intent(paramContext, NearbyTransitActivity.class);
      paramHashMap.putExtra("src_type", str1);
      paramHashMap.putExtra("from_type", str2);
      paramHashMap.putExtra("from", str3);
      paramHashMap.putExtra("version", str4);
      paramHashMap.putExtra("action", paramInt);
      paramHashMap.putExtra("hotnamecode", paramString);
      paramHashMap.putExtra("newly_created", str8);
      paramHashMap.putExtra("onwall", str5);
      paramHashMap.putExtra("nonelbs", str6);
      paramHashMap.putExtra("fissile", str7);
      paramHashMap.putExtra("enter_time", System.currentTimeMillis());
      paramHashMap.putExtra("apollo_game_id", (String)localObject);
      paramContext.startActivity(paramHashMap);
      return;
      str1 = "";
      break;
      str2 = "";
      break label89;
      str3 = "";
      break label109;
      str4 = "";
      break label129;
      str5 = "";
      break label149;
      str6 = "";
      break label169;
      str7 = "";
      break label189;
      str8 = "";
      break label209;
    }
  }
  
  private void a(HotChatInfo paramHotChatInfo)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    localMessage.obj = HotChatInfo.createWifiPOIInfo(paramHotChatInfo);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public static void a(String paramString, int paramInt) {}
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    a("enterAIO", 1);
    if (this.jdField_b_of_type_Int > 0)
    {
      localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("troop_uin", paramString2);
      localIntent.putExtra("uinname", paramString3);
      paramString1 = localIntent;
      startActivity(paramString1);
      long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      if (l > 0L) {
        a(this.app.getCurrentAccountUin(), true, l, 0);
      }
      finish();
      return;
    }
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("troop_uin", paramString2);
    localIntent.putExtra("uinname", paramString3);
    localIntent.addFlags(67108864);
    localIntent.putExtra("is_from_web", true);
    localIntent.putExtra("is_new_add", true);
    paramString1 = getIntent().getStringExtra("newly_created");
    if ((paramString1 != null) && ("1".equals(paramString1))) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("param_newly_created_hot_chat", bool);
      localIntent.putExtra("hotnamecode", getIntent().getStringExtra("hotnamecode"));
      localIntent.putExtra("HOTCHAT_EXTRA_FLAG", this.d);
      if ("10002".equals(this.jdField_a_of_type_JavaLangString))
      {
        localIntent.putExtra("abp_flag", true);
        localIntent.addFlags(268435456);
      }
      paramString1 = localIntent;
      break;
    }
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("NearbyTransitActivity", "reportResult", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    }
    ThreadManager.getSubThreadHandler().post(new abxr(paramInt, paramString, paramBoolean, paramLong));
  }
  
  private boolean a(HotChatInfo paramHotChatInfo)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)this.app.getManager(59)).a();
    ReportController.b(this.app, "CliOper", "", "", "0X8004412", "0X8004412", 1, 0, "", "", "", "");
    if (localHotChatInfo == null)
    {
      a(paramHotChatInfo);
      return true;
    }
    if (TextUtils.equals(paramHotChatInfo.uuid, localHotChatInfo.uuid))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyTransitActivity", 2, "enter poi hotchat start aio, has joined");
      }
      a(paramHotChatInfo.troopUin, paramHotChatInfo.troopCode, paramHotChatInfo.name);
      return true;
    }
    a(paramHotChatInfo);
    return true;
  }
  
  private void b()
  {
    int j = 0;
    int k = 0;
    int i = 0;
    a("doAction", 1);
    DatingUtil.a("NearbyTransitActivity", new Object[] { "doAction", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject;
    if (NetworkUtil.d(BaseApplication.getContext()))
    {
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver, true);
      if (this.jdField_c_of_type_Int == 1)
      {
        localObject = (HotChatHandler)this.app.a(35);
        if ((localObject != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
          if (this.jdField_b_of_type_Int > 0)
          {
            if (!((HotChatHandler)localObject).a(this.jdField_b_of_type_JavaLangString, this.d, this.jdField_b_of_type_Boolean, 0, this.jdField_b_of_type_Int)) {
              i = 1;
            }
            j = i;
            if (j == 0) {
              break label466;
            }
            i = 6;
          }
        }
        for (;;)
        {
          label147:
          k = j;
          j = i;
          i = k;
          label153:
          if (i == 0) {
            break label460;
          }
          localObject = Message.obtain();
          ((Message)localObject).what = 1;
          ((Message)localObject).arg1 = j;
          ((Message)localObject).obj = "加入热聊失败，请稍后再试。";
          label182:
          if (localObject == null) {
            break label464;
          }
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject, 200L);
          return;
          i = j;
          if (!((HotChatHandler)localObject).a(this.jdField_b_of_type_JavaLangString, this.d, this.jdField_b_of_type_Boolean)) {
            i = 1;
          }
          j = i;
          break;
          if (localObject == null)
          {
            i = 9;
            j = 1;
          }
          else
          {
            i = 10;
            j = 1;
          }
        }
      }
      if ((this.jdField_c_of_type_Int != 2) || (this.jdField_c_of_type_JavaLangString == null)) {}
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject(this.jdField_c_of_type_JavaLangString).getJSONObject("params");
        localHotChatInfo = HotChatInfo.createHotChat((JSONObject)localObject);
        if (localHotChatInfo == null) {
          break label480;
        }
        boolean bool = localHotChatInfo.isWifiHotChat;
        if (bool)
        {
          i = 1;
          j = 1;
          k = i;
          m = j;
        }
      }
      catch (JSONException localJSONException)
      {
        HotChatInfo localHotChatInfo;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NearbyTransitActivity", 2, "", localJSONException);
        this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
        k = 7;
        int m = 1;
        continue;
      }
      try
      {
        if (((JSONObject)localObject).has("fissile"))
        {
          this.e = ((JSONObject)localObject).getInt("fissile");
          m = j;
          k = i;
        }
      }
      catch (Exception localException)
      {
        localException.fillInStackTrace();
        k = i;
        m = j;
        continue;
      }
      i = m;
      j = k;
      break label153;
      i = k;
      if (!a(localHotChatInfo))
      {
        i = 1;
        break label471;
        j = 1;
        i = 1;
        break label153;
        Message localMessage = Message.obtain();
        localMessage.what = 1;
        localMessage.arg1 = 2;
        localMessage.obj = getString(2131437312);
        break label182;
        label460:
        localMessage = null;
        break label182;
        label464:
        break;
        label466:
        i = 1;
        break label147;
      }
      label471:
      k = 1;
      j = i;
      i = k;
      continue;
      label480:
      i = 8;
      j = 1;
    }
  }
  
  protected void a(Common.WifiPOIInfo paramWifiPOIInfo)
  {
    if (NetworkUtil.d(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(5);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(5, 200L);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 30000L);
      ThreadManager.post(new abxq(this, paramWifiPOIInfo), 5, null, true);
      return;
    }
    paramWifiPOIInfo = Message.obtain();
    paramWifiPOIInfo.what = 1;
    paramWifiPOIInfo.arg1 = 2;
    paramWifiPOIInfo.obj = getString(2131437312);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramWifiPOIInfo);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    a("doOnCreate", 1);
    super.doOnCreate(paramBundle);
    a();
    if (this.jdField_c_of_type_Int == 1)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(5, 800L);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 30000L);
    }
    ThreadManager.getFileThreadHandler().post(new abxo(this));
    return false;
  }
  
  protected void doOnDestroy()
  {
    DatingUtil.a("NearbyTransitActivity", new Object[] { "doOnDestroy" });
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    super.doOnDestroy();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    DatingUtil.a("NearbyTransitActivity", new Object[] { "handleMessage", Integer.valueOf(paramMessage.what) });
    switch (paramMessage.what)
    {
    }
    label226:
    do
    {
      return false;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
      }
      long l;
      if ((paramMessage.what == 2) || ((paramMessage.obj instanceof String)))
      {
        if (paramMessage.what == 2)
        {
          str1 = getString(2131437312);
          if ((paramMessage.obj instanceof String)) {
            str1 = (String)paramMessage.obj;
          }
          QQToast.a(BaseApplication.getContext(), str1, 0).b(this.jdField_a_of_type_Int);
        }
      }
      else
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
        this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
        l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        if (l > 0L)
        {
          str1 = this.app.getCurrentAccountUin();
          if (paramMessage.what != 2) {
            break label226;
          }
        }
      }
      for (int i = 4;; i = paramMessage.arg1)
      {
        a(str1, false, l, i);
        finish();
        return false;
        str1 = "加入热聊失败，请稍后再试。";
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
      }
      paramMessage = (Object[])paramMessage.obj;
      a((String)paramMessage[0], (String)paramMessage[1], (String)paramMessage[2]);
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
      finish();
      return false;
      a((Common.WifiPOIInfo)paramMessage.obj);
      return false;
    } while (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null);
    if (this.e == 1) {}
    for (String str1 = getString(2131437314);; str1 = getString(2131437313))
    {
      String str2 = str1;
      if (paramMessage.obj != null)
      {
        str2 = str1;
        if ((paramMessage.obj instanceof String))
        {
          str2 = (String)paramMessage.obj;
          NearbyUtils.a("NearbyTransitActivity", new Object[] { "handleMessage MSG_SHOW_LOADING ", str2 });
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, str2, 0, this);
      return false;
    }
  }
  
  protected boolean onBackEvent()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.arg1 = 3;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    return true;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = Message.obtain();
    paramDialogInterface.what = 1;
    paramDialogInterface.arg1 = 3;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramDialogInterface);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.dating.NearbyTransitActivity
 * JD-Core Version:    0.7.0.1
 */