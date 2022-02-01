package com.tencent.mobileqq.olympic.activity;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;

public class ScreenshotObserver
  extends ContentObserver
{
  private static final String jdField_a_of_type_JavaLangString = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "_data", "date_added" };
  private ContentResolver jdField_a_of_type_AndroidContentContentResolver;
  private ScreenshotObserver.Listener jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver$Listener;
  
  public ScreenshotObserver(Handler paramHandler, Context paramContext)
  {
    super(paramHandler);
    this.jdField_a_of_type_AndroidContentContentResolver = paramContext.getContentResolver();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentContentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this);
  }
  
  public void a(ScreenshotObserver.Listener paramListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver$Listener = paramListener;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidContentContentResolver.unregisterContentObserver(this);
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    onChange(paramBoolean, null);
  }
  
  public void onChange(boolean paramBoolean, Uri paramUri)
  {
    Object localObject1;
    Object localObject2;
    long l;
    if (paramUri == null)
    {
      localObject1 = this.jdField_a_of_type_AndroidContentContentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, jdField_a_of_type_ArrayOfJavaLangString, null, null, "date_added DESC");
      if ((localObject1 != null) && (((Cursor)localObject1).moveToFirst()))
      {
        localObject2 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("_data"));
        l = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndex("date_added"));
        if ((Math.abs(System.currentTimeMillis() / 1000L - l) <= 3L) && (((String)localObject2).toLowerCase().contains("screenshot")))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver$Listener;
          if (localObject2 != null) {
            ((ScreenshotObserver.Listener)localObject2).a(paramUri);
          }
        }
      }
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
    }
    else
    {
      localObject1 = paramUri.toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("/\\d+");
      if (((String)localObject1).matches(((StringBuilder)localObject2).toString()))
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContentResolver.query(paramUri, jdField_a_of_type_ArrayOfJavaLangString, null, null, null);
        if ((localObject1 != null) && (((Cursor)localObject1).moveToFirst()))
        {
          localObject2 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("_data"));
          l = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndex("date_added"));
          if ((Math.abs(System.currentTimeMillis() / 1000L - l) <= 3L) && (((String)localObject2).toLowerCase().contains("screenshot")))
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver$Listener;
            if (localObject2 != null) {
              ((ScreenshotObserver.Listener)localObject2).a(paramUri);
            }
          }
        }
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ScreenshotObserver
 * JD-Core Version:    0.7.0.1
 */