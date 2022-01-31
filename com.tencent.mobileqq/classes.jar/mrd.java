import android.os.Bundle;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class mrd
  implements BusinessObserver
{
  mrd(mrb parammrb) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a.a) {
      return;
    }
    if ((!paramBoolean) || (paramBundle == null))
    {
      mrb.a(this.a);
      return;
    }
    do
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.mergeFrom(paramBundle);
        if ((localOIDBSSOPkg == null) || (!localOIDBSSOPkg.uint32_result.has()) || (localOIDBSSOPkg.uint32_result.get() != 0) || (!localOIDBSSOPkg.bytes_bodybuffer.has()) || (localOIDBSSOPkg.bytes_bodybuffer.get() == null))
        {
          mrb.a(this.a);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        mrb.a(this.a);
        return;
      }
      paramBundle = mrb.b(this.a, localOIDBSSOPkg);
    } while ((paramBundle == null) || (paramBundle.size() <= 0));
    mrb.a(this.a, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mrd
 * JD-Core Version:    0.7.0.1
 */