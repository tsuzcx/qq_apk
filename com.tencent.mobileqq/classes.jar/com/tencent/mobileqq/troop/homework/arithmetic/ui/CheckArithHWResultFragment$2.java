package com.tencent.mobileqq.troop.homework.arithmetic.ui;

import android.support.annotation.NonNull;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.homework.arithmetic.stream.SendArithHomeResultSegment.RspInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;

class CheckArithHWResultFragment$2
  extends SimpleObserver<SendArithHomeResultSegment.RspInfo>
{
  CheckArithHWResultFragment$2(CheckArithHWResultFragment paramCheckArithHWResultFragment) {}
  
  public void a(SendArithHomeResultSegment.RspInfo paramRspInfo)
  {
    super.onNext(paramRspInfo);
    SLog.d("QQ.Troop.homework.CheckArithHWResultFragment", "requestSendHomeworkResult completed");
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
    AssertUtils.a(paramRspInfo.a);
    AssertUtils.a(paramRspInfo.b);
    CheckArithHWResultFragment.a(this.a, paramRspInfo.a, paramRspInfo.b);
  }
  
  public void onCancel()
  {
    super.onCancel();
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    SLog.e("QQ.Troop.homework.CheckArithHWResultFragment", "send homework error:" + paramError);
    QQToast.a(this.a.getActivity(), 1, HardCodeUtil.a(2131701837), 0).a();
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
    CheckArithHWResultFragment.a(this.a, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.ui.CheckArithHWResultFragment.2
 * JD-Core Version:    0.7.0.1
 */