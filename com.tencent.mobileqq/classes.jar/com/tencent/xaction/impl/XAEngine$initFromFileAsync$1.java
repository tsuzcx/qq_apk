package com.tencent.xaction.impl;

import android.os.Handler;
import com.google.gson.Gson;
import com.tencent.xaction.api.data.AnimData;
import com.tencent.xaction.api.util.FileUtil;
import com.tencent.xaction.api.util.FileUtil.Companion;
import com.tencent.xaction.api.util.GsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class XAEngine$initFromFileAsync$1
  implements Runnable
{
  XAEngine$initFromFileAsync$1(XAEngine paramXAEngine, String paramString, Function0 paramFunction0) {}
  
  public final void run()
  {
    Object localObject = FileUtil.a.a(this.jdField_a_of_type_JavaLangString);
    if (localObject != null)
    {
      XAEngine.access$setAnimData$p(this.this$0, (AnimData)GsonAdapter.a().fromJson((String)localObject, AnimData.class));
      localObject = this.this$0.getUiHandler();
      if (localObject != null) {
        ((Handler)localObject).post((Runnable)new XAEngine.initFromFileAsync.1.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.impl.XAEngine.initFromFileAsync.1
 * JD-Core Version:    0.7.0.1
 */