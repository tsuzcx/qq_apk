import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.3;
import com.tencent.qphone.base.util.QLog;

public class ppp
  extends ppr
{
  public ppp(PTSJSCLoader.3 param3) {}
  
  public void loaded(String paramString, int paramInt)
  {
    super.loaded(paramString, paramInt);
    QLog.i("PTSJSCLoader", 1, "[updatePTSJSC], asyncBack code = " + paramInt + ", param = " + paramString);
    if ((paramInt == 0) && (paramString == null))
    {
      QLog.i("PTSJSCLoader", 1, "[updatePTSJSC], handleDownloadPTSJSC, download succeed.");
      ppo.b(this.a.this$0);
    }
  }
  
  public void progress(int paramInt)
  {
    super.progress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ppp
 * JD-Core Version:    0.7.0.1
 */