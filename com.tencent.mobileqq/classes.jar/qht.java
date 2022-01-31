import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo.DefnInfo;

public class qht
  extends pxn
{
  public View a;
  public BaseArticleInfo a;
  public VideoViewGroup a;
  public TVK_NetVideoInfo.DefnInfo a;
  public pqb a;
  boolean a;
  public int b;
  public View b;
  public boolean b;
  public int c;
  public long c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public boolean d;
  public int e = -1;
  public long e;
  public String e;
  public boolean e;
  public int f;
  public long f;
  public String f;
  public int g;
  public long g = -1L;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public String l;
  public int m;
  public String m;
  public int n = 0;
  public String n;
  
  public qht()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public VideoInfo a()
  {
    return pxq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID();
    }
    return "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoPlayParam[");
    localStringBuilder.append(" articleID:").append(this.jdField_c_of_type_Long);
    localStringBuilder.append(", videoVid:").append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(", busitype:").append(this.f);
    localStringBuilder.append(", videoDuration:").append(this.b);
    localStringBuilder.append(", position:").append(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) {
      localStringBuilder.append(", title:").append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qht
 * JD-Core Version:    0.7.0.1
 */