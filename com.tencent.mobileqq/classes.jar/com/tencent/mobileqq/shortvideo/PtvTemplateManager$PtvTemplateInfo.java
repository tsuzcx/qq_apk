package com.tencent.mobileqq.shortvideo;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.business.manager.pendant.IPendantKind;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class PtvTemplateManager$PtvTemplateInfo
  implements IPendantKind
{
  public static final int Category_BeautyMakeup = 3;
  public static final int Category_Face = 0;
  public static final int Category_FaceAndGesture = 2;
  public static final int Category_Gesture = 1;
  public static final int DOODLE = 1;
  public static int FUNC_REDBAG_GET = 1;
  public static final int LBS_MACDONALD = 1;
  public static final int LBS_NORMAL_FILTER = 0;
  public static final int NORMAL = 0;
  static final String SV_FILTER_DOWNLOAD_TIME = "sv_filter_download_time";
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
  public int businessID = 0;
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
  public int funcType = 0;
  public String gestureType = "";
  public String gestureWording = "";
  public String iconurl;
  public String id;
  public boolean isAdvertise;
  public boolean isSelected = false;
  public boolean isshow = true;
  public int kind = 0;
  public String md5;
  public String name;
  public boolean needRedDot;
  public String openurl;
  public int platform = 0;
  public boolean popup = true;
  public String popupbtn;
  public String popupbtn2;
  public String popupcontent;
  public String popupcontent2;
  public String popupimgurl;
  public boolean predownload;
  public boolean renderfirst = true;
  public String resurl;
  public double sizeFree = 0.0D;
  long startDownloadTime;
  public String storeurl;
  public int templateStyle = 0;
  public long totalLen;
  public int type;
  public boolean usable;
  
  public static List<PtvTemplateInfo> convertFrom(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = convertFrom(new JSONArray(paramString));
      return paramString;
    }
    catch (JSONException paramString)
    {
      if (QLog.isDevelopLevel()) {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static List<PtvTemplateInfo> convertFrom(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        int j = paramJSONArray.length();
        if (j <= 0) {
          return null;
        }
        localArrayList = new ArrayList(j);
        i = 0;
        if (i < j)
        {
          localPtvTemplateInfo = (PtvTemplateInfo)JSONUtils.a(paramJSONArray.getJSONObject(i), PtvTemplateInfo.class);
          if (localPtvTemplateInfo == null) {}
        }
      }
      catch (JSONException paramJSONArray)
      {
        ArrayList localArrayList;
        int i;
        PtvTemplateInfo localPtvTemplateInfo;
        int k;
        if (QLog.isDevelopLevel()) {
          paramJSONArray.printStackTrace();
        }
        return null;
      }
      try
      {
        Long.parseLong(localPtvTemplateInfo.id);
        k = localPtvTemplateInfo.kind;
        if (k != 0)
        {
          if (k != 1)
          {
            if (k != 2)
            {
              if ((k != 3) && (k != 4)) {
                localArrayList.add(localPtvTemplateInfo);
              } else {
                localArrayList.add(localPtvTemplateInfo);
              }
            }
            else {
              localArrayList.add(localPtvTemplateInfo);
            }
          }
          else if (!PtvTemplateManager.k()) {
            localArrayList.add(localPtvTemplateInfo);
          }
        }
        else {
          localArrayList.add(localPtvTemplateInfo);
        }
      }
      catch (Exception localException)
      {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.e("PtvTemplateManager", 1, "templateId must be a numeric string!");
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static boolean isFace(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 0);
  }
  
  public static boolean isGesture(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 2)
    {
      if (paramInt == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void doDownloadDataReport()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.startDownloadTime;
    HashMap localHashMap = new HashMap();
    localHashMap.put("MANUFACTURER", Build.MANUFACTURER);
    localHashMap.put("MODEL", Build.MODEL);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    localHashMap.put("SDK_INT", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(l1 - l2);
    localHashMap.put("timems", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.totalLen);
    localHashMap.put("totalsize", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.usable);
    localHashMap.put("success", localStringBuilder.toString());
    StatisticCollector.getInstance(VideoEnvironment.getContext()).collectPerformance(null, "sv_filter_download_time", true, 0L, 0L, localHashMap, "");
  }
  
  public String getLbsActivityType(int paramInt)
  {
    if (paramInt != 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("LBS_NORMAL_FILTER_");
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LBS_MACDONALD_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PtvTemplateInfo{id='");
    localStringBuilder.append(this.id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dooleInfos=");
    localStringBuilder.append(this.doodleInfos);
    localStringBuilder.append('\'');
    localStringBuilder.append(",usable=");
    localStringBuilder.append(this.usable);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo
 * JD-Core Version:    0.7.0.1
 */