package rx.internal.util;

import java.security.PrivilegedAction;

final class PlatformDependent$1
  implements PrivilegedAction<ClassLoader>
{
  public ClassLoader run()
  {
    return ClassLoader.getSystemClassLoader();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.util.PlatformDependent.1
 * JD-Core Version:    0.7.0.1
 */