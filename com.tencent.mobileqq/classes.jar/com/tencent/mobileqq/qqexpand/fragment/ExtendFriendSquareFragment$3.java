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
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      if (paramInt == 0)
      {
        ??? = this.a;
        ???.c = false;
        ???.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
        this.a.c();
      }
      else
      {
        ??? = this.a;
        ???.c = true;
        ???.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
        this.a.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
        synchronized (ExtendFriendBaseFragment.a)
        {
          if (this.a.jdField_a_of_type_JavaUtilMap != null) {
            this.a.jdField_a_of_type_JavaUtilMap.clear();
          }
        }
      }
    }
    if (paramInt == 0)
    {
      ExtendFriendSquareFragment.c(this.a);
      this.a.h();
      this.a.c(false);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    paramRecyclerView = this.a;
    paramRecyclerView.i = paramRecyclerView.d();
    if (this.a.e != -1L)
    {
      long l = System.currentTimeMillis() - this.a.e;
      if ((l > 0L) && (l < 2000L))
      {
        f = paramInt2 * 1.0F / (float)l;
        break label72;
      }
    }
    float f = 0.0F;
    label72:
    this.a.e = System.currentTimeMillis();
    paramRecyclerView = this.a;
    ExtendFriendSquareFragment.a(paramRecyclerView, paramRecyclerView.i, f);
    if ((!ExtendFriendSquareFragment.a(this.a)) && (!ExtendFriendSquareFragment.b(this.a)) && (this.a.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager != null) && (this.a.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter != null) && (this.a.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findViewByPosition(this.a.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.getItemCount() - 2) != null))
    {
      this.a.b(true);
      ExtendFriendSquareFragment.a(this.a).post(new ExtendFriendSquareFragment.3.1(this));
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092D5", "0X80092D5", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSquareFragment.3
 * JD-Core Version:    0.7.0.1
 */