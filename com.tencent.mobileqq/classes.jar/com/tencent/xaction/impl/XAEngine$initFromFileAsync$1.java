package com.tencent.xaction.impl;

import com.tencent.xaction.api.util.FileUtil;
import com.tencent.xaction.api.util.FileUtil.Companion;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class XAEngine$initFromFileAsync$1
  implements Runnable
{
  XAEngine$initFromFileAsync$1(XAEngine paramXAEngine, String paramString, Function0 paramFunction0) {}
  
  public final void run()
  {
    String str = FileUtil.a.b(this.jdField_a_of_type_JavaLangString);
    if (str != null) {
      this.this$0.initAsync(str, this.jdField_a_of_type_KotlinJvmFunctionsFunction0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.impl.XAEngine.initFromFileAsync.1
 * JD-Core Version:    0.7.0.1
 */