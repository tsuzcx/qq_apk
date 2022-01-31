import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.util.List;

public class tcc
  extends FriendListObserver
{
  public tcc(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void onGetVisibilityForNetWorkStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      PermisionPrivacyActivity.a(this.a, this.a.b.a(), paramBoolean2);
    }
  }
  
  protected void onSetSpecialCareSwitch_global(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramBoolean)
    {
      paramArrayOfObject = ((FriendsManager)this.a.app.getManager(50)).b();
      if ((paramArrayOfObject != null) && (paramArrayOfObject.size() != 0)) {
        break label51;
      }
    }
    label51:
    for (paramArrayOfObject = "暂无";; paramArrayOfObject = paramArrayOfObject.size() + "人")
    {
      PermisionPrivacyActivity.b(this.a).setRightText(paramArrayOfObject);
      return;
    }
  }
  
  protected void onSetSpecialCareSwitchesOfAPerson(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramBoolean)
    {
      paramArrayOfObject = ((FriendsManager)this.a.app.getManager(50)).b();
      if ((paramArrayOfObject != null) && (paramArrayOfObject.size() != 0)) {
        break label51;
      }
    }
    label51:
    for (paramArrayOfObject = "暂无";; paramArrayOfObject = paramArrayOfObject.size() + "人")
    {
      PermisionPrivacyActivity.b(this.a).setRightText(paramArrayOfObject);
      return;
    }
  }
  
  protected void onSetVisibilityForNetWorkStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {
      this.a.a(2131436049, 1);
    }
    PermisionPrivacyActivity.a(this.a, this.a.b.a(), paramBoolean2);
  }
  
  protected void onUpdateSpecialCareList(boolean paramBoolean1, boolean paramBoolean2, List paramList)
  {
    if (paramBoolean1)
    {
      paramList = ((FriendsManager)this.a.app.getManager(50)).b();
      if ((paramList != null) && (paramList.size() != 0)) {
        break label51;
      }
    }
    label51:
    for (paramList = "暂无";; paramList = paramList.size() + "人")
    {
      PermisionPrivacyActivity.b(this.a).setRightText(paramList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tcc
 * JD-Core Version:    0.7.0.1
 */