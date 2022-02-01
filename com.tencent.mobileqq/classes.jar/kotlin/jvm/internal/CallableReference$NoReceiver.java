package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.SinceKotlin;

@SinceKotlin(version="1.2")
class CallableReference$NoReceiver
  implements Serializable
{
  private static final NoReceiver INSTANCE = new NoReceiver();
  
  private Object readResolve()
  {
    return INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.jvm.internal.CallableReference.NoReceiver
 * JD-Core Version:    0.7.0.1
 */