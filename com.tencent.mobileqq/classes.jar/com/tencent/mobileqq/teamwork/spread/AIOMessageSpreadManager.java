package com.tencent.mobileqq.teamwork.spread;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocTipsConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocTipsConfigBean.TeamworkKeyWords;
import com.tencent.mobileqq.config.business.tendoc.TencentDocTipsConfigProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
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
  long a = 0L;
  private QQAppInterface b;
  private ConfigSetting c;
  private BaseTimAIOTipsProcessor d = null;
  private String e = "https://docs.qq.com/scenario/createpad.html?";
  private long f;
  private List<MessageRecord> g = new ArrayList();
  
  public AIOMessageSpreadManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    this.c = new ConfigSetting(paramQQAppInterface);
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
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      if (paramString2.containsKey(localObject4))
      {
        Float localFloat = (Float)paramString2.get(localObject4);
        localFloat.floatValue();
        paramString2.put(localObject4, localFloat);
      }
      else
      {
        paramString2.put(localObject4, Float.valueOf(1.0F));
      }
      if (((LinkedHashSet)localObject1).add(localObject4)) {
        paramString1.add(localObject4);
      }
    }
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (localLinkedHashMap.containsKey(localObject3))
      {
        localObject4 = (Float)localLinkedHashMap.get(localObject3);
        ((Float)localObject4).floatValue();
        localLinkedHashMap.put(localObject3, localObject4);
      }
      else
      {
        localLinkedHashMap.put(localObject3, Float.valueOf(1.0F));
      }
      if (((LinkedHashSet)localObject1).add(localObject3)) {
        paramString1.add(localObject3);
      }
    }
    localObject1 = new ArrayList();
    localObject2 = new ArrayList();
    int j = 0;
    int i = 0;
    float f1;
    for (;;)
    {
      int k = paramString1.size();
      f1 = 0.0F;
      if (i >= k) {
        break;
      }
      localObject3 = (String)paramString1.get(i);
      if (paramString2.containsKey(localObject3)) {
        ((List)localObject1).add(Float.valueOf(((Float)paramString2.get(localObject3)).floatValue()));
      } else {
        ((List)localObject1).add(Float.valueOf(0.0F));
      }
      if (localLinkedHashMap.containsKey(localObject3)) {
        ((List)localObject2).add(Float.valueOf(((Float)localLinkedHashMap.get(localObject3)).floatValue()));
      } else {
        ((List)localObject2).add(Float.valueOf(0.0F));
      }
      i += 1;
    }
    if (((List)localObject1).size() != ((List)localObject2).size()) {
      return 0.0F;
    }
    if (((List)localObject1).size() == 0) {
      return 0.0F;
    }
    float f2 = 0.0F;
    float f3 = 0.0F;
    i = j;
    while (i < ((List)localObject1).size())
    {
      f3 += ((Float)((List)localObject1).get(i)).floatValue() * ((Float)((List)localObject2).get(i)).floatValue();
      f1 += ((Float)((List)localObject1).get(i)).floatValue() * ((Float)((List)localObject1).get(i)).floatValue();
      f2 += ((Float)((List)localObject2).get(i)).floatValue() * ((Float)((List)localObject2).get(i)).floatValue();
      i += 1;
    }
    return f3 / ((float)Math.pow(f1, 0.5D) * (float)Math.pow(f2, 0.5D));
  }
  
  private List<String> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    int k = paramString.length();
    int i = 0;
    while (i < k)
    {
      int j = i + 1;
      if (j < k)
      {
        if (a(paramString.charAt(i), paramString.charAt(j)))
        {
          localArrayList.add(new String(new char[] { paramString.charAt(i), paramString.charAt(j) }));
          i += 2;
          continue;
        }
        localArrayList.add(String.valueOf(paramString.charAt(i)));
      }
      else
      {
        localArrayList.add(String.valueOf(paramString.charAt(i)));
      }
      i = j;
    }
    return localArrayList;
  }
  
  private void a(ChatMessage paramChatMessage, String paramString1, String paramString2, String paramString3, TencentDocTipsConfigBean.TeamworkKeyWords paramTeamworkKeyWords)
  {
    if ((!this.c.b()) && (QLog.isColorLevel()))
    {
      QLog.i("AIOMessageSpreadManager", 1, "last insert time less");
      return;
    }
    if (QLog.isDebugVersion())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("insertGaryTips:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" link:");
      localStringBuilder.append(paramString2);
      QLog.i("AIOMessageSpreadManager", 1, localStringBuilder.toString());
    }
    this.c.a(paramChatMessage);
    new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new AIOMessageSpreadManager.2(this, paramChatMessage, paramString1, paramTeamworkKeyWords, paramString2, paramString3), 1000L);
  }
  
  static boolean a(char paramChar)
  {
    return (paramChar >= 55296) && (paramChar < 56320);
  }
  
  private boolean a(char paramChar1, char paramChar2)
  {
    return (a(paramChar1)) && (b(paramChar2));
  }
  
  static boolean b(char paramChar)
  {
    return (paramChar >= 56320) && (paramChar < 57344);
  }
  
  private boolean b(ChatMessage paramChatMessage)
  {
    int i = this.c.a();
    int j = TencentDocTipsConfigProcessor.a().b();
    if (j == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOMessageSpreadManager", 1, "config is max: 0, return");
      }
      return false;
    }
    if (i > j)
    {
      if (QLog.isColorLevel())
      {
        paramChatMessage = new StringBuilder();
        paramChatMessage.append("file count over[");
        paramChatMessage.append(i);
        paramChatMessage.append("], return");
        QLog.i("AIOMessageSpreadManager", 1, paramChatMessage.toString());
      }
      return false;
    }
    if ((paramChatMessage instanceof MessageForText))
    {
      boolean bool = TencentDocTipsConfigProcessor.a().a();
      if (QLog.isColorLevel())
      {
        paramChatMessage = new StringBuilder();
        paramChatMessage.append(" is Text Switch On:");
        paramChatMessage.append(bool);
        QLog.i("AIOMessageSpreadManager", 1, paramChatMessage.toString());
      }
      return bool;
    }
    return true;
  }
  
  public void a(TencentDocTipsConfigBean paramTencentDocTipsConfigBean)
  {
    this.c.a(paramTencentDocTipsConfigBean);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (QLog.isDebugVersion())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ready to post to SubThread Process， msgUid[");
      localStringBuilder.append(paramChatMessage.msgUid);
      localStringBuilder.append("], hashCode:");
      localStringBuilder.append(paramChatMessage.hashCode());
      QLog.i("AIOMessageSpreadManager", 4, localStringBuilder.toString());
      if (paramChatMessage.msgUid == 0L) {
        FileManagerUtil.d();
      }
    }
    if ((this.f == paramChatMessage.uniseq) && ((paramChatMessage instanceof MessageForText))) {
      return;
    }
    if ((paramChatMessage instanceof MessageForText)) {
      this.f = paramChatMessage.uniseq;
    }
    ThreadManager.executeOnSubThread(new AIOMessageSpreadManager.1(this, paramChatMessage));
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, SessionInfo paramSessionInfo)
  {
    String str = paramChatMessage.getExtInfoFromExtStr("tim_aio_file_msg_uiniseq");
    long l;
    try
    {
      l = Long.parseLong(str);
    }
    catch (Exception localException1)
    {
      QLog.e("AIOMessageSpreadManager", 1, localException1.toString());
      l = 0L;
    }
    Object localObject1 = this.b.getMessageFacade().b(paramChatMessage.frienduin, paramChatMessage.istroop, l);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AIOMessageSpreadManager", 1, "garyTips not find fileMsg");
      }
      return;
    }
    Object localObject2 = paramChatMessage.getExtInfoFromExtStr("tim_aio_tips_type");
    if (((String)localObject2).equalsIgnoreCase("keyword")) {
      ReportController.b(this.b, "dc00898", "", "", "0X8009078", "0X8009078", 0, 0, "", "", "", "");
    } else if (((String)localObject2).equalsIgnoreCase("precent")) {
      ReportController.b(this.b, "dc00898", "", "", "0X800907B", "0X800907B", 0, 0, "", "", "", "");
    } else if (((String)localObject2).equalsIgnoreCase("text_keyword")) {
      ReportController.b(this.b, "dc00898", "", "", "0X8009072", "0X800907B", 0, 0, "", "", "", "");
    }
    if ((localObject1 instanceof MessageForFile))
    {
      paramChatMessage = this.b.getFileManagerProxy().a(l, paramChatMessage.frienduin, paramChatMessage.istroop);
      if (paramChatMessage == null)
      {
        paramChatMessage = new StringBuilder();
        paramChatMessage.append("query Entity is nyll!!!, uniseq[");
        paramChatMessage.append(l);
        paramChatMessage.append("]");
        QLog.e("AIOMessageSpreadManager", 1, paramChatMessage.toString());
        return;
      }
      TeamWorkConvertUtils.a(paramChatMessage, paramContext, this.b, 2);
      return;
    }
    if ((localObject1 instanceof MessageForTroopFile))
    {
      paramChatMessage = (MessageForTroopFile)localObject1;
      localObject1 = TroopFileUtils.a(this.b, paramChatMessage);
      localObject2 = new TeamWorkFileImportInfo();
      ((TeamWorkFileImportInfo)localObject2).d = ((TroopFileStatusInfo)localObject1).k;
      ((TeamWorkFileImportInfo)localObject2).c = ((TroopFileStatusInfo)localObject1).t;
      ((TeamWorkFileImportInfo)localObject2).J = FileManagerUtil.c(((TroopFileStatusInfo)localObject1).t);
      ((TeamWorkFileImportInfo)localObject2).o = true;
      ((TeamWorkFileImportInfo)localObject2).n = 1;
      ((TeamWorkFileImportInfo)localObject2).K = paramChatMessage.fileSize;
      ((TeamWorkFileImportInfo)localObject2).g = ((TroopFileStatusInfo)localObject1).r;
      ((TeamWorkFileImportInfo)localObject2).h = ((TroopFileStatusInfo)localObject1).u;
      ((TeamWorkFileImportInfo)localObject2).j = paramSessionInfo.c;
      ((TeamWorkFileImportInfo)localObject2).b = paramSessionInfo.b;
      if (((TroopFileStatusInfo)localObject1).e != 12) {
        ((TeamWorkFileImportInfo)localObject2).m = true;
      }
      ((TeamWorkFileImportInfo)localObject2).a = 1;
      TeamWorkConvertUtils.a((TeamWorkFileImportInfo)localObject2, paramContext, this.b, ((TeamWorkFileImportInfo)localObject2).n);
      return;
    }
    if ((localObject1 instanceof MessageForText))
    {
      localObject1 = paramChatMessage.getExtInfoFromExtStr("tim_aio_tips_template_id");
      localObject2 = paramChatMessage.getExtInfoFromExtStr("tim_aio_tips_template_type");
      paramChatMessage = paramChatMessage.getExtInfoFromExtStr("tim_aio_tips_keyword");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        Bundle localBundle = new Bundle();
        TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
        try
        {
          if (Integer.parseInt((String)localObject2) == 0) {
            localTeamWorkFileImportInfo.u = 3;
          } else {
            localTeamWorkFileImportInfo.u = 6;
          }
        }
        catch (Exception localException2)
        {
          QLog.e("AIOMessageSpreadManager", 2, localException2.getMessage());
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.e);
        localStringBuilder.append("type=");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("&template_id=");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("&title=");
        localStringBuilder.append(paramChatMessage);
        localBundle.putString("url", localStringBuilder.toString());
        localBundle.putBoolean("doc_from_aio", true);
        localTeamWorkFileImportInfo.o = true;
        localTeamWorkFileImportInfo.n = 1;
        localTeamWorkFileImportInfo.a = paramSessionInfo.a;
        localTeamWorkFileImportInfo.b = paramSessionInfo.b;
        localTeamWorkFileImportInfo.j = paramSessionInfo.c;
        localTeamWorkFileImportInfo.s = true;
        localBundle.putParcelable("key_team_work_file_import_info", localTeamWorkFileImportInfo);
        localBundle.putString("tdsourcetag", "s_qq_aio_grey");
        TeamWorkDocEditBrowserActivity.a(paramContext, localBundle, false);
      }
    }
    else
    {
      QLog.e("AIOMessageSpreadManager", 1, "unknow msg type!");
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null)
    {
      QLog.e("AIOMessageSpreadManager", 1, FileManagerUtil.d());
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send file:");
      localStringBuilder.append(paramMessageRecord.msgUid);
      QLog.i("AIOMessageSpreadManager", 1, localStringBuilder.toString());
    }
    ThreadManager.getUIHandler().postDelayed(new AIOMessageSpreadManager.3(this), 1000L);
    try
    {
      this.g.add(paramMessageRecord);
      this.a = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append("lastInsertTime[");
        paramMessageRecord.append(this.a);
        paramMessageRecord.append("],lstCache size[");
        paramMessageRecord.append(this.g.size());
        paramMessageRecord.append("]");
        QLog.i("AIOMessageSpreadManager", 1, paramMessageRecord.toString());
      }
      return;
    }
    finally {}
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    String str = paramMessageRecord.getExtInfoFromExtStr("tim_aio_gary_uniseq");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("del garyTips id[");
      localStringBuilder.append(str);
      localStringBuilder.append("],targetId[");
      localStringBuilder.append(paramMessageRecord.msgUid);
      localStringBuilder.append("], hashCode:");
      localStringBuilder.append(paramMessageRecord.hashCode());
      QLog.i("AIOMessageSpreadManager", 1, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(str)) {
      try
      {
        long l = Long.parseLong(str);
        this.b.getMessageFacade().b(paramMessageRecord.frienduin, paramMessageRecord.istroop, l, true);
        return;
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        QLog.e("AIOMessageSpreadManager", 1, paramMessageRecord.toString());
      }
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager
 * JD-Core Version:    0.7.0.1
 */