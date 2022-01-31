package cooperation.qqreader.host.colornote;

import amgn;
import amhc;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class ReaderColorNote
{
  public ColorNote mColorNote;
  
  public ReaderColorNote(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mColorNote = new amhc().d(paramString1).b(paramString2).c(paramString3).a(16908289).a(paramString4).a();
  }
  
  public int getReportType()
  {
    return amgn.a(this.mColorNote.getServiceType());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.host.colornote.ReaderColorNote
 * JD-Core Version:    0.7.0.1
 */