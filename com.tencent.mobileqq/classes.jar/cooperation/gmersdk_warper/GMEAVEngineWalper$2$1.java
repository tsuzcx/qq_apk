package cooperation.gmersdk_warper;

import com.tencent.qqavopensdk.AVEngineEventHandler;

class GMEAVEngineWalper$2$1
  implements Runnable
{
  GMEAVEngineWalper$2$1(GMEAVEngineWalper.2 param2) {}
  
  public void run()
  {
    boolean bool = GMEAVManager.a(this.a.a.a).a();
    if (this.a.a.b != null) {
      this.a.a.b.a(bool, 0);
    }
    bool = GMEAVManager.a(this.a.a.a).b();
    if (this.a.a.b != null) {
      this.a.a.b.b(bool, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.gmersdk_warper.GMEAVEngineWalper.2.1
 * JD-Core Version:    0.7.0.1
 */