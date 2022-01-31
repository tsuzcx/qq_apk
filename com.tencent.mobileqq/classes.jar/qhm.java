import com.tencent.device.qfind.QFindBLEScanMgr;

class qhm
  implements Runnable
{
  qhm(qhl paramqhl) {}
  
  public void run()
  {
    if (this.a.a.b)
    {
      QFindBLEScanMgr.a(this.a.a, System.currentTimeMillis());
      QFindBLEScanMgr.a(this.a.a, true);
      return;
    }
    QFindBLEScanMgr.a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qhm
 * JD-Core Version:    0.7.0.1
 */