package com.tencent.tkd.topicsdk.common;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Parcelable;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/common/PictureUtil;", "", "()V", "TAG", "", "getImagePath", "context", "Landroid/content/Context;", "data", "Landroid/content/Intent;", "uri", "Landroid/net/Uri;", "selection", "makeCropFile", "Ljava/io/File;", "makePicCutIntent", "pathUri", "cropUri", "startPicCutActivityForResult", "Landroid/app/Activity;", "code", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PictureUtil
{
  public static final PictureUtil a = new PictureUtil();
  
  private final Intent a(Uri paramUri1, Uri paramUri2)
  {
    Intent localIntent = new Intent("com.android.camera.action.CROP");
    if (Build.VERSION.SDK_INT >= 24) {
      localIntent.addFlags(1);
    }
    localIntent.setDataAndType(paramUri1, "image/*");
    localIntent.putExtra("crop", "true");
    paramUri1 = Build.MANUFACTURER;
    Intrinsics.checkExpressionValueIsNotNull(paramUri1, "Build.MANUFACTURER");
    if (paramUri1 != null)
    {
      paramUri1 = paramUri1.toLowerCase();
      Intrinsics.checkExpressionValueIsNotNull(paramUri1, "(this as java.lang.String).toLowerCase()");
      if (Intrinsics.areEqual(paramUri1, "huawei"))
      {
        localIntent.putExtra("aspectX", 9998);
        localIntent.putExtra("aspectY", 9999);
      }
      else
      {
        localIntent.putExtra("aspectX", 1);
        localIntent.putExtra("aspectY", 1);
      }
      localIntent.putExtra("circleCrop", false);
      localIntent.putExtra("scale", true);
      localIntent.putExtra("return-data", false);
      localIntent.putExtra("output", (Parcelable)paramUri2);
      localIntent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
      localIntent.putExtra("noFaceDetection", true);
      return localIntent;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private final File a()
  {
    File localFile = new File(TopicSDKHelperKt.b());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CropImage_");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(".jpg");
    localFile = new File(localFile, localStringBuilder.toString());
    try
    {
      if (localFile.exists())
      {
        localFile.delete();
        TLog.d("PictureUtil", "delete");
        return localFile;
      }
    }
    catch (Exception localException)
    {
      TLog.b("PictureUtil", "onCapturePic", (Throwable)localException);
    }
    return localFile;
  }
  
  @NotNull
  public final String a(@NotNull Activity paramActivity, @NotNull Uri paramUri, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "context");
    Intrinsics.checkParameterIsNotNull(paramUri, "pathUri");
    File localFile = a();
    Uri localUri = Uri.fromFile(localFile);
    Intrinsics.checkExpressionValueIsNotNull(localUri, "Uri.fromFile(cropFile)");
    paramActivity.startActivityForResult(a(paramUri, localUri), paramInt);
    paramActivity = localFile.getAbsolutePath();
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "cropFile.absolutePath");
    return paramActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.PictureUtil
 * JD-Core Version:    0.7.0.1
 */