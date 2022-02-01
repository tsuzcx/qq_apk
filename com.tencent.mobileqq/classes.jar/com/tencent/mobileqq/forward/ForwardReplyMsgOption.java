package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMultiForwardFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.replymsg.ForwardMsgManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class ForwardReplyMsgOption
  extends ForwardTextOption
{
  private ChatMessage a;
  
  public ForwardReplyMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public static void a(ForwardBaseOption paramForwardBaseOption, long paramLong)
  {
    String str2 = paramForwardBaseOption.B();
    String str1 = str2;
    if (!TextUtils.isEmpty(str2)) {
      if (str2.startsWith(HardCodeUtil.a(2131902776)))
      {
        str1 = str2.substring(4);
      }
      else
      {
        str1 = str2;
        if (str2.startsWith(HardCodeUtil.a(2131902771))) {
          str1 = str2.substring(3);
        }
      }
    }
    str2 = paramForwardBaseOption.t.getString("uin");
    int i = paramForwardBaseOption.t.getInt("uintype", 0);
    Intent localIntent = new Intent();
    localIntent.setClass(paramForwardBaseOption.s, MiniChatActivity.class);
    localIntent.addFlags(268435456);
    localIntent.putExtra("uin", str2);
    localIntent.putExtra("uintype", i);
    localIntent.putExtra("uinname", str1);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("minaio_scaled_ration", paramForwardBaseOption.a(0.78F));
    localIntent.putExtra("minaio_height_ration", 0.86F);
    localIntent.putExtra("member_dialog_title", str1);
    localIntent.putExtra("structmsg_uniseq", paramLong);
    localIntent.putExtra("multi_forward_title", HardCodeUtil.a(2131902770));
    localIntent.putExtra("multi_forward_type", 3);
    localIntent.putExtra("key_mini_from", 4);
    PublicFragmentActivity.Launcher.a(paramForwardBaseOption.s, localIntent, MiniChatActivity.class, MiniMultiForwardFragment.class);
  }
  
  protected View a()
  {
    View localView = super.a();
    if (this.a != null) {
      localView.findViewById(2131433656).setOnClickListener(new ForwardReplyMsgOption.1(this));
    }
    return localView;
  }
  
  protected boolean b(String paramString1, String paramString2, int paramInt)
  {
    int i = ForwardOrderManager.a().b();
    this.t.putInt("KEY_MSG_FORWARD_ID", i);
    return super.b(paramString1, paramString2, paramInt);
  }
  
  protected void c()
  {
    if (ag()) {
      this.C.add(e);
    }
    if (ah()) {
      this.C.add(d);
    }
    if (ai()) {
      this.C.add(c);
    }
  }
  
  public boolean e()
  {
    boolean bool = super.e();
    long l = this.t.getLong("FORWARD_MSG_UNISEQ", -1L);
    if (l == -1L) {
      return bool;
    }
    this.a = ((ForwardMsgManager)this.q.getManager(QQManagerFactory.FORWARD_MSG_MANAGER)).a(l);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ForwardReplyMsgOption preloadData mChatMessage=");
      localStringBuilder.append(this.a);
      QLog.d("ForwardReplyMsgOption", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public String n()
  {
    String str = super.n();
    Object localObject = str;
    if (this.a != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131902772));
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardReplyMsgOption
 * JD-Core Version:    0.7.0.1
 */