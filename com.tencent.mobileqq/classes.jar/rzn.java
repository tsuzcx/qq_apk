import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.List;

public final class rzn
  implements Runnable
{
  public rzn(Context paramContext, List paramList, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ChatActivityFacade.b = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    ChatActivityFacade.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430178);
    ChatActivityFacade.b.a(str);
    ChatActivityFacade.b.a(2131434057, 3);
    ChatActivityFacade.b.c(2131433029);
    ChatActivityFacade.b.a(new rzo(this));
    ChatActivityFacade.b.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rzn
 * JD-Core Version:    0.7.0.1
 */