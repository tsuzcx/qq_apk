package cooperation.qqfav;

import android.content.ContentValues;

public final class QfavMergeData
{
  public long a = 1L;
  public Object b = null;
  public String c = "";
  public long d = -1L;
  
  public QfavMergeData(long paramLong1, long paramLong2, ContentValues paramContentValues)
  {
    this.d = paramLong1;
    this.a = paramLong2;
    this.b = paramContentValues;
    try
    {
      this.c = paramContentValues.getAsString("entityNickName");
      return;
    }
    catch (Exception paramContentValues) {}
  }
  
  public QfavMergeData(long paramLong1, long paramLong2, Object paramObject, String paramString)
  {
    this.d = paramLong1;
    this.a = paramLong2;
    this.b = paramObject;
    this.c = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.QfavMergeData
 * JD-Core Version:    0.7.0.1
 */