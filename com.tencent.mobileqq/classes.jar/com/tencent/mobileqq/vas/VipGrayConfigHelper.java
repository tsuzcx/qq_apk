package com.tencent.mobileqq.vas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
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
  private static VipGrayConfigHelper jdField_a_of_type_ComTencentMobileqqVasVipGrayConfigHelper;
  private static final Runnable jdField_a_of_type_JavaLangRunnable = new VipGrayConfigHelper.1();
  private static final List<String> jdField_a_of_type_JavaUtilList;
  private static final Map<String, AtomicInteger> jdField_a_of_type_JavaUtilMap;
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private static final Map<String, AtomicInteger> jdField_b_of_type_JavaUtilMap;
  private static final Map<String, AtomicReference<Intent>> c;
  private static final Map<String, AtomicLong> d;
  private int jdField_a_of_type_Int = 1;
  public String a;
  public String b;
  private List<WeakReference<VipGrayConfigHelper.VipGrayConfigListener>> jdField_b_of_type_JavaUtilList = new ArrayList();
  public String c;
  public String d;
  private String e = "https://imgcache.gtimg.cn/club/mqgame/";
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_b_of_type_JavaUtilMap = new HashMap();
    jdField_c_of_type_JavaUtilMap = new HashMap();
    jdField_d_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public VipGrayConfigHelper()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
  }
  
  public static VipGrayConfigHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqVasVipGrayConfigHelper == null) {
      jdField_a_of_type_ComTencentMobileqqVasVipGrayConfigHelper = new VipGrayConfigHelper();
    }
    return jdField_a_of_type_ComTencentMobileqqVasVipGrayConfigHelper;
  }
  
  public static void a()
  {
    int i = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (i >= 0)
    {
      if (i >= jdField_a_of_type_JavaUtilList.size()) {
        return;
      }
      Object localObject = (String)jdField_a_of_type_JavaUtilList.get(i);
      localObject = (AtomicLong)jdField_d_of_type_JavaUtilMap.get(localObject);
      if (localObject != null)
      {
        ThreadManager.getSubThreadHandler().removeCallbacks(jdField_a_of_type_JavaLangRunnable);
        ThreadManager.getSubThreadHandler().postDelayed(jdField_a_of_type_JavaLangRunnable, ((AtomicLong)localObject).get());
      }
    }
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
        jdField_a_of_type_JavaUtilList.clear();
        jdField_a_of_type_JavaUtilMap.clear();
        jdField_b_of_type_JavaUtilMap.clear();
        jdField_d_of_type_JavaUtilMap.clear();
        jdField_c_of_type_JavaUtilMap.clear();
        ((SharedPreferences)localObject).edit().clear().apply();
      }
      else if (jdField_a_of_type_JavaUtilList.isEmpty())
      {
        paramBoolean = true;
      }
      if (paramBoolean) {
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      }
      a(paramAppRuntime, paramJSONArray, paramBoolean, (SharedPreferences)localObject);
      a();
      return;
    }
    QLog.e("VipGrayConfigHelper", 1, "parseVipGrayConfig app = null or configList = null or len < 0");
  }
  
  private void a(AppRuntime paramAppRuntime, JSONArray paramJSONArray, boolean paramBoolean, SharedPreferences paramSharedPreferences)
  {
    try
    {
      int j = paramJSONArray.length();
      int i = 0;
      while (i < j)
      {
        Object localObject = paramJSONArray.getJSONObject(i);
        String str = ((JSONObject)localObject).optString("business");
        if ("vipEnterText".equals(str))
        {
          b(paramAppRuntime, (JSONObject)localObject);
        }
        else if (("backgroundWebView".equals(str)) && (paramBoolean))
        {
          a(paramAppRuntime, paramSharedPreferences, (JSONObject)localObject);
        }
        else if ("gameIcon".equals(str))
        {
          a(paramAppRuntime, (JSONObject)localObject);
        }
        else if (("ipStackConfigDic".equals(str)) && (a(paramAppRuntime, (JSONObject)localObject)))
        {
          long l = ((JSONObject)localObject).optLong("ipStackTimeInterval");
          ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).updateDisPlayInteval(l);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ipsite interval = ");
          ((StringBuilder)localObject).append(l);
          QLog.d("VipGrayConfigHelper", 2, ((StringBuilder)localObject).toString());
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.e("VipGrayConfigHelper", 1, "parseVipGrayConfig exception", paramAppRuntime);
    }
  }
  
  private void a(AppRuntime paramAppRuntime, JSONObject paramJSONObject)
  {
    if (a(paramAppRuntime, paramJSONObject))
    {
      this.e = paramJSONObject.optString("baseUrl", "");
      this.jdField_a_of_type_Int = paramJSONObject.optInt("expireDay", 0);
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("king info, url = ");
        paramAppRuntime.append(this.e);
        paramAppRuntime.append(",expireDay = ");
        paramAppRuntime.append(this.jdField_a_of_type_Int);
        QLog.d("VipGrayConfigHelper", 2, paramAppRuntime.toString());
      }
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
      if ((!TextUtils.isEmpty(str)) && (!IndividuationConfigInfo.a(str, "8.7.0.5295")))
      {
        bool1 = false;
        break label45;
      }
    }
    boolean bool1 = true;
    label45:
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
          if (!IndividuationConfigInfo.a("8.7.0.5295", paramJSONObject)) {
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
      int i = paramString.length();
      if ((i >= paramInt1) && (i >= paramInt2))
      {
        long l1 = Long.parseLong(paramString.substring(i - paramInt1, i - paramInt2 + 1));
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
        paramString.append(i);
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
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (paramBoolean4) {
      if (paramBoolean5)
      {
        if (paramBoolean3) {
          break label31;
        }
        if (paramBoolean2) {
          return true;
        }
      }
    }
    while ((!paramBoolean5) || (!paramBoolean1)) {
      return false;
    }
    label31:
    return true;
  }
  
  private void b()
  {
    try
    {
      int j = this.jdField_b_of_type_JavaUtilList.size();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          VipGrayConfigHelper.VipGrayConfigListener localVipGrayConfigListener = (VipGrayConfigHelper.VipGrayConfigListener)((WeakReference)this.jdField_b_of_type_JavaUtilList.get(i)).get();
          if (localVipGrayConfigListener != null) {
            localVipGrayConfigListener.a();
          }
          i += 1;
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
  
  private void b(AppRuntime paramAppRuntime, JSONObject paramJSONObject)
  {
    if (a(paramAppRuntime, paramJSONObject))
    {
      this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("notVip");
      this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("outdatedVip");
      this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("vip");
      this.jdField_d_of_type_JavaLangString = paramJSONObject.optString("svip");
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("parse vipEnterText notvip = ");
        paramAppRuntime.append(this.jdField_a_of_type_JavaLangString);
        paramAppRuntime.append(", outdatevip = ");
        paramAppRuntime.append(this.jdField_c_of_type_JavaLangString);
        paramAppRuntime.append(", vipstr= ");
        paramAppRuntime.append(this.jdField_b_of_type_JavaLangString);
        paramAppRuntime.append(", svip = ");
        paramAppRuntime.append(this.jdField_d_of_type_JavaLangString);
        QLog.d("VipGrayConfigHelper", 2, paramAppRuntime.toString());
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.e = "https://imgcache.gtimg.cn/club/mqgame/";
    this.jdField_a_of_type_Int = 1;
  }
  
  public String a(String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    return a(paramString, paramLong, paramInt, paramBoolean, false);
  }
  
  public String a(String paramString, long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getNamePlateOfKingUrl, gameAppId = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" dan = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" danSwitch = ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(" isSetting = ");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.i("VipGrayConfigHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = VasUtil.a();
    boolean bool1;
    if ((!TextUtils.isEmpty(this.e)) && (paramLong != 0L)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    SharedPreferences localSharedPreferences = ((AppRuntime)localObject).getApp().getSharedPreferences("sp_plate_of_king", 0);
    boolean bool2;
    if ((!TextUtils.isEmpty(paramString)) && (((AppRuntime)localObject).getCurrentUin().equals(paramString))) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    paramString = new StringBuilder();
    paramString.append("plate_of_king_display_switch_");
    paramString.append(((AppRuntime)localObject).getCurrentUin());
    boolean bool3 = localSharedPreferences.getBoolean(paramString.toString(), true);
    if (a(paramBoolean1, paramBoolean2, bool3, bool2, bool1))
    {
      if (paramInt == 0)
      {
        paramString = new StringBuilder();
        paramString.append(this.e);
        paramString.append(paramLong);
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append(this.e);
        paramString.append(paramLong);
        paramString.append("_");
        paramString.append(paramInt);
      }
      paramString.append(".png");
      return paramString.toString();
    }
    paramString = new StringBuilder();
    paramString.append("getNamePlateOfKingUrl namePlateOfKingUrl = null gameAppId= ");
    paramString.append(paramLong);
    paramString.append(" dan= ");
    paramString.append(paramInt);
    paramString.append(" danSwitch= ");
    paramString.append(paramBoolean1);
    paramString.append(" localSwitch = ");
    paramString.append(bool3);
    QLog.e("VipGrayConfigHelper", 1, paramString.toString());
    return null;
  }
  
  public void a(URLImageView paramURLImageView, boolean paramBoolean1, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean2, String paramString)
  {
    if (paramURLImageView == null) {
      return;
    }
    paramURLImageView.setVisibility(8);
    if (a(paramBoolean1, paramLong1))
    {
      paramURLImageView.setVisibility(0);
      paramString = a(paramString, paramLong2, paramInt, paramBoolean2);
      if (TextUtils.isEmpty(paramString))
      {
        paramURLImageView.setVisibility(8);
        return;
      }
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, new ColorDrawable(), new ColorDrawable());
      if (localURLDrawable.getStatus() != 1) {
        localURLDrawable.restartDownload();
      }
      paramURLImageView.setBackgroundDrawable(localURLDrawable);
      paramURLImageView.setURLDrawableDownListener(new VipGrayConfigHelper.2(this, paramString, paramURLImageView));
    }
  }
  
  public void a(VipGrayConfigHelper.VipGrayConfigListener paramVipGrayConfigListener)
  {
    int i = 0;
    try
    {
      while (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        VipGrayConfigHelper.VipGrayConfigListener localVipGrayConfigListener = (VipGrayConfigHelper.VipGrayConfigListener)((WeakReference)this.jdField_b_of_type_JavaUtilList.get(i)).get();
        if (localVipGrayConfigListener == paramVipGrayConfigListener) {
          return;
        }
        i += 1;
      }
      if (paramVipGrayConfigListener != null) {
        this.jdField_b_of_type_JavaUtilList.add(new WeakReference(paramVipGrayConfigListener));
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
    c();
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
    b();
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
        int i = paramJSONObject.optInt("platformId");
        if (i != 0)
        {
          bool1 = bool2;
          if (i != 2) {}
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
  
  public boolean a(boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showNamePlateOfKing, isSuperVip = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", lastLoginTime = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("VipGrayConfigHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean) {
      return false;
    }
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    paramLong = NetConnInfoCenter.getServerTime();
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong * 1000L);
    int i = ((Calendar)localObject).get(6);
    ((Calendar)localObject).setTimeInMillis(l * 1000L);
    return i - ((Calendar)localObject).get(6) <= this.jdField_a_of_type_Int;
  }
  
  public void b(VipGrayConfigHelper.VipGrayConfigListener paramVipGrayConfigListener)
  {
    Object localObject2 = null;
    int i = 0;
    for (;;)
    {
      Object localObject1 = localObject2;
      try
      {
        if (i < this.jdField_b_of_type_JavaUtilList.size())
        {
          if ((VipGrayConfigHelper.VipGrayConfigListener)((WeakReference)this.jdField_b_of_type_JavaUtilList.get(i)).get() != paramVipGrayConfigListener) {
            break label89;
          }
          localObject1 = this.jdField_b_of_type_JavaUtilList.get(i);
        }
        if (localObject1 != null) {
          this.jdField_b_of_type_JavaUtilList.remove(localObject1);
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
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VipGrayConfigHelper
 * JD-Core Version:    0.7.0.1
 */