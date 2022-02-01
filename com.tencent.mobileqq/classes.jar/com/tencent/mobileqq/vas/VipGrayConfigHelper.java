package com.tencent.mobileqq.vas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IGameCardManager;
import com.tencent.mobileqq.vip.IGameCardManager.GameCardInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class VipGrayConfigHelper
{
  private static final AtomicInteger f = new AtomicInteger(0);
  private static final Map<String, AtomicInteger> g = new HashMap();
  private static final Map<String, AtomicInteger> h = new HashMap();
  private static final Map<String, AtomicReference<Intent>> i = new HashMap();
  private static final Map<String, AtomicLong> j = new HashMap();
  private static final List<String> k = new ArrayList();
  private static final Runnable l = new VipGrayConfigHelper.1();
  private static VipGrayConfigHelper o;
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "https://imgcache.gtimg.cn/club/mqgame/";
  private int m = 1;
  private List<WeakReference<VipGrayConfigHelper.VipGrayConfigListener>> n = new ArrayList();
  
  public static VipGrayConfigHelper a()
  {
    if (o == null) {
      o = new VipGrayConfigHelper();
    }
    return o;
  }
  
  private void a(AppRuntime paramAppRuntime, JSONArray paramJSONArray, boolean paramBoolean)
  {
    if ((paramAppRuntime != null) && (paramJSONArray != null) && (paramJSONArray.length() >= 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parseVipGrayConfig begin config = ");
        ((StringBuilder)localObject).append(paramJSONArray.toString());
        QLog.d("VipGrayConfigHelper", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = MobileQQ.getContext().getSharedPreferences("vipGrayConfigSp", 0);
      if (paramBoolean)
      {
        k.clear();
        g.clear();
        h.clear();
        j.clear();
        i.clear();
        ((SharedPreferences)localObject).edit().clear().apply();
      }
      else if (k.isEmpty())
      {
        paramBoolean = true;
      }
      if (paramBoolean) {
        f.set(0);
      }
      a(paramAppRuntime, paramJSONArray, paramBoolean, (SharedPreferences)localObject);
      b();
      return;
    }
    QLog.e("VipGrayConfigHelper", 1, "parseVipGrayConfig app = null or configList = null or len < 0");
  }
  
  private void a(AppRuntime paramAppRuntime, JSONArray paramJSONArray, boolean paramBoolean, SharedPreferences paramSharedPreferences)
  {
    try
    {
      int i2 = paramJSONArray.length();
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = paramJSONArray.getJSONObject(i1);
        String str = ((JSONObject)localObject).optString("business");
        if ("vipEnterText".equals(str))
        {
          c(paramAppRuntime, (JSONObject)localObject);
        }
        else if (("backgroundWebView".equals(str)) && (paramBoolean))
        {
          a(paramAppRuntime, paramSharedPreferences, (JSONObject)localObject);
        }
        else if ("gameIcon".equals(str))
        {
          b(paramAppRuntime, (JSONObject)localObject);
        }
        else if (("ipStackConfigDic".equals(str)) && (a(paramAppRuntime, (JSONObject)localObject)))
        {
          long l1 = ((JSONObject)localObject).optLong("ipStackTimeInterval");
          ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).updateDisPlayInteval(l1);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ipsite interval = ");
          ((StringBuilder)localObject).append(l1);
          QLog.d("VipGrayConfigHelper", 2, ((StringBuilder)localObject).toString());
        }
        i1 += 1;
      }
      return;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.e("VipGrayConfigHelper", 1, "parseVipGrayConfig exception", paramAppRuntime);
    }
  }
  
  private boolean a(AppRuntime paramAppRuntime, SharedPreferences paramSharedPreferences, JSONObject paramJSONObject)
  {
    return false;
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("minVersion"))
    {
      String str = paramJSONObject.getString("minVersion");
      if ((!TextUtils.isEmpty(str)) && (!IndividuationConfigInfo.a(str, "8.8.17.5770")))
      {
        bool1 = false;
        break label42;
      }
    }
    boolean bool1 = true;
    label42:
    boolean bool2 = bool1;
    if (bool1)
    {
      bool2 = bool1;
      if (paramJSONObject.has("maxVersion"))
      {
        paramJSONObject = paramJSONObject.getString("maxVersion");
        bool2 = bool1;
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          bool2 = bool1;
          if (!IndividuationConfigInfo.a("8.8.17.5770", paramJSONObject)) {
            bool2 = false;
          }
        }
      }
    }
    return bool2;
  }
  
  private boolean a(JSONObject paramJSONObject, String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= paramInt2)
    {
      int i1 = paramString.length();
      if ((i1 >= paramInt1) && (i1 >= paramInt2))
      {
        long l1 = Long.parseLong(paramString.substring(i1 - paramInt1, i1 - paramInt2 + 1));
        long l2 = paramJSONObject.optLong("min");
        long l3 = paramJSONObject.optLong("max");
        if ((l1 >= l2) && (l1 <= l3)) {
          return true;
        }
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("parseJson, index config error, uin length=");
        paramString.append(i1);
        paramString.append(", config=");
        paramString.append(paramJSONObject.toString());
        QLog.e("VipGrayConfigHelper", 1, paramString.toString());
      }
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("parseJson, startIndex < endIndex, element=");
      paramString.append(paramJSONObject);
      QLog.e("VipGrayConfigHelper", 1, paramString.toString());
    }
    return false;
  }
  
  public static void b()
  {
    int i1 = f.get();
    if (i1 >= 0)
    {
      if (i1 >= k.size()) {
        return;
      }
      Object localObject = (String)k.get(i1);
      localObject = (AtomicLong)j.get(localObject);
      if (localObject != null)
      {
        ThreadManager.getSubThreadHandler().removeCallbacks(l);
        ThreadManager.getSubThreadHandler().postDelayed(l, ((AtomicLong)localObject).get());
      }
    }
  }
  
  private void b(AppRuntime paramAppRuntime, JSONObject paramJSONObject)
  {
    if (a(paramAppRuntime, paramJSONObject))
    {
      this.e = paramJSONObject.optString("baseUrl", "");
      this.m = paramJSONObject.optInt("expireDay", 0);
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("king info, url = ");
        paramAppRuntime.append(this.e);
        paramAppRuntime.append(",expireDay = ");
        paramAppRuntime.append(this.m);
        QLog.d("VipGrayConfigHelper", 2, paramAppRuntime.toString());
      }
    }
  }
  
  private void c(AppRuntime paramAppRuntime, JSONObject paramJSONObject)
  {
    if (a(paramAppRuntime, paramJSONObject))
    {
      this.a = paramJSONObject.optString("notVip");
      this.c = paramJSONObject.optString("outdatedVip");
      this.b = paramJSONObject.optString("vip");
      this.d = paramJSONObject.optString("svip");
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("parse vipEnterText notvip = ");
        paramAppRuntime.append(this.a);
        paramAppRuntime.append(", outdatevip = ");
        paramAppRuntime.append(this.c);
        paramAppRuntime.append(", vipstr= ");
        paramAppRuntime.append(this.b);
        paramAppRuntime.append(", svip = ");
        paramAppRuntime.append(this.d);
        QLog.d("VipGrayConfigHelper", 2, paramAppRuntime.toString());
      }
    }
  }
  
  private void h()
  {
    try
    {
      int i2 = this.n.size();
      if (i2 > 0)
      {
        int i1 = 0;
        while (i1 < i2)
        {
          VipGrayConfigHelper.VipGrayConfigListener localVipGrayConfigListener = (VipGrayConfigHelper.VipGrayConfigListener)((WeakReference)this.n.get(i1)).get();
          if (localVipGrayConfigListener != null) {
            localVipGrayConfigListener.a();
          }
          i1 += 1;
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void i()
  {
    this.a = "";
    this.b = "";
    this.c = "";
    this.d = "";
    this.e = "https://imgcache.gtimg.cn/club/mqgame/";
    this.m = 1;
  }
  
  public void a(URLImageView paramURLImageView, IGameCardManager.GameCardInfo paramGameCardInfo)
  {
    if (paramURLImageView == null) {
      return;
    }
    paramURLImageView.setVisibility(0);
    for (;;)
    {
      try
      {
        if (VasUtil.a().getGameCardManager().isSelf(paramGameCardInfo.b))
        {
          paramURLImageView = "owner";
          ((IMobileReportManager)QRoute.api(IMobileReportManager.class)).reportAction(String.valueOf(paramGameCardInfo.f), "4", "platform898", paramGameCardInfo.a, paramURLImageView, 101, 1, System.currentTimeMillis());
          return;
        }
      }
      catch (Exception paramURLImageView)
      {
        paramGameCardInfo = new StringBuilder();
        paramGameCardInfo.append("new_game_card list_error:");
        paramGameCardInfo.append(paramURLImageView.getMessage());
        QLog.e("VipGrayConfigHelper", 1, paramGameCardInfo.toString());
        return;
      }
      paramURLImageView = "visitor";
    }
  }
  
  public void a(URLImageView paramURLImageView, boolean paramBoolean, long paramLong, IGameCardManager.GameCardInfo paramGameCardInfo)
  {
    if (paramURLImageView != null)
    {
      if (paramGameCardInfo == null) {
        return;
      }
      paramURLImageView.setVisibility(8);
      paramURLImageView.setOnClickListener(null);
      if (a(paramBoolean, paramLong, paramGameCardInfo.e, paramGameCardInfo.f))
      {
        URLDrawable localURLDrawable = VasUtil.a().getGameCardManager().getGameCardDrawable(false, paramGameCardInfo, new VipGrayConfigHelper.2(this, paramURLImageView, paramGameCardInfo));
        paramURLImageView.setOnClickListener(new VipGrayConfigHelper.3(this, paramURLImageView, paramGameCardInfo));
        paramURLImageView.setBackgroundDrawable(localURLDrawable);
      }
    }
  }
  
  public void a(VipGrayConfigHelper.VipGrayConfigListener paramVipGrayConfigListener)
  {
    int i1 = 0;
    try
    {
      while (i1 < this.n.size())
      {
        VipGrayConfigHelper.VipGrayConfigListener localVipGrayConfigListener = (VipGrayConfigHelper.VipGrayConfigListener)((WeakReference)this.n.get(i1)).get();
        if (localVipGrayConfigListener == paramVipGrayConfigListener) {
          return;
        }
        i1 += 1;
      }
      if (paramVipGrayConfigListener != null) {
        this.n.add(new WeakReference(paramVipGrayConfigListener));
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramVipGrayConfigListener;
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    a(paramAppRuntime, false);
  }
  
  public void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("VipGrayConfigHelper", 1, "parsejson error, app = null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VipGrayConfigHelper", 2, "parsejson, begin");
    }
    i();
    try
    {
      Object localObject = VasUpdateUtil.a(paramAppRuntime, "vip_personal_card.json", true, null);
      if (localObject == null)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("VipGrayConfigHelper", 2, "parsejson file not exists");
        return;
      }
      localObject = ((JSONObject)localObject).optJSONArray("vipGrayConfig");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
        a(paramAppRuntime, (JSONArray)localObject, paramBoolean);
      } else {
        QLog.e("VipGrayConfigHelper", 1, "parsejson configList = null or len < 0");
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.e("VipGrayConfigHelper", 1, "parseJson exception", paramAppRuntime);
    }
    h();
    return;
  }
  
  public boolean a(AppRuntime paramAppRuntime, JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    if ((paramAppRuntime != null) && (paramJSONObject != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isConfigValid config = ");
        localStringBuilder.append(paramJSONObject.toString());
        QLog.d("VipGrayConfigHelper", 2, localStringBuilder.toString());
      }
      boolean bool1;
      try
      {
        int i1 = paramJSONObject.optInt("platformId");
        if (i1 != 0)
        {
          bool1 = bool2;
          if (i1 != 2) {}
        }
        else
        {
          bool1 = bool2;
          if (a(paramJSONObject)) {
            bool1 = a(paramJSONObject, paramAppRuntime.getAccount(), paramJSONObject.optInt("startIndex"), paramJSONObject.optInt("endIndex"));
          }
        }
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("VipGrayConfigHelper", 1, "isConfigValid exception", paramAppRuntime);
        bool1 = bool2;
      }
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("isConfigValid valid = ");
        paramAppRuntime.append(bool1);
        QLog.d("VipGrayConfigHelper", 2, paramAppRuntime.toString());
      }
      return bool1;
    }
    QLog.e("VipGrayConfigHelper", 1, "isConfigValid app = null || config = null");
    return false;
  }
  
  public boolean a(boolean paramBoolean1, long paramLong, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showNamePlateOfKing, new_game_card , isSuperVip = ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", lastLoginTime = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", gameCardSwitch = ");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append(", gameCardId = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("VipGrayConfigHelper", 2, ((StringBuilder)localObject).toString());
    }
    if ((!paramBoolean2) && (paramInt > 0)) {
      return true;
    }
    if (!paramBoolean1) {
      return false;
    }
    long l1 = paramLong;
    if (paramLong < 0L) {
      l1 = 0L;
    }
    paramLong = NetConnInfoCenter.getServerTime();
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong * 1000L);
    paramInt = ((Calendar)localObject).get(6);
    ((Calendar)localObject).setTimeInMillis(l1 * 1000L);
    return paramInt - ((Calendar)localObject).get(6) <= this.m;
  }
  
  public void b(VipGrayConfigHelper.VipGrayConfigListener paramVipGrayConfigListener)
  {
    Object localObject2 = null;
    int i1 = 0;
    for (;;)
    {
      Object localObject1 = localObject2;
      try
      {
        if (i1 < this.n.size())
        {
          if ((VipGrayConfigHelper.VipGrayConfigListener)((WeakReference)this.n.get(i1)).get() != paramVipGrayConfigListener) {
            break label89;
          }
          localObject1 = this.n.get(i1);
        }
        if (localObject1 != null) {
          this.n.remove(localObject1);
        }
        return;
      }
      finally
      {
        for (;;)
        {
          throw paramVipGrayConfigListener;
        }
        label89:
        i1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VipGrayConfigHelper
 * JD-Core Version:    0.7.0.1
 */