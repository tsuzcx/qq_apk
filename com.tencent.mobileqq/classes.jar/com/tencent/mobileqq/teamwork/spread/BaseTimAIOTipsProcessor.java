package com.tencent.mobileqq.teamwork.spread;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.StringTokenizer;

public abstract class BaseTimAIOTipsProcessor
{
  public int a;
  public QQAppInterface a;
  public ChatMessage a;
  public ConfigSetting a;
  public String a;
  
  public BaseTimAIOTipsProcessor(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, ConfigSetting paramConfigSetting)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_JavaLangString = paramChatMessage.frienduin;
    this.jdField_a_of_type_Int = paramChatMessage.istroop;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting = paramConfigSetting;
  }
  
  public abstract String a();
  
  public abstract void a(BaseTimAIOTipsProcessor.ListResult paramListResult);
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting.a();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      if (QLog.isColorLevel()) {
        QLog.i("BaseTimAIOTipsProcessor", 1, "config filetype is null, or maybe has not recv");
      }
    }
    String str;
    do
    {
      while (!((StringTokenizer)localObject).hasMoreTokens())
      {
        do
        {
          return false;
          str = FileUtil.a(a());
          localObject = new StringTokenizer((String)localObject, "|");
          if (((StringTokenizer)localObject).hasMoreTokens()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("BaseTimAIOTipsProcessor", 1, "config filetype is null");
        return false;
      }
    } while (!str.equalsIgnoreCase(((StringTokenizer)localObject).nextToken()));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.BaseTimAIOTipsProcessor
 * JD-Core Version:    0.7.0.1
 */