package com.tencent.mobileqq.vas.ui;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ui/APNGDrawable;", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncDrawable;", "urlStr", "", "(Ljava/lang/String;)V", "options", "Lcom/tencent/mobileqq/vas/apng/api/ApngOptions;", "(Ljava/lang/String;Lcom/tencent/mobileqq/vas/apng/api/ApngOptions;)V", "filePath", "(Ljava/lang/String;Lcom/tencent/mobileqq/vas/apng/api/ApngOptions;Ljava/lang/String;)V", "checkURLDrawable", "", "doLoadTask", "", "callback", "Lcom/tencent/mobileqq/vas/ui/ILoaderSucessCallback;", "isLoadSucess", "postSubTask", "block", "Lkotlin/Function0;", "postUITask", "Companion", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public final class APNGDrawable
  extends AbsAsyncDrawable
{
  public static final APNGDrawable.Companion a = new APNGDrawable.Companion(null);
  private static boolean d;
  
  public APNGDrawable(@NotNull String paramString)
  {
    this(paramString, localApngOptions, str);
  }
  
  public APNGDrawable(@NotNull String paramString, @NotNull ApngOptions paramApngOptions)
  {
    this(paramString, paramApngOptions, str);
  }
  
  public APNGDrawable(@NotNull String paramString1, @NotNull ApngOptions paramApngOptions, @NotNull String paramString2)
  {
    b(paramApngOptions.d());
    a(paramApngOptions.e());
    c((Function0)new APNGDrawable.1(paramApngOptions));
    d((Function0)new APNGDrawable.2(paramString1, paramApngOptions, paramString2));
    f();
  }
  
  public void a(@NotNull ILoaderSucessCallback paramILoaderSucessCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramILoaderSucessCallback, "callback");
    if (d)
    {
      paramILoaderSucessCallback.a();
      return;
    }
    ThreadManagerV2.executeOnFileThread((Runnable)new APNGDrawable.doLoadTask.1(this, paramILoaderSucessCallback));
  }
  
  public void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new APNGDrawable.sam.java_lang_Runnable.0(paramFunction0));
  }
  
  public boolean a()
  {
    if (d) {
      return true;
    }
    d = b();
    return d;
  }
  
  public void b(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    ThreadManagerV2.executeOnSubThread((Runnable)new APNGDrawable.sam.java_lang_Runnable.0(paramFunction0));
  }
  
  public final boolean b()
  {
    try
    {
      new URL("vasapngdownloader", "", "");
      return true;
    }
    catch (Exception localException)
    {
      label16:
      break label16;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.APNGDrawable
 * JD-Core Version:    0.7.0.1
 */