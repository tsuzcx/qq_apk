import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ppa
  extends ppl
{
  public ppa(ArticleInfo paramArticleInfo, Context paramContext)
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
      ors.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      if ((!ors.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID))) {
        break label141;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ATLAS", 2, "atlas native has undercarriage");
      }
      oxb.a().b();
      return;
      i = 1;
      break;
    }
    label141:
    paramButtonBase = owy.a();
    long l1 = ors.a();
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
    String str2 = ors.a(paramArticleInfo);
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    boolean bool = szp.a(paramArticleInfo.mChannelID);
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
      if ((!rqj.i(paramArticleInfo)) && (!rqj.b(paramArticleInfo)) && (!rqj.j(paramArticleInfo)) && (!rqj.k(paramArticleInfo))) {
        break label170;
      }
      if (!rqj.o(paramArticleInfo)) {
        nrt.a(null, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Long), (String)localObject, (String)localObject, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, str2, false);
      }
      if ((!ors.k(paramArticleInfo)) && (!ors.l(paramArticleInfo))) {
        rqj.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
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
      if (ors.b(paramArticleInfo))
      {
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("like", 0);
          opn.a(this.jdField_a_of_type_AndroidContentContext, paramArticleInfo, "0X8009A74", (JSONObject)localObject);
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
      nrt.a(null, paramArticleInfo.mSubscribeID, (String)localObject, (String)localObject, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str2, false);
      return;
      if ((!rqj.i(paramArticleInfo)) && (!rqj.b(paramArticleInfo)) && (!rqj.j(paramArticleInfo)) && (!rqj.k(paramArticleInfo))) {
        break label383;
      }
      if (!rqj.o(paramArticleInfo)) {
        nrt.a(null, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Long), localJSONException1, localJSONException1, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, str2, false);
      }
    } while ((ors.k(paramArticleInfo)) || (ors.l(paramArticleInfo)));
    label268:
    rqj.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
    return;
    label383:
    if (ors.b(paramArticleInfo))
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("like", 1);
        opn.a(this.jdField_a_of_type_AndroidContentContext, paramArticleInfo, "0X8009A74", (JSONObject)localObject);
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
    nrt.a(null, paramArticleInfo.mSubscribeID, localJSONException2, localJSONException2, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str2, false);
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
    } while ((paramViewBase == null) || (!(paramViewBase instanceof prf)));
    ((prf)paramViewBase).onClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ppa
 * JD-Core Version:    0.7.0.1
 */