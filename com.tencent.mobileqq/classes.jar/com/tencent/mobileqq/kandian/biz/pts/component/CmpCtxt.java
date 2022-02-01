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
  public IReadInJoyModel a;
  public FeedItemCell.CellListener b;
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return UtilsForComponent.a(paramAbsBaseArticleInfo);
  }
  
  public static boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return UtilsForComponent.b(paramAbsBaseArticleInfo);
  }
  
  public static boolean b(IReadInJoyModel paramIReadInJoyModel)
  {
    return (paramIReadInJoyModel.o() == 49) || (paramIReadInJoyModel.o() == 62) || (paramIReadInJoyModel.o() == 63);
  }
  
  public static boolean c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    int i = RIJBaseItemViewType.c(paramAbsBaseArticleInfo);
    return (i == 23) || (i == 26) || (i == 56) || (i == 59);
  }
  
  public static boolean c(IReadInJoyModel paramIReadInJoyModel)
  {
    return (paramIReadInJoyModel.o() == 39) || (paramIReadInJoyModel.o() == 116) || (paramIReadInJoyModel.o() == 66) || (paramIReadInJoyModel.o() == 115);
  }
  
  public static boolean d(IReadInJoyModel paramIReadInJoyModel)
  {
    switch (paramIReadInJoyModel.o())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean e(IReadInJoyModel paramIReadInJoyModel)
  {
    return paramIReadInJoyModel.b() == 3;
  }
  
  public static boolean f(IReadInJoyModel paramIReadInJoyModel)
  {
    return paramIReadInJoyModel.o() == 10;
  }
  
  public static boolean g(IReadInJoyModel paramIReadInJoyModel)
  {
    return paramIReadInJoyModel.o() == 11;
  }
  
  public static boolean h(IReadInJoyModel paramIReadInJoyModel)
  {
    return paramIReadInJoyModel.o() == 12;
  }
  
  public static boolean i(IReadInJoyModel paramIReadInJoyModel)
  {
    return paramIReadInJoyModel.o() == 27;
  }
  
  public static boolean j(IReadInJoyModel paramIReadInJoyModel)
  {
    return paramIReadInJoyModel.o() == 28;
  }
  
  public static boolean k(IReadInJoyModel paramIReadInJoyModel)
  {
    return RIJItemViewTypeUtils.c(paramIReadInJoyModel.o());
  }
  
  public static boolean l(IReadInJoyModel paramIReadInJoyModel)
  {
    return UtilsForComponent.b(paramIReadInJoyModel.o());
  }
  
  public IReadInJoyModel a()
  {
    return this.a;
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.b = paramCellListener;
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.a = paramIReadInJoyModel;
  }
  
  public boolean b()
  {
    return e(this.a);
  }
  
  public boolean c()
  {
    return f(this.a);
  }
  
  public boolean d()
  {
    return g(this.a);
  }
  
  public boolean e()
  {
    return h(this.a);
  }
  
  public boolean f()
  {
    return i(this.a);
  }
  
  public boolean g()
  {
    return (this.a.o() == 50) || (this.a.o() == 51) || (this.a.o() == 52);
  }
  
  public boolean h()
  {
    return j(this.a);
  }
  
  public boolean i()
  {
    return b(this.a);
  }
  
  public boolean j()
  {
    return k(this.a);
  }
  
  public boolean k()
  {
    return l(this.a);
  }
  
  public boolean l()
  {
    return d(this.a);
  }
  
  public boolean m()
  {
    return this.a.o() == 16;
  }
  
  public boolean n()
  {
    return c(this.a);
  }
  
  public long o()
  {
    IReadInJoyModel localIReadInJoyModel = this.a;
    if ((localIReadInJoyModel != null) && (localIReadInJoyModel.k() != null) && (this.a.k().mSocialFeedInfo != null) && (this.a.k().mSocialFeedInfo.s != null)) {
      try
      {
        long l = this.a.k().mSocialFeedInfo.s.e;
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
  
  public int p()
  {
    if ((n()) && ((this.a.k() instanceof AdvertisementInfo))) {
      return ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBigAppAdStyle((AdvertisementInfo)this.a.k());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.CmpCtxt
 * JD-Core Version:    0.7.0.1
 */