package com.tencent.mobileqq.mini.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAIOEntranceProxy;

public class MiniAIOEntryView
  extends MiniAIOEntranceProxy
  implements IMiniMsgUnreadCallback, MiniMsgUser.IMiniMsgActionCallback
{
  private static final String TAG = "MiniAIOEntryView";
  private Activity activity;
  private MiniMsgUser mMiniMsgUser;
  private RelativeLayout miniAIOEntryView;
  private ImageView miniAIOIcon;
  private TextView miniAIOUnReadView;
  private String style;
  
  public MiniAIOEntryView(Context paramContext, String paramString)
  {
    super(paramContext);
    if ((paramContext instanceof Activity)) {
      this.activity = ((Activity)paramContext);
    }
    this.style = paramString;
    initAppBrandRuntime();
  }
  
  public void destroy()
  {
    this.miniAIOUnReadView = null;
    this.miniAIOEntryView = null;
  }
  
  public void hide()
  {
    if (this.miniAIOEntryView != null) {
      this.miniAIOEntryView.setVisibility(8);
    }
  }
  
  public void hideUnread()
  {
    if (this.miniAIOUnReadView != null) {
      this.miniAIOUnReadView.setVisibility(8);
    }
  }
  
  public void initAppBrandRuntime()
  {
    this.miniAIOEntryView = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131559419, null));
    this.miniAIOIcon = ((ImageView)this.miniAIOEntryView.findViewById(2131371182));
    this.miniAIOUnReadView = ((TextView)this.miniAIOEntryView.findViewById(2131371183));
    if ("black".equals(this.style)) {
      this.miniAIOIcon.setBackgroundResource(2130841026);
    }
    for (;;)
    {
      initMiniMsgUser();
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 36.0F), DisplayUtil.dip2px(getContext(), 36.0F));
      localLayoutParams.topMargin = DisplayUtil.dip2px(getContext(), 9.0F);
      localLayoutParams.rightMargin = DisplayUtil.dip2px(getContext(), 12.5F);
      addView(this.miniAIOEntryView, localLayoutParams);
      return;
      this.miniAIOIcon.setBackgroundResource(2130841027);
    }
  }
  
  public void initMiniMsgUser()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 27;
    localMiniMsgUserParam.accessType = 1;
    localMiniMsgUserParam.filterMsgType = 1;
    localMiniMsgUserParam.isNeedBackConversation = true;
    localMiniMsgUserParam.unreadCallback = this;
    localMiniMsgUserParam.actionCallback = this;
    localMiniMsgUserParam.entryView = this.miniAIOEntryView;
    localMiniMsgUserParam.unreadView = this.miniAIOUnReadView;
    localMiniMsgUserParam.filterMsgType = 1;
    if (QLog.isColorLevel()) {
      QLog.d("MiniAIOEntryView", 2, "initMiniMsgUse");
    }
    if (this.activity != null)
    {
      this.mMiniMsgUser = new MiniMsgUser(this.activity, localMiniMsgUserParam);
      this.mMiniMsgUser.showEntry();
      this.mMiniMsgUser.onForeground();
    }
  }
  
  public void onDestroy()
  {
    this.miniAIOUnReadView = null;
    this.miniAIOEntryView = null;
  }
  
  public void onFromMiniAIOToAIO() {}
  
  public void onGoToConversation() {}
  
  public void onOpenMiniAIOCallback() {}
  
  public void onPause()
  {
    if (this.mMiniMsgUser != null)
    {
      this.mMiniMsgUser.hideEntry();
      this.mMiniMsgUser.onBackground();
    }
  }
  
  public void onResume()
  {
    if (this.mMiniMsgUser != null)
    {
      this.mMiniMsgUser.showEntry();
      this.mMiniMsgUser.onForeground();
    }
  }
  
  public void setMiniAIOStyle(String paramString)
  {
    if (this.miniAIOIcon == null) {
      return;
    }
    if ("black".equals(paramString))
    {
      this.miniAIOIcon.setBackgroundResource(2130841026);
      return;
    }
    this.miniAIOIcon.setBackgroundResource(2130841027);
  }
  
  public boolean show(int paramInt)
  {
    if (this.miniAIOEntryView != null)
    {
      this.miniAIOEntryView.setVisibility(0);
      updateUnreadCount(paramInt, false);
    }
    return true;
  }
  
  public void updateOnBackFromMiniAIO(Bundle paramBundle) {}
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    TextView localTextView = this.miniAIOUnReadView;
    if (localTextView == null) {}
    do
    {
      return;
      String str = String.valueOf(paramInt);
      if (paramInt > 99) {
        str = "99+";
      }
      localTextView.setText(str);
    } while (paramBoolean);
    if (paramInt <= 0)
    {
      localTextView.setVisibility(8);
      return;
    }
    localTextView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.ui.MiniAIOEntryView
 * JD-Core Version:    0.7.0.1
 */