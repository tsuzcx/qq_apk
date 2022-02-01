package com.tencent.xaction.impl;

import android.text.TextUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "status", "", "filePath", "invoke"}, k=3, mv={1, 1, 16})
final class XAEngine$initFromUrlAsync$1
  extends Lambda
  implements Function2<String, String, Unit>
{
  XAEngine$initFromUrlAsync$1(XAEngine paramXAEngine, Function0 paramFunction0)
  {
    super(2);
  }
  
  public final void invoke(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "status");
    Intrinsics.checkParameterIsNotNull(paramString2, "filePath");
    if (Intrinsics.areEqual(paramString1, "success"))
    {
      paramString1 = (CharSequence)paramString2;
      if (!TextUtils.isEmpty(paramString1))
      {
        Object localObject = this.this$0;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("requestFile success ");
        localStringBuilder.append(paramString2);
        ((XAEngine)localObject).logi("XAEngine", 2, localStringBuilder.toString());
        localObject = new File(paramString2);
        if (((File)localObject).exists())
        {
          if (((File)localObject).isDirectory())
          {
            this.this$0.initRootAsync(paramString2, this.$callback);
            return;
          }
          if ((((File)localObject).isFile()) && (StringsKt.contains$default(paramString1, (CharSequence)".zip", false, 2, null)))
          {
            this.this$0.initZipAsync(paramString2, this.$callback);
            return;
          }
          if (StringsKt.contains$default(paramString1, (CharSequence)".json", false, 2, null)) {
            this.this$0.initFromFileAsync(paramString2, this.$callback);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.impl.XAEngine.initFromUrlAsync.1
 * JD-Core Version:    0.7.0.1
 */