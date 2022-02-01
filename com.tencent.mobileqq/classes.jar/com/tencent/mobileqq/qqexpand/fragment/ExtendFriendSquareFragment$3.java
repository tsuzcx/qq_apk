package com.tencent.mobileqq.qqexpand.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.Map;

class ExtendFriendSquareFragment$3
  extends RecyclerView.OnScrollListener
{
  ExtendFriendSquareFragment$3(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  public void onScrollStateChanged(RecyclerView arg1, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onScrollStateChanged state=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (this.a.g != null) {
      if (paramInt == 0)
      {
        ??? = this.a;
        ???.A = false;
        ???.g.resume();
        this.a.c();
      }
      else
      {
        ??? = this.a;
        ???.A = true;
        ???.g.pause();
        this.a.g.cancelPendingRequests();
        synchronized (ExtendFriendBaseFragment.a)
        {
          if (this.a.e != null) {
            this.a.e.clear();
          }
        }
      }
    }
    if (paramInt == 0)
    {
      ExtendFriendSquareFragment.d(this.a);
      this.a.l();
      this.a.c(false);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    paramRecyclerView = this.a;
    paramRecyclerView.U = paramRecyclerView.r();
    if (this.a.W != -1L)
    {
      long l = System.currentTimeMillis() - this.a.W;
      if ((l > 0L) && (l < 2000L))
      {
        f = paramInt2 * 1.0F / (float)l;
        break label72;
      }
    }
    float f = 0.0F;
    label72:
    this.a.W = System.currentTimeMillis();
    paramRecyclerView = this.a;
    ExtendFriendSquareFragment.a(paramRecyclerView, paramRecyclerView.U, f);
    if ((!ExtendFriendSquareFragment.e(this.a)) && (!ExtendFriendSquareFragment.f(this.a)) && (this.a.o != null) && (this.a.m != null) && (this.a.o.findViewByPosition(this.a.m.getItemCount() - 2) != null))
    {
      this.a.b(true);
      ExtendFriendSquareFragment.a(this.a).post(new ExtendFriendSquareFragment.3.1(this));
      ReportController.b(this.a.i, "dc00898", "", "", "0X80092D5", "0X80092D5", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSquareFragment.3
 * JD-Core Version:    0.7.0.1
 */