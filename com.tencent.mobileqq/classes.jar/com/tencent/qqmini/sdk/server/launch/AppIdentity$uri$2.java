package com.tencent.qqmini.sdk.server.launch;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class AppIdentity$uri$2
  extends Lambda
  implements Function0<Uri>
{
  AppIdentity$uri$2(AppIdentity paramAppIdentity)
  {
    super(0);
  }
  
  public final Uri invoke()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("miniapp://launch/");
    localStringBuilder.append(Uri.encode(this.this$0.getAppId()));
    localStringBuilder.append('/');
    localStringBuilder.append(this.this$0.getVerType());
    return Uri.parse(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.AppIdentity.uri.2
 * JD-Core Version:    0.7.0.1
 */