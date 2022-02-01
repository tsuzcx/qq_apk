package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;

public abstract class BaseReq
  extends BaseIpc
{
  public ResultReceiver fromReceiver;
  
  public static BaseReq getReq(Bundle paramBundle)
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
      localObject = (BaseReq)((Class)localObject).newInstance();
      ((BaseReq)localObject).fromBundle(paramBundle);
      return localObject;
    }
    catch (Exception paramBundle) {}
    return null;
  }
  
  public final boolean doCallback(Bundle paramBundle)
  {
    if ((paramBundle == null) || (this.fromReceiver == null)) {
      return false;
    }
    this.fromReceiver.send(0, paramBundle);
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.fromReceiver = ((ResultReceiver)paramBundle.getParcelable("_qwallet_ipc_req_fromreceiver"));
  }
  
  public abstract void onReceive();
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    if (this.fromReceiver != null)
    {
      Parcel localParcel = Parcel.obtain();
      this.fromReceiver.writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      ResultReceiver localResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      paramBundle.putParcelable("_qwallet_ipc_req_fromreceiver", localResultReceiver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.BaseReq
 * JD-Core Version:    0.7.0.1
 */