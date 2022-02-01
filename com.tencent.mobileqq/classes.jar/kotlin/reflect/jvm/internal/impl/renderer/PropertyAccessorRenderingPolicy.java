package kotlin.reflect.jvm.internal.impl.renderer;

public enum PropertyAccessorRenderingPolicy
{
  static
  {
    PropertyAccessorRenderingPolicy localPropertyAccessorRenderingPolicy1 = new PropertyAccessorRenderingPolicy("PRETTY", 0);
    PRETTY = localPropertyAccessorRenderingPolicy1;
    PropertyAccessorRenderingPolicy localPropertyAccessorRenderingPolicy2 = new PropertyAccessorRenderingPolicy("DEBUG", 1);
    DEBUG = localPropertyAccessorRenderingPolicy2;
    PropertyAccessorRenderingPolicy localPropertyAccessorRenderingPolicy3 = new PropertyAccessorRenderingPolicy("NONE", 2);
    NONE = localPropertyAccessorRenderingPolicy3;
    $VALUES = new PropertyAccessorRenderingPolicy[] { localPropertyAccessorRenderingPolicy1, localPropertyAccessorRenderingPolicy2, localPropertyAccessorRenderingPolicy3 };
  }
  
  private PropertyAccessorRenderingPolicy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.PropertyAccessorRenderingPolicy
 * JD-Core Version:    0.7.0.1
 */