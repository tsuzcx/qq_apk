import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.av.ReqGroupVideo.ReqCreateShareUrl;
import com.tencent.av.share.AVSchema;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class lyi
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  protected BaseActivity a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected TroopInfoData a;
  String jdField_a_of_type_JavaLangString;
  lym jdField_a_of_type_Lym = null;
  lyn jdField_a_of_type_Lyn;
  boolean jdField_a_of_type_Boolean = false;
  protected String b;
  protected String c;
  
  public lyi()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
  }
  
  public static bbeg a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    bbeg localbbeg = new bbeg(paramQQAppInterface, paramContext);
    if ((paramContext instanceof JumpActivity))
    {
      paramQQAppInterface = ((JumpActivity)paramContext).getIntent();
      if (paramQQAppInterface != null) {
        localbbeg.a("from_url_InternalCheck", paramQQAppInterface.getStringExtra("url"));
      }
    }
    paramContext = bbex.a(paramString, "?");
    paramQQAppInterface = paramContext[0];
    paramContext = paramContext[1];
    paramQQAppInterface = paramQQAppInterface.split("//");
    if (paramQQAppInterface.length != 2) {
      return null;
    }
    localbbeg.jdField_a_of_type_JavaLangString = paramString;
    localbbeg.jdField_b_of_type_JavaLangString = "mqqavshare://";
    localbbeg.c = paramQQAppInterface[1];
    paramQQAppInterface = "parser, jumpStr[" + paramString + "], server_name[" + localbbeg.jdField_b_of_type_JavaLangString + "], action_name[" + localbbeg.c + "]";
    paramString = paramContext.split("&");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString = paramString[i].split("=");
      paramContext = paramQQAppInterface;
      if (arrayOfString.length == 2)
      {
        paramContext = bbex.a(arrayOfString[1], false);
        localbbeg.a(arrayOfString[0], paramContext);
        paramContext = paramQQAppInterface + ", [" + arrayOfString[0] + "]=[" + paramContext + "]";
      }
      i += 1;
      paramQQAppInterface = paramContext;
    }
    QLog.w("ShareChat", 1, paramQQAppInterface);
    return localbbeg;
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return this.jdField_b_of_type_JavaLangString;
    }
    return this.c;
  }
  
  static String a(Context paramContext)
  {
    return paramContext.getString(2131693246);
  }
  
  static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    paramString = bbcz.h(paramQQAppInterface, paramString, paramQQAppInterface.getCurrentAccountUin());
    return paramString + paramQQAppInterface.getApp().getString(2131693249);
  }
  
  static String a(String paramString)
  {
    return bahv.a("", paramString, 0) + "100";
  }
  
  static String a(lys paramlys)
  {
    String str = null;
    if (paramlys != null) {
      str = paramlys.a();
    }
    return str;
  }
  
  static void a(long paramLong, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    QLog.w("ShareChat", 1, "finishJumpActivity, seq[" + paramLong + "]");
    Intent localIntent = new Intent();
    localIntent.setAction("BroadcastReceiverFinishActivity");
    paramContext.sendBroadcast(localIntent);
  }
  
  static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    long l = AudioHelper.b();
    StringBuilder localStringBuilder = new StringBuilder().append("forward, url[").append(paramString2).append("], fromchannel[").append(paramInt).append("], seq[").append(l).append("], app[");
    if (paramQQAppInterface != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w("ShareChat", 1, bool + "], context[" + paramContext + "]");
      if ((paramQQAppInterface != null) && (paramContext != null) && (!TextUtils.isEmpty(paramString2))) {
        break;
      }
      return;
    }
    new lyn(l, 0).a(paramContext, paramString1, new lyl(paramString2, paramQQAppInterface, paramString1, paramInt, l, new WeakReference(paramContext)));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, View paramView, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("param_entrance", 0);
    String str = paramIntent.getStringExtra("group_uin");
    if (i == 35)
    {
      mqy.g();
      a(paramQQAppInterface, paramBaseActivity, paramView, str);
      return;
    }
    long l = paramIntent.getLongExtra("room_id", 0L);
    i = paramIntent.getIntExtra("room_create_time", 0);
    mqy.b();
    new lyi().a(paramQQAppInterface, paramBaseActivity, str, l, i);
  }
  
  static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, View paramView, String paramString)
  {
    bail.a(paramBaseActivity, paramString);
  }
  
  public static boolean a(bbeg parambbeg)
  {
    if ("avshare/group".equals(parambbeg.c)) {
      return b(parambbeg);
    }
    if ("avshare/forward".equals(parambbeg.c)) {
      return d(parambbeg);
    }
    return false;
  }
  
  static String b(lys paramlys)
  {
    if (paramlys != null) {
      return paramlys.b();
    }
    return null;
  }
  
  public static boolean b(bbeg parambbeg)
  {
    if (!"avshare/group".equals(parambbeg.c)) {
      return false;
    }
    String str = (String)parambbeg.jdField_a_of_type_JavaUtilHashMap.get("guid");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    AudioHelper.b("handle_startGAudio");
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.addFlags(268435456);
    localIntent.putExtra("guid", str);
    abtq.a(parambbeg.jdField_a_of_type_AndroidContentContext, localIntent, PublicTransFragmentActivity.class, AVSchema.class);
    mqy.c();
    return true;
  }
  
  static boolean c(bbeg parambbeg)
  {
    if (!parambbeg.a())
    {
      parambbeg = (String)parambbeg.jdField_a_of_type_JavaUtilHashMap.get("from_url_InternalCheck");
      QLog.w("ShareChat", 1, "handle_forward, KEY_CurrentUrl[" + parambbeg + "]");
      if (!TextUtils.isEmpty(parambbeg))
      {
        parambbeg = parambbeg.replace('\\', '/');
        if ((parambbeg.startsWith("https://web.qun.qq.com/")) || (parambbeg.startsWith("http://web.qun.qq.com/"))) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public static boolean d(bbeg parambbeg)
  {
    if (!"avshare/forward".equals(parambbeg.c)) {
      return false;
    }
    if (!c(parambbeg)) {
      return false;
    }
    String str1 = (String)parambbeg.jdField_a_of_type_JavaUtilHashMap.get("url");
    Object localObject1 = (String)parambbeg.jdField_a_of_type_JavaUtilHashMap.get("exp");
    String str2 = (String)parambbeg.jdField_a_of_type_JavaUtilHashMap.get("guin");
    Object localObject2 = (String)parambbeg.jdField_a_of_type_JavaUtilHashMap.get("fromchannel");
    if (TextUtils.isEmpty(str1)) {
      return false;
    }
    int i = (int)bbkk.a("ShareChat", (String)localObject2);
    if (i == 0) {
      return false;
    }
    mqy.a(i, str2);
    AudioHelper.b("handle_forward");
    long l1 = bbkk.a("ShareChat", (String)localObject1);
    long l2 = AudioHelper.a();
    if (l1 < l2)
    {
      parambbeg = bcql.a(parambbeg.jdField_a_of_type_AndroidContentContext, 2131693250, 1);
      parambbeg.a();
      parambbeg.a();
      QLog.w("ShareChat", 1, "handle_forward, expTime[" + l1 + "], curTime[" + l2 + "]");
      return true;
    }
    if (((TroopManager)parambbeg.a().getManager(52)).b(str2) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ShareChat", 1, "handle_forward, troopUin[" + str2 + "]");
      }
      parambbeg = bcql.a(parambbeg.jdField_a_of_type_AndroidContentContext, 2131693250, 1);
      parambbeg.a();
      parambbeg.a();
      return true;
    }
    localObject1 = parambbeg.a();
    localObject2 = (baky)((QQAppInterface)localObject1).getManager(48);
    boolean bool1 = ((baky)localObject2).a(str2);
    boolean bool2 = ((baky)localObject2).b(str2);
    if ((!bool1) && (!bool2))
    {
      if (AudioHelper.e()) {
        QLog.w("ShareChat", 1, "handle_forward, troopUin[" + str2 + "], isAdmin[" + bool1 + "], isOwner[" + bool2 + "]");
      }
      parambbeg = bcql.a(parambbeg.jdField_a_of_type_AndroidContentContext, 2131693251, 1);
      parambbeg.a();
      parambbeg.a();
      return true;
    }
    parambbeg.jdField_b_of_type_Boolean = false;
    if ((parambbeg.jdField_a_of_type_AndroidContentContext instanceof JumpActivity)) {
      ((JumpActivity)parambbeg.jdField_a_of_type_AndroidContentContext).a();
    }
    a((QQAppInterface)localObject1, parambbeg.jdField_a_of_type_AndroidContentContext, str2, str1, i);
    return true;
  }
  
  void a(long paramLong1, long paramLong2, int paramInt)
  {
    QLog.w("ShareChat", 1, "reRequest, mIsRequesting[" + this.jdField_a_of_type_Boolean + "], seq[" + paramLong1 + "]");
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a();
    b(paramLong1, paramLong2, paramInt);
  }
  
  void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString, long paramLong, int paramInt)
  {
    int i = 1;
    int j = 0;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    if (!a()) {
      return;
    }
    a(paramQQAppInterface, paramString);
    paramQQAppInterface = bbgb.a().a(paramString);
    long l = AudioHelper.b();
    if (paramQQAppInterface == null)
    {
      b(l, paramLong, paramInt);
      paramInt = j;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        paramInt = j;
        if (!TroopInfo.isQidianPrivateTroop((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
        {
          if ((!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) || (!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {
            break label315;
          }
          paramInt = 1;
          label152:
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 1) {
            break label321;
          }
          label163:
          if ((paramInt | i) == 0) {
            break label327;
          }
        }
      }
    }
    label315:
    label321:
    label327:
    for (paramInt = j;; paramInt = -1)
    {
      this.jdField_a_of_type_Lyn = new lyn(l, paramInt);
      this.jdField_a_of_type_Lyn.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, new lyj(this, l));
      return;
      this.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_a_of_type_JavaLangString;
      this.c = paramQQAppInterface.jdField_b_of_type_JavaLangString;
      QLog.w("ShareChat", 1, "ShareChat, 从缓存中找到url, groupUin[" + paramString + "], m_share_url_with_no_sig[" + this.jdField_b_of_type_JavaLangString + "], m_share_url[" + this.c + "], seq[" + l + "], mSharePanel[" + this.jdField_a_of_type_Lyn + "]");
      break;
      paramInt = 0;
      break label152;
      i = 0;
      break label163;
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((akhp)paramQQAppInterface.a(20)).b(paramString, false);
    if (this.jdField_a_of_type_Lym == null)
    {
      this.jdField_a_of_type_Lym = new lym(this, null);
      this.jdField_a_of_type_Lym.jdField_a_of_type_JavaLangString = paramString;
      paramQQAppInterface.addObserver(this.jdField_a_of_type_Lym);
    }
  }
  
  boolean a()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_JavaLangString);
    if (localTroopInfo == null)
    {
      QLog.w("ShareChat", 1, "initData fail, mGroupUin[" + this.jdField_a_of_type_JavaLangString + "]");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(localTroopInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return true;
  }
  
  void b(long paramLong1, long paramLong2, int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    long l = bbkk.a("ShareChat", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = bbcz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    }
    int i = 3;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
      i = 1;
    }
    for (;;)
    {
      localObject1 = new lyk(this);
      QLog.w("ShareChat", 1, "requestGetUrlFromServer, share_name[" + (String)localObject2 + "], role[" + i + "], troopUin[" + l + "], roomID[" + paramLong2 + "], roomCreateTime[" + paramInt + "], seq[" + paramLong1 + "]");
      ReqGroupVideo.ReqCreateShareUrl localReqCreateShareUrl = new ReqGroupVideo.ReqCreateShareUrl();
      localReqCreateShareUrl.uint64_uin.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
      localReqCreateShareUrl.uint64_group_code.set(l);
      localReqCreateShareUrl.uint64_room_id.set(paramLong2);
      localReqCreateShareUrl.uint32_room_create_time.set(paramInt);
      localReqCreateShareUrl.group_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName));
      localReqCreateShareUrl.share_name.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localReqCreateShareUrl.role.set(i);
      lgy.a(paramLong1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "QQRTCSvc.group_video_create_share_url", localReqCreateShareUrl, (lhb)localObject1);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lyi
 * JD-Core Version:    0.7.0.1
 */