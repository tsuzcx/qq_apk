import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.av.ui.redbag.AVRedBagMgr;
import com.tencent.av.ui.redbag.AVRedBagMgr.TestFlag;
import com.tencent.mobileqq.utils.AudioHelper;

public class kez
  implements MenuItem.OnMenuItemClickListener
{
  public kez(AVRedBagMgr.TestFlag paramTestFlag, AVRedBagMgr paramAVRedBagMgr) {}
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AudioHelper.a("让入口可用");
    this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr.a.a = 1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kez
 * JD-Core Version:    0.7.0.1
 */