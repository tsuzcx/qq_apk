package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

public final class NullDefaultValue
  extends AnnotationDefaultValue
{
  public static final NullDefaultValue INSTANCE = new NullDefaultValue();
  
  private NullDefaultValue()
  {
    super(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.descriptors.NullDefaultValue
 * JD-Core Version:    0.7.0.1
 */