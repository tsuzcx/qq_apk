package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Map;

public class QZoneShareData
  implements Parcelable
{
  public static final Parcelable.Creator<QZoneShareData> CREATOR = new QZoneShareData.1();
  public static final int FROM_DEFAULT = 0;
  public static final int FROM_H5 = 2;
  public static final int FROM_THIRD_PARTY_SHARE = 1;
  public static final int OTHER_PLATFORM_NOT_SHOW = 0;
  public static final int OTHER_PLATFORM_SHOW = 1;
  public String action;
  public String appName;
  public long appid;
  public String extString;
  public int from;
  public int iUrlInfoFrm;
  public String jFrom;
  public String mDefaultForwardReason;
  public String mHint;
  public ArrayList<String> mImageUrls;
  public long mShareBeginTime;
  public String mSummary;
  public String mTitle;
  public String mWebUrl;
  public String openId;
  public String pkgname;
  public Map<String, String> qzoneShareInfo;
  public String shareUin;
  public int showShareOtherPlat;
  public String targetUrl;
  public Map<String, String> xcxMapEx;
  
  public QZoneShareData() {}
  
  private QZoneShareData(Parcel paramParcel)
  {
    this.appid = paramParcel.readLong();
    this.openId = paramParcel.readString();
    this.mTitle = paramParcel.readString();
    this.mSummary = paramParcel.readString();
    this.targetUrl = paramParcel.readString();
    this.mImageUrls = new ArrayList();
    paramParcel.readStringList(this.mImageUrls);
    this.appName = paramParcel.readString();
    this.shareUin = paramParcel.readString();
    this.extString = paramParcel.readString();
    this.iUrlInfoFrm = paramParcel.readInt();
    this.from = paramParcel.readInt();
    this.action = paramParcel.readString();
    this.pkgname = paramParcel.readString();
    this.showShareOtherPlat = paramParcel.readInt();
    this.jFrom = paramParcel.readString();
    this.mShareBeginTime = paramParcel.readLong();
    this.mHint = paramParcel.readString();
    this.mDefaultForwardReason = paramParcel.readString();
    this.mWebUrl = paramParcel.readString();
    this.qzoneShareInfo = paramParcel.readHashMap(Map.class.getClassLoader());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appid:");
    localStringBuilder.append(this.appid);
    localStringBuilder.append(" openId:");
    localStringBuilder.append(this.openId);
    localStringBuilder.append(" mTitle:");
    localStringBuilder.append(this.mTitle);
    localStringBuilder.append(" mSummary:");
    localStringBuilder.append(this.mSummary);
    localStringBuilder.append(" targetUrl:");
    localStringBuilder.append(this.targetUrl);
    localStringBuilder.append(" mImageUrl:");
    localStringBuilder.append(this.mImageUrls.toString());
    localStringBuilder.append(" appName:");
    localStringBuilder.append(this.appName);
    localStringBuilder.append(" shareUin:");
    localStringBuilder.append(this.shareUin);
    localStringBuilder.append(" extString:");
    localStringBuilder.append(this.extString);
    localStringBuilder.append(" from:");
    localStringBuilder.append(this.from);
    localStringBuilder.append(" action:");
    localStringBuilder.append(this.action);
    localStringBuilder.append(" pkgname:");
    localStringBuilder.append(this.pkgname);
    localStringBuilder.append(" iUrlInfoFrm");
    localStringBuilder.append(this.iUrlInfoFrm);
    localStringBuilder.append(" mWebUrl:");
    localStringBuilder.append(this.mWebUrl);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.appid);
    paramParcel.writeString(this.openId);
    paramParcel.writeString(this.mTitle);
    paramParcel.writeString(this.mSummary);
    paramParcel.writeString(this.targetUrl);
    paramParcel.writeStringList(this.mImageUrls);
    paramParcel.writeString(this.appName);
    paramParcel.writeString(this.shareUin);
    paramParcel.writeString(this.extString);
    paramParcel.writeInt(this.iUrlInfoFrm);
    paramParcel.writeInt(this.from);
    paramParcel.writeString(this.action);
    paramParcel.writeString(this.pkgname);
    paramParcel.writeInt(this.showShareOtherPlat);
    paramParcel.writeString(this.jFrom);
    paramParcel.writeLong(this.mShareBeginTime);
    paramParcel.writeString(this.mHint);
    paramParcel.writeString(this.mDefaultForwardReason);
    paramParcel.writeString(this.mWebUrl);
    paramParcel.writeMap(this.qzoneShareInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.QZoneShareData
 * JD-Core Version:    0.7.0.1
 */