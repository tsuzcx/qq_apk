package com.tencent.tkd.topicsdk.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/TopicPublishInfo;", "Landroid/os/Parcelable;", "topicInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "(Lcom/tencent/tkd/topicsdk/bean/TopicInfo;)V", "coverUrl", "", "title", "intro", "allowSubmit", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getAllowSubmit", "()Z", "getCoverUrl", "()Ljava/lang/String;", "setCoverUrl", "(Ljava/lang/String;)V", "getIntro", "setIntro", "getTitle", "setTitle", "describeContents", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "topicsdk_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class TopicPublishInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new TopicPublishInfo.Creator();
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean;
  @NotNull
  private String b;
  @NotNull
  private String c;
  
  public TopicPublishInfo(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    return "TopicPublishInfo { " + "coverUrl = " + this.jdField_a_of_type_JavaLangString + ", " + "title = " + this.b + ", " + "intro = " + this.c + ',' + "allowSubmit = " + this.jdField_a_of_type_Boolean + " }";
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.TopicPublishInfo
 * JD-Core Version:    0.7.0.1
 */