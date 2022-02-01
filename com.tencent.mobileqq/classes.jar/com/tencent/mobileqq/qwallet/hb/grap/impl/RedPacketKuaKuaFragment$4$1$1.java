package com.tencent.mobileqq.qwallet.hb.grap.impl;

import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import tencent.im.qqwallet.kua_kua_hb_srv.TopicMatchReply;

class RedPacketKuaKuaFragment$4$1$1
  implements BusinessObserver
{
  RedPacketKuaKuaFragment$4$1$1(RedPacketKuaKuaFragment.4.1 param1, long paramLong) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.b.a.a.f())
    {
      if (QLog.isColorLevel()) {
        QLog.i("RedPacketKuaKuaFragment", 2, "getActivity() == null || getActivity().isFinishing()");
      }
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive:type:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",bundle:");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append(",cost:");
      ((StringBuilder)localObject).append(NetConnInfoCenter.getServerTimeMillis() - this.a);
      QLog.d("RedPacketKuaKuaFragment", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = paramBundle.getByteArray("data");
      if ((localObject != null) && (localObject.length > 0) && (paramBoolean))
      {
        paramBundle = new kua_kua_hb_srv.TopicMatchReply();
        paramBundle.mergeFrom((byte[])localObject);
        long l = paramBundle.retCode.get();
        if (l == 1L)
        {
          RedPacketKuaKuaFragment.a(this.b.a.a, paramBundle.matchToken.get());
          this.b.a.a.c();
          ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "kuakua.get.pass", 0, 0, RedPacketKuaKuaFragment.b(this.b.a.a).mQQWalletRedPacketMsg.elem.c, "", "", "");
          return;
        }
        if (l == 99L)
        {
          RedPacketKuaKuaFragment.a(this.b.a.a, paramBundle.refuseInterval.get());
          RedPacketKuaKuaFragment.b(this.b.a.a, NetConnInfoCenter.getServerTime());
          this.b.a.a.a(HardCodeUtil.a(R.string.bm));
          if (RedPacketKuaKuaFragment.i(this.b.a.a) > 0L)
          {
            paramBundle = (ImageView)this.b.a.a.getQBaseActivity().findViewById(R.id.av);
            localObject = this.b.a.a.getResources().getDrawable(R.drawable.q);
            paramBundle.setBackgroundDrawable((Drawable)localObject);
            paramBundle.setVisibility(0);
            ((Animatable)localObject).start();
            ThreadManager.getUIHandler().postDelayed(new RedPacketKuaKuaFragment.4.1.1.1(this, (Drawable)localObject, paramBundle), RedPacketKuaKuaFragment.i(this.b.a.a) * 1000L);
          }
        }
        else
        {
          this.b.a.a.a(HardCodeUtil.a(R.string.bn));
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onReceive fail,retCode:");
            ((StringBuilder)localObject).append(l);
            ((StringBuilder)localObject).append("retMsg:");
            ((StringBuilder)localObject).append(paramBundle.retMsg.get());
            QLog.e("RedPacketKuaKuaFragment", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
      else
      {
        this.b.a.a.a(HardCodeUtil.a(R.string.br));
        return;
      }
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive fail exception:");
      ((StringBuilder)localObject).append(paramBundle.getMessage());
      QLog.e("RedPacketKuaKuaFragment", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketKuaKuaFragment.4.1.1
 * JD-Core Version:    0.7.0.1
 */