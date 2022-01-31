import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import java.net.URLEncoder;

public class mmv
  implements Runnable
{
  public mmv(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    String str3 = "https://post.mp.qq.com/jubao/index?";
    String str1 = str3;
    if (FastWebActivity.a(this.a) != null) {}
    try
    {
      str1 = "https://post.mp.qq.com/jubao/index?" + "articleId=" + FastWebActivity.a(this.a).mArticleID + "&puin=" + FastWebActivity.a(this.a).mSubscribeID + "&url=" + URLEncoder.encode(FastWebActivity.a(this.a).mArticleContentUrl, "utf-8") + "&key=" + FastWebActivity.a(this.a).innerUniqueID + "&type=7&_wv=3";
      ReadInJoyUtils.a(this.a, str1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        String str2 = str3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mmv
 * JD-Core Version:    0.7.0.1
 */