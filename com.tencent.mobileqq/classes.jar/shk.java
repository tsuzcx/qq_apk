import android.os.Handler;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class shk
  extends CardObserver
{
  public shk(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (paramObject != null) && (!Utils.a(paramObject.uin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        this.a.a(8, paramObject.uin, -2147483648);
      }
      return;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, " conversation onGetCalReactiveDays isAllow= " + paramBoolean2);
      }
      this.a.a(0L);
    }
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (Object localObject = (Card)paramObject;; localObject = null)
    {
      if ((paramBoolean) && (localObject != null) && (!Utils.a(((Card)localObject).uin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        this.a.a(8, ((Card)localObject).uin, 1029);
      }
      if (QLog.isDevelopLevel())
      {
        if (localObject == null) {
          break label120;
        }
        paramObject = ((Card)localObject).uin;
        if (localObject == null) {
          break label126;
        }
      }
      label120:
      label126:
      for (localObject = ((Card)localObject).strCampusName;; localObject = "")
      {
        QLog.i("Q.recent", 4, String.format(Locale.getDefault(), "onGetCampusInfo isSuccess: %b uin: %s name: %s", new Object[] { Boolean.valueOf(paramBoolean), Utils.b(paramObject), Utils.b((String)localObject) }));
        return;
        paramObject = "";
        break;
      }
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "Conversation.onUpdateAvatar: uin:" + paramString + ", success :" + paramBoolean);
    }
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a.sendEmptyMessage(3);
    }
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onGreetingRecv");
      }
      this.a.a(8, AppConstants.G, 1001);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     shk
 * JD-Core Version:    0.7.0.1
 */