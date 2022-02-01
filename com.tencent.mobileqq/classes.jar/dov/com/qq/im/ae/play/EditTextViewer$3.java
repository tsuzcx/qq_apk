package dov.com.qq.im.ae.play;

import android.util.Log;

class EditTextViewer$3
  implements Runnable
{
  EditTextViewer$3(EditTextViewer paramEditTextViewer) {}
  
  public void run()
  {
    try
    {
      EditTextViewer.a(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Log.e(EditTextViewer.a(), "drawText Error!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.EditTextViewer.3
 * JD-Core Version:    0.7.0.1
 */