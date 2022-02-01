package com.tencent.mobileqq.flashshow.preload.coldboot;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FSColdBootPreloadFeedManager$RedPointParam
{
  @NonNull
  String a = "";
  @NonNull
  String b = "";
  @NonNull
  String c = "";
  
  public static RedPointParam a(String paramString)
  {
    RedPointParam localRedPointParam = new RedPointParam();
    if (TextUtils.isEmpty(paramString)) {
      return localRedPointParam;
    }
    Uri localUri = Uri.parse(paramString);
    if (localUri.getQueryParameter("badgetype") != null) {
      localRedPointParam.a = localUri.getQueryParameter("badgetype");
    }
    if (localUri.getQueryParameter("extinfo") != null) {
      localRedPointParam.b = localUri.getQueryParameter("extinfo");
    }
    localRedPointParam.c = paramString;
    return localRedPointParam;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof RedPointParam)) {
      return false;
    }
    paramObject = (RedPointParam)paramObject;
    return (this.a.equals(paramObject.a)) && (this.b.equals(paramObject.b));
  }
  
  public int hashCode()
  {
    return this.a.hashCode() + this.b.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.preload.coldboot.FSColdBootPreloadFeedManager.RedPointParam
 * JD-Core Version:    0.7.0.1
 */