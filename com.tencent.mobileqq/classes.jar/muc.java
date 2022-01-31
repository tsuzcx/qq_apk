import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class muc
  implements muf
{
  muc(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, String paramString) {}
  
  private void a(Context paramContext)
  {
    if ((paramContext instanceof JumpActivity)) {
      ((Activity)paramContext).finish();
    }
  }
  
  public void a(int paramInt1, muh parammuh, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      a(this.jdField_a_of_type_AndroidContentContext);
    }
    do
    {
      do
      {
        return;
        biln.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentIntent, 1);
        return;
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        localIntent.putExtra("url", parammuh.jdField_a_of_type_JavaLangString);
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
          localIntent.addFlags(268435456);
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        a(this.jdField_a_of_type_AndroidContentContext);
        return;
        ((asvu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(236)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString, "4", "openRoom");
        return;
        if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
        {
          mtz.a(this.jdField_a_of_type_AndroidContentContext, parammuh.b, parammuh.c, new mud(this));
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "context is not Activity");
      return;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
      {
        mtz.a(this.jdField_a_of_type_AndroidContentContext, parammuh.b, parammuh.c, new mue(this));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "context is not Activity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     muc
 * JD-Core Version:    0.7.0.1
 */