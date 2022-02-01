import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;

class soa
  implements sow
{
  soa(snh paramsnh) {}
  
  public void onClick(View paramView)
  {
    pum localpum = (pum)paramView.getTag();
    BaseArticleInfo localBaseArticleInfo = this.a.b(localpum.jdField_a_of_type_Int);
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
    snh.a(this.a).a(localpum.f, localpum.jdField_a_of_type_Int);
    snh.a(this.a).a(this.a);
    snh.a(this.a).a(localBaseArticleInfo, snh.a(this.a, localpum.jdField_a_of_type_Sey, localBaseArticleInfo), this.a.a, new sob(this, localBaseArticleInfo), this.a.c);
    puf.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     soa
 * JD-Core Version:    0.7.0.1
 */