package com.tencent.tkd.topicsdk.bean;

import .r8.java8methods.utility.Long.hashCode.IJ;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "publishInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicPublishInfo;", "(Lcom/tencent/tkd/topicsdk/bean/TopicPublishInfo;)V", "topicStr", "", "(Ljava/lang/String;)V", "topicId", "", "coverUrl", "title", "intro", "allowSubmit", "", "uid", "source", "", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJI)V", "getAllowSubmit", "()Z", "setAllowSubmit", "(Z)V", "getCoverUrl", "()Ljava/lang/String;", "setCoverUrl", "getIntro", "setIntro", "getSource", "()I", "setSource", "(I)V", "getTitle", "setTitle", "getTopicId", "()J", "setTopicId", "(J)V", "getUid", "setUid", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class TopicInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator CREATOR = new TopicInfo.Creator();
  public static final TopicInfo.Companion Companion = new TopicInfo.Companion(null);
  public static final int SOURCE_UGC = 5;
  @NotNull
  public static final String TAG = "TopicInfo";
  private boolean allowSubmit;
  @NotNull
  private String coverUrl;
  @NotNull
  private String intro;
  private int source;
  @NotNull
  private String title;
  private long topicId;
  private long uid;
  
  public TopicInfo()
  {
    this(0L, null, null, null, false, 0L, 0, 127, null);
  }
  
  public TopicInfo(long paramLong1, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, boolean paramBoolean, long paramLong2, int paramInt)
  {
    this.topicId = paramLong1;
    this.coverUrl = paramString1;
    this.title = paramString2;
    this.intro = paramString3;
    this.allowSubmit = paramBoolean;
    this.uid = paramLong2;
    this.source = paramInt;
  }
  
  public TopicInfo(@NotNull TopicPublishInfo paramTopicPublishInfo)
  {
    this(0L, paramTopicPublishInfo.a(), paramTopicPublishInfo.b(), paramTopicPublishInfo.c(), paramTopicPublishInfo.a(), 0L, 0, 96, null);
  }
  
  public TopicInfo(@NotNull String paramString)
  {
    this(0L, null, null, null, false, 0L, 0, 127, null);
    try
    {
      paramString = new JSONObject(paramString);
      this.topicId = paramString.optLong("topicId");
      String str = paramString.optString("coverUrl");
      Intrinsics.checkExpressionValueIsNotNull(str, "jsonObject.optString(\"coverUrl\")");
      this.coverUrl = str;
      str = paramString.optString("title");
      Intrinsics.checkExpressionValueIsNotNull(str, "jsonObject.optString(\"title\")");
      this.title = str;
      str = paramString.optString("intro");
      Intrinsics.checkExpressionValueIsNotNull(str, "jsonObject.optString(\"intro\")");
      this.intro = str;
      this.uid = paramString.optLong("uid");
      this.allowSubmit = paramString.optBoolean("allowSubmit");
      return;
    }
    catch (JSONException paramString)
    {
      label114:
      break label114;
    }
    TLog.d("TopicInfo", "constructor input an invalid jsonObject string!");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool3 = paramObject instanceof TopicInfo;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (this.topicId == ((TopicInfo)paramObject).topicId) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean getAllowSubmit()
  {
    return this.allowSubmit;
  }
  
  @NotNull
  public final String getCoverUrl()
  {
    return this.coverUrl;
  }
  
  @NotNull
  public final String getIntro()
  {
    return this.intro;
  }
  
  public final int getSource()
  {
    return this.source;
  }
  
  @NotNull
  public final String getTitle()
  {
    return this.title;
  }
  
  public final long getTopicId()
  {
    return this.topicId;
  }
  
  public final long getUid()
  {
    return this.uid;
  }
  
  public int hashCode()
  {
    return .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.topicId);
  }
  
  public final void setAllowSubmit(boolean paramBoolean)
  {
    this.allowSubmit = paramBoolean;
  }
  
  public final void setCoverUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.coverUrl = paramString;
  }
  
  public final void setIntro(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.intro = paramString;
  }
  
  public final void setSource(int paramInt)
  {
    this.source = paramInt;
  }
  
  public final void setTitle(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.title = paramString;
  }
  
  public final void setTopicId(long paramLong)
  {
    this.topicId = paramLong;
  }
  
  public final void setUid(long paramLong)
  {
    this.uid = paramLong;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("topicId", this.topicId);
    ((JSONObject)localObject).put("coverUrl", this.coverUrl);
    ((JSONObject)localObject).put("title", this.title);
    ((JSONObject)localObject).put("intro", this.intro);
    ((JSONObject)localObject).put("uid", this.uid);
    ((JSONObject)localObject).put("allowSubmit", this.allowSubmit);
    localObject = ((JSONObject)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "jsonObject.toString()");
    return localObject;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.TopicInfo
 * JD-Core Version:    0.7.0.1
 */