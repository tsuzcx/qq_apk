import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;

class pho
  implements pen
{
  pho(phl paramphl) {}
  
  public void onClick(View paramView)
  {
    sjy localsjy = (sjy)paramView.getTag();
    BaseArticleInfo localBaseArticleInfo = phl.a(this.a).a(localsjy.jdField_a_of_type_Int);
    if (localBaseArticleInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJVideoHandleClick", 2, "articleInfo == null, ERROR");
      }
      return;
    }
    if ((phl.a(this.a).a().a() != null) && (phl.a(this.a).a().a().b()))
    {
      phl.a(this.a).a().a().a();
      phl.a(this.a).a().f(true);
    }
    phl.a(this.a).a().a().a(localsjy.g, localsjy.jdField_a_of_type_Int);
    phl.a(this.a).a().a().a(phl.a(this.a).a().a());
    phl.a(this.a).a().a().a(localBaseArticleInfo, phk.a(localsjy.jdField_a_of_type_Sdg, localBaseArticleInfo, phl.a(this.a).a().a(), phl.a(this.a)), phl.a(this.a).a().a(), new php(this, localBaseArticleInfo), phl.a(this.a).a().b());
    psf.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pho
 * JD-Core Version:    0.7.0.1
 */