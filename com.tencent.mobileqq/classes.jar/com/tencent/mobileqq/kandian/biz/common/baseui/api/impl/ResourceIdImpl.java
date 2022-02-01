package com.tencent.mobileqq.kandian.biz.common.baseui.api.impl;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.kandian.biz.common.baseui.api.IResourceId;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/baseui/api/impl/ResourceIdImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/baseui/api/IResourceId;", "()V", "getCommonMaskView", "", "getId", "name", "", "getLayoutId", "getResourceId", "type", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ResourceIdImpl
  implements IResourceId
{
  public static final ResourceIdImpl.Companion Companion = new ResourceIdImpl.Companion(null);
  private static final String TAG = "ResourceIdImpl";
  private static final String TYPE_ID = "id";
  private static final String TYPE_LAYOUT = "layout";
  private static final HashMap<String, Integer> sResourceMap = new HashMap();
  
  private final int getResourceId(String paramString1, String paramString2)
  {
    try
    {
      ResourceIdImpl.Companion.a(Companion);
      localObject = sResourceMap.get(paramString2);
      if (localObject != null) {
        return ((Integer)localObject).intValue();
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label36:
      break label36;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("get ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" error, name:");
    ((StringBuilder)localObject).append(paramString2);
    QLog.e("ResourceIdImpl", 1, ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("get ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" error, name:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", id return 0");
    QLog.e("ResourceIdImpl", 1, ((StringBuilder)localObject).toString());
    return 0;
  }
  
  public int getCommonMaskView()
  {
    return 2131365017;
  }
  
  public int getId(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    return getResourceId("id", paramString);
  }
  
  public int getLayoutId(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    return getResourceId("layout", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.baseui.api.impl.ResourceIdImpl
 * JD-Core Version:    0.7.0.1
 */