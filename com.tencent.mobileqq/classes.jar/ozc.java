import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.math.BigInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class ozc
{
  public static String a()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(243);
    double d = 3.0D;
    if (localAladdinConfig != null)
    {
      d = localAladdinConfig.getIntegerFromString("family_comment_card_hide_interval", 3);
      QLog.d("ReadInJoyCommentHelper", 1, "shoudHideCommentView | comment hide interval  " + d + " 天");
    }
    return "确定" + (int)d + "天内不再展示家族占领入口？";
  }
  
  public static boolean a()
  {
    long l = ((Long)bmqa.a("family_comment_card_hide_timestamp", Long.valueOf(-1L))).longValue();
    if (l == -1L)
    {
      QLog.d("ReadInJoyCommentHelper", 1, "shoudHideCommentView | false cuz never click hide btn ");
      return false;
    }
    AladdinConfig localAladdinConfig = Aladdin.getConfig(243);
    double d = 3.0D;
    if (localAladdinConfig != null)
    {
      d = localAladdinConfig.getIntegerFromString("family_comment_card_hide_interval", 3);
      QLog.d("ReadInJoyCommentHelper", 1, "shoudHideCommentView | comment hide interval  " + d + " 天");
    }
    if (System.currentTimeMillis() - l <= d * 24.0D * 60.0D * 60.0D * 1000.0D)
    {
      QLog.d("ReadInJoyCommentHelper", 1, "shoudHideCommentView | true ");
      return true;
    }
    QLog.d("ReadInJoyCommentHelper", 1, "shoudHideCommentView | false ");
    return false;
  }
  
  public Bundle a(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject1 = paramJSONObject.optString("uniqueKey");
      int i = paramJSONObject.optInt("source", 3);
      Object localObject2 = paramJSONObject.optString("feedsID", "");
      int j = paramJSONObject.optInt("feedsType", -1);
      int k = paramJSONObject.optInt("adTag", -1);
      String str3 = paramJSONObject.optString("title", "");
      Object localObject3 = paramJSONObject.optString("sourceName", "");
      String str4 = paramJSONObject.optString("picUrl", "");
      long l = paramJSONObject.optLong("duration", -1L);
      String str5 = paramJSONObject.optString("articleID", "");
      String str1 = paramJSONObject.optString("commentID");
      String str2 = paramJSONObject.optString("subCommentID");
      boolean bool = paramJSONObject.optBoolean("isAwesome");
      int m = paramJSONObject.optInt("jumpType");
      int n = paramJSONObject.optInt("serviceType", 5);
      QLog.d("ReadInJoyCommentHelper", 1, "constructCommentConfigData |   uniqueKey = " + (String)localObject1 + "source = " + i + "feedsId = " + (String)localObject2 + " feedsType=" + j + "adTag = " + k + "title = " + str3 + "sourceName = " + (String)localObject3 + "picUrl =" + str4 + "duration = " + l + "articleId =" + str5 + " feedsServiceType = " + n);
      paramJSONObject = new AnchorData();
      paramJSONObject.jdField_a_of_type_JavaLangString = str1;
      paramJSONObject.b = str2;
      paramJSONObject.jdField_a_of_type_Boolean = bool;
      localObject2 = new CommonCommentData(str5, j, (String)localObject2, k, str3, (String)localObject3, str4, l);
      QLog.d("ReadInJoyCommentHelper", 1, "constructCommentConfigData | commonCommentData " + localObject2 + "\n anchorData " + paramJSONObject);
      localObject3 = new ArticleInfo();
      ((ArticleInfo)localObject3).innerUniqueID = ((String)localObject1);
      ((ArticleInfo)localObject3).mTitle = str3;
      ((ArticleInfo)localObject3).mSummary = "";
      ((ArticleInfo)localObject3).mFirstPagePicUrl = str4;
      if ((localObject2 != null) && (!TextUtils.isEmpty(((CommonCommentData)localObject2).getArticleId()))) {
        ((ArticleInfo)localObject3).mArticleID = Long.parseLong(((CommonCommentData)localObject2).getArticleId());
      }
      if ((localObject2 != null) && (!TextUtils.isEmpty(((CommonCommentData)localObject2).getFeedsId()))) {
        ((ArticleInfo)localObject3).mFeedId = new BigInteger(((CommonCommentData)localObject2).getFeedsId()).longValue();
      }
      if ((localObject2 != null) && (((CommonCommentData)localObject2).getFeedsType() != -1)) {
        ((ArticleInfo)localObject3).mFeedType = ((CommonCommentData)localObject2).getFeedsType();
      }
      QLog.d("ReadInJoyCommentHelper", 1, "constructCommentConfigData | articleInfo " + localObject3);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putSerializable("commonCommentData", (Serializable)localObject2);
      ((Bundle)localObject1).putParcelable("anchorData", paramJSONObject);
      ((Bundle)localObject1).putParcelable("articleInfo", (Parcelable)localObject3);
      ((Bundle)localObject1).putInt("source", i);
      ((Bundle)localObject1).putString("commentId", str1);
      ((Bundle)localObject1).putString("subCommentId", str2);
      ((Bundle)localObject1).putBoolean("isAwesome", bool);
      ((Bundle)localObject1).putInt("jumpType", m);
      ((Bundle)localObject1).putBoolean("fromViola", true);
      ((Bundle)localObject1).putInt("serviceType", n);
      QLog.d("ReadInJoyCommentHelper", 1, "constructCommentConfigData | bundle " + localObject1);
      return localObject1;
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentHelper", 2, QLog.getStackTraceString(paramJSONObject));
      }
    }
    return new Bundle();
  }
  
  public ReadInJoyCommentListFragment a(String paramString, ozq paramozq, ozg paramozg)
  {
    QLog.d("ReadInJoyCommentHelper", 1, "buildCommentFragment | configJsonStr : " + paramString);
    try
    {
      paramString = new JSONObject(paramString);
      QLog.d("ReadInJoyCommentHelper", 2, "buildCommentFragment | paramJsonStr " + paramString.toString());
      paramString = a(paramString);
      ReadInJoyCommentListFragment localReadInJoyCommentListFragment = new ReadInJoyCommentListFragment();
      localReadInJoyCommentListFragment.setArguments(paramString);
      localReadInJoyCommentListFragment.a(paramozq);
      localReadInJoyCommentListFragment.a(paramozg);
      return localReadInJoyCommentListFragment;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ozc
 * JD-Core Version:    0.7.0.1
 */