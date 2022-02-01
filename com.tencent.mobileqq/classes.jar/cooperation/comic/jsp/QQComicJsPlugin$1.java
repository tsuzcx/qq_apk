package cooperation.comic.jsp;

import android.text.TextUtils;

class QQComicJsPlugin$1
  implements QQComicJsCallback
{
  QQComicJsPlugin$1(QQComicJsPlugin paramQQComicJsPlugin) {}
  
  public void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      QQComicJsPlugin.a(this.a, paramString1, new String[] { paramString2 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.jsp.QQComicJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */