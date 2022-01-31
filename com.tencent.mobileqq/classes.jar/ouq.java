import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.List;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class ouq
  implements owa
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool2 = true;
    Object localObject1;
    boolean bool3;
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSubArtilceList != null) && (paramBaseArticleInfo.mSubArtilceList.size() > 0))
    {
      localObject1 = (ArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);
      localJSONObject = new JSONObject();
      paramInt = bgmq.d();
      bool3 = bgmq.q();
      if (paramBaseArticleInfo == null) {}
    }
    try
    {
      i = paramBaseArticleInfo.getCommentCount();
      if (i <= 0) {
        break label708;
      }
      localObject2 = qcn.e(i);
      label78:
      if (bool3)
      {
        localJSONObject.put("left_comment_count", (String)localObject2 + ajjy.a(2131647133));
        localJSONObject.put("left_play_count", qcn.c(paramBaseArticleInfo.mVideoPlayCount));
        localJSONObject.put("play_icon", "ReadInJoy/video_play_icon.png");
      }
      localJSONObject.put("left_article_title", paramBaseArticleInfo.mTitle);
      if ((!paramBaseArticleInfo.isUseGif) || (!badq.h(BaseApplicationImpl.getContext()))) {
        break label777;
      }
      bool1 = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        QLog.d("DoubleVideoProteusItem", 2, localException.getMessage());
        continue;
        Object localObject2 = "0";
        continue;
        localJSONObject.put("right_cover_image_url", localException.getVideoCoverUrlWithSmartCut(true).getFile());
        continue;
        boolean bool1 = false;
        continue;
        bool1 = false;
      }
    }
    paramBaseArticleInfo.isShowGif = bool1;
    if (paramBaseArticleInfo.isShowGif)
    {
      localJSONObject.put("left_cover_gif", paramBaseArticleInfo.gifCoverUrl);
      localJSONObject.put("left_cover_url", paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(true).getFile());
    }
    for (;;)
    {
      long l;
      if ((paramBaseArticleInfo.isAccountShown) && (paramBaseArticleInfo.mPartnerAccountInfo != null))
      {
        l = paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get();
        localJSONObject.put("left_account_uin", l + "");
        localObject2 = obz.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localJSONObject.put("left_account_small_icon_url", localObject2);
        }
      }
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mVideoArticleSubsColor))
      {
        localJSONObject.put("left_item_subscript_text", paramBaseArticleInfo.mVideoArticleSubsText);
        String str = paramBaseArticleInfo.mVideoArticleSubsColor;
        localObject2 = str;
        if (TextUtils.isEmpty(str)) {
          localObject2 = "#00a5e0";
        }
        localJSONObject.put("left_item_subscript_bg_color", localObject2);
      }
      if (localObject1 != null)
      {
        i = ((BaseArticleInfo)localObject1).getCommentCount();
        if (i <= 0) {
          break label750;
        }
        localObject2 = qcn.e(i);
        if (bool3)
        {
          localJSONObject.put("right_comment_count", (String)localObject2 + ajjy.a(2131647133));
          localJSONObject.put("right_play_count", qcn.c(((BaseArticleInfo)localObject1).mVideoPlayCount));
          localJSONObject.put("play_icon", "ReadInJoy/video_play_icon.png");
        }
        localJSONObject.put("right_article_title", ((BaseArticleInfo)localObject1).mTitle);
        if ((!((BaseArticleInfo)localObject1).isUseGif) || (!badq.h(BaseApplicationImpl.getContext()))) {
          break label783;
        }
        bool1 = bool2;
        ((BaseArticleInfo)localObject1).isShowGif = bool1;
        if (!((BaseArticleInfo)localObject1).isShowGif) {
          break label757;
        }
        localJSONObject.put("right_cover_gif", ((BaseArticleInfo)localObject1).gifCoverUrl);
        localJSONObject.put("right_cover_url", ((BaseArticleInfo)localObject1).getVideoCoverUrlWithSmartCut(true).getFile());
        if ((((BaseArticleInfo)localObject1).isAccountShown) && (((BaseArticleInfo)localObject1).mPartnerAccountInfo != null))
        {
          l = ((BaseArticleInfo)localObject1).mPartnerAccountInfo.uint64_uin.get();
          localJSONObject.put("right_account_uin", l + "");
          localObject2 = obz.a(((BaseArticleInfo)localObject1).mPartnerAccountInfo.bytes_v_icon_url);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localJSONObject.put("right_account_small_icon_url", localObject2);
          }
        }
        if (!TextUtils.isEmpty(((BaseArticleInfo)localObject1).mVideoArticleSubsColor))
        {
          localJSONObject.put("right_item_subscript_text", ((BaseArticleInfo)localObject1).mVideoArticleSubsText);
          localObject2 = ((BaseArticleInfo)localObject1).mVideoArticleSubsColor;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = "#00a5e0";
          }
          localJSONObject.put("right_item_subscript_bg_color", localObject1);
        }
      }
      localJSONObject.put("title_num", paramInt + "");
      localJSONObject.put("style_ID", "ReadInjoy_double_video_cell");
      otl.a(localJSONObject, paramBaseArticleInfo);
      return localJSONObject;
      localObject1 = null;
      break;
      label708:
      localObject2 = "0";
      break label78;
      localJSONObject.put("left_cover_image_url", paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(true).getFile());
    }
  }
  
  public void a(int paramInt1, Container paramContainer, opw paramopw, int paramInt2)
  {
    ArticleInfo localArticleInfo2 = paramopw.a();
    if (localArticleInfo2 != null) {
      if ((localArticleInfo2 == null) || (localArticleInfo2.mSubArtilceList == null) || (localArticleInfo2.mSubArtilceList.size() <= 0)) {
        break label96;
      }
    }
    label96:
    for (ArticleInfo localArticleInfo1 = (ArticleInfo)localArticleInfo2.mSubArtilceList.get(0);; localArticleInfo1 = null)
    {
      if ((localArticleInfo2 != null) && (localArticleInfo2.isAccountShown)) {
        oxx.a(paramContainer, paramopw, "id_left_account_name");
      }
      if ((localArticleInfo1 != null) && (localArticleInfo1.isAccountShown)) {
        oxx.a(paramContainer, paramopw, "id_right_account_name");
      }
      return;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, opw paramopw, ViewBase paramViewBase)
  {
    paramInt = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
    ArticleInfo localArticleInfo = paramopw.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSubArtilceList != null) && (localArticleInfo.mSubArtilceList.size() > 0)) {}
    for (paramContainer = (ArticleInfo)localArticleInfo.mSubArtilceList.get(0); (localArticleInfo == null) || (paramContainer == null); paramContainer = null) {
      return false;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 1120: 
    case 1121: 
      paramViewBase.setOnClickListener(new our(this, paramInt, localArticleInfo, paramContainer, paramopw));
      return true;
    case 1149: 
    case 1150: 
      paramViewBase.setOnClickListener(new ous(this, paramInt, paramopw, localArticleInfo, paramContainer));
      return true;
    }
    paramViewBase.setOnClickListener(new out(this, paramInt, paramopw, localArticleInfo, paramContainer));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ouq
 * JD-Core Version:    0.7.0.1
 */