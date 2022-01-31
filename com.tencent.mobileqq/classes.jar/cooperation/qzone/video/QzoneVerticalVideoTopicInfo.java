package cooperation.qzone.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.webkit.URLUtil;
import bhqo;
import bhqp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QzoneVerticalVideoTopicInfo
  implements Parcelable
{
  public static final Parcelable.Creator<QzoneVerticalVideoTopicInfo> CREATOR = new bhqo();
  private String a = QzoneVerticalVideoTopicInfo.class.getSimpleName();
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  
  public QzoneVerticalVideoTopicInfo a(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public String a()
  {
    return this.d;
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.e));
  }
  
  public QzoneVerticalVideoTopicInfo b(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public String b()
  {
    return this.e;
  }
  
  public QzoneVerticalVideoTopicInfo c(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public String c()
  {
    return this.f;
  }
  
  public QzoneVerticalVideoTopicInfo d(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public String d()
  {
    return this.h;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public QzoneVerticalVideoTopicInfo e(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public String e()
  {
    if (!TextUtils.isEmpty(this.i)) {
      return this.i;
    }
    return this.e;
  }
  
  public QzoneVerticalVideoTopicInfo f(String paramString)
  {
    this.i = paramString;
    return this;
  }
  
  public String f()
  {
    bhqp localbhqp = new bhqp(this);
    localbhqp.a("weishi_feedId", this.b).a("weishi_fileId", this.c).a("weishi_musicId", this.d).a("weishi_musicName", this.e).a("weishi_thumbUrl", this.g).a("weishi_topicID", this.h).a("weishi_topicName", this.i);
    return localbhqp.toString();
  }
  
  public String g()
  {
    Object localObject;
    if ((TextUtils.isEmpty(this.g)) || (URLUtil.isHttpUrl(this.g)) || (URLUtil.isHttpsUrl(this.g))) {
      localObject = this.g;
    }
    String str;
    do
    {
      do
      {
        return localObject;
        localObject = Pattern.compile("img:(.*?),").matcher(this.g);
        if (!((Matcher)localObject).find()) {
          break;
        }
        str = ((Matcher)localObject).group().replace("img:", "").replace(",", "");
        localObject = str;
      } while (URLUtil.isHttpUrl(str));
      localObject = str;
    } while (URLUtil.isHttpsUrl(str));
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVerticalVideoTopicInfo
 * JD-Core Version:    0.7.0.1
 */