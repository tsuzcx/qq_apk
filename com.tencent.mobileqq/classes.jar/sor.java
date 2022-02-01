import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

class sor
  extends pue
{
  sor(snh paramsnh, String paramString, int paramInt1, BaseArticleInfo paramBaseArticleInfo, int paramInt2, View paramView, ViewGroup paramViewGroup)
  {
    super(paramString);
  }
  
  public void a(ptx paramptx)
  {
    bkpj.a("ReadInJoyBaseAdapter.Viewtype " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Snh.a(this.jdField_a_of_type_Int)) {
      if ((pfr.a(this.jdField_a_of_type_Snh.a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) && (this.jdField_a_of_type_Snh.c != 56))
      {
        if ((paramptx instanceof ptz)) {}
      }
      else {
        while ((paramptx instanceof ptz)) {
          return;
        }
      }
    }
    phi localphi1;
    String str;
    if (paramptx.a(this.jdField_a_of_type_Int))
    {
      long l1 = System.currentTimeMillis();
      this.jdField_a_of_type_JavaLangObject = paramptx.a(this.b, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewViewGroup);
      long l2 = System.currentTimeMillis();
      if (twz.a.a())
      {
        localphi1 = new phi();
        phi localphi2 = localphi1.a("cost", l2 - l1).b("type", this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_JavaLangObject != null) {
          break label240;
        }
        str = "0";
        paramptx = localphi2.b("result", str).b("handleID", paramptx.a());
        if (this.jdField_a_of_type_AndroidViewView != null) {
          break label247;
        }
      }
    }
    label240:
    label247:
    for (int i = 1;; i = 0)
    {
      paramptx.b("isNewCreate", i).b("isDebugVersion", 0).b("isPublicVersion", 1);
      oat.a("0X800AF90", localphi1.a());
      bkpj.a();
      return;
      str = "1";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sor
 * JD-Core Version:    0.7.0.1
 */