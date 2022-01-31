import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;

public class qbs
{
  public pgd a;
  public pxt a;
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    return qfg.a(paramArticleInfo);
  }
  
  public static boolean a(pgd parampgd)
  {
    return (parampgd.a() == 49) || (parampgd.a() == 62) || (parampgd.a() == 63);
  }
  
  public static boolean b(ArticleInfo paramArticleInfo)
  {
    return qfg.b(paramArticleInfo);
  }
  
  public static boolean b(pgd parampgd)
  {
    return (parampgd.a() == 39) || (parampgd.a() == 116) || (parampgd.a() == 66) || (parampgd.a() == 115) || (parampgd.a() == 122);
  }
  
  public static boolean c(ArticleInfo paramArticleInfo)
  {
    int i = rqj.c(paramArticleInfo);
    return (i == 23) || (i == 26) || (i == 56) || (i == 59);
  }
  
  public static boolean c(pgd parampgd)
  {
    switch (parampgd.a())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean d(pgd parampgd)
  {
    return parampgd.c() == 3;
  }
  
  public static boolean e(pgd parampgd)
  {
    return parampgd.a() == 10;
  }
  
  public static boolean f(pgd parampgd)
  {
    return parampgd.a() == 11;
  }
  
  public static boolean g(pgd parampgd)
  {
    return parampgd.a() == 12;
  }
  
  public static boolean h(pgd parampgd)
  {
    return parampgd.a() == 27;
  }
  
  public static boolean i(pgd parampgd)
  {
    return parampgd.a() == 28;
  }
  
  public static boolean j(pgd parampgd)
  {
    return qfg.b(parampgd.a());
  }
  
  public static boolean k(pgd parampgd)
  {
    return qfg.a(parampgd.a());
  }
  
  public int a()
  {
    if ((m()) && ((this.jdField_a_of_type_Pgd.a() instanceof AdvertisementInfo))) {
      return AdvertisementInfo.getBigAppAdStyle((AdvertisementInfo)this.jdField_a_of_type_Pgd.a());
    }
    return 0;
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_Pgd != null) && (this.jdField_a_of_type_Pgd.a() != null) && (this.jdField_a_of_type_Pgd.a().mSocialFeedInfo != null) && (this.jdField_a_of_type_Pgd.a().mSocialFeedInfo.a != null)) {}
    try
    {
      long l = this.jdField_a_of_type_Pgd.a().mSocialFeedInfo.a.a;
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
  
  public pgd a()
  {
    return this.jdField_a_of_type_Pgd;
  }
  
  public void a(pgd parampgd)
  {
    this.jdField_a_of_type_Pgd = parampgd;
  }
  
  public void a(pxt parampxt)
  {
    this.jdField_a_of_type_Pxt = parampxt;
  }
  
  public boolean a()
  {
    return d(this.jdField_a_of_type_Pgd);
  }
  
  public boolean b()
  {
    return e(this.jdField_a_of_type_Pgd);
  }
  
  public boolean c()
  {
    return f(this.jdField_a_of_type_Pgd);
  }
  
  public boolean d()
  {
    return g(this.jdField_a_of_type_Pgd);
  }
  
  public boolean e()
  {
    return h(this.jdField_a_of_type_Pgd);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_Pgd.a() == 50) || (this.jdField_a_of_type_Pgd.a() == 51) || (this.jdField_a_of_type_Pgd.a() == 52);
  }
  
  public boolean g()
  {
    return i(this.jdField_a_of_type_Pgd);
  }
  
  public boolean h()
  {
    return a(this.jdField_a_of_type_Pgd);
  }
  
  public boolean i()
  {
    return j(this.jdField_a_of_type_Pgd);
  }
  
  public boolean j()
  {
    return k(this.jdField_a_of_type_Pgd);
  }
  
  public boolean k()
  {
    return c(this.jdField_a_of_type_Pgd);
  }
  
  public boolean l()
  {
    return this.jdField_a_of_type_Pgd.a() == 16;
  }
  
  public boolean m()
  {
    return b(this.jdField_a_of_type_Pgd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qbs
 * JD-Core Version:    0.7.0.1
 */