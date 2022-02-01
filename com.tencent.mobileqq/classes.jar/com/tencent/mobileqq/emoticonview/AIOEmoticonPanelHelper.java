package com.tencent.mobileqq.emoticonview;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.mobileqq.activity.EmosmActivity;
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
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.TextUtils;
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
    paramBaseChatPie.b().a().a(this);
  }
  
  private EmoticonMainPanel tryGetEmoticonMainPanel()
  {
    Object localObject = tryGetChatPie();
    if (localObject != null)
    {
      localObject = (AIOEmoticonUIHelper)((BaseChatPie)localObject).a(105);
      if (localObject != null) {
        return ((AIOEmoticonUIHelper)localObject).c();
      }
    }
    return null;
  }
  
  public void delete()
  {
    BaseChatPie localBaseChatPie = tryGetChatPie();
    if (localBaseChatPie != null) {
      TextUtils.backspace(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    }
  }
  
  public void doOnEmoticonPanelFullScreen()
  {
    BaseChatPie localBaseChatPie = tryGetChatPie();
    if (localBaseChatPie == null) {}
    View localView;
    do
    {
      return;
      localView = localBaseChatPie.a().a();
    } while ((!(localView instanceof EmoticonMainPanel)) || (localView.getVisibility() != 0));
    localBaseChatPie.a().a();
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
    if (localBaseChatPie == null) {}
    do
    {
      return;
      EmojiHomeUiPlugin.openEmojiHomePage(localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localBaseChatPie.a().getAccount(), paramInt);
      if (6 == paramInt)
      {
        ReportController.b(null, "CliOper", "", "", "MbGuanli", "MbDianjiTianjia", 0, 0, "", "", "", "");
        return;
      }
    } while (9 != paramInt);
    ReportController.b(null, "CliOper", "", "", "MbGuanli", "MbGiftClick", 0, 0, "", "", "", "");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject = tryGetEmoticonMainPanel();
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 22: 
      showEmoticonPanel((String)paramMessage.obj);
      return true;
    case 10: 
      if (localObject != null) {
        ((EmoticonMainPanel)localObject).updateFavEmoticonPanel();
      }
      return true;
    case 41: 
      if (localObject != null) {
        ((EmoticonMainPanel)localObject).updateLastEmoticonPanel();
      }
      return true;
    case 91: 
      if (localObject != null) {
        ((EmoticonMainPanel)localObject).updateSystemAndEmojiPanel();
      }
      return true;
    case 21: 
      if (localObject != null) {
        ((EmoticonMainPanel)localObject).updateMagicPanel();
      }
      return true;
    }
    localObject = tryGetChatPie();
    if (localObject != null) {
      reportClassicAndSmallEmoticon((String)paramMessage.obj, true, ((BaseChatPie)localObject).a());
    }
    return true;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 14, 8, 6 };
  }
  
  public boolean isEmoPgkForward()
  {
    BaseChatPie localBaseChatPie = tryGetChatPie();
    if (localBaseChatPie == null) {}
    while ((localBaseChatPie.jdField_a_of_type_AndroidContentContext == null) || (localBaseChatPie.a() == null) || (localBaseChatPie.a().getIntent() == null) || (localBaseChatPie.a().getIntent().getExtras() == null) || (!localBaseChatPie.a().getIntent().getExtras().containsKey("FORWARD_EMOPGK_ID"))) {
      return false;
    }
    return true;
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
    if ((paramEmoticonInfo1 != null) && (paramEmoticonInfo2.type == 6) && ((paramEmoticonInfo2 instanceof PicEmoticonInfo)) && (((PicEmoticonInfo)paramEmoticonInfo2).isSound())) {
      MediaPlayerManager.a(paramEmoticonInfo1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
    }
  }
  
  public void reportClassicAndSmallEmoticon(String paramString, boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    BaseChatPie localBaseChatPie = tryGetChatPie();
    if (localBaseChatPie == null) {
      return;
    }
    ThreadManager.post(new ReportWorker(paramString, paramBoolean, tryGetEmoticonMainPanel(), paramQQAppInterface, localBaseChatPie.b()), 2, null, false);
  }
  
  public void send()
  {
    BaseChatPie localBaseChatPie = tryGetChatPie();
    if (localBaseChatPie != null) {
      localBaseChatPie.ao();
    }
  }
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    BaseChatPie localBaseChatPie = tryGetChatPie();
    if ((paramEmoticonInfo != null) && (localBaseChatPie != null)) {
      paramEmoticonInfo.send(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx, localBaseChatPie.a());
    }
    if ((localBaseChatPie instanceof FriendChatPie)) {
      ((FriendChatPie)localBaseChatPie).a(paramEmoticonInfo);
    }
  }
  
  public void setting()
  {
    BaseChatPie localBaseChatPie = tryGetChatPie();
    if (localBaseChatPie != null)
    {
      Intent localIntent = new Intent(localBaseChatPie.jdField_a_of_type_AndroidContentContext, EmosmActivity.class);
      localIntent.putExtra("extra_launch_source", 1);
      localIntent.putExtra("extra_launch_mode", 2);
      localBaseChatPie.a().startActivity(localIntent);
      ReportController.b(null, "CliOper", "", "", "MbGuanli", "MbDianjiGuanli", 0, 0, "", "", "", "");
    }
  }
  
  public void showEmoticonPanel(int paramInt)
  {
    BaseChatPie localBaseChatPie = tryGetChatPie();
    if (localBaseChatPie == null) {}
    AIOEmoticonUIHelper localAIOEmoticonUIHelper;
    do
    {
      return;
      localAIOEmoticonUIHelper = (AIOEmoticonUIHelper)localBaseChatPie.a(105);
    } while (localAIOEmoticonUIHelper == null);
    long l = System.currentTimeMillis();
    EmoticonMainPanel localEmoticonMainPanel = localAIOEmoticonUIHelper.c();
    if ((localEmoticonMainPanel != null) && (localEmoticonMainPanel.getVisibility() == 0))
    {
      localEmoticonMainPanel.initEmoticonView(paramInt);
      localBaseChatPie.a().a(3);
    }
    for (;;)
    {
      localAIOEmoticonUIHelper.jdField_a_of_type_Int = -1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOEmoticonPanelHalper", 2, "[Performance] showEmoticonPanel, duration=" + (System.currentTimeMillis() - l));
      return;
      if (localEmoticonMainPanel == null)
      {
        localAIOEmoticonUIHelper.jdField_a_of_type_Int = paramInt;
        localBaseChatPie.a().a(3);
        if (localEmoticonMainPanel != null) {
          localEmoticonMainPanel.preloadWebProcess();
        }
      }
      else
      {
        localEmoticonMainPanel.initEmoticonView(paramInt);
        localBaseChatPie.a().a(3);
        localEmoticonMainPanel.preloadWebProcess();
      }
    }
  }
  
  public void showEmoticonPanel(String paramString)
  {
    BaseChatPie localBaseChatPie = tryGetChatPie();
    if (localBaseChatPie == null) {}
    AIOEmoticonUIHelper localAIOEmoticonUIHelper;
    do
    {
      return;
      localAIOEmoticonUIHelper = (AIOEmoticonUIHelper)localBaseChatPie.a(105);
    } while (localAIOEmoticonUIHelper == null);
    long l = System.currentTimeMillis();
    EmoticonMainPanel localEmoticonMainPanel = localAIOEmoticonUIHelper.c();
    if ((localEmoticonMainPanel != null) && (localEmoticonMainPanel.getVisibility() == 0))
    {
      localEmoticonMainPanel.initEmoticonView(paramString);
      localBaseChatPie.a().a(3);
    }
    for (;;)
    {
      localAIOEmoticonUIHelper.jdField_a_of_type_JavaLangString = null;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOEmoticonPanelHalper", 2, "[Performance] showEmoticonPanel, duration=" + (System.currentTimeMillis() - l));
      return;
      if (localEmoticonMainPanel == null)
      {
        localAIOEmoticonUIHelper.jdField_a_of_type_JavaLangString = paramString;
        localBaseChatPie.a().a(3);
        if (localEmoticonMainPanel != null) {
          localEmoticonMainPanel.preloadWebProcess();
        }
      }
      else if (paramString != null)
      {
        localEmoticonMainPanel.initEmoticonView(paramString);
        localBaseChatPie.a().a(3);
        localEmoticonMainPanel.preloadWebProcess();
      }
    }
  }
  
  public BaseChatPie tryGetChatPie()
  {
    if ((this.mBaseChatPieReference == null) || (this.mBaseChatPieReference.isEnqueued())) {
      return null;
    }
    return (BaseChatPie)this.mBaseChatPieReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.AIOEmoticonPanelHelper
 * JD-Core Version:    0.7.0.1
 */