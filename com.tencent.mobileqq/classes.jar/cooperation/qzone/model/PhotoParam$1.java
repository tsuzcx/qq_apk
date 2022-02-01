package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PhotoParam$1
  implements Parcelable.Creator<PhotoParam>
{
  public PhotoParam createFromParcel(Parcel paramParcel)
  {
    boolean bool2 = true;
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
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
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
      if (paramParcel.readInt() != 1) {
        break label447;
      }
      bool1 = true;
      label251:
      localPhotoParam.canAddFavor = bool1;
      localPhotoParam.subid = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label452;
      }
      bool1 = true;
      label276:
      localPhotoParam.isOnePictureFeed = bool1;
      localPhotoParam.oneFeedPictruePath = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label457;
      }
      bool1 = true;
      label301:
      localPhotoParam.mFromRecent = bool1;
      if (paramParcel.readInt() != 1) {
        break label462;
      }
      bool1 = true;
      label317:
      localPhotoParam.isTihFeed = bool1;
      if (paramParcel.readInt() != 1) {
        break label467;
      }
      bool1 = true;
      label333:
      localPhotoParam.isOnlyPreView = bool1;
      if (paramParcel.readInt() != 1) {
        break label472;
      }
      bool1 = true;
      label349:
      localPhotoParam.isFriendPhotoBizFeed = bool1;
      if (paramParcel.readInt() != 1) {
        break label477;
      }
      bool1 = true;
      label365:
      localPhotoParam.isShareAlbum = bool1;
      if (paramParcel.readInt() != 1) {
        break label482;
      }
      bool1 = true;
      label381:
      localPhotoParam.isVideoPicMix = bool1;
      localPhotoParam.getPhotoExType = paramParcel.readInt();
      localPhotoParam.sharer = paramParcel.readLong();
      localPhotoParam.loginNickName = paramParcel.readString();
      localPhotoParam.qzoneUserType = paramParcel.readLong();
      if (paramParcel.readInt() != 1) {
        break label487;
      }
    }
    label447:
    label452:
    label457:
    label462:
    label467:
    label472:
    label477:
    label482:
    label487:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPhotoParam.isSharedFeeds = bool1;
      return localPhotoParam;
      bool1 = false;
      break;
      bool1 = false;
      break label251;
      bool1 = false;
      break label276;
      bool1 = false;
      break label301;
      bool1 = false;
      break label317;
      bool1 = false;
      break label333;
      bool1 = false;
      break label349;
      bool1 = false;
      break label365;
      bool1 = false;
      break label381;
    }
  }
  
  public PhotoParam[] newArray(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.PhotoParam.1
 * JD-Core Version:    0.7.0.1
 */