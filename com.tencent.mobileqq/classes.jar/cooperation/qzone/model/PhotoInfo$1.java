package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

final class PhotoInfo$1
  implements Parcelable.Creator<PhotoInfo>
{
  public PhotoInfo createFromParcel(Parcel paramParcel)
  {
    PhotoInfo localPhotoInfo = new PhotoInfo();
    localPhotoInfo.albumId = paramParcel.readString();
    localPhotoInfo.albumPriv = paramParcel.readInt();
    localPhotoInfo.currentUrl = paramParcel.readString();
    localPhotoInfo.bigUrl = paramParcel.readString();
    localPhotoInfo.orgUrl = paramParcel.readString();
    localPhotoInfo.desc = paramParcel.readString();
    localPhotoInfo.praiseCount = paramParcel.readInt();
    localPhotoInfo.commentCount = paramParcel.readInt();
    int i = paramParcel.readInt();
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localPhotoInfo.hasPraise = bool1;
    localPhotoInfo.unikey = paramParcel.readString();
    localPhotoInfo.curkey = paramParcel.readString();
    localPhotoInfo.lloc = paramParcel.readString();
    localPhotoInfo.sloc = paramParcel.readString();
    localPhotoInfo.busi_param = paramParcel.readHashMap(getClass().getClassLoader());
    localPhotoInfo.mNeedEncodeGifPics = paramParcel.readArrayList(getClass().getClassLoader());
    localPhotoInfo.mNeedEncodeGifDelay = paramParcel.readInt();
    localPhotoInfo.photoType = paramParcel.readInt();
    localPhotoInfo.opsynflag = paramParcel.readInt();
    localPhotoInfo.isIndependentUgc = paramParcel.readInt();
    localPhotoInfo.gpsInfo = ((GpsInfo4LocalImage)paramParcel.readParcelable(getClass().getClassLoader()));
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localPhotoInfo.isSelected = bool1;
    localPhotoInfo.ctime = paramParcel.readLong();
    localPhotoInfo.date = paramParcel.readLong();
    localPhotoInfo.tagList = new ArrayList();
    paramParcel.readTypedList(localPhotoInfo.tagList, ImageTagInfo.CREATOR);
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localPhotoInfo.isFakeFeed = bool1;
    localPhotoInfo.showGifState = paramParcel.readInt();
    localPhotoInfo.flag = paramParcel.readInt();
    localPhotoInfo.opMask = paramParcel.readInt();
    localPhotoInfo.allow_share = paramParcel.readInt();
    localPhotoInfo.videoflag = paramParcel.readInt();
    localPhotoInfo.videodata = ((VideoInfo)paramParcel.readParcelable(VideoInfo.class.getClassLoader()));
    localPhotoInfo.albumName = paramParcel.readString();
    localPhotoInfo.uploadtime = paramParcel.readInt();
    localPhotoInfo.photoOpmask = paramParcel.readInt();
    localPhotoInfo.uploadOwner = paramParcel.readString();
    localPhotoInfo.uploaduin = paramParcel.readLong();
    localPhotoInfo.appid = paramParcel.readInt();
    localPhotoInfo.pssCellId = paramParcel.readString();
    localPhotoInfo.pssCellSubId = paramParcel.readString();
    localPhotoInfo.pssUgcKey = paramParcel.readString();
    localPhotoInfo.pssSubId = paramParcel.readInt();
    localPhotoInfo.pssCurLikeKey = paramParcel.readString();
    localPhotoInfo.pssOrgLikeKey = paramParcel.readString();
    localPhotoInfo.pssBusiParam = paramParcel.readHashMap(getClass().getClassLoader());
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localPhotoInfo.pssHasFeedPraise = bool1;
    localPhotoInfo.shareWeixinUrl = paramParcel.readString();
    localPhotoInfo.shareQqUrl = paramParcel.readString();
    localPhotoInfo.shareTitle = paramParcel.readString();
    localPhotoInfo.shareSummary = paramParcel.readString();
    localPhotoInfo.sharePhotoUrl = paramParcel.readString();
    localPhotoInfo.shareSpaceRight = paramParcel.readInt();
    localPhotoInfo.shareAlbumRight = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localPhotoInfo.hasCheckFace = bool1;
    localPhotoInfo.mFaceList = ((ArrayList)paramParcel.readSerializable());
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localPhotoInfo.needShowFaceIcon = bool1;
    localPhotoInfo.originSize = paramParcel.readLong();
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localPhotoInfo.appAdShow = bool1;
    localPhotoInfo.appAdText = paramParcel.readString();
    localPhotoInfo.appAdSchema = paramParcel.readString();
    boolean bool1 = bool2;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    }
    localPhotoInfo.picInfoOpen = bool1;
    localPhotoInfo.picTaginfoList = paramParcel.readArrayList(getClass().getClassLoader());
    localPhotoInfo.heightWeightProportion = paramParcel.readFloat();
    return localPhotoInfo;
  }
  
  public PhotoInfo[] newArray(int paramInt)
  {
    return new PhotoInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.PhotoInfo.1
 * JD-Core Version:    0.7.0.1
 */