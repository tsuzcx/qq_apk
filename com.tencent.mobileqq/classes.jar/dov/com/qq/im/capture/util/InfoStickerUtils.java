package dov.com.qq.im.capture.util;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class InfoStickerUtils
{
  private static final String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131705788);
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { HardCodeUtil.a(2131705796), HardCodeUtil.a(2131705789), HardCodeUtil.a(2131705795), HardCodeUtil.a(2131705794), HardCodeUtil.a(2131705793), HardCodeUtil.a(2131705797), HardCodeUtil.a(2131705791) };
  private static final String b = HardCodeUtil.a(2131705799);
  
  public static String a()
  {
    long l = System.currentTimeMillis();
    return new SimpleDateFormat("MM/dd").format(new Date(l));
  }
  
  public static String a(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("yyyy MMMM dd", Locale.US).format(new Date(paramLong)).toUpperCase();
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String[] a(long paramLong)
  {
    Object localObject;
    String[] arrayOfString;
    if (paramLong != -1L)
    {
      localObject = Calendar.getInstance();
      ((Calendar)localObject).setTime(new Date(paramLong));
      LunarSolarConverter.Solar localSolar = new LunarSolarConverter.Solar();
      localSolar.c = ((Calendar)localObject).get(1);
      localSolar.b = (((Calendar)localObject).get(2) + 1);
      localSolar.jdField_a_of_type_Int = ((Calendar)localObject).get(5);
      localObject = LunarSolarConverter.a(localSolar);
      arrayOfString = new String[4];
      arrayOfString[0] = new String(LunarSolarConverter.a(localSolar.c));
      if (!((LunarSolarConverter.Lunar)localObject).jdField_a_of_type_Boolean) {
        break label210;
      }
      arrayOfString[1] = new String(HardCodeUtil.a(2131705798) + LunarSolarConverter.b(((LunarSolarConverter.Lunar)localObject).b));
    }
    for (;;)
    {
      arrayOfString[2] = new String(String.valueOf(LunarSolarConverter.c(((LunarSolarConverter.Lunar)localObject).jdField_a_of_type_Int).charAt(0)));
      arrayOfString[3] = new String(String.valueOf(LunarSolarConverter.c(((LunarSolarConverter.Lunar)localObject).jdField_a_of_type_Int).charAt(1)));
      if (QLog.isColorLevel()) {
        QLog.d("InfoStickerUtils", 2, arrayOfString);
      }
      return arrayOfString;
      paramLong = System.currentTimeMillis();
      break;
      label210:
      arrayOfString[1] = new String(LunarSolarConverter.b(((LunarSolarConverter.Lunar)localObject).b));
    }
  }
  
  public static String b(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("HH:mm").format(new Date(paramLong));
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String c(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("dd").format(new Date(paramLong));
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String d(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("MMM", Locale.US).format(new Date(paramLong)).toUpperCase();
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String e(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("yyyy").format(new Date(paramLong));
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String f(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("MMM dd HH:mm", Locale.US).format(new Date(paramLong)).toUpperCase();
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String g(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yy MM dd", Locale.US);
      Date localDate = new Date(paramLong);
      return "'" + localSimpleDateFormat.format(localDate).toUpperCase();
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String h(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("HHmm").format(new Date(paramLong));
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String i(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("HHmm").format(new Date(paramLong - 60000L));
      paramLong = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.util.InfoStickerUtils
 * JD-Core Version:    0.7.0.1
 */