import com.tencent.common.app.AppInterface;

class shl
  implements sho
{
  protected axrs a;
  
  private shl(shg paramshg)
  {
    this.jdField_a_of_type_Axrs = new shn(this);
  }
  
  protected axrr a()
  {
    AppInterface localAppInterface = bhfm.a();
    if (localAppInterface != null) {
      return localAppInterface.getNetEngine(0);
    }
    return null;
  }
  
  public void a(shp paramshp)
  {
    paramshp.jdField_d_of_type_Int = 0;
    axro localaxro = new axro();
    localaxro.jdField_a_of_type_JavaLangString = paramshp.jdField_d_of_type_JavaLangString;
    localaxro.jdField_a_of_type_Int = 0;
    localaxro.jdField_c_of_type_JavaLangString = paramshp.e;
    localaxro.jdField_d_of_type_JavaLangString = paramshp.f;
    localaxro.e = paramshp.g;
    localaxro.jdField_c_of_type_Int = 3;
    localaxro.a(paramshp);
    localaxro.jdField_a_of_type_Axrs = this.jdField_a_of_type_Axrs;
    paramshp.a = localaxro;
    localaxro.jdField_a_of_type_Axrt = new shm(this);
    axrr localaxrr = a();
    if (localaxrr != null) {
      localaxrr.a(localaxro);
    }
    urk.a("AsyncFileDownloader", "start download with base downloader, task = %s", paramshp);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(shp paramshp)
  {
    axro localaxro = paramshp.a;
    if (localaxro != null)
    {
      if (a() != null) {
        a().b(localaxro);
      }
      urk.b("AsyncFileDownloader", String.format("cancel task with base downloader, task = %s", new Object[] { paramshp }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     shl
 * JD-Core Version:    0.7.0.1
 */