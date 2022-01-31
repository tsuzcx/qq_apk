import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.av.share.ShareChat.SharePanel.1;
import com.tencent.av.share.ShareChat.SharePanel.2;
import com.tencent.av.share.ShareChat.SharePanel.3;
import com.tencent.av.share.ShareChat.SharePanel.4;
import com.tencent.av.share.ShareChat.SharePanel.5;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONObject;

public class lys
{
  int jdField_a_of_type_Int = -1;
  final long jdField_a_of_type_Long;
  bbjc jdField_a_of_type_Bbjc;
  String jdField_a_of_type_JavaLangString = null;
  public lyx a;
  lyy jdField_a_of_type_Lyy = new lyy(this);
  int b;
  
  lys(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Lyx = null;
    this.b = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a(long paramLong, Context paramContext, boolean paramBoolean, int paramInt, String paramString, lyx paramlyx)
  {
    String str1 = String.valueOf(System.currentTimeMillis());
    Bitmap localBitmap = null;
    if (paramlyx != null) {
      localBitmap = paramlyx.a(paramLong);
    }
    localBitmap = batu.a(localBitmap);
    String str2 = lyn.a(paramContext);
    paramlyx = lyn.a(paramlyx);
    int i;
    if (paramBoolean)
    {
      i = 3;
      a(paramContext, str1, i, paramInt);
      if (!paramBoolean) {
        break label159;
      }
      WXShareHelper.a().a(str1, str2, localBitmap, paramlyx, paramString);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ShareChat", 1, "shareToWX, mWXTransaction[" + str1 + "], bFriendCircle[" + paramBoolean + "], shareLink[" + paramString + "], seq[" + paramLong + "]");
      }
      return;
      i = 2;
      break;
      label159:
      paramContext = batu.a(paramlyx, paramContext);
      WXShareHelper.a().b(str1, str2, localBitmap, paramContext, paramString);
    }
  }
  
  private void c(long paramLong, Context paramContext, int paramInt, lyx paramlyx, String paramString)
  {
    String str = lyn.b(paramlyx);
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(str)) {
      localArrayList.add(str);
    }
    str = paramContext.getString(2131693246) + paramString;
    Bundle localBundle = new Bundle();
    localBundle.putString("title", lyn.a(paramContext));
    localBundle.putString("desc", lyn.a(paramlyx));
    localBundle.putLong("req_share_id", 0L);
    localBundle.putString("detail_url", paramString);
    localBundle.putString("url", paramString);
    localBundle.putStringArrayList("image_url", localArrayList);
    localBundle.putString("troop_wording", str);
    localBundle.putString("bizname", "JoinTroopLink");
    localBundle.putParcelable("PARAM_ActivityResultReceiver", new ShareChat.SharePanel.1(this, new Handler(), paramLong, paramInt));
    bgyu.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramContext, localBundle, null, 145);
    if (QLog.isColorLevel()) {
      QLog.w("ShareChat", 1, "shareToQzone, shareLink[" + paramString + "], seq[" + paramLong + "]");
    }
  }
  
  private void d(long paramLong, Context paramContext)
  {
    if (this.jdField_a_of_type_Lyx == null)
    {
      QLog.w("ShareChat", 1, "tryToGetShareLink, mIHandle为空");
      return;
    }
    String str = this.jdField_a_of_type_Lyx.a(paramLong, this.b);
    if (TextUtils.isEmpty(str))
    {
      boolean bool = bbev.d(null);
      QLog.w("ShareChat", 1, "tryToGetShareLink, url为空, isConn[" + bool + "], mChoosedChannel[" + this.jdField_a_of_type_Int + "], mChoosedLinkType[" + this.b + "], seq[" + paramLong + "]");
      if ((!bool) && (this.jdField_a_of_type_Int != 4))
      {
        bcpw.a(paramContext, paramContext.getString(2131692321), 0).a();
        if (QLog.isColorLevel()) {
          QLog.w("ShareChat", 1, "tryToGetShareLink, !isNetSupport, mChoosedChannel[" + this.jdField_a_of_type_Int + "]");
        }
      }
      for (;;)
      {
        a(this.jdField_a_of_type_Int, this.b, 3);
        return;
        bcpw.a(paramContext, ajyc.a(2131713901), 0).a();
      }
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      a(paramLong, paramContext, this.b, this.jdField_a_of_type_Lyx, str);
      return;
    case 3: 
      a(paramLong, paramContext, true, this.b, str, this.jdField_a_of_type_Lyx);
      return;
    case 2: 
      a(paramLong, paramContext, false, this.b, str, this.jdField_a_of_type_Lyx);
      return;
    case 1: 
      c(paramLong, paramContext, this.b, this.jdField_a_of_type_Lyx, str);
      return;
    case 4: 
      d(paramLong, paramContext, this.b, this.jdField_a_of_type_Lyx, str);
      return;
    }
    b(paramLong, paramContext, this.b, this.jdField_a_of_type_Lyx, str);
  }
  
  private void d(long paramLong, Context paramContext, int paramInt, lyx paramlyx, String paramString)
  {
    paramlyx = paramContext.getString(2131693246) + paramString;
    if (QLog.isColorLevel()) {
      QLog.w("ShareChat", 1, "copyTroopLink, text[" + paramlyx + "], seq[" + paramLong + "]");
    }
    ((ClipboardManager)paramContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("troop_url", paramlyx));
    bcpw.a(paramContext, 2, 2131693247, 0).a();
    a(4, paramInt, 2);
  }
  
  void a()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Lyx != null) {
      this.jdField_a_of_type_Lyx.a(paramInt1, paramInt2, paramInt3);
    }
    a();
  }
  
  void a(long paramLong, Context paramContext)
  {
    this.b = 0;
    d(paramLong, paramContext);
  }
  
  public void a(long paramLong, Context paramContext, int paramInt, lyx paramlyx, String paramString)
  {
    if (paramlyx == null) {
      return;
    }
    try
    {
      Object localObject3 = lyn.a(paramContext);
      String str1 = lyn.a(paramContext);
      String str2 = lyn.a(paramlyx);
      String str3 = lyn.b(paramlyx);
      Object localObject2 = paramContext.getString(2131693244);
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("prompt", localObject3);
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("forward", true);
      ((JSONObject)localObject3).put("autosize", true);
      ((JSONObject)localObject1).put("config", localObject3);
      ((JSONObject)localObject1).put("app", "com.tencent.qqavchat");
      ((JSONObject)localObject1).put("ver", "0.0.0.1");
      ((JSONObject)localObject1).put("view", "qqavchat");
      localObject3 = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("title", str1);
      localJSONObject.put("desc", str2);
      localJSONObject.put("preview", str3);
      localJSONObject.put("tag", localObject2);
      localJSONObject.put("jumpUrl", paramString);
      paramlyx = paramlyx.a(0);
      if (!TextUtils.isEmpty(paramlyx))
      {
        paramString = new JSONObject();
        paramString.put("type", paramlyx);
        paramString.put("name", paramlyx);
        paramString.put("reportType", "898");
        paramString.put("r2", bbjw.a("ShareChat", this.jdField_a_of_type_JavaLangString));
        localJSONObject.put("report", paramString);
      }
      ((JSONObject)localObject3).put("news", localJSONObject);
      ((JSONObject)localObject1).put("meta", localObject3);
      localObject2 = ((JSONObject)localObject1).toString();
      paramlyx = ((JSONObject)localObject1).getString("app");
      paramString = ((JSONObject)localObject1).getString("ver");
      str1 = ((JSONObject)localObject1).getString("view");
      str2 = ((JSONObject)localObject1).getString("config");
      str3 = ((JSONObject)localObject1).getString("meta");
      localObject1 = ((JSONObject)localObject1).getString("prompt");
      QLog.w("ShareChat", 1, "shareToMobileQQ, data[" + (String)localObject2 + "], appName[" + paramlyx + "], appMinVersion[" + paramString + "], appView[" + str1 + "], config[" + str2 + "], metaList[" + str3 + "], promptText[" + (String)localObject1 + "], seq[" + paramLong + "]");
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("forward_type", 27);
      ((Intent)localObject2).putExtra("is_ark_display_share", true);
      ((Intent)localObject2).putExtra("forward_ark_app_name", paramlyx);
      ((Intent)localObject2).putExtra("forward_ark_app_view", str1);
      ((Intent)localObject2).putExtra("forward_ark_app_ver", paramString);
      ((Intent)localObject2).putExtra("forward_ark_app_prompt", (String)localObject1);
      ((Intent)localObject2).putExtra("forward_ark_app_meta", str3);
      ((Intent)localObject2).putExtra("forward_ark_app_config", str2);
      ((Intent)localObject2).putExtras(bbga.a(paramlyx, str1, paramString, str3, paramContext.getResources().getDisplayMetrics().scaledDensity, null, null));
      ((Intent)localObject2).putExtra("PARAM_ActivityResultReceiver", new ShareChat.SharePanel.2(this, new Handler(), paramLong, paramInt));
      aqbc.a(paramContext, (Intent)localObject2);
      return;
    }
    catch (Exception paramlyx)
    {
      QLog.w("ShareChat", 1, "shareToMobileQQ, Exception, seq[" + paramLong + "]", paramlyx);
      bcpw.a(paramContext, ajyc.a(2131713903), 0).a();
      a(0, paramInt, 3);
    }
  }
  
  void a(Context paramContext)
  {
    if (this.jdField_a_of_type_Bbjc != null) {
      return;
    }
    this.jdField_a_of_type_Bbjc = new bbjc(paramContext);
    this.jdField_a_of_type_Bbjc.a(paramContext.getString(2131719497));
    this.jdField_a_of_type_Bbjc.a(batu.a(paramContext, true));
    this.jdField_a_of_type_Bbjc.a(new lyu(this));
    this.jdField_a_of_type_Bbjc.a(this.jdField_a_of_type_Lyy);
  }
  
  void a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    WXShareHelper.a().a(new lyt(this, paramString, paramContext, paramInt1, paramInt2));
  }
  
  void a(Context paramContext, String paramString, lyx paramlyx)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Lyx = paramlyx;
    this.jdField_a_of_type_Lyy.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    a(paramContext);
    this.jdField_a_of_type_Bbjc.a();
  }
  
  void b(long paramLong, Context paramContext)
  {
    this.b = 1;
    d(paramLong, paramContext);
  }
  
  void b(long paramLong, Context paramContext, int paramInt, lyx paramlyx, String paramString)
  {
    TroopInfoData localTroopInfoData = paramlyx.a();
    if (localTroopInfoData == null)
    {
      a(5, paramInt, 3);
      return;
    }
    Intent localIntent = new Intent(paramContext, QRDisplayActivity.class);
    localIntent.putExtra("title", paramContext.getString(2131717065));
    int i;
    if (TextUtils.isEmpty(localTroopInfoData.troopName))
    {
      localIntent.putExtra("nick", localTroopInfoData.newTroopName);
      paramlyx = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("uin", localTroopInfoData.troopUin);
      if (!localTroopInfoData.bOwner) {
        break label324;
      }
      i = 0;
      label122:
      localIntent.putExtra("adminLevel", i);
      localIntent.putExtra("type", 11);
      localIntent.putExtra("GroupFlagExt", localTroopInfoData.dwGroupFlagExt);
      localIntent.putExtra("AuthGroupType", localTroopInfoData.dwAuthGroupType);
      if (!(paramlyx instanceof QQAppInterface)) {
        break label344;
      }
    }
    label324:
    label344:
    for (paramlyx = (QQAppInterface)paramlyx;; paramlyx = null)
    {
      boolean bool = TroopInfo.isQidianPrivateTroop(paramlyx, localTroopInfoData.troopUin);
      localIntent.putExtra("isQidianPrivateTroop", bool);
      if (bool) {
        localIntent.putExtra("groupOwner", localTroopInfoData.troopowneruin);
      }
      localIntent.putExtra("PARAM_QRForwardReceiver", new ShareChat.SharePanel.3(this, new Handler(), paramLong, paramInt));
      localIntent.putExtra("PARAM_ActivityResultReceiver", new ShareChat.SharePanel.4(this, new Handler(), paramLong, paramInt));
      ThreadManager.post(new ShareChat.SharePanel.5(this, paramlyx, localTroopInfoData, localIntent, paramContext, paramInt), 8, null, true);
      return;
      localIntent.putExtra("nick", localTroopInfoData.troopName);
      break;
      if (localTroopInfoData.bAdmin)
      {
        i = 1;
        break label122;
      }
      i = 2;
      break label122;
    }
  }
  
  protected void c(long paramLong, Context paramContext)
  {
    bfol localbfol = (bfol)bfoy.a(paramContext, null);
    localbfol.b(2131720600);
    localbfol.b(2131720601);
    localbfol.c(2131690596);
    localbfol.setOnDismissListener(new lyv(this, paramLong));
    localbfol.a(new lyw(this, paramLong, localbfol));
    switch (this.jdField_a_of_type_Int)
    {
    case 4: 
    default: 
      paramContext = paramContext.getString(2131720598);
    }
    for (;;)
    {
      localbfol.a(paramContext);
      localbfol.show();
      return;
      paramContext = String.format(paramContext.getString(2131690791), new Object[] { paramContext.getString(2131720599) });
      continue;
      paramContext = String.format(paramContext.getString(2131690791), new Object[] { paramContext.getString(2131720602) });
      continue;
      paramContext = String.format(paramContext.getString(2131690791), new Object[] { paramContext.getString(2131719502) });
      continue;
      paramContext = String.format(paramContext.getString(2131690791), new Object[] { paramContext.getString(2131719505) });
      continue;
      paramContext = ajyc.a(2131713902);
    }
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_Long + "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lys
 * JD-Core Version:    0.7.0.1
 */