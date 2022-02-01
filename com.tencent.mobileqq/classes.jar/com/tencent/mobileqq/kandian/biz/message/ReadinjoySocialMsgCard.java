package com.tencent.mobileqq.kandian.biz.message;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadinjoySocialMsgCard
  implements ReadinjoySocialMsgUI
{
  private static Set<KandianMsgBoxRedPntInfo> jdField_a_of_type_JavaUtilSet = new HashSet();
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private KandianMsgBoxRedPntInfo jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo;
  
  public ReadinjoySocialMsgCard(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    c();
  }
  
  public static void a(int paramInt)
  {
    Object localObject = jdField_a_of_type_JavaUtilSet;
    jdField_a_of_type_JavaUtilSet = new HashSet();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      b(false, paramInt, (KandianMsgBoxRedPntInfo)((Iterator)localObject).next());
    }
  }
  
  private static void b(boolean paramBoolean, int paramInt, KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    for (;;)
    {
      Object localObject;
      try
      {
        localReportR5Builder.addFeedsType(1037);
        localReportR5Builder.addChannelId(0);
        localReportR5Builder.addString("message_type", String.valueOf(paramKandianMsgBoxRedPntInfo.messageType));
        localReportR5Builder.addString("feedsid", String.valueOf(paramKandianMsgBoxRedPntInfo.feedsID));
        localReportR5Builder.addString("feedstype", String.valueOf(paramKandianMsgBoxRedPntInfo.feedsType));
        if (paramKandianMsgBoxRedPntInfo.mMsgType == 2)
        {
          localReportR5Builder.addString("sys_msg_id", String.valueOf(paramKandianMsgBoxRedPntInfo.sysMsgID));
          localReportR5Builder.addString("sys_msg_from", String.valueOf(paramKandianMsgBoxRedPntInfo.sysMsgFrom));
        }
        localReportR5Builder.addString("reddot_num", String.valueOf(paramKandianMsgBoxRedPntInfo.mMsgCnt));
        localReportR5Builder.addRowkey("msgbox1000000000");
        if (paramBoolean) {
          break label230;
        }
        localReportR5Builder.addString("behavior_type", String.valueOf(paramInt));
      }
      catch (Exception paramKandianMsgBoxRedPntInfo)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("report has error ");
        ((StringBuilder)localObject).append(paramKandianMsgBoxRedPntInfo);
        QLog.e("ReadinjoySocialMsgCard", 1, ((StringBuilder)localObject).toString());
        return;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", String.valueOf(paramKandianMsgBoxRedPntInfo.mUin), (String)localObject, (String)localObject, 0, 0, String.valueOf(paramKandianMsgBoxRedPntInfo.mUin), "", "", localReportR5Builder.build(), false);
      return;
      label230:
      if (paramBoolean) {
        localObject = "0X8007625";
      } else {
        localObject = "0X8007626";
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new VafContext();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(this.jdField_a_of_type_AndroidAppActivity);
    ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(new ReadinjoySocialMsgCard.1(this));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo;
      if ((localKandianMsgBoxRedPntInfo != null) && (localKandianMsgBoxRedPntInfo.mMsgCnt > 0))
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        jdField_a_of_type_JavaUtilSet.add(this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo);
      }
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    if ((paramKandianMsgBoxRedPntInfo != null) && (!paramKandianMsgBoxRedPntInfo.equals(this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo))) {
      try
      {
        localJSONObject = new JSONObject();
        if (!TextUtils.isEmpty(paramKandianMsgBoxRedPntInfo.mIconUrl)) {
          localJSONObject.put("msgbox_redpoint_icon", paramKandianMsgBoxRedPntInfo.mIconUrl);
        }
        localObject2 = paramKandianMsgBoxRedPntInfo.mCardSummary;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131694295);
        }
        localJSONObject.put("msgbox_redpoint_content", new QQText(EmotionCodecUtils.b((String)localObject1), 7, 17));
        if (!TextUtils.isEmpty(paramKandianMsgBoxRedPntInfo.mArticlePicUrl)) {
          localJSONObject.put("msgbox_redpoint_image", paramKandianMsgBoxRedPntInfo.mArticlePicUrl);
        }
        localJSONObject.put("msgbox_redpoint_count", String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131694296), new Object[] { ReadInJoyHelper.b(paramKandianMsgBoxRedPntInfo.mMsgCnt) }));
        localJSONObject.put("style_ID", "ReadInjoy_msgbox_cell");
        localJSONObject.put("message_type", paramKandianMsgBoxRedPntInfo.messageType);
        localJSONObject.put("feedsid", paramKandianMsgBoxRedPntInfo.feedsID);
        localJSONObject.put("feedstype", paramKandianMsgBoxRedPntInfo.feedsType);
        localJSONObject.put("sys_msg_from", paramKandianMsgBoxRedPntInfo.sysMsgFrom);
        localJSONObject.put("sys_msg_id", paramKandianMsgBoxRedPntInfo.sysMsgID);
        localJSONObject.put("reddot_num", paramKandianMsgBoxRedPntInfo.mMsgCnt);
      }
      catch (JSONException paramKandianMsgBoxRedPntInfo)
      {
        JSONObject localJSONObject;
        Object localObject2;
        label311:
        paramKandianMsgBoxRedPntInfo.printStackTrace();
        return;
      }
    }
    try
    {
      if (!TextUtils.isEmpty(paramKandianMsgBoxRedPntInfo.mExtraData))
      {
        localObject1 = new JSONObject(paramKandianMsgBoxRedPntInfo.mExtraData);
        localObject2 = ((JSONObject)localObject1).keys();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          localJSONObject.put(str, ((JSONObject)localObject1).get(str));
        }
      }
    }
    catch (JSONException localJSONException)
    {
      break label311;
    }
    Object localObject1 = ProteusParser.getTemplateBean(TemplateFactory.a("default_feeds", true), localJSONObject);
    if (localObject1 == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (TemplateBean)localObject1);
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
      if (localObject2 == null)
      {
        QLog.d("ReadinjoySocialMsgCard", 1, "create proteus view error!");
        return;
      }
      localObject2 = ((Container)localObject2).getVirtualView().getComLayoutParams();
      localObject2 = new RelativeLayout.LayoutParams(((Layout.Params)localObject2).mLayoutWidth, ((Layout.Params)localObject2).mLayoutHeight);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, (ViewGroup.LayoutParams)localObject2);
    }
    ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), ((TemplateBean)localObject1).getViewBean());
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoReddotKandianMsgBoxRedPntInfo = paramKandianMsgBoxRedPntInfo;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("set msg info : ");
    ((StringBuilder)localObject1).append(paramKandianMsgBoxRedPntInfo);
    QLog.d("ReadinjoySocialMsgCard", 1, ((StringBuilder)localObject1).toString());
    return;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("210 msgInfo is null ! ");
    ((StringBuilder)localObject1).append(paramKandianMsgBoxRedPntInfo);
    QLog.d("ReadinjoySocialMsgCard", 2, ((StringBuilder)localObject1).toString());
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.ReadinjoySocialMsgCard
 * JD-Core Version:    0.7.0.1
 */