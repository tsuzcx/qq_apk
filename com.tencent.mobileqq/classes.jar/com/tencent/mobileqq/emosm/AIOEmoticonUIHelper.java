package com.tencent.mobileqq.emosm;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.helper.AIOEmoticonGuideHelper;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.helper.OnActivityResultCallback;
import com.tencent.mobileqq.activity.aio.helper.StickerRecHelper;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelProvider;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.AIOEmoticonPanelHelper;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper;
import com.tencent.mobileqq.emoticonview.EmotionKeywordAdapter;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout;
import com.tencent.mobileqq.emoticonview.EmotionSearchPanel;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.util.WeakReference;

public class AIOEmoticonUIHelper
  implements ILifeCycleHelper, OnActivityResultCallback, PanelProvider<EmoticonMainPanel>
{
  public int a;
  private EmoticonObserver jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver = new AIOEmoticonUIHelper.3(this);
  protected EmoticonMainPanel a;
  private EmotionKeywordAdapter jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter;
  private EmotionKeywordHorizonListView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView;
  private EmotionKeywordLayout jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout;
  protected EmotionSearchPanel a;
  private EmoticonManager jdField_a_of_type_ComTencentMobileqqModelEmoticonManager;
  public String a;
  private WeakReference<BaseChatPie> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  
  public AIOEmoticonUIHelper()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public AIOEmoticonUIHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramBaseChatPie);
    paramBaseChatPie.b().a().a(this);
  }
  
  public static EmoticonMainPanel a(BaseChatPie paramBaseChatPie)
  {
    if (paramBaseChatPie == null) {
      return null;
    }
    paramBaseChatPie = (AIOEmoticonUIHelper)paramBaseChatPie.a(105);
    if (paramBaseChatPie == null) {
      return null;
    }
    return paramBaseChatPie.c();
  }
  
  public BaseChatPie a()
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.isEnqueued())) {
      return null;
    }
    return (BaseChatPie)this.jdField_a_of_type_MqqUtilWeakReference.get();
  }
  
  public EmoticonMainPanel a()
  {
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie == null) {
      return null;
    }
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = a(localBaseChatPie, 2131559200);
    Object localObject = (AIOEmoticonPanelHelper)localBaseChatPie.a(104);
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack((EmoticonCallback)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
    if ((localBaseChatPie.y()) || (localBaseChatPie.F)) {}
    for (boolean bool = true;; bool = false)
    {
      ((EmoticonMainPanel)localObject).onlySysAndEmoji = bool;
      if (localBaseChatPie.y()) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setHideAllSettingTabs(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.disableMoreEmotionButton = localBaseChatPie.F;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.disableGuide = localBaseChatPie.F;
      a(localBaseChatPie);
      if (QLog.isColorLevel()) {
        QLog.d(getTag(), 2, "OpenEmoticonMainPanel:" + (System.currentTimeMillis() - l));
      }
      if ((localBaseChatPie instanceof BaseTroopChatPie))
      {
        bool = ((BaseTroopChatPie)localBaseChatPie).G();
        if (bool) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.switchToAnonymous(bool);
        }
      }
      return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
    }
  }
  
  public EmoticonMainPanel a(Context paramContext)
  {
    return a();
  }
  
  public EmoticonMainPanel a(BaseChatPie paramBaseChatPie, int paramInt)
  {
    return (EmoticonMainPanel)View.inflate(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, paramInt, null);
  }
  
  public EmotionKeywordAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter;
  }
  
  public EmotionKeywordLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onDestory();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = null;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.doAutoDownload(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 4779) && (paramInt2 == 8213)) {
      a(17);
    }
    while ((paramInt1 != 4813) || (paramInt2 != 8213)) {
      return;
    }
    a(18);
  }
  
  public void a(Editable paramEditable)
  {
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      return;
      if ((paramEditable == null) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView == null) || (this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager == null) || (((BaseChatPie)localObject).a().jdField_a_of_type_Int == 1008) || (((BaseChatPie)localObject).a().jdField_a_of_type_Int == 10007)) {
        break;
      }
      paramEditable = paramEditable.toString();
      localObject = paramEditable.toLowerCase();
    } while (!this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a((String)localObject));
    ThreadManager.post(new AIOEmoticonUIHelper.2(this, (String)localObject, paramEditable), 5, null, true);
    return;
    QLog.e(getTag(), 1, "emotionkeyword error");
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.init(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.a().jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_AndroidContentContext, paramBaseChatPie.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramBaseChatPie);
  }
  
  public void a(Emoticon paramEmoticon, int paramInt, String paramString, boolean paramBoolean)
  {
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie == null) {}
    ActionGlobalData localActionGlobalData;
    do
    {
      do
      {
        return;
        localBaseChatPie.aj();
      } while ((!paramBoolean) && (paramInt == 1) && (localBaseChatPie.a() != null) && (localBaseChatPie.a().a() != 0));
      localActionGlobalData = MagicfaceActionManager.a(paramEmoticon, 1);
    } while ((!paramBoolean) && (localActionGlobalData != null) && (paramInt == 1) && (!localActionGlobalData.c));
    localBaseChatPie.a().a(paramEmoticon, paramInt, paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onHide(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, String paramString, int paramInt2)
  {
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie == null) {
      return;
    }
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel == null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel = ((EmotionSearchPanel)View.inflate(localBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131558640, null));
      }
      EmoticonPanelHotPicSearchHelper localEmoticonPanelHotPicSearchHelper = (EmoticonPanelHotPicSearchHelper)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getEmoController().getHelper(7);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel.showEmotionSearchWindow();
      int i = ScreenUtil.getRealHeight(localBaseChatPie.jdField_a_of_type_AndroidContentContext) - paramInt1 - ImmersiveUtils.getStatusBarHeight(localBaseChatPie.jdField_a_of_type_AndroidContentContext);
      if (ThemeUtil.isNowThemeIsSimple(localBaseChatPie.a(), false, null))
      {
        Rect localRect = new Rect();
        localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getGlobalVisibleRect(localRect);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel.init(localBaseChatPie.a(), localBaseChatPie, i, paramBoolean2, paramString, paramInt1 - localRect.bottom, paramInt2, localEmoticonPanelHotPicSearchHelper);
        return;
      }
      paramInt1 = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight();
      int j = localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getHeight();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel.init(localBaseChatPie.a(), localBaseChatPie, i, paramBoolean2, paramString, paramInt1 + j, paramInt2, localEmoticonPanelHotPicSearchHelper);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel.onDestory();
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(getTag(), 2, "recreate emotion panel due to full screen");
      }
      this.jdField_a_of_type_Boolean = false;
      bool = true;
    }
    return bool;
  }
  
  public EmoticonMainPanel b()
  {
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie == null) {
      return null;
    }
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = a(localBaseChatPie, 2131559200);
    AIOEmoticonPanelHelper localAIOEmoticonPanelHelper = (AIOEmoticonPanelHelper)localBaseChatPie.a(104);
    if (localAIOEmoticonPanelHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(localAIOEmoticonPanelHelper);
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onlySysAndEmoji = true;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setHideAllSettingTabs(true);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.disableMoreEmotionButton = true;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.disableGuide = true;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setOnlySysEmotionEnable(true);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setSysEmotionOrder(GameMsgUtil.a);
    a(localBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setEmoSettingVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.hideAllTabs();
    if (QLog.isColorLevel()) {
      QLog.d("OpenPanel", 2, "OpenEmoticonMainPanel:" + (System.currentTimeMillis() - l));
    }
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  }
  
  public void b()
  {
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel = ((EmotionSearchPanel)localBaseChatPie.c.findViewById(2131366310));
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.switchToAnonymous(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout.getVisibility() == 0);
  }
  
  public EmoticonMainPanel c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  }
  
  public void c()
  {
    o();
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel.onDestory();
    }
  }
  
  public EmoticonMainPanel d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout.hide();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onPause();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onResume();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onShow();
    }
  }
  
  public int getPanelId()
  {
    return 3;
  }
  
  @NonNull
  public String getTag()
  {
    return getClass().getName();
  }
  
  public void h()
  {
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_Boolean = (localBaseChatPie.y() ^ this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onlySysAndEmoji);
    }
    localBaseChatPie.a().a(3);
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.preloadWebProcess();
    }
    ((AIOEmoticonGuideHelper)localBaseChatPie.a(54)).a();
    AIOPanelUtiles.a(localBaseChatPie.a(), "0X8005CAD", localBaseChatPie.a().jdField_a_of_type_Int);
    VasWebviewUtil.reportCommercialDrainage(localBaseChatPie.a().getCurrentUin(), "ep_mall", "0X8005795", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.isHiden = true;
    }
  }
  
  public int[] interestedIn()
  {
    return new int[] { 0, 14, 6, 10, 21, 9, 1 };
  }
  
  public boolean isNeedRecreatePanel()
  {
    return a();
  }
  
  public void j()
  {
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onlySysAndEmoji = localBaseChatPie.F;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.disableMoreEmotionButton = localBaseChatPie.F;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.disableGuide = localBaseChatPie.F;
    if (!localBaseChatPie.F) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.disableGuideOneTime = true;
    }
    a(localBaseChatPie);
  }
  
  public void k()
  {
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie == null) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout == null) || (localBaseChatPie.a() == null)) {
      return;
    }
    localBaseChatPie.a().removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout = null;
  }
  
  public void l()
  {
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie == null) {}
    while (!localBaseChatPie.t()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout == null) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout = ((EmotionKeywordLayout)View.inflate(localBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131558637, null));
        localObject = (StickerRecHelper)localBaseChatPie.a(14);
        boolean bool = ((StickerRecHelper)localObject).a();
        if (!bool) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView = ((StickerRecHelper)localObject).a(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView.setTouchListener(new AIOEmoticonUIHelper.1(this));
        localObject = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131369142);
        if (!bool) {
          continue;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(9);
      }
      catch (Exception localException)
      {
        Object localObject;
        QLog.e(getTag(), 2, "EmotionPreviewLayout InflateException = " + localException);
        continue;
        localException.addRule(11);
        continue;
      }
      localBaseChatPie.a().addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager = ((EmoticonManager)localBaseChatPie.a().getManager(QQManagerFactory.EMOTICON_MANAGER));
      return;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView = ((EmotionKeywordHorizonListView)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout.findViewById(2131366290));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter = new EmotionKeywordAdapter(localBaseChatPie.jdField_a_of_type_AndroidContentContext, localBaseChatPie.a(), localBaseChatPie.a(), localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx, localBaseChatPie);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter);
    }
  }
  
  public void m()
  {
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout.hide();
      }
      if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
        localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(true);
      }
      localBaseChatPie.ar();
    } while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter == null);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter.reportExposeData();
  }
  
  public void n()
  {
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie == null) {
      return;
    }
    localBaseChatPie.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
  }
  
  public void o()
  {
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie == null) {
      return;
    }
    localBaseChatPie.a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
  }
  
  public void onHideAllPanel()
  {
    i();
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      b();
      return;
    case 14: 
      c();
      return;
    case 10: 
      e();
      return;
    case 6: 
      f();
      return;
    case 21: 
      k();
      a();
      return;
    case 9: 
      l();
      return;
    }
    n();
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (paramInt1 == 3) {
      if (paramInt2 != 1) {
        break label27;
      }
    }
    for (;;)
    {
      a(bool);
      if (paramInt2 == 3) {
        g();
      }
      return;
      label27:
      bool = false;
    }
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    paramXPanelContainer = a();
    if (paramXPanelContainer == null) {}
    while (paramXPanelContainer.f() == 1) {
      return;
    }
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.AIOEmoticonUIHelper
 * JD-Core Version:    0.7.0.1
 */