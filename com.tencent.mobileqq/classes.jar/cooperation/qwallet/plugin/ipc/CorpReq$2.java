package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import bhjx;
import bhlg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x787.oidb_0x787.MemberLevelInfo;
import tencent.im.oidb.cmd0x787.oidb_0x787.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class CorpReq$2
  implements BusinessObserver
{
  CorpReq$2(CorpReq paramCorpReq, CorpResp paramCorpResp, QQAppInterface paramQQAppInterface, ArrayList paramArrayList) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CorpReq.troop.get_troop_mem_card_4_tentpay", 2, "onReceive success=" + paramBoolean + " troopUin=" + this.val$resp.troopUin);
    }
    if (paramBoolean) {}
    label771:
    label805:
    for (;;)
    {
      Object localObject3;
      try
      {
        Object localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).mergeFrom(paramBundle.getByteArray("data"));
        Object localObject2;
        Object localObject4;
        Object localObject6;
        Object localObject5;
        Object localObject7;
        if (((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.has())
        {
          localObject1 = ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.get().toByteArray();
          paramBundle = new oidb_0x787.RspBody();
          paramBundle.mergeFrom((byte[])localObject1);
          localObject3 = new StringBuffer();
          paramBundle = paramBundle.rpt_msg_member_level_info.get();
          localObject2 = new HashMap(paramBundle.size());
          localObject4 = paramBundle.iterator();
          if (((Iterator)localObject4).hasNext())
          {
            localObject6 = (oidb_0x787.MemberLevelInfo)((Iterator)localObject4).next();
            localObject1 = "";
            localObject5 = String.valueOf(((oidb_0x787.MemberLevelInfo)localObject6).uint64_uin.get());
            if (QLog.isColorLevel())
            {
              ((StringBuffer)localObject3).append(" uin=");
              ((StringBuffer)localObject3).append(((String)localObject5).substring(0, 4));
            }
            localObject7 = ((oidb_0x787.MemberLevelInfo)localObject6).str_name.get().toByteArray();
            paramBundle = (Bundle)localObject1;
            if (localObject7 != null)
            {
              paramBundle = (Bundle)localObject1;
              if (localObject7.length > 0) {
                paramBundle = new String((byte[])localObject7);
              }
            }
            localObject1 = ((oidb_0x787.MemberLevelInfo)localObject6).bytes_nick_name.get().toByteArray();
            if ((localObject1 == null) || (localObject1.length <= 0) || (!TextUtils.isEmpty(paramBundle))) {
              break label805;
            }
            localObject1 = new String((byte[])localObject1);
            paramBundle = (Bundle)localObject1;
            if (QLog.isColorLevel())
            {
              ((StringBuffer)localObject3).append(" nick=");
              ((StringBuffer)localObject3).append(bhjx.a((String)localObject1));
              paramBundle = (Bundle)localObject1;
            }
            ((Map)localObject2).put(localObject5, paramBundle);
            continue;
          }
        }
        this.val$resp.troopMemNickJson = ((JSONArray)localObject4).toString();
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.w("CorpReq.troop.get_troop_mem_card_4_tentpay", 2, "handleGetTroopCardDefaultNickBatch ex", paramBundle);
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.d("CorpReq.troop.get_troop_mem_card_4_tentpay", 2, ((StringBuffer)localObject3).toString());
        }
        localObject3 = new Bundle();
        if (!TextUtils.isEmpty(this.this$0.memUin))
        {
          this.val$resp.memUin = this.this$0.memUin;
          localObject1 = (String)((Map)localObject2).get(this.this$0.memUin);
          localObject2 = this.val$resp;
          paramBundle = (Bundle)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramBundle = bhlg.h(this.val$app, this.this$0.troopUin, this.this$0.memUin);
          }
          ((CorpResp)localObject2).memNick = paramBundle;
          this.val$resp.toBundle((Bundle)localObject3);
          this.this$0.doCallback((Bundle)localObject3);
          return;
        }
        try
        {
          localObject4 = new JSONArray(this.val$resp.troopMemNickJson);
          localObject5 = this.val$memUins2Req.iterator();
          if (!((Iterator)localObject5).hasNext()) {
            break label771;
          }
          localObject7 = (String)((Iterator)localObject5).next();
          localObject6 = new JSONObject();
          localObject1 = (String)((Map)localObject2).get(localObject7);
          ((JSONObject)localObject6).put("memUin", localObject7);
          paramBundle = (Bundle)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramBundle = bhlg.h(this.val$app, this.this$0.troopUin, (String)localObject7);
          }
          ((JSONObject)localObject6).put("memNick", paramBundle);
          ((JSONArray)localObject4).put(localObject6);
          continue;
          if (!QLog.isColorLevel()) {
            continue;
          }
        }
        catch (JSONException paramBundle) {}
        QLog.d("CorpReq.troop.get_troop_mem_card_4_tentpay", 2, "onBatchTroopCardDefaultNick JSONException resp.troopMemNickJson=" + this.val$resp.troopMemNickJson);
        continue;
      }
      finally
      {
        if (QLog.isColorLevel()) {
          QLog.d("CorpReq.troop.get_troop_mem_card_4_tentpay", 2, "handleGetTroopCardDefaultNickBatch over time=" + System.currentTimeMillis());
        }
      }
      this.val$resp.toBundle((Bundle)localObject3);
      this.this$0.doCallback((Bundle)localObject3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.CorpReq.2
 * JD-Core Version:    0.7.0.1
 */