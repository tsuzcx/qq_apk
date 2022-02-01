package cooperation.qqcircle.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;

public class QCircleReportHelper$LaunchParam
  implements Parcelable
{
  public static final Parcelable.Creator<LaunchParam> CREATOR = new QCircleReportHelper.LaunchParam.1();
  public String launchFrom;
  public String launchId;
  public int launchScene;
  public HashMap<String, String> schemeAttrs;
  public String toUin;
  
  public static LaunchParam wrap(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.launchFrom = paramString1;
    localLaunchParam.launchId = paramString2;
    localLaunchParam.toUin = paramString3;
    localLaunchParam.launchScene = paramInt;
    return localLaunchParam;
  }
  
  public static LaunchParam wrap(String paramString1, String paramString2, String paramString3, int paramInt, HashMap<String, String> paramHashMap)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.launchFrom = paramString1;
    localLaunchParam.launchId = paramString2;
    localLaunchParam.toUin = paramString3;
    localLaunchParam.launchScene = paramInt;
    localLaunchParam.schemeAttrs = paramHashMap;
    return localLaunchParam;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.launchFrom);
    paramParcel.writeString(this.launchId);
    paramParcel.writeString(this.toUin);
    paramParcel.writeInt(this.launchScene);
    paramParcel.writeMap(this.schemeAttrs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReportHelper.LaunchParam
 * JD-Core Version:    0.7.0.1
 */