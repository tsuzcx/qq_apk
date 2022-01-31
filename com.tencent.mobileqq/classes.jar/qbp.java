import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.SubVideoInfo;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoColumnInfo;

public class qbp
{
  public int a;
  public UrlJumpInfo a;
  public String a;
  public List<qdi> a;
  public boolean a;
  public int b;
  public UrlJumpInfo b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public qbp()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(6);
  }
  
  public static qbp a(articlesummary.VideoColumnInfo paramVideoColumnInfo)
  {
    boolean bool = true;
    qbp localqbp = new qbp();
    localqbp.jdField_a_of_type_Int = paramVideoColumnInfo.uint32_column_id.get();
    localqbp.jdField_a_of_type_JavaLangString = paramVideoColumnInfo.bytes_column_name.get().toStringUtf8();
    localqbp.jdField_c_of_type_JavaLangString = paramVideoColumnInfo.bytes_sub_title.get().toStringUtf8();
    localqbp.jdField_b_of_type_JavaLangString = paramVideoColumnInfo.bytes_column_card_icon_url.get().toStringUtf8();
    localqbp.jdField_b_of_type_Int = paramVideoColumnInfo.uint32_update_count.get();
    localqbp.jdField_c_of_type_Int = paramVideoColumnInfo.uint32_subscribe_count.get();
    if (paramVideoColumnInfo.uint32_is_subscribed.get() == 1) {}
    for (;;)
    {
      localqbp.jdField_a_of_type_Boolean = bool;
      localqbp.d = paramVideoColumnInfo.bytes_column_card_bg_url.get().toStringUtf8();
      localqbp.e = paramVideoColumnInfo.bytes_column_card_bg_color.get().toStringUtf8();
      localqbp.f = paramVideoColumnInfo.bytes_app_name.get().toStringUtf8();
      localqbp.g = paramVideoColumnInfo.bytes_app_icon_url.get().toStringUtf8();
      Iterator localIterator = paramVideoColumnInfo.rpt_sub_video_info.get().iterator();
      while (localIterator.hasNext())
      {
        articlesummary.SubVideoInfo localSubVideoInfo = (articlesummary.SubVideoInfo)localIterator.next();
        qdi localqdi = new qdi();
        localqdi.jdField_a_of_type_Long = localSubVideoInfo.uint64_article_id.get();
        localqdi.jdField_a_of_type_JavaLangString = localSubVideoInfo.bytes_inner_uniq_id.get().toStringUtf8();
        localqdi.jdField_b_of_type_JavaLangString = localSubVideoInfo.bytes_article_title.get().toStringUtf8();
        localqdi.jdField_c_of_type_JavaLangString = localSubVideoInfo.bytes_first_page_pic_url.get().toStringUtf8();
        localqdi.jdField_a_of_type_Int = localSubVideoInfo.uint32_video_play_count.get();
        localqdi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = UrlJumpInfo.a((articlesummary.UrlJumpInfo)localSubVideoInfo.bytes_jum_url.get());
        localqdi.jdField_b_of_type_Int = localSubVideoInfo.uint32_duration.get();
        localqbp.jdField_a_of_type_JavaUtilList.add(localqdi);
      }
      bool = false;
    }
    localqbp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = UrlJumpInfo.a(paramVideoColumnInfo.default_jump_info);
    localqbp.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = UrlJumpInfo.a(paramVideoColumnInfo.app_jump_info);
    return localqbp;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n").append("columnId=").append(this.jdField_a_of_type_Int).append("\n").append("columnName=").append(this.jdField_a_of_type_JavaLangString).append("\n").append("cardIconUrl=").append(this.jdField_b_of_type_JavaLangString).append("\n").append("subTitle=").append(this.jdField_c_of_type_JavaLangString).append("\n").append("subscribeCount=").append(this.jdField_c_of_type_Int).append("\n").append("isSubscribed=").append(this.jdField_a_of_type_Boolean).append("\n").append("cardBgUrl=").append(this.d).append("\n").append("color=").append(this.e).append("\n").append("appName=").append(this.f).append("\n").append("appIconUrl").append(this.g).append("\n").append("subVideoInfoList={");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      qdi localqdi = (qdi)localIterator.next();
      localStringBuilder.append("\n[").append(localqdi.toString()).append("]");
    }
    localStringBuilder.append("}").append("\n").append("defaultJumpUrl=").append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.toString()).append("\n").append("appJumpUrl=").append(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.toString()).append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qbp
 * JD-Core Version:    0.7.0.1
 */