import com.tencent.mobileqq.pb.PBEnumField;
import tencent.im.oidb.articlesummary.articlesummary.ArticleBasicInfo;
import tencent.im.oidb.articlesummary.articlesummary.LongContentInfo;
import tencent.im.oidb.articlesummary.articlesummary.OutsideLinkInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCVideoInfo;

public class rre
{
  public int a;
  public rqu a;
  public rrk a;
  public rrn a;
  
  public rre() {}
  
  public rre(articlesummary.LongContentInfo paramLongContentInfo)
  {
    this.jdField_a_of_type_Int = paramLongContentInfo.enum_long_content_card_type.get();
    this.jdField_a_of_type_Rqu = new rqu(paramLongContentInfo.msg_article_basic_ingo);
    this.jdField_a_of_type_Rrk = new rrk(paramLongContentInfo.msg_outside_link_info);
    this.jdField_a_of_type_Rrn = new rrn(paramLongContentInfo.msg_pgc_video_info);
  }
  
  public articlesummary.LongContentInfo a()
  {
    articlesummary.LongContentInfo localLongContentInfo = new articlesummary.LongContentInfo();
    localLongContentInfo.enum_long_content_card_type.set(this.jdField_a_of_type_Int);
    localLongContentInfo.msg_article_basic_ingo.set(this.jdField_a_of_type_Rqu.a());
    localLongContentInfo.msg_outside_link_info.set(this.jdField_a_of_type_Rrk.a());
    localLongContentInfo.msg_pgc_video_info.set(this.jdField_a_of_type_Rrn.a());
    localLongContentInfo.setHasFlag(true);
    return localLongContentInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rre
 * JD-Core Version:    0.7.0.1
 */