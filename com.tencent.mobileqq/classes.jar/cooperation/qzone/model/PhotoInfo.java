package cooperation.qzone.model;

import NS_FASHION_FEEDS_TAG_PROTO.TagInfo;
import aawa;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import cooperation.qzone.util.PanoramaUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;

public class PhotoInfo
  extends aawa
  implements Parcelable
{
  public static final Parcelable.Creator<PhotoInfo> CREATOR = new PhotoInfo.1();
  public static final int IMAGE_RESOLUTION_BIG = 1;
  public static final int IMAGE_RESOLUTION_ORIGINAL = 2;
  public static int SHOW_GIF;
  public static int SHOW_NEITHER_GIF_NOR_PLAY = 1;
  public static int SHOW_STATIC_PHOTO;
  public String albumId = "";
  public String albumName;
  public int albumPriv;
  public int allow_share;
  public String appAdSchema = "";
  public boolean appAdShow;
  public String appAdText = "";
  public int appid;
  public String bigUrl = "";
  public Map<Integer, String> busi_param = new HashMap();
  public int commentCount;
  public long ctime;
  public String curkey = "";
  public String currentUrl = "";
  public long date;
  public String desc = "";
  public long fileSize;
  public int flag;
  public GpsInfo4LocalImage gpsInfo;
  public boolean hasCheckFace;
  public boolean hasLoaded;
  public Boolean hasLocalOrgFile;
  public boolean hasPraise;
  public boolean hasPreDownload;
  public Boolean hasQQCode;
  public Boolean hasQRCode;
  public boolean hasShowHighScaleTips;
  public boolean hasVisited;
  public float heightWeightProportion;
  private WeakReference<Drawable> imageDrawable;
  public int imageResolution;
  public boolean isFakeFeed;
  public int isIndependentUgc = -1;
  public boolean isSelected;
  public float lastScale;
  public String lloc = "";
  public ArrayList<FaceData> mFaceList;
  public int mNeedEncodeGifDelay;
  public ArrayList<String> mNeedEncodeGifPics = new ArrayList();
  public boolean needShowFaceIcon;
  public int opMask;
  public int opsynflag;
  public String orgUrl = "";
  public long originSize;
  public int photoOpmask;
  public int photoType = 1;
  public boolean picInfoOpen;
  public ArrayList<TagInfo> picTaginfoList;
  public int praiseCount;
  public int progress;
  public Map<Integer, String> pssBusiParam;
  public String pssCellId = "";
  public String pssCellSubId = "";
  public String pssCurLikeKey = "";
  public boolean pssHasFeedPraise;
  public String pssOrgLikeKey = "";
  public int pssSubId;
  public String pssUgcKey = "";
  public boolean quanLoaded;
  public int shareAlbumRight;
  public String sharePhotoUrl = "";
  public String shareQqUrl = "";
  public int shareSpaceRight;
  public String shareSummary = "";
  public String shareTitle = "";
  public String shareWeixinUrl = "";
  public int showGifState = SHOW_STATIC_PHOTO;
  public String sloc = "";
  public ArrayList<ImageTagInfo> tagList;
  private WeakReference<Drawable> thumbDrawable;
  public String unikey = "";
  public String uploadOwner = "";
  public int uploadtime;
  public long uploaduin;
  public VideoInfo videodata;
  public int videoflag;
  
  static
  {
    SHOW_GIF = 2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Drawable getAnimationDrawable()
  {
    Drawable localDrawable2 = getImageDrawable();
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 == null) {
      localDrawable1 = getThumbDrawable();
    }
    return localDrawable1;
  }
  
  public int getCutValue()
  {
    return 0;
  }
  
  public Drawable getImageDrawable()
  {
    if (this.imageDrawable != null) {
      return (Drawable)this.imageDrawable.get();
    }
    return null;
  }
  
  public int getStartX()
  {
    return 0;
  }
  
  public int getStartY()
  {
    return 0;
  }
  
  public Drawable getThumbDrawable()
  {
    if (this.thumbDrawable != null) {
      return (Drawable)this.thumbDrawable.get();
    }
    return null;
  }
  
  public Rect getThumbRect()
  {
    return null;
  }
  
  public boolean hasFace()
  {
    return (this.flag & 0x2) > 0;
  }
  
  public boolean isPanorama()
  {
    if (!PanoramaUtil.getInstance().isNeedShowPanorama()) {}
    while ((this.flag != 32) && (this.flag != 16)) {
      return false;
    }
    return true;
  }
  
  public boolean isWebPic()
  {
    return (this.flag & 0x4) > 0;
  }
  
  public boolean needAnimation(boolean paramBoolean)
  {
    return true;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.imageDrawable = new WeakReference(paramDrawable);
    }
  }
  
  public String toDebugString()
  {
    return "PhotoInfo{\nalbumName='" + this.albumName + '\'' + '\n' + ", albumId='" + this.albumId + '\'' + '\n' + ", albumPriv=" + this.albumPriv + '\n' + ", currentUrl='" + this.currentUrl + '\'' + '\n' + ", bigUrl='" + this.bigUrl + '\'' + '\n' + ", orgUrl='" + this.orgUrl + '\'' + '\n' + ", desc='" + this.desc + '\'' + '\n' + ", praiseCount=" + this.praiseCount + '\n' + ", commentCount=" + this.commentCount + '\n' + ", hasPraise=" + this.hasPraise + '\n' + ", unikey='" + this.unikey + '\'' + '\n' + ", curkey='" + this.curkey + '\'' + '\n' + ", lloc='" + this.lloc + '\'' + '\n' + ", sloc='" + this.sloc + '\'' + '\n' + ", busi_param=" + this.busi_param + '\n' + ", mNeedEncodeGifPics=" + this.mNeedEncodeGifPics + '\n' + ", mNeedEncodeGifDelay=" + this.mNeedEncodeGifDelay + '\n' + ", photoType=" + this.photoType + '\n' + ", opsynflag=" + this.opsynflag + '\n' + ", isIndependentUgc=" + this.isIndependentUgc + '\n' + ", flag=" + this.flag + '\n' + ", isSelected=" + this.isSelected + '\n' + ", hasLoaded=" + this.hasLoaded + '\n' + ", hasShowHighScaleTips=" + this.hasShowHighScaleTips + '\n' + ", lastScale=" + this.lastScale + '\n' + ", hasLocalOrgFile=" + this.hasLocalOrgFile + '\n' + ", progress=" + this.progress + '\n' + ", hasPreDownload=" + this.hasPreDownload + '\n' + ", hasVisited=" + this.hasVisited + '\n' + ", tagList=" + this.tagList + '\n' + ", quanLoaded=" + this.quanLoaded + '\n' + ", isFakeFeed=" + this.isFakeFeed + '\n' + ", showGifState=" + this.showGifState + '\n' + ", ctime=" + this.ctime + '\n' + ", gpsInfo=" + this.gpsInfo + '\n' + ", date=" + this.date + '\n' + ", hasQRCode=" + this.hasQRCode + '\n' + ", opMask=" + this.opMask + '\n' + ", allow_share=" + this.allow_share + '\n' + ", videoflag=" + this.videoflag + '\n' + ", videodata=" + this.videodata.toDebugString() + '\n' + ", uploadtime=" + this.uploadtime + '\n' + ", photoOpmask=" + this.photoOpmask + '\n' + ", uploadOwner='" + this.uploadOwner + '\'' + '\n' + ", uploaduin=" + this.uploaduin + '\n' + ", appid=" + this.appid + '\n' + ", pssCellId='" + this.pssCellId + '\'' + '\n' + ", pssCellSubId='" + this.pssCellSubId + '\'' + '\n' + ", pssUgcKey='" + this.pssUgcKey + '\'' + '\n' + ", pssSubId=" + this.pssSubId + '\n' + ", pssCurLikeKey='" + this.pssCurLikeKey + '\'' + '\n' + ", pssOrgLikeKey='" + this.pssOrgLikeKey + '\'' + '\n' + ", pssBusiParam=" + this.pssBusiParam + '\n' + ", pssHasFeedPraise=" + this.pssHasFeedPraise + '\n' + ", shareWeixinUrl='" + this.shareWeixinUrl + '\'' + '\n' + ", shareQqUrl='" + this.shareQqUrl + '\'' + '\n' + ", shareTitle='" + this.shareTitle + '\'' + '\n' + ", shareSummary='" + this.shareSummary + '\'' + '\n' + ", sharePhotoUrl='" + this.sharePhotoUrl + '\'' + '\n' + ", shareSpaceRight=" + this.shareSpaceRight + '\n' + ", shareAlbumRight=" + this.shareAlbumRight + '\n' + ", hasCheckFace=" + this.hasCheckFace + '\n' + ", needShowFaceIcon=" + this.needShowFaceIcon + '\n' + ", mFaceList=" + this.mFaceList + '\n' + ", originSize=" + this.originSize + '\n' + ", fileSize=" + this.fileSize + '\n' + ", imageResolution=" + this.imageResolution + '\n' + ", appAdShow=" + this.appAdShow + '\n' + ", appAdText='" + this.appAdText + '\'' + '\n' + ", appAdSchema='" + this.appAdSchema + '\'' + '\n' + ", picInfoOpen=" + this.picInfoOpen + '\n' + ", thumbDrawable=" + this.thumbDrawable + '\n' + ", imageDrawable=" + this.imageDrawable + '\n' + ", heightWeightProportion=" + this.heightWeightProportion + '\n' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    paramParcel.writeString(this.albumId);
    paramParcel.writeInt(this.albumPriv);
    paramParcel.writeString(this.currentUrl);
    paramParcel.writeString(this.bigUrl);
    paramParcel.writeString(this.orgUrl);
    paramParcel.writeString(this.desc);
    paramParcel.writeInt(this.praiseCount);
    paramParcel.writeInt(this.commentCount);
    int i;
    if (this.hasPraise)
    {
      i = 1;
      paramParcel.writeInt(i);
      paramParcel.writeString(this.unikey);
      paramParcel.writeString(this.curkey);
      paramParcel.writeString(this.lloc);
      paramParcel.writeString(this.sloc);
      paramParcel.writeMap(this.busi_param);
      paramParcel.writeList(this.mNeedEncodeGifPics);
      paramParcel.writeInt(this.mNeedEncodeGifDelay);
      paramParcel.writeInt(this.photoType);
      paramParcel.writeInt(this.opsynflag);
      paramParcel.writeInt(this.isIndependentUgc);
      paramParcel.writeParcelable(this.gpsInfo, paramInt);
      if (!this.isSelected) {
        break label556;
      }
      i = 1;
      label179:
      paramParcel.writeInt(i);
      paramParcel.writeLong(this.ctime);
      paramParcel.writeLong(this.date);
      paramParcel.writeTypedList(this.tagList);
      if (!this.isFakeFeed) {
        break label561;
      }
      i = 1;
      label217:
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.showGifState);
      paramParcel.writeInt(this.flag);
      paramParcel.writeInt(this.opMask);
      paramParcel.writeInt(this.allow_share);
      paramParcel.writeInt(this.videoflag);
      paramParcel.writeParcelable(this.videodata, paramInt);
      paramParcel.writeString(this.albumName);
      paramParcel.writeInt(this.uploadtime);
      paramParcel.writeInt(this.photoOpmask);
      paramParcel.writeString(this.uploadOwner);
      paramParcel.writeLong(this.uploaduin);
      paramParcel.writeInt(this.appid);
      paramParcel.writeString(this.pssCellId);
      paramParcel.writeString(this.pssCellSubId);
      paramParcel.writeString(this.pssUgcKey);
      paramParcel.writeInt(this.pssSubId);
      paramParcel.writeString(this.pssCurLikeKey);
      paramParcel.writeString(this.pssOrgLikeKey);
      paramParcel.writeMap(this.pssBusiParam);
      if (!this.pssHasFeedPraise) {
        break label566;
      }
      paramInt = 1;
      label384:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.shareWeixinUrl);
      paramParcel.writeString(this.shareQqUrl);
      paramParcel.writeString(this.shareTitle);
      paramParcel.writeString(this.shareSummary);
      paramParcel.writeString(this.sharePhotoUrl);
      paramParcel.writeInt(this.shareSpaceRight);
      paramParcel.writeInt(this.shareAlbumRight);
      if (!this.hasCheckFace) {
        break label571;
      }
      paramInt = 1;
      label454:
      paramParcel.writeInt(paramInt);
      paramParcel.writeSerializable(this.mFaceList);
      if (!this.needShowFaceIcon) {
        break label576;
      }
      paramInt = 1;
      label476:
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.originSize);
      if (!this.appAdShow) {
        break label581;
      }
      paramInt = 1;
      label498:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.appAdText);
      paramParcel.writeString(this.appAdSchema);
      if (!this.picInfoOpen) {
        break label586;
      }
    }
    label556:
    label561:
    label566:
    label571:
    label576:
    label581:
    label586:
    for (paramInt = j;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeList(this.picTaginfoList);
      paramParcel.writeFloat(this.heightWeightProportion);
      return;
      i = 0;
      break;
      i = 0;
      break label179;
      i = 0;
      break label217;
      paramInt = 0;
      break label384;
      paramInt = 0;
      break label454;
      paramInt = 0;
      break label476;
      paramInt = 0;
      break label498;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.PhotoInfo
 * JD-Core Version:    0.7.0.1
 */