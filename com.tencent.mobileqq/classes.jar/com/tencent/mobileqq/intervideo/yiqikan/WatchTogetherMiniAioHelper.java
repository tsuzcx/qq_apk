package com.tencent.mobileqq.intervideo.yiqikan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUnreadQIPCClient;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniEntryViewManager;
import com.tencent.mobileqq.activity.miniaio.MiniMsgBusinessInfo;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class WatchTogetherMiniAioHelper
  implements View.OnClickListener
{
  AIOUnreadQIPCClient a = AIOUnreadQIPCClient.a();
  MiniMsgUserParam b;
  private Activity c;
  private String d;
  private String e;
  private View f;
  private WindowManager.LayoutParams g;
  private WindowManager h;
  
  public WatchTogetherMiniAioHelper(Activity paramActivity, String paramString1, String paramString2, MiniMsgUserParam paramMiniMsgUserParam)
  {
    this.c = paramActivity;
    this.d = paramString1;
    this.b = paramMiniMsgUserParam;
    this.e = paramString2;
  }
  
  public void a()
  {
    if (this.f == null)
    {
      this.f = View.inflate(this.c.getApplicationContext(), 2131629661, null);
      this.f.setOnClickListener(this);
      Object localObject1 = ((ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class)).getAvatarAddress("", this.d, 0);
      AbsDownloader.getFile((String)localObject1);
      Object localObject3 = (RelativeLayout)this.f.findViewById(2131438586);
      URLImageView localURLImageView = (URLImageView)this.f.findViewById(2131438587);
      Object localObject2 = (TextView)this.f.findViewById(2131438588);
      localObject3 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject3).getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localURLImageView.getLayoutParams();
      localObject2 = (RelativeLayout.LayoutParams)((TextView)localObject2).getLayoutParams();
      int i = ViewUtils.dpToPx(32.0F);
      int j = ViewUtils.dpToPx(28.0F);
      ((RelativeLayout.LayoutParams)localObject3).width = i;
      ((RelativeLayout.LayoutParams)localObject3).height = j;
      i = ViewUtils.dpToPx(24.0F);
      localLayoutParams.width = i;
      localLayoutParams.height = i;
      localLayoutParams.leftMargin = ViewUtils.dpToPx(4.0F);
      localURLImageView.setPadding(0, 0, 0, 0);
      localURLImageView.setBackgroundDrawable(null);
      localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, null));
      if (AppSetting.e) {
        AccessibilityUtil.b(this.f, false);
      }
      this.h = ((WindowManager)this.c.getApplicationContext().getSystemService("window"));
      this.g = new WindowManager.LayoutParams();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("is activity window focused ");
        ((StringBuilder)localObject1).append(this.c.hasWindowFocus());
        QLog.d("WatchTogetherMiniAioHelper", 0, ((StringBuilder)localObject1).toString());
      }
      i = this.b.positionX;
      j = this.b.positionY;
      localObject1 = this.g;
      ((WindowManager.LayoutParams)localObject1).type = 1002;
      ((WindowManager.LayoutParams)localObject1).format = 1;
      ((WindowManager.LayoutParams)localObject1).flags = 40;
      ((WindowManager.LayoutParams)localObject1).gravity = 51;
      ((WindowManager.LayoutParams)localObject1).x = i;
      ((WindowManager.LayoutParams)localObject1).y = j;
      ((WindowManager.LayoutParams)localObject1).width = -2;
      ((WindowManager.LayoutParams)localObject1).height = -2;
      ((WindowManager.LayoutParams)localObject1).token = this.c.getWindow().getDecorView().getWindowToken();
      this.h.addView(this.f, this.g);
    }
    this.f.setVisibility(0);
  }
  
  public void b()
  {
    if (this.b != null)
    {
      MiniMsgIPCClient.getInstance();
      MiniMsgIPCClient.register(this.b.businessName, BaseApplicationImpl.getApplication().getQQProcessName());
      MiniMsgIPCClient.getInstance().syncGetUnread();
      MiniMsgIPCClient.getInstance();
      MiniMsgIPCClient.onProcessForeGround(this.b.businessName);
    }
  }
  
  public void c()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if ((((MiniMsgUserParam)localObject).accessType == 0) && (this.b.entryType == 0))
      {
        localObject = MiniMsgIPCClient.getInstance().getBusinessInfo(this.b.businessName);
        if (localObject != null)
        {
          int[] arrayOfInt = ((MiniEntryViewManager)this.b.unreadCallback).a();
          if (arrayOfInt != null)
          {
            ((MiniMsgBusinessInfo)localObject).e = arrayOfInt[0];
            ((MiniMsgBusinessInfo)localObject).f = arrayOfInt[1];
          }
        }
      }
      MiniMsgIPCClient.getInstance();
      MiniMsgIPCClient.onProcessBackground(this.b.businessName);
    }
  }
  
  public void d() {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (((MiniMsgUserParam)localObject).actionCallback != null) {
        this.b.actionCallback.onOpenMiniAIOCallback();
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_mini_need_update_unread", true);
      ((Intent)localObject).putExtra("key_mini_msgtab_businame", this.b.businessName);
      ((Intent)localObject).putExtra("key_mini_msgtab_type", this.b.filterMsgType);
      ((Intent)localObject).putExtra("key_mini_msgtab_need_full_screen", this.b.isNeedFullScreen);
      ((Intent)localObject).putExtra("key_mini_msgtab_isneed_back_conversation", this.b.isNeedBackConversation);
      if (this.b.isNeedBackConversation) {
        ((Intent)localObject).putExtra("key_mini_msgtab_back_pending_intent", this.b.backConversationIntent);
      }
      MiniChatActivity.a(this.c, 1, this.d, this.e);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherMiniAioHelper
 * JD-Core Version:    0.7.0.1
 */