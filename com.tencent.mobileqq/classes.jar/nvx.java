import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.settings.QQStoryShieldListActivity;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class nvx
  extends QQStoryObserver
{
  public nvx(QQStoryShieldListActivity paramQQStoryShieldListActivity) {}
  
  public void a(boolean paramBoolean1, List paramList, byte[] paramArrayOfByte, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (!paramBoolean2)
      {
        paramList = this.a.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler;
        if (this.a.jdField_a_of_type_Int == 2) {}
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          paramList.a(paramArrayOfByte, 10, paramBoolean1);
          return;
        }
      }
      QQStoryShieldListActivity.a(this.a);
      this.a.a(paramList);
      return;
    }
    QQStoryShieldListActivity.b(this.a);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
    if (paramBoolean1)
    {
      List localList = this.a.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager.a(paramBoolean3);
      this.a.a(localList);
      return;
    }
    QQToast.a(this.a, 2131437551, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nvx
 * JD-Core Version:    0.7.0.1
 */