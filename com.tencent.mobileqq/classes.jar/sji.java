import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortListView.RemoveListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class sji
  implements DragSortListView.RemoveListener
{
  public sji(EmosmActivity paramEmosmActivity) {}
  
  public void a(int paramInt)
  {
    Object localObject = (EmoticonPackage)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (!NetworkUtil.d(this.a))
    {
      localObject = new QQToast(this.a);
      ((QQToast)localObject).a(2130838710);
      ((QQToast)localObject).d(1500);
      ((QQToast)localObject).a("无网络连接，删除失败");
      ((QQToast)localObject).b(0);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.a.getString(2131436075));
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    ((EmoticonHandler)this.a.app.a(12)).a(Integer.parseInt(((EmoticonPackage)localObject).epId));
    URLDrawable.clearMemoryCache();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sji
 * JD-Core Version:    0.7.0.1
 */