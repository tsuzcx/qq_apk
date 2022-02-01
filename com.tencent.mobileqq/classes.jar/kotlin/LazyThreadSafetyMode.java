package kotlin;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/LazyThreadSafetyMode;", "", "(Ljava/lang/String;I)V", "SYNCHRONIZED", "PUBLICATION", "NONE", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public enum LazyThreadSafetyMode
{
  static
  {
    LazyThreadSafetyMode localLazyThreadSafetyMode1 = new LazyThreadSafetyMode("SYNCHRONIZED", 0);
    SYNCHRONIZED = localLazyThreadSafetyMode1;
    LazyThreadSafetyMode localLazyThreadSafetyMode2 = new LazyThreadSafetyMode("PUBLICATION", 1);
    PUBLICATION = localLazyThreadSafetyMode2;
    LazyThreadSafetyMode localLazyThreadSafetyMode3 = new LazyThreadSafetyMode("NONE", 2);
    NONE = localLazyThreadSafetyMode3;
    $VALUES = new LazyThreadSafetyMode[] { localLazyThreadSafetyMode1, localLazyThreadSafetyMode2, localLazyThreadSafetyMode3 };
  }
  
  private LazyThreadSafetyMode() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.LazyThreadSafetyMode
 * JD-Core Version:    0.7.0.1
 */