import android.os.Bundle;
import com.tencent.biz.pubaccount.EncryptUinInfo;
import java.util.List;

public abstract class nky
  implements ajtg
{
  protected abstract void a(boolean paramBoolean, List<EncryptUinInfo> paramList, Bundle paramBundle);
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramObject != null) {}
    try
    {
      paramObject = (Bundle)paramObject;
      a(paramBoolean, paramObject.getParcelableArrayList("KEY_ENCRYPT_RESULT_LIST"), paramObject);
      return;
    }
    catch (Exception paramObject) {}
    a(false, null, new Bundle());
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nky
 * JD-Core Version:    0.7.0.1
 */