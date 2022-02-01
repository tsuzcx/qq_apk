package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.share.WxShareHelperFromReadInjoy;
import com.tencent.mobileqq.kandian.biz.share.api.IScreenShotShareHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import mqq.app.AppRuntime;
import org.json.JSONArray;

public class ScreenShotShareHelper
  implements Handler.Callback, AdapterView.OnItemClickListener, IScreenShotShareHelper
{
  private QQProgressDialog b;
  private String c = null;
  private boolean d = false;
  private int e = 0;
  private Activity f;
  private TroopMemberApiClient g = null;
  private Bitmap h = null;
  private String i = null;
  private ShareActionSheetBuilder j = null;
  private String k;
  private int l = 0;
  private int m = 0;
  private String n = "";
  private String o = "";
  private String p = "";
  private JSONArray q = null;
  private int r = 0;
  private Handler s = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private AdapterView.OnItemClickListener t;
  
  public ScreenShotShareHelper(Activity paramActivity)
  {
    this.f = paramActivity;
    if (this.g == null)
    {
      this.g = TroopMemberApiClient.a();
      this.g.e();
    }
    this.l = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299920);
    this.k = "";
    paramActivity = new DisplayMetrics();
    this.f.getWindowManager().getDefaultDisplay().getMetrics(paramActivity);
    this.r = paramActivity.widthPixels;
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("", 2, "shareScreenShotToWechatCircle!");
    }
    int i1 = h();
    if (i1 != -1)
    {
      QRUtils.a(0, i1);
      return;
    }
    try
    {
      if (!TextUtils.isEmpty(this.c))
      {
        a(this.g, this.d, paramBoolean);
        return;
      }
      QLog.e("", 1, "shareScreenShotToWeChat, mScreenshotWithQRPath is Empty");
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shareScreenShotToWeChat, isTimeline=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("e=");
      localStringBuilder.append(localException.toString());
      QLog.e("", 1, localStringBuilder.toString());
    }
  }
  
  public void a()
  {
    TroopMemberApiClient localTroopMemberApiClient = this.g;
    if (localTroopMemberApiClient != null) {
      localTroopMemberApiClient.f();
    }
  }
  
  public void a(int paramInt)
  {
    this.m = paramInt;
  }
  
  @VisibleForTesting
  protected void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      WxShareHelperFromReadInjoy.getInstance().shareImageToWX(this.c, this.h, paramInt2, false);
    } else {
      WXShareHelper.a().a(this.c, this.h, paramInt2, false);
    }
    this.h.recycle();
    this.h = null;
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.t = paramOnItemClickListener;
  }
  
  protected void a(TroopMemberApiClient paramTroopMemberApiClient, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      paramTroopMemberApiClient.d(new ScreenShotShareHelper.4(this, paramBoolean2));
      return;
    }
    int i1;
    if (paramBoolean2) {
      i1 = 3;
    } else {
      i1 = 2;
    }
    this.e = i1;
    i();
  }
  
  public void a(String paramString)
  {
    this.k = paramString;
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    this.i = paramString1;
    if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.contains("ShotCache_"))) {
      this.m = 3;
    }
    if ((this.m == 0) && (paramInt > 0)) {
      this.m = paramInt;
    }
    if (QLog.isDevelopLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("doOnPhotoPlusActivityEditResult->mScreenshotFromType:");
      paramString1.append(this.m);
      paramString1.append(", mEditScreenshotPath:");
      paramString1.append(this.i);
      paramString1.append(", originImagePath:");
      paramString1.append(paramString2);
      QLog.d("", 2, paramString1.toString());
    }
    if (this.m == 3)
    {
      e(this.i);
      return;
    }
    c();
  }
  
  public void a(JSONArray paramJSONArray)
  {
    this.q = paramJSONArray;
  }
  
  public String b()
  {
    String str1 = BaseApplicationImpl.getApplication().getString(2131916528);
    try
    {
      if (this.q != null)
      {
        int i1 = this.q.length();
        i1 = new Random().nextInt(i1);
        String str2 = this.q.getString(i1);
        return str2;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("actionSheet.show exception=");
        localStringBuilder.append(localException);
        QLog.d("", 2, localStringBuilder.toString());
      }
    }
    return str1;
  }
  
  public void b(String paramString)
  {
    this.o = paramString;
  }
  
  public void c()
  {
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showShareActionSheet->mEditScreenshotPath:");
      ((StringBuilder)localObject1).append(this.i);
      QLog.d("", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.f;
    if (localObject1 != null)
    {
      if (((Activity)localObject1).isFinishing()) {
        return;
      }
      if (this.j == null) {
        this.j = new ShareActionSheetBuilder(this.f);
      }
      if ((((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isPublicAccountUrl(this.k)) && (!TextUtils.isEmpty(b()))) {
        this.j.setActionSheetTitle(b());
      } else {
        this.j.setActionSheetTitle(BaseApplicationImpl.getContext().getString(2131916565));
      }
      this.j.setActionSheetItems(d());
      this.j.setItemClickListener(this);
      try
      {
        this.j.show();
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("actionSheet.show exception=");
          localStringBuilder.append(localException);
          QLog.d("", 2, localStringBuilder.toString());
        }
      }
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("showShareActionSheet->post runnable generate screenshot with QRcode! time:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        QLog.d("", 2, ((StringBuilder)localObject2).toString());
      }
      this.d = true;
      this.c = null;
      this.e = 0;
      Object localObject2 = this.h;
      if (localObject2 != null)
      {
        ((Bitmap)localObject2).recycle();
        this.h = null;
      }
      ThreadManager.executeOnSubThread(new ScreenShotShareHelper.1(this));
    }
  }
  
  public void c(String paramString)
  {
    this.p = paramString;
  }
  
  public Bitmap d(String paramString)
  {
    paramString = ScreenShotImageUtil.a(paramString, this.r, this.k, "QRCode_");
    this.c = ((String)paramString.first);
    paramString = (Bitmap)paramString.second;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generateScreenShotImageWithQRCode->end time:");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("", 2, localStringBuilder.toString());
    }
    this.d = false;
    if (!TextUtils.isEmpty(this.c))
    {
      int i1 = this.e;
      if (i1 > 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3) {
              return paramString;
            }
            this.s.post(new ScreenShotShareHelper.3(this));
            return paramString;
          }
          this.s.post(new ScreenShotShareHelper.2(this));
          return paramString;
        }
        e();
      }
    }
    return paramString;
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] d()
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getContext().getString(2131894171);
    localActionSheetItem.icon = 2130839221;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getContext().getString(2131894185);
    localActionSheetItem.icon = 2130839222;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getContext().getString(2131894192);
    localActionSheetItem.icon = 2130839225;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getContext().getString(2131894174);
    localActionSheetItem.icon = 2130839219;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getContext().getString(2131894189);
    localActionSheetItem.icon = 2130839224;
    localActionSheetItem.action = 12;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("", 2, "shareScreenShotToQZone!");
    }
    if ((!this.d) && (!TextUtils.isEmpty(this.c)))
    {
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
      localUserInfo.qzone_uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      QZoneHelper.forwardToPublishMood(this.f, localUserInfo, this.c, BaseApplicationImpl.getContext().getString(2131918092), "", -1);
      return;
    }
    this.e = 1;
    QQToast.makeText(BaseApplicationImpl.getContext(), 0, 2131892975, 0).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299920));
  }
  
  public void e(String paramString)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shareScreenShotToQQ->imgPath:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("", 2, ((StringBuilder)localObject).toString());
    }
    Intent localIntent = new Intent(this.f, ForwardRecentActivity.class);
    localIntent.putExtra("req_share_id", 1478164480L);
    localIntent.putExtra("image_url", paramString);
    localIntent.putExtra("forward_type", -3);
    if (TextUtils.isEmpty(this.n)) {
      paramString = this.k;
    } else {
      paramString = this.n;
    }
    if (TextUtils.isEmpty(this.p)) {
      localObject = BaseApplicationImpl.getContext().getResources().getString(2131892973);
    } else {
      localObject = this.p;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScreenShotShare|");
    localStringBuilder.append(paramString);
    localStringBuilder.append("|");
    localStringBuilder.append((String)localObject);
    paramString = localStringBuilder.toString();
    if (this.m == 3) {
      paramString = paramString.concat("|1");
    } else {
      paramString = paramString.concat("|0");
    }
    localIntent.putExtra("struct_share_key_content_action_DATA", paramString);
    localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
    localIntent.putExtra("req_type", 5);
    localIntent.putExtra("brief_key", HardCodeUtil.a(2131911053));
    localIntent.putExtra("struct_share_key_source_icon", "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
    localIntent.putExtra("struct_share_key_source_name", "QQ看点");
    localIntent.putExtra("struct_share_key_source_action", "plugin");
    localIntent.putExtra("struct_share_key_source_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
    localIntent.putExtra("stuctmsg_bytes", StructMsgFactory.a(localIntent.getExtras()).getBytes());
    this.f.startActivityForResult(localIntent, 1);
  }
  
  public void f()
  {
    a(false);
  }
  
  public void f(String paramString)
  {
    this.n = paramString;
  }
  
  public void g()
  {
    a(true);
  }
  
  @VisibleForTesting
  protected int h()
  {
    if (!WXShareHelper.a().b()) {
      return 2131918154;
    }
    if (!WXShareHelper.a().c()) {
      return 2131918155;
    }
    return -1;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  @VisibleForTesting
  protected void i()
  {
    QQToast.makeText(BaseApplicationImpl.getContext(), 0, 2131892975, 0).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299920));
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "shareMsgToSina start!");
    }
    if (this.b == null)
    {
      this.b = new QQProgressDialog(this.f, this.l);
      this.b.c(2131891516);
    }
    this.b.show();
    Object localObject = BaseApplicationImpl.getContext().getPackageManager();
    try
    {
      ApplicationInfo localApplicationInfo = ((PackageManager)localObject).getApplicationInfo("com.sina.weibo", 8192);
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "shareMsgToSina installSinaWeibo:true");
      }
      if (TextUtils.isEmpty(this.p)) {
        localObject = BaseApplicationImpl.getContext().getResources().getString(2131892973);
      } else {
        localObject = this.p;
      }
      this.o = ((String)localObject);
      if (TextUtils.isEmpty(this.n)) {
        localObject = this.k;
      } else {
        localObject = this.n;
      }
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.setFlags(268435456);
      localIntent.setType("image/*");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.o);
      localStringBuilder.append((String)localObject);
      localIntent.putExtra("android.intent.extra.TEXT", localStringBuilder.toString());
      if (!TextUtils.isEmpty(this.i)) {
        localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.i)));
      }
      localIntent.setPackage(localApplicationInfo.packageName);
      this.f.startActivity(localIntent);
      if ((this.b != null) && (this.b.isShowing())) {
        this.b.dismiss();
      }
      if (!QLog.isColorLevel()) {
        break label371;
      }
      QLog.d("", 2, "shareMsgToSina start weibo!");
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label307:
      break label307;
    }
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "shareMsgToSina installSinaWeibo:false");
    }
    localObject = this.b;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      this.b.dismiss();
    }
    QQToast.makeText(BaseApplicationImpl.getContext(), 0, 2131892979, 0).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299920));
    label371:
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "shareMsgToSina end!");
    }
  }
  
  public void k()
  {
    ShareActionSheetBuilder localShareActionSheetBuilder = this.j;
    if (localShareActionSheetBuilder != null) {
      localShareActionSheetBuilder.onConfigurationChanged();
    }
  }
  
  public String l()
  {
    return this.p;
  }
  
  public String m()
  {
    String str = this.k;
    if (str != null) {
      return str;
    }
    return "";
  }
  
  public int n()
  {
    return this.m;
  }
  
  public QQProgressDialog o()
  {
    if (this.b == null)
    {
      this.b = new QQProgressDialog(this.f, this.l);
      this.b.c(2131891516);
    }
    return this.b;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "onScreenShotItemClick->begin!");
    }
    Object localObject = paramView.getTag();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "onScreenShotItemClick->tag null!");
      }
      return;
    }
    this.j.dismiss();
    int i1 = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).c.action;
    if (i1 != 2)
    {
      if (i1 != 3)
      {
        if (i1 != 9)
        {
          if (i1 != 10)
          {
            if (i1 == 12) {
              j();
            }
          }
          else {
            g();
          }
        }
        else {
          f();
        }
      }
      else {
        e();
      }
    }
    else {
      e(this.i);
    }
    localObject = this.t;
    if (localObject != null) {
      ((AdapterView.OnItemClickListener)localObject).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.ScreenShotShareHelper
 * JD-Core Version:    0.7.0.1
 */