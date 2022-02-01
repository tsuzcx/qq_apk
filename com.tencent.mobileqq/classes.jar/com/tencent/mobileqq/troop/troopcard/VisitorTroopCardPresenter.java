package com.tencent.mobileqq.troop.troopcard;

import KQQ.BatchResponse;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.handler.ITroopBatchInfohandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberInfoHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.api.observer.TroopAvatarObserver;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.avatar.AvatarInfo;
import com.tencent.mobileqq.troop.avatar.TroopAvatarController;
import com.tencent.mobileqq.troop.avatar.TroopAvatarManger;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController.OnGotoBigPicListener;
import com.tencent.mobileqq.troop.avatar.TroopUploadingTask;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.oidb.cmd0x899.oidb_0x899.memberlist;>;
import java.util.Observer;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x787.oidb_0x787.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;
import tencent.im.oidb.cmd0x899.oidb_0x899.RspBody;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class VisitorTroopCardPresenter
{
  protected int a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  protected BaseMessageObserver a;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener = new VisitorTroopCardPresenter.3(this);
  private TroopAvatarObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopAvatarObserver = new VisitorTroopCardPresenter.9(this);
  private TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new VisitorTroopCardPresenter.6(this);
  private TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new VisitorTroopCardPresenter.7(this);
  private TroopAvatarManger jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger;
  private TroopPhotoController.OnGotoBigPicListener jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController$OnGotoBigPicListener = new VisitorTroopCardPresenter.4(this);
  private TroopPhotoController jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController;
  private TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
  private IVisitorTroopCardViewInterface jdField_a_of_type_ComTencentMobileqqTroopTroopcardIVisitorTroopCardViewInterface;
  private TroopSettingObserver jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver = new VisitorTroopCardPresenter.8(this);
  HttpWebCgiAsyncTask.Callback jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = new VisitorTroopCardPresenter.12(this);
  private String jdField_a_of_type_JavaLangString;
  private List<TroopClipPic> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Observer jdField_a_of_type_JavaUtilObserver = new VisitorTroopCardPresenter.5(this);
  private boolean jdField_a_of_type_Boolean = false;
  private List<TroopClipPic> b = new ArrayList();
  
  public VisitorTroopCardPresenter()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageObserver = new VisitorTroopCardPresenter.2(this);
  }
  
  private QBaseActivity a()
  {
    IVisitorTroopCardViewInterface localIVisitorTroopCardViewInterface = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardIVisitorTroopCardViewInterface;
    if (localIVisitorTroopCardViewInterface != null) {
      return ((VisitorTroopCardFragment)localIVisitorTroopCardViewInterface).getQBaseActivity();
    }
    return null;
  }
  
  private VisitorTroopCardFragment a()
  {
    IVisitorTroopCardViewInterface localIVisitorTroopCardViewInterface = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardIVisitorTroopCardViewInterface;
    if (localIVisitorTroopCardViewInterface != null) {
      return (VisitorTroopCardFragment)localIVisitorTroopCardViewInterface;
    }
    return null;
  }
  
  private String a(int paramInt)
  {
    String str = a().getString(2131719909);
    if (paramInt != 221002)
    {
      if (paramInt != 221020) {
        return str;
      }
      return a().getString(2131719910);
    }
    return a().getString(2131719904);
  }
  
  private void a(BatchResponse paramBatchResponse)
  {
    if (paramBatchResponse != null)
    {
      if (paramBatchResponse.result != 0) {
        return;
      }
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      try
      {
        localOIDBSSOPkg.mergeFrom(paramBatchResponse.buffer);
        a(paramBatchResponse, localOIDBSSOPkg);
        b(paramBatchResponse, localOIDBSSOPkg);
        c(paramBatchResponse, localOIDBSSOPkg);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBatchResponse)
      {
        paramBatchResponse.printStackTrace();
      }
    }
  }
  
  private void a(BatchResponse paramBatchResponse, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    if (paramBatchResponse.seq != 0) {
      return;
    }
    if (!paramOIDBSSOPkg.bytes_bodybuffer.has()) {
      return;
    }
    paramBatchResponse = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
    try
    {
      paramOIDBSSOPkg = new oidb_0x88d.RspBody();
      paramOIDBSSOPkg.mergeFrom(paramBatchResponse);
      paramBatchResponse = null;
      List localList = paramOIDBSSOPkg.stzrspgroupinfo.get();
      int j = 0;
      int i;
      if (localList == null) {
        i = 0;
      } else {
        i = localList.size();
      }
      while ((paramBatchResponse == null) && (j < i))
      {
        paramOIDBSSOPkg = (oidb_0x88d.RspGroupInfo)localList.get(j);
        if (paramOIDBSSOPkg == null)
        {
          paramOIDBSSOPkg = paramBatchResponse;
        }
        else
        {
          int k = paramOIDBSSOPkg.uint32_result.get();
          if ((k == 72) && (j == 0))
          {
            paramOIDBSSOPkg = paramBatchResponse;
            if (a() != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardIVisitorTroopCardViewInterface.a(a().getString(2131693072));
              paramOIDBSSOPkg = paramBatchResponse;
            }
          }
          else if ((k == 0) && (paramOIDBSSOPkg.stgroupinfo.has()))
          {
            paramBatchResponse = (oidb_0x88d.GroupInfo)paramOIDBSSOPkg.stgroupinfo.get();
            paramOIDBSSOPkg = paramBatchResponse;
            if (paramBatchResponse != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardIVisitorTroopCardViewInterface.a(paramBatchResponse);
              paramOIDBSSOPkg = paramBatchResponse;
            }
          }
          else
          {
            paramOIDBSSOPkg = new StringBuilder();
            paramOIDBSSOPkg.append("receive 0x88d error:");
            paramOIDBSSOPkg.append(k);
            QLog.e("vip_pretty.VisitorTroopCardFragment.VisitorTroopCardPresenter", 1, paramOIDBSSOPkg.toString());
            paramOIDBSSOPkg = paramBatchResponse;
          }
        }
        j += 1;
        paramBatchResponse = paramOIDBSSOPkg;
      }
      return;
    }
    catch (Exception paramBatchResponse)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.", 2, paramBatchResponse.toString());
      }
    }
  }
  
  private void a(List<oidb_0x899.memberlist> paramList)
  {
    ITroopMemberInfoHandler localITroopMemberInfoHandler = (ITroopMemberInfoHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMemberInfoHandlerName());
    ArrayList localArrayList1 = new ArrayList();
    Object localObject2 = (ITroopRobotService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopRobotService.class, "all");
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      localObject1 = (oidb_0x899.memberlist)localIterator.next();
      String str = String.valueOf(((oidb_0x899.memberlist)localObject1).uint64_member_uin.get());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin)) && (str.equals(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin))) {
        paramList = (List<oidb_0x899.memberlist>)localObject1;
      } else if (((ITroopRobotService)localObject2).isRobotUin(str)) {
        localArrayList1.add(localObject1);
      } else if (((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, str)) {
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
      ((oidb_0x899.memberlist)localObject1).uint64_member_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin));
      ((List)localObject2).add(0, localObject1);
    }
    catch (NumberFormatException paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, paramList.toString());
      }
    }
    ((List)localObject2).addAll(localArrayList2);
    if ((a() != null) && (a().jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView != null)) {
      a().jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView.a((List)localObject2);
    }
    ((List)localObject2).addAll(localArrayList3);
    ((List)localObject2).addAll(localArrayList1);
    paramList = new ArrayList();
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.add(String.valueOf(((oidb_0x899.memberlist)((Iterator)localObject1).next()).uint64_member_uin.get()));
    }
    if (a() != null)
    {
      localObject1 = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).saveMemberUinStringToDB(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember, a().jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, paramList);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        a().jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.memberListToShow = ((String)localObject1);
      }
    }
    localITroopMemberInfoHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, paramList, true, null);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      int i = ((Integer)paramJSONObject.get("retcode")).intValue();
      paramJSONObject = (JSONObject)paramJSONObject.get("result");
      if ((i == 0) && (paramJSONObject != null))
      {
        boolean bool = QLog.isColorLevel();
        if (bool)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkApiState onResult. retCode = ");
          localStringBuilder.append(i);
          localStringBuilder.append("\n");
          QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, localStringBuilder.toString());
        }
        b(paramJSONObject);
        c(paramJSONObject);
        i = ((Integer)paramJSONObject.get("appid")).intValue();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkApiState onResult, appid =");
          localStringBuilder.append(i);
          localStringBuilder.append("\n");
          QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, localStringBuilder.toString());
        }
        d(paramJSONObject);
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkApiState onResult ");
        localStringBuilder.append(paramJSONObject.toString());
        QLog.d("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void b(BatchResponse paramBatchResponse, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    if (paramBatchResponse.seq != 1) {
      return;
    }
    if (!paramOIDBSSOPkg.bytes_bodybuffer.has()) {
      return;
    }
    paramBatchResponse = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
    try
    {
      paramOIDBSSOPkg = new oidb_0x899.RspBody();
      paramOIDBSSOPkg.mergeFrom(paramBatchResponse);
      if (paramOIDBSSOPkg.rpt_memberlist.has())
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember) && ((a() == null) || (!a().e)))
        {
          a(paramOIDBSSOPkg.rpt_memberlist.get());
          return;
        }
        if ((a() != null) && (a().jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView != null))
        {
          a().jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView.a(paramOIDBSSOPkg.rpt_memberlist.get());
          return;
        }
      }
    }
    catch (Exception paramBatchResponse)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.", 2, paramBatchResponse.toString());
      }
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    paramJSONObject = (JSONObject)paramJSONObject.get("basics");
    if (paramJSONObject != null)
    {
      paramJSONObject = (JSONArray)paramJSONObject.get("datas");
      if (paramJSONObject != null)
      {
        int i = 0;
        while (i < paramJSONObject.length())
        {
          Object localObject = (JSONObject)paramJSONObject.get(i);
          String str1 = (String)((JSONObject)localObject).get("name");
          int j = ((Integer)((JSONObject)localObject).get("state")).intValue();
          String str2 = (String)((JSONObject)localObject).get("api");
          localObject = (String)((JSONObject)localObject).get("msg");
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkApiState onResult, basics name = ");
            localStringBuilder.append(str1);
            localStringBuilder.append(" state = ");
            localStringBuilder.append(j);
            localStringBuilder.append(" api = ");
            localStringBuilder.append(str2);
            localStringBuilder.append(" msg = ");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("\n");
            QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, localStringBuilder.toString());
          }
          i += 1;
        }
      }
    }
  }
  
  private void c(BatchResponse paramBatchResponse, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    if (paramBatchResponse.seq != 2) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.getTroopMemberLevelInfo", 2, "batchOidbResp, seq=0X787");
    }
    if (!paramOIDBSSOPkg.bytes_bodybuffer.has()) {
      return;
    }
    paramBatchResponse = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
    for (;;)
    {
      try
      {
        oidb_0x787.RspBody localRspBody = new oidb_0x787.RspBody();
        localRspBody.mergeFrom(paramBatchResponse);
        if (!localRspBody.uint64_group_code.has()) {
          return;
        }
        if (localRspBody.rpt_msg_level_name.isEmpty()) {
          break label519;
        }
        paramBatchResponse = localRspBody.rpt_msg_level_name.get();
        if (localRspBody.rpt_msg_level_name_new.isEmpty()) {
          break label524;
        }
        paramOIDBSSOPkg = localRspBody.rpt_msg_level_name_new.get();
        ITroopInfoService localITroopInfoService = (ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "");
        long l = localRspBody.uint64_group_code.get();
        TroopInfo localTroopInfo = localITroopInfoService.findTroopInfo(String.valueOf(l));
        if (localTroopInfo != null)
        {
          if (paramBatchResponse != null)
          {
            localTroopInfo.setTroopLevelMap787(paramBatchResponse, paramOIDBSSOPkg);
            if (localRspBody.uint32_level_name_seq.has())
            {
              i = localRspBody.uint32_level_name_seq.get();
              localTroopInfo.dwGroupLevelSeq = i;
              if (QLog.isColorLevel())
              {
                paramBatchResponse = new StringBuilder();
                paramBatchResponse.append("levelMap seq=");
                paramBatchResponse.append(i);
                QLog.d("Q.getTroopMemberLevelInfo", 2, paramBatchResponse.toString());
              }
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("Q.getTroopMemberLevelInfo", 2, "has levelMap but no seq");
            }
          }
          localTroopInfo.ownerNameShow = localRspBody.bytes_owner_name.get().toStringUtf8();
          localTroopInfo.adminNameShow = localRspBody.bytes_admin_name.get().toStringUtf8();
          boolean bool = localRspBody.uint32_sys_show_flag.has();
          int k = -1;
          if (!bool) {
            break label529;
          }
          localTroopInfo.cGroupRankSysFlag = ((byte)localRspBody.uint32_sys_show_flag.get());
          i = localTroopInfo.cGroupRankSysFlag;
          if (!localRspBody.uint32_user_show_flag.has()) {
            break label534;
          }
          localTroopInfo.cGroupRankUserFlag = ((byte)localRspBody.uint32_user_show_flag.get());
          j = localTroopInfo.cGroupRankUserFlag;
          if (localRspBody.uint32_user_show_flag_new.has())
          {
            localTroopInfo.cNewGroupRankUserFlag = ((byte)localRspBody.uint32_user_show_flag_new.get());
            k = localTroopInfo.cNewGroupRankUserFlag;
          }
          if (QLog.isColorLevel())
          {
            paramBatchResponse = new StringBuilder();
            paramBatchResponse.append(l);
            paramBatchResponse.append(", sysFlag:");
            paramBatchResponse.append(i);
            paramBatchResponse.append(", userFlag:");
            paramBatchResponse.append(j);
            paramBatchResponse.append(",newUserFlag:");
            paramBatchResponse.append(k);
            QLog.d("Q.getTroopMemberLevelInfo", 2, paramBatchResponse.toString());
          }
          ThreadManager.post(new VisitorTroopCardPresenter.10(this, localITroopInfoService, localTroopInfo), 8, null, false);
          return;
        }
      }
      catch (Exception paramBatchResponse)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.getTroopMemberLevelInfo", 2, paramBatchResponse.toString());
        }
      }
      return;
      label519:
      paramBatchResponse = null;
      continue;
      label524:
      paramOIDBSSOPkg = null;
      continue;
      label529:
      int i = -1;
      continue;
      label534:
      int j = -1;
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    paramJSONObject = (JSONObject)paramJSONObject.get("friendlink");
    if (paramJSONObject != null)
    {
      paramJSONObject = (JSONArray)paramJSONObject.get("datas");
      if (paramJSONObject != null)
      {
        int i = 0;
        while (i < paramJSONObject.length())
        {
          Object localObject = (JSONObject)paramJSONObject.get(i);
          String str1 = (String)((JSONObject)localObject).get("name");
          int j = ((Integer)((JSONObject)localObject).get("state")).intValue();
          String str2 = (String)((JSONObject)localObject).get("api");
          localObject = (String)((JSONObject)localObject).get("msg");
          if (("add_group".equals(str2)) && (j != 1)) {
            this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardIVisitorTroopCardViewInterface.aQ_();
          }
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkApiState onResult, friendlink name = ");
            localStringBuilder.append(str1);
            localStringBuilder.append(" state = ");
            localStringBuilder.append(j);
            localStringBuilder.append(" api = ");
            localStringBuilder.append(str2);
            localStringBuilder.append(" msg= ");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("\n");
            QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, localStringBuilder.toString());
          }
          i += 1;
        }
      }
    }
  }
  
  private void d(JSONObject paramJSONObject)
  {
    paramJSONObject = (JSONObject)paramJSONObject.get("qqpay");
    if (paramJSONObject != null)
    {
      paramJSONObject = (JSONArray)paramJSONObject.get("datas");
      if (paramJSONObject != null)
      {
        int i = 0;
        while (i < paramJSONObject.length())
        {
          Object localObject = (JSONObject)paramJSONObject.get(i);
          String str1 = (String)((JSONObject)localObject).get("name");
          int j = ((Integer)((JSONObject)localObject).get("state")).intValue();
          String str2 = (String)((JSONObject)localObject).get("api");
          localObject = (String)((JSONObject)localObject).get("msg");
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkApiState onResult, qqpay name = ");
            localStringBuilder.append(str1);
            localStringBuilder.append(" state = ");
            localStringBuilder.append(j);
            localStringBuilder.append(" api = ");
            localStringBuilder.append(str2);
            localStringBuilder.append(" msg= ");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("\n");
            QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, localStringBuilder.toString());
          }
          i += 1;
        }
      }
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.a(this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController$OnGotoBigPicListener);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener);
  }
  
  private void e(JSONObject paramJSONObject)
  {
    if (a() != null)
    {
      if (paramJSONObject == null) {
        return;
      }
      try
      {
        paramJSONObject = (JSONObject)paramJSONObject.get("data");
        if (paramJSONObject == null) {
          return;
        }
        paramJSONObject = (JSONObject)paramJSONObject.get("key");
        if (paramJSONObject == null) {
          return;
        }
        int i = ((Integer)paramJSONObject.get("retCode")).intValue();
        paramJSONObject = (String)paramJSONObject.get("retMsg");
        if (i == 0)
        {
          if (a() != null) {
            a().c(true);
          }
          VisitorTroopCardReport.a(9, new Object());
        }
        else
        {
          localObject = a(i);
          this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardIVisitorTroopCardViewInterface.c((String)localObject);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("joinGroup onResult retCode = ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(" retMsg = ");
          ((StringBuilder)localObject).append(paramJSONObject);
          QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, ((StringBuilder)localObject).toString());
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        Object localObject;
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardIVisitorTroopCardViewInterface.c(a().getString(2131719909));
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("joinGroup onResult ");
          ((StringBuilder)localObject).append(paramJSONObject.toString());
          QLog.e("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null) {
      ((IFaceDecoder)localObject).setDecodeTaskCompletionListener(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener = null;
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController;
    if (localObject != null) {
      ((TroopPhotoController)localObject).a(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController$OnGotoBigPicListener = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = null;
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopAvatarObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopAvatarObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver);
  }
  
  protected Drawable a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null)
    {
      Bitmap localBitmap = ((IFaceDecoder)localObject).getBitmapFromCache(4, paramString);
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
    else
    {
      localObject = null;
    }
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = BaseImageUtil.f();
    }
    return new BitmapDrawable(paramString);
  }
  
  public void a()
  {
    f();
    h();
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController;
    if (localObject != null) {
      ((TroopPhotoController)localObject).f();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger;
    if (localObject != null)
    {
      ((TroopAvatarManger)localObject).b(this.jdField_a_of_type_JavaUtilObserver);
      this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger.a();
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardIVisitorTroopCardViewInterface = null;
  }
  
  void a(Bundle paramBundle, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController$OnGotoBigPicListener != null)
    {
      paramBundle.putInt("troop_auth_submit_time", this.jdField_a_of_type_Int);
      paramBundle.putBoolean("troop_info_is_member", paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController$OnGotoBigPicListener.b(paramBundle);
    }
  }
  
  public void a(IVisitorTroopCardViewInterface paramIVisitorTroopCardViewInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardIVisitorTroopCardViewInterface = paramIVisitorTroopCardViewInterface;
    if (a() == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = a().jdField_a_of_type_ComTencentCommonAppAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData = a().jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger = new TroopAvatarManger(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, TroopUploadingTask.class, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger.a(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController = new TroopAvatarController(a(), a(), this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    e();
    g();
  }
  
  void a(String paramString)
  {
    TroopAvatarManger localTroopAvatarManger = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger;
    if (localTroopAvatarManger != null) {
      localTroopAvatarManger.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardIVisitorTroopCardViewInterface != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      if (localObject == null) {
        return;
      }
      localObject = (ITroopMngHandler)((AppInterface)localObject).getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName());
      if (localObject != null) {
        try
        {
          long l = Long.parseLong(paramString);
          this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardIVisitorTroopCardViewInterface.c();
          ((ITroopMngHandler)localObject).a(l, paramInt);
          return;
        }
        catch (Exception paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, paramString.toString());
          }
        }
      }
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    TroopPhotoController localTroopPhotoController = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController;
    if (localTroopPhotoController != null) {
      localTroopPhotoController.a(paramString1, paramString2);
    }
  }
  
  void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData == null) {
        return;
      }
      this.jdField_a_of_type_JavaLangString = paramString2;
      if ((!TextUtils.isEmpty(paramString3)) && (!paramString3.equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount())))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardIVisitorTroopCardViewInterface.aQ_();
        return;
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = (OpenID)((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getOpenIDFromCacheAndDB(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString1);
        if (paramString2 == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardIVisitorTroopCardViewInterface.c();
          this.jdField_a_of_type_AndroidOsHandler = new Handler();
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VisitorTroopCardPresenter.1(this), 3000L);
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageObserver);
          ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getOpenID(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString1);
          return;
        }
        if (!this.jdField_a_of_type_JavaLangString.equals(paramString2.openID)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardIVisitorTroopCardViewInterface.aQ_();
        }
      }
    }
  }
  
  void a(List<TroopClipPic> paramList, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardIVisitorTroopCardViewInterface == null) {
        return;
      }
      TroopInfo localTroopInfo = ((ITroopInfoService)((AppInterface)localObject).getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin));
      if (QLog.isColorLevel())
      {
        if (paramList == null) {
          localObject = "null";
        } else {
          localObject = Integer.valueOf(paramList.size());
        }
        boolean bool;
        if (localTroopInfo == null) {
          bool = true;
        } else {
          bool = false;
        }
        QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, String.format("setAvatarList isServer=%b piclist=%s troopinfo=null %b", new Object[] { Boolean.valueOf(paramBoolean), localObject, Boolean.valueOf(bool) }));
      }
      ArrayList localArrayList = new ArrayList();
      localObject = paramList;
      if (localTroopInfo != null)
      {
        localObject = paramList;
        if (paramList == null)
        {
          localObject = new ArrayList();
          ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getAllPicFromDb((List)localObject, localTroopInfo);
        }
      }
      if (localObject != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.b.clear();
        paramList = ((List)localObject).iterator();
        while (paramList.hasNext())
        {
          localObject = (TroopClipPic)paramList.next();
          if (((TroopClipPic)localObject).type == 1)
          {
            this.b.add(localObject);
          }
          else
          {
            localArrayList.add(AvatarInfo.a((TroopClipPic)localObject, null));
            this.jdField_a_of_type_JavaUtilList.add(localObject);
          }
        }
        if (this.b.size() == 0)
        {
          paramList = new TroopClipPic();
          paramList.id = AvatarInfo.jdField_a_of_type_JavaLangString;
          paramList.type = 1;
          this.b.add(paramList);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardIVisitorTroopCardViewInterface.a(false, localArrayList);
    }
  }
  
  void b()
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData != null))
    {
      if (a() == null) {
        return;
      }
      ITroopBatchInfohandler localITroopBatchInfohandler = (ITroopBatchInfohandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopBatchInfoHandlerName());
      long l = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).stringToLong(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      boolean bool;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember) && (!a().e)) {
        bool = true;
      } else {
        bool = false;
      }
      localITroopBatchInfohandler.a(l, bool, 0);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localAppInterface != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData == null) {
        return;
      }
      ((ITroopMngHandler)localAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName())).a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.getStatOption(), paramString1, paramString2, null, null);
    }
  }
  
  protected void c()
  {
    if ((a() != null) && (a().jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null))
    {
      TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
      if ((localTroopInfoData != null) && (localTroopInfoData.isMember)) {
        ThreadManager.post(new VisitorTroopCardPresenter.11(this), 5, null, false);
      }
    }
  }
  
  void d()
  {
    TroopPhotoController localTroopPhotoController = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController;
    if (localTroopPhotoController != null) {
      localTroopPhotoController.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.VisitorTroopCardPresenter
 * JD-Core Version:    0.7.0.1
 */