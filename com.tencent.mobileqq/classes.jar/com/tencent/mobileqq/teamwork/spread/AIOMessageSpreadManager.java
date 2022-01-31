package com.tencent.mobileqq.teamwork.spread;

import aina;
import ainc;
import aind;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class AIOMessageSpreadManager
  implements Manager
{
  public long a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BaseTimAIOTipsProcessor jdField_a_of_type_ComTencentMobileqqTeamworkSpreadBaseTimAIOTipsProcessor;
  private ConfigSetting jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting;
  private String jdField_a_of_type_JavaLangString = ".docs.qq.com/ep/pad/newpad?opendocxfrom=qq&templateId=";
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString = ".docs.qq.com/ep/pad/newsheet?opendocxfrom=qq&templateId=";
  
  public AIOMessageSpreadManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting = new ConfigSetting(paramQQAppInterface);
  }
  
  private float a(String paramString1, String paramString2)
  {
    Object localObject3 = a(paramString1);
    Object localObject2 = a(paramString2);
    Object localObject1 = new LinkedHashSet();
    paramString1 = new ArrayList();
    paramString2 = new LinkedHashMap();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localObject3 = ((List)localObject3).iterator();
    Object localObject4;
    label148:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      if (paramString2.containsKey(localObject4))
      {
        Float localFloat = (Float)paramString2.get(localObject4);
        localFloat.floatValue();
        paramString2.put(localObject4, localFloat);
      }
      for (;;)
      {
        if (!((LinkedHashSet)localObject1).add(localObject4)) {
          break label148;
        }
        paramString1.add(localObject4);
        break;
        paramString2.put(localObject4, Float.valueOf(1.0F));
      }
    }
    localObject2 = ((List)localObject2).iterator();
    label254:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (localLinkedHashMap.containsKey(localObject3))
      {
        localObject4 = (Float)localLinkedHashMap.get(localObject3);
        ((Float)localObject4).floatValue();
        localLinkedHashMap.put(localObject3, localObject4);
      }
      for (;;)
      {
        if (!((LinkedHashSet)localObject1).add(localObject3)) {
          break label254;
        }
        paramString1.add(localObject3);
        break;
        localLinkedHashMap.put(localObject3, Float.valueOf(1.0F));
      }
    }
    localObject1 = new ArrayList();
    localObject2 = new ArrayList();
    int i = 0;
    if (i < paramString1.size())
    {
      localObject3 = (String)paramString1.get(i);
      if (paramString2.containsKey(localObject3))
      {
        ((List)localObject1).add(Float.valueOf(((Float)paramString2.get(localObject3)).floatValue()));
        label333:
        if (!localLinkedHashMap.containsKey(localObject3)) {
          break label391;
        }
        ((List)localObject2).add(Float.valueOf(((Float)localLinkedHashMap.get(localObject3)).floatValue()));
      }
      for (;;)
      {
        i += 1;
        break;
        ((List)localObject1).add(Float.valueOf(0.0F));
        break label333;
        label391:
        ((List)localObject2).add(Float.valueOf(0.0F));
      }
    }
    if (((List)localObject1).size() != ((List)localObject2).size()) {
      return 0.0F;
    }
    if (((List)localObject1).size() == 0) {
      return 0.0F;
    }
    float f3 = 0.0F;
    float f2 = 0.0F;
    float f1 = 0.0F;
    i = 0;
    while (i < ((List)localObject1).size())
    {
      float f4 = ((Float)((List)localObject1).get(i)).floatValue();
      f3 += ((Float)((List)localObject2).get(i)).floatValue() * f4;
      f4 = ((Float)((List)localObject1).get(i)).floatValue();
      f2 += ((Float)((List)localObject1).get(i)).floatValue() * f4;
      f4 = ((Float)((List)localObject2).get(i)).floatValue();
      f1 += ((Float)((List)localObject2).get(i)).floatValue() * f4;
      i += 1;
    }
    return f3 / ((float)Math.pow(f2, 0.5D) * (float)Math.pow(f1, 0.5D));
  }
  
  private List a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localArrayList;
      int j = paramString.length();
      int i = 0;
      while (i < j) {
        if (i + 1 < j)
        {
          if (a(paramString.charAt(i), paramString.charAt(i + 1)))
          {
            localArrayList.add(new String(new char[] { paramString.charAt(i), paramString.charAt(i + 1) }));
            i += 2;
          }
          else
          {
            localArrayList.add(String.valueOf(paramString.charAt(i)));
            i += 1;
          }
        }
        else
        {
          localArrayList.add(String.valueOf(paramString.charAt(i)));
          i += 1;
        }
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, String paramString1, String paramString2, String paramString3, ConfigSetting.TeamworkKeyWords paramTeamworkKeyWords)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting.b()) && (QLog.isColorLevel()))
    {
      QLog.i("AIOMessageSpreadManager", 1, "last insert time less");
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.i("AIOMessageSpreadManager", 1, "insertGaryTips:" + paramString1 + " link:" + paramString2);
    }
    this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting.a(paramChatMessage);
    new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new ainc(this, paramChatMessage, paramString1, paramTeamworkKeyWords, paramString2, paramString3), 1000L);
  }
  
  static boolean a(char paramChar)
  {
    return (paramChar >= 55296) && (paramChar < 56320);
  }
  
  private boolean a(char paramChar1, char paramChar2)
  {
    return (a(paramChar1)) && (b(paramChar2));
  }
  
  private boolean a(ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting.a();
    int j = this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting.b();
    if (j == 0) {
      if (QLog.isColorLevel()) {
        QLog.i("AIOMessageSpreadManager", 1, "config is max: 0, return");
      }
    }
    do
    {
      return false;
      if (i <= j) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("AIOMessageSpreadManager", 1, "file count over[" + i + "], return");
    return false;
    if ((paramChatMessage instanceof MessageForText))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOMessageSpreadManager", 1, " is Text Switch On:" + this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting.a());
      }
      return this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting.a();
    }
    return true;
  }
  
  static boolean b(char paramChar)
  {
    return (paramChar >= 56320) && (paramChar < 57344);
  }
  
  public void a(ConfigurationService.Config paramConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting.a(paramConfig);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (QLog.isDebugVersion())
    {
      QLog.i("AIOMessageSpreadManager", 4, "ready to post to SubThread Process， msgUid[" + paramChatMessage.msgUid + "], hashCode:" + paramChatMessage.hashCode());
      if (paramChatMessage.msgUid == 0L) {
        FileManagerUtil.a();
      }
    }
    if ((this.jdField_b_of_type_Long == paramChatMessage.uniseq) && ((paramChatMessage instanceof MessageForText))) {
      return;
    }
    if ((paramChatMessage instanceof MessageForText)) {
      this.jdField_b_of_type_Long = paramChatMessage.uniseq;
    }
    ThreadManager.executeOnSubThread(new aina(this, paramChatMessage));
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, SessionInfo paramSessionInfo)
  {
    Object localObject1 = paramChatMessage.getExtInfoFromExtStr("tim_aio_file_msg_uiniseq");
    String str;
    do
    {
      try
      {
        l = Long.parseLong((String)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage.frienduin, paramChatMessage.istroop, l);
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AIOMessageSpreadManager", 1, "garyTips not find fileMsg");
          }
          return;
        }
      }
      catch (Exception localException)
      {
        long l;
        for (;;)
        {
          QLog.e("AIOMessageSpreadManager", 1, localException.toString());
          l = 0L;
        }
        localObject3 = paramChatMessage.getExtInfoFromExtStr("tim_aio_tips_type");
        if (((String)localObject3).equalsIgnoreCase("keyword")) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009078", "0X8009078", 0, 0, "", "", "", "");
        }
        while ((localException instanceof MessageForFile))
        {
          paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l, paramChatMessage.frienduin, paramChatMessage.istroop);
          if (paramChatMessage == null)
          {
            QLog.e("AIOMessageSpreadManager", 1, "query Entity is nyll!!!, uniseq[" + l + "]");
            return;
            if (((String)localObject3).equalsIgnoreCase("precent")) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800907B", "0X800907B", 0, 0, "", "", "", "");
            } else if (((String)localObject3).equalsIgnoreCase("text_keyword")) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009072", "0X800907B", 0, 0, "", "", "", "");
            }
          }
          else
          {
            TeamWorkConvertUtils.a(paramChatMessage, paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4);
            return;
          }
        }
      }
      if ((localException instanceof MessageForTroopFile))
      {
        paramChatMessage = (MessageForTroopFile)localException;
        localObject2 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        localObject3 = new TeamWorkFileImportInfo();
        ((TeamWorkFileImportInfo)localObject3).jdField_c_of_type_JavaLangString = ((TroopFileStatusInfo)localObject2).jdField_a_of_type_JavaLangString;
        ((TeamWorkFileImportInfo)localObject3).jdField_b_of_type_JavaLangString = ((TroopFileStatusInfo)localObject2).g;
        ((TeamWorkFileImportInfo)localObject3).jdField_e_of_type_Int = FileManagerUtil.a(((TroopFileStatusInfo)localObject2).g);
        ((TeamWorkFileImportInfo)localObject3).jdField_b_of_type_Boolean = true;
        ((TeamWorkFileImportInfo)localObject3).jdField_c_of_type_Int = 1;
        ((TeamWorkFileImportInfo)localObject3).jdField_c_of_type_Long = paramChatMessage.fileSize;
        ((TeamWorkFileImportInfo)localObject3).jdField_d_of_type_JavaLangString = ((TroopFileStatusInfo)localObject2).jdField_e_of_type_JavaLangString;
        ((TeamWorkFileImportInfo)localObject3).jdField_b_of_type_Int = ((TroopFileStatusInfo)localObject2).jdField_e_of_type_Int;
        ((TeamWorkFileImportInfo)localObject3).jdField_e_of_type_JavaLangString = paramSessionInfo.jdField_b_of_type_JavaLangString;
        ((TeamWorkFileImportInfo)localObject3).jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
        if (((TroopFileStatusInfo)localObject2).jdField_b_of_type_Int != 12) {
          ((TeamWorkFileImportInfo)localObject3).jdField_a_of_type_Boolean = true;
        }
        ((TeamWorkFileImportInfo)localObject3).jdField_a_of_type_Int = 1;
        TeamWorkConvertUtils.a((TeamWorkFileImportInfo)localObject3, paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((TeamWorkFileImportInfo)localObject3).jdField_c_of_type_Int);
        return;
      }
      if (!(localObject2 instanceof MessageForText)) {
        break;
      }
      str = paramChatMessage.getExtInfoFromExtStr("tim_aio_tips_template_id");
      paramChatMessage = paramChatMessage.getExtInfoFromExtStr("tim_aio_tips_type");
    } while (TextUtils.isEmpty(str));
    Object localObject2 = new Bundle();
    Object localObject3 = new TeamWorkFileImportInfo();
    for (int i = 0;; i = j)
    {
      try
      {
        j = Integer.parseInt(paramChatMessage);
        if (j != 0) {
          break label672;
        }
        i = j;
        ((TeamWorkFileImportInfo)localObject3).jdField_d_of_type_Int = 3;
        i = j;
      }
      catch (Exception paramChatMessage)
      {
        for (;;)
        {
          int j;
          label672:
          QLog.e("AIOMessageSpreadManager", 2, paramChatMessage.getMessage());
          continue;
          paramChatMessage = "https://" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + this.jdField_b_of_type_JavaLangString + str;
        }
      }
      if (i != 0) {
        break;
      }
      paramChatMessage = "https://" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + this.jdField_a_of_type_JavaLangString + str;
      ((Bundle)localObject2).putString("url", paramChatMessage);
      ((TeamWorkFileImportInfo)localObject3).jdField_b_of_type_Boolean = true;
      ((TeamWorkFileImportInfo)localObject3).jdField_c_of_type_Int = 1;
      ((TeamWorkFileImportInfo)localObject3).jdField_a_of_type_Int = paramSessionInfo.jdField_a_of_type_Int;
      ((TeamWorkFileImportInfo)localObject3).jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
      ((TeamWorkFileImportInfo)localObject3).jdField_e_of_type_JavaLangString = paramSessionInfo.jdField_b_of_type_JavaLangString;
      ((TeamWorkFileImportInfo)localObject3).jdField_e_of_type_Boolean = true;
      ((Bundle)localObject2).putParcelable("key_team_work_file_import_info", (Parcelable)localObject3);
      TeamWorkDocEditBrowserActivity.a(paramContext, (Bundle)localObject2, false);
      return;
      i = j;
      ((TeamWorkFileImportInfo)localObject3).jdField_d_of_type_Int = 6;
    }
    QLog.e("AIOMessageSpreadManager", 1, "unknow msg type!");
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null)
    {
      QLog.e("AIOMessageSpreadManager", 1, FileManagerUtil.a());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AIOMessageSpreadManager", 1, "send file:" + paramMessageRecord.msgUid);
    }
    ThreadManager.getUIHandler().postDelayed(new aind(this), 1000L);
    try
    {
      this.jdField_a_of_type_JavaUtilList.add(paramMessageRecord);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("AIOMessageSpreadManager", 1, "lastInsertTime[" + this.jdField_a_of_type_Long + "],lstCache size[" + this.jdField_a_of_type_JavaUtilList.size() + "]");
      }
      return;
    }
    finally {}
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    String str = paramMessageRecord.getExtInfoFromExtStr("tim_aio_gary_uniseq");
    if (QLog.isColorLevel()) {
      QLog.i("AIOMessageSpreadManager", 1, "del garyTips id[" + str + "],targetId[" + paramMessageRecord.msgUid + "], hashCode:" + paramMessageRecord.hashCode());
    }
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      long l = Long.parseLong(str);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageRecord.frienduin, paramMessageRecord.istroop, l, true);
      return;
    }
    catch (Exception paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
      QLog.e("AIOMessageSpreadManager", 1, paramMessageRecord.toString());
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager
 * JD-Core Version:    0.7.0.1
 */