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
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class qbu
  implements qdy
{
  private Map<String, Object> a(TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((paramTemplateBean == null) || (paramViewBase == null)) {
      return null;
    }
    return paramTemplateBean.getDataAttribute(paramViewBase.getName());
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramBaseArticleInfo == null)) {
      return;
    }
    if (paramBaseArticleInfo.subscriptLocation != 0)
    {
      QLog.d("DoubleVideoProteusItem", 2, "bindRightSubscriptInfo | wrong position");
      return;
    }
    ozw.a(paramJSONObject, "right_mark_text", paramBaseArticleInfo.subscriptWording);
    ozw.a(paramJSONObject, "right_mark_color", paramBaseArticleInfo.subscriptWordingColor);
    ozw.a(paramJSONObject, "right_mark_backgroundcolor", paramBaseArticleInfo.subscriptBgColor);
    paramJSONObject.put("right_corner_mark", paramBaseArticleInfo.subscriptType);
  }
  
  private void b(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramBaseArticleInfo == null)) {
      return;
    }
    if (paramBaseArticleInfo.subscriptLocation != 0)
    {
      QLog.d("DoubleVideoProteusItem", 2, "bindLeftSubscriptInfo | wrong position");
      return;
    }
    ozw.a(paramJSONObject, "left_mark_text", paramBaseArticleInfo.subscriptWording);
    ozw.a(paramJSONObject, "left_mark_color", paramBaseArticleInfo.subscriptWordingColor);
    ozw.a(paramJSONObject, "left_mark_backgroundcolor", paramBaseArticleInfo.subscriptBgColor);
    paramJSONObject.put("left_corner_mark", paramBaseArticleInfo.subscriptType);
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
      paramInt = bkwm.e();
      bool2 = bkwm.q();
      if (paramBaseArticleInfo == null) {}
    }
    try
    {
      i = paramBaseArticleInfo.getCommentCount();
      if (i <= 0) {
        break label1081;
      }
      localObject2 = rwv.e(i);
      label75:
      if (bool2)
      {
        localJSONObject.put("left_comment_count", (String)localObject2 + amtj.a(2131712036));
        localJSONObject.put("left_play_count", rwv.c(paramBaseArticleInfo.mVideoPlayCount));
        localJSONObject.put("play_icon", "ReadInJoy/video_play_icon.png");
      }
      localJSONObject.put("left_article_title", paramBaseArticleInfo.mTitle);
      if ((!paramBaseArticleInfo.isUseGif) || (!NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext()))) {
        break label1280;
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
        label1081:
        QLog.d("DoubleVideoProteusItem", 2, localException.getMessage());
        continue;
        Object localObject2 = "0";
        continue;
        localObject2 = localException.getVideoCoverUrlWithSmartCut(true).getFile();
        localJSONObject.put("right_cover_image_url", localObject2);
        udr.a.a((String)localObject2);
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
        localObject2 = pay.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
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
      b(paramBaseArticleInfo, localJSONObject);
      if (!TextUtils.isEmpty(paramBaseArticleInfo.smallGameData))
      {
        localJSONObject.put("left_comment_count", twr.a(paramBaseArticleInfo.mCommentCount, amtj.a(2131701233)));
        localJSONObject.put("left_play_count", amtj.a(2131698956));
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("play_icon", "readinjoy_ad_small_game");
        localJSONObject.put("id_left_play_icon", localObject2);
      }
      if (localObject1 != null)
      {
        i = ((BaseArticleInfo)localObject1).getCommentCount();
        if (i <= 0) {
          break label1137;
        }
        localObject2 = rwv.e(i);
        if (bool2)
        {
          localJSONObject.put("right_comment_count", (String)localObject2 + amtj.a(2131712036));
          localJSONObject.put("right_play_count", rwv.c(((BaseArticleInfo)localObject1).mVideoPlayCount));
          localJSONObject.put("play_icon", "ReadInJoy/video_play_icon.png");
        }
        localJSONObject.put("right_article_title", ((BaseArticleInfo)localObject1).mTitle);
        if ((!((BaseArticleInfo)localObject1).isUseGif) || (!NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext()))) {
          break label1286;
        }
        bool1 = true;
        ((BaseArticleInfo)localObject1).isShowGif = bool1;
        if (!((BaseArticleInfo)localObject1).isShowGif) {
          break label1145;
        }
        localJSONObject.put("right_cover_gif", ((BaseArticleInfo)localObject1).gifCoverUrl);
        localJSONObject.put("right_cover_url", ((BaseArticleInfo)localObject1).getVideoCoverUrlWithSmartCut(true).getFile());
        if ((((BaseArticleInfo)localObject1).isAccountShown) && (((BaseArticleInfo)localObject1).mPartnerAccountInfo != null))
        {
          l = ((BaseArticleInfo)localObject1).mPartnerAccountInfo.uint64_uin.get();
          localJSONObject.put("right_account_uin", l + "");
          localObject2 = pay.a(((BaseArticleInfo)localObject1).mPartnerAccountInfo.bytes_v_icon_url);
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
        a((BaseArticleInfo)localObject1, localJSONObject);
        if (!TextUtils.isEmpty(((BaseArticleInfo)localObject1).smallGameData))
        {
          localJSONObject.put("right_comment_count", twr.a(((BaseArticleInfo)localObject1).mCommentCount, amtj.a(2131701233)));
          localJSONObject.put("right_play_count", amtj.a(2131698956));
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
            break label1178;
          }
          qai.al(paramBaseArticleInfo, localJSONObject);
        }
      }
      localJSONObject.put("title_num", paramInt + "");
      if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.multiVideoColumnInfo == null)) {
        break label1292;
      }
      localObject2 = Integer.valueOf(paramBaseArticleInfo.multiVideoColumnInfo.a);
      localJSONObject.put("column_id_1", localObject2);
      if ((localObject1 == null) || (((BaseArticleInfo)localObject1).multiVideoColumnInfo == null)) {
        break label1273;
      }
      localObject1 = Integer.valueOf(((BaseArticleInfo)localObject1).multiVideoColumnInfo.a);
      localJSONObject.put("column_id_2", localObject1);
      localJSONObject.put("style_ID", "ReadInjoy_double_video_cell");
      qai.a(localJSONObject, paramBaseArticleInfo);
      return localJSONObject;
      localObject1 = null;
      break;
      localObject2 = "0";
      break label75;
      localObject2 = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(true).getFile();
      localJSONObject.put("left_cover_image_url", localObject2);
      udr.a.a((String)localObject2);
    }
  }
  
  public void a(int paramInt1, Container paramContainer, pvc parampvc, int paramInt2)
  {
    ArticleInfo localArticleInfo2 = parampvc.a();
    if (localArticleInfo2 != null) {
      if ((localArticleInfo2 == null) || (localArticleInfo2.mSubArtilceList == null) || (localArticleInfo2.mSubArtilceList.size() <= 0)) {
        break label120;
      }
    }
    label120:
    for (ArticleInfo localArticleInfo1 = (ArticleInfo)localArticleInfo2.mSubArtilceList.get(0);; localArticleInfo1 = null)
    {
      if ((localArticleInfo2 != null) && (localArticleInfo2.isAccountShown)) {
        qga.a(paramContainer, parampvc, "id_left_account_name");
      }
      if ((localArticleInfo1 != null) && (localArticleInfo1.isAccountShown)) {
        qga.a(paramContainer, parampvc, "id_right_account_name");
      }
      if (paramContainer != null)
      {
        sgi.a(localArticleInfo2, paramContainer.getContext());
        sgi.a(localArticleInfo1, paramContainer.getContext());
      }
      return;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pvc parampvc, ViewBase paramViewBase)
  {
    paramInt = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
    ArticleInfo localArticleInfo = parampvc.a();
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
        localObject2 = new pil().a(Long.valueOf(localArticleInfo.mChannelID));
        if (!TextUtils.isEmpty(localArticleInfo.innerUniqueID)) {
          break label288;
        }
      }
      for (paramContainer = "null";; paramContainer = localArticleInfo.innerUniqueID)
      {
        VideoReport.setElementParams(localObject1, ((pil)localObject2).e(paramContainer).a());
        VideoReport.setElementReuseIdentifier(paramViewBase.getNativeView(), localArticleInfo.innerUniqueID);
        paramViewBase.setOnClickListener(new qbv(this, parampvc, localArticleInfo));
        return true;
      }
    case 1127: 
      pil localpil;
      if (("id_right_item_cover_imageview".equals(paramViewBase.getViewId())) || ("id_right_item_gif_imageview".equals(paramViewBase.getViewId())))
      {
        VideoReport.setElementId(paramViewBase.getNativeView(), "card");
        localObject2 = paramViewBase.getNativeView();
        localpil = new pil().a(Long.valueOf(paramContainer.mChannelID));
        if (!TextUtils.isEmpty(paramContainer.innerUniqueID)) {
          break label423;
        }
      }
      for (localObject1 = "null";; localObject1 = paramContainer.innerUniqueID)
      {
        VideoReport.setElementParams(localObject2, localpil.e((String)localObject1).a());
        VideoReport.setElementReuseIdentifier(paramViewBase.getNativeView(), paramContainer.innerUniqueID);
        paramViewBase.setOnClickListener(new qbw(this, parampvc, paramContainer, localArticleInfo));
        return true;
      }
    case 1160: 
    case 1161: 
      paramViewBase.setOnClickListener(new qbx(this, paramInt, parampvc, localArticleInfo, paramContainer));
      return true;
    case 1162: 
    case 1163: 
      label288:
      label423:
      paramViewBase.setOnClickListener(new qby(this, paramInt, parampvc, localArticleInfo, paramContainer));
      return true;
    }
    paramViewBase.setOnClickListener(new qbz(this, localArticleInfo, parampvc));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qbu
 * JD-Core Version:    0.7.0.1
 */