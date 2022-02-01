package cooperation.vip.impl;

import cooperation.vip.VasAdvAppInterface;
import cooperation.vip.VasAdvGdtInterface;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/impl/VasAdvInterfaceBinder$Companion;", "", "()V", "app", "Lcooperation/vip/VasAdvAppInterface;", "getApp", "()Lcooperation/vip/VasAdvAppInterface;", "app$delegate", "Lkotlin/Lazy;", "gdt", "Lcooperation/vip/VasAdvGdtInterface;", "getGdt", "()Lcooperation/vip/VasAdvGdtInterface;", "gdt$delegate", "appInterface", "gdtInterface", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasAdvInterfaceBinder$Companion
{
  private final VasAdvAppInterface b()
  {
    Lazy localLazy = VasAdvInterfaceBinder.a();
    Companion localCompanion = VasAdvInterfaceBinder.a;
    return (VasAdvAppInterface)localLazy.getValue();
  }
  
  private final VasAdvGdtInterface b()
  {
    Lazy localLazy = VasAdvInterfaceBinder.b();
    Companion localCompanion = VasAdvInterfaceBinder.a;
    return (VasAdvGdtInterface)localLazy.getValue();
  }
  
  @JvmStatic
  @NotNull
  public final VasAdvAppInterface a()
  {
    return ((Companion)this).b();
  }
  
  @JvmStatic
  @NotNull
  public final VasAdvGdtInterface a()
  {
    return ((Companion)this).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.impl.VasAdvInterfaceBinder.Companion
 * JD-Core Version:    0.7.0.1
 */