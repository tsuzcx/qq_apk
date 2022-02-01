package com.tencent.mobileqq.dating;

import Override;
import agej;
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
import anzp;
import aoaa;
import asam;
import asbd;
import axxb;
import bdll;
import bhlj;
import bhnv;
import bjbv;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.HotChatInfo;
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
  private static long jdField_b_of_type_Long;
  protected int a;
  long jdField_a_of_type_Long;
  private aoaa jdField_a_of_type_Aoaa = new asbd(this);
  public bjbv a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private int e;
  
  static
  {
    jdField_a_of_type_JavaLangString = anzp.jdField_c_of_type_JavaLangString;
  }
  
  private void a()
  {
    asam.a("NearbyTransitActivity", new Object[] { "parseParams" });
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
    this.jdField_a_of_type_Bjbv = new bjbv(this, 2131561501);
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131299011);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler = new bhlj(Looper.getMainLooper(), this);
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
  
  public static void a(Context paramContext, String paramString, int paramInt, HashMap<String, String> paramHashMap)
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
    if (paramHashMap.containsKey("src_type"))
    {
      str1 = (String)paramHashMap.get("src_type");
      if (!paramHashMap.containsKey("from_type")) {
        break label342;
      }
      str2 = (String)paramHashMap.get("from_type");
      if (!paramHashMap.containsKey("from")) {
        break label349;
      }
      str3 = (String)paramHashMap.get("from");
      if (!paramHashMap.containsKey("version")) {
        break label356;
      }
      str4 = (String)paramHashMap.get("version");
      if (!paramHashMap.containsKey("onwall")) {
        break label363;
      }
      str5 = (String)paramHashMap.get("onwall");
      if (!paramHashMap.containsKey("nonelbs")) {
        break label370;
      }
      str6 = (String)paramHashMap.get("nonelbs");
      if (!paramHashMap.containsKey("fissile")) {
        break label377;
      }
      str7 = (String)paramHashMap.get("fissile");
      label189:
      if (!paramHashMap.containsKey("newly_created")) {
        break label384;
      }
    }
    label384:
    for (paramHashMap = (String)paramHashMap.get("newly_created");; paramHashMap = "")
    {
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
      return;
      str1 = "";
      break;
      label342:
      str2 = "";
      break label89;
      label349:
      str3 = "";
      break label109;
      label356:
      str4 = "";
      break label129;
      label363:
      str5 = "";
      break label149;
      label370:
      str6 = "";
      break label169;
      label377:
      str7 = "";
      break label189;
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
      localIntent = agej.a(new Intent(this, SplashActivity.class), null);
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
      localIntent.putExtra("HOTCHAT_EXTRA_FLAG", this.jdField_d_of_type_Int);
      if ("10002".equals(this.jdField_b_of_type_JavaLangString))
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
      axxb.a("NearbyTransitActivity", "reportResult", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    }
    ThreadManager.getSubThreadHandler().post(new NearbyTransitActivity.4(paramInt, paramString, paramBoolean, paramLong));
  }
  
  private boolean a(HotChatInfo paramHotChatInfo)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)this.app.getManager(60)).a();
    bdll.b(this.app, "CliOper", "", "", "0X8004412", "0X8004412", 1, 0, "", "", "", "");
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
    asam.a("NearbyTransitActivity", new Object[] { "doAction", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject;
    if (bhnv.d(BaseApplication.getContext()))
    {
      this.app.addObserver(this.jdField_a_of_type_Aoaa, true);
      if (this.jdField_c_of_type_Int == 1)
      {
        localObject = (anzp)this.app.a(35);
        if ((localObject != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
          if (this.jdField_b_of_type_Int > 0)
          {
            if (!((anzp)localObject).a(this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_b_of_type_Boolean, 0, this.jdField_b_of_type_Int)) {
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
          ((Message)localObject).obj = jdField_a_of_type_JavaLangString;
          label182:
          if (localObject == null) {
            break label464;
          }
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject, 200L);
          return;
          i = j;
          if (!((anzp)localObject).a(this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_b_of_type_Boolean)) {
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
      if ((this.jdField_c_of_type_Int != 2) || (this.jdField_d_of_type_JavaLangString == null)) {}
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject(this.jdField_d_of_type_JavaLangString).getJSONObject("params");
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
        this.app.removeObserver(this.jdField_a_of_type_Aoaa);
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
        localMessage.obj = getString(2131692905);
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
    if (bhnv.d(BaseApplication.getContext()))
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
    paramWifiPOIInfo.obj = getString(2131692905);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramWifiPOIInfo);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
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
  
  public void doOnDestroy()
  {
    asam.a("NearbyTransitActivity", new Object[] { "doOnDestroy" });
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.app.removeObserver(this.jdField_a_of_type_Aoaa);
    super.doOnDestroy();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    asam.a("NearbyTransitActivity", new Object[] { "handleMessage", Integer.valueOf(paramMessage.what) });
    switch (paramMessage.what)
    {
    }
    label226:
    do
    {
      return false;
      if (this.jdField_a_of_type_Bjbv != null) {
        this.jdField_a_of_type_Bjbv.b();
      }
      long l;
      if ((paramMessage.what == 2) || ((paramMessage.obj instanceof String)))
      {
        if (paramMessage.what == 2)
        {
          str1 = getString(2131692905);
          if ((paramMessage.obj instanceof String)) {
            str1 = (String)paramMessage.obj;
          }
          QQToast.a(BaseApplication.getContext(), str1, 0).b(this.jdField_a_of_type_Int);
        }
      }
      else
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
        this.app.removeObserver(this.jdField_a_of_type_Aoaa);
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
        str1 = jdField_a_of_type_JavaLangString;
        break;
      }
      if (this.jdField_a_of_type_Bjbv != null) {
        this.jdField_a_of_type_Bjbv.b();
      }
      paramMessage = (Object[])paramMessage.obj;
      a((String)paramMessage[0], (String)paramMessage[1], (String)paramMessage[2]);
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.app.removeObserver(this.jdField_a_of_type_Aoaa);
      finish();
      return false;
      a((Common.WifiPOIInfo)paramMessage.obj);
      return false;
    } while (this.jdField_a_of_type_Bjbv == null);
    if (this.e == 1) {}
    for (String str1 = getString(2131692896);; str1 = getString(2131692895))
    {
      String str2 = str1;
      if (paramMessage.obj != null)
      {
        str2 = str1;
        if ((paramMessage.obj instanceof String))
        {
          str2 = (String)paramMessage.obj;
          axxb.a("NearbyTransitActivity", new Object[] { "handleMessage MSG_SHOW_LOADING ", str2 });
        }
      }
      this.jdField_a_of_type_Bjbv.a(0, str2, 0, this);
      return false;
    }
  }
  
  public boolean onBackEvent()
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
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dating.NearbyTransitActivity
 * JD-Core Version:    0.7.0.1
 */