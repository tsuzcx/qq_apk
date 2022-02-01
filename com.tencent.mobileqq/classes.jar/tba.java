import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

class tba
  extends qdb
{
  tba(tay paramtay, String paramString, int paramInt1, BaseArticleInfo paramBaseArticleInfo, int paramInt2, ViewGroup paramViewGroup)
  {
    super(paramString);
  }
  
  public void a(qcu paramqcu)
  {
    blfz.a("ReadInJoyBaseAdapter.Viewtype " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Tay.a(this.jdField_a_of_type_Int)) {
      if ((piv.a(this.jdField_a_of_type_Tay.a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) && (this.jdField_a_of_type_Tay.c != 56))
      {
        if ((paramqcu instanceof qcw)) {}
      }
      else {
        while ((paramqcu instanceof qcw)) {
          return;
        }
      }
    }
    if (paramqcu.a(this.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_JavaLangObject = paramqcu.a(this.b, null, this.jdField_a_of_type_AndroidViewViewGroup);
    }
    blfz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tba
 * JD-Core Version:    0.7.0.1
 */