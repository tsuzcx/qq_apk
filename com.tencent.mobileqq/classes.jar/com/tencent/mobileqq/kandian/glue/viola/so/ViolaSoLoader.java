package com.tencent.mobileqq.kandian.glue.viola.so;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.biz.fastweb.LoadLibCallback;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyWebRenderEngine;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/so/ViolaSoLoader;", "Lcom/tencent/mobileqq/kandian/glue/viola/so/IViolaSoLoader;", "violaSoNames", "", "", "([Ljava/lang/String;)V", "enablePreloadViolaEngine", "", "loadSuccess", "retryCount", "", "[Ljava/lang/String;", "isEngineReady", "loadLibrary", "", "from", "callback", "Lcom/tencent/mobileqq/kandian/biz/fastweb/LoadLibCallback;", "preLoadViola", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViolaSoLoader
  implements IViolaSoLoader
{
  public static final ViolaSoLoader.Companion a;
  private volatile int jdField_a_of_type_Int;
  private volatile boolean jdField_a_of_type_Boolean;
  private final String[] jdField_a_of_type_ArrayOfJavaLangString;
  private volatile boolean b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianGlueViolaSoViolaSoLoader$Companion = new ViolaSoLoader.Companion(null);
  }
  
  public ViolaSoLoader(@NotNull String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    paramArrayOfString = Aladdin.getConfig(433);
    boolean bool = false;
    if (paramArrayOfString.getIntegerFromString("enable_viola_preload", 0) == 1) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.b)) {
      a("preloadEngine");
    }
    if (ViolaAccessHelper.a()) {
      ViolaAccessHelper.a();
    }
  }
  
  public void a(@Nullable String paramString)
  {
    a(paramString, null);
  }
  
  public void a(@Nullable String paramString, @Nullable LoadLibCallback paramLoadLibCallback)
  {
    if (this.b)
    {
      if (paramLoadLibCallback != null) {
        paramLoadLibCallback.onFinish(ReadInJoyWebRenderEngine.g);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("viola loadLibrary from: ");
      localStringBuilder.append(paramString);
      QLog.d("ViolaSoLoader", 2, localStringBuilder.toString());
    }
    SoLoadManager.getInstance().loadSequentially(this.jdField_a_of_type_ArrayOfJavaLangString, (OnLoadListener)new ViolaSoLoader.loadLibrary.1(this, paramLoadLibCallback, paramString));
  }
  
  public boolean a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoader
 * JD-Core Version:    0.7.0.1
 */