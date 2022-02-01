package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.TroopConfessUtil;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.comic.VipComicJumpActivity;
import cooperation.comic.VipComicReportUtils;
import java.util.ArrayList;
import java.util.Iterator;

class AbsShareMsg$1
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long = 0L;
  
  AbsShareMsg$1(AbsShareMsg paramAbsShareMsg) {}
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long < 1000L) {}
    AbsShareMsg localAbsShareMsg;
    Context localContext;
    QQAppInterface localQQAppInterface;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      Object localObject1 = paramView.getTag();
      if ((localObject1 != null) && (AbsShareMsg.class.isInstance(localObject1)))
      {
        localAbsShareMsg = (AbsShareMsg)localObject1;
        localContext = paramView.getContext();
        if ((SplashActivity.class.isInstance(localContext)) || (ChatActivity.class.isInstance(localContext))) {
          if (localContext == null)
          {
            QLog.e("StructMsg", 1, "context is null, never do click, return");
          }
          else
          {
            localObject1 = ((FragmentActivity)localContext).getChatFragment();
            if (localObject1 == null)
            {
              QLog.e("StructMsg", 1, "context.getChatFragment is null, never do click, return");
            }
            else
            {
              localQQAppInterface = ((ChatFragment)localObject1).a();
              if (localQQAppInterface != null)
              {
                if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData == null) || (!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData.startsWith("mqqapi://qsubscribe"))) {
                  break;
                }
                QLog.i("StructMsg", 2, "scheme jump to subscribe hybird");
                try
                {
                  localObject1 = new Intent(localContext, JumpActivity.class);
                  ((Intent)localObject1).setData(Uri.parse(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData));
                  ((Intent)localObject1).putExtra("from", "from_aio");
                  localContext.startActivity((Intent)localObject1);
                }
                catch (Exception localException1)
                {
                  localException1.printStackTrace();
                }
              }
            }
          }
        }
      }
    }
    Object localObject5 = new AbsShareMsg.SourceClickHandler(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, localQQAppInterface, paramView);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAction;
    Object localObject2 = localObject3;
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAction.equals("web"))
    {
      localObject2 = localObject3;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl.contains("webcard.mp.qq.com"))
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
        localObject2 = "plugin";
        ((AbsShareMsg)localObject3).mSourceAction = "plugin";
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSource_A_ActionData = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.source_puin });
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "mSourceOnClickListener sourceAction = " + (String)localObject2);
    }
    if ("app".equals(localObject2)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData.startsWith("comic_plugin.apk")))
      {
        localObject2 = new Intent(localContext, VipComicJumpActivity.class);
        ((Intent)localObject2).putExtra("options", "{\"from\":28}");
        localContext.startActivity((Intent)localObject2);
        localObject3 = AIOGallerySceneWithBusiness.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData);
        if ((localObject3 != null) && (localObject3.length >= 8))
        {
          if (!localObject3[7].equals("link")) {
            break label1154;
          }
          localObject2 = localObject3[4];
        }
      }
    }
    for (;;)
    {
      VipComicReportUtils.a(null, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.uin, localContext, "3009", "2", "40059", localObject3[0], new String[] { localObject3[2], localObject3[4], localObject2 });
      localObject2 = "";
      label527:
      ReportCenter.a().a(localQQAppInterface.getAccount(), "", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid), "1000", "80", "0", false);
      label557:
      Util.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.uin, "sourceclick", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID, (String)localObject2);
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X800567C", "0X800567C", 0, 0, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID + "", "", "", "");
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID + "", "", "", "");
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8007C39", "0X8007C39", 0, 0, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID + "", "", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, "");
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.adverSign == 1) {
        ReportController.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.uin, "0X800631F", "0X800631F", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.msgId, "", "", "");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 114) {
        ThreadManager.post(new AbsShareMsg.1.1(this, localQQAppInterface), 0, null, false);
      }
      label919:
      label1466:
      label1507:
      label2155:
      if (((localAbsShareMsg instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)localAbsShareMsg).mIsPAVideoStructMsg))
      {
        localObject3 = (StructMsgForGeneralShare)localAbsShareMsg;
        localObject5 = ((StructMsgForGeneralShare)localObject3).iterator();
        label876:
        while (((Iterator)localObject5).hasNext())
        {
          localObject2 = (AbsStructMsgElement)((Iterator)localObject5).next();
          if ((localObject2 instanceof StructMsgItemLayout5))
          {
            Iterator localIterator = ((StructMsgItemLayout5)localObject2).a.iterator();
            StructMsgItemVideo localStructMsgItemVideo;
            String str2;
            IPublicAccountReportUtils localIPublicAccountReportUtils;
            String str3;
            while (localIterator.hasNext())
            {
              localObject2 = (AbsStructMsgElement)localIterator.next();
              if ((localObject2 instanceof StructMsgItemVideo))
              {
                localStructMsgItemVideo = (StructMsgItemVideo)localObject2;
                if (localStructMsgItemVideo.a())
                {
                  localObject2 = new VideoR5.Builder(null, ((StructMsgForGeneralShare)localObject3).source_puin, localStructMsgItemVideo.ae, localStructMsgItemVideo.aj);
                  ((VideoR5.Builder)localObject2).a("aio_app_id", Long.valueOf(((StructMsgForGeneralShare)localObject3).mSourceAppid));
                  str2 = ((VideoR5.Builder)localObject2).a().a();
                  localObject2 = "";
                  if (((StructMsgForGeneralShare)localObject3).uinType != 1008) {
                    break label2229;
                  }
                  localObject2 = "1";
                  ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80065FE", "0X80065FE", 0, 0, (String)localObject2, Integer.toString(VideoReporter.a(localStructMsgItemVideo.v, ((StructMsgForGeneralShare)localObject3).mSourceName)), "", str2, false);
                  localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
                  str3 = ((StructMsgForGeneralShare)localObject3).source_puin;
                  if (localStructMsgItemVideo.aj == null) {
                    break label2280;
                  }
                }
              }
            }
            for (localObject2 = localStructMsgItemVideo.aj;; localObject2 = "0")
            {
              localIPublicAccountReportUtils.publicAccountReportClickEvent(localQQAppInterface, str3, "0x8007410", "0x8007410", 0, 0, "1", "", (String)localObject2, str2, false);
              break label919;
              break label876;
              if ((!localObject3[7].equals("scrawl_link")) || (localObject3.length < 9)) {
                break label2406;
              }
              localObject2 = localObject3[8];
              break;
              if (((AbsShareMsg.SourceClickHandler)localObject5).a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSource_A_ActionData))
              {
                localObject3 = "run";
                if (localAbsShareMsg.mSourceAppid == -1L) {}
                for (localObject2 = "";; localObject2 = String.valueOf(localAbsShareMsg.mSourceAppid))
                {
                  ReportController.b(null, "dc00898", "", "", "0X800A86D", "0X800A86D", 0, 0, (String)localObject2, "", "", "");
                  localObject2 = localObject3;
                  break;
                }
              }
              if (((AbsShareMsg.SourceClickHandler)localObject5).a(((FragmentActivity)localContext).getActivity(), this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid, localAbsShareMsg.mSourceName, localAbsShareMsg.mSourceActionData, localAbsShareMsg.mSource_A_ActionData))
              {
                localObject3 = "setup";
                if (localAbsShareMsg.mSourceAppid == -1L) {}
                for (localObject2 = "";; localObject2 = String.valueOf(localAbsShareMsg.mSourceAppid))
                {
                  ReportController.b(null, "dc00898", "", "", "0X800A86E", "0X800A86E", 0, 0, (String)localObject2, "", "", "");
                  localObject2 = localObject3;
                  break;
                }
              }
              ((AbsShareMsg.SourceClickHandler)localObject5).a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl);
              localObject2 = "setup";
              break label527;
              if ("web".equals(localObject2))
              {
                localObject3 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl;
                if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 114)
                {
                  localObject2 = ((MedalWallMng)localQQAppInterface.getManager(QQManagerFactory.MEDAL_WALL_MNG)).a(true, localQQAppInterface.getCurrentAccountUin(), MedalWallMng.g);
                  if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals("mqqapi://readinjoy/open?src_type=internal&version=1&target=1"))) {
                    break label1687;
                  }
                  localObject3 = JumpParser.a(localQQAppInterface, localContext, (String)localObject2);
                  if (localObject3 == null) {
                    break label1660;
                  }
                  ((JumpAction)localObject3).a();
                  ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, (String)localObject2, "", "", "");
                }
                for (;;)
                {
                  localObject2 = "setup";
                  break;
                  localObject2 = localObject3;
                  if (localAbsShareMsg.uinType != 1) {
                    break label1466;
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 116)
                  {
                    localObject2 = localObject3;
                    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 123) {
                      break label1466;
                    }
                  }
                  localObject3 = String.format("%s&gc=%s", new Object[] { localObject3, NearbyURLSafeUtil.a(localAbsShareMsg.uin) });
                  localObject2 = localObject3;
                  if (!QLog.isColorLevel()) {
                    break label1466;
                  }
                  QLog.i("StructMsg", 2, "GeneralClickHandler clickWebMsg source confess groupUin:" + localAbsShareMsg.uin);
                  localObject2 = localObject3;
                  break label1466;
                  label1660:
                  localContext.startActivity(new Intent(localContext, JumpActivity.class).setData(Uri.parse((String)localObject2)));
                  break label1507;
                  if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (ViolaAccessHelper.b((String)localObject2))) {
                    ViolaAccessHelper.a(localContext, null, ViolaAccessHelper.c((String)localObject2), null);
                  } else {
                    ((AbsShareMsg.SourceClickHandler)localObject5).a((String)localObject2);
                  }
                }
              }
              if ("plugin".equals(localObject2))
              {
                if ((localAbsShareMsg.uinType == 1) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 123))
                {
                  this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData = TroopConfessUtil.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData, localAbsShareMsg.uin);
                  boolean bool = TroopConfessUtil.a(localQQAppInterface, localAbsShareMsg.uin, false);
                  localObject2 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl;
                  if ((bool) && (!TextUtils.isEmpty((CharSequence)localObject2)) && ((localContext instanceof FragmentActivity)))
                  {
                    localObject5 = ((FragmentActivity)localContext).getChatFragment();
                    if (localObject5 != null)
                    {
                      localObject2 = ((ChatFragment)localObject5).a();
                      if ((localObject2 != null) && ((localObject2 instanceof TroopChatPie)))
                      {
                        localObject3 = "https://ti.qq.com/honest-say/group.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&gc=$GCODE$&src_type=share&from=appstore_aio&adtag=qq_to_qq".replace("$GCODE$", NearbyURLSafeUtil.a(localAbsShareMsg.uin));
                        if (QLog.isColorLevel()) {
                          QLog.i("StructMsg", 2, "AbsShareMsg clickWebMsg confess groupUin:" + localAbsShareMsg.uin + ",paramUrl=" + (String)localObject3);
                        }
                        localObject5 = ((ChatFragment)localObject5).getActivity().getIntent();
                        ((Intent)localObject5).putExtra("url", (String)localObject3);
                        ((Intent)localObject5).putExtra("confess_half_screen_web", true);
                        TroopConfessUtil.a((TroopChatPie)localObject2);
                      }
                    }
                  }
                  if (!bool) {
                    QQToast.a(BaseApplicationImpl.getContext(), TroopConfessUtil.a, 0).a();
                  }
                  if (QLog.isColorLevel()) {
                    QLog.i("StructMsg", 2, "GeneralClickHandler clickWebMsg source confess url:" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData);
                  }
                }
                for (;;)
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName.equals(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.readInjoy)) {
                    localObject2 = null;
                  }
                  try
                  {
                    localObject3 = Uri.parse(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl).getQueryParameter("article_id");
                    localObject2 = localObject3;
                  }
                  catch (Exception localException2)
                  {
                    for (;;)
                    {
                      localException2.printStackTrace();
                      continue;
                      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007756", "0X8007756", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl, "", "", false);
                    }
                  }
                  if (TextUtils.isEmpty((CharSequence)localObject2)) {
                    break label2155;
                  }
                  ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007756", "0X8007756", 0, 0, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl, "", "", false);
                  localObject2 = "plugin";
                  break;
                  ((AbsShareMsg.SourceClickHandler)localObject5).c(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSource_A_ActionData);
                }
              }
              ((AbsShareMsg.SourceClickHandler)localObject5).a((String)localObject2, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSource_A_ActionData);
              break label557;
              if (localException2.uinType == 0)
              {
                localObject2 = "2";
                break label1036;
              }
              if (localException2.uinType == 1)
              {
                localObject2 = "3";
                break label1036;
              }
              if (localException2.uinType != 3000) {
                break label1036;
              }
              localObject2 = "4";
              break label1036;
            }
          }
        }
      }
      label1036:
      label1687:
      label2229:
      label2280:
      if ((localAbsShareMsg.mMsgServiceID != 81) || (localAbsShareMsg == null) || (TextUtils.isEmpty(localAbsShareMsg.mMsg_A_ActionData))) {
        break;
      }
      label1154:
      Object localObject4 = JumpParser.a(localQQAppInterface, localContext, localAbsShareMsg.mMsg_A_ActionData);
      if (localObject4 == null) {
        break;
      }
      localObject2 = ((JumpAction)localObject4).b("usertype");
      localObject4 = ((JumpAction)localObject4).b("unionid");
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject4))) {
        break;
      }
      int i = 0;
      try
      {
        int j = Integer.parseInt((String)localObject2);
        i = j;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label2378:
        break label2378;
      }
      StoryReportor.a("share_uin_obj", "clk_tail", 0, i, new String[] { localObject4 });
      break;
      label2406:
      String str1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsShareMsg.1
 * JD-Core Version:    0.7.0.1
 */