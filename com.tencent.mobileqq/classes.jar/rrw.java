import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.articlesummary.SubscriptInfo;

public class rrw
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, articlesummary.SubscriptInfo paramSubscriptInfo)
  {
    if (paramBaseArticleInfo == null)
    {
      QLog.d("SubscriptInfo", 2, "articleinfo == null");
      return;
    }
    paramBaseArticleInfo.subscriptWording = qxl.a(paramSubscriptInfo.bytes_subscript_txt, "");
    paramBaseArticleInfo.subscriptWordingColor = qxl.a(paramSubscriptInfo.bytes_subscript_color, "");
    paramBaseArticleInfo.subscriptBgColor = qxl.a(paramSubscriptInfo.bytes_background_color, "");
    paramBaseArticleInfo.subscriptLocation = qxl.a(paramSubscriptInfo.uint32_is_show_top, 0);
    paramBaseArticleInfo.subscriptType = qxl.a(paramSubscriptInfo.uint32_subscript_type, 0);
    QLog.d("SubscriptInfo", 2, "parseByPB | wording: " + paramBaseArticleInfo.subscriptWording + " \ntxtColor : " + paramBaseArticleInfo.subscriptWordingColor + " \nbgColor : " + paramBaseArticleInfo.subscriptBgColor + " \nisShowTop : " + paramBaseArticleInfo.subscriptLocation + " \ntype : " + paramBaseArticleInfo.subscriptType + " \n");
  }
  
  public String toString()
  {
    return "SubscriptInfo{wording='" + this.jdField_a_of_type_JavaLangString + '\'' + ", wordingColor='" + this.jdField_b_of_type_JavaLangString + '\'' + ", bgColor='" + this.c + '\'' + ", type=" + this.jdField_a_of_type_Int + ", location=" + this.jdField_b_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rrw
 * JD-Core Version:    0.7.0.1
 */