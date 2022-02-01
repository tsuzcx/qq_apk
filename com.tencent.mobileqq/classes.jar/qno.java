import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;

public class qno
{
  public ppu a;
  public qjp a;
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    return qrc.a(paramArticleInfo);
  }
  
  public static boolean a(ppu paramppu)
  {
    return (paramppu.a() == 49) || (paramppu.a() == 62) || (paramppu.a() == 63);
  }
  
  public static boolean b(ArticleInfo paramArticleInfo)
  {
    return qrc.b(paramArticleInfo);
  }
  
  public static boolean b(ppu paramppu)
  {
    return (paramppu.a() == 39) || (paramppu.a() == 116) || (paramppu.a() == 66) || (paramppu.a() == 115) || (paramppu.a() == 122);
  }
  
  public static boolean c(ArticleInfo paramArticleInfo)
  {
    int i = sel.c(paramArticleInfo);
    return (i == 23) || (i == 26) || (i == 56) || (i == 59);
  }
  
  public static boolean c(ppu paramppu)
  {
    switch (paramppu.a())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean d(ppu paramppu)
  {
    return paramppu.c() == 3;
  }
  
  public static boolean e(ppu paramppu)
  {
    return paramppu.a() == 10;
  }
  
  public static boolean f(ppu paramppu)
  {
    return paramppu.a() == 11;
  }
  
  public static boolean g(ppu paramppu)
  {
    return paramppu.a() == 12;
  }
  
  public static boolean h(ppu paramppu)
  {
    return paramppu.a() == 27;
  }
  
  public static boolean i(ppu paramppu)
  {
    return paramppu.a() == 28;
  }
  
  public static boolean j(ppu paramppu)
  {
    return qrc.b(paramppu.a());
  }
  
  public static boolean k(ppu paramppu)
  {
    return qrc.a(paramppu.a());
  }
  
  public int a()
  {
    if ((m()) && ((this.jdField_a_of_type_Ppu.a() instanceof AdvertisementInfo))) {
      return AdvertisementInfo.getBigAppAdStyle((AdvertisementInfo)this.jdField_a_of_type_Ppu.a());
    }
    return 0;
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_Ppu != null) && (this.jdField_a_of_type_Ppu.a() != null) && (this.jdField_a_of_type_Ppu.a().mSocialFeedInfo != null) && (this.jdField_a_of_type_Ppu.a().mSocialFeedInfo.a != null)) {}
    try
    {
      long l = this.jdField_a_of_type_Ppu.a().mSocialFeedInfo.a.a;
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
  
  public ppu a()
  {
    return this.jdField_a_of_type_Ppu;
  }
  
  public void a(ppu paramppu)
  {
    this.jdField_a_of_type_Ppu = paramppu;
  }
  
  public void a(qjp paramqjp)
  {
    this.jdField_a_of_type_Qjp = paramqjp;
  }
  
  public boolean a()
  {
    return d(this.jdField_a_of_type_Ppu);
  }
  
  public boolean b()
  {
    return e(this.jdField_a_of_type_Ppu);
  }
  
  public boolean c()
  {
    return f(this.jdField_a_of_type_Ppu);
  }
  
  public boolean d()
  {
    return g(this.jdField_a_of_type_Ppu);
  }
  
  public boolean e()
  {
    return h(this.jdField_a_of_type_Ppu);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_Ppu.a() == 50) || (this.jdField_a_of_type_Ppu.a() == 51) || (this.jdField_a_of_type_Ppu.a() == 52);
  }
  
  public boolean g()
  {
    return i(this.jdField_a_of_type_Ppu);
  }
  
  public boolean h()
  {
    return a(this.jdField_a_of_type_Ppu);
  }
  
  public boolean i()
  {
    return j(this.jdField_a_of_type_Ppu);
  }
  
  public boolean j()
  {
    return k(this.jdField_a_of_type_Ppu);
  }
  
  public boolean k()
  {
    return c(this.jdField_a_of_type_Ppu);
  }
  
  public boolean l()
  {
    return this.jdField_a_of_type_Ppu.a() == 16;
  }
  
  public boolean m()
  {
    return b(this.jdField_a_of_type_Ppu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qno
 * JD-Core Version:    0.7.0.1
 */