package com.tencent.mobileqq.qwallet.hb.aio.elem;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;

public class RedPacketInfoBase
  implements Parcelable
{
  public static final Parcelable.Creator<RedPacketInfoBase> CREATOR = new RedPacketInfoBase.1();
  public static final String ICON_DEF = "icon_def";
  public static final String ICON_DRAW = "icon_draw";
  public static final String ICON_EMOJI = "icon_emoji";
  public static final String ICON_KSONG = "icon_ksong";
  public static final String ICON_SP = "icon_sp";
  public static final String ICON_TXT = "icon_txt";
  public static final String ICON_VIDEO = "icon_video";
  public static final String ICON_VOICE = "icon_voice";
  public AnimationView.AnimationInfo animInfo;
  public Bundle attribute = new Bundle();
  public String background;
  public int bigAnimId;
  public int channel = -1;
  public Bitmap corner;
  public Bitmap icon;
  public boolean isCache;
  public int isHideTitle;
  public String resPath;
  public int skinId;
  public int skinType;
  public AnimationView.AnimationInfo specailBackgroundAnimInfo;
  public Bitmap specialBackground;
  public String templateId;
  public String title;
  public int type;
  
  public RedPacketInfoBase() {}
  
  protected RedPacketInfoBase(Parcel paramParcel)
  {
    this.type = paramParcel.readInt();
    this.skinType = paramParcel.readInt();
    this.skinId = paramParcel.readInt();
    this.channel = paramParcel.readInt();
    this.bigAnimId = paramParcel.readInt();
    this.templateId = paramParcel.readString();
    this.corner = ((Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
    this.icon = ((Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
    this.specialBackground = ((Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
    this.title = paramParcel.readString();
    this.isHideTitle = paramParcel.readInt();
    this.resPath = paramParcel.readString();
    this.attribute = paramParcel.readBundle();
    int i = paramParcel.readInt();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.isCache = bool;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfoBase
 * JD-Core Version:    0.7.0.1
 */