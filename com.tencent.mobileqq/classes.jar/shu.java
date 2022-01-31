import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

final class shu
  implements ViewBase.OnClickListener
{
  shu(ArticleInfo paramArticleInfo, Activity paramActivity, rap paramrap, int paramInt1, int paramInt2, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool2 = false;
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    sht.a(this.jdField_a_of_type_AndroidAppActivity, localAdvertisementInfo, this.jdField_a_of_type_Rap, this.jdField_a_of_type_Int);
    int j = this.b;
    int i = j;
    if (j == 6) {
      if ((this.jdField_a_of_type_Rap != null) && (this.jdField_a_of_type_Rap.a() != null))
      {
        i = j;
        if (this.jdField_a_of_type_Rap.a().b()) {}
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
        oau.a(localAdvertisementInfo, i, null);
        paramViewBase = null;
        if (this.jdField_a_of_type_Rap != null) {
          paramViewBase = this.jdField_a_of_type_Rap.a();
        }
        if ((oau.h((AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && ((this.b == 4) || (this.b == 3) || (this.b == 1)))
        {
          if (this.b == 1) {
            i = 3;
          }
          oau.a(this.jdField_a_of_type_AndroidAppActivity, 1);
          sht.a(this.jdField_a_of_type_AndroidAppActivity);
          sht.a(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
          nmf.a(new nyg().a(this.jdField_a_of_type_AndroidAppActivity).a(nmf.jdField_a_of_type_Int).b(nmf.ai).a((AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).d(i).a());
        }
        while (sht.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, paramViewBase, localAdvertisementInfo)) {
          return;
        }
        boolean bool1 = bool2;
        if (this.b != 6)
        {
          bool1 = bool2;
          if (this.b != 5) {
            if ((this.jdField_a_of_type_Rap != null) && ((this.jdField_a_of_type_Int == 0) || (oox.b(this.jdField_a_of_type_Int))))
            {
              paramViewBase = this.jdField_a_of_type_Rap;
              bool1 = bool2;
              if (rap.a(localAdvertisementInfo, this.jdField_a_of_type_Int) != 104)
              {
                paramViewBase = this.jdField_a_of_type_Rap;
                bool1 = bool2;
                if (rap.a(localAdvertisementInfo, this.jdField_a_of_type_Int) == 105) {}
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
          paramViewBase = new nyc();
          if (this.b == 8) {
            paramViewBase.c = true;
          }
          if (sht.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Rap, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
            break;
          }
          sht.a(this.jdField_a_of_type_AndroidAppActivity, localAdvertisementInfo, this.jdField_a_of_type_Rap, this.jdField_a_of_type_Int, bool1, oat.b((AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), paramViewBase);
          oaw.a().a(4);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     shu
 * JD-Core Version:    0.7.0.1
 */