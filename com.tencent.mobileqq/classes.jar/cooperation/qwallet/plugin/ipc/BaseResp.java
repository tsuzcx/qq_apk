package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import android.text.TextUtils;

public abstract class BaseResp
  extends BaseIpc
{
  public static BaseResp getResp(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    Object localObject = paramBundle.getString("_qwallet_ipc_class");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    try
    {
      ClassLoader localClassLoader = BaseIpc.class.getClassLoader();
      if (localClassLoader == null) {
        return null;
      }
      localObject = localClassLoader.loadClass((String)localObject);
      if (localObject == null) {
        return null;
      }
      localObject = (BaseResp)((Class)localObject).newInstance();
      ((BaseResp)localObject).fromBundle(paramBundle);
      return localObject;
    }
    catch (Exception paramBundle) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.BaseResp
 * JD-Core Version:    0.7.0.1
 */