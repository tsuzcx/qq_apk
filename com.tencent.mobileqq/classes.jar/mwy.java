import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody;

public class mwy
  extends akih
{
  public mwy(AccountDetailActivity paramAccountDetailActivity) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof oidb_cmd0xc96.RspBody))
    {
      paramObject = (oidb_cmd0xc96.RspBody)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, new Object[] { "0xc96 responseBody success, wording=", paramObject.wording.get() });
      }
      paramObject = new JSONObject();
      if (this.a.d == null) {}
    }
    try
    {
      paramObject.put("uin", this.a.d);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("find.mp.qq.com");
      localArrayList.add("post.mp.qq.com");
      localArrayList.add("article.mp.qq.com");
      aqrr.a("unFollow", paramObject, localArrayList, null);
      this.a.h();
      ndn.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.d, "0X8005A2D", "0X8005A2D", 0, 0, "", "", "", "", false);
      StructLongMessageDownloadProcessor.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.d);
      ((azhx)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).a(this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      return;
    }
    catch (JSONException paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
      }
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(Object paramObject)
  {
    this.a.d(2131629887);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    paramObject = this.a;
    paramObject.c -= 1;
    if (this.a.c == 0) {
      this.a.L();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mwy
 * JD-Core Version:    0.7.0.1
 */