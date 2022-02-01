package com.tencent.mobileqq.teamwork.spread;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocTipsConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocTipsConfigBean.KeyWords;
import com.tencent.mobileqq.config.business.tendoc.TencentDocTipsConfigBean.TeamworkKeyWords;
import com.tencent.mobileqq.config.business.tendoc.TencentDocTipsConfigProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class ConfigSetting
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TencentDocTipsConfigBean jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocTipsConfigBean;
  
  public ConfigSetting(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private TencentDocTipsConfigBean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocTipsConfigBean == null) {
      this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocTipsConfigBean = TencentDocTipsConfigProcessor.a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocTipsConfigBean;
  }
  
  private void a()
  {
    ThreadManager.executeOnSubThread(new ConfigSetting.1(this));
  }
  
  private void b(TencentDocTipsConfigBean paramTencentDocTipsConfigBean)
  {
    if (paramTencentDocTipsConfigBean == null) {
      return;
    }
    try
    {
      paramTencentDocTipsConfigBean.a(((ITeamWorkHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER)).getTemplateListByHttp());
      return;
    }
    catch (Exception paramTencentDocTipsConfigBean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getTemplateListFromCgi failed :");
      localStringBuilder.append(paramTencentDocTipsConfigBean.toString());
      QLog.e("ConfigSetting", 2, localStringBuilder.toString());
      paramTencentDocTipsConfigBean.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public TencentDocTipsConfigBean.TeamworkKeyWords a(String paramString)
  {
    Iterator localIterator = a().a().iterator();
    while (localIterator.hasNext())
    {
      TencentDocTipsConfigBean.TeamworkKeyWords localTeamworkKeyWords = (TencentDocTipsConfigBean.TeamworkKeyWords)localIterator.next();
      if (localTeamworkKeyWords.jdField_a_of_type_JavaLangString.contains(paramString)) {
        return localTeamworkKeyWords;
      }
    }
    return null;
  }
  
  public String a(BaseTimAIOTipsProcessor paramBaseTimAIOTipsProcessor)
  {
    Object localObject2;
    Object localObject1;
    if ((!(paramBaseTimAIOTipsProcessor instanceof BuddyFileAIOMsgTips)) && (!(paramBaseTimAIOTipsProcessor instanceof TroopFileAIOMsgTips)))
    {
      if ((paramBaseTimAIOTipsProcessor instanceof TeamWorkTextMsgTipsProcessor))
      {
        localObject2 = a().a();
        localObject1 = a().a();
        paramBaseTimAIOTipsProcessor = paramBaseTimAIOTipsProcessor.a();
        localObject2 = ((List)localObject2).iterator();
      }
    }
    else {
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (TencentDocTipsConfigBean.TeamworkKeyWords)((Iterator)localObject2).next();
        if ((paramBaseTimAIOTipsProcessor.contains(((TencentDocTipsConfigBean.TeamworkKeyWords)localObject3).jdField_a_of_type_JavaLangString)) && (((SparseArray)localObject1).valueAt(((TencentDocTipsConfigBean.TeamworkKeyWords)localObject3).b) != null))
        {
          return ((TencentDocTipsConfigBean.KeyWords)((SparseArray)localObject1).valueAt(((TencentDocTipsConfigBean.TeamworkKeyWords)localObject3).b)).jdField_a_of_type_JavaLangString;
          localObject1 = a().a();
          paramBaseTimAIOTipsProcessor = FileUtil.a(paramBaseTimAIOTipsProcessor.a());
          localObject2 = ((Map)localObject1).keySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (TencentDocTipsConfigBean.KeyWords)((Map)localObject1).get((String)((Iterator)localObject2).next());
            String[] arrayOfString = ((TencentDocTipsConfigBean.KeyWords)localObject3).jdField_b_of_type_ArrayOfJavaLangString;
            int j = arrayOfString.length;
            int i = 0;
            while (i < j)
            {
              if (arrayOfString[i].equalsIgnoreCase(paramBaseTimAIOTipsProcessor)) {
                return ((TencentDocTipsConfigBean.KeyWords)localObject3).jdField_a_of_type_JavaLangString;
              }
              i += 1;
            }
          }
        }
      }
    }
    return "";
  }
  
  public void a(TencentDocTipsConfigBean paramTencentDocTipsConfigBean)
  {
    if (paramTencentDocTipsConfigBean == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocTipsConfigBean = paramTencentDocTipsConfigBean;
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (TextUtils.isEmpty(localTicketManager.getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "docs.qq.com")))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramTencentDocTipsConfigBean = new ConfigSetting.LocalWtTicketPromise(this, paramTencentDocTipsConfigBean);
      localTicketManager.getPskey(str, 16L, new String[] { "docs.qq.com" }, paramTencentDocTipsConfigBean);
      return;
    }
    ThreadManager.excute(new ConfigSetting.2(this, paramTencentDocTipsConfigBean), 128, null, false);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForText)) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    this.jdField_a_of_type_Int += 1;
    ThreadManager.executeOnSubThread(new ConfigSetting.3(this));
  }
  
  public boolean a()
  {
    return System.currentTimeMillis() - this.jdField_a_of_type_Long > a().b() * 1000;
  }
  
  public String[] a(BaseTimAIOTipsProcessor paramBaseTimAIOTipsProcessor)
  {
    Map localMap = a().a();
    Object localObject = a().a();
    boolean bool = paramBaseTimAIOTipsProcessor instanceof BuddyFileAIOMsgTips;
    int i = 0;
    if ((!bool) && (!(paramBaseTimAIOTipsProcessor instanceof TroopFileAIOMsgTips)))
    {
      paramBaseTimAIOTipsProcessor = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        paramBaseTimAIOTipsProcessor[i] = ((TencentDocTipsConfigBean.TeamworkKeyWords)((List)localObject).get(i)).jdField_a_of_type_JavaLangString;
        i += 1;
      }
      return paramBaseTimAIOTipsProcessor;
    }
    paramBaseTimAIOTipsProcessor = FileUtil.a(paramBaseTimAIOTipsProcessor.a());
    localObject = localMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      TencentDocTipsConfigBean.KeyWords localKeyWords = (TencentDocTipsConfigBean.KeyWords)localMap.get((String)((Iterator)localObject).next());
      String[] arrayOfString = localKeyWords.jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramBaseTimAIOTipsProcessor)) {
          return localKeyWords.jdField_a_of_type_ArrayOfJavaLangString;
        }
        i += 1;
      }
    }
    return new String[0];
  }
  
  public String b(BaseTimAIOTipsProcessor paramBaseTimAIOTipsProcessor)
  {
    Object localObject2;
    Object localObject1;
    if ((!(paramBaseTimAIOTipsProcessor instanceof BuddyFileAIOMsgTips)) && (!(paramBaseTimAIOTipsProcessor instanceof TroopFileAIOMsgTips)))
    {
      if ((paramBaseTimAIOTipsProcessor instanceof TeamWorkTextMsgTipsProcessor))
      {
        localObject2 = a().a();
        localObject1 = a().a();
        paramBaseTimAIOTipsProcessor = paramBaseTimAIOTipsProcessor.a();
        localObject2 = ((List)localObject2).iterator();
      }
    }
    else {
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (TencentDocTipsConfigBean.TeamworkKeyWords)((Iterator)localObject2).next();
        if ((paramBaseTimAIOTipsProcessor.contains(((TencentDocTipsConfigBean.TeamworkKeyWords)localObject3).jdField_a_of_type_JavaLangString)) && (((SparseArray)localObject1).valueAt(((TencentDocTipsConfigBean.TeamworkKeyWords)localObject3).b) != null))
        {
          return ((TencentDocTipsConfigBean.KeyWords)((SparseArray)localObject1).valueAt(((TencentDocTipsConfigBean.TeamworkKeyWords)localObject3).b)).jdField_b_of_type_JavaLangString;
          localObject1 = a().a();
          paramBaseTimAIOTipsProcessor = FileUtil.a(paramBaseTimAIOTipsProcessor.a());
          localObject2 = ((Map)localObject1).keySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (TencentDocTipsConfigBean.KeyWords)((Map)localObject1).get((String)((Iterator)localObject2).next());
            String[] arrayOfString = ((TencentDocTipsConfigBean.KeyWords)localObject3).jdField_b_of_type_ArrayOfJavaLangString;
            int j = arrayOfString.length;
            int i = 0;
            while (i < j)
            {
              if (arrayOfString[i].equalsIgnoreCase(paramBaseTimAIOTipsProcessor)) {
                return ((TencentDocTipsConfigBean.KeyWords)localObject3).jdField_b_of_type_JavaLangString;
              }
              i += 1;
            }
          }
        }
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.ConfigSetting
 * JD-Core Version:    0.7.0.1
 */