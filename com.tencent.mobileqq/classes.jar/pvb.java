import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;

public class pvb
{
  public pax a;
  public prb a;
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    return pyp.a(paramArticleInfo);
  }
  
  public static boolean a(pax parampax)
  {
    return (parampax.a() == 49) || (parampax.a() == 62) || (parampax.a() == 63);
  }
  
  public static boolean b(ArticleInfo paramArticleInfo)
  {
    return pyp.b(paramArticleInfo);
  }
  
  public static boolean b(pax parampax)
  {
    return (parampax.a() == 39) || (parampax.a() == 116) || (parampax.a() == 66) || (parampax.a() == 115) || (parampax.a() == 122);
  }
  
  public static boolean c(ArticleInfo paramArticleInfo)
  {
    int i = rap.c(paramArticleInfo);
    return (i == 23) || (i == 26) || (i == 56) || (i == 59);
  }
  
  public static boolean c(pax parampax)
  {
    switch (parampax.a())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean d(pax parampax)
  {
    return parampax.c() == 3;
  }
  
  public static boolean e(pax parampax)
  {
    return parampax.a() == 10;
  }
  
  public static boolean f(pax parampax)
  {
    return parampax.a() == 11;
  }
  
  public static boolean g(pax parampax)
  {
    return parampax.a() == 12;
  }
  
  public static boolean h(pax parampax)
  {
    return parampax.a() == 27;
  }
  
  public static boolean i(pax parampax)
  {
    return parampax.a() == 28;
  }
  
  public static boolean j(pax parampax)
  {
    return pyp.b(parampax.a());
  }
  
  public static boolean k(pax parampax)
  {
    return pyp.a(parampax.a());
  }
  
  public int a()
  {
    if ((m()) && ((this.jdField_a_of_type_Pax.a() instanceof AdvertisementInfo))) {
      return AdvertisementInfo.getBigAppAdStyle((AdvertisementInfo)this.jdField_a_of_type_Pax.a());
    }
    return 0;
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_Pax != null) && (this.jdField_a_of_type_Pax.a() != null) && (this.jdField_a_of_type_Pax.a().mSocialFeedInfo != null) && (this.jdField_a_of_type_Pax.a().mSocialFeedInfo.a != null)) {}
    try
    {
      long l = this.jdField_a_of_type_Pax.a().mSocialFeedInfo.a.a;
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
  
  public pax a()
  {
    return this.jdField_a_of_type_Pax;
  }
  
  public void a(pax parampax)
  {
    this.jdField_a_of_type_Pax = parampax;
  }
  
  public void a(prb paramprb)
  {
    this.jdField_a_of_type_Prb = paramprb;
  }
  
  public boolean a()
  {
    return d(this.jdField_a_of_type_Pax);
  }
  
  public boolean b()
  {
    return e(this.jdField_a_of_type_Pax);
  }
  
  public boolean c()
  {
    return f(this.jdField_a_of_type_Pax);
  }
  
  public boolean d()
  {
    return g(this.jdField_a_of_type_Pax);
  }
  
  public boolean e()
  {
    return h(this.jdField_a_of_type_Pax);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_Pax.a() == 50) || (this.jdField_a_of_type_Pax.a() == 51) || (this.jdField_a_of_type_Pax.a() == 52);
  }
  
  public boolean g()
  {
    return i(this.jdField_a_of_type_Pax);
  }
  
  public boolean h()
  {
    return a(this.jdField_a_of_type_Pax);
  }
  
  public boolean i()
  {
    return j(this.jdField_a_of_type_Pax);
  }
  
  public boolean j()
  {
    return k(this.jdField_a_of_type_Pax);
  }
  
  public boolean k()
  {
    return c(this.jdField_a_of_type_Pax);
  }
  
  public boolean l()
  {
    return this.jdField_a_of_type_Pax.a() == 16;
  }
  
  public boolean m()
  {
    return b(this.jdField_a_of_type_Pax);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pvb
 * JD-Core Version:    0.7.0.1
 */