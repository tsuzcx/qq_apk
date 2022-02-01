package com.tencent.mobileqq.portal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.springfestival.entry.ITaskManager;
import com.tencent.mobileqq.activity.springfestival.entry.model.BaseActivityData;
import com.tencent.mobileqq.activity.springfestival.entry.model.PendantData;
import com.tencent.mobileqq.activity.springfestival.entry.model.UserData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppPullInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.ARMapHongBaoListView.onPendentClickListener;

class ConversationHongBaoV2$18
  implements ARMapHongBaoListView.onPendentClickListener
{
  ConversationHongBaoV2$18(ConversationHongBaoV2 paramConversationHongBaoV2, String paramString, ARMapHongBaoListView paramARMapHongBaoListView, ITaskManager paramITaskManager, BaseActivityData paramBaseActivityData, int paramInt) {}
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showNormalActivityPendant onPendentClick jumpUrl = ");
      ((StringBuilder)localObject1).append(this.a);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.b.e())
    {
      this.b.h();
      localObject1 = this.c.a();
      ((UserData)localObject1).hasClickedHolder = true;
      this.c.b();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("  点击后 [showNormalActivityPendant] userData.hasClickedHolder =  ");
        ((StringBuilder)localObject2).append(((UserData)localObject1).hasClickedHolder);
        QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject2).toString());
      }
    }
    Object localObject1 = this.f;
    ((ConversationHongBaoV2)localObject1).f(((ConversationHongBaoV2)localObject1).B());
    localObject1 = this.d.pendantData;
    if ((localObject1 != null) && (((PendantData)localObject1).clickType == 2) && (!TextUtils.isEmpty(this.a))) {
      if ((!this.a.startsWith("http")) && (!this.a.startsWith("https")))
      {
        if ((ConversationHongBaoV2.q(this.f) instanceof BaseActivity))
        {
          localObject2 = JumpParser.a((QQAppInterface)this.f.q.aF, ConversationHongBaoV2.q(this.f), this.a);
          if (localObject2 != null) {
            ((JumpAction)localObject2).a();
          } else {
            ConversationHongBaoV2.q(this.f).startActivity(new Intent(ConversationHongBaoV2.q(this.f), JumpActivity.class).setData(Uri.parse(this.a)));
          }
        }
        else
        {
          ConversationHongBaoV2.q(this.f).startActivity(new Intent(ConversationHongBaoV2.q(this.f), JumpActivity.class).setData(Uri.parse(this.a)));
        }
      }
      else
      {
        localObject2 = new Intent(ConversationHongBaoV2.q(this.f), QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", this.a);
        ConversationHongBaoV2.q(this.f).startActivity((Intent)localObject2);
      }
    }
    Object localObject2 = this.f.q.y();
    if ((localObject1 != null) && (((PendantData)localObject1).clickType == 1) && (localObject2 != null)) {
      ((MiniAppPullInterface)localObject2).showMicroAppEntry();
    }
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showNormalActivityPendant onPendentCloseBtnClick fCloseType = ");
      localStringBuilder.append(this.e);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    this.f.g(false);
    if (this.e == 1)
    {
      ConversationHongBaoV2.f(this.f);
      this.b.f();
    }
    ConversationHongBaoV2.g(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2.18
 * JD-Core Version:    0.7.0.1
 */