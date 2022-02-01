package cooperation.vip;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/VasAdvSupport$Companion;", "", "()V", "instance", "Lcooperation/vip/VasAdvSupport;", "getInstance", "()Lcooperation/vip/VasAdvSupport;", "instance$delegate", "Lkotlin/Lazy;", "get", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasAdvSupport$Companion
{
  private final VasAdvSupport b()
  {
    Lazy localLazy = VasAdvSupport.a();
    Companion localCompanion = VasAdvSupport.a;
    return (VasAdvSupport)localLazy.getValue();
  }
  
  @JvmStatic
  @NotNull
  public final VasAdvSupport a()
  {
    return ((Companion)this).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.VasAdvSupport.Companion
 * JD-Core Version:    0.7.0.1
 */