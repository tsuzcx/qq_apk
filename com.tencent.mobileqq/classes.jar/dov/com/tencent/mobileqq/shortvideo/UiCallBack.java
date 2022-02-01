package dov.com.tencent.mobileqq.shortvideo;

import java.util.ArrayList;

public abstract interface UiCallBack
{
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, ShortVideoResult paramShortVideoResult);
  
  public abstract void a(int paramInt, ArrayList<ShortVideoResult> paramArrayList);
  
  public abstract void a(String[] paramArrayOfString, String paramString);
  
  public abstract void b(int paramInt, ShortVideoResult paramShortVideoResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.UiCallBack
 * JD-Core Version:    0.7.0.1
 */