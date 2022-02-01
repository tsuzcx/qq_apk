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
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class pwa
  implements pye
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
      paramInt = bnrf.d();
      bool2 = bnrf.p();
      if (paramBaseArticleInfo == null) {}
    }
    try
    {
      i = paramBaseArticleInfo.getCommentCount();
      if (i <= 0) {
        break label1047;
      }
      localObject2 = rpt.e(i);
      label75:
      if (bool2)
      {
        localJSONObject.put("left_comment_count", (String)localObject2 + anzj.a(2131711804));
        localJSONObject.put("left_play_count", rpt.c(paramBaseArticleInfo.mVideoPlayCount));
        localJSONObject.put("play_icon", "ReadInJoy/video_play_icon.png");
      }
      localJSONObject.put("left_article_title", paramBaseArticleInfo.mTitle);
      if ((!paramBaseArticleInfo.isUseGif) || (!bhnv.h(BaseApplicationImpl.getContext()))) {
        break label1247;
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
        label1047:
        QLog.d("DoubleVideoProteusItem", 2, localException.getMessage());
        continue;
        Object localObject2 = "0";
        continue;
        localObject2 = localException.getVideoCoverUrlWithSmartCut(true).getFile();
        localJSONObject.put("right_cover_image_url", localObject2);
        txb.a.a((String)localObject2);
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
        localObject2 = ozs.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
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
      if (!TextUtils.isEmpty(paramBaseArticleInfo.smallGameData))
      {
        localJSONObject.put("left_comment_count", tqa.a(paramBaseArticleInfo.mCommentCount, anzj.a(2131700998)));
        localJSONObject.put("left_play_count", anzj.a(2131698721));
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("play_icon", "readinjoy_ad_small_game");
        localJSONObject.put("id_left_play_icon", localObject2);
      }
      if (localObject1 != null)
      {
        i = ((BaseArticleInfo)localObject1).getCommentCount();
        if (i <= 0) {
          break label1104;
        }
        localObject2 = rpt.e(i);
        if (bool2)
        {
          localJSONObject.put("right_comment_count", (String)localObject2 + anzj.a(2131711804));
          localJSONObject.put("right_play_count", rpt.c(((BaseArticleInfo)localObject1).mVideoPlayCount));
          localJSONObject.put("play_icon", "ReadInJoy/video_play_icon.png");
        }
        localJSONObject.put("right_article_title", ((BaseArticleInfo)localObject1).mTitle);
        if ((!((BaseArticleInfo)localObject1).isUseGif) || (!bhnv.h(BaseApplicationImpl.getContext()))) {
          break label1253;
        }
        bool1 = true;
        ((BaseArticleInfo)localObject1).isShowGif = bool1;
        if (!((BaseArticleInfo)localObject1).isShowGif) {
          break label1112;
        }
        localJSONObject.put("right_cover_gif", ((BaseArticleInfo)localObject1).gifCoverUrl);
        localJSONObject.put("right_cover_url", ((BaseArticleInfo)localObject1).getVideoCoverUrlWithSmartCut(true).getFile());
        if ((((BaseArticleInfo)localObject1).isAccountShown) && (((BaseArticleInfo)localObject1).mPartnerAccountInfo != null))
        {
          l = ((BaseArticleInfo)localObject1).mPartnerAccountInfo.uint64_uin.get();
          localJSONObject.put("right_account_uin", l + "");
          localObject2 = ozs.a(((BaseArticleInfo)localObject1).mPartnerAccountInfo.bytes_v_icon_url);
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
        if (!TextUtils.isEmpty(((BaseArticleInfo)localObject1).smallGameData))
        {
          localJSONObject.put("right_comment_count", tqa.a(((BaseArticleInfo)localObject1).mCommentCount, anzj.a(2131700998)));
          localJSONObject.put("right_play_count", anzj.a(2131698721));
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("play_icon", "readinjoy_ad_small_game");
          localJSONObject.put("id_right_play_icon", localObject2);
        }
        ((BaseArticleInfo)localObject1).isTwoItem = true;
      }
      if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.columnEntrances != null) && (!paramBaseArticleInfo.columnEntrances.isEmpty()) && (localObject1 != null) && (((BaseArticleInfo)localObject1).columnEntrances != null) && (!((BaseArticleInfo)localObject1).columnEntrances.isEmpty()))
      {
        localObject2 = (VideoColumnInfo)paramBaseArticleInfo.columnEntrances.get(0);
        localObject3 = (VideoColumnInfo)((BaseArticleInfo)localObject1).columnEntrances.get(0);
        if ((localObject2 != null) && (localObject3 != null))
        {
          if ((((VideoColumnInfo)localObject2).a == 0) || (((VideoColumnInfo)localObject2).a != ((VideoColumnInfo)localObject3).a)) {
            break label1145;
          }
          puo.aj(paramBaseArticleInfo, localJSONObject);
        }
      }
      localJSONObject.put("title_num", paramInt + "");
      if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.multiVideoColumnInfo == null)) {
        break label1259;
      }
      localObject2 = Integer.valueOf(paramBaseArticleInfo.multiVideoColumnInfo.a);
      localJSONObject.put("column_id_1", localObject2);
      if ((localObject1 == null) || (((BaseArticleInfo)localObject1).multiVideoColumnInfo == null)) {
        break label1240;
      }
      localObject1 = Integer.valueOf(((BaseArticleInfo)localObject1).multiVideoColumnInfo.a);
      localJSONObject.put("column_id_2", localObject1);
      localJSONObject.put("style_ID", "ReadInjoy_double_video_cell");
      puo.a(localJSONObject, paramBaseArticleInfo);
      return localJSONObject;
      localObject1 = null;
      break;
      localObject2 = "0";
      break label75;
      localObject2 = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(true).getFile();
      localJSONObject.put("left_cover_image_url", localObject2);
      txb.a.a((String)localObject2);
    }
  }
  
  public void a(int paramInt1, Container paramContainer, ppu paramppu, int paramInt2)
  {
    ArticleInfo localArticleInfo2 = paramppu.a();
    if (localArticleInfo2 != null) {
      if ((localArticleInfo2 == null) || (localArticleInfo2.mSubArtilceList == null) || (localArticleInfo2.mSubArtilceList.size() <= 0)) {
        break label120;
      }
    }
    label120:
    for (ArticleInfo localArticleInfo1 = (ArticleInfo)localArticleInfo2.mSubArtilceList.get(0);; localArticleInfo1 = null)
    {
      if ((localArticleInfo2 != null) && (localArticleInfo2.isAccountShown)) {
        qag.a(paramContainer, paramppu, "id_left_account_name");
      }
      if ((localArticleInfo1 != null) && (localArticleInfo1.isAccountShown)) {
        qag.a(paramContainer, paramppu, "id_right_account_name");
      }
      if (paramContainer != null)
      {
        rze.a(localArticleInfo2, paramContainer.getContext());
        rze.a(localArticleInfo1, paramContainer.getContext());
      }
      return;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, ppu paramppu, ViewBase paramViewBase)
  {
    paramInt = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
    ArticleInfo localArticleInfo = paramppu.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSubArtilceList != null) && (localArticleInfo.mSubArtilceList.size() > 0)) {}
    for (paramContainer = (ArticleInfo)localArticleInfo.mSubArtilceList.get(0); (localArticleInfo == null) || (paramContainer == null); paramContainer = null) {
      return false;
    }
    if (localArticleInfo.mProteusTemplateBean != null) {
      paramContainer.mProteusTemplateBean = localArticleInfo.mProteusTemplateBean;
    }
    Object localObject1;
    Object localObject2;
    switch (paramInt)
    {
    default: 
      return false;
    case 1126: 
      if (("id_left_item_cover_imageview".equals(paramViewBase.getViewId())) || ("id_left_item_gif_imageview".equals(paramViewBase.getViewId())))
      {
        VideoReport.setElementId(paramViewBase.getNativeView(), "card");
        localObject1 = paramViewBase.getNativeView();
        localObject2 = new pda().a(localArticleInfo.mChannelID);
        if (!TextUtils.isEmpty(localArticleInfo.innerUniqueID)) {
          break label285;
        }
      }
      for (paramContainer = "null";; paramContainer = localArticleInfo.innerUniqueID)
      {
        VideoReport.setElementParams(localObject1, ((pda)localObject2).a(paramContainer).a());
        VideoReport.setElementReuseIdentifier(paramViewBase.getNativeView(), localArticleInfo.innerUniqueID);
        paramViewBase.setOnClickListener(new pwb(this, paramppu, localArticleInfo));
        return true;
      }
    case 1127: 
      pda localpda;
      if (("id_right_item_cover_imageview".equals(paramViewBase.getViewId())) || ("id_right_item_gif_imageview".equals(paramViewBase.getViewId())))
      {
        VideoReport.setElementId(paramViewBase.getNativeView(), "card");
        localObject2 = paramViewBase.getNativeView();
        localpda = new pda().a(paramContainer.mChannelID);
        if (!TextUtils.isEmpty(paramContainer.innerUniqueID)) {
          break label417;
        }
      }
      for (localObject1 = "null";; localObject1 = paramContainer.innerUniqueID)
      {
        VideoReport.setElementParams(localObject2, localpda.a((String)localObject1).a());
        VideoReport.setElementReuseIdentifier(paramViewBase.getNativeView(), paramContainer.innerUniqueID);
        paramViewBase.setOnClickListener(new pwc(this, paramppu, paramContainer, localArticleInfo));
        return true;
      }
    case 1160: 
    case 1161: 
      paramViewBase.setOnClickListener(new pwd(this, paramInt, paramppu, localArticleInfo, paramContainer));
      return true;
    case 1162: 
    case 1163: 
      label285:
      label417:
      paramViewBase.setOnClickListener(new pwe(this, paramInt, paramppu, localArticleInfo, paramContainer));
      return true;
    }
    paramViewBase.setOnClickListener(new pwf(this, localArticleInfo, paramppu));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pwa
 * JD-Core Version:    0.7.0.1
 */