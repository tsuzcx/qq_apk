import com.tencent.common.app.AppInterface;

class sue
  implements suh
{
  protected aysb a;
  
  private sue(stz paramstz)
  {
    this.jdField_a_of_type_Aysb = new sug(this);
  }
  
  protected aysa a()
  {
    AppInterface localAppInterface = bjav.a();
    if (localAppInterface != null) {
      return localAppInterface.getNetEngine(0);
    }
    return null;
  }
  
  public void a(sui paramsui)
  {
    paramsui.jdField_d_of_type_Int = 0;
    ayrx localayrx = new ayrx();
    localayrx.jdField_a_of_type_JavaLangString = paramsui.jdField_d_of_type_JavaLangString;
    localayrx.jdField_a_of_type_Int = 0;
    localayrx.jdField_c_of_type_JavaLangString = paramsui.e;
    localayrx.jdField_d_of_type_JavaLangString = paramsui.f;
    localayrx.e = paramsui.g;
    localayrx.jdField_c_of_type_Int = 3;
    localayrx.a(paramsui);
    localayrx.jdField_a_of_type_Aysb = this.jdField_a_of_type_Aysb;
    paramsui.a = localayrx;
    localayrx.jdField_a_of_type_Aysc = new suf(this);
    aysa localaysa = a();
    if (localaysa != null) {
      localaysa.a(localayrx);
    }
    ved.a("AsyncFileDownloader", "start download with base downloader, task = %s", paramsui);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(sui paramsui)
  {
    ayrx localayrx = paramsui.a;
    if (localayrx != null)
    {
      if (a() != null) {
        a().b(localayrx);
      }
      ved.b("AsyncFileDownloader", String.format("cancel task with base downloader, task = %s", new Object[] { paramsui }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sue
 * JD-Core Version:    0.7.0.1
 */