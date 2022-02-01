import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class snc
  implements pql
{
  public snc(FastWebActivity paramFastWebActivity) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    QLog.e("FastWebActivity", 1, "onLoadUserInfoFailed " + paramString1 + " " + paramString2);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    QLog.d("FastWebActivity", 1, "onLoadUserInfoSucceed " + paramReadInJoyUserInfo);
    FastWebActivity localFastWebActivity;
    ArticleInfo localArticleInfo;
    int i;
    if (paramReadInJoyUserInfo != null) {
      if ((paramReadInJoyUserInfo.isLiving()) && (FastWebActivity.a(this.a) != null))
      {
        FastWebActivity.a(this.a).a("https://pub.idqqimg.com/pc/misc/files/20200611/2a67e74aa4ed4a71a8e877deac8e41cf.png");
        FastWebActivity.a(this.a).b("https://pub.idqqimg.com/pc/misc/files/20200611/558a344321d34d25b847cf32ff9403f8.png");
        if (this.a.a != null)
        {
          localFastWebActivity = this.a;
          localArticleInfo = this.a.a;
          i = (int)this.a.a.mChannelID;
          if ((FastWebActivity.a(this.a) == null) || (!FastWebActivity.a(this.a).c())) {
            break label216;
          }
          paramString = "2";
        }
      }
    }
    for (;;)
    {
      paramString = ozs.a(localFastWebActivity, localArticleInfo, i, paramString);
      try
      {
        paramString.put("live_circle_from_page", 1);
        ssy.a(this.a.a, "0X800B17D", paramString.toString());
        if ((FastWebActivity.a(this.a) != null) && (FastWebActivity.a(this.a) != null))
        {
          srw.a(this.a.a, FastWebActivity.a(this.a).c, paramReadInJoyUserInfo);
          FastWebActivity.c(this.a);
        }
        return;
        label216:
        paramString = "1";
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("FastWebActivity", 2, localJSONException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     snc
 * JD-Core Version:    0.7.0.1
 */