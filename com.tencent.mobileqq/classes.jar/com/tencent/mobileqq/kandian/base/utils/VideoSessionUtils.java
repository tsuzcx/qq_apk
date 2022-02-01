package com.tencent.mobileqq.kandian.base.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.base.MD5Utils;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/VideoSessionUtils;", "", "()V", "makeSessionID", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoSessionUtils
{
  public static final VideoSessionUtils a = new VideoSessionUtils();
  
  @JvmStatic
  @Nullable
  public static final String a()
  {
    if ((RIJQQAppInterfaceUtil.e() instanceof QQAppInterface))
    {
      localObject = RIJQQAppInterfaceUtil.e();
      if (localObject != null)
      {
        localObject = (QQAppInterface)localObject;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((QQAppInterface)localObject).getCurrentUin());
        localStringBuilder.append("_");
        localStringBuilder.append(System.currentTimeMillis());
        return MD5Utils.toMD5(localStringBuilder.toString());
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    return MD5Utils.toMD5(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.VideoSessionUtils
 * JD-Core Version:    0.7.0.1
 */