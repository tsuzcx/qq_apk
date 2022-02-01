import com.tencent.qphone.base.util.QLog;

class oqj
  extends pvq
{
  oqj(oqb paramoqb) {}
  
  public void a(boolean paramBoolean)
  {
    QLog.i("DailyHeaderViewController", 1, "[onDailyDynamicHeaderDataUpdated] " + paramBoolean);
    if (!paramBoolean)
    {
      if ((oqb.a(this.a) == -1) || (oqb.a(this.a) == 0))
      {
        oqb.a(this.a, 0);
        return;
      }
      oqb.a(this.a, 4);
      return;
    }
    oqb.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqj
 * JD-Core Version:    0.7.0.1
 */