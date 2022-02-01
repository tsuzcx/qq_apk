package cooperation.qzone.model;

import NS_MOBILE_COVER_DATE.CoverPackageInfo;
import NS_MOBILE_COVER_DATE.GameCoverInfo;
import NS_MOBILE_COVER_DATE.feeds_cover;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CoverCacheData
  implements Parcelable
{
  public static final Parcelable.Creator<CoverCacheData> CREATOR = new CoverCacheData.1();
  public int alian = 0;
  public HashMap<String, String> backupMapExtInfo;
  public String coverId = "";
  public CoverCacheData.GameCoverInfo gameCoverInfo;
  public int isJigsawOpen = 0;
  public String local_url = "";
  public HashMap<String, String> mapExtInfo = new HashMap();
  public CoverCacheData.PackageInfo packageInfo;
  public ArrayList<Map<Integer, String>> photoWall = new ArrayList();
  public String type = "";
  public long uin = 0L;
  public HashMap<String, String> urls = new HashMap();
  
  public static CoverCacheData createFromResponse(long paramLong, feeds_cover paramfeeds_cover)
  {
    if (paramfeeds_cover == null) {
      return null;
    }
    CoverCacheData localCoverCacheData = new CoverCacheData();
    localCoverCacheData.uin = paramLong;
    localCoverCacheData.coverId = paramfeeds_cover.id;
    localCoverCacheData.type = paramfeeds_cover.type;
    localCoverCacheData.isJigsawOpen = paramfeeds_cover.photoWallCombinePic;
    if (paramfeeds_cover.MulRelsotionUrl != null) {
      localCoverCacheData.urls.putAll(paramfeeds_cover.MulRelsotionUrl);
    }
    if (paramfeeds_cover.packageInfo != null)
    {
      localCoverCacheData.packageInfo = new CoverCacheData.PackageInfo();
      localCoverCacheData.packageInfo.prePic = paramfeeds_cover.packageInfo.prePic;
      localCoverCacheData.packageInfo.PackageUrl = paramfeeds_cover.packageInfo.PackageUrl;
      localCoverCacheData.packageInfo.md5 = paramfeeds_cover.packageInfo.md5;
      localCoverCacheData.packageInfo.weather = paramfeeds_cover.packageInfo.weather;
      localCoverCacheData.packageInfo.daytime = paramfeeds_cover.packageInfo.daytime;
      localCoverCacheData.packageInfo.coverStyle = paramfeeds_cover.packageInfo.coverStyle;
    }
    if (paramfeeds_cover.gameCoverInfo != null)
    {
      localCoverCacheData.gameCoverInfo = new CoverCacheData.GameCoverInfo();
      localCoverCacheData.gameCoverInfo.xCoordLU = paramfeeds_cover.gameCoverInfo.xCoordLU;
      localCoverCacheData.gameCoverInfo.yCoordLU = paramfeeds_cover.gameCoverInfo.yCoordLU;
      localCoverCacheData.gameCoverInfo.xCoordRD = paramfeeds_cover.gameCoverInfo.xCoordRD;
      localCoverCacheData.gameCoverInfo.yCoordRD = paramfeeds_cover.gameCoverInfo.yCoordRD;
      localCoverCacheData.gameCoverInfo.jmpUrl = paramfeeds_cover.gameCoverInfo.jmpUrl;
      localCoverCacheData.gameCoverInfo.schema = paramfeeds_cover.gameCoverInfo.schema;
      localCoverCacheData.gameCoverInfo.jmpType = paramfeeds_cover.gameCoverInfo.jmpType;
    }
    if ((paramfeeds_cover.vecUrls != null) && (paramfeeds_cover.vecUrls.size() > 0)) {
      localCoverCacheData.photoWall.addAll(paramfeeds_cover.vecUrls);
    }
    if (paramfeeds_cover.mapExtInfo != null) {
      localCoverCacheData.mapExtInfo.putAll(paramfeeds_cover.mapExtInfo);
    }
    return localCoverCacheData;
  }
  
  public static CoverCacheData createFromResponse(long paramLong, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp)
  {
    if (parammobile_sub_get_cover_rsp == null) {
      return null;
    }
    CoverCacheData localCoverCacheData = new CoverCacheData();
    localCoverCacheData.uin = paramLong;
    localCoverCacheData.type = parammobile_sub_get_cover_rsp.type;
    localCoverCacheData.isJigsawOpen = parammobile_sub_get_cover_rsp.photoWallCombinePic;
    if (parammobile_sub_get_cover_rsp.MulRelsotionUrl != null) {
      localCoverCacheData.urls.putAll(parammobile_sub_get_cover_rsp.MulRelsotionUrl);
    }
    if (parammobile_sub_get_cover_rsp.packageInfo != null)
    {
      localCoverCacheData.packageInfo = new CoverCacheData.PackageInfo();
      localCoverCacheData.packageInfo.prePic = parammobile_sub_get_cover_rsp.packageInfo.prePic;
      localCoverCacheData.packageInfo.PackageUrl = parammobile_sub_get_cover_rsp.packageInfo.PackageUrl;
      localCoverCacheData.packageInfo.md5 = parammobile_sub_get_cover_rsp.packageInfo.md5;
      localCoverCacheData.packageInfo.weather = parammobile_sub_get_cover_rsp.packageInfo.weather;
      localCoverCacheData.packageInfo.daytime = parammobile_sub_get_cover_rsp.packageInfo.daytime;
      localCoverCacheData.packageInfo.coverStyle = parammobile_sub_get_cover_rsp.packageInfo.coverStyle;
    }
    if ((parammobile_sub_get_cover_rsp.vecUrls != null) && (parammobile_sub_get_cover_rsp.vecUrls.size() > 0)) {
      localCoverCacheData.photoWall.addAll(parammobile_sub_get_cover_rsp.vecUrls);
    }
    return localCoverCacheData;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean isVideoCover()
  {
    return ("CustomVideoCover".equals(this.type)) || ("VideoCover".equals(this.type));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.uin);
    paramParcel.writeString(this.coverId);
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.local_url);
    paramParcel.writeMap(this.urls);
    paramParcel.writeParcelable(this.packageInfo, paramInt);
    paramParcel.writeParcelable(this.gameCoverInfo, paramInt);
    paramParcel.writeList(this.photoWall);
    paramParcel.writeInt(this.isJigsawOpen);
    paramParcel.writeMap(this.mapExtInfo);
    paramParcel.writeMap(this.backupMapExtInfo);
    paramParcel.writeInt(this.alian);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.model.CoverCacheData
 * JD-Core Version:    0.7.0.1
 */