import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.av.ui.redbag.AVRedBagMgr.TestFlag;

public class kfc
  implements MenuItem.OnMenuItemClickListener
{
  public kfc(AVRedBagMgr.TestFlag paramTestFlag) {}
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AVRedBagMgr.TestFlag localTestFlag = this.a;
    localTestFlag.a += 1;
    if (this.a.a > 3) {
      this.a.a = 0;
    }
    paramMenuItem.setTitle("禁用C2C发包索引:" + this.a.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kfc
 * JD-Core Version:    0.7.0.1
 */