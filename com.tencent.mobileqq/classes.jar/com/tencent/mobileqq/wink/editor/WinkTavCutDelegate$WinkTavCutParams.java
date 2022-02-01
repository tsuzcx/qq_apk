package com.tencent.mobileqq.wink.editor;

import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/WinkTavCutDelegate$WinkTavCutParams;", "", "isInit", "", "editMode", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "winkEditData", "", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "templatePath", "", "width", "", "height", "(ZLcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;Ljava/util/List;Ljava/lang/String;II)V", "getEditMode", "()Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "getHeight", "()I", "()Z", "getTemplatePath", "()Ljava/lang/String;", "getWidth", "getWinkEditData", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class WinkTavCutDelegate$WinkTavCutParams
{
  private final boolean a;
  @NotNull
  private final WinkEditorViewModel.EditMode b;
  @NotNull
  private final List<WinkEditData> c;
  @Nullable
  private final String d;
  private final int e;
  private final int f;
  
  public WinkTavCutDelegate$WinkTavCutParams(boolean paramBoolean, @NotNull WinkEditorViewModel.EditMode paramEditMode, @NotNull List<WinkEditData> paramList, @Nullable String paramString, int paramInt1, int paramInt2)
  {
    this.a = paramBoolean;
    this.b = paramEditMode;
    this.c = paramList;
    this.d = paramString;
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public final boolean a()
  {
    return this.a;
  }
  
  @NotNull
  public final WinkEditorViewModel.EditMode b()
  {
    return this.b;
  }
  
  @NotNull
  public final List<WinkEditData> c()
  {
    return this.c;
  }
  
  @Nullable
  public final String d()
  {
    return this.d;
  }
  
  public final int e()
  {
    return this.e;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof WinkTavCutParams))
      {
        paramObject = (WinkTavCutParams)paramObject;
        if ((this.a == paramObject.a) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d)) && (this.e == paramObject.e) && (this.f == paramObject.f)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int f()
  {
    return this.f;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WinkTavCutParams(isInit=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", editMode=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", winkEditData=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", templatePath=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkTavCutDelegate.WinkTavCutParams
 * JD-Core Version:    0.7.0.1
 */