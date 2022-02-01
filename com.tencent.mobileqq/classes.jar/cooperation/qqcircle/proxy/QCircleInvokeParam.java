package cooperation.qqcircle.proxy;

public class QCircleInvokeParam
{
  private static final int ACTION_GET_IMPL = 4;
  private static final int ACTION_INIT = 1;
  private static final int ACTION_JS_BRIDGE = 5;
  private static final int ACTION_LAUNCHER = 3;
  private static final int ACTION_RELEASE = 2;
  
  public static int getAction(int paramInt)
  {
    return paramInt >> 16;
  }
  
  public static int getMethod(int paramInt)
  {
    return 0xFFFF & paramInt;
  }
  
  public static int initInvokeKey(int paramInt1, int paramInt2)
  {
    return paramInt1 << 16 | paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.proxy.QCircleInvokeParam
 * JD-Core Version:    0.7.0.1
 */