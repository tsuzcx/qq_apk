package com.tencent.mobileqq.troop.entereffect;

import QQService.EVIPSPEC;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopEnterEffectConfig$GrayTipsConfig
{
  private static final String o = HardCodeUtil.a(2131912574);
  public int a;
  public boolean b;
  public int c;
  public String d;
  public ArrayList<TroopEnterEffectConfig.GrayTipsConfig.Link> e = new ArrayList();
  public boolean f;
  public int g;
  public String h;
  public int i;
  public int j;
  public int k;
  public String l;
  public ArrayList<Integer> m = new ArrayList();
  public int n;
  
  public static int a(AppRuntime paramAppRuntime)
  {
    String str = paramAppRuntime.getCurrentUin();
    paramAppRuntime = (IFriendDataService)paramAppRuntime.getRuntimeService(IFriendDataService.class, "all");
    int i2 = 1;
    paramAppRuntime = paramAppRuntime.getFriend(str, true);
    int i1 = i2;
    if (paramAppRuntime != null)
    {
      boolean bool = paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
      if (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))
      {
        if (paramAppRuntime.getServiceType(EVIPSPEC.E_SP_SUPERVIP) == 1) {
          return 22;
        }
        return 5;
      }
      i1 = i2;
      if (bool)
      {
        if (paramAppRuntime.getServiceType(EVIPSPEC.E_SP_QQVIP) == 1) {
          return 21;
        }
        i1 = 4;
      }
    }
    return i1;
  }
  
  private void a()
  {
    while (this.d.indexOf('[') > 0)
    {
      int i3 = this.d.indexOf('[');
      this.d = this.d.replaceFirst("\\[", "");
      int i2 = this.d.indexOf(']', i3);
      int i1 = i2;
      if (i2 > 0)
      {
        this.d = this.d.replaceFirst("]", "");
        i1 = i2 - 1;
      }
      if (i1 < this.d.length() - 1)
      {
        String str1 = this.d;
        i2 = i1 + 1;
        if (str1.charAt(i2) == '(')
        {
          i1 += 2;
          int i4 = this.d.indexOf(')', i1);
          if (i4 > 0)
          {
            str1 = this.d.substring(i1, i4);
            Object localObject = new StringBuilder();
            ((StringBuilder)localObject).append(this.d.substring(0, i1 - 1));
            String str2 = this.d;
            ((StringBuilder)localObject).append(str2.substring(i4 + 1, str2.length()));
            this.d = ((StringBuilder)localObject).toString();
            localObject = new TroopEnterEffectConfig.GrayTipsConfig.Link();
            ((TroopEnterEffectConfig.GrayTipsConfig.Link)localObject).a = i3;
            ((TroopEnterEffectConfig.GrayTipsConfig.Link)localObject).b = i2;
            ((TroopEnterEffectConfig.GrayTipsConfig.Link)localObject).c = str1;
            this.e.add(localObject);
          }
        }
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      QLog.e("GrayTipsConfig.GrayTips", 1, "mergeFromJson error grayTipsObj == null");
      return;
    }
    this.a = paramJSONObject.optInt("id");
    int i2 = paramJSONObject.optInt("isValid");
    int i1 = 0;
    boolean bool;
    if (i2 == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.b = bool;
    this.c = paramJSONObject.optInt("priority");
    this.d = paramJSONObject.optString("wording");
    a();
    if (paramJSONObject.optInt("noLongerPrompt") == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.f = bool;
    Object localObject;
    if (this.f)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(o);
      this.d = ((StringBuilder)localObject).toString();
    }
    this.g = paramJSONObject.optInt("linkType");
    this.h = paramJSONObject.optString("serviceCode");
    this.i = paramJSONObject.optInt("hardType");
    this.j = paramJSONObject.optInt("openMonth");
    this.k = paramJSONObject.optInt("hardMonth");
    this.l = paramJSONObject.optString("aidAndroid");
    try
    {
      localObject = paramJSONObject.optJSONArray("vipType");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
        while (i1 < ((JSONArray)localObject).length())
        {
          this.m.add(Integer.valueOf(((JSONArray)localObject).getInt(i1)));
          i1 += 1;
        }
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mergeFromJson error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("GrayTipsConfig.GrayTips", 1, localStringBuilder.toString());
      this.n = paramJSONObject.optInt("settingStatus");
    }
  }
  
  public boolean a(int paramInt, AppRuntime paramAppRuntime)
  {
    int i1 = a(paramAppRuntime);
    boolean bool3 = this.b;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      int i2 = this.n;
      if (paramInt != i2)
      {
        bool1 = bool2;
        if (i2 != 0) {}
      }
      else if (!this.m.contains(Integer.valueOf(i1)))
      {
        bool1 = bool2;
        if (!this.m.contains(Integer.valueOf(0))) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.entereffect.TroopEnterEffectConfig.GrayTipsConfig
 * JD-Core Version:    0.7.0.1
 */