package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import avli;
import bbbq;
import bdla;
import bhiw;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class EmoticonPanelSettingHelper
  extends AbstractEmoticonPanelHelper
  implements View.OnClickListener
{
  private static final String LOG_TAG = "EmoticonPanelSettingHelper";
  private int mBtnStatus;
  private ImageView mEmoticonSettingBtn;
  private boolean mHideMoreButton;
  private boolean mHideSettingButton;
  private ImageView mMoreEmoticonButton;
  
  public EmoticonPanelSettingHelper(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  private int getMoreBtnStatusByEmotionInfo(EmotionPanelInfo paramEmotionPanelInfo)
  {
    int i = 1;
    if (paramEmotionPanelInfo == null)
    {
      QLog.e("EmoticonPanelSettingHelper", 1, "getMoreBtnStatusByEmotionInfo info = null");
      i = -1;
    }
    while ((paramEmotionPanelInfo.type != 7) && (paramEmotionPanelInfo.type != 10)) {
      return i;
    }
    return 2;
  }
  
  public String getTag()
  {
    return "EmoticonPanelSettingHelper";
  }
  
  public void initBefore()
  {
    EmoticonMainPanel localEmoticonMainPanel = this.mPanelController.getPanel();
    this.mMoreEmoticonButton = ((ImageView)localEmoticonMainPanel.findViewById(2131363953));
    this.mEmoticonSettingBtn = ((ImageView)localEmoticonMainPanel.findViewById(2131364042));
    this.mMoreEmoticonButton.setOnClickListener(this);
    this.mEmoticonSettingBtn.setOnClickListener(this);
    if ((this.mPanelController.businessType == 3) || (this.mHideSettingButton) || (this.mPanelController.mHideAllSettingTabs)) {
      this.mEmoticonSettingBtn.setVisibility(8);
    }
    if ((this.mPanelController.mParams.disableMoreEmotionButton) || (this.mHideMoreButton) || (this.mPanelController.mHideAllSettingTabs))
    {
      this.mMoreEmoticonButton.setVisibility(8);
      return;
    }
    this.mMoreEmoticonButton.setVisibility(0);
  }
  
  public int[] interestedIn()
  {
    return new int[] { 1 };
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = this.mPanelController.app;
    Object localObject = this.mPanelController.context;
    boolean bool = this.mPanelController.hasBigEmotion;
    EmoticonCallback localEmoticonCallback = this.mPanelController.callback;
    switch (paramView.getId())
    {
    }
    int i;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      VasWebviewUtil.reportCommercialDrainage(localQQAppInterface.getCurrentUin(), "ep_mall", "click_mine", "", 0, 0, 0, "", "", "");
      EmojiHomeUiPlugin.openEmosmActivity((BaseActivity)localObject, localQQAppInterface.getAccount(), 1, false, "");
      bdla.b(localQQAppInterface, "dc00898", "", "", "0x800a56d", "0x800a56d", 0, 0, "", "", "", "");
      i = this.mPanelController.getFromType(false);
      if (i != 0)
      {
        bdla.b(localQQAppInterface, "dc00898", "", "", "0X800AE0F", "0X800AE0F", i, 0, "", "", "", "");
        continue;
        if ((this.mBtnStatus != 2) || (bool)) {
          break;
        }
        if (localEmoticonCallback != null) {
          localEmoticonCallback.delete();
        }
      }
    }
    bdla.b(localQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B7", 0, 0, "", "", "", "");
    if (this.mPanelController.mNewFlag.getVisibility() == 0)
    {
      bdla.b(localQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B9", 0, 0, "", "", "", "");
      this.mPanelController.mNewFlag.setVisibility(8);
      ((bbbq)localQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).b(String.valueOf("100610.100611"));
      ((Context)localObject).getSharedPreferences("mobileQQ", 0).edit().putBoolean("emo_panel_mall_new_played", false).apply();
    }
    for (bool = true;; bool = false)
    {
      bhiw.a(localQQAppInterface);
      this.mPanelController.mWebPreloadHitSession.b();
      EmojiHomeUiPlugin.openEmojiHomePage((BaseActivity)this.mPanelController.context, localQQAppInterface.getAccount(), 1, bool, "");
      bdla.b(localQQAppInterface, "CliOper", "", "", "0X80047A3", "0X80047A3", 0, 0, "", "", "", "");
      if (localObject != null)
      {
        localObject = ((Context)localObject).getSharedPreferences("emoticon_panel_" + localQQAppInterface.getCurrentAccountUin(), 0);
        if (localObject != null) {
          ((SharedPreferences)localObject).edit().putLong("sp_key_market_open_time", System.currentTimeMillis()).apply();
        }
      }
      if (WebProcessManager.c()) {}
      for (i = 1;; i = 0)
      {
        VasWebviewUtil.reportVasStatus("personal_web_preload_hit_rit", "emoticon_main_panel_plus", "0", 0, 0, i, 0, "", "");
        bdla.b(localQQAppInterface, "dc00898", "", "", "0x800a56c", "0x800a56c", 0, 0, "", "", "", "");
        i = this.mPanelController.getFromType(false);
        if (i == 0) {
          break;
        }
        bdla.b(localQQAppInterface, "dc00898", "", "", "0X800AE0E", "0X800AE0E", i, 0, "", "", "", "");
        break;
      }
    }
  }
  
  public boolean performClick(int paramInt)
  {
    if ((paramInt == 13) && (this.mMoreEmoticonButton != null))
    {
      this.mMoreEmoticonButton.performClick();
      return true;
    }
    if ((paramInt == 14) && (this.mEmoticonSettingBtn != null))
    {
      this.mEmoticonSettingBtn.performClick();
      return true;
    }
    return false;
  }
  
  protected void setEmoSettingVisibility(int paramInt)
  {
    if (this.mEmoticonSettingBtn != null) {
      this.mEmoticonSettingBtn.setVisibility(paramInt);
    }
  }
  
  public void setHideMoreAndSettingButton(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mHideMoreButton = paramBoolean1;
    this.mHideSettingButton = paramBoolean2;
  }
  
  protected void setMoreSettingVisibility(int paramInt)
  {
    if (this.mMoreEmoticonButton != null) {
      this.mMoreEmoticonButton.setVisibility(paramInt);
    }
  }
  
  public void switchMoreSettingStyle(EmotionPanelInfo paramEmotionPanelInfo)
  {
    if (paramEmotionPanelInfo == null) {}
    for (;;)
    {
      return;
      boolean bool = this.mPanelController.hasBigEmotion;
      EmoticonPanelController.EmoticonPanelParams localEmoticonPanelParams = this.mPanelController.mParams;
      int i = getMoreBtnStatusByEmotionInfo(paramEmotionPanelInfo);
      if (this.mBtnStatus != i)
      {
        this.mBtnStatus = i;
        if ((bool) && (!localEmoticonPanelParams.disableMoreEmotionButton)) {
          if (this.mHideMoreButton) {
            this.mMoreEmoticonButton.setVisibility(8);
          }
        }
        while (this.mPanelController.mHideAllSettingTabs)
        {
          this.mMoreEmoticonButton.setVisibility(8);
          return;
          this.mMoreEmoticonButton.setVisibility(0);
          this.mMoreEmoticonButton.setImageResource(2130847145);
          continue;
          if ((!((EmoticonPanelExtendHelper)this.mPanelController.getHelper(1)).isShowExtendPanel()) && (this.mBtnStatus == 2) && (!localEmoticonPanelParams.disableMoreEmotionButton))
          {
            this.mMoreEmoticonButton.setVisibility(0);
            this.mMoreEmoticonButton.setImageResource(2130847134);
            this.mMoreEmoticonButton.setPadding((int)(10.0F * this.mPanelController.density), 0, 0, 0);
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonPanelSettingHelper", 2, "onPageSelected, show del pic");
            }
          }
          else
          {
            this.mMoreEmoticonButton.setVisibility(8);
          }
        }
      }
    }
  }
  
  public void switchSettingBtnStyle(EmotionPanelInfo paramEmotionPanelInfo)
  {
    if (paramEmotionPanelInfo == null) {}
    for (;;)
    {
      return;
      boolean bool = this.mPanelController.hasBigEmotion;
      EmoticonPanelController.EmoticonPanelParams localEmoticonPanelParams = this.mPanelController.mParams;
      int i = getMoreBtnStatusByEmotionInfo(paramEmotionPanelInfo);
      if (this.mBtnStatus != i)
      {
        this.mBtnStatus = i;
        if ((bool) && (!localEmoticonPanelParams.disableMoreEmotionButton)) {
          if (this.mHideMoreButton) {
            this.mMoreEmoticonButton.setVisibility(8);
          }
        }
        while (this.mPanelController.mHideAllSettingTabs)
        {
          this.mMoreEmoticonButton.setVisibility(8);
          return;
          this.mMoreEmoticonButton.setVisibility(0);
          this.mMoreEmoticonButton.setImageResource(2130847145);
          this.mMoreEmoticonButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
          continue;
          if ((!((EmoticonPanelExtendHelper)this.mPanelController.getHelper(1)).isShowExtendPanel()) && (this.mBtnStatus == 2) && (!localEmoticonPanelParams.disableMoreEmotionButton))
          {
            this.mMoreEmoticonButton.setVisibility(0);
            this.mMoreEmoticonButton.setImageResource(2130847134);
            this.mMoreEmoticonButton.setScaleType(ImageView.ScaleType.CENTER);
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonPanelSettingHelper", 2, "onPageSelected, show del pic");
            }
          }
          else
          {
            this.mMoreEmoticonButton.setVisibility(8);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelSettingHelper
 * JD-Core Version:    0.7.0.1
 */