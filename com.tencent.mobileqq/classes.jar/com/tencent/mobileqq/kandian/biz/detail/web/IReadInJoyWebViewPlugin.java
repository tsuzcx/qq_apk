package com.tencent.mobileqq.kandian.biz.detail.web;

import android.app.Activity;
import android.content.Intent;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/detail/web/IReadInJoyWebViewPlugin;", "", "getActivity", "Landroid/app/Activity;", "getApp", "Lmqq/app/AppRuntime;", "getCurrentUrl", "", "getPublicUin", "getUin", "getWebView", "startActivityForResult", "", "intent", "Landroid/content/Intent;", "requestCode", "", "switchRequestCode", "", "b", "", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyWebViewPlugin
{
  public static final IReadInJoyWebViewPlugin.Companion a = IReadInJoyWebViewPlugin.Companion.a;
  
  public abstract int a(byte paramByte, boolean paramBoolean);
  
  @NotNull
  public abstract AppRuntime a();
  
  @Nullable
  public abstract Object b();
  
  @Nullable
  public abstract String c();
  
  @Nullable
  public abstract String d();
  
  @Nullable
  public abstract Activity e();
  
  @Nullable
  public abstract String f();
  
  public abstract void startActivityForResult(@Nullable Intent paramIntent, byte paramByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.web.IReadInJoyWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */