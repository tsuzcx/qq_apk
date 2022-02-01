package com.tencent.mobileqq.kandian.glue.viola.so;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.biz.fastweb.LoadLibCallback;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/so/ViolaSoLoaderManager;", "Lcom/tencent/mobileqq/kandian/glue/viola/so/IViolaSoLoader;", "()V", "soLoader", "useViolaJSCLoader", "", "getViolaSoName", "", "", "loaderType", "", "(I)[Ljava/lang/String;", "isEngineReady", "loadLibrary", "", "from", "callback", "Lcom/tencent/mobileqq/kandian/biz/fastweb/LoadLibCallback;", "preLoadViola", "useLegacyLoader", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViolaSoLoaderManager
  implements IViolaSoLoader
{
  public static final ViolaSoLoaderManager.Companion a;
  @NotNull
  private static final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0)ViolaSoLoaderManager.Companion.instance.2.INSTANCE);
  @NotNull
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "viola_jsc", "viola" };
  @NotNull
  private static final String[] b = { "jsc", "viola2" };
  private IViolaSoLoader jdField_a_of_type_ComTencentMobileqqKandianGlueViolaSoIViolaSoLoader;
  private volatile boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianGlueViolaSoViolaSoLoaderManager$Companion = new ViolaSoLoaderManager.Companion(null);
  }
  
  public ViolaSoLoaderManager()
  {
    Object localObject = Aladdin.getConfig(432);
    boolean bool = false;
    int i = ((AladdinConfig)localObject).getIntegerFromString("viola_so_loader", 0);
    if (i != 0) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    if (this.jdField_a_of_type_Boolean) {
      localObject = (IViolaSoLoader)new ViolaSoLoader(a(i));
    } else {
      localObject = (IViolaSoLoader)new ViolaSoLegacyLoader();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaSoIViolaSoLoader = ((IViolaSoLoader)localObject);
  }
  
  private final String[] a(int paramInt)
  {
    if (paramInt == 1) {
      return jdField_a_of_type_ArrayOfJavaLangString;
    }
    return b;
  }
  
  public void a()
  {
    IViolaSoLoader localIViolaSoLoader = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaSoIViolaSoLoader;
    if (localIViolaSoLoader != null) {
      localIViolaSoLoader.a();
    }
  }
  
  public void a(@Nullable String paramString, @Nullable LoadLibCallback paramLoadLibCallback)
  {
    IViolaSoLoader localIViolaSoLoader = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaSoIViolaSoLoader;
    if (localIViolaSoLoader != null) {
      localIViolaSoLoader.a(paramString, paramLoadLibCallback);
    }
  }
  
  public boolean a()
  {
    IViolaSoLoader localIViolaSoLoader = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaSoIViolaSoLoader;
    if (localIViolaSoLoader != null) {
      return localIViolaSoLoader.a();
    }
    return false;
  }
  
  public final boolean b()
  {
    return this.jdField_a_of_type_Boolean ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager
 * JD-Core Version:    0.7.0.1
 */