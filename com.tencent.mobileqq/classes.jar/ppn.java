import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.3;
import com.tencent.qphone.base.util.QLog;

public class ppn
  extends ppr
{
  public ppn(PTSEngineLoader.3 param3) {}
  
  public void loaded(String paramString, int paramInt)
  {
    super.loaded(paramString, paramInt);
    QLog.i("PTSEngineLoader", 1, "[updatePTSEngine], asyncBack code = " + paramInt + ", param = " + paramString);
    if ((paramInt == 0) && (paramString == null))
    {
      QLog.i("PTSEngineLoader", 1, "[updatePTSEngine], handleDownloadPTSEngine, download succeed.");
      ppm.c(this.a.this$0);
    }
  }
  
  public void progress(int paramInt)
  {
    super.progress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ppn
 * JD-Core Version:    0.7.0.1
 */