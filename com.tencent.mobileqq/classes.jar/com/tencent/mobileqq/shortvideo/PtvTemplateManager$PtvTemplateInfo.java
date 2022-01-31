package com.tencent.mobileqq.shortvideo;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import azri;
import bdcs;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class PtvTemplateManager$PtvTemplateInfo
{
  public static final int AR_PARTICLE = 9;
  public static final int Category_BeautyMakeup = 3;
  public static final int Category_Face = 0;
  public static final int Category_FaceAndGesture = 2;
  public static final int Category_Gesture = 1;
  public static final int D3D_TK = 1;
  public static final int DG_FILTER = 3;
  public static final int DOODLE = 1;
  public static final int DOV_DG_FILTER = 5;
  public static final int DOV_FDG_FILTER = 6;
  public static final int FDG_FILTER = 4;
  public static final int FILTER = 0;
  public static int FUNC_REDBAG_GET = 1;
  public static final int LBS_MACDONALD = 1;
  public static final int LBS_NORMAL_FILTER = 0;
  public static final int NORMAL = 0;
  public static final int OLD_FILTER = 22;
  public static final int PORTRAIT_FILTER = 7;
  public static final int PTU_FILTER = 21;
  public static final int QQ_BIG_HEAD = 20;
  static final String SV_FILTER_DOWNLOAD_TIME = "sv_filter_download_time";
  public static final int YSLD_FILTER = 2;
  public int activityType = 0;
  public String advertiseIconUrl;
  public String advertiseStr;
  public String advertiseWebUrl;
  public boolean advertisement;
  public String androidopenurlheader;
  public String badgeurl;
  public String bigHeadMd5 = "";
  public boolean bigHeadModelUsable;
  public String bigHeadName = "";
  public String bigHeadUrl = "";
  public int businessID;
  public String buttonbgcolor;
  public int category = 0;
  public int categoryId;
  public String categoryName;
  public int color;
  public String dgModelName;
  public String dgModelResmd5;
  public String dgModelResurl;
  public boolean dgModelUsable;
  public String dgStageName;
  public String dgStageResmd5;
  public String dgStageResurl;
  public boolean dgStageUsable;
  public ArrayList<PtvTemplateManager.DoodleInfo> doodleInfos;
  public boolean downloading;
  public String filtername;
  public int funcType;
  public String gestureType = "";
  public String gestureWording = "";
  public String iconurl;
  public String id;
  public boolean isAdvertise;
  public boolean isSelected;
  public boolean isshow = true;
  public int kind = 0;
  public String md5;
  public String name;
  public boolean needRedDot;
  public String openurl;
  public int platform;
  public boolean popup = true;
  public String popupbtn;
  public String popupbtn2;
  public String popupcontent;
  public String popupcontent2;
  public String popupimgurl;
  public boolean predownload;
  public boolean renderfirst = true;
  public String resurl;
  public double sizeFree;
  long startDownloadTime;
  public String storeurl;
  public int templateStyle;
  public long totalLen;
  public int type;
  public boolean usable;
  
  public static List<PtvTemplateInfo> convertFrom(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      try
      {
        paramString = convertFrom(new JSONArray(paramString));
        return paramString;
      }
      catch (JSONException paramString) {}
    } while (!QLog.isDevelopLevel());
    paramString.printStackTrace();
    return null;
  }
  
  public static List<PtvTemplateInfo> convertFrom(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      try
      {
        int j = paramJSONArray.length();
        if (j <= 0) {
          return null;
        }
        localArrayList = new ArrayList(j);
        i = 0;
        if (i >= j) {
          break label188;
        }
        PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateInfo)bdcs.a(paramJSONArray.getJSONObject(i), PtvTemplateInfo.class);
        if (localPtvTemplateInfo == null) {
          break label193;
        }
        try
        {
          Long.parseLong(localPtvTemplateInfo.id);
          switch (localPtvTemplateInfo.kind)
          {
          case 2: 
            localArrayList.add(localPtvTemplateInfo);
          }
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            break label193;
          }
        }
        localArrayList.add(localPtvTemplateInfo);
      }
      catch (JSONException paramJSONArray)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        paramJSONArray.printStackTrace();
        return null;
      }
      QLog.e("PtvTemplateManager", 1, "templateId must be a numeric string!");
      break label193;
      if (!PtvTemplateManager.e())
      {
        localArrayList.add(localException);
        break label193;
        localArrayList.add(localException);
        break label193;
        localArrayList.add(localException);
        break label193;
        label188:
        return localArrayList;
        continue;
      }
      label193:
      i += 1;
    }
  }
  
  public static boolean isFace(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 0);
  }
  
  public static boolean isGesture(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1);
  }
  
  public void doDownloadDataReport()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.startDownloadTime;
    HashMap localHashMap = new HashMap();
    localHashMap.put("MANUFACTURER", Build.MANUFACTURER);
    localHashMap.put("MODEL", Build.MODEL);
    localHashMap.put("SDK_INT", "" + Build.VERSION.SDK_INT);
    localHashMap.put("timems", "" + (l1 - l2));
    localHashMap.put("totalsize", "" + this.totalLen);
    localHashMap.put("success", "" + this.usable);
    azri.a(VideoEnvironment.a()).a(null, "sv_filter_download_time", true, 0L, 0L, localHashMap, "");
  }
  
  public String getLbsActivityType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "LBS_NORMAL_FILTER_" + paramInt;
    }
    return "LBS_MACDONALD_" + paramInt;
  }
  
  public boolean hasFace()
  {
    return isFace(this.category);
  }
  
  public boolean hasGesture()
  {
    return isGesture(this.category);
  }
  
  public String toString()
  {
    return "PtvTemplateInfo{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", dooleInfos=" + this.doodleInfos + '\'' + ",usable=" + this.usable + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo
 * JD-Core Version:    0.7.0.1
 */