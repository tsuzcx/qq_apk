import com.tencent.qphone.base.util.QLog;

class nhd
  extends ohe
{
  nhd(ngv paramngv) {}
  
  public void a(boolean paramBoolean)
  {
    QLog.i("DailyHeaderViewController", 1, "[onDailyDynamicHeaderDataUpdated] " + paramBoolean);
    if (!paramBoolean)
    {
      if ((ngv.a(this.a) == -1) || (ngv.a(this.a) == 0))
      {
        ngv.a(this.a, 0);
        return;
      }
      ngv.a(this.a, 4);
      return;
    }
    ngv.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhd
 * JD-Core Version:    0.7.0.1
 */