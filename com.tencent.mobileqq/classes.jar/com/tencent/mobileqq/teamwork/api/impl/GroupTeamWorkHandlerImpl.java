package com.tencent.mobileqq.teamwork.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGroupTeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamworkforgroup.GPadInfo;
import com.tencent.mobileqq.teamworkforgroup.GroupPadTemplateInfo;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkManager;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkObserver;
import com.tencent.mobileqq.troop.managerfactory.api.IManagerFactoryService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0xae9.Oidb_0xae9.GetListReq;
import tencent.im.oidb.cmd0xae9.Oidb_0xae9.GetListRsp;
import tencent.im.oidb.cmd0xae9.Oidb_0xae9.ReqBody;
import tencent.im.oidb.cmd0xae9.Oidb_0xae9.RspBody;
import tencent.im.oidb.cmd0xae9.group_online_docs.DocInfo;
import tencent.im.oidb.cmd0xae9.online_docs.DocId;
import tencent.im.oidb.cmd0xae9.online_docs.DocMetaData;
import tencent.im.oidb.cmd0xaee.Oidb_0xaee.ReqBody;
import tencent.im.oidb.cmd0xaee.Oidb_0xaee.Template;
import tencent.im.oidb.cmd0xaef.Oidb_0xaef.ReqBody;
import tencent.im.oidb.cmd0xaef.Oidb_0xaef.SearchDocReq;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class GroupTeamWorkHandlerImpl
  extends BusinessHandler
  implements IGroupTeamWorkHandler
{
  public static String TAG = "GroupTeamWorkHandlerImpl";
  private AppInterface app;
  
  public GroupTeamWorkHandlerImpl(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.app = paramAppInterface;
  }
  
  public static void buildPadInfo(GPadInfo paramGPadInfo, group_online_docs.DocInfo paramDocInfo, long paramLong)
  {
    if ((paramGPadInfo != null) && (paramDocInfo != null)) {}
    for (;;)
    {
      try
      {
        if ((paramDocInfo.doc_meta_data != null) && (paramDocInfo.doc_meta_data.doc_id != null))
        {
          online_docs.DocMetaData localDocMetaData = paramDocInfo.doc_meta_data;
          localObject = localDocMetaData.doc_id;
          paramGPadInfo.domainId = ((online_docs.DocId)localObject).domain_id.get();
          if (!((online_docs.DocId)localObject).pad_id.has()) {
            break label432;
          }
          localObject = ((online_docs.DocId)localObject).pad_id.get().toStringUtf8();
          paramGPadInfo.padId = ((String)localObject);
          if (!localDocMetaData.title.has()) {
            break label439;
          }
          localObject = localDocMetaData.title.get().toStringUtf8();
          paramGPadInfo.title = ((String)localObject);
          paramGPadInfo.creatorUin = localDocMetaData.creator_uin.get();
          paramGPadInfo.createTime = localDocMetaData.create_ts.get();
          paramGPadInfo.lastEditorUin = localDocMetaData.last_modify_uin.get();
          paramGPadInfo.lastEditTime = (localDocMetaData.last_modify_ts.get() * 1000L);
          paramGPadInfo.ownerUin = localDocMetaData.owner_uin.get();
          int i = localDocMetaData.doc_type.get();
          bool = true;
          if (i == 0) {
            paramGPadInfo.type = 1;
          } else if (localDocMetaData.doc_type.get() == 1) {
            paramGPadInfo.type = 2;
          } else if (localDocMetaData.doc_type.get() == 2) {
            paramGPadInfo.type = 3;
          }
          paramGPadInfo.creatorUid = localDocMetaData.creator_uid.get();
          paramGPadInfo.lastModifyUid = localDocMetaData.last_modify_uid.get();
          paramGPadInfo.owneruid = localDocMetaData.owner_uid.get();
          if (!paramDocInfo.creator_nick.has()) {
            break label446;
          }
          localObject = paramDocInfo.creator_nick.get();
          paramGPadInfo.creatorCard = ((String)localObject);
          if (!paramDocInfo.owner_nick.has()) {
            break label453;
          }
          localObject = paramDocInfo.owner_nick.get();
          paramGPadInfo.ownerCard = ((String)localObject);
          if (!paramDocInfo.last_modify_nick.has()) {
            break label460;
          }
          localObject = paramDocInfo.last_modify_nick.get();
          paramGPadInfo.lastModifyCard = ((String)localObject);
          if (paramDocInfo.top.get() != 1) {
            break label467;
          }
          paramGPadInfo.pinedFlag = bool;
          if (!paramDocInfo.doc_url.has()) {
            break label473;
          }
          paramDocInfo = paramDocInfo.doc_url.get();
          paramGPadInfo.pad_url = paramDocInfo;
          paramGPadInfo.groupCode = paramLong;
        }
      }
      finally {}
      return;
      label432:
      Object localObject = "";
      continue;
      label439:
      localObject = "";
      continue;
      label446:
      localObject = "";
      continue;
      label453:
      localObject = "";
      continue;
      label460:
      localObject = "";
      continue;
      label467:
      boolean bool = false;
      continue;
      label473:
      paramDocInfo = "";
    }
  }
  
  public static void buildPadTemplateInfo(GroupPadTemplateInfo paramGroupPadTemplateInfo, Oidb_0xaee.Template paramTemplate)
  {
    if ((paramGroupPadTemplateInfo != null) && (paramTemplate != null)) {}
    try
    {
      paramGroupPadTemplateInfo.templateID = paramTemplate.template_id.get();
      paramGroupPadTemplateInfo.templateName = paramTemplate.template_name.get();
      paramGroupPadTemplateInfo.templateType = paramTemplate.group_type.get();
      paramGroupPadTemplateInfo.mobThumbUrl = paramTemplate.mob_thumb_url.get();
      paramGroupPadTemplateInfo.mobPrevUrl = paramTemplate.mob_prev_url.get();
      paramGroupPadTemplateInfo.webThumUrl = paramTemplate.web_thumb_url.get();
      paramGroupPadTemplateInfo.webPrevUrl = paramTemplate.web_prev_url.get();
      paramGroupPadTemplateInfo.templateUrl = paramTemplate.template_url.get();
      paramGroupPadTemplateInfo.docOrSheetType = paramTemplate.doc_type.get();
      paramGroupPadTemplateInfo.groupCode = paramTemplate.group_code.get();
    }
    finally {}
  }
  
  public static String getClassName()
  {
    return GroupTeamWorkHandlerImpl.class.getName();
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xae9_1");
      this.allowCmdSet.add("OidbSvc.0xaef_1");
      this.allowCmdSet.add("OidbSvc.0xaee");
      this.allowCmdSet.add("OidbSvc.0xaea_1");
      this.allowCmdSet.add("OidbSvc.0xaf3_1");
      this.allowCmdSet.add("OidbSvc.0xaf3_2");
      this.allowCmdSet.add("OidbSvc.0xae9_2");
    }
    return this.allowCmdSet;
  }
  
  public void getGroupPadTemplateList(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    Object localObject2 = new Oidb_0xaee.ReqBody();
    ((Oidb_0xaee.ReqBody)localObject2).group_code.set(paramLong);
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2798);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0xaee.ReqBody)localObject2).toByteArray()));
    localObject2 = createToServiceMsg("OidbSvc.0xaee");
    ((ToServiceMsg)localObject2).addAttribute("key_group_code", Long.valueOf(paramLong));
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    super.sendPbReq((ToServiceMsg)localObject2);
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getGroupPadTemplateList! groupCode = ");
      ((StringBuilder)localObject2).append(paramLong);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void getGroupTeamWorkList(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramLong == 0L) {
      return;
    }
    Object localObject2 = new Oidb_0xae9.GetListReq();
    ((Oidb_0xae9.GetListReq)localObject2).group_code.set(paramLong);
    ((Oidb_0xae9.GetListReq)localObject2).start.set(paramInt1);
    ((Oidb_0xae9.GetListReq)localObject2).limit.set(paramInt2);
    Object localObject1 = new Oidb_0xae9.ReqBody();
    ((Oidb_0xae9.ReqBody)localObject1).get_list_req.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2793);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0xae9.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0xae9_1");
    ((ToServiceMsg)localObject1).addAttribute("key_group_code", Long.valueOf(paramLong));
    ((ToServiceMsg)localObject1).addAttribute("key_req_start", Integer.valueOf(paramInt1));
    ((ToServiceMsg)localObject1).addAttribute("key_req_limit", Integer.valueOf(paramInt2));
    ((ToServiceMsg)localObject1).addAttribute("key_type_operation", Integer.valueOf(paramInt3));
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    super.sendPbReq((ToServiceMsg)localObject1);
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getGroupTeamWorkList group code = ");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append(" start = ");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(" count = ");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void getGroupTeamWorkListLastAddTime(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAddGroupTeamWorkTime group code = ");
      localStringBuilder.append(paramLong);
      QLog.i(str, 2, localStringBuilder.toString());
    }
  }
  
  public void handleDeleteTeamWorkFile(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {
      return;
    }
    boolean bool = paramFromServiceMsg.isSuccess();
    int i = -1;
    String str = (String)paramToServiceMsg.getAttribute("key_type_pad_url");
    ((Long)paramToServiceMsg.getAttribute("key_group_code")).longValue();
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    int j = i;
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      j = i;
      if (paramToServiceMsg.uint32_result.has())
      {
        j = i;
        i = paramToServiceMsg.uint32_result.get();
        j = i;
        if (paramToServiceMsg.str_error_msg.has())
        {
          j = i;
          paramToServiceMsg = paramToServiceMsg.str_error_msg.get();
        }
        else
        {
          paramToServiceMsg = "";
        }
        j = i;
        paramFromServiceMsg = paramToServiceMsg;
        if (i != 0) {
          break label274;
        }
        try
        {
          paramObject = ((GroupTeamWorkManager)((IManagerFactoryService)this.app.getRuntimeService(IManagerFactoryService.class, "")).getManager(GroupTeamWorkManager.class)).e();
          j = i;
          paramFromServiceMsg = paramToServiceMsg;
          if (TextUtils.isEmpty(str)) {
            break label274;
          }
          j = i;
          paramFromServiceMsg = paramToServiceMsg;
          if (!paramObject.containsKey(str)) {
            break label274;
          }
          paramObject.remove(((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getNoParamUrl(str));
          j = i;
          paramFromServiceMsg = paramToServiceMsg;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          break label248;
        }
      }
      else
      {
        paramFromServiceMsg = "";
        j = i;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      paramToServiceMsg = "";
      i = j;
      label248:
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, " handleDeleteTeamWorkFile parse oidb_sso.OIDBSSOPkg failed.");
      }
      paramFromServiceMsg.printStackTrace();
      paramFromServiceMsg = paramToServiceMsg;
      j = i;
    }
    label274:
    notifyUI(4, bool, new Object[] { Integer.valueOf(j), paramFromServiceMsg });
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = TAG;
      paramObject = new StringBuilder();
      paramObject.append(" handleDeleteTeamWorkFile issuccess = ");
      paramObject.append(bool);
      paramObject.append(" retCode = ");
      paramObject.append(j);
      paramObject.append(" error msg = ");
      paramObject.append(paramFromServiceMsg);
      QLog.i(paramToServiceMsg, 2, paramObject.toString());
    }
  }
  
  /* Error */
  public void handleGetGroupPadTemplateList(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: invokevirtual 436	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   9: istore 7
    //   11: iconst_m1
    //   12: istore 6
    //   14: new 530	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 531	java/util/ArrayList:<init>	()V
    //   21: astore 9
    //   23: new 296	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   26: dup
    //   27: invokespecial 297	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   30: astore_1
    //   31: aload_0
    //   32: getfield 21	com/tencent/mobileqq/teamwork/api/impl/GroupTeamWorkHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   35: astore_2
    //   36: ldc 185
    //   38: astore 8
    //   40: aload_2
    //   41: ldc_w 459
    //   44: ldc 185
    //   46: invokevirtual 465	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   49: checkcast 459	com/tencent/mobileqq/troop/managerfactory/api/IManagerFactoryService
    //   52: ldc_w 467
    //   55: invokeinterface 471 2 0
    //   60: checkcast 467	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkManager
    //   63: astore 10
    //   65: aload 8
    //   67: astore_2
    //   68: iload 6
    //   70: istore 4
    //   72: aload_1
    //   73: aload_3
    //   74: checkcast 449	[B
    //   77: checkcast 449	[B
    //   80: invokevirtual 453	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   83: checkcast 296	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   86: astore 11
    //   88: aload 8
    //   90: astore_2
    //   91: iload 6
    //   93: istore 4
    //   95: aload 8
    //   97: astore_3
    //   98: iload 6
    //   100: istore 5
    //   102: aload 11
    //   104: getfield 306	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   107: invokevirtual 454	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   110: ifeq +449 -> 559
    //   113: aload 8
    //   115: astore_2
    //   116: iload 6
    //   118: istore 4
    //   120: aload 11
    //   122: getfield 306	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   125: invokevirtual 95	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   128: istore 6
    //   130: aload 8
    //   132: astore_1
    //   133: aload 8
    //   135: astore_2
    //   136: iload 6
    //   138: istore 4
    //   140: aload 11
    //   142: getfield 457	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   145: invokevirtual 150	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   148: ifeq +19 -> 167
    //   151: aload 8
    //   153: astore_2
    //   154: iload 6
    //   156: istore 4
    //   158: aload 11
    //   160: getfield 457	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   163: invokevirtual 152	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   166: astore_1
    //   167: aload_1
    //   168: astore_3
    //   169: iload 6
    //   171: istore 5
    //   173: iload 6
    //   175: ifne +384 -> 559
    //   178: aload_1
    //   179: astore_2
    //   180: iload 6
    //   182: istore 4
    //   184: new 533	tencent/im/oidb/cmd0xaee/Oidb_0xaee$RspBody
    //   187: dup
    //   188: invokespecial 534	tencent/im/oidb/cmd0xaee/Oidb_0xaee$RspBody:<init>	()V
    //   191: astore_3
    //   192: aload_1
    //   193: astore_2
    //   194: iload 6
    //   196: istore 4
    //   198: aload_3
    //   199: aload 11
    //   201: getfield 312	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   204: invokevirtual 66	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   207: invokevirtual 535	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   210: invokevirtual 536	tencent/im/oidb/cmd0xaee/Oidb_0xaee$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   213: pop
    //   214: aload_1
    //   215: astore_2
    //   216: iload 6
    //   218: istore 4
    //   220: aload_3
    //   221: getfield 540	tencent/im/oidb/cmd0xaee/Oidb_0xaee$RspBody:list_rsp	Ltencent/im/oidb/cmd0xaee/Oidb_0xaee$ListRsp;
    //   224: getfield 546	tencent/im/oidb/cmd0xaee/Oidb_0xaee$ListRsp:rpt_template	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   227: invokevirtual 551	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   230: astore 8
    //   232: aload_1
    //   233: astore_3
    //   234: iload 6
    //   236: istore 5
    //   238: aload 8
    //   240: ifnull +319 -> 559
    //   243: aload_1
    //   244: astore_2
    //   245: iload 6
    //   247: istore 4
    //   249: aload_1
    //   250: astore_3
    //   251: iload 6
    //   253: istore 5
    //   255: aload 8
    //   257: invokeinterface 556 1 0
    //   262: ifle +297 -> 559
    //   265: iconst_0
    //   266: istore 5
    //   268: aload_1
    //   269: astore_2
    //   270: iload 6
    //   272: istore 4
    //   274: iload 5
    //   276: aload 8
    //   278: invokeinterface 556 1 0
    //   283: if_icmpge +143 -> 426
    //   286: aload_1
    //   287: astore_2
    //   288: iload 6
    //   290: istore 4
    //   292: new 194	com/tencent/mobileqq/teamworkforgroup/GroupPadTemplateInfo
    //   295: dup
    //   296: invokespecial 557	com/tencent/mobileqq/teamworkforgroup/GroupPadTemplateInfo:<init>	()V
    //   299: astore_3
    //   300: aload_1
    //   301: astore_2
    //   302: iload 6
    //   304: istore 4
    //   306: aload_3
    //   307: aload 8
    //   309: iload 5
    //   311: invokeinterface 560 2 0
    //   316: checkcast 189	tencent/im/oidb/cmd0xaee/Oidb_0xaee$Template
    //   319: invokestatic 562	com/tencent/mobileqq/teamwork/api/impl/GroupTeamWorkHandlerImpl:buildPadTemplateInfo	(Lcom/tencent/mobileqq/teamworkforgroup/GroupPadTemplateInfo;Ltencent/im/oidb/cmd0xaee/Oidb_0xaee$Template;)V
    //   322: aload_1
    //   323: astore_2
    //   324: iload 6
    //   326: istore 4
    //   328: aload 9
    //   330: aload_3
    //   331: invokeinterface 563 2 0
    //   336: pop
    //   337: aload_1
    //   338: astore_2
    //   339: iload 6
    //   341: istore 4
    //   343: invokestatic 360	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   346: ifeq +242 -> 588
    //   349: aload_1
    //   350: astore_2
    //   351: iload 6
    //   353: istore 4
    //   355: getstatic 362	com/tencent/mobileqq/teamwork/api/impl/GroupTeamWorkHandlerImpl:TAG	Ljava/lang/String;
    //   358: astore 11
    //   360: aload_1
    //   361: astore_2
    //   362: iload 6
    //   364: istore 4
    //   366: new 364	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 365	java/lang/StringBuilder:<init>	()V
    //   373: astore 12
    //   375: aload_1
    //   376: astore_2
    //   377: iload 6
    //   379: istore 4
    //   381: aload 12
    //   383: ldc_w 565
    //   386: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload_1
    //   391: astore_2
    //   392: iload 6
    //   394: istore 4
    //   396: aload 12
    //   398: aload_3
    //   399: invokevirtual 566	java/lang/Object:toString	()Ljava/lang/String;
    //   402: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload_1
    //   407: astore_2
    //   408: iload 6
    //   410: istore 4
    //   412: aload 11
    //   414: iconst_2
    //   415: aload 12
    //   417: invokevirtual 377	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokestatic 381	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   423: goto +165 -> 588
    //   426: aload_1
    //   427: astore_2
    //   428: iload 6
    //   430: istore 4
    //   432: aload 10
    //   434: aload 9
    //   436: invokevirtual 570	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkManager:a	(Ljava/util/List;)V
    //   439: aload_1
    //   440: astore_3
    //   441: iload 6
    //   443: istore 5
    //   445: goto +114 -> 559
    //   448: astore_3
    //   449: aload_1
    //   450: astore_2
    //   451: iload 6
    //   453: istore 4
    //   455: getstatic 362	com/tencent/mobileqq/teamwork/api/impl/GroupTeamWorkHandlerImpl:TAG	Ljava/lang/String;
    //   458: astore 8
    //   460: aload_1
    //   461: astore_2
    //   462: iload 6
    //   464: istore 4
    //   466: new 364	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 365	java/lang/StringBuilder:<init>	()V
    //   473: astore 10
    //   475: aload_1
    //   476: astore_2
    //   477: iload 6
    //   479: istore 4
    //   481: aload 10
    //   483: ldc_w 572
    //   486: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: aload_1
    //   491: astore_2
    //   492: iload 6
    //   494: istore 4
    //   496: aload 10
    //   498: aload_3
    //   499: invokevirtual 573	java/lang/Exception:toString	()Ljava/lang/String;
    //   502: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload_1
    //   507: astore_2
    //   508: iload 6
    //   510: istore 4
    //   512: aload 8
    //   514: iconst_1
    //   515: aload 10
    //   517: invokevirtual 377	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokestatic 575	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   523: aload_1
    //   524: astore_3
    //   525: iload 6
    //   527: istore 5
    //   529: goto +30 -> 559
    //   532: astore_1
    //   533: invokestatic 360	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   536: ifeq +13 -> 549
    //   539: getstatic 362	com/tencent/mobileqq/teamwork/api/impl/GroupTeamWorkHandlerImpl:TAG	Ljava/lang/String;
    //   542: iconst_2
    //   543: ldc_w 577
    //   546: invokestatic 507	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   549: aload_1
    //   550: invokevirtual 510	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   553: iload 4
    //   555: istore 5
    //   557: aload_2
    //   558: astore_3
    //   559: aload_0
    //   560: iconst_3
    //   561: iload 7
    //   563: iconst_3
    //   564: anewarray 512	java/lang/Object
    //   567: dup
    //   568: iconst_0
    //   569: iload 5
    //   571: invokestatic 411	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   574: aastore
    //   575: dup
    //   576: iconst_1
    //   577: aload_3
    //   578: aastore
    //   579: dup
    //   580: iconst_2
    //   581: aload 9
    //   583: aastore
    //   584: invokevirtual 516	com/tencent/mobileqq/teamwork/api/impl/GroupTeamWorkHandlerImpl:notifyUI	(IZLjava/lang/Object;)V
    //   587: return
    //   588: iload 5
    //   590: iconst_1
    //   591: iadd
    //   592: istore 5
    //   594: goto -326 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	597	0	this	GroupTeamWorkHandlerImpl
    //   0	597	1	paramToServiceMsg	ToServiceMsg
    //   0	597	2	paramFromServiceMsg	FromServiceMsg
    //   0	597	3	paramObject	Object
    //   70	484	4	i	int
    //   100	493	5	j	int
    //   12	514	6	k	int
    //   9	553	7	bool	boolean
    //   38	475	8	localObject1	Object
    //   21	561	9	localArrayList	ArrayList
    //   63	453	10	localObject2	Object
    //   86	327	11	localObject3	Object
    //   373	43	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   198	214	448	java/lang/Exception
    //   220	232	448	java/lang/Exception
    //   255	265	448	java/lang/Exception
    //   274	286	448	java/lang/Exception
    //   292	300	448	java/lang/Exception
    //   306	322	448	java/lang/Exception
    //   328	337	448	java/lang/Exception
    //   343	349	448	java/lang/Exception
    //   355	360	448	java/lang/Exception
    //   366	375	448	java/lang/Exception
    //   381	390	448	java/lang/Exception
    //   396	406	448	java/lang/Exception
    //   412	423	448	java/lang/Exception
    //   432	439	448	java/lang/Exception
    //   72	88	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   102	113	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   120	130	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   140	151	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   158	167	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   184	192	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   198	214	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   220	232	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   255	265	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   274	286	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   292	300	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   306	322	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   328	337	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   343	349	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   355	360	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   366	375	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   381	390	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   396	406	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   412	423	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   432	439	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   455	460	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   466	475	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   481	490	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   496	506	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   512	523	532	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void handleGetGroupTeamWorkList(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {
      return;
    }
    boolean bool = paramFromServiceMsg.isSuccess();
    int n = ((Integer)paramToServiceMsg.getAttribute("key_type_operation")).intValue();
    ((Integer)paramToServiceMsg.getAttribute("key_req_start")).intValue();
    long l = ((Long)paramToServiceMsg.getAttribute("key_group_code")).longValue();
    int i = -1;
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new oidb_sso.OIDBSSOPkg();
    paramToServiceMsg = this.app;
    Object localObject1 = "";
    GroupTeamWorkManager localGroupTeamWorkManager = (GroupTeamWorkManager)((IManagerFactoryService)paramToServiceMsg.getRuntimeService(IManagerFactoryService.class, "")).getManager(GroupTeamWorkManager.class);
    int j = i;
    paramFromServiceMsg = (FromServiceMsg)localObject1;
    for (;;)
    {
      int m;
      try
      {
        ((oidb_sso.OIDBSSOPkg)localObject2).mergeFrom((byte[])paramObject);
        int k = i;
        paramObject = localObject1;
        j = i;
        paramFromServiceMsg = (FromServiceMsg)localObject1;
        if (((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.has())
        {
          j = i;
          paramFromServiceMsg = (FromServiceMsg)localObject1;
          i = ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.get();
          paramToServiceMsg = (ToServiceMsg)localObject1;
          j = i;
          paramFromServiceMsg = (FromServiceMsg)localObject1;
          if (((oidb_sso.OIDBSSOPkg)localObject2).str_error_msg.has())
          {
            j = i;
            paramFromServiceMsg = (FromServiceMsg)localObject1;
            paramToServiceMsg = ((oidb_sso.OIDBSSOPkg)localObject2).str_error_msg.get();
          }
          k = i;
          paramObject = paramToServiceMsg;
          if (i == 0)
          {
            j = i;
            paramFromServiceMsg = paramToServiceMsg;
            paramObject = new Oidb_0xae9.RspBody();
            j = i;
            paramFromServiceMsg = paramToServiceMsg;
            try
            {
              paramObject.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.get().toByteArray());
              j = i;
              paramFromServiceMsg = paramToServiceMsg;
              paramObject = (Oidb_0xae9.GetListRsp)paramObject.get_list_rsp.get();
              if (paramObject == null)
              {
                j = i;
                paramFromServiceMsg = paramToServiceMsg;
                if (!QLog.isColorLevel()) {
                  break label818;
                }
                j = i;
                paramFromServiceMsg = paramToServiceMsg;
                QLog.i(TAG, 2, " handleGetGroupTeamWorkList getListRsp null: ");
                return;
              }
              j = i;
              paramFromServiceMsg = paramToServiceMsg;
              localObject1 = paramObject.doc_list.get();
              j = i;
              paramFromServiceMsg = paramToServiceMsg;
              k = paramObject.next.get();
              m = i;
              paramObject = paramToServiceMsg;
              j = k;
              if (localObject1 == null) {
                continue;
              }
              m = i;
              paramObject = paramToServiceMsg;
              j = k;
              try
              {
                if (((List)localObject1).size() <= 0) {
                  continue;
                }
                j = 0;
                if (j >= ((List)localObject1).size()) {
                  break label828;
                }
                paramFromServiceMsg = new GPadInfo();
                buildPadInfo(paramFromServiceMsg, (group_online_docs.DocInfo)((List)localObject1).get(j), l);
                localArrayList.add(paramFromServiceMsg);
                if (!QLog.isColorLevel()) {
                  break label819;
                }
                paramObject = TAG;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(" handleGetGroupTeamWorkList localPadInfo: ");
                ((StringBuilder)localObject2).append(paramFromServiceMsg.toString());
                QLog.i(paramObject, 2, ((StringBuilder)localObject2).toString());
              }
              catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
              {
                j = i;
                i = k;
                continue;
              }
              catch (Exception paramFromServiceMsg)
              {
                j = k;
                continue;
              }
              m = i;
              paramObject = paramToServiceMsg;
              j = k;
              if (n != 3) {
                continue;
              }
              localGroupTeamWorkManager.a(1, localArrayList);
              m = i;
              paramObject = paramToServiceMsg;
              j = k;
            }
            catch (Exception paramFromServiceMsg)
            {
              j = 0;
            }
            localGroupTeamWorkManager.a(2, localArrayList);
            m = i;
            paramObject = paramToServiceMsg;
            j = k;
            continue;
            try
            {
              paramObject = TAG;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(" handleGetGroupTeamWorkList exception: ");
              ((StringBuilder)localObject1).append(paramFromServiceMsg.toString());
              QLog.e(paramObject, 1, ((StringBuilder)localObject1).toString());
              m = i;
              paramObject = paramToServiceMsg;
            }
            catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
            {
              k = j;
              j = i;
              i = k;
              continue;
            }
          }
        }
        j = 0;
        m = k;
        paramToServiceMsg = paramObject;
        i = j;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        i = 0;
        paramToServiceMsg = paramFromServiceMsg;
        paramFromServiceMsg = paramObject;
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, " handleGetGroupTeamWorkList parse oidb_sso.OIDBSSOPkg failed.");
        }
        paramFromServiceMsg.printStackTrace();
        m = j;
      }
      notifyUI(1, bool, new Object[] { Integer.valueOf(m), paramToServiceMsg, localArrayList, Integer.valueOf(i), Integer.valueOf(n) });
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = TAG;
        paramObject = new StringBuilder();
        paramObject.append(" handleGetGroupTeamWorkList issuccess = ");
        paramObject.append(bool);
        paramObject.append(" retCode = ");
        paramObject.append(m);
        paramObject.append(" error msg = ");
        paramObject.append(paramToServiceMsg);
        paramObject.append(" next =");
        paramObject.append(i);
        paramObject.append(" type operation = ");
        paramObject.append(n);
        QLog.i(paramFromServiceMsg, 2, paramObject.toString());
      }
      return;
      label818:
      return;
      label819:
      j += 1;
      continue;
      label828:
      if (n != 1) {
        if (n != 2) {}
      }
    }
  }
  
  /* Error */
  public void handleGetGroupTeamWorkListLastAddTime(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: invokevirtual 436	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   9: istore 10
    //   11: iconst_m1
    //   12: istore 4
    //   14: new 296	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   17: dup
    //   18: invokespecial 297	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   21: astore_2
    //   22: aload_1
    //   23: ldc_w 329
    //   26: invokevirtual 442	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   29: checkcast 331	java/lang/Long
    //   32: invokevirtual 447	java/lang/Long:longValue	()J
    //   35: lstore 11
    //   37: iload 4
    //   39: istore 5
    //   41: aload_2
    //   42: aload_3
    //   43: checkcast 449	[B
    //   46: checkcast 449	[B
    //   49: invokevirtual 453	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   52: checkcast 296	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   55: astore_3
    //   56: iload 4
    //   58: istore 5
    //   60: aload_3
    //   61: getfield 306	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   64: invokevirtual 454	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   67: ifeq +319 -> 386
    //   70: iload 4
    //   72: istore 5
    //   74: aload_3
    //   75: getfield 306	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   78: invokevirtual 95	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   81: istore 4
    //   83: iload 4
    //   85: istore 5
    //   87: aload_3
    //   88: getfield 457	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   91: invokevirtual 150	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   94: ifeq +18 -> 112
    //   97: iload 4
    //   99: istore 5
    //   101: aload_3
    //   102: getfield 457	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   105: invokevirtual 152	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   108: astore_1
    //   109: goto +6 -> 115
    //   112: ldc 185
    //   114: astore_1
    //   115: iload 4
    //   117: istore 5
    //   119: aload_1
    //   120: astore_2
    //   121: iload 4
    //   123: ifne +170 -> 293
    //   126: new 583	tencent/im/oidb/cmd0xae9/Oidb_0xae9$RspBody
    //   129: dup
    //   130: invokespecial 584	tencent/im/oidb/cmd0xae9/Oidb_0xae9$RspBody:<init>	()V
    //   133: astore_2
    //   134: aload_2
    //   135: aload_3
    //   136: getfield 312	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   139: invokevirtual 66	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   142: invokevirtual 535	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   145: invokevirtual 585	tencent/im/oidb/cmd0xae9/Oidb_0xae9$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   148: pop
    //   149: aload_2
    //   150: getfield 626	tencent/im/oidb/cmd0xae9/Oidb_0xae9$RspBody:get_add_time_rsp	Ltencent/im/oidb/cmd0xae9/Oidb_0xae9$GetAddTimeRsp;
    //   153: invokevirtual 629	tencent/im/oidb/cmd0xae9/Oidb_0xae9$GetAddTimeRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   156: checkcast 628	tencent/im/oidb/cmd0xae9/Oidb_0xae9$GetAddTimeRsp
    //   159: getfield 632	tencent/im/oidb/cmd0xae9/Oidb_0xae9$GetAddTimeRsp:timestamp	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   162: invokevirtual 47	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   165: lstore 13
    //   167: aload_0
    //   168: getfield 21	com/tencent/mobileqq/teamwork/api/impl/GroupTeamWorkHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   171: invokevirtual 636	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   174: lload 11
    //   176: invokestatic 639	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   179: ldc_w 641
    //   182: ldc 185
    //   184: invokestatic 644	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkManager:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   187: lload 13
    //   189: invokestatic 639	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   192: invokevirtual 647	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   195: istore 6
    //   197: iload 4
    //   199: istore 5
    //   201: aload_1
    //   202: astore_2
    //   203: iload 6
    //   205: ifne +88 -> 293
    //   208: iconst_1
    //   209: istore 8
    //   211: iconst_1
    //   212: istore 9
    //   214: iconst_1
    //   215: istore 6
    //   217: iload 8
    //   219: istore 7
    //   221: aload_0
    //   222: getfield 21	com/tencent/mobileqq/teamwork/api/impl/GroupTeamWorkHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   225: invokevirtual 636	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   228: lload 11
    //   230: invokestatic 639	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   233: ldc_w 641
    //   236: lload 13
    //   238: invokestatic 639	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   241: invokestatic 651	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkManager:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   244: iload 8
    //   246: istore 7
    //   248: ldc_w 653
    //   251: invokestatic 494	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   254: checkcast 653	com/tencent/mobileqq/teamwork/api/IGetExternalInterface
    //   257: aload_0
    //   258: getfield 21	com/tencent/mobileqq/teamwork/api/impl/GroupTeamWorkHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   261: aload_0
    //   262: getfield 21	com/tencent/mobileqq/teamwork/api/impl/GroupTeamWorkHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   265: invokevirtual 636	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   268: lload 11
    //   270: invokestatic 639	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   273: ldc_w 655
    //   276: iconst_1
    //   277: invokeinterface 659 6 0
    //   282: iload 9
    //   284: istore 6
    //   286: goto +141 -> 427
    //   289: astore_2
    //   290: goto +19 -> 309
    //   293: iconst_0
    //   294: istore 6
    //   296: iload 5
    //   298: istore 4
    //   300: aload_2
    //   301: astore_1
    //   302: goto +125 -> 427
    //   305: astore_2
    //   306: iconst_0
    //   307: istore 6
    //   309: iload 6
    //   311: istore 7
    //   313: getstatic 362	com/tencent/mobileqq/teamwork/api/impl/GroupTeamWorkHandlerImpl:TAG	Ljava/lang/String;
    //   316: astore_3
    //   317: iload 6
    //   319: istore 7
    //   321: new 364	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 365	java/lang/StringBuilder:<init>	()V
    //   328: astore 15
    //   330: iload 6
    //   332: istore 7
    //   334: aload 15
    //   336: ldc_w 572
    //   339: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: iload 6
    //   345: istore 7
    //   347: aload 15
    //   349: aload_2
    //   350: invokevirtual 573	java/lang/Exception:toString	()Ljava/lang/String;
    //   353: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: iload 6
    //   359: istore 7
    //   361: aload_3
    //   362: iconst_1
    //   363: aload 15
    //   365: invokevirtual 377	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 575	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   371: goto +56 -> 427
    //   374: astore_2
    //   375: iload 7
    //   377: istore 6
    //   379: goto +28 -> 407
    //   382: astore_2
    //   383: goto +21 -> 404
    //   386: ldc 185
    //   388: astore_2
    //   389: iload 4
    //   391: istore 5
    //   393: goto -100 -> 293
    //   396: astore_2
    //   397: ldc 185
    //   399: astore_1
    //   400: iload 5
    //   402: istore 4
    //   404: iconst_0
    //   405: istore 6
    //   407: invokestatic 360	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   410: ifeq +13 -> 423
    //   413: getstatic 362	com/tencent/mobileqq/teamwork/api/impl/GroupTeamWorkHandlerImpl:TAG	Ljava/lang/String;
    //   416: iconst_2
    //   417: ldc_w 577
    //   420: invokestatic 507	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   423: aload_2
    //   424: invokevirtual 510	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   427: aload_0
    //   428: bipush 7
    //   430: iload 10
    //   432: iconst_3
    //   433: anewarray 512	java/lang/Object
    //   436: dup
    //   437: iconst_0
    //   438: iload 4
    //   440: invokestatic 411	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   443: aastore
    //   444: dup
    //   445: iconst_1
    //   446: aload_1
    //   447: aastore
    //   448: dup
    //   449: iconst_2
    //   450: iload 6
    //   452: invokestatic 664	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   455: aastore
    //   456: invokevirtual 516	com/tencent/mobileqq/teamwork/api/impl/GroupTeamWorkHandlerImpl:notifyUI	(IZLjava/lang/Object;)V
    //   459: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	460	0	this	GroupTeamWorkHandlerImpl
    //   0	460	1	paramToServiceMsg	ToServiceMsg
    //   0	460	2	paramFromServiceMsg	FromServiceMsg
    //   0	460	3	paramObject	Object
    //   12	427	4	i	int
    //   39	362	5	j	int
    //   195	256	6	bool1	boolean
    //   219	157	7	bool2	boolean
    //   209	36	8	bool3	boolean
    //   212	71	9	bool4	boolean
    //   9	422	10	bool5	boolean
    //   35	234	11	l1	long
    //   165	72	13	l2	long
    //   328	36	15	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   221	244	289	java/lang/Exception
    //   248	282	289	java/lang/Exception
    //   134	197	305	java/lang/Exception
    //   221	244	374	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   248	282	374	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   313	317	374	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   321	330	374	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   334	343	374	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   347	357	374	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   361	371	374	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   126	134	382	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   134	197	382	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   41	56	396	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   60	70	396	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   74	83	396	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   87	97	396	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   101	109	396	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  /* Error */
  public void handleSearchForGroupTeamWorkList(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: ldc 185
    //   2: astore 12
    //   4: aload_2
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aload_2
    //   10: invokevirtual 436	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: istore 9
    //   15: aload_1
    //   16: ldc_w 406
    //   19: invokevirtual 442	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   22: checkcast 408	java/lang/Integer
    //   25: invokevirtual 581	java/lang/Integer:intValue	()I
    //   28: pop
    //   29: iconst_m1
    //   30: istore 4
    //   32: aload_1
    //   33: ldc_w 329
    //   36: invokevirtual 442	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   39: checkcast 331	java/lang/Long
    //   42: invokevirtual 447	java/lang/Long:longValue	()J
    //   45: lstore 10
    //   47: new 530	java/util/ArrayList
    //   50: dup
    //   51: invokespecial 531	java/util/ArrayList:<init>	()V
    //   54: astore 13
    //   56: new 296	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   59: dup
    //   60: invokespecial 297	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   63: astore_1
    //   64: aload 12
    //   66: astore_2
    //   67: iload 4
    //   69: istore 6
    //   71: aload_1
    //   72: aload_3
    //   73: checkcast 449	[B
    //   76: checkcast 449	[B
    //   79: invokevirtual 453	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   82: checkcast 296	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   85: astore 14
    //   87: aload 12
    //   89: astore_3
    //   90: iload 4
    //   92: istore 5
    //   94: aload 12
    //   96: astore_2
    //   97: iload 4
    //   99: istore 6
    //   101: aload 14
    //   103: getfield 306	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   106: invokevirtual 454	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   109: ifeq +502 -> 611
    //   112: aload 12
    //   114: astore_2
    //   115: iload 4
    //   117: istore 6
    //   119: aload 14
    //   121: getfield 306	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   124: invokevirtual 95	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   127: istore 4
    //   129: aload 12
    //   131: astore_1
    //   132: aload 12
    //   134: astore_2
    //   135: iload 4
    //   137: istore 6
    //   139: aload 14
    //   141: getfield 457	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   144: invokevirtual 150	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   147: ifeq +19 -> 166
    //   150: aload 12
    //   152: astore_2
    //   153: iload 4
    //   155: istore 6
    //   157: aload 14
    //   159: getfield 457	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   162: invokevirtual 152	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   165: astore_1
    //   166: aload_1
    //   167: astore_3
    //   168: iload 4
    //   170: istore 5
    //   172: iload 4
    //   174: ifne +437 -> 611
    //   177: aload_1
    //   178: astore_2
    //   179: iload 4
    //   181: istore 6
    //   183: new 667	tencent/im/oidb/cmd0xaef/Oidb_0xaef$RspBody
    //   186: dup
    //   187: invokespecial 668	tencent/im/oidb/cmd0xaef/Oidb_0xaef$RspBody:<init>	()V
    //   190: astore_3
    //   191: aload_1
    //   192: astore_2
    //   193: iload 4
    //   195: istore 6
    //   197: aload_3
    //   198: aload 14
    //   200: getfield 312	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   203: invokevirtual 66	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   206: invokevirtual 535	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   209: invokevirtual 669	tencent/im/oidb/cmd0xaef/Oidb_0xaef$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   212: pop
    //   213: aload_1
    //   214: astore_2
    //   215: iload 4
    //   217: istore 6
    //   219: aload_3
    //   220: getfield 673	tencent/im/oidb/cmd0xaef/Oidb_0xaef$RspBody:search_doc_rsp	Ltencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchDocRsp;
    //   223: invokevirtual 676	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchDocRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   226: checkcast 675	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchDocRsp
    //   229: astore_3
    //   230: aload_3
    //   231: ifnonnull +32 -> 263
    //   234: aload_1
    //   235: astore_2
    //   236: iload 4
    //   238: istore 6
    //   240: invokestatic 360	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   243: ifeq +568 -> 811
    //   246: aload_1
    //   247: astore_2
    //   248: iload 4
    //   250: istore 6
    //   252: getstatic 362	com/tencent/mobileqq/teamwork/api/impl/GroupTeamWorkHandlerImpl:TAG	Ljava/lang/String;
    //   255: iconst_2
    //   256: ldc_w 678
    //   259: invokestatic 381	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: return
    //   263: aload_1
    //   264: astore_2
    //   265: iload 4
    //   267: istore 6
    //   269: aload_3
    //   270: getfield 679	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchDocRsp:next	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   273: invokevirtual 95	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   276: istore 5
    //   278: aload_3
    //   279: getfield 682	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchDocRsp:is_end	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   282: invokevirtual 95	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   285: istore 6
    //   287: iload 6
    //   289: iconst_1
    //   290: if_icmpne +9 -> 299
    //   293: iconst_1
    //   294: istore 8
    //   296: goto +6 -> 302
    //   299: iconst_0
    //   300: istore 8
    //   302: aload_3
    //   303: getfield 683	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchDocRsp:doc_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   306: invokevirtual 551	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   309: astore_2
    //   310: aload_2
    //   311: ifnull +225 -> 536
    //   314: aload_2
    //   315: invokeinterface 556 1 0
    //   320: ifle +216 -> 536
    //   323: iconst_0
    //   324: istore 6
    //   326: iload 6
    //   328: aload_2
    //   329: invokeinterface 556 1 0
    //   334: if_icmpge +202 -> 536
    //   337: new 49	com/tencent/mobileqq/teamworkforgroup/GPadInfo
    //   340: dup
    //   341: invokespecial 603	com/tencent/mobileqq/teamworkforgroup/GPadInfo:<init>	()V
    //   344: astore_3
    //   345: new 530	java/util/ArrayList
    //   348: dup
    //   349: invokespecial 531	java/util/ArrayList:<init>	()V
    //   352: astore 12
    //   354: aload_2
    //   355: iload 6
    //   357: invokeinterface 560 2 0
    //   362: checkcast 685	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchItem
    //   365: astore 14
    //   367: aload_3
    //   368: aload 14
    //   370: getfield 689	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchItem:doc_info	Ltencent/im/oidb/cmd0xae9/group_online_docs$DocInfo;
    //   373: invokevirtual 690	tencent/im/oidb/cmd0xae9/group_online_docs$DocInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   376: checkcast 25	tencent/im/oidb/cmd0xae9/group_online_docs$DocInfo
    //   379: lload 10
    //   381: invokestatic 605	com/tencent/mobileqq/teamwork/api/impl/GroupTeamWorkHandlerImpl:buildPadInfo	(Lcom/tencent/mobileqq/teamworkforgroup/GPadInfo;Ltencent/im/oidb/cmd0xae9/group_online_docs$DocInfo;J)V
    //   384: aload 14
    //   386: getfield 694	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchItem:match_word	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   389: invokevirtual 697	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   392: astore 14
    //   394: aload 14
    //   396: ifnull +60 -> 456
    //   399: aload 14
    //   401: invokeinterface 556 1 0
    //   406: ifle +50 -> 456
    //   409: iconst_0
    //   410: istore 7
    //   412: iload 7
    //   414: aload 14
    //   416: invokeinterface 556 1 0
    //   421: if_icmpge +35 -> 456
    //   424: aload 12
    //   426: aload 14
    //   428: iload 7
    //   430: invokeinterface 560 2 0
    //   435: checkcast 68	com/tencent/mobileqq/pb/ByteStringMicro
    //   438: invokevirtual 72	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   441: invokeinterface 563 2 0
    //   446: pop
    //   447: iload 7
    //   449: iconst_1
    //   450: iadd
    //   451: istore 7
    //   453: goto -41 -> 412
    //   456: aload_3
    //   457: getfield 701	com/tencent/mobileqq/teamworkforgroup/GPadInfo:searchKeyWordList	Ljava/util/List;
    //   460: aload 12
    //   462: invokeinterface 705 2 0
    //   467: pop
    //   468: aload 13
    //   470: aload_3
    //   471: invokeinterface 563 2 0
    //   476: pop
    //   477: invokestatic 360	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   480: ifeq +47 -> 527
    //   483: getstatic 362	com/tencent/mobileqq/teamwork/api/impl/GroupTeamWorkHandlerImpl:TAG	Ljava/lang/String;
    //   486: astore 12
    //   488: new 364	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 365	java/lang/StringBuilder:<init>	()V
    //   495: astore 14
    //   497: aload 14
    //   499: ldc_w 707
    //   502: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload 14
    //   508: aload_3
    //   509: invokevirtual 608	com/tencent/mobileqq/teamworkforgroup/GPadInfo:toString	()Ljava/lang/String;
    //   512: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload 12
    //   518: iconst_2
    //   519: aload 14
    //   521: invokevirtual 377	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: invokestatic 381	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   527: iload 6
    //   529: iconst_1
    //   530: iadd
    //   531: istore 6
    //   533: goto -207 -> 326
    //   536: goto +129 -> 665
    //   539: astore_2
    //   540: goto +105 -> 645
    //   543: astore_2
    //   544: goto +18 -> 562
    //   547: astore_2
    //   548: goto +94 -> 642
    //   551: astore_2
    //   552: goto +7 -> 559
    //   555: astore_2
    //   556: iconst_0
    //   557: istore 5
    //   559: iconst_0
    //   560: istore 8
    //   562: getstatic 362	com/tencent/mobileqq/teamwork/api/impl/GroupTeamWorkHandlerImpl:TAG	Ljava/lang/String;
    //   565: astore_3
    //   566: new 364	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 365	java/lang/StringBuilder:<init>	()V
    //   573: astore 12
    //   575: aload 12
    //   577: ldc_w 709
    //   580: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload 12
    //   586: aload_2
    //   587: invokevirtual 573	java/lang/Exception:toString	()Ljava/lang/String;
    //   590: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: pop
    //   594: aload_3
    //   595: iconst_1
    //   596: aload 12
    //   598: invokevirtual 377	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 575	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   604: goto +61 -> 665
    //   607: astore_2
    //   608: goto +37 -> 645
    //   611: iconst_0
    //   612: istore 6
    //   614: iconst_0
    //   615: istore 8
    //   617: aload_3
    //   618: astore_1
    //   619: iload 5
    //   621: istore 4
    //   623: iload 6
    //   625: istore 5
    //   627: goto +38 -> 665
    //   630: astore_3
    //   631: iconst_0
    //   632: istore 5
    //   634: iload 6
    //   636: istore 4
    //   638: aload_2
    //   639: astore_1
    //   640: aload_3
    //   641: astore_2
    //   642: iconst_0
    //   643: istore 8
    //   645: invokestatic 360	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   648: ifeq +13 -> 661
    //   651: getstatic 362	com/tencent/mobileqq/teamwork/api/impl/GroupTeamWorkHandlerImpl:TAG	Ljava/lang/String;
    //   654: iconst_2
    //   655: ldc_w 711
    //   658: invokestatic 507	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   661: aload_2
    //   662: invokevirtual 510	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   665: aload_0
    //   666: iconst_2
    //   667: iload 9
    //   669: iconst_5
    //   670: anewarray 512	java/lang/Object
    //   673: dup
    //   674: iconst_0
    //   675: iload 4
    //   677: invokestatic 411	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   680: aastore
    //   681: dup
    //   682: iconst_1
    //   683: aload_1
    //   684: aastore
    //   685: dup
    //   686: iconst_2
    //   687: aload 13
    //   689: aastore
    //   690: dup
    //   691: iconst_3
    //   692: iload 5
    //   694: invokestatic 411	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   697: aastore
    //   698: dup
    //   699: iconst_4
    //   700: iload 8
    //   702: invokestatic 664	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   705: aastore
    //   706: invokevirtual 516	com/tencent/mobileqq/teamwork/api/impl/GroupTeamWorkHandlerImpl:notifyUI	(IZLjava/lang/Object;)V
    //   709: invokestatic 360	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   712: ifeq +98 -> 810
    //   715: getstatic 362	com/tencent/mobileqq/teamwork/api/impl/GroupTeamWorkHandlerImpl:TAG	Ljava/lang/String;
    //   718: astore_2
    //   719: new 364	java/lang/StringBuilder
    //   722: dup
    //   723: invokespecial 365	java/lang/StringBuilder:<init>	()V
    //   726: astore_3
    //   727: aload_3
    //   728: ldc_w 713
    //   731: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload_3
    //   736: iload 9
    //   738: invokevirtual 521	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   741: pop
    //   742: aload_3
    //   743: ldc_w 523
    //   746: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: pop
    //   750: aload_3
    //   751: iload 4
    //   753: invokevirtual 422	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   756: pop
    //   757: aload_3
    //   758: ldc_w 525
    //   761: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: pop
    //   765: aload_3
    //   766: aload_1
    //   767: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: pop
    //   771: aload_3
    //   772: ldc_w 715
    //   775: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: pop
    //   779: aload_3
    //   780: iload 5
    //   782: invokevirtual 422	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   785: pop
    //   786: aload_3
    //   787: ldc_w 717
    //   790: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: pop
    //   794: aload_3
    //   795: iload 8
    //   797: invokevirtual 521	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   800: pop
    //   801: aload_2
    //   802: iconst_2
    //   803: aload_3
    //   804: invokevirtual 377	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   807: invokestatic 381	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   810: return
    //   811: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	812	0	this	GroupTeamWorkHandlerImpl
    //   0	812	1	paramToServiceMsg	ToServiceMsg
    //   0	812	2	paramFromServiceMsg	FromServiceMsg
    //   0	812	3	paramObject	Object
    //   30	722	4	i	int
    //   92	689	5	j	int
    //   69	566	6	k	int
    //   410	42	7	m	int
    //   294	502	8	bool1	boolean
    //   13	724	9	bool2	boolean
    //   45	335	10	l	long
    //   2	595	12	localObject1	Object
    //   54	634	13	localArrayList	ArrayList
    //   85	435	14	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   302	310	539	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   314	323	539	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   326	394	539	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   399	409	539	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   412	447	539	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   456	527	539	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   302	310	543	java/lang/Exception
    //   314	323	543	java/lang/Exception
    //   326	394	543	java/lang/Exception
    //   399	409	543	java/lang/Exception
    //   412	447	543	java/lang/Exception
    //   456	527	543	java/lang/Exception
    //   278	287	547	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   278	287	551	java/lang/Exception
    //   197	213	555	java/lang/Exception
    //   219	230	555	java/lang/Exception
    //   240	246	555	java/lang/Exception
    //   252	262	555	java/lang/Exception
    //   269	278	555	java/lang/Exception
    //   562	604	607	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   71	87	630	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   101	112	630	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   119	129	630	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   139	150	630	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   157	166	630	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   183	191	630	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   197	213	630	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   219	230	630	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   240	246	630	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   252	262	630	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   269	278	630	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return GroupTeamWorkObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.getServiceCmd();
    boolean bool = paramFromServiceMsg.isSuccess();
    if ("OidbSvc.0xae9_1".equals(paramFromServiceMsg.getServiceCmd())) {
      handleGetGroupTeamWorkList(paramToServiceMsg, paramFromServiceMsg, paramObject);
    } else if ("OidbSvc.0xaee".equals(paramFromServiceMsg.getServiceCmd())) {
      handleGetGroupPadTemplateList(paramToServiceMsg, paramFromServiceMsg, paramObject);
    } else if ("OidbSvc.0xaef_1".equals(paramFromServiceMsg.getServiceCmd())) {
      handleSearchForGroupTeamWorkList(paramToServiceMsg, paramFromServiceMsg, paramObject);
    } else if ("OidbSvc.0xaea_1".equals(paramFromServiceMsg.getServiceCmd())) {
      handleDeleteTeamWorkFile(paramToServiceMsg, paramFromServiceMsg, paramObject);
    } else if ((!"OidbSvc.0xaf3_1".equals(paramFromServiceMsg.getServiceCmd())) && (!"OidbSvc.0xaf3_2".equals(paramFromServiceMsg.getServiceCmd())) && ("OidbSvc.0xae9_2".equals(paramFromServiceMsg.getServiceCmd()))) {
      handleGetGroupTeamWorkListLastAddTime(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = TAG;
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("onReceive, cmd=");
      paramFromServiceMsg.append(str);
      paramFromServiceMsg.append(", isSucc=");
      paramFromServiceMsg.append(bool);
      QLog.i(paramToServiceMsg, 2, paramFromServiceMsg.toString());
    }
  }
  
  public void reqDeleteGroupTeamWorkFile(long paramLong, online_docs.DocId paramDocId, String paramString, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void reqSearchGroupTeamWorkList(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramLong == 0L) {
      return;
    }
    Object localObject2 = new Oidb_0xaef.SearchDocReq();
    ((Oidb_0xaef.SearchDocReq)localObject2).group_code.set(paramLong);
    ((Oidb_0xaef.SearchDocReq)localObject2).key_word.set(ByteStringMicro.copyFromUtf8(paramString));
    ((Oidb_0xaef.SearchDocReq)localObject2).start.set(paramInt1);
    ((Oidb_0xaef.SearchDocReq)localObject2).limit.set(paramInt2);
    Object localObject1 = new Oidb_0xaef.ReqBody();
    ((Oidb_0xaef.ReqBody)localObject1).search_doc_req.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2799);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0xaef.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0xaef_1");
    ((ToServiceMsg)localObject1).addAttribute("key_group_code", Long.valueOf(paramLong));
    ((ToServiceMsg)localObject1).addAttribute("key_req_start", Integer.valueOf(paramInt1));
    ((ToServiceMsg)localObject1).addAttribute("key_req_limit", Integer.valueOf(paramInt2));
    ((ToServiceMsg)localObject1).addAttribute("key_type_key_word", paramString);
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    super.sendPbReq((ToServiceMsg)localObject1);
    if (QLog.isColorLevel())
    {
      paramString = TAG;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reqSearchGroupTeamWorkList group code = ");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(" start = ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" count = ");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.i(paramString, 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.GroupTeamWorkHandlerImpl
 * JD-Core Version:    0.7.0.1
 */