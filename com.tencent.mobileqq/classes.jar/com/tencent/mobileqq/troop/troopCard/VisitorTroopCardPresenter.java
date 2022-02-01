package com.tencent.mobileqq.troop.troopCard;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.activity.photo.AvatarInfo;
import com.tencent.mobileqq.activity.photo.TroopAvatarController;
import com.tencent.mobileqq.activity.photo.TroopPhotoController;
import com.tencent.mobileqq.activity.photo.TroopPhotoController.OnGotoBigPicListener;
import com.tencent.mobileqq.activity.photo.TroopPhotoUtil;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopUploadingTask;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.oidb.cmd0x899.oidb_0x899.memberlist;>;
import java.util.Observer;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class VisitorTroopCardPresenter
{
  protected int a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected OpenIdObserver a;
  private TroopPhotoController.OnGotoBigPicListener jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController$OnGotoBigPicListener = new VisitorTroopCardPresenter.4(this);
  private TroopPhotoController jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new VisitorTroopCardPresenter.6(this);
  private TroopHandler jdField_a_of_type_ComTencentMobileqqAppTroopHandler;
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener = new VisitorTroopCardPresenter.3(this);
  private IVisitorTroopCardViewInterface jdField_a_of_type_ComTencentMobileqqTroopTroopCardIVisitorTroopCardViewInterface;
  HttpWebCgiAsyncTask.Callback jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = new VisitorTroopCardPresenter.9(this);
  private TroopAvatarManger jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger;
  private TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData;
  private String jdField_a_of_type_JavaLangString;
  private List<TroopClipPic> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Observer jdField_a_of_type_JavaUtilObserver = new VisitorTroopCardPresenter.5(this);
  private boolean jdField_a_of_type_Boolean = false;
  private List<TroopClipPic> b = new ArrayList();
  
  public VisitorTroopCardPresenter()
  {
    this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver = new VisitorTroopCardPresenter.2(this);
  }
  
  private FragmentActivity a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardIVisitorTroopCardViewInterface != null) {
      return ((VisitorTroopCardFragment)this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardIVisitorTroopCardViewInterface).getActivity();
    }
    return null;
  }
  
  private VisitorTroopCardFragment a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardIVisitorTroopCardViewInterface != null) {
      return (VisitorTroopCardFragment)this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardIVisitorTroopCardViewInterface;
    }
    return null;
  }
  
  /* Error */
  private void a(KQQ.BatchResponse paramBatchResponse)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: getfield 114	KQQ/BatchResponse:result	I
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 116	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   15: dup
    //   16: invokespecial 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   19: astore 9
    //   21: aload 9
    //   23: aload_1
    //   24: getfield 121	KQQ/BatchResponse:buffer	[B
    //   27: invokevirtual 125	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   30: pop
    //   31: aload_1
    //   32: getfield 128	KQQ/BatchResponse:seq	I
    //   35: ifne +240 -> 275
    //   38: aload 9
    //   40: getfield 132	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   43: invokevirtual 138	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   46: ifeq +229 -> 275
    //   49: aload 9
    //   51: getfield 132	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   54: invokevirtual 142	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   57: invokevirtual 148	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   60: astore 7
    //   62: new 150	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   65: dup
    //   66: invokespecial 151	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   69: astore 8
    //   71: aload 8
    //   73: aload 7
    //   75: invokevirtual 152	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   78: pop
    //   79: aload 8
    //   81: getfield 156	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   84: invokevirtual 161	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   87: astore 10
    //   89: aload 10
    //   91: ifnonnull +49 -> 140
    //   94: iconst_0
    //   95: istore_2
    //   96: goto +870 -> 966
    //   99: aload 7
    //   101: ifnonnull +174 -> 275
    //   104: iload_3
    //   105: iload_2
    //   106: if_icmpge +169 -> 275
    //   109: aload 10
    //   111: iload_3
    //   112: invokeinterface 166 2 0
    //   117: checkcast 168	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   120: astore 8
    //   122: aload 8
    //   124: ifnonnull +27 -> 151
    //   127: iload_3
    //   128: iconst_1
    //   129: iadd
    //   130: istore_3
    //   131: goto -32 -> 99
    //   134: astore_1
    //   135: aload_1
    //   136: invokevirtual 171	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   139: return
    //   140: aload 10
    //   142: invokeinterface 175 1 0
    //   147: istore_2
    //   148: goto +818 -> 966
    //   151: aload 8
    //   153: getfield 179	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   156: invokevirtual 183	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   159: istore 4
    //   161: iload 4
    //   163: bipush 72
    //   165: if_icmpne +35 -> 200
    //   168: iload_3
    //   169: ifne +31 -> 200
    //   172: aload_0
    //   173: invokespecial 86	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardPresenter:a	()Landroid/support/v4/app/FragmentActivity;
    //   176: ifnull +697 -> 873
    //   179: aload_0
    //   180: getfield 78	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardPresenter:jdField_a_of_type_ComTencentMobileqqTroopTroopCardIVisitorTroopCardViewInterface	Lcom/tencent/mobileqq/troop/troopCard/IVisitorTroopCardViewInterface;
    //   183: aload_0
    //   184: invokespecial 86	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardPresenter:a	()Landroid/support/v4/app/FragmentActivity;
    //   187: ldc 184
    //   189: invokevirtual 190	android/support/v4/app/FragmentActivity:getString	(I)Ljava/lang/String;
    //   192: invokeinterface 195 2 0
    //   197: goto -70 -> 127
    //   200: iload 4
    //   202: ifne +643 -> 845
    //   205: aload 8
    //   207: getfield 199	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   210: invokevirtual 202	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   213: ifeq +632 -> 845
    //   216: aload 8
    //   218: getfield 199	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   221: invokevirtual 205	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   224: checkcast 201	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   227: astore 8
    //   229: aload 8
    //   231: astore 7
    //   233: aload 8
    //   235: ifnull -108 -> 127
    //   238: aload_0
    //   239: getfield 78	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardPresenter:jdField_a_of_type_ComTencentMobileqqTroopTroopCardIVisitorTroopCardViewInterface	Lcom/tencent/mobileqq/troop/troopCard/IVisitorTroopCardViewInterface;
    //   242: aload 8
    //   244: invokeinterface 208 2 0
    //   249: aload 8
    //   251: astore 7
    //   253: goto -126 -> 127
    //   256: astore 7
    //   258: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq +14 -> 275
    //   264: ldc 215
    //   266: iconst_2
    //   267: aload 7
    //   269: invokevirtual 219	java/lang/Exception:toString	()Ljava/lang/String;
    //   272: invokestatic 223	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: aload_1
    //   276: getfield 128	KQQ/BatchResponse:seq	I
    //   279: iconst_1
    //   280: if_icmpne +117 -> 397
    //   283: aload 9
    //   285: getfield 132	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   288: invokevirtual 138	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   291: ifeq +106 -> 397
    //   294: aload 9
    //   296: getfield 132	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   299: invokevirtual 142	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   302: invokevirtual 148	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   305: astore 7
    //   307: new 225	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody
    //   310: dup
    //   311: invokespecial 226	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:<init>	()V
    //   314: astore 8
    //   316: aload 8
    //   318: aload 7
    //   320: invokevirtual 227	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   323: pop
    //   324: aload 8
    //   326: getfield 230	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   329: invokevirtual 231	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   332: ifeq +65 -> 397
    //   335: aload_0
    //   336: getfield 100	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardPresenter:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   339: getfield 236	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   342: ifeq +20 -> 362
    //   345: aload_0
    //   346: invokespecial 94	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardPresenter:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
    //   349: ifnull +527 -> 876
    //   352: aload_0
    //   353: invokespecial 94	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardPresenter:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
    //   356: getfield 239	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment:d	Z
    //   359: ifeq +517 -> 876
    //   362: aload_0
    //   363: invokespecial 94	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardPresenter:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
    //   366: ifnull +31 -> 397
    //   369: aload_0
    //   370: invokespecial 94	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardPresenter:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
    //   373: getfield 242	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   376: ifnull +21 -> 397
    //   379: aload_0
    //   380: invokespecial 94	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardPresenter:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
    //   383: getfield 242	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   386: aload 8
    //   388: getfield 230	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   391: invokevirtual 161	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   394: invokevirtual 247	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:a	(Ljava/util/List;)V
    //   397: aload_1
    //   398: getfield 128	KQQ/BatchResponse:seq	I
    //   401: iconst_2
    //   402: if_icmpne -391 -> 11
    //   405: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq +11 -> 419
    //   411: ldc 249
    //   413: iconst_2
    //   414: ldc 251
    //   416: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   419: aload 9
    //   421: getfield 132	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   424: invokevirtual 138	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   427: ifeq -416 -> 11
    //   430: aload 9
    //   432: getfield 132	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   435: invokevirtual 142	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   438: invokevirtual 148	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   441: astore_1
    //   442: new 255	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody
    //   445: dup
    //   446: invokespecial 256	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:<init>	()V
    //   449: astore 8
    //   451: aload 8
    //   453: aload_1
    //   454: invokevirtual 257	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   457: pop
    //   458: aload 8
    //   460: getfield 261	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   463: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   466: ifeq -455 -> 11
    //   469: aload 8
    //   471: getfield 267	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   474: invokevirtual 270	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   477: ifne +484 -> 961
    //   480: aload 8
    //   482: getfield 267	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   485: invokevirtual 161	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   488: astore_1
    //   489: aload 8
    //   491: getfield 273	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name_new	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   494: invokevirtual 270	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   497: ifne +458 -> 955
    //   500: aload 8
    //   502: getfield 273	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name_new	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   505: invokevirtual 161	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   508: astore 7
    //   510: aload_0
    //   511: getfield 89	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardPresenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   514: getstatic 278	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   517: invokevirtual 284	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   520: checkcast 286	com/tencent/mobileqq/app/TroopManager
    //   523: astore 9
    //   525: aload 8
    //   527: getfield 261	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   530: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   533: lstore 5
    //   535: aload 9
    //   537: lload 5
    //   539: invokestatic 295	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   542: invokevirtual 298	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   545: astore 10
    //   547: aload 10
    //   549: ifnull -538 -> 11
    //   552: aload_1
    //   553: ifnull +70 -> 623
    //   556: aload 10
    //   558: aload_1
    //   559: aload 7
    //   561: invokevirtual 304	com/tencent/mobileqq/data/troop/TroopInfo:setTroopLevelMap787	(Ljava/util/List;Ljava/util/List;)V
    //   564: aload 8
    //   566: getfield 307	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   569: invokevirtual 308	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   572: ifeq +341 -> 913
    //   575: aload 8
    //   577: getfield 307	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   580: invokevirtual 183	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   583: istore_2
    //   584: aload 10
    //   586: iload_2
    //   587: i2l
    //   588: putfield 312	com/tencent/mobileqq/data/troop/TroopInfo:dwGroupLevelSeq	J
    //   591: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   594: ifeq +29 -> 623
    //   597: ldc 249
    //   599: iconst_2
    //   600: new 314	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 315	java/lang/StringBuilder:<init>	()V
    //   607: ldc_w 317
    //   610: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: iload_2
    //   614: invokevirtual 324	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   617: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   623: aload 10
    //   625: aload 8
    //   627: getfield 328	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   630: invokevirtual 142	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   633: invokevirtual 331	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   636: putfield 334	com/tencent/mobileqq/data/troop/TroopInfo:ownerNameShow	Ljava/lang/String;
    //   639: aload 10
    //   641: aload 8
    //   643: getfield 337	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   646: invokevirtual 142	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   649: invokevirtual 331	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   652: putfield 340	com/tencent/mobileqq/data/troop/TroopInfo:adminNameShow	Ljava/lang/String;
    //   655: aload 8
    //   657: getfield 343	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   660: invokevirtual 308	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   663: ifeq +287 -> 950
    //   666: aload 10
    //   668: aload 8
    //   670: getfield 343	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   673: invokevirtual 183	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   676: i2b
    //   677: putfield 347	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankSysFlag	B
    //   680: aload 10
    //   682: getfield 347	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankSysFlag	B
    //   685: istore_2
    //   686: aload 8
    //   688: getfield 350	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   691: invokevirtual 308	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   694: ifeq +251 -> 945
    //   697: aload 10
    //   699: aload 8
    //   701: getfield 350	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   704: invokevirtual 183	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   707: i2b
    //   708: putfield 353	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankUserFlag	B
    //   711: aload 10
    //   713: getfield 353	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankUserFlag	B
    //   716: istore_3
    //   717: aload 8
    //   719: getfield 356	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   722: invokevirtual 308	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   725: ifeq +214 -> 939
    //   728: aload 10
    //   730: aload 8
    //   732: getfield 356	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   735: invokevirtual 183	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   738: i2b
    //   739: putfield 359	com/tencent/mobileqq/data/troop/TroopInfo:cNewGroupRankUserFlag	B
    //   742: aload 10
    //   744: getfield 359	com/tencent/mobileqq/data/troop/TroopInfo:cNewGroupRankUserFlag	B
    //   747: istore 4
    //   749: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   752: ifeq +55 -> 807
    //   755: ldc 249
    //   757: iconst_2
    //   758: new 314	java/lang/StringBuilder
    //   761: dup
    //   762: invokespecial 315	java/lang/StringBuilder:<init>	()V
    //   765: lload 5
    //   767: invokevirtual 362	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   770: ldc_w 364
    //   773: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: iload_2
    //   777: invokevirtual 324	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   780: ldc_w 366
    //   783: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: iload_3
    //   787: invokevirtual 324	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   790: ldc_w 368
    //   793: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: iload 4
    //   798: invokevirtual 324	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   801: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   804: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   807: new 370	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardPresenter$7
    //   810: dup
    //   811: aload_0
    //   812: aload 9
    //   814: aload 10
    //   816: invokespecial 373	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardPresenter$7:<init>	(Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardPresenter;Lcom/tencent/mobileqq/app/TroopManager;Lcom/tencent/mobileqq/data/troop/TroopInfo;)V
    //   819: bipush 8
    //   821: aconst_null
    //   822: iconst_0
    //   823: invokestatic 379	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   826: return
    //   827: astore_1
    //   828: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   831: ifeq -820 -> 11
    //   834: ldc 249
    //   836: iconst_2
    //   837: aload_1
    //   838: invokevirtual 219	java/lang/Exception:toString	()Ljava/lang/String;
    //   841: invokestatic 382	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   844: return
    //   845: ldc_w 384
    //   848: iconst_1
    //   849: new 314	java/lang/StringBuilder
    //   852: dup
    //   853: invokespecial 315	java/lang/StringBuilder:<init>	()V
    //   856: ldc_w 386
    //   859: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: iload 4
    //   864: invokevirtual 324	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   867: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   870: invokestatic 382	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   873: goto -746 -> 127
    //   876: aload_0
    //   877: aload 8
    //   879: getfield 230	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   882: invokevirtual 161	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   885: invokespecial 387	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardPresenter:a	(Ljava/util/List;)V
    //   888: goto -491 -> 397
    //   891: astore 7
    //   893: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   896: ifeq -499 -> 397
    //   899: ldc 215
    //   901: iconst_2
    //   902: aload 7
    //   904: invokevirtual 219	java/lang/Exception:toString	()Ljava/lang/String;
    //   907: invokestatic 223	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   910: goto -513 -> 397
    //   913: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   916: ifeq -293 -> 623
    //   919: ldc 249
    //   921: iconst_2
    //   922: ldc_w 389
    //   925: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   928: goto -305 -> 623
    //   931: astore_1
    //   932: aload_1
    //   933: invokevirtual 390	java/lang/Exception:printStackTrace	()V
    //   936: goto -281 -> 655
    //   939: iconst_m1
    //   940: istore 4
    //   942: goto -193 -> 749
    //   945: iconst_m1
    //   946: istore_3
    //   947: goto -230 -> 717
    //   950: iconst_m1
    //   951: istore_2
    //   952: goto -266 -> 686
    //   955: aconst_null
    //   956: astore 7
    //   958: goto -448 -> 510
    //   961: aconst_null
    //   962: astore_1
    //   963: goto -474 -> 489
    //   966: iconst_0
    //   967: istore_3
    //   968: aconst_null
    //   969: astore 7
    //   971: goto -872 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	974	0	this	VisitorTroopCardPresenter
    //   0	974	1	paramBatchResponse	KQQ.BatchResponse
    //   95	857	2	i	int
    //   104	864	3	j	int
    //   159	782	4	k	int
    //   533	233	5	l	long
    //   60	192	7	localObject1	Object
    //   256	12	7	localException1	Exception
    //   305	255	7	localObject2	Object
    //   891	12	7	localException2	Exception
    //   956	14	7	localObject3	Object
    //   69	809	8	localObject4	Object
    //   19	794	9	localObject5	Object
    //   87	728	10	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   21	31	134	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   62	89	256	java/lang/Exception
    //   109	122	256	java/lang/Exception
    //   140	148	256	java/lang/Exception
    //   151	161	256	java/lang/Exception
    //   172	197	256	java/lang/Exception
    //   205	229	256	java/lang/Exception
    //   238	249	256	java/lang/Exception
    //   845	873	256	java/lang/Exception
    //   442	489	827	java/lang/Exception
    //   489	510	827	java/lang/Exception
    //   510	547	827	java/lang/Exception
    //   556	623	827	java/lang/Exception
    //   655	686	827	java/lang/Exception
    //   686	717	827	java/lang/Exception
    //   717	749	827	java/lang/Exception
    //   749	807	827	java/lang/Exception
    //   807	826	827	java/lang/Exception
    //   913	928	827	java/lang/Exception
    //   932	936	827	java/lang/Exception
    //   307	362	891	java/lang/Exception
    //   362	397	891	java/lang/Exception
    //   876	888	891	java/lang/Exception
    //   623	655	931	java/lang/Exception
  }
  
  private void a(List<oidb_0x899.memberlist> paramList)
  {
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    ArrayList localArrayList1 = new ArrayList();
    Object localObject2 = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      localObject1 = (oidb_0x899.memberlist)localIterator.next();
      String str = String.valueOf(((oidb_0x899.memberlist)localObject1).uint64_member_uin.get());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin)) && (str.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))) {
        paramList = (List<oidb_0x899.memberlist>)localObject1;
      } else if (((TroopRobotManager)localObject2).b(str)) {
        localArrayList1.add(localObject1);
      } else if (TroopUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, str)) {
        localArrayList2.add(localObject1);
      } else {
        localArrayList3.add(localObject1);
      }
    }
    localObject2 = new ArrayList();
    Object localObject1 = paramList;
    if (paramList == null) {}
    try
    {
      localObject1 = new oidb_0x899.memberlist();
      ((oidb_0x899.memberlist)localObject1).uint64_member_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin));
      ((List)localObject2).add(0, localObject1);
    }
    catch (NumberFormatException paramList)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, paramList.toString());
        }
      }
      if (a() == null) {
        break label419;
      }
      localObject1 = TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember, a().jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, paramList);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label419;
      }
      a().jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.memberListToShow = ((String)localObject1);
      localTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramList, true, null);
    }
    ((List)localObject2).addAll(localArrayList2);
    if ((a() != null) && (a().jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView != null)) {
      a().jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.a((List)localObject2);
    }
    ((List)localObject2).addAll(localArrayList3);
    ((List)localObject2).addAll(localArrayList1);
    paramList = new ArrayList();
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.add(String.valueOf(((oidb_0x899.memberlist)((Iterator)localObject1).next()).uint64_member_uin.get()));
    }
    label419:
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.setOnGotoBigPicListener(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController$OnGotoBigPicListener);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.setOnGotoBigPicListener(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController$OnGotoBigPicListener = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = null;
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
  }
  
  protected Drawable a(String paramString)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(4, paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        localObject = localBitmap;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 4, true);
          localObject = localBitmap;
        }
      }
    }
    paramString = localObject;
    if (localObject == null) {
      paramString = ImageUtil.c();
    }
    return new BitmapDrawable(paramString);
  }
  
  public void a()
  {
    f();
    h();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onDestroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.onDestroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.b(this.jdField_a_of_type_JavaUtilObserver);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardIVisitorTroopCardViewInterface = null;
  }
  
  void a(Bundle paramBundle, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController$OnGotoBigPicListener != null)
    {
      paramBundle.putInt("troop_auth_submit_time", this.jdField_a_of_type_Int);
      paramBundle.putBoolean("troop_info_is_member", paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController$OnGotoBigPicListener.gotoBigPic(paramBundle);
    }
  }
  
  public void a(IVisitorTroopCardViewInterface paramIVisitorTroopCardViewInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardIVisitorTroopCardViewInterface = paramIVisitorTroopCardViewInterface;
    if (a() == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = a().jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = a().jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger = new TroopAvatarManger(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopUploadingTask.class, this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController = new TroopAvatarController(a(), a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    e();
    g();
  }
  
  void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardIVisitorTroopCardViewInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      TroopHandler localTroopHandler;
      do
      {
        return;
        localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      } while (localTroopHandler == null);
      try
      {
        long l = Long.parseLong(paramString);
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardIVisitorTroopCardViewInterface.c();
        localTroopHandler.a(l, paramInt);
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, paramString.toString());
  }
  
  void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onPicPicked(paramString1, paramString2);
    }
  }
  
  void a(String paramString1, String paramString2, String paramString3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_JavaLangString = paramString2;
        if ((!TextUtils.isEmpty(paramString3)) && (!paramString3.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardIVisitorTroopCardViewInterface.b();
          return;
        }
      } while (TextUtils.isEmpty(paramString2));
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(paramString1);
      if (paramString2 == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardIVisitorTroopCardViewInterface.c();
        this.jdField_a_of_type_AndroidOsHandler = new Handler();
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VisitorTroopCardPresenter.1(this), 3000L);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().d(paramString1);
        return;
      }
    } while (this.jdField_a_of_type_JavaLangString.equals(paramString2.openID));
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardIVisitorTroopCardViewInterface.b();
  }
  
  void a(List<TroopClipPic> paramList, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardIVisitorTroopCardViewInterface == null)) {
      return;
    }
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin));
    Object localObject;
    boolean bool;
    label72:
    ArrayList localArrayList;
    if (QLog.isColorLevel())
    {
      if (paramList == null)
      {
        localObject = "null";
        if (localTroopInfo != null) {
          break label238;
        }
        bool = true;
        QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, String.format("setAvatarList isServer=%b piclist=%s troopinfo=null %b", new Object[] { Boolean.valueOf(paramBoolean), localObject, Boolean.valueOf(bool) }));
      }
    }
    else
    {
      localArrayList = new ArrayList();
      localObject = paramList;
      if (localTroopInfo != null)
      {
        localObject = paramList;
        if (paramList == null)
        {
          localObject = new ArrayList();
          TroopPhotoUtil.b((List)localObject, localTroopInfo);
        }
      }
      if (localObject == null) {
        break label315;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      this.b.clear();
      paramList = ((List)localObject).iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label272;
      }
      localObject = (TroopClipPic)paramList.next();
      if (((TroopClipPic)localObject).type == 1)
      {
        this.b.add(localObject);
        continue;
        localObject = Integer.valueOf(paramList.size());
        break;
        label238:
        bool = false;
        break label72;
      }
      localArrayList.add(AvatarInfo.a((TroopClipPic)localObject, null));
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
    label272:
    if (this.b.size() == 0)
    {
      paramList = new TroopClipPic();
      paramList.id = AvatarInfo.jdField_a_of_type_JavaLangString;
      paramList.type = 1;
      this.b.add(paramList);
    }
    label315:
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardIVisitorTroopCardViewInterface.a(false, localArrayList);
  }
  
  void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (a() == null)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler == null) {
      return;
    }
    TroopHandler localTroopHandler = this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler;
    long l = BizTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) && (!a().d)) {}
    for (boolean bool = true;; bool = false)
    {
      localTroopHandler.a(l, bool, 0);
      return;
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {
      return;
    }
    ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), paramString1, paramString2, null, null);
  }
  
  protected void c()
  {
    if ((a() != null) && (a().jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) {
      ThreadManager.post(new VisitorTroopCardPresenter.8(this), 5, null, false);
    }
  }
  
  void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onPickPic();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter
 * JD-Core Version:    0.7.0.1
 */