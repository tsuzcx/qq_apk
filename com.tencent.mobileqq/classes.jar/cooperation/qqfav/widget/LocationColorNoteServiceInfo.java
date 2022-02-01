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
    if (QLog.isColorLevel()) {
      QLog.i("FavColorNoteServiceInfo", 2, "getColorNote: colorNote key [" + "qfav" + "]");
    }
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689571);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692258);
    localBuilder.a(17104896);
    localBuilder.a("" + this.jdField_a_of_type_JavaLangLong + "-4");
    localBuilder.b(str1);
    localBuilder.c(str2);
    localBuilder.d("resdrawable://2130844321");
    return localBuilder.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqfav.widget.LocationColorNoteServiceInfo
 * JD-Core Version:    0.7.0.1
 */