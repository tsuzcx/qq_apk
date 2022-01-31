import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagRequset;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class mud
{
  public static void a(QQAppInterface paramQQAppInterface, AccountDetail paramAccountDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseInfoModel", 2, "saveAccountDetailToDBAndCache");
    }
    atmp localatmp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    if ((paramAccountDetail != null) && (paramAccountDetail.getId() != -1L)) {
      if (!localatmp.a(paramAccountDetail)) {
        localatmp.a(AccountDetail.class);
      }
    }
    for (;;)
    {
      localatmp.a();
      paramQQAppInterface = (ajoy)paramQQAppInterface.getManager(56);
      if ((paramQQAppInterface != null) && (paramAccountDetail != null))
      {
        paramQQAppInterface.a(paramAccountDetail);
        if (paramAccountDetail.followType == 1) {
          paramQQAppInterface.a(PublicAccountInfo.createPublicAccount(paramAccountDetail, 0L));
        }
      }
      return;
      localatmp.a(paramAccountDetail);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, nbu paramnbu, int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), ndt.class);
    localNewIntent.putExtra("cmd", "set_function_flag");
    mobileqq_mp.SetFunctionFlagRequset localSetFunctionFlagRequset = new mobileqq_mp.SetFunctionFlagRequset();
    localSetFunctionFlagRequset.version.set(1);
    localSetFunctionFlagRequset.uin.set((int)Long.parseLong(paramString));
    localSetFunctionFlagRequset.type.set(paramnbu.e);
    localSetFunctionFlagRequset.value.set(paramInt);
    localSetFunctionFlagRequset.account_type.set(1);
    localNewIntent.putExtra("data", localSetFunctionFlagRequset.toByteArray());
    localNewIntent.setObserver(new mue(paramQQAppInterface, paramnbu, paramInt, paramString));
    paramQQAppInterface.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mud
 * JD-Core Version:    0.7.0.1
 */