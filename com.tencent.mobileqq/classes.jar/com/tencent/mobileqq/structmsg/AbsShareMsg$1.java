package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.TroopConfessUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoR5Builder;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoR5BuilderFactory;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaAccessHelper;
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
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

class AbsShareMsg$1
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long = 0L;
  
  AbsShareMsg$1(AbsShareMsg paramAbsShareMsg) {}
  
  public void onClick(View paramView)
  {
    Object localObject4;
    Object localObject3;
    if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long >= 1000L)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      Object localObject1 = paramView.getTag();
      if ((localObject1 != null) && (AbsShareMsg.class.isInstance(localObject1)))
      {
        AbsShareMsg localAbsShareMsg = (AbsShareMsg)localObject1;
        Context localContext = paramView.getContext();
        if ((SplashActivity.class.isInstance(localContext)) || (ChatActivity.class.isInstance(localContext))) {
          if (localContext == null)
          {
            QLog.e("StructMsg", 1, "context is null, never do click, return");
          }
          else
          {
            Object localObject6 = (BaseActivity)localContext;
            localObject1 = ((BaseActivity)localObject6).getChatFragment();
            if (localObject1 == null)
            {
              QLog.e("StructMsg", 1, "context.getChatFragment is null, never do click, return");
            }
            else
            {
              Object localObject5 = ((ChatFragment)localObject1).a();
              if (localObject5 != null) {
                if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData.startsWith("mqqapi://qsubscribe")))
                {
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
                else
                {
                  Object localObject7 = new AbsShareMsg.SourceClickHandler(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, (QQAppInterface)localObject5, paramView);
                  localObject4 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAction;
                  Object localObject2 = localObject4;
                  if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAction.equals("web"))
                  {
                    localObject2 = localObject4;
                    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl.contains("webcard.mp.qq.com"))
                    {
                      localObject2 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
                      ((AbsShareMsg)localObject2).mSourceAction = "plugin";
                      ((AbsShareMsg)localObject2).mSource_A_ActionData = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=%s", new Object[] { ((AbsShareMsg)localObject2).source_puin });
                      localObject2 = "plugin";
                    }
                  }
                  if (QLog.isColorLevel())
                  {
                    localObject4 = new StringBuilder();
                    ((StringBuilder)localObject4).append("mSourceOnClickListener sourceAction = ");
                    ((StringBuilder)localObject4).append((String)localObject2);
                    QLog.d("StructMsg", 2, ((StringBuilder)localObject4).toString());
                  }
                  boolean bool = "app".equals(localObject2);
                  localObject4 = "setup";
                  if (bool)
                  {
                    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData != null) && ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData.startsWith("comic_plugin.apk")) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsg_A_ActionData.startsWith("comic_plugin.apk"))))
                    {
                      AbsShareMsg.access$000(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, localContext);
                      localObject2 = "";
                    }
                    for (;;)
                    {
                      break;
                      if (((AbsShareMsg.SourceClickHandler)localObject7).a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSource_A_ActionData))
                      {
                        if (localAbsShareMsg.mSourceAppid == -1L) {
                          localObject2 = "";
                        } else {
                          localObject2 = String.valueOf(localAbsShareMsg.mSourceAppid);
                        }
                        ReportController.b(null, "dc00898", "", "", "0X800A86D", "0X800A86D", 0, 0, (String)localObject2, "", "", "");
                        localObject2 = "run";
                      }
                      else if (((AbsShareMsg.SourceClickHandler)localObject7).a(((BaseActivity)localObject6).getActivity(), this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid, localAbsShareMsg.mSourceName, localAbsShareMsg.mSourceActionData, localAbsShareMsg.mSource_A_ActionData))
                      {
                        if (localAbsShareMsg.mSourceAppid == -1L) {
                          localObject2 = "";
                        } else {
                          localObject2 = String.valueOf(localAbsShareMsg.mSourceAppid);
                        }
                        ReportController.b(null, "dc00898", "", "", "0X800A86E", "0X800A86E", 0, 0, (String)localObject2, "", "", "");
                        localObject2 = localObject4;
                      }
                      else
                      {
                        ((AbsShareMsg.SourceClickHandler)localObject7).a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl);
                        localObject2 = localObject4;
                      }
                    }
                    ReportCenter.a().a(((QQAppInterface)localObject5).getAccount(), "", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid), "1000", "80", "0", false);
                  }
                  for (;;)
                  {
                    break;
                    if ("web".equals(localObject2))
                    {
                      localObject6 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl;
                      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 114)
                      {
                        localObject2 = ((MedalWallMng)((QQAppInterface)localObject5).getManager(QQManagerFactory.MEDAL_WALL_MNG)).a(true, ((QQAppInterface)localObject5).getCurrentAccountUin(), MedalWallMng.g);
                      }
                      else
                      {
                        localObject2 = localObject6;
                        if (localAbsShareMsg.uinType == 1) {
                          if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 116)
                          {
                            localObject2 = localObject6;
                            if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 123) {}
                          }
                          else
                          {
                            localObject6 = String.format("%s&gc=%s", new Object[] { localObject6, NearbyURLSafeUtil.a(localAbsShareMsg.uin) });
                            localObject2 = localObject6;
                            if (QLog.isColorLevel())
                            {
                              localObject2 = new StringBuilder();
                              ((StringBuilder)localObject2).append("GeneralClickHandler clickWebMsg source confess groupUin:");
                              ((StringBuilder)localObject2).append(localAbsShareMsg.uin);
                              QLog.i("StructMsg", 2, ((StringBuilder)localObject2).toString());
                              localObject2 = localObject6;
                            }
                          }
                        }
                      }
                      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals("mqqapi://readinjoy/open?src_type=internal&version=1&target=1")))
                      {
                        localObject6 = JumpParser.a((BaseQQAppInterface)localObject5, localContext, (String)localObject2);
                        if (localObject6 != null) {
                          ((JumpAction)localObject6).a();
                        } else {
                          localContext.startActivity(new Intent(localContext, JumpActivity.class).setData(Uri.parse((String)localObject2)));
                        }
                        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, (String)localObject2, "", "", "");
                        localObject2 = localObject4;
                      }
                      else if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((IViolaAccessHelper)QRoute.api(IViolaAccessHelper.class)).isViolaUrlFromWeb((String)localObject2)))
                      {
                        ((IViolaAccessHelper)QRoute.api(IViolaAccessHelper.class)).startViolaPage(localContext, null, ((IViolaAccessHelper)QRoute.api(IViolaAccessHelper.class)).getviolaurlfromweb((String)localObject2), null);
                        localObject2 = localObject4;
                      }
                      else
                      {
                        ((AbsShareMsg.SourceClickHandler)localObject7).a((String)localObject2);
                        localObject2 = localObject4;
                      }
                    }
                    else if ("plugin".equals(localObject2))
                    {
                      if ((localAbsShareMsg.uinType == 1) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 123))
                      {
                        localObject2 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
                        ((AbsShareMsg)localObject2).mSourceActionData = TroopConfessUtil.a(((AbsShareMsg)localObject2).mSourceActionData, localAbsShareMsg.uin);
                        bool = TroopConfessUtil.a((QQAppInterface)localObject5, localAbsShareMsg.uin, false);
                        localObject2 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl;
                        if ((bool) && (!TextUtils.isEmpty((CharSequence)localObject2)) && ((localContext instanceof BaseActivity)))
                        {
                          localObject6 = ((BaseActivity)localObject6).getChatFragment();
                          if (localObject6 != null)
                          {
                            localObject2 = ((ChatFragment)localObject6).a();
                            if ((localObject2 != null) && ((localObject2 instanceof TroopChatPie)))
                            {
                              localObject4 = "https://ti.qq.com/honest-say/group.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&gc=$GCODE$&src_type=share&from=appstore_aio&adtag=qq_to_qq".replace("$GCODE$", NearbyURLSafeUtil.a(localAbsShareMsg.uin));
                              if (QLog.isColorLevel())
                              {
                                localObject7 = new StringBuilder();
                                ((StringBuilder)localObject7).append("AbsShareMsg clickWebMsg confess groupUin:");
                                ((StringBuilder)localObject7).append(localAbsShareMsg.uin);
                                ((StringBuilder)localObject7).append(",paramUrl=");
                                ((StringBuilder)localObject7).append((String)localObject4);
                                QLog.i("StructMsg", 2, ((StringBuilder)localObject7).toString());
                              }
                              localObject6 = ((ChatFragment)localObject6).getBaseActivity().getIntent();
                              ((Intent)localObject6).putExtra("url", (String)localObject4);
                              ((Intent)localObject6).putExtra("confess_half_screen_web", true);
                              TroopConfessUtil.a((TroopChatPie)localObject2);
                            }
                          }
                        }
                        if (!bool) {
                          QQToast.a(BaseApplicationImpl.getContext(), TroopConfessUtil.a, 0).a();
                        }
                        if (QLog.isColorLevel())
                        {
                          localObject2 = new StringBuilder();
                          ((StringBuilder)localObject2).append("GeneralClickHandler clickWebMsg source confess url:");
                          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData);
                          QLog.i("StructMsg", 2, ((StringBuilder)localObject2).toString());
                        }
                      }
                      else
                      {
                        ((AbsShareMsg.SourceClickHandler)localObject7).c(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSource_A_ActionData);
                      }
                      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName.equals(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.readInjoy))
                      {
                        try
                        {
                          localObject2 = Uri.parse(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl).getQueryParameter("article_id");
                        }
                        catch (Exception localException2)
                        {
                          localException2.printStackTrace();
                          localObject3 = null;
                        }
                        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007756", "0X8007756", 0, 0, (String)localObject3, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl, "", "", false);
                        } else {
                          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007756", "0X8007756", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl, "", "", false);
                        }
                      }
                      localObject3 = "plugin";
                    }
                    else
                    {
                      ((AbsShareMsg.SourceClickHandler)localObject7).a((String)localObject3, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSource_A_ActionData);
                    }
                  }
                  Util.a((AppRuntime)localObject5, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.uin, "sourceclick", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID, (String)localObject3);
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID);
                  ((StringBuilder)localObject3).append("");
                  ReportController.b((AppRuntime)localObject5, "CliOper", "", "", "0X800567C", "0X800567C", 0, 0, ((StringBuilder)localObject3).toString(), "", "", "");
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID);
                  ((StringBuilder)localObject3).append("");
                  ReportController.b((AppRuntime)localObject5, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, ((StringBuilder)localObject3).toString(), "", "", "");
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID);
                  ((StringBuilder)localObject3).append("");
                  ReportController.b((AppRuntime)localObject5, "dc00898", "", "", "0X8007C39", "0X8007C39", 0, 0, ((StringBuilder)localObject3).toString(), "", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, "");
                  if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.adverSign == 1)
                  {
                    localObject3 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.uin;
                    localObject4 = new StringBuilder();
                    ((StringBuilder)localObject4).append("");
                    ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.msgId);
                    ReportController.b((AppRuntime)localObject5, "P_CliOper", "Pb_account_lifeservice", (String)localObject3, "0X800631F", "0X800631F", 0, 0, ((StringBuilder)localObject4).toString(), "", "", "");
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 114) {
                    ThreadManager.post(new AbsShareMsg.1.1(this, (QQAppInterface)localObject5), 0, null, false);
                  }
                  localObject3 = localObject5;
                  localObject4 = null;
                  localObject5 = localObject3;
                  if ((localAbsShareMsg instanceof StructMsgForGeneralShare))
                  {
                    StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)localAbsShareMsg;
                    localObject5 = localObject3;
                    if (localStructMsgForGeneralShare.mIsPAVideoStructMsg)
                    {
                      Iterator localIterator1 = localStructMsgForGeneralShare.iterator();
                      for (;;)
                      {
                        localObject5 = localObject3;
                        if (!localIterator1.hasNext()) {
                          break;
                        }
                        localObject5 = (AbsStructMsgElement)localIterator1.next();
                        localObject7 = localObject4;
                        localObject6 = localObject3;
                        if ((localObject5 instanceof StructMsgItemLayout5))
                        {
                          Iterator localIterator2 = ((StructMsgItemLayout5)localObject5).a.iterator();
                          localObject5 = localObject3;
                          for (;;)
                          {
                            localObject7 = localObject4;
                            localObject6 = localObject5;
                            if (!localIterator2.hasNext()) {
                              break;
                            }
                            localObject3 = (AbsStructMsgElement)localIterator2.next();
                            if ((localObject3 instanceof StructMsgItemVideo))
                            {
                              localObject7 = (StructMsgItemVideo)localObject3;
                              if (((StructMsgItemVideo)localObject7).a())
                              {
                                localObject6 = ((IVideoR5BuilderFactory)QRoute.api(IVideoR5BuilderFactory.class)).create((String)localObject4, localStructMsgForGeneralShare.source_puin, ((StructMsgItemVideo)localObject7).ae, ((StructMsgItemVideo)localObject7).aj).a("aio_app_id", Long.valueOf(localStructMsgForGeneralShare.mSourceAppid)).a();
                                if (localStructMsgForGeneralShare.uinType == 1008) {
                                  localObject3 = "1";
                                }
                                for (;;)
                                {
                                  break;
                                  if (localStructMsgForGeneralShare.uinType == 0) {
                                    localObject3 = "2";
                                  } else if (localStructMsgForGeneralShare.uinType == 1) {
                                    localObject3 = "3";
                                  } else if (localStructMsgForGeneralShare.uinType == 3000) {
                                    localObject3 = "4";
                                  } else {
                                    localObject3 = "";
                                  }
                                }
                                ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80065FE", "0X80065FE", 0, 0, (String)localObject3, Integer.toString(((IVideoReporter)QRoute.api(IVideoReporter.class)).getReportVideoType(((StructMsgItemVideo)localObject7).v, localStructMsgForGeneralShare.mSourceName)), "", (String)localObject6, false);
                                IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
                                String str = localStructMsgForGeneralShare.source_puin;
                                if (((StructMsgItemVideo)localObject7).aj != null) {
                                  localObject3 = ((StructMsgItemVideo)localObject7).aj;
                                } else {
                                  localObject3 = "0";
                                }
                                localIPublicAccountReportUtils.publicAccountReportClickEvent((AppInterface)localObject5, str, "0x8007410", "0x8007410", 0, 0, "1", "", (String)localObject3, (String)localObject6, false);
                              }
                            }
                          }
                        }
                        localObject4 = localObject7;
                        localObject3 = localObject6;
                      }
                    }
                  }
                  if ((localAbsShareMsg.mMsgServiceID == 81) && (localAbsShareMsg != null) && (!TextUtils.isEmpty(localAbsShareMsg.mMsg_A_ActionData)))
                  {
                    localObject4 = JumpParser.a((BaseQQAppInterface)localObject5, localContext, localAbsShareMsg.mMsg_A_ActionData);
                    if (localObject4 != null)
                    {
                      localObject3 = ((JumpAction)localObject4).b("usertype");
                      localObject4 = ((JumpAction)localObject4).b("unionid");
                      if ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject4))) {}
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    try
    {
      i = Integer.parseInt((String)localObject3);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i;
      label2438:
      break label2438;
    }
    i = 0;
    StoryReportor.a("share_uin_obj", "clk_tail", 0, i, new String[] { localObject4 });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsShareMsg.1
 * JD-Core Version:    0.7.0.1
 */