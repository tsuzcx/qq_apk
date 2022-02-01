package com.tencent.mobileqq.kandian.base.video.player.wrapper;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/PlayerVideoInfo;", "", "playType", "", "vid", "", "(ILjava/lang/String;)V", "urls", "", "(ILjava/lang/String;[Ljava/lang/String;)V", "pid", "isPreload", "", "duration", "", "playMode", "keepLastframe", "coverFrame", "hwCodec", "hwBackupUrls", "preloadDuration", "(ILjava/lang/String;[Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/String;ZZZLjava/lang/String;I)V", "getCoverFrame", "()Z", "setCoverFrame", "(Z)V", "getDuration", "()J", "setDuration", "(J)V", "getHwBackupUrls", "()Ljava/lang/String;", "setHwBackupUrls", "(Ljava/lang/String;)V", "getHwCodec", "setHwCodec", "setPreload", "getKeepLastframe", "setKeepLastframe", "getPid", "getPlayMode", "setPlayMode", "getPlayType", "()I", "getPreloadDuration", "setPreloadDuration", "(I)V", "getUrls", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getVid", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;[Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/String;ZZZLjava/lang/String;I)Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/PlayerVideoInfo;", "equals", "other", "hashCode", "toString", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class PlayerVideoInfo
{
  private final int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  @Nullable
  private final String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  @Nullable
  private final String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int;
  @Nullable
  private final String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  @Nullable
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  @Nullable
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  
  public PlayerVideoInfo(int paramInt, @Nullable String paramString)
  {
    this(paramInt, paramString, null);
  }
  
  public PlayerVideoInfo(int paramInt, @Nullable String paramString, @Nullable String[] paramArrayOfString)
  {
    this(paramInt, paramString, paramArrayOfString, null, false, 0L, null, false, false, false, null, 0, 4080, null);
  }
  
  public PlayerVideoInfo(int paramInt1, @Nullable String paramString1, @Nullable String[] paramArrayOfString, @Nullable String paramString2, boolean paramBoolean1, long paramLong, @Nullable String paramString3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, @Nullable String paramString4, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_c_of_type_Boolean = paramBoolean3;
    this.jdField_d_of_type_Boolean = paramBoolean4;
    this.jdField_d_of_type_JavaLangString = paramString4;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @Nullable
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public final void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public final void a(@Nullable String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  @Nullable
  public final String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  @Nullable
  public final String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public final void b(@Nullable String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public final void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public final void d(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof PlayerVideoInfo))
      {
        paramObject = (PlayerVideoInfo)paramObject;
        if ((this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (Intrinsics.areEqual(this.jdField_a_of_type_ArrayOfJavaLangString, paramObject.jdField_a_of_type_ArrayOfJavaLangString)) && (Intrinsics.areEqual(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Boolean == paramObject.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long) && (Intrinsics.areEqual(this.jdField_c_of_type_JavaLangString, paramObject.jdField_c_of_type_JavaLangString)) && (this.jdField_b_of_type_Boolean == paramObject.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean == paramObject.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean == paramObject.jdField_d_of_type_Boolean) && (Intrinsics.areEqual(this.jdField_d_of_type_JavaLangString, paramObject.jdField_d_of_type_JavaLangString)) && (this.jdField_b_of_type_Int == paramObject.jdField_b_of_type_Int)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayerVideoInfo(playType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", vid=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", urls=");
    localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString));
    localStringBuilder.append(", pid=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", isPreload=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", playMode=");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(", keepLastframe=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", coverFrame=");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append(", hwCodec=");
    localStringBuilder.append(this.jdField_d_of_type_Boolean);
    localStringBuilder.append(", hwBackupUrls=");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(", preloadDuration=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerVideoInfo
 * JD-Core Version:    0.7.0.1
 */