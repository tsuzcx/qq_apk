package com.tencent.mobileqq.multimsg.save;

import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class FileSaveErrorInfo
{
  public static HashMap<Integer, String> a = new HashMap();
  
  static
  {
    a.put(Integer.valueOf(10001), BaseApplication.getContext().getString(2131915870));
    a.put(Integer.valueOf(10002), BaseApplication.getContext().getString(2131915868));
    a.put(Integer.valueOf(10003), BaseApplication.getContext().getString(2131916755));
    a.put(Integer.valueOf(10004), BaseApplication.getContext().getString(2131888242));
    a.put(Integer.valueOf(10005), BaseApplication.getContext().getString(2131915865));
    a.put(Integer.valueOf(10006), BaseApplication.getContext().getString(2131915882));
    a.put(Integer.valueOf(10007), BaseApplication.getContext().getString(2131915869));
  }
  
  public static String a(int paramInt)
  {
    return (String)a.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.FileSaveErrorInfo
 * JD-Core Version:    0.7.0.1
 */