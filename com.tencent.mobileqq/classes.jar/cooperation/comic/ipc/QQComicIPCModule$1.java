package cooperation.comic.ipc;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.utils.BoodoHippyBirdge.ICheckPluginListener;
import eipc.EIPCResult;

class QQComicIPCModule$1
  implements BoodoHippyBirdge.ICheckPluginListener
{
  QQComicIPCModule$1(QQComicIPCModule paramQQComicIPCModule, int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    QLog.i("QQComicIPCModule", 1, "checkPluginInstall onResult retCode:" + paramInt + " msg:" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putInt("retCode", paramInt);
    localBundle.putString("msg", paramString);
    paramString = EIPCResult.createSuccessResult(localBundle);
    this.jdField_a_of_type_CooperationComicIpcQQComicIPCModule.callbackResult(this.jdField_a_of_type_Int, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.ipc.QQComicIPCModule.1
 * JD-Core Version:    0.7.0.1
 */