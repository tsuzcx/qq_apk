package com.tencent.mobileqq.jsp;

import android.app.Activity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

class MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2
  extends Thread
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2(MediaApiPlugin paramMediaApiPlugin, String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString2;
  }
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = MediaApiPlugin.a(this.b, this.jdField_a_of_type_Int);
      if (isInterrupted()) {
        throw new InterruptedException();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      System.gc();
      this.this$0.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "3", "[]" });
      return;
      this.this$0.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "0", localOutOfMemoryError.toString() });
      return;
    }
    catch (IOException localIOException)
    {
      this.this$0.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "2", "[]" });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.MediaApiPlugin.PrepareSinglePictureAndCallbackThreadV2
 * JD-Core Version:    0.7.0.1
 */