package com.tencent.mobileqq.teamwork.spread;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocDataLineTipsConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocDataLineTipsConfigBean.KeyWords;
import com.tencent.mobileqq.config.business.tendoc.TencentDocDataLineTipsConfigBean.TeamworkKeyWords;
import com.tencent.mobileqq.config.business.tendoc.TencentDocDataLineTipsConfigProcessor;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.teamwork.TeamWorkHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class ConfigSettingForDataLine
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TencentDocDataLineTipsConfigBean jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocDataLineTipsConfigBean;
  
  public ConfigSettingForDataLine(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private TencentDocDataLineTipsConfigBean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocDataLineTipsConfigBean == null) {
      this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocDataLineTipsConfigBean = TencentDocDataLineTipsConfigProcessor.a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocDataLineTipsConfigBean;
  }
  
  private void a()
  {
    ThreadManager.executeOnSubThread(new ConfigSettingForDataLine.2(this));
  }
  
  private void b(TencentDocDataLineTipsConfigBean paramTencentDocDataLineTipsConfigBean)
  {
    if (paramTencentDocDataLineTipsConfigBean == null) {
      return;
    }
    try
    {
      paramTencentDocDataLineTipsConfigBean.a(((TeamWorkHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER)).a());
      return;
    }
    catch (Exception paramTencentDocDataLineTipsConfigBean)
    {
      QLog.e("ConfigSettingForDataLine", 2, " getTemplateListFromCgi failed :" + paramTencentDocDataLineTipsConfigBean.toString());
      paramTencentDocDataLineTipsConfigBean.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a(BaseTimDataLineTipsProcessor paramBaseTimDataLineTipsProcessor)
  {
    if ((paramBaseTimDataLineTipsProcessor instanceof BuddyFileDataLineMsgTips))
    {
      Map localMap = a().a();
      paramBaseTimDataLineTipsProcessor = FileUtil.a(paramBaseTimDataLineTipsProcessor.a());
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        TencentDocDataLineTipsConfigBean.KeyWords localKeyWords = (TencentDocDataLineTipsConfigBean.KeyWords)localMap.get((String)localIterator.next());
        String[] arrayOfString = localKeyWords.jdField_b_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(paramBaseTimDataLineTipsProcessor)) {
            return localKeyWords.jdField_a_of_type_JavaLangString;
          }
          i += 1;
        }
      }
    }
    return "";
  }
  
  public void a(TencentDocDataLineTipsConfigBean paramTencentDocDataLineTipsConfigBean)
  {
    if (paramTencentDocDataLineTipsConfigBean == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocDataLineTipsConfigBean = paramTencentDocDataLineTipsConfigBean;
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (TextUtils.isEmpty(localTicketManager.getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "docs.qq.com")))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramTencentDocDataLineTipsConfigBean = new ConfigSettingForDataLine.LocalWtTicketPromise(this, paramTencentDocDataLineTipsConfigBean);
      localTicketManager.getPskey(str, 16L, new String[] { "docs.qq.com" }, paramTencentDocDataLineTipsConfigBean);
      return;
    }
    ThreadManager.excute(new ConfigSettingForDataLine.1(this, paramTencentDocDataLineTipsConfigBean), 128, null, false);
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Int += 1;
    ThreadManager.executeOnSubThread(new ConfigSettingForDataLine.3(this));
  }
  
  public boolean a()
  {
    boolean bool = false;
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_m_str_teamwork_dataline_tips_sp", 0).getLong("file_str_lstat_show_time_local", 0L);
    if (l - this.jdField_a_of_type_Long > a().b() * 1000) {
      bool = true;
    }
    return bool;
  }
  
  public String[] a(BaseTimDataLineTipsProcessor paramBaseTimDataLineTipsProcessor)
  {
    int i = 0;
    Map localMap = a().a();
    Object localObject = a().a();
    if ((paramBaseTimDataLineTipsProcessor instanceof BuddyFileDataLineMsgTips))
    {
      paramBaseTimDataLineTipsProcessor = FileUtil.a(paramBaseTimDataLineTipsProcessor.a());
      localObject = localMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        TencentDocDataLineTipsConfigBean.KeyWords localKeyWords = (TencentDocDataLineTipsConfigBean.KeyWords)localMap.get((String)((Iterator)localObject).next());
        String[] arrayOfString = localKeyWords.jdField_b_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(paramBaseTimDataLineTipsProcessor)) {
            return localKeyWords.jdField_a_of_type_ArrayOfJavaLangString;
          }
          i += 1;
        }
      }
    }
    paramBaseTimDataLineTipsProcessor = new String[((List)localObject).size()];
    while (i < ((List)localObject).size())
    {
      paramBaseTimDataLineTipsProcessor[i] = ((TencentDocDataLineTipsConfigBean.TeamworkKeyWords)((List)localObject).get(i)).jdField_a_of_type_JavaLangString;
      i += 1;
    }
    return paramBaseTimDataLineTipsProcessor;
    return new String[0];
  }
  
  public String b(BaseTimDataLineTipsProcessor paramBaseTimDataLineTipsProcessor)
  {
    if ((paramBaseTimDataLineTipsProcessor instanceof BuddyFileDataLineMsgTips))
    {
      Map localMap = a().a();
      paramBaseTimDataLineTipsProcessor = FileUtil.a(paramBaseTimDataLineTipsProcessor.a());
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        TencentDocDataLineTipsConfigBean.KeyWords localKeyWords = (TencentDocDataLineTipsConfigBean.KeyWords)localMap.get((String)localIterator.next());
        String[] arrayOfString = localKeyWords.jdField_b_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(paramBaseTimDataLineTipsProcessor)) {
            return localKeyWords.jdField_b_of_type_JavaLangString;
          }
          i += 1;
        }
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.ConfigSettingForDataLine
 * JD-Core Version:    0.7.0.1
 */