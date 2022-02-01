import android.app.Activity;
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
import com.tencent.av.share.ShareChat.SharePanel.6;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class lyw
{
  int jdField_a_of_type_Int = -1;
  final long jdField_a_of_type_Long;
  ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  String jdField_a_of_type_JavaLangString = null;
  public lzb a;
  lzc jdField_a_of_type_Lzc;
  int b;
  
  lyw(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Lzb = null;
    this.b = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a(long paramLong, Context paramContext, boolean paramBoolean, int paramInt, String paramString, lzb paramlzb)
  {
    String str1 = String.valueOf(System.currentTimeMillis());
    Bitmap localBitmap = null;
    if (paramlzb != null) {
      localBitmap = paramlzb.a(paramLong);
    }
    localBitmap = bhbx.a(localBitmap);
    String str2 = lyr.a(paramContext);
    paramlzb = lyr.a(paramlzb);
    int i;
    if (paramBoolean)
    {
      i = 3;
      a(paramContext, str1, i, paramInt);
      if (!paramBoolean) {
        break label159;
      }
      WXShareHelper.a().a(str1, str2, localBitmap, paramlzb, paramString);
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
      paramContext = bhbx.a(paramlzb, paramContext);
      WXShareHelper.a().b(str1, str2, localBitmap, paramContext, paramString);
    }
  }
  
  private void b(long paramLong, Context paramContext, int paramInt, lzb paramlzb, String paramString)
  {
    String str = lyr.b(paramlzb);
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(str)) {
      localArrayList.add(str);
    }
    str = paramContext.getString(2131692850) + paramString;
    Bundle localBundle = new Bundle();
    localBundle.putString("title", lyr.a(paramContext));
    localBundle.putString("desc", lyr.a(paramlzb));
    localBundle.putLong("req_share_id", 0L);
    localBundle.putString("detail_url", paramString);
    localBundle.putString("url", paramString);
    localBundle.putStringArrayList("image_url", localArrayList);
    localBundle.putString("troop_wording", str);
    localBundle.putString("bizname", "JoinTroopLink");
    localBundle.putParcelable("PARAM_ActivityResultReceiver", new ShareChat.SharePanel.1(this, new Handler(), paramLong, paramInt));
    bmud.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramContext, localBundle, null, 145);
    if (QLog.isColorLevel()) {
      QLog.w("ShareChat", 1, "shareToQzone, shareLink[" + paramString + "], seq[" + paramLong + "]");
    }
  }
  
  private void b(long paramLong, Context paramContext, int paramInt, lzb paramlzb, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if ((paramlzb == null) || (paramActionSheetItem == null)) {
      return;
    }
    try
    {
      Object localObject3 = lyr.a(paramContext);
      String str1 = lyr.a(paramContext);
      String str2 = lyr.a(paramlzb);
      String str3 = lyr.b(paramlzb);
      Object localObject2 = paramContext.getString(2131692848);
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
      paramlzb = paramlzb.a(0);
      if (!TextUtils.isEmpty(paramlzb))
      {
        paramString = new JSONObject();
        paramString.put("type", paramlzb);
        paramString.put("name", paramlzb);
        paramString.put("reportType", "898");
        paramString.put("r2", bhsr.a("ShareChat", this.jdField_a_of_type_JavaLangString));
        localJSONObject.put("report", paramString);
      }
      ((JSONObject)localObject3).put("news", localJSONObject);
      ((JSONObject)localObject1).put("meta", localObject3);
      localObject2 = ((JSONObject)localObject1).toString();
      paramlzb = ((JSONObject)localObject1).getString("app");
      paramString = ((JSONObject)localObject1).getString("ver");
      str1 = ((JSONObject)localObject1).getString("view");
      str2 = ((JSONObject)localObject1).getString("config");
      str3 = ((JSONObject)localObject1).getString("meta");
      localObject1 = ((JSONObject)localObject1).getString("prompt");
      QLog.w("ShareChat", 1, "shareToMobileQQ, data[" + (String)localObject2 + "], appName[" + paramlzb + "], appMinVersion[" + paramString + "], appView[" + str1 + "], config[" + str2 + "], metaList[" + str3 + "], promptText[" + (String)localObject1 + "], seq[" + paramLong + "]");
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("forward_type", 27);
      ((Intent)localObject2).putExtra("is_ark_display_share", true);
      ((Intent)localObject2).putExtra("forward_ark_app_name", paramlzb);
      ((Intent)localObject2).putExtra("forward_ark_app_view", str1);
      ((Intent)localObject2).putExtra("forward_ark_app_ver", paramString);
      ((Intent)localObject2).putExtra("forward_ark_app_prompt", (String)localObject1);
      ((Intent)localObject2).putExtra("forward_ark_app_meta", str3);
      ((Intent)localObject2).putExtra("forward_ark_app_config", str2);
      paramlzb = bhow.a(paramlzb, str1, paramString, str3, paramContext.getResources().getDisplayMetrics().scaledDensity, null, null);
      paramlzb.putInt("key_req", ForwardRecentActivity.f);
      paramlzb.putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
      paramlzb.putString("key_direct_show_uin", paramActionSheetItem.uin);
      ((Intent)localObject2).putExtras(paramlzb);
      ((Intent)localObject2).putExtra("PARAM_ActivityResultReceiver", new ShareChat.SharePanel.2(this, new Handler(), paramLong, paramInt));
      auxu.a((Activity)paramContext, (Intent)localObject2, ForwardRecentTranslucentActivity.class, -1);
      return;
    }
    catch (Exception paramlzb)
    {
      QLog.w("ShareChat", 1, "shareToMobileQQ, Exception, seq[" + paramLong + "]", paramlzb);
      QQToast.a(paramContext, anzj.a(2131712777), 0).a();
      a(0, paramInt, 3);
    }
  }
  
  private void c(long paramLong, Context paramContext, int paramInt, lzb paramlzb, String paramString)
  {
    paramlzb = paramContext.getString(2131692850) + paramString;
    if (QLog.isColorLevel()) {
      QLog.w("ShareChat", 1, "copyTroopLink, text[" + paramlzb + "], seq[" + paramLong + "]");
    }
    ((ClipboardManager)paramContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("troop_url", paramlzb));
    QQToast.a(paramContext, 2, 2131692851, 0).a();
    a(4, paramInt, 2);
  }
  
  private void d(long paramLong, Context paramContext, int paramInt, lzb paramlzb, String paramString)
  {
    if (paramlzb == null) {
      return;
    }
    paramlzb = new Intent(paramContext, DirectForwardActivity.class);
    paramlzb.putExtra("isFromShare", true);
    paramlzb.putExtra("isFromTeamWork", true);
    paramlzb.putExtra("toUin", antf.z);
    paramlzb.putExtra("uinType", 6000);
    paramlzb.putExtra("forward_type", -1);
    paramlzb.putExtra("forward_text", paramContext.getResources().getText(2131692850) + paramString);
    paramlzb.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
    paramContext.startActivity(paramlzb);
  }
  
  private void d(long paramLong, Context paramContext, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (this.jdField_a_of_type_Lzb == null) {
      QLog.w("ShareChat", 1, "tryToGetShareLink, mIHandle为空");
    }
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_Lzb.a(paramLong, this.b);
      if (TextUtils.isEmpty(str))
      {
        boolean bool = bhnv.d(null);
        QLog.w("ShareChat", 1, "tryToGetShareLink, url为空, isConn[" + bool + "], mChoosedChannel[" + this.jdField_a_of_type_Int + "], mChoosedLinkType[" + this.b + "], seq[" + paramLong + "]");
        if ((!bool) && (this.jdField_a_of_type_Int != 4))
        {
          QQToast.a(paramContext, paramContext.getString(2131691989), 0).a();
          if (QLog.isColorLevel()) {
            QLog.w("ShareChat", 1, "tryToGetShareLink, !isNetSupport, mChoosedChannel[" + this.jdField_a_of_type_Int + "]");
          }
        }
        for (;;)
        {
          a(this.jdField_a_of_type_Int, this.b, 3);
          return;
          QQToast.a(paramContext, anzj.a(2131712775), 0).a();
        }
      }
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        return;
      case 0: 
      case 73: 
        a(paramLong, paramContext, this.b, this.jdField_a_of_type_Lzb, str, paramActionSheetItem);
        return;
      case 3: 
        a(paramLong, paramContext, true, this.b, str, this.jdField_a_of_type_Lzb);
        return;
      case 2: 
        a(paramLong, paramContext, false, this.b, str, this.jdField_a_of_type_Lzb);
        return;
      case 72: 
        b(paramLong, paramContext, this.b, this.jdField_a_of_type_Lzb, str, paramActionSheetItem);
        return;
      case 1: 
        b(paramLong, paramContext, this.b, this.jdField_a_of_type_Lzb, str);
        return;
      case 4: 
        c(paramLong, paramContext, this.b, this.jdField_a_of_type_Lzb, str);
        return;
      case 5: 
        a(paramLong, paramContext, this.b, this.jdField_a_of_type_Lzb, str);
        return;
      case 26: 
        d(paramLong, paramContext, this.b, this.jdField_a_of_type_Lzb, str);
        return;
      }
    } while (!bmko.a(str).a(paramContext, paramActionSheetItem.uin, 101, null));
    QQToast.a(paramContext, 2, 2131691991, 0).a();
  }
  
  void a()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Lzb != null) {
      this.jdField_a_of_type_Lzb.a(paramInt1, paramInt2, paramInt3);
    }
    a();
  }
  
  void a(long paramLong, Context paramContext, int paramInt, lzb paramlzb, String paramString)
  {
    TroopInfoData localTroopInfoData = paramlzb.a();
    if (localTroopInfoData == null)
    {
      a(5, paramInt, 3);
      return;
    }
    Intent localIntent = new Intent(paramContext, QRDisplayActivity.class);
    localIntent.putExtra("title", paramContext.getString(2131715826));
    int i;
    if (TextUtils.isEmpty(localTroopInfoData.troopName))
    {
      localIntent.putExtra("nick", localTroopInfoData.newTroopName);
      paramlzb = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("uin", localTroopInfoData.troopUin);
      if (!localTroopInfoData.bOwner) {
        break label323;
      }
      i = 0;
      label122:
      localIntent.putExtra("adminLevel", i);
      localIntent.putExtra("type", 11);
      localIntent.putExtra("GroupFlagExt", localTroopInfoData.dwGroupFlagExt);
      localIntent.putExtra("AuthGroupType", localTroopInfoData.dwAuthGroupType);
      if (!(paramlzb instanceof QQAppInterface)) {
        break label343;
      }
    }
    label323:
    label343:
    for (paramlzb = (QQAppInterface)paramlzb;; paramlzb = null)
    {
      boolean bool = TroopInfo.isQidianPrivateTroop(paramlzb, localTroopInfoData.troopUin);
      localIntent.putExtra("isQidianPrivateTroop", bool);
      if (bool) {
        localIntent.putExtra("groupOwner", localTroopInfoData.troopowneruin);
      }
      localIntent.putExtra("PARAM_QRForwardReceiver", new ShareChat.SharePanel.4(this, new Handler(), paramLong, paramInt));
      localIntent.putExtra("PARAM_ActivityResultReceiver", new ShareChat.SharePanel.5(this, new Handler(), paramLong, paramInt));
      ThreadManager.post(new ShareChat.SharePanel.6(this, paramlzb, localTroopInfoData, localIntent, paramContext, paramInt), 8, null, true);
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
  
  public void a(long paramLong, Context paramContext, int paramInt, lzb paramlzb, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramlzb == null) {
      return;
    }
    try
    {
      Object localObject2 = lyr.a(paramContext);
      String str1 = lyr.a(paramContext);
      String str2 = lyr.a(paramlzb);
      String str3 = lyr.b(paramlzb);
      Object localObject1 = paramContext.getString(2131692848);
      paramActionSheetItem = new JSONObject();
      paramActionSheetItem.put("prompt", localObject2);
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("forward", true);
      ((JSONObject)localObject2).put("autosize", true);
      paramActionSheetItem.put("config", localObject2);
      paramActionSheetItem.put("app", "com.tencent.qqavchat");
      paramActionSheetItem.put("ver", "0.0.0.1");
      paramActionSheetItem.put("view", "qqavchat");
      localObject2 = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("title", str1);
      localJSONObject.put("desc", str2);
      localJSONObject.put("preview", str3);
      localJSONObject.put("tag", localObject1);
      localJSONObject.put("jumpUrl", paramString);
      paramlzb = paramlzb.a(0);
      if (!TextUtils.isEmpty(paramlzb))
      {
        paramString = new JSONObject();
        paramString.put("type", paramlzb);
        paramString.put("name", paramlzb);
        paramString.put("reportType", "898");
        paramString.put("r2", bhsr.a("ShareChat", this.jdField_a_of_type_JavaLangString));
        localJSONObject.put("report", paramString);
      }
      ((JSONObject)localObject2).put("news", localJSONObject);
      paramActionSheetItem.put("meta", localObject2);
      localObject1 = paramActionSheetItem.toString();
      paramlzb = paramActionSheetItem.getString("app");
      paramString = paramActionSheetItem.getString("ver");
      str1 = paramActionSheetItem.getString("view");
      str2 = paramActionSheetItem.getString("config");
      str3 = paramActionSheetItem.getString("meta");
      paramActionSheetItem = paramActionSheetItem.getString("prompt");
      QLog.w("ShareChat", 1, "shareToMobileQQ, data[" + (String)localObject1 + "], appName[" + paramlzb + "], appMinVersion[" + paramString + "], appView[" + str1 + "], config[" + str2 + "], metaList[" + str3 + "], promptText[" + paramActionSheetItem + "], seq[" + paramLong + "]");
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("forward_type", 27);
      ((Intent)localObject1).putExtra("is_ark_display_share", true);
      ((Intent)localObject1).putExtra("forward_ark_app_name", paramlzb);
      ((Intent)localObject1).putExtra("forward_ark_app_view", str1);
      ((Intent)localObject1).putExtra("forward_ark_app_ver", paramString);
      ((Intent)localObject1).putExtra("forward_ark_app_prompt", paramActionSheetItem);
      ((Intent)localObject1).putExtra("forward_ark_app_meta", str3);
      ((Intent)localObject1).putExtra("forward_ark_app_config", str2);
      ((Intent)localObject1).putExtras(bhow.a(paramlzb, str1, paramString, str3, paramContext.getResources().getDisplayMetrics().scaledDensity, null, null));
      ((Intent)localObject1).putExtra("PARAM_ActivityResultReceiver", new ShareChat.SharePanel.3(this, new Handler(), paramLong, paramInt));
      auxu.a(paramContext, (Intent)localObject1);
      return;
    }
    catch (Exception paramlzb)
    {
      QLog.w("ShareChat", 1, "shareToMobileQQ, Exception, seq[" + paramLong + "]", paramlzb);
      QQToast.a(paramContext, anzj.a(2131712777), 0).a();
      a(0, paramInt, 3);
    }
  }
  
  void a(long paramLong, Context paramContext, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    this.b = 0;
    d(paramLong, paramContext, paramActionSheetItem);
  }
  
  void a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      return;
    }
    Object localObject = new ShareActionSheetV2.Param();
    ((ShareActionSheetV2.Param)localObject).context = paramContext;
    ((ShareActionSheetV2.Param)localObject).fullScreen = false;
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetTitle(paramContext.getString(2131718159));
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(((Activity)paramContext).getIntent());
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(0, 0, 0);
    paramContext = new ArrayList();
    localObject = new ArrayList();
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(26));
    ((List)localObject).add(ShareActionSheetBuilder.ActionSheetItem.build(1));
    ((List)localObject).add(ShareActionSheetBuilder.ActionSheetItem.build(6));
    ((List)localObject).add(ShareActionSheetBuilder.ActionSheetItem.build(123));
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(paramContext, (List)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setOnDismissListener(new lyz(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(this.jdField_a_of_type_Lzc);
  }
  
  void a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    WXShareHelper.a().a(new lyy(this, paramString, paramContext, paramInt1, paramInt2));
  }
  
  void a(Context paramContext, String paramString, lzb paramlzb)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Lzb = paramlzb;
    this.jdField_a_of_type_Lzc = new lzc(this, paramContext);
    this.jdField_a_of_type_Lzc.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    a(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
  }
  
  void b(long paramLong, Context paramContext, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    this.b = 1;
    d(paramLong, paramContext, paramActionSheetItem);
  }
  
  protected void c(long paramLong, Context paramContext, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    blir localblir = (blir)blji.a(paramContext, null);
    localblir.b(2131719049);
    localblir.b(2131719050);
    localblir.c(2131690580);
    localblir.setOnDismissListener(new lza(this, paramLong));
    localblir.a(new lyx(this, paramLong, paramActionSheetItem, localblir));
    switch (this.jdField_a_of_type_Int)
    {
    case 4: 
    default: 
      paramContext = paramContext.getString(2131719047);
    }
    for (;;)
    {
      localblir.a(paramContext);
      localblir.show();
      return;
      paramContext = String.format(paramContext.getString(2131690703), new Object[] { paramContext.getString(2131719048) });
      continue;
      paramContext = String.format(paramContext.getString(2131690703), new Object[] { paramContext.getString(2131719051) });
      continue;
      paramContext = String.format(paramContext.getString(2131690703), new Object[] { paramContext.getString(2131718163) });
      continue;
      paramContext = String.format(paramContext.getString(2131690703), new Object[] { paramContext.getString(2131718166) });
      continue;
      paramContext = anzj.a(2131712776);
    }
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_Long + "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lyw
 * JD-Core Version:    0.7.0.1
 */