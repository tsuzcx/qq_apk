package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bhft;

public class WeishiFeedInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WeishiFeedInfo> CREATOR = new bhft();
  public static final int FROM_TYPE_ALBUM_VIDEO = 1;
  public static final int FROM_TYPE_DEFAULT = 0;
  public static final int FROM_TYPE_WEISHI_VIDEO = 2;
  public WeishiBasicInfo basicInfo;
  public WeishiBottomButton bottomButton;
  public WeishiFeedCommInfo feedCommInfo;
  public WeishiInterestInfo interestInfo;
  public KingCardInfo kingCardInfo;
  public boolean mIsFrdLikeMiniAppVideo;
  public int mIsFrom = 0;
  public WeishiOperationInfo operationInfo;
  public WeishiShareDataInfo shareDataInfo;
  public WeishiUserInfo userInfo;
  public VideoInfo videoInfo;
  
  public WeishiFeedInfo() {}
  
  public WeishiFeedInfo(Parcel paramParcel)
  {
    this.userInfo = ((WeishiUserInfo)paramParcel.readParcelable(WeishiUserInfo.class.getClassLoader()));
    this.videoInfo = ((VideoInfo)paramParcel.readParcelable(VideoInfo.class.getClassLoader()));
    this.basicInfo = ((WeishiBasicInfo)paramParcel.readParcelable(WeishiBasicInfo.class.getClassLoader()));
    this.feedCommInfo = ((WeishiFeedCommInfo)paramParcel.readParcelable(WeishiFeedCommInfo.class.getClassLoader()));
    this.operationInfo = ((WeishiOperationInfo)paramParcel.readParcelable(WeishiOperationInfo.class.getClassLoader()));
    this.bottomButton = ((WeishiBottomButton)paramParcel.readParcelable(WeishiBottomButton.class.getClassLoader()));
    this.shareDataInfo = ((WeishiShareDataInfo)paramParcel.readParcelable(WeishiShareDataInfo.class.getClassLoader()));
    this.kingCardInfo = ((KingCardInfo)paramParcel.readParcelable(KingCardInfo.class.getClassLoader()));
    this.interestInfo = ((WeishiInterestInfo)paramParcel.readParcelable(WeishiInterestInfo.class.getClassLoader()));
    this.mIsFrom = paramParcel.readInt();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mIsFrdLikeMiniAppVideo = bool;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.userInfo, paramInt);
    paramParcel.writeParcelable(this.videoInfo, paramInt);
    paramParcel.writeParcelable(this.basicInfo, paramInt);
    paramParcel.writeParcelable(this.feedCommInfo, paramInt);
    paramParcel.writeParcelable(this.operationInfo, paramInt);
    paramParcel.writeParcelable(this.bottomButton, paramInt);
    paramParcel.writeParcelable(this.shareDataInfo, paramInt);
    paramParcel.writeParcelable(this.kingCardInfo, paramInt);
    paramParcel.writeParcelable(this.interestInfo, paramInt);
    paramParcel.writeInt(this.mIsFrom);
    if (this.mIsFrdLikeMiniAppVideo) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.model.WeishiFeedInfo
 * JD-Core Version:    0.7.0.1
 */