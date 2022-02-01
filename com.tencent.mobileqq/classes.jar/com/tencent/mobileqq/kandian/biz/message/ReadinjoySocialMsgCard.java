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
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatServiceImpl;
import com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatServiceImpl.Companion;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
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
  private static Set<KandianMsgBoxRedPntInfo> g = new HashSet();
  private FrameLayout a;
  private View.OnClickListener b;
  private Activity c;
  private VafContext d;
  private KandianMsgBoxRedPntInfo e;
  private Container f;
  
  public ReadinjoySocialMsgCard(Activity paramActivity)
  {
    this.c = paramActivity;
    d();
  }
  
  public static void a(int paramInt)
  {
    Object localObject = g;
    g = new HashSet();
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
        localReportR5Builder.addString("reddot_num", String.valueOf(RIJPrivateChatServiceImpl.Companion.a().getTotalRedCount(paramKandianMsgBoxRedPntInfo)));
        localReportR5Builder.addRowkey("msgbox1000000000");
        if (paramBoolean) {
          break label226;
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
      PublicAccountReportUtils.a(null, "CliOper", "", String.valueOf(paramKandianMsgBoxRedPntInfo.mUin), (String)localObject, (String)localObject, 0, 0, String.valueOf(paramKandianMsgBoxRedPntInfo.mUin), "", "", localReportR5Builder.build(), false);
      return;
      label226:
      if (paramBoolean) {
        localObject = "0X8007625";
      } else {
        localObject = "0X8007626";
      }
    }
  }
  
  private void d()
  {
    this.d = new VafContext();
    this.d.setContext(this.c);
    this.d.setCurActivity(this.c);
    ProteusSupportUtil.a(this.d, "default_feeds");
    this.a = new FrameLayout(this.c);
    this.a.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    this.a.setOnClickListener(new ReadinjoySocialMsgCard.1(this));
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
  }
  
  public void a(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    if ((paramKandianMsgBoxRedPntInfo != null) && (!paramKandianMsgBoxRedPntInfo.equals(this.e))) {
      try
      {
        localJSONObject = new JSONObject();
        if (!TextUtils.isEmpty(paramKandianMsgBoxRedPntInfo.mIconUrl)) {
          localJSONObject.put("msgbox_redpoint_icon", paramKandianMsgBoxRedPntInfo.mIconUrl);
        }
        localObject2 = paramKandianMsgBoxRedPntInfo.mCardSummary;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = this.c.getResources().getString(2131891933);
        }
        localJSONObject.put("msgbox_redpoint_content", new QQText(EmotionCodecUtils.c((String)localObject1), 7, 17));
        if (!TextUtils.isEmpty(paramKandianMsgBoxRedPntInfo.mArticlePicUrl)) {
          localJSONObject.put("msgbox_redpoint_image", paramKandianMsgBoxRedPntInfo.mArticlePicUrl);
        }
        localJSONObject.put("msgbox_redpoint_count", String.format(this.c.getResources().getString(2131891934), new Object[] { ReadInJoyHelper.d(RIJPrivateChatServiceImpl.Companion.a().getTotalRedCount(paramKandianMsgBoxRedPntInfo)) }));
        localJSONObject.put("style_ID", "ReadInjoy_msgbox_cell");
        localJSONObject.put("message_type", paramKandianMsgBoxRedPntInfo.messageType);
        localJSONObject.put("feedsid", paramKandianMsgBoxRedPntInfo.feedsID);
        localJSONObject.put("feedstype", paramKandianMsgBoxRedPntInfo.feedsType);
        localJSONObject.put("sys_msg_from", paramKandianMsgBoxRedPntInfo.sysMsgFrom);
        localJSONObject.put("sys_msg_id", paramKandianMsgBoxRedPntInfo.sysMsgID);
        localJSONObject.put("reddot_num", RIJPrivateChatServiceImpl.Companion.a().getTotalRedCount(paramKandianMsgBoxRedPntInfo));
      }
      catch (JSONException paramKandianMsgBoxRedPntInfo)
      {
        JSONObject localJSONObject;
        Object localObject2;
        label324:
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
      break label324;
    }
    Object localObject1 = ProteusParser.getTemplateBean(TemplateFactory.a("default_feeds", true), localJSONObject);
    if (localObject1 == null) {
      return;
    }
    if (this.f == null)
    {
      this.f = this.d.getViewFactory().inflate(this.d, (TemplateBean)localObject1);
      localObject2 = this.f;
      if (localObject2 == null)
      {
        QLog.d("ReadinjoySocialMsgCard", 1, "create proteus view error!");
        return;
      }
      localObject2 = ((Container)localObject2).getVirtualView().getComLayoutParams();
      localObject2 = new RelativeLayout.LayoutParams(((Layout.Params)localObject2).mLayoutWidth, ((Layout.Params)localObject2).mLayoutHeight);
      this.a.addView(this.f, (ViewGroup.LayoutParams)localObject2);
    }
    ProteusSupportUtil.a(this.f.getVirtualView(), ((TemplateBean)localObject1).getViewBean());
    this.e = paramKandianMsgBoxRedPntInfo;
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
    if ((this.a != null) && (this.e != null) && (RIJPrivateChatServiceImpl.Companion.a().getTotalRedCount(this.e) > 0))
    {
      this.a.setVisibility(0);
      g.add(this.e);
    }
  }
  
  public void c()
  {
    this.c = null;
    this.a = null;
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.ReadinjoySocialMsgCard
 * JD-Core Version:    0.7.0.1
 */