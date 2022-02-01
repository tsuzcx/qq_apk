package com.tencent.mobileqq.vas.troopkeyword;

import QC.GetUsrKeyWordInfoRsp;
import QC.OneKeyWordItemClient;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopKeyWord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.keyword.EntryStatus;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class TroopKeywordManager
{
  private static int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 0L;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap<String, List<TroopKeyWord>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public TroopKeywordManager(QQAppInterface paramQQAppInterface, EntityManager paramEntityManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
  }
  
  private long a()
  {
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = QVipConfigManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "troop_keyword_last_pull_timestamp", 0L);
    }
    return this.jdField_a_of_type_Long;
  }
  
  public static TroopKeywordManager a(QQAppInterface paramQQAppInterface)
  {
    return ((VasExtensionManager)paramQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a;
  }
  
  private void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPullTimestamp = ");
      localStringBuilder.append(paramLong);
      QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Long = paramLong;
    QVipConfigManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "troop_keyword_last_pull_timestamp", paramLong);
  }
  
  private void a(HashMap<String, List<TroopKeyWord>> paramHashMap)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!paramHashMap.containsKey(str)) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateKeywords: ");
        ((StringBuilder)localObject).append(paramHashMap);
        QLog.d("TroopKeywordManager.troop.special_msg.keyword", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(paramHashMap);
      this.jdField_a_of_type_Boolean = true;
      d();
      return;
    }
    for (;;)
    {
      throw paramHashMap;
    }
  }
  
  public static boolean a()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool3 = paramMessageRecord instanceof Message;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (((Message)paramMessageRecord).bizType == 16) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static long b()
  {
    return QzoneConfig.getInstance().getConfig("K_QQ_VAS", "SK_QQ_VAS_KeywordAIORefreshFrequency", 1) * 60L * 1000L;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(TroopKeyWord.class);
      HashMap localHashMap = new HashMap();
      if (localObject1 != null)
      {
        Iterator localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          TroopKeyWord localTroopKeyWord = (TroopKeyWord)localIterator.next();
          List localList = (List)localHashMap.get(localTroopKeyWord.troopUin);
          localObject1 = localList;
          if (localList == null)
          {
            localObject1 = new ArrayList();
            localHashMap.put(localTroopKeyWord.troopUin, localObject1);
          }
          ((List)localObject1).add(localTroopKeyWord);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("syncLoad: ");
        ((StringBuilder)localObject1).append(localHashMap);
        QLog.d("TroopKeywordManager.troop.special_msg.keyword", 2, ((StringBuilder)localObject1).toString());
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(localHashMap);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void d()
  {
    ThreadManagerV2.excute(new TroopKeywordManager.1(this), 32, null, true);
  }
  
  public EntryStatus a(String paramString)
  {
    EntryStatus localEntryStatus = new EntryStatus();
    if ((!TextUtils.isEmpty(paramString)) && (a()))
    {
      c();
      Object localObject1 = BaseApplicationImpl.getContext().getResources();
      List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      int i;
      boolean bool;
      if ((localList != null) && (!localList.isEmpty()))
      {
        Object localObject2 = new ExpireSet();
        Object localObject3 = localList.iterator();
        int j = 0;
        i = 0;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (TroopKeyWord)((Iterator)localObject3).next();
          if (((TroopKeyWord)localObject4).expiredFlag == 3)
          {
            j += 1;
            ((ExpireSet)localObject2).add(Long.valueOf(((TroopKeyWord)localObject4).wordId));
          }
          else if (((TroopKeyWord)localObject4).expiredFlag == 2)
          {
            i += 1;
            ((ExpireSet)localObject2).add(Long.valueOf(((TroopKeyWord)localObject4).wordId));
          }
        }
        localEntryStatus.jdField_a_of_type_Int = j;
        localEntryStatus.jdField_b_of_type_Int = i;
        localEntryStatus.jdField_b_of_type_JavaLangString = ((ExpireSet)localObject2).toJson();
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("troop_keyword_expire_list_");
        ((StringBuilder)localObject4).append(paramString);
        localObject3 = QVipConfigManager.a((AppRuntime)localObject3, ((StringBuilder)localObject4).toString(), null);
        bool = ExpireSet.fromJson((String)localObject3).containsAll((Collection)localObject2) ^ true;
        if (bool)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("expireList hasNewExpiredId, last:");
          ((StringBuilder)localObject2).append((String)localObject3);
          ((StringBuilder)localObject2).append(" now:");
          ((StringBuilder)localObject2).append(localEntryStatus.jdField_b_of_type_JavaLangString);
          QLog.e("TroopKeywordManager.troop.special_msg.keyword", 1, ((StringBuilder)localObject2).toString());
        }
        else
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("troop_keyword_expire_list_");
          ((StringBuilder)localObject3).append(paramString);
          QVipConfigManager.a((AppRuntime)localObject2, ((StringBuilder)localObject3).toString(), localEntryStatus.jdField_b_of_type_JavaLangString);
        }
        if (j > 0)
        {
          localObject1 = ((Resources)localObject1).getString(2131699493, new Object[] { Integer.valueOf(j) });
          i = 5;
        }
        else if (i > 0)
        {
          localObject1 = ((Resources)localObject1).getString(2131699498);
          i = 4;
        }
        else
        {
          localObject1 = ((Resources)localObject1).getString(2131699494, new Object[] { Integer.valueOf(localList.size()) });
          i = 3;
          bool = false;
        }
      }
      else
      {
        localObject1 = ((Resources)localObject1).getString(2131692934);
        if ((!QVipConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_keyword_guide_clicked", false)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())) {
          bool = true;
        } else {
          bool = false;
        }
        if (bool) {
          i = 2;
        } else {
          i = 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopKeywordManager.troop.special_msg.keyword", 2, new Object[] { "getTips, troopUin=", paramString, " tips=", localObject1, " red=", Boolean.valueOf(bool) });
      }
      localEntryStatus.jdField_a_of_type_JavaLangString = ((String)localObject1);
      localEntryStatus.jdField_a_of_type_Boolean = bool;
      localEntryStatus.c = i;
      return localEntryStatus;
    }
    localEntryStatus.jdField_a_of_type_JavaLangString = "";
    localEntryStatus.jdField_a_of_type_Boolean = false;
    localEntryStatus.c = 1;
    QLog.e("TroopKeywordManager.troop.special_msg.keyword", 1, new Object[] { "getTips error, troopUin=", paramString, " enable=", Boolean.valueOf(a()) });
    return localEntryStatus;
  }
  
  public void a() {}
  
  public void a(GetUsrKeyWordInfoRsp paramGetUsrKeyWordInfoRsp)
  {
    QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, "onKeyworkRsp");
    if (paramGetUsrKeyWordInfoRsp == null)
    {
      QLog.e("TroopKeywordManager.troop.special_msg.keyword", 1, "rsp == null");
      return;
    }
    boolean bool;
    if (1 == paramGetUsrKeyWordInfoRsp.iShowEntry) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool);
    HashMap localHashMap = new HashMap();
    ArrayList[] arrayOfArrayList = new ArrayList[2];
    arrayOfArrayList[0] = paramGetUsrKeyWordInfoRsp.vBaseWord;
    arrayOfArrayList[1] = paramGetUsrKeyWordInfoRsp.vVaWord;
    int j = arrayOfArrayList.length;
    int i = 0;
    while (i < j)
    {
      paramGetUsrKeyWordInfoRsp = arrayOfArrayList[i];
      if (paramGetUsrKeyWordInfoRsp != null)
      {
        Iterator localIterator = paramGetUsrKeyWordInfoRsp.iterator();
        while (localIterator.hasNext())
        {
          paramGetUsrKeyWordInfoRsp = (OneKeyWordItemClient)localIterator.next();
          TroopKeyWord localTroopKeyWord = new TroopKeyWord();
          localTroopKeyWord.wordId = paramGetUsrKeyWordInfoRsp.uWordId;
          localTroopKeyWord.keyword = paramGetUsrKeyWordInfoRsp.sKeyWordContent.toLowerCase();
          localTroopKeyWord.troopUin = String.valueOf(paramGetUsrKeyWordInfoRsp.uGroupNum);
          localTroopKeyWord.expiredFlag = ((int)paramGetUsrKeyWordInfoRsp.uWordExpiredFlag);
          if ((paramGetUsrKeyWordInfoRsp.uWordStatus == 2L) && ((paramGetUsrKeyWordInfoRsp.uWordExpiredFlag == 1L) || (paramGetUsrKeyWordInfoRsp.uWordExpiredFlag == 2L))) {
            bool = true;
          } else {
            bool = false;
          }
          localTroopKeyWord.enable = bool;
          if (QLog.isColorLevel()) {
            QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, localTroopKeyWord.toString());
          }
          List localList = (List)localHashMap.get(localTroopKeyWord.troopUin);
          paramGetUsrKeyWordInfoRsp = localList;
          if (localList == null)
          {
            paramGetUsrKeyWordInfoRsp = new ArrayList();
            localHashMap.put(localTroopKeyWord.troopUin, paramGetUsrKeyWordInfoRsp);
          }
          paramGetUsrKeyWordInfoRsp.add(localTroopKeyWord);
        }
      }
      i += 1;
    }
    a(localHashMap);
  }
  
  public void a(String paramString)
  {
    if (a(paramString))
    {
      long l = System.currentTimeMillis();
      if (Math.abs(l - a()) > b())
      {
        QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, "onKeywordTimeoutCheck");
        a(l);
        b();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean a(String paramString)
  {
    boolean bool1 = a();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("TroopKeywordManager.troop.special_msg.keyword", 1, "hasKeyword, troopUin is empty");
      return false;
    }
    paramString = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (!a()) {
      return false;
    }
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.e("TroopKeywordManager.troop.special_msg.keyword", 1, "containsKeyword, troopUin is empty");
      return false;
    }
    c();
    Object localObject = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString2);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      paramString1 = paramString1.toLowerCase();
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (TroopKeyWord)localIterator.next();
        if ((((TroopKeyWord)localObject).enable) && (paramString1.contains(((TroopKeyWord)localObject).keyword)))
        {
          if (QLog.isColorLevel())
          {
            paramString1 = new StringBuilder();
            paramString1.append("containsKeyword: ");
            paramString1.append(((TroopKeyWord)localObject).keyword);
            QLog.d("TroopKeywordManager.troop.special_msg.keyword", 2, paramString1.toString());
          }
          ReportController.b(null, "dc00898", "", paramString2, "qq_vip", "0X800A8FD", 0, 1, 0, "", "", ((TroopKeyWord)localObject).keyword, "");
          return true;
        }
      }
    }
    return false;
  }
  
  public void b()
  {
    QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, "onKeywordChangePush");
    ((ISVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(new TroopKeywordManager.MyBusinessObserver(this), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager
 * JD-Core Version:    0.7.0.1
 */