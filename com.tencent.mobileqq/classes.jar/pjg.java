import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;

public class pjg
{
  public opw a;
  public pfh a;
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    return pmu.a(paramArticleInfo);
  }
  
  public static boolean a(opw paramopw)
  {
    return (paramopw.a() == 49) || (paramopw.a() == 62) || (paramopw.a() == 63);
  }
  
  public static boolean b(ArticleInfo paramArticleInfo)
  {
    return pmu.b(paramArticleInfo);
  }
  
  public static boolean b(opw paramopw)
  {
    return (paramopw.a() == 39) || (paramopw.a() == 116) || (paramopw.a() == 66) || (paramopw.a() == 115) || (paramopw.a() == 122);
  }
  
  public static boolean c(ArticleInfo paramArticleInfo)
  {
    int i = qoe.c(paramArticleInfo);
    return (i == 23) || (i == 26) || (i == 56) || (i == 59);
  }
  
  public static boolean c(opw paramopw)
  {
    switch (paramopw.a())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean d(opw paramopw)
  {
    return paramopw.c() == 3;
  }
  
  public static boolean e(opw paramopw)
  {
    return paramopw.a() == 10;
  }
  
  public static boolean f(opw paramopw)
  {
    return paramopw.a() == 11;
  }
  
  public static boolean g(opw paramopw)
  {
    return paramopw.a() == 12;
  }
  
  public static boolean h(opw paramopw)
  {
    return paramopw.a() == 27;
  }
  
  public static boolean i(opw paramopw)
  {
    return paramopw.a() == 28;
  }
  
  public static boolean j(opw paramopw)
  {
    return pmu.b(paramopw.a());
  }
  
  public static boolean k(opw paramopw)
  {
    return pmu.a(paramopw.a());
  }
  
  public int a()
  {
    if ((m()) && ((this.jdField_a_of_type_Opw.a() instanceof AdvertisementInfo))) {
      return AdvertisementInfo.getBigAppAdStyle((AdvertisementInfo)this.jdField_a_of_type_Opw.a());
    }
    return 0;
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_Opw != null) && (this.jdField_a_of_type_Opw.a() != null) && (this.jdField_a_of_type_Opw.a().mSocialFeedInfo != null) && (this.jdField_a_of_type_Opw.a().mSocialFeedInfo.a != null)) {}
    try
    {
      long l = this.jdField_a_of_type_Opw.a().mSocialFeedInfo.a.a;
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
  
  public opw a()
  {
    return this.jdField_a_of_type_Opw;
  }
  
  public void a(opw paramopw)
  {
    this.jdField_a_of_type_Opw = paramopw;
  }
  
  public void a(pfh parampfh)
  {
    this.jdField_a_of_type_Pfh = parampfh;
  }
  
  public boolean a()
  {
    return d(this.jdField_a_of_type_Opw);
  }
  
  public boolean b()
  {
    return e(this.jdField_a_of_type_Opw);
  }
  
  public boolean c()
  {
    return f(this.jdField_a_of_type_Opw);
  }
  
  public boolean d()
  {
    return g(this.jdField_a_of_type_Opw);
  }
  
  public boolean e()
  {
    return h(this.jdField_a_of_type_Opw);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_Opw.a() == 50) || (this.jdField_a_of_type_Opw.a() == 51) || (this.jdField_a_of_type_Opw.a() == 52);
  }
  
  public boolean g()
  {
    return i(this.jdField_a_of_type_Opw);
  }
  
  public boolean h()
  {
    return a(this.jdField_a_of_type_Opw);
  }
  
  public boolean i()
  {
    return j(this.jdField_a_of_type_Opw);
  }
  
  public boolean j()
  {
    return k(this.jdField_a_of_type_Opw);
  }
  
  public boolean k()
  {
    return c(this.jdField_a_of_type_Opw);
  }
  
  public boolean l()
  {
    return this.jdField_a_of_type_Opw.a() == 16;
  }
  
  public boolean m()
  {
    return b(this.jdField_a_of_type_Opw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pjg
 * JD-Core Version:    0.7.0.1
 */