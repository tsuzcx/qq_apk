package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class CommentGuideConfigHandler
  extends SimpleConfigHandler
{
  public static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd");
  
  public static String a(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return a.format(localDate);
  }
  
  public static String a(String paramString)
  {
    String str = (String)RIJSPUtils.b("readinjoy_comment_guide_base_jump_url", "");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("jump = ");
    ((StringBuilder)localObject).append(str);
    QLog.d("CommentGuideConfigHandler", 1, ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = (String)URLUtil.a(str).get("appSchema");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = URLDecoder.decode((String)localObject, "UTF-8");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("&rowkey=");
          localStringBuilder.append(paramString);
          paramString = localStringBuilder.toString();
          paramString = URLUtil.a(URLUtil.a(str, "appSchema"), "appSchema", paramString);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getJumpUrl : ");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("CommentGuideConfigHandler", 1, ((StringBuilder)localObject).toString());
          return paramString;
        }
        catch (Exception paramString)
        {
          QLog.d("CommentGuideConfigHandler", 1, "getJumpUrl ", paramString);
        }
      }
    }
    return str;
  }
  
  public static void a(int paramInt)
  {
    String str = a(System.currentTimeMillis());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    RIJSPUtils.a("readinjoy_comment_guide_show_num_one_day", localStringBuilder.toString());
  }
  
  public static boolean a()
  {
    boolean bool;
    if (((Integer)RIJSPUtils.b("readinjoy_comment_guide_pic_button_should_show", Integer.valueOf(-1))).intValue() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isShow = ");
    localStringBuilder.append(bool);
    QLog.d("CommentGuideConfigHandler", 1, localStringBuilder.toString());
    return bool;
  }
  
  public static boolean b()
  {
    boolean bool1;
    if (((Integer)RIJSPUtils.b("readinjoy_comment_guide_should_show", Integer.valueOf(-1))).intValue() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (bool1)
    {
      int i = ((Integer)RIJSPUtils.b("readinjoy_comment_guide_max_show_count", Integer.valueOf(3))).intValue();
      int j = c();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("count = ");
      localStringBuilder.append(i);
      localStringBuilder.append("  todayNum : ");
      localStringBuilder.append(j);
      QLog.d("CommentGuideConfigHandler", 1, localStringBuilder.toString());
      if (j < i)
      {
        a(j + 1);
        bool2 = true;
      }
      else
      {
        bool2 = false;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isShow = ");
    localStringBuilder.append(bool2);
    QLog.d("CommentGuideConfigHandler", 1, localStringBuilder.toString());
    return bool2;
  }
  
  public static int c()
  {
    String[] arrayOfString = ((String)RIJSPUtils.b("readinjoy_comment_guide_show_num_one_day", "0_0")).split("_");
    if ((arrayOfString != null) && (arrayOfString.length >= 2) && (a(System.currentTimeMillis()).equals(arrayOfString[0]))) {
      return Integer.valueOf(arrayOfString[1]).intValue();
    }
    return 0;
  }
  
  public static String d()
  {
    String str = (String)RIJSPUtils.b("readinjoy_comment_guide_wording", HardCodeUtil.a(2131900372));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wording = ");
    localStringBuilder.append(str);
    QLog.d("CommentGuideConfigHandler", 1, localStringBuilder.toString());
    return str;
  }
  
  public static JSONObject e()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("style_ID", "ReadInJoy_comment_pop_guide");
      localJSONObject.put("guide_image", RIJSPUtils.b("readinjoy_comment_guide_image_url", "readinjoy_comment_guide_big_bg"));
      localJSONObject.put("guide_wording", d());
      localJSONObject.put("jump_button_text", HardCodeUtil.a(2131900371));
      localJSONObject.put("dismiss_button_image", "readinjoy_comment_guide_close");
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("CommentGuideConfigHandler", 1, "getGuidePopupWindowData ", localJSONException);
    }
    return localJSONObject;
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onReceiveConfig] ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("CommentGuideConfigHandler", 1, ((StringBuilder)localObject).toString());
    paramString = AladdinParseUtils.a(paramString);
    localObject = paramString.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = (String)paramString.get(str1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onReceiveConfig] key=");
      localStringBuilder.append(str1);
      localStringBuilder.append(", value=");
      localStringBuilder.append(str2);
      QLog.d("CommentGuideConfigHandler", 2, localStringBuilder.toString());
      if (TextUtils.equals(str1, "should_show")) {
        RIJSPUtils.a("readinjoy_comment_guide_should_show", Integer.valueOf(Integer.valueOf(str2).intValue()));
      } else if (TextUtils.equals(str1, "wording")) {
        RIJSPUtils.a("readinjoy_comment_guide_wording", str2);
      } else if (TextUtils.equals(str1, "image_url")) {
        RIJSPUtils.a("readinjoy_comment_guide_image_url", str2);
      } else if (TextUtils.equals(str1, "base_jump_url")) {
        RIJSPUtils.a("readinjoy_comment_guide_base_jump_url", str2);
      } else if (TextUtils.equals(str1, "max_show_count")) {
        RIJSPUtils.a("readinjoy_comment_guide_max_show_count", Integer.valueOf(Integer.valueOf(str2).intValue()));
      } else if (TextUtils.equals(str1, "pic_button_should_show")) {
        RIJSPUtils.a("readinjoy_comment_guide_pic_button_should_show", Integer.valueOf(Integer.valueOf(str2).intValue()));
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    QLog.d("CommentGuideConfigHandler", 1, "[onWipeConfig]");
    RIJSPUtils.a("readinjoy_comment_guide_should_show", Integer.valueOf(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.CommentGuideConfigHandler
 * JD-Core Version:    0.7.0.1
 */