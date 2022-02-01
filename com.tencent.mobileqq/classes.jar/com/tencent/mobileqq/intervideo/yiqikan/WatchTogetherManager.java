package com.tencent.mobileqq.intervideo.yiqikan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVPluginReportInterface;
import com.tencent.mobileqq.nearby.api.IFactoryApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.together.TogetherObserver;
import com.tencent.mobileqq.together.TogetherSession;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.manager.Manager;

public class WatchTogetherManager
  implements Manager
{
  HashMap<Integer, IWatchTogetherRoomDelegate> a = new HashMap();
  QQAppInterface b;
  Map<String, NewTogetherRoomMessageData> c = new HashMap();
  IVPluginReportInterface d;
  String e = "mqqapi://miniapp/open?_atype=0&_mappid=1109894538&_mvid=&_path=pages%2Findex%2Findex&_vt=3&_sig=71cba9e2ab0f0e779a62ecf6705e0f5cf65a4f764d755e8fc07b537e655c70ad";
  TogetherObserver f = new WatchTogetherManager.1(this);
  
  public WatchTogetherManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    a(2, (IWatchTogetherRoomDelegate)this.b.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER));
    a(1, (IWatchTogetherRoomDelegate)this.b.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER));
    this.d = ((IFactoryApi)QRoute.api(IFactoryApi.class)).getIVPluginReportInterface();
  }
  
  private int a(String paramString)
  {
    paramString = (NewTogetherRoomMessageData)this.c.get(paramString);
    if (paramString != null) {
      return paramString.c;
    }
    return 0;
  }
  
  private NewTogetherRoomMessageData a(WatchTogetherSession paramWatchTogetherSession)
  {
    if (paramWatchTogetherSession == null) {
      return null;
    }
    NewTogetherRoomMessageData localNewTogetherRoomMessageData = new NewTogetherRoomMessageData();
    localNewTogetherRoomMessageData.c = paramWatchTogetherSession.a;
    localNewTogetherRoomMessageData.a = paramWatchTogetherSession.n;
    localNewTogetherRoomMessageData.k = paramWatchTogetherSession.e;
    localNewTogetherRoomMessageData.j = paramWatchTogetherSession.b;
    localNewTogetherRoomMessageData.d = paramWatchTogetherSession.c;
    localNewTogetherRoomMessageData.i = paramWatchTogetherSession.d;
    Object localObject = Uri.parse(paramWatchTogetherSession.b);
    paramWatchTogetherSession = ((Uri)localObject).getQueryParameter("roomid");
    String str1 = ((Uri)localObject).getQueryParameter("room_show_number");
    String str2 = ((Uri)localObject).getQueryParameter("fromid");
    localObject = ((Uri)localObject).getQueryParameter("room_group_code");
    if (!TextUtils.isEmpty(paramWatchTogetherSession)) {
      localNewTogetherRoomMessageData.d = Integer.parseInt(paramWatchTogetherSession);
    }
    if (!TextUtils.isEmpty(str1)) {
      localNewTogetherRoomMessageData.e = Integer.parseInt(str1);
    }
    localNewTogetherRoomMessageData.f = ((String)localObject);
    localNewTogetherRoomMessageData.l = str2;
    return localNewTogetherRoomMessageData;
  }
  
  private String a(Bundle paramBundle, String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = "";
    if (bool)
    {
      QLog.i("WatchTogetherManager", 1, "getTroopOwnerUin  troopUin is null");
      return "";
    }
    Object localObject1;
    if (paramBundle != null)
    {
      localObject1 = paramBundle.getString("TOGETHER_BUNDLE_KEY_OWNER_UIN");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getTroopOwnerUin  from extrainfo ownerUin=");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("WatchTogetherManager", 1, ((StringBuilder)localObject2).toString());
    }
    else
    {
      Object localObject3 = this.b;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((TroopManager)((QQAppInterface)localObject3).getManager(QQManagerFactory.TROOP_MANAGER)).f(paramString);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((TroopInfo)localObject3).troopowneruin;
        }
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getTroopOwnerUin  extraInfo = ");
    ((StringBuilder)localObject2).append(paramBundle);
    ((StringBuilder)localObject2).append(";troopUin=");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(";ownerUin=");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.i("WatchTogetherManager", 1, ((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  private long b(String paramString)
  {
    paramString = (NewTogetherRoomMessageData)this.c.get(paramString);
    if (paramString != null) {
      return paramString.d;
    }
    return 0L;
  }
  
  private void b(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    if ((paramNewTogetherRoomMessageData.g != paramNewTogetherRoomMessageData.c) && (paramNewTogetherRoomMessageData.g != 0))
    {
      b(paramNewTogetherRoomMessageData.a, paramNewTogetherRoomMessageData);
      Bundle localBundle = new Bundle();
      localBundle.putString("close_reason", "switch_room");
      localBundle.putInt("old_room_type", paramNewTogetherRoomMessageData.g);
      localBundle.putInt("new_room_type", paramNewTogetherRoomMessageData.c);
      IWatchTogetherRoomDelegate localIWatchTogetherRoomDelegate = (IWatchTogetherRoomDelegate)this.a.get(Integer.valueOf(paramNewTogetherRoomMessageData.g));
      if (localIWatchTogetherRoomDelegate != null) {
        localIWatchTogetherRoomDelegate.b(paramNewTogetherRoomMessageData, localBundle, new WatchTogetherManager.3(this));
      }
    }
    else
    {
      b(paramNewTogetherRoomMessageData.a, paramNewTogetherRoomMessageData);
      c(paramNewTogetherRoomMessageData);
    }
  }
  
  private void c(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      localObject = (IWatchTogetherRoomDelegate)this.a.get(localObject);
      if (localObject != null)
      {
        localObject = ((IWatchTogetherRoomDelegate)localObject).a();
        if (localObject != null) {
          ((PushMessageDelegate)localObject).b(paramNewTogetherRoomMessageData);
        }
      }
    }
  }
  
  private void d(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      localObject = (IWatchTogetherRoomDelegate)this.a.get(localObject);
      if (localObject != null)
      {
        localObject = ((IWatchTogetherRoomDelegate)localObject).a();
        if (localObject != null) {
          ((PushMessageDelegate)localObject).c(paramNewTogetherRoomMessageData);
        }
      }
    }
  }
  
  private void e(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    b(paramNewTogetherRoomMessageData.a, paramNewTogetherRoomMessageData);
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Integer)localIterator.next();
      Object localObject1 = (IWatchTogetherRoomDelegate)this.a.get(localObject2);
      if (localObject1 != null)
      {
        if (((Integer)localObject2).intValue() == paramNewTogetherRoomMessageData.c)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("preload roomtype =  ");
          ((StringBuilder)localObject2).append(paramNewTogetherRoomMessageData.c);
          QLog.i("WatchTogetherManager", 1, ((StringBuilder)localObject2).toString());
          paramNewTogetherRoomMessageData.l = "101";
          ((IWatchTogetherRoomDelegate)localObject1).a(paramNewTogetherRoomMessageData);
        }
        localObject1 = ((IWatchTogetherRoomDelegate)localObject1).a();
        if (localObject1 != null) {
          ((PushMessageDelegate)localObject1).a(paramNewTogetherRoomMessageData);
        }
      }
    }
  }
  
  public void a()
  {
    this.b.addObserver(this.f);
  }
  
  public void a(int paramInt)
  {
    this.a.remove(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt, IWatchTogetherRoomDelegate paramIWatchTogetherRoomDelegate)
  {
    this.a.put(Integer.valueOf(paramInt), paramIWatchTogetherRoomDelegate);
  }
  
  public void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(WatchTogetherSession paramWatchTogetherSession, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openWatchTogetherRoom  pushActionType = ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("WatchTogetherManager", 1, ((StringBuilder)localObject).toString());
    localObject = new NewTogetherRoomMessageData();
    ((NewTogetherRoomMessageData)localObject).b = paramWatchTogetherSession.r;
    ((NewTogetherRoomMessageData)localObject).a = paramWatchTogetherSession.n;
    ((NewTogetherRoomMessageData)localObject).c = paramWatchTogetherSession.a;
    ((NewTogetherRoomMessageData)localObject).d = paramWatchTogetherSession.c;
    ((NewTogetherRoomMessageData)localObject).g = a(paramWatchTogetherSession.n);
    ((NewTogetherRoomMessageData)localObject).j = paramWatchTogetherSession.b;
    ((NewTogetherRoomMessageData)localObject).i = paramWatchTogetherSession.d;
    ((NewTogetherRoomMessageData)localObject).k = paramWatchTogetherSession.e;
    ((NewTogetherRoomMessageData)localObject).h = b(paramWatchTogetherSession.n);
    paramWatchTogetherSession = new StringBuilder();
    paramWatchTogetherSession.append("openWatchTogetherRoom  pushContent = ");
    paramWatchTogetherSession.append(((NewTogetherRoomMessageData)localObject).toString());
    QLog.i("WatchTogetherManager", 1, paramWatchTogetherSession.toString());
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 5) {
          return;
        }
        b((NewTogetherRoomMessageData)localObject);
        return;
      }
      d((NewTogetherRoomMessageData)localObject);
      return;
    }
    e((NewTogetherRoomMessageData)localObject);
  }
  
  public void a(WatchTogetherSession paramWatchTogetherSession, Bundle paramBundle)
  {
    if (paramWatchTogetherSession == null)
    {
      ToastUtil.a().a("watchTogetherSession == null!");
      return;
    }
    paramWatchTogetherSession = a(paramWatchTogetherSession);
    paramWatchTogetherSession.b = a(paramBundle, paramWatchTogetherSession.a);
    a(paramWatchTogetherSession);
  }
  
  public void a(String paramString, int paramInt, WatchTogetherSession paramWatchTogetherSession)
  {
    IWatchTogetherRoomDelegate localIWatchTogetherRoomDelegate = (IWatchTogetherRoomDelegate)this.a.get(Integer.valueOf(paramInt));
    if (localIWatchTogetherRoomDelegate == null)
    {
      QLog.i("WatchTogetherManager", 1, "preloadBizRoom  fail!  roomtype is not registered");
      return;
    }
    NewTogetherRoomMessageData localNewTogetherRoomMessageData = a(paramWatchTogetherSession);
    paramWatchTogetherSession = localNewTogetherRoomMessageData;
    if (localNewTogetherRoomMessageData == null)
    {
      paramWatchTogetherSession = new NewTogetherRoomMessageData();
      paramWatchTogetherSession.l = paramString;
    }
    paramWatchTogetherSession.b = a(null, paramWatchTogetherSession.a);
    paramString = new StringBuilder();
    paramString.append("preloadRoom  roomtype = ");
    paramString.append(paramInt);
    QLog.i("WatchTogetherManager", 1, paramString.toString());
    localIWatchTogetherRoomDelegate.a(paramWatchTogetherSession);
  }
  
  public void a(String paramString, NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    boolean bool1 = this.b.getCurrentAccountUin().equals(paramNewTogetherRoomMessageData.b);
    boolean bool2 = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(this.b, paramNewTogetherRoomMessageData.a, this.b.getCurrentAccountUin());
    a(paramString, paramNewTogetherRoomMessageData.a, paramNewTogetherRoomMessageData.b, Boolean.valueOf(bool1).booleanValue(), Boolean.valueOf(bool2).booleanValue());
  }
  
  public void a(String paramString, WatchTogetherSession paramWatchTogetherSession, Bundle paramBundle)
  {
    if (paramWatchTogetherSession == null) {
      return;
    }
    boolean bool1;
    boolean bool2;
    if (paramBundle != null)
    {
      bool1 = paramBundle.getBoolean("TOGETHER_BUNDLE_KEY_IS_OWNER");
      bool2 = paramBundle.getBoolean("TOGETHER_BUNDLE_KEY_IS_ADMIN");
    }
    else
    {
      bool1 = TroopUtils.a(this.b, paramWatchTogetherSession.n, this.b.getCurrentAccountUin());
      bool2 = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(this.b, paramWatchTogetherSession.n, this.b.getCurrentAccountUin());
    }
    paramBundle = a(paramBundle, paramWatchTogetherSession.n);
    a(paramString, paramWatchTogetherSession.n, paramBundle, bool1, bool2);
    IVPluginReportInterface localIVPluginReportInterface = this.d;
    if (localIVPluginReportInterface != null)
    {
      paramString = localIVPluginReportInterface.opDepartment("intervideo").opName("open_together_miniapp").opType(String.valueOf(paramWatchTogetherSession.a)).d1(paramWatchTogetherSession.n).d2(paramBundle).d3(paramString);
      int i;
      if (bool1) {
        i = 1;
      } else {
        i = 0;
      }
      paramString.opIn(i).report();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      if (paramBoolean1) {
        str = this.b.getCurrentUin();
      } else {
        str = "0";
      }
    }
    paramString3 = new StringBuilder(this.e);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("&group_uin=");
    localStringBuilder.append(paramString2);
    paramString3.append(localStringBuilder.toString());
    paramString2 = new StringBuilder();
    paramString2.append("&user_uin=");
    paramString2.append(this.b.getCurrentAccountUin());
    paramString3.append(paramString2.toString());
    paramString2 = new StringBuilder();
    paramString2.append("&source_id=");
    paramString2.append(paramString1);
    paramString3.append(paramString2.toString());
    paramString1 = new StringBuilder();
    paramString1.append("&owner_uin=");
    paramString1.append(str);
    paramString3.append(paramString1.toString());
    paramString3.append("&isowner=");
    paramString2 = "1";
    if (paramBoolean1) {
      paramString1 = "1";
    } else {
      paramString1 = "0";
    }
    paramString3.append(paramString1);
    paramString3.append("&isadmain=");
    if (paramBoolean2) {
      paramString1 = paramString2;
    } else {
      paramString1 = "0";
    }
    paramString3.append(paramString1);
    try
    {
      paramBoolean1 = TextUtils.isEmpty("8.8.17");
      k = 0;
      if (paramBoolean1) {
        break label488;
      }
      paramString1 = "8.8.17".split("\\.");
      if (paramString1.length <= 0) {
        break label488;
      }
      i = 0;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        int k;
        continue;
        int j = i + j;
        k += 1;
        int i = j;
        continue;
        j = 0;
      }
    }
    j = i;
    if (k < paramString1.length)
    {
      if (k == 0)
      {
        j = Integer.parseInt(paramString1[k]) * 100000;
      }
      else if (k == 1)
      {
        j = Integer.parseInt(paramString1[k]) * 100;
      }
      else
      {
        j = i;
        if (k != 2) {
          break label475;
        }
        j = Integer.parseInt(paramString1[k]);
      }
    }
    else
    {
      paramString1 = new StringBuilder();
      paramString1.append("&versioncode=");
      paramString1.append(j);
      paramString3.append(paramString1.toString());
      break label393;
      paramString3.append("&versioncode=0");
      label393:
      paramString1 = new StringBuilder();
      paramString1.append("openMiniAPP  scheme = ");
      paramString1.append(paramString3.toString());
      QLog.i("WatchTogetherManager", 1, paramString1.toString());
      paramString1 = new Intent();
      paramString1.setData(Uri.parse(paramString3.toString()));
      paramString1.setFlags(268435456);
      BaseApplicationImpl.getContext().startActivity(paramString1);
      return;
    }
  }
  
  public void b(String paramString, NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    this.c.put(paramString, paramNewTogetherRoomMessageData);
  }
  
  public void onDestroy()
  {
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherManager
 * JD-Core Version:    0.7.0.1
 */