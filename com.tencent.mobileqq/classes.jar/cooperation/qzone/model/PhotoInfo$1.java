package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

final class PhotoInfo$1
  implements Parcelable.Creator<PhotoInfo>
{
  public PhotoInfo createFromParcel(Parcel paramParcel)
  {
    boolean bool2 = true;
    PhotoInfo localPhotoInfo = new PhotoInfo();
    localPhotoInfo.albumId = paramParcel.readString();
    localPhotoInfo.albumPriv = paramParcel.readInt();
    localPhotoInfo.currentUrl = paramParcel.readString();
    localPhotoInfo.bigUrl = paramParcel.readString();
    localPhotoInfo.orgUrl = paramParcel.readString();
    localPhotoInfo.desc = paramParcel.readString();
    localPhotoInfo.praiseCount = paramParcel.readInt();
    localPhotoInfo.commentCount = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
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
      if (paramParcel.readInt() != 1) {
        break label697;
      }
      bool1 = true;
      label232:
      localPhotoInfo.isSelected = bool1;
      localPhotoInfo.ctime = paramParcel.readLong();
      localPhotoInfo.date = paramParcel.readLong();
      localPhotoInfo.tagList = new ArrayList();
      paramParcel.readTypedList(localPhotoInfo.tagList, ImageTagInfo.CREATOR);
      if (paramParcel.readInt() != 1) {
        break label702;
      }
      bool1 = true;
      label290:
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
      if (paramParcel.readInt() != 1) {
        break label707;
      }
      bool1 = true;
      label492:
      localPhotoInfo.pssHasFeedPraise = bool1;
      localPhotoInfo.shareWeixinUrl = paramParcel.readString();
      localPhotoInfo.shareQqUrl = paramParcel.readString();
      localPhotoInfo.shareTitle = paramParcel.readString();
      localPhotoInfo.shareSummary = paramParcel.readString();
      localPhotoInfo.sharePhotoUrl = paramParcel.readString();
      localPhotoInfo.shareSpaceRight = paramParcel.readInt();
      localPhotoInfo.shareAlbumRight = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label712;
      }
      bool1 = true;
      label571:
      localPhotoInfo.hasCheckFace = bool1;
      localPhotoInfo.mFaceList = ((ArrayList)paramParcel.readSerializable());
      if (paramParcel.readInt() != 1) {
        break label717;
      }
      bool1 = true;
      label599:
      localPhotoInfo.needShowFaceIcon = bool1;
      localPhotoInfo.originSize = paramParcel.readLong();
      if (paramParcel.readInt() != 1) {
        break label722;
      }
      bool1 = true;
      label624:
      localPhotoInfo.appAdShow = bool1;
      localPhotoInfo.appAdText = paramParcel.readString();
      localPhotoInfo.appAdSchema = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label727;
      }
    }
    label697:
    label702:
    label707:
    label712:
    label717:
    label722:
    label727:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPhotoInfo.picInfoOpen = bool1;
      localPhotoInfo.picTaginfoList = paramParcel.readArrayList(getClass().getClassLoader());
      localPhotoInfo.heightWeightProportion = paramParcel.readFloat();
      return localPhotoInfo;
      bool1 = false;
      break;
      bool1 = false;
      break label232;
      bool1 = false;
      break label290;
      bool1 = false;
      break label492;
      bool1 = false;
      break label571;
      bool1 = false;
      break label599;
      bool1 = false;
      break label624;
    }
  }
  
  public PhotoInfo[] newArray(int paramInt)
  {
    return new PhotoInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.model.PhotoInfo.1
 * JD-Core Version:    0.7.0.1
 */