package com.tencent.mobileqq.kandian.biz.viola.api;

import android.os.Bundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaInitDelegate;", "", "disableSwitcher", "", "getCommonSuspensionGestureLayout", "getOriginalJsUrl", "", "initDataFromBundle", "bundle", "Landroid/os/Bundle;", "setCanCloseFromBottom", "canCloseFromBottom", "", "setUserVisibleHint", "isVisibleToUser", "updateViolaPageByData", "url", "data", "Lorg/json/JSONObject;", "updateViolaPageWhenScroll", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IViolaInitDelegate
{
  @Nullable
  public abstract Object a();
  
  @Nullable
  public abstract String a();
  
  public abstract void a();
  
  public abstract void a(@NotNull Bundle paramBundle);
  
  public abstract void a(@Nullable String paramString);
  
  public abstract void a(@Nullable String paramString, @Nullable JSONObject paramJSONObject);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.IViolaInitDelegate
 * JD-Core Version:    0.7.0.1
 */