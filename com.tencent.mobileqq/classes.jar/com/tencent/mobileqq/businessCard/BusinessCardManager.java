package com.tencent.mobileqq.businessCard;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.profile.SchoolInfo;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class BusinessCardManager
  implements Manager
{
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  TransFileControllerImpl jdField_a_of_type_ComTencentMobileqqTransfileApiImplTransFileControllerImpl = null;
  protected ArrayList<SchoolInfo> a;
  protected ConcurrentHashMap<String, BusinessCard> a;
  protected ConcurrentHashMap<String, BusinessCard> b;
  
  public BusinessCardManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(0);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.b = new ConcurrentHashMap();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pref_business_card");
    localStringBuilder.append(paramQQAppInterface.getAccount());
    this.jdField_a_of_type_AndroidContentSharedPreferences = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
    a();
  }
  
  private boolean a(BusinessCard paramBusinessCard)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBusinessCard != null)
    {
      String str = paramBusinessCard.cardId;
      bool1 = bool2;
      if (str != null)
      {
        bool1 = bool2;
        if (str.length() != 0)
        {
          paramBusinessCard.setStatus(1000);
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramBusinessCard);
          bool1 = bool2;
          if (paramBusinessCard.getStatus() == 1001) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void c(BusinessCard paramBusinessCard)
  {
    if (paramBusinessCard != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramBusinessCard);
    }
  }
  
  private void d(BusinessCard paramBusinessCard)
  {
    if (paramBusinessCard != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(paramBusinessCard);
    }
  }
  
  public int a()
  {
    int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_server_seq", -1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLocalSeq | seq = ");
      localStringBuilder.append(i);
      QLog.d("BusinessCard_Manager", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public BusinessCard a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localBusinessCard = (BusinessCard)((Map.Entry)localIterator.next()).getValue();
        if (localBusinessCard.cardType == 1) {
          break label63;
        }
      }
    }
    BusinessCard localBusinessCard = null;
    label63:
    if ((localBusinessCard == null) && (QLog.isColorLevel())) {
      QLog.w("BusinessCard_Manager", 2, "getMyBusinessCard return null");
    }
    return localBusinessCard;
  }
  
  public BusinessCard a(String paramString)
  {
    return (BusinessCard)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public ArrayList<SchoolInfo> a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      ArrayList localArrayList2 = (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone();
      return localArrayList2;
    }
  }
  
  List<BusinessCard> a()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(BusinessCard.class);
    if ((localList != null) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBusinessCardListFromDB= ");
      localStringBuilder.append(localList.size());
      QLog.d("BusinessCard_Manager", 2, localStringBuilder.toString());
    }
    return localList;
  }
  
  public void a()
  {
    ThreadManager.post(new BusinessCardManager.1(this), 8, null, true);
  }
  
  public void a(int paramInt)
  {
    if (paramInt != -1) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_server_seq", paramInt).commit();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveServerSeq | seq = ");
      localStringBuilder.append(paramInt);
      QLog.d("BusinessCard_Manager", 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCardSetting|type=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", flag=");
      localStringBuilder.append(paramBoolean);
      QLog.d("BusinessCard_Manager", 2, localStringBuilder.toString());
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_need_show_guide", paramBoolean).commit();
        return;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_need_req_card", paramBoolean).commit();
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_show_open_card", paramBoolean).commit();
  }
  
  public void a(BusinessCard paramBusinessCard)
  {
    if (paramBusinessCard == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramBusinessCard.cardId)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramBusinessCard.cardId);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramBusinessCard.cardId, paramBusinessCard);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      d((BusinessCard)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public void a(String paramString, BusinessCard paramBusinessCard)
  {
    if (paramBusinessCard != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (this.b.containsKey(paramString)) {
        this.b.remove(paramString);
      }
      this.b.put(paramString, paramBusinessCard);
    }
  }
  
  public void a(ArrayList<SchoolInfo> paramArrayList)
  {
    if (paramArrayList != null) {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
        return;
      }
    }
  }
  
  /* Error */
  public void a(List<BusinessCard> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +184 -> 185
    //   4: aload_0
    //   5: getfield 46	com/tencent/mobileqq/businessCard/BusinessCardManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   8: invokevirtual 283	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   11: invokevirtual 288	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   14: iload_2
    //   15: ifeq +16 -> 31
    //   18: aload_0
    //   19: getfield 46	com/tencent/mobileqq/businessCard/BusinessCardManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   22: ldc 87
    //   24: invokevirtual 293	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   27: invokevirtual 297	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/String;)Z
    //   30: pop
    //   31: aload_1
    //   32: invokeinterface 298 1 0
    //   37: astore_3
    //   38: aload_3
    //   39: invokeinterface 162 1 0
    //   44: ifeq +61 -> 105
    //   47: aload_3
    //   48: invokeinterface 166 1 0
    //   53: checkcast 87	com/tencent/mobileqq/businessCard/data/BusinessCard
    //   56: astore_1
    //   57: aload_0
    //   58: aload_1
    //   59: invokespecial 300	com/tencent/mobileqq/businessCard/BusinessCardManager:a	(Lcom/tencent/mobileqq/businessCard/data/BusinessCard;)Z
    //   62: ifeq +6 -> 68
    //   65: goto -27 -> 38
    //   68: new 59	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   75: astore_3
    //   76: aload_3
    //   77: ldc_w 302
    //   80: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_3
    //   85: aload_1
    //   86: getfield 91	com/tencent/mobileqq/businessCard/data/BusinessCard:cardId	Ljava/lang/String;
    //   89: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: new 279	java/lang/Exception
    //   96: dup
    //   97: aload_3
    //   98: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokespecial 304	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   104: athrow
    //   105: aload_0
    //   106: getfield 46	com/tencent/mobileqq/businessCard/BusinessCardManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   109: invokevirtual 283	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   112: invokevirtual 306	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   115: aload_0
    //   116: getfield 46	com/tencent/mobileqq/businessCard/BusinessCardManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   119: invokevirtual 283	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   122: invokevirtual 309	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   125: return
    //   126: astore_1
    //   127: goto +46 -> 173
    //   130: astore_1
    //   131: new 59	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   138: astore_3
    //   139: aload_3
    //   140: ldc_w 311
    //   143: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload_3
    //   148: aload_1
    //   149: invokevirtual 312	java/lang/Exception:toString	()Ljava/lang/String;
    //   152: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: ldc 140
    //   158: iconst_2
    //   159: aload_3
    //   160: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aload_1
    //   167: invokevirtual 315	java/lang/Exception:printStackTrace	()V
    //   170: goto -55 -> 115
    //   173: aload_0
    //   174: getfield 46	com/tencent/mobileqq/businessCard/BusinessCardManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   177: invokevirtual 283	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   180: invokevirtual 309	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   183: aload_1
    //   184: athrow
    //   185: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	BusinessCardManager
    //   0	186	1	paramList	List<BusinessCard>
    //   0	186	2	paramBoolean	boolean
    //   37	123	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	14	126	finally
    //   18	31	126	finally
    //   31	38	126	finally
    //   38	65	126	finally
    //   68	105	126	finally
    //   105	115	126	finally
    //   131	170	126	finally
    //   4	14	130	java/lang/Exception
    //   18	31	130	java/lang/Exception
    //   31	38	130	java/lang/Exception
    //   38	65	130	java/lang/Exception
    //   68	105	130	java/lang/Exception
    //   105	115	130	java/lang/Exception
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_red_point", paramBoolean).commit();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRedPointClicked | clicked = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("BusinessCard_Manager", 2, localStringBuilder.toString());
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_need_show_guide", true);
        }
      }
      else {
        bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_need_req_card", false);
      }
    }
    else {
      bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_show_open_card", false);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCardSetting|type=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", result=");
      localStringBuilder.append(bool);
      QLog.d("BusinessCard_Manager", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public BusinessCard b(String paramString)
  {
    return (BusinessCard)this.b.get(paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.drop(BusinessCard.class);
  }
  
  public void b(BusinessCard paramBusinessCard)
  {
    if (paramBusinessCard == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramBusinessCard.cardId))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramBusinessCard.cardId);
      c(paramBusinessCard);
    }
    else
    {
      a(paramBusinessCard);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramBusinessCard.cardId, paramBusinessCard);
  }
  
  public void b(String paramString)
  {
    if (this.b.containsKey(paramString)) {
      this.b.remove(paramString);
    }
  }
  
  public BusinessCard c(String paramString)
  {
    if (paramString != null)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        return null;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        BusinessCard localBusinessCard = (BusinessCard)localIterator.next();
        if ((localBusinessCard.OCRInfo != null) && (paramString.equals(localBusinessCard.OCRInfo.b))) {
          return localBusinessCard;
        }
      }
    }
    return null;
  }
  
  public BusinessCard d(String paramString)
  {
    BusinessCard localBusinessCard1 = new BusinessCard();
    BusinessCard localBusinessCard2 = (BusinessCard)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(BusinessCard.class, paramString);
    paramString = localBusinessCard2;
    if (localBusinessCard2 == null) {
      paramString = localBusinessCard1;
    }
    return paramString;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.b.clear();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.BusinessCardManager
 * JD-Core Version:    0.7.0.1
 */