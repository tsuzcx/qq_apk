import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.redbag.AVRedBagMgr.TestFlag;

public class kgw
  implements MenuItem.OnMenuItemClickListener
{
  public kgw(AVRedBagMgr.TestFlag paramTestFlag) {}
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AVActivity.b("打印线程");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kgw
 * JD-Core Version:    0.7.0.1
 */