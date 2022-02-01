package com.tencent.mobileqq.msgforward;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.FileProvider;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.helper.MultiForwardHelper;
import com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgUtil;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.util.DatalineDeviceChooseModel;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.jubao.JubaoApiPlugin;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.multimsg.save.FileSaveDialog;
import com.tencent.mobileqq.multimsg.save.FileSaveReq;
import com.tencent.mobileqq.multimsg.save.FileSaveResult;
import com.tencent.mobileqq.multimsg.save.ISingleFileSaveCallBack;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.weiyun.WeiyunAIOUtils;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class AIOShareActionSheet
  implements AdapterView.OnItemClickListener, ISingleFileSaveCallBack
{
  public static String d;
  public static String e = "0X8007F0A ";
  public static String f = "0X8007F0B ";
  public static String g = "0X8007F0C ";
  public static String h = "0X8007F0D ";
  public static String i = "0X8007F0E ";
  public static String j = "0X8007F0F ";
  public static String k = "0X8007F10 ";
  public static String l = "0X800A77E";
  public static String m = "0X800B761";
  public static String n = "0X800B762";
  private static String t;
  QQAppInterface a;
  protected ShareActionSheetBuilder b;
  protected MqqHandler c;
  WXShareHelper.WXShareListener o;
  private Activity p;
  private Context q;
  private BaseChatPie r;
  private boolean s = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("TempMail");
    localStringBuilder.append(File.separator);
    d = localStringBuilder.toString();
    t = HardCodeUtil.a(2131898385);
  }
  
  public AIOShareActionSheet(QQAppInterface paramQQAppInterface, Context paramContext, Activity paramActivity, BaseChatPie paramBaseChatPie, MqqHandler paramMqqHandler)
  {
    this.a = paramQQAppInterface;
    this.q = paramContext;
    this.p = paramActivity;
    this.r = paramBaseChatPie;
    this.c = paramMqqHandler;
  }
  
  public static String a(MessageForPic paramMessageForPic)
  {
    URL localURL = URLDrawableHelper.getURL(paramMessageForPic, 131075);
    if (AbsDownloader.getFile(localURL.toString()) != null) {
      return AbsDownloader.getFilePath(localURL.toString());
    }
    localURL = URLDrawableHelper.getURL(paramMessageForPic, 1);
    if (AbsDownloader.getFile(localURL.toString()) != null) {
      return AbsDownloader.getFilePath(localURL.toString());
    }
    paramMessageForPic = URLDrawableHelper.getURL(paramMessageForPic, 65537);
    if (AbsDownloader.getFile(paramMessageForPic.toString()) != null) {
      return AbsDownloader.getFilePath(paramMessageForPic.toString());
    }
    return null;
  }
  
  public static String a(MessageForPic paramMessageForPic, List<String> paramList1, List<String> paramList2)
  {
    Object localObject = a(paramMessageForPic);
    if (localObject == null)
    {
      QLog.e("AIOShareActionSheet", 1, new Object[] { "getPicMsgPath null, ", paramMessageForPic.getUserLogString() });
      return null;
    }
    paramList1.add(localObject);
    if (new File((String)localObject).getName().indexOf(".") == -1) {
      paramMessageForPic = FileUtils.estimateFileType((String)localObject);
    } else {
      paramMessageForPic = "";
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131898389));
    ((StringBuilder)localObject).append(paramList1.size());
    ((StringBuilder)localObject).append(".");
    ((StringBuilder)localObject).append(paramMessageForPic);
    paramMessageForPic = ((StringBuilder)localObject).toString();
    paramList1 = new StringBuilder();
    paramList1.append(paramMessageForPic);
    paramList1.append(HardCodeUtil.a(2131898384));
    paramList1 = paramList1.toString();
    paramList2.add(paramMessageForPic);
    return paramList1;
  }
  
  private void m()
  {
    String str3 = this.a.getCurrentAccountUin();
    Object localObject1 = this.a;
    Object localObject2 = n;
    ReportController.b((AppRuntime)localObject1, "CliOper", "", str3, (String)localObject2, (String)localObject2, 0, 0, "", "", "", "");
    Object localObject3 = MultiMsgManager.a().i();
    int i2 = ((List)localObject3).size();
    if (i2 == 0)
    {
      a(this.q.getString(2131886152));
      return;
    }
    if (i2 > 50)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.q.getString(2131886154));
      ((StringBuilder)localObject1).append(50);
      ((StringBuilder)localObject1).append(this.q.getString(2131886155));
      a(((StringBuilder)localObject1).toString());
      return;
    }
    localObject1 = MsgProxyUtils.d((MessageRecord)((List)localObject3).get(0));
    String str2 = this.r.ah.c;
    localObject2 = ((List)localObject3).iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (!MsgProxyUtils.d((ChatMessage)((Iterator)localObject2).next()).equals(localObject1))
      {
        a(this.q.getString(2131886153));
        return;
      }
    }
    localObject2 = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    String str1;
    if (((FriendsManager)localObject2).n((String)localObject1)) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    int i3 = this.r.F();
    int i1 = 25061;
    if (i3 != 0) {
      if ((i3 != 1) && (i3 != 3000)) {
        if (i3 != 10014) {
          localObject2 = NewReportPlugin.a((String)localObject1, i3);
        }
      }
    }
    for (;;)
    {
      break;
      str2 = ((ChatMessage)((List)localObject3).get(0)).frienduin;
      localObject1 = ((ChatMessage)((List)localObject3).get(0)).senderuin;
      localObject2 = NewReportPlugin.a(str2, i3);
      i1 = 25080;
      break;
      localObject2 = NewReportPlugin.a(str2, i3);
      i1 = 25060;
      break;
      if (!((FriendsManager)localObject2).n((String)localObject1))
      {
        localObject2 = NewReportPlugin.a((String)localObject1, i3);
      }
      else
      {
        localObject2 = NewReportPlugin.a((String)localObject1, i3);
        i1 = 25062;
      }
    }
    String str4 = NewReportPlugin.a((List)localObject3);
    localObject3 = Base64Util.encodeToString(JubaoApiPlugin.a((List)localObject3).getBytes(), 2);
    NewReportPlugin.a((BaseActivity)this.p, (String)localObject1, str1, str2, str3, i1, str4, i2, (String)localObject3, (Bundle)localObject2);
  }
  
  public String a(MessageForStructing paramMessageForStructing)
  {
    String str = paramMessageForStructing.getSummaryMsg();
    Object localObject2 = str;
    if ((paramMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))
    {
      localObject2 = (StructMsgForGeneralShare)paramMessageForStructing.structingMsg;
      paramMessageForStructing = ((StructMsgForGeneralShare)localObject2).mContentSummary;
      Object localObject1 = paramMessageForStructing;
      if (paramMessageForStructing == null)
      {
        localObject1 = paramMessageForStructing;
        if (((StructMsgForGeneralShare)localObject2).mStructMsgItemLists != null)
        {
          localObject2 = ((StructMsgForGeneralShare)localObject2).mStructMsgItemLists.iterator();
          do
          {
            do
            {
              localObject1 = paramMessageForStructing;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject1 = (AbsStructMsgElement)((Iterator)localObject2).next();
            } while (!(localObject1 instanceof StructMsgItemLayout2));
            localObject1 = (StructMsgItemLayout2)localObject1;
          } while (((StructMsgItemLayout2)localObject1).ax == null);
          Iterator localIterator = ((StructMsgItemLayout2)localObject1).ax.iterator();
          localObject1 = paramMessageForStructing;
          for (;;)
          {
            paramMessageForStructing = (MessageForStructing)localObject1;
            if (!localIterator.hasNext()) {
              break;
            }
            paramMessageForStructing = (AbsStructMsgElement)localIterator.next();
            if ((paramMessageForStructing instanceof StructMsgItemSummary)) {
              localObject1 = ((StructMsgItemSummary)paramMessageForStructing).aA;
            }
          }
        }
      }
      localObject2 = str;
      if (localObject1 != null)
      {
        paramMessageForStructing = new StringBuilder();
        paramMessageForStructing.append(str);
        paramMessageForStructing.append((String)localObject1);
        localObject2 = paramMessageForStructing.toString();
      }
    }
    return localObject2;
  }
  
  public void a() {}
  
  public void a(FileSaveResult paramFileSaveResult) {}
  
  public void a(FileSaveResult paramFileSaveResult, int paramInt) {}
  
  public void a(String paramString)
  {
    Context localContext = this.q;
    DialogUtil.a(localContext, 230, null, paramString, "", localContext.getString(2131886151), new AIOShareActionSheet.11(this), null).show();
  }
  
  public void a(Map<String, String> paramMap, ArrayList<ChatMessage> paramArrayList)
  {
    if (paramArrayList.isEmpty()) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.SEND_MULTIPLE");
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_ac");
    localIntent.setType("message/rfc822");
    a(paramMap, paramArrayList, localIntent);
    try
    {
      paramArrayList = this.q.getPackageManager().queryIntentActivities(localIntent, 0);
      if (!paramArrayList.isEmpty())
      {
        paramMap = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          Object localObject = (ResolveInfo)paramArrayList.next();
          if ((((ResolveInfo)localObject).activityInfo.packageName.toLowerCase().contains("mail")) || (((ResolveInfo)localObject).activityInfo.name.toLowerCase().contains("mail")))
          {
            if (((ResolveInfo)localObject).activityInfo.packageName.equals("com.tencent.androidqqmail"))
            {
              if (((ResolveInfo)localObject).activityInfo.name.contains("LaunchComposeNote")) {
                continue;
              }
              localObject = new ComponentName(((ResolveInfo)localObject).activityInfo.applicationInfo.packageName, ((ResolveInfo)localObject).activityInfo.name);
              localIntent.setPackage(null);
              localIntent.setComponent((ComponentName)localObject);
            }
            else
            {
              if ((((ResolveInfo)localObject).activityInfo.packageName.contains("bluetooth")) || (((ResolveInfo)localObject).activityInfo.name.contains("bluetooth"))) {
                continue;
              }
              localIntent.setComponent(null);
              localIntent.setPackage(((ResolveInfo)localObject).activityInfo.packageName);
            }
            paramMap.add((Intent)localIntent.clone());
          }
        }
        try
        {
          paramArrayList = Intent.createChooser((Intent)paramMap.remove(0), HardCodeUtil.a(2131898383));
          if (paramArrayList == null) {
            return;
          }
          paramArrayList.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])paramMap.toArray(new Parcelable[0]));
          paramArrayList.putExtra("big_brother_source_key", "biz_src_jc_ac");
          this.q.startActivity(paramArrayList);
          return;
        }
        catch (Exception paramMap)
        {
          QLog.e("AIOShareActionSheet", 1, "realSendToMail error_1, ", paramMap);
          if (!(paramMap instanceof ClassCastException)) {
            return;
          }
        }
        paramMap = new ArrayList();
        paramMap.add(localIntent.getCharSequenceExtra("android.intent.extra.TEXT"));
        localIntent.removeExtra("android.intent.extra.TEXT");
        localIntent.putCharSequenceArrayListExtra("android.intent.extra.TEXT", paramMap);
        this.q.startActivity(Intent.createChooser(localIntent, HardCodeUtil.a(2131898381)));
        return;
      }
    }
    catch (Exception paramMap)
    {
      QLog.e("AIOShareActionSheet", 1, "realSendToMail error_2, ", paramMap);
    }
  }
  
  /* Error */
  public void a(Map<String, String> paramMap, ArrayList<ChatMessage> paramArrayList, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc 157
    //   2: astore 11
    //   4: aload_2
    //   5: iconst_0
    //   6: invokevirtual 532	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   9: checkcast 275	com/tencent/mobileqq/data/ChatMessage
    //   12: astore 21
    //   14: aload 21
    //   16: getfield 535	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   19: ifne +55 -> 74
    //   22: aload_0
    //   23: getfield 123	com/tencent/mobileqq/msgforward/AIOShareActionSheet:q	Landroid/content/Context;
    //   26: ldc_w 536
    //   29: invokevirtual 234	android/content/Context:getString	(I)Ljava/lang/String;
    //   32: iconst_2
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: getfield 121	com/tencent/mobileqq/msgforward/AIOShareActionSheet:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   42: aload 21
    //   44: getfield 539	com/tencent/mobileqq/data/ChatMessage:selfuin	Ljava/lang/String;
    //   47: invokestatic 544	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: aload_0
    //   54: getfield 121	com/tencent/mobileqq/msgforward/AIOShareActionSheet:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   57: aload 21
    //   59: getfield 309	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   62: invokestatic 544	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   65: aastore
    //   66: invokestatic 548	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   69: astore 8
    //   71: goto +114 -> 185
    //   74: aload 21
    //   76: getfield 535	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   79: iconst_1
    //   80: if_icmpne +40 -> 120
    //   83: aload_0
    //   84: getfield 123	com/tencent/mobileqq/msgforward/AIOShareActionSheet:q	Landroid/content/Context;
    //   87: ldc_w 549
    //   90: invokevirtual 234	android/content/Context:getString	(I)Ljava/lang/String;
    //   93: iconst_1
    //   94: anewarray 4	java/lang/Object
    //   97: dup
    //   98: iconst_0
    //   99: aload_0
    //   100: getfield 121	com/tencent/mobileqq/msgforward/AIOShareActionSheet:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   103: aload 21
    //   105: getfield 309	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   108: invokestatic 552	com/tencent/mobileqq/utils/ContactUtils:d	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   111: aastore
    //   112: invokestatic 548	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   115: astore 8
    //   117: goto +68 -> 185
    //   120: aload 21
    //   122: getfield 535	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   125: sipush 3000
    //   128: if_icmpne +53 -> 181
    //   131: aload_0
    //   132: getfield 123	com/tencent/mobileqq/msgforward/AIOShareActionSheet:q	Landroid/content/Context;
    //   135: ldc_w 549
    //   138: invokevirtual 234	android/content/Context:getString	(I)Ljava/lang/String;
    //   141: astore 7
    //   143: aload_0
    //   144: getfield 121	com/tencent/mobileqq/msgforward/AIOShareActionSheet:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   147: astore 8
    //   149: aload 7
    //   151: iconst_1
    //   152: anewarray 4	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: aload 8
    //   159: aload 8
    //   161: invokevirtual 556	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   164: aload 21
    //   166: getfield 309	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   169: invokestatic 559	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   172: aastore
    //   173: invokestatic 548	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   176: astore 8
    //   178: goto +7 -> 185
    //   181: ldc 196
    //   183: astore 8
    //   185: aload_3
    //   186: ldc_w 561
    //   189: aload 8
    //   191: invokevirtual 405	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   194: pop
    //   195: getstatic 66	com/tencent/mobileqq/msgforward/AIOShareActionSheet:d	Ljava/lang/String;
    //   198: iconst_1
    //   199: invokestatic 565	com/tencent/mobileqq/utils/FileUtils:delete	(Ljava/lang/String;Z)V
    //   202: new 57	java/io/File
    //   205: dup
    //   206: getstatic 66	com/tencent/mobileqq/msgforward/AIOShareActionSheet:d	Ljava/lang/String;
    //   209: invokespecial 178	java/io/File:<init>	(Ljava/lang/String;)V
    //   212: astore 7
    //   214: aload 7
    //   216: invokevirtual 568	java/io/File:isDirectory	()Z
    //   219: ifeq +17 -> 236
    //   222: aload 7
    //   224: invokevirtual 571	java/io/File:exists	()Z
    //   227: ifne +9 -> 236
    //   230: aload 7
    //   232: invokevirtual 574	java/io/File:mkdirs	()Z
    //   235: pop
    //   236: new 362	java/util/ArrayList
    //   239: dup
    //   240: invokespecial 426	java/util/ArrayList:<init>	()V
    //   243: astore 9
    //   245: new 362	java/util/ArrayList
    //   248: dup
    //   249: invokespecial 426	java/util/ArrayList:<init>	()V
    //   252: astore 10
    //   254: new 362	java/util/ArrayList
    //   257: dup
    //   258: invokespecial 426	java/util/ArrayList:<init>	()V
    //   261: astore 19
    //   263: new 362	java/util/ArrayList
    //   266: dup
    //   267: invokespecial 426	java/util/ArrayList:<init>	()V
    //   270: astore 13
    //   272: aconst_null
    //   273: astore 17
    //   275: aconst_null
    //   276: astore 15
    //   278: aconst_null
    //   279: astore 16
    //   281: aconst_null
    //   282: astore 14
    //   284: aload 17
    //   286: astore 12
    //   288: new 41	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   295: astore 7
    //   297: aload 17
    //   299: astore 12
    //   301: aload 7
    //   303: getstatic 66	com/tencent/mobileqq/msgforward/AIOShareActionSheet:d	Ljava/lang/String;
    //   306: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 17
    //   312: astore 12
    //   314: aload 7
    //   316: getstatic 74	com/tencent/mobileqq/msgforward/AIOShareActionSheet:t	Ljava/lang/String;
    //   319: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 17
    //   325: astore 12
    //   327: aload 7
    //   329: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 577	com/tencent/mobileqq/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   335: pop
    //   336: aload 13
    //   338: astore 7
    //   340: aload 17
    //   342: astore 12
    //   344: new 41	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   351: astore 13
    //   353: aload 17
    //   355: astore 12
    //   357: aload 13
    //   359: getstatic 66	com/tencent/mobileqq/msgforward/AIOShareActionSheet:d	Ljava/lang/String;
    //   362: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload 17
    //   368: astore 12
    //   370: aload 13
    //   372: getstatic 74	com/tencent/mobileqq/msgforward/AIOShareActionSheet:t	Ljava/lang/String;
    //   375: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload 17
    //   381: astore 12
    //   383: new 579	java/io/BufferedWriter
    //   386: dup
    //   387: new 581	java/io/FileWriter
    //   390: dup
    //   391: aload 13
    //   393: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokespecial 582	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   399: invokespecial 585	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   402: astore 13
    //   404: aload 9
    //   406: astore 17
    //   408: aload 11
    //   410: astore 16
    //   412: aload 7
    //   414: astore 12
    //   416: aload 10
    //   418: astore 15
    //   420: new 41	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   427: astore 20
    //   429: aload 9
    //   431: astore 17
    //   433: aload 11
    //   435: astore 16
    //   437: aload 7
    //   439: astore 12
    //   441: aload 10
    //   443: astore 15
    //   445: aload 20
    //   447: ldc_w 587
    //   450: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: aload 9
    //   456: astore 17
    //   458: aload 11
    //   460: astore 16
    //   462: aload 7
    //   464: astore 12
    //   466: aload 10
    //   468: astore 15
    //   470: aload 20
    //   472: ldc_w 589
    //   475: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload 9
    //   481: astore 17
    //   483: aload 11
    //   485: astore 16
    //   487: aload 7
    //   489: astore 12
    //   491: aload 10
    //   493: astore 15
    //   495: aload 20
    //   497: aload 8
    //   499: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload 9
    //   505: astore 17
    //   507: aload 11
    //   509: astore 16
    //   511: aload 7
    //   513: astore 12
    //   515: aload 10
    //   517: astore 15
    //   519: aload 20
    //   521: ldc_w 591
    //   524: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload 9
    //   530: astore 17
    //   532: aload 11
    //   534: astore 16
    //   536: aload 7
    //   538: astore 12
    //   540: aload 10
    //   542: astore 15
    //   544: new 41	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   551: astore 14
    //   553: aload 9
    //   555: astore 17
    //   557: aload 11
    //   559: astore 16
    //   561: aload 7
    //   563: astore 12
    //   565: aload 10
    //   567: astore 15
    //   569: aload 14
    //   571: aload 8
    //   573: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload 9
    //   579: astore 17
    //   581: aload 11
    //   583: astore 16
    //   585: aload 7
    //   587: astore 12
    //   589: aload 10
    //   591: astore 15
    //   593: aload 14
    //   595: ldc_w 593
    //   598: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload 9
    //   604: astore 17
    //   606: aload 11
    //   608: astore 16
    //   610: aload 7
    //   612: astore 12
    //   614: aload 10
    //   616: astore 15
    //   618: aload 13
    //   620: aload 14
    //   622: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokevirtual 596	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   628: aload 9
    //   630: astore 17
    //   632: aload 11
    //   634: astore 16
    //   636: aload 7
    //   638: astore 12
    //   640: aload 10
    //   642: astore 15
    //   644: new 598	java/text/SimpleDateFormat
    //   647: dup
    //   648: ldc 196
    //   650: getstatic 604	java/util/Locale:SIMPLIFIED_CHINESE	Ljava/util/Locale;
    //   653: invokespecial 607	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   656: astore 18
    //   658: aload 9
    //   660: astore 17
    //   662: aload 11
    //   664: astore 16
    //   666: aload 7
    //   668: astore 12
    //   670: aload 10
    //   672: astore 15
    //   674: aload 18
    //   676: ldc_w 609
    //   679: invokevirtual 612	java/text/SimpleDateFormat:applyPattern	(Ljava/lang/String;)V
    //   682: aload 9
    //   684: astore 17
    //   686: aload 11
    //   688: astore 16
    //   690: aload 7
    //   692: astore 12
    //   694: aload 10
    //   696: astore 15
    //   698: aload 18
    //   700: aload 21
    //   702: getfield 616	com/tencent/mobileqq/data/ChatMessage:time	J
    //   705: ldc2_w 617
    //   708: lmul
    //   709: invokestatic 624	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   712: invokevirtual 627	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   715: astore 14
    //   717: aload 9
    //   719: astore 17
    //   721: aload 11
    //   723: astore 16
    //   725: aload 7
    //   727: astore 12
    //   729: aload 10
    //   731: astore 15
    //   733: aload 20
    //   735: ldc_w 629
    //   738: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: pop
    //   742: aload 9
    //   744: astore 17
    //   746: aload 11
    //   748: astore 16
    //   750: aload 7
    //   752: astore 12
    //   754: aload 10
    //   756: astore 15
    //   758: aload 20
    //   760: aload 14
    //   762: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: pop
    //   766: aload 9
    //   768: astore 17
    //   770: aload 11
    //   772: astore 16
    //   774: aload 7
    //   776: astore 12
    //   778: aload 10
    //   780: astore 15
    //   782: aload 20
    //   784: ldc_w 631
    //   787: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: pop
    //   791: aload 9
    //   793: astore 17
    //   795: aload 11
    //   797: astore 16
    //   799: aload 7
    //   801: astore 12
    //   803: aload 10
    //   805: astore 15
    //   807: new 41	java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   814: astore 8
    //   816: aload 9
    //   818: astore 17
    //   820: aload 11
    //   822: astore 16
    //   824: aload 7
    //   826: astore 12
    //   828: aload 10
    //   830: astore 15
    //   832: aload 8
    //   834: ldc_w 633
    //   837: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: pop
    //   841: aload 9
    //   843: astore 17
    //   845: aload 11
    //   847: astore 16
    //   849: aload 7
    //   851: astore 12
    //   853: aload 10
    //   855: astore 15
    //   857: aload 8
    //   859: aload 14
    //   861: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: pop
    //   865: aload 9
    //   867: astore 17
    //   869: aload 11
    //   871: astore 16
    //   873: aload 7
    //   875: astore 12
    //   877: aload 10
    //   879: astore 15
    //   881: aload 8
    //   883: ldc_w 635
    //   886: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: pop
    //   890: aload 9
    //   892: astore 17
    //   894: aload 11
    //   896: astore 16
    //   898: aload 7
    //   900: astore 12
    //   902: aload 10
    //   904: astore 15
    //   906: aload 13
    //   908: aload 8
    //   910: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   913: invokevirtual 596	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   916: iconst_0
    //   917: istore 4
    //   919: aload 10
    //   921: astore 8
    //   923: aload 11
    //   925: astore 10
    //   927: aload 9
    //   929: astore 17
    //   931: aload 10
    //   933: astore 16
    //   935: aload 7
    //   937: astore 12
    //   939: aload 8
    //   941: astore 15
    //   943: aload_2
    //   944: invokevirtual 636	java/util/ArrayList:size	()I
    //   947: istore 5
    //   949: iload 4
    //   951: iload 5
    //   953: if_icmpge +1169 -> 2122
    //   956: aload_2
    //   957: iload 4
    //   959: invokevirtual 532	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   962: checkcast 275	com/tencent/mobileqq/data/ChatMessage
    //   965: astore 17
    //   967: aload 17
    //   969: instanceof 638
    //   972: istore 6
    //   974: iload 6
    //   976: ifeq +77 -> 1053
    //   979: aload 17
    //   981: checkcast 638	com/tencent/mobileqq/data/MessageForText
    //   984: astore 11
    //   986: aload 11
    //   988: getfield 642	com/tencent/mobileqq/data/MessageForText:sb	Ljava/lang/CharSequence;
    //   991: ifnull +18 -> 1009
    //   994: aload 11
    //   996: getfield 642	com/tencent/mobileqq/data/MessageForText:sb	Ljava/lang/CharSequence;
    //   999: invokeinterface 645 1 0
    //   1004: astore 12
    //   1006: goto +10 -> 1016
    //   1009: aload 11
    //   1011: getfield 648	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   1014: astore 12
    //   1016: aload 12
    //   1018: astore 11
    //   1020: aload 12
    //   1022: invokestatic 653	com/tencent/mobileqq/text/TextUtils:hasSysEmotion	(Ljava/lang/String;)Z
    //   1025: ifeq +54 -> 1079
    //   1028: aload 12
    //   1030: invokestatic 656	com/tencent/mobileqq/text/TextUtils:Symbol2FavoriteSymbol	(Ljava/lang/String;)Ljava/lang/String;
    //   1033: astore 11
    //   1035: goto +44 -> 1079
    //   1038: astore 11
    //   1040: aload 9
    //   1042: astore_1
    //   1043: aload 13
    //   1045: astore 9
    //   1047: aload 7
    //   1049: astore_2
    //   1050: goto +1247 -> 2297
    //   1053: aload 17
    //   1055: instanceof 161
    //   1058: istore 6
    //   1060: iload 6
    //   1062: ifeq +24 -> 1086
    //   1065: aload 17
    //   1067: checkcast 161	com/tencent/mobileqq/data/MessageForPic
    //   1070: aload 9
    //   1072: aload 19
    //   1074: invokestatic 658	com/tencent/mobileqq/msgforward/AIOShareActionSheet:a	(Lcom/tencent/mobileqq/data/MessageForPic;Ljava/util/List;Ljava/util/List;)Ljava/lang/String;
    //   1077: astore 11
    //   1079: aload 11
    //   1081: astore 12
    //   1083: goto +595 -> 1678
    //   1086: aload 17
    //   1088: instanceof 660
    //   1091: istore 6
    //   1093: iload 6
    //   1095: ifeq +193 -> 1288
    //   1098: aload 17
    //   1100: checkcast 660	com/tencent/mobileqq/data/MessageForShortVideo
    //   1103: invokestatic 666	com/tencent/mobileqq/shortvideo/ShortVideoUtils:findVideoPathIfExists	(Lcom/tencent/mobileqq/data/MessageForShortVideo;)Ljava/lang/String;
    //   1106: astore 11
    //   1108: aload 11
    //   1110: ifnonnull +30 -> 1140
    //   1113: aload 10
    //   1115: iconst_1
    //   1116: iconst_2
    //   1117: anewarray 4	java/lang/Object
    //   1120: dup
    //   1121: iconst_0
    //   1122: ldc_w 668
    //   1125: aastore
    //   1126: dup
    //   1127: iconst_1
    //   1128: aload 17
    //   1130: invokevirtual 669	com/tencent/mobileqq/data/ChatMessage:getUserLogString	()Ljava/lang/String;
    //   1133: aastore
    //   1134: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1137: goto +1633 -> 2770
    //   1140: aload 8
    //   1142: aload 11
    //   1144: invokeinterface 175 2 0
    //   1149: pop
    //   1150: new 41	java/lang/StringBuilder
    //   1153: dup
    //   1154: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   1157: astore 11
    //   1159: aload 11
    //   1161: ldc_w 670
    //   1164: invokestatic 72	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1167: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: pop
    //   1171: aload 11
    //   1173: aload 8
    //   1175: invokeinterface 201 1 0
    //   1180: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1183: pop
    //   1184: aload 11
    //   1186: ldc_w 672
    //   1189: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1192: pop
    //   1193: aload 11
    //   1195: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1198: astore 15
    //   1200: new 41	java/lang/StringBuilder
    //   1203: dup
    //   1204: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   1207: astore 12
    //   1209: aload 12
    //   1211: aload 15
    //   1213: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: pop
    //   1217: aload 7
    //   1219: astore 11
    //   1221: aload 12
    //   1223: ldc_w 673
    //   1226: invokestatic 72	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1229: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1232: pop
    //   1233: aload 7
    //   1235: astore 11
    //   1237: aload 12
    //   1239: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1242: astore 12
    //   1244: aload 7
    //   1246: astore 11
    //   1248: aload 11
    //   1250: aload 15
    //   1252: invokeinterface 175 2 0
    //   1257: pop
    //   1258: aload 11
    //   1260: astore 7
    //   1262: goto +416 -> 1678
    //   1265: astore_1
    //   1266: goto +4 -> 1270
    //   1269: astore_1
    //   1270: goto +4 -> 1274
    //   1273: astore_1
    //   1274: aload 9
    //   1276: astore_2
    //   1277: aload 10
    //   1279: astore 9
    //   1281: aload 8
    //   1283: astore 10
    //   1285: goto +969 -> 2254
    //   1288: aload 7
    //   1290: astore 11
    //   1292: aload 17
    //   1294: instanceof 675
    //   1297: istore 6
    //   1299: iload 6
    //   1301: ifne +353 -> 1654
    //   1304: aload 17
    //   1306: instanceof 677
    //   1309: ifeq +6 -> 1315
    //   1312: goto +342 -> 1654
    //   1315: aload 17
    //   1317: instanceof 336
    //   1320: ifeq +316 -> 1636
    //   1323: aload 17
    //   1325: checkcast 336	com/tencent/mobileqq/data/MessageForStructing
    //   1328: astore 16
    //   1330: aload 16
    //   1332: getfield 343	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1335: ifnull +1429 -> 2764
    //   1338: aload 16
    //   1340: getfield 343	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1343: instanceof 679
    //   1346: istore 6
    //   1348: iload 6
    //   1350: ifeq +50 -> 1400
    //   1353: aload 16
    //   1355: getfield 343	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1358: checkcast 679	com/tencent/mobileqq/structmsg/StructMsgForHypertext
    //   1361: iconst_0
    //   1362: invokevirtual 683	com/tencent/mobileqq/structmsg/StructMsgForHypertext:getSpannableString	(Z)Landroid/text/SpannableStringBuilder;
    //   1365: invokevirtual 686	android/text/SpannableStringBuilder:toString	()Ljava/lang/String;
    //   1368: astore 11
    //   1370: goto +222 -> 1592
    //   1373: aload 8
    //   1375: astore 12
    //   1377: aload 7
    //   1379: astore_2
    //   1380: astore 11
    //   1382: aload 9
    //   1384: astore_1
    //   1385: aload 13
    //   1387: astore 8
    //   1389: aload 10
    //   1391: astore 9
    //   1393: aload 12
    //   1395: astore 7
    //   1397: goto +967 -> 2364
    //   1400: aload 11
    //   1402: astore 12
    //   1404: aload 12
    //   1406: astore 11
    //   1408: ldc_w 688
    //   1411: aload 16
    //   1413: getfield 343	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1416: getfield 693	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgAction	Ljava/lang/String;
    //   1419: invokevirtual 278	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1422: ifeq +22 -> 1444
    //   1425: aload 12
    //   1427: astore 11
    //   1429: ldc_w 694
    //   1432: invokestatic 72	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1435: astore 12
    //   1437: aload 12
    //   1439: astore 11
    //   1441: goto +151 -> 1592
    //   1444: aload 12
    //   1446: astore 11
    //   1448: aload 16
    //   1450: getfield 343	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1453: getfield 697	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1456: istore 5
    //   1458: iload 5
    //   1460: bipush 32
    //   1462: if_icmpne +30 -> 1492
    //   1465: aload 12
    //   1467: astore 11
    //   1469: aload_0
    //   1470: aload 16
    //   1472: invokevirtual 699	com/tencent/mobileqq/msgforward/AIOShareActionSheet:a	(Lcom/tencent/mobileqq/data/MessageForStructing;)Ljava/lang/String;
    //   1475: astore 12
    //   1477: aload 12
    //   1479: astore 11
    //   1481: goto +111 -> 1592
    //   1484: astore_1
    //   1485: aload 13
    //   1487: astore 12
    //   1489: goto +1242 -> 2731
    //   1492: aload 12
    //   1494: astore 11
    //   1496: aload 16
    //   1498: invokevirtual 339	com/tencent/mobileqq/data/MessageForStructing:getSummaryMsg	()Ljava/lang/String;
    //   1501: astore 15
    //   1503: aload 12
    //   1505: astore 11
    //   1507: aload 16
    //   1509: getfield 343	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1512: getfield 702	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgUrl	Ljava/lang/String;
    //   1515: ifnull +1242 -> 2757
    //   1518: aload 12
    //   1520: astore 11
    //   1522: new 41	java/lang/StringBuilder
    //   1525: dup
    //   1526: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   1529: astore 21
    //   1531: aload 12
    //   1533: astore 11
    //   1535: aload 21
    //   1537: aload 15
    //   1539: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1542: pop
    //   1543: aload 12
    //   1545: astore 11
    //   1547: aload 21
    //   1549: ldc_w 704
    //   1552: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1555: pop
    //   1556: aload 12
    //   1558: astore 11
    //   1560: aload 21
    //   1562: aload 16
    //   1564: getfield 343	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1567: getfield 702	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgUrl	Ljava/lang/String;
    //   1570: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1573: pop
    //   1574: aload 12
    //   1576: astore 11
    //   1578: aload 21
    //   1580: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1583: astore 12
    //   1585: aload 12
    //   1587: astore 11
    //   1589: goto +3 -> 1592
    //   1592: aload 7
    //   1594: astore 15
    //   1596: aload 11
    //   1598: astore 12
    //   1600: aload 15
    //   1602: astore 7
    //   1604: aload 11
    //   1606: ifnonnull +72 -> 1678
    //   1609: aload 15
    //   1611: astore 11
    //   1613: ldc_w 705
    //   1616: invokestatic 72	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1619: astore 12
    //   1621: aload 15
    //   1623: astore 7
    //   1625: goto +53 -> 1678
    //   1628: astore_1
    //   1629: aload 11
    //   1631: astore 7
    //   1633: goto -359 -> 1274
    //   1636: aload 11
    //   1638: astore 7
    //   1640: aconst_null
    //   1641: astore 12
    //   1643: goto +35 -> 1678
    //   1646: astore_1
    //   1647: aload 11
    //   1649: astore 7
    //   1651: goto -377 -> 1274
    //   1654: aload 11
    //   1656: astore 7
    //   1658: aload 7
    //   1660: astore 11
    //   1662: aload 17
    //   1664: aload 9
    //   1666: aload 19
    //   1668: invokestatic 709	com/tencent/mobileqq/data/MessageForMixedMsg:getTextFromMixedMsgForMail	(Lcom/tencent/mobileqq/data/ChatMessage;Ljava/util/List;Ljava/util/List;)Ljava/lang/CharSequence;
    //   1671: invokeinterface 645 1 0
    //   1676: astore 12
    //   1678: aload 12
    //   1680: ifnull +1090 -> 2770
    //   1683: aload 7
    //   1685: astore 11
    //   1687: aload 18
    //   1689: ldc_w 609
    //   1692: invokevirtual 612	java/text/SimpleDateFormat:applyPattern	(Ljava/lang/String;)V
    //   1695: aload 7
    //   1697: astore 15
    //   1699: aload 18
    //   1701: aload 17
    //   1703: getfield 616	com/tencent/mobileqq/data/ChatMessage:time	J
    //   1706: ldc2_w 617
    //   1709: lmul
    //   1710: invokestatic 624	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1713: invokevirtual 627	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   1716: astore 16
    //   1718: aload 14
    //   1720: astore 11
    //   1722: aload 7
    //   1724: astore 15
    //   1726: aload 16
    //   1728: aload 14
    //   1730: invokevirtual 278	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1733: ifne +110 -> 1843
    //   1736: aload 7
    //   1738: astore 15
    //   1740: aload 20
    //   1742: ldc_w 629
    //   1745: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1748: pop
    //   1749: aload 7
    //   1751: astore 15
    //   1753: aload 20
    //   1755: aload 16
    //   1757: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1760: pop
    //   1761: aload 7
    //   1763: astore 15
    //   1765: aload 20
    //   1767: ldc_w 631
    //   1770: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1773: pop
    //   1774: aload 7
    //   1776: astore 15
    //   1778: new 41	java/lang/StringBuilder
    //   1781: dup
    //   1782: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   1785: astore 11
    //   1787: aload 7
    //   1789: astore 15
    //   1791: aload 11
    //   1793: ldc_w 633
    //   1796: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1799: pop
    //   1800: aload 7
    //   1802: astore 15
    //   1804: aload 11
    //   1806: aload 16
    //   1808: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1811: pop
    //   1812: aload 7
    //   1814: astore 15
    //   1816: aload 11
    //   1818: ldc_w 635
    //   1821: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1824: pop
    //   1825: aload 7
    //   1827: astore 15
    //   1829: aload 13
    //   1831: aload 11
    //   1833: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1836: invokevirtual 596	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   1839: aload 16
    //   1841: astore 11
    //   1843: aload 7
    //   1845: astore 15
    //   1847: aload 18
    //   1849: ldc_w 711
    //   1852: invokevirtual 612	java/text/SimpleDateFormat:applyPattern	(Ljava/lang/String;)V
    //   1855: aload 7
    //   1857: astore 15
    //   1859: aload 18
    //   1861: aload 17
    //   1863: getfield 616	com/tencent/mobileqq/data/ChatMessage:time	J
    //   1866: ldc2_w 617
    //   1869: lmul
    //   1870: invokestatic 624	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1873: invokevirtual 627	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   1876: astore 14
    //   1878: aload 7
    //   1880: astore 15
    //   1882: aload 20
    //   1884: ldc_w 713
    //   1887: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1890: pop
    //   1891: aload 7
    //   1893: astore 15
    //   1895: aload 20
    //   1897: aload_1
    //   1898: aload 17
    //   1900: getfield 312	com/tencent/mobileqq/data/ChatMessage:senderuin	Ljava/lang/String;
    //   1903: invokeinterface 718 2 0
    //   1908: checkcast 185	java/lang/String
    //   1911: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1914: pop
    //   1915: aload 7
    //   1917: astore 15
    //   1919: aload 20
    //   1921: ldc_w 720
    //   1924: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1927: pop
    //   1928: aload 7
    //   1930: astore 15
    //   1932: aload 20
    //   1934: aload 14
    //   1936: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1939: pop
    //   1940: aload 7
    //   1942: astore 15
    //   1944: aload 20
    //   1946: ldc_w 722
    //   1949: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1952: pop
    //   1953: aload 7
    //   1955: astore 15
    //   1957: aload 20
    //   1959: aload 12
    //   1961: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1964: pop
    //   1965: aload 7
    //   1967: astore 15
    //   1969: aload 20
    //   1971: ldc_w 724
    //   1974: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1977: pop
    //   1978: aload 7
    //   1980: astore 15
    //   1982: new 41	java/lang/StringBuilder
    //   1985: dup
    //   1986: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   1989: astore 16
    //   1991: aload 7
    //   1993: astore 15
    //   1995: aload 16
    //   1997: aload_1
    //   1998: aload 17
    //   2000: getfield 312	com/tencent/mobileqq/data/ChatMessage:senderuin	Ljava/lang/String;
    //   2003: invokeinterface 718 2 0
    //   2008: checkcast 185	java/lang/String
    //   2011: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2014: pop
    //   2015: aload 7
    //   2017: astore 15
    //   2019: aload 16
    //   2021: ldc_w 726
    //   2024: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2027: pop
    //   2028: aload 7
    //   2030: astore 15
    //   2032: aload 16
    //   2034: aload 14
    //   2036: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2039: pop
    //   2040: aload 7
    //   2042: astore 15
    //   2044: aload 16
    //   2046: ldc_w 704
    //   2049: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2052: pop
    //   2053: aload 7
    //   2055: astore 15
    //   2057: aload 13
    //   2059: aload 16
    //   2061: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2064: invokevirtual 596	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   2067: aload 7
    //   2069: astore 15
    //   2071: new 41	java/lang/StringBuilder
    //   2074: dup
    //   2075: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   2078: astore 14
    //   2080: aload 7
    //   2082: astore 15
    //   2084: aload 14
    //   2086: aload 12
    //   2088: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2091: pop
    //   2092: aload 7
    //   2094: astore 15
    //   2096: aload 14
    //   2098: ldc_w 728
    //   2101: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2104: pop
    //   2105: aload 7
    //   2107: astore 15
    //   2109: aload 13
    //   2111: aload 14
    //   2113: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2116: invokevirtual 596	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   2119: goto +655 -> 2774
    //   2122: aload 9
    //   2124: astore_2
    //   2125: aload 10
    //   2127: astore 12
    //   2129: aload 8
    //   2131: astore 11
    //   2133: aload 7
    //   2135: astore 15
    //   2137: aload 20
    //   2139: ldc_w 730
    //   2142: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2145: pop
    //   2146: aload 7
    //   2148: astore 15
    //   2150: aload 20
    //   2152: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2155: invokestatic 736	android/text/Html:fromHtml	(Ljava/lang/String;)Landroid/text/Spanned;
    //   2158: astore_1
    //   2159: aload_3
    //   2160: ldc_w 511
    //   2163: aload_1
    //   2164: invokevirtual 739	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/CharSequence;)Landroid/content/Intent;
    //   2167: pop
    //   2168: aload 13
    //   2170: invokevirtual 742	java/io/BufferedWriter:flush	()V
    //   2173: aload_2
    //   2174: astore 10
    //   2176: aload 7
    //   2178: astore 9
    //   2180: aload 11
    //   2182: astore 12
    //   2184: aload 13
    //   2186: invokevirtual 745	java/io/BufferedWriter:close	()V
    //   2189: aload_2
    //   2190: astore 10
    //   2192: aload 7
    //   2194: astore 9
    //   2196: goto +235 -> 2431
    //   2199: astore_1
    //   2200: aload 12
    //   2202: astore 9
    //   2204: aload 11
    //   2206: astore 10
    //   2208: goto +46 -> 2254
    //   2211: astore_1
    //   2212: aload 15
    //   2214: astore 7
    //   2216: aload 9
    //   2218: astore_2
    //   2219: aload 10
    //   2221: astore 9
    //   2223: aload 8
    //   2225: astore 10
    //   2227: goto +27 -> 2254
    //   2230: astore_1
    //   2231: aload 13
    //   2233: astore 12
    //   2235: goto +496 -> 2731
    //   2238: astore_1
    //   2239: aload 17
    //   2241: astore_2
    //   2242: aload 16
    //   2244: astore 9
    //   2246: aload 15
    //   2248: astore 10
    //   2250: aload 12
    //   2252: astore 7
    //   2254: aload 13
    //   2256: astore 8
    //   2258: aload_1
    //   2259: astore 11
    //   2261: aload_2
    //   2262: astore_1
    //   2263: aload 7
    //   2265: astore_2
    //   2266: aload 10
    //   2268: astore 7
    //   2270: goto +94 -> 2364
    //   2273: astore 12
    //   2275: aload 9
    //   2277: astore_1
    //   2278: aload 10
    //   2280: astore 8
    //   2282: aload 7
    //   2284: astore_2
    //   2285: aload 14
    //   2287: astore 9
    //   2289: aload 11
    //   2291: astore 10
    //   2293: aload 12
    //   2295: astore 11
    //   2297: aload 8
    //   2299: astore 7
    //   2301: aload 9
    //   2303: astore 8
    //   2305: aload 10
    //   2307: astore 9
    //   2309: goto +55 -> 2364
    //   2312: astore 11
    //   2314: aload 9
    //   2316: astore_1
    //   2317: ldc 157
    //   2319: astore 9
    //   2321: aload 16
    //   2323: astore 8
    //   2325: aload 7
    //   2327: astore_2
    //   2328: aload 10
    //   2330: astore 7
    //   2332: goto +32 -> 2364
    //   2335: astore 11
    //   2337: goto +9 -> 2346
    //   2340: astore_1
    //   2341: goto +390 -> 2731
    //   2344: astore 11
    //   2346: aload 9
    //   2348: astore_1
    //   2349: ldc 157
    //   2351: astore 9
    //   2353: aload 10
    //   2355: astore 7
    //   2357: aload 15
    //   2359: astore 8
    //   2361: aload 13
    //   2363: astore_2
    //   2364: aload 8
    //   2366: astore 12
    //   2368: aload 9
    //   2370: iconst_1
    //   2371: ldc_w 747
    //   2374: aload 11
    //   2376: invokestatic 507	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2379: aload_1
    //   2380: astore 10
    //   2382: aload_2
    //   2383: astore 9
    //   2385: aload 7
    //   2387: astore 11
    //   2389: aload 8
    //   2391: ifnull +40 -> 2431
    //   2394: aload_1
    //   2395: astore 10
    //   2397: aload_2
    //   2398: astore 9
    //   2400: aload 7
    //   2402: astore 12
    //   2404: aload 8
    //   2406: invokevirtual 745	java/io/BufferedWriter:close	()V
    //   2409: aload_1
    //   2410: astore 10
    //   2412: aload_2
    //   2413: astore 9
    //   2415: aload 7
    //   2417: astore 11
    //   2419: goto +12 -> 2431
    //   2422: astore_1
    //   2423: aload_1
    //   2424: invokevirtual 750	java/io/IOException:printStackTrace	()V
    //   2427: aload 12
    //   2429: astore 11
    //   2431: new 362	java/util/ArrayList
    //   2434: dup
    //   2435: invokespecial 426	java/util/ArrayList:<init>	()V
    //   2438: astore_1
    //   2439: aload_1
    //   2440: aload_0
    //   2441: getstatic 74	com/tencent/mobileqq/msgforward/AIOShareActionSheet:t	Ljava/lang/String;
    //   2444: invokevirtual 753	com/tencent/mobileqq/msgforward/AIOShareActionSheet:b	(Ljava/lang/String;)Landroid/net/Uri;
    //   2447: invokevirtual 516	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2450: pop
    //   2451: aload 10
    //   2453: invokeinterface 425 1 0
    //   2458: ifne +121 -> 2579
    //   2461: aload 10
    //   2463: invokeinterface 263 1 0
    //   2468: astore_2
    //   2469: aload_2
    //   2470: invokeinterface 269 1 0
    //   2475: ifeq +104 -> 2579
    //   2478: aload_2
    //   2479: invokeinterface 273 1 0
    //   2484: checkcast 185	java/lang/String
    //   2487: astore 7
    //   2489: new 41	java/lang/StringBuilder
    //   2492: dup
    //   2493: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   2496: astore 8
    //   2498: aload 8
    //   2500: getstatic 66	com/tencent/mobileqq/msgforward/AIOShareActionSheet:d	Ljava/lang/String;
    //   2503: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2506: pop
    //   2507: aload 8
    //   2509: aload 19
    //   2511: aload 10
    //   2513: aload 7
    //   2515: invokeinterface 756 2 0
    //   2520: invokeinterface 242 2 0
    //   2525: checkcast 185	java/lang/String
    //   2528: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2531: pop
    //   2532: aload 7
    //   2534: aload 8
    //   2536: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2539: invokestatic 760	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   2542: ifne +6 -> 2548
    //   2545: goto -76 -> 2469
    //   2548: aload_1
    //   2549: aload_0
    //   2550: aload 19
    //   2552: aload 10
    //   2554: aload 7
    //   2556: invokeinterface 756 2 0
    //   2561: invokeinterface 242 2 0
    //   2566: checkcast 185	java/lang/String
    //   2569: invokevirtual 753	com/tencent/mobileqq/msgforward/AIOShareActionSheet:b	(Ljava/lang/String;)Landroid/net/Uri;
    //   2572: invokevirtual 516	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2575: pop
    //   2576: goto -107 -> 2469
    //   2579: aload 11
    //   2581: invokeinterface 425 1 0
    //   2586: ifne +121 -> 2707
    //   2589: aload 11
    //   2591: invokeinterface 263 1 0
    //   2596: astore_2
    //   2597: aload_2
    //   2598: invokeinterface 269 1 0
    //   2603: ifeq +104 -> 2707
    //   2606: aload_2
    //   2607: invokeinterface 273 1 0
    //   2612: checkcast 185	java/lang/String
    //   2615: astore 7
    //   2617: new 41	java/lang/StringBuilder
    //   2620: dup
    //   2621: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   2624: astore 8
    //   2626: aload 8
    //   2628: getstatic 66	com/tencent/mobileqq/msgforward/AIOShareActionSheet:d	Ljava/lang/String;
    //   2631: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2634: pop
    //   2635: aload 8
    //   2637: aload 9
    //   2639: aload 11
    //   2641: aload 7
    //   2643: invokeinterface 756 2 0
    //   2648: invokeinterface 242 2 0
    //   2653: checkcast 185	java/lang/String
    //   2656: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2659: pop
    //   2660: aload 7
    //   2662: aload 8
    //   2664: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2667: invokestatic 760	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   2670: ifne +6 -> 2676
    //   2673: goto +31 -> 2704
    //   2676: aload_1
    //   2677: aload_0
    //   2678: aload 9
    //   2680: aload 11
    //   2682: aload 7
    //   2684: invokeinterface 756 2 0
    //   2689: invokeinterface 242 2 0
    //   2694: checkcast 185	java/lang/String
    //   2697: invokevirtual 753	com/tencent/mobileqq/msgforward/AIOShareActionSheet:b	(Ljava/lang/String;)Landroid/net/Uri;
    //   2700: invokevirtual 516	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2703: pop
    //   2704: goto -107 -> 2597
    //   2707: aload_3
    //   2708: ldc_w 762
    //   2711: aload_1
    //   2712: invokevirtual 765	android/content/Intent:putParcelableArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   2715: pop
    //   2716: getstatic 770	android/os/Build$VERSION:SDK_INT	I
    //   2719: bipush 24
    //   2721: if_icmplt +9 -> 2730
    //   2724: aload_3
    //   2725: iconst_1
    //   2726: invokevirtual 774	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2729: pop
    //   2730: return
    //   2731: aload 12
    //   2733: ifnull +16 -> 2749
    //   2736: aload 12
    //   2738: invokevirtual 745	java/io/BufferedWriter:close	()V
    //   2741: goto +8 -> 2749
    //   2744: astore_2
    //   2745: aload_2
    //   2746: invokevirtual 750	java/io/IOException:printStackTrace	()V
    //   2749: goto +5 -> 2754
    //   2752: aload_1
    //   2753: athrow
    //   2754: goto -2 -> 2752
    //   2757: aload 15
    //   2759: astore 11
    //   2761: goto -1169 -> 1592
    //   2764: aconst_null
    //   2765: astore 11
    //   2767: goto -1175 -> 1592
    //   2770: aload 14
    //   2772: astore 11
    //   2774: iload 4
    //   2776: iconst_1
    //   2777: iadd
    //   2778: istore 4
    //   2780: aload 11
    //   2782: astore 14
    //   2784: goto -1857 -> 927
    //   2787: astore_1
    //   2788: aload 11
    //   2790: astore 7
    //   2792: goto -576 -> 2216
    //   2795: astore_1
    //   2796: aload 11
    //   2798: astore 7
    //   2800: goto -584 -> 2216
    //   2803: astore_1
    //   2804: goto -588 -> 2216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2807	0	this	AIOShareActionSheet
    //   0	2807	1	paramMap	Map<String, String>
    //   0	2807	2	paramArrayList	ArrayList<ChatMessage>
    //   0	2807	3	paramIntent	Intent
    //   917	1862	4	i1	int
    //   947	516	5	i2	int
    //   972	377	6	bool	boolean
    //   141	2658	7	localObject1	Object
    //   69	2594	8	localObject2	Object
    //   243	2436	9	localObject3	Object
    //   252	2301	10	localObject4	Object
    //   2	1032	11	localObject5	Object
    //   1038	1	11	localThrowable1	java.lang.Throwable
    //   1077	292	11	localObject6	Object
    //   1380	21	11	localThrowable2	java.lang.Throwable
    //   1406	890	11	localObject7	Object
    //   2312	1	11	localThrowable3	java.lang.Throwable
    //   2335	1	11	localThrowable4	java.lang.Throwable
    //   2344	31	11	localThrowable5	java.lang.Throwable
    //   2387	410	11	localObject8	Object
    //   286	1965	12	localObject9	Object
    //   2273	21	12	localThrowable6	java.lang.Throwable
    //   2366	371	12	localObject10	Object
    //   270	2092	13	localObject11	Object
    //   282	2501	14	localObject12	Object
    //   276	2482	15	localObject13	Object
    //   279	2043	16	localObject14	Object
    //   273	1967	17	localObject15	Object
    //   656	1204	18	localSimpleDateFormat	SimpleDateFormat
    //   261	2290	19	localArrayList	ArrayList
    //   427	1724	20	localStringBuilder	StringBuilder
    //   12	1567	21	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   979	1006	1038	java/lang/Throwable
    //   1009	1016	1038	java/lang/Throwable
    //   1020	1035	1038	java/lang/Throwable
    //   1065	1079	1038	java/lang/Throwable
    //   1113	1137	1038	java/lang/Throwable
    //   1159	1217	1265	java/lang/Throwable
    //   1140	1159	1269	java/lang/Throwable
    //   1098	1108	1273	java/lang/Throwable
    //   1248	1258	1373	java/lang/Throwable
    //   1353	1370	1373	java/lang/Throwable
    //   1469	1477	1484	finally
    //   1221	1233	1628	java/lang/Throwable
    //   1237	1244	1628	java/lang/Throwable
    //   1408	1425	1628	java/lang/Throwable
    //   1429	1437	1628	java/lang/Throwable
    //   1448	1458	1628	java/lang/Throwable
    //   1469	1477	1628	java/lang/Throwable
    //   1496	1503	1628	java/lang/Throwable
    //   1507	1518	1628	java/lang/Throwable
    //   1522	1531	1628	java/lang/Throwable
    //   1535	1543	1628	java/lang/Throwable
    //   1547	1556	1628	java/lang/Throwable
    //   1560	1574	1628	java/lang/Throwable
    //   1578	1585	1628	java/lang/Throwable
    //   1613	1621	1628	java/lang/Throwable
    //   1304	1312	1646	java/lang/Throwable
    //   1315	1348	1646	java/lang/Throwable
    //   2159	2173	2199	java/lang/Throwable
    //   1699	1718	2211	java/lang/Throwable
    //   1726	1736	2211	java/lang/Throwable
    //   1740	1749	2211	java/lang/Throwable
    //   1753	1761	2211	java/lang/Throwable
    //   1765	1774	2211	java/lang/Throwable
    //   1778	1787	2211	java/lang/Throwable
    //   1791	1800	2211	java/lang/Throwable
    //   1804	1812	2211	java/lang/Throwable
    //   1816	1825	2211	java/lang/Throwable
    //   1829	1839	2211	java/lang/Throwable
    //   1847	1855	2211	java/lang/Throwable
    //   1859	1878	2211	java/lang/Throwable
    //   1882	1891	2211	java/lang/Throwable
    //   1895	1915	2211	java/lang/Throwable
    //   1919	1928	2211	java/lang/Throwable
    //   1932	1940	2211	java/lang/Throwable
    //   1944	1953	2211	java/lang/Throwable
    //   1957	1965	2211	java/lang/Throwable
    //   1969	1978	2211	java/lang/Throwable
    //   1982	1991	2211	java/lang/Throwable
    //   1995	2015	2211	java/lang/Throwable
    //   2019	2028	2211	java/lang/Throwable
    //   2032	2040	2211	java/lang/Throwable
    //   2044	2053	2211	java/lang/Throwable
    //   2057	2067	2211	java/lang/Throwable
    //   2071	2080	2211	java/lang/Throwable
    //   2084	2092	2211	java/lang/Throwable
    //   2096	2105	2211	java/lang/Throwable
    //   2109	2119	2211	java/lang/Throwable
    //   2137	2146	2211	java/lang/Throwable
    //   2150	2159	2211	java/lang/Throwable
    //   420	429	2230	finally
    //   445	454	2230	finally
    //   470	479	2230	finally
    //   495	503	2230	finally
    //   519	528	2230	finally
    //   544	553	2230	finally
    //   569	577	2230	finally
    //   593	602	2230	finally
    //   618	628	2230	finally
    //   644	658	2230	finally
    //   674	682	2230	finally
    //   698	717	2230	finally
    //   733	742	2230	finally
    //   758	766	2230	finally
    //   782	791	2230	finally
    //   807	816	2230	finally
    //   832	841	2230	finally
    //   857	865	2230	finally
    //   881	890	2230	finally
    //   906	916	2230	finally
    //   943	949	2230	finally
    //   956	974	2230	finally
    //   979	1006	2230	finally
    //   1009	1016	2230	finally
    //   1020	1035	2230	finally
    //   1053	1060	2230	finally
    //   1065	1079	2230	finally
    //   1086	1093	2230	finally
    //   1098	1108	2230	finally
    //   1113	1137	2230	finally
    //   1140	1159	2230	finally
    //   1159	1217	2230	finally
    //   1221	1233	2230	finally
    //   1237	1244	2230	finally
    //   1248	1258	2230	finally
    //   1292	1299	2230	finally
    //   1304	1312	2230	finally
    //   1315	1348	2230	finally
    //   1353	1370	2230	finally
    //   1408	1425	2230	finally
    //   1429	1437	2230	finally
    //   1448	1458	2230	finally
    //   1496	1503	2230	finally
    //   1507	1518	2230	finally
    //   1522	1531	2230	finally
    //   1535	1543	2230	finally
    //   1547	1556	2230	finally
    //   1560	1574	2230	finally
    //   1578	1585	2230	finally
    //   1613	1621	2230	finally
    //   1662	1678	2230	finally
    //   1687	1695	2230	finally
    //   1699	1718	2230	finally
    //   1726	1736	2230	finally
    //   1740	1749	2230	finally
    //   1753	1761	2230	finally
    //   1765	1774	2230	finally
    //   1778	1787	2230	finally
    //   1791	1800	2230	finally
    //   1804	1812	2230	finally
    //   1816	1825	2230	finally
    //   1829	1839	2230	finally
    //   1847	1855	2230	finally
    //   1859	1878	2230	finally
    //   1882	1891	2230	finally
    //   1895	1915	2230	finally
    //   1919	1928	2230	finally
    //   1932	1940	2230	finally
    //   1944	1953	2230	finally
    //   1957	1965	2230	finally
    //   1969	1978	2230	finally
    //   1982	1991	2230	finally
    //   1995	2015	2230	finally
    //   2019	2028	2230	finally
    //   2032	2040	2230	finally
    //   2044	2053	2230	finally
    //   2057	2067	2230	finally
    //   2071	2080	2230	finally
    //   2084	2092	2230	finally
    //   2096	2105	2230	finally
    //   2109	2119	2230	finally
    //   2137	2146	2230	finally
    //   2150	2159	2230	finally
    //   2159	2173	2230	finally
    //   420	429	2238	java/lang/Throwable
    //   445	454	2238	java/lang/Throwable
    //   470	479	2238	java/lang/Throwable
    //   495	503	2238	java/lang/Throwable
    //   519	528	2238	java/lang/Throwable
    //   544	553	2238	java/lang/Throwable
    //   569	577	2238	java/lang/Throwable
    //   593	602	2238	java/lang/Throwable
    //   618	628	2238	java/lang/Throwable
    //   644	658	2238	java/lang/Throwable
    //   674	682	2238	java/lang/Throwable
    //   698	717	2238	java/lang/Throwable
    //   733	742	2238	java/lang/Throwable
    //   758	766	2238	java/lang/Throwable
    //   782	791	2238	java/lang/Throwable
    //   807	816	2238	java/lang/Throwable
    //   832	841	2238	java/lang/Throwable
    //   857	865	2238	java/lang/Throwable
    //   881	890	2238	java/lang/Throwable
    //   906	916	2238	java/lang/Throwable
    //   943	949	2238	java/lang/Throwable
    //   357	366	2273	java/lang/Throwable
    //   370	379	2273	java/lang/Throwable
    //   383	404	2273	java/lang/Throwable
    //   344	353	2312	java/lang/Throwable
    //   301	310	2335	java/lang/Throwable
    //   314	323	2335	java/lang/Throwable
    //   327	336	2335	java/lang/Throwable
    //   288	297	2340	finally
    //   301	310	2340	finally
    //   314	323	2340	finally
    //   327	336	2340	finally
    //   344	353	2340	finally
    //   357	366	2340	finally
    //   370	379	2340	finally
    //   383	404	2340	finally
    //   2368	2379	2340	finally
    //   288	297	2344	java/lang/Throwable
    //   2184	2189	2422	java/io/IOException
    //   2404	2409	2422	java/io/IOException
    //   2736	2741	2744	java/io/IOException
    //   1662	1678	2787	java/lang/Throwable
    //   1687	1695	2787	java/lang/Throwable
    //   1292	1299	2795	java/lang/Throwable
    //   956	974	2803	java/lang/Throwable
    //   1053	1060	2803	java/lang/Throwable
    //   1086	1093	2803	java/lang/Throwable
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    boolean bool = paramChatMessage instanceof MessageForPic;
    if ((bool) && (((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(paramChatMessage))) {
      return false;
    }
    if ((!(paramChatMessage instanceof MessageForTroopFile)) && (!(paramChatMessage instanceof MessageForQQStoryComment)))
    {
      if ((paramChatMessage instanceof MessageForArkApp)) {
        return false;
      }
      if ((paramChatMessage instanceof MessageForStructing))
      {
        MessageForStructing localMessageForStructing = (MessageForStructing)paramChatMessage;
        if ((localMessageForStructing.structingMsg != null) && ("viewMultiMsg".equals(localMessageForStructing.structingMsg.mMsgAction))) {
          return true;
        }
      }
      else if ((bool) && (ZhituManager.a((MessageForPic)paramChatMessage)))
      {
        return false;
      }
      return MultiMsgProxy.a(paramChatMessage);
    }
    return false;
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    int i1;
    if (AIOUtils.a(2) == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (AIOUtils.a(3) == 0) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    Object localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = paramContext.getString(2131894192);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839225;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 9;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = paramContext.getString(2131894178);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839480;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 25;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    if (this.s)
    {
      localObject = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = paramContext.getString(2131889842);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130840469;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 50;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
      localArrayList.add(localObject);
    }
    localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = paramContext.getString(2131889847);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130847328;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 11;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    if (i1 != 0)
    {
      localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
      if (QFileAssistantUtils.a(this.a)) {
        localActionSheetItem.label = paramContext.getString(2131894177);
      } else {
        localActionSheetItem.label = paramContext.getString(2131894180);
      }
      localActionSheetItem.icon = 2130839515;
      localActionSheetItem.iconNeedBg = true;
      localActionSheetItem.action = 26;
      localActionSheetItem.argus = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    if (UpComingMsgUtil.a(this.r.ah.a))
    {
      localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
      localActionSheetItem.label = paramContext.getString(2131886600);
      localActionSheetItem.icon = 2130837934;
      localActionSheetItem.iconNeedBg = true;
      localActionSheetItem.action = 139;
      localActionSheetItem.argus = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    if (i2 != 0)
    {
      localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
      localActionSheetItem.label = paramContext.getString(2131894195);
      localActionSheetItem.icon = 2130839670;
      localActionSheetItem.iconNeedBg = true;
      localActionSheetItem.action = 27;
      localActionSheetItem.argus = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894175);
    localActionSheetItem.icon = 2130839217;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 28;
    localActionSheetItem.argus = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894170);
    localActionSheetItem.icon = 2130840355;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 47;
    localActionSheetItem.argus = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  public Uri b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d);
    localStringBuilder.append(paramString);
    paramString = new File(localStringBuilder.toString());
    if (Build.VERSION.SDK_INT >= 24) {
      return FileProvider.getUriForFile(this.q, "com.tencent.mobileqq.fileprovider", paramString);
    }
    return Uri.fromFile(paramString);
  }
  
  public void b()
  {
    Iterator localIterator = MultiMsgManager.a().i().iterator();
    ChatMessage localChatMessage;
    int i1;
    do
    {
      boolean bool2 = localIterator.hasNext();
      bool1 = true;
      if (!bool2) {
        break;
      }
      localChatMessage = (ChatMessage)localIterator.next();
      i1 = ItemBuilderFactory.a(this.a, localChatMessage);
    } while ((!(localChatMessage instanceof MessageForPic)) || (i1 != 1) || (MsgUtils.a(this.a, (MessageForPic)localChatMessage, false)));
    break label85;
    boolean bool1 = false;
    label85:
    if ((this.b == null) || (this.s != bool1))
    {
      this.s = bool1;
      this.b = new ShareActionSheetBuilder(this.p);
      i1 = DisplayUtil.dip2px(this.q, 4.0F);
      int i2 = this.b.getIconMarginLeftRight();
      this.b.setIconMarginLeftRight(Math.max(i1, i2));
      this.b.setActionSheetTitle(this.q.getString(2131916565));
      this.b.setActionSheetItems(a(this.q));
      this.b.setItemClickListener(this);
    }
    try
    {
      this.b.show();
      ReportController.b(this.a, "CliOper", "", this.a.getCurrentAccountUin(), m, m, 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShareActionSheet", 2, "actionSheet.show exception=", localException);
      }
    }
  }
  
  public void b(FileSaveResult paramFileSaveResult) {}
  
  public void b(Map<String, String> paramMap, ArrayList<ChatMessage> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      ChatMessage localChatMessage = (ChatMessage)paramArrayList.get(i1);
      MessageForStructing localMessageForStructing = null;
      Object localObject2 = null;
      Object localObject1;
      if ((localChatMessage instanceof MessageForText))
      {
        localObject1 = (MessageForText)localChatMessage;
        if (((MessageForText)localObject1).sb != null) {
          localObject2 = ((MessageForText)localObject1).sb.toString();
        } else {
          localObject2 = ((MessageForText)localObject1).msg;
        }
        localObject1 = localObject2;
        if (TextUtils.hasSysEmotion((String)localObject2)) {
          localObject1 = TextUtils.Symbol2FavoriteSymbol((String)localObject2);
        }
      }
      else if ((localChatMessage instanceof MessageForPic))
      {
        localObject1 = HardCodeUtil.a(2131898382);
      }
      else if ((localChatMessage instanceof MessageForShortVideo))
      {
        localObject1 = HardCodeUtil.a(2131898386);
      }
      else if ((!(localChatMessage instanceof MessageForMixedMsg)) && (!(localChatMessage instanceof MessageForLongMsg)))
      {
        if ((localChatMessage instanceof MessageForStructing))
        {
          localMessageForStructing = (MessageForStructing)localChatMessage;
          if (localMessageForStructing.structingMsg != null) {
            if ((localMessageForStructing.structingMsg instanceof StructMsgForHypertext))
            {
              localObject2 = ((StructMsgForHypertext)localMessageForStructing.structingMsg).getSpannableString(false).toString();
            }
            else if (localMessageForStructing.structingMsg.mMsgServiceID == 32)
            {
              localObject2 = a(localMessageForStructing);
            }
            else
            {
              localObject1 = localMessageForStructing.getSummaryMsg();
              localObject2 = localObject1;
              if (localMessageForStructing.structingMsg.mMsgUrl != null)
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append((String)localObject1);
                ((StringBuilder)localObject2).append("\n");
                ((StringBuilder)localObject2).append(localMessageForStructing.structingMsg.mMsgUrl);
                localObject2 = ((StringBuilder)localObject2).toString();
              }
            }
          }
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = HardCodeUtil.a(2131898388);
          }
        }
        else
        {
          localObject1 = localMessageForStructing;
          if ((localChatMessage instanceof MessageForArkFlashChat))
          {
            localObject1 = localMessageForStructing;
            if (localChatMessage.msg != null) {
              localObject1 = localChatMessage.msg;
            }
          }
        }
      }
      else
      {
        localObject1 = MessageForMixedMsg.getTextFromMixedMsg(localChatMessage).toString();
      }
      if (localObject1 != null)
      {
        localObject2 = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
        ((SimpleDateFormat)localObject2).applyPattern("HH:mm:ss");
        localObject2 = ((SimpleDateFormat)localObject2).format(Long.valueOf(localChatMessage.time * 1000L));
        localStringBuilder.append((String)paramMap.get(localChatMessage.senderuin));
        localStringBuilder.append(" ");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("\n");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("\n");
        if (i1 != paramArrayList.size() - 1) {
          localStringBuilder.append("\n");
        }
      }
      i1 += 1;
    }
    paramMap = (ClipboardManager)this.q.getSystemService("clipboard");
    paramArrayList = ClipData.newPlainText("simple text", localStringBuilder.toString());
    ClipboardMonitor.setPrimaryClip(paramMap, paramArrayList);
    paramMap.setPrimaryClip(paramArrayList);
    QQToast.makeText(this.a.getApp(), 2131892028, 0).show(this.r.A());
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    boolean bool = paramChatMessage instanceof MessageForPic;
    if ((bool) && (((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(paramChatMessage))) {
      return false;
    }
    if ((!(paramChatMessage instanceof MessageForTroopFile)) && (!(paramChatMessage instanceof MessageForQQStoryComment)))
    {
      if ((paramChatMessage instanceof MessageForArkApp)) {
        return false;
      }
      if ((bool) && (ZhituManager.a((MessageForPic)paramChatMessage))) {
        return false;
      }
      return MultiMsgProxy.a(paramChatMessage);
    }
    return false;
  }
  
  public void c()
  {
    ShareActionSheetBuilder localShareActionSheetBuilder = this.b;
    if (localShareActionSheetBuilder != null)
    {
      localShareActionSheetBuilder.setItemClickListener(null);
      this.b.dismiss();
    }
    if (this.o != null) {
      WXShareHelper.a().b(this.o);
    }
  }
  
  public boolean d()
  {
    Iterator localIterator = MultiMsgManager.a().b.entrySet().iterator();
    boolean bool2 = false;
    int i1 = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (((Boolean)((Map.Entry)localObject).getValue()).booleanValue())
      {
        localObject = (ChatMessage)((Map.Entry)localObject).getKey();
        boolean bool1 = i1 | ((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg((MessageRecord)localObject);
        if (!MultiMsgProxy.b(this.a, (ChatMessage)localObject)) {
          return false;
        }
        i1 = bool1;
        if ((localObject instanceof MessageForTroopFile))
        {
          localObject = (MessageForTroopFile)localObject;
          localObject = TroopFileUtils.a(this.a, (MessageForTroopFile)localObject);
          if (localObject != null)
          {
            i1 = bool1;
            if (((TroopFileStatusInfo)localObject).e != 8)
            {
              i1 = bool1;
              if (((TroopFileStatusInfo)localObject).e != 9)
              {
                i1 = bool1;
                if (((TroopFileStatusInfo)localObject).e != 6)
                {
                  i1 = bool1;
                  if (((TroopFileStatusInfo)localObject).e != 7) {
                    if (((TroopFileStatusInfo)localObject).e == 11)
                    {
                      i1 = bool1;
                      if (FileUtil.d(((TroopFileStatusInfo)localObject).k)) {
                        break;
                      }
                    }
                    else
                    {
                      i1 = bool1;
                      if (((TroopFileStatusInfo)localObject).e == 10) {
                        break;
                      }
                    }
                  }
                }
              }
            }
          }
          else
          {
            return false;
          }
        }
      }
    }
    if (i1 == 0) {
      bool2 = true;
    }
    return bool2;
  }
  
  public boolean e()
  {
    Iterator localIterator = MultiMsgManager.a().b.entrySet().iterator();
    boolean bool2 = false;
    int i1 = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (((Boolean)((Map.Entry)localObject).getValue()).booleanValue())
      {
        localObject = (ChatMessage)((Map.Entry)localObject).getKey();
        boolean bool1 = i1 | ((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg((MessageRecord)localObject);
        if (!MultiMsgProxy.a(this.a, (ChatMessage)localObject)) {
          return false;
        }
        i1 = bool1;
        if ((localObject instanceof MessageForTroopFile))
        {
          localObject = (MessageForTroopFile)localObject;
          i1 = bool1;
          if (TroopFileUtils.a(this.a, (MessageForTroopFile)localObject) == null) {
            return false;
          }
        }
      }
    }
    if (i1 == 0) {
      bool2 = true;
    }
    return bool2;
  }
  
  public boolean f()
  {
    if (!NetworkUtil.isNetSupport(this.q))
    {
      QQToast.makeText(this.a.getApp(), 2131889169, 0).show(this.r.A());
      return false;
    }
    Object localObject1 = MultiMsgManager.a().i();
    if (((List)localObject1).size() == 0)
    {
      QQToast.makeText(this.a.getApp(), 2131896469, 0).show(this.r.A());
      return false;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i1 = 0;
    Object localObject2;
    while (i1 < ((List)localObject1).size())
    {
      localObject2 = (ChatMessage)((List)localObject1).get(i1);
      if ((localObject2 instanceof MessageForTroopFile)) {
        localArrayList1.add((MessageForTroopFile)localObject2);
      } else if ((localObject2 instanceof MessageForFile)) {
        localArrayList2.add((MessageForFile)localObject2);
      }
      i1 += 1;
    }
    if (localArrayList1.size() > 0)
    {
      localObject1 = localArrayList1.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageForTroopFile)((Iterator)localObject1).next();
        TroopFileUtils.a(this.q, this.a, (ChatMessage)localObject2);
      }
    }
    if (localArrayList2.size() > 0)
    {
      localObject1 = new ArrayList();
      localObject2 = localArrayList2.iterator();
      MessageForFile localMessageForFile;
      FileManagerEntity localFileManagerEntity;
      while (((Iterator)localObject2).hasNext())
      {
        localMessageForFile = (MessageForFile)((Iterator)localObject2).next();
        localFileManagerEntity = FileManagerUtil.a(this.a, localMessageForFile);
        if ((localFileManagerEntity.cloudType != 0) && (localFileManagerEntity.cloudType != 2)) {
          ((ArrayList)localObject1).add(localMessageForFile);
        }
      }
      if (((ArrayList)localObject1).size() == 0)
      {
        FMToastUtil.a(2131889578);
        return false;
      }
      if (((ArrayList)localObject1).size() == 1)
      {
        localObject1 = (MessageForFile)((ArrayList)localObject1).get(0);
        localObject2 = FileManagerUtil.a(this.a, (MessageForFile)localObject1);
        if (localObject2 == null)
        {
          FMToastUtil.a(2131889578);
          return false;
        }
        if (((FileManagerEntity)localObject2).status == 16)
        {
          FMToastUtil.a(2131889788);
          return false;
        }
        FileManagerUtil.b(this.a, (ChatMessage)localObject1, BaseActivity.sTopActivity);
      }
      else
      {
        localObject2 = new ArrayList();
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localMessageForFile = (MessageForFile)((Iterator)localObject1).next();
          localFileManagerEntity = FileManagerUtil.a(this.a, localMessageForFile);
          if ((localFileManagerEntity != null) && (localFileManagerEntity.status != 16)) {
            ((List)localObject2).add(localMessageForFile);
          }
        }
        if (((List)localObject2).size() == 0)
        {
          FMToastUtil.a(2131889578);
          return false;
        }
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageForFile)((Iterator)localObject1).next();
          FileManagerUtil.b(this.a, (ChatMessage)localObject2, BaseActivity.sTopActivity);
        }
      }
    }
    if ((localArrayList1.size() == 0) && (localArrayList2.size() == 0))
    {
      FMToastUtil.a(2131889579);
      return false;
    }
    return true;
  }
  
  public boolean g()
  {
    if (!NetworkUtil.isNetSupport(this.q))
    {
      QQToast.makeText(this.a.getApp(), 2131889169, 0).show(this.r.A());
      return false;
    }
    Object localObject = MultiMsgManager.a().i();
    if (((List)localObject).size() == 0)
    {
      QQToast.makeText(this.a.getApp(), 2131896469, 0).show(this.r.A());
      return false;
    }
    localObject = MultiMsgUtil.a(this.a, (ArrayList)localObject);
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return false;
      }
      DatalineDeviceChooseModel.b((List)localObject).a(this.q, this.a, new AIOShareActionSheet.12(this, (List)localObject));
      return true;
    }
    return false;
  }
  
  public boolean h()
  {
    Iterator localIterator = MultiMsgManager.a().b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Boolean)localEntry.getValue()).booleanValue()) && (!a((ChatMessage)localEntry.getKey()))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean i()
  {
    List localList = MultiMsgManager.a().i();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (!a(localChatMessage)) {
        localArrayList.add(localChatMessage);
      }
    }
    localList.removeAll(localArrayList);
    if (localList.isEmpty())
    {
      QQToast.makeText(this.a.getApp(), 2131892021, 0).show(this.r.A());
      return false;
    }
    ((MultiForwardHelper)this.r.q(1)).a(localList, 3);
    return true;
  }
  
  public void j()
  {
    List localList = MultiMsgManager.a().i();
    ((AIOUpComingMsgHelper)this.r.q(59)).b(localList, System.currentTimeMillis() + 60000L, 2);
  }
  
  public boolean k()
  {
    Iterator localIterator = MultiMsgManager.a().b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Boolean)localEntry.getValue()).booleanValue()) && (!b((ChatMessage)localEntry.getKey()))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean l()
  {
    List localList = MultiMsgManager.a().i();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (!b(localChatMessage)) {
        localArrayList.add(localChatMessage);
      }
    }
    localList.removeAll(localArrayList);
    if (localList.isEmpty())
    {
      QQToast.makeText(this.a.getApp(), 2131892027, 0).show(this.r.A());
      return false;
    }
    ((MultiForwardHelper)this.r.q(1)).a(localList, 4);
    return true;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 != null)
    {
      this.b.dismiss();
      int i1 = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.action;
      Object localObject2;
      if (i1 != 9)
      {
        if (i1 != 11)
        {
          Object localObject3;
          Object localObject4;
          Object localObject5;
          if (i1 != 47)
          {
            if (i1 != 50)
            {
              if (i1 != 139) {
                switch (i1)
                {
                default: 
                  break;
                case 28: 
                  localObject1 = this.a;
                  localObject2 = k;
                  ReportController.b((AppRuntime)localObject1, "CliOper", "", "", (String)localObject2, (String)localObject2, 0, 0, "", "", "", "");
                  if (!k()) {
                    DialogUtil.a(this.q, 230).setMessage(this.q.getString(2131892026)).setPositiveButton(17039370, new AIOShareActionSheet.9(this)).setNegativeButton(17039360, new AIOShareActionSheet.8(this)).show();
                  } else if ((!MultiMsgManager.a().i().isEmpty()) && (l())) {
                    this.r.a(false, null, false);
                  }
                  break;
                case 27: 
                  localObject1 = this.a;
                  localObject2 = j;
                  ReportController.b((AppRuntime)localObject1, "CliOper", "", "", (String)localObject2, (String)localObject2, 0, 0, "", "", "", "");
                  if (!d()) {
                    DialogUtil.a(this.q, 230).setMessage(this.q.getString(2131892029)).setPositiveButton(17039370, new AIOShareActionSheet.7(this)).setNegativeButton(17039360, new AIOShareActionSheet.6(this)).show();
                  } else if (WeiyunAIOUtils.a(this.a, this.p, this.r.A(), this.c)) {
                    this.r.a(false, null, false);
                  }
                  break;
                case 26: 
                  boolean bool;
                  if (QFileAssistantUtils.a(this.a))
                  {
                    bool = g();
                  }
                  else
                  {
                    if (!e())
                    {
                      DialogUtil.a(this.q, 230).setMessage(this.q.getString(2131892031)).setPositiveButton(17039370, new AIOShareActionSheet.5(this)).setNegativeButton(17039360, new AIOShareActionSheet.4(this)).show();
                      break;
                    }
                    bool = f();
                  }
                  ReportController.b(this.a, "CliOper", "", "", "0X80067F7", "0X80067F7", 0, 0, "", "", "", "");
                  if (!bool) {
                    break;
                  }
                  this.r.a(false, null, false);
                  break;
                case 25: 
                  localObject1 = this.a;
                  localObject2 = i;
                  ReportController.b((AppRuntime)localObject1, "CliOper", "", "", (String)localObject2, (String)localObject2, 0, 0, "", "", "", "");
                  if (!h()) {
                    DialogUtil.a(this.q, 230).setMessage(this.q.getString(2131892020)).setPositiveButton(17039370, new AIOShareActionSheet.3(this)).setNegativeButton(17039360, new AIOShareActionSheet.2(this)).show();
                  } else if ((!MultiMsgManager.a().i().isEmpty()) && (i())) {
                    this.r.a(false, null, false);
                  }
                  break;
                }
              } else {
                j();
              }
            }
            else
            {
              localObject1 = this.a;
              localObject2 = l;
              ReportController.b((AppRuntime)localObject1, "CliOper", "", "", (String)localObject2, (String)localObject2, 0, 0, "", "", "", "");
              localObject2 = MultiMsgManager.a().i();
              localObject1 = new ArrayList();
              localObject2 = ((List)localObject2).iterator();
              i1 = 0;
              int i2;
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (ChatMessage)((Iterator)localObject2).next();
                i2 = ItemBuilderFactory.a(this.a, (ChatMessage)localObject3);
                if (((localObject3 instanceof MessageForPic)) && (i2 == 1))
                {
                  if (!MsgUtils.a(this.a, (MessageForPic)localObject3, false)) {
                    ((List)localObject1).add((MessageForPic)((ChatMessage)localObject3).deepCopyByReflect());
                  }
                }
                else {
                  i1 = 1;
                }
              }
              if (((List)localObject1).isEmpty())
              {
                localObject1 = this.q;
                QQToast.makeText((Context)localObject1, ((Context)localObject1).getString(2131915876), 0).show();
              }
              else
              {
                localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
                localObject3 = this.r.ah.c;
                localObject4 = this.r.ah.b;
                i2 = this.r.ah.a;
                if (i1 != 0)
                {
                  localObject5 = this.q;
                  QQToast.makeText((Context)localObject5, ((Context)localObject5).getString(2131915876), 0).show();
                }
                AIOGalleryUtils.a(this.p, (String)localObject2, (String)localObject3, (String)localObject4, i2, (List)localObject1, 102);
              }
            }
          }
          else
          {
            localObject2 = new FileSaveDialog(this.p);
            localObject1 = (MultiRichMediaSaveManager)this.a.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
            if (localObject1 != null)
            {
              localObject3 = this.r;
              if ((localObject3 != null) && (((BaseChatPie)localObject3).V != null))
              {
                localObject3 = new ArrayList();
                localObject4 = MultiMsgManager.a().b.entrySet().iterator();
                while (((Iterator)localObject4).hasNext())
                {
                  localObject5 = (Map.Entry)((Iterator)localObject4).next();
                  if (((Boolean)((Map.Entry)localObject5).getValue()).booleanValue()) {
                    ((List)localObject3).add(((Map.Entry)localObject5).getKey());
                  }
                }
                localObject3 = FileSaveReq.a(this.a, (List)localObject3, this.r.V.c, this);
                if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
                {
                  if (!CheckPermission.isHasStoragePermission(this.p))
                  {
                    CheckPermission.requestStorePermission(this.p, null);
                  }
                  else
                  {
                    ((MultiRichMediaSaveManager)localObject1).a(new AIOShareActionSheet.10(this, (FileSaveDialog)localObject2, (MultiRichMediaSaveManager)localObject1, (List)localObject3));
                    ((MultiRichMediaSaveManager)localObject1).a((List)localObject3, true);
                    localObject2 = this.r;
                    if ((localObject2 != null) && (((BaseChatPie)localObject2).ah != null)) {
                      ((MultiRichMediaSaveManager)localObject1).a((List)localObject3, 1, this.r.ah.a);
                    }
                  }
                }
                else
                {
                  localObject1 = this.q;
                  QQToast.makeText((Context)localObject1, ((Context)localObject1).getString(2131915875), 0).show();
                }
              }
            }
          }
        }
        else
        {
          m();
        }
      }
      else
      {
        localObject1 = this.a;
        localObject2 = h;
        ReportController.b((AppRuntime)localObject1, "CliOper", "", "", (String)localObject2, (String)localObject2, 0, 0, "", "", "", "");
        if (!WXShareHelper.a().b()) {
          i1 = 2131891948;
        } else if (!WXShareHelper.a().c()) {
          i1 = 2131918155;
        } else {
          i1 = -1;
        }
        if (i1 != -1)
        {
          QQToast.makeText(this.a.getApp(), this.q.getString(i1), 0).show();
        }
        else
        {
          if (this.o != null) {
            this.o = new AIOShareActionSheet.1(this);
          }
          WXShareHelper.a().a(this.o);
          ((MultiForwardHelper)this.r.q(1)).a(this.r.V, true);
        }
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgforward.AIOShareActionSheet
 * JD-Core Version:    0.7.0.1
 */