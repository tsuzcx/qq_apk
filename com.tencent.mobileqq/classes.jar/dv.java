import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import java.lang.ref.WeakReference;

class dv
  implements apcz
{
  dv(dr paramdr, DataLineMsgRecord paramDataLineMsgRecord) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Dr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_Dr.jdField_a_of_type_AndroidContentContext == null)) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
          paramView = new WeakReference(this.jdField_a_of_type_Dr.jdField_a_of_type_AndroidContentContext);
        } while (!(this.jdField_a_of_type_Dr.jdField_a_of_type_AndroidContentContext instanceof Activity));
        if (!badq.d(this.jdField_a_of_type_Dr.jdField_a_of_type_AndroidContentContext))
        {
          bbmy.a(this.jdField_a_of_type_Dr.jdField_a_of_type_AndroidContentContext, 2131626719, 0).b(this.jdField_a_of_type_Dr.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
          return;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord == null) || (paramView.get() == null));
      str = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.getExtInfoFromExtStr("key_team_work_ext_info_new_url");
      Boolean.parseBoolean(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.getExtInfoFromExtStr("team_work_is_message_convert"));
    } while (TextUtils.isEmpty(str));
    Bundle localBundle = new Bundle();
    localBundle.putString("url", str);
    localBundle.putString("tdsourcetag", "s_qq_aio_grey");
    TeamWorkDocEditBrowserActivity.a((Context)paramView.get(), localBundle, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     dv
 * JD-Core Version:    0.7.0.1
 */