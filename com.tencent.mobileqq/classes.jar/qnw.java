import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class qnw
  implements qqa
{
  private Boolean a(qfw paramqfw, ViewBase paramViewBase, int paramInt1, BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2, BaseArticleInfo paramBaseArticleInfo3, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return Boolean.valueOf(false);
    case 1126: 
      b(paramViewBase, paramBaseArticleInfo2);
      a(paramqfw, paramViewBase, paramBaseArticleInfo2, paramInt2);
      return Boolean.valueOf(true);
    case 1127: 
      a(paramViewBase, paramBaseArticleInfo3);
      a(paramqfw, paramViewBase, (ArticleInfo)paramBaseArticleInfo2, paramBaseArticleInfo3, paramInt2);
      return Boolean.valueOf(true);
    case 1160: 
    case 1161: 
      b(paramqfw, paramViewBase, paramInt1, paramBaseArticleInfo2, paramBaseArticleInfo3);
      return Boolean.valueOf(true);
    case 1162: 
    case 1163: 
      a(paramqfw, paramViewBase, paramInt1, paramBaseArticleInfo2, paramBaseArticleInfo3);
      return Boolean.valueOf(true);
    }
    a(paramqfw, paramViewBase, paramBaseArticleInfo1);
    return Boolean.valueOf(true);
  }
  
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
    pjc.a(paramJSONObject, "right_mark_text", paramBaseArticleInfo.subscriptWording);
    pjc.a(paramJSONObject, "right_mark_color", paramBaseArticleInfo.subscriptWordingColor);
    pjc.a(paramJSONObject, "right_mark_backgroundcolor", paramBaseArticleInfo.subscriptBgColor);
    paramJSONObject.put("right_corner_mark", paramBaseArticleInfo.subscriptType);
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, boolean paramBoolean)
  {
    Object localObject;
    if (paramBaseArticleInfo != null)
    {
      int i = paramBaseArticleInfo.getCommentCount();
      if (i <= 0) {
        break label352;
      }
      localObject = six.e(i);
      if (paramBoolean)
      {
        paramJSONObject.put("right_comment_count", localObject);
        paramJSONObject.put("right_play_count", six.c(paramBaseArticleInfo.mVideoPlayCount));
        paramJSONObject.put("play_icon", "ReadInJoy/video_play_icon.png");
        paramJSONObject.put("comment_icon", "comment_icon_white");
      }
      paramJSONObject.put("right_article_title", paramBaseArticleInfo.mTitle);
      if ((!paramBaseArticleInfo.isUseGif) || (!NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext()))) {
        break label360;
      }
      paramBoolean = true;
      label96:
      paramBaseArticleInfo.isShowGif = paramBoolean;
      if (!paramBaseArticleInfo.isShowGif) {
        break label365;
      }
      paramJSONObject.put("right_cover_gif", paramBaseArticleInfo.gifCoverUrl);
      paramJSONObject.put("right_cover_url", paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(true).getFile());
    }
    for (;;)
    {
      if ((paramBaseArticleInfo.isAccountShown) && (paramBaseArticleInfo.mPartnerAccountInfo != null))
      {
        long l = paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get();
        paramJSONObject.put("right_account_uin", l + "");
        localObject = qxl.b(paramBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramJSONObject.put("right_account_small_icon_url", localObject);
        }
      }
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mVideoArticleSubsColor))
      {
        paramJSONObject.put("right_item_subscript_text", paramBaseArticleInfo.mVideoArticleSubsText);
        String str = paramBaseArticleInfo.mVideoArticleSubsColor;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = "#00a5e0";
        }
        paramJSONObject.put("right_item_subscript_bg_color", localObject);
      }
      a(paramBaseArticleInfo, paramJSONObject);
      if (!TextUtils.isEmpty(paramBaseArticleInfo.smallGameData))
      {
        paramJSONObject.put("right_comment_count", uks.a(paramBaseArticleInfo.mCommentCount, anvx.a(2131701584)));
        paramJSONObject.put("right_play_count", anvx.a(2131699307));
        localObject = new JSONObject();
        ((JSONObject)localObject).put("play_icon", "readinjoy_ad_small_game");
        paramJSONObject.put("id_right_play_icon", localObject);
      }
      paramBaseArticleInfo.isTwoItem = true;
      return;
      label352:
      localObject = "0";
      break;
      label360:
      paramBoolean = false;
      break label96;
      label365:
      localObject = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(true).getFile();
      paramJSONObject.put("right_cover_image_url", localObject);
      uro.a.a((String)localObject);
    }
  }
  
  private void a(ViewBase paramViewBase, BaseArticleInfo paramBaseArticleInfo)
  {
    View localView;
    pti localpti;
    if (("id_right_item_cover_imageview".equals(paramViewBase.getViewId())) || ("id_right_item_gif_imageview".equals(paramViewBase.getViewId())))
    {
      VideoReport.setElementId(paramViewBase.getNativeView(), "card");
      localView = paramViewBase.getNativeView();
      localpti = new pti().a(Long.valueOf(paramBaseArticleInfo.mChannelID));
      if (!TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID)) {
        break label101;
      }
    }
    label101:
    for (String str = "null";; str = paramBaseArticleInfo.innerUniqueID)
    {
      VideoReport.setElementParams(localView, localpti.e(str).a());
      VideoReport.setElementReuseIdentifier(paramViewBase.getNativeView(), paramBaseArticleInfo.innerUniqueID);
      return;
    }
  }
  
  private void a(qfw paramqfw, ViewBase paramViewBase, int paramInt, BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2)
  {
    paramViewBase.setOnClickListener(new qnx(this, paramInt, paramqfw, paramBaseArticleInfo1, paramBaseArticleInfo2));
  }
  
  private void a(qfw paramqfw, ViewBase paramViewBase, ArticleInfo paramArticleInfo, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    paramViewBase.setOnClickListener(new qoa(this, paramqfw, paramInt, paramBaseArticleInfo, paramArticleInfo));
  }
  
  private void a(qfw paramqfw, ViewBase paramViewBase, BaseArticleInfo paramBaseArticleInfo)
  {
    paramViewBase.setOnClickListener(new qnz(this, paramBaseArticleInfo, paramqfw));
  }
  
  private void a(qfw paramqfw, ViewBase paramViewBase, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    paramViewBase.setOnClickListener(new qob(this, paramqfw, paramInt, paramBaseArticleInfo));
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
    pjc.a(paramJSONObject, "left_mark_text", paramBaseArticleInfo.subscriptWording);
    pjc.a(paramJSONObject, "left_mark_color", paramBaseArticleInfo.subscriptWordingColor);
    pjc.a(paramJSONObject, "left_mark_backgroundcolor", paramBaseArticleInfo.subscriptBgColor);
    paramJSONObject.put("left_corner_mark", paramBaseArticleInfo.subscriptType);
  }
  
  private void b(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, boolean paramBoolean)
  {
    Object localObject;
    if (paramBaseArticleInfo != null)
    {
      int i = paramBaseArticleInfo.getCommentCount();
      if (i <= 0) {
        break label355;
      }
      localObject = six.e(i);
      if (paramBoolean)
      {
        paramJSONObject.put("left_comment_count", localObject);
        paramJSONObject.put("left_play_count", six.c(paramBaseArticleInfo.mVideoPlayCount));
        paramJSONObject.put("play_icon", "ReadInJoy/video_play_icon.png");
        paramJSONObject.put("comment_icon", "comment_icon_white");
      }
      paramJSONObject.put("left_article_title", paramBaseArticleInfo.mTitle);
      if ((!paramBaseArticleInfo.isUseGif) || (!NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext()))) {
        break label363;
      }
      paramBoolean = true;
      label99:
      paramBaseArticleInfo.isShowGif = paramBoolean;
      if (!paramBaseArticleInfo.isShowGif) {
        break label368;
      }
      paramJSONObject.put("left_cover_gif", paramBaseArticleInfo.gifCoverUrl);
      paramJSONObject.put("left_cover_url", paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(true).getFile());
    }
    for (;;)
    {
      if ((paramBaseArticleInfo.isAccountShown) && (paramBaseArticleInfo.mPartnerAccountInfo != null))
      {
        long l = paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get();
        paramJSONObject.put("left_account_uin", l + "");
        localObject = qxl.b(paramBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramJSONObject.put("left_account_small_icon_url", localObject);
        }
      }
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mVideoArticleSubsColor))
      {
        paramJSONObject.put("left_item_subscript_text", paramBaseArticleInfo.mVideoArticleSubsText);
        String str = paramBaseArticleInfo.mVideoArticleSubsColor;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = "#00a5e0";
        }
        paramJSONObject.put("left_item_subscript_bg_color", localObject);
      }
      b(paramBaseArticleInfo, paramJSONObject);
      if (!TextUtils.isEmpty(paramBaseArticleInfo.smallGameData))
      {
        paramJSONObject.put("left_comment_count", uks.a(paramBaseArticleInfo.mCommentCount, anvx.a(2131701584)));
        paramJSONObject.put("left_play_count", anvx.a(2131699307));
        paramBaseArticleInfo = new JSONObject();
        paramBaseArticleInfo.put("play_icon", "readinjoy_ad_small_game");
        paramJSONObject.put("id_left_play_icon", paramBaseArticleInfo);
      }
      return;
      label355:
      localObject = "0";
      break;
      label363:
      paramBoolean = false;
      break label99;
      label368:
      localObject = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(true).getFile();
      paramJSONObject.put("left_cover_image_url", localObject);
      uro.a.a((String)localObject);
    }
  }
  
  private void b(ViewBase paramViewBase, BaseArticleInfo paramBaseArticleInfo)
  {
    View localView;
    pti localpti;
    if (("id_left_item_cover_imageview".equals(paramViewBase.getViewId())) || ("id_left_item_gif_imageview".equals(paramViewBase.getViewId())))
    {
      VideoReport.setElementId(paramViewBase.getNativeView(), "card");
      localView = paramViewBase.getNativeView();
      localpti = new pti().a(Long.valueOf(paramBaseArticleInfo.mChannelID));
      if (!TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID)) {
        break label101;
      }
    }
    label101:
    for (String str = "null";; str = paramBaseArticleInfo.innerUniqueID)
    {
      VideoReport.setElementParams(localView, localpti.e(str).a());
      VideoReport.setElementReuseIdentifier(paramViewBase.getNativeView(), paramBaseArticleInfo.innerUniqueID);
      return;
    }
  }
  
  private void b(qfw paramqfw, ViewBase paramViewBase, int paramInt, BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2)
  {
    paramViewBase.setOnClickListener(new qny(this, paramInt, paramqfw, paramBaseArticleInfo1, paramBaseArticleInfo2));
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject1;
    JSONObject localJSONObject;
    boolean bool;
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSubArtilceList != null) && (paramBaseArticleInfo.mSubArtilceList.size() > 0))
    {
      localObject1 = (ArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);
      localJSONObject = new JSONObject();
      paramInt = bmhv.e();
      bool = bmhv.t();
    }
    for (;;)
    {
      try
      {
        b(paramBaseArticleInfo, localJSONObject, bool);
        a((BaseArticleInfo)localObject1, localJSONObject, bool);
        a(paramBaseArticleInfo, (BaseArticleInfo)localObject1, localJSONObject);
        localJSONObject.put("title_num", paramInt + "");
        if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.multiVideoColumnInfo == null)) {
          continue;
        }
        localObject2 = Integer.valueOf(paramBaseArticleInfo.multiVideoColumnInfo.a);
        localJSONObject.put("column_id_1", localObject2);
        if ((localObject1 == null) || (((BaseArticleInfo)localObject1).multiVideoColumnInfo == null)) {
          continue;
        }
        localObject1 = Integer.valueOf(((BaseArticleInfo)localObject1).multiVideoColumnInfo.a);
        localJSONObject.put("column_id_2", localObject1);
        localJSONObject.put("style_ID", "ReadInjoy_double_video_cell");
      }
      catch (Exception localException)
      {
        Object localObject2;
        QLog.d("DoubleVideoProteusItem", 2, localException.getMessage());
        continue;
      }
      qmm.a(localJSONObject, paramBaseArticleInfo);
      return localJSONObject;
      localObject1 = null;
      break;
      localObject2 = "";
      continue;
      localObject1 = "";
    }
  }
  
  public void a(int paramInt1, Container paramContainer, qfw paramqfw, int paramInt2)
  {
    ArticleInfo localArticleInfo2 = paramqfw.a();
    if (localArticleInfo2 != null) {
      if ((localArticleInfo2 == null) || (localArticleInfo2.mSubArtilceList == null) || (localArticleInfo2.mSubArtilceList.size() <= 0)) {
        break label118;
      }
    }
    label118:
    for (ArticleInfo localArticleInfo1 = (ArticleInfo)localArticleInfo2.mSubArtilceList.get(0);; localArticleInfo1 = null)
    {
      if ((localArticleInfo2 != null) && (localArticleInfo2.isAccountShown)) {
        qsd.a(paramContainer, paramqfw, "id_left_account_name");
      }
      if ((localArticleInfo1 != null) && (localArticleInfo1.isAccountShown)) {
        qsd.a(paramContainer, paramqfw, "id_right_account_name");
      }
      if (paramContainer != null)
      {
        ssn.a(localArticleInfo2, BaseActivity.sTopActivity);
        ssn.a(localArticleInfo1, BaseActivity.sTopActivity);
      }
      return;
    }
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2, JSONObject paramJSONObject)
  {
    VideoColumnInfo localVideoColumnInfo;
    if ((paramBaseArticleInfo1 != null) && (paramBaseArticleInfo1.columnEntrances != null) && (!paramBaseArticleInfo1.columnEntrances.isEmpty()) && (paramBaseArticleInfo2 != null) && (paramBaseArticleInfo2.columnEntrances != null) && (!paramBaseArticleInfo2.columnEntrances.isEmpty()))
    {
      localVideoColumnInfo = (VideoColumnInfo)paramBaseArticleInfo1.columnEntrances.get(0);
      paramBaseArticleInfo2 = (VideoColumnInfo)paramBaseArticleInfo2.columnEntrances.get(0);
      if ((localVideoColumnInfo != null) && (paramBaseArticleInfo2 != null))
      {
        if ((localVideoColumnInfo.a == 0) || (localVideoColumnInfo.a != paramBaseArticleInfo2.a)) {
          break label110;
        }
        qmm.al(paramBaseArticleInfo1, paramJSONObject);
      }
    }
    label110:
    do
    {
      return;
      if (localVideoColumnInfo.a != 0)
      {
        paramJSONObject.put("column_tips_left", "栏目");
        paramJSONObject.put("column_name_left", localVideoColumnInfo.b);
        paramJSONObject.put("readinjoy_column_icon_left", "readinjoy_column_icon_white");
      }
    } while (paramBaseArticleInfo2.a == 0);
    paramJSONObject.put("column_tips_right", "栏目");
    paramJSONObject.put("column_name_right", paramBaseArticleInfo2.b);
    paramJSONObject.put("readinjoy_column_icon_right", "readinjoy_column_icon_white");
  }
  
  public boolean a(int paramInt, Container paramContainer, qfw paramqfw, ViewBase paramViewBase)
  {
    int i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
    ArticleInfo localArticleInfo = paramqfw.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSubArtilceList != null) && (localArticleInfo.mSubArtilceList.size() > 0)) {}
    for (paramContainer = (ArticleInfo)localArticleInfo.mSubArtilceList.get(0); (localArticleInfo == null) || (paramContainer == null); paramContainer = null) {
      return false;
    }
    if (localArticleInfo.mProteusTemplateBean != null) {
      paramContainer.mProteusTemplateBean = localArticleInfo.mProteusTemplateBean;
    }
    return a(paramqfw, paramViewBase, i, localArticleInfo, localArticleInfo, paramContainer, paramInt).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qnw
 * JD-Core Version:    0.7.0.1
 */