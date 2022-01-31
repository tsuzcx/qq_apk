import com.tencent.qphone.base.util.QLog;

class nvx
  extends oxe
{
  nvx(nvp paramnvp) {}
  
  public void a(boolean paramBoolean)
  {
    QLog.i("DailyHeaderViewController", 1, "[onDailyDynamicHeaderDataUpdated] " + paramBoolean);
    if (!paramBoolean)
    {
      if ((nvp.a(this.a) == -1) || (nvp.a(this.a) == 0))
      {
        nvp.a(this.a, 0);
        return;
      }
      nvp.a(this.a, 4);
      return;
    }
    nvp.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nvx
 * JD-Core Version:    0.7.0.1
 */