package com.tencent.mobileqq.flutter.channel.expand;

import androidx.annotation.Nullable;
import io.flutter.plugin.common.MethodChannel.Result;
import java.lang.ref.WeakReference;

public class ExpandBaseChannel$MethodChannelResultWrapper
  implements MethodChannel.Result
{
  private MethodChannel.Result jdField_a_of_type_IoFlutterPluginCommonMethodChannel$Result;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<ExpandBaseChannel> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ExpandBaseChannel$MethodChannelResultWrapper(ExpandBaseChannel paramExpandBaseChannel, String paramString, MethodChannel.Result paramResult)
  {
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel$Result = paramResult;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramExpandBaseChannel);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void error(String paramString1, @Nullable String paramString2, @Nullable Object paramObject)
  {
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel$Result.error(paramString1, paramString2, paramObject);
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      ExpandChannelReportUtil.b(((ExpandBaseChannel)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), this.jdField_a_of_type_JavaLangString, "method");
    }
  }
  
  public void notImplemented()
  {
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel$Result.notImplemented();
  }
  
  public void success(@Nullable Object paramObject)
  {
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel$Result.success(paramObject);
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      ExpandChannelReportUtil.b(((ExpandBaseChannel)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), this.jdField_a_of_type_JavaLangString, "method");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.ExpandBaseChannel.MethodChannelResultWrapper
 * JD-Core Version:    0.7.0.1
 */