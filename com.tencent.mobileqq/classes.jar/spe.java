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

public class spe
  implements bkhe
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
  
  private spe(snh paramsnh) {}
  
  private String a()
  {
    if (qph.a().b()) {
      return "list_readinjoy_daily_lite";
    }
    return "list_readinjoy_daily";
  }
  
  private void a()
  {
    if (pha.a()) {}
    switch (this.jdField_a_of_type_Snh.jdField_c_of_type_Int)
    {
    default: 
      if (pil.c(this.jdField_a_of_type_Snh.jdField_c_of_type_Int))
      {
        adcd.a().a(a());
        return;
      }
      break;
    case 56: 
      adcd.a().a("list_video_kandian");
      return;
    case 0: 
      adcd.a().a("list_new_kandian");
      return;
    case 70: 
      adcd.a().a("list_subscript");
      return;
    }
    adcd.a().a("list_kandian_channel_" + this.jdField_a_of_type_Snh.jdField_c_of_type_Int);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Snh.jdField_c_of_type_Int == 40677) {
      if ((paramInt == 0) && (this.jdField_a_of_type_Snh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)) {
        this.jdField_a_of_type_Snh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramInt, snh.b(this.jdField_a_of_type_Snh));
      }
    }
    while (this.jdField_a_of_type_Snh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr == null) {
      return;
    }
    this.jdField_a_of_type_Snh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramInt, snh.b(this.jdField_a_of_type_Snh));
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (oqj.a(this.jdField_a_of_type_Snh.jdField_c_of_type_Int))
    {
      Pair localPair = pmh.a().a(this.jdField_a_of_type_Snh.jdField_c_of_type_Int, paramInt1 + paramInt2 - 1);
      if (localPair != null)
      {
        pmh.a().a(this.jdField_a_of_type_Snh.jdField_c_of_type_Int, ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
        ThreadManager.executeOnSubThread(new ReadInJoyBaseAdapter.RIJOnScrollListener.1(this, localPair));
      }
    }
  }
  
  private void a(AbsListView paramAbsListView)
  {
    if (this.jdField_a_of_type_Snh.i == 2) {
      if (Build.VERSION.SDK_INT < 21)
      {
        if (!snh.a(this.jdField_a_of_type_Snh, paramAbsListView)) {
          break label37;
        }
        tdv.a().b();
      }
    }
    label37:
    while (this.jdField_a_of_type_Snh.i != -1)
    {
      return;
      tdv.a().c();
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
        if (!snh.a(this.jdField_a_of_type_Snh))
        {
          bool1 = bool2;
          if (!pha.j())
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
    if (pha.a()) {}
    switch (this.jdField_a_of_type_Snh.jdField_c_of_type_Int)
    {
    default: 
      if (pil.c(this.jdField_a_of_type_Snh.jdField_c_of_type_Int))
      {
        adcd.a().a(a(), false);
        return;
      }
      break;
    case 56: 
      adcd.a().a("list_video_kandian", false);
      return;
    case 0: 
      adcd.a().a("list_new_kandian", false);
      return;
    case 70: 
      adcd.a().a("list_subscript", false);
      return;
    }
    adcd.a().a("list_kandian_channel_" + this.jdField_a_of_type_Snh.jdField_c_of_type_Int, false);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_b_of_type_Int < paramInt1) {
      ptq.a(this.jdField_a_of_type_AndroidViewView);
    }
    ooi localooi;
    long l1;
    long l2;
    long l3;
    do
    {
      while ((this.jdField_a_of_type_Snh.jdField_a_of_type_Seu != null) && (this.jdField_a_of_type_Snh.jdField_a_of_type_Seu.h()))
      {
        return;
        if (paramInt1 + paramInt2 - 1 < this.jdField_c_of_type_Int) {
          ptq.a(this.jdField_b_of_type_AndroidViewView);
        }
      }
      View localView = paramAbsListView.getChildAt(0);
      localooi = (ooi)snh.a().getManager(307);
      if ((localooi.a(this.jdField_a_of_type_Snh, this.jdField_a_of_type_Snh.jdField_a_of_type_AndroidAppActivity)) && (snh.a(this.jdField_a_of_type_Snh) != null)) {
        snh.a(this.jdField_a_of_type_Snh).a(this.jdField_a_of_type_Snh, this.jdField_a_of_type_Snh.jdField_a_of_type_AndroidAppActivity);
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
      this.jdField_a_of_type_Snh.a(paramAbsListView, snh.jdField_a_of_type_Int);
    }
    if (paramInt1 > this.jdField_b_of_type_Int) {
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      localooi.a(this.jdField_a_of_type_Snh, this.jdField_a_of_type_Snh.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Double);
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
    this.jdField_a_of_type_Snh.i = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "onScrollStateChanged " + paramInt);
    }
    puj localpuj;
    int i;
    if (paramInt == 0)
    {
      b();
      this.jdField_a_of_type_Snh.jdField_a_of_type_Svt.b();
      tdv.a().c();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "resume image onScrollStateChanged idle");
      }
      if (this.jdField_a_of_type_Boolean)
      {
        snh.a(this.jdField_a_of_type_Snh, this.jdField_a_of_type_Snh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition(), snh.c());
        if (this.jdField_a_of_type_Snh.getCount() - this.jdField_a_of_type_Snh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition() < snh.d()) {
          snh.a(this.jdField_a_of_type_Snh);
        }
        snh.b(this.jdField_a_of_type_Snh, this.jdField_a_of_type_Boolean);
        localpuj = snh.a(this.jdField_a_of_type_Snh, paramAbsListView);
        if (localpuj != null) {
          break label333;
        }
        i = paramAbsListView.getFirstVisiblePosition();
        label171:
        a(i);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseAdapter", 2, "predownload position: " + i + " when scroll state idle");
        }
        snh.a(this.jdField_a_of_type_Snh).postDelayed(snh.a(this.jdField_a_of_type_Snh), 1000L);
        label236:
        if ((paramInt != 2) || (!snh.a(this.jdField_a_of_type_Snh))) {
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
      snh.a(this.jdField_a_of_type_Snh).removeMessages(1001);
      for (;;)
      {
        this.jdField_a_of_type_Snh.jdField_a_of_type_Twx.a(paramAbsListView, paramInt);
        return;
        snh.a(this.jdField_a_of_type_Snh, this.jdField_a_of_type_Snh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition() - snh.c(), snh.c());
        break;
        label333:
        i = localpuj.a();
        break label171;
        a();
        this.jdField_a_of_type_Snh.jdField_a_of_type_Svt.a();
        snh.a(this.jdField_a_of_type_Snh).removeCallbacks(snh.a(this.jdField_a_of_type_Snh));
        break label236;
        label378:
        if ((paramInt == 2) || (!this.jdField_b_of_type_Boolean)) {
          break label256;
        }
        this.jdField_b_of_type_Boolean = false;
        snh.c(this.jdField_a_of_type_Snh, false);
        break label256;
        this.jdField_a_of_type_Snh.a(paramAbsListView, snh.jdField_b_of_type_Int);
        QLog.d("gifvideo.ReadInJoyBaseAdapter", 2, "check shortcontent play");
        if (!this.jdField_a_of_type_Snh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a()) {
          ptq.a(this.jdField_a_of_type_Snh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
        }
      }
      if (snh.a(this.jdField_a_of_type_Snh) != null) {
        snh.a(this.jdField_a_of_type_Snh).a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     spe
 * JD-Core Version:    0.7.0.1
 */