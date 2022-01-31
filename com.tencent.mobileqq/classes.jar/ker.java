import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.redbag.AVRedBagMgr.TestFlag;
import com.tencent.mobileqq.debug.PstnCardTestActivity;
import com.tencent.qphone.base.util.BaseApplication;

public class ker
  implements MenuItem.OnMenuItemClickListener
{
  public ker(AVRedBagMgr.TestFlag paramTestFlag, VideoAppInterface paramVideoAppInterface) {}
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().startActivity(new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp(), PstnCardTestActivity.class));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ker
 * JD-Core Version:    0.7.0.1
 */