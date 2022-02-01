import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class qeb
  implements qft
{
  private void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramJSONObject.put("info_avator_uin", paramBaseArticleInfo.mSubscribeID);
    String str2 = " ";
    String str1 = str2;
    if (paramBaseArticleInfo.mSubscribeName != null)
    {
      str1 = str2;
      if (paramBaseArticleInfo.mSubscribeName.length() > 0)
      {
        if (paramBaseArticleInfo.mSubscribeName.length() <= 10) {
          break label107;
        }
        str1 = paramBaseArticleInfo.mSubscribeName.substring(0, 10);
      }
    }
    label107:
    for (str1 = str1 + "...";; str1 = paramBaseArticleInfo.mSubscribeName)
    {
      paramJSONObject.put("nickname_text", str1);
      b(paramBaseArticleInfo, paramJSONObject);
      paramJSONObject.put("user_info_text", paramBaseArticleInfo.mTitle);
      return;
    }
  }
  
  private void b(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramBaseArticleInfo.mSocialFeedInfo.h == 2) {}
    for (int i = 1; (i != 0) && (!qcd.c(paramBaseArticleInfo)); i = 0)
    {
      paramJSONObject.put("user_desc_follow_text", pha.g(2131717263));
      paramJSONObject.put("is_show_followed", 1);
      paramBaseArticleInfo.showMyFollowText = 1;
      return;
    }
    paramJSONObject.put("is_show_followed", 0);
    paramBaseArticleInfo.showMyFollowText = 0;
  }
  
  private void c(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramBaseArticleInfo = paramBaseArticleInfo.mKdLiveInfo;
    if (!TextUtils.isEmpty(paramBaseArticleInfo.jdField_a_of_type_JavaLangString)) {
      paramJSONObject.put("live_status_bg_url", paramBaseArticleInfo.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(paramBaseArticleInfo.b)) {
      paramJSONObject.put("live_status_icon_url", paramBaseArticleInfo.b);
    }
    paramJSONObject.put("live_status_text", paramBaseArticleInfo.c);
    if (!TextUtils.isEmpty(paramBaseArticleInfo.d)) {
      paramJSONObject.put("live_hot_icon_url", paramBaseArticleInfo.d);
    }
    paramJSONObject.put("live_hot_text", paramBaseArticleInfo.e);
    paramJSONObject.put("jump_report_info", paramBaseArticleInfo.g);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mKdLiveInfo == null)) {
      return new JSONObject();
    }
    Object localObject = new qba();
    ((qba)localObject).a(paramBaseArticleInfo).b(paramBaseArticleInfo).g(paramBaseArticleInfo).h(paramBaseArticleInfo);
    try
    {
      ((qba)localObject).a(paramBaseArticleInfo, Long.parseLong(paramBaseArticleInfo.mSubscribeID));
      localObject = ((qba)localObject).a();
      ((JSONObject)localObject).put("style_ID", "ReadInJoy_live_video_cell");
      a(paramBaseArticleInfo, (JSONObject)localObject);
      ((JSONObject)localObject).put("article_large_imge_url", paramBaseArticleInfo.mFirstPagePicUrl);
      ((JSONObject)localObject).put("play_icon_url", "rij_multi_video_column_play");
      c(paramBaseArticleInfo, (JSONObject)localObject);
      switch (paramBaseArticleInfo.mKdLiveInfo.jdField_a_of_type_Int)
      {
      default: 
        ((JSONObject)localObject).put("video_info_visibility", "1");
        ((JSONObject)localObject).put("video_jump_url", paramBaseArticleInfo.mArticleContentUrl);
        ((JSONObject)localObject).put("video_jump_report_info", paramBaseArticleInfo.mReportCommonData);
        QLog.d("LiveSingleVideoProteusItem", 1, ((JSONObject)localObject).toString());
        return localObject;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("LiveSingleVideoProteusItem", 1, localNumberFormatException.toString());
        continue;
        ((JSONObject)localObject).put("avatar_info_visibility", "1");
        continue;
        ((JSONObject)localObject).put("bottom_info_visibility", "1");
      }
    }
  }
  
  public void a(int paramInt1, Container paramContainer, pxk parampxk, int paramInt2) {}
  
  public boolean a(int paramInt, Container paramContainer, pxk parampxk, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qeb
 * JD-Core Version:    0.7.0.1
 */