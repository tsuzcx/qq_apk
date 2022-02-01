import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSAppLoader.2;
import com.tencent.qphone.base.util.QLog;

public class qyz
  extends qzf
{
  public qyz(PTSAppLoader.2 param2) {}
  
  public void loaded(String paramString, int paramInt)
  {
    super.loaded(paramString, paramInt);
    QLog.i("PTSAppLoader", 1, "[updatePTSApp], asyncBack code = " + paramInt + ", param = " + paramString);
    if ((paramInt == 0) && (paramString == null))
    {
      qyy.b(this.a.this$0, this.a.a);
      QLog.i("PTSAppLoader", 1, "[updatePTSApp], download succeed, bid = " + this.a.a);
    }
  }
  
  public void progress(int paramInt)
  {
    super.progress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qyz
 * JD-Core Version:    0.7.0.1
 */