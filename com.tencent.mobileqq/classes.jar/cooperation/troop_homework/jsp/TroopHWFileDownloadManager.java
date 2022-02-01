package cooperation.troop_homework.jsp;

import android.content.Context;
import android.os.Process;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import com.tencent.tmdownloader.TMAssistantDownloadSettingClient;
import java.io.File;
import java.util.HashMap;

public class TroopHWFileDownloadManager
{
  public static final String a = "cooperation.troop_homework.jsp.TroopHWFileDownloadManager";
  private TMAssistantDownloadClient b;
  private TMAssistantDownloadSettingClient c;
  private HashMap<String, String> d = new HashMap();
  private HashMap<String, TroopHWFileDownloadManager.OnDownloadStateListener> e = new HashMap();
  private String f;
  private ITMAssistantDownloadClientListener g = new TroopHWFileDownloadManager.5(this);
  
  public TroopHWFileDownloadManager(Context paramContext)
  {
    TMAssistantDownloadManager localTMAssistantDownloadManager = TMAssistantDownloadManager.getInstance(paramContext.getApplicationContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append("_");
    localStringBuilder.append(System.currentTimeMillis());
    this.f = localStringBuilder.toString();
    this.b = localTMAssistantDownloadManager.getDownloadSDKClient(this.f);
    this.c = TMAssistantDownloadManager.getInstance(paramContext).getDownloadSDKSettingClient();
    this.b.registerDownloadTaskListener(this.g);
  }
  
  public void a(Context paramContext)
  {
    this.b.unRegisterDownloadTaskListener(this.g);
    TMAssistantDownloadManager.getInstance(paramContext.getApplicationContext()).releaseDownloadSDKClient(this.f);
  }
  
  public void a(String paramString)
  {
    ThreadManager.post(new TroopHWFileDownloadManager.2(this, paramString), 5, null, true);
  }
  
  public void a(String paramString1, String paramString2, TroopHWFileDownloadManager.OnDownloadStateListener paramOnDownloadStateListener)
  {
    String str = paramString2.substring(paramString2.lastIndexOf("/") + 1);
    File localFile = new File(paramString2);
    if (localFile.exists())
    {
      if (paramOnDownloadStateListener != null)
      {
        paramOnDownloadStateListener.a(paramString1, localFile.length(), localFile.length());
        paramOnDownloadStateListener.a(paramString1, 3, 0, null, paramString2);
      }
      return;
    }
    if (!this.e.containsKey(paramString1))
    {
      this.e.put(paramString1, paramOnDownloadStateListener);
      this.d.put(paramString1, paramString2);
    }
    ThreadManager.post(new TroopHWFileDownloadManager.1(this, paramString1, str), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWFileDownloadManager
 * JD-Core Version:    0.7.0.1
 */