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
  public static final String a = HardCodeUtil.a(2131903535);
  public static long e = 0L;
  public static long f = 0L;
  private static long g = 0L;
  protected QQProgressNotifier b;
  protected int c;
  long d;
  private int h;
  private MqqHandler i;
  private boolean j;
  private String k;
  private int l;
  private String m;
  private String n;
  private boolean o = true;
  private int p = 0;
  private int q = 0;
  private HotChatObserver r = new NearbyTransitActivity.2(this);
  
  private void a()
  {
    DatingUtil.a("NearbyTransitActivity", new Object[] { "parseParams" });
    Intent localIntent = getIntent();
    Bundle localBundle = localIntent.getExtras();
    this.k = localBundle.getString("from");
    this.l = localBundle.getInt("action");
    this.n = localBundle.getString("params");
    if (this.l == 1) {
      this.m = localIntent.getExtras().getString("hotnamecode");
    }
    if ("1".equals(localBundle.getString("onwall"))) {
      this.p |= 0x2;
    }
    if ("1".equals(localBundle.getString("nonelbs"))) {
      this.o = false;
    }
    if ("1".equals(localBundle.getString("fissile"))) {
      this.q = 1;
    }
    this.d = localIntent.getLongExtra("enter_time", System.currentTimeMillis());
    this.b = new QQProgressNotifier(this, 2131627752);
    this.c = getResources().getDimensionPixelSize(2131299920);
    this.j = false;
    this.i = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a("openNearbyTransitActivity", 0);
    long l1 = Math.abs(System.currentTimeMillis() - g);
    if (paramContext != null)
    {
      if ((l1 >= 0L) && (l1 < 800L)) {
        return;
      }
      g = System.currentTimeMillis();
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
    long l1 = Math.abs(System.currentTimeMillis() - g);
    if ((paramContext != null) && ((l1 < 0L) || (l1 >= 800L)))
    {
      if (paramHashMap == null) {
        return;
      }
      g = System.currentTimeMillis();
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
    this.i.sendMessage(localMessage);
  }
  
  public static void a(String paramString, int paramInt) {}
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    a("enterAIO", 1);
    Intent localIntent;
    if (this.h > 0)
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
      localIntent.putExtra("HOTCHAT_EXTRA_FLAG", this.p);
      paramString1 = localIntent;
      if ("10002".equals(this.k))
      {
        localIntent.putExtra("abp_flag", true);
        localIntent.addFlags(268435456);
        paramString1 = localIntent;
      }
    }
    startActivity(paramString1);
    long l1 = System.currentTimeMillis() - this.d;
    if (l1 > 0L) {
      a(this.app.getCurrentAccountUin(), true, l1, 0);
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
  
  private void b()
  {
    a("doAction", 1);
    DatingUtil.a("NearbyTransitActivity", new Object[] { "doAction", Boolean.valueOf(this.j) });
    if (this.j) {
      return;
    }
    Message localMessage = null;
    int i1;
    Object localObject;
    boolean bool;
    int i2;
    if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.app.addObserver(this.r, true);
      i1 = this.l;
      if (i1 == 1)
      {
        localObject = (IHotChatHandler)this.app.getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName());
        if ((localObject != null) && (!TextUtils.isEmpty(this.m)))
        {
          i1 = this.h;
          if (i1 > 0) {
            bool = ((IHotChatHandler)localObject).quickJoinHotChat(this.m, this.p, this.o, 0, i1);
          } else {
            bool = ((IHotChatHandler)localObject).quickJoinHotChat(this.m, this.p, this.o);
          }
          i2 = bool ^ true;
          i1 = i2;
          if (i2 != 0)
          {
            int i3 = 6;
            i1 = i2;
            i2 = i3;
            break label367;
          }
        }
        else
        {
          if (localObject == null)
          {
            i1 = 1;
            i2 = 9;
            break label367;
          }
          i1 = 1;
          i2 = 10;
          break label367;
        }
      }
      else if (i1 == 2)
      {
        localObject = this.n;
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
            i1 = 1;
            break label447;
          }
          bool = b(localHotChatInfo);
          i1 = bool ^ true;
          break label447;
        }
        i1 = 1;
        i2 = 8;
        try
        {
          if (((JSONObject)localObject).has("fissile")) {
            this.q = ((JSONObject)localObject).getInt("fissile");
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
        this.app.removeObserver(this.r);
        i2 = 7;
        i1 = 1;
      }
      break label367;
      i1 = 1;
      i2 = 1;
      label367:
      if (i1 != 0)
      {
        localMessage = Message.obtain();
        localMessage.what = 1;
        localMessage.arg1 = i2;
        localMessage.obj = a;
        break label428;
        localMessage = Message.obtain();
        localMessage.what = 1;
        localMessage.arg1 = 2;
        localMessage.obj = getString(2131890731);
      }
      label428:
      if (localMessage != null) {
        this.i.sendMessageDelayed(localMessage, 200L);
      }
      return;
      label447:
      i2 = 1;
    }
  }
  
  private boolean b(HotChatInfo paramHotChatInfo)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).g();
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
  
  protected void a(Common.WifiPOIInfo paramWifiPOIInfo)
  {
    if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.i.removeMessages(2);
      this.i.removeMessages(5);
      this.i.sendEmptyMessageDelayed(5, 200L);
      this.i.sendEmptyMessageDelayed(2, 30000L);
      ThreadManager.post(new NearbyTransitActivity.3(this, paramWifiPOIInfo), 5, null, true);
      return;
    }
    paramWifiPOIInfo = Message.obtain();
    paramWifiPOIInfo.what = 1;
    paramWifiPOIInfo.arg1 = 2;
    paramWifiPOIInfo.obj = getString(2131890731);
    this.i.sendMessage(paramWifiPOIInfo);
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
    if (this.l == 1)
    {
      this.i.sendEmptyMessageDelayed(5, 800L);
      this.i.sendEmptyMessageDelayed(2, 30000L);
    }
    ThreadManager.getFileThreadHandler().post(new NearbyTransitActivity.1(this));
    return false;
  }
  
  protected void doOnDestroy()
  {
    DatingUtil.a("NearbyTransitActivity", new Object[] { "doOnDestroy" });
    this.j = true;
    this.i.removeCallbacksAndMessages(null);
    this.app.removeObserver(this.r);
    super.doOnDestroy();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    DatingUtil.a("NearbyTransitActivity", new Object[] { "handleMessage", Integer.valueOf(paramMessage.what) });
    int i2 = paramMessage.what;
    int i1 = 4;
    Object localObject;
    if ((i2 != 1) && (i2 != 2))
    {
      if (i2 != 3)
      {
        if (i2 != 4)
        {
          if (i2 != 5) {
            return false;
          }
          if (this.b != null)
          {
            if (this.q == 1) {
              i1 = 2131890722;
            } else {
              i1 = 2131890721;
            }
            String str = getString(i1);
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
            this.b.a(0, (String)localObject, 0, this);
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
        localObject = this.b;
        if (localObject != null) {
          ((QQProgressNotifier)localObject).b();
        }
        paramMessage = (Object[])paramMessage.obj;
        a((String)paramMessage[0], (String)paramMessage[1], (String)paramMessage[2]);
        this.i.removeCallbacksAndMessages(null);
        this.app.removeObserver(this.r);
        finish();
        return false;
      }
    }
    else
    {
      localObject = this.b;
      if (localObject != null) {
        ((QQProgressNotifier)localObject).b();
      }
      if ((paramMessage.what == 2) || ((paramMessage.obj instanceof String)))
      {
        if (paramMessage.what == 2) {
          localObject = getString(2131890731);
        } else {
          localObject = a;
        }
        if ((paramMessage.obj instanceof String)) {
          localObject = (String)paramMessage.obj;
        }
        QQToast.makeText(BaseApplication.getContext(), (CharSequence)localObject, 0).show(this.c);
      }
      this.i.removeCallbacksAndMessages(null);
      this.app.removeObserver(this.r);
      long l1 = System.currentTimeMillis() - this.d;
      if (l1 > 0L)
      {
        localObject = this.app.getCurrentAccountUin();
        if (paramMessage.what != 2) {
          i1 = paramMessage.arg1;
        }
        a((String)localObject, false, l1, i1);
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
    this.i.sendMessage(localMessage);
    return true;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = Message.obtain();
    paramDialogInterface.what = 1;
    paramDialogInterface.arg1 = 3;
    this.i.sendMessage(paramDialogInterface);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.NearbyTransitActivity
 * JD-Core Version:    0.7.0.1
 */