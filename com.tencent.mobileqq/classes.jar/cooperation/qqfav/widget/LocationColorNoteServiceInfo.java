package cooperation.qqfav.widget;

import android.content.Context;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.Builder;
import com.tencent.qphone.base.util.QLog;

public class LocationColorNoteServiceInfo
  implements IServiceInfo
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Long jdField_a_of_type_JavaLangLong;
  
  public LocationColorNoteServiceInfo(Context paramContext, Long paramLong)
  {
    this.jdField_a_of_type_JavaLangLong = paramLong;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
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
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131689603);
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131692184);
    localBuilder.a(17104896);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangLong);
    localStringBuilder.append("-4");
    localBuilder.a(localStringBuilder.toString());
    localBuilder.b((String)localObject);
    localBuilder.c(str);
    localBuilder.d("resdrawable://2130844227");
    return localBuilder.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.widget.LocationColorNoteServiceInfo
 * JD-Core Version:    0.7.0.1
 */