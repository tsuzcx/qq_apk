import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class tfr
  extends ContactBindObserver
{
  public tfr(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  protected void b(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      PhoneUnityBindInfoActivity.a(this.a, this.a.jdField_a_of_type_AndroidWidgetRelativeLayout, 1, 2);
    }
    for (;;)
    {
      this.a.app.unRegistObserver(this);
      this.a.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
      return;
      PhoneUnityBindInfoActivity.a(this.a, this.a.jdField_a_of_type_AndroidWidgetRelativeLayout, 3, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tfr
 * JD-Core Version:    0.7.0.1
 */