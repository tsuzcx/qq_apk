package com.tencent.mobileqq.troop.handler;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.config.TroopAddFriendHandlerProcessorConfig;
import com.tencent.mobileqq.troop.api.handler.ITroopAddFriendHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.util.AddFriendSceneUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import tencent.im.oidb.cmd0xb01.cmd0xb01.ReqBody;
import tencent.im.oidb.cmd0xb01.cmd0xb01.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopAddFriendHandler
  extends TroopBaseHandler
  implements ITroopAddFriendHandler
{
  protected Set<String> a;
  
  public TroopAddFriendHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    TroopAddFriendHandlerProcessorConfig.a().a(paramAppInterface);
  }
  
  private void a(String paramString, long paramLong, int paramInt1, ArrayList<String> paramArrayList, int paramInt2, boolean paramBoolean)
  {
    int m = AddFriendSceneUtil.a(paramInt1);
    boolean bool = QLog.isColorLevel();
    int k = 7;
    if (bool) {
      QLog.i("TroopAddFriendHandler", 2, String.format("getTroopMemberRemark troopUin_type_reqts_size_start_bInc_servicetype= %s_%d_%d_%d_%d_%b_%d", new Object[] { paramString, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramArrayList.size()), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean), Integer.valueOf(m) }));
    }
    long l = Long.parseLong(this.appRuntime.getCurrentAccountUin());
    int j = paramArrayList.size();
    int i = j;
    if (j - paramInt2 > 20) {
      i = paramInt2 + 20;
    }
    j = i - paramInt2;
    Object localObject = new byte[j * 4 + 7];
    PkgTools.word2Byte((byte[])localObject, 0, (short)2);
    PkgTools.dWord2Byte((byte[])localObject, 2, l);
    localObject[6] = ((byte)j);
    j = paramInt2;
    while (j < i)
    {
      PkgTools.dWord2Byte((byte[])localObject, k, Long.parseLong((String)paramArrayList.get(j)));
      k += 4;
      j += 1;
    }
    localObject = makeOIDBPkg("OidbSvc.0x53c_2", 1340, m, (byte[])localObject);
    ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString);
    ((ToServiceMsg)localObject).extraData.putStringArrayList("memberUins", paramArrayList);
    ((ToServiceMsg)localObject).extraData.putInt("offsetStart", paramInt2);
    ((ToServiceMsg)localObject).extraData.putInt("offsetEnd", i);
    ((ToServiceMsg)localObject).extraData.putLong("reqTs", paramLong);
    ((ToServiceMsg)localObject).extraData.putInt("type", paramInt1);
    ((ToServiceMsg)localObject).extraData.putBoolean("bIncrement", paramBoolean);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1 = paramToServiceMsg.extraData.getLong("reqTs", 0L);
    Object localObject = paramToServiceMsg.extraData;
    int i = 0;
    int j = ((Bundle)localObject).getInt("type", 0);
    String str1 = paramToServiceMsg.extraData.getString("fromUin");
    String str2 = paramToServiceMsg.extraData.getString("troopUin");
    int k = paramToServiceMsg.extraData.getInt("startOffset");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("bIncrement");
    localObject = paramToServiceMsg.extraData.getStringArrayList("uins");
    boolean bool1;
    if (k >= ((List)localObject).size()) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HashMap localHashMap = new HashMap(50);
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramFromServiceMsg = (byte[])paramObject;
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0))
      {
        paramToServiceMsg.uint32_result.get();
        paramFromServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramFromServiceMsg.getInt();
        paramObject = Short.valueOf(paramFromServiceMsg.getShort());
        paramToServiceMsg = (ToServiceMsg)localObject;
        while (i < paramObject.shortValue())
        {
          long l2 = paramFromServiceMsg.getInt();
          s = paramFromServiceMsg.getShort();
          localHashMap.put(Long.toString(l2 & 0xFFFFFFFF), Integer.valueOf(Short.valueOf(s).shortValue()));
          i += 1;
        }
        TroopAddFriendHandlerProcessorConfig.a().a(this.appRuntime, str2, localHashMap);
        short s = paramFromServiceMsg.getShort();
        if (QLog.isColorLevel()) {
          QLog.i("TroopAddFriendHandler", 2, String.format("handleBatchReqMemberCmnFrds sucNum:%d, failNum:%d", new Object[] { paramObject, Short.valueOf(s) }));
        }
        notifyUI(TroopObserver.TYPE_NOTIFY_BATCH_REQ_COMMFRDS, true, new Object[] { str2, str1, Long.valueOf(l1), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2), localHashMap, paramToServiceMsg });
        if (!bool1) {
          a(str2, paramToServiceMsg, k, l1, j, bool2);
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          if (paramToServiceMsg == null) {
            i = -1;
          } else {
            i = paramToServiceMsg.uint32_result.get();
          }
          QLog.i("TroopAddFriendHandler", 2, String.format("handleBatchReqMemberCmnFrds result:%d", new Object[] { Integer.valueOf(i) }));
        }
        notifyUI(TroopObserver.TYPE_NOTIFY_BATCH_REQ_COMMFRDS, false, new Object[] { str2, str1, Long.valueOf(l1), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2), null, null });
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAddFriendHandler", 2, String.format("handleBatchReqMemberCmnFrds result2:%d", new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()) }));
      }
      notifyUI(TroopObserver.TYPE_NOTIFY_BATCH_REQ_COMMFRDS, false, new Object[] { str2, str1, Long.valueOf(l1), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2), null, null });
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1 = paramToServiceMsg.extraData.getString("troopUin");
    String str2 = paramToServiceMsg.extraData.getString("troopCode");
    long l = paramToServiceMsg.extraData.getLong("reqTs", 0L);
    int k = paramToServiceMsg.extraData.getInt("type", 0);
    paramToServiceMsg = new cmd0xb01.RspBody();
    int m = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    int j = -1;
    int i;
    if (m == 0)
    {
      if (paramToServiceMsg.uint32_result.has())
      {
        j = paramToServiceMsg.uint32_result.get();
        if (j == 0) {
          i = 1;
        } else {
          i = 2;
        }
        if (j == 2)
        {
          double d = paramToServiceMsg.double_density.get();
          ReportController.b(this.appRuntime, "dc00899", "Grp_addFrd", "", "nonGreyTip", "density", 0, 0, str1, "", String.valueOf(d), "");
        }
      }
      else
      {
        i = 0;
      }
      paramToServiceMsg = PreferenceManager.getDefaultSharedPreferences(this.appRuntime.getApp());
      paramFromServiceMsg = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_security_check_flag", this.appRuntime.getCurrentAccountUin(), str1 });
      paramToServiceMsg.edit().putInt(paramFromServiceMsg, i).apply();
    }
    else
    {
      i = 0;
    }
    int n = TroopObserver.TYPE_BATCH_ADD_FRIEND_SECURITY_CHECK;
    boolean bool;
    if (m == 0) {
      bool = true;
    } else {
      bool = false;
    }
    notifyUI(n, bool, new Object[] { Integer.valueOf(i), str1, str2, Long.valueOf(l), Integer.valueOf(k) });
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopAddFriendHandler", 4, String.format(Locale.getDefault(), "handleBatchAddFriendSecurityCheck %s_%d_%d result: %s_%s_%s", new Object[] { str1, Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j) }));
    }
  }
  
  protected String a()
  {
    return "TroopAddFriendHandler";
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("troopUin");
    long l1 = paramToServiceMsg.extraData.getLong("reqTs", 0L);
    boolean bool = paramToServiceMsg.extraData.getBoolean("bIncrement", false);
    int i1 = paramToServiceMsg.extraData.getInt("type", 0);
    paramObject = "TroopAddFriendHandler";
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      Object localObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = (FromServiceMsg)localObject;
      }
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
      {
        i = paramFromServiceMsg.uint32_result.get();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleGetTroopMemberRemark ret=");
          ((StringBuilder)localObject).append(i);
          QLog.i("TroopAddFriendHandler", 2, ((StringBuilder)localObject).toString());
        }
        if ((i == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
        {
          byte[] arrayOfByte = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
          i = arrayOfByte[0];
          if (i != 0)
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("handleGetTroopMemberRemark error! cResult=");
            paramToServiceMsg.append(i);
            QLog.e("TroopAddFriendHandler", 1, paramToServiceMsg.toString());
            return;
          }
          i = arrayOfByte[1];
          HashMap localHashMap = new HashMap();
          int k = 0;
          int j = 2;
          paramFromServiceMsg = paramObject;
          while (k < i)
          {
            long l2 = PkgTools.getLongData(arrayOfByte, j);
            j += 4;
            int m = arrayOfByte[j];
            paramObject = null;
            j += 1;
            int n = 0;
            while (n < m)
            {
              int i2 = arrayOfByte[j];
              int i3 = j + 1;
              j = arrayOfByte[i3];
              i3 += 1;
              localObject = PkgTools.getUTFString(arrayOfByte, i3, j);
              j = i3 + j;
              if (TextUtils.isEmpty(paramObject)) {
                if (QLog.isColorLevel())
                {
                  paramObject = new StringBuilder();
                  paramObject.append("handleGetTroopMemberRemark uin=");
                  paramObject.append(l2);
                  paramObject.append(" cTag=");
                  paramObject.append(i2);
                  paramObject.append(" sRemark=");
                  paramObject.append((String)localObject);
                  QLog.i(paramFromServiceMsg, 2, paramObject.toString());
                  paramObject = localObject;
                }
                else
                {
                  paramObject = localObject;
                }
              }
              n += 1;
            }
            if (!TextUtils.isEmpty(paramObject)) {
              localHashMap.put(String.valueOf(l2), paramObject);
            }
            k += 1;
          }
          i = paramToServiceMsg.extraData.getInt("offsetStart");
          j = paramToServiceMsg.extraData.getInt("offsetEnd");
          paramToServiceMsg = paramToServiceMsg.extraData.getStringArrayList("memberUins");
          paramObject = new ArrayList();
          paramObject.addAll(paramToServiceMsg.subList(i, j));
          TroopAddFriendHandlerProcessorConfig.a().a(this.appRuntime, str, localHashMap, paramObject);
          if (j < paramToServiceMsg.size())
          {
            a(str, l1, i1, paramToServiceMsg, j, bool);
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i(paramFromServiceMsg, 2, "handleGetTroopMemberRemark ... ok, that's all.");
            }
            notifyUI(TroopObserver.TYPE_NOTIFY_BATCH_REQ_REMARK, true, new Object[] { str, Long.valueOf(l1), Integer.valueOf(i1), Boolean.valueOf(bool) });
          }
          i = 1;
          break label647;
        }
      }
    }
    paramFromServiceMsg = "TroopAddFriendHandler";
    int i = 0;
    label647:
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i(paramFromServiceMsg, 2, "handleGetTroopMemberRemark failed");
      }
      notifyUI(TroopObserver.TYPE_NOTIFY_BATCH_REQ_REMARK, false, new Object[] { str, Long.valueOf(l1), Integer.valueOf(i1), Boolean.valueOf(bool) });
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    a(paramString, paramLong, paramInt, paramArrayList, 0, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    long l1;
    try
    {
      l1 = Long.parseLong(this.appRuntime.getAccount());
      try
      {
        l2 = Long.parseLong(paramString2);
      }
      catch (Throwable localThrowable1) {}
      localThrowable2.printStackTrace();
    }
    catch (Throwable localThrowable2)
    {
      l1 = 0L;
    }
    long l2 = 0L;
    if ((l1 != 0L) && (l2 != 0L))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopAddFriendHandler", 4, String.format(Locale.getDefault(), "batchAddFriendSecurityCheck %s_%d_%d", new Object[] { Long.valueOf(l2), Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
      }
      Object localObject = new cmd0xb01.ReqBody();
      ((cmd0xb01.ReqBody)localObject).uint64_uin.set(l1);
      ((cmd0xb01.ReqBody)localObject).uint64_group_uin.set(l2);
      localObject = makeOIDBPkg("OidbSvc.0xb01", 2817, 1, ((cmd0xb01.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString1);
      ((ToServiceMsg)localObject).extraData.putString("troopCode", paramString2);
      ((ToServiceMsg)localObject).extraData.putLong("reqTs", paramLong);
      ((ToServiceMsg)localObject).extraData.putInt("type", paramInt);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopAddFriendHandler", 4, "batchAddFriendSecurityCheck invalid param!");
    }
  }
  
  public void a(String paramString, List<String> paramList, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopAddFriendHandler", 2, String.format("batchReqMemberCmnFrds %s_%d_%d_%d_%d_%b", new Object[] { paramString, Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(paramList.size()), Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean) }));
    }
    int j = paramInt1 + 50;
    int i = j;
    if (j > paramList.size()) {
      i = paramList.size();
    }
    Object localObject2 = paramList.subList(paramInt1, i);
    j = ((List)localObject2).size();
    if (j == 0) {
      return;
    }
    String str = this.appRuntime.getCurrentUin();
    Object localObject1 = ByteBuffer.allocate(j * 4 + 6);
    ((ByteBuffer)localObject1).putInt((int)Long.parseLong(str));
    ((ByteBuffer)localObject1).putShort((short)j);
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      ((ByteBuffer)localObject1).putInt((int)Long.parseLong((String)((List)localObject2).get(paramInt1)));
      paramInt1 += 1;
    }
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1069);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(4);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject1).array()));
    localObject1 = createToServiceMsg("OidbSvc.0x42d_4");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putLong("reqTs", paramLong);
    ((ToServiceMsg)localObject1).extraData.putInt("type", paramInt2);
    ((ToServiceMsg)localObject1).extraData.putString("fromUin", str);
    ((ToServiceMsg)localObject1).extraData.putString("troopUin", paramString);
    ((ToServiceMsg)localObject1).extraData.putInt("startOffset", i);
    ((ToServiceMsg)localObject1).extraData.putBoolean("bIncrement", paramBoolean);
    ((ToServiceMsg)localObject1).extraData.putStringArrayList("uins", (ArrayList)paramList);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public Set<String> getCommandList()
  {
    if (this.a == null)
    {
      this.a = new HashSet();
      this.a.add("OidbSvc.0x53c_2");
      this.a.add("OidbSvc.0x42d_4");
      this.a.add("OidbSvc.0xb01");
    }
    return this.a;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(str))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("cmdfilter error=");
          paramToServiceMsg.append(str);
          QLog.d("TroopAddFriendHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if (!a().equals(paramToServiceMsg.extraData.getString("REQ_TAG")))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("REQ_TAG doesn't match. cmd:  ");
          paramToServiceMsg.append(str);
          QLog.d("TroopAddFriendHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("OidbSvc.0x53c_2".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x42d_4".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xb01".equals(paramFromServiceMsg.getServiceCmd())) {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAddFriendHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopAddFriendHandler
 * JD-Core Version:    0.7.0.1
 */