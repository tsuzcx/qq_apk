import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class sob
  implements aqrn
{
  public sob(FastWebActivity paramFastWebActivity) {}
  
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
    aqrv localaqrv = new aqrv().a(16908290);
    StringBuilder localStringBuilder = new StringBuilder().append(aqso.b);
    if (this.a.a == null)
    {
      str2 = "";
      localaqrv = localaqrv.a(str2);
      if (this.a.a != null) {
        break label165;
      }
      str2 = "";
      label109:
      localaqrv = localaqrv.b(str2);
      if (this.a.a != null) {
        break label179;
      }
    }
    label165:
    label179:
    for (str2 = "";; str2 = this.a.a.mSubscribeName)
    {
      return localaqrv.c(str2).d(str1).a(FastWebActivity.a(this.a)).a();
      str2 = this.a.a.innerUniqueID;
      break;
      str2 = this.a.a.mTitle;
      break label109;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sob
 * JD-Core Version:    0.7.0.1
 */