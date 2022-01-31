import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;

public class pmh
  implements poa
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mKdLiveInfo == null) || (paramBaseArticleInfo.mSubArtilceList == null) || (paramBaseArticleInfo.mSubArtilceList.get(0) == null) || (((ArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0)).mKdLiveInfo == null)) {
      return new JSONObject();
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_live_double_video_cell");
    BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);
    qlb localqlb2 = paramBaseArticleInfo.mKdLiveInfo;
    qlb localqlb1 = localBaseArticleInfo.mKdLiveInfo;
    String str2 = " ";
    String str1 = str2;
    if (paramBaseArticleInfo.mSubscribeName != null)
    {
      str1 = str2;
      if (paramBaseArticleInfo.mSubscribeName.length() > 0)
      {
        if (paramBaseArticleInfo.mSubscribeName.length() <= 10) {
          break label555;
        }
        str1 = paramBaseArticleInfo.mSubscribeName.substring(0, 10);
        str1 = str1 + "...";
      }
    }
    localJSONObject.put("left_user_name_text", str1);
    localJSONObject.put("left_video_title_text", paramBaseArticleInfo.mTitle);
    localJSONObject.put("left_video_bg_url", paramBaseArticleInfo.mFirstPagePicUrl);
    localJSONObject.put("left_jump_url", paramBaseArticleInfo.mArticleContentUrl);
    localJSONObject.put("left_live_status_bg_url", localqlb2.a);
    if (!TextUtils.isEmpty(localqlb2.b)) {
      localJSONObject.put("left_live_status_icon_url", localqlb2.b);
    }
    localJSONObject.put("left_live_status_text", localqlb2.c);
    if (!TextUtils.isEmpty(localqlb2.d)) {
      localJSONObject.put("left_live_hot_icon_url", localqlb2.d);
    }
    localJSONObject.put("left_live_hot_text", localqlb2.e);
    str2 = " ";
    str1 = str2;
    if (localBaseArticleInfo.mSubscribeName != null)
    {
      str1 = str2;
      if (localBaseArticleInfo.mSubscribeName.length() > 0)
      {
        if (localBaseArticleInfo.mSubscribeName.length() <= 10) {
          break label563;
        }
        str1 = localBaseArticleInfo.mSubscribeName.substring(0, 10);
      }
    }
    label555:
    label563:
    for (str1 = str1 + "...";; str1 = localBaseArticleInfo.mSubscribeName)
    {
      localJSONObject.put("right_user_name_text", str1);
      localJSONObject.put("right_video_title_text", localBaseArticleInfo.mTitle);
      localJSONObject.put("right_video_bg_url", localBaseArticleInfo.mFirstPagePicUrl);
      localJSONObject.put("right_jump_url", localBaseArticleInfo.mArticleContentUrl);
      localJSONObject.put("right_live_status_bg_url", localqlb1.a);
      if (!TextUtils.isEmpty(localqlb1.b)) {
        localJSONObject.put("right_live_status_icon_url", localqlb1.b);
      }
      localJSONObject.put("right_live_status_text", localqlb1.c);
      if (!TextUtils.isEmpty(localqlb1.d)) {
        localJSONObject.put("right_live_hot_icon_url", localqlb1.d);
      }
      localJSONObject.put("right_live_hot_text", localqlb1.e);
      localJSONObject.put("left_jump_report_info", paramBaseArticleInfo.mReportCommonData);
      localJSONObject.put("right_jump_report_info", localBaseArticleInfo.mReportCommonData);
      QLog.d("LiveDoubleVideoProteusItem", 1, localJSONObject.toString());
      return localJSONObject;
      str1 = paramBaseArticleInfo.mSubscribeName;
      break;
    }
  }
  
  public void a(int paramInt1, Container paramContainer, pgd parampgd, int paramInt2) {}
  
  public boolean a(int paramInt, Container paramContainer, pgd parampgd, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pmh
 * JD-Core Version:    0.7.0.1
 */