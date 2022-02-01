package cooperation.qqcircle.proxy;

public abstract interface QCircleInvokeStub
{
  public abstract void invoke(int paramInt, Object... paramVarArgs);
  
  public abstract void invokeWithCallBack(int paramInt, Object paramObject, Object... paramVarArgs);
  
  public abstract Object invokeWithReturnValue(int paramInt, Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.proxy.QCircleInvokeStub
 * JD-Core Version:    0.7.0.1
 */