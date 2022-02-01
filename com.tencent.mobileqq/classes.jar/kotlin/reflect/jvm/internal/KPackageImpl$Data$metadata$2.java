package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/Triple;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmNameResolver;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMetadataVersion;", "invoke"}, k=3, mv={1, 1, 16})
final class KPackageImpl$Data$metadata$2
  extends Lambda
  implements Function0<Triple<? extends JvmNameResolver, ? extends ProtoBuf.Package, ? extends JvmMetadataVersion>>
{
  KPackageImpl$Data$metadata$2(KPackageImpl.Data paramData)
  {
    super(0);
  }
  
  @Nullable
  public final Triple<JvmNameResolver, ProtoBuf.Package, JvmMetadataVersion> invoke()
  {
    Object localObject3 = KPackageImpl.Data.access$getKotlinClass$p(this.this$0);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((ReflectKotlinClass)localObject3).getClassHeader();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        String[] arrayOfString1 = ((KotlinClassHeader)localObject3).getData();
        String[] arrayOfString2 = ((KotlinClassHeader)localObject3).getStrings();
        localObject1 = localObject2;
        if (arrayOfString1 != null)
        {
          localObject1 = localObject2;
          if (arrayOfString2 != null)
          {
            localObject1 = JvmProtoBufUtil.readPackageDataFrom(arrayOfString1, arrayOfString2);
            localObject1 = new Triple((JvmNameResolver)((Pair)localObject1).component1(), (ProtoBuf.Package)((Pair)localObject1).component2(), ((KotlinClassHeader)localObject3).getMetadataVersion());
          }
        }
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KPackageImpl.Data.metadata.2
 * JD-Core Version:    0.7.0.1
 */