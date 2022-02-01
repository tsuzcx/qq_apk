package com.tencent.mobileqq.kandian.base.utils.api.impl;

import com.tencent.mobileqq.kandian.base.utils.JSONUtils;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJR5JsonManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/api/impl/RIJR5JsonManagerImpl;", "Lcom/tencent/mobileqq/kandian/base/utils/api/IRIJR5JsonManager;", "()V", "getJSONArray", "Lorg/json/JSONArray;", "jsonString", "", "name", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJR5JsonManagerImpl
  implements IRIJR5JsonManager
{
  @Nullable
  public JSONArray getJSONArray(@Nullable String paramString1, @Nullable String paramString2)
  {
    return JSONUtils.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.api.impl.RIJR5JsonManagerImpl
 * JD-Core Version:    0.7.0.1
 */