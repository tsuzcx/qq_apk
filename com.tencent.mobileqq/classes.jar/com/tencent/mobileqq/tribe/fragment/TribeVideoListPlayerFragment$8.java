package com.tencent.mobileqq.tribe.fragment;

import android.support.v7.widget.RecyclerView.ViewHolder;
import azbi;
import azca;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import naj;

class TribeVideoListPlayerFragment$8
  implements Runnable
{
  TribeVideoListPlayerFragment$8(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment, RecyclerView.ViewHolder paramViewHolder) {}
  
  public void run()
  {
    try
    {
      naj.a(BaseApplicationImpl.getContext(), ((azbi)this.a).a.i, null, "GET", null, null);
      return;
    }
    catch (IOException localIOException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TribeVideoListPlayerFragment", 2, "HttpUtil.openRequest exposureUrl: " + QLog.getStackTraceString(localIOException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.8
 * JD-Core Version:    0.7.0.1
 */