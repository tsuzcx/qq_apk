package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Map;

public class PhotoParam
  implements Parcelable
{
  public static final int APP_ID = 4;
  public static final Parcelable.Creator<PhotoParam> CREATOR = new PhotoParam.1();
  public int albumPriv;
  public int albumType;
  public String albumanswer;
  public String albumid;
  public int albumnum;
  public int appid = 4;
  public Map<Integer, String> busi_param = new HashMap();
  public int businessPhotoFeedIndex;
  public boolean canAddFavor = true;
  public String cell_id = "";
  public String cell_subId = "";
  public int commentNum;
  public String curKey = "";
  public String feedId = "";
  public long feedUin;
  public int getPhotoExType = 0;
  public boolean isFriendPhotoBizFeed;
  public boolean isLike;
  public boolean isOnePictureFeed;
  public boolean isOnlyPreView;
  public boolean isShareAlbum;
  public boolean isSharedFeeds;
  public boolean isTihFeed;
  public boolean isVideoPicMix;
  public int likeNum;
  public String loginNickName = "";
  public long loginUin;
  public boolean mFromRecent;
  public String oneFeedPictruePath = "";
  public String orgKey = "";
  public long ownerUin;
  public String qunid;
  public long qzoneUserType;
  public long realOwnerUin;
  public long sharer;
  public int sortType;
  public int subid = -1;
  public String ugcKey = "";
  public int uploadnum;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("PhotoParam{");
    localStringBuffer.append("loginUin=").append(this.loginUin);
    localStringBuffer.append(", feedUin=").append(this.feedUin);
    localStringBuffer.append(", ownerUin=").append(this.ownerUin);
    localStringBuffer.append(", realOwnerUin=").append(this.realOwnerUin);
    localStringBuffer.append(", albumanswer='").append(this.albumanswer).append('\'');
    localStringBuffer.append(", albumid='").append(this.albumid).append('\'');
    localStringBuffer.append(", sortType=").append(this.sortType);
    localStringBuffer.append(", albumPriv=").append(this.albumPriv);
    localStringBuffer.append(", albumnum=").append(this.albumnum);
    localStringBuffer.append(", uploadnum=").append(this.uploadnum);
    localStringBuffer.append(", albumType=").append(this.albumType);
    localStringBuffer.append(", businessPhotoFeedIndex=").append(this.businessPhotoFeedIndex);
    localStringBuffer.append(", qunid='").append(this.qunid).append('\'');
    localStringBuffer.append(", isLike=").append(this.isLike);
    localStringBuffer.append(", likeNum=").append(this.likeNum);
    localStringBuffer.append(", commentNum=").append(this.commentNum);
    localStringBuffer.append(", curKey='").append(this.curKey).append('\'');
    localStringBuffer.append(", orgKey='").append(this.orgKey).append('\'');
    localStringBuffer.append(", feedId='").append(this.feedId).append('\'');
    localStringBuffer.append(", cell_id='").append(this.cell_id).append('\'');
    localStringBuffer.append(", cell_subId='").append(this.cell_subId).append('\'');
    localStringBuffer.append(", appid=").append(this.appid);
    localStringBuffer.append(", ugcKey='").append(this.ugcKey).append('\'');
    localStringBuffer.append(", canAddFavor=").append(this.canAddFavor);
    localStringBuffer.append(", subid=").append(this.subid);
    localStringBuffer.append(", isOnePictureFeed=").append(this.isOnePictureFeed);
    localStringBuffer.append(", oneFeedPictruePath='").append(this.oneFeedPictruePath).append('\'');
    localStringBuffer.append(", mFromRecent=").append(this.mFromRecent);
    localStringBuffer.append(", busi_param=").append(this.busi_param);
    localStringBuffer.append(", isTihFeed=").append(this.isTihFeed);
    localStringBuffer.append(", isOnlyPreView=").append(this.isOnlyPreView);
    localStringBuffer.append(", isFriendPhotoBizFeed=").append(this.isFriendPhotoBizFeed);
    localStringBuffer.append(", isShareAlbum=").append(this.isShareAlbum);
    localStringBuffer.append(", isVideoPicMix=").append(this.isVideoPicMix);
    localStringBuffer.append(", getPhotoExType=").append(this.getPhotoExType);
    localStringBuffer.append(", sharer=").append(this.sharer);
    localStringBuffer.append(", loginNickName='").append(this.loginNickName).append('\'');
    localStringBuffer.append(", qzoneUserType=").append(this.qzoneUserType);
    localStringBuffer.append(", isSharedFeeds=").append(this.isSharedFeeds);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeLong(this.loginUin);
    paramParcel.writeLong(this.feedUin);
    paramParcel.writeLong(this.ownerUin);
    paramParcel.writeLong(this.realOwnerUin);
    paramParcel.writeString(this.albumanswer);
    paramParcel.writeString(this.albumid);
    paramParcel.writeInt(this.sortType);
    paramParcel.writeInt(this.albumPriv);
    paramParcel.writeInt(this.albumnum);
    paramParcel.writeInt(this.uploadnum);
    paramParcel.writeInt(this.albumType);
    paramParcel.writeInt(this.businessPhotoFeedIndex);
    paramParcel.writeString(this.qunid);
    if (this.isLike)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.likeNum);
      paramParcel.writeInt(this.commentNum);
      paramParcel.writeString(this.curKey);
      paramParcel.writeString(this.orgKey);
      paramParcel.writeString(this.feedId);
      paramParcel.writeString(this.cell_id);
      paramParcel.writeString(this.cell_subId);
      paramParcel.writeInt(this.appid);
      paramParcel.writeMap(this.busi_param);
      paramParcel.writeString(this.ugcKey);
      if (!this.canAddFavor) {
        break label380;
      }
      paramInt = 1;
      label209:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.subid);
      if (!this.isOnePictureFeed) {
        break label385;
      }
      paramInt = 1;
      label231:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.oneFeedPictruePath);
      if (!this.mFromRecent) {
        break label390;
      }
      paramInt = 1;
      label253:
      paramParcel.writeInt(paramInt);
      if (!this.isTihFeed) {
        break label395;
      }
      paramInt = 1;
      label267:
      paramParcel.writeInt(paramInt);
      if (!this.isOnlyPreView) {
        break label400;
      }
      paramInt = 1;
      label281:
      paramParcel.writeInt(paramInt);
      if (!this.isFriendPhotoBizFeed) {
        break label405;
      }
      paramInt = 1;
      label295:
      paramParcel.writeInt(paramInt);
      if (!this.isShareAlbum) {
        break label410;
      }
      paramInt = 1;
      label309:
      paramParcel.writeInt(paramInt);
      if (!this.isVideoPicMix) {
        break label415;
      }
      paramInt = 1;
      label323:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.getPhotoExType);
      paramParcel.writeLong(this.sharer);
      paramParcel.writeString(this.loginNickName);
      paramParcel.writeLong(this.qzoneUserType);
      if (!this.isSharedFeeds) {
        break label420;
      }
    }
    label385:
    label390:
    label395:
    label400:
    label405:
    label410:
    label415:
    label420:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
      label380:
      paramInt = 0;
      break label209;
      paramInt = 0;
      break label231;
      paramInt = 0;
      break label253;
      paramInt = 0;
      break label267;
      paramInt = 0;
      break label281;
      paramInt = 0;
      break label295;
      paramInt = 0;
      break label309;
      paramInt = 0;
      break label323;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.PhotoParam
 * JD-Core Version:    0.7.0.1
 */