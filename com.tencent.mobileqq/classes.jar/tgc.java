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

public class tgc
  implements Manager
{
  public byte a;
  public int a;
  ajvb jdField_a_of_type_Ajvb = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final ssy jdField_a_of_type_Ssy = new tge(this);
  private tgg jdField_a_of_type_Tgg;
  public boolean a;
  public boolean b;
  public boolean c = true;
  public boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public tgc(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Byte = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_Boolean = ((Boolean)((tcv)tdc.a(10)).b("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    this.c = a();
    c();
    DeviceProfileManager.a(this.jdField_a_of_type_Ajvb);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Ssy);
    this.d = ((ssw)paramQQAppInterface.getManager(181)).f();
    b(false);
    paramQQAppInterface = tcv.e();
    if (!TextUtils.isEmpty(paramQQAppInterface))
    {
      this.jdField_a_of_type_Tgg = a(paramQQAppInterface);
      if (this.jdField_a_of_type_Tgg != null) {
        this.jdField_a_of_type_Tgg.jdField_b_of_type_Boolean = tcv.j();
      }
    }
  }
  
  private tgg a(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString))
    {
      veg.c("Q.qqstory.config.takevideo", "parseTakeVideoConfig is null");
      return null;
    }
    try
    {
      tgg localtgg = new tgg();
      JSONObject localJSONObject = new JSONObject(paramString);
      localtgg.jdField_a_of_type_Long = localJSONObject.optLong("startTime", -1L);
      localtgg.jdField_b_of_type_Long = localJSONObject.optLong("endTime", -1L);
      localtgg.jdField_a_of_type_JavaLangString = localJSONObject.optString("imageUrl", "");
      localtgg.jdField_b_of_type_JavaLangString = localJSONObject.optString("desc", "");
      localtgg.c = localJSONObject.optString("jumpUrl", "");
      localtgg.d = localJSONObject.optString("contentId", "");
      if (localJSONObject.optInt("oneTimeUse", 0) == 1) {}
      for (;;)
      {
        localtgg.jdField_a_of_type_Boolean = bool;
        return localtgg;
        bool = false;
      }
      return null;
    }
    catch (JSONException localJSONException)
    {
      veg.c("Q.qqstory.config.takevideo", "parseTakeVideoConfig config error config=" + paramString, localJSONException);
    }
  }
  
  private void b()
  {
    if ((!this.jdField_b_of_type_Boolean) || (!this.c) || (this.jdField_a_of_type_Byte != 0) || (this.h) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    veg.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request!");
    this.h = true;
    Object localObject = SosoInterface.b();
    if ((localObject != null) && (((SosoInterface.SosoLbsInfo)localObject).a != null)) {}
    long l1;
    long l2;
    for (localObject = new tgi(((SosoInterface.SosoLbsInfo)localObject).a.f);; localObject = new tgi(null))
    {
      ssw localssw = (ssw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
      tgd localtgd = new tgd(this, (ssv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98), localssw);
      l1 = localssw.a();
      l2 = NetConnInfoCenter.getServerTime();
      if (l2 <= l1) {
        break;
      }
      syr.a().a((syv)localObject, localtgd);
      veg.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request sent");
      return;
    }
    veg.a("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request not send, check next time! %d, %d", Long.valueOf(l2), Long.valueOf(l1));
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
    ((mxq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43)).notifyUI(105, true, null);
    ((ssv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98)).notifyUI(1020, true, Boolean.valueOf(this.jdField_a_of_type_Boolean));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Ajvb == null) {
      this.jdField_a_of_type_Ajvb = new tgf(this);
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
    ssv localssv;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localssv = (ssv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98);
      if ((!this.jdField_b_of_type_Boolean) || (!this.c)) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      localssv.notifyUI(1022, true, Boolean.valueOf(bool));
      return;
    }
  }
  
  public tgg a()
  {
    return this.jdField_a_of_type_Tgg;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Tgg = null;
    tcv.f(false);
    tcv.g("");
    veg.c("Q.qqstory.config.takevideo", "configManager.clearMsgTabTakeVideoConfig");
    tgh localtgh = new tgh();
    ste.a().dispatch(localtgh);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    ssw localssw = (ssw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
    this.d = paramBoolean;
    localssw.i(paramBoolean);
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
    return (DeviceProfileManager.a(str, arrayOfInteger, new ajvg()) < 0) || (arrayOfInteger[0].intValue() == 1);
  }
  
  public boolean a(String paramString)
  {
    tgg localtgg = a(paramString);
    if (localtgg != null)
    {
      if (TextUtils.isEmpty(localtgg.d)) {
        veg.e("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig contentId is null", new Object[] { paramString });
      }
    }
    else {
      return false;
    }
    if ((this.jdField_a_of_type_Tgg != null) && (TextUtils.equals(this.jdField_a_of_type_Tgg.d, localtgg.d)))
    {
      veg.d("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig same config ignore, config=%s", new Object[] { paramString });
      return false;
    }
    veg.b("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig old config=%s, new config=%s", this.jdField_a_of_type_Tgg, paramString);
    this.jdField_a_of_type_Tgg = localtgg;
    tcv.f(false);
    tcv.g(paramString);
    paramString = new tgh();
    ste.a().dispatch(paramString);
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ssy);
    }
    DeviceProfileManager.b(this.jdField_a_of_type_Ajvb);
    this.jdField_a_of_type_Ajvb = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tgc
 * JD-Core Version:    0.7.0.1
 */