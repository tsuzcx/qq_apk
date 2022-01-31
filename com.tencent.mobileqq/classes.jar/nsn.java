import com.tencent.qphone.base.util.QLog;

class nsn
  extends osp
{
  nsn(nsf paramnsf) {}
  
  public void a(boolean paramBoolean)
  {
    QLog.i("DailyHeaderViewController", 1, "[onDailyDynamicHeaderDataUpdated] " + paramBoolean);
    if (!paramBoolean)
    {
      if ((nsf.a(this.a) == -1) || (nsf.a(this.a) == 0))
      {
        nsf.a(this.a, 0);
        return;
      }
      nsf.a(this.a, 4);
      return;
    }
    nsf.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsn
 * JD-Core Version:    0.7.0.1
 */