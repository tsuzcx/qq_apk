import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagRequset;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class oaw
{
  public static void a(QQAppInterface paramQQAppInterface, AccountDetail paramAccountDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseInfoModel", 2, "saveAccountDetailToDBAndCache");
    }
    EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    if ((paramAccountDetail != null) && (paramAccountDetail.getId() != -1L)) {
      if (!localEntityManager.update(paramAccountDetail)) {
        localEntityManager.drop(AccountDetail.class);
      }
    }
    for (;;)
    {
      localEntityManager.close();
      paramQQAppInterface = (aoan)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if ((paramQQAppInterface != null) && (paramAccountDetail != null))
      {
        paramQQAppInterface.a(paramAccountDetail);
        if (paramAccountDetail.followType == 1) {
          paramQQAppInterface.a(PublicAccountInfo.createPublicAccount(paramAccountDetail, 0L));
        }
      }
      return;
      localEntityManager.persist(paramAccountDetail);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, oji paramoji, int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), oln.class);
    localNewIntent.putExtra("cmd", "set_function_flag");
    mobileqq_mp.SetFunctionFlagRequset localSetFunctionFlagRequset = new mobileqq_mp.SetFunctionFlagRequset();
    localSetFunctionFlagRequset.version.set(1);
    localSetFunctionFlagRequset.uin.set((int)Long.parseLong(paramString));
    localSetFunctionFlagRequset.type.set(paramoji.e);
    localSetFunctionFlagRequset.value.set(paramInt);
    localSetFunctionFlagRequset.account_type.set(1);
    localNewIntent.putExtra("data", localSetFunctionFlagRequset.toByteArray());
    localNewIntent.setObserver(new oax(paramQQAppInterface, paramoji, paramInt, paramString));
    paramQQAppInterface.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oaw
 * JD-Core Version:    0.7.0.1
 */