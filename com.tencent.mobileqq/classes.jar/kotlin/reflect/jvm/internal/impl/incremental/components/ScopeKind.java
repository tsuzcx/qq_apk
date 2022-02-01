package kotlin.reflect.jvm.internal.impl.incremental.components;

public enum ScopeKind
{
  static
  {
    ScopeKind localScopeKind1 = new ScopeKind("PACKAGE", 0);
    PACKAGE = localScopeKind1;
    ScopeKind localScopeKind2 = new ScopeKind("CLASSIFIER", 1);
    CLASSIFIER = localScopeKind2;
    $VALUES = new ScopeKind[] { localScopeKind1, localScopeKind2 };
  }
  
  private ScopeKind() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.incremental.components.ScopeKind
 * JD-Core Version:    0.7.0.1
 */