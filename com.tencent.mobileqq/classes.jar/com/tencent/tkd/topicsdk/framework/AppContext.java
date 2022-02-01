package com.tencent.tkd.topicsdk.framework;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/AppContext;", "", "()V", "instance", "Landroid/content/Context;", "getInstance", "()Landroid/content/Context;", "topicsdk_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"StaticFieldLeak"})
public final class AppContext
{
  @NotNull
  private static final Context a;
  public static final AppContext a;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkFrameworkAppContext = new AppContext();
    jdField_a_of_type_AndroidContentContext = TopicSDK.a.a().a().a();
  }
  
  @NotNull
  public final Context a()
  {
    return jdField_a_of_type_AndroidContentContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.AppContext
 * JD-Core Version:    0.7.0.1
 */