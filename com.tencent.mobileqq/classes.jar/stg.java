import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;

public class stg
  implements Manager
{
  public byte a;
  public int a;
  ajgy jdField_a_of_type_Ajgy = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final sgc jdField_a_of_type_Sgc = new sti(this);
  private stk jdField_a_of_type_Stk;
  public boolean a;
  public boolean b;
  public boolean c = true;
  public boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public stg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Byte = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_Boolean = ((Boolean)((spz)sqg.a(10)).b("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    this.c = a();
    c();
    DeviceProfileManager.a(this.jdField_a_of_type_Ajgy);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Sgc);
    this.d = ((sga)paramQQAppInterface.getManager(181)).f();
    b(false);
    paramQQAppInterface = spz.e();
    if (!TextUtils.isEmpty(paramQQAppInterface))
    {
      this.jdField_a_of_type_Stk = a(paramQQAppInterface);
      if (this.jdField_a_of_type_Stk != null) {
        this.jdField_a_of_type_Stk.jdField_b_of_type_Boolean = spz.j();
      }
    }
  }
  
  private stk a(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString))
    {
      urk.c("Q.qqstory.config.takevideo", "parseTakeVideoConfig is null");
      return null;
    }
    try
    {
      stk localstk = new stk();
      JSONObject localJSONObject = new JSONObject(paramString);
      localstk.jdField_a_of_type_Long = localJSONObject.optLong("startTime", -1L);
      localstk.jdField_b_of_type_Long = localJSONObject.optLong("endTime", -1L);
      localstk.jdField_a_of_type_JavaLangString = localJSONObject.optString("imageUrl", "");
      localstk.jdField_b_of_type_JavaLangString = localJSONObject.optString("desc", "");
      localstk.c = localJSONObject.optString("jumpUrl", "");
      localstk.d = localJSONObject.optString("contentId", "");
      if (localJSONObject.optInt("oneTimeUse", 0) == 1) {}
      for (;;)
      {
        localstk.jdField_a_of_type_Boolean = bool;
        return localstk;
        bool = false;
      }
      return null;
    }
    catch (JSONException localJSONException)
    {
      urk.c("Q.qqstory.config.takevideo", "parseTakeVideoConfig config error config=" + paramString, localJSONException);
    }
  }
  
  private void b()
  {
    if ((!this.jdField_b_of_type_Boolean) || (!this.c) || (this.jdField_a_of_type_Byte != 0) || (this.h) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    urk.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request!");
    this.h = true;
    Object localObject = SosoInterface.b();
    if ((localObject != null) && (((SosoInterface.SosoLbsInfo)localObject).a != null)) {}
    long l1;
    long l2;
    for (localObject = new stm(((SosoInterface.SosoLbsInfo)localObject).a.f);; localObject = new stm(null))
    {
      sga localsga = (sga)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
      sth localsth = new sth(this, (sfz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98), localsga);
      l1 = localsga.a();
      l2 = NetConnInfoCenter.getServerTime();
      if (l2 <= l1) {
        break;
      }
      slv.a().a((slz)localObject, localsth);
      urk.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request sent");
      return;
    }
    urk.a("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request not send, check next time! %d, %d", Long.valueOf(l2), Long.valueOf(l1));
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "update cfg svr=" + this.jdField_b_of_type_Boolean + ", dpc=" + this.c + ", user=" + this.d);
    }
    boolean bool2 = this.jdField_a_of_type_Boolean;
    boolean bool1;
    if ((this.jdField_b_of_type_Boolean) && (this.c) && (this.d))
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_Int = 52;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        break label113;
      }
    }
    label113:
    while ((!paramBoolean) || (bool2 == this.jdField_a_of_type_Boolean))
    {
      return;
      bool1 = false;
      break;
    }
    ((mmr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43)).notifyUI(105, true, null);
    ((sfz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98)).notifyUI(1020, true, Boolean.valueOf(this.jdField_a_of_type_Boolean));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Ajgy == null) {
      this.jdField_a_of_type_Ajgy = new stj(this);
    }
  }
  
  private void d()
  {
    if ((this.e) && (this.g) && (this.f)) {
      b();
    }
  }
  
  private void e()
  {
    sfz localsfz;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localsfz = (sfz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98);
      if ((!this.jdField_b_of_type_Boolean) || (!this.c)) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      localsfz.notifyUI(1022, true, Boolean.valueOf(bool));
      return;
    }
  }
  
  public stk a()
  {
    return this.jdField_a_of_type_Stk;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Stk = null;
    spz.f(false);
    spz.g("");
    urk.c("Q.qqstory.config.takevideo", "configManager.clearMsgTabTakeVideoConfig");
    stl localstl = new stl();
    sgi.a().dispatch(localstl);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    sga localsga = (sga)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
    this.d = paramBoolean;
    localsga.i(paramBoolean);
    b(true);
  }
  
  public boolean a()
  {
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.StoryCfg.name(), "1");
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "getMsgTabDPC:" + str);
    }
    Integer[] arrayOfInteger;
    if (!TextUtils.isEmpty(str))
    {
      arrayOfInteger = new Integer[1];
      arrayOfInteger[0] = Integer.valueOf(0);
    }
    return (DeviceProfileManager.a(str, arrayOfInteger, new ajhd()) < 0) || (arrayOfInteger[0].intValue() == 1);
  }
  
  public boolean a(String paramString)
  {
    stk localstk = a(paramString);
    if (localstk != null)
    {
      if (TextUtils.isEmpty(localstk.d)) {
        urk.e("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig contentId is null", new Object[] { paramString });
      }
    }
    else {
      return false;
    }
    if ((this.jdField_a_of_type_Stk != null) && (TextUtils.equals(this.jdField_a_of_type_Stk.d, localstk.d)))
    {
      urk.d("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig same config ignore, config=%s", new Object[] { paramString });
      return false;
    }
    urk.b("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig old config=%s, new config=%s", this.jdField_a_of_type_Stk, paramString);
    this.jdField_a_of_type_Stk = localstk;
    spz.f(false);
    spz.g(paramString);
    paramString = new stl();
    sgi.a().dispatch(paramString);
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Sgc);
    }
    DeviceProfileManager.b(this.jdField_a_of_type_Ajgy);
    this.jdField_a_of_type_Ajgy = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     stg
 * JD-Core Version:    0.7.0.1
 */