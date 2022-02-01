package com.tencent.mobileqq.kandian.biz.pts.component;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.pts.UtilsForComponent;
import com.tencent.mobileqq.qroute.QRoute;

public class CmpCtxt
{
  public FeedItemCell.CellListener a;
  public IReadInJoyModel a;
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return UtilsForComponent.a(paramAbsBaseArticleInfo);
  }
  
  public static boolean a(IReadInJoyModel paramIReadInJoyModel)
  {
    return (paramIReadInJoyModel.d() == 49) || (paramIReadInJoyModel.d() == 62) || (paramIReadInJoyModel.d() == 63);
  }
  
  public static boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return UtilsForComponent.b(paramAbsBaseArticleInfo);
  }
  
  public static boolean b(IReadInJoyModel paramIReadInJoyModel)
  {
    return (paramIReadInJoyModel.d() == 39) || (paramIReadInJoyModel.d() == 116) || (paramIReadInJoyModel.d() == 66) || (paramIReadInJoyModel.d() == 115);
  }
  
  public static boolean c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    int i = RIJBaseItemViewType.a(paramAbsBaseArticleInfo);
    return (i == 23) || (i == 26) || (i == 56) || (i == 59);
  }
  
  public static boolean c(IReadInJoyModel paramIReadInJoyModel)
  {
    switch (paramIReadInJoyModel.d())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean d(IReadInJoyModel paramIReadInJoyModel)
  {
    return paramIReadInJoyModel.a() == 3;
  }
  
  public static boolean e(IReadInJoyModel paramIReadInJoyModel)
  {
    return paramIReadInJoyModel.d() == 10;
  }
  
  public static boolean f(IReadInJoyModel paramIReadInJoyModel)
  {
    return paramIReadInJoyModel.d() == 11;
  }
  
  public static boolean g(IReadInJoyModel paramIReadInJoyModel)
  {
    return paramIReadInJoyModel.d() == 12;
  }
  
  public static boolean h(IReadInJoyModel paramIReadInJoyModel)
  {
    return paramIReadInJoyModel.d() == 27;
  }
  
  public static boolean i(IReadInJoyModel paramIReadInJoyModel)
  {
    return paramIReadInJoyModel.d() == 28;
  }
  
  public static boolean j(IReadInJoyModel paramIReadInJoyModel)
  {
    return RIJItemViewTypeUtils.c(paramIReadInJoyModel.d());
  }
  
  public static boolean k(IReadInJoyModel paramIReadInJoyModel)
  {
    return UtilsForComponent.a(paramIReadInJoyModel.d());
  }
  
  public int a()
  {
    if ((m()) && ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a() instanceof AdvertisementInfo))) {
      return ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBigAppAdStyle((AdvertisementInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a());
    }
    return 0;
  }
  
  public long a()
  {
    IReadInJoyModel localIReadInJoyModel = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
    if ((localIReadInJoyModel != null) && (localIReadInJoyModel.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mSocialFeedInfo.a != null)) {
      try
      {
        long l = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mSocialFeedInfo.a.a;
        return l;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    return 0L;
  }
  
  public IReadInJoyModel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener = paramCellListener;
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel = paramIReadInJoyModel;
  }
  
  public boolean a()
  {
    return d(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel);
  }
  
  public boolean b()
  {
    return e(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel);
  }
  
  public boolean c()
  {
    return f(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel);
  }
  
  public boolean d()
  {
    return g(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel);
  }
  
  public boolean e()
  {
    return h(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.d() == 50) || (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.d() == 51) || (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.d() == 52);
  }
  
  public boolean g()
  {
    return i(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel);
  }
  
  public boolean h()
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel);
  }
  
  public boolean i()
  {
    return j(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel);
  }
  
  public boolean j()
  {
    return k(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel);
  }
  
  public boolean k()
  {
    return c(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel);
  }
  
  public boolean l()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.d() == 16;
  }
  
  public boolean m()
  {
    return b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.CmpCtxt
 * JD-Core Version:    0.7.0.1
 */