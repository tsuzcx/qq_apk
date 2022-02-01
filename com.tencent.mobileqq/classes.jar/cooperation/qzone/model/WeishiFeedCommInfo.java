package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WeishiFeedCommInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WeishiFeedCommInfo> CREATOR = new WeishiFeedCommInfo.1();
  public int appid;
  public String cellId;
  public String curlikekey;
  public String feedskey;
  public boolean isLike;
  public int operatemask;
  public int operatemask2;
  public int orgCommentnum;
  public String orglikekey;
  public int orglikenum;
  public int polyPraiseCombo;
  public int polyPraiseItemId;
  public String polyPraisePicUrl;
  public String subId;
  public int ugcRight;
  public String ugckey;
  
  public WeishiFeedCommInfo(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.appid = paramInt;
    this.ugckey = paramString1;
    this.cellId = paramString2;
    this.subId = paramString3;
    this.feedskey = paramString4;
  }
  
  protected WeishiFeedCommInfo(Parcel paramParcel)
  {
    this.appid = paramParcel.readInt();
    this.ugckey = paramParcel.readString();
    this.cellId = paramParcel.readString();
    this.subId = paramParcel.readString();
    this.feedskey = paramParcel.readString();
    this.operatemask = paramParcel.readInt();
    this.operatemask2 = paramParcel.readInt();
    this.curlikekey = paramParcel.readString();
    this.orglikekey = paramParcel.readString();
    this.orglikenum = paramParcel.readInt();
    this.orgCommentnum = paramParcel.readInt();
    this.ugcRight = paramParcel.readInt();
    int i = paramParcel.readInt();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.isLike = bool;
    this.polyPraiseItemId = paramParcel.readInt();
    this.polyPraisePicUrl = paramParcel.readString();
    this.polyPraiseCombo = paramParcel.readInt();
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
 * Qualified Name:     cooperation.qzone.model.WeishiFeedCommInfo
 * JD-Core Version:    0.7.0.1
 */