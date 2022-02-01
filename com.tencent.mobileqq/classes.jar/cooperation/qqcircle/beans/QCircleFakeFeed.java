package cooperation.qqcircle.beans;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import cooperation.qzone.LbsDataV2.PoiInfo;
import cooperation.qzone.model.LabelInfo;
import java.util.ArrayList;

public class QCircleFakeFeed
  implements Parcelable
{
  public static final String BUNDLE_KEY = "KEY_Q_CIRCLE_FAKE_FEED";
  public static final String BUNDLE_KEY_LIST = "KEY_CERTIFIED_FAKE_FEED_LIST";
  public static final Parcelable.Creator<QCircleFakeFeed> CREATOR = new QCircleFakeFeed.1();
  private String clientKey = "";
  private String content = "";
  private String coverPath = "";
  private long createTime;
  private int duration;
  private String feedId = "";
  private int feedType;
  private ArrayList<String> filterId;
  private int height;
  private ArrayList<String> imgLists;
  private ArrayList<Float> kuolieCentreX;
  private ArrayList<Float> kuolieCentreY;
  private ArrayList<Float> kuolieHeightScale;
  private ArrayList<String> kuolieId;
  private ArrayList<Float> kuolieRotate;
  private ArrayList<Float> kuolieWidthScale;
  private ArrayList<LabelInfo> labelInfos;
  private ArrayList<String> materialId;
  private String nickename = "";
  private LbsDataV2.PoiInfo poiInfo;
  private String puin = "";
  private ArrayList<Integer> showCircleTakeSame;
  private ArrayList<String> simulateName;
  private ArrayList<String> simulateSchema;
  private String title = "";
  private String videoPath = "";
  private int width;
  
  public QCircleFakeFeed() {}
  
  protected QCircleFakeFeed(Parcel paramParcel)
  {
    this.feedId = paramParcel.readString();
    this.clientKey = paramParcel.readString();
    this.feedType = paramParcel.readInt();
    this.title = paramParcel.readString();
    this.content = paramParcel.readString();
    this.imgLists = paramParcel.createStringArrayList();
    this.coverPath = paramParcel.readString();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.duration = paramParcel.readInt();
    this.createTime = paramParcel.readLong();
    this.puin = paramParcel.readString();
    this.nickename = paramParcel.readString();
    this.videoPath = paramParcel.readString();
    this.labelInfos = ((ArrayList)paramParcel.readSerializable());
    this.poiInfo = ((LbsDataV2.PoiInfo)paramParcel.readParcelable(LbsDataV2.PoiInfo.class.getClassLoader()));
    this.materialId = ((ArrayList)paramParcel.readSerializable());
    this.filterId = ((ArrayList)paramParcel.readSerializable());
    this.simulateName = ((ArrayList)paramParcel.readSerializable());
    this.simulateSchema = ((ArrayList)paramParcel.readSerializable());
    this.kuolieId = ((ArrayList)paramParcel.readSerializable());
    this.kuolieCentreX = ((ArrayList)paramParcel.readSerializable());
    this.kuolieCentreY = ((ArrayList)paramParcel.readSerializable());
    this.kuolieWidthScale = ((ArrayList)paramParcel.readSerializable());
    this.kuolieHeightScale = ((ArrayList)paramParcel.readSerializable());
    this.kuolieRotate = ((ArrayList)paramParcel.readSerializable());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getClientKey()
  {
    return this.clientKey;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getCoverPath()
  {
    return this.coverPath;
  }
  
  public long getCreateTime()
  {
    return this.createTime;
  }
  
  public int getDuration()
  {
    return this.duration;
  }
  
  public String getFeedId()
  {
    return this.feedId;
  }
  
  public int getFeedType()
  {
    return this.feedType;
  }
  
  public ArrayList<String> getFilterId()
  {
    return this.filterId;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public ArrayList<String> getImgLists()
  {
    return this.imgLists;
  }
  
  public ArrayList<Float> getKuolieCentreX()
  {
    return this.kuolieCentreX;
  }
  
  public ArrayList<Float> getKuolieCentreY()
  {
    return this.kuolieCentreY;
  }
  
  public ArrayList<Float> getKuolieHeightScale()
  {
    return this.kuolieHeightScale;
  }
  
  public ArrayList<String> getKuolieId()
  {
    return this.kuolieId;
  }
  
  public ArrayList<Float> getKuolieRotate()
  {
    return this.kuolieRotate;
  }
  
  public ArrayList<Float> getKuolieWidthScale()
  {
    return this.kuolieWidthScale;
  }
  
  public ArrayList<LabelInfo> getLabelInfos()
  {
    return this.labelInfos;
  }
  
  public ArrayList<String> getMaterialId()
  {
    return this.materialId;
  }
  
  public String getNickename()
  {
    return this.nickename;
  }
  
  public LbsDataV2.PoiInfo getPoiInfo()
  {
    return this.poiInfo;
  }
  
  public String getPuin()
  {
    return this.puin;
  }
  
  public ArrayList<Integer> getShowCircleTakeSame()
  {
    return this.showCircleTakeSame;
  }
  
  public ArrayList<String> getSimulateName()
  {
    return this.simulateName;
  }
  
  public ArrayList<String> getSimulateSchema()
  {
    return this.simulateSchema;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getVideoPath()
  {
    return this.videoPath;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void setClientKey(String paramString)
  {
    this.clientKey = paramString;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setCoverPath(String paramString)
  {
    this.coverPath = paramString;
  }
  
  public void setCreateTime(long paramLong)
  {
    this.createTime = paramLong;
  }
  
  public void setDuration(int paramInt)
  {
    this.duration = paramInt;
  }
  
  public void setFeedId(String paramString)
  {
    this.feedId = paramString;
  }
  
  public void setFeedType(int paramInt)
  {
    this.feedType = paramInt;
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setImgLists(ArrayList<String> paramArrayList)
  {
    this.imgLists = paramArrayList;
  }
  
  public QCircleFakeFeed setKuolieCentreX(ArrayList<Float> paramArrayList)
  {
    this.kuolieCentreX = paramArrayList;
    return this;
  }
  
  public QCircleFakeFeed setKuolieCentreY(ArrayList<Float> paramArrayList)
  {
    this.kuolieCentreY = paramArrayList;
    return this;
  }
  
  public QCircleFakeFeed setKuolieHeightScale(ArrayList<Float> paramArrayList)
  {
    this.kuolieHeightScale = paramArrayList;
    return this;
  }
  
  public QCircleFakeFeed setKuolieId(ArrayList<String> paramArrayList)
  {
    this.kuolieId = paramArrayList;
    return this;
  }
  
  public QCircleFakeFeed setKuolieRotate(ArrayList<Float> paramArrayList)
  {
    this.kuolieRotate = paramArrayList;
    return this;
  }
  
  public QCircleFakeFeed setKuolieWidthScale(ArrayList<Float> paramArrayList)
  {
    this.kuolieWidthScale = paramArrayList;
    return this;
  }
  
  public void setLabelInfos(ArrayList<LabelInfo> paramArrayList)
  {
    this.labelInfos = paramArrayList;
  }
  
  public void setNickename(String paramString)
  {
    this.nickename = paramString;
  }
  
  public void setPoiInfo(LbsDataV2.PoiInfo paramPoiInfo)
  {
    this.poiInfo = paramPoiInfo;
  }
  
  public void setPuin(String paramString)
  {
    this.puin = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setVideoPath(String paramString)
  {
    this.videoPath = paramString;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.feedId);
    paramParcel.writeString(this.clientKey);
    paramParcel.writeInt(this.feedType);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.content);
    paramParcel.writeStringList(this.imgLists);
    paramParcel.writeString(this.coverPath);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeInt(this.duration);
    paramParcel.writeLong(this.createTime);
    paramParcel.writeString(this.puin);
    paramParcel.writeString(this.nickename);
    paramParcel.writeString(this.videoPath);
    paramParcel.writeSerializable(this.labelInfos);
    paramParcel.writeParcelable(this.poiInfo, 0);
    paramParcel.writeSerializable(this.materialId);
    paramParcel.writeSerializable(this.filterId);
    paramParcel.writeSerializable(this.simulateName);
    paramParcel.writeSerializable(this.simulateSchema);
    paramParcel.writeSerializable(this.kuolieId);
    paramParcel.writeSerializable(this.kuolieCentreX);
    paramParcel.writeSerializable(this.kuolieCentreY);
    paramParcel.writeSerializable(this.kuolieWidthScale);
    paramParcel.writeSerializable(this.kuolieHeightScale);
    paramParcel.writeSerializable(this.kuolieRotate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.beans.QCircleFakeFeed
 * JD-Core Version:    0.7.0.1
 */