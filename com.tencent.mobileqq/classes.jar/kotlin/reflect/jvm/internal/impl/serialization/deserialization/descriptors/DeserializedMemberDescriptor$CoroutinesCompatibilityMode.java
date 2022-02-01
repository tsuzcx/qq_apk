package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

public enum DeserializedMemberDescriptor$CoroutinesCompatibilityMode
{
  static
  {
    CoroutinesCompatibilityMode localCoroutinesCompatibilityMode1 = new CoroutinesCompatibilityMode("COMPATIBLE", 0);
    COMPATIBLE = localCoroutinesCompatibilityMode1;
    CoroutinesCompatibilityMode localCoroutinesCompatibilityMode2 = new CoroutinesCompatibilityMode("NEEDS_WRAPPER", 1);
    NEEDS_WRAPPER = localCoroutinesCompatibilityMode2;
    CoroutinesCompatibilityMode localCoroutinesCompatibilityMode3 = new CoroutinesCompatibilityMode("INCOMPATIBLE", 2);
    INCOMPATIBLE = localCoroutinesCompatibilityMode3;
    $VALUES = new CoroutinesCompatibilityMode[] { localCoroutinesCompatibilityMode1, localCoroutinesCompatibilityMode2, localCoroutinesCompatibilityMode3 };
  }
  
  private DeserializedMemberDescriptor$CoroutinesCompatibilityMode() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.CoroutinesCompatibilityMode
 * JD-Core Version:    0.7.0.1
 */