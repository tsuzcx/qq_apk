package com.tencent.mobileqq.troop.api.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.avgame.util.AvGameEntranceUtils;
import com.tencent.biz.common.report.BnrReport;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.LiangGroupHelper;
import com.tencent.mobileqq.app.handler.GetOpenID;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatManager;
import com.tencent.mobileqq.app.hiddenchat.TroopStatusUtil;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.TroopFansEntryConfig;
import com.tencent.mobileqq.qqexpand.utils.IExpandQuestionUtils;
import com.tencent.mobileqq.qqexpand.utils.ProfileGuideDialogUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.association.TroopAssociationsEntryConfig;
import com.tencent.mobileqq.troop.associations.TroopAssociationsUtil;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.fragment.TroopRemarkEditFragment;
import com.tencent.mobileqq.troop.plugin.TroopPluginCallback;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutFragment;
import com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardConfig;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingApi;
import com.tencent.mobileqq.troop.utils.FansTroopUtils;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TroopInfoActivityConstant;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheetHelper;
import cooperation.plugin.PluginInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopManageCmd;
import cooperation.troop.TroopManageProxyActivity;
import cooperation.troop.TroopPluginManager;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@QAPI(process={""})
public class ChatSettingForTroopApiImpl
  implements IChatSettingForTroopApi
{
  protected TroopShareUtility mTroopShareUtility;
  
  public void OpenTroopManagePluginActivity(AppRuntime paramAppRuntime, Activity paramActivity, Intent paramIntent, int paramInt)
  {
    Dialog localDialog = TroopBaseProxyActivity.a(paramActivity);
    TroopManageCmd localTroopManageCmd = new TroopManageCmd((QQAppInterface)paramAppRuntime);
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler != null) {
      localPluginCommunicationHandler.register(localTroopManageCmd);
    }
    TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.j, TroopManageProxyActivity.class, paramActivity, paramIntent, localDialog, "com.tencent.mobileqq.activity.TroopManageActivity", paramAppRuntime.getCurrentAccountUin(), paramInt);
  }
  
  public void StoryReportor(Activity paramActivity)
  {
    int i = paramActivity.getIntent().getIntExtra("extra_share_group_from", 0);
    if (i != 0) {
      StoryReportor.a("story_grp", "clk_msg", i, 0, new String[0]);
    }
  }
  
  public void StoryReportorReportEvent(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    StoryReportor.a(paramString1, paramString2, paramInt1, paramInt2, paramVarArgs);
  }
  
  public void TroopNameEntry(Object paramObject, Activity paramActivity, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (!(paramObject instanceof TroopInfoData)) {
      return;
    }
    Object localObject2 = (TroopInfoData)paramObject;
    if (localObject2 != null)
    {
      boolean bool1;
      if ((!((TroopInfoData)localObject2).isOwnerOrAdim()) && (((TroopInfoData)localObject2).allowMemberModifTroopName != 1)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      if ((bool1) && (QVipBigTroopExpiredProcessor.c().mIsEnable) && (((TroopInfoData)localObject2).mIsFreezed == 1) && (((TroopInfoData)localObject2).isOwnerOrAdim()))
      {
        paramBoolean = TroopManager.LiangGroupHelper.c(((TroopInfoData)localObject2).groupFreezeReason);
        if (((TroopInfoData)localObject2).bOwner)
        {
          localObject1 = ((TroopInfoData)localObject2).troopUin;
          if (paramBoolean) {
            paramInt1 = 15;
          } else {
            paramInt1 = 8;
          }
          str = VipUtils.a(0, paramInt1).toString();
          localObject2 = HardCodeUtil.a(2131701933);
          localObject3 = new ChatSettingForTroopApiImpl.1(this, paramBoolean);
          if (paramBoolean) {
            paramObject = "0X800A57F";
          } else {
            paramObject = "0X8009E38";
          }
          VipUtils.a(paramActivity, (String)localObject1, str, (String)localObject2, (DialogInterface.OnClickListener)localObject3, paramObject, 1, paramBoolean);
        }
        else
        {
          VipUtils.a(paramActivity, paramBoolean);
        }
        ReportController.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 1, 0, "", "", "", "");
        return;
      }
      boolean bool2 = ((TroopInfoData)localObject2).hasSetNewTroopName;
      String str = "";
      if (bool2) {
        paramObject = ((TroopInfoData)localObject2).newTroopName;
      } else {
        paramObject = "";
      }
      Object localObject1 = paramObject;
      if (paramObject == null) {
        localObject1 = "";
      }
      int i;
      if ((!paramBoolean) && (!((TroopInfoData)localObject2).isNewTroop)) {
        i = 1;
      } else {
        i = 0;
      }
      Object localObject3 = new Intent();
      ((Intent)localObject3).putExtra("edit_type", 1);
      ((Intent)localObject3).putExtra("edit_mode", 2);
      int j;
      if (bool1) {
        j = 2131701952;
      } else {
        j = 2131701951;
      }
      ((Intent)localObject3).putExtra("title", HardCodeUtil.a(j));
      ((Intent)localObject3).putExtra("default_text", (String)localObject1);
      ((Intent)localObject3).putExtra("max_num", paramInt1);
      ((Intent)localObject3).putExtra("canPostNull", false);
      if (bool1) {
        paramObject = HardCodeUtil.a(2131701937);
      } else {
        paramObject = "";
      }
      ((Intent)localObject3).putExtra("right_btn", paramObject);
      ((Intent)localObject3).putExtra("edit_mode", bool1);
      paramObject = str;
      if (i != 0) {
        paramObject = ((TroopInfoData)localObject2).troopUin;
      }
      ((Intent)localObject3).putExtra("troopUin", paramObject);
      RouteUtils.a(paramActivity, (Intent)localObject3, "/base/activity/editInfoActivity", paramInt2);
      return;
    }
  }
  
  public Object actionSheetHelperCreateDialog(Context paramContext, View paramView)
  {
    return ActionSheetHelper.a(paramContext, paramView);
  }
  
  public void addRecentTroopItemIntoRecentMsgList(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = (TroopManager)paramAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramAppRuntime != null) {
      paramAppRuntime.e(paramAppRuntime.b(paramString));
    }
  }
  
  public boolean appOnClick_Special(AppRuntime paramAppRuntime, Activity paramActivity, long paramLong, Object paramObject1, Object paramObject2)
  {
    paramActivity = (QBaseActivity)paramActivity;
    paramObject1 = (TroopInfo)paramObject1;
    paramObject2 = (TroopInfoData)paramObject2;
    if (paramObject1 == null) {
      return false;
    }
    if (paramLong == 101761547L)
    {
      ListenTogetherUtils.b((QQAppInterface)paramAppRuntime, paramActivity.getApplicationContext(), 1, paramObject2.troopUin, 0);
      return true;
    }
    if ((paramLong == 101793773L) && ((paramAppRuntime instanceof QQAppInterface)))
    {
      TroopAppShortcutUtils.a((QQAppInterface)paramAppRuntime, paramActivity, paramObject1, paramObject2.troopUin);
      return true;
    }
    if ((paramLong == 101817424L) && ((paramAppRuntime instanceof QQAppInterface)))
    {
      TroopAppShortcutUtils.b((QQAppInterface)paramAppRuntime, paramActivity, paramObject1, paramObject2.troopUin);
      return true;
    }
    if (paramLong == 101847770L)
    {
      paramAppRuntime = new Intent();
      paramAppRuntime.putExtra("troop_uin", paramObject2.troopUin);
      paramAppRuntime.putExtra("param_from", 19);
      paramAppRuntime.putExtra("TROOP_INFO_MEMBER_NUM", paramObject1.wMemberNum);
      RouteUtils.a(paramActivity, paramAppRuntime, "/troop/memberlist/TroopMemberList");
      return true;
    }
    if (paramLong == 101872203L)
    {
      if (AvGameEntranceUtils.a(paramActivity, paramObject2.troopUin)) {
        return true;
      }
      paramAppRuntime = (IAvGameManager)paramAppRuntime.getRuntimeService(IAvGameManager.class, "");
      if (paramAppRuntime != null) {
        paramAppRuntime.createAvGameRoom(paramActivity, 3, paramObject2.troopUin, 0);
      }
      int i;
      if ((paramAppRuntime != null) && (paramAppRuntime.isAvGameRoomExist())) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800B4E3", "0X800B4E3", i, 0, "", "", paramObject1.troopuin, "");
      return true;
    }
    return false;
  }
  
  public void bnrReport(AppInterface paramAppInterface, int paramInt)
  {
    BnrReport.a(paramAppInterface, paramInt);
  }
  
  public boolean checkPlugin(AppRuntime paramAppRuntime, Object paramObject)
  {
    paramAppRuntime = (TroopPluginManager)paramAppRuntime.getManager(QQManagerFactory.TROOP_PLUGIN_MANAGER);
    if (paramAppRuntime != null) {
      return paramAppRuntime.a("troop_manage_plugin.apk", (TroopPluginCallback)paramObject);
    }
    return false;
  }
  
  public void clearChatRecordTaskRun(AppRuntime paramAppRuntime, String paramString1, String paramString2, Handler paramHandler, int paramInt)
  {
    paramAppRuntime = (QQAppInterface)paramAppRuntime;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getMessageHistoryCont(paramAppRuntime, paramString1, 1, localStringBuilder);
    List localList = paramAppRuntime.getMessageFacade().a(paramString1, 1);
    long l1;
    if ((localList != null) && (!localList.isEmpty())) {
      l1 = ((MessageRecord)localList.get(localList.size() - 1)).shmsgseq;
    } else {
      l1 = 0L;
    }
    if (i > 0) {
      try
      {
        long l2 = Long.parseLong(localStringBuilder.toString());
        l1 = Math.max(l2, l1);
        if (l1 > 0L) {
          paramAppRuntime.getMsgCache().a(paramString1, 1, l1);
        }
        if (((TroopManager)paramAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramString1))
        {
          FriendsStatusUtil.a(paramAppRuntime, paramString1, 1);
          paramAppRuntime.getMessageFacade().a(paramString1, 1, true, false);
        }
        else
        {
          paramAppRuntime.getMessageFacade().a(paramString1, 1);
          TroopAssistantManager.a().b(paramString1, paramAppRuntime);
        }
        paramAppRuntime.getMessageFacade().c(paramString1, 1);
        ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopAllTask(paramAppRuntime, "chat_history_confirm_del_msg");
        paramAppRuntime = paramAppRuntime.getHandler(Conversation.class);
        paramString2 = paramAppRuntime.obtainMessage(1017);
        paramString2.obj = paramString1;
        paramString2.arg1 = 1;
        paramAppRuntime.sendMessage(paramString2);
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e(paramString2, 1, "ClearChatRecordTask parse seq fail.", paramAppRuntime);
        paramHandler.sendEmptyMessage(paramInt);
        return;
      }
    } else if (QLog.isColorLevel()) {
      QLog.d(paramString2, 2, "msg history already clear!");
    }
    paramHandler.sendEmptyMessage(paramInt);
  }
  
  public void clearTroopAssistTipTime(AppRuntime paramAppRuntime, String paramString)
  {
    TroopAssistantManager.a().c((QQAppInterface)paramAppRuntime, paramString);
  }
  
  public String configTroopStoryProfileFromAIO(Intent paramIntent, String paramString1, String paramString2)
  {
    return TroopStoryUtil.a(paramIntent, paramString1, paramString2);
  }
  
  public Dialog createQuestionDialog(Context paramContext)
  {
    return ProfileGuideDialogUtils.a(paramContext);
  }
  
  public void deleteTroop(AppRuntime paramAppRuntime, String paramString)
  {
    ((TroopManager)paramAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
  }
  
  public void doReportTroop(Object paramObject1, Object paramObject2, AppRuntime paramAppRuntime)
  {
    if (((paramObject1 instanceof QBaseActivity)) && ((paramObject2 instanceof TroopInfoData)) && ((paramAppRuntime instanceof QQAppInterface))) {
      TroopUtils.a((QBaseActivity)paramObject1, (TroopInfoData)paramObject2, (QQAppInterface)paramAppRuntime);
    }
  }
  
  public Intent getChatActivityIntent(Activity paramActivity)
  {
    return new Intent(paramActivity, ChatActivity.class);
  }
  
  public Intent getJumpActionIntent(Activity paramActivity)
  {
    return new Intent(paramActivity, JumpActivity.class);
  }
  
  public void getOpenID(AppInterface paramAppInterface, String paramString)
  {
    GetOpenID.a(((QQAppInterface)paramAppInterface).getMsgHandler(), paramString);
  }
  
  public String getQzoneHelperQunPhotoDataHasChange()
  {
    return "ken_qun_photo_data_has_changed";
  }
  
  public SpannableString getSpannableStringFromColorNickText(CharSequence paramCharSequence, int paramInt)
  {
    return new ColorNickText(paramCharSequence, paramInt).a();
  }
  
  public Intent getSplashActivityIntent(Activity paramActivity)
  {
    return new Intent(paramActivity, SplashActivity.class);
  }
  
  public Object getStrOpenIDFromCacheAndDB(AppInterface paramAppInterface, String paramString)
  {
    return ((QQAppInterface)paramAppInterface).getMsgHandler().a(paramString);
  }
  
  public int getTroopMask(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppRuntime).getTroopMask(paramString);
    }
    return 1;
  }
  
  public String getTroopMemberName(AppRuntime paramAppRuntime, String paramString1, String paramString2, boolean paramBoolean)
  {
    return ContactUtils.a((QQAppInterface)paramAppRuntime, paramString1, paramString2, paramBoolean);
  }
  
  public Bundle getTroopProfileExtra(String paramString, int paramInt)
  {
    return TroopInfoUIUtil.a(paramString, paramInt);
  }
  
  public Intent getTroopTagViewIntent(Activity paramActivity)
  {
    return new Intent(paramActivity, TroopTagViewActivity.class);
  }
  
  public String getUrlFromIndividuationUrlHelper_entryEffect()
  {
    return IndividuationUrlHelper.a("troopEnterEffect");
  }
  
  public String getUrlFromIndividuationUrlHelper_keyWord()
  {
    return IndividuationUrlHelper.a("groupkeywords");
  }
  
  public void gotoSettingOrShare(Activity paramActivity) {}
  
  public void handleAppClick1101236949(Object paramObject, Activity paramActivity)
  {
    paramObject = (TroopInfoData)paramObject;
    if ((QVipBigTroopExpiredProcessor.c().mIsEnable) && (paramObject.mIsFreezed == 1) && (paramObject.isOwnerOrAdim()))
    {
      boolean bool = TroopManager.LiangGroupHelper.c(paramObject.groupFreezeReason);
      if (paramObject.bOwner)
      {
        String str1 = paramObject.troopUin;
        int i;
        if (bool) {
          i = 15;
        } else {
          i = 8;
        }
        String str2 = VipUtils.a(0, i).toString();
        String str3 = HardCodeUtil.a(2131701953);
        ChatSettingForTroopApiImpl.5 local5 = new ChatSettingForTroopApiImpl.5(this, bool);
        if (bool) {
          paramObject = "0X800A57F";
        } else {
          paramObject = "0X8009E38";
        }
        if (bool) {
          i = 1;
        } else {
          i = 3;
        }
        VipUtils.a(paramActivity, str1, str2, str3, local5, paramObject, i, bool);
      }
      else
      {
        VipUtils.a(paramActivity, bool);
      }
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 3, 0, "", "", "", "");
      return;
    }
  }
  
  public void handleAppShareAction(AppRuntime paramAppRuntime, Activity paramActivity, Intent paramIntent)
  {
    Intent localIntent = BaseAIOUtils.a(new Intent(paramActivity, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    paramIntent = ForwardUtils.a(localIntent);
    ForwardUtils.a((QQAppInterface)paramAppRuntime, paramActivity, paramIntent, localIntent);
  }
  
  public void handleTroopAppManageShortcutBar(AppRuntime paramAppRuntime, String paramString, Object paramObject)
  {
    long l = Long.parseLong(paramString);
    QQAppInterface localQQAppInterface = (QQAppInterface)paramAppRuntime;
    paramObject = (QBaseActivity)paramObject;
    TroopAppShortcutUtils.a(2, l, localQQAppInterface, paramObject.getApplicationContext(), paramObject);
    l = Long.parseLong(paramString);
    paramAppRuntime = ((TroopShortcutBarManager)paramAppRuntime.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(Long.valueOf(l));
    if (paramAppRuntime != null) {
      paramAppRuntime.c(0);
    }
  }
  
  public void hiddenChatShowGuideDialog(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    HiddenChatManager.a((QQAppInterface)paramAppRuntime).a(paramActivity);
  }
  
  public void hideJuhua(Object paramObject, String paramString)
  {
    try
    {
      paramObject = (QQProgressDialog)paramObject;
      if ((paramObject != null) && (paramObject.isShowing()))
      {
        paramObject.dismiss();
        return;
      }
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.i(paramString, 2, paramObject.toString());
      }
    }
  }
  
  public void initKeyword(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean, Object paramObject)
  {
    new QueryTask(new ChatSettingForTroopApiImpl.6(this, paramAppRuntime, paramString), new ChatSettingForTroopApiImpl.7(this, paramBoolean, paramObject, paramString)).a(null);
  }
  
  public void initTroopShareUtility(Activity paramActivity, Object paramObject, AppRuntime paramAppRuntime)
  {
    this.mTroopShareUtility = TroopUtils.a((QBaseActivity)paramActivity, (TroopInfoData)paramObject, (QQAppInterface)paramAppRuntime);
  }
  
  public void inviteMember(Activity paramActivity, String paramString, boolean paramBoolean, ArrayList<String> paramArrayList, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_groupcode", paramString);
    localIntent.putExtra("param_type", 1);
    localIntent.putExtra("param_subtype", 1);
    localIntent.putExtra("param_is_troop_admin", paramBoolean);
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131692486));
    localIntent.putExtra("param_uins_selected_default", paramArrayList);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_title", paramActivity.getString(2131696061));
    localIntent.putExtra("param_max", 100);
    if (!paramBoolean) {
      localIntent.putExtra("filer_robot", true);
    }
    localIntent.putExtra("param_entrance", 38);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(paramActivity, localIntent, paramInt);
  }
  
  public boolean isGrayTroopForTroopAssociations(String paramString, int paramInt, long paramLong)
  {
    TroopAssociationsEntryConfig localTroopAssociationsEntryConfig = (TroopAssociationsEntryConfig)QConfigManager.a().a(686);
    return (localTroopAssociationsEntryConfig != null) && (localTroopAssociationsEntryConfig.a(paramString, paramInt, paramLong));
  }
  
  public boolean isGrayTroopForTroopGameCard(String paramString)
  {
    TroopGameCardConfig localTroopGameCardConfig = (TroopGameCardConfig)QConfigManager.a().a(695);
    return (localTroopGameCardConfig != null) && (localTroopGameCardConfig.a(paramString));
  }
  
  public boolean isGroupEntranceSwitchOn()
  {
    TroopFansEntryConfig localTroopFansEntryConfig = (TroopFansEntryConfig)QConfigManager.a().a(701);
    if (localTroopFansEntryConfig != null) {
      return localTroopFansEntryConfig.isGroupEntranceSwitchOn();
    }
    return false;
  }
  
  public void jump2PayJoinTroopWeb(Context paramContext, String paramString1, String paramString2)
  {
    TroopNotificationUtils.a(paramContext, paramString1, paramString2);
  }
  
  public void jumpRobotPage(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    TroopUtils.a(paramActivity, paramString, paramBoolean);
  }
  
  public boolean keyWordIsEnable()
  {
    return TroopKeywordManager.a();
  }
  
  public void launcherTroopShortcutFragment(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("troop_uin", paramString);
    new SessionInfo();
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_JavaLangString = paramString;
    localSessionInfo.jdField_a_of_type_Int = 1;
    localSessionInfo.b = paramString;
    localIntent.putExtra("session_info", localSessionInfo);
    localIntent.putExtra("fling_action_key", 2);
    localIntent.putExtra("fling_code_key", hashCode());
    localIntent.putExtra("reportfrom", 2);
    PublicFragmentActivity.Launcher.a(paramActivity, localIntent, PublicFragmentActivity.class, TroopAppShortcutFragment.class);
  }
  
  public void messageNotificationSettingFragmentLaunch(Activity paramActivity, Intent paramIntent)
  {
    MessageNotificationSettingFragment.a(paramActivity, paramIntent);
  }
  
  public boolean needAnswerQuestion(String paramString)
  {
    return ((IExpandQuestionUtils)QRoute.api(IExpandQuestionUtils.class)).needAnswerQuestion(paramString);
  }
  
  public void newReportTask(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    new ReportTask((QQAppInterface)paramAppRuntime).a("dc00899").b("Grp_private").c("Grp_data").d("exp").a(new String[] { paramString, String.valueOf(paramInt) }).a();
  }
  
  public void newTroopShareUtility(Activity paramActivity, Object paramObject)
  {
    this.mTroopShareUtility = new TroopShareUtility((QBaseActivity)paramActivity, (TroopInfoData)paramObject);
  }
  
  public void openAddTroopWeb(Activity paramActivity, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("?_wv=1031&troopUin=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("&isVerify=");
    localStringBuilder.append(0);
    paramString1 = localStringBuilder.toString();
    paramString2 = new Intent(paramActivity, QQBrowserActivity.class);
    paramString2.putExtra("url", paramString1);
    paramString2.putExtra("hide_left_button", true);
    paramString2.putExtra("show_right_close_button", true);
    paramString2.putExtra("finish_animation_up_down", true);
    paramActivity.startActivity(paramString2);
  }
  
  public void openTroopAssociationWebPage(Context paramContext, String paramString)
  {
    TroopAssociationsUtil.a(paramContext, paramString);
  }
  
  public void openTroopInfoActivity(Context paramContext, Bundle paramBundle, int paramInt)
  {
    TroopUtils.a(paramContext, paramBundle, paramInt);
  }
  
  public void openTroopProfole(Activity paramActivity, Object paramObject, int paramInt)
  {
    paramObject = (TroopInfoData)paramObject;
    Bundle localBundle = TroopInfoUIUtil.a(paramObject.troopUin, 3, paramObject.troopLat, paramObject.troopLon, paramObject.cityId, paramObject.troopLocation);
    localBundle.putInt("troop_type_ex", paramObject.troopTypeExt);
    localBundle.putString("leftViewText", HardCodeUtil.a(2131719940));
    localBundle.putInt("troop_auth_submit_time", paramInt);
    localBundle.putInt("PARAM_EXIT_ANIMATION", 1);
    localBundle.putBoolean(TroopInfoActivityConstant.jdField_a_of_type_JavaLangString, true);
    ((ITroopInfoActivityApi)QRoute.api(ITroopInfoActivityApi.class)).openTroopProfile(paramActivity, localBundle);
    paramActivity.overridePendingTransition(2130771993, 2130771994);
  }
  
  public void openTroopmemberCard(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    TroopMemberCardUtils.a((QQAppInterface)paramAppRuntime, paramContext, paramString1, paramString2, paramInt1, paramInt2, paramBundle);
  }
  
  public void preloadQunAlbum(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      QZoneHelper.preloadQunAlbum((QQAppInterface)paramAppRuntime, paramString);
    }
  }
  
  public void reportClockTroopAppShowOrClick(Object paramObject, boolean paramBoolean)
  {
    if (paramObject != null) {
      paramObject = ((TroopInfo)paramObject).troopuin;
    } else {
      paramObject = "";
    }
    QQGameTroopManager.a(1, paramObject, false);
  }
  
  public void reportCommercialDrainage(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7)
  {
    VasWebviewUtil.a(paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramInt3, paramString5, paramString6, paramString7);
  }
  
  public void reportDC00087(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    GameCenterUtils.a(null, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public void requestForPubAccountInfo(AppRuntime paramAppRuntime, long paramLong, int paramInt, Handler paramHandler)
  {
    TroopBindPubAccountProtocol.a((QQAppInterface)paramAppRuntime, paramLong, new ChatSettingForTroopApiImpl.3(this, paramInt, paramHandler));
  }
  
  public void secRecognize(boolean paramBoolean, View paramView)
  {
    TroopUtils.a(paramBoolean, paramView);
  }
  
  public void sendBroadcastQunMsgUnreadCount(Activity paramActivity, int paramInt)
  {
    QZoneHelper.sendBroadcastQunMsgUnreadCount(paramActivity, paramInt);
  }
  
  public void setAppIcon(Context paramContext, ImageView paramImageView, String paramString, float paramFloat, boolean paramBoolean)
  {
    TroopAppShortcutUtils.a(paramContext, paramImageView, paramString, paramFloat, paramBoolean);
  }
  
  public void setBooleanForQVipConfigManager_keyWordGuideClicked(AppRuntime paramAppRuntime)
  {
    QVipConfigManager.b((QQAppInterface)paramAppRuntime, "troop_keyword_guide_clicked", true);
  }
  
  public void setColorText(TextView paramTextView, Spannable paramSpannable, int paramInt)
  {
    ColorNickManager.a(paramTextView, paramSpannable, paramInt);
  }
  
  public void setColorText(AppRuntime paramAppRuntime, TextView paramTextView, Spannable paramSpannable)
  {
    ColorNickManager.a((QQAppInterface)paramAppRuntime, paramTextView, paramSpannable);
  }
  
  public void setStringForQVipConfigManager_keyWordExpireList(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    paramAppRuntime = (QQAppInterface)paramAppRuntime;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_keyword_expire_list_");
    localStringBuilder.append(paramString1);
    QVipConfigManager.a(paramAppRuntime, localStringBuilder.toString(), paramString2);
  }
  
  public void setTroopMsgFilterToServer(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)paramAppRuntime).setTroopMsgFilterToServer(paramString, Integer.valueOf(paramInt));
    }
  }
  
  public void startActivityForTroop(Activity paramActivity, String paramString, int paramInt)
  {
    ChatHistoryActivity.a(paramActivity, paramString, 1, 3012);
  }
  
  public void startChatBackgroundSettingActivity(Activity paramActivity, AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    TroopUtils.a(paramActivity, (QQAppInterface)paramAppRuntime, paramString, paramInt);
  }
  
  public void startFansTroopIdolPage(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    FansTroopUtils.a(paramContext, paramString, paramInt1, paramInt2);
  }
  
  public void startFansTroopIdolRank(Context paramContext, String paramString, int paramInt)
  {
    FansTroopUtils.b(paramContext, paramString, paramInt);
  }
  
  public void startGameSdkCallback(Activity paramActivity, boolean paramBoolean, String paramString1, long paramLong, int paramInt, String paramString2)
  {
    ForwardSdkShareOption.a(paramActivity, paramBoolean, paramString1, paramLong, paramInt, paramString2);
  }
  
  public Intent startJoinTroop(Context paramContext, String paramString1, String paramString2, short paramShort, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    return AddFriendLogicActivity.a(paramContext, paramString1, paramString2, paramShort, paramInt, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void startJumpAccountLogin(Activity paramActivity, Object paramObject)
  {
    paramObject = (QQCustomDialog)paramObject;
    Intent localIntent = new Intent();
    localIntent.putExtra("is_change_account", true);
    localIntent.putExtra("if_check_account_same", true);
    localIntent.putExtras(paramActivity.getIntent().getExtras());
    localIntent.putExtra("key_action", ((ITroopSettingApi)QRoute.api(ITroopSettingApi.class)).getSimpleNameForTroopSettingActivity());
    localIntent.addFlags(268435456);
    localIntent.addFlags(67108864);
    paramObject.cancel();
    RouteUtils.a(paramActivity, localIntent, "/base/login");
  }
  
  public void startModifyHomeworkTroopNickname(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    HWTroopUtils.a(paramContext, paramString1, paramString2, paramString3);
  }
  
  public void startModifyLocationActivityForResult(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    TroopLocationModifyActivity.a(paramActivity, paramString1, paramString2, paramInt);
  }
  
  public void startTroop2DCode()
  {
    this.mTroopShareUtility.f();
  }
  
  public void startTroopMemberCard(Activity paramActivity, AppRuntime paramAppRuntime, Object paramObject1, Object paramObject2, int paramInt)
  {
    if ((paramObject1 instanceof TroopInfo))
    {
      if (!(paramObject2 instanceof TroopInfoData)) {
        return;
      }
      Object localObject = (TroopInfo)paramObject1;
      paramObject1 = (TroopInfoData)paramObject2;
      int i;
      if ((localObject != null) && (((TroopInfo)localObject).isHomeworkTroop())) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        HWTroopUtils.a(paramActivity, paramAppRuntime.getCurrentAccountUin(), paramObject1.troopUin, "troopProfile");
        ReportController.b(paramAppRuntime, "P_CliOper", "Grp_edu", "", "Grp_data", "mbercard_Clk", 0, 0, paramObject1.troopUin, "", "", "");
      }
      else
      {
        paramObject2 = paramObject1.troopColorNick;
        localObject = new Intent();
        ((Intent)localObject).putExtra("edit_type", 5);
        ((Intent)localObject).putExtra("edit_mode", 0);
        ((Intent)localObject).putExtra("title", HardCodeUtil.a(2131697577));
        ((Intent)localObject).putExtra("default_text", paramObject2);
        ((Intent)localObject).putExtra("max_num", 60);
        ((Intent)localObject).putExtra("default_nick_id", paramObject1.troopColorNickId);
        ((Intent)localObject).putExtra("troopUin", paramObject1.troopUin);
        ((Intent)localObject).putExtra("uin", paramAppRuntime.getAccount());
        ((Intent)localObject).putExtra("from", 0);
        RouteUtils.a(paramActivity, (Intent)localObject, "/base/activity/editInfoActivity", paramInt);
      }
      ReportController.b(paramAppRuntime, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "Clk_modifydata", 0, 0, paramObject1.troopUin, "", "", "");
      TroopReportor.a("Grp_set_new", "grpData_admin", "clk_modifydata", 0, 0, new String[] { paramObject1.troopUin, TroopReportor.a(paramObject1) });
      VasWebviewUtil.a(paramAppRuntime.getCurrentUin(), "group_nickname", "group_nickname_2", "", 1, 0, 0, "", "", "");
    }
  }
  
  public void startTroopRemarkActivity(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra(TroopRemarkEditFragment.jdField_a_of_type_JavaLangString, paramString1);
      localIntent.putExtra(TroopRemarkEditFragment.c, paramString3);
      localIntent.putExtra(TroopRemarkEditFragment.b, paramString2);
      if (!TextUtils.isEmpty(paramString4)) {
        localIntent.putExtra(TroopRemarkEditFragment.d, paramString4);
      }
      PublicFragmentActivity.a(paramActivity, localIntent, TroopRemarkEditFragment.class, paramInt);
    }
  }
  
  public boolean troopNoticeFreezed(Activity paramActivity, Object paramObject)
  {
    paramObject = (TroopInfoData)paramObject;
    if ((QVipBigTroopExpiredProcessor.c().mIsEnable) && (paramObject.mIsFreezed == 1) && (paramObject.isOwnerOrAdim()))
    {
      boolean bool = TroopManager.LiangGroupHelper.c(paramObject.groupFreezeReason);
      if (paramObject.bOwner)
      {
        String str1 = paramObject.troopUin;
        int i;
        if (bool) {
          i = 15;
        } else {
          i = 8;
        }
        String str2 = VipUtils.a(0, i).toString();
        String str3 = HardCodeUtil.a(2131701946);
        ChatSettingForTroopApiImpl.2 local2 = new ChatSettingForTroopApiImpl.2(this, bool);
        if (bool) {
          paramObject = "0X800A57F";
        } else {
          paramObject = "0X8009E38";
        }
        if (bool) {
          i = 1;
        } else {
          i = 3;
        }
        VipUtils.a(paramActivity, str1, str2, str3, local2, paramObject, i, bool);
      }
      else
      {
        VipUtils.a(paramActivity, bool);
      }
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 3, 0, "", "", "", "");
      return true;
    }
    return false;
  }
  
  public void troopShareUtilityDestroy()
  {
    TroopShareUtility localTroopShareUtility = this.mTroopShareUtility;
    if (localTroopShareUtility != null)
    {
      localTroopShareUtility.e();
      this.mTroopShareUtility = null;
    }
  }
  
  public void updateEntryItem(AppRuntime paramAppRuntime, View paramView, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, boolean paramBoolean, String paramString1, String paramString2)
  {
    TroopUtils.a(paramView, paramCharSequence1, null, null, paramBoolean, paramString1, HardCodeUtil.a(2131691297), new ChatSettingForTroopApiImpl.4(this, paramAppRuntime));
  }
  
  public void updateHiddenChat(AppRuntime paramAppRuntime, Object paramObject)
  {
    TroopStatusUtil.a((QQAppInterface)paramAppRuntime, (TroopInfo)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.ChatSettingForTroopApiImpl
 * JD-Core Version:    0.7.0.1
 */