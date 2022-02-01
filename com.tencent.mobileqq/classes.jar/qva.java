import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;

public class qva
{
  public pxk a;
  public qrb a;
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    return qyo.a(paramArticleInfo);
  }
  
  public static boolean a(pxk parampxk)
  {
    return (parampxk.a() == 49) || (parampxk.a() == 62) || (parampxk.a() == 63);
  }
  
  public static boolean b(ArticleInfo paramArticleInfo)
  {
    return qyo.b(paramArticleInfo);
  }
  
  public static boolean b(pxk parampxk)
  {
    return (parampxk.a() == 39) || (parampxk.a() == 116) || (parampxk.a() == 66) || (parampxk.a() == 115) || (parampxk.a() == 122);
  }
  
  public static boolean c(ArticleInfo paramArticleInfo)
  {
    int i = snh.c(paramArticleInfo);
    return (i == 23) || (i == 26) || (i == 56) || (i == 59);
  }
  
  public static boolean c(pxk parampxk)
  {
    switch (parampxk.a())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean d(pxk parampxk)
  {
    return parampxk.c() == 3;
  }
  
  public static boolean e(pxk parampxk)
  {
    return parampxk.a() == 10;
  }
  
  public static boolean f(pxk parampxk)
  {
    return parampxk.a() == 11;
  }
  
  public static boolean g(pxk parampxk)
  {
    return parampxk.a() == 12;
  }
  
  public static boolean h(pxk parampxk)
  {
    return parampxk.a() == 27;
  }
  
  public static boolean i(pxk parampxk)
  {
    return parampxk.a() == 28;
  }
  
  public static boolean j(pxk parampxk)
  {
    return qyo.b(parampxk.a());
  }
  
  public static boolean k(pxk parampxk)
  {
    return qyo.a(parampxk.a());
  }
  
  public int a()
  {
    if ((m()) && ((this.jdField_a_of_type_Pxk.a() instanceof AdvertisementInfo))) {
      return AdvertisementInfo.getBigAppAdStyle((AdvertisementInfo)this.jdField_a_of_type_Pxk.a());
    }
    return 0;
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_Pxk != null) && (this.jdField_a_of_type_Pxk.a() != null) && (this.jdField_a_of_type_Pxk.a().mSocialFeedInfo != null) && (this.jdField_a_of_type_Pxk.a().mSocialFeedInfo.a != null)) {}
    try
    {
      long l = this.jdField_a_of_type_Pxk.a().mSocialFeedInfo.a.a;
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
  
  public pxk a()
  {
    return this.jdField_a_of_type_Pxk;
  }
  
  public void a(pxk parampxk)
  {
    this.jdField_a_of_type_Pxk = parampxk;
  }
  
  public void a(qrb paramqrb)
  {
    this.jdField_a_of_type_Qrb = paramqrb;
  }
  
  public boolean a()
  {
    return d(this.jdField_a_of_type_Pxk);
  }
  
  public boolean b()
  {
    return e(this.jdField_a_of_type_Pxk);
  }
  
  public boolean c()
  {
    return f(this.jdField_a_of_type_Pxk);
  }
  
  public boolean d()
  {
    return g(this.jdField_a_of_type_Pxk);
  }
  
  public boolean e()
  {
    return h(this.jdField_a_of_type_Pxk);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_Pxk.a() == 50) || (this.jdField_a_of_type_Pxk.a() == 51) || (this.jdField_a_of_type_Pxk.a() == 52);
  }
  
  public boolean g()
  {
    return i(this.jdField_a_of_type_Pxk);
  }
  
  public boolean h()
  {
    return a(this.jdField_a_of_type_Pxk);
  }
  
  public boolean i()
  {
    return j(this.jdField_a_of_type_Pxk);
  }
  
  public boolean j()
  {
    return k(this.jdField_a_of_type_Pxk);
  }
  
  public boolean k()
  {
    return c(this.jdField_a_of_type_Pxk);
  }
  
  public boolean l()
  {
    return this.jdField_a_of_type_Pxk.a() == 16;
  }
  
  public boolean m()
  {
    return b(this.jdField_a_of_type_Pxk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qva
 * JD-Core Version:    0.7.0.1
 */