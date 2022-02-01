import com.tencent.qphone.base.util.QLog;

class oha
  extends pfh
{
  oha(ogs paramogs) {}
  
  public void a(boolean paramBoolean)
  {
    QLog.i("DailyHeaderViewController", 1, "[onDailyDynamicHeaderDataUpdated] " + paramBoolean);
    if (!paramBoolean)
    {
      if ((ogs.a(this.a) == -1) || (ogs.a(this.a) == 0))
      {
        ogs.a(this.a, 0);
        return;
      }
      ogs.a(this.a, 4);
      return;
    }
    ogs.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oha
 * JD-Core Version:    0.7.0.1
 */