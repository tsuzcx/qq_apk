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
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
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
  QQAppInterface a;
  private int b;
  private TencentDocDataLineTipsConfigBean c;
  private long d;
  
  public ConfigSettingForDataLine(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    c();
  }
  
  private void b(TencentDocDataLineTipsConfigBean paramTencentDocDataLineTipsConfigBean)
  {
    if (paramTencentDocDataLineTipsConfigBean == null) {
      return;
    }
    try
    {
      paramTencentDocDataLineTipsConfigBean.a(((ITeamWorkHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER)).getTemplateListByHttp());
      return;
    }
    catch (Exception paramTencentDocDataLineTipsConfigBean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getTemplateListFromCgi failed :");
      localStringBuilder.append(paramTencentDocDataLineTipsConfigBean.toString());
      QLog.e("ConfigSettingForDataLine", 2, localStringBuilder.toString());
      paramTencentDocDataLineTipsConfigBean.printStackTrace();
    }
  }
  
  private void c()
  {
    ThreadManager.executeOnSubThread(new ConfigSettingForDataLine.2(this));
  }
  
  private TencentDocDataLineTipsConfigBean d()
  {
    if (this.c == null) {
      this.c = TencentDocDataLineTipsConfigProcessor.a();
    }
    return this.c;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public void a(TencentDocDataLineTipsConfigBean paramTencentDocDataLineTipsConfigBean)
  {
    if (paramTencentDocDataLineTipsConfigBean == null) {
      return;
    }
    this.c = paramTencentDocDataLineTipsConfigBean;
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (TextUtils.isEmpty(localTicketManager.getPskey(this.a.getCurrentAccountUin(), "docs.qq.com")))
    {
      String str = this.a.getCurrentAccountUin();
      paramTencentDocDataLineTipsConfigBean = new ConfigSettingForDataLine.LocalWtTicketPromise(this, paramTencentDocDataLineTipsConfigBean);
      localTicketManager.getPskey(str, 16L, new String[] { "docs.qq.com" }, paramTencentDocDataLineTipsConfigBean);
      return;
    }
    ThreadManager.excute(new ConfigSettingForDataLine.1(this, paramTencentDocDataLineTipsConfigBean), 128, null, false);
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    this.d = System.currentTimeMillis();
    this.b += 1;
    ThreadManager.executeOnSubThread(new ConfigSettingForDataLine.3(this));
  }
  
  public String[] a(BaseTimDataLineTipsProcessor paramBaseTimDataLineTipsProcessor)
  {
    Map localMap = d().e();
    Object localObject = d().f();
    boolean bool = paramBaseTimDataLineTipsProcessor instanceof BuddyFileDataLineMsgTips;
    int i = 0;
    if (bool)
    {
      paramBaseTimDataLineTipsProcessor = FileUtil.a(paramBaseTimDataLineTipsProcessor.a());
      localObject = localMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        TencentDocDataLineTipsConfigBean.KeyWords localKeyWords = (TencentDocDataLineTipsConfigBean.KeyWords)localMap.get((String)((Iterator)localObject).next());
        String[] arrayOfString = localKeyWords.d;
        int j = arrayOfString.length;
        i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(paramBaseTimDataLineTipsProcessor)) {
            return localKeyWords.a;
          }
          i += 1;
        }
      }
      return new String[0];
    }
    paramBaseTimDataLineTipsProcessor = new String[((List)localObject).size()];
    while (i < ((List)localObject).size())
    {
      paramBaseTimDataLineTipsProcessor[i] = ((TencentDocDataLineTipsConfigBean.TeamworkKeyWords)((List)localObject).get(i)).a;
      i += 1;
    }
    return paramBaseTimDataLineTipsProcessor;
  }
  
  public String b(BaseTimDataLineTipsProcessor paramBaseTimDataLineTipsProcessor)
  {
    if ((paramBaseTimDataLineTipsProcessor instanceof BuddyFileDataLineMsgTips))
    {
      Map localMap = d().e();
      paramBaseTimDataLineTipsProcessor = FileUtil.a(paramBaseTimDataLineTipsProcessor.a());
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        TencentDocDataLineTipsConfigBean.KeyWords localKeyWords = (TencentDocDataLineTipsConfigBean.KeyWords)localMap.get((String)localIterator.next());
        String[] arrayOfString = localKeyWords.d;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(paramBaseTimDataLineTipsProcessor)) {
            return localKeyWords.b;
          }
          i += 1;
        }
      }
    }
    return "";
  }
  
  public boolean b()
  {
    long l = System.currentTimeMillis();
    BaseApplication localBaseApplication = this.a.getApp();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.getCurrentAccountUin());
    ((StringBuilder)localObject).append("_m_str_teamwork_dataline_tips_sp");
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = false;
    this.d = localBaseApplication.getSharedPreferences((String)localObject, 0).getLong("file_str_lstat_show_time_local", 0L);
    if (l - this.d > d().b() * 1000) {
      bool = true;
    }
    return bool;
  }
  
  public String c(BaseTimDataLineTipsProcessor paramBaseTimDataLineTipsProcessor)
  {
    if ((paramBaseTimDataLineTipsProcessor instanceof BuddyFileDataLineMsgTips))
    {
      Map localMap = d().e();
      paramBaseTimDataLineTipsProcessor = FileUtil.a(paramBaseTimDataLineTipsProcessor.a());
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        TencentDocDataLineTipsConfigBean.KeyWords localKeyWords = (TencentDocDataLineTipsConfigBean.KeyWords)localMap.get((String)localIterator.next());
        String[] arrayOfString = localKeyWords.d;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(paramBaseTimDataLineTipsProcessor)) {
            return localKeyWords.c;
          }
          i += 1;
        }
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.ConfigSettingForDataLine
 * JD-Core Version:    0.7.0.1
 */