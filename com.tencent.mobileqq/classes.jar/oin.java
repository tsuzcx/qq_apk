import com.tencent.qphone.base.util.QLog;

class oin
  extends pkt
{
  oin(oif paramoif) {}
  
  public void a(boolean paramBoolean)
  {
    QLog.i("DailyHeaderViewController", 1, "[onDailyDynamicHeaderDataUpdated] " + paramBoolean);
    if (!paramBoolean)
    {
      if ((oif.a(this.a) == -1) || (oif.a(this.a) == 0))
      {
        oif.a(this.a, 0);
        return;
      }
      oif.a(this.a, 4);
      return;
    }
    oif.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oin
 * JD-Core Version:    0.7.0.1
 */