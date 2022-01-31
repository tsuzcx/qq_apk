package cooperation.qlink;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;

public class QlinkReliableReport$ReliableReportProxy
  extends BaseProxy
{
  public QlinkReliableReport$ReliableReportProxy(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  protected void a()
  {
    QlinkReliableReport.a().c();
  }
  
  protected void b()
  {
    QlinkReliableReport.a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qlink.QlinkReliableReport.ReliableReportProxy
 * JD-Core Version:    0.7.0.1
 */