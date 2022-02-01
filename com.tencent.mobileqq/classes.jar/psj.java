import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;

class psj
  implements pnq
{
  psj(psf parampsf) {}
  
  public void onClick(View paramView)
  {
    sxh localsxh = (sxh)paramView.getTag();
    BaseArticleInfo localBaseArticleInfo = psf.a(this.a).a(localsxh.jdField_a_of_type_Int);
    if (localBaseArticleInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJVideoHandleClick", 2, "articleInfo == null, ERROR");
      }
      return;
    }
    if ((psf.a(this.a).a().a() != null) && (psf.a(this.a).a().a().b()))
    {
      psf.a(this.a).a().a().a();
      psf.a(this.a).a().f(true);
    }
    psf.a(this.a).a().a().a(localsxh.g, localsxh.jdField_a_of_type_Int);
    psf.a(this.a).a().a().a(psf.a(this.a).a().a());
    psf.a(this.a).a().a().a(localBaseArticleInfo, prz.a(localsxh.jdField_a_of_type_Spk, localBaseArticleInfo, psf.a(this.a).a().a(), psf.a(this.a)), psf.a(this.a).a().a(), new psk(this, localBaseArticleInfo), psf.a(this.a).a().b());
    qdc.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psj
 * JD-Core Version:    0.7.0.1
 */