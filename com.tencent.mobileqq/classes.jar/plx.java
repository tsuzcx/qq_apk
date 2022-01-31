import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class plx
  implements poa
{
  private Map<String, Object> a(TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((paramTemplateBean == null) || (paramViewBase == null)) {
      return null;
    }
    return paramTemplateBean.getDataAttribute(paramViewBase.getName());
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject1;
    boolean bool2;
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSubArtilceList != null) && (paramBaseArticleInfo.mSubArtilceList.size() > 0))
    {
      localObject1 = (ArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);
      localJSONObject = new JSONObject();
      paramInt = bjxj.d();
      bool2 = bjxj.q();
      if (paramBaseArticleInfo == null) {}
    }
    try
    {
      i = paramBaseArticleInfo.getCommentCount();
      if (i <= 0) {
        break label893;
      }
      localObject2 = rdm.e(i);
      label75:
      if (bool2)
      {
        localJSONObject.put("left_comment_count", (String)localObject2 + alpo.a(2131713304));
        localJSONObject.put("left_play_count", rdm.c(paramBaseArticleInfo.mVideoPlayCount));
        localJSONObject.put("play_icon", "ReadInJoy/video_play_icon.png");
      }
      localJSONObject.put("left_article_title", paramBaseArticleInfo.mTitle);
      if ((!paramBaseArticleInfo.isUseGif) || (!bdee.h(BaseApplicationImpl.getContext()))) {
        break label1069;
      }
      bool1 = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        boolean bool1;
        Object localObject3;
        label893:
        QLog.d("DoubleVideoProteusItem", 2, localException.getMessage());
        continue;
        Object localObject2 = "0";
        continue;
        localJSONObject.put("right_cover_image_url", localException.getVideoCoverUrlWithSmartCut(true).getFile());
        continue;
        if (((VideoColumnInfo)localObject2).a != 0)
        {
          localJSONObject.put("column_tips_left", "栏目");
          localJSONObject.put("column_name_left", ((VideoColumnInfo)localObject2).b);
          localJSONObject.put("readinjoy_column_icon_left", "readinjoy_column_icon_white");
        }
        if (((VideoColumnInfo)localObject3).a != 0)
        {
          localJSONObject.put("column_tips_right", "栏目");
          localJSONObject.put("column_name_right", ((VideoColumnInfo)localObject3).b);
          localJSONObject.put("readinjoy_column_icon_right", "readinjoy_column_icon_white");
          continue;
          String str = "";
          continue;
          bool1 = false;
          continue;
          bool1 = false;
          continue;
          localObject2 = "";
        }
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
        localObject2 = ors.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localJSONObject.put("left_account_small_icon_url", localObject2);
        }
      }
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mVideoArticleSubsColor))
      {
        localJSONObject.put("left_item_subscript_text", paramBaseArticleInfo.mVideoArticleSubsText);
        localObject3 = paramBaseArticleInfo.mVideoArticleSubsColor;
        localObject2 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject2 = "#00a5e0";
        }
        localJSONObject.put("left_item_subscript_bg_color", localObject2);
      }
      if (localObject1 != null)
      {
        i = ((BaseArticleInfo)localObject1).getCommentCount();
        if (i <= 0) {
          break label938;
        }
        localObject2 = rdm.e(i);
        if (bool2)
        {
          localJSONObject.put("right_comment_count", (String)localObject2 + alpo.a(2131713304));
          localJSONObject.put("right_play_count", rdm.c(((BaseArticleInfo)localObject1).mVideoPlayCount));
          localJSONObject.put("play_icon", "ReadInJoy/video_play_icon.png");
        }
        localJSONObject.put("right_article_title", ((BaseArticleInfo)localObject1).mTitle);
        if ((!((BaseArticleInfo)localObject1).isUseGif) || (!bdee.h(BaseApplicationImpl.getContext()))) {
          break label1075;
        }
        bool1 = true;
        ((BaseArticleInfo)localObject1).isShowGif = bool1;
        if (!((BaseArticleInfo)localObject1).isShowGif) {
          break label946;
        }
        localJSONObject.put("right_cover_gif", ((BaseArticleInfo)localObject1).gifCoverUrl);
        localJSONObject.put("right_cover_url", ((BaseArticleInfo)localObject1).getVideoCoverUrlWithSmartCut(true).getFile());
        if ((((BaseArticleInfo)localObject1).isAccountShown) && (((BaseArticleInfo)localObject1).mPartnerAccountInfo != null))
        {
          l = ((BaseArticleInfo)localObject1).mPartnerAccountInfo.uint64_uin.get();
          localJSONObject.put("right_account_uin", l + "");
          localObject2 = ors.a(((BaseArticleInfo)localObject1).mPartnerAccountInfo.bytes_v_icon_url);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localJSONObject.put("right_account_small_icon_url", localObject2);
          }
        }
        if (!TextUtils.isEmpty(((BaseArticleInfo)localObject1).mVideoArticleSubsColor))
        {
          localJSONObject.put("right_item_subscript_text", ((BaseArticleInfo)localObject1).mVideoArticleSubsText);
          localObject3 = ((BaseArticleInfo)localObject1).mVideoArticleSubsColor;
          localObject2 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            localObject2 = "#00a5e0";
          }
          localJSONObject.put("right_item_subscript_bg_color", localObject2);
        }
      }
      if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.columnEntrances != null) && (!paramBaseArticleInfo.columnEntrances.isEmpty()) && (localObject1 != null) && (((BaseArticleInfo)localObject1).columnEntrances != null) && (!((BaseArticleInfo)localObject1).columnEntrances.isEmpty()))
      {
        localObject2 = (VideoColumnInfo)paramBaseArticleInfo.columnEntrances.get(0);
        localObject3 = (VideoColumnInfo)((BaseArticleInfo)localObject1).columnEntrances.get(0);
        if ((localObject2 != null) && (localObject3 != null))
        {
          if ((((VideoColumnInfo)localObject2).a == 0) || (((VideoColumnInfo)localObject2).a != ((VideoColumnInfo)localObject3).a)) {
            break label967;
          }
          pkm.aj(paramBaseArticleInfo, localJSONObject);
        }
      }
      localJSONObject.put("title_num", paramInt + "");
      if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.multiVideoColumnInfo == null)) {
        break label1081;
      }
      localObject2 = Integer.valueOf(paramBaseArticleInfo.multiVideoColumnInfo.a);
      localJSONObject.put("column_id_1", localObject2);
      if ((localObject1 == null) || (((BaseArticleInfo)localObject1).multiVideoColumnInfo == null)) {
        break label1062;
      }
      localObject1 = Integer.valueOf(((BaseArticleInfo)localObject1).multiVideoColumnInfo.a);
      localJSONObject.put("column_id_2", localObject1);
      localJSONObject.put("style_ID", "ReadInjoy_double_video_cell");
      pkm.a(localJSONObject, paramBaseArticleInfo);
      return localJSONObject;
      localObject1 = null;
      break;
      localObject2 = "0";
      break label75;
      localJSONObject.put("left_cover_image_url", paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(true).getFile());
    }
  }
  
  public void a(int paramInt1, Container paramContainer, pgd parampgd, int paramInt2)
  {
    ArticleInfo localArticleInfo2 = parampgd.a();
    if (localArticleInfo2 != null) {
      if ((localArticleInfo2 == null) || (localArticleInfo2.mSubArtilceList == null) || (localArticleInfo2.mSubArtilceList.size() <= 0)) {
        break label105;
      }
    }
    label105:
    for (ArticleInfo localArticleInfo1 = (ArticleInfo)localArticleInfo2.mSubArtilceList.get(0);; localArticleInfo1 = null)
    {
      if ((localArticleInfo2 != null) && (localArticleInfo2.isAccountShown)) {
        ppx.a(paramContainer, parampgd, "id_left_account_name");
      }
      if ((localArticleInfo1 != null) && (localArticleInfo1.isAccountShown)) {
        ppx.a(paramContainer, parampgd, "id_right_account_name");
      }
      ppy.a(localArticleInfo2, paramContainer, parampgd);
      return;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pgd parampgd, ViewBase paramViewBase)
  {
    paramInt = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
    ArticleInfo localArticleInfo = parampgd.a();
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
      paramViewBase.setOnClickListener(new ply(this, paramInt, localArticleInfo, paramContainer, parampgd));
      return true;
    case 1152: 
    case 1153: 
      paramViewBase.setOnClickListener(new plz(this, paramInt, parampgd, localArticleInfo, paramContainer));
      return true;
    case 1154: 
    case 1155: 
      paramViewBase.setOnClickListener(new pma(this, paramInt, parampgd, localArticleInfo, paramContainer));
      return true;
    }
    paramViewBase.setOnClickListener(new pmb(this, localArticleInfo, parampgd));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     plx
 * JD-Core Version:    0.7.0.1
 */