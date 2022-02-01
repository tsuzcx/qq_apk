package com.tencent.xaction.api.style;

import androidx.annotation.Keep;
import com.tencent.xaction.api.data.Border;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/style/Style;", "", "w", "", "h", "x", "y", "rad", "ml", "mt", "mr", "mb", "pl", "pt", "pr", "pb", "borders", "", "Lcom/tencent/xaction/api/data/Border;", "align", "op", "", "vi", "", "bc", "", "bg", "rx", "ry", "rz", "elev", "sx", "sy", "fs", "ff", "ta", "fw", "ffp", "fc", "fh", "drawableId", "hierarchy", "(IIIIIIIIIIIII[Lcom/tencent/xaction/api/data/Border;IFZLjava/lang/String;Ljava/lang/String;IIIFFFFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III)V", "getAlign", "()I", "setAlign", "(I)V", "getBc", "()Ljava/lang/String;", "setBc", "(Ljava/lang/String;)V", "getBg", "setBg", "getBorders", "()[Lcom/tencent/xaction/api/data/Border;", "setBorders", "([Lcom/tencent/xaction/api/data/Border;)V", "[Lcom/tencent/xaction/api/data/Border;", "getDrawableId", "setDrawableId", "getElev", "()F", "setElev", "(F)V", "getFc", "setFc", "getFf", "setFf", "getFfp", "setFfp", "getFh", "setFh", "getFs", "setFs", "getFw", "setFw", "getH", "setH", "getHierarchy", "getMb", "setMb", "getMl", "setMl", "getMr", "setMr", "getMt", "setMt", "getOp", "setOp", "getPb", "setPb", "getPl", "setPl", "getPr", "setPr", "getPt", "setPt", "getRad", "setRad", "getRx", "setRx", "getRy", "setRy", "getRz", "setRz", "getSx", "setSx", "getSy", "setSy", "getTa", "setTa", "getVi", "()Z", "setVi", "(Z)V", "getW", "setW", "getX", "setX", "getY", "setY", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IIIIIIIIIIIII[Lcom/tencent/xaction/api/data/Border;IFZLjava/lang/String;Ljava/lang/String;IIIFFFFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III)Lcom/tencent/xaction/api/style/Style;", "equals", "other", "hashCode", "toString", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class Style
{
  private int align;
  @NotNull
  private String bc;
  @NotNull
  private String bg;
  @Nullable
  private Border[] borders;
  private int drawableId;
  private float elev;
  @NotNull
  private String fc;
  @NotNull
  private String ff;
  @NotNull
  private String ffp;
  private int fh;
  private float fs;
  @NotNull
  private String fw;
  private int h;
  private final int hierarchy;
  private int mb;
  private int ml;
  private int mr;
  private int mt;
  private float op;
  private int pb;
  private int pl;
  private int pr;
  private int pt;
  private int rad;
  private int rx;
  private int ry;
  private int rz;
  private float sx;
  private float sy;
  @NotNull
  private String ta;
  private boolean vi;
  private int w;
  private int x;
  private int y;
  
  public Style()
  {
    this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0.0F, false, null, null, 0, 0, 0, 0.0F, 0.0F, 0.0F, 0.0F, null, null, null, null, null, 0, 0, 0, -1, 3, null);
  }
  
  public Style(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, @Nullable Border[] paramArrayOfBorder, int paramInt14, float paramFloat1, boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2, int paramInt15, int paramInt16, int paramInt17, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6, @NotNull String paramString7, int paramInt18, int paramInt19, int paramInt20)
  {
    this.w = paramInt1;
    this.h = paramInt2;
    this.x = paramInt3;
    this.y = paramInt4;
    this.rad = paramInt5;
    this.ml = paramInt6;
    this.mt = paramInt7;
    this.mr = paramInt8;
    this.mb = paramInt9;
    this.pl = paramInt10;
    this.pt = paramInt11;
    this.pr = paramInt12;
    this.pb = paramInt13;
    this.borders = paramArrayOfBorder;
    this.align = paramInt14;
    this.op = paramFloat1;
    this.vi = paramBoolean;
    this.bc = paramString1;
    this.bg = paramString2;
    this.rx = paramInt15;
    this.ry = paramInt16;
    this.rz = paramInt17;
    this.elev = paramFloat2;
    this.sx = paramFloat3;
    this.sy = paramFloat4;
    this.fs = paramFloat5;
    this.ff = paramString3;
    this.ta = paramString4;
    this.fw = paramString5;
    this.ffp = paramString6;
    this.fc = paramString7;
    this.fh = paramInt18;
    this.drawableId = paramInt19;
    this.hierarchy = paramInt20;
  }
  
  public final int component1()
  {
    return this.w;
  }
  
  public final int component10()
  {
    return this.pl;
  }
  
  public final int component11()
  {
    return this.pt;
  }
  
  public final int component12()
  {
    return this.pr;
  }
  
  public final int component13()
  {
    return this.pb;
  }
  
  @Nullable
  public final Border[] component14()
  {
    return this.borders;
  }
  
  public final int component15()
  {
    return this.align;
  }
  
  public final float component16()
  {
    return this.op;
  }
  
  public final boolean component17()
  {
    return this.vi;
  }
  
  @NotNull
  public final String component18()
  {
    return this.bc;
  }
  
  @NotNull
  public final String component19()
  {
    return this.bg;
  }
  
  public final int component2()
  {
    return this.h;
  }
  
  public final int component20()
  {
    return this.rx;
  }
  
  public final int component21()
  {
    return this.ry;
  }
  
  public final int component22()
  {
    return this.rz;
  }
  
  public final float component23()
  {
    return this.elev;
  }
  
  public final float component24()
  {
    return this.sx;
  }
  
  public final float component25()
  {
    return this.sy;
  }
  
  public final float component26()
  {
    return this.fs;
  }
  
  @NotNull
  public final String component27()
  {
    return this.ff;
  }
  
  @NotNull
  public final String component28()
  {
    return this.ta;
  }
  
  @NotNull
  public final String component29()
  {
    return this.fw;
  }
  
  public final int component3()
  {
    return this.x;
  }
  
  @NotNull
  public final String component30()
  {
    return this.ffp;
  }
  
  @NotNull
  public final String component31()
  {
    return this.fc;
  }
  
  public final int component32()
  {
    return this.fh;
  }
  
  public final int component33()
  {
    return this.drawableId;
  }
  
  public final int component34()
  {
    return this.hierarchy;
  }
  
  public final int component4()
  {
    return this.y;
  }
  
  public final int component5()
  {
    return this.rad;
  }
  
  public final int component6()
  {
    return this.ml;
  }
  
  public final int component7()
  {
    return this.mt;
  }
  
  public final int component8()
  {
    return this.mr;
  }
  
  public final int component9()
  {
    return this.mb;
  }
  
  @NotNull
  public final Style copy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, @Nullable Border[] paramArrayOfBorder, int paramInt14, float paramFloat1, boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2, int paramInt15, int paramInt16, int paramInt17, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6, @NotNull String paramString7, int paramInt18, int paramInt19, int paramInt20)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "bc");
    Intrinsics.checkParameterIsNotNull(paramString2, "bg");
    Intrinsics.checkParameterIsNotNull(paramString3, "ff");
    Intrinsics.checkParameterIsNotNull(paramString4, "ta");
    Intrinsics.checkParameterIsNotNull(paramString5, "fw");
    Intrinsics.checkParameterIsNotNull(paramString6, "ffp");
    Intrinsics.checkParameterIsNotNull(paramString7, "fc");
    return new Style(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, paramInt13, paramArrayOfBorder, paramInt14, paramFloat1, paramBoolean, paramString1, paramString2, paramInt15, paramInt16, paramInt17, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramString3, paramString4, paramString5, paramString6, paramString7, paramInt18, paramInt19, paramInt20);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Style))
      {
        paramObject = (Style)paramObject;
        if ((this.w == paramObject.w) && (this.h == paramObject.h) && (this.x == paramObject.x) && (this.y == paramObject.y) && (this.rad == paramObject.rad) && (this.ml == paramObject.ml) && (this.mt == paramObject.mt) && (this.mr == paramObject.mr) && (this.mb == paramObject.mb) && (this.pl == paramObject.pl) && (this.pt == paramObject.pt) && (this.pr == paramObject.pr) && (this.pb == paramObject.pb) && (Intrinsics.areEqual(this.borders, paramObject.borders)) && (this.align == paramObject.align) && (Float.compare(this.op, paramObject.op) == 0) && (this.vi == paramObject.vi) && (Intrinsics.areEqual(this.bc, paramObject.bc)) && (Intrinsics.areEqual(this.bg, paramObject.bg)) && (this.rx == paramObject.rx) && (this.ry == paramObject.ry) && (this.rz == paramObject.rz) && (Float.compare(this.elev, paramObject.elev) == 0) && (Float.compare(this.sx, paramObject.sx) == 0) && (Float.compare(this.sy, paramObject.sy) == 0) && (Float.compare(this.fs, paramObject.fs) == 0) && (Intrinsics.areEqual(this.ff, paramObject.ff)) && (Intrinsics.areEqual(this.ta, paramObject.ta)) && (Intrinsics.areEqual(this.fw, paramObject.fw)) && (Intrinsics.areEqual(this.ffp, paramObject.ffp)) && (Intrinsics.areEqual(this.fc, paramObject.fc)) && (this.fh == paramObject.fh) && (this.drawableId == paramObject.drawableId) && (this.hierarchy == paramObject.hierarchy)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getAlign()
  {
    return this.align;
  }
  
  @NotNull
  public final String getBc()
  {
    return this.bc;
  }
  
  @NotNull
  public final String getBg()
  {
    return this.bg;
  }
  
  @Nullable
  public final Border[] getBorders()
  {
    return this.borders;
  }
  
  public final int getDrawableId()
  {
    return this.drawableId;
  }
  
  public final float getElev()
  {
    return this.elev;
  }
  
  @NotNull
  public final String getFc()
  {
    return this.fc;
  }
  
  @NotNull
  public final String getFf()
  {
    return this.ff;
  }
  
  @NotNull
  public final String getFfp()
  {
    return this.ffp;
  }
  
  public final int getFh()
  {
    return this.fh;
  }
  
  public final float getFs()
  {
    return this.fs;
  }
  
  @NotNull
  public final String getFw()
  {
    return this.fw;
  }
  
  public final int getH()
  {
    return this.h;
  }
  
  public final int getHierarchy()
  {
    return this.hierarchy;
  }
  
  public final int getMb()
  {
    return this.mb;
  }
  
  public final int getMl()
  {
    return this.ml;
  }
  
  public final int getMr()
  {
    return this.mr;
  }
  
  public final int getMt()
  {
    return this.mt;
  }
  
  public final float getOp()
  {
    return this.op;
  }
  
  public final int getPb()
  {
    return this.pb;
  }
  
  public final int getPl()
  {
    return this.pl;
  }
  
  public final int getPr()
  {
    return this.pr;
  }
  
  public final int getPt()
  {
    return this.pt;
  }
  
  public final int getRad()
  {
    return this.rad;
  }
  
  public final int getRx()
  {
    return this.rx;
  }
  
  public final int getRy()
  {
    return this.ry;
  }
  
  public final int getRz()
  {
    return this.rz;
  }
  
  public final float getSx()
  {
    return this.sx;
  }
  
  public final float getSy()
  {
    return this.sy;
  }
  
  @NotNull
  public final String getTa()
  {
    return this.ta;
  }
  
  public final boolean getVi()
  {
    return this.vi;
  }
  
  public final int getW()
  {
    return this.w;
  }
  
  public final int getX()
  {
    return this.x;
  }
  
  public final int getY()
  {
    return this.y;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void setAlign(int paramInt)
  {
    this.align = paramInt;
  }
  
  public final void setBc(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.bc = paramString;
  }
  
  public final void setBg(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.bg = paramString;
  }
  
  public final void setBorders(@Nullable Border[] paramArrayOfBorder)
  {
    this.borders = paramArrayOfBorder;
  }
  
  public final void setDrawableId(int paramInt)
  {
    this.drawableId = paramInt;
  }
  
  public final void setElev(float paramFloat)
  {
    this.elev = paramFloat;
  }
  
  public final void setFc(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.fc = paramString;
  }
  
  public final void setFf(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.ff = paramString;
  }
  
  public final void setFfp(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.ffp = paramString;
  }
  
  public final void setFh(int paramInt)
  {
    this.fh = paramInt;
  }
  
  public final void setFs(float paramFloat)
  {
    this.fs = paramFloat;
  }
  
  public final void setFw(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.fw = paramString;
  }
  
  public final void setH(int paramInt)
  {
    this.h = paramInt;
  }
  
  public final void setMb(int paramInt)
  {
    this.mb = paramInt;
  }
  
  public final void setMl(int paramInt)
  {
    this.ml = paramInt;
  }
  
  public final void setMr(int paramInt)
  {
    this.mr = paramInt;
  }
  
  public final void setMt(int paramInt)
  {
    this.mt = paramInt;
  }
  
  public final void setOp(float paramFloat)
  {
    this.op = paramFloat;
  }
  
  public final void setPb(int paramInt)
  {
    this.pb = paramInt;
  }
  
  public final void setPl(int paramInt)
  {
    this.pl = paramInt;
  }
  
  public final void setPr(int paramInt)
  {
    this.pr = paramInt;
  }
  
  public final void setPt(int paramInt)
  {
    this.pt = paramInt;
  }
  
  public final void setRad(int paramInt)
  {
    this.rad = paramInt;
  }
  
  public final void setRx(int paramInt)
  {
    this.rx = paramInt;
  }
  
  public final void setRy(int paramInt)
  {
    this.ry = paramInt;
  }
  
  public final void setRz(int paramInt)
  {
    this.rz = paramInt;
  }
  
  public final void setSx(float paramFloat)
  {
    this.sx = paramFloat;
  }
  
  public final void setSy(float paramFloat)
  {
    this.sy = paramFloat;
  }
  
  public final void setTa(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.ta = paramString;
  }
  
  public final void setVi(boolean paramBoolean)
  {
    this.vi = paramBoolean;
  }
  
  public final void setW(int paramInt)
  {
    this.w = paramInt;
  }
  
  public final void setX(int paramInt)
  {
    this.x = paramInt;
  }
  
  public final void setY(int paramInt)
  {
    this.y = paramInt;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Style(w=");
    localStringBuilder.append(this.w);
    localStringBuilder.append(", h=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", x=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", y=");
    localStringBuilder.append(this.y);
    localStringBuilder.append(", rad=");
    localStringBuilder.append(this.rad);
    localStringBuilder.append(", ml=");
    localStringBuilder.append(this.ml);
    localStringBuilder.append(", mt=");
    localStringBuilder.append(this.mt);
    localStringBuilder.append(", mr=");
    localStringBuilder.append(this.mr);
    localStringBuilder.append(", mb=");
    localStringBuilder.append(this.mb);
    localStringBuilder.append(", pl=");
    localStringBuilder.append(this.pl);
    localStringBuilder.append(", pt=");
    localStringBuilder.append(this.pt);
    localStringBuilder.append(", pr=");
    localStringBuilder.append(this.pr);
    localStringBuilder.append(", pb=");
    localStringBuilder.append(this.pb);
    localStringBuilder.append(", borders=");
    localStringBuilder.append(Arrays.toString(this.borders));
    localStringBuilder.append(", align=");
    localStringBuilder.append(this.align);
    localStringBuilder.append(", op=");
    localStringBuilder.append(this.op);
    localStringBuilder.append(", vi=");
    localStringBuilder.append(this.vi);
    localStringBuilder.append(", bc=");
    localStringBuilder.append(this.bc);
    localStringBuilder.append(", bg=");
    localStringBuilder.append(this.bg);
    localStringBuilder.append(", rx=");
    localStringBuilder.append(this.rx);
    localStringBuilder.append(", ry=");
    localStringBuilder.append(this.ry);
    localStringBuilder.append(", rz=");
    localStringBuilder.append(this.rz);
    localStringBuilder.append(", elev=");
    localStringBuilder.append(this.elev);
    localStringBuilder.append(", sx=");
    localStringBuilder.append(this.sx);
    localStringBuilder.append(", sy=");
    localStringBuilder.append(this.sy);
    localStringBuilder.append(", fs=");
    localStringBuilder.append(this.fs);
    localStringBuilder.append(", ff=");
    localStringBuilder.append(this.ff);
    localStringBuilder.append(", ta=");
    localStringBuilder.append(this.ta);
    localStringBuilder.append(", fw=");
    localStringBuilder.append(this.fw);
    localStringBuilder.append(", ffp=");
    localStringBuilder.append(this.ffp);
    localStringBuilder.append(", fc=");
    localStringBuilder.append(this.fc);
    localStringBuilder.append(", fh=");
    localStringBuilder.append(this.fh);
    localStringBuilder.append(", drawableId=");
    localStringBuilder.append(this.drawableId);
    localStringBuilder.append(", hierarchy=");
    localStringBuilder.append(this.hierarchy);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.api.style.Style
 * JD-Core Version:    0.7.0.1
 */