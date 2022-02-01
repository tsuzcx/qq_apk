import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;

public class qtr
{
  public pvc a;
  public qps a;
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    return qxf.a(paramArticleInfo);
  }
  
  public static boolean a(pvc parampvc)
  {
    return (parampvc.a() == 49) || (parampvc.a() == 62) || (parampvc.a() == 63);
  }
  
  public static boolean b(ArticleInfo paramArticleInfo)
  {
    return qxf.b(paramArticleInfo);
  }
  
  public static boolean b(pvc parampvc)
  {
    return (parampvc.a() == 39) || (parampvc.a() == 116) || (parampvc.a() == 66) || (parampvc.a() == 115) || (parampvc.a() == 122);
  }
  
  public static boolean c(ArticleInfo paramArticleInfo)
  {
    int i = pgb.a(paramArticleInfo);
    return (i == 23) || (i == 26) || (i == 56) || (i == 59);
  }
  
  public static boolean c(pvc parampvc)
  {
    switch (parampvc.a())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean d(pvc parampvc)
  {
    return parampvc.c() == 3;
  }
  
  public static boolean e(pvc parampvc)
  {
    return parampvc.a() == 10;
  }
  
  public static boolean f(pvc parampvc)
  {
    return parampvc.a() == 11;
  }
  
  public static boolean g(pvc parampvc)
  {
    return parampvc.a() == 12;
  }
  
  public static boolean h(pvc parampvc)
  {
    return parampvc.a() == 27;
  }
  
  public static boolean i(pvc parampvc)
  {
    return parampvc.a() == 28;
  }
  
  public static boolean j(pvc parampvc)
  {
    return qxf.b(parampvc.a());
  }
  
  public static boolean k(pvc parampvc)
  {
    return qxf.a(parampvc.a());
  }
  
  public int a()
  {
    if ((m()) && ((this.jdField_a_of_type_Pvc.a() instanceof AdvertisementInfo))) {
      return AdvertisementInfo.getBigAppAdStyle((AdvertisementInfo)this.jdField_a_of_type_Pvc.a());
    }
    return 0;
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_Pvc != null) && (this.jdField_a_of_type_Pvc.a() != null) && (this.jdField_a_of_type_Pvc.a().mSocialFeedInfo != null) && (this.jdField_a_of_type_Pvc.a().mSocialFeedInfo.a != null)) {}
    try
    {
      long l = this.jdField_a_of_type_Pvc.a().mSocialFeedInfo.a.a;
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      return 0L;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public pvc a()
  {
    return this.jdField_a_of_type_Pvc;
  }
  
  public void a(pvc parampvc)
  {
    this.jdField_a_of_type_Pvc = parampvc;
  }
  
  public void a(qps paramqps)
  {
    this.jdField_a_of_type_Qps = paramqps;
  }
  
  public boolean a()
  {
    return d(this.jdField_a_of_type_Pvc);
  }
  
  public boolean b()
  {
    return e(this.jdField_a_of_type_Pvc);
  }
  
  public boolean c()
  {
    return f(this.jdField_a_of_type_Pvc);
  }
  
  public boolean d()
  {
    return g(this.jdField_a_of_type_Pvc);
  }
  
  public boolean e()
  {
    return h(this.jdField_a_of_type_Pvc);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_Pvc.a() == 50) || (this.jdField_a_of_type_Pvc.a() == 51) || (this.jdField_a_of_type_Pvc.a() == 52);
  }
  
  public boolean g()
  {
    return i(this.jdField_a_of_type_Pvc);
  }
  
  public boolean h()
  {
    return a(this.jdField_a_of_type_Pvc);
  }
  
  public boolean i()
  {
    return j(this.jdField_a_of_type_Pvc);
  }
  
  public boolean j()
  {
    return k(this.jdField_a_of_type_Pvc);
  }
  
  public boolean k()
  {
    return c(this.jdField_a_of_type_Pvc);
  }
  
  public boolean l()
  {
    return this.jdField_a_of_type_Pvc.a() == 16;
  }
  
  public boolean m()
  {
    return b(this.jdField_a_of_type_Pvc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qtr
 * JD-Core Version:    0.7.0.1
 */