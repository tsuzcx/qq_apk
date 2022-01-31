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

public class tfz
  implements Manager
{
  public byte a;
  public int a;
  ajuz jdField_a_of_type_Ajuz = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final ssv jdField_a_of_type_Ssv = new tgb(this);
  private tgd jdField_a_of_type_Tgd;
  public boolean a;
  public boolean b;
  public boolean c = true;
  public boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public tfz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Byte = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_Boolean = ((Boolean)((tcs)tcz.a(10)).b("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    this.c = a();
    c();
    DeviceProfileManager.a(this.jdField_a_of_type_Ajuz);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Ssv);
    this.d = ((sst)paramQQAppInterface.getManager(181)).f();
    b(false);
    paramQQAppInterface = tcs.e();
    if (!TextUtils.isEmpty(paramQQAppInterface))
    {
      this.jdField_a_of_type_Tgd = a(paramQQAppInterface);
      if (this.jdField_a_of_type_Tgd != null) {
        this.jdField_a_of_type_Tgd.jdField_b_of_type_Boolean = tcs.j();
      }
    }
  }
  
  private tgd a(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString))
    {
      ved.c("Q.qqstory.config.takevideo", "parseTakeVideoConfig is null");
      return null;
    }
    try
    {
      tgd localtgd = new tgd();
      JSONObject localJSONObject = new JSONObject(paramString);
      localtgd.jdField_a_of_type_Long = localJSONObject.optLong("startTime", -1L);
      localtgd.jdField_b_of_type_Long = localJSONObject.optLong("endTime", -1L);
      localtgd.jdField_a_of_type_JavaLangString = localJSONObject.optString("imageUrl", "");
      localtgd.jdField_b_of_type_JavaLangString = localJSONObject.optString("desc", "");
      localtgd.c = localJSONObject.optString("jumpUrl", "");
      localtgd.d = localJSONObject.optString("contentId", "");
      if (localJSONObject.optInt("oneTimeUse", 0) == 1) {}
      for (;;)
      {
        localtgd.jdField_a_of_type_Boolean = bool;
        return localtgd;
        bool = false;
      }
      return null;
    }
    catch (JSONException localJSONException)
    {
      ved.c("Q.qqstory.config.takevideo", "parseTakeVideoConfig config error config=" + paramString, localJSONException);
    }
  }
  
  private void b()
  {
    if ((!this.jdField_b_of_type_Boolean) || (!this.c) || (this.jdField_a_of_type_Byte != 0) || (this.h) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    ved.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request!");
    this.h = true;
    Object localObject = SosoInterface.b();
    if ((localObject != null) && (((SosoInterface.SosoLbsInfo)localObject).a != null)) {}
    long l1;
    long l2;
    for (localObject = new tgf(((SosoInterface.SosoLbsInfo)localObject).a.f);; localObject = new tgf(null))
    {
      sst localsst = (sst)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
      tga localtga = new tga(this, (sss)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98), localsst);
      l1 = localsst.a();
      l2 = NetConnInfoCenter.getServerTime();
      if (l2 <= l1) {
        break;
      }
      syo.a().a((sys)localObject, localtga);
      ved.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request sent");
      return;
    }
    ved.a("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request not send, check next time! %d, %d", Long.valueOf(l2), Long.valueOf(l1));
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
    ((mxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43)).notifyUI(105, true, null);
    ((sss)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98)).notifyUI(1020, true, Boolean.valueOf(this.jdField_a_of_type_Boolean));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Ajuz == null) {
      this.jdField_a_of_type_Ajuz = new tgc(this);
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
    sss localsss;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localsss = (sss)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98);
      if ((!this.jdField_b_of_type_Boolean) || (!this.c)) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      localsss.notifyUI(1022, true, Boolean.valueOf(bool));
      return;
    }
  }
  
  public tgd a()
  {
    return this.jdField_a_of_type_Tgd;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Tgd = null;
    tcs.f(false);
    tcs.g("");
    ved.c("Q.qqstory.config.takevideo", "configManager.clearMsgTabTakeVideoConfig");
    tge localtge = new tge();
    stb.a().dispatch(localtge);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    sst localsst = (sst)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
    this.d = paramBoolean;
    localsst.i(paramBoolean);
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
    return (DeviceProfileManager.a(str, arrayOfInteger, new ajve()) < 0) || (arrayOfInteger[0].intValue() == 1);
  }
  
  public boolean a(String paramString)
  {
    tgd localtgd = a(paramString);
    if (localtgd != null)
    {
      if (TextUtils.isEmpty(localtgd.d)) {
        ved.e("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig contentId is null", new Object[] { paramString });
      }
    }
    else {
      return false;
    }
    if ((this.jdField_a_of_type_Tgd != null) && (TextUtils.equals(this.jdField_a_of_type_Tgd.d, localtgd.d)))
    {
      ved.d("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig same config ignore, config=%s", new Object[] { paramString });
      return false;
    }
    ved.b("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig old config=%s, new config=%s", this.jdField_a_of_type_Tgd, paramString);
    this.jdField_a_of_type_Tgd = localtgd;
    tcs.f(false);
    tcs.g(paramString);
    paramString = new tge();
    stb.a().dispatch(paramString);
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ssv);
    }
    DeviceProfileManager.b(this.jdField_a_of_type_Ajuz);
    this.jdField_a_of_type_Ajuz = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tfz
 * JD-Core Version:    0.7.0.1
 */