package kotlin.reflect;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KParameter$Kind;", "", "(Ljava/lang/String;I)V", "INSTANCE", "EXTENSION_RECEIVER", "VALUE", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public enum KParameter$Kind
{
  static
  {
    Kind localKind1 = new Kind("INSTANCE", 0);
    INSTANCE = localKind1;
    Kind localKind2 = new Kind("EXTENSION_RECEIVER", 1);
    EXTENSION_RECEIVER = localKind2;
    Kind localKind3 = new Kind("VALUE", 2);
    VALUE = localKind3;
    $VALUES = new Kind[] { localKind1, localKind2, localKind3 };
  }
  
  private KParameter$Kind() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.reflect.KParameter.Kind
 * JD-Core Version:    0.7.0.1
 */