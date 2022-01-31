package com.tencent.mobileqq.msgforward;

import aeiw;
import aeix;
import aeiy;
import aeiz;
import aeja;
import aejb;
import aejc;
import aejd;
import aeje;
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
import android.os.Parcelable;
import android.support.v4.content.FileProvider;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.QQAppInterface;
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
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.lovelanguage.LoveLanguageManager;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
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
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
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
import mqq.os.MqqHandler;

public class AIOShareActionSheet
  implements AdapterView.OnItemClickListener
{
  public static String a;
  public static String b;
  public static String c = "0X8007F0B ";
  public static String d = "0X8007F0C ";
  public static String e = "0X8007F0D ";
  public static String f = "0X8007F0E ";
  public static String g = "0X8007F0F ";
  public static String h = "0X8007F10 ";
  private static String i;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  public QQAppInterface a;
  protected ShareActionSheetBuilder a;
  WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  public MqqHandler a;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aJ + "TempMail" + File.separator;
    i = "聊天记录.txt";
    jdField_b_of_type_JavaLangString = "0X8007F0A ";
  }
  
  public AIOShareActionSheet(QQAppInterface paramQQAppInterface, Context paramContext, Activity paramActivity, BaseChatPie paramBaseChatPie, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public static String a(MessageForPic paramMessageForPic)
  {
    URL localURL = URLDrawableHelper.a(paramMessageForPic, 131075);
    if (AbsDownloader.a(localURL.toString()) != null) {
      return AbsDownloader.d(localURL.toString());
    }
    localURL = URLDrawableHelper.a(paramMessageForPic, 1);
    if (AbsDownloader.a(localURL.toString()) != null) {
      return AbsDownloader.d(localURL.toString());
    }
    paramMessageForPic = URLDrawableHelper.a(paramMessageForPic, 65537);
    if (AbsDownloader.a(paramMessageForPic.toString()) != null) {
      return AbsDownloader.d(paramMessageForPic.toString());
    }
    return null;
  }
  
  public static String a(MessageForPic paramMessageForPic, List paramList1, List paramList2)
  {
    String str1 = a(paramMessageForPic);
    if (str1 == null)
    {
      QLog.e("AIOShareActionSheet", 1, new Object[] { "getPicMsgPath null, ", paramMessageForPic.getUserLogString() });
      return null;
    }
    paramList1.add(str1);
    String str2 = new File(str1).getName();
    paramMessageForPic = "";
    if (str2.indexOf(".") == -1) {
      paramMessageForPic = FileUtils.a(str1);
    }
    paramMessageForPic = "图片" + paramList1.size() + "." + paramMessageForPic;
    paramList1 = paramMessageForPic + " (可在附件中查看)";
    paramList2.add(paramMessageForPic);
    return paramList1;
  }
  
  public Uri a(String paramString)
  {
    paramString = new File(jdField_a_of_type_JavaLangString + paramString);
    if (Build.VERSION.SDK_INT >= 24) {
      return FileProvider.getUriForFile(this.jdField_a_of_type_AndroidContentContext, "com.tencent.mobileqq.fileprovider", paramString);
    }
    return Uri.fromFile(paramString);
  }
  
  public String a(MessageForStructing paramMessageForStructing)
  {
    String str = paramMessageForStructing.getSummaryMsg();
    if ((paramMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))
    {
      Object localObject2 = (StructMsgForGeneralShare)paramMessageForStructing.structingMsg;
      paramMessageForStructing = ((StructMsgForGeneralShare)localObject2).mContentSummary;
      Object localObject1 = paramMessageForStructing;
      if (paramMessageForStructing == null)
      {
        localObject1 = paramMessageForStructing;
        if (((StructMsgForGeneralShare)localObject2).mStructMsgItemLists != null)
        {
          localObject2 = ((StructMsgForGeneralShare)localObject2).mStructMsgItemLists.iterator();
          for (;;)
          {
            localObject1 = paramMessageForStructing;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            Object localObject3 = (AbsStructMsgElement)((Iterator)localObject2).next();
            localObject1 = paramMessageForStructing;
            if ((localObject3 instanceof StructMsgItemLayout2))
            {
              localObject3 = (StructMsgItemLayout2)localObject3;
              localObject1 = paramMessageForStructing;
              if (((StructMsgItemLayout2)localObject3).a != null)
              {
                localObject3 = ((StructMsgItemLayout2)localObject3).a.iterator();
                for (;;)
                {
                  localObject1 = paramMessageForStructing;
                  if (!((Iterator)localObject3).hasNext()) {
                    break;
                  }
                  localObject1 = (AbsStructMsgElement)((Iterator)localObject3).next();
                  if ((localObject1 instanceof StructMsgItemSummary)) {
                    paramMessageForStructing = ((StructMsgItemSummary)localObject1).A;
                  }
                }
              }
            }
            paramMessageForStructing = (MessageForStructing)localObject1;
          }
        }
      }
      if (localObject1 != null) {
        return str + (String)localObject1;
      }
    }
    return str;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(this.jdField_a_of_type_AndroidContentContext.getString(2131433100));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(a(this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(this);
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=", localException);
    }
  }
  
  public void a(Map paramMap, ArrayList paramArrayList)
  {
    if (paramArrayList.isEmpty()) {}
    Intent localIntent;
    label291:
    do
    {
      for (;;)
      {
        return;
        localIntent = new Intent("android.intent.action.SEND_MULTIPLE");
        localIntent.setType("message/rfc822");
        a(paramMap, paramArrayList, localIntent);
        for (;;)
        {
          Object localObject;
          try
          {
            paramArrayList = this.jdField_a_of_type_AndroidContentContext.getPackageManager().queryIntentActivities(localIntent, 0);
            if (paramArrayList.isEmpty()) {
              break;
            }
            paramMap = new ArrayList();
            paramArrayList = paramArrayList.iterator();
            if (!paramArrayList.hasNext()) {
              break label291;
            }
            localObject = (ResolveInfo)paramArrayList.next();
            if ((!((ResolveInfo)localObject).activityInfo.packageName.toLowerCase().contains("mail")) && (!((ResolveInfo)localObject).activityInfo.name.toLowerCase().contains("mail"))) {
              continue;
            }
            if (((ResolveInfo)localObject).activityInfo.packageName.equals("com.tencent.androidqqmail"))
            {
              if (((ResolveInfo)localObject).activityInfo.name.contains("LaunchComposeNote")) {
                continue;
              }
              localObject = new ComponentName(((ResolveInfo)localObject).activityInfo.applicationInfo.packageName, ((ResolveInfo)localObject).activityInfo.name);
              localIntent.setPackage(null);
              localIntent.setComponent((ComponentName)localObject);
              paramMap.add((Intent)localIntent.clone());
              continue;
            }
            if (((ResolveInfo)localObject).activityInfo.packageName.contains("bluetooth")) {
              continue;
            }
          }
          catch (Exception paramMap)
          {
            QLog.e("AIOShareActionSheet", 1, "realSendToMail error_2, ", paramMap);
            return;
          }
          if (!((ResolveInfo)localObject).activityInfo.name.contains("bluetooth"))
          {
            localIntent.setComponent(null);
            localIntent.setPackage(((ResolveInfo)localObject).activityInfo.packageName);
          }
        }
        try
        {
          paramArrayList = Intent.createChooser((Intent)paramMap.remove(0), "选择发送邮件客户端");
          if (paramArrayList != null)
          {
            paramArrayList.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])paramMap.toArray(new Parcelable[0]));
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramArrayList);
            return;
          }
        }
        catch (Exception paramMap)
        {
          QLog.e("AIOShareActionSheet", 1, "realSendToMail error_1, ", paramMap);
        }
      }
    } while (!(paramMap instanceof ClassCastException));
    paramMap = new ArrayList();
    paramMap.add(localIntent.getCharSequenceExtra("android.intent.extra.TEXT"));
    localIntent.removeExtra("android.intent.extra.TEXT");
    localIntent.putCharSequenceArrayListExtra("android.intent.extra.TEXT", paramMap);
    this.jdField_a_of_type_AndroidContentContext.startActivity(Intent.createChooser(localIntent, "选择发送邮件客户端"));
  }
  
  /* Error */
  public void a(Map paramMap, ArrayList paramArrayList, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokevirtual 422	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   5: checkcast 424	com/tencent/mobileqq/data/ChatMessage
    //   8: astore 6
    //   10: ldc 149
    //   12: astore 5
    //   14: aload 6
    //   16: getfield 427	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   19: ifne +744 -> 763
    //   22: aload_0
    //   23: getfield 91	com/tencent/mobileqq/msgforward/AIOShareActionSheet:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   26: ldc_w 428
    //   29: invokevirtual 257	android/content/Context:getString	(I)Ljava/lang/String;
    //   32: iconst_2
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: getfield 89	com/tencent/mobileqq/msgforward/AIOShareActionSheet:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   42: aload 6
    //   44: getfield 431	com/tencent/mobileqq/data/ChatMessage:selfuin	Ljava/lang/String;
    //   47: invokestatic 436	com/tencent/mobileqq/utils/ContactUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: aload_0
    //   54: getfield 89	com/tencent/mobileqq/msgforward/AIOShareActionSheet:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   57: aload 6
    //   59: getfield 439	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   62: invokestatic 436	com/tencent/mobileqq/utils/ContactUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   65: aastore
    //   66: invokestatic 443	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   69: astore 5
    //   71: aload_3
    //   72: ldc_w 445
    //   75: aload 5
    //   77: invokevirtual 448	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   80: pop
    //   81: getstatic 52	com/tencent/mobileqq/msgforward/AIOShareActionSheet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   84: iconst_1
    //   85: invokestatic 451	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Z)V
    //   88: new 43	java/io/File
    //   91: dup
    //   92: getstatic 52	com/tencent/mobileqq/msgforward/AIOShareActionSheet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   95: invokespecial 144	java/io/File:<init>	(Ljava/lang/String;)V
    //   98: astore 7
    //   100: aload 7
    //   102: invokevirtual 454	java/io/File:isDirectory	()Z
    //   105: ifeq +17 -> 122
    //   108: aload 7
    //   110: invokevirtual 457	java/io/File:exists	()Z
    //   113: ifne +9 -> 122
    //   116: aload 7
    //   118: invokevirtual 460	java/io/File:mkdirs	()Z
    //   121: pop
    //   122: new 235	java/util/ArrayList
    //   125: dup
    //   126: invokespecial 311	java/util/ArrayList:<init>	()V
    //   129: astore 12
    //   131: new 235	java/util/ArrayList
    //   134: dup
    //   135: invokespecial 311	java/util/ArrayList:<init>	()V
    //   138: astore 10
    //   140: new 235	java/util/ArrayList
    //   143: dup
    //   144: invokespecial 311	java/util/ArrayList:<init>	()V
    //   147: astore 13
    //   149: new 235	java/util/ArrayList
    //   152: dup
    //   153: invokespecial 311	java/util/ArrayList:<init>	()V
    //   156: astore 11
    //   158: new 27	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   165: getstatic 52	com/tencent/mobileqq/msgforward/AIOShareActionSheet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   168: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: getstatic 56	com/tencent/mobileqq/msgforward/AIOShareActionSheet:i	Ljava/lang/String;
    //   174: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 461	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Ljava/io/File;
    //   183: pop
    //   184: new 463	java/io/BufferedWriter
    //   187: dup
    //   188: new 465	java/io/FileWriter
    //   191: dup
    //   192: new 27	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   199: getstatic 52	com/tencent/mobileqq/msgforward/AIOShareActionSheet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   202: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: getstatic 56	com/tencent/mobileqq/msgforward/AIOShareActionSheet:i	Ljava/lang/String;
    //   208: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokespecial 466	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   217: invokespecial 469	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   220: astore 8
    //   222: new 27	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   229: astore 14
    //   231: aload 14
    //   233: ldc_w 471
    //   236: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 14
    //   242: ldc_w 473
    //   245: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload 5
    //   250: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: ldc_w 475
    //   256: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 8
    //   262: new 27	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   269: aload 5
    //   271: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc_w 477
    //   277: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokevirtual 480	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   286: new 482	java/text/SimpleDateFormat
    //   289: dup
    //   290: ldc 149
    //   292: getstatic 488	java/util/Locale:SIMPLIFIED_CHINESE	Ljava/util/Locale;
    //   295: invokespecial 491	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   298: astore 15
    //   300: aload 15
    //   302: ldc_w 493
    //   305: invokevirtual 496	java/text/SimpleDateFormat:applyPattern	(Ljava/lang/String;)V
    //   308: aload 15
    //   310: aload 6
    //   312: getfield 500	com/tencent/mobileqq/data/ChatMessage:time	J
    //   315: ldc2_w 501
    //   318: lmul
    //   319: invokestatic 508	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   322: invokevirtual 511	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   325: astore 6
    //   327: aload 14
    //   329: ldc_w 513
    //   332: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload 6
    //   337: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: ldc_w 515
    //   343: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 8
    //   349: new 27	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   356: ldc_w 517
    //   359: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload 6
    //   364: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: ldc_w 519
    //   370: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokevirtual 480	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   379: iconst_0
    //   380: istore 4
    //   382: iload 4
    //   384: aload_2
    //   385: invokevirtual 520	java/util/ArrayList:size	()I
    //   388: if_icmpge +837 -> 1225
    //   391: aload_2
    //   392: iload 4
    //   394: invokevirtual 422	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   397: checkcast 424	com/tencent/mobileqq/data/ChatMessage
    //   400: astore 16
    //   402: aconst_null
    //   403: astore 5
    //   405: aload 16
    //   407: instanceof 522
    //   410: ifeq +464 -> 874
    //   413: aload 16
    //   415: checkcast 522	com/tencent/mobileqq/data/MessageForText
    //   418: astore 5
    //   420: aload 5
    //   422: getfield 526	com/tencent/mobileqq/data/MessageForText:sb	Ljava/lang/CharSequence;
    //   425: ifnull +439 -> 864
    //   428: aload 5
    //   430: getfield 526	com/tencent/mobileqq/data/MessageForText:sb	Ljava/lang/CharSequence;
    //   433: invokeinterface 529 1 0
    //   438: astore 7
    //   440: aload 7
    //   442: astore 5
    //   444: aload 7
    //   446: invokestatic 534	com/tencent/mobileqq/text/TextUtils:a	(Ljava/lang/String;)Z
    //   449: ifeq +10 -> 459
    //   452: aload 7
    //   454: invokestatic 536	com/tencent/mobileqq/text/TextUtils:c	(Ljava/lang/String;)Ljava/lang/String;
    //   457: astore 5
    //   459: aload 5
    //   461: astore 7
    //   463: aload 5
    //   465: invokestatic 540	com/tencent/mobileqq/lovelanguage/LoveLanguageManager:b	(Ljava/lang/String;)Z
    //   468: ifeq +1166 -> 1634
    //   471: aload 5
    //   473: invokestatic 542	com/tencent/mobileqq/lovelanguage/LoveLanguageManager:b	(Ljava/lang/String;)Ljava/lang/String;
    //   476: astore 7
    //   478: goto +1156 -> 1634
    //   481: aload 6
    //   483: astore 7
    //   485: aload 5
    //   487: ifnull +259 -> 746
    //   490: aload 15
    //   492: ldc_w 493
    //   495: invokevirtual 496	java/text/SimpleDateFormat:applyPattern	(Ljava/lang/String;)V
    //   498: aload 15
    //   500: aload 16
    //   502: getfield 500	com/tencent/mobileqq/data/ChatMessage:time	J
    //   505: ldc2_w 501
    //   508: lmul
    //   509: invokestatic 508	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   512: invokevirtual 511	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   515: astore 9
    //   517: aload 6
    //   519: astore 7
    //   521: aload 9
    //   523: aload 6
    //   525: invokevirtual 339	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   528: ifne +59 -> 587
    //   531: aload 14
    //   533: ldc_w 513
    //   536: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: aload 9
    //   541: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: ldc_w 515
    //   547: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload 8
    //   553: new 27	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   560: ldc_w 517
    //   563: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: aload 9
    //   568: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: ldc_w 519
    //   574: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   580: invokevirtual 480	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   583: aload 9
    //   585: astore 7
    //   587: aload 15
    //   589: ldc_w 544
    //   592: invokevirtual 496	java/text/SimpleDateFormat:applyPattern	(Ljava/lang/String;)V
    //   595: aload 15
    //   597: aload 16
    //   599: getfield 500	com/tencent/mobileqq/data/ChatMessage:time	J
    //   602: ldc2_w 501
    //   605: lmul
    //   606: invokestatic 508	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   609: invokevirtual 511	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   612: astore 6
    //   614: aload 14
    //   616: ldc_w 546
    //   619: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: aload_1
    //   623: aload 16
    //   625: getfield 549	com/tencent/mobileqq/data/ChatMessage:senderuin	Ljava/lang/String;
    //   628: invokeinterface 554 2 0
    //   633: checkcast 153	java/lang/String
    //   636: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: ldc_w 556
    //   642: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: aload 6
    //   647: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: ldc_w 558
    //   653: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: aload 14
    //   659: aload 5
    //   661: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: ldc_w 560
    //   667: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: aload 8
    //   673: new 27	java/lang/StringBuilder
    //   676: dup
    //   677: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   680: aload_1
    //   681: aload 16
    //   683: getfield 549	com/tencent/mobileqq/data/ChatMessage:senderuin	Ljava/lang/String;
    //   686: invokeinterface 554 2 0
    //   691: checkcast 153	java/lang/String
    //   694: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: ldc_w 562
    //   700: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: aload 6
    //   705: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: ldc_w 564
    //   711: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   717: invokevirtual 480	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   720: aload 8
    //   722: new 27	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   729: aload 5
    //   731: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: ldc_w 566
    //   737: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   743: invokevirtual 480	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   746: aload 7
    //   748: astore 5
    //   750: iload 4
    //   752: iconst_1
    //   753: iadd
    //   754: istore 4
    //   756: aload 5
    //   758: astore 6
    //   760: goto -378 -> 382
    //   763: aload 6
    //   765: getfield 427	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   768: iconst_1
    //   769: if_icmpne +40 -> 809
    //   772: aload_0
    //   773: getfield 91	com/tencent/mobileqq/msgforward/AIOShareActionSheet:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   776: ldc_w 567
    //   779: invokevirtual 257	android/content/Context:getString	(I)Ljava/lang/String;
    //   782: iconst_1
    //   783: anewarray 4	java/lang/Object
    //   786: dup
    //   787: iconst_0
    //   788: aload_0
    //   789: getfield 89	com/tencent/mobileqq/msgforward/AIOShareActionSheet:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   792: aload 6
    //   794: getfield 439	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   797: invokestatic 569	com/tencent/mobileqq/utils/ContactUtils:i	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   800: aastore
    //   801: invokestatic 443	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   804: astore 5
    //   806: goto -735 -> 71
    //   809: aload 6
    //   811: getfield 427	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   814: sipush 3000
    //   817: if_icmpne -746 -> 71
    //   820: aload_0
    //   821: getfield 91	com/tencent/mobileqq/msgforward/AIOShareActionSheet:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   824: ldc_w 567
    //   827: invokevirtual 257	android/content/Context:getString	(I)Ljava/lang/String;
    //   830: iconst_1
    //   831: anewarray 4	java/lang/Object
    //   834: dup
    //   835: iconst_0
    //   836: aload_0
    //   837: getfield 89	com/tencent/mobileqq/msgforward/AIOShareActionSheet:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   840: aload_0
    //   841: getfield 89	com/tencent/mobileqq/msgforward/AIOShareActionSheet:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   844: invokevirtual 575	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   847: aload 6
    //   849: getfield 439	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   852: invokestatic 578	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   855: aastore
    //   856: invokestatic 443	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   859: astore 5
    //   861: goto -790 -> 71
    //   864: aload 5
    //   866: getfield 581	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   869: astore 7
    //   871: goto -431 -> 440
    //   874: aload 16
    //   876: instanceof 127
    //   879: ifeq +20 -> 899
    //   882: aload 16
    //   884: checkcast 127	com/tencent/mobileqq/data/MessageForPic
    //   887: aload 12
    //   889: aload 13
    //   891: invokestatic 583	com/tencent/mobileqq/msgforward/AIOShareActionSheet:a	(Lcom/tencent/mobileqq/data/MessageForPic;Ljava/util/List;Ljava/util/List;)Ljava/lang/String;
    //   894: astore 5
    //   896: goto -415 -> 481
    //   899: aload 16
    //   901: instanceof 585
    //   904: ifeq +128 -> 1032
    //   907: aload 16
    //   909: checkcast 585	com/tencent/mobileqq/data/MessageForShortVideo
    //   912: invokestatic 590	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Lcom/tencent/mobileqq/data/MessageForShortVideo;)Ljava/lang/String;
    //   915: astore 5
    //   917: aload 5
    //   919: ifnonnull +34 -> 953
    //   922: ldc 123
    //   924: iconst_1
    //   925: iconst_2
    //   926: anewarray 4	java/lang/Object
    //   929: dup
    //   930: iconst_0
    //   931: ldc_w 592
    //   934: aastore
    //   935: dup
    //   936: iconst_1
    //   937: aload 16
    //   939: invokevirtual 593	com/tencent/mobileqq/data/ChatMessage:getUserLogString	()Ljava/lang/String;
    //   942: aastore
    //   943: invokestatic 135	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   946: aload 6
    //   948: astore 5
    //   950: goto -200 -> 750
    //   953: aload 10
    //   955: aload 5
    //   957: invokeinterface 141 2 0
    //   962: pop
    //   963: new 27	java/lang/StringBuilder
    //   966: dup
    //   967: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   970: ldc_w 595
    //   973: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: aload 10
    //   978: invokeinterface 167 1 0
    //   983: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   986: ldc_w 597
    //   989: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   995: astore 7
    //   997: new 27	java/lang/StringBuilder
    //   1000: dup
    //   1001: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1004: aload 7
    //   1006: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: ldc 172
    //   1011: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1014: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1017: astore 5
    //   1019: aload 11
    //   1021: aload 7
    //   1023: invokeinterface 141 2 0
    //   1028: pop
    //   1029: goto -548 -> 481
    //   1032: aload 16
    //   1034: instanceof 599
    //   1037: ifne +11 -> 1048
    //   1040: aload 16
    //   1042: instanceof 601
    //   1045: ifeq +22 -> 1067
    //   1048: aload 16
    //   1050: aload 12
    //   1052: aload 13
    //   1054: invokestatic 605	com/tencent/mobileqq/data/MessageForMixedMsg:getTextFromMixedMsgForMail	(Lcom/tencent/mobileqq/data/ChatMessage;Ljava/util/List;Ljava/util/List;)Ljava/lang/CharSequence;
    //   1057: invokeinterface 529 1 0
    //   1062: astore 5
    //   1064: goto -583 -> 481
    //   1067: aload 16
    //   1069: instanceof 196
    //   1072: ifeq -591 -> 481
    //   1075: aload 16
    //   1077: checkcast 196	com/tencent/mobileqq/data/MessageForStructing
    //   1080: astore 7
    //   1082: aload 7
    //   1084: getfield 203	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1087: ifnull +541 -> 1628
    //   1090: aload 7
    //   1092: getfield 203	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1095: instanceof 607
    //   1098: ifeq +23 -> 1121
    //   1101: aload 7
    //   1103: getfield 203	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1106: checkcast 607	com/tencent/mobileqq/structmsg/StructMsgForHypertext
    //   1109: iconst_0
    //   1110: invokevirtual 611	com/tencent/mobileqq/structmsg/StructMsgForHypertext:getSpannableString	(Z)Landroid/text/SpannableStringBuilder;
    //   1113: invokevirtual 614	android/text/SpannableStringBuilder:toString	()Ljava/lang/String;
    //   1116: astore 5
    //   1118: goto +523 -> 1641
    //   1121: ldc_w 616
    //   1124: aload 7
    //   1126: getfield 203	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1129: getfield 621	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgAction	Ljava/lang/String;
    //   1132: invokevirtual 339	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1135: ifeq +11 -> 1146
    //   1138: ldc_w 623
    //   1141: astore 5
    //   1143: goto +498 -> 1641
    //   1146: aload 7
    //   1148: getfield 203	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1151: getfield 626	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1154: bipush 32
    //   1156: if_icmpne +14 -> 1170
    //   1159: aload_0
    //   1160: aload 7
    //   1162: invokevirtual 628	com/tencent/mobileqq/msgforward/AIOShareActionSheet:a	(Lcom/tencent/mobileqq/data/MessageForStructing;)Ljava/lang/String;
    //   1165: astore 5
    //   1167: goto +474 -> 1641
    //   1170: aload 7
    //   1172: invokevirtual 199	com/tencent/mobileqq/data/MessageForStructing:getSummaryMsg	()Ljava/lang/String;
    //   1175: astore 5
    //   1177: aload 7
    //   1179: getfield 203	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1182: getfield 631	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgUrl	Ljava/lang/String;
    //   1185: ifnull +440 -> 1625
    //   1188: new 27	java/lang/StringBuilder
    //   1191: dup
    //   1192: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1195: aload 5
    //   1197: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1200: ldc_w 564
    //   1203: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: aload 7
    //   1208: getfield 203	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1211: getfield 631	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgUrl	Ljava/lang/String;
    //   1214: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1220: astore 5
    //   1222: goto +419 -> 1641
    //   1225: aload 14
    //   1227: ldc_w 633
    //   1230: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1233: pop
    //   1234: aload_3
    //   1235: ldc_w 403
    //   1238: aload 14
    //   1240: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1243: invokestatic 639	android/text/Html:fromHtml	(Ljava/lang/String;)Landroid/text/Spanned;
    //   1246: invokevirtual 642	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/CharSequence;)Landroid/content/Intent;
    //   1249: pop
    //   1250: aload 8
    //   1252: invokevirtual 645	java/io/BufferedWriter:flush	()V
    //   1255: aload 8
    //   1257: ifnull +8 -> 1265
    //   1260: aload 8
    //   1262: invokevirtual 648	java/io/BufferedWriter:close	()V
    //   1265: new 235	java/util/ArrayList
    //   1268: dup
    //   1269: invokespecial 311	java/util/ArrayList:<init>	()V
    //   1272: astore_1
    //   1273: aload_1
    //   1274: aload_0
    //   1275: getstatic 56	com/tencent/mobileqq/msgforward/AIOShareActionSheet:i	Ljava/lang/String;
    //   1278: invokevirtual 650	com/tencent/mobileqq/msgforward/AIOShareActionSheet:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   1281: invokevirtual 408	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1284: pop
    //   1285: aload 12
    //   1287: invokeinterface 310 1 0
    //   1292: ifne +169 -> 1461
    //   1295: aload 12
    //   1297: invokeinterface 216 1 0
    //   1302: astore_2
    //   1303: aload_2
    //   1304: invokeinterface 222 1 0
    //   1309: ifeq +152 -> 1461
    //   1312: aload_2
    //   1313: invokeinterface 226 1 0
    //   1318: checkcast 153	java/lang/String
    //   1321: astore 5
    //   1323: aload 5
    //   1325: new 27	java/lang/StringBuilder
    //   1328: dup
    //   1329: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1332: getstatic 52	com/tencent/mobileqq/msgforward/AIOShareActionSheet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1335: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: aload 13
    //   1340: aload 12
    //   1342: aload 5
    //   1344: invokeinterface 653 2 0
    //   1349: invokeinterface 654 2 0
    //   1354: checkcast 153	java/lang/String
    //   1357: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1360: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1363: invokestatic 657	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1366: ifeq -63 -> 1303
    //   1369: aload_1
    //   1370: aload_0
    //   1371: aload 13
    //   1373: aload 12
    //   1375: aload 5
    //   1377: invokeinterface 653 2 0
    //   1382: invokeinterface 654 2 0
    //   1387: checkcast 153	java/lang/String
    //   1390: invokevirtual 650	com/tencent/mobileqq/msgforward/AIOShareActionSheet:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   1393: invokevirtual 408	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1396: pop
    //   1397: goto -94 -> 1303
    //   1400: astore_1
    //   1401: aload_1
    //   1402: invokevirtual 660	java/io/IOException:printStackTrace	()V
    //   1405: goto -140 -> 1265
    //   1408: astore_2
    //   1409: aconst_null
    //   1410: astore_1
    //   1411: ldc 123
    //   1413: iconst_1
    //   1414: ldc_w 662
    //   1417: aload_2
    //   1418: invokestatic 367	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1421: aload_1
    //   1422: ifnull -157 -> 1265
    //   1425: aload_1
    //   1426: invokevirtual 648	java/io/BufferedWriter:close	()V
    //   1429: goto -164 -> 1265
    //   1432: astore_1
    //   1433: aload_1
    //   1434: invokevirtual 660	java/io/IOException:printStackTrace	()V
    //   1437: goto -172 -> 1265
    //   1440: astore_1
    //   1441: aconst_null
    //   1442: astore_2
    //   1443: aload_2
    //   1444: ifnull +7 -> 1451
    //   1447: aload_2
    //   1448: invokevirtual 648	java/io/BufferedWriter:close	()V
    //   1451: aload_1
    //   1452: athrow
    //   1453: astore_2
    //   1454: aload_2
    //   1455: invokevirtual 660	java/io/IOException:printStackTrace	()V
    //   1458: goto -7 -> 1451
    //   1461: aload 10
    //   1463: invokeinterface 310 1 0
    //   1468: ifne +108 -> 1576
    //   1471: aload 10
    //   1473: invokeinterface 216 1 0
    //   1478: astore_2
    //   1479: aload_2
    //   1480: invokeinterface 222 1 0
    //   1485: ifeq +91 -> 1576
    //   1488: aload_2
    //   1489: invokeinterface 226 1 0
    //   1494: checkcast 153	java/lang/String
    //   1497: astore 5
    //   1499: aload 5
    //   1501: new 27	java/lang/StringBuilder
    //   1504: dup
    //   1505: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1508: getstatic 52	com/tencent/mobileqq/msgforward/AIOShareActionSheet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1511: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1514: aload 11
    //   1516: aload 10
    //   1518: aload 5
    //   1520: invokeinterface 653 2 0
    //   1525: invokeinterface 654 2 0
    //   1530: checkcast 153	java/lang/String
    //   1533: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1536: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1539: invokestatic 657	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1542: ifeq -63 -> 1479
    //   1545: aload_1
    //   1546: aload_0
    //   1547: aload 11
    //   1549: aload 10
    //   1551: aload 5
    //   1553: invokeinterface 653 2 0
    //   1558: invokeinterface 654 2 0
    //   1563: checkcast 153	java/lang/String
    //   1566: invokevirtual 650	com/tencent/mobileqq/msgforward/AIOShareActionSheet:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   1569: invokevirtual 408	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1572: pop
    //   1573: goto -94 -> 1479
    //   1576: aload_3
    //   1577: ldc_w 664
    //   1580: aload_1
    //   1581: invokevirtual 667	android/content/Intent:putParcelableArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   1584: pop
    //   1585: getstatic 179	android/os/Build$VERSION:SDK_INT	I
    //   1588: bipush 24
    //   1590: if_icmplt +9 -> 1599
    //   1593: aload_3
    //   1594: iconst_1
    //   1595: invokevirtual 671	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1598: pop
    //   1599: return
    //   1600: astore_1
    //   1601: aload 8
    //   1603: astore_2
    //   1604: goto -161 -> 1443
    //   1607: astore_3
    //   1608: aload_1
    //   1609: astore_2
    //   1610: aload_3
    //   1611: astore_1
    //   1612: goto -169 -> 1443
    //   1615: astore_2
    //   1616: aload 8
    //   1618: astore_1
    //   1619: goto -208 -> 1411
    //   1622: goto -1141 -> 481
    //   1625: goto +16 -> 1641
    //   1628: aconst_null
    //   1629: astore 5
    //   1631: goto +10 -> 1641
    //   1634: aload 7
    //   1636: astore 5
    //   1638: goto -1157 -> 481
    //   1641: aload 5
    //   1643: ifnonnull -21 -> 1622
    //   1646: ldc_w 673
    //   1649: astore 5
    //   1651: goto -1170 -> 481
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1654	0	this	AIOShareActionSheet
    //   0	1654	1	paramMap	Map
    //   0	1654	2	paramArrayList	ArrayList
    //   0	1654	3	paramIntent	Intent
    //   380	375	4	j	int
    //   12	1638	5	localObject1	Object
    //   8	939	6	localObject2	Object
    //   98	1537	7	localObject3	Object
    //   220	1397	8	localBufferedWriter	java.io.BufferedWriter
    //   515	69	9	str	String
    //   138	1412	10	localArrayList1	ArrayList
    //   156	1392	11	localArrayList2	ArrayList
    //   129	1245	12	localArrayList3	ArrayList
    //   147	1225	13	localArrayList4	ArrayList
    //   229	1010	14	localStringBuilder	StringBuilder
    //   298	298	15	localSimpleDateFormat	SimpleDateFormat
    //   400	676	16	localChatMessage	ChatMessage
    // Exception table:
    //   from	to	target	type
    //   1260	1265	1400	java/io/IOException
    //   158	222	1408	java/lang/Throwable
    //   1425	1429	1432	java/io/IOException
    //   158	222	1440	finally
    //   1447	1451	1453	java/io/IOException
    //   222	379	1600	finally
    //   382	402	1600	finally
    //   405	440	1600	finally
    //   444	459	1600	finally
    //   463	478	1600	finally
    //   490	517	1600	finally
    //   521	583	1600	finally
    //   587	746	1600	finally
    //   864	871	1600	finally
    //   874	896	1600	finally
    //   899	917	1600	finally
    //   922	946	1600	finally
    //   953	1029	1600	finally
    //   1032	1048	1600	finally
    //   1048	1064	1600	finally
    //   1067	1118	1600	finally
    //   1121	1138	1600	finally
    //   1146	1167	1600	finally
    //   1170	1222	1600	finally
    //   1225	1255	1600	finally
    //   1411	1421	1607	finally
    //   222	379	1615	java/lang/Throwable
    //   382	402	1615	java/lang/Throwable
    //   405	440	1615	java/lang/Throwable
    //   444	459	1615	java/lang/Throwable
    //   463	478	1615	java/lang/Throwable
    //   490	517	1615	java/lang/Throwable
    //   521	583	1615	java/lang/Throwable
    //   587	746	1615	java/lang/Throwable
    //   864	871	1615	java/lang/Throwable
    //   874	896	1615	java/lang/Throwable
    //   899	917	1615	java/lang/Throwable
    //   922	946	1615	java/lang/Throwable
    //   953	1029	1615	java/lang/Throwable
    //   1032	1048	1615	java/lang/Throwable
    //   1048	1064	1615	java/lang/Throwable
    //   1067	1118	1615	java/lang/Throwable
    //   1121	1138	1615	java/lang/Throwable
    //   1146	1167	1615	java/lang/Throwable
    //   1170	1222	1615	java/lang/Throwable
    //   1225	1255	1615	java/lang/Throwable
  }
  
  public boolean a()
  {
    Iterator localIterator = MultiMsgManager.a().a.entrySet().iterator();
    boolean bool2 = false;
    if (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      bool1 = bool2;
      if (((Boolean)((Map.Entry)localObject).getValue()).booleanValue())
      {
        localObject = (ChatMessage)((Map.Entry)localObject).getKey();
        bool2 |= FlashPicHelper.a((MessageRecord)localObject);
        if (MultiMsgProxy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject)) {}
      }
    }
    while (bool2)
    {
      Object localObject;
      do
      {
        do
        {
          return false;
          bool1 = bool2;
          if (!(localObject instanceof MessageForTroopFile)) {
            break;
          }
          localObject = (MessageForTroopFile)localObject;
          localObject = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForTroopFile)localObject);
        } while (localObject == null);
        bool1 = bool2;
        if (((TroopFileStatusInfo)localObject).jdField_b_of_type_Int == 8) {
          break;
        }
        bool1 = bool2;
        if (((TroopFileStatusInfo)localObject).jdField_b_of_type_Int == 9) {
          break;
        }
        bool1 = bool2;
        if (((TroopFileStatusInfo)localObject).jdField_b_of_type_Int == 6) {
          break;
        }
        bool1 = bool2;
        if (((TroopFileStatusInfo)localObject).jdField_b_of_type_Int == 7) {
          break;
        }
        if (((TroopFileStatusInfo)localObject).jdField_b_of_type_Int == 11)
        {
          bool1 = bool2;
          if (FileUtil.a(((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaLangString)) {
            break;
          }
        }
      } while (((TroopFileStatusInfo)localObject).jdField_b_of_type_Int != 10);
      boolean bool1 = bool2;
      bool2 = bool1;
      break;
    }
    return true;
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    if (((paramChatMessage instanceof MessageForPic)) && (FlashPicHelper.a(paramChatMessage))) {}
    while (((paramChatMessage instanceof MessageForTroopFile)) || ((paramChatMessage instanceof MessageForQQStoryComment)) || ((paramChatMessage instanceof MessageForArkApp))) {
      return false;
    }
    if ((paramChatMessage instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramChatMessage;
      if ((localMessageForStructing.structingMsg != null) && ("viewMultiMsg".equals(localMessageForStructing.structingMsg.mMsgAction))) {
        return true;
      }
    }
    return MultiMsgProxy.a(paramChatMessage);
  }
  
  public List[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    int j;
    if (AIOUtils.a(2) == 0)
    {
      j = 1;
      if (AIOUtils.a(3) != 0) {
        break label340;
      }
    }
    label340:
    for (int k = 1;; k = 0)
    {
      Object localObject = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = paramContext.getString(2131430126);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).jdField_b_of_type_Int = 2130838340;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).c = 9;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject);
      localObject = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = paramContext.getString(2131430134);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).jdField_b_of_type_Int = 2130838507;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).c = 25;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject);
      localObject = new ArrayList();
      if (j != 0)
      {
        localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
        localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430135);
        localActionSheetItem.jdField_b_of_type_Int = 2130838541;
        localActionSheetItem.jdField_a_of_type_Boolean = true;
        localActionSheetItem.c = 26;
        localActionSheetItem.jdField_b_of_type_JavaLangString = "";
        ((ArrayList)localObject).add(localActionSheetItem);
      }
      if (k != 0)
      {
        localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
        localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430136);
        localActionSheetItem.jdField_b_of_type_Int = 2130838656;
        localActionSheetItem.jdField_a_of_type_Boolean = true;
        localActionSheetItem.c = 27;
        localActionSheetItem.jdField_b_of_type_JavaLangString = "";
        ((ArrayList)localObject).add(localActionSheetItem);
      }
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430137);
      localActionSheetItem.jdField_b_of_type_Int = 2130838332;
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.c = 28;
      localActionSheetItem.jdField_b_of_type_JavaLangString = "";
      ((ArrayList)localObject).add(localActionSheetItem);
      return (List[])new ArrayList[] { localArrayList, localObject };
      j = 0;
      break;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null) {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
    }
  }
  
  public void b(Map paramMap, ArrayList paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    ChatMessage localChatMessage;
    Object localObject1;
    label64:
    Object localObject2;
    if (j < paramArrayList.size())
    {
      localChatMessage = (ChatMessage)paramArrayList.get(j);
      if ((localChatMessage instanceof MessageForText))
      {
        localObject1 = (MessageForText)localChatMessage;
        if (((MessageForText)localObject1).sb != null)
        {
          localObject1 = ((MessageForText)localObject1).sb.toString();
          localObject2 = localObject1;
          if (TextUtils.a((String)localObject1)) {
            localObject2 = TextUtils.c((String)localObject1);
          }
          localObject1 = localObject2;
          if (LoveLanguageManager.b((String)localObject2)) {
            localObject1 = LoveLanguageManager.b((String)localObject2);
          }
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject2 = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
          ((SimpleDateFormat)localObject2).applyPattern("HH:mm:ss");
          localObject2 = ((SimpleDateFormat)localObject2).format(Long.valueOf(localChatMessage.time * 1000L));
          localStringBuilder.append((String)paramMap.get(localChatMessage.senderuin)).append(" ").append((String)localObject2).append("\n").append((String)localObject1).append("\n");
          if (j != paramArrayList.size() - 1) {
            localStringBuilder.append("\n");
          }
        }
        j += 1;
        break;
        localObject1 = ((MessageForText)localObject1).msg;
        break label64;
        if ((localChatMessage instanceof MessageForPic))
        {
          localObject1 = "[图片]";
        }
        else if ((localChatMessage instanceof MessageForShortVideo))
        {
          localObject1 = "[视频]";
        }
        else
        {
          if ((!(localChatMessage instanceof MessageForMixedMsg)) && (!(localChatMessage instanceof MessageForLongMsg))) {
            break label295;
          }
          localObject1 = MessageForMixedMsg.getTextFromMixedMsg(localChatMessage).toString();
        }
      }
      label295:
      if ((localChatMessage instanceof MessageForStructing))
      {
        localObject1 = (MessageForStructing)localChatMessage;
        if (((MessageForStructing)localObject1).structingMsg == null) {
          break label530;
        }
        if ((((MessageForStructing)localObject1).structingMsg instanceof StructMsgForHypertext)) {
          localObject2 = ((StructMsgForHypertext)((MessageForStructing)localObject1).structingMsg).getSpannableString(false).toString();
        }
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "[结构化消息]";
      break;
      if (((MessageForStructing)localObject1).structingMsg.mMsgServiceID == 32)
      {
        localObject2 = a((MessageForStructing)localObject1);
      }
      else
      {
        localObject2 = ((MessageForStructing)localObject1).getSummaryMsg();
        if (((MessageForStructing)localObject1).structingMsg.mMsgUrl != null)
        {
          localObject2 = (String)localObject2 + "\n" + ((MessageForStructing)localObject1).structingMsg.mMsgUrl;
          continue;
          if (((localChatMessage instanceof MessageForArkFlashChat)) && (localChatMessage.msg != null))
          {
            localObject1 = localChatMessage.msg;
            break;
            ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", localStringBuilder.toString()));
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131433777, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
            return;
          }
          localObject1 = null;
          break;
        }
        continue;
        label530:
        localObject2 = null;
      }
    }
  }
  
  public boolean b()
  {
    Iterator localIterator = MultiMsgManager.a().a.entrySet().iterator();
    boolean bool2 = false;
    if (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      bool1 = bool2;
      if (((Boolean)((Map.Entry)localObject).getValue()).booleanValue())
      {
        localObject = (ChatMessage)((Map.Entry)localObject).getKey();
        bool2 |= FlashPicHelper.a((MessageRecord)localObject);
        if (MultiMsgProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject)) {}
      }
    }
    while (bool2)
    {
      Object localObject;
      do
      {
        return false;
        bool1 = bool2;
        if (!(localObject instanceof MessageForTroopFile)) {
          break;
        }
        localObject = (MessageForTroopFile)localObject;
      } while (TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForTroopFile)localObject) == null);
      boolean bool1 = bool2;
      bool2 = bool1;
      break;
    }
    return true;
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    if (((paramChatMessage instanceof MessageForPic)) && (FlashPicHelper.a(paramChatMessage))) {}
    while (((paramChatMessage instanceof MessageForTroopFile)) || ((paramChatMessage instanceof MessageForQQStoryComment)) || ((paramChatMessage instanceof MessageForArkApp))) {
      return false;
    }
    return MultiMsgProxy.a(paramChatMessage);
  }
  
  public boolean c()
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131433009, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      return false;
    }
    Object localObject1 = MultiMsgManager.a().a();
    if (((List)localObject1).size() == 0)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131433423, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      return false;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = 0;
    Object localObject2;
    if (j < ((List)localObject1).size())
    {
      localObject2 = (ChatMessage)((List)localObject1).get(j);
      if ((localObject2 instanceof MessageForTroopFile)) {
        localArrayList1.add((MessageForTroopFile)localObject2);
      }
      for (;;)
      {
        j += 1;
        break;
        if ((localObject2 instanceof MessageForFile)) {
          localArrayList2.add((MessageForFile)localObject2);
        }
      }
    }
    if (localArrayList1.size() > 0)
    {
      localObject1 = localArrayList1.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageForTroopFile)((Iterator)localObject1).next();
        TroopFileUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject2);
      }
    }
    MessageForFile localMessageForFile;
    FileManagerEntity localFileManagerEntity;
    if (localArrayList2.size() > 0)
    {
      localObject1 = new ArrayList();
      localObject2 = localArrayList2.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localMessageForFile = (MessageForFile)((Iterator)localObject2).next();
        localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
        if ((localFileManagerEntity.cloudType != 0) && (localFileManagerEntity.cloudType != 2)) {
          ((ArrayList)localObject1).add(localMessageForFile);
        }
      }
      if (((ArrayList)localObject1).size() == 0)
      {
        FMToastUtil.a(2131428331);
        return false;
      }
      if (((ArrayList)localObject1).size() != 1) {
        break label416;
      }
      localObject1 = (MessageForFile)((ArrayList)localObject1).get(0);
      localObject2 = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject1);
      if (localObject2 == null)
      {
        FMToastUtil.a(2131428331);
        return false;
      }
      if (((FileManagerEntity)localObject2).status == 16)
      {
        FMToastUtil.a(2131428188);
        return false;
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject1, BaseActivity.sTopActivity);
    }
    while ((localArrayList1.size() == 0) && (localArrayList2.size() == 0))
    {
      FMToastUtil.a(2131428333);
      return false;
      label416:
      localObject2 = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localMessageForFile = (MessageForFile)((Iterator)localObject1).next();
        localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
        if ((localFileManagerEntity != null) && (localFileManagerEntity.status != 16)) {
          ((List)localObject2).add(localMessageForFile);
        }
      }
      if (((List)localObject2).size() == 0)
      {
        FMToastUtil.a(2131428331);
        return false;
      }
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageForFile)((Iterator)localObject1).next();
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject2, BaseActivity.sTopActivity);
      }
    }
    return true;
  }
  
  public boolean d()
  {
    Iterator localIterator = MultiMsgManager.a().a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Boolean)localEntry.getValue()).booleanValue()) && (!a((ChatMessage)localEntry.getKey()))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean e()
  {
    List localList = MultiMsgManager.a().a();
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
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131433766, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(localList, 3);
    return true;
  }
  
  public boolean f()
  {
    Iterator localIterator = MultiMsgManager.a().a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Boolean)localEntry.getValue()).booleanValue()) && (!b((ChatMessage)localEntry.getKey()))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean g()
  {
    List localList = MultiMsgManager.a().a();
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
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131433776, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(localList, 4);
    return true;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.b();
            switch (((ShareActionSheetBuilder.ActionSheetItemViewHolder)paramAdapterView).a.c)
            {
            default: 
              return;
            case 9: 
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", e, e, 0, 0, "", "", "", "");
              paramInt = -1;
              if (!WXShareHelper.a().a()) {
                paramInt = 2131438947;
              }
              while (paramInt != -1)
              {
                QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_AndroidContentContext.getString(paramInt), 0).a();
                return;
                if (!WXShareHelper.a().b()) {
                  paramInt = 2131435320;
                }
              }
              if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null) {
                this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new aeiw(this);
              }
              WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c(true);
              return;
            case 25: 
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", f, f, 0, 0, "", "", "", "");
              if (!d())
              {
                DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131433764)).setPositiveButton(17039370, new aeiy(this)).setNegativeButton(17039360, new aeix(this)).show();
                return;
              }
              break;
            }
          } while ((MultiMsgManager.a().a().isEmpty()) || (!e()));
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(false, null, false);
          return;
          if (!b())
          {
            DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131433773)).setPositiveButton(17039370, new aeja(this)).setNegativeButton(17039360, new aeiz(this)).show();
            return;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067F7", "0X80067F7", 0, 0, "", "", "", "");
        } while (!c());
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(false, null, false);
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", g, g, 0, 0, "", "", "", "");
        if (!a())
        {
          DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131433774)).setPositiveButton(17039370, new aejc(this)).setNegativeButton(17039360, new aejb(this)).show();
          return;
        }
      } while (!WeiyunAIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_MqqOsMqqHandler));
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(false, null, false);
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", h, h, 0, 0, "", "", "", "");
      if (!f())
      {
        DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131433775)).setPositiveButton(17039370, new aeje(this)).setNegativeButton(17039360, new aejd(this)).show();
        return;
      }
    } while ((MultiMsgManager.a().a().isEmpty()) || (!g()));
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(false, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.msgforward.AIOShareActionSheet
 * JD-Core Version:    0.7.0.1
 */