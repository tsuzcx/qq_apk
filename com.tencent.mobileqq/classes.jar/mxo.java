import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.handler.UserInfoHandler.1;
import com.tencent.avgame.ipc.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;

public class mxo
  extends mxl
{
  private final MQLruCache<String, Object> jdField_a_of_type_AndroidSupportV4UtilMQLruCache = BaseApplicationImpl.sImageCache;
  private final QQLruCache<String, UserInfo> jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(10001, 50, 10);
  private final QQLruCache<String, String> b = new QQLruCache(10001, 50, 10);
  
  protected mxo(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private new a()
  {
    new localnew = null;
    if ((this.mApp instanceof AVGameAppInterface)) {
      localnew = ((AVGameAppInterface)this.mApp).a();
    }
    return localnew;
  }
  
  private void a(int paramInt, List<String> paramList)
  {
    if (paramList.size() == 0) {}
    for (;;)
    {
      return;
      Object localObject = new oidb_0x5eb.ReqBody();
      ArrayList localArrayList = new ArrayList(paramList.size());
      try
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add(Long.valueOf(Long.parseLong((String)localIterator.next())));
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception localException)
      {
        if (localArrayList.size() == 0)
        {
          QLog.d("UserInfoHandler", 1, "getNicksFromSvr uins empty return.");
          return;
        }
        ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.set(localArrayList);
        ((oidb_0x5eb.ReqBody)localObject).uint32_req_nick.set(1);
        localObject = makeOIDBPkg("OidbSvc.0x5eb_20002", 1515, 22, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
        ((ToServiceMsg)localObject).extraData.putStringArrayList("uins", (ArrayList)paramList);
        ((ToServiceMsg)localObject).extraData.putInt("uinType", paramInt);
        sendPbReq((ToServiceMsg)localObject);
      }
    }
    QLog.i("UserInfoHandler", 2, "getNicksFromSvr " + paramList.size());
  }
  
  private void a(int paramInt, List<String> arg2, HashMap<String, String> paramHashMap)
  {
    Object localObject = a();
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("UserInfoHandler", 2, String.format("getNicksRemote uins.size=%d", new Object[] { Integer.valueOf(???.size()) }));
      }
      ((new)localObject).a(paramInt, ???, paramHashMap);
      if (paramHashMap.size() > 0) {
        synchronized (this.b)
        {
          localObject = paramHashMap.keySet().iterator();
          if (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            this.b.put(str, paramHashMap.get(str));
          }
        }
      }
    }
  }
  
  private void a(HashMap<String, String> paramHashMap, List<String> paramList1, List<String> paramList2)
  {
    HashMap localHashMap = new HashMap(paramList1.size());
    a(0, paramList1, localHashMap);
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      String str = (String)paramList1.next();
      if (localHashMap.containsKey(str)) {
        paramHashMap.put(str, localHashMap.get(str));
      } else {
        paramList2.add(str);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("UserInfoHandler", 2, String.format("getNicks from main = %s", new Object[] { paramHashMap }));
    }
  }
  
  private void a(List<String> paramList1, HashMap<String, String> paramHashMap, List<String> paramList2)
  {
    for (;;)
    {
      String str1;
      String str2;
      synchronized (this.b)
      {
        paramList1 = paramList1.iterator();
        if (!paramList1.hasNext()) {
          break;
        }
        str1 = (String)paramList1.next();
        str2 = (String)this.b.get(str1);
        if (str2 == null) {
          paramList2.add(str1);
        }
      }
      paramHashMap.put(str1, str2);
    }
    if (QLog.isColorLevel()) {
      QLog.i("UserInfoHandler", 2, String.format("getNicks from cache = %s", new Object[] { paramHashMap }));
    }
  }
  
  public static UserInfo b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = myk.a().a();
    if (localObject != null)
    {
      localObject = (mxo)((AVGameAppInterface)localObject).a(2);
      if (localObject != null) {
        return ((mxo)localObject).a(paramString);
      }
    }
    return null;
  }
  
  public Bitmap a(int paramInt1, String paramString, byte paramByte, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {}
    try
    {
      paramString = paramInt2 + "_" + paramString + "_" + paramInt1 + "_" + paramByte;
      paramString = this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
      localObject1 = localObject2;
      if ((paramString instanceof Bitmap)) {
        localObject1 = (Bitmap)paramString;
      }
      return localObject1;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
  }
  
  public Bitmap a(String paramString, byte paramByte)
  {
    boolean bool = true;
    Bitmap localBitmap2 = a(1, paramString, paramByte, 200);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = b(1, paramString, paramByte, 200);
    }
    if (localBitmap1 == null)
    {
      if (paramByte == 4) {}
      for (;;)
      {
        return bhmq.a(bool);
        bool = false;
      }
    }
    return localBitmap1;
  }
  
  public UserInfo a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = paramInt + "_" + paramString;
        paramString = (UserInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
        return paramString;
      }
      catch (Throwable paramString)
      {
        return null;
      }
    }
    return null;
  }
  
  public UserInfo a(String paramString)
  {
    UserInfo localUserInfo2 = a(0, paramString);
    UserInfo localUserInfo1 = localUserInfo2;
    if (localUserInfo2 == null) {
      localUserInfo1 = b(0, paramString);
    }
    return localUserInfo1;
  }
  
  public HashMap<String, String> a(List<String> paramList)
  {
    HashMap localHashMap = new HashMap(paramList.size());
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramList.size() > 0) {
      a(paramList, localHashMap, localArrayList1);
    }
    if (localArrayList1.size() > 0) {
      ThreadManager.postImmediately(new UserInfoHandler.1(this, new HashMap(localArrayList1.size()), localArrayList1, localArrayList2), null, true);
    }
    return localHashMap;
  }
  
  public void a(int paramInt, String paramString, UserInfo paramUserInfo)
  {
    if (paramUserInfo != null) {}
    try
    {
      String str = paramInt + "_" + paramString;
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(str, paramUserInfo);
      notifyUI(0, true, new Object[] { Integer.valueOf(paramInt), paramString, paramUserInfo });
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          localThrowable.printStackTrace();
          QLog.i("UserInfoHandler", 2, "updateUserInfo", localThrowable);
        }
      }
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_0x5eb.RspBody();
    int j = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    int k = paramToServiceMsg.extraData.getInt("uinType");
    paramFromServiceMsg = paramToServiceMsg.extraData.getStringArrayList("uins");
    paramToServiceMsg = new HashMap(paramFromServiceMsg.size());
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (j == 0) {}
    for (;;)
    {
      int i;
      try
      {
        if (((oidb_0x5eb.RspBody)localObject).rpt_msg_uin_data.size() != paramFromServiceMsg.size()) {
          break label316;
        }
        paramObject = ((oidb_0x5eb.RspBody)localObject).rpt_msg_uin_data.get();
        paramFromServiceMsg = this.b;
        i = 0;
        try
        {
          if (i >= paramObject.size()) {
            break label279;
          }
          long l = ((oidb_0x5eb.UdcUinData)paramObject.get(i)).uint64_uin.get();
          localObject = ((oidb_0x5eb.UdcUinData)paramObject.get(i)).bytes_nick.get().toStringUtf8();
          if ((l <= 0L) || (localObject == null)) {
            break label322;
          }
          String str = Long.toString(l);
          paramToServiceMsg.put(str, localObject);
          this.b.put(str, localObject);
        }
        finally {}
        if (bool1) {
          break label236;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        bool1 = bool2;
      }
      notifyUI(2, false, new Object[] { Integer.valueOf(k), null });
      label236:
      if (QLog.isColorLevel()) {
        QLog.i("UserInfoHandler", 2, String.format("handleGetNicksFromSvr suc=%b result=%d nicks=%s", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(j), paramToServiceMsg }));
      }
      return;
      label279:
      label316:
      for (bool1 = true;; bool1 = false)
      {
        try
        {
          notifyUI(2, true, new Object[] { Integer.valueOf(k), paramToServiceMsg });
        }
        catch (Exception paramFromServiceMsg)
        {
          bool1 = true;
        }
        break;
      }
      label322:
      i += 1;
    }
  }
  
  public Bitmap b(int paramInt1, String paramString, byte paramByte, int paramInt2)
  {
    Object localObject = a();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((new)localObject).a(paramInt1, paramString, paramByte, paramInt2))
    {
      if (localObject != null) {}
      try
      {
        paramString = paramInt2 + "_" + paramString + "_" + paramInt1 + "_" + paramByte;
        this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramString, localObject);
        return localObject;
      }
      catch (Throwable paramString) {}
    }
    return localObject;
  }
  
  public UserInfo b(int paramInt, String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (TextUtils.isEmpty(paramString)) {
      return localObject2;
    }
    localObject2 = a();
    if (localObject2 == null) {}
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        break;
      }
      try
      {
        paramString = paramInt + "_" + paramString;
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramString, localObject1);
        return localObject1;
      }
      catch (Throwable paramString)
      {
        localObject2 = localObject1;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      paramString.printStackTrace();
      QLog.i("UserInfoHandler", 2, "getUserInfoFromRemote", paramString);
      return localObject1;
      localObject1 = ((new)localObject2).a(paramInt, paramString);
    }
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    boolean bool2 = false;
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      String[] arrayOfString = nho.d;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (!TextUtils.isEmpty(str)) {
          this.allowCmdSet.add(str);
        }
        i += 1;
      }
    }
    boolean bool1 = bool2;
    if (this.allowCmdSet != null)
    {
      bool1 = bool2;
      if (!this.allowCmdSet.contains(paramString)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected Class<? extends anui> observerClass()
  {
    return mxu.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvc.0x5eb_20002".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxo
 * JD-Core Version:    0.7.0.1
 */