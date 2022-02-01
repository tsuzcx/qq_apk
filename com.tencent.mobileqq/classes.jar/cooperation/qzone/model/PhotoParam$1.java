package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PhotoParam$1
  implements Parcelable.Creator<PhotoParam>
{
  public PhotoParam createFromParcel(Parcel paramParcel)
  {
    PhotoParam localPhotoParam = new PhotoParam();
    localPhotoParam.loginUin = paramParcel.readLong();
    localPhotoParam.feedUin = paramParcel.readLong();
    localPhotoParam.ownerUin = paramParcel.readLong();
    localPhotoParam.realOwnerUin = paramParcel.readLong();
    localPhotoParam.albumanswer = paramParcel.readString();
    localPhotoParam.albumid = paramParcel.readString();
    localPhotoParam.sortType = paramParcel.readInt();
    localPhotoParam.albumPriv = paramParcel.readInt();
    localPhotoParam.albumnum = paramParcel.readInt();
    localPhotoParam.uploadnum = paramParcel.readInt();
    localPhotoParam.albumType = paramParcel.readInt();
    localPhotoParam.businessPhotoFeedIndex = paramParcel.readInt();
    localPhotoParam.qunid = paramParcel.readString();
    int i = paramParcel.readInt();
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localPhotoParam.isLike = bool1;
    localPhotoParam.likeNum = paramParcel.readInt();
    localPhotoParam.commentNum = paramParcel.readInt();
    localPhotoParam.curKey = paramParcel.readString();
    localPhotoParam.orgKey = paramParcel.readString();
    localPhotoParam.feedId = paramParcel.readString();
    localPhotoParam.cell_id = paramParcel.readString();
    localPhotoParam.cell_subId = paramParcel.readString();
    localPhotoParam.appid = paramParcel.readInt();
    localPhotoParam.busi_param = paramParcel.readHashMap(getClass().getClassLoader());
    localPhotoParam.ugcKey = paramParcel.readString();
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localPhotoParam.canAddFavor = bool1;
    localPhotoParam.subid = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localPhotoParam.isOnePictureFeed = bool1;
    localPhotoParam.oneFeedPictruePath = paramParcel.readString();
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localPhotoParam.mFromRecent = bool1;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localPhotoParam.isTihFeed = bool1;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localPhotoParam.isOnlyPreView = bool1;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localPhotoParam.isFriendPhotoBizFeed = bool1;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localPhotoParam.isShareAlbum = bool1;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localPhotoParam.isVideoPicMix = bool1;
    localPhotoParam.getPhotoExType = paramParcel.readInt();
    localPhotoParam.sharer = paramParcel.readLong();
    localPhotoParam.loginNickName = paramParcel.readString();
    localPhotoParam.qzoneUserType = paramParcel.readLong();
    boolean bool1 = bool2;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    }
    localPhotoParam.isSharedFeeds = bool1;
    return localPhotoParam;
  }
  
  public PhotoParam[] newArray(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.model.PhotoParam.1
 * JD-Core Version:    0.7.0.1
 */