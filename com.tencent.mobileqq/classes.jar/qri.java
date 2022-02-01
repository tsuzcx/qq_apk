import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class qri
  implements ViewBase.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public qri(ArticleInfo paramArticleInfo, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  @NotNull
  public static qrj a(ArticleInfo paramArticleInfo, int paramInt)
  {
    int m = 0;
    qrj localqrj = new qrj();
    if (paramArticleInfo == null) {
      return localqrj;
    }
    boolean bool1 = ppe.a(paramArticleInfo);
    int i;
    boolean bool2;
    int j;
    label59:
    int k;
    label68:
    boolean bool3;
    boolean bool4;
    if ((paramInt == 77) || (paramInt == 78))
    {
      i = 1;
      bool2 = ppe.g(paramArticleInfo);
      if ((paramInt != 72) && (paramInt != 74)) {
        break label232;
      }
      j = 1;
      if (paramInt != 76) {
        break label237;
      }
      k = 1;
      bool3 = ppe.a(paramArticleInfo);
      bool4 = ppe.f(paramArticleInfo);
      if ((paramInt == 73) || (paramInt == 75)) {
        m = 1;
      }
      if ((!bool1) && (i == 0)) {
        break label243;
      }
      if (!TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {
        a(localqrj, paramArticleInfo.mSubscribeID);
      }
      label123:
      if (TextUtils.isEmpty(localqrj.jdField_a_of_type_JavaLangString))
      {
        if (TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {
          break label342;
        }
        a(localqrj, paramArticleInfo.mSubscribeID);
      }
    }
    for (;;)
    {
      localqrj.jdField_a_of_type_JavaLangString = uvs.a(paramArticleInfo, localqrj.jdField_a_of_type_JavaLangString, uvs.e);
      QLog.d("OnSocialAvatarClickListener", 1, "uin = " + localqrj.jdField_a_of_type_Long + " url = " + localqrj.jdField_a_of_type_JavaLangString + " articleID = " + paramArticleInfo.mArticleID);
      return localqrj;
      i = 0;
      break;
      label232:
      j = 0;
      break label59;
      label237:
      k = 0;
      break label68;
      label243:
      if ((bool2) || (j != 0))
      {
        if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq == null)) {
          break label123;
        }
        a(localqrj, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Long);
        break label123;
      }
      if (((k == 0) && (!bool3) && (!bool4) && (m == 0)) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy == null)) {
        break label123;
      }
      a(localqrj, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.jdField_a_of_type_Long);
      break label123;
      label342:
      if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq != null)) {
        a(localqrj, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Long);
      } else if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy != null)) {
        a(localqrj, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.jdField_a_of_type_Long);
      }
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt)
  {
    qrj localqrj = a(paramArticleInfo, paramInt);
    if (!TextUtils.isEmpty(localqrj.jdField_a_of_type_JavaLangString))
    {
      pqx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
      pkh.a(paramContext, localqrj.jdField_a_of_type_JavaLangString);
      a(paramArticleInfo, pqw.b(paramArticleInfo), localqrj.jdField_a_of_type_Long);
    }
  }
  
  private static void a(ArticleInfo paramArticleInfo, String paramString, long paramLong)
  {
    if (paramArticleInfo == null) {
      return;
    }
    Object localObject = "1";
    if (ppe.g(paramArticleInfo))
    {
      localObject = "3";
      String str = pqf.a((String)localObject, paramArticleInfo, paramLong);
      if (!uvs.a(paramArticleInfo.mChannelID)) {
        break label185;
      }
      localObject = "0X800935C";
      label43:
      olh.a(null, String.valueOf(paramLong), (String)localObject, (String)localObject, 0, 0, String.valueOf(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str, false);
    }
    for (;;)
    {
      try
      {
        localObject = pqf.a();
        ((JSONObject)localObject).put("feeds_source", paramString);
        ((JSONObject)localObject).put("kandian_mode", pqu.a());
        paramString = pqw.c(paramArticleInfo);
        if (!uvs.a(paramArticleInfo.mChannelID)) {
          break label192;
        }
        paramArticleInfo = "0X8009357";
        olh.a(null, "CliOper", "", "", paramArticleInfo, paramArticleInfo, 0, 0, paramString, "", "", ((JSONObject)localObject).toString(), false);
        return;
      }
      catch (JSONException paramArticleInfo)
      {
        paramArticleInfo.printStackTrace();
        return;
      }
      if (!ppe.a(paramArticleInfo)) {
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
  
  @VisibleForTesting
  static void a(@NotNull qrj paramqrj, long paramLong)
  {
    paramqrj.jdField_a_of_type_Long = paramLong;
    paramqrj.jdField_a_of_type_JavaLangString = (pjj.g + bhcu.encodeToString(String.valueOf(paramqrj.jdField_a_of_type_Long).getBytes(), 2));
  }
  
  @VisibleForTesting
  static void a(@NotNull qrj paramqrj, @NotNull String paramString)
  {
    try
    {
      paramqrj.jdField_a_of_type_Long = Long.parseLong(paramString);
      paramqrj.jdField_a_of_type_JavaLangString = (pjj.k + bhcu.encodeToString(String.valueOf(paramqrj.jdField_a_of_type_Long).getBytes(), 2));
      return;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qri
 * JD-Core Version:    0.7.0.1
 */