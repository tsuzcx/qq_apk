import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;

public class puy
{
  public pau a;
  public pqy a;
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    return pym.a(paramArticleInfo);
  }
  
  public static boolean a(pau parampau)
  {
    return (parampau.a() == 49) || (parampau.a() == 62) || (parampau.a() == 63);
  }
  
  public static boolean b(ArticleInfo paramArticleInfo)
  {
    return pym.b(paramArticleInfo);
  }
  
  public static boolean b(pau parampau)
  {
    return (parampau.a() == 39) || (parampau.a() == 116) || (parampau.a() == 66) || (parampau.a() == 115) || (parampau.a() == 122);
  }
  
  public static boolean c(ArticleInfo paramArticleInfo)
  {
    int i = ram.c(paramArticleInfo);
    return (i == 23) || (i == 26) || (i == 56) || (i == 59);
  }
  
  public static boolean c(pau parampau)
  {
    switch (parampau.a())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean d(pau parampau)
  {
    return parampau.c() == 3;
  }
  
  public static boolean e(pau parampau)
  {
    return parampau.a() == 10;
  }
  
  public static boolean f(pau parampau)
  {
    return parampau.a() == 11;
  }
  
  public static boolean g(pau parampau)
  {
    return parampau.a() == 12;
  }
  
  public static boolean h(pau parampau)
  {
    return parampau.a() == 27;
  }
  
  public static boolean i(pau parampau)
  {
    return parampau.a() == 28;
  }
  
  public static boolean j(pau parampau)
  {
    return pym.b(parampau.a());
  }
  
  public static boolean k(pau parampau)
  {
    return pym.a(parampau.a());
  }
  
  public int a()
  {
    if ((m()) && ((this.jdField_a_of_type_Pau.a() instanceof AdvertisementInfo))) {
      return AdvertisementInfo.getBigAppAdStyle((AdvertisementInfo)this.jdField_a_of_type_Pau.a());
    }
    return 0;
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_Pau != null) && (this.jdField_a_of_type_Pau.a() != null) && (this.jdField_a_of_type_Pau.a().mSocialFeedInfo != null) && (this.jdField_a_of_type_Pau.a().mSocialFeedInfo.a != null)) {}
    try
    {
      long l = this.jdField_a_of_type_Pau.a().mSocialFeedInfo.a.a;
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
  
  public pau a()
  {
    return this.jdField_a_of_type_Pau;
  }
  
  public void a(pau parampau)
  {
    this.jdField_a_of_type_Pau = parampau;
  }
  
  public void a(pqy parampqy)
  {
    this.jdField_a_of_type_Pqy = parampqy;
  }
  
  public boolean a()
  {
    return d(this.jdField_a_of_type_Pau);
  }
  
  public boolean b()
  {
    return e(this.jdField_a_of_type_Pau);
  }
  
  public boolean c()
  {
    return f(this.jdField_a_of_type_Pau);
  }
  
  public boolean d()
  {
    return g(this.jdField_a_of_type_Pau);
  }
  
  public boolean e()
  {
    return h(this.jdField_a_of_type_Pau);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_Pau.a() == 50) || (this.jdField_a_of_type_Pau.a() == 51) || (this.jdField_a_of_type_Pau.a() == 52);
  }
  
  public boolean g()
  {
    return i(this.jdField_a_of_type_Pau);
  }
  
  public boolean h()
  {
    return a(this.jdField_a_of_type_Pau);
  }
  
  public boolean i()
  {
    return j(this.jdField_a_of_type_Pau);
  }
  
  public boolean j()
  {
    return k(this.jdField_a_of_type_Pau);
  }
  
  public boolean k()
  {
    return c(this.jdField_a_of_type_Pau);
  }
  
  public boolean l()
  {
    return this.jdField_a_of_type_Pau.a() == 16;
  }
  
  public boolean m()
  {
    return b(this.jdField_a_of_type_Pau);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     puy
 * JD-Core Version:    0.7.0.1
 */