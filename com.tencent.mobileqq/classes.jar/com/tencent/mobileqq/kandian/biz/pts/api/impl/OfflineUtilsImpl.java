package com.tencent.mobileqq.kandian.biz.pts.api.impl;

import com.tencent.mobileqq.kandian.biz.pts.api.IOfflineUtils;
import com.tencent.mobileqq.kandian.biz.pts.util.OfflineUtils;
import java.io.InputStream;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/api/impl/OfflineUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/pts/api/IOfflineUtils;", "()V", "checkOfflineDirExist", "", "init", "preCache", "isBackground", "", "readInputStreamAsString", "", "inputStream", "Ljava/io/InputStream;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class OfflineUtilsImpl
  implements IOfflineUtils
{
  public void checkOfflineDirExist() {}
  
  public void init() {}
  
  public void preCache(boolean paramBoolean)
  {
    OfflineUtils.a(paramBoolean);
  }
  
  @Nullable
  public String readInputStreamAsString(@Nullable InputStream paramInputStream)
  {
    return OfflineUtils.b(paramInputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.api.impl.OfflineUtilsImpl
 * JD-Core Version:    0.7.0.1
 */