package rx.plugins;

class RxJavaSingleExecutionHookDefault
  extends RxJavaSingleExecutionHook
{
  private static final RxJavaSingleExecutionHookDefault INSTANCE = new RxJavaSingleExecutionHookDefault();
  
  public static RxJavaSingleExecutionHook getInstance()
  {
    return INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.plugins.RxJavaSingleExecutionHookDefault
 * JD-Core Version:    0.7.0.1
 */