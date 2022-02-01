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
  protected int a;
  protected QBaseActivity a;
  protected TroopInfoData a;
  protected TroopManagerBizObserver a;
  protected TroopShareUtility.OnShareListener a;
  protected ShareActionSheetBuilder a;
  protected QQProgressDialog a;
  QidianBusinessObserver jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new TroopShareUtility.6(this);
  protected ActionSheet a;
  protected ActionSheetAdapter a;
  protected String a;
  boolean jdField_a_of_type_Boolean = false;
  protected int b;
  protected ActionSheet b;
  protected String b;
  protected boolean b;
  protected String c;
  protected boolean c;
  protected String d;
  private boolean d;
  protected String e;
  
  public TroopShareUtility(QBaseActivity paramQBaseActivity, TroopInfoData paramTroopInfoData)
  {
    this(paramQBaseActivity, paramTroopInfoData, null);
  }
  
  public TroopShareUtility(QBaseActivity paramQBaseActivity, TroopInfoData paramTroopInfoData, TroopShareUtility.OnShareListener paramOnShareListener)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter = null;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiTroopManagerBizObserver = new TroopShareUtility.5(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData = paramTroopInfoData;
    paramQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if (paramQBaseActivity != null)
    {
      paramQBaseActivity.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiTroopManagerBizObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener = paramOnShareListener;
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
    int m = ((BitMatrix)localObject).a();
    paramString = new int[m * m];
    int i = 0;
    while (i < m)
    {
      int j = 0;
      while (j < m)
      {
        int k;
        if (((BitMatrix)localObject).a(j, i)) {
          k = -16777216;
        } else {
          k = 16777215;
        }
        paramString[(i * m + j)] = k;
        j += 1;
      }
      i += 1;
    }
    localObject = Bitmap.createBitmap(m, m, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject).setPixels(paramString, 0, m, 0, 0, m, m);
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
      float f = paramInt1;
      localCanvas.drawRect(0.0F, 0.0F, f, f, localPaint);
      i = paramInt1 - paramInt2;
      localCanvas.drawBitmap((Bitmap)localObject, null, new Rect(paramInt2, paramInt2, i, i), null);
      if (paramBoolean)
      {
        paramInt1 = (paramInt1 - 106) / 2;
        localPaint = new Paint();
        localPaint.setAntiAlias(true);
        paramInt2 = paramInt1 + 106;
        Rect localRect = new Rect(paramInt1, paramInt1, paramInt2, paramInt2);
        paramResources = BitmapManager.a(paramResources, 2130839669);
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
  
  private String a()
  {
    int i = this.jdField_b_of_type_Int;
    if (i == -1) {
      return null;
    }
    if (i == 0) {
      return this.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public static String a(String paramString, Context paramContext)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = paramContext.getString(2131719042);
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
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = paramContext.getString(2131696399);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839067;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).iconNeedBg = true;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 2;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = paramContext.getString(2131696413);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839068;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).iconNeedBg = true;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 3;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = paramContext.getString(2131696420);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839071;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 9;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = paramContext.getString(2131696402);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839065;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 10;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696391);
    localActionSheetItem.icon = 2130839063;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    if (paramBoolean)
    {
      localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
      localActionSheetItem.label = paramContext.getString(2131716658);
      localActionSheetItem.icon = 2130842548;
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
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnClick.chooseLinkType: ");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      QLog.i("TroopShareUtility", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    b(true);
    h();
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity == null) {
      return;
    }
    boolean bool2 = TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopPrivilegeFlag, 128);
    boolean bool1 = false;
    Object localObject;
    if (((!bool2) || (!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopPrivilegeFlag, 512))) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption == 3))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      QQToast.a((Context)localObject, 0, ((QBaseActivity)localObject).getString(2131719932), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
      return;
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim()) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember) && ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupFlagExt & 0x80) != 0L))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      QQToast.a((Context)localObject, 0, ((QBaseActivity)localObject).getString(2131697762), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
      return;
    }
    String str;
    if (this.jdField_b_of_type_Int == 1) {
      str = "0";
    } else {
      str = "1";
    }
    int i = this.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
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
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
    ReportController.b(localQQAppInterface, "CliOper", "", "", "Grp", (String)localObject, 0, 0, str, "", "", "");
    bool2 = NetworkUtil.isNetSupport(BaseApplication.getContext());
    if ((!bool2) && (this.jdField_a_of_type_Int != 4))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      QQToast.a((Context)localObject, ((QBaseActivity)localObject).getString(2131692183), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.i("TroopShareUtility", 2, "tryToGetShareLink: net is not supported");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener;
      if (localObject != null) {
        ((TroopShareUtility.OnShareListener)localObject).a(this.jdField_a_of_type_Int, false);
      }
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      if ((localObject instanceof TroopCreateLogicActivity)) {
        ((TroopCreateLogicActivity)localObject).finish();
      }
      return;
    }
    if (a() == null)
    {
      if ((!bool2) && (this.jdField_a_of_type_Int == 4))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
        QQToast.a((Context)localObject, ((QBaseActivity)localObject).getString(2131692183), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
        if (QLog.isColorLevel()) {
          QLog.i("TroopShareUtility", 2, "tryToGetShareLink: net is not supported");
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener;
        if (localObject != null) {
          ((TroopShareUtility.OnShareListener)localObject).a(this.jdField_a_of_type_Int, false);
        }
        this.jdField_a_of_type_Int = -1;
        this.jdField_b_of_type_Int = -1;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
        if ((localObject instanceof TroopCreateLogicActivity)) {
          ((TroopCreateLogicActivity)localObject).finish();
        }
        return;
      }
      a();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isQidianPrivateTroop)
      {
        ((QidianHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).b(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin);
        return;
      }
      localObject = (ITroopManagerBizHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MANAGER_BIZ_HANDLER);
      str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
      if (this.jdField_b_of_type_Int == 0) {
        bool1 = true;
      }
      ((ITroopManagerBizHandler)localObject).d(str, bool1);
      return;
    }
    i = this.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return;
            }
            m();
            return;
          }
          i();
          return;
        }
        j();
        return;
      }
      k();
      return;
    }
    this.jdField_c_of_type_JavaLangString = ((ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class)).getAvatarAddress("", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 0);
    l();
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity == null) {
      return;
    }
    this.e = String.valueOf(System.currentTimeMillis());
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
    Bitmap localBitmap = a(localQQAppInterface.getTroopFaceBitmap(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, (byte)3, false, false));
    String str = a();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
    }
    TroopInfo localTroopInfo = ((TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
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
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131715569));
      ((StringBuilder)localObject1).append(ContactUtils.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    WXShareHelper.a().a(this);
    WXShareHelper.a().a(this.e, (String)localObject2, localBitmap, (String)localObject1, str);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("shareToFriendCircle.transaction: ");
      ((StringBuilder)localObject1).append(this.e);
      ((StringBuilder)localObject1).append(" troopname:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName);
      ((StringBuilder)localObject1).append(" memo:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo);
      ((StringBuilder)localObject1).append(" shareLink:");
      ((StringBuilder)localObject1).append(str);
      QLog.i("TroopShareUtility", 2, ((StringBuilder)localObject1).toString());
    }
    this.jdField_b_of_type_Int = -1;
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity == null) {
      return;
    }
    String str1 = String.valueOf(System.currentTimeMillis());
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
    Object localObject2 = ((TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    Bitmap localBitmap = a(localQQAppInterface.getTroopFaceBitmap(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, (byte)3, false, false));
    String str2 = a();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName == null) {
      localObject1 = "";
    } else {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName;
    }
    StringBuffer localStringBuffer = new StringBuffer((String)localObject1);
    if (TextUtils.isEmpty(localStringBuffer)) {
      localStringBuffer.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    }
    if ((localObject2 != null) && (!((TroopInfo)localObject2).hasSetTroopName()) && (((TroopInfo)localObject2).wMemberNumClient > 0))
    {
      localStringBuffer.append("(");
      localStringBuffer.append(((TroopInfo)localObject2).wMemberNumClient);
      localStringBuffer.append(")");
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131715565));
      ((StringBuilder)localObject1).append(ContactUtils.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject1 = a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    WXShareHelper.a().b(str1, localStringBuffer.toString(), localBitmap, (String)localObject1, str2);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("shareToWXFriend.transaction: ");
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append(" troopname:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName);
      ((StringBuilder)localObject1).append(" memo:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopIntro);
      ((StringBuilder)localObject1).append(" shareLink:");
      ((StringBuilder)localObject1).append(str2);
      QLog.i("TroopShareUtility", 2, ((StringBuilder)localObject1).toString());
    }
    this.jdField_b_of_type_Int = -1;
  }
  
  private void k()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if (localObject1 == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)((QBaseActivity)localObject1).getAppRuntime();
    Object localObject3 = ((TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    boolean bool;
    if (localObject3 != null) {
      bool = ((TroopInfo)localObject3).isNewTroop;
    } else {
      bool = false;
    }
    if ((bool) && (this.jdField_d_of_type_JavaLangString == null))
    {
      a(new TroopShareUtility.7(this));
      return;
    }
    String str = a();
    if (bool)
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
    }
    else
    {
      localObject1 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((ITroopAvatarUtilApi)localObject1).getAvatarAddress("", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 0));
      ((StringBuilder)localObject2).append("100");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localArrayList.add(localObject1);
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName;
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
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
    ((StringBuilder)localObject1).append(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131719037), new Object[] { localObject2 }));
    ((StringBuilder)localObject1).append("(");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    ((StringBuilder)localObject1).append(")");
    ((StringBuilder)localObject1).append(a());
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject3 = new Bundle();
    ((Bundle)localObject3).putString("title", (String)localObject2);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131715568));
      ((StringBuilder)localObject2).append(ContactUtils.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin));
      ((Bundle)localObject3).putString("desc", ((StringBuilder)localObject2).toString());
    }
    else
    {
      ((Bundle)localObject3).putString("desc", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo);
    }
    ((Bundle)localObject3).putLong("req_share_id", 0L);
    ((Bundle)localObject3).putString("detail_url", str);
    ((Bundle)localObject3).putString("url", str);
    ((Bundle)localObject3).putStringArrayList("image_url", localArrayList);
    ((Bundle)localObject3).putString("troop_wording", (String)localObject1);
    ((Bundle)localObject3).putString("bizname", "JoinTroopLink");
    QZoneShareManager.jumpToQzoneShare(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, (Bundle)localObject3, null, 145);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("shareToQzone.troopname:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName);
      ((StringBuilder)localObject1).append(" shareLink:");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(" desc:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo);
      QLog.i("TroopShareUtility", 2, ((StringBuilder)localObject1).toString());
    }
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
  }
  
  private void l()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopShareUtility", 2, "shareToMobileQQ mBaseActivity is null");
      }
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)((QBaseActivity)localObject1).getAppRuntime();
    Object localObject4 = ((TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
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
      ((StringBuilder)localObject1).append(this.jdField_d_of_type_JavaLangString);
      QLog.d("TroopShareUtility", 2, ((StringBuilder)localObject1).toString());
    }
    if ((bool) && (this.jdField_d_of_type_JavaLangString == null))
    {
      a(new TroopShareUtility.8(this));
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName;
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
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
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(15);
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131718147));
    ((StringBuilder)localObject4).append((String)localObject3);
    AbsShareMsg localAbsShareMsg = ((AbsShareMsg.Builder)localObject2).a(((StringBuilder)localObject4).toString()).a("web", a(), (String)localObject1, (String)localObject1, (String)localObject1).a();
    localObject1 = null;
    if ((!bool) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("100");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else if (bool)
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("shareToMobileQQ.coverUrl:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("TroopShareUtility", 2, ((StringBuilder)localObject2).toString());
    }
    StructMsgItemLayoutDefault localStructMsgItemLayoutDefault = new StructMsgItemLayoutDefault();
    localStructMsgItemLayoutDefault.b(1);
    localStructMsgItemLayoutDefault.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131696187));
    AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(2);
    localObject4 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo;
    if (TextUtils.isEmpty((CharSequence)localObject4))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131715567));
      ((StringBuilder)localObject2).append(ContactUtils.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin));
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
    int i;
    if (this.jdField_d_of_type_Boolean) {
      i = 21;
    } else {
      i = 3;
    }
    ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, (Intent)localObject2, i);
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if ((localObject2 instanceof TroopCreateLogicActivity)) {
      ((TroopCreateLogicActivity)localObject2).jdField_a_of_type_Boolean = true;
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
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
  }
  
  @TargetApi(11)
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity == null) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
    }
    localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131693511), new Object[] { localObject1, a() });
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("copyTroopLink.text:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("TroopShareUtility", 2, ((StringBuilder)localObject2).toString());
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      ((android.text.ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getSystemService("clipboard")).setText((CharSequence)localObject1);
    }
    else
    {
      localObject2 = (android.content.ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getSystemService("clipboard");
      localObject1 = ClipData.newPlainText("troop_url", (CharSequence)localObject1);
      ClipboardMonitor.setPrimaryClip((android.content.ClipboardManager)localObject2, (ClipData)localObject1);
      ((android.content.ClipboardManager)localObject2).setPrimaryClip((ClipData)localObject1);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    QQToast.a((Context)localObject1, 2, ((QBaseActivity)localObject1).getString(2131691298), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener;
    if (localObject1 != null) {
      ((TroopShareUtility.OnShareListener)localObject1).a(this.jdField_a_of_type_Int, true);
    }
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
  }
  
  public void a()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) && (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694668);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
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
    QBaseActivity localQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if (localQBaseActivity == null) {
      return;
    }
    ReportController.b((QQAppInterface)localQBaseActivity.getAppRuntime(), "CliOper", "", "", "Grp", "Clk_share_grplink", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData = paramTroopInfoData;
    d();
  }
  
  public void a(TroopShareUtility.UploadHeaderCallback paramUploadHeaderCallback)
  {
    ThreadManager.post(new TroopShareUtility.10(this, paramUploadHeaderCallback), 8, null, false);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
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
    int i = this.jdField_a_of_type_Int;
    Object localObject;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
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
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner;
      String str2 = "1";
      String str1;
      if (bool) {
        str1 = "0";
      } else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bAdmin) {
        str1 = "1";
      } else {
        str1 = "2";
      }
      ReportTask localReportTask = new ReportTask(null).a("P_CliOper").b("Grp_set").c("Grp_data").d((String)localObject);
      String str3 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
      localObject = str2;
      if (paramBoolean) {
        localObject = "0";
      }
      localReportTask.a(new String[] { str3, localObject, str1 }).a();
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Int = 0;
    h();
  }
  
  protected void d()
  {
    Object localObject1 = new ArrayList();
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember) {
      i = 5;
    } else {
      i = 4;
    }
    int j = 0;
    while (j <= i)
    {
      ((List)localObject1).add(ActionSheetAdapter.a(j));
      j += 1;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter == null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      if (localObject2 != null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter = new ActionSheetAdapter((Context)localObject2);
      }
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter;
    if (localObject2 != null) {
      ((ActionSheetAdapter)localObject2).a((List)localObject1);
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      localObject1 = new TroopShareUtility.1(this);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131719029));
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember));
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setOnDismissListener(new TroopShareUtility.2(this));
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener((AdapterView.OnItemClickListener)localObject1);
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.b.setVisibility(8);
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
    this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiTroopManagerBizObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData = null;
  }
  
  public void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if (localObject == null) {
      return;
    }
    TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    localObject = new Intent((Context)localObject, QRDisplayActivity.class);
    ((Intent)localObject).putExtra("title", HardCodeUtil.a(2131715564));
    if (TextUtils.isEmpty(localTroopInfoData.troopName)) {
      ((Intent)localObject).putExtra("nick", localTroopInfoData.newTroopName);
    } else {
      ((Intent)localObject).putExtra("nick", localTroopInfoData.troopName);
    }
    ((Intent)localObject).putExtra("uin", localTroopInfoData.troopUin);
    int i;
    if (localTroopInfoData.bOwner) {
      i = 0;
    } else if (localTroopInfoData.bAdmin) {
      i = 1;
    } else {
      i = 2;
    }
    ((Intent)localObject).putExtra("adminLevel", i);
    ((Intent)localObject).putExtra("type", 2);
    ((Intent)localObject).putExtra("GroupFlagExt", localTroopInfoData.dwGroupFlagExt);
    ((Intent)localObject).putExtra("AuthGroupType", localTroopInfoData.dwAuthGroupType);
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
    boolean bool = ((TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).m(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    ((Intent)localObject).putExtra("isQidianPrivateTroop", bool);
    if (bool) {
      ((Intent)localObject).putExtra("groupOwner", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin);
    }
    ThreadManager.post(new TroopShareUtility.9(this, localQQAppInterface, localTroopInfoData, (Intent)localObject), 8, null, true);
  }
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    Object localObject = this.e;
    if ((localObject != null) && (((String)localObject).equals(paramBaseResp.transaction)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity == null) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener;
      if (localObject != null)
      {
        i = this.jdField_a_of_type_Int;
        boolean bool;
        if (paramBaseResp.errCode == 0) {
          bool = true;
        } else {
          bool = false;
        }
        ((TroopShareUtility.OnShareListener)localObject).a(i, bool);
      }
      this.jdField_a_of_type_Int = -1;
      int i = paramBaseResp.errCode;
      if (i != -2) {
        if (i != 0)
        {
          paramBaseResp = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
          QQToast.a(paramBaseResp, 1, paramBaseResp.getString(2131719009), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
        }
        else
        {
          paramBaseResp = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
          QQToast.a(paramBaseResp, 2, paramBaseResp.getString(2131719027), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
        }
      }
      WXShareHelper.a().b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility
 * JD-Core Version:    0.7.0.1
 */