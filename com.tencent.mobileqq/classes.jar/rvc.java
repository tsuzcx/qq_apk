import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

final class rvc
  implements ViewBase.OnClickListener
{
  rvc(ArticleInfo paramArticleInfo, Activity paramActivity, qoe paramqoe, int paramInt1, int paramInt2, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool2 = false;
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    rvb.a(this.jdField_a_of_type_AndroidAppActivity, localAdvertisementInfo, this.jdField_a_of_type_Qoe, this.jdField_a_of_type_Int);
    int j = this.b;
    int i = j;
    if (j == 6) {
      if ((this.jdField_a_of_type_Qoe != null) && (this.jdField_a_of_type_Qoe.a() != null))
      {
        i = j;
        if (this.jdField_a_of_type_Qoe.a().a()) {}
      }
      else
      {
        i = 5;
      }
    }
    if (this.b == 103) {
      i = 101;
    }
    for (j = 1;; j = 0)
    {
      if (this.b == 104)
      {
        i = 102;
        j = 1;
      }
      for (;;)
      {
        npj.a(localAdvertisementInfo, i, null);
        paramViewBase = null;
        if (this.jdField_a_of_type_Qoe != null) {
          paramViewBase = this.jdField_a_of_type_Qoe.a();
        }
        if ((npj.h((AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && ((this.b == 4) || (this.b == 3) || (this.b == 1)))
        {
          if (this.b == 1) {
            i = 3;
          }
          npj.a(this.jdField_a_of_type_AndroidAppActivity, 1);
          rvb.a(this.jdField_a_of_type_AndroidAppActivity);
          rvb.a(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
          nbe.a(new nmv().a(this.jdField_a_of_type_AndroidAppActivity).a(nbe.jdField_a_of_type_Int).b(nbe.ai).a((AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).d(i).a());
        }
        while (rvb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, paramViewBase, localAdvertisementInfo)) {
          return;
        }
        boolean bool1 = bool2;
        if (this.b != 6)
        {
          bool1 = bool2;
          if (this.b != 5) {
            if ((this.jdField_a_of_type_Qoe != null) && ((this.jdField_a_of_type_Int == 0) || (odm.b(this.jdField_a_of_type_Int))))
            {
              paramViewBase = this.jdField_a_of_type_Qoe;
              bool1 = bool2;
              if (qoe.a(localAdvertisementInfo, this.jdField_a_of_type_Int) != 104)
              {
                paramViewBase = this.jdField_a_of_type_Qoe;
                bool1 = bool2;
                if (qoe.a(localAdvertisementInfo, this.jdField_a_of_type_Int) == 105) {}
              }
            }
            else
            {
              if (j != 0) {
                break label461;
              }
              bool1 = bool2;
              if (this.b != 101) {
                if (this.b != 102) {
                  break label461;
                }
              }
            }
          }
        }
        label461:
        for (bool1 = bool2;; bool1 = true)
        {
          paramViewBase = new nmr();
          if (this.b == 8) {
            paramViewBase.c = true;
          }
          rvb.a(this.jdField_a_of_type_AndroidAppActivity, localAdvertisementInfo, this.jdField_a_of_type_Qoe, this.jdField_a_of_type_Int, bool1, npi.b((AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), paramViewBase);
          npl.a().a(4);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rvc
 * JD-Core Version:    0.7.0.1
 */