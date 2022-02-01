package com.tencent.mobileqq.qwallet.hb.grap.impl;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.hb.aio.impl.QWalletRedPkgUtils;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils.AnsyListener;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import tencent.im.qqwallet.GdtAdServlet;
import tencent.im.qqwallet.kua_kua_hb_srv.TopicMatchRequest;

class RedPacketKuaKuaFragment$4$1
  implements QwUtils.AnsyListener
{
  RedPacketKuaKuaFragment$4$1(RedPacketKuaKuaFragment.4 param4) {}
  
  public void a(int paramInt, String... paramVarArgs)
  {
    if (this.a.a.f())
    {
      if (QLog.isColorLevel()) {
        QLog.i("RedPacketKuaKuaFragment", 2, "ansyBack:getActivity() == null || getActivity().isFinishing()");
      }
      return;
    }
    if (paramVarArgs.length > 0)
    {
      if (paramVarArgs[0] == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("RedPacketKuaKuaFragment", 2, "get getPskeyAsync success");
      }
      long l = NetConnInfoCenter.getServerTimeMillis();
      String str1 = RedPacketKuaKuaFragment.k(this.a.a).b;
      paramInt = QWalletRedPkgUtils.a(this.a.a.getQBaseActivity().getAppRuntime(), RedPacketKuaKuaFragment.k(this.a.a));
      String str2 = this.a.a.getQBaseActivity().getAppRuntime().getCurrentUin();
      NewIntent localNewIntent = new NewIntent(MobileQQ.getContext(), GdtAdServlet.class);
      localNewIntent.putExtra("cmd", "trpc.qqhb.kua_kua_hb_srv.KuaKuaHbSvc.TopicMatch");
      paramVarArgs = this.a.a.a(paramVarArgs[0], str2, paramInt, str1);
      if (paramVarArgs != null) {
        localNewIntent.putExtra("data", WupUtil.a(paramVarArgs.toByteArray()));
      }
      localNewIntent.setObserver(new RedPacketKuaKuaFragment.4.1.1(this, l));
      this.a.a.getQBaseActivity().getAppRuntime().startServlet(localNewIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketKuaKuaFragment.4.1
 * JD-Core Version:    0.7.0.1
 */