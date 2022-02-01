package com.tencent.xaction;

import android.support.v4.util.MQLruCache;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/XALottieView$Companion;", "", "()V", "KEY_CONFIG", "", "KEY_IMAGE_PATH", "TAG", "mqLruCache", "Landroid/support/v4/util/MQLruCache;", "mqLruCache$annotations", "getMqLruCache", "()Landroid/support/v4/util/MQLruCache;", "setMqLruCache", "(Landroid/support/v4/util/MQLruCache;)V", "XALottie_release"}, k=1, mv={1, 1, 16})
public final class XALottieView$Companion
{
  @Nullable
  public final MQLruCache<String, Object> a()
  {
    return XALottieView.access$getMqLruCache$cp();
  }
  
  public final void a(@Nullable MQLruCache<String, Object> paramMQLruCache)
  {
    XALottieView.access$setMqLruCache$cp(paramMQLruCache);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.XALottieView.Companion
 * JD-Core Version:    0.7.0.1
 */