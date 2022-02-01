package cooperation.qqfav.widget;

import android.content.Context;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.Builder;
import com.tencent.qphone.base.util.QLog;

public class LocationColorNoteServiceInfo
  implements IServiceInfo
{
  private Long a;
  private Context b;
  
  public LocationColorNoteServiceInfo(Context paramContext, Long paramLong)
  {
    this.a = paramLong;
    this.b = paramContext;
  }
  
  public ColorNote getColorNote()
  {
    ColorNote.Builder localBuilder = new ColorNote.Builder();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getColorNote: colorNote key [");
      ((StringBuilder)localObject).append("qfav");
      ((StringBuilder)localObject).append("]");
      QLog.i("FavColorNoteServiceInfo", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b.getString(2131886213);
    String str = this.b.getString(2131889171);
    localBuilder.a(17104896);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.a);
    localStringBuilder.append("-4");
    localBuilder.a(localStringBuilder.toString());
    localBuilder.b((String)localObject);
    localBuilder.c(str);
    localBuilder.d("resdrawable://2130845544");
    return localBuilder.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.widget.LocationColorNoteServiceInfo
 * JD-Core Version:    0.7.0.1
 */