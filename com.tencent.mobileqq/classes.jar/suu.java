import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.emosm.view.DragSortListView.RemoveListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class suu
  implements DragSortListView.RemoveListener
{
  public suu(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "RemoveListener which = " + paramInt);
    }
    paramInt -= 1;
    byte b;
    if ((paramInt >= 0) && (paramInt < this.a.a.size()))
    {
      Object localObject = (Groups)this.a.a.get(paramInt);
      b = (byte)((Groups)localObject).group_id;
      if (QLog.isColorLevel())
      {
        QLog.d("GroupManagerActivity", 2, "RemoveListener remove groupId :" + b);
        QLog.d("GroupManagerActivity", 2, "RemoveListener remove friend_count :" + ((Groups)localObject).group_friend_count);
      }
      if (b == 0)
      {
        localObject = new QQToast(this.a);
        ((QQToast)localObject).d(2000);
        ((QQToast)localObject).c(2131436516);
        ((QQToast)localObject).a();
      }
    }
    else
    {
      return;
    }
    GroupManagerActivity.a(this.a, b);
    ReportController.b(this.a.app, "CliOper", "", "", "category", "Delete_category", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     suu
 * JD-Core Version:    0.7.0.1
 */