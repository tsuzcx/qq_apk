package cooperation.qzone.model;

import NS_FASHION_FEEDS_TAG_PROTO.TagInfo;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.common.galleryactivity.GalleryImage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;

public class PhotoInfo
  extends GalleryImage
  implements Parcelable
{
  public static final Parcelable.Creator<PhotoInfo> CREATOR = new PhotoInfo.1();
  public static final int IMAGE_RESOLUTION_BIG = 1;
  public static final int IMAGE_RESOLUTION_ORIGINAL = 2;
  public static int SHOW_GIF = 2;
  public static int SHOW_NEITHER_GIF_NOR_PLAY = 1;
  public static int SHOW_STATIC_PHOTO;
  public String albumId = "";
  public String albumName;
  public int albumPriv;
  public int allow_share = 0;
  public String appAdSchema = "";
  public boolean appAdShow = false;
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
  public long fileSize = 0L;
  public int flag = 0;
  public GpsInfo4LocalImage gpsInfo;
  public boolean hasCheckFace = false;
  public boolean hasLoaded;
  public Boolean hasLocalOrgFile = null;
  public boolean hasPraise = false;
  public boolean hasPreDownload = false;
  public Boolean hasQQCode = null;
  public Boolean hasQRCode = null;
  public boolean hasShowHighScaleTips;
  public boolean hasVisited = false;
  public float heightWeightProportion = 0.0F;
  private WeakReference<Drawable> imageDrawable;
  public int imageResolution = 0;
  public boolean isFakeFeed = false;
  public int isIndependentUgc = -1;
  public boolean isSelected;
  public float lastScale;
  public String lloc = "";
  public ArrayList<FaceData> mFaceList = null;
  public int mNeedEncodeGifDelay;
  public ArrayList<String> mNeedEncodeGifPics = new ArrayList();
  public boolean needShowFaceIcon = false;
  public int opMask = 0;
  public int opsynflag;
  public String orgUrl = "";
  public long originSize = 0L;
  public int photoOpmask;
  public int photoType = 1;
  public boolean picInfoOpen = false;
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
  public boolean quanLoaded = false;
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
  public long uploaduin = 0L;
  public VideoInfo videodata = null;
  public int videoflag = 0;
  
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
    WeakReference localWeakReference = this.imageDrawable;
    if (localWeakReference != null) {
      return (Drawable)localWeakReference.get();
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
    WeakReference localWeakReference = this.thumbDrawable;
    if (localWeakReference != null) {
      return (Drawable)localWeakReference.get();
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
    boolean bool2 = ((IPanoramaUtil)QRoute.api(IPanoramaUtil.class)).isNeedShowPanorama();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    int i = this.flag;
    if ((i == 32) || (i == 16)) {
      bool1 = true;
    }
    return bool1;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PhotoInfo{\nalbumName='");
    localStringBuilder.append(this.albumName);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", albumId='");
    localStringBuilder.append(this.albumId);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", albumPriv=");
    localStringBuilder.append(this.albumPriv);
    localStringBuilder.append('\n');
    localStringBuilder.append(", currentUrl='");
    localStringBuilder.append(this.currentUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", bigUrl='");
    localStringBuilder.append(this.bigUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", orgUrl='");
    localStringBuilder.append(this.orgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", desc='");
    localStringBuilder.append(this.desc);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", praiseCount=");
    localStringBuilder.append(this.praiseCount);
    localStringBuilder.append('\n');
    localStringBuilder.append(", commentCount=");
    localStringBuilder.append(this.commentCount);
    localStringBuilder.append('\n');
    localStringBuilder.append(", hasPraise=");
    localStringBuilder.append(this.hasPraise);
    localStringBuilder.append('\n');
    localStringBuilder.append(", unikey='");
    localStringBuilder.append(this.unikey);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", curkey='");
    localStringBuilder.append(this.curkey);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", lloc='");
    localStringBuilder.append(this.lloc);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", sloc='");
    localStringBuilder.append(this.sloc);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", busi_param=");
    localStringBuilder.append(this.busi_param);
    localStringBuilder.append('\n');
    localStringBuilder.append(", mNeedEncodeGifPics=");
    localStringBuilder.append(this.mNeedEncodeGifPics);
    localStringBuilder.append('\n');
    localStringBuilder.append(", mNeedEncodeGifDelay=");
    localStringBuilder.append(this.mNeedEncodeGifDelay);
    localStringBuilder.append('\n');
    localStringBuilder.append(", photoType=");
    localStringBuilder.append(this.photoType);
    localStringBuilder.append('\n');
    localStringBuilder.append(", opsynflag=");
    localStringBuilder.append(this.opsynflag);
    localStringBuilder.append('\n');
    localStringBuilder.append(", isIndependentUgc=");
    localStringBuilder.append(this.isIndependentUgc);
    localStringBuilder.append('\n');
    localStringBuilder.append(", flag=");
    localStringBuilder.append(this.flag);
    localStringBuilder.append('\n');
    localStringBuilder.append(", isSelected=");
    localStringBuilder.append(this.isSelected);
    localStringBuilder.append('\n');
    localStringBuilder.append(", hasLoaded=");
    localStringBuilder.append(this.hasLoaded);
    localStringBuilder.append('\n');
    localStringBuilder.append(", hasShowHighScaleTips=");
    localStringBuilder.append(this.hasShowHighScaleTips);
    localStringBuilder.append('\n');
    localStringBuilder.append(", lastScale=");
    localStringBuilder.append(this.lastScale);
    localStringBuilder.append('\n');
    localStringBuilder.append(", hasLocalOrgFile=");
    localStringBuilder.append(this.hasLocalOrgFile);
    localStringBuilder.append('\n');
    localStringBuilder.append(", progress=");
    localStringBuilder.append(this.progress);
    localStringBuilder.append('\n');
    localStringBuilder.append(", hasPreDownload=");
    localStringBuilder.append(this.hasPreDownload);
    localStringBuilder.append('\n');
    localStringBuilder.append(", hasVisited=");
    localStringBuilder.append(this.hasVisited);
    localStringBuilder.append('\n');
    localStringBuilder.append(", tagList=");
    localStringBuilder.append(this.tagList);
    localStringBuilder.append('\n');
    localStringBuilder.append(", quanLoaded=");
    localStringBuilder.append(this.quanLoaded);
    localStringBuilder.append('\n');
    localStringBuilder.append(", isFakeFeed=");
    localStringBuilder.append(this.isFakeFeed);
    localStringBuilder.append('\n');
    localStringBuilder.append(", showGifState=");
    localStringBuilder.append(this.showGifState);
    localStringBuilder.append('\n');
    localStringBuilder.append(", ctime=");
    localStringBuilder.append(this.ctime);
    localStringBuilder.append('\n');
    localStringBuilder.append(", gpsInfo=");
    localStringBuilder.append(this.gpsInfo);
    localStringBuilder.append('\n');
    localStringBuilder.append(", date=");
    localStringBuilder.append(this.date);
    localStringBuilder.append('\n');
    localStringBuilder.append(", hasQRCode=");
    localStringBuilder.append(this.hasQRCode);
    localStringBuilder.append('\n');
    localStringBuilder.append(", opMask=");
    localStringBuilder.append(this.opMask);
    localStringBuilder.append('\n');
    localStringBuilder.append(", allow_share=");
    localStringBuilder.append(this.allow_share);
    localStringBuilder.append('\n');
    localStringBuilder.append(", videoflag=");
    localStringBuilder.append(this.videoflag);
    localStringBuilder.append('\n');
    localStringBuilder.append(", videodata=");
    localStringBuilder.append(this.videodata.toDebugString());
    localStringBuilder.append('\n');
    localStringBuilder.append(", uploadtime=");
    localStringBuilder.append(this.uploadtime);
    localStringBuilder.append('\n');
    localStringBuilder.append(", photoOpmask=");
    localStringBuilder.append(this.photoOpmask);
    localStringBuilder.append('\n');
    localStringBuilder.append(", uploadOwner='");
    localStringBuilder.append(this.uploadOwner);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", uploaduin=");
    localStringBuilder.append(this.uploaduin);
    localStringBuilder.append('\n');
    localStringBuilder.append(", appid=");
    localStringBuilder.append(this.appid);
    localStringBuilder.append('\n');
    localStringBuilder.append(", pssCellId='");
    localStringBuilder.append(this.pssCellId);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", pssCellSubId='");
    localStringBuilder.append(this.pssCellSubId);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", pssUgcKey='");
    localStringBuilder.append(this.pssUgcKey);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", pssSubId=");
    localStringBuilder.append(this.pssSubId);
    localStringBuilder.append('\n');
    localStringBuilder.append(", pssCurLikeKey='");
    localStringBuilder.append(this.pssCurLikeKey);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", pssOrgLikeKey='");
    localStringBuilder.append(this.pssOrgLikeKey);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", pssBusiParam=");
    localStringBuilder.append(this.pssBusiParam);
    localStringBuilder.append('\n');
    localStringBuilder.append(", pssHasFeedPraise=");
    localStringBuilder.append(this.pssHasFeedPraise);
    localStringBuilder.append('\n');
    localStringBuilder.append(", shareWeixinUrl='");
    localStringBuilder.append(this.shareWeixinUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", shareQqUrl='");
    localStringBuilder.append(this.shareQqUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", shareTitle='");
    localStringBuilder.append(this.shareTitle);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", shareSummary='");
    localStringBuilder.append(this.shareSummary);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", sharePhotoUrl='");
    localStringBuilder.append(this.sharePhotoUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", shareSpaceRight=");
    localStringBuilder.append(this.shareSpaceRight);
    localStringBuilder.append('\n');
    localStringBuilder.append(", shareAlbumRight=");
    localStringBuilder.append(this.shareAlbumRight);
    localStringBuilder.append('\n');
    localStringBuilder.append(", hasCheckFace=");
    localStringBuilder.append(this.hasCheckFace);
    localStringBuilder.append('\n');
    localStringBuilder.append(", needShowFaceIcon=");
    localStringBuilder.append(this.needShowFaceIcon);
    localStringBuilder.append('\n');
    localStringBuilder.append(", mFaceList=");
    localStringBuilder.append(this.mFaceList);
    localStringBuilder.append('\n');
    localStringBuilder.append(", originSize=");
    localStringBuilder.append(this.originSize);
    localStringBuilder.append('\n');
    localStringBuilder.append(", fileSize=");
    localStringBuilder.append(this.fileSize);
    localStringBuilder.append('\n');
    localStringBuilder.append(", imageResolution=");
    localStringBuilder.append(this.imageResolution);
    localStringBuilder.append('\n');
    localStringBuilder.append(", appAdShow=");
    localStringBuilder.append(this.appAdShow);
    localStringBuilder.append('\n');
    localStringBuilder.append(", appAdText='");
    localStringBuilder.append(this.appAdText);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", appAdSchema='");
    localStringBuilder.append(this.appAdSchema);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", picInfoOpen=");
    localStringBuilder.append(this.picInfoOpen);
    localStringBuilder.append('\n');
    localStringBuilder.append(", thumbDrawable=");
    localStringBuilder.append(this.thumbDrawable);
    localStringBuilder.append('\n');
    localStringBuilder.append(", imageDrawable=");
    localStringBuilder.append(this.imageDrawable);
    localStringBuilder.append('\n');
    localStringBuilder.append(", heightWeightProportion=");
    localStringBuilder.append(this.heightWeightProportion);
    localStringBuilder.append('\n');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.PhotoInfo
 * JD-Core Version:    0.7.0.1
 */