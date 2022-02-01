package cooperation.qlink;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

@KeepClassConstructor
public class ReliableReportProxy
  extends BaseProxy
{
  public ReliableReportProxy(QQAppInterface paramQQAppInterface, BaseProxyManager paramBaseProxyManager)
  {
    super(paramQQAppInterface, paramBaseProxyManager);
  }
  
  public void destroy()
  {
    QlinkReliableReport.a().d();
  }
  
  public void init()
  {
    QlinkReliableReport.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qlink.ReliableReportProxy
 * JD-Core Version:    0.7.0.1
 */