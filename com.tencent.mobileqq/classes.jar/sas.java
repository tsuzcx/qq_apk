import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ImageData;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class sas
  implements sai
{
  public static String a(String paramString, ImageData paramImageData)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramImageData.a)) {}
    while (!((Boolean)bjxj.a("sp_native_web_sharpp_pic_switch", Boolean.valueOf(false))).booleanValue()) {
      return paramString;
    }
    if (paramString.contains("fmt=gif"))
    {
      paramImageData.a = false;
      return paramString;
    }
    paramImageData = bhos.a(paramString);
    if (paramImageData.containsKey("tp"))
    {
      paramImageData = (String)paramImageData.get("tp");
      paramString = paramString.replace("tp=" + paramImageData, "tp=sharp");
    }
    for (;;)
    {
      QLog.d(pfo.a, 2, "sharpSupport, url : " + paramString);
      return paramString;
      if (paramImageData.size() > 0) {
        paramString = paramString + "&tp=sharp";
      } else {
        paramString = paramString + "?tp=sharp";
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.contains("tp=sharp");
  }
  
  public int a(BaseData paramBaseData)
  {
    return 1;
  }
  
  public sah a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    return new sat(LayoutInflater.from(paramContext).inflate(2131560019, null), paramBaseData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.s == 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sas
 * JD-Core Version:    0.7.0.1
 */