import android.support.v4.util.MQLruCache;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfoEntity;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager.1;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;

public class nfd
  implements Manager
{
  private MQLruCache<Long, net> jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(50);
  private aukp jdField_a_of_type_Aukp;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public nfd(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Aukp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static nfd a(QQAppInterface paramQQAppInterface)
  {
    return (nfd)paramQQAppInterface.getManager(173);
  }
  
  public int a(boolean paramBoolean1, long paramLong1, long paramLong2, long paramLong3, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    try
    {
      net localnet1 = new net();
      localnet1.jdField_a_of_type_Long = paramLong1;
      localnet1.c = paramLong3;
      localnet1.b = paramLong2;
      localnet1.jdField_a_of_type_Boolean = paramBoolean1;
      net localnet2 = (net)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(Long.valueOf(paramLong1));
      if (localnet2 != null)
      {
        if (paramLong3 == 0L) {
          localnet1.b = localnet2.b;
        }
        if (!paramBoolean1) {
          localnet1.a(localnet2.a());
        }
      }
      localnet1.b(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailDynamicDataManager", 2, "updateAccountDetailDynamicInfoCache puin:" + paramLong1 + " last_msg_id:" + localnet1.b + " msg_cnt:" + paramLong3 + " isFirstEnter:" + paramBoolean1 + " isFromDB:" + paramBoolean2);
      }
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(Long.valueOf(paramLong1), localnet1);
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
  
  public ArrayList<neu> a(long paramLong)
  {
    net localnet = a(paramLong);
    if (localnet == null) {
      return null;
    }
    return localnet.a();
  }
  
  public net a(long paramLong)
  {
    return (net)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(Long.valueOf(paramLong));
  }
  
  public net a(String paramString)
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
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, akdn paramakdn)
  {
    ArrayList localArrayList = a(paramLong);
    if ((localArrayList == null) || (localArrayList.isEmpty())) {
      ThreadManager.post(new AccountDetailDynamicDataManager.2(this, paramLong, paramQQAppInterface, paramakdn), 8, null, true);
    }
  }
  
  public boolean a(long paramLong, byte[] paramArrayOfByte)
  {
    DynamicInfoEntity localDynamicInfoEntity2 = (DynamicInfoEntity)this.jdField_a_of_type_Aukp.a(DynamicInfoEntity.class, paramLong);
    DynamicInfoEntity localDynamicInfoEntity1 = localDynamicInfoEntity2;
    if (localDynamicInfoEntity2 == null) {
      localDynamicInfoEntity1 = new DynamicInfoEntity();
    }
    localDynamicInfoEntity1.puin = String.valueOf(paramLong);
    localDynamicInfoEntity1.dynamicInfoData = paramArrayOfByte;
    return a(localDynamicInfoEntity1);
  }
  
  protected boolean a(auko paramauko)
  {
    boolean bool = false;
    if (paramauko.getStatus() == 1000)
    {
      this.jdField_a_of_type_Aukp.b(paramauko);
      if (paramauko.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramauko.getStatus() != 1001) && (paramauko.getStatus() != 1002)) {
      return bool;
    }
    return this.jdField_a_of_type_Aukp.a(paramauko);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.evictAll();
    this.jdField_a_of_type_Aukp.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nfd
 * JD-Core Version:    0.7.0.1
 */