package com.tencent.mobileqq.kandian.biz.pts.item;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.KandianUGStatisticUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.utils.PackageUtil;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;

public class KandianTenProteusItem
  implements ProteusItem
{
  private String a(PBBytesField paramPBBytesField)
  {
    if ((paramPBBytesField.has()) && (paramPBBytesField.get() != null)) {
      return paramPBBytesField.get().toStringUtf8();
    }
    return null;
  }
  
  private void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("big_brother_source_key", "biz_src_kandian_hotnews");
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(paramString));
    if (VideoFeedsHelper.a(paramContext, localIntent)) {
      paramContext.startActivity(localIntent);
    }
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject(paramAbsBaseArticleInfo.proteusItemsData);
    long l = localJSONObject.getLong("updateTime");
    l = System.currentTimeMillis() - (l * 1000L - 10800000L);
    if (l > 86400000L)
    {
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append((int)(l / 86400000L));
      paramAbsBaseArticleInfo.append("天前");
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.toString();
    }
    else if (l > 3600000L)
    {
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append((int)(l / 3600000L));
      paramAbsBaseArticleInfo.append("小时前");
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.toString();
    }
    else if (l > 60000L)
    {
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append((int)(l / 60000L));
      paramAbsBaseArticleInfo.append("分钟前");
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.toString();
    }
    else
    {
      paramAbsBaseArticleInfo = "";
    }
    localJSONObject.put("updateTimeStr", paramAbsBaseArticleInfo);
    if (PackageUtil.a(BaseApplicationImpl.getContext(), "com.tencent.reading"))
    {
      localJSONObject.put("jump_page", "3");
      return localJSONObject;
    }
    localJSONObject.put("jump_page", "2");
    return localJSONObject;
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2) {}
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    if ((paramViewBase != null) && (!TextUtils.isEmpty(paramViewBase.getClickEvnet())) && (paramViewBase.getClickEvnet().startsWith("cmd_kandian_ten_click"))) {}
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a(paramIReadInJoyModel.a().weishiUGInfo.bytes_report_base_url));
      localStringBuilder.append(a(paramIReadInJoyModel.a().weishiUGInfo.bytes_exposure_report_tail));
      KandianUGStatisticUtils.a(localStringBuilder.toString());
      label90:
      paramViewBase.setOnClickListener(new KandianTenProteusItem.1(this, paramIReadInJoyModel, paramContainer));
      return true;
      return false;
    }
    catch (Exception localException)
    {
      break label90;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.KandianTenProteusItem
 * JD-Core Version:    0.7.0.1
 */