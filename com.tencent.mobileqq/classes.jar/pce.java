import com.tencent.qphone.base.util.QLog;

class pce
  extends ohe
{
  pce(pbz parampbz) {}
  
  public void h(int paramInt)
  {
    boolean bool;
    if (paramInt < 3)
    {
      bool = true;
      QLog.d(pbz.a(this.a), 1, "visibility changed, visible :  " + bool);
      if (!bool) {
        break label66;
      }
      pbz.c(this.a);
    }
    for (;;)
    {
      if (paramInt == 5) {
        ohb.a().b(this);
      }
      return;
      bool = false;
      break;
      label66:
      if (pbz.a(this.a) != null) {
        pbz.a(this.a).b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pce
 * JD-Core Version:    0.7.0.1
 */