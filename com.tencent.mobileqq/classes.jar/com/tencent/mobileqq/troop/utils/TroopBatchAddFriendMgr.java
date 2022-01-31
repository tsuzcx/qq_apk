package com.tencent.mobileqq.troop.utils;

import alto;
import amdu;
import ameq;
import amqt;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import asrb;
import awge;
import awgf;
import awgg;
import awgh;
import bbpd;
import bclg;
import bcmf;
import bcmg;
import bcmh;
import bcpa;
import bcpx;
import bctz;
import bcua;
import bdeu;
import bdhb;
import bdin;
import bdnn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.haoliyou.orion.XorCipherException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ArrayList<Lbcmh;>;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBatchAddFriendMgr
  implements bcua
{
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy_MM_dd");
  private static final Comparator<bcmh> jdField_a_of_type_JavaUtilComparator = new bcmg();
  ameq jdField_a_of_type_Ameq = new bcmf(this);
  public QQAppInterface a;
  private String jdField_a_of_type_JavaLangString;
  public ConcurrentHashMap<String, Long> a;
  private String jdField_b_of_type_JavaLangString = "";
  ConcurrentHashMap<String, bctz> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public TroopBatchAddFriendMgr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Ameq, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private bctz a(String paramString)
  {
    synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      bctz localbctz = (bctz)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localbctz == null) {
        return null;
      }
      if (!localbctz.a())
      {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        return null;
      }
      return localbctz;
    }
  }
  
  private String a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return paramString1 + paramString2;
    }
    return null;
  }
  
  private ArrayList<bcmh> a(bcmh parambcmh, String paramString)
  {
    paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramString);
    if (paramString == null) {
      return null;
    }
    paramString = b(paramString.mAtOrReplyMeUins);
    a(paramString, parambcmh);
    return paramString;
  }
  
  public static ArrayList<String> a(List<MessageRecord> paramList, QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = paramQQAppInterface.getCurrentAccountUin();
    HashMap localHashMap = new HashMap();
    int m = paramList.size();
    int k = 0;
    int j = 0;
    Object localObject;
    if (k < m)
    {
      if (k < j) {
        i = j;
      }
      do
      {
        do
        {
          k += 1;
          j = i;
          break;
          i = j;
        } while (!((MessageRecord)paramList.get(k)).senderuin.equals(str1));
        if (k != 0) {
          break label192;
        }
        i = j;
      } while (k + 1 > m - 1);
      localObject = ((MessageRecord)paramList.get(k + 1)).senderuin;
      if (((String)localObject).equals(str1)) {
        break label618;
      }
      if (localHashMap.containsKey(localObject)) {
        localHashMap.put(localObject, Integer.valueOf(((Integer)localHashMap.get(localObject)).intValue() + 1));
      }
    }
    label169:
    label192:
    label618:
    for (int i = k + 2;; i = j)
    {
      break;
      localHashMap.put(localObject, Integer.valueOf(1));
      break label169;
      if (k == m - 1)
      {
        i = j;
        if (k - 1 < 0) {
          break;
        }
        i = j;
        if (k - 1 < j) {
          break;
        }
        localObject = ((MessageRecord)paramList.get(k - 1)).senderuin;
        i = j;
        if (((String)localObject).equals(str1)) {
          break;
        }
        if (localHashMap.containsKey(localObject))
        {
          localHashMap.put(localObject, Integer.valueOf(((Integer)localHashMap.get(localObject)).intValue() + 1));
          i = j;
          break;
        }
        localHashMap.put(localObject, Integer.valueOf(1));
        i = j;
        break;
      }
      String str2 = ((MessageRecord)paramList.get(k + 1)).senderuin;
      if ((k - 1 >= 0) && (k - 1 >= j)) {}
      for (localObject = ((MessageRecord)paramList.get(k - 1)).senderuin;; localObject = null)
      {
        if (!str2.equals(str1)) {
          if (localHashMap.containsKey(str2))
          {
            localHashMap.put(str2, Integer.valueOf(((Integer)localHashMap.get(str2)).intValue() + 1));
            i = k + 2;
          }
        }
        for (;;)
        {
          if ((localObject != null) && (!((String)localObject).equals(str2)) && (!((String)localObject).equals(str1)))
          {
            if (localHashMap.containsKey(localObject))
            {
              localHashMap.put(localObject, Integer.valueOf(((Integer)localHashMap.get(localObject)).intValue() + 1));
              break;
              localHashMap.put(str2, Integer.valueOf(1));
              break label405;
              i = k + 1;
              continue;
            }
            localHashMap.put(localObject, Integer.valueOf(1));
          }
        }
        break;
        i = ((TroopManager)paramQQAppInterface.getManager(52)).a().j;
        paramList = localHashMap.entrySet().iterator();
        while (paramList.hasNext())
        {
          localObject = (Map.Entry)paramList.next();
          if ((((Integer)((Map.Entry)localObject).getValue()).intValue() >= i) && (!bclg.b(paramQQAppInterface, (String)((Map.Entry)localObject).getKey()))) {
            localArrayList.add(((Map.Entry)localObject).getKey());
          }
        }
        return localArrayList;
      }
    }
  }
  
  private void a(String paramString, boolean paramBoolean, long paramLong, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = a(paramString);
    } while (paramString == null);
    paramString.a(paramBoolean, paramInt);
  }
  
  private void a(ArrayList<bcmh> paramArrayList, bcmh parambcmh)
  {
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList();
    }
    int j = 0;
    int i;
    for (int k = 0; j < ((ArrayList)localObject).size(); k = i)
    {
      i = k;
      if (parambcmh.jdField_a_of_type_JavaLangString != null)
      {
        i = k;
        if (parambcmh.jdField_a_of_type_JavaLangString.equals(((bcmh)((ArrayList)localObject).get(j)).jdField_a_of_type_JavaLangString))
        {
          k = 1;
          i = k;
          if (((bcmh)((ArrayList)localObject).get(j)).jdField_a_of_type_Long < parambcmh.jdField_a_of_type_Long)
          {
            ((bcmh)((ArrayList)localObject).get(j)).jdField_a_of_type_Long = parambcmh.jdField_a_of_type_Long;
            ((bcmh)((ArrayList)localObject).get(j)).b = parambcmh.b;
            ((bcmh)((ArrayList)localObject).get(j)).jdField_a_of_type_Int = parambcmh.jdField_a_of_type_Int;
            i = k;
          }
        }
      }
      j += 1;
    }
    if (k == 0) {
      ((ArrayList)localObject).add(parambcmh);
    }
  }
  
  private void a(ArrayList<bcmh> paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    TroopInfo localTroopInfo;
    do
    {
      TroopManager localTroopManager;
      do
      {
        return;
        localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        localTroopInfo = localTroopManager.b(paramString);
      } while (localTroopInfo == null);
      Collections.sort(paramArrayList, jdField_a_of_type_JavaUtilComparator);
      int i = 10;
      Object localObject = localTroopManager.a();
      if (((amqt)localObject).p >= 1) {
        i = ((amqt)localObject).p;
      }
      if (paramArrayList.size() > i) {
        paramArrayList.subList(0, i);
      }
      localObject = a(paramArrayList);
      paramArrayList = (ArrayList<bcmh>)localObject;
      if (localObject == null) {
        paramArrayList = "";
      }
      localTroopInfo.mAtOrReplyMeUins = paramArrayList;
      localTroopManager.c(localTroopInfo);
    } while (!QLog.isColorLevel());
    QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "markAtOrReplyMeMsgInTroop handled" + paramString + localTroopInfo.mAtOrReplyMeUins);
  }
  
  public int a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("troop_gt_af_total_").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localObject = ((StringBuilder)localObject).toString();
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences((String)localObject, 0).getInt(c(paramString), 0);
    if (i >= ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a().f)
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, " has recommended exceed the limit ,uin = " + paramString);
      }
      return -1;
    }
    return i;
  }
  
  public int a(String paramString, long paramLong, int paramInt)
  {
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    Object localObject1 = (TroopManager)((QQAppInterface)localObject2).getManager(52);
    if (QLog.isColorLevel()) {
      QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("startReqTroopMemberList troopUin_type_ts=%s_%d_%d", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
    }
    if ((paramString != null) && (paramString.length() > 0))
    {
      TroopInfo localTroopInfo = ((TroopManager)localObject1).b(paramString);
      localObject1 = "0";
      if (localTroopInfo != null) {
        localObject1 = localTroopInfo.troopcode;
      }
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        if (!bdin.d(BaseApplication.getContext()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("prepareTroopBatchAddFrdData return. net connect err %s", new Object[] { paramString }));
          }
          return -1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("startReqTroopMemberList troopUin_type_ts=%s_%d_%d", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
        }
        localObject2 = (amdu)((QQAppInterface)localObject2).a(20);
        if (paramLong != 0L) {
          break label248;
        }
        paramLong = System.currentTimeMillis();
      }
    }
    label248:
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(paramLong));
      ((amdu)localObject2).a(true, paramString, (String)localObject1, true, 7, paramLong, paramInt);
      return 0;
      return -1;
    }
  }
  
  public int a(String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    List localList = a(paramString);
    if ((localList == null) || (localList.size() == 0)) {
      return -1;
    }
    ArrayList localArrayList = new ArrayList(localList.size());
    int i = 0;
    if (i < localList.size())
    {
      if ((((TroopMemberInfo)localList.get(i)).memberuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (!bdeu.d(((TroopMemberInfo)localList.get(i)).memberuin))) {}
      for (;;)
      {
        i += 1;
        break;
        if ((paramBoolean) && (((TroopMemberInfo)localList.get(i)).recommendRemark == null)) {
          localArrayList.add(((TroopMemberInfo)localList.get(i)).memberuin);
        } else if (!paramBoolean) {
          localArrayList.add(((TroopMemberInfo)localList.get(i)).memberuin);
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      if (!bdin.d(BaseApplication.getContext())) {
        return -1;
      }
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, new Object[] { "startReqRecmdRemarkList dbSize=", Integer.valueOf(localList.size()) });
      if (paramLong != 0L) {
        break label297;
      }
      paramLong = System.currentTimeMillis();
    }
    label297:
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(paramLong));
      ((amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(paramString, paramLong, paramInt, (ArrayList)localArrayList, paramBoolean);
      return 0;
      return 1;
    }
  }
  
  public int a(String paramString, long paramLong, int paramInt, boolean paramBoolean, List<String> paramList)
  {
    List localList = a(paramString);
    if ((localList == null) || (localList.size() == 0)) {
      return -1;
    }
    ArrayList localArrayList = new ArrayList(localList.size());
    int i = 0;
    if (i < localList.size())
    {
      if ((((TroopMemberInfo)localList.get(i)).memberuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (!bdeu.d(((TroopMemberInfo)localList.get(i)).memberuin))) {}
      for (;;)
      {
        i += 1;
        break;
        if ((paramBoolean) && (((TroopMemberInfo)localList.get(i)).commonFrdCnt == -2147483648)) {
          localArrayList.add(((TroopMemberInfo)localList.get(i)).memberuin);
        } else if (!paramBoolean) {
          localArrayList.add(((TroopMemberInfo)localList.get(i)).memberuin);
        }
      }
    }
    String str1;
    if ((paramInt == 4) && (paramList != null))
    {
      i = 0;
      if (i < paramList.size())
      {
        str1 = (String)paramList.get(i);
        if (!TextUtils.isEmpty(str1)) {}
      }
    }
    label256:
    label508:
    for (;;)
    {
      i += 1;
      break;
      int j = 0;
      if (j < localArrayList.size())
      {
        String str2 = (String)localArrayList.get(j);
        if ((str2 == null) || (!str1.equals(str2))) {}
      }
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          break label508;
        }
        QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, "startReqCmnFrdCntList add uin unexpected ^_^ " + bdnn.e(str1));
        localArrayList.add(str1);
        break;
        j += 1;
        break label256;
        if (localArrayList.size() > 0)
        {
          QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, new Object[] { "startReqCmnFrdCntList dbSize=", Integer.valueOf(localList.size()), " reqSize=", Integer.valueOf(localArrayList.size()) });
          if (!bdin.d(BaseApplication.getContext())) {
            return -1;
          }
          long l = paramLong;
          if (paramLong == 0L) {
            l = System.currentTimeMillis();
          }
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(l));
          ((amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(paramString, localArrayList, 0, Long.valueOf(l), paramInt, paramBoolean);
          return 0;
        }
        if (QLog.isColorLevel()) {
          QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "startReqCmnFrdCntList no need");
        }
        return 1;
      }
    }
  }
  
  String a(String paramString)
  {
    return "daily_rec_uin_" + paramString;
  }
  
  public String a(ArrayList<bcmh> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return "";
    }
    for (;;)
    {
      JSONArray localJSONArray;
      int i;
      try
      {
        localJSONArray = new JSONArray();
        i = 0;
        if (i < paramArrayList.size())
        {
          bcmh localbcmh = (bcmh)paramArrayList.get(i);
          if ((localbcmh != null) && (localbcmh.jdField_a_of_type_JavaLangString != null))
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("mem", localbcmh.jdField_a_of_type_JavaLangString);
            localJSONObject.put("type", localbcmh.jdField_a_of_type_Int);
            localJSONObject.put("time", localbcmh.jdField_a_of_type_Long);
            localJSONObject.put("seq", localbcmh.b);
            localJSONArray.put(localJSONObject);
          }
          else
          {
            QLog.e("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "inf memberUin is null ");
          }
        }
      }
      catch (JSONException paramArrayList)
      {
        QLog.e("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "FlagMsgInfoFromJson " + paramArrayList.toString());
        return "";
      }
      paramArrayList = new JSONObject();
      paramArrayList.put("list", localJSONArray);
      paramArrayList = paramArrayList.toString();
      return paramArrayList;
      i += 1;
    }
  }
  
  public ArrayList<String> a(String paramString)
  {
    String[] arrayOfString = null;
    ArrayList localArrayList = null;
    String str = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    TroopInfo localTroopInfo = localTroopManager.b(paramString);
    Object localObject = arrayOfString;
    if (localTroopInfo != null)
    {
      localObject = arrayOfString;
      if (!TextUtils.isEmpty(localTroopInfo.dailyNewMemberUins))
      {
        localObject = arrayOfString;
        if (localTroopInfo.dailyNewMemberUins.startsWith(str))
        {
          arrayOfString = localTroopInfo.dailyNewMemberUins.split("\\|");
          localObject = localArrayList;
          if (arrayOfString.length > 1)
          {
            localArrayList = new ArrayList();
            int i = arrayOfString.length - 1;
            for (;;)
            {
              localObject = localArrayList;
              if (i <= 0) {
                break;
              }
              localArrayList.add(arrayOfString[i]);
              i -= 1;
            }
          }
          localTroopInfo.dailyNewMemberUins = "";
          localTroopManager.b(localTroopInfo);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "getAndClean dailyNewMember  troopUin = " + paramString + ",resultList = " + localObject);
    }
    return localObject;
  }
  
  public List<TroopMemberInfo> a(String paramString)
  {
    awgf localawgf = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    Object localObject = localawgf;
    if (paramString != null)
    {
      localObject = localawgf;
      if (paramString.length() > 0)
      {
        localObject = localawgf;
        if (localQQAppInterface != null)
        {
          localawgf = localQQAppInterface.getEntityManagerFactory().createEntityManager();
          localObject = localawgf.a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { paramString }, null, null, null, null);
          localawgf.a();
        }
      }
    }
    return localObject;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ameq);
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir().getParent() + File.separator + "shared_prefs";
    if (QLog.isColorLevel()) {
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "onDestroy curUin " + str1 + ",sharePrefsDir = " + str2);
    }
    ThreadManagerV2.executeOnFileThread(new TroopBatchAddFriendMgr.1(this, str2, str1));
  }
  
  public void a(bctz parambctz)
  {
    if ((parambctz == null) || (TextUtils.isEmpty(parambctz.c))) {}
    for (;;)
    {
      return;
      String str = parambctz.c;
      parambctz = a(parambctz.c);
      if (QLog.isColorLevel())
      {
        if (parambctz == null) {
          break label138;
        }
        QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onReadyForInsertTip scene uin_type_ts_valid=%s_%d_%d_%b", new Object[] { str, Integer.valueOf(parambctz.jdField_a_of_type_Int), Long.valueOf(parambctz.jdField_a_of_type_Long), Boolean.valueOf(true) }));
      }
      while (parambctz != null)
      {
        ((amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).notifyUI(115, true, new Object[] { parambctz.c, Integer.valueOf(parambctz.jdField_a_of_type_Int), parambctz.jdField_a_of_type_JavaUtilList });
        return;
        label138:
        QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onReadyForInsertTip scene uin_valid=%s_%b", new Object[] { str, Boolean.valueOf(false) }));
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject1 = a(paramString, paramMessageRecord.msgseq + "");
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).equals(this.jdField_b_of_type_JavaLangString))) {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "TriggerAndCleanAtOrReplyMsg handled");
      }
    }
    do
    {
      return;
      this.jdField_b_of_type_JavaLangString = ((String)localObject1);
      localObject1 = new ArrayList();
      int i;
      if ((paramMessageRecord.atInfoList != null) && (paramMessageRecord.atInfoList.size() > 0)) {
        i = 0;
      }
      while (i < paramMessageRecord.atInfoList.size())
      {
        Object localObject2 = (MessageForText.AtTroopMemberInfo)paramMessageRecord.atInfoList.get(i);
        if (((MessageForText.AtTroopMemberInfo)localObject2).flag == 0)
        {
          localObject2 = "" + ((MessageForText.AtTroopMemberInfo)localObject2).uin;
          if (e((String)localObject2))
          {
            ((ArrayList)localObject1).add(localObject2);
            if (QLog.isColorLevel()) {
              QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "update AtTroopMemberInfo = " + (String)localObject2);
            }
          }
        }
        i += 1;
        continue;
        if ((paramMessageRecord instanceof MessageForReplyText))
        {
          paramMessageRecord = (MessageForReplyText)paramMessageRecord;
          if (e("" + paramMessageRecord.mSourceMsgInfo.mSourceMsgSenderUin)) {
            ((ArrayList)localObject1).add("" + paramMessageRecord.mSourceMsgInfo.mSourceMsgSenderUin);
          }
        }
      }
    } while ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0));
    a(paramString, (List)localObject1, 5);
  }
  
  public void a(String paramString)
  {
    Object localObject1 = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("troop_gt_af_daily_").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).append("_").append((String)localObject1);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences((String)localObject1, 0);
    localObject2 = b(paramString);
    ((SharedPreferences)localObject1).edit().remove((String)localObject2).apply();
    if (QLog.isColorLevel()) {
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "removeTroopBAGrayTipsDailyCount key = " + (String)localObject2 + ",troopUin = " + paramString);
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    ((amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).notifyUI(113, false, new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
  }
  
  void a(String paramString1, String paramString2)
  {
    Object localObject1;
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("troop_gt_af_daily_").append(paramString2).append("_");
      paramString2 = new File(paramString1).list();
      if (paramString2 != null) {
        break label52;
      }
    }
    for (;;)
    {
      return;
      label52:
      String str = ((StringBuilder)localObject1).toString();
      localObject1 = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
      int j = paramString2.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = paramString2[i];
        if (((String)localObject2).startsWith(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "clearSPFile fileName " + (String)localObject2 + ",prefixToday = " + (String)localObject1);
          }
          if (!((String)localObject2).startsWith((String)localObject1))
          {
            localObject2 = new File(paramString1 + File.separator + (String)localObject2);
            bdhb.d(((File)localObject2).getAbsolutePath());
            if (QLog.isColorLevel()) {
              QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "clearSPFile delete SP " + ((File)localObject2).getAbsolutePath());
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "markMultiAtOrReplyMeMsgInTroop single");
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (paramString1.equals(this.jdField_a_of_type_JavaLangString))) {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "markAtOrReplyMeMsgInTroop unhandled when aio opened");
      }
    }
    do
    {
      do
      {
        return;
      } while ((!b("atMeOrReplyMe")) || (!e(paramString2)));
      paramString2 = a(new bcmh(this, paramString2, paramInt, paramLong1, paramLong2), paramString1);
    } while ((paramString2 == null) || (paramString2.size() < 0));
    a(paramString2, paramString1);
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    Object localObject = a(paramString1, paramLong2 + "");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).equals(this.jdField_b_of_type_JavaLangString))) {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "TriggerAndCleanAtOrReplyMsg handled");
      }
    }
    do
    {
      return;
      this.jdField_b_of_type_JavaLangString = ((String)localObject);
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramString2);
      a(paramString1, (List)localObject, 5);
    } while (!QLog.isColorLevel());
    QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "TriggerAndCleanAtOrReplyMsg memUin  " + paramString2);
  }
  
  public void a(String paramString, HashMap<String, Integer> paramHashMap)
  {
    awgf localawgf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    awgh localawgh = localawgf.a();
    localawgh.a();
    StringBuilder localStringBuilder = new StringBuilder(1024);
    try
    {
      Iterator localIterator = paramHashMap.keySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label285;
        }
        String str = (String)localIterator.next();
        i = ((Integer)paramHashMap.get(str)).intValue();
        List localList = localawgf.a(TroopMemberInfo.class, false, "troopuin=? and memberuin=?", new String[] { paramString, str }, null, null, null, null);
        Object localObject2 = null;
        localObject1 = localObject2;
        if (localList != null)
        {
          localObject1 = localObject2;
          if (localList.size() > 0) {
            localObject1 = (TroopMemberInfo)localList.get(0);
          }
        }
        if (localObject1 != null) {
          break;
        }
        localObject1 = new TroopMemberInfo();
        ((TroopMemberInfo)localObject1).troopuin = paramString;
        ((TroopMemberInfo)localObject1).memberuin = str;
        ((TroopMemberInfo)localObject1).commonFrdCnt = i;
        localawgf.a((awge)localObject1);
        localStringBuilder.append("|").append(str);
      }
    }
    catch (Exception paramHashMap)
    {
      for (;;)
      {
        int i;
        Object localObject1;
        if (QLog.isColorLevel()) {
          QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "updateDBMemberCmnFrds  exception ,troopUin = " + paramString, paramHashMap);
        }
        return;
        ((TroopMemberInfo)localObject1).commonFrdCnt = i;
        localawgf.a((awge)localObject1);
      }
    }
    finally
    {
      localawgf.a();
      localawgh.b();
    }
    label285:
    localawgh.c();
    QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, new Object[] { "updateDBMemberCmnFrds troopUin=", paramString, " frdNotInDb=", localStringBuilder.toString() });
    localawgf.a();
    localawgh.b();
  }
  
  public void a(String paramString, HashMap<String, String> paramHashMap, List<String> paramList)
  {
    awgf localawgf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    awgh localawgh = localawgf.a();
    localawgh.a();
    StringBuilder localStringBuilder = new StringBuilder(1024);
    label315:
    for (;;)
    {
      try
      {
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          paramList = (String)paramHashMap.get(str);
          if (paramList != null) {
            break label315;
          }
          paramList = "";
          List localList = localawgf.a(TroopMemberInfo.class, false, "troopuin=? and memberuin=?", new String[] { paramString, str }, null, null, null, null);
          Object localObject2 = null;
          localObject1 = localObject2;
          if (localList != null)
          {
            localObject1 = localObject2;
            if (localList.size() > 0) {
              localObject1 = (TroopMemberInfo)localList.get(0);
            }
          }
          if (localObject1 == null)
          {
            localObject1 = new TroopMemberInfo();
            ((TroopMemberInfo)localObject1).troopuin = paramString;
            ((TroopMemberInfo)localObject1).memberuin = str;
            ((TroopMemberInfo)localObject1).recommendRemark = paramList;
            localawgf.a((awge)localObject1);
            localStringBuilder.append("|").append(str);
            continue;
          }
        }
      }
      catch (Exception paramString)
      {
        Object localObject1;
        return;
        if (TextUtils.equals(paramList, ((TroopMemberInfo)localObject1).recommendRemark)) {
          continue;
        }
        ((TroopMemberInfo)localObject1).recommendRemark = paramList;
        localawgf.a((awge)localObject1);
        continue;
      }
      finally
      {
        localawgf.a();
        localawgh.b();
      }
      localawgh.c();
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, new Object[] { "updateDBMemberRemark troopUin=", paramString, " frdNotInDb=", localStringBuilder.toString() });
      localawgf.a();
      localawgh.b();
      return;
    }
  }
  
  public void a(String paramString, List<String> paramList, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = null;
      if (paramList != null) {
        break;
      }
      localObject1 = "null";
      QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, String.format("onTriggerBatchAddTip troopUin_type=%s_%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), localObject1 }));
    } while ((a(paramString) != null) || (!bctz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt)));
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        for (;;)
        {
          localObject1 = a(paramString);
          if (localObject1 == null)
          {
            paramList = new bctz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt, this, paramList);
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramList);
            paramString = paramList;
            paramInt = 1;
            if (paramInt == 0) {
              break;
            }
            paramString.a();
            return;
            try
            {
              ??? = asrb.a(Arrays.toString(paramList.toArray()));
              localObject1 = ???;
            }
            catch (XorCipherException localXorCipherException)
            {
              localXorCipherException.printStackTrace();
            }
          }
        }
      }
      paramString = (String)localObject1;
      paramInt = 0;
    }
  }
  
  public void a(ArrayList<MessageRecord> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "markAtOrReplyMeMsgInTroop Multi");
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    label27:
    label155:
    label368:
    label370:
    do
    {
      break label27;
      for (;;)
      {
        return;
        if (b("atMeOrReplyMe"))
        {
          HashMap localHashMap = new HashMap();
          int i = 0;
          Object localObject;
          String str;
          if (i < paramArrayList.size())
          {
            localObject = (MessageRecord)paramArrayList.get(i);
            if (((MessageRecord)localObject).mMessageInfo != null)
            {
              str = ((MessageRecord)localObject).frienduin;
              localObject = new bcmh(this, ((MessageRecord)localObject).senderuin, ((MessageRecord)localObject).mMessageInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, ((MessageRecord)localObject).frienduin), ((MessageRecord)localObject).time, ((MessageRecord)localObject).msgseq);
              if (!localHashMap.containsKey(str)) {
                break label155;
              }
              ((ArrayList)localHashMap.get(str)).add(localObject);
            }
            for (;;)
            {
              i += 1;
              break;
              localHashMap.put(str, new ArrayList());
            }
          }
          if (localHashMap.keySet().size() <= 0) {
            break label370;
          }
          paramArrayList = localHashMap.keySet().iterator();
          for (;;)
          {
            if (!paramArrayList.hasNext()) {
              break label368;
            }
            str = (String)paramArrayList.next();
            if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (str.equals(this.jdField_a_of_type_JavaLangString)))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "markAtOrReplyMeMsgInTroop unhandled when key aio opened");
              return;
            }
            localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(str);
            if (localObject == null) {
              break;
            }
            localObject = b(((TroopInfo)localObject).mAtOrReplyMeUins);
            ArrayList localArrayList = (ArrayList)localHashMap.get(str);
            i = 0;
            if (i < localArrayList.size())
            {
              bcmh localbcmh = (bcmh)localArrayList.get(i);
              if (!e(localbcmh.jdField_a_of_type_JavaLangString)) {}
              for (;;)
              {
                i += 1;
                break;
                a((ArrayList)localObject, localbcmh);
              }
            }
            a((ArrayList)localObject, str);
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "markMultiAtOrReplyMeMsgInTroop no handled");
  }
  
  public boolean a(String paramString)
  {
    String str = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_gt_af_daily_").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).append("_").append(str);
    str = localStringBuilder.toString();
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(str, 0).getInt(d(paramString), 0);
    paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a();
    if (i >= paramString.m) {}
    for (boolean bool = false;; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "shouldCheckNewMember config.nm_newMemberIndex = " + paramString.m + ",value = " + i + ",result = " + bool);
      }
      return bool;
    }
  }
  
  public int b(String paramString)
  {
    int i = 0;
    String str = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_gt_af_daily_").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).append("_").append(str);
    str = localStringBuilder.toString();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(str, 0).contains(a(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "canBeRecommendedOrNot has recommended today ,uin = " + paramString);
      }
      i = -1;
    }
    int j = i;
    if (i >= 0) {
      j = a(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "canBeRecommendedOrNot uin = " + paramString + ",result = " + j);
    }
    return j;
  }
  
  String b(String paramString)
  {
    return "daily_troop_tips_count_" + paramString;
  }
  
  public ArrayList<bcmh> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("list");
        i = 0;
        if (i < paramString.length())
        {
          JSONObject localJSONObject = (JSONObject)paramString.get(i);
          if (localJSONObject == null) {
            break label174;
          }
          String str = localJSONObject.optString("mem");
          int j = localJSONObject.optInt("type");
          long l1 = localJSONObject.optLong("time");
          long l2 = localJSONObject.optLong("seq");
          if (str != null) {
            localArrayList.add(new bcmh(this, str, j, l1, l2));
          } else {
            QLog.e("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "memberUin is null ");
          }
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "FlagMsgInfoFromJson " + paramString.toString());
      }
      return localArrayList;
      label174:
      i += 1;
    }
  }
  
  public void b(bctz parambctz)
  {
    if ((parambctz == null) || (TextUtils.isEmpty(parambctz.c))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onFailed troopUin_type_ts=%s_%d_%d", new Object[] { parambctz.c, Integer.valueOf(parambctz.jdField_a_of_type_Int), Long.valueOf(parambctz.jdField_a_of_type_Long) }));
    }
    if (parambctz.jdField_a_of_type_Int == 2) {
      bcpa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambctz.c, 101509131);
    }
    a(parambctz.c);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "markDailyTroopNewMemberGrayTipShownCount ");
    }
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    TroopInfo localTroopInfo = localTroopManager.b(paramString);
    if (localTroopInfo == null) {}
    int i;
    do
    {
      return;
      Object localObject = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("troop_gt_af_daily_").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).append("_").append((String)localObject);
      localObject = localStringBuilder.toString();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences((String)localObject, 0);
      paramString = d(paramString);
      i = ((SharedPreferences)localObject).getInt(paramString, 0) + 1;
      ((SharedPreferences)localObject).edit().putInt(paramString, i).apply();
      localTroopManager.b(localTroopInfo);
    } while (!QLog.isColorLevel());
    QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "markDailyTroopNewMemberGrayTipShownCount key = " + paramString + ",value = " + i + ",dailyNewMemberUins = " + localTroopInfo.dailyNewMemberUins);
  }
  
  public void b(String paramString1, String paramString2)
  {
    String str1 = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("troop_gt_af_daily_").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).append("_").append(str1);
    str1 = ((StringBuilder)localObject).toString();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(str1, 0);
    str1 = a(paramString1);
    int i = ((SharedPreferences)localObject).getInt(str1, 0) + 1;
    ((SharedPreferences)localObject).edit().putInt(str1, i).apply();
    String str2 = b(paramString2);
    int j = ((SharedPreferences)localObject).getInt(str2, 0);
    ((SharedPreferences)localObject).edit().putInt(str2, j + 1).apply();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("troop_gt_af_total_").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localObject = ((StringBuilder)localObject).toString();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences((String)localObject, 0);
    str2 = c(paramString1);
    j = ((SharedPreferences)localObject).getInt(str2, 0);
    ((SharedPreferences)localObject).edit().putInt(str2, j + 1).apply();
    if (QLog.isColorLevel()) {
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "markHasShownTipDaily key = " + str1 + ",value = " + i + ",uin = " + paramString1 + ",troopCode = " + paramString2);
    }
  }
  
  public boolean b(String paramString)
  {
    return bcpx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
  }
  
  String c(String paramString)
  {
    return "total_rec_uin_" + paramString;
  }
  
  public void c(String paramString)
  {
    boolean bool = false;
    if (TextUtils.isEmpty(paramString)) {}
    bctz localbctz;
    do
    {
      return;
      localbctz = a(paramString);
      if (QLog.isColorLevel())
      {
        if (localbctz != null) {
          bool = true;
        }
        QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onStartCheckInAIO %s scene exist:%b", new Object[] { paramString, Boolean.valueOf(bool) }));
      }
    } while (localbctz == null);
    localbctz.a();
  }
  
  public void c(String paramString1, String paramString2)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    TroopInfo localTroopInfo = localTroopManager.b(paramString1);
    if (localTroopInfo == null) {
      return;
    }
    QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, new Object[] { "markNewMemberIndexAndUinDaily [", paramString1, ",", paramString2, "]" });
    String str = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("troop_gt_af_daily_").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).append("_").append(str);
    localObject = ((StringBuilder)localObject).toString();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences((String)localObject, 0);
    paramString1 = "troopNewMember_" + paramString1;
    int i = ((SharedPreferences)localObject).getInt(paramString1, 0) + 1;
    ((SharedPreferences)localObject).edit().putInt(paramString1, i).apply();
    if (TextUtils.isEmpty(localTroopInfo.dailyNewMemberUins)) {
      localTroopInfo.dailyNewMemberUins = (str + "|" + paramString2);
    }
    for (;;)
    {
      localTroopManager.b(localTroopInfo);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "mark dailyNewMember key = " + paramString1 + ",value = " + i + ",dailyNewMemberUins = " + localTroopInfo.dailyNewMemberUins);
      return;
      if (localTroopInfo.dailyNewMemberUins.startsWith(str)) {
        localTroopInfo.dailyNewMemberUins = (localTroopInfo.dailyNewMemberUins + "|" + paramString2);
      } else {
        localTroopInfo.dailyNewMemberUins = (str + "|" + paramString2);
      }
    }
  }
  
  public boolean c(String paramString)
  {
    String str = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_gt_af_daily_").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).append("_").append(str);
    str = localStringBuilder.toString();
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(str, 0).getInt(b(paramString), 0);
    paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a();
    if (i >= paramString.e) {}
    for (boolean bool = false;; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "canShowTipsOrNot config.tipsTotalCountForTroopEveryday = " + paramString.e + ",value = " + i + ",result = " + bool);
      }
      return bool;
    }
  }
  
  String d(String paramString)
  {
    return "daily_troop_new_member_tips_count_" + paramString;
  }
  
  public void d(String paramString)
  {
    boolean bool = false;
    if (TextUtils.isEmpty(paramString)) {}
    bctz localbctz;
    do
    {
      do
      {
        return;
        localbctz = a(paramString);
        if (QLog.isColorLevel())
        {
          if (localbctz != null) {
            bool = true;
          }
          QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("insertTip aio %s scene valid:%b", new Object[] { paramString, Boolean.valueOf(bool) }));
        }
      } while (localbctz == null);
      localbctz.b();
      a(paramString);
    } while (localbctz.jdField_a_of_type_Int != 2);
    bcpa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbctz.c, 101509131);
  }
  
  public void d(String paramString1, String paramString2)
  {
    Object localObject2 = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    TroopInfo localTroopInfo = localTroopManager.b(paramString1);
    if ((localTroopInfo != null) && (!TextUtils.isEmpty(localTroopInfo.dailyNewMemberUins)) && (localTroopInfo.dailyNewMemberUins.startsWith((String)localObject2)))
    {
      Object localObject3 = localTroopInfo.dailyNewMemberUins.split("\\|");
      Object localObject1 = new ArrayList();
      int i = 1;
      while (i < localObject3.length)
      {
        if (!localObject3[i].equals(paramString2)) {
          ((ArrayList)localObject1).add(localObject3[i]);
        }
        i += 1;
      }
      if (((ArrayList)localObject1).size() <= 0) {
        break label250;
      }
      localObject2 = new StringBuilder((String)localObject2);
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (String)((Iterator)localObject1).next();
        ((StringBuilder)localObject2).append("|").append((String)localObject3);
      }
    }
    label250:
    for (localTroopInfo.dailyNewMemberUins = ((StringBuilder)localObject2).toString();; localTroopInfo.dailyNewMemberUins = "")
    {
      localTroopManager.b(localTroopInfo);
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "remove dailyNewMember  troopUin = " + paramString1 + ",newMemberUin = " + paramString2);
      }
      return;
    }
  }
  
  public boolean d(String paramString)
  {
    synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      if ((bctz)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) == null)
      {
        bool = false;
        QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, "clearTroopScence " + bool + " " + paramString);
        return bool;
      }
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      boolean bool = true;
    }
  }
  
  public void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onActivePush troopUin=%s", new Object[] { paramString }));
    }
    ThreadManager.executeOnSubThread(new TroopBatchAddFriendMgr.3(this, paramString), true);
  }
  
  public boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (int i = 1;; i = 0)
    {
      if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        i = 2;
      }
      for (;;)
      {
        alto localalto = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        int j = i;
        if (localalto != null)
        {
          j = i;
          if (localalto.b(paramString)) {
            j = 3;
          }
        }
        if (bclg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString)) {
          j = 4;
        }
        if ((QLog.isColorLevel()) && (j != 0)) {
          QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "preCheckUin failed in circumstance:" + j);
        }
        return j == 0;
      }
    }
  }
  
  public void f(String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    Object localObject = localTroopManager.b(paramString);
    int i;
    if ((localObject != null) && (!TextUtils.isEmpty(((TroopInfo)localObject).mAtOrReplyMeUins)))
    {
      ArrayList localArrayList2 = b(((TroopInfo)localObject).mAtOrReplyMeUins);
      ((TroopInfo)localObject).mAtOrReplyMeUins = "";
      localTroopManager.c((TroopInfo)localObject);
      if ((localArrayList2 != null) && (localArrayList2.size() > 0))
      {
        long l = System.currentTimeMillis() / 1000L;
        i = 0;
        if (i < localArrayList2.size())
        {
          localObject = (bcmh)localArrayList2.get(i);
          if ((l - ((bcmh)localObject).jdField_a_of_type_Long < (localTroopManager.a().a * 24.0D * 3600.0D)) && (!TextUtils.isEmpty(((bcmh)localObject).jdField_a_of_type_JavaLangString)))
          {
            j = 0;
            label158:
            if (j >= localArrayList1.size()) {
              break label295;
            }
            String str = (String)localArrayList1.get(j);
            if ((TextUtils.isEmpty(str)) || (!((bcmh)localObject).jdField_a_of_type_JavaLangString.equals(str))) {
              break label223;
            }
          }
        }
      }
    }
    label295:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        localArrayList1.add(((bcmh)localObject).jdField_a_of_type_JavaLangString);
      }
      i += 1;
      break;
      label223:
      j += 1;
      break label158;
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "checkTriggerTipsAndCleanAtOrReplyMsg visibleUins size = " + localArrayList1.size() + ",visibleUins = " + localArrayList1);
      }
      if (localArrayList1.size() > 0) {
        a(paramString, localArrayList1, 5);
      }
      return;
    }
  }
  
  public void g(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr
 * JD-Core Version:    0.7.0.1
 */