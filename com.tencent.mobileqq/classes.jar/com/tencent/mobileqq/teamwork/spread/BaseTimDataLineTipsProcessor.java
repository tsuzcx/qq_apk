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
  protected QQAppInterface a;
  protected String b;
  protected int c;
  protected DataLineMsgRecord d;
  protected ConfigSettingForDataLine e;
  
  public BaseTimDataLineTipsProcessor(QQAppInterface paramQQAppInterface, DataLineMsgRecord paramDataLineMsgRecord, ConfigSettingForDataLine paramConfigSettingForDataLine)
  {
    this.a = paramQQAppInterface;
    this.d = paramDataLineMsgRecord;
    this.b = paramDataLineMsgRecord.frienduin;
    this.c = paramDataLineMsgRecord.istroop;
    this.e = paramConfigSettingForDataLine;
  }
  
  protected abstract String a();
  
  protected boolean b()
  {
    Object localObject = TencentDocDataLineTipsConfigProcessor.a().c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.BaseTimDataLineTipsProcessor
 * JD-Core Version:    0.7.0.1
 */