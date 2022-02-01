package com.tencent.mobileqq.dating;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.hotchat.api.IHotChatHandler;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class NearbyTransitActivity
  extends BaseActivity
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener, Handler.Callback
{
  public static final String a;
  public static long b;
  public static long c;
  private static long jdField_d_of_type_Long;
  protected int a;
  long jdField_a_of_type_Long;
  private HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new NearbyTransitActivity.2(this);
  protected QQProgressNotifier a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int = 0;
  private String jdField_d_of_type_JavaLangString;
  private int e = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131705649);
    jdField_d_of_type_Long = 0L;
    jdField_b_of_type_Long = 0L;
    jdField_c_of_type_Long = 0L;
  }
  
  private void a()
  {
    DatingUtil.a("NearbyTransitActivity", new Object[] { "parseParams" });
    Intent localIntent = getIntent();
    Bundle localBundle = localIntent.getExtras();
    this.jdField_b_of_type_JavaLangString = localBundle.getString("from");
    this.jdField_c_of_type_Int = localBundle.getInt("action");
    this.jdField_d_of_type_JavaLangString = localBundle.getString("params");
    if (this.jdField_c_of_type_Int == 1) {
      this.jdField_c_of_type_JavaLangString = localIntent.getExtras().getString("hotnamecode");
    }
    if ("1".equals(localBundle.getString("onwall"))) {
      this.jdField_d_of_type_Int |= 0x2;
    }
    if ("1".equals(localBundle.getString("nonelbs"))) {
      this.jdField_b_of_type_Boolean = false;
    }
    if ("1".equals(localBundle.getString("fissile"))) {
      this.e = 1;
    }
    this.jdField_a_of_type_Long = localIntent.getLongExtra("enter_time", System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this, 2131561396);
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131299168);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a("openNearbyTransitActivity", 0);
    long l = Math.abs(System.currentTimeMillis() - jdField_d_of_type_Long);
    if (paramContext != null)
    {
      if ((l >= 0L) && (l < 800L)) {
        return;
      }
      jdField_d_of_type_Long = System.currentTimeMillis();
      Intent localIntent = new Intent(paramContext, NearbyTransitActivity.class);
      localIntent.putExtra("from", "10002");
      localIntent.putExtra("action", 2);
      localIntent.putExtra("params", paramString);
      localIntent.putExtra("enter_time", System.currentTimeMillis());
      paramContext.startActivity(localIntent);
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, HashMap<String, String> paramHashMap)
  {
    a("openNearbyTransitActivity", 0);
    long l = Math.abs(System.currentTimeMillis() - jdField_d_of_type_Long);
    if ((paramContext != null) && ((l < 0L) || (l >= 800L)))
    {
      if (paramHashMap == null) {
        return;
      }
      jdField_d_of_type_Long = System.currentTimeMillis();
      String str1;
      if (paramHashMap.containsKey("src_type")) {
        str1 = (String)paramHashMap.get("src_type");
      } else {
        str1 = "";
      }
      String str2;
      if (paramHashMap.containsKey("from_type")) {
        str2 = (String)paramHashMap.get("from_type");
      } else {
        str2 = "";
      }
      String str3;
      if (paramHashMap.containsKey("from")) {
        str3 = (String)paramHashMap.get("from");
      } else {
        str3 = "";
      }
      String str4;
      if (paramHashMap.containsKey("version")) {
        str4 = (String)paramHashMap.get("version");
      } else {
        str4 = "";
      }
      String str5;
      if (paramHashMap.containsKey("onwall")) {
        str5 = (String)paramHashMap.get("onwall");
      } else {
        str5 = "";
      }
      String str6;
      if (paramHashMap.containsKey("nonelbs")) {
        str6 = (String)paramHashMap.get("nonelbs");
      } else {
        str6 = "";
      }
      String str7;
      if (paramHashMap.containsKey("fissile")) {
        str7 = (String)paramHashMap.get("fissile");
      } else {
        str7 = "";
      }
      if (paramHashMap.containsKey("newly_created")) {
        paramHashMap = (String)paramHashMap.get("newly_created");
      } else {
        paramHashMap = "";
      }
      Intent localIntent = new Intent(paramContext, NearbyTransitActivity.class);
      localIntent.putExtra("src_type", str1);
      localIntent.putExtra("from_type", str2);
      localIntent.putExtra("from", str3);
      localIntent.putExtra("version", str4);
      localIntent.putExtra("action", paramInt);
      localIntent.putExtra("hotnamecode", paramString);
      localIntent.putExtra("newly_created", paramHashMap);
      localIntent.putExtra("onwall", str5);
      localIntent.putExtra("nonelbs", str6);
      localIntent.putExtra("fissile", str7);
      localIntent.putExtra("enter_time", System.currentTimeMillis());
      paramContext.startActivity(localIntent);
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
    Intent localIntent;
    if (this.jdField_b_of_type_Int > 0)
    {
      localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("troop_uin", paramString2);
      localIntent.putExtra("uinname", paramString3);
      paramString1 = localIntent;
    }
    else
    {
      localIntent = new Intent(this, ChatActivity.class);
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("troop_uin", paramString2);
      localIntent.putExtra("uinname", paramString3);
      localIntent.addFlags(67108864);
      localIntent.putExtra("is_from_web", true);
      localIntent.putExtra("is_new_add", true);
      paramString1 = getIntent().getStringExtra("newly_created");
      boolean bool;
      if ((paramString1 != null) && ("1".equals(paramString1))) {
        bool = true;
      } else {
        bool = false;
      }
      localIntent.putExtra("param_newly_created_hot_chat", bool);
      localIntent.putExtra("hotnamecode", getIntent().getStringExtra("hotnamecode"));
      localIntent.putExtra("HOTCHAT_EXTRA_FLAG", this.jdField_d_of_type_Int);
      paramString1 = localIntent;
      if ("10002".equals(this.jdField_b_of_type_JavaLangString))
      {
        localIntent.putExtra("abp_flag", true);
        localIntent.addFlags(268435456);
        paramString1 = localIntent;
      }
    }
    startActivity(paramString1);
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    if (l > 0L) {
      a(this.app.getCurrentAccountUin(), true, l, 0);
    }
    finish();
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("NearbyTransitActivity", "reportResult", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    }
    ThreadManager.getSubThreadHandler().post(new NearbyTransitActivity.4(paramInt, paramString, paramBoolean, paramLong));
  }
  
  private boolean a(HotChatInfo paramHotChatInfo)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a();
    ReportController.b(this.app, "CliOper", "", "", "0X8004412", "0X8004412", 1, 0, "", "", "", "");
    if (localHotChatInfo == null)
    {
      a(paramHotChatInfo);
    }
    else if (TextUtils.equals(paramHotChatInfo.uuid, localHotChatInfo.uuid))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyTransitActivity", 2, "enter poi hotchat start aio, has joined");
      }
      a(paramHotChatInfo.troopUin, paramHotChatInfo.troopCode, paramHotChatInfo.name);
    }
    else
    {
      a(paramHotChatInfo);
    }
    return true;
  }
  
  private void b()
  {
    a("doAction", 1);
    DatingUtil.a("NearbyTransitActivity", new Object[] { "doAction", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Message localMessage = null;
    int i;
    Object localObject;
    boolean bool;
    int j;
    if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver, true);
      i = this.jdField_c_of_type_Int;
      if (i == 1)
      {
        localObject = (IHotChatHandler)this.app.getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName());
        if ((localObject != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
        {
          i = this.jdField_b_of_type_Int;
          if (i > 0) {
            bool = ((IHotChatHandler)localObject).quickJoinHotChat(this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_b_of_type_Boolean, 0, i);
          } else {
            bool = ((IHotChatHandler)localObject).quickJoinHotChat(this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_b_of_type_Boolean);
          }
          j = bool ^ true;
          i = j;
          if (j != 0)
          {
            int k = 6;
            i = j;
            j = k;
            break label367;
          }
        }
        else
        {
          if (localObject == null)
          {
            i = 1;
            j = 9;
            break label367;
          }
          i = 1;
          j = 10;
          break label367;
        }
      }
      else if (i == 2)
      {
        localObject = this.jdField_d_of_type_JavaLangString;
        if (localObject == null) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject).getJSONObject("params");
        HotChatInfo localHotChatInfo = HotChatInfo.createHotChat((JSONObject)localObject);
        if (localHotChatInfo != null)
        {
          if (localHotChatInfo.isWifiHotChat)
          {
            i = 1;
            break label447;
          }
          bool = a(localHotChatInfo);
          i = bool ^ true;
          break label447;
        }
        i = 1;
        j = 8;
        try
        {
          if (((JSONObject)localObject).has("fissile")) {
            this.e = ((JSONObject)localObject).getInt("fissile");
          }
        }
        catch (Exception localException)
        {
          localException.fillInStackTrace();
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyTransitActivity", 2, "", localJSONException);
        }
        this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
        j = 7;
        i = 1;
      }
      break label367;
      i = 1;
      j = 1;
      label367:
      if (i != 0)
      {
        localMessage = Message.obtain();
        localMessage.what = 1;
        localMessage.arg1 = j;
        localMessage.obj = jdField_a_of_type_JavaLangString;
        break label428;
        localMessage = Message.obtain();
        localMessage.what = 1;
        localMessage.arg1 = 2;
        localMessage.obj = getString(2131693191);
      }
      label428:
      if (localMessage != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 200L);
      }
      return;
      label447:
      j = 1;
    }
  }
  
  protected void a(Common.WifiPOIInfo paramWifiPOIInfo)
  {
    if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(5);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(5, 200L);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 30000L);
      ThreadManager.post(new NearbyTransitActivity.3(this, paramWifiPOIInfo), 5, null, true);
      return;
    }
    paramWifiPOIInfo = Message.obtain();
    paramWifiPOIInfo.what = 1;
    paramWifiPOIInfo.arg1 = 2;
    paramWifiPOIInfo.obj = getString(2131693191);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramWifiPOIInfo);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
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
    ThreadManager.getFileThreadHandler().post(new NearbyTransitActivity.1(this));
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
    int j = paramMessage.what;
    int i = 4;
    Object localObject;
    if ((j != 1) && (j != 2))
    {
      if (j != 3)
      {
        if (j != 4)
        {
          if (j != 5) {
            return false;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null)
          {
            if (this.e == 1) {
              i = 2131693182;
            } else {
              i = 2131693181;
            }
            String str = getString(i);
            localObject = str;
            if (paramMessage.obj != null)
            {
              localObject = str;
              if ((paramMessage.obj instanceof String))
              {
                localObject = (String)paramMessage.obj;
                NearbyUtils.a("NearbyTransitActivity", new Object[] { "handleMessage MSG_SHOW_LOADING ", localObject });
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, (String)localObject, 0, this);
            return false;
          }
        }
        else
        {
          a((Common.WifiPOIInfo)paramMessage.obj);
          return false;
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
        if (localObject != null) {
          ((QQProgressNotifier)localObject).b();
        }
        paramMessage = (Object[])paramMessage.obj;
        a((String)paramMessage[0], (String)paramMessage[1], (String)paramMessage[2]);
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
        this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
        finish();
        return false;
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
      if (localObject != null) {
        ((QQProgressNotifier)localObject).b();
      }
      if ((paramMessage.what == 2) || ((paramMessage.obj instanceof String)))
      {
        if (paramMessage.what == 2) {
          localObject = getString(2131693191);
        } else {
          localObject = jdField_a_of_type_JavaLangString;
        }
        if ((paramMessage.obj instanceof String)) {
          localObject = (String)paramMessage.obj;
        }
        QQToast.a(BaseApplication.getContext(), (CharSequence)localObject, 0).b(this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
      long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      if (l > 0L)
      {
        localObject = this.app.getCurrentAccountUin();
        if (paramMessage.what != 2) {
          i = paramMessage.arg1;
        }
        a((String)localObject, false, l, i);
      }
      finish();
    }
    return false;
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
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dating.NearbyTransitActivity
 * JD-Core Version:    0.7.0.1
 */