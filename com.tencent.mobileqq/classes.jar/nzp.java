import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class nzp
  extends apas
{
  public nzp(EqqAccountDetailActivity paramEqqAccountDetailActivity, oji paramoji, int paramInt1, int paramInt2) {}
  
  public int a()
  {
    return 7;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof ArrayList))
    {
      paramObject = ((ArrayList)paramObject).iterator();
      for (;;)
      {
        if (paramObject.hasNext())
        {
          Object localObject = paramObject.next();
          if (((localObject instanceof AppletItem)) && (((AppletItem)localObject).c().equals(EqqAccountDetailActivity.p(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity))))
          {
            this.jdField_a_of_type_Oji.d = this.jdField_a_of_type_Int;
            this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.p();
            if (this.jdField_a_of_type_Oji.e == 6)
            {
              if (this.b != 1) {
                break label236;
              }
              this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a(1);
              bdla.b(EqqAccountDetailActivity.q(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity), "P_CliOper", "Pb_account_lifeservice", EqqAccountDetailActivity.q(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity), "mp_msg_ziliao_2", "share_click", 0, 0, "", "", "", "");
              bdla.b(EqqAccountDetailActivity.r(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity), "P_CliOper", "Pb_account_lifeservice", EqqAccountDetailActivity.r(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity), "0X8004F05", "0X8004F05", 0, 0, "", "", "", "");
            }
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a, 2, String.valueOf(this.b));
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.g();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a, 2, "状态切换成功");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a(this.jdField_a_of_type_Oji);
      return;
      label236:
      bdla.b(EqqAccountDetailActivity.s(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity), "P_CliOper", "Pb_account_lifeservice", EqqAccountDetailActivity.s(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity), "0X8004F07", "0X8004F07", 0, 0, "", "", "", "");
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a, 2, "success:" + paramBoolean);
    }
    EqqAccountDetailActivity.e(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity);
  }
  
  public void b(Object paramObject)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.d(2131694983);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    EqqAccountDetailActivity.e(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity);
    if (EqqAccountDetailActivity.f(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity) == 0) {
      EqqAccountDetailActivity.f(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nzp
 * JD-Core Version:    0.7.0.1
 */