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
  private SparseArray<WebProteusViewCreator.ProteusItemViewOnClickListener> jdField_a_of_type_AndroidUtilSparseArray;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  private WebProteusViewCreator.ProteusItemViewOnClickListener jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemWebProteusViewCreator$ProteusItemViewOnClickListener;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  
  public WebProteusViewCreator$ProteusItemViewHolder(WebProteusViewCreator paramWebProteusViewCreator, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    if ((paramView instanceof Container)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = ((Container)paramView);
    }
    a();
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener a()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.3(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener a(int paramInt)
  {
    WebProteusViewCreator.ProteusItemViewOnClickListener localProteusItemViewOnClickListener = (WebProteusViewCreator.ProteusItemViewOnClickListener)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localProteusItemViewOnClickListener != null) {
      return localProteusItemViewOnClickListener;
    }
    return k();
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
  
  private List<RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem> a(MiniAppData paramMiniAppData)
  {
    ArrayList localArrayList = new ArrayList();
    RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem localWeChatVideoArticleItem = new RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem();
    localWeChatVideoArticleItem.a = paramMiniAppData.c;
    localWeChatVideoArticleItem.b = paramMiniAppData.jdField_a_of_type_Int;
    localArrayList.add(localWeChatVideoArticleItem);
    return localArrayList;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemWebProteusViewCreator$ProteusItemViewOnClickListener = null;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1012, b());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1023, c());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1002, d());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1001, e());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1162, f());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1158, g());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1161, h());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1174, i());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1039, i());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1041, j());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1202, a());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1160, FastWebPTSUtils.a());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1129, FastWebPTSUtils.b());
    k();
  }
  
  private void a(Context paramContext, ProteusItemData paramProteusItemData)
  {
    ViewFactory.findClickableViewListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), new WebProteusViewCreator.ProteusItemViewHolder.1(this, paramContext, paramProteusItemData));
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
        if (paramView.z == 1) {
          b(paramView);
        }
        if ((paramView.A == 2) && ((WebProteusViewCreator.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemWebProteusViewCreator) instanceof FastWebActivity)))
        {
          RIJ3ClickUtils.a.a(paramView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, (FastWebActivity)WebProteusViewCreator.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemWebProteusViewCreator));
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
    JSONObject localJSONObject = paramProteusItemData.c;
    Object localObject1 = paramViewBase.getEventAttachedData();
    Object localObject2 = a(localJSONObject);
    if (a())
    {
      a(paramViewBase, paramContext, paramProteusItemData, (String)localObject1, localJSONObject, (String)localObject2);
      return;
    }
    localObject1 = new FastWebRecommendUGInfo(localJSONObject.optString("kd_ug_rsp_info"), (String)localObject2);
    KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(((FastWebRecommendUGInfo)localObject1).a, (String)localObject2, "3"));
    DownloadInfo localDownloadInfo = DownloadManagerV2.a().b(((FastWebRecommendUGInfo)localObject1).b);
    if (localDownloadInfo == null)
    {
      KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(((FastWebRecommendUGInfo)localObject1).a, (String)localObject2, "9"));
      KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(((FastWebRecommendUGInfo)localObject1).a, (String)localObject2, "10"));
      localObject2 = new DownloadInfo();
      ((DownloadInfo)localObject2).d = ((FastWebRecommendUGInfo)localObject1).b;
      ((DownloadInfo)localObject2).m = "biz_src_kandian_read";
      ((DownloadInfo)localObject2).e = "com.tencent.reading";
      DownloadManagerV2.a().b((DownloadInfo)localObject2);
      try
      {
        localObject2 = localJSONObject.getJSONObject("id_recommend_category_txt");
        ((JSONObject)localObject2).put("text", "下载中...0%");
        ((JSONObject)localObject2).put("label_ug_progress_progress", 0);
        if (WebProteusViewCreator.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemWebProteusViewCreator) == null) {
          break label242;
        }
        WebProteusViewCreator.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemWebProteusViewCreator).notifyDataSetChanged();
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
    label242:
    if (((FastWebRecommendUGInfo)localObject1).d != null)
    {
      localObject1 = ((FastWebRecommendUGInfo)localObject1).d;
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
    paramContext = ReportUtil.a(paramProteusItemData.a, paramViewBase.getName());
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
    KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(localFastWebRecommendUGInfo.a, paramString2, "3"));
    KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(localFastWebRecommendUGInfo.a, paramString2, "7"));
    if (!TextUtils.isEmpty(localFastWebRecommendUGInfo.c))
    {
      paramString2 = new Intent();
      paramString2.setAction("android.intent.action.VIEW");
      paramString2.putExtra("big_brother_source_key", "biz_src_kandian_read");
      paramString2.setData(Uri.parse(localFastWebRecommendUGInfo.c));
      if (VideoFeedsHelper.a(paramContext, paramString2)) {
        paramContext.startActivity(paramString2);
      }
    }
    paramContext = ReportUtil.a(paramProteusItemData.a, paramViewBase.getName());
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
    if (!paramMiniAppData.jdField_a_of_type_Boolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestWechatVideoSeelaterProgress: ");
      localStringBuilder.append(paramMiniAppData);
      QLog.d("WebProteusViewCreator", 1, localStringBuilder.toString());
      paramMiniAppData.jdField_a_of_type_Boolean = true;
      ReadInJoyLogicEngine.a().a().a(a(paramMiniAppData));
      QQToast.a(BaseApplicationImpl.getApplication(), 0, HardCodeUtil.a(2131718334), 0).a();
      VideoReportUtil.a.a(paramMiniAppData.b, 0L, paramMiniAppData);
    }
  }
  
  private void a(ProteusItemData paramProteusItemData)
  {
    if (paramProteusItemData.c != null) {
      try
      {
        paramProteusItemData = paramProteusItemData.c.optJSONObject("card_info");
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
        KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(paramJSONObject.a, paramString, "20"));
        if (!DownloadManagerV2.a().a(paramDownloadInfo)) {
          DownloadManagerV2.a().b(paramDownloadInfo);
        }
      }
      else
      {
        if (a(paramDownloadInfo.a()))
        {
          DownloadManagerV2.a().a(paramJSONObject.b);
          KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(paramJSONObject.a, paramString, "22"));
          return;
        }
        KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(paramJSONObject.a, paramString, "10"));
        DownloadManagerV2.a().b(paramDownloadInfo);
        paramString = new StringBuilder();
        paramString.append(paramJSONObject.h);
        paramString.append(paramDownloadInfo.f);
        paramString.append("%");
        localJSONObject.put("text", paramString.toString());
        localJSONObject.put("label_ug_progress_progress", paramDownloadInfo.f);
        if (WebProteusViewCreator.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemWebProteusViewCreator) != null)
        {
          WebProteusViewCreator.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemWebProteusViewCreator).notifyDataSetChanged();
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
    return PackageUtil.a(BaseApplicationImpl.getContext(), "com.tencent.reading").equals("0") ^ true;
  }
  
  private boolean a(int paramInt)
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
  
  private boolean a(JSONObject paramJSONObject)
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
            if (((FastWebRecommendUGInfo)localObject).c != null) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener b()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.4(this);
  }
  
  private void b(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    JSONObject localJSONObject = paramProteusItemData.c;
    String str2 = paramViewBase.getEventAttachedData();
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = RIJJumpUtils.a(str2, localJSONObject);
      RIJJumpUtils.a(paramContext, str1);
    }
    paramContext = ReportUtil.a(paramProteusItemData.a, paramViewBase.getName());
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
    this.jdField_a_of_type_AndroidViewView.setOnLongClickListener(new WebProteusViewCreator.ProteusItemViewHolder.2(this, paramProteusItemData));
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener c()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.5(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener d()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.6(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener e()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.7(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener f()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.8(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener g()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.9(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener h()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.10(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener i()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.11(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener j()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.12(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemWebProteusViewCreator$ProteusItemViewOnClickListener == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemWebProteusViewCreator$ProteusItemViewOnClickListener = new WebProteusViewCreator.ProteusItemViewHolder.13(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemWebProteusViewCreator$ProteusItemViewOnClickListener;
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer != null)
    {
      if (paramBaseData2 == null) {
        return;
      }
      if ((paramBaseData2 instanceof ProteusItemData))
      {
        paramBaseData1 = (ProteusItemData)paramBaseData2;
        Object localObject = paramBaseData1.a;
        if (localObject != null)
        {
          WebProteusViewCreator.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemWebProteusViewCreator, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer);
          try
          {
            ((TemplateBean)localObject).bindData(paramBaseData1.c);
            ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramBaseData1.a.getViewBean());
            this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData = paramBaseData1;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("bindWebProteusViewCreator: ");
            ((StringBuilder)localObject).append(paramBaseData1.c);
            QLog.d("WebProteusViewCreator", 1, ((StringBuilder)localObject).toString());
          }
          catch (Exception localException)
          {
            QLog.e("WebProteusViewCreator", 1, QLog.getStackTraceString(localException));
          }
          a(WebProteusViewCreator.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemWebProteusViewCreator), paramBaseData1);
          a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, paramBaseData2);
        }
        if ((paramBaseData2 instanceof ProteusAnimationItemData)) {
          ((ProteusAnimationItemData)paramBaseData2).a(this.jdField_a_of_type_AndroidViewView);
        }
        a(paramBaseData1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebProteusViewCreator.ProteusItemViewHolder
 * JD-Core Version:    0.7.0.1
 */