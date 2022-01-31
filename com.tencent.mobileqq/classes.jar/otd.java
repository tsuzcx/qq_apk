import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class otd
  implements AladdinConfigHandler
{
  public static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd");
  
  public static int a()
  {
    String[] arrayOfString = ((String)bkbq.a("readinjoy_comment_guide_show_num_one_day", "0_0")).split("_");
    if ((arrayOfString != null) && (arrayOfString.length >= 2) && (a(System.currentTimeMillis()).equals(arrayOfString[0]))) {
      return Integer.valueOf(arrayOfString[1]).intValue();
    }
    return 0;
  }
  
  public static TemplateBean a(VafContext paramVafContext)
  {
    if (paramVafContext == null)
    {
      sfq localsfq = sfq.a("comment_feeds", true);
      paramVafContext = localsfq;
      if (localsfq == null) {
        return null;
      }
    }
    else
    {
      paramVafContext = (sfq)paramVafContext.getTemplateFactory();
    }
    if (paramVafContext != null) {}
    for (;;)
    {
      try
      {
        paramVafContext = paramVafContext.getTemplateBean(a());
        return paramVafContext;
      }
      catch (JSONException paramVafContext)
      {
        QLog.d("CommentGuideConfigHandler", 1, "getTemplateBean ", paramVafContext);
      }
      paramVafContext = null;
    }
    return null;
  }
  
  public static String a()
  {
    String str = (String)bkbq.a("readinjoy_comment_guide_wording", alud.a(2131702566));
    QLog.d("CommentGuideConfigHandler", 1, "wording = " + str);
    return str;
  }
  
  public static String a(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return a.format(localDate);
  }
  
  public static String a(String paramString)
  {
    String str2 = (String)bkbq.a("readinjoy_comment_guide_base_jump_url", "");
    QLog.d("CommentGuideConfigHandler", 1, "jump = " + str2);
    String str1;
    if (TextUtils.isEmpty(str2)) {
      str1 = null;
    }
    String str3;
    do
    {
      do
      {
        return str1;
        str1 = str2;
      } while (TextUtils.isEmpty(paramString));
      str3 = (String)bhsz.a(str2).get("appSchema");
      str1 = str2;
    } while (TextUtils.isEmpty(str3));
    try
    {
      str1 = URLDecoder.decode(str3, "UTF-8");
      paramString = str1 + "&rowkey=" + paramString;
      paramString = bhsz.a(bhsz.a(str2, "appSchema"), "appSchema", paramString);
      QLog.d("CommentGuideConfigHandler", 1, "getJumpUrl : " + paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.d("CommentGuideConfigHandler", 1, "getJumpUrl ", paramString);
    }
    return str2;
  }
  
  public static JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("style_ID", "ReadInJoy_comment_pop_guide");
      localJSONObject.put("guide_image", bkbq.a("readinjoy_comment_guide_image_url", "readinjoy_comment_guide_big_bg"));
      localJSONObject.put("guide_wording", a());
      localJSONObject.put("jump_button_text", alud.a(2131702565));
      localJSONObject.put("dismiss_button_image", "readinjoy_comment_guide_close");
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("CommentGuideConfigHandler", 1, "getGuidePopupWindowData ", localJSONException);
    }
    return localJSONObject;
  }
  
  public static void a(int paramInt)
  {
    String str = a(System.currentTimeMillis());
    bkbq.a("readinjoy_comment_guide_show_num_one_day", str + "_" + paramInt);
  }
  
  public static boolean a()
  {
    if (((Integer)bkbq.a("readinjoy_comment_guide_pic_button_should_show", Integer.valueOf(-1))).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("CommentGuideConfigHandler", 1, "isShow = " + bool);
      return bool;
    }
  }
  
  public static boolean b()
  {
    boolean bool1;
    if (((Integer)bkbq.a("readinjoy_comment_guide_should_show", Integer.valueOf(-1))).intValue() == 1)
    {
      bool1 = true;
      bool2 = bool1;
      if (bool1)
      {
        int i = ((Integer)bkbq.a("readinjoy_comment_guide_max_show_count", Integer.valueOf(3))).intValue();
        int j = a();
        QLog.d("CommentGuideConfigHandler", 1, "count = " + i + "  todayNum : " + j);
        if (j >= i) {
          break label126;
        }
        a(j + 1);
      }
    }
    label126:
    for (boolean bool2 = true;; bool2 = false)
    {
      QLog.d("CommentGuideConfigHandler", 1, "isShow = " + bool2);
      return bool2;
      bool1 = false;
      break;
    }
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("CommentGuideConfigHandler", 1, "[onReceiveConfig] " + paramString);
    paramString = osq.a(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      QLog.d("CommentGuideConfigHandler", 2, "[onReceiveConfig] key=" + str1 + ", value=" + str2);
      if (TextUtils.equals(str1, "should_show")) {
        bkbq.a("readinjoy_comment_guide_should_show", Integer.valueOf(Integer.valueOf(str2).intValue()));
      } else if (TextUtils.equals(str1, "wording")) {
        bkbq.a("readinjoy_comment_guide_wording", str2);
      } else if (TextUtils.equals(str1, "image_url")) {
        bkbq.a("readinjoy_comment_guide_image_url", str2);
      } else if (TextUtils.equals(str1, "base_jump_url")) {
        bkbq.a("readinjoy_comment_guide_base_jump_url", str2);
      } else if (TextUtils.equals(str1, "max_show_count")) {
        bkbq.a("readinjoy_comment_guide_max_show_count", Integer.valueOf(Integer.valueOf(str2).intValue()));
      } else if (TextUtils.equals(str1, "pic_button_should_show")) {
        bkbq.a("readinjoy_comment_guide_pic_button_should_show", Integer.valueOf(Integer.valueOf(str2).intValue()));
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    QLog.d("CommentGuideConfigHandler", 1, "[onWipeConfig]");
    bkbq.a("readinjoy_comment_guide_should_show", Integer.valueOf(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     otd
 * JD-Core Version:    0.7.0.1
 */