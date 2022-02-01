import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;

public class rfw
{
  public qfw a;
  public rbx a;
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    return rjl.a(paramArticleInfo);
  }
  
  public static boolean a(qfw paramqfw)
  {
    return (paramqfw.a() == 49) || (paramqfw.a() == 62) || (paramqfw.a() == 63);
  }
  
  public static boolean b(ArticleInfo paramArticleInfo)
  {
    return rjl.b(paramArticleInfo);
  }
  
  public static boolean b(qfw paramqfw)
  {
    return (paramqfw.a() == 39) || (paramqfw.a() == 116) || (paramqfw.a() == 66) || (paramqfw.a() == 115);
  }
  
  public static boolean c(ArticleInfo paramArticleInfo)
  {
    int i = ppe.a(paramArticleInfo);
    return (i == 23) || (i == 26) || (i == 56) || (i == 59);
  }
  
  public static boolean c(qfw paramqfw)
  {
    switch (paramqfw.a())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean d(qfw paramqfw)
  {
    return paramqfw.c() == 3;
  }
  
  public static boolean e(qfw paramqfw)
  {
    return paramqfw.a() == 10;
  }
  
  public static boolean f(qfw paramqfw)
  {
    return paramqfw.a() == 11;
  }
  
  public static boolean g(qfw paramqfw)
  {
    return paramqfw.a() == 12;
  }
  
  public static boolean h(qfw paramqfw)
  {
    return paramqfw.a() == 27;
  }
  
  public static boolean i(qfw paramqfw)
  {
    return paramqfw.a() == 28;
  }
  
  public static boolean j(qfw paramqfw)
  {
    return rjl.b(paramqfw.a());
  }
  
  public static boolean k(qfw paramqfw)
  {
    return rjl.a(paramqfw.a());
  }
  
  public int a()
  {
    if ((m()) && ((this.jdField_a_of_type_Qfw.a() instanceof AdvertisementInfo))) {
      return AdvertisementInfo.getBigAppAdStyle((AdvertisementInfo)this.jdField_a_of_type_Qfw.a());
    }
    return 0;
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_Qfw != null) && (this.jdField_a_of_type_Qfw.a() != null) && (this.jdField_a_of_type_Qfw.a().mSocialFeedInfo != null) && (this.jdField_a_of_type_Qfw.a().mSocialFeedInfo.a != null)) {}
    try
    {
      long l = this.jdField_a_of_type_Qfw.a().mSocialFeedInfo.a.a;
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
  
  public qfw a()
  {
    return this.jdField_a_of_type_Qfw;
  }
  
  public void a(qfw paramqfw)
  {
    this.jdField_a_of_type_Qfw = paramqfw;
  }
  
  public void a(rbx paramrbx)
  {
    this.jdField_a_of_type_Rbx = paramrbx;
  }
  
  public boolean a()
  {
    return d(this.jdField_a_of_type_Qfw);
  }
  
  public boolean b()
  {
    return e(this.jdField_a_of_type_Qfw);
  }
  
  public boolean c()
  {
    return f(this.jdField_a_of_type_Qfw);
  }
  
  public boolean d()
  {
    return g(this.jdField_a_of_type_Qfw);
  }
  
  public boolean e()
  {
    return h(this.jdField_a_of_type_Qfw);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_Qfw.a() == 50) || (this.jdField_a_of_type_Qfw.a() == 51) || (this.jdField_a_of_type_Qfw.a() == 52);
  }
  
  public boolean g()
  {
    return i(this.jdField_a_of_type_Qfw);
  }
  
  public boolean h()
  {
    return a(this.jdField_a_of_type_Qfw);
  }
  
  public boolean i()
  {
    return j(this.jdField_a_of_type_Qfw);
  }
  
  public boolean j()
  {
    return k(this.jdField_a_of_type_Qfw);
  }
  
  public boolean k()
  {
    return c(this.jdField_a_of_type_Qfw);
  }
  
  public boolean l()
  {
    return this.jdField_a_of_type_Qfw.a() == 16;
  }
  
  public boolean m()
  {
    return b(this.jdField_a_of_type_Qfw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rfw
 * JD-Core Version:    0.7.0.1
 */