package common.qzone.component.cache.common;

import android.support.v4.util.LruCache;

public class ExtendLruCache
{
  private int jdField_a_of_type_Int;
  private final LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache;
  private int b;
  
  public String toString()
  {
    float f1 = 0.0F;
    StringBuilder localStringBuilder = new StringBuilder(128);
    float f2 = this.jdField_a_of_type_Int + this.b;
    if (f2 != 0.0F) {
      f1 = this.jdField_a_of_type_Int * 100 / f2;
    }
    String str = String.format("ExtendLruCache[hits=%d,misses=%d,hitRate=%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), String.valueOf(f1) });
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
    localStringBuilder.append(str);
    localStringBuilder.append("\n");
    localStringBuilder.append(this.jdField_a_of_type_AndroidSupportV4UtilLruCache.toString());
    int i = this.jdField_a_of_type_AndroidSupportV4UtilLruCache.size() / 1024;
    int j = this.jdField_a_of_type_AndroidSupportV4UtilLruCache.maxSize() / 1024;
    localStringBuilder.append("\n");
    localStringBuilder.append("Lru Size Info:" + String.valueOf(i) + "kb/" + String.valueOf(j) + "kb");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     common.qzone.component.cache.common.ExtendLruCache
 * JD-Core Version:    0.7.0.1
 */