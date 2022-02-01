package com.tencent.mobileqq.troop.troopcard.ui;

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
  protected BaseMessageObserver b = new VisitorTroopCardPresenter.2(this);
  HttpWebCgiAsyncTask.Callback c = new VisitorTroopCardPresenter.12(this);
  private IVisitorTroopCardViewInterface d;
  private TroopPhotoController e;
  private TroopAvatarManger f;
  private IFaceDecoder g;
  private String h;
  private Handler i;
  private boolean j = false;
  private List<TroopClipPic> k = new ArrayList();
  private List<TroopClipPic> l = new ArrayList();
  private AppInterface m;
  private TroopInfoData n;
  private DecodeTaskCompletionListener o = new VisitorTroopCardPresenter.3(this);
  private TroopPhotoController.OnGotoBigPicListener p = new VisitorTroopCardPresenter.4(this);
  private Observer q = new VisitorTroopCardPresenter.5(this);
  private TroopMngObserver r = new VisitorTroopCardPresenter.6(this);
  private TroopObserver s = new VisitorTroopCardPresenter.7(this);
  private TroopSettingObserver t = new VisitorTroopCardPresenter.8(this);
  private TroopAvatarObserver u = new VisitorTroopCardPresenter.9(this);
  
  private String a(int paramInt)
  {
    String str = f().getString(2131917514);
    if (paramInt != 221002)
    {
      if (paramInt != 221020) {
        return str;
      }
      return f().getString(2131917515);
    }
    return f().getString(2131917509);
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
      int i2 = 0;
      int i1;
      if (localList == null) {
        i1 = 0;
      } else {
        i1 = localList.size();
      }
      while ((paramBatchResponse == null) && (i2 < i1))
      {
        paramOIDBSSOPkg = (oidb_0x88d.RspGroupInfo)localList.get(i2);
        if (paramOIDBSSOPkg == null)
        {
          paramOIDBSSOPkg = paramBatchResponse;
        }
        else
        {
          int i3 = paramOIDBSSOPkg.uint32_result.get();
          if ((i3 == 72) && (i2 == 0))
          {
            paramOIDBSSOPkg = paramBatchResponse;
            if (f() != null)
            {
              this.d.a(f().getString(2131890186));
              paramOIDBSSOPkg = paramBatchResponse;
            }
          }
          else if ((i3 == 0) && (paramOIDBSSOPkg.stgroupinfo.has()))
          {
            paramBatchResponse = (oidb_0x88d.GroupInfo)paramOIDBSSOPkg.stgroupinfo.get();
            paramOIDBSSOPkg = paramBatchResponse;
            if (paramBatchResponse != null)
            {
              this.d.a(paramBatchResponse);
              paramOIDBSSOPkg = paramBatchResponse;
            }
          }
          else
          {
            paramOIDBSSOPkg = new StringBuilder();
            paramOIDBSSOPkg.append("receive 0x88d error:");
            paramOIDBSSOPkg.append(i3);
            QLog.e("vip_pretty.VisitorTroopCardFragment.VisitorTroopCardPresenter", 1, paramOIDBSSOPkg.toString());
            paramOIDBSSOPkg = paramBatchResponse;
          }
        }
        i2 += 1;
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
    ITroopMemberInfoHandler localITroopMemberInfoHandler = (ITroopMemberInfoHandler)this.m.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMemberInfoHandlerName());
    ArrayList localArrayList1 = new ArrayList();
    Object localObject2 = (ITroopRobotService)this.m.getRuntimeService(ITroopRobotService.class, "all");
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      localObject1 = (oidb_0x899.memberlist)localIterator.next();
      String str = String.valueOf(((oidb_0x899.memberlist)localObject1).uint64_member_uin.get());
      if ((!TextUtils.isEmpty(this.n.troopowneruin)) && (str.equals(this.n.troopowneruin))) {
        paramList = (List<oidb_0x899.memberlist>)localObject1;
      } else if (((ITroopRobotService)localObject2).isRobotUin(str)) {
        localArrayList1.add(localObject1);
      } else if (((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(this.m, this.n.troopUin, str)) {
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
      ((oidb_0x899.memberlist)localObject1).uint64_member_uin.set(Long.parseLong(this.n.troopowneruin));
      ((List)localObject2).add(0, localObject1);
    }
    catch (NumberFormatException paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, paramList.toString());
      }
    }
    ((List)localObject2).addAll(localArrayList2);
    if ((g() != null) && (g().K != null)) {
      g().K.a((List)localObject2);
    }
    ((List)localObject2).addAll(localArrayList3);
    ((List)localObject2).addAll(localArrayList1);
    paramList = new ArrayList();
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.add(String.valueOf(((oidb_0x899.memberlist)((Iterator)localObject1).next()).uint64_member_uin.get()));
    }
    if (g() != null)
    {
      localObject1 = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).saveMemberUinStringToDB(this.m, this.n.isMember, g().X, paramList);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        g().X.memberListToShow = ((String)localObject1);
      }
    }
    localITroopMemberInfoHandler.a(this.n.troopUin, paramList, true, null);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      int i1 = ((Integer)paramJSONObject.get("retcode")).intValue();
      paramJSONObject = (JSONObject)paramJSONObject.get("result");
      if ((i1 == 0) && (paramJSONObject != null))
      {
        boolean bool = QLog.isColorLevel();
        if (bool)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkApiState onResult. retCode = ");
          localStringBuilder.append(i1);
          localStringBuilder.append("\n");
          QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, localStringBuilder.toString());
        }
        b(paramJSONObject);
        c(paramJSONObject);
        i1 = ((Integer)paramJSONObject.get("appid")).intValue();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkApiState onResult, appid =");
          localStringBuilder.append(i1);
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
        if ((this.n.isMember) && ((g() == null) || (!g().ak)))
        {
          a(paramOIDBSSOPkg.rpt_memberlist.get());
          return;
        }
        if ((g() != null) && (g().K != null))
        {
          g().K.a(paramOIDBSSOPkg.rpt_memberlist.get());
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
        int i1 = 0;
        while (i1 < paramJSONObject.length())
        {
          Object localObject = (JSONObject)paramJSONObject.get(i1);
          String str1 = (String)((JSONObject)localObject).get("name");
          int i2 = ((Integer)((JSONObject)localObject).get("state")).intValue();
          String str2 = (String)((JSONObject)localObject).get("api");
          localObject = (String)((JSONObject)localObject).get("msg");
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkApiState onResult, basics name = ");
            localStringBuilder.append(str1);
            localStringBuilder.append(" state = ");
            localStringBuilder.append(i2);
            localStringBuilder.append(" api = ");
            localStringBuilder.append(str2);
            localStringBuilder.append(" msg = ");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("\n");
            QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, localStringBuilder.toString());
          }
          i1 += 1;
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
        ITroopInfoService localITroopInfoService = (ITroopInfoService)this.m.getRuntimeService(ITroopInfoService.class, "");
        long l1 = localRspBody.uint64_group_code.get();
        TroopInfo localTroopInfo = localITroopInfoService.findTroopInfo(String.valueOf(l1));
        if (localTroopInfo != null)
        {
          if (paramBatchResponse != null)
          {
            localTroopInfo.setTroopLevelMap787(paramBatchResponse, paramOIDBSSOPkg);
            if (localRspBody.uint32_level_name_seq.has())
            {
              i1 = localRspBody.uint32_level_name_seq.get();
              localTroopInfo.dwGroupLevelSeq = i1;
              if (QLog.isColorLevel())
              {
                paramBatchResponse = new StringBuilder();
                paramBatchResponse.append("levelMap seq=");
                paramBatchResponse.append(i1);
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
          int i3 = -1;
          if (!bool) {
            break label529;
          }
          localTroopInfo.cGroupRankSysFlag = ((byte)localRspBody.uint32_sys_show_flag.get());
          i1 = localTroopInfo.cGroupRankSysFlag;
          if (!localRspBody.uint32_user_show_flag.has()) {
            break label534;
          }
          localTroopInfo.cGroupRankUserFlag = ((byte)localRspBody.uint32_user_show_flag.get());
          i2 = localTroopInfo.cGroupRankUserFlag;
          if (localRspBody.uint32_user_show_flag_new.has())
          {
            localTroopInfo.cNewGroupRankUserFlag = ((byte)localRspBody.uint32_user_show_flag_new.get());
            i3 = localTroopInfo.cNewGroupRankUserFlag;
          }
          if (QLog.isColorLevel())
          {
            paramBatchResponse = new StringBuilder();
            paramBatchResponse.append(l1);
            paramBatchResponse.append(", sysFlag:");
            paramBatchResponse.append(i1);
            paramBatchResponse.append(", userFlag:");
            paramBatchResponse.append(i2);
            paramBatchResponse.append(",newUserFlag:");
            paramBatchResponse.append(i3);
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
      int i1 = -1;
      continue;
      label534:
      int i2 = -1;
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
        int i1 = 0;
        while (i1 < paramJSONObject.length())
        {
          Object localObject = (JSONObject)paramJSONObject.get(i1);
          String str1 = (String)((JSONObject)localObject).get("name");
          int i2 = ((Integer)((JSONObject)localObject).get("state")).intValue();
          String str2 = (String)((JSONObject)localObject).get("api");
          localObject = (String)((JSONObject)localObject).get("msg");
          if (("add_group".equals(str2)) && (i2 != 1)) {
            this.d.c();
          }
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkApiState onResult, friendlink name = ");
            localStringBuilder.append(str1);
            localStringBuilder.append(" state = ");
            localStringBuilder.append(i2);
            localStringBuilder.append(" api = ");
            localStringBuilder.append(str2);
            localStringBuilder.append(" msg= ");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("\n");
            QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, localStringBuilder.toString());
          }
          i1 += 1;
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
        int i1 = 0;
        while (i1 < paramJSONObject.length())
        {
          Object localObject = (JSONObject)paramJSONObject.get(i1);
          String str1 = (String)((JSONObject)localObject).get("name");
          int i2 = ((Integer)((JSONObject)localObject).get("state")).intValue();
          String str2 = (String)((JSONObject)localObject).get("api");
          localObject = (String)((JSONObject)localObject).get("msg");
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkApiState onResult, qqpay name = ");
            localStringBuilder.append(str1);
            localStringBuilder.append(" state = ");
            localStringBuilder.append(i2);
            localStringBuilder.append(" api = ");
            localStringBuilder.append(str2);
            localStringBuilder.append(" msg= ");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("\n");
            QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, localStringBuilder.toString());
          }
          i1 += 1;
        }
      }
    }
  }
  
  private void e()
  {
    this.e.a(this.p);
    this.g.setDecodeTaskCompletionListener(this.o);
  }
  
  private void e(JSONObject paramJSONObject)
  {
    if (f() != null)
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
        int i1 = ((Integer)paramJSONObject.get("retCode")).intValue();
        paramJSONObject = (String)paramJSONObject.get("retMsg");
        if (i1 == 0)
        {
          if (g() != null) {
            g().c(true);
          }
          VisitorTroopCardReport.a(9, new Object());
        }
        else
        {
          localObject = a(i1);
          this.d.c((String)localObject);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("joinGroup onResult retCode = ");
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).append(" retMsg = ");
          ((StringBuilder)localObject).append(paramJSONObject);
          QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, ((StringBuilder)localObject).toString());
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        Object localObject;
        this.d.c(f().getString(2131917514));
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
  
  private QBaseActivity f()
  {
    IVisitorTroopCardViewInterface localIVisitorTroopCardViewInterface = this.d;
    if (localIVisitorTroopCardViewInterface != null) {
      return ((VisitorTroopCardFragment)localIVisitorTroopCardViewInterface).getQBaseActivity();
    }
    return null;
  }
  
  private VisitorTroopCardFragment g()
  {
    IVisitorTroopCardViewInterface localIVisitorTroopCardViewInterface = this.d;
    if (localIVisitorTroopCardViewInterface != null) {
      return (VisitorTroopCardFragment)localIVisitorTroopCardViewInterface;
    }
    return null;
  }
  
  private void h()
  {
    Object localObject = this.g;
    if (localObject != null) {
      ((IFaceDecoder)localObject).setDecodeTaskCompletionListener(null);
    }
    this.o = null;
    localObject = this.e;
    if (localObject != null) {
      ((TroopPhotoController)localObject).a(null);
    }
    this.p = null;
    this.c = null;
  }
  
  private void i()
  {
    this.m.addObserver(this.u);
    this.m.addObserver(this.r);
    this.m.addObserver(this.s);
    this.m.addObserver(this.t);
  }
  
  private void j()
  {
    this.m.removeObserver(this.u);
    this.m.removeObserver(this.r);
    this.m.removeObserver(this.s);
    this.m.removeObserver(this.b);
    this.m.removeObserver(this.t);
  }
  
  public void a()
  {
    h();
    j();
    Object localObject = this.i;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.g;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    localObject = this.e;
    if (localObject != null) {
      ((TroopPhotoController)localObject).e();
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((TroopAvatarManger)localObject).b(this.q);
      this.f.b();
    }
    this.m = null;
    this.n = null;
    this.d = null;
  }
  
  void a(Bundle paramBundle, boolean paramBoolean)
  {
    if (this.p != null)
    {
      paramBundle.putInt("troop_auth_submit_time", this.a);
      paramBundle.putBoolean("troop_info_is_member", paramBoolean);
      this.p.b(paramBundle);
    }
  }
  
  public void a(IVisitorTroopCardViewInterface paramIVisitorTroopCardViewInterface)
  {
    this.d = paramIVisitorTroopCardViewInterface;
    if (g() == null) {
      return;
    }
    this.m = g().al;
    this.n = g().W;
    this.f = new TroopAvatarManger(this.n.troopUin, TroopUploadingTask.class, this.m);
    this.f.a(this.q);
    this.g = ((IQQAvatarService)this.m.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.m);
    paramIVisitorTroopCardViewInterface = new Bundle();
    paramIVisitorTroopCardViewInterface.putString("troopUin", this.n.troopUin);
    paramIVisitorTroopCardViewInterface.putInt("type", 1);
    this.e = new TroopAvatarController(f(), f(), this.m, paramIVisitorTroopCardViewInterface);
    e();
    i();
  }
  
  void a(String paramString)
  {
    TroopAvatarManger localTroopAvatarManger = this.f;
    if (localTroopAvatarManger != null) {
      localTroopAvatarManger.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.d != null)
    {
      Object localObject = this.m;
      if (localObject == null) {
        return;
      }
      localObject = (ITroopMngHandler)((AppInterface)localObject).getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName());
      if (localObject != null) {
        try
        {
          long l1 = Long.parseLong(paramString);
          this.d.d();
          ((ITroopMngHandler)localObject).a(l1, paramInt);
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
    TroopPhotoController localTroopPhotoController = this.e;
    if (localTroopPhotoController != null) {
      localTroopPhotoController.b(paramString1, paramString2);
    }
  }
  
  void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.m != null)
    {
      if (this.n == null) {
        return;
      }
      this.h = paramString2;
      if ((!TextUtils.isEmpty(paramString3)) && (!paramString3.equals(this.m.getAccount())))
      {
        this.d.c();
        return;
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = (OpenID)((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getOpenIDFromCacheAndDB(this.m, paramString1);
        if (paramString2 == null)
        {
          this.d.d();
          this.i = new Handler();
          this.i.postDelayed(new VisitorTroopCardPresenter.1(this), 3000L);
          this.m.addObserver(this.b);
          ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getOpenID(this.m, paramString1);
          return;
        }
        if (!this.h.equals(paramString2.openID)) {
          this.d.c();
        }
      }
    }
  }
  
  void a(List<TroopClipPic> paramList, boolean paramBoolean)
  {
    Object localObject = this.m;
    if ((localObject != null) && (this.n != null))
    {
      if (this.d == null) {
        return;
      }
      TroopInfo localTroopInfo = ((ITroopInfoService)((AppInterface)localObject).getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(String.valueOf(this.n.troopUin));
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
        this.k.clear();
        this.l.clear();
        paramList = ((List)localObject).iterator();
        while (paramList.hasNext())
        {
          localObject = (TroopClipPic)paramList.next();
          if (((TroopClipPic)localObject).type == 1)
          {
            this.l.add(localObject);
          }
          else
          {
            localArrayList.add(AvatarInfo.a((TroopClipPic)localObject, null));
            this.k.add(localObject);
          }
        }
        if (this.l.size() == 0)
        {
          paramList = new TroopClipPic();
          paramList.id = AvatarInfo.a;
          paramList.type = 1;
          this.l.add(paramList);
        }
      }
      this.d.a(false, localArrayList);
    }
  }
  
  protected Drawable b(String paramString)
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      Bitmap localBitmap = ((IFaceDecoder)localObject).getBitmapFromCache(4, paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        localObject = localBitmap;
        if (!this.g.isPausing())
        {
          this.g.requestDecodeFace(paramString, 4, true);
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
      paramString = BaseImageUtil.k();
    }
    return new BitmapDrawable(paramString);
  }
  
  void b()
  {
    if ((this.m != null) && (this.n != null))
    {
      if (g() == null) {
        return;
      }
      ITroopBatchInfohandler localITroopBatchInfohandler = (ITroopBatchInfohandler)this.m.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopBatchInfoHandlerName());
      long l1 = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).stringToLong(this.n.troopUin);
      boolean bool;
      if ((this.n.isMember) && (!g().ak)) {
        bool = true;
      } else {
        bool = false;
      }
      localITroopBatchInfohandler.a(l1, bool, 0);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    AppInterface localAppInterface = this.m;
    if (localAppInterface != null)
    {
      if (this.n == null) {
        return;
      }
      ((ITroopMngHandler)localAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName())).a(this.n.troopUin, "", this.n.getStatOption(), paramString1, paramString2, null, null);
    }
  }
  
  protected void c()
  {
    if ((g() != null) && (g().X != null))
    {
      TroopInfoData localTroopInfoData = this.n;
      if ((localTroopInfoData != null) && (localTroopInfoData.isMember)) {
        ThreadManager.post(new VisitorTroopCardPresenter.11(this), 5, null, false);
      }
    }
  }
  
  void d()
  {
    TroopPhotoController localTroopPhotoController = this.e;
    if (localTroopPhotoController != null) {
      localTroopPhotoController.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardPresenter
 * JD-Core Version:    0.7.0.1
 */