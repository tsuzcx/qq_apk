import android.os.Handler;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.redbag.AVRedBagMgr;
import com.tencent.av.ui.redbag.AVRedBagMgr.TestFlag;

public class keh
  implements MenuItem.OnMenuItemClickListener
{
  public keh(AVRedBagMgr.TestFlag paramTestFlag, VideoAppInterface paramVideoAppInterface, AVRedBagMgr paramAVRedBagMgr) {}
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8002) });
    this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr.b(true);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new kei(this), 10000L);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     keh
 * JD-Core Version:    0.7.0.1
 */