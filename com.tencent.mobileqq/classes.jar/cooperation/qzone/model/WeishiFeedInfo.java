package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WeishiFeedInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WeishiFeedInfo> CREATOR = new WeishiFeedInfo.1();
  public static final int FROM_TYPE_ALBUM_VIDEO = 1;
  public static final int FROM_TYPE_DEFAULT = 0;
  public static final int FROM_TYPE_WEISHI_VIDEO = 2;
  public WeishiBasicInfo basicInfo;
  public WeishiBottomButton bottomButton;
  public WeishiFeedCommInfo feedCommInfo;
  public int feedFakeType;
  public WeishiInterestInfo interestInfo;
  public KingCardInfo kingCardInfo;
  public boolean mIsFrdLikeMiniAppVideo;
  public int mIsFrom;
  public WeishiOperationInfo operationInfo;
  public WeishiShareDataInfo shareDataInfo;
  public WeishiUserInfo userInfo;
  public VideoInfo videoInfo;
  
  public WeishiFeedInfo()
  {
    this.mIsFrom = 0;
    this.feedFakeType = 2;
  }
  
  protected WeishiFeedInfo(Parcel paramParcel)
  {
    boolean bool = false;
    this.mIsFrom = 0;
    this.feedFakeType = 2;
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
    if (paramParcel.readInt() != 0) {
      bool = true;
    }
    this.mIsFrdLikeMiniAppVideo = bool;
    this.feedFakeType = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.WeishiFeedInfo
 * JD-Core Version:    0.7.0.1
 */