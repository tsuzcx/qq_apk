package com.tencent.mobileqq.jsp;

import android.app.Activity;
import becq;
import bepp;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;

class MediaApiPlugin$PreparePicturesAndCallbackThreadV2
  extends Thread
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public MediaApiPlugin$PreparePicturesAndCallbackThreadV2(MediaApiPlugin paramMediaApiPlugin, String paramString, int paramInt, String[] paramArrayOfString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
  
  public void run()
  {
    int i = 0;
    try
    {
      JSONArray localJSONArray = new JSONArray();
      int j = this.jdField_a_of_type_ArrayOfJavaLangString.length;
      if (i < j) {
        if (isInterrupted()) {
          throw new InterruptedException();
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        System.gc();
        this.this$0.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "3", "[]" });
        return;
        localOutOfMemoryError.put(MediaApiPlugin.a(this.jdField_a_of_type_ArrayOfJavaLangString[i], this.jdField_a_of_type_Int));
        i += 1;
      }
      if (isInterrupted()) {
        throw new InterruptedException();
      }
    }
    catch (IOException localIOException)
    {
      this.this$0.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "2", "[]" });
      return;
      this.this$0.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "0", localIOException.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      this.this$0.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "2", "[]" });
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Activity localActivity = this.this$0.mRuntime.a();
      if ((localActivity != null) && (!localActivity.isFinishing())) {
        this.this$0.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "1", "[]" });
      }
      return;
    }
    finally
    {
      if (this.this$0.a.isShowing()) {
        this.this$0.a.dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.MediaApiPlugin.PreparePicturesAndCallbackThreadV2
 * JD-Core Version:    0.7.0.1
 */