import android.support.v4.util.MQLruCache;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfoEntity;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager.1;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;

public class muf
  implements Manager
{
  private MQLruCache<Long, mtv> jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(50);
  private atmp jdField_a_of_type_Atmp;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public muf(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Atmp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static muf a(QQAppInterface paramQQAppInterface)
  {
    return (muf)paramQQAppInterface.getManager(173);
  }
  
  public int a(boolean paramBoolean1, long paramLong1, long paramLong2, long paramLong3, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    try
    {
      mtv localmtv1 = new mtv();
      localmtv1.jdField_a_of_type_Long = paramLong1;
      localmtv1.c = paramLong3;
      localmtv1.b = paramLong2;
      localmtv1.jdField_a_of_type_Boolean = paramBoolean1;
      mtv localmtv2 = (mtv)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(Long.valueOf(paramLong1));
      if (localmtv2 != null)
      {
        if (paramLong3 == 0L) {
          localmtv1.b = localmtv2.b;
        }
        if (!paramBoolean1) {
          localmtv1.a(localmtv2.a());
        }
      }
      localmtv1.b(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailDynamicDataManager", 2, "updateAccountDetailDynamicInfoCache puin:" + paramLong1 + " last_msg_id:" + localmtv1.b + " msg_cnt:" + paramLong3 + " isFirstEnter:" + paramBoolean1 + " isFromDB:" + paramBoolean2);
      }
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(Long.valueOf(paramLong1), localmtv1);
      return 0;
    }
    finally {}
  }
  
  public int a(byte[] paramArrayOfByte, boolean paramBoolean1, long paramLong1, long paramLong2, long paramLong3, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    a(paramBoolean1, paramLong1, paramLong2, paramLong3, paramArrayList, paramBoolean2);
    if ((!paramBoolean2) && (paramBoolean1) && (paramArrayOfByte != null) && (paramLong3 > 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailDynamicDataManager", 2, "updateAccountDetailDynamicInfoDB puin:" + paramLong1 + " last_msg_id:" + paramLong2 + " msg_cnt:" + paramLong3 + " isFirstEnter:" + paramBoolean1 + " isFromDB:" + paramBoolean2);
      }
      ThreadManager.post(new AccountDetailDynamicDataManager.1(this, paramLong1, paramArrayOfByte), 8, null, true);
    }
    return 0;
  }
  
  public ArrayList<mtw> a(long paramLong)
  {
    mtv localmtv = a(paramLong);
    if (localmtv == null) {
      return null;
    }
    return localmtv.a();
  }
  
  public mtv a(long paramLong)
  {
    return (mtv)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(Long.valueOf(paramLong));
  }
  
  public mtv a(String paramString)
  {
    long l2 = 0L;
    try
    {
      l1 = Long.parseLong(paramString);
      return a(l1);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("AccountDetailDynamicDataManager", 2, "getAccountDetailDynamicInfoFromCache puin:" + paramString);
          l1 = l2;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, ajpe paramajpe)
  {
    ArrayList localArrayList = a(paramLong);
    if ((localArrayList == null) || (localArrayList.isEmpty())) {
      ThreadManager.post(new AccountDetailDynamicDataManager.2(this, paramLong, paramQQAppInterface, paramajpe), 8, null, true);
    }
  }
  
  public boolean a(long paramLong, byte[] paramArrayOfByte)
  {
    DynamicInfoEntity localDynamicInfoEntity2 = (DynamicInfoEntity)this.jdField_a_of_type_Atmp.a(DynamicInfoEntity.class, paramLong);
    DynamicInfoEntity localDynamicInfoEntity1 = localDynamicInfoEntity2;
    if (localDynamicInfoEntity2 == null) {
      localDynamicInfoEntity1 = new DynamicInfoEntity();
    }
    localDynamicInfoEntity1.puin = String.valueOf(paramLong);
    localDynamicInfoEntity1.dynamicInfoData = paramArrayOfByte;
    return a(localDynamicInfoEntity1);
  }
  
  protected boolean a(atmo paramatmo)
  {
    boolean bool = false;
    if (paramatmo.getStatus() == 1000)
    {
      this.jdField_a_of_type_Atmp.b(paramatmo);
      if (paramatmo.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramatmo.getStatus() != 1001) && (paramatmo.getStatus() != 1002)) {
      return bool;
    }
    return this.jdField_a_of_type_Atmp.a(paramatmo);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.evictAll();
    this.jdField_a_of_type_Atmp.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     muf
 * JD-Core Version:    0.7.0.1
 */