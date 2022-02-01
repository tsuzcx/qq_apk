package com.tencent.mobileqq.troopshare;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.google.zxing.common.BitMatrix;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerBizHandler;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetAdapter;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class TroopShareUtility
  implements WXShareHelper.WXShareListener
{
  protected int a = -1;
  protected int b = -1;
  protected String c;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  protected QBaseActivity h;
  protected TroopInfoData i;
  protected TroopShareUtility.OnShareListener j;
  boolean k = false;
  protected QQProgressDialog l;
  protected ActionSheetAdapter m = null;
  protected ActionSheet n = null;
  protected ShareActionSheetBuilder o = null;
  protected boolean p = false;
  protected ActionSheet q = null;
  protected boolean r = false;
  protected TroopManagerBizObserver s = new TroopShareUtility.5(this);
  QidianBusinessObserver t = new TroopShareUtility.6(this);
  private boolean u = false;
  
  public TroopShareUtility(QBaseActivity paramQBaseActivity, TroopInfoData paramTroopInfoData)
  {
    this(paramQBaseActivity, paramTroopInfoData, null);
  }
  
  public TroopShareUtility(QBaseActivity paramQBaseActivity, TroopInfoData paramTroopInfoData, TroopShareUtility.OnShareListener paramOnShareListener)
  {
    this.h = paramQBaseActivity;
    this.i = paramTroopInfoData;
    paramQBaseActivity = this.h;
    if (paramQBaseActivity != null)
    {
      paramQBaseActivity.addObserver(this.t);
      this.h.addObserver(this.s);
    }
    this.j = paramOnShareListener;
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawColor(-1);
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint());
      return localBitmap;
    }
    return null;
  }
  
  public static Bitmap a(String paramString, Resources paramResources)
  {
    return a(paramString, paramResources, 540, 70, true);
  }
  
  public static Bitmap a(String paramString, Resources paramResources, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = QRUtils.a(paramString, -1);
    int i4 = ((BitMatrix)localObject).a();
    paramString = new int[i4 * i4];
    int i1 = 0;
    while (i1 < i4)
    {
      int i2 = 0;
      while (i2 < i4)
      {
        int i3;
        if (((BitMatrix)localObject).a(i2, i1)) {
          i3 = -16777216;
        } else {
          i3 = 16777215;
        }
        paramString[(i1 * i4 + i2)] = i3;
        i2 += 1;
      }
      i1 += 1;
    }
    localObject = Bitmap.createBitmap(i4, i4, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject).setPixels(paramString, 0, i4, 0, 0, i4, i4);
    try
    {
      paramString = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.ARGB_8888);
    }
    catch (OutOfMemoryError paramString)
    {
      label139:
      break label139;
    }
    System.gc();
    try
    {
      paramString = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.ARGB_8888);
      if (paramString == null)
      {
        ((Bitmap)localObject).recycle();
        return null;
      }
      Canvas localCanvas = new Canvas(paramString);
      Paint localPaint = new Paint();
      localPaint.setShader(new LinearGradient(0.0F, 0.0F, 0.0F, 600.0F, -657931, -1513240, Shader.TileMode.REPEAT));
      float f1 = paramInt1;
      localCanvas.drawRect(0.0F, 0.0F, f1, f1, localPaint);
      i1 = paramInt1 - paramInt2;
      localCanvas.drawBitmap((Bitmap)localObject, null, new Rect(paramInt2, paramInt2, i1, i1), null);
      if (paramBoolean)
      {
        paramInt1 = (paramInt1 - 106) / 2;
        localPaint = new Paint();
        localPaint.setAntiAlias(true);
        paramInt2 = paramInt1 + 106;
        Rect localRect = new Rect(paramInt1, paramInt1, paramInt2, paramInt2);
        paramResources = BitmapManager.a(paramResources, 2130840141);
        if (paramResources != null)
        {
          localCanvas.drawBitmap(paramResources, null, localRect, localPaint);
          paramResources.recycle();
        }
      }
      ((Bitmap)localObject).recycle();
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        paramResources = new StringBuilder();
        paramResources.append("getQrCode cost time:");
        paramResources.append(l2 - l1);
        QLog.d("TroopShareUtility", 2, paramResources.toString());
      }
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopShareUtility", 2, paramString.getMessage());
      }
      return null;
    }
  }
  
  public static String a(String paramString, Context paramContext)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = paramContext.getString(2131916578);
    }
    return str;
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    for (;;)
    {
      try
      {
        AbsShareMsg localAbsShareMsg = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(132).a(paramBundle.getString("summary")).e(paramBundle.getString("targetUrl")).a(1105290942L).a();
        localAbsShareMsg.mMsgBrief = paramBundle.getString("summary");
        localAbsShareMsg.mContentSummary = paramBundle.getString("summary");
        localAbsShareMsg.mContentTitle = paramBundle.getString("title");
        localObject = paramBundle.getString("sourcename");
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        if (bool) {
          localAbsShareMsg.mSourceName = "NOW";
        } else if (((String)localObject).equals("null")) {
          localAbsShareMsg.mSourceName = "";
        } else {
          localAbsShareMsg.mSourceName = ((String)localObject);
        }
        localObject = paramBundle.getString("sourceIcon");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localAbsShareMsg.mSourceIcon = ((String)localObject);
          localAbsShareMsg.mSourceAction = "";
          localAbsShareMsg.mMsgUrl = paramBundle.getString("targetUrl");
          localAbsShareMsg.mContentCover = paramBundle.getString("imageUrl");
          if (!TextUtils.isEmpty(paramBundle.getString("msgActionData")))
          {
            localAbsShareMsg.mMsgActionData = paramBundle.getString("msgActionData");
            localAbsShareMsg.mMsgAction = "plugin";
          }
          localObject = paramBundle.getString("liveActionData");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localAbsShareMsg.mMsgActionData = ((String)localObject);
            localAbsShareMsg.mMsgAction = "web";
          }
          localObject = StructMsgElementFactory.a(2);
          String str = paramBundle.getString("summary");
          ((AbsStructMsgItem)localObject).a(paramBundle.getString("imageUrl"), paramBundle.getString("title"), str);
          localAbsShareMsg.addItem((AbsStructMsgElement)localObject);
          paramBundle = new Intent();
          paramBundle.putExtra("forward_type", -3);
          paramBundle.putExtra("emoInputType", 2);
          paramBundle.putExtra("stuctmsg_bytes", localAbsShareMsg.getBytes());
          ForwardBaseOption.a(paramActivity, paramBundle, paramInt);
          return;
        }
      }
      catch (Exception paramActivity)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.share", 2, "shareStoryToQQ exception", paramActivity);
        }
        return;
      }
      Object localObject = "";
    }
  }
  
  public static void a(Activity paramActivity, MessageForQQStory paramMessageForQQStory, int paramInt)
  {
    try
    {
      AbsShareMsg localAbsShareMsg = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(80).a(paramMessageForQQStory.brief).e("").a();
      if (paramMessageForQQStory.briefBgColor == 0) {
        paramMessageForQQStory.briefBgColor = Color.parseColor("#d8000000");
      }
      paramMessageForQQStory.briefBgColor &= 0xFFFFFF;
      paramMessageForQQStory.briefBgColor |= 0xD8000000;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("coverImgUrl", paramMessageForQQStory.coverImgUrl);
        localJSONObject.put("logoImgUrl", paramMessageForQQStory.logoImgUrl);
        localJSONObject.put("briefBgColor", paramMessageForQQStory.briefBgColor);
        localJSONObject.put("authorName", paramMessageForQQStory.authorName);
        localJSONObject.put("type", paramMessageForQQStory.type);
        localJSONObject.put("vid", paramMessageForQQStory.mVid);
        localJSONObject.put("headtip", paramMessageForQQStory.mHeadTip);
        localJSONObject.put("storyTitle", paramMessageForQQStory.storyTitle);
        localJSONObject.put("storyBrief", paramMessageForQQStory.storyBrief);
        localAbsShareMsg.mQQStoryExtra = localJSONObject.toString();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      localAbsShareMsg.mCompatibleText = MessageForQQStory.buildCompatibleText(paramMessageForQQStory.authorName, paramMessageForQQStory.brief, paramMessageForQQStory.srcName);
      localAbsShareMsg.mMsgBrief = paramMessageForQQStory.brief;
      localAbsShareMsg.mSourceName = paramMessageForQQStory.srcName;
      localAbsShareMsg.mSourceAction = paramMessageForQQStory.srcAction;
      localAbsShareMsg.mMsgAction = paramMessageForQQStory.msgAction;
      Intent localIntent = new Intent();
      localIntent.putExtra("forward_type", 28);
      localIntent.putExtra("emoInputType", 2);
      localIntent.putExtra("stuctmsg_bytes", localAbsShareMsg.getBytes());
      ForwardBaseOption.a(paramActivity, localIntent, paramInt);
      if (QLog.isColorLevel())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("shareStoryToQQ: ");
        paramActivity.append(paramMessageForQQStory.toString());
        paramActivity.append(", compatibleTxt=");
        paramActivity.append(localAbsShareMsg.mCompatibleText);
        paramActivity.append(", qqstoryExtra=");
        paramActivity.append(localAbsShareMsg.mQQStoryExtra);
        QLog.d("Q.qqstory.share", 2, paramActivity.toString());
        return;
      }
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.share", 2, "shareStoryToQQ exception", paramActivity);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, Intent paramIntent)
  {
    do
    {
      try
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleShareQQStory: resultCode=");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("Q.qqstory.share", 2, ((StringBuilder)localObject).toString());
      }
      catch (Exception paramQQAppInterface)
      {
        Object localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.qqstory.share", 2, "handleShareQQStory exception", paramQQAppInterface);
        return;
      }
      localObject = AIOUtils.a(new Intent(paramActivity, SplashActivity.class), null);
      ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
      ForwardUtils.a(paramQQAppInterface, paramActivity, ForwardUtils.a((Intent)localObject), (Intent)localObject);
      return;
    } while (paramInt == -1);
  }
  
  public static List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = paramContext.getString(2131894171);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839221;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).iconNeedBg = true;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 2;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = paramContext.getString(2131894185);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839222;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).iconNeedBg = true;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 3;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = paramContext.getString(2131894192);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839225;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 9;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = paramContext.getString(2131894174);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839219;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 10;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894163);
    localActionSheetItem.icon = 2130839217;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    if (paramBoolean)
    {
      localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
      localActionSheetItem.label = paramContext.getString(2131914121);
      localActionSheetItem.icon = 2130843501;
      localActionSheetItem.iconNeedBg = true;
      localActionSheetItem.action = 23;
      localActionSheetItem.argus = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    try
    {
      Object localObject = new AbsShareMsg.Builder(StructMsgForGeneralShare.class);
      boolean bool = "action_mqq".equals(paramBundle.getString("jump_action"));
      if (bool)
      {
        localObject = ((AbsShareMsg.Builder)localObject).c(129).a(paramBundle.getString("summary")).a(1104763709L).a();
        ((AbsShareMsg)localObject).mMsgBrief = paramBundle.getString("summary");
        ((AbsShareMsg)localObject).mContentSummary = paramBundle.getString("summary");
        ((AbsShareMsg)localObject).mContentTitle = paramBundle.getString("title");
        ((AbsShareMsg)localObject).mSourceAction = "";
        ((AbsShareMsg)localObject).mContentCover = paramBundle.getString("imageUrl");
        ((AbsShareMsg)localObject).mMsgAction = "plugin";
        ((AbsShareMsg)localObject).mMsg_A_ActionData = paramBundle.getString("action_data");
      }
      else
      {
        localObject = ((AbsShareMsg.Builder)localObject).c(129).a(paramBundle.getString("summary")).e(paramBundle.getString("targetUrl")).a(1104763709L).a();
        ((AbsShareMsg)localObject).mMsgBrief = paramBundle.getString("summary");
        ((AbsShareMsg)localObject).mContentSummary = paramBundle.getString("summary");
        ((AbsShareMsg)localObject).mContentTitle = paramBundle.getString("title");
        ((AbsShareMsg)localObject).mSourceAction = "";
        ((AbsShareMsg)localObject).mMsgUrl = paramBundle.getString("targetUrl");
        ((AbsShareMsg)localObject).mContentCover = paramBundle.getString("imageUrl");
        ((AbsShareMsg)localObject).mMsgAction = "web";
      }
      AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(2);
      String str = paramBundle.getString("summary");
      localAbsStructMsgItem.a(paramBundle.getString("imageUrl"), paramBundle.getString("title"), str);
      ((AbsShareMsg)localObject).addItem(localAbsStructMsgItem);
      paramBundle = new Intent();
      paramBundle.putExtra("forward_type", -3);
      paramBundle.putExtra("emoInputType", 2);
      paramBundle.putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject).getBytes());
      paramBundle.putExtra("structmsg_service_id", ((AbsShareMsg)localObject).mMsgServiceID);
      paramBundle.putExtra("selection_mode", 2);
      paramBundle.putExtra("forwardDirect", true);
      ForwardBaseOption.a(paramActivity, paramBundle, 21, -1);
      return;
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.share", 2, "shareQQGroupVideoToQQ exception", paramActivity);
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, Intent paramIntent)
  {
    do
    {
      try
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleShareQQNow: resultCode=");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("Q.qqstory.share", 2, ((StringBuilder)localObject).toString());
      }
      catch (Exception paramQQAppInterface)
      {
        Object localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.qqstory.share", 2, "handleShareQQNow exception", paramQQAppInterface);
        return;
      }
      localObject = AIOUtils.a(new Intent(paramActivity, SplashActivity.class), null);
      ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
      ForwardUtils.a(paramQQAppInterface, paramActivity, ForwardUtils.a((Intent)localObject), (Intent)localObject);
      return;
    } while (paramInt == -1);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, Intent paramIntent)
  {
    do
    {
      try
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleShareQQGroupVideo: resultCode=");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("Q.qqstory.share", 2, ((StringBuilder)localObject).toString());
      }
      catch (Exception paramQQAppInterface)
      {
        Object localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.qqstory.share", 2, "handleShareQQGroupVideo exception", paramQQAppInterface);
        return;
      }
      localObject = AIOUtils.a(new Intent(paramActivity, SplashActivity.class), null);
      ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
      ForwardUtils.a(paramQQAppInterface, paramActivity, ForwardUtils.a((Intent)localObject), (Intent)localObject);
      return;
    } while (paramInt == -1);
  }
  
  private void g()
  {
    if (this.r) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnClick.chooseLinkType: ");
      localStringBuilder.append(this.b);
      QLog.i("TroopShareUtility", 2, localStringBuilder.toString());
    }
    this.b = 0;
    this.r = true;
    b(true);
    h();
  }
  
  private void h()
  {
    if (this.h == null) {
      return;
    }
    boolean bool2 = TroopInfo.hasPayPrivilege(this.i.mTroopPrivilegeFlag, 128);
    boolean bool1 = false;
    Object localObject;
    if (((!bool2) || (!TroopInfo.hasPayPrivilege(this.i.mTroopPrivilegeFlag, 512))) && (this.i.cGroupOption == 3))
    {
      localObject = this.h;
      QQToast.makeText((Context)localObject, 0, ((QBaseActivity)localObject).getString(2131917537), 0).show(this.h.getTitleBarHeight());
      return;
    }
    if ((!this.i.isOwnerOrAdim()) && (this.i.isMember) && ((this.i.dwGroupFlagExt & 0x80) != 0L))
    {
      localObject = this.h;
      QQToast.makeText((Context)localObject, 0, ((QBaseActivity)localObject).getString(2131895535), 0).show(this.h.getTitleBarHeight());
      return;
    }
    String str;
    if (this.b == 1) {
      str = "0";
    } else {
      str = "1";
    }
    int i1 = this.a;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 4) {
              localObject = "";
            } else {
              localObject = "Copy_grplink";
            }
          }
          else {
            localObject = "Grplink_moments";
          }
        }
        else {
          localObject = "Grplink_wechat";
        }
      }
      else {
        localObject = "Grplink_qzone";
      }
    }
    else {
      localObject = "Grplink_qq";
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.h.getAppRuntime();
    ReportController.b(localQQAppInterface, "CliOper", "", "", "Grp", (String)localObject, 0, 0, str, "", "", "");
    bool2 = NetworkUtil.isNetSupport(BaseApplication.getContext());
    if ((!bool2) && (this.a != 4))
    {
      localObject = this.h;
      QQToast.makeText((Context)localObject, ((QBaseActivity)localObject).getString(2131889169), 0).show(this.h.getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.i("TroopShareUtility", 2, "tryToGetShareLink: net is not supported");
      }
      localObject = this.j;
      if (localObject != null) {
        ((TroopShareUtility.OnShareListener)localObject).a(this.a, false);
      }
      this.a = -1;
      this.b = -1;
      localObject = this.h;
      if ((localObject instanceof TroopCreateLogicActivity)) {
        ((TroopCreateLogicActivity)localObject).finish();
      }
      return;
    }
    if (i() == null)
    {
      if ((!bool2) && (this.a == 4))
      {
        localObject = this.h;
        QQToast.makeText((Context)localObject, ((QBaseActivity)localObject).getString(2131889169), 0).show(this.h.getTitleBarHeight());
        if (QLog.isColorLevel()) {
          QLog.i("TroopShareUtility", 2, "tryToGetShareLink: net is not supported");
        }
        localObject = this.j;
        if (localObject != null) {
          ((TroopShareUtility.OnShareListener)localObject).a(this.a, false);
        }
        this.a = -1;
        this.b = -1;
        localObject = this.h;
        if ((localObject instanceof TroopCreateLogicActivity)) {
          ((TroopCreateLogicActivity)localObject).finish();
        }
        return;
      }
      a();
      if (this.i.isQidianPrivateTroop)
      {
        ((QidianHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).b(this.i.troopUin, this.i.troopowneruin);
        return;
      }
      localObject = (ITroopManagerBizHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MANAGER_BIZ_HANDLER);
      str = this.i.troopUin;
      if (this.b == 0) {
        bool1 = true;
      }
      ((ITroopManagerBizHandler)localObject).d(str, bool1);
      return;
    }
    i1 = this.a;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 4) {
              return;
            }
            n();
            return;
          }
          j();
          return;
        }
        k();
        return;
      }
      l();
      return;
    }
    this.e = ((ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class)).getAvatarAddress("", this.i.troopUin, 0);
    m();
  }
  
  private String i()
  {
    int i1 = this.b;
    if (i1 == -1) {
      return null;
    }
    if (i1 == 0) {
      return this.c;
    }
    return this.d;
  }
  
  private void j()
  {
    if (this.h == null) {
      return;
    }
    this.g = String.valueOf(System.currentTimeMillis());
    QQAppInterface localQQAppInterface = (QQAppInterface)this.h.getAppRuntime();
    Bitmap localBitmap = a(localQQAppInterface.getTroopFaceBitmap(this.i.troopUin, (byte)3, false, false));
    String str = i();
    Object localObject2 = this.i.troopName;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.i.troopUin;
    }
    TroopInfo localTroopInfo = ((TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.i.troopUin);
    localObject2 = localObject1;
    if (localTroopInfo != null)
    {
      localObject2 = localObject1;
      if (!localTroopInfo.hasSetTroopName())
      {
        localObject2 = localObject1;
        if (localTroopInfo.wMemberNum > 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("(");
          ((StringBuilder)localObject2).append(localTroopInfo.wMemberNum);
          ((StringBuilder)localObject2).append(")");
          localObject2 = ((StringBuilder)localObject2).toString();
        }
      }
    }
    localObject1 = this.i.mRichFingerMemo;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131913041));
      ((StringBuilder)localObject1).append(ContactUtils.a(localQQAppInterface, this.i.troopUin, this.i.troopowneruin));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    WXShareHelper.a().a(this);
    WXShareHelper.a().a(this.g, (String)localObject2, localBitmap, (String)localObject1, str);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("shareToFriendCircle.transaction: ");
      ((StringBuilder)localObject1).append(this.g);
      ((StringBuilder)localObject1).append(" troopname:");
      ((StringBuilder)localObject1).append(this.i.troopName);
      ((StringBuilder)localObject1).append(" memo:");
      ((StringBuilder)localObject1).append(this.i.mRichFingerMemo);
      ((StringBuilder)localObject1).append(" shareLink:");
      ((StringBuilder)localObject1).append(str);
      QLog.i("TroopShareUtility", 2, ((StringBuilder)localObject1).toString());
    }
    this.b = -1;
  }
  
  private void k()
  {
    if (this.h == null) {
      return;
    }
    String str1 = String.valueOf(System.currentTimeMillis());
    QQAppInterface localQQAppInterface = (QQAppInterface)this.h.getAppRuntime();
    Object localObject2 = ((TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.i.troopUin);
    Bitmap localBitmap = a(localQQAppInterface.getTroopFaceBitmap(this.i.troopUin, (byte)3, false, false));
    String str2 = i();
    if (this.i.troopName == null) {
      localObject1 = "";
    } else {
      localObject1 = this.i.troopName;
    }
    StringBuffer localStringBuffer = new StringBuffer((String)localObject1);
    if (TextUtils.isEmpty(localStringBuffer)) {
      localStringBuffer.append(this.i.troopUin);
    }
    if ((localObject2 != null) && (!((TroopInfo)localObject2).hasSetTroopName()) && (((TroopInfo)localObject2).wMemberNumClient > 0))
    {
      localStringBuffer.append("(");
      localStringBuffer.append(((TroopInfo)localObject2).wMemberNumClient);
      localStringBuffer.append(")");
    }
    localObject2 = this.i.mRichFingerMemo;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131913037));
      ((StringBuilder)localObject1).append(ContactUtils.a(localQQAppInterface, this.i.troopUin, this.i.troopowneruin));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject1 = a((String)localObject1, this.h);
    WXShareHelper.a().b(str1, localStringBuffer.toString(), localBitmap, (String)localObject1, str2);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("shareToWXFriend.transaction: ");
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append(" troopname:");
      ((StringBuilder)localObject1).append(this.i.troopName);
      ((StringBuilder)localObject1).append(" memo:");
      ((StringBuilder)localObject1).append(this.i.troopIntro);
      ((StringBuilder)localObject1).append(" shareLink:");
      ((StringBuilder)localObject1).append(str2);
      QLog.i("TroopShareUtility", 2, ((StringBuilder)localObject1).toString());
    }
    this.b = -1;
  }
  
  private void l()
  {
    Object localObject1 = this.h;
    if (localObject1 == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)((QBaseActivity)localObject1).getAppRuntime();
    Object localObject3 = ((TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.i.troopUin);
    boolean bool;
    if (localObject3 != null) {
      bool = ((TroopInfo)localObject3).isNewTroop;
    } else {
      bool = false;
    }
    if ((bool) && (this.f == null))
    {
      a(new TroopShareUtility.7(this));
      return;
    }
    String str = i();
    if (bool)
    {
      localObject1 = this.f;
    }
    else
    {
      localObject1 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((ITroopAvatarUtilApi)localObject1).getAvatarAddress("", this.i.troopUin, 0));
      ((StringBuilder)localObject2).append("100");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localArrayList.add(localObject1);
    }
    Object localObject2 = this.i.troopName;
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.i.troopUin;
    }
    localObject2 = localObject1;
    if (localObject3 != null)
    {
      localObject2 = localObject1;
      if (!((TroopInfo)localObject3).hasSetTroopName())
      {
        localObject2 = localObject1;
        if (((TroopInfo)localObject3).wMemberNumClient > 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("(");
          ((StringBuilder)localObject2).append(((TroopInfo)localObject3).wMemberNum);
          ((StringBuilder)localObject2).append(")");
          localObject2 = ((StringBuilder)localObject2).toString();
        }
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(String.format(this.h.getString(2131916573), new Object[] { localObject2 }));
    ((StringBuilder)localObject1).append("(");
    ((StringBuilder)localObject1).append(this.i.troopUin);
    ((StringBuilder)localObject1).append(")");
    ((StringBuilder)localObject1).append(i());
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject3 = new Bundle();
    ((Bundle)localObject3).putString("title", (String)localObject2);
    if (TextUtils.isEmpty(this.i.mRichFingerMemo))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131913040));
      ((StringBuilder)localObject2).append(ContactUtils.a(localQQAppInterface, this.i.troopUin, this.i.troopowneruin));
      ((Bundle)localObject3).putString("desc", ((StringBuilder)localObject2).toString());
    }
    else
    {
      ((Bundle)localObject3).putString("desc", this.i.mRichFingerMemo);
    }
    ((Bundle)localObject3).putLong("req_share_id", 0L);
    ((Bundle)localObject3).putString("detail_url", str);
    ((Bundle)localObject3).putString("url", str);
    ((Bundle)localObject3).putStringArrayList("image_url", localArrayList);
    ((Bundle)localObject3).putString("troop_wording", (String)localObject1);
    ((Bundle)localObject3).putString("bizname", "JoinTroopLink");
    QZoneShareManager.jumpToQzoneShare(localQQAppInterface, this.h, (Bundle)localObject3, null, 145);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("shareToQzone.troopname:");
      ((StringBuilder)localObject1).append(this.i.troopName);
      ((StringBuilder)localObject1).append(" shareLink:");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(" desc:");
      ((StringBuilder)localObject1).append(this.i.mRichFingerMemo);
      QLog.i("TroopShareUtility", 2, ((StringBuilder)localObject1).toString());
    }
    this.a = -1;
    this.b = -1;
  }
  
  private void m()
  {
    Object localObject1 = this.h;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopShareUtility", 2, "shareToMobileQQ mBaseActivity is null");
      }
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)((QBaseActivity)localObject1).getAppRuntime();
    Object localObject4 = ((TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.i.troopUin);
    boolean bool;
    if (localObject4 != null) {
      bool = ((TroopInfo)localObject4).isNewTroop;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("shareToMobileQQ isNewTroop = ");
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(",mNewTroopHeadUrl = ");
      ((StringBuilder)localObject1).append(this.f);
      QLog.d("TroopShareUtility", 2, ((StringBuilder)localObject1).toString());
    }
    if ((bool) && (this.f == null))
    {
      a(new TroopShareUtility.8(this));
      return;
    }
    Object localObject2 = this.i.troopName;
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.i.troopUin;
    }
    Object localObject3 = localObject1;
    if (localObject4 != null)
    {
      localObject3 = localObject1;
      if (!((TroopInfo)localObject4).hasSetTroopName())
      {
        localObject3 = localObject1;
        if (((TroopInfo)localObject4).wMemberNumClient > 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("(");
          ((StringBuilder)localObject2).append(((TroopInfo)localObject4).wMemberNum);
          ((StringBuilder)localObject2).append(")");
          localObject3 = ((StringBuilder)localObject2).toString();
        }
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("group:");
    ((StringBuilder)localObject1).append(this.i.troopUin);
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(15);
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(this.h.getString(2131915625));
    ((StringBuilder)localObject4).append((String)localObject3);
    AbsShareMsg localAbsShareMsg = ((AbsShareMsg.Builder)localObject2).a(((StringBuilder)localObject4).toString()).a("web", i(), (String)localObject1, (String)localObject1, (String)localObject1).a();
    localObject1 = null;
    if ((!bool) && (!TextUtils.isEmpty(this.e)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.e);
      ((StringBuilder)localObject1).append("100");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else if (bool)
    {
      localObject1 = this.f;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("shareToMobileQQ.coverUrl:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("TroopShareUtility", 2, ((StringBuilder)localObject2).toString());
    }
    StructMsgItemLayoutDefault localStructMsgItemLayoutDefault = new StructMsgItemLayoutDefault();
    localStructMsgItemLayoutDefault.c(1);
    localStructMsgItemLayoutDefault.b(this.h.getString(2131893953));
    AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(2);
    localObject4 = this.i.mRichFingerMemo;
    if (TextUtils.isEmpty((CharSequence)localObject4))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131913039));
      ((StringBuilder)localObject2).append(ContactUtils.a(localQQAppInterface, this.i.troopUin, this.i.troopowneruin));
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = localObject4;
      if (((String)localObject4).length() > 40) {
        localObject2 = ((String)localObject4).substring(0, 40);
      }
    }
    localAbsStructMsgItem.a((String)localObject1, (String)localObject3, (String)localObject2, 1);
    localAbsShareMsg.addItem(localStructMsgItemLayoutDefault);
    localAbsShareMsg.addItem(localAbsStructMsgItem);
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("forward_type", -3);
    ((Intent)localObject2).putExtra("stuctmsg_bytes", localAbsShareMsg.getBytes());
    int i1;
    if (this.u) {
      i1 = 21;
    } else {
      i1 = 3;
    }
    ForwardBaseOption.a(this.h, (Intent)localObject2, i1);
    localObject2 = this.h;
    if ((localObject2 instanceof TroopCreateLogicActivity)) {
      ((TroopCreateLogicActivity)localObject2).e = true;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("shareToMobileQQ.mMsgServiceID:");
      ((StringBuilder)localObject2).append(localAbsShareMsg.mMsgServiceID);
      ((StringBuilder)localObject2).append(" mMsgBrief:");
      ((StringBuilder)localObject2).append(localAbsShareMsg.mMsgBrief);
      ((StringBuilder)localObject2).append(" mContentTitle:");
      ((StringBuilder)localObject2).append(localAbsShareMsg.mContentTitle);
      ((StringBuilder)localObject2).append(" mContentSummary:");
      ((StringBuilder)localObject2).append(localAbsShareMsg.mContentSummary);
      ((StringBuilder)localObject2).append(" mMsgUrl:");
      ((StringBuilder)localObject2).append(localAbsShareMsg.mMsgUrl);
      ((StringBuilder)localObject2).append(" coverUrl:");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" mSourceName:");
      ((StringBuilder)localObject2).append(localAbsShareMsg.mSourceName);
      QLog.i("TroopShareUtility", 2, ((StringBuilder)localObject2).toString());
    }
    this.a = -1;
    this.b = -1;
  }
  
  @TargetApi(11)
  private void n()
  {
    if (this.h == null) {
      return;
    }
    Object localObject2 = this.i.troopName;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.i.troopUin;
    }
    localObject1 = String.format(this.h.getString(2131891065), new Object[] { localObject1, i() });
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("copyTroopLink.text:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("TroopShareUtility", 2, ((StringBuilder)localObject2).toString());
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      ((android.text.ClipboardManager)this.h.getSystemService("clipboard")).setText((CharSequence)localObject1);
    }
    else
    {
      localObject2 = (android.content.ClipboardManager)this.h.getSystemService("clipboard");
      localObject1 = ClipData.newPlainText("troop_url", (CharSequence)localObject1);
      ClipboardMonitor.setPrimaryClip((android.content.ClipboardManager)localObject2, (ClipData)localObject1);
      ((android.content.ClipboardManager)localObject2).setPrimaryClip((ClipData)localObject1);
    }
    localObject1 = this.h;
    QQToast.makeText((Context)localObject1, 2, ((QBaseActivity)localObject1).getString(2131888249), 0).show(this.h.getTitleBarHeight());
    localObject1 = this.j;
    if (localObject1 != null) {
      ((TroopShareUtility.OnShareListener)localObject1).a(this.a, true);
    }
    this.a = -1;
    this.b = -1;
  }
  
  public void a()
  {
    try
    {
      if ((this.l == null) && (this.h != null))
      {
        this.l = new QQProgressDialog(this.h, this.h.getTitleBarHeight());
        this.l.c(2131892360);
        this.l.c(false);
      }
      if (this.l != null)
      {
        this.l.show();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopShareUtility", 2, localException.toString());
      }
    }
  }
  
  public void a(TroopInfoData paramTroopInfoData)
  {
    QBaseActivity localQBaseActivity = this.h;
    if (localQBaseActivity == null) {
      return;
    }
    ReportController.b((QQAppInterface)localQBaseActivity.getAppRuntime(), "CliOper", "", "", "Grp", "Clk_share_grplink", 0, 0, "", "", "", "");
    this.i = paramTroopInfoData;
    d();
  }
  
  public void a(TroopShareUtility.UploadHeaderCallback paramUploadHeaderCallback)
  {
    ThreadManager.post(new TroopShareUtility.10(this, paramUploadHeaderCallback), 8, null, false);
  }
  
  public void a(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public void b()
  {
    try
    {
      if ((this.l != null) && (this.l.isShowing()))
      {
        this.l.dismiss();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopShareUtility", 2, localException.toString());
      }
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    int i1 = this.a;
    Object localObject;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            localObject = null;
          } else {
            localObject = "share_circle";
          }
        }
        else {
          localObject = "share_wechat";
        }
      }
      else {
        localObject = "share_qzone";
      }
    }
    else {
      localObject = "share_qq";
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      boolean bool = this.i.bOwner;
      String str2 = "1";
      String str1;
      if (bool) {
        str1 = "0";
      } else if (this.i.bAdmin) {
        str1 = "1";
      } else {
        str1 = "2";
      }
      ReportTask localReportTask = new ReportTask(null).a("P_CliOper").b("Grp_set").c("Grp_data").d((String)localObject);
      String str3 = this.i.troopUin;
      localObject = str2;
      if (paramBoolean) {
        localObject = "0";
      }
      localReportTask.a(new String[] { str3, localObject, str1 }).a();
    }
  }
  
  public void c()
  {
    this.b = 0;
    h();
  }
  
  protected void d()
  {
    Object localObject1 = new ArrayList();
    int i1;
    if (this.i.isMember) {
      i1 = 5;
    } else {
      i1 = 4;
    }
    int i2 = 0;
    while (i2 <= i1)
    {
      ((List)localObject1).add(ActionSheetAdapter.a(i2));
      i2 += 1;
    }
    if (this.m == null)
    {
      localObject2 = this.h;
      if (localObject2 != null) {
        this.m = new ActionSheetAdapter((Context)localObject2);
      }
    }
    Object localObject2 = this.m;
    if (localObject2 != null) {
      ((ActionSheetAdapter)localObject2).a((List)localObject1);
    }
    if (this.n == null)
    {
      localObject1 = new TroopShareUtility.1(this);
      if (this.o == null)
      {
        this.o = new ShareActionSheetBuilder(this.h);
        this.o.setActionSheetTitle(this.h.getString(2131916565));
        this.o.setActionSheetItems(a(this.h, this.i.isMember));
        this.o.setOnDismissListener(new TroopShareUtility.2(this));
        this.o.setItemClickListener((AdapterView.OnItemClickListener)localObject1);
      }
      try
      {
        this.o.show();
        this.o.i.setVisibility(8);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("actionSheet.show exception=");
          ((StringBuilder)localObject2).append(localException);
          QLog.d("ShareActionSheet", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
  }
  
  public void e()
  {
    this.j = null;
    this.h.removeObserver(this.t);
    this.h.removeObserver(this.s);
    this.h = null;
    this.i = null;
  }
  
  public void f()
  {
    Object localObject = this.h;
    if (localObject == null) {
      return;
    }
    TroopInfoData localTroopInfoData = this.i;
    localObject = new Intent((Context)localObject, QRDisplayActivity.class);
    ((Intent)localObject).putExtra("title", HardCodeUtil.a(2131913036));
    if (TextUtils.isEmpty(localTroopInfoData.troopName)) {
      ((Intent)localObject).putExtra("nick", localTroopInfoData.newTroopName);
    } else {
      ((Intent)localObject).putExtra("nick", localTroopInfoData.troopName);
    }
    ((Intent)localObject).putExtra("uin", localTroopInfoData.troopUin);
    int i1;
    if (localTroopInfoData.bOwner) {
      i1 = 0;
    } else if (localTroopInfoData.bAdmin) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    ((Intent)localObject).putExtra("adminLevel", i1);
    ((Intent)localObject).putExtra("type", 2);
    ((Intent)localObject).putExtra("GroupFlagExt", localTroopInfoData.dwGroupFlagExt);
    ((Intent)localObject).putExtra("AuthGroupType", localTroopInfoData.dwAuthGroupType);
    QQAppInterface localQQAppInterface = (QQAppInterface)this.h.getAppRuntime();
    boolean bool = ((TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).Z(this.i.troopUin);
    ((Intent)localObject).putExtra("isQidianPrivateTroop", bool);
    if (bool) {
      ((Intent)localObject).putExtra("groupOwner", this.i.troopowneruin);
    }
    ThreadManager.post(new TroopShareUtility.9(this, localQQAppInterface, localTroopInfoData, (Intent)localObject), 8, null, true);
  }
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    Object localObject = this.g;
    if ((localObject != null) && (((String)localObject).equals(paramBaseResp.transaction)))
    {
      if (this.h == null) {
        return;
      }
      localObject = this.j;
      if (localObject != null)
      {
        i1 = this.a;
        boolean bool;
        if (paramBaseResp.errCode == 0) {
          bool = true;
        } else {
          bool = false;
        }
        ((TroopShareUtility.OnShareListener)localObject).a(i1, bool);
      }
      this.a = -1;
      int i1 = paramBaseResp.errCode;
      if (i1 != -2) {
        if (i1 != 0)
        {
          paramBaseResp = this.h;
          QQToast.makeText(paramBaseResp, 1, paramBaseResp.getString(2131916544), 0).show(this.h.getTitleBarHeight());
        }
        else
        {
          paramBaseResp = this.h;
          QQToast.makeText(paramBaseResp, 2, paramBaseResp.getString(2131916563), 0).show(this.h.getTitleBarHeight());
        }
      }
      WXShareHelper.a().b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility
 * JD-Core Version:    0.7.0.1
 */