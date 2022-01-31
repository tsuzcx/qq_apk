import com.tencent.mobileqq.pb.PBEnumField;
import tencent.im.oidb.articlesummary.articlesummary.ArticleBasicInfo;
import tencent.im.oidb.articlesummary.articlesummary.LongContentInfo;
import tencent.im.oidb.articlesummary.articlesummary.OutsideLinkInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCVideoInfo;

public class qco
{
  public int a;
  public qce a;
  public qcu a;
  public qcx a;
  
  public qco() {}
  
  public qco(articlesummary.LongContentInfo paramLongContentInfo)
  {
    this.jdField_a_of_type_Int = paramLongContentInfo.enum_long_content_card_type.get();
    this.jdField_a_of_type_Qce = new qce(paramLongContentInfo.msg_article_basic_ingo);
    this.jdField_a_of_type_Qcu = new qcu(paramLongContentInfo.msg_outside_link_info);
    this.jdField_a_of_type_Qcx = new qcx(paramLongContentInfo.msg_pgc_video_info);
  }
  
  public articlesummary.LongContentInfo a()
  {
    articlesummary.LongContentInfo localLongContentInfo = new articlesummary.LongContentInfo();
    localLongContentInfo.enum_long_content_card_type.set(this.jdField_a_of_type_Int);
    localLongContentInfo.msg_article_basic_ingo.set(this.jdField_a_of_type_Qce.a());
    localLongContentInfo.msg_outside_link_info.set(this.jdField_a_of_type_Qcu.a());
    localLongContentInfo.msg_pgc_video_info.set(this.jdField_a_of_type_Qcx.a());
    localLongContentInfo.setHasFlag(true);
    return localLongContentInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qco
 * JD-Core Version:    0.7.0.1
 */