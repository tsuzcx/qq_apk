package com.tencent.mobileqq.servlet;

import KQQ.PluginInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;

public class GameCenterManagerImp
  implements Manager
{
  public static ConcurrentHashMap a;
  protected static byte[] a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private HashMap b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public GameCenterManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("gamecenter_prefername", 0);
    c();
    a();
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.GameCenterManagerImp", 2, "loadGameCenterUnread.");
    }
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.b = new HashMap();
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    if (!TextUtils.isEmpty(str1))
    {
      Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("gc_pluginid" + str1, null);
      if (localObject != null)
      {
        localObject = ((String)localObject).split("&");
        if ((localObject != null) && (localObject.length > 0))
        {
          int i = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              return;
            }
            String str2 = localObject[i];
            try
            {
              long l = Long.parseLong(str2);
              if (l > 0L)
              {
                GameCenterManagerImp.UnreadData localUnreadData = new GameCenterManagerImp.UnreadData(this);
                localUnreadData.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("gc_unread" + str1 + "_" + str2, 0L);
                localUnreadData.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("gc_newmsg" + str1 + "_" + str2, false);
                localUnreadData.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("gc_redpoint" + str1 + "_" + str2, false);
                localUnreadData.c = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("gc_tab" + str1 + "_" + str2, false);
                localUnreadData.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("gc_text" + str1 + "_" + str2, "");
                localUnreadData.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("gc_icon" + str1 + "_" + str2, "");
                localUnreadData.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("gc_type" + str1 + "_" + str2, -1);
                this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l));
                this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), localUnreadData);
              }
            }
            catch (Exception localException)
            {
              label501:
              break label501;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilHashMap != null))
    {
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      String str1 = "";
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        long l = ((Long)localIterator.next()).longValue();
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(l)))
        {
          if (str1.length() > 0) {}
          for (str1 = str1 + "&" + l;; str1 = str1 + l)
          {
            GameCenterManagerImp.UnreadData localUnreadData = (GameCenterManagerImp.UnreadData)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l));
            localEditor.putLong("gc_unread" + str2 + "_" + l, localUnreadData.jdField_a_of_type_Long);
            localEditor.putBoolean("gc_newmsg" + str2 + "_" + l, localUnreadData.jdField_a_of_type_Boolean);
            localEditor.putBoolean("gc_redpoint" + str2 + "_" + l, localUnreadData.jdField_b_of_type_Boolean);
            localEditor.putBoolean("gc_tab" + str2 + "_" + l, localUnreadData.c);
            localEditor.putString("gc_text" + str2 + "_" + l, localUnreadData.jdField_a_of_type_JavaLangString);
            localEditor.putString("gc_icon" + str2 + "_" + l, localUnreadData.jdField_b_of_type_JavaLangString);
            localEditor.putInt("gc_type" + str2 + "_" + l, localUnreadData.jdField_a_of_type_Int);
            break;
          }
        }
      }
      localEditor.putString("gc_pluginid" + str2, str1);
      localEditor.commit();
    }
  }
  
  public int a(String paramString)
  {
    if (this.b.containsKey(paramString)) {
      return ((Integer)this.b.get(paramString)).intValue();
    }
    return -1;
  }
  
  public void a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Object localObject2 = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + (String)localObject1);
    if ((!((File)localObject2).exists()) || (TextUtils.isEmpty((CharSequence)localObject1))) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.GameCenterManagerImp", 2, "BusinessInfoCheckUpdateItem pb file does not exist,uin=" + (String)localObject1);
      }
    }
    for (;;)
    {
      return;
      Boolean localBoolean = (Boolean)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
      if ((localBoolean == null) || (!localBoolean.booleanValue()))
      {
        jdField_a_of_type_ArrayOfByte = null;
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        jdField_a_of_type_ArrayOfByte = FileUtils.a((File)localObject2);
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, Boolean.valueOf(true));
      }
      localObject2 = jdField_a_of_type_ArrayOfByte;
      if (localObject2 == null)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.lebatab.GameCenterManagerImp", 2, "Can not translate BusinessInfoCheckUpdateItem pb file to byte");
        return;
      }
      this.b.clear();
      try
      {
        localObject1 = new BusinessInfoCheckUpdate.TimeRspBody();
        ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).mergeFrom((byte[])localObject2);
        int i = 0;
        while (i < ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.size())
        {
          localObject2 = (BusinessInfoCheckUpdate.AppInfo)((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.get(i);
          if (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() != 0) {
            this.b.put(((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get(), Integer.valueOf(((BusinessInfoCheckUpdate.AppInfo)localObject2).type.get()));
          }
          i += 1;
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
  
  public void a(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong1)))
    {
      localObject = (GameCenterManagerImp.UnreadData)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
      ((GameCenterManagerImp.UnreadData)localObject).jdField_a_of_type_Boolean = paramBoolean;
      ((GameCenterManagerImp.UnreadData)localObject).jdField_a_of_type_Long = paramLong2;
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong1), localObject);
      d();
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), GameCenterServlet.class);
      ((NewIntent)localObject).setAction("gc_refresh_ui");
      if ((paramLong2 <= 0L) && (!paramBoolean)) {
        break label140;
      }
      if (paramLong2 <= 0L) {
        break label127;
      }
      ((NewIntent)localObject).putExtra("gc_notify_type", 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
      label127:
      ((NewIntent)localObject).putExtra("gc_notify_type", 1);
      continue;
      label140:
      ((NewIntent)localObject).putExtra("gc_notify_type", 3);
    }
  }
  
  public void a(String paramString)
  {
    if (this.b.containsKey(paramString)) {
      this.b.remove(paramString);
    }
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong))) {
      return ((GameCenterManagerImp.UnreadData)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public boolean a(List paramList)
  {
    boolean bool1;
    int i;
    int j;
    if ((paramList != null) && (paramList.size() > 0))
    {
      bool1 = false;
      i = -1;
      int m = 0;
      if (m < paramList.size())
      {
        PluginInfo localPluginInfo = (PluginInfo)paramList.get(m);
        boolean bool3 = bool1;
        int k = i;
        if (localPluginInfo != null) {
          if (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(localPluginInfo.Id)) != null) {}
        }
        GameCenterManagerImp.UnreadData localUnreadData;
        boolean bool2;
        label296:
        do
        {
          m += 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.GameCenterManagerImp", 2, "setNewUnread.i=" + m + ",plugin:" + localPluginInfo.toString());
          }
          localUnreadData = (GameCenterManagerImp.UnreadData)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(localPluginInfo.Id));
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.GameCenterManagerImp", 2, "setNewUnread.i=" + m + ",before unreaddata:" + localUnreadData.toString());
          }
          if (localPluginInfo.Count > 0L)
          {
            j = i;
            if (localUnreadData.jdField_a_of_type_Long != localPluginInfo.Count)
            {
              bool2 = true;
              bool1 = bool2;
              j = i;
              if (localPluginInfo.Tab)
              {
                j = 0;
                bool1 = bool2;
              }
            }
            localUnreadData.jdField_a_of_type_Long = localPluginInfo.Count;
            localUnreadData.jdField_a_of_type_JavaLangString = localPluginInfo.Text;
            localUnreadData.jdField_a_of_type_Boolean = false;
            localUnreadData.jdField_b_of_type_Boolean = false;
            if (TextUtils.isEmpty(localUnreadData.jdField_a_of_type_JavaLangString))
            {
              localUnreadData.jdField_a_of_type_Int = 1;
              localUnreadData.c = localPluginInfo.Tab;
              bool2 = bool1;
            }
          }
          do
          {
            bool3 = bool2;
            k = j;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.lebatab.GameCenterManagerImp", 2, "setNewUnread.i=" + m + ",unreaddata:" + localUnreadData.toString());
              k = j;
              bool3 = bool2;
            }
            bool1 = bool3;
            i = k;
            break;
            localUnreadData.jdField_a_of_type_Int = 4;
            break label296;
            if (localPluginInfo.Flag)
            {
              if (localUnreadData.jdField_a_of_type_Long > 0L) {
                break;
              }
              j = i;
              if (!localUnreadData.jdField_a_of_type_Boolean)
              {
                bool2 = true;
                bool1 = bool2;
                j = i;
                if (localPluginInfo.Tab) {
                  if (i != -1)
                  {
                    bool1 = bool2;
                    j = i;
                    if (i != 4) {}
                  }
                  else
                  {
                    j = 1;
                    bool1 = bool2;
                  }
                }
              }
              localUnreadData.jdField_a_of_type_Boolean = localPluginInfo.Flag;
              localUnreadData.jdField_b_of_type_Boolean = false;
              localUnreadData.jdField_a_of_type_Long = 0L;
              localUnreadData.jdField_a_of_type_JavaLangString = localPluginInfo.Text;
              if (TextUtils.isEmpty(localUnreadData.jdField_a_of_type_JavaLangString)) {}
              for (localUnreadData.jdField_a_of_type_Int = 3;; localUnreadData.jdField_a_of_type_Int = 6)
              {
                localUnreadData.c = localPluginInfo.Tab;
                bool2 = bool1;
                break;
              }
            }
            bool2 = bool1;
            j = i;
          } while (!localPluginInfo.RedPoint);
        } while ((localUnreadData.jdField_a_of_type_Long > 0L) || ((localPluginInfo.Id == 769L) && (localUnreadData.jdField_a_of_type_Boolean)));
        j = i;
        if (!localUnreadData.jdField_b_of_type_Boolean)
        {
          bool2 = true;
          bool1 = bool2;
          j = i;
          if (i == -1)
          {
            bool1 = bool2;
            j = i;
            if (localPluginInfo.Tab)
            {
              j = 4;
              bool1 = bool2;
            }
          }
        }
        localUnreadData.jdField_b_of_type_Boolean = localPluginInfo.RedPoint;
        localUnreadData.jdField_a_of_type_Boolean = false;
        localUnreadData.jdField_a_of_type_Long = 0L;
        localUnreadData.jdField_a_of_type_JavaLangString = localPluginInfo.Text;
        localUnreadData.jdField_b_of_type_JavaLangString = localPluginInfo.PicUrl;
        if (TextUtils.isEmpty(localUnreadData.jdField_a_of_type_JavaLangString)) {
          if (TextUtils.isEmpty(localUnreadData.jdField_b_of_type_JavaLangString)) {
            localUnreadData.jdField_a_of_type_Int = 2;
          }
        }
        for (;;)
        {
          localUnreadData.c = localPluginInfo.Tab;
          bool2 = bool1;
          break;
          localUnreadData.jdField_a_of_type_Int = 7;
          continue;
          localUnreadData.jdField_a_of_type_Int = 5;
        }
      }
      d();
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.GameCenterManagerImp", 2, "setNewUnread.changeType=" + i + ",ischange:" + bool1);
      }
      if (i != -1)
      {
        paramList = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), GameCenterServlet.class);
        paramList.setAction("gc_refresh_ui");
        paramList.putExtra("gc_notify_type", i);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramList);
        j = i;
      }
    }
    for (;;)
    {
      if (j != -1)
      {
        return true;
        j = i;
        if (bool1)
        {
          paramList = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), GameCenterServlet.class);
          paramList.setAction("gc_refresh_ui");
          paramList.putExtra("gc_notify_type", 3);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramList);
          j = i;
        }
      }
      else
      {
        return false;
        j = -1;
      }
    }
  }
  
  public void b()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0);
    int i = localSharedPreferences.getInt("businessinfo_check_update_interval_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 600);
    int j = localSharedPreferences.getInt("businessinfo_last_check_update_timestamp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    int k = (int)(System.currentTimeMillis() / 1000L);
    if ((k - j > i) || (k < j)) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(true, 2);
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.GameCenterManagerImp
 * JD-Core Version:    0.7.0.1
 */