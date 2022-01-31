import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.22.1;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import mqq.os.MqqHandler;

public class rqu
  implements bhtv
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
  
  rqu(rqj paramrqj) {}
  
  private String a()
  {
    if (pwu.a().a()) {
      return "list_readinjoy_daily_lite";
    }
    return "list_readinjoy_daily";
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
        if (!rqj.b(this.jdField_a_of_type_Rqj))
        {
          bool1 = bool2;
          if (!ors.h())
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
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_b_of_type_Int < paramInt1) {
      pcv.a(this.jdField_a_of_type_AndroidViewView);
    }
    label38:
    label354:
    label496:
    label503:
    do
    {
      ocq localocq;
      long l1;
      long l2;
      long l3;
      do
      {
        break label38;
        while ((this.jdField_a_of_type_Rqj.jdField_a_of_type_Rjg != null) && (this.jdField_a_of_type_Rqj.jdField_a_of_type_Rjg.h()))
        {
          return;
          if (paramInt1 + paramInt2 - 1 < this.jdField_c_of_type_Int) {
            pcv.a(this.jdField_b_of_type_AndroidViewView);
          }
        }
        View localView = paramAbsListView.getChildAt(0);
        localocq = (ocq)rqj.a().getManager(307);
        if ((localocq.a(this.jdField_a_of_type_Rqj, this.jdField_a_of_type_Rqj.jdField_a_of_type_AndroidAppActivity)) && (rqj.a(this.jdField_a_of_type_Rqj) != null)) {
          rqj.a(this.jdField_a_of_type_Rqj).a(this.jdField_a_of_type_Rqj, this.jdField_a_of_type_Rqj.jdField_a_of_type_AndroidAppActivity);
        }
        if (oee.a(this.jdField_a_of_type_Rqj.jdField_c_of_type_Int))
        {
          Pair localPair = owy.a().a(this.jdField_a_of_type_Rqj.jdField_c_of_type_Int, paramInt1 + paramInt2 - 1);
          if (localPair != null)
          {
            owy.a().a(this.jdField_a_of_type_Rqj.jdField_c_of_type_Int, ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
            ThreadManager.executeOnSubThread(new ReadInJoyBaseAdapter.22.1(this, localPair));
          }
        }
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
        this.jdField_a_of_type_Rqj.a(paramAbsListView, rqj.jdField_a_of_type_Int);
      }
      if (paramInt1 > this.jdField_b_of_type_Int) {
        this.jdField_a_of_type_Boolean = true;
      }
      for (;;)
      {
        localocq.a(this.jdField_a_of_type_Rqj, this.jdField_a_of_type_Rqj.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Double);
        this.jdField_b_of_type_Int = paramInt1;
        this.jdField_c_of_type_Int = (paramInt1 + paramInt2 - 1);
        this.jdField_a_of_type_AndroidViewView = paramAbsListView.getChildAt(0);
        this.jdField_b_of_type_AndroidViewView = paramAbsListView.getChildAt(paramInt2 - 1);
        if (this.jdField_a_of_type_Rqj.i != 2) {
          break label503;
        }
        if (Build.VERSION.SDK_INT >= 21) {
          break;
        }
        if (!rqj.a(this.jdField_a_of_type_Rqj, paramAbsListView)) {
          break label496;
        }
        sff.a().b();
        return;
        this.jdField_a_of_type_Long = 0L;
        this.jdField_b_of_type_Long = 0L;
        this.jdField_c_of_type_Long = 0L;
        break label354;
        if (paramInt1 < this.jdField_b_of_type_Int) {
          this.jdField_a_of_type_Boolean = false;
        }
      }
      sff.a().c();
      return;
    } while (this.jdField_a_of_type_Rqj.i != -1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Rqj.i = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "onScrollStateChanged " + paramInt);
    }
    label174:
    pdn localpdn;
    int i;
    if (paramInt == 0)
    {
      if (ors.a()) {}
      switch (this.jdField_a_of_type_Rqj.jdField_c_of_type_Int)
      {
      default: 
        if (otf.c(this.jdField_a_of_type_Rqj.jdField_c_of_type_Int))
        {
          abvl.a().a(a(), false);
          this.jdField_a_of_type_Rqj.jdField_a_of_type_Rxw.b();
          sff.a().c();
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseAdapter", 2, "resume image onScrollStateChanged idle");
          }
          if (!this.jdField_a_of_type_Boolean) {
            break label485;
          }
          rqj.a(this.jdField_a_of_type_Rqj, this.jdField_a_of_type_Rqj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition(), rqj.c());
          if (this.jdField_a_of_type_Rqj.getCount() - this.jdField_a_of_type_Rqj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition() < rqj.d()) {
            rqj.a(this.jdField_a_of_type_Rqj);
          }
          rqj.b(this.jdField_a_of_type_Rqj, this.jdField_a_of_type_Boolean);
          localpdn = rqj.a(this.jdField_a_of_type_Rqj, paramAbsListView);
          if (localpdn != null) {
            break label512;
          }
          i = paramAbsListView.getFirstVisiblePosition();
          label237:
          if (this.jdField_a_of_type_Rqj.jdField_c_of_type_Int != 40677) {
            break label523;
          }
          if ((i == 0) && (this.jdField_a_of_type_Rqj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)) {
            this.jdField_a_of_type_Rqj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(i, rqj.a(this.jdField_a_of_type_Rqj));
          }
          label282:
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseAdapter", 2, "predownload position: " + i + " when scroll state idle");
          }
          rqj.a(this.jdField_a_of_type_Rqj).postDelayed(rqj.a(this.jdField_a_of_type_Rqj), 1000L);
          if ((paramInt != 2) || (!rqj.b(this.jdField_a_of_type_Rqj))) {
            break label724;
          }
          this.jdField_b_of_type_Boolean = true;
          label361:
          switch (paramInt)
          {
          }
        }
        break;
      }
    }
    for (;;)
    {
      rqj.a(this.jdField_a_of_type_Rqj).removeMessages(1001);
      for (;;)
      {
        this.jdField_a_of_type_Rqj.jdField_a_of_type_Svj.a(paramAbsListView, paramInt);
        return;
        abvl.a().a("list_video_kandian", false);
        break;
        abvl.a().a("list_new_kandian", false);
        break;
        abvl.a().a("list_subscript", false);
        break;
        abvl.a().a("list_kandian_channel_" + this.jdField_a_of_type_Rqj.jdField_c_of_type_Int, false);
        break;
        label485:
        rqj.a(this.jdField_a_of_type_Rqj, this.jdField_a_of_type_Rqj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition() - rqj.c(), rqj.c());
        break label174;
        label512:
        i = localpdn.a();
        break label237;
        label523:
        if (this.jdField_a_of_type_Rqj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr == null) {
          break label282;
        }
        this.jdField_a_of_type_Rqj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(i, rqj.a(this.jdField_a_of_type_Rqj));
        break label282;
        if (ors.a()) {
          switch (this.jdField_a_of_type_Rqj.jdField_c_of_type_Int)
          {
          default: 
            if (otf.c(this.jdField_a_of_type_Rqj.jdField_c_of_type_Int)) {
              abvl.a().a(a());
            }
            break;
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_Rqj.jdField_a_of_type_Rxw.a();
          rqj.a(this.jdField_a_of_type_Rqj).removeCallbacks(rqj.a(this.jdField_a_of_type_Rqj));
          break;
          abvl.a().a("list_video_kandian");
          continue;
          abvl.a().a("list_new_kandian");
          continue;
          abvl.a().a("list_subscript");
          continue;
          abvl.a().a("list_kandian_channel_" + this.jdField_a_of_type_Rqj.jdField_c_of_type_Int);
        }
        label724:
        if ((paramInt == 2) || (!this.jdField_b_of_type_Boolean)) {
          break label361;
        }
        this.jdField_b_of_type_Boolean = false;
        rqj.c(this.jdField_a_of_type_Rqj, false);
        break label361;
        this.jdField_a_of_type_Rqj.a(paramAbsListView, rqj.jdField_b_of_type_Int);
        QLog.d("gifvideo.ReadInJoyBaseAdapter", 2, "check shortcontent play");
        if (!this.jdField_a_of_type_Rqj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a()) {
          pcv.a(this.jdField_a_of_type_Rqj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
        }
      }
      if (rqj.a(this.jdField_a_of_type_Rqj) != null) {
        rqj.a(this.jdField_a_of_type_Rqj).a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rqu
 * JD-Core Version:    0.7.0.1
 */