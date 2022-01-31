import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;

public class ssw
  implements Manager, sxo
{
  public static final String a;
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e;
  public static final String f;
  protected int a;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  public Drawable a;
  public aukn a;
  public QQStoryContext a;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public SoftReference<View> a;
  public List<QQStoryUserInfo> a;
  public ConcurrentHashMap<String, SoftReference<Bitmap>> a;
  public tbn a;
  public boolean a;
  public List<QQStoryUserInfo> b;
  public ConcurrentHashMap<String, QQStoryUserInfo> b;
  public boolean b;
  protected boolean c;
  protected boolean d;
  protected boolean e;
  protected boolean f;
  protected boolean g = true;
  protected boolean h;
  protected boolean i;
  public boolean j;
  public boolean k = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = sxp.a("StorySvc.video_config_get");
    jdField_b_of_type_JavaLangString = sxp.a("StorySvc.video_config_set");
    jdField_c_of_type_JavaLangString = sxp.a("StorySvc.video_get_user_mask_list");
    jdField_d_of_type_JavaLangString = sxp.a("StorySvc.video_set_user_mask");
    jdField_e_of_type_JavaLangString = sxp.a("StorySvc.video_get_user_mask_states");
    jdField_f_of_type_JavaLangString = sxp.a("StorySvc.video_show_video_list");
  }
  
  public ssw(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(null);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 10;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramAppInterface.getApp().getSharedPreferences("QQStory_Config_SP_" + paramAppInterface.getAccount(), 4);
    this.jdField_a_of_type_Aukn = paramAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext = new QQStoryContext();
    this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext.a();
    a();
  }
  
  public static String a()
  {
    return ajyc.a(2131710932);
  }
  
  public static void c(String paramString) {}
  
  public static boolean i()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_key_auto_play_type", 1001);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("sp_key_msg_tab_active_next_check_time", 0L);
  }
  
  public QQStoryUserInfo a(String paramString)
  {
    Object localObject;
    if (paramString == null) {
      localObject = null;
    }
    QQStoryUserInfo localQQStoryUserInfo;
    do
    {
      do
      {
        return localObject;
        localQQStoryUserInfo = (QQStoryUserInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject = localQQStoryUserInfo;
      } while (localQQStoryUserInfo != null);
      localQQStoryUserInfo = (QQStoryUserInfo)this.jdField_a_of_type_Aukn.a(QQStoryUserInfo.class, paramString);
      localObject = localQQStoryUserInfo;
    } while (localQQStoryUserInfo == null);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localQQStoryUserInfo);
    return localQQStoryUserInfo;
  }
  
  public List<QQStoryUserInfo> a(boolean paramBoolean)
  {
    List localList = null;
    if (paramBoolean) {
      if (this.jdField_b_of_type_JavaUtilList.size() != 0) {
        localList = this.jdField_b_of_type_JavaUtilList;
      }
    }
    while (localList != null)
    {
      Bosses.get().postJob(new ssx(this, "QQStoryManager", paramBoolean));
      return localList;
      if (this.jdField_a_of_type_JavaUtilList.size() != 0) {
        localList = this.jdField_a_of_type_JavaUtilList;
      }
    }
    return b(paramBoolean);
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("sp_key_my_notification", true);
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("sp_key_special_notification", true);
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("sp_key_show_allow_stranger_visit_mystory", false);
    this.jdField_f_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("sp_key_allow_stranger_visit_mystory", false);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_key_allow_stranger_day_num", 10);
    this.g = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("sp_key_show_auto_post2discovery", true);
    this.h = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("sp_key_auto_post2discovery", false);
    this.i = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("sp_key_show_video_info", false);
    b(bbjn.h(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
    this.jdField_a_of_type_Tbn = new tbn(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_key_net_type", paramInt).commit();
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("sp_key_msg_tab_active_next_check_time", paramLong).commit();
  }
  
  public void a(String paramString)
  {
    boolean bool2 = true;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.getInt("isHideQZone") != 1) {
          break label85;
        }
        bool1 = true;
        this.jdField_a_of_type_Boolean = bool1;
        if (paramString.getInt("isHideStory") != 1) {
          break label90;
        }
        bool1 = bool2;
        this.jdField_b_of_type_Boolean = bool1;
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("readQuickShotShareToStoryConfig", 2, paramString.getMessage());
      return;
      label85:
      boolean bool1 = false;
      continue;
      label90:
      bool1 = false;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_key_my_notification", paramBoolean).commit();
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public List<QQStoryUserInfo> b(boolean paramBoolean)
  {
    Object localObject;
    List localList;
    if (paramBoolean)
    {
      localObject = " isAllowed=? ";
      localList = this.jdField_a_of_type_Aukn.a(QQStoryUserInfo.class, true, (String)localObject, new String[] { "1" }, null, null, null, null);
      if (!paramBoolean) {
        break label122;
      }
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      localObject = this.jdField_b_of_type_JavaUtilList;
    }
    for (;;)
    {
      label54:
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            QQStoryUserInfo localQQStoryUserInfo = (QQStoryUserInfo)localIterator.next();
            ((List)localObject).add(localQQStoryUserInfo);
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localQQStoryUserInfo.uin, localQQStoryUserInfo);
            continue;
            localObject = " isInterested=? ";
            break;
            label122:
            this.jdField_a_of_type_JavaUtilList = new ArrayList();
            localObject = this.jdField_a_of_type_JavaUtilList;
            break label54;
          }
        }
        return localList;
      }
    }
    return new ArrayList();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "_pgc_media_has_subscribe", 0).edit().putBoolean("has_subscribe", true).commit();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_key_auto_play_type", paramInt).commit();
  }
  
  public void b(String paramString)
  {
    boolean bool2 = true;
    this.j = false;
    this.k = true;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.getInt("story_PGC_steaming") != 1) {
          break label85;
        }
        bool1 = true;
        this.j = bool1;
        if (paramString.getInt("story_friend_steaming") != 1) {
          break label90;
        }
        bool1 = bool2;
        this.k = bool1;
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("readStoryPlayerProxyConfig", 2, paramString.getMessage());
      return;
      label85:
      boolean bool1 = false;
      continue;
      label90:
      bool1 = false;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_key_special_notification", paramBoolean).commit();
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "_pgc_v_has_subscribe", 0).edit().putBoolean("has_subscribe", true).commit();
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_key_allow_stranger_day_num", paramInt).commit();
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_key_allow_stranger_visit_mystory", paramBoolean).commit();
  }
  
  public boolean c()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_key_show_allow_stranger_visit_mystory", paramBoolean).commit();
  }
  
  public boolean d()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public void e(boolean paramBoolean)
  {
    this.g = paramBoolean;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_key_show_auto_post2discovery", paramBoolean).commit();
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("sp_key_open_myvideo", false);
  }
  
  public void f(boolean paramBoolean)
  {
    this.h = paramBoolean;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_key_auto_post2discovery", paramBoolean).commit();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("sp_key_user_show_msg_tab_story_node", false);
  }
  
  public void g(boolean paramBoolean)
  {
    this.i = paramBoolean;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_key_show_video_info", paramBoolean).commit();
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "_pgc_v_has_subscribe", 0).getBoolean("has_subscribe", false);
  }
  
  public void h(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_key_open_myvideo", paramBoolean).commit();
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "_pgc_media_has_subscribe", 0).getBoolean("has_subscribe", false);
  }
  
  public void i(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_key_user_show_msg_tab_story_node", paramBoolean).commit();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Aukn.a();
    if (this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext.c();
    }
    tdc.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ssw
 * JD-Core Version:    0.7.0.1
 */