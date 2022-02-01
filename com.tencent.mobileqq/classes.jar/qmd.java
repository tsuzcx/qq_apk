import com.tencent.qphone.base.util.QLog;

class qmd
  extends pmn
{
  qmd(qly paramqly) {}
  
  public void h(int paramInt)
  {
    boolean bool;
    if (paramInt < 3)
    {
      bool = true;
      QLog.d("RvPolymericContainer", 1, "visibility changed, visible :  " + bool);
      if (!bool) {
        break label61;
      }
      qly.c(this.a);
    }
    for (;;)
    {
      if (paramInt == 5) {
        pmk.a().b(this);
      }
      return;
      bool = false;
      break;
      label61:
      if (qly.a(this.a) != null) {
        qly.a(this.a).b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qmd
 * JD-Core Version:    0.7.0.1
 */