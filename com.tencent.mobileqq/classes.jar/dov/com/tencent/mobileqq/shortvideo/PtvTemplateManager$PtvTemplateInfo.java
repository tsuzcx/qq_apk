package dov.com.tencent.mobileqq.shortvideo;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import azmz;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PtvTemplateManager$PtvTemplateInfo
{
  public static final int AR_PARTICLE = 11;
  public static final int Category_Face = 0;
  public static final int Category_FaceAndGesture = 2;
  public static final int Category_Gesture = 1;
  public static final int D3D_TK = 1;
  public static final int DG_FILTER = 5;
  public static final int DISPLAY_TYPE_AR = 2;
  public static final int DISPLAY_TYPE_AUDIO = 1;
  public static final int DISPLAY_TYPE_CHANGE_VOICE = 4;
  public static final int DISPLAY_TYPE_DEFAULT = 0;
  public static final int DISPLAY_TYPE_WM = 3;
  public static final int DOODLE = 1;
  public static final int DOV_FILTER = 13;
  public static final int FDG_FILTER = 6;
  public static final int FILTER = 0;
  public static final int FOOLS_DAY = 10;
  public static int FUNC_REDBAG_GET = 1;
  public static final int LBS_MACDONALD = 1;
  public static final int LBS_NORMAL_FILTER = 0;
  public static final int MOVIE_FILTER = 3;
  public static final int NORMAL = 0;
  public static final int PORTRAIT_FILTER = 7;
  public static final int QQ_BIG_HEAD = 20;
  public static final int RANDOM_FORTUNE = 9;
  public static final int SHOOK_HEAD = 8;
  static final String SV_FILTER_DOWNLOAD_TIME = "sv_filter_download_time";
  public static final int WS_FILTER = 12;
  public static final int YSLD_FILTER = 2;
  public int activityType = 0;
  public boolean advertisement;
  public String androidopenurlheader;
  public String badgeurl;
  public String bigHeadMd5 = "";
  public boolean bigHeadModelUsable;
  public String bigHeadName = "";
  public String bigHeadUrl = "";
  public int businessID;
  public String buttonbgcolor;
  public String cameraScheme;
  public String cameraTitle;
  public int category = 0;
  public int categoryId;
  public String dgModelName;
  public String dgModelResmd5;
  public String dgModelResurl;
  public boolean dgModelUsable;
  public String dgStageName;
  public String dgStageResmd5;
  public String dgStageResurl;
  public boolean dgStageUsable;
  public int displayType = 0;
  public ArrayList<PtvTemplateManager.DoodleInfo> doodleInfos;
  public boolean downloading;
  public boolean editablewatermark;
  public int funcType;
  public String gestureType = "";
  public String gestureWording = "";
  public String iconurl;
  public String id;
  public String jump_app;
  public int kind = 0;
  public String md5;
  public boolean multivideosupport = true;
  public String name;
  public boolean needRedDot;
  public String openurl;
  public int platform;
  public String playShowCoverImg;
  public String playShowDisplayText;
  public boolean popup = true;
  public String popupbtn;
  public String popupbtn2;
  public String popupcontent;
  public String popupcontent2;
  public String popupimgurl;
  public boolean predownload;
  public String resurl;
  public double sizeFree;
  public long startDownloadTime;
  public String storeurl;
  public int templateStyle;
  public long totalLen;
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
          break;
        }
        localArrayList = new ArrayList(j);
        i = 0;
        if (i >= j) {
          break label156;
        }
        PtvTemplateInfo localPtvTemplateInfo = parseContent(paramJSONArray.getJSONObject(i));
        if (localPtvTemplateInfo == null) {
          break label161;
        }
        try
        {
          Long.parseLong(localPtvTemplateInfo.id);
          switch (localPtvTemplateInfo.kind)
          {
          case 1: 
            localArrayList.add(localPtvTemplateInfo);
          }
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            break label161;
          }
        }
        if (PtvTemplateManager.b()) {
          break label161;
        }
        localArrayList.add(localPtvTemplateInfo);
      }
      catch (JSONException paramJSONArray) {}
      QLog.e("PtvTemplateManager", 1, "templateId must be a numeric string!");
      break label161;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      paramJSONArray.printStackTrace();
      return null;
      localArrayList.add(localException);
      break label161;
      label156:
      return localArrayList;
      continue;
      label161:
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
  
  private static PtvTemplateInfo parseContent(JSONObject paramJSONObject)
  {
    PtvTemplateInfo localPtvTemplateInfo = new PtvTemplateInfo();
    try
    {
      if (paramJSONObject.has("id")) {
        localPtvTemplateInfo.id = paramJSONObject.getString("id");
      }
      if (paramJSONObject.has("iconurl")) {
        localPtvTemplateInfo.iconurl = paramJSONObject.getString("iconurl");
      }
      if (paramJSONObject.has("resurl")) {
        localPtvTemplateInfo.resurl = paramJSONObject.getString("resurl");
      }
      if (paramJSONObject.has("md5")) {
        localPtvTemplateInfo.md5 = paramJSONObject.getString("md5");
      }
      if (paramJSONObject.has("name")) {
        localPtvTemplateInfo.name = paramJSONObject.getString("name");
      }
      if (paramJSONObject.has("predownload")) {
        localPtvTemplateInfo.predownload = paramJSONObject.getBoolean("predownload");
      }
      if (paramJSONObject.has("platform")) {
        localPtvTemplateInfo.platform = paramJSONObject.getInt("platform");
      }
      if (paramJSONObject.has("businessID")) {
        localPtvTemplateInfo.businessID = paramJSONObject.getInt("businessID");
      }
      if (paramJSONObject.has("categoryId")) {
        localPtvTemplateInfo.categoryId = paramJSONObject.getInt("categoryId");
      }
      if (paramJSONObject.has("templateStyle")) {
        localPtvTemplateInfo.templateStyle = paramJSONObject.getInt("templateStyle");
      }
      if (paramJSONObject.has("needRedDot")) {
        localPtvTemplateInfo.needRedDot = paramJSONObject.getBoolean("needRedDot");
      }
      if (paramJSONObject.has("kind")) {
        localPtvTemplateInfo.kind = paramJSONObject.getInt("kind");
      }
      if (paramJSONObject.has("displayType")) {
        localPtvTemplateInfo.displayType = paramJSONObject.getInt("displayType");
      }
      if (paramJSONObject.has("qq_camera_top_title")) {
        localPtvTemplateInfo.cameraTitle = paramJSONObject.getString("qq_camera_top_title");
      }
      if (paramJSONObject.has("qq_camera_scheme")) {
        localPtvTemplateInfo.cameraScheme = paramJSONObject.getString("qq_camera_scheme");
      }
      if (paramJSONObject.has("activityType")) {
        localPtvTemplateInfo.activityType = paramJSONObject.getInt("activityType");
      }
      if (paramJSONObject.has("category")) {
        localPtvTemplateInfo.category = paramJSONObject.getInt("category");
      }
      if (paramJSONObject.has("gestureType")) {
        localPtvTemplateInfo.gestureType = paramJSONObject.getString("gestureType");
      }
      if (paramJSONObject.has("gestureWording")) {
        localPtvTemplateInfo.gestureWording = paramJSONObject.getString("gestureWording");
      }
      if (paramJSONObject.has("advertisement")) {
        localPtvTemplateInfo.advertisement = paramJSONObject.getBoolean("advertisement");
      }
      if (paramJSONObject.has("androidopenurlheader")) {
        localPtvTemplateInfo.androidopenurlheader = paramJSONObject.getString("androidopenurlheader");
      }
      if (paramJSONObject.has("openurl")) {
        localPtvTemplateInfo.openurl = paramJSONObject.getString("openurl");
      }
      if (paramJSONObject.has("storeurl")) {
        localPtvTemplateInfo.storeurl = paramJSONObject.getString("storeurl");
      }
      if (paramJSONObject.has("popup")) {
        localPtvTemplateInfo.popup = paramJSONObject.getBoolean("popup");
      }
      if (paramJSONObject.has("badgeurl")) {
        localPtvTemplateInfo.badgeurl = paramJSONObject.getString("badgeurl");
      }
      if (paramJSONObject.has("popupimgurl")) {
        localPtvTemplateInfo.popupimgurl = paramJSONObject.getString("popupimgurl");
      }
      if (paramJSONObject.has("popupcontent")) {
        localPtvTemplateInfo.popupcontent = paramJSONObject.getString("popupcontent");
      }
      if (paramJSONObject.has("popupbtn")) {
        localPtvTemplateInfo.popupbtn = paramJSONObject.getString("popupbtn");
      }
      if (paramJSONObject.has("popupcontent2")) {
        localPtvTemplateInfo.popupcontent2 = paramJSONObject.getString("popupcontent2");
      }
      if (paramJSONObject.has("popupbtn2")) {
        localPtvTemplateInfo.popupbtn2 = paramJSONObject.getString("popupbtn2");
      }
      if (paramJSONObject.has("buttonbgcolor")) {
        localPtvTemplateInfo.buttonbgcolor = paramJSONObject.getString("buttonbgcolor");
      }
      if (paramJSONObject.has("multivideosupport")) {
        localPtvTemplateInfo.multivideosupport = paramJSONObject.getBoolean("multivideosupport");
      }
      if (paramJSONObject.has("sizeFree")) {
        localPtvTemplateInfo.sizeFree = paramJSONObject.getDouble("sizeFree");
      }
      if (paramJSONObject.has("jump_app")) {
        localPtvTemplateInfo.jump_app = paramJSONObject.getString("jump_app");
      }
      if (paramJSONObject.has("funcType")) {
        localPtvTemplateInfo.funcType = paramJSONObject.getInt("funcType");
      }
    }
    catch (Exception paramJSONObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PtvTemplateManager", 1, "parseContent error=" + paramJSONObject.getMessage());
    }
    return localPtvTemplateInfo;
    return localPtvTemplateInfo;
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
    azmz.a(VideoEnvironment.a()).a(null, "sv_filter_download_time", true, 0L, 0L, localHashMap, "");
  }
  
  public int getDisplayIconByType()
  {
    switch (this.displayType)
    {
    default: 
      return -1;
    case 1: 
      return 2130844110;
    case 2: 
      return 2130844111;
    case 3: 
      return 2130844113;
    }
    return 2130844112;
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
  
  public boolean isDovItem()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(this.jump_app))
    {
      bool1 = bool2;
      if (this.jump_app.startsWith("qim")) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isWsBanner()
  {
    return this.kind == 12;
  }
  
  public boolean needDisplayType()
  {
    return this.displayType != 0;
  }
  
  public String toString()
  {
    return "PtvTemplateInfo{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", dooleInfos=" + this.doodleInfos + '\'' + ",usable=" + this.usable + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo
 * JD-Core Version:    0.7.0.1
 */