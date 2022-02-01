package com.tencent.mobileqq.ecshop.temp.api.impl;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.statistics.GdtC2SReporter;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.api.IEcshopService;
import com.tencent.mobileqq.ecshop.api.IEcshopUtilApi;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.ecshop.view.api.IEcshopRainViewApi;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout6;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutPromotion;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HeaderViewListAdapter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class EcshopMessageApiImpl
  implements IEcshopMessageApi
{
  private static final String TAG = "EcshopMessageApi";
  
  public static void enterGDTVideoActivity(BaseQQAppInterface paramBaseQQAppInterface, AbsStructMsgElement paramAbsStructMsgElement, Activity paramActivity)
  {
    if (paramAbsStructMsgElement == null) {
      return;
    }
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = getAdInfo(paramAbsStructMsgElement);
    ((IEcshopService)paramBaseQQAppInterface.getRuntimeService(IEcshopService.class)).enterGDTVideoActivity(localAdInfo, paramAbsStructMsgElement.ap, paramAbsStructMsgElement.ak, paramActivity);
  }
  
  public static boolean enterGdtCanvasActivity(BaseQQAppInterface paramBaseQQAppInterface, AbsStructMsgElement paramAbsStructMsgElement, Activity paramActivity)
  {
    if (paramAbsStructMsgElement == null) {
      return false;
    }
    if (((paramAbsStructMsgElement.as instanceof AbsShareMsg)) && (((AbsShareMsg)paramAbsStructMsgElement.as).mStructMsgItemLists != null))
    {
      paramAbsStructMsgElement = (AbsStructMsgElement)((AbsShareMsg)paramAbsStructMsgElement.as).mStructMsgItemLists.get(0);
      if (((paramAbsStructMsgElement instanceof AbsStructMsgItem)) && (paramAbsStructMsgElement.t == 1))
      {
        qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = getAdInfo(paramAbsStructMsgElement);
        return ((IEcshopService)paramBaseQQAppInterface.getRuntimeService(IEcshopService.class)).enterGdtCanvasActivity(localAdInfo, paramAbsStructMsgElement.ap, paramAbsStructMsgElement.ak, paramActivity);
      }
    }
    return false;
  }
  
  private static AbsStructMsgElement getAbsStructMsgElement(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg;
      if ((paramMessageRecord instanceof StructMsgForGeneralShare))
      {
        paramMessageRecord = (StructMsgForGeneralShare)paramMessageRecord;
        if ((paramMessageRecord.mStructMsgItemLists != null) && (paramMessageRecord.mStructMsgItemLists.size() > 0)) {
          return (AbsStructMsgElement)paramMessageRecord.mStructMsgItemLists.get(0);
        }
      }
    }
    return null;
  }
  
  public static qq_ad_get.QQAdGetRsp.AdInfo getAdInfo(AbsStructMsgElement paramAbsStructMsgElement)
  {
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
    if (paramAbsStructMsgElement == null) {
      return localAdInfo;
    }
    Object localObject1;
    if (!StringUtil.isEmpty(paramAbsStructMsgElement.aj))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("adinfo<<<<<<<<<<<<<");
        ((StringBuilder)localObject1).append(paramAbsStructMsgElement.aj);
        QLog.i("EcshopMessageApi", 2, ((StringBuilder)localObject1).toString());
      }
      try
      {
        paramAbsStructMsgElement = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramAbsStructMsgElement.aj)));
        return paramAbsStructMsgElement;
      }
      catch (JSONException paramAbsStructMsgElement)
      {
        paramAbsStructMsgElement.printStackTrace();
      }
    }
    else
    {
      Object localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo();
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.u)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject2).advertiser_id.set(Long.parseLong(paramAbsStructMsgElement.u));
      }
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.T)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject2).corporate_image_name.set(paramAbsStructMsgElement.T);
      }
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.U)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject2).corporate_logo.set(paramAbsStructMsgElement.U);
      }
      Object localObject3 = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo();
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.K)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localObject3).video_url.set(paramAbsStructMsgElement.K);
      }
      ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localObject3).media_duration.set(paramAbsStructMsgElement.aa);
      ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localObject3).video_file_size.set(paramAbsStructMsgElement.ab);
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.ag)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localObject3).tencent_video_id.set(paramAbsStructMsgElement.ag);
      }
      localObject1 = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo();
      ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo)localObject1).advertiser_info.set((MessageMicro)localObject2);
      ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo)localObject1).video_info.set((MessageMicro)localObject3);
      ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo)localObject1).mini_program_type.set(paramAbsStructMsgElement.P);
      localObject3 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.v)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject3).aid.set(Long.parseLong(paramAbsStructMsgElement.v));
      }
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.I)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject3).traceid.set(paramAbsStructMsgElement.I);
      }
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.J)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject3).via.set(paramAbsStructMsgElement.J);
      }
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.E)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject3).product_id.set(paramAbsStructMsgElement.E);
      }
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.D)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject3).noco_id.set(Long.parseLong(paramAbsStructMsgElement.D));
      }
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.ah)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject3).view_id.set(paramAbsStructMsgElement.ah);
      }
      localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.s)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject2).exposure_url.set(paramAbsStructMsgElement.s);
      }
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.G)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject2).click_url.set(paramAbsStructMsgElement.G);
      }
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.A)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject2).effect_url.set(paramAbsStructMsgElement.A);
      }
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.C)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject2).landing_page_report_url.set(paramAbsStructMsgElement.C);
      }
      ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject2).trace_info.set((MessageMicro)localObject3);
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.X)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject2).negative_feedback_url.set(paramAbsStructMsgElement.X);
      }
      localObject3 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls();
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.Q)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls)localObject3).api_click_monitor_url.set(Arrays.asList(paramAbsStructMsgElement.Q.split("\\|")));
      }
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.R)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls)localObject3).api_exposure_monitor_url.set(Arrays.asList(paramAbsStructMsgElement.R.split("\\|")));
      }
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.Z)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls)localObject3).sdk_click_monitor_url.set(Arrays.asList(paramAbsStructMsgElement.Z.split("\\|")));
      }
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.Y)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls)localObject3).sdk_exposure_monitor_url.set(Arrays.asList(paramAbsStructMsgElement.Y.split("\\|")));
      }
      ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject2).thirdparty_monitor_urls.set((MessageMicro)localObject3);
      localObject3 = new qq_ad_get.QQAdGetRsp.AdInfo.DestInfo();
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.B)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject3).landing_page.set(paramAbsStructMsgElement.B);
      }
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.x)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject3).canvas_json.set(paramAbsStructMsgElement.x);
      }
      ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject3).dest_type.set(paramAbsStructMsgElement.z);
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.ae)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject3).universal_link.set(paramAbsStructMsgElement.ae);
      }
      qq_ad_get.QQAdGetRsp.AdInfo.AppInfo localAppInfo = new qq_ad_get.QQAdGetRsp.AdInfo.AppInfo();
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.M)) {
        localAppInfo.customized_invoke_url.set(paramAbsStructMsgElement.M);
      }
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.w)) {
        localAppInfo.pkg_download_schema.set(paramAbsStructMsgElement.w);
      }
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.L)) {
        localAppInfo.app_name.set(paramAbsStructMsgElement.L);
      }
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.N)) {
        localAppInfo.app_package_name.set(paramAbsStructMsgElement.N);
      }
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.O)) {
        localAppInfo.pkg_url.set(paramAbsStructMsgElement.O);
      }
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.E)) {
        localAppInfo.android_app_id.set(paramAbsStructMsgElement.E);
      }
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.H)) {
        localAppInfo.channel_id.set(paramAbsStructMsgElement.H);
      }
      localAppInfo.app_score_num.set(paramAbsStructMsgElement.ac);
      localAppInfo.download_num.set(paramAbsStructMsgElement.ad);
      localAdInfo.product_type.set(paramAbsStructMsgElement.F);
      localAdInfo.display_info.set((MessageMicro)localObject1);
      localAdInfo.report_info.set((MessageMicro)localObject2);
      localAdInfo.dest_info.set((MessageMicro)localObject3);
      localAdInfo.app_info.set(localAppInfo);
      if (!StringUtil.isEmpty(paramAbsStructMsgElement.af)) {
        localAdInfo.ext_json.set(paramAbsStructMsgElement.af);
      }
    }
    return localAdInfo;
  }
  
  private static double getPercentageOfGlobalVisibleRect(View paramView)
  {
    if (paramView == null) {
      return 0.0D;
    }
    Rect localRect = new Rect();
    if (!paramView.getGlobalVisibleRect(localRect)) {
      return 0.0D;
    }
    if ((localRect.left < UIUtils.c(paramView.getContext())) && (localRect.top < UIUtils.d(paramView.getContext())) && (localRect.right > 0))
    {
      if (localRect.bottom <= 0) {
        return 0.0D;
      }
      double d1 = localRect.width();
      Double.isNaN(d1);
      double d2 = localRect.height();
      Double.isNaN(d2);
      double d3 = paramView.getWidth() * paramView.getHeight();
      Double.isNaN(d3);
      return d1 * 1.0D * d2 / d3;
    }
    return 0.0D;
  }
  
  public static View getViewByPosition(ChatMessage paramChatMessage, ChatXListView paramChatXListView)
  {
    int i = ((ChatAdapter1)((HeaderViewListAdapter)paramChatXListView.getAdapter()).getWrappedAdapter()).b(paramChatMessage) + paramChatXListView.getHeaderViewsCount();
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("pos is:");
      paramChatMessage.append(i);
      QLog.d("Q.msg.delmsg", 2, paramChatMessage.toString());
    }
    if (i < 0) {
      return null;
    }
    return paramChatXListView.getChildAt(i - paramChatXListView.getFirstVisiblePosition());
  }
  
  public static void handlePubTailMsg(ChatMessage paramChatMessage)
  {
    try
    {
      if (Build.VERSION.SDK_INT < 23) {
        return;
      }
      if (!(paramChatMessage instanceof MessageForStructing)) {
        return;
      }
      paramChatMessage = (MessageForStructing)paramChatMessage;
      Object localObject = (StructMsgForGeneralShare)paramChatMessage.structingMsg;
      EcshopConfBean localEcshopConfBean = ((IEcshopUtilApi)QRoute.api(IEcshopUtilApi.class)).getEcshopConfBean();
      if (!((IEcshopRainViewApi)QRoute.api(IEcshopRainViewApi.class)).isInPromotionTime(localEcshopConfBean.m, paramChatMessage)) {
        return;
      }
      localObject = ((StructMsgForGeneralShare)localObject).getStructMsgItemLists();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((List)localObject).get(0);
        StructMsgItemLayoutPromotion localStructMsgItemLayoutPromotion = new StructMsgItemLayoutPromotion();
        if (localStructMsgItemLayoutPromotion.a(localAbsStructMsgElement, localEcshopConfBean.m))
        {
          ((List)localObject).clear();
          ((List)localObject).add(localStructMsgItemLayoutPromotion);
          paramChatMessage.bDynicMsg = true;
          return;
        }
      }
    }
    catch (Exception paramChatMessage)
    {
      QLog.e("EcshopMessageApi", 1, paramChatMessage, new Object[0]);
    }
  }
  
  public static List<String> jsonArrayToList(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      if (paramJSONArray.length() == 0) {
        return localArrayList;
      }
      int i = 0;
      while (i < paramJSONArray.length())
      {
        localArrayList.add(paramJSONArray.optString(i));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public void GdtC2SReportArkMsg(MessageRecord paramMessageRecord, int paramInt)
  {
    int i = 0;
    if ((paramInt != 0) && (paramInt == 1)) {
      i = 1;
    }
    paramMessageRecord = getAdInfoByChatMessage(paramMessageRecord);
    if (paramMessageRecord != null) {
      GdtC2SReporter.a(i, 2, paramMessageRecord);
    }
  }
  
  public void GdtC2SReportStructMsg(MessageRecord paramMessageRecord, int paramInt)
  {
    int i = 0;
    if ((paramInt != 0) && (paramInt == 1)) {
      i = 1;
    }
    paramMessageRecord = getAbsStructMsgElement(paramMessageRecord);
    if (paramMessageRecord != null) {
      GdtC2SReporter.a(i, 2, getAdInfo(paramMessageRecord));
    }
  }
  
  public ChatMessage buildMessageForArkApp(String paramString)
  {
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(-5008);
    localMessageForArkApp.msgtype = -5008;
    ArkAppMessage localArkAppMessage = new ArkAppMessage();
    localArkAppMessage.fromAppXml(paramString);
    localMessageForArkApp.msgData = localArkAppMessage.toBytes();
    localMessageForArkApp.parse();
    return localMessageForArkApp;
  }
  
  public void doArkAppContainerOnEvent(MessageRecord paramMessageRecord, int paramInt)
  {
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = (MessageForArkApp)paramMessageRecord;
      if (paramMessageRecord.arkContainer != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("EcshopMessageApi", 2, "doOnEvent ARKAPP_TYPE_DESTROY");
        }
        paramMessageRecord.arkContainer.doOnEvent(paramInt);
      }
    }
  }
  
  public qq_ad_get.QQAdGetRsp.AdInfo getAdInfoByChatMessage(@Nullable MessageRecord paramMessageRecord)
  {
    boolean bool = paramMessageRecord instanceof MessageForStructing;
    Object localObject2 = null;
    AbsStructMsgElement localAbsStructMsgElement = null;
    Object localObject3 = null;
    Object localObject1;
    if (bool)
    {
      paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg;
      localObject1 = localAbsStructMsgElement;
      if ((paramMessageRecord instanceof StructMsgForGeneralShare))
      {
        paramMessageRecord = ((StructMsgForGeneralShare)paramMessageRecord).mStructMsgItemLists;
        localObject1 = localAbsStructMsgElement;
        if (paramMessageRecord != null)
        {
          localObject1 = localAbsStructMsgElement;
          if (!paramMessageRecord.isEmpty())
          {
            localObject2 = paramMessageRecord.iterator();
            paramMessageRecord = localObject3;
            label165:
            do
            {
              for (;;)
              {
                localObject1 = paramMessageRecord;
                if (!((Iterator)localObject2).hasNext()) {
                  return localObject1;
                }
                localObject1 = (AbsStructMsgElement)((Iterator)localObject2).next();
                if (!(localObject1 instanceof StructMsgItemLayout5)) {
                  break label165;
                }
                localObject1 = ((StructMsgItemLayout5)localObject1).ax;
                if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
                {
                  localObject1 = ((ArrayList)localObject1).iterator();
                  if (((Iterator)localObject1).hasNext())
                  {
                    localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject1).next();
                    if (!(localAbsStructMsgElement instanceof StructMsgItemVideo)) {
                      break;
                    }
                    paramMessageRecord = getAdInfo(localAbsStructMsgElement);
                  }
                }
              }
            } while ((!(localObject1 instanceof StructMsgItemLayout6)) && (!(localObject1 instanceof StructMsgItemLayoutPromotion)));
            paramMessageRecord = getAdInfo((AbsStructMsgElement)localObject1);
          }
        }
      }
    }
    else
    {
      for (;;)
      {
        return paramMessageRecord;
        localObject1 = localAbsStructMsgElement;
        if ((paramMessageRecord instanceof MessageForArkApp)) {
          try
          {
            paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
            localObject1 = localAbsStructMsgElement;
            if (paramMessageRecord != null)
            {
              paramMessageRecord = paramMessageRecord.metaList;
              localObject1 = localAbsStructMsgElement;
              if (!StringUtil.isEmpty(paramMessageRecord))
              {
                paramMessageRecord = new JSONObject(paramMessageRecord).optJSONObject("gdt");
                localObject1 = localAbsStructMsgElement;
                if (paramMessageRecord != null)
                {
                  localObject1 = new qq_ad_get.QQAdGetRsp.AdInfo();
                  try
                  {
                    localObject2 = paramMessageRecord.optJSONObject("adInfo");
                    if (localObject2 != null)
                    {
                      if (QLog.isColorLevel())
                      {
                        paramMessageRecord = new StringBuilder();
                        paramMessageRecord.append("ark adinfo<<<<<<<<<<<<<");
                        paramMessageRecord.append(localObject2);
                        QLog.i("EcshopMessageApi", 2, paramMessageRecord.toString());
                      }
                      paramMessageRecord = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), localObject2));
                      continue;
                    }
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.trace_info.aid.set(Long.parseLong(paramMessageRecord.optString("aid")));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.trace_info.traceid.set(paramMessageRecord.optString("traceid"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.exposure_url.set(paramMessageRecord.optString("apurl"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.trace_info.view_id.set(paramMessageRecord.optString("view_id"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.trace_info.via.set(paramMessageRecord.optString("via"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.trace_info.noco_id.set(paramMessageRecord.optInt("noco_id"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.trace_info.product_id.set(paramMessageRecord.optString("product_id"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.effect_url.set(paramMessageRecord.optString("effect_url"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.landing_page_report_url.set(paramMessageRecord.optString("landing_page_report_url"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).dest_info.landing_page.set(paramMessageRecord.optString("landing_page"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).display_info.advertiser_info.corporate_image_name.set(paramMessageRecord.optString("corporate_image_name"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).display_info.advertiser_info.corporate_logo.set(paramMessageRecord.optString("corporate_logo"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).display_info.advertiser_info.advertiser_id.set(paramMessageRecord.optInt("advertiser_id"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).display_info.video_info.video_url.set(paramMessageRecord.optString("video_url"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).display_info.creative_size.set(paramMessageRecord.optInt("creative_size"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).display_info.mini_program_type.set(paramMessageRecord.optInt("mini_program_type"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).display_info.video_info.tencent_video_id.set(paramMessageRecord.optString("tencent_video_id"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).dest_info.canvas_json.set(paramMessageRecord.optString("canvas_json"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).app_info.customized_invoke_url.set(paramMessageRecord.optString("customized_invoke_url"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).app_info.app_score_num.set(paramMessageRecord.optInt("app_score_num"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).app_info.download_num.set(paramMessageRecord.optInt("download_num"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).app_info.pkg_url.set(paramMessageRecord.optString("pkgurl"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).app_info.channel_id.set(paramMessageRecord.optString("subordinate_product_id"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).product_type.set(paramMessageRecord.optInt("product_type"));
                    localObject2 = paramMessageRecord.optJSONObject("thirdparty_monitor_urls");
                    if (localObject2 != null)
                    {
                      ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.thirdparty_monitor_urls.api_click_monitor_url.set(jsonArrayToList(((JSONObject)localObject2).optJSONArray("api_click_monitor_url")));
                      ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.thirdparty_monitor_urls.api_exposure_monitor_url.set(jsonArrayToList(((JSONObject)localObject2).optJSONArray("api_exposure_monitor_url")));
                      ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.thirdparty_monitor_urls.sdk_click_monitor_url.set(jsonArrayToList(((JSONObject)localObject2).optJSONArray("sdk_click_monitor_url")));
                      ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.thirdparty_monitor_urls.sdk_exposure_monitor_url.set(jsonArrayToList(((JSONObject)localObject2).optJSONArray("sdk_exposure_monitor_url")));
                    }
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.trace_info.view_id.set(paramMessageRecord.optString("view_id"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.negative_feedback_url.set(paramMessageRecord.optString("neg_feedback"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).display_info.video_info.media_duration.set(paramMessageRecord.optInt("media_duration"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).display_info.video_info.video_file_size.set(paramMessageRecord.optInt("video_file_size"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).dest_info.universal_link.set(paramMessageRecord.optString("universal_link"));
                    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).dest_info.dest_type.set(paramMessageRecord.optInt("dest_type"));
                    paramMessageRecord = paramMessageRecord.optString("ext");
                    if (!StringUtil.isEmpty(paramMessageRecord))
                    {
                      paramMessageRecord = new JSONObject(URLDecoder.decode(paramMessageRecord));
                      ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).ext_json.set(paramMessageRecord.optString("sdk_data"));
                      ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).app_info.app_package_name.set(paramMessageRecord.optString("pkg_name"));
                      ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).app_info.app_name.set(paramMessageRecord.optString("appname"));
                    }
                    return localObject1;
                  }
                  catch (Exception paramMessageRecord) {}
                  paramMessageRecord.printStackTrace();
                }
              }
            }
          }
          catch (Exception paramMessageRecord)
          {
            localObject1 = localObject2;
          }
        }
      }
    }
    return localObject1;
  }
  
  public String getArkMsgMetaList(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
      if (paramMessageRecord != null) {
        return paramMessageRecord.metaList;
      }
    }
    return null;
  }
  
  public String getArkMsgMsg(MessageRecord paramMessageRecord)
  {
    return ((MessageForArkApp)paramMessageRecord).msg;
  }
  
  public boolean getArkMsgReportClick(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = getArkMsgMetaList(paramMessageRecord);
    if (!StringUtil.isEmpty(paramMessageRecord)) {
      try
      {
        paramMessageRecord = new JSONObject(paramMessageRecord).optJSONObject("gdt");
        if (paramMessageRecord != null)
        {
          paramMessageRecord = paramMessageRecord.optJSONObject("extParams");
          if (paramMessageRecord != null)
          {
            boolean bool = paramMessageRecord.optBoolean("is_report_click");
            return bool;
          }
        }
      }
      catch (JSONException paramMessageRecord)
      {
        QLog.e("EcshopMessageApi", 1, paramMessageRecord, new Object[0]);
      }
    }
    return false;
  }
  
  public String getArkMsgSourceAd(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
    if (paramMessageRecord != null) {
      return paramMessageRecord.mSourceAd;
    }
    return null;
  }
  
  @NonNull
  public String getDisType(@Nullable MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg;
      if ((paramMessageRecord instanceof StructMsgForGeneralShare))
      {
        paramMessageRecord = ((StructMsgForGeneralShare)paramMessageRecord).mStructMsgItemLists;
        if ((paramMessageRecord != null) && (!paramMessageRecord.isEmpty()))
        {
          AbsStructMsgElement localAbsStructMsgElement;
          do
          {
            paramMessageRecord = paramMessageRecord.iterator();
            Object localObject;
            while (!((Iterator)localObject).hasNext())
            {
              do
              {
                do
                {
                  if (!paramMessageRecord.hasNext()) {
                    break;
                  }
                  localObject = (AbsStructMsgElement)paramMessageRecord.next();
                } while (!(localObject instanceof StructMsgItemLayout5));
                localObject = ((StructMsgItemLayout5)localObject).ax;
              } while ((localObject == null) || (((ArrayList)localObject).isEmpty()));
              localObject = ((ArrayList)localObject).iterator();
            }
            localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
          } while (!(localAbsStructMsgElement instanceof StructMsgItemVideo));
          return ((StructMsgItemVideo)localAbsStructMsgElement).bd;
        }
      }
    }
    return "";
  }
  
  public ChatMessage getLastAmsMessage(List<ChatMessage> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)paramList.get(i);
        Object localObject = getAbsStructMsgElement(localChatMessage);
        if (localObject != null)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("mGdtActionType ");
            localStringBuilder.append(((AbsStructMsgElement)localObject).t);
            QLog.i("EcshopMessageApi", 2, localStringBuilder.toString());
          }
          if ((((AbsStructMsgElement)localObject).t == 1) && ((((AbsStructMsgElement)localObject).as instanceof StructMsgForGeneralShare))) {
            return localChatMessage;
          }
        }
        else
        {
          localObject = getSourceAdFromArk(localChatMessage);
          if ((localObject != null) && (String.valueOf(1).equals(((JSONObject)localObject).optString("action_type")))) {
            return localChatMessage;
          }
        }
        i -= 1;
      }
    }
    return null;
  }
  
  public String getLastMsgQggExt(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return "";
    }
    AbsStructMsgElement localAbsStructMsgElement = getAbsStructMsgElement(paramMessageRecord);
    if (localAbsStructMsgElement != null)
    {
      if (localAbsStructMsgElement.ai == null) {
        return "";
      }
      return localAbsStructMsgElement.ai;
    }
    paramMessageRecord = getSourceAdFromArk(paramMessageRecord);
    if (paramMessageRecord == null) {
      return "";
    }
    return paramMessageRecord.optString("qgg_ext");
  }
  
  public String getLastMsgType(MessageRecord paramMessageRecord)
  {
    AbsStructMsgElement localAbsStructMsgElement = getAbsStructMsgElement(paramMessageRecord);
    if (localAbsStructMsgElement != null)
    {
      if (QLog.isColorLevel())
      {
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append("mGdtActionType ");
        paramMessageRecord.append(localAbsStructMsgElement.t);
        QLog.i("EcshopMessageApi", 2, paramMessageRecord.toString());
      }
      if (localAbsStructMsgElement.t == 0) {
        return "";
      }
      return String.valueOf(localAbsStructMsgElement.t);
    }
    paramMessageRecord = getSourceAdFromArk(paramMessageRecord);
    if (paramMessageRecord == null) {
      return "";
    }
    return paramMessageRecord.optString("action_type");
  }
  
  @NonNull
  public String getMessageImageUrl(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg;
      if ((paramMessageRecord instanceof StructMsgForGeneralShare)) {
        return ((StructMsgForGeneralShare)paramMessageRecord).mContentCover;
      }
    }
    return "";
  }
  
  @NonNull
  public String getMessageLandingUrl(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg;
      if ((paramMessageRecord instanceof StructMsgForGeneralShare))
      {
        paramMessageRecord = ((StructMsgForGeneralShare)paramMessageRecord).mStructMsgItemLists;
        if ((paramMessageRecord != null) && (!paramMessageRecord.isEmpty()))
        {
          paramMessageRecord = paramMessageRecord.iterator();
          AbsStructMsgElement localAbsStructMsgElement;
          do
          {
            if (!paramMessageRecord.hasNext()) {
              break;
            }
            localAbsStructMsgElement = (AbsStructMsgElement)paramMessageRecord.next();
          } while (!(localAbsStructMsgElement instanceof StructMsgItemLayout6));
          return ((StructMsgItemLayout6)localAbsStructMsgElement).d;
        }
      }
    }
    else if ((paramMessageRecord instanceof MessageForArkApp))
    {
      try
      {
        paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
        if (paramMessageRecord != null)
        {
          paramMessageRecord = paramMessageRecord.metaList;
          if (!TextUtils.isEmpty(paramMessageRecord))
          {
            paramMessageRecord = new JSONObject(paramMessageRecord).optJSONObject("floorData");
            if (paramMessageRecord != null)
            {
              paramMessageRecord = paramMessageRecord.optString("url");
              return paramMessageRecord;
            }
          }
        }
      }
      catch (Exception paramMessageRecord)
      {
        QLog.e("EcshopMessageApi", 1, paramMessageRecord, new Object[0]);
      }
    }
    return "";
  }
  
  @NonNull
  public String getMessageTitleText(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg;
      if ((paramMessageRecord instanceof StructMsgForGeneralShare)) {
        return ((StructMsgForGeneralShare)paramMessageRecord).mContentTitle;
      }
    }
    return "";
  }
  
  @Nullable
  public String getSourceAd(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
      if (paramMessageRecord != null) {
        return paramMessageRecord.mSourceAd;
      }
    }
    else if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if ((paramMessageRecord.structingMsg instanceof AbsShareMsg)) {
        return ((AbsShareMsg)paramMessageRecord.structingMsg).mAdSourceMenu;
      }
    }
    return "";
  }
  
  public JSONObject getSourceAdFromArk(MessageRecord paramMessageRecord)
  {
    boolean bool = paramMessageRecord instanceof MessageForArkApp;
    Object localObject2 = null;
    StringBuilder localStringBuilder = null;
    Object localObject1 = localObject2;
    MessageRecord localMessageRecord;
    if (bool)
    {
      MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramMessageRecord;
      paramMessageRecord = localMessageForArkApp.ark_app_message;
      if (paramMessageRecord != null) {
        paramMessageRecord = paramMessageRecord.mSourceAd;
      } else {
        paramMessageRecord = "";
      }
      localObject1 = localObject2;
      try
      {
        if (StringUtil.isEmpty(paramMessageRecord)) {
          return ???;
        }
        paramMessageRecord = new JSONObject(paramMessageRecord);
        try
        {
          paramMessageRecord.put("aio_desc_name", localMessageForArkApp.msg);
          return paramMessageRecord;
        }
        catch (Exception localException1) {}
        localStringBuilder = new StringBuilder();
      }
      catch (Exception localException2)
      {
        paramMessageRecord = localStringBuilder;
      }
      localStringBuilder.append("[getSourceAdFromArk] ");
      localStringBuilder.append(QLog.getStackTraceString(localException2));
      QLog.e("EcshopMessageApi", 1, localStringBuilder.toString());
      localMessageRecord = paramMessageRecord;
    }
    return localMessageRecord;
  }
  
  public String getStructMsgContentTitle(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = getAbsStructMsgElement(paramMessageRecord);
    if (paramMessageRecord != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mGdtActionType ");
        localStringBuilder.append(paramMessageRecord.t);
        QLog.i("EcshopMessageApi", 2, localStringBuilder.toString());
      }
      if ((paramMessageRecord.as instanceof StructMsgForGeneralShare)) {
        return ((StructMsgForGeneralShare)paramMessageRecord.as).mContentTitle;
      }
    }
    return null;
  }
  
  public String getStructMsgGdtAid(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg;
      if ((paramMessageRecord instanceof StructMsgForGeneralShare))
      {
        paramMessageRecord = (StructMsgForGeneralShare)paramMessageRecord;
        if ((paramMessageRecord.mStructMsgItemLists != null) && (paramMessageRecord.mStructMsgItemLists.size() > 0))
        {
          paramMessageRecord = (AbsStructMsgElement)paramMessageRecord.mStructMsgItemLists.get(0);
          if (paramMessageRecord != null) {
            return paramMessageRecord.v;
          }
        }
      }
    }
    return null;
  }
  
  public String getStructMsgReportClick(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = getAbsStructMsgElement(paramMessageRecord);
    if (paramMessageRecord != null) {
      return paramMessageRecord.ak;
    }
    return null;
  }
  
  public String getStuctMsgAdInfo(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if ((paramMessageRecord.structingMsg instanceof StructMsgForGeneralShare))
      {
        paramMessageRecord = ((StructMsgForGeneralShare)paramMessageRecord.structingMsg).getStructMsgItemLists();
        if (paramMessageRecord != null)
        {
          if (paramMessageRecord.isEmpty()) {
            return null;
          }
          return ((AbsStructMsgElement)paramMessageRecord.get(0)).aj;
        }
      }
    }
    return null;
  }
  
  public boolean isArkAppMessageValid(ChatMessage paramChatMessage)
  {
    boolean bool3 = paramChatMessage instanceof MessageForArkApp;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramChatMessage = (MessageForArkApp)paramChatMessage;
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramChatMessage.ark_app_message.appName))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramChatMessage.ark_app_message.appView)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isMessageForArkApp(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord instanceof MessageForArkApp;
  }
  
  public boolean isMessageForStructing(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord instanceof MessageForStructing;
  }
  
  public void preloadEcshopAd(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    ThreadManagerV2.excute(new EcshopMessageApiImpl.1(this, paramBaseQQAppInterface, paramString), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.temp.api.impl.EcshopMessageApiImpl
 * JD-Core Version:    0.7.0.1
 */