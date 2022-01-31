import com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.KandianAppInPush;

class mpj
  implements Runnable
{
  mpj(mpi parammpi) {}
  
  public void run()
  {
    Kandian210Msg0xeeInfo localKandian210Msg0xeeInfo = KandianAppInPush.a(this.a.a);
    KandianAppInPush.b(this.a.a, null);
    this.a.a.a(localKandian210Msg0xeeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mpj
 * JD-Core Version:    0.7.0.1
 */