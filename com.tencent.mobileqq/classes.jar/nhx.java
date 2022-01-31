import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagRequset;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class nhx
{
  public static void a(QQAppInterface paramQQAppInterface, AccountDetail paramAccountDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseInfoModel", 2, "saveAccountDetailToDBAndCache");
    }
    awbw localawbw = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    if ((paramAccountDetail != null) && (paramAccountDetail.getId() != -1L)) {
      if (!localawbw.a(paramAccountDetail)) {
        localawbw.a(AccountDetail.class);
      }
    }
    for (;;)
    {
      localawbw.a();
      paramQQAppInterface = (aluw)paramQQAppInterface.getManager(56);
      if ((paramQQAppInterface != null) && (paramAccountDetail != null))
      {
        paramQQAppInterface.a(paramAccountDetail);
        if (paramAccountDetail.followType == 1) {
          paramQQAppInterface.a(PublicAccountInfo.createPublicAccount(paramAccountDetail, 0L));
        }
      }
      return;
      localawbw.a(paramAccountDetail);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, npo paramnpo, int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), nrz.class);
    localNewIntent.putExtra("cmd", "set_function_flag");
    mobileqq_mp.SetFunctionFlagRequset localSetFunctionFlagRequset = new mobileqq_mp.SetFunctionFlagRequset();
    localSetFunctionFlagRequset.version.set(1);
    localSetFunctionFlagRequset.uin.set((int)Long.parseLong(paramString));
    localSetFunctionFlagRequset.type.set(paramnpo.e);
    localSetFunctionFlagRequset.value.set(paramInt);
    localSetFunctionFlagRequset.account_type.set(1);
    localNewIntent.putExtra("data", localSetFunctionFlagRequset.toByteArray());
    localNewIntent.setObserver(new nhy(paramQQAppInterface, paramnpo, paramInt, paramString));
    paramQQAppInterface.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nhx
 * JD-Core Version:    0.7.0.1
 */