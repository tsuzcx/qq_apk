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

public class rdl
{
  public int a;
  public long a;
  public UrlJumpInfo a;
  public String a;
  public List<rfo> a;
  public boolean a;
  public int b;
  public UrlJumpInfo b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public rdl()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(6);
  }
  
  public static rdl a(articlesummary.VideoColumnInfo paramVideoColumnInfo)
  {
    boolean bool = true;
    rdl localrdl = new rdl();
    localrdl.jdField_a_of_type_Int = paramVideoColumnInfo.uint32_column_id.get();
    localrdl.jdField_a_of_type_JavaLangString = paramVideoColumnInfo.bytes_column_name.get().toStringUtf8();
    localrdl.jdField_b_of_type_JavaLangString = paramVideoColumnInfo.bytes_column_icon_url.get().toStringUtf8();
    localrdl.jdField_d_of_type_JavaLangString = paramVideoColumnInfo.bytes_sub_title.get().toStringUtf8();
    localrdl.jdField_c_of_type_JavaLangString = paramVideoColumnInfo.bytes_column_card_icon_url.get().toStringUtf8();
    localrdl.jdField_b_of_type_Int = paramVideoColumnInfo.uint32_update_count.get();
    localrdl.jdField_a_of_type_Long = paramVideoColumnInfo.uint64_last_update_time.get();
    localrdl.jdField_c_of_type_Int = paramVideoColumnInfo.uint32_video_count.get();
    localrdl.jdField_d_of_type_Int = paramVideoColumnInfo.uint32_subscribe_count.get();
    if (paramVideoColumnInfo.uint32_is_subscribed.get() == 1) {}
    for (;;)
    {
      localrdl.jdField_a_of_type_Boolean = bool;
      localrdl.jdField_e_of_type_JavaLangString = paramVideoColumnInfo.bytes_column_card_bg_url.get().toStringUtf8();
      localrdl.f = paramVideoColumnInfo.bytes_column_card_bg_color.get().toStringUtf8();
      localrdl.g = paramVideoColumnInfo.bytes_app_name.get().toStringUtf8();
      localrdl.h = paramVideoColumnInfo.bytes_app_icon_url.get().toStringUtf8();
      localrdl.jdField_e_of_type_Int = paramVideoColumnInfo.uin32_column_card_bg_style.get();
      Iterator localIterator = paramVideoColumnInfo.rpt_sub_video_info.get().iterator();
      while (localIterator.hasNext())
      {
        articlesummary.SubVideoInfo localSubVideoInfo = (articlesummary.SubVideoInfo)localIterator.next();
        rfo localrfo = new rfo();
        localrfo.jdField_a_of_type_Long = localSubVideoInfo.uint64_article_id.get();
        localrfo.jdField_a_of_type_JavaLangString = localSubVideoInfo.bytes_inner_uniq_id.get().toStringUtf8();
        localrfo.jdField_b_of_type_JavaLangString = localSubVideoInfo.bytes_article_title.get().toStringUtf8();
        localrfo.jdField_c_of_type_JavaLangString = localSubVideoInfo.bytes_first_page_pic_url.get().toStringUtf8();
        localrfo.jdField_a_of_type_Int = localSubVideoInfo.uint32_video_play_count.get();
        localrfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = UrlJumpInfo.a((articlesummary.UrlJumpInfo)localSubVideoInfo.bytes_jum_url.get());
        localrfo.jdField_b_of_type_Int = localSubVideoInfo.uint32_duration.get();
        localrdl.jdField_a_of_type_JavaUtilList.add(localrfo);
      }
      bool = false;
    }
    localrdl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = UrlJumpInfo.a(paramVideoColumnInfo.default_jump_info);
    localrdl.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = UrlJumpInfo.a(paramVideoColumnInfo.app_jump_info);
    return localrdl;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n").append("columnId=").append(this.jdField_a_of_type_Int).append("\n").append("columnName=").append(this.jdField_a_of_type_JavaLangString).append("\n").append("columnIconUrl=").append(this.jdField_b_of_type_JavaLangString).append("\n").append("cardIconUrl=").append(this.jdField_c_of_type_JavaLangString).append("\n").append("subTitle=").append(this.jdField_d_of_type_JavaLangString).append("\n").append("updateCount=").append(this.jdField_b_of_type_Int).append("\n").append("updateTime=").append(this.jdField_a_of_type_Long).append("\n").append("videoCount=").append(this.jdField_c_of_type_Int).append("\n").append("subscribeCount=").append(this.jdField_d_of_type_Int).append("\n").append("isSubscribed=").append(this.jdField_a_of_type_Boolean).append("\n").append("cardBgUrl=").append(this.jdField_e_of_type_JavaLangString).append("\n").append("color=").append(this.f).append("\n").append("appName=").append(this.g).append("\n").append("appIconUrl").append(this.h).append("\n").append("cardBgStyle").append(this.jdField_e_of_type_Int).append("\n").append("subVideoInfoList={");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      rfo localrfo = (rfo)localIterator.next();
      localStringBuilder.append("\n[").append(localrfo.toString()).append("]");
    }
    localStringBuilder.append("}").append("\n").append("defaultJumpUrl=").append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.toString()).append("\n").append("appJumpUrl=").append(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.toString()).append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rdl
 * JD-Core Version:    0.7.0.1
 */