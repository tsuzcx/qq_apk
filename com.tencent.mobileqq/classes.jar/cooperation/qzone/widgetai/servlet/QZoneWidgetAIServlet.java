package cooperation.qzone.widgetai.servlet;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QZoneWidgetAIServlet
  extends MSFServlet
{
  public static final String CMD_PREFIX_PUBLIC = "SQQzoneSvc.";
  private static final String TAG = "QZoneWidgetAIServlet";
  private static final int TIMEOUT = 30000;
  private MSFServlet mServlet;
  
  public QZoneWidgetAIServlet()
  {
    Object localObject = null;
    try
    {
      Class localClass = getWidgetAIPluginClassLoader().loadClass("com.qzone.commonbase.servlet.QZonePetServletIml");
      localObject = localClass;
    }
    catch (Exception localException)
    {
      QLog.e("QZoneWidgetAIServlet", 1, "load instance failed:" + QLog.getStackTraceString(localException));
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label17:
      break label17;
    }
    if (localObject == null)
    {
      QLog.e("QZoneWidgetAIServlet", 1, "*loadInstance load class fail");
      return;
    }
    localObject = localObject.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    if ((localObject != null) && ((localObject instanceof MSFServlet)))
    {
      this.mServlet = ((MSFServlet)localObject);
      return;
    }
  }
  
  private static ClassLoader getWidgetAIPluginClassLoader()
  {
    return PluginStatic.getOrCreateClassLoader(BaseApplicationImpl.getApplication(), "qzone_widgetai.apk");
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    QLog.e("QZoneWidgetAIServlet", 1, "recieve a request");
    if (this.mServlet != null) {
      this.mServlet.onReceive(paramIntent, paramFromServiceMsg);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (this.mServlet != null) {
      this.mServlet.onSend(paramIntent, paramPacket);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.widgetai.servlet.QZoneWidgetAIServlet
 * JD-Core Version:    0.7.0.1
 */