import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class swc
  implements pyb
{
  public swc(FastWebActivity paramFastWebActivity) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    QLog.e("FastWebActivity", 1, "onLoadUserInfoFailed " + paramString1 + " " + paramString2);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    QLog.d("FastWebActivity", 1, "onLoadUserInfoSucceed " + paramReadInJoyUserInfo);
    ArticleInfo localArticleInfo;
    int i;
    if ((paramReadInJoyUserInfo != null) && (paramReadInJoyUserInfo.isLiving()) && (FastWebActivity.a(this.a) != null))
    {
      FastWebActivity.a(this.a).a("https://pub.idqqimg.com/pc/misc/files/20200611/2a67e74aa4ed4a71a8e877deac8e41cf.png");
      FastWebActivity.a(this.a).b("https://pub.idqqimg.com/pc/misc/files/20200611/558a344321d34d25b847cf32ff9403f8.png");
      if (this.a.a != null)
      {
        paramReadInJoyUserInfo = this.a;
        localArticleInfo = this.a.a;
        i = (int)this.a.a.mChannelID;
        if ((FastWebActivity.a(this.a) == null) || (!FastWebActivity.a(this.a).c())) {
          break label166;
        }
        paramString = "2";
      }
    }
    for (;;)
    {
      paramString = pha.a(paramReadInJoyUserInfo, localArticleInfo, i, paramString);
      try
      {
        paramString.put("live_circle_from_page", 1);
        tcc.a(this.a.a, "0X800B17D", paramString.toString());
        return;
        label166:
        paramString = "1";
      }
      catch (JSONException paramReadInJoyUserInfo)
      {
        for (;;)
        {
          QLog.e("FastWebActivity", 2, paramReadInJoyUserInfo.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     swc
 * JD-Core Version:    0.7.0.1
 */