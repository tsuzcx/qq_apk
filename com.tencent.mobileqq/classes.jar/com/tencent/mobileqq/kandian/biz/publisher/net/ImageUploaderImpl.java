package com.tencent.mobileqq.kandian.biz.publisher.net;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.ugc.upload.IImageUploadListener;
import com.tencent.mobileqq.kandian.biz.ugc.upload.RIJUgcImageUploader;
import com.tencent.tkd.topicsdk.interfaces.BaseUploader;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/net/ImageUploaderImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/BaseUploader;", "()V", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "cancel", "", "pause", "resume", "resumeFromAppRestart", "p0", "", "upload", "path", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ImageUploaderImpl
  extends BaseUploader
{
  private final QQAppInterface e()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    if (localObject != null) {
      return (QQAppInterface)localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void a() {}
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "p0");
  }
  
  public void b() {}
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    int i;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    paramString = new RIJUgcImageUploader((Context)BaseApplicationImpl.getApplication(), e(), paramString);
    paramString.a((IImageUploadListener)new ImageUploaderImpl.upload.1(this));
    paramString.a();
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.net.ImageUploaderImpl
 * JD-Core Version:    0.7.0.1
 */