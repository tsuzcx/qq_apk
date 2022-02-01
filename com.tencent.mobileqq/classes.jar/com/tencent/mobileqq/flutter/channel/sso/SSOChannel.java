package com.tencent.mobileqq.flutter.channel.sso;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flutter.channel.BaseMethodChannel;
import com.tencent.mobileqq.flutter.channel.model.RequestPacket;
import com.tencent.mobileqq.flutter.channel.model.ResponsePacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.MethodCodec;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

public class SSOChannel
  extends BaseMethodChannel
  implements BusinessObserver
{
  public static final AtomicInteger a;
  private Map<Integer, MethodChannel.Result> a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  }
  
  public SSOChannel()
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  private void a(RequestPacket paramRequestPacket, MethodChannel.Result paramResult)
  {
    if ((paramRequestPacket != null) && (paramResult != null))
    {
      int i = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", a().getAccount(), paramRequestPacket.cmd);
      localToServiceMsg.setTimeout(paramRequestPacket.timeout.intValue() * 1000L);
      localToServiceMsg.extraData.putLong("REQUEST_TIME", System.currentTimeMillis());
      localToServiceMsg.extraData.putInt("FLUTTER_REQUEST_SEQ", i);
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramResult);
      localToServiceMsg.putWupBuffer(paramRequestPacket.body);
      paramResult = new NewIntent(a().getApplication(), FlutterServlet.class);
      paramResult.putExtra(ToServiceMsg.class.getSimpleName(), localToServiceMsg);
      paramResult.setObserver(this);
      a().startServlet(paramResult);
      if (QLog.isColorLevel()) {
        QLog.d("QFlutter.SSOChannel", 2, String.format("send request cmd: %s, request seq: %s", new Object[] { paramRequestPacket.cmd, Integer.valueOf(i) }));
      }
      return;
    }
    QLog.d("QFlutter.SSOChannel", 1, "send request, packet == null or result == null");
  }
  
  private void a(String paramString, ResponsePacket paramResponsePacket, MethodChannel.Result paramResult)
  {
    ThreadManager.getUIHandler().post(new SSOChannel.2(this, paramResponsePacket, paramString, paramResult));
  }
  
  public MethodChannel.MethodCallHandler a()
  {
    return new SSOChannel.1(this);
  }
  
  public MethodCodec a()
  {
    return SSOChannelHandler.a;
  }
  
  public String a()
  {
    return "sso_channel";
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.e("QFlutter.SSOChannel", 1, "onReceive, bundle == null");
      return;
    }
    ToServiceMsg localToServiceMsg = (ToServiceMsg)paramBundle.getParcelable(ToServiceMsg.class.getSimpleName());
    Object localObject = (FromServiceMsg)paramBundle.getParcelable(FromServiceMsg.class.getSimpleName());
    if ((localToServiceMsg != null) && (localObject != null))
    {
      paramInt = localToServiceMsg.extraData.getInt("FLUTTER_REQUEST_SEQ");
      long l1 = System.currentTimeMillis();
      long l2 = localToServiceMsg.extraData.getLong("REQUEST_TIME");
      if (QLog.isColorLevel()) {
        QLog.d("QFlutter.SSOChannel", 2, String.format("[onReceive]cmd: %s, app seq: %s, cost: %s, errCode: %s, request seq: %s", new Object[] { localToServiceMsg.getServiceCmd(), Integer.valueOf(localToServiceMsg.getAppSeq()), Long.valueOf(l1 - l2), Integer.valueOf(((FromServiceMsg)localObject).getResultCode()), Integer.valueOf(paramInt) }));
      }
      byte[] arrayOfByte = ((FromServiceMsg)localObject).getWupBuffer();
      paramBundle = new ResponsePacket();
      paramBundle.isSuc = Boolean.valueOf(((FromServiceMsg)localObject).isSuccess());
      paramBundle.errCode = Integer.valueOf(((FromServiceMsg)localObject).getResultCode());
      paramBundle.body = arrayOfByte;
      localObject = (MethodChannel.Result)this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
      a(localToServiceMsg.getServiceCmd(), paramBundle, (MethodChannel.Result)localObject);
      return;
    }
    QLog.e("QFlutter.SSOChannel", 1, "request == null || response == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.sso.SSOChannel
 * JD-Core Version:    0.7.0.1
 */