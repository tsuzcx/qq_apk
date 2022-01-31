import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.redbag.AVRedBagMgr.TestFlag;
import com.tencent.qphone.base.util.BaseApplication;

public class kfh
  implements MenuItem.OnMenuItemClickListener
{
  public kfh(AVRedBagMgr.TestFlag paramTestFlag, VideoAppInterface paramVideoAppInterface) {}
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + "qav_SP", 0).edit();
    paramMenuItem.putInt("qav_UserGuide_for_av_redbag_count", 0);
    paramMenuItem.commit();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kfh
 * JD-Core Version:    0.7.0.1
 */