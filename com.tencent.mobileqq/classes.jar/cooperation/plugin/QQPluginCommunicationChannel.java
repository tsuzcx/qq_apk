package cooperation.plugin;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.AbstractPluginCommunicationChannel;
import mqq.app.AppRuntime;

public class QQPluginCommunicationChannel
  extends AbstractPluginCommunicationChannel
{
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public String getNickName()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      return localQQAppInterface.getCurrentNickname();
    }
    return null;
  }
  
  public String getSKey()
  {
    if (a() != null) {
      return "getSKey";
    }
    return null;
  }
  
  public String getSid()
  {
    throw new RuntimeException("NotSupported!");
  }
  
  public long getUin()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      return localQQAppInterface.getLongAccountUin();
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.QQPluginCommunicationChannel
 * JD-Core Version:    0.7.0.1
 */