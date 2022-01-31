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

public class lyn
{
  int jdField_a_of_type_Int = -1;
  final long jdField_a_of_type_Long;
  bbjq jdField_a_of_type_Bbjq;
  String jdField_a_of_type_JavaLangString = null;
  public lys a;
  lyt jdField_a_of_type_Lyt = new lyt(this);
  int b;
  
  lyn(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Lys = null;
    this.b = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a(long paramLong, Context paramContext, boolean paramBoolean, int paramInt, String paramString, lys paramlys)
  {
    String str1 = String.valueOf(System.currentTimeMillis());
    Bitmap localBitmap = null;
    if (paramlys != null) {
      localBitmap = paramlys.a(paramLong);
    }
    localBitmap = baui.a(localBitmap);
    String str2 = lyi.a(paramContext);
    paramlys = lyi.a(paramlys);
    int i;
    if (paramBoolean)
    {
      i = 3;
      a(paramContext, str1, i, paramInt);
      if (!paramBoolean) {
        break label159;
      }
      WXShareHelper.a().a(str1, str2, localBitmap, paramlys, paramString);
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
      paramContext = baui.a(paramlys, paramContext);
      WXShareHelper.a().b(str1, str2, localBitmap, paramContext, paramString);
    }
  }
  
  private void c(long paramLong, Context paramContext, int paramInt, lys paramlys, String paramString)
  {
    String str = lyi.b(paramlys);
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(str)) {
      localArrayList.add(str);
    }
    str = paramContext.getString(2131693247) + paramString;
    Bundle localBundle = new Bundle();
    localBundle.putString("title", lyi.a(paramContext));
    localBundle.putString("desc", lyi.a(paramlys));
    localBundle.putLong("req_share_id", 0L);
    localBundle.putString("detail_url", paramString);
    localBundle.putString("url", paramString);
    localBundle.putStringArrayList("image_url", localArrayList);
    localBundle.putString("troop_wording", str);
    localBundle.putString("bizname", "JoinTroopLink");
    localBundle.putParcelable("PARAM_ActivityResultReceiver", new ShareChat.SharePanel.1(this, new Handler(), paramLong, paramInt));
    bgzl.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramContext, localBundle, null, 145);
    if (QLog.isColorLevel()) {
      QLog.w("ShareChat", 1, "shareToQzone, shareLink[" + paramString + "], seq[" + paramLong + "]");
    }
  }
  
  private void d(long paramLong, Context paramContext)
  {
    if (this.jdField_a_of_type_Lys == null)
    {
      QLog.w("ShareChat", 1, "tryToGetShareLink, mIHandle为空");
      return;
    }
    String str = this.jdField_a_of_type_Lys.a(paramLong, this.b);
    if (TextUtils.isEmpty(str))
    {
      boolean bool = bbfj.d(null);
      QLog.w("ShareChat", 1, "tryToGetShareLink, url为空, isConn[" + bool + "], mChoosedChannel[" + this.jdField_a_of_type_Int + "], mChoosedLinkType[" + this.b + "], seq[" + paramLong + "]");
      if ((!bool) && (this.jdField_a_of_type_Int != 4))
      {
        bcql.a(paramContext, paramContext.getString(2131692321), 0).a();
        if (QLog.isColorLevel()) {
          QLog.w("ShareChat", 1, "tryToGetShareLink, !isNetSupport, mChoosedChannel[" + this.jdField_a_of_type_Int + "]");
        }
      }
      for (;;)
      {
        a(this.jdField_a_of_type_Int, this.b, 3);
        return;
        bcql.a(paramContext, ajya.a(2131713912), 0).a();
      }
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      a(paramLong, paramContext, this.b, this.jdField_a_of_type_Lys, str);
      return;
    case 3: 
      a(paramLong, paramContext, true, this.b, str, this.jdField_a_of_type_Lys);
      return;
    case 2: 
      a(paramLong, paramContext, false, this.b, str, this.jdField_a_of_type_Lys);
      return;
    case 1: 
      c(paramLong, paramContext, this.b, this.jdField_a_of_type_Lys, str);
      return;
    case 4: 
      d(paramLong, paramContext, this.b, this.jdField_a_of_type_Lys, str);
      return;
    }
    b(paramLong, paramContext, this.b, this.jdField_a_of_type_Lys, str);
  }
  
  private void d(long paramLong, Context paramContext, int paramInt, lys paramlys, String paramString)
  {
    paramlys = paramContext.getString(2131693247) + paramString;
    if (QLog.isColorLevel()) {
      QLog.w("ShareChat", 1, "copyTroopLink, text[" + paramlys + "], seq[" + paramLong + "]");
    }
    ((ClipboardManager)paramContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("troop_url", paramlys));
    bcql.a(paramContext, 2, 2131693248, 0).a();
    a(4, paramInt, 2);
  }
  
  void a()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Lys != null) {
      this.jdField_a_of_type_Lys.a(paramInt1, paramInt2, paramInt3);
    }
    a();
  }
  
  void a(long paramLong, Context paramContext)
  {
    this.b = 0;
    d(paramLong, paramContext);
  }
  
  public void a(long paramLong, Context paramContext, int paramInt, lys paramlys, String paramString)
  {
    if (paramlys == null) {
      return;
    }
    try
    {
      Object localObject3 = lyi.a(paramContext);
      String str1 = lyi.a(paramContext);
      String str2 = lyi.a(paramlys);
      String str3 = lyi.b(paramlys);
      Object localObject2 = paramContext.getString(2131693245);
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
      paramlys = paramlys.a(0);
      if (!TextUtils.isEmpty(paramlys))
      {
        paramString = new JSONObject();
        paramString.put("type", paramlys);
        paramString.put("name", paramlys);
        paramString.put("reportType", "898");
        paramString.put("r2", bbkk.a("ShareChat", this.jdField_a_of_type_JavaLangString));
        localJSONObject.put("report", paramString);
      }
      ((JSONObject)localObject3).put("news", localJSONObject);
      ((JSONObject)localObject1).put("meta", localObject3);
      localObject2 = ((JSONObject)localObject1).toString();
      paramlys = ((JSONObject)localObject1).getString("app");
      paramString = ((JSONObject)localObject1).getString("ver");
      str1 = ((JSONObject)localObject1).getString("view");
      str2 = ((JSONObject)localObject1).getString("config");
      str3 = ((JSONObject)localObject1).getString("meta");
      localObject1 = ((JSONObject)localObject1).getString("prompt");
      QLog.w("ShareChat", 1, "shareToMobileQQ, data[" + (String)localObject2 + "], appName[" + paramlys + "], appMinVersion[" + paramString + "], appView[" + str1 + "], config[" + str2 + "], metaList[" + str3 + "], promptText[" + (String)localObject1 + "], seq[" + paramLong + "]");
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("forward_type", 27);
      ((Intent)localObject2).putExtra("is_ark_display_share", true);
      ((Intent)localObject2).putExtra("forward_ark_app_name", paramlys);
      ((Intent)localObject2).putExtra("forward_ark_app_view", str1);
      ((Intent)localObject2).putExtra("forward_ark_app_ver", paramString);
      ((Intent)localObject2).putExtra("forward_ark_app_prompt", (String)localObject1);
      ((Intent)localObject2).putExtra("forward_ark_app_meta", str3);
      ((Intent)localObject2).putExtra("forward_ark_app_config", str2);
      ((Intent)localObject2).putExtras(bbgo.a(paramlys, str1, paramString, str3, paramContext.getResources().getDisplayMetrics().scaledDensity, null, null));
      ((Intent)localObject2).putExtra("PARAM_ActivityResultReceiver", new ShareChat.SharePanel.2(this, new Handler(), paramLong, paramInt));
      aqbe.a(paramContext, (Intent)localObject2);
      return;
    }
    catch (Exception paramlys)
    {
      QLog.w("ShareChat", 1, "shareToMobileQQ, Exception, seq[" + paramLong + "]", paramlys);
      bcql.a(paramContext, ajya.a(2131713914), 0).a();
      a(0, paramInt, 3);
    }
  }
  
  void a(Context paramContext)
  {
    if (this.jdField_a_of_type_Bbjq != null) {
      return;
    }
    this.jdField_a_of_type_Bbjq = new bbjq(paramContext);
    this.jdField_a_of_type_Bbjq.a(paramContext.getString(2131719508));
    this.jdField_a_of_type_Bbjq.a(baui.a(paramContext, true));
    this.jdField_a_of_type_Bbjq.a(new lyp(this));
    this.jdField_a_of_type_Bbjq.a(this.jdField_a_of_type_Lyt);
  }
  
  void a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    WXShareHelper.a().a(new lyo(this, paramString, paramContext, paramInt1, paramInt2));
  }
  
  void a(Context paramContext, String paramString, lys paramlys)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Lys = paramlys;
    this.jdField_a_of_type_Lyt.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    a(paramContext);
    this.jdField_a_of_type_Bbjq.a();
  }
  
  void b(long paramLong, Context paramContext)
  {
    this.b = 1;
    d(paramLong, paramContext);
  }
  
  void b(long paramLong, Context paramContext, int paramInt, lys paramlys, String paramString)
  {
    TroopInfoData localTroopInfoData = paramlys.a();
    if (localTroopInfoData == null)
    {
      a(5, paramInt, 3);
      return;
    }
    Intent localIntent = new Intent(paramContext, QRDisplayActivity.class);
    localIntent.putExtra("title", paramContext.getString(2131717076));
    int i;
    if (TextUtils.isEmpty(localTroopInfoData.troopName))
    {
      localIntent.putExtra("nick", localTroopInfoData.newTroopName);
      paramlys = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
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
      if (!(paramlys instanceof QQAppInterface)) {
        break label344;
      }
    }
    label324:
    label344:
    for (paramlys = (QQAppInterface)paramlys;; paramlys = null)
    {
      boolean bool = TroopInfo.isQidianPrivateTroop(paramlys, localTroopInfoData.troopUin);
      localIntent.putExtra("isQidianPrivateTroop", bool);
      if (bool) {
        localIntent.putExtra("groupOwner", localTroopInfoData.troopowneruin);
      }
      localIntent.putExtra("PARAM_QRForwardReceiver", new ShareChat.SharePanel.3(this, new Handler(), paramLong, paramInt));
      localIntent.putExtra("PARAM_ActivityResultReceiver", new ShareChat.SharePanel.4(this, new Handler(), paramLong, paramInt));
      ThreadManager.post(new ShareChat.SharePanel.5(this, paramlys, localTroopInfoData, localIntent, paramContext, paramInt), 8, null, true);
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
    bfpc localbfpc = (bfpc)bfpp.a(paramContext, null);
    localbfpc.b(2131720611);
    localbfpc.b(2131720612);
    localbfpc.c(2131690596);
    localbfpc.setOnDismissListener(new lyq(this, paramLong));
    localbfpc.a(new lyr(this, paramLong, localbfpc));
    switch (this.jdField_a_of_type_Int)
    {
    case 4: 
    default: 
      paramContext = paramContext.getString(2131720609);
    }
    for (;;)
    {
      localbfpc.a(paramContext);
      localbfpc.show();
      return;
      paramContext = String.format(paramContext.getString(2131690791), new Object[] { paramContext.getString(2131720610) });
      continue;
      paramContext = String.format(paramContext.getString(2131690791), new Object[] { paramContext.getString(2131720613) });
      continue;
      paramContext = String.format(paramContext.getString(2131690791), new Object[] { paramContext.getString(2131719513) });
      continue;
      paramContext = String.format(paramContext.getString(2131690791), new Object[] { paramContext.getString(2131719516) });
      continue;
      paramContext = ajya.a(2131713913);
    }
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_Long + "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lyn
 * JD-Core Version:    0.7.0.1
 */