import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ImageData;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class qyc
  implements qxs
{
  public static String a(String paramString, ImageData paramImageData)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramImageData.a)) {}
    while (!((Boolean)bgmq.a("sp_native_web_sharpp_pic_switch", Boolean.valueOf(false))).booleanValue()) {
      return paramString;
    }
    if (paramString.contains("fmt=gif"))
    {
      paramImageData.a = false;
      return paramString;
    }
    paramImageData = befm.a(paramString);
    if (paramImageData.containsKey("tp"))
    {
      paramImageData = (String)paramImageData.get("tp");
      paramString = paramString.replace("tp=" + paramImageData, "tp=sharp");
    }
    for (;;)
    {
      QLog.d(oph.a, 2, "sharpSupport, url : " + paramString);
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
  
  public qxr a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    return new qyd(LayoutInflater.from(paramContext).inflate(2131494350, null), paramBaseData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.p == 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qyc
 * JD-Core Version:    0.7.0.1
 */