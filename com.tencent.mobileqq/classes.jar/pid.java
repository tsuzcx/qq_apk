import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.component.network.downloader.impl.ipc.DownloadSerice;

public class pid
  implements Downloader.DownloadListener
{
  public pid(DownloadSerice paramDownloadSerice, Messenger paramMessenger) {}
  
  public void onDownloadCanceled(String paramString)
  {
    paramString = Const.a(paramString);
    try
    {
      this.jdField_a_of_type_AndroidOsMessenger.send(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = Const.b(paramString, paramDownloadResult);
    try
    {
      this.jdField_a_of_type_AndroidOsMessenger.send(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    paramString = Const.a(paramString, paramLong, paramFloat);
    try
    {
      this.jdField_a_of_type_AndroidOsMessenger.send(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = Const.a(paramString, paramDownloadResult);
    try
    {
      this.jdField_a_of_type_AndroidOsMessenger.send(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pid
 * JD-Core Version:    0.7.0.1
 */