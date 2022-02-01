import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import org.jetbrains.annotations.NotNull;

public class ram
  implements rae
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c = 20000;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    RIJRedPacketManager.a().a(paramString, paramInt1, paramInt2, null);
  }
  
  public boolean a()
  {
    return RIJRedPacketManager.a().d();
  }
  
  public boolean a(@NotNull String paramString)
  {
    boolean bool = b(paramString);
    if ((!bool) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      RIJRedPacketManager.a().a(paramString, new ran(this, paramString));
    }
    return bool;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public String b()
  {
    return RIJRedPacketManager.a().b();
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void b(String paramString)
  {
    RIJRedPacketManager.a().a(paramString);
  }
  
  public boolean b(String paramString)
  {
    return RIJRedPacketManager.a().a(paramString);
  }
  
  public int c()
  {
    return RIJRedPacketManager.a().i();
  }
  
  public void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  public int d()
  {
    return h() / c();
  }
  
  public void d(int paramInt)
  {
    RIJRedPacketManager.a().a(paramInt);
  }
  
  public int e()
  {
    return this.c;
  }
  
  public int f()
  {
    return RIJRedPacketManager.a().f();
  }
  
  public int g()
  {
    return RIJRedPacketManager.a().a();
  }
  
  public int h()
  {
    return RIJRedPacketManager.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ram
 * JD-Core Version:    0.7.0.1
 */