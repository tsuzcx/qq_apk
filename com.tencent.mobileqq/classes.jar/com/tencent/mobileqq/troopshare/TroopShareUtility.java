package com.tencent.mobileqq.troopshare;

import ajxi;
import ajxj;
import ajxk;
import ajxl;
import ajxm;
import ajxn;
import ajxo;
import ajxp;
import ajxq;
import ajxs;
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
import com.google.zxing.common.BitMatrix;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetAdapter;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class TroopShareUtility
  implements WXShareHelper.WXShareListener
{
  public int a;
  public BaseActivity a;
  protected TroopObserver a;
  public TroopInfoData a;
  public TroopShareUtility.OnShareListener a;
  public ShareActionSheetBuilder a;
  public QQProgressDialog a;
  protected ActionSheet a;
  protected ActionSheetAdapter a;
  public String a;
  public boolean a;
  public int b;
  public ActionSheet b;
  public String b;
  public boolean b;
  public String c;
  public String d;
  protected String e;
  
  public TroopShareUtility(BaseActivity paramBaseActivity, TroopInfoData paramTroopInfoData)
  {
    this(paramBaseActivity, paramTroopInfoData, null);
  }
  
  public TroopShareUtility(BaseActivity paramBaseActivity, TroopInfoData paramTroopInfoData, TroopShareUtility.OnShareListener paramOnShareListener)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new ajxm(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = paramTroopInfoData;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    WXShareHelper.a().a(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener = paramOnShareListener;
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = null;
    if (paramBitmap != null)
    {
      localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawColor(-1);
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint());
    }
    return localBitmap;
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
      if (j < m)
      {
        if (((BitMatrix)localObject).a(j, i)) {}
        for (int k = -16777216;; k = 16777215)
        {
          paramString[(i * m + j)] = k;
          j += 1;
          break;
        }
      }
      i += 1;
    }
    localObject = Bitmap.createBitmap(m, m, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject).setPixels(paramString, 0, m, 0, 0, m, m);
    try
    {
      paramString = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.ARGB_8888);
      if (paramString == null)
      {
        ((Bitmap)localObject).recycle();
        return null;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        System.gc();
        try
        {
          paramString = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.ARGB_8888);
        }
        catch (OutOfMemoryError paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TroopShareUtility", 2, paramString.getMessage());
          }
          return null;
        }
      }
      Canvas localCanvas = new Canvas(paramString);
      Paint localPaint = new Paint();
      localPaint.setShader(new LinearGradient(0.0F, 0.0F, 0.0F, 600.0F, -657931, -1513240, Shader.TileMode.REPEAT));
      localCanvas.drawRect(0.0F, 0.0F, paramInt1, paramInt1, localPaint);
      localCanvas.drawBitmap((Bitmap)localObject, null, new Rect(paramInt2, paramInt2, paramInt1 - paramInt2, paramInt1 - paramInt2), null);
      if (paramBoolean)
      {
        paramInt1 = (paramInt1 - 106) / 2;
        localPaint = new Paint();
        localPaint.setAntiAlias(true);
        Rect localRect = new Rect(paramInt1, paramInt1, paramInt1 + 106, 106 + paramInt1);
        paramResources = BitmapManager.a(paramResources, 2130838916);
        if (paramResources != null)
        {
          localCanvas.drawBitmap(paramResources, null, localRect, localPaint);
          paramResources.recycle();
        }
      }
      ((Bitmap)localObject).recycle();
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("TroopShareUtility", 2, "getQrCode cost time:" + (l2 - l1));
      }
    }
    return paramString;
  }
  
  private String a()
  {
    if (this.jdField_b_of_type_Int == -1) {
      return null;
    }
    if (this.jdField_b_of_type_Int == 0) {
      return this.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435325);
    }
    return str;
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    try
    {
      localAbsShareMsg = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(1).a(paramBundle.getString("summary")).c(paramBundle.getString("targetUrl")).a(1105290942L).a();
      localAbsShareMsg.mMsgBrief = paramBundle.getString("summary");
      localAbsShareMsg.mContentSummary = paramBundle.getString("summary");
      localAbsShareMsg.mContentTitle = paramBundle.getString("title");
      localObject = paramBundle.getString("sourcename");
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
      for (localAbsShareMsg.mSourceName = "NOW";; localAbsShareMsg.mSourceName = "")
      {
        localAbsShareMsg.mSourceAction = "";
        localAbsShareMsg.mMsgUrl = paramBundle.getString("targetUrl");
        localAbsShareMsg.mContentCover = paramBundle.getString("imageUrl");
        if (!TextUtils.isEmpty(paramBundle.getString("msgActionData")))
        {
          localAbsShareMsg.mMsgActionData = paramBundle.getString("msgActionData");
          localAbsShareMsg.mMsgAction = "plugin";
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
        if (!((String)localObject).equals("null")) {
          break;
        }
      }
    }
    catch (Exception paramActivity)
    {
      AbsShareMsg localAbsShareMsg;
      Object localObject;
      while (QLog.isColorLevel())
      {
        QLog.e("Q.qqstory.share", 2, "shareStoryToQQ exception", paramActivity);
        return;
        localAbsShareMsg.mSourceName = ((String)localObject);
      }
    }
  }
  
  public static void a(Activity paramActivity, MessageForQQStory paramMessageForQQStory, int paramInt)
  {
    try
    {
      AbsShareMsg localAbsShareMsg = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(80).a(paramMessageForQQStory.brief).c("").a();
      if (paramMessageForQQStory.briefBgColor == 0) {
        paramMessageForQQStory.briefBgColor = Color.parseColor("#d8000000");
      }
      paramMessageForQQStory.briefBgColor &= 0xFFFFFF;
      paramMessageForQQStory.briefBgColor |= 0xD8000000;
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("coverImgUrl", paramMessageForQQStory.coverImgUrl);
        ((JSONObject)localObject).put("logoImgUrl", paramMessageForQQStory.logoImgUrl);
        ((JSONObject)localObject).put("briefBgColor", paramMessageForQQStory.briefBgColor);
        ((JSONObject)localObject).put("authorName", paramMessageForQQStory.authorName);
        ((JSONObject)localObject).put("type", paramMessageForQQStory.type);
        ((JSONObject)localObject).put("vid", paramMessageForQQStory.mVid);
        ((JSONObject)localObject).put("headtip", paramMessageForQQStory.mHeadTip);
        localAbsShareMsg.mQQStoryExtra = ((JSONObject)localObject).toString();
        localAbsShareMsg.mCompatibleText = MessageForQQStory.buildCompatibleText(paramMessageForQQStory.authorName, paramMessageForQQStory.brief, paramMessageForQQStory.srcName);
        localAbsShareMsg.mMsgBrief = paramMessageForQQStory.brief;
        localAbsShareMsg.mSourceName = paramMessageForQQStory.srcName;
        localAbsShareMsg.mSourceAction = paramMessageForQQStory.srcAction;
        localAbsShareMsg.mMsgAction = paramMessageForQQStory.msgAction;
        localObject = new Intent();
        ((Intent)localObject).putExtra("forward_type", 28);
        ((Intent)localObject).putExtra("emoInputType", 2);
        ((Intent)localObject).putExtra("stuctmsg_bytes", localAbsShareMsg.getBytes());
        ForwardBaseOption.a(paramActivity, (Intent)localObject, paramInt);
        if (QLog.isColorLevel())
        {
          QLog.d("Q.qqstory.share", 2, "shareStoryToQQ: " + paramMessageForQQStory.toString() + ", compatibleTxt=" + localAbsShareMsg.mCompatibleText + ", qqstoryExtra=" + localAbsShareMsg.mQQStoryExtra);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      return;
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
    try
    {
      if (!QLog.isColorLevel()) {
        break label102;
      }
      QLog.d("Q.qqstory.share", 2, "handleShareQQStory: resultCode=" + paramInt);
    }
    catch (Exception paramQQAppInterface)
    {
      label102:
      do
      {
        Intent localIntent;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.qqstory.share", 2, "handleShareQQStory exception", paramQQAppInterface);
        return;
      } while (paramInt == -1);
    }
    localIntent = AIOUtils.a(new Intent(paramActivity, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    ForwardUtils.a(paramQQAppInterface, paramActivity, ForwardUtils.a(localIntent), localIntent);
    return;
  }
  
  public static List[] a(Context paramContext, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = paramContext.getString(2131430108);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).jdField_b_of_type_Int = 2130838336;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).c = 2;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = paramContext.getString(2131430114);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).jdField_b_of_type_Int = 2130838337;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).c = 3;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = paramContext.getString(2131430126);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).jdField_b_of_type_Int = 2130838340;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).c = 9;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = paramContext.getString(2131430127);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).jdField_b_of_type_Int = 2130838334;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).c = 10;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430110);
    localActionSheetItem.jdField_b_of_type_Int = 2130838332;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.c = 1;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    if (paramBoolean)
    {
      localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131429999);
      localActionSheetItem.jdField_b_of_type_Int = 2130840508;
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.c = 23;
      localActionSheetItem.jdField_b_of_type_JavaLangString = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    try
    {
      AbsShareMsg localAbsShareMsg = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(1).a(paramBundle.getString("summary")).c(paramBundle.getString("targetUrl")).a(1104763709L).a();
      localAbsShareMsg.mMsgBrief = paramBundle.getString("summary");
      localAbsShareMsg.mContentSummary = paramBundle.getString("summary");
      localAbsShareMsg.mContentTitle = paramBundle.getString("title");
      localAbsShareMsg.mSourceAction = "";
      localAbsShareMsg.mMsgUrl = paramBundle.getString("targetUrl");
      localAbsShareMsg.mContentCover = paramBundle.getString("imageUrl");
      localAbsShareMsg.mMsgAction = "web";
      AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(2);
      String str = paramBundle.getString("summary");
      localAbsStructMsgItem.a(paramBundle.getString("imageUrl"), paramBundle.getString("title"), str);
      localAbsShareMsg.addItem(localAbsStructMsgItem);
      paramBundle = new Intent();
      paramBundle.putExtra("forward_type", -3);
      paramBundle.putExtra("emoInputType", 2);
      paramBundle.putExtra("stuctmsg_bytes", localAbsShareMsg.getBytes());
      ForwardBaseOption.a(paramActivity, paramBundle, paramInt);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.qqstory.share", 2, "shareQQGroupVideoToQQ exception", paramActivity);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, Intent paramIntent)
  {
    try
    {
      if (!QLog.isColorLevel()) {
        break label102;
      }
      QLog.d("Q.qqstory.share", 2, "handleShareQQNow: resultCode=" + paramInt);
    }
    catch (Exception paramQQAppInterface)
    {
      label102:
      do
      {
        Intent localIntent;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.qqstory.share", 2, "handleShareQQNow exception", paramQQAppInterface);
        return;
      } while (paramInt == -1);
    }
    localIntent = AIOUtils.a(new Intent(paramActivity, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    ForwardUtils.a(paramQQAppInterface, paramActivity, ForwardUtils.a(localIntent), localIntent);
    return;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, Intent paramIntent)
  {
    try
    {
      if (!QLog.isColorLevel()) {
        break label102;
      }
      QLog.d("Q.qqstory.share", 2, "handleShareQQGroupVideo: resultCode=" + paramInt);
    }
    catch (Exception paramQQAppInterface)
    {
      label102:
      do
      {
        Intent localIntent;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.qqstory.share", 2, "handleShareQQGroupVideo exception", paramQQAppInterface);
        return;
      } while (paramInt == -1);
    }
    localIntent = AIOUtils.a(new Intent(paramActivity, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    ForwardUtils.a(paramQQAppInterface, paramActivity, ForwardUtils.a(localIntent), localIntent);
    return;
  }
  
  private void h()
  {
    Object localObject = "";
    label56:
    QQAppInterface localQQAppInterface;
    if (this.jdField_b_of_type_Int == 1)
    {
      str = "0";
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
        ReportController.b(localQQAppInterface, "CliOper", "", "", "Grp", (String)localObject, 0, 0, str, "", "", "");
        bool = NetworkUtil.d(BaseApplication.getContext());
        if ((!bool) && (this.jdField_a_of_type_Int != 4))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433009), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
          if (QLog.isColorLevel()) {
            QLog.i("TroopShareUtility", 2, "tryToGetShareLink: net is not supported");
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener.a(this.jdField_a_of_type_Int, false);
          }
          this.jdField_a_of_type_Int = -1;
          this.jdField_b_of_type_Int = -1;
          if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
            ((TroopCreateLogicActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
          }
        }
        break;
      }
    }
    do
    {
      return;
      str = "1";
      break;
      localObject = "Grplink_moments";
      break label56;
      localObject = "Grplink_wechat";
      break label56;
      localObject = "Grplink_qq";
      break label56;
      localObject = "Grplink_qzone";
      break label56;
      localObject = "Copy_grplink";
      break label56;
      if (a() != null) {
        break label414;
      }
      if ((bool) || (this.jdField_a_of_type_Int != 4)) {
        break label370;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433009), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.i("TroopShareUtility", 2, "tryToGetShareLink: net is not supported");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener.a(this.jdField_a_of_type_Int, false);
      }
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
    } while (!(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity));
    ((TroopCreateLogicActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
    return;
    label370:
    a();
    localObject = (TroopHandler)localQQAppInterface.a(20);
    String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (this.jdField_b_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((TroopHandler)localObject).a(str, bool);
      return;
    }
    label414:
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      this.c = AvatarTroopUtil.a("", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
      l();
      return;
    case 3: 
      i();
      return;
    case 2: 
      j();
      return;
    case 1: 
      k();
      return;
    }
    m();
  }
  
  private void i()
  {
    this.e = String.valueOf(System.currentTimeMillis());
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
    Bitmap localBitmap = a(localQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (byte)3, false, false));
    String str = a();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    }
    for (;;)
    {
      Object localObject3 = ((TroopManager)localQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      Object localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (!((TroopInfo)localObject3).hasSetTroopName())
        {
          localObject2 = localObject1;
          if (((TroopInfo)localObject3).wMemberNum > 0) {
            localObject2 = (String)localObject1 + "(" + ((TroopInfo)localObject3).wMemberNum + ")";
          }
        }
      }
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
      localObject1 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = "创建人：" + ContactUtils.e(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      }
      WXShareHelper.a().a(this.e, (String)localObject2, localBitmap, (String)localObject1, str);
      if (QLog.isColorLevel()) {
        QLog.i("TroopShareUtility", 2, "shareToFriendCircle.transaction: " + this.e + " troopname:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName + " memo:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo + " shareLink:" + str);
      }
      this.jdField_b_of_type_Int = -1;
      return;
    }
  }
  
  private void j()
  {
    String str1 = String.valueOf(System.currentTimeMillis());
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
    Object localObject = ((TroopManager)localQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    Bitmap localBitmap = a(localQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (byte)3, false, false));
    String str2 = a();
    StringBuffer localStringBuffer = new StringBuffer(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName);
    if (TextUtils.isEmpty(localStringBuffer)) {
      localStringBuffer.append(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    if ((localObject != null) && (!((TroopInfo)localObject).hasSetTroopName()) && (((TroopInfo)localObject).wMemberNumClient > 0)) {
      localStringBuffer.append("(").append(((TroopInfo)localObject).wMemberNumClient).append(")");
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = "创建人：" + ContactUtils.e(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
    }
    for (;;)
    {
      localObject = a((String)localObject);
      WXShareHelper.a().b(str1, localStringBuffer.toString(), localBitmap, (String)localObject, str2);
      if (QLog.isColorLevel()) {
        QLog.i("TroopShareUtility", 2, "shareToWXFriend.transaction: " + str1 + " troopname:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName + " memo:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopIntro + " shareLink:" + str2);
      }
      this.jdField_b_of_type_Int = -1;
      return;
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
    Object localObject3 = ((TroopManager)localQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if (localObject3 != null) {}
    for (boolean bool = ((TroopInfo)localObject3).isNewTroop; (bool) && (this.d == null); bool = false)
    {
      a(new ajxn(this));
      return;
    }
    String str = a();
    Object localObject1;
    ArrayList localArrayList;
    if (bool)
    {
      localObject1 = this.d;
      localArrayList = new ArrayList();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localArrayList.add(localObject1);
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      }
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (!((TroopInfo)localObject3).hasSetTroopName())
        {
          localObject2 = localObject1;
          if (((TroopInfo)localObject3).wMemberNumClient > 0) {
            localObject2 = (String)localObject1 + "(" + ((TroopInfo)localObject3).wMemberNum + ")";
          }
        }
      }
      localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131430161), new Object[] { localObject2 }) + "(" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + ")" + a();
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("title", (String)localObject2);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
        break label536;
      }
      ((Bundle)localObject3).putString("desc", "创建人：" + ContactUtils.e(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin));
    }
    for (;;)
    {
      ((Bundle)localObject3).putLong("req_share_id", 0L);
      ((Bundle)localObject3).putString("detail_url", str);
      ((Bundle)localObject3).putString("url", str);
      ((Bundle)localObject3).putStringArrayList("image_url", localArrayList);
      ((Bundle)localObject3).putString("troop_wording", (String)localObject1);
      ((Bundle)localObject3).putString("bizname", "JoinTroopLink");
      QZoneShareManager.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Bundle)localObject3, null, 145);
      if (QLog.isColorLevel()) {
        QLog.i("TroopShareUtility", 2, "shareToQzone.troopname:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName + " shareLink:" + str + " desc:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
      }
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
      return;
      localObject1 = AvatarTroopUtil.a("", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0) + "100";
      break;
      label536:
      ((Bundle)localObject3).putString("desc", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
    Object localObject3 = ((TroopManager)localQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if (localObject3 != null) {}
    for (boolean bool = ((TroopInfo)localObject3).isNewTroop; (bool) && (this.d == null); bool = false)
    {
      a(new ajxo(this));
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    }
    localObject2 = localObject1;
    if (localObject3 != null)
    {
      localObject2 = localObject1;
      if (!((TroopInfo)localObject3).hasSetTroopName())
      {
        localObject2 = localObject1;
        if (((TroopInfo)localObject3).wMemberNumClient > 0) {
          localObject2 = (String)localObject1 + "(" + ((TroopInfo)localObject3).wMemberNum + ")";
        }
      }
    }
    AbsShareMsg localAbsShareMsg = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(15).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435321) + (String)localObject2).c(a()).a();
    localObject1 = null;
    StructMsgItemLayoutDefault localStructMsgItemLayoutDefault;
    AbsStructMsgItem localAbsStructMsgItem;
    if ((!bool) && (!TextUtils.isEmpty(this.c)))
    {
      localObject1 = this.c + "100";
      if (QLog.isColorLevel()) {
        QLog.i("TroopShareUtility", 2, "shareToMobileQQ.coverUrl:" + (String)localObject1);
      }
      localStructMsgItemLayoutDefault = new StructMsgItemLayoutDefault();
      localStructMsgItemLayoutDefault.b(1);
      localStructMsgItemLayoutDefault.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131430434));
      localAbsStructMsgItem = StructMsgElementFactory.a(2);
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        break label614;
      }
      localObject3 = "创建人:" + ContactUtils.e(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
    }
    label614:
    for (;;)
    {
      localAbsStructMsgItem.a((String)localObject1, (String)localObject2, (String)localObject3, 1);
      localAbsShareMsg.addItem(localStructMsgItemLayoutDefault);
      localAbsShareMsg.addItem(localAbsStructMsgItem);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("forward_type", -3);
      ((Intent)localObject2).putExtra("stuctmsg_bytes", localAbsShareMsg.getBytes());
      ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Intent)localObject2, 3);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
        ((TroopCreateLogicActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).jdField_a_of_type_Boolean = true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopShareUtility", 2, "shareToMobileQQ.mMsgServiceID:" + localAbsShareMsg.mMsgServiceID + " mMsgBrief:" + localAbsShareMsg.mMsgBrief + " mContentTitle:" + localAbsShareMsg.mContentTitle + " mContentSummary:" + localAbsShareMsg.mContentSummary + " mMsgUrl:" + localAbsShareMsg.mMsgUrl + " coverUrl:" + (String)localObject1 + " mSourceName:" + localAbsShareMsg.mSourceName);
      }
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
      return;
      if (!bool) {
        break;
      }
      localObject1 = this.d;
      break;
    }
  }
  
  @TargetApi(11)
  private void m()
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    }
    str1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435323), new Object[] { str1, a() });
    if (QLog.isColorLevel()) {
      QLog.i("TroopShareUtility", 2, "copyTroopLink.text:" + str1);
    }
    if (Build.VERSION.SDK_INT < 11) {
      ((android.text.ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("clipboard")).setText(str1);
    }
    for (;;)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435324), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      if (this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener.a(this.jdField_a_of_type_Int, true);
      }
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
      return;
      ((android.content.ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("troop_url", str1));
    }
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131435070);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("TroopShareUtility", 2, localException.toString());
    }
  }
  
  public void a(ajxs paramajxs)
  {
    ThreadManager.post(new ajxq(this, paramajxs), 8, null, false);
  }
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.e == null) || (!this.e.equals(paramBaseResp.transaction))) {
      return;
    }
    TroopShareUtility.OnShareListener localOnShareListener;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener != null)
    {
      localOnShareListener = this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener;
      i = this.jdField_a_of_type_Int;
      if (paramBaseResp.errCode != 0) {
        break label123;
      }
    }
    label123:
    for (boolean bool = true;; bool = false)
    {
      localOnShareListener.a(i, bool);
      this.jdField_a_of_type_Int = -1;
      switch (paramBaseResp.errCode)
      {
      case -2: 
      case -1: 
      default: 
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435303), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435302), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
  }
  
  public void a(TroopInfoData paramTroopInfoData)
  {
    ReportController.b((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime(), "CliOper", "", "", "Grp", "Clk_share_grplink", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = paramTroopInfoData;
    d();
  }
  
  public void a(boolean paramBoolean)
  {
    String str1;
    label63:
    ReportTask localReportTask;
    String str2;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      localObject = null;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        str1 = "2";
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label166;
        }
        str1 = "0";
        localReportTask = new ReportTask(null).a("P_CliOper").b("Grp_set").c("Grp_data").d((String)localObject);
        str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!paramBoolean) {
          break label183;
        }
      }
      break;
    }
    label166:
    label183:
    for (Object localObject = "0";; localObject = "1")
    {
      localReportTask.a(new String[] { str2, localObject, str1 }).a();
      return;
      localObject = "share_qq";
      break;
      localObject = "share_qzone";
      break;
      localObject = "share_circle";
      break;
      localObject = "share_wechat";
      break;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
        break label63;
      }
      str1 = "1";
      break label63;
    }
  }
  
  public void b()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("TroopShareUtility", 2, localException.toString());
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Int = 0;
    h();
  }
  
  protected void d()
  {
    Object localObject = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {}
    for (int i = 5;; i = 4)
    {
      int j = 0;
      while (j <= i)
      {
        ((List)localObject).add(ActionSheetAdapter.a(j));
        j += 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter == null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter = new ActionSheetAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter.a((List)localObject);
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      localObject = new ajxi(this);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433100));
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember));
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(new ajxj(this));
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a((AdapterView.OnItemClickListener)localObject);
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  public void e()
  {
    this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null));
    this.jdField_b_of_type_ComTencentWidgetActionSheet.b(2131435316);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.b(2131435317);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.c(2131433015);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new ajxk(this));
    this.jdField_b_of_type_ComTencentWidgetActionSheet.a(new ajxl(this));
    String str;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435315);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(str);
      if (!this.jdField_b_of_type_ComTencentWidgetActionSheet.isShowing())
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_b_of_type_ComTencentWidgetActionSheet.show();
      }
      return;
      str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435312), new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435313) });
      continue;
      str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435312), new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435314) });
      continue;
      str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435312), new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435300) });
      continue;
      str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435312), new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435308) });
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    WXShareHelper.a().b(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = null;
  }
  
  public void g()
  {
    TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData;
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QRDisplayActivity.class);
    localIntent.putExtra("title", "群聊二维码");
    localIntent.putExtra("nick", localTroopInfoData.troopName);
    localIntent.putExtra("uin", localTroopInfoData.troopUin);
    int i;
    if (localTroopInfoData.bOwner) {
      i = 0;
    }
    for (;;)
    {
      localIntent.putExtra("adminLevel", i);
      localIntent.putExtra("type", 2);
      localIntent.putExtra("GroupFlagExt", localTroopInfoData.dwGroupFlagExt);
      localIntent.putExtra("AuthGroupType", localTroopInfoData.dwAuthGroupType);
      ThreadManager.post(new ajxp(this, (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime(), localTroopInfoData, localIntent), 8, null, true);
      return;
      if (localTroopInfoData.bAdmin) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility
 * JD-Core Version:    0.7.0.1
 */