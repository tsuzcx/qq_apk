package com.tencent.mobileqq.model;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

class ChatBackgroundManager$1
  extends IPCDownloadListener
{
  ChatBackgroundManager$1(ChatBackgroundManager paramChatBackgroundManager, String paramString, int paramInt1, int paramInt2) {}
  
  public void a(long paramLong, int paramInt, Bundle paramBundle)
  {
    super.a(paramLong, paramInt, paramBundle);
    paramBundle = new StringBuilder();
    paramBundle.append(paramLong);
    paramBundle.append("");
    paramBundle = ChatBackgroundUtil.a(true, paramBundle.toString());
    if (new File(paramBundle).exists()) {
      ChatBackgroundUtil.a(this.jdField_a_of_type_ComTencentMobileqqModelChatBackgroundManager.a.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqModelChatBackgroundManager.a.getCurrentUin(), this.jdField_a_of_type_JavaLangString, paramBundle, this.jdField_a_of_type_Int, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.model.ChatBackgroundManager.1
 * JD-Core Version:    0.7.0.1
 */