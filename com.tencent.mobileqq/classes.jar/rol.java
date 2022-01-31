import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.2;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.3;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.4;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.5;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.6;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.7;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.8;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.9;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class rol
{
  private static Set<String> jdField_a_of_type_JavaUtilSet;
  private static rol jdField_a_of_type_Rol = new rol();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final ajmm jdField_a_of_type_Ajmm = new rom(this);
  private CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, rof> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<rof> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ron jdField_a_of_type_Ron = new ron(this);
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString = "";
  private final HashMap<String, Integer> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private List<rof> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private long e;
  
  static
  {
    jdField_a_of_type_JavaUtilSet = new HashSet();
    jdField_a_of_type_JavaUtilSet.add(new String("2171946401"));
  }
  
  public static int a()
  {
    return 2130839781;
  }
  
  private static int a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    int i;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      i = a().a(paramString, 1, 0);
      if (i > 0)
      {
        paramQQAppInterface = new StringBuilder(150);
        paramQQAppInterface.append("updateServiceAccountBelongInfo(");
        paramQQAppInterface.append(i);
        paramQQAppInterface.append(")->getPublicAccountFolderType->puin:");
        paramQQAppInterface.append(paramString);
        paramQQAppInterface.append(", folder type:");
        paramQQAppInterface.append(1);
        paramQQAppInterface.append(", error param, default service folder!");
        QLog.d("ServiceAccountFolderManager", 1, paramQQAppInterface.toString());
      }
      i = 1;
      label94:
      return i;
    }
    Object localObject3 = (ajoy)paramQQAppInterface.getManager(56);
    if (localObject3 != null) {
      if (!ahca.a(paramQQAppInterface)) {}
    }
    label448:
    label1108:
    for (;;)
    {
      AccountDetail localAccountDetail;
      int k;
      try
      {
        Object localObject1 = ((ajoy)localObject3).a(paramString, true);
        if (localObject1 != null) {
          break label1108;
        }
        localAccountDetail = ((ajoy)localObject3).b(paramString);
        localObject3 = localObject1;
        localObject1 = localAccountDetail;
        if ((localObject3 == null) && (localObject1 == null)) {
          break label535;
        }
        if (localObject3 == null) {
          break label448;
        }
        l = ((PublicAccountInfo)localObject3).accountFlag2;
        j = (int)((0x7800 & l) >> 11);
        i = -1;
        switch (j)
        {
        default: 
          if (localObject3 == null) {
            break label478;
          }
          j = ((PublicAccountInfo)localObject3).accountFlag;
          k = rtr.a(j);
          if (!rtr.a(j, l)) {
            break label488;
          }
          j = 2;
          if ((i != 0) || (j != 2)) {
            break label507;
          }
          j = 1;
          k = a().a(paramString, j, 1);
          i = j;
          if (k <= 0) {
            break label94;
          }
          paramQQAppInterface = new StringBuilder(256);
          paramQQAppInterface.append("updateServiceAccountBelongInfo(");
          paramQQAppInterface.append(k);
          paramQQAppInterface.append(")->getPublicAccountFolderType->puin:");
          paramQQAppInterface.append(paramString);
          paramQQAppInterface.append(", folder type:");
          paramQQAppInterface.append(j);
          if (localObject3 != null)
          {
            paramQQAppInterface.append(", info accountFlag:");
            paramQQAppInterface.append(((PublicAccountInfo)localObject3).accountFlag);
            paramQQAppInterface.append(", info accountFlag2:");
            paramQQAppInterface.append(((PublicAccountInfo)localObject3).accountFlag2);
          }
          if (localObject1 != null)
          {
            paramQQAppInterface.append(", detail accountFlag:");
            paramQQAppInterface.append(((AccountDetail)localObject1).accountFlag);
            paramQQAppInterface.append(", detail accountFlag2:");
            paramQQAppInterface.append(((AccountDetail)localObject1).accountFlag2);
          }
          QLog.d("ServiceAccountFolderManager", 1, paramQQAppInterface.toString());
          return j;
        }
      }
      catch (Throwable localThrowable)
      {
        localObject2 = ((ajoy)localObject3).b(paramString);
        continue;
      }
      Object localObject2 = ((ajoy)localObject3).b(paramString);
      continue;
      long l = ((AccountDetail)localObject2).accountFlag2;
      continue;
      i = 2;
      continue;
      i = 1;
      continue;
      i = 0;
      continue;
      i = 3;
      continue;
      label478:
      int j = ((AccountDetail)localObject2).accountFlag;
      continue;
      label488:
      if (k == -5)
      {
        j = 3;
      }
      else
      {
        j = 1;
        continue;
        label507:
        if ((i == 2) && (j == 1))
        {
          j = 1;
        }
        else if (i != -1)
        {
          j = i;
          continue;
          if (b(paramString)) {
            return 0;
          }
          if (paramQQAppInterface != null)
          {
            localObject2 = ((ajjj)paramQQAppInterface.getManager(51)).b(paramString);
            if ((localObject2 != null) && (((Friends)localObject2).isFriend()))
            {
              QLog.d("ServiceAccountFolderManager", 1, " getPublicAccountFolderType error, is UIN_TYPE_PUBLIC_ACCOUNT, but is friend relation  puin = " + paramString);
              localObject2 = new HashMap();
              ((HashMap)localObject2).put("self_uin", paramQQAppInterface.getCurrentAccountUin());
              ((HashMap)localObject2).put("inValid_uin", paramString);
              awrn.a(BaseApplicationImpl.getContext()).a(paramString, "ServiceAccountFolderManager_InValid_puin", false, 1L, 0L, (HashMap)localObject2, null);
              return 0;
            }
          }
          localObject2 = paramQQAppInterface.a().a(paramString, 1008);
          if (localObject2 != null)
          {
            if (((MessageRecord)localObject2).istroop != 1008)
            {
              QLog.d("ServiceAccountFolderManager", 1, " getPublicAccountFolderType error, not UIN_TYPE_PUBLIC_ACCOUNT, msg info is " + ((MessageRecord)localObject2).toString() + " puin = " + paramString);
              localObject3 = new HashMap();
              if (paramQQAppInterface != null) {
                ((HashMap)localObject3).put("self_uin", paramQQAppInterface.getCurrentAccountUin());
              }
              ((HashMap)localObject3).put("inValid_uin", paramString);
              ((HashMap)localObject3).put("inValid_msg_troop", String.valueOf(((MessageRecord)localObject2).istroop));
              ((HashMap)localObject3).put("inValid_msg_content", ((MessageRecord)localObject2).toString());
              awrn.a(BaseApplicationImpl.getContext()).a(paramString, "ServiceAccountFolderManager_InValid_Msg", false, 1L, 0L, (HashMap)localObject3, null);
              return 0;
            }
            if (myn.a((MessageRecord)localObject2)) {
              return 0;
            }
            paramQQAppInterface = ((MessageRecord)localObject2).getExtInfoFromExtStr("inter_num");
            if ((!TextUtils.isEmpty(paramQQAppInterface)) && (paramQQAppInterface.equals("1")))
            {
              i = a().a(paramString, 2, 2);
              if (i > 0)
              {
                paramQQAppInterface = new StringBuilder(128);
                paramQQAppInterface.append("updateServiceAccountBelongInfo(");
                paramQQAppInterface.append(i);
                paramQQAppInterface.append(")->getPublicAccountFolderType->puin:");
                paramQQAppInterface.append(paramString);
                paramQQAppInterface.append(", folder type:");
                paramQQAppInterface.append(2);
                paramQQAppInterface.append(", inter_num:1");
                QLog.d("ServiceAccountFolderManager", 1, paramQQAppInterface.toString());
              }
              return 2;
            }
            if ((!TextUtils.isEmpty(paramQQAppInterface)) && (paramQQAppInterface.equals("2")))
            {
              i = a().a(paramString, 3, 2);
              if (i > 0)
              {
                paramQQAppInterface = new StringBuilder(128);
                paramQQAppInterface.append("updateServiceAccountBelongInfo(");
                paramQQAppInterface.append(i);
                paramQQAppInterface.append(")->getPublicAccountFolderType->puin:");
                paramQQAppInterface.append(paramString);
                paramQQAppInterface.append(", folder type:");
                paramQQAppInterface.append(3);
                paramQQAppInterface.append(", inter_num:2");
                QLog.d("ServiceAccountFolderManager", 1, paramQQAppInterface.toString());
              }
              return 3;
            }
          }
          i = a().a(paramString, 1, 2);
          if (i > 0)
          {
            paramQQAppInterface = new StringBuilder(150);
            paramQQAppInterface.append("updateServiceAccountBelongInfo(");
            paramQQAppInterface.append(i);
            paramQQAppInterface.append(")->getPublicAccountFolderType->puin:");
            paramQQAppInterface.append(paramString);
            paramQQAppInterface.append(", folder type:");
            paramQQAppInterface.append(1);
            paramQQAppInterface.append(", no info to judge, default service folder!");
            QLog.d("ServiceAccountFolderManager", 1, paramQQAppInterface.toString());
          }
          return 1;
          localAccountDetail = null;
          localObject3 = localObject2;
          localObject2 = localAccountDetail;
          continue;
          localObject2 = null;
          localObject3 = null;
        }
      }
    }
  }
  
  private int a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountBelongInfo->empty puin!");
      }
      return 0;
    }
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      Integer localInteger = Integer.valueOf((paramInt1 << 2) + paramInt2);
      if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        if ((this.jdField_b_of_type_JavaUtilHashMap.get(paramString) == null) || (!localInteger.equals(this.jdField_b_of_type_JavaUtilHashMap.get(paramString))))
        {
          this.jdField_b_of_type_JavaUtilHashMap.put(paramString, localInteger);
          return 2;
        }
      }
      else
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(paramString, localInteger);
        return 1;
      }
    }
    return 0;
  }
  
  public static Drawable a()
  {
    Drawable localDrawable = BaseApplicationImpl.sApplication.getResources().getDrawable(a());
    Object localObject = localDrawable;
    if (!TextUtils.isEmpty(rsp.jdField_e_of_type_JavaLangString)) {
      localObject = URLDrawable.getDrawable(rsp.jdField_e_of_type_JavaLangString, localDrawable, localDrawable);
    }
    return localObject;
  }
  
  public static String a(int paramInt)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", String.valueOf(paramInt));
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    if (TextUtils.isEmpty(rsp.jdField_d_of_type_JavaLangString)) {
      return rsp.b();
    }
    return rsp.jdField_d_of_type_JavaLangString;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.a().a(paramString, 1008, 15);
    if ((paramQQAppInterface == null) || (paramQQAppInterface.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getLastExtraInfo->puin:" + paramString + " no message list");
      }
      return "";
    }
    int i = paramQQAppInterface.size() - 1;
    for (;;)
    {
      Object localObject;
      if (i >= 0)
      {
        localObject = (MessageRecord)paramQQAppInterface.get(i);
        if (((MessageRecord)localObject).isread) {
          break label173;
        }
        localObject = ((MessageRecord)localObject).getExtInfoFromExtStr("public_account_msg_extra_info_type");
        if (!"1".equals(localObject)) {
          break label163;
        }
      }
      label163:
      while ("2".equals(localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderManager", 2, "getLastExtraInfo->puin:" + paramString + ", extraInfo:" + "");
        }
        return "";
      }
      label173:
      i -= 1;
    }
  }
  
  public static rol a()
  {
    if (jdField_a_of_type_Rol == null) {}
    try
    {
      jdField_a_of_type_Rol = new rol();
      return jdField_a_of_type_Rol;
    }
    finally {}
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "updateMsgState->puin:" + paramString + " begin update");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {}
    do
    {
      ajoy localajoy;
      do
      {
        return;
        localajoy = (ajoy)localQQAppInterface.getManager(56);
      } while ((localajoy != null) && (localajoy.c(paramString) == null) && (localajoy.b(paramString) == null));
      if (rtr.a(localQQAppInterface, paramString) != -7) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ServiceAccountFolderManager", 2, "updateMsgState->puin:" + paramString + " is EQQ, return!");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "updateMsgState->puin:" + paramString + " do update");
    }
    a(localQQAppInterface, paramString);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return a(paramQQAppInterface, paramString, true) == 0;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = true;
    if (b(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "isBelongServiceAccountFolder->puin:" + paramString + ", inOutFolderWhiteList!");
      }
      return false;
    }
    int i = a(paramQQAppInterface, paramString, true);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "isBelongServiceAccountFolder->puin:" + paramString + ", type:" + i);
    }
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = true;
    if (b(paramString)) {
      return false;
    }
    if (a(paramQQAppInterface, paramString, false) == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = false;
    if (a(paramQQAppInterface, paramString, false) == 2) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean e(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = false;
    int i = a(paramQQAppInterface, paramString, false);
    if (QLog.isColorLevel()) {
      QLog.d("EcShopAssistantManager", 2, "isBelongEcShopFolder->puin:" + paramString + ", type:" + i);
    }
    if (i == 3) {
      bool = true;
    }
    return bool;
  }
  
  public int a(QQAppInterface paramQQAppInterface)
  {
    int i = 2;
    if (b() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getFolderUnreadType->type:1");
      }
      i = 1;
    }
    do
    {
      return i;
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getFolderUnreadType->type:0");
      }
    } while ((a()) && (a(paramQQAppInterface) > b()));
    return 0;
  }
  
  public long a()
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          i = 0;
          if (i < this.jdField_a_of_type_JavaUtilList.size())
          {
            if (TextUtils.isEmpty(((rof)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangCharSequence)) {
              break label158;
            }
            rof localrof = (rof)this.jdField_a_of_type_JavaUtilList.get(i);
            long l = a(localrof);
            if (QLog.isColorLevel()) {
              QLog.d("ServiceAccountFolderManager", 2, "getFolderLastShowMsgId->msgId:" + l);
            }
            return l;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderManager", 2, "getFolderLastShowMsgId->msgId:0");
          }
          return 0L;
        }
      }
      Object localObject2 = null;
      continue;
      label158:
      i += 1;
    }
  }
  
  public long a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_Long == 0L) && (!this.jdField_a_of_type_Boolean))
    {
      f(paramQQAppInterface);
      this.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderDisplayTime->mFolderDisplayTime:" + this.jdField_a_of_type_Long);
    }
    return this.jdField_a_of_type_Long;
  }
  
  public long a(rof paramrof)
  {
    if (paramrof == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getFeedMsgId->empty feed");
      }
      return 0L;
    }
    paramrof = paramrof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if ((paramrof != null) && ((paramrof instanceof MessageForStructing)))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramrof;
      paramrof = localMessageForStructing.structingMsg;
      if (paramrof != null) {
        break label110;
      }
      paramrof = awuw.a(localMessageForStructing.msgData);
    }
    label110:
    for (;;)
    {
      if (paramrof != null) {}
      for (long l = paramrof.msgId;; l = 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderManager", 2, "getFeedMsgId->msgId:" + l);
        }
        return l;
      }
    }
  }
  
  public CharSequence a(QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)) && (!this.jdField_a_of_type_Boolean))
    {
      f(paramQQAppInterface);
      this.jdField_a_of_type_Boolean = true;
      return new axkd(this.jdField_a_of_type_JavaLangCharSequence, 3, 16);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderMsgBrief->mFolderMsgBrief:" + this.jdField_a_of_type_JavaLangCharSequence);
    }
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public CharSequence a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    QQMessageFacade.Message localMessage = new QQMessageFacade.Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    paramQQAppInterface.a().a(localMessage);
    paramMessageRecord = new MsgSummary();
    bado.a(paramQQAppInterface.getApplication(), paramQQAppInterface, localMessage, localMessage.istroop, paramMessageRecord, localMessage.nickName, false, paramBoolean);
    return paramMessageRecord.a(paramQQAppInterface.getApplication());
  }
  
  public String a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        Object localObject2 = (rof)this.jdField_a_of_type_JavaUtilList.get(0);
        if (localObject2 != null)
        {
          localObject2 = ((rof)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          if (localObject2 != null)
          {
            localObject2 = ((MessageRecord)localObject2).frienduin;
            if (QLog.isColorLevel()) {
              QLog.d("ServiceAccountFolderManager", 2, "getFolderLastMsgUin->msgUin:" + (String)localObject2);
            }
            return localObject2;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getFolderLastMsgUin->msgUin:0");
      }
      return "0";
    }
  }
  
  public List<rof> a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderManager", 2, "getDataList->empty DataList");
        }
        return null;
      }
      StringBuilder localStringBuilder;
      try
      {
        List localList = (List)((ArrayList)this.jdField_a_of_type_JavaUtilList).clone();
        if (!QLog.isColorLevel()) {
          break label214;
        }
        int i = localList.size();
        localStringBuilder = new StringBuilder("getDataList->");
        localStringBuilder.append("size:").append(i).append(", content:[");
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext()) {
          localStringBuilder.append(((rof)localIterator.next()).jdField_a_of_type_JavaLangString).append(",");
        }
        if (i <= 0) {
          break label194;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderManager", 2, "getDataList->exception:" + localException.getStackTrace());
        }
        return null;
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      label194:
      localStringBuilder.append("]");
      QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
      label214:
      return localException;
    }
  }
  
  public List<rof> a(QQAppInterface paramQQAppInterface)
  {
    RecentUser localRecentUser = null;
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "refreshDataList!");
    }
    if (paramQQAppInterface == null) {
      return this.jdField_a_of_type_JavaUtilList;
    }
    if (!paramQQAppInterface.getAccount().equals(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "refreshDataList->new cuin:" + paramQQAppInterface.getAccount() + ", old cuin:" + this.jdField_a_of_type_JavaLangString);
      }
      a(paramQQAppInterface);
    }
    Object localObject1;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      localObject1 = rqn.a().a(paramQQAppInterface);
      localObject3 = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (TroopBarData)((Iterator)localObject1).next();
        if (b(paramQQAppInterface, ((TroopBarData)localObject4).mUin))
        {
          localObject4 = rql.a(paramQQAppInterface, paramQQAppInterface.getApplication(), (TroopBarData)localObject4);
          if (localObject4 != null)
          {
            if ((((rql)localObject4).jdField_a_of_type_JavaUtilList != null) && (((rql)localObject4).jdField_a_of_type_JavaUtilList.size() > 0))
            {
              localObject5 = (rqm)((rql)localObject4).jdField_a_of_type_JavaUtilList.get(0);
              if ((TextUtils.isEmpty(((rqm)localObject5).jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(((rqm)localObject5).jdField_c_of_type_JavaLangString))) {
                ((rqm)localObject5).jdField_b_of_type_JavaLangString = ((rqm)localObject5).jdField_c_of_type_JavaLangString;
              }
            }
            ((List)localObject3).add(localObject4);
          }
        }
      }
    }
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      localObject4 = ((List)localObject3).iterator();
      if (!QLog.isColorLevel()) {
        break label790;
      }
      localObject1 = new StringBuilder("refreshDataList->SubscriptionFeedList size:");
      ((StringBuilder)localObject1).append(((List)localObject3).size()).append(", content:{");
    }
    for (;;)
    {
      if (((Iterator)localObject4).hasNext())
      {
        localObject3 = (rql)((Iterator)localObject4).next();
        if ((QLog.isColorLevel()) && (localObject1 != null)) {
          ((StringBuilder)localObject1).append("[").append(((rql)localObject3).jdField_a_of_type_JavaLangString).append(", ").append(((rql)localObject3).jdField_a_of_type_Int).append("]");
        }
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(((rql)localObject3).jdField_a_of_type_JavaLangString))
        {
          localObject5 = rof.a(paramQQAppInterface, (rql)localObject3);
          if (((rof)localObject5).jdField_b_of_type_Boolean)
          {
            this.jdField_a_of_type_JavaUtilList.add(localObject5);
            this.jdField_a_of_type_JavaUtilHashMap.put(((rql)localObject3).jdField_a_of_type_JavaLangString, localObject5);
          }
        }
      }
      else
      {
        if ((QLog.isColorLevel()) && (localObject1 != null))
        {
          ((StringBuilder)localObject1).append("}");
          QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject1).toString());
        }
        for (;;)
        {
          localObject4 = paramQQAppInterface.a().a().a(false);
          if ((localObject4 == null) || (((List)localObject4).size() <= 0)) {
            break label772;
          }
          localObject3 = ((List)localObject4).iterator();
          localObject1 = localRecentUser;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder("refreshDataList->RecentList size:");
            ((StringBuilder)localObject1).append(((List)localObject4).size()).append(", content:{");
          }
          while (((Iterator)localObject3).hasNext())
          {
            localRecentUser = (RecentUser)((Iterator)localObject3).next();
            if ((QLog.isColorLevel()) && (localObject1 != null)) {
              ((StringBuilder)localObject1).append("[").append(localRecentUser.uin).append(", ").append(localRecentUser.getType()).append("]");
            }
            if ((localRecentUser.getType() == 1008) && (b(paramQQAppInterface, localRecentUser.uin)) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localRecentUser.uin)))
            {
              localObject4 = rof.a(paramQQAppInterface, localRecentUser);
              if (((rof)localObject4).jdField_b_of_type_Boolean)
              {
                this.jdField_a_of_type_JavaUtilList.add(localObject4);
                this.jdField_a_of_type_JavaUtilHashMap.put(localRecentUser.uin, localObject4);
              }
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderManager", 2, "refreshDataList->empty SubscriptionFeedList!");
          }
        }
        if ((QLog.isColorLevel()) && (localObject1 != null))
        {
          ((StringBuilder)localObject1).append("}");
          QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject1).toString());
        }
        for (;;)
        {
          h(paramQQAppInterface);
          return this.jdField_a_of_type_JavaUtilList;
          label772:
          if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderManager", 2, "refreshDataList->empty RecentList!");
          }
        }
        label790:
        localObject1 = null;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_JavaLangString.equals(paramQQAppInterface.getAccount())))
    {
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
      if (localSharedPreferences != null)
      {
        this.jdField_c_of_type_Long = localSharedPreferences.getLong("service_account_folder_last_read_time", 0L);
        this.jdField_d_of_type_Long = localSharedPreferences.getLong("service_account_folder_last_enter_time", 0L);
        rsp.p = localSharedPreferences.getBoolean("service_folder_redclean_after_enter", false);
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderManager", 2, "initManager->mFolderLastReadTime:" + this.jdField_c_of_type_Long + ", mFolderLastEnterTime:" + this.jdField_d_of_type_Long);
        }
      }
      this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getAccount();
      this.jdField_a_of_type_Boolean = false;
      b(paramQQAppInterface);
      paramQQAppInterface.addObserver(this.jdField_a_of_type_Ajmm, true);
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "initManager->cuin:" + this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_d_of_type_Long = paramLong;
    ThreadManager.executeOnFileThread(new ServiceAccountFolderManager.6(this, paramQQAppInterface));
  }
  
  public void a(QQAppInterface paramQQAppInterface, AccountDetail paramAccountDetail)
  {
    paramAccountDetail = paramAccountDetail.uin;
    if (TextUtils.isEmpty(paramAccountDetail))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "handleAccountDetailChange->empty uin");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "handleAccountDetailChange->update feed");
    }
    a(paramQQAppInterface, paramAccountDetail);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObject = (MessageRecord)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "addMessageToServiceAccountFolder->friend uin:" + paramObject.frienduin + ", istroop:" + paramObject.istroop);
      }
      if ((paramObject.istroop == 1008) && (b(paramQQAppInterface, paramObject.frienduin))) {
        break label116;
      }
      paramQQAppInterface = paramQQAppInterface.getHandler(ServiceAccountFolderActivity.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.sendEmptyMessage(102);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "addMessageToServiceAccountFolder->msg not belong serviceAccountFolder");
      }
    }
    for (;;)
    {
      return;
      label116:
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "addMessageToServiceAccountFolder->go to update feed");
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        ThreadManager.executeOnSubThread(new ServiceAccountFolderManager.3(this, paramQQAppInterface, paramObject));
      }
      while (!paramObject.isSendFromLocal())
      {
        b(paramQQAppInterface, 0L);
        return;
        a(paramQQAppInterface, paramObject.frienduin);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.executeOnSubThread(new ServiceAccountFolderManager.9(this, paramQQAppInterface, paramString));
      return;
    }
    for (;;)
    {
      rof localrof;
      int i;
      int j;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          localrof = (rof)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
          localrof.jdField_a_of_type_JavaLangString = paramString;
          localObject2 = (ajoy)paramQQAppInterface.getManager(56);
          if (localObject2 != null)
          {
            PublicAccountInfo localPublicAccountInfo = ((ajoy)localObject2).c(paramString);
            if (localPublicAccountInfo != null)
            {
              localrof.jdField_c_of_type_JavaLangString = localPublicAccountInfo.name;
              localrof.jdField_b_of_type_Boolean = localPublicAccountInfo.isVisible();
              localrof.jdField_c_of_type_Int = 0;
            }
          }
          else
          {
            localrof.jdField_b_of_type_Int = paramQQAppInterface.a().b(paramString, 1008);
            i = paramQQAppInterface.a().f(paramString, 1008);
            if (localrof.jdField_b_of_type_Int <= 0) {
              break label771;
            }
            if ((localrof.jdField_b_of_type_Int != 1) || (i <= 0)) {
              break label746;
            }
            localrof.jdField_a_of_type_Int = 2;
            localObject2 = paramQQAppInterface.a();
            if (localObject2 == null) {
              break label990;
            }
            localrof.jdField_b_of_type_JavaLangCharSequence = null;
            localrof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((QQMessageFacade)localObject2).b(paramString, 1008);
            localObject2 = ((QQMessageFacade)localObject2).a(paramString, 1008);
            if ((localObject2 == null) || (TextUtils.isEmpty(((DraftSummaryInfo)localObject2).getSummary()))) {
              break label837;
            }
            if ((localrof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (((DraftSummaryInfo)localObject2).getTime() <= localrof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time)) {
              break label780;
            }
            localrof.jdField_e_of_type_Int = 4;
            localrof.jdField_a_of_type_Long = ((DraftSummaryInfo)localObject2).getTime();
            localrof.jdField_b_of_type_JavaLangString = ahcw.a().a(localrof.jdField_a_of_type_JavaLangString, ((DraftSummaryInfo)localObject2).getTime());
            localrof.jdField_a_of_type_JavaLangCharSequence = ((DraftSummaryInfo)localObject2).getSummary();
            i = 0;
            localrof.jdField_d_of_type_JavaLangString = a(paramQQAppInterface, localrof.jdField_a_of_type_JavaLangString);
            localrof.jdField_a_of_type_Boolean = true;
            if (!rqn.a().a(paramQQAppInterface, paramString, 1008)) {
              break label944;
            }
            localrof.jdField_a_of_type_Boolean = false;
            if ((paramQQAppInterface.a() == null) || (paramQQAppInterface.a().a() == null)) {
              break label987;
            }
            localObject2 = paramQQAppInterface.a().a().a(paramString, 1008);
            if (localObject2 == null) {
              break label987;
            }
            localrof.jdField_b_of_type_Long = ((RecentUser)localObject2).lastmsgtime;
            if ((i == 0) || (localrof.jdField_b_of_type_Long <= 0L)) {
              break label987;
            }
            localrof.jdField_a_of_type_Long = localrof.jdField_b_of_type_Long;
            localrof.jdField_b_of_type_JavaLangString = ahcw.a().a(paramString, localrof.jdField_a_of_type_Long);
            localrof.jdField_a_of_type_JavaLangCharSequence = "";
            i = 0;
            if (QLog.isColorLevel()) {
              QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountFolderFeed->" + localrof.toString());
            }
            if (rtr.a(paramQQAppInterface, paramString) != -7) {
              break label981;
            }
            j = 1;
            if ((QLog.isColorLevel()) && (j != 0)) {
              QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountFolderFeed->puin:" + localrof.jdField_a_of_type_JavaLangString + " is Eqq!");
            }
            if ((!localrof.jdField_b_of_type_Boolean) || (i != 0) || (j != 0) || (!c(paramQQAppInterface, paramString)))
            {
              this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
              this.jdField_a_of_type_JavaUtilList.remove(localrof);
              if (QLog.isColorLevel()) {
                QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountFolderFeed->remove feed puin:" + localrof.jdField_a_of_type_JavaLangString + ", title:" + localrof.jdField_c_of_type_JavaLangString);
              }
            }
            h(paramQQAppInterface);
            j(paramQQAppInterface);
          }
        }
        else
        {
          localrof = new rof();
          this.jdField_a_of_type_JavaUtilList.add(localrof);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localrof);
          continue;
        }
        Object localObject2 = ((ajoy)localObject2).b(paramString);
        if (localObject2 == null) {
          continue;
        }
        localrof.jdField_c_of_type_JavaLangString = ((AccountDetail)localObject2).name;
        if (1 == ((AccountDetail)localObject2).showFlag)
        {
          bool = true;
          localrof.jdField_b_of_type_Boolean = bool;
          localrof.jdField_c_of_type_Int = 0;
        }
      }
      boolean bool = false;
      continue;
      label746:
      localrof.jdField_a_of_type_Int = 1;
      label771:
      label780:
      label944:
      if (i > 0)
      {
        localrof.jdField_b_of_type_Int -= 1;
        continue;
        localrof.jdField_a_of_type_Int = 0;
        continue;
        localrof.jdField_e_of_type_Int = 0;
        localrof.jdField_a_of_type_Long = localrof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
        localrof.jdField_b_of_type_JavaLangString = ahcw.a().a(paramString, localrof.jdField_a_of_type_Long);
        localrof.jdField_a_of_type_JavaLangCharSequence = a(paramQQAppInterface, localrof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, false);
        i = 0;
        continue;
        label837:
        if ((localrof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (localrof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time > 0L))
        {
          localrof.jdField_e_of_type_Int = 0;
          localrof.jdField_a_of_type_Long = localrof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
          localrof.jdField_b_of_type_JavaLangString = ahcw.a().a(paramString, localrof.jdField_a_of_type_Long);
          localrof.jdField_a_of_type_JavaLangCharSequence = a(paramQQAppInterface, localrof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, false);
          i = 0;
        }
        else
        {
          localrof.jdField_e_of_type_Int = 0;
          localrof.jdField_a_of_type_Long = 0L;
          localrof.jdField_b_of_type_JavaLangString = null;
          localrof.jdField_a_of_type_JavaLangCharSequence = null;
          i = 1;
          continue;
          if ((localrof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ("1".equals(localrof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("inter_num"))))
          {
            localrof.jdField_a_of_type_Boolean = false;
            continue;
            label981:
            j = 0;
            continue;
            label987:
            continue;
            label990:
            i = 0;
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "updateDraft->puin:" + paramString1);
    }
    a(paramQQAppInterface, paramString1);
  }
  
  public void a(QQAppInterface paramQQAppInterface, rof paramrof, boolean paramBoolean)
  {
    String str = paramrof.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "deleteServiceAccountFolderFeed->puin:" + str + ", needRefresh:" + paramBoolean);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))
        {
          rof localrof = (rof)this.jdField_a_of_type_JavaUtilHashMap.get(str);
          if (localrof != null)
          {
            this.jdField_a_of_type_JavaUtilList.remove(localrof);
            this.jdField_a_of_type_JavaUtilHashMap.remove(str);
          }
        }
        if (paramrof.jdField_a_of_type_Boolean)
        {
          paramrof = paramQQAppInterface.a().a().b(paramrof.jdField_a_of_type_JavaLangString, 1008);
          if (paramrof != null) {
            ahcq.a(paramQQAppInterface, paramrof, -1);
          }
          if (paramBoolean)
          {
            h(paramQQAppInterface);
            j(paramQQAppInterface);
          }
          return;
        }
      }
      rqn.a().a(str, paramQQAppInterface);
      ahcq.b(paramQQAppInterface, str, rtr.b(paramQQAppInterface, str));
      paramQQAppInterface.a().c(str, 1008);
    }
  }
  
  public void a(List<rof> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      if (paramList != null) {
        this.jdField_b_of_type_JavaUtilList.addAll(paramList);
      }
      return;
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderHasLittleRedDot->mFolderHasLittleRedDot:" + this.jdField_c_of_type_Boolean);
    }
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "containsFeedWithUin->empty uin, return false");
      }
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "containsFeedWithUin->uin:" + paramString + ", return " + bool);
      }
      return bool;
    }
  }
  
  public int b()
  {
    if (this.e > this.jdField_c_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getFolderUnreadNum->mFolderUnreadNum:" + this.jdField_a_of_type_Int);
      }
      if ((rsp.a()) && (this.jdField_d_of_type_Long >= this.e)) {
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderManager", 2, "enter time:" + this.jdField_d_of_type_Long + "  Last msgtime=" + this.e);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return 0;
      return this.jdField_a_of_type_Int;
    }
    QLog.d("ServiceAccountFolderManager", 2, "getFolderUnreadNum->0");
    return 0;
  }
  
  public long b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderLastEnterTime->mFolderLastEnterTime:" + this.jdField_d_of_type_Long);
    }
    return this.jdField_d_of_type_Long;
  }
  
  public long b(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_b_of_type_Long == 0L) && (!this.jdField_a_of_type_Boolean))
    {
      f(paramQQAppInterface);
      this.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderOperationTime->mFolderOperationTime:" + this.jdField_b_of_type_Long);
    }
    return this.jdField_b_of_type_Long;
  }
  
  public String b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderReportKeyBytesOacMsgxtend->mReportKeyBytesOacMsgxtend:" + this.jdField_d_of_type_JavaLangString);
    }
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public String b(QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!this.jdField_a_of_type_Boolean))
    {
      f(paramQQAppInterface);
      this.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderShowTime->mFolderShowTime:" + this.jdField_b_of_type_JavaLangString);
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public List<rof> b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      List localList = this.jdField_b_of_type_JavaUtilList;
      return localList;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.executeOnSubThread(new ServiceAccountFolderManager.2(this, paramQQAppInterface));
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "refreshAndUpdate->cuin:" + this.jdField_a_of_type_JavaLangString + ", throw to sub thread!");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "refreshAndUpdate->cuin:" + this.jdField_a_of_type_JavaLangString);
    }
    a(paramQQAppInterface);
    j(paramQQAppInterface);
  }
  
  public void b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
    this.jdField_d_of_type_Long = paramLong;
    ThreadManager.executeOnFileThread(new ServiceAccountFolderManager.7(this, paramQQAppInterface));
  }
  
  public void b(QQAppInterface paramQQAppInterface, rof paramrof, boolean paramBoolean)
  {
    if (paramrof == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Int -= paramrof.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_Int < 0) {
        this.jdField_a_of_type_Int = 0;
      }
      paramrof.jdField_b_of_type_Int = 0;
      paramrof = paramrof.jdField_a_of_type_JavaLangString;
      ahcq.b(paramQQAppInterface, paramrof, 1008);
      paramQQAppInterface.a().c(paramrof, 1008);
      paramQQAppInterface.a().a(paramrof, 1008, true);
      a(paramQQAppInterface, paramrof);
      if (paramBoolean) {
        i(paramQQAppInterface);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ServiceAccountFolderManager", 2, "clearServiceAccountFolderFeedUnreadNum->uin:" + paramrof + ", needRefresh:" + paramBoolean);
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "isLastDraftMsg->lastDraft:" + this.jdField_b_of_type_Boolean);
    }
    return this.jdField_b_of_type_Boolean;
  }
  
  public String c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderExtraInfo->mFolderExtraInfo:" + this.jdField_c_of_type_JavaLangString);
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "handleFollowListChange");
    }
    b(paramQQAppInterface);
  }
  
  public void d(QQAppInterface paramQQAppInterface)
  {
    long l = NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "deleteServiceAccountFolder->time:" + l);
    }
    ThreadManager.executeOnSubThread(new ServiceAccountFolderManager.4(this, paramQQAppInterface, l));
  }
  
  public void e(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "clearServiceAccountFolderUnreadNum");
      }
      localArrayList = new ArrayList();
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          rof localrof = (rof)localIterator.next();
          localrof.jdField_b_of_type_Int = 0;
          localArrayList.add(localrof.jdField_a_of_type_JavaLangString);
        }
      }
      this.jdField_a_of_type_Int = 0;
    } while (localArrayList.size() <= 0);
    ThreadManager.executeOnSubThread(new ServiceAccountFolderManager.5(this, localArrayList, paramQQAppInterface));
  }
  
  public void f(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null)
    {
      this.jdField_a_of_type_Long = paramQQAppInterface.getLong("service_account_folder_display_time", 0L);
      this.jdField_b_of_type_JavaLangString = paramQQAppInterface.getString("service_account_folder_time", "");
      this.jdField_b_of_type_Long = paramQQAppInterface.getLong("service_account_folder_operation_time", 0L);
      this.jdField_a_of_type_JavaLangCharSequence = paramQQAppInterface.getString("service_account_folder_brief", "");
      this.e = paramQQAppInterface.getLong("service_account_folder_maxunreadtime", 0L);
      this.jdField_a_of_type_Int = paramQQAppInterface.getInt("service_account_folder_unreadnum", 0);
      this.jdField_d_of_type_JavaLangString = paramQQAppInterface.getString("service_account_folder_extend", "");
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getFolderLocalData->mFolderDisplayTime:" + this.jdField_a_of_type_Long + ", mFolderShowTime:" + this.jdField_b_of_type_JavaLangString + ", mFolderOperationTime:" + this.jdField_b_of_type_Long + ", mFolderMsgBrief:" + this.jdField_a_of_type_JavaLangCharSequence + ", mFolderReportKeyBytesOacMsgxtend:" + this.jdField_d_of_type_JavaLangString);
      }
    }
  }
  
  public void g(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnFileThread(new ServiceAccountFolderManager.8(this, paramQQAppInterface));
  }
  
  public void h(QQAppInterface paramQQAppInterface)
  {
    for (;;)
    {
      long l3;
      Object localObject1;
      long l4;
      Object localObject2;
      Object localObject3;
      boolean bool;
      Object localObject4;
      Object localObject5;
      long l2;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        ahcq.a(this.jdField_a_of_type_JavaUtilList);
        Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Ron);
        int i = 0;
        l3 = 0L;
        String str1 = "";
        int k = 0;
        long l1 = 0L;
        localObject1 = "";
        l4 = 0L;
        localObject2 = "";
        String str2 = "";
        localObject3 = "";
        int j = 0;
        bool = false;
        localObject4 = "";
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          localObject5 = (rof)localIterator.next();
          if (((rof)localObject5).jdField_a_of_type_Int == 2)
          {
            bool = true;
            l2 = l3;
            if (((rof)localObject5).jdField_b_of_type_Int > 0)
            {
              l2 = l3;
              if (((rof)localObject5).jdField_a_of_type_Long >= l3) {
                l2 = ((rof)localObject5).jdField_a_of_type_Long;
              }
            }
            l3 = l4;
            if (((rof)localObject5).jdField_b_of_type_Long > l4) {
              l3 = ((rof)localObject5).jdField_b_of_type_Long;
            }
            if ((((rof)localObject5).jdField_b_of_type_Int <= 0) || (k != 0) || (TextUtils.isEmpty(((rof)localObject5).jdField_d_of_type_JavaLangString))) {
              break label822;
            }
            str1 = ((rof)localObject5).jdField_d_of_type_JavaLangString;
            k = 1;
            if ((j != 0) || (TextUtils.isEmpty(((rof)localObject5).jdField_a_of_type_JavaLangCharSequence))) {
              break label795;
            }
            l1 = ((rof)localObject5).jdField_a_of_type_Long;
            localObject4 = ((rof)localObject5).jdField_b_of_type_JavaLangString;
            localObject3 = ((rof)localObject5).jdField_c_of_type_JavaLangString;
            str2 = ((rof)localObject5).jdField_a_of_type_JavaLangString;
            localObject2 = ((rof)localObject5).jdField_a_of_type_JavaLangCharSequence;
            localObject1 = ((rof)localObject5).jdField_e_of_type_JavaLangString;
            j = 1;
            break label828;
          }
          if (((rof)localObject5).jdField_a_of_type_Int != 1) {
            break label825;
          }
          i += ((rof)localObject5).jdField_b_of_type_Int;
          continue;
        }
        this.jdField_a_of_type_Int = i;
        this.jdField_c_of_type_Boolean = bool;
        this.e = l3;
        this.jdField_c_of_type_JavaLangString = str1;
        this.jdField_a_of_type_Long = l1;
        this.jdField_b_of_type_JavaLangString = ((String)localObject1);
        this.jdField_b_of_type_Long = l4;
        this.jdField_d_of_type_JavaLangString = ((String)localObject4);
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label679;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.jdField_a_of_type_JavaLangCharSequence = new axkd((CharSequence)localObject3, 3, 16).a((String)localObject2 + "：", true, new int[0]);
          if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
            break label787;
          }
          if (((rof)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_e_of_type_Int != 4) {
            break label863;
          }
          bool = true;
          this.jdField_b_of_type_Boolean = bool;
          if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderManager", 2, "generateFolderDescription->mFolderDisplayTime:" + this.jdField_a_of_type_Long + ", mFolderShowTime:" + this.jdField_b_of_type_JavaLangString + ", mFolderExtraInfo:" + this.jdField_c_of_type_JavaLangString + ", mFolderMsgBrief:" + this.jdField_a_of_type_JavaLangCharSequence + ", mFolderUnreadNum:" + this.jdField_a_of_type_Int + ", maxUnreadDisplayTime:" + this.e + ", mFolderLastReadTime:" + this.jdField_c_of_type_Long + ", mFolderLastEnterTime:" + this.jdField_d_of_type_Long + ", mFolderHasLittleRedDot:" + this.jdField_c_of_type_Boolean + ", lastDraft:" + this.jdField_b_of_type_Boolean);
          }
          g(paramQQAppInterface);
          return;
        }
        if (!TextUtils.isEmpty(str2)) {
          this.jdField_a_of_type_JavaLangCharSequence = new axkd((CharSequence)localObject3, 3, 16).a(str2 + "：", true, new int[0]);
        }
      }
      this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject3);
      label787:
      label795:
      if (this.jdField_a_of_type_JavaLangCharSequence == null)
      {
        this.jdField_a_of_type_JavaLangCharSequence = "";
        continue;
        label679:
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          this.jdField_a_of_type_Long = ((rof)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_Long;
          this.jdField_b_of_type_JavaLangString = ((rof)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_JavaLangCharSequence = ((rof)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangCharSequence;
          this.jdField_d_of_type_JavaLangString = ((rof)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_e_of_type_JavaLangString;
          if (this.jdField_a_of_type_JavaLangCharSequence == null)
          {
            this.jdField_a_of_type_JavaLangCharSequence = "";
            continue;
            this.jdField_b_of_type_Boolean = false;
            continue;
            localObject5 = localObject2;
            Object localObject6 = localObject1;
            localObject1 = localObject4;
            localObject2 = localObject3;
            localObject3 = localObject5;
            localObject4 = localObject6;
            break label828;
            label822:
            continue;
            label825:
            continue;
            label828:
            localObject5 = localObject4;
            localObject6 = localObject3;
            localObject4 = localObject1;
            localObject3 = localObject2;
            localObject2 = localObject6;
            localObject1 = localObject5;
            l4 = l3;
            l3 = l2;
            continue;
            label863:
            bool = false;
          }
        }
      }
    }
  }
  
  public void i(QQAppInterface paramQQAppInterface)
  {
    akeu localakeu = paramQQAppInterface.a().a();
    RecentUser localRecentUser = localakeu.b(ajed.aA, 7230);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
      {
        if (localRecentUser != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountFolderInMsgTab->删除folder节点");
          }
          localakeu.b(localRecentUser);
        }
        return;
      }
      ??? = localRecentUser;
      if (localRecentUser == null)
      {
        localRecentUser = new RecentUser(ajed.aA, 7230);
        localRecentUser.displayName = a(paramQQAppInterface);
        ??? = localRecentUser;
        if (QLog.isColorLevel())
        {
          QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountFolderInMsgTab->新增folder节点");
          ??? = localRecentUser;
        }
      }
      long l1 = a(paramQQAppInterface);
      long l2 = b(paramQQAppInterface);
      ((RecentUser)???).lastmsgtime = Math.max(l1, l2);
      localakeu.a((RecentUser)???);
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountFolderInMsgTab->更新folder节点:tempFolderDisplayTime:" + l1 + ", tempFolderOperationTime:" + l2 + ", ru.lastmsgtime:" + ((RecentUser)???).lastmsgtime);
      }
      paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.sendEmptyMessage(1009);
        return;
      }
    }
  }
  
  public void j(QQAppInterface paramQQAppInterface)
  {
    i(paramQQAppInterface);
    MqqHandler localMqqHandler = paramQQAppInterface.getHandler(ServiceAccountFolderActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(100);
    }
    paramQQAppInterface = paramQQAppInterface.getHandler(FolderFollowTabFragment.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(100);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "refreshFolderAndActivityUI");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rol
 * JD-Core Version:    0.7.0.1
 */