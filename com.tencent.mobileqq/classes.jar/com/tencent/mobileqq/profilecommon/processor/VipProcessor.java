package com.tencent.mobileqq.profilecommon.processor;

import QQService.EVIPSPEC;
import android.content.Intent;
import androidx.annotation.VisibleForTesting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.emosm.IEmoticonHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.jetbrains.annotations.NotNull;

@KeepClassConstructor
public class VipProcessor
  extends AbsProfileCommonProcessor
{
  private static final int[] a = { 23105, 23106, 23107 };
  private long b = 0L;
  
  public VipProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  @VisibleForTesting
  @NotNull
  private Friends a(ByteStringMicro paramByteStringMicro, Friends paramFriends)
  {
    paramFriends = (Friends)paramFriends.clone();
    int m = paramFriends.qqVipInfo;
    int j = 0;
    int i = paramByteStringMicro.byteAt(0);
    int k = 1;
    if ((i & 0x80) == 0) {
      i = 0;
    } else {
      i = 1;
    }
    paramFriends.qqVipInfo = (m & 0xFFFFFF | i << 24);
    m = paramFriends.superQqInfo;
    if ((paramByteStringMicro.byteAt(0) & 0x8) == 0) {
      i = 0;
    } else {
      i = 1;
    }
    paramFriends.superQqInfo = (m & 0xFFFFFF | i << 24);
    if ((paramByteStringMicro.byteAt(0) & 0x40) != 0) {
      i = k;
    } else {
      i = 0;
    }
    if (i != 0) {
      j = 65536;
    }
    if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
      paramFriends.superVipInfo = (paramFriends.superVipInfo & 0xFF00FFFF | j);
    } else if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
      paramFriends.qqVipInfo = (paramFriends.qqVipInfo & 0xFF00FFFF | j);
    } else if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
      paramFriends.superQqInfo = (paramFriends.superQqInfo & 0xFF00FFFF | j);
    }
    if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB)) {
      paramFriends.bigClubInfo = (paramFriends.bigClubInfo & 0xFF00FFFF | j);
    }
    return paramFriends;
  }
  
  private void a()
  {
    ((QQAppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER).notifyUI(100, true, null);
  }
  
  private void a(ByteStringMicro paramByteStringMicro, FriendsManager paramFriendsManager, Friends paramFriends)
  {
    boolean bool = this.appRuntime.getCurrentAccountUin().equals(Long.toString(this.b));
    paramFriendsManager.b(a(paramByteStringMicro, paramFriends));
    if (bool)
    {
      a();
      c();
      b();
      d();
    }
  }
  
  @VisibleForTesting
  @NotNull
  private Friends b(ByteStringMicro paramByteStringMicro, Friends paramFriends)
  {
    paramFriends = (Friends)paramFriends.clone();
    boolean bool1 = paramFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
    boolean bool2 = paramFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
    boolean bool3 = paramFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ);
    paramFriends.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB);
    int m = paramByteStringMicro.byteAt(4);
    int n = paramByteStringMicro.byteAt(5);
    int i = 1;
    int k = 1;
    int j;
    if ((n & 0xF0) != 0)
    {
      j = 0;
      for (i = 16; j < 4; i = (byte)(i << 1))
      {
        if ((n & i) != 0)
        {
          i = 13 - j;
          break label166;
        }
        j += 1;
      }
    }
    label164:
    for (;;)
    {
      i = 0;
      break;
      if (m == 0) {
        break;
      }
      j = 0;
      for (i = k;; i = (byte)(i << 1))
      {
        if (j >= 8) {
          break label164;
        }
        if ((m & i) != 0)
        {
          i = 9 - j;
          break;
        }
        j += 1;
      }
    }
    label166:
    if (bool1)
    {
      paramFriends.superVipInfo = (0xFFFF & i | paramFriends.superVipInfo & 0xFFFF0000);
      return paramFriends;
    }
    if (bool2)
    {
      paramFriends.qqVipInfo = (0xFFFF & i | paramFriends.qqVipInfo & 0xFFFF0000);
      return paramFriends;
    }
    if (bool3) {
      paramFriends.superQqInfo = (0xFFFF & i | paramFriends.superQqInfo & 0xFFFF0000);
    }
    return paramFriends;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipProcessor", 2, "[EmoticonUpdateAuth] updateEmoticonAuth");
    }
    IEmoticonHandler localIEmoticonHandler = (IEmoticonHandler)((QQAppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM);
    localIEmoticonHandler.a(0, 0);
    localIEmoticonHandler.a(0, 0, 1, 0);
  }
  
  private void b(ByteStringMicro paramByteStringMicro, FriendsManager paramFriendsManager, Friends paramFriends)
  {
    boolean bool = this.appRuntime.getCurrentAccountUin().equals(Long.toString(this.b));
    paramFriendsManager.b(b(paramByteStringMicro, paramFriends));
    if (bool) {
      a();
    }
  }
  
  private void c()
  {
    Intent localIntent = new Intent("tencent.video.q2v.SVIP.PAY");
    localIntent.putExtra("SVIPpaySuccess", true);
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    this.appRuntime.getApp().sendBroadcast(localIntent);
  }
  
  private void c(ByteStringMicro paramByteStringMicro, FriendsManager paramFriendsManager, Friends paramFriends)
  {
    boolean bool = this.appRuntime.getCurrentAccountUin().equals(Long.toString(this.b));
    paramFriends = (Friends)paramFriends.clone();
    int i;
    if ((paramByteStringMicro.byteAt(5) & 0x20) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    paramFriends.superVipInfo = (i << 24 | paramFriends.superVipInfo & 0xFFFFFF);
    paramFriendsManager.b(paramFriends);
    if (bool)
    {
      a();
      b();
    }
  }
  
  private void d()
  {
    QVipConfigManager.b(this.appRuntime, "last_pull_pay_rule", 0L);
    String str = ((TicketManager)this.appRuntime.getManager(2)).getSkey(this.appRuntime.getCurrentAccountUin());
    ((VipInfoHandler)((QQAppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a(str, Long.toString(this.b));
  }
  
  public String getProcessorKey()
  {
    return "VipProcessor";
  }
  
  public boolean interceptProfileModifyPush(int paramInt)
  {
    int[] arrayOfInt = a;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramInt == arrayOfInt[i]) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void onProcessProfileModifyPush(int paramInt, ByteStringMicro paramByteStringMicro)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onProcessProfileModifyPush uin = ");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(" type = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" value = ");
      ((StringBuilder)localObject).append(Arrays.toString(paramByteStringMicro.toByteArray()));
      QLog.d("VipProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (this.b <= 0L) {
      return;
    }
    Object localObject = (FriendsManager)this.appRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Friends localFriends = ((FriendsManager)localObject).m(String.valueOf(this.b));
    if (localFriends == null) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 23107: 
      c(paramByteStringMicro, (FriendsManager)localObject, localFriends);
      return;
    case 23106: 
      b(paramByteStringMicro, (FriendsManager)localObject, localFriends);
      return;
    }
    a(paramByteStringMicro, (FriendsManager)localObject, localFriends);
  }
  
  public void onProcessProfileModifyPushBegin(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void onProcessProfileModifyPushEnd()
  {
    this.b = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecommon.processor.VipProcessor
 * JD-Core Version:    0.7.0.1
 */