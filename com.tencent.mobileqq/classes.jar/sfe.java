import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;

class sfe
  implements sga
{
  sfe(sel paramsel) {}
  
  public void onClick(View paramView)
  {
    pmz localpmz = (pmz)paramView.getTag();
    BaseArticleInfo localBaseArticleInfo = this.a.b(localpmz.jdField_a_of_type_Int);
    if (localBaseArticleInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "articleInfo == null, ERROR");
      }
      return;
    }
    if ((this.a.a != null) && (this.a.a.b()))
    {
      this.a.a.a();
      this.a.b = true;
    }
    sel.a(this.a).a(localpmz.f, localpmz.jdField_a_of_type_Int);
    sel.a(this.a).a(this.a);
    sel.a(this.a).a(localBaseArticleInfo, sel.a(this.a, localpmz.jdField_a_of_type_Rwc, localBaseArticleInfo), this.a.a, new sff(this, localBaseArticleInfo), this.a.c);
    pms.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sfe
 * JD-Core Version:    0.7.0.1
 */