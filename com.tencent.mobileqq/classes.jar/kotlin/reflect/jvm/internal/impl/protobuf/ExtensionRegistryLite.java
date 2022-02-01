package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExtensionRegistryLite
{
  private static final ExtensionRegistryLite EMPTY = new ExtensionRegistryLite(true);
  private static volatile boolean eagerlyParseMessageSets = false;
  private final Map<ExtensionRegistryLite.ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;
  
  ExtensionRegistryLite()
  {
    this.extensionsByNumber = new HashMap();
  }
  
  private ExtensionRegistryLite(boolean paramBoolean)
  {
    this.extensionsByNumber = Collections.emptyMap();
  }
  
  public static ExtensionRegistryLite getEmptyRegistry()
  {
    return EMPTY;
  }
  
  public static ExtensionRegistryLite newInstance()
  {
    return new ExtensionRegistryLite();
  }
  
  public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> paramGeneratedExtension)
  {
    this.extensionsByNumber.put(new ExtensionRegistryLite.ObjectIntPair(paramGeneratedExtension.getContainingTypeDefaultInstance(), paramGeneratedExtension.getNumber()), paramGeneratedExtension);
  }
  
  public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType paramContainingType, int paramInt)
  {
    return (GeneratedMessageLite.GeneratedExtension)this.extensionsByNumber.get(new ExtensionRegistryLite.ObjectIntPair(paramContainingType, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
 * JD-Core Version:    0.7.0.1
 */