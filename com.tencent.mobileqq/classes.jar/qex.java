import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class qex
  extends qfo
{
  public qex(ArticleInfo paramArticleInfo, Context paramContext)
  {
    super(paramArticleInfo, paramContext);
  }
  
  private void a(ButtonBase paramButtonBase)
  {
    boolean bool = true;
    int i;
    if (paramButtonBase.isSelected())
    {
      i = -1;
      paramButtonBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo;
      paramButtonBase.b += i;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.b < 0) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.b = 0;
      }
      paramButtonBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo;
      if (i <= 0) {
        break label136;
      }
    }
    label136:
    for (int j = 1;; j = 0)
    {
      paramButtonBase.c = j;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.invalidateProteusTemplateBean();
      pay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      if ((!pay.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID))) {
        break label141;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ATLAS", 2, "atlas native has undercarriage");
      }
      pkp.a().b();
      return;
      i = 1;
      break;
    }
    label141:
    paramButtonBase = pkm.a();
    long l1 = pay.a();
    long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId;
    if (i > 0) {}
    for (;;)
    {
      paramButtonBase.a(l1, l2, bool, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.clone());
      break;
      bool = false;
    }
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.c == 1) {
      return 2;
    }
    return 13;
  }
  
  protected void a(ArticleInfo paramArticleInfo)
  {
    String str2 = pay.a(paramArticleInfo);
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    boolean bool = uhv.a(paramArticleInfo.mChannelID);
    Object localObject;
    String str1;
    if (bool)
    {
      localObject = "0X800935E";
      if (!bool) {
        break label163;
      }
      str1 = "0X800935F";
      label35:
      if (localSocializeFeedsInfo.c != 1) {
        break label268;
      }
      if ((!pgb.i(paramArticleInfo)) && (!pgb.g(paramArticleInfo)) && (!pgb.j(paramArticleInfo)) && (!pgb.k(paramArticleInfo))) {
        break label170;
      }
      if (!pgb.o(paramArticleInfo)) {
        odq.a(null, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Long), (String)localObject, (String)localObject, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, str2, false);
      }
      if ((!pay.l(paramArticleInfo)) && (!pay.m(paramArticleInfo))) {
        pgw.b(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      }
    }
    label163:
    label170:
    do
    {
      return;
      localObject = "0X8007B65";
      break;
      str1 = "0X8007B66";
      break label35;
      if (pay.b(paramArticleInfo))
      {
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("like", 0);
          ozb.a(this.jdField_a_of_type_AndroidContentContext, paramArticleInfo, "0X8009A74", (JSONObject)localObject);
          return;
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            localJSONException1.printStackTrace();
          }
        }
      }
      odq.a(null, paramArticleInfo.mSubscribeID, (String)localObject, (String)localObject, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str2, false);
      return;
      if ((!pgb.i(paramArticleInfo)) && (!pgb.g(paramArticleInfo)) && (!pgb.j(paramArticleInfo)) && (!pgb.k(paramArticleInfo))) {
        break label383;
      }
      if (!pgb.o(paramArticleInfo)) {
        odq.a(null, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Long), localJSONException1, localJSONException1, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, str2, false);
      }
    } while ((pay.l(paramArticleInfo)) || (pay.m(paramArticleInfo)));
    label268:
    pgw.b(paramArticleInfo, (int)paramArticleInfo.mChannelID);
    return;
    label383:
    if (pay.b(paramArticleInfo))
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("like", 1);
        ozb.a(this.jdField_a_of_type_AndroidContentContext, paramArticleInfo, "0X8009A74", (JSONObject)localObject);
        return;
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
    odq.a(null, paramArticleInfo.mSubscribeID, localJSONException2, localJSONException2, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str2, false);
  }
  
  protected void a(ViewBase paramViewBase)
  {
    QLog.d("OnLikeClickListener", 1, "cick like");
    if ((paramViewBase instanceof ButtonBase)) {
      a((ButtonBase)paramViewBase);
    }
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_like_button");
    } while ((paramViewBase == null) || (!(paramViewBase instanceof qhs)));
    ((qhs)paramViewBase).onClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qex
 * JD-Core Version:    0.7.0.1
 */