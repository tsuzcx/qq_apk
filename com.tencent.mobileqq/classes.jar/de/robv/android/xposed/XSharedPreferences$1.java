package de.robv.android.xposed;

class XSharedPreferences$1
  extends Thread
{
  XSharedPreferences$1(XSharedPreferences paramXSharedPreferences, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    synchronized (this.this$0)
    {
      XSharedPreferences.access$000(this.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.XSharedPreferences.1
 * JD-Core Version:    0.7.0.1
 */