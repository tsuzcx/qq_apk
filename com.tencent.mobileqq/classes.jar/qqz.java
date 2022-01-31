import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.CoverSelectTabFragment;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.qphone.base.util.QLog;

public class qqz
  implements qrk
{
  public qqz(CoverSelectTabFragment paramCoverSelectTabFragment) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJUGC.CoverSelectTabFragment", 2, "OutputPicListener outPath:" + paramString);
    }
    CoverSelectTabFragment.a(this.a, paramString, CoverSelectTabFragment.a(this.a).getCurrentItem());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqz
 * JD-Core Version:    0.7.0.1
 */