package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.KandianUGStatisticUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity;
import com.tencent.mobileqq.kandian.biz.fastweb.data.MiniAppData;
import com.tencent.mobileqq.kandian.biz.fastweb.data.ProteusAnimationItemData;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRecommendUGInfo;
import com.tencent.mobileqq.kandian.biz.fastweb.util.RIJ3ClickUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.biz.feeds.entity.ExposureArticle;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoReportUtil;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.ProteusRecommendItemData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.kandian.repo.video.RIJWeChatVideoSeeLaterModule;
import com.tencent.mobileqq.kandian.repo.video.RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class WebProteusViewCreator$ProteusItemViewHolder
  extends BaseItemViewHolder
{
  private Container b;
  private ArrayList<String> c;
  private SparseArray<WebProteusViewCreator.ProteusItemViewOnClickListener> d;
  private WebProteusViewCreator.ProteusItemViewOnClickListener n;
  
  public WebProteusViewCreator$ProteusItemViewHolder(WebProteusViewCreator paramWebProteusViewCreator, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    if ((paramView instanceof Container)) {
      this.b = ((Container)paramView);
    }
    c();
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener a(int paramInt)
  {
    WebProteusViewCreator.ProteusItemViewOnClickListener localProteusItemViewOnClickListener = (WebProteusViewCreator.ProteusItemViewOnClickListener)this.d.get(paramInt);
    if (localProteusItemViewOnClickListener != null) {
      return localProteusItemViewOnClickListener;
    }
    return n();
  }
  
  private String a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.opt("card_info") != null) {
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("card_info");
        if (paramJSONObject.opt("rowKey") != null)
        {
          paramJSONObject = paramJSONObject.getString("rowKey");
          return paramJSONObject;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    return "";
  }
  
  private void a(Context paramContext, ProteusItemData paramProteusItemData)
  {
    ViewFactory.findClickableViewListener(this.b.getVirtualView(), new WebProteusViewCreator.ProteusItemViewHolder.1(this, paramContext, paramProteusItemData));
  }
  
  private void a(View paramView, BaseData paramBaseData)
  {
    if (paramView != null)
    {
      if (paramBaseData == null) {
        return;
      }
      try
      {
        paramView = (ProteusItemData)paramBaseData;
        if (paramView.be == 1) {
          b(paramView);
        }
        if ((paramView.bf == 2) && ((WebProteusViewCreator.a(this.a) instanceof FastWebActivity)))
        {
          RIJ3ClickUtils.a.a(paramView, this.b, (FastWebActivity)WebProteusViewCreator.a(this.a));
          return;
        }
      }
      catch (Exception paramView)
      {
        paramBaseData = new StringBuilder();
        paramBaseData.append("addLongClickListener error,msg:");
        paramBaseData.append(paramView.toString());
        QLog.d("WebProteusViewCreator", 1, paramBaseData.toString());
      }
    }
  }
  
  private void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    JSONObject localJSONObject = paramProteusItemData.bb;
    Object localObject1 = paramViewBase.getEventAttachedData();
    Object localObject2 = a(localJSONObject);
    if (a())
    {
      a(paramViewBase, paramContext, paramProteusItemData, (String)localObject1, localJSONObject, (String)localObject2);
      return;
    }
    localObject1 = new FastWebRecommendUGInfo(localJSONObject.optString("kd_ug_rsp_info"), (String)localObject2);
    KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(((FastWebRecommendUGInfo)localObject1).c, (String)localObject2, "3"));
    DownloadInfo localDownloadInfo = DownloadManagerV2.a().b(((FastWebRecommendUGInfo)localObject1).d);
    if (localDownloadInfo == null)
    {
      KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(((FastWebRecommendUGInfo)localObject1).c, (String)localObject2, "9"));
      KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(((FastWebRecommendUGInfo)localObject1).c, (String)localObject2, "10"));
      localObject2 = new DownloadInfo();
      ((DownloadInfo)localObject2).d = ((FastWebRecommendUGInfo)localObject1).d;
      ((DownloadInfo)localObject2).r = "biz_src_kandian_read";
      ((DownloadInfo)localObject2).e = "com.tencent.reading";
      DownloadManagerV2.a().b((DownloadInfo)localObject2);
      try
      {
        localObject2 = localJSONObject.getJSONObject("id_recommend_category_txt");
        ((JSONObject)localObject2).put("text", "下载中...0%");
        ((JSONObject)localObject2).put("label_ug_progress_progress", 0);
        if (WebProteusViewCreator.b(this.a) == null) {
          break label234;
        }
        WebProteusViewCreator.b(this.a).notifyDataSetChanged();
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    else
    {
      a(localDownloadInfo, localJSONObject, localJSONException);
    }
    label234:
    if (((FastWebRecommendUGInfo)localObject1).f != null)
    {
      localObject1 = ((FastWebRecommendUGInfo)localObject1).f;
      try
      {
        ((ClipboardManager)paramContext.getSystemService("clipboard")).setText((CharSequence)localObject1);
      }
      catch (Throwable paramContext)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[ugDownloadJump] error, t = ");
        ((StringBuilder)localObject1).append(paramContext);
        QLog.e("WebProteusViewCreator", 1, ((StringBuilder)localObject1).toString());
      }
    }
    paramContext = ReportUtil.a(paramProteusItemData.bd, paramViewBase.getName());
    if ((paramProteusItemData instanceof ProteusRecommendItemData))
    {
      ReportUtil.a(paramViewBase.getName(), (ProteusRecommendItemData)paramProteusItemData, paramContext);
      return;
    }
    ReportUtil.a(paramViewBase.getName(), localJSONObject, paramContext);
  }
  
  private void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    FastWebRecommendUGInfo localFastWebRecommendUGInfo = new FastWebRecommendUGInfo(paramJSONObject.optString("kd_ug_rsp_info"), paramString2);
    KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(localFastWebRecommendUGInfo.c, paramString2, "3"));
    KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(localFastWebRecommendUGInfo.c, paramString2, "7"));
    if (!TextUtils.isEmpty(localFastWebRecommendUGInfo.e))
    {
      paramString2 = new Intent();
      paramString2.setAction("android.intent.action.VIEW");
      paramString2.putExtra("big_brother_source_key", "biz_src_kandian_read");
      paramString2.setData(Uri.parse(localFastWebRecommendUGInfo.e));
      if (VideoFeedsHelper.a(paramContext, paramString2)) {
        paramContext.startActivity(paramString2);
      }
    }
    paramContext = ReportUtil.a(paramProteusItemData.bd, paramViewBase.getName());
    if ((paramProteusItemData instanceof ProteusRecommendItemData)) {
      ReportUtil.a(paramViewBase.getName(), (ProteusRecommendItemData)paramProteusItemData, paramContext);
    } else {
      ReportUtil.a(paramViewBase.getName(), paramJSONObject, paramContext);
    }
    paramContext = new StringBuilder();
    paramContext.append("onClick,schema=");
    paramContext.append(paramString1);
    paramContext.append(" viewID=");
    paramContext.append(paramViewBase.getName());
    QLog.d("WebProteusViewCreator", 1, paramContext.toString());
  }
  
  private void a(MiniAppData paramMiniAppData)
  {
    if (!paramMiniAppData.d)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestWechatVideoSeelaterProgress: ");
      localStringBuilder.append(paramMiniAppData);
      QLog.d("WebProteusViewCreator", 1, localStringBuilder.toString());
      paramMiniAppData.d = true;
      ReadInJoyLogicEngine.a().t().a(b(paramMiniAppData));
      QQToast.makeText(BaseApplicationImpl.getApplication(), 0, HardCodeUtil.a(2131915826), 0).show();
      VideoReportUtil.a.a(paramMiniAppData.aQ, 0L, paramMiniAppData);
    }
  }
  
  private void a(ProteusItemData paramProteusItemData)
  {
    if (paramProteusItemData.bb != null) {
      try
      {
        paramProteusItemData = paramProteusItemData.bb.optJSONObject("card_info");
        if (paramProteusItemData != null)
        {
          paramProteusItemData = paramProteusItemData.optString("rowKey");
          RIJFeedsDynamicInsertController.INSTANCE.deleteArticle(new ExposureArticle(paramProteusItemData, false));
          return;
        }
      }
      catch (Exception paramProteusItemData)
      {
        QLog.d("WebProteusViewCreator", 1, paramProteusItemData.getMessage());
      }
    }
  }
  
  private void a(DownloadInfo paramDownloadInfo, JSONObject paramJSONObject, String paramString)
  {
    try
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject("id_recommend_category_txt");
      paramJSONObject = new FastWebRecommendUGInfo(paramJSONObject.optString("kd_ug_rsp_info"), paramString);
      if (paramDownloadInfo.a() == 4)
      {
        KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(paramJSONObject.c, paramString, "20"));
        if (!DownloadManagerV2.a().d(paramDownloadInfo)) {
          DownloadManagerV2.a().b(paramDownloadInfo);
        }
      }
      else
      {
        if (b(paramDownloadInfo.a()))
        {
          DownloadManagerV2.a().e(paramJSONObject.d);
          KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(paramJSONObject.c, paramString, "22"));
          return;
        }
        KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(paramJSONObject.c, paramString, "10"));
        DownloadManagerV2.a().b(paramDownloadInfo);
        paramString = new StringBuilder();
        paramString.append(paramJSONObject.j);
        paramString.append(paramDownloadInfo.t);
        paramString.append("%");
        localJSONObject.put("text", paramString.toString());
        localJSONObject.put("label_ug_progress_progress", paramDownloadInfo.t);
        if (WebProteusViewCreator.b(this.a) != null)
        {
          WebProteusViewCreator.b(this.a).notifyDataSetChanged();
          return;
        }
      }
    }
    catch (JSONException paramDownloadInfo)
    {
      paramDownloadInfo.printStackTrace();
    }
  }
  
  private boolean a()
  {
    return PackageUtil.b(BaseApplicationImpl.getContext(), "com.tencent.reading").equals("0") ^ true;
  }
  
  private List<RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem> b(MiniAppData paramMiniAppData)
  {
    ArrayList localArrayList = new ArrayList();
    RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem localWeChatVideoArticleItem = new RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem();
    localWeChatVideoArticleItem.a = paramMiniAppData.c;
    localWeChatVideoArticleItem.d = paramMiniAppData.e;
    localArrayList.add(localWeChatVideoArticleItem);
    return localArrayList;
  }
  
  private void b(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    JSONObject localJSONObject = paramProteusItemData.bb;
    String str2 = paramViewBase.getEventAttachedData();
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = RIJJumpUtils.a(str2, localJSONObject);
      RIJJumpUtils.c(paramContext, str1);
    }
    paramContext = ReportUtil.a(paramProteusItemData.bd, paramViewBase.getName());
    if ((paramProteusItemData instanceof ProteusRecommendItemData)) {
      ReportUtil.a(paramViewBase.getName(), (ProteusRecommendItemData)paramProteusItemData, paramContext);
    } else {
      ReportUtil.a(paramViewBase.getName(), localJSONObject, paramContext);
    }
    paramContext = new StringBuilder();
    paramContext.append("[defaultUrlJump], schema = ");
    paramContext.append(str1);
    paramContext.append(", viewID = ");
    paramContext.append(paramViewBase.getName());
    QLog.d("WebProteusViewCreator", 1, paramContext.toString());
  }
  
  private void b(ProteusItemData paramProteusItemData)
  {
    this.f.setOnLongClickListener(new WebProteusViewCreator.ProteusItemViewHolder.2(this, paramProteusItemData));
  }
  
  private boolean b(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 30)
    {
      bool1 = bool2;
      if (paramInt != 10)
      {
        bool1 = bool2;
        if (paramInt != 20)
        {
          bool1 = bool2;
          if (paramInt != 1)
          {
            if (paramInt == 2) {
              return true;
            }
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean b(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramJSONObject != null)
    {
      Object localObject = paramJSONObject.optString("kd_ug_rsp_info");
      bool1 = bool2;
      if (localObject != null)
      {
        localObject = new FastWebRecommendUGInfo((String)localObject, a(paramJSONObject));
        bool1 = bool2;
        if (paramJSONObject.opt("id_recommend_category_txt") != null)
        {
          bool1 = bool2;
          if (paramJSONObject.opt("kd_ug_download_url") != null)
          {
            bool1 = bool2;
            if (((FastWebRecommendUGInfo)localObject).e != null) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void c()
  {
    this.n = null;
    this.d = new SparseArray();
    this.d.put(1012, e());
    this.d.put(1023, f());
    this.d.put(1002, g());
    this.d.put(1001, h());
    this.d.put(1162, i());
    this.d.put(1158, j());
    this.d.put(1161, k());
    this.d.put(1174, l());
    this.d.put(1039, l());
    this.d.put(1041, m());
    this.d.put(1202, d());
    this.d.put(1160, FastWebPTSUtils.d());
    this.d.put(1129, FastWebPTSUtils.e());
    n();
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener d()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.3(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener e()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.4(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener f()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.5(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener g()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.6(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener h()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.7(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener i()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.8(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener j()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.9(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener k()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.10(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener l()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.11(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener m()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.12(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener n()
  {
    if (this.n == null) {
      this.n = new WebProteusViewCreator.ProteusItemViewHolder.13(this);
    }
    return this.n;
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if (this.b != null)
    {
      if (paramBaseData2 == null) {
        return;
      }
      if ((paramBaseData2 instanceof ProteusItemData))
      {
        paramBaseData1 = (ProteusItemData)paramBaseData2;
        Object localObject = paramBaseData1.bd;
        if (localObject != null)
        {
          WebProteusViewCreator.a(this.a, this.b);
          try
          {
            ((TemplateBean)localObject).bindData(paramBaseData1.bb);
            ProteusSupportUtil.a(this.b.getVirtualView(), paramBaseData1.bd.getViewBean());
            this.g = paramBaseData1;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("bindWebProteusViewCreator: ");
            ((StringBuilder)localObject).append(paramBaseData1.bb);
            QLog.d("WebProteusViewCreator", 1, ((StringBuilder)localObject).toString());
          }
          catch (Exception localException)
          {
            QLog.e("WebProteusViewCreator", 1, QLog.getStackTraceString(localException));
          }
          a(WebProteusViewCreator.a(this.a), paramBaseData1);
          a(this.b, paramBaseData2);
        }
        if ((paramBaseData2 instanceof ProteusAnimationItemData)) {
          ((ProteusAnimationItemData)paramBaseData2).a(this.f);
        }
        a(paramBaseData1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebProteusViewCreator.ProteusItemViewHolder
 * JD-Core Version:    0.7.0.1
 */