import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.TabView;
import com.tencent.qphone.base.util.QLog;

public class myx
  implements View.OnClickListener
{
  public myx(PoiMapActivity paramPoiMapActivity) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof PoiMapActivity.TabView))
    {
      this.a.a(((PoiMapActivity.TabView)paramView).a);
      this.a.i();
      if (QLog.isDevelopLevel()) {
        QLog.i("PoiMapActivity", 4, "mTabClickListener" + ((PoiMapActivity.TabView)paramView).a);
      }
      if (PoiMapActivity.a(this.a)) {
        this.a.a("share_locate", "click_tab" + (((PoiMapActivity.TabView)paramView).a + 1), "", "", "", "");
      }
    }
    else
    {
      return;
    }
    this.a.a("share_locate", "click_tab" + (((PoiMapActivity.TabView)paramView).a + 1), this.a.f, this.a.e, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     myx
 * JD-Core Version:    0.7.0.1
 */