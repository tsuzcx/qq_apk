package cooperation.qzone.model;

import NS_MOBILE_FEEDS.stPhotoTag;
import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;

public class ImageTagInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ImageTagInfo> CREATOR = new ImageTagInfo.1();
  private static String sDbKey;
  public int appId;
  public String content;
  public int direction = 2;
  public int patternId;
  public String poiTagStreet;
  public String resTraceInfo;
  public int resourceId;
  public String tagId = "";
  public int type = 0;
  public int xScale;
  public int yScale;
  
  public ImageTagInfo() {}
  
  public ImageTagInfo(stPhotoTag paramstPhotoTag)
  {
    if (paramstPhotoTag != null)
    {
      this.type = paramstPhotoTag.type;
      this.content = paramstPhotoTag.content;
      this.tagId = paramstPhotoTag.tag_id;
      this.xScale = ((int)paramstPhotoTag.x_scale);
      this.yScale = ((int)paramstPhotoTag.y_scale);
      this.direction = paramstPhotoTag.direction;
      this.poiTagStreet = paramstPhotoTag.poiTagStreet;
    }
  }
  
  private ImageTagInfo(Parcel paramParcel)
  {
    this.type = paramParcel.readInt();
    this.content = paramParcel.readString();
    this.tagId = paramParcel.readString();
    this.appId = paramParcel.readInt();
    this.resourceId = paramParcel.readInt();
    this.patternId = paramParcel.readInt();
    this.xScale = paramParcel.readInt();
    this.yScale = paramParcel.readInt();
    this.direction = paramParcel.readInt();
    this.poiTagStreet = paramParcel.readString();
    this.resTraceInfo = paramParcel.readString();
  }
  
  public static ArrayList<stPhotoTag> ImageTagInfoConvertTostPhotoTag(ArrayList<ImageTagInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        ImageTagInfo localImageTagInfo = (ImageTagInfo)paramArrayList.next();
        if (localImageTagInfo != null) {
          localArrayList.add(new stPhotoTag(localImageTagInfo.type, localImageTagInfo.content, localImageTagInfo.tagId, localImageTagInfo.xScale, localImageTagInfo.yScale, localImageTagInfo.direction, localImageTagInfo.poiTagStreet));
        }
      }
    }
    return localArrayList;
  }
  
  public static String getDbKey()
  {
    return sDbKey;
  }
  
  public static void setDbKey(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    sDbKey = paramString;
  }
  
  public static ArrayList<ImageTagInfo> stPhotoTagConvertToImageTagInfo(ArrayList<stPhotoTag> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localArrayList.add(new ImageTagInfo((stPhotoTag)paramArrayList.next()));
      }
    }
    return localArrayList;
  }
  
  public ImageTagInfo clone()
  {
    ImageTagInfo localImageTagInfo = new ImageTagInfo();
    localImageTagInfo.type = this.type;
    localImageTagInfo.content = this.content;
    localImageTagInfo.tagId = this.tagId;
    localImageTagInfo.appId = this.appId;
    localImageTagInfo.resourceId = this.resourceId;
    localImageTagInfo.patternId = this.patternId;
    localImageTagInfo.xScale = this.xScale;
    localImageTagInfo.yScale = this.yScale;
    localImageTagInfo.direction = this.direction;
    localImageTagInfo.poiTagStreet = this.poiTagStreet;
    localImageTagInfo.resTraceInfo = this.resTraceInfo;
    return localImageTagInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeTo(ContentValues paramContentValues)
  {
    Parcel localParcel = Parcel.obtain();
    writeToParcel(localParcel, 0);
    byte[] arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    paramContentValues.put("key", sDbKey);
    paramContentValues.put("data", arrayOfByte);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.content);
    paramParcel.writeString(this.tagId);
    paramParcel.writeInt(this.appId);
    paramParcel.writeInt(this.resourceId);
    paramParcel.writeInt(this.patternId);
    paramParcel.writeInt(this.xScale);
    paramParcel.writeInt(this.yScale);
    paramParcel.writeInt(this.direction);
    paramParcel.writeString(this.poiTagStreet);
    paramParcel.writeString(this.resTraceInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.model.ImageTagInfo
 * JD-Core Version:    0.7.0.1
 */