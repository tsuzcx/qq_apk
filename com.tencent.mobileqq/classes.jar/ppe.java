import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

public class ppe
  implements ViewBase.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public ppe(ArticleInfo paramArticleInfo, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private static String a(ArticleInfo paramArticleInfo, int paramInt, AtomicLong paramAtomicLong)
  {
    if (paramArticleInfo == null)
    {
      paramAtomicLong = "";
      return paramAtomicLong;
    }
    String str4 = "";
    long l2 = 0L;
    long l1;
    String str1;
    if ((rqj.a(paramArticleInfo)) || (paramInt == 77) || (paramInt == 78))
    {
      l1 = l2;
      str1 = str4;
      if (TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {}
    }
    label650:
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(paramArticleInfo.mSubscribeID);
        str1 = oqu.k + bdbi.encodeToString(String.valueOf(l1).getBytes(), 2);
        if (!TextUtils.isEmpty(str1)) {
          break label650;
        }
        if (TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {
          break label524;
        }
        try
        {
          l2 = Long.parseLong(paramArticleInfo.mSubscribeID);
          l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          String str2;
          localNumberFormatException2.printStackTrace();
          continue;
        }
        str1 = oqu.k + bdbi.encodeToString(String.valueOf(l1).getBytes(), 2);
        if (paramAtomicLong != null) {
          paramAtomicLong.set(l1);
        }
        paramAtomicLong = str1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("OnSocialAvatarClickListener", 2, "uin = " + l1 + " url =  articleID = " + paramArticleInfo.mArticleID);
        return str1;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        localNumberFormatException1.printStackTrace();
        l1 = l2;
        continue;
      }
      if ((rqj.b(paramArticleInfo)) || (paramInt == 72) || (paramInt == 74))
      {
        l1 = l2;
        str2 = str4;
        if (paramArticleInfo.mSocialFeedInfo != null)
        {
          l1 = l2;
          str2 = str4;
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw != null)
          {
            l1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.a;
            str2 = oqu.g + bdbi.encodeToString(String.valueOf(l1).getBytes(), 2);
          }
        }
      }
      else if ((paramInt == 76) || (rqj.a(paramArticleInfo)))
      {
        l1 = l2;
        str2 = str4;
        if (paramArticleInfo.mSocialFeedInfo != null)
        {
          l1 = l2;
          str2 = str4;
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme != null)
          {
            l1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme.a;
            str2 = oqu.g + bdbi.encodeToString(String.valueOf(l1).getBytes(), 2);
          }
        }
      }
      else if ((!rqj.f(paramArticleInfo)) && (paramInt != 73))
      {
        l1 = l2;
        str2 = str4;
        if (paramInt != 75) {}
      }
      else
      {
        l1 = l2;
        str2 = str4;
        if (paramArticleInfo.mSocialFeedInfo != null)
        {
          l1 = l2;
          str2 = str4;
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme != null)
          {
            l1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme.a;
            str2 = oqu.g + bdbi.encodeToString(String.valueOf(l1).getBytes(), 2);
            continue;
            label524:
            String str3;
            if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw != null))
            {
              l1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.a;
              str3 = oqu.g + bdbi.encodeToString(String.valueOf(l1).getBytes(), 2);
            }
            else if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme != null))
            {
              l1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme.a;
              str3 = oqu.g + bdbi.encodeToString(String.valueOf(l1).getBytes(), 2);
            }
          }
        }
      }
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt)
  {
    AtomicLong localAtomicLong = new AtomicLong();
    String str = a(paramArticleInfo, paramInt, localAtomicLong);
    if (!TextUtils.isEmpty(str))
    {
      ors.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
      ors.a(paramContext, str);
      a(paramArticleInfo, ors.d(paramArticleInfo), localAtomicLong.get());
    }
  }
  
  private static void a(ArticleInfo paramArticleInfo, String paramString, long paramLong)
  {
    if (paramArticleInfo == null) {
      return;
    }
    Object localObject = "1";
    if (rqj.b(paramArticleInfo))
    {
      localObject = "3";
      String str = ors.a((String)localObject, paramArticleInfo, paramLong);
      if (!szp.a(paramArticleInfo.mChannelID)) {
        break label185;
      }
      localObject = "0X800935C";
      label43:
      nrt.a(null, String.valueOf(paramLong), (String)localObject, (String)localObject, 0, 0, String.valueOf(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str, false);
    }
    for (;;)
    {
      try
      {
        localObject = ors.a();
        ((JSONObject)localObject).put("feeds_source", paramString);
        ((JSONObject)localObject).put("kandian_mode", ors.e());
        paramString = ors.e(paramArticleInfo);
        if (!szp.a(paramArticleInfo.mChannelID)) {
          break label192;
        }
        paramArticleInfo = "0X8009357";
        nrt.a(null, "CliOper", "", "", paramArticleInfo, paramArticleInfo, 0, 0, paramString, "", "", ((JSONObject)localObject).toString(), false);
        return;
      }
      catch (JSONException paramArticleInfo)
      {
        paramArticleInfo.printStackTrace();
        return;
      }
      if (!rqj.a(paramArticleInfo)) {
        break;
      }
      localObject = "4";
      break;
      label185:
      localObject = "0X8007BA3";
      break label43;
      label192:
      paramArticleInfo = "0X800744D";
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ppe
 * JD-Core Version:    0.7.0.1
 */