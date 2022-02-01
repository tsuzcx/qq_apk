package kotlin;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/DeprecationLevel;", "", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "HIDDEN", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public enum DeprecationLevel
{
  static
  {
    DeprecationLevel localDeprecationLevel1 = new DeprecationLevel("WARNING", 0);
    WARNING = localDeprecationLevel1;
    DeprecationLevel localDeprecationLevel2 = new DeprecationLevel("ERROR", 1);
    ERROR = localDeprecationLevel2;
    DeprecationLevel localDeprecationLevel3 = new DeprecationLevel("HIDDEN", 2);
    HIDDEN = localDeprecationLevel3;
    $VALUES = new DeprecationLevel[] { localDeprecationLevel1, localDeprecationLevel2, localDeprecationLevel3 };
  }
  
  private DeprecationLevel() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.DeprecationLevel
 * JD-Core Version:    0.7.0.1
 */