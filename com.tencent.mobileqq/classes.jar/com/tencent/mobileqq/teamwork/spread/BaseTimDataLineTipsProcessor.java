package com.tencent.mobileqq.teamwork.spread;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocDataLineTipsConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocDataLineTipsConfigProcessor;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.StringTokenizer;

public abstract class BaseTimDataLineTipsProcessor
{
  protected int a;
  protected QQAppInterface a;
  protected DataLineMsgRecord a;
  protected ConfigSettingForDataLine a;
  protected String a;
  
  public BaseTimDataLineTipsProcessor(QQAppInterface paramQQAppInterface, DataLineMsgRecord paramDataLineMsgRecord, ConfigSettingForDataLine paramConfigSettingForDataLine)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord = paramDataLineMsgRecord;
    this.jdField_a_of_type_JavaLangString = paramDataLineMsgRecord.frienduin;
    this.jdField_a_of_type_Int = paramDataLineMsgRecord.istroop;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSettingForDataLine = paramConfigSettingForDataLine;
  }
  
  protected abstract String a();
  
  protected boolean a()
  {
    Object localObject = TencentDocDataLineTipsConfigProcessor.a().a();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.i("BaseTimDataLineTipsProcessor", 1, "config filetype is null, or maybe has not recv");
      }
      return false;
    }
    String str = FileUtil.a(a());
    localObject = new StringTokenizer((String)localObject, "|");
    if (!((StringTokenizer)localObject).hasMoreTokens())
    {
      if (QLog.isColorLevel()) {
        QLog.i("BaseTimDataLineTipsProcessor", 1, "config filetype is null");
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
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.BaseTimDataLineTipsProcessor
 * JD-Core Version:    0.7.0.1
 */