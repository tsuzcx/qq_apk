import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.qphone.base.util.QLog;

public class teo
  implements qhl
{
  public teo(FastWebActivity paramFastWebActivity) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    QLog.e("FastWebActivity", 1, "onLoadUserInfoFailed " + paramString1 + " " + paramString2);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    QLog.d("FastWebActivity", 1, "onLoadUserInfoSucceed " + paramReadInJoyUserInfo);
    if ((paramReadInJoyUserInfo != null) && (FastWebActivity.a(this.a) != null) && (FastWebActivity.a(this.a) != null))
    {
      tjf.a(this.a.a, FastWebActivity.a(this.a).c, paramReadInJoyUserInfo);
      FastWebActivity.d(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     teo
 * JD-Core Version:    0.7.0.1
 */