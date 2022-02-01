import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyPatchAdView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

final class oqn
  implements otk
{
  oqn(ReadInJoyPatchAdView paramReadInJoyPatchAdView, Activity paramActivity, sfq paramsfq, seu paramseu, sfw paramsfw, seo paramseo, oqo paramoqo) {}
  
  public void a(sey paramsey, int paramInt)
  {
    if (!oqm.a(paramsey)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(oqm.a, 2, "onStart: id = " + paramsey.a.mArticleID);
    }
    oqm.a(paramsey, paramInt, 1);
    oqm.b();
  }
  
  public void a(sey paramsey, int paramInt1, int paramInt2)
  {
    if (!oqm.a(paramsey)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.a.clickPos = paramInt2;
    if (paramInt1 == 1) {
      paramsey.a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    for (;;)
    {
      ubb.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.a, null, 3, true, null);
      nxw.a(new omp().a(this.jdField_a_of_type_AndroidAppActivity).a(nxw.a).b(nxw.T).d(paramInt2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.a).a());
      return;
      paramsey.a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
  
  public void b(sey paramsey, int paramInt)
  {
    int i = 1;
    if (!oqm.a(paramsey)) {}
    for (;;)
    {
      return;
      if ((paramInt == 1) && (!paramsey.a.patchStatus.c.get()))
      {
        paramsey.a.patchStatus.c.set(true);
        paramInt = i;
      }
      while (paramInt != 0)
      {
        nxw.a(new omp().a(BaseApplication.getContext()).a(nxw.b).b(nxw.O).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.a).e(new JSONObject()).a());
        return;
        if ((paramInt == 2) && (!paramsey.a.patchStatus.d.get()))
        {
          paramsey.a.patchStatus.d.set(true);
          paramInt = i;
        }
        else
        {
          paramInt = 0;
        }
      }
    }
  }
  
  public void b(sey paramsey, int paramInt1, int paramInt2)
  {
    if (!oqm.a(paramsey)) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(oqm.a, 2, "onCompletion: id = " + paramsey.a.mArticleID);
        }
        oqm.a(paramsey, paramInt1, 3);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.a();
        if (paramInt1 != 1) {
          break;
        }
      } while (this.jdField_a_of_type_Sfq.a() != paramsey);
      switch (paramInt2)
      {
      default: 
        this.jdField_a_of_type_Seu.a(paramsey);
        return;
      }
      this.jdField_a_of_type_Seu.a();
      return;
    } while ((this.jdField_a_of_type_Sfw == null) || (paramInt2 != 0));
    this.jdField_a_of_type_Sfw.a(paramsey);
    this.jdField_a_of_type_Seo.c();
  }
  
  public void c(sey paramsey, int paramInt)
  {
    if (!oqm.a(paramsey)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(oqm.a, 2, "onResume: id = " + paramsey.a.mArticleID);
      }
      if (this.jdField_a_of_type_Sfq.a().a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2)
      {
        oqm.a(this.jdField_a_of_type_Sfq.a(), this.jdField_a_of_type_Sfq, true, this.jdField_a_of_type_Oqo);
        return;
      }
    } while (this.jdField_a_of_type_Sfq.a().a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2);
    oqm.a(this.jdField_a_of_type_Sfq.a(), this.jdField_a_of_type_Sfq, false, true, this.jdField_a_of_type_Sfw, this.jdField_a_of_type_Seo, this.jdField_a_of_type_Oqo);
  }
  
  public void d(sey paramsey, int paramInt)
  {
    if (!oqm.a(paramsey)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(oqm.a, 2, "onPause: id = " + paramsey.a.mArticleID);
    }
    if (this.jdField_a_of_type_Sfq.a().a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
      this.jdField_a_of_type_Sfq.a().a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.a();
      }
      oqm.c();
      return;
      if (this.jdField_a_of_type_Sfq.a().a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
        this.jdField_a_of_type_Sfq.a().a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqn
 * JD-Core Version:    0.7.0.1
 */