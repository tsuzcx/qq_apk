package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;

public abstract class BaseIpc
{
  protected static final String BASE_IPC_CLASS_KEY = "_qwallet_ipc_class";
  
  public void fromBundle(Bundle paramBundle) {}
  
  public void toBundle(Bundle paramBundle)
  {
    paramBundle.putString("_qwallet_ipc_class", getClass().getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.BaseIpc
 * JD-Core Version:    0.7.0.1
 */