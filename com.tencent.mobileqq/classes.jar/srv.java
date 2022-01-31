import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class srv
{
  @vlq(a="type")
  public int a;
  @vlq(a="linkUrl")
  public String a;
  @vlq(a="capture")
  public srr a;
  @vlq(a="comp")
  public srs a;
  @vlq(a="gameinfo")
  public srt a;
  @vlq(a="game")
  public sru a;
  @vlq(a="videoShare")
  public srw a;
  @vlq(a="parseState")
  public int b;
  @vlq(a="title")
  public String b;
  @vlq(a="body")
  public String c;
  @vlq(a="picUrl")
  public String d;
  @vlq(a="app")
  public String e;
  
  @Nullable
  public static srv a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = (srv)JsonORM.a(new JSONObject(paramString), srv.class);
      return paramString;
    }
    catch (JsonORM.JsonParseException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static srv a(String paramString1, String paramString2, String paramString3, @Nullable String paramString4, @Nullable String paramString5)
  {
    srv localsrv = new srv();
    localsrv.jdField_a_of_type_JavaLangString = paramString1;
    localsrv.jdField_b_of_type_JavaLangString = paramString2;
    localsrv.c = paramString3;
    localsrv.d = paramString4;
    localsrv.e = paramString5;
    localsrv.jdField_a_of_type_Int = 1;
    localsrv.jdField_b_of_type_Int = 2;
    return localsrv;
  }
  
  public static srv a(String paramString1, boolean paramBoolean, @Nullable String paramString2, @Nullable String paramString3)
  {
    srv localsrv = new srv();
    localsrv.jdField_a_of_type_JavaLangString = paramString1;
    localsrv.d = paramString2;
    localsrv.e = paramString3;
    if (paramBoolean) {}
    for (localsrv.jdField_b_of_type_Int = 0;; localsrv.jdField_b_of_type_Int = 2)
    {
      localsrv.jdField_a_of_type_Int = 1;
      return localsrv;
    }
  }
  
  public String a()
  {
    String str3 = this.jdField_a_of_type_JavaLangString;
    String str2 = str3;
    if (baea.d.matcher(str3).find())
    {
      String str1 = null;
      int i = str3.lastIndexOf("#");
      if (i > 0) {
        str1 = str3.substring(i);
      }
      str3 = URLUtil.guessUrl(str3);
      str2 = str3;
      if (str1 != null) {
        return str3 + str1;
      }
    }
    return str2;
  }
  
  public String a(boolean paramBoolean)
  {
    try
    {
      Object localObject = JsonORM.a(this);
      if (paramBoolean) {
        ((JSONObject)localObject).remove("parseState");
      }
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JsonORM.JsonParseException localJsonParseException)
    {
      urk.b("Q.qqstory.tag", "VideoLinkInfo", localJsonParseException);
    }
    return "";
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == 5) && (this.jdField_a_of_type_Srw != null);
  }
  
  public String b()
  {
    String str1;
    String str2;
    label30:
    String str3;
    if (this.jdField_b_of_type_JavaLangString != null)
    {
      str1 = this.jdField_b_of_type_JavaLangString.trim();
      if (this.c == null) {
        break label57;
      }
      str2 = this.c.trim();
      if ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(str2))) {
        break label63;
      }
      str3 = this.jdField_a_of_type_JavaLangString;
    }
    label57:
    label63:
    do
    {
      return str3;
      str1 = "";
      break;
      str2 = "";
      break label30;
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        return String.format("%s-%s", new Object[] { str1, str2 });
      }
      str3 = str1;
    } while (!TextUtils.isEmpty(str1));
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     srv
 * JD-Core Version:    0.7.0.1
 */