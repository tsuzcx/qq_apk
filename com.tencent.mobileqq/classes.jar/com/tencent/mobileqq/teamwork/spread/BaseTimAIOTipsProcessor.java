package com.tencent.mobileqq.teamwork.spread;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocTipsConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocTipsConfigProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.StringTokenizer;

public abstract class BaseTimAIOTipsProcessor
{
  protected int a;
  protected QQAppInterface a;
  protected ChatMessage a;
  protected ConfigSetting a;
  protected String a;
  
  public BaseTimAIOTipsProcessor(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, ConfigSetting paramConfigSetting)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_JavaLangString = paramChatMessage.frienduin;
    this.jdField_a_of_type_Int = paramChatMessage.istroop;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting = paramConfigSetting;
  }
  
  protected abstract String a();
  
  protected abstract void a(BaseTimAIOTipsProcessor.ListResult paramListResult);
  
  protected boolean a()
  {
    Object localObject = TencentDocTipsConfigProcessor.a().c();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.i("BaseTimAIOTipsProcessor", 1, "config filetype is null, or maybe has not recv");
      }
      return false;
    }
    String str = FileUtil.a(a());
    localObject = new StringTokenizer((String)localObject, "|");
    if (!((StringTokenizer)localObject).hasMoreTokens())
    {
      if (QLog.isColorLevel()) {
        QLog.i("BaseTimAIOTipsProcessor", 1, "config filetype is null");
      }
      return false;
    }
    while (((StringTokenizer)localObject).hasMoreTokens()) {
      if (str.equalsIgnoreCase(((StringTokenizer)localObject).nextToken())) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.BaseTimAIOTipsProcessor
 * JD-Core Version:    0.7.0.1
 */