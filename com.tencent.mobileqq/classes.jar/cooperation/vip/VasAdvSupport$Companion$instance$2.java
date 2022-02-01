package cooperation.vip;

import cooperation.vip.impl.VasAdvInterfaceBinder;
import cooperation.vip.impl.VasAdvInterfaceBinder.Companion;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcooperation/vip/VasAdvSupport;", "invoke"}, k=3, mv={1, 1, 16})
final class VasAdvSupport$Companion$instance$2
  extends Lambda
  implements Function0<VasAdvSupport>
{
  public static final 2 INSTANCE = new 2();
  
  VasAdvSupport$Companion$instance$2()
  {
    super(0);
  }
  
  @NotNull
  public final VasAdvSupport invoke()
  {
    return new VasAdvSupport(VasAdvInterfaceBinder.a.a(), VasAdvInterfaceBinder.a.a(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.VasAdvSupport.Companion.instance.2
 * JD-Core Version:    0.7.0.1
 */