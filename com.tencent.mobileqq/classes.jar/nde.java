import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class nde
  extends Observable
  implements Manager
{
  public static final int a;
  public static boolean c;
  public char a;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  protected baic a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String a;
  HashMap<String, ndg> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  Map<String, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  public boolean a;
  public int b;
  private String b;
  public boolean b;
  public int c;
  
  static
  {
    if (uyp.a()) {}
    for (int i = 3050;; i = 6282)
    {
      jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public nde(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -100;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Char = '0';
    this.jdField_a_of_type_Baic = new ndf(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("now_msg_sp" + paramQQAppInterface.getCurrentAccountUin(), 0);
    a();
  }
  
  private void b() {}
  
  public String a()
  {
    if (this.jdField_b_of_type_JavaLangString == null) {
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("now_tab_sp", 0).getString("now_show_key" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "00100");
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public ndg a(String paramString, long paramLong)
  {
    ndg localndg2 = (ndg)this.jdField_a_of_type_JavaUtilHashMap.get(paramString + paramLong);
    ndg localndg1 = localndg2;
    if (localndg2 == null)
    {
      localndg1 = new ndg(this);
      localndg1.jdField_a_of_type_JavaLangString = paramString;
      localndg1.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_JavaUtilHashMap.put(localndg1.a(), localndg1);
    }
    return localndg1;
  }
  
  public void a()
  {
    boolean bool = false;
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("now_tab_sp", 0).getBoolean("now_is_first_run_key", true);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("now_tab_sp", 0).getInt("now_index_key", 3);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("now_tab_sp", 0).getString("now_name_key", "");
    if (this.jdField_b_of_type_Int != -1) {}
    String str;
    do
    {
      return;
      str = a();
      if (str != null) {
        this.jdField_a_of_type_Char = str.charAt(2);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.fourTab", 4, "initNowTabShowValue : " + str);
      }
      if ((str != null) && (str.length() <= "00100".length())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.qqstory.fourTab", 2, "isNowTabShow fullVal is null");
    return;
    Object localObject = str;
    if (str.length() < "00100".length()) {
      localObject = str + "00100".substring(str.length());
    }
    localObject = ((String)localObject).toCharArray();
    char c1 = localObject[2];
    int i;
    if (localObject[0] == '1') {
      if ((localObject[3] == '0') || (c1 == '0') || (c1 == '1'))
      {
        i = 0;
        label264:
        this.jdField_b_of_type_Int = i;
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqstory.fourTab", 2, "uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + ",isNowTabShow mIsNowTabShow=" + this.jdField_b_of_type_Int + " plan=" + c1);
        }
        if (this.jdField_b_of_type_Int != 0) {
          break label410;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      agby.jdField_a_of_type_Int |= 0x2;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n) {
        break;
      }
      b();
      return;
      i = 1;
      break label264;
      if ((localObject[1] == '0') || (c1 == '0') || (c1 == '1')) {}
      for (i = 0;; i = 1)
      {
        this.jdField_b_of_type_Int = i;
        break;
      }
      label410:
      bool = true;
    }
  }
  
  public void a(MessageForStructing paramMessageForStructing)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramMessageForStructing.frienduin))
    {
      long l = ((Long)this.jdField_a_of_type_JavaUtilMap.get(paramMessageForStructing.frienduin)).longValue();
      if (paramMessageForStructing.time > l)
      {
        this.jdField_a_of_type_JavaUtilMap.put(paramMessageForStructing.frienduin, Long.valueOf(paramMessageForStructing.time));
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("time" + paramMessageForStructing.frienduin, paramMessageForStructing.time).commit();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("uid" + paramMessageForStructing.frienduin, paramMessageForStructing.msgUid).commit();
      return;
      this.jdField_a_of_type_JavaUtilMap.put(paramMessageForStructing.frienduin, Long.valueOf(paramMessageForStructing.time));
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("time" + paramMessageForStructing.frienduin, paramMessageForStructing.time).commit();
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("room_id", paramString2);
    localBundle.putLong("time", paramLong);
    localBundle.putString("friendUin", paramString1);
    paramString1 = a(paramString1, paramLong);
    if ((paramString1.jdField_a_of_type_Int == 1) || (paramString1.jdField_a_of_type_Int == 2))
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(1001), Boolean.valueOf(true), paramString1, localBundle });
      return;
    }
    if (paramString1.jdField_a_of_type_JavaUtilList.size() != 0)
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(1001), Boolean.valueOf(true), paramString1, localBundle });
      return;
    }
    paramString1 = new Bundle();
    paramString1.putString("is_sub_room", "0");
    paramString1.putString("playtype", "4");
    paramString1.putString("platform", "3");
    paramString1.putString("room_id", paramString2);
    paramString2 = new HashMap();
    paramString2.put("BUNDLE", paramString1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    paramString2.put("CONTEXT", MobileQQ.getContext());
    new baib("http://now.qq.com/cgi-bin/now/web/room/get_live_room_url", "GET", this.jdField_a_of_type_Baic, 1001, localBundle, true).execute(new HashMap[] { paramString2 });
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NowLiveManager", 2, "getLiveState: roomId = " + paramString2 + " vid = " + paramString3 + " shMsgSeq = " + paramLong);
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("room_id", paramString2);
    localBundle.putLong("time", paramLong);
    localBundle.putString("vid", paramString3);
    localBundle.putString("friendUin", paramString1);
    localBundle.putBoolean("needReqUrl", paramBoolean);
    paramString1 = a(paramString1, paramLong);
    if ((paramString1.jdField_a_of_type_Int == 1) || (paramString1.jdField_a_of_type_Int == 2))
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(1003), Boolean.valueOf(true), paramString1, localBundle });
      return;
    }
    paramString1 = new Bundle();
    paramString1.putString("room_id", paramString2);
    paramString1.putString("vid", paramString3);
    paramString2 = new HashMap();
    paramString2.put("BUNDLE", paramString1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    paramString2.put("CONTEXT", MobileQQ.getContext());
    new baib("http://now.qq.com/cgi-bin/now/web/room/check_live_stat", "GET", this.jdField_a_of_type_Baic, 1003, localBundle, true).execute(new HashMap[] { paramString2 });
  }
  
  public void a(Integer[] paramArrayOfInteger)
  {
    a(paramArrayOfInteger, true);
  }
  
  public void a(Integer[] paramArrayOfInteger, boolean paramBoolean)
  {
    Object localObject2 = a();
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.fourTab", 2, "writeNowTabStateVal fullVal=" + (String)localObject2 + " vals:" + Arrays.toString(paramArrayOfInteger) + "     mNowTabShowState=" + this.jdField_b_of_type_Int);
    }
    if ((localObject2 == null) || (((String)localObject2).length() > "00100".length()) || (paramArrayOfInteger == null) || (paramArrayOfInteger.length != 5))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.fourTab", 2, "writeNowTabStateVal valid val," + (String)localObject2 + "," + paramArrayOfInteger);
      }
      return;
    }
    Object localObject1 = localObject2;
    if (((String)localObject2).length() < "00100".length()) {
      localObject1 = (String)localObject2 + "00100".substring(((String)localObject2).length());
    }
    localObject1 = new StringBuilder((String)localObject1);
    int i = 0;
    label198:
    if (i < paramArrayOfInteger.length)
    {
      localObject2 = paramArrayOfInteger[i];
      if (localObject2 == null) {}
      for (;;)
      {
        i += 1;
        break label198;
        if ((((Integer)localObject2).intValue() < 0) || (((Integer)localObject2).intValue() > 9))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("Q.qqstory.fourTab", 2, "writeNowTabStateVal wrong index,," + localObject2);
          return;
        }
        ((StringBuilder)localObject1).setCharAt(i, (char)(((Integer)localObject2).intValue() + 48));
      }
    }
    char c1 = ((StringBuilder)localObject1).charAt(2);
    if ('1' == ((StringBuilder)localObject1).charAt(0))
    {
      if ((((StringBuilder)localObject1).charAt(3) == '0') || (c1 == '0') || (c1 == '1'))
      {
        i = 0;
        label340:
        this.jdField_b_of_type_Int = i;
        if (this.jdField_b_of_type_Int != 0) {
          break label663;
        }
      }
      label663:
      for (bool = false;; bool = true)
      {
        this.jdField_a_of_type_Boolean = bool;
        agby.jdField_a_of_type_Int |= 0x2;
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqstory.fourTab", 2, "userChange mNowTabShowState=" + this.jdField_b_of_type_Int + " result:" + localObject1 + "  plan=" + c1);
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqstory.fourTab", 2, "uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + ",writeNowTabStateVal vals=" + Arrays.toString(paramArrayOfInteger) + ",mIsNowTabShow=" + this.jdField_b_of_type_Int + ",isNowTabShow=" + this.jdField_a_of_type_Boolean);
        }
        localObject1 = ((StringBuilder)localObject1).toString();
        this.jdField_b_of_type_JavaLangString = ((String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("now_tab_sp", 0).edit().putString("now_show_key" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject1).apply();
        if (this.jdField_a_of_type_Boolean) {}
        localObject1 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "qqsetting_calltab_show_key", "0111100");
        if ((!paramBoolean) || (paramArrayOfInteger[0] == null) || (1 != paramArrayOfInteger[0].intValue()) || (((String)localObject1).charAt(0) != '0')) {
          break;
        }
        paramArrayOfInteger = new Integer[7];
        paramArrayOfInteger[0] = Integer.valueOf(1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramArrayOfInteger, false);
        return;
        i = 1;
        break label340;
      }
    }
    if ((((StringBuilder)localObject1).charAt(1) == '0') || (c1 == '0') || (c1 == '1'))
    {
      i = 0;
      label695:
      this.jdField_b_of_type_Int = i;
      if (this.jdField_b_of_type_Int != 0) {
        break label797;
      }
    }
    label797:
    for (boolean bool = false;; bool = true)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Boolean) {
        agby.jdField_a_of_type_Int |= 0x2;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.qqstory.fourTab", 2, "userNoChange mNowTabShowState=" + this.jdField_b_of_type_Int + " result:" + localObject1 + "  plan=" + c1);
      break;
      i = 1;
      break label695;
    }
  }
  
  public boolean a()
  {
    if (sst.i())
    {
      int j = a().charAt(2);
      if ((jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {}
      for (int i = 1; (j != 48) && (i == 0); i = 0) {
        return true;
      }
      return false;
    }
    return false;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return paramLong >= ((Long)this.jdField_a_of_type_JavaUtilMap.get(paramString)).longValue();
    }
    long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("time" + paramString, 0L);
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(l));
    if (paramLong >= l) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    while (!a()) {
      return false;
    }
    Iterator localIterator = ((avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a().iterator();
    while (localIterator.hasNext())
    {
      BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)localIterator.next();
      if (localAppSetting.appid.get() == jdField_a_of_type_Int) {
        return localAppSetting.setting.get();
      }
    }
    return true;
  }
  
  public void onDestroy()
  {
    deleteObservers();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nde
 * JD-Core Version:    0.7.0.1
 */