package kotlin.reflect;

import kotlin.Metadata;
import kotlin.SinceKotlin;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KVisibility;", "", "(Ljava/lang/String;I)V", "PUBLIC", "PROTECTED", "INTERNAL", "PRIVATE", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
public enum KVisibility
{
  static
  {
    KVisibility localKVisibility1 = new KVisibility("PUBLIC", 0);
    PUBLIC = localKVisibility1;
    KVisibility localKVisibility2 = new KVisibility("PROTECTED", 1);
    PROTECTED = localKVisibility2;
    KVisibility localKVisibility3 = new KVisibility("INTERNAL", 2);
    INTERNAL = localKVisibility3;
    KVisibility localKVisibility4 = new KVisibility("PRIVATE", 3);
    PRIVATE = localKVisibility4;
    $VALUES = new KVisibility[] { localKVisibility1, localKVisibility2, localKVisibility3, localKVisibility4 };
  }
  
  private KVisibility() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.reflect.KVisibility
 * JD-Core Version:    0.7.0.1
 */