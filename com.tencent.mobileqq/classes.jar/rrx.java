import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.List;

public final class rrx
  implements Runnable
{
  public rrx(Context paramContext, List paramList, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ChatActivityFacade.b = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    ChatActivityFacade.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430158);
    ChatActivityFacade.b.a(str);
    ChatActivityFacade.b.a(2131434024, 3);
    ChatActivityFacade.b.c(2131432998);
    ChatActivityFacade.b.a(new rry(this));
    ChatActivityFacade.b.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rrx
 * JD-Core Version:    0.7.0.1
 */