package com.tencent.xaction.api.style;

import androidx.annotation.Keep;
import com.tencent.xaction.api.data.Border;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/style/Style;", "", "w", "", "h", "x", "y", "ml", "", "mt", "mr", "mb", "pl", "pt", "pr", "pb", "borders", "", "Lcom/tencent/xaction/api/data/Border;", "op", "vi", "", "bc", "", "bg", "rx", "ry", "elev", "sx", "sy", "fs", "ff", "ta", "fw", "ffp", "fc", "drawableId", "hierarchy", "(FFFFIIIIIIII[Lcom/tencent/xaction/api/data/Border;FZLjava/lang/String;Ljava/lang/String;IIFFFFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getBc", "()Ljava/lang/String;", "setBc", "(Ljava/lang/String;)V", "getBg", "setBg", "getBorders", "()[Lcom/tencent/xaction/api/data/Border;", "setBorders", "([Lcom/tencent/xaction/api/data/Border;)V", "[Lcom/tencent/xaction/api/data/Border;", "getDrawableId", "()I", "setDrawableId", "(I)V", "getElev", "()F", "setElev", "(F)V", "getFc", "setFc", "getFf", "setFf", "getFfp", "setFfp", "getFs", "setFs", "getFw", "setFw", "getH", "setH", "getHierarchy", "getMb", "setMb", "getMl", "setMl", "getMr", "setMr", "getMt", "setMt", "getOp", "setOp", "getPb", "setPb", "getPl", "setPl", "getPr", "setPr", "getPt", "setPt", "getRx", "setRx", "getRy", "setRy", "getSx", "setSx", "getSy", "setSy", "getTa", "setTa", "getVi", "()Z", "setVi", "(Z)V", "getW", "setW", "getX", "setX", "getY", "setY", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(FFFFIIIIIIII[Lcom/tencent/xaction/api/data/Border;FZLjava/lang/String;Ljava/lang/String;IIFFFFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)Lcom/tencent/xaction/api/style/Style;", "equals", "other", "hashCode", "toString", "XActionEngine_release"}, k=1, mv={1, 1, 16})
@Keep
public final class Style
{
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
  private float fs;
  @NotNull
  private String fw;
  private float h;
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
  private int rx;
  private int ry;
  private float sx;
  private float sy;
  @NotNull
  private String ta;
  private boolean vi;
  private float w;
  private float x;
  private float y;
  
  public Style()
  {
    this(0.0F, 0.0F, 0.0F, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, null, 0.0F, false, null, null, 0, 0, 0.0F, 0.0F, 0.0F, 0.0F, null, null, null, null, null, 0, 0, 1073741823, null);
  }
  
  public Style(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, @Nullable Border[] paramArrayOfBorder, float paramFloat5, boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2, int paramInt9, int paramInt10, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6, @NotNull String paramString7, int paramInt11, int paramInt12)
  {
    this.w = paramFloat1;
    this.h = paramFloat2;
    this.x = paramFloat3;
    this.y = paramFloat4;
    this.ml = paramInt1;
    this.mt = paramInt2;
    this.mr = paramInt3;
    this.mb = paramInt4;
    this.pl = paramInt5;
    this.pt = paramInt6;
    this.pr = paramInt7;
    this.pb = paramInt8;
    this.borders = paramArrayOfBorder;
    this.op = paramFloat5;
    this.vi = paramBoolean;
    this.bc = paramString1;
    this.bg = paramString2;
    this.rx = paramInt9;
    this.ry = paramInt10;
    this.elev = paramFloat6;
    this.sx = paramFloat7;
    this.sy = paramFloat8;
    this.fs = paramFloat9;
    this.ff = paramString3;
    this.ta = paramString4;
    this.fw = paramString5;
    this.ffp = paramString6;
    this.fc = paramString7;
    this.drawableId = paramInt11;
    this.hierarchy = paramInt12;
  }
  
  public final float component1()
  {
    return this.w;
  }
  
  public final int component10()
  {
    return this.pt;
  }
  
  public final int component11()
  {
    return this.pr;
  }
  
  public final int component12()
  {
    return this.pb;
  }
  
  @Nullable
  public final Border[] component13()
  {
    return this.borders;
  }
  
  public final float component14()
  {
    return this.op;
  }
  
  public final boolean component15()
  {
    return this.vi;
  }
  
  @NotNull
  public final String component16()
  {
    return this.bc;
  }
  
  @NotNull
  public final String component17()
  {
    return this.bg;
  }
  
  public final int component18()
  {
    return this.rx;
  }
  
  public final int component19()
  {
    return this.ry;
  }
  
  public final float component2()
  {
    return this.h;
  }
  
  public final float component20()
  {
    return this.elev;
  }
  
  public final float component21()
  {
    return this.sx;
  }
  
  public final float component22()
  {
    return this.sy;
  }
  
  public final float component23()
  {
    return this.fs;
  }
  
  @NotNull
  public final String component24()
  {
    return this.ff;
  }
  
  @NotNull
  public final String component25()
  {
    return this.ta;
  }
  
  @NotNull
  public final String component26()
  {
    return this.fw;
  }
  
  @NotNull
  public final String component27()
  {
    return this.ffp;
  }
  
  @NotNull
  public final String component28()
  {
    return this.fc;
  }
  
  public final int component29()
  {
    return this.drawableId;
  }
  
  public final float component3()
  {
    return this.x;
  }
  
  public final int component30()
  {
    return this.hierarchy;
  }
  
  public final float component4()
  {
    return this.y;
  }
  
  public final int component5()
  {
    return this.ml;
  }
  
  public final int component6()
  {
    return this.mt;
  }
  
  public final int component7()
  {
    return this.mr;
  }
  
  public final int component8()
  {
    return this.mb;
  }
  
  public final int component9()
  {
    return this.pl;
  }
  
  @NotNull
  public final Style copy(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, @Nullable Border[] paramArrayOfBorder, float paramFloat5, boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2, int paramInt9, int paramInt10, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6, @NotNull String paramString7, int paramInt11, int paramInt12)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "bc");
    Intrinsics.checkParameterIsNotNull(paramString2, "bg");
    Intrinsics.checkParameterIsNotNull(paramString3, "ff");
    Intrinsics.checkParameterIsNotNull(paramString4, "ta");
    Intrinsics.checkParameterIsNotNull(paramString5, "fw");
    Intrinsics.checkParameterIsNotNull(paramString6, "ffp");
    Intrinsics.checkParameterIsNotNull(paramString7, "fc");
    return new Style(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfBorder, paramFloat5, paramBoolean, paramString1, paramString2, paramInt9, paramInt10, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramString3, paramString4, paramString5, paramString6, paramString7, paramInt11, paramInt12);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof Style))
      {
        paramObject = (Style)paramObject;
        if ((Float.compare(this.w, paramObject.w) != 0) || (Float.compare(this.h, paramObject.h) != 0) || (Float.compare(this.x, paramObject.x) != 0) || (Float.compare(this.y, paramObject.y) != 0) || (this.ml != paramObject.ml) || (this.mt != paramObject.mt) || (this.mr != paramObject.mr) || (this.mb != paramObject.mb) || (this.pl != paramObject.pl) || (this.pt != paramObject.pt) || (this.pr != paramObject.pr) || (this.pb != paramObject.pb) || (!Intrinsics.areEqual(this.borders, paramObject.borders)) || (Float.compare(this.op, paramObject.op) != 0) || (this.vi != paramObject.vi) || (!Intrinsics.areEqual(this.bc, paramObject.bc)) || (!Intrinsics.areEqual(this.bg, paramObject.bg)) || (this.rx != paramObject.rx) || (this.ry != paramObject.ry) || (Float.compare(this.elev, paramObject.elev) != 0) || (Float.compare(this.sx, paramObject.sx) != 0) || (Float.compare(this.sy, paramObject.sy) != 0) || (Float.compare(this.fs, paramObject.fs) != 0) || (!Intrinsics.areEqual(this.ff, paramObject.ff)) || (!Intrinsics.areEqual(this.ta, paramObject.ta)) || (!Intrinsics.areEqual(this.fw, paramObject.fw)) || (!Intrinsics.areEqual(this.ffp, paramObject.ffp)) || (!Intrinsics.areEqual(this.fc, paramObject.fc)) || (this.drawableId != paramObject.drawableId) || (this.hierarchy != paramObject.hierarchy)) {}
      }
    }
    else {
      return true;
    }
    return false;
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
  
  public final float getFs()
  {
    return this.fs;
  }
  
  @NotNull
  public final String getFw()
  {
    return this.fw;
  }
  
  public final float getH()
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
  
  public final int getRx()
  {
    return this.rx;
  }
  
  public final int getRy()
  {
    return this.ry;
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
  
  public final float getW()
  {
    return this.w;
  }
  
  public final float getX()
  {
    return this.x;
  }
  
  public final float getY()
  {
    return this.y;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
  
  public final void setFs(float paramFloat)
  {
    this.fs = paramFloat;
  }
  
  public final void setFw(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.fw = paramString;
  }
  
  public final void setH(float paramFloat)
  {
    this.h = paramFloat;
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
  
  public final void setRx(int paramInt)
  {
    this.rx = paramInt;
  }
  
  public final void setRy(int paramInt)
  {
    this.ry = paramInt;
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
  
  public final void setW(float paramFloat)
  {
    this.w = paramFloat;
  }
  
  public final void setX(float paramFloat)
  {
    this.x = paramFloat;
  }
  
  public final void setY(float paramFloat)
  {
    this.y = paramFloat;
  }
  
  @NotNull
  public String toString()
  {
    return "Style(w=" + this.w + ", h=" + this.h + ", x=" + this.x + ", y=" + this.y + ", ml=" + this.ml + ", mt=" + this.mt + ", mr=" + this.mr + ", mb=" + this.mb + ", pl=" + this.pl + ", pt=" + this.pt + ", pr=" + this.pr + ", pb=" + this.pb + ", borders=" + Arrays.toString(this.borders) + ", op=" + this.op + ", vi=" + this.vi + ", bc=" + this.bc + ", bg=" + this.bg + ", rx=" + this.rx + ", ry=" + this.ry + ", elev=" + this.elev + ", sx=" + this.sx + ", sy=" + this.sy + ", fs=" + this.fs + ", ff=" + this.ff + ", ta=" + this.ta + ", fw=" + this.fw + ", ffp=" + this.ffp + ", fc=" + this.fc + ", drawableId=" + this.drawableId + ", hierarchy=" + this.hierarchy + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.style.Style
 * JD-Core Version:    0.7.0.1
 */