package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstUtil;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaPropertyDescriptor
  extends PropertyDescriptorImpl
  implements JavaCallableMemberDescriptor
{
  private final boolean isStaticFinal;
  @Nullable
  private final Pair<CallableDescriptor.UserDataKey<?>, ?> singleUserData;
  
  protected JavaPropertyDescriptor(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Annotations paramAnnotations, @NotNull Modality paramModality, @NotNull Visibility paramVisibility, boolean paramBoolean1, @NotNull Name paramName, @NotNull SourceElement paramSourceElement, @Nullable PropertyDescriptor paramPropertyDescriptor, @NotNull CallableMemberDescriptor.Kind paramKind, boolean paramBoolean2, @Nullable Pair<CallableDescriptor.UserDataKey<?>, ?> paramPair)
  {
    super(paramDeclarationDescriptor, paramPropertyDescriptor, paramAnnotations, paramModality, paramVisibility, paramBoolean1, paramName, paramKind, paramSourceElement, false, false, false, false, false, false);
    this.isStaticFinal = paramBoolean2;
    this.singleUserData = paramPair;
  }
  
  @NotNull
  public static JavaPropertyDescriptor create(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Annotations paramAnnotations, @NotNull Modality paramModality, @NotNull Visibility paramVisibility, boolean paramBoolean1, @NotNull Name paramName, @NotNull SourceElement paramSourceElement, boolean paramBoolean2)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(7);
    }
    if (paramAnnotations == null) {
      $$$reportNull$$$0(8);
    }
    if (paramModality == null) {
      $$$reportNull$$$0(9);
    }
    if (paramVisibility == null) {
      $$$reportNull$$$0(10);
    }
    if (paramName == null) {
      $$$reportNull$$$0(11);
    }
    if (paramSourceElement == null) {
      $$$reportNull$$$0(12);
    }
    return new JavaPropertyDescriptor(paramDeclarationDescriptor, paramAnnotations, paramModality, paramVisibility, paramBoolean1, paramName, paramSourceElement, null, CallableMemberDescriptor.Kind.DECLARATION, paramBoolean2, null);
  }
  
  @NotNull
  protected PropertyDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Modality paramModality, @NotNull Visibility paramVisibility, @Nullable PropertyDescriptor paramPropertyDescriptor, @NotNull CallableMemberDescriptor.Kind paramKind, @NotNull Name paramName, @NotNull SourceElement paramSourceElement)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(13);
    }
    if (paramModality == null) {
      $$$reportNull$$$0(14);
    }
    if (paramVisibility == null) {
      $$$reportNull$$$0(15);
    }
    if (paramKind == null) {
      $$$reportNull$$$0(16);
    }
    if (paramName == null) {
      $$$reportNull$$$0(17);
    }
    if (paramSourceElement == null) {
      $$$reportNull$$$0(18);
    }
    return new JavaPropertyDescriptor(paramDeclarationDescriptor, getAnnotations(), paramModality, paramVisibility, isVar(), paramName, paramSourceElement, paramPropertyDescriptor, paramKind, this.isStaticFinal, this.singleUserData);
  }
  
  @NotNull
  public JavaCallableMemberDescriptor enhance(@Nullable KotlinType paramKotlinType1, @NotNull List<ValueParameterData> paramList, @NotNull KotlinType paramKotlinType2, @Nullable Pair<CallableDescriptor.UserDataKey<?>, ?> paramPair)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a22 = a10\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\nCaused by: java.lang.NullPointerException\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\r\n\t... 17 more\r\n");
  }
  
  @Nullable
  public <V> V getUserData(CallableDescriptor.UserDataKey<V> paramUserDataKey)
  {
    Pair localPair = this.singleUserData;
    if ((localPair != null) && (((CallableDescriptor.UserDataKey)localPair.getFirst()).equals(paramUserDataKey))) {
      return this.singleUserData.getSecond();
    }
    return null;
  }
  
  public boolean hasSynthesizedParameterNames()
  {
    return false;
  }
  
  public boolean isConst()
  {
    KotlinType localKotlinType = getType();
    return (this.isStaticFinal) && (ConstUtil.canBeUsedForConstVal(localKotlinType)) && ((!TypeEnhancementKt.hasEnhancedNullability(localKotlinType)) || (KotlinBuiltIns.isString(localKotlinType)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor
 * JD-Core Version:    0.7.0.1
 */