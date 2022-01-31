package com.tencent.mobileqq.jsp;

import android.app.Activity;
import bcdb;
import bcpq;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

class MediaApiPlugin$PrepareSinglePictureAndCallbackThread
  extends Thread
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  int c;
  int d;
  
  public MediaApiPlugin$PrepareSinglePictureAndCallbackThread(MediaApiPlugin paramMediaApiPlugin, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = MediaApiPlugin.a(this.jdField_b_of_type_JavaLangString, this.c, this.d, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      if (isInterrupted()) {
        throw new InterruptedException();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      System.gc();
      this.this$0.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "3", "{}" });
      return;
      this.this$0.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "0", localOutOfMemoryError.toString() });
      return;
    }
    catch (IOException localIOException)
    {
      this.this$0.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "2", "{}" });
      return;
    }
    catch (JSONException localJSONException)
    {
      this.this$0.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "2", "{}" });
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Activity localActivity = this.this$0.mRuntime.a();
      if ((localActivity != null) && (!localActivity.isFinishing())) {
        this.this$0.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "1", "{}" });
      }
      return;
    }
    finally
    {
      if ((this.this$0.a != null) && (this.this$0.a.isShowing())) {
        this.this$0.a.dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.MediaApiPlugin.PrepareSinglePictureAndCallbackThread
 * JD-Core Version:    0.7.0.1
 */