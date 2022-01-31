import com.tencent.qphone.base.util.QLog;

class nsk
  extends osm
{
  nsk(nsc paramnsc) {}
  
  public void a(boolean paramBoolean)
  {
    QLog.i("DailyHeaderViewController", 1, "[onDailyDynamicHeaderDataUpdated] " + paramBoolean);
    if (!paramBoolean)
    {
      if ((nsc.a(this.a) == -1) || (nsc.a(this.a) == 0))
      {
        nsc.a(this.a, 0);
        return;
      }
      nsc.a(this.a, 4);
      return;
    }
    nsc.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsk
 * JD-Core Version:    0.7.0.1
 */