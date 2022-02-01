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
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  AIOUnreadQIPCClient jdField_a_of_type_ComTencentMobileqqActivityAioAIOUnreadQIPCClient = AIOUnreadQIPCClient.a();
  MiniMsgUserParam jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public WatchTogetherMiniAioHelper(Activity paramActivity, String paramString1, String paramString2, MiniMsgUserParam paramMiniMsgUserParam)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam = paramMiniMsgUserParam;
    this.b = paramString2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 2131563046, null);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      Object localObject1 = ((ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class)).getAvatarAddress("", this.jdField_a_of_type_JavaLangString, 0);
      AbsDownloader.getFile((String)localObject1);
      Object localObject3 = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371242);
      URLImageView localURLImageView = (URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371243);
      Object localObject2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371244);
      localObject3 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject3).getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localURLImageView.getLayoutParams();
      localObject2 = (RelativeLayout.LayoutParams)((TextView)localObject2).getLayoutParams();
      int i = ViewUtils.b(32.0F);
      int j = ViewUtils.b(28.0F);
      ((RelativeLayout.LayoutParams)localObject3).width = i;
      ((RelativeLayout.LayoutParams)localObject3).height = j;
      i = ViewUtils.b(24.0F);
      localLayoutParams.width = i;
      localLayoutParams.height = i;
      localLayoutParams.leftMargin = ViewUtils.b(4.0F);
      localURLImageView.setPadding(0, 0, 0, 0);
      localURLImageView.setBackgroundDrawable(null);
      localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, null));
      if (AppSetting.d) {
        AccessibilityUtil.b(this.jdField_a_of_type_AndroidViewView, false);
      }
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getApplicationContext().getSystemService("window"));
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("is activity window focused ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidAppActivity.hasWindowFocus());
        QLog.d("WatchTogetherMiniAioHelper", 0, ((StringBuilder)localObject1).toString());
      }
      i = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.positionX;
      j = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.positionY;
      localObject1 = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
      ((WindowManager.LayoutParams)localObject1).type = 1002;
      ((WindowManager.LayoutParams)localObject1).format = 1;
      ((WindowManager.LayoutParams)localObject1).flags = 40;
      ((WindowManager.LayoutParams)localObject1).gravity = 51;
      ((WindowManager.LayoutParams)localObject1).x = i;
      ((WindowManager.LayoutParams)localObject1).y = j;
      ((WindowManager.LayoutParams)localObject1).width = -2;
      ((WindowManager.LayoutParams)localObject1).height = -2;
      ((WindowManager.LayoutParams)localObject1).token = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getWindowToken();
      this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam != null)
    {
      MiniMsgIPCClient.getInstance();
      MiniMsgIPCClient.register(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.businessName, BaseApplicationImpl.getApplication().getQQProcessName());
      MiniMsgIPCClient.getInstance().syncGetUnread();
      MiniMsgIPCClient.getInstance();
      MiniMsgIPCClient.onProcessForeGround(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.businessName);
    }
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam;
    if (localObject != null)
    {
      if ((((MiniMsgUserParam)localObject).accessType == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.entryType == 0))
      {
        localObject = MiniMsgIPCClient.getInstance().getBusinessInfo(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.businessName);
        if (localObject != null)
        {
          int[] arrayOfInt = ((MiniEntryViewManager)this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.unreadCallback).a();
          if (arrayOfInt != null)
          {
            ((MiniMsgBusinessInfo)localObject).c = arrayOfInt[0];
            ((MiniMsgBusinessInfo)localObject).d = arrayOfInt[1];
          }
        }
      }
      MiniMsgIPCClient.getInstance();
      MiniMsgIPCClient.onProcessBackground(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.businessName);
    }
  }
  
  public void d() {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam;
    if (localObject != null)
    {
      if (((MiniMsgUserParam)localObject).actionCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.actionCallback.onOpenMiniAIOCallback();
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_mini_need_update_unread", true);
      ((Intent)localObject).putExtra("key_mini_msgtab_businame", this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.businessName);
      ((Intent)localObject).putExtra("key_mini_msgtab_type", this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.filterMsgType);
      ((Intent)localObject).putExtra("key_mini_msgtab_need_full_screen", this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.isNeedFullScreen);
      ((Intent)localObject).putExtra("key_mini_msgtab_isneed_back_conversation", this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.isNeedBackConversation);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.isNeedBackConversation) {
        ((Intent)localObject).putExtra("key_mini_msgtab_back_pending_intent", this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.backConversationIntent);
      }
      MiniChatActivity.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_JavaLangString, this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherMiniAioHelper
 * JD-Core Version:    0.7.0.1
 */