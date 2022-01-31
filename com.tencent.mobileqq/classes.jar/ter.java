import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class ter
{
  @vym(a="type")
  public int a;
  @vym(a="linkUrl")
  public String a;
  @vym(a="capture")
  public ten a;
  @vym(a="comp")
  public teo a;
  @vym(a="gameinfo")
  public tep a;
  @vym(a="game")
  public teq a;
  @vym(a="videoShare")
  public tes a;
  @vym(a="parseState")
  public int b;
  @vym(a="title")
  public String b;
  @vym(a="body")
  public String c;
  @vym(a="picUrl")
  public String d;
  @vym(a="app")
  public String e;
  
  @Nullable
  public static ter a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = (ter)JsonORM.a(new JSONObject(paramString), ter.class);
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
  
  public static ter a(String paramString1, String paramString2, String paramString3, @Nullable String paramString4, @Nullable String paramString5)
  {
    ter localter = new ter();
    localter.jdField_a_of_type_JavaLangString = paramString1;
    localter.jdField_b_of_type_JavaLangString = paramString2;
    localter.c = paramString3;
    localter.d = paramString4;
    localter.e = paramString5;
    localter.jdField_a_of_type_Int = 1;
    localter.jdField_b_of_type_Int = 2;
    return localter;
  }
  
  public static ter a(String paramString1, boolean paramBoolean, @Nullable String paramString2, @Nullable String paramString3)
  {
    ter localter = new ter();
    localter.jdField_a_of_type_JavaLangString = paramString1;
    localter.d = paramString2;
    localter.e = paramString3;
    if (paramBoolean) {}
    for (localter.jdField_b_of_type_Int = 0;; localter.jdField_b_of_type_Int = 2)
    {
      localter.jdField_a_of_type_Int = 1;
      return localter;
    }
  }
  
  public String a()
  {
    String str3 = this.jdField_a_of_type_JavaLangString;
    String str2 = str3;
    if (bbff.d.matcher(str3).find())
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
      veg.b("Q.qqstory.tag", "VideoLinkInfo", localJsonParseException);
    }
    return "";
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == 5) && (this.jdField_a_of_type_Tes != null);
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
 * Qualified Name:     ter
 * JD-Core Version:    0.7.0.1
 */