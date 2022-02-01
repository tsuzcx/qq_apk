package cooperation.qqcircle.proxy;

import com.tencent.qphone.base.util.QLog;

public class QCircleInvokeProxy
{
  public static final String TAG = "QCircleInvokeProxy";
  private boolean mHasStubBind = false;
  private QCircleInvokeStub mInvokeStub;
  
  public static void bindStub(QCircleInvokeStub paramQCircleInvokeStub)
  {
    QLog.d("QCircleInvokeProxy", 1, "invoke stub has bind!");
    getInstance().mInvokeStub = paramQCircleInvokeStub;
    getInstance().mHasStubBind = true;
  }
  
  public static boolean checkStubState(int paramInt1, int paramInt2)
  {
    boolean bool2 = getInstance().mHasStubBind;
    boolean bool1 = bool2;
    if (!bool2)
    {
      QLog.d("QCircleInvokeProxy", 1, "checkStubState fail,stub has not bind.action:" + paramInt1 + ",method:" + paramInt2);
      bool1 = getInstance().mHasStubBind;
    }
    return bool1;
  }
  
  private static QCircleInvokeProxy getInstance()
  {
    return QCircleInvokeProxy.QCircleProxyImpl.access$100();
  }
  
  public static void invoke(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    if (checkStubState(paramInt1, paramInt2)) {
      getInstance().mInvokeStub.invoke(QCircleInvokeParam.initInvokeKey(paramInt1, paramInt2), paramVarArgs);
    }
  }
  
  public static void invokeWithCallBack(int paramInt1, int paramInt2, Object paramObject, Object... paramVarArgs)
  {
    if (checkStubState(paramInt1, paramInt2)) {
      getInstance().mInvokeStub.invokeWithCallBack(QCircleInvokeParam.initInvokeKey(paramInt1, paramInt2), paramObject, paramVarArgs);
    }
  }
  
  public static Object invokeWithReturnValue(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    if (checkStubState(paramInt1, paramInt2)) {
      return getInstance().mInvokeStub.invokeWithReturnValue(QCircleInvokeParam.initInvokeKey(paramInt1, paramInt2), paramVarArgs);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.proxy.QCircleInvokeProxy
 * JD-Core Version:    0.7.0.1
 */