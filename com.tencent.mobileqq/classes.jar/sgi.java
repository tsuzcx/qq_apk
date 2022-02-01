import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.RIJOnScrollListener.1;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import mqq.os.MqqHandler;

public class sgi
  implements blih
{
  double jdField_a_of_type_Double = 0.0D;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  private View jdField_a_of_type_AndroidViewView;
  boolean jdField_a_of_type_Boolean;
  final double jdField_b_of_type_Double = 200.0D;
  private int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = 0L;
  private View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  long jdField_c_of_type_Long = 0L;
  
  private sgi(sel paramsel) {}
  
  private String a()
  {
    if (qhv.a().b()) {
      return "list_readinjoy_daily_lite";
    }
    return "list_readinjoy_daily";
  }
  
  private void a()
  {
    if (ozs.a()) {}
    switch (this.jdField_a_of_type_Sel.jdField_c_of_type_Int)
    {
    default: 
      if (pbd.c(this.jdField_a_of_type_Sel.jdField_c_of_type_Int))
      {
        adlb.a().a(a());
        return;
      }
      break;
    case 56: 
      adlb.a().a("list_video_kandian");
      return;
    case 0: 
      adlb.a().a("list_new_kandian");
      return;
    case 70: 
      adlb.a().a("list_subscript");
      return;
    }
    adlb.a().a("list_kandian_channel_" + this.jdField_a_of_type_Sel.jdField_c_of_type_Int);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Sel.jdField_c_of_type_Int == 40677) {
      if ((paramInt == 0) && (this.jdField_a_of_type_Sel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)) {
        this.jdField_a_of_type_Sel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramInt, sel.b(this.jdField_a_of_type_Sel));
      }
    }
    while (this.jdField_a_of_type_Sel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr == null) {
      return;
    }
    this.jdField_a_of_type_Sel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramInt, sel.b(this.jdField_a_of_type_Sel));
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (tqa.a(this.jdField_a_of_type_Sel.jdField_c_of_type_Int))
    {
      Pair localPair = pfa.a().a(this.jdField_a_of_type_Sel.jdField_c_of_type_Int, paramInt1 + paramInt2 - 1);
      if (localPair != null)
      {
        pfa.a().a(this.jdField_a_of_type_Sel.jdField_c_of_type_Int, ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
        ThreadManager.executeOnSubThread(new ReadInJoyBaseAdapter.RIJOnScrollListener.1(this, localPair));
      }
    }
  }
  
  private void a(AbsListView paramAbsListView)
  {
    if (this.jdField_a_of_type_Sel.i == 2) {
      if (Build.VERSION.SDK_INT < 21)
      {
        if (!sel.a(this.jdField_a_of_type_Sel, paramAbsListView)) {
          break label37;
        }
        sun.a().b();
      }
    }
    label37:
    while (this.jdField_a_of_type_Sel.i != -1)
    {
      return;
      sun.a().c();
      return;
    }
  }
  
  private boolean a(AbsListView paramAbsListView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Double > 0.0D)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Double < 200.0D)
      {
        bool1 = bool2;
        if (!sel.a(this.jdField_a_of_type_Sel))
        {
          bool1 = bool2;
          if (!ozs.j())
          {
            bool1 = bool2;
            if (paramAbsListView.getVisibility() == 0) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void b()
  {
    if (ozs.a()) {}
    switch (this.jdField_a_of_type_Sel.jdField_c_of_type_Int)
    {
    default: 
      if (pbd.c(this.jdField_a_of_type_Sel.jdField_c_of_type_Int))
      {
        adlb.a().a(a(), false);
        return;
      }
      break;
    case 56: 
      adlb.a().a("list_video_kandian", false);
      return;
    case 0: 
      adlb.a().a("list_new_kandian", false);
      return;
    case 70: 
      adlb.a().a("list_subscript", false);
      return;
    }
    adlb.a().a("list_kandian_channel_" + this.jdField_a_of_type_Sel.jdField_c_of_type_Int, false);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_b_of_type_Int < paramInt1) {
      pmd.a(this.jdField_a_of_type_AndroidViewView);
    }
    tnt localtnt;
    long l1;
    long l2;
    long l3;
    do
    {
      while ((this.jdField_a_of_type_Sel.jdField_a_of_type_Rvy != null) && (this.jdField_a_of_type_Sel.jdField_a_of_type_Rvy.h()))
      {
        return;
        if (paramInt1 + paramInt2 - 1 < this.jdField_c_of_type_Int) {
          pmd.a(this.jdField_b_of_type_AndroidViewView);
        }
      }
      View localView = paramAbsListView.getChildAt(0);
      localtnt = (tnt)sel.a().getManager(307);
      if ((localtnt.a(this.jdField_a_of_type_Sel, this.jdField_a_of_type_Sel.jdField_a_of_type_AndroidAppActivity)) && (sel.a(this.jdField_a_of_type_Sel) != null)) {
        sel.a(this.jdField_a_of_type_Sel).a(this.jdField_a_of_type_Sel, this.jdField_a_of_type_Sel.jdField_a_of_type_AndroidAppActivity);
      }
      a(paramInt1, paramInt2);
      if (localView == null) {
        break;
      }
      if (this.jdField_a_of_type_Long == 0L)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        return;
      }
      this.jdField_b_of_type_Long = (localView.getHeight() * paramInt1 - localView.getTop());
      l1 = this.jdField_b_of_type_Long;
      l2 = this.jdField_c_of_type_Long;
      l3 = System.currentTimeMillis();
    } while (l3 == this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Double = ((l1 - l2) * 1000L / (l3 - this.jdField_a_of_type_Long));
    this.jdField_a_of_type_Long = l3;
    this.jdField_c_of_type_Long = this.jdField_b_of_type_Long;
    if (a(paramAbsListView))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "低速滚动触发自动播放检测");
      }
      this.jdField_a_of_type_Sel.a(paramAbsListView, sel.jdField_a_of_type_Int);
    }
    if (paramInt1 > this.jdField_b_of_type_Int) {
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      localtnt.a(this.jdField_a_of_type_Sel, this.jdField_a_of_type_Sel.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Double);
      this.jdField_b_of_type_Int = paramInt1;
      this.jdField_c_of_type_Int = (paramInt1 + paramInt2 - 1);
      this.jdField_a_of_type_AndroidViewView = paramAbsListView.getChildAt(0);
      this.jdField_b_of_type_AndroidViewView = paramAbsListView.getChildAt(paramInt2 - 1);
      a(paramAbsListView);
      return;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_b_of_type_Long = 0L;
      this.jdField_c_of_type_Long = 0L;
      break;
      if (paramInt1 < this.jdField_b_of_type_Int) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Sel.i = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "onScrollStateChanged " + paramInt);
    }
    pmw localpmw;
    int i;
    if (paramInt == 0)
    {
      b();
      this.jdField_a_of_type_Sel.jdField_a_of_type_Smw.b();
      sun.a().c();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "resume image onScrollStateChanged idle");
      }
      if (this.jdField_a_of_type_Boolean)
      {
        sel.a(this.jdField_a_of_type_Sel, this.jdField_a_of_type_Sel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition(), sel.c());
        if (this.jdField_a_of_type_Sel.getCount() - this.jdField_a_of_type_Sel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition() < sel.d()) {
          sel.a(this.jdField_a_of_type_Sel);
        }
        sel.b(this.jdField_a_of_type_Sel, this.jdField_a_of_type_Boolean);
        localpmw = sel.a(this.jdField_a_of_type_Sel, paramAbsListView);
        if (localpmw != null) {
          break label333;
        }
        i = paramAbsListView.getFirstVisiblePosition();
        label171:
        a(i);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseAdapter", 2, "predownload position: " + i + " when scroll state idle");
        }
        sel.a(this.jdField_a_of_type_Sel).postDelayed(sel.a(this.jdField_a_of_type_Sel), 1000L);
        label236:
        if ((paramInt != 2) || (!sel.a(this.jdField_a_of_type_Sel))) {
          break label378;
        }
        this.jdField_b_of_type_Boolean = true;
        label256:
        switch (paramInt)
        {
        }
      }
    }
    for (;;)
    {
      sel.a(this.jdField_a_of_type_Sel).removeMessages(1001);
      for (;;)
      {
        this.jdField_a_of_type_Sel.jdField_a_of_type_Twz.a(paramAbsListView, paramInt);
        return;
        sel.a(this.jdField_a_of_type_Sel, this.jdField_a_of_type_Sel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition() - sel.c(), sel.c());
        break;
        label333:
        i = localpmw.a();
        break label171;
        a();
        this.jdField_a_of_type_Sel.jdField_a_of_type_Smw.a();
        sel.a(this.jdField_a_of_type_Sel).removeCallbacks(sel.a(this.jdField_a_of_type_Sel));
        break label236;
        label378:
        if ((paramInt == 2) || (!this.jdField_b_of_type_Boolean)) {
          break label256;
        }
        this.jdField_b_of_type_Boolean = false;
        sel.c(this.jdField_a_of_type_Sel, false);
        break label256;
        this.jdField_a_of_type_Sel.a(paramAbsListView, sel.jdField_b_of_type_Int);
        QLog.d("gifvideo.ReadInJoyBaseAdapter", 2, "check shortcontent play");
        if (!this.jdField_a_of_type_Sel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a()) {
          pmd.a(this.jdField_a_of_type_Sel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
        }
      }
      if (sel.a(this.jdField_a_of_type_Sel) != null) {
        sel.a(this.jdField_a_of_type_Sel).a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgi
 * JD-Core Version:    0.7.0.1
 */