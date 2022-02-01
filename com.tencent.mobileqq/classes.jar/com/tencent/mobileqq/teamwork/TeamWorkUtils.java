package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.NotOnlineFile;

public class TeamWorkUtils
{
  private static volatile int a = 0;
  public static long a = 101458937L;
  public static final SparseArray<Pair<Integer, String>> a;
  public static String a = ".doc|.docx|.xls|.xlsx|";
  public static final HashMap<String, String> a;
  public static final Map<Integer, String> a;
  private static long b = 0L;
  public static final SparseArray<Pair<Integer, String>> b;
  public static String b = "https://docs.qq.com/desktop/m/index.html?_wv=2";
  public static final Map<String, Integer> b;
  public static String c = "docs.qq.com/desktop/m";
  public static String d = "https://docs.qq.com/desktop/favicon.ico";
  public static final String e;
  public static final String f;
  public static final String g;
  public static final String h;
  private static String i = "TeamWorkUtils";
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(9), "s_qq_mini_importing");
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(12), "s_qq_url_2_doc");
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_aiomsg", "docs_miniapp_config_aio_msg");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_myfile", "docs_miniapp_config_my_file");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_myfile_yindao", "docs_miniapp_config_my_file");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_myfile_banner", "docs_miniapp_config_my_file");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_myfile_menu_create", "docs_miniapp_config_templatelist");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_grpfile", "docs_miniapp_config_troop_file");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_aio_grey", "docs_miniapp_config_gray_bar");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_aio_edit", "docs_miniapp_config_aio_edit");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_file_edit", "docs_miniapp_config_bottom_edit");
    jdField_a_of_type_JavaUtilHashMap.put("s_QQ_file_share_edit", "docs_miniapp_config_menu_edit");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_file_preview", "docs_miniapp_config_online_preview");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_ocr_save", "docs_miniapp_config_ocr_save");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_url_2_doc", "docs_miniapp_config_url_2_doc");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_mini_importing", "s_qq_mini_importing");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_aio_ark_h5", "docs_miniapp_config_aio_ark_h5");
    jdField_b_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_b_of_type_JavaUtilMap.put("docx", Integer.valueOf(1));
    jdField_b_of_type_JavaUtilMap.put("sheet", Integer.valueOf(2));
    jdField_b_of_type_JavaUtilMap.put("form", Integer.valueOf(3));
    jdField_b_of_type_JavaUtilMap.put("slide", Integer.valueOf(4));
    jdField_b_of_type_JavaUtilMap.put("pdf", Integer.valueOf(5));
    jdField_a_of_type_AndroidUtilSparseArray.put(1, new Pair(Integer.valueOf(2130850048), "static://DefaultTeamWorkMiniShareDoc"));
    jdField_a_of_type_AndroidUtilSparseArray.put(2, new Pair(Integer.valueOf(2130850055), "static://DefaultTeamWorkMiniShareSheet"));
    jdField_a_of_type_AndroidUtilSparseArray.put(3, new Pair(Integer.valueOf(2130850051), "static://DefaultTeamWorkMiniShareForm"));
    jdField_a_of_type_AndroidUtilSparseArray.put(4, new Pair(Integer.valueOf(2130850057), "static://DefaultTeamWorkMiniShareSlide"));
    jdField_a_of_type_AndroidUtilSparseArray.put(5, new Pair(Integer.valueOf(2130850053), "static://DefaultTeamWorkMiniSharePdf"));
    jdField_b_of_type_AndroidUtilSparseArray.put(1, new Pair(Integer.valueOf(2130850047), "static://DefaultTeamWorkH5ShareDoc"));
    jdField_b_of_type_AndroidUtilSparseArray.put(2, new Pair(Integer.valueOf(2130850054), "static://DefaultTeamWorkH5ShareSheet"));
    jdField_b_of_type_AndroidUtilSparseArray.put(3, new Pair(Integer.valueOf(2130850050), "static://DefaultTeamWorkH5ShareForm"));
    jdField_b_of_type_AndroidUtilSparseArray.put(4, new Pair(Integer.valueOf(2130850056), "static://DefaultTeamWorkH5ShareSlide"));
    jdField_b_of_type_AndroidUtilSparseArray.put(5, new Pair(Integer.valueOf(2130850052), "static://DefaultTeamWorkH5SharePdf"));
    e = HardCodeUtil.a(2131714554);
    jdField_b_of_type_Long = 0L;
    f = HardCodeUtil.a(2131714584);
    g = HardCodeUtil.a(2131714569);
    h = HardCodeUtil.a(2131714610);
    jdField_a_of_type_Int = -2147483648;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (paramInt == 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("groupid=");
      localStringBuilder.append(paramString);
      localStringBuilder.append("&groupname=");
      localStringBuilder.append(ContactUtils.a(paramQQAppInterface, paramString, false));
      localStringBuilder.append("&uinType=");
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    }
    if (paramInt == 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("groupid=");
      localStringBuilder.append(paramString);
      localStringBuilder.append("&groupname=");
      localStringBuilder.append(ContactUtils.f(paramQQAppInterface, paramString));
      localStringBuilder.append("&uinType=");
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    if (FMConstants.b(paramString)) {
      return "https://pub.idqqimg.com/pc/misc/files/20200116/fd11abde219141a6f97e79c7fde6b71f.png";
    }
    if (FMConstants.c(paramString)) {
      return "https://pub.idqqimg.com/pc/misc/files/20200116/f15795a2b4c9a5f7668f10eb78d27499.png";
    }
    if (FMConstants.e(paramString)) {
      return "https://pub.idqqimg.com/pc/misc/files/20200116/ed532c207b5439a6c29ce241ad7decb7.png";
    }
    if (FMConstants.d(paramString)) {
      return "https://pub.idqqimg.com/pc/misc/files/20200116/fcbfa8f749abb54bf66b48e93c82b295.png";
    }
    if (FMConstants.f(paramString)) {
      return "https://pub.idqqimg.com/pc/misc/files/20200116/90226039f41abf0e1f42e46a5350e364.png";
    }
    return "";
  }
  
  public static List<ChatMessage> a(List<TencentDocData> paramList, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (a(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (TencentDocData)paramList.next();
        MessageForStructing localMessageForStructing = new MessageForStructing();
        localMessageForStructing.structingMsg = new StructMsgForGeneralShare();
        localMessageForStructing.senderuin = String.valueOf(((TencentDocData)localObject).sendUin);
        localMessageForStructing.selfuin = paramString1;
        localMessageForStructing.frienduin = paramString2;
        localMessageForStructing.issend = 1;
        localMessageForStructing.msgtype = -2011;
        localMessageForStructing.time = ((TencentDocData)localObject).aioTime;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mMsgAction = ((TencentDocData)localObject).action;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mSourceAction = ((TencentDocData)localObject).sourceAction;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mMsgServiceID = ((TencentDocData)localObject).serviceId;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentCover = ((TencentDocData)localObject).docIcon;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentSummary = ((TencentDocData)localObject).summary;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentTitle = ((TencentDocData)localObject).getTitle();
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mSourceIcon = ((TencentDocData)localObject).icon;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mSourceName = ((TencentDocData)localObject).sourceName;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mMsgBrief = ((TencentDocData)localObject).getBriefDes(BaseApplication.getContext());
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mSourceUrl = ((TencentDocData)localObject).url;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mSourceAppid = ((TencentDocData)localObject).appid;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mMsgUrl = ((TencentDocData)localObject).docUrl;
        localObject = new StructMsgItemLayout2();
        ((AbsStructMsgItem)localObject).b(0);
        StructMsgItemCover localStructMsgItemCover = new StructMsgItemCover(((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentCover);
        localStructMsgItemCover.t = StructMsgItemCover.q;
        ((AbsStructMsgItem)localObject).a(localStructMsgItemCover);
        ((AbsStructMsgItem)localObject).a(new StructMsgItemTitle(((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentTitle));
        ((AbsStructMsgItem)localObject).a(new StructMsgItemSummary(((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentSummary));
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mStructMsgItemLists.add(localObject);
        localArrayList.add(localMessageForStructing);
      }
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, TencentDocData paramTencentDocData, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    Object localObject = TencentDocLocalCooperationProcessor.a();
    boolean bool;
    if (localObject != null) {
      bool = ((TencentDocLocalCooperationBean)localObject).a(paramTeamWorkFileImportInfo.b);
    } else {
      bool = false;
    }
    int j;
    if (((paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 0) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 3000)) && (TextUtils.isEmpty(paramTeamWorkFileImportInfo.n))) {
      j = 1;
    } else {
      j = 0;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.putExtra("k_forward_show_direct_share_tips", true);
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("req_type", 95);
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("image_url_remote", paramTencentDocData.docIcon);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramQQAppInterface.getCurrentNickname());
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131714583));
    int k;
    if (bool) {
      k = 2131714574;
    } else {
      k = 2131714587;
    }
    ((StringBuilder)localObject).append(HardCodeUtil.a(k));
    ((StringBuilder)localObject).append("《");
    ((StringBuilder)localObject).append(paramTencentDocData.title);
    ((StringBuilder)localObject).append("》");
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (str != null)
    {
      localObject = str;
      if (str.length() > 45)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str.substring(0, 45));
        ((StringBuilder)localObject).append("…");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    localIntent.putExtra("title", (String)localObject);
    str = paramTencentDocData.summary;
    localObject = str;
    if (str != null)
    {
      localObject = str;
      if (str.length() > 60)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str.substring(0, 60));
        ((StringBuilder)localObject).append("…");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    localIntent.putExtra("desc", (String)localObject);
    localIntent.putExtra("detail_url", paramTencentDocData.docUrl);
    localIntent.putExtra("struct_share_key_content_action", "web");
    localIntent.putExtra("struct_share_key_source_action", "web");
    localIntent.putExtra("struct_share_key_source_icon", d);
    localIntent.putExtra("app_name", paramActivity.getString(2131719569));
    localIntent.putExtra("source_url", "https://docs.qq.com/desktop/m/index.html?_wv=2097154");
    localIntent.putExtra("forward _key_nojump", true);
    paramTencentDocData = StructMsgFactory.a(localIntent.getExtras());
    if (paramTencentDocData != null)
    {
      localIntent.putExtra("stuctmsg_bytes", paramTencentDocData.getBytes());
      if (j != 0)
      {
        localIntent.putExtra("uintype", paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
        localIntent.putExtra("uin", paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("troop_uin", paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("uinname", ContactUtils.a(paramQQAppInterface, paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString, paramTeamWorkFileImportInfo.jdField_a_of_type_Int));
      }
      paramQQAppInterface = new StringBuilder(HardCodeUtil.a(2131714547));
      if ((paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 1) && (paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 3000))
      {
        if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 0) {
          paramQQAppInterface.append("好友");
        }
      }
      else {
        paramQQAppInterface.append("群成员");
      }
      if (bool) {
        paramQQAppInterface.append("一起编辑文档：");
      } else {
        paramQQAppInterface.append("一起查看文档：");
      }
      localIntent.putExtra("key_send_tips", paramQQAppInterface.toString());
      if (j == 0) {
        TenDocLogReportHelper.a(null, "0X800A5A1");
      } else {
        TenDocLogReportHelper.a(null, "0X800A5A2");
      }
      if (j != 0) {
        paramQQAppInterface = DirectForwardActivity.class;
      } else {
        paramQQAppInterface = ForwardRecentActivity.class;
      }
      localIntent.setClass(paramActivity, paramQQAppInterface);
      paramActivity.startActivityForResult(localIntent, 2864);
    }
  }
  
  /* Error */
  public static void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +461 -> 462
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aload_0
    //   10: instanceof 281
    //   13: ifeq +147 -> 160
    //   16: aload_0
    //   17: checkcast 281	com/tencent/mobileqq/data/MessageForStructing
    //   20: astore_0
    //   21: aload_0
    //   22: getfield 289	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   25: ifnull +134 -> 159
    //   28: aload_0
    //   29: getfield 289	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   32: getfield 610	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgUrl	Ljava/lang/String;
    //   35: invokestatic 459	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifeq +4 -> 42
    //   41: return
    //   42: aload_0
    //   43: getfield 289	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   46: getfield 610	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgUrl	Ljava/lang/String;
    //   49: invokestatic 611	com/tencent/mobileqq/filemanager/data/FMConstants:a	(Ljava/lang/String;)Z
    //   52: ifeq +410 -> 462
    //   55: aload_0
    //   56: getfield 289	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   59: instanceof 284
    //   62: ifeq +59 -> 121
    //   65: aload_0
    //   66: getfield 289	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   69: checkcast 284	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   72: astore_3
    //   73: aload_3
    //   74: getfield 397	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:mMsgUrl	Ljava/lang/String;
    //   77: aload_0
    //   78: getfield 303	com/tencent/mobileqq/data/MessageForStructing:selfuin	Ljava/lang/String;
    //   81: invokestatic 616	com/tencent/mobileqq/teamwork/TeamWorkHandlerUtils:a	(Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;
    //   84: astore 4
    //   86: aload 4
    //   88: ldc_w 618
    //   91: invokevirtual 624	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   94: ifne +27 -> 121
    //   97: aload_3
    //   98: aload 4
    //   100: ldc_w 626
    //   103: invokevirtual 630	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   106: checkcast 620	org/json/JSONObject
    //   109: ldc_w 512
    //   112: invokevirtual 630	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   115: checkcast 294	java/lang/String
    //   118: putfield 354	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:mContentTitle	Ljava/lang/String;
    //   121: aload_0
    //   122: aload_1
    //   123: invokestatic 632	com/tencent/mobileqq/teamwork/TeamWorkUtils:b	(Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   126: return
    //   127: astore_3
    //   128: goto +24 -> 152
    //   131: astore_3
    //   132: invokestatic 637	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq -14 -> 121
    //   138: getstatic 640	com/tencent/mobileqq/teamwork/TeamWorkConstants:i	Ljava/lang/String;
    //   141: iconst_2
    //   142: aload_3
    //   143: invokevirtual 643	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   146: invokestatic 646	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: goto -28 -> 121
    //   152: aload_0
    //   153: aload_1
    //   154: invokestatic 632	com/tencent/mobileqq/teamwork/TeamWorkUtils:b	(Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   157: aload_3
    //   158: athrow
    //   159: return
    //   160: aload_0
    //   161: instanceof 648
    //   164: ifeq +268 -> 432
    //   167: aload_0
    //   168: checkcast 648	com/tencent/mobileqq/data/MessageForArkApp
    //   171: astore_0
    //   172: aload_0
    //   173: getfield 652	com/tencent/mobileqq/data/MessageForArkApp:ark_app_message	Lcom/tencent/mobileqq/data/ArkAppMessage;
    //   176: getfield 657	com/tencent/mobileqq/data/ArkAppMessage:metaList	Ljava/lang/String;
    //   179: astore_1
    //   180: aload_1
    //   181: invokestatic 459	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   184: ifeq +4 -> 188
    //   187: return
    //   188: new 620	org/json/JSONObject
    //   191: dup
    //   192: aload_1
    //   193: invokespecial 658	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   196: astore_1
    //   197: ldc_w 660
    //   200: aload_0
    //   201: getfield 652	com/tencent/mobileqq/data/MessageForArkApp:ark_app_message	Lcom/tencent/mobileqq/data/ArkAppMessage;
    //   204: getfield 663	com/tencent/mobileqq/data/ArkAppMessage:appName	Ljava/lang/String;
    //   207: invokevirtual 666	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   210: istore_2
    //   211: iload_2
    //   212: ifeq +61 -> 273
    //   215: aload_1
    //   216: ldc_w 668
    //   219: invokevirtual 671	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   222: ifeq +240 -> 462
    //   225: aload_1
    //   226: ldc_w 668
    //   229: invokevirtual 675	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   232: astore_1
    //   233: aload_1
    //   234: ifnull +228 -> 462
    //   237: aload_1
    //   238: ldc_w 677
    //   241: invokevirtual 680	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   244: astore_1
    //   245: aload_1
    //   246: invokestatic 459	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   249: ifne +213 -> 462
    //   252: aload_1
    //   253: invokestatic 611	com/tencent/mobileqq/filemanager/data/FMConstants:a	(Ljava/lang/String;)Z
    //   256: ifeq +206 -> 462
    //   259: aload_1
    //   260: ldc_w 682
    //   263: invokevirtual 686	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   266: iconst_0
    //   267: aaload
    //   268: aload_0
    //   269: invokestatic 689	com/tencent/mobileqq/teamwork/TeamWorkUtils:a	(Ljava/lang/String;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   272: return
    //   273: ldc_w 691
    //   276: aload_0
    //   277: getfield 652	com/tencent/mobileqq/data/MessageForArkApp:ark_app_message	Lcom/tencent/mobileqq/data/ArkAppMessage;
    //   280: getfield 663	com/tencent/mobileqq/data/ArkAppMessage:appName	Ljava/lang/String;
    //   283: invokevirtual 666	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   286: ifeq +61 -> 347
    //   289: aload_1
    //   290: ldc_w 693
    //   293: invokevirtual 671	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   296: ifeq +166 -> 462
    //   299: aload_1
    //   300: ldc_w 693
    //   303: invokevirtual 675	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   306: astore_1
    //   307: aload_1
    //   308: ifnull +154 -> 462
    //   311: aload_1
    //   312: ldc_w 677
    //   315: invokevirtual 680	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   318: astore_1
    //   319: aload_1
    //   320: invokestatic 459	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   323: ifne +139 -> 462
    //   326: aload_1
    //   327: invokestatic 611	com/tencent/mobileqq/filemanager/data/FMConstants:a	(Ljava/lang/String;)Z
    //   330: ifeq +132 -> 462
    //   333: aload_1
    //   334: ldc_w 682
    //   337: invokevirtual 686	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   340: iconst_0
    //   341: aaload
    //   342: aload_0
    //   343: invokestatic 689	com/tencent/mobileqq/teamwork/TeamWorkUtils:a	(Ljava/lang/String;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   346: return
    //   347: ldc_w 695
    //   350: aload_0
    //   351: getfield 652	com/tencent/mobileqq/data/MessageForArkApp:ark_app_message	Lcom/tencent/mobileqq/data/ArkAppMessage;
    //   354: getfield 663	com/tencent/mobileqq/data/ArkAppMessage:appName	Ljava/lang/String;
    //   357: invokevirtual 666	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   360: ifeq +102 -> 462
    //   363: aload_1
    //   364: ldc_w 697
    //   367: invokevirtual 671	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   370: ifeq +92 -> 462
    //   373: aload_1
    //   374: ldc_w 697
    //   377: invokevirtual 700	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   380: astore_1
    //   381: aload_1
    //   382: ifnull +80 -> 462
    //   385: aload_1
    //   386: ldc_w 702
    //   389: invokevirtual 680	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   392: astore_1
    //   393: aload_1
    //   394: invokestatic 459	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   397: ifne +65 -> 462
    //   400: aload_1
    //   401: invokestatic 611	com/tencent/mobileqq/filemanager/data/FMConstants:a	(Ljava/lang/String;)Z
    //   404: ifeq +58 -> 462
    //   407: aload_1
    //   408: aload_0
    //   409: invokestatic 689	com/tencent/mobileqq/teamwork/TeamWorkUtils:a	(Ljava/lang/String;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   412: return
    //   413: astore_0
    //   414: invokestatic 637	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   417: ifeq +45 -> 462
    //   420: getstatic 640	com/tencent/mobileqq/teamwork/TeamWorkConstants:i	Ljava/lang/String;
    //   423: iconst_2
    //   424: aload_0
    //   425: invokevirtual 643	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   428: invokestatic 646	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   431: return
    //   432: aload_0
    //   433: instanceof 704
    //   436: ifeq +26 -> 462
    //   439: aload_0
    //   440: checkcast 704	com/tencent/mobileqq/data/MessageForText
    //   443: astore_0
    //   444: aload_0
    //   445: getfield 707	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   448: invokestatic 611	com/tencent/mobileqq/filemanager/data/FMConstants:a	(Ljava/lang/String;)Z
    //   451: ifeq +11 -> 462
    //   454: aload_0
    //   455: getfield 707	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   458: aload_0
    //   459: invokestatic 689	com/tencent/mobileqq/teamwork/TeamWorkUtils:a	(Ljava/lang/String;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   462: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	463	0	paramMessageRecord	MessageRecord
    //   0	463	1	paramQQAppInterface	QQAppInterface
    //   210	2	2	bool	boolean
    //   72	26	3	localStructMsgForGeneralShare	StructMsgForGeneralShare
    //   127	1	3	localObject	Object
    //   131	27	3	localJSONException	JSONException
    //   84	15	4	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   55	121	127	finally
    //   132	149	127	finally
    //   55	121	131	org/json/JSONException
    //   188	211	413	org/json/JSONException
    //   215	233	413	org/json/JSONException
    //   237	272	413	org/json/JSONException
    //   273	307	413	org/json/JSONException
    //   311	346	413	org/json/JSONException
    //   347	381	413	org/json/JSONException
    //   385	412	413	org/json/JSONException
  }
  
  public static void a(String paramString)
  {
    a(paramString, null);
  }
  
  public static void a(String paramString, ChatMessage paramChatMessage)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str1;
    Object localObject;
    if (paramChatMessage != null)
    {
      str1 = paramChatMessage.senderuin;
      localObject = paramChatMessage.frienduin;
    }
    else
    {
      str1 = null;
      localObject = str1;
    }
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      String str2 = localQQAppInterface.getCurrentAccountUin();
      JSONObject localJSONObject = TeamWorkHandlerUtils.a(paramString, str2);
      if (localJSONObject.getInt("retcode") == 0)
      {
        TencentDocData localTencentDocData = new TencentDocData();
        TencentDocData.obtainFromJsonObject(localJSONObject, null, localTencentDocData);
        localTencentDocData.docUrl = paramString;
        paramString = str1;
        if (str1 == null) {
          paramString = str2;
        }
        localTencentDocData.sendUin = Long.parseLong(paramString);
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = str2;
        }
        localTencentDocData.aioTime = (System.currentTimeMillis() / 1000L);
        localObject = new ArrayList();
        ((ArrayList)localObject).add(localTencentDocData);
        paramString = a((List)localObject, str2, paramString).iterator();
        while (paramString.hasNext())
        {
          localObject = (ChatMessage)paramString.next();
          if (paramChatMessage != null) {
            ((ChatMessage)localObject).istroop = paramChatMessage.istroop;
          }
          b((MessageRecord)localObject, localQQAppInterface);
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e(i, 2, paramString, new Object[0]);
      }
    }
  }
  
  public static boolean a(Collection paramCollection)
  {
    return (paramCollection != null) && (!paramCollection.isEmpty());
  }
  
  private static void b(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
      if (localMessageForStructing.structingMsg != null)
      {
        if (TextUtils.isEmpty(localMessageForStructing.structingMsg.mMsgUrl)) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(TeamWorkConstants.i, 2, "tencentdoc also need insert into fm db");
        }
        msg_comm.Msg localMsg = new msg_comm.Msg();
        Object localObject1 = new msg_comm.MsgHead();
        localMsg.msg_head.set((MessageMicro)localObject1);
        ((msg_comm.MsgHead)localMsg.msg_head.get()).msg_uid.set(localMessageForStructing.longMsgId);
        ((msg_comm.MsgHead)localMsg.msg_head.get()).msg_time.set((int)localMessageForStructing.time);
        if ((localMessageForStructing.senderuin != null) && (localMessageForStructing.frienduin != null) && (localMessageForStructing.selfuin != null)) {
          if (localMessageForStructing.senderuin.equals(localMessageForStructing.frienduin))
          {
            ((msg_comm.MsgHead)localMsg.msg_head.get()).from_uin.set(Long.parseLong(localMessageForStructing.senderuin));
            ((msg_comm.MsgHead)localMsg.msg_head.get()).to_uin.set(Long.parseLong(localMessageForStructing.selfuin));
          }
          else
          {
            ((msg_comm.MsgHead)localMsg.msg_head.get()).from_uin.set(Long.parseLong(localMessageForStructing.senderuin));
            ((msg_comm.MsgHead)localMsg.msg_head.get()).to_uin.set(Long.parseLong(localMessageForStructing.frienduin));
          }
        }
        if (localMessageForStructing.istroop == 1)
        {
          localObject1 = new msg_comm.C2CTmpMsgHead();
          ((msg_comm.MsgHead)localMsg.msg_head.get()).c2c_tmp_msg_head.set((MessageMicro)localObject1);
          ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)localMsg.msg_head.get()).c2c_tmp_msg_head.get()).service_type.set(1);
          if (localMessageForStructing.frienduin != null) {
            ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)localMsg.msg_head.get()).c2c_tmp_msg_head.get()).group_code.set(Integer.parseInt(localMessageForStructing.frienduin));
          }
        }
        ((msg_comm.MsgHead)localMsg.msg_head.get()).msg_seq.set((short)(int)localMessageForStructing.msgseq);
        localObject1 = new im_msg_body.NotOnlineFile();
        ((im_msg_body.NotOnlineFile)localObject1).uint32_file_type.set(0);
        ((im_msg_body.NotOnlineFile)localObject1).bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(localMessageForStructing.structingMsg.mMsgUrl));
        ((im_msg_body.NotOnlineFile)localObject1).uint64_file_size.set(0L);
        ((im_msg_body.NotOnlineFile)localObject1).uint32_subcmd.set(1);
        Object localObject2;
        if ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))
        {
          localObject2 = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
          if (TextUtils.isEmpty(((StructMsgForGeneralShare)localObject2).mContentCover)) {
            ((StructMsgForGeneralShare)localObject2).mContentCover = a(((StructMsgForGeneralShare)localObject2).mMsgUrl);
          }
          if (!TextUtils.isEmpty(((StructMsgForGeneralShare)localObject2).mContentTitle)) {
            ((im_msg_body.NotOnlineFile)localObject1).bytes_file_name.set(ByteStringMicro.copyFromUtf8(((StructMsgForGeneralShare)localObject2).mContentTitle));
          }
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("structmsg_service_id", ((StructMsgForGeneralShare)localObject2).mMsgServiceID);
            localJSONObject.put("stuctmsg_bytes", Base64.encodeToString(((StructMsgForGeneralShare)localObject2).getBytes(), 0));
            localJSONObject.put("structmsg_uniseq", paramMessageRecord.uniseq);
            localJSONObject.put("accostType", ((StructMsgForGeneralShare)localObject2).sourceAccoutType);
          }
          catch (JSONException paramMessageRecord)
          {
            if (QLog.isColorLevel()) {
              QLog.e(TeamWorkConstants.i, 2, paramMessageRecord.getMessage());
            }
          }
          ((im_msg_body.NotOnlineFile)localObject1).bytes_note.set(ByteStringMicro.copyFromUtf8(((StructMsgForGeneralShare)localObject2).mContentCover));
          ((im_msg_body.NotOnlineFile)localObject1).bytes_pb_reserve.set(ByteStringMicro.copyFrom(localJSONObject.toString().getBytes()));
        }
        paramMessageRecord = new ArrayList(paramQQAppInterface.getFileManagerProxy().b()).iterator();
        while (paramMessageRecord.hasNext())
        {
          localObject2 = (FileManagerEntity)paramMessageRecord.next();
          if ((((FileManagerEntity)localObject2).Uuid != null) && (((FileManagerEntity)localObject2).Uuid.equalsIgnoreCase(localMessageForStructing.structingMsg.mMsgUrl)))
          {
            ((FileManagerEntity)localObject2).srvTime = (localMessageForStructing.time * 1000L);
            ((FileManagerEntity)localObject2).bDelInFM = false;
            paramQQAppInterface.getFileManagerDataCenter().c((FileManagerEntity)localObject2);
            return;
          }
        }
        ThreadManager.getUIHandler().post(new TeamWorkUtils.4(paramQQAppInterface, localMsg, (im_msg_body.NotOnlineFile)localObject1, localMessageForStructing));
      }
    }
  }
  
  private static void b(String paramString, QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = TeamWorkHandlerUtils.a(paramString, paramQQAppInterface.getCurrentAccountUin());
      if (paramString.getInt("retcode") == 0)
      {
        paramString = (String)((JSONObject)paramString.get("doc_meta")).get("title");
        if (!paramFileManagerEntity.fileName.equals(paramString))
        {
          paramFileManagerEntity.fileName = paramString;
          paramQQAppInterface.getFileManagerDataCenter().c(paramFileManagerEntity);
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkUtils
 * JD-Core Version:    0.7.0.1
 */