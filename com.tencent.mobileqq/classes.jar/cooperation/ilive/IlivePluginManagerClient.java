package cooperation.ilive;

import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

public class IlivePluginManagerClient
{
  private volatile boolean a = false;
  private List<WeakReference<IlivePluginManagerClient.OnPluginReadyListener>> b = new ArrayList();
  private long c = 0L;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.IlivePluginManagerClient
 * JD-Core Version:    0.7.0.1
 */