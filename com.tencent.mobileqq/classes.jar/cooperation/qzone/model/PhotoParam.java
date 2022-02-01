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
  public boolean isFriendPhotoBizFeed = false;
  public boolean isLike = false;
  public boolean isOnePictureFeed = false;
  public boolean isOnlyPreView = false;
  public boolean isShareAlbum = false;
  public boolean isSharedFeeds = false;
  public boolean isTihFeed;
  public boolean isVideoPicMix;
  public int likeNum;
  public String loginNickName = "";
  public long loginUin;
  public boolean mFromRecent = false;
  public String oneFeedPictruePath = "";
  public String orgKey = "";
  public long ownerUin;
  public String qunid;
  public long qzoneUserType = 0L;
  public long realOwnerUin;
  public long sharer = 0L;
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
    localStringBuffer.append("loginUin=");
    localStringBuffer.append(this.loginUin);
    localStringBuffer.append(", feedUin=");
    localStringBuffer.append(this.feedUin);
    localStringBuffer.append(", ownerUin=");
    localStringBuffer.append(this.ownerUin);
    localStringBuffer.append(", realOwnerUin=");
    localStringBuffer.append(this.realOwnerUin);
    localStringBuffer.append(", albumanswer='");
    localStringBuffer.append(this.albumanswer);
    localStringBuffer.append('\'');
    localStringBuffer.append(", albumid='");
    localStringBuffer.append(this.albumid);
    localStringBuffer.append('\'');
    localStringBuffer.append(", sortType=");
    localStringBuffer.append(this.sortType);
    localStringBuffer.append(", albumPriv=");
    localStringBuffer.append(this.albumPriv);
    localStringBuffer.append(", albumnum=");
    localStringBuffer.append(this.albumnum);
    localStringBuffer.append(", uploadnum=");
    localStringBuffer.append(this.uploadnum);
    localStringBuffer.append(", albumType=");
    localStringBuffer.append(this.albumType);
    localStringBuffer.append(", businessPhotoFeedIndex=");
    localStringBuffer.append(this.businessPhotoFeedIndex);
    localStringBuffer.append(", qunid='");
    localStringBuffer.append(this.qunid);
    localStringBuffer.append('\'');
    localStringBuffer.append(", isLike=");
    localStringBuffer.append(this.isLike);
    localStringBuffer.append(", likeNum=");
    localStringBuffer.append(this.likeNum);
    localStringBuffer.append(", commentNum=");
    localStringBuffer.append(this.commentNum);
    localStringBuffer.append(", curKey='");
    localStringBuffer.append(this.curKey);
    localStringBuffer.append('\'');
    localStringBuffer.append(", orgKey='");
    localStringBuffer.append(this.orgKey);
    localStringBuffer.append('\'');
    localStringBuffer.append(", feedId='");
    localStringBuffer.append(this.feedId);
    localStringBuffer.append('\'');
    localStringBuffer.append(", cell_id='");
    localStringBuffer.append(this.cell_id);
    localStringBuffer.append('\'');
    localStringBuffer.append(", cell_subId='");
    localStringBuffer.append(this.cell_subId);
    localStringBuffer.append('\'');
    localStringBuffer.append(", appid=");
    localStringBuffer.append(this.appid);
    localStringBuffer.append(", ugcKey='");
    localStringBuffer.append(this.ugcKey);
    localStringBuffer.append('\'');
    localStringBuffer.append(", canAddFavor=");
    localStringBuffer.append(this.canAddFavor);
    localStringBuffer.append(", subid=");
    localStringBuffer.append(this.subid);
    localStringBuffer.append(", isOnePictureFeed=");
    localStringBuffer.append(this.isOnePictureFeed);
    localStringBuffer.append(", oneFeedPictruePath='");
    localStringBuffer.append(this.oneFeedPictruePath);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mFromRecent=");
    localStringBuffer.append(this.mFromRecent);
    localStringBuffer.append(", busi_param=");
    localStringBuffer.append(this.busi_param);
    localStringBuffer.append(", isTihFeed=");
    localStringBuffer.append(this.isTihFeed);
    localStringBuffer.append(", isOnlyPreView=");
    localStringBuffer.append(this.isOnlyPreView);
    localStringBuffer.append(", isFriendPhotoBizFeed=");
    localStringBuffer.append(this.isFriendPhotoBizFeed);
    localStringBuffer.append(", isShareAlbum=");
    localStringBuffer.append(this.isShareAlbum);
    localStringBuffer.append(", isVideoPicMix=");
    localStringBuffer.append(this.isVideoPicMix);
    localStringBuffer.append(", getPhotoExType=");
    localStringBuffer.append(this.getPhotoExType);
    localStringBuffer.append(", sharer=");
    localStringBuffer.append(this.sharer);
    localStringBuffer.append(", loginNickName='");
    localStringBuffer.append(this.loginNickName);
    localStringBuffer.append('\'');
    localStringBuffer.append(", qzoneUserType=");
    localStringBuffer.append(this.qzoneUserType);
    localStringBuffer.append(", isSharedFeeds=");
    localStringBuffer.append(this.isSharedFeeds);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.PhotoParam
 * JD-Core Version:    0.7.0.1
 */