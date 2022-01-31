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

public class qli
{
  public int a;
  public UrlJumpInfo a;
  public String a;
  public List<qnb> a;
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
  
  public qli()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(6);
  }
  
  public static qli a(articlesummary.VideoColumnInfo paramVideoColumnInfo)
  {
    boolean bool = true;
    qli localqli = new qli();
    localqli.jdField_a_of_type_Int = paramVideoColumnInfo.uint32_column_id.get();
    localqli.jdField_a_of_type_JavaLangString = paramVideoColumnInfo.bytes_column_name.get().toStringUtf8();
    localqli.jdField_c_of_type_JavaLangString = paramVideoColumnInfo.bytes_sub_title.get().toStringUtf8();
    localqli.jdField_b_of_type_JavaLangString = paramVideoColumnInfo.bytes_column_card_icon_url.get().toStringUtf8();
    localqli.jdField_b_of_type_Int = paramVideoColumnInfo.uint32_update_count.get();
    localqli.jdField_c_of_type_Int = paramVideoColumnInfo.uint32_subscribe_count.get();
    if (paramVideoColumnInfo.uint32_is_subscribed.get() == 1) {}
    for (;;)
    {
      localqli.jdField_a_of_type_Boolean = bool;
      localqli.d = paramVideoColumnInfo.bytes_column_card_bg_url.get().toStringUtf8();
      localqli.e = paramVideoColumnInfo.bytes_column_card_bg_color.get().toStringUtf8();
      localqli.f = paramVideoColumnInfo.bytes_app_name.get().toStringUtf8();
      localqli.g = paramVideoColumnInfo.bytes_app_icon_url.get().toStringUtf8();
      Iterator localIterator = paramVideoColumnInfo.rpt_sub_video_info.get().iterator();
      while (localIterator.hasNext())
      {
        articlesummary.SubVideoInfo localSubVideoInfo = (articlesummary.SubVideoInfo)localIterator.next();
        qnb localqnb = new qnb();
        localqnb.jdField_a_of_type_Long = localSubVideoInfo.uint64_article_id.get();
        localqnb.jdField_a_of_type_JavaLangString = localSubVideoInfo.bytes_inner_uniq_id.get().toStringUtf8();
        localqnb.jdField_b_of_type_JavaLangString = localSubVideoInfo.bytes_article_title.get().toStringUtf8();
        localqnb.jdField_c_of_type_JavaLangString = localSubVideoInfo.bytes_first_page_pic_url.get().toStringUtf8();
        localqnb.jdField_a_of_type_Int = localSubVideoInfo.uint32_video_play_count.get();
        localqnb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = UrlJumpInfo.a((articlesummary.UrlJumpInfo)localSubVideoInfo.bytes_jum_url.get());
        localqnb.jdField_b_of_type_Int = localSubVideoInfo.uint32_duration.get();
        localqli.jdField_a_of_type_JavaUtilList.add(localqnb);
      }
      bool = false;
    }
    localqli.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = UrlJumpInfo.a(paramVideoColumnInfo.default_jump_info);
    localqli.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = UrlJumpInfo.a(paramVideoColumnInfo.app_jump_info);
    return localqli;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n").append("columnId=").append(this.jdField_a_of_type_Int).append("\n").append("columnName=").append(this.jdField_a_of_type_JavaLangString).append("\n").append("cardIconUrl=").append(this.jdField_b_of_type_JavaLangString).append("\n").append("subTitle=").append(this.jdField_c_of_type_JavaLangString).append("\n").append("subscribeCount=").append(this.jdField_c_of_type_Int).append("\n").append("isSubscribed=").append(this.jdField_a_of_type_Boolean).append("\n").append("cardBgUrl=").append(this.d).append("\n").append("color=").append(this.e).append("\n").append("appName=").append(this.f).append("\n").append("appIconUrl").append(this.g).append("\n").append("subVideoInfoList={");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      qnb localqnb = (qnb)localIterator.next();
      localStringBuilder.append("\n[").append(localqnb.toString()).append("]");
    }
    localStringBuilder.append("}").append("\n").append("defaultJumpUrl=").append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.toString()).append("\n").append("appJumpUrl=").append(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.toString()).append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qli
 * JD-Core Version:    0.7.0.1
 */