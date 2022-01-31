import com.tencent.common.app.AppInterface;

class suh
  implements suk
{
  protected ayrz a;
  
  private suh(suc paramsuc)
  {
    this.jdField_a_of_type_Ayrz = new suj(this);
  }
  
  protected ayry a()
  {
    AppInterface localAppInterface = bjae.a();
    if (localAppInterface != null) {
      return localAppInterface.getNetEngine(0);
    }
    return null;
  }
  
  public void a(sul paramsul)
  {
    paramsul.jdField_d_of_type_Int = 0;
    ayrv localayrv = new ayrv();
    localayrv.jdField_a_of_type_JavaLangString = paramsul.jdField_d_of_type_JavaLangString;
    localayrv.jdField_a_of_type_Int = 0;
    localayrv.jdField_c_of_type_JavaLangString = paramsul.e;
    localayrv.jdField_d_of_type_JavaLangString = paramsul.f;
    localayrv.e = paramsul.g;
    localayrv.jdField_c_of_type_Int = 3;
    localayrv.a(paramsul);
    localayrv.jdField_a_of_type_Ayrz = this.jdField_a_of_type_Ayrz;
    paramsul.a = localayrv;
    localayrv.jdField_a_of_type_Aysa = new sui(this);
    ayry localayry = a();
    if (localayry != null) {
      localayry.a(localayrv);
    }
    veg.a("AsyncFileDownloader", "start download with base downloader, task = %s", paramsul);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(sul paramsul)
  {
    ayrv localayrv = paramsul.a;
    if (localayrv != null)
    {
      if (a() != null) {
        a().b(localayrv);
      }
      veg.b("AsyncFileDownloader", String.format("cancel task with base downloader, task = %s", new Object[] { paramsul }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     suh
 * JD-Core Version:    0.7.0.1
 */