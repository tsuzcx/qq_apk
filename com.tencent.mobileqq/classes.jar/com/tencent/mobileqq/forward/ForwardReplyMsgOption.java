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
    String str2 = paramForwardBaseOption.c();
    String str1 = str2;
    if (!TextUtils.isEmpty(str2)) {
      if (str2.startsWith(HardCodeUtil.a(2131704883)))
      {
        str1 = str2.substring(4);
      }
      else
      {
        str1 = str2;
        if (str2.startsWith(HardCodeUtil.a(2131704876))) {
          str1 = str2.substring(3);
        }
      }
    }
    str2 = paramForwardBaseOption.jdField_a_of_type_AndroidOsBundle.getString("uin");
    int i = paramForwardBaseOption.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 0);
    Intent localIntent = new Intent();
    localIntent.setClass(paramForwardBaseOption.jdField_a_of_type_AndroidAppActivity, MiniChatActivity.class);
    localIntent.addFlags(268435456);
    localIntent.putExtra("uin", str2);
    localIntent.putExtra("uintype", i);
    localIntent.putExtra("uinname", str1);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("minaio_scaled_ration", paramForwardBaseOption.a(0.78F));
    localIntent.putExtra("minaio_height_ration", 0.86F);
    localIntent.putExtra("member_dialog_title", str1);
    localIntent.putExtra("structmsg_uniseq", paramLong);
    localIntent.putExtra("multi_forward_title", HardCodeUtil.a(2131704875));
    localIntent.putExtra("multi_forward_type", 3);
    localIntent.putExtra("key_mini_from", 4);
    PublicFragmentActivity.Launcher.a(paramForwardBaseOption.jdField_a_of_type_AndroidAppActivity, localIntent, MiniChatActivity.class, MiniMultiForwardFragment.class);
  }
  
  protected View a()
  {
    View localView = super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
      localView.findViewById(2131367200).setOnClickListener(new ForwardReplyMsgOption.1(this));
    }
    return localView;
  }
  
  public String a()
  {
    String str = super.a();
    Object localObject = str;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131704877));
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public boolean a()
  {
    boolean bool = super.a();
    long l = this.jdField_a_of_type_AndroidOsBundle.getLong("FORWARD_MSG_UNISEQ", -1L);
    if (l == -1L) {
      return bool;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ForwardMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FORWARD_MSG_MANAGER)).a(l);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ForwardReplyMsgOption preloadData mChatMessage=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      QLog.d("ForwardReplyMsgOption", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  protected void b()
  {
    if (p()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (q()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (r()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
  }
  
  protected boolean b(String paramString1, String paramString2, int paramInt)
  {
    int i = ForwardOrderManager.a().a();
    this.jdField_a_of_type_AndroidOsBundle.putInt("KEY_MSG_FORWARD_ID", i);
    return super.b(paramString1, paramString2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardReplyMsgOption
 * JD-Core Version:    0.7.0.1
 */