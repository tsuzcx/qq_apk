package com.tencent.qqmini.sdk.launcher.ui;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.R.drawable;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class MoreItemList$Builder
{
  private boolean isAboutPresent;
  private boolean isComplaintPresent;
  private boolean isShareQQPresent;
  private boolean isShareQZonePresent;
  private boolean isShareWxFriendsPresent;
  private boolean isShareWxMomentsPresent;
  private MoreItemList.DisplaySettings mDisplaySettings = new MoreItemList.DisplaySettings();
  MoreItemList mMoreItemList = new MoreItemList(null);
  
  public Builder addAbout(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.id = 5;
    localMoreItem.visible = this.mDisplaySettings.isShowAbout;
    localMoreItem.drawable = paramInt;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "关于";
    }
    localMoreItem.text = str;
    this.mMoreItemList.add(localMoreItem);
    this.isAboutPresent = true;
    return this;
  }
  
  public Builder addComplaint(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.id = 6;
    localMoreItem.visible = this.mDisplaySettings.isShowComplaint;
    localMoreItem.drawable = paramInt;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "举报";
    }
    localMoreItem.text = str;
    this.mMoreItemList.add(localMoreItem);
    this.isComplaintPresent = true;
    return this;
  }
  
  public Builder addDebug(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.id = 7;
    localMoreItem.visible = this.mDisplaySettings.isShowDebug;
    localMoreItem.drawable = paramInt;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "调试";
    }
    localMoreItem.text = str;
    this.mMoreItemList.add(localMoreItem);
    return this;
  }
  
  public Builder addFavorite(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.id = 10;
    localMoreItem.visible = this.mDisplaySettings.isShowFavorite;
    localMoreItem.drawable = paramInt;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "添加到我的";
    }
    localMoreItem.text = str;
    this.mMoreItemList.add(localMoreItem);
    return this;
  }
  
  public Builder addMonitor(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.id = 8;
    localMoreItem.visible = this.mDisplaySettings.isShowMonitor;
    localMoreItem.drawable = paramInt;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "性能";
    }
    localMoreItem.text = str;
    this.mMoreItemList.add(localMoreItem);
    return this;
  }
  
  public Builder addMoreItem(MoreItem paramMoreItem)
  {
    if (paramMoreItem == null)
    {
      QMLog.w("MoreItemList", "Failed to add moreItem, moreItem is null");
      return this;
    }
    if ((paramMoreItem.id < 100) || (paramMoreItem.id > 200))
    {
      QMLog.w("MoreItemList", "Failed to add more item, id must in range of [100, 200], but the actual id is " + paramMoreItem.id);
      return this;
    }
    paramMoreItem.visible = this.mDisplaySettings.isShowShareOthers;
    this.mMoreItemList.add(paramMoreItem);
    return this;
  }
  
  public Builder addQQFavorite(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.id = 12;
    localMoreItem.visible = this.mDisplaySettings.isShowQQFavorite;
    localMoreItem.drawable = paramInt;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "收藏";
    }
    localMoreItem.text = str;
    this.mMoreItemList.add(localMoreItem);
    return this;
  }
  
  public Builder addRestart(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.id = 9;
    localMoreItem.visible = this.mDisplaySettings.isShowRestart;
    localMoreItem.drawable = paramInt;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "重启";
    }
    localMoreItem.text = str;
    this.mMoreItemList.add(localMoreItem);
    return this;
  }
  
  public Builder addShareQQ(String paramString, int paramInt)
  {
    return addShareQQ(paramString, paramInt, false);
  }
  
  public Builder addShareQQ(String paramString, int paramInt, boolean paramBoolean)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.id = 1;
    localMoreItem.visible = this.mDisplaySettings.isShowShareQQ;
    localMoreItem.drawable = paramInt;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "QQ";
    }
    localMoreItem.text = str;
    localMoreItem.shareInMiniProcess = paramBoolean;
    this.mMoreItemList.add(localMoreItem);
    this.isShareQQPresent = true;
    return this;
  }
  
  public Builder addShareQzone(String paramString, int paramInt)
  {
    return addShareQzone(paramString, paramInt, false);
  }
  
  public Builder addShareQzone(String paramString, int paramInt, boolean paramBoolean)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.id = 2;
    localMoreItem.visible = this.mDisplaySettings.isShowShareQzone;
    localMoreItem.drawable = paramInt;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "QQ空间";
    }
    localMoreItem.text = str;
    localMoreItem.shareInMiniProcess = paramBoolean;
    this.mMoreItemList.add(localMoreItem);
    this.isShareQZonePresent = true;
    return this;
  }
  
  public Builder addShareWxFriends(String paramString, int paramInt)
  {
    return addShareWxFriends(paramString, paramInt, false);
  }
  
  public Builder addShareWxFriends(String paramString, int paramInt, boolean paramBoolean)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.id = 3;
    localMoreItem.visible = this.mDisplaySettings.isShowShareWxFriends;
    localMoreItem.drawable = paramInt;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "微信好友";
    }
    localMoreItem.text = str;
    localMoreItem.shareInMiniProcess = paramBoolean;
    this.mMoreItemList.add(localMoreItem);
    this.isShareWxFriendsPresent = true;
    return this;
  }
  
  public Builder addShareWxMoments(String paramString, int paramInt)
  {
    return addShareWxMoments(paramString, paramInt, false);
  }
  
  public Builder addShareWxMoments(String paramString, int paramInt, boolean paramBoolean)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.id = 4;
    localMoreItem.visible = this.mDisplaySettings.isShowShareWxMoments;
    localMoreItem.drawable = paramInt;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "微信朋友圈";
    }
    localMoreItem.text = str;
    localMoreItem.shareInMiniProcess = paramBoolean;
    this.mMoreItemList.add(localMoreItem);
    this.isShareWxMomentsPresent = true;
    return this;
  }
  
  public Builder addShortcut(String paramString, int paramInt)
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.id = 11;
    localMoreItem.visible = this.mDisplaySettings.isShowShortcut;
    localMoreItem.drawable = paramInt;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "添加到桌面";
    }
    localMoreItem.text = str;
    this.mMoreItemList.add(localMoreItem);
    return this;
  }
  
  public final MoreItemList build()
  {
    if (!this.isAboutPresent) {
      addAbout("关于", R.drawable.mini_sdk_about);
    }
    if (!this.isComplaintPresent) {
      addComplaint("举报", R.drawable.mini_sdk_browser_report);
    }
    return this.mMoreItemList;
  }
  
  public boolean isMyFavorite()
  {
    return this.mDisplaySettings.isMyFavorite;
  }
  
  public Builder setDisplaySettings(MoreItemList.DisplaySettings paramDisplaySettings)
  {
    this.mDisplaySettings = paramDisplaySettings;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ui.MoreItemList.Builder
 * JD-Core Version:    0.7.0.1
 */