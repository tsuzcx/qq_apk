package cooperation.qqfav;

import alza;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;

public abstract class QfavHelper$AsyncFavoritesProvider
  extends OnPluginInstallListener.Stub
{
  public Bundle a;
  
  public QfavHelper$AsyncFavoritesProvider(Bundle paramBundle)
  {
    this.a = paramBundle;
  }
  
  public void a()
  {
    QfavHelper.a(BaseApplication.getContext(), this);
  }
  
  public abstract void a(boolean paramBoolean, Bundle paramBundle);
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    a(false, this.a);
  }
  
  public void onInstallFinish(String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new alza(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qqfav.QfavHelper.AsyncFavoritesProvider
 * JD-Core Version:    0.7.0.1
 */