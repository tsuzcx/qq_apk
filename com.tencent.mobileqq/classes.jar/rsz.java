import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class rsz
  implements AbsListView.OnScrollListener
{
  double jdField_a_of_type_Double = 0.0D;
  private int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  private View jdField_a_of_type_AndroidViewView;
  private ReadInJoyXListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  private final psf jdField_a_of_type_Psf;
  boolean jdField_a_of_type_Boolean;
  final double jdField_b_of_type_Double = 200.0D;
  private int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = 0L;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = true;
  long c = 0L;
  
  public rsz(psf parampsf)
  {
    this.jdField_a_of_type_Psf = parampsf;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = parampsf.a().a();
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
        if (!this.jdField_a_of_type_Psf.a().d())
        {
          bool1 = bool2;
          if (!pay.j())
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
    if (this.jdField_a_of_type_Int < paramInt1) {
      prq.a(this.jdField_a_of_type_AndroidViewView);
    }
    long l1;
    long l2;
    long l3;
    do
    {
      for (;;)
      {
        paramAbsListView = this.jdField_a_of_type_Psf.a();
        if ((paramAbsListView == null) || (!paramAbsListView.h())) {
          break;
        }
        return;
        if (paramInt1 + paramInt2 - 1 < this.jdField_b_of_type_Int) {
          prq.a(this.jdField_b_of_type_AndroidViewView);
        }
      }
      paramAbsListView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(0);
      if (paramAbsListView == null) {
        break;
      }
      if (this.jdField_a_of_type_Long == 0L)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        return;
      }
      this.jdField_b_of_type_Long = (paramAbsListView.getHeight() * paramInt1 - paramAbsListView.getTop());
      l1 = this.jdField_b_of_type_Long;
      l2 = this.c;
      l3 = System.currentTimeMillis();
    } while (l3 == this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Double = ((l1 - l2) * 1000L / (l3 - this.jdField_a_of_type_Long));
    this.jdField_a_of_type_Long = l3;
    this.c = this.jdField_b_of_type_Long;
    if (a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "低速滚动触发自动播放检测");
      }
      this.jdField_a_of_type_Psf.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, slt.jdField_a_of_type_Int);
    }
    if (paramInt1 > this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = (paramInt1 + paramInt2 - 1);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(0);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt2 - 1);
      return;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_b_of_type_Long = 0L;
      this.c = 0L;
      break;
      if (paramInt1 < this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Psf.q();
      return;
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
      paramAbsListView = this.jdField_a_of_type_Psf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      if (paramAbsListView == null) {}
      for (paramInt = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition();; paramInt = paramAbsListView.a())
      {
        this.jdField_a_of_type_Psf.a(paramInt, this.jdField_b_of_type_Boolean);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseAdapter", 2, "predownload position: " + paramInt + " when scroll state idle");
        }
        this.jdField_a_of_type_Psf.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, slt.jdField_b_of_type_Int);
        QLog.d("gifvideo.ReadInJoyBaseAdapter", 2, "check shortcontent play");
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a()) {
          break;
        }
        prq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
        return;
      }
      this.jdField_a_of_type_Psf.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rsz
 * JD-Core Version:    0.7.0.1
 */