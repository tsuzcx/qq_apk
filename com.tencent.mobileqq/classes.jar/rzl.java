import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class rzl
  implements aocf
{
  public rzl(FastWebActivity paramFastWebActivity) {}
  
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
    aocl localaocl = new aocl().a(16908290);
    StringBuilder localStringBuilder = new StringBuilder().append("mainFeeds:");
    if (FastWebActivity.a(this.a) == null)
    {
      str2 = "";
      localaocl = localaocl.a(str2);
      if (FastWebActivity.a(this.a) != null) {
        break label164;
      }
      str2 = "";
      label108:
      localaocl = localaocl.b(str2);
      if (FastWebActivity.a(this.a) != null) {
        break label178;
      }
    }
    label164:
    label178:
    for (str2 = "";; str2 = FastWebActivity.a(this.a).mSubscribeName)
    {
      return localaocl.c(str2).d(str1).a(FastWebActivity.a(this.a)).a();
      str2 = FastWebActivity.a(this.a).innerUniqueID;
      break;
      str2 = FastWebActivity.a(this.a).mTitle;
      break label108;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rzl
 * JD-Core Version:    0.7.0.1
 */