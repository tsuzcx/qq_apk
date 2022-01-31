import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;

public class kty
  extends PublicAccountObserver
{
  private AccountDetailGroupListContainer b;
  
  public kty(AccountDetailGroupListContainer paramAccountDetailGroupListContainer1, AccountDetailGroupListContainer paramAccountDetailGroupListContainer2)
  {
    this.b = paramAccountDetailGroupListContainer2;
  }
  
  public void a()
  {
    this.b = null;
  }
  
  public void a(boolean paramBoolean, PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if ((paramBoolean) && (paramPaConfigInfo != null)) {
      if (paramPaConfigInfo.e != 3) {}
    }
    while (this.b == null) {
      for (;;)
      {
        PublicAccountUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.a.jdField_a_of_type_JavaLangString);
        return;
        if ((paramPaConfigInfo.e == 6) && (this.b != null)) {
          AccountDetailGroupListContainer.a(this.b, paramPaConfigInfo);
        }
      }
    }
    AccountDetailGroupListContainer.a(this.b, 2131430035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kty
 * JD-Core Version:    0.7.0.1
 */