package com.tencent.mobileqq.kandian.glue.viola.so;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.LoadLibCallback;
import com.tencent.mobileqq.kandian.glue.viola.ViolaBizLibHandler;
import com.tencent.mobileqq.kandian.glue.viola.ViolaLibHandler;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/so/ViolaSoLoaderManager;", "Lcom/tencent/mobileqq/kandian/glue/viola/so/IViolaSoLoader;", "()V", "enableOnePageOneRuntime", "", "jscLoader", "Lcom/tencent/mobileqq/kandian/glue/viola/so/ViolaSoLegacyLoader;", "loaderType", "", "soLoader", "useV8SoLoader", "getJscSoUrl", "", "getRuntimeMode", "getV8SoName", "", "()[Ljava/lang/String;", "getViolaSoName", "(I)[Ljava/lang/String;", "innerLoadLibrary", "", "from", "callback", "Lcom/tencent/mobileqq/kandian/biz/fastweb/LoadLibCallback;", "isEngineReady", "loadLibrary", "multiV8Instance", "preLoadViola", "switchToJSCLoader", "updateViolaSoExist", "useLegacyLoader", "usingV8", "violaSoExist", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViolaSoLoaderManager
  implements IViolaSoLoader
{
  public static final ViolaSoLoaderManager.Companion a = new ViolaSoLoaderManager.Companion(null);
  @NotNull
  private static final Lazy g = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0)ViolaSoLoaderManager.Companion.instance.2.INSTANCE);
  private volatile boolean b;
  private IViolaSoLoader c;
  private volatile int d;
  private boolean e;
  private ViolaSoLegacyLoader f;
  
  public ViolaSoLoaderManager()
  {
    boolean bool2 = true;
    this.e = true;
    this.f = new ViolaSoLegacyLoader();
    this.d = Aladdin.getConfig(432).getIntegerFromString("viola_so_loader", 4);
    boolean bool1;
    if (this.d != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.b = bool1;
    IViolaSoLoader localIViolaSoLoader;
    if (this.b) {
      localIViolaSoLoader = (IViolaSoLoader)new ViolaSoLoader(a(this.d));
    } else {
      localIViolaSoLoader = (IViolaSoLoader)new ViolaSoLegacyLoader();
    }
    this.c = localIViolaSoLoader;
    if (Aladdin.getConfig(530).getIntegerFromString("enable_one_page_one_runtime", 1) == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.e = bool1;
  }
  
  private final String[] a(int paramInt)
  {
    return l();
  }
  
  private final void b(String paramString, LoadLibCallback paramLoadLibCallback)
  {
    IViolaSoLoader localIViolaSoLoader = this.c;
    if (localIViolaSoLoader != null) {
      localIViolaSoLoader.a(paramString, (LoadLibCallback)new ViolaSoLoaderManager.innerLoadLibrary.1(this, paramString, paramLoadLibCallback));
    }
    paramLoadLibCallback = new StringBuilder();
    paramLoadLibCallback.append("start load library. from: ");
    paramLoadLibCallback.append(paramString);
    paramLoadLibCallback.append(", loaderType: ");
    paramLoadLibCallback.append(this.d);
    QLog.w("ViolaSoLoaderManager", 1, paramLoadLibCallback.toString());
  }
  
  private final String[] l()
  {
    return new String[] { "j2v8-android-armeabi-v7a" };
  }
  
  private final void m()
  {
    this.c = ((IViolaSoLoader)this.f);
    this.b = false;
    this.d = 0;
  }
  
  public void a()
  {
    IViolaSoLoader localIViolaSoLoader = this.c;
    if (localIViolaSoLoader != null) {
      localIViolaSoLoader.a();
    }
  }
  
  public void a(@Nullable String paramString, @Nullable LoadLibCallback paramLoadLibCallback)
  {
    b(paramString, paramLoadLibCallback);
  }
  
  public boolean b()
  {
    IViolaSoLoader localIViolaSoLoader = this.c;
    if (localIViolaSoLoader != null) {
      return localIViolaSoLoader.b();
    }
    return false;
  }
  
  public final boolean c()
  {
    return (this.d == 3) || (this.d == 4);
  }
  
  public final boolean d()
  {
    return this.e;
  }
  
  public final boolean e()
  {
    return this.b ^ true;
  }
  
  public final boolean f()
  {
    int i = this.d;
    boolean bool2 = false;
    if (i != 0)
    {
      if ((i != 3) && (i != 4)) {
        return false;
      }
      Object localObject = RIJSPUtils.d("viola_use_v8", Boolean.valueOf(false), false);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJSPUtils.getReadInJoyS…OLA_USE_V8, false, false)");
      return ((Boolean)localObject).booleanValue();
    }
    boolean bool1 = bool2;
    if (ViolaBizLibHandler.x())
    {
      bool1 = bool2;
      if (ViolaLibHandler.w()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void g()
  {
    String str = (String)null;
    int i = this.d;
    if ((i == 3) || (i == 4)) {
      str = "viola_use_v8";
    }
    if (str != null) {
      RIJSPUtils.c(str, Boolean.valueOf(true), false);
    }
  }
  
  public final boolean h()
  {
    return this.d == 4;
  }
  
  public final int i()
  {
    int i = this.d;
    if (i != 3)
    {
      if (i != 4) {
        return 0;
      }
      return 2;
    }
    return 1;
  }
  
  @NotNull
  public final String j()
  {
    return "https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager
 * JD-Core Version:    0.7.0.1
 */