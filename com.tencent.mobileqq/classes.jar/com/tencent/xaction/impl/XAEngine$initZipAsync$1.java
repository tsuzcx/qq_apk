package com.tencent.xaction.impl;

import android.content.Context;
import com.tencent.xaction.api.IRuleManager;
import com.tencent.xaction.api.util.FileUtil;
import com.tencent.xaction.api.util.FileUtil.Companion;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class XAEngine$initZipAsync$1
  implements Runnable
{
  XAEngine$initZipAsync$1(XAEngine paramXAEngine, String paramString, Function0 paramFunction0) {}
  
  public final void run()
  {
    Object localObject1 = FileUtil.a;
    Object localObject2 = XAEngine.access$getContext$p(this.this$0);
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    localObject1 = ((FileUtil.Companion)localObject1).a((Context)localObject2, this.jdField_a_of_type_JavaLangString, false);
    if (localObject1 == null)
    {
      localObject1 = this.this$0;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(" 资源不存在");
      ((XAEngine)localObject1).logd("XAEngine", 1, ((StringBuilder)localObject2).toString());
      return;
    }
    XAEngine.access$getRuleManager$p(this.this$0).registerRuleLine("$PARENT_ROOT", localObject1);
    localObject2 = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("/xa.json");
    ((XAEngine)localObject2).initFromFileAsync(localStringBuilder.toString(), this.jdField_a_of_type_KotlinJvmFunctionsFunction0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.impl.XAEngine.initZipAsync.1
 * JD-Core Version:    0.7.0.1
 */