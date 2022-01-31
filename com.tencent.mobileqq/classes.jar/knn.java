import android.os.Bundle;
import com.tencent.biz.helper.TroopCardAppInfoHelper;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class knn
  implements BusinessObserver
{
  public knn(TroopCardAppInfoHelper paramTroopCardAppInfoHelper, boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper.jdField_a_of_type_Boolean) {
      return;
    }
    if ((!paramBoolean) || (paramBundle == null))
    {
      TroopCardAppInfoHelper.a(this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper);
      return;
    }
    paramBundle = paramBundle.getByteArray("data");
    Object localObject = new oidb_sso.OIDBSSOPkg();
    try
    {
      ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramBundle);
      if ((localObject == null) || (!((oidb_sso.OIDBSSOPkg)localObject).uint32_result.has()) || (((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get() != 0) || (!((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() == null))
      {
        TroopCardAppInfoHelper.a(this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopCardAppInfoHandler", 2, "handleGetTroopAppBriefList error " + QLog.getStackTraceString(paramBundle));
      }
      TroopCardAppInfoHelper.a(this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper);
      return;
    }
    localObject = TroopCardAppInfoHelper.a(this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper, (oidb_sso.OIDBSSOPkg)localObject);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        TroopCardAppInfoHelper.a(this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper, (List)localObject);
        return;
      }
      paramBundle = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject).next();
        new TroopAppInfo().appId = localLong.longValue();
      }
      TroopCardAppInfoHelper.a(this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper, paramBundle);
      return;
    }
    TroopCardAppInfoHelper.a(this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     knn
 * JD-Core Version:    0.7.0.1
 */