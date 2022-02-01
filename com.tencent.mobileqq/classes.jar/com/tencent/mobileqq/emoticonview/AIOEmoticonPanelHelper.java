package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emoticonview.api.IReportWorkerService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import mqq.util.WeakReference;

public class AIOEmoticonPanelHelper
  implements Handler.Callback, ILifeCycleHelper, EmoticonCallback
{
  public static final String TAG = "AIOEmoticonPanelHalper";
  private WeakReference<BaseChatPie> mBaseChatPieReference;
  
  public AIOEmoticonPanelHelper(BaseChatPie paramBaseChatPie)
  {
    this.mBaseChatPieReference = new WeakReference(paramBaseChatPie);
    paramBaseChatPie.bv().d().a(this);
  }
  
  private IEmoticonMainPanel tryGetEmoticonMainPanel()
  {
    Object localObject = tryGetChatPie();
    if (localObject != null)
    {
      localObject = (AIOEmoticonUIHelper)((BaseChatPie)localObject).q(105);
      if (localObject != null) {
        return ((AIOEmoticonUIHelper)localObject).j();
      }
    }
    return null;
  }
  
  public void delete()
  {
    BaseChatPie localBaseChatPie = tryGetChatPie();
    if (localBaseChatPie != null) {
      TextUtils.backspace(localBaseChatPie.Y);
    }
  }
  
  public void doOnEmoticonPanelFullScreen()
  {
    BaseChatPie localBaseChatPie = tryGetChatPie();
    if (localBaseChatPie == null) {
      return;
    }
    View localView = localBaseChatPie.bm().getCurrentPanelView();
    if (((localView instanceof IEmoticonMainPanel)) && (localView.getVisibility() == 0)) {
      localBaseChatPie.bm().b();
    }
  }
  
  public void emoticonMall()
  {
    gotoEmoMallPage(6);
  }
  
  @NonNull
  public String getTag()
  {
    return getClass().getName();
  }
  
  public void gotoEmoMallPage(int paramInt)
  {
    BaseChatPie localBaseChatPie = tryGetChatPie();
    if (localBaseChatPie == null) {
      return;
    }
    EmojiHomeUiPlugin.openEmojiHomePage(localBaseChatPie.f, localBaseChatPie.i().getAccount(), paramInt);
    if (6 == paramInt)
    {
      ReportController.b(null, "CliOper", "", "", "MbGuanli", "MbDianjiTianjia", 0, 0, "", "", "", "");
      return;
    }
    if (9 == paramInt) {
      ReportController.b(null, "CliOper", "", "", "MbGuanli", "MbGiftClick", 0, 0, "", "", "", "");
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject = tryGetEmoticonMainPanel();
    int i = paramMessage.what;
    if (i != 10)
    {
      if (i != 41)
      {
        if (i != 53)
        {
          if (i != 55)
          {
            if (i != 91)
            {
              if (i != 21)
              {
                if (i != 22) {
                  return false;
                }
                showEmoticonPanel((String)paramMessage.obj);
                return true;
              }
              if (localObject != null) {
                ((IEmoticonMainPanel)localObject).updateMagicPanel();
              }
              return true;
            }
            if (localObject != null) {
              ((IEmoticonMainPanel)localObject).updateSystemAndEmojiPanel();
            }
            return true;
          }
          localObject = tryGetChatPie();
          if (localObject != null) {
            reportClassicAndSmallEmoticon((String)paramMessage.obj, true, ((BaseChatPie)localObject).i());
          }
          return true;
        }
        showManagerFavEmoticonTips();
        return true;
      }
      if (localObject != null) {
        ((IEmoticonMainPanel)localObject).updateLastEmoticonPanel();
      }
      return true;
    }
    if (localObject != null) {
      ((IEmoticonMainPanel)localObject).updateFavEmoticonPanel();
    }
    return true;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 15, 9, 7 };
  }
  
  public boolean isEmoPgkForward()
  {
    BaseChatPie localBaseChatPie = tryGetChatPie();
    boolean bool2 = false;
    if (localBaseChatPie == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (localBaseChatPie.e != null)
    {
      bool1 = bool2;
      if (localBaseChatPie.aX() != null)
      {
        bool1 = bool2;
        if (localBaseChatPie.aX().getIntent() != null)
        {
          bool1 = bool2;
          if (localBaseChatPie.aX().getIntent().getExtras() != null)
          {
            bool1 = bool2;
            if (localBaseChatPie.aX().getIntent().getExtras().containsKey("FORWARD_EMOPGK_ID")) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  public boolean onLongClick(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void onMoveToState(int paramInt) {}
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable)
  {
    paramEmoticonInfo1 = tryGetChatPie();
    if ((paramEmoticonInfo1 != null) && (paramEmoticonInfo2.type == 6) && ((paramEmoticonInfo2 instanceof IPicEmoticonInfo)) && (((IPicEmoticonInfo)paramEmoticonInfo2).isSound())) {
      MediaPlayerManager.a(paramEmoticonInfo1.d).a(true);
    }
  }
  
  public void reportClassicAndSmallEmoticon(String paramString, boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    BaseChatPie localBaseChatPie = tryGetChatPie();
    if (localBaseChatPie == null) {
      return;
    }
    IEmoticonMainPanel localIEmoticonMainPanel = tryGetEmoticonMainPanel();
    ThreadManager.post(((IReportWorkerService)QRoute.api(IReportWorkerService.class)).createReportWorker(paramString, paramBoolean, localIEmoticonMainPanel, paramQQAppInterface, localBaseChatPie.F()), 2, null, false);
  }
  
  public void send()
  {
    BaseChatPie localBaseChatPie = tryGetChatPie();
    if (localBaseChatPie != null) {
      localBaseChatPie.ax();
    }
  }
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    BaseChatPie localBaseChatPie = tryGetChatPie();
    if ((paramEmoticonInfo != null) && (localBaseChatPie != null)) {
      paramEmoticonInfo.send(localBaseChatPie.d, localBaseChatPie.f, localBaseChatPie.Y, localBaseChatPie.aE());
    }
    if ((localBaseChatPie instanceof FriendChatPie)) {
      ((FriendChatPie)localBaseChatPie).a(paramEmoticonInfo);
    }
  }
  
  public void setting()
  {
    Object localObject = tryGetChatPie();
    if (localObject != null)
    {
      localObject = new ActivityURIRequest(((BaseChatPie)localObject).aX(), "/base/activity/EmosmActivity");
      ((ActivityURIRequest)localObject).extra().putInt("extra_launch_source", 1);
      ((ActivityURIRequest)localObject).extra().putInt("extra_launch_mode", 2);
      QRoute.startUri((URIRequest)localObject);
      ReportController.b(null, "CliOper", "", "", "MbGuanli", "MbDianjiGuanli", 0, 0, "", "", "", "");
    }
  }
  
  public void showEmoticonPanel(int paramInt)
  {
    Object localObject = tryGetChatPie();
    if (localObject == null) {
      return;
    }
    AIOEmoticonUIHelper localAIOEmoticonUIHelper = (AIOEmoticonUIHelper)((BaseChatPie)localObject).q(105);
    if (localAIOEmoticonUIHelper == null) {
      return;
    }
    long l = System.currentTimeMillis();
    IEmoticonMainPanel localIEmoticonMainPanel = localAIOEmoticonUIHelper.j();
    if ((localIEmoticonMainPanel != null) && (localIEmoticonMainPanel.getVisibility() == 0))
    {
      localIEmoticonMainPanel.initEmoticonView(paramInt);
      ((BaseChatPie)localObject).bm().a(3);
    }
    else if (localIEmoticonMainPanel == null)
    {
      localAIOEmoticonUIHelper.d = paramInt;
      ((BaseChatPie)localObject).bm().a(3);
      if (localIEmoticonMainPanel != null) {
        localIEmoticonMainPanel.preloadWebProcess();
      }
    }
    else
    {
      localIEmoticonMainPanel.initEmoticonView(paramInt);
      ((BaseChatPie)localObject).bm().a(3);
      localIEmoticonMainPanel.preloadWebProcess();
    }
    localAIOEmoticonUIHelper.d = -1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[Performance] showEmoticonPanel, duration=");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      QLog.d("AIOEmoticonPanelHalper", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void showEmoticonPanel(String paramString)
  {
    BaseChatPie localBaseChatPie = tryGetChatPie();
    if (localBaseChatPie == null) {
      return;
    }
    AIOEmoticonUIHelper localAIOEmoticonUIHelper = (AIOEmoticonUIHelper)localBaseChatPie.q(105);
    if (localAIOEmoticonUIHelper == null) {
      return;
    }
    long l = System.currentTimeMillis();
    IEmoticonMainPanel localIEmoticonMainPanel = localAIOEmoticonUIHelper.j();
    if ((localIEmoticonMainPanel != null) && (localIEmoticonMainPanel.getVisibility() == 0))
    {
      localIEmoticonMainPanel.initEmoticonView(paramString);
      localBaseChatPie.bm().a(3);
    }
    else if (localIEmoticonMainPanel == null)
    {
      localAIOEmoticonUIHelper.c = paramString;
      localBaseChatPie.bm().a(3);
      if (localIEmoticonMainPanel != null) {
        localIEmoticonMainPanel.preloadWebProcess();
      }
    }
    else if (paramString != null)
    {
      localIEmoticonMainPanel.initEmoticonView(paramString);
      localBaseChatPie.bm().a(3);
      localIEmoticonMainPanel.preloadWebProcess();
    }
    localAIOEmoticonUIHelper.c = null;
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("[Performance] showEmoticonPanel, duration=");
      paramString.append(System.currentTimeMillis() - l);
      QLog.d("AIOEmoticonPanelHalper", 2, paramString.toString());
    }
  }
  
  public void showManagerFavEmoticonTips()
  {
    Object localObject = tryGetChatPie();
    if (localObject == null) {
      return;
    }
    localObject = ((BaseChatPie)localObject).e;
    DialogUtil.a((Context)localObject, 230, null, ((Context)localObject).getString(2131886260), 2131889114, 2131889113, new AIOEmoticonPanelHelper.1(this, (Context)localObject), new AIOEmoticonPanelHelper.2(this)).show();
  }
  
  public BaseChatPie tryGetChatPie()
  {
    WeakReference localWeakReference = this.mBaseChatPieReference;
    if ((localWeakReference != null) && (!localWeakReference.isEnqueued())) {
      return (BaseChatPie)this.mBaseChatPieReference.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.AIOEmoticonPanelHelper
 * JD-Core Version:    0.7.0.1
 */