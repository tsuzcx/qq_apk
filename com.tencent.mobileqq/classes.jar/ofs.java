import com.tencent.qphone.base.util.QLog;

class ofs
  extends pmn
{
  ofs(ofk paramofk) {}
  
  public void a(boolean paramBoolean)
  {
    QLog.i("DailyHeaderViewController", 1, "[onDailyDynamicHeaderDataUpdated] " + paramBoolean);
    if (!paramBoolean)
    {
      if ((ofk.a(this.a) == -1) || (ofk.a(this.a) == 0))
      {
        ofk.a(this.a, 0);
        return;
      }
      ofk.a(this.a, 4);
      return;
    }
    ofk.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ofs
 * JD-Core Version:    0.7.0.1
 */