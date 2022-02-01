import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class sxj
  implements aqck
{
  public sxj(FastWebActivity paramFastWebActivity) {}
  
  public ColorNote getColorNote()
  {
    String str2 = "";
    String str1 = str2;
    if (FastWebActivity.a(this.a) != null)
    {
      str1 = str2;
      if (FastWebActivity.a(this.a).g != null) {
        str1 = FastWebActivity.a(this.a).g;
      }
    }
    aqcs localaqcs = new aqcs().a(16908290);
    StringBuilder localStringBuilder = new StringBuilder().append("mainFeeds:");
    if (this.a.a == null)
    {
      str2 = "";
      localaqcs = localaqcs.a(str2);
      if (this.a.a != null) {
        break label164;
      }
      str2 = "";
      label108:
      localaqcs = localaqcs.b(str2);
      if (this.a.a != null) {
        break label178;
      }
    }
    label164:
    label178:
    for (str2 = "";; str2 = this.a.a.mSubscribeName)
    {
      return localaqcs.c(str2).d(str1).a(FastWebActivity.a(this.a)).a();
      str2 = this.a.a.innerUniqueID;
      break;
      str2 = this.a.a.mTitle;
      break label108;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sxj
 * JD-Core Version:    0.7.0.1
 */