import com.tencent.qphone.base.util.QLog;

class pnt
  extends osm
{
  pnt(pno parampno) {}
  
  public void h(int paramInt)
  {
    boolean bool;
    if (paramInt < 3)
    {
      bool = true;
      QLog.d(pno.a(this.a), 1, "visibility changed, visible :  " + bool);
      if (!bool) {
        break label66;
      }
      pno.c(this.a);
    }
    for (;;)
    {
      if (paramInt == 5) {
        osj.a().b(this);
      }
      return;
      bool = false;
      break;
      label66:
      if (pno.a(this.a) != null) {
        pno.a(this.a).b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pnt
 * JD-Core Version:    0.7.0.1
 */