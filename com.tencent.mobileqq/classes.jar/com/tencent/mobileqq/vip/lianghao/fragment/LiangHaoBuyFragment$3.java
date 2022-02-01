package com.tencent.mobileqq.vip.lianghao.fragment;

import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.vip.lianghao.LHLoginMng.OnLockLHUinResult;
import com.tencent.qphone.base.util.QLog;

class LiangHaoBuyFragment$3
  implements LHLoginMng.OnLockLHUinResult
{
  LiangHaoBuyFragment$3(LiangHaoBuyFragment paramLiangHaoBuyFragment) {}
  
  public void a(Intent paramIntent, boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("lockLH uin=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",suc=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",lhsig=");
      String str;
      if (paramArrayOfByte != null) {
        str = SecUtil.toHexString(paramArrayOfByte);
      } else {
        str = "null";
      }
      localStringBuilder.append(str);
      QLog.i("LiangHaoBuyFragment", 4, localStringBuilder.toString());
    }
    ThreadManagerV2.getUIHandlerV2().post(new LiangHaoBuyFragment.3.1(this, paramBoolean, paramIntent, paramString1, paramArrayOfByte, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.fragment.LiangHaoBuyFragment.3
 * JD-Core Version:    0.7.0.1
 */