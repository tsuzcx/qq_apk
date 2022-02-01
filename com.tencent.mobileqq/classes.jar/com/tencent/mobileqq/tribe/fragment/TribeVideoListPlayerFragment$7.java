package com.tencent.mobileqq.tribe.fragment;

import android.support.v7.widget.RecyclerView.ViewHolder;
import bdmc;
import bdmt;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

class TribeVideoListPlayerFragment$7
  implements Runnable
{
  TribeVideoListPlayerFragment$7(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment, RecyclerView.ViewHolder paramViewHolder) {}
  
  public void run()
  {
    try
    {
      HttpUtil.openRequest(BaseApplicationImpl.getContext(), ((bdmc)this.a).a.i, null, "GET", null, null);
      return;
    }
    catch (IOException localIOException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TribeVideoListPlayerFragment", 2, "HttpUtil.openRequest exposureUrl: " + QLog.getStackTraceString(localIOException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.7
 * JD-Core Version:    0.7.0.1
 */