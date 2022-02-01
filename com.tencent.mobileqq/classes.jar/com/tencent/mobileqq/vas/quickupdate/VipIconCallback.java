package com.tencent.mobileqq.vas.quickupdate;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class VipIconCallback
  extends BaseUpdateCallback
{
  public static final String SCID_CONFIG = "namePlate_UrlConfig";
  public static final String WILDCARD = "1000000";
  public static VipIconCallback sInstance = new VipIconCallback();
  private List<VipIconCallback.VipIconClickConfig> configs = null;
  
  private ArrayList<VipIconCallback.VipIconClickConfig> buildConfigs()
  {
    localArrayList = new ArrayList();
    try
    {
      Object localObject = readJsonString();
      if ((localObject == null) && (TextUtils.isEmpty((CharSequence)localObject))) {
        return localArrayList;
      }
      localObject = new JSONObject((String)localObject).getJSONArray("namePlateUrlConfig");
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        VipIconCallback.VipIconClickConfig localVipIconClickConfig = new VipIconCallback.VipIconClickConfig();
        localVipIconClickConfig.a = localJSONObject.optString("vipType");
        localVipIconClickConfig.b = localJSONObject.optString("itemId");
        localVipIconClickConfig.d = localJSONObject.optString("drawerUrl");
        localVipIconClickConfig.e = localJSONObject.optString("VaProfileUrl");
        localVipIconClickConfig.f = localJSONObject.optString("ctocUrl");
        localVipIconClickConfig.c = localJSONObject.optString("nameplateType");
        localVipIconClickConfig.g = localJSONObject.optString("VaProfileGuestUrl");
        localVipIconClickConfig.h = localJSONObject.optString("ctocGuestUrl");
        localVipIconClickConfig.i = localJSONObject.optString("ctocSettingUrl");
        localVipIconClickConfig.j = localJSONObject.optString("ctocSettingGuestUrl");
        localArrayList.add(localVipIconClickConfig);
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  @Nullable
  public VipIconCallback.VipIconClickConfig findConfig(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.configs == null) {
      try
      {
        if (this.configs == null) {
          this.configs = buildConfigs();
        }
      }
      finally {}
    }
    Object localObject2 = null;
    Iterator localIterator = this.configs.iterator();
    while (localIterator.hasNext())
    {
      VipIconCallback.VipIconClickConfig localVipIconClickConfig = (VipIconCallback.VipIconClickConfig)localIterator.next();
      if ((localVipIconClickConfig.a.equals(String.valueOf(paramInt1))) && (localVipIconClickConfig.c.equals(String.valueOf(paramInt3))))
      {
        if (localVipIconClickConfig.b.equals(String.valueOf(paramInt2))) {
          return localVipIconClickConfig;
        }
        if (localVipIconClickConfig.b.equals("1000000")) {
          localObject2 = localVipIconClickConfig;
        }
      }
    }
    return localObject2;
  }
  
  public long getBID()
  {
    return 34L;
  }
  
  protected String getRootDir()
  {
    return "vipicon";
  }
  
  protected String getScidPrefix()
  {
    return "namePlate_UrlConfig";
  }
  
  public boolean isFileExists(String paramString)
  {
    return super.isFileExists(getBID(), paramString);
  }
  
  protected boolean isZip_KeepZip()
  {
    return false;
  }
  
  String readJsonString()
  {
    try
    {
      String str = FileUtils.readFileToString(new File(getSavePath(MobileQQ.getContext(), "namePlate_UrlConfig")));
      return str;
    }
    catch (Exception localException)
    {
      label22:
      break label22;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.VipIconCallback
 * JD-Core Version:    0.7.0.1
 */