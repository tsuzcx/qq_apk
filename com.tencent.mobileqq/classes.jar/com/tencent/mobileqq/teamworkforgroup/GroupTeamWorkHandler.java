package com.tencent.mobileqq.teamworkforgroup;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0xae9.Oidb_0xae9.GetAddTimeRsp;
import tencent.im.oidb.cmd0xae9.Oidb_0xae9.GetListReq;
import tencent.im.oidb.cmd0xae9.Oidb_0xae9.GetListRsp;
import tencent.im.oidb.cmd0xae9.Oidb_0xae9.ReqBody;
import tencent.im.oidb.cmd0xae9.Oidb_0xae9.RspBody;
import tencent.im.oidb.cmd0xae9.group_online_docs.DocInfo;
import tencent.im.oidb.cmd0xae9.online_docs.DocId;
import tencent.im.oidb.cmd0xae9.online_docs.DocMetaData;
import tencent.im.oidb.cmd0xaea.Oidb_0xaea.DeleteDocReq;
import tencent.im.oidb.cmd0xaea.Oidb_0xaea.ReqBody;
import tencent.im.oidb.cmd0xaee.Oidb_0xaee.ListRsp;
import tencent.im.oidb.cmd0xaee.Oidb_0xaee.ReqBody;
import tencent.im.oidb.cmd0xaee.Oidb_0xaee.RspBody;
import tencent.im.oidb.cmd0xaee.Oidb_0xaee.Template;
import tencent.im.oidb.cmd0xaef.Oidb_0xaef.ReqBody;
import tencent.im.oidb.cmd0xaef.Oidb_0xaef.SearchDocReq;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class GroupTeamWorkHandler
  extends BusinessHandler
{
  public static String a;
  public static String b = "OidbSvc.0xae9_1";
  public static String c = "OidbSvc.0xae9_2";
  public static String d = "OidbSvc.0xaef_1";
  public static String e = "OidbSvc.0xaea_1";
  public static String f = "OidbSvc.0xaee";
  public static String g = "OidbSvc.0xaf3_1";
  public static String h = "OidbSvc.0xaf3_2";
  public static String i = "key_group_code";
  public static String j = "key_req_start";
  public static String k = "key_req_limit";
  public static String l = "key_type_operation";
  public static String m = "key_type_key_word";
  public static String n = "key_type_pad_url";
  private QQAppInterface a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "GroupTeamWorkHandler";
  }
  
  public GroupTeamWorkHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static void a(GPadInfo paramGPadInfo, group_online_docs.DocInfo paramDocInfo, long paramLong)
  {
    boolean bool = true;
    if ((paramGPadInfo != null) && (paramDocInfo != null)) {}
    for (;;)
    {
      try
      {
        online_docs.DocMetaData localDocMetaData;
        if ((paramDocInfo.doc_meta_data != null) && (paramDocInfo.doc_meta_data.doc_id != null))
        {
          localDocMetaData = paramDocInfo.doc_meta_data;
          localObject = localDocMetaData.doc_id;
          paramGPadInfo.domainId = ((online_docs.DocId)localObject).domain_id.get();
          if (((online_docs.DocId)localObject).pad_id.has())
          {
            localObject = ((online_docs.DocId)localObject).pad_id.get().toStringUtf8();
            paramGPadInfo.padId = ((String)localObject);
            if (!localDocMetaData.title.has()) {
              break label417;
            }
            localObject = localDocMetaData.title.get().toStringUtf8();
            paramGPadInfo.title = ((String)localObject);
            paramGPadInfo.creatorUin = localDocMetaData.creator_uin.get();
            paramGPadInfo.createTime = localDocMetaData.create_ts.get();
            paramGPadInfo.lastEditorUin = localDocMetaData.last_modify_uin.get();
            paramGPadInfo.lastEditTime = (1000L * localDocMetaData.last_modify_ts.get());
            paramGPadInfo.ownerUin = localDocMetaData.owner_uin.get();
            if (localDocMetaData.doc_type.get() != 0) {
              continue;
            }
            paramGPadInfo.type = 1;
            paramGPadInfo.creatorUid = localDocMetaData.creator_uid.get();
            paramGPadInfo.lastModifyUid = localDocMetaData.last_modify_uid.get();
            paramGPadInfo.owneruid = localDocMetaData.owner_uid.get();
            if (!paramDocInfo.creator_nick.has()) {
              break label424;
            }
            localObject = paramDocInfo.creator_nick.get();
            paramGPadInfo.creatorCard = ((String)localObject);
            if (!paramDocInfo.owner_nick.has()) {
              break label431;
            }
            localObject = paramDocInfo.owner_nick.get();
            paramGPadInfo.ownerCard = ((String)localObject);
            if (!paramDocInfo.last_modify_nick.has()) {
              break label438;
            }
            localObject = paramDocInfo.last_modify_nick.get();
            paramGPadInfo.lastModifyCard = ((String)localObject);
            if (paramDocInfo.top.get() != 1) {
              break label445;
            }
            paramGPadInfo.pinedFlag = bool;
            if (!paramDocInfo.doc_url.has()) {
              break label411;
            }
            paramDocInfo = paramDocInfo.doc_url.get();
            paramGPadInfo.pad_url = paramDocInfo;
            paramGPadInfo.groupCode = paramLong;
          }
        }
        else
        {
          return;
        }
        localObject = "";
        continue;
        if (localDocMetaData.doc_type.get() == 1)
        {
          paramGPadInfo.type = 2;
          continue;
        }
        if (localDocMetaData.doc_type.get() != 2) {
          continue;
        }
      }
      finally {}
      paramGPadInfo.type = 3;
      continue;
      label411:
      paramDocInfo = "";
      continue;
      label417:
      Object localObject = "";
      continue;
      label424:
      localObject = "";
      continue;
      label431:
      localObject = "";
      continue;
      label438:
      localObject = "";
      continue;
      label445:
      bool = false;
    }
  }
  
  public static void a(GroupPadTemplateInfo paramGroupPadTemplateInfo, Oidb_0xaee.Template paramTemplate)
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
      return;
    }
    finally
    {
      paramGroupPadTemplateInfo = finally;
      throw paramGroupPadTemplateInfo;
    }
  }
  
  public void a(long paramLong)
  {
    if (paramLong == 0L) {}
    do
    {
      return;
      Object localObject = new Oidb_0xaee.ReqBody();
      ((Oidb_0xaee.ReqBody)localObject).group_code.set(paramLong);
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(2798);
      localOIDBSSOPkg.uint32_result.set(0);
      localOIDBSSOPkg.uint32_service_type.set(1);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0xaee.ReqBody)localObject).toByteArray()));
      localObject = createToServiceMsg(f);
      ((ToServiceMsg)localObject).addAttribute(i, Long.valueOf(paramLong));
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      super.sendPbReq((ToServiceMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "getGroupPadTemplateList! groupCode = " + paramLong);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramLong == 0L) {}
    do
    {
      return;
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
      localObject1 = createToServiceMsg(b);
      ((ToServiceMsg)localObject1).addAttribute(i, Long.valueOf(paramLong));
      ((ToServiceMsg)localObject1).addAttribute(j, Integer.valueOf(paramInt1));
      ((ToServiceMsg)localObject1).addAttribute(k, Integer.valueOf(paramInt2));
      ((ToServiceMsg)localObject1).addAttribute(l, Integer.valueOf(paramInt3));
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      super.sendPbReq((ToServiceMsg)localObject1);
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "getGroupTeamWorkList group code = " + paramLong + " start = " + paramInt1 + " count = " + paramInt2);
  }
  
  public void a(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramLong == 0L) {}
    do
    {
      return;
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
      localObject1 = createToServiceMsg(d);
      ((ToServiceMsg)localObject1).addAttribute(i, Long.valueOf(paramLong));
      ((ToServiceMsg)localObject1).addAttribute(j, Integer.valueOf(paramInt1));
      ((ToServiceMsg)localObject1).addAttribute(k, Integer.valueOf(paramInt2));
      ((ToServiceMsg)localObject1).addAttribute(m, paramString);
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      super.sendPbReq((ToServiceMsg)localObject1);
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "reqSearchGroupTeamWorkList group code = " + paramLong + " start = " + paramInt1 + " count = " + paramInt2);
  }
  
  public void a(long paramLong, online_docs.DocId paramDocId, String paramString, boolean paramBoolean)
  {
    if (paramLong == 0L) {
      return;
    }
    Object localObject = new Oidb_0xaea.DeleteDocReq();
    ((Oidb_0xaea.DeleteDocReq)localObject).group_code.set(paramLong);
    ((Oidb_0xaea.DeleteDocReq)localObject).doc_id.set(paramDocId);
    paramDocId = ((Oidb_0xaea.DeleteDocReq)localObject).copy;
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      paramDocId.set(i1);
      paramDocId = new Oidb_0xaea.ReqBody();
      paramDocId.delete_doc_req.set((MessageMicro)localObject);
      localObject = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "docs.qq.com");
      paramDocId.pskey.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(2794);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramDocId.toByteArray()));
      paramDocId = createToServiceMsg(e);
      paramDocId.addAttribute(i, Long.valueOf(paramLong));
      paramDocId.addAttribute(n, paramString);
      paramDocId.setTimeout(30000L);
      paramDocId.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
      super.sendPbReq(paramDocId);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 2, "reqDeleteGroupTeamWorkFile group code = " + paramLong + " padUrl " + paramString + " isCopy: = " + paramBoolean);
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {
      return;
    }
    boolean bool = paramFromServiceMsg.isSuccess();
    i1 = -1;
    paramToServiceMsg = "";
    ArrayList localArrayList = new ArrayList();
    Object localObject = new oidb_sso.OIDBSSOPkg();
    GroupTeamWorkManager localGroupTeamWorkManager = (GroupTeamWorkManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GROUP_TEAM_WORK_MANAGER);
    paramFromServiceMsg = paramToServiceMsg;
    i2 = i1;
    for (;;)
    {
      try
      {
        localObject = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
        paramObject = paramToServiceMsg;
        i3 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        i2 = i1;
        if (!((oidb_sso.OIDBSSOPkg)localObject).uint32_result.has()) {
          continue;
        }
        paramFromServiceMsg = paramToServiceMsg;
        i2 = i1;
        i1 = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
        paramFromServiceMsg = paramToServiceMsg;
        i2 = i1;
        if (((oidb_sso.OIDBSSOPkg)localObject).str_error_msg.has())
        {
          paramFromServiceMsg = paramToServiceMsg;
          i2 = i1;
          paramToServiceMsg = ((oidb_sso.OIDBSSOPkg)localObject).str_error_msg.get();
          paramObject = paramToServiceMsg;
          i3 = i1;
          if (i1 != 0) {
            continue;
          }
          paramFromServiceMsg = paramToServiceMsg;
          i2 = i1;
          paramObject = new Oidb_0xaee.RspBody();
          paramFromServiceMsg = paramToServiceMsg;
          i2 = i1;
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        int i3;
        i1 = i2;
        paramToServiceMsg = paramFromServiceMsg;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, " handleGetGroupPadTemplateList parse oidb_sso.OIDBSSOPkg failed.");
        paramObject.printStackTrace();
        continue;
      }
      try
      {
        paramObject.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray());
        paramFromServiceMsg = paramToServiceMsg;
        i2 = i1;
        paramObject = paramObject.list_rsp.rpt_template.get();
        if (paramObject != null)
        {
          paramFromServiceMsg = paramToServiceMsg;
          i2 = i1;
          if (paramObject.size() > 0)
          {
            i3 = 0;
            paramFromServiceMsg = paramToServiceMsg;
            i2 = i1;
            if (i3 < paramObject.size())
            {
              paramFromServiceMsg = paramToServiceMsg;
              i2 = i1;
              localObject = new GroupPadTemplateInfo();
              paramFromServiceMsg = paramToServiceMsg;
              i2 = i1;
              a((GroupPadTemplateInfo)localObject, (Oidb_0xaee.Template)paramObject.get(i3));
              paramFromServiceMsg = paramToServiceMsg;
              i2 = i1;
              localArrayList.add(localObject);
              paramFromServiceMsg = paramToServiceMsg;
              i2 = i1;
              if (QLog.isColorLevel())
              {
                paramFromServiceMsg = paramToServiceMsg;
                i2 = i1;
                QLog.i(jdField_a_of_type_JavaLangString, 2, " handleGetGroupPadTemplateList localPadInfo: " + localObject.toString());
              }
              i3 += 1;
              continue;
              paramToServiceMsg = "";
              continue;
            }
            paramFromServiceMsg = paramToServiceMsg;
            i2 = i1;
            localGroupTeamWorkManager.a(localArrayList);
          }
        }
        notifyUI(3, bool, new Object[] { Integer.valueOf(i1), paramToServiceMsg, localArrayList });
        return;
      }
      catch (Exception paramObject)
      {
        paramFromServiceMsg = paramToServiceMsg;
        i2 = i1;
        QLog.e(jdField_a_of_type_JavaLangString, 1, " handleGetGroupPadTemplateList exception: " + paramObject.toString());
        i3 = i1;
        paramObject = paramToServiceMsg;
      }
      paramToServiceMsg = paramObject;
      i1 = i3;
    }
  }
  
  public void b(long paramLong)
  {
    if (paramLong == 0L) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 2, "getAddGroupTeamWorkTime group code = " + paramLong);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    boolean bool7 = paramFromServiceMsg.isSuccess();
    int i3 = -1;
    String str = "";
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    boolean bool4 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool3 = false;
    long l1 = ((Long)paramToServiceMsg.getAttribute(i)).longValue();
    paramToServiceMsg = (GroupTeamWorkManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GROUP_TEAM_WORK_MANAGER);
    boolean bool1 = bool5;
    paramFromServiceMsg = str;
    i2 = i3;
    for (;;)
    {
      try
      {
        localOIDBSSOPkg = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom((byte[])paramObject);
        bool2 = bool6;
        paramObject = str;
        i1 = i3;
        bool1 = bool5;
        paramFromServiceMsg = str;
        i2 = i3;
        if (!localOIDBSSOPkg.uint32_result.has()) {
          continue;
        }
        bool1 = bool5;
        paramFromServiceMsg = str;
        i2 = i3;
        i3 = localOIDBSSOPkg.uint32_result.get();
        bool1 = bool5;
        paramFromServiceMsg = str;
        i2 = i3;
        if (localOIDBSSOPkg.str_error_msg.has())
        {
          bool1 = bool5;
          paramFromServiceMsg = str;
          i2 = i3;
          paramToServiceMsg = localOIDBSSOPkg.str_error_msg.get();
          bool2 = bool6;
          paramObject = paramToServiceMsg;
          i1 = i3;
          if (i3 != 0) {
            continue;
          }
          bool1 = bool5;
          paramFromServiceMsg = paramToServiceMsg;
          i2 = i3;
          paramObject = new Oidb_0xae9.RspBody();
          bool2 = bool4;
          bool1 = bool5;
          paramFromServiceMsg = paramToServiceMsg;
          i2 = i3;
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        boolean bool2;
        long l2;
        paramToServiceMsg = paramFromServiceMsg;
        int i1 = i2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, " handleGetGroupPadTemplateList parse oidb_sso.OIDBSSOPkg failed.");
        paramObject.printStackTrace();
        continue;
      }
      try
      {
        paramObject.mergeFrom(localOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
        bool2 = bool4;
        bool1 = bool5;
        paramFromServiceMsg = paramToServiceMsg;
        i2 = i3;
        l2 = ((Oidb_0xae9.GetAddTimeRsp)paramObject.get_add_time_rsp.get()).timestamp.get();
        bool2 = bool4;
        bool1 = bool5;
        paramFromServiceMsg = paramToServiceMsg;
        i2 = i3;
        if (!GroupTeamWorkManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), String.valueOf(l1), "key_groupteamwork_add_timestamp", "").equals(String.valueOf(l2)))
        {
          bool4 = true;
          bool5 = true;
          bool3 = true;
          bool2 = bool4;
          bool1 = bool5;
          paramFromServiceMsg = paramToServiceMsg;
          i2 = i3;
          GroupTeamWorkManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), String.valueOf(l1), "key_groupteamwork_add_timestamp", String.valueOf(l2));
          bool2 = bool4;
          bool1 = bool5;
          paramFromServiceMsg = paramToServiceMsg;
          i2 = i3;
          ((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), String.valueOf(l1), "TIM_GROUP_TM_REDDOT", true);
        }
        bool1 = bool3;
        i1 = i3;
        notifyUI(7, bool7, new Object[] { Integer.valueOf(i1), paramToServiceMsg, Boolean.valueOf(bool1) });
        return;
      }
      catch (Exception paramObject)
      {
        bool1 = bool2;
        paramFromServiceMsg = paramToServiceMsg;
        i2 = i3;
        QLog.e(jdField_a_of_type_JavaLangString, 1, " handleGetGroupPadTemplateList exception: " + paramObject.toString());
        i1 = i3;
        paramObject = paramToServiceMsg;
      }
      paramToServiceMsg = "";
      continue;
      paramToServiceMsg = paramObject;
      bool1 = bool2;
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {
      return;
    }
    boolean bool = paramFromServiceMsg.isSuccess();
    i6 = ((Integer)paramToServiceMsg.getAttribute(l)).intValue();
    ((Integer)paramToServiceMsg.getAttribute(j)).intValue();
    long l1 = ((Long)paramToServiceMsg.getAttribute(i)).longValue();
    paramToServiceMsg = "";
    i5 = 0;
    i3 = 0;
    ArrayList localArrayList = new ArrayList();
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    GroupTeamWorkManager localGroupTeamWorkManager = (GroupTeamWorkManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GROUP_TEAM_WORK_MANAGER);
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          try
          {
            localOIDBSSOPkg.mergeFrom((byte[])paramObject);
            if (!localOIDBSSOPkg.uint32_result.has()) {
              continue;
            }
            i1 = localOIDBSSOPkg.uint32_result.get();
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
          {
            int i4;
            int i1 = 0;
            int i2 = -1;
            continue;
            i1 = 0;
            i2 = -1;
            continue;
            i5 += 1;
            continue;
            if (i6 == 1) {
              continue;
            }
            if (i6 != 2) {
              continue;
            }
            continue;
            i2 = i1;
            i1 = i3;
            continue;
          }
          try
          {
            if (localOIDBSSOPkg.str_error_msg.has())
            {
              paramFromServiceMsg = localOIDBSSOPkg.str_error_msg.get();
              paramToServiceMsg = paramFromServiceMsg;
              if (i1 != 0) {
                continue;
              }
              i4 = i5;
            }
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
          {
            i3 = 0;
            i2 = i1;
            i1 = i3;
            continue;
            i3 = 0;
            i2 = i1;
            i1 = i3;
            continue;
          }
          try
          {
            for (;;)
            {
              paramFromServiceMsg = new Oidb_0xae9.RspBody();
              i2 = i3;
              i4 = i5;
              try
              {
                paramFromServiceMsg.mergeFrom(localOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
                i2 = i3;
                i4 = i5;
                paramObject = (Oidb_0xae9.GetListRsp)paramFromServiceMsg.get_list_rsp.get();
                if (paramObject == null)
                {
                  i2 = i3;
                  i4 = i5;
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  i2 = i3;
                  i4 = i5;
                  QLog.i(jdField_a_of_type_JavaLangString, 2, " handleGetGroupTeamWorkList getListRsp null: ");
                  return;
                }
              }
              catch (Exception paramFromServiceMsg)
              {
                i3 = i2;
              }
            }
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
          {
            i2 = i1;
            i1 = i4;
          }
        }
        try
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, " handleGetGroupTeamWorkList exception: " + paramFromServiceMsg.toString());
          i2 = i1;
          i1 = i3;
          notifyUI(1, bool, new Object[] { Integer.valueOf(i2), paramToServiceMsg, localArrayList, Integer.valueOf(i1), Integer.valueOf(i6) });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i(jdField_a_of_type_JavaLangString, 2, " handleGetGroupTeamWorkList issuccess = " + bool + " retCode = " + i2 + " error msg = " + paramToServiceMsg + " next =" + i1 + " type operation = " + i6);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          i2 = i1;
          i1 = i3;
        }
      }
      paramToServiceMsg = "";
      continue;
      i2 = i3;
      i4 = i5;
      paramFromServiceMsg = paramObject.doc_list.get();
      i2 = i3;
      i4 = i5;
      i3 = paramObject.next.get();
      if (paramFromServiceMsg == null) {
        continue;
      }
      i2 = i3;
      i4 = i3;
      if (paramFromServiceMsg.size() <= 0) {
        continue;
      }
      i5 = 0;
      i2 = i3;
      i4 = i3;
      if (i5 >= paramFromServiceMsg.size()) {
        continue;
      }
      i2 = i3;
      i4 = i3;
      paramObject = new GPadInfo();
      i2 = i3;
      i4 = i3;
      a(paramObject, (group_online_docs.DocInfo)paramFromServiceMsg.get(i5), l1);
      i2 = i3;
      i4 = i3;
      localArrayList.add(paramObject);
      i2 = i3;
      i4 = i3;
      if (!QLog.isColorLevel()) {
        continue;
      }
      i2 = i3;
      i4 = i3;
      QLog.i(jdField_a_of_type_JavaLangString, 2, " handleGetGroupTeamWorkList localPadInfo: " + paramObject.toString());
      continue;
      i2 = i3;
      i4 = i3;
      localGroupTeamWorkManager.a(2, localArrayList);
      continue;
      if (i6 != 3) {
        continue;
      }
      i2 = i3;
      i4 = i3;
      localGroupTeamWorkManager.a(1, localArrayList);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, " handleGetGroupTeamWorkList parse oidb_sso.OIDBSSOPkg failed.");
      }
      paramFromServiceMsg.printStackTrace();
    }
  }
  
  /* Error */
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: invokevirtual 520	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   9: istore 9
    //   11: aload_1
    //   12: getstatic 62	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkHandler:j	Ljava/lang/String;
    //   15: invokevirtual 605	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   18: checkcast 425	java/lang/Integer
    //   21: invokevirtual 662	java/lang/Integer:intValue	()I
    //   24: pop
    //   25: aload_1
    //   26: getstatic 58	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkHandler:i	Ljava/lang/String;
    //   29: invokevirtual 605	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   32: checkcast 354	java/lang/Long
    //   35: invokevirtual 608	java/lang/Long:longValue	()J
    //   38: lstore 10
    //   40: new 522	java/util/ArrayList
    //   43: dup
    //   44: invokespecial 523	java/util/ArrayList:<init>	()V
    //   47: astore 12
    //   49: new 321	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   52: dup
    //   53: invokespecial 322	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   56: astore_1
    //   57: aload_1
    //   58: aload_3
    //   59: checkcast 532	[B
    //   62: checkcast 532	[B
    //   65: invokevirtual 536	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   68: checkcast 321	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   71: astore_2
    //   72: aload_2
    //   73: getfield 331	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   76: invokevirtual 537	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   79: ifeq +671 -> 750
    //   82: aload_2
    //   83: getfield 331	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   86: invokevirtual 159	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   89: istore 4
    //   91: aload_2
    //   92: getfield 540	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   95: invokevirtual 214	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   98: ifeq +238 -> 336
    //   101: aload_2
    //   102: getfield 540	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   105: invokevirtual 216	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   108: astore_1
    //   109: iload 4
    //   111: ifne +626 -> 737
    //   114: new 702	tencent/im/oidb/cmd0xaef/Oidb_0xaef$RspBody
    //   117: dup
    //   118: invokespecial 703	tencent/im/oidb/cmd0xaef/Oidb_0xaef$RspBody:<init>	()V
    //   121: astore_3
    //   122: aload_3
    //   123: aload_2
    //   124: getfield 337	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   127: invokevirtual 130	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   130: invokevirtual 544	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   133: invokevirtual 704	tencent/im/oidb/cmd0xaef/Oidb_0xaef$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   136: pop
    //   137: aload_3
    //   138: getfield 708	tencent/im/oidb/cmd0xaef/Oidb_0xaef$RspBody:search_doc_rsp	Ltencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchDocRsp;
    //   141: invokevirtual 711	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchDocRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   144: checkcast 710	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchDocRsp
    //   147: astore_2
    //   148: aload_2
    //   149: ifnonnull +193 -> 342
    //   152: invokestatic 383	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq -151 -> 4
    //   158: getstatic 26	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   161: iconst_2
    //   162: ldc_w 713
    //   165: invokestatic 401	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: return
    //   169: astore_2
    //   170: iconst_0
    //   171: istore 8
    //   173: iconst_0
    //   174: istore 5
    //   176: getstatic 26	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   179: iconst_1
    //   180: new 385	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   187: ldc_w 715
    //   190: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_2
    //   194: invokevirtual 590	java/lang/Exception:toString	()Ljava/lang/String;
    //   197: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 398	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 592	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: iload 4
    //   208: istore 6
    //   210: iload 5
    //   212: istore 4
    //   214: aload_0
    //   215: iconst_2
    //   216: iload 9
    //   218: iconst_5
    //   219: anewarray 579	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: iload 6
    //   226: invokestatic 428	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   229: aastore
    //   230: dup
    //   231: iconst_1
    //   232: aload_1
    //   233: aastore
    //   234: dup
    //   235: iconst_2
    //   236: aload 12
    //   238: aastore
    //   239: dup
    //   240: iconst_3
    //   241: iload 4
    //   243: invokestatic 428	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   246: aastore
    //   247: dup
    //   248: iconst_4
    //   249: iload 8
    //   251: invokestatic 659	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   254: aastore
    //   255: invokevirtual 587	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkHandler:notifyUI	(IZLjava/lang/Object;)V
    //   258: invokestatic 383	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq -257 -> 4
    //   264: getstatic 26	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   267: iconst_2
    //   268: new 385	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   275: ldc_w 717
    //   278: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: iload 9
    //   283: invokevirtual 510	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   286: ldc_w 677
    //   289: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: iload 6
    //   294: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   297: ldc_w 679
    //   300: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload_1
    //   304: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: ldc_w 719
    //   310: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: iload 4
    //   315: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   318: ldc_w 721
    //   321: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: iload 8
    //   326: invokevirtual 510	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   329: invokevirtual 398	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 401	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: return
    //   336: ldc 249
    //   338: astore_1
    //   339: goto -230 -> 109
    //   342: aload_2
    //   343: getfield 722	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchDocRsp:next	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   346: invokevirtual 159	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   349: istore 5
    //   351: aload_2
    //   352: getfield 725	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchDocRsp:is_end	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   355: invokevirtual 159	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   358: istore 6
    //   360: iload 6
    //   362: iconst_1
    //   363: if_icmpne +402 -> 765
    //   366: iconst_1
    //   367: istore 8
    //   369: aload_2
    //   370: getfield 726	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchDocRsp:doc_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   373: invokevirtual 560	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   376: astore_2
    //   377: aload_2
    //   378: ifnull +211 -> 589
    //   381: aload_2
    //   382: invokeinterface 565 1 0
    //   387: ifle +202 -> 589
    //   390: iconst_0
    //   391: istore 6
    //   393: iload 6
    //   395: aload_2
    //   396: invokeinterface 565 1 0
    //   401: if_icmpge +188 -> 589
    //   404: new 113	com/tencent/mobileqq/teamworkforgroup/GPadInfo
    //   407: dup
    //   408: invokespecial 690	com/tencent/mobileqq/teamworkforgroup/GPadInfo:<init>	()V
    //   411: astore_3
    //   412: new 522	java/util/ArrayList
    //   415: dup
    //   416: invokespecial 523	java/util/ArrayList:<init>	()V
    //   419: astore 13
    //   421: aload_2
    //   422: iload 6
    //   424: invokeinterface 569 2 0
    //   429: checkcast 728	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchItem
    //   432: astore 14
    //   434: aload_3
    //   435: aload 14
    //   437: getfield 732	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchItem:doc_info	Ltencent/im/oidb/cmd0xae9/group_online_docs$DocInfo;
    //   440: invokevirtual 733	tencent/im/oidb/cmd0xae9/group_online_docs$DocInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   443: checkcast 89	tencent/im/oidb/cmd0xae9/group_online_docs$DocInfo
    //   446: lload 10
    //   448: invokestatic 692	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkHandler:a	(Lcom/tencent/mobileqq/teamworkforgroup/GPadInfo;Ltencent/im/oidb/cmd0xae9/group_online_docs$DocInfo;J)V
    //   451: aload 14
    //   453: getfield 737	tencent/im/oidb/cmd0xaef/Oidb_0xaef$SearchItem:match_word	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   456: invokevirtual 740	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   459: astore 14
    //   461: aload 14
    //   463: ifnull +60 -> 523
    //   466: aload 14
    //   468: invokeinterface 565 1 0
    //   473: ifle +50 -> 523
    //   476: iconst_0
    //   477: istore 7
    //   479: iload 7
    //   481: aload 14
    //   483: invokeinterface 565 1 0
    //   488: if_icmpge +35 -> 523
    //   491: aload 13
    //   493: aload 14
    //   495: iload 7
    //   497: invokeinterface 569 2 0
    //   502: checkcast 132	com/tencent/mobileqq/pb/ByteStringMicro
    //   505: invokevirtual 136	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   508: invokeinterface 575 2 0
    //   513: pop
    //   514: iload 7
    //   516: iconst_1
    //   517: iadd
    //   518: istore 7
    //   520: goto -41 -> 479
    //   523: aload_3
    //   524: getfield 744	com/tencent/mobileqq/teamworkforgroup/GPadInfo:searchKeyWordList	Ljava/util/List;
    //   527: aload 13
    //   529: invokeinterface 748 2 0
    //   534: pop
    //   535: aload 12
    //   537: aload_3
    //   538: invokeinterface 575 2 0
    //   543: pop
    //   544: invokestatic 383	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   547: ifeq +33 -> 580
    //   550: getstatic 26	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   553: iconst_2
    //   554: new 385	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   561: ldc_w 750
    //   564: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: aload_3
    //   568: invokevirtual 695	com/tencent/mobileqq/teamworkforgroup/GPadInfo:toString	()Ljava/lang/String;
    //   571: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: invokevirtual 398	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokestatic 401	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   580: iload 6
    //   582: iconst_1
    //   583: iadd
    //   584: istore 6
    //   586: goto -193 -> 393
    //   589: iload 4
    //   591: istore 6
    //   593: iload 5
    //   595: istore 4
    //   597: goto -383 -> 214
    //   600: astore_2
    //   601: iconst_0
    //   602: istore 8
    //   604: iconst_0
    //   605: istore 4
    //   607: ldc 249
    //   609: astore_1
    //   610: iconst_m1
    //   611: istore 5
    //   613: invokestatic 383	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   616: ifeq +13 -> 629
    //   619: getstatic 26	com/tencent/mobileqq/teamworkforgroup/GroupTeamWorkHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   622: iconst_2
    //   623: ldc_w 752
    //   626: invokestatic 596	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   629: aload_2
    //   630: invokevirtual 599	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   633: iload 5
    //   635: istore 6
    //   637: goto -423 -> 214
    //   640: astore_2
    //   641: iconst_0
    //   642: istore 8
    //   644: iconst_0
    //   645: istore 6
    //   647: ldc 249
    //   649: astore_1
    //   650: iload 4
    //   652: istore 5
    //   654: iload 6
    //   656: istore 4
    //   658: goto -45 -> 613
    //   661: astore_2
    //   662: iload 4
    //   664: istore 5
    //   666: iconst_0
    //   667: istore 4
    //   669: iconst_0
    //   670: istore 8
    //   672: goto -59 -> 613
    //   675: astore_2
    //   676: iconst_0
    //   677: istore 8
    //   679: iload 4
    //   681: istore 6
    //   683: iload 5
    //   685: istore 4
    //   687: iload 6
    //   689: istore 5
    //   691: goto -78 -> 613
    //   694: astore_2
    //   695: iload 4
    //   697: istore 6
    //   699: iload 5
    //   701: istore 4
    //   703: iload 6
    //   705: istore 5
    //   707: goto -94 -> 613
    //   710: astore_2
    //   711: iload 4
    //   713: istore 6
    //   715: iload 5
    //   717: istore 4
    //   719: iload 6
    //   721: istore 5
    //   723: goto -110 -> 613
    //   726: astore_2
    //   727: iconst_0
    //   728: istore 8
    //   730: goto -554 -> 176
    //   733: astore_2
    //   734: goto -558 -> 176
    //   737: iconst_0
    //   738: istore 8
    //   740: iload 4
    //   742: istore 6
    //   744: iconst_0
    //   745: istore 4
    //   747: goto -533 -> 214
    //   750: iconst_0
    //   751: istore 8
    //   753: iconst_0
    //   754: istore 4
    //   756: ldc 249
    //   758: astore_1
    //   759: iconst_m1
    //   760: istore 6
    //   762: goto -548 -> 214
    //   765: iconst_0
    //   766: istore 8
    //   768: goto -399 -> 369
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	771	0	this	GroupTeamWorkHandler
    //   0	771	1	paramToServiceMsg	ToServiceMsg
    //   0	771	2	paramFromServiceMsg	FromServiceMsg
    //   0	771	3	paramObject	Object
    //   89	666	4	i1	int
    //   174	548	5	i2	int
    //   208	553	6	i3	int
    //   477	42	7	i4	int
    //   171	596	8	bool1	boolean
    //   9	273	9	bool2	boolean
    //   38	409	10	l1	long
    //   47	489	12	localArrayList1	ArrayList
    //   419	109	13	localArrayList2	ArrayList
    //   432	62	14	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   122	148	169	java/lang/Exception
    //   152	168	169	java/lang/Exception
    //   342	351	169	java/lang/Exception
    //   57	91	600	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   91	109	640	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   114	122	661	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   122	148	661	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   152	168	661	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   342	351	661	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   351	360	675	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   369	377	694	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   381	390	694	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   393	461	694	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   466	476	694	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   479	514	694	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   523	580	694	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   176	206	710	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   351	360	726	java/lang/Exception
    //   369	377	733	java/lang/Exception
    //   381	390	733	java/lang/Exception
    //   393	461	733	java/lang/Exception
    //   466	476	733	java/lang/Exception
    //   479	514	733	java/lang/Exception
    //   523	580	733	java/lang/Exception
  }
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {
      return;
    }
    boolean bool = paramFromServiceMsg.isSuccess();
    int i3 = -1;
    Object localObject = "";
    String str = (String)paramToServiceMsg.getAttribute(n);
    ((Long)paramToServiceMsg.getAttribute(i)).longValue();
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    paramFromServiceMsg = (FromServiceMsg)localObject;
    i2 = i3;
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = localObject;
        i1 = i3;
        paramFromServiceMsg = (FromServiceMsg)localObject;
        i2 = i3;
        if (paramToServiceMsg.uint32_result.has())
        {
          paramFromServiceMsg = (FromServiceMsg)localObject;
          i2 = i3;
          i3 = paramToServiceMsg.uint32_result.get();
          paramFromServiceMsg = (FromServiceMsg)localObject;
          i2 = i3;
          if (!paramToServiceMsg.str_error_msg.has()) {
            continue;
          }
          paramFromServiceMsg = (FromServiceMsg)localObject;
          i2 = i3;
          paramToServiceMsg = paramToServiceMsg.str_error_msg.get();
          paramObject = paramToServiceMsg;
          i1 = i3;
          if (i3 == 0)
          {
            paramFromServiceMsg = paramToServiceMsg;
            i2 = i3;
            localObject = ((GroupTeamWorkManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GROUP_TEAM_WORK_MANAGER)).a();
            paramObject = paramToServiceMsg;
            i1 = i3;
            paramFromServiceMsg = paramToServiceMsg;
            i2 = i3;
            if (!TextUtils.isEmpty(str))
            {
              paramObject = paramToServiceMsg;
              i1 = i3;
              paramFromServiceMsg = paramToServiceMsg;
              i2 = i3;
              if (((ConcurrentHashMap)localObject).containsKey(str))
              {
                paramFromServiceMsg = paramToServiceMsg;
                i2 = i3;
                ((ConcurrentHashMap)localObject).remove(TeamWorkUtils.c(str));
                i1 = i3;
                paramObject = paramToServiceMsg;
              }
            }
          }
        }
        paramFromServiceMsg = paramObject;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        int i1 = i2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, " handleDeleteTeamWorkFile parse oidb_sso.OIDBSSOPkg failed.");
        paramToServiceMsg.printStackTrace();
        continue;
      }
      notifyUI(4, bool, new Object[] { Integer.valueOf(i1), paramFromServiceMsg });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 2, " handleDeleteTeamWorkFile issuccess = " + bool + " retCode = " + i1 + " error msg = " + paramFromServiceMsg);
      return;
      paramToServiceMsg = "";
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add(b);
      this.allowCmdSet.add(d);
      this.allowCmdSet.add(f);
      this.allowCmdSet.add(e);
      this.allowCmdSet.add(g);
      this.allowCmdSet.add(h);
      this.allowCmdSet.add(c);
    }
    return this.allowCmdSet;
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return GroupTeamWorkObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.getServiceCmd();
    boolean bool = paramFromServiceMsg.isSuccess();
    if (b.equals(paramFromServiceMsg.getServiceCmd())) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "onReceive, cmd=" + str + ", isSucc=" + bool);
      }
      return;
      if (f.equals(paramFromServiceMsg.getServiceCmd())) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (d.equals(paramFromServiceMsg.getServiceCmd())) {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (e.equals(paramFromServiceMsg.getServiceCmd())) {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if ((!g.equals(paramFromServiceMsg.getServiceCmd())) && (!h.equals(paramFromServiceMsg.getServiceCmd())) && (c.equals(paramFromServiceMsg.getServiceCmd()))) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkHandler
 * JD-Core Version:    0.7.0.1
 */