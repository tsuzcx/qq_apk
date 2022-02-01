import com.tencent.biz.PoiMapActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class nrz
  implements AbsListView.OnScrollListener
{
  public nrz(PoiMapActivity paramPoiMapActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("PoiMapActivity", 4, "onScrollStateChanged");
      }
      if ((!this.a.f) && (this.a.d))
      {
        this.a.f = true;
        paramAbsListView = this.a;
        paramAbsListView.n += 1;
        if (QLog.isDevelopLevel()) {
          QLog.i("PoiMapActivity", 4, "onScrollStateChanged mSearchPage:" + this.a.n);
        }
        this.a.a(this.a.h, this.a.i, this.a.c, "", this.a.n, 20);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nrz
 * JD-Core Version:    0.7.0.1
 */