package com.tencent.mobileqq.forward;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.dataline.core.DirectForwarder;
import com.dataline.core.DirectForwarder.CallBack;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.biz.widgets.ShareResultDialog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.avgameshare.AVGameShareUtil;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.hiboom.HiBoomConstants;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.share.api.IShareReport;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.RegionalThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;
import com.tencent.mobileqq.utils.QQCustomDialogWtihForwardAvatar;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.writetogether.api.IWriteTogetherOidbHandler;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import eipc.EIPCClient;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ForwardBaseOption
  implements DialogInterface.OnDismissListener, ForwardAbility, ForwardAbility.ForwardAbilityType, ForwardConstants, ForwardDialogBuilder
{
  static int D = 0;
  public static String M = "key_thumb_style_centerinside";
  static SimpleDateFormat ac;
  protected QQCustomDialog A;
  protected ShareResultDialog B = null;
  protected Set<Integer> C;
  protected boolean E;
  protected boolean F = false;
  protected long G = 0L;
  public boolean H = false;
  protected Context I;
  boolean J = false;
  boolean K = false;
  protected int L = 11;
  protected QQProgressDialog N;
  protected boolean O = false;
  protected boolean P = false;
  protected String Q;
  protected int R;
  protected boolean S;
  protected List<ForwardBaseOption.EventListener> T;
  DialogInterface.OnClickListener U;
  DialogInterface.OnClickListener V;
  View.OnClickListener W;
  DialogInterface.OnClickListener X;
  protected ArrayList<ResultRecord> Y;
  protected int Z = 0;
  private ArrayList<ResultRecord> a;
  protected QQProgressDialog aa;
  DiscussionObserver ab = new ForwardBaseOption.15(this);
  private ArrayList<ResultRecord> ad;
  private ShareAioResultDialog ae = null;
  private boolean[] af;
  private QQProgressDialog ag;
  protected QQAppInterface q;
  protected Intent r;
  protected Activity s;
  protected Bundle t;
  protected String u;
  String v;
  boolean w;
  String x;
  String y;
  float z;
  
  public ForwardBaseOption(Intent paramIntent)
  {
    this.r = paramIntent;
    if (paramIntent.getExtras() != null) {
      paramIntent = paramIntent.getExtras();
    } else {
      paramIntent = new Bundle();
    }
    this.t = paramIntent;
    this.I = BaseApplicationImpl.getApplication().getApplicationContext();
    this.E = false;
    this.T = new ArrayList();
  }
  
  private String a(String paramString)
  {
    String str2 = HardCodeUtil.a(2131902739);
    String str1 = paramString;
    if (paramString.startsWith(str2)) {
      str1 = paramString.substring(str2.length());
    }
    return str1.trim();
  }
  
  @Deprecated
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    a(paramActivity, paramIntent, ForwardRecentActivity.class, paramInt, -1, "");
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt1, int paramInt2)
  {
    a(paramActivity, paramIntent, ForwardRecentActivity.class, paramInt1, paramInt2, "");
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt1, int paramInt2, String paramString)
  {
    a(paramActivity, paramIntent, ForwardRecentActivity.class, paramInt1, paramInt2, paramString);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, String paramString)
  {
    a(paramActivity, paramIntent, ForwardRecentActivity.class, paramInt, paramString);
  }
  
  @Deprecated
  public static void a(Activity paramActivity, Intent paramIntent, Class<?> paramClass, int paramInt)
  {
    a(paramActivity, paramIntent, paramClass, paramInt, -1, "");
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, Class<?> paramClass, int paramInt1, int paramInt2, String paramString)
  {
    paramIntent.setClass(paramActivity, paramClass);
    paramIntent.putExtra("caller_name", paramActivity.getClass().getSimpleName());
    paramIntent.putExtra("forward_source_business_type", paramInt2);
    paramIntent.putExtra("forward_source_sub_business_type", paramString);
    paramActivity.startActivityForResult(paramIntent, paramInt1);
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt1, int paramInt2)
  {
    a(paramActivity, paramString, paramIntent, ForwardRecentActivity.class, paramInt1, paramInt2);
  }
  
  private static void a(Activity paramActivity, String paramString, Intent paramIntent, Class<?> paramClass, int paramInt1, int paramInt2)
  {
    paramIntent.setClass(paramActivity, paramClass);
    if (TextUtils.isEmpty(paramString)) {
      paramIntent.putExtra("caller_name", paramActivity.getClass().getSimpleName());
    } else {
      paramIntent.putExtra("caller_name", paramString);
    }
    paramIntent.putExtra("forward_source_business_type", paramInt2);
    paramActivity.startActivityForResult(paramIntent, paramInt1);
  }
  
  @Deprecated
  public static void a(Context paramContext, Intent paramIntent)
  {
    a(paramContext, paramIntent, ForwardRecentActivity.class, -1, "");
  }
  
  @Deprecated
  public static void a(Context paramContext, Intent paramIntent, Class<?> paramClass)
  {
    a(paramContext, paramIntent, paramClass, -1, "");
  }
  
  private static void a(Context paramContext, Intent paramIntent, Class<?> paramClass, int paramInt, String paramString)
  {
    if (paramContext != null)
    {
      paramIntent.setClass(paramContext, paramClass);
      paramIntent.putExtra("forward_source_business_type", paramInt);
      paramIntent.putExtra("forward_source_sub_business_type", paramString);
      paramContext.startActivity(paramIntent);
    }
  }
  
  private void a(Bundle paramBundle, int paramInt, String paramString)
  {
    long l = paramBundle.getLong("req_share_id", 0L);
    Object localObject;
    if (l == 0L)
    {
      paramBundle = paramBundle.getString("forward_ark_app_meta");
      if (TextUtils.isEmpty(paramBundle))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardBaseOption", 2, "reportClickSend arkAppId is empty");
        }
        return;
      }
      localObject = null;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramBundle).optJSONObject("news");
        paramBundle = (Bundle)localObject;
        if (localJSONObject == null) {
          break label125;
        }
        paramBundle = localJSONObject.optString("appid");
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        paramBundle = (Bundle)localObject;
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append(l);
      paramBundle.append("");
      paramBundle = paramBundle.toString();
    }
    label125:
    boolean bool;
    if ((paramInt != 1) && (paramInt != 2)) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportClickSend ,isForwardC2cOrGroup = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    if (("101492711".equals(paramBundle)) && (bool))
    {
      if (paramInt == 1) {
        localObject = "c2c_AIO";
      } else {
        localObject = "Grp_AIO";
      }
      ReportController.b(null, "dc00899", (String)localObject, "", "video_tab", "videoark_share", 0, 0, paramString, paramBundle, "", "");
    }
  }
  
  private void a(AIOImageData paramAIOImageData, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "getImageEditListener from AIOImageData");
    }
    if ((paramAIOImageData.a(4)) && (paramAIOImageData.c(4) != null))
    {
      a(paramAIOImageData, paramString);
      return;
    }
    if ((paramAIOImageData.a(2)) && (paramAIOImageData.c(2) != null))
    {
      a(paramAIOImageData, paramString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "Edit Forward Image: image does not exist");
    }
  }
  
  private void a(AIORichMediaData paramAIORichMediaData, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startToAioImagePreview: msgId=");
      if (paramAIORichMediaData != null) {
        localObject = Long.valueOf(paramAIORichMediaData.L);
      } else {
        localObject = "";
      }
      localStringBuilder.append(localObject);
      QLog.d("ForwardOption.ForwardBaseOption", 2, localStringBuilder.toString());
    }
    if (paramAIORichMediaData != null)
    {
      paramString = new AIOImageProviderService(this.q.getCurrentUin(), paramString, 0, null);
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("extra.EXTRA_NOT_CLEAR_TOP", true);
      a((Bundle)localObject, paramString, paramAIORichMediaData);
      aq();
    }
  }
  
  private void a(MessageForPic paramMessageForPic, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startToAioImagePreview: uniseq=");
      if (paramMessageForPic != null) {
        localObject = Long.valueOf(paramMessageForPic.uniseq);
      } else {
        localObject = "";
      }
      localStringBuilder.append(localObject);
      QLog.d("ForwardOption.ForwardBaseOption", 2, localStringBuilder.toString());
    }
    if (paramMessageForPic != null)
    {
      paramString = new AIOImageProviderService(this.q.getCurrentUin(), paramString, 0, paramMessageForPic);
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("extra.EXTRA_NOT_CLEAR_TOP", true);
      a((Bundle)localObject, paramString, AIOGalleryUtils.a(paramMessageForPic));
      aq();
    }
  }
  
  private void a(MessageForPic paramMessageForPic, String paramString, ForwardBaseOption.IPicDownloadCallback paramIPicDownloadCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "getImageEditListener from MessageForPic");
    }
    paramIPicDownloadCallback = new File(paramMessageForPic.path);
    if (paramIPicDownloadCallback.exists())
    {
      paramIPicDownloadCallback.length();
      long l = paramMessageForPic.size;
    }
    a(paramMessageForPic, paramString);
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startToAioImagePreviewWithPath: path=");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject = new AIOImageData();
      ((AIOImageData)localObject).a = paramString1;
      ((AIOImageData)localObject).b = paramString1;
      ((AIOImageData)localObject).c = paramString1;
      ((AIOImageData)localObject).j = false;
      paramString1 = new Bundle();
      paramString1.putBoolean("extra.EXTRA_NOT_CLEAR_TOP", true);
      a(paramString1, new AIOImageProviderService(this.q.getCurrentUin(), paramString2, 0, null), (AIORichMediaData)localObject);
      aq();
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("key_mini_report_event_action_type", paramString1);
    localBundle.putString("key_mini_report_event_sub_action_type", paramString2);
    localBundle.putString("key_mini_report_event_reserves", paramString3);
    localBundle.putString("key_mini_report_event_reserves2", paramString4);
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_report_event", localBundle, null);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    boolean bool;
    if ((paramInt != 1) && (paramInt != 2)) {
      bool = false;
    } else {
      bool = true;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportClickSend ,isAudioReqType = ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(",isMusicArkView = ");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append(",isForwardC2cOrGroup = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    if (((paramBoolean1) || (paramBoolean2)) && (bool))
    {
      if (paramInt == 1) {
        localObject = "c2c_AIO";
      } else {
        localObject = "Grp_AIO";
      }
      if (paramInt == 1) {
        paramString = "";
      }
      ReportController.b(null, "dc00899", (String)localObject, "", "music_tab", "musicark_share", 0, 0, paramString, "", "", "");
    }
  }
  
  private void a(int[] paramArrayOfInt, String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean[] paramArrayOfBoolean)
  {
    IWriteTogetherOidbHandler localIWriteTogetherOidbHandler = (IWriteTogetherOidbHandler)this.q.getBusinessHandler(BusinessHandlerFactory.WRITE_TOGETHER_HANDLER);
    int i = 0;
    while (i < paramArrayOfBoolean.length)
    {
      if (paramArrayOfBoolean[i] != 0) {
        localIWriteTogetherOidbHandler.sendForwardWtMessage(paramArrayOfString1[i], paramArrayOfString2[i], paramArrayOfInt[i], paramString);
      }
      i += 1;
    }
    aD();
    paramArrayOfInt = new ForwardBaseOption.4(this, paramArrayOfBoolean, paramArrayOfString1, paramArrayOfString2, paramArrayOfInt, this.t.getInt("forward_write_together_number"));
    this.q.addObserver(paramArrayOfInt);
  }
  
  private boolean a(RecentUser paramRecentUser)
  {
    boolean bool = true;
    if ((paramRecentUser != null) && (!Utils.b(paramRecentUser.uin)) && ((paramRecentUser.getType() != 1006) || (a(ForwardAbility.ForwardAbilityType.i))) && (b(paramRecentUser)) && ((paramRecentUser.getType() != 1) || (!c(paramRecentUser.uin))) && ((paramRecentUser.getType() != 0) || (!CrmUtils.a(this.q, paramRecentUser.uin, paramRecentUser.getType()))))
    {
      if ((paramRecentUser.getType() != 1004) && (paramRecentUser.getType() != 1000)) {
        return bool;
      }
      if (this.E) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  private void aA()
  {
    if (K())
    {
      localObject1 = L().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ResultRecord)((Iterator)localObject1).next();
        c(((ResultRecord)localObject2).uin, ((ResultRecord)localObject2).getUinType());
      }
    }
    Object localObject1 = this.t;
    if (localObject1 != null) {
      localObject1 = ((Bundle)localObject1).getString("uin");
    } else {
      localObject1 = "";
    }
    Object localObject2 = this.t;
    int i = -1;
    if (localObject2 != null) {
      i = ((Bundle)localObject2).getInt("uintype", -1);
    }
    c((String)localObject1, i);
  }
  
  private void aB()
  {
    Bundle localBundle = new Bundle();
    if (K())
    {
      localObject = L().iterator();
      while (((Iterator)localObject).hasNext())
      {
        localBundle.putLong("key_receiver_type", ((ResultRecord)((Iterator)localObject).next()).getUinType());
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "ae_camera_get_info_client", "action_get_send_to_info", localBundle, null);
      }
    }
    Object localObject = this.t;
    long l;
    if (localObject != null) {
      l = ((Bundle)localObject).getInt("uintype", -1);
    } else {
      l = -1L;
    }
    localBundle.putLong("key_receiver_type", l);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "ae_camera_get_info_client", "action_get_send_to_info", localBundle, null);
  }
  
  private Drawable aC()
  {
    Object localObject1 = this.y;
    if ((localObject1 != null) && (AbsDownloader.hasFile((String)localObject1))) {
      localObject1 = this.y;
    } else {
      localObject1 = this.x;
    }
    if (localObject1 != null)
    {
      Object localObject3 = b((String)localObject1, "file:");
      Object localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (((File)localObject3).exists())
        {
          localObject3 = ((File)localObject3).getAbsolutePath();
          this.t.putString("EditImagePath", (String)localObject3);
          URL localURL = RegionalThumbDownloader.generateURLForNew((String)localObject3, ScreenUtil.dip2px(100.0F), ScreenUtil.dip2px(300.0F));
          localObject2 = localObject1;
          if (localURL != null) {
            localObject2 = localURL.toString();
          }
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = localObject3;
          }
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getURLDrawable updateImageView  fixedUrlString=");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.e("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject2).toString());
            localObject2 = localObject1;
          }
        }
      }
      try
      {
        localObject1 = URLDrawable.getDrawable((String)localObject2);
        return localObject1;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getURLDrawable fixedUrlString url is illegal = ");
          ((StringBuilder)localObject2).append(localException);
          QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject2).toString());
        }
        return null;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("ForwardOption.ForwardBaseOption", 2, "getURLDrawable isURLDrawablFoward is true, but mBigURLDrawableUrl and URLDrawableUrl are null");
    }
    return null;
  }
  
  private void aD()
  {
    if (this.ag == null)
    {
      this.ag = new QQProgressDialog(this.s, 0, 2131627607, 17);
      this.ag.setContentView(2131629210);
      this.ag.a("正在发送");
      this.ag.setCancelable(true);
    }
    if (this.ag.isShowing()) {
      this.ag.dismiss();
    }
    this.ag.show();
  }
  
  private void aE()
  {
    QQProgressDialog localQQProgressDialog = this.ag;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.ag.dismiss();
    }
  }
  
  private void au()
  {
    J();
    if ((this.t.getBoolean("is_ark_display_share")) && (this.t.getBoolean("forward_ark_from_h5_parse_meta_success")))
    {
      this.A = DialogUtils.a(this.s, B(), this.t, this.s.getResources().getInteger(2131492885));
      this.A.setMessage("");
      this.A.setNegativeButton(2131887648, P());
      this.A.setPositiveButton(2131887750, N());
      this.A.show();
      return;
    }
    this.A = DialogUtils.a(this.s, B(), n(), null, N(), P());
  }
  
  private void av()
  {
    int i = this.t.getInt("forward_type");
    if ((i != 27) && (i != 39) && (i != 46))
    {
      this.A = DialogUtil.a(this.s, B(), n(), H(), C(), D(), N(), P());
      return;
    }
    this.A = DialogUtils.a(this.s, B(), this.t, this.s.getResources().getInteger(2131492885));
    this.A.setMessage("");
    this.A.setNegativeButton(2131887648, P());
    this.A.setPositiveButton(2131887750, N());
    this.A.show();
  }
  
  private void aw()
  {
    int i = this.t.getInt("key_forward_ability_type");
    if ((i == h.intValue()) || (i == k.intValue()) || (i == n.intValue()) || (i == f.intValue())) {
      this.t.putBoolean("is_ark_display_share", false);
    }
  }
  
  private void ax()
  {
    Object localObject1 = this.s;
    if ((localObject1 != null) && (!((Activity)localObject1).isFinishing()))
    {
      if (this.ae == null) {
        this.ae = new ShareAioResultDialog(this.s);
      }
      Object localObject2 = this.q.getApplication().getString(2131916399);
      String str = this.t.getString("app_name");
      localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(str);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = new ForwardBaseOption.1(this);
      this.ae.a((String)localObject1, (DialogInterface.OnClickListener)localObject2);
      this.ae.a((DialogInterface.OnClickListener)localObject2);
      this.ae.show();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ForwardOption.ForwardBaseOption", 2, " qbShowShareResultDialog error mActivity = null");
    }
  }
  
  private void ay()
  {
    Object localObject = this.ad;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = this.ad.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
        if (localResultRecord.uinType == 6000) {
          b(g.intValue());
        } else if (localResultRecord.uinType == 6003) {
          b(l.intValue());
        }
      }
      localObject = this.Y;
      if ((localObject == null) || (((ArrayList)localObject).isEmpty()))
      {
        this.r.putExtra("NOCANCEL4DATALIN", true);
        this.s.setResult(0, this.r);
        this.s.finish();
      }
      this.t.putParcelableArrayList("forward_multi_target", this.Y);
      this.r.putParcelableArrayListExtra("forward_multi_target", this.Y);
    }
    b();
    if (this.F) {
      return;
    }
    if (this.t.getBoolean("system_share", false))
    {
      if ((1 == this.t.getInt("forward_type", 2147483647)) && (this.r.getBooleanExtra("sendMultiple", false))) {
        return;
      }
      ForwardUtils.a(this.s, this.t);
      return;
    }
    if ((this.O) && (!this.P))
    {
      ThreadManager.getUIHandler().postDelayed(new ForwardBaseOption.3(this), 500L);
      return;
    }
    this.s.finish();
    if (this.r.getBooleanExtra("is_need_show_toast", true)) {
      ForwardUtils.a(this.q, 500L);
    }
  }
  
  private void az()
  {
    Object localObject = this.t;
    boolean bool;
    if (localObject != null) {
      bool = ((Bundle)localObject).getBoolean("from_card", false);
    } else {
      bool = false;
    }
    if (bool)
    {
      localObject = this.t.getString("pubUin");
      if (localObject == null) {
        localObject = "";
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.q, "P_CliOper", "Pb_account_lifeservice", (String)localObject, "0X8005A2C", "0X8005A2C", 0, 0, "", "", "", "", false);
    }
    if (this.r.getBooleanExtra("forward_source_from_shoot_quick", false))
    {
      int i = this.t.getInt("forward_type");
      if (i == 21) {
        localObject = "0X800780B";
      }
      for (;;)
      {
        break;
        if (i == 1) {
          localObject = "0X8007811";
        } else {
          localObject = "";
        }
      }
      ReportController.b(this.q, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
    }
    localObject = this.t;
    if ((localObject != null) && (((Bundle)localObject).getBoolean("forward_report_confirm")))
    {
      localObject = this.t.getString("forward_report_confirm_action_name");
      String str = this.t.getString("forward_report_confirm_reverse2");
      if (localObject == null) {
        localObject = "";
      }
      if (str == null) {
        str = "";
      }
      ReportController.b(this.q, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, str, "", "", "");
    }
    if (this.F) {
      ReportCenter.a().a(this.q.getAccount(), "", String.valueOf(this.G), "1000", "50", "0", false, this.F);
    }
    localObject = this.t;
    if ((localObject != null) && (((Bundle)localObject).getInt("extra_key_from_apollo") > 0)) {
      VipUtils.a(null, "cmshow", "Apollo", "QQSend", 0, 0, new String[0]);
    }
    localObject = this.t;
    if ((localObject != null) && (((Bundle)localObject).getBoolean("KEY_FROM_OCR", false))) {
      ReportController.b(this.q, "dc00898", "", "", "0X8009C8E", "0X8009C8E", 0, 0, "", "", "", "");
    }
    localObject = this.t;
    if ((localObject != null) && (((Bundle)localObject).getBoolean("KEY_FROM_TRANSLATE", false))) {
      ReportController.b(this.q, "dc00898", "", "", "0X8009C85", "0X8009C85", 0, 0, "", "", "", "");
    }
  }
  
  private File b(String paramString1, String paramString2)
  {
    boolean bool1 = paramString1.toLowerCase(Locale.US).startsWith(paramString2);
    Object localObject2 = null;
    if (bool1) {
      localObject1 = localObject2;
    }
    try
    {
      if (!paramString1.substring(0, paramString2.length()).equalsIgnoreCase(paramString2)) {
        break label75;
      }
      localObject1 = new File(paramString1.substring(paramString2.length()));
    }
    catch (IndexOutOfBoundsException paramString1)
    {
      label59:
      boolean bool2;
      break label59;
    }
    Object localObject1 = localObject2;
    break label75;
    localObject1 = AbsDownloader.getFile(AbsDownloader.covertUrlForAioImage(paramString1));
    label75:
    bool1 = this.r.getBooleanExtra("forward_source_from_shoot_quick", false);
    bool2 = this.r.getBooleanExtra("forward_source_from_pre_guide", false);
    if ((bool1) || (bool2)) {
      localObject1 = new File(this.x);
    }
    return localObject1;
  }
  
  private boolean b(RecentUser paramRecentUser)
  {
    return (paramRecentUser.getType() != 1020) && (paramRecentUser.getType() != 1008) && (paramRecentUser.getType() != 1005) && (paramRecentUser.getType() != 1009) && (paramRecentUser.getType() != 1021) && (paramRecentUser.getType() != 1001) && (paramRecentUser.getType() != 10002) && (paramRecentUser.getType() != 10004) && (paramRecentUser.getType() != 1022) && (paramRecentUser.getType() != 1032) && (paramRecentUser.getType() != 1033) && (paramRecentUser.getType() != 1034) && (paramRecentUser.getType() != 7000) && (paramRecentUser.getType() != 6004) && (paramRecentUser.getType() != 9501);
  }
  
  public static int c(Bundle paramBundle)
  {
    int i = paramBundle.getInt("forward_source_business_type", -1);
    int j;
    if (i == -1)
    {
      int k = paramBundle.getInt("forward_source_uin_type", -1);
      if (k == 0)
      {
        i = 100101;
        j = k;
      }
      else if (k == 1)
      {
        i = 100100;
        j = k;
      }
      else
      {
        j = k;
        if (k == 3000)
        {
          i = 100300;
          j = k;
        }
      }
    }
    else
    {
      j = -11;
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("getForwardSrcBusinessType, srcBusinessType = ");
      paramBundle.append(i);
      paramBundle.append(",sourceUinType = ");
      paramBundle.append(j);
      QLog.d("ForwardOption.ForwardBaseOption", 2, paramBundle.toString());
    }
    return i;
  }
  
  private void c(String paramString, int paramInt)
  {
    Intent localIntent = this.r;
    if ((localIntent != null) && (("ChatActivity".equals(localIntent.getStringExtra("caller_name"))) || ("SplashActivity".equals(this.r.getStringExtra("caller_name")))))
    {
      PicItemBuilder.a(this.q, paramInt, this.r.getStringExtra("forward_photo_sender_uin"), this.r.getStringExtra("forward_photo_md5"), "0X8009F55", paramString);
      return;
    }
    localIntent = this.r;
    if ((localIntent != null) && ("PublicTransFragmentActivity".equals(localIntent.getStringExtra("caller_name")))) {
      PicItemBuilder.a(this.q, paramInt, this.r.getStringExtra("forward_photo_sender_uin"), this.r.getStringExtra("forward_photo_md5"), "0X8009F56", paramString);
    }
  }
  
  public static boolean d(Bundle paramBundle)
  {
    int i = paramBundle.getInt("forward_source_uin_type", -1);
    return (i == 1004) || (i == 1000);
  }
  
  private boolean f(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 0) && (paramInt != 1006) && (paramInt != 3000) && (paramInt != 1000))
    {
      if (paramInt == 10014) {
        return true;
      }
      return K();
    }
    return true;
  }
  
  private boolean f(String paramString)
  {
    String str = this.t.getString("uin");
    int k = this.t.getInt("uintype", 0);
    if (((TroopGagMgr)this.q.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(str, true).b)
    {
      QQToast.makeText(this.q.getApp(), 2131895180, 0).show(this.s.getResources().getDimensionPixelSize(2131299920));
      return false;
    }
    int j = al().getInt("key_forward_ability_type");
    paramString = new StringBuilder();
    paramString.append("-->getConfirmListener--onClick--type = ");
    paramString.append(j);
    QLog.d("ForwardOption.ForwardBaseOption", 1, paramString.toString());
    int i;
    if ((!QFileAssistantUtils.a(this.q)) || (j != g.intValue()))
    {
      i = j;
      if (j != l.intValue()) {}
    }
    else
    {
      this.t.putString("uin", "3636666661");
      this.t.putInt("uintype", 0);
      this.t.putString("uinname", this.I.getString(2131896189));
      this.t.putInt("key_forward_ability_type", c.intValue());
      i = c.intValue();
    }
    try
    {
      if ((i != g.intValue()) && (i != l.intValue()))
      {
        if (i == h.intValue())
        {
          aa();
        }
        else if (i == k.intValue())
        {
          g();
        }
        else if (i == n.intValue())
        {
          ak();
        }
        else if (i == f.intValue())
        {
          paramString = null;
          if ((this.A instanceof QQCustomDialogWtihEmoticonInput)) {
            paramString = ((QQCustomDialogWtihEmoticonInput)this.A).c();
          }
          d(paramString);
        }
        else if (!a(str, k))
        {
          b();
        }
      }
      else {
        b(i);
      }
      if ((this.r.getBooleanExtra("is_need_show_toast", true)) && (a(k, str, i))) {
        ForwardUtils.a(this.q, 300L);
      }
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardBaseOption", 2, "Throwable", paramString);
      }
    }
    h(i);
    az();
    return true;
  }
  
  private void g(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 12: 
      a("user_click", "more_button", "share_QQ", "success");
      return;
    case 11: 
      a("user_click", "custom_button", "share_QQ", "success");
      return;
    }
    a("user_click", "more_about", "share", "success");
  }
  
  private void g(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "getImageEditListener from other");
    }
    String str = this.t.getString("forward_filepath");
    if (str != null)
    {
      a(str, paramString);
      return;
    }
    if (this.r.getBooleanExtra("key_flag_from_plugin", false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "Edit Forward Image: from QZone");
      }
      this.t.putBoolean("FORWARD_IS_QZONE_SHARE", true);
      a(this.v, paramString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "Edit Forward Image: Unknown source");
    }
  }
  
  private Drawable h(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject = RegionalThumbDownloader.generateURLForNew(paramString, ScreenUtil.dip2px(100.0F), ScreenUtil.dip2px(300.0F));
    if (localObject == null) {
      return null;
    }
    if (!AbsDownloader.hasFile(((URL)localObject).toString())) {
      return null;
    }
    if (localObject != null) {
      localObject = ((URL)localObject).toString();
    } else {
      localObject = "";
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = (String)localObject;
    }
    try
    {
      localObject = URLDrawable.getDrawable(paramString);
      try
      {
        URLDrawableHelper.decodeLocalImage((URLDrawable)localObject, null, false);
        return localObject;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        return localObject;
      }
    }
    catch (Exception paramString)
    {
      localObject = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getNormalDrawable urlString url is illegal = ");
    localStringBuilder.append(paramString);
    QLog.d("ForwardOption.ForwardBaseOption", 2, localStringBuilder.toString());
    return localObject;
  }
  
  private void h(int paramInt)
  {
    Object localObject1 = this.t;
    int i = 0;
    Object localObject2;
    String str;
    Object localObject3;
    Object localObject4;
    if (localObject1 != null)
    {
      boolean bool = ((Bundle)localObject1).getBoolean("from_web", false);
      i = bool;
      if (bool)
      {
        localObject2 = this.t.getString("struct_uin");
        if (localObject2 == null) {
          localObject2 = "";
        }
        str = this.t.getString("struct_url");
        localObject1 = str;
        if (str == null) {
          localObject1 = "";
        }
        str = this.t.getString("strurt_msgid");
        if (str == null) {
          str = "";
        }
        localObject3 = ((IPublicAccountDetailActivity)QRoute.api(IPublicAccountDetailActivity.class)).getArticleId((String)localObject1);
        if (paramInt == f.intValue()) {
          paramInt = 1002;
        } else {
          paramInt = 1001;
        }
        localObject4 = this.t.getString("source_puin");
        if ((localObject4 != null) && (!"".equals(localObject4)))
        {
          localObject2 = this.t.getString("uin");
          if ((localObject2 != null) && (paramInt != 1002)) {
            break label202;
          }
          localObject2 = "";
          label202:
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.q, "P_CliOper", "Pb_account_lifeservice", (String)localObject2, "0X8005B07", "0X8005B07", paramInt, 0, (String)localObject4, str, (String)localObject1, (String)localObject3, false);
          i = bool;
        }
        else
        {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.q, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", paramInt, 0, (String)localObject2, str, (String)localObject1, (String)localObject3, false);
          i = bool;
        }
      }
    }
    localObject1 = this.t;
    if ((localObject1 != null) && (i == 0))
    {
      str = ((Bundle)localObject1).getString("source_puin");
      if (str != null)
      {
        localObject1 = this.r.getByteArrayExtra("stuctmsg_bytes");
        if (localObject1 != null)
        {
          localObject3 = StructMsgFactory.a((byte[])localObject1);
          if (localObject3 != null)
          {
            localObject2 = this.t.getString("uin");
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
            localObject4 = this.q;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(((AbsStructMsg)localObject3).msgId);
            ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEventForMigrate((AppInterface)localObject4, "P_CliOper", "Pb_account_lifeservice", (String)localObject1, "0X8005B06", "0X8005B06", 0, 0, str, localStringBuilder.toString(), "", "", false);
            localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("");
            ((StringBuilder)localObject4).append(((AbsStructMsg)localObject3).msgId);
            ((IPublicAccountReportUtils)localObject2).reportPAinfoToLighthouse("0X8005B06", (String)localObject1, str, ((StringBuilder)localObject4).toString(), "", "");
          }
        }
      }
    }
  }
  
  private int o()
  {
    if (G()) {
      return 2;
    }
    return 0;
  }
  
  private void p()
  {
    int i = this.t.getInt("req_type");
    Object localObject1;
    if ((this.t.getBoolean("is_ark_display_share", false)) && (i != 5))
    {
      this.A = DialogUtils.a(this.s, B(), this.t, this.s.getResources().getInteger(2131492885));
      localObject1 = this.t.getString("shareArkInfo");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    try
    {
      Object localObject2 = new JSONObject((String)localObject1);
      localObject1 = ((JSONObject)localObject2).optString("app");
      String str = ((JSONObject)localObject2).optString("view");
      localObject2 = ((JSONObject)localObject2).optString("meta");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
        ArkAppDataReport.a(this.q, (String)localObject1, "AIOArkSdkSelectSend", 1, 0, 0L, 0L, 0L, str, "");
      }
      label162:
      this.A.setMessage("");
      this.A.setNegativeButton(2131887648, P());
      this.A.setPositiveButton(2131887750, N());
      this.A.show();
      return;
      this.A = DialogUtils.a(this.s, B(), n(), null, N(), P(), this.s.getResources().getInteger(2131492885));
      i = this.t.getInt("key_forward_ability_type");
      boolean bool = this.r.getBooleanExtra("forward_ability_entrence_show_in_share", false);
      if ((i == f.intValue()) && (bool))
      {
        localObject1 = (QQCustomDialogWtihEmoticonInput)this.A;
        ((QQCustomDialogWtihEmoticonInput)localObject1).b();
        ((QQCustomDialogWtihEmoticonInput)localObject1).getEditText().setHint(HardCodeUtil.a(2131902733));
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      break label162;
    }
  }
  
  protected void A()
  {
    if (this.r.getBooleanExtra("k_favorites", true)) {
      this.C.add(h);
    }
  }
  
  public String B()
  {
    int i = this.t.getInt("key_forward_ability_type");
    Object localObject1;
    if (i == f.intValue()) {
      localObject1 = "QQ空间";
    } else if (i == g.intValue()) {
      localObject1 = HardCodeUtil.a(2131892059);
    } else if (i == l.intValue()) {
      localObject1 = "我的iPad";
    } else if (i == h.intValue()) {
      localObject1 = HardCodeUtil.a(2131902732);
    } else if (i == n.intValue()) {
      localObject1 = QQStoryConstant.a;
    } else {
      localObject1 = this.t.getString("uinname");
    }
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131902737));
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("dialogTitle=");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject1).toString());
    }
    return localObject2;
  }
  
  public int C()
  {
    return 2131887648;
  }
  
  public int D()
  {
    return 2131887750;
  }
  
  protected boolean E()
  {
    Object localObject = this.A;
    if ((localObject != null) && (((QQCustomDialog)localObject).isShowing())) {
      return false;
    }
    localObject = this.B;
    if ((localObject != null) && (((ShareResultDialog)localObject).isShowing())) {
      this.B.dismiss();
    }
    ae();
    return true;
  }
  
  protected int F()
  {
    return this.t.getInt("emoInputType", o());
  }
  
  protected boolean G()
  {
    int i = this.t.getInt("uintype", 0);
    int j = this.t.getInt("key_forward_ability_type");
    if (i == 10014) {
      return true;
    }
    if (f(i)) {
      return true;
    }
    if (j != g.intValue())
    {
      if (j == l.intValue()) {
        return true;
      }
      if (i != 1024) {
        return i == 1025;
      }
    }
    return true;
  }
  
  protected String H()
  {
    int i = this.t.getInt("uintype", 0);
    int j = this.t.getInt("key_forward_ability_type");
    if (f(i)) {
      return HardCodeUtil.a(2131902735);
    }
    if ((j != g.intValue()) && (j != l.intValue())) {
      return "";
    }
    return HardCodeUtil.a(2131902740);
  }
  
  @TargetApi(11)
  protected final void I()
  {
    if (k())
    {
      Z();
      return;
    }
    aw();
    int i = F();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("-->buildConfirmDialog--editTextType = ");
      ((StringBuilder)localObject1).append(i);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject1).toString());
    }
    if (i == 0)
    {
      av();
    }
    else if (i == 1)
    {
      au();
    }
    else if (i == 2)
    {
      p();
    }
    else if (i == 3)
    {
      this.A = DialogUtils.a(this.s, B(), n(), null, N(), P(), this.s.getResources().getInteger(2131492885), false);
    }
    else
    {
      Object localObject2;
      if (i == 4)
      {
        localObject1 = this.t.getString("choose_friend_content");
        localObject2 = this.t.getString("choose_friend_subcontent");
        ArrayList localArrayList = this.t.getStringArrayList("choose_friend_feedbacks");
        this.A = DialogUtils.a(this.s, B(), (String)localObject1, (String)localObject2, localArrayList, null, N(), P(), this.s.getResources().getInteger(2131492885), false);
      }
      else if (i == 5)
      {
        i = this.t.getInt("key_hiboom_id");
        this.A = DialogUtils.a(this.s, B(), "", null, N(), P(), this.s.getResources().getInteger(2131492885), false);
        localObject1 = new HiBoomTextView(this.s);
        ((HiBoomTextView)localObject1).setHiBoom(i, 0, HiBoomConstants.e);
        ((HiBoomTextView)localObject1).setText(this.u);
        ((HiBoomTextView)localObject1).setMaxSize(HiBoomConstants.a);
        localObject2 = new LinearLayout.LayoutParams(500, 500);
        ((LinearLayout.LayoutParams)localObject2).gravity = 17;
        this.A.addView((View)localObject1, (LinearLayout.LayoutParams)localObject2);
      }
      else
      {
        this.A = DialogUtils.a(this.s, B(), n(), null, N(), P(), this.s.getResources().getInteger(2131492885), false);
      }
    }
    Object localObject1 = this.A;
    if ((localObject1 instanceof QQCustomDialogWtihForwardAvatar)) {
      a((QQCustomDialogWtihForwardAvatar)localObject1);
    }
    localObject1 = H();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      this.A.setEditLint((String)localObject1);
    }
    if (this.t.getBoolean("miniAppNeedOnlyPreview", false))
    {
      ((QQCustomArkDialog)this.A).a(B());
      ((QQCustomArkDialog)this.A).a();
    }
    this.A.setOnDismissListener(this);
    this.A.adjustTitle();
    d();
    boolean bool1 = QQEmojiUtil.containsEmoji(this.u);
    boolean bool2 = QQSysFaceUtil.containsExpression(this.u);
    this.A.setMsgMaxLineWithEnd(this.u, 3, bool1, bool2);
    if (a(this.A)) {
      b(this.v, this.A);
    }
    if (this.t.getInt(M, 0) == 1) {
      this.A.setPreviewImageScaleType(true);
    }
    SimpleModeHelper.a(this.A);
    if (!this.s.isFinishing()) {
      this.A.show();
    }
  }
  
  public void J()
  {
    String str = this.t.getString("forward_ark_app_meta");
    boolean bool3 = TextUtils.isEmpty(str);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3) {
      try
      {
        new JSONObject(str);
        bool1 = true;
      }
      catch (Exception localException)
      {
        ArkAppCenter.a("ForwardOption.ForwardBaseOption", String.format("CheckMetaLegality,appMeta is parse error and msg=%s", new Object[] { localException.getMessage() }));
        bool1 = bool2;
      }
    }
    this.t.putBoolean("forward_ark_from_h5_parse_meta_success", bool1);
  }
  
  protected boolean K()
  {
    List localList = L();
    return (localList != null) && (!localList.isEmpty());
  }
  
  protected List<ResultRecord> L()
  {
    return this.a;
  }
  
  protected List<ResultRecord> M()
  {
    return this.Y;
  }
  
  protected final DialogInterface.OnClickListener N()
  {
    if (this.U == null) {
      this.U = new ForwardBaseOption.2(this);
    }
    return this.U;
  }
  
  protected boolean O()
  {
    boolean[] arrayOfBoolean = this.t.getBooleanArray("forward_is_write_together");
    int[] arrayOfInt = this.t.getIntArray("forward_write_together_base_rev");
    String str = this.t.getString("forward_source_uin");
    String[] arrayOfString1 = this.t.getStringArray("forward_write_together_pad_id");
    String[] arrayOfString2 = this.t.getStringArray("forward_write_together_token");
    if ((arrayOfBoolean != null) && (arrayOfInt != null) && (arrayOfString1 != null) && (arrayOfString2 != null))
    {
      List localList = M();
      this.af = new boolean[arrayOfBoolean.length];
      boolean bool1 = false;
      int i = 0;
      for (;;)
      {
        bool2 = bool1;
        if (i >= localList.size()) {
          break;
        }
        ResultRecord localResultRecord = (ResultRecord)localList.get(i);
        bool2 = bool1;
        if (localResultRecord.getUinType() == 1) {
          if (!localResultRecord.uin.equals(str))
          {
            bool2 = bool1;
          }
          else
          {
            int k = arrayOfBoolean.length;
            int j = 0;
            for (;;)
            {
              bool2 = bool1;
              if (j >= k) {
                break;
              }
              if (arrayOfBoolean[j] != 0)
              {
                a(arrayOfInt, str, arrayOfString1, arrayOfString2, arrayOfBoolean);
                bool2 = true;
                break;
              }
              j += 1;
            }
          }
        }
        i += 1;
        bool1 = bool2;
      }
    }
    boolean bool2 = false;
    return bool2;
  }
  
  protected final DialogInterface.OnClickListener P()
  {
    if (this.V == null) {
      this.V = new ForwardBaseOption.5(this);
    }
    return this.V;
  }
  
  protected final DialogInterface.OnClickListener Q()
  {
    if (this.X == null) {
      this.X = new ForwardBaseOption.6(this);
    }
    return this.X;
  }
  
  protected void R() {}
  
  protected void S() {}
  
  public void T()
  {
    b();
  }
  
  protected boolean U()
  {
    return true;
  }
  
  protected void V()
  {
    String str1 = this.t.getString("uin");
    String str2 = this.t.getString("troop_uin");
    int i = this.t.getInt("uintype");
    if (b(str1, str2, i))
    {
      if (i == 0) {
        i = 1;
      } else if (i == 1) {
        i = 2;
      } else if (i == 3000) {
        i = 3;
      } else {
        i = 0;
      }
      ReportController.b(this.q, "CliOper", "", "", "0X8009AAE", "0X8009AAE", i, 0, "", "", "", "");
    }
  }
  
  protected void W()
  {
    this.H = false;
    if (this.t.getBoolean("miniAppNeedOnlyPreview", false)) {
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_direct_share_fail", null, null);
    }
    if (this.t.getBoolean("avgame_share_callback_key", false)) {
      AVGameShareUtil.a().a(this.s, false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "do forwardOnCancel");
    }
  }
  
  protected void X() {}
  
  protected void Y()
  {
    this.A.setImageOnClickListener(a(new ForwardBaseOption.9(this)));
  }
  
  protected void Z()
  {
    ForwardNewVersionDialog localForwardNewVersionDialog = new ForwardNewVersionDialog(this.s);
    this.A = localForwardNewVersionDialog;
    localForwardNewVersionDialog.a(G() ^ true);
    localForwardNewVersionDialog.c(210);
    localForwardNewVersionDialog.a(a());
    localForwardNewVersionDialog.setCanceledOnTouchOutside(false);
    localForwardNewVersionDialog.a(B(), H(), this.s.getResources().getString(C()), this.s.getResources().getString(D()), N(), P());
    localForwardNewVersionDialog.a(new ForwardBaseOption.12(this));
    a(localForwardNewVersionDialog);
    if (!this.s.isFinishing()) {
      localForwardNewVersionDialog.show();
    }
    this.A.setOnDismissListener(this);
  }
  
  public float a(float paramFloat)
  {
    Display localDisplay = this.s.getWindowManager().getDefaultDisplay();
    float f2 = localDisplay.getWidth();
    float f3 = this.s.getResources().getDimensionPixelSize(2131297276);
    float f1 = paramFloat;
    if (f3 > f2 * paramFloat)
    {
      f2 = f3 / localDisplay.getWidth();
      f1 = paramFloat;
      if (f2 > paramFloat)
      {
        f1 = paramFloat;
        if (f2 < 1.0D) {
          f1 = f2;
        }
      }
    }
    return f1;
  }
  
  protected View.OnClickListener a(ForwardBaseOption.IPicDownloadCallback paramIPicDownloadCallback)
  {
    String str = this.t.getString("uin");
    if (this.W == null) {
      this.W = new ForwardBaseOption.7(this, str, paramIPicDownloadCallback);
    }
    return this.W;
  }
  
  protected View a()
  {
    return null;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    boolean bool = as();
    ArrayList localArrayList = new ArrayList();
    RecentUser localRecentUser;
    if ((bool) && (this.R == 2))
    {
      localRecentUser = new RecentUser(AppConstants.DATALINE_PC_UIN, 6000);
      localRecentUser.displayName = HardCodeUtil.a(2131892059);
      localArrayList.add(localRecentUser);
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localRecentUser = (RecentUser)paramList.next();
      if ((bool) && (this.R == 1) && (localRecentUser != null) && (TextUtils.equals(localRecentUser.uin, AppConstants.DATALINE_PC_UIN))) {
        localArrayList.add(localRecentUser);
      } else if (a(localRecentUser)) {
        localArrayList.add(localRecentUser);
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("getForwardRecentList result size is: ");
      paramList.append(localArrayList.size());
      QLog.i("ForwardOption.ForwardBaseOption", 2, paramList.toString());
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    if (this.aa == null) {
      this.aa = new QQProgressDialog(this.s, this.I.getResources().getDimensionPixelSize(2131299920));
    }
    this.aa.c(paramInt);
    if (!this.s.isFinishing()) {
      this.aa.show();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (!E()) {
      return;
    }
    if (paramInt >= 0) {
      this.t.putInt("key_forward_ability_type", paramInt);
    }
    if (paramBundle != null)
    {
      this.O = paramBundle.getBoolean("from_outside_share", false);
      this.P = paramBundle.getBoolean("from_dataline_aio", false);
      ((IShareReport)QRoute.api(IShareReport.class)).setUinType(String.valueOf(this.t.getInt("uintype")));
      this.Q = paramBundle.getString("caller_name", "");
      this.t.putAll(paramBundle);
    }
    this.a = this.t.getParcelableArrayList("forward_multi_target");
    this.Y = new ArrayList();
    this.ad = new ArrayList();
    paramBundle = this.a;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)paramBundle.next();
        if ((localResultRecord.uinType != 6000) && (localResultRecord.uinType != 6003)) {
          this.Y.add(localResultRecord);
        } else {
          this.ad.add(localResultRecord);
        }
      }
    }
    I();
  }
  
  protected void a(Intent paramIntent) {}
  
  protected void a(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramBoolean) {
      URLDrawableHelper.decodeLocalImage((URLDrawable)paramDrawable, this.q.getCurrentAccountUin(), true);
    }
    if (paramDrawable == null) {
      return;
    }
    if (!paramBoolean) {
      paramDrawable.setBounds(ImageUtil.a(paramDrawable, 36, 100, this.z));
    }
  }
  
  protected void a(Drawable paramDrawable, boolean paramBoolean, int paramInt)
  {
    a(paramDrawable, paramBoolean, paramInt, false);
  }
  
  protected void a(Drawable paramDrawable, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.s.runOnUiThread(new ForwardBaseOption.10(this, paramDrawable, paramBoolean1, paramInt, paramBoolean2));
  }
  
  public void a(Bundle paramBundle)
  {
    QQCustomDialog localQQCustomDialog = this.A;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      paramBundle.putBundle("key_forward_base_option_bundle", this.t);
    }
  }
  
  protected void a(Bundle paramBundle, AIOImageProviderService paramAIOImageProviderService, AIORichMediaData paramAIORichMediaData)
  {
    PeakUtils.a(this.s, paramBundle, paramAIOImageProviderService, paramAIORichMediaData, 19001, 4);
  }
  
  protected void a(Bundle paramBundle, String paramString, DirectForwarder.CallBack paramCallBack)
  {
    paramBundle = this.A;
    if ((paramBundle instanceof QQCustomDialogWtihEmoticonInput)) {
      paramBundle = ((QQCustomDialogWtihEmoticonInput)paramBundle).getInputValue();
    } else if ((paramBundle instanceof ForwardNewVersionDialog)) {
      paramBundle = ((ForwardNewVersionDialog)paramBundle).getInputValue();
    } else {
      paramBundle = "";
    }
    if (QFileAssistantUtils.a(this.q))
    {
      a(paramBundle, paramString, paramCallBack);
      return;
    }
    b(paramBundle, paramString, paramCallBack);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.q = paramQQAppInterface;
    this.s = paramActivity;
    this.z = this.s.getResources().getDisplayMetrics().density;
  }
  
  public void a(ForwardBaseOption.EventListener paramEventListener)
  {
    this.T.add(paramEventListener);
  }
  
  protected void a(QQCustomDialogWtihForwardAvatar paramQQCustomDialogWtihForwardAvatar)
  {
    if (paramQQCustomDialogWtihForwardAvatar == null) {
      return;
    }
    Object localObject1 = L();
    Object localObject2;
    if (localObject1 == null)
    {
      int i = this.t.getInt("uintype", 0);
      if (i == 10014)
      {
        localObject1 = this.t;
        localObject2 = "guild_id";
      }
      else
      {
        localObject1 = this.t;
        localObject2 = "uin";
      }
      localObject1 = ((Bundle)localObject1).getString((String)localObject2);
      boolean bool = this.t.getBoolean("new_create_troop", false);
      localObject2 = B();
      if (((f(i)) || (i == 10014)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
        paramQQCustomDialogWtihForwardAvatar.a(this.q, this.s, (String)localObject1, i, a((String)localObject2), bool);
      }
    }
    else
    {
      if (((List)localObject1).size() == 1)
      {
        localObject2 = (ResultRecord)((List)localObject1).get(0);
        if (((ResultRecord)localObject2).uinType == 10014) {
          localObject1 = ((ResultRecord)localObject2).guildId;
        } else {
          localObject1 = ((ResultRecord)localObject2).uin;
        }
        paramQQCustomDialogWtihForwardAvatar.a(this.q, this.s, (String)localObject1, ((ResultRecord)localObject2).getUinType(), ((ResultRecord)localObject2).name, false);
        return;
      }
      paramQQCustomDialogWtihForwardAvatar.a(this.q, this.s, (List)localObject1, true);
    }
  }
  
  protected final void a(String paramString, QQCustomDialog paramQQCustomDialog)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addSourceNameView start! sourceName =");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramString != null) && (!"".equals(paramString)))
    {
      if (paramQQCustomDialog == null) {
        return;
      }
      localObject = new TextView(this.s);
      ((TextView)localObject).setText(paramString);
      ((TextView)localObject).setTextSize(12.0F);
      ((TextView)localObject).setPadding(0, 0, 0, 0);
      ((TextView)localObject).setIncludeFontPadding(false);
      ((TextView)localObject).setTextColor(-8355712);
      paramQQCustomDialog.addView((View)localObject);
    }
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    this.H = true;
    Bundle localBundle = new Bundle();
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    localBundle.putString("uin", paramString1);
    localBundle.putInt("uintype", 1);
    localBundle.putBoolean("new_create_troop", true);
    paramString1 = new StringBuilder();
    paramString1.append(HardCodeUtil.a(2131902738));
    paramString1.append(paramString2);
    localBundle.putString("uinname", paramString1.toString());
    a(ForwardAbility.ForwardAbilityType.e.intValue(), localBundle);
  }
  
  protected void a(String paramString1, String paramString2, DirectForwarder.CallBack paramCallBack)
  {
    paramString1 = this.t.getString("uin");
    int i = this.t.getInt("uintype");
    b(paramString1, this.t.getString("troop_uin"), i);
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2)
  {
    if (paramInt2 != g.intValue())
    {
      if (paramInt2 == l.intValue()) {
        return false;
      }
      if (this.F) {
        return false;
      }
      if (!(this instanceof ForwardSendHongBaoOption))
      {
        if ((this instanceof ForwardChooseFriendOption)) {
          return false;
        }
        if (this.t.getInt("cmshow_game_id") > 0) {
          return false;
        }
        boolean bool1 = this.r.getBooleanExtra("forward_source_from_shoot_quick", false);
        boolean bool2 = this.r.getBooleanExtra("forward_source_from_pre_guide", false);
        if (!bool1)
        {
          if (bool2) {
            return false;
          }
          if (paramInt1 == 1)
          {
            bool2 = ((TroopGagMgr)this.q.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(paramString, true).b ^ true;
            bool1 = bool2;
            if (bool2)
            {
              bool1 = bool2;
              if ((this instanceof ForwardFileOption))
              {
                paramString = (ForwardFileOption)this;
                bool1 = bool2;
                if (paramString.ad != null)
                {
                  bool1 = bool2;
                  if (paramString.ad.c() == 10006) {
                    return false;
                  }
                }
              }
            }
          }
          else
          {
            bool1 = true;
          }
          return bool1;
        }
      }
    }
    return false;
  }
  
  protected boolean a(LightAppSettingInfo paramLightAppSettingInfo)
  {
    if (paramLightAppSettingInfo == null) {
      return false;
    }
    paramLightAppSettingInfo = paramLightAppSettingInfo.e;
    if (paramLightAppSettingInfo == null) {
      return false;
    }
    Bundle localBundle = this.t;
    if (localBundle == null) {
      return false;
    }
    int i = localBundle.getInt("req_type");
    if (i != 1)
    {
      if ((i == 2) && (paramLightAppSettingInfo.contains(Integer.valueOf(11003)))) {
        return true;
      }
    }
    else if (paramLightAppSettingInfo.contains(Integer.valueOf(11005))) {
      return true;
    }
    return false;
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    return true;
  }
  
  public boolean a(Integer paramInteger)
  {
    Set localSet = this.C;
    return (localSet != null) && (localSet.contains(paramInteger));
  }
  
  protected boolean a(String paramString, int paramInt)
  {
    boolean[] arrayOfBoolean = this.t.getBooleanArray("forward_is_write_together");
    int[] arrayOfInt = this.t.getIntArray("forward_write_together_base_rev");
    String str = this.t.getString("forward_source_uin");
    String[] arrayOfString1 = this.t.getStringArray("forward_write_together_pad_id");
    String[] arrayOfString2 = this.t.getStringArray("forward_write_together_token");
    if (paramInt == 1)
    {
      if (!paramString.equals(str)) {
        return false;
      }
      if ((arrayOfBoolean != null) && (arrayOfInt != null) && (arrayOfString1 != null) && (arrayOfString2 != null))
      {
        this.af = new boolean[arrayOfBoolean.length];
        int i = arrayOfBoolean.length;
        paramInt = 0;
        while (paramInt < i)
        {
          if (arrayOfBoolean[paramInt] != 0)
          {
            a(arrayOfInt, str, arrayOfString1, arrayOfString2, arrayOfBoolean);
            return true;
          }
          paramInt += 1;
        }
      }
      return false;
    }
    return false;
  }
  
  protected boolean a(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(this.t);
    this.s.setResult(-1, localIntent);
    if (paramBoolean) {
      this.s.finish();
    }
    return false;
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    return null;
  }
  
  public void aa()
  {
    int i = h();
    if (this.s.isFinishing()) {
      return;
    }
    d(i);
  }
  
  protected void ab()
  {
    this.t.putBoolean("isBack2Root", true);
    if (this.t.getInt("uintype") == 6002)
    {
      e(this.t.getString("uin"));
      return;
    }
    if (!f()) {
      ReportController.b(this.q, "CliOper", "", "", "0X8004047", "0X8004047", 0, 0, "", "", "", "");
    }
  }
  
  public boolean ac()
  {
    return true;
  }
  
  public void ad()
  {
    QQCustomDialog localQQCustomDialog = this.A;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      this.A.dismiss();
    }
    this.q.removeObserver(this.ab);
  }
  
  public void ae()
  {
    QQProgressDialog localQQProgressDialog = this.aa;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.aa.dismiss();
    }
  }
  
  protected boolean af()
  {
    boolean bool2 = TextUtils.isEmpty(this.q.getAccount());
    boolean bool1 = true;
    if (bool2)
    {
      QLog.e("ForwardOption.ForwardBaseOption", 1, "-->allowPhoneContactAbility--allow = false, uin is empty");
      return false;
    }
    Object localObject = (IPhoneContactService)this.q.getRuntimeService(IPhoneContactService.class, "");
    if ((localObject == null) || (!((IPhoneContactService)localObject).isBindContactOk())) {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-->allowPhoneContactAbility--allow = ");
      ((StringBuilder)localObject).append(bool1);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  protected boolean ag()
  {
    Object localObject = (DiscussionManager)this.q.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if (localObject != null)
    {
      localObject = ((DiscussionManager)localObject).b();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        bool = true;
        break label41;
      }
    }
    boolean bool = false;
    label41:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-->allowDiscussAbility--allow = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  protected boolean ah()
  {
    Object localObject = (TroopManager)this.q.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).g();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        bool = true;
        break label41;
      }
    }
    boolean bool = false;
    label41:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-->allowTroopAbility--allow = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  protected boolean ai()
  {
    Object localObject = (FriendsManager)this.q.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject != null)
    {
      localObject = ((FriendsManager)localObject).k();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((Groups)((Iterator)localObject).next()).group_friend_count > 0)
          {
            bool = true;
            break label68;
          }
        }
      }
    }
    boolean bool = false;
    label68:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-->allowFriendAbility--allow = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  protected boolean aj()
  {
    Object localObject = this.r;
    boolean bool2 = false;
    boolean bool1 = ((Intent)localObject).getBooleanExtra("sendMultiple", false);
    int i;
    if (MultiMsgManager.a().f() > 1) {
      i = 1;
    } else {
      i = 0;
    }
    int j = this.t.getInt("from_busi_type");
    if ((!bool1) && (i == 0) && (j != 2))
    {
      localObject = (SmartDeviceProxyMgr)this.q.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((SmartDeviceProxyMgr)localObject).c())
        {
          localObject = ((SmartDeviceProxyMgr)localObject).e();
          bool1 = bool2;
          if (localObject != null)
          {
            bool1 = bool2;
            if (localObject.length > 0) {
              bool1 = true;
            }
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("-->allowSmartDeviceAbility--allow = ");
        ((StringBuilder)localObject).append(bool1);
        QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
      }
      return bool1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowSmartDeviceAbility--allow = false");
    }
    return false;
  }
  
  protected void ak() {}
  
  public Bundle al()
  {
    return this.t;
  }
  
  public int am()
  {
    return c(this.t);
  }
  
  public void an()
  {
    int i = am();
    String str = this.t.getString("forward_source_sub_business_type", "");
    int j = e(this.t.getInt("forward_type", 2147483647));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportShowForwardRecent srcBusinessType = ");
      localStringBuilder.append(i);
      localStringBuilder.append(",srcSubBusinessType = ");
      localStringBuilder.append(str);
      QLog.d("ForwardOption.ForwardBaseOption", 2, localStringBuilder.toString());
    }
    ReportController.b(this.q, "dc00898", "", "", "0X800A7EB", "0X800A7EB", i, 0, "", "", String.valueOf(j), str);
  }
  
  public void ao()
  {
    Object localObject3 = this;
    if (((ForwardBaseOption)localObject3).t == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "reportFinalSelectedTargets return, mExtraData is null");
      }
      return;
    }
    if (ac == null) {
      ac = new SimpleDateFormat("yyyyMMddHHmmss");
    }
    int j = am();
    String str3 = ((ForwardBaseOption)localObject3).t.getString("forward_source_sub_business_type", "");
    Object localObject1 = ac.format(Long.valueOf(System.currentTimeMillis()));
    int k = ((ForwardBaseOption)localObject3).t.getInt("forward_type", 2147483647);
    int i = ((ForwardBaseOption)localObject3).e(k);
    boolean bool = QLog.isColorLevel();
    String str1 = ",srcSubBusinessType = ";
    if (bool)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("reportFinalSelectedTargets srcBusinessType = ");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(",srcSubBusinessType = ");
      ((StringBuilder)localObject2).append(str3);
      ((StringBuilder)localObject2).append(",forwardType = ");
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append(",forwardMsgType = ");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(",operateTime = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject4 = ((ForwardBaseOption)localObject3).a;
    Object localObject2 = ",forwardTargetType = ";
    String str2 = ",targetUinType = ";
    if ((localObject4 != null) && (((ArrayList)localObject4).size() > 0))
    {
      localObject4 = ((ForwardBaseOption)localObject3).a.iterator();
      for (;;)
      {
        localObject3 = this;
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject4).next();
        String str4 = localResultRecord.uin;
        k = localResultRecord.uinType;
        m = ((ForwardBaseOption)localObject3).b(str4, k);
        ReportController.b(((ForwardBaseOption)localObject3).q, "dc00898", "", str4, "0X800A7EC", "0X800A7EC", j, 0, (String)localObject1, String.valueOf(m), String.valueOf(i), str3);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("reportFinalSelectedTargets multi,,targetUin = ");
          ((StringBuilder)localObject3).append(str4);
          ((StringBuilder)localObject3).append(str2);
          ((StringBuilder)localObject3).append(k);
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append(m);
          ((StringBuilder)localObject3).append(str1);
          ((StringBuilder)localObject3).append(str3);
          QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject3).toString());
        }
      }
    }
    k = this.t.getInt("uintype");
    str1 = this.t.getString("uin");
    int m = b(str1, k);
    ReportController.b(this.q, "dc00898", "", str1, "0X800A7EC", "0X800A7EC", j, 0, (String)localObject1, String.valueOf(m), String.valueOf(i), str3);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reportFinalSelectedTargets single,,targetUin = ");
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append(",targetUinType = ");
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append(",forwardTargetType = ");
      ((StringBuilder)localObject1).append(m);
      ((StringBuilder)localObject1).append(",srcSubBusinessType = ");
      ((StringBuilder)localObject1).append(str3);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void ap()
  {
    ForwardBaseOption localForwardBaseOption = this;
    if (ac == null) {
      ac = new SimpleDateFormat("yyyyMMddHHmmss");
    }
    int k = am();
    Object localObject1 = localForwardBaseOption.t;
    String str3 = "";
    String str4 = ((Bundle)localObject1).getString("forward_source_sub_business_type", "");
    String str1 = ac.format(Long.valueOf(System.currentTimeMillis()));
    int i = -1;
    int m = localForwardBaseOption.t.getInt("forward_type", 2147483647);
    int j = localForwardBaseOption.e(m);
    localObject1 = localForwardBaseOption.A;
    if ((localObject1 instanceof QQCustomDialogWtihEmoticonInput)) {
      localObject1 = ((QQCustomDialogWtihEmoticonInput)localObject1).getInputValue();
    } else if ((localObject1 instanceof ForwardNewVersionDialog)) {
      localObject1 = ((ForwardNewVersionDialog)localObject1).getInputValue();
    } else {
      localObject1 = "";
    }
    boolean bool1 = TextUtils.isEmpty((CharSequence)localObject1) ^ true;
    boolean bool2 = QLog.isColorLevel();
    Object localObject2 = ",srcSubBusinessType = ";
    Object localObject3 = "ForwardOption.ForwardBaseOption";
    if (bool2)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reportClickSend srcBusinessType = ");
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append(",srcSubBusinessType = ");
      ((StringBuilder)localObject1).append(str4);
      ((StringBuilder)localObject1).append(",forwardType = ");
      ((StringBuilder)localObject1).append(m);
      ((StringBuilder)localObject1).append(",forwardMsgType = ");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(",hasLeftAMessage = ");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(",operateTime = ");
      ((StringBuilder)localObject1).append(str1);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject4 = localForwardBaseOption.a;
    String str2 = ",forwardTargetType = ";
    str1 = ",targetUinType = ";
    localObject1 = "1";
    if ((localObject4 != null) && (((ArrayList)localObject4).size() > 0))
    {
      localObject4 = localForwardBaseOption.a.iterator();
      for (localObject1 = str3; ((Iterator)localObject4).hasNext(); localObject1 = str3)
      {
        localObject1 = (ResultRecord)((Iterator)localObject4).next();
        str3 = ((ResultRecord)localObject1).uin;
        m = ((ResultRecord)localObject1).uinType;
        i = localForwardBaseOption.b(str3, m);
        QQAppInterface localQQAppInterface = localForwardBaseOption.q;
        if (bool1) {
          localObject1 = "1";
        } else {
          localObject1 = "2";
        }
        ReportController.b(localQQAppInterface, "dc00898", "", str3, "0X800A7ED", "0X800A7ED", k, 0, (String)localObject1, String.valueOf(i), String.valueOf(j), str4);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("reportClickSend multi,,targetUin = ");
          ((StringBuilder)localObject1).append(str3);
          ((StringBuilder)localObject1).append(str1);
          ((StringBuilder)localObject1).append(m);
          ((StringBuilder)localObject1).append(str2);
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(str4);
          QLog.d((String)localObject3, 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
    else
    {
      localForwardBaseOption.t.getInt("forward_source_uin_type");
      m = localForwardBaseOption.t.getInt("uintype");
      localObject2 = localForwardBaseOption.t.getString("uin");
      i = localForwardBaseOption.b((String)localObject2, m);
      localObject3 = localForwardBaseOption.q;
      if (!bool1) {
        localObject1 = "2";
      }
      ReportController.b((AppRuntime)localObject3, "dc00898", "", (String)localObject2, "0X800A7ED", "0X800A7ED", k, 0, (String)localObject1, String.valueOf(i), String.valueOf(j), str4);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("reportClickSend single,,targetUin = ");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(",targetUinType = ");
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append(",forwardTargetType = ");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(",srcSubBusinessType = ");
        ((StringBuilder)localObject1).append(str4);
        QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = localObject2;
    }
    localObject2 = this;
    if (2 == ((ForwardBaseOption)localObject2).t.getInt("req_type")) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((ForwardBaseOption)localObject2).a(bool1, "music".equals(((ForwardBaseOption)localObject2).t.getString("forward_ark_app_view")), i, (String)localObject1);
    ((ForwardBaseOption)localObject2).a(((ForwardBaseOption)localObject2).t, i, (String)localObject1);
  }
  
  public void aq()
  {
    ReportController.b(this.q, "dc00898", "", "", "0X8009BE9", "0X8009BE9", this.L, 0, "", "", "", "");
  }
  
  public void ar()
  {
    ReportController.b(this.q, "dc00898", "", "", "0X8009BEA", "0X8009BEA", this.L, 0, "", "", "", "");
    ap();
  }
  
  public boolean as()
  {
    Intent localIntent = this.r;
    if (localIntent == null) {
      return false;
    }
    int i = localIntent.getIntExtra("key_req", -1);
    if (i != 1) {
      return i == 2;
    }
    return true;
  }
  
  public QQAppInterface at()
  {
    return this.q;
  }
  
  int b(String paramString, int paramInt)
  {
    boolean bool = AppConstants.DATALINE_PC_UIN.equals(paramString);
    int i = 1;
    if (bool) {
      return 4;
    }
    if ("-1010".equals(paramString)) {
      return 6;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3000)
        {
          if (ChatActivityUtils.a(paramInt)) {
            return 3;
          }
          return 100;
        }
        return 7;
      }
      return 2;
    }
    paramInt = i;
    if (this.q.getCurrentAccountUin().equals(paramString)) {
      paramInt = 5;
    }
    return paramInt;
  }
  
  protected void b()
  {
    boolean bool = K();
    int i = 0;
    if (bool)
    {
      List localList = M();
      if ((localList != null) && (!localList.isEmpty()))
      {
        int j = localList.size();
        while (i < j)
        {
          ResultRecord localResultRecord = (ResultRecord)localList.get(i);
          if (U()) {
            b(localResultRecord.uin, localResultRecord.groupUin, localResultRecord.getUinType());
          }
          i += 1;
        }
        this.t.putBoolean("isBack2Root", true);
        f();
      }
    }
    else
    {
      ar();
      if (this.H)
      {
        ReportController.b(this.q, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
        this.H = false;
      }
      if (U()) {
        V();
      }
      ab();
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-->forwardToDataLine--type = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool1 = this.r.getBooleanExtra("isJumpAIO", false);
    boolean bool2 = this.r.getBooleanExtra("forward_source_from_shoot_quick", false);
    boolean bool3 = this.r.getBooleanExtra("forward_source_from_pre_guide", false);
    if ((!bool1) && (!bool2) && (!bool3))
    {
      Bundle localBundle = new Bundle();
      localObject = AppConstants.DATALINE_PC_UIN;
      if (paramInt == l.intValue()) {
        localObject = AppConstants.DATALINE_IPAD_UIN;
      }
      localBundle.putAll(this.t);
      Intent localIntent = new Intent();
      ForwardBaseOption.13 local13 = new ForwardBaseOption.13(this);
      DataLineHandler localDataLineHandler = (DataLineHandler)this.q.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      if (this.r.getBooleanExtra("sendMultiple", false))
      {
        a(localIntent);
        localBundle.putAll(localIntent.getExtras());
        paramInt = localDataLineHandler.n().a((String)localObject, localBundle, local13);
        a(localBundle, (String)localObject, null);
      }
      else
      {
        b(localIntent);
        localBundle.putAll(localIntent.getExtras());
        paramInt = localDataLineHandler.n().b((String)localObject, localBundle, local13);
        a(localBundle, (String)localObject, null);
      }
      if ((!K()) && (paramInt == 0))
      {
        DirectForwarder.b(this.s, paramInt);
        this.r.putExtra("NOCANCEL4DATALIN", true);
        if (am() == 100200) {
          this.s.setResult(-1, this.r);
        } else {
          this.s.setResult(0, this.r);
        }
        this.s.finish();
      }
      return;
    }
    if ((bool2) || (bool3))
    {
      this.t.remove("PhotoConst.SEND_FLAG");
      this.r.removeExtra("PhotoConst.SEND_FLAG");
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->forwardToDataLine jumpAIO ");
    }
    c(paramInt);
  }
  
  protected void b(Intent paramIntent) {}
  
  public void b(Bundle paramBundle)
  {
    paramBundle = paramBundle.getBundle("key_forward_base_option_bundle");
    if (paramBundle != null) {
      a(paramBundle.getInt("key_forward_ability_type", ForwardAbility.ForwardAbilityType.b.intValue()), paramBundle);
    }
  }
  
  protected void b(QQCustomDialog paramQQCustomDialog) {}
  
  public void b(String paramString)
  {
    Bundle localBundle = this.t;
    if (localBundle != null) {
      localBundle.remove(paramString);
    }
  }
  
  protected final void b(String paramString, QQCustomDialog paramQQCustomDialog)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateImageView: filepath=");
      localStringBuilder.append(paramString);
      QLog.d("ForwardOption.ForwardBaseOption", 2, localStringBuilder.toString());
    }
    ThreadManager.post(new ForwardBaseOption.11(this, paramString, paramQQCustomDialog), 8, null, false);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "updateImageView end! ");
    }
  }
  
  protected void b(String paramString1, String paramString2, DirectForwarder.CallBack paramCallBack)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.q.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (!TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sendDataLineMessage: invoked.  textAndEmoji: ");
        ((StringBuilder)localObject).append(paramString1);
        QLog.i("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
      }
      b(new Intent());
      Object localObject = new Bundle();
      ((Bundle)localObject).putBoolean("sendMultiple", false);
      ((Bundle)localObject).putInt("dataline_forward_type", 102);
      ((Bundle)localObject).putString("dataline_forward_text", paramString1);
      int i = localDataLineHandler.n().b(paramString2, (Bundle)localObject, paramCallBack);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("sendDataLineMessage: invoked.  noteRet: ");
        paramString1.append(i);
        QLog.i("ForwardOption.ForwardBaseOption", 2, paramString1.toString());
      }
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  protected boolean b(String paramString1, String paramString2, int paramInt)
  {
    Object localObject1 = this.A;
    if ((localObject1 instanceof QQCustomDialogWtihEmoticonInput)) {
      localObject1 = ((QQCustomDialogWtihEmoticonInput)localObject1).getInputValue();
    } else if ((localObject1 instanceof ForwardNewVersionDialog)) {
      localObject1 = ((ForwardNewVersionDialog)localObject1).getInputValue();
    } else {
      localObject1 = "";
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sendMessageOnConfirm: invoked.  textAndEmoji: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject2).toString());
      }
      this.t.putString("share_comment_message", (String)localObject1);
      int i = ForwardOrderManager.a().b();
      if (K())
      {
        int[] arrayOfInt = this.t.getIntArray("KEY_MSG_FORWARD_ID_ARRAY");
        this.t.remove("KEY_MSG_FORWARD_ID_ARRAY");
        if (arrayOfInt != null)
        {
          localObject2 = new int[arrayOfInt.length + 1];
          if (arrayOfInt.length > 0) {
            System.arraycopy(arrayOfInt, 0, localObject2, 0, arrayOfInt.length);
          }
          localObject2[arrayOfInt.length] = i;
        }
        else
        {
          localObject2 = new int[1];
          localObject2[0] = i;
        }
        this.t.putIntArray("KEY_MSG_FORWARD_ID_ARRAY", (int[])localObject2);
      }
      else
      {
        this.t.putInt("KEY_MSG_FORWARD_ID", i);
      }
      Object localObject2 = new SessionInfo();
      ((SessionInfo)localObject2).a = paramInt;
      ((SessionInfo)localObject2).b = paramString1;
      ((SessionInfo)localObject2).c = paramString2;
      if (!(this instanceof ForwardShareCardOption)) {
        ForwardOrderManager.a().a((SessionInfo)localObject2, (String)localObject1, i);
      }
      return true;
    }
    return false;
  }
  
  protected void c()
  {
    if (ai()) {
      this.C.add(c);
    }
    if (ag()) {
      this.C.add(e);
    }
    if (ah()) {
      this.C.add(d);
    }
    if (af()) {
      this.C.add(i);
    }
    if (q()) {
      this.C.add(f);
    }
    this.C.add(j);
  }
  
  protected void c(int paramInt)
  {
    Intent localIntent = new Intent(this.s, LiteActivity.class);
    if (paramInt == l.intValue())
    {
      localIntent.putExtra("targetUin", AppConstants.DATALINE_IPAD_UIN);
      localIntent.putExtra("device_type", 1);
    }
    else
    {
      localIntent.putExtra("targetUin", AppConstants.DATALINE_PC_UIN);
      localIntent.putExtra("device_type", 0);
    }
    if (this.r.getBooleanExtra("isFromShare", false))
    {
      this.t.putString("leftBackText", HardCodeUtil.a(2131902731));
      localIntent.addFlags(268435456);
      localIntent.addFlags(67108864);
      this.t.putBoolean("isBack2Root", true);
    }
    localIntent.putExtras(this.t);
    localIntent.putExtra("MigSdkShareNotDone", false);
    if (this.r.getBooleanExtra("sendMultiple", false)) {
      a(localIntent);
    } else {
      b(localIntent);
    }
    this.s.startActivity(localIntent);
    this.t.putBoolean("isBack2Root", false);
    localIntent.putExtras(this.t);
    this.s.setResult(0, localIntent);
    this.s.finish();
  }
  
  protected boolean c(Intent paramIntent)
  {
    boolean bool2 = this.t.getBoolean("isFromFavorites");
    boolean bool1 = bool2;
    if (!bool2)
    {
      String str = this.t.getString("app_name");
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        bool1 = bool2;
        if (str.equals(this.s.getString(2131889193))) {
          bool1 = true;
        }
      }
    }
    if (bool1)
    {
      this.t.putBoolean("isBack2Root", true);
      this.t.putString("leftBackText", this.s.getString(2131917002));
      paramIntent.putExtras(this.t);
    }
    bool2 = this.t.getBoolean("isFromAIOPlus");
    return (bool1) && (bool2);
  }
  
  public boolean c(String paramString)
  {
    HotChatManager localHotChatManager = (HotChatManager)this.q.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    return (localHotChatManager != null) && (localHotChatManager.b(paramString));
  }
  
  protected void d()
  {
    if (TextUtils.isEmpty(this.u)) {
      return;
    }
    this.A.setMessageWithEmo(this.u, this.z);
  }
  
  protected void d(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-->showQfavResultDialog--code = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.A;
    if ((localObject != null) && (((QQCustomDialog)localObject).isShowing())) {
      this.A.dismiss();
    }
    ae();
    ForwardBaseOption.14 local14 = new ForwardBaseOption.14(this);
    localObject = this.B;
    if (localObject == null) {
      this.B = new ShareResultDialog(this.s);
    } else {
      ((ShareResultDialog)localObject).dismiss();
    }
    String str = this.s.getString(2131887625);
    localObject = str;
    if (!TextUtils.isEmpty(this.t.getString("app_name")))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(this.t.getString("app_name"));
      localObject = ((StringBuilder)localObject).toString();
    }
    this.B.a((String)localObject, local14);
    this.B.a(2131889090);
    localObject = this.B;
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((ShareResultDialog)localObject).a(bool);
    this.B.a(2131916566);
    this.B.b(0);
    this.B.c(2131916567);
    this.B.b(this.s.getString(2131892321), local14);
    try
    {
      this.B.show();
      return;
    }
    catch (Exception localException)
    {
      label269:
      break label269;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->showQfavResultDialog--resultDlg.show() failed");
    }
  }
  
  protected void d(String paramString) {}
  
  int e(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 100;
    case 27: 
    case 35: 
    case 38: 
    case 39: 
    case 46: 
      return 11;
    case 24: 
      return 9;
    case 21: 
      return 4;
    case 20: 
    case 23: 
      return 8;
    case 14: 
      return 7;
    case 8: 
      return 3;
    case 3: 
      return 5;
    case 1: 
      return 2;
    case -1: 
      return 1;
    case -3: 
    case 1001: 
      return 10;
    }
    return 6;
  }
  
  protected void e(String paramString)
  {
    Object localObject1 = (SmartDeviceProxyMgr)this.q.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    Object localObject2 = ((SmartDeviceProxyMgr)localObject1).g(Long.parseLong(paramString));
    ((SmartDeviceProxyMgr)localObject1).a(this.s, (DeviceInfo)localObject2, false);
    String str = this.r.getStringExtra("forward_filepath");
    localObject1 = (RouterHandler)this.q.getBusinessHandler(BusinessHandlerFactory.ROUTER_HANDLER);
    localObject2 = new ArrayList();
    try
    {
      ((ArrayList)localObject2).add(new FileInfo(str));
      label81:
      ((RouterHandler)localObject1).a((ArrayList)localObject2, null, null, Long.parseLong(paramString));
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      break label81;
    }
  }
  
  public boolean e()
  {
    this.v = this.r.getStringExtra("forward_thumb");
    this.w = this.r.getBooleanExtra("forward_urldrawable", false);
    this.x = this.r.getStringExtra("forward_urldrawable_thumb_url");
    this.y = this.r.getStringExtra("forward_urldrawable_big_url");
    this.u = this.r.getStringExtra("forward_text");
    this.K = this.r.getBooleanExtra("forward_from_jump", false);
    this.R = this.r.getIntExtra("key_share_data_line_support_type", 0);
    Bundle localBundle = this.t;
    if (localBundle != null)
    {
      if (localBundle.getInt("forward_type", -1) == 11) {
        this.F = true;
      }
      this.G = this.t.getLong("req_share_id", 0L);
    }
    x();
    return true;
  }
  
  protected boolean f()
  {
    if (K()) {
      return a(false);
    }
    return a(true);
  }
  
  protected void g() {}
  
  protected int h()
  {
    return -1;
  }
  
  public void i()
  {
    Object localObject = this.A;
    if ((localObject instanceof QQCustomArkDialog)) {
      ((QQCustomArkDialog)localObject).a(1);
    }
    localObject = this.N;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      this.N.dismiss();
    }
  }
  
  public void j()
  {
    QQCustomDialog localQQCustomDialog = this.A;
    if ((localQQCustomDialog instanceof QQCustomArkDialog)) {
      ((QQCustomArkDialog)localQQCustomDialog).a(0);
    }
  }
  
  protected boolean k()
  {
    return false;
  }
  
  public boolean l()
  {
    return false;
  }
  
  public void m()
  {
    ReportController.b(this.q, "CliOper", "", "", "0X8005A0F", "0X8005A0F", 0, 0, "0", "", "", "");
  }
  
  public String n()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DialogContent:mForwardText=");
      localStringBuilder.append(this.u);
      QLog.d("ForwardOption.ForwardBaseOption", 2, localStringBuilder.toString());
    }
    return this.u;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    boolean bool = this.s instanceof DirectForwardActivity;
    int j = 0;
    int i;
    if (((!bool) || (this.S)) && ((this.s.getIntent() == null) || (!this.s.getIntent().getBooleanExtra("key_share_from_screen_need_finish", false))))
    {
      i = j;
      if (this.s.getIntent() != null)
      {
        i = j;
        if (this.s.getIntent().getIntExtra("key_req", -1) != 1) {}
      }
    }
    else
    {
      i = 1;
    }
    if (i != 0) {
      this.s.finish();
    }
    if ((this.A instanceof QQCustomArkDialog)) {
      QLog.d("ForwardOption.ForwardBaseOption", 1, "QQCustomArkDialog dismiss");
    }
  }
  
  protected boolean q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowQZoneAbility--allow = false");
    }
    return false;
  }
  
  public boolean r()
  {
    return false;
  }
  
  public void s()
  {
    Iterator localIterator = this.T.iterator();
    while (localIterator.hasNext()) {
      ((ForwardBaseOption.EventListener)localIterator.next()).a(this);
    }
  }
  
  public boolean t()
  {
    return this.K;
  }
  
  public String u()
  {
    String str2 = this.r.getStringExtra("k_forward_title");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = HardCodeUtil.a(2131902741);
    }
    return str1;
  }
  
  public void v()
  {
    Bundle localBundle = this.t;
    if ((localBundle != null) && (localBundle.getBoolean("k_forward_show_direct_share_tips", false))) {
      ReportController.b(this.q, "dc00898", "", "", "0X800A220", "0X800A220", 0, 0, "0", "", "", "");
    }
    ao();
  }
  
  public void w() {}
  
  void x()
  {
    if (D <= 0)
    {
      Display localDisplay = ((WindowManager)this.I.getSystemService("window")).getDefaultDisplay();
      int i = this.I.getResources().getDimensionPixelSize(2131298138);
      int j = this.I.getResources().getDimensionPixelSize(2131298140);
      D = (localDisplay.getWidth() - i * 2 - j * 3) / 4;
    }
  }
  
  public Set<Integer> y()
  {
    if (this.C == null)
    {
      this.C = new HashSet();
      c();
    }
    return this.C;
  }
  
  public void z()
  {
    this.C = new HashSet();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption
 * JD-Core Version:    0.7.0.1
 */