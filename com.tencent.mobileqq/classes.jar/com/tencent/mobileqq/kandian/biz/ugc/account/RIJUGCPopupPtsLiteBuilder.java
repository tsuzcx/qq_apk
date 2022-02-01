package com.tencent.mobileqq.kandian.biz.ugc.account;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteItemViewHandler;
import com.tencent.mobileqq.kandian.repo.pts.PTSStyleManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJUGCPopupPtsLiteBuilder
{
  private Context jdField_a_of_type_AndroidContentContext;
  private PTSLiteItemViewHandler jdField_a_of_type_ComTencentMobileqqKandianBizPtsLitePTSLiteItemViewHandler;
  
  public RIJUGCPopupPtsLiteBuilder(Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsLitePTSLiteItemViewHandler = new PTSLiteItemViewHandler(paramContext);
    b();
    a(paramViewGroup);
  }
  
  private String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(RIJUGCAddAccountFragment.a());
      localStringBuilder1.append(" ");
      localStringBuilder1.append(RIJUGCAddAccountAladdinUtils.a());
      localJSONObject.put("tips", localStringBuilder1.toString());
      localJSONObject.put("edit_profile_text", RIJUGCAddAccountAladdinUtils.c());
      localJSONObject.put("use_origin_account_text", RIJUGCAddAccountAladdinUtils.b());
      localJSONObject.put("accountUin", ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[getJsonData] error, e = ");
      localStringBuilder2.append(localJSONException);
      QLog.e("RIJUGCPopupPtsLiteBuilder", 1, localStringBuilder2.toString());
    }
    return localJSONObject.toString();
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {
      return;
    }
    Object localObject = PTSStyleManager.a().a("default_feeds", "ugc_account_popup");
    String str = a();
    localObject = new PTSItemData.Builder().withItemID("RIJUGCPopupPtsLiteBuilder").withPageName("ugc_account_popup").withFrameTreeJson((String)localObject).withJsonData(str).build();
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsLitePTSLiteItemViewHandler.a(null, (PTSItemData)localObject);
    if (localObject != null) {
      paramViewGroup.addView((View)localObject);
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsLitePTSLiteItemViewHandler.a(new RIJUGCPopupPtsLiteBuilder.1(this));
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsLitePTSLiteItemViewHandler.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.account.RIJUGCPopupPtsLiteBuilder
 * JD-Core Version:    0.7.0.1
 */