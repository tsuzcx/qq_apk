import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyPatchAdView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

final class oei
  implements ogo
{
  oei(ReadInJoyPatchAdView paramReadInJoyPatchAdView, Activity paramActivity, rkp paramrkp, rjg paramrjg, rkv paramrkv, rja paramrja, oej paramoej) {}
  
  public void a(rjk paramrjk, int paramInt)
  {
    if (!oeh.a(paramrjk)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(oeh.a, 2, "onStart: id = " + paramrjk.a.mArticleID);
    }
    oeh.a(paramrjk, paramInt, 1);
    oeh.a();
  }
  
  public void a(rjk paramrjk, int paramInt1, int paramInt2)
  {
    if (!oeh.a(paramrjk)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.a.clickPos = paramInt2;
    if (paramInt1 == 1) {
      paramrjk.a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    for (;;)
    {
      szl.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.a, null, 3, true, null);
      noy.a(new obk().a(this.jdField_a_of_type_AndroidAppActivity).a(noy.a).b(noy.R).d(paramInt2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.a).a());
      return;
      paramrjk.a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
  
  public void b(rjk paramrjk, int paramInt)
  {
    int i = 1;
    if (!oeh.a(paramrjk)) {}
    for (;;)
    {
      return;
      if ((paramInt == 1) && (!paramrjk.a.patchStatus.c.get()))
      {
        paramrjk.a.patchStatus.c.set(true);
        paramInt = i;
      }
      while (paramInt != 0)
      {
        noy.a(new obk().a(BaseApplication.getContext()).a(noy.b).b(noy.M).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.a).e(new JSONObject()).a());
        return;
        if ((paramInt == 2) && (!paramrjk.a.patchStatus.d.get()))
        {
          paramrjk.a.patchStatus.d.set(true);
          paramInt = i;
        }
        else
        {
          paramInt = 0;
        }
      }
    }
  }
  
  public void b(rjk paramrjk, int paramInt1, int paramInt2)
  {
    if (!oeh.a(paramrjk)) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(oeh.a, 2, "onCompletion: id = " + paramrjk.a.mArticleID);
        }
        oeh.a(paramrjk, paramInt1, 3);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.a();
        if (paramInt1 != 1) {
          break;
        }
      } while (this.jdField_a_of_type_Rkp.a() != paramrjk);
      switch (paramInt2)
      {
      default: 
        this.jdField_a_of_type_Rjg.a(paramrjk);
        return;
      }
      this.jdField_a_of_type_Rjg.a();
      return;
    } while ((this.jdField_a_of_type_Rkv == null) || (paramInt2 != 0));
    this.jdField_a_of_type_Rkv.a(paramrjk);
    this.jdField_a_of_type_Rja.c();
  }
  
  public void c(rjk paramrjk, int paramInt)
  {
    if (!oeh.a(paramrjk)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(oeh.a, 2, "onResume: id = " + paramrjk.a.mArticleID);
      }
      if (this.jdField_a_of_type_Rkp.a().a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2)
      {
        oeh.a(this.jdField_a_of_type_Rkp.a(), this.jdField_a_of_type_Rkp, true, this.jdField_a_of_type_Oej);
        return;
      }
    } while (this.jdField_a_of_type_Rkp.a().a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2);
    oeh.a(this.jdField_a_of_type_Rkp.a(), this.jdField_a_of_type_Rkp, false, true, this.jdField_a_of_type_Rkv, this.jdField_a_of_type_Rja, this.jdField_a_of_type_Oej);
  }
  
  public void d(rjk paramrjk, int paramInt)
  {
    if (!oeh.a(paramrjk)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(oeh.a, 2, "onPause: id = " + paramrjk.a.mArticleID);
    }
    if (this.jdField_a_of_type_Rkp.a().a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
      this.jdField_a_of_type_Rkp.a().a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.a();
      }
      oeh.b();
      return;
      if (this.jdField_a_of_type_Rkp.a().a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
        this.jdField_a_of_type_Rkp.a().a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oei
 * JD-Core Version:    0.7.0.1
 */