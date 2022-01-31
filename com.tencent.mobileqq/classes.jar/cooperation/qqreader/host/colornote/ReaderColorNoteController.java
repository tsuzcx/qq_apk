package cooperation.qqreader.host.colornote;

import alrv;
import android.content.Context;
import android.content.ContextWrapper;
import bfnf;

public class ReaderColorNoteController
{
  private alrv a;
  
  public ReaderColorNoteController(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = new alrv(paramContext, paramBoolean1, paramBoolean2);
  }
  
  public void attachToActivity(ContextWrapper paramContextWrapper)
  {
    paramContextWrapper = bfnf.a(paramContextWrapper);
    if (paramContextWrapper != null) {
      this.a.a(paramContextWrapper);
    }
  }
  
  public boolean canAddColorNote()
  {
    return this.a.b();
  }
  
  public void deleteColorNote()
  {
    this.a.f();
  }
  
  public void exitAnimation()
  {
    this.a.d();
  }
  
  public void insertColorNote()
  {
    this.a.e();
  }
  
  public boolean isColorNoteExist()
  {
    return this.a.c();
  }
  
  public void onCannotAdd()
  {
    this.a.i();
  }
  
  public void onDestroy()
  {
    this.a.c();
  }
  
  public void onPause()
  {
    this.a.b();
  }
  
  public void onResume()
  {
    if (this.a.a()) {
      this.a.a();
    }
  }
  
  public void setColorNoteAnimFinishCallback(OnColorNoteAnimFinishCallback paramOnColorNoteAnimFinishCallback)
  {
    this.a.a(new ReaderColorNoteController.1(this, paramOnColorNoteAnimFinishCallback));
  }
  
  public void setReaderServiceInfo(IReaderServiceInfo paramIReaderServiceInfo)
  {
    this.a.a(new ReaderColorNoteController.2(this, paramIReaderServiceInfo));
  }
  
  public boolean shouldDisplayColorNote()
  {
    return this.a.a();
  }
  
  public void updateColorNote(ReaderColorNote paramReaderColorNote)
  {
    this.a.a(paramReaderColorNote.mColorNote);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.host.colornote.ReaderColorNoteController
 * JD-Core Version:    0.7.0.1
 */