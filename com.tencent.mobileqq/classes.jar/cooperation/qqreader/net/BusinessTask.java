package cooperation.qqreader.net;

import android.support.annotation.NonNull;
import com.tencent.util.Pair;
import java.util.HashMap;

public class BusinessTask
  extends BaseCgiTask
{
  private Pair<Integer, Integer> a;
  private String d;
  
  public BusinessTask(String paramString)
  {
    this.d = paramString;
  }
  
  public BusinessTask(String paramString, @NonNull Pair<Integer, Integer> paramPair)
  {
    this.d = paramString;
    this.a = paramPair;
  }
  
  protected BaseCgiTask.RequestType a()
  {
    return BaseCgiTask.RequestType.GET;
  }
  
  protected String a()
  {
    if ("GetEnterShelfOnOffTask".equals(this.d)) {
      return "https://app.books.qq.com/webapp/json/reader_webapp_config/GetEnterShelfOnOff";
    }
    if ("QueryUserGrayUpdateStateTask".equals(this.d)) {
      return "https://app.books.qq.com/webapp/json/reader_webapp_update/IsUserGrayRelease";
    }
    if ("UpdateToQQBookstoreTask".equals(this.d)) {
      return "https://app.books.qq.com/webapp/json/reader_webapp_update/UpdateToQQBookstore";
    }
    if ("ZzConfigDataTask".equals(this.d)) {
      return "https://app.books.qq.com/webapp/meteor?flag1=" + this.a.first + "&flag2=" + this.a.second;
    }
    if ("ReaderShadowGray".endsWith(this.d)) {
      return "https://app.books.qq.com/webapp/meteor_is_gray_user?flag1=" + this.a.first + "&flag2=" + this.a.second;
    }
    return null;
  }
  
  protected HashMap<String, String> a()
  {
    return b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.net.BusinessTask
 * JD-Core Version:    0.7.0.1
 */