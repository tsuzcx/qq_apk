import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

final class szm
  implements ViewBase.OnClickListener
{
  szm(ArticleInfo paramArticleInfo, Activity paramActivity, rqj paramrqj, int paramInt1, int paramInt2, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool2 = false;
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    szl.a(this.jdField_a_of_type_AndroidAppActivity, localAdvertisementInfo, this.jdField_a_of_type_Rqj, this.jdField_a_of_type_Int);
    int j = this.b;
    int i = j;
    if (j == 6) {
      if ((this.jdField_a_of_type_Rqj != null) && (this.jdField_a_of_type_Rqj.a() != null))
      {
        i = j;
        if (this.jdField_a_of_type_Rqj.a().b()) {}
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
        oee.a(localAdvertisementInfo, i, null);
        paramViewBase = null;
        if (this.jdField_a_of_type_Rqj != null) {
          paramViewBase = this.jdField_a_of_type_Rqj.a();
        }
        if ((oee.h((AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && ((this.b == 4) || (this.b == 3) || (this.b == 1)))
        {
          if (this.b == 1) {
            i = 3;
          }
          oee.a(this.jdField_a_of_type_AndroidAppActivity, 1);
          szl.a(this.jdField_a_of_type_AndroidAppActivity);
          szl.a(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
          noy.a(new obk().a(this.jdField_a_of_type_AndroidAppActivity).a(noy.jdField_a_of_type_Int).b(noy.ai).a((AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).d(i).a());
        }
        while (szl.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, paramViewBase, localAdvertisementInfo)) {
          return;
        }
        boolean bool1 = bool2;
        if (this.b != 6)
        {
          bool1 = bool2;
          if (this.b != 5) {
            if ((this.jdField_a_of_type_Rqj != null) && ((this.jdField_a_of_type_Int == 0) || (otf.b(this.jdField_a_of_type_Int))))
            {
              paramViewBase = this.jdField_a_of_type_Rqj;
              bool1 = bool2;
              if (rqj.a(localAdvertisementInfo, this.jdField_a_of_type_Int) != 104)
              {
                paramViewBase = this.jdField_a_of_type_Rqj;
                bool1 = bool2;
                if (rqj.a(localAdvertisementInfo, this.jdField_a_of_type_Int) == 105) {}
              }
            }
            else
            {
              if (j != 0) {
                break label479;
              }
              bool1 = bool2;
              if (this.b != 101) {
                if (this.b != 102) {
                  break label479;
                }
              }
            }
          }
        }
        label479:
        for (bool1 = bool2;; bool1 = true)
        {
          paramViewBase = new obg();
          if (this.b == 8) {
            paramViewBase.c = true;
          }
          if (szl.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Rqj, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
            break;
          }
          szl.a(this.jdField_a_of_type_AndroidAppActivity, localAdvertisementInfo, this.jdField_a_of_type_Rqj, this.jdField_a_of_type_Int, bool1, oed.b((AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), paramViewBase);
          oek.a().a(4);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     szm
 * JD-Core Version:    0.7.0.1
 */