package cooperation.vip.impl;

import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebAccelerator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VasAdvAppImpl$initTbsEnvironment$1
  implements Runnable
{
  VasAdvAppImpl$initTbsEnvironment$1(VasAdvAppImpl paramVasAdvAppImpl) {}
  
  public final void run()
  {
    QbSdk.initTbsSettings(MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("use_speedy_classloader", Boolean.valueOf(true)), TuplesKt.to("use_dexloader_service", Boolean.valueOf(true)) }));
    WebAccelerator.initTbsEnvironment(this.this$0.a(), 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.impl.VasAdvAppImpl.initTbsEnvironment.1
 * JD-Core Version:    0.7.0.1
 */