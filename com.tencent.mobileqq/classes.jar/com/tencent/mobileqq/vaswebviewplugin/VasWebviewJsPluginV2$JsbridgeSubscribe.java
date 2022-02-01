package com.tencent.mobileqq.vaswebviewplugin;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface VasWebviewJsPluginV2$JsbridgeSubscribe
{
  String args() default "";
  
  String method();
  
  int threadMode() default 0;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPluginV2.JsbridgeSubscribe
 * JD-Core Version:    0.7.0.1
 */