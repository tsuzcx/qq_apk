package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bjli;
import java.util.HashMap;
import java.util.Map;

public class WeishiBasicInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WeishiBasicInfo> CREATOR = new bjli();
  public String cover_url;
  public Map<String, String> dc_report;
  public String nick_name;
  public String weishi_feedId;
  public String weishi_fileId;
  public String weishi_musicId;
  public String weishi_musicName;
  public String weishi_musicUrl;
  public String weishi_schema;
  public String weishi_summary;
  public String weishi_topicID;
  public String weishi_topicName;
  public String weishi_topicUrl;
  
  public WeishiBasicInfo(Parcel paramParcel)
  {
    this.weishi_feedId = paramParcel.readString();
    this.weishi_fileId = paramParcel.readString();
    this.cover_url = paramParcel.readString();
    this.nick_name = paramParcel.readString();
    this.weishi_musicId = paramParcel.readString();
    this.weishi_musicName = paramParcel.readString();
    this.weishi_musicUrl = paramParcel.readString();
    this.weishi_topicID = paramParcel.readString();
    this.weishi_topicName = paramParcel.readString();
    this.weishi_topicUrl = paramParcel.readString();
    this.weishi_schema = paramParcel.readString();
    this.dc_report = new HashMap();
    paramParcel.readMap(this.dc_report, this.dc_report.getClass().getClassLoader());
    this.weishi_summary = paramParcel.readString();
  }
  
  public WeishiBasicInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, Map<String, String> paramMap, String paramString12)
  {
    this.weishi_feedId = paramString1;
    this.weishi_fileId = paramString2;
    this.cover_url = paramString3;
    this.nick_name = paramString4;
    this.weishi_musicId = paramString5;
    this.weishi_musicName = paramString6;
    this.weishi_musicUrl = paramString7;
    this.weishi_topicID = paramString8;
    this.weishi_topicName = paramString9;
    this.weishi_topicUrl = paramString10;
    this.weishi_schema = paramString11;
    this.dc_report = paramMap;
    this.weishi_summary = paramString12;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.weishi_feedId);
    paramParcel.writeString(this.weishi_fileId);
    paramParcel.writeString(this.cover_url);
    paramParcel.writeString(this.nick_name);
    paramParcel.writeString(this.weishi_musicId);
    paramParcel.writeString(this.weishi_musicName);
    paramParcel.writeString(this.weishi_musicUrl);
    paramParcel.writeString(this.weishi_topicID);
    paramParcel.writeString(this.weishi_topicName);
    paramParcel.writeString(this.weishi_topicUrl);
    paramParcel.writeString(this.weishi_schema);
    paramParcel.writeMap(this.dc_report);
    paramParcel.writeString(this.weishi_summary);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.model.WeishiBasicInfo
 * JD-Core Version:    0.7.0.1
 */