package dov.com.tencent.mobileqq.shortvideo.util.videoconverter;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aozf;
import com.tencent.mobileqq.persistence.Entity;
import org.json.JSONObject;

public class ShortVideoTravellerManager$TravellerVideoItem
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new aozf();
  public static final String TRAVELLER_PROVIDER_CATEGORY = "category";
  public static final String TRAVELLER_PROVIDER_ITEM_ID = "item_id";
  public static final String TRAVELLER_PROVIDER_TYPE = "type";
  public static final String TRAVELLER_VIDEO_ID = "video_id";
  public static final String TRAVELLER_VIDEO_LIST = "videos";
  public static final String TRAVELLER_VIDEO_MD5 = "md5";
  public static final String TRAVELLER_VIDEO_PLACE = "name";
  public static final String TRAVELLER_VIDEO_URL = "url";
  public int category;
  public String item_id;
  public String md5;
  public String name;
  public String path;
  public int type = 100;
  public String url = "";
  public int video_id = -1;
  
  public ShortVideoTravellerManager$TravellerVideoItem() {}
  
  public ShortVideoTravellerManager$TravellerVideoItem(Parcel paramParcel)
  {
    this.video_id = paramParcel.readInt();
    this.url = paramParcel.readString();
    this.md5 = paramParcel.readString();
    this.name = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.category = paramParcel.readInt();
    this.item_id = paramParcel.readString();
    this.path = paramParcel.readString();
  }
  
  public ShortVideoTravellerManager$TravellerVideoItem(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("video_id")) {
      this.video_id = paramJSONObject.optInt("video_id", -1);
    }
    if (paramJSONObject.has("url")) {
      this.url = paramJSONObject.optString("url", "");
    }
    if (paramJSONObject.has("md5")) {
      this.md5 = paramJSONObject.optString("md5", "");
    }
    if (paramJSONObject.has("name")) {
      this.name = paramJSONObject.optString("name", "");
    }
    if (paramJSONObject.has("type")) {
      this.type = paramJSONObject.optInt("type", -1);
    }
    if (paramJSONObject.has("category")) {
      this.category = paramJSONObject.optInt("category", -1);
    }
    if (paramJSONObject.has("item_id")) {
      this.item_id = paramJSONObject.optString("item_id", "");
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TravellerVideoItem{");
    localStringBuilder.append("video_id=").append(this.video_id);
    localStringBuilder.append(", url='").append(this.url).append('\'');
    localStringBuilder.append(", md5='").append(this.md5).append('\'');
    localStringBuilder.append(", name='").append(this.name).append('\'');
    localStringBuilder.append(", type=").append(this.type);
    localStringBuilder.append(", category=").append(this.category);
    localStringBuilder.append(", item_id='").append(this.item_id).append('\'');
    localStringBuilder.append(", path='").append(this.path).append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.video_id);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.md5);
    paramParcel.writeString(this.name);
    paramParcel.writeInt(this.type);
    paramParcel.writeInt(this.category);
    paramParcel.writeString(this.item_id);
    paramParcel.writeString(this.path);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.videoconverter.ShortVideoTravellerManager.TravellerVideoItem
 * JD-Core Version:    0.7.0.1
 */