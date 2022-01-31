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

public class qop
  implements begh
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
  
  qop(qoe paramqoe) {}
  
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
        if (!qoe.b(this.jdField_a_of_type_Qoe))
        {
          bool1 = bool2;
          if (!obz.i())
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
      omf.a(this.jdField_a_of_type_AndroidViewView);
    }
    label38:
    label352:
    label494:
    label501:
    do
    {
      nny localnny;
      long l1;
      long l2;
      long l3;
      do
      {
        break label38;
        while ((this.jdField_a_of_type_Qoe.jdField_a_of_type_Qhp != null) && (this.jdField_a_of_type_Qoe.jdField_a_of_type_Qhp.g()))
        {
          return;
          if (paramInt1 + paramInt2 - 1 < this.jdField_c_of_type_Int) {
            omf.a(this.jdField_b_of_type_AndroidViewView);
          }
        }
        View localView = paramAbsListView.getChildAt(0);
        localnny = (nny)qoe.a().getManager(307);
        if ((localnny.a(this.jdField_a_of_type_Qoe, this.jdField_a_of_type_Qoe.jdField_a_of_type_AndroidAppActivity)) && (qoe.a(this.jdField_a_of_type_Qoe) != null)) {
          qoe.a(this.jdField_a_of_type_Qoe).a(this.jdField_a_of_type_Qoe, this.jdField_a_of_type_Qoe.jdField_a_of_type_AndroidAppActivity);
        }
        if (npj.a(this.jdField_a_of_type_Qoe.jdField_c_of_type_Int))
        {
          Pair localPair = ogy.a().a(this.jdField_a_of_type_Qoe.jdField_c_of_type_Int, paramInt1 + paramInt2);
          if (localPair != null)
          {
            ogy.a().a(this.jdField_a_of_type_Qoe.jdField_c_of_type_Int, ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
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
        this.jdField_a_of_type_Qoe.a(paramAbsListView, qoe.jdField_a_of_type_Int);
      }
      if (paramInt1 > this.jdField_b_of_type_Int) {
        this.jdField_a_of_type_Boolean = true;
      }
      for (;;)
      {
        localnny.a(this.jdField_a_of_type_Qoe, this.jdField_a_of_type_Qoe.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Double);
        this.jdField_b_of_type_Int = paramInt1;
        this.jdField_c_of_type_Int = (paramInt1 + paramInt2 - 1);
        this.jdField_a_of_type_AndroidViewView = paramAbsListView.getChildAt(0);
        this.jdField_b_of_type_AndroidViewView = paramAbsListView.getChildAt(paramInt2 - 1);
        if (this.jdField_a_of_type_Qoe.i != 2) {
          break label501;
        }
        if (Build.VERSION.SDK_INT >= 21) {
          break;
        }
        if (!qoe.a(this.jdField_a_of_type_Qoe, paramAbsListView)) {
          break label494;
        }
        rcv.a().b();
        return;
        this.jdField_a_of_type_Long = 0L;
        this.jdField_b_of_type_Long = 0L;
        this.jdField_c_of_type_Long = 0L;
        break label352;
        if (paramInt1 < this.jdField_b_of_type_Int) {
          this.jdField_a_of_type_Boolean = false;
        }
      }
      rcv.a().c();
      return;
    } while (this.jdField_a_of_type_Qoe.i != -1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Qoe.i = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "onScrollStateChanged " + paramInt);
    }
    label171:
    omw localomw;
    int i;
    if (paramInt == 0)
    {
      if (obz.a()) {}
      switch (this.jdField_a_of_type_Qoe.jdField_c_of_type_Int)
      {
      default: 
        if (odm.c(this.jdField_a_of_type_Qoe.jdField_c_of_type_Int))
        {
          zqk.a().a("list_readinjoy_daily", false);
          this.jdField_a_of_type_Qoe.jdField_a_of_type_Qvt.b();
          rcv.a().c();
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseAdapter", 2, "resume image onScrollStateChanged idle");
          }
          if (!this.jdField_a_of_type_Boolean) {
            break label481;
          }
          qoe.a(this.jdField_a_of_type_Qoe, this.jdField_a_of_type_Qoe.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition(), qoe.c());
          if (this.jdField_a_of_type_Qoe.getCount() - this.jdField_a_of_type_Qoe.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition() < qoe.d()) {
            qoe.a(this.jdField_a_of_type_Qoe);
          }
          qoe.b(this.jdField_a_of_type_Qoe, this.jdField_a_of_type_Boolean);
          localomw = qoe.a(this.jdField_a_of_type_Qoe, paramAbsListView);
          if (localomw != null) {
            break label508;
          }
          i = paramAbsListView.getFirstVisiblePosition();
          label234:
          if (this.jdField_a_of_type_Qoe.jdField_c_of_type_Int != 40677) {
            break label519;
          }
          if ((i == 0) && (this.jdField_a_of_type_Qoe.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)) {
            this.jdField_a_of_type_Qoe.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(i, qoe.a(this.jdField_a_of_type_Qoe));
          }
          label279:
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseAdapter", 2, "predownload position: " + i + " when scroll state idle");
          }
          qoe.a(this.jdField_a_of_type_Qoe).postDelayed(qoe.a(this.jdField_a_of_type_Qoe), 1000L);
          if ((paramInt != 2) || (!qoe.b(this.jdField_a_of_type_Qoe))) {
            break label718;
          }
          this.jdField_b_of_type_Boolean = true;
          label358:
          switch (paramInt)
          {
          }
        }
        break;
      }
    }
    for (;;)
    {
      qoe.a(this.jdField_a_of_type_Qoe).removeMessages(1001);
      for (;;)
      {
        this.jdField_a_of_type_Qoe.jdField_a_of_type_Rrb.a(paramAbsListView, paramInt);
        return;
        zqk.a().a("list_video_kandian", false);
        break;
        zqk.a().a("list_new_kandian", false);
        break;
        zqk.a().a("list_subscript", false);
        break;
        zqk.a().a("list_kandian_channel_" + this.jdField_a_of_type_Qoe.jdField_c_of_type_Int, false);
        break;
        label481:
        qoe.a(this.jdField_a_of_type_Qoe, this.jdField_a_of_type_Qoe.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition() - qoe.c(), qoe.c());
        break label171;
        label508:
        i = localomw.a();
        break label234;
        label519:
        if (this.jdField_a_of_type_Qoe.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr == null) {
          break label279;
        }
        this.jdField_a_of_type_Qoe.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(i, qoe.a(this.jdField_a_of_type_Qoe));
        break label279;
        if (obz.a()) {
          switch (this.jdField_a_of_type_Qoe.jdField_c_of_type_Int)
          {
          default: 
            if (odm.c(this.jdField_a_of_type_Qoe.jdField_c_of_type_Int)) {
              zqk.a().a("list_readinjoy_daily");
            }
            break;
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_Qoe.jdField_a_of_type_Qvt.a();
          qoe.a(this.jdField_a_of_type_Qoe).removeCallbacks(qoe.a(this.jdField_a_of_type_Qoe));
          break;
          zqk.a().a("list_video_kandian");
          continue;
          zqk.a().a("list_new_kandian");
          continue;
          zqk.a().a("list_subscript");
          continue;
          zqk.a().a("list_kandian_channel_" + this.jdField_a_of_type_Qoe.jdField_c_of_type_Int);
        }
        label718:
        if ((paramInt == 2) || (!this.jdField_b_of_type_Boolean)) {
          break label358;
        }
        this.jdField_b_of_type_Boolean = false;
        qoe.c(this.jdField_a_of_type_Qoe, false);
        break label358;
        this.jdField_a_of_type_Qoe.a(paramAbsListView, qoe.jdField_b_of_type_Int);
        QLog.d("gifvideo.ReadInJoyBaseAdapter", 2, "check shortcontent play");
        omf.a(this.jdField_a_of_type_Qoe.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      }
      if (qoe.a(this.jdField_a_of_type_Qoe) != null) {
        qoe.a(this.jdField_a_of_type_Qoe).a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qop
 * JD-Core Version:    0.7.0.1
 */