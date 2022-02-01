package cooperation.liveroom;

import android.os.Bundle;
import bihu;
import bihw;
import bihz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BrowserAppInterface;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;

public class LiveRoomDownloadManager
{
  private static LiveRoomDownloadManager instance;
  
  public static LiveRoomDownloadManager getInstance()
  {
    if (instance == null) {
      instance = new LiveRoomDownloadManager();
    }
    return instance;
  }
  
  public void download(List<String> paramList, Map<String, File> paramMap, boolean paramBoolean, LiveRoomDownloadManager.DownloadCallback paramDownloadCallback)
  {
    bihz localbihz = ((bihw)((BrowserAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web")).getManager(47)).a(1);
    if (localbihz != null)
    {
      Bundle localBundle = new Bundle();
      paramDownloadCallback = new LiveRoomDownloadManager.1(this, paramDownloadCallback);
      if (paramBoolean)
      {
        paramList = paramMap.keySet().iterator();
        while (paramList.hasNext())
        {
          Object localObject = (String)paramList.next();
          localObject = new bihu((String)localObject, (File)paramMap.get(localObject));
          ((bihu)localObject).j = true;
          ((bihu)localObject).p = false;
          localbihz.a((bihu)localObject, paramDownloadCallback, localBundle);
        }
      }
      paramList = new bihu(paramList, paramMap, "LiveRoomDownloadManager");
      paramList.j = true;
      paramList.p = false;
      localbihz.a(paramList, paramDownloadCallback, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomDownloadManager
 * JD-Core Version:    0.7.0.1
 */